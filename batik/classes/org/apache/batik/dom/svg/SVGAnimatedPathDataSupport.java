package org.apache.batik.dom.svg;
public abstract class SVGAnimatedPathDataSupport {
    public static void handlePathSegList(org.w3c.dom.svg.SVGPathSegList p,
                                         org.apache.batik.parser.PathHandler h) {
        int n =
          p.
          getNumberOfItems(
            );
        h.
          startPath(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            org.w3c.dom.svg.SVGPathSeg seg =
              p.
              getItem(
                i);
            switch (seg.
                      getPathSegType(
                        )) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CLOSEPATH:
                    h.
                      closePath(
                        );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegMovetoAbs s =
                          (org.w3c.dom.svg.SVGPathSegMovetoAbs)
                            seg;
                        h.
                          movetoAbs(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegMovetoRel s =
                          (org.w3c.dom.svg.SVGPathSegMovetoRel)
                            seg;
                        h.
                          movetoRel(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoAbs s =
                          (org.w3c.dom.svg.SVGPathSegLinetoAbs)
                            seg;
                        h.
                          linetoAbs(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoRel s =
                          (org.w3c.dom.svg.SVGPathSegLinetoRel)
                            seg;
                        h.
                          linetoRel(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                            seg;
                        h.
                          curvetoCubicAbs(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                            seg;
                        h.
                          curvetoCubicRel(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                            seg;
                        h.
                          curvetoQuadraticAbs(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                            seg;
                        h.
                          curvetoQuadraticRel(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegArcAbs s =
                          (org.w3c.dom.svg.SVGPathSegArcAbs)
                            seg;
                        h.
                          arcAbs(
                            s.
                              getR1(
                                ),
                            s.
                              getR2(
                                ),
                            s.
                              getAngle(
                                ),
                            s.
                              getLargeArcFlag(
                                ),
                            s.
                              getSweepFlag(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegArcRel s =
                          (org.w3c.dom.svg.SVGPathSegArcRel)
                            seg;
                        h.
                          arcRel(
                            s.
                              getR1(
                                ),
                            s.
                              getR2(
                                ),
                            s.
                              getAngle(
                                ),
                            s.
                              getLargeArcFlag(
                                ),
                            s.
                              getSweepFlag(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs s =
                          (org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs)
                            seg;
                        h.
                          linetoHorizontalAbs(
                            s.
                              getX(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel s =
                          (org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel)
                            seg;
                        h.
                          linetoHorizontalRel(
                            s.
                              getX(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs s =
                          (org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs)
                            seg;
                        h.
                          linetoVerticalAbs(
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoVerticalRel s =
                          (org.w3c.dom.svg.SVGPathSegLinetoVerticalRel)
                            seg;
                        h.
                          linetoVerticalRel(
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                            seg;
                        h.
                          curvetoCubicSmoothAbs(
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                            seg;
                        h.
                          curvetoCubicSmoothRel(
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs)
                            seg;
                        h.
                          curvetoQuadraticSmoothAbs(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel)
                            seg;
                        h.
                          curvetoQuadraticSmoothRel(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
            }
        }
        h.
          endPath(
            );
    }
    public SVGAnimatedPathDataSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Yb2wcRxWfO/93bJ99iZ2Qxk5iO5GcpneN0kAjh1LHseML" +
                                                              "Z8ey00h1aC5ze3N3G+/tbmbn7LODoa2EEpAIVnDbULX+5KqA2qZCVICglVEl" +
                                                              "2qqA1BIBBTVF4gPhT0QjpPIhQHkzs3u7t+dzVD5w0s3tzbx5/+f33uwLN1GN" +
                                                              "RVEX0VmEzZnEigzpbBxTi6QGNWxZJ2AuoTxVhf9x+sbYwSCqnUItWWyNKtgi" +
                                                              "wyrRUtYU6lR1i2FdIdYYISm+Y5wSi9AZzFRDn0LtqhXLmZqqqGzUSBFOcBLT" +
                                                              "OGrDjFE1mWckZjNgqDMOmkSFJtEB/3J/HDUphjnnkm/xkA96VjhlzpVlMdQa" +
                                                              "P4tncDTPVC0aVy3WX6DobtPQ5jKawSKkwCJntQO2C47FD5S5oPvl0Ee3F7Ot" +
                                                              "wgUbsa4bTJhnTRDL0GZIKo5C7uyQRnLWOfQlVBVHGzzEDPXGHaFREBoFoY61" +
                                                              "LhVo30z0fG7QEOYwh1OtqXCFGNpZysTEFOdsNuNCZ+BQz2zbxWawdkfRWmll" +
                                                              "mYlP3B1deup06/eqUGgKhVR9kqujgBIMhEyBQ0kuSag1kEqR1BRq0yHYk4Sq" +
                                                              "WFPn7UiHLTWjY5aH8Dtu4ZN5k1Ah0/UVxBFso3mFGbRoXloklP2vJq3hDNja" +
                                                              "4doqLRzm82BgowqK0TSGvLO3VE+reoqh7f4dRRt7Pw8EsLUuR1jWKIqq1jFM" +
                                                              "oLBMEQ3rmegkpJ6eAdIaAxKQMrS1IlPuaxMr0zhDEjwjfXTjcgmoGoQj+BaG" +
                                                              "2v1kghNEaasvSp743Bw7dOm8PqIHUQB0ThFF4/pvgE1dvk0TJE0ogXMgNzbt" +
                                                              "iT+JO169GEQIiNt9xJLmB1+89eDertU3Jc1da9AcT54lCksoK8mWd7YN9h2s" +
                                                              "4mrUm4al8uCXWC5O2bi90l8wAWE6ihz5YsRZXJ342cOPfpf8NYgaY6hWMbR8" +
                                                              "DvKoTTFypqoRepTohGJGUjHUQPTUoFiPoTp4jqs6kbPH02mLsBiq1sRUrSH+" +
                                                              "g4vSwIK7qBGeVT1tOM8mZlnxXDARQq3wRe3w3Y/kR/wylI5mjRyJYgXrqm5E" +
                                                              "x6nB7beigDhJ8G02moSsn45aRp5CCkYNmoliyIMssRdSRi5qzUAqnTw6oKs5" +
                                                              "bsU4CD6CGZ7Mm6ZBAXIg38z/m6QCt3njbCAA4djmBwMNztGIoaUITShL+cND" +
                                                              "t15KvC0TjR8O21sM7QfhESk8IoRHQHgEhEcqC0eBgJC5iSshww/BmwYYABxu" +
                                                              "6pt85NiZi91VkHfmbDV4npN2l9SjQRcrHIBPKFfDzfM7r+97PYiq4yiMFZbH" +
                                                              "Gi8vAzQDwKVM22e7KQmVyi0YOzwFg1c6aigkBXhVqXDYXOqNGUL5PEObPByc" +
                                                              "csYPbrRyMVlTf7R6Zfaxk1++N4iCpTWCi6wBeOPbxzmyFxG8148Na/ENXbjx" +
                                                              "0dUnFwwXJUqKjlMry3ZyG7r9WeF3T0LZswO/knh1oVe4vQFQnGE4dRDkLr+M" +
                                                              "EhDqdwCd21IPBqcNmsMaX3J83Miy1Jh1Z0S6tvGhXWYuTyGfgqIWfHbSfPa3" +
                                                              "v/zzfuFJp2yEPPV+krB+D1RxZmEBSm1uRp6ghADd+1fGv/nEzQunRDoCRc9a" +
                                                              "Anv5OAgQBdEBD37lzXPvfXB95VrQTWEGtTqfhJanIGzZ9DF8AvD9D/9yeOET" +
                                                              "EmbCgzbW7SiCnckl73Z1A9jTABB4cvQ+pEMaqmkVJzXCz8+/Qrv2vfK3S60y" +
                                                              "3BrMONmy984M3PlPHUaPvn36n12CTUDhZdf1n0smsXyjy3mAUjzH9Sg89m7n" +
                                                              "t97Az0JVACS21HkiwBUJfyARwAPCF/eK8T7f2mf4sMvy5njpMfK0Rwll8dqH" +
                                                              "zSc/fO2W0La0v/LGfRSb/TKLZBRA2D5kDyVgz1c7TD5uLoAOm/1ANYKtLDC7" +
                                                              "b3XsC63a6m0QOwViFQBj6zgFyCyUpJJNXVP3u5++3nHmnSoUHEaNmoFTw1gc" +
                                                              "ONQAmU6sLKBtwfzcg1KP2XqnFBVQmYfKJngUtq8d36GcyURE5n+4+fuHnl++" +
                                                              "LtLSlDzu8jLcLcY+PuwV80H+eA9D9TgJ6ADKFop+E5/QOn4rZU9RZ6U+RvRg" +
                                                              "K48vLaeOP7dPdhvh0t5gCFrfF3/9759HrvzhrTVKUAMzzHs0MkM0j0xeNDpL" +
                                                              "isaoaPFc4Hq/5fIff9SbOfxJ6gWf67pDReD/t4MReyrjv1+VNx7/y9YTD2TP" +
                                                              "fALo3+5zp5/ld0ZfeOvobuVyUPSzEvXL+uDSTf1ex4JQSqBx17mZfKZZHJye" +
                                                              "YgKEeWBj8D1oJ8BB/8GRGL1uYtVa4krhppVIl7Z1uPogIyjZif9boObwbmR2" +
                                                              "v+JtQnjzMUky/AQ4ZD1lTYvJ7z40wmlHsJ4C9BXqP7wOQiX4MMFQW1Zs8Iqh" +
                                                              "qG+dmyRVc1B2ZuxePLoQ/mD6mRsvysz3N+4+YnJx6WsfRy4tyVMgbzc9ZRcM" +
                                                              "7x55wxEKt/Ihws/izvWkiB3Df7q68ONvL1wI2sYeY6h6xlDlDel+PkzKoB36" +
                                                              "H/GKTxw2C3CPqtwnclDbUnZJlRcr5aXlUP3m5Yd+I45v8fLTBAcxndc0Tx57" +
                                                              "c7rWpCStCouaZCEwxQ+/rVRqZBmqglFYkJPU56DpW4saKGH0UjKGWv2UDNWI" +
                                                              "Xy/dLEONLh2cC/ngJZkH7kDCH8+bTiK3CsjnF9SIvI0VAuWwfr9sme4QLg9U" +
                                                              "95Qkr3iZ4KBMXr5OgG57+djY+Vuffk72WIqG5+fF5RPu0rKTKyLVzorcHF61" +
                                                              "I323W15u2OUkW0mP59VNJA1gu+iHtvqaDqu32Hu8t3LotV9crH0XjskpFMAM" +
                                                              "bTzlucpLT0HnkocScSruFgnPyyjRDfX3PT33wN70338vKqZdVLZVpk8o155/" +
                                                              "5FeXt6xA17QhhmrgHJHCFGpUrSNz+gRRZugUalatoQKoCFxUrMVQfV5Xz+VJ" +
                                                              "LBVHLTyJMX/NIPxiu7O5OMubb4a6y497+ZUFuotZQg8beT0lsBuqijtT8pbD" +
                                                              "AXs4cb4N7kwxlJvKbU8oR74a+sliuGoYDmKJOV72dVY+WSwk3hcfbmWx0Un2" +
                                                              "wFWJ+KhpOj1x3aIpM/7rkobPwyVyjz3LcSUgiz7/uyjYfUM88uHyfwGbmaqQ" +
                                                              "0xQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
