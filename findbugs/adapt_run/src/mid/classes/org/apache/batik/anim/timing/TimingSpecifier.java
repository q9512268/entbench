package org.apache.batik.anim.timing;
public abstract class TimingSpecifier {
    protected org.apache.batik.anim.timing.TimedElement owner;
    protected boolean isBegin;
    protected TimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                              boolean isBegin) { super();
                                                 this.owner = owner;
                                                 this.isBegin = isBegin; }
    public org.apache.batik.anim.timing.TimedElement getOwner() { return owner;
    }
    public boolean isBegin() { return isBegin; }
    public void initialize() {  }
    public void deinitialize() {  }
    public abstract boolean isEventCondition();
    float newInterval(org.apache.batik.anim.timing.Interval interval) { return java.lang.Float.
                                                                                 POSITIVE_INFINITY;
    }
    float removeInterval(org.apache.batik.anim.timing.Interval interval) {
        return java.lang.Float.
                 POSITIVE_INFINITY;
    }
    float handleTimebaseUpdate(org.apache.batik.anim.timing.InstanceTime instanceTime,
                               float newTime) { return java.lang.Float.
                                                         POSITIVE_INFINITY;
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
      ("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");
}
