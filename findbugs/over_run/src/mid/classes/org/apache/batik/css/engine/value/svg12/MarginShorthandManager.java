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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
