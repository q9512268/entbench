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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "l0cKTgL9uv5fnaEyiVUXAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "v8Rs/uCu33vz7zzz7fz+8X8ALHaxi2kiAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UxaL/gt+j4cC/x8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P/RnVftTYCtbP1vcOeeARepp2/qveX9x+bmr/+Yy9JAK3TSOVsCK5mYlXKhg" +
       "1ZccL4vBKvlc/fkV3GG58tIJcL/7Iqie6fYipJ7OdSBfUpf56xdQ9MoxqDx/" +
       "FAvPXwyjS1CVYQ+RVKW3yuSvn43Lx/8K/C6B5/+WT1leFhyWIE90j9ZB7z1Z" +
       "CIVg8r2WHKbXBHj1fffw6kTbVkvHl43fFr/+1c/t33j9gF66BtZGEHyvXcid" +
       "G6FyMnvhPhPy6fr0L5gfefMbf6z8+OWj6H3kvKmu3c9U50fIEXYccHZ+Ohqr" +
       "QcB9p0HAlIlQXAKzwoP129jtWvn+Y3d3wgNl9v1g+kiqzQ5osXR8za3kF1IA" +
       "Za5x69gJCtj8gFFwa+1ix+LerMQt4+32YcdwQVbhu5YVuPKxU2ZsADYfP/9f" +
       "PvmVX3j+a8BvQ+jBvIxw4IozPfJZuR/72dc/9cwjr37956vZEGCN8Gnq5odL" +
       "rvb9NC6Tj5SJdqzq06WqUrWgZLUk5aoJzDIrbe8LHkLseGCez482G8grT3xt" +
       "89k/+cJhI3ERKS4QWx9/9ef+6vYnXr18Zvv2/B07qLNtDlu4Sui3HVn47CC4" +
       "Sy9VC/q/vfHKP/+VVz52kOqJ85sRCuy1v/Af/s9Xbn/m679zl7XuFTf4Hhyb" +
       "3vh7/WYyII9/bE3VWqRc6G4Da9QMYjsYt/p9siFTeME3bHIXWJSBrU3d7rv7" +
       "zN444+aew2qYXWuM9wJH8Nt0gnZXi0jiJgq9o7wRJdkFE0y6iUtLDh1MZGpF" +
       "0GtyVlDhnFLbIR7Q852II9RE4FEC34+xcdFja1JD80MsxJC8jWBWgzAxrI/K" +
       "i1UUSBNTlkRnok+DukigtYZTWwzDRZvmqBqK9/Wov563kTRjEHRfGE17lKE9" +
       "dFnv1iV5NHSbq0VN3sEEyc2ms2EwiBfzwbiY9Jh2b1Y4C5QEganXA9nb1VVf" +
       "phVPllTDW4jRVpySTkQ17WLYWdMJY/I201U3+kIz2IQf03Wh1tE79GzoxRg/" +
       "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" +
       "/9a7/umP/qPX/qi60Pp/IhbslrgpAAA=");
}
