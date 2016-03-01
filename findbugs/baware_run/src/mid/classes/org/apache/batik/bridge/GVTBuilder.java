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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4H8BcnzsKaYkAAA=");
}
