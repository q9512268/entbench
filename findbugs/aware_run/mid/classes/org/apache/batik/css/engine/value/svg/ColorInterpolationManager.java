package org.apache.batik.css.engine.value.svg;
public class ColorInterpolationManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINEARRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LINEARRGB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SRGB_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_INTERPOLATION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 SRGB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ColorInterpolationManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vPgBHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAM16a8zsxnkez5F0jqTIOkeSb5FtWZcju/ImH5d7X8h1zOXu" +
       "ksv7kktyySaReVuSu7wtL7vcTZQ6BhIbNeoaiew4QKL+iI20gS9BkKA3JFBR" +
       "tHYQI0AK59IWtZMgQJykBuIfTYu6bTrkfnedcxRB+tEP4HyzM/POvM877zzz" +
       "coZf/A50X5pAtTjyd44fZUd2kR0t/fZRtovt9Iik27yepLaF+XqazkDZC+bT" +
       "v3rjb773affmVeiaBj2mh2GU6ZkXhalgp5G/sS0aunFWOvLtIM2gm/RS3+hw" +
       "nnk+THtp9jwNfd850Qy6RZ+oAAMVYKACXKkAo2etgNBb7DAPsFJCD7N0Df0E" +
       "dIWGrsVmqV4GPXWxk1hP9OC4G75CAHq4v/wtA1CVcJFAT55iP2B+FeDP1OCX" +
       "fu5Hb/7aPdANDbrhhWKpjgmUyMAgGvRQYAeGnaSoZdmWBj0S2rYl2omn+96+" +
       "0luDHk09J9SzPLFPjVQW5rGdVGOeWe4hs8SW5GYWJafwFp7tWye/7lv4ugOw" +
       "vv0M6wHhuCwHAB/0gGLJQjftE5F7V15oZdB7L0ucYrxFgQZA9HpgZ250OtS9" +
       "oQ4KoEcPc+froQOLWeKFDmh6X5SDUTLo8Tt2Wto61s2V7tgvZNA7L7fjD1Wg" +
       "1QOVIUqRDHrb5WZVT2CWHr80S+fm5zvsBz/1YyERXq10tmzTL/W/Hwg9cUlI" +
       "sBd2YoemfRB86AP0Z/W3/+YnrkIQaPy2S40Pbf7Fj3/3wz/wxCtfO7R5123a" +
       "cMbSNrMXzM8bD//eu7Hn+veUatwfR6lXTv4F5JX788c1zxcxWHlvP+2xrDw6" +
       "qXxF+A/qR3/F/qur0IMT6JoZ+XkA/OgRMwpiz7cT3A7tRM9sawI9YIcWVtVP" +
       "oOsgT3uhfSjlFovUzibQvX5VdC2qfgMTLUAXpYmug7wXLqKTfKxnbpUvYgiC" +
       "roMHegg8T0OHv+p/Bn0UdqPAhnVTD70wgvkkKvGXExpaOpzZKchboDaOYAP4" +
       "/+oHkaMunEZ5AhwSjhIH1oFXuPahEjbTFLZDB2gIb3Q/t+F048AAT5RMSjcG" +
       "1qnWEKOHwFmSo9IT4/8PdChKO93cXrkCpvDdlwnEB2uPiHzLTl4wX8oHo+9+" +
       "+YXfuXq6oI4tnEE/BBQ5OihyVClyBBQ5OihyVClyBBQ5uqMi0JUr1fhvLRU6" +
       "uA+Y/BWgEUCwDz0n/gj5kU88fQ/w23h7L5i5sil8Z57HzohnUtGrCbwfeuVz" +
       "25+U/2H9KnT1ImGXIEDRg6U4X9LsKZ3eurxQb9fvjY9/+2++8tkXo7Mle2EH" +
       "OGaSV0uWTPD0ZXMnkWlbgFvPuv/Ak/pvvPCbL966Ct0L6AVQaqYDmwK2euLy" +
       "GBcY4fkTdi2x3AcAL6Ik0P2y6oQSH8zcJNqelVR+8HCVfwTYGIWOkwtrpqx9" +
       "LC7Ttx78ppy0Sygq9v77YvyLf/S7f9GszH1C9DfObZ2inT1/jlzKzm5UNPLI" +
       "mQ/MEtsG7f7r5/if/cx3Pv4PKgcALZ653YC3yhQDpAKmEJj5p762/k/f+ubn" +
       "v3H1zGkysLvmhu+ZxQHk34K/K+D5v+VTgisLDsTwKHbMTk+e0lNcjvy+M92A" +
       "L/tgoZYedEsKg8jyFp5u+Hbpsf/7xrPIb/y3T908+IQPSk5c6gdeu4Oz8u8f" +
       "QB/9nR/9H09U3Vwxy43yzH5nzQ7s+9hZz2iS6LtSj+In/+N7fv6r+i8CHgfc" +
       "mXp7u6JDqLIHVE1gvbJFrUrhS3WNMnlven4hXFxr5wKaF8xPf+Ov3yL/9W99" +
       "t9L2YkR0ft4ZPX7+4Gpl8mQBun/H5VVP6KkL2rVeYX/4pv/K90CPGujRBIyX" +
       "cgngouKClxy3vu/6f/63/+7tH/m9e6CrY+hBP9KtsV4tOOgB4Ol26gIaK+If" +
       "+vDBm7f3g+RmBRV6FfiDg7yz+nUvUPC5O3PNuAxozpbrO/8X5xsf+9P/+Soj" +
       "VCxzm338krwGf/EXHsc+9FeV/NlyL6WfKF7NzyD4O5Nt/Erw368+fe3fX4Wu" +
       "a9BN8ziylEv2BYtIA9FUehJugujzQv3FyOgQBjx/Smfvvkw154a9TDRn+wLI" +
       "l63L/IOXuOVdpZU/BJ73H3PL+y9zyxWoyny4EnmqSm+VyfurObkngx6IkygD" +
       "WtogGryWVmFsBjTxQt2vBnsOFFcbT1oJvy2Daq+9Rx1CQuBLB2or02aZoAeH" +
       "6NzReZ6vhiyuAI65r3HUPaqXv+k7KF9m/16ZjMpkfKLuO5a+eeuEd2QQhQO3" +
       "ubX0uyf636w8vpygYz0vKfnc31lJ4NEPn3VGRyAK/uSfffrr/+SZbwG3I6H7" +
       "KmMAbzs3IpuXLwY//cXPvOf7XvrjT1akChiV/+zo5ofLXqXXB/XxEqpYxTC0" +
       "nmZMxX22VaG962rjEy8A28XmOOqFX3z0W6tf+PaXDhHt5aV1qbH9iZf+0d8e" +
       "feqlq+feI555VSh/XubwLlEp/ZZjCyfQU3cbpZIY//lXXvw3/+zFjx+0evRi" +
       "VDwCL31f+oP/8/Wjz/3xb98mkLrXj97AxGYPf51opRP05I9BNH2OSkUxz+c6" +
       "ITsSSog4OkCdFblNJMNZ4vIoHU1Qy/DG8mQ1GyuKS8nNLDQRndCCgAvkcbai" +
       "hN16kGPJSFPFodrjFlO0ReGI5clIwQU2arJel4i9Aees6uMCVnmui8fMsp9y" +
       "Ik72unFo5Qt1iuACgRByNk6sblOBW7VNc54suOYK8/NI02VsT6QknMtqmHcb" +
       "8/58vY9JVo1VubkYrBmhZeLNZa1lwM3mGBXhnWsRdVQvmhjihEFd8orFdBt4" +
       "C4pLld2UFzOXmapCp49b1IRVxWhtukvZa0bbtbT2JiyZk5Kqbudg55DRLPan" +
       "s2jnU06uYmOmzpvKCpuTMeq2c4dXxfVgNLf0/ajOuU7HmHMMG4RZjLDSqL9m" +
       "3SbqCJIUjwYk0oi7Sn1IyquFGpCTeUfUko5Vz5OZxKaY3uQYiaelvrJoEnEU" +
       "TXRDneqKpsq78UKqRd5GHE2CsURLSL5aeeK8zteW0RrT8ZgNKEpZcdpsym31" +
       "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" +
       "436wNykAAA==");
}
