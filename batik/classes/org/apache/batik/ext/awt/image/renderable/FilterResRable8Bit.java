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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "owYPONvyl6ho3zfyW7y76X9jeq9NIysAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BwhPfbWc+pZ2hPrvvgnUV/LKd4Pro/uo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("P3rnVfrNM9q+lRf/LC69BagUPfXT3BHOX3mz2n0WXMY+TuOOa3f3sflfnwH2" +
       "N/PiXwKw0W3A/vIR2G/fCaWu9sGu7rxS/+MZbb+TF//hdKWKJ5T6W3dCqZ/c" +
       "x/nJPyal/uAMsP89L753ulLFE0r9/psA+1Be+RS4fnof7E/fUbAHq+gzxeez" +
       "U1fNyeEtkTcV1P7XGZL5o7z4H3Hpftlxjlbc0wLaJcX3HV32jiT1ozcrqdz8" +
       "f2FfUr9wZyR1bpew5I9/eCCuhw7FhYVysLDUqFaYzN7l2wtmLz8jtXchLl3V" +
       "rCgOLSWJ9a4a+rsvwa8eCmHv4psVQn666dV9Ibx6p31j794CzCNnAH00Lx6K" +
       "S5eDQ/WfgPiWNwHx2j7EvXfsxu5+3whE6bXC3N71M9rekxdPxqV7QZib7H+k" +
       "z/tlR/CeehPwHt03470n9+E9eWfgnXD4hw8teOfflmfiQFlRAbFyBvxGXpR3" +
       "2dhkdzhkn+RjJ2LIjrCuFWHjSDgfeBPCKU5TvK+UHzDZCYe6o+Z9gOS9rxUN" +
       "9/9nohDIR84QVn6EZ+/ZuHRFDXU51g9FnVe3jkTywTd0/CwuXbv1oHV+avSR" +
       "W/4BZPdPC+pXX7py98Mv8b9ZnDU+/MeCe6jS3UbiOMfPZB27vxiEumEV4rpn" +
       "d0IrKDANwWrxuvdccb65OHjIoeyROyp0XHribCpx6YJ1YDkHo8Zx6ZHbjYpL" +
       "50F5vPcULM+n9QY9QXm85wxE5ZM9wfzF7/F+EsBz1C8uXdzdHO/yMUAddMlv" +
       "Px4cGBT8+jepXQUsDrK6v0/dmeQjx72hWCivvZbFHA45fqo6n7T4X6KDrWTC" +
       "7p/d+tpLJP3JH7Z+bneqW3Xk7TancjdVurQ7YF4Qzbej77wttQNaF/FnfvzA" +
       "1+95+mDr/MCO4SPPPMbbk6cfoUbcIC4OPW///sN/54N/46XfLk7x/F9uqI58" +
       "5DUAAA==");
}
