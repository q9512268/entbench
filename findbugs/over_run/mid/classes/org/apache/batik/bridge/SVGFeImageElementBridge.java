package org.apache.batik.bridge;
public class SVGFeImageElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeImageElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_IMAGE_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        java.lang.String uriStr =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            filterElement);
        if (uriStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        org.w3c.dom.Document document =
          filterElement.
          getOwnerDocument(
            );
        boolean isUse =
          uriStr.
          indexOf(
            '#') !=
          -1;
        org.w3c.dom.Element contentElement =
          null;
        if (isUse) {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_USE_TAG);
        }
        else {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_IMAGE_TAG);
        }
        contentElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            uriStr);
        org.w3c.dom.Element proxyElement =
          document.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_G_TAG);
        proxyElement.
          appendChild(
            contentElement);
        java.awt.geom.Rectangle2D defaultRegion =
          filterRegion;
        org.w3c.dom.Element filterDefElement =
          (org.w3c.dom.Element)
            filterElement.
            getParentNode(
              );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          getBaseFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            ctx);
        contentElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getX(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getY(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getWidth(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getHeight(
                    )));
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            proxyElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            filterDefElement,
            null,
            SVG_PRIMITIVE_UNITS_ATTRIBUTE,
            ctx);
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
                  filterDefElement,
                  SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            at =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  at,
                  filteredNode);
        }
        filter =
          new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
            filter,
            at);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        java.awt.geom.Rectangle2D primitiveRegionUserSpace =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegionUserSpace,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createSVGFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                       java.awt.geom.Rectangle2D primitiveRegion,
                                                                                       org.w3c.dom.Element refElement,
                                                                                       boolean toBBoxNeeded,
                                                                                       org.w3c.dom.Element filterElement,
                                                                                       org.apache.batik.gvt.GraphicsNode filteredNode) {
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            refElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (toBBoxNeeded) {
            short coordSystemType;
            org.w3c.dom.Element filterDefElement =
              (org.w3c.dom.Element)
                filterElement.
                getParentNode(
                  );
            java.lang.String s =
              org.apache.batik.bridge.SVGUtilities.
              getChainableAttributeNS(
                filterDefElement,
                null,
                SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                ctx);
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
                      filterDefElement,
                      SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                      s,
                      ctx);
            }
            if (coordSystemType ==
                  org.apache.batik.bridge.SVGUtilities.
                    OBJECT_BOUNDING_BOX) {
                at =
                  org.apache.batik.bridge.SVGUtilities.
                    toObjectBBox(
                      at,
                      filteredNode);
            }
            java.awt.geom.Rectangle2D bounds =
              filteredNode.
              getGeometryBounds(
                );
            at.
              preConcatenate(
                java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    primitiveRegion.
                      getX(
                        ) -
                      bounds.
                      getX(
                        ),
                    primitiveRegion.
                      getY(
                        ) -
                      bounds.
                      getY(
                        )));
        }
        else {
            at.
              translate(
                primitiveRegion.
                  getX(
                    ),
                primitiveRegion.
                  getY(
                    ));
        }
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          at);
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createRasterFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                          java.awt.geom.Rectangle2D primitiveRegion,
                                                                                          org.apache.batik.util.ParsedURL purl) {
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
          getRegistry(
            ).
          readURL(
            purl);
        java.awt.geom.Rectangle2D bounds =
          filter.
          getBounds2D(
            );
        java.awt.geom.AffineTransform scale =
          new java.awt.geom.AffineTransform(
          );
        scale.
          translate(
            primitiveRegion.
              getX(
                ),
            primitiveRegion.
              getY(
                ));
        scale.
          scale(
            primitiveRegion.
              getWidth(
                ) /
              (bounds.
                 getWidth(
                   ) -
                 1),
            primitiveRegion.
              getHeight(
                ) /
              (bounds.
                 getHeight(
                   ) -
                 1));
        scale.
          translate(
            -bounds.
              getX(
                ),
            -bounds.
              getY(
                ));
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          scale);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/jt7MnNnDds99VZid2O/f39n9/3kBFit15Z3sJ1iNv5NOZcH8vJCVvz81k1Z" +
       "9RfAsg7ztBSM0E1XsvOJH49AiNnKhT3uY5CmAp9csGwsZ/NKkJjn4ZRpv7PN" +
       "7baAlpXlnMU2JNArhs/rtlT5znXzATPWA2nie/7p/V9730PfAj7tQNeuMnsD" +
       "Vx6asRtnmfO7nv/gPTc8/e335CgFIKr/oeb5xzOu7NU0zopmVlB7qt6Vqcrn" +
       "mz4rhRGXA4um5tpeNZT7gekA/F3tpoXwE7d+a/GR73xqm/Idj9tjxNpTT//6" +
       "T3be+/TJQ4n2Q5fkuofHbJPtXOibdi0cQA9cbZZ8BPXPLzzxJ5944t1bqW49" +
       "mjY2wVvRp/7qv76288y3v3KZTOQa2/sZHBvd/BstJGzjex9uPNXFtZAkot6r" +
       "1GQjreED2FiXG8aSZB2yuSC60mAxJdtSGqtLXPT7C6cby70NHGJ8FVPg2RyZ" +
       "t80O35A83hzYTYkaz+kiwbcTabGSBVxEpYhbePNhw0unOiu1uq2iI7U9AaYD" +
       "zZR135mt1LJcqFnmcFnqFCphJdzIXbivFWqVVaqkM6dqcV2KYK1ImJIRUe9Z" +
       "TXKqT9XEm3Wm8yLTDcuR0IiH5Ar2q30sqZSmao3pb3Rr6OOdldq0Zh2/uBGc" +
       "rtOfhfGSl5vLptxrLRpW0BxJbX6aNEb0uIsJ6mgmc8GSjzedbjdmBWm6bs3C" +
       "OYXX/YgfeBubic01RXHFTk1dNAvihpCwNYHxlNAuu9XJUictZt1rSUi540fF" +
       "xOL8pbGK1h6HOAyzaRppp+OU+nTZHAamjTURn8Y3wy6OxQI6m1pdTxRRzJyj" +
       "4zSaY4rekixL9k1uPBatSpNPbdSUuMXcbI9HQYlBJ3yXVQysSvOLjmcs4ikA" +
       "6UFfNAYNo0J4rFS35iNONztDobboWbOIlIWKHYcDZ0hRYIK2Sqdzfzlw0960" +
       "R/NOMEutmIwmXFqKgnndt5ACwxqhCGsTWCOb9ki2yr4dTevdIdLpCA1z0UoS" +
       "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" +
       "Bb34pyYAAA==");
}
