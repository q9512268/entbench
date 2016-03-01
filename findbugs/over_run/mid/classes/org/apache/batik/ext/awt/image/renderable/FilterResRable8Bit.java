package org.apache.batik.ext.awt.image.renderable;
public class FilterResRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.ext.awt.image.renderable.FilterResRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private int filterResolutionX = -1;
    private int filterResolutionY = -1;
    public FilterResRable8Bit() { super(); }
    public FilterResRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                              int filterResX,
                              int filterResY) { super();
                                                init(src, null);
                                                setFilterResolutionX(
                                                  filterResX);
                                                setFilterResolutionY(
                                                  filterResY); }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 srcs.
                 get(
                   0);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public int getFilterResolutionX() { return filterResolutionX;
    }
    public void setFilterResolutionX(int filterResolutionX) {
        if (filterResolutionX <
              0) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        touch(
          );
        this.
          filterResolutionX =
          filterResolutionX;
    }
    public int getFilterResolutionY() { return filterResolutionY;
    }
    public void setFilterResolutionY(int filterResolutionY) {
        touch(
          );
        this.
          filterResolutionY =
          filterResolutionY;
    }
    public boolean allPaintRable(java.awt.image.renderable.RenderableImage ri) {
        if (!(ri instanceof org.apache.batik.ext.awt.image.renderable.PaintRable))
            return false;
        java.util.List v =
          ri.
          getSources(
            );
        if (v ==
              null)
            return true;
        java.util.Iterator i =
          v.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            java.awt.image.renderable.RenderableImage nri =
              (java.awt.image.renderable.RenderableImage)
                i.
                next(
                  );
            if (!allPaintRable(
                   nri))
                return false;
        }
        return true;
    }
    public boolean distributeAcross(java.awt.image.renderable.RenderableImage src,
                                    java.awt.Graphics2D g2d) {
        boolean ret;
        if (src instanceof org.apache.batik.ext.awt.image.renderable.PadRable) {
            org.apache.batik.ext.awt.image.renderable.PadRable pad =
              (org.apache.batik.ext.awt.image.renderable.PadRable)
                src;
            java.awt.Shape clip =
              g2d.
              getClip(
                );
            g2d.
              clip(
                pad.
                  getPadRect(
                    ));
            ret =
              distributeAcross(
                pad.
                  getSource(
                    ),
                g2d);
            g2d.
              setClip(
                clip);
            return ret;
        }
        if (src instanceof org.apache.batik.ext.awt.image.renderable.CompositeRable) {
            org.apache.batik.ext.awt.image.renderable.CompositeRable comp =
              (org.apache.batik.ext.awt.image.renderable.CompositeRable)
                src;
            if (comp.
                  getCompositeRule(
                    ) !=
                  org.apache.batik.ext.awt.image.CompositeRule.
                    OVER)
                return false;
            if (false) {
                java.awt.color.ColorSpace crCS =
                  comp.
                  getOperationColorSpace(
                    );
                java.awt.color.ColorSpace g2dCS =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                  getDestinationColorSpace(
                    g2d);
                if (g2dCS ==
                      null ||
                      g2dCS !=
                      crCS)
                    return false;
            }
            java.util.List v =
              comp.
              getSources(
                );
            if (v ==
                  null)
                return true;
            java.util.ListIterator li =
              v.
              listIterator(
                v.
                  size(
                    ));
            while (li.
                     hasPrevious(
                       )) {
                java.awt.image.renderable.RenderableImage csrc =
                  (java.awt.image.renderable.RenderableImage)
                    li.
                    previous(
                      );
                if (!allPaintRable(
                       csrc)) {
                    li.
                      next(
                        );
                    break;
                }
            }
            if (!li.
                  hasPrevious(
                    )) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g2d,
                    comp);
                return true;
            }
            if (!li.
                  hasNext(
                    ))
                return false;
            int idx =
              li.
              nextIndex(
                );
            org.apache.batik.ext.awt.image.renderable.Filter f =
              new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
              v.
                subList(
                  0,
                  idx),
              comp.
                getCompositeRule(
                  ),
              comp.
                isColorSpaceLinear(
                  ));
            f =
              new org.apache.batik.ext.awt.image.renderable.FilterResRable8Bit(
                f,
                getFilterResolutionX(
                  ),
                getFilterResolutionY(
                  ));
            org.apache.batik.ext.awt.image.GraphicsUtil.
              drawImage(
                g2d,
                f);
            while (li.
                     hasNext(
                       )) {
                org.apache.batik.ext.awt.image.renderable.PaintRable pr =
                  (org.apache.batik.ext.awt.image.renderable.PaintRable)
                    li.
                    next(
                      );
                if (!pr.
                      paintRable(
                        g2d)) {
                    org.apache.batik.ext.awt.image.renderable.Filter prf =
                      (org.apache.batik.ext.awt.image.renderable.Filter)
                        pr;
                    prf =
                      new org.apache.batik.ext.awt.image.renderable.FilterResRable8Bit(
                        prf,
                        getFilterResolutionX(
                          ),
                        getFilterResolutionY(
                          ));
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      drawImage(
                        g2d,
                        prf);
                }
            }
            return true;
        }
        return false;
    }
    public boolean paintRable(java.awt.Graphics2D g2d) {
        java.awt.Composite c =
          g2d.
          getComposite(
            );
        if (!org.apache.batik.ext.awt.image.SVGComposite.
               OVER.
              equals(
                c))
            return false;
        org.apache.batik.ext.awt.image.renderable.Filter src =
          getSource(
            );
        return distributeAcross(
                 src,
                 g2d);
    }
    java.lang.ref.Reference resRed = null;
    float resScale = 0;
    private float getResScale() { return resScale;
    }
    private java.awt.image.RenderedImage getResRed(java.awt.RenderingHints hints) {
        java.awt.geom.Rectangle2D imageRect =
          getBounds2D(
            );
        double resScaleX =
          getFilterResolutionX(
            ) /
          imageRect.
          getWidth(
            );
        double resScaleY =
          getFilterResolutionY(
            ) /
          imageRect.
          getHeight(
            );
        float resScale =
          (float)
            java.lang.Math.
            min(
              resScaleX,
              resScaleY);
        java.awt.image.RenderedImage ret;
        if (resScale ==
              this.
                resScale) {
            ret =
              (java.awt.image.RenderedImage)
                resRed.
                get(
                  );
            if (ret !=
                  null)
                return ret;
        }
        java.awt.geom.AffineTransform resUsr2Dev;
        resUsr2Dev =
          java.awt.geom.AffineTransform.
            getScaleInstance(
              resScale,
              resScale);
        java.awt.image.renderable.RenderContext newRC =
          new java.awt.image.renderable.RenderContext(
          resUsr2Dev,
          null,
          hints);
        ret =
          getSource(
            ).
            createRendering(
              newRC);
        ret =
          new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
            org.apache.batik.ext.awt.image.GraphicsUtil.
              wrap(
                ret));
        this.
          resScale =
          resScale;
        this.
          resRed =
          new java.lang.ref.SoftReference(
            ret);
        return ret;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.AffineTransform usr2dev =
          renderContext.
          getTransform(
            );
        if (usr2dev ==
              null) {
            usr2dev =
              new java.awt.geom.AffineTransform(
                );
        }
        java.awt.RenderingHints hints =
          renderContext.
          getRenderingHints(
            );
        int filterResolutionX =
          getFilterResolutionX(
            );
        int filterResolutionY =
          getFilterResolutionY(
            );
        if (filterResolutionX <=
              0 ||
              filterResolutionY ==
              0)
            return null;
        java.awt.geom.Rectangle2D imageRect =
          getBounds2D(
            );
        java.awt.Rectangle devRect;
        devRect =
          usr2dev.
            createTransformedShape(
              imageRect).
            getBounds(
              );
        float scaleX =
          1;
        if (filterResolutionX <
              devRect.
                width)
            scaleX =
              filterResolutionX /
                (float)
                  devRect.
                    width;
        float scaleY =
          1;
        if (filterResolutionY <
              0)
            scaleY =
              scaleX;
        else
            if (filterResolutionY <
                  devRect.
                    height)
                scaleY =
                  filterResolutionY /
                    (float)
                      devRect.
                        height;
        if (scaleX >=
              1 &&
              scaleY >=
              1)
            return getSource(
                     ).
              createRendering(
                renderContext);
        java.awt.image.RenderedImage resRed =
          getResRed(
            hints);
        float resScale =
          getResScale(
            );
        java.awt.geom.AffineTransform residualAT;
        residualAT =
          new java.awt.geom.AffineTransform(
            usr2dev.
              getScaleX(
                ) /
              resScale,
            usr2dev.
              getShearY(
                ) /
              resScale,
            usr2dev.
              getShearX(
                ) /
              resScale,
            usr2dev.
              getScaleY(
                ) /
              resScale,
            usr2dev.
              getTranslateX(
                ),
            usr2dev.
              getTranslateY(
                ));
        return new org.apache.batik.ext.awt.image.rendered.AffineRed(
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              resRed),
          residualAT,
          hints);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MOwXk0UjueYNAxNKaDN+ufo/61xvXeIpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "c3ttj/PX3qh1nwWXeohTve3W3W0Y/6tz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wP52XvwLADa4Bdhf3YP9zu0w6uYQ7Ob2G/U/nNP2e3nx78826uqUUX/ndhj1" +
       "k4c4P/n/yKg/PAfsf8uL759t1NUpo/7gDYB9KK98Clw/dwj2524r2KNR9Jli" +
       "C+zMUZM5viXzpoLb/zxHM3+SF38Ylu4XLGs/4p6V0C6LrmspgrPX1I/fqKZy" +
       "9/+lQ0390u3R1IXdhCV//OMjdT10rK6+L3i6IQW1wmUO7rm1Yg7yc04Hd4al" +
       "q7IRhL4hRqGCS76728195VgJB5feqBLyE0qvHCrhldsdGwf3FmAeOQfoo3nx" +
       "UFi6xzs2/ymIb34DEB88hHjw9l3f3e/rgci/Wpo7uHZO27vz4smwdC9Ic8zh" +
       "RntOl+zhPfUG4D166MYHTx7Ce/L2wDsV8A8fe/Auvg1HI4CxggJi5Rz4cF6U" +
       "d7MxZnfA45DlY6dyyI6xIhdpY6+c978B5RQnIt5byg+J7JQzuq3ufYTkPa+W" +
       "DQ//J6JQyEfOUVZ+DOfg2bB0RfIVIVSOVZ1XN/cq+cDrOkIWlh68+bB0fvLz" +
       "kZv+wWP3TwnS1168ctfDL85/uzgvfPyPA3ePSnepkWWdPFd14v6S5yuqUajr" +
       "7t0pK6/ANASjxWtec4X54uLoIYdyMNhxmYSlJ87nEpbuNI4856jXNCw9cqte" +
       "YekiKE9Sz8DwfBY1oATlSUoOZOXTlOD9xe9JOh7g2dOFpUu7m5MkHwPcAUl+" +
       "+3HvyKGQ175IxUUwOAjS4Tp155KPnIyGYqB88NU85rjLyZPR+UuL/xU6WkpG" +
       "9OH5q6+/OJh88kfNX9idzJYsIctyLneNSpd3h8QLpvly9B235HbE6xLxzE/e" +
       "9I27nz5aOr9pJ/A+Mk/I9uTZx6C7thcWB5ezv/fw3/7A33jxd4uTOP8HmnNG" +
       "N8Q1AAA=");
}
