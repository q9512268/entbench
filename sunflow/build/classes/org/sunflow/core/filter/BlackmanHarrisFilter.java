package org.sunflow.core.filter;
public class BlackmanHarrisFilter implements org.sunflow.core.Filter {
    private float s;
    private float inv;
    public BlackmanHarrisFilter(float size) { super();
                                              s = size;
                                              inv = 1.0F / (s * 0.5F); }
    public float getSize() { return s; }
    public float get(float x, float y) { return bh1d(x * inv) * bh1d(y * inv);
    }
    private float bh1d(float x) { if (x < -1.0F || x > 1.0F) return 0.0F;
                                  x = (x + 1) * 0.5F;
                                  final double A0 = 0.35875;
                                  final double A1 = -0.48829;
                                  final double A2 = 0.14128;
                                  final double A3 = -0.01168;
                                  return (float) (A0 + A1 * java.lang.Math.
                                                    cos(
                                                      2 *
                                                        java.lang.Math.
                                                          PI *
                                                        x) +
                                                    A2 *
                                                    java.lang.Math.
                                                    cos(
                                                      4 *
                                                        java.lang.Math.
                                                          PI *
                                                        x) +
                                                    A3 *
                                                    java.lang.Math.
                                                    cos(
                                                      6 *
                                                        java.lang.Math.
                                                          PI *
                                                        x)); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0YC4xUV/XO7P/HfmCX/wLLQrIUZ0pppXWRFhaWXToLE5YS" +
                                                              "uyjDnTd3dh+8ee/x3p3d2a1rKdGCnxJaKaWGYqI0rYSWxlg10TYYo23TatKP" +
                                                              "1mps1ZiIVmLRWE1R6zn3zrzfzCwhJm7y7ry99/z/952/TKpsi3QynUf4pMns" +
                                                              "yBadx6lls1SfRm17F+wllEcq6N/2Xtp+W5hUj5BZY9QeUqjN+lWmpewRsljV" +
                                                              "bU51hdnbGUshRtxiNrPGKVcNfYS0q/ZgxtRUReVDRoohwG5qxUgr5dxSk1nO" +
                                                              "BvMEOFkcA0miQpLoxuBxb4w0KoY56YLP84D3eU4QMuPysjlpie2n4zSa5aoW" +
                                                              "jak2781Z5AbT0CZHNYNHWI5H9mu35E2wLXZLkQm6nml+/+rxsRZhgtlU1w0u" +
                                                              "1LN3MtvQxlkqRprd3S0ay9gHyWdIRYw0eIA56Y4VmEaBaRSYFrR1oUD6JqZn" +
                                                              "M32GUIcXKFWbCgrEyTI/EZNaNJMnExcyA4VantddIIO2Sx1tpZZFKj58Q/TE" +
                                                              "I3tbvllBmkdIs6oPozgKCMGByQgYlGWSzLI3plIsNUJadXD2MLNUqqlTeU+3" +
                                                              "2eqoTnkW3F8wC25mTWYJnq6twI+gm5VVuGE56qVFQOX/q0prdBR07XB1lRr2" +
                                                              "4z4oWK+CYFaaQtzlUSoPqHqKkyVBDEfH7jsBAFBrMoyPGQ6rSp3CBmmTIaJR" +
                                                              "fTQ6DKGnjwJolQEBaHGyoCxRtLVJlQN0lCUwIgNwcXkEUHXCEIjCSXsQTFAC" +
                                                              "Ly0IeMnjn8vb1x+7Rx/QwyQEMqeYoqH8DYDUGUDaydLMYpAHErFxVewk7Xju" +
                                                              "aJgQAG4PAEuY73z6yh2rOy++KGEWloDZkdzPFJ5QziZnvbqor+e2ChSj1jRs" +
                                                              "FZ3v01xkWTx/0pszocJ0OBTxMFI4vLjzx3cfOsfeDZP6QVKtGFo2A3HUqhgZ" +
                                                              "U9WYtZXpzKKcpQZJHdNTfeJ8kNTAe0zVmdzdkU7bjA+SSk1sVRvifzBRGkig" +
                                                              "ierhXdXTRuHdpHxMvOdMQkgNPGQtPFVE/olfTkajY0aGRalCdVU3onHLQP3R" +
                                                              "oXqKRjmz4T0Fp6YRtbN6WjMmoralRA1r1PlfMSwWBSkggqKbNAiEDNUHqGWp" +
                                                              "dr/YjGDAmf8/VjnUevZEKAQOWRQsB4DEBgwtxayEciK7acuVpxMvy1DD9Mjb" +
                                                              "i5PVwDWS5xpBrhHJNVKKKwmFBLM5yF16Hvx2ACoAlODGnuFPbdt3tKsCQs6c" +
                                                              "qASjI2iXrxX1uWWiUNsTyl+3/XbtwPTHXg+TMFSSJLQityMs9XQEbGWWobAU" +
                                                              "FKRynaFQHaPle0FJGcjFUxP37b73RiGDt8QjwSqoTogex8LssOgOpnYpus1H" +
                                                              "Lr1/4eS04Sa5r2cUWl0RJtaOrqBLg8onlFVL6bOJ56a7w6QSChIUYU4haaC+" +
                                                              "dQZ5+GpIb6Eeoy61oHDasDJUw6NCEa3nY5Yx4e6IWGsV73PAtQ2YVEvgqc1n" +
                                                              "mfjF0w4T17kyNjFWAlqIev/xYfOxX/z0j2uFuQutodnT04cZ7/WUIyTWJgpP" +
                                                              "qxt6uyzGAO7Xp+JffvjykT0i7gBieSmG3bj2QRkCF4KZP/fiwbfeefvsG2E3" +
                                                              "Vjn042wSxpqcoyTuk/oZlARuK115oJxpkOcYNd136RCValqlSY1hcvyrecWa" +
                                                              "Z/98rEXGgQY7hTBafW0C7v78TeTQy3v/0SnIhBRsp67NXDBZo2e7lDdaFp1E" +
                                                              "OXL3vbb40RfoY1DtocLa6hQTRTNUKl9xuhvOJm3IOjUDbhjP95+b4vuUo93x" +
                                                              "38veMr8EgoRrfzL6wO43978inFyLeY37qHeTJ2s3WqOeCGuRxv8Q/kLw/Acf" +
                                                              "NDpuyDre1pdvJkudbmKaOZC8Z4bxz69AdLrtnQOnLz0lFQh22wAwO3riCx9G" +
                                                              "jp2QnpMjyfKiqcCLI8cSqQ4ut6J0y2biIjD6/3Bh+ntPTh+RUrX5G+wWmB+f" +
                                                              "+vm/X4mc+s1LJao4pJBB5WC51ufOOX7vSJU2f775+8fbKvqhagyS2qyuHsyy" +
                                                              "wZSXJsxUdjbpcZc77IgNr3LoGk5Cq8ALYvtmIUbUEYYIYYg424pLt+0tnn5n" +
                                                              "ecbmhHL8jfeadr/3/BWhsH/u9taKIWpKa7fisgKtPTfYoAaoPQZwN1/c/skW" +
                                                              "7eJVoDgCFBUYNu0dFvTInK+y5KGran75gx927Hu1goT7ST1YONVPRZEmdVAd" +
                                                              "mT0G7TVn3n6HLA4TWB1ahKqkSHnMxyWlM31LxuQiN6e+O/db658487YoSrIK" +
                                                              "LRToYezvvj4q7mpuGzj3+rqfPfHgyQkZOjMkQgBv3gc7tOTh3/2zyMCi65XI" +
                                                              "jQD+SPT86QV9G94V+G77QezlueKZBBq0i3vTuczfw13VPwqTmhHSouTvRrup" +
                                                              "lsWiPgL3AbtwYYL7k+/cP9vLQbbXaa+LgsnpYRtsfN6Ir+S+6HZ7XSN6cD48" +
                                                              "1fk2UB3sdSEiXj4hUFaKtQeX1YXWUmNaKtyfWaC3NMxAFFJKAK+TjRTXAVzu" +
                                                              "ljTuLBt2O69fcIrLCCcVqj5eimdyBp7yaCUuqxzODjffEO7tnG50SzXncTK3" +
                                                              "aBSVUycm9OJy9yhROs8ePnEmtePxNeF8mbmdQ4Ya5kc0Ns40D6sKpORLpCFx" +
                                                              "c3Sjsv7+G2fHeC5dPIsilc4y0+aq8hkXZPDC4T8t2LVhbN91DJpLAroHSX5j" +
                                                              "6PxLW1cqD4XF5VcmQdGl2Y/U6w/9eovBLV/3l/cux5ut6Lx58DTlvdlUetgr" +
                                                              "EQjOCFUOdYZmkZvhbAoX6AM1o4wPwxQjotYNWH6tJPHVZtyIi23Dr7PzUvi9" +
                                                              "Pp3LoQb0Cssi7yTeOkH6szNofz8u90K+gvYBzQ/9z5q34VEHPO158duvofme" +
                                                              "4qJWDjWgU35OcZU+PoPSD+HyRU4qk2NrUgGtv3T9Wuc4mVPqjoudel7RtzX5" +
                                                              "PUh5+kxz7dwzd70p7lvON5tGGG/TWU3zNhPPe7VpsbQqdGiUrcUUP4+WKnny" +
                                                              "9s3x6xm+COFPSfjTnLQE4cEc+OMF+yonDR4wjqOcePMCfQ2CB4Dw9etmoQC3" +
                                                              "iAEFm2pENtVcyFM88/ko7N1+LXs7KN77GBZH8XGzUMiy8vNmQrlwZtv2e658" +
                                                              "9HF5H1Q0OiUSvAHmUHk1dYrhsrLUCrSqB3quznqmbkWhGbRKgd2gXegJqjiE" +
                                                              "n4kuXxC4LNndzp3prbPrn//J0erXYMrZQ0KUk9l7isePnJmF3rInVjxvQ6MQ" +
                                                              "t7jenq9Mblid/suvxHxH5Hy+qDx8Qqn74NjUMjsUCZO6QVIFfY7lxFy0eVLf" +
                                                              "yZRxyze8VyeNrO58A52FsUnxo6ewSt6YTc4ufkvgpKv4HlP8fQUG3wlmbULq" +
                                                              "ojkEWkfWNL2nwqp9uNyaQytDnCViQ6ZZuMDtF1Y3TZGE38Zl838BC8HdPLUY" +
                                                              "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
