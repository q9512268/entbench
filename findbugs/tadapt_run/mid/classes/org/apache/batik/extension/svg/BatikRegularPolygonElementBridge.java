package org.apache.batik.extension.svg;
public class BatikRegularPolygonElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikRegularPolygonElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_REGULAR_POLYGON_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikRegularPolygonElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            e);
        java.lang.String s;
        s =
          e.
            getAttributeNS(
              null,
              SVG_CX_ATTRIBUTE);
        float cx =
          0;
        if (s.
              length(
                ) !=
              0) {
            cx =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  SVG_CX_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttributeNS(
              null,
              SVG_CY_ATTRIBUTE);
        float cy =
          0;
        if (s.
              length(
                ) !=
              0) {
            cy =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  SVG_CY_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttributeNS(
              null,
              SVG_R_ATTRIBUTE);
        float r;
        if (s.
              length(
                ) !=
              0) {
            r =
              org.apache.batik.bridge.UnitProcessor.
                svgOtherLengthToUserSpace(
                  s,
                  SVG_R_ATTRIBUTE,
                  uctx);
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_R_ATTRIBUTE,
              s });
        }
        int sides =
          convertSides(
            e,
            BATIK_EXT_SIDES_ATTRIBUTE,
            3,
            ctx);
        java.awt.geom.GeneralPath gp =
          new java.awt.geom.GeneralPath(
          );
        for (int i =
               0;
             i <
               sides;
             i++) {
            double angle =
              (i +
                 0.5) *
              (2 *
                 java.lang.Math.
                   PI /
                 sides) -
              java.lang.Math.
                PI /
              2;
            double x =
              cx +
              r *
              java.lang.Math.
              cos(
                angle);
            double y =
              cy -
              r *
              java.lang.Math.
              sin(
                angle);
            if (i ==
                  0)
                gp.
                  moveTo(
                    (float)
                      x,
                    (float)
                      y);
            else
                gp.
                  lineTo(
                    (float)
                      x,
                    (float)
                      y);
        }
        gp.
          closePath(
            );
        shapeNode.
          setShape(
            gp);
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
      ("H4sIAAAAAAAAAM1Ya2xUxxWeXdvrBwY/AEMgGHAMKq/dEBIQNS0B8zKs7ZUN" +
       "qDUNy+y9s+sLd++93DtrL6YEiNSAUIuiYFL6wH9KlDbikVaJUiUKomrVJEoT" +
       "BI3aPNSkVX8kfSCFP6EVbdMzM/e1dx8EpT9q6c5ez5w595wz33znzJy/gWos" +
       "E3UYWJNxlB4wiBVNsPcENi0id6vYsrZDb1I68adTh2/9tv5oGEWG0JRhbPVK" +
       "2CKbFKLK1hCao2gWxZpErD5CZDYjYRKLmCOYKro2hKYrVk/WUBVJob26TJjA" +
       "TmzGUQum1FRSOUp6bAUUzY1za2Lcmti6oEBXHDVKunHAmzCrYEK3b4zJZr3v" +
       "WRQ1x/fiERzLUUWNxRWLduVNtMTQ1QMZVadRkqfRvepDdiC2xh8qCkPHc02f" +
       "3n5iuJmHYSrWNJ1yF60BYunqCJHjqMnr3aiSrLUfPYqq4miST5iizrjz0Rh8" +
       "NAYfdfz1pMD6yUTLZbt17g51NEUMiRlE0fxCJQY2cdZWk+A2g4Y6avvOJ4O3" +
       "81xvneUOuHh6SWz8u7ubf1aFmoZQk6INMnMkMILCR4YgoCSbIqa1TpaJPIRa" +
       "NFjwQWIqWFXG7NVutZSMhmkOIOCEhXXmDGLyb3qxgpUE38ycRHXTdS/NQWX/" +
       "V5NWcQZ8bfN8FR5uYv3gYIMChplpDNizp1TvUzSZ46hwhutj5zYQgKm1WUKH" +
       "dfdT1RqGDtQqIKJiLRMbBPBpGRCt0QGCJsdaGaUs1gaW9uEMSVI0MyiXEEMg" +
       "Vc8DwaZQND0oxjXBKs0KrJJvfW70rTl5UNuihVEIbJaJpDL7J8Gk9sCkAZIm" +
       "JoF9ICY2Lo4/hdteOR5GCISnB4SFzIvfvPnw0vYrrwmZ2SVk+lN7iUST0rnU" +
       "lGv3di9aXcXMqDN0S2GLX+A532UJe6QrbwDTtLka2WDUGbwy8OuvH3mW/C2M" +
       "GnpQRNLVXBZw1CLpWUNRibmZaMTElMg9qJ5ocjcf70G18B5XNCJ6+9Npi9Ae" +
       "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" +
       "U1jkOzzyhsH3/FusOfdffPsGTPUZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
