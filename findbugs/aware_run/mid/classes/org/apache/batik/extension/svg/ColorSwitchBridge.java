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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
