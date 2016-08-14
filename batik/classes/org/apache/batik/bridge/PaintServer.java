package org.apache.batik.bridge;
public abstract class PaintServer implements org.apache.batik.util.SVGConstants, org.apache.batik.util.CSSConstants, org.apache.batik.bridge.ErrorConstants {
    protected PaintServer() { super(); }
    public static org.apache.batik.gvt.ShapePainter convertMarkers(org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode node,
                                                                   org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v;
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                MARKER_START_INDEX);
        org.apache.batik.gvt.Marker startMarker =
          convertMarker(
            e,
            v,
            ctx);
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                MARKER_MID_INDEX);
        org.apache.batik.gvt.Marker midMarker =
          convertMarker(
            e,
            v,
            ctx);
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                MARKER_END_INDEX);
        org.apache.batik.gvt.Marker endMarker =
          convertMarker(
            e,
            v,
            ctx);
        if (startMarker !=
              null ||
              midMarker !=
              null ||
              endMarker !=
              null) {
            org.apache.batik.gvt.MarkerShapePainter p =
              new org.apache.batik.gvt.MarkerShapePainter(
              node.
                getShape(
                  ));
            p.
              setStartMarker(
                startMarker);
            p.
              setMiddleMarker(
                midMarker);
            p.
              setEndMarker(
                endMarker);
            return p;
        }
        else {
            return null;
        }
    }
    public static org.apache.batik.gvt.Marker convertMarker(org.w3c.dom.Element e,
                                                            org.apache.batik.css.engine.value.Value v,
                                                            org.apache.batik.bridge.BridgeContext ctx) {
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            return null;
        }
        else {
            java.lang.String uri =
              v.
              getStringValue(
                );
            org.w3c.dom.Element markerElement =
              ctx.
              getReferencedElement(
                e,
                uri);
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                markerElement);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.MarkerBridge)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_CSS_URI_BAD_TARGET,
                  new java.lang.Object[] { uri });
            }
            return ((org.apache.batik.bridge.MarkerBridge)
                      bridge).
              createMarker(
                ctx,
                markerElement,
                e);
        }
    }
    public static org.apache.batik.gvt.ShapePainter convertFillAndStroke(org.w3c.dom.Element e,
                                                                         org.apache.batik.gvt.ShapeNode node,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.Shape shape =
          node.
          getShape(
            );
        if (shape ==
              null)
            return null;
        java.awt.Paint fillPaint =
          convertFillPaint(
            e,
            node,
            ctx);
        org.apache.batik.gvt.FillShapePainter fp =
          new org.apache.batik.gvt.FillShapePainter(
          shape);
        fp.
          setPaint(
            fillPaint);
        java.awt.Stroke stroke =
          convertStroke(
            e);
        if (stroke ==
              null)
            return fp;
        java.awt.Paint strokePaint =
          convertStrokePaint(
            e,
            node,
            ctx);
        org.apache.batik.gvt.StrokeShapePainter sp =
          new org.apache.batik.gvt.StrokeShapePainter(
          shape);
        sp.
          setStroke(
            stroke);
        sp.
          setPaint(
            strokePaint);
        org.apache.batik.gvt.CompositeShapePainter cp =
          new org.apache.batik.gvt.CompositeShapePainter(
          shape);
        cp.
          addShapePainter(
            fp);
        cp.
          addShapePainter(
            sp);
        return cp;
    }
    public static org.apache.batik.gvt.ShapePainter convertStrokePainter(org.w3c.dom.Element e,
                                                                         org.apache.batik.gvt.ShapeNode node,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.Shape shape =
          node.
          getShape(
            );
        if (shape ==
              null)
            return null;
        java.awt.Stroke stroke =
          convertStroke(
            e);
        if (stroke ==
              null)
            return null;
        java.awt.Paint strokePaint =
          convertStrokePaint(
            e,
            node,
            ctx);
        org.apache.batik.gvt.StrokeShapePainter sp =
          new org.apache.batik.gvt.StrokeShapePainter(
          shape);
        sp.
          setStroke(
            stroke);
        sp.
          setPaint(
            strokePaint);
        return sp;
    }
    public static java.awt.Paint convertStrokePaint(org.w3c.dom.Element strokedElement,
                                                    org.apache.batik.gvt.GraphicsNode strokedNode,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            strokedElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              STROKE_OPACITY_INDEX);
        float opacity =
          convertOpacity(
            v);
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              strokedElement,
              org.apache.batik.css.engine.SVGCSSEngine.
                STROKE_INDEX);
        return convertPaint(
                 strokedElement,
                 strokedNode,
                 v,
                 opacity,
                 ctx);
    }
    public static java.awt.Paint convertFillPaint(org.w3c.dom.Element filledElement,
                                                  org.apache.batik.gvt.GraphicsNode filledNode,
                                                  org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            filledElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              FILL_OPACITY_INDEX);
        float opacity =
          convertOpacity(
            v);
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              filledElement,
              org.apache.batik.css.engine.SVGCSSEngine.
                FILL_INDEX);
        return convertPaint(
                 filledElement,
                 filledNode,
                 v,
                 opacity,
                 ctx);
    }
    public static java.awt.Paint convertPaint(org.w3c.dom.Element paintedElement,
                                              org.apache.batik.gvt.GraphicsNode paintedNode,
                                              org.apache.batik.css.engine.value.Value paintDef,
                                              float opacity,
                                              org.apache.batik.bridge.BridgeContext ctx) {
        if (paintDef.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            switch (paintDef.
                      getPrimitiveType(
                        )) {
                case org.w3c.dom.css.CSSPrimitiveValue.
                       CSS_IDENT:
                    return null;
                case org.w3c.dom.css.CSSPrimitiveValue.
                       CSS_RGBCOLOR:
                    return convertColor(
                             paintDef,
                             opacity);
                case org.w3c.dom.css.CSSPrimitiveValue.
                       CSS_URI:
                    return convertURIPaint(
                             paintedElement,
                             paintedNode,
                             paintDef,
                             opacity,
                             ctx);
                default:
                    throw new java.lang.IllegalArgumentException(
                      "Paint argument is not an appropriate CSS value");
            }
        }
        else {
            org.apache.batik.css.engine.value.Value v =
              paintDef.
              item(
                0);
            switch (v.
                      getPrimitiveType(
                        )) {
                case org.w3c.dom.css.CSSPrimitiveValue.
                       CSS_RGBCOLOR:
                    return convertRGBICCColor(
                             paintedElement,
                             v,
                             (org.apache.batik.css.engine.value.svg.ICCColor)
                               paintDef.
                               item(
                                 1),
                             opacity,
                             ctx);
                case org.w3c.dom.css.CSSPrimitiveValue.
                       CSS_URI:
                    {
                        java.awt.Paint result =
                          silentConvertURIPaint(
                            paintedElement,
                            paintedNode,
                            v,
                            opacity,
                            ctx);
                        if (result !=
                              null)
                            return result;
                        v =
                          paintDef.
                            item(
                              1);
                        switch (v.
                                  getPrimitiveType(
                                    )) {
                            case org.w3c.dom.css.CSSPrimitiveValue.
                                   CSS_IDENT:
                                return null;
                            case org.w3c.dom.css.CSSPrimitiveValue.
                                   CSS_RGBCOLOR:
                                if (paintDef.
                                      getLength(
                                        ) ==
                                      2) {
                                    return convertColor(
                                             v,
                                             opacity);
                                }
                                else {
                                    return convertRGBICCColor(
                                             paintedElement,
                                             v,
                                             (org.apache.batik.css.engine.value.svg.ICCColor)
                                               paintDef.
                                               item(
                                                 2),
                                             opacity,
                                             ctx);
                                }
                            default:
                                throw new java.lang.IllegalArgumentException(
                                  "Paint argument is not an appropriate CSS value");
                        }
                    }
                default:
                    throw new java.lang.IllegalArgumentException(
                      "Paint argument is not an appropriate CSS value");
            }
        }
    }
    public static java.awt.Paint silentConvertURIPaint(org.w3c.dom.Element paintedElement,
                                                       org.apache.batik.gvt.GraphicsNode paintedNode,
                                                       org.apache.batik.css.engine.value.Value paintDef,
                                                       float opacity,
                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.Paint paint =
          null;
        try {
            paint =
              convertURIPaint(
                paintedElement,
                paintedNode,
                paintDef,
                opacity,
                ctx);
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            
        }
        return paint;
    }
    public static java.awt.Paint convertURIPaint(org.w3c.dom.Element paintedElement,
                                                 org.apache.batik.gvt.GraphicsNode paintedNode,
                                                 org.apache.batik.css.engine.value.Value paintDef,
                                                 float opacity,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String uri =
          paintDef.
          getStringValue(
            );
        org.w3c.dom.Element paintElement =
          ctx.
          getReferencedElement(
            paintedElement,
            uri);
        org.apache.batik.bridge.Bridge bridge =
          ctx.
          getBridge(
            paintElement);
        if (bridge ==
              null ||
              !(bridge instanceof org.apache.batik.bridge.PaintBridge)) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              paintedElement,
              ERR_CSS_URI_BAD_TARGET,
              new java.lang.Object[] { uri });
        }
        return ((org.apache.batik.bridge.PaintBridge)
                  bridge).
          createPaint(
            ctx,
            paintElement,
            paintedElement,
            paintedNode,
            opacity);
    }
    public static java.awt.Color convertRGBICCColor(org.w3c.dom.Element paintedElement,
                                                    org.apache.batik.css.engine.value.Value colorDef,
                                                    org.apache.batik.css.engine.value.svg.ICCColor iccColor,
                                                    float opacity,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.Color color =
          null;
        if (iccColor !=
              null) {
            color =
              convertICCColor(
                paintedElement,
                iccColor,
                opacity,
                ctx);
        }
        if (color ==
              null) {
            color =
              convertColor(
                colorDef,
                opacity);
        }
        return color;
    }
    public static java.awt.Color convertICCColor(org.w3c.dom.Element e,
                                                 org.apache.batik.css.engine.value.svg.ICCColor c,
                                                 float opacity,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String iccProfileName =
          c.
          getColorProfile(
            );
        if (iccProfileName ==
              null) {
            return null;
        }
        org.apache.batik.bridge.SVGColorProfileElementBridge profileBridge =
          (org.apache.batik.bridge.SVGColorProfileElementBridge)
            ctx.
            getBridge(
              SVG_NAMESPACE_URI,
              SVG_COLOR_PROFILE_TAG);
        if (profileBridge ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.color.ICCColorSpaceExt profileCS =
          profileBridge.
          createICCColorSpaceExt(
            ctx,
            e,
            iccProfileName);
        if (profileCS ==
              null) {
            return null;
        }
        int n =
          c.
          getNumberOfColors(
            );
        float[] colorValue =
          new float[n];
        if (n ==
              0) {
            return null;
        }
        for (int i =
               0;
             i <
               n;
             i++) {
            colorValue[i] =
              c.
                getColor(
                  i);
        }
        float[] rgb =
          profileCS.
          intendedToRGB(
            colorValue);
        return new java.awt.Color(
          rgb[0],
          rgb[1],
          rgb[2],
          opacity);
    }
    public static java.awt.Color convertColor(org.apache.batik.css.engine.value.Value c,
                                              float opacity) {
        int r =
          resolveColorComponent(
            c.
              getRed(
                ));
        int g =
          resolveColorComponent(
            c.
              getGreen(
                ));
        int b =
          resolveColorComponent(
            c.
              getBlue(
                ));
        return new java.awt.Color(
          r,
          g,
          b,
          java.lang.Math.
            round(
              opacity *
                255.0F));
    }
    public static java.awt.Stroke convertStroke(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v;
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                STROKE_WIDTH_INDEX);
        float width =
          v.
          getFloatValue(
            );
        if (width ==
              0.0F)
            return null;
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                STROKE_LINECAP_INDEX);
        int linecap =
          convertStrokeLinecap(
            v);
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                STROKE_LINEJOIN_INDEX);
        int linejoin =
          convertStrokeLinejoin(
            v);
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                STROKE_MITERLIMIT_INDEX);
        float miterlimit =
          convertStrokeMiterlimit(
            v);
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              e,
              org.apache.batik.css.engine.SVGCSSEngine.
                STROKE_DASHARRAY_INDEX);
        float[] dasharray =
          convertStrokeDasharray(
            v);
        float dashoffset =
          0;
        if (dasharray !=
              null) {
            v =
              org.apache.batik.bridge.CSSUtilities.
                getComputedStyle(
                  e,
                  org.apache.batik.css.engine.SVGCSSEngine.
                    STROKE_DASHOFFSET_INDEX);
            dashoffset =
              v.
                getFloatValue(
                  );
            if (dashoffset <
                  0) {
                float dashpatternlength =
                  0;
                for (int i =
                       0;
                     i <
                       dasharray.
                         length;
                     i++) {
                    dashpatternlength +=
                      dasharray[i];
                }
                if (dasharray.
                      length %
                      2 !=
                      0)
                    dashpatternlength *=
                      2;
                if (dashpatternlength ==
                      0) {
                    dashoffset =
                      0;
                }
                else {
                    while (dashoffset <
                             0)
                        dashoffset +=
                          dashpatternlength;
                }
            }
        }
        return new java.awt.BasicStroke(
          width,
          linecap,
          linejoin,
          miterlimit,
          dasharray,
          dashoffset);
    }
    public static float[] convertStrokeDasharray(org.apache.batik.css.engine.value.Value v) {
        float[] dasharray =
          null;
        if (v.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            int length =
              v.
              getLength(
                );
            dasharray =
              (new float[length]);
            float sum =
              0;
            for (int i =
                   0;
                 i <
                   dasharray.
                     length;
                 ++i) {
                dasharray[i] =
                  v.
                    item(
                      i).
                    getFloatValue(
                      );
                sum +=
                  dasharray[i];
            }
            if (sum ==
                  0) {
                dasharray =
                  null;
            }
        }
        return dasharray;
    }
    public static float convertStrokeMiterlimit(org.apache.batik.css.engine.value.Value v) {
        float miterlimit =
          v.
          getFloatValue(
            );
        return miterlimit <
          1.0F
          ? 1.0F
          : miterlimit;
    }
    public static int convertStrokeLinecap(org.apache.batik.css.engine.value.Value v) {
        java.lang.String s =
          v.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'b':
                return java.awt.BasicStroke.
                         CAP_BUTT;
            case 'r':
                return java.awt.BasicStroke.
                         CAP_ROUND;
            case 's':
                return java.awt.BasicStroke.
                         CAP_SQUARE;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Linecap argument is not an appropriate CSS value");
        }
    }
    public static int convertStrokeLinejoin(org.apache.batik.css.engine.value.Value v) {
        java.lang.String s =
          v.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'm':
                return java.awt.BasicStroke.
                         JOIN_MITER;
            case 'r':
                return java.awt.BasicStroke.
                         JOIN_ROUND;
            case 'b':
                return java.awt.BasicStroke.
                         JOIN_BEVEL;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Linejoin argument is not an appropriate CSS value");
        }
    }
    public static int resolveColorComponent(org.apache.batik.css.engine.value.Value v) {
        float f;
        switch (v.
                  getPrimitiveType(
                    )) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                f =
                  v.
                    getFloatValue(
                      );
                f =
                  f >
                    100.0F
                    ? 100.0F
                    : (f <
                         0.0F
                         ? 0.0F
                         : f);
                return java.lang.Math.
                  round(
                    255.0F *
                      f /
                      100.0F);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
                f =
                  v.
                    getFloatValue(
                      );
                f =
                  f >
                    255.0F
                    ? 255.0F
                    : (f <
                         0.0F
                         ? 0.0F
                         : f);
                return java.lang.Math.
                  round(
                    f);
            default:
                throw new java.lang.IllegalArgumentException(
                  "Color component argument is not an appropriate CSS value");
        }
    }
    public static float convertOpacity(org.apache.batik.css.engine.value.Value v) {
        float r =
          v.
          getFloatValue(
            );
        return r <
          0.0F
          ? 0.0F
          : (r >
               1.0F
               ? 1.0F
               : r);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f6JE4yqeMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yc//Pn8M7O2XAZPD8FB1NcNVD4sFmcNi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KSxP/sGi1E+ew+ILefCxqFhGO8XiUV1vuiKJp9IU9H38GugrZBcB18eP6Pv4" +
       "DaIvDz6w5+TvnsPJ38uDvxOVXn/EScewbcJV+CjwrILWD++xf+56YP/iEfYv" +
       "/vlgf+kc7F/Kg5/dY9+BPtKYM9h/7hqwP5xHPgOurx5h/+oNVpsr24NuIPm6" +
       "IYe5fdoT9CvnEPTP8uAfRaX7LyfouKrdkqmURIf76IKwX7pWwv4CuP7giLA/" +
       "uIHC8k/2XHztHC7+dR58NSrW6I8VpYCcx//qHve/uFbcT4LrO0e4v3Mdcd9S" +
       "pLrlUtyfKl4LRfpda2b5CrztSdGelq+fQ8vv58G/iYr9mzktV6Lk314rJWC8" +
       "PyB2eXf3G0pJHvzeHv1/PQf9f8+Db0SlN4SGDZyD5o6Dybh3JRpeuVYa3g7g" +
       "z45omP150/C/z6Hh1Tz446h0UT6XgG9eBxt6kB0RkN1AAj51bN0OX9v/CDfa" +
       "Ya/ZBDN0LzhD2ffOoez7efDdvWkdd8njUi43rfvogsc/uR6C9OkjHj99HXm8" +
       "uUh18wmPf3YpIQevuzohB/lekoNb9zJ0itODgxPsB7ddB/N68JUj7F+5jtgv" +
       "7FPtVKdA9dA5iN+YB/fvTeeV4D5wHbz1g986gvtb1xHuwW5XZtHVBZonzkH6" +
       "VB48une8d37EsZxfPJHzU/EF+seuAf2b8kgYALlnl3d3v/7oP1UghM9Bj+TB" +
       "O6PSg5egb0mhLuV7PsGc/amrz9mLbaG7rVovfvGJ3/7Ai0/852Jn5e1GKEoB" +
       "EWhXOCJwKs+3X3rlm79791u+VGxAvnkphbtJ9dmzFZcfnbjkRETBwV0n1D6S" +
       "Q3tsZ0dKpeN7VJpe4zZ2kM2BCi0gwFPxKeJ4h/yNKrpA9ntn+7X4n+8fO6in" +
       "B6VcXA7e/VqCcvLR61bgCWiRfiXH6qbdmHiA++lZu3GsDA/sdxc2bc9V883F" +
       "x+92++sN7/DklA14mV6x8dGu8UVlV255IbztK0r3aeFlz3nH5UEP+Ity3tId" +
       "sHOSj4+UtlDtd12rHYcAaU8fqfbTN1K1f+QcSD+aB2JUeugS1WYNoEx2vgFy" +
       "L10F6Ok1gH4wjwQO0AXoCDR0I0Fr54A28mB5dtqcH7+RpUJX3rNHLF8r4jJo" +
       "fPMIcfNGIg7PQRzngQvc/MsQm57hnoHsXQ/IiyPIixsJ+QPnQP5gHmwB5GB3" +
       "RK+wnfk+bKDpOyN2CvL7r1WZgQJf8I8g+zcS8sfOgfw38uDD+4+sHBhAjCg7" +
       "o8Mf+UGwplHpdacOSuVHPh6+7NTl7qSg/KUXL97+0IuTf78bqo9P893BlG5f" +
       "xbZ9eof+qedb/UBdGQX2O3b79f0CywvAJl3l0zMYoXYPeWsPfnKX/qej0r1n" +
       "0wPDXtxPp/vbUenOfTpQ1O7hdJLPg3EOJMkfX/SPh65Tm+Z3BxXS3Tj18Gmh" +
       "KCY3978WvydZTh8lyv2m4tTr8bpEvDv3+pz85Rf7g/e/iv3M7iiTbEvbbV7K" +
       "7cDF2Z2qOnJxTu9hP1vacVm3Uu/43j2/eMdTx+sw9+wavBfQU2177MqHhtqO" +
       "HxXHfLa/8tAvvftnX/xGcWrg/wMWUS/ajjwAAA==");
}
