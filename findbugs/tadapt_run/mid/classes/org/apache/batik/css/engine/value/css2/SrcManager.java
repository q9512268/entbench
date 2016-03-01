package org.apache.batik.css.engine.value.css2;
public class SrcManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NONE_VALUE); }
    public SrcManager() { super(); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_DESCRIPTOR_SRC_VALUE;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_SRC_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_STRING_VALUE:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                            }
                                            org.apache.batik.css.engine.value.ListValue result =
                                              new org.apache.batik.css.engine.value.ListValue(
                                              );
                                            for (;
                                                 ;
                                                 ) {
                                                switch (lu.
                                                          getLexicalUnitType(
                                                            )) {
                                                    case org.w3c.css.sac.LexicalUnit.
                                                           SAC_STRING_VALUE:
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.StringValue(
                                                              org.w3c.dom.css.CSSPrimitiveValue.
                                                                CSS_STRING,
                                                              lu.
                                                                getStringValue(
                                                                  )));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        break;
                                                    case org.w3c.css.sac.LexicalUnit.
                                                           SAC_URI:
                                                        java.lang.String uri =
                                                          resolveURI(
                                                            engine.
                                                              getCSSBaseURI(
                                                                ),
                                                            lu.
                                                              getStringValue(
                                                                ));
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.URIValue(
                                                              lu.
                                                                getStringValue(
                                                                  ),
                                                              uri));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        if (lu !=
                                                              null &&
                                                              lu.
                                                              getLexicalUnitType(
                                                                ) ==
                                                              org.w3c.css.sac.LexicalUnit.
                                                                SAC_FUNCTION) {
                                                            if (!lu.
                                                                  getFunctionName(
                                                                    ).
                                                                  equalsIgnoreCase(
                                                                    "format")) {
                                                                break;
                                                            }
                                                            lu =
                                                              lu.
                                                                getNextLexicalUnit(
                                                                  );
                                                        }
                                                        break;
                                                    case org.w3c.css.sac.LexicalUnit.
                                                           SAC_IDENT:
                                                        java.lang.StringBuffer sb =
                                                          new java.lang.StringBuffer(
                                                          lu.
                                                            getStringValue(
                                                              ));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        if (lu !=
                                                              null &&
                                                              lu.
                                                              getLexicalUnitType(
                                                                ) ==
                                                              org.w3c.css.sac.LexicalUnit.
                                                                SAC_IDENT) {
                                                            do  {
                                                                sb.
                                                                  append(
                                                                    ' ');
                                                                sb.
                                                                  append(
                                                                    lu.
                                                                      getStringValue(
                                                                        ));
                                                                lu =
                                                                  lu.
                                                                    getNextLexicalUnit(
                                                                      );
                                                            }while(lu !=
                                                                     null &&
                                                                     lu.
                                                                     getLexicalUnitType(
                                                                       ) ==
                                                                     org.w3c.css.sac.LexicalUnit.
                                                                       SAC_IDENT); 
                                                            result.
                                                              append(
                                                                new org.apache.batik.css.engine.value.StringValue(
                                                                  org.w3c.dom.css.CSSPrimitiveValue.
                                                                    CSS_STRING,
                                                                  sb.
                                                                    toString(
                                                                      )));
                                                        }
                                                        else {
                                                            java.lang.String id =
                                                              sb.
                                                              toString(
                                                                );
                                                            java.lang.String s =
                                                              id.
                                                              toLowerCase(
                                                                ).
                                                              intern(
                                                                );
                                                            org.apache.batik.css.engine.value.Value v =
                                                              (org.apache.batik.css.engine.value.Value)
                                                                values.
                                                                get(
                                                                  s);
                                                            result.
                                                              append(
                                                                v !=
                                                                  null
                                                                  ? v
                                                                  : new org.apache.batik.css.engine.value.StringValue(
                                                                  org.w3c.dom.css.CSSPrimitiveValue.
                                                                    CSS_STRING,
                                                                  id));
                                                        }
                                                        break;
                                                }
                                                if (lu ==
                                                      null) {
                                                    return result;
                                                }
                                                if (lu.
                                                      getLexicalUnitType(
                                                        ) !=
                                                      org.w3c.css.sac.LexicalUnit.
                                                        SAC_OPERATOR_COMMA) {
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                                }
                                                lu =
                                                  lu.
                                                    getNextLexicalUnit(
                                                      );
                                                if (lu ==
                                                      null) {
                                                    throw createMalformedLexicalUnitDOMException(
                                                            );
                                                }
                                            }
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9+h7v7z8/QoZ1OcU918BvIn/7NLiO//0SR6ThecqkHAE8HujRx6b1HbrhwLf" +
       "cyGIPTOTH2TAyXq48w+n/h5uLv9tmFT0kjrFSYHXYggBw+yFtM9282JIk3PW" +
       "c1M4ma+0Zl3klKD78h0bdF5ecIMxQuN4dMBfTUYp3gptvmPK84P+KkTEYLlA" +
       "mS36OdjdIERYxkmVaRkcbskgbS23Rb7N4SaqTrWAy5hU4hzAFSHWFigTObn+" +
       "6tFYJrig0NKnYr8QuxXy3C8V0mC5NBu7udnbiU95MH3yOzRPaQna4dRiGa7I" +
       "zg/t3Hsw0fX4PKmyDblZ4zIoip74/b9fi+x/55UCSUgVN8wbNTbINN+ZlXDk" +
       "jDxD6RQFgKd1C09dLjv30MSa/JwBd2oqkhHMLW5RwQNe2vnBpDW3DmwYRjIw" +
       "LcCo4JY/7jzyyvLZykNhUcNIJc+rfXKRWnNVu9piUKzpa3IUvDkr2rEostnQ" +
       "FjuiXVw4IBfQimyYK4ZaIiCwEmv92G3gZKxqd+gDUH2C6UAOIwpMEUJ8gsYH" +
       "h5503ObdlpqCkD/olENPNV7e/JuKrUvdUqcQioS8w+488fyK831CaJWoFVlW" +
       "+TRiidXvy2fqJA8+hU8I2n+w4fVxQhYWDW1OdTM9W96YJlpGCQcdICG6reHt" +
       "TY+9/4QkIeiNA8Bs9977P408sFdajKyRZ+aVqX4cWSdLcrDTMsKISpwiMNrP" +
       "P7Xt5z/ativsCOsrnFTEDUNjVM8KM5SNXo1Bxsvbls878I/t3zzTBelnB6lM" +
       "6+rmNOtI5OpthZ2O+yThFdaeFjv3Rq5zEpprOsFT+DhawsflR2mcWCym1+da" +
       "xnXQ2h31bh++ZRRDLaH9O0qs3YfdPZyMU+0lupqiHLM81zRwbZPHgG2fDQNm" +
       "Qet0qOgcPgOKoZYg8tsl1r6D3W4wLxWfqIRmFiH/W9dMfi0uNUFb49CwZvjk" +
       "F0MtQeIjJdYexW4vZMH9jLt0Z0st1bFi/NJ9Y6jqylTngdFnnfhzyGcw+66Z" +
       "YQ24NAPaeofq9cNnWDHUEkw5XGLtCHaP5zJsFfgYN4mqE6k5ppJOsuTx4wfX" +
       "zI96XJoOLeEQlRg+P4qhlqD5uRJrz2P3U8mPpSxJ05rMql1+XHf1pNKDF2x6" +
       "5rNh0xRomkOrNnw2FUMNsCIs7hF2qZ2M1A4tUASRNlUiMZZRFardqavchZlV" +
       "iiNtPT3LxEhc8cXAaW4YdHaa6J6WMFKRpV2dyzIKMzE9FMivYXeck1GKxSBb" +
       "EFzGqV94rP7VNbMaH17ITGjHHX4dHz6ri6GW0LozJdbOYvcGJ2NAIzsSTOdq" +
       "UmUy++72SD89fNIznFR7L5FYh0/M+3NEPugrTx6srZxw8M4/iNew7KN7DaSD" +
       "ybSm+ctE37jctFhSFTTUyKLRFF/vcjL7f3so5WQEfon7vyOR/8zJjKsiQ/U4" +
       "mDVCB/G8o81FEKF6lAM/zgeQSBTCgXgBvR/yAnjKICTcQnz74S4Czz04OFQO" +
       "/CB/hd0BBId/M13TWHB1hnm64Ug0E8otOrO6Mv5quuKrU2fmZOPiPzY3WU3L" +
       "f9mglDi4ctXdl255XL45KhrduhV3GQUpqnz+zBZzM4ru5u5VvmLOlTFPV81y" +
       "s+d6eWHP6ib7TAPKqZCJijsp8CBnt2Tf5d48tOjo67vLT0Hev46EKBRN6/Kf" +
       "RzJmGirNdbFCyTiUuuKtsLX6vQ0nPjkbahCvUESm702lMPqUPUfPdSdN83th" +
       "UtVBRkJxwDLi7WbpFn01UwatnNy+PG6k9ezfcWPQyihGXMEZh6Gjs7P4Zs1J" +
       "c34Fk/+OX60ZQ8y6HXfHbUYHyt+0afpXBWcHsdMyyGlQx75Yp2k6pVvZVMF5" +
       "00QnEqrAH0P/BbNYo29IHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DSivF4WPg0c+QSm//ig/d4e6ny2Sf5pC1xdWegrv7DDykh3f5ZzceylR/7PX" +
       "gPrhovBJ8Hz4BPWHX3/U/+oOdV8qki9cRC2c+J/RAeIXXwPEcgl4AjzmCUTz" +
       "9Yf4H+5Q9+Ui+Xd7iG1rrq3d/XnT6RHFe175iOVAX2rjl16rNt4OHvdEG+7r" +
       "o42jkuDoFNTbClDbilFiSTTjmLMyx9BcxXfSU5qn7wS8JUl0mSt7+41LvV05" +
       "ufZw0tKjp72ZgXfcHvB0ZlhhsXiWzL9TJF9JoTcYsaWlVqnMouhXDhr96mvQ" +
       "aHEnAHoKPF8+0eiXX3/7+tod6v64SP4ghR4E9sWalp8Wx0L7e2PsAeF/fTUI" +
       "wZJ67XAZpThZf/Rl9+P2d7qML7xw/b63vqD8l/I+xtm9q/s56L752nXPH4Se" +
       "y18NY2vulNLfvz8WDcvX11Po3X+3uzIpdHfxKiX/0z3zN1LoyVdkTk8O6s4z" +
       "/u8Tc70NYwpd3WfO87wElt1b8QDfDNLzlP8nhW5cpgRSlO/zdH8BdH6gA53u" +
       "M+dJ/hK0DkiK7LfCU9uvvLLCDlZxMqLZlYsh75mVPPxKVnIuSn7qQmxbXrM8" +
       "jUPX+4uWzxpffKEnfM9L1Z/Z33oxXC3Pi1bu46B79xdwzmLZJ2/b2mlbV7vv" +
       "/daDv3j/06dx94N7gQ+T65xs77z1FRPaC9PyUkj+b9/6r7/j5174w/JM9m8B" +
       "Qn7ZwP8qAAA=");
}
