package org.apache.batik.ext.awt.image.rendered;
public class AffineRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    java.awt.RenderingHints hints;
    java.awt.geom.AffineTransform src2me;
    java.awt.geom.AffineTransform me2src;
    public java.awt.geom.AffineTransform getTransform() { return (java.awt.geom.AffineTransform)
                                                                   src2me.
                                                                   clone(
                                                                     );
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public AffineRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                     java.awt.geom.AffineTransform src2me,
                     java.awt.RenderingHints hints) { super();
                                                      this.src2me =
                                                        src2me;
                                                      this.hints =
                                                        hints;
                                                      try { me2src =
                                                              src2me.
                                                                createInverse(
                                                                  );
                                                      }
                                                      catch (java.awt.geom.NoninvertibleTransformException nite) {
                                                          me2src =
                                                            null;
                                                      }
                                                      java.awt.Rectangle srcBounds =
                                                        src.
                                                        getBounds(
                                                          );
                                                      java.awt.Rectangle myBounds;
                                                      myBounds =
                                                        src2me.
                                                          createTransformedShape(
                                                            srcBounds).
                                                          getBounds(
                                                            );
                                                      java.awt.image.ColorModel cm =
                                                        fixColorModel(
                                                          src);
                                                      java.awt.image.SampleModel sm =
                                                        fixSampleModel(
                                                          src,
                                                          cm,
                                                          myBounds);
                                                      java.awt.geom.Point2D pt =
                                                        new java.awt.geom.Point2D.Float(
                                                        src.
                                                          getTileGridXOffset(
                                                            ),
                                                        src.
                                                          getTileGridYOffset(
                                                            ));
                                                      pt =
                                                        src2me.
                                                          transform(
                                                            pt,
                                                            null);
                                                      init(
                                                        src,
                                                        myBounds,
                                                        cm,
                                                        sm,
                                                        (int)
                                                          pt.
                                                          getX(
                                                            ),
                                                        (int)
                                                          pt.
                                                          getY(
                                                            ),
                                                        null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        zr.
          zeroRect(
            new java.awt.Rectangle(
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  )));
        genRect(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int x,
                                         int y) {
        if (me2src ==
              null)
            return null;
        int tx =
          tileGridXOff +
          x *
          tileWidth;
        int ty =
          tileGridYOff +
          y *
          tileHeight;
        java.awt.Point pt =
          new java.awt.Point(
          tx,
          ty);
        java.awt.image.WritableRaster wr =
          java.awt.image.Raster.
          createWritableRaster(
            sm,
            pt);
        genRect(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        if (me2src ==
              null)
            return;
        java.awt.Rectangle srcR =
          me2src.
          createTransformedShape(
            wr.
              getBounds(
                )).
          getBounds(
            );
        srcR.
          setBounds(
            srcR.
              x -
              1,
            srcR.
              y -
              1,
            srcR.
              width +
              2,
            srcR.
              height +
              2);
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        if (!srcR.
              intersects(
                src.
                  getBounds(
                    )))
            return;
        java.awt.image.Raster srcRas =
          src.
          getData(
            srcR.
              intersection(
                src.
                  getBounds(
                    )));
        if (srcRas ==
              null)
            return;
        java.awt.geom.AffineTransform aff =
          (java.awt.geom.AffineTransform)
            src2me.
            clone(
              );
        aff.
          concatenate(
            java.awt.geom.AffineTransform.
              getTranslateInstance(
                srcRas.
                  getMinX(
                    ),
                srcRas.
                  getMinY(
                    )));
        java.awt.geom.Point2D srcPt =
          new java.awt.geom.Point2D.Float(
          wr.
            getMinX(
              ),
          wr.
            getMinY(
              ));
        srcPt =
          me2src.
            transform(
              srcPt,
              null);
        java.awt.geom.Point2D destPt =
          new java.awt.geom.Point2D.Double(
          srcPt.
            getX(
              ) -
            srcRas.
            getMinX(
              ),
          srcPt.
            getY(
              ) -
            srcRas.
            getMinY(
              ));
        destPt =
          aff.
            transform(
              destPt,
              null);
        aff.
          preConcatenate(
            java.awt.geom.AffineTransform.
              getTranslateInstance(
                -destPt.
                  getX(
                    ),
                -destPt.
                  getY(
                    )));
        java.awt.image.AffineTransformOp op =
          new java.awt.image.AffineTransformOp(
          aff,
          hints);
        java.awt.image.BufferedImage srcBI;
        java.awt.image.BufferedImage myBI;
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.image.ColorModel myCM =
          getColorModel(
            );
        java.awt.image.WritableRaster srcWR =
          (java.awt.image.WritableRaster)
            srcRas;
        srcCM =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            coerceData(
              srcWR,
              srcCM,
              true);
        srcBI =
          new java.awt.image.BufferedImage(
            srcCM,
            srcWR.
              createWritableTranslatedChild(
                0,
                0),
            srcCM.
              isAlphaPremultiplied(
                ),
            null);
        myBI =
          new java.awt.image.BufferedImage(
            myCM,
            wr.
              createWritableTranslatedChild(
                0,
                0),
            myCM.
              isAlphaPremultiplied(
                ),
            null);
        op.
          filter(
            srcBI,
            myBI);
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                )) {
            if (!cm.
                  isAlphaPremultiplied(
                    ))
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceColorModel(
                      cm,
                      true);
            return cm;
        }
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        int b =
          src.
          getSampleModel(
            ).
          getNumBands(
            ) +
          1;
        if (b ==
              4) {
            int[] masks =
              new int[4];
            for (int i =
                   0;
                 i <
                   b -
                   1;
                 i++)
                masks[i] =
                  16711680 >>
                    8 *
                    i;
            masks[3] =
              255 <<
                8 *
                (b -
                   1);
            return new java.awt.image.DirectColorModel(
              cs,
              8 *
                b,
              masks[0],
              masks[1],
              masks[2],
              masks[3],
              true,
              java.awt.image.DataBuffer.
                TYPE_INT);
        }
        int[] bits =
          new int[b];
        for (int i =
               0;
             i <
               b;
             i++)
            bits[i] =
              8;
        return new java.awt.image.ComponentColorModel(
          cs,
          bits,
          true,
          true,
          java.awt.Transparency.
            TRANSLUCENT,
          java.awt.image.DataBuffer.
            TYPE_INT);
    }
    protected java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                        java.awt.image.ColorModel cm,
                                                        java.awt.Rectangle bounds) {
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        int w =
          sm.
          getWidth(
            );
        if (w <
              defSz)
            w =
              defSz;
        if (w >
              bounds.
                width)
            w =
              bounds.
                width;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              bounds.
                height)
            h =
              bounds.
                height;
        if (w <=
              0 ||
              h <=
              0) {
            w =
              1;
            h =
              1;
        }
        return cm.
          createCompatibleSampleModel(
            w,
            h);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "x+pmU+DLsdGyzzER5k3iFd+m/Be0IZjTqyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
