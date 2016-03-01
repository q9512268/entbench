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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mKZT0pUJAG0zTcSPSDX+uO8/o2zfwbAfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eH68Mgd9YqjTrt7BK1W2RrQTEWPQgYiTo+pslxODCbnTZtOYWmu19byRj7AM" +
       "ZtxZLx5u1hSXDAl0aJjDKJzpg97IjgVrimznnjXCTK7WIJSKYgsqFVS2ZLwU" +
       "ExCdLuY7GyOSzhxj8VUDRTIeXsRTacSpveqgOdVFVcOE3cCxlhslbA376Irt" +
       "d3k7atc32wkRrOBhNaorzUFXj0XTXA8sHxn3lmC5MqKWuTzdUR4myAi5M7L1" +
       "KINVdyGt5lsfHsG9LNO3FWywcAfENK9wzKSK2HV+kJn8lFCNtEVO4qas4xta" +
       "NIe5bLa5BlVrBcPWjgumI2/brra6jZWF9Le6OF7RPVFeIl5150ddSSDgNatN" +
       "ED1i0KlJTcXEEvoTq93YtTc+bPn9BobAEt4w5NFyVV1xjD3E+XGNc1f1LYhn" +
       "17qfJcI86BEymSHeeu4mNIIMFzm7xFiAWs26rs/hJoaOKuuggu+WtFyJzKaS" +
       "YIbcn88CDjNW2C5FKGFJNRp6A9Mk3vE3ZHM2sSYUCGrJJEw5zCZwGOc1HTGa" +
       "Wl7XW7DOmolnLqjU7tGROCGUbMtW+ltlofLTeiLSW2nFczDDN315lelYhkzq" +
       "fp1s6IbRU/pRxnLaOMrzWnOFrb1+YJKiLOEmMUx6hqJP+Z1qJ75P9GJXsFg4" +
       "xLggyzRtl/f7nBSP/J6SN7pLPUZrw2admVbrnou0kJEi+d2uEMtRbnhtzOZQ" +
       "vD8UsOUmZqvb1ZbyFkoV76UVf6BMKtGUafcru4kuCmJ3Bq/5JhJiO2ujtS2w" +
       "Gv++Ypmev7adkofLTaGTE+OlV25O669hh+CowSJ598neWfm7Cl04ZTx77HC6" +
       "EwwVux5P3O0guNzx+PSHXnzJ4H8RPTjaVEtS6IE0jN7nmZnpnWF1DXB65u67" +
       "O1x5Dn66s/vFD/3Pxyfvt59/DSdm77gg50WW/4T77G/1v1P/6QPo8sk+720n" +
       "9OcrPXt+d/d6bKbrOJic2+N94sSyxYYk9B7wNI4s27i4K3nad7d5waXSC/Z9" +
       "f48Dio/e49vHiuTvp9CDCzM9ORIptzZP3eUnXm1D6SzTsuDHT/R7tCh8Cjzf" +
       "c6Tf93z79fv5e3z7VJF8HPgX0G+/g1gUVE6V+8TrUK7Ym4eeBo95pJz57VHu" +
       "0tGh8dFO7un51f6sS46dtDziUpPUjEsO/+geJvhMkfyDFLpfD6NtV03V4v2X" +
       "Ti3wD1+HBR4pCt9WKr3/rb49FjgoCQ7K9+AMZMUpdNkJypPKL5QVf/Ueiv+L" +
       "IvlcCl0rfNvxzGN7vuWCPfd2PDXI51+HQcpT6GfA88Ejg3zw2+oSZdeVBL9x" +
       "D8W/WCQvl4oH4+ICxh3MeF8WOsapzr/+OnQuhjf0PvB86UjnL70GnQ/A2Izi" +
       "MAVimkZR/Pyr6V8pCX7vHvr/QZH8uxR6o+XkROiFMRcaRxML6P63Xej+CxSl" +
       "Of7960WF7wLPK0fmeOW1usB/vKMJLp/O/OWx0R8eK/TImZNrHcxBC88sGfy3" +
       "e5joj4vkyyn0EDCRqPqRZ56z0eMXbHSRpDTSV16LkXLQzyfXZ4q7AI/ddqNv" +
       "fwtN/5WXbtz/6EvTPyhvkJzcFHuAhe631p539uD0TP5qFJtAlZJyf4walX9f" +
       "S6H3fItXBwBCHmdL6f/3nsOfpdCT9+aQQlfK/7O1vp5Cj92tFsAwkJ6l/j8p" +
       "9OY7UQNKkJ6l/KsUunmRErRf/p+l+2YKXT+lS6Gr+8wZkktg5F0GJEX2cnTc" +
       "8d/yPYu2lqSxqqegN/NL58O/Ewd55NUc5EzE+K5zcV55KfQ4Jlvvr4U+p3/u" +
       "JWb4Q680fnF/R0f31N2u4HI/C13bXxc6ieveeVdux7yuUu/9xkOff+DdxzHo" +
       "Q3uBT4fmGdnececLMT0/SssrLLt//uivfu8vvfTl8pzzrwGSkrRErSsAAA==");
}
