package org.apache.batik.css.engine.value.css2;
public class ClipManager extends org.apache.batik.css.engine.value.RectManager {
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_CLIP_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.InheritValue.
                                                             INSTANCE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_AUTO_VALUE)) {
                                                        return org.apache.batik.css.engine.value.ValueConstants.
                                                                 AUTO_VALUE;
                                                    }
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
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_AUTO_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public ClipManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XHwfHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
