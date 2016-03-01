package org.apache.batik.bridge;
public class SVGFeSpecularLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeSpecularLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_SPECULAR_LIGHTING_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float surfaceScale =
          convertNumber(
            filterElement,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1,
            ctx);
        float specularConstant =
          convertNumber(
            filterElement,
            SVG_SPECULAR_CONSTANT_ATTRIBUTE,
            1,
            ctx);
        float specularExponent =
          convertSpecularExponent(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.Light light =
          extractLight(
            filterElement,
            ctx);
        double[] kernelUnitLength =
          convertKernelUnitLength(
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
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.SpecularLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          specularConstant,
          specularExponent,
          surfaceScale,
          kernelUnitLength);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float convertSpecularExponent(org.w3c.dom.Element filterElement,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return 1;
        }
        else {
            try {
                float v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
                if (v <
                      1 ||
                      v >
                      128) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                      s });
                }
                return v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
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
       "d/LLif8FiMDEb08lAAA=");
}
