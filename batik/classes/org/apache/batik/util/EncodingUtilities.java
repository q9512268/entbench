package org.apache.batik.util;
public class EncodingUtilities {
    protected static final java.util.Map ENCODINGS = new java.util.HashMap(
      );
    static { ENCODINGS.put("UTF-8", "UTF8");
             ENCODINGS.put("UTF-16", "Unicode");
             ENCODINGS.put("US-ASCII", "ASCII");
             ENCODINGS.put("ISO-8859-1", "8859_1");
             ENCODINGS.put("ISO-8859-2", "8859_2");
             ENCODINGS.put("ISO-8859-3", "8859_3");
             ENCODINGS.put("ISO-8859-4", "8859_4");
             ENCODINGS.put("ISO-8859-5", "8859_5");
             ENCODINGS.put("ISO-8859-6", "8859_6");
             ENCODINGS.put("ISO-8859-7", "8859_7");
             ENCODINGS.put("ISO-8859-8", "8859_8");
             ENCODINGS.put("ISO-8859-9", "8859_9");
             ENCODINGS.put("ISO-2022-JP", "JIS");
             ENCODINGS.put("WINDOWS-31J", "MS932");
             ENCODINGS.put("EUC-JP", "EUCJIS");
             ENCODINGS.put("GB2312", "GB2312");
             ENCODINGS.put("BIG5", "Big5");
             ENCODINGS.put("EUC-KR", "KSC5601");
             ENCODINGS.put("ISO-2022-KR", "ISO2022KR");
             ENCODINGS.put("KOI8-R", "KOI8_R");
             ENCODINGS.put("EBCDIC-CP-US", "Cp037");
             ENCODINGS.put("EBCDIC-CP-CA", "Cp037");
             ENCODINGS.put("EBCDIC-CP-NL", "Cp037");
             ENCODINGS.put("EBCDIC-CP-WT", "Cp037");
             ENCODINGS.put("EBCDIC-CP-DK", "Cp277");
             ENCODINGS.put("EBCDIC-CP-NO", "Cp277");
             ENCODINGS.put("EBCDIC-CP-FI", "Cp278");
             ENCODINGS.put("EBCDIC-CP-SE", "Cp278");
             ENCODINGS.put("EBCDIC-CP-IT", "Cp280");
             ENCODINGS.put("EBCDIC-CP-ES", "Cp284");
             ENCODINGS.put("EBCDIC-CP-GB", "Cp285");
             ENCODINGS.put("EBCDIC-CP-FR", "Cp297");
             ENCODINGS.put("EBCDIC-CP-AR1", "Cp420");
             ENCODINGS.put("EBCDIC-CP-HE", "Cp424");
             ENCODINGS.put("EBCDIC-CP-BE", "Cp500");
             ENCODINGS.put("EBCDIC-CP-CH", "Cp500");
             ENCODINGS.put("EBCDIC-CP-ROECE", "Cp870");
             ENCODINGS.put("EBCDIC-CP-YU", "Cp870");
             ENCODINGS.put("EBCDIC-CP-IS", "Cp871");
             ENCODINGS.put("EBCDIC-CP-AR2", "Cp918");
             ENCODINGS.put("CP1252", "Cp1252"); }
    protected EncodingUtilities() { super(); }
    public static java.lang.String javaEncoding(java.lang.String encoding) {
        return (java.lang.String)
                 ENCODINGS.
                 get(
                   encoding.
                     toUpperCase(
                       ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wUxxmfO7/fZ4MNGGzAGBCP+EIbmlATGmMMHD0/isFV" +
                                                              "j8cxtzdnL97bXXZn7bMTWoIUQVUVEUoIrQp/QUgpDVHVqE3bRK6i5qGklUho" +
                                                              "0zQKRU3/SJqiBKVJq9LXNzN7t487m0ZVLO3cePabb+b75vf9vm/20g1UYhqo" +
                                                              "lai0g07oxOzoUekANkyS7Fawae6Asbj0aBH+cO87feuCqDSGakew2Sthk2yW" +
                                                              "iZI0Y6hFVk2KVYmYfYQk2YwBg5jEGMNU1tQYapTNSFpXZEmmvVqSMIEhbERR" +
                                                              "PabUkBMWJRFbAUUtUdhJmO8k3OV/3RlF1ZKmTzjic13i3a43TDLtrGVSFIru" +
                                                              "x2M4bFFZCUdlk3ZmDLRK15SJYUWjHSRDO/Yra20XbIuuzXNB25N1H986PhLi" +
                                                              "LpiFVVWj3DxzOzE1ZYwko6jOGe1RSNo8gL6KiqKoyiVMUXs0u2gYFg3Dollr" +
                                                              "HSnYfQ1RrXS3xs2hWU2lusQ2RNFirxIdGzhtqxngewYN5dS2nU8GaxflrBVW" +
                                                              "5pn4yKrwyUf3hn5YhOpiqE5WB9l2JNgEhUVi4FCSThDD7EomSTKG6lU47EFi" +
                                                              "yFiRJ+2TbjDlYRVTC44/6xY2aOnE4Gs6voJzBNsMS6KakTMvxQFl/1eSUvAw" +
                                                              "2Nrk2Cos3MzGwcBKGTZmpDDgzp5SPCqrSYoW+mfkbGz/IgjA1LI0oSNabqli" +
                                                              "FcMAahAQUbA6HB4E6KnDIFqiAQANipqnVcp8rWNpFA+TOEOkT25AvAKpCu4I" +
                                                              "NoWiRr8Y1wSn1Ow7Jdf53Ohbf+x+dasaRAHYc5JICtt/FUxq9U3aTlLEIBAH" +
                                                              "YmL1yugp3PTM0SBCINzoExYyP37g5n2rW6deFDLzC8j0J/YTicalc4naKwu6" +
                                                              "V6wrYtso1zVTZofvsZxH2YD9pjOjA8M05TSylx3Zl1Pbn//KoYvkvSCqjKBS" +
                                                              "SVOsNOCoXtLSuqwQYwtRiYEpSUZQBVGT3fx9BJVBPyqrRIz2p1ImoRFUrPCh" +
                                                              "Uo3/Dy5KgQrmokroy2pKy/Z1TEd4P6MjhMrgQdXwtCLxx38pioVHtDQJYwmr" +
                                                              "sqqFBwyN2W+GgXES4NuRcAJQPxo2NcsACIY1YziMAQcjxH7BndCjSloSkLQT" +
                                                              "/gGDwZUMY/qnqj3DbJs1HgiA2xf4g16BeNmqKUlixKWT1saem0/EXxaAYkFg" +
                                                              "e4Wi5bBgh1iwgy8oji1vQRQI8HVms4WFDBzMKIQ4cGz1isE92/YdbSsCTOnj" +
                                                              "xeBVJtrmyTXdDg9kyTsuXW6omVx8bc1zQVQcRQ1YohZWWOroMoaBlKRRO26r" +
                                                              "E5CFnGSwyJUMWBYzNIkkgYumSwq2lnJtjBhsnKLZLg3ZVMWCMjx9oii4fzR1" +
                                                              "evzBoa/dGURBL/+zJUuAutj0AcbaOXZu98d9Ib11R975+PKpg5rDAJ6Eks2D" +
                                                              "eTOZDW1+JPjdE5dWLsJPxZ852M7dXgEMTTFEFJBfq38ND8F0Zsma2VIOBqc0" +
                                                              "I40V9irr40o6YmjjzgiHaD3vzwZY1LKIWwjPl+0Q5L/sbZPO2jkC0gxnPit4" +
                                                              "Mrh3UD/zu1+/+1nu7mzeqHMl/EFCO11cxZQ1cFaqd2C7wyAE5N46PfCtR24c" +
                                                              "2cUxCxJLCi3Yztpu4Cg4QnDzQy8eeOMP185dDTo4p6hCNzQKIU2SmZyd7BWq" +
                                                              "mcFOWHCZsyWgOwU0MOC071QBonJKxgmFsNj6Z93SNU/95VhIQEGBkSySVt9e" +
                                                              "gTM+byM69PLev7VyNQGJpVvHbY6Y4PBZjuYuw8ATbB+ZB19t+fYL+AxkA2Bg" +
                                                              "U54knFQRdwPi57aW238nb+/yvbubNUtNN/69IeYqi+LS8asf1Ax98OxNvltv" +
                                                              "XeU+7l6sdwqEsWZZBtTP8fPTVmyOgNxdU327Q8rULdAYA40ScK3ZbwA7Zjzg" +
                                                              "sKVLyn7/i+ea9l0pQsHNqFLRcHIz5nGGKgDgxBwBYs3oX7hPHO54OTQhbirK" +
                                                              "Mz5vgDl4YeGj60nrlDt78idzfrT+wtlrHGi60DE/R6wLPMTKq3Mnti++dvdv" +
                                                              "Ljx8alzk9xXTE5pv3tx/9CuJw3/8e57LOZUVqD1882PhS99t7t7wHp/vcAqb" +
                                                              "3Z7Jz0/Ay87cz1xMfxRsK/1lEJXFUEiyq+EhrFgsUmNQAZrZEhkqZs97bzUn" +
                                                              "SpfOHGcu8POZa1k/mzl5EfpMmvVrfAQ2nx3hOniW2IG9xE9gAcQ7ET5lOW9X" +
                                                              "suYOfnxFrNtBUanJa24KW5BVrPiYo3mGBYBwevq6+zdF+rYMAhZaHCywRDZo" +
                                                              "JUy6HY/zajIu7V4eampf92GbAENrAVlX2XnsZz+NxZaHJCHcVkixt9x8/EK5" +
                                                              "9Gb6+T+JCfMKTBByjY+Hvzn0+v5XOG2Xs1y+I+teV6aGnO/KGSFvzqiH57rt" +
                                                              "keuibNv9fxZWMA3uUnIaqpzwDjlNkuwux2ywC7dPVT+nKk8YO4f2/VGl6/17" +
                                                              "HrtXuHXxNBHsyD/9petXzkxeviQyBHMvRaumu33mX3lZzbB0hrrHAchHWz4/" +
                                                              "9e7bQ3uCNqfXsmZIYHcuRTUOqQGFssG9OfIL5MhrthcmQvOmr9f9/HhD0WYo" +
                                                              "SCKo3FLlAxaJJL0xWWZaCRdunEuWE6c2aP4DfwF4/s0eBhY2IEDT0G1fOBbl" +
                                                              "bhzAr+w9RYGV0BX1B2vvYc02YV1nIarPFA5xKAlKdSuhyJIT1fyv1H/1cNcD" +
                                                              "DsMjho2W6W6H/GZ77vDJs8n+82sEQhq8N64e1Ur/4Lf/eqXj9PWXChT8FVTT" +
                                                              "71DIGFF8WaXFA8defnF2KPqt2hNvP90+vPGTVOpsrPU2tTj7fyEYsXJ6BPq3" +
                                                              "8sLhPzfv2DCy7xMU3Qt97vSr/F7vpZe2LJNOBPlXApE78r4ueCd1etFZaRBq" +
                                                              "GaoXj0tyAJjHDnYpPHEbAPHChW9BRAVZdz9ren2Jon4Gjb5iLBuBdrCGeLCy" +
                                                              "pNkhPoHwDTwwQwV3iDVjFFWzmdn7IRs76ITL+Azh8j9URmygS89QVJ93/2RV" +
                                                              "09y8D1viY4z0xNm68jlnd77OwZn7YFINMEtZiuLO665+qW6QlMxNqxZZXkT/" +
                                                              "UYoaC16KKSpmP3zbR4TsN8CRflnI6fzXLXeMokpHDghCdNwiD1NUBCKse0Iv" +
                                                              "cEqitMkEvEyR83zj7TzvIpclnljjHxWzcWEN2Enl8tltffff/Nx5cdWSFDw5" +
                                                              "ybRUAQ+LW18uthZPqy2rq3Trilu1T1YszeaNerFhB/HzXTDrApDq7LSbfZcQ" +
                                                              "sz13F3nj3Ppnf3W09FWgt10ogCmatSu/CMzoFpDarmh+vgEe4rejzhXfmdiw" +
                                                              "OvX+m7zMzi+u/fJx6eqFPa+dmHsOblFVEVQCTEwyvDrdNKFuJ9KYEUM1stmT" +
                                                              "gS2CFhkrnmRWy4CJWaxxv9jurMmNsos6RW153xULfN6AK8k4MTZqlpq002GV" +
                                                              "M+L52pmlJ0vXfROcEVfZhVkjZUSyLIpHe3U9mzyr/qrzAE34KYUP8tnneZc1" +
                                                              "j/0XFJlponAYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IgAA");
}
