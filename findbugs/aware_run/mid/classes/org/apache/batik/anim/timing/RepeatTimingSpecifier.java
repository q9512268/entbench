package org.apache.batik.anim.timing;
public class RepeatTimingSpecifier extends org.apache.batik.anim.timing.EventbaseTimingSpecifier {
    protected int repeatIteration;
    protected boolean repeatIterationSpecified;
    public RepeatTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset,
                                 java.lang.String syncbaseID) { super(
                                                                  owner,
                                                                  isBegin,
                                                                  offset,
                                                                  syncbaseID,
                                                                  owner.
                                                                    getRoot(
                                                                      ).
                                                                    getRepeatEventName(
                                                                      ));
    }
    public RepeatTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset,
                                 java.lang.String syncbaseID,
                                 int repeatIteration) {
        super(
          owner,
          isBegin,
          offset,
          syncbaseID,
          owner.
            getRoot(
              ).
            getRepeatEventName(
              ));
        this.
          repeatIteration =
          repeatIteration;
        this.
          repeatIterationSpecified =
          true;
    }
    public java.lang.String toString() { return (eventbaseID ==
                                                   null
                                                   ? ""
                                                   : eventbaseID +
                                                 ".") +
                                         "repeat" +
                                         (repeatIterationSpecified
                                            ? "(" +
                                          repeatIteration +
                                          ")"
                                            : "") +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : "");
    }
    public void handleEvent(org.w3c.dom.events.Event e) {
        org.w3c.dom.smil.TimeEvent evt =
          (org.w3c.dom.smil.TimeEvent)
            e;
        if (!repeatIterationSpecified ||
              evt.
              getDetail(
                ) ==
              repeatIteration) {
            super.
              handleEvent(
                e);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DYOH9wUcev8Dl1orWnoaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
