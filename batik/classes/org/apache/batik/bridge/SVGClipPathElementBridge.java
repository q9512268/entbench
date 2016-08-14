package org.apache.batik.bridge;
public class SVGClipPathElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.ClipBridge {
    public SVGClipPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_CLIP_PATH_TAG; }
    public org.apache.batik.ext.awt.image.renderable.ClipRable createClip(org.apache.batik.bridge.BridgeContext ctx,
                                                                          org.w3c.dom.Element clipElement,
                                                                          org.w3c.dom.Element clipedElement,
                                                                          org.apache.batik.gvt.GraphicsNode clipedNode) {
        java.lang.String s;
        java.awt.geom.AffineTransform Tx;
        s =
          clipElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                convertTransform(
                  clipElement,
                  SVG_TRANSFORM_ATTRIBUTE,
                  s,
                  ctx);
        }
        else {
            Tx =
              new java.awt.geom.AffineTransform(
                );
        }
        short coordSystemType;
        s =
          clipElement.
            getAttributeNS(
              null,
              SVG_CLIP_PATH_UNITS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                USER_SPACE_ON_USE;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  clipElement,
                  SVG_CLIP_PATH_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  Tx,
                  clipedNode);
        }
        java.awt.geom.Area clipPath =
          new java.awt.geom.Area(
          );
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node node =
               clipElement.
               getFirstChild(
                 );
             node !=
               null;
             node =
               node.
                 getNextSibling(
                   )) {
            if (node.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element child =
              (org.w3c.dom.Element)
                node;
            org.apache.batik.gvt.GraphicsNode clipNode =
              builder.
              build(
                ctx,
                child);
            if (clipNode ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            if (child instanceof org.apache.batik.dom.svg.SVGOMUseElement) {
                org.w3c.dom.Node shadowChild =
                  ((org.apache.batik.dom.svg.SVGOMUseElement)
                     child).
                  getCSSFirstChild(
                    );
                if (shadowChild !=
                      null &&
                      shadowChild.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    child =
                      (org.w3c.dom.Element)
                        shadowChild;
                }
            }
            int wr =
              org.apache.batik.bridge.CSSUtilities.
              convertClipRule(
                child);
            java.awt.geom.GeneralPath path =
              new java.awt.geom.GeneralPath(
              clipNode.
                getOutline(
                  ));
            path.
              setWindingRule(
                wr);
            java.awt.geom.AffineTransform at =
              clipNode.
              getTransform(
                );
            if (at ==
                  null)
                at =
                  Tx;
            else
                at.
                  preConcatenate(
                    Tx);
            java.awt.Shape outline =
              at.
              createTransformedShape(
                path);
            org.apache.batik.gvt.ShapeNode outlineNode =
              new org.apache.batik.gvt.ShapeNode(
              );
            outlineNode.
              setShape(
                outline);
            org.apache.batik.ext.awt.image.renderable.ClipRable clip =
              org.apache.batik.bridge.CSSUtilities.
              convertClipPath(
                child,
                outlineNode,
                ctx);
            if (clip !=
                  null) {
                java.awt.geom.Area area =
                  new java.awt.geom.Area(
                  outline);
                area.
                  subtract(
                    new java.awt.geom.Area(
                      clip.
                        getClipPath(
                          )));
                outline =
                  area;
            }
            clipPath.
              add(
                new java.awt.geom.Area(
                  outline));
        }
        if (!hasChildren) {
            return null;
        }
        org.apache.batik.gvt.ShapeNode clipPathNode =
          new org.apache.batik.gvt.ShapeNode(
          );
        clipPathNode.
          setShape(
            clipPath);
        org.apache.batik.ext.awt.image.renderable.ClipRable clipElementClipPath =
          org.apache.batik.bridge.CSSUtilities.
          convertClipPath(
            clipElement,
            clipPathNode,
            ctx);
        if (clipElementClipPath !=
              null) {
            clipPath.
              subtract(
                new java.awt.geom.Area(
                  clipElementClipPath.
                    getClipPath(
                      )));
        }
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          clipedNode.
          getFilter(
            );
        if (filter ==
              null) {
            filter =
              clipedNode.
                getGraphicsNodeRable(
                  true);
        }
        boolean useAA =
          false;
        java.awt.RenderingHints hints;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertShapeRendering(
              clipElement,
              null);
        if (hints !=
              null) {
            java.lang.Object o =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_ANTIALIASING);
            useAA =
              o ==
                java.awt.RenderingHints.
                  VALUE_ANTIALIAS_ON;
        }
        return new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
          filter,
          clipPath,
          useAA);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Yv+roovNs/8B8wjYZ3kVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IQAA");
}
