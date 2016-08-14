package org.python.util.case_study;

import java.io.File;
import java.util.Properties;
import java.util.Set;
import java.util.HashSet;

import org.python.core.PyException;
import org.python.core.PySystemState;
import org.python.core.imp;
import org.python.modules._py_compile; 

import jrapl.EnergyCheckUtils;

modes {low <: mid; mid <: high; }

public class CompileTask {
  private boolean tadapt;

  public CompileTask() {
    String tadaptstr = System.getenv("PANDA_TADAPT");
    if (tadaptstr != null && tadaptstr.equals("true")) {
      this.tadapt = true;
    } else {
      this.tadapt = false;
    }
  }

  public void process(Set<File> toCompile) {
    Properties props = new Properties();
    props.setProperty(PySystemState.PYTHON_CACHEDIR_SKIP, "true");
    PySystemState.initialize(System.getProperties(), props); 

    for (File src : toCompile) {
      String name = _py_compile.getModuleName(src);
      String compiledFilePath = name.replace('.', '/');
      if (src.getName().endsWith("__init__.py")) {
        compiledFilePath += "/__init__";
      }
      File compiled = new File("./", compiledFilePath + "$py.class");
      compile(src, compiled, name);
    }
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      throw new RuntimeException("Must supplied arguments!");
    }

    Set<File> toCompile = new HashSet<File>();

    for (int i = 0; i < args.length; i++) {
      String fileName = args[i];
      if (!fileName.endsWith(".py")) {
        throw new RuntimeException("Invalid py file " + fileName); 
      }
      toCompile.add(new File(args[i]));
    }

    ENT_Util.initModeFile();
    //#ENT_Util.startStopwatch();
    for (int k = 0; k < 10; k++) {

      double[] before = EnergyCheckUtils.getEnergyStats();

      // Do several runs to bench
      for (int i = 0; i < 100; i++) {
        CompileTask task = new CompileTask();
        task.process(toCompile);
      }

      double[] after = EnergyCheckUtils.getEnergyStats();
      //ENT_Util.stopStopwatch();

      ENT_Util.writeModeFile(String.format("ERun %d: %f %f %f\n", k, after[0]-before[0], after[1]-before[1], after[2]-before[2]));
      //ENT_Util.writeModeFile(String.format("Time: %s\n", ENT_Util.elapsedTime()));

    }
	  ENT_Util.closeModeFile();
    EnergyCheckUtils.DeallocProfile();
  }

  protected void compile(File src, File compiled, String moduleName) {
    byte[] bytes;
    try {
      bytes = imp.compileSource(moduleName, src);
    } catch (PyException pye) {
      pye.printStackTrace();
      throw new RuntimeException("Compile failed; see the compiler error output for details.");
    }

    TemperatureContext@mode<*> tempContext = 
      snapshot (new TemperatureContext@mode<?>(this.tadapt)) ?mode[@mode<low>,@mode<high>];
    tempContext.sleep();
    tempContext = null;
    /*
    try {
      float temp = ENT_Util.Temperature.getTempC();
      if (temp >= 65.0) {
        Thread.sleep(1000);
      } else if (temp >= 60.0) {
        Thread.sleep(250);
      } else {
      }
    } catch (Exception e) {
    }
    */


    File dir = compiled.getParentFile();
    if (!dir.exists() && !compiled.getParentFile().mkdirs()) {
      throw new RuntimeException("Unable to make directory for compiled file: " + compiled);
    }
    imp.cacheCompiledSource(src.getAbsolutePath(), compiled.getAbsolutePath(), bytes);
  }

  protected String getFrom() {
    return "*.py";
  }

  protected String getTo() {
    return "*$py.class";
  }

}

