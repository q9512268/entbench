package org.apache.batik.css.engine.value.css2;
public class FontWeightManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLD_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LIGHTER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LIGHTER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_WEIGHT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_WEIGHT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INTEGER) {
            int i =
              lu.
              getIntegerValue(
                );
            switch (i) {
                case 100:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_100;
                case 200:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_200;
                case 300:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_300;
                case 400:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                case 500:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_500;
                case 600:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_600;
                case 700:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_700;
                case 800:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_800;
                case 900:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_900;
            }
            throw createInvalidFloatValueDOMException(
                    i);
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            int i =
              (int)
                floatValue;
            if (floatValue ==
                  i) {
                switch (i) {
                    case 100:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_100;
                    case 200:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_200;
                    case 300:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_300;
                    case 400:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_400;
                    case 500:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_500;
                    case 600:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_600;
                    case 700:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    case 800:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_800;
                    case 900:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_900;
                }
            }
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                BOLDER_VALUE) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSContext ctx =
              engine.
              getCSSContext(
                );
            org.apache.batik.css.engine.CSSStylableElement p =
              org.apache.batik.css.engine.CSSEngine.
              getParentCSSStylableElement(
                elt);
            float fw;
            if (p ==
                  null) {
                fw =
                  400;
            }
            else {
                org.apache.batik.css.engine.value.Value v =
                  engine.
                  getComputedStyle(
                    p,
                    pseudo,
                    idx);
                fw =
                  v.
                    getFloatValue(
                      );
            }
            return createFontWeight(
                     ctx.
                       getBolderFontWeight(
                         fw));
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    LIGHTER_VALUE) {
                sm.
                  putParentRelative(
                    idx,
                    true);
                org.apache.batik.css.engine.CSSContext ctx =
                  engine.
                  getCSSContext(
                    );
                org.apache.batik.css.engine.CSSStylableElement p =
                  org.apache.batik.css.engine.CSSEngine.
                  getParentCSSStylableElement(
                    elt);
                float fw;
                if (p ==
                      null) {
                    fw =
                      400;
                }
                else {
                    org.apache.batik.css.engine.value.Value v =
                      engine.
                      getComputedStyle(
                        p,
                        pseudo,
                        idx);
                    fw =
                      v.
                        getFloatValue(
                          );
                }
                return createFontWeight(
                         ctx.
                           getLighterFontWeight(
                             fw));
            }
            else
                if (value ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        NORMAL_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                }
                else
                    if (value ==
                          org.apache.batik.css.engine.value.ValueConstants.
                            BOLD_VALUE) {
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    }
        return value;
    }
    protected org.apache.batik.css.engine.value.Value createFontWeight(float f) {
        switch ((int)
                  f) {
            case 100:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_100;
            case 200:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_200;
            case 300:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_300;
            case 400:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_400;
            case 500:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_500;
            case 600:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_600;
            case 700:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_700;
            case 800:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_800;
            default:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_900;
        }
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontWeightManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeO79f8Ssv8nDixAnKg7uQQAE5TXEcGzucH4qD" +
       "2zoEZ7w3Z2+8t7vsztnn0JSH2iYtBfEIT0FUVUFQmhCEQH1QaFDUAoUiAaFA" +
       "W6AvCVoalUBLUWmh/z+7e7u3d7fGUl1LOx7P/P/M/3//P//8M+Ojp0mJaZAm" +
       "pvIIn9KZGelQeT81TBZvV6hp7oS2YemOIvrBFe/0XhQmpUNkzhg1eyRqsk6Z" +
       "KXFziCyVVZNTVWJmL2Nx5Og3mMmMCcplTR0i82SzO6krsiTzHi3OkGCQGjFS" +
       "Tzk35JEUZ932AJwsjYEkUSFJtM3f3Roj1ZKmT7nkCz3k7Z4epEy6c5mc1MX2" +
       "0gkaTXFZicZkk7emDbJO15SpUUXjEZbmkb3K+TYE22Pn50Cw4uHaDz++aaxO" +
       "QNBIVVXjQj1zBzM1ZYLFY6TWbe1QWNK8knyVFMVIlYeYk5aYM2kUJo3CpI62" +
       "LhVIX8PUVLJdE+pwZ6RSXUKBOGnOHkSnBk3aw/QLmWGEcm7rLphB2+UZbS0t" +
       "c1S8bV300B1X1D1SRGqHSK2sDqA4EgjBYZIhAJQlR5hhtsXjLD5E6lUw9gAz" +
       "ZKrI+2xLN5jyqEp5CszvwIKNKZ0ZYk4XK7Aj6GakJK4ZGfUSwqHsv0oSCh0F" +
       "Xee7uloadmI7KFgpg2BGgoLf2SzF47Ia52SZnyOjY8ulQACsZUnGx7TMVMUq" +
       "hQbSYLmIQtXR6AC4njoKpCUaOKDByaKCgyLWOpXG6SgbRo/00fVbXUBVIYBA" +
       "Fk7m+cnESGClRT4reexzunfzjVepXWqYhEDmOJMUlL8KmJp8TDtYghkM1oHF" +
       "WL02djud/8TBMCFAPM9HbNH84CtnLl7fdOIZi2ZxHpq+kb1M4sPSkZE5Ly5p" +
       "X3NREYpRrmumjMbP0lyssn67pzWtQ4SZnxkROyNO54kdP//yNQ+yd8OkspuU" +
       "SpqSSoIf1UtaUpcVZlzCVGZQzuLdpIKp8XbR303KoB6TVWa19iUSJuPdpFgR" +
       "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" +
       "F7FmKn8mg759iahireu/1vPjwZMkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "w1mep0FuezMekACB+izls8AJL1ICLcr/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Z+muJ9CDp3Rg0P3DWZIPAOmApHj8gfA4MmBvbrBT5zia0Xy/PT1x1q/L5fDo" +
       "mznLmVfR5869QJZ3uo9f9tL9re6XtC+91h/+2Hfrn9/ftNNcZbcrpNzPQlf2" +
       "l/5KocUL47O3lHYs63Lvhe8//OsPPH/8cvvwXuHTNXZGt/fe/CpbxwuT8vLZ" +
       "7p++6zd/6Fdf+3p5WeT/ASNJ5HVsLwAA");
}
