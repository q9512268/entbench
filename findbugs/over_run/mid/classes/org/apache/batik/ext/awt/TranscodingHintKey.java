package org.apache.batik.ext.awt;
final class TranscodingHintKey extends java.awt.RenderingHints.Key {
    TranscodingHintKey(int number) { super(number); }
    public boolean isCompatibleValue(java.lang.Object val) { boolean isCompatible =
                                                               true;
                                                             if (val !=
                                                                   null &&
                                                                   !(val instanceof java.lang.String)) {
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
       "9dwUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
