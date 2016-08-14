package org.apache.batik.anim.timing;
public class WallclockTimingSpecifier extends org.apache.batik.anim.timing.TimingSpecifier {
    protected java.util.Calendar time;
    protected org.apache.batik.anim.timing.InstanceTime instance;
    public WallclockTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    java.util.Calendar time) { super(
                                                                 owner,
                                                                 isBegin);
                                                               this.
                                                                 time =
                                                                 time;
    }
    public java.lang.String toString() { return "wallclock(" + time.
                                           toString(
                                             ) +
                                         ")"; }
    public void initialize() { float t = owner.getRoot().convertWallclockTime(
                                                           time);
                               instance = new org.apache.batik.anim.timing.InstanceTime(
                                            this,
                                            t,
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
       "DArui+ITXz/6N72/3BLEGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
