package org.apache.batik.css.engine.value.svg12;
public class MarginShorthandManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ShorthandManager {
    public MarginShorthandManager() { super(); }
    public java.lang.String getPropertyName() { return org.apache.batik.util.SVG12CSSConstants.
                                                         CSS_MARGIN_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public void setValues(org.apache.batik.css.engine.CSSEngine eng,
                          org.apache.batik.css.engine.value.ShorthandManager.PropertyHandler ph,
                          org.w3c.css.sac.LexicalUnit lu,
                          boolean imp) throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT)
            return;
        org.w3c.css.sac.LexicalUnit[] lus =
          new org.w3c.css.sac.LexicalUnit[4];
        int cnt =
          0;
        while (lu !=
                 null) {
            if (cnt ==
                  4)
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            lus[cnt++] =
              lu;
            lu =
              lu.
                getNextLexicalUnit(
                  );
        }
        switch (cnt) {
            case 1:
                lus[3] =
                  (lus[2] =
                     (lus[1] =
                        lus[0]));
                break;
            case 2:
                lus[2] =
                  lus[0];
                lus[3] =
                  lus[1];
                break;
            case 3:
                lus[3] =
                  lus[1];
                break;
            default:
        }
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_TOP_PROPERTY,
            lus[0],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_RIGHT_PROPERTY,
            lus[1],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_BOTTOM_PROPERTY,
            lus[2],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_LEFT_PROPERTY,
            lus[3],
            imp);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
