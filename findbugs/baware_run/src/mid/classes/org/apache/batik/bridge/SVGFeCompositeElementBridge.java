package org.apache.batik.bridge;
public class SVGFeCompositeElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeCompositeElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COMPOSITE_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.CompositeRule rule =
          convertOperator(
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
    protected static org.apache.batik.ext.awt.image.CompositeRule convertOperator(org.w3c.dom.Element filterElement,
                                                                                  org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_OPERATOR_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_ATOP_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     ATOP;
        }
        if (SVG_IN_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     IN;
        }
        if (SVG_OVER_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_OUT_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OUT;
        }
        if (SVG_XOR_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     XOR;
        }
        if (SVG_ARITHMETIC_VALUE.
              equals(
                s)) {
            float k1 =
              convertNumber(
                filterElement,
                SVG_K1_ATTRIBUTE,
                0,
                ctx);
            float k2 =
              convertNumber(
                filterElement,
                SVG_K2_ATTRIBUTE,
                0,
                ctx);
            float k3 =
              convertNumber(
                filterElement,
                SVG_K3_ATTRIBUTE,
                0,
                ctx);
            float k4 =
              convertNumber(
                filterElement,
                SVG_K4_ATTRIBUTE,
                0,
                ctx);
            return org.apache.batik.ext.awt.image.CompositeRule.
              ARITHMETIC(
                k1,
                k2,
                k3,
                k4);
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_OPERATOR_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KDp0RXjeMMTp/R42j/0L9IOEPRsZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
