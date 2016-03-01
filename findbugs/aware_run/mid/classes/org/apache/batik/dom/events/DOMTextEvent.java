package org.apache.batik.dom.events;
public class DOMTextEvent extends org.apache.batik.dom.events.DOMUIEvent implements org.w3c.dom.events.TextEvent {
    protected java.lang.String data;
    public java.lang.String getData() { return data; }
    public void initTextEvent(java.lang.String typeArg, boolean canBubbleArg,
                              boolean cancelableArg,
                              org.w3c.dom.views.AbstractView viewArg,
                              java.lang.String dataArg) { initUIEvent(typeArg,
                                                                      canBubbleArg,
                                                                      cancelableArg,
                                                                      viewArg,
                                                                      0);
                                                          data =
                                                            dataArg;
    }
    public void initTextEventNS(java.lang.String namespaceURIArg,
                                java.lang.String typeArg,
                                boolean canBubbleArg,
                                boolean cancelableArg,
                                org.w3c.dom.views.AbstractView viewArg,
                                java.lang.String dataArg) {
        initUIEventNS(
          namespaceURIArg,
          typeArg,
          canBubbleArg,
          cancelableArg,
          viewArg,
          0);
        data =
          dataArg;
    }
    public DOMTextEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RI9h2Nf2qkvc84bBc/gl1hz5LyT06soZGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/w9dvnv6zCMAAA==");
}
