package org.apache.batik.bridge;
public class SVGFeDiffuseLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeDiffuseLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DIFFUSE_LIGHTING_TAG;
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
        float diffuseConstant =
          convertNumber(
            filterElement,
            SVG_DIFFUSE_CONSTANT_ATTRIBUTE,
            1,
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
          new org.apache.batik.ext.awt.image.renderable.DiffuseLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          diffuseConstant,
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "m0kC17jnDYMf3jOsefLf3PeigtQXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
