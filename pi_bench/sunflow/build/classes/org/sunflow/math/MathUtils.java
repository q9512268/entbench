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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6xcwhRojAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r2UHEv4fiOUkuL4sAAA=");
}
