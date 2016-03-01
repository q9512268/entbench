package org.apache.batik.css.engine.value.svg;
public class BaselineShiftManager extends org.apache.batik.css.engine.value.LengthManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BASELINE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BASELINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUPER_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUPER_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_BASELINE_SHIFT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_BASELINE_SHIFT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 BASELINE_VALUE;
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
                java.lang.Object v =
                  values.
                  get(
                    lu.
                      getStringValue(
                        ).
                      toLowerCase(
                        ).
                      intern(
                        ));
                if (v ==
                      null) {
                    throw createInvalidIdentifierDOMException(
                            lu.
                              getStringValue(
                                ));
                }
                return (org.apache.batik.css.engine.value.Value)
                         v;
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
            throw createInvalidIdentifierDOMException(
                    value);
        }
        java.lang.Object v =
          values.
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_PERCENTAGE) {
            sm.
              putLineHeightRelative(
                idx,
                true);
            int fsi =
              engine.
              getLineHeightIndex(
                );
            org.apache.batik.css.engine.CSSStylableElement parent;
            parent =
              (org.apache.batik.css.engine.CSSStylableElement)
                elt.
                getParentNode(
                  );
            if (parent ==
                  null) {
                parent =
                  elt;
            }
            org.apache.batik.css.engine.value.Value fs =
              engine.
              getComputedStyle(
                parent,
                pseudo,
                fsi);
            float fsv =
              fs.
              getFloatValue(
                );
            float v =
              value.
              getFloatValue(
                );
            return new org.apache.batik.css.engine.value.FloatValue(
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER,
              fsv *
                v /
                100.0F);
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
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public BaselineShiftManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DlHTKZA3DHQkkaUisP4PD7lgAyAiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o798+fnjL7xH9wKfTLBTsr3r9vequm4Q");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "lzehdv/07b/6/i+88s3y5sL/BT3L+j4bLgAA";
}
