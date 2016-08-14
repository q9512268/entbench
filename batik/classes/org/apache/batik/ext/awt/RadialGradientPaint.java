package org.apache.batik.ext.awt;
public final class RadialGradientPaint extends org.apache.batik.ext.awt.MultipleGradientPaint {
    private java.awt.geom.Point2D focus;
    private java.awt.geom.Point2D center;
    private float radius;
    public RadialGradientPaint(float cx, float cy, float radius, float[] fractions,
                               java.awt.Color[] colors) { this(cx,
                                                               cy,
                                                               radius,
                                                               cx,
                                                               cy,
                                                               fractions,
                                                               colors);
    }
    public RadialGradientPaint(java.awt.geom.Point2D center, float radius,
                               float[] fractions,
                               java.awt.Color[] colors) { this(center,
                                                               radius,
                                                               center,
                                                               fractions,
                                                               colors);
    }
    public RadialGradientPaint(float cx, float cy, float radius, float fx,
                               float fy,
                               float[] fractions,
                               java.awt.Color[] colors) { this(new java.awt.geom.Point2D.Float(
                                                                 cx,
                                                                 cy),
                                                               radius,
                                                               new java.awt.geom.Point2D.Float(
                                                                 fx,
                                                                 fy),
                                                               fractions,
                                                               colors,
                                                               NO_CYCLE,
                                                               SRGB);
    }
    public RadialGradientPaint(java.awt.geom.Point2D center,
                               float radius,
                               java.awt.geom.Point2D focus,
                               float[] fractions,
                               java.awt.Color[] colors) {
        this(
          center,
          radius,
          focus,
          fractions,
          colors,
          NO_CYCLE,
          SRGB);
    }
    public RadialGradientPaint(java.awt.geom.Point2D center,
                               float radius,
                               java.awt.geom.Point2D focus,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace) {
        this(
          center,
          radius,
          focus,
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          new java.awt.geom.AffineTransform(
            ));
    }
    public RadialGradientPaint(java.awt.geom.Point2D center,
                               float radius,
                               java.awt.geom.Point2D focus,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                               java.awt.geom.AffineTransform gradientTransform) {
        super(
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          gradientTransform);
        if (center ==
              null) {
            throw new java.lang.NullPointerException(
              "Center point should not be null.");
        }
        if (focus ==
              null) {
            throw new java.lang.NullPointerException(
              "Focus point should not be null.");
        }
        if (radius <=
              0) {
            throw new java.lang.IllegalArgumentException(
              "radius should be greater than zero");
        }
        this.
          center =
          (java.awt.geom.Point2D)
            center.
            clone(
              );
        this.
          focus =
          (java.awt.geom.Point2D)
            focus.
            clone(
              );
        this.
          radius =
          radius;
    }
    public RadialGradientPaint(java.awt.geom.Rectangle2D gradientBounds,
                               float[] fractions,
                               java.awt.Color[] colors) {
        this(
          (float)
            gradientBounds.
            getX(
              ) +
            (float)
              gradientBounds.
              getWidth(
                ) /
            2,
          (float)
            gradientBounds.
            getY(
              ) +
            (float)
              gradientBounds.
              getWidth(
                ) /
            2,
          (float)
            gradientBounds.
            getWidth(
              ) /
            2,
          fractions,
          colors);
    }
    public java.awt.PaintContext createContext(java.awt.image.ColorModel cm,
                                               java.awt.Rectangle deviceBounds,
                                               java.awt.geom.Rectangle2D userBounds,
                                               java.awt.geom.AffineTransform transform,
                                               java.awt.RenderingHints hints) {
        transform =
          new java.awt.geom.AffineTransform(
            transform);
        transform.
          concatenate(
            gradientTransform);
        try {
            return new org.apache.batik.ext.awt.RadialGradientPaintContext(
              cm,
              deviceBounds,
              userBounds,
              transform,
              hints,
              (float)
                center.
                getX(
                  ),
              (float)
                center.
                getY(
                  ),
              radius,
              (float)
                focus.
                getX(
                  ),
              (float)
                focus.
                getY(
                  ),
              fractions,
              colors,
              cycleMethod,
              colorSpace);
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            throw new java.lang.IllegalArgumentException(
              "transform should be " +
              "invertible");
        }
    }
    public java.awt.geom.Point2D getCenterPoint() {
        return new java.awt.geom.Point2D.Double(
          center.
            getX(
              ),
          center.
            getY(
              ));
    }
    public java.awt.geom.Point2D getFocusPoint() {
        return new java.awt.geom.Point2D.Double(
          focus.
            getX(
              ),
          focus.
            getY(
              ));
    }
    public float getRadius() { return radius;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WA9mKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZMItyvLUpSviGs0YzcAcrk3EG59L65pA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BMaGBjM4ot3JViMqFvuBHkezdRrV65v+LCjXObaRwuUOP9cmramtqTUQm7ej" +
       "dKz7KSaJi4aHKmNAYxNrRS20jq1kwUhoZYNRzNhyuUnHG62sLlZesTMqyqaq" +
       "pNUndavGE5Ejixt9lkjCkpF1bFtZQOtZL2xq6ahFsTgNGTGeqpoxjRfNhi4v" +
       "+/252N8k0NagM7rSbGFoswurs7XXHMm1uYrEZHUyrdAzKmyOTJYgyxV4MRqN" +
       "UKK2tBUzNVxEJIIpgZjeqJ6RdK2+rnI9HySOEJdo7dV0XJaUBbAAm0shZGvM" +
       "8aYzHOHF8tCf3tuy1SPFCt3hQWXTbuQV//UeVqaSszs8vmt9uMJZ/PJlzhNn" +
       "Xk8vdT9xsMQelJ4671hycTLrU6+8+prCfhq5tL+K3YhK90ee/1dsdaPax1Dt" +
       "tjcnh2Q8kaN/oVTa+40dFbv7OYv1Z66yft9Ofmdvn929Mm84kqbuzgHQnrJP" +
       "G4B49BDicNk+r/n1vPjlA6DHjwG5ipovk/YNNwpzEvbuP39Rf++RvLgSlR6U" +
       "A1WK1P0T9Qdoj7Z6i02m47W5zveu3vNuyJGA8+MdpeeArPZ3Xvcu2rS9BwEf" +
       "5+6pC+qeyYsnotJDmhq1iqX5Yie7WJ8/4vAd3ymHzwJiv7rP4VfffA5fvKCu" +
       "nBe3gG4Bh918P+QsBl/4Dhgs3PVJQOuf7DP4J28+g7UL6vI4tAcDhwYMjo92" +
       "Mo6YQ+5piyoqPXbGufH8EOwTd/0/ZfefCvmzrz18/fHXpv9+d5zy4H8P91Ol" +
       "66vYto+fgzv2fM0P1JVRcH7/7tSJX7Dzgaj0xHm7vlHpMihzmvfev4PGo9Jb" +
       "z4IGkPs+egDZjko3T0NGpavF/ThcLyrdOIKLStd2D8dBBgA7AMkfh/5BlLh9" +
       "b1vVyd7JCH44gjz67bR1LOg/f+L0T/Evo4Njc/Huf0Z35M+9NmB++Jv1T+/O" +
       "h8u2lGU5lutU6b7dUfUCaX707rlzsR3gutZ/8VsP/dL9LxwMIw/tCD6y72O0" +
       "PXP2YeyO40fF8ensnz3+y+/7hdf+sNhO+n/DHDMf/jUAAA==");
}
