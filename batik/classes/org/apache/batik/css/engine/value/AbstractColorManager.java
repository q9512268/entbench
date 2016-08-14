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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze3AVVxk/94aEPAgJgfAmQAhogN5bSmntBBESEgi9eQwB" +
       "1GAJJ3vPTRb27i675yY3qdGW6hCcKYNIKTgtf8FQGVqYaqd2tBVb7WNKnWlB" +
       "a8uUKuqIIlp0LI6o9fvO7r37uI8MM2Jm9mRz9vvO+Z6/7zsnp66RQtMgNUzl" +
       "IT6kMzPUrPJOapgs2qRQ09wEcz3S4wX0b9uutN8XJEXdZGI/NdskarIWmSlR" +
       "s5vMkVWTU1ViZjtjUeToNJjJjAHKZU3tJtWy2RrXFVmSeZsWZUiwhRoRMoly" +
       "bsi9Cc5a7QU4mRMBScJCkvAa/+eGCJkgafqQQz7dRd7k+oKUcWcvk5PKyA46" +
       "QMMJLivhiGzyhqRBluiaMtSnaDzEkjy0Q1lhm2BDZEWGCWrPVHx8c39/pTDB" +
       "ZKqqGhfqmRuZqSkDLBohFc5ss8Li5i7yFVIQIWUuYk7qIqlNw7BpGDZNaetQ" +
       "gfTlTE3EmzShDk+tVKRLKBAn872L6NSgcXuZTiEzrFDMbd0FM2g7L62tpWWG" +
       "io8tCR98fFvlswWkoptUyGoXiiOBEBw26QaDsngvM8w10SiLdpNJKji7ixky" +
       "VeRh29NVptynUp4A96fMgpMJnRliT8dW4EfQzUhIXDPS6sVEQNl/FcYU2ge6" +
       "TnV0tTRswXlQsFQGwYwYhbizWcbtlNUoJ3P9HGkd6+4HAmAdH2e8X0tvNU6l" +
       "MEGqrBBRqNoX7oLQU/uAtFCDADQ4mZlzUbS1TqWdtI/1YET66DqtT0BVIgyB" +
       "LJxU+8nESuClmT4vufxzrX3lvgfV9WqQBEDmKJMUlL8MmGp8TBtZjBkM8sBi" +
       "nLA4cohOfXE0SAgQV/uILZrnv3x99dKas69bNLOy0HT07mAS75GO9U58e3ZT" +
       "/X0FKEaxrpkyOt+juciyTvtLQ1IHhJmaXhE/hlIfz2589YsPnWRXg6S0lRRJ" +
       "mpKIQxxNkrS4LivMWMdUZlDOoq2khKnRJvG9lYyH94isMmu2IxYzGW8l4xQx" +
       "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" +
       "VvRf1LPQEbYfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zr1n0f77V9/Ujie+28XCd2Yvum7Y26H/WWCLdZSJGU" +
       "KJGiRImUxHV1KL4lvnlIUey8JQHaJMuQBJvTpUDrP4YU7Qo3ybYWKzZ087qu" +
       "DyQYkKHoHl2bIBu2dm2A5o81w7ytO6R+7/vwDAf7ATw/6vD7/Z7v63zOl+fw" +
       "lW8jD8QRUgl8Z286PjjSM3C0cVpHYB/o8dGQbU2UKNa1nqPE8Rz2vaA++5Xr" +
       "f/7a56wbV5FrMvJ2xfN8oADb92JBj30n1TUWuX7WSzm6GwPkBrtRUgVNgO2g" +
       "rB2D51nkLedYAXKTPVEBhSqgUAW0VAHFz6gg09t0L3F7BYfigThE/jpyhUWu" +
       "BWqhHkCeuSgkUCLFPRYzKS2AEh4qfkvQqJI5i5D3n9p+sPk2gz9fQV/6uz92" +
       "4x/eh1yXkeu2NyvUUaESAA4iI291dXetRzGuabomI495uq7N9MhWHDsv9ZaR" +
       "x2Pb9BSQRPqpk4rOJNCjcswzz71VLWyLEhX40al5hq072smvBwxHMaGt7zqz" +
       "9WAhXfRDAx+xoWKRoaj6Ccv9W9vTAPK+yxynNt4cQQLI+qCrA8s/Hep+T4Ed" +
       "yOOH2DmKZ6IzENmeCUkf8BM4CkCevKvQwteBom4VU38BIE9cppscHkGqh0tH" +
       "FCwAeedlslISjNKTl6J0Lj7fHv/wZ37cG3hXS501XXUK/R+CTE9fYhJ0Q490" +
       "T9UPjG/9IPtTyrt+7ZNXEQQSv/MS8YHmH/+173z4h55+9bcPNO+5Aw2/3ugq" +
       "eEH94vrRr7+3dwu7r1DjocCP7SL4Fywv039y/OT5LIAz712nEouHRycPXxV+" +
       "c/XRX9T/5CryCINcU30ncWEePab6bmA7etTXPT1SgK4xyMO6p/XK5wzyILxn" +
       "bU8/9PKGEeuAQe53yq5rfvkbusiAIgoXPQjvbc/wT+4DBVjlfRYgCHIDXsg7" +
       "4XUTOfyV/wFio5bv6qiiKp7t+egk8gv7Y1T3wBr61kLXMOu3aOwnEUxB1I9M" +
       "VIF5YOnHD9S4oDWhTmiqOImO4muY8YoKoBV+xCkezIroqEi54P/nYFlh+Y3d" +
       "lSswKO+9DAkOnE0D39H06AX1pYSgvvOlF7569XSKHPsMIG04/tFh/KNy/CM4" +
       "/tFh/KNy/KM7jY9cuVIO+45Cj0MewChuIR5ApHzrrdlfHX7kk8/eBxMw2N0P" +
       "Q1CQoncH7N4ZgjAlTqowjZFXv7D7mPQ3qleRqxeRt9Addj1SsE8KvDzFxZuX" +
       "Z9yd5F7/xB/9+Zd/6kX/bO5dgPJjSLids5jSz172cuSrugZB8kz8B9+v/MoL" +
       "v/bizavI/RAnIDYCBboSws7Tl8e4MLWfP4HJwpYHoMGGH7mKUzw6wbZHgBX5" +
       "u7OeMvyPlvePQR9TyHFzIfmLp28PivYdh3QpgnbJihKGf2QW/Oy/+9d/3Cjd" +
       "fYLY18+tgTMdPH8OJQph10s8eOwsB+aRrkO6P/jC5O98/tuf+CtlAkCK5+40" +
       "4M2i7UF0gCGEbv6J3w7//Tf+8Iu/e/UsaQBcJpO1Y6vZwci/gH9X4PV/iqsw" +
       "rug4zPDHe8cw8/5TnAmKkb//TDeYvg6ciEUG3RQ919dsw1bWjl5k7P+6/oHa" +
       "r/zpZ24ccsKBPScp9UOvL+Cs//sI5KNf/bHvPl2KuaIWK96Z/87IDjD69jPJ" +
       "eBQp+0KP7GP/5qmf/i3lZyEgQxCM7VwvcQ0p/YGUAayWvqiULXrpWb1o3hef" +
       "nwgX59q5yuQF9XO/+2dvk/7sn32n1PZiaXM+7pwSPH9ItaJ5fwbFv/vyrB8o" +
       "sQXpmq+Of/SG8+prUKIMJaoQ32I+ghCUXciSY+oHHvwP/+JfvusjX78PuUoj" +
       "jzi+otFKOeGQh2Gm67EF0SsL/vKHD9m8e+gE4DPkNuMPCfJE+asoDm/dHWvo" +
       "ojI5m65P/E/eWX/8W//jNieUKHOHBfkSv4y+8jNP9j70JyX/2XQvuJ/Obodl" +
       "WMWd8dZ/0f3vV5+99q+uIg/KyA31uESUCtCFk0iGZVF8UjfCMvLC84slzmE9" +
       "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" +
       "h+5o0lvXMGlg6epg3ZImTm/gLGZ1URw1k1jzCGEOZ0kmEwxKL7fTrLVYEWPa" +
       "m4ftjUlu+tBYrNu3q03U3I/yRZTytRrX2uke2qHTboUmUzTczHJssfOWGBmL" +
       "4xgXa60WnYzEATmOqJHqDSO86w7SzbjXkLDN2pgpOq3mgo3RkyZGt4SVRwAD" +
       "HY26IE0mXK6DNsAqvWpjvhx2W6gIKkGlIfYr8WI21XvNreUHy7wvaixb44kx" +
       "Ro/IneYsG7owxHbLAB/a1CaojvNs28G5TnOH1YdpM8d7/gbvbqWmIndogxTr" +
       "Cs5XPL2Xcxw1cKqxHVWroTVj4pEI4MN8NKEWOUd0mfFAqo1XcYNZz4P6vmaO" +
       "UbI+A+N5Ul3U9L4FhBrIRZdpJ9t4R1aoaastcJxlVSdis4InupeZK9uqNbfR" +
       "3F+gySwN8o0QMqBV15MWb/S6ayLttOZ7fVcdTDCaS6QAdewkU8FEnGz0Pslu" +
       "2tsVzg/oaoubr5NEjKbUgpNij1u3cB1r9TZ8Y7SjdrWFx6hwFSMq+dqM4jao" +
       "JhtNrqNgRTiCterDkrgdGr3NAutoqghlkgPXIKPd0tjydZ4MmzbIer1+s6Vv" +
       "HWMyooS2X2lMPMpR4Nu0sR+bzcpqI3S6ma1bxlQFVXaSwAVsu+Tcpq7sOoyM" +
       "VbvoBDAbSzE8rN3CNaj/blj3qhGGN+k4qeLabo2LqhRNxZQHyzgyIhsNQ5z2" +
       "2ZlE9zRRl/QeEBVMJVl9DkuxOR+og9wzV9uEg2jH4z6YN4QaNaXrlR3X91fL" +
       "dTCwKHajy8F+hdpdfDPgcyBw4rLXk1YefAuo9ztDnuZqit7rKOFykklpf99Y" +
       "6cvWcrvoZq6547c7IciIzsDcb9o1vrnEuWSXELKQLscrn6WGldoGdBOlUVW8" +
       "OKmbgTHYjcy5u14PM9nXGgY9YR0Zm2wgjPQgSK80j5cd2xWXK4KpdFwzGjbn" +
       "E16rV0jVINqb/R5vNRXQXFWzzZCjdwM+a/lu36vMW5jt85PmkGkveFjmBK45" +
       "4ppxI9ywsbqSIT+3WJugKjfXwFcaarbZMPtu051117FJNinJUIOls5jTEx3t" +
       "+eQ6aiodNEJnPXVVIfx1X8BHaas17DnbyRAdpAm6UZn2XLfT7cJZ+nQy8+HL" +
       "VKcTkUt1rm4YZ6dVO2gtzQmMcplKvSb6Hkg8Gc3ILIUveumcq64iWxHVRrpP" +
       "252JQKO7mR9HfcqPrIkTdhoMqJmc5PqTmGrLlciuQTxq+agsMH1AYENQg1M+" +
       "A6i8XDC8sDHzhY0lnp2Y681KHzHNXWK76TSY2MFuGmT9bqMhd1uj5dJf0ZMo" +
       "E2v7gbQaUF6OhS2Y2t10sLb2WsTy2tbMYMlIBuLI1EeZoAadFe3Fch/tx4lk" +
       "VOe1Derp4Xwu5Hp10thgXjJZCMpiW+VpazkSOSVq1QayXwHwxQ5OyDBS2Bo2" +
       "Vz3PdmRYa1MTQndg9U9NKbZiUyntrttrvsMlxmrQaER9ie1Ua4t0ygOaWM9W" +
       "xJ7znKgVSoy4RXFlSUdDlm+YU15P6GEcTtB6dRQ68RpT6bHGZ3xIy4nudlpU" +
       "4g02JsoMgqwe9oLRXqKp0SSTWRu4a7BlQ2E2HffHe3eZ66utzVgVvxl6qhwy" +
       "ijjKaoJUj9Wa7AUdul/PeGUzXu/UDEZ0CH8Lfb8lT/2OyQG65eTbPOzyfgvb" +
       "S9WGapg5a7cbXW6RwhqF6Qsdxq23vSiqDNaaQjetbEimyk4wfXqENqVUMGrs" +
       "ZEqtVwZ8a/+R4nXefWM7Ko+Vm0enZ64bp1M8WL6BnYTszgNeLQcEyEPK8eFS" +
       "drohV/5dv8c5xrm9XqTYOnnqbues5bbJFz/+0ssa/3O1q8d75BZAHgZ+8Jcc" +
       "PdWdc6KuQUkfvPsWEVceM5/t3f7Wx//bk/MPWR95A6dT77uk52WRf5975Xf6" +
       "36/+7avIfac7ubcdgF9kev7i/u0jkQ6SyJtf2MV96tSzpXffC6+vHHv2K3c+" +
       "IbpjxK6UETskxqUjiKuHkJ7sKL6n2LfdNdRyuzZW1CNWz2DF44ieDU5oPnCv" +
       "vd3ebEaVd+VoP3FptCvHJ4rHkp44GU3z3SOS56hM1YMiEiXzp4vmowB5ixrp" +
       "CtDP9mIh5w+8/v7yGX2Z6B97vS2z82cSZceLF53/FLx+/dj5v/69cf614+w9" +
       "NurodRw7A3unOLQqPnLRPXA6nT9ZClDPTWcTIPfZ3mnEbt5LcCFVP96G/2yp" +
       "5k/f45jq7xXNS6D4cqTcIi+9XLKeufrzb8LV7yg6n4XX7x+7+vffqKvJO7r6" +
       "vjOs/OxZU5K+cg9zv1Q0P1+cCJQ5KPSJ8iT9ksG/8GYN/kF4fevY4G99bwy+" +
       "ckbwkyXBr96d4G+VBP+kaP4RQN5xsLU0tDh88L3jZDtn8S+/CYuLjzyQ5+D1" +
       "3WOLv/u9mU3n4/Yb93j2m0Xzz2FMTR0wGrStOGk4fP40OLPw1Tdh4fcVnQS8" +
       "Xju28LU3YiFAHgwiO4UhuFdg7zTnH4gtPwIl19fv4YDfK5qvAuTWIdCMBwHT" +
       "1srcPo52Affn8bhMkjPffO2N+CaDGXWnz1CKc/QnbvsY7vABl/qll68/9O6X" +
       "xX9bfolx+pHVwyzykJE4zvljz3P314JIN+zSxIcPh6BB+e8PAPLM664X4PiQ" +
       "q9T/Px4Yv3m8IN6FESDXDjfnef4TNPdOPBCRYXue8r8A5MZlSqhF+f883R8D" +
       "5JEzOjjo4eY8yZ9C6ZCkuP12cIL6jddfI8/S/zgo2ZWLFdppyB9/vZCfK+qe" +
       "u1CKlZ9FnpRNyeHDyBfUL788HP/4d9o/d/hkRXWUPC+kPMQiDx6+njktvZ65" +
       "q7QTWdcGt1579CsPf+CkTHz0oPDZHDun2/vu/E0I5Qag/Ioj/9V3//IP//zL" +
       "f1ieZ/5foMeDrq8qAAA=");
}
