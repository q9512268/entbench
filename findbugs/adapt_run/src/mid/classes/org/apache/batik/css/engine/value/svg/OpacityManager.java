package org.apache.batik.css.engine.value.svg;
public class OpacityManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected boolean inherited;
    protected java.lang.String property;
    public OpacityManager(java.lang.String prop, boolean inherit) { super(
                                                                      );
                                                                    property =
                                                                      prop;
                                                                    inherited =
                                                                      inherit;
    }
    public boolean isInheritedProperty() { return inherited; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_NUMBER_OR_INHERIT; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                                NUMBER_1;
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
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              type,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sCcpSyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2l6nY30g9gZ1W2T8aOGYjUTks4bprqpsqzWRZBqV13Ic60kgJg2K9sRFXR9M" +
       "/dVUEF27aRN1tD1HpB2fJjPGtdYRqcONNoHvJmklYivmIGm1Gxu+me9kJFeb" +
       "a5sWt8FWYEjYpXTg3C42Q0YVmDa7ubpbj3C4Haa9XM+3iwwxR8MgCdCtTDWr" +
       "ddvpzmyFRANuPlo3hy143h7WKovYCoh+qhjouNOaMuvOTqPaPDuphxNiLVuT" +
       "ChrzxJDbzMIMi5aiQY0YlkunHUTY1mnd8HbEZsbS8HbV1lmKcVODmje1frvD" +
       "0UbX6mL0eqhsVy5fH8vBnFqzNj3lerjIKDsKNuv9idN15m1h5wa8a0mZi6FY" +
       "Pm7OsRB2LHYHFuJybCGV5oBfY6HM2w6fRRq3206FgBNWW3izFFbUQDIacbBd" +
       "MZM6XOfG1ZmPVAPSGOJjtNL2a12iP+M3wng+7lYzapmgdboJ1isB0oL1YTuw" +
       "wVqLmfFmZ4pZTjPGR3HOmXLDbtQyIVZ5hOxmy9ZwnGy1mqujCM4T+TbDTMwb" +
       "hjGX0SsGh1uM07ZpstnrSNWtNJ0lm46E1ZVhAxV9ozrVRqsauqouBhNpa8N1" +
       "WrHUmE2jmJNNV/a6k12EmnKOmDK25A1s3hRUyatwESJv5sHM4SgvCIc0xqO2" +
       "nSDL3TSNuxwpruGFaLoIs4yoHA3aptARBrkmDPAVzEYdxZ/tio/uZ8p9Se+7" +
       "2yZ4qNz9ODlJ/Tvse+yrniySp072isrfFejC6dvZXfjTnUSo2Ot8850OSMtt" +
       "3c996PkX1PHnqwdHO7CtGLo/9vzvt7WtZp8RdRVIevedNyXZ8nz4dGfw1z/0" +
       "p4/N32M++10cIL3lgp4XRf4M+4XfoN+u/PMD6J6TfcKXnFyfZ3r6/O7gtVCL" +
       "k9Cdn9sjfPOJZx859uYzR5595uIu3Gnf3X4L7p37vr/LBveH71L3kSL5QAw9" +
       "YkX9443FyZmtvPpp1Hzw5faPzsouC547b+Y7wNM9MrP76pv5z+5S95NF8mMx" +
       "9DorIlzLkeLiTOcOdv74K7XzKfAMj+wcvvp2fvYudf+ySD4VQw9bxQ2Q8jDl" +
       "DlZ++hVYeb0oLLaOuSMruVffyp+5S93PFcnnYui6ocXH5p0ck17YCb3HOrqa" +
       "U1r9+Vdg9cNF4ZPgEY6sFl59q798l7pfKZJ/dd7q0RHQIKcm/tIrMLHE+ifA" +
       "8+yRic+++ib+h7vU/VqR/Nu9iV1NlxJ7f3BzfCj6jpe/unBKX3rjxVfqjTeB" +
       "xzjyhvHqeOPCSe/3FkalqFLaEknKIaNlliLZC9eKj2meupvhndmMLHNla797" +
       "obVLRxcyjiQ9etya6jmH3TFLZormF7Nkyfz7RfKfYug1SqhJsVY6syj66qlH" +
       "f/uVerQYQu8/8uj7X32PXhj/lyPTC+Pb1ui2J8WlvD+6vc+K1z8oCf68SL4W" +
       "Qzf2fqEKzts55+vfjXOyGHrw/C2b4srAoy+5Abi/tab8wgvXr77xhcV/KS+a" +
       "nNwsu5+BruqJbZ89kDyTv+KHmm6VNty/P570y7+/epmYOrkHBBAUpKXuf7ln" +
       "/VYMPfmyrPHRmdhZxv9zFOt3YIyhK/vMWZ6/AXP27XiAWiA9S/kd0DsXKYEW" +
       "5f8ZuksHMXTtlA40us+cJbkMpAOSInvFPx44jZd3FyFHcSgp+8g46tLs0vm1" +
       "8UmoPPxyoXJmOf22c4vg8ibp8YI12d8lvaV88YXB6P3fbHx+f59HsaU8L6Rc" +
       "ZaD79leLTha9T95R2rGsK713ffvBL93/1PEC/cG9wqeD84xub7n95RnS8ePy" +
       "ukv+5Tf+0g/81At/WJ6A/j+xOztk4isAAA==");
}
