package org.sunflow.math;
public final class OrthoNormalBasis {
    private org.sunflow.math.Vector3 u;
    private org.sunflow.math.Vector3 v;
    private org.sunflow.math.Vector3 w;
    private OrthoNormalBasis() { super();
                                 u = new org.sunflow.math.Vector3();
                                 v = new org.sunflow.math.Vector3();
                                 w = new org.sunflow.math.Vector3(); }
    public void flipU() { u.negate(); }
    public void flipV() { v.negate(); }
    public void flipW() { w.negate(); }
    public void swapUV() { org.sunflow.math.Vector3 t = u;
                           u = v;
                           v = t; }
    public void swapVW() { org.sunflow.math.Vector3 t = v;
                           v = w;
                           w = t; }
    public void swapWU() { org.sunflow.math.Vector3 t = w;
                           w = u;
                           u = t; }
    public org.sunflow.math.Vector3 transform(org.sunflow.math.Vector3 a,
                                              org.sunflow.math.Vector3 dest) {
        dest.
          x =
          a.
            x *
            u.
              x +
            a.
              y *
            v.
              x +
            a.
              z *
            w.
              x;
        dest.
          y =
          a.
            x *
            u.
              y +
            a.
              y *
            v.
              y +
            a.
              z *
            w.
              y;
        dest.
          z =
          a.
            x *
            u.
              z +
            a.
              y *
            v.
              z +
            a.
              z *
            w.
              z;
        return dest;
    }
    public org.sunflow.math.Vector3 transform(org.sunflow.math.Vector3 a) {
        float x =
          a.
            x *
          u.
            x +
          a.
            y *
          v.
            x +
          a.
            z *
          w.
            x;
        float y =
          a.
            x *
          u.
            y +
          a.
            y *
          v.
            y +
          a.
            z *
          w.
            y;
        float z =
          a.
            x *
          u.
            z +
          a.
            y *
          v.
            z +
          a.
            z *
          w.
            z;
        return a.
          set(
            x,
            y,
            z);
    }
    public org.sunflow.math.Vector3 untransform(org.sunflow.math.Vector3 a,
                                                org.sunflow.math.Vector3 dest) {
        dest.
          x =
          org.sunflow.math.Vector3.
            dot(
              a,
              u);
        dest.
          y =
          org.sunflow.math.Vector3.
            dot(
              a,
              v);
        dest.
          z =
          org.sunflow.math.Vector3.
            dot(
              a,
              w);
        return dest;
    }
    public org.sunflow.math.Vector3 untransform(org.sunflow.math.Vector3 a) {
        float x =
          org.sunflow.math.Vector3.
          dot(
            a,
            u);
        float y =
          org.sunflow.math.Vector3.
          dot(
            a,
            v);
        float z =
          org.sunflow.math.Vector3.
          dot(
            a,
            w);
        return a.
          set(
            x,
            y,
            z);
    }
    public float untransformX(org.sunflow.math.Vector3 a) { return org.sunflow.math.Vector3.
                                                              dot(
                                                                a,
                                                                u);
    }
    public float untransformY(org.sunflow.math.Vector3 a) { return org.sunflow.math.Vector3.
                                                              dot(
                                                                a,
                                                                v);
    }
    public float untransformZ(org.sunflow.math.Vector3 a) {
        return org.sunflow.math.Vector3.
          dot(
            a,
            w);
    }
    public static final org.sunflow.math.OrthoNormalBasis makeFromW(org.sunflow.math.Vector3 w) {
        org.sunflow.math.OrthoNormalBasis onb =
          new org.sunflow.math.OrthoNormalBasis(
          );
        w.
          normalize(
            onb.
              w);
        if (java.lang.Math.
              abs(
                onb.
                  w.
                  x) <
              java.lang.Math.
              abs(
                onb.
                  w.
                  y) &&
              java.lang.Math.
              abs(
                onb.
                  w.
                  x) <
              java.lang.Math.
              abs(
                onb.
                  w.
                  z)) {
            onb.
              v.
              x =
              0;
            onb.
              v.
              y =
              onb.
                w.
                z;
            onb.
              v.
              z =
              -onb.
                 w.
                 y;
        }
        else
            if (java.lang.Math.
                  abs(
                    onb.
                      w.
                      y) <
                  java.lang.Math.
                  abs(
                    onb.
                      w.
                      z)) {
                onb.
                  v.
                  x =
                  onb.
                    w.
                    z;
                onb.
                  v.
                  y =
                  0;
                onb.
                  v.
                  z =
                  -onb.
                     w.
                     x;
            }
            else {
                onb.
                  v.
                  x =
                  onb.
                    w.
                    y;
                onb.
                  v.
                  y =
                  -onb.
                     w.
                     x;
                onb.
                  v.
                  z =
                  0;
            }
        org.sunflow.math.Vector3.
          cross(
            onb.
              v.
              normalize(
                ),
            onb.
              w,
            onb.
              u);
        return onb;
    }
    public static final org.sunflow.math.OrthoNormalBasis makeFromWV(org.sunflow.math.Vector3 w,
                                                                     org.sunflow.math.Vector3 v) {
        org.sunflow.math.OrthoNormalBasis onb =
          new org.sunflow.math.OrthoNormalBasis(
          );
        w.
          normalize(
            onb.
              w);
        org.sunflow.math.Vector3.
          cross(
            v,
            onb.
              w,
            onb.
              u).
          normalize(
            );
        org.sunflow.math.Vector3.
          cross(
            onb.
              w,
            onb.
              u,
            onb.
              v);
        return onb;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "25a2MAAA");
}
