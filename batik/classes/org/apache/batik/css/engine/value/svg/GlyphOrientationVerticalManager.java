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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AaaN+4/IGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "B/0kAAA=");
}
