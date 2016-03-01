package org.apache.batik.anim.timing;
public class Interval {
    protected float begin;
    protected float end;
    protected org.apache.batik.anim.timing.InstanceTime beginInstanceTime;
    protected org.apache.batik.anim.timing.InstanceTime endInstanceTime;
    protected java.util.LinkedList beginDependents = new java.util.LinkedList(
      );
    protected java.util.LinkedList endDependents = new java.util.LinkedList(
      );
    public Interval(float begin, float end, org.apache.batik.anim.timing.InstanceTime beginInstanceTime,
                    org.apache.batik.anim.timing.InstanceTime endInstanceTime) {
        super(
          );
        this.
          begin =
          begin;
        this.
          end =
          end;
        this.
          beginInstanceTime =
          beginInstanceTime;
        this.
          endInstanceTime =
          endInstanceTime;
    }
    public java.lang.String toString() { return org.apache.batik.anim.timing.TimedElement.
                                           toString(
                                             begin) +
                                         ".." +
                                         org.apache.batik.anim.timing.TimedElement.
                                           toString(
                                             end);
    }
    public float getBegin() { return begin; }
    public float getEnd() { return end; }
    public org.apache.batik.anim.timing.InstanceTime getBeginInstanceTime() {
        return beginInstanceTime;
    }
    public org.apache.batik.anim.timing.InstanceTime getEndInstanceTime() {
        return endInstanceTime;
    }
    void addDependent(org.apache.batik.anim.timing.InstanceTime dependent,
                      boolean forBegin) { if (forBegin) {
                                              beginDependents.
                                                add(
                                                  dependent);
                                          }
                                          else {
                                              endDependents.
                                                add(
                                                  dependent);
                                          } }
    void removeDependent(org.apache.batik.anim.timing.InstanceTime dependent,
                         boolean forBegin) { if (forBegin) {
                                                 beginDependents.
                                                   remove(
                                                     dependent);
                                             }
                                             else {
                                                 endDependents.
                                                   remove(
                                                     dependent);
                                             } }
    float setBegin(float begin) { float minTime =
                                    java.lang.Float.
                                      POSITIVE_INFINITY;
                                  this.begin = begin;
                                  java.util.Iterator i =
                                    beginDependents.
                                    iterator(
                                      );
                                  while (i.hasNext(
                                             )) {
                                      org.apache.batik.anim.timing.InstanceTime it =
                                        (org.apache.batik.anim.timing.InstanceTime)
                                          i.
                                          next(
                                            );
                                      float t =
                                        it.
                                        dependentUpdate(
                                          begin);
                                      if (t <
                                            minTime) {
                                          minTime =
                                            t;
                                      }
                                  }
                                  return minTime;
    }
    float setEnd(float end, org.apache.batik.anim.timing.InstanceTime endInstanceTime) {
        float minTime =
          java.lang.Float.
            POSITIVE_INFINITY;
        this.
          end =
          end;
        this.
          endInstanceTime =
          endInstanceTime;
        java.util.Iterator i =
          endDependents.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                i.
                next(
                  );
            float t =
              it.
              dependentUpdate(
                end);
            if (t <
                  minTime) {
                minTime =
                  t;
            }
        }
        return minTime;
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
      ("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" +
       "rwDwoyH07vNu/wBou4dc3guP7To9HkLv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vGUnsEjzn5Ntnwiha2fb5ncu8t+T7W6E0JXjdmDa3cPJJj8eQveAJvnj094t" +
       "Tj1310+SC6fD0KOFdP2NrHEicn3yVLxZXC4/jA0j5uCI/iuv9kcf/17tl3f3" +
       "AVVbybJ8lEs0dP/uauJRfPnEbUc7HOti75kfPvTrl586jIUf2gl87MEnZHvv" +
       "rS/ftddeWFyXy37rkd/48K+8+o3iEPb/ARaRCb31LwAA");
}
