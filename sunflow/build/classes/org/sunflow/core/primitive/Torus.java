package org.sunflow.core.primitive;
public class Torus implements org.sunflow.core.PrimitiveList {
    private float ri2;
    private float ro2;
    private float ri;
    private float ro;
    public Torus() { super();
                     ri = 0.25F;
                     ro = 1;
                     ri2 = ri * ri;
                     ro2 = ro * ro; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        ri =
          pl.
            getFloat(
              "radiusInner",
              ri);
        ro =
          pl.
            getFloat(
              "radiusOuter",
              ro);
        ri2 =
          ri *
            ri;
        ro2 =
          ro *
            ro;
        return true;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          -ro -
            ri,
          -ro -
            ri,
          -ri);
        bounds.
          include(
            ro +
              ri,
            ro +
              ri,
            ri);
        if (o2w !=
              null)
            bounds =
              o2w.
                transform(
                  bounds);
        return bounds;
    }
    public float getPrimitiveBound(int primID, int i) { switch (i) {
                                                            case 0:
                                                            case 2:
                                                                return -ro -
                                                                  ri;
                                                            case 1:
                                                            case 3:
                                                                return ro +
                                                                  ri;
                                                            case 4:
                                                                return -ri;
                                                            case 5:
                                                                return ri;
                                                            default:
                                                                return 0;
                                                        }
    }
    public int getNumPrimitives() { return 1; }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        org.sunflow.core.Instance parent =
          state.
          getInstance(
            );
        org.sunflow.math.Point3 p =
          parent.
          transformWorldToObject(
            state.
              getPoint(
                ));
        float deriv =
          p.
            x *
          p.
            x +
          p.
            y *
          p.
            y +
          p.
            z *
          p.
            z -
          ri2 -
          ro2;
        state.
          getNormal(
            ).
          set(
            p.
              x *
              deriv,
            p.
              y *
              deriv,
            p.
              z *
              deriv +
              2 *
              ro2 *
              p.
                z);
        state.
          getNormal(
            ).
          normalize(
            );
        double phi =
          java.lang.Math.
          asin(
            org.sunflow.math.MathUtils.
              clamp(
                p.
                  z /
                  ri,
                -1,
                1));
        double theta =
          java.lang.Math.
          atan2(
            p.
              y,
            p.
              x);
        if (theta <
              0)
            theta +=
              2 *
                java.lang.Math.
                  PI;
        state.
          getUV(
            ).
          x =
          (float)
            (theta /
               (2 *
                  java.lang.Math.
                    PI));
        state.
          getUV(
            ).
          y =
          (float)
            ((phi +
                java.lang.Math.
                  PI /
                2) /
               java.lang.Math.
                 PI);
        state.
          setShader(
            parent.
              getShader(
                0));
        state.
          setModifier(
            parent.
              getModifier(
                0));
        org.sunflow.math.Vector3 worldNormal =
          parent.
          transformNormalObjectToWorld(
            state.
              getNormal(
                ));
        state.
          getNormal(
            ).
          set(
            worldNormal);
        state.
          getNormal(
            ).
          normalize(
            );
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    )));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        float rd2x =
          r.
            dx *
          r.
            dx;
        float rd2y =
          r.
            dy *
          r.
            dy;
        float rd2z =
          r.
            dz *
          r.
            dz;
        float ro2x =
          r.
            ox *
          r.
            ox;
        float ro2y =
          r.
            oy *
          r.
            oy;
        float ro2z =
          r.
            oz *
          r.
            oz;
        double alpha =
          rd2x +
          rd2y +
          rd2z;
        double beta =
          2 *
          (r.
             ox *
             r.
               dx +
             r.
               oy *
             r.
               dy +
             r.
               oz *
             r.
               dz);
        double gamma =
          ro2x +
          ro2y +
          ro2z -
          ri2 -
          ro2;
        double A =
          alpha *
          alpha;
        double B =
          2 *
          alpha *
          beta;
        double C =
          beta *
          beta +
          2 *
          alpha *
          gamma +
          4 *
          ro2 *
          rd2z;
        double D =
          2 *
          beta *
          gamma +
          8 *
          ro2 *
          r.
            oz *
          r.
            dz;
        double E =
          gamma *
          gamma +
          4 *
          ro2 *
          ro2z -
          4 *
          ro2 *
          ri2;
        double[] t =
          org.sunflow.math.Solvers.
          solveQuartic(
            A,
            B,
            C,
            D,
            E);
        if (t !=
              null) {
            if (t[0] >=
                  r.
                  getMax(
                    ) ||
                  t[t.
                      length -
                      1] <=
                  r.
                  getMin(
                    ))
                return;
            for (int i =
                   0;
                 i <
                   t.
                     length;
                 i++) {
                if (t[i] >
                      r.
                      getMin(
                        )) {
                    r.
                      setMax(
                        (float)
                          t[i]);
                    state.
                      setIntersection(
                        0,
                        0,
                        0);
                    return;
                }
            }
        }
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iqO4/wch4p/KKisAAA==");
}
