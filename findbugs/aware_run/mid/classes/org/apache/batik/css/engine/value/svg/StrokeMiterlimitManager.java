package org.apache.batik.css.engine.value.svg;
public class StrokeMiterlimitManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_NUMBER_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_MITERLIMIT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_4;
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
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
        }
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (unitType ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              unitType,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                unitType);
    }
    public StrokeMiterlimitManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "K9vIkdd1HlK+4JHtv7h26bZzHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2z79ht9+8uvZhef/AaTV6CGHKQAA");
}
