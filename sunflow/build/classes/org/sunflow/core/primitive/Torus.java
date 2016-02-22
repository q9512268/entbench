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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ja5CKwAA");
}
