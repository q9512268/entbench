package org.apache.batik.ext.awt.geom;
public class SegmentList {
    java.util.List segments = new java.util.LinkedList();
    public SegmentList() { super(); }
    public SegmentList(java.awt.Shape s) { super();
                                           java.awt.geom.PathIterator pi =
                                             s.
                                             getPathIterator(
                                               null);
                                           float[] pts = new float[6];
                                           int type;
                                           java.awt.geom.Point2D.Double loc =
                                             null;
                                           java.awt.geom.Point2D.Double openLoc =
                                             null;
                                           while (!pi.isDone()) {
                                               type =
                                                 pi.
                                                   currentSegment(
                                                     pts);
                                               switch (type) {
                                                   case java.awt.geom.PathIterator.
                                                          SEG_MOVETO:
                                                       openLoc =
                                                         (loc =
                                                            new java.awt.geom.Point2D.Double(
                                                              pts[0],
                                                              pts[1]));
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_LINETO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Linear(
                                                                 loc,
                                                                 p0));
                                                           loc =
                                                             p0;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_QUADTO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           java.awt.geom.Point2D.Double p1 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[2],
                                                             pts[3]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Quadradic(
                                                                 loc,
                                                                 p0,
                                                                 p1));
                                                           loc =
                                                             p1;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_CUBICTO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           java.awt.geom.Point2D.Double p1 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[2],
                                                             pts[3]);
                                                           java.awt.geom.Point2D.Double p2 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[4],
                                                             pts[5]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Cubic(
                                                                 loc,
                                                                 p0,
                                                                 p1,
                                                                 p2));
                                                           loc =
                                                             p2;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_CLOSE:
                                                       segments.
                                                         add(
                                                           new org.apache.batik.ext.awt.geom.Linear(
                                                             loc,
                                                             openLoc));
                                                       loc =
                                                         openLoc;
                                                       break;
                                               }
                                               pi.
                                                 next(
                                                   );
                                           }
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.util.Iterator iter =
          iterator(
            );
        if (!iter.
              hasNext(
                ))
            return null;
        java.awt.geom.Rectangle2D ret;
        ret =
          (java.awt.geom.Rectangle2D)
            ((org.apache.batik.ext.awt.geom.Segment)
               iter.
               next(
                 )).
            getBounds2D(
              ).
            clone(
              );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Segment seg =
              (org.apache.batik.ext.awt.geom.Segment)
                iter.
                next(
                  );
            java.awt.geom.Rectangle2D segB =
              seg.
              getBounds2D(
                );
            java.awt.geom.Rectangle2D.
              union(
                segB,
                ret,
                ret);
        }
        return ret;
    }
    public void add(org.apache.batik.ext.awt.geom.Segment s) {
        segments.
          add(
            s);
    }
    public java.util.Iterator iterator() {
        return segments.
          iterator(
            );
    }
    public int size() { return segments.size(
                                          );
    }
    public org.apache.batik.ext.awt.geom.SegmentList.SplitResults split(double y) {
        java.util.Iterator iter =
          segments.
          iterator(
            );
        org.apache.batik.ext.awt.geom.SegmentList above =
          new org.apache.batik.ext.awt.geom.SegmentList(
          );
        org.apache.batik.ext.awt.geom.SegmentList below =
          new org.apache.batik.ext.awt.geom.SegmentList(
          );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Segment seg =
              (org.apache.batik.ext.awt.geom.Segment)
                iter.
                next(
                  );
            org.apache.batik.ext.awt.geom.Segment.SplitResults results =
              seg.
              split(
                y);
            if (results ==
                  null) {
                java.awt.geom.Rectangle2D bounds =
                  seg.
                  getBounds2D(
                    );
                if (bounds.
                      getY(
                        ) >
                      y) {
                    below.
                      add(
                        seg);
                }
                else
                    if (bounds.
                          getY(
                            ) ==
                          y) {
                        if (bounds.
                              getHeight(
                                ) !=
                              0) {
                            below.
                              add(
                                seg);
                        }
                    }
                    else {
                        above.
                          add(
                            seg);
                    }
                continue;
            }
            org.apache.batik.ext.awt.geom.Segment[] resAbove =
              results.
              getAbove(
                );
            for (int i =
                   0;
                 i <
                   resAbove.
                     length;
                 i++) {
                above.
                  add(
                    resAbove[i]);
            }
            org.apache.batik.ext.awt.geom.Segment[] resBelow =
              results.
              getBelow(
                );
            for (int i =
                   0;
                 i <
                   resBelow.
                     length;
                 i++) {
                below.
                  add(
                    resBelow[i]);
            }
        }
        return new org.apache.batik.ext.awt.geom.SegmentList.SplitResults(
          above,
          below);
    }
    public static class SplitResults {
        final org.apache.batik.ext.awt.geom.SegmentList
          above;
        final org.apache.batik.ext.awt.geom.SegmentList
          below;
        public SplitResults(org.apache.batik.ext.awt.geom.SegmentList above,
                            org.apache.batik.ext.awt.geom.SegmentList below) {
            super(
              );
            if (above !=
                  null &&
                  above.
                  size(
                    ) >
                  0) {
                this.
                  above =
                  above;
            }
            else {
                this.
                  above =
                  null;
            }
            if (below !=
                  null &&
                  below.
                  size(
                    ) >
                  0) {
                this.
                  below =
                  below;
            }
            else {
                this.
                  below =
                  null;
            }
        }
        public org.apache.batik.ext.awt.geom.SegmentList getAbove() {
            return above;
        }
        public org.apache.batik.ext.awt.geom.SegmentList getBelow() {
            return below;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "8S1kd4X472Wx/0viFYer/wEdGVY1+hcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "opP+4d2//6bfeeZb+T3m/wCIOwjUlSIAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Gv4HWIHizKYgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zu/lXg/1OAnd5bkd3WdOJPuuY2nyR5Ll73MwcNEKLlVWcND9fbb0P36ftk+U" +
       "xU/F0COmHg+8xNWi5vB4p/F7To4OqgPWha4CBk1bP4KoTOmn38rxQFXxk+cP" +
       "RZ4Fj3rEu/rd4f3CCcgL39a5cYXp0/eR1D8pi5+LoQdk7XBTwz3jSmEMXQHJ" +
       "SjsVzKe+A8G8o6x8N3jMI8GY332j+Nx92t4oi1+IoWtWrFfHnxUUd15xb78f" +
       "fceyf+J0b508wlW2/ItTOf3idyCnG8d0WEd0WN99OX3+Pm3/six+Iz6ci97N" +
       "Jh6wjm5LVaz+5nfA6q2y8kXw7I5Y3X33feUC8Vc1L1Hsw4nhl+4jhS+XxRdi" +
       "EK1924qPNd/5tm9r3OLKfgs9Suw4OpXWF9/SwSOIYGdQlqfZT91xv+xwJ0r9" +
       "5dduXHvXa/x/qu5AnNxbepiGrhmJbZ89hjvzftUPdcOq+H34cCjnVz9/EEPP" +
       "3JdTYB3lT0Xx7x/6/GEMPXWvPmV8yeKz0F+NoXfcDRpAgvIs5B/H0M2LkEAt" +
       "1e9ZuP8WQ9dP4YCiDy9nQb4GsAOQ8vVP/bucPB1OOvNL5/P+ie6e+Fa6OzNV" +
       "eP5cgq/uDh4n42R2dJ74xmsU86Pf6Pz84fqHastFUWK5RkMPHW6inCT0990T" +
       "2zGuq8SL33zsVx5+4Xjy8diB4FP3OUPbe+5+1wJ3/Li6HVH8xrt+9Qf+6Wt/" +
       "VB2E/T/mGzPb1CkAAA==");
}
