package org.apache.batik.css.engine.value.svg;
public class OpacityManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected boolean inherited;
    protected java.lang.String property;
    public OpacityManager(java.lang.String prop, boolean inherit) { super(
                                                                      );
                                                                    property =
                                                                      prop;
                                                                    inherited =
                                                                      inherit;
    }
    public boolean isInheritedProperty() { return inherited; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_NUMBER_OR_INHERIT; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                                NUMBER_1;
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
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              type,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Lf0vR5OswlghAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9r/wzp/7gb/7yu9VJ6j/F+EGeysGLAAA");
}
