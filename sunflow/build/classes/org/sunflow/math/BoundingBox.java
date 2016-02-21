package org.sunflow.math;
public class BoundingBox {
    private org.sunflow.math.Point3 minimum;
    private org.sunflow.math.Point3 maximum;
    public BoundingBox() { super();
                           minimum = new org.sunflow.math.Point3(java.lang.Float.
                                                                   POSITIVE_INFINITY,
                                                                 java.lang.Float.
                                                                   POSITIVE_INFINITY,
                                                                 java.lang.Float.
                                                                   POSITIVE_INFINITY);
                           maximum = new org.sunflow.math.Point3(
                                       java.lang.Float.
                                         NEGATIVE_INFINITY,
                                       java.lang.Float.
                                         NEGATIVE_INFINITY,
                                       java.lang.Float.
                                         NEGATIVE_INFINITY);
    }
    public BoundingBox(org.sunflow.math.BoundingBox b) {
        super(
          );
        minimum =
          new org.sunflow.math.Point3(
            b.
              minimum);
        maximum =
          new org.sunflow.math.Point3(
            b.
              maximum);
    }
    public BoundingBox(org.sunflow.math.Point3 p) {
        this(
          p.
            x,
          p.
            y,
          p.
            z);
    }
    public BoundingBox(float x, float y, float z) {
        super(
          );
        minimum =
          new org.sunflow.math.Point3(
            x,
            y,
            z);
        maximum =
          new org.sunflow.math.Point3(
            x,
            y,
            z);
    }
    public BoundingBox(float size) { super(
                                       );
                                     minimum =
                                       new org.sunflow.math.Point3(
                                         -size,
                                         -size,
                                         -size);
                                     maximum =
                                       new org.sunflow.math.Point3(
                                         size,
                                         size,
                                         size);
    }
    public final org.sunflow.math.Point3 getMinimum() {
        return minimum;
    }
    public final org.sunflow.math.Point3 getMaximum() {
        return maximum;
    }
    public final org.sunflow.math.Point3 getCenter() {
        return org.sunflow.math.Point3.
          mid(
            minimum,
            maximum,
            new org.sunflow.math.Point3(
              ));
    }
    public final org.sunflow.math.Point3 getCorner(int i) {
        float x =
          (i &
             1) ==
          0
          ? minimum.
              x
          : maximum.
              x;
        float y =
          (i &
             2) ==
          0
          ? minimum.
              y
          : maximum.
              y;
        float z =
          (i &
             4) ==
          0
          ? minimum.
              z
          : maximum.
              z;
        return new org.sunflow.math.Point3(
          x,
          y,
          z);
    }
    public final float getBound(int i) { switch (i) {
                                             case 0:
                                                 return minimum.
                                                          x;
                                             case 1:
                                                 return maximum.
                                                          x;
                                             case 2:
                                                 return minimum.
                                                          y;
                                             case 3:
                                                 return maximum.
                                                          y;
                                             case 4:
                                                 return minimum.
                                                          z;
                                             case 5:
                                                 return maximum.
                                                          z;
                                             default:
                                                 return 0;
                                         }
    }
    public final org.sunflow.math.Vector3 getExtents() {
        return org.sunflow.math.Point3.
          sub(
            maximum,
            minimum,
            new org.sunflow.math.Vector3(
              ));
    }
    public final float getArea() { org.sunflow.math.Vector3 w =
                                     getExtents(
                                       );
                                   float ax =
                                     java.lang.Math.
                                     max(
                                       w.
                                         x,
                                       0);
                                   float ay =
                                     java.lang.Math.
                                     max(
                                       w.
                                         y,
                                       0);
                                   float az =
                                     java.lang.Math.
                                     max(
                                       w.
                                         z,
                                       0);
                                   return 2 *
                                     (ax *
                                        ay +
                                        ay *
                                        az +
                                        az *
                                        ax);
    }
    public final float getVolume() { org.sunflow.math.Vector3 w =
                                       getExtents(
                                         );
                                     float ax =
                                       java.lang.Math.
                                       max(
                                         w.
                                           x,
                                         0);
                                     float ay =
                                       java.lang.Math.
                                       max(
                                         w.
                                           y,
                                         0);
                                     float az =
                                       java.lang.Math.
                                       max(
                                         w.
                                           z,
                                         0);
                                     return ax *
                                       ay *
                                       az;
    }
    public final void enlargeUlps() { final float eps =
                                        1.0E-4F;
                                      minimum.
                                        x -=
                                        java.lang.Math.
                                          max(
                                            eps,
                                            java.lang.Math.
                                              ulp(
                                                minimum.
                                                  x));
                                      minimum.
                                        y -=
                                        java.lang.Math.
                                          max(
                                            eps,
                                            java.lang.Math.
                                              ulp(
                                                minimum.
                                                  y));
                                      minimum.
                                        z -=
                                        java.lang.Math.
                                          max(
                                            eps,
                                            java.lang.Math.
                                              ulp(
                                                minimum.
                                                  z));
                                      maximum.
                                        x +=
                                        java.lang.Math.
                                          max(
                                            eps,
                                            java.lang.Math.
                                              ulp(
                                                maximum.
                                                  x));
                                      maximum.
                                        y +=
                                        java.lang.Math.
                                          max(
                                            eps,
                                            java.lang.Math.
                                              ulp(
                                                maximum.
                                                  y));
                                      maximum.
                                        z +=
                                        java.lang.Math.
                                          max(
                                            eps,
                                            java.lang.Math.
                                              ulp(
                                                maximum.
                                                  z));
    }
    public final boolean isEmpty() { return maximum.
                                              x <
                                       minimum.
                                         x ||
                                       maximum.
                                         y <
                                       minimum.
                                         y ||
                                       maximum.
                                         z <
                                       minimum.
                                         z;
    }
    public final boolean intersects(org.sunflow.math.BoundingBox b) {
        return b !=
          null &&
          minimum.
            x <=
          b.
            maximum.
            x &&
          maximum.
            x >=
          b.
            minimum.
            x &&
          minimum.
            y <=
          b.
            maximum.
            y &&
          maximum.
            y >=
          b.
            minimum.
            y &&
          minimum.
            z <=
          b.
            maximum.
            z &&
          maximum.
            z >=
          b.
            minimum.
            z;
    }
    public final boolean contains(org.sunflow.math.Point3 p) {
        return p !=
          null &&
          p.
            x >=
          minimum.
            x &&
          p.
            x <=
          maximum.
            x &&
          p.
            y >=
          minimum.
            y &&
          p.
            y <=
          maximum.
            y &&
          p.
            z >=
          minimum.
            z &&
          p.
            z <=
          maximum.
            z;
    }
    public final boolean contains(float x,
                                  float y,
                                  float z) {
        return x >=
          minimum.
            x &&
          x <=
          maximum.
            x &&
          y >=
          minimum.
            y &&
          y <=
          maximum.
            y &&
          z >=
          minimum.
            z &&
          z <=
          maximum.
            z;
    }
    public final void include(org.sunflow.math.Point3 p) {
        if (p !=
              null) {
            if (p.
                  x <
                  minimum.
                    x)
                minimum.
                  x =
                  p.
                    x;
            if (p.
                  x >
                  maximum.
                    x)
                maximum.
                  x =
                  p.
                    x;
            if (p.
                  y <
                  minimum.
                    y)
                minimum.
                  y =
                  p.
                    y;
            if (p.
                  y >
                  maximum.
                    y)
                maximum.
                  y =
                  p.
                    y;
            if (p.
                  z <
                  minimum.
                    z)
                minimum.
                  z =
                  p.
                    z;
            if (p.
                  z >
                  maximum.
                    z)
                maximum.
                  z =
                  p.
                    z;
        }
    }
    public final void include(float x, float y,
                              float z) { if (x <
                                               minimum.
                                                 x)
                                             minimum.
                                               x =
                                               x;
                                         if (x >
                                               maximum.
                                                 x)
                                             maximum.
                                               x =
                                               x;
                                         if (y <
                                               minimum.
                                                 y)
                                             minimum.
                                               y =
                                               y;
                                         if (y >
                                               maximum.
                                                 y)
                                             maximum.
                                               y =
                                               y;
                                         if (z <
                                               minimum.
                                                 z)
                                             minimum.
                                               z =
                                               z;
                                         if (z >
                                               maximum.
                                                 z)
                                             maximum.
                                               z =
                                               z;
    }
    public final void include(org.sunflow.math.BoundingBox b) {
        if (b !=
              null) {
            if (b.
                  minimum.
                  x <
                  minimum.
                    x)
                minimum.
                  x =
                  b.
                    minimum.
                    x;
            if (b.
                  maximum.
                  x >
                  maximum.
                    x)
                maximum.
                  x =
                  b.
                    maximum.
                    x;
            if (b.
                  minimum.
                  y <
                  minimum.
                    y)
                minimum.
                  y =
                  b.
                    minimum.
                    y;
            if (b.
                  maximum.
                  y >
                  maximum.
                    y)
                maximum.
                  y =
                  b.
                    maximum.
                    y;
            if (b.
                  minimum.
                  z <
                  minimum.
                    z)
                minimum.
                  z =
                  b.
                    minimum.
                    z;
            if (b.
                  maximum.
                  z >
                  maximum.
                    z)
                maximum.
                  z =
                  b.
                    maximum.
                    z;
        }
    }
    public final java.lang.String toString() {
        return java.lang.String.
          format(
            "(%.2f, %.2f, %.2f) to (%.2f, %.2f, %.2f)",
            minimum.
              x,
            minimum.
              y,
            minimum.
              z,
            maximum.
              x,
            maximum.
              y,
            maximum.
              z);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1bTcC9lfcNQ1DX0pdBQf1P8BXto81zAsAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "boGFOANnO08+CFaf/e2J0yg/dDtQvrFH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+cZtRHnhsGOSDkmBaXAG3lGeMDfH271VZ/U+8Pxgj/cHd1Kq0hkofyJPxNxy" +
       "XcVeq7lHPvfEAeTkVkHWASf7HeTu+84LVT8Dbn5D/px8U7iLW4X7AQDzvXu4" +
       "770zMt15pPAMkPmdtXPOTUG6t7oNeBpwgu9B4rcR5EkMP3VG3SfyJAOWGXuH" +
       "azWfPwDcvqU7aWC1PvFfgPxi82PX/ado9z8Y5RuvPnjp0VfF3yuuwx//V+Ve" +
       "tnRJX9v2yRtaJ/L3+KGmGwXge3f3tfwCxafj0uXTQS2IDPKvwtV8atfss4C/" +
       "E82AVPe5k40+DzZKoFGe/YJfQLz29tHu5lm622E9dlK0RWT58A+bsBMnO89d" +
       "cx5T/Enr6Oxkvfub1kvKN1/tDj72fexru+v3ii1vtzmVS2zp4u6fAAXR/Pzl" +
       "mZtSO6J1T+f5Nx/4xXvfc3RW9MCO4YOaneDtqRvfdS9Ckvx2+vYfPfoPfvxv" +
       "vfoHxWWo/wcODvmHPTcAAA==");
}
