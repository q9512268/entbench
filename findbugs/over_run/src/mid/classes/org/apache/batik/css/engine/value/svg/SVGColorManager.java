package org.apache.batik.css.engine.value.svg;
public class SVGColorManager extends org.apache.batik.css.engine.value.svg.ColorManager {
    protected java.lang.String property;
    protected org.apache.batik.css.engine.value.Value defaultValue;
    public SVGColorManager(java.lang.String prop) { this(prop, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                 BLACK_RGB_VALUE);
    }
    public SVGColorManager(java.lang.String prop, org.apache.batik.css.engine.value.Value v) {
        super(
          );
        property =
          prop;
        defaultValue =
          v;
    }
    public boolean isInheritedProperty() { return false;
    }
    public boolean isAnimatableProperty() { return true;
    }
    public boolean isAdditiveProperty() { return true;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_COLOR;
    }
    public java.lang.String getPropertyName() { return property;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return defaultValue;
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
                      CSS_CURRENTCOLOR_VALUE)) {
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         CURRENTCOLOR_VALUE;
            }
        }
        org.apache.batik.css.engine.value.Value v =
          super.
          createValue(
            lu,
            engine);
        lu =
          lu.
            getNextLexicalUnit(
              );
        if (lu ==
              null) {
            return v;
        }
        if (lu.
              getLexicalUnitType(
                ) !=
              org.w3c.css.sac.LexicalUnit.
                SAC_FUNCTION ||
              !lu.
              getFunctionName(
                ).
              equalsIgnoreCase(
                "icc-color")) {
            throw createInvalidLexicalUnitDOMException(
                    lu.
                      getLexicalUnitType(
                        ));
        }
        lu =
          lu.
            getParameters(
              );
        if (lu.
              getLexicalUnitType(
                ) !=
              org.w3c.css.sac.LexicalUnit.
                SAC_IDENT) {
            throw createInvalidLexicalUnitDOMException(
                    lu.
                      getLexicalUnitType(
                        ));
        }
        org.apache.batik.css.engine.value.ListValue result =
          new org.apache.batik.css.engine.value.ListValue(
          ' ');
        result.
          append(
            v);
        org.apache.batik.css.engine.value.svg.ICCColor icc =
          new org.apache.batik.css.engine.value.svg.ICCColor(
          lu.
            getStringValue(
              ));
        result.
          append(
            icc);
        lu =
          lu.
            getNextLexicalUnit(
              );
        while (lu !=
                 null) {
            if (lu.
                  getLexicalUnitType(
                    ) !=
                  org.w3c.css.sac.LexicalUnit.
                    SAC_OPERATOR_COMMA) {
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            }
            lu =
              lu.
                getNextLexicalUnit(
                  );
            if (lu ==
                  null) {
                throw createInvalidLexicalUnitDOMException(
                        (short)
                          -1);
            }
            icc.
              append(
                getColorValue(
                  lu));
            lu =
              lu.
                getNextLexicalUnit(
                  );
        }
        return result;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.svg.SVGValueConstants.
                CURRENTCOLOR_VALUE) {
            sm.
              putColorRelative(
                idx,
                true);
            int ci =
              engine.
              getColorIndex(
                );
            return engine.
              getComputedStyle(
                elt,
                pseudo,
                ci);
        }
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            org.apache.batik.css.engine.value.Value v =
              lv.
              item(
                0);
            org.apache.batik.css.engine.value.Value t =
              super.
              computeValue(
                elt,
                pseudo,
                engine,
                idx,
                sm,
                v);
            if (t !=
                  v) {
                org.apache.batik.css.engine.value.ListValue result =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                result.
                  append(
                    t);
                result.
                  append(
                    lv.
                      item(
                        1));
                return result;
            }
            return value;
        }
        return super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            value);
    }
    protected float getColorValue(org.w3c.css.sac.LexicalUnit lu) {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return lu.
                  getIntegerValue(
                    );
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return lu.
                  getFloatValue(
                    );
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rhIu1GWamEZCK0Qm+g8Q7FT1ZSIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r840R9ntCikPcND9+wdwJ3uC5+4o7VjW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5e4Hvvfwr1x5/nj/8vBe4dNxd0a3d93+iRflBkn5KGv360/84w///Ze/Ud7L" +
       "/z8/q6esiy4AAA==");
}
