package org.apache.batik.css.engine.value.svg;
public class GlyphOrientationVerticalManager extends org.apache.batik.css.engine.value.svg.GlyphOrientationManager {
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_GLYPH_ORIENTATION_VERTICAL_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_IDENT) {
            if (lu.
                  getStringValue(
                    ).
                  equalsIgnoreCase(
                    org.apache.batik.util.CSSConstants.
                      CSS_AUTO_VALUE)) {
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         AUTO_VALUE;
            }
            throw createInvalidIdentifierDOMException(
                    lu.
                      getStringValue(
                        ));
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_AUTO_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     AUTO_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    public GlyphOrientationVerticalManager() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BypxwZ7/GAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BVO1FWrdJAAA");
}
