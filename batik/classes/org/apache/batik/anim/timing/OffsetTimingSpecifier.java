package org.apache.batik.anim.timing;
public class OffsetTimingSpecifier extends org.apache.batik.anim.timing.TimingSpecifier {
    protected float offset;
    public OffsetTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset) { super(owner, isBegin);
                                                 this.offset = offset;
    }
    public java.lang.String toString() { return (offset >= 0 ? "+"
                                                   : "") + offset;
    }
    public void initialize() { org.apache.batik.anim.timing.InstanceTime instance =
                                 new org.apache.batik.anim.timing.InstanceTime(
                                 this,
                                 offset,
                                 false);
                               owner.addInstanceTime(instance,
                                                     isBegin);
    }
    public boolean isEventCondition() { return false; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Iw4/+Ddt9McqBRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d2bpH979+Vd/8plv5gez/wvRQ70lBSQAAA==");
}
