package org.apache.batik.dom.svg;
public interface ExtendedTraitAccess extends org.apache.batik.dom.svg.TraitAccess {
    boolean hasProperty(java.lang.String pn);
    boolean hasTrait(java.lang.String ns, java.lang.String ln);
    boolean isPropertyAnimatable(java.lang.String pn);
    boolean isAttributeAnimatable(java.lang.String ns, java.lang.String ln);
    boolean isPropertyAdditive(java.lang.String pn);
    boolean isAttributeAdditive(java.lang.String ns, java.lang.String ln);
    boolean isTraitAnimatable(java.lang.String ns, java.lang.String tn);
    boolean isTraitAdditive(java.lang.String ns, java.lang.String tn);
    int getPropertyType(java.lang.String pn);
    int getAttributeType(java.lang.String ns, java.lang.String ln);
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1445630120000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye3BUVxk/u3mHQB5AiDwCgZCRR3eLip0SKg2BNAkbshLK" +
                                          "TIOynL33bHLJ3Xsv955NlrT0qZbhD2RKWqsWxnHotDqUdrQdO9UyOFZbBrUD" +
                                          "VqVlBB3/qC9m4A9FB7V+3zl3d+/ebLY6TczMPbl77ne+8/2+9zmnrpEyxybL" +
                                          "LWqoNMQPWMwJRfE9Sm2HqZ06dZydMBtTDv/u2EM3f1H1SJCUD5I5w9TpU6jD" +
                                          "ujSmq84gWaIZDqeGwpztjKm4Imozh9mjlGumMUjma05P0tI1ReN9psqQYBe1" +
                                          "I6Secm5r8RRnPS4DTpZGhDRhIU24w0/QHiE1imkdyC1YmLeg0/MNaZO5/RxO" +
                                          "6iL76CgNp7imhyOaw9vTNlljmfqBId3kIZbmoX36elcRvZH1k9Sw/KXav906" +
                                          "Olwn1DCXGobJBURnB3NMfZSpEVKbm92qs6SznzxISiJkloeYk9ZIZtMwbBqG" +
                                          "TTN4c1Qg/WxmpJKdpoDDM5zKLQUF4qQln4lFbZp02USFzMChkrvYxWJAuyyL" +
                                          "NmNuH8Qn14QnvrKn7jslpHaQ1GrGAIqjgBAcNhkEhbJknNlOh6oydZDUG2Dw" +
                                          "AWZrVNfGXWs3ONqQQXkKXCCjFpxMWcwWe+Z0BZYEbHZK4aadhZcQTuX+Kkvo" +
                                          "dAiwNuawSoRdOA8AqzUQzE5Q8D13SemIZqjCj/JXZDG2bgMCWFqRZHzYzG5V" +
                                          "alCYIA3SRXRqDIUHwPmMISAtM8EFbeFrUzBFXVtUGaFDLMZJk58uKj8BVZVQ" +
                                          "BC7hZL6fTHACKy30Wcljn2vbNx653+g2giQAMqtM0VH+WbCo2bdoB0swm0Ec" +
                                          "yIU1qyNP0cbXDwUJAeL5PmJJ870Hbty9tvnsW5JmUQGa/vg+pvCYcjI+58Li" +
                                          "zlV3lqAYlZbpaGj8POQiyqLul/a0BZmmMcsRP4YyH8/u+Ml9D3+b/TlIqntI" +
                                          "uWLqqST4Ub1iJi1NZ/Y9zGA25UztIVXMUDvF9x5SAe8RzWBytj+RcBjvIaW6" +
                                          "mCo3xW9QUQJYoIqq4V0zEmbm3aJ8WLynLUJIBTwkAM9nifxbjAMnyfCwmWRh" +
                                          "qlBDM8xw1DYRPxpU5BzmwLsKXy0zHAf/H7ltXeiOsGOmbHDIsGkPhSl4xTCT" +
                                          "H8OqmQw7o0PhrWkOIkOqtKnGOxSgdULodtb/e8M0amDuWCAAxlnsTw06RFW3" +
                                          "qavMjikTqc1bb5yOnZduh6Hi6o6TtbBrSO4aEruGYNcQ7BoqsCsJBMRm83B3" +
                                          "6QVgwxHIBpCOa1YNfL5376HlJeB+1lgpWiAtwnNR5gcs9EkpEsFdA9bxSz//" +
                                          "4yeDJJjLGbWeZD/AeLvHT5Fng/DI+pwcO23GgO43T0ePPXnt8d1CCKBYUWjD" +
                                          "Vhw7wT8h6ULy+uJb+9+9euXkO8Gs4CUcEnUqDjWPk0oahyxHFc5JVTZdSWDz" +
                                          "PoC/ADz/xgcx4oR0vYZO1/+XZQPAsjzqCIj3JqgmUxrAo3jU3ZKp0opIiScf" +
                                          "nTih9j+7TgZ/Q36oboVK9MKv/vXT0NO/PVfAB6q4ad2ms1GmewSshi1bJvUW" +
                                          "fSLrZmp0TLnj4s2Sy0801Qjb1cShrcjV9ta82i5bE9tUmArFZaoqn6l0q6eu" +
                                          "634R3nz0Twt3fmZ4rxDBW6mRVxkUGVwZxfqa5b7Up0o/y2/1nTp3T5vyRFCU" +
                                          "FkzTBUpS/qJ2r1JhU5tBDTUQFs7MTmOj5otQvy5iyupl9JXY6wdbg6QUag3U" +
                                          "V04hH0LpavZvnlce2jNhg1tVghISpp2kOn7K1MdqPmybY7kZkTrqpReDsWvQ" +
                                          "aRfA0+ImUPEfvzZaOC6QqUbQN4uxBYdW4SlBfF2JQ5sg+zh4TlsuMiHj65AE" +
                                          "0SKt9xpgbC2h0bjOMGf8s3blulf+cqROOqUOMxkTrf1wBrn5j20mD5/fc7NZ" +
                                          "sAko2HHkskeOTJaxuTnOHbZND6Ac6UcuLvnqm/Q4FEQoQo42zkRdCeSHap1Y" +
                                          "ic1FSDYXAu5m8fkuMXag2tx0h7+7cLiTk1nQdIO9RRMFIrR64wqb6oEUJJmo" +
                                          "rSUhwY26Jf/Fxpv736gY35Ip54WWSMptTt/br3W/HxMRUIlBmPU7T3h12EMe" +
                                          "29cJS2FeWVWkhc6XKHyw4erIM394QUrk71h8xOzQxOEPQkcmpGllW7diUmfl" +
                                          "XSNbO590LcV2ESu63n/x4PefP/h40NV5iJOKuGnqjBpZm2QMiU2MT49S2vJ1" +
                                          "x//x0Jcu9UPk9ZDKlKHtT7EeNT+mK5xU3KPYXC8oI9wjN5YBTgKrLSstrF1Y" +
                                          "wZ7jQkw5+s712buun7kh1JV/3vCWwj5qSQ3V47AB2S/wF+Nu6gwD3afObv9c" +
                                          "nX72FnAcBI6ijvTb0A+k8wqnS11W8d4Pf9S490IJCXaRat2kahfFzh76M0gd" +
                                          "zBmGViJtbbpbpoexShjqhJuTSY6PQba0cPhuTVpcBNz4qwte3vjciSui5goO" +
                                          "n8hPRvjS5iajto+UjPKjM5ij6hSDoFKLxHACBzgWVEIMi5KMv3sF6S4c9spm" +
                                          "4L7/Tjc4sacQ4GXwrHEBr5lGwK7r57BaRbDaOIxwMk/LpqsOQ0tSjvnWh1uf" +
                                          "HtxYaW53cd8+44Z+oAj4B3EY43jhkb25mBJ9enrQN8Oz3kW/fiatfqgI8MM4" +
                                          "PAY9q8fqqiqyrA/1F6YH9VJ4NrioN8y4zSeKQH8Khy9zMtdr88LYj04P9iXw" +
                                          "bHKxb5px7N8ogv2bOHydk3pN5rUpff2Z6UG+CJ4tLvItM478VBHkp3F4Dipr" +
                                          "Bnlhiz//kXHjAtFX97q4e2cyxl8tAvk1HL4LkIcYzwR59jjQLdhLtNs87/2c" +
                                          "lGju5aVvx53pnJ5enh49NcETdfUUnXH/OFdEWedxeAMaflBWNi1kOr0f5ID/" +
                                          "+H8HnoZcU+BmBXumpkm3u/JGUjl9orZywYl7fy2Ohdlbwxro9RMpXfd0qN5u" +
                                          "tdyyWUITcGpkx2iJfxc5aZrqygHMDaOQ/IKk/iX0AoWogRJGL+UlUJefkpMy" +
                                          "8d9Ld5mT6hwdJ+XyxUtyBbgDCb5ehRY6kH+LlNX+/A/TvufiaUVeDy5u2zNn" +
                                          "gJS8b4cD14ne7fff+PSz8h5K0en4OHKZBZ2/PFBn7w9apuSW4VXeverWnJeq" +
                                          "VmYOJfVS4JwXL/K42x6IKQs9YKHvaOq0Zk+o757ceOZnh8ovQje/mwQoeNFu" +
                                          "z123vNiF820KWu/dkUJnnF3UFqfm9urf73377+8FGkTrTeSpqLnYiphy7Mzl" +
                                          "aMKyvhYkVT2kDM5cLD1IqjVnywFjB1NG7bwjU3ncTBnZi/k56K4UD8tCM65C" +
                                          "Z2dn8RaEk+WTD4aTL4rgVDLG7M3IHdnM9t24pCzL+1VodkAmM9Q0+FQs0mdZ" +
                                          "7hVdyV+F5i1LhOV1kdL+AzQudH1SGwAA");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1445630120000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAAL1aecwsWVWv97156yzvzZvVYXYeE4cevuruquqFQWa6eq+u" +
                                          "6q2qeimUN7V27Xt1VTcO4hiEQAKow2KE+UMhCBmWqEQjQYcYWQJqMIhKFAga" +
                                          "FYHI/OESUfFW9be97y0T8nx2Urerq8695/zOdu89t5//PnQs8KGc65irhemE" +
                                          "23ISbusmth2uXDnYJkhsyPuBLNVNPggY8OyC+PAnz/zbD9+lnt2CjnPQbbxt" +
                                          "OyEfao4djOXAMZeyREJn9p82TdkKQugsqfNLHo5CzYRJLQgfJ6EbD3QNofPk" +
                                          "rggwEAEGIsCZCHBtnwp0ulm2I6ue9uDtMPCgN0JHSOi4K6bihdBDFw/i8j5v" +
                                          "7QwzzBCAEU6mvycAVNY58aEH97BvMF8C+N05+Nn3vv7sbx2FznDQGc2mU3FE" +
                                          "IEQImHDQTZZsCbIf1CRJljjoVluWJVr2Nd7U1pncHHQu0BY2H0a+vKek9GHk" +
                                          "yn7Gc19zN4kpNj8SQ8ffg6dosint/jqmmPwCYL1zH+sGYSt9DgCe1oBgvsKL" +
                                          "8m6XGwzNlkLogcM99jCe7wEC0PWEJYeqs8fqBpsHD6BzG9uZvL2A6dDX7AUg" +
                                          "PeZEgEsI3XPFQVNdu7xo8Av5QgjdfZhuuHkFqE5liki7hNAdh8mykYCV7jlk" +
                                          "pQP2+X7/Ne94g92xtzKZJVk0U/lPgk73H+o0lhXZl21R3nS86ZXke/g7P/PW" +
                                          "LQgCxHccIt7Q/O7PvvjkY/e/8IUNzcsuQzMQdFkML4gfFG75yr31R6tHUzFO" +
                                          "uk6gpca/CHnm/sOdN48nLoi8O/dGTF9u7758Yfy5+Zs+Kn93CzrdhY6LjhlZ" +
                                          "wI9uFR3L1UzZb8u27POhLHWhU7It1bP3XegEuCc1W948HShKIIdd6AYze3Tc" +
                                          "yX4DFSlgiFRFJ8C9ZivO7r3Lh2p2n7gQBJ0AF3QEXCNo87k3bULIglXHkmFe" +
                                          "5G3NduCh76T4U4PaEg+HcgDuJfDWdWAB+L/xqsJ2GQ6cyAcOCTv+AuaBV6jy" +
                                          "5iUsORYcLBdwMwmByLLE+LwW1kRAG2ynbuf+fzNMUg2cjY8cAca593BqMEFU" +
                                          "dRxTkv0L4rMR3nzx4xe+tLUXKju6C6HHANftDdftjOs24LoNuG5fhit05EjG" +
                                          "7PaU+8YLgA0NkA1AnrzpUfpniKfe+vBR4H5ufENqgSQLz7uzH0dBv0evnLtb" +
                                          "aeLoZslSBL58938OTOGZb/9HJvHB9JsOuHWZeDnUn4Off/899dd+N+t/CmSq" +
                                          "kAeeBZLA/Yej9qJAS8P3sCZBAt4ft/hR61+3Hj7+x1vQCQ46K+5k9wlvRjIt" +
                                          "gwx7Wgt2Uz6YAS56f3F22oTi4ztZIITuPSzXAbaP76bSFPyxgxYE9yl1en86" +
                                          "84ZbMppbfwQ+R8D1P+mVWiJ9sImJc/WdwHxwLzJdNzlyJISOFbfL2/m0/0Op" +
                                          "jQ8rOBXgp2j3A3/1p99BtqCt/fR+5sCECZTw+IGUkg52Jkset+67DOPLqbL+" +
                                          "9n3DX3n399/yusxfAMXLL8fwfNqmEoP5Ecwzb/6C99ff/MYHv7q152NHQzCn" +
                                          "RoKpieAmyKY7gETRbN7MFPJwCN2lm+L5XdQTMP0Bwc7rZjlT1R1gws9ES62y" +
                                          "vZkzsrACEp2/grsemOcviO/66g9unvzgD168xFMvVgzFu49vLJRJlYDh7zoc" +
                                          "RR0+UAEd+kL/p8+aL/wQjMiBEbPIG/ggkJOL1LhDfezE1z/7R3c+9ZWj0FYL" +
                                          "Om06vNTi0ykZJNZQBbO4CnJA4j7x5CYxxidBczaLTSjD/7KNOFlY37KvCNIB" +
                                          "U+fb//5dX37ny78J5CCgY8vUh4EEB7TVj9LVxC8+/+77bnz2W2/PbALS8PA9" +
                                          "zbNPpqNWMgavyNqfTJvcxmLp7WNp86q02d410z2pmegsF5J8EFKOpIHVhJRZ" +
                                          "6qqpY+hrFvC25c5UCT997pvG+//pY5tp8HCeOEQsv/XZt/1o+x3Pbh1YfLz8" +
                                          "kvn/YJ/NAiQT+uY9Uz50NS5Zj9Y/fuLpT//m02/ZSHXu4qm0CVaKH/vaf395" +
                                          "+33f+uJlcvQNprPrlGlb3GGbfmEvbdjw5ic7aNCt7X7IwlxGcHaSGHCEWJ0R" +
                                          "jtW0RlxfcPXxGJFJzc3TvUUR79cMIVDJHtMdrGwSQYQOSSCzYFnFsL7pM3mP" +
                                          "E9RGcdybesE0sTtO2PBYyR9Jgyq7GrQ4AffZxsSbmDiOwF69aqG1agsvT3LI" +
                                          "2kSkHCwL5LzEiGtqKJjlsi3nKnAxV11btu82V8lKIMmp5/Sp0XBKxcRYaVZp" +
                                          "q9jxuHxJ4lYShYdMYwlHxSaFKIVOgSbqbAPrYnGVcdmS3oh02vIq6GLKd7mG" +
                                          "J7djdx3qPQvtWs5arVq62Y4sitUtPo8N82G3MJb7VTfwRnNcLnRLtCxamF8Z" +
                                          "j+0hjTYYl2urjbHaZYtonIdHHa1Z0CxDWtULc4uUF3mY6vPcAIPHyaCkkeVS" +
                                          "fdF3y5qlrgZ8XF0yfdPULcXDuxJidDnBcmZISTbF8ZLrFIwqHcO9Gb+s5ksD" +
                                          "M7YLjfqs7QgEzo5tHOlTCke7zUlPsKpFLyjRa3uddGmNMExHnhtVrsuFVCzg" +
                                          "Xpth+qhYGC3gaWK5RE9ynUaDwtY9csS2UG9k2qjZEjg3X2Tp1pqqq4a/nCdT" +
                                          "ohatVmTf6kedysguoCN76ffssh6YbocfFdp+u9b19AVeE/uq0VQFwrD75kAt" +
                                          "OSuJa7DtYiOuTTl/0lfas2mADPreaDQzerN6XW+5CTUV46mc4/I4N28KHa6H" +
                                          "8rykcuKIiWa5nrF0pJoW9yM+pp2xNKhVat6aHa2b2KjSKCC0bHU5T6/rMDHj" +
                                          "Gu2isKDq05Y35jrr+bqNgem0Pu/WEHo8G3uNLtuJhxbVpWshVWm2BLnls2u8" +
                                          "NZuEbJtvNUiKIwysEvX0Cj7hJiO8XlY5sqQwnVq9t0LyU9HU7eJS6CclDMkt" +
                                          "igttVKO8kMpPOrmpUHeKguTg+SC28k1x1WUL3qo/zIvCrBGzRE0G2cciiEo5" +
                                          "3xHCVTVc2sEUIyx21Obh5SLnLutzUe/msAqprc0JYnq1uckJLt/WK8PBSFt5" +
                                          "ZGTCPNCRZVFiMB6i81WnAkc5yqw2kJwAM2bXs8NuNCU9j2ZQVihohFboc/C8" +
                                          "um7Xihi7DruTGcU2lq1qgtE1uTJeT/FVqOfGIq4vu/y0BLagSDKtjtgRMXe6" +
                                          "nodO8uumJVgIT1SmJAhtlujiTGzUqKqtKYmg1yh7pdRjazpWPRNvUJUkLjTm" +
                                          "42Hishi+tmIy6M1W+XWnpsCdshnOZG0QtAeW0Gl0g7YxVGkTTZg606kMPGsU" +
                                          "l538UPWnxqBrDLywZ7cHCb2QWNKRQgGWK1SetxrRtF6rJaYdMHG+NG5NEY9f" +
                                          "UrpmMJ5YEARsNbA5KVJLHa3klJgQZBZ6gPJNP2rP++KojDteUA8InBpbFQRH" +
                                          "SqPJIk46XdytD/jCvK+QGFIudUxCxnMFc+FOtVoY2/0xthCDatNwm0FLqlWF" +
                                          "hF7DMLqSGwShk21hKnMNGJh32WGwFliuNbo5NxYHRaS9GKAIk5eHw5kdVqRC" +
                                          "vd7D5+xUb0zUuBwzFbXEkqtcRAi5aq4qRzNjUGkHaJ0VmzbrNfTp0Mg7vLpK" +
                                          "Oi0RIyYMJ9HTxnro1OFaYw0nCzFBnXF+OecGBTg340bDWqCvvXpXRwhvYbGJ" +
                                          "X3MQnUW4npt33K5Gi4rNaGpVz5WZBQePkJIjOJNeleot4eWMyfcH8HCi1PCS" +
                                          "h/JS0QoKbUuO6UDVCgKxZKcKTfqc5eYZ0tbRoEiv8pV8YaQLBZFWfVGfVEO+" +
                                          "UtQwoVkNWavmtzje8eySmfdKclRC0DFir/NMHCKKxaF+0sCBt43BvMK2JzGX" +
                                          "KB6PCWUWCAqvinDBZlyEwZarcavOtow1g7MuDXtE0S8QKouFeINhR62gTDHW" +
                                          "QMeccLRcYdoqcs0qMZuXYklYlEYsv0DYSR5VO3nS5Zfc0jZFuaj31UUhnCzU" +
                                          "Lu26RWNgl3sFSvKG1kqYlw3OYHzPHcuNYLoc8WOlls91LXbYVJZrjh/USyOP" +
                                          "FUZ9NErwuTRFaRNXWkVihAWL3FpFGTOIKK2jl7BaE8yKYTVxF0K9qOYFfUC1" +
                                          "lUqACGZkKjnRGw8GHjugEsBNKcS4b2N6MW81MFgRy30uqBlOsdMxAkMeMASf" +
                                          "RIw96Ahcv1GqiSVWjMil7VnwCG01R87IQYtrYyzVZbrDu4W5JhZadGM+q0WY" +
                                          "VVGMiJrxi2KY5NVyriySGmMU7JHUHVTHY6rV9cclNPaEktNkCcJyfJpV43mx" +
                                          "RChwK3GXZaS0mCNY18XQ6ZSm3JAJYcFHpnAnocZs18StIVtmELUA5lW5WBUJ" +
                                          "utiSp5OpoYqlWa+zilHZ71JIFR2xvlEuqJVksB4lg+ZwZIiW2zbNaVnSWEsx" +
                                          "Z3RfGGDVPClOik0auIoNJ+hQVoawiub7E0wjBr2obXs67nJWcURpbJFi0Cpd" +
                                          "XBKFBIaTPCFGVXYIprhGz+x1QqbclPtMzuphCYv0hvNZveJ0q7Hex+Y4s+j5" +
                                          "JB2Efqswj7myPjJiLBeUC0UhiuyyoRaICYws69NYxzx6hEzQcg0v0nDcyvWj" +
                                          "0iJuILwyEJZV0Z6Viy27JuLdkqYvGSFfyxmV2LPpQmFakdChUqXRar5L1Gf8" +
                                          "mA+LBq8qrbVaLlH5hbTGrfZEI0JBcAXXkRNa1T2ViBh6XhqOBD4vDtWImbgi" +
                                          "3l+jXhzKyFIXNTrSsIUzsCvqcLzUaUzj9dDJsfqwp1OYppdUuuG0emQC5il8" +
                                          "vZhOml1Kw3rUEglaJRoVq4FroWQZZnQRDXhxhLZnsd9p4j5mtuNe2cfKOD8W" +
                                          "Gvygm8SUAZOuFwxG+ZDWl/ZULURKJ0zm/BRDRKmSQ1Eu59R0FEeacxTRVUMo" +
                                          "YhZOVGXbH/UrgzViTGFF40PFW3QrFIUOa/OqV1E8T/NWfg0utErzTnVCoH1f" +
                                          "c/qVFbqm5d6oU+mpq+qaCiW/UiHneh4dVrVZLHR6iYC5SblfcRbLojDorCQD" +
                                          "cfuYz7qKUuRKbDtXJ9CQXHZDCi1XJnjHcJEW2tBcH7dNVQN52ph19FrYmlXL" +
                                          "HioXxVViVsLa0ih0SJQ0uuJ8HY+xqq6PSEklw35QKcNF0WzrEcZPlgmGuDaB" +
                                          "ybaKVvtik5EUlrVnHXjQkppTWUrkGsUrJj7tawVj4OcVrNuAc51Kx3Y4kc3h" +
                                          "Fj6LLNewkAgm2qxuVh2fW8Vzs6ysigNVMoU48Z3qmHJnipT3+lgUSqvVlO0y" +
                                          "Yts1kqJGKImI8ZzvrRYdClhnBHd7BqzN8jVn6izGRJvMsSZLyIrhUquKVCUl" +
                                          "zGJKaiwRudkqYcMVLiwadQGT1fG8ZHRypNmf5eAazCwjYCF2IjdWWFRc9+0F" +
                                          "QVcEVGwUUFsuK4qSG9Lrior18rKNDjo9DueK8LCF2+W4yrsRPUUnM3kp+1Ob" +
                                          "kL2JNR8QyoRGiXhGwj20mJS6vVFQnfc6S37g5Tkj55SxsigPOFutOMuRLsNW" +
                                          "PHLkfitaF4rIsq+1KsV8bxrBksEStt1C2JanWNXIV8oIUi7nKq02SJWMTLse" +
                                          "ac81V12VqbXJU73VUp0bE6ZogAWsSDYKYAU6sVdxS8cL/XZZiMHkZ4sMbnMa" +
                                          "bGClHso2KmGdKmF1rijZlTHfNHJTpoHyDIn6i0mDbJcppNuRbKoaFlG3viZz" +
                                          "hYkjGTWLqo7yudYoyFsSV1Yn0mqSa2FagVQHk4IhkbnaehRJYGvRjmu1dCvV" +
                                          "/fF2s7dmRYe9qjXYxKYv8j/GLi65GsMQOskLIOmBrX4Indoro2+4H6i6Hdkt" +
                                          "cpy/Yp3vQH0v3cred6XqdbaN/eAzzz4nDT5USLex6cgNwD103FeZwHfMA3xP" +
                                          "g5FeeeUtO5UV7/fLap9/5p/vYV6rPpXVlS4p95HQ6bTnMD0j2TsLeeCQnIeH" +
                                          "/Aj1/Bfbj4i/vAUd3SuyXXKscHGnxy8urZ325TDybWavwOZDD1+yz3dEWYp8" +
                                          "eZ/vKx/kP3XhM0+f34JuOFh5TEe471Ad70bF8S3eTBnsnmOcDlXfifefHCzq" +
                                          "AbXelLrGXeB6aKfQnX2nb29z0/b2ZN/BLvGcrT1XHe/4iQ89sl9PqjumKYuZ" +
                                          "1s+ztpWVX3jBlNPa7n+deUXhU997x9lNccIET3bN8NhLD7D//Cdw6E1fev2/" +
                                          "358Nc0RMT4b2K2T7ZJvjhtv2R675Pr9K5Uh+/s/v+9XP8x84Ch3pQjcE2lrO" +
                                          "6v9HNr6eRVgGTc2wi1m7yAJrU49Of+tpcyGEblT5ANgvO9jKCJ84EJH1EDoh" +
                                          "OI4p8/Z+tD71UjWXg6yyB6+72HK3g+uRHcs9ck2Wuxje1j5Vfl8J8VWUsEob" +
                                          "H2QRoIQsAaS/zX2owbVCfRBcuR2ouf9DqJeY+heugvLNafPGELpd27N0zdYs" +
                                          "Pkzd8hDin7tWxGko5ncQ56+7cd95Fdi/lDZvC6E7tKAWhr4mRKF8Rdxvv1bc" +
                                          "94ML28GNXU9L/9pVIH8gbd4TQucOWFqSshLsIbzvvVa8D4Dr1Tt4X33d7fzh" +
                                          "q4D+SNr8egjddtDOl0f9G9eK+j5wPbGD+onrjvq3r4L6U2nzcbDC0jaZ64qe" +
                                          "/YlrxfwycDV2MDeuO+Y/vArmz6bN74fQmV3Ml7fyp68BcUqaLS2IHcTE9Yzl" +
                                          "L10F7J+kzecA2IUc7gbz3oro0CR9VNv5b02G//PXiv9ucA138A+vu8W/fhUl" +
                                          "/E3a/EUInQVK2Avu3aXon+1D/tqPAzkBueIyx/rpauvuS/5atPk7jPjx586c" +
                                          "vOs59i+z9ezeX1ZOkdBJJTLNgyfRB+6Pu76saBmQU5slrJt9/V0I3X2ljQgw" +
                                          "Jmgzmb+9of4HMHNfjhpQgvYg5XeAog5ThtCx7Psg3fdC6PQ+XQgd39wcJPkX" +
                                          "MDogSW9/kB6MH9jU7PhMpvdzL6X3vS4HT7bTjVD2V6/dTUu0+bPXBfETzxH9" +
                                          "N7xY+tDmZF00+fU6HeUkCZ3Y7BL2Nj4PXXG03bGOdx794S2fPPWK3U3aLRuB" +
                                          "9/33gGwPXH793rTcMFtxr3/vrt95zYef+0Z2uvu/uDFVOoMnAAA=");
}
