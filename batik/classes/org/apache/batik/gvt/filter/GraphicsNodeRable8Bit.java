package org.apache.batik.gvt.filter;
public class GraphicsNodeRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.gvt.filter.GraphicsNodeRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private java.awt.geom.AffineTransform cachedGn2dev = null;
    private java.awt.geom.AffineTransform cachedUsr2dev = null;
    private org.apache.batik.ext.awt.image.rendered.CachableRed cachedRed =
      null;
    private java.awt.geom.Rectangle2D cachedBounds = null;
    private boolean usePrimitivePaint = true;
    public boolean getUsePrimitivePaint() { return usePrimitivePaint; }
    public void setUsePrimitivePaint(boolean usePrimitivePaint) { this.usePrimitivePaint =
                                                                    usePrimitivePaint;
    }
    private org.apache.batik.gvt.GraphicsNode node;
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() {
        return node;
    }
    public void setGraphicsNode(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
    }
    public void clearCache() { cachedRed = null;
                               cachedUsr2dev = null;
                               cachedGn2dev = null;
                               cachedBounds = null; }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 java.util.Map props) { super(
                                                          (org.apache.batik.ext.awt.image.renderable.Filter)
                                                            null,
                                                          props);
                                                        if (node ==
                                                              null)
                                                            throw new java.lang.IllegalArgumentException(
                                                              );
                                                        this.
                                                          node =
                                                          node;
                                                        this.
                                                          usePrimitivePaint =
                                                          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 boolean usePrimitivePaint) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          usePrimitivePaint;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        if (usePrimitivePaint) {
            java.awt.geom.Rectangle2D primitiveBounds =
              node.
              getPrimitiveBounds(
                );
            if (primitiveBounds ==
                  null)
                return new java.awt.geom.Rectangle2D.Double(
                  0,
                  0,
                  0,
                  0);
            return (java.awt.geom.Rectangle2D)
                     primitiveBounds.
                     clone(
                       );
        }
        java.awt.geom.Rectangle2D bounds =
          node.
          getBounds(
            );
        if (bounds ==
              null) {
            return new java.awt.geom.Rectangle2D.Double(
              0,
              0,
              0,
              0);
        }
        java.awt.geom.AffineTransform at =
          node.
          getTransform(
            );
        if (at !=
              null) {
            bounds =
              at.
                createTransformedShape(
                  bounds).
                getBounds2D(
                  );
        }
        return bounds;
    }
    public boolean isDynamic() { return false;
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
        java.awt.color.ColorSpace g2dCS =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          getDestinationColorSpace(
            g2d);
        if (g2dCS ==
              null ||
              g2dCS !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB)) {
            return false;
        }
        org.apache.batik.gvt.GraphicsNode gn =
          getGraphicsNode(
            );
        if (getUsePrimitivePaint(
              )) {
            gn.
              primitivePaint(
                g2d);
        }
        else {
            gn.
              paint(
                g2d);
        }
        return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.AffineTransform usr2dev =
          renderContext.
          getTransform(
            );
        java.awt.geom.AffineTransform gn2dev;
        if (usr2dev ==
              null) {
            usr2dev =
              new java.awt.geom.AffineTransform(
                );
            gn2dev =
              usr2dev;
        }
        else {
            gn2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
        }
        java.awt.geom.AffineTransform gn2usr =
          node.
          getTransform(
            );
        if (gn2usr !=
              null) {
            gn2dev.
              concatenate(
                gn2usr);
        }
        java.awt.geom.Rectangle2D bounds2D =
          getBounds2D(
            );
        if (cachedBounds !=
              null &&
              cachedGn2dev !=
              null &&
              cachedBounds.
              equals(
                bounds2D) &&
              gn2dev.
              getScaleX(
                ) ==
              cachedGn2dev.
              getScaleX(
                ) &&
              gn2dev.
              getScaleY(
                ) ==
              cachedGn2dev.
              getScaleY(
                ) &&
              gn2dev.
              getShearX(
                ) ==
              cachedGn2dev.
              getShearX(
                ) &&
              gn2dev.
              getShearY(
                ) ==
              cachedGn2dev.
              getShearY(
                )) {
            double deltaX =
              usr2dev.
              getTranslateX(
                ) -
              cachedUsr2dev.
              getTranslateX(
                );
            double deltaY =
              usr2dev.
              getTranslateY(
                ) -
              cachedUsr2dev.
              getTranslateY(
                );
            if (deltaX ==
                  0 &&
                  deltaY ==
                  0)
                return cachedRed;
            if (deltaX ==
                  (int)
                    deltaX &&
                  deltaY ==
                  (int)
                    deltaY) {
                return new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                  cachedRed,
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinX(
                          ) +
                        deltaX),
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinY(
                          ) +
                        deltaY));
            }
        }
        if (false) {
            java.lang.System.
              out.
              println(
                "Not using Cached Red: " +
                usr2dev);
            java.lang.System.
              out.
              println(
                "Old:                  " +
                cachedUsr2dev);
        }
        if (bounds2D.
              getWidth(
                ) >
              0 &&
              bounds2D.
              getHeight(
                ) >
              0) {
            cachedUsr2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
            cachedGn2dev =
              gn2dev;
            cachedBounds =
              bounds2D;
            cachedRed =
              new org.apache.batik.gvt.filter.GraphicsNodeRed8Bit(
                node,
                usr2dev,
                usePrimitivePaint,
                renderContext.
                  getRenderingHints(
                    ));
            return cachedRed;
        }
        cachedUsr2dev =
          null;
        cachedGn2dev =
          null;
        cachedBounds =
          null;
        cachedRed =
          null;
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "K5TiZzXu/d35isduDnU+dzfe0f8CLVXqYigpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xknoCled/Tx5LMyHC9m9GyT8UJj42ZfP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("J+py/TfP79mr200O//7NTeq+VmS/EVfepqvx7Lov1k809Tdv+UD5X119oPwh" +
       "kKhDnNRbg/PcSYN52eD3bwL2D4rs6wBsdB2w131bnHqmcsKA330TDHjsSNDz" +
       "QwbM33pB/9eb1P1xkX0zrlwEgj5t7+VRxQnE//hmZVwctn3kEOJH3nIZ18oG" +
       "r98E57eL7M8BzuhanH94gvNbbxbnEyAZhziNt16Uf32Tuu8V2Xfiyj2yrUph" +
       "cbJ4Ft3/eBPoHi0KnwXpZw7R/cxbju7chZvU3Vtkt8eVe4Gi7s8m92ePnzqG" +
       "d+6ONwHv4SPhfeUQ3lfeeniP3KTu0SK7BBY8M+rtwDphlodLJ1723INvFtyT" +
       "IH31ENxX31ILPAoLHj4+JD6yMLhXgnvmJsCfK7IngNb6x5HCGeRPvgnk7ygK" +
       "3wPStw+Rf/v/CfJ3HyO/JgDiysfDm/8l4pvcGDyHFNnzwE3JIdhaq/vOpqsf" +
       "TfTEmYm4w4sEZPHrhGXVW7rHE1ceue6V4+L+5GPX/NNhfztf/qVXLt796Cuz" +
       "f1feuj2+QX+BrtytJbZ9+n7Lqec7/VDVzJKjF/a3XfwS9gfjyg/cJBKNi/8z" +
       "FA8F7eeu7Pt8CCzY1+sTV24D+emWnbhy6WzLuHJH+X26XR9o4Uk7MOn+4XQT" +
       "AowOmhSPpH8klNYbD4fxdRSHknwYEZ87FdQeqm7ppx/6fuI77nL6pm8xafn3" +
       "laOgNWEP7zh+6RVq/COvoz+3v2ks21KeF6PcTVfu2l96Pg58n7nhaEdj3Um8" +
       "97sPfPnCc0dB+gN7gk/M6BRt77z+td6+48flRdz81x79Zx/8x6/8UXnY/38A" +
       "qx+z5lc0AAA=");
}
