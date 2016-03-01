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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
