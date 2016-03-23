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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
