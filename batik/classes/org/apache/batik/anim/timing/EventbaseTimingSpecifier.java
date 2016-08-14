package org.apache.batik.anim.timing;
public class EventbaseTimingSpecifier extends org.apache.batik.anim.timing.EventLikeTimingSpecifier implements org.w3c.dom.events.EventListener {
    protected java.lang.String eventbaseID;
    protected org.apache.batik.anim.timing.TimedElement eventbase;
    protected org.w3c.dom.events.EventTarget eventTarget;
    protected java.lang.String eventNamespaceURI;
    protected java.lang.String eventType;
    protected java.lang.String eventName;
    public EventbaseTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    java.lang.String eventbaseID,
                                    java.lang.String eventName) {
        super(
          owner,
          isBegin,
          offset);
        this.
          eventbaseID =
          eventbaseID;
        this.
          eventName =
          eventName;
        org.apache.batik.anim.timing.TimedDocumentRoot root =
          owner.
          getRoot(
            );
        this.
          eventNamespaceURI =
          root.
            getEventNamespaceURI(
              eventName);
        this.
          eventType =
          root.
            getEventType(
              eventName);
        if (eventbaseID ==
              null) {
            this.
              eventTarget =
              owner.
                getAnimationEventTarget(
                  );
        }
        else {
            this.
              eventTarget =
              owner.
                getEventTargetById(
                  eventbaseID);
        }
    }
    public java.lang.String toString() { return (eventbaseID == null
                                                   ? ""
                                                   : eventbaseID +
                                                 ".") + eventName +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() { ((org.apache.batik.dom.events.NodeEventTarget)
                                  eventTarget).addEventListenerNS(
                                                 eventNamespaceURI,
                                                 eventType,
                                                 this,
                                                 false,
                                                 null); }
    public void deinitialize() { ((org.apache.batik.dom.events.NodeEventTarget)
                                    eventTarget).removeEventListenerNS(
                                                   eventNamespaceURI,
                                                   eventType,
                                                   this,
                                                   false); }
    public void handleEvent(org.w3c.dom.events.Event e) { owner.eventOccurred(
                                                                  this,
                                                                  e);
    }
    public void resolve(org.w3c.dom.events.Event e) { float time =
                                                        owner.
                                                        getRoot(
                                                          ).
                                                        convertEpochTime(
                                                          e.
                                                            getTimeStamp(
                                                              ));
                                                      org.apache.batik.anim.timing.InstanceTime instance =
                                                        new org.apache.batik.anim.timing.InstanceTime(
                                                        this,
                                                        time +
                                                          offset,
                                                        true);
                                                      owner.
                                                        addInstanceTime(
                                                          instance,
                                                          isBegin);
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
       "AAA=");
}
