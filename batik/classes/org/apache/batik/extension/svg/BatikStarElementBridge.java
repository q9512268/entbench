package org.apache.batik.extension.svg;
public class BatikStarElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikStarElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_STAR_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikStarElementBridge(
                                                            ); }
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
                ) ==
              0)
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_R_ATTRIBUTE,
              s });
        r =
          org.apache.batik.bridge.UnitProcessor.
            svgOtherLengthToUserSpace(
              s,
              SVG_R_ATTRIBUTE,
              uctx);
        s =
          e.
            getAttributeNS(
              null,
              BATIK_EXT_IR_ATTRIBUTE);
        float ir;
        if (s.
              length(
                ) ==
              0)
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { BATIK_EXT_IR_ATTRIBUTE,
              s });
        ir =
          org.apache.batik.bridge.UnitProcessor.
            svgOtherLengthToUserSpace(
              s,
              BATIK_EXT_IR_ATTRIBUTE,
              uctx);
        int sides =
          convertSides(
            e,
            BATIK_EXT_SIDES_ATTRIBUTE,
            3,
            ctx);
        java.awt.geom.GeneralPath gp =
          new java.awt.geom.GeneralPath(
          );
        double angle;
        double x;
        double y;
        final double SECTOR =
          2.0 *
          java.lang.Math.
            PI /
          sides;
        final double HALF_PI =
          java.lang.Math.
            PI /
          2.0;
        for (int i =
               0;
             i <
               sides;
             i++) {
            angle =
              i *
                SECTOR -
                HALF_PI;
            x =
              cx +
                ir *
                java.lang.Math.
                cos(
                  angle);
            y =
              cy -
                ir *
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
            angle =
              (i +
                 0.5) *
                SECTOR -
                HALF_PI;
            x =
              cx +
                r *
                java.lang.Math.
                cos(
                  angle);
            y =
              cy -
                r *
                java.lang.Math.
                sin(
                  angle);
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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GHkl7/0r/smKd/4NlB21jagaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fUJLS322MfUSZ1IvashUDxoRKw0TBqmujKnZNsm4Xyop0dpsieZCsEVTHGjl" +
       "QQNZYm5FcxiVKqczPMRXIuKTauJz06a2WEVtNIzC6pShegZTLA2wtYAMUWvS" +
       "aMymitHqlF1EIKnBKOLdDt8Y93mhu476xUF/0sXdVSNqDrTVnOclBxOnTafd" +
       "krtGi5z0UvC+pbdccx22ZAG3PaPQFyo9fhqOxZ4E12ZNay5vxqEoSNNxg5j7" +
       "xUg3JATG126pwNoDnVXjlhK1iyIeisp4NWQKRrdIdEakFrKldRdmNMUtK76I" +
       "biLTaS5mnaYpFyJVn64409ZLG3qqK1h52l8LA0pnyjgtVpiFmM7YhR2Ux3qb" +
       "aM0V3hx4bVIf4JV5ITBnqIUIcAvofOOMHGHi1cas6uLWhKsIWsfqk8W51qMW" +
       "JMq1Z+MqgSplWzajmdwB43Z5jAynFRaxZxTPA4eB24UK1ai4ZjdwK/hmXPG8" +
       "VJy2hOoAWzSSTrEV14rtXnXYhXExHbmUHhK6pfVWNIEPiks2sik9LdSKUb9T" +
       "6S97fj+O2qU5gtNs1W9EYjPs+d251GvosjrwCbe3mBPDOaEXOmFJldGWxnIj" +
       "xq61uzzD4a02SRJwmfDb9ACt6yO10QmTuIN1qTAxLNF2O2nftbhVuc7H9cHG" +
       "JRrNjdilRWB0uxVVlh2s1SksWyq6bGhEO+YUUuVay8GoKjbtVpNudebFBhH1" +
       "FyWhIm4Qa6YmXTsZ9bCYG6GFRa3rSW5vEmD+vO2XSEfsB3V+SNNIqdabr6lu" +
       "TcUn6WTAjxc64xc7aach+GW5MhulmjH2EcOyWk1gMUerjAle86ZDLQp41qlg" +
       "Y70+ZgfYdBWpK0/chKQGgkWFBwSux8PyehaX5nEDl5I+TqDd1qRbLZEIi1nh" +
       "LJbX9TY+oEVluE5iRFpawUL2fLU35NBOymx6Ir5exZXZcsjjDsr2MHrjTeR2" +
       "UFZSPmKkaVSvNEwEjtdVvDleFYde2pu7/bYWmonp+5pIxilXFBSbFdUiKbaH" +
       "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" +
       "++lv5hcs/wt9hm986CUAAA==");
}
