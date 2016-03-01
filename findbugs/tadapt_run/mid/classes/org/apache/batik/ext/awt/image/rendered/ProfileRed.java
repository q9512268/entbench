package org.apache.batik.ext.awt.image.rendered;
public class ProfileRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private static final java.awt.color.ColorSpace sRGBCS = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_sRGB);
    private static final java.awt.image.ColorModel sRGBCM = new java.awt.image.DirectColorModel(
      sRGBCS,
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private org.apache.batik.ext.awt.color.ICCColorSpaceExt
      colorSpace;
    public ProfileRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                      org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace) {
        super(
          );
        this.
          colorSpace =
          colorSpace;
        init(
          src,
          src.
            getBounds(
              ),
          sRGBCM,
          sRGBCM.
            createCompatibleSampleModel(
              src.
                getWidth(
                  ),
              src.
                getHeight(
                  )),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster argbWR) {
        try {
            java.awt.image.RenderedImage img =
              getSource(
                );
            java.awt.image.ColorModel imgCM =
              img.
              getColorModel(
                );
            java.awt.color.ColorSpace imgCS =
              imgCM.
              getColorSpace(
                );
            int nImageComponents =
              imgCS.
              getNumComponents(
                );
            int nProfileComponents =
              colorSpace.
              getNumComponents(
                );
            if (nImageComponents !=
                  nProfileComponents) {
                java.lang.System.
                  err.
                  println(
                    "Input image and associated color profile have" +
                    (" mismatching number of color components: conversion is not p" +
                     "ossible"));
                return argbWR;
            }
            int w =
              argbWR.
              getWidth(
                );
            int h =
              argbWR.
              getHeight(
                );
            int minX =
              argbWR.
              getMinX(
                );
            int minY =
              argbWR.
              getMinY(
                );
            java.awt.image.WritableRaster srcWR =
              imgCM.
              createCompatibleWritableRaster(
                w,
                h);
            srcWR =
              srcWR.
                createWritableTranslatedChild(
                  minX,
                  minY);
            img.
              copyData(
                srcWR);
            if (!(imgCM instanceof java.awt.image.ComponentColorModel) ||
                  !(img.
                      getSampleModel(
                        ) instanceof java.awt.image.BandedSampleModel) ||
                  imgCM.
                  hasAlpha(
                    ) &&
                  imgCM.
                  isAlphaPremultiplied(
                    )) {
                java.awt.image.ComponentColorModel imgCompCM =
                  new java.awt.image.ComponentColorModel(
                  imgCS,
                  imgCM.
                    getComponentSize(
                      ),
                  imgCM.
                    hasAlpha(
                      ),
                  false,
                  imgCM.
                    getTransparency(
                      ),
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
                java.awt.image.WritableRaster wr =
                  java.awt.image.Raster.
                  createBandedRaster(
                    java.awt.image.DataBuffer.
                      TYPE_BYTE,
                    argbWR.
                      getWidth(
                        ),
                    argbWR.
                      getHeight(
                        ),
                    imgCompCM.
                      getNumComponents(
                        ),
                    new java.awt.Point(
                      0,
                      0));
                java.awt.image.BufferedImage imgComp =
                  new java.awt.image.BufferedImage(
                  imgCompCM,
                  wr,
                  imgCompCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                java.awt.image.BufferedImage srcImg =
                  new java.awt.image.BufferedImage(
                  imgCM,
                  srcWR.
                    createWritableTranslatedChild(
                      0,
                      0),
                  imgCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                java.awt.Graphics2D g =
                  imgComp.
                  createGraphics(
                    );
                g.
                  setRenderingHint(
                    java.awt.RenderingHints.
                      KEY_COLOR_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_COLOR_RENDER_QUALITY);
                g.
                  drawImage(
                    srcImg,
                    0,
                    0,
                    null);
                img =
                  imgComp;
                imgCM =
                  imgCompCM;
                srcWR =
                  wr.
                    createWritableTranslatedChild(
                      minX,
                      minY);
            }
            java.awt.image.ComponentColorModel newCM =
              new java.awt.image.ComponentColorModel(
              colorSpace,
              imgCM.
                getComponentSize(
                  ),
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
            java.awt.image.DataBufferByte data =
              (java.awt.image.DataBufferByte)
                srcWR.
                getDataBuffer(
                  );
            srcWR =
              java.awt.image.Raster.
                createBandedRaster(
                  data,
                  argbWR.
                    getWidth(
                      ),
                  argbWR.
                    getHeight(
                      ),
                  argbWR.
                    getWidth(
                      ),
                  new int[] { 0,
                  1,
                  2 },
                  new int[] { 0,
                  0,
                  0 },
                  new java.awt.Point(
                    0,
                    0));
            java.awt.image.BufferedImage newImg =
              new java.awt.image.BufferedImage(
              newCM,
              srcWR,
              newCM.
                isAlphaPremultiplied(
                  ),
              null);
            java.awt.image.ComponentColorModel sRGBCompCM =
              new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_sRGB),
              new int[] { 8,
              8,
              8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
            java.awt.image.WritableRaster wr =
              java.awt.image.Raster.
              createBandedRaster(
                java.awt.image.DataBuffer.
                  TYPE_BYTE,
                argbWR.
                  getWidth(
                    ),
                argbWR.
                  getHeight(
                    ),
                sRGBCompCM.
                  getNumComponents(
                    ),
                new java.awt.Point(
                  0,
                  0));
            java.awt.image.BufferedImage sRGBImage =
              new java.awt.image.BufferedImage(
              sRGBCompCM,
              wr,
              false,
              null);
            java.awt.image.ColorConvertOp colorConvertOp =
              new java.awt.image.ColorConvertOp(
              null);
            colorConvertOp.
              filter(
                newImg,
                sRGBImage);
            if (imgCM.
                  hasAlpha(
                    )) {
                java.awt.image.DataBufferByte rgbData =
                  (java.awt.image.DataBufferByte)
                    wr.
                    getDataBuffer(
                      );
                byte[][] imgBanks =
                  data.
                  getBankData(
                    );
                byte[][] rgbBanks =
                  rgbData.
                  getBankData(
                    );
                byte[][] argbBanks =
                  { rgbBanks[0],
                rgbBanks[1],
                rgbBanks[2],
                imgBanks[3] };
                java.awt.image.DataBufferByte argbData =
                  new java.awt.image.DataBufferByte(
                  argbBanks,
                  imgBanks[0].
                    length);
                srcWR =
                  java.awt.image.Raster.
                    createBandedRaster(
                      argbData,
                      argbWR.
                        getWidth(
                          ),
                      argbWR.
                        getHeight(
                          ),
                      argbWR.
                        getWidth(
                          ),
                      new int[] { 0,
                      1,
                      2,
                      3 },
                      new int[] { 0,
                      0,
                      0,
                      0 },
                      new java.awt.Point(
                        0,
                        0));
                sRGBCompCM =
                  new java.awt.image.ComponentColorModel(
                    java.awt.color.ColorSpace.
                      getInstance(
                        java.awt.color.ColorSpace.
                          CS_sRGB),
                    new int[] { 8,
                    8,
                    8,
                    8 },
                    true,
                    false,
                    java.awt.Transparency.
                      TRANSLUCENT,
                    java.awt.image.DataBuffer.
                      TYPE_BYTE);
                sRGBImage =
                  new java.awt.image.BufferedImage(
                    sRGBCompCM,
                    srcWR,
                    false,
                    null);
            }
            java.awt.image.BufferedImage result =
              new java.awt.image.BufferedImage(
              sRGBCM,
              argbWR.
                createWritableTranslatedChild(
                  0,
                  0),
              false,
              null);
            java.awt.Graphics2D g =
              result.
              createGraphics(
                );
            g.
              setRenderingHint(
                java.awt.RenderingHints.
                  KEY_COLOR_RENDERING,
                java.awt.RenderingHints.
                  VALUE_COLOR_RENDER_QUALITY);
            g.
              drawImage(
                sRGBImage,
                0,
                0,
                null);
            g.
              dispose(
                );
            return argbWR;
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            throw new java.lang.Error(
              e.
                getMessage(
                  ));
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1wWa/UQIfgGbHxeRgpNQl67/D8AjXsMLGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Fu+vV8Hy9Vj/8aXVdh1x+QA2X3US0o4MexLQDl85oJ5RZ/XzJzDslZmXK+BB" +
       "99K7eBLDTkF5hchZHs7LS1nx2nxObkqgs0FkL8G6A4BHnK+CE6CH7cnOHoj8" +
       "BHxOgee/syeTnjVslw13Entrl4cOFi9BkMnpt3BisJ9Nr8wD7DB7DlNni69Z" +
       "Wc2K5nbExnUj683H7S6D5/Ke3aXr2C1cx+6s2soKOiuY3K3tfdW5q1Xfgkau" +
       "OudrunNC9f6LVz1bfkGvA8+b9lR/03VUl66t+qlc9X2Fz6vHvIme0OutL6hX" +
       "Lic9Bd4dp9Hd2i6S/ZZv4LTXXe20e2aOemk/FMZg2wTS9NLMqe178WLuxSwh" +
       "drd7jRNKtl+0kgBBbj8Uxvpg2/Lef3j/N3790e+ANG9Dp5dZCoLsPjJid5Ht" +
       "5H7p2Q/e/7Knvvve/GUJfMh/iLz4lkzq7KWZel9m6iBfgbJynHD5+03Xcmtv" +
       "iG58ZLtgGbDc26bAT9z5nflHvvfp7RbkJJSdINbf89Sv/GT3fU/tHNn4PXrV" +
       "3usoz3bzlyt9256HI+jhG42Sc1D/+NknvvTJJ9691erO49sYEuzSP/2X//WN" +
       "3ae/+7VrrIlvdvz/xcQmtz1Jl2MG2/9w46khrkZpKhq9Ol/Byt2E9xEcqytC" +
       "OSBqLlOwGz7WYk2J2yytkGyE025sqKVg3YhZvVbjahJeEQYhFQgMMmrTayex" +
       "QzH0OyHTduhxp4OGo04YDmUGmcl4310JRVg1YaXfm9dJrSkuo2JpsVnUVENr" +
       "GXbkeNKC53ndhQ13abiNbolPe4ETt8J+M0BDsb90Cp7k9SleGhabuNQNKQFp" +
       "rHAf9QK5VK/qxsxVCiFvkc7cJleKL8pGn0RRUZQ6RWtlE+hwXKEGY5d1tXiQ" +
       "rgMsdTm3N1IdZ2jVzRjVN91q2Y/XSsqvN8wcJd1uu+VaHg6mMsalaI1i8/K4" +
       "7Y+KnIzzSosYMG3EnQU9rzaZTlEa4QmurCP6RG3MK7xbwcvVgctRrL1Ig9Zm" +
       "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" +
       "AAA=");
}
