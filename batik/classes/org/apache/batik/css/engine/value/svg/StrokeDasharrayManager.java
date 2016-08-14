package org.apache.batik.css.engine.value.svg;
public class StrokeDasharrayManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_LIST_OR_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_DASHARRAY_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONE_VALUE;
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
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             NONE_VALUE;
                }
                throw createInvalidIdentifierDOMException(
                        lu.
                          getStringValue(
                            ));
            default:
                org.apache.batik.css.engine.value.ListValue lv =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                do  {
                    org.apache.batik.css.engine.value.Value v =
                      super.
                      createValue(
                        lu,
                        engine);
                    lv.
                      append(
                        v);
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    if (lu !=
                          null &&
                          lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_OPERATOR_COMMA) {
                        lu =
                          lu.
                            getNextLexicalUnit(
                              );
                    }
                }while(lu !=
                         null); 
                return lv;
        }
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
                  CSS_NONE_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     NONE_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        switch (value.
                  getCssValueType(
                    )) {
            case org.w3c.dom.css.CSSValue.
                   CSS_PRIMITIVE_VALUE:
                return value;
        }
        org.apache.batik.css.engine.value.ListValue lv =
          (org.apache.batik.css.engine.value.ListValue)
            value;
        org.apache.batik.css.engine.value.ListValue result =
          new org.apache.batik.css.engine.value.ListValue(
          ' ');
        for (int i =
               0;
             i <
               lv.
               getLength(
                 );
             i++) {
            result.
              append(
                super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv.
                      item(
                        i)));
        }
        return result;
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeDasharrayManager() { super(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YBkvWSVe8a3lP6tB2qzxIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L7ztl9770698tbwG8P8AElDX0n4sAAA=");
}
