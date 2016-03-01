package org.apache.batik.css.engine.value.css2;
public class FontVariantManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALL_CAPS_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALL_CAPS_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_VARIANT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontVariantManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0qkm+LaaWm+duMHysRYwypkCc2dpc9ppsC0QY9JVUjWrvWmtaFZDlj1+eNv2" +
       "qKFTc+HbaSq1c+L2yMdaQOfnCsw9T5ufcXtsxHEhKfOyOW2PO8avGi16ZqZn" +
       "bttMdXSK1oe9pq69EzdTPtYCpnipwNxF2rxI0BQwUyiGFQLXaswrvK2W6r+a" +
       "uOopCF3Zb2L0Fjgj6/mePzmLT52sKpt+8r4/sXeZzLNwJZQe8aQs2y8ptr5P" +
       "03FcYrpU8iuLxn5dImjBf/d0R1Ax/cX0eJ0zXyGoaVxmuLsMZhBiMv6BoJkF" +
       "GOHuwjt2nquQ5XLxQDCD1k55DY6xmxKkYL/tdNcJqrDoYFPesZO8A6sDCe2+" +
       "q6XPxMrxDWZhxPRoyuO84GQwUzceZmx3onmOUpH9FyhdSSX5/4GgbD25ecv9" +
       "N+86zZ/IRFkYHqarTIL6iT/EZS4OTXlXS6/la190a8rT5fPTpZ3jic4uG4My" +
       "pBD2nNXgejMyWjJPR2+eWnP+tcO+K1CU7kIeAQr0XdmX85SWhFvNrnCuSpEd" +
       "EyhxghXv9V767C1PLXsDQby2bCzEERGPnr/WFde073tReQiVQOWKU+zlYOM+" +
       "ZRsWB3VH4emLqkkl8w+jKfSUCTQdMMuYBp2cGaWvpwQ1Z5fX2S/KFbI6hPUN" +
       "dHW6zGTXVSupafZZZtlBnruppQGOkXCHppmPikUNzPKaxoLJJyyD/wcDjko4" +
       "6h0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
