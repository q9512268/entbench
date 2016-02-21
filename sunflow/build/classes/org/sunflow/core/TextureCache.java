package org.sunflow.core;
public final class TextureCache {
    private static java.util.HashMap<java.lang.String,org.sunflow.core.Texture>
      textures =
      new java.util.HashMap<java.lang.String,org.sunflow.core.Texture>(
      );
    private TextureCache() { super(); }
    public static synchronized org.sunflow.core.Texture getTexture(java.lang.String filename,
                                                                   boolean isLinear) {
        if (textures.
              containsKey(
                filename)) {
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  TEX,
                "Using cached copy for file \"%s\" ...",
                filename);
            return textures.
              get(
                filename);
        }
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              TEX,
            "Using file \"%s\" ...",
            filename);
        org.sunflow.core.Texture t =
          new org.sunflow.core.Texture(
          filename,
          isLinear);
        textures.
          put(
            filename,
            t);
        return t;
    }
    public static synchronized void flush() { org.sunflow.system.UI.
                                                printInfo(
                                                  org.sunflow.system.UI.Module.
                                                    TEX,
                                                  "Flushing texture cache");
                                              textures.clear(
                                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "w+DO9AqHun8DnnCfrGccAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6eezryFl+v/f27duj+97u0nZZ9mxfgdbwcxLHOVigdZzT" +
       "sRMnPhOgr77jxPcRO4btJaAViLai21JQWQmp3C1FiAICFRYhoOWSihBQJFqE" +
       "kChHJfoHhyjX2Pnd+96WFhHJ48nMfN9893wz4w9/HrorCiHY9+ydaXvxoZ7F" +
       "h2sbO4x3vh4dkhTGyGGka4QtRxEH2m6pr/r56//yxfesbhxAV5fQw7LrerEc" +
       "W54bzfXIs7e6RkHXT1t7tu5EMXSDWstbGUliy0YoK4qfoaD7zoDG0E3qmAQE" +
       "kIAAEpCSBAQ/HQWAXqa7iUMUELIbRwH0ZugSBV311YK8GHr6PBJfDmXnCA1T" +
       "cgAwXCv+C4CpEjgLoadOeN/z/CKG3wcjz/3QG2/8wmXo+hK6brlsQY4KiIjB" +
       "JEvofkd3FD2McE3TtSX0oKvrGquHlmxbeUn3EnooskxXjpNQPxFS0Zj4eljO" +
       "eSq5+9WCtzBRYy88Yc+wdFs7/neXYcsm4PUVp7zuOewX7YDBey1AWGjIqn4M" +
       "cmVjuVoMPXkR4oTHm2MwAIDe7ejxyjuZ6oorgwboob3ubNk1ETYOLdcEQ+/y" +
       "EjBLDD16R6SFrH1Z3cimfiuGHrk4jtl3gVH3lIIoQGLo5ReHlZiAlh69oKUz" +
       "+vn85Jvf9Z3u0D0oadZ01S7ovwaAnrgANNcNPdRdVd8D3v866v3yKz7+zgMI" +
       "AoNffmHwfswvf9cX3vANT7zwif2Yr7nNmKmy1tX4lvoh5YFPPUa8tn25IOOa" +
       "70VWofxznJfmzxz1PJP5wPNecYKx6Dw87nxh/juLt/6M/g8H0L0j6Krq2YkD" +
       "7OhB1XN8y9bDge7qoRzr2gi6R3c1ouwfQXeDOmW5+r51ahiRHo+gK3bZdNUr" +
       "/wMRGQBFIaK7Qd1yDe+47svxqqxnPgRBLwMP9BB47of2v/IdQxKy8hwdkVXZ" +
       "tVwPYUKv4L9QqKvJSKxHoK6BXt9DosQ1bC9FolBFvNA8+a96oY5wwHuARxCy" +
       "utIPCwvz/x9xZwVfN9JLl4DIH7vo8DbwlaFna3p4S30u6fS+8HO3fv/gxAGO" +
       "JBJDj4NpDo+mOSymOTw7DXTpUon9q4rp9soEqtgApwbh7v7Xst9Bvumdr7oM" +
       "rMhPrwA5FkORO0dd4jQMjMpgpwJbhF74QPo24S2VA+jgfPgsSARN9xbgTBH0" +
       "ToLbzYtuczu819/xuX/56Puf9U4d6Fw8PvLrF0MWfvmqi8IMPVXXgFBO0b/u" +
       "Kfljtz7+7M0D6ApwdhDgYhkYJIgdT1yc45x/PnMc6wpe7gIMG17oyHbRdRyg" +
       "7o1XoZeetpRafqCsP3hssI+A5/qRBZfvovdhvyi/am8VhdIucFHG0m9h/R/9" +
       "8z/6O7QU93HYvX5mIWP1+Jkzrl4gu1469YOnNsCFug7G/eUHmPe+7/Pv+LbS" +
       "AMCIV99uwptFSQAXByoEYv6eTwSf/uxnPvQnB6dGE0N3+6G1BZ6fnXBZdED3" +
       "vQSXYLqvPSUIxAob+FRhNjd51/E0y7BkxdYLM/2P66+pfuwf33Vjbwg2aDm2" +
       "o2/40ghO27+6A73199/4r0+UaC6pxVp1KrTTYfsA+PApZjwM5V1BR/a2P378" +
       "h39X/lEQSkH4iqxcLyMSVAoBKrWGlPy/riwPL/RVi+LJ6Kz1n3ewMznFLfU9" +
       "f/JPLxP+6de/UFJ7Pik5q2xa9p/Z21dRPJUB9K+86OpDOVqBcfUXJt9+w37h" +
       "iwDjEmBUwUocTUMQXrJzpnE0+q67/+I3f+sVb/rUZeigD91re7LWl0svg+4B" +
       "5q1HKxCZMv/1b9grN70Gihslq9CLmN8bxSPlvyuAwNfeOcD0i5zi1Ecf+fep" +
       "rbz9r//tRUIoQ8ttltIL8Evkwx98lPjWfyjhT328gH4ie3HIBfnXKWztZ5x/" +
       "PnjV1d8+gO5eQjfUo+ROkO2k8JwlSGii44wPJIDn+s8nJ/uV+JmTGPbYxfhy" +
       "ZtqL0eU01IN6Mbqo33shoDxcSFk4XhuP32cDyiWorLy+BHm6LG8WxdeVOjko" +
       "ql8fQ1ejMoU88uH/Br9L4Pmv4ikQFg37tfYh4mjBf+pkxffBSnQt3i88EdDx" +
       "6+6sYzZRovhMovQD1vN/+Hv/fP1t+1zmvHGUufIR6EW4T//55dp98c13l4Hw" +
       "iiJHpXCuAQlGxcgYeurOeXeJa+84952yC92e3VeeutuRcxyWmb3v70X18vg2" +
       "/lN00EAQT38JQdxSR84t9mOffkejNNLrWwuEbV3jjrYD56PU6dL9zLktwm1F" +
       "dUv93Ed/4BNP/73wcJn77aVSkIWCCFe8G0fee7n03tISAMGvuQPBRxSVQfWW" +
       "+l0f/K8//LtnP/PJy9BVsOAVhi2HIO8DieXhnbZMZxHc5ECtC6CAwT+whwYJ" +
       "fKncIyU+dNJ6snbH0DfeCXexI7y4xBebDpAT6WHHS1yt9PnzDnVv4vtne0tz" +
       "uP//Yg5vBkvS/0J8J9wf+WuRzwJ9PlAaUREzDntgP3m2E3jXwwSFs+wtbsH0" +
       "bgn4fIR3qF5pZIXrXRKOLfHGKZJ94Dmx0UfulCiWA7iikEoRfPsp2nFRvZXd" +
       "Bvl+y3UutkNHiUtR1oriDfte7I6rxDcVRTe7BDKIu2qHzcNK8X99+yh1GQQo" +
       "P1FsSy3aCABhWK5sl3N2C63Y6s3juCSAjS9YJm6u7WbRrV+gq/u/pis6pxXK" +
       "A5vM7/+b9/zBu1/9WeCtJHTXtgj3QHVnBDNJin339374fY/f99xffX+ZJYEU" +
       "ifli/htfX2CN7sBdUS1zNaIovGO2Hi3YYr0kVHVKjmK6zGt0reDspVdSJrQc" +
       "kP9tjzaVyLMPfXbzwc99ZB9kLy6bFwbr73zu+/778F3PHZzZpr/6RTvlszD7" +
       "rXpJ9MuOJHw29N1mlhKi/7cfffbXfurZd+ypeuj8prPwgY/86X/+weEH/uqT" +
       "t9n3XLGBNr5ixcbXuWE9GuHHP0pYdsVUzeaiPkVaTS6qIzA7yVx6npmrnBga" +
       "LZ7Dh0OS5sgpZ1sLjKcwhdKdJo3WtFjTEiOKWgN+Phpv2O6AX/kdcSSMwwo+" +
       "43v2TDD5YBXI4Y5v4Cyzq21iJuPteWAG45kQj0YiHDfpZoIyKOfYAotq6CSn" +
       "ndzI0TBHt4YxmOetjbBckrVgPfCcXPX6y8paXbAbx51ro1Ygagt8PZY28C7Z" +
       "bNvVipxM7IUw1khqMiDHMWNbu4YQ9IPaJmDnC9+heYcLFHFeWbMJS655L5G9" +
       "rDPXWGyEWbGoTIR5X7Atww2WI5qwlqo22tDiIpjl9kCvVQZrYjdOK7aFEGzW" +
       "TDoVAUsrO8rLmj7FtLEuqg/kGZ1skyU3ZAeTlrPmg2zYZ3ixv8vEvqGTU3WR" +
       "rD04nHoRu6WjZFNr1/pKB96u+3PW94yc2+1EA11357u+Mh85wSKn/EbVEYLG" +
       "dBNy6pzM5m3dmwy2Gjeor/tSb5dWGJrtGWqNmw2c1tLkK5psp/6UwSZBIu6Y" +
       "PBJW3UALZq1Fl1YoPm+xM46ww6jipnQ6HYqOQuUrvRv3onHF9HyrwraaWL5A" +
       "t/FW3marzmKzYXluDm97dXq1I1J2SfLEetK1h1xj03BlziedNVtvDrFg7I8D" +
       "bmKiqJj6KRb2VLfbXtt+Sg+02QZG/IYZJj1xlqs5xeULsj4QsVk7gIM14U3M" +
       "RpZLgtNfDeJsiLORAHfM5WZBJM2pJAwwKe7O1ladDok1WVNwnBD7AeeLWY+q" +
       "ZULAb9IZGfQt2WInqzzstBlu5Q0qrKl2Jx17yZMLvxEHM2yKsnSvtprPFK/n" +
       "jMbBNKiPXJwcoVNiSaYcOhkTKVHFmonRXQsajcrjuNIabToDbcpX3X6rBeNz" +
       "sdaZL2N/5Xs80sMjpW8u0Z0xMUQfdTq46a5os79mGRQNGw1biEmszk3wmKoM" +
       "Urm2Wdq2P2K6arWRKKLbao7GTA9sL4VoLIUYoyaYTUiJM6618DRKYxX4XdCd" +
       "YIstnU/aOUwzFZOb+k1WEaOguYlq/QEXDtTJXJacWGDXfjT3Et/geeBLKaw1" +
       "2Rlaqdf9QaZbDkfLVkhqfODuPDHRkRnPLxejXhB4Ouw5QsWvtUfKiENb6WK1" +
       "JJYttjtpDbx1vd6GaYOo1DxH8zlyZHPasCLSFM9LjRZPVOJsblU9Eh6I/JQR" +
       "uU3swf6aVhN+0fQwiTHjxk6edBdd1OwZFZYZjdbyuD8w2kPUdfigxkd9fCzE" +
       "6UKTTMEQZZBWi4GDUTWsKsbTYSVpj0YpOVS7IjHAU6UzrcZ115rYw+3EmvH1" +
       "OHPrqGLRSS+IvQmHN7yaxiwRw0BFVK8Ii540EAnJ6/GuYmgDO0OEVqeBcS0b" +
       "kbbodpVELiWlNY4edbu93kzqw6yk93Ddw6b+Lp9Nst1m2DabZqaCvKW1yTcd" +
       "ppmhC9pI6JZhLrayxXTHJq5KJIaHRDWqzIeVqk22Rs14akhkC21wCRxUtt3u" +
       "eh7UTDvd9JstvNFNA2Nj88kmq5IMJ8k9lhXM7hQPNi2cwSlKNt1tfTEeUqZg" +
       "8f580cuTlSPYZLaLhn19vbQaDpMQXT0h44bRNNakwax6Cm2s0NxsVludmrvu" +
       "DGJSxPudnNi2/S3DdAdhu9HcjLfKzEhGZCVH+bZiz+arTTXaZT69qW5nA44P" +
       "uk3EaPZiGGmqE1VUXA2P5JxfrdBF2yR2aUcknKRdbyYypzTb1QYlpnIjoasd" +
       "y8HdDZXP9U2Gb3aLzPMXSiQ0vR7u2fN0ybHKOomqdC+yvcqqO95IW3igbWDD" +
       "YRDJCfi5RRDWdDqUKw06naDIOBcwZiEpW785qKncZt3vJRs/3824BCRgalKp" +
       "coNIy7Gh3ooSs5lXPAYfjbqyHY47UwFnKZMlKLhqNdctWsP0AWk1O2Q03dW2" +
       "bcM0cr878uFlU2J8D4MnQ85HbB9RnFm7STXJ8YSqddTaDmFww67PFtqSrJrr" +
       "mSTNrXq9Nml4LmMOaHZKBzO8bylcj6hu6VZFmQaBEyNwc6rlcRNTZyoZskot" +
       "YGGn2tuqO940HE6uzHGabamaJNRdaigHfR8bj9lR0p+79ZhC26wc0oO6Yum6" +
       "w+jrcVo3jFGs2AphrWa8qTB8Z6TChsS1YXgiUAaK1kVkO5jjXELhbd2UpJxp" +
       "1zbdBLhxDo/7dLYKKvNar28Z606lHY277s5E6vpKRVRG3BnDHo8v5tVqtZmq" +
       "jLJWh9sq1RpvyM1GXnKxMVxy/HDo2z13VNmBdW8kG9Xc2ObUsq9qHSmNOHEk" +
       "LbHYbK3tuYV4o1yqLVMFD0xhq05wst1qoP1GRqyGeoLxsdiiFpxTlVpwRC2Y" +
       "pT6XvdjNZv2WTDYG9GLCS/ScIbAhOZn1otXWz2eZsl6zxrxSa0fOdtheIFVe" +
       "7JGKNef1erBxDSyj3bjiETBV60VsR2G6o7oQYrme5kY2o3IryGaT7mQ6pxQa" +
       "WTfilYoxsWaxHSzVphGZTFAnItT6BA+qBt5HOt2GUU8NIZ1pdWEtMZrkKjN5" +
       "2gq6PVpj7D5jqqS1DZMsXjYMKbHYZdZaShuGYJuql2WtxlI15qjMq1ZVZyY2" +
       "ZcLxdGv3s3SWiyqnSTNWDMyBoS6GLZF3yIAPF7N6M+35NEr4NrzIh5mIB5N0" +
       "5NlZZK9bNrkz6JxoRvCgobW4lY1hnYbPqU4FrTLoclfdSaq7m66JzZzhlyI1" +
       "c60kzDq1XqgmUr2/4K2WD2tcxqit2JDgdCUa8MwU6q2ghdNTErXTmtWfZ71E" +
       "m+IcHrfp2HXrnV5MKnCdDZ1K29W3DDvviVVsMGFgWUzbLSQmm5taqy1VBsGI" +
       "n3RiskMHOGziI0ccN2rtbtcbeEN1EuIj3mEFcdYYDpvtHVyDFUImhstFwqlq" +
       "mGeh3OnNzKCz9HZygIiqnSzxxkb3YT9b6QMds3kO7rdhrCuNR0il0+7odhz2" +
       "KBOPUKa+kskZnqE2HTfIRk+Xpw6pIQbqp8uEHWdkV1pum0lVHwpIl9JkfKcR" +
       "5qItT6jVtIOZYtetwok3xXuztkmrmRBpbTtJxw2RavVVe7rElFpqw/w46q5E" +
       "oimmSGQ6zDaRlc0SUSvVXdb3KVuyx0oFYxW1OUObCqwNwk7UbbPYUokUIU/r" +
       "/Z3fFlqVtmY6Tb/f7aZracXgFtoLPWvSUmq8k4vEvJdQmDjCwAJGjlaDuYON" +
       "BBbvh7TnOQHb4GV7tmOCseggYiOm9dEAxrTUgJcu6WHtRrfBVxjXaqmxZhu7" +
       "BkMyzFgxmpUFaiDT1k4a77jAGcB6oJFs4K7R7lzsGhnW3qAT1kKiZi4mo8jd" +
       "OQlB9ikRc2QFC8zeJDdrS3RLZVZddbjQ3q3RvqnzINXA+AkyxxptbaS1wND2" +
       "eOTTvu6hOwr2xiMc2JDa5JGJIkrhWoyQQSP3NCZAa3EoC1ToUzXeG2pDbRUt" +
       "xhxYoLTNeNqq7JgmZ4o7R1l6E9wVgPHWpk6fbyC8tWBXi3HSHyr4DuQmpIBq" +
       "u3kd9oZUGE0cfFNNHX+GpgRdqxl5rW1O3WHY4/zxSK7xGq3BcLtR33rVPrZy" +
       "kjGp9t35GKuia8l0+iNMn05QtiEpq3FbgRvGerOpqI6WOyw6c22MJJKgyrHm" +
       "lugxLSN3pwEss0HcrPXyjF+36QFfW07Ho7pKDVCNwecuSBPMidTSB01ircOD" +
       "sTGNuPYUabbSsZgnlAhm1FbTEaLMZWCtC4PudrppdVmvppstWhvqQwnnF8Ec" +
       "5e2mGHot0pD4TlNNke1mJUkGMqYkFRla46zVHIwdTUO6jSri5izcF2Kzz2Kb" +
       "bCooNduSNUNZmhUPJTqDDbsamRTRy7q+GfVYkh5tjVgZdjSHW9N5ugExTVRy" +
       "l5QCeTPzzDTBmLVBdqb2TJ03XR3zM1LBmmYkZxEWW1IPgWcs7Q67jaah01uf" +
       "zep8ntdmcSWja7gtAfPGxkE3qoSUOuw3BaB8xEEED5WoYQXsBUyh2pV0K3PG" +
       "WxxNd63UFDt+RoQeglvqlpr1eRiJqW2jrxIjip1tZmoj9xWzns8jjOj7Sj0S" +
       "sNVyooOlE9aQfCwsHWRLO6FRJfk2bvg8Sml+lebYRnU26eWBvtkIJr6etBoh" +
       "5rj9mMaEISfALL+u9QYyk09ttaFjqL+r1pcy2x4k64kT5FM3F5Z9jvYov0LH" +
       "Jlaz625tUGdnCCFj1RTuTtt4MEzcVtd1CQPk3irYRX9Lsb3+7i/vhOPB8uDm" +
       "5M7/KziyyV7iWNvdz3VyVl7+7ocuXB+fvZY6e54VhdDjd7rhLw8wPvT2557X" +
       "pj9ePTg6/HpLDN0Te/432vpWt8+gOnjpI3G6/MDh9O7hd9/+949y37p605dx" +
       "pfrkBTovovxp+sOfHHyt+oMH0OWTm4gXfXpxHuiZC8eloR4nocudu4V4/ESy" +
       "X1dIrAqex44k+9jFW4hTlb6UccTQ/dHOVVeh51q5ru3N5MK12sGpgvenl/kZ" +
       "G3lzDN2teJ6ty24J/MGXuJP7saJ4fwzda+rx0Wlo0SKfGt4PfakjpbMoy4b3" +
       "nojkyaIRPnqO61+BSIriR24riLO8/OxL9H2kKH6iODO1k2h1O5Fd2XqWdsr2" +
       "T345bGdAZ2c/OiguUB950fdL+29u1J97/vq1Vz7P/1l5737yXcw9FHTNSGz7" +
       "7H3XmfpVP9QNq2Tlnv3tl1++fjmGblw81ga8FK+Syl/aD/vVGLrvzDBgIEe1" +
       "s4M+HkOXwaCi+uulem5ll85HgxPpPPSlpHMmgLz6jrc0dLL//OuW+tHnycl3" +
       "fqHx4/s7fdWW81I71yjo7v3nBSdu/vQdsR3jujp87Rcf+Pl7XnMckh7YE3xq" +
       "aWdoe/L29+c9x4/LG+/8V175i9/8k89/pjzF/h8vuQh/lScAAA==");
}
