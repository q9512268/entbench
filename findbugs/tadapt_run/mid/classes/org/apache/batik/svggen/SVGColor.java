package org.apache.batik.svggen;
public class SVGColor extends org.apache.batik.svggen.AbstractSVGConverter {
    public static final java.awt.Color aqua = java.awt.Color.cyan;
    public static final java.awt.Color black = java.awt.Color.black;
    public static final java.awt.Color blue = java.awt.Color.blue;
    public static final java.awt.Color fuchsia = java.awt.Color.magenta;
    public static final java.awt.Color gray = java.awt.Color.gray;
    public static final java.awt.Color green = new java.awt.Color(0, 128,
                                                                  0);
    public static final java.awt.Color lime = java.awt.Color.green;
    public static final java.awt.Color maroon = new java.awt.Color(128, 0,
                                                                   0);
    public static final java.awt.Color navy = new java.awt.Color(0, 0, 128);
    public static final java.awt.Color olive = new java.awt.Color(128, 128,
                                                                  0);
    public static final java.awt.Color purple = new java.awt.Color(128, 0,
                                                                   128);
    public static final java.awt.Color red = java.awt.Color.red;
    public static final java.awt.Color silver = new java.awt.Color(192, 192,
                                                                   192);
    public static final java.awt.Color teal = new java.awt.Color(0, 128, 128);
    public static final java.awt.Color white = java.awt.Color.white;
    public static final java.awt.Color yellow = java.awt.Color.yellow;
    private static java.util.Map colorMap = new java.util.HashMap();
    static { colorMap.put(black, "black");
             colorMap.put(silver, "silver");
             colorMap.put(gray, "gray");
             colorMap.put(white, "white");
             colorMap.put(maroon, "maroon");
             colorMap.put(red, "red");
             colorMap.put(purple, "purple");
             colorMap.put(fuchsia, "fuchsia");
             colorMap.put(green, "green");
             colorMap.put(lime, "lime");
             colorMap.put(olive, "olive");
             colorMap.put(yellow, "yellow");
             colorMap.put(navy, "navy");
             colorMap.put(blue, "blue");
             colorMap.put(teal, "teal");
             colorMap.put(aqua, "aqua"); }
    public SVGColor(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Paint paint =
          gc.
          getPaint(
            );
        return toSVG(
                 (java.awt.Color)
                   paint,
                 generatorContext);
    }
    public static org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Color color,
                                                                   org.apache.batik.svggen.SVGGeneratorContext gc) {
        java.lang.String cssColor =
          (java.lang.String)
            colorMap.
            get(
              color);
        if (cssColor ==
              null) {
            java.lang.StringBuffer cssColorBuffer =
              new java.lang.StringBuffer(
              RGB_PREFIX);
            cssColorBuffer.
              append(
                color.
                  getRed(
                    ));
            cssColorBuffer.
              append(
                COMMA);
            cssColorBuffer.
              append(
                color.
                  getGreen(
                    ));
            cssColorBuffer.
              append(
                COMMA);
            cssColorBuffer.
              append(
                color.
                  getBlue(
                    ));
            cssColorBuffer.
              append(
                RGB_SUFFIX);
            cssColor =
              cssColorBuffer.
                toString(
                  );
        }
        float alpha =
          color.
          getAlpha(
            ) /
          255.0F;
        java.lang.String alphaString =
          gc.
          doubleString(
            alpha);
        return new org.apache.batik.svggen.SVGPaintDescriptor(
          cssColor,
          alphaString);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Gn/86b+MSd/FuCUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "i4qNvoay7VXWGuNbClfzHB/E9cnGy1M7hRt0DZUZLOnIlDJA894og6erzlLO" +
       "BxDfXDhhtwaveEacEJmA9ihwoGqwSJDra07WFZedj7yMXXdiqJlRaLtmRjVt" +
       "5M36AR4JDrElkLEl1VZjOOp3V3idlbipQ/VHXTmwFZg3Oli4VGB/vN2FTVGh" +
       "3fVussbCgTaYBUvP8MfkOsYxsT4baGLAyjNUDaatBJ7aOi7STB9OhwHJSENj" +
       "yPT8xjrZwqOZH4axnAwsrjbppGPMbq+wKWx6fl0R/SGbQQg01ndM6IfzGUPT" +
       "ti+Fgg0UbudyzoZ9VxcKlABvb9b1eZNnpkanZrEcB+u70Qwz5y1utOkN+pie" +
       "S5HgkxKtO1tt0yDULUR4kUL36s1e3cI9u9YVshE5wyXSdkKBJFsuzq0pDEzA" +
       "z93B0kOaJsx3QzhPhlHi7qr1LtKV7PnEwUe79UIIBFGZIh0FD7atYcCwXlKr" +
       "VrVtrglGb4RlPLltK6tsA7EtsNlBRJSQIhy3epjpLYECA8JssBCS56S7iN2+" +
       "j+g66S75xoDkW8uc7EZWh8DpbLjmh2J7gaYTRWcSY9Jc+Uga1+uwS6Gm5cm7" +
       "WLIVwm4qqbrYYFk4j/kJLyLoJGTpsYtjGN916swW9y1PEVsSPyVW9ZYL2eMZ" +
       "gfXUOlmjRWQ47klWfUKgId7YUXE08GZ5i3Y832GZbqp7irSw51DsycmqMY+k" +
       "kRbS3dacRNodo7asVqtspoxbc9iTG2Y8xybDBtFJdv0OSdFzfG7LC36iLqcY" +
       "oVFVSILslKxCerLeLIf1rtru6Vusk1R7/XRrjfvuvI2oKEoai1WzyiV2fc4h" +
       "iJIvWb7tqENbaKwRP+DGYy2F6K5YH2IpOghZTw6XI3E3C6XMkompwexaAWvM" +
       "WERtzheyyZHJik8aRk53k0mzgwKOAnlnKN1RyllM6oU5u8jJCCweTdZYSl20" +
       "SndUUzc2EKZM0d4KZ2qWH0Q7TJB7Eg1E0M5nExyeT3mcQ0Z2QhjKiBPy2niF" +
       "78ZxKIa9aXfVsqt5g+KX/BKeUoPJwNoxy4TUKGTblCEBrVVVfJuOc1EeoP0B" +
       "gdbz0YgaKWtz2IiY3EoCdynDA1lrGKEzShc03+lm/b41xgcRo3AKng12PKN5" +
       "MxoODCiebdrVVnVeG/aImqv5yRDnbV9do0KPz7G8r+O1oI5WrfmMw3ORYzDX" +
       "DzCuE8WDHoQutDVDtOdkpz9pNNGaEm2GXiIS45Gjcxu8Qyynq+ZUJ3oR25YR" +
       "ZANNxgmKdKo63wzDuraZ0q225xG5sfEYW6x2sthwbEvi+6mBtzQPGqxqbcrw" +
       "0DrUSKzVxrJqqiESqdat9rbsjl0scLvThFsbPczo8Vonaw3B4JZ6MPPn3mJN" +
       "517DVXMQXJsj3oBwKV+FW5RV+rC50NcD1axbm21zUpvAa5tBRVcn+upEhHBB" +
       "78GNpoHaSgsEUxGXcJyd2xE5tRtwZnXF5YJrZxnPeQrXnq4H81BnRxSccT12" +
       "7K6rCDVT1ZhYzrKauTbwyM0G8952k83HVLawNJ9oNgY7RsFmVY9SzBxjPDaU" +
       "uha9nA5ECyU5Kev2mnjLSfPBsK4hOJmx+JZIp5KaBLsY205Fh9yu7D4ZC93G" +
       "pIY1+wmDEbE51yVqLkkY1p0zPmbmQTYbIYzQCIRg2JLWxHLDKbNN2I973JhP" +
       "wIKpLa0uH8uLFlYn1r05Bk1UZ0N3TAxrKGS3O8SJSW3Vrc4WdS7HqlOOQzs4" +
       "H7MSjnUZfbESeiTd0fIprSz6DXg58rtVfTxuuISJmYPNuGuBKYRRblmh3I5i" +
       "Iqm1plwAJb142kb94TZRSKs7HLrpiGWqYDuBzEHoXXaSwFax7YjYYRyfdVcG" +
       "Nxh6ar0VpVTMjsXE2okmZ7IDv2HafRAam91aVzR6tO6CZRpVxrNEJmaYNdmM" +
       "LTC/K9Fjc7fotD0UImbpdgc8d+z2q/02h0K7PqvTguAshhHGhoMOgUmrKJcH" +
       "EQdj9DiIbRxXOWnYBidew+xWF7TcVvxaIq1rmIkbVMkfn7VJu54vdp3WZFbD" +
       "U6odKVMnwjKsI65kIKC2yRup5Lvm1LAwHUI71nIg4V02qCdht47xPb2zVDlr" +
       "w0pKvFrVB5S7xrTeDqzzrOzyHRqo151kTWWyRXliI9XknSoxmyCjbZjfTTdJ" +
       "UN11hhNxhCpLpIZSm7FDxdYkamdqDVn52USb2Uje95pOJm1CBm7DVRHaaI0G" +
       "7sHVbTMbjzs7K4ORYMgYLXdkDTCmbQ6aLIE6Xd6tTmxGXJP1cGenLmYsuD6N" +
       "gqWMwpmdhkAhFIiNnmAvyDbZmVDtbatVFaZbwreDJu41DD8SaKaa+T0OafWQ" +
       "JJwZ6aKZ+tXtpjn3A2M4wpYq60DaRoykVkfXWXvtSO0eumB3FGuGITSt9ilW" +
       "FGCFTKmAQCewm7frbbjT5OXOqKGGZtdua7vc2qRUX9OwlUyvZMir7ULLINrt" +
       "KNE5immLk5kBqTqbUI0Wte743VnAgBWxLjEB5huJu2GiSYbFyQ5pZDgHDySI" +
       "U6vkYlVdcVUZzyWw0VoICooaFB0YS9aC+5u43VuI3TpPd7ygZusDSxOQob9L" +
       "0rw64HiAcWDKNLUzxYZnrmuqO+QSadzCV0m1Ux2s7HmziYqreW0w6ogK083n" +
       "S71KNyDDmrfbyNwz2BYhR65L1cF0A3oskRLD9MJNlWuM5rnarCGTRlV1x2IV" +
       "VsV6VW7UNFbhCKkKt00WIsc6S7mbTtNQRQdGc0FAzRi1N+MdNEG4naw2KGmR" +
       "9oFEuV2aiUPKmvd3foKuerCZE3FLkpXBJKmCndiwrcd9HhktnGiU5mkrS9nM" +
       "9rYw69q+T+7mLJknc1gcLURuKwWMMM7G/JRTxBrkRcs+MVrlzU4vGMOkMGjg" +
       "KwmN/AateCOcGq1tpbl16J3Yrwc1aqnjy2ETESInnE3jOTFJhh0UyVjHxRaS" +
       "a87mO2M8YP24Mfe0bWvkrRsN3QyZ4bhBLJypWYu6CuxO5wPECrNwooSRG4+b" +
       "XH0612fVnpmL00G1y07NNTvRYB0PlyI0hjA9TefNaDsnGAZGCG2TiU0B8hB4" +
       "GC29gJF4waH9rjILm0J/NJ9b6NCPPCG0l5yJJeYSyxgWCdkesJfaHOJGrBvl" +
       "Nbcf4UhtDDNrJFz0A1MSZ2OBB2vNtsEtKVHTkKk2lKfJZGULxGBqc+tZuBkw" +
       "Wynle5mBNxQEzSdrD+0KQ9gPx63RBpm2VMFEqB7an4Klld7M4Q6cpGoVHoCD" +
       "hp5imBqsR9W2VOfa+mTZivvp1O2EK6lpJNOtytYECdaSxFbiNGZ75iqWdXY9" +
       "gucm08nrTd6VhlAa+YE+iaYrNA/ZoN3o8Y0133ekiZzW3KzTT+DBTh1pZrOF" +
       "MDjfVqWmOIcMFwEgjL43I+0WivQbqCL7PAjBaQ3u0KPmAnUbA4Gtdd3tCCHU" +
       "dBy26AiFvaULNlIDotkWF3QaVhUUYsb9YLbZQRbaoyOtK1VFuSOm8/VGFybD" +
       "aXuRLxZbLe7RqLrSwLlhxhtwHFlGoxc3q/gyhtrwrs/VxFjFVwtkyeAoV8Xb" +
       "3kyDpuMa4UEdWKnSggYN0t4Mw7CPf7y4hvju1W6CHi0vvU6SCFcOUrz41hVu" +
       "QI7+TCqKZ08u/8rP9cq5xLMzl39nshMqxa3OBy7LDSxvdL72mVdf09ifqx/f" +
       "Mv67pPJQ4gcfc/SN7pwhdQAoPX/57RVdpkaeZhv8+mf+y1PTH7U+dYW8qw+e" +
       "w3me5M/Tr/8m8SPqXz6o3HeSe3BP0ubdg168O+PgZqQnaeRN78o7+MCJZH+o" +
       "kNjT4FGPJKuev1Y91d09VnCttIK97st3p0kzb5uEU0izyCgwG9ohEcmBdZI/" +
       "W9L7/jl6Z5Nw/qgo3kwqDyS+IBLHUzz7Fnk+fT1WIzs4zqAtjfC/v9013Nlp" +
       "y4b/diK1Z4vGIj3AOZKacwWpHZz6zoWiOzjtVf5xUCt6Xbt+uUCu3SiKa+cF" +
       "8vxbCGQi215ygVSuHVxFKllSuXGc11j8kfDkPXnT+1xf9Rdfu3Xjiddm/6pM" +
       "7TvJx32IqtwwUsc5mx9zpn49iHTDLkX00D5bJii5fTSpPHEJa8WfaWWlgHrt" +
       "9r7/e5PK7fP9i5SR4vtsvyeSys3TfoDU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vnK2y1NJ5T7Qpaj+cHAs5xcukzOmxEkkq0kpIm+jgz1WlF27O1SdmONjbyf4" +
       "M9HtI3fFpDKn/Th+pJOjv2y+8dqI+Yk34Z/bZyWqjpznBZUbVOXBfYLkSQz6" +
       "0KXUjmldHz73g0e++dCzx/HykT3gUxs/g+2DF6cA4m6QlEl7+a888fde+luv" +
       "/U75n8P/Bc04yvRsMAAA");
}
