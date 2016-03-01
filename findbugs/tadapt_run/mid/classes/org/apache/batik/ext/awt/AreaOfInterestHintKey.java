package org.apache.batik.ext.awt;
final class AreaOfInterestHintKey extends java.awt.RenderingHints.Key {
    AreaOfInterestHintKey(int number) { super(number); }
    public boolean isCompatibleValue(java.lang.Object val) { boolean isCompatible =
                                                               true;
                                                             if (val !=
                                                                   null &&
                                                                   !(val instanceof java.awt.Shape)) {
                                                                 isCompatible =
                                                                   false;
                                                             }
                                                             return isCompatible;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Hy9Fq4joFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HwAA");
}
