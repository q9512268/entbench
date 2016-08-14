package org.apache.batik.css.engine.value.svg12;
public class LineHeightManager extends org.apache.batik.css.engine.value.LengthManager {
    public LineHeightManager() { super(); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LINE_HEIGHT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.SVG12CSSConstants.
                                                         CSS_LINE_HEIGHT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                {
                    java.lang.String s =
                      lu.
                      getStringValue(
                        ).
                      toLowerCase(
                        );
                    if (org.apache.batik.util.SVG12CSSConstants.
                          CSS_NORMAL_VALUE.
                          equals(
                            s))
                        return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                                 NORMAL_VALUE;
                    throw createInvalidIdentifierDOMException(
                            lu.
                              getStringValue(
                                ));
                }
            default:
                return super.
                  createValue(
                    lu,
                    engine);
        }
    }
    protected int getOrientation() { return VERTICAL_ORIENTATION;
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
                CSS_PRIMITIVE_VALUE)
            return value;
        switch (value.
                  getPrimitiveType(
                    )) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
                return new org.apache.batik.css.engine.value.svg12.LineHeightValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  value.
                    getFloatValue(
                      ),
                  true);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                {
                    float v =
                      value.
                      getFloatValue(
                        );
                    int fsidx =
                      engine.
                      getFontSizeIndex(
                        );
                    float fs =
                      engine.
                      getComputedStyle(
                        elt,
                        pseudo,
                        fsidx).
                      getFloatValue(
                        );
                    return new org.apache.batik.css.engine.value.FloatValue(
                      org.w3c.dom.css.CSSPrimitiveValue.
                        CSS_NUMBER,
                      v *
                        fs *
                        0.01F);
                }
            default:
                return super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    value);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iP8PopMZNHweAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVae8zsRnX3/W5yk3sTcm8SCGkg7xsoLHze9a7t3QYK+7a9" +
       "tvfhtXfXBYLXj7XX79eu1xAKqC0UpDRqA6UV5K+gFhoerYooqqCpUHkIVJUK" +
       "UVqJh1Cl0lJaqARFpYWOvd/7PtIokfpJnvU3c86Z8ztz5szxzDz5fejaMIAK" +
       "nmttFpYb7apJtLu00N1o46nhLkWjAykIVaVpSWE4BnUPyfd9/PyPf/qofmEH" +
       "OiNCt0qO40ZSZLhOOFJD11qpCg2dP6xtW6odRtAFeimtJDiODAumjTB6kIZu" +
       "OMIaQRfpfRVgoAIMVIBzFeD6IRVgep7qxHYz45CcKPSht0CnaOiMJ2fqRdC9" +
       "x4V4UiDZe2IGOQIg4frsfwGAypmTALrnAPsW8yWA31OAH/vdN1z4k9PQeRE6" +
       "bzhcpo4MlIhAJyJ0o63aczUI64qiKiJ0s6OqCqcGhmQZaa63CN0SGgtHiuJA" +
       "PTBSVhl7apD3eWi5G+UMWxDLkRscwNMM1VL2/7tWs6QFwHrbIdYtwk5WDwCe" +
       "M4BigSbJ6j7LNabhKBF090mOA4wXe4AAsF5nq5HuHnR1jSOBCuiW7dhZkrOA" +
       "uSgwnAUgvdaNQS8RdMcVhWa29iTZlBbqQxF0+0m6wbYJUJ3NDZGxRNALTpLl" +
       "ksAo3XFilI6Mz/fZVz3yJodwdnKdFVW2Mv2vB0x3nWAaqZoaqI6sbhlvfDn9" +
       "Xum2T79zB4IA8QtOEG9pPvnmH772FXc99YUtzYsuQ9OfL1U5ekh+Yn7TV17c" +
       "fFntdKbG9Z4bGtngH0Oeu/9gr+XBxAMz77YDiVnj7n7jU6PPzd76YfV7O9A5" +
       "Ejoju1ZsAz+6WXZtz7DUoKs6aiBFqkJCZ1VHaebtJHQdeKcNR93W9jUtVCMS" +
       "usbKq864+f/ARBoQkZnoOvBuOJq7/+5JkZ6/Jx4EQdeBB7oRPAVo+5f/RlAK" +
       "666twpIsOYbjwoPAzfBnA+ooEhypIXhXQKvnwnPg/+YrS7s4HLpxABwSdoMF" +
       "LAGv0NVtIyyHIaw6C6AhvJKsWIXD1aKEwBkKQjUWesRIDnCTYDfzQe//tfck" +
       "s82F9alTYNhefDJoWGC+Ea6lqMFD8mNxo/3Djz70pZ2DSbRn1QiqARV2tyrs" +
       "5irsAhV2tyrs5irs5irsXqICdOpU3vPzM1W2zgJoTBA0QDi98WXc66k3vvO+" +
       "08BLvfU1YJwyUvjKUb15GGbIPJjKwNehp963fpvwq8UdaOd4eM7UB1XnMvZB" +
       "FlQPgufFk9PycnLPv+O7P/7Yex92DyfosXi/Fzcu5czm/X0nDR24sqqASHoo" +
       "/uX3SJ946NMPX9yBrgHBBATQSALGA7HprpN9HJv/D+7H0gzLtQCw5ga2ZGVN" +
       "+wHwXKQH7vqwJveAm/L3m4GNb8gmxIvB88q9GZL/Zq23eln5/K3HZIN2AkUe" +
       "q1/NeR/4+l//czk3935YP39koeTU6MEjoSQTdj4PGjcf+sA4UFVA9433DX7n" +
       "Pd9/x6/kDgAo7r9chxezsglCCBhCYOZf/4L/99/65hNf3Tl0mgispfHcMuTk" +
       "AGRWD527CkjQ20sO9QGhyAITMvOai7xju4qhGdLcUjMv/e/zD5Q+8a+PXNj6" +
       "gQVq9t3oFU8v4LD+FxrQW7/0hv+8KxdzSs6WwkObHZJt4+uth5LrQSBtMj2S" +
       "t/3tnb/3eekDIFKD6BgaqZoHPCi3AZQPGpzjf3le7p5oK2XF3eFR5z8+v46k" +
       "LA/Jj371B88TfvCZH+baHs95jo41I3kPbt0rK+5JgPgXnpzphBTqgK7yFPu6" +
       "C9ZTPwUSRSBRBpEt7Acg8iTHPGOP+trr/uEvP3vbG79yGtrpQOcsV1I6Uj7J" +
       "oLPAu9VQB0Er8V7z2u3grq8HxYUcKnQJ+K1T3J7/dxoo+LIrx5dOlrIcTtHb" +
       "/6tvzd/+nZ9cYoQ8slxmpT7BL8JPvv+O5i9/L+c/nOIZ913JpdEYpHeHvMiH" +
       "7R/t3Hfmr3ag60TogryXOwpZrAUTRwT5UrifUIL88lj78dxnu9A/eBDCXnwy" +
       "vBzp9mRwOVwFwHtGnb2fOxpPfg7+ToHnZ9mTmTur2K64tzT3lv17DtZ9z0tO" +
       "gdl6LbKL7xYz/tfkUu7Ny4tZ8dLtMGWvvwimdZgnrYBDMxzJyjt+bQRczJIv" +
       "7ksXQBILxuTi0sJzMS8AaXvuThn63W3mtw1oWYnkIrYugV7RfX5pS5WvXDcd" +
       "CqNdkES++x8f/fJv3f8tMKYUdG2+9oGhPNIjG2d59W88+Z47b3js2+/OoxQI" +
       "UYP3ti+8NpNKXw1xVrSzorMP9Y4MKpcnArQURkweWFQlR3tVVx4Ehg3i72ov" +
       "aYQfvuVb5vu/+5FtQnjSb08Qq+987F0/333ksZ0jafj9l2TCR3m2qXiu9PP2" +
       "LBxA916tl5yj808fe/jP//Dhd2y1uuV4UtkG30wf+dr/fHn3fd/+4mVykmss" +
       "91kMbHTTV4lKSNb3/xhB1CZrPkkmWr8wSBvpvFCvp9a6vBbJAI+bxqhRooft" +
       "Zb07rlbktdul3OWKUJ1uTZ+XNdGZDwYtj6tbZKtSLwr1dkROSm1/wTa6Db9b" +
       "xnyuaQgG745HdVMy+4ZucSPbH7KSbVhF0kewaZzGuIKreGXZMRc1SdUQMULx" +
       "ag2bl/EEnRdwpiVQftfm7HHEV1oa23BER6eddOW6c6piFHusjLDFRjxurcoe" +
       "xqLzeWkaNlFq2ErssdeV8FEbQUa22Cv31zqPTAW0wwk26zQmjTUaLxKb8fua" +
       "bFljtapXkElCYzM33MwTxUgZE2lv2F7PXjqNaDNH/ZS1wjpV6xtDLyaLTWlT" +
       "NOEh0RQE058N4sVmLOu6NOiypF2mHSa1vaWKLeAxx6EByRngc2BercxEGot7" +
       "M7ZmhPMWzQxafXRIzNtquEyxIVqRRLomVLXVihJ7pfW6ZPi+7k4pz53bPdOD" +
       "ubVKjYV4jq2afDyLq3aJaxuT5UDmZLY9UTiOWUvDoa2oScnnW7jkSza/QSSG" +
       "lHHT7GF63UsYg50a7QprB3RHqdvKkCfRCClO024rqvU2pdSh8TGR+Fo8njEV" +
       "mId9o10acMOu5UQjhzd5km5RrfKCp+a+OJNQRked6gjlvGqvqaRsy3Pdqtir" +
       "ISvOKfsi59SHvf4Er6fBmG2lfQdrWjNu3hpw7UhlAsKk6lyAC4jVdKelhVRh" +
       "Ax+Z6t14TdQ3kcUzCckzTTUdU76Hpd3GDN305yTCLotMg2lIlk1W/cnE6foC" +
       "hzVbpY455P2V2IkXnaqkF4aW7daHPLsIZo1hjRb6nogUl1W+YquGg+G97qLn" +
       "Nft1Suw3nBWV9LkZxdsFYU6FaaXc92aaZo0Uby1SdYLrM0WrAfNyi8f6A2nI" +
       "0gw5aAyC+swviB0Hm7FBsmbaC7pdKZfbnbA8UKJaVWoTS12RQzt0WkVijOB2" +
       "nVsWbUcNFdlWyI1SMinf6sYSJjEGWlvGim5NNZGUixLBsf2hNTNas4m2Xrtz" +
       "be44YUObT8meFZKbDsXXSG/d6SpeTyhOJkR34s82izI5mW8YYUwiZWPQRvjF" +
       "fMULliXYNYe025uyKXZ7Ehl4pKNVemTbaNengtzDg+asiJYQZ9B0VCZ1da++" +
       "VvnFdKB1qVrSkp0h2jWBrUc9qyMIgUBaWFeH58aCjGfrdg1fMj0vMAW8Dlex" +
       "jlGlaBKTJuyiOWzLZdcoNeojkRIXCUGxTZbBhwxLwiWem/dJRCmUJaLdDoQl" +
       "gdIVc47J/poZkuR6XoILq7CrjVmE7NTBEEXGsub26JZWsq2e0zATTNAxQV2x" +
       "IU5Mab5lUEGvtgnNDd/shP6oPum5o4Y+b1pDy3DbjZmvD1ieJLt1mzBl3+41" +
       "GhMdGUbNut8plkBwn2O4rDkds9ljeWIUtjFSteVVpx8ms2Kceu2hWUVlZNoK" +
       "qnos0OsR1a5TQxpNDNwiOIvo85Omqru8GbaCbljsEUaDFcnKhDUnrTKpq0yr" +
       "kM5XsBQM1+UQc5kG1+ymZNnlk8E46php1W811TIatggHreGqC9uJq8qV6gyl" +
       "NKbCqClT6xXSMmzM2G4V08YOsvEwm2yYnXCYGiymrhW9LnXhUoqSnCYaKu9u" +
       "ytaMaDSZEsWvubYDW/ON12uzcavYXBBTQxutw+pkKS9Lg8Vkoq94ELjcdRGL" +
       "dCZcNylb60ikW6CDsuZTSg2viqS1jsp9v0QsucUE79opMmqRU8FAdQEtUmu3" +
       "2p4VB+VEZbWRh1RkpBmsGwmX6l68birhxOg213q/ZScleK6oZayAaWor8Gfo" +
       "tMl75VDvVT1zKY8KvOW0OYZD/XWtPVxMjbrUsyWR6fnUcMzEJaHbxTitpjHT" +
       "FVhPK0pAj9ZusT+oS0xXacyXtWnJ6hDOqmYKMTs0k/raG8xqokWL7rQcSrhp" +
       "zcRGo9QdpDQW8GihxrXh+nBINBCRI2zSKI8GRt1oT/BpbaG11SJXrhktpMWJ" +
       "01XLwY3aING5seOkeFgIWAdF4N58zI7ndlWqlfq1yYyeRkswhVqVpobWwwom" +
       "cVITh4s0EVmBtbaRIVJnOGpohKIvNxZcYbxYb+ZxMA7LggKX560atzCpwOgK" +
       "hjlfSthyJvaGzSJTZihmzCxp3CAnUdKo+ro/mtjmMl0WRXisWwWv5I37+qRA" +
       "aEtcp6qx1oftQp2adNzQRGJ4kTTQCJ1MOWpc1eHEcUYWN2iQHYb2wAqij/0S" +
       "XFtSal/zRoK04akaHtFKE10FBg7DaQy3ktamwsopxcvtkubTjYLnLO2ArHti" +
       "YdSpTqWRNzdHUt8RJpvpihCtmTWC67xALRdavRqUG5WaWVvLYOAou1wdgTWm" +
       "2aRTlios4WZPm6e1VFKLMsbrQ4ryJjyD0jzRF+2gGC+KJtvQ7ZJhi/oYn9Tx" +
       "ahoWXbxDiWErRShcGskDIkGIIc8jqD4y6DmJs8lQRCo6298oS1fTx2apbgzr" +
       "JNGo+G49HBVqxroouFMFE7CxklibZkytViiSOnZcidSwLPL9wJkmxX5Doqt2" +
       "N4U1clUqF/l2JZos/SUZhz4IOELXKShrfy5Uq3WhWl+1qp2kxhNpHOK9QiHh" +
       "0YaHKCnfKRPOuFvm2O5MKlLmGC6XHAXGC+0p3SAKfdxg7UalqhQMqlqgjNIM" +
       "S5qiJaq0SljhzBU34EsussdtynA3RqExq9a66GAOYxWx0hpO42SyND2sxhd1" +
       "oV2KUaMx7wZChVCr3qTkFmcWjE/LhsPjZEPxSFXwBQBanKTraYQIdhypadvG" +
       "SxWMnpX0uJaa1sKxUSL0pzOls1xNQdJLjhhccJdxFG0UeVStbpCkQicrNDWW" +
       "7cliXJO8drLmEpAtVRAB8zaGQ1ZlD4kWk4GmNJB1pVapzFqzarQYByoy7PeY" +
       "kQSSEJ20+3jIO62aRyeE2V6ElRYKT5VIWxT7rNxLS4Go4/KSpasZ/dAx3LWS" +
       "dGea1xzVlq0IEeGBmmqzOPELkbOSZ9RmstGGKxMRyxWmgIvMYLVCbKLUbw1b" +
       "zgKfYy426mProZR0nUGHNfGOFS7jIRbUWWPZbKqbth1tqMF6Y4jhVLEr8FLH" +
       "SjDmrjHCq3Y3m6XiFmWnys+MklEtmAYYCL1aLtMEFokLfyasdDsAn/darYag" +
       "uDP3dDEqyF1Y1gdTkY1WkznHlvlNZ+Js4ubQLSxmhZIZEeLCAEkb2zP5ZdBj" +
       "6E7HMjdeqiMiwswKRYVQy8ZS1SturRamDuE2S567ZOfTdtwRyioSITPTs1ms" +
       "R+nwQi6JY1OkGy4bDqcLMUbR8nRajstxMhz1RnqhGroVOxiloWAvBBYRYqOb" +
       "+N3ZjOhoqGApo+5s1O9UQsaZUfY6lkHO7yq6u+Gxktx1wkE8RtGagtfnG7ca" +
       "I+WaUqnKmivMNFXq6I2K3khaer/YDOx11QfL3XK17iwGDlXroLEWLyv1Hl/u" +
       "eL062Ygn1pAi12ivaNBBoZuKoTyvKWPV8SrtTkWNZSZ12LFVVljdGrsJvql2" +
       "sMST+0688Zy0ueFLcJtQOoi08nvhEmQ5VqfKcVTZHSZeIwzJYdTy/bU0HSka" +
       "Ud54YVOK26npdRS4afbDSaGiyim9WPbTFiIW+kaq6U6/Wudn/SGwXqmijrFG" +
       "uVupEMtl09UETlv4hIVWuajR0qaBD8sC7RXDrlly4ynary4IfrmujQpYHVuR" +
       "DkjFdBAOJKnmUF4DNjbgEwtG+4tBR+5W015vhrfhEtXHxSYCe3ZzE+NmwUWJ" +
       "eYpWkMAfmMkQY8kRNzIHnVmnyIr2KugOJ1Z/TjWxwlwlViyXTDaO3bPTDjEr" +
       "w93xALcWDVJoEEgb30wFSRwrJu4jsWN5NbiCtNyeN9InRbs+XCB4SeuvzAE/" +
       "5Qi2Oy4O9FXKY9MuUrRHgUH4CFoNB5EFw+jcb6hltj70Uc+nmdnIrGCqhlUD" +
       "V11pTbHXYy2yF40CukY1eoiwrvlddMEHhRGP+B01AL2tirS0TmNm5lLmoMng" +
       "SsufN2EVLZMbBi8sUhpeBhZXrE+kcBibrhd55S5KTBS14FZ7m3YqzhhV9xdd" +
       "MkYw3FM4UQ07Ij5VZmtzMWoVjEF14HqMyBJrFXzFvjr7vH39M9thuDnfTDk4" +
       "U1taeNZAPIMv623TvVnxwMEGbP535uQ5zNEN2MNdOSjbLbjzSkdl+U7BE29/" +
       "7HGl/8HSzt5u5jSCzkau90pLXanWEVFngaSXX3lXhMlPCg932T7/9n+5Y/zL" +
       "+hufwdnB3Sf0PCnyQ8yTX+y+RP7tHej0wZ7bJWeYx5kePL7Tdi5Qozhwxsf2" +
       "2+48sOytmcVeAh5kz7LI5ffvL+sFp3Iv2I79VTaLw6u0xVnhRNCtRkg6uhoY" +
       "kaoMAjc/Fc4ZuCMOM4mg6+aua6mSc+hM7tNt0xztMq8wj6N/KXhqe+hrzz36" +
       "t1+l7dey4uEIer4R1h3DlqJsl38ffta2PsT5lmeL8wHw7PFuf59bnI9cpe3R" +
       "rPjNCLrFyK4I5Nt2V0D5rmeB8nxWeRd4unsou889yt+/Stv7s+I9EXR+oUb7" +
       "8A4Ozk748Wlj7+5Gjvq9zwL1LVnlveBh91Czzz3qD12l7Y+y4onjqNm9+EMc" +
       "Qvzgs4CYLwH3gIffg8g/9xA/cZW2T2bFx7cQW6omxdb2bGT/iOClT3+ifUif" +
       "W+OPn601siPX1+1Z43XPjTV2coKdfVAvykCty3KOJZTkXVpNDFmyeMeI9mke" +
       "uBrwJse187e8t8+e6O3U3hH9nqTb93tTXHu31Wfaiax62eKZM38xKz4TQTfI" +
       "gSpFam7MrOpThxb9i2c7hTL/CvYsGjwTi4LkwQvcSJXB0vW0bva1q7R9PSv+" +
       "JoJuAm7WDwzV2aYPWe3jh0C/8mxd507wvHkP6JufG9c5kxOc2R/M3adxCy7a" +
       "WNlKl12MAyjzSJEVnzuECqRcvJqUTITKSLnWn8p1+s5VLPvdrPhGlF0ts734" +
       "8g70zWdi1wSkupdcT8nO2m+/5Cbd9vaX/NHHz1//wsf5v8tvaBzc0DpLQ9dr" +
       "sWUdPRo98n7GC1TNyCGc3R6UevnPv/+fYk5+iyaCrs1/cwj/tmX/jwi692nZ" +
       "o70DyaOMP9oLC1dgjKAz25ejPD8B6c3leMAaCMqjlD+NoAsnKYEW+e9Rup9F" +
       "0LlDOtDp9uUISXYufBqQZK873r5DwU9vMhr8F+l745mcOv5ZceAqtzydqxz5" +
       "Ern/2PdDfh1zP9ePtxcyH5I/9jjFvumH2Ae3t2BkS0rTTMr1NHTd9kLOwffC" +
       "vVeUti/rDPGyn9708bMP7H/b3LRV+HBeH9Ht7stfOWnbXpRfEkn/7IV/+qo/" +
       "ePyb+bnz/wJ2yXqIJysAAA==");
}
