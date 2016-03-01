package org.apache.batik.anim.timing;
public class SyncbaseTimingSpecifier extends org.apache.batik.anim.timing.OffsetTimingSpecifier {
    protected java.lang.String syncbaseID;
    protected org.apache.batik.anim.timing.TimedElement syncbaseElement;
    protected boolean syncBegin;
    protected java.util.HashMap instances = new java.util.HashMap();
    public SyncbaseTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                   boolean isBegin,
                                   float offset,
                                   java.lang.String syncbaseID,
                                   boolean syncBegin) { super(owner,
                                                              isBegin,
                                                              offset);
                                                        this.syncbaseID =
                                                          syncbaseID;
                                                        this.syncBegin =
                                                          syncBegin;
                                                        this.syncbaseElement =
                                                          owner.
                                                            getTimedElementById(
                                                              syncbaseID);
                                                        syncbaseElement.
                                                          addDependent(
                                                            this,
                                                            syncBegin);
    }
    public java.lang.String toString() { return syncbaseID + "." +
                                         (syncBegin
                                            ? "begin"
                                            : "end") +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() {  }
    public boolean isEventCondition() { return false; }
    float newInterval(org.apache.batik.anim.timing.Interval interval) {
        if (owner.
              hasPropagated) {
            return java.lang.Float.
                     POSITIVE_INFINITY;
        }
        org.apache.batik.anim.timing.InstanceTime instance =
          new org.apache.batik.anim.timing.InstanceTime(
          this,
          (syncBegin
             ? interval.
             getBegin(
               )
             : interval.
             getEnd(
               )) +
            offset,
          true);
        instances.
          put(
            interval,
            instance);
        interval.
          addDependent(
            instance,
            syncBegin);
        return owner.
          addInstanceTime(
            instance,
            isBegin);
    }
    float removeInterval(org.apache.batik.anim.timing.Interval interval) {
        if (owner.
              hasPropagated) {
            return java.lang.Float.
                     POSITIVE_INFINITY;
        }
        org.apache.batik.anim.timing.InstanceTime instance =
          (org.apache.batik.anim.timing.InstanceTime)
            instances.
            get(
              interval);
        interval.
          removeDependent(
            instance,
            syncBegin);
        return owner.
          removeInstanceTime(
            instance,
            isBegin);
    }
    float handleTimebaseUpdate(org.apache.batik.anim.timing.InstanceTime instanceTime,
                               float newTime) { if (owner.
                                                      hasPropagated) {
                                                    return java.lang.Float.
                                                             POSITIVE_INFINITY;
                                                }
                                                return owner.
                                                  instanceTimeChanged(
                                                    instanceTime,
                                                    isBegin);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MJw28DSuecPA0x2Ygj+6/w0rbS+WZSEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ivywv63ilJAaGk+gWXW+XMENZItGCwGeKkKHIIgPfrDYHvjzb23b4tFyN+b4" +
       "EsEfYh9mX/Rckbx4vEFV/q5C5w6eT21Qndrzhopd+ffc625AeXDx+Y+9+po+" +
       "+snK0U5YK4GuJ0H4fa6xMdxTXV0FPb3/3ntrw/JqxMke9pc/9ltPid9vfeQt" +
       "nJ2+9xyd57v8m8PXf6n7PdqPXYbuO97RvuPSxtlGL5/dx34wMpI08sUzu9nv" +
       "OZbsY4XEngJP71CyvfNbfye6u/u+5/v2ur/gKOavXlD214rkLyfQA0lwcrrz" +
       "oRNT+SvfbhPrdIdlxo+fPZt9GjzjQ97G333e/tYFZV8okr+eFNdv7KS8/GPc" +
       "de9uE9j6Ccc/9TY4fmeRWZxHzA45nn33Of6HF5T94yL5UgLdtOPOxvATMvD1" +
       "43Pr+gmPf/dt8FicQ5eb1bcPebz9FniE7srepcPrEsX34wn04oWnvkxxl2pz" +
       "uAH9CxcI418Uyc8n0EO+sT1qVGR94EQO//TtyuHJkvX9b/3dkkPx+eWywlcv" +
       "YO9Xi+RfJdAjkeEFG+MeHP7rt8thgfQfPeTwo2+bw8tl2eXv7Hz/CFGLc/6S" +
       "rbLLr18gk18vkv+YQO+yVF93y4bFgY4U6mpinJPMf3orkskS6Il7XAoqbjg8" +
       "eceFxf0lO+1nXrvxwBOvSf+2vBdzfBHuOgs9YKaue/q489T71TAyTLtk6Pr+" +
       "8DMs/76RQE9fJLAEurp/Kcn/rX2j/5FAj9+1EQC+4u903TcBcpyvm0BXyv/T" +
       "9f4nwNSTemDY/cvpKr+XQPeBKsXr74dH6q5eqO795bhz0s0unQ0tjtX32LdT" +
       "36lo5IUzMUR5B/XI36f84THgF1/rcz/0ZuMn9zeBNFfN86KXB1jo2v5S0nHM" +
       "8Nw9ezvq62rvpW898rPXXzyKbx7ZE3wyW07R9t67X7vpeGFSXpTJ//4Tf+cD" +
       "P/Xar5UHWv8Pwd0bTBwsAAA=");
}
