package org.apache.batik.extension.svg;
public class ColorSwitchBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.PaintBridge, org.apache.batik.extension.svg.BatikExtConstants {
    public ColorSwitchBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_COLOR_SWITCH_TAG;
    }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element paintElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) { org.w3c.dom.Element clrDef =
                                                         null;
                                                       for (org.w3c.dom.Node n =
                                                              paintElement.
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
                                                                   ) !=
                                                                 org.w3c.dom.Node.
                                                                   ELEMENT_NODE)
                                                               continue;
                                                           org.w3c.dom.Element ref =
                                                             (org.w3c.dom.Element)
                                                               n;
                                                           if (org.apache.batik.bridge.SVGUtilities.
                                                                 matchUserAgent(
                                                                   ref,
                                                                   ctx.
                                                                     getUserAgent(
                                                                       ))) {
                                                               clrDef =
                                                                 ref;
                                                               break;
                                                           }
                                                       }
                                                       if (clrDef ==
                                                             null)
                                                           return java.awt.Color.
                                                                    black;
                                                       org.apache.batik.bridge.Bridge bridge =
                                                         ctx.
                                                         getBridge(
                                                           clrDef);
                                                       if (bridge ==
                                                             null ||
                                                             !(bridge instanceof org.apache.batik.bridge.PaintBridge))
                                                           return java.awt.Color.
                                                                    black;
                                                       return ((org.apache.batik.bridge.PaintBridge)
                                                                 bridge).
                                                         createPaint(
                                                           ctx,
                                                           clrDef,
                                                           paintedElement,
                                                           paintedNode,
                                                           opacity);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NgLzz5n9Df3976MbgYe7Qzv7GwiPXrXNLW730ceC4YTbne192hfbEkezvm4S" +
       "HpzjZa/GD1zvgCd/Lf7Uu59+RqY+XdrZ27qbh9C50PVeYymxYp3YzXri+lsA" +
       "RH6+dbil9OV3/+t9zM/rb30JG+UPndDzpMjPEM9+tfdK6SM70E0HG0xXnbwd" +
       "Z3ry+LbSeV8JI99hjm0uPXDgvrsyb10CV2XPfZVrb1ZfM9RO5aG2DbAb7Iyu" +
       "b/AszRo/hC5oSkgCrQPgaIWdDvLYPAzL4MU2Ho7KzTvc4yY+CK7X7pn42p++" +
       "ib90g2fvyZq3h9BtwETclQSL3PPOEfve8RPYl2dhdt7Q27Ov99Ox73ROcHo/" +
       "Dx+7Xs5u03XvBHuf+u6Mel2RdmXX3s2O7RUn39b/yD7BpavEaXG4C95RPd0A" +
       "hZwrbwGAPgJKXLZPablCmKv7oRtM+W9kzftD6FbJV4RQyVFlf+DtfqOwDncP" +
       "u3MffOCl+CABgHrVYVx2snDvVX8A2B5aS59/5sLZVzzD/k1+HnVwsHwOh86q" +
       "kWUd3Qg+cn/G8xXVyG06t90W9vKv3wqhB2+MiyFAr3i70fybW57fDqH7rs8D" +
       "IPDg/ijXZ0Lo4kku4If8+yjdsyF0/pAuhM5sb46SPAd0AiTZ7Re8fXc8fr2w" +
       "aolB6AtSSM9629lNTh2B5r0syB1314s57oDl6AlYBuf5fzr2oTfa/qvjivTc" +
       "M0PybS/UP709gZMsYbPJpJzFoVu2h4EH8H3putL2ZZ3pP/6jO75w7rH9peaO" +
       "rcKHGXlEt4eufdzVtb0wP6Da/NEr/uB1v/PMt/I97/8D++hCKGwjAAA=");
}
