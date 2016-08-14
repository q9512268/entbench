package org.apache.batik.bridge;
public class SVGBridgeExtension implements org.apache.batik.bridge.BridgeExtension {
    public float getPriority() { return 0.0F; }
    public java.util.Iterator getImplementedExtensions() { return java.util.Collections.
                                                                    EMPTY_LIST.
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() { return "The Apache Batik Team.";
    }
    public java.lang.String getContactAddress() { return "batik-dev@xmlgraphics.apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "The required SVG 1.0 tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAltGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGCircleElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGClipPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGColorProfileElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGDescElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGEllipseElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeBlendElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeColorMatrixElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeCompositeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeConvolveMatrixElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeDiffuseLightingElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeDisplacementMapElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFeDistantLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeFloodElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeGaussianBlurElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMergeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMergeElementBridge.SVGFeMergeNodeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMorphologyElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeOffsetElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFePointLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeSpecularLightingElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFeSpotLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeTileElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeTurbulenceElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFontElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFontFaceElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFilterElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGHKernElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGLineElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGLinearGradientElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMarkerElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMaskElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMissingGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPatternElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPolylineElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPolygonElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGRadialGradientElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGRectElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGGradientElementBridge.SVGStopElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSVGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSwitchElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTextPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTitleElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGUseElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGVKernElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSetElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateColorElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateTransformElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateMotionElementBridge(
              ));
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        java.lang.String ns =
          e.
          getNamespaceURI(
            );
        if (!org.apache.batik.util.SVGConstants.
               SVG_NAMESPACE_URI.
              equals(
                ns)) {
            return false;
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        if (ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SCRIPT_TAG) ||
              ln.
              startsWith(
                "animate") ||
              ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SET_TAG)) {
            return true;
        }
        return false;
    }
    public SVGBridgeExtension() { super();
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
       "If+Z1/zkV/7I839ZnqL+H3hJo0CHKQAA");
}
