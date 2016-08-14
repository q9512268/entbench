package org.apache.batik.bridge;
public class SVGFeBlendElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeBlendElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_BLEND_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.CompositeRule rule =
          convertMode(
            filterElement,
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
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            in2);
        srcs.
          add(
            in);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
          srcs,
          rule,
          true);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.CompositeRule convertMode(org.w3c.dom.Element filterElement,
                                                                              org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String rule =
          filterElement.
          getAttributeNS(
            null,
            SVG_MODE_ATTRIBUTE);
        if (rule.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_NORMAL_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_MULTIPLY_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     MULTIPLY;
        }
        if (SVG_SCREEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     SCREEN;
        }
        if (SVG_DARKEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     DARKEN;
        }
        if (SVG_LIGHTEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     LIGHTEN;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_MODE_ATTRIBUTE,
          rule });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "efGKzQv/BvSA34SaGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YPpHd/3BGz/57LfyO4X/BeKhK2bJJAAA");
}
