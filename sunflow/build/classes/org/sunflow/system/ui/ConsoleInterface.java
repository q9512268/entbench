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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wUxxmfO7/fD7ABYx42hsqE3iUhECWmEHAwNj2bKwba" +
       "msAx3puzF/Z2l91Z++zUaYKUQisFkZQQWhH/BUpCSaBVUSo1RERRm9AkVRNo" +
       "07Rq0lZVQ5uihlZNq9A2/WZm93Zv74EsRT1p5+Z2vm/me83v+2buzDVUYhpo" +
       "IVFpiE7oxAxtVGkUGyaJdyvYNLfBu5j0RBH+++6rA3cFUekQqh3FZr+ETdIj" +
       "EyVuDqEFsmpSrErEHCAkzjiiBjGJMYaprKlDqEk2+5K6Iksy7dfihBHswEYE" +
       "NWBKDXnYoqTPnoCiBRGQJMwlCa/3D3dFULWk6RMu+VwPebdnhFEm3bVMiuoj" +
       "e/EYDltUVsIR2aRdKQPdomvKxIii0RBJ0dBeZZVtgs2RVVkmaD9X99GNI6P1" +
       "3ASzsKpqlKtnbiWmpoyReATVuW83KiRp7kcPoKIIqvIQU9QRcRYNw6JhWNTR" +
       "1qUC6WuIaiW7Na4OdWYq1SUmEEVtmZPo2MBJe5oolxlmKKe27pwZtF2c1lZo" +
       "maXi47eEjz6xu/57RahuCNXJ6iATRwIhKCwyBAYlyWFimOvjcRIfQg0qOHuQ" +
       "GDJW5Enb042mPKJiaoH7HbOwl5ZODL6mayvwI+hmWBLVjLR6CR5Q9q+ShIJH" +
       "QNdmV1ehYQ97DwpWyiCYkcAQdzZL8T5ZjVO0yM+R1rHj80AArGVJQke19FLF" +
       "KoYXqFGEiILVkfAghJ46AqQlGgSgQVFL3kmZrXUs7cMjJMYi0kcXFUNAVcEN" +
       "wVgoavKT8ZnASy0+L3n8c21gzeH71V41iAIgc5xICpO/CpgW+pi2kgQxCOwD" +
       "wVi9PHIMN184FEQIiJt8xILm+a9cv2fFwouvCpr5OWi2DO8lEo1JJ4dr32zt" +
       "7ryriIlRrmumzJyfoTnfZVF7pCulA8I0p2dkgyFn8OLWH3/5wdPkgyCq7EOl" +
       "kqZYSYijBklL6rJCjE1EJQamJN6HKoga7+bjfagM+hFZJeLtlkTCJLQPFSv8" +
       "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" +
       "uq7z7fc+a3b9D3a5aSJ3HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
