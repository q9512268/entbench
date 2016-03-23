package org.sunflow.core.modifiers;
public class NormalMapModifier implements org.sunflow.core.Modifier {
    private org.sunflow.core.Texture normalMap;
    public NormalMapModifier() { super();
                                 normalMap = null; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            normalMap =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  true);
        return normalMap !=
          null;
    }
    public void modify(org.sunflow.core.ShadingState state) { state.
                                                                getNormal(
                                                                  ).
                                                                set(
                                                                  normalMap.
                                                                    getNormal(
                                                                      state.
                                                                        getUV(
                                                                          ).
                                                                        x,
                                                                      state.
                                                                        getUV(
                                                                          ).
                                                                        y,
                                                                      state.
                                                                        getBasis(
                                                                          )));
                                                              state.
                                                                setBasis(
                                                                  org.sunflow.math.OrthoNormalBasis.
                                                                    makeFromW(
                                                                      state.
                                                                        getNormal(
                                                                          )));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYDYxUVxW+M/v/w/7BLssCCywLDQudV7BYm0Vk2bJlcHaZ" +
       "sJTooCxv3tzZeeyb9x7v3bc7u+1qSzWsRgm2FLApRBOaVkILMSVqtA2m0bZp" +
       "NWmtttWUGjURrcQS09aIWs+99/3P7CKJTvLuu3PvOefec+453zn3nbuKKkwD" +
       "dWKVxMikjs3YNpUkRcPEmX5FNM3dMDYinSgT/7bvytCdUVSZQg050RyURBMP" +
       "yFjJmCm0VFZNIqoSNocwzlCOpIFNbIyLRNbUFGqVzXheV2RJJoNaBlOCPaKR" +
       "QM0iIYactgiO2wIIWpqAnQhsJ0JfeLo3geolTZ/0yNt95P2+GUqZ99YyCWpK" +
       "HBDHRcEisiIkZJP0Fgy0VteUyVFFIzFcILEDykbbBDsSG4tM0HWh8YPrR3NN" +
       "zATzRVXVCFPP3IVNTRnHmQRq9Ea3KThvHkRfQGUJVOcjJqg74SwqwKICLOpo" +
       "61HB7udh1cr3a0wd4kiq1CW6IYJWBIXooiHmbTFJtmeQUE1s3RkzaLvc1ZZr" +
       "WaTiI2uFYyf2NX23DDWmUKOsDtPtSLAJAoukwKA4n8aG2ZfJ4EwKNatw2MPY" +
       "kEVFnrJPusWUR1WRWHD8jlnooKVjg63p2QrOEXQzLIlohqteljmU/a8iq4ij" +
       "oGubpyvXcICOg4K1MmzMyIrgdzZL+ZisZghaFuZwdez+NBAAa1Uek5zmLlWu" +
       "ijCAWriLKKI6KgyD66mjQFqhgQMaBHXMKpTaWhelMXEUj1CPDNEl+RRQ1TBD" +
       "UBaCWsNkTBKcUkfolHznc3Vo05F71e1qFEVgzxksKXT/dcDUGWLahbPYwBAH" +
       "nLG+J3FcbHt2JooQELeGiDnN9+67tmVd56UXOc3iEjQ70wewREakM+mGV5f0" +
       "r7mzjG6jWtdMmR5+QHMWZUl7pregA8K0uRLpZMyZvLTrp5+9/yx+N4pq46hS" +
       "0hQrD37ULGl5XVawcTdWsSESnImjGqxm+tl8HFVBPyGrmI/uzGZNTOKoXGFD" +
       "lRr7DybKgghqolroy2pWc/q6SHKsX9ARQlXwoA3w1CH+Y2+CPiPktDwWdFlI" +
       "GhpV3RQAbNJg1pxgWmpW0SYE05AEzRh1/0uagQUAHhlc2TCFIc3Ii8qgqA/a" +
       "QzHqYfr/UXaB6jV/IhIBky8JB7wCsbJdUzLYGJGOWVu3XXt65GXuTDQAbIsQ" +
       "tA5WjdmrxuiqMXfVWNGqKBJhiy2gq/OzhZMZgxgHkK1fM/z5HftnusrAqfSJ" +
       "cjArJe0KJJt+Dwgc9B6RzrfMm1pxef3zUVSeQC2iRCxYFPC8zxgFVJLG7MCt" +
       "T0Ma8rLBcl82oGnM0CScATCaLSvYUqq1cWzQcYIW+CQ4uYpGpTB7pii5f3Tp" +
       "5MQDe754WxRFgwmALlkB2EXZkxS2XXjuDgd+KbmNh698cP74tOZBQCCjOImw" +
       "iJPq0BV2h7B5RqSe5eLFkWenu5nZawCiiQghBejXGV4jgDC9DlpTXapB4Szz" +
       "Ejrl2LiW5AxtwhthftrM+guckFsCT4Mdg+xNZ9t02i7kfk39LKQFywafHNZP" +
       "vfnzP32MmdtJHI2+jD+MSa8PrKiwFgZLzZ7b7jYwBrq3TyYffuTq4b3MZ4Fi" +
       "ZakFu2nbDyAFRwhm/vKLB9965/KZ16OenxPI1lYaip6CqyQdR7VzKAmrrfb2" +
       "A2CnADJQr+m+R+UhKKYVTAPrn42r1l/8y5Em7gcKjDhutO7GArzxRVvR/S/v" +
       "+7CTiYlINNl6NvPIOILP9yT3GYY4SfdReOC1pd98QTwFuQDw15SnMINUxGyA" +
       "2KFtZPrfxtrbQ3N30GaV6Xf+YHz5iqIR6ejr783b895z19hug1WV/6wBnHq5" +
       "e9FmdQHELwyD03bRzAHd7ZeGPtekXLoOElMgUYJSwtxpAD4WAp5hU1dU/frH" +
       "z7ftf7UMRQdQraKJmQGRBRmqAe/GZg6gtaB/ags/3IlqaJqYqqhI+aIBauBl" +
       "pY9uW14nzNhT31/4zKYnTl9mXqZzGYtdVF0SQFVWm3uBffYXd/zyiW8cn+DZ" +
       "fc3saBbia//HTiV96Hd/LzI5w7ESlUeIPyWce6yjf/O7jN8DFMrdXSjOUADK" +
       "Hu+Gs/n3o12VP4miqhRqkuxaeI+oWDRMU1D/mU6BDPVyYD5Yy/HCpdcFzCVh" +
       "MPMtG4YyLzNCn1LT/rwQetXTI+x0Os7bj14RxDpxxnILa3toc6sDFlW6IcN9" +
       "CYfQom4OoQTVqE42ZlztUIMVpe7dcMSA8Rw+afsJ2uzg6/SWclY+dQtt1rq7" +
       "Yb/KcJHkxy6/N9q7WVS0G6dqoEG5dLZKl1XpZw4dO53Z+fh67rEtwepxG1yO" +
       "nvrVv16JnfztSyUKmBqi6bcqeBwrvl1F6ZKBGBlklwDP4d5ueOj3P+ge3Xoz" +
       "RQcd67xBWUH/LwMlemYPu/BWXjj0547dm3P7b6J+WBYyZ1jkdwbPvXT3aumh" +
       "KLvx8EgouikFmXqD/l9rYHAldXcgCla6LjKfesQieJptF2kuncNLeJebGWdj" +
       "DeWQqH2itp91FvkZMw2GixvFTYeszU82zN99yTjb1ugcWSpPmzQkdEvPQIgG" +
       "K1jqIMNW2oRqU85DcTFu37k2JPdLM93JP3D/XVSCgdO1Pil8fc8bB15hJ11N" +
       "Xcu1r8+twAV9dVMTN9xH8IvA82/60N3SAX53aem3L1DL3RsUzRhzQn9IAWG6" +
       "5Z2xx648xRUI43yIGM8c++pHsSPHeDDya/jKopuwn4dfxbk6tGGQsGKuVRjH" +
       "wB/PT//wyenDUftsUgCdaU1TsKi6Zxdxc+KCoNn5Xu/6SuOPjraUDUCYx1G1" +
       "pcoHLRzPBF29yrTSvnPwbu6e49u7pjYnKNLjJGQGr9Ic8Ppf1AJ0oI9j+r5g" +
       "idwDT7sdI+03H16zsYacPxKE8aVF4TWcEzOySlERMhalmpkjfL5GmwchfFgF" +
       "OsloiH3k9FUgqHxckzOe+b70vzAfiG0uuq3SMqu96DsY/3YjPX26sXrh6Xve" +
       "YPjvfl+ph7DMWoriLwR8/UrdwFmZKVrPywKdvU4Q1DH7PRpylNtnChznXI8S" +
       "1BTmAvPQl5/sFEF1PjJC/ZX1/ETfIqgMiGj3226B0MRqTFoWxXhZVIj4ciTy" +
       "+XDrjQ7BZfHfkSiqsM+RTthZ/IMkXOlP7xi699rHH+d3NEkRp6aolDoINn5d" +
       "dDPZilmlObIqt6+53nChZpWDAs18w14ALPb5Xx+4sk4PviN0gTG73XvMW2c2" +
       "PfezmcrXAL/2oohI0Py9xQVkQbeghNibKAYVyPrsZtW75tHJzeuyf/0NK9FR" +
       "UWEepocC+eE34xfGPtzCvn9VAMDhAqts75pUd2Fp3AggVAP1SZF+mGR2sM03" +
       "zx2lN3qCuopxt/g7CFxfJrCxVbPUjI1xdd5I4Luok/wtXQ8xeCO+3HQfj2ye" +
       "hspGEoO67qSl93UWmtNhnGGDjPkZ1qXNxf8A8+FUj5kYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/W9yvWCQryIAAA==");
}
