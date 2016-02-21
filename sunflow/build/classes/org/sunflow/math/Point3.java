package org.sunflow.math;
public final class Point3 {
    public float x;
    public float y;
    public float z;
    public Point3() { super(); }
    public Point3(float x, float y, float z) { super();
                                               this.x = x;
                                               this.y = y;
                                               this.z = z; }
    public Point3(org.sunflow.math.Point3 p) { super();
                                               x = p.x;
                                               y = p.y;
                                               z = p.z; }
    public float get(int i) { switch (i) { case 0: return x; case 1: return y;
                                           default:
                                               return z; } }
    public final float distanceTo(org.sunflow.math.Point3 p) { float dx =
                                                                 x -
                                                                 p.
                                                                   x;
                                                               float dy =
                                                                 y -
                                                                 p.
                                                                   y;
                                                               float dz =
                                                                 z -
                                                                 p.
                                                                   z;
                                                               return (float)
                                                                        java.lang.Math.
                                                                        sqrt(
                                                                          dx *
                                                                            dx +
                                                                            dy *
                                                                            dy +
                                                                            dz *
                                                                            dz);
    }
    public final float distanceTo(float px, float py, float pz) {
        float dx =
          x -
          px;
        float dy =
          y -
          py;
        float dz =
          z -
          pz;
        return (float)
                 java.lang.Math.
                 sqrt(
                   dx *
                     dx +
                     dy *
                     dy +
                     dz *
                     dz);
    }
    public final float distanceToSquared(org.sunflow.math.Point3 p) {
        float dx =
          x -
          p.
            x;
        float dy =
          y -
          p.
            y;
        float dz =
          z -
          p.
            z;
        return dx *
          dx +
          dy *
          dy +
          dz *
          dz;
    }
    public final float distanceToSquared(float px, float py, float pz) {
        float dx =
          x -
          px;
        float dy =
          y -
          py;
        float dz =
          z -
          pz;
        return dx *
          dx +
          dy *
          dy +
          dz *
          dz;
    }
    public final org.sunflow.math.Point3 set(float x, float y, float z) {
        this.
          x =
          x;
        this.
          y =
          y;
        this.
          z =
          z;
        return this;
    }
    public final org.sunflow.math.Point3 set(org.sunflow.math.Point3 p) {
        x =
          p.
            x;
        y =
          p.
            y;
        z =
          p.
            z;
        return this;
    }
    public static final org.sunflow.math.Point3 add(org.sunflow.math.Point3 p,
                                                    org.sunflow.math.Vector3 v,
                                                    org.sunflow.math.Point3 dest) {
        dest.
          x =
          p.
            x +
            v.
              x;
        dest.
          y =
          p.
            y +
            v.
              y;
        dest.
          z =
          p.
            z +
            v.
              z;
        return dest;
    }
    public static final org.sunflow.math.Vector3 sub(org.sunflow.math.Point3 p1,
                                                     org.sunflow.math.Point3 p2,
                                                     org.sunflow.math.Vector3 dest) {
        dest.
          x =
          p1.
            x -
            p2.
              x;
        dest.
          y =
          p1.
            y -
            p2.
              y;
        dest.
          z =
          p1.
            z -
            p2.
              z;
        return dest;
    }
    public static final org.sunflow.math.Point3 mid(org.sunflow.math.Point3 p1,
                                                    org.sunflow.math.Point3 p2,
                                                    org.sunflow.math.Point3 dest) {
        dest.
          x =
          0.5F *
            (p1.
               x +
               p2.
                 x);
        dest.
          y =
          0.5F *
            (p1.
               y +
               p2.
                 y);
        dest.
          z =
          0.5F *
            (p1.
               z +
               p2.
                 z);
        return dest;
    }
    public static final org.sunflow.math.Vector3 normal(org.sunflow.math.Point3 p0,
                                                        org.sunflow.math.Point3 p1,
                                                        org.sunflow.math.Point3 p2) {
        float edge1x =
          p1.
            x -
          p0.
            x;
        float edge1y =
          p1.
            y -
          p0.
            y;
        float edge1z =
          p1.
            z -
          p0.
            z;
        float edge2x =
          p2.
            x -
          p0.
            x;
        float edge2y =
          p2.
            y -
          p0.
            y;
        float edge2z =
          p2.
            z -
          p0.
            z;
        float nx =
          edge1y *
          edge2z -
          edge1z *
          edge2y;
        float ny =
          edge1z *
          edge2x -
          edge1x *
          edge2z;
        float nz =
          edge1x *
          edge2y -
          edge1y *
          edge2x;
        return new org.sunflow.math.Vector3(
          nx,
          ny,
          nz);
    }
    public static final org.sunflow.math.Vector3 normal(org.sunflow.math.Point3 p0,
                                                        org.sunflow.math.Point3 p1,
                                                        org.sunflow.math.Point3 p2,
                                                        org.sunflow.math.Vector3 dest) {
        float edge1x =
          p1.
            x -
          p0.
            x;
        float edge1y =
          p1.
            y -
          p0.
            y;
        float edge1z =
          p1.
            z -
          p0.
            z;
        float edge2x =
          p2.
            x -
          p0.
            x;
        float edge2y =
          p2.
            y -
          p0.
            y;
        float edge2z =
          p2.
            z -
          p0.
            z;
        dest.
          x =
          edge1y *
            edge2z -
            edge1z *
            edge2y;
        dest.
          y =
          edge1z *
            edge2x -
            edge1x *
            edge2z;
        dest.
          z =
          edge1x *
            edge2y -
            edge1y *
            edge2x;
        return dest;
    }
    public final java.lang.String toString() {
        return java.lang.String.
          format(
            "(%.2f, %.2f, %.2f)",
            x,
            y,
            z);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8Mfm/wMRFSABJyYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/HOv/HZxDuH/A6QswjBEMQAA");
}
