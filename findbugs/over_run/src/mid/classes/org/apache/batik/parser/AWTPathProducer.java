package org.apache.batik.parser;
public class AWTPathProducer implements org.apache.batik.parser.PathHandler, org.apache.batik.parser.ShapeProducer {
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath path;
    protected float currentX;
    protected float currentY;
    protected float xCenter;
    protected float yCenter;
    protected int windingRule;
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PathParser p =
                                                   new org.apache.batik.parser.PathParser(
                                                   );
                                                 org.apache.batik.parser.AWTPathProducer ph =
                                                   new org.apache.batik.parser.AWTPathProducer(
                                                   );
                                                 ph.
                                                   setWindingRule(
                                                     wr);
                                                 p.
                                                   setPathHandler(
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
    public void startPath() throws org.apache.batik.parser.ParseException {
        currentX =
          0;
        currentY =
          0;
        xCenter =
          0;
        yCenter =
          0;
        path =
          new org.apache.batik.ext.awt.geom.ExtendedGeneralPath(
            windingRule);
    }
    public void endPath() throws org.apache.batik.parser.ParseException {
        
    }
    public void movetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void movetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void closePath() throws org.apache.batik.parser.ParseException {
        path.
          closePath(
            );
        java.awt.geom.Point2D pt =
          path.
          getCurrentPoint(
            );
        currentX =
          (float)
            pt.
            getX(
              );
        currentY =
          (float)
            pt.
            getY(
              );
    }
    public void linetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void linetoHorizontalRel(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              currentY);
    }
    public void linetoHorizontalAbs(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              currentY);
    }
    public void linetoVerticalRel(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoVerticalAbs(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY =
                 y));
    }
    public void curvetoCubicRel(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX +
              x1,
            currentY +
              y1,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicAbs(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            x1,
            y1,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoCubicSmoothRel(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicSmoothAbs(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticRel(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX +
                x1,
            yCenter =
              currentY +
                y1,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticAbs(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              x1,
            yCenter =
              y1,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticSmoothRel(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticSmoothAbs(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX =
              x,
            currentY =
              y);
    }
    public void arcRel(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void arcAbs(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public AWTPathProducer() { super(); }
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
       "vs3u3rMTsbUZcfwN/IFXnPCvCwf+tXGt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Y/vMF46aevNO2nB2GU1SN3sHflbv11683l179Tp9PFY0d1+noOxtp7sP+LfP" +
       "nnXzXEqeCXK3KZ4mBVrmNEdlS/cODx5no+DjZ72HPrynnD34l/vKvS19+AC4" +
       "hK1yhZeg3Gxv48Hr6nXngGGjwM+9yAb/f0jJZwBCXwvGL75BcnHlGOoB9H93" +
       "A9Cvpg/TnblHt9AfPR/oh5F9+UXK/iAlXwCoZ0dQZyo7QPjFG0CYRbzXgUvf" +
       "ItTPH+GfvEjZ11LyR0HuCkCY+Wz6+98eYPvqjTruG8DlbLE554/tz0936k9l" +
       "DH+RkhdAaAZxzQv2tu9/9wDh128UYWq9ZIswOX+E3zkL4f9OybeC7PvF6+D7" +
       "qxvFlwfXB7b4PnA++C4cBP5s35fJuH54FtK/Scn3gS0tZ6UFDqOZx7D+9Xlg" +
       "fXyL9fGXEevOlTOw7tyakpv2sSKyfxTrzsXzGJlPbLE+ce5+u/OqsxC+JiVX" +
       "AULFdHztpOfuXDsPaz61RfjUy2nNt5yF9d6UvAFgTb8mvo7n7rzxPLB+bIv1" +
       "Yy8n1neehXU3JW/fx3rScx+8UazvBNcntlg/cT5YD6HYwKyfBfPvpaQM8soN" +
       "TMLxjCT9CM88aVz4PAA/twX83MsEGDsLcCslP3kdwCct/MiNAn4HuD69Bfzp" +
       "lwnw4CzAqdPvkGChuwHMa15gKNezL3UecD+7hfvZlwnuT50F9z0pGZ+Ae9K6" +
       "wo3CLYLr97ZwP38+cC9lDJcOYtX1SAZTP0sP85QoQe6qEnrp1IuGsqGcNLp6" +
       "Hlr4ylYL/+XHrYXgLC2sUuIc08JJX3BvVAvpV43/bauFr52PFi5mDBdPxf6B" +
       "s7B/MCXvC3KvPoydtRwn0E/6wfvPQwPf3GrgGz8eDfzTszTwREoev64GTvrA" +
       "h25UAxVwfX+rge/9eDTw1Fka+Ocp+SUw2201MAwl1Us/yDzpAU+eA/6dnU3d" +
       "zb+XH/8zZ+H/REo+dh38J+3/L24U/8Og5ytb/FfOB//1c9dPnYX6N1Pyb4Lc" +
       "646jPm30P3se2O/aYr/r5cT+78/C/jsp+e1TsZ+0+2duFPuDoP97t9jffD7Y" +
       "L2cMl4+5fFZ87DXlZdlxTE1Kj5PtfOmYrr54lq7+c0o+H+QuSd51AsJ/PA/F" +
       "7G4Vk385FbMH/oQG/vgsDfxpSv5wo4GTrvFHL0UDMcgyjp3yTI+p3X3iaPnm" +
       "OLTyG09fvfLap0d/nB103D+yfAuVuzINTfPwqaJD95dcT5samWpu2ZwxcjMc" +
       "Xw9yrz3l7X96CjC7SSXeeWHD/z+D3LXj/EHu5uz/Yb6/CHK3HvClespuDrN8" +
       "M8jdBFjS2790M60c/X5/c7gq3smK7j7sLqmOc3eepeP9KofPQab7T9nR/r29" +
       "onBzuP9R5ZNPd3vv+27145tzmIopJUnayhUqd3lzJDRrNN1veuupre21dYl4" +
       "6Ae3f+qWB/b2xm7fCHzguodke/P1DzrilhtkRxOTz7z20+/+V0//WXac4P8D" +
       "KUtArnNBAAA=");
}
