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
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO+PzB/4GjGOwMY4B8ZG70IYSakJjHAOmZ3Ax" +
                                                              "sdTj45jbm/Mt3ttddmfts9OkCVIVqraUUiCkKvxFSkpJiKpGbdomchU1H0pa" +
                                                              "iYQ2TaNQ1PSPpClKaJS0Kv16M7N7+3Fn06hqT7q5udk3b+a9+b3fe7Pnr6Jy" +
                                                              "00DtRKVROqETM9qn0kFsmCTdq2DT3AljSemhMvzB3re3rQujSALVZbE5IGGT" +
                                                              "bJKJkjYTqE1WTYpViZjbCEmzGYMGMYkxhqmsqQk0Tzb7c7oiSzId0NKECQxj" +
                                                              "I44aMaWGnLIo6bcVUNQWh53E+E5iPcHH3XFUI2n6hCve4hHv9Txhkjl3LZOi" +
                                                              "hvh+PIZjFpWVWFw2aXfeQCt1TZkYUTQaJXka3a+ssV2wNb6myAWdT9R/dP1I" +
                                                              "toG7YA5WVY1y88wdxNSUMZKOo3p3tE8hOfMAug+VxdFsjzBFXXFn0RgsGoNF" +
                                                              "HWtdKdh9LVGtXK/GzaGOpogusQ1RtNivRMcGztlqBvmeQUMltW3nk8HajoK1" +
                                                              "wsoiE4+vjB17aG/D98tQfQLVy+oQ244Em6CwSAIcSnIpYpg96TRJJ1CjCoc9" +
                                                              "RAwZK/KkfdJNpjyiYmrB8TtuYYOWTgy+pusrOEewzbAkqhkF8zIcUPa/8oyC" +
                                                              "R8DWZtdWYeEmNg4GVsuwMSODAXf2lFmjspqmaFFwRsHGrs+CAEytyBGa1QpL" +
                                                              "zVIxDKAmAREFqyOxIYCeOgKi5RoA0KCodVqlzNc6lkbxCEkyRAbkBsUjkKri" +
                                                              "jmBTKJoXFOOa4JRaA6fkOZ+r29YfvkfdooZRCPacJpLC9j8bJrUHJu0gGWIQ" +
                                                              "iAMxsWZF/ARufvpQGCEQnhcQFjI//MK1O1e1T70gZBaUkNme2k8kmpTOpOou" +
                                                              "Luxdvq6MbaNS10yZHb7Pch5lg/aT7rwODNNc0MgeRp2HUzue+/z958i7YVTd" +
                                                              "jyKSplg5wFGjpOV0WSHGZqISA1OS7kdVRE338uf9qAL6cVklYnR7JmMS2o9m" +
                                                              "KXwoovH/4KIMqGAuqoa+rGY0p69jmuX9vI4QqoAvWgvfpUh8+C9FOJbVciSG" +
                                                              "JazKqhYbNDRmvxkDxkmBb7OxFKB+NGZqlgEQjGnGSAwDDrLEfiCZTHYE9hQb" +
                                                              "mjApgXBWNGPI0nXNALYBqOn/j0XyzNI546EQHMLCIAUoED1bNCVNjKR0zNrY" +
                                                              "d+3x5EsCXiwkbB9RFIV1o2LdKF83CutGxbrR4nVRKMSXm8vWF+cNpzUKcQ/E" +
                                                              "W7N8aM/WfYc6ywBo+vgscDUT7fQloF6XHBxGT0oXmmonF19e/WwYzYqjJixR" +
                                                              "Cyssn/QYI8BU0qgdzDUpSE1uhujwZAiW2gxNImkgqOkyha2lUhsjBhunaK5H" +
                                                              "g5O/WKTGps8eJfePpk6OPzD8xVvDKOxPCmzJcuAzNn2QUXmBsruCZFBKb/2D" +
                                                              "b3904cS9mksLvizjJMeimcyGziAggu5JSis68JPJp+/t4m6vAtqmGE4dDrk9" +
                                                              "uIaPdbodBme2VILBGc3IYYU9cnxcTbOGNu6OcKQ28v5cgEUdC8MO+I7Zccl/" +
                                                              "2dNmnbXzBbIZzgJW8Axxx5B+6je/fOeT3N1OMqn3VAFDhHZ7CIwpa+JU1ejC" +
                                                              "dqdBCMi9eXLwm8evPriLYxYkbi61YBdre4G44AjBzV964cDrv7t85lLYxTlF" +
                                                              "VbqhUQhwks4X7GSPUO0MdsKCS90tQaApoIEBp+tuFSAqZ2ScUgiLrb/XL1n9" +
                                                              "5J8ONwgoKDDiIGnVjRW44zdtRPe/tPcv7VxNSGI52HWbKyaIfY6ruccw8ATb" +
                                                              "R/6BV9oefh6fghQBtGzKk4QzLeJuQPzc1nD7b+XtbYFna1mzxPTi3x9inlop" +
                                                              "KR259H7t8PvPXOO79Rdb3uMewHq3QBhrluZB/fwgP23BZhbkbpvatrtBmboO" +
                                                              "GhOgUQLmNbcbQJJ5Hzhs6fKK3/7s2eZ9F8tQeBOqVjSc3oR5nKEqADgxs8Cv" +
                                                              "ef0zd4rDHa+EpoGbioqMLxpgDl5U+uj6cjrlzp780fwfrD97+jIHmi50LCgQ" +
                                                              "60IfsfKS3Y3tc6+u/dXZb5wYF0l/+fSEFpjX8rftSurg7/9a5HJOZSUKksD8" +
                                                              "ROz8t1t7N7zL57ucwmZ35YvTFPCyO/cT53IfhjsjPw+jigRqkOwSeRgrFovU" +
                                                              "BJSFplM3Qxnte+4v8UQ9013gzIVBPvMsG2QzNz1Cn0mzfm2AwBawI1xnFxdO" +
                                                              "keEjsBDinX4+ZRlvV7DmFn58ZawbpShi8kKcwhZkFSsB5midYQEgnAzHogwI" +
                                                              "NlCbiwWWyIaslEl34HFeYial3csamrvWfdApwNBeQtZTix7+yY8TiWUNkhDu" +
                                                              "LKXYX4M+erZSeiP33B/EhJtKTBBy8x6NfW34tf0vc9quZLl8p+NeT6aGnO/J" +
                                                              "GQ3+nNEI3yu2R66IWm73f1lmwTS4YMk5uBPEdso5kmYXPGaDXcb9T/VzqvKF" +
                                                              "sXto3xtVet67/Tt3CLcuniaCXfmnPnfl4qnJC+dFhmDupWjldFfS4nswqxmW" +
                                                              "zFD3uAD5cPOnp955a3hP2Ob0OtYMC+y2UFTrkhpQKBvcWyC/UIG85vphIjTf" +
                                                              "9eX6nx5pKtsEBUk/qrRU+YBF+tP+mKwwrZQHN+7Ny41TGzT/gk8Ivv9kXwYW" +
                                                              "NiBA09Rr30I6CtcQ4Ff2HCrcFdAV9Qdrb2fNVmFddymqz5cOcSgJIrqVUmTJ" +
                                                              "jWr+iQTvI956wMvwtj87iyp0kTCGhgovERiM2qa7XfKb8ZmDx06ntz+yWoCp" +
                                                              "yX9j61Ot3GO//sfL0ZNXXixxRaiimn6LQsaIEkhAbT7kDvCLt8vmb9Ydfeup" +
                                                              "rpGNH6eoZ2PtNyjb2f9FYMSK6cEa3MrzB//YunNDdt/HqM8XBdwZVPndgfMv" +
                                                              "bl4qHQ3ztwwizRS9nfBP6vYDudog1DJUP3RvLmClxcHHShsrK0vXyCXBF2bd" +
                                                              "/awZCOSUxhk0Buq2kB+HDTyuWX6NilcofAP3zVDsHWRNnqK6EUI9V0lH4bKZ" +
                                                              "rp5jLKtHeW53w3BihjD8DyouNtCjw4aaii+2rBxrKXqNJl79SI+frq+cf/ru" +
                                                              "1ziUC69nagCUGUtRvAWDpx/RDZKRuSNqRPkgaOWrFC2YwXKgDdHh+/+KmPN1" +
                                                              "uKuWmkNRGbReyaNwUEFJKC/4r1fuOEXVrhwsKjpekZOgHURY92G9BApElZUP" +
                                                              "eVjB9jo/rHk3OqzCFO+ti8Uyf+npxJ01aOe3C6e3brvn2qceEbc+ScGTk0zL" +
                                                              "bEgJ4gJaiN3F02pzdEW2LL9e90TVEieFNYoNuxG1wAPjHggCneGjNXAfMrsK" +
                                                              "16LXz6x/5heHIq8Afe5CIUzRnF3F9Whet4A0d8WLUx/wHL+odS//1sSGVZn3" +
                                                              "3uAVf3GdH5RPSpfO7nn1aMsZuNDN7kflwPQkzwvluybUHUQaMxKoVjb78rBF" +
                                                              "0CJjxZdX6xiUMYtl7hfbnbWFUfbOABJQ0XvPEm9a4HY0ToyNmqWm7cw82x3x" +
                                                              "vY116A/iLjDBHfFUgJg1Ul7k7bJkfEDXnTwe+bPOYzoVpCw+yGef513WPPZv" +
                                                              "R5d8PxAZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
