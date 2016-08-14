package org.apache.batik.bridge;
public abstract class SVGUtilities implements org.apache.batik.util.SVGConstants, org.apache.batik.bridge.ErrorConstants {
    protected SVGUtilities() { super(); }
    public static org.w3c.dom.Element getParentElement(org.w3c.dom.Element elt) {
        org.w3c.dom.Node n =
          org.apache.batik.css.engine.CSSEngine.
          getCSSParentNode(
            elt);
        while (n !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE) {
            n =
              org.apache.batik.css.engine.CSSEngine.
                getCSSParentNode(
                  n);
        }
        return (org.w3c.dom.Element)
                 n;
    }
    public static float[] convertSVGNumberList(org.w3c.dom.svg.SVGNumberList l) {
        int n =
          l.
          getNumberOfItems(
            );
        if (n ==
              0) {
            return null;
        }
        float[] fl =
          new float[n];
        for (int i =
               0;
             i <
               n;
             i++) {
            fl[i] =
              l.
                getItem(
                  i).
                getValue(
                  );
        }
        return fl;
    }
    public static float convertSVGNumber(java.lang.String s) {
        return java.lang.Float.
          parseFloat(
            s);
    }
    public static int convertSVGInteger(java.lang.String s) {
        return java.lang.Integer.
          parseInt(
            s);
    }
    public static float convertRatio(java.lang.String v) {
        float d =
          1;
        if (v.
              endsWith(
                "%")) {
            v =
              v.
                substring(
                  0,
                  v.
                    length(
                      ) -
                    1);
            d =
              100;
        }
        float r =
          java.lang.Float.
          parseFloat(
            v) /
          d;
        if (r <
              0) {
            r =
              0;
        }
        else
            if (r >
                  1) {
                r =
                  1;
            }
        return r;
    }
    public static java.lang.String getDescription(org.w3c.dom.svg.SVGElement elt) {
        java.lang.String result =
          "";
        boolean preserve =
          false;
        org.w3c.dom.Node n =
          elt.
          getFirstChild(
            );
        if (n !=
              null &&
              n.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            java.lang.String name =
              n.
              getPrefix(
                ) ==
              null
              ? n.
              getNodeName(
                )
              : n.
              getLocalName(
                );
            if (name.
                  equals(
                    SVG_DESC_TAG)) {
                preserve =
                  ((org.w3c.dom.svg.SVGLangSpace)
                     n).
                    getXMLspace(
                      ).
                    equals(
                      SVG_PRESERVE_VALUE);
                for (n =
                       n.
                         getFirstChild(
                           );
                     n !=
                       null;
                     n =
                       n.
                         getNextSibling(
                           )) {
                    if (n.
                          getNodeType(
                            ) ==
                          org.w3c.dom.Node.
                            TEXT_NODE) {
                        result +=
                          n.
                            getNodeValue(
                              );
                    }
                }
            }
        }
        return preserve
          ? org.apache.batik.dom.util.XMLSupport.
          preserveXMLSpace(
            result)
          : org.apache.batik.dom.util.XMLSupport.
          defaultXMLSpace(
            result);
    }
    public static boolean matchUserAgent(org.w3c.dom.Element elt,
                                         org.apache.batik.bridge.UserAgent ua) {
        test: if (elt.
                    hasAttributeNS(
                      null,
                      SVG_SYSTEM_LANGUAGE_ATTRIBUTE)) {
            java.lang.String sl =
              elt.
              getAttributeNS(
                null,
                SVG_SYSTEM_LANGUAGE_ATTRIBUTE);
            if (sl.
                  length(
                    ) ==
                  0)
                return false;
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              sl,
              ", ");
            while (st.
                     hasMoreTokens(
                       )) {
                java.lang.String s =
                  st.
                  nextToken(
                    );
                if (matchUserLanguage(
                      s,
                      ua.
                        getLanguages(
                          ))) {
                    break test;
                }
            }
            return false;
        }
        if (elt.
              hasAttributeNS(
                null,
                SVG_REQUIRED_FEATURES_ATTRIBUTE)) {
            java.lang.String rf =
              elt.
              getAttributeNS(
                null,
                SVG_REQUIRED_FEATURES_ATTRIBUTE);
            if (rf.
                  length(
                    ) ==
                  0)
                return false;
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              rf,
              " ");
            while (st.
                     hasMoreTokens(
                       )) {
                java.lang.String s =
                  st.
                  nextToken(
                    );
                if (!ua.
                      hasFeature(
                        s)) {
                    return false;
                }
            }
        }
        if (elt.
              hasAttributeNS(
                null,
                SVG_REQUIRED_EXTENSIONS_ATTRIBUTE)) {
            java.lang.String re =
              elt.
              getAttributeNS(
                null,
                SVG_REQUIRED_EXTENSIONS_ATTRIBUTE);
            if (re.
                  length(
                    ) ==
                  0)
                return false;
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              re,
              " ");
            while (st.
                     hasMoreTokens(
                       )) {
                java.lang.String s =
                  st.
                  nextToken(
                    );
                if (!ua.
                      supportExtension(
                        s)) {
                    return false;
                }
            }
        }
        return true;
    }
    protected static boolean matchUserLanguage(java.lang.String s,
                                               java.lang.String userLanguages) {
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          userLanguages,
          ", ");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String t =
              st.
              nextToken(
                );
            if (s.
                  startsWith(
                    t)) {
                if (s.
                      length(
                        ) >
                      t.
                      length(
                        )) {
                    return s.
                      charAt(
                        t.
                          length(
                            )) ==
                      '-';
                }
                return true;
            }
        }
        return false;
    }
    public static java.lang.String getChainableAttributeNS(org.w3c.dom.Element element,
                                                           java.lang.String namespaceURI,
                                                           java.lang.String attrName,
                                                           org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.bridge.DocumentLoader loader =
          ctx.
          getDocumentLoader(
            );
        org.w3c.dom.Element e =
          element;
        java.util.List refs =
          new java.util.LinkedList(
          );
        for (;
             ;
             ) {
            java.lang.String v =
              e.
              getAttributeNS(
                namespaceURI,
                attrName);
            if (v.
                  length(
                    ) >
                  0) {
                return v;
            }
            java.lang.String uriStr =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                e);
            if (uriStr.
                  length(
                    ) ==
                  0) {
                return "";
            }
            java.lang.String baseURI =
              ((org.apache.batik.dom.AbstractNode)
                 e).
              getBaseURI(
                );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              baseURI,
              uriStr);
            java.util.Iterator iter =
              refs.
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                if (purl.
                      equals(
                        iter.
                          next(
                            )))
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      e,
                      ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                      new java.lang.Object[] { uriStr });
            }
            try {
                org.w3c.dom.svg.SVGDocument svgDoc =
                  (org.w3c.dom.svg.SVGDocument)
                    e.
                    getOwnerDocument(
                      );
                org.apache.batik.bridge.URIResolver resolver =
                  ctx.
                  createURIResolver(
                    svgDoc,
                    loader);
                e =
                  resolver.
                    getElement(
                      purl.
                        toString(
                          ),
                      e);
                refs.
                  add(
                    purl);
            }
            catch (java.io.IOException ioEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ioEx,
                  ERR_URI_IO,
                  new java.lang.Object[] { uriStr });
            }
            catch (java.lang.SecurityException secEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  secEx,
                  ERR_URI_UNSECURE,
                  new java.lang.Object[] { uriStr });
            }
        }
    }
    public static java.awt.geom.Point2D convertPoint(java.lang.String xStr,
                                                     java.lang.String xAttr,
                                                     java.lang.String yStr,
                                                     java.lang.String yAttr,
                                                     short unitsType,
                                                     org.apache.batik.parser.UnitProcessor.Context uctx) {
        float x;
        float y;
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToObjectBoundingBox(
                      xStr,
                      xAttr,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToObjectBoundingBox(
                      yStr,
                      yAttr,
                      uctx);
                break;
            case USER_SPACE_ON_USE:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      xStr,
                      xAttr,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      yStr,
                      yAttr,
                      uctx);
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Invalid unit type");
        }
        return new java.awt.geom.Point2D.Float(
          x,
          y);
    }
    public static float convertLength(java.lang.String length,
                                      java.lang.String attr,
                                      short unitsType,
                                      org.apache.batik.parser.UnitProcessor.Context uctx) {
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                return org.apache.batik.bridge.UnitProcessor.
                  svgOtherLengthToObjectBoundingBox(
                    length,
                    attr,
                    uctx);
            case USER_SPACE_ON_USE:
                return org.apache.batik.bridge.UnitProcessor.
                  svgOtherLengthToUserSpace(
                    length,
                    attr,
                    uctx);
            default:
                throw new java.lang.IllegalArgumentException(
                  "Invalid unit type");
        }
    }
    public static java.awt.geom.Rectangle2D convertMaskRegion(org.w3c.dom.Element maskElement,
                                                              org.w3c.dom.Element maskedElement,
                                                              org.apache.batik.gvt.GraphicsNode maskedNode,
                                                              org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String xStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_X_ATTRIBUTE);
        if (xStr.
              length(
                ) ==
              0) {
            xStr =
              SVG_MASK_X_DEFAULT_VALUE;
        }
        java.lang.String yStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_Y_ATTRIBUTE);
        if (yStr.
              length(
                ) ==
              0) {
            yStr =
              SVG_MASK_Y_DEFAULT_VALUE;
        }
        java.lang.String wStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE);
        if (wStr.
              length(
                ) ==
              0) {
            wStr =
              SVG_MASK_WIDTH_DEFAULT_VALUE;
        }
        java.lang.String hStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE);
        if (hStr.
              length(
                ) ==
              0) {
            hStr =
              SVG_MASK_HEIGHT_DEFAULT_VALUE;
        }
        short unitsType;
        java.lang.String units =
          maskElement.
          getAttributeNS(
            null,
            SVG_MASK_UNITS_ATTRIBUTE);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              OBJECT_BOUNDING_BOX;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                maskElement,
                SVG_MASK_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            maskedElement);
        return convertRegion(
                 xStr,
                 yStr,
                 wStr,
                 hStr,
                 unitsType,
                 maskedNode,
                 uctx);
    }
    public static java.awt.geom.Rectangle2D convertPatternRegion(org.w3c.dom.Element patternElement,
                                                                 org.w3c.dom.Element paintedElement,
                                                                 org.apache.batik.gvt.GraphicsNode paintedNode,
                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String xStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_X_ATTRIBUTE,
            ctx);
        if (xStr.
              length(
                ) ==
              0) {
            xStr =
              SVG_PATTERN_X_DEFAULT_VALUE;
        }
        java.lang.String yStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_Y_ATTRIBUTE,
            ctx);
        if (yStr.
              length(
                ) ==
              0) {
            yStr =
              SVG_PATTERN_Y_DEFAULT_VALUE;
        }
        java.lang.String wStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_WIDTH_ATTRIBUTE,
            ctx);
        if (wStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              patternElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_WIDTH_ATTRIBUTE });
        }
        java.lang.String hStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_HEIGHT_ATTRIBUTE,
            ctx);
        if (hStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              patternElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_HEIGHT_ATTRIBUTE });
        }
        short unitsType;
        java.lang.String units =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_PATTERN_UNITS_ATTRIBUTE,
            ctx);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              OBJECT_BOUNDING_BOX;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                patternElement,
                SVG_PATTERN_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintedElement);
        return convertRegion(
                 xStr,
                 yStr,
                 wStr,
                 hStr,
                 unitsType,
                 paintedNode,
                 uctx);
    }
    public static float[] convertFilterRes(org.w3c.dom.Element filterElement,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        float[] filterRes =
          new float[2];
        java.lang.String s =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_FILTER_RES_ATTRIBUTE,
            ctx);
        java.lang.Float[] vals =
          convertSVGNumberOptionalNumber(
            filterElement,
            SVG_FILTER_RES_ATTRIBUTE,
            s,
            ctx);
        if (filterRes[0] <
              0 ||
              filterRes[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FILTER_RES_ATTRIBUTE,
              s });
        }
        if (vals[0] ==
              null)
            filterRes[0] =
              -1;
        else {
            filterRes[0] =
              vals[0].
                floatValue(
                  );
            if (filterRes[0] <
                  0)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_FILTER_RES_ATTRIBUTE,
                  s });
        }
        if (vals[1] ==
              null)
            filterRes[1] =
              filterRes[0];
        else {
            filterRes[1] =
              vals[1].
                floatValue(
                  );
            if (filterRes[1] <
                  0)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_FILTER_RES_ATTRIBUTE,
                  s });
        }
        return filterRes;
    }
    public static java.lang.Float[] convertSVGNumberOptionalNumber(org.w3c.dom.Element elem,
                                                                   java.lang.String attrName,
                                                                   java.lang.String attrValue,
                                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.Float[] ret =
          new java.lang.Float[2];
        if (attrValue.
              length(
                ) ==
              0)
            return ret;
        try {
            java.util.StringTokenizer tokens =
              new java.util.StringTokenizer(
              attrValue,
              " ");
            ret[0] =
              new java.lang.Float(
                java.lang.Float.
                  parseFloat(
                    tokens.
                      nextToken(
                        )));
            if (tokens.
                  hasMoreTokens(
                    )) {
                ret[1] =
                  new java.lang.Float(
                    java.lang.Float.
                      parseFloat(
                        tokens.
                          nextToken(
                            )));
            }
            if (tokens.
                  hasMoreTokens(
                    )) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  elem,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  attrValue });
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              elem,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { attrName,
              attrValue,
              nfEx });
        }
        return ret;
    }
    public static java.awt.geom.Rectangle2D convertFilterChainRegion(org.w3c.dom.Element filterElement,
                                                                     org.w3c.dom.Element filteredElement,
                                                                     org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String xStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_X_ATTRIBUTE,
            ctx);
        if (xStr.
              length(
                ) ==
              0) {
            xStr =
              SVG_FILTER_X_DEFAULT_VALUE;
        }
        java.lang.String yStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_Y_ATTRIBUTE,
            ctx);
        if (yStr.
              length(
                ) ==
              0) {
            yStr =
              SVG_FILTER_Y_DEFAULT_VALUE;
        }
        java.lang.String wStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_WIDTH_ATTRIBUTE,
            ctx);
        if (wStr.
              length(
                ) ==
              0) {
            wStr =
              SVG_FILTER_WIDTH_DEFAULT_VALUE;
        }
        java.lang.String hStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_HEIGHT_ATTRIBUTE,
            ctx);
        if (hStr.
              length(
                ) ==
              0) {
            hStr =
              SVG_FILTER_HEIGHT_DEFAULT_VALUE;
        }
        short unitsType;
        java.lang.String units =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_FILTER_UNITS_ATTRIBUTE,
            ctx);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              OBJECT_BOUNDING_BOX;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                SVG_FILTER_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            filteredElement);
        java.awt.geom.Rectangle2D region =
          convertRegion(
            xStr,
            yStr,
            wStr,
            hStr,
            unitsType,
            filteredNode,
            uctx);
        units =
          getChainableAttributeNS(
            filterElement,
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_FILTER_MARGINS_UNITS_ATTRIBUTE,
            ctx);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              USER_SPACE_ON_USE;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                org.apache.batik.util.SVG12Constants.
                  SVG_FILTER_MARGINS_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        java.lang.String dxStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MX_ATRIBUTE);
        if (dxStr.
              length(
                ) ==
              0) {
            dxStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MX_DEFAULT_VALUE;
        }
        java.lang.String dyStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MY_ATRIBUTE);
        if (dyStr.
              length(
                ) ==
              0) {
            dyStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MY_DEFAULT_VALUE;
        }
        java.lang.String dwStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MW_ATRIBUTE);
        if (dwStr.
              length(
                ) ==
              0) {
            dwStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MW_DEFAULT_VALUE;
        }
        java.lang.String dhStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MH_ATRIBUTE);
        if (dhStr.
              length(
                ) ==
              0) {
            dhStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MH_DEFAULT_VALUE;
        }
        return extendRegion(
                 dxStr,
                 dyStr,
                 dwStr,
                 dhStr,
                 unitsType,
                 filteredNode,
                 region,
                 uctx);
    }
    protected static java.awt.geom.Rectangle2D extendRegion(java.lang.String dxStr,
                                                            java.lang.String dyStr,
                                                            java.lang.String dwStr,
                                                            java.lang.String dhStr,
                                                            short unitsType,
                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                            java.awt.geom.Rectangle2D region,
                                                            org.apache.batik.parser.UnitProcessor.Context uctx) {
        float dx;
        float dy;
        float dw;
        float dh;
        switch (unitsType) {
            case USER_SPACE_ON_USE:
                dx =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      dxStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MX_ATRIBUTE,
                      uctx);
                dy =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      dyStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MY_ATRIBUTE,
                      uctx);
                dw =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      dwStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MW_ATRIBUTE,
                      uctx);
                dh =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      dhStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MH_ATRIBUTE,
                      uctx);
                break;
            case OBJECT_BOUNDING_BOX:
                java.awt.geom.Rectangle2D bounds =
                  filteredNode.
                  getGeometryBounds(
                    );
                if (bounds ==
                      null) {
                    dx =
                      (dy =
                         (dw =
                            (dh =
                               0)));
                }
                else {
                    dx =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalCoordinateToObjectBoundingBox(
                          dxStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MX_ATRIBUTE,
                          uctx);
                    dx *=
                      bounds.
                        getWidth(
                          );
                    dy =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalCoordinateToObjectBoundingBox(
                          dyStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MY_ATRIBUTE,
                          uctx);
                    dy *=
                      bounds.
                        getHeight(
                          );
                    dw =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalCoordinateToObjectBoundingBox(
                          dwStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MW_ATRIBUTE,
                          uctx);
                    dw *=
                      bounds.
                        getWidth(
                          );
                    dh =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalCoordinateToObjectBoundingBox(
                          dhStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MH_ATRIBUTE,
                          uctx);
                    dh *=
                      bounds.
                        getHeight(
                          );
                }
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Invalid unit type");
        }
        region.
          setRect(
            region.
              getX(
                ) +
              dx,
            region.
              getY(
                ) +
              dy,
            region.
              getWidth(
                ) +
              dw,
            region.
              getHeight(
                ) +
              dh);
        return region;
    }
    public static java.awt.geom.Rectangle2D getBaseFilterPrimitiveRegion(org.w3c.dom.Element filterPrimitiveElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         java.awt.geom.Rectangle2D defaultRegion,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s;
        org.apache.batik.parser.UnitProcessor.Context uctx;
        uctx =
          org.apache.batik.bridge.UnitProcessor.
            createContext(
              ctx,
              filteredElement);
        double x =
          defaultRegion.
          getX(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_X_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            x =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  SVG_X_ATTRIBUTE,
                  uctx);
        }
        double y =
          defaultRegion.
          getY(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_Y_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            y =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  SVG_Y_ATTRIBUTE,
                  uctx);
        }
        double w =
          defaultRegion.
          getWidth(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_WIDTH_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            w =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalLengthToUserSpace(
                  s,
                  SVG_WIDTH_ATTRIBUTE,
                  uctx);
        }
        double h =
          defaultRegion.
          getHeight(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_HEIGHT_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            h =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalLengthToUserSpace(
                  s,
                  SVG_HEIGHT_ATTRIBUTE,
                  uctx);
        }
        return new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
    }
    public static java.awt.geom.Rectangle2D convertFilterPrimitiveRegion(org.w3c.dom.Element filterPrimitiveElement,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         java.awt.geom.Rectangle2D defaultRegion,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String units =
          "";
        if (filterElement !=
              null) {
            units =
              getChainableAttributeNS(
                filterElement,
                null,
                SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                ctx);
        }
        short unitsType;
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              USER_SPACE_ON_USE;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                SVG_FILTER_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        java.lang.String xStr =
          "";
        java.lang.String yStr =
          "";
        java.lang.String wStr =
          "";
        java.lang.String hStr =
          "";
        if (filterPrimitiveElement !=
              null) {
            xStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_X_ATTRIBUTE);
            yStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_Y_ATTRIBUTE);
            wStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_WIDTH_ATTRIBUTE);
            hStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_HEIGHT_ATTRIBUTE);
        }
        double x =
          defaultRegion.
          getX(
            );
        double y =
          defaultRegion.
          getY(
            );
        double w =
          defaultRegion.
          getWidth(
            );
        double h =
          defaultRegion.
          getHeight(
            );
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            filteredElement);
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                java.awt.geom.Rectangle2D bounds =
                  filteredNode.
                  getGeometryBounds(
                    );
                if (bounds !=
                      null) {
                    if (xStr.
                          length(
                            ) !=
                          0) {
                        x =
                          org.apache.batik.bridge.UnitProcessor.
                            svgHorizontalCoordinateToObjectBoundingBox(
                              xStr,
                              SVG_X_ATTRIBUTE,
                              uctx);
                        x =
                          bounds.
                            getX(
                              ) +
                            x *
                            bounds.
                            getWidth(
                              );
                    }
                    if (yStr.
                          length(
                            ) !=
                          0) {
                        y =
                          org.apache.batik.bridge.UnitProcessor.
                            svgVerticalCoordinateToObjectBoundingBox(
                              yStr,
                              SVG_Y_ATTRIBUTE,
                              uctx);
                        y =
                          bounds.
                            getY(
                              ) +
                            y *
                            bounds.
                            getHeight(
                              );
                    }
                    if (wStr.
                          length(
                            ) !=
                          0) {
                        w =
                          org.apache.batik.bridge.UnitProcessor.
                            svgHorizontalLengthToObjectBoundingBox(
                              wStr,
                              SVG_WIDTH_ATTRIBUTE,
                              uctx);
                        w *=
                          bounds.
                            getWidth(
                              );
                    }
                    if (hStr.
                          length(
                            ) !=
                          0) {
                        h =
                          org.apache.batik.bridge.UnitProcessor.
                            svgVerticalLengthToObjectBoundingBox(
                              hStr,
                              SVG_HEIGHT_ATTRIBUTE,
                              uctx);
                        h *=
                          bounds.
                            getHeight(
                              );
                    }
                }
                break;
            case USER_SPACE_ON_USE:
                if (xStr.
                      length(
                        ) !=
                      0) {
                    x =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalCoordinateToUserSpace(
                          xStr,
                          SVG_X_ATTRIBUTE,
                          uctx);
                }
                if (yStr.
                      length(
                        ) !=
                      0) {
                    y =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalCoordinateToUserSpace(
                          yStr,
                          SVG_Y_ATTRIBUTE,
                          uctx);
                }
                if (wStr.
                      length(
                        ) !=
                      0) {
                    w =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalLengthToUserSpace(
                          wStr,
                          SVG_WIDTH_ATTRIBUTE,
                          uctx);
                }
                if (hStr.
                      length(
                        ) !=
                      0) {
                    h =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalLengthToUserSpace(
                          hStr,
                          SVG_HEIGHT_ATTRIBUTE,
                          uctx);
                }
                break;
            default:
                throw new java.lang.Error(
                  "invalid unitsType:" +
                  unitsType);
        }
        java.awt.geom.Rectangle2D region =
          new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
        units =
          "";
        if (filterElement !=
              null) {
            units =
              getChainableAttributeNS(
                filterElement,
                null,
                org.apache.batik.util.SVG12Constants.
                  SVG_FILTER_PRIMITIVE_MARGINS_UNITS_ATTRIBUTE,
                ctx);
        }
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              USER_SPACE_ON_USE;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                org.apache.batik.util.SVG12Constants.
                  SVG_FILTER_PRIMITIVE_MARGINS_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        java.lang.String dxStr =
          "";
        java.lang.String dyStr =
          "";
        java.lang.String dwStr =
          "";
        java.lang.String dhStr =
          "";
        if (filterPrimitiveElement !=
              null) {
            dxStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MX_ATRIBUTE);
            dyStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MY_ATRIBUTE);
            dwStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MW_ATRIBUTE);
            dhStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MH_ATRIBUTE);
        }
        if (dxStr.
              length(
                ) ==
              0) {
            dxStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MX_DEFAULT_VALUE;
        }
        if (dyStr.
              length(
                ) ==
              0) {
            dyStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MY_DEFAULT_VALUE;
        }
        if (dwStr.
              length(
                ) ==
              0) {
            dwStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MW_DEFAULT_VALUE;
        }
        if (dhStr.
              length(
                ) ==
              0) {
            dhStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MH_DEFAULT_VALUE;
        }
        region =
          extendRegion(
            dxStr,
            dyStr,
            dwStr,
            dhStr,
            unitsType,
            filteredNode,
            region,
            uctx);
        java.awt.geom.Rectangle2D.
          intersect(
            region,
            filterRegion,
            region);
        return region;
    }
    public static java.awt.geom.Rectangle2D convertFilterPrimitiveRegion(org.w3c.dom.Element filterPrimitiveElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         java.awt.geom.Rectangle2D defaultRegion,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        org.w3c.dom.Node parentNode =
          filterPrimitiveElement.
          getParentNode(
            );
        org.w3c.dom.Element filterElement =
          null;
        if (parentNode !=
              null &&
              parentNode.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            filterElement =
              (org.w3c.dom.Element)
                parentNode;
        }
        return convertFilterPrimitiveRegion(
                 filterPrimitiveElement,
                 filterElement,
                 filteredElement,
                 filteredNode,
                 defaultRegion,
                 filterRegion,
                 ctx);
    }
    public static final short USER_SPACE_ON_USE =
      1;
    public static final short OBJECT_BOUNDING_BOX =
      2;
    public static final short STROKE_WIDTH =
      3;
    public static short parseCoordinateSystem(org.w3c.dom.Element e,
                                              java.lang.String attr,
                                              java.lang.String coordinateSystem,
                                              org.apache.batik.bridge.BridgeContext ctx) {
        if (SVG_USER_SPACE_ON_USE_VALUE.
              equals(
                coordinateSystem)) {
            return USER_SPACE_ON_USE;
        }
        else
            if (SVG_OBJECT_BOUNDING_BOX_VALUE.
                  equals(
                    coordinateSystem)) {
                return OBJECT_BOUNDING_BOX;
            }
            else {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attr,
                  coordinateSystem });
            }
    }
    public static short parseMarkerCoordinateSystem(org.w3c.dom.Element e,
                                                    java.lang.String attr,
                                                    java.lang.String coordinateSystem,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
        if (SVG_USER_SPACE_ON_USE_VALUE.
              equals(
                coordinateSystem)) {
            return USER_SPACE_ON_USE;
        }
        else
            if (SVG_STROKE_WIDTH_VALUE.
                  equals(
                    coordinateSystem)) {
                return STROKE_WIDTH;
            }
            else {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attr,
                  coordinateSystem });
            }
    }
    protected static java.awt.geom.Rectangle2D convertRegion(java.lang.String xStr,
                                                             java.lang.String yStr,
                                                             java.lang.String wStr,
                                                             java.lang.String hStr,
                                                             short unitsType,
                                                             org.apache.batik.gvt.GraphicsNode targetNode,
                                                             org.apache.batik.parser.UnitProcessor.Context uctx) {
        double x;
        double y;
        double w;
        double h;
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToObjectBoundingBox(
                      xStr,
                      SVG_X_ATTRIBUTE,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToObjectBoundingBox(
                      yStr,
                      SVG_Y_ATTRIBUTE,
                      uctx);
                w =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalLengthToObjectBoundingBox(
                      wStr,
                      SVG_WIDTH_ATTRIBUTE,
                      uctx);
                h =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalLengthToObjectBoundingBox(
                      hStr,
                      SVG_HEIGHT_ATTRIBUTE,
                      uctx);
                java.awt.geom.Rectangle2D bounds =
                  targetNode.
                  getGeometryBounds(
                    );
                if (bounds !=
                      null) {
                    x =
                      bounds.
                        getX(
                          ) +
                        x *
                        bounds.
                        getWidth(
                          );
                    y =
                      bounds.
                        getY(
                          ) +
                        y *
                        bounds.
                        getHeight(
                          );
                    w *=
                      bounds.
                        getWidth(
                          );
                    h *=
                      bounds.
                        getHeight(
                          );
                }
                else {
                    x =
                      (y =
                         (w =
                            (h =
                               0)));
                }
                break;
            case USER_SPACE_ON_USE:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      xStr,
                      SVG_X_ATTRIBUTE,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      yStr,
                      SVG_Y_ATTRIBUTE,
                      uctx);
                w =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalLengthToUserSpace(
                      wStr,
                      SVG_WIDTH_ATTRIBUTE,
                      uctx);
                h =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalLengthToUserSpace(
                      hStr,
                      SVG_HEIGHT_ATTRIBUTE,
                      uctx);
                break;
            default:
                throw new java.lang.Error(
                  "invalid unitsType:" +
                  unitsType);
        }
        return new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
    }
    public static java.awt.geom.AffineTransform convertTransform(org.w3c.dom.Element e,
                                                                 java.lang.String attr,
                                                                 java.lang.String transform,
                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        try {
            return org.apache.batik.parser.AWTTransformProducer.
              createAffineTransform(
                transform);
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              pEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { attr,
              transform,
              pEx });
        }
    }
    public static java.awt.geom.AffineTransform toObjectBBox(java.awt.geom.AffineTransform Tx,
                                                             org.apache.batik.gvt.GraphicsNode node) {
        java.awt.geom.AffineTransform Mx =
          new java.awt.geom.AffineTransform(
          );
        java.awt.geom.Rectangle2D bounds =
          node.
          getGeometryBounds(
            );
        if (bounds !=
              null) {
            Mx.
              translate(
                bounds.
                  getX(
                    ),
                bounds.
                  getY(
                    ));
            Mx.
              scale(
                bounds.
                  getWidth(
                    ),
                bounds.
                  getHeight(
                    ));
        }
        Mx.
          concatenate(
            Tx);
        return Mx;
    }
    public static java.awt.geom.Rectangle2D toObjectBBox(java.awt.geom.Rectangle2D r,
                                                         org.apache.batik.gvt.GraphicsNode node) {
        java.awt.geom.Rectangle2D bounds =
          node.
          getGeometryBounds(
            );
        if (bounds !=
              null) {
            return new java.awt.geom.Rectangle2D.Double(
              bounds.
                getX(
                  ) +
                r.
                getX(
                  ) *
                bounds.
                getWidth(
                  ),
              bounds.
                getY(
                  ) +
                r.
                getY(
                  ) *
                bounds.
                getHeight(
                  ),
              r.
                getWidth(
                  ) *
                bounds.
                getWidth(
                  ),
              r.
                getHeight(
                  ) *
                bounds.
                getHeight(
                  ));
        }
        else {
            return new java.awt.geom.Rectangle2D.Double(
              );
        }
    }
    public static float convertSnapshotTime(org.w3c.dom.Element e,
                                            org.apache.batik.bridge.BridgeContext ctx) {
        if (!e.
              hasAttributeNS(
                null,
                SVG_SNAPSHOT_TIME_ATTRIBUTE)) {
            return 0.0F;
        }
        java.lang.String t =
          e.
          getAttributeNS(
            null,
            SVG_SNAPSHOT_TIME_ATTRIBUTE);
        if (t.
              equals(
                SVG_NONE_VALUE)) {
            return 0.0F;
        }
        class Handler implements org.apache.batik.parser.ClockHandler {
            float
              time;
            public void clockValue(float t) {
                time =
                  t;
            }
            public Handler() {
                super(
                  );
            }
        }
        ;
        org.apache.batik.parser.ClockParser p =
          new org.apache.batik.parser.ClockParser(
          false);
        Handler h =
          new Handler(
          );
        p.
          setClockHandler(
            h);
        try {
            p.
              parse(
                t);
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              null,
              e,
              pEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_SNAPSHOT_TIME_ATTRIBUTE,
              t,
              pEx });
        }
        return h.
                 time;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uNtNRz8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7DraH2f79l77z6y7BN2l4Vd2GUhAcGVLcuW3Q0JsmxZ" +
       "fsmyJcuWmnKjt2TrZT0sySklybQBSodSyqsd2GamJE2Z5VGGtJlJ09m0kwIN" +
       "QyePtmmahiSTSWgpHaAtedAm/SSfc3zO2XvPZufcjWf8Wdb3+v9/3//1+ftb" +
       "z36jdCUMSpDv2Zlhe9E1LY2uLe3atSjztfBaf1hjpCDUVMKWwpAD964rT372" +
       "3u989/3mfQelq2LpQcl1vUiKLM8Np1ro2RtNHZbu3d/t2JoTRqX7hktpI8Fx" +
       "ZNnw0Aqjp4el7znRNSo9NTwiAQYkwIAEuCABxvetQKeXaW7sEHkPyY3Cdelv" +
       "lC4NS1d9JScvKj1xehBfCiTncBim4ACMcEf+nQdMFZ3ToPTaY953PD+P4Q9B" +
       "8Ac/8vb7Pndb6V6xdK/lsjk5CiAiApOIpbsdzZG1IMRVVVPF0v2upqmsFliS" +
       "bW0LusXSA6FluFIUB9oxSPnN2NeCYs49cncrOW9BrERecMyebmm2evTtim5L" +
       "BuD1oT2vOw7J/D5g8C4LEBbokqIddbm8slw1Kr3mbI9jHp8agAag6+2OFpne" +
       "8VSXXQncKD2wWztbcg2YjQLLNUDTK14MZolKj9500BxrX1JWkqFdj0qPnG3H" +
       "7KpAqzsLIPIuUekVZ5sVI4FVevTMKp1Yn2/Q3/++H3Ep96CgWdUUO6f/DtDp" +
       "8TOdppquBZqraLuOd79p+GHpoV9490GpBBq/4kzjXZt/8de/9bY3P/7cF3dt" +
       "XnWDNmN5qSnRdeUT8j2/8mrijc3bcjLu8L3Qyhf/FOeF+DOHNU+nPtC8h45H" +
       "zCuvHVU+N/23wo9+Uvv6QemuXumq4tmxA+TofsVzfMvWgq7maoEUaWqvdKfm" +
       "qkRR3yvdDq6Hlqvt7o51PdSiXumyXdy66hXfAUQ6GCKH6HZwbbm6d3TtS5FZ" +
       "XKd+qVS6D7xLffBulHav4jMqzWHTczRYUiTXcj2YCbyc/xDW3EgG2JqwDKR+" +
       "BYdeHAARhL3AgCUgB6Z2WCEHlmpoMMt3Z4BjwC3AMRcw/6UbOs25ui+5dAkA" +
       "/uqz6m4DTaE8W9WC68oH41bnW5++/ssHx+J/iAcwUGC2a7vZrhWzXdvNdu3k" +
       "bKVLl4pJXp7PultRsB4roNnA5t39Rvav9X/43U/eBkTJTy4DMPOm8M1NL7G3" +
       "Bb3C4ilAIEvPfTT5Mf6d5YPSwWkbmlMKbt2Vd2dyy3ds4Z46qzs3Gvfed33t" +
       "O5/58Du8vRadMsqHyv38nrlyPnkW08BTNBWYu/3wb3qt9LPXf+EdTx2ULgON" +
       "B1YukoBUAgPy+Nk5Tinp00cGL+flCmBY9wJHsvOqIyt1V2QGXrK/Uyz2PcX1" +
       "/QDje3KpfRS833ooxsVnXvugn5cv3wlHvmhnuCgM6ltZ/+O/8ZX/Vi3gPrK9" +
       "957wZqwWPX1C3/PB7i00+/69DHCBpoF2//WjzN//0Dfe9VcLAQAtXnejCZ/K" +
       "SwLoOVhCAPPf+uL6P3/1tz/x6wd7oYlKd/qBFwHN0NT0mM+8qvSyc/gEE75h" +
       "TxIwGTYYIRecp2au46mWbkmyreWC+n/vfX3lZ//H++7biYIN7hxJ0ptfeID9" +
       "/Ve2Sj/6y2//o8eLYS4pucvaw7ZvtrODD+5HxoNAynI60h/71cf+wRekjwOL" +
       "CqxYaG21wjCVChhKxbrBBf9vKsprZ+oqefGa8KT8n1axE6HFdeX9v/7Nl/Hf" +
       "/FffKqg9HZucXO6R5D+9k7C8eG0Khn/4rLJTUmiCduhz9A/dZz/3XTCiCEZU" +
       "gMkKxwGwM+kp4ThsfeX23/zFf/PQD//KbaUDsnSX7UkqKRV6VroTCLgWmsBE" +
       "pf4Pvm23uMkdRxY6LT2P+Z1QPFJ8uwoIfOPNTQyZhxZ7LX3kT8e2/OO/98fP" +
       "A6EwLjfwqGf6i/CzH3uU+IGvF/33Wp73fjx9vu0FYdi+L/JJ5/8cPHn1lw5K" +
       "t4ul+5TDGI+X7DjXHRHENeFR4AfiwFP1p2OUnUN++tiKvfqshTkx7Vn7srf5" +
       "4DpvnV/fdcakPJKjjAKVu3u3GLvPkyalcAK7Nc5JutYDIZmhBQ/83k9+4o9+" +
       "7F2Ng1ygr2xy0gEq9+3b0XEeSv7Esx967Hs++DvvLXQ+1/h80B8spn+iKJ/K" +
       "i+8t1ve2CIS/sWxbQL+uhkVkGgGWLFeyD23Dn4PXJfD+s/ydE5rf2LnyB4jD" +
       "eOK1xwGFD1zd/TO2M73OMjjRuT6mr4Nv5wsRE1gOMH6bw7AKfscDX1197Guf" +
       "2oVMZyXmTGPt3R/8239+7X0fPDgRqL7uebHiyT67YLVYkpflRS/XwSfOm6Xo" +
       "Qf7hZ97x8z/zjnftqHrgdNjVAbuKT/3H//flax/9nS/dwPdfAdoXRDs/kZdI" +
       "Xrxth2/tpir5V04LTB0Iyr2HAnPvDQQmv8DB7YP8gr/JaueXZF5084IqUOhF" +
       "pQfHrX6H4K63xjO63aO74GKRV43P0Dx/kTTDgNYHDml+4ByaC7re/uJovpvl" +
       "puNB5/q81+aoGxF7/QWJ3S3/JeARryDXsGvl/Lv+4qh4eGkrTx2pAQ+2ccDa" +
       "PbW0saL/K6KTyrnb+5whsvcXJhJI6T37wYYe2Ea99/ff/+W/+7qvAonrH5mD" +
       "vHULqDz/nn9W/eP8i/fi+Hk054ctAuShFEajwi9r6jFLwxNEMxHw7t4FWIoe" +
       "vkyhYQ8/eg15mahOlMrCgeJqUF8Lmo705cZqVYmEvrbo1I2eJbNzWXQqfmeZ" +
       "edtB2h1VtEARtO0k2ar1eaWTaa1yc+K0k1raJjp+07GZNiso3eoI9WYu16cW" +
       "xEAjujV/Sq3KBMFO6TG78lCEmNidoUrDMKw5YpXCvGwdrqNtLa55WFCFYR3e" +
       "wOsmVmvUfbrs0KLYn6+DTgdBmpNBs2uHHNaPuobjz9ZzerJkzHi24csOXNXp" +
       "+hatpLNl1Kl5tX5lKYphbDim5IkSapUH/YDsdxCHNyC7q22nYmUwdMwRO6tO" +
       "I4tIJ8G4lk4q/MqcV7lROpGxfntEdx222x7zq2m2rHJCa2oHbNJxWKU2DAlS" +
       "qvoNO5xzOhI3yguttnaZ9kJQokTNkMFqJAN0fYIdS5KXyVMr1KUGK6GJSvEw" +
       "H/GiEYuisIbqiSAaYKR2Z8IGlBOhtWavKaBlxXAd1o+dkYXolVk5WvQRw+Gm" +
       "geJXymtKVuN+rbHi56ssa46FlSyVR4jBtlZVwuvVy7K1MXQD45V45LvCpk11" +
       "1hXTS0YjechyDXbCdV2lHzGUNhEGTSWbuwulK/HKzG/xLOnZKJYu+l4F1sqw" +
       "iZLzldAzkAHttcNshHeMcreLk3idWfXpdTbmPHFlltdcS8Sbk1mNnNUEvFlu" +
       "IPNVNFvZHuOrSLtlbp2246YjMouFaa1Nb0f2iE421nIxIMMNFHT5uT0cWfVy" +
       "n+fZodF30TE+Snlj28r4yRgOh9ECI4lqO2P6xhIdjGRZxXHIlOgyJjokKqzt" +
       "NYfipE9aa4u1PWQ8IdY+MjcloTwmHCMLLXY26PYjlulBg1lMzdhRG9P9Dimz" +
       "UiJQ+NBLQqItL+0uMbeNqZNxI1iGZUVldCpiK5I7YvFakvG8NoVJd7puL7i1" +
       "X2dmfhenvJgJm5qL+b2FPp4mbqvlbYj2ZC7LWGoJoR7LwwrWHltbtcfKC59q" +
       "2gOxrYTuNBagKMsqWCisxQGjlYky2W823LGsZUwQO8wcws2KLXg9iyckPZOZ" +
       "JqfDsj+FDFnhBlunyQ1i35Nb28p6teGB7Hb9WLTXlf5E2C5YrstzQ58ym3Td" +
       "aUMYa830blmtcjNvncn8YNOYSdUxnGi9qdfpTJYTDjOBVFJ63BYcuqHHjcnE" +
       "9M1eFJpa2O1tMHSYjbAVwtTHncogXE98x8fCUXU+q5bXRJquWvJIY3v1dgWq" +
       "Debukm61xHHdmVUGHq4uKwNUGIn8yLYESnW2WtsctKMevhz45nSs9mt2N9BE" +
       "IukaRGPoBOHADvokv2VmVF9iass1NlyidRgfm+x6CdEmZnhdomy2jCiZgf06" +
       "3WGrEdkbjgTKEaClZTokpBqUbSCxqkt1Q2hGG62arC1/0p+Ps27Y7vjrqAFW" +
       "w3YCeBmiuj1qVLbtddLQGwin8AO1HyLslhqwltldJo2MGNaGVUQT6lrCEss0" +
       "bPOuaeG4sJnVVL9lp5M5kSVrlQs6Ta5TQ7ejZqWV9ExOEpa9BuNzK7eWNXV4" +
       "MKZEqD5eYZYeaMykKeFpYxjrGgiXy/XacL6Mfc1AKCpouhxTpdSpmsA62WH1" +
       "BqnznS4vkBUW720xoqF7i3LKtKrtQEyRroYLiMB2W0N0Q8tGt12HyzGGSn3W" +
       "poyJVlEqKavM1i1oLMqj7azfLLuLNiRDTKUx68U1qWsOUWY9kRdug0TCRdc2" +
       "4s5mPdJMaWKEGt5OykJaxbKk0tRTiESS1bzdb6DMjJZjhSd7QX8FTLi4kCcq" +
       "za4pdQDrVR0EqXQCR7WlNxzy0qIb4HSWsmjfNwmDWW23zS1UXm9cDksEFZ4r" +
       "q6nTXXOjRPTBwkNcZ7DsuZMVKiiD6rDjGjWStQw0mEaVcou0eZLs2h0fiUSY" +
       "lrJazXP1Kl32AEJkH0WdBbeq4LpeE8XqqryFhQYczTlLcITatCIsxjKhKs1t" +
       "faEIYsDq8WSpN/TtkG/W5kuvO5ngSlCfKR6dLToG2kb1MWIoEUyz0KbdnDY7" +
       "vbBi2zoMs7KTCVK3toi0Tbvlpuhis4g5BYpGPladblZoinhzUghG5TY041sw" +
       "NiXDUDKqOu9qSC3iR00N9/z2hOx0h8im4sS41NhidkhuFpVhtbFhlUV1Iyqk" +
       "YG96S5pfKH64CiwV4GSg9ETC65BEb7FGh+vWVjA/no0crhd3h5TVxrNyxCxU" +
       "DU24pdDC6rX6OKy6XAq5Viz15kZY05GgTFMYRURMZldlPWbJNowFGQtrdOYS" +
       "UOAnZiqDkN5gNhrYf8lNNErMDAv9gd/KWvCK6c+SRsiq1UYrhjeQyYVVETiZ" +
       "FWbYTQSqbNEM9uGUlxdwl1Ark/p0GvmMQYkDaVIOVSPkGGXZX7L9abOpoyvO" +
       "mYTYZA7I2Hrb7bbdChCxm3ImZW+WsJjheCUezRJrO+cqMjesok3OSyhrTk4t" +
       "cmjNsd5cZmYyg5GLWhWFpwgle9YSUqej3jjG2TUjB5ZGxbqou8N1VVTlqVuF" +
       "xtx2WyczTtoKGuz29SCUzcEaH7SbMzJu9UVR6TJppY+02J7nrCckExEWIcwk" +
       "KTKaIORpME1qvoo9EdNQ2WSqcJIaeG3VitMeja9RqLXoQ8mq0VxDCMS15QWy" +
       "IWYIFnQmVHmOtZLGaoMxy7TqaLVKHaNmbczzxmG/0gLuje0uZ5NlMoWtYaLP" +
       "YI2gllAHX0mNsj9GaGU2M8QyDxwChxoT4Asb9Q1Guctm1MKNNQ210g2XlBUY" +
       "Gi2o6kzrUqnsL1WeWmNQeVkxawRFpEhvoQReGdDNyU2o5rSBNCfJbEysEREm" +
       "ozJpNTiOgYONmALO4FSxeDZuLTMum3hxvyL3Uk3GxLLWi5hubDqwXq5kFUId" +
       "4LI90Ms1TlawCYZiWmdshVXUX8VqebGce0pEdVC6h1GVER5aVpeu4akom9wa" +
       "MeFgaNMQxBitNeIQAYhk+lBjIM8BO1QX7k68pC3DcQIRxhxmZ2HPSXrTWK6o" +
       "DhaxRnmswmKMNV2hKo9E2RXNilLHhZFXbs02hDSqIutReWq4lCPDTZhIBaRF" +
       "jLetRMY0BPa7ESZuFmTCZk5/i1v9xnomogEzSctWEziwzcQ3y2OtDxOD5sbT" +
       "eNpobnEy1qtWaou8PFFQ0WOsGkVg3pJTu1UhWy+GNDXflltbsAXhQ1upRBjQ" +
       "lCnadDUTavSdmjvAiBBY2jKarXnObvMJNGX9MTvcRBt04/XkzK6LGsQu9KY2" +
       "x8Tt2DIkPZrVUzGkYBsdwfMWHFeFQchQVVfPEnFDuWHkrELOF6gZvmZheo3M" +
       "IAUJanMmZVaO5VnpVAw38AqLdLeRleuTUER8qI0N6l67i9JWO0BV35Ia2dzr" +
       "OyhhxpalJmXclqdkp5OuhpM6E9HzcOF4gs8sMsEZMT6Gc1xd0BWsTWZjtrqI" +
       "U6iVLJe8M5jXN5NUq/e3KIRWNnJtraeUSgz67a03gjfZhGp0OoveGNn0aHuy" +
       "JUbCkiWGPNoJhFU4D/o9dWNluL1pqhN23kaGqY21ViY2YeQeVdM2YTU0olqr" +
       "ApWtllmt1zMXDqm6U2k0h+u+v5YSJ6QWSGNkAwupLzms6sS9nqo77CKpzmvL" +
       "CQPrehMbN1sR1VeNOFq11GbayTA+IjuCxGgDSenAVqLB6KQewdDAXa5hiA5q" +
       "mzU5iRodzMo6UQziG3TBBdV6uqG3cxOzmQCXGBEB4eKyqqFxVakiWNTaNltg" +
       "pI68RhfaRIQprKdgDSqs1AQvXdiMbm76dpMdVsaE7KVJW8fktZSZ7na8JeB+" +
       "aM99kbalgZn5JMIoYpKWM8xoRo1mWmbqi3U3nNmxPXLpSJgxPCUIgj4oh4ne" +
       "CbfbZOZvt6vFplNOKYSWuc5i4YaUwXr9+XSWkcKUod2kmXFpbcRzyaZqGM1Z" +
       "gm8ydRwx6CgQIt/znVQZeekyanHlgNG7jsExycxgrQBpp3jMBIIILxNIY2Kd" +
       "aM5xCiWXQczJc5JXwu4iXZLlTdvcZPA2WaAqrs7kOZOxKB92WpmPIVqlQpEm" +
       "JGW+rQ8qbBYZ3Qo6iaAyJ5bxbDluzSWsPDe0iTOsbodQamBTbKShHZ6oVysz" +
       "3A9DxeeikKjOUblNkDMhQxB2Zo9MlSFMKyASJaWNeNgl6G1vslBYoiryeOpO" +
       "4cDGvSzVBjN2Qk2b7aZNMJUJ0h2NvJZL9OI6Ox6TVtwm47Usax4ikpUejrCN" +
       "1aBO9kLHaE3Y7sIJy11oXR204imt8gPH5uZUPYwn/W1Z6Fec3hbeduRYbI5V" +
       "qwy2cKKhTziyMbTR2KHgMDMsQVE4Ye4STktccp0hn81MiTNIa0g0lyC86LX4" +
       "BlNZWlVtjPBcdUkMcNZajyV7HQRJLHmoFCQ2h5YxSEghFW0vIQns6GiEThl2" +
       "PEza8Sq1pmSCsBuFWdti1jb6S3GWrZCwxcXoPMJnG4jHx/7UwvstiVsH85Zq" +
       "6xg1STZ1r6ckIyb0rT4metZiU5Nsp45oMqV3PbLZTgW5qrfnfhYjHbSbkhsc" +
       "rJi/stiE9BtwEERVb7uaLnx10KaF9sLoVeUJbTs9L7XiUQ0ELGpNhrqT6tRr" +
       "1VI0VJdtaG4AN8CMyE4glsvoQtgaAV7x/Ao7bY0jdDEDJk7ujmb+osN3wlE0" +
       "DkdTZ7YddknaXXfUqDbSa+veUKjidjQikZ5I12G1b7sY5LhzRBm3Vyy2rSMh" +
       "bE9XqFTj66oozolNCjR2yNE264Lxoe5o7icdddrEHFS3ekSl3LRGIGwY6Hx/" +
       "SZJcB2iyq3UturJqNdu4shJnBtqMkaALLdoyMqTD+bCsmbXZdrIIG82uwIi1" +
       "IYMpC6EWz2wOD0g4XFS3dKqFW1vweTohYDbh6QYfjjedng/7UIabWg3KxhMo" +
       "8+bT1PTbLLbSYIedkENSx7bAcg4oeLygPcsSNZXhWCYVqpsO1dZQJMlkpbMc" +
       "jYR60LSb1mKwbC0bWDsmYrwuLsa6FjS2/GrW4WFy7CBDF1AY1lvN8VTZCl7F" +
       "aKQj03Lr2HY6QFbLrSnik+lCiCp8b6yK82Z9Wy7PEnm8mrDLLs62yy6vNbkm" +
       "0oISnCKrruQ0BuUeP4ToVFXMhtALl/O1uFoZ0GzSWa0m03jT4PQQ4iEMrq6F" +
       "kMQ23YjT24qUTf3xei11huYaROIoh6tlWNDJ5tSXW9q6y1GNKWWymUKxRr8m" +
       "jnhzOFxPVyQH94V2ZgUg6CP5jNc7Q8uvuCSrthue4Zq1iZ5OWvUVlEAtBa/M" +
       "dbss4RBftifDpjFZEIa87sIiSUODVjTfdvyQ2DYVq8EkPBlrrglpgc2DgFXT" +
       "QFgILOi8UWvgmT0eVUJUK/dICqLSedPoK94iZm2V3o4H/WWnHtJNS22lGEZx" +
       "pobRLHDxFNaFEhOEwPQGKHEHZTZLo29m0Lg94qBkZLLtqIFkakIZXCilnZi3" +
       "IrTfGQwpMrDd2CK6U605seLueLT0640Grrpp3BpMscSKNIyFU9Y2Mx1gPOOR" +
       "jhq0BwGG9e3NOgrXptlVxPU6JhIisgHigRf4ALeylTRGcWNVz6pQuthQ9YFl" +
       "zRaNoB0jFrvqDgk3GLXivoBIOA1UFnCN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "sf25hz///f/kmd8u/mj//wEaQ0X4C0sAAA==");
}
