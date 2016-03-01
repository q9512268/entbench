package org.apache.batik.bridge;
public class SVGGElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    public SVGGElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_G_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGGElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (gn ==
              null)
            return null;
        associateSVGContext(
          ctx,
          e,
          gn);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        if (hints !=
              null)
            gn.
              setRenderingHints(
                hints);
        java.awt.geom.Rectangle2D r =
          org.apache.batik.bridge.CSSUtilities.
          convertEnableBackground(
            e);
        if (r !=
              null)
            gn.
              setBackgroundEnable(
                r);
        return gn;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.CompositeGraphicsNode(
          );
    }
    public boolean isComposite() { return true; }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (evt.
              getTarget(
                ) instanceof org.w3c.dom.Element) {
            handleElementAdded(
              (org.apache.batik.gvt.CompositeGraphicsNode)
                node,
              e,
              (org.w3c.dom.Element)
                evt.
                getTarget(
                  ));
        }
        else {
            super.
              handleDOMNodeInsertedEvent(
                evt);
        }
    }
    protected void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
                                      org.w3c.dom.Node parent,
                                      org.w3c.dom.Element childElt) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.GraphicsNode childNode =
          builder.
          build(
            ctx,
            childElt);
        if (childNode ==
              null) {
            return;
        }
        int idx =
          -1;
        for (org.w3c.dom.Node ps =
               childElt.
               getPreviousSibling(
                 );
             ps !=
               null;
             ps =
               ps.
                 getPreviousSibling(
                   )) {
            if (ps.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            org.w3c.dom.Element pse =
              (org.w3c.dom.Element)
                ps;
            org.apache.batik.gvt.GraphicsNode psgn =
              ctx.
              getGraphicsNode(
                pse);
            while (psgn !=
                     null &&
                     psgn.
                     getParent(
                       ) !=
                     gn) {
                psgn =
                  psgn.
                    getParent(
                      );
            }
            if (psgn ==
                  null)
                continue;
            idx =
              gn.
                indexOf(
                  psgn);
            if (idx ==
                  -1)
                continue;
            break;
        }
        idx++;
        gn.
          add(
            idx,
            childNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae6zkVnn33s3uJpuQ3WwgSUPe2dAmA9eep2caHpnx2J6H" +
       "7fG87PG0sPF7POPX+D1DUx5SS1pUGpWE0haiqgJBUXioKqUSog2qWkCgSiDU" +
       "QtUSRCuVliKRP0qr0pYee+69c+/dB4qCOpKPPed85zvne/3O53P83PehU74H" +
       "5VzHXOmmE+yqSbA7N8u7wcpV/d0OVWZFz1cVzBR9fwTqLskPfOrcD3/01Oz8" +
       "DnR6Ct0q2rYTiIHh2P5A9R0zUhUKOretxU3V8gPoPDUXIxEOA8OEKcMPHqWg" +
       "Gw91DaCL1P4UYDAFGEwBzqYA17dUoNMrVDu0sLSHaAf+Evpl6AQFnXbldHoB" +
       "dP9RJq7oidYeGzaTAHC4Pv3PAaGyzokH3Xcg+0bmywR+Jgc//dtvOf9HJ6Fz" +
       "U+icYQ/T6chgEgEYZArdZKmWpHp+XVFUZQrdYquqMlQ9QzSNdTbvKXTBN3Rb" +
       "DEJPPVBSWhm6qpeNudXcTXIqmxfKgeMdiKcZqqns/zulmaIOZL1tK+tGQiKt" +
       "BwKeNcDEPE2U1f0u1y0MWwmge4/3OJDxYhcQgK5nLDWYOQdDXWeLoAK6sLGd" +
       "Kdo6PAw8w9YB6SknBKME0J1XZZrq2hXlhairlwLojuN07KYJUN2QKSLtEkCv" +
       "Ok6WcQJWuvOYlQ7Z5/vM69/zVrtl72RzVlTZTOd/Peh0z7FOA1VTPdWW1U3H" +
       "mx6h3ife9rkndyAIEL/qGPGG5jO/9OJjr73n+S9uaF59BZqeNFfl4JL8Ienm" +
       "r96FPVw7mU7jetfxjdT4RyTP3J/da3k0cUHk3XbAMW3c3W98fvBXwts/pn5v" +
       "Bzrbhk7LjhlawI9ukR3LNUzVI1Vb9cRAVdrQDaqtYFl7GzoDninDVje1PU3z" +
       "1aANXWdmVaed7D9QkQZYpCo6A54NW3P2n10xmGXPiQtB0BlwQTeB6yK0+WX3" +
       "AJrDM8dSYVEWbcN2YNZzUvlTg9qKCAeqD54V0Oo6sAT8f/G6/C4K+07oAYeE" +
       "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" +
       "JwAA");
}
