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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL2cDXAcxZWAe0e/lmVbki3bGFvGsnDiPy3GGF8iEpDkHwlW" +
       "PyfJphDg9Wi3Vxo8OzOa6ZVWyjkOVAVI6jApsIlzCb5Kzq5zfA4mFBR3EBxf" +
       "hYSkgKMMKQ7iCslBuOTiUIW4OsxB7rj3emZ2Zkc7s7Y0da7a3tF09+t+X79+" +
       "/Xp22qfeI2WGTho1UUmKzWxCo0ZzL173irpBk+2yaBgDcDee+Pq/PXzg4mtz" +
       "7hZI+SCZPyIaXQnRoDskKieNQbJCUgwmKglqdFOaxBq9OjWoPiYySVUGSb1k" +
       "dKY1WUpIrEtNUiywW9RjpFZkTJeGMox2WgIYWRnjvYny3kRbvQVaYqQ6oWoT" +
       "ToVleRXaXXlYNu20ZzBSE7tLHBOjGSbJ0ZhksJasTtZrqjwxLKusmWZZ813y" +
       "FgvEzbEt0zA0Pr7gw0++MVLDMSwUFUVlXEWjjxqqPEaTMbLAubtdpmljlHyZ" +
       "lMTIXFdhRppidqNRaDQKjdr6OqWg9/Ookkm3q1wdZksq1xLYIUZW5QvRRF1M" +
       "W2J6eZ9BQiWzdOeVQdurctraw+1R8fD66KFv7ql5ooQsGCQLJKUfu5OATjBo" +
       "ZBCA0vQQ1Y3WZJImB0mtAgPeT3VJlKVJa7TrDGlYEVkGTMDGgjczGtV5mw4r" +
       "GEnQTc8kmKrn1Etxo7L+KkvJ4jDoutjR1dRwB94HBask6JieEsH2rCql+yQl" +
       "ye0ov0ZOx6ZboABUrUhTNqLmmipVRLhB6kwTkUVlONoPxqcMQ9EyFUxQ57bm" +
       "IxRZa2JinzhM44ws9ZbrNbOg1BwOAqswUu8txiXBKC3zjJJrfN7rvuHgl5QO" +
       "RSAR6HOSJmTs/1yo1OCp1EdTVKcwD8yK1etij4iLn7tfIAQK13sKm2We/qup" +
       "mzY0nP25WebKAmV6hu6iCRZPHBuaf255+9rPlWA3KjXVkHDw8zTns6zXymnJ" +
       "auBpFuckYmaznXm272e3feUkvSCQqk5SnlDlTBrsqDahpjVJpvpOqlBdZDTZ" +
       "SeZQJdnO8ztJBVzHJIWad3tSKYOyTlIq81vlKv8bEKVABCKqgmtJSan2tSay" +
       "EX6d1QghFfAh1fDZScx//JsROTqipmlUTIiKpKjRXl1F/XFAuc+hBlwnIVdT" +
       "o0Ng//s2bmreGjXUjA4GGVX14agIVjFCzUw+T8VxFpXSYAzRnbqojUgJYxey" +
       "QKvT/p/by6L+C8cjERia5V7HIMOc6lDlJNXjiUOZtu1Tj8VfNI0OJ4pFjpH1" +
       "0Giz2Wgzb5S7UWi0mTfa7G6URCK8rUXYuGkCMID7wBWAL65e23/nzXvvbywB" +
       "29PGS4E+Fl0zbW1qd3yG7ejjiVPn+i6+8nLVSYEI4FaGYG1yFoimvAXCXN90" +
       "NUGT4KH8lgrbXUb9F4eC/SBnj4zfvfvANbwfbp+PAsvAXWH1XvTUuSaavHO9" +
       "kNwF9/3hw9OP7FedWZ+3iNhr37Sa6EwavSPrVT6eWHeV+FT8uf1NAikFDwVe" +
       "mYkwi8DhNXjbyHMqLbaDRl0qQeGUqqdFGbNsr1rFRnR13LnDTa4Wk3rT+tAc" +
       "PB3kvv0L/dqjb/zLf2zmJO1lYIFr/e6nrMXlelBYHXcytY51DeiUQrlfH+l9" +
       "+PB7993OTQtKrC7UYBOm7eByYHSA4Fd/Pvrmb9469kvBMUcGa29mCMKYLNdl" +
       "0afwLwKf/8UPugu8YbqNunbLd12Vc14atrzG6Ru4MRmmNhpH0y4FjE9KSeKQ" +
       "THEu/HnB1Zue+tPBGnO4ZbhjW8uG4gKc+1e0ka+8uOdiAxcTSeAy6vBzipm+" +
       "eaEjuVXXxQnsR/buV1d86wXxUfDy4FkNaZJyZ0k4D8IH8DrOIsrTzZ686zFp" +
       "Mtw2nj+NXOFOPPGNX74/b/f7Z6Z4b/PjJfe4d4lai2lF5ihAY8uIleQ5b8xd" +
       "rGG6JAt9WOJ1Oh2iMQLCrjvbfUeNfPYTaHYQmk2AIzV6dHB72TxTskqXVfzq" +
       "n3+yeO+5EiLsIFWyKiZ3iHzCkTlg6dQYAY+Z1W68yezHeCUkNZwHmUYIoa8s" +
       "PJzb0xrjAzD5j0uevOHvj77FrdA0uyt59UoDYzmvb+QBuTOt/3T+2+/8+OLf" +
       "VZjL+Vp/X+apt/TjHnnonrc/mjYS3IsVCDU89Qejp76zrP2LF3h9x51g7dXZ" +
       "6UsNOFyn7rUn0/8lNJb/VCAVg6QmYQW/u0U5gzN5EAI+w46IIUDOy88P3sxI" +
       "pSXnLpd7XZmrWa8jc5Y4uMbSeD3PY3V1OIrt8Om0rK7Ta3URwi86eJWrefpZ" +
       "TNbzIRTwcgM4FYOH2NmcYG4etQGCGans3La9e6Bz4DZeaSkjK7gh4bI7TNV0" +
       "c2sqBcQHdFEx0CebnhbTrZh0mm21+JppW64vS/HuJnB+F8yi5ncBJfsLK1nC" +
       "lcQkxoCxpIiyR9ElAcJhx3Zra193fNv2/oHO7taBzp5u7k1cdo8byv7MkMF6" +
       "dSkNK8GYFe6eXnxx9PmKyW12KFuoilnyFqPrlWc6fh/nK00lxg4D9oi7ooJW" +
       "fdi1gtVgshHdSsCs8vQour/uN/u+84cfmD3yTiFPYXr/oa9/2nzwkLkCmFua" +
       "1dN2Fe465rbG07tVQa3wGjt+f3r/syf232f2qi4/QN8O+88fvP4/LzUf+e0v" +
       "CsR+FUOqKlNRybm2SC5uW+wFbqpVvunR/z5w7xs9EGh0ksqMIo1maGcyf8JV" +
       "GJkh1wg4GyZnEloK4nrLSGSdpmU9Fj5wmRZ+LUzHvzSLghEUtvB9RS0ck1un" +
       "m7cpsYBkRubiBkbU40bfzjZ7Kl+Rm8pmBA0Lg6ojQtmjpDwDJQetruzyUTIz" +
       "YyV3+UjG1dtRMt6r83Ec9egyNgNdElaLe3x02T9jXfb4SGak1q3LLkUrrM2X" +
       "Z6BN2mpzxEebr85YmxEfyQxCOlCjkAL3zkCBMauZUR8FHpixAqM+kmEdDLKp" +
       "gzNQ4oDV1KSPEodnrMSkj2RGqoKN6ZEANbKFuxPh3XE6wf+VE/8A2RVZElw3" +
       "Vvg9gOJrxrF7Dh1N9hzfJFhx/hCD6FfVNsp0jMouUU18BfIGqV38sZsT8W19" +
       "9WLJ+YeWVk/fu6OkBp+d+Tr/ddfbwAv3/HHZwBdH9l7GpnylR3+vyO93nfrF" +
       "zjWJhwT+5NAMMKc9ccyv1JK/ylXplGV0JX9da8wPLsEgyYA1Yv1eg3SsxCey" +
       "5NZYIKrs95Ho2cgJpih7VVqYW5XsJzrXbrPzlntWrD6qwP6JJjvxL97R0wG7" +
       "xKcw+T6YUFIXx3kVXuxOTDaa/RfBVY2pUtKZFCeLze28nRbeuInfPp5P+Br4" +
       "iBaPvaER3usjsTBh/PNxG+XmIo/TdAttczsUwd1+H03yjv4kgPALmDznJow3" +
       "nnZongmH5nXgeQ6ZEiIPhUXTlFRAokfhEscR52iu9RimSQ+xWTaKl47JQY3P" +
       "FKth/RLC1Xk1gPkbmLwUwPzlcJj/BZB5yiL0ZGjMn/SRGGDBmLzGW3wnAMu7" +
       "mPw6AMtbs8ayArPWQ+dft5R4PTQsfhKDXafXPbZlUqmce7QLLckVMu1MUoY7" +
       "JIUZvLPvBxD9EJM/MjI/oVORUds7O/OAY70QHta3LQhvh4bVT6JH64gT20xh" +
       "Y5GIP5YIdwSfFMPy51ljuQqzmqFbH1tKfBwaFj+J/lge56rPD8CCO+dIJWAZ" +
       "pmwbNZikiPbT86kclsiccKxlC2hYZ0owv8PA4iuxGJYrA7CswKSekaX5WPK3" +
       "3qMOoMXhAdpgqbMhNEB+EosB+mwAoHWYNBYG1K/ZP7/nPb1IYF6zpwSnt3rW" +
       "9JZjFgRvwmZL182h0fOTWIze1gB6n8NkEyOL8um1qRkladjk6lwrQAK2DMOy" +
       "C9m14RgcOCrha5aCXwsNmZ9Ef2R3cCw7ApB1YHITI7VpcR91PXRp7/JMxdZw" +
       "XPhW6P9hS4/DoZHxk1g4duV/D2Ji7Xs8e6ASyXoNyENzmBMbcMD2B4BF+ZEu" +
       "CDgcsHkByWj+UtA9a7wNmAW+SDhhwTgRGl4/if6G9zxnQAP4DGMSx8BBVcao" +
       "zgbUmP2U7HkHy95wsEA8JTxrKfFsaFj8JBbDogdgwV+gIzLjP7mZWApQSYdD" +
       "pRH6fs7S4VxoVPwk+lN5gmt+IIDK3ZhMMFI6DvGlB8ZkOBu8Dujy76yu/y40" +
       "GH4SPbp6djL13gc9osGobueu8OTeqkuMP6LgpTivvw5g+RAm9zJ870ub2CYy" +
       "Md7ZPRDvbW2/BUs7W8TIfaGBLVljSjC/wwDrK7EwWFTnAUwe5AgeDcDzt5h8" +
       "041nR2ss1jYdz5Fw8NwISnRYynSEhsdP4iXhORmA5xQmxxiptPF4qByfNZVV" +
       "mAUOu+ROS4c7Q6PiJ9HXNUUe4Eo/HQDknzD5ISNVCMScgpykg+SJ8JBYv/2Y" +
       "36Eg8ZNYOHLKGcoATziA5wPg/AyTM0FwfhwOHChV8iNLlR+FBsdPYjF7OReA" +
       "5DVMXoRtCMaFJhLbgXvQvBQemvOWIudDQ+Mn8dLt5q0ASL/F5I1LgfTmrCFh" +
       "BfxhsuQDS6UPQoM0ZUmcCobkerzLf5Q0NxcXAvi8h8m7DF/conqC+j4/+fdw" +
       "6MBCVVphSjC/w6BTWm5JLL9kE3rQg+ijAEQfY/IBdz2IyF6qXHD+M5wFHHa0" +
       "pQ2WKg2hwfGT6O96+NotlPkjESqw2Kewt0hnZCZp8kSrrI14FnCBhENlC/S9" +
       "xdKhJTQqfhKLUakLoLIIk2pG5ialMSlJCzGZFw6T66Hney0N4qExiftI9Hcy" +
       "Uzzhyq8MALMKkyt8Qz1hWWi/DZfqlg5aaFQ0H4kefUu5qFKbSqSFX/Fs2GnN" +
       "z+20elVJ4T9GChsCiF2DyRp/Yp8JhxjULttkSii7JixipqQCEn2JuVb0B0ft" +
       "ZV1oCeDzBUy2WHzaRCXp4XN9OHxioIXlKco+Hxqfz/tI9OhbzkWV5/i05ENq" +
       "cUh1BJC6GZM2f1LtsybFX+ZfB/p0W3p1h0bKT2Jhj2RPtmWexxr9YlqTaS6q" +
       "4Su+sCuA2W2Y9EBQJBm5Rxpxexbe4bDrDefpWRQ0tF75K5v2MuHlsuNhVn2A" +
       "RN8VTtjNlU8GgElhsoeRWgDTdtvA9nh7T1dvITLxWZOpx6xW6L/l0c3vSyXD" +
       "yBxNVxlNMJosZFyLAgQXCwECHroK+NBV2MfIIjMEmG49rplX9G3gS2N0I6hw" +
       "xFLlyGVaj6D6wfGTWAxOwLNXAZ+9ChO4F4OoMRDN7J/EcjRtoMAzliLPhIbG" +
       "T2IxNAGPUoWDmNzLSL1lN9Mnl4vO7B+ncjpQu+xdS5d3Q6PjJ7EYnW8F0Pk2" +
       "Jg8zspAbTiCbQ5fPJstItfvQKx7zWjrt1L15Ujzx2NEFlUuO7vpXfvAyd5q7" +
       "OkYqUxlZdp9Ccl2XazpNSZxptXkmiZ9/EL7HSEPw64OMlEn2S0fCd81axxlZ" +
       "6leLkRJI3aVPgDMqVBpKQuou+Q+w4HlLQvv8213uMdgKO+UYKTcv3EV+CNKh" +
       "CF4+odnLcg1flvGoV7N51Ctrvg6Ue4vZHkRSX2wQXS8+r857rZj/nwr2K8AZ" +
       "839ViCdOH725+0tT1x83j6YmZHFyEqXMjZEK8wAsF4qvEa/ylWbLKu9Y+8n8" +
       "x+dcbb9KnXc01t03bltg4vwY6TLPWU2jKXdk881jN5x5+f7yVwUSuZ1ERLDy" +
       "26cfistqGZ2svD1W6JDOblHnx0hbqt7Z+8pHv4rU8bOHxDzW0xBUI554+Mz5" +
       "3pSm/Y1A5nSCqSlJmuUn9rZNKH00MabnnfkpH+KvP3BWMTIfjV/E1944GQvo" +
       "vNxdPLXMSOP0I1DTT3JXyeo41fnLFShmnufF64ymuXM5WYxEyMYskgZbi8e6" +
       "NM06zFt2gpPXNJzdwk/xj+H/AwrD+484RQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tt8GAetiOimHZKM2rG3RUdSzgojWOAfF");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AAA=");
}
