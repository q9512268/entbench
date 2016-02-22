package org.sunflow.math;
public final class MathUtils {
    private MathUtils() { super(); }
    public static final int clamp(int x, int min, int max) { if (x > max)
                                                                 return max;
                                                             if (x > min)
                                                                 return x;
                                                             return min; }
    public static final float clamp(float x, float min, float max) { if (x >
                                                                           max)
                                                                         return max;
                                                                     if (x >
                                                                           min)
                                                                         return x;
                                                                     return min;
    }
    public static final double clamp(double x, double min, double max) { if (x >
                                                                               max)
                                                                             return max;
                                                                         if (x >
                                                                               min)
                                                                             return x;
                                                                         return min;
    }
    public static final int min(int a, int b, int c) {
        if (a >
              b)
            a =
              b;
        if (a >
              c)
            a =
              c;
        return a;
    }
    public static final float min(float a, float b,
                                  float c) { if (a >
                                                   b)
                                                 a =
                                                   b;
                                             if (a >
                                                   c)
                                                 a =
                                                   c;
                                             return a;
    }
    public static final double min(double a, double b,
                                   double c) { if (a >
                                                     b)
                                                   a =
                                                     b;
                                               if (a >
                                                     c)
                                                   a =
                                                     c;
                                               return a;
    }
    public static final float min(float a, float b,
                                  float c,
                                  float d) { if (a >
                                                   b)
                                                 a =
                                                   b;
                                             if (a >
                                                   c)
                                                 a =
                                                   c;
                                             if (a >
                                                   d)
                                                 a =
                                                   d;
                                             return a;
    }
    public static final int max(int a, int b, int c) {
        if (a <
              b)
            a =
              b;
        if (a <
              c)
            a =
              c;
        return a;
    }
    public static final float max(float a, float b,
                                  float c) { if (a <
                                                   b)
                                                 a =
                                                   b;
                                             if (a <
                                                   c)
                                                 a =
                                                   c;
                                             return a;
    }
    public static final double max(double a, double b,
                                   double c) { if (a <
                                                     b)
                                                   a =
                                                     b;
                                               if (a <
                                                     c)
                                                   a =
                                                     c;
                                               return a;
    }
    public static final float max(float a, float b,
                                  float c,
                                  float d) { if (a <
                                                   b)
                                                 a =
                                                   b;
                                             if (a <
                                                   c)
                                                 a =
                                                   c;
                                             if (a <
                                                   d)
                                                 a =
                                                   d;
                                             return a;
    }
    public static final float smoothStep(float a,
                                         float b,
                                         float x) {
        if (x <=
              a)
            return 0;
        if (x >=
              b)
            return 1;
        float t =
          clamp(
            (x -
               a) /
              (b -
                 a),
            0.0F,
            1.0F);
        return t *
          t *
          (3 -
             2 *
             t);
    }
    public static final float fastPow(float a, float b) {
        float x =
          java.lang.Float.
          floatToRawIntBits(
            a);
        x *=
          1.0F /
            (1 <<
               23);
        x =
          x -
            127;
        float y =
          x -
          (int)
            java.lang.Math.
            floor(
              x);
        b *=
          x +
            (y -
               y *
               y) *
            0.346607F;
        y =
          b -
            (int)
              java.lang.Math.
              floor(
                b);
        y =
          (y -
             y *
             y) *
            0.33971F;
        return java.lang.Float.
          intBitsToFloat(
            (int)
              ((b +
                  127 -
                  y) *
                 (1 <<
                    23)));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "25r/AzNWKHUkIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1NeyQwn/D2rV0s7MLAAA");
}
