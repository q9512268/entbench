package org.apache.batik.bridge;
public abstract class AbstractSVGFilterPrimitiveElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.FilterPrimitiveBridge, org.apache.batik.bridge.ErrorConstants {
    protected AbstractSVGFilterPrimitiveElementBridge() { super(); }
    protected static org.apache.batik.ext.awt.image.renderable.Filter getIn(org.w3c.dom.Element filterElement,
                                                                            org.w3c.dom.Element filteredElement,
                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                            org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                            java.util.Map filterMap,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_IN_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return inputFilter;
        }
        else {
            return getFilterSource(
                     filterElement,
                     s,
                     filteredElement,
                     filteredNode,
                     filterMap,
                     ctx);
        }
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter getIn2(org.w3c.dom.Element filterElement,
                                                                             org.w3c.dom.Element filteredElement,
                                                                             org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                             org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                             java.util.Map filterMap,
                                                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_IN2_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_IN2_ATTRIBUTE });
        }
        return getFilterSource(
                 filterElement,
                 s,
                 filteredElement,
                 filteredNode,
                 filterMap,
                 ctx);
    }
    protected static void updateFilterMap(org.w3c.dom.Element filterElement,
                                          org.apache.batik.ext.awt.image.renderable.Filter filter,
                                          java.util.Map filterMap) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_RESULT_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0 &&
              s.
              trim(
                ).
              length(
                ) !=
              0) {
            filterMap.
              put(
                s,
                filter);
        }
    }
    protected static void handleColorInterpolationFilters(org.apache.batik.ext.awt.image.renderable.Filter filter,
                                                          org.w3c.dom.Element filterElement) {
        if (filter instanceof org.apache.batik.ext.awt.image.renderable.FilterColorInterpolation) {
            boolean isLinear =
              org.apache.batik.bridge.CSSUtilities.
              convertColorInterpolationFilters(
                filterElement);
            ((org.apache.batik.ext.awt.image.renderable.FilterColorInterpolation)
               filter).
              setColorSpaceLinear(
                isLinear);
        }
    }
    static org.apache.batik.ext.awt.image.renderable.Filter getFilterSource(org.w3c.dom.Element filterElement,
                                                                            java.lang.String s,
                                                                            org.w3c.dom.Element filteredElement,
                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                            java.util.Map filterMap,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.ext.awt.image.renderable.Filter srcG =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            filterMap.
            get(
              SVG_SOURCE_GRAPHIC_VALUE);
        java.awt.geom.Rectangle2D filterRegion =
          srcG.
          getBounds2D(
            );
        int length =
          s.
          length(
            );
        org.apache.batik.ext.awt.image.renderable.Filter source =
          null;
        switch (length) {
            case 13:
                if (SVG_SOURCE_GRAPHIC_VALUE.
                      equals(
                        s)) {
                    source =
                      srcG;
                }
                break;
            case 11:
                if (s.
                      charAt(
                        1) ==
                      SVG_SOURCE_ALPHA_VALUE.
                      charAt(
                        1)) {
                    if (SVG_SOURCE_ALPHA_VALUE.
                          equals(
                            s)) {
                        source =
                          srcG;
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FilterAlphaRable(
                            source);
                    }
                }
                else
                    if (SVG_STROKE_PAINT_VALUE.
                          equals(
                            s)) {
                        java.awt.Paint paint =
                          org.apache.batik.bridge.PaintServer.
                          convertStrokePaint(
                            filteredElement,
                            filteredNode,
                            ctx);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
                            filterRegion,
                            paint);
                    }
                break;
            case 15:
                if (s.
                      charAt(
                        10) ==
                      SVG_BACKGROUND_IMAGE_VALUE.
                      charAt(
                        10)) {
                    if (SVG_BACKGROUND_IMAGE_VALUE.
                          equals(
                            s)) {
                        source =
                          new org.apache.batik.gvt.filter.BackgroundRable8Bit(
                            filteredNode);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
                            source,
                            filterRegion,
                            org.apache.batik.ext.awt.image.PadMode.
                              ZERO_PAD);
                    }
                }
                else
                    if (SVG_BACKGROUND_ALPHA_VALUE.
                          equals(
                            s)) {
                        source =
                          new org.apache.batik.gvt.filter.BackgroundRable8Bit(
                            filteredNode);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FilterAlphaRable(
                            source);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
                            source,
                            filterRegion,
                            org.apache.batik.ext.awt.image.PadMode.
                              ZERO_PAD);
                    }
                break;
            case 9:
                if (SVG_FILL_PAINT_VALUE.
                      equals(
                        s)) {
                    java.awt.Paint paint =
                      org.apache.batik.bridge.PaintServer.
                      convertFillPaint(
                        filteredElement,
                        filteredNode,
                        ctx);
                    if (paint ==
                          null) {
                        paint =
                          new java.awt.Color(
                            0,
                            0,
                            0,
                            0);
                    }
                    source =
                      new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
                        filterRegion,
                        paint);
                }
                break;
        }
        if (source ==
              null) {
            source =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                filterMap.
                get(
                  s);
        }
        return source;
    }
    static final java.awt.geom.Rectangle2D
      INFINITE_FILTER_REGION =
      new java.awt.geom.Rectangle2D.Float(
      -java.lang.Float.
         MAX_VALUE /
        2,
      -java.lang.Float.
         MAX_VALUE /
        2,
      java.lang.Float.
        MAX_VALUE,
      java.lang.Float.
        MAX_VALUE);
    protected static int convertInteger(org.w3c.dom.Element filterElement,
                                        java.lang.String attrName,
                                        int defaultValue,
                                        org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultValue;
        }
        else {
            try {
                return org.apache.batik.bridge.SVGUtilities.
                  convertSVGInteger(
                    s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            }
        }
    }
    protected static float convertNumber(org.w3c.dom.Element filterElement,
                                         java.lang.String attrName,
                                         float defaultValue,
                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultValue;
        }
        else {
            try {
                return org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s,
                  nfEx });
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ASMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f/+/ROMu1fbEM3j899vg8fWi+C9xeWWg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wGN/yFtU/tkBjj99JXBkMfTOl3khrLja8sYbbqzub1lKv/b85Xve8Pz8j8o7" +
       "Uac3Ie+loXvUxLbP3kQ4837JDxXVKCW7d38vwS+//mcMveEWSz5YizaHJPql" +
       "Pf03Y+jKeXoAbPl9lu5bMXTfgQ4MtX85S/IdYJ6ApHj9a/8k/0BveZXOBelZ" +
       "XKRl5U0GQwIQ7sHKLpzJu4+trtTOQ99NO6ddzl6qKpKv8k7xSV6dsMc53uef" +
       "HzJPv9T8xf2lLskW87wY5R4aunt/v+w0N3/slqOdjHVp8K7vPPCFe584SeMe" +
       "2DN88IAzvL315tencMePywtP+W++4R//0C89/yflzYP/CzrmL2zsLQAA");
}
