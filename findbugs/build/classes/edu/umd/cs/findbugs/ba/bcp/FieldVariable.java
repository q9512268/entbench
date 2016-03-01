package edu.umd.cs.findbugs.ba.bcp;
public class FieldVariable implements edu.umd.cs.findbugs.ba.bcp.Variable {
    private final edu.umd.cs.findbugs.ba.vna.ValueNumber ref;
    private final java.lang.String className;
    private final java.lang.String fieldName;
    private final java.lang.String fieldSig;
    public FieldVariable(java.lang.String className, java.lang.String fieldName,
                         java.lang.String fieldSig) { this(null, className,
                                                           fieldName,
                                                           fieldSig); }
    public FieldVariable(@javax.annotation.Nullable
                         edu.umd.cs.findbugs.ba.vna.ValueNumber ref, java.lang.String className,
                         java.lang.String fieldName,
                         java.lang.String fieldSig) { super();
                                                      this.ref = ref;
                                                      this.className =
                                                        className;
                                                      this.fieldName =
                                                        fieldName;
                                                      this.fieldSig =
                                                        fieldSig;
    }
    public boolean isStatic() { return ref == null; }
    public java.lang.String getClassName() { return className; }
    public java.lang.String getFieldName() { return fieldName; }
    public java.lang.String getFieldSig() { return fieldSig; }
    @java.lang.Override
    public boolean sameAs(edu.umd.cs.findbugs.ba.bcp.Variable other) {
        if (!(other instanceof edu.umd.cs.findbugs.ba.bcp.FieldVariable)) {
            return false;
        }
        edu.umd.cs.findbugs.ba.bcp.FieldVariable otherField =
          (edu.umd.cs.findbugs.ba.bcp.FieldVariable)
            other;
        if (isStatic(
              ) !=
              otherField.
              isStatic(
                )) {
            return false;
        }
        return (ref ==
                  null ||
                  ref.
                  equals(
                    otherField.
                      ref)) &&
          className.
          equals(
            otherField.
              className) &&
          fieldName.
          equals(
            otherField.
              fieldName) &&
          fieldSig.
          equals(
            otherField.
              fieldSig);
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.StringBuilder buf =
                                           new java.lang.StringBuilder(
                                           );
                                         buf.append(className);
                                         buf.append('.');
                                         buf.append(fieldName);
                                         return buf.toString(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZe5AUxRnv3Xtyd3AvXh7cHRwnCa9dNWrKHBDg4ODI3nHF" +
                                                              "AVUeyDI723s33OzMMNNzt2AwapUFWhWK6IEkpcQ/MBojQiVaMQ8tLMug5aPK" +
                                                              "V9SkxFRiJSbGKEn5qJBovq9nZuexO0tB5Kqmd677+77u7+vf9+iehz8gFYZO" +
                                                              "2qjCYmy3Ro3YGoUNCLpB092yYBiboC8p3l0m/Gv7e/3XRUnlEJkyIhh9omDQ" +
                                                              "HonKaWOItEqKwQRFpEY/pWnkGNCpQfUxgUmqMkSmSUZvVpMlUWJ9apoiwRZB" +
                                                              "T5BGgTFdSpmM9toCGGlNwErifCXxlcHhrgSpE1Vtt0s+00Pe7RlByqw7l8FI" +
                                                              "Q2KnMCbETSbJ8YRksK6cThZpqrx7WFZZjOZYbKd8jW2C9YlrCkzQcbL+k3MH" +
                                                              "Rxq4CZoFRVEZV8/YSA1VHqPpBKl3e9fINGvsIjeRsgSp9RAz0plwJo3DpHGY" +
                                                              "1NHWpYLVT6aKme1WuTrMkVSpibggRub6hWiCLmRtMQN8zSChmtm6c2bQdk5e" +
                                                              "W0vLAhUPLYpP3L294adlpH6I1EvKIC5HhEUwmGQIDEqzKaobK9Npmh4ijQps" +
                                                              "9iDVJUGW9tg73WRIw4rATNh+xyzYaWpU53O6toJ9BN10U2SqnlcvwwFl/1eR" +
                                                              "kYVh0HW6q6ulYQ/2g4I1EixMzwiAO5ulfFRS0oy0BznyOnZ+CwiAtSpL2Yia" +
                                                              "n6pcEaCDNFkQkQVlOD4I0FOGgbRCBQDqjLSECkVba4I4KgzTJCIyQDdgDQHV" +
                                                              "JG4IZGFkWpCMS4Jdagnskmd/PuhfeuBGZZ0SJRFYc5qKMq6/FpjaAkwbaYbq" +
                                                              "FPzAYqxbmDgsTH9if5QQIJ4WILZofv7tsysWt5161qKZVYRmQ2onFVlSPJaa" +
                                                              "8vLs7gXXleEyqjXVkHDzfZpzLxuwR7pyGkSY6XmJOBhzBk9t/M31Nz9E34+S" +
                                                              "ml5SKaqymQUcNYpqVpNkqq+lCtUFRtO9ZBJV0t18vJdUwXtCUqjVuyGTMSjr" +
                                                              "JeUy76pU+f9gogyIQBPVwLukZFTnXRPYCH/PaYSQKnhIDJ4WYv3xX0aS8RE1" +
                                                              "S+OCKCiSosYHdBX1N+IQcVJg25F4BsCUMoeNuKGLcQ4dmjbjZjYdFw13MCXE" +
                                                              "U6IW58ES3FESUjKNIbV26afIoZbN45EIbMDsoPvL4DnrVDlN9aQ4Ya5ac/aR" +
                                                              "5PMWtNAdbPsw8lWYMQYzxkQj5swYSwkxmDHmm5FEInyiqTiztcuwR6Pg7RBu" +
                                                              "6xYM3rB+x/6OMoCXNl4OBo4CaYcv7XS7IcGJ40nxRNPkPXPPXPl0lJQnSJMg" +
                                                              "MlOQMYus1IchPomjtgvXpSAhuXlhjicvYELTVRHU0GlYfrClVKtjVMd+RqZ6" +
                                                              "JDhZC/0zHp4ziq6fnDoyfsuW71wRJVF/KsApKyCKIfsABvB8oO4MhoBicuv3" +
                                                              "vffJicN7VTcY+HKLkxILOFGHjiAUguZJigvnCI8ln9jbyc0+CYI1E8C5IA62" +
                                                              "BefwxZouJ26jLtWgcEbVs4KMQ46Na9iIro67PRyjjfx9KsCiFp1vJjxLbG/k" +
                                                              "vzg6XcN2hoVpxFlAC54Xlg1q97750l+/xs3tpJB6T+4fpKzLE7ZQWBMPUI0u" +
                                                              "bDfplALd20cG7jr0wb6tHLNAMa/YhJ3YdkO4gi0EM9/27K633jlz7LVoHucR" +
                                                              "BnnbTEH5k8srif2kpoSSMNt8dz0Q9mSIC4iazs0K4FPKcI9Dx/pP/eVXPvb3" +
                                                              "Aw0WDmTocWC0+PwC3P7LVpGbn9/+aRsXExEx7bo2c8msWN7sSl6p68JuXEfu" +
                                                              "lldav39auBeyAkRiQ9pDeXAt4zYo45rPhCqMc2KGjVkZFvuv5Q3f12s44RW8" +
                                                              "vRptwtkJH7sOm8sNr3/4XdBTQSXFg699NHnLR0+e5Qr5SzAvHPoErctCIDbz" +
                                                              "cyB+RjB+rROMEaC7+lT/tgb51DmQOAQSRag7jA06hM+cDzw2dUXV7556evqO" +
                                                              "l8tItIfUyKqQ7hG4H5JJ4ADUGIHIm9O+ucLa//FqaBq4qqRA+YIO3IP24ru7" +
                                                              "Jqsxvh97Hp/x6NIHjp7hQNS4iNZCJ1tm429ZcSfD9ivYLCqEbhhrYAfL+ZrL" +
                                                              "HQDMD8kmY4oQ2yLIJu03sch0YeFio7cENvqwWc2HvoHNGstoyy7SvtjRrVkD" +
                                                              "s2wFIIP6shXPfW7AfOjVr7/+wPcOj1v104LwLBHgm/nvDXLq1j9+VoBTnh+K" +
                                                              "1HYB/qH4w/e0dC9/n/O7gRq5O3OFWR+Snct71UPZj6Mdlc9ESdUQaRDt0wbf" +
                                                              "Bgh/Q1BhG84RBE4kvnF/tWyVhl35RDQ7mCQ80wZThFttwDtS4/vkQFZown3p" +
                                                              "gGeWjbpZQcBGCH+53sIsbxdis8QqNhip0nQJTqSw8goAniAHonFjCeGMlOk0" +
                                                              "g6/rXb/gOBs6H84G/SrMg6fVnqU1RAUxRAV8vQGb7UWWHiaUASbwBNFvG/na" +
                                                              "gALpi1Cg3Z6rPUSB0YtRIEwoKMCPhWEKyBeoAIJorj3X3BAFjItRIEwoI9Vc" +
                                                              "gUFpuNj6WYn154oFYP5XSQLHlWAAtqJWxAm780oU8U79jrmvNez0yU/Ox26d" +
                                                              "OJrecP+VVoxr8p/o1ihm9vhv//tC7MgfnityjJjEVG2JTMeo7FlfJU7pi6p9" +
                                                              "/GDuhqi3p9z5p190Dq+6kPIf+9rOU+Dj/+2gxMLwQB1cyulb/9ayafnIjguo" +
                                                              "5NsD5gyK/HHfw8+tnS/eGeW3EFbsLLi98DN1+SNmjU6ZqSubfHFzXh4szU44" +
                                                              "W2uDZW0Q8udP9GGsJdLxgRJjB7G5HbxCMqwLJv85EDd30EwZcGaTslCij9l3" +
                                                              "GFcN7BD3dw68a2HvsiIMFt20B+Pf3fLGzhf4LlUjLPK28UAC4OM5fTRYSn8B" +
                                                              "fxF4PscH14sd+AvJrtu+kJiTv5HQNHSYEok+oEB8b9M7o/e8d9xSIJjVA8R0" +
                                                              "/8QdX8QOTFiOZF1rzSu4WfLyWFdbljrYHMLVzS01C+fo+cuJvb96cO++qL07" +
                                                              "t0CiTKmqTAUlv3sRO5bAkctvdmutq2+v//XBprIecNFeUm0q0i6T9qb9MK0y" +
                                                              "zJRnH9ybMBe09qrR5oxEFmp2+cWD5B1fRjnH+2/zZ4M2ePptfPdfuGuEsZaA" +
                                                              "/09KjB3H5keM1A1T1u3L2q4pHriUpths67P5wk0RxlpC3cdLjP0Sm59Zpujx" +
                                                              "5X/XFI9eKlNgEbXN1mfbhZsijLWEus+UGDuNzSlGah1TOJWEa4mnLoEleOq4" +
                                                              "DB7BVkcoYYlgqRTB11iRC48wYQH9I66Um/g8r5Yw0OvYvMigmgCMrOQkE65t" +
                                                              "XvLbpi5vm3xx1OReSmyA8kCX0rRETfb/QQuLNcW2gfJlGDRMWAl7vVti7M/Y" +
                                                              "nIHszFTPBY1rzXdCrYndb30pdssxMtl3s4z3HTMLvl5ZX1zER47WV884uvkN" +
                                                              "XiHmv4rUQfLPmLLsPVx63is1ONBJXOM666ip8Z8PGWkJL5XhHAgtX/Y/LPp/" +
                                                              "MjK9OD0jUSg+PKQfM9JchJQfD6xXL/VnjNS41CBM9A2fgzRtD8OioPUOfg5d" +
                                                              "MIivX2gOyD03b9ZpPRfxFOLEk2ynnS+Y5Fm8V6JY/vDvkE59YFpfIpPiiaPr" +
                                                              "+288e+391pUsnEb37EEptVAVWLfD+XJ5bqg0R1blugXnppycdLlTrjRaC3Yd" +
                                                              "Z5YHy92ASg2x0xK4rzQ689eWbx1b+uSL+ytfgUJrK4nArjVvLbzXyGkmnFO2" +
                                                              "JgqrHwehXQt+sHv54syHv+fXbcSqlmaH0yfFobve7D05+ukK/uGrAhBAc/zC" +
                                                              "ZfVuZSMVx3RfKTUFYS2gO3I72OabnO/FC3xGOgoLxMLPHjWyOk71VaqppFEM" +
                                                              "FGO1bo9zTPKdMExNCzC4PZ4i+ofYHMqh9QF/yUSfptn1c2SXxj37vmLh/T5k" +
                                                              "jjTxV3xr/h96RZ3ZkiAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0JAoZXBtwPnktO9gA8LHSEXW0vpUrDNap4shXib0h8vhdAh+HcTp8p7Y5UzO" +
       "GfCcnERlRlsMfdeOzXQaiM1FMnUWtqWlcpsdSQI9RjqObISkI/ViW+LmJWE1" +
       "q3VbixkJI1s6wLbWqmZ4LX9jRMmkXl4LXYmCe1Ez6G3IHmNETSIlGv4A4xY+" +
       "YWlJiqaG0bW0fl0aaXKJ7rHLjGEHVIe2rebYTGZdy0w9kmk4Hm6rGw0pkTKY" +
       "Kw2yyjRrFUI31tnMT7qVms3GE1Nrq1KE9Tgeq/UV3GJCv1YfChvbNjK8F5EW" +
       "FZTTrp2xagdepluzNtX6lYUvBRnlNMkqNnXM8gqv16uIU4KzCI2DLlEblTAj" +
       "6G3Zdn3GTwhuOGaQRG0ZgdNk5xVE69TtEFmrtZhm+01OgeVFF5XnywFmWkib" +
       "w+FKvVdDUdvZ1lnJpxNNIDxPHbXp6rIRAcdaWQa+KHL9uDHfIjzuigyJWco2" +
       "QnoYNexpDN7K4GAI69J0mKpoc41MWu7I1yYkUhquSXQIeg06qofDJUWIpu2s" +
       "ndVVv6I13GjSr0eiUwtqjW4ybRuJ48yVFMWVhNA3zaVg8XjQ0qfNGNvKPlYN" +
       "hwtyxWmVXseWwPRIk7TKo0a5EmGYMGmkQhCv42WXrkcDtxH1QxTGpnNixItT" +
       "yqzheJ/2WAEp6VU+rIrbZkoP/XaoxSTTUrfahigJNlEKhQEH/Fa95Izg2FSr" +
       "5ZbLD5q8KChm3W4itQVX0lrbdWU+nkr1arWmp6uB04iZmDHGm96Kry86GF3t" +
       "drFma9xhaMbFB6VEYxUYplYKscJWK6FZkpkBygwrWJjUu6soSxd4nQ7grNZn" +
       "aDuoL/i+iFn9Gdktxy5WwWeaaLRwK5VZctVWF4tQbhpsaRayNN/iWo2lK2M+" +
       "X9mwTDdB0EhbILJOWX5da/fT1XqiVejUp/udKPY3m7qYxrYQSstWVFlTDDOs" +
       "RYvp0JjUm8bAlsI6XFoPtYFdTssIxq5ZgjZd2EtbU3ZVtvGS5BMjb1HqlWmZ" +
       "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" +
       "cf/19y9YlD0CKwAA");
}
