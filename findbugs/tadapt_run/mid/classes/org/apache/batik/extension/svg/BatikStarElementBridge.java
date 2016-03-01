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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+El/mxVn/wuwZjgPzRkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eDIpdNeKK7ZW68EgrfhadwEioJ1Uw1IZrpNK1Iz6fbSk4QQ6K7YrrJbiVl3c" +
       "OCVr3ZMXSr8lL2Gnt1KZrtOsoTWGraKVVXODlaU0aKsSSg2HZRamanCsFAog" +
       "mTBFbBokY1RNZ21bQAszlPO5IiIsiGFFbSodsCTaSTu8ysDDVl8g+QDrW3K7" +
       "01gVJm0l1GA2BqGNdXDBVQi0XJ0ZQlRIyn6Rp+O6DzhTeazfFptTsVCdudTI" +
       "q68kpLq02aAzWY6bG1mpsNMG7fQ6RqsnxCTBYIpZN1iMLhQL9UUTEypRE56E" +
       "IjYpV4cC3NCdjYhZSU3Hy6xXajSaNEXD85XZHAR1pF6e1ejuuhcIKEwauivp" +
       "EiUa5BrZNJGiVsBqvhYvJ1J73V5wveFqIbityLHMans+aupCDBeoaVkOImHV" +
       "MbxwuKx5C41j7fl6jbT8Vd8aSoW0Hfr1RJOZptviRkEZF/lZCq+rIZwwsrKe" +
       "WWxYqjNKOrUWaX0w6nbxIcrJbFjRN/pcSmZTrDWF1wHYT9NqU6IohOsYTXHJ" +
       "l3XaKnTDhTMXR3xBphlR2OBeNXamSEXHeppOSOIGTSUTZloLsWM7MazG5caY" +
       "jaddurHClkVpRRTB/mMyK7HeDSoLEp6z9brG+w4faispVX3WmZuiM/AaKU07" +
       "nFDRp7g1jVW2QfsdvVpCYDH2WFlt16Z0cxGTPow5cDRWSlR1pKEsGQhUuzoa" +
       "izJLLrq1lJwh6Gio2/GAomcbW2MKqwraV111Uq/zIEaa1YlZ7HjrvihwnlQV" +
       "5rHfJMvLZNJRiP543qq1epzUWhTWs5ozGJYUj23zMbne9LxqUvInbWwcsXDN" +
       "SsEbFoGFMiBX7zWZAi7L3KpU0KdNnrB8vLocCay3FDpIh++wtV5t3p+0C6kK" +
       "i6JfYOrwQsPTCjVAQIqWB/V0VER9QhKmtQKB4u7SAnsgHbXXI7Uvj3isa/ub" +
       "dlNNC2lz49XEio3Wy6kYT5Ip2+j2OLI6q/BynRt0ebKMIctpDdXrjLFym6xj" +
       "zVeRP5ASfYkjtUIR5NtB0+JtlvJ0NPAq/VLJKonjgq0shg1nMCOIYatUJWfN" +
       "CTFhu/YUJzGBNqWNuXHWypIlTDJquJ5Htjto6JSLw8W86cIlR68t4YGJx2bs" +
       "j6tzxU4bgQJ3koaKT9vtcqEekn6oawOtX0gRXSK9FGb0NV5hA7ZQNUS/122u" +
       "nQmM1KvL1IyVgVFcpCWasibThByLTZ3tDsm0UVA7nBuV+JST+epUxNUuI8ED" +
       "ox7P8CJV6YThrCAXZa213pBut6dNioV2xHQqznhlLxB5WgkFRKfgRdEc9RaW" +
       "6NVnG6SOzP1B34TdUr1EdVO9BK/msFyh1o7VDsw+pYqwoGrluJ84A51rzyUX" +
       "bXYprDae2iOH5SRCwNXGWJyXU6TXHAskO1MIneok48hMygV8tugPGzEDs+za" +
       "LTSYtTFxQE27pCcCbMXjfjImkHLg2iwWbpxyV0GJKJ5XCMoN2ua6jfvMIKW8" +
       "WqR4JVUc8PWqghhM3Zp2TDPtyQMSLwaOPEd6GhbrG7pUmoiNSqANDX6B6KP5" +
       "zJ7M58sxU66zcjnC2zXRLvWFpWDxzW6M1/ql0axPWmup6uGWWRrECMrIsxUo" +
       "FAyfpJb9amMyc5BecQX3ZhVaRMvjeNXmjRFMDtxVxMBT354alKowY0Nxo56g" +
       "cc6kjZJBwfXnS0YmR/GwHnfZtG1SntNxK3giVZl5wx2r3ep8WYddoxh2WFyj" +
       "5zbScFWt3aDFhjqkuBJi1hqdNrGJdExU1ZEiLGbFlOpjaBR1lWkjgKs4sH+0" +
       "7Mt4WJIaTrpoubpYCkboVAIphu/Gk8Vcai9ZnqKbdJFxo2lroTP12C5acXcY" +
       "aq2kq81bPXkdDuI0RX0NZzCwFU6XGq4Vy20br/cTnXciCfZTZ7OAtU59nNYq" +
       "zeZqEfmL2Zzqb6pNDAukxKLbCG12ay5aGU0rGD1yJnODlbA+vhFDgutspkUf" +
       "FytYtY5Wek0xDpbNWRoWlRUhsKI4RHBeWixdfcm0bQbzB01+Ux+PcJyYxpMB" +
       "tWmWqQFIdWuzZQk0S3sx0ZUN1CnpWrOyLmAWbCeCA6+jtbgw2JRbghe0N74x" +
       "e3V7y0t7e749Pyg4uCMCL83ZRPclvDVupx7MmocPDhfzz7n9+4T976OHi4cn" +
       "Tqf2DyWK/5fzcywJD64Gs1foe691Z5S/Pj/37qeeVZmPIjt7R3zTELopdL3X" +
       "W1qsWUd4yO5HH732UcEgvzI7PHr6wrv/5Z7xm+ZvewkH6vef4PMkyd8ZPP8l" +
       "4jXKr+5Apw8Ooq64zDuO9Njx46fzvhZGvjM+dgh174FJ7tg/1C7tmaR09UPt" +
       "q7rPqdx9tk5znRPU6Dpz66zxQuiCoYU04DoAhtZ4rpf726GrrX7YAcVRuvmA" +
       "fVzE+8DT3BOx+eMX8V3Xmfv5rHlHCN0CRKRcRbLoPescke+JH1W+e8Gzh7v9" +
       "/vHK9yvXmXt/1jwZQjcD+fadcD9477sieOXt7dr2lutQAb/0Iyjgtn2/Hewp" +
       "gHwpCgCx7/luqIE3BPWqeji9dwK+J9LD1xdp788B+9B3ZtDrsrKruvbu3g3f" +
       "tZVjxOHuaC55Gg32v5yZZ66j+Oey5ukQOg9KOEvN8XK40ZHkPAmhM7Frqoea" +
       "/tCPoOlXZoMPg+eZPU0/8xI0vZN1fyPfbK6q5zM51Jns528ehscJYU6bTn6N" +
       "9JGcxO9eRzu/nzXPh/n/KmLND0emulXPpw918fGXooskhO66+mVtdvN09xX/" +
       "Jdn+/0H5xLMXbnzFs/xf5/eVB/9RuImCbtQjyzp6UXCkf87zNd3M5bhpe23g" +
       "5V+fvZrXHNsPgYpAmzP/x1ucF0LonmvjAPc/6B/F+lwIXTyJFUJn8++jcJ8H" +
       "/ncIF0Lntp2jIF8CPAGQrPvn3r7z164VRiOB6GiKm9975D59TNXJqSP7855/" +
       "5qa844eZ8gDl6HVptqfn/xXa33+j7b+FLiuffLZPv/3F2ke317WKJaVpRuVG" +
       "Crphe3N8sIc/eE1q+7TOdR/5/m2fuunh/Xrjti3Dh7FyhLf7r343itlemN9m" +
       "pn/4it97w289+/X8guR/AdjoSMHEJQAA");
}
