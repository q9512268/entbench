package org.apache.batik.ext.awt.image;
public class GraphicsUtil {
    public static java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    public static void drawImage(java.awt.Graphics2D g2d, java.awt.image.RenderedImage ri) {
        drawImage(
          g2d,
          wrap(
            ri));
    }
    public static void drawImage(java.awt.Graphics2D g2d,
                                 org.apache.batik.ext.awt.image.rendered.CachableRed cr) {
        java.awt.geom.AffineTransform at =
          null;
        while (true) {
            if (cr instanceof org.apache.batik.ext.awt.image.rendered.AffineRed) {
                org.apache.batik.ext.awt.image.rendered.AffineRed ar =
                  (org.apache.batik.ext.awt.image.rendered.AffineRed)
                    cr;
                if (at ==
                      null)
                    at =
                      ar.
                        getTransform(
                          );
                else
                    at.
                      concatenate(
                        ar.
                          getTransform(
                            ));
                cr =
                  ar.
                    getSource(
                      );
                continue;
            }
            else
                if (cr instanceof org.apache.batik.ext.awt.image.rendered.TranslateRed) {
                    org.apache.batik.ext.awt.image.rendered.TranslateRed tr =
                      (org.apache.batik.ext.awt.image.rendered.TranslateRed)
                        cr;
                    int dx =
                      tr.
                      getDeltaX(
                        );
                    int dy =
                      tr.
                      getDeltaY(
                        );
                    if (at ==
                          null)
                        at =
                          java.awt.geom.AffineTransform.
                            getTranslateInstance(
                              dx,
                              dy);
                    else
                        at.
                          translate(
                            dx,
                            dy);
                    cr =
                      tr.
                        getSource(
                          );
                    continue;
                }
            break;
        }
        java.awt.geom.AffineTransform g2dAt =
          g2d.
          getTransform(
            );
        if (at ==
              null ||
              at.
              isIdentity(
                ))
            at =
              g2dAt;
        else
            at.
              preConcatenate(
                g2dAt);
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.image.ColorModel g2dCM =
          getDestinationColorModel(
            g2d);
        java.awt.color.ColorSpace g2dCS =
          null;
        if (g2dCM !=
              null)
            g2dCS =
              g2dCM.
                getColorSpace(
                  );
        if (g2dCS ==
              null)
            g2dCS =
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_sRGB);
        java.awt.image.ColorModel drawCM =
          g2dCM;
        if (g2dCM ==
              null ||
              !g2dCM.
              hasAlpha(
                )) {
            drawCM =
              sRGB_Unpre;
        }
        if (cr instanceof org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed) {
            if (g2dCS.
                  equals(
                    srcCM.
                      getColorSpace(
                        )) &&
                  drawCM.
                  equals(
                    srcCM)) {
                g2d.
                  setTransform(
                    at);
                org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed bicr;
                bicr =
                  (org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed)
                    cr;
                g2d.
                  drawImage(
                    bicr.
                      getBufferedImage(
                        ),
                    bicr.
                      getMinX(
                        ),
                    bicr.
                      getMinY(
                        ),
                    null);
                g2d.
                  setTransform(
                    g2dAt);
                return;
            }
        }
        double determinant =
          at.
          getDeterminant(
            );
        if (!at.
              isIdentity(
                ) &&
              determinant <=
              1.0) {
            if (at.
                  getType(
                    ) !=
                  java.awt.geom.AffineTransform.
                    TYPE_TRANSLATION)
                cr =
                  new org.apache.batik.ext.awt.image.rendered.AffineRed(
                    cr,
                    at,
                    g2d.
                      getRenderingHints(
                        ));
            else {
                int xloc =
                  cr.
                  getMinX(
                    ) +
                  (int)
                    at.
                    getTranslateX(
                      );
                int yloc =
                  cr.
                  getMinY(
                    ) +
                  (int)
                    at.
                    getTranslateY(
                      );
                cr =
                  new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                    cr,
                    xloc,
                    yloc);
            }
        }
        if (g2dCS !=
              srcCM.
              getColorSpace(
                )) {
            if (g2dCS ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB))
                cr =
                  convertTosRGB(
                    cr);
            else
                if (g2dCS ==
                      java.awt.color.ColorSpace.
                      getInstance(
                        java.awt.color.ColorSpace.
                          CS_LINEAR_RGB))
                    cr =
                      convertToLsRGB(
                        cr);
        }
        srcCM =
          cr.
            getColorModel(
              );
        if (!drawCM.
              equals(
                srcCM))
            cr =
              org.apache.batik.ext.awt.image.rendered.FormatRed.
                construct(
                  cr,
                  drawCM);
        if (!at.
              isIdentity(
                ) &&
              determinant >
              1.0)
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                at,
                g2d.
                  getRenderingHints(
                    ));
        g2d.
          setTransform(
            IDENTITY);
        java.awt.Composite g2dComposite =
          g2d.
          getComposite(
            );
        if (g2d.
              getRenderingHint(
                org.apache.batik.ext.awt.RenderingHintsKeyExt.
                  KEY_TRANSCODING) ==
              org.apache.batik.ext.awt.RenderingHintsKeyExt.
                VALUE_TRANSCODING_PRINTING) {
            if (org.apache.batik.ext.awt.image.SVGComposite.
                  OVER.
                  equals(
                    g2dComposite)) {
                g2d.
                  setComposite(
                    org.apache.batik.ext.awt.image.SVGComposite.
                      OVER);
            }
        }
        java.awt.Rectangle crR =
          cr.
          getBounds(
            );
        java.awt.Shape clip =
          g2d.
          getClip(
            );
        try {
            java.awt.Rectangle clipR;
            if (clip ==
                  null) {
                clip =
                  crR;
                clipR =
                  crR;
            }
            else {
                clipR =
                  clip.
                    getBounds(
                      );
                if (!clipR.
                      intersects(
                        crR))
                    return;
                clipR =
                  clipR.
                    intersection(
                      crR);
            }
            java.awt.Rectangle gcR =
              getDestinationBounds(
                g2d);
            if (gcR !=
                  null) {
                if (!clipR.
                      intersects(
                        gcR))
                    return;
                clipR =
                  clipR.
                    intersection(
                      gcR);
            }
            boolean useDrawRenderedImage =
              false;
            srcCM =
              cr.
                getColorModel(
                  );
            java.awt.image.SampleModel srcSM =
              cr.
              getSampleModel(
                );
            if (srcSM.
                  getWidth(
                    ) *
                  srcSM.
                  getHeight(
                    ) >=
                  clipR.
                    width *
                  clipR.
                    height)
                useDrawRenderedImage =
                  true;
            java.lang.Object atpHint =
              g2d.
              getRenderingHint(
                org.apache.batik.ext.awt.RenderingHintsKeyExt.
                  KEY_AVOID_TILE_PAINTING);
            if (atpHint ==
                  org.apache.batik.ext.awt.RenderingHintsKeyExt.
                    VALUE_AVOID_TILE_PAINTING_ON)
                useDrawRenderedImage =
                  true;
            if (atpHint ==
                  org.apache.batik.ext.awt.RenderingHintsKeyExt.
                    VALUE_AVOID_TILE_PAINTING_OFF)
                useDrawRenderedImage =
                  false;
            java.awt.image.WritableRaster wr;
            if (useDrawRenderedImage) {
                java.awt.image.Raster r =
                  cr.
                  getData(
                    clipR);
                wr =
                  ((java.awt.image.WritableRaster)
                     r).
                    createWritableChild(
                      clipR.
                        x,
                      clipR.
                        y,
                      clipR.
                        width,
                      clipR.
                        height,
                      0,
                      0,
                      null);
                java.awt.image.BufferedImage bi =
                  new java.awt.image.BufferedImage(
                  srcCM,
                  wr,
                  srcCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                g2d.
                  drawImage(
                    bi,
                    clipR.
                      x,
                    clipR.
                      y,
                    null);
            }
            else {
                wr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      srcSM,
                      new java.awt.Point(
                        0,
                        0));
                java.awt.image.BufferedImage bi =
                  new java.awt.image.BufferedImage(
                  srcCM,
                  wr,
                  srcCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                int xt0 =
                  cr.
                  getMinTileX(
                    );
                int xt1 =
                  xt0 +
                  cr.
                  getNumXTiles(
                    );
                int yt0 =
                  cr.
                  getMinTileY(
                    );
                int yt1 =
                  yt0 +
                  cr.
                  getNumYTiles(
                    );
                int tw =
                  srcSM.
                  getWidth(
                    );
                int th =
                  srcSM.
                  getHeight(
                    );
                java.awt.Rectangle tR =
                  new java.awt.Rectangle(
                  0,
                  0,
                  tw,
                  th);
                java.awt.Rectangle iR =
                  new java.awt.Rectangle(
                  0,
                  0,
                  0,
                  0);
                if (false) {
                    java.lang.System.
                      err.
                      println(
                        "SrcCM: " +
                        srcCM);
                    java.lang.System.
                      err.
                      println(
                        "CR: " +
                        cr);
                    java.lang.System.
                      err.
                      println(
                        "CRR: " +
                        crR +
                        " TG: [" +
                        xt0 +
                        ',' +
                        yt0 +
                        ',' +
                        xt1 +
                        ',' +
                        yt1 +
                        "] Off: " +
                        cr.
                          getTileGridXOffset(
                            ) +
                        ',' +
                        cr.
                          getTileGridYOffset(
                            ));
                }
                int yloc =
                  yt0 *
                  th +
                  cr.
                  getTileGridYOffset(
                    );
                int skip =
                  (clipR.
                     y -
                     yloc) /
                  th;
                if (skip <
                      0)
                    skip =
                      0;
                yt0 +=
                  skip;
                int xloc =
                  xt0 *
                  tw +
                  cr.
                  getTileGridXOffset(
                    );
                skip =
                  (clipR.
                     x -
                     xloc) /
                    tw;
                if (skip <
                      0)
                    skip =
                      0;
                xt0 +=
                  skip;
                int endX =
                  clipR.
                    x +
                  clipR.
                    width -
                  1;
                int endY =
                  clipR.
                    y +
                  clipR.
                    height -
                  1;
                if (false) {
                    java.lang.System.
                      out.
                      println(
                        "clipR: " +
                        clipR +
                        " TG: [" +
                        xt0 +
                        ',' +
                        yt0 +
                        ',' +
                        xt1 +
                        ',' +
                        yt1 +
                        "] Off: " +
                        cr.
                          getTileGridXOffset(
                            ) +
                        ',' +
                        cr.
                          getTileGridYOffset(
                            ));
                }
                yloc =
                  yt0 *
                    th +
                    cr.
                    getTileGridYOffset(
                      );
                int minX =
                  xt0 *
                  tw +
                  cr.
                  getTileGridXOffset(
                    );
                int xStep =
                  tw;
                xloc =
                  minX;
                for (int y =
                       yt0;
                     y <
                       yt1;
                     y++,
                       yloc +=
                         th) {
                    if (yloc >
                          endY)
                        break;
                    for (int x =
                           xt0;
                         x <
                           xt1;
                         x++,
                           xloc +=
                             xStep) {
                        if (xloc <
                              minX ||
                              xloc >
                              endX)
                            break;
                        tR.
                          x =
                          xloc;
                        tR.
                          y =
                          yloc;
                        java.awt.geom.Rectangle2D.
                          intersect(
                            crR,
                            tR,
                            iR);
                        java.awt.image.WritableRaster twr;
                        twr =
                          wr.
                            createWritableChild(
                              0,
                              0,
                              iR.
                                width,
                              iR.
                                height,
                              iR.
                                x,
                              iR.
                                y,
                              null);
                        cr.
                          copyData(
                            twr);
                        java.awt.image.BufferedImage subBI;
                        subBI =
                          bi.
                            getSubimage(
                              0,
                              0,
                              iR.
                                width,
                              iR.
                                height);
                        if (false) {
                            java.lang.System.
                              out.
                              println(
                                "Drawing: " +
                                tR);
                            java.lang.System.
                              out.
                              println(
                                "IR: " +
                                iR);
                        }
                        g2d.
                          drawImage(
                            subBI,
                            iR.
                              x,
                            iR.
                              y,
                            null);
                    }
                    xStep =
                      -xStep;
                    xloc +=
                      xStep;
                }
            }
        }
        finally {
            g2d.
              setTransform(
                g2dAt);
            g2d.
              setComposite(
                g2dComposite);
        }
    }
    public static void drawImage(java.awt.Graphics2D g2d,
                                 java.awt.image.renderable.RenderableImage filter,
                                 java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.AffineTransform origDev =
          g2d.
          getTransform(
            );
        java.awt.Shape origClip =
          g2d.
          getClip(
            );
        java.awt.RenderingHints origRH =
          g2d.
          getRenderingHints(
            );
        java.awt.Shape clip =
          rc.
          getAreaOfInterest(
            );
        if (clip !=
              null)
            g2d.
              clip(
                clip);
        g2d.
          transform(
            rc.
              getTransform(
                ));
        g2d.
          setRenderingHints(
            rc.
              getRenderingHints(
                ));
        drawImage(
          g2d,
          filter);
        g2d.
          setTransform(
            origDev);
        g2d.
          setClip(
            origClip);
        g2d.
          setRenderingHints(
            origRH);
    }
    public static void drawImage(java.awt.Graphics2D g2d,
                                 java.awt.image.renderable.RenderableImage filter) {
        if (filter instanceof org.apache.batik.ext.awt.image.renderable.PaintRable) {
            org.apache.batik.ext.awt.image.renderable.PaintRable pr =
              (org.apache.batik.ext.awt.image.renderable.PaintRable)
                filter;
            if (pr.
                  paintRable(
                    g2d))
                return;
        }
        java.awt.geom.AffineTransform at =
          g2d.
          getTransform(
            );
        java.awt.image.RenderedImage ri =
          filter.
          createRendering(
            new java.awt.image.renderable.RenderContext(
              at,
              g2d.
                getClip(
                  ),
              g2d.
                getRenderingHints(
                  )));
        if (ri ==
              null)
            return;
        g2d.
          setTransform(
            IDENTITY);
        drawImage(
          g2d,
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              ri));
        g2d.
          setTransform(
            at);
    }
    public static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage bi,
                                                     java.awt.RenderingHints hints) {
        java.awt.Graphics2D g2d =
          bi.
          createGraphics(
            );
        if (hints !=
              null)
            g2d.
              addRenderingHints(
                hints);
        g2d.
          setRenderingHint(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_BUFFERED_IMAGE,
            new java.lang.ref.WeakReference(
              bi));
        g2d.
          clip(
            new java.awt.Rectangle(
              0,
              0,
              bi.
                getWidth(
                  ),
              bi.
                getHeight(
                  )));
        return g2d;
    }
    public static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage bi) {
        java.awt.Graphics2D g2d =
          bi.
          createGraphics(
            );
        g2d.
          setRenderingHint(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_BUFFERED_IMAGE,
            new java.lang.ref.WeakReference(
              bi));
        g2d.
          clip(
            new java.awt.Rectangle(
              0,
              0,
              bi.
                getWidth(
                  ),
              bi.
                getHeight(
                  )));
        return g2d;
    }
    public static final boolean WARN_DESTINATION;
    static { boolean warn = true;
             try { java.lang.String s = java.lang.System.
                     getProperty(
                       "org.apache.batik.warn_destination",
                       "true");
                   warn = java.lang.Boolean.
                            valueOf(
                              s).
                            booleanValue(
                              ); }
             catch (java.lang.SecurityException se) {
                 
             }
             catch (java.lang.NumberFormatException nfe) {
                 
             }
             finally { WARN_DESTINATION =
                         warn; } }
    public static java.awt.image.BufferedImage getDestination(java.awt.Graphics2D g2d) {
        java.lang.Object o =
          g2d.
          getRenderingHint(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_BUFFERED_IMAGE);
        if (o !=
              null)
            return (java.awt.image.BufferedImage)
                     ((java.lang.ref.Reference)
                        o).
                     get(
                       );
        java.awt.GraphicsConfiguration gc =
          g2d.
          getDeviceConfiguration(
            );
        if (gc ==
              null) {
            return null;
        }
        java.awt.GraphicsDevice gd =
          gc.
          getDevice(
            );
        if (WARN_DESTINATION &&
              gd.
              getType(
                ) ==
              java.awt.GraphicsDevice.
                TYPE_IMAGE_BUFFER &&
              g2d.
              getRenderingHint(
                org.apache.batik.ext.awt.RenderingHintsKeyExt.
                  KEY_TRANSCODING) !=
              org.apache.batik.ext.awt.RenderingHintsKeyExt.
                VALUE_TRANSCODING_PRINTING)
            java.lang.System.
              err.
              println(
                "Graphics2D from BufferedImage lacks BUFFERED_IMAGE hint");
        return null;
    }
    public static java.awt.image.ColorModel getDestinationColorModel(java.awt.Graphics2D g2d) {
        java.awt.image.BufferedImage bi =
          getDestination(
            g2d);
        if (bi !=
              null) {
            return bi.
              getColorModel(
                );
        }
        java.awt.GraphicsConfiguration gc =
          g2d.
          getDeviceConfiguration(
            );
        if (gc ==
              null) {
            return null;
        }
        if (gc.
              getDevice(
                ).
              getType(
                ) ==
              java.awt.GraphicsDevice.
                TYPE_IMAGE_BUFFER) {
            if (g2d.
                  getRenderingHint(
                    org.apache.batik.ext.awt.RenderingHintsKeyExt.
                      KEY_TRANSCODING) ==
                  org.apache.batik.ext.awt.RenderingHintsKeyExt.
                    VALUE_TRANSCODING_PRINTING)
                return sRGB_Unpre;
            return null;
        }
        return gc.
          getColorModel(
            );
    }
    public static java.awt.color.ColorSpace getDestinationColorSpace(java.awt.Graphics2D g2d) {
        java.awt.image.ColorModel cm =
          getDestinationColorModel(
            g2d);
        if (cm !=
              null)
            return cm.
              getColorSpace(
                );
        return null;
    }
    public static java.awt.Rectangle getDestinationBounds(java.awt.Graphics2D g2d) {
        java.awt.image.BufferedImage bi =
          getDestination(
            g2d);
        if (bi !=
              null) {
            return new java.awt.Rectangle(
              0,
              0,
              bi.
                getWidth(
                  ),
              bi.
                getHeight(
                  ));
        }
        java.awt.GraphicsConfiguration gc =
          g2d.
          getDeviceConfiguration(
            );
        if (gc ==
              null) {
            return null;
        }
        if (gc.
              getDevice(
                ).
              getType(
                ) ==
              java.awt.GraphicsDevice.
                TYPE_IMAGE_BUFFER) {
            return null;
        }
        return null;
    }
    public static final java.awt.image.ColorModel
      Linear_sRGB =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      Linear_sRGB_Pre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      true,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      Linear_sRGB_Unpre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      sRGB =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      sRGB_Pre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      true,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      sRGB_Unpre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static java.awt.image.ColorModel makeLinear_sRGBCM(boolean premult) {
        return premult
          ? Linear_sRGB_Pre
          : Linear_sRGB_Unpre;
    }
    public static java.awt.image.BufferedImage makeLinearBufferedImage(int width,
                                                                       int height,
                                                                       boolean premult) {
        java.awt.image.ColorModel cm =
          makeLinear_sRGBCM(
            premult);
        java.awt.image.WritableRaster wr =
          cm.
          createCompatibleWritableRaster(
            width,
            height);
        return new java.awt.image.BufferedImage(
          cm,
          wr,
          premult,
          null);
    }
    public static org.apache.batik.ext.awt.image.rendered.CachableRed convertToLsRGB(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        if (cs ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_LINEAR_RGB))
            return src;
        return new org.apache.batik.ext.awt.image.rendered.Any2LsRGBRed(
          src);
    }
    public static org.apache.batik.ext.awt.image.rendered.CachableRed convertTosRGB(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        if (cs ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB))
            return src;
        return new org.apache.batik.ext.awt.image.rendered.Any2sRGBRed(
          src);
    }
    public static org.apache.batik.ext.awt.image.rendered.CachableRed wrap(java.awt.image.RenderedImage ri) {
        if (ri instanceof org.apache.batik.ext.awt.image.rendered.CachableRed)
            return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                     ri;
        if (ri instanceof java.awt.image.BufferedImage)
            return new org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed(
              (java.awt.image.BufferedImage)
                ri);
        return new org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed(
          ri);
    }
    public static void copyData_INT_PACK(java.awt.image.Raster src,
                                         java.awt.image.WritableRaster dst) {
        int x0 =
          dst.
          getMinX(
            );
        if (x0 <
              src.
              getMinX(
                ))
            x0 =
              src.
                getMinX(
                  );
        int y0 =
          dst.
          getMinY(
            );
        if (y0 <
              src.
              getMinY(
                ))
            y0 =
              src.
                getMinY(
                  );
        int x1 =
          dst.
          getMinX(
            ) +
          dst.
          getWidth(
            ) -
          1;
        if (x1 >
              src.
              getMinX(
                ) +
              src.
              getWidth(
                ) -
              1)
            x1 =
              src.
                getMinX(
                  ) +
                src.
                getWidth(
                  ) -
                1;
        int y1 =
          dst.
          getMinY(
            ) +
          dst.
          getHeight(
            ) -
          1;
        if (y1 >
              src.
              getMinY(
                ) +
              src.
              getHeight(
                ) -
              1)
            y1 =
              src.
                getMinY(
                  ) +
                src.
                getHeight(
                  ) -
                1;
        int width =
          x1 -
          x0 +
          1;
        int height =
          y1 -
          y0 +
          1;
        java.awt.image.SinglePixelPackedSampleModel srcSPPSM;
        srcSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            src.
            getSampleModel(
              );
        final int srcScanStride =
          srcSPPSM.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            src.
            getDataBuffer(
              );
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        final int srcBase =
          srcDB.
          getOffset(
            ) +
          srcSPPSM.
          getOffset(
            x0 -
              src.
              getSampleModelTranslateX(
                ),
            y0 -
              src.
              getSampleModelTranslateY(
                ));
        java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
        dstSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            dst.
            getSampleModel(
              );
        final int dstScanStride =
          dstSPPSM.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dst.
            getDataBuffer(
              );
        final int[] dstPixels =
          dstDB.
          getBankData(
            )[0];
        final int dstBase =
          dstDB.
          getOffset(
            ) +
          dstSPPSM.
          getOffset(
            x0 -
              dst.
              getSampleModelTranslateX(
                ),
            y0 -
              dst.
              getSampleModelTranslateY(
                ));
        if (srcScanStride ==
              dstScanStride &&
              srcScanStride ==
              width) {
            java.lang.System.
              arraycopy(
                srcPixels,
                srcBase,
                dstPixels,
                dstBase,
                width *
                  height);
        }
        else
            if (width >
                  128) {
                int srcSP =
                  srcBase;
                int dstSP =
                  dstBase;
                for (int y =
                       0;
                     y <
                       height;
                     y++) {
                    java.lang.System.
                      arraycopy(
                        srcPixels,
                        srcSP,
                        dstPixels,
                        dstSP,
                        width);
                    srcSP +=
                      srcScanStride;
                    dstSP +=
                      dstScanStride;
                }
            }
            else {
                for (int y =
                       0;
                     y <
                       height;
                     y++) {
                    int srcSP =
                      srcBase +
                      y *
                      srcScanStride;
                    int dstSP =
                      dstBase +
                      y *
                      dstScanStride;
                    for (int x =
                           0;
                         x <
                           width;
                         x++)
                        dstPixels[dstSP++] =
                          srcPixels[srcSP++];
                }
            }
    }
    public static void copyData_FALLBACK(java.awt.image.Raster src,
                                         java.awt.image.WritableRaster dst) {
        int x0 =
          dst.
          getMinX(
            );
        if (x0 <
              src.
              getMinX(
                ))
            x0 =
              src.
                getMinX(
                  );
        int y0 =
          dst.
          getMinY(
            );
        if (y0 <
              src.
              getMinY(
                ))
            y0 =
              src.
                getMinY(
                  );
        int x1 =
          dst.
          getMinX(
            ) +
          dst.
          getWidth(
            ) -
          1;
        if (x1 >
              src.
              getMinX(
                ) +
              src.
              getWidth(
                ) -
              1)
            x1 =
              src.
                getMinX(
                  ) +
                src.
                getWidth(
                  ) -
                1;
        int y1 =
          dst.
          getMinY(
            ) +
          dst.
          getHeight(
            ) -
          1;
        if (y1 >
              src.
              getMinY(
                ) +
              src.
              getHeight(
                ) -
              1)
            y1 =
              src.
                getMinY(
                  ) +
                src.
                getHeight(
                  ) -
                1;
        int width =
          x1 -
          x0 +
          1;
        int[] data =
          null;
        for (int y =
               y0;
             y <=
               y1;
             y++) {
            data =
              src.
                getPixels(
                  x0,
                  y,
                  width,
                  1,
                  data);
            dst.
              setPixels(
                x0,
                y,
                width,
                1,
                data);
        }
    }
    public static void copyData(java.awt.image.Raster src,
                                java.awt.image.WritableRaster dst) {
        if (is_INT_PACK_Data(
              src.
                getSampleModel(
                  ),
              false) &&
              is_INT_PACK_Data(
                dst.
                  getSampleModel(
                    ),
                false)) {
            copyData_INT_PACK(
              src,
              dst);
            return;
        }
        copyData_FALLBACK(
          src,
          dst);
    }
    public static java.awt.image.WritableRaster copyRaster(java.awt.image.Raster ras) {
        return copyRaster(
                 ras,
                 ras.
                   getMinX(
                     ),
                 ras.
                   getMinY(
                     ));
    }
    public static java.awt.image.WritableRaster copyRaster(java.awt.image.Raster ras,
                                                           int minX,
                                                           int minY) {
        java.awt.image.WritableRaster ret =
          java.awt.image.Raster.
          createWritableRaster(
            ras.
              getSampleModel(
                ),
            new java.awt.Point(
              0,
              0));
        ret =
          ret.
            createWritableChild(
              ras.
                getMinX(
                  ) -
                ras.
                getSampleModelTranslateX(
                  ),
              ras.
                getMinY(
                  ) -
                ras.
                getSampleModelTranslateY(
                  ),
              ras.
                getWidth(
                  ),
              ras.
                getHeight(
                  ),
              minX,
              minY,
              null);
        java.awt.image.DataBuffer srcDB =
          ras.
          getDataBuffer(
            );
        java.awt.image.DataBuffer retDB =
          ret.
          getDataBuffer(
            );
        if (srcDB.
              getDataType(
                ) !=
              retDB.
              getDataType(
                )) {
            throw new java.lang.IllegalArgumentException(
              "New DataBuffer doesn\'t match original");
        }
        int len =
          srcDB.
          getSize(
            );
        int banks =
          srcDB.
          getNumBanks(
            );
        int[] offsets =
          srcDB.
          getOffsets(
            );
        for (int b =
               0;
             b <
               banks;
             b++) {
            switch (srcDB.
                      getDataType(
                        )) {
                case java.awt.image.DataBuffer.
                       TYPE_BYTE:
                    {
                        java.awt.image.DataBufferByte srcDBT =
                          (java.awt.image.DataBufferByte)
                            srcDB;
                        java.awt.image.DataBufferByte retDBT =
                          (java.awt.image.DataBufferByte)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
                case java.awt.image.DataBuffer.
                       TYPE_INT:
                    {
                        java.awt.image.DataBufferInt srcDBT =
                          (java.awt.image.DataBufferInt)
                            srcDB;
                        java.awt.image.DataBufferInt retDBT =
                          (java.awt.image.DataBufferInt)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
                case java.awt.image.DataBuffer.
                       TYPE_SHORT:
                    {
                        java.awt.image.DataBufferShort srcDBT =
                          (java.awt.image.DataBufferShort)
                            srcDB;
                        java.awt.image.DataBufferShort retDBT =
                          (java.awt.image.DataBufferShort)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
                case java.awt.image.DataBuffer.
                       TYPE_USHORT:
                    {
                        java.awt.image.DataBufferUShort srcDBT =
                          (java.awt.image.DataBufferUShort)
                            srcDB;
                        java.awt.image.DataBufferUShort retDBT =
                          (java.awt.image.DataBufferUShort)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
            }
        }
        return ret;
    }
    public static java.awt.image.WritableRaster makeRasterWritable(java.awt.image.Raster ras) {
        return makeRasterWritable(
                 ras,
                 ras.
                   getMinX(
                     ),
                 ras.
                   getMinY(
                     ));
    }
    public static java.awt.image.WritableRaster makeRasterWritable(java.awt.image.Raster ras,
                                                                   int minX,
                                                                   int minY) {
        java.awt.image.WritableRaster ret =
          java.awt.image.Raster.
          createWritableRaster(
            ras.
              getSampleModel(
                ),
            ras.
              getDataBuffer(
                ),
            new java.awt.Point(
              0,
              0));
        ret =
          ret.
            createWritableChild(
              ras.
                getMinX(
                  ) -
                ras.
                getSampleModelTranslateX(
                  ),
              ras.
                getMinY(
                  ) -
                ras.
                getSampleModelTranslateY(
                  ),
              ras.
                getWidth(
                  ),
              ras.
                getHeight(
                  ),
              minX,
              minY,
              null);
        return ret;
    }
    public static java.awt.image.ColorModel coerceColorModel(java.awt.image.ColorModel cm,
                                                             boolean newAlphaPreMult) {
        if (cm.
              isAlphaPremultiplied(
                ) ==
              newAlphaPreMult)
            return cm;
        java.awt.image.WritableRaster wr =
          cm.
          createCompatibleWritableRaster(
            1,
            1);
        return cm.
          coerceData(
            wr,
            newAlphaPreMult);
    }
    public static java.awt.image.ColorModel coerceData(java.awt.image.WritableRaster wr,
                                                       java.awt.image.ColorModel cm,
                                                       boolean newAlphaPreMult) {
        if (!cm.
              hasAlpha(
                ))
            return cm;
        if (cm.
              isAlphaPremultiplied(
                ) ==
              newAlphaPreMult)
            return cm;
        if (newAlphaPreMult) {
            multiplyAlpha(
              wr);
        }
        else {
            divideAlpha(
              wr);
        }
        return coerceColorModel(
                 cm,
                 newAlphaPreMult);
    }
    public static void multiplyAlpha(java.awt.image.WritableRaster wr) {
        if (is_BYTE_COMP_Data(
              wr.
                getSampleModel(
                  )))
            mult_BYTE_COMP_Data(
              wr);
        else
            if (is_INT_PACK_Data(
                  wr.
                    getSampleModel(
                      ),
                  true))
                mult_INT_PACK_Data(
                  wr);
            else {
                int[] pixel =
                  null;
                int bands =
                  wr.
                  getNumBands(
                    );
                float norm =
                  1.0F /
                  255.0F;
                int x0;
                int x1;
                int y0;
                int y1;
                int a;
                int b;
                float alpha;
                x0 =
                  wr.
                    getMinX(
                      );
                x1 =
                  x0 +
                    wr.
                    getWidth(
                      );
                y0 =
                  wr.
                    getMinY(
                      );
                y1 =
                  y0 +
                    wr.
                    getHeight(
                      );
                for (int y =
                       y0;
                     y <
                       y1;
                     y++)
                    for (int x =
                           x0;
                         x <
                           x1;
                         x++) {
                        pixel =
                          wr.
                            getPixel(
                              x,
                              y,
                              pixel);
                        a =
                          pixel[bands -
                                  1];
                        if (a >=
                              0 &&
                              a <
                              255) {
                            alpha =
                              a *
                                norm;
                            for (b =
                                   0;
                                 b <
                                   bands -
                                   1;
                                 b++)
                                pixel[b] =
                                  (int)
                                    (pixel[b] *
                                       alpha +
                                       0.5F);
                            wr.
                              setPixel(
                                x,
                                y,
                                pixel);
                        }
                    }
            }
    }
    public static void divideAlpha(java.awt.image.WritableRaster wr) {
        if (is_BYTE_COMP_Data(
              wr.
                getSampleModel(
                  )))
            divide_BYTE_COMP_Data(
              wr);
        else
            if (is_INT_PACK_Data(
                  wr.
                    getSampleModel(
                      ),
                  true))
                divide_INT_PACK_Data(
                  wr);
            else {
                int x0;
                int x1;
                int y0;
                int y1;
                int a;
                int b;
                float ialpha;
                int bands =
                  wr.
                  getNumBands(
                    );
                int[] pixel =
                  null;
                x0 =
                  wr.
                    getMinX(
                      );
                x1 =
                  x0 +
                    wr.
                    getWidth(
                      );
                y0 =
                  wr.
                    getMinY(
                      );
                y1 =
                  y0 +
                    wr.
                    getHeight(
                      );
                for (int y =
                       y0;
                     y <
                       y1;
                     y++)
                    for (int x =
                           x0;
                         x <
                           x1;
                         x++) {
                        pixel =
                          wr.
                            getPixel(
                              x,
                              y,
                              pixel);
                        a =
                          pixel[bands -
                                  1];
                        if (a >
                              0 &&
                              a <
                              255) {
                            ialpha =
                              255 /
                                (float)
                                  a;
                            for (b =
                                   0;
                                 b <
                                   bands -
                                   1;
                                 b++)
                                pixel[b] =
                                  (int)
                                    (pixel[b] *
                                       ialpha +
                                       0.5F);
                            wr.
                              setPixel(
                                x,
                                y,
                                pixel);
                        }
                    }
            }
    }
    public static void copyData(java.awt.image.BufferedImage src,
                                java.awt.image.BufferedImage dst) {
        java.awt.Rectangle srcRect =
          new java.awt.Rectangle(
          0,
          0,
          src.
            getWidth(
              ),
          src.
            getHeight(
              ));
        copyData(
          src,
          srcRect,
          dst,
          new java.awt.Point(
            0,
            0));
    }
    public static void copyData(java.awt.image.BufferedImage src,
                                java.awt.Rectangle srcRect,
                                java.awt.image.BufferedImage dst,
                                java.awt.Point destP) {
        boolean srcAlpha =
          src.
          getColorModel(
            ).
          hasAlpha(
            );
        boolean dstAlpha =
          dst.
          getColorModel(
            ).
          hasAlpha(
            );
        if (srcAlpha ==
              dstAlpha)
            if (!srcAlpha ||
                  src.
                  isAlphaPremultiplied(
                    ) ==
                  dst.
                  isAlphaPremultiplied(
                    )) {
                copyData(
                  src.
                    getRaster(
                      ),
                  dst.
                    getRaster(
                      ));
                return;
            }
        int[] pixel =
          null;
        java.awt.image.Raster srcR =
          src.
          getRaster(
            );
        java.awt.image.WritableRaster dstR =
          dst.
          getRaster(
            );
        int bands =
          dstR.
          getNumBands(
            );
        int dx =
          destP.
            x -
          srcRect.
            x;
        int dy =
          destP.
            y -
          srcRect.
            y;
        int w =
          srcRect.
            width;
        int x0 =
          srcRect.
            x;
        int y0 =
          srcRect.
            y;
        int y1 =
          y0 +
          srcRect.
            height -
          1;
        if (!srcAlpha) {
            int[] oPix =
              new int[bands *
                        w];
            int out =
              w *
              bands -
              1;
            while (out >=
                     0) {
                oPix[out] =
                  255;
                out -=
                  bands;
            }
            int b;
            int in;
            for (int y =
                   y0;
                 y <=
                   y1;
                 y++) {
                pixel =
                  srcR.
                    getPixels(
                      x0,
                      y,
                      w,
                      1,
                      pixel);
                in =
                  w *
                    (bands -
                       1) -
                    1;
                out =
                  w *
                    bands -
                    2;
                switch (bands) {
                    case 4:
                        while (in >=
                                 0) {
                            oPix[out--] =
                              pixel[in--];
                            oPix[out--] =
                              pixel[in--];
                            oPix[out--] =
                              pixel[in--];
                            out--;
                        }
                        break;
                    default:
                        while (in >=
                                 0) {
                            for (b =
                                   0;
                                 b <
                                   bands -
                                   1;
                                 b++)
                                oPix[out--] =
                                  pixel[in--];
                            out--;
                        }
                }
                dstR.
                  setPixels(
                    x0 +
                      dx,
                    y +
                      dy,
                    w,
                    1,
                    oPix);
            }
        }
        else
            if (dstAlpha &&
                  dst.
                  isAlphaPremultiplied(
                    )) {
                int a;
                int b;
                int alpha;
                int in;
                int fpNorm =
                  (1 <<
                     24) /
                  255;
                int pt5 =
                  1 <<
                  23;
                for (int y =
                       y0;
                     y <=
                       y1;
                     y++) {
                    pixel =
                      srcR.
                        getPixels(
                          x0,
                          y,
                          w,
                          1,
                          pixel);
                    in =
                      bands *
                        w -
                        1;
                    switch (bands) {
                        case 4:
                            while (in >=
                                     0) {
                                a =
                                  pixel[in];
                                if (a ==
                                      255)
                                    in -=
                                      4;
                                else {
                                    in--;
                                    alpha =
                                      fpNorm *
                                        a;
                                    pixel[in] =
                                      pixel[in] *
                                        alpha +
                                        pt5 >>>
                                        24;
                                    in--;
                                    pixel[in] =
                                      pixel[in] *
                                        alpha +
                                        pt5 >>>
                                        24;
                                    in--;
                                    pixel[in] =
                                      pixel[in] *
                                        alpha +
                                        pt5 >>>
                                        24;
                                    in--;
                                }
                            }
                            break;
                        default:
                            while (in >=
                                     0) {
                                a =
                                  pixel[in];
                                if (a ==
                                      255)
                                    in -=
                                      bands;
                                else {
                                    in--;
                                    alpha =
                                      fpNorm *
                                        a;
                                    for (b =
                                           0;
                                         b <
                                           bands -
                                           1;
                                         b++) {
                                        pixel[in] =
                                          pixel[in] *
                                            alpha +
                                            pt5 >>>
                                            24;
                                        in--;
                                    }
                                }
                            }
                    }
                    dstR.
                      setPixels(
                        x0 +
                          dx,
                        y +
                          dy,
                        w,
                        1,
                        pixel);
                }
            }
            else
                if (dstAlpha &&
                      !dst.
                      isAlphaPremultiplied(
                        )) {
                    int a;
                    int b;
                    int ialpha;
                    int in;
                    int fpNorm =
                      16711680;
                    int pt5 =
                      1 <<
                      15;
                    for (int y =
                           y0;
                         y <=
                           y1;
                         y++) {
                        pixel =
                          srcR.
                            getPixels(
                              x0,
                              y,
                              w,
                              1,
                              pixel);
                        in =
                          bands *
                            w -
                            1;
                        switch (bands) {
                            case 4:
                                while (in >=
                                         0) {
                                    a =
                                      pixel[in];
                                    if (a <=
                                          0 ||
                                          a >=
                                          255)
                                        in -=
                                          4;
                                    else {
                                        in--;
                                        ialpha =
                                          fpNorm /
                                            a;
                                        pixel[in] =
                                          pixel[in] *
                                            ialpha +
                                            pt5 >>>
                                            16;
                                        in--;
                                        pixel[in] =
                                          pixel[in] *
                                            ialpha +
                                            pt5 >>>
                                            16;
                                        in--;
                                        pixel[in] =
                                          pixel[in] *
                                            ialpha +
                                            pt5 >>>
                                            16;
                                        in--;
                                    }
                                }
                                break;
                            default:
                                while (in >=
                                         0) {
                                    a =
                                      pixel[in];
                                    if (a <=
                                          0 ||
                                          a >=
                                          255)
                                        in -=
                                          bands;
                                    else {
                                        in--;
                                        ialpha =
                                          fpNorm /
                                            a;
                                        for (b =
                                               0;
                                             b <
                                               bands -
                                               1;
                                             b++) {
                                            pixel[in] =
                                              pixel[in] *
                                                ialpha +
                                                pt5 >>>
                                                16;
                                            in--;
                                        }
                                    }
                                }
                        }
                        dstR.
                          setPixels(
                            x0 +
                              dx,
                            y +
                              dy,
                            w,
                            1,
                            pixel);
                    }
                }
                else
                    if (src.
                          isAlphaPremultiplied(
                            )) {
                        int[] oPix =
                          new int[bands *
                                    w];
                        int a;
                        int b;
                        int ialpha;
                        int in;
                        int out;
                        int fpNorm =
                          16711680;
                        int pt5 =
                          1 <<
                          15;
                        for (int y =
                               y0;
                             y <=
                               y1;
                             y++) {
                            pixel =
                              srcR.
                                getPixels(
                                  x0,
                                  y,
                                  w,
                                  1,
                                  pixel);
                            in =
                              (bands +
                                 1) *
                                w -
                                1;
                            out =
                              bands *
                                w -
                                1;
                            while (in >=
                                     0) {
                                a =
                                  pixel[in];
                                in--;
                                if (a >
                                      0) {
                                    if (a <
                                          255) {
                                        ialpha =
                                          fpNorm /
                                            a;
                                        for (b =
                                               0;
                                             b <
                                               bands;
                                             b++)
                                            oPix[out--] =
                                              pixel[in--] *
                                                ialpha +
                                                pt5 >>>
                                                16;
                                    }
                                    else
                                        for (b =
                                               0;
                                             b <
                                               bands;
                                             b++)
                                            oPix[out--] =
                                              pixel[in--];
                                }
                                else {
                                    in -=
                                      bands;
                                    for (b =
                                           0;
                                         b <
                                           bands;
                                         b++)
                                        oPix[out--] =
                                          255;
                                }
                            }
                            dstR.
                              setPixels(
                                x0 +
                                  dx,
                                y +
                                  dy,
                                w,
                                1,
                                oPix);
                        }
                    }
                    else {
                        java.awt.Rectangle dstRect =
                          new java.awt.Rectangle(
                          destP.
                            x,
                          destP.
                            y,
                          srcRect.
                            width,
                          srcRect.
                            height);
                        for (int b =
                               0;
                             b <
                               bands;
                             b++)
                            copyBand(
                              srcR,
                              srcRect,
                              b,
                              dstR,
                              dstRect,
                              b);
                    }
    }
    public static void copyBand(java.awt.image.Raster src,
                                int srcBand,
                                java.awt.image.WritableRaster dst,
                                int dstBand) {
        java.awt.Rectangle sR =
          src.
          getBounds(
            );
        java.awt.Rectangle dR =
          dst.
          getBounds(
            );
        java.awt.Rectangle cpR =
          sR.
          intersection(
            dR);
        copyBand(
          src,
          cpR,
          srcBand,
          dst,
          cpR,
          dstBand);
    }
    public static void copyBand(java.awt.image.Raster src,
                                java.awt.Rectangle sR,
                                int sBand,
                                java.awt.image.WritableRaster dst,
                                java.awt.Rectangle dR,
                                int dBand) {
        int dy =
          dR.
            y -
          sR.
            y;
        int dx =
          dR.
            x -
          sR.
            x;
        sR =
          sR.
            intersection(
              src.
                getBounds(
                  ));
        dR =
          dR.
            intersection(
              dst.
                getBounds(
                  ));
        int width;
        int height;
        if (dR.
              width <
              sR.
                width)
            width =
              dR.
                width;
        else
            width =
              sR.
                width;
        if (dR.
              height <
              sR.
                height)
            height =
              dR.
                height;
        else
            height =
              sR.
                height;
        int x =
          sR.
            x +
          dx;
        int[] samples =
          null;
        for (int y =
               sR.
                 y;
             y <
               sR.
                 y +
               height;
             y++) {
            samples =
              src.
                getSamples(
                  sR.
                    x,
                  y,
                  width,
                  1,
                  sBand,
                  samples);
            dst.
              setSamples(
                x,
                y +
                  dy,
                width,
                1,
                dBand,
                samples);
        }
    }
    public static boolean is_INT_PACK_Data(java.awt.image.SampleModel sm,
                                           boolean requireAlpha) {
        if (!(sm instanceof java.awt.image.SinglePixelPackedSampleModel))
            return false;
        if (sm.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            sm;
        int[] masks =
          sppsm.
          getBitMasks(
            );
        if (masks.
              length ==
              3) {
            if (requireAlpha)
                return false;
        }
        else
            if (masks.
                  length !=
                  4)
                return false;
        if (masks[0] !=
              16711680)
            return false;
        if (masks[1] !=
              65280)
            return false;
        if (masks[2] !=
              255)
            return false;
        if (masks.
              length ==
              4 &&
              masks[3] !=
              -16777216)
            return false;
        return true;
    }
    public static boolean is_BYTE_COMP_Data(java.awt.image.SampleModel sm) {
        if (!(sm instanceof java.awt.image.ComponentSampleModel))
            return false;
        if (sm.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_BYTE)
            return false;
        return true;
    }
    protected static void divide_INT_PACK_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
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
                ));
        final int[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width;
            while (sp <
                     end) {
                int pixel =
                  pixels[sp];
                int a =
                  pixel >>>
                  24;
                if (a <=
                      0) {
                    pixels[sp] =
                      16777215;
                }
                else
                    if (a <
                          255) {
                        int aFP =
                          16711680 /
                          a;
                        pixels[sp] =
                          a <<
                            24 |
                            ((pixel &
                                16711680) >>
                               16) *
                            aFP &
                            16711680 |
                            (((pixel &
                                 65280) >>
                                8) *
                               aFP &
                               16711680) >>
                            8 |
                            ((pixel &
                                255) *
                               aFP &
                               16711680) >>
                            16;
                    }
                sp++;
            }
        }
    }
    protected static void mult_INT_PACK_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
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
                ));
        final int[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width;
            while (sp <
                     end) {
                int pixel =
                  pixels[sp];
                int a =
                  pixel >>>
                  24;
                if (a >=
                      0 &&
                      a <
                      255) {
                    pixels[sp] =
                      a <<
                        24 |
                        (pixel &
                           16711680) *
                        a >>
                        8 &
                        16711680 |
                        (pixel &
                           65280) *
                        a >>
                        8 &
                        65280 |
                        (pixel &
                           255) *
                        a >>
                        8 &
                        255;
                }
                sp++;
            }
        }
    }
    protected static void divide_BYTE_COMP_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          csm.
          getScanlineStride(
            );
        final int pixStride =
          csm.
          getPixelStride(
            );
        final int[] bandOff =
          csm.
          getBandOffsets(
            );
        java.awt.image.DataBufferByte db =
          (java.awt.image.DataBufferByte)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          csm.
          getOffset(
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
                ));
        int aOff =
          bandOff[bandOff.
                    length -
                    1];
        int bands =
          bandOff.
            length -
          1;
        final byte[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width *
              pixStride;
            while (sp <
                     end) {
                int a =
                  pixels[sp +
                           aOff] &
                  255;
                if (a ==
                      0) {
                    for (int b =
                           0;
                         b <
                           bands;
                         b++)
                        pixels[sp +
                                 bandOff[b]] =
                          (byte)
                            255;
                }
                else
                    if (a <
                          255) {
                        int aFP =
                          16711680 /
                          a;
                        for (int b =
                               0;
                             b <
                               bands;
                             b++) {
                            int i =
                              sp +
                              bandOff[b];
                            pixels[i] =
                              (byte)
                                ((pixels[i] &
                                    255) *
                                   aFP >>>
                                   16);
                        }
                    }
                sp +=
                  pixStride;
            }
        }
    }
    protected static void mult_BYTE_COMP_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          csm.
          getScanlineStride(
            );
        final int pixStride =
          csm.
          getPixelStride(
            );
        final int[] bandOff =
          csm.
          getBandOffsets(
            );
        java.awt.image.DataBufferByte db =
          (java.awt.image.DataBufferByte)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          csm.
          getOffset(
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
                ));
        int aOff =
          bandOff[bandOff.
                    length -
                    1];
        int bands =
          bandOff.
            length -
          1;
        final byte[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width *
              pixStride;
            while (sp <
                     end) {
                int a =
                  pixels[sp +
                           aOff] &
                  255;
                if (a !=
                      255)
                    for (int b =
                           0;
                         b <
                           bands;
                         b++) {
                        int i =
                          sp +
                          bandOff[b];
                        pixels[i] =
                          (byte)
                            ((pixels[i] &
                                255) *
                               a >>
                               8);
                    }
                sp +=
                  pixStride;
            }
        }
    }
    public GraphicsUtil() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pvsync9+uUCIsp6vEN7jh3j0h/8HGbitKT1IAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CdArWXWe3v/mzcYwG9t4zAzbgDMIv1Zra8njhZa61Wqp" +
       "JbV6UbeawJvepG6pN/XeclhMygZCBShncHDZppIqKC8Fxia4vBKTiomhcFzB" +
       "cWwnjpcQXPESgnHZjg2Jndst/eu89w+P/72oSket2+fee75zzzn33O7b/ZEv" +
       "la4EfqnsuVa2tNzwqp6GV1dW42qYeXpwdUA1aNkPdK1ryUHAgbJr6it/6oG/" +
       "/tr7jAcPSndKpRfIjuOGcmi6TsDogWvFukaVHjguxS3dDsLSg9RKjmUoCk0L" +
       "oswgfIoqPe9E1bD0BHUoAgREgIAIUCEChB5zgUrP153I7uY1ZCcMNqW3lC5R" +
       "pTs9NRcvLL3idCOe7Mv2vhm6QABauDv/PwOgisqpX3r5EfYd5mcBfn8Zeuaf" +
       "v+nBj18uPSCVHjAdNhdHBUKEoBOpdJ+t24ruB6im6ZpUesjRdY3VfVO2zG0h" +
       "t1R6ODCXjhxGvn6kpLww8nS/6PNYc/epOTY/UkPXP4K3MHVLO/x3ZWHJS4D1" +
       "xcdYdwh7eTkAeK8JBPMXsqofVrljbTpaWHrZ2RpHGJ8YAgZQ9S5bDw33qKs7" +
       "HBkUlB7ejZ0lO0uIDX3TWQLWK24EeglLj96w0VzXnqyu5aV+LSw9cpaP3p0C" +
       "XPcUisirhKUXnWUrWgKj9OiZUToxPl8af/t7vtvpOweFzJquWrn8d4NKj5+p" +
       "xOgL3dcdVd9VvO+11A/IL/7kOw9KJcD8ojPMO56f/Udfef3rHv/UZ3Y833wd" +
       "nomy0tXwmvoh5f7Pv7T7ZPtyLsbdnhuY+eCfQl6YP70/81TqAc978VGL+cmr" +
       "hyc/xfy7+dt+Qv+zg9K9ZOlO1bUiG9jRQ6pre6al+4Tu6L4c6hpZukd3tG5x" +
       "nizdBY4p09F3pZPFItBDsnSHVRTd6Rb/gYoWoIlcRXeBY9NZuIfHnhwaxXHq" +
       "lUqlu8C3dB/4EqXdp/gNS2+CDNfWIVmVHdNxIdp3c/wBpDuhAnRrQAqw+jUU" +
       "uJEPTBBy/SUkAzsw9P2J3DPlJIRMGww/RPiyZ5hqwOfoczvzbnsPaY7xweTS" +
       "JaD+l551fgv4Td+1NN2/pj4TdfCv/OS1zx0cOcNeO2GpDDq9uuv0atFpEThB" +
       "p1eLTq+e7LR06VLR1wvzznfDDAZpDdwdBML7nmTfOHj6na+8DOzLS+4AGs5Z" +
       "oRvH4+5xgCCLMKgCKy196gPJ98zeWjkoHZwOrLnAoOjevDqdh8OjsPfEWYe6" +
       "XrsPvOOP//pjP/Bm99i1TkXqvcc/u2busa88q1rfVXUNxMDj5l/7cvlnrn3y" +
       "zU8clO4AYQCEvlAGpgqiyuNn+zjluU8dRsEcyxUAeOH6tmzlpw5D172h4bvJ" +
       "cUkx5vcXxw8BHT9a2pNTtp2ffYGX0xfubCQftDMoiij7Haz3I7/z639SK9R9" +
       "GJAfODHFsXr41IkgkDf2QOHuDx3bAOfrOuD7vQ/Q/+z9X3rHGwoDAByvul6H" +
       "T+S0C5wfDCFQ8/d+ZvOf/+D3P/SbB8dGE4JZMFIsU013IP8efC6B79/l3xxc" +
       "XrBz4Ie7+yjy8qMw4uU9v+ZYNhBQLOByuQU9wTu2q5kLU1YsPbfY//PAq+Gf" +
       "+Z/veXBnExYoOTSp1z13A8fl39Qpve1zb/rfjxfNXFLzCe1Yf8dsuyj5guOW" +
       "Ud+Xs1yO9Ht+47Ef/FX5R0C8BTEuMLd6EbZKhT5KxQBWCl2UCwqdOVfNycuC" +
       "k45w2tdOJB7X1Pf95p8/f/bn//orhbSnM5eT4z6Svad2ppaTl6eg+Zec9fq+" +
       "HBiAr/6p8T980PrU10CLEmhRBZEsmPgg7qSnrGTPfeWu//Jv/u2Ln/785dJB" +
       "r3Sv5cpaTy4crnQPsHQ9MEDISr3vev3OmpO7AXmwgFp6FvidgTxS/HseEPDJ" +
       "G8eaXp54HLvrI1+dWMrbv/A3z1JCEWWuM9+eqS9BH/nhR7vf+WdF/WN3z2s/" +
       "nj47FoMk7bhu9Sfsvzp45Z2fPijdJZUeVPcZ4Ey2otyJJJD1BIdpIcgST50/" +
       "ncHspuunjsLZS8+GmhPdng00x3MAOM658+N7z8SWh3Mtd8GX3McW8mxsuVQq" +
       "Dl5fVHlFQZ/IybcUY3KQH/4D4M9BkWcWrT8Zlu4mMXzMkdy84H9RWHqsMJJ8" +
       "ylnqrn0VXSyAMjlfdoI8HO7iV05rOUF3o968oYU8dST/I3kpDELKn+1Yd7/X" +
       "kX9wffkvF/LnBAuB+kxHtg4xPCigzPgahrMcOUY5cjI+3/xo37RB/Iz36Rr0" +
       "5of/YP3Df/zRXSp21tbOMOvvfOaf/P3V9zxzcCIBftWzctCTdXZJcCHq8wt5" +
       "c+99xXm9FDV6/+Njb/7FH3vzO3ZSPXw6ncPBauWjv/V/f+3qB/7ws9fJIu5S" +
       "XNfSZefMYA1vcrCqwGimO1YwH11/sKTnHKycjA9H6nl5Gin71wKG6Bwa3Dcd" +
       "GdwuxwFB2vVHrqZbZ+R/wzcgv7SXn7+B/OrNyf/ACfmv0X6h8mtnxNS+ATHV" +
       "vZhvuoGYq5sT86GTYvKOd31B19+AoPZeUOMGgm5uTtA7cgmvJ5v/DcgW72Xb" +
       "3EC29OZku/u8Qc6+AfneupdvewP53npz8t17/ui+7Tkl3EWjSyDHu1K9ilyt" +
       "5P+/7+ZkeMnKUp84zPtmuh+AafuJlYUc+vaDhW/nE+TV3RL/jJBPft1CgqB5" +
       "/3FjlOssn3r3F9/3a+991R+AADgoXYnzKRlEyhM9jqP8Asr3feT9jz3vmT98" +
       "d5HUgmln9q6frv1N3up7bw7qozlUtlgbUnIQjorcU9eO0NIn8HDAsi33AmjD" +
       "l7y8Xw9I9PBDCSomomoqCaheUSHLFqWy37O6VZqiE2M7tucikaQDqYs1A2Hb" +
       "YUNpEFgTYdnWV1VpXtH7kk2PR77Ppy2ol1lKj5yhXtKppUJ9M5p6Jj42p2u8" +
       "U2e1iTcfDNjeIFW7qNqrUc4adQfufLDtiUmvrDg13Zaqkq3VJBu2ZvCsOWn4" +
       "3iKsxc22HostaNKk+zVWmnnrnrwJTFOBN2upJrMZquGJrAwonIe3xKhueajq" +
       "pzSktQUEGiQzluYpm5sbtpOxcojrNhuSKsmHFiyw5tAitk6bXMPGMtng9piV" +
       "+gN75XVtW9iOmzwwO3ZLm/AgUDvVytzkGA9Pp2ljPGp7/rDaWctM2sSjUdsU" +
       "xTqFLPqsVF03tXHUYiS6xSJ0j80kNQwyQrDJWjaYmD5eWTdmcxGTJL01X1rl" +
       "SB6tqpHcTYejLG2aCNVhnM5qgY/0pTej4T5Ub3EVDmO2nUWvNxuryniU6N6G" +
       "tblxZ+20dUTipt7YFuNB3OgOJwNnNVRTUmin3hiVgY11mBTe1Ho0U6Yskduw" +
       "zbHdGqmcJjSNDmxKuBDhVqWSDsDIuliN4Dh+NA6romEHotSEYZ/Mti0Ooeot" +
       "TXc6YtIYzbx+E4dH8QbvS/3lup7IxBRfjil+iImjlc2yg7VGuskGo/npWJhx" +
       "68VCIscNJ4u6m2yMZtAymdGeM9u0MEmbrbqT+SBiLM+wpVFFqScNC4J52HNX" +
       "q/kk7MKwQiVGvYUlipCFaDqvJHiMTPzZpMnA7HSVQQkcrORqbTrtuZNN0CN4" +
       "TvBlj7UEHG9yA9UAShtpq2m502yulryvUSg6hYneUt0wmtwcTipMWl13aW0g" +
       "KkG32RnObDXtzA2pZy+2RNTlJS8Qyjw9obeLGCKiansWNpddk+8u1jDDBnR7" +
       "6/aGvt8ml315RBiitZzJqYLX2qhIr8zpHJ8Ox9tgWM1mui5tpW25HcYiPoRl" +
       "yUwivsp5zS6wh+nKbU4iiF9vkJnT3KJKyLm26azqE22+tRfSsl+1aHmMGT17" +
       "Ds+XottCenh9FCPIqk30YZqkhLbX81mrPx1CQ4OpWMOm3+usRrDgkdxQRrrC" +
       "diP5QT3UkIxN6qsg2IRqI+ozwXaoB5Y1dcE6opbGSZ8hhgbKULOEGoYr25kE" +
       "ZjXr9qtaZRosg3J3BreoSBIwqLVu9LRgug4ZYWIOhptsE/AEhtbCcXU0VXm5" +
       "g/BM0KPSMtfa8pWlXJ/jyTa1R2Z5hOMhCy1BNHEEPJ0kC6w/NiKTNntUYyVX" +
       "+jE8omoBRShMClnTNRqbYrmrQ2g8ts3mfL2RiCm24ZFxo9aWosEsQ3rJKDQq" +
       "BLVWCReWV7zUcLcpP92MmZq94quZOWD6htJFOqncMIw1raAaqdUFRGs2J3NF" +
       "S9uqMO2XPb49Q208iFYDEIysbF4nuaxDsy1ZbpRhuRXrDQTd2KN1JjFz22IS" +
       "QVgnqdlHu2IY6FpSY82AnSDdYJxtR5PuULKXLMcP1K7lLpVuBa6aUxgY8qq7" +
       "TWSH4KlBdRnoY9yt9ttZPcb4vhbGEUwup1FDXuKwMGVWWHM5mifKhImCygJN" +
       "fM/noARxF/1+24wjDV9KtV4KB2zLtlcY67dqZRpfe5hIpbLKUeVGXG8bzhRh" +
       "bDJIoi7JhtBKypbrKoIjK8Yy3EQHY8Jvhl0r3RKhsO1Whoo6aqdjAsYrQtqk" +
       "qIjzSRJqwEnNwyDIHCBlxPTGFcvVmlvELTM9GxlkrBGYc33R8bRVmlSH5CyL" +
       "t0mrRUC1uNZeDmpaf9jvDdypovB9qTMkKQadDxeLqhjbSLtZLhteIs6Mjh1m" +
       "usGwdpLVJLW/qLNqN65BmJgkK31EDgcVWNPWqeIs4c3El1tZVFEMTO2hS7TJ" +
       "tINqT0unfY/u8XPRhGiLgmTRd2IEq01rgtoNkzQmhFDlZ9FEjZsmW4sR3xe7" +
       "oYg3eokuio1IFQIbqy1gLTWICVlpm+Nt2ioLUBwOWgJBQkYn5cT1osETvNpp" +
       "4lgZJbbRYEhtoCoIHkIqCzbc0rZeA3cw3iPbjW15PkGqGFxvZrVIsStaI0Vg" +
       "Gh4HIYUMCJTxFI7IGLzNpc01qTVkctQmCIaGOyGuVgZ8X4HNBUKPzaVDu5LN" +
       "NDtSdz4E4y6g/MAZqCyw4LEQQNA2aqdKRFuzjtFpsJuqYQbrxRqvI6POuuw0" +
       "lgxenaflpKmHi/V2tiRWSxoHa3Al4SaoT3VdKPY8blImV4FeUxg+DRb0ggQe" +
       "H2sVB099uIwtuZaTxEO+JtXWKdxE2pFO1+IYtSjR9ZPmRKEaTYpphzNeiWl6" +
       "DOk63Z3Dm44xYsRFxlXL+ISKmg1o1dZqyyQWlCBeU/B86o6rzWa9bEFmFvh0" +
       "szwl5PEaVQacR9TMiis3IJ70SMFebzWM8OAtzS16ATSU2vY2ESckrQwaNiT0" +
       "xyLLGQQer1qzbIFtFQPvKx2lCYVLBC7368l04aArHxkOszbvwjFl4BCWdJfL" +
       "dLCG8BHs9GqYKk/T6ZYPaQUkfFDU1+qdJsSjRuAja6Gukm2OYsQQLC6xejAh" +
       "NiBzceVq3YRAdCWaWTV0502K06pKs1IfWzCO+oug7slOIoxqPWWeoV40IL1y" +
       "x02t2YxpGWZ9yE8RJAraFYyeO9FKHWPAI7RkW1OiGr1lvaTBNIarxmaKqktP" +
       "6PA2IjF1SO1ETQFTEiwSGjAAQw5mfmyn1Y4OfK1PrSBT5uujRuqj26pXH6EO" +
       "yWxhX1h2h0OUldZM7DTxdrxoD4M2htQQTAbmE4GcoZLQ/djv1prjWh+hBNSO" +
       "ObXi6HEwVtK2Xy/3NzVyk8zEDe2ErUWNhqA5tBwLfsPLeMgYBzjdTqMQgmb9" +
       "SqsPQS6O2RMi5CvpdLMJ7XkvsOzFNMzUWUhoWnsGtYBCGb697mOVtbepDKP2" +
       "uNJurBGLVSRZ6tMLMOASj0DCdquOYWtAkQS6oegQ0RYuUY6NulPfwhKjkv1u" +
       "7FU2zTBwtWiKhBshXRIS0YhQgtlO2UaE2ZytsmKD1dKeUsX0qCOZnW4q6OvJ" +
       "crRiylmkoEGi2j7B2HWqQmZ+RITreYAt69VVUxk5o6SjDBSnJy671dpWMwUR" +
       "GCkhOJWqPxjD01BRoWDk446k8HUcmOIyDaVRhzDs9XjTIeb8aIItMTRTQime" +
       "EwTdtQgmSsYVdOuTHYN2RBojs/pWaGzEOspgLWRu9isd27BBGNdBKOzZEurV" +
       "Bq0hUq/JXQhmuTrOSetKixUxQeiE1WXdjIkKF9B93oog3W0mKlKbC4K85bh2" +
       "151N+EBYbZYVuCGz9mKRCc4gdiCR0hdKu+zb1VarQlUh0YxCdTXpx229s4kl" +
       "O+rCVa08W9cW5UXcT9rMBKGqKBW30n4mQ5lcq9JQFdsOo3V5qbWhsENNYzoS" +
       "IkmU1faiK7iTLBz2bd9pio2uvKhT0rraQURSgZTIr/PrvpU5WXWqTes9mWbC" +
       "csJQljKubtVyJKr1tguJ2tbnrdiZhevhJqk2qYEYZ5QGMQopxkMJ7rT6TBLK" +
       "c4OLUTe21igTLlyaaNeGLA9PIot2WgLJkP10YZhqUxORcmW2tWetYSx3aFnk" +
       "KDtKRpWeLU8WW8RLqOom61ZaSX2uIXPS1Cltue5KDQZuTeaLBtbr6q0t3cfV" +
       "DFkgDZmiUpbqU4MKE9X93qxN8QkxppfTmbJe0S2rFqowELg+rEDMkhYVHSc8" +
       "dbap9qBGixrrHLzu0XUq5dsYE/X4iAfxqoVtZCmW+Az8kdXumJTqk7lb08k4" +
       "NlysSc/dLSl3yuJUmrJQX24I2KSJSJLfUEezAUa0OliAIROtqRCpMjDgrlkb" +
       "9vxBi58p/bC13IxqlkMnqQF1VL6/RTNuO3Sz4ZJraNVGsiYWFLtwR1tZGGU8" +
       "1pc5Js36ZsNSnIDqkRzXdVmQGbhT02VxXpp2a30Z7rtNXK8KTHmG9dhpanem" +
       "XI2cdytjNJQ7LtrDVlYfJP8te9Mcb0W6rHdlMxOZagW1G0HgaJIz5NGebCbE" +
       "xqzgcNfl/XlWaZDUMObgZRSYgsXQkhDGaMiCLjZsSlAUTKpmxPhEdUSRRk20" +
       "XXKi62adA5NQnXUm6kzSu43OsN0ZmZYqzUJoplr1jr0OUn+0NQi1Zrqg6mhl" +
       "VWXbgmXOC4ht5ncrrEL4RG8K4c2Wb1kdLDGoMFiXWxtCnS5XKj7Var3pMsOn" +
       "BtzHCcEamWLkNmoSO2u0YzTWQepM1Htm1qwhSgB5w7QbDuYTKrYXtZZgKDDS" +
       "KtfWQ5tD1uxyITbW216vxkeV8XTVHIFsnuszUpXDotpYFJiqtezVh3ATs7vz" +
       "lhSNGz7BocvtlJiUtQEX8CNSkoi1Oqwws5GzUQkiVIztCuquu03fdcAiY+lS" +
       "Lc5Z6eMobqxdfFixliO4UzFcuj5L5epoAYGElPXRpkhbdX/K+phlCTVhIw2y" +
       "7hiVtrq72ZZ7JOnVQqY2mpENhlknWL0lZisxdXiKoImJoibIQB1x3rjnxEIL" +
       "gqMMQlhBXnX8CSwL5U2jlUojKd5CIMmfYBgpgoQ/GnSMAGKbGq2RxoiLFzXM" +
       "nBMT34uSkIrh1ZzTGLrR52c6MBBGdpoztC+b6YhwKy3UHDJbk69nfTR2RVOG" +
       "G0uaqaU6oZYDgrZQZ47ZlNgb220qmwO74pJ43i0TKB1MTFudb0QCLXPLtpBI" +
       "kyGEyhTKz8btUKjNkoxb4zJaGasNdNVvES7pGuVVGauvwvmKtH1T9aex1xAH" +
       "3cBv14Jtg0JNi5yXeyMqCkekoaqZFBhgmLqtmTv3Q9pKljMEZAeiMhnrw44d" +
       "kWStt5iA+VPqlI3yAJpjExB2gl42W8sLCptYHVoQEMlTGjxYXANfhvSQrmvL" +
       "SX1hrso6hsxH2Rwfzcq9WZZK7YCE2vzITh1lDjsJ0msonr9Vaxk16E1xsJza" +
       "4CNpQXCNNZNUB52wMS5bUUMfEaaAOVTFttqWOxAlRQiDxaZV0xOmj3AETqy2" +
       "vLo1yGlmTNTINCuRO4QXTbQf1zJLUaKxzNanPkt0tl19Ml9SaNQJUarHKB2M" +
       "3fCzQRQPNVI3OWjFdqq9NOKMECViWZFjmW3NPZYYpZyl4yq5MSIyYya81eDX" +
       "CDv1uPJmlvH+sqdoYVAd8B4xZIjliDPmjj7p1qtLeirymrmsdjLZSDjGhpBm" +
       "q6IM48ra6bPolmt2e0w2k/iJV1nSdHkozqdqg0IisKjsrC2xrFE06H3EIit8" +
       "II5GdKSucHwxE31qAM9mDXnoyoK3HEmo4TVadY9ocxZpIOjSCA26t8arAQ/m" +
       "XNqmsAZLCh0kDsweDW8kkinDLMoY5Y68aW4m6ygYpJqyaoURTbLaCidH0kqT" +
       "O47SCiUUBjM/pAgWlGnLnswmalVKvCg0auuqRnKT9XArSNLMbzLYBq+v+CE2" +
       "wCvVYKvV8QBRa7rIwqMQjrc4MQbNr2eK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
