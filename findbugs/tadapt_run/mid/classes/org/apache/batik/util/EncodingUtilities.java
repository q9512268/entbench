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
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wUxxmfO9vnR/wmGGLAGGOIePlKSUCJaQg4BhvO9tU2" +
                                                              "tDVJjrm9Od/C3u6yO4sP0zxApUFtRaNAUvqAPyjpA9EQVUVtI4W6qtokoimC" +
                                                              "Rm0S2pSGP9qUIIU/Eqelr29mdm8fd3ZUqYql3RvPfPPNfN/8vt/3zZ65gcpM" +
                                                              "A7XpWE3hDrpXJ2ZHnLXj2DBJqkvBpjkMvQnpS38+8tjkbyv3h1FkBNVmsNkn" +
                                                              "YZNslImSMkfQPFk1KVYlYvYTkmIz4gYxibEHU1lTR9BM2ezN6oosybRPSxEm" +
                                                              "sA0bMdSAKTXkpEVJr62Aovkxvpso3010fVCgM4aqJU3f605o9k3o8owx2ay7" +
                                                              "nklRfWwn3oOjFpWVaEw2aWfOQMt0Tdk7qmi0g+Rox07lbtsRm2N3F7ih7fm6" +
                                                              "D249mannbpiBVVWj3ERzkJiasoekYqjO7e1WSNbcjR5FJTF0m0eYovaYs2gU" +
                                                              "Fo3Coo69rhTsvoaoVrZL4+ZQR1NEl9iGKFrgV6JjA2dtNXG+Z9BQQW3b+WSw" +
                                                              "tjVvrXPcAROfXhY9+rWH639YgupGUJ2sDrHtSLAJCouMgENJNkkMc30qRVIj" +
                                                              "qEGFAx8ihowVedw+7UZTHlUxtQACjltYp6UTg6/p+gpOEmwzLIlqRt68NAeV" +
                                                              "/V9ZWsGjYGuTa6uwcCPrBwOrZNiYkcaAPXtK6S5ZTXEc+WfkbWzfAgIwtTxL" +
                                                              "aEbLL1WqYuhAjQIiClZHo0MAPnUURMs0gKDBsTaFUuZrHUu78ChJUDQ7KBcX" +
                                                              "QyBVyR3BplA0MyjGNcEpNQdOyXM+N/rXHt6n9qhhFII9p4iksP3fBpNaApMG" +
                                                              "SZoYBOJATKxeGnsGN714KIwQCM8MCAuZH3/+5v3LWyZeFjJzisgMJHcSiSak" +
                                                              "U8naS3O7ltxTwrZRoWumzA7fZzmPsrg90pnTgWma8hrZYIczODH4q889fppc" +
                                                              "D6OqXhSRNMXKAo4aJC2rywoxNhGVGJiSVC+qJGqqi4/3onJox2SViN6BdNok" +
                                                              "tBeVKrwrovH/wUVpUMFcVAVtWU1rTlvHNMPbOR0hVA4PqoanBYk//ktRJprR" +
                                                              "siSKJazKqhaNGxqznx0o5xxiQjsFo7oWTQL+d61Y2bEmamqWAYCMasZoFAMq" +
                                                              "MkQMCpd0q5KWAlxthX/AfHAsQ5z+Ma6VY3bPGAuF4EjmBglBgVjq0ZQUMRLS" +
                                                              "UWtD983nEhcE2FiA2B6j6E5YsEMs2MEXFEdasCAKhfg6t7OFhQwc2i4If+Df" +
                                                              "6iVDD23ecaitBPCmj5WCx5no4oJ81OXyhEPuCenMpcHJi69WnQ6jMFBJEvKR" +
                                                              "mxTafUlB5DRDk0gKWGmq9OBQZHTqhFB0H2ji2Nj+bY99gu/Dy/NMYRlQFJse" +
                                                              "Z+ycX6I9GN/F9NY98dcPzj7ziOZGui9xOPmuYCYjkLbgqQaNT0hLW/G5xIuP" +
                                                              "tIdRKbASMDHFEDlAci3BNXxE0umQMrOlAgxOa0YWK2zIYdIqmjG0MbeHw62B" +
                                                              "t2+HI65lkTUfns/YocZ/2WiTzt6zBDwZZgJWcNL/1JB+/PXfvLOKu9vJD3We" +
                                                              "xD5EaKeHk5iyRs4+DS4Ehw1CQO6Px+JHnr7xxHaOP5BYWGzBdvbuAi6CIwQ3" +
                                                              "H3x59xt/euvUa2EXsxRV6oZGIVhJKpe3kw2hmmnsZFB3twS0poAGBpz2rSoA" +
                                                              "U07LOKkQFif/rFu08ty7h+sFFBTocZC0/KMVuP13bECPX3h4soWrCUksrbpu" +
                                                              "c8UEV89wNa83DLyX7SO3//K8r7+EjwPrA9Oa8jjh5Im4GxA/t7u4/VH+XhUY" +
                                                              "W81e7aYX//4Q85Q/CenJ196r2fbe+Zt8t/76yXvcfVjvFAhjr0U5UD8ryDU9" +
                                                              "2MyA3F0T/Q/WKxO3QOMIaJSAN80BA5gu5wOHLV1W/ubPf9G041IJCm9EVYqG" +
                                                              "UxsxjzNUCQAnZgZIMqevu18c7lgFvOq5qajAeObP+cVPqjurU+7b8Z/M+tHa" +
                                                              "7554i+NKoGhOnhJbCyiR195uNL975ZvXfjb57XKRuZdMTWGBebP/MaAkD7z9" +
                                                              "YYGTOXkVqSoC80eiZ77V3HXfdT7fZRE2e2GuMLsAz7pzP3k6+364LfLLMCof" +
                                                              "QfWSXeduw4rFYnMEajvTKX6hFvaN++s0UZR05llybpDBPMsG+cvNatBm0qxd" +
                                                              "E6CsOewU74FnoR3KC4OUFUK8sYlPWczfS9hrOT/CEtZcQVHE5NU0hS3IKlYC" +
                                                              "XNE8zQJAMd39XQMP9PZvGmJg8uKB3amGrKRJB/EYrxQT0lfaDu6/s/zmagGH" +
                                                              "1qLSnqJy1eTqutbT31OFeHtx5f5y8u19F05qf7gedkrFYlOE5Baz7+ILPX9J" +
                                                              "cMKuYHl62HGzJwOvN0Y92aLeny0a4Llqe+aqKMx2/l+LJVACdyc5C5VLdFjO" +
                                                              "khS7uxGVOqXZx7gaI7A5BeHuHu25F76z5tDyz54Ujl8wRaS78j/99NVLx8fP" +
                                                              "nhG5g7mfomVT3T8LL72smlg0TUXkguj9TfdOvHNt20Nhm+1r2WtYYHw2RTUu" +
                                                              "/wG5ss4H8zwZyhNdUxBIQndk5fG/P/bF1wegWOlFFZYq77ZIb8ofveWmlfQg" +
                                                              "y71ouRFtw+o/8BeC59/sYXBiHQJWjV32paM1f+vQ9Rwbpyi0FJqiNmHvNezV" +
                                                              "I+y7t1gayBUnAygXIrqVVGTJjX/+FwleP7y1gpsPEEPIvKluiPx2e+rA0ROp" +
                                                              "gWdXCow0+m9d3aqV/cHv/vXrjmNXXylS2FdSTV+hkD1ECeSgBQWg7OMXaJfQ" +
                                                              "11yeLLny1OzqwoqcaWqZot5eOjW6ggu8dOBvzcP3ZXb8D6X2/ICjgiq/33fm" +
                                                              "lU2LpafC/BuAyB8F3w78kzr9uKsyCLUM1Y+0tvzR3sGObBE8CftoE8XL3aJY" +
                                                              "CbMmv6ZuCSSLhmk0BkowJ7rsQKzngcgSZ4f4wME3MD5N3fYoe1GKqtlM54bH" +
                                                              "+va5gWBNEwiF9RDrWJejqKHgvshKpdkFH6nEhxXpuRN1FbNObP09v7PkP35U" +
                                                              "Q1pJW4rizeSedkQ3SFrmhlSLvC6i+CBFM4teYikqZT98118QsofAbUFZyOL8" +
                                                              "1yv3ZYqqXDkIdNHwihymqAREWPOrepEzEcVMLuSP+LyfZ36Unz0ksdAXWfwD" +
                                                              "oRMFVtxOD2dPbO7fd3P1s+I6JSl4fJx/UAI+FTe7fCQtmFKboyvSs+RW7fOV" +
                                                              "i5wM0CA27OJ7jgdU6wCSOjvt5sBFw2zP3zfeOLX2/KuHIpeBprajEKZoxvbC" +
                                                              "si+nWxDm22PFMgfwDL8DdVZd23HxwzdDjby6tgmtZboZCenI+SvxtK5/I4wq" +
                                                              "e1EZsCrJ8Zr0gb3qIJH2GL5EFElqlpr/lljLoIlZbHHP2A6tyfey6zhFbQVf" +
                                                              "CYt8ooCLxxgxNjDtdmLzcY+l695R7tkEe+GcSGgliVifrtsJrjLEPa/rPABP" +
                                                              "steO/wJXLEgEBRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+q1nv5UfAP4PIjsmMAIiAAA=");
}
