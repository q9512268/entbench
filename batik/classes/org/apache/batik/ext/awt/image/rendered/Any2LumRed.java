package org.apache.batik.ext.awt.image.rendered;
public class Any2LumRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public Any2LumRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          src,
          src.
            getBounds(
              ),
          fixColorModel(
            src),
          fixSampleModel(
            src),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
        props.
          put(
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              PROPERTY_COLORSPACE,
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              VALUE_COLORSPACE_GREY);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.image.Raster srcRas =
          src.
          getData(
            wr.
              getBounds(
                ));
        if (srcCM ==
              null) {
            float[][] matrix =
              null;
            if (sm.
                  getNumBands(
                    ) ==
                  2) {
                matrix =
                  (new float[2][2]);
                matrix[0][0] =
                  1;
                matrix[1][1] =
                  1;
            }
            else {
                matrix =
                  (new float[sm.
                               getNumBands(
                                 )][1]);
                matrix[0][0] =
                  1;
            }
            java.awt.image.BandCombineOp op =
              new java.awt.image.BandCombineOp(
              matrix,
              null);
            op.
              filter(
                srcRas,
                wr);
        }
        else {
            java.awt.image.WritableRaster srcWr =
              (java.awt.image.WritableRaster)
                srcRas;
            if (srcCM.
                  hasAlpha(
                    ))
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    srcWr,
                    srcCM,
                    false);
            java.awt.image.BufferedImage srcBI;
            java.awt.image.BufferedImage dstBI;
            srcBI =
              new java.awt.image.BufferedImage(
                srcCM,
                srcWr.
                  createWritableTranslatedChild(
                    0,
                    0),
                false,
                null);
            java.awt.image.ColorModel dstCM =
              getColorModel(
                );
            if (!dstCM.
                  hasAlpha(
                    )) {
                dstBI =
                  new java.awt.image.BufferedImage(
                    dstCM,
                    wr.
                      createWritableTranslatedChild(
                        0,
                        0),
                    dstCM.
                      isAlphaPremultiplied(
                        ),
                    null);
            }
            else {
                java.awt.image.PixelInterleavedSampleModel dstSM;
                dstSM =
                  (java.awt.image.PixelInterleavedSampleModel)
                    wr.
                    getSampleModel(
                      );
                java.awt.image.SampleModel smna =
                  new java.awt.image.PixelInterleavedSampleModel(
                  dstSM.
                    getDataType(
                      ),
                  dstSM.
                    getWidth(
                      ),
                  dstSM.
                    getHeight(
                      ),
                  dstSM.
                    getPixelStride(
                      ),
                  dstSM.
                    getScanlineStride(
                      ),
                  new int[] { 0 });
                java.awt.image.WritableRaster dstWr;
                dstWr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      smna,
                      wr.
                        getDataBuffer(
                          ),
                      new java.awt.Point(
                        0,
                        0));
                dstWr =
                  dstWr.
                    createWritableChild(
                      wr.
                        getMinX(
                          ) -
                        wr.
                        getSampleModelTranslateX(
                          ),
                      wr.
                        getMinY(
                          ) -
                        wr.
                        getSampleModelTranslateY(
                          ),
                      wr.
                        getWidth(
                          ),
                      wr.
                        getHeight(
                          ),
                      0,
                      0,
                      null);
                java.awt.image.ColorModel cmna =
                  new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8 },
                  false,
                  false,
                  java.awt.Transparency.
                    OPAQUE,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
                dstBI =
                  new java.awt.image.BufferedImage(
                    cmna,
                    dstWr,
                    false,
                    null);
            }
            java.awt.image.ColorConvertOp op =
              new java.awt.image.ColorConvertOp(
              null);
            op.
              filter(
                srcBI,
                dstBI);
            if (dstCM.
                  hasAlpha(
                    )) {
                copyBand(
                  srcWr,
                  sm.
                    getNumBands(
                      ) -
                    1,
                  wr,
                  getSampleModel(
                    ).
                    getNumBands(
                      ) -
                    1);
                if (dstCM.
                      isAlphaPremultiplied(
                        ))
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      multiplyAlpha(
                        wr);
            }
        }
        return wr;
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm !=
              null) {
            if (cm.
                  hasAlpha(
                    ))
                return new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8,
                  8 },
                  true,
                  cm.
                    isAlphaPremultiplied(
                      ),
                  java.awt.Transparency.
                    TRANSLUCENT,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
            return new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_GRAY),
              new int[] { 8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
        }
        else {
            java.awt.image.SampleModel sm =
              src.
              getSampleModel(
                );
            if (sm.
                  getNumBands(
                    ) ==
                  2)
                return new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8,
                  8 },
                  true,
                  true,
                  java.awt.Transparency.
                    TRANSLUCENT,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
            return new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_GRAY),
              new int[] { 8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int width =
          sm.
          getWidth(
            );
        int height =
          sm.
          getHeight(
            );
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm !=
              null) {
            if (cm.
                  hasAlpha(
                    ))
                return new java.awt.image.PixelInterleavedSampleModel(
                  java.awt.image.DataBuffer.
                    TYPE_BYTE,
                  width,
                  height,
                  2,
                  2 *
                    width,
                  new int[] { 0,
                  1 });
            return new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              width,
              height,
              1,
              width,
              new int[] { 0 });
        }
        else {
            if (sm.
                  getNumBands(
                    ) ==
                  2)
                return new java.awt.image.PixelInterleavedSampleModel(
                  java.awt.image.DataBuffer.
                    TYPE_BYTE,
                  width,
                  height,
                  2,
                  2 *
                    width,
                  new int[] { 0,
                  1 });
            return new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              width,
              height,
              1,
              width,
              new int[] { 0 });
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwUxxWfu/P3t41tiMHGGEOEgbuQhEjUJI057GB6Nq5N" +
       "iGoajrndOd/ivd1ld84+O02bpK2glRohQoBWiv9yFKVNCKoatZWayFWkJhFp" +
       "paSobVqFVuo/6QdqUKX0D/r13uze7d7enQlV25N2dm/mzXvzvn7v7b50nVRa" +
       "JulhGg/zBYNZ4WGNT1DTYnJUpZZ1GObi0oUQ/euxD8f3BEnVNGlKUWtMohYb" +
       "UZgqW9OkW9EsTjWJWeOMybhjwmQWM+coV3RtmnQo1mjaUBVJ4WO6zJDgCDVj" +
       "pJVybiqJDGejDgNOumNwkog4SWTIvzwYIw2Sbiy45Os85FHPClKmXVkWJy2x" +
       "E3SORjJcUSMxxeKDWZNsN3R1YUbVeZhlefiEutsxwcHY7iIT9F1u/vjmmVSL" +
       "MMEaqmk6F+pZk8zS1Tkmx0izOzussrR1knyRhGKk3kPMSX8sJzQCQiMgNKet" +
       "SwWnb2RaJh3VhTo8x6nKkPBAnGwqZGJQk6YdNhPizMChhju6i82gbW9eW1vL" +
       "IhWf3R45d+FYy3dDpHmaNCvaFB5HgkNwEDINBmXpBDOtIVlm8jRp1cDZU8xU" +
       "qKosOp5us5QZjfIMuD9nFpzMGMwUMl1bgR9BNzMjcd3Mq5cUAeX8q0yqdAZ0" +
       "7XR1tTUcwXlQsE6Bg5lJCnHnbKmYVTSZk43+HXkd+z8DBLC1Os14Ss+LqtAo" +
       "TJA2O0RUqs1EpiD0tBkgrdQhAE1OusoyRVsbVJqlMyyOEemjm7CXgKpWGAK3" +
       "cNLhJxOcwEtdPi95/HN9fO/Tj2kHtCAJwJllJql4/nrY1OPbNMmSzGSQB/bG" +
       "hoHYedr52ukgIUDc4SO2ab7/hRsP7uhZecumWV+C5lDiBJN4XFpONL27Ibpt" +
       "TwiPUWPoloLOL9BcZNmEszKYNQBhOvMccTGcW1yZ/Mnnnvg2+1OQ1I2SKklX" +
       "M2mIo1ZJTxuKysyHmMZMypk8SmqZJkfF+iiphueYojF79lAyaTE+SipUMVWl" +
       "i/9goiSwQBPVwbOiJfXcs0F5SjxnDUJINVykAa4wsX/izgmLpPQ0i1CJaoqm" +
       "RyZMHfW3IoA4CbBtKpKAqJ+NWHrGhBCM6OZMhEIcpJizgJlJ53lESYP7I+AO" +
       "GXwiQ54v3B3LpCeZHMZwM/5fgrKo8Zr5QACcscEPBSpk0QFdhY1x6Vxm3/CN" +
       "S/Erdphhaji24uRukB22ZYeFbAGcIDssZIdzssOubBIICJHteAbb9+C5WcAA" +
       "AOGGbVOPHjx+ui8EQWfMV4DZkbSvoBhFXaDIoXtceqWtcXHTtV1vBElFjLRR" +
       "iWeoirVlyJwB1JJmncRuSECZcqtFr6daYJkzdYnJAFblqobDpUafYybOc9Lu" +
       "4ZCrZZi1kfKVpOT5ycrF+SePfOmuIAkWFggUWQnYhtsnENbz8N3vB4ZSfJtP" +
       "ffjxK+cf112IKKg4uUJZtBN16PMHhd88cWmgl74af+3xfmH2WoBwTiHlAB17" +
       "/DIKEGgwh+aoSw0onNTNNFVxKWfjOp4y9Xl3RkRrq3huh7Cox5TsgGu3k6Pi" +
       "jqudBo5r7ejGOPNpIarF/VPGc7/62R/uEebOFZZmT0cwxfigB8yQWZuArVY3" +
       "bA+bjAHdBxcnnnn2+qmjImaBYnMpgf04RgHEwIVg5q++dfL9315bvhp045xD" +
       "Nc8koCnK5pXEeVK3ipIgbat7HgBDFXACo6b/YQ3iU0kqNKEyTKy/N2/Z9eqf" +
       "n26x40CFmVwY7bg1A3f+jn3kiSvH/tYj2AQkLMauzVwyG+HXuJyHTJMu4Dmy" +
       "T77X/c036XNQKwCfLWWRCcgNOLmOh1rHyT2fFFaiQIInBFwRDt8tONwlxnvR" +
       "WIIvEWt7cNhieROnMDc9DVdcOnP1o8YjH71+Q2ha2LF542SMGoN2aOKwNQvs" +
       "1/qB7QC1UkB378r451vUlZvAcRo4SgDd1iET9MgWRJVDXVn96x+/0Xn83RAJ" +
       "jpA6VafyCBUJSmohM5iVAnDOGp9+0A6M+RoYWoSqpEj5ogl0zsbSbh9OG1w4" +
       "avEHa7+394WlayJCDZvHei/DO3HYno9V8avyF01vrBZwMEl3ub5G9GTLT51b" +
       "kg89v8vuPtoKe4VhaIVf/sU/3glf/N3bJYpSLdeNnSqbY6pHZghFFtSRMdHy" +
       "uVj2QdPZ3/+wf2bf7ZQQnOu5RZHA/xtBiYHyJcF/lDef+mPX4QdSx2+jGmz0" +
       "mdPP8sWxl95+aKt0Nij6W7sQFPXFhZsGvYYFoSaDRl5DNXGmUYT95nwAdKFj" +
       "++AacgJgqDQil4idPM6V2+rLah9adItQdtHhEVPhAhSoBZ26EHtkFVyYxuGz" +
       "nNTgm+R+yin+f0SQfgqHSTve7/8Pcw0nooaYH8tr3ItrO+FacjReWsVYYhzA" +
       "YadgGoQQN0ydQ84yeLupssRrma9stK/CvLQ58e99Qm5qFWudwOE4J41JJQvA" +
       "oZuYImrOFXf4XOGjEPak/wN7bsK1CFxXHJWv3I498VHGgZUwYjmOtzJidhUj" +
       "LuIAXVITGHGKpg2VFVixy2dFP4kwo/XfMGOWkzq3Nce6sK7oo4D9IitdWmqu" +
       "Wbv08C8FPOZfNhsA6JIZVfXghBczqgyTgY6C0i6Thrh9hZM7P2GNh8TMPQot" +
       "vmxzOAU95uocOKkUd++ur8NbabldnIRg9FJ/A/r7UtRACaOX8gwnLX5KkC/u" +
       "XrpnwN4uHeSu/eAlOQ/cgQQfLxi33RANJaCTh9qFDVGguGiLyOm4VeR4qvTm" +
       "gqIlvivlCkzG/rIE715LB8cfu3Hf83YzLal0UcR3fYxU2319vkhtKsstx6vq" +
       "wLabTZdrtwSdTGm1D+xm73pPGkUh4QwM2i5fp2n15xvO95f3vv7T01XvQZ9w" +
       "lAQoJ2uOer7q2J8woF3NQHdwNOb2B57vkqIFHtz2rYUHdiT/8hvRDxH7vXRD" +
       "efq4dPWFR39+dt0ytMr1oxCJ4J/sNKlTrP0L2iST5sxp0qhYw1k4InBRqDpK" +
       "ajKacjLDRuUYacL8ovjFSdjFMWdjfhZfxTjpK/q0VOIFFnrHeWbu0zOagLhG" +
       "aCjcmYIPXrk6nzEM3wZ3Ju/K9mLd49L+rzX/6ExbaAQwokAdL/tqK5PI9xDe" +
       "b2BuU9Fio/C/4BeA6594odNxAu+ctEWd70G9+Q9C0KTaa6F4bMwwcrS17xh2" +
       "Fr2Iw3eyOM9JYMCZ9UH3JSH/ZfGIw+V/A3PiUgcPFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae8zjWHX3fLPz2GF3Z3Zhl2XKvgfobuBzHDsvDaU4D8dx" +
       "EjvOw07clsFvO/ErfsRO6PJYUaBF3SI60K0Eo0qFtqCFpVVRK1VUW1UtoEWV" +
       "qFBfUgFVlUpLkdg/SlFpS6+d7/vyfd88YITUSL65ufecc+8595yfz703z38H" +
       "OhX4UM5zrZVuueGumoS7M6u4G648NdilusW+6AeqUrfEIBiBtivy4587/70f" +
       "fMi4sAOdFqBXio7jhmJouk4wUAPXWqpKFzq/bW1aqh2E0IXuTFyKcBSaFtw1" +
       "g/ByF3rFIdYQutTdnwIMpgCDKcDZFGB8SwWY7ladyK6nHKITBgvondCJLnTa" +
       "k9PphdBjR4V4oi/ae2L6mQZAwtn0NweUypgTH3r0QPeNztcp/JEcfPU33nbh" +
       "D05C5wXovOkM0+nIYBIhGESA7rJVW1L9AFcUVRGgex1VVYaqb4qWuc7mLUD3" +
       "BabuiGHkqwdGShsjT/WzMbeWu0tOdfMjOXT9A/U0U7WU/V+nNEvUga4PbHXd" +
       "aEik7UDBcyaYmK+JsrrPcsfcdJQQeuQ4x4GOlzqAALCesdXQcA+GusMRQQN0" +
       "32btLNHR4WHom44OSE+5ERglhC7eVGhqa0+U56KuXgmhB4/T9TddgOrOzBAp" +
       "Swjdf5wskwRW6eKxVTq0Pt+h3/zsOxzS2cnmrKiylc7/LGB6+BjTQNVUX3Vk" +
       "dcN411Pdj4oPfOEDOxAEiO8/Rryh+aNffPmtb3z4xS9taH7qBjSMNFPl8Ir8" +
       "Cemer762/mT1ZDqNs54bmOniH9E8c//+Xs/lxAOR98CBxLRzd7/zxcFfTt/9" +
       "afXbO9C5NnRadq3IBn50r+zanmmpfkt1VF8MVaUN3ak6Sj3rb0NnQL1rOuqm" +
       "ldG0QA3b0B1W1nTazX4DE2lARGqiM6BuOpq7X/fE0MjqiQdB0BnwQHeBZxfa" +
       "fLLvEFJhw7VVWJRFx3RcuO+7qf4BrDqhBGxrwBLw+jkcuJEPXBB2fR0WgR8Y" +
       "6l5HGpliHMKmDZYfBsuhgDVRQJyvCt3IHqjKbupu3v/XQEmq8YX4xAmwGK89" +
       "DgUWiCLStQDjFflqVGu+/NkrL+0chMaerUKoAMbe3Yy9m42dwSgYezcbe3d/" +
       "7N3t2NCJE9mQr0rnsFl7sHJzgAEAHe96cvgL1Ns/8PhJ4HRefAcwe0oK3xyk" +
       "61vUaGfYKAPXhV58Ln4P9678DrRzFG3TeYOmcyl7P8XIAyy8dDzKbiT3/Pu/" +
       "9b0XPvq0u423I/C9BwPXc6Zh/PhxC/uurCoAGLfin3pU/PyVLzx9aQe6A2AD" +
       "wMNQBP4LoObh42McCefL+9CY6nIKKKy5vi1aadc+np0LDd+Nty3Z0t+T1e8F" +
       "Nn5F6t/3g6e45/DZd9r7Si8tX7VxlXTRjmmRQe/PDL2P/91f/SuamXsfpc8f" +
       "eu8N1fDyIWRIhZ3PMODerQ+MfFUFdP/4XP/XP/Kd9/9c5gCA4okbDXgpLesA" +
       "EcASAjP/0pcWf/+Nr3/iaztbpwnBqzGSLFNODpRM26Fzt1ASjPb67XwAslgg" +
       "6FKvuTR2bFcxNVOULDX10v8+/zrk8//+7IWNH1igZd+N3vijBWzbX1OD3v3S" +
       "2/7z4UzMCTl9s21ttiXbwOUrt5Jx3xdX6TyS9/z1Q7/5RfHjAHgB2AXmWs3w" +
       "68Re4KSTuj+E0B83RuuAJJ0hCNJsweFMwlNZmUFgJhfK+tC0eCQ4HDhHY/NQ" +
       "9nJF/tDXvns3990/fTnT9Gj6c9hPeqJ3eeOaafFoAsS/+jhKkGJgADrsRfrn" +
       "L1gv/gBIFIBEGeBgwPhAj+SIV+1RnzrzD3/25w+8/asnoR0COme5okKIWYBC" +
       "d4LIUAMDIF3i/exbN44RnwXFhUxV6DrlNw71YPbrJJjgkzfHJiLNXrbh/eB/" +
       "MZb0zD99/zojZKh0g5f2MX4Bfv5jF+tv+XbGv4WHlPvh5HoIB5nelrfwafs/" +
       "dh4//Rc70BkBuiDvpZGcaEVp0AkgdQr2c0uQah7pP5oGbd75lw/g77XHoenQ" +
       "sMeBafvqAPWUOq2fO4xFPwSfE+D53/RJzZ02bF6+99X3MoBHD1IAz0tOgEg/" +
       "Vdgt7+ZTfjyT8lhWXkqLN2yWKa3+NICEIMtfAYdmOqKVDVwLgYtZ8qV96RzI" +
       "Z8GaXJpZ5f34uZC5U6r97iYJ3IBhWmKZiI1LlG/qPm/eUGVvvXu2wrouyCc/" +
       "+M8f+sqvPfENsKYUdGqZ2hss5aER6ShNsd/3/EceesXVb34wQzgQ2twv/z76" +
       "/VQqfSuN06KVFuS+qhdTVYdZ2tAVg7CXgZKqZNre0pX7vmkD7F7u5Y/w0/d9" +
       "Y/6xb31mkxse99tjxOoHrv7KD3efvbpzKCN/4rqk+DDPJivPJn33noV96LFb" +
       "jZJxEP/ywtN/8ntPv38zq/uO5pdNsH36zN/8z1d2n/vml2+QyNxhuT/BwoZ3" +
       "PUdiQRvf/3SRqcbH4yThtQjuoyGGhGaPbLWaTFOXItZozsZUO18st2olelGk" +
       "zZYrznyQtyqwuVQQS6lgOSZfkLxOQbcGrsG6Nd5cVldEh6PrHVcMBV5cEfyc" +
       "MgjPE4euxC0ILnLhEqssxp1JvgH7CBqt1bJSVh3W4gpFuqDYsL2eLNdLp7ws" +
       "S8W8ww1EKrKMlg6va1NawPgWPUIao6lDjT1BQFqMZObdMQurUdKoaGit6XB0" +
       "y+qMeeA2xlQaC/qCrzJzvtoMRjOe4lWmt5KMWWyzfC8nuxw6CG2HdRF7Jo5r" +
       "HIXxTGlNNfR6g5t5FLeSzAXVaKmzhk4zkU3Hc1fHhvyovVzH03ZcGErmCisy" +
       "QaVIkGAH27En3JynVoWkiQ6ZwYySx8NekqidBi/QAY0OkOlY4lTBsFTNbEZh" +
       "kMQyOS2b7VGVQCJ4ObNtbtjt9Zriwp6XiJwnzCvrITKa20neXDPrKAj8ATJ3" +
       "VgOj1Zmj835vOKkE1Jqts2ZPpztqOIx5RyoAmxkoZ4zcSlJyOvN+DXda8UJo" +
       "Uey8NFVoo2+ue3XDmEUls1LQJb6q8siy2zZ4DR1gRSVHTFeo0vBIW6TrS5Go" +
       "FUl9TsfNRpuu2ROv1mDCNmfZldnAQ+SGMK4k40XHDRivGAVFVphp7V7UqDqE" +
       "t+61evG4ZyGSPqjW6HVvJitob1GUx7g6qSzyq4WCC/nyZICEo7EcTyw2aJZq" +
       "etGi6mC/KHXsKTcaCnMMzZGTuZJbVxq1bh1hAgQbBrnuIsTdEYUXmPxgvAiQ" +
       "pmc28mFtrvsKa+BNhIkCdzXgAomjFlZvtWKaqj2zy/WJ3vH4Ft5BZbprUAkj" +
       "x81Q6ZvVIkzSVY2BR7PCnAzrOBVTlgVYMdjxpwjTl+iePVy3hmwNllqGS05V" +
       "xS8WorneHjdkbMgURKkMG4OgX44MQZUjm+dy9aLVMGsUjU0Ij6G7hXJb8sJR" +
       "bPbHfN+13C7TrdZkgbabwbozpdmawSx7sjxqyTyyEuCe4zhLvZBDGBZpF4ad" +
       "uTXpFey2iwjUKIk6q2BF2j2ht/LmlaG9EKi5RuRM0zMiderOiHLVwlfiqJkb" +
       "mt64x/GWCVd11xzGbK3PxRJjUtpEDvJEcThLnAaIdJpbzXERi4MJbK51u+v1" +
       "2byJ1CnRXdiDldAjNR5tuzhWl2phx+vgCypH86TfMmr1XokRekazLXsUYKUs" +
       "qohazeG0X27ncKY1iU22iC3RGtr16qpA9oS4Bxc13e+4FcEvsnhdDuRmvzb0" +
       "5nmWUIwpkpS4xEbhOj2Em77iGYY4MwtYNIjmtUJBmKqEhLfkdiMIhLayBilV" +
       "JNXa7TpFhiouSVVgdl4G+Ma0WhLH9MlZkovMSpPltR6HNYS5NFy6NYOYiI22" +
       "OwlldcGH8oQchRyyrDUtYtYdDExedU2fs1ZUXEMoynbkQTRs1gV5ERJ+SRGn" +
       "1HytABDCCclauFLDG4vadCUxcrUbYULdFwQTmWsdzmNGxZXsE7mh2tcYO2rj" +
       "c57Q9THPOlMjDJwmLa0rNLqsYcJQo8K+ps2STk7WEKTQ7nR0LBpTQlijkVK/" +
       "RxpKpSLztm6VMVHLoYlmkwXercUjk7TwGlKGG+1Os6XHRk50h3HedegRTRNc" +
       "0uG1GeNhq+rEQgfzgb9Ajcgo192kOAr0VoTOS31ztoiUmlv0y+qsxfRpry36" +
       "BMz1W3IZLhUGcNRUJYYQBHuUl+NEM/VaZcXyQoT73BSV8Jw0w0mllsjAYZ1C" +
       "bmHP2rZYmzo9T9fy2EAnm3Gb04uLXE7RulUUKUpLw8tjxaRBy5W5W3c6RW/S" +
       "VLkOanptHWT/ZVKvNYgJXndLEjxlUXOcny/oTnM16qxgugALVXWhOYVSguXr" +
       "hM3F07KkIziq5WYOOjeHSxIOp7MCzs67PTFac/GqBRAkolbkiOpFWMNejcrl" +
       "CSzn0dKEZjtxXevy/KAuA5Dv2oyB+ORqVNAIQjTZdtupEfGgEVZCho6txFkO" +
       "+HZ72eTDskwbpjpgnF5DrjY4RWacPuJWpjOyjOTYgiEWukQRKwx7LZcuiEwn" +
       "ptllgMCLWpmtI+N5DS1XfKyILMeWsMTlgYsN9YaCmM1RtafzA4prTDinWkpy" +
       "cH7iVNABTs08vMSJ2qpeG1ND2zV6RZPDnQbT8qq5PF7q5QbulHeHC685K7q6" +
       "lV8H0lAyqkwLiTFx2STFcg6tYrwlrqh6Q1iSqgk3GJScOm6Vq4jLFZFHln4N" +
       "xGbTQiOp2Kq2Rt1REZHmeqW6rCyjfuh2VIwzxDanwcEYRnVLg2lUoqbesKuo" +
       "tDNcSNOSRwq6QRDhcNBTyFXEzQqs0hdQOBdrBUkrCyzrMFFxIJA4nIQ1c0qu" +
       "KJmArYaq5ez+BGOVYVLIzVr2Om8r/X4l4BOrWsyJnTBPm7MSXw5Yoj8hDCFo" +
       "LadTwh2KjYFVbNCTlj2ejqpFJ8aVDjHL5XBR1il90WBNCzOVfq/EFXJ+VzSq" +
       "otIOWSUkjSbXN3Bj6NaEQqlJhnOCW02TqLUGcaPbuUFuZTo5LT9kNX1BDkdL" +
       "tQxX+nKcd1xXnJKV0Efboc/kwBZtNlD5gJtOjTU+FRW95bIsnV8pbAVbqd3I" +
       "C4KBb4vVIOzA9WWXLVbUapW1iwuCj5SYaWIUBhCGXeKuEE3bts8QEw2bMK1Z" +
       "sy/O4ZguS0EHqRPJhKT4JdrGqhWObOnCOJ7ObCZcU6ZijGddgCwTrj1qka2O" +
       "pxc4gjOTVUEh+tg8duGJ1msx/Hy9QGlZLQWdsutijWrbDBXeXkS8tMxX6hWi" +
       "zwgabQR4iWoLnDbRjZq8XuirkT4t1fNmaWT4RtUQeuV+oUUblVGvz7rh0k7W" +
       "DD6uFiNXZjrzsZLLRX6FlsAGXXHaA71KUDAO++VxOMDrIjOp6LHTnRQ78zoc" +
       "TXzPiWksItVhBKu4xbCwrLOs1k1MFPg7TYn1kVFdEA2upUcts7tibIxTB9hi" +
       "ObL1RdtamkurPl+3YL/dLCPFbq0iaxFKahV0uu6KVn4sD1BtmowLKFJdzo2w" +
       "EwRhUlou4q4ojQTFD+OhMmrZSCOX2GXU67fmYwNj417BLGpewUGKyZKpFjV0" +
       "uSyP8shkyQrV2MJZlypEjOqXFwWqErsESrOkEtOMVKgVy8v5ok2Q4brgT8ek" +
       "Yo7girEcNBKyvJwMgIcvMKXPEwO0mlPC/Crs+Yib1CmMggO6Y438fr5bMIej" +
       "YpB4+YUxjZE5BtBnsGh4HXHWAX7WbQyi8VSUuxV3OSOGyozo8cpMMwQtGc28" +
       "DrzIc0ybIByfVHkpyq8ZUe8aLbE+k+1puz/x5yVn3eyhsYBSEdyp2l0Fq3Zz" +
       "/noCl5qJJOJs7M5xpQuHi06x364mDRVoFY2rhOnCdRirqXipWMVchU7wKCeH" +
       "TV4p51vVHFut5zsjUSwRmNSLY9kfIuXEKBB+oR2j6orpValpry5UxyRKDUlY" +
       "0FrtOMfBONo3x7rcJ2IcT7coV25vl3hvtiE+uCIBm8O0g7qN3dGm67G0eN3B" +
       "AVz2OX38WP3wAdz2ZAVKd3wP3ezmI9vtfeKZq9cU5pPIzt6JlBBCd4au9yZL" +
       "XarWsUOap26+s+1lFz/bk5IvPvNvF0dvMd5+G2fHjxyb53GRn+o9/+XW6+UP" +
       "70AnD85NrruSOsp0+ehpyTlfDSPfGR05M3nowLIXU4s9Dh58z7L4jc9vb+gF" +
       "JzIv2Kz9sQO/YweJD2XHEtuDQ943w+y8UAxC1c8kRLc4MlylBdhqn5Vdb9UQ" +
       "QzH9vdw61OJHbbcPC8wa7AMLPJo2vgk81/YscO02LLADPMfz3VCVQ1XJwuFW" +
       "1kh/5jOC995C2felxTtD6G7NTOpgQ+L3XGXPLYElX3PMkscoMnO86ycwx2Np" +
       "Iwyel/bM8dLtmCOtPnMbdvjwLexwNS1+NYTuAXYYirZnqUcMcfGYIY6TZJZ4" +
       "9nYskYTQue1lU3py/uB119ybq1n5s9fOn331tfHfZvctB9end3ahs1pkWYcP" +
       "Kw/VT3u+CnTJKDdHl1729fEQesOPedAOQmC/mk3/YxsJvxVCD99aQgidyr4P" +
       "c/12CD14M64QOgnKw9S/E0KvuhE1oATlYcpPhdCF45Rg/Oz7MN3zwN5buhA6" +
       "vakcJnkBSAckafVz3m3fSuBSEPqiHKa3EieOviIOPOS+H+Uhh94qTxx5F2T/" +
       "lNjH7WjzX4kr8gvXKPodL5c+ubnRki1xvU6lnO1CZzaXawfY/9hNpe3LOk0+" +
       "+YN7Pnfn6/bfU/dsJrwNwENze+TG10dN2wuzC5/1H7/6D9/8u9e+np0D/x9+" +
       "fb3dwiIAAA==");
}
