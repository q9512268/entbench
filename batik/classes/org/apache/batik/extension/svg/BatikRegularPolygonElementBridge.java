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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYe2wUxxmfOz/w+8X7YWPA0PK6AxLSItMktrHB5GxcG6zW" +
       "NBxzu3N3i/d2l905++zELUnaQqmCKCEJTRukSo7yUAhRFdRUaRBppCZR0kpJ" +
       "adK0CqnUSqUP1NBK6R+0Tb+Z2b3d2/MdpSqqpZ1bz37zzfd985vf9808ewWV" +
       "WSZqIRoN0QmDWKFujQ5g0yJyl4otazf0RaVHS/Df9l3u3xJE5SOoLomtPglb" +
       "pEchqmyNoGZFsyjWJGL1EyKzEQMmsYg5hqmiayNormL1pgxVkRTap8uECQxj" +
       "M4IaMaWmEktT0msroKg5ApaEuSXhDv/n9giqkXRjwhVf4BHv8nxhkil3Loui" +
       "hsgBPIbDaaqo4Yhi0faMidYaujqRUHUaIhkaOqButkOwM7I5LwTLn6//+Nrx" +
       "ZAMPwWysaTrl7lmDxNLVMSJHUL3b262SlHUQfRmVRFC1R5iitogzaRgmDcOk" +
       "jreuFFhfS7R0qkvn7lBHU7khMYMoWparxMAmTtlqBrjNoKGC2r7zweBta9Zb" +
       "4WWeiw+vDZ98dF/D90tQ/QiqV7QhZo4ERlCYZAQCSlIxYlodskzkEdSowWIP" +
       "EVPBqjJpr3STpSQ0TNOw/E5YWGfaICaf040VrCP4ZqYlqptZ9+IcUPZ/ZXEV" +
       "J8DXea6vwsMe1g8OVilgmBnHgDt7SOmooskULfWPyPrYdhcIwNBZKUKTenaq" +
       "Ug1DB2oSEFGxlggPAfS0BIiW6QBAk6JFBZWyWBtYGsUJEmWI9MkNiE8gVckD" +
       "wYZQNNcvxjXBKi3yrZJnfa70bz12j7ZDC6IA2CwTSWX2V8OgFt+gQRInJoF9" +
       "IAbWrIk8gue9fCSIEAjP9QkLmR/ce/XOdS0XXhcyi2eQ2RU7QCQalaZjdW8v" +
       "6Vq9pYSZUWHolsIWP8dzvssG7C/tGQMYZl5WI/sYcj5eGPzJFw89Q/4URFW9" +
       "qFzS1XQKcNQo6SlDUYm5nWjExJTIvaiSaHIX/96LZsF7RNGI6N0Vj1uE9qJS" +
       "lXeV6/x/CFEcVLAQVcG7osV1593ANMnfMwZCaBY8qBWeTyPxt4o1FJnhpJ4i" +
       "YSxhTdH08ICpM/+tMDBODGKbDMcA9aNhS0+bAMGwbibCGHCQJPYH2DREs8DH" +
       "sDWWCHeyvkGSSKvYHGChECQByjpNRU6QEMOe8X+ZNcNiMXs8EIBlWuInCRX2" +
       "1w5dlYkZlU6mO7uvPhd9UwCQbRo7ihTdAYaEhCEhbkgoa0gIDAldzxAUCPD5" +
       "5zCDBERggUeBKoCra1YP3b1z/5HlJYBNY7wUVoeJLs/JWV0unzhJICqdbaqd" +
       "XHZp46tBVBpBTViiaayyFNRhJoDcpFF7/9fEIJu5SaXVk1RYNjR1icjAaYWS" +
       "i62lQh8jJuunaI5Hg5Py2OYOF044M9qPLpwav2/4KxuCKJibR9iUZUCBbPgA" +
       "Y/8sy7f5+WMmvfWHL3989pEp3WWSnMTk5NO8kcyH5X6E+MMTlda04nPRl6fa" +
       "eNgrgekphp0JJNrinyOHqNod0me+VIDDcd1MYZV9cmJcRZOmPu72cOg28vc5" +
       "AItqtnPXwrPe3sr8l32dZ7B2voA6w5nPC55UPjdkPP7Ln/3hFh5uJ//UewqH" +
       "IULbPZzHlDVxdmt0YbvbJATkPjg18NDDVw7v5ZgFiRUzTdjG2i7gOlhCCPPX" +
       "Xj/4/oeXpi8GXZxTSPrpGNROmayTrB9VFXESZlvl2gOcqQKDMNS07dEAn0pc" +
       "wTGVsI31j/qVG8/9+ViDwIEKPQ6M1l1fgdu/sBMdenPf31u4moDEcrYbM1dM" +
       "JILZruYO08QTzI7Mfe80f/s1/DikFKBxS5kknJkRjwHii7aZ+7+Bt7f6vn2G" +
       "NSstL/hz95entopKxy9+VDv80fmr3Nrc4sy71n3YaBfwYs2qDKif7yenHdhK" +
       "gtytF/q/1KBeuAYaR0CjBMRs7TKBMjM5yLCly2b96pVX5+1/uwQFe1CVqmO5" +
       "B/NNhioB3cRKAttmjDvuFIs7XgFNA3cV5Tmf18ECvHTmpetOGZQHe/LF+S9s" +
       "ffL0JY4yQ+hY7FX4KdaszeKN/5U7edH59eLN1RDg7wso2vCf5IPuDM2WuCy+" +
       "zYVqH163Td9/8rS864mNokJpyq0nuqFcPvPuP98KnfrNGzOkp0qqG+tVMkZU" +
       "j7Hs4NOck0T6eFnoEtkHdSd++8O2ROeN5A/W13KdDMH+XwpOrCmcD/ymvHb/" +
       "Hxftvj25/wZSwVJfOP0qn+579o3tq6QTQV4DiyyQVzvnDmr3BhYmNQkU+xpz" +
       "k/XU8v2yIoucJgaUZfBsspGzaWY6ngF0WZIrNLQIHQwX+fYF1nwednqC0H5w" +
       "xAKIkj2DvQ5uG/jmYUeAkDgC8A+fZc2g2B3t/+XOZB0dBu/vy41QCzxbbDe3" +
       "3HiECg0tEgVS5FuCNfspqoEIRXQJq/32eo+4ocA3KxTN8Ng6xe+NhaLQ0CLu" +
       "mkW+8WyYoqgaQuHsAAcoLXkEFxMVtahn3VhpNyFWdc6O6LMdvqtIrHi7hjXr" +
       "nZqi0jB1ComByL6yotbRNYNOX6BKuLISJx4ri8fDvkVwpGcz6fFbpJCsp0L2" +
       "QaBwZBNjNDSUxAbpB+7krj1QZNW+yZp7KaqKpRVV5uOA6FcXuesxlRTUc2P2" +
       "aTk81fTh6HcvnxF5xn+09gmTIyePfhI6dlLkHHH/sCLvCsA7RtxBcEsbRPA/" +
       "gb8APP9iD3ODdbBfipq67INwa/YkzFK2iZYVM4tP0fP7s1MvPTV1OGiHpZei" +
       "0jFdkV1kTt0EZC5k31bCc9RG0dEbQGaQvR6CktfiN08+bM4potUHh1KurpT9" +
       "+3VBXTnHRZbCh9Ixi/oWc9PAfulI28DvxMovnGGAkJv7VPjB4fcOvMVzcQVL" +
       "/tkM6En8UCR4DikNrPmWcOlBz/tDFJUoNviZ6YHs+XZO7vxi6m3fqP/R8aaS" +
       "HqhIelFFWlMOpkmvnJuVZ1npmMcg99qJd3itYUCjKLAGMMU6vsrb7xXZW2dY" +
       "8xjl13dQy9AhRRZUN+3C6jv/C1hl4Bh+vTsDVuwuyLvUFBdx0nOn6yvmn97z" +
       "Hi/dspdlNbBe8bSqeqLljVy5YZK4wj2tEbW/CMy5mVgpp6CFVYSWe/OCGPMi" +
       "RYsKjwEOzr57R70EJYh/FEVl/Ncrdx74zZWDLSNevCKvgE0gwl5/bDjkelsh" +
       "mh4a3r6NSDqnGM6ZOaHOBPKPCXyx515vsbNDvEdgRsH80trBd1pcW0els6d3" +
       "9t9z9bYnxBFcUvHkJNNSDagWtwHZ6nZZQW2OrvIdq6/VPV+50mHARmGwS0CL" +
       "PcjugE1nMEQt8p1PrbbsMfX96a3nf3qk/B0g+70ogCGN7fVcGYv7UTjkpuFY" +
       "sTeSv3vhJMAPzu2rH5u4fV38L7/mJzB7ty8pLB+VLj55989PLJiGA3Z1LyoD" +
       "cieZEVSlWNsmtEEijZkjqFaxujNgImhRsJpDDXUM/JjVsjwudjhrs73sAoei" +
       "5flJK//aC06r48Ts1NOabJNLtduTc5tub6iqtGH4Brg9HnZ8WvCRSHol0Uif" +
       "YThJsPKvBueEZ/wUyTv56F/wV9a8+28oUKkS0BoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
