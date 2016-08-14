package org.apache.batik.util;
public class HaltingThread extends java.lang.Thread {
    protected boolean beenHalted = false;
    public HaltingThread() { super(); }
    public HaltingThread(java.lang.Runnable r) { super(r); }
    public HaltingThread(java.lang.String name) { super(name); }
    public HaltingThread(java.lang.Runnable r, java.lang.String name) { super(
                                                                          r,
                                                                          name);
    }
    public boolean isHalted() { synchronized (this)  { return beenHalted;
                                } }
    public void halt() { synchronized (this)  { beenHalted = true; } }
    public void clearHalted() { synchronized (this)  { beenHalted = false;
                                } }
    public static void haltThread() { haltThread(java.lang.Thread.currentThread(
                                                                    )); }
    public static void haltThread(java.lang.Thread t) { if (t instanceof org.apache.batik.util.HaltingThread)
                                                            ((org.apache.batik.util.HaltingThread)
                                                               t).
                                                              halt(
                                                                );
    }
    public static boolean hasBeenHalted() { return hasBeenHalted(
                                                     java.lang.Thread.
                                                       currentThread(
                                                         ));
    }
    public static boolean hasBeenHalted(java.lang.Thread t) {
        if (t instanceof org.apache.batik.util.HaltingThread)
            return ((org.apache.batik.util.HaltingThread)
                      t).
              isHalted(
                );
        return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
