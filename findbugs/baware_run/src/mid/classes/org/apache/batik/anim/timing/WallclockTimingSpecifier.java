package org.apache.batik.anim.timing;
public class WallclockTimingSpecifier extends org.apache.batik.anim.timing.TimingSpecifier {
    protected java.util.Calendar time;
    protected org.apache.batik.anim.timing.InstanceTime instance;
    public WallclockTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    java.util.Calendar time) { super(
                                                                 owner,
                                                                 isBegin);
                                                               this.
                                                                 time =
                                                                 time;
    }
    public java.lang.String toString() { return "wallclock(" + time.
                                           toString(
                                             ) +
                                         ")"; }
    public void initialize() { float t = owner.getRoot().convertWallclockTime(
                                                           time);
                               instance = new org.apache.batik.anim.timing.InstanceTime(
                                            this,
                                            t,
                                            false);
                               owner.addInstanceTime(instance,
                                                     isBegin);
    }
    public boolean isEventCondition() { return false; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Bk/sl9nQ+x+FFNLiERoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "73jz108hJxvIBduTtYacIR1yHkKMHhowasT+G964nWHrczC5lKmKvEj57cy8" +
       "K3s7fWPPa6RrxQOcvOu/eFt5+z/954uMkMH7NZzxWHsJe/Yjd1Ov/27W/gBn" +
       "09b3xS8Oh3BdfdA2/0nn308+dOYvTiJnJeSSurtoF2V7laKXBBeq4d5KHi7s" +
       "j9QfXXRuV1iP78eRe47PhkPdHkf4Ay+E+ZQ6zV84Buq3pFa+Bz4P7eLdQ8dB" +
       "/QSSZTpZkwez9EqavHoPQ8/7gQeglLqW8S4D2Ju57fl124iQpm9Mk+52OKnr" +
       "Dj1zVLAr8Hn1rmCvvo5go+sIlmb7exKdM3eN9JPB3Z5JhV09DqkgvqQKWZfx" +
       "CWiZ0/kdYgdP3990bSFPpdnXwDAUZhsr2GJmurK9J/WdC1u9sgdaItxoQfe9" +
       "srCJPSUuZTMvdZSd7e7kmKzln1hWOLNuOWDGeXCj865/fs/Xfufhb0H3byOn" +
       "o9Q1odcf6rG7Svd+73j2/fe+7OlvvyuLqtDqvQ/Ql7K+zRtpnCZKmqh7qt6d" +
       "qjrMFqycHIJOFgh1bV/b/CF9KtDDbO9n0Ba8/HtMMWxV9z4dcarn16M4dmY8" +
       "gXbXfZRS+/i001JaRncjthcDtj52q6HCGAsam3qy31bDBCTA4ciCPCkILkG0" +
       "hbXVaPdFlvZomlXW9Yox9MI5zvqDZU42RDqvDJoO6zWaSq0u+k6CDrsWzc6S" +
       "AT8kI9wpuVq+opIs782AMkjKJTdyMFeP8liebIijqeR4BZWSF1QX35i1cbtD" +
       "6EXSxM3uBkzDUDaAQ5Ndc1ZfoRI6LnSjBbVk6EYSB9Vcq9nkSMqnbRkfAHox" +
       "4FpezhQNhWrT0oCEYi9ot9MQcaUvdEflBAUsvbSsFqO1rfXcKUwXbKMpsI7f" +
       "rvMjshsqI65fjJfjtuo4ZrnYoSdCY9RG3abdifplp+eRy3WcDwaEa4mDfn7t" +
       "umF9UG9MRjK9ieXGbDzgVGm18HLLlYf3gxYe2l1tGgNzlI+7ruHKCSlielSI" +
       "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" +
       "jvMkAAA=");
}
