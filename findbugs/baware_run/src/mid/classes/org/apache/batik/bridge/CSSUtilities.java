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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bDZQcRbWumU32Lz+7SUg25D+bTXwJyQwRIeoisNlssktm" +
       "s+POkiOLsuntqZ1t0tPddNfszgZjCDwles6LColGlOhR8IcXiOc9eDz/MB7U" +
       "gCiRqAgiInAUEHgHjk8jouK9Vd3TPT3TveFsv7fndHVv161b9351761b1TXH" +
       "XiHTLZO0GpKWlRJswqBWIo3Pacm0aLZTlSxrAN4OyR975pZ9Z37WsD9OagfJ" +
       "7FHJ6pUli25VqJq1BslSRbOYpMnU2kFpFlukTWpRc0xiiq4NkvmK1ZM3VEVW" +
       "WK+epUiwUzJTZI7EmKkMFxjtsRkwsjzFpUlyaZIdfoL2FJkp68aE22BRWYNO" +
       "Tx3S5t3+LEaaU9dIY1KywBQ1mVIs1l40yXmGrk7kVJ0laJElrlEvtIG4PHVh" +
       "BQytX2/68xufGG3mMMyTNE1nXEWrn1q6OkazKdLkvu1Sad66lnyI1KTIDA8x" +
       "I20pp9MkdJqETh19XSqQfhbVCvlOnavDHE61howCMbKynIkhmVLeZpPmMgOH" +
       "embrzhuDtitK2jrD7VPx8HnJQ5++uvk/akjTIGlStAyKI4MQDDoZBEBpfpia" +
       "Vkc2S7ODZI4GA56hpiKpyh57tOdaSk6TWAFMwIEFXxYMavI+XaxgJEE3syAz" +
       "3SypN8KNyv5v+ogq5UDXBa6uQsOt+B4UbFRAMHNEAtuzm0zbrWhZbkflLUo6" +
       "tm0HAmhal6dsVC91NU2T4AWZK0xElbRcMgPGp+WAdLoOJmhyWwtgilgbkrxb" +
       "ytEhRhb66dKiCqgaOBDYhJH5fjLOCUZpkW+UPOPzyo6LD16ndWtxEgOZs1RW" +
       "Uf4Z0GiZr1E/HaEmBT8QDWeuS31KWvCdA3FCgHi+j1jQ3PfB1y5bv+zEg4Jm" +
       "cRWavuFrqMyG5NuHZz+6pHPtu2pQjHpDtxQc/DLNuZel7Zr2ogGRZkGJI1Ym" +
       "nMoT/T+88vo76Utx0thDamVdLeTBjubIet5QVGpuoxo1JUazPaSBatlOXt9D" +
       "6uA5pWhUvO0bGbEo6yHTVP6qVuf/A0QjwAIhaoRnRRvRnWdDYqP8uWgQQprh" +
       "Iu+yL/x7JxaM0OSonqdJSZY0RdOTaVNH/XFAecyhFjxnodbQk8Ng/7s3bExs" +
       "Slp6wQSDTOpmLimBVYxSUZkcNpVsjiY7M5krQH/QHVBFczP+vzoqosbzxmMx" +
       "GIwl/lCgghd162qWmkPyocLmrtfuHnpYmBm6ho0VBC/oLSF6S/DeEqK3hLc3" +
       "EovxTs7BXsVow1jtBq+HsDtzbeYDl+860FoDZmaMTwOgkXRNxTTU6YYHJ6YP" +
       "ycce7T9z6ieNd8ZJHCLIMExD7lzQVjYXiKnM1GWahWAUNCs4kTEZPA9UlYOc" +
       "ODK+f+e+87kc3vCODKdDZMLmaQzKpS7a/G5djW/TTS/8+fin9uqug5fNF840" +
       "V9ES40arf0j9yg/J61ZI9w59Z29bnEyDYAQBmEngMBDblvn7KIsf7U4sRl3q" +
       "QeER3cxLKlY5AbSRjZr6uPuG29oc/nwODPFsdKhFcF1iexi/Y+0CA8sWYZto" +
       "Mz4teKx/T8a47fFHXryAw+1MC02e+TxDWbsnFCGzuTzozHFNcMCkFOieOpK+" +
       "5fArN13F7Q8oVlXrsA3LTghBMIQA84cfvPaJp39z+8/jrs0y0mCYOgM3pdli" +
       "SU+sIrNC9ERTd0WCaKYCBzSctis0MExlRJGGVYp+8rem1RvvfflgszAFFd44" +
       "lrR+cgbu+3M3k+sfvvrMMs4mJuNs6sLmkokQPc/l3GGa0gTKUdx/eulnTkq3" +
       "QbCHAGspeyiPmYTDQPi4vYPrn+TlBb66i7Bos7z2X+5inqxnSP7Ez1+dtfPV" +
       "+1/j0panTd7h7pWMdmFhWKwuAvsWf6zplqxRoHvHiR3vb1ZPvAEcB4GjDBHT" +
       "6jMhzBXLjMOmnl73q+89sGDXozUkvpU0qrqU3SpxPyMNYODUGoUIWTQuvUwM" +
       "7ni9M3kUSYXyiOfy6iPVlTcYx3bPf7fcc/FXjv6G25WwosWlkLiiIiTylNv1" +
       "5pef/Oxz3z3zpToxYa8NDmG+dgv/2qcO3/DsXypA5sGrSjLhaz+YPPa5RZ2X" +
       "vMTbu1EEW68qVk4tEGfdtm+/M/+neGvtD+KkbpA0y3Z6u1NSC+ibg5DSWU7O" +
       "CylwWX15eiZykfZSlFzij2Cebv3xy53S4Bmp8XmWL2QtxFG8lGDE4X/x7f6Q" +
       "FSP8YRtvsoaXa7FYz4ewhkG2XhiGhQ88WDyRZiCGokmqL160OMyrdMLIjIH+" +
       "jh2ZdEd/144B3m4hAMHtShpnCYxRGPSoiJ9YbsKiW/Tx7mqmWqwucBwftzNS" +
       "Lw3D9AJm74rJ/5qcxMi5e8Oaa7o1jpCtFamCcIRMprSqcUjXBGUVXaapmxXk" +
       "AZzf15sqkWJIWBqUSPNFwO03HDqa7btjo/CeueXJaResve567O8/Thz57UNV" +
       "sqAGphsbVDpGVY/ii6HLlRU+28vXGa4DbDp9pubJmxfOrMxgkNOygPxkXbBz" +
       "+zs4ecMfFg1cMrrrLaQmy31A+Vl+rffYQ9vWyDfH+VJJ+FvFEqu8UXu5lzWa" +
       "FNaE2kCZr7WW7GsJmtO/wNVt21d39fQgxG6xSPkca04IR9+UFbPDrm1h89DC" +
       "xi+QE1k9n8ClPNUYl0ELmep4BBxlZGaOMrDyLi0HYdHhuLrCZmXLSlBOkyin" +
       "5g6shDhw5VyDLy7lr7PlAQxB7bMh6IsM1CCOPnDiLiudZwAe58C9oEwBIk3a" +
       "VPKQtI3ZK9XjC85c+/26PVucVWi1JoJyu9V76pvdzw9xQ69HTyqZl8eLOsyc" +
       "JyNtFrq8CX8xuP6BF+qAL/AOobXTXniuKK08DQOjScj86lMhuXfu07s/98Jd" +
       "QgX/ZOojpgcOfezNxMFDIsqI7YtVFTsI3jZiC0Oog8WNRR54QnrhLbY+f3zv" +
       "t76696a4ba27GKlR7J0lrwfgQt0HupC0duNtr+/7yON9sHjoIfUFTbm2QHuy" +
       "5X5eZxWGPaPg7ne4Xm/LjIgzElsH4PLX+0Ic65NYTDDSjI4Fw1OAQcmwCbXk" +
       "XG8Lc64xTB4SPIVw3WvPlN1rAVatgytnO0MuMvcK4lg9ZnH34p0dDcHwC1gc" +
       "YeQcyKnGYMmX1vnmWdcYtW3gBhecz0wZnGVYdSFch21VDkcGThDHycD59xBw" +
       "7sLiDkZabHC6NFxEbZbk3TlTL2hZx87OLeVdOQoTQz9koJCLqvTtW1zwvjxl" +
       "8HCdTN4N1322qvdFBl4Qx8nA+2YIeN/G4h5GVtjgwUoHNybAuCAm8dRjq6LC" +
       "fyJ9u94OWXj7sOf5o4zUDeu6SiWtmhgHiy7C904ZYWxAVsL1oI3Hg5EhfNLm" +
       "ePItIvzjEIQfweKHYH6BCDsG+p6KQIiTFRpsb0FliqHSbaaUVcDn07BmY22c" +
       "UwboKWa8LsQnozHiNXA9ZgPyWGQQB3GcDOInQyB+CotfQO6mWB0FpncWTEvn" +
       "+dz9LiiPRWN380EoWwNxjwSUN22Wb4aDUpaS2UZTmZraq6/N/GZ//uGivRAC" +
       "4ctYPMv4qp1bKcfQ6aTJXbK67zmsz00ZVvRkchHAucGGdUNUsAZyPAtYW0oa" +
       "91MtS/FrUjcmXFyY10OA/DsWf2Rkvg1kZlQyaIkHVv7VRe9/o0EP5urYflvX" +
       "/ZGhF8QxBD2uHvYYqw+GKNaIRdzNZgbAQAMQitVEZ1+nbH1ORYZQEMezQmh+" +
       "CEItWDS5RtSTl3JBRhRrjgyieIPgIO5RQBTI8awgag2BqA2LJS5EfDIMgmhp" +
       "NDMirMfj59sKnR8ZREEcJ5kRY8kQdDZisZaR2TY6WxTLUKUJJHXnxNi6aGA5" +
       "D4TfbCuxOTJYgjhOBsvFIbBcgsVFDD9Qc1h2KpYyjN89/chsmjIyfFcMVpjx" +
       "AVuPgciQCeI4GTI9IchgZ7FO12D6IKOwYUm7sGyJxmDWgvCqrYQaGSxBHCeD" +
       "ZWcILO/DIg0JkAMLFCOqPu4zl/dGg8tqkH7C1mIiMlyCOE6GixyCC24JxT7A" +
       "yAwn+qqK4f/qVdrx418jxTbUN+a9+J8P7ap7QuyuVd9T9J1+efa6h7+o//ql" +
       "uLP1tb8cs+VwvU1oKO5RH8gAJvkkn1064Ikv2P5vTn4EdYQ7hKuD9y896B79" +
       "8qpH9h1d9Qz/XFqvWDsls8PMVTmV5Gnz6rGnXzo9a+nd/FTBNNyIRXhn+Y9z" +
       "VZ7WKjuExUemCY3iGmGBITsF08GBpIqtS/zX3ifwb+l3CL7ii11sbDIf6OXC" +
       "3MhIrUq1nDgqdABb6obL3044nHRffDvHb5OJTlXXKO4gOXXiIIyiJ0qn5aCy" +
       "uqRZISnvrLqYXM/tQsIQ//rXkLqPYHE94CijpEKxEPKPinjjCUTVd2ZiV085" +
       "iJ2LVWsA1lvtkHNrZEEsiKNP8RrxFZMHMWf8VlaskHNjLLHNlIxRRbZ2QNhB" +
       "whc5WIdCgDyCxUF3iWxvjNm9nB+4eaNg8p4weWqKppPwNOTAfzyaZAPTsAds" +
       "mB6IDPggjiHAo06HXUzvCMH0K1h83p1fcR5JS2zUQfWCs0cVm/aX/JYD+4Vo" +
       "vhPgtPw7G4bfRQZsEMfJpuV7QuD8LyzuLoezvyBOUbqfCGLHp4xLC1a1gvSv" +
       "21q8HhkuQRzP3uC+F4LQA1h8y01ceiVrt2NsK6oGihHurYkSIUfw25FZVs0i" +
       "wUHco0AwkONklvXTENxOY/Ej17IghqlVLOvhaD58rwfp19tarI8MlyCOPrX9" +
       "exHCqJ4KAedpLH7pbmillNwoU7QcT+Yc65rtOfajerZQY49Hgxksqmo6bA07" +
       "IsMsiONZYfZyCGb/g8Xv3aX4VlXXsxwZrHjGhef5yM5S1FxpK3NlZPAEcZwk" +
       "WBkuRiF7ybE3sPgj40ft+F4y041qEE19G3kuVm0CEcdshVhkELEAjuEQuelb" +
       "s5uai191oCjx2mDY4ri/HId14DxZHDfgpw06tOwV/T3iM6ZvQTJtTFeyJTTj" +
       "sWjy4KWgzc227je/VTQ3VEPznBCO1WO7g+FC74koPF3RmcnwMxUcr4UhWC7B" +
       "Yi5gZFYE+/i8tw5UkZGZ3h8b4KbBwoofNokf48h3H22qbzl6xS/F0tT5wczM" +
       "FKkfKaiq9xio57nWMOmIwgGeKQ6FGlyRVYy0BHwqg5WieECh462Cfg1Ynp8e" +
       "1lz87qVby0ijSwesxIOXZD0jNUCCjxuMKmYtTsMWxWgttvEqwUzmTwZzqYn3" +
       "PDzmyfyHZc72SkH8tGxIPn708h3XvXbRHeI8vqxKe/YglxmwpBc/DeBM8Wjh" +
       "ykBuDq/a7rVvzP56w2pnc2aOENg178WuLeF53JiBI77Id1LdaisdWH/i9ovv" +
       "/8mB2tNxEruKxCRw4qsqzw0XjYJJll+VqnbUaadk8kP07Y3P7Tr1l1/F5vLj" +
       "2UQcjloW1mJIvuX+J9MjhnFrnDT0kOkKLC2K/FDzlgmtn8pjZtnJqdrh0uGS" +
       "mhSZjeYpYXjiyNiAziq9xd9zMNJaeTas8jcujao+Ts3NyB3ZzPIdxiwYhreW" +
       "I/tvIqAh0mBrQ6lew7APxQmjutQw0P/il+E/B/8JSW54+D06AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yyXPaw5MubfCWR1uzierkaqLMzS2aEeIMQKvw7q7RgdiP3VIU7dnlMJ7jD3Q" +
       "aAJMzv2NHmGhEfbLSx9DZkzSIJzeqFYsRrEJCeaSJbvWJGylfbI6GGGYy7fx" +
       "tqd6hjAzpfIEoTGerHZbtbruGX0v1WtISMvCxKyzXKszWJN4Z54sBkJMFudC" +
       "ovVwvBKkrU1lknrDRn+YxrW46Gqr2hSbt4V6NArosNiuTsXOuDUghngrjDZ2" +
       "aSP6nM6LpmpRU7ce2iWiZeuCVZeDGdqEh9MyW21xfL+U4JY4lgYa0/WKXEum" +
       "XLpn6ym3DjXD0kTTT8Q0xPWxLtbrct9AV5pAt7GF3iNq6pKi0SnvmVxxytDM" +
       "JnXrFAbXHZkLE1yj+QAec1O1ype6Bu/DOEQIuN1mGyOMU6JJBe5zMSq3Kh1U" +
       "I4ziEl6OKozahtOaGBc3uFbt2dKYE+Ko468Gabc2jAh+U6x7BBNGZW+0JDws" +
       "TEYShFHDiFcshPfLrtYd82a3R8IL2xm4LMQWG43YRerTMCmFOibYM5lS2PYy" +
       "EkklrI1mXS9yExfuTYUNI0zaQmjR87CJ1aNWzeP0aUyXxK6Iu/WUYGdMfTWL" +
       "VKhVGi3XLVIX3LEzHsdjh5OxxYppRJw2Gnm+TkbFlIISpJcIgxI9ARG63Jvw" +
       "i9JYpllhNiSgeaelSKneWSaOK4sjszHUICSoiHgSTCyvvh5NMJb2bMqw27NF" +
       "MpnypjT0ZsHSWCCDmumPCGhEzNodacMU4427cgNxk9iDpEuuLchCNU2X4Xp5" +
       "xdkmk7oSZfuhGhGOt7Dbdl13S7M2CrnUpFOfQJiCr/oVnZIquBsnbIC058HM" +
       "XcPLsL0qEgEWbkRlgVnFRr3UcTHeFgbsmtbM+XiYsOy0vlgAh7FgUhBnImxz" +
       "UzeUodzgewRKkQM8wRBrM5otF3Oj7wzgLifoXGs6RIOqyeI802pOrQUt0Vi/" +
       "qBaVYgMxpUqMgq8yxg8oWxht+t4EEaBuTV5yEMtOoEYRxCvNaBVpNXXYaVRL" +
       "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" +
       "lsCsvT1ocEs9NdsRtoIExJ/FG6ZWX5fB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("CFkWaHyowUiDiyilU6v0jDaJIIB9ShaMQOYIyGi6cQw17HY5HCa4H/UTdLyu" +
       "roLVZl2aLxe9nmUVZytHnAqCbDZMpoQsKgzC+rAFQ51aTC3L05G0tFwOtntk" +
       "HM2LveZgqTsd38HYkkmbfQot96EOtrE0O3Qa3pIPnd5K9vVS1J3Y+oRfKgtv" +
       "MV8a6dBobTLK5eZmMOwJCisEjaUULQW3yAaVYdqu8BuGlBNjvdB9hSOhMCZX" +
       "Lb1kt/1R3VLWSItJRvYyCkfrEgMZVhGH2lCjN+Fq1SJWqrdarbdkj3O1F/ZE" +
       "/WX54sHJJpalhWQ3xi/gSXJy5QYP8wbDwi2CGIS+IIX7pdT87+Lxbojjz9NL" +
       "qfv1tQvHqxiPXrY/YLtMOpmcbGU6zvq6q20lwH3f9S/LfpWa5wPqJGv2/P6B" +
       "q+2eyZ/df+RdTz8r0x+FD3eLo2JYuDV0vTdbSqxYp/C8CtT0xquvUwzyzUP7" +
       "Rbvfftc372ffqr/jBexGeOiMnGer/OeDj3+h+zrpA4eFCydLeJdta7q00OOX" +
       "Ltzd5ith5DvsJct3D5x076uz3vwRcBC77iWuvCPgHLXJ9XSromcWoA92Gzt2" +
       "fXd31nfrinQku/ZRtk9OccK83M+es3D9d7LknWHhdk0Jgf7gjmY4ynGNr71M" +
       "G6QgOFLyPEeX5s5N46kftshyuvX8wpOXLnRmTNE7pugXkanDfa535xd/4pQl" +
       "C2HhgrGj6plzqPpwlrw/LNyZUeXaXhQq8iRMrRO6Xn8eXfl64FG+hLwn7O9f" +
       "A2GvyC6+ERzajjDtxVetnLA8wy+dQ8wvZ8k/Dgsvl1wnVvyQcfMtg3is7PZU" +
       "fnCP+J9cA+IHs4s1cDyzQ/zM9UT8q+cg/rUs+URYuHeHGHey7ShtQTI1340c" +
       "+VgjXnmyKq4pwCjHigR8iGYpZWzPyCevgZFsr1HhR8Hx6R0jn76ejDx3DiP/" +
       "Pkt+Myw8vGMEda1s3xZQA+BNczfdMSzwLbiS+d0suq6lCM6elH99DaRkWQuP" +
       "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");
}
