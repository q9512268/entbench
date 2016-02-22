package org.sunflow.core.filter;
public class BlackmanHarrisFilter implements org.sunflow.core.Filter {
    private float s;
    private float inv;
    public BlackmanHarrisFilter(float size) { super();
                                              s = size;
                                              inv = 1.0F / (s * 0.5F); }
    public float getSize() { return s; }
    public float get(float x, float y) { return bh1d(x * inv) * bh1d(y * inv);
    }
    private float bh1d(float x) { if (x < -1.0F || x > 1.0F) return 0.0F;
                                  x = (x + 1) * 0.5F;
                                  final double A0 = 0.35875;
                                  final double A1 = -0.48829;
                                  final double A2 = 0.14128;
                                  final double A3 = -0.01168;
                                  return (float) (A0 + A1 * java.lang.Math.
                                                    cos(
                                                      2 *
                                                        java.lang.Math.
                                                          PI *
                                                        x) +
                                                    A2 *
                                                    java.lang.Math.
                                                    cos(
                                                      4 *
                                                        java.lang.Math.
                                                          PI *
                                                        x) +
                                                    A3 *
                                                    java.lang.Math.
                                                    cos(
                                                      6 *
                                                        java.lang.Math.
                                                          PI *
                                                        x)); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYC2wUxxmeOz/xAz/A5m3AGCIeuQtJaINMKWDs2PQMlk2Q" +
                                                              "egSOvb05e/He7rI7a5+d0CZUEaRSKU0cQqtgqRIRFJGAqkZtlYeoojaJklZK" +
                                                              "mjZJq5CqrVTaFDWoalKVtun/z+zdPu58CKmxtHPrmf//Z/7n989euEYqLJO0" +
                                                              "UY1F2IRBrUi3xgYk06KpLlWyrN0wl5CfLJP+vv/qzo1hUhkns0ckq1+WLNqj" +
                                                              "UDVlxckSRbOYpMnU2klpCjkGTGpRc0xiiq7FSYti9WUMVZEV1q+nKBLskcwY" +
                                                              "aZIYM5WkzWifI4CRJTE4SZSfJLo1uNwZI3Wybky45PM95F2eFaTMuHtZjDTG" +
                                                              "DkpjUtRmihqNKRbrzJpkraGrE8OqziI0yyIH1Q2OCXbENhSYoP1Sw8c3Tow0" +
                                                              "chPMkTRNZ1w9a5BaujpGUzHS4M52qzRjHSJfIWUxUushZqQjlts0CptGYdOc" +
                                                              "ti4VnL6eanamS+fqsJykSkPGAzGy3C/EkEwp44gZ4GcGCdXM0Z0zg7bL8toK" +
                                                              "LQtUfGJtdOrJ/Y3fLyMNcdKgaEN4HBkOwWCTOBiUZpLUtLamUjQVJ00aOHuI" +
                                                              "moqkKpOOp5stZViTmA3uz5kFJ22DmnxP11bgR9DNtGWmm3n10jygnP8q0qo0" +
                                                              "DLq2uroKDXtwHhSsUeBgZlqCuHNYykcVLcXI0iBHXseOLwEBsFZlKBvR81uV" +
                                                              "axJMkGYRIqqkDUeHIPS0YSCt0CEATUYWzigUbW1I8qg0TBMYkQG6AbEEVLO4" +
                                                              "IZCFkZYgGZcEXloY8JLHP9d2bjr+gNarhUkIzpyisornrwWmtgDTIE1Tk0Ie" +
                                                              "CMa6NbGTUuuLx8KEAHFLgFjQ/PDB61vWtV1+VdAsKkKzK3mQyiwhn0nOfnNx" +
                                                              "1+qNZXiMakO3FHS+T3OeZQPOSmfWgArTmpeIi5Hc4uXBn335ofP0wzCp6SOV" +
                                                              "sq7aGYijJlnPGIpKzXupRk2J0VQfmUW1VBdf7yNV8B5TNCpmd6XTFmV9pFzl" +
                                                              "U5U6/x9MlAYRaKIaeFe0tJ57NyQ2wt+zBiGkCh5yFzwVRPzxX0b2RUf0DI1K" +
                                                              "sqQpmh4dMHXU34pCxUmCbUeilq2lVX08aplyVDeH8//LukmjsDfETXSbCu7P" +
                                                              "SFqvZJqK1cMnIxhmxme9QRY1nDMeCoHxFwdTH5hor66mqJmQp+xt3defTbwu" +
                                                              "wgpTwbENI+tg14izawR3jYhdI8V2JaEQ32wu7i68DD4ahWyHclu3emjfjgPH" +
                                                              "2ssgvIzxcjAwkrb7YKfLLQm5Op6QLzbXTy6/sv7lMCmPkWZJZrakIopsNYeh" +
                                                              "PsmjTgrXJQGQXFxY5sEFBDRTl2kKytJM+OBIqdbHqInzjMz1SMihFuZndGbM" +
                                                              "KHp+cvnU+MN7vnpHmIT9UIBbVkAVQ/YBLOD5Qt0RLAHF5DYcvfrxxZOHdbcY" +
                                                              "+LAlB4kFnKhDezAcguZJyGuWSc8lXjzcwc0+C4o1kyC5oA62Bffw1ZrOXN1G" +
                                                              "XapB4bRuZiQVl3I2rmEjpj7uzvA4beLvcyEsajH5lsJT7WQj/8XVVgPHeSKu" +
                                                              "Mc4CWnBc+MKQcfrdX/z5Lm7uHIQ0eLB/iLJOT9lCYc28QDW5YbvbpBTo3j81" +
                                                              "8PgT147u5TELFCuKbdiBYxeUK3AhmPmRVw+998GVM2+H3ThngNt2EtqfbF5J" +
                                                              "nCc1JZSE3Va554Gyp0JlwKjpuE+D+FTSipRUKSbWvxtWrn/ur8cbRRyoMJML" +
                                                              "o3U3F+DOL9hGHnp9/ydtXExIRth1beaSiVo+x5W81TSlCTxH9uG3lnz7Fek0" +
                                                              "oAJUYkuZpLy4horlOubTkJ20IC+VDLhhzMGpOwcOyMc6Bv4oMGhBEQZB13Iu" +
                                                              "+o097xx8gzu5GjMf51Hvek9eQ4XwRFijMP6n8BeC57/4oNFxQtT75i4HdJbl" +
                                                              "UccwsnDy1SXaRL8C0cPNH4w+dfUZoUAQlQPE9NjU1z+NHJ8SnhOty4qC7sHL" +
                                                              "I9oXoQ4OG/F0y0vtwjl6/nTx8PPnDh8Vp2r2A3E39JnP/Po/b0RO/e61IggA" +
                                                              "KaRLogG92+fOuX7vCJW2P9rwwonmsh6oGn2k2taUQzbtS3llQu9l2UmPu9ym" +
                                                              "iE94lUPXMBJaA17g0xv4Me7IH4bwwxC+1ovDSstbPP3O8rTXCfnE2x/V7/no" +
                                                              "petcYX9/7q0V/ZIhrN2Ewyq09rwguPVK1gjQ3X155/2N6uUbIDEOEmVoSq1d" +
                                                              "JuBr1ldZHOqKqt/85OXWA2+WkXAPqQELp3okXqTJLKiO1BoBaM4aX9wiisM4" +
                                                              "VodGriopUL5gAhN0afHU784YjCfr5I/m/WDT2ekrvEoZQsYizh/GbsGHyvyW" +
                                                              "5wLD+V9+/ldnv3VyXARTidQI8M3/1y41eeT3/ywwOcfBItkS4I9HLzy1sGvz" +
                                                              "h5zfBSTk7sgWdjgA6i7vnecz/wi3V/40TKripFF2blV7JNXGMh+Hm4SVu2rB" +
                                                              "zcu37r8ViBa4Mw+4i4Pp6tk2CIXeHChnvnh30a8OXbgAnkoHGCqD6Bci/CXO" +
                                                              "WW7j4xocbs+BTZVhKnDzpgG0qS0hFJKME98joBXHPhz2ChmxGQNx960fXMbh" +
                                                              "fkbKFG2s2J6pEnuKpdtwWJvfOb+br333Yqkb3ULN+YzMK2hsRQ+LKb5kphsY" +
                                                              "L6ZnjkxNp3Y9vT7sFJ4tDHJWN25X6RhVPVuVoSRfIvXzO6cble/PfuwPP+4Y" +
                                                              "3nYrnS3Otd2kd8X/l0JKrJk5N4NHeeXIXxbu3jxy4Baa1KUBKwVFfq//wmv3" +
                                                              "rpIfC/MLtkiXgou5n6nTnyQ1JmW2qfmhYUXe703o5vnw1Dt+ry/eKBYJmXz7" +
                                                              "NRNrCaCZLLH2IA42pOAwZUPQAfH4dkN77GbpVLqu48SgwecP+a2Qf8n93poV" +
                                                              "ZmINaBoWAJFP2nu46KMl7PEoDkcg18EeAVt87TOwRTOutcLT4ijUchNb7Css" +
                                                              "kTOxBrR0+iDXDFMlzHASh28yUp4cWZ8K2OHE/8MOWbiuFruRYyswv+Crn/hS" +
                                                              "JT873VA9b/q+d3j5yX9NqoNCkrZV1QtWnvdKw6RphWtVJ6DL4D/TxUqq+FbA" +
                                                              "8LsevvDTnxb032WkMUgPBsIfL9kZRmo9ZAybR/7mJToLAQZE+HrOyBX4Rt4B" +
                                                              "IWhHBGhnQ57i7JiSe6DlZh7Is3hvgFhS+WfXXPmzxYfXhHxxesfOB65/7mlx" +
                                                              "A5VVaXISpdRC5ysuw/kSunxGaTlZlb2rb8y+NGtlDmyaxIHdMF7kCbNBCEgD" +
                                                              "Xb4wcD2zOvK3tPfObHrp58cq34Iuai8JSYzM2VvY3mQNG7Brb6ywwwe44ffG" +
                                                              "ztXfmdi8Lv233/IGkogbweKZ6aF9e/zdvkujn2zh3/kqAEdplvdd2ye0QSqP" +
                                                              "mb7rwmyMRgk/wHI7OOarz8/i9wpG2gvvSoVfeaC5HqfmNt3WeObBhaPWnfF9" +
                                                              "/82hjm0YAQZ3xnOf3I7DxixaH+IvEes3jNxV8qDB87K7WLXo5szP81ccXvgf" +
                                                              "kj8DsoEZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
