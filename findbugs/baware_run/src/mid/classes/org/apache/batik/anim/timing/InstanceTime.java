package org.apache.batik.anim.timing;
public class InstanceTime implements java.lang.Comparable {
    protected float time;
    protected org.apache.batik.anim.timing.TimingSpecifier creator;
    protected boolean clearOnReset;
    public InstanceTime(org.apache.batik.anim.timing.TimingSpecifier creator,
                        float time,
                        boolean clearOnReset) { super();
                                                this.creator = creator;
                                                this.time = time;
                                                this.clearOnReset = clearOnReset;
    }
    public boolean getClearOnReset() { return clearOnReset; }
    public float getTime() { return time; }
    float dependentUpdate(float newTime) { time = newTime;
                                           if (creator != null) {
                                               return creator.
                                                 handleTimebaseUpdate(
                                                   this,
                                                   time);
                                           }
                                           return java.lang.Float.
                                                    POSITIVE_INFINITY;
    }
    public java.lang.String toString() { return java.lang.Float.toString(
                                                                  time);
    }
    public int compareTo(java.lang.Object o) { org.apache.batik.anim.timing.InstanceTime it =
                                                 (org.apache.batik.anim.timing.InstanceTime)
                                                   o;
                                               if (time ==
                                                     it.
                                                       time)
                                                   return 0;
                                               if (time >
                                                     it.
                                                       time)
                                                   return 1;
                                               return -1;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GW9R1xgGD9jLPOb/D9pBHRVqHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
