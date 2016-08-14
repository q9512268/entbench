package org.apache.batik.bridge;
public class RepaintManager {
    static final int COPY_OVERHEAD = 10000;
    static final int COPY_LINE_OVERHEAD = 10;
    protected org.apache.batik.gvt.renderer.ImageRenderer renderer;
    public RepaintManager(org.apache.batik.gvt.renderer.ImageRenderer r) {
        super(
          );
        renderer =
          r;
    }
    public java.util.Collection updateRendering(java.util.Collection areas)
          throws java.lang.InterruptedException { renderer.flush(areas);
                                                  java.util.List rects = new java.util.ArrayList(
                                                    areas.
                                                      size(
                                                        ));
                                                  java.awt.geom.AffineTransform at =
                                                    renderer.
                                                    getTransform(
                                                      );
                                                  java.util.Iterator i =
                                                    areas.
                                                    iterator(
                                                      );
                                                  while (i.
                                                           hasNext(
                                                             )) {
                                                      java.awt.Shape s =
                                                        (java.awt.Shape)
                                                          i.
                                                          next(
                                                            );
                                                      s =
                                                        at.
                                                          createTransformedShape(
                                                            s);
                                                      java.awt.geom.Rectangle2D r2d =
                                                        s.
                                                        getBounds2D(
                                                          );
                                                      int x0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getX(
                                                                ));
                                                      int y0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getY(
                                                                ));
                                                      int x1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getX(
                                                                ) +
                                                              r2d.
                                                              getWidth(
                                                                ));
                                                      int y1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getY(
                                                                ) +
                                                              r2d.
                                                              getHeight(
                                                                ));
                                                      java.awt.Rectangle r =
                                                        new java.awt.Rectangle(
                                                        x0 -
                                                          1,
                                                        y0 -
                                                          1,
                                                        x1 -
                                                          x0 +
                                                          3,
                                                        y1 -
                                                          y0 +
                                                          3);
                                                      rects.
                                                        add(
                                                          r);
                                                  }
                                                  org.apache.batik.ext.awt.geom.RectListManager devRLM =
                                                    null;
                                                  try {
                                                      devRLM =
                                                        new org.apache.batik.ext.awt.geom.RectListManager(
                                                          rects);
                                                      devRLM.
                                                        mergeRects(
                                                          COPY_OVERHEAD,
                                                          COPY_LINE_OVERHEAD);
                                                  }
                                                  catch (java.lang.Exception e) {
                                                      e.
                                                        printStackTrace(
                                                          );
                                                  }
                                                  renderer.
                                                    repaint(
                                                      devRLM);
                                                  return devRLM;
    }
    public void setupRenderer(java.awt.geom.AffineTransform u2d,
                              boolean dbr,
                              java.awt.Shape aoi,
                              int width,
                              int height) {
        renderer.
          setTransform(
            u2d);
        renderer.
          setDoubleBuffered(
            dbr);
        renderer.
          updateOffScreen(
            width,
            height);
        renderer.
          clearOffScreen(
            );
    }
    public java.awt.image.BufferedImage getOffScreen() {
        return renderer.
          getOffScreen(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "j2E4pXRon8E9lBZGaGw/4F1sPvwPIpAwq2keAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+zr1nkY77XvtX1j+147ie14sRMndjpb7Y/UW5rTrBQl" +
       "SqQoPkVK4tbeUHyJb4ovicy8NgG2pGubZZ3TZENjDJiLdYXbtMOKrRtaeBi2" +
       "JmiwIV2xF7Am6AasXReg+aMPLNu6Q+r3vvfaNdoJ4NHhOd/5zvc+H885b3wL" +
       "uhZHUC0M3Nx0g+RI3ydHtts+SvJQj49Iqs0qUaxrmKvE8Ry03VY/9PM3/+A7" +
       "n9vcugpdl6F3K74fJEpiBX7M63HgZrpGQTfPWkeu7sUJdIuylUyB08RyYcqK" +
       "k5cp6F3nhibQ89QJCTAgAQYkwBUJMHoGBQY9ovuph5UjFD+Jt9Bfha5Q0PVQ" +
       "LclLoOcuIgmVSPGO0bAVBwDDg+W7BJiqBu8j6IOnvB94voPhz9fgV7/wA7f+" +
       "0X3QTRm6aflCSY4KiEjAJDL0sKd7az2KUU3TNRl6zNd1TdAjS3GtoqJbhh6P" +
       "LdNXkjTST4VUNqahHlVznknuYbXkLUrVJIhO2TMs3dVO3q4ZrmICXp844/XA" +
       "IV62AwZvWICwyFBU/WTI/Y7lawn0gcsjTnl8fgoAwNAHPD3ZBKdT3e8roAF6" +
       "/KA7V/FNWEgiyzcB6LUgBbMk0NP3RFrKOlRURzH12wn01GU49tAFoB6qBFEO" +
       "SaD3XgarMAEtPX1JS+f08y36o5/9hD/xr1Y0a7rqlvQ/CAY9e2kQrxt6pPuq" +
       "fhj48EvUTyhP/PJnrkIQAH7vJeADzD/5K9/+vu9+9s2vHGD+3F1gmLWtq8lt" +
       "9fX1o19/P/Zi/76SjAfDILZK5V/gvDJ/9rjn5X0IPO+JU4xl59FJ55v8v179" +
       "0M/ov3sVukFA19XATT1gR4+pgRdarh6NdV+PlETXCOgh3dewqp+AHgB1yvL1" +
       "QytjGLGeEND9btV0PajegYgMgKIU0QOgbvlGcFIPlWRT1fchBEEPgAd6GDwv" +
       "Qodf9Z9AK3gTeDqsqIpv+QHMRkHJfwzrfrIGst3Aa2D1DhwHaQRMEA4iE1aA" +
       "HWz04451ZGmmDvN6qABLnSk+sILoqDSx8P8n8n3J2a3dlStA6O+/7PIu8JZJ" +
       "4Gp6dFt9NR2Mvv1zt3/t6qkLHMskgT4C5js6zHdUzXd0mO/o4nzQlSvVNO8p" +
       "5z3oFWjFAf4NIt/DLwrfT378Mx+6DxhUuLsfiLQEhe8dgLGziEBUcU8FZgm9" +
       "+cXdJ6UfRK5CVy9G0pJW0HSjHM6W8e80zj1/2YPuhvfmp3/7D778E68EZ750" +
       "ITQfu/idI0sX/dBlqUaBqmsg6J2hf+mDyi/e/uVXnr8K3Q/8HsS6BIitDCPP" +
       "Xp7jgqu+fBL2Sl6uAYaNIPIUt+w6iVU3kk0U7M5aKnU/WtUfAzJ+V2m77wNP" +
       "+9iYq/+y991hWb7nYB6l0i5xUYXV7xXCL/3Hf/M7zUrcJxH45rk1TdCTl895" +
       "fYnsZuXfj53ZwDzSdQD3X77I/u3Pf+vTf6kyAADx4btN+HxZYsDbgQqBmP/a" +
       "V7b/6Ru/+fpvXD0zmgQse+natdT9KZNlO3TjLZgEs33kjB4QNVzgXKXVPC/6" +
       "XqBZhqWsXb200v9984X6L/7Pz9462IELWk7M6LvfHsFZ+/sG0A/92g/84bMV" +
       "mitquWqdyewM7BAK332GGY0iJS/p2H/y15/5O7+qfAkEVRDIYqvQq9h05dhx" +
       "SqLem0C1O/zSzJIjYD7AoYH7Ex7wSv74rVI0XI18qSqPSiFV+KCqr1kWH4jP" +
       "O8xFnzyXkdxWP/cbv/eI9Hu/8u2Kw4spzXn7mCnhyweTLIsP7gH6Jy9Hh4kS" +
       "bwBc6036L99y3/wOwCgDjCqIczETAdr3F6zpGPraA//5X/zLJz7+9fugqzh0" +
       "ww0UDVcqx4QeAh6hxxsQ1fbhX/y+g0HsHgTFrYpV6A7mD4b0VPV2HRD44r1j" +
       "El5mJGdu/dT/Ytz1p37rj+4QQhWN7rIQXxovw2/85NPYx363Gn8WFsrRz+7v" +
       "DNcgezsb2/gZ7/evfuj6v7oKPSBDt9Tj1FBS3LR0NhmkQ/FJvgjSxwv9F1Ob" +
       "wzr+8mnYe//lkHRu2ssB6WyZAPUSuqzfuBSDygdCwPPSsXu+dDkGVavGQccl" +
       "SUcEyOTAevL4b/291//wk5/uXS2d4FpWkg6kcusMjk7LDPSvv/H5Z9716jd/" +
       "pAoSEPRdt0qkaDX9c1X5fFl8V6XfqyB8xFUemwBOLF9xj8PIH4PfFfD83/Ip" +
       "6SsbDgv/49hx9vHB0/QjBIviIxjDrm4z0oifjNDhW9sNG1keCJDZcQIGv/L4" +
       "N5yf/O2fPSRXl43kErD+mVf/xh8fffbVq+dS2g/fkVWeH3NIaystPFIWZOl2" +
       "z73VLNUI/L9/+ZV//tOvfPpA1eMXE7QR+P742X//f7529MVvfvUuGcJ9IAs4" +
       "rCRl2SqLwUGy3Xv64EcvWsj3gKd2bCG1u1hIWcHKQF9WFvdQb1mdlAVRsU+W" +
       "2ivVRBH06FRXZQ97idrln5zaR8vWF45t+sS2L1ILVZXbdycSLGEPhVGQAK/T" +
       "tRMyHzyJ2uU7com4j78tcQc1XwGorzWOukcVAvPu099XVv/8nYJ60nbV509M" +
       "XQIfdiCQPW+73ZPF5pzfHb6GLhFJ/omJBNb46BkyKgAfVj/y3z73tb/54W8A" +
       "yyJPPL2EHgJpST/8C80/Kl/Cd8bP0yU/QpUwU0qczKplWtdOWZqdI5pLwGIf" +
       "/ClYSm49NWnFBHryoyTZWOzUPS8afo1hGbbVYlp+wek7xw5nwTDZDUiZN4XJ" +
       "eObsbWbSXQyFfYHJa6Sp9dutddOQ/fUsCz1nM7K4RAkjAR07uGj0dkNtgIqo" +
       "tJ1yCxd80Q+NkTVIRig/2U0dzsQHGwLbKmJmeH2vD6/NblgfU6Gcrr2mX8hJ" +
       "Z91vdrPMGPM2YsmyTHrbaEQ0Gi437U/deNklk7FliW0xVgpmttfFrrCV2KjZ" +
       "yLRGg3DR2rzhTshOOHKtRpvbktvdxvHmIKOZIR6/7UtTZTdY9sloETBCa89r" +
       "+jiXCrzjtNZbi4iikcaKGLdy4t1qK6urWXvBD6esRpv02PPInWOBT+01ZzM0" +
       "ohP9Rb5O90iua918GPdngF4t0/Mx6k80x7ZFez7Eh6Ii5sXCt5ek4tBLrSOL" +
       "vigFriM1tuMkxqUdv2gzvhmuJp2iBSfLHlLg4m7RJxB/OdlHKL7t6EFrrvKE" +
       "PwdfYtoU0fhme2h5tCM5+sqRlVWv44maiWBh3EGiUFTZQNl6S8GfB8tN4am5" +
       "icjD3pwQ7d6cK6ZuMmt4frsnMziXL5pKbTzlNSekFwLp+C2vAbJ1I02H615e" +
       "JwUaKbb4GOHsnB0S/CaembtpqDu84gJr5Xh6SNKdodDuOuR2GmLbed9BmotR" +
       "OHXq5jhK+jy2a3vDcZSzUl3bzRvYeiyP5Wgrj3KYHKpRTZJlMeTnRCO1p1Nr" +
       "rprMzFyRIjYomPkosbRsMR97U8Id4466JMfz2JCmBIG5+MKf8tlSlewZgnEy" +
       "YRYoL2mkgIijHSsgeDgWO+PpkMxnACs+WW4sgRUER+Fb8QxhF9RUwZScXwyE" +
       "vSWP87ntM9gCN+U0X87gCSzpcdrvrOXZgrCkXdsUJGlewBRuixPcRDiSFUMG" +
       "naw8vL6o7RtbY7zPBBwzJ5vUxG0OZqI1mfe6KeyvkBblRSiBGMKsu50VVi/h" +
       "ia6B476SLdyU2E/NpiZmw9yQyYKqpU25vy0G1mC2arXsuaOo+WI2nDc67da8" +
       "2+FWG1GT6XwhqYWyxmzdddlxK5wWq7oYdNYjZTpdF1NeCUKW1dqzaWemivYq" +
       "4jNvLgTbfF3gw7ZI+YzRYqZOjGKSxOGGKFEdp2s4tBl0GyrNOSZujMy6ga/4" +
       "nqrDY80RJtpyTmMR6WzlQI/mRh3Ha9Pdlpjtpp3JqsGY9ILlBaS/ahEk74sF" +
       "Li/RoaOE7By3poEj2lyb43Yk1ZVHSIwShWnJnkEuZ3Fuy13CE0busBNsh9S2" +
       "hiZek6tzaqNlYFiRpZmDwri/mXsbrG92VgsO7w5UvoYsW8ZmvF/2BHiSO2FL" +
       "y2a7ZRPP1GliEziM9gYLkJOrWrxsZELDXeHD8R7dc1N52qihJB3uYmzoU5O2" +
       "MqNpmaaahZ1ZPCaPhBkN/D53gnAf9OgZKlDkqrueS0EfxSaEveNJlpyhnJwG" +
       "+ZxDOXwVEzRwSEPOFWbWJSZob0IinQ2PKBTf8rB2bkyGTldl2LmmIjOnjWpw" +
       "kyJmKpou+znttDtYm9ZtZGPYi+7Sz3odptntk1of1vBRrhLtbX00lrbYZjMQ" +
       "5/V9usiJ/mTSj6U8WdaQHJV3q6at2ssJXQw3eTcZulObIkVTxYkm0p5OxVaH" +
       "2fatYCvWWkR/j3WaLjwMbZyaCM2BMZBXcGzAvTWI8uxaV6cWorYwMRsQKuOZ" +
       "qqZGVLeAaaWdkg1b1BWqT4yXyWQ7wGQTUZ001OJ+PRbNEIn2cAzDeDKpNeXc" +
       "QxZTciU1IlRqIC10Sm0wkaXpeR1udsIkm5MIkS7XDIGTPm8BsnVltJ/gAr1q" +
       "cDEdT/vFDtWwyESlkO7URaUx1QVpyvGuQtrwmk5rS4c1umZGMXt0w08m9qxV" +
       "Yzm6aczwjhozRb3Z5QvaE/PBJljKjbaMTvtyN1UZZD9vBL6f093WKqFZP6RS" +
       "0zbRxjgOnfZ8qKz8pNO0gtoqjwuwMtSHFmWyDjowcUtT1IGAruMlnFt1GJPa" +
       "MNVAXU5oI0ariYex6yb6Bp50Q0wnrTjrzpt7YQbPyVautzdsKy7GscHKFE85" +
       "O8HbS/Jq2MuwsbUmx7HYwVqtup/Qi2G9gdkmgyKqHND+dlabxAu5V29ovIsv" +
       "4XaTZ+hGC3CfoGNxu9yK3nS4HzTmBSqwAb0K0MlkUZvJ7s5Cvel2RKp1IOBs" +
       "0EabZmjtEkOrG8qKzTHS7/W7HZwabvods556xNJS95q+XHnFjphP2LaE7FKm" +
       "5kYwHPaIfurvh/JuGlnYYLOi4Z5h6BHRjQzY32q57SP4LFyitXQSOPN4qW27" +
       "XXPab3LcZpk01kVr76DpOmvAbCb4LUnJs96K2CyHJFasU4PhwvGaS1bqZtkV" +
       "1M0gypV+rcfC6hws7t2hxy0H3ISLGwgHJ7sW5jecvd+mUXay7XERuxFr6yEn" +
       "J5w6t1eStMIHrRAxGyFlztVNpMF0tsTtZZxi2wnlAjcB60K0kvWUbs3CWlyf" +
       "rL1U0XQsWcA2PuoSuT3KszadZu0xAqxM24k7c7DAnR6yUE1LIUnFxJBdwqhO" +
       "e6wUUbdGGeNaoHQGcwnRXDgesuia36k5MVDxlcCxDTvJwg7r9xu1RT8ymhmW" +
       "0oo4xgYBmXTnMGAshzOdaNl6vhjXeg2Gs5uDCU1g87pJWj0axpY9t8c6TSMb" +
       "cgw2FNJAZpiupjpOnCJzz0uMKYrSuDZc1Jim4euwOEWDkTOxGF9H+zA8i6jM" +
       "JAaRqIziPI+FbJyMXIEa7RYryve6oUZlO5zParo/XwawETcsmqnrQzbppqZP" +
       "FXAB9zuUT+2ihTolJ7lruXV3mQ4GKmq14CjmUbdZy9aR0fV6QZPDSM7Ww2Js" +
       "TzXeV3wDWxvBQhobuOq6WTtl2qbVWi13yIYc9/MBxrKrZbCn5wPbCkVxEMdZ" +
       "JjIGKnelZDuNKWbAN3Qbna4QNWyZzdVEHXggc13jDMPwgZSOmCztqlEbjdvq" +
       "hB+E+2YvE60GQ0XafhePqAyxRlqvwBwHFWbJbKeB/IDfzAaLxdZbqQkR8oza" +
       "M3Qc5bxYEThOzNP9Qm6uHbYmOcig3hbrvSY1GCE0trY2S7Q5A9+em17LZaxu" +
       "rZtzPo/Hg2Isr8PcRvzxdmCRqpPDWN/AhOYOWUZ9Q6/FLTtS/LpcJ70WbhcK" +
       "F5AwhawmFJYw5G5kw5TYjXpJk9qnGhvLEppTaD2YxlHebPfMYlw3iKS1btVa" +
       "CrFq+hmRtfHusrWMbCLM25bSbHjLtt6pI+sJqxlKPzJBbtiI26jMEm2Vwl1z" +
       "lXMDnfXMaGSZeGiGCbGk2p68toC7N3xqvorxzrDOTtexDnPNXW8W7bqESW2E" +
       "Ohr0gv4+T128T7Gwl4L5jTz2ihEBG1g62AuBaWcbX+7b8KJGogFf4KuVjmN0" +
       "eyvMlIiQrJ5aNN1RbRw0W4S3K1qSKhl9a840W7Xp1FjmWyTpCsR2nSF2sygi" +
       "nW7O+VafcAg23fDAICSdyxhj2R2PlvM2PdYBpw11TRXdBmwnw0Z7v97Gkmf0" +
       "lZBPV6IQuvuuN+QaGeoXS0JP9sKebyd+XPTpWa8xQ+Xh2pUXoant2laR7lPe" +
       "39pBzpvEHuTnOfiooDaTbhSkqYb0FpOOZ6ITxkRqWZIYS4sNQq+eib2uKsqi" +
       "JeyY6VSfTabLmYj0OIlAGjuBiLYdcTMZJSSVJp5Io5mBDW3JIZtGi9YWIHVk" +
       "BJBKRttERMzQsCl6sl502J2Ek8RAZFNXK7Z6RwtDuYeRcZiPhwPcZsZii1gw" +
       "sTdTpTqZkhrSBym0wMUqPWsqXtzRa4IoLYotPfRbcKHtjHjizRw9EOVlk2xP" +
       "B7G4DdqKWxPFbooNlnvHEBRyRfpme51HW7D0TzrRdGc1u819Y18jG0a/35v1" +
       "OCJjm1gQ+ZQeKIne9kf9PhLqQ37U8SRcWjd9ryOra9JBtkumvRWVnNRYDgd6" +
       "AEpL8dRxkRrlGTg8n4w5Z9JRxmkr6evphplJlIvsRiGSYVzG1VcMSW/6++UQ" +
       "6Vp+nScXCmVM/HnhS0XR0Do2EtYLwkhYCiZtfwAytYyAbZ6rG8jSh/NdlOGz" +
       "dhoLITPPx+Ki3MDaC7WlBxa7PG5upHU7rCu+MmioQKtYB3wIrWhjXLCT9Qqb" +
       "t7MWgWRDaj9YKI122NksgVO1Ydbrt4U+ptPuVLD4sezBdFTTCx74kjVt7GEy" +
       "GCO2XWNopdbZqt16u6HBLFhFm0OPUXWrlfH7mjrfrAVYY/zalhF5jxNHTE3w" +
       "6V4AvjOb2hatczrd0kh7QdZlfUzsRgtewuGBRGTj6WK0ak22+7rkzcc9abIA" +
       "33Y9L8PhqZFM3YURMHKHVWauThFjReG6rSxuum1Wk7mdHc9QrafN5xg3xvVB" +
       "YtowvrIbo1a45AO/N+q7A3msjHdwC6/HbLZjiRDdbRuOjqLo95ZbBJ94Z1sX" +
       "j1VbMaen1LbbLTvcd7A7ceh6rixeON24qn7XoUsnm+fPSc42wqFyz/CZex0+" +
       "V/uFr3/q1dc05qfqV48PEPgEeigJwu9x9Ux3z6G6D2B66d57o7Pq7P1sY/tX" +
       "P/U/np5/bPPxd3DE94FLdF5G+Q9nb3x1/BH1x69C951uc99xK+DioJcvbm7f" +
       "iPQkjfz5hS3uZ04l+8TJluDHjiX7sctbgme6u3M/sLKCg+4vnc9cOT0ofe4e" +
       "AuSVXaWV2+ovcd/8+peKL79x2J1dK7GeQLV73S6584JLeZL5wlucxp7dO/j9" +
       "8V9483f+q/T9J3p/16kYPnKyG3pPMZxsJr7nbqdpZd8XKpR/6x5yOB797MWj" +
       "gihKw0TXRntVD0s8FYq/WxY/mkA3wacUiLSHYzDLP2yK/vjFA9L3vp3mvlAV" +
       "Z673Y2+3MXj+fKlq+OGLM5ae5x3PaP3Z2Mq1CuDaiYyeqWSk7JIjUw+8I9Qw" +
       "LF+fg6QpLg+R77YD+sA6CFxd8U8wPHqKQdgoB7uvds3ZavqffoujxF8oi7+f" +
       "QI8AG0zDkxPIu+66ZoGlncn19T+FXN934oP7Y7nu/2zkep6xX3mLvjfL4pcS" +
       "6GFTTxjDENRI109l+f5TWVrloezRIC2/9XStOqI94/+fvRP+90BFFy9glKfJ" +
       "T91xretwFUn9udduPvjka+J/qO4gnF4XeoiCHjRS1z1/kHeufj2MdMOq+Hvo" +
       "cKwXVn9fTaAn73EpJIGuHyoVwV85wH8tgW5dhk+ga9X/ebh/m0A3zuAAqkPl" +
       "PMivJ9B9AKSs/rvwLocTh/PM/ZWLi9mpiB9/OxGfW/8+fCEeVtfqTlaYlD0O" +
       "u19+jaQ/8e3OTx2uSKiuUhQllgcp6IHDbY3TVeq5e2I7wXV98uJ3Hv35h144" +
       "iayPHgg+s9tztH3g7vcRRl6YVDcIin/65D/+6D947TerU9H/B2j/29bvKAAA");
}
