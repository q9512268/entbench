package org.apache.batik.css.engine.value.css2;
public class TextDecorationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BLINK_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLINK_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINE_THROUGH_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LINE_THROUGH_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OVERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OVERLINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_UNDERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          UNDERLINE_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT_LIST; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_TEXT_DECORATION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
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
                return org.apache.batik.css.engine.value.ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                org.apache.batik.css.engine.value.ListValue lv =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                do  {
                    if (lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_IDENT) {
                        java.lang.String s =
                          lu.
                          getStringValue(
                            ).
                          toLowerCase(
                            ).
                          intern(
                            );
                        java.lang.Object obj =
                          values.
                          get(
                            s);
                        if (obj ==
                              null) {
                            throw createInvalidIdentifierDOMException(
                                    lu.
                                      getStringValue(
                                        ));
                        }
                        lv.
                          append(
                            (org.apache.batik.css.engine.value.Value)
                              obj);
                        lu =
                          lu.
                            getNextLexicalUnit(
                              );
                    }
                    else {
                        throw createInvalidLexicalUnitDOMException(
                                lu.
                                  getLexicalUnitType(
                                    ));
                    }
                }while(lu !=
                         null); 
                return lv;
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
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
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NONE_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public TextDecorationManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H3q5ej4Bn/6Rnv1XXs9P3KLuU3nyKxHygJVfySi2Im+i5a++DC2v5IWPwGd4" +
       "pOXwldfyH9+i7nN58lyEXDFAdKzeydnlBT++zTq6K1No/esvQ+sH8sLH4DM7" +
       "0nr2ymv9G7eo+808+dJ5rfkj/Bmeqvjll6FisQQ8Cp/rRypef+VV/L1b1D2f" +
       "J7+9V5EGSzW290dSx8ceb3vxY5tT+sIav/NyrfFG+CyPrLF8ZaxxUBAcHCv1" +
       "hlypBNMKXUJVO2RBammqLbtWdEzzxK0Up0ajdpErevvWhd4uHd2SOGrpoePe" +
       "dM85pAWunWrAzxfPgvkP8uRrEfIqLQBqBApj5kX/+tSiX3+5Fn0cPr94ZNFf" +
       "fGUsets+VrrR/L8jNL2gOHIvgqP/UPB/+8Y2yl//Y0HwX/PkT2CYtbfD/ozt" +
       "Rtb405dijTRCXnvDKy/5mf1DL7iKt78+pn35uSt3vf45+Y+KWx8nV7zuZpG7" +
       "lrFtnz1iPZO/7AdgaRW63L0/cPWLv7+IkLf+/S7nRMjt+V+hxJ/vmb8XIY+9" +
       "KHN0dGZ4lvH7R15+E8YIubzPnOX5n3C1vhEPhHSYnqX8YYRcvUgJpSj+z9L9" +
       "dYTcc0oHO91nzpL8DWwdkuTZv/WPp0z9xQ3WWoRRoGp7tDoa1PTS+WD5xGce" +
       "eDGfORNfv+VcVFxc6jyOYOP9tc7r2lee6/M/8YP65/bXazRb3e3yVu5ikTv3" +
       "N31OouDHbtracVuXe0/+6L6v3v3EccR+317g02l5RrY33/j+Stvxo+LGye5f" +
       "vP43n/4nz327OCH+f3mi89xtKwAA");
}
