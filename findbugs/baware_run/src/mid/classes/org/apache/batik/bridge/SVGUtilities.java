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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5PubJTlt9Ns8jMFtBJ0nw1kz7ep8za32");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Q1/1171BqhNpU/HcUEfK8TrWQs2oUlh/qZtgB2MOZa/TtqcjPa2V6cRv64IF" +
       "kd1Ndd1LlsxgijfEakSVhKHe4UZJJ/HmcZI2idFIoAQ8VogSXCaAQYoWthfM" +
       "ugKOGykV+Wa9LDNcu85Ufbu4HOJYVY4G64CfzGuohW8scdqolOpDAzJ7w1nL" +
       "UtRwUl6q5sAZ0PVNWm84bFjWOxsCDy1RFmgJH0b0HEhbiR8UlSXnJ3qfpqVE" +
       "Cv0Y9asgzGWRGRS1wtai3xG9pDzq6FDUD+WY0wUgwV2xIgmyD8JkYzSxk1Gr" +
       "OEjTJrpAJ8mEac/phQm5OrZpbGI/xUO3RNSak8pSZfxlaQy3wlraggZrk6gN" +
       "QPhakQx4YrdqyKo5KZH9qufUwDaK8ylvOhfCIo4ZVFEMg7gpUjygsjxoxUYn" +
       "lI2SMRzDc4101s14tQk1dJqM1jjY3wVCVV45VXtSRkrLvtuRK1a7WcbK61qc" +
       "pkVXVLmV0hinMwyEGomnSrDDFVtQNeT5YleOeBt3OKq+GGhrVd109ZGlQKWV" +
       "vKEDuysNRHduFTsO5M+d2chbydSmDBbIY2dcHDraWDTVjlelXGLBx726yyAz" +
       "rWzo3mBereGTxICXsOmLeC+CCVxeBs1+qbyh7XpU4xeDciexl+pypEg9teLB" +
       "lYmb4hbUWSoKDJPNasMvTmCmiYCtUcfRiCaCIG/OfrreXN9P6nfnRwSHeVQL" +
       "q5FVLK/jV/Pk9Anzk55uWLhVlILQF+Vwd5qfv7JTomOJOUdP83dHvHsHZxWP" +
       "Pi9FJT/cYqe9w2y6g6avu1Y2S8f3Xf+weXa09tC1srLyY7Vn3v3U0wr9y/De" +
       "/qH7KCzcFrreGy11rVpHiHwlGOmJax8hDvOktN1h8Bff/d8enPyM8bbryHJ5" +
       "9Qk6Tw75T4fPfrn3OvmDe4WbDo+Gn5cud7zTk8cPhG/31TDyncmxY+GHDtcs" +
       "SzIpPAHe+P6a4SdPzHYicw1ZyIVvK3cnEhsu7CcM7a/fvdn6xRX5iuLaV7L8" +
       "S9UJ834fPiMh4h9mxd8LC3fpagiwA132e2b3P7IT5Q++0AHQ0YHzG+8/DkJW" +
       "P9kHYfLigfDQURCCtZ5J+vYEPc8eyVo9cwYcn8yKfxQWXia7zlr1w2O9gbi+" +
       "9trimqeobA+wn/7EY199x9OP/WGe5XGrGUxFH/H1U7IZj/T57rPf+PbvvPSh" +
       "z+TJUDdLYrCVp5NpoM/P8jyWvJkzccdx5F8N3j+1j3z+eaNT7MAgdpa84/oI" +
       "uMp18sXJ5bvWRMlpx5gXNcsVw1PlJD+s/HRyoZCL3xdeSPAOrf4lS3X00Dht" +
       "tpvMrco86yWHU+4dN8X37k56Uct11Cwz6qBumxxoulcOM4hBZXIq8e/fEp9P" +
       "djrleW5I91RtOSrrv3lG3Rez4jcAiHJG6ZaxM5r/230jkJuKXzqHqcgzDH4a" +
       "vJV9gVVuvKnIPXXe4HfPYOnfZ8VXwzzr6JglyO5/bsftvzsHt/cdqKS1z631" +
       "YnL7jTO4/cOs+HqYZRofcLufn5RV/OqO3f983sV9HLzX++yuX0x2v30Gu9/J" +
       "ij8J87T7jN1xZktOLOyfnoPTVxws7Hv3OX3vjef0wHQ8eIrHO+r9f3gGDj/O" +
       "iu+HhTuB98fUQPZN7yBhdblD4n+e1/dnCv2JfSQ+cQOR2Nu1+sgBHI9cK4rl" +
       "AtVH9H1ULly8NioXbssK4CXvBC5GNg77nWb2b5Fc11JF5xCsCxfOAdZD2c2s" +
       "/vf3wfr96wXrp/9SYC0PteTCfWfg8EBW3A2MwiEOJHBekahnDuHCS3Y833Ne" +
       "VSmB9w/2ef7BDRSQm/NWN+cCsmP8QFReey1Raecf+//0yaF49AyYXpcVD4WF" +
       "+4ESoYZoOpnvRsLQN6UoVCn2uDZdePi82vQ6oPylbd/t5w0C69I2OXiH0/GC" +
       "PoDtjc+Dzcv+OuVf4RwzzNP8g8D1Hz8KX+kM+KpZUdzZYsY193UNzPXyPC4S" +
       "4/CKrgLzlteVsR2YbzivO3otAJHdB5N9cSTvCIQZyXDO9VvOQKSdFU+GeUJz" +
       "hgiZR51Zy517uvCmc3D+cHYTAhy7+5y7L6LOnWGZ9XV4peeLnmHKAeUquVl5" +
       "LIeAPAMeJit6u1hlKAbLsaof/BIAZnrFcakZgy0HMFyWelRy8PPiVwa4fXof" +
       "v0+/mPhl1A530PzcGdC8NStmu+0rI4Zgt+hs0cnqxjsA5ucAIP856hHA+Pf3" +
       "Afj+DQTgqFffsW2cwfYiK+RdrN41LcD2eLu7enbHsnJe09sEdL1y23f7+SKt" +
       "+aHJ2Gc+PIP5dVa4YeHhkxsVOo/lRGv7Le/7qUN28szt+89i50CZLu+2rd1s" +
       "R+153m6zd8E7B6T3ZjeLYG50nwb0J6hGf/MMSH8hK94RFh44Jk+5bz9Vld55" +
       "DhAeyW6+EfDz3D4Iz10vCGfEfLfmrW49JlIn/VGOyXh16Jk+cAYwH8yK9wFf" +
       "DRy76iingvF3zgFG1jTbIe79aB+MH91AibiYt7p4ikSMd2LxsTO4fzorPhIW" +
       "XgUCvbYYqFuxOPxbyalofPQGoHFTa9t3+3mD0Lglb3XLMTROQnIEl0+egcun" +
       "suIfA1yOqcvZuDxzI3D57j4u372BuByJgl8Aki+cAck/y4rPXh8knztvLAus" +
       "yM0PbftuP28QJC/knZ47A4h/lRW/BgL5fI+Auq6vgA1SqLJpEKp2boR2CPyL" +
       "8yJQAWTW9hGo/QQR+MoZCHw1K74YFl6ZIzAU/SVwJWfj8KXz+hNQfzO1jwN1" +
       "vTic4U+OGI2z/cnWlfzeGbB8PSt+d7fJOVUlvnYOIB7NboIg/eZf3AfiF3+C" +
       "AvHHZ3D+J1nxjV20OvFFJ8j+w34QcT10fPuCaJrpqMdb5eh887zoZGLy8X10" +
       "Pn4D0dlF8Be+lYtEzvf3z8Dkf2XFd0BgEbrbv+q2225e8a0du//jvDu2JwCb" +
       "n99n9/MvDrvjHbt/fm1297KZL/zoFHaPyP6fndcYgsj65i/vs/vlF4XdI/uz" +
       "vdvPYPeOrLgYFu492KI4ohcYbjgxt+fou5819i5dD9dJ9o/RI4/ayB4a8MDz" +
       "HuuzfRSN/JmnL996/9Pcf9wesB48LuY2snCrFlnW0f94H7m+5PmqZuYw3JaX" +
       "d3o5R/eGhfuv8ethWLi0vcjI3btn2/4+oO4n24eFi/nn0XavCAu379qBobYX" +
       "R5u8KizcBJpklw95BybjyF9StwKVbM8HHjgqH/mP+S/4W+1hl6MPo8hOu/PH" +
       "Kh0kUkTbBytdlT/7dJ/6+e/Vf3n7MAzZEjebbJRbycIt2+dy5INmyRiPXHO0" +
       "g7Eu4a//8Z2fu+21B4kjd24J3snqEdpeffpjJzq2F+YPitj86v1feNM/efoP" +
       "8j/M/39Ljl5z70oAAA==");
}
