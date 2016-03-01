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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IC043lu1+ZqYcMwqsPJEHpTyMA7UeNAwCXbR1BPZDzVBWS4q5typqaORICuS" +
       "60z6Y89tVrjxoOCuODkuYBOfEGhQX6ktjrNkWxuTvbHOoHLiLMgOXRS7lRYa" +
       "GhTZknG7b7KtakmoDtVW3e9DxvbMwzR5ypKT3ABGr9GoNb2ashkPNbsqBt2N" +
       "STfmm6jWCO1ip97mhhbdbbldtp9ja3K+PxmU+naDSXjDwTuES29afKvZGJoi" +
       "Hgw4uojaBuVz5b5POkJnoFDamnQjk5i7lZEeFPFe2xRrpXyvNoxVelYtlmSY" +
       "y/lpJEyc7sgx6C6jMKuIbtthTi1JWre8tGd0VG124X6YrYTcRuqs13a9ux4x" +
       "LMk1cTCYEbK+AlLHLecwTQcdOsd5kdlW7EF3OTJJmh56E6+54IMG3yA42aGa" +
       "GMUO+/0kPybWvFfTS6Izb87LBRNXki5uxj6W10eeFaGmZ609olZiVmrkTBqF" +
       "gjtmxs1cxbam1MI09ciM9Y1Al/AKoUz7VmfZnJs1pjrr1+v8IJwncW+V8wgq" +
       "sVblkPGqg+6ErKNdVOsmruaqLOeRAinCPcnKDarphjNq0FUFjEo6YoPQ6VDC" +
       "67xGywFZ92Y9Xh4aaGEVj2PSGG/mQ6vRWZdXkWCuSvOSHHuLUGeZBDCUWdaB" +
       "EFRsWQM9K+6Wp65aW7itomKvw5YP66kFhE+rPQh1s7QM/AapDVZUZJIldool" +
       "ObE+yOdAuRTWc1yrCEyTbFYxMJ+UWobur2KxFElsPhcaGx4vNyRvbTKbDkNV" +
       "edG1eqU1XWuKbmu4GJBjYeEPI6k76WJdojcyAGVbZc6dhKVcwUlm63qkEUMO" +
       "btwK8BZipOoNA7WIUbWnVkPB6LluERd5x0DrbMWzVNTyHW1W9muEhqt0orR0" +
       "qyblcVRfyKgVLyi/XZNbslKnOhuphZVmsyZoSe2yE82E+mrkioxT0+tlt9Fy" +
       "uOK6uNmAlejwoVjmzVnCuOU+F/Kb/MYuEn7c020a6PO4q4XrRkCRRZmvzJfG" +
       "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");
}
