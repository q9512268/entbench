package org.sunflow.image;
public class BlackbodySpectrum extends org.sunflow.image.SpectralCurve {
    private float temp;
    public BlackbodySpectrum(float temp) { super();
                                           this.temp = temp; }
    public float sample(float lambda) { double wavelength = lambda * 1.0E-9;
                                        return (float) (3.74183E-16 * java.lang.Math.
                                                          pow(
                                                            wavelength,
                                                            -5.0) /
                                                          (java.lang.Math.
                                                             exp(
                                                               0.014388 /
                                                                 (wavelength *
                                                                    temp)) -
                                                             1.0));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wcRxmfOzvnR5z4kdhJ83AS24lkN9y2TUsoDmmTix07" +
                                                              "PSenOI2oA7nM7c7Zm+ztbnZn7bOLIYlUYpCI0uKmAbX+K1VLlDYVogIJWgUh" +
                                                              "+lALUh9QCqIFhESgRDQgCmqA8s3M7fPOrviDk25ub+abb77n7/tmL11Di2wL" +
                                                              "tROdJumkSexkn04z2LKJktKwbR+Auaz8SBX+2+Gre++Mo8QIWjqG7SEZ26Rf" +
                                                              "JZpij6C1qm5TrMvE3kuIwnZkLGITaxxT1dBHUKtqDxZMTZVVOmQohBEcxFYa" +
                                                              "NWNKLTXnUDJYYkDR2jRIInFJpB3R5d40apANc9InXxkgTwVWGGXBP8umqCl9" +
                                                              "FI9jyaGqJqVVm/YWLXSzaWiTo5pBk6RIk0e1O0om2JO+o8wEHc80fnDj7FgT" +
                                                              "N8EyrOsG5erZ+4ltaONESaNGf7ZPIwX7OPoiqkqjxQFiirrS7qESHCrBoa62" +
                                                              "PhVIv4ToTiFlcHWoyylhykwgijaEmZjYwoUSmwyXGTjU0pLufDNou97TVmhZ" +
                                                              "puLDN0uzjxxu+nYVahxBjao+zMSRQQgKh4yAQUkhRyx7h6IQZQQ16+DsYWKp" +
                                                              "WFOnSp5usdVRHVMH3O+ahU06JrH4mb6twI+gm+XI1LA89fI8oEr/FuU1PAq6" +
                                                              "tvm6Cg372TwoWK+CYFYeQ9yVtlQfU3WFonXRHZ6OXfcAAWytKRA6ZnhHVesY" +
                                                              "JlCLCBEN66PSMISePgqkiwwIQIuiVfMyZbY2sXwMj5Isi8gIXUYsAVUdNwTb" +
                                                              "QlFrlIxzAi+tingp4J9re7eduV8f0OMoBjIrRNaY/IthU3tk036SJxaBPBAb" +
                                                              "G3rS53DbczNxhIC4NUIsaL77het3b26/8pKgWV2BZl/uKJFpVr6QW/ramlT3" +
                                                              "nVVMjFrTsFXm/JDmPMsypZXeogkI0+ZxZItJd/HK/hfuO3GRvBdH9YMoIRua" +
                                                              "U4A4apaNgqlqxNpNdGJhSpRBVEd0JcXXB1ENPKdVnYjZffm8Teggqtb4VMLg" +
                                                              "/8FEeWDBTFQPz6qeN9xnE9Mx/lw0EUI18EUN8K1C4sN/KTosjRkFImEZ66pu" +
                                                              "SBnLYPozh+oKliix4VmBVdOQbEfPa8aEZFuyZFij3n+1AJ6XdmoQAjlDmRw2" +
                                                              "gYHlFJIszsz/+wlFpuOyiVgMzL8mmvywgwwYmkKsrDzr7Oy7/nT2FRFYLBlK" +
                                                              "1qGoEw5Llg5L8sOSZYehWIyfsZwdKtwLzjkGaQ4429A9/Pk9R2Y6wKhFc6Ia" +
                                                              "LMtIO0L1JuVjgQvgWfmve367ZWD602/EURzgIgf1xof99QHYZ/XKMmSiAOrM" +
                                                              "B/8uBErzA35FGdCV8xMnD37pFi5DEMcZw0UAQWx7hqGvd0RXNH8r8W08ffWD" +
                                                              "y+emDT+TQ4XBrWdlOxlAdEQ9GVU+K/esx89mn5vuiqNqQB1AWoohMwDE2qNn" +
                                                              "hICi1wVdpkstKJw3rALW2JKLlPV0zDIm/BkeYs38eTm4djHLnDXwTZRSif+y" +
                                                              "1TaTjStESLJYiWjBQf0zw+Zjv/jpH7dwc7v43xgo3MOE9gYwhzFr4ejS7Ife" +
                                                              "AYsQoPv1+czXH752+hCPO6DorHRgFxtTgDXgQjDzAy8df/vddy68GfdjlULR" +
                                                              "dXLQuxQ9Jdk8ql9ASThtky8PYJYGecKiputeHaJSzas4pxGWHP9q3Hjrs38+" +
                                                              "0yTiQIMZN4w2fzwDf/6mnejEK4f/0c7ZxGRWM32b+WQCiJf5nHdYFp5kchRP" +
                                                              "vr72Gy/ixwDSAUZtdYpwZIxVylfWwg07ORuyTi2AG8ZLRea2zBF5pivze1FA" +
                                                              "bqqwQdC1Pil97eBbR1/lTq5lec3mmd5LAlm7wxoNRFiTMP5H8InB9z/sy4zO" +
                                                              "JgRYt6RKFWO9VzJMswiSdy/Q44UVkKZb3j326NWnhALRkhohJjOzX/0oeWZW" +
                                                              "eE70HZ1lpT+4R/QeQh02fIpJt2GhU/iO/j9cnv7+k9OnhVQt4SraB03iUz//" +
                                                              "96vJ8795uQJ4QwoZWHSPW0LuXB72jlBp11caf3C2paofUGMQ1Tq6etwhg0qQ" +
                                                              "JzROtpMLuMvvaPhEUDnmGopiPeAFPn07F0PyhEFcGMTXdrOhyw6CZ9hZgd44" +
                                                              "K5998/0lB99//jpXONxcB7FiCJvC2s1s2MisvSJaoAawPQZ0t1/Z+7km7coN" +
                                                              "4DgCHGXoKO19FpTGYghZStSLan75wx+1HXmtCsX7UT1YWOnHHKRRHaAjsceg" +
                                                              "qhbNu+4W4DBRC0MTVxWVKc/ycV3lTO8rmJTn5tT3Vnxn2xNz73BQEii02nPk" +
                                                              "mlAd5RcyvwxcfGPrz5548NyECJ0FEiGyb+WH+7Tcqd/9s8zAvOpVyI3I/hHp" +
                                                              "0qOrUtvf4/v98sN2dxbLWxEo0P7e2y4W/h7vSPw4jmpGUJNcugAdxJrDQH0E" +
                                                              "mn7bvRXBJSm0Hm7gRbfa65XXNdHkDBwbLXzBiK+moej2ax3rGNEKtx64v8Fa" +
                                                              "F0P84bN8yyY+drNhs1taakxLhUsyidSWxQswpSAQKfDnraKWsnGADfcJNvdU" +
                                                              "ijyxtIkNPd5hXvEKNb7BQuYHG2L5s3a+uwlHqgunZueUfY/fGi9l9V0UEsIw" +
                                                              "P6GRcaJF4nZtKG6H+G3MD4L6L9+yLE2L+fLWj3Fpn6e565k/wKMHvHjqT6sO" +
                                                              "bB878j/0desiukdZfmvo0su7N8kPxfmFUsRc2UU0vKk3HGn1FoGbsx5G0w7P" +
                                                              "W81uvNWXvFVfubeq4GivY5lvawSbS4WCBxnnenwB8OaToGzCxgVT3Le2+kFZ" +
                                                              "WCAoy+GQTWSKFDWX3TEYUq4se4EhLt3y03ONtSvm7n2L97vexbgB2ou8o2nB" +
                                                              "ZA48J0yL5FWuQoNIbZP/TMHxZZceqKX8l4s8KQinKVocIKSsOPKnINEJiqqA" +
                                                              "iD2eNPnCSoiL8kuV0BNrKccaJ8VYOPM8a7Z+nDUDydoZSgf+isgNXUe8JMrK" +
                                                              "l+f27L3/+icfFw23rOGpKf5KAQq96P298N8wLzeXV2Kg+8bSZ+o2uunfLAT2" +
                                                              "g3J1IGgyEF4m8+mqSDdqd3lN6dsXtj3/k5nE61BGDqEYpmjZoXJ8L5oOoMmh" +
                                                              "dHlDA9DA2+Te7m9Obt+c/8uveAEtr5tR+qxc9+GZqQ12LBlHdYPgd10hRV54" +
                                                              "dk3q+4k8boW6o0TOcHTvTdJSFnyYvTriVikZc4k3yy5rFHWUN4rlF1joLCaI" +
                                                              "tZNxL3VbIbBwTDO4yq2aEq2X6Iirsukh03Q75Be41U2Tp9gsG3b9F7nS12f7" +
                                                              "FQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
