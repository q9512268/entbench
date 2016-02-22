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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PIkp7X/p5CKXyycAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wfx/EWebDEAAA==");
}
