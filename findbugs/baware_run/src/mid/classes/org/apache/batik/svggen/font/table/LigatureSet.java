package org.apache.batik.svggen.font.table;
public class LigatureSet {
    private int ligatureCount;
    private int[] ligatureOffsets;
    private org.apache.batik.svggen.font.table.Ligature[] ligatures;
    public LigatureSet(java.io.RandomAccessFile raf, int offset) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            offset);
        ligatureCount =
          raf.
            readUnsignedShort(
              );
        ligatureOffsets =
          (new int[ligatureCount]);
        ligatures =
          (new org.apache.batik.svggen.font.table.Ligature[ligatureCount]);
        for (int i =
               0;
             i <
               ligatureCount;
             i++) {
            ligatureOffsets[i] =
              raf.
                readUnsignedShort(
                  );
        }
        for (int i =
               0;
             i <
               ligatureCount;
             i++) {
            raf.
              seek(
                offset +
                  ligatureOffsets[i]);
            ligatures[i] =
              new org.apache.batik.svggen.font.table.Ligature(
                raf);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wUxxkfn98v/AAM5WHANki8bktJmhLTJMaxg8kZWzax" +
                                                              "VJPk2Nubu1vY21125+zDlBKoGlAqURRMStvgP1poU0ogbYP6UihVHwHRBEGj" +
                                                              "NoQ2NMkfSUqQ4I/GaWmbfjOze/u4B0WqYmn3xrPfN4/v8ft9M8evo1LTQC26" +
                                                              "qEbFINmmYzPYT9v9omHiaKcimuYG6A1LT711YOfkHyp3BVDZMJqSEM1eSTRx" +
                                                              "t4yVqDmM5sqqSURVwuZ6jKNUo9/AJjZGRCJr6jCaLps9SV2RJZn0alFMBYZE" +
                                                              "I4QaREIMOZIiuMcagKB5IbYaga1G6PALtIdQjaTp2xyFWR6FTtc3Kpt05jMJ" +
                                                              "qg9tFkdEIUVkRQjJJmlPG2iprinb4opGgjhNgpuVuy1DrAvdnWWGlhfqPry1" +
                                                              "P1HPzDBVVFWNsC2aA9jUlBEcDaE6p7dLwUlzK/oSKg6hapcwQW0he1IBJhVg" +
                                                              "Unu/jhSsvharqWSnxrZD7JHKdIkuiKAF3kF00RCT1jD9bM0wQgWx9s6UYbfz" +
                                                              "M7u13e3b4sGlwvjXH6//UTGqG0Z1sjpIlyPBIghMMgwGxckINsyOaBRHh1GD" +
                                                              "Cg4fxIYsKvKY5e1GU46rIklBCNhmoZ0pHRtsTsdW4EnYm5GSiGZkthdjQWX9" +
                                                              "VxpTxDjstcnZK99hN+2HDVbJsDAjJkLsWSolW2Q1yuLIq5HZY9vDIACq5UlM" +
                                                              "ElpmqhJVhA7UyENEEdW4MAjBp8ZBtFSDEDRYrOUZlNpaF6UtYhyHCZrpl+vn" +
                                                              "n0CqkhmCqhA03S/GRgIvzfJ5yeWf6+tX79uurlUDqAjWHMWSQtdfDUrNPqUB" +
                                                              "HMMGhjzgijVLQs+ITS/tDSAEwtN9wlzmJ1+8+cCy5jNnuczsHDJ9kc1YImHp" +
                                                              "SGTKxTmdi1cV02VU6JopU+d7ds6yrN/60p7WAWmaMiPSj0H745mB333hiWP4" +
                                                              "WgBV9aAySVNSSYijBklL6rKCjYewig2R4GgPqsRqtJN970Hl0A7JKua9fbGY" +
                                                              "iUkPKlFYV5nG/gcTxWAIaqIqaMtqTLPbukgSrJ3WEULl8KAaeOYi/sd+CdKE" +
                                                              "hJbEgiiJqqxqQr+h0f1ThzLMwSa0o/BV14QIxP+W5SuC9wimljIgIAXNiAsi" +
                                                              "REUC84+CORKPY1WIgaUEIkYUDCgUZ6kyiAF7IPD0T37KNLXC1NGiInDQHD88" +
                                                              "KJBZazUlio2wNJ5a03XzRPg8Dz2aLpb9CArCvEE+b5DNG+TzBum8QTZv0DUv" +
                                                              "Kipi002j8/NYAE9uAUwAUK5ZPPjYuk17W4ohCPXREnADFV2URVKdDnjYiB+W" +
                                                              "jl8cmLzwStWxAAoAvkSApBymaPMwBSc6Q5NwFBaVjzNs3BTys0TOdaAzh0Z3" +
                                                              "De38NFuHG/zpgKWAW1S9n0J2Zoo2f9LnGrduz3sfnnxmh+akv4dNbBLM0qSo" +
                                                              "0uJ3rn/zYWnJfPFU+KUdbQFUAlAF8ExESCdAvmb/HB50abeRmu6lAjYc04yk" +
                                                              "qNBPNrxWkYShjTo9LOoaWHsauLiaplsTPG1W/rFf+rVJp+8ZPEppzPh2wZjg" +
                                                              "84P64ddffX8lM7dNGnUutoega3cBFR2skUFSgxOCGwxMg/Mvh/oPHLy+ZyOL" +
                                                              "P5BozTVhG313AkCBC8HMXzm79fLVN4+8FnBilgBTpyJQ9KQzm6T9qKrAJmmc" +
                                                              "O+sBoFMg82nUtD2iQlTKMZlmEk2Sf9UtXHHqg331PA4U6LHDaNntB3D6P7UG" +
                                                              "PXH+8clmNkyRRInWsZkjxtF7qjNyh2GI2+g60rsuzf3Gy+Jh4AHAXlMewwxO" +
                                                              "A8wGAbbzmcAKTFPWggOQdFqyQwKoMrsBmE0a9q7EpuXhYCpikn5DToKnRizy" +
                                                              "Otk0ufU35WMP2sSUS4VLPmz2Xvj52nfDLBIqKADQfrqOWldqdxhxVxjWcw99" +
                                                              "DH9F8PyHPtQztIPTQGOnxUXzM2Sk62lY/eIC1aN3C8KOxqtbnn3veb4FP1n7" +
                                                              "hPHe8ac+Du4b5+7lFU1rVlHh1uFVDd8Ofd1LV7eg0CxMo/vdkzt+8dyOPXxV" +
                                                              "jV5+7oLy8/k//vv3wUN/PZcD9ItlqypdSeM9g9RNfu/wLZWtOPyPnU++3gfQ" +
                                                              "0oMqUqq8NYV7ou4xoSQzUxGXu5xaiXW4N0ddAzSyBLzAuu9iCxGylmMF4FQ7" +
                                                              "AHv6utIS1mlQM70e+moz3ejrdaSrIg9L+1+7UTt04/RNZgxvSe8Gm15R555o" +
                                                              "oK+F1BMz/Ey3VjQTIHfXmfWP1itnbsGIwzAiS4w+A+g27YEmS7q0/I1f/bpp" +
                                                              "08ViFOhGVYomRrtFhvKoEuAVmwlg6rR+/wMcXUYr4FVPW2mUMQxihuHINi83" +
                                                              "VHQldcKSe+ynM15c/b2JNxmqcRibzdSLTXqS8BMyOw46XPLBlW+988vJ75Tz" +
                                                              "0CqQKD69mf/sUyK73/4oy8iMOnPkjk9/WDj+7KzO+64xfYfDqHZrOrvEAZZ3" +
                                                              "dD9zLPn3QEvZbwOofBjVS9bRa0hUUpQZhuG4YdrnMTieeb57jw68Tm7PcPQc" +
                                                              "f/K6pvWzpzsjSogn+h3CpLUqaoZnnsUl8/yEWYRY41Gmsoi9F9PXMpufynVD" +
                                                              "hiM69hFUdYFBCapVrDKuU0upjHRWcWam7xB9PcbH68sbhkPeTbTAM9+ab36e" +
                                                              "TfCiYRF9hbNXm08bstJeLT8emP64zZAHIzQOVD+b+v6Pz20qv8zjNjc9+c5W" +
                                                              "b28//23tz9cCVIXO/LnMGqfQJTXAYxmD/xIk/1+LfHr+F0eJEMdaEoYgiRBW" +
                                                              "4yRhnyg+ucko1C3Mn+kuK098t/XVnROtbzHgq5BNyAcg5RxnX5fOjeNXr12q" +
                                                              "nXuCVacllNstovBeGmTfCXiO+sxDdfSVZM1VOUljiAtY8UdyJ1GANpcTSF9Z" +
                                                              "FRU22r1Q9ynMIPS/++nLsLBzZXZhxHmJIgac8TUV0+rM/jbN5qzM/Qp8TOcg" +
                                                              "3AVZSNzLtuvA2j2XJouvPD2zJvtUREdrznPmWZLfkf4JXt79t1kb7ktsuoPj" +
                                                              "zjyfn/1Dfr/3+LmHFklPB9jlDEfRrEsdr1K7FzurDAypr3rrhxbH8YYDKkuY" +
                                                              "63w1hE2V9P8nC3zbS19fhiiQqAu5xwuIf5VF1AYXJ1uupP92p31oGrtDNF1g" +
                                                              "PXY7F5p+rSCa5tMmqNJGU5NpbfbOPK3QzEyUtQ+m7QBfegeXBrqu/2/22l/A" +
                                                              "XmmXwzNrZ39lyHfz41q7q+5BFN/m5rucYwX1kd3jE9G+oytsKugAsxFNX67g" +
                                                              "Eax4hiKo2nUlQuuxmVmXs/xCUToxUVcxY+KRP3Hgsy/9auCAE0spirtccLXL" +
                                                              "dAPHZLaIGl486OznKEEtt7c8hDPJoNERrvkc1DGFNAkqoT9ulR8QNCOPCgAl" +
                                                              "b7jlTxBU75eHpbBft9wPCapy5GAo3nCLvAgnFBChzVO6HXP1DuDyEi1d5PVv" +
                                                              "JpCm3y7xXCHR6kFKdhNvo1qK38XDEXZi3frtNz97lF9RSIo4NkZHqQZ24rcl" +
                                                              "GWRckHc0e6yytYtvTXmhcqEdZA18wU4qzHbhzQZIFZ2G1yzf+d1syxzjLx9Z" +
                                                              "ffqVvWWXgI03oiIRiGljdjGb1lMA2xtDuc53wBvsaqG96p1NFz56o6iRnRks" +
                                                              "gmoupBGWDpy+0h/T9W8GUGUPKoUcwmlWaT+4TR3A0ojhOS6WRaDuzFD9FJoL" +
                                                              "Ir2lZ5axDFqb6aVXXBDu2Sfn7Gs/OE6NYmMNHd2qKjxcktJ191dm2S7GGmle" +
                                                              "0RWHQ726bl0Z1IwzywNq0d+zDKn+C7zQ4yFuGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wSYAAA==");
}
