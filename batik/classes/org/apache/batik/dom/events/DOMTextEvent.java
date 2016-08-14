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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b+bn4/8DlAVS5/QjAAA=");
}
