package org.apache.batik.bridge;
public class SVGFilterElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.FilterBridge, org.apache.batik.bridge.ErrorConstants {
    protected static final java.awt.Color TRANSPARENT_BLACK = new java.awt.Color(
      0,
      true);
    public SVGFilterElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FILTER_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode) {
        java.awt.geom.Rectangle2D filterRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterChainRegion(
            filterElement,
            filteredElement,
            filteredNode,
            ctx);
        if (filterRegion ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter sourceGraphic =
          filteredNode.
          getGraphicsNodeRable(
            true);
        sourceGraphic =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            sourceGraphic,
            filterRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.FilterChainRable filterChain =
          new org.apache.batik.ext.awt.image.renderable.FilterChainRable8Bit(
          sourceGraphic,
          filterRegion);
        float[] filterRes =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterRes(
            filterElement,
            ctx);
        filterChain.
          setFilterResolutionX(
            (int)
              filterRes[0]);
        filterChain.
          setFilterResolutionY(
            (int)
              filterRes[1]);
        java.util.Map filterNodeMap =
          new java.util.HashMap(
          11);
        filterNodeMap.
          put(
            SVG_SOURCE_GRAPHIC_VALUE,
            sourceGraphic);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          buildFilterPrimitives(
            filterElement,
            filterRegion,
            filteredElement,
            filteredNode,
            sourceGraphic,
            filterNodeMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        else
            if (in ==
                  sourceGraphic) {
                in =
                  createEmptyFilter(
                    filterElement,
                    filterRegion,
                    filteredElement,
                    filteredNode,
                    ctx);
            }
        filterChain.
          setSource(
            in);
        return filterChain;
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createEmptyFilter(org.w3c.dom.Element filterElement,
                                                                                        java.awt.geom.Rectangle2D filterRegion,
                                                                                        org.w3c.dom.Element filteredElement,
                                                                                        org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                        org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            null,
            filterElement,
            filteredElement,
            filteredNode,
            filterRegion,
            filterRegion,
            ctx);
        return new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
          primitiveRegion,
          TRANSPARENT_BLACK);
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter buildFilterPrimitives(org.w3c.dom.Element filterElement,
                                                                                            java.awt.geom.Rectangle2D filterRegion,
                                                                                            org.w3c.dom.Element filteredElement,
                                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                            org.apache.batik.ext.awt.image.renderable.Filter in,
                                                                                            java.util.Map filterNodeMap,
                                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        java.util.List refs =
          new java.util.LinkedList(
          );
        for (;
             ;
             ) {
            org.apache.batik.ext.awt.image.renderable.Filter newIn =
              buildLocalFilterPrimitives(
                filterElement,
                filterRegion,
                filteredElement,
                filteredNode,
                in,
                filterNodeMap,
                ctx);
            if (newIn !=
                  in) {
                return newIn;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                filterElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return in;
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                filterElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL url =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURLObject(
                  ),
              uri);
            if (refs.
                  contains(
                    url)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              add(
                url);
            filterElement =
              ctx.
                getReferencedElement(
                  filterElement,
                  uri);
        }
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter buildLocalFilterPrimitives(org.w3c.dom.Element filterElement,
                                                                                                 java.awt.geom.Rectangle2D filterRegion,
                                                                                                 org.w3c.dom.Element filteredElement,
                                                                                                 org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                                 org.apache.batik.ext.awt.image.renderable.Filter in,
                                                                                                 java.util.Map filterNodeMap,
                                                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node n =
               filterElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                e);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.FilterPrimitiveBridge)) {
                continue;
            }
            org.apache.batik.bridge.FilterPrimitiveBridge filterBridge =
              (org.apache.batik.bridge.FilterPrimitiveBridge)
                bridge;
            org.apache.batik.ext.awt.image.renderable.Filter filterNode =
              filterBridge.
              createFilter(
                ctx,
                e,
                filteredElement,
                filteredNode,
                in,
                filterRegion,
                filterNodeMap);
            if (filterNode ==
                  null) {
                return null;
            }
            else {
                in =
                  filterNode;
            }
        }
        return in;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RGzAMGwcDv2Va94wuK+ewubR/wON1mnS+x0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mikAAA==");
}
