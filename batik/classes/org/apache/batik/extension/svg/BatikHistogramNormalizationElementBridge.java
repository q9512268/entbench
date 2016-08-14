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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Y+kT2RX2Soc//BsjzeqEox0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/MX9hu1KjrQYqtzuk5mbv9opzk6fvsP578nHFP/a+/qX/uFvhLcd4fH9x6F9" +
       "vIjkU+C6cRjaG+dDe2TrK06OnUZyOfZTpawfuUPmfqxoPgBWphJqcqztnVf0" +
       "/ehJYv7Ql5CYrys6nwbXRw+1/+jLSMyL4KHkh14MgqapRTd5yyS9uyS+u0yt" +
       "E1DhS9K9PosYusvYJ9+HShG/cgeX/EbR/HxcfhOUamHMG4d5+KsnLvmFl+OS" +
       "LIa+5ov9wKA4LX3tTV9G7b/mUT72wtV7X/PC/E/LM/bjL27uY6B714ltnz7c" +
       "OnV/yQ+1tVFadt/+qMsvf37nVtB0pq4ATgNtac5v73k+EUOP3J4HROv4/jTX" +
       "J2Po2nmuGLqn/D1N94cxdOWELoYu7W9Ok3wK6ARIits/8o/y/i23QyV8FcWh" +
       "rMS80Nsn9vGRzRmfZxdOFTyHGVxG+eEvFOVjltNn/cUyLz+BOypoEvYQTT7+" +
       "wmD8LZ/Dfmz/rYFiy3leSLmXgS7vP3s4LoqevK20I1mX+s98/sGfue/pI8B4" +
       "cK/wyWo6pdvjtz7YJx0/Lo/i819+zS+86cdf+KvydO//AMpjQHWbKAAA");
}
