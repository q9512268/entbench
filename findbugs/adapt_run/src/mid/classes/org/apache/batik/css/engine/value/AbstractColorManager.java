package org.apache.batik.css.engine.value;
public abstract class AbstractColorManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AQUA_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          AQUA_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BLACK_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLACK_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BLUE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLUE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FUCHSIA_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          FUCHSIA_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GRAY_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          GRAY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GREEN_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          GREEN_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LIME_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LIME_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MAROON_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MAROON_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NAVY_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NAVY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OLIVE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OLIVE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_PURPLE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          PURPLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          RED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SILVER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SILVER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TEAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          TEAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_WHITE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WHITE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_YELLOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          YELLOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ACTIVEBORDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ACTIVEBORDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ACTIVECAPTION_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ACTIVECAPTION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_APPWORKSPACE_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                                    APPWORKSPACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BACKGROUND_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                                  BACKGROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONFACE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONFACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONHIGHLIGHT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONHIGHLIGHT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_CAPTIONTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CAPTIONTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_GRAYTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          GRAYTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_HIGHLIGHT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          HIGHLIGHT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_HIGHLIGHTTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          HIGHLIGHTTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INACTIVEBORDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INACTIVEBORDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INACTIVECAPTION_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INACTIVECAPTION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INACTIVECAPTIONTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INACTIVECAPTIONTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INFOBACKGROUND_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INFOBACKGROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INFOTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INFOTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MENU_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MENU_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MENUTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MENUTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SCROLLBAR_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SCROLLBAR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDDARKSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDDARKSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDFACE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDFACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDHIGHLIGHT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDHIGHLIGHT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDLIGHTSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDLIGHTSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WINDOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WINDOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WINDOWFRAME_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WINDOWFRAME_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WINDOWTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WINDOWTEXT_VALUE);
    }
    protected static final org.apache.batik.css.engine.value.StringMap
      computedValues =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_BLACK_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  BLACK_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_SILVER_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  SILVER_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_GRAY_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  GRAY_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_WHITE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  WHITE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_MAROON_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  MAROON_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_RED_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  RED_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_PURPLE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  PURPLE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_FUCHSIA_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  FUCHSIA_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_GREEN_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  GREEN_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_LIME_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  LIME_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_OLIVE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  OLIVE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_YELLOW_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  YELLOW_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_NAVY_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  NAVY_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_BLUE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  BLUE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_TEAL_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  TEAL_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_AQUA_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  AQUA_RGB_VALUE);
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_RGBCOLOR) {
            lu =
              lu.
                getParameters(
                  );
            org.apache.batik.css.engine.value.Value red =
              createColorComponent(
                lu);
            lu =
              lu.
                getNextLexicalUnit(
                  ).
                getNextLexicalUnit(
                  );
            org.apache.batik.css.engine.value.Value green =
              createColorComponent(
                lu);
            lu =
              lu.
                getNextLexicalUnit(
                  ).
                getNextLexicalUnit(
                  );
            org.apache.batik.css.engine.value.Value blue =
              createColorComponent(
                lu);
            return createRGBColor(
                     red,
                     green,
                     blue);
        }
        return super.
          createValue(
            lu,
            engine);
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
                CSS_IDENT) {
            java.lang.String ident =
              value.
              getStringValue(
                );
            org.apache.batik.css.engine.value.Value v =
              (org.apache.batik.css.engine.value.Value)
                computedValues.
                get(
                  ident);
            if (v !=
                  null) {
                return v;
            }
            if (values.
                  get(
                    ident) ==
                  null) {
                throw new java.lang.IllegalStateException(
                  "Not a system-color:" +
                  ident);
            }
            return engine.
              getCSSContext(
                ).
              getSystemColor(
                ident);
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
    protected org.apache.batik.css.engine.value.Value createRGBColor(org.apache.batik.css.engine.value.Value r,
                                                                     org.apache.batik.css.engine.value.Value g,
                                                                     org.apache.batik.css.engine.value.Value b) {
        return new org.apache.batik.css.engine.value.RGBColorValue(
          r,
          g,
          b);
    }
    protected org.apache.batik.css.engine.value.Value createColorComponent(org.w3c.css.sac.LexicalUnit lu)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
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
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PERCENTAGE:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PERCENTAGE,
                  lu.
                    getFloatValue(
                      ));
        }
        throw createInvalidRGBComponentUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    private org.w3c.dom.DOMException createInvalidRGBComponentUnitDOMException(short type) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          type) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.rgb.component.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    public AbstractColorManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fwHV0vBlzR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dquidBIxUd3FJhJTCxrJyK5i1Wy8ZbQwDLdMIG3XO6+S5AJWkxDcMeTcHEtk" +
       "SrgdS2lMndRFWgK1kHx7gCaT7k72HFSIEysx+xsktHcx3CFFZgyLkSZhtU2+" +
       "6uYmh9mD/pLo9zFj3lxqVEPe9SV74thRNdtW+thWpVA/2WVpjIYtc+Q4tD1c" +
       "y5jUBtDQG++yzrxBeuOp4oVVjxnK7iKQiRwONjKrr/stIlzUamKQdFF93Riw" +
       "3NpyJcIjPVvJpVWcSKbJbY2xQ6tRut6KIJLaUyUebyIpMBXPwubOvE+xW0UY" +
       "17rtgW1FtLDBBNqfDTOxPpnEqwUbc1l7Mm4yrNVCQ7HZWYvCSOratu1mrDqx" +
       "EszJgIWw6XaXKysmNLIY9TSLGS3zwXbi+nQ+3XLmYEKZltAP6W6v6XdNoIul" +
       "Z4lSiU2Yo/BcI2tuVEt3m6StpJybDqqyLrr+TKylY3aR21VOHqv0AG02NsPE" +
       "2sALf7Jm42SxafH5uBmARFRbi53fZwWCQ2KcrUyxJUzHSKPJaElqd9o9SmV5" +
       "ITfms2UFQ8iqgLJ57Db6zWxg4L7K2JpjWAozUlkaoZ0l30YnCZ7O60wzrhla" +
       "Zsy2WctZEf5qh016odQldwtsQWg70eslys4ZthsMS1EJZrTrWNCsBzTsx/WF" +
       "samNNoMeqzU2UjzfxJVsRneqQ4riFIrS1nKl7kw2VIXtVDqb0K4I3iK3orGN" +
       "eww1czKzH0z8actlWZXFFyNyQOasIozSmZtQfb3VHNikl1c8ZxAJfbs97sZ8" +
       "Bw67MagaPSuarBurHjlj1rt+zM/n9oTmbGYJp+gKrXRZYtcKxhk/zVDckzSl" +
       "C2/0tWcu2kIFV0Q4n2bT2src1fvZ0ouG+aZnYkTeplddfEsHrayNIUxcr4et" +
       "KreOR5q3ZZKtLHoONk8ZozMzA3EtEGm1EcmDXrOZJsDHDb+Lbmt4G+6GAr3x" +
       "15t1t+WYy7xL0aJs25NpjRc3VbXHqdak3taRVehtNvmEjnBrbTgjbNfE23SL" +
       "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" +
       "5ZcYu99486/9yC+98OflmeT/By/Ul42PKgAA");
}
