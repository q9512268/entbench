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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Ba57lVveNHGvRhbiP/3/Bcx/O7o4IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e/Dr2H2X7r2795XdvXc3TTbd7ntvSjdqfrIlS7ZnlxI/" +
       "ZNmybMmWJduCZqOnJetpvSwrLE3DQAIdQgY2IZ1p96+Uls426UA7dGAKywB9" +
       "TDIdmunQwkASGIYWQmYSGFogQDiSf+9772+7bMAzOj7S+Z5zvp/v93u+53se" +
       "b3wTejAKITjwnd3K8eMDPYsP1g5+EO8CPTqgGZyTw0jXOo4cRTPw7RX1+V+8" +
       "9Yff+bR5+zJ0VYLeLXueH8ux5XvRVI98J9U1Brp18pV0dDeKodvMWk5lJIkt" +
       "B2GsKH6Jgd51qmoM3WGOWEAACwhgASlZQFonVKDSw7qXuJ2ihuzF0Qb6c9Al" +
       "BroaqAV7MfTc2UYCOZTdw2a4EgFo4XrxLgJQZeUshJ49xr7HfBfgz8DIa3/j" +
       "w7f/9hXolgTdsjy+YEcFTMSgEwl6yNVdRQ+jlqbpmgQ96um6xuuhJTtWXvIt" +
       "QY9F1sqT4yTUj4VUfEwCPSz7PJHcQ2qBLUzU2A+P4RmW7mhHbw8ajrwCWN97" +
       "gnWPsFd8BwBvWoCx0JBV/ajKA7blaTH0zPkaxxjvDAEBqHrN1WPTP+7qAU8G" +
       "H6DH9rpzZG+F8HFoeStA+qCfgF5i6In7NlrIOpBVW17pr8TQ+87TcfsiQHWj" +
       "FERRJYbec56sbAlo6YlzWjqln2+OX/7UR72+d7nkWdNVp+D/Oqj09LlKU93Q" +
       "Q91T9X3Fhz7AfFZ+769+8jIEAeL3nCPe0/zdP/vtD/3w02/+xp7mB+5Bwypr" +
       "XY1fUT+vPPLbT3ZebF4p2Lge+JFVKP8M8tL8ucOSl7IAjLz3HrdYFB4cFb45" +
       "/bXlx35e/8Zl6OYAuqr6TuICO3pU9d3AcvSQ0j09lGNdG0A3dE/rlOUD6BrI" +
       "M5an77+yhhHp8QB6wCk/XfXLdyAiAzRRiOgayFue4R/lAzk2y3wWQBB0DTzQ" +
       "Q+B5Ctr/yv8YUhHTd3VEVmXP8nyEC/0Cf6FQT5ORWI9AXgOlgY8owP7tD1YP" +
       "6kjkJyEwSMQPV4gMrMLU94VIlK5WuocYQFII5ewC86AwtuD/TzdZgfb29tIl" +
       "oIgnz7sBB4ygvu9oeviK+lrSJr/9hVe+dPl4WBzKKYaeB30d7Ps6KPs62Pd1" +
       "UPR1UPYFXbpUdvF9RZ97PQMt2WC8A0/40Iv8j9If+eTzV4CBBdsHgIgLUuT+" +
       "Drlz4iEGpR9UgZlCb35u++Pij1UuQ5fPetaCT/DpZlGdK/zhsd+7c35E3avd" +
       "W5/4gz/84mdf9U/G1hlXfTjk765ZDNnnz0s09FVdA07wpPkPPCv/8iu/+uqd" +
       "y9ADwA8A3xfLwFaBW3n6fB9nhu5LR26wwPIgAGz4oSs7RdGR77oZm6G/PflS" +
       "qvqRMv8okPG7Clu+DZ4XDo27/C9K3x0U6fftTaNQ2jkUpZv9k3zw07/3W/8B" +
       "K8V95JFvnZrjeD1+6ZQXKBq7VY73R09sYBbqOqD715/j/vpnvvmJP10aAKB4" +
       "4V4d3inSDhj9QIVAzH/hNzb/4mtf/fzvXD4xmhhMg4niWGp2DLL4Dt28ACTo" +
       "7QdP+AFexAFDrLCaO4Ln+pplWLLi6IWV/s9b76/+8n/61O29HTjgy5EZ/fBb" +
       "N3Dy/fvb0Me+9OE/erps5pJazGInMjsh27vGd5+03ApDeVfwkf34V576yV+X" +
       "fxo4WeDYIivXS191pZTBlRL5e2IIu3BMxgVP+5HZ1SM1tIKS5RB68YIoKLRc" +
       "oMn0cOZAXn3sa/ZP/cEv7GeF89PMOWL9k6/95e8efOq1y6fm4hfumg5P19nP" +
       "x6UJPrzX5nfB7xJ4/nfxFFosPuz98WOdw0nh2eNZIQgyAOe5i9gqu+j9/hdf" +
       "/fs/9+on9jAeOzsVkSDS+oV//r++fPC5r//mPfzeg5Hph/sQDC0SYm93jRi6" +
       "AgKQknek/PKBMj0omC21BJVlHyqSZ6LTbuis0E/Ffa+on/6dbz0sfusffLvk" +
       "42zgeHrUjeRgL7VHiuTZQgiPn/e5fTkyAV3tzfGfue28+R3QogRaVMGsEbEh" +
       "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" +
       "4VO8PXPvS0ikG8TltaH8Vx7/pZd/9vWv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "lgdJ/wf+9VEg9CwAAA==";
}
