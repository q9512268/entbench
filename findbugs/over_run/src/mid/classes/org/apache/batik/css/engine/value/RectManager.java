package org.apache.batik.css.engine.value;
public abstract class RectManager extends org.apache.batik.css.engine.value.LengthManager {
    protected int orientation;
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_FUNCTION:
                                                    if (!lu.
                                                          getFunctionName(
                                                            ).
                                                          equalsIgnoreCase(
                                                            "rect")) {
                                                        break;
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_RECT_FUNCTION:
                                                    lu =
                                                      lu.
                                                        getParameters(
                                                          );
                                                    org.apache.batik.css.engine.value.Value top =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value right =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value bottom =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value left =
                                                      createRectComponent(
                                                        lu);
                                                    return new org.apache.batik.css.engine.value.RectValue(
                                                      top,
                                                      right,
                                                      bottom,
                                                      left);
                                            }
                                            throw createMalformedRectDOMException(
                                                    );
    }
    private org.apache.batik.css.engine.value.Value createRectComponent(org.w3c.css.sac.LexicalUnit lu)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             AUTO_VALUE;
                }
                break;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_EM:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_EMS,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_EX:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_EXS,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PIXEL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PX,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_CENTIMETER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_CM,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_MILLIMETER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_MM,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INCH:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IN,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_POINT:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PT,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PICA:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PC,
                  lu.
                    getFloatValue(
                      ));
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
        throw createMalformedRectDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return value;
        }
        if (value.
              getPrimitiveType(
                ) !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_RECT) {
            return value;
        }
        org.apache.batik.css.engine.value.RectValue rect =
          (org.apache.batik.css.engine.value.RectValue)
            value;
        orientation =
          VERTICAL_ORIENTATION;
        org.apache.batik.css.engine.value.Value top =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getTop(
                ));
        org.apache.batik.css.engine.value.Value bottom =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getBottom(
                ));
        orientation =
          HORIZONTAL_ORIENTATION;
        org.apache.batik.css.engine.value.Value left =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getLeft(
                ));
        org.apache.batik.css.engine.value.Value right =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getRight(
                ));
        if (top !=
              rect.
              getTop(
                ) ||
              right !=
              rect.
              getRight(
                ) ||
              bottom !=
              rect.
              getBottom(
                ) ||
              left !=
              rect.
              getLeft(
                )) {
            return new org.apache.batik.css.engine.value.RectValue(
              top,
              right,
              bottom,
              left);
        }
        else {
            return value;
        }
    }
    protected int getOrientation() { return orientation;
    }
    private org.w3c.dom.DOMException createMalformedRectDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "malformed.rect",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            SYNTAX_ERR,
          s);
    }
    public RectManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze3AVVxk/94bcPMgbElIeAUJACXBXpC06wQqE0ARuSOQC" +
       "jqE2bPaemyzs3V12z01uUmMLtoJ1hsECFbXwh6VTy1DoqIyOtRQftXRoZcCO" +
       "tmUsav9otWWm/GFTRa3fd3b37t69jwxTxztzT/bu+R7ne5zf952TU9dJsWmQ" +
       "Zl1UY2KYjerUDPfic69omDTWroimuQXe9ksP//nQ/RO/K9sTJKE+UjUkmt2S" +
       "aNL1MlViZh+ZI6smE1WJmpsojSFHr0FNagyLTNbUPlIvm10JXZElmXVrMYoE" +
       "20QjQmpFxgx5IMloly2AkbkRvhqBr0ZY4ydoi5AKSdNHXYaZGQztnjmkTbj6" +
       "TEZqIjvFYVFIMlkRIrLJ2lIGWaJryuigorEwTbHwTuUO2xEbIndkuaH5meoP" +
       "bh4cquFumCaqqsa4ieZmamrKMI1FSLX7tkOhCXM3+SopipCpHmJGWiKOUgGU" +
       "CqDUsdelgtVXUjWZaNe4OcyRFNIlXBAj8zOF6KIhJmwxvXzNIKGU2bZzZrB2" +
       "XtpaJ9w+E48sEQ5/+96aHxaR6j5SLatRXI4Ei2CgpA8cShMD1DDXxGI01kdq" +
       "VQh4lBqyqMhjdrTrTHlQFVkSUsBxC75M6tTgOl1fQSTBNiMpMc1ImxfnSWX/" +
       "Ko4r4iDY2uDaalm4Ht+DgeUyLMyIi5B7NsuUXbIa43mUyZG2sWUjEABrSYKy" +
       "IS2taooqwgtSZ6WIIqqDQhSSTx0E0mINUtDguZZHKPpaF6Vd4iDtZ6TRT9dr" +
       "TQFVGXcEsjBS7yfjkiBKM31R8sTn+qZVB+5TO9UgCcCaY1RScP1TganJx7SZ" +
       "xqlBYR9YjBWtkUfFhuf2BwkB4nofsUXzk6/cWL206fwFi2ZWDpqegZ1UYv3S" +
       "iYGqy7PbF3+2CJdRqmumjMHPsJzvsl57pi2lA9I0pCXiZNiZPL/5N1964CR9" +
       "N0jKu0hI0pRkAvKoVtISuqxQ426qUkNkNNZFyqgaa+fzXaQEniOySq23PfG4" +
       "SVkXmaLwVyGN/wYXxUEEuqgcnmU1rjnPusiG+HNKJ4TUwJfUw3chsT78LyOq" +
       "MKQlqCBKoiqrmtBraGg/BpRjDjXhOQazuiYMQP7vWrY8vFIwtaQBCSloxqAg" +
       "QlYMUWtSkExToOogrFAYFpUkFTaDsG5RhdQwwph3+v9dYwp9MG0kEIDwzPaD" +
       "gwL7qlNTYtTolw4n13bcON1/0Uo83Cy29xhZBmrDltowVxsGtWFLbZirDXvU" +
       "kkCAa5uO6q1EgDDuAkAARK5YHP3yhh37m4sgA/WRKRADJF2UVaHaXeRw4L5f" +
       "OnV588SlV8pPBkkQwGUAKpRbJloyyoRV5QxNojHAqXwFwwFNIX+JyLkOcv7o" +
       "yJ5t93+Kr8OL/CiwGEAL2XsRr9MqWvw7Ppfc6n3vfHDm0XHN3fsZpcSpgFmc" +
       "CCnN/tj6je+XWueJZ/ufG28JkimAU4DNTIQAAuw1+XVkQEubA9NoSykYHNeM" +
       "hKjglIOt5WzI0EbcNzzpanGot/IP08G3QI7wn4vqx1777V9XcE86xaDaU8Wj" +
       "lLV5AAiF1XGoqXWza4tBKdD98WjvoSPX923nqQUUC3IpbMGxHYAHogMefOjC" +
       "7tevvXni1aCbjgwqcHIAmpkUt2X6R/AJwPc/+EXQwBcWeNS12wg2Lw1hOmpe" +
       "5K4NwEyBrYHJ0bJVheST47I4oFDcC/+qXrj87HsHaqxwK/DGyZalkwtw39+2" +
       "ljxw8d6JJi4mIGExdf3nklkIPc2VvMYwxFFcR2rPlTnfeVE8BlgP+GrKY5RD" +
       "JuH+IDyAt3NfCHxc4Zu7E4cW05vjmdvI0/T0Swdffb9y2/vnbvDVZnZN3rh3" +
       "i3qblUVWFEDZZ4g9ZEA4zjboOM5IwRpm+EGnUzSHQNjt5zfdU6Ocvwlq+0Ct" +
       "BGBq9hgAfKmMVLKpi0ve+MWvGnZcLiLB9aRc0cTYepFvOFIGmU7NIcDMlP75" +
       "1dY6RkqdApMiWR5Cp8/NHc6OhM54AMZ+OuPHq548/ibPQivtZqWxcV4WNvK2" +
       "3N3W71393lvPTzxeYhX1xfmxzMfX+M8eZWDvXz7MigRHsRwNh4+/Tzj12Mz2" +
       "u97l/C6cIPeCVHaxAcB1eT99MvH3YHPohSAp6SM1kt0Cb8NSAju5D9o+0+mL" +
       "oU3OmM9s4ax+pS0Nl7P9UOZR6wcyt8jBM1Ljc6Uv66owik3wbbWzrtWfdQHC" +
       "Hzo5y0I+fhKHJQ6elOmGxmCVNJZKi+XJUVlALCNTNUOmqh0T3F2ePMBjVjQ5" +
       "YLJeQ04AMg7bTeCZhondvy4ZW+c0eLlYLMqNZveln3W+3c+RtxRr6RbHA54q" +
       "ucYY9CB6DQ7LcJsVyDLfioTxumu7HnvnaWtF/pTyEdP9hx/+KHzgsIWIVqO/" +
       "IKvX9vJYzb5vdfMLaeEc698+M/7sD8b3Wauqy2xbO+BU9vTv//1y+OifXsrR" +
       "DRXJ9mENt3kgvU8b/M62TAotP/aP+7/+Wg8U3S5SmlTl3UnaFctMvhIzOeDx" +
       "vnuEcBPSNg5rDyOBVl236yqOK3HosnKrLRcopXKnZhAflzJSKkJWGABwbnry" +
       "T3UBrPWAFEGXz8l3ouHuPrH38PFYzxPLg3bJ+CJsCqbpyxQ6TBWPqGIePD/e" +
       "dfNznAseK69MFF19pLEiuw1ESU15mrzW/CnrV/Di3r/N3HLX0I5b6O/m+uz3" +
       "i3yq+9RLdy+SHgnyo6iFVVlH2EymtswkKTconLnVzLRoTkesFiMxG76CHTHB" +
       "j1NuwmSDFM8EHzqVFxDmaweCVj7x342MzMLzwsgKiR8TTFEKR2hKlkRlqyoz" +
       "h2ZhoTNFezTawZ/4ok2fNmfP2ZIaHW0xLRFe19PdkZKojuHizKM4JABNJYNC" +
       "g8ZLiMP5icnPNS4932VqgV2WXfrxxWr+Wk67ts7ZTVHbtdFbiRMjJbohD4Mh" +
       "vmBNLSAxt/vwJ+PKvpGfYIwTfBOHvYxMs3yIZz3sfDUVyhNOjbsO+trHdhBP" +
       "5DnwfdA258ECDsJBz07bfKw+Q0N8HSEnHcKTpGSUjSrYeuO9H1XTmVzDuzvs" +
       "RsLWhRK+H8bhCw5JSyHJKJZC08k9yY07UqDbPobDQYZ3awk9aSe0Lwjf+t9k" +
       "6Tz4nrQ9eXKSIGzM7mzysRYw7skCc0/h8H1GqgYp63E7I9fP3PTHP7bpt+EU" +
       "HjNO2+s/PYnpD2XvxHysBcz7UYG5szichoJh7b9uUcEjOI3hRvQCHt+xri/O" +
       "3LovUgCUnqscPLw0Zt0oW7eg0unj1aUzjm/9A79OSN9UVkA3GU8qire39jyH" +
       "dIPGZW5VhdVpW53MzxmZPykaM1I8nMbjZy3G5+1yk4cRTvPWg5fnl4xMz8UD" +
       "vR2MXsoXYHv7KWEV/K+X7gIj5S4dKLUevCQXQTqQ4OPLugMMwuQVKAK/2JAd" +
       "kFQgs/FKx7p+slh7erUFGZ0Q/7+C07Ukrf8swEHi+IZN99248wnrYkZSxLEx" +
       "lDIVmlXr+ifd+czPK82RFepcfLPqmbKFTveXcTHkXRtPQag8/BJlpu+mwmxJ" +
       "X1i8fmLVuVf2h65Ac76dBEQoTNuzj4QpPQlt2fZIrrYc+kJ+idJW/taOSx++" +
       "EajjJ29iNfJNhTj6pUPnrvbGdf27QVLWRYqhuaUpfl5dN6rCzhk2Mrr80ICW" +
       "VNP/gqjCTSJiieCesR1amX6Ld3aMNGcfeLLvMcsVbYQaa1E6iqn09YpJXffO" +
       "cs9ux2FZCj0Nqdgf6dZ1+yqrqIR7Xtc5CFzD4Z7/AuY0ZyQ8HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n/5ufk3zP8mtMMurJwAA");
}
