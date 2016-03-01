package org.apache.batik.bridge;
public abstract class AbstractSVGFilterPrimitiveElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.FilterPrimitiveBridge, org.apache.batik.bridge.ErrorConstants {
    protected AbstractSVGFilterPrimitiveElementBridge() { super(); }
    protected static org.apache.batik.ext.awt.image.renderable.Filter getIn(org.w3c.dom.Element filterElement,
                                                                            org.w3c.dom.Element filteredElement,
                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                            org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                            java.util.Map filterMap,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_IN_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return inputFilter;
        }
        else {
            return getFilterSource(
                     filterElement,
                     s,
                     filteredElement,
                     filteredNode,
                     filterMap,
                     ctx);
        }
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter getIn2(org.w3c.dom.Element filterElement,
                                                                             org.w3c.dom.Element filteredElement,
                                                                             org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                             org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                             java.util.Map filterMap,
                                                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_IN2_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_IN2_ATTRIBUTE });
        }
        return getFilterSource(
                 filterElement,
                 s,
                 filteredElement,
                 filteredNode,
                 filterMap,
                 ctx);
    }
    protected static void updateFilterMap(org.w3c.dom.Element filterElement,
                                          org.apache.batik.ext.awt.image.renderable.Filter filter,
                                          java.util.Map filterMap) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_RESULT_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0 &&
              s.
              trim(
                ).
              length(
                ) !=
              0) {
            filterMap.
              put(
                s,
                filter);
        }
    }
    protected static void handleColorInterpolationFilters(org.apache.batik.ext.awt.image.renderable.Filter filter,
                                                          org.w3c.dom.Element filterElement) {
        if (filter instanceof org.apache.batik.ext.awt.image.renderable.FilterColorInterpolation) {
            boolean isLinear =
              org.apache.batik.bridge.CSSUtilities.
              convertColorInterpolationFilters(
                filterElement);
            ((org.apache.batik.ext.awt.image.renderable.FilterColorInterpolation)
               filter).
              setColorSpaceLinear(
                isLinear);
        }
    }
    static org.apache.batik.ext.awt.image.renderable.Filter getFilterSource(org.w3c.dom.Element filterElement,
                                                                            java.lang.String s,
                                                                            org.w3c.dom.Element filteredElement,
                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                            java.util.Map filterMap,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.ext.awt.image.renderable.Filter srcG =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            filterMap.
            get(
              SVG_SOURCE_GRAPHIC_VALUE);
        java.awt.geom.Rectangle2D filterRegion =
          srcG.
          getBounds2D(
            );
        int length =
          s.
          length(
            );
        org.apache.batik.ext.awt.image.renderable.Filter source =
          null;
        switch (length) {
            case 13:
                if (SVG_SOURCE_GRAPHIC_VALUE.
                      equals(
                        s)) {
                    source =
                      srcG;
                }
                break;
            case 11:
                if (s.
                      charAt(
                        1) ==
                      SVG_SOURCE_ALPHA_VALUE.
                      charAt(
                        1)) {
                    if (SVG_SOURCE_ALPHA_VALUE.
                          equals(
                            s)) {
                        source =
                          srcG;
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FilterAlphaRable(
                            source);
                    }
                }
                else
                    if (SVG_STROKE_PAINT_VALUE.
                          equals(
                            s)) {
                        java.awt.Paint paint =
                          org.apache.batik.bridge.PaintServer.
                          convertStrokePaint(
                            filteredElement,
                            filteredNode,
                            ctx);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
                            filterRegion,
                            paint);
                    }
                break;
            case 15:
                if (s.
                      charAt(
                        10) ==
                      SVG_BACKGROUND_IMAGE_VALUE.
                      charAt(
                        10)) {
                    if (SVG_BACKGROUND_IMAGE_VALUE.
                          equals(
                            s)) {
                        source =
                          new org.apache.batik.gvt.filter.BackgroundRable8Bit(
                            filteredNode);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
                            source,
                            filterRegion,
                            org.apache.batik.ext.awt.image.PadMode.
                              ZERO_PAD);
                    }
                }
                else
                    if (SVG_BACKGROUND_ALPHA_VALUE.
                          equals(
                            s)) {
                        source =
                          new org.apache.batik.gvt.filter.BackgroundRable8Bit(
                            filteredNode);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FilterAlphaRable(
                            source);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
                            source,
                            filterRegion,
                            org.apache.batik.ext.awt.image.PadMode.
                              ZERO_PAD);
                    }
                break;
            case 9:
                if (SVG_FILL_PAINT_VALUE.
                      equals(
                        s)) {
                    java.awt.Paint paint =
                      org.apache.batik.bridge.PaintServer.
                      convertFillPaint(
                        filteredElement,
                        filteredNode,
                        ctx);
                    if (paint ==
                          null) {
                        paint =
                          new java.awt.Color(
                            0,
                            0,
                            0,
                            0);
                    }
                    source =
                      new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
                        filterRegion,
                        paint);
                }
                break;
        }
        if (source ==
              null) {
            source =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                filterMap.
                get(
                  s);
        }
        return source;
    }
    static final java.awt.geom.Rectangle2D
      INFINITE_FILTER_REGION =
      new java.awt.geom.Rectangle2D.Float(
      -java.lang.Float.
         MAX_VALUE /
        2,
      -java.lang.Float.
         MAX_VALUE /
        2,
      java.lang.Float.
        MAX_VALUE,
      java.lang.Float.
        MAX_VALUE);
    protected static int convertInteger(org.w3c.dom.Element filterElement,
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
            try {
                return org.apache.batik.bridge.SVGUtilities.
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
        }
    }
    protected static float convertNumber(org.w3c.dom.Element filterElement,
                                         java.lang.String attrName,
                                         float defaultValue,
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
            try {
                return org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
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
      ("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" +
       "8yCR5/CuN79/+OdvPTZ6Z5XIAGYXhzDfvEnHe9TY1W9+nCdkDl4FshPf/IHw" +
       "vtsnty15j893UQRnn53JjzqAs+7cBXtTHwabK58IkqoBUi/b+fJqSU2jbw5A" +
       "jmg5STTk1DnjufmeSG5asyg51Y9gnmX9+OVGO3hHanwf64OsBsd937dd+R0/" +
       "ZAUIf1nBp8zi7Wxs5nIVBhmptHhCzmB1RZNUH0zUOzwL8AY3jXR3RLojq9qj" +
       "HZHOVe190b72FZGebs5iEiNncMuShlkoSfUU5I8ynDSp0gWXCCDFdjE2K8Wq" +
       "Fxay2UzxnRvpmIo7r5bskO9unv/VOWmX8+vFONeOg85+5xVLKXx5hEggnFmz" +
       "is1qN03dzN620P/PLJaG8yvEnqt3jsR77povXKUxN7Vth5vbvX/59E+hXUee" +
       "LpAN1TDdmKfSIap6DlYFS87Ic9AufktxrX3xC6Nlh2+eNCY/XUFO04okI3OK" +
       "e7J/gSev/ufkVUsG132JPOQsn6D8LH/Zte/pFbPkm4P8oiWcK++CljupNdel" +
       "ak0KN0ptVY5jNWftZyqaywx4ltj2s6RwLlDYNvF1HjaX+dzp9BIcffGpkrOq" +
       "dKxsPFrZ8EI5FAdPshNZHEo5BDPyzDA5xEIrTMkYVGSrG1ToUJ6XR4kqRDdV" +
       "UnCnDEFKBaEHI7Rt+BgkvGaENZf+NPhcnzTMTTgq/6j52u3nVB1bJGx3ekFq" +
       "z6Vz4eiiuul779EEeUth5rnXzTe3PHOH/rf3gs5VstAUQXmZ1fX8IyvfjnJ7" +
       "q0aDzmrZY8zLzKQnC6zPzQIRV4/YeuK/jKw/pZcmYJIKM8ATiBKrlBSN2yp1" +
       "rmhf4WoITFPyUMJV7YOP/GLxjrnfukMIfkYRv3fpH778yKHdm/fvEyiF4mfk" +
       "3GL1qfyiGN4SZpa46bhG9OGKCw+++9bqK4N2FjcOm0zGMfOxbl4DSRN2bss6" +
       "VyCbwDT5DUnwrpy/+z9X/eDlHriEREh1WlM2pmkkngshVVY65rEstxDjAopt" +
       "Vp/DXwCez/BBc8IOYVaNbXZRYnq2KmEYGRxnJDDHMLLHmVkszIhoZBfU+Kpq" +
       "iVT3h9gkINonKYvwO8hGNw4nS8Th/NwRO5by7lgubjbDs9b2nrWnDDeLcSyM" +
       "mxwbsw0v0mzEZhibHXwXt5UQ0y5sboIcg4tpgU9OPz5pOU3AISwPbbFPtemU" +
       "yWlTEY6+05ZxVmVZEQnp8GXvLCGYu7DZDTedtBEHYxUBAvzLKpncZ1Mn4V3h" +
       "rY2vb7j9nXsFpPgzeR8x3bHzhs9DN+4UeCKKsWfn1UO9c0RBVjggNtdmLC9w" +
       "FViFz+h4e//W392z9ToHT9YyUj6kK3FX7yOnRu+98Nxga+n6U6b364tw9Ckz" +
       "6LLiKk/xFR8qofKHsfk1JFiDAJX82o41HVA7SJQncnaWgGR7XWE9cNLCasQh" +
       "TMJG7KONfAlhBQrJqbYEsxI44mBwPQ8peLULiVJ+LsB4sOXxEvJ8CpsD4EKA" +
       "LUJ0/Txw+0DmsZOW3xk4dA48x+0jHz9lxlaMo+/Y5ZxVeVZMT1jFsj2f0+9v" +
       "Gt34eNXmSxxfHLL9GH/u9rz/ipEyxf6W5Qns+O81GVcdL5ZQx2FsnmVkHFzk" +
       "h6jJ0LSTolLwZ1cbz520Nqbg0Ndgc02Cg/g9FdooyvGE2sD2peKirUiounRC" +
       "4f6jhHCPYnOE8SoJCrc7jV/7sPNtV7ZvfHnZZhg55wsW+jE0Tcr7Sim+rMn3" +
       "jdRVTxy54q+82Jz9+jUG7g2JtKp6SzCe90rDpAmFn2+MKMgY/OffjEwskqVB" +
       "JhFzqwb/EvSjgCh+ehA6//XSHWek1qUDVuLFS/Ip+AGQ4OtnhgNXC4p+IoH7" +
       "gMTwhseTTkUGEQphZQKe+oFde+E6mnAiHWWneKvVmAjw78iOu6d77VvC/pFL" +
       "u7ccW3SXqJbLqrR5M3I5DdJqUbjP1gJmFOXm8KpcOfuTcffXzHTAokFs2HWn" +
       "KR6LXAoWbKBNTPbVka2WbDn5lT0XHXh2R+ULkHKsIQEJbt9r8qt6GSMN9+I1" +
       "nYUuEKslk5e4W2vfWvf8x68GGnnxlIgrx7RSM6LyLQcO9yYM42dBUhMhFZCX" +
       "0AwvOV6ySeuj8pCZcx+pjOlpLfvJeRwasISBiUvGFujYbC9+bWGkOT95yv8C" +
       "Vavqw9RcjtyRzVhf9SRtGN5RLtnvC/BASYM1Rju7DMO+5wQu55I3DHTeAFfP" +
       "Nf8DhJUQISwiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PP4v8Ngf2BaVf3aA409fCRxZXHnny7zc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("VVxTeeMNN1P3tymVX33+8j1veJ7/o/J+0+mNx3vpyj164jhnbxWceb8UhJpu" +
       "lZLdu79jEJRf/zOuvOEWSz5Yi+RDEv3Snv5bceXKeXoAbPl9lu6v48p9Bzow" +
       "1P7lLMl3gHkCkuL1b4KT/KN+y2txHkjP4iItK28lWAqAcA9WduFM3n1sdaV2" +
       "Hvpu2jntcvaCVJF8lXeHT/LqZHKc433h+RHz9EvtX9hf0FIcKc+LUe6hK3fv" +
       "74qd5uaP3XK0k7EuDd71nQe+eO8TJ2ncA3uGDx5whre33vwqFO4GcXl5Kf/N" +
       "N/z6D/3i839S3iL4v3wLsh/ULQAA");
}
