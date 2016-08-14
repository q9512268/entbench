package org.apache.batik.bridge;
public class SVGMaskElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.MaskBridge {
    public SVGMaskElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_MASK_TAG; }
    public org.apache.batik.gvt.filter.Mask createMask(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.w3c.dom.Element maskElement,
                                                       org.w3c.dom.Element maskedElement,
                                                       org.apache.batik.gvt.GraphicsNode maskedNode) {
        java.lang.String s;
        java.awt.geom.Rectangle2D maskRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertMaskRegion(
            maskElement,
            maskedElement,
            maskedNode,
            ctx);
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.CompositeGraphicsNode maskNode =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        org.apache.batik.gvt.CompositeGraphicsNode maskNodeContent =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        maskNode.
          getChildren(
            ).
          add(
            maskNodeContent);
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node node =
               maskElement.
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
            org.apache.batik.gvt.GraphicsNode gn =
              builder.
              build(
                ctx,
                child);
            if (gn ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            maskNodeContent.
              getChildren(
                ).
              add(
                gn);
        }
        if (!hasChildren) {
            return null;
        }
        java.awt.geom.AffineTransform Tx;
        s =
          maskElement.
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
                  maskElement,
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
          maskElement.
            getAttributeNS(
              null,
              SVG_MASK_CONTENT_UNITS_ATTRIBUTE);
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
                  maskElement,
                  SVG_MASK_CONTENT_UNITS_ATTRIBUTE,
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
                  maskedNode);
        }
        maskNodeContent.
          setTransform(
            Tx);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          maskedNode.
          getFilter(
            );
        if (filter ==
              null) {
            filter =
              maskedNode.
                getGraphicsNodeRable(
                  true);
        }
        return new org.apache.batik.gvt.filter.MaskRable8Bit(
          filter,
          maskNode,
          maskRegion);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eO/vv+G3nv9Gfub4P52O+MHgIAAA");
}
