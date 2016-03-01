package org.apache.batik.ext.awt.image.rendered;
public class DiffuseLightingRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private double kd;
    private org.apache.batik.ext.awt.image.Light light;
    private org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap;
    private double scaleX;
    private double scaleY;
    private java.awt.Rectangle litRegion;
    private boolean linear;
    public DiffuseLightingRed(double kd, org.apache.batik.ext.awt.image.Light light,
                              org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap,
                              java.awt.Rectangle litRegion,
                              double scaleX,
                              double scaleY,
                              boolean linear) { super();
                                                this.kd =
                                                  kd;
                                                this.light =
                                                  light;
                                                this.bumpMap =
                                                  bumpMap;
                                                this.litRegion =
                                                  litRegion;
                                                this.scaleX =
                                                  scaleX;
                                                this.scaleY =
                                                  scaleY;
                                                this.linear =
                                                  linear;
                                                java.awt.image.ColorModel cm;
                                                if (linear)
                                                    cm =
                                                      org.apache.batik.ext.awt.image.GraphicsUtil.
                                                        Linear_sRGB_Pre;
                                                else
                                                    cm =
                                                      org.apache.batik.ext.awt.image.GraphicsUtil.
                                                        sRGB_Pre;
                                                java.awt.image.SampleModel sm =
                                                  cm.
                                                  createCompatibleSampleModel(
                                                    litRegion.
                                                      width,
                                                    litRegion.
                                                      height);
                                                init(
                                                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                    null,
                                                  litRegion,
                                                  cm,
                                                  sm,
                                                  litRegion.
                                                    x,
                                                  litRegion.
                                                    y,
                                                  null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        final double[] lightColor =
          light.
          getColor(
            linear);
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              wr.
              getSampleModelTranslateX(
                ),
            minY -
              wr.
              getSampleModelTranslateY(
                ));
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int r =
          0;
        int g =
          0;
        int b =
          0;
        int i =
          0;
        int j =
          0;
        double x =
          scaleX *
          minX;
        double y =
          scaleY *
          minY;
        double NL =
          0;
        final double[][][] NA =
          bumpMap.
          getNormalArray(
            minX,
            minY,
            w,
            h);
        if (!light.
              isConstant(
                )) {
            final double[][] LA =
              new double[w][3];
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                light.
                  getLightRow(
                    x,
                    y +
                      i *
                      scaleY,
                    scaleX,
                    w,
                    NR,
                    LA);
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    final double[] L =
                      LA[j];
                    NL =
                      255.0 *
                        kd *
                        (N[0] *
                           L[0] +
                           N[1] *
                           L[1] +
                           N[2] *
                           L[2]);
                    r =
                      (int)
                        (NL *
                           lightColor[0]);
                    g =
                      (int)
                        (NL *
                           lightColor[1]);
                    b =
                      (int)
                        (NL *
                           lightColor[2]);
                    if ((r &
                           -256) !=
                          0)
                        r =
                          (r &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((g &
                           -256) !=
                          0)
                        g =
                          (g &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((b &
                           -256) !=
                          0)
                        b =
                          (b &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    pixels[p++] =
                      -16777216 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                p +=
                  adjust;
            }
        }
        else {
            final double[] L =
              new double[3];
            light.
              getLight(
                0,
                0,
                0,
                L);
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    NL =
                      255.0 *
                        kd *
                        (N[0] *
                           L[0] +
                           N[1] *
                           L[1] +
                           N[2] *
                           L[2]);
                    r =
                      (int)
                        (NL *
                           lightColor[0]);
                    g =
                      (int)
                        (NL *
                           lightColor[1]);
                    b =
                      (int)
                        (NL *
                           lightColor[2]);
                    if ((r &
                           -256) !=
                          0)
                        r =
                          (r &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((g &
                           -256) !=
                          0)
                        g =
                          (g &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((b &
                           -256) !=
                          0)
                        b =
                          (b &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    pixels[p++] =
                      -16777216 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                p +=
                  adjust;
            }
        }
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfWwUxxWfO9vnDwz+AIxrwIAxNBC4KxAKjYEE2zg2OWPL" +
       "JrSxmxxzu3O+xXu7y+6cfZhQAlIDilQUBZLSNtBKBTVFBKKoqFGjUNKvJEpT" +
       "BE3bJKhJ2/yRtAlS+KNxWtqmb2Y/b+8D+KPqSTu3N/Pem/fmvfm9N3Onr6Iy" +
       "Q0ctGlZEHKa7NGKE+9l7P9YNInbI2DC2Qm9MePTPh/dO/rZyXxCFhtC0JDZ6" +
       "BWyQLonIojGE5kqKQbEiEGMLISLj6NeJQfQxTCVVGUIzJaMnpcmSINFeVSSM" +
       "YBvWo6gOU6pL8TQlPZYAiuZFuTYRrk1ko5+gLYqqBVXb5TI0ZTF0eMYYbcqd" +
       "z6CoNroDj+FImkpyJCoZtC2jo9s1Vd41Iqs0TDI0vENebS3E5ujqnGVoebbm" +
       "k+uPJWv5MkzHiqJSbqIxQAxVHiNiFNW4vZtkkjJ2oq+hkiia4iGmqDVqTxqB" +
       "SSMwqW2vSwXaTyVKOtWhcnOoLSmkCUwhihZkC9GwjlOWmH6uM0iooJbtnBms" +
       "ne9Ya7vbZ+ITt0eOfPPB2udKUM0QqpGUQaaOAEpQmGQIFpSk4kQ3NooiEYdQ" +
       "nQIOHyS6hGVpwvJ2vSGNKJimIQTsZWGdaY3ofE53rcCTYJueFqiqO+YleFBZ" +
       "v8oSMh4BWxtcW00Lu1g/GFglgWJ6AkPsWSylo5Ii8jjK5nBsbL0XCIC1PEVo" +
       "UnWmKlUwdKB6M0RkrIxEBiH4lBEgLVMhBHUeawWEsrXWsDCKR0iMokY/Xb85" +
       "BFSVfCEYC0Uz/WRcEnipyeclj3+ubll3aLfSrQRRAHQWiSAz/acAU7OPaYAk" +
       "iE5gH5iM1UujT+KGFw8GEQLimT5ik+bHD127e1nzhVdMmtl5aPriO4hAY8KJ" +
       "+LRLczqWfKmEqVGhqYbEnJ9lOd9l/dZIW0YDpGlwJLLBsD14YeBX9z98inwY" +
       "RFU9KCSocjoFcVQnqClNkol+D1GIjikRe1AlUcQOPt6DyuE9KinE7O1LJAxC" +
       "e1CpzLtCKv8NS5QAEWyJquBdUhKq/a5hmuTvGQ0hVA4PqoanFZkf/k3R7khS" +
       "TZEIFrAiKWqkX1eZ/cyhHHOIAe8ijGpqJA7xP7p8RXhNxFDTOgRkRNVHIhii" +
       "IknMQb5P8TiNSCkIhgg4RwQPiZFOKZFIGyQqjSQpBNwAEcMsCLX/7/QZtjrT" +
       "xwMBcNwcP2zIsOO6VRkExIQj6fZN187EXjNDkm0ja10puhN0CJs6hLkOHGRB" +
       "hzDXIWzrEM7VAQUCfOoZTBczXsDbo4AbANzVSwYf2Lz9YEsJBKo2XgquYqSL" +
       "cxJZhwswdlaICacvDUxefL3qVBAFAYPikMjcbNKalU3MZKirAhEBzgrlFRtb" +
       "I4UzSV490IWj4/u27f0C18ObIJjAMsA2xt7PYN2ZotUPDPnk1hz44JOzT+5R" +
       "XYjIyjh2oszhZMjT4ne03/iYsHQ+Phd7cU9rEJUCnAGEUwxbDtCx2T9HFgK1" +
       "2WjObKkAgxOqnsIyG7IhuIomdXXc7eERWMffZ4CLp7AtOReeTdYe5d9stEFj" +
       "7SwzYlnM+Kzg2WL9oHbszd/8dRVfbjux1HgqgkFC2zxgxoTVc9iqc0Nwq04I" +
       "0P3xaP/hJ64eGObxBxQL803YytoOADFwISzz11/Z+da775x4I+jGLIVsno5D" +
       "YZRxjGT9qKqIkSzOXX0ADGVABBY1rfcpEJVSQsJxmbBN8q+aRSvOfXSo1owD" +
       "GXrsMFp2YwFu/+fa0cOvPTjZzMUEBJaM3TVzyUyEn+5K3qjreBfTI7Pv8txv" +
       "vYyPQa4AfDakCWJCLl+DcoNFtWffsgpxMB03aL8upcARY1b+OtswufMX5ROd" +
       "dm7Kx2JS3mv0XvxJ9/sx7ugKtr9ZP7N9qmfnbtRHPFFWazrgM/gE4PkPe9jC" +
       "sw4zE9R3WOlovpOPNC0D2i8pUkBmmxDZU//u6FMfPGOa4M/XPmJy8Mijn4UP" +
       "HTG9ZxY1C3PqCi+PWdiY5rBmLdNuQbFZOEfX+2f3vPD0ngOmVvXZKXoTVKDP" +
       "/P7fvw4f/dOrefA9JKoQv+Z2XcUi2sHiBr+DTKtCK479Y+8jb/YBePSgirQi" +
       "7UyTHtErFgozIx33eMytmHiH1z7mHYoCS5kjWE8jAN0NMg7PMDZx5GbTU3s6" +
       "pfVizear51HO6AYg+KFUNEuMNbzhRKstB7CvOz3vGygqj6uqTLDiXzT2szPD" +
       "zbuDj0UcCsQpEB8bYE2r4c0F2XHnOUPEhMfe+Hjqto/PX+O+yz6EeKEPbDMD" +
       "p441i1jgzPLn3W5sJIHujgtbvlorX7gOEodAogCVhtGnwzJlsoDSoi4rf/ul" +
       "nzdsv1SCgl2oSlax2IV5zkGVAPbESEINkdHuutvEuvEKaGq5qSjHeAYv8/ID" +
       "16aURjnUTDw/60frfnD8HY6x5orPdmBmfk55wA+wbmb76Mp33vvp5PfLzZ1Q" +
       "ZF/7+Br/2SfH9//l05xF5ok8z1b38Q9FTj/V1LHhQ87vZlTGvTCTW3xBzeHy" +
       "rjyV+nuwJfTLICofQrWCdVjchuU0y1NDcEAy7BMkHCizxrMPO2Zl3+ZUDHP8" +
       "WOOZ1p/Lvbu3lGbtVDd9s+oaNcBzm5XZbvOn7wDiLwJnWczbJaxZZmfLck2X" +
       "xgB5felyShGhFAVHRWdzTueMg6wRTSHbCsbeA9maN8Kz3JpkeQHNZVNz1iRy" +
       "VSzETVGZzFCJ/ejyaZm6RS3nwLPSmmdlAS2NoloW4mbAZaIg+9nt05Peop4t" +
       "8Ky1ZlpbQM+JonoW4oakZAhYJl/J5/Td/wM197HmIXva+/NNu/8Wp50Pz3pr" +
       "2vUFpn2k6OoU4qaoUpboABmxCtzNPk0P3KKms+Fpt+ZqL6DpN4pqWogbFpQd" +
       "5TGHwahPzUNF1My40y11puOfEPKd7z3TeXIFYulvbqErGF4zndh/5LjYd3JF" +
       "0ErKd8G6UlVbLpMxIntEBXgF5k87vfziycXwNZcnS6483lideyBlkpoLHDeX" +
       "Fs5P/gle3v+3pq0bkttv4aQ5z2e/X+QPe0+/es9i4fEgvzszU0bOnVs2U1t2" +
       "oqjSCU3rSnZh1+J4rMnef9jyGPaHlxsTPmc7Z6hCrL7yyq5a2W+o7uY61Z1Z" +
       "BX5Zlyg7Eg1gg0KZw6hOFCnQnmbNdymqYPfUnZhi9vukG7vfu9EWyyp6WMdw" +
       "BlJ17g0JK4gac+5zzTtI4czxmopZx+/7Az+lO/eE1XAgSqRl2ZuvPe8hTScJ" +
       "iVtRbWZvjX+dpejzN1kqg932KzfmjCnhOYqai0uALMi/vVznKGosxEVRCbRe" +
       "6ucpmpGPGiih9VK+QFGtnxLm599euvMUVbl0gEjmi5fkJZAOJOz1Z875YNXN" +
       "nis2wqFVh4IYvJkJZEOQEy8zbxQvHtRamIUJ/C8Be/+mzT8F4CB9fPOW3de+" +
       "eNK8BxFkPDHBpEyBg5d5JeNgwIKC0mxZoe4l16c9W7nIxsE6U2F3Z872bIxh" +
       "2GMaC9om3yWB0ercFbx1Yt351w+GLkMpPIwCmKLpw7k1akZLA0ANR/MdMQEh" +
       "+f1FW9V72y9++nagnh8FLChuLsYREw6fv9Kf0LRvB1FlD0Qj+CjDC+jOXQqc" +
       "88b0rBNrKK6mFeffg2lsh2H2dwFfGWtBpzq97B6Nopbc83vu3SKcksaJ3s6k" +
       "c1z0oWZa07yjfGU7WLM2w1YawjEW7dU06+IitIqvvKZxIPkdazr/C+7Sxs73" +
       "GwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mZ+6ZD37I9AiD1qUQOAKWB8MQnJs2u9Jnz77t3/8p7e/7Rs3QTsEdMFyBZkQ" +
       "cgaFzgPqUgINhKTE+8k3b2fu+hxILuWqQlcpvx2qO/O7C88/B4hsSXrIv3f+" +
       "B2uJ7/77f79qEPKwcY1pcaI+jzzzkbuwN30vr3/I31nte5KrYy1Yvh/WLX3C" +
       "/tedB858cQc6y0OXpL13g6lgRRkr8mA9HOy/MID3h2Plx9e224XcYwfx6VUn" +
       "5+WRbk9GjsP5APKZdJa/cCJYZIsp6HZwPbTHow+dDBanoDwzzKvcn6dXsuS1" +
       "+9x81vP1GEzrvOVKCO2Y8oHXX8rl8SwZbU3Zva7Z+8dB3QmuR/dAPXodUPx1" +
       "QGXZ6T6e01Y2t7Ob15+A9JYXCelV4CrtQSpdB5JwI5DOilviyG7fcAKU+CJB" +
       "PQCuxh6oxnVAaTcC6kwgCZYyv5bt9P8DTO6NY1pcC5P3IjHdB6437mF643Uw" +
       "xTeC6bylh0Nlubf0edMJWOsXCeuV4EL3YKHXgfXEDQ1V9kol5Pz05hOY3vGC" +
       "mLZh6RSYzadLu/XdPEz93LV7vSnLPpSZJt9zADVU3RGsfRh3GJZ0ZT/kTxU/" +
       "AON0xbDq+zHyUh4tMnLb3b64n8BauWGsIBrcetgY7TrLx977Dx/42vsf/Dag" +
       "7B50Os7oFDD1kR6ZKNsW+YVnPnj3S576znvzFSYYRu5D+KV8yN7/fBpnyZNZ" +
       "8ov7qt6VqTrKX+NoIQj7+aJQkQ+0PRHsb7bc/4W24a2/3K0EZGv/15/y6mw9" +
       "SZKZyjZjp71O4RaZ+GuylTAoVqGSFmUscLyULkvsjKN7/iixkySNyiyczKP6" +
       "Bq5JKq8NWhbZ1q3BBOXpEROiFDqeEihFuSuiY0wYKu7h3hjFy2KP0nolZDMM" +
       "W9YIpphkFq5ssbRARLjRhiluNRpHZQbhFBtR7Vi1m0yZdfwauRkUpLBj8XiX" +
       "EupMh8LhplXnmguGdESy1MZKA7vZV7gxpyEyi/j8Zp5ghBZihV6br6GzzQCY" +
       "lXSNDl41V9RAxHW806fJEW3UGKU3UAfJGJtOOxMy7Ql9x5PsEckQynQ06i/Q" +
       "eObWluyk5tGN8cDi+EVLj3giGi+Gvlk03Sq8pBerFTqdi9UxWeDHREHpLxai" +
       "tJLTGuYyvts2YIK0TW/Tw1w+xEqG2wyKU7lSJFdBYdwmCzHOKOKojFcjY+V0" +
       "pq4iirYJR1xvFlf7ZtrVV72RuCKTQSuZdnVGJ5hZJeZD0zR6JXcFa6auCxW9" +
       "Y6/a09U4WaEA9no1K8Wj9VwYb6YUG840yWFdemSb2GSt6RpvYs3O2rDYmd2t" +
       "Rf2C7ro9MXRQO3CU5kKoxyIPk+OwoLAqx6GlSKYm/cJg5XUmA0FgW7g3sDsD" +
       "kvBGZsUclBnX1fGFPHAGJNvdjGpaZ+qt4x4A0GGonm6Tg3HAzzqysCi7Kl4t" +
       "+xI2XvQihVjpKxZeWAqB8nHDHfW1CjpLQmlWKNBRcYl0iKW1nPVqLZMLZqON" +
       "5VZJvWEYVNVBA5EuzDESK3L41J04M5uyJmuZQmv9wtD0yQRH9W7FQvElPe1r" +
       "aHeiCOsZHvjzWdDGqGFB77vmApmLjSpKjKYqhi+wwiRFZkMJd3RvA5ZIRhkG" +
       "y36rLNDqyB8Mh63uYKaPWikiSK1JneWERcvU8eqyW9X7xUlkjGGqQ6wbHXxA" +
       "6/a4qpuw2G0XS3Wl6KTaVO7boVUVwJsJW9FaiwbVg+khLaWrmUrZ+Gra0VYL" +
       "EXd6TYuVmxYi8+SssGh7HWvdo2k0aBcrCwWdN9NmQ3fWiyExaVLYyJUMl5Cm" +
       "A2eFWYzpWnC72CEN3RwqxZY1kQYsF9bamwhvglcgvM4W6V4rwZQi5qV0iFFx" +
       "gxlVBy18tumtIlSeaNQKEaqaHY3jzqCgTVsVbuUKDsGbKmKWh3VTG415nCT8" +
       "lk7NVua8qPCItNG6XZZsKQ3d6HirXquecHWvMZxrTEK0x+xyaA6ZaZfUdJ00" +
       "nf5ArHKNsc6MMJPUlsvKcD3gdJ5gKZ4gO5vByhgNPJRZt3CpH2D0HKkjAz40" +
       "/HGy7qMSs5a4UkoGLFubDk08IQdGTeWZYqOOzw2mbdoFQygWvEhjClgvqGm0" +
       "yXY7Q1RL23Nylvp4vz5tDSaYyrr8GJXSedAW3UpLbDHpdLReqCU6bS7woIdS" +
       "bmm+XEWL1YiWkh6vrYO1bAkkJkhxe5IoKl1eTdEW0Vpwutk3JJGhBGtS7vOU" +
       "7rc0HE2XvkUMQ5GsTNLRtNIskDOjgkSlulrAig1WJHtGqx+0SklY5xZMiXfD" +
       "CdfmHLOopZVKj03HcHU4XxjkxtBKbpBqfN8YVxylUEb0RdAdwJwm16VJ08d7" +
       "E8xpdfDJOhHbIZaUxs0usaSKpZnBipTZWibsygnITadOahHp2vJ8LtUVfDjr" +
       "qypfwWiv3grZoaKM5YVSlZtBiBNGfbROF5bThylA9jO66XbFIJWRhjycqqIR" +
       "JcXucrU0CayUJsvEHU+lpr6SCsx6VaiQBa6cCByi9WoVpcOKCZoM6EahvNiE" +
       "LttqE2tylKbFIsLDslCvV5MKCRsdmpwGjlttL/hhYnTGzRW1Is1Rys7nhVa7" +
       "M22h6KLoq5KH96ajQdBLbBFlGitYGI5iVp2P3KK7bnfmftAnvNJiTUQIrAoF" +
       "iY25scGn/QmOAjIvj6fpZrLBHbhKlVeGr6DqmKxzcSNM4nix4QZCpaW2BROb" +
       "9TAaTCHJZYhwpqrB0kv6aAHM/0bkSa3hoijCbBisI7U/rw5ZWbbrVFLqjcp2" +
       "XJjHSa+JBEk9WlKh3+S5OtNc2aojhsMuRxAzIfWXfWSJVziTU5oGFqwrKd4c" +
       "lmes5cYeyzFYoV3SG97ERG07afMTBIlqRF/lOqxQ6SNzzu5tGn3dcCoTrjvu" +
       "NPlkUcTK3ArTYW4m64uqj9q0zEQDkeBZXJ3DJbUcc+2Cs2TtaTznqTkwFtXm" +
       "EK6uxuuKCkKkr6itZo9yBzHMl+bSRC8FXR314faYAtxQqTcXcMMQkQWqcKOl" +
       "7g/0+mQz7oa4TyzdlEzKZaW/Ce2u3i2mdbu7cLFR1TRmeMNoMQWmv6xz/Taf" +
       "VDvieFIOap461VOwpKwWu2yttVjCFDFh8KjPiKk2pIIQrWMxm5bjzma5MmrR" +
       "aky39Xk6LgUp107FqG0UJhIWDDwcbYgLvORXpAJRmncddsLhWl9V4K6xCl2E" +
       "m8MsvElruELhnNjut71KpagXjWXK0U55Vg16ZDcylqEYW64/ry9Z3JVb7hKb" +
       "amHHWac9K3DbI1ev+CoSWU4qB3FxhC2tkjuyhKRETqupCZySE/ERTjKm3I2i" +
       "MMajGKeEzqq6GhldpbWIGwjZLtaEydBwJuP2GqkVVF912o3uopZUXZ+TbdRW" +
       "zWp13YLXoi3Wa32vXI5jr8qpdMoXBzyB1GHUR0ojtdtEEKtQTYiqazbSolhu" +
       "DJrE2ECmRbqrDRr1mLfGnXiMjWflBE2V7sY3NlPYidY9dUyTmKsO/BkmTw1J" +
       "iyaFTZFpS3hrU0f7ZhfT08Tvc2yJt8owP2l3ucaMZfmih9CxGJWtjhhO24AU" +
       "YFdgJDS1q3NejFmnvm7r9LrnzKRU7AkJz9sqLZmlebJEq6pibUZaRyNa0+5w" +
       "JqfjSOkva+vheNQVsUBUWk1bYBpUWu55pjLoMvyUSYv6cDMdpfh42uFTAush" +
       "irEReLs2HJWdNc2NbFu2WqMS41rurGKLLV4gl3DTCQtVTnG9StigNkXe8sRB" +
       "H+65DpBxBZNvaYuehfSqyFhG1v1is961yXkswAjDREhj5lULXFr2/FI8ITyn" +
       "ZNZYd1JZCe7EE90WaidYmDKcCdiMouwAJrwQ5ld0re0xFW81c5ci4Q3k6rjT" +
       "XQsal04YotjfVMDgFr2IVXGOkutpeazMSWIRWbG4wv0OUUkdWUOqtLGQyz2i" +
       "gPuU3OjUJtZUpL1+Qjohjs6XRNUEBlVTfSPN1wwvOaNapVG2dFnZoJbpuXS3" +
       "rcyJoMohS0spx3DZWxVEMwzjijCopiUFmcMDTinAiBI09YqKL+M0SCcFkXWm" +
       "QWlSDME60Rhhk7I/cnitCPcqft9R1Kax6XBC10qCMWdLdb6mYT5d32xWVaE0" +
       "g916tKgV+SKPzqu8tVnW8WVxuSxQ/LqmsQTmDBxbZOSNvVpw6gQ0qzfjyOwA" +
       "LaImWFVsvNqsL69Rq1esLws9qrIUJLiapuOQrEhpYrsen8BIvZXCFosoeHHe" +
       "Wo5WQ6vERzGnNLTxSOrp03AozvjYmMOypxgpUzRXy2a5RKWqbWCOxi5Wgl6I" +
       "WnRfR+Jp6lAdN0jw6RATh0otkjzb63AdXdeaUwoeEJ3QSWi72mwqUdyfTEWr" +
       "sMQNW6+qZo9vsSD0FvlGvbpg5oyjB6X1iphqFXIR90Axzg7wTSMVk0HcDYeC" +
       "TU56CNZAFQS203GDqGBoU+XYWVlWYIWhGmhCmFy7i3r4Bl1W5WpPYZZrksIK" +
       "dsK7SsUq1qTmrO6QSYDXJiWiDPotiWSilTp9AWu6dnkzQwuKLxFiUlyE5Wpx" +
       "DXdos+9x5BqzKdpb180i8HS6VWgxQ6Qv9we4BqtFYtac1kubJgw7wtLRGgSN" +
       "aREdLIb4uqbGTUot0MMYLRJWuzAwYMxoY7DBzgcrqdEQCz7K+BRVswlFVZcl" +
       "K9BK3ZK8JtTOLES9dNWsozXG9USpUY6j8oiSzEDoAWo3pWJacGe8UKhvDLUz" +
       "qc/ofmldXAhrA5/V5UmhBpN6SK7imOITkjNlEAsRDK6PkqBe7qxbrey19Dde" +
       "3OvybfnOwMH5PnhLzgre+yLeiLdF92fJqw92UfLfGejEmfCRXZQjO8hQtsd9" +
       "9/WO7fMzh4+9+6mnZfbjxZ29nfd6CJ0PXe9RS4kV60hT2fbDI9ffjO7nXy0c" +
       "7gh/6d3/fNf4TdrbXsQh5r0ncJ5s8rf7z3yl8xrpV3agmw72h6/6nuJ4pceO" +
       "7wpf8JUw8p3xsb3huw9G9q79rTxhb2SFk/tTh7a79ubUQ1vbnzjYOLU3gHs7" +
       "QncfnJpsT1dmvh5mR2tDIQgVP2/hd57naORzWfJMCJ2TXG/TFkIhu//soUN9" +
       "8oW2WI4dN4TQ5asPubMTuzuv+iRn+xmJ9KmnL5674+nJX+XnvAefepynoXNq" +
       "ZFlH9+CP5M94YCWn5/jPb3fkvfzvD0LotTd4+AQ03s/manx+28IfhdA9z99C" +
       "CJ3O/4/W+pMQuvN6tULoJpAelf5iCL38WtJAEqRHJb8cQpdOSoL+8/+jcl8N" +
       "oQuHciF0Zps5KvJ10DoQybJ/fnDiVr7Rk7qWGIS+IIXAmsmp44xw4CmXX8hT" +
       "jpDIg8emfv5V1/40jbbfdT0uffrpHvP252of356kS5aQplkr52jo7PZQ/2Cq" +
       "33/d1vbbOtN9+Ee3fub8q/dp6dYt4MMJeATbvdc+tsZtL8wPmtPfv+N33/Cb" +
       "T38r3//8H2PnRJ1uJwAA");
}
