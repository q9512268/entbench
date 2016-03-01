package org.apache.batik.dom.svg12;
public class SVG12OMDocument extends org.apache.batik.dom.svg.SVGOMDocument {
    protected SVG12OMDocument() { super(); }
    public SVG12OMDocument(org.w3c.dom.DocumentType dt, org.w3c.dom.DOMImplementation impl) {
        super(
          dt,
          impl);
    }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.dom.svg12.SVG12OMDocument(
                                             ); }
    public void addCSSNavigableDocumentListener(org.apache.batik.css.engine.CSSNavigableDocumentListener l) {
        if (cssNavigableDocumentListeners.
              containsKey(
                l)) {
            return;
        }
        org.apache.batik.dom.svg.SVGOMDocument.DOMNodeInsertedListenerWrapper nodeInserted =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMNodeInsertedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMNodeRemovedListenerWrapper nodeRemoved =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMNodeRemovedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMSubtreeModifiedListenerWrapper subtreeModified =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMSubtreeModifiedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMCharacterDataModifiedListenerWrapper cdataModified =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMCharacterDataModifiedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMAttrModifiedListenerWrapper attrModified =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMAttrModifiedListenerWrapper(
          l);
        cssNavigableDocumentListeners.
          put(
            l,
            new org.w3c.dom.events.EventListener[] { nodeInserted,
            nodeRemoved,
            subtreeModified,
            cdataModified,
            attrModified });
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            initializeEventSupport(
              );
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            nodeInserted,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            nodeRemoved,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModified,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMCharacterDataModified",
            cdataModified,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            attrModified,
            false);
    }
    public void removeCSSNavigableDocumentListener(org.apache.batik.css.engine.CSSNavigableDocumentListener l) {
        org.w3c.dom.events.EventListener[] listeners =
          (org.w3c.dom.events.EventListener[])
            cssNavigableDocumentListeners.
            get(
              l);
        if (listeners ==
              null) {
            return;
        }
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            initializeEventSupport(
              );
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            listeners[0],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            listeners[1],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            listeners[2],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMCharacterDataModified",
            listeners[3],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            listeners[4],
            false);
        cssNavigableDocumentListeners.
          remove(
            l);
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
       "mPd/ADwn4EeoIwAA");
}
