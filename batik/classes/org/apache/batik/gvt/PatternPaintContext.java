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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "H/8PqhoWT4IeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Onxqg+nU/vOFox2YR473ik4flBb750/c6Xi/PCr4xHtffEnnPlm7eLir346h" +
       "+2LP/0eOkR4e7uw7uhdwesedN7qH5e2Gk93mP37vf3988pz1nldxfPqmczjP" +
       "s/z08LN/0n+r9qGL0D3He8+33Ls42+jZszvO10IjTkJ3cmbf+Yljvf9Aoea3" +
       "gKdzqPfO+Y29k5G9/Sbp2/aWcZdDk8/dpe4LRfKpGLq2NOJpFCLdw63KE1P6" +
       "9CttLJ1mWRZ88uwB7RvA86FD6T70/Zfut+9S9ztF8hsxdEW3I9+LjNtupqWe" +
       "rZ+I+8XvQdxHi8I3g+cjh+J+5Psv7pfvUvcvi+RLMfRaMJgnp6VFYfVEwD/4" +
       "HgR8CDo02V8+FPCXvz8C3ns43W8zPPcAx1Jk/81JUrL4yl308FdF8hfAqQA9" +
       "CGeOOx45f3RwUlsq51+9GuVkMfTwbS6KFKfer7/lEtr+4pT2+ZeuX33spem/" +
       "K+9KHF9uum8AXTUTxzl9UnUqf9kPDdMuRbtvf27ll39/G0Ovu931FaA1kJZ4" +
       "/9Oe8r/E0I3zlDF0qfw/Tfc14AlO6GLo8j5zmuTrgDsgKbJ/599mL35/VJdd" +
       "OOXHD+2o1PBDr6Th4yanL1EUvr+8/nfkp5P9BcDntS+8xIx+7FuNT+4vcWiO" +
       "stsVXK4OoCv7+yTHvv7pO3I74nWZevt3HvjV+95yFJce2AM+selT2N50+xsT" +
       "vY0fl3ccdr/12G/80K+89Nfl0cD/AzGcAhyXKQAA");
}
