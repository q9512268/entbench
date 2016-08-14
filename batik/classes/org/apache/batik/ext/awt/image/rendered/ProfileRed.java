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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "S1/6kkelLEFIzVYYjjnBaXf7G27FVXEc6dK1QBPIMkWjacRM6VpVxmBbV1oL" +
       "0e9b5QaVjIf2oqyQZYKly0mxRujLfqnnewsjKI0WE7qbclgPToXpSkkXxaLs" +
       "2xVOjpYVn+BZTFU3YblV8Se+1akMA98r9VJS3bCuUqBw1ce5gBt2F/Bk5ltl" +
       "Kq73qF516M91T9CmpXXkr2OubuLMhAdLMKuryU2FiBc1vbKq2S17CaLJbFQb" +
       "C75EdNgyHBamo3mvhDQ2QwSZ6EnDUzYmqxtCzbDKKB1NBb4id3nGHcMB7I+5" +
       "wqSM1upRBVaDjRxVNxs+ZNt1VRCLw2kFwEXU1bnquB2FPWa+3KCxKMGz1XhY" +
       "nk4KIe5paX/Ur278cFPjtNAeJxRcwwl2Oi8LrcbEjOGeoBVIotwoLiN4ZOoL" +
       "fIFXwxpJVZphhJHYkvSbgaHJmltsz81ZX+1WV4pldfyplUbtuNVajuFeoo9H" +
       "5ZBrw6rnL2l7jsbdtjJfpKm2JAJ6KDXtUkV0GnCjU1/HTSsalibSmqyuZk23" +
       "5VYq4oCZEMRkXOOaXK8hau6mI6kWPkXX9TEXkvB0iiBwHUXTEYLDUlMMGLRR" +
       "kf1x06Xm66JvVgWXVkdDThyNVHVM1ZkqRSVkcTDqJeF4GvO+MVKL/fIM42ey" +
       "PhETbjBXE6kymxAdRtArGGn30agiTs0KaVSb00KI1cA6ccOlI2nYE5ZOOMEt" +
       "o1EkYBIvaa6wxtvF1aZKTFFBc1ltjsQoyqLYplhAWZKfxYVNwvEY3RvqjYmH" +
       "eIZXqDU5eYi1N4t0nnaXCEkkPbMRgpWm252ZI3c8bVXrtBPOfLcOr2R6Lnmb" +
       "akcMquVI9AJ2vJatNliVzAmW5wp1HDUqbj8Cr1bRTN1ZmffisZ/EIJ57llDv" +
       "hCRf3tBsL5pHG5ekGJA14bjEWZW2WGyowZAapeYMZhcr1y6smJbFhwJcoQap" +
       "R0/1Dgz3wvGmW7e7fm0WqH2qUtzM+FG1jjaIyrTk69UBUVWsScGbUa1ao+hv" +
       "pvUyPV8rRptdzJHEMWvycF2hB5Y9ZXsYWVLSXhT3msYq4eZmX57C8xYtC+LS" +
       "HfAKVXFGzqq/aSxDETcGFdNv9gCUiNW6OTeX2mpJkct+UZisStQIa/Npsxxv" +
       "JA012JmNRm1SRtnIFOm+OG30S2lNhIeFCcXMRYwd1qv2kuCqVpXDCVdhGm6Z" +
       "TWd8uxOpMLZpDmGkLg2HcdSp63IX5peNBWWg9dmgFyS9tccORGBESfd4e+px" +
       "o0JnloRVm5RWDWytNNhWCVlu3GELGckdoqqpSJNzm2ifjsgxhmXbube8uB31" +
       "HfnhwcHNJNhIZx3qi9hJbrsezopXHpyy5J8z0InbrKPn3ocHk1C2O77/eheO" +
       "+c74I29/8mmZ/mhxZ+9AdxNAtwSO+9OmslHMI6J2gKTHr38KMMjvWw8PGr/8" +
       "9n+5b/J6/c0v4srmwRN6nhT5u4Nnvkq+SvqtHeimg2PHq26CjzNdPn7YeN5T" +
       "gtCzJ8eOHO8/8Ow9mcceAs9oz7Ojk+dXh3N37cOr12zn/gbn5b95g773ZcWv" +
       "Af9rSrA9ickaCoex8uvPd+pwVGLe8K4D4+7LGh8Bj7tnnPt/Y9ypvVu9vROx" +
       "+0+cK848I8jvIAQ/ULxcwodv4ILfyYqnAuic5LhJSwiE7PfThx744IvxQBxA" +
       "5w/vKbNLl3uv+ofE9lZf+tTTF87d8/T0r/OruoOb91so6JwamubR8+oj9TOu" +
       "p6hGrvct29NrN//6eAC9+gXe0QBL96u5+h/bSvi9AHrgxhIC6HT+fZTrUwF0" +
       "7/W4AugmUB6l/mwAvexa1IASlEcpPxdAF09SgvHz76N0XwD+PqQLoDPbylGS" +
       "PwTSAUlW/aL7oi+0MNEPPEEKwGzGp47D3EGE3Pl8EXIEGR89hmf5n2z2sSfc" +
       "/s3mivTpp3vDtzyHfnR7GSqZQppmUs5R0NntvewBfj18XWn7ss50Hvvx7Z+5" +
       "5ZX7WHv7VuHDxDui24PXvnlsW26Q3xWmf3DP537mY09/Kz/3/R8z9lPU/SQA" +
       "AA==");
}
