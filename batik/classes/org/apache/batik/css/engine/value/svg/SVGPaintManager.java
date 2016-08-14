package org.apache.batik.css.engine.value.svg;
public class SVGPaintManager extends org.apache.batik.css.engine.value.svg.SVGColorManager {
    public SVGPaintManager(java.lang.String prop) { super(prop); }
    public SVGPaintManager(java.lang.String prop, org.apache.batik.css.engine.value.Value v) {
        super(
          prop,
          v);
    }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_PAINT; }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_NONE_VALUE)) {
                                                        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                 NONE_VALUE;
                                                    }
                                                default:
                                                    return super.
                                                      createValue(
                                                        lu,
                                                        engine);
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                            }
                                            java.lang.String value =
                                              lu.
                                              getStringValue(
                                                );
                                            java.lang.String uri =
                                              resolveURI(
                                                engine.
                                                  getCSSBaseURI(
                                                    ),
                                                value);
                                            lu =
                                              lu.
                                                getNextLexicalUnit(
                                                  );
                                            if (lu ==
                                                  null) {
                                                return new org.apache.batik.css.engine.value.URIValue(
                                                  value,
                                                  uri);
                                            }
                                            org.apache.batik.css.engine.value.ListValue result =
                                              new org.apache.batik.css.engine.value.ListValue(
                                              ' ');
                                            result.
                                              append(
                                                new org.apache.batik.css.engine.value.URIValue(
                                                  value,
                                                  uri));
                                            if (lu.
                                                  getLexicalUnitType(
                                                    ) ==
                                                  org.w3c.css.sac.LexicalUnit.
                                                    SAC_IDENT) {
                                                if (lu.
                                                      getStringValue(
                                                        ).
                                                      equalsIgnoreCase(
                                                        org.apache.batik.util.CSSConstants.
                                                          CSS_NONE_VALUE)) {
                                                    result.
                                                      append(
                                                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                          NONE_VALUE);
                                                    return result;
                                                }
                                            }
                                            org.apache.batik.css.engine.value.Value v =
                                              super.
                                              createValue(
                                                lu,
                                                engine);
                                            if (v.
                                                  getCssValueType(
                                                    ) ==
                                                  org.w3c.dom.css.CSSValue.
                                                    CSS_CUSTOM) {
                                                org.apache.batik.css.engine.value.ListValue lv =
                                                  (org.apache.batik.css.engine.value.ListValue)
                                                    v;
                                                for (int i =
                                                       0;
                                                     i <
                                                       lv.
                                                       getLength(
                                                         );
                                                     i++) {
                                                    result.
                                                      append(
                                                        lv.
                                                          item(
                                                            i));
                                                }
                                            }
                                            else {
                                                result.
                                                  append(
                                                    v);
                                            }
                                            return result;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.svg.SVGValueConstants.
                NONE_VALUE) {
            return value;
        }
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            org.apache.batik.css.engine.value.Value v =
              lv.
              item(
                0);
            if (v.
                  getPrimitiveType(
                    ) ==
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_URI) {
                v =
                  lv.
                    item(
                      1);
                if (v ==
                      org.apache.batik.css.engine.value.svg.SVGValueConstants.
                        NONE_VALUE) {
                    return value;
                }
                org.apache.batik.css.engine.value.Value t =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    v);
                if (t !=
                      v) {
                    org.apache.batik.css.engine.value.ListValue result =
                      new org.apache.batik.css.engine.value.ListValue(
                      ' ');
                    result.
                      append(
                        lv.
                          item(
                            0));
                    result.
                      append(
                        t);
                    if (lv.
                          getLength(
                            ) ==
                          3) {
                        result.
                          append(
                            lv.
                              item(
                                1));
                    }
                    return result;
                }
                return value;
            }
        }
        return super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZaWwU1/l5fV/4AAwBbC4D4uhuaAIKNQkBY4PpGiwMrmo3" +
       "mLezb72DZ2eGmbf22onbkKoCIhUhSoAe0D9EIVUIqG3UVjnkKlIO5ZBIUWlS" +
       "QVK1UumBGtQ2/UHb9PvezOzMzh6uq1BL82b2ve943/e+8/m5W6TUNEgLU3mQ" +
       "j+nMDHaovIcaJou2K9Q098DcoHS6mP51382dGwKkrJ/MiFOzW6Im65SZEjX7" +
       "SbOsmpyqEjN3MhZFjB6DmcwYoVzW1H4yWza7EroiSzLv1qIMAfqoESYNlHND" +
       "jiQ567IJcNIchp2ExE5Cm/3LbWFSI2n6mAs+1wPe7llByITLy+SkPnyAjtBQ" +
       "kstKKCybvC1lkNW6powNKRoPshQPHlDW2SrYEV6XpYIll+s+uXM8Xi9UMJOq" +
       "qsaFeOZuZmrKCIuGSZ0726GwhHmQfJUUh0m1B5iT1rDDNARMQ8DUkdaFgt3X" +
       "MjWZaNeEONyhVKZLuCFOFmcS0alBEzaZHrFnoFDBbdkFMki7KC2tJWWWiE+t" +
       "Dp08va/+h8Wkrp/UyWovbkeCTXBg0g8KZYkIM8zN0SiL9pMGFQ67lxkyVeRx" +
       "+6QbTXlIpTwJx++oBSeTOjMET1dXcI4gm5GUuGakxYsJg7J/lcYUOgSyNrmy" +
       "WhJ24jwIWCXDxowYBbuzUUqGZTXKyUI/RlrG1i8CAKCWJxiPa2lWJSqFCdJo" +
       "mYhC1aFQL5ieOgSgpRoYoMHJvLxEUdc6lYbpEBtEi/TB9VhLAFUpFIEonMz2" +
       "gwlKcErzfKfkOZ9bOzcee1TdrgZIEew5yiQF918NSC0+pN0sxgwGfmAh1qwK" +
       "n6JNLx8JEALAs33AFsxPHrv98JqWyTcsmPk5YHZFDjCJD0rnIzOuLGhfuaEY" +
       "t1Gha6aMh58hufCyHnulLaVDhGlKU8TFoLM4ufu1Lz/+A/anAKnqImWSpiQT" +
       "YEcNkpbQZYUZ25jKDMpZtItUMjXaLta7SDl8h2WVWbO7YjGT8S5SooipMk38" +
       "BhXFgASqqAq+ZTWmOd865XHxndIJIeXwkBp4VhHrT7w5iYfiWoKFqERVWdVC" +
       "PYaG8pshiDgR0G08FAGrHw6ZWtIAEwxpxlCIgh3Emb0gmQg7BHsKjVAlyULm" +
       "CNhV37YeCobbTVUwCiOIFqf/H3mlUO6Zo0VFcCQL/AFBAV/arilRZgxKJ5Nb" +
       "Om4/P/iWZWzoILbGOFkH7IMW+6BgHwT2QYt9ULAPAvugjz0pKhJcZ+E2LCOA" +
       "IxyGYADRuGZl7yM79h9ZUgzWp4+WgP4DALokIyu1uxHDCfOD0qXG2vHFN9a+" +
       "GiAlYdJIJZ6kCiaZzcYQhC9p2PbwmgjkKzdtLPKkDcx3hiaxKEStfOnDplKh" +
       "jTAD5zmZ5aHgJDV031D+lJJz/2TyzOihvq/dGyCBzEyBLEshyCF6D8b3dBxv" +
       "9UeIXHTrDt/85NKpCc2NFRmpx8mYWZgowxK/XfjVMyitWkRfGHx5olWovRJi" +
       "OYeTxjDZ4ueREYranLCOslSAwDHNSFAFlxwdV/G4oY26M8JgG8T3LDCLavTN" +
       "efCEbGcVb1xt0nGcYxk42plPCpE2HuzVz/7q3T/cJ9TtZJg6T2nQy3ibJ6oh" +
       "sUYRvxpcs91jMAZw18/0fOupW4cHhM0CxNJcDFtxbIdoBkcIav7GGwff//DG" +
       "+auBtJ0XcUjryQhUR6m0kDhPqgoICdyWu/uBqKhAtECrad2rgn3KMZlGFIaO" +
       "9c+6ZWtf+POxessOFJhxzGjN1ATc+Xu2kMff2vePFkGmSMKs7OrMBbNC/UyX" +
       "8mbDoGO4j9Sh95q//To9C0kDArUpjzMRe4ssHQjJ50KRJjAxAQetBCxOc51Y" +
       "vleM96MmBBIRaxtwWGZ6vSLT8Txl1aB0/OrHtX0fv3JbiJFZl3mNoJvqbZbd" +
       "4bA8BeTn+KPWdmrGAe7+yZ1fqVcm7wDFfqAoQXQ2dxkQQVMZJmNDl5Z/8PNX" +
       "m/ZfKSaBTlKlaDTaSYX3kUowe2bGIfim9E0PW6c+WgFDvRCVZAmfNYGaX5j7" +
       "TDsSOhenMP7TOT/e+My5G8L8dEGiOdu1HrCt7oHcroXjChxWZxtsPlTfCQas" +
       "EI8/1ztnv2LqrNKHo9hFVwGT6MZhq1j6Ag4dlq4e/B/VihPturUw3wvl04H4" +
       "K/OXEX4dpCkYpDlfpSeq1PNPnDwX3fX0Wqsea8ysnjqgObj4y3+9HTzz0Zs5" +
       "EnQl1/TPKWyEKR6eZcgyI6F2iyLYDerXZ5z47c9ah7ZMJ5fiXMsU2RJ/LwQh" +
       "VuXPjf6tvP7EH+fteSi+fxppcaFPnX6Sz3Y/9+a25dKJgKj4rYyY1SlkIrV5" +
       "FQtMDQatjYpi4kytsLalaQOYiQe7HJ5NtgFsmr7/5EMtYO7RAmsxHKApmQkd" +
       "uBqHXg0qacjmoh3LrK/wnHuTERNqITkBqW/Ebh0+37NfOtLa8zvLDO/JgWDB" +
       "zb4Q+mbftQNviwOrQAtJq8ljHWBJnqxeb8n/KfwVwfNvfHDrOIFv6Mja7T5g" +
       "UboR0HX0nZUFOvdMAUITjR8Of+/mRUsAf6PkA2ZHTj75afDYScunrG5yaVZD" +
       "58WxOkpLHByGcXeLC3ERGJ2/vzTx4oWJwwH7oL7ESXlE0xRG1fRBOrkRSplM" +
       "tVt73Xq07qXjjcWd4K1dpCKpygeTrCuaabHlZjLiOQe3AXXt19416pyTolW6" +
       "HelE5Nz/WUROMT+Q6SUr4Om0Tb1z+l6SD7WAJxwqsPZ1HB6Dml42N6tygnKs" +
       "fRw3wbUDrkom7pZKlsHTbcvVPX2V5EMtIPaxAmvHcTgKDijjdY+w3TwKefIu" +
       "KKQO11rg2WNLtWf6CsmHWkDo7xZYO4vDKSgThxh3NJFuUuK25+Mr4fk+yEmx" +
       "bF/feTwaf4543Oz0XVBhA64tgGfA1sPA9FWYDzV3MefUcfOxjhu9TxLlm0ml" +
       "YJilZIkqe1WZOzDLCtV67b29HeJLbPGij5uvY5jrcItqieDWXd0dKYnpWCkI" +
       "5B/hcIGTaslgkDxE/YhTO1zlP3u3lN8Mz1Fbg0enr/x8qD51lNm1na2O4BSK" +
       "7eVjCkY3vJ+GpIJY63G4jMP3HSqthaggCQa9jNCjEGSygN+8hsOLHO97E3oy" +
       "9xG89JkU6OCbvhsn7IjmZl16Wxe10vPn6irmnNt7TRS76cvUGiheYklF8eRQ" +
       "bz4t0w0Wk4VgNVaDqIvXu1OYdPpSDAICjEKGdyzUK5wsnhKVk1Lx9iJetV0t" +
       "DyInZdaHF+caJLlcOLAtGL2QH0Az7oeEXYi3F+46J1UuHDC1PrwgHwF1AMHP" +
       "3+iOif33d4jQyGqGfaKpouw2TJjQ7KlMyNN3Lc2oHcX/TpziKmn992RQunRu" +
       "x85Hb69/2ronkhQ6Po5UqqGksq6s0m3H4rzUHFpl21femXG5cplT6zVYG3ZD" +
       "wHyPv7RDbNPRcOf5LlHM1vRdyvvnN77yzpGy96BKHSBFFMr7Ac9/Lqxr+raU" +
       "noR+byCcXTpCiyZud9pWfmfsoTWxv/xa3AYQq9RckB9+ULr6zCO/ODH3fEuA" +
       "VHeRUihjWaqfVMnm1jF1N5NGjH5SK5sdKdgiUJGpklGXzkAfo3ipI/Riq7M2" +
       "PYu3jJwsya62s+9mqxRtlBlbtKQaRTJQ2Va7M077mdG5JXXdh+DOeDqSpJW8" +
       "8TTAaAfD3bruNCMlTbqINCO5szmOfxOfOPz9P46qQWdXHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xPldgM0fvvj3XvGhJ76en6L9H9GCv7vmKAAA");
}
