package org.apache.batik.parser;
public class AWTPolygonProducer extends org.apache.batik.parser.AWTPolylineProducer {
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PointsParser p =
                                                   new org.apache.batik.parser.PointsParser(
                                                   );
                                                 org.apache.batik.parser.AWTPolygonProducer ph =
                                                   new org.apache.batik.parser.AWTPolygonProducer(
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
    public void endPoints() throws org.apache.batik.parser.ParseException {
        path.
          closePath(
            );
    }
    public AWTPolygonProducer() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7JtGRTu3vGHwAH2aNeS/ROK42NIVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
