package org.apache.batik.bridge;
public class SVGFeDisplacementMapElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeDisplacementMapElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DISPLACEMENT_MAP_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float scale =
          convertNumber(
            filterElement,
            SVG_SCALE_ATTRIBUTE,
            0,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel xChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_X_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel yChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_Y_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter in2 =
          getIn2(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in2 ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion;
        defaultRegion =
          (java.awt.geom.Rectangle2D)
            in.
            getBounds2D(
              ).
            clone(
              );
        defaultRegion.
          add(
            in2.
              getBounds2D(
                ));
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            pad);
        srcs.
          add(
            in2);
        org.apache.batik.ext.awt.image.renderable.Filter displacementMap =
          new org.apache.batik.ext.awt.image.renderable.DisplacementMapRable8Bit(
          srcs,
          scale,
          xChannelSelector,
          yChannelSelector);
        handleColorInterpolationFilters(
          displacementMap,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          displacementMap,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.ARGBChannel convertChannelSelector(org.w3c.dom.Element filterElement,
                                                                                       java.lang.String attrName,
                                                                                       org.apache.batik.ext.awt.image.ARGBChannel defaultChannel,
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
            return defaultChannel;
        }
        if (SVG_A_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     A;
        }
        if (SVG_R_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     R;
        }
        if (SVG_G_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     G;
        }
        if (SVG_B_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     B;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { attrName,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
