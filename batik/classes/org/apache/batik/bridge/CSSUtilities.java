package org.apache.batik.bridge;
public abstract class CSSUtilities implements org.apache.batik.util.CSSConstants, org.apache.batik.bridge.ErrorConstants, org.apache.batik.util.XMLConstants {
    protected CSSUtilities() { super(); }
    public static org.apache.batik.css.engine.CSSEngine getCSSEngine(org.w3c.dom.Element e) {
        return ((org.apache.batik.dom.svg.SVGOMDocument)
                  e.
                  getOwnerDocument(
                    )).
          getCSSEngine(
            );
    }
    public static org.apache.batik.css.engine.value.Value getComputedStyle(org.w3c.dom.Element e,
                                                                           int property) {
        org.apache.batik.css.engine.CSSEngine engine =
          getCSSEngine(
            e);
        if (engine ==
              null)
            return null;
        return engine.
          getComputedStyle(
            (org.apache.batik.css.engine.CSSStylableElement)
              e,
            null,
            property);
    }
    public static int convertPointerEvents(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              POINTER_EVENTS_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'v':
                if (s.
                      length(
                        ) ==
                      7) {
                    return org.apache.batik.gvt.GraphicsNode.
                             VISIBLE;
                }
                else {
                    switch (s.
                              charAt(
                                7)) {
                        case 'p':
                            return org.apache.batik.gvt.GraphicsNode.
                                     VISIBLE_PAINTED;
                        case 'f':
                            return org.apache.batik.gvt.GraphicsNode.
                                     VISIBLE_FILL;
                        case 's':
                            return org.apache.batik.gvt.GraphicsNode.
                                     VISIBLE_STROKE;
                        default:
                            throw new java.lang.IllegalStateException(
                              "unexpected event, must be one of (p,f,s) is:" +
                              s.
                                charAt(
                                  7));
                    }
                }
            case 'p':
                return org.apache.batik.gvt.GraphicsNode.
                         PAINTED;
            case 'f':
                return org.apache.batik.gvt.GraphicsNode.
                         FILL;
            case 's':
                return org.apache.batik.gvt.GraphicsNode.
                         STROKE;
            case 'a':
                return org.apache.batik.gvt.GraphicsNode.
                         ALL;
            case 'n':
                return org.apache.batik.gvt.GraphicsNode.
                         NONE;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected event, must be one of (v,p,f,s,a,n) is:" +
                  s.
                    charAt(
                      0));
        }
    }
    public static java.awt.geom.Rectangle2D convertEnableBackground(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              ENABLE_BACKGROUND_INDEX);
        if (v.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            return null;
        }
        org.apache.batik.css.engine.value.ListValue lv =
          (org.apache.batik.css.engine.value.ListValue)
            v;
        int length =
          lv.
          getLength(
            );
        switch (length) {
            case 1:
                return org.apache.batik.gvt.CompositeGraphicsNode.
                         VIEWPORT;
            case 5:
                float x =
                  lv.
                  item(
                    1).
                  getFloatValue(
                    );
                float y =
                  lv.
                  item(
                    2).
                  getFloatValue(
                    );
                float w =
                  lv.
                  item(
                    3).
                  getFloatValue(
                    );
                float h =
                  lv.
                  item(
                    4).
                  getFloatValue(
                    );
                return new java.awt.geom.Rectangle2D.Float(
                  x,
                  y,
                  w,
                  h);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected length:" +
                  length);
        }
    }
    public static boolean convertColorInterpolationFilters(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_INTERPOLATION_FILTERS_INDEX);
        return CSS_LINEARRGB_VALUE ==
          v.
          getStringValue(
            );
    }
    public static org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum convertColorInterpolation(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_INTERPOLATION_INDEX);
        return CSS_LINEARRGB_VALUE ==
          v.
          getStringValue(
            )
          ? org.apache.batik.ext.awt.MultipleGradientPaint.
              LINEAR_RGB
          : org.apache.batik.ext.awt.MultipleGradientPaint.
              SRGB;
    }
    public static boolean isAutoCursor(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value cursorValue =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              CURSOR_INDEX);
        boolean isAuto =
          false;
        if (cursorValue !=
              null) {
            if (cursorValue.
                  getCssValueType(
                    ) ==
                  org.w3c.dom.css.CSSValue.
                    CSS_PRIMITIVE_VALUE &&
                  cursorValue.
                  getPrimitiveType(
                    ) ==
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT &&
                  cursorValue.
                  getStringValue(
                    ).
                  charAt(
                    0) ==
                  'a') {
                isAuto =
                  true;
            }
            else
                if (cursorValue.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_VALUE_LIST &&
                      cursorValue.
                      getLength(
                        ) ==
                      1) {
                    org.apache.batik.css.engine.value.Value lValue =
                      cursorValue.
                      item(
                        0);
                    if (lValue !=
                          null &&
                          lValue.
                          getCssValueType(
                            ) ==
                          org.w3c.dom.css.CSSValue.
                            CSS_PRIMITIVE_VALUE &&
                          lValue.
                          getPrimitiveType(
                            ) ==
                          org.w3c.dom.css.CSSPrimitiveValue.
                            CSS_IDENT &&
                          lValue.
                          getStringValue(
                            ).
                          charAt(
                            0) ==
                          'a') {
                        isAuto =
                          true;
                    }
                }
        }
        return isAuto;
    }
    public static java.awt.Cursor convertCursor(org.w3c.dom.Element e,
                                                org.apache.batik.bridge.BridgeContext ctx) {
        return ctx.
          getCursorManager(
            ).
          convertCursor(
            e);
    }
    public static java.awt.RenderingHints convertShapeRendering(org.w3c.dom.Element e,
                                                                java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              SHAPE_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              10)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    0)) {
            case 'o':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_OFF);
                break;
            case 'c':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_DEFAULT);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_OFF);
                break;
            case 'g':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_STROKE_CONTROL,
                    java.awt.RenderingHints.
                      VALUE_STROKE_PURE);
                break;
        }
        return hints;
    }
    public static java.awt.RenderingHints convertTextRendering(org.w3c.dom.Element e,
                                                               java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              13)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    8)) {
            case 's':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_TEXT_ANTIALIAS_OFF);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_OFF);
                break;
            case 'l':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_TEXT_ANTIALIAS_OFF);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_ON);
                break;
            case 'c':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_TEXT_ANTIALIAS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_FRACTIONALMETRICS,
                    java.awt.RenderingHints.
                      VALUE_FRACTIONALMETRICS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_STROKE_CONTROL,
                    java.awt.RenderingHints.
                      VALUE_STROKE_PURE);
                break;
        }
        return hints;
    }
    public static java.awt.RenderingHints convertImageRendering(org.w3c.dom.Element e,
                                                                java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              IMAGE_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              13)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    8)) {
            case 's':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                break;
            case 'q':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_INTERPOLATION_BICUBIC);
                break;
        }
        return hints;
    }
    public static java.awt.RenderingHints convertColorRendering(org.w3c.dom.Element e,
                                                                java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              13)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    8)) {
            case 's':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_COLOR_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_COLOR_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ALPHA_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_ALPHA_INTERPOLATION_SPEED);
                break;
            case 'q':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_COLOR_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_COLOR_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ALPHA_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_ALPHA_INTERPOLATION_QUALITY);
                break;
        }
        return hints;
    }
    public static boolean convertDisplay(org.w3c.dom.Element e) {
        if (!(e instanceof org.apache.batik.css.engine.CSSStylableElement)) {
            return true;
        }
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              DISPLAY_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) !=
          'n';
    }
    public static boolean convertVisibility(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              VISIBILITY_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) ==
          'v';
    }
    public static final java.awt.Composite
      TRANSPARENT =
      java.awt.AlphaComposite.
      getInstance(
        java.awt.AlphaComposite.
          SRC_OVER,
        0);
    public static java.awt.Composite convertOpacity(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              OPACITY_INDEX);
        float f =
          v.
          getFloatValue(
            );
        if (f <=
              0.0F) {
            return TRANSPARENT;
        }
        else
            if (f >=
                  1.0F) {
                return java.awt.AlphaComposite.
                         SrcOver;
            }
            else {
                return java.awt.AlphaComposite.
                  getInstance(
                    java.awt.AlphaComposite.
                      SRC_OVER,
                    f);
            }
    }
    public static boolean convertOverflow(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              OVERFLOW_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        return s.
          charAt(
            0) ==
          'h' ||
          s.
          charAt(
            0) ==
          's';
    }
    public static float[] convertClip(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              CLIP_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RECT:
                float[] off =
                  new float[4];
                off[0] =
                  v.
                    getTop(
                      ).
                    getFloatValue(
                      );
                off[1] =
                  v.
                    getRight(
                      ).
                    getFloatValue(
                      );
                off[2] =
                  v.
                    getBottom(
                      ).
                    getFloatValue(
                      );
                off[3] =
                  v.
                    getLeft(
                      ).
                    getFloatValue(
                      );
                return off;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitiveType:" +
                  primitiveType);
        }
    }
    public static org.apache.batik.ext.awt.image.renderable.Filter convertFilter(org.w3c.dom.Element filteredElement,
                                                                                 org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            filteredElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              FILTER_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                java.lang.String uri =
                  v.
                  getStringValue(
                    );
                org.w3c.dom.Element filter =
                  ctx.
                  getReferencedElement(
                    filteredElement,
                    uri);
                org.apache.batik.bridge.Bridge bridge =
                  ctx.
                  getBridge(
                    filter);
                if (bridge ==
                      null ||
                      !(bridge instanceof org.apache.batik.bridge.FilterBridge)) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filteredElement,
                      ERR_CSS_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                return ((org.apache.batik.bridge.FilterBridge)
                          bridge).
                  createFilter(
                    ctx,
                    filter,
                    filteredElement,
                    filteredNode);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitive type:" +
                  primitiveType);
        }
    }
    public static org.apache.batik.ext.awt.image.renderable.ClipRable convertClipPath(org.w3c.dom.Element clippedElement,
                                                                                      org.apache.batik.gvt.GraphicsNode clippedNode,
                                                                                      org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            clippedElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              CLIP_PATH_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                java.lang.String uri =
                  v.
                  getStringValue(
                    );
                org.w3c.dom.Element cp =
                  ctx.
                  getReferencedElement(
                    clippedElement,
                    uri);
                org.apache.batik.bridge.Bridge bridge =
                  ctx.
                  getBridge(
                    cp);
                if (bridge ==
                      null ||
                      !(bridge instanceof org.apache.batik.bridge.ClipBridge)) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      clippedElement,
                      ERR_CSS_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                return ((org.apache.batik.bridge.ClipBridge)
                          bridge).
                  createClip(
                    ctx,
                    cp,
                    clippedElement,
                    clippedNode);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitive type:" +
                  primitiveType);
        }
    }
    public static int convertClipRule(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              CLIP_RULE_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) ==
          'n'
          ? java.awt.geom.GeneralPath.
              WIND_NON_ZERO
          : java.awt.geom.GeneralPath.
              WIND_EVEN_ODD;
    }
    public static org.apache.batik.gvt.filter.Mask convertMask(org.w3c.dom.Element maskedElement,
                                                               org.apache.batik.gvt.GraphicsNode maskedNode,
                                                               org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            maskedElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              MASK_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                java.lang.String uri =
                  v.
                  getStringValue(
                    );
                org.w3c.dom.Element m =
                  ctx.
                  getReferencedElement(
                    maskedElement,
                    uri);
                org.apache.batik.bridge.Bridge bridge =
                  ctx.
                  getBridge(
                    m);
                if (bridge ==
                      null ||
                      !(bridge instanceof org.apache.batik.bridge.MaskBridge)) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      maskedElement,
                      ERR_CSS_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                return ((org.apache.batik.bridge.MaskBridge)
                          bridge).
                  createMask(
                    ctx,
                    m,
                    maskedElement,
                    maskedNode);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitive type:" +
                  primitiveType);
        }
    }
    public static int convertFillRule(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FILL_RULE_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) ==
          'n'
          ? java.awt.geom.GeneralPath.
              WIND_NON_ZERO
          : java.awt.geom.GeneralPath.
              WIND_EVEN_ODD;
    }
    public static java.awt.Color convertLightingColor(org.w3c.dom.Element e,
                                                      org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              LIGHTING_COLOR_INDEX);
        if (v.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return org.apache.batik.bridge.PaintServer.
              convertColor(
                v,
                1);
        }
        else {
            return org.apache.batik.bridge.PaintServer.
              convertRGBICCColor(
                e,
                v.
                  item(
                    0),
                (org.apache.batik.css.engine.value.svg.ICCColor)
                  v.
                  item(
                    1),
                1,
                ctx);
        }
    }
    public static java.awt.Color convertFloodColor(org.w3c.dom.Element e,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FLOOD_COLOR_INDEX);
        org.apache.batik.css.engine.value.Value o =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FLOOD_OPACITY_INDEX);
        float f =
          org.apache.batik.bridge.PaintServer.
          convertOpacity(
            o);
        if (v.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return org.apache.batik.bridge.PaintServer.
              convertColor(
                v,
                f);
        }
        else {
            return org.apache.batik.bridge.PaintServer.
              convertRGBICCColor(
                e,
                v.
                  item(
                    0),
                (org.apache.batik.css.engine.value.svg.ICCColor)
                  v.
                  item(
                    1),
                f,
                ctx);
        }
    }
    public static java.awt.Color convertStopColor(org.w3c.dom.Element e,
                                                  float opacity,
                                                  org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              STOP_COLOR_INDEX);
        org.apache.batik.css.engine.value.Value o =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              STOP_OPACITY_INDEX);
        opacity *=
          org.apache.batik.bridge.PaintServer.
            convertOpacity(
              o);
        if (v.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return org.apache.batik.bridge.PaintServer.
              convertColor(
                v,
                opacity);
        }
        else {
            return org.apache.batik.bridge.PaintServer.
              convertRGBICCColor(
                e,
                v.
                  item(
                    0),
                (org.apache.batik.css.engine.value.svg.ICCColor)
                  v.
                  item(
                    1),
                opacity,
                ctx);
        }
    }
    public static void computeStyleAndURIs(org.w3c.dom.Element refElement,
                                           org.w3c.dom.Element localRefElement,
                                           java.lang.String uri) {
        int idx =
          uri.
          indexOf(
            '#');
        if (idx !=
              -1)
            uri =
              uri.
                substring(
                  0,
                  idx);
        if (uri.
              length(
                ) !=
              0)
            localRefElement.
              setAttributeNS(
                XML_NAMESPACE_URI,
                "base",
                uri);
        org.apache.batik.css.engine.CSSEngine engine =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            localRefElement);
        org.apache.batik.css.engine.CSSEngine refEngine =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            refElement);
        engine.
          importCascadedStyleMaps(
            refElement,
            refEngine,
            localRefElement);
    }
    protected static int rule(org.w3c.dom.css.CSSValue v) {
        return ((org.w3c.dom.css.CSSPrimitiveValue)
                  v).
          getStringValue(
            ).
          charAt(
            0) ==
          'n'
          ? java.awt.geom.GeneralPath.
              WIND_NON_ZERO
          : java.awt.geom.GeneralPath.
              WIND_EVEN_ODD;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JsLYKqGkGY48vFpRAWRtyOrlClWVFxsx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0tPmErGBCw2Xhjy1XLUtr32oHFFxK+i487hHBWuvERTbpa7RXBQpx/PrUHUF" +
       "3H7aWA4WGNRmpRGYpq5YPZHDVQeZ1s0ij8PKwmsajWHFjwNFYYQgajaMJpSY" +
       "kGnWB2mxg9ckRei203pt7dq811S6G3FQpMwipk2Kbbw8VuhpTE1wQcR1mrYj" +
       "eqGiHTCnQLhRo47SIr0hYqPFoJVR6s91UqiP1yUNL8p2saEXtW4c2BjJI5Wo" +
       "o89pZtJ340bP6KSqwpRlKSRotu1Xu5wui8u1gakLtw8Z/hAnJbUBwUHTlJQQ" +
       "WKfJslIVLvbmRR1Mv6C1Ik0cr28a61ar9eY3Z4+C1Rf2NP5l+cLDySYXw6pn" +
       "N7gX8BQ6uXKDh3mDUeEWcRFGgShF+2XY/HPxeLfE8ffpZdj92tyF4xWQxy7b" +
       "W7BdYh2NTrY6HWd97dW2IXSCwA0uy36VmgWKPMmaPft/8Gq7a/Ln/h9519PP" +
       "LpmPwoe7hdVFVLg1cr03WfJKtk7heSWo6Q1XX+Og8s1F+wW/33nXNx4Yv0V7" +
       "+wvYyfDwGTnPVvkvqI9/vvda6QOHhQsny3+XbXu6tNATly763RbIURw440uW" +
       "/h486d5XZb35Q+DAd92LX3k3wTlqk+vpVkXPLF4f7DaF7Pru7qzv1oh0tHTt" +
       "o2wfnexEebmfPmfR+2ey5B1R4XZVjoD+dBxVd+TjGl9zmTZIYXgk53mOLs2d" +
       "m8Y7f9ACzenW8wtPXbpImjHF7JhiXkSmDve53p1f/LFTlixGhQv6jqpnzqHq" +
       "w1ny/qhwZ0aVa3txJC9H0cY6oet159GVryUe5cvPe8L+wTUQdm928Q3gUHeE" +
       "qS++auWE5Rl+8RxifilL/klUeLnkOis5iFg331LYWcm7PZcf3CP+p9eA+KHs" +
       "YhUcz+wQP3M9Ef/qOYh/LUs+ERXu2yHuONlWlrYomWrgxs7yWCNecbKirsrA" +
       "KDlZAj5EteQytmfkk9fASLZPqfDD4Pj0jpFPX09GnjuHkX+fJb8ZFR7ZMYK6" +
       "VrbnC6gB8Ka5m+7qFvgVXsn8bl64riWLzp6Uf30NpGRZC4+C43M7Uj53PUn5" +
       "4jmkfClL/iNQg6uScqwob77MdWTDYaY4VGxFumfJvUBc6sCgWBEY1+N5TSOQ" +
       "X87W0fe8feFalem14PjKjrevXE/e/ugc3p7Pkj8Eg5IetuLIReMgdPNNQb+1" +
       "R/rVa9WQe4A4O6Db7xcJ6WVjzRUH0l0U1s6/dnvD8+r+7BxevpUlfxLlu5ly" +
       "fcqJOW7k4n77zv56ztXXr4GrzJAKNcDRm3Zcvek6c3XfCQxOdpZytsEH17O4" +
       "M7v/3XPY+ass+d9R4Z4dOyNN9OSTOrKb39tT8ufXSgkYhw7euaPkndeJklzm" +
       "LNfBzVfHfXBrlhzuh98xUKWrwD648GJowhd3sL943WHffQ7se7Lkjn13921R" +
       "vVp3H1x8EXAf3rotu/2+rrgfPgf3o1nywB53PhRcDfcrr3U8ABH5YWmHu/Qi" +
       "4j47HhwUz4H8pix5bVS4YwcZ00PPEjdZ1v2IcPC6a8VaBGK3d1jb1xNr/Rys" +
       "zSwpR9m7GzlWXg/1Rfa6wFm4yDXAzaelYO5wON7BHV9PuOg5cDtZ8pZ91zJg" +
       "kNxh7e+xvvVau/b1QGxrh9W6nliZc7AOs2QABupjrCBRLHd9pmOJawX7GiD3" +
       "Zgd2cz3B/ug5YLMQ/4CPCi85dlOWnu3bf83Vn/fk+/i3W1Sf/cVX/95PPfvq" +
       "/5pvhb9FD3kxaAXqFV7rOlXm2x9//ptffumDn8zfGLlhIYbbBzJn34e7/HW3" +
       "S95iy4HffimfD4PjdVs+t9/X/uYRKGZDuedugbN8KvBivdR0taq3qnJm5nUj" +
       "0D8xOtvD+e9sM+3BYrc1/UD/QSpz8hT1Jkt21O2LYR/MSopecna0Ow717t7v" +
       "q0Yt15GzSfTxve0rUbp7dPJuJLiZXFHSp7aS5o1dWcxcZ9ErKvVpnV2fcy9z" +
       "SQchYEzKJN0COyf7T+5sNbfo6TVY9Cuyi2BWdvjhnUV/+EW06Av75+En8fej" +
       "l81V1FV0BKafnqZLIe0uc7v6Ro7ynCeLB9mTxYN37Ccru/n/rpXSVSe8ehbH" +
       "HQV5QJP1+dGpgjmb1/KUMR/4snH+szs2P3ud2MwEffeeqHOeKx78XJa8fz8s" +
       "ZJ6SFSPtmCrkb09VVpQ7saKcrWt+xJiNJl/fsfX16zma/LNzOPpoljx7KUdc" +
       "vH0tdf908eAfXwPY+7KLjwG5v7sD+93/P6rxqXNg/0qWfGw/iFJiaB6rxSNX" +
       "tFMlN5ajk4w5Lf/yRdCBCw9sy26/r5cOfOYcMv5tlvzGXgeAX7CuoAP/6loX" +
       "Id4IQL5xB/aNLyLYs1O9bfd//hzEX8iS39rP7Eld1SIwyctH92M9uOPUW1vW" +
       "qac+B799rUSAoPlCa0dE67oT8QfnEPHVLPnyflLUtVx3mcPNbvynPeb//CKs" +
       "QF2Y7TDPrqMDODWI/vdzgH89S74W5e835s+0Ite7Eu7nrwH3XdnFOhButcMd" +
       "XT/c24TLsf2vc3B/J0u+ASJEabvQlq+ztZzlhOtfcQXhhpWrL/d0fPNaA64H" +
       "gcwf2NHxgRdKxw/9QId3bLv3n16yzRYL0dEoXyLMSfjrqxN0mDV08F0APLjc" +
       "A37vhaBPosLtp/+SIJuk3X/ZX5xs/5ZD+uSzF2+579nJH2znWMd/nXErWbhF" +
       "iS3r9Luwp85v8gJZ0XM6bt2+GevlEG6NCvdd5bk4mEVsTzJxD2/Z5r8dmMHZ" +
       "/CAez79P57sYFW7b5wNVbU9OZ7krKlwAWbLTu73jzjj1luf2leBk20/3n9aT" +
       "/OHxXT+I4JMip1/az6K2/C9mjjcjxNs/mXlS+tSzA/onvlP76PZPAyRLTNOs" +
       "llvA3HT7/wV5pdmGhkevWttxXTfhr//+Hb9862uON1/csRV4r7OnZHv4yq/n" +
       "d2wvyl+oT3/jvl/7kX/+7Nfy11z/H2GJw9b7RwAA");
}
