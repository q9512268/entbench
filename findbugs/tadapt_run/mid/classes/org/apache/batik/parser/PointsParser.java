package org.apache.batik.parser;
public class PointsParser extends org.apache.batik.parser.NumberParser {
    protected org.apache.batik.parser.PointsHandler pointsHandler;
    protected boolean eRead;
    public PointsParser() { super();
                            pointsHandler = org.apache.batik.parser.DefaultPointsHandler.
                                              INSTANCE; }
    public void setPointsHandler(org.apache.batik.parser.PointsHandler handler) {
        pointsHandler =
          handler;
    }
    public org.apache.batik.parser.PointsHandler getPointsHandler() {
        return pointsHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { pointsHandler.startPoints();
                              current = reader.read();
                              skipSpaces();
                              loop: for (; ; ) { if (current ==
                                                       -1) {
                                                     break loop;
                                                 }
                                                 float x =
                                                   parseFloat(
                                                     );
                                                 skipCommaSpaces(
                                                   );
                                                 float y =
                                                   parseFloat(
                                                     );
                                                 pointsHandler.
                                                   point(
                                                     x,
                                                     y);
                                                 skipCommaSpaces(
                                                   ); }
                              pointsHandler.endPoints(); }
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
