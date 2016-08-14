package org.apache.batik.gvt.text;
public class ConcreteTextLayoutFactory implements org.apache.batik.gvt.text.TextLayoutFactory {
    public org.apache.batik.gvt.text.TextSpanLayout createTextLayout(java.text.AttributedCharacterIterator aci,
                                                                     int[] charMap,
                                                                     java.awt.geom.Point2D offset,
                                                                     java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.text.GlyphLayout(
          aci,
          charMap,
          offset,
          frc);
    }
    public ConcreteTextLayoutFactory() { super(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "raUaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2wvzrmP6p6/64zd+8tlv5p2P/wdoMKPrViUAAA==");
}
