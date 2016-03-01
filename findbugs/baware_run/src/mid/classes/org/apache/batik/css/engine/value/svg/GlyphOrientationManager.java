package org.apache.batik.css.engine.value.svg;
public abstract class GlyphOrientationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_ANGLE; }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_DEGREE:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_DEG,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_GRADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_GRAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_RADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_RAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INTEGER:
                                                    {
                                                        int n =
                                                          lu.
                                                          getIntegerValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_REAL:
                                                    {
                                                        float n =
                                                          lu.
                                                          getFloatValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                return new org.apache.batik.css.engine.value.FloatValue(
                  type,
                  floatValue);
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public GlyphOrientationManager() { super(
                                         );
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
       "o+jpfWO6GPKcOe2tO2EPaZHLdmoE0caia9PAVCtSfbWJC2lk2+uOHBmSSBRq" +
       "myrj9MRCK/VhVcMGVabZKbGRyaaNVMW5MOz0KqOauTIC3U97BL7pROW0OYgY" +
       "tzg27KXE2ma3AF6IakySZaoK0rAAbPze8IZsS/imF7Yrvyk/gDi4bgKb8ayh" +
       "8wJ2o8mlO9zZO/g4I4hB6AtSmBycyOafs1c4kT1yagVl2++7L3fFlG+9P/Gu" +
       "x5+U+59EdvZO+6YhdF3ouK81lbViHhF1Gkh6zeWPGdj8hu3wFOor7/rXO8dv" +
       "1N/yAs7Z7z2h50mRv8M+9bXOq6Rf3YGuOjiTes7d33GmC8dPoq73lTDy7fGx" +
       "86i7Dzx7y743H9nz7COXPuu+5IidykdsGxhXOEwNr9C2zgonhG4xAsrWFd8I" +
       "FXngO/ltas4wOhJNfAhdKzqOqQj2YaS5z3fucbTL/IV53PpXg6e0Z33ppbf+" +
       "l67Q9u6seFsIvcIIcNuwhDA7Bd83P2tLDu18+4u18yHwvG7Pzte99HZ+8Apt" +
       "v5IV7wuhm43saj0/B7uMle9/EVZmAAHdAx58z0r8pbfyN67Q9vGseCKEzmpK" +
       "uG/ewSXTiTi+ytj7z0Nu9UdehNU5Pt4FHnLPavKlsXpnC8r758qvzG4545KU" +
       "X24GgrTbVRJDEsyJbYT7NA9d6SaU4LhWXst7+9SJ3k7t3W7uSbpjvzfZsXbB" +
       "4tlKJMXNsDRn/lxWfDKEXib5ihAq+Tn+Puern/829pA+d/5vvljn3w8ea8/5" +
       "1kvv/BORc02gO354yRbVdIQwl/elS7s3+/m7OcGXs+IPQ+jc1oXtjDP3S/b+" +
       "84fO+aMX4pwkhG6/zDV3dk93x3P+nbP9R4n0mSfPnrn9ycnf5De9B//6uK4L" +
       "nVEj0zx6rXKkftr1FdXIjblue8ni5l9//jxxeHAjDyYhKHMjvrFl/csQuv95" +
       "WcO9m4+jjH+9Nz8uwxhCp7eVozzfBrB/KR6gFiiPUn4HDNNJSqBF/n2U7u9D" +
       "6PpDOtDptnKU5BkgHZBk1e+5+1Om+vzuwvdSsjxE9oY0OXU86zqImZufL2aO" +
       "JGoPHkuv8n957adC0fZ/Xhelzz5J9976bPWT2wt1yRTSNJNypgtdu73bP0in" +
       "7r+stH1Zp8mHf3Lj5657aD/1u3Gr8OEsPaLbvZe+sW5ZbpjfMad/cPvnX/9b" +
       "T343v+f6P1V2Mt9+JwAA");
}
