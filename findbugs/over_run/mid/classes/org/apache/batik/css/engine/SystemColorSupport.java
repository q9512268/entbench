package org.apache.batik.css.engine;
public class SystemColorSupport implements org.apache.batik.util.CSSConstants {
    public static org.apache.batik.css.engine.value.Value getSystemColor(java.lang.String ident) {
        ident =
          ident.
            toLowerCase(
              );
        java.awt.SystemColor sc =
          (java.awt.SystemColor)
            factories.
            get(
              ident);
        return new org.apache.batik.css.engine.value.RGBColorValue(
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getRed(
                )),
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getGreen(
                )),
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getBlue(
                )));
    }
    protected static final java.util.Map factories = new java.util.HashMap(
      );
    static { factories.put(CSS_ACTIVEBORDER_VALUE, java.awt.SystemColor.
                                                     windowBorder);
             factories.put(CSS_ACTIVECAPTION_VALUE, java.awt.SystemColor.
                                                      activeCaption);
             factories.put(CSS_APPWORKSPACE_VALUE, java.awt.SystemColor.
                                                     desktop);
             factories.put(CSS_BACKGROUND_VALUE, java.awt.SystemColor.
                                                   desktop);
             factories.put(CSS_BUTTONFACE_VALUE, java.awt.SystemColor.
                                                   control);
             factories.put(CSS_BUTTONHIGHLIGHT_VALUE, java.awt.SystemColor.
                                                        controlLtHighlight);
             factories.put(CSS_BUTTONSHADOW_VALUE, java.awt.SystemColor.
                                                     controlDkShadow);
             factories.put(CSS_BUTTONTEXT_VALUE, java.awt.SystemColor.
                                                   controlText);
             factories.put(CSS_CAPTIONTEXT_VALUE, java.awt.SystemColor.
                                                    activeCaptionText);
             factories.put(CSS_GRAYTEXT_VALUE, java.awt.SystemColor.
                                                 textInactiveText);
             factories.put(CSS_HIGHLIGHT_VALUE, java.awt.SystemColor.
                                                  textHighlight);
             factories.put(CSS_HIGHLIGHTTEXT_VALUE, java.awt.SystemColor.
                                                      textHighlightText);
             factories.put(CSS_INACTIVEBORDER_VALUE, java.awt.SystemColor.
                                                       windowBorder);
             factories.put(CSS_INACTIVECAPTION_VALUE, java.awt.SystemColor.
                                                        inactiveCaption);
             factories.put(CSS_INACTIVECAPTIONTEXT_VALUE, java.awt.SystemColor.
                                                            inactiveCaptionText);
             factories.put(CSS_INFOBACKGROUND_VALUE, java.awt.SystemColor.
                                                       info);
             factories.put(CSS_INFOTEXT_VALUE, java.awt.SystemColor.
                                                 infoText);
             factories.put(CSS_MENU_VALUE, java.awt.SystemColor.menu);
             factories.put(CSS_MENUTEXT_VALUE, java.awt.SystemColor.
                                                 menuText);
             factories.put(CSS_SCROLLBAR_VALUE, java.awt.SystemColor.
                                                  scrollbar);
             factories.put(CSS_THREEDDARKSHADOW_VALUE, java.awt.SystemColor.
                                                         controlDkShadow);
             factories.put(CSS_THREEDFACE_VALUE, java.awt.SystemColor.
                                                   control);
             factories.put(CSS_THREEDHIGHLIGHT_VALUE, java.awt.SystemColor.
                                                        controlHighlight);
             factories.put(CSS_THREEDLIGHTSHADOW_VALUE, java.awt.SystemColor.
                                                          controlLtHighlight);
             factories.put(CSS_THREEDSHADOW_VALUE, java.awt.SystemColor.
                                                     controlShadow);
             factories.put(CSS_WINDOW_VALUE, java.awt.SystemColor.
                                               window);
             factories.put(CSS_WINDOWFRAME_VALUE, java.awt.SystemColor.
                                                    windowBorder);
             factories.put(CSS_WINDOWTEXT_VALUE, java.awt.SystemColor.
                                                   windowText); }
    protected SystemColorSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO+PzB/4GjGuDMY4h4uuulASUmIaAC9hwxlef" +
                                                              "g1qT5Jjbm7MX9naX3Tn7bJLyIaWhVZRGfJWkhT9S0jaIhqgqahsp1FXVJhFN" +
                                                              "ETRqk9CmNPzRpgQp/JE4Lf16M7N7+3FnR5WqWNq58c6bNzPv/d7vvdmzN1Gp" +
                                                              "aaB2HaspHKZjOjHDMdaPYcMkqS4Fm+YAvE1IX//zkX2Tv604EEShQVQzjM1e" +
                                                              "CZtkk0yUlDmI5suqSbEqEXMbISk2I2YQkxgjmMqaOojmyGZPRldkSaa9Woow" +
                                                              "ge3YiKJ6TKkhJ7OU9FgKKFoQ5buJ8N1E1vsFOqOoStL0MWdCs2dCl2uMyWac" +
                                                              "9UyK6qK78AiOZKmsRKKySTtzBlqma8rYkKLRMMnR8C7lbssQW6J3F5ih/cXa" +
                                                              "j24/NVzHzTALq6pG+RHNfmJqyghJRVGt83ajQjLmHvQVVBJFM13CFHVE7UUj" +
                                                              "sGgEFrXP60jB7quJms10afw41NYU0iW2IYoWepXo2MAZS02M7xk0lFPr7Hwy" +
                                                              "nLYtf1rb3b4jHlsWOfrNh+t+WIJqB1GtrMbZdiTYBIVFBsGgJJMkhrk+lSKp" +
                                                              "QVSvgsPjxJCxIo9b3m4w5SEV0yxAwDYLe5nVicHXdGwFnoSzGVmJakb+eGkO" +
                                                              "Kuu/0rSCh+Csjc5ZxQk3sfdwwEoZNmakMWDPmjJjt6ymOI68M/Jn7NgKAjC1" +
                                                              "LEPosJZfaoaK4QVqEBBRsDoUiQP41CEQLdUAggbH2hRKma11LO3GQyRBUZNf" +
                                                              "LiaGQKqCG4JNoWiOX4xrAi81+7zk8s/NbWuf3Kt2q0EUgD2niKSw/c+ESa2+" +
                                                              "Sf0kTQwCcSAmVi2NHseNLx8KIgTCc3zCQubHj9y6f3nrxKtCpqWITF9yF5Fo" +
                                                              "QjqdrLk8r2vJPSVsG+W6ZsrM+Z6T8yiLWSOdOR2YpjGvkQ2G7cGJ/l99ef8Z" +
                                                              "ciOIKntQSNKUbAZwVC9pGV1WiLGZqMTAlKR6UAVRU118vAeVQT8qq0S87Uun" +
                                                              "TUJ70AyFvwpp/H8wURpUMBNVQl9W05rd1zEd5v2cjhAqgwetgWcxEn/8lyIt" +
                                                              "MqxlSARLWJVVLRIzNHZ+5lDOOcSEfgpGdS2SBPzvXrEyvCZialkDABnRjKEI" +
                                                              "BlQMEzEYkUwzQtQh2GEkPmZSAsGtaEY8q+uaAdwDwNM//SVzzAqzRgMBcNA8" +
                                                              "Pz0oEFndmpIiRkI6mt2w8dYLiYsCeixcLPtRFIZ1w2LdMF83DOuGxbrhwnVR" +
                                                              "IMCXm83WF1gAT+4GTgBSrloSf2jLzkPtJQBCfXQGuIGJLi5IUl0OediMn5DO" +
                                                              "Xu6fvPR65ZkgCgK/JCFJOZmiw5MpRKIzNImkgKqmyhk2b0amzhJF94EmTowe" +
                                                              "2L7vs3wfbvJnCkuBt9j0GKPs/BId/qAvprf28b9+dO74o5oT/p5sYifBgpmM" +
                                                              "Vdr9zvUfPiEtbcPnEy8/2hFEM4CqgJ4pBg+Cw1r9a3jYpdNmanaWcjhwWjMy" +
                                                              "WGFDNr1W0mFDG3XecNTV8/5scHENC7c2eEas+OO/bLRRZ+1cgVKGGd8peCb4" +
                                                              "fFw/+eZv3lvFzW0njVpXto8T2ukiKqasgVNSvQPBAYMQkPvjidiRYzcf38Hx" +
                                                              "BxJ3FFuwg7VdQFDgQjDzY6/ueetP75x+I+hglqIK3dAohC5J5fLnZEOoeppz" +
                                                              "Mqg7W4KgUUADA07HAyoAU07LOKkQFif/rF208vz7T9YJKCjwxkbS8k9W4Lz/" +
                                                              "zAa0/+LDk61cTUBiudYxmyMmCHyWo3m9YeAxto/cgSvzn34Fn4RUAPRryuOE" +
                                                              "MyriZkDcb3fx80d4u8o3tpo1HaYb/94Qc9VECempNz6o3v7BhVt8t96iyu3u" +
                                                              "Xqx3CoSxZlEO1M/1c003NodB7q6JbQ/WKRO3QeMgaJSARc0+Awgv5wGHJV1a" +
                                                              "9vbPf9G483IJCm5ClYqGU5swjzNUAQAn5jBwZU5fd79w7mg5NHX8qKjg8Mye" +
                                                              "C4p7amNGp9y24z+Z+6O13zv1DseVQFFLnhLbCiiRF+RONL9/9VvXfzb5nTKR" +
                                                              "zpdMTWG+eU3/6FOSB9/9uMDInLyKlBq++YORs99u7rrvBp/vsAibfUeuMMkA" +
                                                              "zzpzP3cm82GwPfTLICobRHWSVfxux0qWxeYgFHymXRFDgewZ9xZvolLpzLPk" +
                                                              "PD+DuZb185eT3KDPpFm/2kdZLcyL91hlg10+eCgrgHhnM5+ymLdLWLOcu7CE" +
                                                              "dVdQFDJ5iU1hC7KKFR9XNE+zAFBMmqNPBswCmNx4YBeteDZp0n48ysvHhPRE" +
                                                              "+2MH7iy7tVrAoa2otKvSXDW5urbtzPdVId5RXLm3xnx378VntT/cCNr1Y7Ep" +
                                                              "QnKr2Xvppe6/JDhhl7M8PWCb2ZWB1xtDrmxR580W9fBcsyxzTVRru/6vpRMo" +
                                                              "gQuVnIE7QGRAzpAUu9ARNV+ofYqrMQJrKQh3x7XnX/rumkPLv/SsMPzCKSLd" +
                                                              "kf/pF69dPjl+7qzIHcz8FC2b6lJaeBNm1cSiaSoiB0Qfbr534r3r2x8KWmxf" +
                                                              "w5oBgfEmiqod/gNyZS8fzPNkIE90jX4gCd2hlSf/vu+rb/ZBsdKDyrOqvCdL" +
                                                              "elLe6C0zs0kXspzblxPRFqz+A38BeP7NHgYn9kLAqqHLuom05a8iup5j41DJ" +
                                                              "LoWuqE1Yu4Y13eJ89xZLA7niZADlQkjPJhVZcuKf/4X8dxJ3reDOB5ZF2wsq" +
                                                              "cZFd4vH8hwQGpvlT3TD57fj0waOnUn3PrRRwavDe2jaq2cwPfvevX4dPXHut" +
                                                              "yFWggmr6CoWMEMWXrhYW4LeXX8Ad7l9zZbLk6uGmqsLinWlqnaI0Xzo1EP0L" +
                                                              "vHLwb80D9w3v/B+q8gU+Q/lVPt979rXNi6XDQf4NQaSagm8P3kmdXohWGoRm" +
                                                              "DdULyvY8Cppszy+zULCseGVcFFZB1uXX3K2+vFI/jUZftRbwIqyOxyzLsWHx" +
                                                              "gYRv4JFpSrz9rBmhqGaIUNdl0FZ453SXxxGW2cM8vzsBNjpNgBXWWezFuhyE" +
                                                              "ceFFlNVgTQWfxMRnHOmFU7Xlc0898Ht+Gcp/aqmCfJXOKoq7RHD1Q7pB0jI/" +
                                                              "dpUoGAQ9fI2ilmnOCeEvOnz7h8ScJyiaXWwORSXQuiW/AW7xS0JBwX/dcocp" +
                                                              "qnTkYFHRcYscA+0gwrrH9SI+F3VVLuCKbovUuGvmfJJr8lPcNysWufwDph1l" +
                                                              "2ZiVqc6d2rJt763Vz4mbnaTg8XGmZSZQu7hk5iN14ZTabF2h7iW3a16sWGQn" +
                                                              "o3qxYSd+WlygXQeQ1xk+mn13HrMjf/V56/TaC68fCl0BGtyBApiiWTsKK9Cc" +
                                                              "ngUa2REtlsSAx/h1rLPy+s5LH78daOCFvkWYrdPNSEhHLlyNpXX9mSCq6EGl" +
                                                              "wNokx8vjL4yp/UQaMTw5MZTUsmr+W2cNAzNmscstYxm0Ov+WfRmAVFLwFbPI" +
                                                              "1xK4A40SYwPTbuVYD7dBmLlHuWUTrME5kVtLEtFeXbdybfA6t7yu85h9njU7" +
                                                              "/wsndMbBpRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae6wrR3nfe5J7k3tJcm8ChDSQJxdoYjjr964Jj6zXu37t" +
       "2utd22ubwmW9L6/3/V4vTXlINKhIEJWQgkTyF6gUBYKqoraqqFJVLSBQJSrU" +
       "l1RAbaVCKRL5A1qVtnR2fc7xOec+KKrUI3k8nvlm5vvm+77ffPPNef6H0Fnf" +
       "gwqObWxUww725STYXxu1/WDjyP5+j6oxgufLEm4Ivj8GbVfEh7948Sc/fWp1" +
       "aQ86t4BeLliWHQiBZls+K/u2EckSBV3ctRKGbPoBdIlaC5EAh4FmwJTmB49R" +
       "0MuODQ2gy9QhCzBgAQYswDkLMLajAoNul63QxLMRghX4LvRr0BkKOueIGXsB" +
       "9NDJSRzBE8yDaZhcAjDDrdnvKRAqH5x40INHsm9lvkrgjxfgp3/rXZd+9ybo" +
       "4gK6qFlcxo4ImAjAIgvoNlM2l7LnY5IkSwvoTkuWJU72NMHQ0pzvBXSXr6mW" +
       "EISefLRJWWPoyF6+5m7nbhMz2bxQDGzvSDxFkw3p8NdZxRBUIOvdO1m3EpJZ" +
       "OxDwggYY8xRBlA+H3KxrlhRAD5wecSTj5T4gAENvMeVgZR8tdbMlgAborq3u" +
       "DMFSYS7wNEsFpGftEKwSQPded9Jsrx1B1AVVvhJA95ymY7ZdgOp8vhHZkAB6" +
       "5WmyfCagpXtPaemYfn44eMtH3mN1rL2cZ0kWjYz/W8Gg+08NYmVF9mRLlLcD" +
       "b3uUeka4+8sf2oMgQPzKU8Rbmt//1Zcef+P9L351S/Pqa9AMl2tZDK6In17e" +
       "8c3X4I80bsrYuNWxfS1T/gnJc/NnDnoeSxzgeXcfzZh17h92vsj++fx9n5N/" +
       "sAdd6ELnRNsITWBHd4q26WiG7LVlS/aEQJa60HnZkvC8vwvdAuqUZsnb1qGi" +
       "+HLQhW428qZzdv4bbJECpsi26BZQ1yzFPqw7QrDK64kDQdAt4AMh4PN6aPuX" +
       "fweQDa9sU4YFUbA0y4YZz87kzxRqSQIcyD6oS6DXseElsH/9TaV9BPbt0AMG" +
       "CdueCgvAKlbythMWfR+WLRVwCHMbP5CBcxu2x4WOY3sAiYDhOf//SybZLlyK" +
       "z5wBCnrNaXgwgGd1bEOSvSvi02GTeOkLV76+d+QuB/sXQPtg3f3tuvv5uvtg" +
       "3f3tuvtXrwudOZMv94ps/a0tAE3qABMAWt72CPfO3rs/9PBNwAid+GaghowU" +
       "vj5o4zsU6eZYKQJThl78RPz+6XuLe9DeSfTNeAZNF7LhTIaZR9h4+bTXXWve" +
       "i09+7ycvPPOEvfO/E3B+AAtXj8zc+uHTu+vZoiwBoNxN/+iDwpeufPmJy3vQ" +
       "zQArAD4GAthCsGP3n17jhHs/dgiVmSxngcCK7ZmCkXUd4tuFYOXZ8a4lV/sd" +
       "ef1OsMd3ZPb+IPhEBw6Qf2e9L3ey8hVbM8mUdkqKHIrfyjnP/s1ffL+Sb/ch" +
       "al88dg5ycvDYMaTIJruYY8KdOxsYe7IM6P7+E8zHPv7DJ9+RGwCgeO21Fryc" +
       "lThACKBCsM0f/Kr7t9/59qe/tbczmgA673h2AHxHlpIjObMu6PYbyAkWfP2O" +
       "JWC1BpghM5zLE8u0JU3RhKUhZ4b6nxdfV/rSv37k0tYUDNByaElv/PkT7Np/" +
       "qQm97+vv+rf782nOiNlht9u2HdkWQV++mxnzPGGT8ZG8/y/v++RXhGcBFgP8" +
       "87VUziENyrcByvUG5/I/mpf7p/pKWfGAf9z+T7rYsaDkivjUt350+/RHf/xS" +
       "zu3JqOa4umnBeWxrYVnxYAKmf9VpZ+8I/grQVV8c/Mol48WfghkXYEYRwJg/" +
       "9ADiJCeM44D67C1/9yd/eve7v3kTtEdCFwxbkEgh9zPoPDBw2V8BsEqctz++" +
       "VW58Kygu5aJCVwm/NYp78l83AwYfuT7EkFlQsvPSe/5jaCw/8A//ftUm5OBy" +
       "jbP41PgF/Pyn7sXf9oN8/M7Ls9H3J1ejMAjgdmPLnzN/vPfwuT/bg25ZQJfE" +
       "g+hwKhhh5jsLEBH5hyEjiCBP9J+MbrZH+WNHKPaa0whzbNnT+LJDf1DPqLP6" +
       "hVOQ8upslxsH5+rh+XoCUs5AeeXt+ZCH8vJyVrwh18lNWfWXA+icn8egAWBB" +
       "swTjwJd/Bv7OgM9/Z59s4qxhe2jfhR9EDg8ehQ4OOKTOK7mlaMC+POih6yib" +
       "FeI82roi/uHou998Nn3h+a17LwUQTkCF6wXuV98dMsB/3Q0OrV1I9+P2m1/8" +
       "/j9O37l34JAvO7mD999oB3PSVwbQ7TtHAU6SNdJbvM7KclY8vqWtXdc13pwV" +
       "RHIGAOfZ8j6yX8x+j66jGqAVJ1wampi14VnRynknAuDnhnj5UANTcFcAjnF5" +
       "bSCHrF7KWc1McH8bYJ9ilPhfMwrUeMduMsoGsfqH/+mpb3z0td8BOutBZ6PM" +
       "6IEajq04CLPry68///H7Xvb0dz+cnxbgqGCeIS49ns36jhtY4uRqUe/NROXy" +
       "0IsS/IDO0V2WcmlviCeMp5ngHIwOYnP4ibu+o3/qe5/fxt2nweMUsfyhp3/j" +
       "Z/sfeXrv2G3ntVddOI6P2d54cqZvP9jh4w5wjVXyEeQ/v/DEH332iSe3XN11" +
       "MnYnwNX083/1X9/Y/8R3v3aNgPBmw/4/KDa4/bOdqt/FDv+o0lzh40mS8Mqw" +
       "wKRNuNpet8MWPa+uqmEYGhg3MbsChjdWcWLIilpyx7Xeemki9KxhCbPK2EKW" +
       "PWrTFfjVdMG2lR6vr8YNrrgWuitXdYWV75TI2bS3IgfEmHX1Bm4OmJR11JED" +
       "94gqpZTqNDJAChXSYmu8yw/cGirWl4OUiWAJiSLJTAeltiMIzTI4ppxOf7Ee" +
       "rjstWhKYuUjrLlclzcIci4hSdwbDqT4rj6N6sUoQ3Go0HaVruiTji0DXi5uJ" +
       "0TK7NT90uSXhEjN62eX0crc8H+mJujZpVxjaa3PTXjCsIemcIDR4245VuTLX" +
       "+r36uK+veshw0iDVfp+0R7Vl2EMHJaIU+eTQHdpcQBVpXsL9MoCpckhveEFs" +
       "TDb9uttHUEwbLvqmz/b7G24cpE3DNQXUm+t9iqVpi0VxxFj6/oiv9ypkTVvB" +
       "4kxYl6vwYJp20jFGuXWnXWA7A8XsuRt11WOn7QCtCOvRmjI70Wg6bfZIulTB" +
       "yc6UQCaTtd9WCdKbMfXiuom4Yc/0S0VBiaulwXxS1Phyd27zsjOzyzS24Ipl" +
       "Gkn0okEyHtKJNxY1D5SSt6wsq+uO4fNDxRusCkGB7/bcZqkdePRyIWnjebM7" +
       "JZtgoV6P1leeXjC4vjOacpHqM+ukhyddu7GsmNW4xhHT4ibB4tackmvWVBM7" +
       "M6kdk5bNpe2p2RP0ZUFu68N+GMJFj8NXBdxfi7VFMtIrviLFMWEvBqag03yL" +
       "Mde9dVDfmMNuHaXhnoUM1D62xksUAW67vYUi2EK/Opq6RLPJ+i17oo2Yagkn" +
       "RpQ0wVR12Smv2L4plErUsNIebdjmZDFQKE1oj/ou3q72BjavDWfVxMM0tFRA" +
       "Uh314cGSD5VKPyi7RWKitsqW1udiWCwQnFAucEpRH49iXOQwc6qVBx1fHlAJ" +
       "2u+qY1yspPgoXHbWjU1dqVhe0g9wx+W7Y7KxIWvAgNau5FE66pWjHsNN/XaB" +
       "ry98jy4s6mN0o1E8N5SGbHnurNuRPiq3EbHdg41GQ1bQhagNu30rGHGD/mSJ" +
       "LeIp3nDa0xKvUe2FS48xo8/WJ9iUnZRKaITJ09EYdd0ihyKT0BpPekgR25BR" +
       "7DhwB40nrDOhm4PpyGjwxZonlVJCqkVlcb3CXDWWA5UXE8KCUWPTDWg3MTiM" +
       "pfjedEqx3XTQWRRqRms4FDlCUZ22xJW5JpNGM4/YRPhCEwy9hTUtdt0nuk1j" +
       "RBMpMdcncToKRqtym9AZc8FhfjsQiDnqFkIBk+JWPKBhmJumKeamrEo3xQGG" +
       "MmnRJkhLMp2uxurduhmUY1SaU9rcx2UtESkmYMnuohSXKYkm0UprGLaTpbeK" +
       "rSnbpfGZiVZ4sqRi40K1PVabnGfYnFJeU6nOBL1RE1dmo3bYbfcordadGMWh" +
       "LGm0VWsNZ2FdiRi2XlvoKq724R5O9oYLU4trtMP2gfxdU1f7rrlZ6eVlUTDT" +
       "VY9sVAlzbMdymUIivxIry6hn4XrYDBrrYrvP+HCzK8EuFjmeUkaXjYI0RKp2" +
       "zR7DTs2fa0pTdUx6KnmNNJoojEYES5GxiA0Kl1ckQVdxV+1VnaZawOOS1xAq" +
       "67kjAe+wBB4oLObXAHbaZGvglfiiSbbalZksDsZTFK75YocY4IhYlgnBLwyH" +
       "8JJi2UWhJKrTfrstoY6ML6sKGcMFeRFVjIhM+aK1njqzwEbH5VDX+q7gq9MB" +
       "F42YJjanRzoTrTVJY+epqFTQTtJMAHaRYawiU2lEttTRupXO63AoywGD1JJC" +
       "t7BSDbfbr0iYvcJrvZpCWQtiaMuOk9KuivDVvjqZYC2siHSwjY1Nigg17Osj" +
       "UlNgjywX0ShFxo15r4+v40Rfcqje4KtUCqeYUIQLVEuvl8TxpKmF0jwxN7SJ" +
       "dza8XTEbcxlLAhsWVS5KrUqVtKrsBGNYbxMOCXrjaQu9JS4rSoIWpWqI2pXA" +
       "sUsdYb6EG9WR2JgSuGw6g7RuVyKkuZoGaNCoa5uwEs7cpILbXLIwiGGJhkti" +
       "sVgZ2BLA23pvOYL5PjusjGRaFXrAY8RiAYvVqBa3O71pSWhES0ZptKtopdvD" +
       "TRCuzt32pObH63QwwUaYVVs348WkpkhII0ZMtTbozFC3v1ZReiPjVQcRzEHb" +
       "aWzK1bSwKNSHpUoalVo+8HOSpKwVtcQ1jSUL7HBANeDGNJop6bJmjfts6kj0" +
       "mG8X5EkFrpNDrgm6Q7rVtahN32i6hcJ8yPqNRoh4XtR04MjHtKUykUOa1rE0" +
       "dVKmIppouR0zypjq4vaS7fDcVEnCpOjyiTxXyc7GnLFA+XK8aCSLyDYoJ6UY" +
       "nWkVWuFiWUJr8rjSbzEOacJlXVpQ4oZqlFaGWioWZFz11M7KomuFjUlJFE8N" +
       "xRDBCSk3p15Nm5RWOAKOXrYxGxCFFCObtOkOmKYfg4Aiqc6bciC3Fk7RqqIb" +
       "P+qsGJYolOkOom2QYOphtlC2g37EzVp8LfSWQcpI065UY2eUWUmspIKgUysY" +
       "wyIOnGeOEM7I6nvlWeQ4ch3utVYrA6FRhseX5QXfLCVByzMTtoYW+YbSFP1N" +
       "ko6nrBfC9chhaVsdhVOrSyCjNoulDjYJGxg7mBZsZe569Kjn9UerSoLMrBns" +
       "habOUBHM+TST4n2OknQFdsh6Q2LWRgFx025HTFESLy/rRk+QmwOzJHKawNla" +
       "szhSll6tUvUqXhmcObyZKHHNbqoKYWquLcHqYLPgUCVlBnqXaBTXs6qKS+WV" +
       "wSlwFBa8Jbxo+lK/tfGGboRLlGxQch0vpn5Rn/lOujQShiXdtIBV0KbMIIOO" +
       "OrcaOoW5bocKbbNYE1AtdGrraqnVo2w+dInSPKzOSxW5hwLdUxhiaQusZYz0" +
       "NdMDkaEY9hW4OkMlgBOe3Bo2awuyHPuuuCClatRBV/Go7UTGuDJu1RBlXYyF" +
       "oTWxKozHsrEQteTyWnDLIjC9SI5mVYmZdcJgQ/Kqanp13OZpguZn3moOMEGe" +
       "zVBMQoxGulhSej1sm65PaRZvuJbQLc5Su0QwRSrqUPESLbYacSWCmwUXVSeF" +
       "EWxMmaCBNLzZQKvPWiOlOhgJnKCaKFPRTWlmr/i2zZotaUJtojmKO46fbgrp" +
       "hMJ9uT0VSXLRLIWzWaVfLkRkF15PFkrALuOuuxkmm5Ty+U6iztmo2iMdzksb" +
       "XtNcuW2hOxlIRpFcVGsVbpYkbb4s0gDu/OZg7QzU5ozn5ZQMVxtClEnSGEzV" +
       "8YhXEpq1OkOTnCAzQyyiDbQTFNqiAwuuiSu92bBvuwjbaZVGiNMsrruw5Ezs" +
       "NjZqKN2yZpjWEJeJaGilyArlxN5GE2Z8PGS52SjUeBjjkYQr9prxDJZEW3Rc" +
       "a6zPyQ4rzn0RKxTV2PM6Da5bICsgDgjx/tKOJmE7MpVez0MNRhxsfBA1xS1n" +
       "VTLKC23qinWp7PUCpF6ZplVzaQljFZ21wem/GIXISq9pg1J1MRaWZHmFaHxF" +
       "KNV9vj2y7IqbzDmpwIPL0Wwkj0qJXjCtUqXj0WsFntbq8FjA66iCG8VmO9g0" +
       "MUfT+LHf7zdw0VInQpklAsPnsARelTyK2RT8GtVBUEkY4mSk83NPYgYcsepQ" +
       "xmbgzGYNk8PdOtE24oGtJ2i0pqobB56MBHoMTvzFeOKbXgEoZ4ClA9MX/QCc" +
       "NMVhVOAV1sSmJBWTS6ZbSvpVrFrk5jEzXobTeQuRmiZldEJ+MvZooqZPA4oI" +
       "SHm2lDZLBasHyCZEa6uGtZ4gcOxbEr1sOqwKLmZvfWt2ZTN+sVvznXmC4Og5" +
       "DlyWsw7+F7gtJtde8Ey+4C7Xm/+dO/2oczzXu0sAnjlMTzx81VPGNo/LcUcv" +
       "sdn1+b7rPdHlV+dPf+Dp56ThZ0qHKR01gM4HtvMmQ45k48SqHvTo9dMEdP5C" +
       "ucv9feUD/3Lv+G2rd/8CjxoPnOLz9JS/Qz//tfbrxd/cg246ygRe9XZ6ctBj" +
       "J/N/Fzw5CD1rfCILeN+REu453PjCgRIK135YuKZG93YmtLWeU3nsMzu98znB" +
       "B2+Q6H4yK94XQHeocnDsTepQ8W+40RtWnkraz7OoOxN9/89LaJzINgfQXVe/" +
       "hGU5/XuuepPfviOLX3ju4q2vem7y1/lj0NFb73kKulUJDeN4CvZY/ZzjyYqW" +
       "C3x+m5B18q+nAujVN5AwgM5tKznjH92O+VgAveJaYwLoJlAep3wmgC6dpgyg" +
       "s/n3cbpPBtCFHR1YdFs5TvIpMDsgyarPOtdIGm7z1smZY250AAi5Uu76eUo5" +
       "GnL8ZSlzvfw/KA7dJGQO0sAvPNcbvOel+me2L1uiIaRpNsutFHTL9pHtyNUe" +
       "uu5sh3Od6zzy0zu+eP51h7Bwx5bhnQMc4+2Ba78hEaYT5K8+6R+86vfe8tvP" +
       "fTvPYf4PtfrIANoiAAA=");
}
