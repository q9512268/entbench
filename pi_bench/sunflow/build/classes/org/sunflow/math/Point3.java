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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "P37rIf7BJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
