package org.sunflow.system.ui;
public class ConsoleInterface implements org.sunflow.system.UserInterface {
    private int min;
    private int max;
    private float invP;
    private java.lang.String task;
    private int lastP;
    public ConsoleInterface() { super(); }
    public void print(org.sunflow.system.UI.Module m, org.sunflow.system.UI.PrintLevel level,
                      java.lang.String s) { java.lang.System.err.
                                              println(
                                                org.sunflow.system.UI.
                                                  formatOutput(
                                                    m,
                                                    level,
                                                    s)); }
    public void taskStart(java.lang.String s, int min, int max) {
        task =
          s;
        this.
          min =
          min;
        this.
          max =
          max;
        lastP =
          -1;
        invP =
          100.0F /
            (max -
               min);
    }
    public void taskUpdate(int current) { int p = min == max ? 0 : (int)
                                                                     ((current -
                                                                         min) *
                                                                        invP);
                                          if (p != lastP) java.lang.System.
                                                            err.print(
                                                                  task +
                                                                  " [" +
                                                                  (lastP =
                                                                     p) +
                                                                  "%]\r");
    }
    public void taskStop() { java.lang.System.err.print(("                                                            " +
                                                         "          \r"));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f0zp0N1LHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
