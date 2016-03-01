package org.apache.batik.apps.rasterizer;
public class Main implements org.apache.batik.apps.rasterizer.SVGConverterController {
    public static final java.lang.String RASTERIZER_SECURITY_POLICY = "org/apache/batik/apps/rasterizer/resources/rasterizer.policy";
    public static interface OptionHandler {
        void handleOption(java.lang.String[] optionValues, org.apache.batik.apps.rasterizer.SVGConverter c);
        int getOptionValuesLength();
        java.lang.String getOptionDescription();
        java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        long jlc$SourceLastModified$jl7 = 1445630120000L;
        java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1aC3AV1Rk+9+YdEhISCcgbEmhBubf4ojaohCSYwA3cEh41" +
                                              "tF42e89NFvbuLrvnJhcE8dFWxhmtI1i11czYgk8Up9Wxj9HS6UOpVUeqrYhv" +
                                              "O6OItjAdxYqP/v85e+/u3fsIGmhm9r+7e17/+c5/vv//z2bPB6TEMskMQ9Ki" +
                                              "UoBtMqgVCON9WDItGm1VJctaCW8j8vVv7th2/G8VV/tJaQ8Z3S9ZXbJk0cUK" +
                                              "VaNWD5msaBaTNJlayyiNYouwSS1qDkhM0bUeMlaxOuOGqsgK69KjFCuslswQ" +
                                              "GSMxZiq9CUY77Q4YmRri2gS5NsEWb4XmEKmSdWOT02BCRoNWVxnWjTvjWYzU" +
                                              "htZLA1IwwRQ1GFIs1pw0yVmGrm7qU3UWoEkWWK+ebwOxJHR+FgwzHq756MRN" +
                                              "/bUchnpJ03TGp2itoJauDtBoiNQ4b9tVGrc2kitJUYiMclVmpCmUGjQIgwZh" +
                                              "0NR8nVqgfTXVEvFWnU+HpXoqNWRUiJHpmZ0YkinF7W7CXGfooZzZc+eNYbbT" +
                                              "0rNNLbdnirecFdx56+W1vygiNT2kRtG6UR0ZlGAwSA8ASuO91LRaolEa7SFj" +
                                              "NFjwbmoqkqpstle7zlL6NIklwARSsODLhEFNPqaDFawkzM1MyEw309OLcaOy" +
                                              "n0piqtQHc21w5ipmuBjfwwQrFVDMjElge3aT4g2KFuV2lNkiPcempVABmpbF" +
                                              "KevX00MVaxK8IHXCRFRJ6wt2g/FpfVC1RAcTNLmt5ekUsTYkeYPURyOMjPfW" +
                                              "C4siqFXBgcAmjIz1VuM9wSpN8KySa30+WLbgxiu0Ds1PfKBzlMoq6j8KGk3x" +
                                              "NFpBY9SksA9Ew6o5oR9LDY9v9xMClcd6Kos6j205tvDsKfueEnUm5qizvHc9" +
                                              "lVlE3tU7+vlJrbMvLEI1yg3dUnDxM2bOd1nYLmlOGsA0DekesTCQKty34s+X" +
                                              "XXU/PeInlZ2kVNbVRBzsaIysxw1FpealVKOmxGi0k1RQLdrKyztJGdyHFI2K" +
                                              "t8tjMYuyTlKs8lelOn8GiGLQBUJUCfeKFtNT94bE+vl90iCE1MFFSuD6NhF/" +
                                              "C1AwEgv263EalGRJUzQ9GDZ1nD8uKOccasF9FEoNPdgL9r9h7rzA/KClJ0ww" +
                                              "yKBu9gUlsIp+KgrhwbCCpmSBMSmbqRnskhQtgPZm/N9GSuKc6wd9PliOSV4y" +
                                              "UGEfdehqlJoReWdiUfuxhyJPC0PDzWGjxci5MFxADBfgwwVwuIAzXACHa1pu" +
                                              "4OJ2gP6wiMTn42OegUqI5YfF2wA0ADxcNbv7e0vWbZ9RBHZnDBYj9Em+Lyem" +
                                              "HqChR1nOABd1G3e+9Ozhc/3E75BFjYvluylrdhko9lnHTXGMo8dKk1Ko9+pt" +
                                              "4R23fHDdWq4E1GjMNWATylYwTGBbYK0fPLXx4Ouv7XrBn1a8mAFDJ3rB2TFS" +
                                              "LvUCvUkyg3cW51FGKtKEJWZ4xhfw54Prc7xwsvhCGF9dq70DpqW3AODswWVy" +
                                              "Pq7gPLfrmp1D0eW754kdXZe5/9rBvTz498/+Grjtjf05lrnU5npnwCoYb3pW" +
                                              "tNDFeTTldSPy/APHiw7dPL6KL0pVLwQKjrduyvDWItgwdZlGwV3k89sp3zUn" +
                                              "v6f2qvDkNe9NWHlx/zqugtv3Yl8l4DawZRg9Zrr3qR4cvV3e17Vn/6Wz5Jv9" +
                                              "3Fkg8eZwMpmNmt2IwqAmBa+o4bTwTXUSQy/PDvRiEZHnTJMejTy+tclPisF7" +
                                              "gMdksLfQGU3xDp5B+M2p/YBDlQMIMd2MSyoWpTxeJes39UHnDaeGMcIqYbHL" +
                                              "0cIWwtVmUyL/xdIGA+U4QSW8/hQup6No4pbix9uZKGbxarPBcmY5Ww44XAV2" +
                                              "wxVpWqXBYisxRepVKZLBpzUz5z36/o21wiJVeJNaorOH78B5f+YictXTlx+f" +
                                              "wrvxyRhDOLTgVBOOqd7pucU0pU2oR/LqA5Nvf1K6E1wcuBULeI17Cr+Yn4Wx" +
                                              "lGsnYGDbnYD9ztsLd/rr+sO/3L+u7KDYfE05q3u89FtXPP0z/ZUj/pQHztVE" +
                                              "1FxqdT33m453ItzEy3GXpQ3LtX9azD7X4tYayBgz8+8jl/JDdzc+u22o8U3A" +
                                              "r4eUKxbsROgsR3DianN0z+tHDlRPfojbajHqZOuTGdVlB20ZsRhXtcYQ/Dge" +
                                              "ona+OBiRBURExgvQMn18LXzeteC0wpMTZxu9f+inb//u+M/LBLCz80PgaTf+" +
                                              "k+Vq7zVvfczNKItJcoRdnvY9wT13TGi9+Ahv72xfbD0/me2CAWWn7Tn3xz/0" +
                                              "zyj9k5+U9ZBa2U4EVktqAv1VD+BopbIDSBYyyjMDWRG1Nad5a5KXOlzDeonD" +
                                              "zWDFLM1dnCuMpI9wLlhRiAUYdKhokiqIAPyKSrU+1m8VXIawqcTBZQ/Y+yK4" +
                                              "te71DXe8+6BYPi/mnsp0+87rvwjcuFMwiMgHGrNCcncbkROIPcK1THJPV2AU" +
                                              "3mLxO3u3/vberdehVthsLiNFYNt422Hb70IXZdj2XO/Yc6uqaxR5K1UmwiNF" +
                                              "D6STKihMZhk8Ps8z+JgduaH3ceht7kW5IN0JsYMHfO4vULYeBUBXIqOWYlIF" +
                                              "qseRSKfmpuj2uME4qW7+1bhHFtwz9BoPmJIkx05u8HKeWNPSeXf+d9sPX1oO" +
                                              "1NJJyhOasjFBO6OZ5llmJXpdJOikWo7J2quLMRYjvjmGwzJzhw1qu1dfCttt" +
                                              "AHwvNXlnLQXQGETxTUaq+nn8K2JhXnONbWD4s5aR4gFdiVroHnLvBdeRQES+" +
                                              "6YWj1auPPnEsi40yo94uyRDGPAbFhWjM47xxd4dk9UO98/Yt+26tuu8Ep/lR" +
                                              "kgycbC03IQNIZsTIdu2Sspd//4eGdc8XEf9iUqnqUnSxhNk75GAQTFCrH5KH" +
                                              "pHHJQhEwDGIIUcshIVkgcd7QhSWnY44qLJoO11I75lg6opgj//JsL1B2PYpr" +
                                              "IT3vo0ysG6dUK5Sirdye3ENCexuOb/xj2ea2FDe0iWVH2eM1e3w0hUVsQfF9" +
                                              "cb/tqwNZg0WNcIVtIMOnCchbC5TdjuJmILU0kG3Ukk3F2Qt5vTuHYcfIYOCJ" +
                                              "VO7MqsHrGwP8UM0wCsFS5MACTkyTcK2HxeeeAmX3CW1R3JUr2hGqDafMKhS7" +
                                              "hSIo7kZxL4r7IQUF6HlGmDNz43brOlxac/Su5L+qJ84SXrZAvuVteIMy9Mxf" +
                                              "Pqy5Old0xQ8m7abedgdfKjpnFGv6EQ9i0wHjKAhBLKzJyLT8h5y8L0Fzo4dd" +
                                              "8LHOgvPh0+udgr3G7ZShCF8/BqCNzw0aBJTq/uPXrj+0Wkx5+jBYReTOeKT7" +
                                              "0YPXXcCpu2ZAsRQmzsrF0XRDxtF06mCkOePINieaEfndvTc8Nf291fX8LE4A" +
                                              "h9pvTQpvfZW9fXx8+/htNzs1a162LjyNisgvbun96NaewW1ievlShsw2W+74" +
                                              "/JnDW1/bX0RKIcjHUFMyKcTCjATyHXi7O2haCXdt0ApC0NGiNdBBejXAKurS" +
                                              "b9OJMjjufH3zKDL7bAHc1iA1F+kJLYrdzvck6QnDcJeKZOSr29eVkLaeBHjp" +
                                              "udt0jQeSgPtoxyrxsMZdaEAg2Rpq6e6OrLws3B5Z3bKis2VRqJ3brQGFvpV5" +
                                              "GaVQErhGUaOtkhkV+3P3FxWNC8ft/xbfn9nAnWqwOIc/kPSc/aX9wV3D+YPc" +
                                              "NPuicA0o9qJ4BMUBFC+4nYYY4eT430W5BQZ+uUDZK95BHxjOF7so/iCKQyhe" +
                                              "BYrvh9isFaIQJ7QYCVr/dNB6g/eI4k0Ub38ptIYLIlyhzwO8wuECSh05SbTc" +
                                              "WQ+Kd1G8h+J9cNl0Y0JSrVxBeFmvrqtU0kaM3kcOev9GcRTFf1B8eErRc495" +
                                              "okDZZ18RuE9QfIric7AwpovQDJ87R4qRrySNkY8P24l3OGFf8Wndj77KAmVV" +
                                              "JwlU3rjLV4FiFIpqDA91psQ2YeGmEQN2hgMYz1+xWx+mdr760wvYmQXKJo4Y" +
                                              "sPEoJqCYxEiFAKxFVU8NZo0OZlPTmE1DMePUY+Y+lvGm96qu9XGNvl6gEXjp" +
                                              "KY6X7sTjUTNhQIDYnpQpT5d4F3NHjPnXUJyN4hug26CksFMD93wH7nPTcJ+H" +
                                              "4oJTynv+dC0f56kePvqCvL7FF+AVLv7S3naVg1kziotQXOLMb8SItedCbBGK" +
                                              "ttPlKXxLhsMpNBKcOI8vRdF1CnHqzoVTGMUKUZJkpDrjU3NqR808qc/UPMfz" +
                                              "/lOM+EcO+aGhmvJxQ6v+Ib5npP7ZoipEymMJVXUfjLvuSw2TxhQOS1XqmBzV" +
                                              "/Q5ks8NpxEil84Dz8K0RjYFJxuZsDLsYf9x1L4eQ31uXkRL+664nwWhOPfBZ" +
                                              "4sZdJcpIEVTBWwrxuSCr7MB87HBL6/pe3Zg3ne1KiP9bish7h5Ysu+LYBbvF" +
                                              "Z33IDjZvxl4gAywTnzF5p0VZebe7t1RfpR2zT4x+uGJm6hxujFDY2VETXeGS" +
                                              "DrvBwHPsCZ4PglZT+rvgwV0Lnnhme+kBSOTXEgSxfm32p5akkYAce20o12F2" +
                                              "Kudrrnx73XMfv+yr44fhROTlUwq1iMg7njgUjhnGT/ykopOUKFqUJvl3oLZN" +
                                              "2goqD5gZZ+OlvZiZCazypdTVGSk1IzOyv5MMm0JXF0yhxcH7Rk4TSUQabCoS" +
                                              "6jKMVEI4nyNvGLidfQP4YP4PQyxRIpooAAA=");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "cnaNCvSOtJsRs5+DF3eE5OBzOfhCDv4J");
        java.lang.String jlc$ClassType$jl5$1 =
          ("yJSAgIts58bpyzgGCdWJS0m/YL7wG//h++d/blehvLLeWtxLO5h6et43f+9s" +
           "+a7o0seLtOcoptwO0oQwHxmVLl7/jluBa1dMveumCnzwWIHF8kf6OxTj+ZPe" +
           "F3Tlj79yRXX22kK4rJL25fGXv/mRehHTzydmaIJgJRxcu7sywh9feHnmiqt4" +
           "1xTTZfWPvvALX3v829IDxR2rnURysirZztfWDyx8r7DwM0UEuH4CcEBRkZBc" +
           "Vn/20z/8jT9+7ltfP1s6B0J2nhwqgQ7ywKi0f72riScRXBJAqwNmgYzx3t1s" +
           "EGCPBAcUeOHo6VGKCJz/9XAXlfhTmWR+uc9yUz3A3djRcrSPnkpPY8872Xsy" +
           "tXg1pvBBkMy9AuEd8X7gD/OrY9kVFyDykvzJTg8E9zbdGo8vCzLfvSy1RmQL" +
           "p7uFiXmgc0/Im1/KbqC9iWlpbSXQdtvmsz+648n3PPz1dxTb5mohvUrBPHxs" +
           "qAf3Q45E4+0IPHkn68B3lk94o+u73Gv7s9/NwT/Lwb/MwTdy8Dsnfdwrc64n" +
           "/NkNFvvPN+j71ulFv3SzcHbCf/6nHPx+Dl4C/tMAkmu7mn4qAr9KCf2PHPxh" +
           "gSsH/zUH//0VSuhmsXfvOBn8UjHgOzcg5LuvUEInc8scfDsHf5KD/wVioA4y" +
           "eCu8Vnp229x1LV1xXrPE/iwHL+fgf+fg+zn409dJYifX+Ysb9P3oVQrrz3Pw" +
           "QwD2wG68PXKPb5Qhr1Uue7floNg0+bnKXn4ysnfuJ7TX9u6+Qd+9r1A4101Y" +
           "9u7KQX5/au98nle5kbnY5J1/4zUL6aEcXChw5a0HcvDgT0pIb7pB36OvWUiP" +
           "5ODNOXgsKt2xE1LLsl4fOT2Vg8eP5FQseOn1lNMJ34QXK7712gMOs7fHjoMv" +
           "mR8/BLEHkrBupurFG0KB4m2vWaZP5wDKAQxeKFPFjF4fcdZzUD4SZyUHtdfJ" +
           "Z505HoXnwC9WfOa68t57ezHgXT92RNw/ltM7cvDOHLz7mLPXLKXOlVJq5aD9" +
           "+nv2PfJmsqFei2z6ORjkgH4dZTO6UjZcDoZZVLrniiv4h7vlqVd0fR9ko2+8" +
           "6p+Fdv/gon7+hfO3P/yC+Lu7s8DDf0K5gy7dvogt6+QV8xPtc16gL8xCFHfs" +
           "jnWL1+e9CXjNuxlFUenO4x85H3vSbvIMJPTXnAx2aP51cuyz4G359NiodGvx" +
           "fXLc+8Fqx+NAjNk1Tg5Ro9JZMCRvFlfgr5MYX7iZOk8UHZ687usgE+/+n+uy" +
           "+oUXBuwHXq5/dneHHmTn222OBbxv3bY7Si+Q5sfSj18X2yGuc/2nf3DvF+94" +
           "6rCMce+O4ONddIK2t1z7kLtre1FxLL39Fw//03f+oxe+Vdzj/n/3Vj/MZjcA" +
           "AA==");
    }
    public abstract static class AbstractOptionHandler implements org.apache.batik.apps.rasterizer.Main.OptionHandler {
        public void handleOption(java.lang.String[] optionValues,
                                 org.apache.batik.apps.rasterizer.SVGConverter c) {
            int nOptions =
              optionValues !=
              null
              ? optionValues.
                  length
              : 0;
            if (nOptions !=
                  getOptionValuesLength(
                    )) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            safeHandleOption(
              optionValues,
              c);
        }
        public abstract void safeHandleOption(java.lang.String[] optionValues,
                                              org.apache.batik.apps.rasterizer.SVGConverter c);
        public AbstractOptionHandler() { super(
                                           );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "chiu9/wnbfDv/Yf/uEIJOcpc5Tw+MZ+Fnvv4ve2f/m4+/zDcs9n3x1diM0ji" +
           "DudWPmX+285DZ/58p3ATWzgv7GWIc84IsyBiQVbk76eNIIs8Nn48w9ke55cO" +
           "4Oy1J6HmyLYngebwTADPGXX2fMuhwR+NT4FAPF3Zre+Wsu+P5RMfzNuLWfOT" +
           "W61nj68HEevnmSaYIWsWZ+TrPBoAjzGEi/sxOgeZJ1DxRd2o58vcBXLt3Dsy" +
           "YXa36doWq7IW3nKRP9eu6Q2X9nkF1r/tcDHSBpnfB//xQ1/9pYdfACYiCqc3" +
           "mfqAZY7sOAyzZPgXnnv6vlc89e0P5gAE0Gf0kc75x7JVB9eTOGuwrOnsi3pv" +
           "JiqTn+gkOEqpHCckMZf2up458jQTQOtmL9ODnrjjhfXHv/PpbRZ30g1PEEvv" +
           "f+oDP9p98qmdI7nzw1ekr0fnbPPnnOlX7mnYKzx4vV3yGfg/ffaJP/7NJ963" +
           "5eqO45lgB7zofPov//urux/79pevknDcaNj/B8MGt2G9qt9H9//I8kpeRLM4" +
           "Xsg03OCVtNjXFxu02x2Oi7ztEWMzmOIjFF1E1WpMmYbZZ1JrWBfqNXwjlg2x" +
           "US32CQatrNt6e71sOdgYh5p42yz325zo2svINdyg3ymNJy075TpDfUr0SsZg" +
           "TbdHqseUpiJE1YdIER5a6CiFHWTDmrDjw40mspFDaGh5WpdZR1ggOauphI5h" +
           "bjWl4omRlnHfbE8n9gKbwmi7SUkWIUaQH26snhaUW/OhOyLcRVRhyuq6ljAa" +
           "24+KTby0mM6cuTbXPI1aR1NGa+ldgloxjjewmi5erYTNQa2/9pO6uGJU1Cqt" +
           "GLrN6V1DVdPRbEgY0xk20VFVnrLahvBSgWyi0ni+YByzmeKE3WirlZBiOF4M" +
           "ExYfzjvDkFJ7FDJejI0eS9AVNiqVlk1pxq/owWRNrZkSzRuy709qCQETsqUG" +
           "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" +
           "8cy38suT/wUnrU4OoSUAAA==");
    }
    public abstract static class NoValueOptionHandler extends org.apache.batik.apps.rasterizer.Main.AbstractOptionHandler {
        public void safeHandleOption(java.lang.String[] optionValues,
                                     org.apache.batik.apps.rasterizer.SVGConverter c) {
            handleOption(
              c);
        }
        public int getOptionValuesLength() {
            return 0;
        }
        public abstract void handleOption(org.apache.batik.apps.rasterizer.SVGConverter c);
        public NoValueOptionHandler() { super(
                                          );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "h7OMaV7TGDBcZID7X/SwmLAyGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "nG3g0iYAAA==");
    }
    public abstract static class SingleValueOptionHandler extends org.apache.batik.apps.rasterizer.Main.AbstractOptionHandler {
        public void safeHandleOption(java.lang.String[] optionValues,
                                     org.apache.batik.apps.rasterizer.SVGConverter c) {
            handleOption(
              optionValues[0],
              c);
        }
        public int getOptionValuesLength() {
            return 1;
        }
        public abstract void handleOption(java.lang.String optionValue,
                                          org.apache.batik.apps.rasterizer.SVGConverter c);
        public SingleValueOptionHandler() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "4Jb9oU5Nsy54vsQ0r2kMHC4yNP4v8uzSa1MbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "L/391378qW/ld1D/C6EBHiLrJgAA");
    }
    public abstract static class FloatOptionHandler extends org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler {
        public void handleOption(java.lang.String optionValue,
                                 org.apache.batik.apps.rasterizer.SVGConverter c) {
            try {
                handleOption(
                  java.lang.Float.
                    parseFloat(
                      optionValue),
                  c);
            }
            catch (java.lang.NumberFormatException e) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
        }
        public abstract void handleOption(float optionValue,
                                          org.apache.batik.apps.rasterizer.SVGConverter c);
        public FloatOptionHandler() { super(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO9vnD4y/CLZrgjHmQOXrrigftDqaAgbjI2d8" +
           "tYGqpskxtzfnW7y3u+zO2WdTl5C0BSEV0eCkJAL/5ahtREJUNWrVKshVqyZR" +
           "miJo1OZDTVr1j6QfSOGfuBVt0zczu7d7e2cD//Skm9ubeTPvzXu/95s3e+kG" +
           "qjIN1K1jNYVDdEInZijOnuPYMEmqR8GmuR96E9LpP587Pv+72hN+FBhGDRls" +
           "9kvYJL0yUVLmMFopqybFqkTMfYSk2Iy4QUxijGEqa+owWi6b0ayuyJJM+7UU" +
           "YQIHsRFDzZhSQ07mKIlaC1C0KsatCXNrwju8ApEYqpc0fcKZ0FE0occ1xmSz" +
           "jj6ToqbYETyGwzkqK+GYbNJI3kAbdU2ZGFE0GiJ5GjqiPGA5Ym/sgRI3dL/U" +
           "+Mmts5km7oZlWFU1yrdoDhJTU8ZIKoYand7dCsmaR9E3UEUMLXEJUxSM2UrD" +
           "oDQMSu39OlJg/VKi5rI9Gt8OtVcK6BIziKLVxYvo2MBZa5k4txlWqKHW3vlk" +
           "2G1XYbd2uD1bfGpjePp7jzb9qAI1DqNGWR1i5khgBAUlw+BQkk0Sw9yRSpHU" +
           "MGpWIeBDxJCxIk9a0W4x5REV0xxAwHYL68zpxOA6HV9BJGFvRk6imlHYXpqD" +
           "yvpXlVbwCOy11dmr2GEv64cN1slgmJHGgD1rSuWorKY4jopnFPYYfBgEYGp1" +
           "ltCMVlBVqWLoQC0CIgpWR8JDAD51BESrNICgwbG2wKLM1zqWRvEISVDU7pWL" +
           "iyGQquWOYFMoWu4V4ytBlDo8UXLF58a+bWeOqX2qH/nA5hSRFGb/EpjU6Zk0" +
           "SNLEIJAHYmL9htjTuPWVU36EQHi5R1jI/OTrN7dv6px7TcisKCMzkDxCJJqQ" +
           "ZpMN1+7tWf+FCmZGja6ZMgt+0c55lsWtkUheB6ZpLazIBkP24Nzgr7/62PPk" +
           "735UF0UBSVNyWcBRs6RldVkhxh6iEgNTkoqiWqKmevh4FFXDc0xWiegdSKdN" +
           "QqOoUuFdAY3/BxelYQnmojp4ltW0Zj/rmGb4c15HCK2AL+qC7zkkPvyXonQ4" +
           "o2VJGEtYlVUtHDc0tn8WUM45xITnFIzqWjgJ+B/dvCW0NWxqOQMAGdaMkTAG" +
           "VGSIGIQ/uhk2sAlgkieJEe7HshpieNP/b5rybM/Lxn0+CMe9XjJQII/6NCVF" +
           "jIQ0ndu5++aLiTcE0FhyWN6i6POgLiTUhbi6EFMXctSFmLpgr6JhOqCzCPfB" +
           "JiCSyOfjiu9hlggMQARHgQuAjOvXDz2y9/Cp7goAnz5eCe5noutKDqcehzRs" +
           "pk9Il64Nzl99s+55P/IDryThcHJOiGDRCSEOOEOTSAooaqGzwubL8MKnQ1k7" +
           "0Nz58RMHj3+O2+EmfbZgFfAVmx5nVF1QEfQme7l1G09+9Mnlp6c0J+2LThH7" +
           "8CuZydik2xtm7+YT0oYu/HLilamgH1UCRQEtUwggY7xOr44iVonYDM32UgMb" +
           "TmtGFitsyKbVOpoxtHGnh+OvmTXLBRQZHDwGcnL/4pB+8e3f/vU+7kn7HGh0" +
           "HeBDhEZc3MMWa+Es0+yga79BCMj98Xz83FM3Th7i0AKJNeUUBlnbA5wD0QEP" +
           "fuu1o+988P7sW34HjhQO31wS6pg838s9n8LHB9//si/jC9YheKOlxyKvrgJ7" +
           "6UzzOsc24DEFMpyBI3hABfDJaRknFcJy4d+Na7e8/I8zTSLcCvTYaNl0+wWc" +
           "/s/sRI+98eh8J1/GJ7Fz1PGfIybIeZmz8g7DwBPMjvyJ6yufeRVfBJoHajUh" +
           "tzlbIu4PxAN4P/dFmLf3ecYeZE3QdGO8OI1c9U5COvvWx0sPfnzlJre2uGBy" +
           "x70f6xGBIhEFUHYAWU0Re7PRVp21bXmwoc1LOn3YzMBi98/t+1qTMncL1A6D" +
           "Wgn41BwwgAPzRVCypKuq3/3FL1sPX6tA/l5UBwyX6sU84VAtIJ2YGaDPvP6l" +
           "7cKO8Rpomrg/UImHmNNXlQ/n7qxOeQAmf9r2423fn3mfo1DAboU1nf9Zy9vP" +
           "smYj769gj5soqsFJ4AIwDUBr8houX3AXn9+xiLuK9Rho5UL1CK+lZh+fnkkN" +
           "PLdFVA0txWf8bihhX/j9f34TOv+n18scJQGrnnQU+kHf6hLS7+e1mkNYW6/P" +
           "V7z3ZHt9Kd+zlToXYPMNC7O5V8Grj/+tY/9DmcN3QeSrPF7yLvnD/kuv71kn" +
           "Penn5abg8JIytXhSxO0vUGoQqKtVti3Ws5SnQXchro0sXrvgO23FddqbBoJx" +
           "ywLHx4HjgIQhFzUsspgn7/1W9Nj/drhqcWCzMjokymh7YPNti4ehg3vgJBuD" +
           "4wdykM36yiIU8whrvkxRfYaXGKLcAAitX+RaZ8hZODLGrMI4PNXyweiFj14Q" +
           "8PVW0R5hcmr69KehM9MCyuKqsaak2nfPEdcNbmsTazbnOcAX0cJn9H54eern" +
           "P5g66bf2GaWockyTxXVlK2sGRawid8Y1rGM77+4vhLidDcXge8EK8YW7wIuf" +
           "44U1uzygaVtkxQVAw04IV8qztwRDOSAwj/cvt84f/VX15C77flJuipB82Oy/" +
           "+rO+DxM8fWsYPxSSxsUNO4wRV1Vih4f9JFzPcG5C/QG1bMFsX6E8bfXaINQH" +
           "tlz81/Fvvz0A9VQU1eRU+WiORFPFyVxt5pIuo5yLoZPalkWsrKDIt0HXee8w" +
           "b7VFkuIYa2RPUrC+pAOfI3cPnzzUNaVFvZ3Ya+/oVgA+ay95ByHuzdKLM401" +
           "bTMH/sCr0MLdth4CmM4pist1bjcGdIOkZb7telEWCC99k6Ku21lEgVELf/g+" +
           "nhCTT8LlvOxkyEL245Y9DWTnlQXE8F+33HdAmyMHR594cIucpagCRNjjd3Xb" +
           "rw/d2W1rCDhWgdNOyZGi8OR9pVXDVlF/3wYArgJgTRGb8ldNNuZz4mUTJOfM" +
           "3n3Hbj74nCjYJQVPTrJVlgDSxbWgcFCuXnA1e61A3/pbDS/VrrXZr+jC4LaN" +
           "4xJSkRfXHZ4K1gwWCtl3ZrddefNU4Drw9iHkwxQtO+R60SPeakAZnINT/FCs" +
           "XE5DGcGL60jdXw5f/ee7vhZekVks0LnYjIR07sp78bSuP+tHtVFUBeRO8sOo" +
           "TjZ3TaiDRBoziigikNRyauGtVAPLAszOT+4Zy6FLC73sLkdRd+kJVHq/hWJ1" +
           "nBg72eoW5RSVFjldd49yz44L/mGeBmQmYv26bl9xItzzus6ZYZY1+f8BUxUz" +
           "GU8WAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze6zjWHn33NmZnR2WndmBXbYL+x5oF8N1nDixowG6iZM4" +
           "TpzYedh5lDI4fsfP+JHYptsCEg+BRBEMW5CWbf8AtUXLQ1VRK1VUW1UtIFAl" +
           "KtSXVEBVpdJSJPaP0qq0pcfO3Jt77zyWVaVG8ol9/J3vfM+fv3PO8z+EzgQ+" +
           "BHuulWiWG+4rcbi/tMr7YeIpwX6HKXOiHygyaYlBMAZ9V6XHv3Thxz/5qH5x" +
           "Dzo7h14lOo4biqHhOsFQCVxrrcgMdGHX27QUOwihi8xSXItIFBoWwhhBeIWB" +
           "XnFkaAhdZg5EQIAICBAByUVAajsqMOiVihPZZDZCdMJgBf0qdIqBznpSJl4I" +
           "PXaciSf6on2dDZdrADicy54FoFQ+OPahRw913+p8g8KfgJFrv/GOi793Grow" +
           "hy4YzigTRwJChGCSOXS3rdgLxQ9qsqzIc+heR1HkkeIbomWkudxz6FJgaI4Y" +
           "Rr5yaKSsM/IUP59zZ7m7pUw3P5JC1z9UTzUUSz54OqNaogZ0vX+n61bDVtYP" +
           "FDxvAMF8VZSUgyF3mIYjh9AjJ0cc6ni5CwjA0DttJdTdw6nucETQAV3a+s4S" +
           "HQ0Zhb7haID0jBuBWULowVsyzWztiZIpasrVEHrgJB23fQWo7soNkQ0JoftO" +
           "kuWcgJcePOGlI/75Yf8tH3mX03b2cpllRbIy+c+BQQ+fGDRUVMVXHEnZDrz7" +
           "jcwz4v1f+eAeBAHi+04Qb2n+4FdefOpND7/wtS3Na29Cwy6WihRelT6zuOdb" +
           "ryOfrJ7OxDjnuYGROf+Y5nn4c9ffXIk9kHn3H3LMXu4fvHxh+Oezd39O+cEe" +
           "dJ6GzkquFdkgju6VXNszLMWnFEfxxVCRaeguxZHJ/D0N3QnuGcNRtr2sqgZK" +
           "SEN3WHnXWTd/BiZSAYvMRHeCe8NR3YN7Twz1/D72IAh6LbigR8H1cWj7y/9D" +
           "SEV011YQURIdw3ERzncz/TOHOrKIhEoA7mXw1nORBYh/883oPo4EbuSDgERc" +
           "X0NEEBW6sn0JHrwA8cUABJORKj7SEw1nP4s37/9tpjjT+eLm1CngjtedBAML" +
           "5FHbtWTFvypdi+rNF79w9Rt7h8lx3VohRIDp9rfT7efT7WfT7e+m28+mu9yy" +
           "XDFkvczDbaAE8CR06lQ+8aszSbYxADxoAiwAKHn3k6Nf7rzzg4+fBsHnbe4A" +
           "5s9IkVuDNblDDzrHSAmEMPTCJzfvEX6tsAftHUfdTHrQdT4bzmVYeYiJl09m" +
           "2834XvjA93/8xWeednd5dwzGr8PBjSOzdH78pJ19V1JkAJA79m98VPzy1a88" +
           "fXkPugNgBMDFEFgwg5yHT85xLK2vHEBkpssZoLDq+rZoZa8OcO18qPvuZteT" +
           "B8A9+f29wMY8dL05FvjZ21d5WfvqbcBkTjuhRQ7Bbx15n/6bv/jnUm7uA7S+" +
           "cOT7N1LCK0cQImN2IceCe3cxMPYVBdD9/Se5j3/ihx/4pTwAAMUTN5vwctaS" +
           "ABmAC4GZ3/e11d9+9zuf+fbeLmhC8ImMFpYhxVslfwp+p8D1P9mVKZd1bLP7" +
           "EnkdYh49xBgvm/kNO9kA2lggD7MIusw7tisbqiEuLCWL2P+68Hr0y//6kYvb" +
           "mLBAz0FIvemlGez6f64Ovfsb7/j3h3M2p6Tsa7ez345sC6Gv2nGu+b6YZHLE" +
           "7/nLhz71VfHTAIwBAAYgA3NMg3J7QLkDC7kt4LxFTrwrZs0jwdFEOJ5rR6qS" +
           "q9JHv/2jVwo/+uMXc2mPlzVH/d4TvSvbUMuaR2PA/jUns74tBjqgw17ov/2i" +
           "9cJPAMc54CgBQAtYH4BQfCxKrlOfufPv/uRP73/nt05Dey3oPIAYuSXmCQfd" +
           "BSJdCXSAX7H3i09to3lzDjQXc1WhG5TfBsgD+dNpIOCTt8aaVlaV7NL1gf9k" +
           "rcV7/+E/bjBCjjI3+RifGD9Hnn/2QfJtP8jH79I9G/1wfCMwgwpuN7b4Ofvf" +
           "9h4/+2d70J1z6KJ0vTwURCvKkmgOSqLgoGYEJeSx98fLm+23/MohnL3uJNQc" +
           "mfYk0Ow+COA+o87uz+8c/mR8CiTimeI+vl/Inp/KBz6Wt5ez5ue3Vs9ufwFk" +
           "bJCXmWCEajiilfN5MgQRY0mXD3JUAGUnMPHlpYXnbO4DhXYeHZky+9tabYtV" +
           "WVvaSpHfV24ZDVcOZAXev2fHjHFB2ffhf/zoN3/9ie8CF3WgM+vMfMAzR2bs" +
           "R1kl/P7nP/HQK65978M5AAH04Z5pXnwq49q9ncZZ08ia5oGqD2aqjvLPOQO+" +
           "o70cJxQ51/a2kcn5hg2gdX29zEOevvRd89nvf35bwp0MwxPEygevfein+x+5" +
           "tnekcH7ihtr16Jht8ZwL/crrFvahx243Sz6i9U9ffPqPfufpD2ylunS8DGyC" +
           "Vc7n/+q/v7n/ye99/SbVxh2W+39wbHj3l9pYQNcOfgw6UycbPo4nKltdOw0s" +
           "QUhm7mvLtj1gp75vaGrYWIk1bbGkizIRzqiVF5hxmKrOBE9KEZyyxYk8tspk" +
           "oT5qCgWFNDs1BimLejhsdvj+xBe6gS6skvnQNjouys4bY8FHl5WBOmIpNaoL" +
           "YSGV0giXcaUoNRBkZNrVaKGMuXU6jZBqOSgpsEmtlnQf7aLL/kxoyE3amRtL" +
           "1om4Wa9pr4YEZUfDaqVZZTyuTODcGsaLeh9u1XWqMbSCqrmedZhCwguM3Wu5" +
           "3ipZtFbmuKfORmaRTrABHxtLqrkSYXczMSqLgphESafTg3Genw3odjBsNdK5" +
           "PhoUcLtLWyKJkoVuIIbktO9vlhFR85qzlScVVKk7L7SaBVeS0NgepctlZeyu" +
           "FrPmOKE2qbnqwtRs0e/QJbO2kPninAK0lNEpU8uVwVG18sxGAm1Il2QG4eGe" +
           "HQZl08bduTVp8Wjiy25D74x5Yk533RkoH3GZDGxxWG2W+CbfY6bA2PGoV+T9" +
           "htsY9EZRqcpaHQ0RukbZp6tUSLChIHUrdTo1uowQz9ZusVefi2UTC2Nrsuq2" +
           "J6W1ZRYpdDpbyMWogS5UylsqnIcv00V1VaPRxqpPTYaoUTZ1rV7jrQ1cH5hm" +
           "YbSpJsOR1+Z7lDehlXoj7pAxbVbFwgSLy0MQE3Fc27RnTIVIvZitVdpCtd6h" +
           "WuuhWTFsqz2beqtGsvamlrDYkGyCorLtF6nmuoJJfTSwNLvTprQG6o+iiet3" +
           "Z9jS9ZwWN5upda05ozzUCsmeYNWF1YRxB2SBpDVvMiQ6jVqjjNabI79Pk9pm" +
           "QRU3XaaHpqvJcN2kR0KDx70JYyTUYBVN2Fmr504iTMCSsG41XIKfMq0yIcKL" +
           "icKupsVVG3FqZX00bFELpOkt+cocKN5nmnSn1p7ZTFUPl+OImwh8qdIctI3y" +
           "EF3SCDv2+7i8rngxPpaMoEv2UrMRk53OajD3en0UxsOJCrdIe04txcq8p4Vw" +
           "QSqXrWASmryu1CtzjxFTum5yRayfaj6OVIocZ+KlMt8q8PWR0E8mUn0YVIaW" +
           "LJh6rFeMptYfm+7KAA61lbWOtVrThlSIJ4aiyaOu3B+sWJePWnJtVkLqsWLN" +
           "BqAEW3qYFU4K8yXi29QCk9Bym+wWawy8IvHUNLl1MnWdAeYWhQ7VDGeWwIdt" +
           "wDV0iAnfw8oxPXZaNDDsUuvAdURek5NCfxKv2EGvRslizxzXKIEa0RQ9QCLd" +
           "LAY1SzMNpdNU8Hage4bS55BF2U8WPYSJnQJM9pTqdNkZ0DRS6ZNCa0kPCo4c" +
           "lWFYZIyx1Cy09GTSrxgVjtVAB68vjEqz1ZtK4ahlM57mVzo6uyJTklPrHYMc" +
           "Jay6NKKqbmlab1AbtrVBVFuy62kjLSZVhPRwza05aVkhlbLjRmG3sZIUPR0G" +
           "nlmlrQqwvFWtBnC5zCF0w0/GutTusAZAFnLUZNkmOx7VXFdcUekmWjBEr+sM" +
           "UBMv9NMyMey1lyWYLcJNW13MtZZaE+y47AgtdNBUB7aCWyhVqMLVnmN5FanQ" +
           "gYvMWG/jBBnNE9kwi3Fo4/BsXHBnEdJmDEu0tTbKk8NBM+Q3mjbDY9bHMENw" +
           "nVmjVyryWm8xtkOqZYRB0l0IrOfGYZtydJhd2+MpUx8O5u3GhpIcBsG8Okwo" +
           "JRVZ8zBuOnib0gttkLt6cy6Ver2JCDeDApxoIl6tk71llZimRKnVK4113CjU" +
           "up2+wvN1y1nUyptGYdDk1ChCXbhKEBweTEpYe6kP2BK6GVU8jSgRQdUhmHa9" +
           "iiCBgSzJ6kxXuqwVJ921r3XwCp+mbCAVsQbwopfU6ZJeq6uNjjg0nZbUSTAZ" +
           "7ou4QiA0kY5HjESuxzOxbxXgzURCAiQY0mBiRSc6KEJ18FaKcpRKJwtamdsp" +
           "oeGNTZ3rLddJp5JEqjIUQFC4bXHJ62FqLegI4+JaH+MQGcSOWlKkmTJvlgYy" +
           "xRIsjUpVvkyy6/UkLgSc6qRWx1eKEVVPYrygVmKqTuvNFt+e1SZ8Yajg3FDw" +
           "iuhiam9cCWVYpzRLe3WjSiAhjK7GPUdi0FqlMdEcDK1vNlqNS4cCmXjdaFVC" +
           "Si0GDbhpJawhVpmvb5JpJeAJTKiFdKc4o8QGt+YqFi51WWLoubavITxtt+1+" +
           "f2oNEAdfxawyqNlq1S9ixZLqlGzVRRu1hcujjlqdJ9U1F9izJV6pasty4K6C" +
           "Vger0ZsGX/cJ3Y2mpdrUqcKxwUTd6lB3yzyDkl3Ymuuw6phmn2PkllArhKBM" +
           "IBaGrk+RZVUtYWN2DTsoEUidAeU7zoCHzbZa0ZkRDiuobfZnkwrCCXhamrfD" +
           "aleGU2vsTmdcr0/ibFkgKH+JwOEMqTZsqV8aKCOfa+EJA8oQxIzWOGo6nOI4" +
           "ZXGhER06Caf6KGYLa55yB6tuKIRGaRKUR85gKoElfSGY+muNLZZasrxa1N1O" +
           "nGyYdgxCUaMHeivlg8DTHBxBJ9X+EpF9fSVNyLS3dM3E1vEZ1w8NTNG10lrr" +
           "1KMGtpETs1eqJAbNExvdX5vxUJ2JU6rLSLWaEU7hoTgn9DnbYCi/R2Ncf5ps" +
           "FKO1RLEBwQmTwrCsS7ZfqXYVvVftkUnUXQWiaBYdlWvKUn9hB2MxXTisVJsW" +
           "pI5TbZcxRfEdrqxVKgu1SIkTVzKTcTwVrG4xoIbixpCJGepTPRyHsbXOGHJD" +
           "mmoK0ewSswm+oSMVw3g0SkHOCqEZD4TapoDRArFKw82wwY5qmyUirUMCUxFh" +
           "ipZJHFetTmR4daLIJgjss3Aj7hHqJJhx8WgUB3yfxTZDARUMHVOrnVbKSVSZ" +
           "RAYUuui1gmmlSSzUqUj3B+3QSgkUaa3XaaFWFQY8qgx5eGKwwxbXSoQ4LHt0" +
           "5JYTxp1zomVOAr/boMNCe6ooxGaBCy0zomdiccjxPgl7NValSxLnpCnfF4XW" +
           "el6aiTDiCloNFpNquZ60o1QGH3KsgC7GvTYSkH6hx8ihjpF2D/PA6h9dLCVK" +
           "pllzvsBDxWpOSLJaNSvdqIhaTU1oMiqiwY5OjscEY63Z2EyaTBErz6qNydix" +
           "BtMm0YJLpbZcs5Nee1iuYhIdSZ6okcP+cimXpgt/g8jFCeqTDX2iyX02mVMG" +
           "wQ6rnjBtCFYLKW1mNYBr2nhILQhL7vejeYrZ/LjDqr2SU2ovljjmkMtZZyBw" +
           "Y78jWFpjFC8mmtQio6lTQ5UKWish3qIxQgTfn859eElijNjH4s7IHKrT9hzr" +
           "otpmQoZWae7LsqL2eazhb6pG29zEg5CFh5XCiFNEszZ36P4YaZHBtFluUBLF" +
           "VApLebopq4ii4Gt9rpiCGRQYZ7akhwU88HBiMYo4OGyHQouvK0OWCFh3vJyX" +
           "xqLRGNbd1DA0w+wPEzGiQqHGMbUgZccwNk8qLYbESwFjykMZNjtCe4Xokw7q" +
           "1DW8qLiT8nAEPuSWLGPVJMUwBrEppW4P7Nm6WFlY1ZgO0zQKKvPZfIbCKlHn" +
           "Yz6leGICVihvzZYub395q8d784Xy4QkHWDRmL6iXsWqKb79APycugtAXpXyH" +
           "qxEfbh/mGykP3mb78MgWC5StFR+61dFGvk78zHuvPSezn0X3rm9NTULo7PUT" +
           "px2fPcDmjbdeEPfyY53dfslX3/svD47fpr/zZewIP3JCyJMsf7f3/NepN0gf" +
           "24NOH+6e3HDgdHzQleN7Jud9JYx8Z3xs5+ShQ7NeyMzVANe162a9dvNd2Zv6" +
           "7FTus21onNj229saMA+Og02UN7/kbv5IoEjXWSs+6MjZhrfZTcwbN4Tu1vM9" +
           "/+3+f045PBKDAljXr11D3gWn91JL+qMT5R3WobkeyDoZcD173VzPvgxz7R3m" +
           "lHI7m91MhTNqdsSRPUT50Pfdxi4fypp3n7BL1pfubPCel2ODOIQu3XjEcuDV" +
           "1/9MZzQgkx644UR4e4opfeG5C+de8xz/1/mRxOFJ410MdE6NLOvo/t+R+7Oe" +
           "r6hGrvBd291AL//7eAg9+lIShSArDh9yPT62HfxMCN1308EgiLK/o7SfCqGL" +
           "J2mBo/L/o3TPgtl2dABmtjdHSX4zhE4Dkuz2t7wDu77tZzv7GhmOZin5pusx" +
           "98SnjgPioesvvZTrj2DoE8fALz/4PwCqaHv0f1X64nOd/rterHx2ezAjWWKa" +
           "ZlzOMdCd2zOiQ7B77JbcDnidbT/5k3u+dNfrD1D5nq3Au5w6ItsjNz/5aNpe" +
           "mJ9VpH/4mt9/y28/9518v/R/AWq70iqRIQAA");
    }
    public abstract static class TimeOptionHandler extends org.apache.batik.apps.rasterizer.Main.FloatOptionHandler {
        public void handleOption(java.lang.String optionValue,
                                 final org.apache.batik.apps.rasterizer.SVGConverter c) {
            try {
                org.apache.batik.parser.ClockParser p =
                  new org.apache.batik.parser.ClockParser(
                  false);
                p.
                  setClockHandler(
                    new org.apache.batik.parser.ClockHandler(
                      ) {
                        public void clockValue(float v) {
                            handleOption(
                              v,
                              c);
                        }
                    });
                p.
                  parse(
                    optionValue);
            }
            catch (org.apache.batik.parser.ParseException e) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
        }
        public abstract void handleOption(float optionValue,
                                          org.apache.batik.apps.rasterizer.SVGConverter c);
        public TimeOptionHandler() { super(
                                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WkXvdpl2ddy1pPlEISRaxni0R/Ukqt9cGyzHWcoI90eTKuOsKzMOgwUu9RtV" +
           "pyYvN75nC0ZrPC0L/do4xInKKpk313yPJPtoY0zXA9QIZhSK1cqy17QCo9if" +
           "6B2w3x1uWr210qu3QT6CWSxTmk0rkt51Vn3MlvAC12BQoUOltK4UG1RLcQqJ" +
           "KfJAl+2movJMISpSFC3Hsuyx7a5aSamVUuu7c6lnr2zS9IVmySpPuaiE1OsL" +
           "BCUkuJIWiHoVWemTcDPob0rlEc2ZrjTpjqcglZ43k1lJbQ9m9TqiWToulnqj" +
           "pjtYmViUlBvrTjM0VyO4pifNuF6Hp8asG61kqlmSY7ZnuQMSTTAs7ZYtoVkd" +
           "Iyt7PCKooFNyWV+vlsxwLiusW5SxuNfmFLppEz7M9SmV8AJnBMSbuasQCYel" +
           "Yq3Sr3ntkljmdSstTFm4bsZlREaUvoUhyLQ9DUeMPO+w1EJQkUEhXdcK9BJT" +
           "SqN+D7Ypw50VMbleT4cV0jF1lx+1AZrOxUkPsfGZiaidsaRROpla1RYdCaUy" +
           "kpZng7UziGhME6dUDTVq9bbTrrFK2QtpCtF0xZMZkpv7JtuBy7M+iXVKs42o" +
           "lGyEN1dwx6wY/Z6wElh0DGPVdcSXkuHUpyaTIhHgAaogjb44YcuM2CkW+3W1" +
           "vDRit1Yt+TIx1gejqGQuRuVFy69KOM/IXo8qbejYKBFs3GbgdjCnyibWLxN0" +
           "CTYEeVWNbGWM983yQmfZUhVeaf0q7kuiNk+0is52mZgEneKiH9Y4qq5tpHlp" +
           "sMKHZttvjkh7qC4TPOGmdafpqcNKlepEsce0hiQzGNRSQR4vulUQYWaRTyWj" +
           "1lxYpocgdQMtDwRD8IqlSVkUFxqAiEEbl+tMIegsi7qkWJg1nQalCN5oATaV" +
           "HKNTD+NehcCSpSejQEmBruv0kp1GiFd3ULIgwl2BcMp0B6nMUKQUVYdrh7ek" +
           "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" +
           "o/8L9OArd30hAAA=");
    }
    public abstract static class RectangleOptionHandler extends org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler {
        public void handleOption(java.lang.String optionValue,
                                 org.apache.batik.apps.rasterizer.SVGConverter c) {
            java.awt.geom.Rectangle2D r =
              parseRect(
                optionValue);
            if (r ==
                  null) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            handleOption(
              r,
              c);
        }
        public abstract void handleOption(java.awt.geom.Rectangle2D r,
                                          org.apache.batik.apps.rasterizer.SVGConverter c);
        public java.awt.geom.Rectangle2D.Float parseRect(java.lang.String rectValue) {
            java.awt.geom.Rectangle2D.Float rect =
              null;
            if (rectValue !=
                  null) {
                if (!rectValue.
                      toLowerCase(
                        ).
                      endsWith(
                        "f")) {
                    rectValue +=
                      "f";
                }
                java.util.StringTokenizer st =
                  new java.util.StringTokenizer(
                  rectValue,
                  ",");
                if (st.
                      countTokens(
                        ) ==
                      4) {
                    java.lang.String xStr =
                      st.
                      nextToken(
                        );
                    java.lang.String yStr =
                      st.
                      nextToken(
                        );
                    java.lang.String wStr =
                      st.
                      nextToken(
                        );
                    java.lang.String hStr =
                      st.
                      nextToken(
                        );
                    float x =
                      java.lang.Float.
                        NaN;
                    float y =
                      java.lang.Float.
                        NaN;
                    float w =
                      java.lang.Float.
                        NaN;
                    float h =
                      java.lang.Float.
                        NaN;
                    try {
                        x =
                          java.lang.Float.
                            parseFloat(
                              xStr);
                        y =
                          java.lang.Float.
                            parseFloat(
                              yStr);
                        w =
                          java.lang.Float.
                            parseFloat(
                              wStr);
                        h =
                          java.lang.Float.
                            parseFloat(
                              hStr);
                    }
                    catch (java.lang.NumberFormatException e) {
                        
                    }
                    if (!java.lang.Float.
                          isNaN(
                            x) &&
                          !java.lang.Float.
                          isNaN(
                            y) &&
                          (!java.lang.Float.
                             isNaN(
                               w) &&
                             w >
                             0) &&
                          (!java.lang.Float.
                             isNaN(
                               h) &&
                             h >
                             0)) {
                        rect =
                          new java.awt.geom.Rectangle2D.Float(
                            x,
                            y,
                            w,
                            h);
                    }
                }
            }
            return rect;
        }
        public RectangleOptionHandler() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO39gG4M/iA2BYIw5UPm6K80HqkwpYD5sesau" +
           "TWhjmhxze3O+xXu7y+6cfXbqEiK1UKQiFBxCq+K/iNqkJERVo1ZqQVRVSqI0" +
           "jaBRmw81adU/mn4ghX9CK9qm783s3u7t2QeoUi3teG/mzXvz3vvNb97s+euk" +
           "yrZIh0n1FI3ycZPZ0X5876eWzVJdGrXtvdCbUI7/8dThm7+pPRIm1UNkfoba" +
           "vQq12U6VaSl7iCxVdZtTXWH2HsZSOKPfYjazRilXDX2ItKh2T9bUVEXlvUaK" +
           "ocA+asVJE+XcUpM5znocBZwsi4vVxMRqYluDAp1xUq8Y5rg3YXHRhC7fGMpm" +
           "PXs2J43xg3SUxnJc1WJx1eadeYusNQ1tfFgzeJTlefSg9qATiN3xB0vC0PFS" +
           "w8e3TmYaRRgWUF03uHDRHmC2oY2yVJw0eL07NJa1D5GvkYo4mesT5iQSd43G" +
           "wGgMjLr+elKw+nlMz2W7DOEOdzVVmwouiJPlxUpMatGso6ZfrBk01HDHdzEZ" +
           "vG0veOumO+Di02tjU8881vjDCtIwRBpUfRCXo8AiOBgZgoCybJJZ9tZUiqWG" +
           "SJMOCR9klko1dcLJdrOtDuuU5wACbliwM2cyS9j0YgWZBN+snMINq+BeWoDK" +
           "+VWV1ugw+Nrq+So93In94GCdCguz0hSw50ypHFH1lMBR8YyCj5EvgABMnZNl" +
           "PGMUTFXqFDpIs4SIRvXh2CCATx8G0SoDIGgJrM2iFGNtUmWEDrMEJ4uCcv1y" +
           "CKRqRSBwCictQTGhCbK0OJAlX36u79l04nG9Ww+TEKw5xRQN1z8XJrUFJg2w" +
           "NLMY7AM5sX5N/DRtvXgsTAgItwSEpcyPv3pjy7q2y69KmSUzyPQlDzKFJ5Rz" +
           "yflX7+ta/dkKXEaNadgqJr/Ic7HL+p2RzrwJTNNa0IiDUXfw8sAvH3niefa3" +
           "MKnrIdWKoeWygKMmxciaqsasXUxnFuUs1UNqmZ7qEuM9ZA68x1Wdyd6+dNpm" +
           "vIdUaqKr2hC/IURpUIEhqoN3VU8b7rtJeUa8501CyBJ4SDs8PyPyT/znJB3L" +
           "GFkWowrVVd2I9VsG+o8JFZzDbHhPwahpxJKA/5H1G6IbY7aRswCQMcMajlFA" +
           "RYbJQfhh2jGL2gAmdYJZsV6q6lHEm/l/s5RHnxeMhUKQjvuCZKDBPuo2tBSz" +
           "EspUbtuOGy8mXpdAw83hRIuTTWAuKs1Fhbkomot65qJoLjIA64dtpLE+E7Pc" +
           "DY5ANkkoJIzfg6uROIAsjgAfACHXrx58dPeBYx0VAEBzrBJSgKKrSg6oLo84" +
           "XLZPKOevDtx8842658MkDNyShAPKOyUiRaeEPOQsQ2EpoKnZzguXM2OznxAz" +
           "roNcPjN2ZN/hT4t1+IkfFVYBZ+H0fqTrgolIcMPPpLfh6IcfXzg9aXhbv+gk" +
           "cQ/AkpnIKB3BVAedTyhr2unLiYuTkTCpBJoCauaQRGS9tqCNImbpdFkafakB" +
           "h9OGlaUaDrnUWsczljHm9QgMNmHTIuGIcAgsUBD85wbNs2//+i/3i0i6Z0GD" +
           "7xAfZLzTxz+orFkwTZOHrr0WYyD3+zP9p56+fnS/gBZIrJjJYATbLuAdyA5E" +
           "8OuvHnrng/fPvRX24MjhAM4loZbJC1/u+QT+QvD8Bx/kDOyQ3NHc5RBYe4HB" +
           "TLS8ylsbcJkGuwTBEXlYB/CpaZUmNYZ74V8NKze8/PcTjTLdGvS4aFl3ewVe" +
           "/73byBOvP3azTagJKXiWevHzxCRBL/A0b7UsOo7ryB+5tvTbV+hZoHqgVxv2" +
           "t2BMIuJBRAIfELGIifb+wNhD2ERsP8aLt5Gv5kkoJ9/6aN6+jy7dEKstLpr8" +
           "ee+lZqdEkcwCGHuEOE0Rg+Noq4ntwjysYWGQdLqpnQFlD1ze85VG7fItMDsE" +
           "ZhXgVLvPAh7MF0HJka6a8+7Pf9F64GoFCe8kdZpBUzup2HCkFpDO7AxQaN78" +
           "/Ba5jrEaaBpFPEhJhDDoy2ZO546syUUCJn6y8Eebvjf9vkChhN0SZ7r4sVK0" +
           "n8JmreivwNd1nNTQJHABLA1Aa4s6Ll8Il5i/uEy4iu1YZOlsNYmop849OTWd" +
           "6nt2g6wcmovP+R1Qxr7w23//KnrmD6/NcJxUOzWlZ7AC7C0vIf1eUa95hLXx" +
           "2s2K955aVF/K96ipbRY2XzM7mwcNXHnyr4v3bs4cuAsiXxaIUlDlc73nX9u1" +
           "SnkqLEpOyeElpWrxpE5/vMCoxaC21tEt7JkntkFHIa8NmK/t8Fx08noxuA0k" +
           "484InJAAjgcSRC6ZX0ZZYN+HhZaw+L0IrlsC2FhKR2Up7Q6sv20BMbhvF5xk" +
           "o3D8wB7EWV8qQzGPYvNFTuozosSQ5QZAaHWZq52lZuHIGHWK49hk8wcj3/3w" +
           "BQnfYCUdEGbHpo5/Ej0xJaEsrxsrSip+/xx55RBrbcRmfV4AvIwVMWPnny9M" +
           "/vT7k0fDjp89nFSOGqq8smzEZkDmqvPOuAY7toju3kKKF+FQNzyvOCl+5S7w" +
           "EhZ4wWZ7ADQLy2gsD5p7BWjoGI8OMyMbLRSRn9mOAkNiOUYZMIhONQAG7Et6" +
           "YTv4P4dtOQ6tgeeK4+SVMmHDZm/pppptasC5kLc1vyy0Tpbx/jA2eU5qTbzY" +
           "Y/DcuC6bNa5Q9BiUe9EZv/vogMXWmct91/zKO7ozwLZYVPKFQt6qlRenG2oW" +
           "Tj/8O1GfFm6+9VD+pXOa5mNIP1tWmxZLqyI09bJgMMW/45y0325FHLi28EP4" +
           "8U05+VtwdZ9xMuxP/OeXPQk0GJTlpEr898udAmueHByK8sUvcpqTChDB12dM" +
           "N66b7+wuNqhiZvZRLVecnnyotJ4QIGi5HQh8pcGKIp4VH6Lc4y8nP0UllAvT" +
           "u/c8fuOhZ2Upr2h0YgK1zI2TOfLCUDhCl8+qzdVV3b361vyXale6vFh0lfCv" +
           "TWAT9o4ouxcHals7Uihx3zm36dIbx6qvAaPvJyHKyYL9vs9A8psHFMg5ON/3" +
           "x/11ie9zpii7O+v+dODNf7wbaha1GpHX17ZyMxLKqUvv9adN8zthUttDqoD2" +
           "WX6I1Kn29nEdttQoVJU1OV09lGM9KcBz0sjphW9W83EXUDxZRWScgM4r9OIt" +
           "j5OO0rOp9OYLZewYs7ahdlFWBIqOnGn6R/P4LWcGryA3G87+8/A33u6DXVq0" +
           "cL+2OXYuWahf/J/EvILGOSYxi4D6RLzXNN2L1WaRVdMUzPMD4fRzUholOAmt" +
           "Mc3/AmNR7r3aFgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8838IPl/AZkhrY+uIgAA");
    }
    public abstract static class ColorOptionHandler extends org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler {
        public void handleOption(java.lang.String optionValue,
                                 org.apache.batik.apps.rasterizer.SVGConverter c) {
            java.awt.Color color =
              parseARGB(
                optionValue);
            if (color ==
                  null) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            handleOption(
              color,
              c);
        }
        public abstract void handleOption(java.awt.Color color,
                                          org.apache.batik.apps.rasterizer.SVGConverter c);
        public java.awt.Color parseARGB(java.lang.String argbVal) {
            java.awt.Color c =
              null;
            if (argbVal !=
                  null) {
                java.util.StringTokenizer st =
                  new java.util.StringTokenizer(
                  argbVal,
                  ".");
                if (st.
                      countTokens(
                        ) ==
                      4) {
                    java.lang.String aStr =
                      st.
                      nextToken(
                        );
                    java.lang.String rStr =
                      st.
                      nextToken(
                        );
                    java.lang.String gStr =
                      st.
                      nextToken(
                        );
                    java.lang.String bStr =
                      st.
                      nextToken(
                        );
                    int a =
                      -1;
                    int r =
                      -1;
                    int g =
                      -1;
                    int b =
                      -1;
                    try {
                        a =
                          java.lang.Integer.
                            parseInt(
                              aStr);
                        r =
                          java.lang.Integer.
                            parseInt(
                              rStr);
                        g =
                          java.lang.Integer.
                            parseInt(
                              gStr);
                        b =
                          java.lang.Integer.
                            parseInt(
                              bStr);
                    }
                    catch (java.lang.NumberFormatException e) {
                        
                    }
                    if (a >=
                          0 &&
                          a <=
                          255 &&
                          r >=
                          0 &&
                          r <=
                          255 &&
                          g >=
                          0 &&
                          g <=
                          255 &&
                          b >=
                          0 &&
                          b <=
                          255) {
                        c =
                          new java.awt.Color(
                            r,
                            g,
                            b,
                            a);
                    }
                }
            }
            return c;
        }
        public ColorOptionHandler() { super(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static java.lang.String USAGE =
      org.apache.batik.apps.rasterizer.Messages.
      formatMessage(
        "Main.usage",
        null);
    public static java.lang.String CL_OPTION_OUTPUT =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.output",
        "-d");
    public static java.lang.String CL_OPTION_OUTPUT_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.output.description",
        "No description");
    public static java.lang.String CL_OPTION_MIME_TYPE =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.mime.type",
        "-m");
    public static java.lang.String CL_OPTION_MIME_TYPE_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.mime.type.description",
        "No description");
    public static java.lang.String CL_OPTION_WIDTH =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.width",
        "-w");
    public static java.lang.String CL_OPTION_WIDTH_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.width.description",
        "No description");
    public static java.lang.String CL_OPTION_HEIGHT =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.height",
        "-h");
    public static java.lang.String CL_OPTION_HEIGHT_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.height.description",
        "No description");
    public static java.lang.String CL_OPTION_MAX_WIDTH =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.max.width",
        "-maxw");
    public static java.lang.String CL_OPTION_MAX_WIDTH_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.max.width.description",
        "No description");
    public static java.lang.String CL_OPTION_MAX_HEIGHT =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.max.height",
        "-maxh");
    public static java.lang.String CL_OPTION_MAX_HEIGHT_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.max.height.description",
        "No description");
    public static java.lang.String CL_OPTION_AOI =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.aoi",
        "-a");
    public static java.lang.String CL_OPTION_AOI_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.aoi.description",
        "No description");
    public static java.lang.String CL_OPTION_BACKGROUND_COLOR =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.background.color",
        "-bg");
    public static java.lang.String CL_OPTION_BACKGROUND_COLOR_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.background.color.description",
        "No description");
    public static java.lang.String CL_OPTION_MEDIA_TYPE =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.media.type",
        "-cssMedia");
    public static java.lang.String CL_OPTION_MEDIA_TYPE_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.media.type.description",
        "No description");
    public static java.lang.String CL_OPTION_DEFAULT_FONT_FAMILY =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.default.font.family",
        "-font-family");
    public static java.lang.String CL_OPTION_DEFAULT_FONT_FAMILY_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.default.font.family.description",
        "No description");
    public static java.lang.String CL_OPTION_ALTERNATE_STYLESHEET =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.alternate.stylesheet",
        "-cssAlternate");
    public static java.lang.String CL_OPTION_ALTERNATE_STYLESHEET_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.alternate.stylesheet.description",
        "No description");
    public static java.lang.String CL_OPTION_VALIDATE =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.validate",
        "-validate");
    public static java.lang.String CL_OPTION_VALIDATE_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.validate.description",
        "No description");
    public static java.lang.String CL_OPTION_ONLOAD =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.onload",
        "-onload");
    public static java.lang.String CL_OPTION_ONLOAD_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.onload.description",
        "No description");
    public static java.lang.String CL_OPTION_SNAPSHOT_TIME =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.snapshot.time",
        "-snapshotTime");
    public static java.lang.String CL_OPTION_SNAPSHOT_TIME_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.snapshot.time.description",
        "No description");
    public static java.lang.String CL_OPTION_LANGUAGE =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.language",
        "-lang");
    public static java.lang.String CL_OPTION_LANGUAGE_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.language.description",
        "No description");
    public static java.lang.String CL_OPTION_USER_STYLESHEET =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.user.stylesheet",
        "-cssUser");
    public static java.lang.String CL_OPTION_USER_STYLESHEET_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.user.stylesheet.description",
        "No description");
    public static java.lang.String CL_OPTION_DPI =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.dpi",
        "-dpi");
    public static java.lang.String CL_OPTION_DPI_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.dpi.description",
        "No description");
    public static java.lang.String CL_OPTION_QUALITY =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.quality",
        "-q");
    public static java.lang.String CL_OPTION_QUALITY_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.quality.description",
        "No description");
    public static java.lang.String CL_OPTION_INDEXED =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.indexed",
        "-indexed");
    public static java.lang.String CL_OPTION_INDEXED_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.indexed.description",
        "No description");
    public static java.lang.String CL_OPTION_ALLOWED_SCRIPTS =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.allowed.scripts",
        "-scripts");
    public static java.lang.String CL_OPTION_ALLOWED_SCRIPTS_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.allowed.scripts.description",
        "No description");
    public static java.lang.String CL_OPTION_CONSTRAIN_SCRIPT_ORIGIN =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.constrain.script.origin",
        "-anyScriptOrigin");
    public static java.lang.String CL_OPTION_CONSTRAIN_SCRIPT_ORIGIN_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.constrain.script.origin.description",
        "No description");
    public static java.lang.String CL_OPTION_SECURITY_OFF =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.security.off",
        "-scriptSecurityOff");
    public static java.lang.String CL_OPTION_SECURITY_OFF_DESCRIPTION =
      org.apache.batik.apps.rasterizer.Messages.
      get(
        "Main.cl.option.security.off.description",
        "No description");
    protected static java.util.Map optionMap =
      new java.util.HashMap(
      );
    protected static java.util.Map mimeTypeMap =
      new java.util.HashMap(
      );
    static { mimeTypeMap.put("image/jpg",
                             org.apache.batik.apps.rasterizer.DestinationType.
                               JPEG);
             mimeTypeMap.put("image/jpeg",
                             org.apache.batik.apps.rasterizer.DestinationType.
                               JPEG);
             mimeTypeMap.put("image/jpe",
                             org.apache.batik.apps.rasterizer.DestinationType.
                               JPEG);
             mimeTypeMap.put("image/png",
                             org.apache.batik.apps.rasterizer.DestinationType.
                               PNG);
             mimeTypeMap.put("application/pdf",
                             org.apache.batik.apps.rasterizer.DestinationType.
                               PDF);
             mimeTypeMap.put("image/tiff",
                             org.apache.batik.apps.rasterizer.DestinationType.
                               TIFF);
             optionMap.put(CL_OPTION_OUTPUT,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setDst(
                                       new java.io.File(
                                         optionValue));
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_OUTPUT_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_MIME_TYPE,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   org.apache.batik.apps.rasterizer.DestinationType dstType =
                                     (org.apache.batik.apps.rasterizer.DestinationType)
                                       mimeTypeMap.
                                       get(
                                         optionValue);
                                   if (dstType ==
                                         null) {
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   }
                                   c.
                                     setDestinationType(
                                       dstType);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_MIME_TYPE_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_WIDTH,
                           new org.apache.batik.apps.rasterizer.Main.FloatOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   if (optionValue <=
                                         0) {
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   }
                                   c.
                                     setWidth(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_WIDTH_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_HEIGHT,
                           new org.apache.batik.apps.rasterizer.Main.FloatOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   if (optionValue <=
                                         0) {
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   }
                                   c.
                                     setHeight(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_HEIGHT_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_MAX_WIDTH,
                           new org.apache.batik.apps.rasterizer.Main.FloatOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   if (optionValue <=
                                         0) {
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   }
                                   c.
                                     setMaxWidth(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_MAX_WIDTH_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_MAX_HEIGHT,
                           new org.apache.batik.apps.rasterizer.Main.FloatOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   if (optionValue <=
                                         0) {
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   }
                                   c.
                                     setMaxHeight(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_MAX_HEIGHT_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_AOI,
                           new org.apache.batik.apps.rasterizer.Main.RectangleOptionHandler(
                             ) {
                               public void handleOption(java.awt.geom.Rectangle2D optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setArea(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_AOI_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_BACKGROUND_COLOR,
                           new org.apache.batik.apps.rasterizer.Main.ColorOptionHandler(
                             ) {
                               public void handleOption(java.awt.Color optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setBackgroundColor(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_BACKGROUND_COLOR_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_MEDIA_TYPE,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setMediaType(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_MEDIA_TYPE_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_DEFAULT_FONT_FAMILY,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setDefaultFontFamily(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_DEFAULT_FONT_FAMILY_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_ALTERNATE_STYLESHEET,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setAlternateStylesheet(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_ALTERNATE_STYLESHEET_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_USER_STYLESHEET,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setUserStylesheet(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_USER_STYLESHEET_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_LANGUAGE,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setLanguage(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_LANGUAGE_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_DPI,
                           new org.apache.batik.apps.rasterizer.Main.FloatOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   if (optionValue <=
                                         0) {
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   }
                                   c.
                                     setPixelUnitToMillimeter(
                                       2.54F /
                                         optionValue *
                                         10);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_DPI_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_QUALITY,
                           new org.apache.batik.apps.rasterizer.Main.FloatOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   if (optionValue <=
                                         0 ||
                                         optionValue >=
                                         1) {
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   }
                                   c.
                                     setQuality(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_QUALITY_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_INDEXED,
                           new org.apache.batik.apps.rasterizer.Main.FloatOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   if (optionValue !=
                                         1 &&
                                         optionValue !=
                                         2 &&
                                         optionValue !=
                                         4 &&
                                         optionValue !=
                                         8)
                                       throw new java.lang.IllegalArgumentException(
                                         );
                                   c.
                                     setIndexed(
                                       (int)
                                         optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_INDEXED_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_VALIDATE,
                           new org.apache.batik.apps.rasterizer.Main.NoValueOptionHandler(
                             ) {
                               public void handleOption(org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setValidate(
                                       true);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_VALIDATE_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_ONLOAD,
                           new org.apache.batik.apps.rasterizer.Main.NoValueOptionHandler(
                             ) {
                               public void handleOption(org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setExecuteOnload(
                                       true);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_ONLOAD_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_SNAPSHOT_TIME,
                           new org.apache.batik.apps.rasterizer.Main.TimeOptionHandler(
                             ) {
                               public void handleOption(float optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setExecuteOnload(
                                       true);
                                   c.
                                     setSnapshotTime(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_SNAPSHOT_TIME_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_ALLOWED_SCRIPTS,
                           new org.apache.batik.apps.rasterizer.Main.SingleValueOptionHandler(
                             ) {
                               public void handleOption(java.lang.String optionValue,
                                                        org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setAllowedScriptTypes(
                                       optionValue);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_ALLOWED_SCRIPTS_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_CONSTRAIN_SCRIPT_ORIGIN,
                           new org.apache.batik.apps.rasterizer.Main.NoValueOptionHandler(
                             ) {
                               public void handleOption(org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setConstrainScriptOrigin(
                                       false);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_CONSTRAIN_SCRIPT_ORIGIN_DESCRIPTION;
                               }
                           });
             optionMap.put(CL_OPTION_SECURITY_OFF,
                           new org.apache.batik.apps.rasterizer.Main.NoValueOptionHandler(
                             ) {
                               public void handleOption(org.apache.batik.apps.rasterizer.SVGConverter c) {
                                   c.
                                     setSecurityOff(
                                       true);
                               }
                               public java.lang.String getOptionDescription() {
                                   return CL_OPTION_SECURITY_OFF_DESCRIPTION;
                               }
                           }); }
    protected java.util.List args;
    public Main(java.lang.String[] args) {
        super(
          );
        this.
          args =
          new java.util.ArrayList(
            );
        for (int i =
               0;
             i <
               args.
                 length;
             i++) {
            this.
              args.
              add(
                args[i]);
        }
    }
    protected void error(java.lang.String errorCode,
                         java.lang.Object[] errorArgs) {
        java.lang.System.
          err.
          println(
            org.apache.batik.apps.rasterizer.Messages.
              formatMessage(
                errorCode,
                errorArgs));
    }
    public static final java.lang.String ERROR_NOT_ENOUGH_OPTION_VALUES =
      "Main.error.not.enough.option.values";
    public static final java.lang.String ERROR_ILLEGAL_ARGUMENT =
      "Main.error.illegal.argument";
    public static final java.lang.String ERROR_WHILE_CONVERTING_FILES =
      "Main.error.while.converting.files";
    public void execute() { org.apache.batik.apps.rasterizer.SVGConverter c =
                              new org.apache.batik.apps.rasterizer.SVGConverter(
                              this);
                            java.util.List sources =
                              new java.util.ArrayList(
                              );
                            int nArgs = args.
                              size(
                                );
                            for (int i = 0;
                                 i <
                                   nArgs;
                                 i++) { java.lang.String v =
                                          (java.lang.String)
                                            args.
                                            get(
                                              i);
                                        org.apache.batik.apps.rasterizer.Main.OptionHandler optionHandler =
                                          (org.apache.batik.apps.rasterizer.Main.OptionHandler)
                                            optionMap.
                                            get(
                                              v);
                                        if (optionHandler ==
                                              null) {
                                            sources.
                                              add(
                                                v);
                                        }
                                        else {
                                            int nOptionArgs =
                                              optionHandler.
                                              getOptionValuesLength(
                                                );
                                            if (i +
                                                  nOptionArgs >=
                                                  nArgs) {
                                                error(
                                                  ERROR_NOT_ENOUGH_OPTION_VALUES,
                                                  new java.lang.Object[] { v,
                                                  optionHandler.
                                                    getOptionDescription(
                                                      ) });
                                                return;
                                            }
                                            java.lang.String[] optionValues =
                                              new java.lang.String[nOptionArgs];
                                            for (int j =
                                                   0;
                                                 j <
                                                   nOptionArgs;
                                                 j++) {
                                                optionValues[j] =
                                                  (java.lang.String)
                                                    args.
                                                    get(
                                                      1 +
                                                        i +
                                                        j);
                                            }
                                            i +=
                                              nOptionArgs;
                                            try {
                                                optionHandler.
                                                  handleOption(
                                                    optionValues,
                                                    c);
                                            }
                                            catch (java.lang.IllegalArgumentException e) {
                                                e.
                                                  printStackTrace(
                                                    );
                                                error(
                                                  ERROR_ILLEGAL_ARGUMENT,
                                                  new java.lang.Object[] { v,
                                                  optionHandler.
                                                    getOptionDescription(
                                                      ),
                                                  toString(
                                                    optionValues) });
                                                return;
                                            }
                                        }
                            }
                            org.apache.batik.util.ApplicationSecurityEnforcer securityEnforcer =
                              new org.apache.batik.util.ApplicationSecurityEnforcer(
                              this.
                                getClass(
                                  ),
                              RASTERIZER_SECURITY_POLICY);
                            securityEnforcer.
                              enforceSecurity(
                                !c.
                                  getSecurityOff(
                                    ));
                            java.lang.String[] expandedSources =
                              expandSources(
                                sources);
                            c.setSources(
                                expandedSources);
                            validateConverterConfig(
                              c);
                            if (expandedSources ==
                                  null ||
                                  expandedSources.
                                    length <
                                  1) { java.lang.System.
                                         out.
                                         println(
                                           USAGE);
                                       java.lang.System.
                                         out.
                                         flush(
                                           );
                                       securityEnforcer.
                                         enforceSecurity(
                                           false);
                                       return;
                            }
                            try { c.execute(
                                      ); }
                            catch (org.apache.batik.apps.rasterizer.SVGConverterException e) {
                                error(
                                  ERROR_WHILE_CONVERTING_FILES,
                                  new java.lang.Object[] { e.
                                    getMessage(
                                      ) });
                            }
                            finally { java.lang.System.
                                        out.
                                        flush(
                                          );
                                      securityEnforcer.
                                        enforceSecurity(
                                          false);
                            } }
    protected java.lang.String toString(java.lang.String[] v) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        int n =
          v !=
          null
          ? v.
              length
          : 0;
        for (int i =
               0;
             i <
               n;
             i++) {
            sb.
              append(
                v[i]);
            sb.
              append(
                ' ');
        }
        return sb.
          toString(
            );
    }
    public void validateConverterConfig(org.apache.batik.apps.rasterizer.SVGConverter c) {
        
    }
    protected java.lang.String[] expandSources(java.util.List sources) {
        java.util.List expandedSources =
          new java.util.ArrayList(
          );
        java.util.Iterator iter =
          sources.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String v =
              (java.lang.String)
                iter.
                next(
                  );
            java.io.File f =
              new java.io.File(
              v);
            if (f.
                  exists(
                    ) &&
                  f.
                  isDirectory(
                    )) {
                java.io.File[] fl =
                  f.
                  listFiles(
                    new org.apache.batik.apps.rasterizer.SVGConverter.SVGFileFilter(
                      ));
                for (int i =
                       0;
                     i <
                       fl.
                         length;
                     i++) {
                    expandedSources.
                      add(
                        fl[i].
                          getPath(
                            ));
                }
            }
            else {
                expandedSources.
                  add(
                    v);
            }
        }
        java.lang.String[] s =
          new java.lang.String[expandedSources.
                                 size(
                                   )];
        expandedSources.
          toArray(
            s);
        return s;
    }
    public static void main(java.lang.String[] args) {
        panda.runtime.PANDA_Util.
          initModeFile(
            );
        panda.runtime.PANDA_Util.
          startStopwatch(
            );
        double[] before =
          jrapl.EnergyCheckUtils.
          getEnergyStats(
            );
        try {
            new org.apache.batik.apps.rasterizer.Main(
              args).
              execute(
                );
        }
        catch (java.lang.Exception e) {
            
        }
        finally {
            panda.runtime.PANDA_Util.
              stopStopwatch(
                );
            double[] after =
              jrapl.EnergyCheckUtils.
              getEnergyStats(
                );
            panda.runtime.PANDA_Util.
              writeModeFile(
                java.lang.String.
                  format(
                    "Energy: %f %f %f\n",
                    after[0] -
                      before[0],
                    after[1] -
                      before[1],
                    after[2] -
                      before[2]));
            panda.runtime.PANDA_Util.
              writeModeFile(
                java.lang.String.
                  format(
                    "Time: %s\n",
                    panda.runtime.PANDA_Util.
                      elapsedTime(
                        )));
            panda.runtime.PANDA_Util.
              closeModeFile(
                );
            jrapl.EnergyCheckUtils.
              DeallocProfile(
                );
        }
        java.lang.System.
          exit(
            0);
    }
    public static final java.lang.String MESSAGE_ABOUT_TO_TRANSCODE =
      "Main.message.about.to.transcode";
    public static final java.lang.String MESSAGE_ABOUT_TO_TRANSCODE_SOURCE =
      "Main.message.about.to.transcode.source";
    public static final java.lang.String MESSAGE_CONVERSION_FAILED =
      "Main.message.conversion.failed";
    public static final java.lang.String MESSAGE_CONVERSION_SUCCESS =
      "Main.message.conversion.success";
    public boolean proceedWithComputedTask(org.apache.batik.transcoder.Transcoder transcoder,
                                           java.util.Map hints,
                                           java.util.List sources,
                                           java.util.List dest) {
        java.lang.System.
          out.
          println(
            org.apache.batik.apps.rasterizer.Messages.
              formatMessage(
                MESSAGE_ABOUT_TO_TRANSCODE,
                new java.lang.Object[] { "" +
                sources.
                  size(
                    ) }));
        return true;
    }
    public boolean proceedWithSourceTranscoding(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                                java.io.File dest) {
        java.lang.System.
          out.
          print(
            org.apache.batik.apps.rasterizer.Messages.
              formatMessage(
                MESSAGE_ABOUT_TO_TRANSCODE_SOURCE,
                new java.lang.Object[] { source.
                  toString(
                    ),
                dest.
                  toString(
                    ) }));
        return true;
    }
    public boolean proceedOnSourceTranscodingFailure(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                                     java.io.File dest,
                                                     java.lang.String errorCode) {
        java.lang.System.
          out.
          println(
            org.apache.batik.apps.rasterizer.Messages.
              formatMessage(
                MESSAGE_CONVERSION_FAILED,
                new java.lang.Object[] { errorCode }));
        return true;
    }
    public void onSourceTranscodingSuccess(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                           java.io.File dest) {
        java.lang.System.
          out.
          println(
            org.apache.batik.apps.rasterizer.Messages.
              formatMessage(
                MESSAGE_CONVERSION_SUCCESS,
                null));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5ptHx9n/B3QfUoLGVQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "29ggn7mJNgyM8MyF0RcuboRXtlne6wS+c4zwhEBhvM4qzBr98iWN8IREvIgg" +
       "4OoZIu3nzhVp/dw17a2lg/pBIat1+8WYnms7ymNHScvSRsTHbKd+BlCWInyT" +
       "QCBiuuc4k5fyXOOJ7/vvb/7ID7zo4/tZHtOt6wkERDwnst3pOPsC33c99daH" +
       "nvaWT3zf+qsUYBrtvw2771WZWPdcUNWZWPx6TFFyGPXW337Q1Eyy9SPQE/J0" +
       "wATtAMRLSxs9/6lOJSTgox+qqCBldlIcz/JTM50oXJ0x0pSw0kSpMyPHYUdE" +
       "gDE+EcYlC1mO+aFMwIlpy4NlMBUGwkyOMH7QEgoGUR2KXnXaJo0pzbQjQiyw" +
       "vQbij9kIVeOEJXGn35HLsORrYyksFbqU2nJ6XtjPN5WaVJXJOiagbpHhqt0e" +
       "pOchCGoG0EKPh303oSPPJefGatJlE9jPL7BwIA0bi7xaCUhyPkI1sS2J5VZp" +
       "KMySWlNblPUw1vGhVuzYcNdrEHOjiYuYxJRpqz8PGa8/qxrevM1Ox+KoRo66" +
       "QrHWljDJ4QpIOp21YYG1/cIYrw6X8bTRa4rOaIrqXrs7ms8Q0whiBbPaFtOD" +
       "Mdnl5GkB5n2awM2o0Kq2sZThF9hi0evpIjHgK1w0Z2qLlWiTYyxaenUTg7kq" +
       "RLZkrN6u82I7GPMORNbNBSE0R4Zbj/KT/pjwKv2yP3M4b6DXoGKZzcedsYMU" +
       "hZZKttipgOBzRMKlhr3AJi2+WJvpqDZsi+VRPY/pM0smSLMnjqOCQAkwCtMw" +
       "3UuGQUHi0WaXanEddkW2jUYs4jGY/VnL5gYjK5zDoNVVj6qKYxLlbNMvlloB" +
       "S5Elm6oGYxiiA3JJ4IthSjnDcuKpLFKsGn6XmFZws4fCYxgWSa/CWJ4np/ik" +
       "XYcReWAgaLcgOt08l8bVWdGvzaqVEQlbeRgZTwbstCCNJcTsDyXV4BVk1kbp" +
       "kWgFS3NuCqEE2eaCQno4os4HfQnryHxjiSy7rIaQYg/Jt+pBIYAjqWHy/ZQq" +
       "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" +
       "00knoPsR1xOW81E6Z+p6vRX0FwNd041J");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "RoY8/2UAAA==");
}
