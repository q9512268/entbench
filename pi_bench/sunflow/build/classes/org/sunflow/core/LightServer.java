package org.sunflow.core;
class LightServer {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.LightSource[] lights;
    private org.sunflow.core.Shader shaderOverride;
    private boolean shaderOverridePhotons;
    private int maxDiffuseDepth = 4;
    private int maxReflectionDepth = 16;
    private int maxRefractionDepth = 16;
    private org.sunflow.core.CausticPhotonMapInterface causticPhotonMap;
    private org.sunflow.core.GIEngine giEngine;
    private int photonCounter;
    private org.sunflow.core.LightServer.CacheEntry[] shadingCache;
    private float shadingCacheResolution;
    private long cacheLookups;
    private long cacheEmptyEntryMisses;
    private long cacheWrongEntryMisses;
    private long cacheEntryAdditions;
    private long cacheHits;
    private static class CacheEntry {
        int cx;
        int cy;
        org.sunflow.core.LightServer.Sample first;
        public CacheEntry() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1YfWwcxRWfO387dnw+x44JTkicC5UT545QUoqc0iSOjR3O" +
                                                                  "H7KD1ToQZ25vzrfx3u5md9Y+O7hAUBW3UqMgTJJW4L+CQBGQqGrUSi3IFWpL" +
                                                                  "Ba0EpQVaNVRVpaaiUYmqQtW0pW9mdm8/zmeEVEs3npt5b97HvPd7b+6F66jC" +
                                                                  "NNAmotI4ndWJGe9R6TA2TJLuVrBpHoK1CelcGf77kWuD94RR5Tham8XmgIRN" +
                                                                  "0isTJW2Oo42yalKsSsQcJCTNOIYNYhJjGlNZU8dRs2z253RFlmQ6oKUJIxjD" +
                                                                  "RhI1YkoNOWVR0m8fQNHGJGiS4Jok9gW3u5KoTtL0WZe81UPe7dlhlDlXlklR" +
                                                                  "JHkMT+OERWUlkZRN2pU30A5dU2YnFY3GSZ7Gjym7bRccTO4uckH75YaPbp7J" +
                                                                  "RrgLmrCqapSbZ44QU1OmSTqJGtzVHoXkzOPoa6gsidZ4iCmKJR2hCRCaAKGO" +
                                                                  "tS4VaF9PVCvXrXFzqHNSpS4xhSja4j9ExwbO2ccMc53hhGpq286ZwdrNBWuF" +
                                                                  "lUUmPrUjsXjuSOS7ZahhHDXI6ihTRwIlKAgZB4eSXIoY5r50mqTHUaMKlz1K" +
                                                                  "DBkr8px901FTnlQxteD6HbewRUsnBpfp+gruEWwzLIlqRsG8DA8o+1tFRsGT" +
                                                                  "YGuLa6uwsJetg4G1MihmZDDEnc1SPiWraYpuC3IUbIzdDwTAWpUjNKsVRJWr" +
                                                                  "GBZQVISIgtXJxCiEnjoJpBUaBKBB0YaShzJf61iawpNkgkVkgG5YbAFVDXcE" +
                                                                  "Y6GoOUjGT4Jb2hC4Jc/9XB/cc/qE2qeGUQh0ThNJYfqvAaZNAaYRkiEGgTwQ" +
                                                                  "jHXbk2dxy8sLYYSAuDlALGi+//CNvZ2bll8TNLeuQDOUOkYkOiFdSK19s627" +
                                                                  "454ypka1rpkyu3yf5TzLhu2drrwOCNNSOJFtxp3N5ZGffvXRi+SDMKrtR5WS" +
                                                                  "plg5iKNGScvpskKM+4hKDExJuh/VEDXdzff7URXMk7JKxOpQJmMS2o/KFb5U" +
                                                                  "qfHv4KIMHMFcVAtzWc1ozlzHNMvneR0h1AQf1AqfHUj88f8U9SWyWo4kdDkx" +
                                                                  "bGjMdDMBYJMCt2YTpqVmFG0mYRpSQjMmC98lzSAAL5NZCpkxTYw4iyj9/3hW" +
                                                                  "nundNBMKgUvbggmtQC70aUqaGBPSorW/58ZLE6+LYGEBbltM0edAStyWEmdS" +
                                                                  "4h4psW4sZQkUAWMWhUJczjomWFwbOH0K0hfws65j9KGDRxfayyBe9Jly8Bgj" +
                                                                  "bffVkW43xx1gnpAuRevntlzd9WoYlSdRFEvUwgorC/uMSQAcacrOyboUVBgX" +
                                                                  "6Dd7gJ5VKEOTSBpwphTg26dUa2ASW6donecEpwyxhEuULgIr6o+Wz888NvbI" +
                                                                  "HWEU9mM7E1kBsMTYhxkiF5A3Fszplc5tOHXto0tn5zU3u33FwqlxRZzMhvZg" +
                                                                  "JATdMyFt34yvTLw8H+NurwH0pRiyBYBtU1CGDzy6HCBmtlSDwRnNyGGFbTk+" +
                                                                  "rqVZQ5txV3iINrKhWUQrC6GAghzDvzSqP/PuL//yee5JB+4bPHV6lNAuD8Sw" +
                                                                  "w6IcTBrdiDxkEAJ0vz8//ORT108d5uEIFFtXEhhjYzdAC9wOePDrrx1/7/2r" +
                                                                  "F94OuyFMUZVuyNC4kDw3Zt0n8BeCz3/Zh+ECWxD4EO22QWpzAaV0Jvp2VznA" +
                                                                  "KwWSnUVH7AEV4lDOyDilEJZA/27YtuvKX09HxH0rsOKES+enH+Cu37IfPfr6" +
                                                                  "kY838WNCEquXrgNdMgHCTe7J+wwDzzI98o+9tfHbP8PPAJwDhJryHOGoiLhD" +
                                                                  "EL/B3dwXd/DxrsDe3WzYZnqD3J9Hnr5mQjrz9of1Yx++coNr62+MvBc/gPUu" +
                                                                  "EUbiFkBYDNmDD6XZbovOxvV50GF9EKn6sJmFw+5aHnwwoizfBLHjIFaClsEc" +
                                                                  "MgAn875Ysqkrqn7741dbjr5ZhsK9qFbRcLoX84xDNRDqxMwCxOb1L+8VesxU" +
                                                                  "wxDh/kBFHipaYLdw28r325PTKb+RuR+s/96e55au8rjUxRm3cv4yhvo+iOU9" +
                                                                  "uJvlF39196+fe+LsjKjiHaWhLcDX+q8hJXXyj/8suhcOait0GAH+8cQLT2/o" +
                                                                  "vvcDzu+iC+OO5YsrFSC0y3vnxdw/wu2VPwmjqnEUkeyedwwrFkvscejzTKcR" +
                                                                  "hr7Yt+/v2USD0lVAz7YgsnnEBnHNrZAwZ9RsXh+IQXbTvF3otGOwMxiDIcQn" +
                                                                  "BznL7XzsYEOnNx4KR1WvchRFYSnvr6isao1aKROqn5wDRJy227s7h49KC7Hh" +
                                                                  "P4lLv2UFBkHX/HziW2PvHHuD4201q6+HHEM91RPqsAfHI2yIM0VWCaaAPon5" +
                                                                  "6PtTT197UegTjJwAMVlY/OYn8dOLAgZFA7+1qIf28ogmPqDdltWkcI7eP1+a" +
                                                                  "/+Hz86eEVlF/O9oDr60Xf/OfN+Ln//DzFTqmMtl+hLFUDhW6nXV+VwuDDnyj" +
                                                                  "4UdnomW9UGj7UbWlysct0p/2R1iVaaU8vncfBm7U2aaxckNRaDvggKilbPwi" +
                                                                  "G+4XwbSnJA4d+Oxxi9mQZKE3y2YjAZGpzyiyGT47bZE7S4jMiFRhw0BxdpTi" +
                                                                  "ppC9MjzrOUcrRMyqLe0ozuniJeAxZnIVY/Ir52+YTXdSVGnyl7GbzTy5o6sU" +
                                                                  "Jw+GIxauG0u98nioXji5uJQeenZX2K6xXwGR9uPbew5FtW6z7niibTVPgOTW" +
                                                                  "ol8BxMtVemmpoXr90gPv8Aax8LqsA6TIWIrihUfPvFI3SEbmStYJsBRx+jBF" +
                                                                  "kaAiFJWzf1zRE4LsEYrWeMgoSww+8xKdhPwDIjZ9XHfMjPAaymA/LmA/H/L7" +
                                                                  "uHDPzZ8WtJ5r2erDOP6zipPflvhhBd4vSwcHT9z4wrOia5UUPDfHn+GQ1aI3" +
                                                                  "LrT9W0qe5pxV2ddxc+3lmm3ORfu6Zq9ubL4fQIc3mBsCXZwZKzRz713Y88ov" +
                                                                  "FirfAgw7jEKYoqbDxQUyr1sQgYeTxegFBZK3l10d35m9tzPzt9/xFsRGu7bS" +
                                                                  "9NAAPPlu/+Wpj/fyd3wFxDDJ88p9YFYdIdK04YPCtSy6MPuBhfvBdl99YZU9" +
                                                                  "XyhqL64CxY8+aM9miLFfs9S0DaZr3BXf7zt2xNZauh5gcFc8he9Bgb/M+xB/" +
                                                                  "E8kBXXda/ys6T+qHghWBL3Lms3zKhnP/A7Cg2UFhFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAK05a8zj2FWeb3YeO93uzM52Hyzb7T6mlK23n/NwEltTYJ04" +
           "juM4cWLHcRxKp44fsRO/4kfsuCy0lUpLK8oitqVI7f5qBar6EqICCRUtQkBR" +
           "K6SiipdEWyEkikql7g8KokC5dr7XfDOzywoi+eb63nPPPe97zvVnvwedCwMI" +
           "9j17u7C9aF9Po/2lXduPtr4e7jNsbagEoa61bCUMx2DshvrkFy//4IfPm1f2" +
           "oPMz6H7Fdb1IiSzPDXk99OyNrrHQ5ePRtq07YQRdYZfKRkHiyLIR1gqj6yz0" +
           "uhNLI+gae0gCAkhAAAlIQQJCHEOBRa/X3dhp5SsUNwrX0C9AZ1jovK/m5EXQ" +
           "Ezcj8ZVAcQ7QDAsOAIaL+fsEMFUsTgPo8SPedzzfwvBHYeSF33jnld85C12e" +
           "QZctV8jJUQEREdhkBt3j6M5cD0JC03RtBt3n6rom6IGl2FZW0D2DrobWwlWi" +
           "ONCPhJQPxr4eFHseS+4eNectiNXIC47YMyzd1g7fzhm2sgC8PnjM645DKh8H" +
           "DF6yAGGBoaj64ZK7VparRdCbTq844vFaDwCApRccPTK9o63uchUwAF3d6c5W" +
           "3AUiRIHlLgDoOS8Gu0TQI3dEmsvaV9SVstBvRNDDp+GGuykAdXchiHxJBD1w" +
           "GqzABLT0yCktndDP9wZv/8i7XdrdK2jWdNXO6b8IFj12ahGvG3qgu6q+W3jP" +
           "W9mPKQ9++YN7EASAHzgFvIP5vZ9/+dlnHnvpKzuYH78NDDdf6mp0Q/3U/N6v" +
           "P9p6Gj+bk3HR90IrV/5NnBfmPzyYuZ76wPMePMKYT+4fTr7E/6n8ns/o392D" +
           "LnWh86pnxw6wo/tUz/EtWw86uqsHSqRrXehu3dVaxXwXugD6rOXqu1HOMEI9" +
           "6kJ32cXQea94ByIyAIpcRBdA33IN77DvK5FZ9FMfgqD7wQM9DB4Y2v2K/wii" +
           "EdNzdMS3kGHg5ayHiO5GcyBWEwlj17C9BAkDFfGCxdG76gU68PuFGQHP2OjB" +
           "fm5R/v8jrjSn+0py5gwQ6aOnHdoGvkB7tqYHN9QX4mb75c/f+OrekYEfcBxB" +
           "bwG77B/ssp/vsn9il2stRTX1thsFW+jMmWKfN+Qb79QGhL4C7gsC2z1PCz/H" +
           "vOuDT54F9uIndwGJ5aDIneNr69jhu0VYU4HVQS99PHnv5BdLe9DezYEyJxYM" +
           "XcqXD/PwdhTGrp12kNvhvfyB7/zgCx97zjt2lZsi74EH37oy98AnT4s18FRd" +
           "AzHtGP1bH1e+dOPLz13bg+4Cbg1CWaQA0wNR4rHTe9zkidcPo1rOyznAsOEF" +
           "jmLnU4eh6FJkBl5yPFLo+96ifx+Q8TXooLnJVvPZ+/28fcPOPnKlneKiiJo/" +
           "Jfif/Ju/+OdqIe7DAHv5xJEl6NH1E06dI7tcuO99xzYwDnQdwP39x4e//tHv" +
           "feBnCwMAEE/dbsNredsCzgxUCMT8/q+s//Zb3/zUN/aOjSYCp1o8ty013TH5" +
           "I/A7A57/zp+cuXxg55BXWwdR4fGjsODnO//EMW0gQNjAu3ILuia6jqdZhqXM" +
           "bT232P+8/Obyl/7lI1d2NmGDkUOTeubVERyP/1gTes9X3/lvjxVozqj5AXUs" +
           "v2OwXdS7/xgzEQTKNqcjfe9fvvE3/0z5JIifIGaFVqYXYQgq5AEVCiwVsoCL" +
           "Fjk1V8mbN4UnHeFmXzuRSNxQn//G918/+f4fvlxQe3MmclLvfcW/vjO1vHk8" +
           "BegfOu31tBKaAA59afCOK/ZLPwQYZwCjCo7fkAtAzElvspID6HMX/u6P/vjB" +
           "d339LLRHQZdsT9EopXA46G5g6XpognCV+j/z7M6ak4uguVKwCt3C/M5AHi7e" +
           "zgMCn75zrKHyROLYXR/+D86ev+8f/v0WIRRR5jbn56n1M+Szn3ik9dPfLdYf" +
           "u3u++rH01jgMkq7jtZXPOP+69+T5P9mDLsygK+pBRjdR7Dh3ohnIYsLDNA9k" +
           "fTfN35yR7I7f60fh7NHToebEtqcDzXH8B/0cOu9fOhVbctkXh+EzB7HlmdOx" +
           "5QxUdJ4tljxRtNfy5i0nzPPpCNpT01dWzzCwHBBfNgfpCfLc1W+tPvGdz+1S" +
           "j9O6OAWsf/CFD/1o/yMv7J1I+J66Jec6uWaX9BXEvb6gMKfuiVfapVhB/dMX" +
           "nvuD337uAzuqrt6cvrRBdv65v/qvr+1//Nt/fpsT9ixITXeBOG+reUPszLd+" +
           "R1O//toVwb2qIrZ5jz5FyvA1kvIAeN52QMrb7kDK5FVIOWdYQbgrZB4ACnvF" +
           "DERQHH+XuJ0gWnpVone6PQNOlHOV/cZ+KX+/cXuyzubdnwRHT1iUOAV5rmIf" +
           "EvvQ0lavHR42E1DygFhxbWk3Dsm/UoS53Cv3d3XCKVqf/l/TCizx3mNkrAdK" +
           "jg//4/Nf+9WnvgWsioHObfI4AMzvxI6DOK/CfumzH33j61749oeLkxQco8Kz" +
           "7/fek2NdvhLHeaPmjXbI6iM5q4IXB6rOKmHULw48XTvitn2Cn24Ejk3v/8Bt" +
           "dM87aDTsEoe/Xlk2pERNecngqlhDcxM4RVFmvAJVZ00c19DaSPTWaskSuCVf" +
           "5ehGjyyPvdGsUttkgZFW45qj4TLMNUxCbEpVcd1fjBlGQlm4NWp2RutOIApW" +
           "tUtJPttUSm1/NFEGE37iK4olys56FEklX8IdzcGQzNHbk3ZYdf2oNscb9Gao" +
           "NeZwnarXl63BgHC8qIu6msR0dJyvj4nKmGHjSdD0aa9Xbum22jEajZUUkzjK" +
           "87WxqTjY1Fl0+UHJCseMVOE8tLJV7F4ohCOVaY0HXFceyCaz7NiDmYhpfFjJ" +
           "KrUqT9nOqO71RKabLkne7JbllTfgpAlfcjBjNKA7TMcSUMZb4QsJsN/zxhFb" +
           "kmY6VhaHekOzTZu0p/bK5hl61R/DXJuXRHs14wcVX6yWiJomVmSXkqsdYdbo" +
           "LLdOY86r6phDY3VFN2qyMpz7DYYPFqwTtNaKL8xnKDoSy5wjjNdMJ8omtDdd" +
           "ZdzQU+qL0NJmqNVyegxfMVt8SyF6HS4S0IlC4cNJazMNplS2pgeCL6CpKSwV" +
           "dIm302TOVVS1r9aqptnx1xWsPku0YNCUYsoWRWcYiMtwuowFTmjMFNOkyWm3" +
           "bpljPunaPWIxa6K6MO16ci2olZz1mBaVfs/Oyj2yuQowP8VLZWrs2qM00sk6" +
           "PdcTXgzdpm/48CKI21KSsV17zYcdjCQwDy5HFOiP5U7MKvU4CRk9WqCdct8y" +
           "nRlJtl21LAwtKVBkP25Vu+K8m2lkMiYkX1wOeuGEZ6Sg05yNJl2hu4imTNqy" +
           "2u7SY/ymqDR7zWZJVgQzY4x62VISf7BarCarRacmzwlqQk7VtlzveJy47IxR" +
           "Zg4kiDIqgk+biKoi63ZlrXfEkVkamwNGNtYbQpkNCEXmV1a7sxgnoyU9na8q" +
           "WrrFQlaWBSImbYLtWDCCtAabWWVu29h4wOrxiOREbiWvOIvShF4ZD+uVBlpD" +
           "t/5KKQf+ahtXt0ZtnLFmXNGCIOGAsQscQ0WpXx3UZh3D2Ex5CxbIfi+I+Jok" +
           "+PaiZvUGHUHd+OGq14dRs0e2UyY2kUmbnGqZYTREftpfNZheyvkjxukLFQ/p" +
           "UfOauDboDdrr9uk+pU6IKJPUspfZGT3ob1ydL5llYmSUCQAlLjHMwERckLaS" +
           "h640cpXOO8u+RvabMtNvRRV57K8nDtUpOTLvC6Nl32nhmJ0JBMHWBrOWv0rH" +
           "coJa2yWOVE3JjV1t0Oz3FuJmvlg40ajVKCniWuk0h4IXSEgNm7HtOszKnXZz" +
           "bkf9kq4RQrSV2o4moCbqhxIazkYrkZD6kikyarb0HIkChkyXeiXTSMJ6bYn3" +
           "OiSfGsp229Rxxt5izcVybhiTlYRW07S8cH0i5vWNG9mZhkuebAsaT7U3YrLw" +
           "ghYS94URoSpqwG3nnjhpLqZ1UmssmNqk1+bGQtNPfHO8qNQ1UakQglTXPFdX" +
           "236yTc12LLKLblD3YCnDMGywmXdpqS3iTr/RLq+aYX8sm+nKompElQoz31Zr" +
           "EUdPI68UubVMrMbVKpWs7ZSfZX1zM1swxFjrb6moim43YzbBaHgQBwld8nlr" +
           "25SbkVhudchsW6dbTSeyBTLh3cG206Hm4xUcrCezUS1KJ1WrOwh6piSOgla9" +
           "QyzMjNxkwnqIDGMWQba6XmOaMDof0pO6PQCmiwlJUu+q42agWWS6ahNMaZNh" +
           "CMLx43IJ02pxu0tR0bRtmks504gWnnD6kAyCtIw0kEpA4SgXb6m+OJvE20EL" +
           "XZFJdRaVXKypt7IqMjPhdktKSbTNVSojyc8IZVJiNn5lkrlEL5EEV5zQDaI9" +
           "QW2S25KW3WZmBFJpyFG86U1LOJ3SpSDkem0B1l0absXVRtcYGkF9JWNVTBq0" +
           "2ut4GiwGWn9Bt8Z6g4GThMyyLg4iDB4Z9HyIDYcEk5AmE2xpruNZrEm2WaRZ" +
           "1ZKphpBpEJJ6VcrkmbsmqwxOu0HNGS2DDPeMspzCsOoNgnoF7m+aKrIYinFb" +
           "nFvUqimTA4ck69PZ3Ntw6WZSK3UovN1z6yHjUAlcU2g3STwrM5osvexSSssO" +
           "22p/QbgYiPThehWs3UYDLWvzZVCbmWEPX1PgNGC9KYam5IAn12k/aaXcvMzC" +
           "2EQPUzFJSRNZNSna8hWZ1ZIKFlQrteG4N4f5mIdDBK/rtZoSY8FSTHmnqm7Q" +
           "rbnxYIsT8ZjZ2FQVL+N12NBhNlz2lhatSCarklN4jZnMdLpdIlgYmyqnWFGp" +
           "Q9Awpo7YcQXxNhuVzGLYasEcBygPKKFV2lY3bqolSBJXJsPEWa7dtrjSt7qW" +
           "JAG12oSqvszGPZU3A6BHGNlURIEs2RMia8iL0HXbTZceBDMimeF8ODXh7mg6" +
           "H2+oqhd1uKSfWmRXHbnNzGUb0yyU25w7SNEeX5Y2qslTsuBugroVKl5Z6fHc" +
           "2q0lJM9sK5VG2DBRvNdq0OYQtVmwKdVc0VOEziypMtzQdEyilVJ5XYdput3H" +
           "y/xwHRIG3a1su/3SRGopCjH03Fp9GI3HZbwh6ovxkkmI/sSWEU52MY1jwRFI" +
           "EQ24vO4aFcxbOMM1qdmRtFK7DX1YhhUEpjOsDnIZm0I43CODemlqIJwxgFkX" +
           "QciMGq+dfmTDJkuJpCnV3ekEniQxSbrbJSpqLohsuNhZNsS5ZG9DNSr5SIUv" +
           "WxNFEbGNqxpNpyFWFCVVVwNeITeLRc+y58PE6sDoNJkLLkOgGsylqYU7o1mv" +
           "Xd1W5CUx6/jZ1tqCg64xn7UbArrsWxRvJqVmqvljy/dbeH+ZBZyoBnx/u2b1" +
           "kpfFrsXoRDpzuxMZ6Qa1CiyPp5ow6bhbu9GZZ+NtzauHIpPAnW6qxJ1SjGOu" +
           "5U2XVi1mRrruzqaVXj2dJh0ej4cgE6hRkVTPGq5lzceT4YIbS56NNdN+NNEd" +
           "x/emAV5aDDcYoaQYC9RSH3elbmCZojHcUN2q0J47QiQzYZNP4WWTWimERTFS" +
           "ZpQzvo2yYVsOJL2/8EAkg7G0p5nDhOwuZ/iUNvrLIaFsHQJhwUMjbCOmyWE2" +
           "w6SIqQUVPSC5YT2z/KFhb0yzqaEbIVHpMZ6hScBZSk0Uh6RBu3BnVFa6VTYY" +
           "41Jprdf8dFLRtFSFq7bjVDneiOuzNR7PWdQYddWq0wxb01ky62V81ihXZQzz" +
           "NpQVGMQiaSzbPdlbz8l0JG6DcjhayPo41RdUc9ar2uWSVq05eJQNswhHUirk" +
           "O3FjLuADghgO7RiBJX+JGFutmlApSTIY5uMyJWtdrVdC5WErErb1/jBumsam" +
           "qdk4Ls9EfLo112wdbaUyBit93LFYyghxoUQqs6DanBqNLKqkg5kSm7WFSqmY" +
           "qePNxRzpw2kTaWOr5nSqKcg2rI/hNb0wpSZbZZ2wmvVMd4gQjdYCuJlJjQgi" +
           "LzM2r638ua+o9I4+D4GqJ58wXkOFk95+w70IuuAH1kaJikL28HYTzBRl8dVX" +
           "uMI9cc0F5VcVb7zTF6HimuJT73vhRY37dHnvoNZmQFV78KHuJJ4IunR8sX9Y" +
           "xz76SmU42PnhW74Y7r5yqZ9/8fLFh14U/7q4/z76EnU3C100Yts+edl0on/e" +
           "D3TDKoi8e3f15Bd/HwIF9WlCQKWZ/xWE/vIO7Fci6HUnwIB8D3ongZ6PoLMA" +
           "KO/+mn+bcn13iZaeuVnGR4q++mql7Am1PHXT/VbxCfZATP149xH2hvqFF5nB" +
           "u1+uf3p3367aSpblWC6y0IXd1f/RV40n7ojtENd5+ukf3vvFu998qOh7dwQf" +
           "m+oJ2t50+wvttuNHxRV09vsP/e7bf+vFbxa3B/8DwGxRvBsfAAA=");
    }
    private static class Sample {
        org.sunflow.core.Instance i;
        org.sunflow.core.Shader s;
        float nx;
        float ny;
        float nz;
        org.sunflow.image.Color c;
        org.sunflow.core.LightServer.Sample
          next;
        public Sample() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "O9WbpVYNkcfqqBrYzGa9WPJaJqmLUtCe9lRx3YUbUymtSci4VyazZilVMa6e" +
           "qZWqOovqVXWiLcjqymZ8EsfL22bsLyM/3i6bbHcrTyss6xmNpCRvaV9YiUuj" +
           "TWysxZIjiEpSb1aqi2Q8ZPkWP5bjVjpaso2WhLiZj9sklSnLcoyFZq+FCFql" +
           "5mOi3RpgGjgQR3QQwlSib8vN6piaVAW3tRHKDh7oUuTyOsHZZGWzImp4II5b" +
           "PBXVeDSezDetBrZYL9yabBpME3fXaUJqeBJRUnsWJ2jVs5pio8/Z3iaVk0WH" +
           "7bKwtRk27BZmaxW+1KuSCFGyN/y835oOZ3NiqPSDFbKhBm5lYMlYPcU9f+oP" +
           "53wzcZo0iyCbGJn2hik1RlNgynavRUp21U1Kpqw0pFAUu32KyIZ8fYLChueR" +
           "iIiuk6m8ole9Vqkm8ZRcEUeLKiI0RuMxr7USfu6XUkfRyq1Ix2irX24LUlSL" +
           "xCmSKurQDflZwNSTTa3cWJDdLK0rHddBFLyNxRzRV1V3AcNNRMbBodEKuIbE" +
           "CIKrWesFO+mLi8WojYQbwq11Rsg4y7gZMUFFqTZhjJLfCowytXSbrWY84Aay" +
           "VLWVaNVpjviWkCzXpWmMIZMKpgRJVqKWo5k0m65arcqWb9cso1sb0xwpGpNN" +
           "Y9rKJNfwq14w4yokhtcjasWQEUPN6iCscCxp7QSI1xgJ3TIcRWXbrPDsuLeo" +
           "j1GFh2NGTDVx7WpYy/C9KgxX+9VWaKbCGhEHsdXnVthwXCannmTANU43NUTR" +
           "MZOtGVUa6dIbs91Y4XY6rIlmuyZ1DXMcAz1oYx7OyJg75udpvzz2Ub8v4qWy" +
           "r8xIY+gJrYbJqGRjapuW2+fbq5HqWHHLNMY1coY2tlbZ8XU/GkUKSAQMmhuQ" +
           "wpafzytGu2sxjThltl0qUZFsKm69VETIWZ1lNkRnXMs61bK49Jg1rQ3jxlhc" +
           "hWKycmCkl3andmWCL+K2lTU3rlPqz2V2Ko4nPKbCUeZwaAgia2y6iM3yQG8j" +
           "sNTqe/WF4dALhQYnxQRnWCSrqL5n1qhmZeHxxIJT+YXQXK60Ulqv+jbiVIfE" +
           "Fi216vFkGraRbSkbVDe+EvtENVm1YhAKjNZdYGccRm4kOR01rYHtiM4oEXvY" +
           "wnfq43Xb66s+BQ+rzdmm1RaV1rws6IP+ZO468qitUFVNb47VPj5WK1tvra5N" +
           "Sq7rXTdZEMnQRWJstlnMgmhDNPFg0172rbjnx0wzNGaywvLZMI07VXxs4WMK" +
           "ZSth4lUasxIfKEQd5zVStOQV0q2NslrksHOS8qyxpMEeM13OK9VmYzNucKk2" +
           "BLlKnY6kEmeUVtI4g7czZFAqNzBtDRKbN785T3k+/vJSsfuLrPPw8hNkYHnH" +
           "+19GtnWb5HovhM67vh4LYfGt5r3JYdpepN5XoNtfUhz7kAvlH5Bee7v7zuLj" +
           "0aff89zz8ugzyN5+Pv9WkGHvX0Mfnwe07q6tDvLpR1/qigus+vBNd+G7+1vp" +
           "C89fuvDQ87O/Lm53Du9Y7+lDF9TINI9/Sj1WP+f6iqoXAO/ZfVh1i5/PgsT+" +
           "NBCQ8eY/BdDf2pF9PoRecYwMyHa/dpzoSyF0FyDKq7/t3uKzwe4TcXLmpHwP" +
           "N/nKnVLqY1vy1IkvjsU/F+yLaRDt/r3ghvTF53vDd7zY+MzuNkkyhaz4KnWh" +
           "D53fXWwd3tk9cdvZDuY61336R/d96Z7XH2zyfTvAR2p6DNvrbn1d07HcsLhg" +
           "yX7/od990288/63iK8b/ANn9iD71IQAA");
    }
    LightServer(org.sunflow.core.Scene scene) {
        super(
          );
        this.
          scene =
          scene;
        lights =
          (new org.sunflow.core.LightSource[0]);
        causticPhotonMap =
          null;
        shaderOverride =
          null;
        shaderOverridePhotons =
          false;
        causticPhotonMap =
          null;
        giEngine =
          null;
        shadingCache(
          0);
    }
    void setLights(org.sunflow.core.LightSource[] lights) {
        this.
          lights =
          lights;
    }
    void shadingCache(float shadingRate) {
        shadingCache =
          shadingRate >
            0
            ? (new org.sunflow.core.LightServer.CacheEntry[4096])
            : null;
        shadingCacheResolution =
          (float)
            (1 /
               java.lang.Math.
               sqrt(
                 shadingRate));
    }
    org.sunflow.core.Scene getScene() { return scene;
    }
    void setShaderOverride(org.sunflow.core.Shader shader,
                           boolean photonOverride) {
        shaderOverride =
          shader;
        shaderOverridePhotons =
          photonOverride;
    }
    boolean build(org.sunflow.core.Options options) {
        giEngine =
          org.sunflow.core.gi.GIEngineFactory.
            create(
              options);
        java.lang.String caustics =
          options.
          getString(
            "caustics",
            null);
        if (caustics ==
              null ||
              caustics.
              equals(
                "none"))
            causticPhotonMap =
              null;
        else
            if (caustics !=
                  null &&
                  caustics.
                  equals(
                    "kd"))
                causticPhotonMap =
                  new org.sunflow.core.photonmap.CausticPhotonMap(
                    options);
            else {
                org.sunflow.system.UI.
                  printWarning(
                    org.sunflow.system.UI.Module.
                      LIGHT,
                    "Unrecognized caustics photon map engine \"%s\" - ignoring",
                    caustics);
                causticPhotonMap =
                  null;
            }
        org.sunflow.system.Timer t =
          new org.sunflow.system.Timer(
          );
        t.
          start(
            );
        int numLightSamples =
          0;
        for (int i =
               0;
             i <
               lights.
                 length;
             i++)
            numLightSamples +=
              lights[i].
                getNumSamples(
                  );
        if (giEngine !=
              null) {
            if (!giEngine.
                  init(
                    scene))
                return false;
        }
        if (!calculatePhotons(
               causticPhotonMap,
               "caustic",
               0))
            return false;
        t.
          end(
            );
        cacheLookups =
          0;
        cacheHits =
          0;
        cacheEmptyEntryMisses =
          0;
        cacheWrongEntryMisses =
          0;
        cacheEntryAdditions =
          0;
        if (shadingCache !=
              null) {
            for (int i =
                   0;
                 i <
                   shadingCache.
                     length;
                 i++)
                shadingCache[i] =
                  null;
        }
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Light Server stats:");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Light sources found: %d",
            lights.
              length);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Light samples:       %d",
            numLightSamples);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Max raytrace depth:");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "      - Diffuse          %d",
            maxDiffuseDepth);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "      - Reflection       %d",
            maxReflectionDepth);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "      - Refraction       %d",
            maxRefractionDepth);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * GI engine            %s",
            options.
              getString(
                "gi.engine",
                "none"));
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Caustics:            %s",
            caustics ==
              null
              ? "none"
              : caustics);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Shader override:     %b",
            shaderOverride);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Photon override:     %b",
            shaderOverridePhotons);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Shading cache:       %s",
            shadingCache ==
              null
              ? "off"
              : "on");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Build time:          %s",
            t.
              toString(
                ));
        return true;
    }
    void showStats() { if (shadingCache ==
                             null) return;
                       int numUsedEntries =
                         0;
                       for (org.sunflow.core.LightServer.CacheEntry e
                             :
                             shadingCache)
                           numUsedEntries +=
                             e !=
                               null
                               ? 1
                               : 0;
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "Shading cache stats:");
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Used entries:        %d (%d%%)",
                           numUsedEntries,
                           100 *
                             numUsedEntries /
                             shadingCache.
                               length);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Lookups:             %d",
                           cacheLookups);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Hits:                %d",
                           cacheHits);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Hit rate:            %d%%",
                           100 *
                             cacheHits /
                             cacheLookups);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Empty entry misses:  %d",
                           cacheEmptyEntryMisses);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Wrong entry misses:  %d",
                           cacheWrongEntryMisses);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Entry adds:          %d",
                           cacheEntryAdditions);
    }
    boolean calculatePhotons(final org.sunflow.core.PhotonStore map,
                             java.lang.String type,
                             final int seed) {
        if (map ==
              null)
            return true;
        if (lights.
              length ==
              0) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  LIGHT,
                "Unable to trace %s photons, no lights in scene",
                type);
            return false;
        }
        final float[] histogram =
          new float[lights.
                      length];
        histogram[0] =
          lights[0].
            getPower(
              );
        for (int i =
               1;
             i <
               lights.
                 length;
             i++)
            histogram[i] =
              histogram[i -
                          1] +
                lights[i].
                getPower(
                  );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Tracing %s photons ...",
            type);
        int numEmittedPhotons =
          map.
          numEmit(
            );
        if (numEmittedPhotons <=
              0 ||
              histogram[histogram.
                          length -
                          1] <=
              0) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  LIGHT,
                "Photon mapping enabled, but no %s photons to emit",
                type);
            return false;
        }
        map.
          prepare(
            scene.
              getBounds(
                ));
        org.sunflow.system.UI.
          taskStart(
            "Tracing " +
            type +
            " photons",
            0,
            numEmittedPhotons);
        java.lang.Thread[] photonThreads =
          new java.lang.Thread[scene.
                                 getThreads(
                                   )];
        final float scale =
          1.0F /
          numEmittedPhotons;
        int delta =
          numEmittedPhotons /
          photonThreads.
            length;
        photonCounter =
          0;
        org.sunflow.system.Timer photonTimer =
          new org.sunflow.system.Timer(
          );
        photonTimer.
          start(
            );
        for (int i =
               0;
             i <
               photonThreads.
                 length;
             i++) {
            final int threadID =
              i;
            final int start =
              threadID *
              delta;
            final int end =
              threadID ==
              photonThreads.
                length -
              1
              ? numEmittedPhotons
              : (threadID +
                   1) *
              delta;
            photonThreads[i] =
              new java.lang.Thread(
                new java.lang.Runnable(
                  ) {
                    public void run() {
                        org.sunflow.core.IntersectionState istate =
                          new org.sunflow.core.IntersectionState(
                          );
                        for (int i =
                               start;
                             i <
                               end;
                             i++) {
                            synchronized (LightServer.this)  {
                                org.sunflow.system.UI.
                                  taskUpdate(
                                    photonCounter);
                                photonCounter++;
                                if (org.sunflow.system.UI.
                                      taskCanceled(
                                        ))
                                    return;
                            }
                            int qmcI =
                              i +
                              seed;
                            double rand =
                              org.sunflow.math.QMC.
                              halton(
                                0,
                                qmcI) *
                              histogram[histogram.
                                          length -
                                          1];
                            int j =
                              0;
                            while (rand >=
                                     histogram[j] &&
                                     j <
                                     histogram.
                                       length)
                                j++;
                            if (j ==
                                  histogram.
                                    length)
                                continue;
                            double randX1 =
                              j ==
                              0
                              ? rand /
                              histogram[0]
                              : (rand -
                                   histogram[j]) /
                              (histogram[j] -
                                 histogram[j -
                                             1]);
                            double randY1 =
                              org.sunflow.math.QMC.
                              halton(
                                1,
                                qmcI);
                            double randX2 =
                              org.sunflow.math.QMC.
                              halton(
                                2,
                                qmcI);
                            double randY2 =
                              org.sunflow.math.QMC.
                              halton(
                                3,
                                qmcI);
                            org.sunflow.math.Point3 pt =
                              new org.sunflow.math.Point3(
                              );
                            org.sunflow.math.Vector3 dir =
                              new org.sunflow.math.Vector3(
                              );
                            org.sunflow.image.Color power =
                              new org.sunflow.image.Color(
                              );
                            lights[j].
                              getPhoton(
                                randX1,
                                randY1,
                                randX2,
                                randY2,
                                pt,
                                dir,
                                power);
                            power.
                              mul(
                                scale);
                            org.sunflow.core.Ray r =
                              new org.sunflow.core.Ray(
                              pt,
                              dir);
                            scene.
                              trace(
                                r,
                                istate);
                            if (istate.
                                  hit(
                                    ))
                                shadePhoton(
                                  org.sunflow.core.ShadingState.
                                    createPhotonState(
                                      r,
                                      istate,
                                      qmcI,
                                      map,
                                      LightServer.this),
                                  power);
                        }
                    }
                });
            photonThreads[i].
              setPriority(
                scene.
                  getThreadPriority(
                    ));
            photonThreads[i].
              start(
                );
        }
        for (int i =
               0;
             i <
               photonThreads.
                 length;
             i++) {
            try {
                photonThreads[i].
                  join(
                    );
            }
            catch (java.lang.InterruptedException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      LIGHT,
                    "Photon thread %d of %d was interrupted",
                    i +
                      1,
                    photonThreads.
                      length);
                return false;
            }
        }
        if (org.sunflow.system.UI.
              taskCanceled(
                )) {
            org.sunflow.system.UI.
              taskStop(
                );
            return false;
        }
        photonTimer.
          end(
            );
        org.sunflow.system.UI.
          taskStop(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Tracing time for %s photons: %s",
            type,
            photonTimer.
              toString(
                ));
        map.
          init(
            );
        return true;
    }
    void shadePhoton(org.sunflow.core.ShadingState state,
                     org.sunflow.image.Color power) {
        state.
          getInstance(
            ).
          prepareShadingState(
            state);
        org.sunflow.core.Shader shader =
          getPhotonShader(
            state);
        if (shader !=
              null)
            shader.
              scatterPhoton(
                state,
                power);
    }
    void traceDiffusePhoton(org.sunflow.core.ShadingState previous,
                            org.sunflow.core.Ray r,
                            org.sunflow.image.Color power) {
        if (previous.
              getDiffuseDepth(
                ) >=
              maxDiffuseDepth)
            return;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        if (previous.
              getIntersectionState(
                ).
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createDiffuseBounceState(
                previous,
                r,
                0);
            shadePhoton(
              state,
              power);
        }
    }
    void traceReflectionPhoton(org.sunflow.core.ShadingState previous,
                               org.sunflow.core.Ray r,
                               org.sunflow.image.Color power) {
        if (previous.
              getReflectionDepth(
                ) >=
              maxReflectionDepth)
            return;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        if (previous.
              getIntersectionState(
                ).
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createReflectionBounceState(
                previous,
                r,
                0);
            shadePhoton(
              state,
              power);
        }
    }
    void traceRefractionPhoton(org.sunflow.core.ShadingState previous,
                               org.sunflow.core.Ray r,
                               org.sunflow.image.Color power) {
        if (previous.
              getRefractionDepth(
                ) >=
              maxRefractionDepth)
            return;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        if (previous.
              getIntersectionState(
                ).
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createRefractionBounceState(
                previous,
                r,
                0);
            shadePhoton(
              state,
              power);
        }
    }
    private org.sunflow.core.Shader getShader(org.sunflow.core.ShadingState state) {
        return shaderOverride !=
          null
          ? shaderOverride
          : state.
          getShader(
            );
    }
    private org.sunflow.core.Shader getPhotonShader(org.sunflow.core.ShadingState state) {
        return shaderOverride !=
          null &&
          shaderOverridePhotons
          ? shaderOverride
          : state.
          getShader(
            );
    }
    org.sunflow.core.ShadingState getRadiance(float rx,
                                              float ry,
                                              int i,
                                              org.sunflow.core.Ray r,
                                              org.sunflow.core.IntersectionState istate) {
        scene.
          trace(
            r,
            istate);
        if (istate.
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createState(
                istate,
                rx,
                ry,
                r,
                i,
                this);
            state.
              getInstance(
                ).
              prepareShadingState(
                state);
            org.sunflow.core.Shader shader =
              getShader(
                state);
            if (shader ==
                  null) {
                state.
                  setResult(
                    org.sunflow.image.Color.
                      BLACK);
                return state;
            }
            if (shadingCache !=
                  null) {
                org.sunflow.image.Color c =
                  lookupShadingCache(
                    state,
                    shader);
                if (c !=
                      null) {
                    state.
                      setResult(
                        c);
                    return state;
                }
            }
            state.
              setResult(
                shader.
                  getRadiance(
                    state));
            if (shadingCache !=
                  null)
                addShadingCache(
                  state,
                  shader,
                  state.
                    getResult(
                      ));
            return state;
        }
        else
            return null;
    }
    void shadeBakeResult(org.sunflow.core.ShadingState state) {
        org.sunflow.core.Shader shader =
          getShader(
            state);
        if (shader !=
              null)
            state.
              setResult(
                shader.
                  getRadiance(
                    state));
        else
            state.
              setResult(
                org.sunflow.image.Color.
                  BLACK);
    }
    org.sunflow.image.Color shadeHit(org.sunflow.core.ShadingState state) {
        state.
          getInstance(
            ).
          prepareShadingState(
            state);
        org.sunflow.core.Shader shader =
          getShader(
            state);
        return shader !=
          null
          ? shader.
          getRadiance(
            state)
          : org.sunflow.image.Color.
              BLACK;
    }
    private static final int hash(int x, int y) {
        return x ^
          y;
    }
    private synchronized org.sunflow.image.Color lookupShadingCache(org.sunflow.core.ShadingState state,
                                                                    org.sunflow.core.Shader shader) {
        if (state.
              getNormal(
                ) ==
              null)
            return null;
        cacheLookups++;
        int cx =
          (int)
            (state.
               getRasterX(
                 ) *
               shadingCacheResolution);
        int cy =
          (int)
            (state.
               getRasterY(
                 ) *
               shadingCacheResolution);
        int hash =
          hash(
            cx,
            cy);
        org.sunflow.core.LightServer.CacheEntry e =
          shadingCache[hash &
                         shadingCache.
                           length -
                         1];
        if (e ==
              null) {
            cacheEmptyEntryMisses++;
            return null;
        }
        if (e.
              cx ==
              cx &&
              e.
                cy ==
              cy) {
            for (org.sunflow.core.LightServer.Sample s =
                   e.
                     first;
                 s !=
                   null;
                 s =
                   s.
                     next) {
                if (s.
                      i !=
                      state.
                      getInstance(
                        ))
                    continue;
                if (s.
                      s !=
                      shader)
                    continue;
                if (state.
                      getNormal(
                        ).
                      dot(
                        s.
                          nx,
                        s.
                          ny,
                        s.
                          nz) <
                      0.95F)
                    continue;
                cacheHits++;
                return s.
                         c;
            }
        }
        else
            cacheWrongEntryMisses++;
        return null;
    }
    private synchronized void addShadingCache(org.sunflow.core.ShadingState state,
                                              org.sunflow.core.Shader shader,
                                              org.sunflow.image.Color c) {
        if (state.
              getNormal(
                ) ==
              null)
            return;
        cacheEntryAdditions++;
        int cx =
          (int)
            (state.
               getRasterX(
                 ) *
               shadingCacheResolution);
        int cy =
          (int)
            (state.
               getRasterY(
                 ) *
               shadingCacheResolution);
        int h =
          hash(
            cx,
            cy) &
          shadingCache.
            length -
          1;
        org.sunflow.core.LightServer.CacheEntry e =
          shadingCache[h];
        if (e ==
              null)
            e =
              (shadingCache[h] =
                 new org.sunflow.core.LightServer.CacheEntry(
                   ));
        org.sunflow.core.LightServer.Sample s =
          new org.sunflow.core.LightServer.Sample(
          );
        s.
          i =
          state.
            getInstance(
              );
        s.
          s =
          shader;
        s.
          c =
          c;
        s.
          nx =
          state.
            getNormal(
              ).
            x;
        s.
          ny =
          state.
            getNormal(
              ).
            y;
        s.
          nz =
          state.
            getNormal(
              ).
            z;
        if (e.
              cx ==
              cx &&
              e.
                cy ==
              cy) {
            s.
              next =
              e.
                first;
            e.
              first =
              s;
        }
        else {
            e.
              cx =
              cx;
            e.
              cy =
              cy;
            s.
              next =
              null;
            e.
              first =
              s;
        }
    }
    org.sunflow.image.Color traceGlossy(org.sunflow.core.ShadingState previous,
                                        org.sunflow.core.Ray r,
                                        int i) {
        if (previous.
              getReflectionDepth(
                ) >=
              maxReflectionDepth ||
              previous.
              getDiffuseDepth(
                ) >
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? shadeHit(
              org.sunflow.core.ShadingState.
                createGlossyBounceState(
                  previous,
                  r,
                  i))
          : org.sunflow.image.Color.
              BLACK;
    }
    org.sunflow.image.Color traceReflection(org.sunflow.core.ShadingState previous,
                                            org.sunflow.core.Ray r,
                                            int i) {
        if (previous.
              getReflectionDepth(
                ) >=
              maxReflectionDepth ||
              previous.
              getDiffuseDepth(
                ) >
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? shadeHit(
              org.sunflow.core.ShadingState.
                createReflectionBounceState(
                  previous,
                  r,
                  i))
          : org.sunflow.image.Color.
              BLACK;
    }
    org.sunflow.image.Color traceRefraction(org.sunflow.core.ShadingState previous,
                                            org.sunflow.core.Ray r,
                                            int i) {
        if (previous.
              getRefractionDepth(
                ) >=
              maxRefractionDepth ||
              previous.
              getDiffuseDepth(
                ) >
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? shadeHit(
              org.sunflow.core.ShadingState.
                createRefractionBounceState(
                  previous,
                  r,
                  i))
          : org.sunflow.image.Color.
              BLACK;
    }
    org.sunflow.core.ShadingState traceFinalGather(org.sunflow.core.ShadingState previous,
                                                   org.sunflow.core.Ray r,
                                                   int i) {
        if (previous.
              getDiffuseDepth(
                ) >=
              maxDiffuseDepth)
            return null;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? org.sunflow.core.ShadingState.
          createFinalGatherState(
            previous,
            r,
            i)
          : null;
    }
    org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        if (giEngine ==
              null)
            return org.sunflow.image.Color.
                     BLACK;
        return giEngine.
          getGlobalRadiance(
            state);
    }
    org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                          org.sunflow.image.Color diffuseReflectance) {
        if (giEngine ==
              null ||
              state.
              getDiffuseDepth(
                ) >=
              maxDiffuseDepth)
            return org.sunflow.image.Color.
                     BLACK;
        return giEngine.
          getIrradiance(
            state,
            diffuseReflectance);
    }
    void initLightSamples(org.sunflow.core.ShadingState state) {
        for (org.sunflow.core.LightSource l
              :
              lights)
            l.
              getSamples(
                state);
    }
    void initCausticSamples(org.sunflow.core.ShadingState state) {
        if (causticPhotonMap !=
              null)
            causticPhotonMap.
              getSamples(
                state);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Gf1ajPWdMWOTaxgSlRVstNEuFWKatKBa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "1PHfda+PnHoSldd84mjhe1h46qI3fPIVfZ/4wEdf1QY/jhzunjmrceGe2A++" +
       "ydGXunOqqzdun4Ifw7j96CkdtYNB7T8QOyF6RmSFc5epHZw8KWOzCgdvv/jZ" +
       "+ME7suJFADZ79Wa7ZHZxzsPdpW9px8I+eMtrPdY5fZWLCPd2hHu3kvDv5aSI" +
       "SwhnT5wOKntLMLJj1074oVfgd292MFu6PNzxG16Z32n4l52jsuJd2VodPeaO" +
       "V2Sf0HrNxdivpbYa2MY7WuMr0zq1YiR7FFn4BzkJ9hKCXFbQICQAY+WuW/K3" +
       "p0DmCkzzR9TZjrhjKt4qAz16HvzEmXU7gyB/uJ6T/NZLBJCtujmYxoU7lMRy" +
       "tFxoJ6TFq6r39WD7gR3pH7ilVju/5JybFUYWgWb+Knt3NdpTpnlVZb4JbD+6" +
       "4/WjV+Z123a0OlLm2VXw20V8XAz2F0cjVf4C4MHqEjG8NyvCfNGgoyaOHB8t" +
       "Y93TcnRVLaNg+6udNP7qVjnxkTSeOnelMAizmWLPX09subKpZy94+WEuiA9e" +
       "IqTvy4r3xYVvyBf8bgW0Zy3vv6p8WsBTD7Ztt/9vhbVkyL77iP7rzwhpJK+z" +
       "Gh/KSX7sEgH8UFZ8JC48Eoeyqu9WDp8rhx+4qhw6gP8uNzrYz42uJoes+PgJ" +
       "3x+7hO+PZ8WrMZBaxvdkMfK5lP/JraC8W9Z9cGZZ962k/KlLKP/LrPjJU5R3" +
       "65vPpfwvrkD5ddlBEBsPdgsED84sELyE8umFWBemYwffnTP6hUvYfiYrfhZE" +
       "f/NoSM9qve+E4c9dleFzAMtutdnBmdVmt4jh5y9h+KtZ8Ytx4UHAcDc0nMfz" +
       "l67A8+EjTV7b8bx2ZeO9Iz93R/bz946LPP34+FEYe+5MGMtXrUdbD80Dfi6A" +
       "375EOL+bFV8AAR0IZwQGiuw9npNYmQvmN67q1e8AAtnNrg5u5exqp/s/uoRe" +
       "th7u4L8C3efjVV2eZ2t+Eyfe8+LfvwXzjYPBjuLg1lP88iUU/ywrvgQmHTnF" +
       "tpVz+9AJt9dcYHsJt6eyg88CKJMdt8lNcMvvJzQXe/cTzk9fjox7l6f91SV8" +
       "v5YV/xtMiWdytH3d5ITrn1+Ba/52BgI4vmfH9T03wTUn0MwmtWtPnYW+Z210" +
       "7TUI54NS4X1ZrcM7LyZ8mEnvMHv318kXf3N70+YTVR8eXIF+PtyCmdbBKzv6" +
       "r9w0/QzC7TcyEufTze1IfPjIJcxfnxX3A++VNW2f9on3Hj5wVe99FNB9dUf7" +
       "1St773lpx9auD5++hOwzWfEGEInztINy/Cha7+n3yasSBUo++Ikd0Z/4uyR6" +
       "yR2vw+yO1+GLQKt7KeUe2avc4zom++kd2U//XZKtXkIWzwrkFNldMrlHtnTV" +
       "5CML0j+/I/vzf5dk65eQzSPAO8EUOifbyl4dp+R4lqdapzKKw2+5qmrfCFh+" +
       "bsf2c1dmuz/cHvYv4TjMik5ceBgkTMBJFdk5nTadUmn3qiQfB5g+vyP5+SuT" +
       "3Bt3dtFXuoTpe7JiEhfuB0w7YXg+S/6qySE4f/CFHcsv3HpVGpcQzLKHQxmY" +
       "q+VZ23vvnOwG2zf1T48vylU5QgDSb+84/vat5xhewjHLBg9dkDxkHHcvuZ7P" +
       "0rsZlikYp06965h90ueJM5/J237aTf3pVx+8+/FXJ7+7/UrH0efX7qELdxuJ" +
       "45z+xMqp/TuDUDesnP89eflAkPN5L1DX/rQH5ILZvwzk4WZb7TsBvlPV4sJd" +
       "u73Tld4fF24DlbLdDxy/GnzqzZ3tp2PS7W3jJ07rNxNY4ZHXEtipZ1fPX/ct" +
       "h/y7g0ffXUi2Xx58Wf3Uq93+e79a/fHt96ZUR95ssl7upgt3bT99lXeafbvh" +
       "2Qt7O+rrzvbbvvbAp+958ehp2ANbwCe2dgrbm8//ylP+8l72XabNv3n8X3/z" +
       "T7z6B/mrS/8fzyXV0BBSAAA=");
}
