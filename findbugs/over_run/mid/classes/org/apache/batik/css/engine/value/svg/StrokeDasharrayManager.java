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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ca1A3rIwlUTmiR32vyZNXoi8HwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qzVuB898xxrzl8YaW1mDrV2lXp0qtSqKmS4BL26TcqyLvDVx9HC3zf1XUrzB" +
       "MK0sl/X2J0d6O7Zzir/D6dbd3iTX3m4OqFYsyl66eGbEX0qTz4XQy0Rf5kM5" +
       "M2Za9Nl9i37+Wi16L3iSHYsmL41Fj++cHl5i/p8INNfPFr8sOPpCRv/1S9so" +
       "ff1y1uAbafIXIMza2GFzrnUpa/zltVrjDvC8e8ca735prHEya3Byd8S3r+I7" +
       "TLi20uUwvWknOwdMlSZP7HK5cCUuKQuZ4jOpP5vJ9I9XmOXfSZNvhuldNduL" +
       "Lu1lz10rUKco9pEdu37kxdgVhKie74ayCAKkq4LZf1yh7gdp8m8hdCMAs4Gv" +
       "A9Pyu5cvnthX9N9fjKJxCN1y6Us96a2EW19wEXFzeU785JNnr3/Vk5O/ye61" +
       "7F1wO01C1yuRZR08RD6QP+n5sqJnmpzeHCl72d+Pr4JGe9ePwNoL0kyHH2Wk" +
       "x6AQuueqpOHOOe9BwuM7KHkZwhA6uckcpDkJor1L0QCxQHqw5ekQOne0JZAi" +
       "+z/Y7oYQOrPfDnS6yRxschZwB03S7Dlvd+rAVzcXCd5CbWcs4w1Y33rQuzNf" +
       "OX81XznwYXbfoc+p7Cbr7qdPtLnLelF85kmi/9bnsY9u7g2JFp8kKZfrSejU" +
       "5gpTxjT9fLrnstx2eZ3sPvDDGz91+v7dT70bNwLvz7QDst116Ys5LdsLs6s0" +
       "yWdf9ek3/O6T38yO8/8PXGJGtmIsAAA=");
}
