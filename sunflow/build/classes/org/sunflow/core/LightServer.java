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
        public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYf2xbRx0/O4nzo2njJE2adWnWpi6QNvXb1v3QSBlrvYQ4" +
                                                                  "cxOr6YJwoO75+Ry/9vm91/fOiZMRaCehBiSqIrKuoC1/ddpUbeuEmECCTUEI" +
                                                                  "GNpA2g8YA7EBQqJoVKwgBlqB8b27Z78fjjPtDyL5cr773n1/f77f85NXUYNl" +
                                                                  "oj6i0SidN4gVHdZoEpsWycZUbFlHYC0tP1yH/370yvhdQRRKoU15bB2SsUVG" +
                                                                  "FKJmrRTapmgWxZpMrHFCsuxE0iQWMWcxVXQthboUK14wVEVW6CE9SxjBFDYT" +
                                                                  "qB1TaiqZIiVx+wKKtiVAEolLIh3wbw8lUKusG/MOeY+LPObaYZQFh5dFUThx" +
                                                                  "HM9iqUgVVUooFh0qmWiPoavzM6pOo6REo8fV220TjCVurzJB/zNt714/lw9z" +
                                                                  "E3RiTdMpV886TCxdnSXZBGpzVodVUrBOoi+gugTa4CKmKJIoM5WAqQRMy9o6" +
                                                                  "VCD9RqIVCzGdq0PLN4UMmQlE0Q7vJQY2ccG+JsllhhuaqK07Pwzabq9oK7Ss" +
                                                                  "UvGhPdLyw0fD36pDbSnUpmiTTBwZhKDAJAUGJYUMMa0D2SzJplC7Bs6eJKaC" +
                                                                  "VWXB9nSHpcxomBbB/WWzsMWiQUzO07EV+BF0M4sy1c2KejkeUPa3hpyKZ0DX" +
                                                                  "bkdXoeEIWwcFWxQQzMxhiDv7SP0JRctSdJP/REXHyH1AAEcbC4Tm9Qqreg3D" +
                                                                  "AuoQIaJibUaahNDTZoC0QYcANCnaWvNSZmsDyyfwDEmziPTRJcUWUDVzQ7Aj" +
                                                                  "FHX5yfhN4KWtPi+5/HN1fP/ZB7RRLYgCIHOWyCqTfwMc6vMdOkxyxCSQB+Jg" +
                                                                  "6+7Eedz93FIQISDu8hELmu98/to9g32rLwiaG9egmcgcJzJNyxczm17ujQ3c" +
                                                                  "VcfEaDJ0S2HO92jOsyxp7wyVDECY7sqNbDNa3lw9/OPPnLpE3g6iljgKybpa" +
                                                                  "LEActct6wVBUYn6KaMTElGTjqJlo2Rjfj6NGmCcUjYjViVzOIjSO6lW+FNL5" +
                                                                  "dzBRDq5gJmqBuaLl9PLcwDTP5yUDIdQJH9QDnz1I/PH/FH1ayusFImEZa4qm" +
                                                                  "S0lTZ/ozh2pZLFFiwTwLu4YuWUUtp+pzkmXKkm7OVL7LukkAbWbyFBJllphR" +
                                                                  "FmDG/+/qEtOqcy4QAIP3+tNdhUwZ1dUsMdPycvHg8LWn0y+KUGLhb9uDoo8C" +
                                                                  "l6jNJcq4RF1cIjEs5wmUCHMeBQKcz2bGWDgVXHICkhvQtXVg8nNjx5b66yCa" +
                                                                  "jLl6sCcj7fdUmZiDAGXYTst/G/v9vtHFj78aREEAiQxUGQfst7vAnlUpU5dJ" +
                                                                  "FrCmFuiXgU+qDfNryoBWL8ydnvrizVwGN3qzCxsAeNjxJMPcCouIP2vXurft" +
                                                                  "zJV3L59f1J389ZSDchWrOslgod/vTb/yaXn3dvxs+rnFSBDVA9YAvlIM+QDQ" +
                                                                  "1efn4YGHoTLUMl2aQOGcbhawyrbK+NhC86Y+56zwMGtnQ5eIOBYGPgE5Sn9i" +
                                                                  "0nj0Vz//8z5uyTKgt7kq8SShQy4QYZd1cLhod6LqiEkI0P32QvLrD109M81D" +
                                                                  "Cih2rsUwwsYYgAd4Byz4pRdOvvHWmxdfCzphSFGjYSrQmpASV2bz+/AXgM9/" +
                                                                  "2YdlPlsQCNARs2FoewWHDMb6I45wgEgqpC6Ljsj9GkSfklNwRiUsCf7dtuuW" +
                                                                  "Z/9yNiz8rcJKOVwGP/gCZ/2Gg+jUi0f/2cevCcisIjoGdMgEzHY6Nx8wTTzP" +
                                                                  "5CidfmXbN36CHwXABpC0lAXCcQ9xgyDuwdu4LSQ+7vPt3cGGiOUOcm8euTqX" +
                                                                  "tHzutXc2Tr3z/DUurbf1cTv+EDaGRBgJLwCzCLIHDw6z3W6DjVtKIMMWP9qM" +
                                                                  "YisPl922Ov7ZsLp6HdimgK0MTYE1YQLWlTyxZFM3NP76Bz/sPvZyHQqOoBZV" +
                                                                  "x9kRzDMONUOoEysPMFkyPnmPkGOuCYYwtweqshAz+k1ru3O4YFDugIXvbvn2" +
                                                                  "/sdX3uRhKMLuRn68juG0BxR5T+3k9KVX7/zF4187Pyeq8kBtIPOd63lvQs08" +
                                                                  "+Id/VXmBQ9gaHYPvfEp68pGtsbvf5ucdLGGnd5aqawugrXP21kuFfwT7Qz8K" +
                                                                  "osYUCst2DzuF1SJL4xT0bVa5sYU+17Pv7cFEwzFUwcpeP4652PpRzKlpMGfU" +
                                                                  "bL7RF3HMr7z8D9oRN+iPuADik1F+ZBcfP8aGPbb3vVc1rXMVRUG55K2B7DE0" +
                                                                  "WcxYUMmUAuDfrN2u3Zo8Ji9Fkn8UTr9hjQOCrusJ6atTrx9/iaNrE6uVR8qK" +
                                                                  "uirhAXPGhdphNuxlgqwTTD55pMWOt048cuUpIY8/cnzEZGn5K+9Hzy4L0BMN" +
                                                                  "+c6qnth9RjTlPul2rMeFnxj50+XF7z2xeEZI1eFtL4fh9fTUL//zUvTC7366" +
                                                                  "Ro9Tp9iPKpbJgUp/stlraqHQvV9u+/65jroRKKtx1FTUlJNFEs96I6zRKmZc" +
                                                                  "tncafSfqbNVYcaEosNsw7MrJxjvZEBfBNFQTdQ5++LhNs2GMhd48myV9LI99" +
                                                                  "SJZd8Nlrs9xbg6V4VO1iw33V2VHrNIXsVeCZzk/0QMSs24RO4oIhOnuXMmQd" +
                                                                  "ZUpr52+QTQcpCln8petkM0/ujnVKkQvDEQvXbbVebTxULz64vJKdeOyWoF1R" +
                                                                  "p4Cl/Zh230NRi9Nely3Ru54lgHNP1atevETlp1famras3P86bwcrr8VWQIpc" +
                                                                  "UVXd8OiahwyT5BQuZKsASxGnCxSF/YJQVM/+cUHnBdkiRRtcZJQlBp+5iU5B" +
                                                                  "/gERm542ymqGeQllsB8VsF8KeG1c8XPXBwWtyy07PRjHfyYp53dR/FCSli+v" +
                                                                  "jI0/cO2Ox0SPKqt4YYE/qyGrRSdcafJ31LytfFdodOD6pmead5Ud7emR3bKx" +
                                                                  "Ocgf4O3kVl/PZkUqrdsbF/c//7Ol0CuAYdMogCnqnK4ukCWjCBE4nahGLyiQ" +
                                                                  "vJkcGvjm/N2Dub/+hncgNtr11qZPy83vnV3YYQWiQdQcRw0Qw6TEK/e989ph" +
                                                                  "Is+aHigMZfSiVvk1ZROLNcx+PuFWsY25sbLKni4U9VfXhOrnHLRmc8Q8yG63" +
                                                                  "odUdrC1Fw3DvcqumBM4yK0OcpROHDMNu6AM3c6sbBk/hZTZM/w8VTnIc/xQA" +
                                                                  "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "A8Z4qeURHwAA");
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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nafv82zI/A8qzYwspBcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVaeezkVn33/pI9soTsZgNJSEPIsbSEQes57PFYCy32jMdj" +
           "z2F7DnvGUBaPj7Fn7PF9zNCUqwUEEkVqoFSC/AVqi7haFbVSRZuqaksFqkSF" +
           "ekkFVFUqFUUif5RWTVv67Pndu5ttVPGT/Ob5Hd/3+Z7v+/x+n/8BdDYMoJLn" +
           "2puF7UbX9Cy6trTRa9HG08NrbA/llSDUtaathOEYtN1Qn/zypR+9+DHz8h50" +
           "ToYeUNZrN1Iiy12HQz107UTXetClo1bK1p0wgi73lkqiwHFk2XDPCqPrPegV" +
           "x6ZG0NXeAQQYQIABBLiAABNHo8CkV+rr2GnmM5R1FPrQL0JnetA5T83hRdAT" +
           "J4l4SqA4+2T4ggNA4UL+LgKmislZAD1+yPuO55sY/ngJfvbX3nH5d+6CLsnQ" +
           "JWs9yuGoAEQEFpGhex3dmetBSGiarsnQ/Wtd10Z6YCm2tS1wy9CV0FqslSgO" +
           "9EMh5Y2xpwfFmkeSu1fNeQtiNXKDQ/YMS7e1g7ezhq0sAK8PHvG647CdtwMG" +
           "L1oAWGAoqn4w5e6VtdYi6HWnZxzyeLULBoCp5x09Mt3Dpe5eK6ABurLTna2s" +
           "F/AoCqz1Agw968ZglQh65LZEc1l7irpSFvqNCHr49Dh+1wVG3VMIIp8SQa8+" +
           "PaygBLT0yCktHdPPDwZv/ui71p31XoFZ01U7x38BTHrs1KShbuiBvlb13cR7" +
           "39j7hPLgVz+0B0Fg8KtPDd6N+b1feOGtb3rs+a/txvzULcZw86WuRjfUz8zv" +
           "++ajzafxu3IYFzw3tHLln+C8MH9+v+d65gHPe/CQYt557aDz+eGfzd7zOf37" +
           "e9BFBjqnunbsADu6X3Udz7L1gNbXeqBEusZA9+hrrVn0M9B5UO9Za33XyhlG" +
           "qEcMdLddNJ1zi3cgIgOQyEV0HtStteEe1D0lMot65kEQ9AB4oIfBU4Z2f8Vv" +
           "BEmw6To6rKjK2lq7MB+4Of+5QteaAkd6COoa6PVcOIzXhu2mcBiosBssDt9V" +
           "N9BBGFiYEXCURA+u5Qbm/eRIZzlXl9MzZ4DAHz3t7jbwlI5ra3pwQ302JqkX" +
           "vnjj63uH5r8vjwh6CqxybX+Va/kq146tcnWkOJ6tQ2fOFGu8Kl90p1CgjhVw" +
           "bBDy7n169PPsOz/05F3Akrz0biDLfCh8+8jbPAoFTBHwVGCP0POfTN8rvru8" +
           "B+2dDKE5UNB0MZ/O54HvMMBdPe06t6J76YPf+9GXPvGMe+REJ2Lyvm/fPDP3" +
           "zSdPizRwVV0D0e6I/BsfV75y46vPXN2D7gYOD4JcpACjBPHjsdNrnPDR6wfx" +
           "LuflLGDYcANHsfOugyB1MTIDNz1qKXR9X1G/H8j4cWi/OGHFee8DXl6+amcb" +
           "udJOcVHE07eMvE//7V/+S60Q90HovXRsMxvp0fVj7p4Tu1Q49v1HNjAOdB2M" +
           "+4dP8r/68R988G2FAYART91qwat52QRuDlQIxPzLX/P/7jvf/sy39o6MJgL7" +
           "XTy3LTXbMflj8HcGPP+TPzlzecPOVa809+PF44cBw8tX/ukjbCB02MDHcgu6" +
           "Olk7rmYZljK39dxi/+vS6ytf+dePXt7ZhA1aDkzqTXcmcNT+GhJ6z9ff8e+P" +
           "FWTOqPnWdSS/o2G7ePjAEWUiCJRNjiN771+99tf/XPk0iKwgmoXWVi8CFFTI" +
           "AyoUWC5kUSpK+FRfNS9eFx53hJO+dizFuKF+7Fs/fKX4wz98oUB7Mkc5rve+" +
           "4l3fmVpePJ4B8g+d9vqOEppgHPL84O2X7edfBBRlQFEFG3PIBSDeZCesZH/0" +
           "2fN//8d/8uA7v3kXtNeGLtquorWVwuGge4Cl66EJQlXm/dxbd9acXgDF5YJV" +
           "6CbmdwbycPF2EQB8+vaxpp2nGEfu+vB/cvb8ff/4HzcJoYgyt9hZT82X4c9/" +
           "6pHmz36/mH/k7vnsx7KbYzBIx47mVj/n/Nvek+f+dA86L0OX1f1cT1TsOHci" +
           "GeQ34UECCPLBE/0nc5Xdxnz9MJw9ejrUHFv2dKA5iv2gno/O6xdPxZZc9sU2" +
           "WdmPLZXTseUMVFTeWkx5oiiv5sXPHDPPpyPojFV0vTqCXnPTLnOAcBem8rKW" +
           "F8ROufXbGsL1kzDzSnUfZvU2MJk7wQwPYD50E8yRqWg7BR8Dyb5MkK8BD7IP" +
           "ErkNyOEdQO6ts5c2dT6wHBCrk/0kEH7myndWn/reF3YJ3mm7PjVY/9CzH/7x" +
           "tY8+u3csrX7qpsz2+Jxdal2Ae2WBMEf3xEutUsxo//OXnvmD33zmgztUV04m" +
           "iRQ4A33hr//7G9c++d2/uEWmAgzZVaJTqhj9BFSh3FEVm7wmn4Iy/wlAMe8I" +
           "ZXsrKNbLhJJ3oftQ0NtAce/kReotvchywGko303d017kvUyQrwJPfR9k/TYg" +
           "szuAvHsN/KbAcQrM5o5gdlZ+BuQpZ6vXsGvl/P3dt17urrz6BpDQhMWROjdd" +
           "a63YByAeWtrq1YMURgRHbLADXV3a2IH8LhebZx7rr+3OpaewPv1/xgp88r4j" +
           "Yj0XHHE/8k8f+8avPPUd4F8sdDbJdxfgiMdWHMT5qf8Dn//4a1/x7Hc/UuRn" +
           "IDnjX9z+0Rtyqh9+KY7z4v158UsHrD6Sszpy40DVe0oY9Ys0StcOuZWO8fM2" +
           "oB7b/X9wG937fAcJGeLgryfO9GqqDjPH4LCGxtaw9rI+5OrRgktXDuLDnG+t" +
           "Bh4SBUjZjaKSyCyxljKN52W0tpGxGE3AWTMJKwNSElttZkjRiCK6lfbK8qSV" +
           "GE3qbYmhqIBJhUk0alUIZbKQViRDshJDroZkS2yWHM3BDW2jjeA64w1rPDZN" +
           "tzU4qRnzAT8tU6LnUlUKleg6m3HbQXMxCvV0JvdWC4YdNLbNhlWOeZuj4Q62" +
           "aqh2KIiTuqVJdtjxuuloJq9cazwYzYesuKp2xZkzYxBhVZ0h2QJdUk6/PalE" +
           "Q7bS7M5Xs028Ydl+q2qz6WLhhGS7vZTNkVBGV92ZPSMrzXJX8Edmb7VCjFoJ" +
           "NRDX9/plQ0XMeU0ftjBToukpjUjiqEISuOloKUdFNjvciGPNN/o4WZ2KvOOZ" +
           "0sBcWZzpIp6+SccdZht3xyRZqfGVTiXFVlVswTpL2ve9YeAh6HiVDZxRh+12" +
           "vVptgfgszelCG6dkkS5nK7E/mcAT2XRpz2kvFCcJJkynrCCOshUyd0pW/HVl" +
           "5I3K6cIKZKSF09lizEt9aaDKS8t0bL/eaFQXc0nTpXrbXsxcfp42En7aXSFa" +
           "ZPsdZFRRI3/JrJaLITFxqE1TmKwcQci2xpZlVx7nTgRxnSELc1aW9Gi71eR+" +
           "MO76sqz28KidzDZ+xrUatWFIThGqNtuEw9ZkGVTqXRIdV/xN10botRBp06Eo" +
           "LZBsUG8tgsmmSSurfn+kRcq0EXdTpzsP5GTDJbMGrgkEOfe3XcoLJg2/xohp" +
           "mkxYiqVS3StzhGJ6ZaSlzCY0IZlC1OusXHUrcZ7CIdXVSM46npuF41GZBPNq" +
           "ZGS3JohlLFmEng4Sv4HyPd6W27hXLvlp1RXIScthWWrCJg2l2hvLUdVRPcYk" +
           "GQKmssCLynMOwdVpm6FYosYxy/ZybMQ67HfGYTXA0lChEV9YcgpHzVa0p8bs" +
           "QMEry46gV0KZqg+USnkjc1ppyamlTV+Kbb6uttJg7Iyrox4zjTLZ2Ham2BJm" +
           "1qvEot2l3+6NbDoFVM1hedmtB2RrqZYFm/QB/QlVGVJlrsFPGN9lUbGtsHor" +
           "VkaeQw3tJprauKgkac1pLtrDLTGuqKwq2pzCa2o2NgbAzlRmoHKtakyj5GwF" +
           "w17J2iLGWHIVKpwB9WjT5gyZ0zitcqLcR8bMim1sRmHdDmbbrusN5XDgILNJ" +
           "xd16MI2z/dRabKcjRfB7farJU8RqA6sTY+2054MQoQi6t22tS0hX7vupZ41Y" +
           "StalcKHSwRaZG2WJohYRvMmQiSZw01V/Ymc9i5q2s/rMtIR1lyQW/GC2RRdd" +
           "E2Gw5WpgEVhPwtV5zE/NcqiEfWblGD1Bm/cjJh4jE2CPPcOMNwje01sJ3qgk" +
           "fMsbIIzbJJrDBREsiU513SyZsjlmytZIIOWySyaLSh3RGGFaEeiow8a4S7M9" +
           "vNaUp8RysI1TYtXszIf4UmejdVnn+SrdW1e8Uh3u03aYxsoKi/WJQ05Dpqu1" +
           "yG4dZrFyNytNo/XUapeYpJcI1GS8XrRoIshkoke04zk8ThvlAZmkm+3YG7qT" +
           "sWPTpBWFG3VOS55bjdrrdUsoZcOlUrZocznTifGqyZflaq9eEmEc7pewuClG" +
           "/S5eE3Vq5hrlmKDpzmBKu0pnZAGjIZuDFo5H29kgq5dUx++a2VDQSG1Z7fM0" +
           "IRBcg0BnjS49HWNbHFuG09oirc8m5tCWMKbMKkKnrTnwxEjbSGudlDJTUnHd" +
           "4rKEDoiF3+J4YewtYcHucBSxJLWuNJwYfG3kUWt0M1InjNkj1qXpvFTBEAle" +
           "04gA2/PFcliOuS1WIjgDNxe8C9s6B3f6W34zW4RS4NIDwqSy1hxjN43atpV2" +
           "2P4Sb7QCJ8Pw5hjhZ0SZUNRga9J9HVnIZI3hsHhUaxqDrS3hSc80sXFHH+t8" +
           "h630ph1vyyZJgFYQuC4F07aXVEuDKtykQxwJU8pGCNmrMfQynW3b8lwbK1V0" +
           "0qQHS1hp0f1ta2ZEU9NBvXJbjgU5BPEjIokqyUkusY0njVAaDsXKGC8tVHje" +
           "qtUlc9Vt+W1lqPIso6bbViQSPgnoDJtyGYjYRMllZPo06SC8SBOmnIzmFhZt" +
           "+93BGHNbKIbN8KQEs+hUQ2jGT2PEToIqM8OEdru2amDctJYtxQhu6OPptlHv" +
           "WlE2p0OzUcJduNOejFowZk5TUUdIUvLaSYrJjT4P15DM7cxrJR7rjDIzBuuZ" +
           "00m7PJjLMTywUBMmg9A1SLEjsrQvBDxaIaxItkNlXO5xsmb3e7yCrmtaBFuS" +
           "suSRktiZIqqKdSouao631RbnD+xGMIItp42jdb20ZXyM79QoMmsaLaMfSfy6" +
           "PmppYYTVYt63MbsL3LHva7FXNVvC1KlUhqS7CeV5dUgMW7zXG8YMGaTNQYPb" +
           "lMmBKQuelrlCOMcsd5Lgw5galMqZ1AioVknKVqthZ4SZM1z1YEJGNDsJNVQV" +
           "DMcTkUkSeZblosEWJ7EYxHKGpTCX4QSuIjdkf1XTuY48kfTGvNQl2VhAqcHC" +
           "x2zfaE3ZCKnjlp/MB1I43tohiTpBE7eTcS/05UV/zocTShpJQ8PoUm000HkD" +
           "Q1BJp3i+HuJDepwpUmKYQj0ZCd1lsGC0oaEOtQzL6CnD4lWpMl+mnckAjoNx" +
           "miiqNF44nhNkETxqqZIHo+gU11tyDatNSj0c+KJn+o4+TAdoL2nhIrpsotMY" +
           "pgIcbzTKtlAhJ9mArIi2yHuUvVKEWlJP+vM+axu63kX1UcMbpgE2bLHVmoCj" +
           "aSLpVZQIWXSRYuWwxM1nPa69VLSUsJcD1E74ttRHdbYcV6O+ZsWKSm1QLvCc" +
           "kVfTibY/svQNMOJur7/xk3WG9rCgzaID3A5CHJ0JcBgHTRv3B8g0XTRGFdTA" +
           "4fkqLE2HqDKUNbUhMWN50NfabUmBWa4/qXkIK3lNzwgdscGRUgdNuomILnSj" +
           "agr61Pa45RgW2oExS1qjTRRssVgtNaNyf1MVQs0XF80YEyRjHY7XVLyWUSPw" +
           "o1jCaqVezU7S9XLsExVxKE20rFJrSUmFqI5WgUNoSte30GFp2WXoZNNa9BKF" +
           "b8K+y7Qivjx0p7Q0maWOFrsOPhIJmZrzblQTle3C0OpBq8FaBrJqwy1lUIKX" +
           "tlvqiajWi5fl9mIK98I6lXYxzMkUsbdJtc7YxrQSMkLG1Kq7jlU0WcyISXsr" +
           "NwJj2BuJfNgo+R2ujkdxHXX8anW1rU65uRbOCWxDwhYu1/lEdTpVlGvM5hV4" +
           "huM9vm1FBtloGsKi3Z8Yg8lspE/LWF8wRH4o+M3O2MUMPfGwDhpjxsTwAww2" +
           "gzEzMhV6OehUVKC7FOdTqZ8RYGd3QT7RQtjxWp9FCOohyFhR56nI1LomK4sN" +
           "FG5UgvYsLaXzDqZ3ZXVTKc2NcLmqDMUqRfaMbUx0dEaSGHXW1eaiutCCnihP" +
           "p3qi+qHvWkLWLXNqpnAdbVCt68K8Hg/EyloxkkZ1y8BEw9/O0tAjVXBgectb" +
           "8qPMJ17eEev+4jR5eOUJTlZ5xwdexinqNofmvQg67wVWokTFN5j3Z4fH8eJI" +
           "fQW6/eXDsQ+0UP5h6LW3u+UsPgp95n3PPqdxn63s7Z/T3w5OzvuXz8fpgNbd" +
           "ddTBOfnRl7q6Aqs+fNMN+O7WVv3ic5cuPPTc5G+KW5vDm9V7etAFI7bt459I" +
           "j9XPeYFuWAXAe3YfTL3i53PgwH4aCDjJ5j8F0N/aDftCBL3i2DAg2/3a8UFf" +
           "jqC7wKC8+tveLT4H7D79ZmdOyvdQyVfudFQ+ppKnTnxJLP6lYF9M/Xj3TwU3" +
           "1C89xw7e9UL9s7tbItVWtsXXpgs96PzuwurwLu6J21I7oHWu8/SL9335ntcf" +
           "KPm+HeAjMz2G7XW3voahHC8qLk62v//Q7775N577dvF14n8Bb5cOBeshAAA=");
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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV8CbDz2l2f73374+3JW/KS9/LWbAqfbMm27HlAY8vabHmV" +
       "NzmBh/bF2hdbVng0yRQIZSaENklhBl7LEEpLA0k7BcrQtAlMCQw0DEtL6RQC" +
       "bWcaSjMkMwVKU6BHsu/y+S7v+3K/3BmdK0vnHP1+/+38j3SkT3ypcEcYFCDP" +
       "tTaa5UbXlCS6ZlqVa9HGU8JrbbYyEIJQkXFLCMMxOPay9NynHvzzr35Yf+iw" +
       "cOei8DrBcdxIiAzXCUdK6ForRWYLD54cJSzFDqPCQ6wprAQ4jgwLZo0weokt" +
       "fMOpplHhBfYIAgwgwAACnEOAGye1QKP7FSe28ayF4EShX/jOwgFbuNOTMnhR" +
       "4dnrO/GEQLB33QxyBqCHu7PfU0Aqb5wEhWeOuW85nyH8UQj+yD/4tof+xW2F" +
       "BxeFBw2Hy+BIAEQELrIo3GcrtqgEYUOWFXlReNhRFJlTAkOwjDTHvSg8Ehqa" +
       "I0RxoBwLKTsYe0qQX/NEcvdJGbcgliI3OKanGoolH/26Q7UEDXB97ITrliGZ" +
       "HQcE7zUAsEAVJOWoye1Lw5Gjwpv3WxxzfKEDKoCmd9lKpLvHl7rdEcCBwiNb" +
       "3VmCo8FcFBiOBqre4cbgKlHhyQs7zWTtCdJS0JSXo8IT+/UG21Og1j25ILIm" +
       "UeHR/Wp5T0BLT+5p6ZR+vtT7pg+916GdwxyzrEhWhv9u0OjpvUYjRVUCxZGU" +
       "bcP73sF+THjs0x88LBRA5Uf3Km/r/Nx3fOVd73z6M7+yrfPGc+r0RVORopel" +
       "j4sP/Oab8LfXb8tg3O25oZEp/zrmufkPdmdeSjzgeY8d95idvHZ08jOjX+bf" +
       "95PKnxwW7mUKd0quFdvAjh6WXNszLCWgFEcJhEiRmcI9iiPj+XmmcBfYZw1H" +
       "2R7tq2qoREzhdis/dKeb/wYiUkEXmYjuAvuGo7pH+54Q6fl+4hV2f3eA7f7d" +
       "fv4/Ksxg3bUVWJAEx3BceBC4Gf9MoY4swJESgn0ZnPVcOIwd1XLXcBhIsBto" +
       "x78lN1BAGND0CDjKSgmuZQbmff26TjJWD60PDoDA37Tv7hbwFNq1ZCV4WfpI" +
       "3CS+8tMv/9rhsfnv5BEV3gSucm13lWvZVa6dukrh4CDv/PXZ1baaBHpYAo8G" +
       "se6+t3Pf2v72Dz53GzAhb307EGJWFb445OInMYDJI50EDLHwmR9cv3/6t4uH" +
       "hcPrY2eGEBy6N2s+yCLecWR7Yd9nzuv3we/54p9/8mOvuCfec10w3jn12ZaZ" +
       "Uz63L8vAlRQZhLmT7t/xjPAzL3/6lRcOC7cDTwfRLRKANYLA8fT+Na5zzpeO" +
       "Al3G5Q5AWHUDW7CyU0fR6d5ID9z1yZFcyQ/k+w8DGWdyLjwItvrOfPP/2dnX" +
       "eVn5+q1RZErbY5EH0m/mvB/5T5//YzQX91HMffDUKMYp0Uun/Dzr7MHcox8+" +
       "sYFxoCig3u//4ODvf/RL3/Pu3ABAjefPu+ALWYkD/wYqBGL+rl/xf+8Lf/Dx" +
       "3zk8NppCcj232y/hBi7ylhMYIDxYwI8yY3lh4tiubKiGIFpKZpz/78EXSz/z" +
       "vz700Fb9FjhyZD3vfO0OTo6/oVl436992188nXdzIGXD04moTqptY97rTnpu" +
       "BIGwyXAk7/+tp37oc8KPgOgJIlZopEoehA52/pKBehT0esYJOQmEwlyV1/JK" +
       "b8/Lb8zksZNa9hvJijeHp13ieq87lWW8LH34d758//TL/+YrOZnr05TTFtAV" +
       "vJe2RpcVzySg+8f3/Z8WQh3UK3+m956HrM98FfS4AD1KYGwO+wEIOcl19rKr" +
       "fcdd//mzv/TYt//mbYVDsnCv5QoyKeSuV7gH2LwS6iBaJd7fetdW9+u7QfFQ" +
       "TrVwhvzWZp7If2VW8faLow6ZZRknjvvE/+1b4gf+6/85I4Q83pwzuO61X8Cf" +
       "+OEn8W/5k7z9ieNnrZ9OzoZhkJGdtEV+0v6zw+fu/HeHhbsWhYekXbo3Faw4" +
       "c6cFSHHCoxwQpITXnb8+XdmOzS8dB7Y37QedU5fdDzkn4R/sZ7Wz/Xv3osx9" +
       "mZSf2EWao4hzXZQ5KOQ778qbPJuXL2TFW7eWHRXu8gJjBcbynXv/Dfg7ANtf" +
       "Z1vWWXZgO/I+gu+G/2eOx38PjEx3hJkPZI3hbUjLSjQrGts+qxeaykvXE3kW" +
       "bI/siDxyAZH2BUSy3VYuHSIq3GllY2MIDO7Fiw0u9/1tlvXqP37+83/71ef/" +
       "KPePu40QqKURaOekfafafPkTX/iT37r/qZ/OR5bbRSHcKmg/Xz6bDl+X5eaI" +
       "7zsWw1sy1iWwfe9ODN+7Ff3wFmUmebg6SndufafJUaC8KFtx42AniG/ci64v" +
       "ZcXoSMvz87V8CFTrxaJlgAh/h2o4gnWiccXRIv3yEDMIDBuMlqtd/g2/8sgX" +
       "lj/8xZ/a5tb78WSvsvLBj/zdv7n2oY8cnprRPH9mUnG6zXZWkwO8P0eZRehn" +
       "L7tK3oL8H5985Rf+ySvfs0X1yPX5OQGmnz/1H//q16/94B/+6jlJ4m3A2LIf" +
       "Qy85FvLhVnJHmtkOfll0AnMY11GycfTo3DZ9NNxrx/NHcDI5o66g8I6LZdzN" +
       "jfskln7uA//zyfG36N9+E3njm/dktN/lP+1+4lept0h/77Bw23FkPTO5vL7R" +
       "S9fH03sDBcyGnfF1UfWprQXm8rskyLx7a3KXjPbhJefirHCB9UqZ8Le6uqR6" +
       "khT2YmrnJmPqc2B7dBdMHr0gpr73RmLqA6EugIyhD6YbgSEf28zjZ1OivN4e" +
       "7O+4SdjvANtjO9iPXQD779wI7Eevhz3Q3QgYX97m23Zemf0TwUAouq6lCM4e" +
       "8u+6SeQvgO0NO+RvuAD5h24E+YO2kLQMVY1DpaV426mxsAfu+28S3NvA9uQO" +
       "3JMXgPvojYB7BIADM6ZdXn0hvo99DfjeuMP3xgvw/fBN4AuEy/H9yE3iw8D2" +
       "9A7f0xfg+7EbwfeQJMRhZEhbewRJ95E/veOMP+F7NZmjhGKPy8dvkkuG/807" +
       "Lm++gMsnboTL3ZpBOBrIro84vOEMB4rZ1tiD/FNfA+RndpCfuQDyz9wI5Pu9" +
       "XJq4G2fCPM8yfvYmoWWZ2/M7aM9fAO1f3wi0+7KAZTgaLkj6VqL966/02GVX" +
       "OlLBWy+7XfRC3jfhRMHm4lzsF49Q//IFuVi2++6seM8WelZ867EoP3s2Bcl+" +
       "allhnM0pst/W9rJ566y4bGD895ec+42s+LWsWG2RXFL3N88MsJ++ScW/vbCN" +
       "+YWj/+co/nduRPGPnVZ8fks+Pk6U9oYqMFF0hWgP+H/4GpzpxR3wFy8A/gc3" +
       "ZLFShph13WXsnTuy3g5yHW0P7RduEu1bdz525Gvnof3iDSUEOVrC9qJN7gFd" +
       "Iwy3fvbf9iD+8dcA8a07iG+9AOKf3jjEWQCk9hoQv3yTEDM9v20H8W0XQPzz" +
       "G4H4Ouk4hDRk2Tg21H2Af3GTAN+486gjzzoP4F/dCMB7coC0EZ0L669fE9bW" +
       "gg8OgLMh17BrRfD74PbzL3xbtvtuMAcN8ydz2a/3HMF43LSkF47um0yVIASC" +
       "esG0sKM4/dDJdGz7bGsPKHHDQMG07IGTzlhgOy9933//8K9///NfABPFduGO" +
       "VXZ7CsyuTl2xF2dPDr/7Ex996hs+8offl9/qBWIcfDX9t2/L6D5wGd2swt3X" +
       "UX0yo7qd4bNCGHXz27SKnLE9TwU3zix6/B/R5ZBpHP2xUxFHh1JpbkMx6vGW" +
       "MQ/4SQRtiPoi8ogE0Rq63tV0ZNBmFaoYWHbJR7gmFWIDYS1203UtkQVkbhDt" +
       "DT2eWLUx1WUkxhy43ATxxLTDTSotpNQaO8sG1+lLDUEyzJZA9oiST08qfUU3" +
       "uCWnwjBqhliI9bAFNuVLYycVUNGGVyqEoioM1cF5z6pgVImrpN7SmIncwPQ8" +
       "AcHUttftd/hq4A35bjKfomtsOqpPwtLGgdV6T+gLUGepuuNuapixbE2TSEKq" +
       "C38sEWKb75UQ3+4ENhbhRZJyu/2FH/R5aeJbKxvvO0NUokJRMfxxIIudYZHF" +
       "yJnUpqxxh54Xw1E6bS4npIUnfc2YtBdLC8wudEStMEV/wderIF+mNxpEsEar" +
       "Lfag2aZsBZIlWkSvwyzlElOhJ3PZV+WaYUX2tGvq4QyTB5uoX5uVN15zrc7b" +
       "ftF1q3TVr0zVlSNtil0tsDudhTcZigNUmFUsh2S4zbRtoPXSskpa6HTVbhet" +
       "3jJcd8iOsGxDy5LtNimijrt6nV81ZR4VED7uI42k3+MCX67MilyzY+nynDfi" +
       "/lKfT1stSnR5nuoEjXQxwbGAwWfuZtNUupBlTHtq7Dul6ijgusu2INNdPp3S" +
       "Tbzh98wGrs+cRVeqpyV/wc0og4zazhgJ+6Jr+IRKmqiMxYHpLdtpcVBU2LmW" +
       "LMBZoT5w8JU7ClvLijX1+o1pVegvxuXpQkIsmm4gsWVWhhpaRicNpGO0+ElF" +
       "aIi1cSeY0PK4R27kznqkkWaa8m6j46ahHvRmzMwWlkWS9ZoIZnQo3i07ekiX" +
       "UppwZ7bSbKT+hG2PZoaViobjDSlZpopcr1XhxTLLaaVlQjU73qioM3Fi+/ic" +
       "dBfVjtyARajOyxCDSNVw0U6pdV+Yec3IhfEKN9PbI0SYOb3irCFJ3ZndkyzM" +
       "kiormqmNG+4EG7rTii3C1aS1mgfT0gaz4tqYVBZdc0WLETnp+y40aImYNZm0" +
       "VrI6cZvLXhTPfWRgkZve0qWSNgqtusiobfaHbqkc1iBMmWHzGhxCdQG457Is" +
       "NIs22LUr7EAf2YhniTI6dHBE8MfLTmnaaS06C9vTRB6eEJtGrToGukz8dDUW" +
       "poqpVcczvq36rMqLHcJrkRN9xFTSYAHGpNRGyEWkV1BDNIJ1tb9w6D5s9TbD" +
       "TdtciDMCKNgWLb/NSDIO9wx9sfTaky5C1pKxFAkIYaeDsW7ORlKzWOLHjqnL" +
       "kF+ZaUNR4lOyIXYYCfWGayWFYchPjb7fH/WBBnCo00ql1kjzZpui6Y1ts+o7" +
       "kr5EV4MWXWUcyZJpuNnczFi3PYGKE1eNImYuMHOC99NNLGsCVnRcvdxduwa1" +
       "7K0mfRQ166mkYEINJzHGEpgmxcq63GOHAygcyEZdMKsbaKWuaDZY8lCNNOTE" +
       "aCRml52XiXllwXRZs9Qf8b4n4A28z9bJapGr6aZSWoob1sHaMcYrcEjbDbS5" +
       "ZIrT0pIqDtWJ3mI5su0E+BCbSisOpdFVMF3CkhKqSXOWDmmF7M0NTqS0uLIm" +
       "y2LTrHqBZVgqBaPUclEu+/yk0ShS047ZYBiyHOGiPCKbg+pKNTqzptuQet4m" +
       "dP1mhG00hNBS05zrc4SCSpLYrxTZOb9SONI0YkLoU+CymDMWO4q8nhenMt4h" +
       "zRocG2tYma9W8Fqdpp3qatpSCc8w9XQu0GttNSOXGL4ZRat4FcnmsLdZoaw6" +
       "6amrvhrxcLxAi1SbVCYCRhCVBkWQsd504XiDiiu0SaV1CGJXieZDnNqiEETT" +
       "QxDIfHS9YTiN785RbuaYRbvf6Sslb5IMa92kJsYzayHD2EhyZo6DUmiLrFWq" +
       "JYtbrYMNzA9bWKkM7IC16WlCchI5R3yYYmqlLpYIJWzV77pLxKPgcn1O1jFI" +
       "U5s23tNGnWkKhaGszYlad2Iu3EG0ELrwjJgyZivYGNHCHZftoNiAmtSqDCHu" +
       "ZDCrrLkmN4iXzU236itwv0pWguLccRBa45y+6TJKSCIJBCTqTo2FDgWOLg36" +
       "03DeG7LLgRNFidublOsJNuk3mJLvNbi4FcoGPa4wTm3kKZEND/CKChk1aDER" +
       "iKjepbQSy81KM6TXMLs12umNpdZw3AYj4bqKrqRxi2sK1HTENXTMm1s+xKSy" +
       "JUq+O4DTkjKtyzIsFs2KHUicGvCxF1Ed4B/GgPUHaBNW9GAKw2NEXK0cpZlK" +
       "fq3muvNiZVVHvJRE6mQdnk+YtYFMrZo7G8JL0wiH0rxlJZgTO9hwOCtNoRG7" +
       "SHgmxrCY5Os2vFGVuQr3+u1lMrS86VKi4ym/llrRZLTpeRJbRUiWVV3VIagk" +
       "6vfgJTucN4d9gSHtNUR3nTqt0cTKVOZdVzOneqtWnk+kDbtYTkYsIfKbqWCH" +
       "btCe66MAEkBsYcSoyrY6xUlH50sLwhuNZ7PUsGtdiVZ4nYBmxETDNorqO4HI" +
       "aYhqLiVM6Miy6yQ0pFJuXZ8J/rRrV9rVBiLXI1SPjG6MluUNz5Usqcw7pjZ1" +
       "BnAFxRZpHbPNyJMrDu7O0uJS7PaqLrRJYWjS2axdt9Zi5fGGg7qsUkLqFWNS" +
       "HLUW2hQbLKpds+UEqEo14N5YSMlmrcowDVsLKpOurw1aRXs0WaFopZoswjA2" +
       "xy5rakpEuvZ0Dbtz2gxNtb/qGXVIC1E2mhm1LpuUl9N+VTcswTabXZbTqZpV" +
       "7Vrx1JmG5VE0XY/weC0qjTnOLMYbVN+AKCanPNbsNNf1XrW6MPCOCjXglCwP" +
       "tDodavo8biykVdzgev05qbaLSFGcF6UksR3CHNaFoYvI+sKsLR28nXgDpKet" +
       "Iag+1lHDadZwfT4zPbhaTuGiMzbJdmkGVcloFMZlEEBwkkalEUk5IaxMR8EY" +
       "76XjOlwDrAY0u6RYxV/NtXa4tmZVpg5jaF2tBqtVu16Ll0V1PuyphplEZNqV" +
       "FWPe91cCtiTSKdUvmfZMECgJq6AmovJxNJ3PKLaVzpM2DPJCSSa6oVeqmAnU" +
       "p1IY1cZW215Ccy9a8MWk3a4FCYXasN60ymXIq7FyCRJj0e6saMszBvLamkMQ" +
       "LJIrsWRb8NKWAqlUqeP1RTGRgvpIpWFiQbupQ6NkcQKJq0qXatYZ13GVtme0" +
       "ZWaESFhEqGo8pAmxhRPTfmWMqsVxkmINXZkWtRBuYLJdSRZ9Ll7BdN8KanVk" +
       "Wk0phe0wlMPYqh/1Z8X1lE8g3QtFvDzqqPVVs1Jkug097Vjd8QyheajXnEe+" +
       "w/hVVzCHxbHQCq2JTKrLKT4eezaH2CVCs+phu1qs0+NkSm3YlFu0Z1N8Q1fU" +
       "9pQpha1RZ5Z6Ft6okLxFeMtSe5RSnMsnJC9w5Yqg9iY9HONj3a7PzQHRDpFQ" +
       "dGHCIbowZDdrm82yPevPFjOQXM15H6aXIdoboNOuNWgla7bZZUjCKStGPKI9" +
       "DfXUktgW6+NxdbEJwNAV2gS7hlZFiSY8k3NNKCI8wqrhyaRnFCcM6xYnOtG1" +
       "EZ7RiFGlVTemUrNRXhRTZjGAyw7CozgYaxYdHm4ro3YYF/ENj3HBuD0uyV4N" +
       "OALbpHqsR/HwYMoskTmYbfALLqxacejSJJ4mq6aReMaIajGjTstx27OGqXRL" +
       "c3xY7c9wrT/n4kadXFuDTC5rzIA2ow3dXmi0UCTaAY60VsSQSWQIbiVjVm+i" +
       "bBs3IKJs4Vn9sFYs01hzw9Egn0X9hLOj+Vok8YiVcT4uBkswlYhwy1tbeGRD" +
       "3ZbhBfqqX4vEYJ36DjmTW1CntI7bEOS7pjxRSlp5KXWrywEjw+hwUEorjEQv" +
       "6+POwJiNRy5JYWnISTTKpb0R3LWrmifY1krHNFNlI5KsMUZnDokKo8BQv7ws" +
       "TkbY0iJmU5gN43aNktshDZU4D/ba83WHqWNw16ykA5C5L3r+RG4s6rqJBht9" +
       "yvFjirUWcVytNUyy5VoRWy/TUK/iiU2QvI2juAKyZNldDy2OsEUu1FJHDHgu" +
       "ISNWr3FWE6ZnU4JU2CGB1+DqZMinsxFBzYVlp5YY1Nox12gPE4OgZrfWMdIJ" +
       "eGy+WkPB1I3QKeGHIlNFZsI8mqFQo1FOZqFjzaySohFWWUdYYMXoaOFFEyDp" +
       "sOczw048rs6L67DRRuqJ4kkIXx5wnakTWr0QGkSkbY8lq7tY9cCURSjJBEV4" +
       "cxtOxjOS1CJ4NKkZjQ2yWVqoUl57IBMMFTIACWJZGTimLyMre7rBilNtvaQm" +
       "tRhKe42+MBE0H1SounGTX8sRMVuEuDywG+ui3mmtK0vBpspOWSP6aWtm9+cb" +
       "Q6EQauJONYJR2YCVNyoLKLQsD9v0EbLUnkseEmI0Xlfb1Z5mdykkcDQwdfU2" +
       "fXydApNk3RmjGr6F21okcYOVO5gDFxsFG1Kpyq1G2B7WFd3ydVrrLVUJKYMQ" +
       "J4gkpRdjrDPH3JbcHVeUlY700ZBO0LrQtHyD1LTJOGwzLk11RzKhNlEwXva5" +
       "UdjVIMqA+dGwAkFgolHhGxTS4iu1RlitV2mbA3NUVOUqomNtxmwfKSLtcaMj" +
       "ur62WKfkIDT8xOlU14vMXZLOyBfpntpa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "r/5B/trR/weDnJHhCFIAAA==");
}
