package org.apache.batik.svggen.font;
public class Glyph {
    protected short leftSideBearing;
    protected int advanceWidth;
    private org.apache.batik.svggen.font.Point[] points;
    public Glyph(org.apache.batik.svggen.font.table.GlyphDescription gd, short lsb,
                 int advance) { super();
                                leftSideBearing = lsb;
                                advanceWidth = advance;
                                describe(gd); }
    public int getAdvanceWidth() { return advanceWidth; }
    public short getLeftSideBearing() { return leftSideBearing; }
    public org.apache.batik.svggen.font.Point getPoint(int i) { return points[i];
    }
    public int getPointCount() { return points.length; }
    public void reset() {  }
    public void scale(int factor) { for (int i = 0; i < points.
                                                          length;
                                         i++) { points[i].
                                                  x = (points[i].
                                                         x <<
                                                         10) *
                                                        factor >>
                                                        26;
                                                points[i].
                                                  y = (points[i].
                                                         y <<
                                                         10) *
                                                        factor >>
                                                        26;
                                    }
                                    leftSideBearing = (short)
                                                        (leftSideBearing *
                                                           factor >>
                                                           6);
                                    advanceWidth = advanceWidth *
                                                     factor >>
                                                     6; }
    private void describe(org.apache.batik.svggen.font.table.GlyphDescription gd) {
        int endPtIndex =
          0;
        points =
          (new org.apache.batik.svggen.font.Point[gd.
                                                    getPointCount(
                                                      ) +
                                                    2]);
        for (int i =
               0;
             i <
               gd.
               getPointCount(
                 );
             i++) {
            boolean endPt =
              gd.
              getEndPtOfContours(
                endPtIndex) ==
              i;
            if (endPt) {
                endPtIndex++;
            }
            points[i] =
              new org.apache.batik.svggen.font.Point(
                gd.
                  getXCoordinate(
                    i),
                gd.
                  getYCoordinate(
                    i),
                (gd.
                   getFlags(
                     i) &
                   org.apache.batik.svggen.font.table.GlyfDescript.
                     onCurve) !=
                  0,
                endPt);
        }
        points[gd.
                 getPointCount(
                   )] =
          new org.apache.batik.svggen.font.Point(
            0,
            0,
            true,
            true);
        points[gd.
                 getPointCount(
                   ) +
                 1] =
          new org.apache.batik.svggen.font.Point(
            advanceWidth,
            0,
            true,
            true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ueeueNTgZ3lt2RYhwqPWWnz78n8BCRmKxEEiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VsmWmOdlL9do4Or+mtfRqeGz9+3tsK8r");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gxe++fAvXn/vYWzx8J7hYxU+wdvT977IRNpeVF09yn/1sV966Wdf+1J1GPX/" +
       "APPYRWUcLQAA");
}
