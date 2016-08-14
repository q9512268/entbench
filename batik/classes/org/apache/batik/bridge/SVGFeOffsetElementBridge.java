package org.apache.batik.bridge;
public class SVGFeOffsetElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeOffsetElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_OFFSET_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
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
        float dx =
          convertNumber(
            filterElement,
            SVG_DX_ATTRIBUTE,
            0,
            ctx);
        float dy =
          convertNumber(
            filterElement,
            SVG_DY_ATTRIBUTE,
            0,
            ctx);
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            dx,
            dy);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          pad,
          at);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/sqa5/4F8I8AFTgYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Rab0D+/+/Tf+1nPfyO+t/wcDTWhWMCMAAA==");
}
