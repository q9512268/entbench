package org.apache.batik.bridge;
public class GVTBuilder implements org.apache.batik.util.SVGConstants {
    public GVTBuilder() { super(); }
    public org.apache.batik.gvt.GraphicsNode build(org.apache.batik.bridge.BridgeContext ctx,
                                                   org.w3c.dom.Document document) {
        ctx.
          setDocument(
            document);
        ctx.
          initializeDocument(
            document);
        ctx.
          setGVTBuilder(
            this);
        org.apache.batik.bridge.DocumentBridge dBridge =
          ctx.
          getDocumentBridge(
            );
        org.apache.batik.gvt.RootGraphicsNode rootNode =
          null;
        try {
            rootNode =
              dBridge.
                createGraphicsNode(
                  ctx,
                  document);
            org.w3c.dom.Element svgElement =
              document.
              getDocumentElement(
                );
            org.apache.batik.gvt.GraphicsNode topNode =
              null;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                svgElement);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                return null;
            }
            org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
              (org.apache.batik.bridge.GraphicsNodeBridge)
                bridge;
            topNode =
              gnBridge.
                createGraphicsNode(
                  ctx,
                  svgElement);
            if (topNode ==
                  null) {
                return null;
            }
            rootNode.
              getChildren(
                ).
              add(
                topNode);
            buildComposite(
              ctx,
              svgElement,
              (org.apache.batik.gvt.CompositeGraphicsNode)
                topNode);
            gnBridge.
              buildGraphicsNode(
                ctx,
                svgElement,
                topNode);
            dBridge.
              buildGraphicsNode(
                ctx,
                document,
                rootNode);
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            ex.
              setGraphicsNode(
                rootNode);
            throw ex;
        }
        if (ctx.
              isInteractive(
                )) {
            ctx.
              addUIEventListeners(
                document);
            ctx.
              addGVTListener(
                document);
        }
        if (ctx.
              isDynamic(
                )) {
            ctx.
              addDOMListeners(
                );
        }
        return rootNode;
    }
    public org.apache.batik.gvt.GraphicsNode build(org.apache.batik.bridge.BridgeContext ctx,
                                                   org.w3c.dom.Element e) {
        org.apache.batik.bridge.Bridge bridge =
          ctx.
          getBridge(
            e);
        if (bridge instanceof org.apache.batik.bridge.GenericBridge) {
            ((org.apache.batik.bridge.GenericBridge)
               bridge).
              handleElement(
                ctx,
                e);
            handleGenericBridges(
              ctx,
              e);
            return null;
        }
        else
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                handleGenericBridges(
                  ctx,
                  e);
                return null;
            }
        org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
          (org.apache.batik.bridge.GraphicsNodeBridge)
            bridge;
        if (!gnBridge.
              getDisplay(
                e)) {
            handleGenericBridges(
              ctx,
              e);
            return null;
        }
        org.apache.batik.gvt.GraphicsNode gn =
          gnBridge.
          createGraphicsNode(
            ctx,
            e);
        if (gn !=
              null) {
            if (gnBridge.
                  isComposite(
                    )) {
                buildComposite(
                  ctx,
                  e,
                  (org.apache.batik.gvt.CompositeGraphicsNode)
                    gn);
            }
            else {
                handleGenericBridges(
                  ctx,
                  e);
            }
            gnBridge.
              buildGraphicsNode(
                ctx,
                e,
                gn);
        }
        if (ctx.
              isDynamic(
                )) {
            
        }
        return gn;
    }
    protected void buildComposite(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.CompositeGraphicsNode parentNode) {
        for (org.w3c.dom.Node n =
               e.
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
                    ELEMENT_NODE) {
                buildGraphicsNode(
                  ctx,
                  (org.w3c.dom.Element)
                    n,
                  parentNode);
            }
        }
    }
    protected void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e,
                                     org.apache.batik.gvt.CompositeGraphicsNode parentNode) {
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
            throw new org.apache.batik.bridge.InterruptedBridgeException(
              );
        }
        org.apache.batik.bridge.Bridge bridge =
          ctx.
          getBridge(
            e);
        if (bridge instanceof org.apache.batik.bridge.GenericBridge) {
            ((org.apache.batik.bridge.GenericBridge)
               bridge).
              handleElement(
                ctx,
                e);
            handleGenericBridges(
              ctx,
              e);
            return;
        }
        else
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                handleGenericBridges(
                  ctx,
                  e);
                return;
            }
        if (!org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                e)) {
            handleGenericBridges(
              ctx,
              e);
            return;
        }
        org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
          (org.apache.batik.bridge.GraphicsNodeBridge)
            bridge;
        try {
            org.apache.batik.gvt.GraphicsNode gn =
              gnBridge.
              createGraphicsNode(
                ctx,
                e);
            if (gn !=
                  null) {
                parentNode.
                  getChildren(
                    ).
                  add(
                    gn);
                if (gnBridge.
                      isComposite(
                        )) {
                    buildComposite(
                      ctx,
                      e,
                      (org.apache.batik.gvt.CompositeGraphicsNode)
                        gn);
                }
                else {
                    handleGenericBridges(
                      ctx,
                      e);
                }
                gnBridge.
                  buildGraphicsNode(
                    ctx,
                    e,
                    gn);
            }
            else {
                handleGenericBridges(
                  ctx,
                  e);
            }
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            org.apache.batik.gvt.GraphicsNode errNode =
              ex.
              getGraphicsNode(
                );
            if (errNode !=
                  null) {
                parentNode.
                  getChildren(
                    ).
                  add(
                    errNode);
                gnBridge.
                  buildGraphicsNode(
                    ctx,
                    e,
                    errNode);
                ex.
                  setGraphicsNode(
                    null);
            }
            throw ex;
        }
    }
    protected void handleGenericBridges(org.apache.batik.bridge.BridgeContext ctx,
                                        org.w3c.dom.Element e) {
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n instanceof org.w3c.dom.Element) {
                org.w3c.dom.Element e2 =
                  (org.w3c.dom.Element)
                    n;
                org.apache.batik.bridge.Bridge b =
                  ctx.
                  getBridge(
                    e2);
                if (b instanceof org.apache.batik.bridge.GenericBridge) {
                    ((org.apache.batik.bridge.GenericBridge)
                       b).
                      handleElement(
                        ctx,
                        e2);
                }
                handleGenericBridges(
                  ctx,
                  e2);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO387/s4nSex8OUFx0rtGTYDKodR27MTh7Jg4" +
       "McJpc5nbnfNtvLe72Z07nx1S2gJKQCKKgtuGQoOQUpqitKkKFVDaKqiCpBSQ" +
       "WiKgoCZI/EH4qGiEVFQFKO/N7t7u7d05CiIn7ezezJs3837zm/fezLl3SJVl" +
       "kg6m8QifNpgV6df4CDUtJvep1LL2QF1ceqyC/mP/teG7w6R6nDSlqDUkUYsN" +
       "KEyVrXHSrmgWp5rErGHGZOwxYjKLmVnKFV0bJwsVazBtqIqk8CFdZigwRs0Y" +
       "aaWcm0oiw9mgo4CT9hjMJCpmEu0JNnfHSIOkG9Oe+BKfeJ+vBSXT3lgWJy2x" +
       "gzRLoxmuqNGYYvHunEk2GLo6PaHqPMJyPHJQ3eJAsDO2pQiC1c81v3fjRKpF" +
       "QDCfaprOhXnWbmbpapbJMdLs1farLG0dIg+QihiZ5xPmpDPmDhqFQaMwqGut" +
       "JwWzb2RaJt2nC3O4q6nakHBCnKwqVGJQk6YdNSNizqChlju2i85g7cq8tbaV" +
       "RSY+siE6+9j+lucrSPM4aVa0UZyOBJPgMMg4AMrSCWZaPbLM5HHSqsFijzJT" +
       "oaoy46x0m6VMaJRnYPldWLAyYzBTjOlhBesItpkZietm3rykIJTzryqp0gmw" +
       "dZFnq23hANaDgfUKTMxMUuCd06VyUtFkTlYEe+Rt7PwkCEDXmjTjKT0/VKVG" +
       "oYK02RRRqTYRHQXqaRMgWqUDAU1OlpZVilgbVJqkEyyOjAzIjdhNIFUngMAu" +
       "nCwMiglNsEpLA6vkW593hrceP6zt0MIkBHOWmaTi/OdBp45Ap90syUwG+8Du" +
       "2NAVe5QuevlYmBAQXhgQtmW+/9nr927suHDJlllWQmZX4iCTeFw6k2h6Y3nf" +
       "+rsrcBq1hm4puPgFlotdNuK0dOcM8DCL8hqxMeI2Xtj90888+B321zCpHyTV" +
       "kq5m0sCjVklPG4rKzO1MYyblTB4kdUyT+0T7IKmB75iiMbt2VzJpMT5IKlVR" +
       "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" +
       "VRkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eOYr2R3E/wKjhCYu0iQAAA==");
}
