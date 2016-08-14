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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nJ+PU/Ji9kXxiM23/wO8G9dkdxYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rxc2f3jf77/5t57/Vn7E+b/nd9tTJCEAAA==");
}
