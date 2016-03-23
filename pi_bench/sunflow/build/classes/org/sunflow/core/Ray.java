package org.sunflow.core;
public final class Ray {
    public float ox;
    public float oy;
    public float oz;
    public float dx;
    public float dy;
    public float dz;
    private float tMin;
    private float tMax;
    private static final float EPSILON = 0;
    private Ray() { super(); }
    public Ray(float ox, float oy, float oz, float dx, float dy, float dz) {
        super(
          );
        this.
          ox =
          ox;
        this.
          oy =
          oy;
        this.
          oz =
          oz;
        this.
          dx =
          dx;
        this.
          dy =
          dy;
        this.
          dz =
          dz;
        float in =
          1.0F /
          (float)
            java.lang.Math.
            sqrt(
              dx *
                dx +
                dy *
                dy +
                dz *
                dz);
        this.
          dx *=
          in;
        this.
          dy *=
          in;
        this.
          dz *=
          in;
        tMin =
          EPSILON;
        tMax =
          java.lang.Float.
            POSITIVE_INFINITY;
    }
    public Ray(org.sunflow.math.Point3 o, org.sunflow.math.Vector3 d) { super(
                                                                          );
                                                                        ox =
                                                                          o.
                                                                            x;
                                                                        oy =
                                                                          o.
                                                                            y;
                                                                        oz =
                                                                          o.
                                                                            z;
                                                                        dx =
                                                                          d.
                                                                            x;
                                                                        dy =
                                                                          d.
                                                                            y;
                                                                        dz =
                                                                          d.
                                                                            z;
                                                                        float in =
                                                                          1.0F /
                                                                          (float)
                                                                            java.lang.Math.
                                                                            sqrt(
                                                                              dx *
                                                                                dx +
                                                                                dy *
                                                                                dy +
                                                                                dz *
                                                                                dz);
                                                                        dx *=
                                                                          in;
                                                                        dy *=
                                                                          in;
                                                                        dz *=
                                                                          in;
                                                                        tMin =
                                                                          EPSILON;
                                                                        tMax =
                                                                          java.lang.Float.
                                                                            POSITIVE_INFINITY;
    }
    public Ray(org.sunflow.math.Point3 a,
               org.sunflow.math.Point3 b) {
        super(
          );
        ox =
          a.
            x;
        oy =
          a.
            y;
        oz =
          a.
            z;
        dx =
          b.
            x -
            ox;
        dy =
          b.
            y -
            oy;
        dz =
          b.
            z -
            oz;
        tMin =
          EPSILON;
        float n =
          (float)
            java.lang.Math.
            sqrt(
              dx *
                dx +
                dy *
                dy +
                dz *
                dz);
        float in =
          1.0F /
          n;
        dx *=
          in;
        dy *=
          in;
        dz *=
          in;
        tMax =
          n -
            EPSILON;
    }
    public org.sunflow.core.Ray transform(org.sunflow.math.Matrix4 m) {
        if (m ==
              null)
            return this;
        org.sunflow.core.Ray r =
          new org.sunflow.core.Ray(
          );
        r.
          ox =
          m.
            transformPX(
              ox,
              oy,
              oz);
        r.
          oy =
          m.
            transformPY(
              ox,
              oy,
              oz);
        r.
          oz =
          m.
            transformPZ(
              ox,
              oy,
              oz);
        r.
          dx =
          m.
            transformVX(
              dx,
              dy,
              dz);
        r.
          dy =
          m.
            transformVY(
              dx,
              dy,
              dz);
        r.
          dz =
          m.
            transformVZ(
              dx,
              dy,
              dz);
        r.
          tMin =
          tMin;
        r.
          tMax =
          tMax;
        return r;
    }
    public void normalize() { float in = 1.0F /
                                (float)
                                  java.lang.Math.
                                  sqrt(
                                    dx *
                                      dx +
                                      dy *
                                      dy +
                                      dz *
                                      dz);
                              dx *= in;
                              dy *= in;
                              dz *= in; }
    public final float getMin() { return tMin;
    }
    public final float getMax() { return tMax;
    }
    public final org.sunflow.math.Vector3 getDirection() {
        return new org.sunflow.math.Vector3(
          dx,
          dy,
          dz);
    }
    public final boolean isInside(float t) {
        return tMin <
          t &&
          t <
          tMax;
    }
    public final org.sunflow.math.Point3 getPoint(org.sunflow.math.Point3 dest) {
        dest.
          x =
          ox +
            tMax *
            dx;
        dest.
          y =
          oy +
            tMax *
            dy;
        dest.
          z =
          oz +
            tMax *
            dz;
        return dest;
    }
    public final float dot(org.sunflow.math.Vector3 v) {
        return dx *
          v.
            x +
          dy *
          v.
            y +
          dz *
          v.
            z;
    }
    public final float dot(float vx, float vy,
                           float vz) { return dx *
                                         vx +
                                         dy *
                                         vy +
                                         dz *
                                         vz;
    }
    public final void setMax(float t) { tMax =
                                          t;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZAcOKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "toSOLxEW6REVARd8GG7W2CzKgowa6So6RTiY42B4XYLh2larwlY6jDbJAKep" +
       "ynTBJtu5N+jJvo+ro4niOJvyrN1l+5VWlVnVvY6GNeLlVjWFKYWCh3VxadAn" +
       "W5lETTvIYpSOxiJtsJ3O2FPIgTSiexjnC87Qc2JiPO3yREYzbObLFs/0O9FA" +
       "6CajRklPyhYW03rUngmLxnJEsX3KabugAcEnUwvLeCQRDMmpNmxeQ0u+ilg+" +
       "bltWz2yS1HyeNljC77CblF/UevSCqIi2lM2mvU2TlqLAmolis7ZEKD0iJlq3" +
       "Txj4ArPW4RiBgy7aWHfYWCA7U3PerqzZbCqo4siqe5OZN6vOJcVfjGZ1Yzwn" +
       "eVT1WZ4cyuIKQFuTumRtfazVdz3U4vml6s7xiiWk/nSM89RGmiPj9hgnMWpm" +
       "TesRW2k5IrKMtDbuRClv+5Jp6gunNw20aq/hrRqRQro9qVXpuEyv7qz1VYu1" +
       "WnHLaY+wcW+2Hohd3RiRvF8nkhIKiCyp8mJqobGI80bQShe9+pL0MlYiJ/YQ" +
       "rwYxheoWUh9bkm9XOmG6ajAq7zLppkUrYhah1sqtLtplZ0Z08UXP5Vv9UrZa" +
       "8UO+4xEbea52JhvFatTx3gx3ZqKXLibznmfqY4eiyhZRN4iy41V0NXJRXpfq" +
       "G6bt6Rm7Lo2YLhMSKkNtGKaN0l1V8ytWB+aleNFrUYuMbdrLtcniTDOrzOTQ" +
       "tmG10ccw1FmSvEG3qJRGdceB0ynLrMdsVc8mU0aJ13GMV0B4XDUFcV1C6LJD" +
       "KXTDRGdZtSTPahMP08q1dbO7HA5bbrM0FIZLT9a7iWytrJU8D71qM2ytSWag" +
       "CKNyf41UbU6sWNuKwvAVvk1kLDJOWNGK4F4dCTFFbYZtrA8IqvrGlShPxPr6" +
       "GJ4ZVrjYWGCYhcXca3kcPVkzbcbZVGshQqdRq9Q3bMHnKjSt1xhuYyUZEzJT" +
       "rc52iBmOd2ihpan8xpyEarmix3Bc8hKS8KKO0Z7j04427MGJKfaScFbOeItf" +
       "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" +
       "A8dX9ll+5Z1hOS+YXD+DZS5nBw2hc4oT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nnDUxttB8Gv7BL/2NhI8d5SYndhitdM9gyqVF/ipVIm3QLVIz/KY9PV9ql9/" +
       "J92VP4OgkBeDfDX2MO6+ccSRu6uNREBNYynNN3s+esu/TOxt85d/+ZXLFx95" +
       "Rfi9Yo/w4Vb8+/rQRS0yzePbaY6dn3d9VTMKbPftba5xC+zfH0JXTm7RBhN/" +
       "/pOD2/nYXrMbIfSuY81A9Nk/O95oCcCDRvmp7B4kYMeWeve2CSU7N+fMB4qC" +
       "HnozRR1Ls5+9KTku/gflIJGN9v4L5Yb82iv04IfeQH92b0+ybEpZsU3iYh+6" +
       "sLc9+jAZfvq20g5kne996DsPfOm+Dx4k7g/sAT6ysGPYPnD6/t+O5YbFjt3s" +
       "PzzyKx/5uVf+sFjo//9EMjerHDQAAA==");
}
