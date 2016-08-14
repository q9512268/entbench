package org.apache.batik.bridge;
public class SVGTextPathElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public SVGTextPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_TEXT_PATH_TAG; }
    public void handleElement(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element e) {
        
    }
    public org.apache.batik.gvt.text.TextPath createTextPath(org.apache.batik.bridge.BridgeContext ctx,
                                                             org.w3c.dom.Element textPathElement) {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            textPathElement);
        org.w3c.dom.Element pathElement =
          ctx.
          getReferencedElement(
            textPathElement,
            uri);
        if (pathElement ==
              null ||
              !SVG_NAMESPACE_URI.
              equals(
                pathElement.
                  getNamespaceURI(
                    )) ||
              !pathElement.
              getLocalName(
                ).
              equals(
                SVG_PATH_TAG)) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              textPathElement,
              ERR_URI_BAD_TARGET,
              new java.lang.Object[] { uri });
        }
        java.lang.String s =
          pathElement.
          getAttributeNS(
            null,
            SVG_D_ATTRIBUTE);
        java.awt.Shape pathShape =
          null;
        if (s.
              length(
                ) !=
              0) {
            org.apache.batik.parser.AWTPathProducer app =
              new org.apache.batik.parser.AWTPathProducer(
              );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    pathElement));
            try {
                org.apache.batik.parser.PathParser pathParser =
                  new org.apache.batik.parser.PathParser(
                  );
                pathParser.
                  setPathHandler(
                    app);
                pathParser.
                  parse(
                    s);
            }
            catch (org.apache.batik.parser.ParseException pEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  pathElement,
                  pEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_D_ATTRIBUTE });
            }
            finally {
                pathShape =
                  app.
                    getShape(
                      );
            }
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              pathElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_D_ATTRIBUTE });
        }
        s =
          pathElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            java.awt.geom.AffineTransform tr =
              org.apache.batik.bridge.SVGUtilities.
              convertTransform(
                pathElement,
                SVG_TRANSFORM_ATTRIBUTE,
                s,
                ctx);
            pathShape =
              tr.
                createTransformedShape(
                  pathShape);
        }
        org.apache.batik.gvt.text.TextPath textPath =
          new org.apache.batik.gvt.text.TextPath(
          new java.awt.geom.GeneralPath(
            pathShape));
        s =
          textPathElement.
            getAttributeNS(
              null,
              SVG_START_OFFSET_ATTRIBUTE);
        if (s.
              length(
                ) >
              0) {
            float startOffset =
              0;
            int percentIndex =
              s.
              indexOf(
                '%');
            if (percentIndex !=
                  -1) {
                float pathLength =
                  textPath.
                  lengthOfPath(
                    );
                java.lang.String percentString =
                  s.
                  substring(
                    0,
                    percentIndex);
                float startOffsetPercent =
                  0;
                try {
                    startOffsetPercent =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          percentString);
                }
                catch (java.lang.NumberFormatException e) {
                    startOffsetPercent =
                      -1;
                }
                if (startOffsetPercent <
                      0) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      textPathElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_START_OFFSET_ATTRIBUTE,
                      s });
                }
                startOffset =
                  (float)
                    (startOffsetPercent *
                       pathLength /
                       100.0);
            }
            else {
                org.apache.batik.parser.UnitProcessor.Context uctx =
                  org.apache.batik.bridge.UnitProcessor.
                  createContext(
                    ctx,
                    textPathElement);
                startOffset =
                  org.apache.batik.bridge.UnitProcessor.
                    svgOtherLengthToUserSpace(
                      s,
                      SVG_START_OFFSET_ATTRIBUTE,
                      uctx);
            }
            textPath.
              setStartOffset(
                startOffset);
        }
        return textPath;
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
       "vv8HirXMsW4iAAA=");
}
