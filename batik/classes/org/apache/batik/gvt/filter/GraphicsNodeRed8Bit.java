package org.apache.batik.gvt.filter;
public class GraphicsNodeRed8Bit extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private org.apache.batik.gvt.GraphicsNode node;
    private java.awt.geom.AffineTransform node2dev;
    private java.awt.RenderingHints hints;
    private boolean usePrimitivePaint;
    public GraphicsNodeRed8Bit(org.apache.batik.gvt.GraphicsNode node, java.awt.geom.AffineTransform node2dev,
                               boolean usePrimitivePaint,
                               java.awt.RenderingHints hints) { super(
                                                                  );
                                                                this.
                                                                  node =
                                                                  node;
                                                                this.
                                                                  node2dev =
                                                                  node2dev;
                                                                this.
                                                                  hints =
                                                                  hints;
                                                                this.
                                                                  usePrimitivePaint =
                                                                  usePrimitivePaint;
                                                                java.awt.geom.AffineTransform at =
                                                                  node2dev;
                                                                java.awt.geom.Rectangle2D bounds2D =
                                                                  node.
                                                                  getPrimitiveBounds(
                                                                    );
                                                                if (bounds2D ==
                                                                      null)
                                                                    bounds2D =
                                                                      new java.awt.geom.Rectangle2D.Float(
                                                                        0,
                                                                        0,
                                                                        1,
                                                                        1);
                                                                if (!usePrimitivePaint) {
                                                                    java.awt.geom.AffineTransform nodeAt =
                                                                      node.
                                                                      getTransform(
                                                                        );
                                                                    if (nodeAt !=
                                                                          null) {
                                                                        at =
                                                                          (java.awt.geom.AffineTransform)
                                                                            at.
                                                                            clone(
                                                                              );
                                                                        at.
                                                                          concatenate(
                                                                            nodeAt);
                                                                    }
                                                                }
                                                                java.awt.Rectangle bounds =
                                                                  at.
                                                                  createTransformedShape(
                                                                    bounds2D).
                                                                  getBounds(
                                                                    );
                                                                java.awt.image.ColorModel cm =
                                                                  createColorModel(
                                                                    );
                                                                int defSz =
                                                                  org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
                                                                  getDefaultTileSize(
                                                                    );
                                                                int tgX =
                                                                  defSz *
                                                                  (int)
                                                                    java.lang.Math.
                                                                    floor(
                                                                      bounds.
                                                                        x /
                                                                        defSz);
                                                                int tgY =
                                                                  defSz *
                                                                  (int)
                                                                    java.lang.Math.
                                                                    floor(
                                                                      bounds.
                                                                        y /
                                                                        defSz);
                                                                int tw =
                                                                  bounds.
                                                                    x +
                                                                  bounds.
                                                                    width -
                                                                  tgX;
                                                                if (tw >
                                                                      defSz)
                                                                    tw =
                                                                      defSz;
                                                                int th =
                                                                  bounds.
                                                                    y +
                                                                  bounds.
                                                                    height -
                                                                  tgY;
                                                                if (th >
                                                                      defSz)
                                                                    th =
                                                                      defSz;
                                                                if (tw <=
                                                                      0 ||
                                                                      th <=
                                                                      0) {
                                                                    tw =
                                                                      1;
                                                                    th =
                                                                      1;
                                                                }
                                                                java.awt.image.SampleModel sm =
                                                                  cm.
                                                                  createCompatibleSampleModel(
                                                                    tw,
                                                                    th);
                                                                init(
                                                                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                                    null,
                                                                  bounds,
                                                                  cm,
                                                                  sm,
                                                                  tgX,
                                                                  tgY,
                                                                  null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        genRect(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        java.awt.image.BufferedImage offScreen =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            offScreen,
            hints);
        g.
          setComposite(
            java.awt.AlphaComposite.
              Clear);
        g.
          fillRect(
            0,
            0,
            wr.
              getWidth(
                ),
            wr.
              getHeight(
                ));
        g.
          setComposite(
            java.awt.AlphaComposite.
              SrcOver);
        g.
          translate(
            -wr.
              getMinX(
                ),
            -wr.
              getMinY(
                ));
        g.
          transform(
            node2dev);
        if (usePrimitivePaint) {
            node.
              primitivePaint(
                g);
        }
        else {
            node.
              paint(
                g);
        }
        g.
          dispose(
            );
    }
    static final boolean onMacOSX;
    static { onMacOSX = "Mac OS X".equals(
                                     java.lang.System.
                                       getProperty(
                                         "os.name"));
    }
    public java.awt.image.ColorModel createColorModel() {
        if (onMacOSX)
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     sRGB_Pre;
        return org.apache.batik.ext.awt.image.GraphicsUtil.
                 sRGB_Unpre;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "K7g/EK/YfPhvFDLP7fUcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "t+Xp5+78gzf9ztPfyM/D/w/tdjVH9icAAA==");
}
