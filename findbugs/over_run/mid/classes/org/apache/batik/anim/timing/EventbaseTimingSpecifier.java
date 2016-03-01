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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7DVN9yavnlveNPkOv4JD938ASoNxfysfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GhTt2UoqjziNSwp6suLKITdfrZatSsNbheXJYMLzvGXHLo8T5WYisErXHExF" +
       "r8puDHqMNphobkeTcY8yy/pgbYxNdlIK7E5UbzTstt4oFpT5eBjRSZBY3oSs" +
       "zpgVT1grS+yuHNFvDh2TCQfjelDxGmYwcQZBbJUklDF0I2L7XWNUpJXZuqrO" +
       "asskqpCi0I9sdO2v+nVNWZFDc8X3SGcthIo7JOm4O8T0NmduNuPFgO3ErCC4" +
       "uKdZWjXy/fG8UzSrtprOxsKsgdicuxIGmk9s6KTZXQkmy9idSaMwI1mDGxAK" +
       "YmipmIKvwGrNrbmjXmu4GY8WsRolXp0zu/NGcdVawaw+ahHd9bzVxRurqTCk" +
       "ZsHEnC43WsMrBp0lrDBsjysqSi1VpH7YigJ2Q+D9aDrDN2KpT2EwEzQElEDE" +
       "TZDia9+vo1pr4zt8far1tHLD18uqb1ItyVt3GmrIEYO1aDVb5U5vAkyMn6mN" +
       "NT+PmJJEYRMcb5ZGJi0EvbYDwhFqQJAiM1+6plHlqt2FVkRlPByscIJiUL/L" +
       "jRk+kkxjrbcUguumo6bcKelNsbGKWGK8FNreeNIYNaV1cVDALQfBIr8dluY9" +
       "tcC7BbY50AOubbUKrNzg7AAXxwPFa4jtBYuPqxXZ7FSEbBt00RuzuLee4g15" +
       "nSK1BK3WqWlxg/XstmnNh4CkNBI8lTWqrOUIiBzCVretW22D9MV+qsNjZ1TY" +
       "0LZqdctK07OdHodN2hEVomowjMMwqRu9Km36rkp4gyElRI0RuWKN+cYTQ7YK" +
       "Aj7OXC551dTCksBFcVhprSKivlI9Lu2jiw419qobkie9Qp9crBGb1MZsv9mr" +
       "Rg2lNJaH9XqZK7cacFqxCZP00E0rQdvLVmLPsVa3OurN2WGLqHSDKlhDPdoN" +
       "cJgHCu/L43IJ5cstftjoeTpdYAQ5NvrJqGxKnNYFHA4FdtxtrsgVvxzgjc7c" +
       "tV3S1VeJ4E1WFF4SlCYNI9M6O53P5mGhO18UJNiYDUbSpFeiGt2GghVHPS0Y" +
       "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" +
       "/vZT38hPOf4Pz/2h5KUqAAA=");
}
