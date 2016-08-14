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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gkSnmP2CeMXmxX8Dn2QIW64ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
