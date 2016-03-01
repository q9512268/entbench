package org.apache.batik.extension.svg;
public class BatikHistogramNormalizationElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikHistogramNormalizationElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_HISTOGRAM_NORMALIZATION_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikHistogramNormalizationElementBridge(
                                                            );
    }
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
        org.apache.batik.ext.awt.image.renderable.Filter sourceGraphics =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            filterMap.
            get(
              SVG_SOURCE_GRAPHIC_VALUE);
        java.awt.geom.Rectangle2D defaultRegion;
        if (in ==
              sourceGraphics) {
            defaultRegion =
              filterRegion;
        }
        else {
            defaultRegion =
              in.
                getBounds2D(
                  );
        }
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        float trim =
          1;
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            BATIK_EXT_TRIM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            try {
                trim =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { BATIK_EXT_TRIM_ATTRIBUTE,
                  s });
            }
        }
        if (trim <
              0)
            trim =
              0;
        else
            if (trim >
                  100)
                trim =
                  100;
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          in;
        filter =
          new org.apache.batik.extension.svg.BatikHistogramNormalizationFilter8Bit(
            filter,
            trim /
              100);
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
        handleColorInterpolationFilters(
          filter,
          filterElement);
        return filter;
    }
    protected static int convertSides(org.w3c.dom.Element filterElement,
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
            int ret =
              0;
            try {
                ret =
                  org.apache.batik.bridge.SVGUtilities.
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
            if (ret <
                  3)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            return ret;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Zqkr/TaLvKYxEniH8dB/APlIE1nuHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eB5eTj32PLicrAngvqAu7q+cxpP/BZ8L4Pqf4ircXXTs1+aH6cMC4YnjCiGK" +
       "sgtgtt6DHdQPkIL/raWUJ8v2etF89T5Mxe3XgGmdlOUt4Ji7geaVD35bClLM" +
       "M64fSZ+CchfE5PrCq5diXgMK/DKdCusP9jXiHtCKFitF7FOCuG36fP2eqly5" +
       "HjwR1gtBufl9f/u+P/iBN30axLQL3bMp/A1CeeqJg3VRgX/3S+9/9P4XPvN9" +
       "JUoBiBI+wFx7WyG1dyeLi4YpGvbI1EcKU6WySOhpSdovgcUyS2vvmMpC7PoA" +
       "fzeH5SX83MOfXn7o739mXzqez9tzxNbzL3zv/x6894WLpwr2N91UM5/m2Rft" +
       "pdKvOvRwDD15p6eUHOzfffy5X/vJ596z1+rhs+UnA35d/cyf/PcfHHzwM79/" +
       "iwrlbi/8EgKbPvi3XDXpUEefPqrO5e0ky+T5ECd1OycpMpv0TXuX2mbWpLVW" +
       "O6XEfrsvqLM2trXdpWHhaU5U5QYuT/F8QfRnDL9imybLU+GyM505LSTWbMbt" +
       "rFJeSOnmbKV2Rd/thuhQW0jyIh8RvC8N20K2QkO/XlMxDdYrWzdc8SuP0xoB" +
       "HiT1OolvYLPer/QzdNruhStmOfa6ttjhEkSnxnSjhSQ1Shumhk8r8o7GQ6dK" +
       "MhWuUcUbsc/DHDHDQjFo2CkT0bZq8RhDqBvJ8dWuyzDMKDHbrKFkK4ebJgqH" +
       "Up0uv2rwXHeZtkdoe9T1GDdoJ4NJyM5FsebIHUaaha5PD5Ftq9lH+MRcMhh4" +
       "Ll9H6FhiJ12wRnNL07FClfaxdX/namY9WzKoMsJoe0D3mclyOHKl1oDX0JQl" +
       "x+oM77alaZOjtSan8xKZUTFFpjsxaiHbzTRoEGTcq7Qdue2GtL1SpKqGm45I" +
       "iIxB19hVhFuDRVdo6xtxMG2O6Cqa082WzMUdsl3VBs0Kv/DiXZ9NsorgTaXd" +
       "WJ6tmX4qrSRdokfcxG97DIOLjqaG3ST3W86s61aS2mRrbtQ0nstGkBrzdrdC" +
       "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" +
       "ErG4in8oAAA=");
}
