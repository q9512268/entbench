package org.apache.batik.css.engine.value.svg;
public class ColorProfileManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_PROFILE_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.String s =
                  lu.
                  getStringValue(
                    ).
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
            case org.w3c.css.sac.LexicalUnit.
                   SAC_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  lu.
                    getStringValue(
                      ),
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    lu.
                      getStringValue(
                        )));
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                java.lang.String s =
                  value.
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  value,
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public ColorProfileManager() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JYNBVSlwx66LLvgvzRX4dfAYNoLG7MFPx+qDI1sokj3T/s2FUstIs4OxjWNz" +
       "Sby+PT3g+PPnguA32FzhpMIC1cq200H7y/8FtAk4505zoYbV36Ip9/vWnbR0" +
       "/lRZwcJTO94TJU/y3rgEjrDRuKJ4jl7eY1iebrCoLCwssSpmXXxdm8Fdk/d+" +
       "ECWhFXb80WL9kJPaGVlhcUaT8cBm/MjeRmkYOcmzXrw8f4bMPx0PqAWtl/Jj" +
       "OC35KUEL8e2l+4STIpcOJrVevCSfgnQgwddburMnH5gZrmYoMQyoRYXb2Eua" +
       "yJpanws/qp7Jjzzl98qUmkP8T+QcyuPWP0UD0oVTW7v2337geeuyTFLoxARK" +
       "KYajuHUll6w+a9NKc2TltTfcmXexcJVTI6Rc1nl1E94M+0hcbC323R6Z9clL" +
       "pPdPb7z0q8m8d6G62UmyYOtW7fT8S2P9JdGU0ONQ9u8MTy05oFIX11pNDc+M" +
       "b2qMfvoHcfVBrBJlaXr6AenqmV2/PrrodE2AFHeQXCh/WKKfFMnmlnF1G5NG" +
       "jX5SKputCVARpMhUSaln5uEmoxgIBC42nKXJXrxF5aRuapU29e65SNHGmLFZ" +
       "i6sRFAMVUbHb49xCpBTwcV33Mbg9nsKUWSERVwO8diDcqevOFWROmS7CTTRt" +
       "hMzKFq/4lvMfp934H0MeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7LFv5rei/weOakuyhCkAAA==");
}
