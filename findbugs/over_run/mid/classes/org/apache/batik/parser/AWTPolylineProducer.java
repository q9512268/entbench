package org.apache.batik.parser;
public class AWTPolylineProducer implements org.apache.batik.parser.PointsHandler, org.apache.batik.parser.ShapeProducer {
    protected java.awt.geom.GeneralPath path;
    protected boolean newPath;
    protected int windingRule;
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PointsParser p =
                                                   new org.apache.batik.parser.PointsParser(
                                                   );
                                                 org.apache.batik.parser.AWTPolylineProducer ph =
                                                   new org.apache.batik.parser.AWTPolylineProducer(
                                                   );
                                                 ph.
                                                   setWindingRule(
                                                     wr);
                                                 p.
                                                   setPointsHandler(
                                                     ph);
                                                 p.
                                                   parse(
                                                     r);
                                                 return ph.
                                                   getShape(
                                                     );
    }
    public void setWindingRule(int i) { windingRule =
                                          i;
    }
    public int getWindingRule() { return windingRule;
    }
    public java.awt.Shape getShape() { return path;
    }
    public void startPoints() throws org.apache.batik.parser.ParseException {
        path =
          new java.awt.geom.GeneralPath(
            windingRule);
        newPath =
          true;
    }
    public void point(float x, float y) throws org.apache.batik.parser.ParseException {
        if (newPath) {
            newPath =
              false;
            path.
              moveTo(
                x,
                y);
        }
        else {
            path.
              lineTo(
                x,
                y);
        }
    }
    public void endPoints() throws org.apache.batik.parser.ParseException {
        
    }
    public AWTPolylineProducer() { super(
                                     ); }
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
       "10unBHsD/sCL3B19rEi+F2iYWpny4keqt68i1zxV/aOvQPWrReHD4BkeqT58" +
       "dVQ/q9lPvkjdTxfJjwKt5+e0Lk12quGPvQINS8x7I3ikIw2lV1/DX3yRul8q" +
       "kp/LoDuBhmXMFu/Pner28680cAvvvetIt3e9+rr91q2D+rtKgk8Wya+D4Qpw" +
       "Lcn2E0JR9Pypjp94pTp+EXjMIx3NV0fHs+B1YXzdYfuRVl5a/HHJ+kcvZYJP" +
       "F8nvAsY4OrrtOKP8771S5b8QPPGR8vGr7+C/fSnt/r5I/iIrvw26qXv/8uVo" +
       "uAETxU0+aClu5B+84Yu6/Vdgxg8/d/XOB56Tfq/8puPkS627htCddu77Zy9Q" +
       "z+Qvx4llu6UGd+2vU+Py758y6IFbzEbFBw9lppT6H/f0n8ugaxfpgavL/7N0" +
       "/5ZBd5/Sgab2mbMk/5FBtwGSIvuf8U1uoPb3yJtLZ9Y2RyFR2vn+l7LzCcvZ" +
       "Tz6K9VD5RePx2iXff9P4tPHx5xjuqz5b/779JyeGr+12RSt3DqEr+69fTtY/" +
       "j9+yteO2Lvee/Py9P3LXE8drtXv3Ap+G5xnZHr35Nx1UEGflVxi7n3rgx7/0" +
       "+5/70/JC7H8AlOYKcmoqAAA=");
}
