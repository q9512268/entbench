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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5yw2RZi5uXAoQ9MW6ehm7F3yHyxb29eWIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gRemuK15sB9tW3R9wslwreekFtfroEafw9Z+s4ZwYzyKLJTtTOosM8iThli3" +
       "LH5ItJpm3K9lybrS1qNtnwn5Gc0MTAvh/HF9qg174jTkHL+dUCmcMinjYR2f" +
       "7K1rsbbQddZv+ltlvlytdQPMFmGtj4hwTrWilJz3A84eM/Suia+FrWX24la3" +
       "LxmKHQsL2XcHjRhxOa+qqAvEarf8YZJ2fJ7lOxQhd4aWEdL6tLsWN42wkjDm" +
       "lBv3KMIZrKftpJsJYrzdeBXbWaQIN+IrvYpdTxv9nrimpBWM0kKzQzbC9nDE" +
       "NJNQhW2Dp5u71pbrc43essM1d5uQZSZ4g65tDdyhFpvVQJ5kft7e+pi+7m+m" +
       "w1ZkpRW5g5N4wDcyth85ERrrfGdj5kynzzRNlsPneFubcniWwMl0GM9Tnl9y" +
       "giMJjM1ybT1ZOFM8sNsTXJjVCHxmyr1htdtdL3ATjnqORfloFamYTQyd++1t" +
       "2nCGIo4m3JRpii3SH69wWG8u1p1Vj0W7Q2URmUobJ60UpohkjLcSFidicVBD" +
       "K2gzyOp8qz10ujy5GkuDdt4ne1k0b0mbXTSYRbtgSmeinvWEiERVJRkHWYig" +
       "rp9T+nTFrTdCa06ZvQgVQ3kXBFg61dYTh5nDGzwgYWbohyPaSXlzvQ3FcMyn" +
       "LhnzIcxPts4a84gd3fY74yYtCK7schjtbHJkwzpif+QlRrc65TlqgVOkgDNt" +
       "gW+JUlTZaOQcprOV4XeGFV7XtHXDahHVFtpf1Sd9c7Pwp4EgKPVh2w77Lac9" +
       "GKpjYiqJFjw3VlWt6UniNKLpvrda1YiRYnVGA9ohO5HBNbpOs2MJsJlurQap" +
       "9BaNDqVngV3xdZJcEWMZa7GVpjCVMNdaKV2PGi1WRG+aUGq9b2+7C5kdhdq8" +
       "j1k028tbrjWFlZQiVlQlMioNS2bNUd1q9eqEZLe5fqLpKmzpao0adbk6O91R" +
       "G2KFj6KETaZdU1aQrb6I69gcmS11abFuYCyuOQNcmrapLKqp3KDX09heFrpO" +
       "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" +
       "1uHETh59PTs5s9t4z7k9Qvks+jiej/cP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("o2/KX3qZYn7o280v7F+tybaY50UrD4yh+/cP6E72BM/dsbXjti4PPvCdh3/p" +
       "yvPH+5eH9wKfzrszsr3r9k/ECMePykdd+W888asf/kcvf6281/9/hpBWDK8u" +
       "AAA=");
}
