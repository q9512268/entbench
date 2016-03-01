package org.apache.batik.css.engine.value.css2;
public class ClipManager extends org.apache.batik.css.engine.value.RectManager {
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_CLIP_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.InheritValue.
                                                             INSTANCE;
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
                                            }
                                            return super.
                                              createValue(
                                                lu,
                                                engine);
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
                  CSS_AUTO_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public ClipManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe2wUxxmfO9tn+zD4ARjKw2BjSHjdlUeCqqMtYAwcnPEJ" +
       "A2lNm2Nub85es7e77M7ZhxNKQGpA+QNFQBLSFtRKoDQRgaht+kgV5KiPJEpS" +
       "BInSkLShD7VJH0jhn9CItuk3M7u3e3u+cyyQetLO7c1833zP+c18c+euoyrT" +
       "QG06VlM4RPfpxAzF2XscGyZJdSjYNLdDb0J65I/HD9x8s/agHwV60aR+bHZJ" +
       "2CQbZKKkzF40W1ZNilWJmFsJSTGOuEFMYgxiKmtqL5oqm9GMrsiSTLu0FGEE" +
       "O7ERQ42YUkNOZimJWhNQNCfGtQlzbcJrvQSRGKqTNH2fwzCjgKHDNcZoM448" +
       "k6KG2AAexOEslZVwTDZpJGegxbqm7OtTNBoiORoaUO6xHLE5dk+RG9qeq//4" +
       "1qP9DdwNk7GqapSbaG4jpqYMklQM1Tu9nQrJmHvRN1BFDE1wEVPUHrOFhkFo" +
       "GITa9jpUoP1EomYzHRo3h9ozBXSJKURRa+EkOjZwxpomznWGGWqoZTtnBmvn" +
       "5q21w+0x8bHF4RNP3N/wgwpU34vqZbWHqSOBEhSE9IJDSSZJDHNtKkVSvahR" +
       "hYD3EEPGijxsRbvJlPtUTLOQArZbWGdWJwaX6fgKIgm2GVmJakbevDRPKutX" +
       "VVrBfWBrs2OrsHAD6wcDgzIoZqQx5J7FUrlHVlM8jwo58ja2bwECYK3OENqv" +
       "5UVVqhg6UJNIEQWrfeEeSD61D0irNEhBg+daiUmZr3Us7cF9JEHRdC9dXAwB" +
       "VS13BGOhaKqXjM8EUZrhiZIrPte3rj76gLpJ9SMf6JwiksL0nwBMLR6mbSRN" +
       "DALrQDDWLYo9jptfPOJHCIineogFzU8evLFmScvIK4Jm5ig03ckBItGEdCY5" +
       "6fKsjoVfqGBq1OiaKbPgF1jOV1ncGonkdECa5vyMbDBkD45s+/VXH3qG/MOP" +
       "glEUkDQlm4E8apS0jC4rxNhIVGJgSlJRVEvUVAcfj6JqeI/JKhG93em0SWgU" +
       "VSq8K6Dx3+CiNEzBXBSEd1lNa/a7jmk/f8/pCKFqeFAdPHcj8eHfFJnhfi1D" +
       "wljCqqxq4bihMftZQDnmEBPeUzCqa+Ek5P+epctCq8KmljUgIcOa0RfGkBX9" +
       "RAyGJdMME7UPNAwPYiVLWMdySCJZ78Iq5IcRYsmn/3/E5pg3Jg/5fBCoWV6Y" +
       "UGCFbdKUFDES0onsus4b5xOviRRky8byI0XLQXZIyA5x2SEQFRKyQ1w261ge" +
       "cslGPh8XOYXpIPICoroH8AEAum5hz9c37z7SVgEJqQ9VQkgY6YKiDavDARIb" +
       "/RPSucvbbl56I/iMH/kBa5KwYTm7RnvBriE2PUOTSApgq9T+YWNouPSOMaoe" +
       "aOTk0MGdBz7P9XBvBGzCKsAwxh5n8J0X0e4FgNHmrT/84ccXHt+vOVBQsLPY" +
       "G2IRJ0OYNm+AvcYnpEVz8fOJF/e3+1ElwBZANcUQRUDBFq+MAqSJ2KjNbKkB" +
       "g9OakcEKG7KhNkj7DW3I6eGZ18iaqSIJWTp4FOSA/8Ue/dQ7v/nbCu5Je2+o" +
       "d23qPYRGXHjEJmviyNPoZNd2gxCg+/3J+PHHrh/exVMLKOaNJrCdtR2AQxAd" +
       "8OA3X9l79dr7Z97yO+lIYUPOJuFsk+O2TPkUPj54/ssehiGsQ2BJU4cFaHPz" +
       "iKYzyQsc3QDbFFjoLDnad6iQfHJaxkmFsLXw7/r5y57/59EGEW4FeuxsWTL2" +
       "BE7/59ahh167/2YLn8Ynsb3V8Z9DJgB7sjPzWsPA+5geuYNXZj/5Mj4F0A9w" +
       "a8rDhCMo4v5APIAruS/CvF3hGbuXNe2mO8cLl5HrDJSQHn3ro4k7P7p4g2tb" +
       "eIhyx70L6xGRRSIKIGwpspoCRGejzTprp+VAh2le0NmEzX6YbOXI1q81KCO3" +
       "QGwviJUAVs1uA9AvV5BKFnVV9bsv/aJ59+UK5N+AgoqGUxswX3CoFjKdmP0A" +
       "nDn9y2uEHkM10DRwf6AiDzGnzxk9nJ0ZnfIADP902o9WP3X6fZ6FIu1mWuz8" +
       "x3ze3s2axSJJ2euSXN41/BMo45rCOQ00u9R5hJ+lzhw6cTrVfXaZODU0Fe7x" +
       "nXCEffbt/7weOvmHV0fZMGqppi9VyCBRXDJrQGRrEcZ38eOag0+rrtyseO/Y" +
       "9LpieGcztZQA70Wlwdsr4OVDf5+x/Uv9u8eB23M8jvJO+XTXuVc3LpCO+fmJ" +
       "U0B20Um1kCnidhkINQgcrVVmFuuZyLO+LR/aySxkC+z0t7/dWS8AlucJazry" +
       "rDzawTKsZRb19jJjO1nTTdFkqALVfqgVAPdgu+HlAIcBV6BZediTTZo0bsgZ" +
       "gPBB6/B6ofnm3l9WD6+3D6ajsQjKLWbXpRc2fZDgQathWZF3lSsj1hp9rq2n" +
       "gTVLWaIvLFMMFmoU3t90bc93PnxWaOQ9e3uIyZETj3waOnpCLABRoMwrqhHc" +
       "PKJI8WjXWk4K59jwwYX9P//+/sN+y/cbKapOappCsJqPjS9/jmr2+lFoG1h2" +
       "6pMDD7/TDRt/FNVkVXlvlkRThWlYbWaTLsc6VY2TlJbebP+jyLdIt6BqFWvi" +
       "4j3y2TCRdazh3VsKE/0ueFZa2bpy/IleirVMMqtlxjizTNEU2VyryhlM2cZr" +
       "Zzob63UcMHBnHDAfnohlRWT8DijFWsbI4TJjD7ImCwcdmd0P8MwsYf7gbZtf" +
       "z4Za4Fln2bBu/OaXYi1j4sNlxo6w5iAcTPoIte3OH3K/Yq1i9rXL9Z6gqEK2" +
       "bndcq5P9TLkWzKHbdlgTG2qFJ2pZHR2/w0qxlnHKE2XGnmTNsUKHbQWM4cTT" +
       "KWrgByF2FRMSVzGOP47ftj8a2dBceOKWUfHx+6MUaxmbz5YZe4o13xX+WE/S" +
       "OKvQnaxmtv1x19jVtUPP3fS9O+OmWfDcZ9l63/jdVIrV4wo/18NvWzuTWTu0" +
       "QuJGmlgKxUhOlrCyQ5WpTTO/nEc6eno6+RtX8YceafY2aM003ZaW0jKh9d1d" +
       "nTmJ6Oy0x5l/xprzFE2QDAJ1G/cy63racfWFO+PqNngGLH8NjN/VpVg9xldw" +
       "PSrGQqYqKF2MEtjE2m+z5sf89Veju5f9fIETvM6aEYoahQvFgh7NkS+N35E5" +
       "iIzrSokVUdOLLrrF5ax0/nR9zbTTO37LrzXyF6h1cFhMZxXFdcRxH3cCukHS" +
       "MrejTtSZOv96k6IFn+3Ki6JK9sUNuCKY36aodUxmCMJgfk1bjFetxVGCkaKA" +
       "eHHz/A7OJaPxwPYDrZvyGgCvlxK04N9uuj9RFHToQKh4cZP8BWYHEvb6V91e" +
       "aUvHdtg2qHmtWOZ8xQUuT5OpY6WJq36dV3Cs5/+U2KferPivBEqM05u3PnDj" +
       "3rPibklS8PAwm2UCnHXFDVa+yGstOZs9V2DTwluTnqudbx/DC+623Lrx7IVl" +
       "wu+BZnguW8z2/J3L1TOrL75xJHAFCohdyIehmNrl+p9CXMpHcnoWKtBdsdFO" +
       "9VAC83ugSPDPuy/9611fE788QKIOaCnHkZCOX3wvntb1b/lRbRRVQZVBcr0o" +
       "KJvr96kQqEGjoEgIJLWsmv9TZRJbX5itdO4Zy6ET873s2pGituJSqPgqNqho" +
       "Q8RYx2Zn00z0lMVZXXePcs9KAs2YpyERE7EuXbdu4yp4cbJG1zl+fMIR7X+d" +
       "w9rQDh0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVae+zrVn33/d3eRy+l9/YWSlf67m2hhP6c2HlZF1iT+JHY" +
       "SezYiZN4jItfcez4FT8SJ9CNhza6oQHaWgYa9J8VjaFC0QQb0gTqNjFAoG1M" +
       "aBuTRtE2bTBAo5vGprGNHTu/9310VSstko+dc77f7/l+vud7vufrc/zUD6AT" +
       "YQDlfM9eGbYXbetJtG3Zpe1o5evhNt0ucXIQ6lrDlsOwD+ouqfd++uyPfvyB" +
       "6bkt6KQE3Sy7rhfJkem5Ia+Hnr3QtTZ0dr+WsHUnjKBzbUteyHAcmTbcNsPo" +
       "Yht62QHWCLrQ3lUBBirAQAU4UwGu7VMBppfrbuw0Ug7ZjcI59HPQsTZ00ldT" +
       "9SLonsNCfDmQnR0xXIYASDid/hcBqIw5CaC797BvMF8G+PEc/Nivv+Xc7xyH" +
       "zkrQWdMVUnVUoEQEOpGgGxzdUfQgrGmarknQTa6ua4IemLJtrjO9Jeh8aBqu" +
       "HMWBvmektDL29SDrc99yN6gptiBWIy/YgzcxdVvb/XdiYssGwHrLPtYNQjKt" +
       "BwDPmECxYCKr+i7LdTPT1SLorqMcexgvMIAAsJ5y9Gjq7XV1nSuDCuj8Zuxs" +
       "2TVgIQpM1wCkJ7wY9BJBt11VaGprX1ZnsqFfiqBbj9JxmyZAdX1miJQlgl55" +
       "lCyTBEbptiOjdGB8ftB9w/ve5jbdrUxnTVftVP/TgOnOI0y8PtED3VX1DeMN" +
       "r2t/UL7l849uQRAgfuUR4g3N7739uYdff+czX97QvPoKNKxi6Wp0SX1SufHr" +
       "tzcexI6napz2vdBMB/8Q8sz9uZ2Wi4kPZt4texLTxu3dxmf4Px6/4xP697ag" +
       "My3opOrZsQP86CbVc3zT1gNKd/VAjnStBV2vu1oja29Bp8Bz23T1TS07mYR6" +
       "1IKus7Oqk172H5hoAkSkJjoFnk134u0++3I0zZ4TH4KgU+CCbgDXa6HNL7tH" +
       "UAhPPUeHZVV2TdeDucBL8acD6moyHOkheNZAq+/BCvD/2UOF7QocenEAHBL2" +
       "AgOWgVdM9U0jrIYhrLsG0BBeyHaspxUIcCLT78gu8I9gO3U+//+n2yS1xrnl" +
       "sWNgoG4/GiZsMMOanq3pwSX1sbhOPPepS1/d2ps2O3aMIAT0vb3pezvrext0" +
       "tb3pezvrO61Atg/0DR07lnX5ilSHjV+AUZ2B+AAi5w0PCj9Lv/XRe48Dh/SX" +
       "14EhSUnhqwfwxn5EaWVxUwVuDT3zoeU7xZ/Pb0FbhyNxqjeoOpOyc2n83IuT" +
       "F47OwCvJPfue7/zo6Q8+4u3PxUOhfSdEXM6ZTvF7j1o48FRdA0FzX/zr7pY/" +
       "e+nzj1zYgq4DcQPEykgGZgRh6M6jfRya6hd3w2aK5QQAPPECR7bTpt1Ydyaa" +
       "Bt5yvyYb+huz55uAjR+CdopDkyFtvdlPy1dsXCUdtCMosrD8RsH/6F/9yXfR" +
       "zNy7EfzsgTVR0KOLB6JGKuxsFh9u2veBfqDrgO5vPsT92uM/eM/PZA4AKO67" +
       "UocX0rIBogUYQmDmX/jy/JvPfuvJb2ztO00Els1YsU012YD8CfgdA9f/pFcK" +
       "Lq3YzPjzjZ2wc/de3PHTnh/Y1w1EIBtMx9SDLgxcx9PMiSkrtp567H+dvb/w" +
       "2e+/79zGJ2xQs+tSr39+Afv1P1WH3vHVt/z7nZmYY2q6Au7bb59sE1Zv3pdc" +
       "CwJ5leqRvPPP7/jwl+SPggANgmJorvUszkGZPaBsAPOZLXJZCR9pQ9LirvDg" +
       "RDg81w5kKpfUD3zjhy8Xf/iF5zJtD6c6B8e9I/sXN66WFncnQPyrjs76phxO" +
       "AV3xme6bz9nP/BhIlIBEFcS1kA1A+EkOeckO9YlTf/0Hf3TLW79+HNoioTO2" +
       "J2uknE046Hrg6Xo4BZEr8X/64Y03L0+D4lwGFboM/MZBbs3+HQcKPnj1WEOm" +
       "mcr+dL31P1lbedff/sdlRsiizBUW6CP8EvzUR25rvOl7Gf/+dE+570wuD8kg" +
       "q9vnRT7h/NvWvSe/uAWdkqBz6k7KKKYBF0wiCaRJ4W4eCdLKQ+2HU57N+n5x" +
       "L5zdfjTUHOj2aKDZXwrAc0qdPp/ZH/AHk2NgIp5Ativb+fT/wxnjPVl5IS1e" +
       "s7F6+vhaMGPDLPUEHBPTle1MzoMR8BhbvbA7R0WQigITX7DsSibmlSD5zrwj" +
       "BbO9yd82sSot0Y0W2XP5qt5wcVdXMPo37gtreyAVfO/ff+Br77/vWTBENHQi" +
       "W8/AyBzosRun2fEvPvX4HS977NvvzQIQiD7cB4lzD6dSmWshTgs8LYhdqLel" +
       "UIVsVW/LYdTJ4oSuZWiv6ZlcYDogtC52Uj/4kfPPzj7ynU9u0rqjbniEWH/0" +
       "sV/+yfb7Hts6kEzfd1k+e5Bnk1BnSr98x8IBdM+1esk4yH98+pHf//gj79lo" +
       "df5wakiAN59P/sV/f237Q9/+yhXyjOts70UMbHTjqFkMW7XdX0eUdGQ5SBJn" +
       "wmKRm1vjxRpvMUukbglNS7MHemM+70Tj2lJ1OYKuIXbXQbqxUi3pYUWvVDoV" +
       "aZp0mR7l13K9LtmrtwUy4hkP7/GGPI1yM0MsMSZHE75Qb7nCrC1M8YpIN/PW" +
       "1MUarSieoZ1KjOponFNXqx5IW9mKWqii6JrLgbua02NvFfR7VL4s2p0iz038" +
       "pLYmkVGoUiuJ1gRr3G1ruJKny6UW3MSxpBrCstFciuW8zOeUpkQjjZ4iMcxs" +
       "TRbzw4LUNe0h7ZAhLfQpNibIzthITMaJ5u2SN3cwqgOmldBvx3mSIgi2QvC9" +
       "IjIezLqsZDr0cNrtdRsTKurZa0Wlg0VP4Clm3u82kcly3bAMpol3VcnrFIvV" +
       "WZmhkFpNT1gitCVx2ccln6Z0I1HmToWN+t26Z7K8Jw/YctJsEyVtluMpbK7P" +
       "YbhYmHMYri27swo1l31Bkami5c/HnZnd6xT6Meb2AtppLvhuoU7iRGFJiNyg" +
       "GbDkdEZ6VKsvY5Y/8LgC4TnjdZP30CnmresjgWYGPC/niBlrScvE95y1O6So" +
       "4dyT+pFbdxZuaY4Ulrl8UlWaZJHvcmgXXhpLf4AWF3NJGTbnAlsnpgKBtWhc" +
       "ECQab3YjZiYKC3nKT8c4ShAcZVpJyCsL2uaiQb/N9moB4KS0Ib2UR+WJwbQM" +
       "B6FEh5Znir7AeY6Jo5EoBvXJsB6ECBuEzRpeXqq4sW550ryXlOgKOQjsJhj/" +
       "qrX0SlVLRpQl0RgzKEt054vSQBTnU6M8oLstojcMJjqhC3i5gOfNoEtM60ZO" +
       "k82BIwXoIKyoJEYTTV5rYNqotqyLQgGtU+xUZuYjq1MlBlIwNaVWwEU6GliV" +
       "stH2aUzoTMr00pyF7by7rHfafNlRBL6L19pBD8eH7bEHzB1NOJZuNlpg3fIM" +
       "cj2o6os26QjqosUUaadkGnlUndVbEUVojXGpPGFCyxMnc6o+L7CmzCicQRYs" +
       "Viy4KuW5M41oyKXFqqPg9RleLIU5WBw10TkFd1jOsInBDO/ZTpGoAt/IW41i" +
       "kHSnLZGiDcGmeZFYDMSaOrHK9FxvwTQzpTBUd/LC0BiIwrzKlPEEzTXMLgFc" +
       "oi4QWsHuyrBcsZwZPKnCfoMh5zpZ07imalX15oSk3enELOBL2wKxIJkXFXPa" +
       "mURSD3cdos7pg3VjnvpUicvpvho1QA+ObQ2MlsrKeX5CzeojjK+tKFrrdIjK" +
       "gOvWltzYFNvDjrYSGrRUqbbmpZbKj0PHhVGYKPkGShtwaVJveEOxPB5QDVLR" +
       "mAFwdCEPlu84LCqlhF2YPD9bVZVVKz9q90ZSa1UrJYhA9EieWfUKS6RcMHQ1" +
       "tCluWh2x45Hf4loNL/Ca1RpRi53SdI2paGVdEUSDoOc9TOzNjHF5zJi4vMBr" +
       "fEuBeU6I1YWi2KVyCzY7TXhWl0vMctx3Kry7qAcmgXADti/UfGOO9XPjYdeL" +
       "OYHtyJ4us/1ZvkNp9XWFw0b1RZ1aN5iwtkymJbdK50d5vUga3aYT9OFqUVVH" +
       "zSi3YMV6L2xzYwpp8XSeHXedXG2hjl2fENfVCUuTsI7mCoS9rEu1rjro8QO8" +
       "Ts5zndpcoBHG6irMrG5grDxTCYaqMNPuzKrgQ7RV1impUDXludCih32/SLJC" +
       "Da4OdFjrVRawqzTiEq0jOU9D0Dk35qlR0yJoZ2GuupwndTXESBpGDkbpHNds" +
       "BlNYT8ROm2HlLh00tIhHar2kplXZGjrC7AqmBRUJq6zYnN0aD8CMiMlwlmOR" +
       "PjcbcFapCIehPjWpsIfU6UFRJeUmtzaZ8XrVC1W0hyskaXlt3JW1stmbNGk5" +
       "mYFI3R4tK3BQWpUqcAkjKGJYJPU4CYf9NlIn0jp5Oi2UKzAybrvVsRsqqFiV" +
       "MJw26pXQ4tbDkKvlSoYej7sjyYJLHatI5mvYUq4G+LTR8YqLUo1r1YJYgBsL" +
       "Ep1SSjzq6ojDVtW2XWoGOC30mi4aeMVZhav4RQOJFL01XSWVfLucUDwvtJgW" +
       "tfRD32vwlG6t+37g58TaFLH1fNch1qPyWGFHrcK8WmAaLNqjlguTHtTEsBDX" +
       "sNpCLNUZ0hVFTAkXsEyXsNyAKXVzNcObU4MkXI7QhkdajOZw+ZqLu9gKiYnm" +
       "rFPI4/xyUq6Z+Jpy18kMc+m85E5aNZzD8oiHDTkUhFupTLbigjOM19UEXeto" +
       "iMiJQNOIHgujbrEA1wH+UtBge/l8jPGlKZ2z19NlWe0H4mQkSyw+yJN6JXFH" +
       "DWIyUSK4stTZhdMU8xOpQ81938TEVaPOj3A66FF8QKgSWtVZ2cjngiBahToL" +
       "j7G2b+qUugYRo1bJD+2lFgZFVsQnpVwCDxZYXNXrCApi+4Jmc6P+KBZVtO03" +
       "2NzEoQf5OpIfOIVZwzW16azV7RlqIIoOGcfSqs3m2jwsr4Rk1sit81EF1oZC" +
       "tWbHKi2vg1WAr+VlnwklXilgFm2xBbff18jZvNYGgdcQa5xmxLmmXWupdbFc" +
       "l3TN7PclL6+EhmRw9XoZrpe9ieugNjbEyzkUL8tW2LOY9lAZ+byKTCTc6MnR" +
       "dCiRqC2EVmHqY8EccY0+iG1yC4T/Tod0vAEaYXlFxVDOTYYy28NArtNaSUTf" +
       "Qpcy6/qNdq3Oe51lMJ82VY6hW9WhNRrOikwJs5bL8QjjYDgHh93cClYVRvZZ" +
       "2fcbIT3nLAGDLSdAcjZY8wtTpOx3cLwC93E+gsmuOBNH9sKe8f3p0B4rQ7nf" +
       "DtWyOEb6Nq3oCpezVm2tFZXrc3K4MIsWukL6DV6T11NUDBkCzsc6KYGF1l/B" +
       "LVs3A7HTmUd2YpnrfpcYIOIqWE3tDqJKgbT2lDI6UDvNutvEaxPXm9r8sF/F" +
       "TYschkqr2KctvNJyGktVc7Q8V+0sw/GkYihSNFkXJblI2i6i1GOYlUdjs2AV" +
       "w66deOVlyaypfc5rgaWYbaIMPJ4XTCwYtTGpbMwJBlFcTZ2XOKzfng3XTFPR" +
       "bKNPIXOSRnypySPwMj9PbLfJEMiIcp1+NxwAot6wU1T7fWYYGPUViZB8RxDX" +
       "FMsVK5PIqsqIVld1lhkOJs0kV+4M5MRR1qWxpBe9ApqMckMCFlhm0XNBQ7Qo" +
       "JMCxxGjAcehEwNgc6wwnuCphdhmFLU1sBWJx6cGFancxXMf9YT/O92KacmyD" +
       "SQZT1g4aq15p6Pf7LOwSall3vXKOj0bVsarLkzEid/J5VJKHeYuZYlpBc/sO" +
       "XWZX+aRkw4kfrEkC6eE1ukDB6qqMBrI6GZJsjpt3XYNqN6tdqwuLvmhgia0t" +
       "OSGgevPxnCGRDhFZBOLk1qVwUsVE3YpLE2zSIvqLTlkmxp487S1IY1rpzoRc" +
       "Fy0RJbO1DgRvJg40tt0OArIkJ3nY5bG1AjRHK+1gPVqR5WlBJacdKRmRmson" +
       "TVRtxLOm0Al0qx8JErvAyrNyi3RzKGOWaQYLB924wYzRsuxpg8RpdGhjMiso" +
       "FqlHiUg1ZjJT05vNNVyrsLTMJSBjwANpsaKMxsJOmHyxi8WxhfFks+/1mGlR" +
       "lbhqfThuEgulLGIFXR4smlpkIPOmEw1ZqZr0BnG/xPrj8pCeo2VNRBthCc4N" +
       "EGaiB5y5qBPzTr4UgzmKWyioUGa2UOVqSwcZNNzmiMRFObeiwoiVQkxE8P7S" +
       "jvvuPNaUBMYbuTKCtoOk0hLtZZyrS64RD6trBKbRdqHPBu1KKaGbNbLhTbVV" +
       "S5863cDO+Vhj1PGbqusNmaiuhRrJYmKtUUVjQ+BwLl7BWLlQmBCVarXHtFgZ" +
       "aDGTGuwIXS7cSCkosM0rPC/2JLGuBnmPoRcBsHBvTlCWRxgtuj0MnQXWl3ha" +
       "GZXMSGOL0qpM9KsVsAL4lBnFtDDnjHl3PvV6VX6cIJKbz6/zNngfHI10Tg0x" +
       "phYiY39F8ESFiEeKFhdXflFVaKqwtnOTTouvjHLaEgMp8DQPXiTf+Mb0FfPN" +
       "L+wt/6ZsQ2PvdAq83KcN1At4u9003ZMW9+9t4ma/k9fYxD2w0QWlb+x3XO3Q" +
       "KXtbf/Jdjz2hsR8rbO1sEA4j6PrI8x+y9YVuHxB1Gkh63dV3JjrZmdv+xtWX" +
       "3vVPt/XfNH3rC9iav+uInkdF/nbnqa9QD6i/ugUd39vGuuw08DDTxcObV2cC" +
       "PYoDt39oC+uOPcvenFrsgd198t375dvjV/SCY5kXbMb+GvuvwTXash1lJ4Ju" +
       "NsOWO9UDM9I1LvCy89WMgT/gMGIEnVI8z9Zld9+Z3OfbKjnYZVZhHUb/GnAV" +
       "d9AXX3r077xG27vT4u0R9AozrLmmI0fpxvku/LRtsY/zkReL835wXdzBefGl" +
       "x/kr12h7f1o8GkHnzfSwPds6uwrKX3oRKM+mlXeCq76Dsv7So/zwNdp+Iy0e" +
       "i6Czhh7twts7lzrix8fNna8gMtSPvwjU59PKe8DV2kHdeulRf/wabZ9Ii988" +
       "jLq7E3+ofYhPvgiI2RJwN7i4HYjcSw/xM9do+920eHoDEdcncmxvjht2t+lf" +
       "8/wnxfv0mTU+/WKtcTu4hjvWGL401tjKCLZ2Qb06BbVE1QxLKKvbbT0xVdke" +
       "uGa0S3P/tYA3BIHInrLe/vBIb8d2TsB3JN2625vmOds42yESVffTxTNj/nJa" +
       "fD6CXqYGuhzpmTHTqs/tW/QLL9ai94LL2rGo9dJY9PjOydsV5v+JcOoF2eKX" +
       "JUdfzPi/cWUbpX+/khF8My3+FKRZGztszoSuZI0/eyHWSIBhD3zEkJ7C3nrZ" +
       "p1Wbz4HUTz1x9vSrnhj8ZXaOv/fJzvVt6PQktu2Dh2YHnk/6gT4xMwTXb47Q" +
       "/Oz27Qh64P/2kUUEXZfeMtWf3TD/XQTd87zM0c7J1kHGf9jx7aswRtDJzcNB" +
       "nu+CNfpKPCCQg/Ig5fcj6NxRSqBFdj9I988RdGafDnS6eThI8i9AOiBJH//V" +
       "350oDz2/wXhdjXbGMjl2ODPec5Dzz+cgB5Lp+w6lwNm3ebvparz5Ou+S+vQT" +
       "dPdtz5U/tvlOQrXl9TqVcroNndp8srGX8t5zVWm7sk42H/zxjZ++/v7d9PzG" +
       "jcL7c/CAbndd+UMEwvGj7NOB9ede9Zk3/NYT38qOL/8X0pVX5jQpAAA=");
}
