package org.apache.batik.ext.awt;
public final class LinearGradientPaint extends org.apache.batik.ext.awt.MultipleGradientPaint {
    private java.awt.geom.Point2D start;
    private java.awt.geom.Point2D end;
    public LinearGradientPaint(float startX, float startY, float endX, float endY,
                               float[] fractions,
                               java.awt.Color[] colors) { this(new java.awt.geom.Point2D.Float(
                                                                 startX,
                                                                 startY),
                                                               new java.awt.geom.Point2D.Float(
                                                                 endX,
                                                                 endY),
                                                               fractions,
                                                               colors,
                                                               NO_CYCLE,
                                                               SRGB);
    }
    public LinearGradientPaint(float startX, float startY,
                               float endX,
                               float endY,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod) {
        this(
          new java.awt.geom.Point2D.Float(
            startX,
            startY),
          new java.awt.geom.Point2D.Float(
            endX,
            endY),
          fractions,
          colors,
          cycleMethod,
          SRGB);
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors) {
        this(
          start,
          end,
          fractions,
          colors,
          NO_CYCLE,
          SRGB);
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace) {
        this(
          start,
          end,
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          new java.awt.geom.AffineTransform(
            ));
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
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
        if (start ==
              null ||
              end ==
              null) {
            throw new java.lang.NullPointerException(
              "Start and end points must be" +
              "non-null");
        }
        if (start.
              equals(
                end)) {
            throw new java.lang.IllegalArgumentException(
              "Start point cannot equal" +
              "endpoint");
        }
        this.
          start =
          (java.awt.geom.Point2D)
            start.
            clone(
              );
        this.
          end =
          (java.awt.geom.Point2D)
            end.
            clone(
              );
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
            return new org.apache.batik.ext.awt.LinearGradientPaintContext(
              cm,
              deviceBounds,
              userBounds,
              transform,
              hints,
              start,
              end,
              fractions,
              this.
                getColors(
                  ),
              cycleMethod,
              colorSpace);
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            e.
              printStackTrace(
                );
            throw new java.lang.IllegalArgumentException(
              "transform should be" +
              "invertible");
        }
    }
    public java.awt.geom.Point2D getStartPoint() {
        return new java.awt.geom.Point2D.Double(
          start.
            getX(
              ),
          start.
            getY(
              ));
    }
    public java.awt.geom.Point2D getEndPoint() {
        return new java.awt.geom.Point2D.Double(
          end.
            getX(
              ),
          end.
            getY(
              ));
    }
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
       "0kYCPZD4wfc62kpzjg11aXeadojGU/nw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("L0PQBXQ/3Yuekyk+M734PTv+nUrbXjmWZ30igd51mPi1XMnQdueLrK/u4wYg" +
       "HjuEmGhKInnG0WH5u05mjQ/bdycUv3AA9uSxETxVy/OHlOUlcYHfn5yTVv5v" +
       "efEfE+hhJdKkRNu/H3z32UiR1j/eWijEf7rvPP0R9/PzZuh5wMj9/O6Fu/K7" +
       "3xr3j1F3ATqnrdDMbwLKDS3h8nx1cfJT5IiPCPyzvyiB+UGEtk+g9u0n8KFz" +
       "2vID1AvXEuhBQCDuqWeQd+H6fR0iJNDjZ9wEza+1PXXXbfTdDWrli6/fvP7k" +
       "68K/3N2NOrjl/EAfuq6njnP84sqx+tUg0nSroP2B3VFwUBAEFPKpe51DJdAl" +
       "UOY4X3jHDvqpBHrHWdD5WUB2AvK7EujWacgEulL8Hod7NoFuHMEl0NVd5TjI" +
       "C2B0AJJXXwwOrGjv/g7Psgsn3d+hMj72dtI65jFfOnEkX/xPwcE9l3T3XwV3" +
       "lC+9zgx+4Bvoz+1ufCoO2L/lo1zvQ9d2l0+LQfO7Mi/cc7SDsa5S7/3mI7/8" +
       "wMsHPviRHcJHGn4Mt+fOvl6Ju0FSXIjc/oMn/94H/s7rf1icQ/xfY4U8D+wx" +
       "AAA=");
}
