package tadapt_custom;

import java.io.*;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import jrapl.EnergyCheckUtils;

modes {low <: mid; mid <: high; } 

public class XalanBench {
  private boolean tadapt;

  public XalanBench() {
    String tadaptstr = System.getenv("PANDA_TADAPT");
    if (tadaptstr != null && tadaptstr.equals("true")) {
      this.tadapt = true;
    } else {
      this.tadapt = false;
    }
  }

  public void execute() {
    try {
    ENT_Util.initModeFile();

    Properties props = System.getProperties();
    String key = "javax.xml.transform.TransformerFactory";
    String value = "org.apache.xalan.processor.TransformerFactoryImpl";
    props.put(key,value);
    System.setProperties(props);

    Source stylesheet = new StreamSource(new File("xalan/xmlspec.xsl"));
    TransformerFactory factory = TransformerFactory.newInstance();
    Templates template = factory.newTemplates(stylesheet);

    String[] names = new String[]{
      "xalan/acks.xml", 
      "xalan/binding.xml", 
      "xalan/changes.xml", 
      "xalan/concepts.xml", 
      "xalan/controls.xml", 
      "xalan/datatypes.xml", 
      "xalan/expr.xml", 
      "xalan/intro.xml", 
      "xalan/model.xml", 
      "xalan/prod-notes.xml", 
      "xalan/references.xml", 
      "xalan/rpm.xml", 
      "xalan/schema.xml", 
      "xalan/structure.xml", 
      "xalan/template.xml", 
      "xalan/terms.xml", 
      "xalan/ui.xml", 
    };



    for (int k = 0; k < 10; k++) {
      double[] before = EnergyCheckUtils.getEnergyStats();

      for (int i = 0; i < 1000; i++) {
        for (int j = 0; j < names.length; j++) {
            FileOutputStream outputStream = new FileOutputStream(new File("scratch", "xalan.out." + j));
            Result outFile = new StreamResult(outputStream);

            Transformer transformer = template.newTransformer();
            //transformer.setErrorListener(this);
            FileInputStream inputStream = new FileInputStream(new File(names[j]));
            Source inFile = new StreamSource(inputStream);

            transformer.transform(inFile, outFile);
            inputStream.close();

            /*
            try {
              float temp = PANDA_Util.Temperature.getTempC();
              if (temp >= 65.0) {
                Thread.sleep(1000);
              } else if (temp >= 60.0) {
                Thread.sleep(250);
              } else {
              }
            } catch (Exception e) {
            }
            */
    
            TemperatureContext@mode<?> d_tempContext = new TemperatureContext@mode<?>(this.tadapt);
            TemperatureContext@mode<*> tempContext = snapshot d_tempContext ?mode[@mode<low>,@mode<high>];
            tempContext.sleep();
            tempContext = null;

            outputStream.close();
          } 
        }

        double[] after = EnergyCheckUtils.getEnergyStats();

        ENT_Util.writeModeFile(String.format("ERun %d: %f %f %f\n", k, after[0]-before[0], after[1]-before[1], after[2]-before[2]));
      }

      //ENT_Util.writeModeFile(String.format("Time: %s\n", ENT_Util.elapsedTime()));
      ENT_Util.closeModeFile();
      EnergyCheckUtils.DeallocProfile();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    (new XalanBench()).execute();
  }
}
