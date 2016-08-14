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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W2juI/joy4Zj6jcU1ElDPdRc+/DoPLMYev6Y4Mnb2K130SEZgJdNUw1ZV9NL" +
       "oX76Hob9WNF8BBhWDXQ50vf5dMy/ehv/IriLLWvTloHUge5oelAcMB2emVg6" +
       "4ye/DWe8pej8PnD9+JEzfvw1OOOguO2WcHZHj1zep+w5O37nyVb8WgemBqUW" +
       "SJG1pddLRHy+aH62aD5acvzn9zDnp4vmkwA89+YkbC/K9qYpBj5+ap9Pfbv2" +
       "qYHrpSP7vPR3aJ+rJdXVE8X/xXkTfPzcfvR5rJvKSQmgt9R/N/nalz6Vv/Ly" +
       "frtZkUM9gip3+87o9k+dirPrp+5x/n76Bcqfke9+9Y//h/CDxxD9uhMj1Qub" +
       "FGdAnzky0mcuGunY+68/PfZj5HLs86fOfuUezv7lovlsBL1RiU1L27v5ZG8+" +
       "vODwn/82HH696HwaXF8+0uXLf58OL9rPncjyzHFyfuVIlq/cSZbPXzDjv7+H" +
       "GX+9aL4QQY+XZizR/VvY8ldfiy3TCHrszl+FFEfcb77tG7T9d1PqL754/YE3" +
       "vTj/g/LDiJNvmx6koQdWsWWdPZE8c3/FC/SVWWr14P580it//lMEveku0B9B" +
       "V5TT8uWLe/r/EkE3LtJH0OXy9yzd70bQtVM6wGp/c5bk9yPoPkBS3P6Bdxzy" +
       "9bs9hzAHIHtUIHp5immqwHJ7Y6WXzlQ8RxFaOuPRb+WMkylnv6wokrr8SvC4" +
       "oom5I+x45cUh+8PfaH56/2WHasl5XnB5gIau7j8yOamKnrwrt2NeV6inv/nw" +
       "5x586hgeHt4LfJotZ2R7250/oyghvPjwIf/lN/2b7/+XL/5heRL5ty5/dh++" +
       "KQAA");
}
