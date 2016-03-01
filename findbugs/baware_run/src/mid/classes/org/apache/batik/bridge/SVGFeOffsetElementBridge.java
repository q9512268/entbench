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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wAfc84bBU/cMax7/N3i3ybe3FwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
