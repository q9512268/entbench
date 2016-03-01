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
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYe2wUxxmfOz+wLwY/wIaSYMAcqLxuazkJQqYt4GBsesZX" +
                                                              "m1DVNDnmdud8i/d2l9k5++zUJURqQahCUXBSGgX/RdQ2IiGqGrVSFeSqUpMo" +
                                                              "TSNo1OahJq36R9MHUvgntKJt+s3M7u3ens9p/+pJO7c38833nt/3zV25ieoc" +
                                                              "irpsbGo4waZt4iRS/D2FqUO0PgM7zhGYTavn/nDh1O1fN56OovoxtCKHnSEV" +
                                                              "O6RfJ4bmjKF1uukwbKrEOUyIxnekKHEIncRMt8wx1K47g3nb0FWdDVka4QRH" +
                                                              "MU2iVswY1TMFRgZdBgytTwptFKGNsi9M0JtETaplT/sb1pZt6Auscdq8L89h" +
                                                              "qCV5Ak9ipcB0Q0nqDustUrTdtozpccNiCVJkiRPGfa4jDiXvq3BD14vNH995" +
                                                              "PNci3LASm6bFhInOCHEsY5JoSdTszx4wSN45ib6BapLorgAxQ/GkJ1QBoQoI" +
                                                              "9ez1qUD75cQs5PssYQ7zONXbKleIoY3lTGxMcd5lkxI6A4cG5touNoO1G0rW" +
                                                              "euEOmfjkdmXuOw+3/LAGNY+hZt0c5eqooAQDIWPgUJLPEOrs0zSijaFWEwI+" +
                                                              "SqiODX3GjXabo4+bmBUgBTy38MmCTaiQ6fsKIgm20YLKLFoyLyuSyv1VlzXw" +
                                                              "ONja4dsqLezn82BgTAfFaBZD7rlbaid0UxN5VL6jZGP8S0AAW5flCctZJVG1" +
                                                              "JoYJ1CZTxMDmuDIKyWeOA2mdBSlIRa5VYcp9bWN1Ao+TNENrwnQpuQRUjcIR" +
                                                              "fAtD7WEywQmitDYUpUB8bh7ec/4Rc8CMogjorBHV4PrfBZs6Q5tGSJZQAudA" +
                                                              "bmzalnwKd7x8NooQELeHiCXNj79+a++OzoVXJc3di9AMZ04QlaXVy5kV1+/p" +
                                                              "27q7hqvRYFuOzoNfZrk4ZSl3pbdoA9J0lDjyxYS3uDDyi68++hz5axTFBlG9" +
                                                              "ahmFPORRq2rlbd0g9CAxCcWMaIOokZhan1gfRMvgPambRM4OZ7MOYYOo1hBT" +
                                                              "9Zb4DS7KAgvuohi862bW8t5tzHLivWgjhFrgQe3w9CD5Ed8MMSVn5YmCVWzq" +
                                                              "pqWkqMXt5wEVmEMceNdg1baUDOT/xM7uxC7FsQoUElKx6LiCIStyRC4qmpVX" +
                                                              "nElIrKMH95l6ntuUAjUewAyPFmzbogBAkH32/0lukftj5VQkAqG6JwwUBpyx" +
                                                              "AcvQCE2rc4X9B269kH5dJiE/OK4nGeoB4QkpPCGEJ0B4AoQnqgtHkYiQuYor" +
                                                              "IVMDAjsBEAEY3bR19KFDx8921UBO2lO1EBVOuqWiZvX5WOIVgLR65frI7Tff" +
                                                              "iD0XRVGAmwzULL9wxMsKh6x71FKJBshVrYR4MKpULxqL6oEWLk6dPnrqc0KP" +
                                                              "YC3gDOsAxvj2FEfwkoh4GAMW49t85sOPrz41a/loUFZcvJpYsZODTFc4wmHj" +
                                                              "0+q2Dfil9Muz8SiqBeQCtGYYThcErDMsowxsej3g5rY0gMFZi+axwZc8tI2x" +
                                                              "HLWm/BmReq18aJdZyNMhpKDA/M+P2pfe/tWfe4QnvfLQHKjro4T1BiCJM2sT" +
                                                              "4NPqZ9cRSgjQ/e5i6sKTN88cE6kFFJsWExjnYx9AEUQHPPjNV0++88H7l9+K" +
                                                              "+unIoCYXMtDeFIUtqz6BTwSef/OHwwifkHDS1udi2oYSqNlc8hZfN4A3A446" +
                                                              "T474gyYkn57VccYg/Cz8s3lz90t/O98iw23AjJctOz6dgT//mf3o0dcfvt0p" +
                                                              "2ERUXl59//lkErNX+pz3UYqnuR7F0zfWffcVfAnQHxDX0WeIAFEk/IFEAO8V" +
                                                              "vlDE2BNau58PcSeY4+XHKNAGpdXH3/po+dGPrt0S2pb3UcG4D2G7V2aRjAII" +
                                                              "60buUAbqfLXD5uPqIuiwOgw6A9jJAbN7Fw5/rcVYuANix0CsCsDqDFOAv2JZ" +
                                                              "KrnUdcve/dnPO45fr0HRfhQzLKz1Y3HgUCNkOnFygJxF+4t7pR5TDV7JKaIK" +
                                                              "D3Gnr188nAfyNhMBmPnJ6h/t+d78+yILZdrd7W4XPzaL8bN82C7mo/x1B0MN" +
                                                              "OANYAKoVS14Sn+YlvFTOnqJ11boT0VldfmxuXht+tlv2EG3lFf8ANLTP/+Zf" +
                                                              "v0xc/P1rixSPRmbZOw0ySYyATA73Gyvgfkg0bz5U7bpxu+a9J9Y0VSI959RZ" +
                                                              "Bce3VcfxsIBXHvvL2iNfyB3/HyB8fchRYZY/GLry2sEt6hNR0X9K9K7oW8s3" +
                                                              "9QZdBkIpgUbb5GbxmeXiAHSVQtvGQzYIz243tLvDB0Bi7ZIpU++IK4CfMCIR" +
                                                              "WpfgGjr6UclO/F4DtYN3CFM9arAx4A3BKBnnqe2RbapoJGx+V6EJTjsAKQAo" +
                                                              "KtT/yhJI8xAfUgy15sSGoBiKti5x86N6HsrHpNs7K7NtH0w88+HzMqfDjXaI" +
                                                              "mJydO/dJ4vyczG95G9lUcSEI7pE3EqFwCx92FkXKLyFF7Oj/09XZn35/9kzU" +
                                                              "NXaAodpJS5c3ml18+LIMWu9/hzt8Ym8RbjnVOzWOTWsqrpDy2qO+MN/csHr+" +
                                                              "wd+KbqF0NWmCYpwtGEYga4MZXG9TktWF/k0Svm3xNQF3iWqtJEM1MAoDTkhq" +
                                                              "uHmsWowaKGEMUp5kqCVMyVCd+A7SMYZiPh2cAvkSJJkC7kDCXwG03bRtEcjN" +
                                                              "r48JeVcqRirheZdsdD4lOAHI3VSWquKq72FKQV720+rV+UOHH7l1/7OyM1IN" +
                                                              "PDMjroZw05X9VwmXNlbl5vGqH9h6Z8WLjZu91CrrzIK6iZwBjBZdzNpQq+DE" +
                                                              "Sx3DO5f3XHvjbP0NOBTHUAQztPJY4KItPQX9RgFA81gyCPaBP4xEF9Mb++Px" +
                                                              "N//+bqRNlD63PHQutSOtXrj2Xipr209HUeMgqoOTQ4pjKKY7D0ybI0SdhCLd" +
                                                              "UDD1kwUyqEFCZqyCWfpXYAVPY8z/BhCecR26vDTLm2aGuiqPd+VFArqCKUL3" +
                                                              "c+4Cq0NIDgcsuFrkt+VFrILYdF/6x6lvvT0Mx6xM8SC3ZU4hUyoKwT8d/Crh" +
                                                              "Io3sS2vSySHbdvvUmjsiqrYtEOHbwuhzkppTwHVtm23/B5ipDAI8FAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ao4texpojt4FsJ9RZ/1LRxv+VHoGBuK50n51H8v+P51PfDxvr2XNj+2snnV/" +
       "HEZslGefcIZpuaqd83kKQI+xtWsHMSrDbBSa+NrSruZs7of5d+4dmTL7uxRu" +
       "h1VZi++kyPuVO3rD9QNZ4e7fe8Ss68Fs8P3/+NyXf/XJr8MtaiPn1pn54M4c" +
       "W1GIswT5l1/84MOvev4b788BCKJP70ONK09nXDuvpHHWMFnTOFD1oUxVKX+v" +
       "d9UI8DlOGHqu7St6Zi+0HAit65vZH/rM1a+vPvLNT+4yu9NueIrYeO/z7/v+" +
       "/gee3zuWTz95S0p7fM4up86FfvVNC4fI46+0Sj6D/adPP/NHv/PMszuprp7M" +
       "Dhvw8PPJv/rvL+9/+BtfvE2icZft/R82FrzqOy0i4qiDDy8rRikZpaljittC" +
       "0k0UNOFUSeEpLeimsbpdtfuBAohmPTKi6cQpMrLAuI4e6zUL1Us2uSoXCttR" +
       "ezQI+uqCHk3qUnM+QQd6v8RZzaAZyhJrSMHI572hJHhFUV20A7wyIPnWaD13" +
       "QacNChHOV2PccCPSRwt+W6xqeK2G4y5A8a1cKluGp1mhH82aHpGoU0BYAwll" +
       "SmwwErHenK9uF01lqK5d1GUWRbFoCuWK6K29FNCdlis1ZLEyMNvEzFl22GIc" +
       "r5JZJ2yIow2Xusaq02pwrjbgQS1Jix2iOsfdGcaOdUZeqUR/0OJHJUuOEqU4" +
       "5NnBfKrX5xswTHzAdppCZJE81gaNoerbQzSaFf0pqFBxpOlBrVsjFwEtl6kV" +
       "aflaHetjbsDEERiFQx14W1/TBIuW2ytr0GuaKrFkrMk6wOtMkVgLLZIs9wTN" +
       "wruU5FRm7IJzRbrViJRy25P0YbRNiUQSiLI1q9RVvwvzTirto81Vu9ive32P" +
       "I41tMRgx1bLWj8q9KFL61a0oTGYd2+A8BbeHzZTX9LK9SrkKRWjNMvBiwROL" +
       "TSwcG3FDdMzlSncmsZgUcLRLNQWlsJgCTCsbgedRfYYb9+ajdrfXEMMI20rW" +
       "UmXHjYQrSIElMhO8uZyoM48ozJz6aF4fbvAa79BD1epXzKjDzZ0SpnQ7Xdbb" +
       "dDextFkXZXs7SURhqRLwSNo1tm6tVJ8PKZNV61OmGtoz1dKxUSqU5W5lOW32" +
       "ahJGUeOyadMamLblZrHtKe0iPR2mPOPEDNfZjA2RKjl6XbK5gVqWFc0nZ2Oh" +
       "SHmFodAQwsTt+3F/MFpq3MCkAFMdNzZJH0Yoo4z8Ub02W1QNDSUGWo3mvfnS" +
       "C+stmeiFZn0aVfpl0JTa0z4V69TM2aq2m3T0aloTPK/f6Boti54IyypZUAsF" +
       "cevJk7aG6xZJ8VOM6NvqRN6UV3KxgPqlalBdBOuBwsaQTjCn4YqYSjbuz3SP" +
       "ItuYzSw3qSLhMcNsrEqtUFhsy2o6ZOt2k1QXDtsTB4OgBI2jY3OSplJaG/Mq" +
       "J3qr6UJ1i3NzwK/nPdWZDXhCnFZ5UVFEr7ioD8npjGCkaoear2NvYdUqpdm4" +
       "Bspg2+pa6/F8uWDDed/AE5Jmyg29xvOS7JYVh5bH28APxquAn4By0pCdBq8Z" +
       "gj4vztQRIw7RFEZwSlfZqO+NGnYnrXQtmpPAZkATgePLE7dhc2GHb5Flu+KC" +
       "eEQtR0ZCbXqss5158zq1auElFLPjlQmWZbm/ooJmpZ0ko7q/SSlt3acbpVAj" +
       "JmS9VCFXrbLethqo2CHcpuHVif7K79HNRhurE5TXd4M5aK0Uqx8rMAuSeYZa" +
       "RvUG1VDw2aBIdlgmrZGl4qgulmyx2KjLYhyMrel6Uh6LnDzvDiplM+SqQ9O0" +
       "GGwygGc3J9mOul0ySfmos6ik1SLbadejhRwqA4Lv+KNuGnQrXmPcXVX0nhsG" +
       "GtbpKTQ+Z8SIStfLEtswk5W3IJoUPyZIUCtHYi/cEkWYdngjdqqt274STUVm" +
       "yGpE4rSWWCEoMfD0TvLxtiZZQd3o06CpKMOF1ggZPvKSNDKW+LwcKticZ6dW" +
       "QU2TqVYDXCltdccOWncGRlCsqW19uhH4hd9hKJQv9Eq+aaBgbBpE312b3X6r" +
       "sww9YlisW3SbL0VDQugFU1IbSPNlHzXKViXqDIVaTWtUVizbjsaNdOkqKUk1" +
       "Rv1Wr7cUZKxQqNVaVZssdAqxy3m0MuEBY7DcCATbSn2YSIaJiq0kscxVi5GK" +
       "sW6VPEUKBFurLaamQFA4RRCVIVEl5htl5ZarsqYpc5Te1iLc3pIYQEWyZiUl" +
       "nFq2NSBuK/p8iKKOiXuYrplrgPmlxmA0scskitqrRihMCv4WHymBGw+qLLY1" +
       "x6apySbl9lspM8HGBkexjRXKsQ1KrMlrm2mU6oIal2s9TTIUojBpdQSq6euT" +
       "Fg7P2QW92QsBJpX8GT7SmgRTalblkjpYUhxXwWbQiWeB2Z0w5bgXcLGViPOk" +
       "QpHLNjUTqmxSRkNNVmJKsFKMjuiICRhWpNal9rQTuiNdWxuo7vZEAnob1hqY" +
       "i/6229kWFbw1H9HCSnTZzbydsgUCVP1BecjI1XZH5ToM3nTDYq3mUuZGWPB1" +
       "p+e2KwsUFPRqrbDhulM91KtjYtLbqt3aTKiV6KrjoWmxjvGCSAkK1fFkqUhI" +
       "bkGx1+xQdIN2sTjzhphs66aTxpMFKAB7XWo0cZs1a5TQHfbQwtRcY6mG9oqh" +
       "lUq9gTObigm2kZQNNaSqeHOznpurOTbblkfVmZ/GBZVskwomSxxZJgfTumbg" +
       "smamEVeftNbrbskSzE0dR1ubes3UFgNlqqDNbrgpRQ1QWQgDbEJ2yE7VG0Mv" +
       "IPvwnbvi/PloNis3Z6ljTCyqJcl9sG72twq3LRE46K6ZOla3qlPOHxUKXIeg" +
       "TZ7mBmPfnDeXYWWk2SLKEgxQBJxmeVINqRS6Xr1Td93AKA1mqu+1m2lBrjTa" +
       "w2VEdfqU1wFDdLNoc7WUMkfzTbEcSU2vbnWAVU5rFaHSisKWL0TVTlUALSyp" +
       "1QqtLR+YDHz3cU57o4uo3ibWG23bJMtN0h5pUoOr+g28EbAJnZIldjXpdDcs" +
       "WxWXKEZOpi5eRsnVdiRMVMrT/bZU1nDHLtYKXY4fxyS62IKa4tQGs6Uri9ux" +
       "OBxHQegzm1IgFngB1aJWWEj0QmcWsJgwdmjFT0CzocxVgp9OmuRwBcYsusKk" +
       "tYOnQp/FrXEA2g2+yFMeM1wtgrjlRGMvUTvNBj/yyyuYu/AbmdYLVFXilanV" +
       "W5Q0ar2S2u0VXV0x9CRpYhBPQUNbCiFRaxuyFgyscGFM9UhnCFukWhwuS+Mg" +
       "7gTVEtvpy9USVgjlwkhsQcQoolVxwxc5ocfwEISmCVaekHLiTAR7ZpfXzaBF" +
       "LirT2ri7nMZkkQ7DLdepWNOkvqxP9a3g94MC05BSnBHLJg6dajnrYYJYH7ZG" +
       "VH8Lem2F6HCg15+QgzlL1YrzDd1T6z0ibbAkPysUeqmAooVZMBBspoL3Wv0Y" +
       "SCKYhMvSxPLDEka2RgY/Dzxx2Cf8ZaejVBlsM+MwSV/QXX3EMMVVMtoEDZae" +
       "Bht6bPoThZJ7Sm2L1he0oQ1KlTUz7DoltRlbQU8vyCwVBnRn1MW1AkEHmMAx" +
       "cy2K2XAF4FjIdRWdRStpxV6vhxifVlK+JtH4dEQsRhuvkwxrOkqHC87DI6m0" +
       "ljZSa6av1yNnGVlBqICG2Jol8WK78v1h0pKBU8LRetnyGYqrsTDFz1L/t/1w" +
       "p6/78oPm4cUBPHRlA80f4tSR3n7BvZsH3AvqLAKhqoH0sPKWfy6/QuXtWHUC" +
       "yY5ZD9/psiA/Yn3sPc+/oIsfL+7drOqMAXIReP5bbGNt2MdYZUfdN935OMnn" +
       "dyVH1YbPv+dfHhr+5OIdP0Q99dFTcp5m+bv8i19svlH79T3k7GHt4ZZbnJOT" +
       "rp+sOFwKDRCH7vBE3eHhQ8tezSzGwS9507Lk7Wuar7BjuYvsvONU5WxvR3VQ" +
       "gngkK4MnuHa8+p1VvSVjnpXmDsievKVa7mcXcuF+RttSXd02wnw58AqFum3W" +
       "eNBbF/mE08sMjvmoDM/Na8/Sj5zX/0FH5hOVMYA8dOcyflaHfPCW+8XdnZj2" +
       "qRcuX3jdC6O/zivZh/dWF7vIBTO27eNlo2P9835omFau5MVdEcnPf34RIA/e" +
       "6Z4BIGdhm4v+CzvqZwHy2ttRQ0rYHqd8H0CunKYEyLn89zjdrwDk0hEdQM7v" +
       "OsdJnoPcIUnW/TX/NoWpXZUtPXMymg+35eoP2pZjAPDkibDN74EPQize3QTf" +
       "0D79Qlt458uVj+8K8pqtbnOvudBF7t7dDRyG6eN35HbA63zrqe/d+5mLbziA" +
       "lHt3Ah8FzzHZHr19xbvh+CCvUW//8HW//9bffuFreZ3sfwHU6X0OoB8AAA==");
}
