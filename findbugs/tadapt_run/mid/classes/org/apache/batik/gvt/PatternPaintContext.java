package org.apache.batik.gvt;
public class PatternPaintContext implements java.awt.PaintContext {
    private java.awt.image.ColorModel rasterCM;
    private java.awt.image.WritableRaster raster;
    private java.awt.image.RenderedImage tiled;
    protected java.awt.geom.AffineTransform usr2dev;
    public java.awt.geom.AffineTransform getUsr2Dev() { return usr2dev; }
    private static java.awt.Rectangle EVERYTHING = new java.awt.Rectangle(
      java.lang.Integer.
        MIN_VALUE /
        4,
      java.lang.Integer.
        MIN_VALUE /
        4,
      java.lang.Integer.
        MAX_VALUE /
        2,
      java.lang.Integer.
        MAX_VALUE /
        2);
    public PatternPaintContext(java.awt.image.ColorModel destCM, java.awt.geom.AffineTransform usr2dev,
                               java.awt.RenderingHints hints,
                               org.apache.batik.ext.awt.image.renderable.Filter tile,
                               java.awt.geom.Rectangle2D patternRegion,
                               boolean overflow) { super(
                                                     );
                                                   if (usr2dev ==
                                                         null) {
                                                       throw new java.lang.IllegalArgumentException(
                                                         );
                                                   }
                                                   if (hints ==
                                                         null) {
                                                       hints =
                                                         new java.awt.RenderingHints(
                                                           null);
                                                   }
                                                   if (tile ==
                                                         null) {
                                                       throw new java.lang.IllegalArgumentException(
                                                         );
                                                   }
                                                   this.
                                                     usr2dev =
                                                     usr2dev;
                                                   org.apache.batik.ext.awt.image.renderable.TileRable tileRable =
                                                     new org.apache.batik.ext.awt.image.renderable.TileRable8Bit(
                                                     tile,
                                                     EVERYTHING,
                                                     patternRegion,
                                                     overflow);
                                                   java.awt.color.ColorSpace destCS =
                                                     destCM.
                                                     getColorSpace(
                                                       );
                                                   if (destCS ==
                                                         java.awt.color.ColorSpace.
                                                         getInstance(
                                                           java.awt.color.ColorSpace.
                                                             CS_sRGB))
                                                       tileRable.
                                                         setColorSpaceLinear(
                                                           false);
                                                   else
                                                       if (destCS ==
                                                             java.awt.color.ColorSpace.
                                                             getInstance(
                                                               java.awt.color.ColorSpace.
                                                                 CS_LINEAR_RGB))
                                                           tileRable.
                                                             setColorSpaceLinear(
                                                               true);
                                                   java.awt.image.renderable.RenderContext rc =
                                                     new java.awt.image.renderable.RenderContext(
                                                     usr2dev,
                                                     EVERYTHING,
                                                     hints);
                                                   tiled =
                                                     tileRable.
                                                       createRendering(
                                                         rc);
                                                   if (tiled !=
                                                         null) {
                                                       java.awt.geom.Rectangle2D devRgn =
                                                         usr2dev.
                                                         createTransformedShape(
                                                           patternRegion).
                                                         getBounds(
                                                           );
                                                       if (devRgn.
                                                             getWidth(
                                                               ) >
                                                             128 ||
                                                             devRgn.
                                                             getHeight(
                                                               ) >
                                                             128)
                                                           tiled =
                                                             new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
                                                               org.apache.batik.ext.awt.image.GraphicsUtil.
                                                                 wrap(
                                                                   tiled),
                                                               256,
                                                               64);
                                                   }
                                                   else {
                                                       rasterCM =
                                                         java.awt.image.ColorModel.
                                                           getRGBdefault(
                                                             );
                                                       java.awt.image.WritableRaster wr;
                                                       wr =
                                                         rasterCM.
                                                           createCompatibleWritableRaster(
                                                             32,
                                                             32);
                                                       tiled =
                                                         org.apache.batik.ext.awt.image.GraphicsUtil.
                                                           wrap(
                                                             new java.awt.image.BufferedImage(
                                                               rasterCM,
                                                               wr,
                                                               false,
                                                               null));
                                                       return;
                                                   }
                                                   rasterCM =
                                                     tiled.
                                                       getColorModel(
                                                         );
                                                   if (rasterCM.
                                                         hasAlpha(
                                                           )) {
                                                       if (destCM.
                                                             hasAlpha(
                                                               ))
                                                           rasterCM =
                                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                                               coerceColorModel(
                                                                 rasterCM,
                                                                 destCM.
                                                                   isAlphaPremultiplied(
                                                                     ));
                                                       else
                                                           rasterCM =
                                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                                               coerceColorModel(
                                                                 rasterCM,
                                                                 false);
                                                   }
    }
    public void dispose() { raster = null;
    }
    public java.awt.image.ColorModel getColorModel() {
        return rasterCM;
    }
    public java.awt.image.Raster getRaster(int x,
                                           int y,
                                           int width,
                                           int height) {
        if (raster ==
              null ||
              raster.
              getWidth(
                ) <
              width ||
              raster.
              getHeight(
                ) <
              height) {
            raster =
              rasterCM.
                createCompatibleWritableRaster(
                  width,
                  height);
        }
        java.awt.image.WritableRaster wr =
          raster.
          createWritableChild(
            0,
            0,
            width,
            height,
            x,
            y,
            null);
        tiled.
          copyData(
            wr);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            wr,
            tiled.
              getColorModel(
                ),
            rasterCM.
              isAlphaPremultiplied(
                ));
        if (raster.
              getWidth(
                ) ==
              width &&
              raster.
              getHeight(
                ) ==
              height)
            return raster;
        return wr.
          createTranslatedChild(
            0,
            0);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RvwPrey1IL0dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gu6LXO89lrY7fEGz7+he0NK773xYPSm/Xjg5Mf79D/63x7nnjA+8hlegbz2H" +
       "83yTvzT54h8M36F84iJ0z/H58S3fVZyt9OzZU+NrgRbFgcOdOTt+4tjuby7M" +
       "/HZwdQ/t3j1/OHcysrc/6Hzn3jPu8uLjS3cp+3KRfCGCrq21iA+Dev/wuPHE" +
       "lX7p1Q6HTjdZZnz+7EvWN4HrE4fafeL7r91v3aXst4vk1yPoimqGnhtqtz0Q" +
       "27mmeqLuV74HdR8tMt8GrpcO1X3p+6/uV+9S9q+L5Pci6PVgME/eeBaZ1RMF" +
       "/8X3oOBD0KHLfvpQwU9/fxS893C632Z47gHEUtz+6UlSNvG1u9jhz4vk3wJS" +
       "AXZgz7yyeOT88f9JaWmcf/dajJNG0MO3+dijeHP9xls+Mtt/GKX8ysvXrz72" +
       "Mv/vy+8djj9euo+CruqxZZ1+23Tq/rIXaLpZqnbf/t2TV/79dQS94XafoACr" +
       "gbTE+1d7yf8cQTfOS0bQpfL/tNw3ABOcyEXQ5f3NaZFvgtaBSHH7t95tztP3" +
       "r9vSC6d4/NCPSgs/9GoWPq5y+kOIgvvLz/uOeDref+D3vPLll8npj327+fn9" +
       "hxiKJeV50cpVCrqy/ybkmOufvmNrR21dHr3rOw/86n1vP4pLD+wBn/j0KWxv" +
       "vf1XD7jtReV3CvlvPvbr7/3Fl/+iPN7/f4Vf6qF3KQAA");
}
