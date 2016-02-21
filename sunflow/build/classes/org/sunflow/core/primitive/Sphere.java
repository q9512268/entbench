package org.sunflow.core.primitive;
public class Sphere implements org.sunflow.core.PrimitiveList {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          1);
        if (o2w !=
              null)
            bounds =
              o2w.
                transform(
                  bounds);
        return bounds;
    }
    public float getPrimitiveBound(int primID, int i) { return (i &
                                                                  1) ==
                                                          0
                                                          ? -1
                                                          : 1;
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
        org.sunflow.math.Point3 localPoint =
          parent.
          transformWorldToObject(
            state.
              getPoint(
                ));
        state.
          getNormal(
            ).
          set(
            localPoint.
              x,
            localPoint.
              y,
            localPoint.
              z);
        state.
          getNormal(
            ).
          normalize(
            );
        float phi =
          (float)
            java.lang.Math.
            atan2(
              state.
                getNormal(
                  ).
                y,
              state.
                getNormal(
                  ).
                x);
        if (phi <
              0)
            phi +=
              2 *
                java.lang.Math.
                  PI;
        float theta =
          (float)
            java.lang.Math.
            acos(
              state.
                getNormal(
                  ).
                z);
        state.
          getUV(
            ).
          y =
          theta /
            (float)
              java.lang.Math.
                PI;
        state.
          getUV(
            ).
          x =
          phi /
            (float)
              (2 *
                 java.lang.Math.
                   PI);
        org.sunflow.math.Vector3 v =
          new org.sunflow.math.Vector3(
          );
        v.
          x =
          -2 *
            (float)
              java.lang.Math.
                PI *
            state.
              getNormal(
                ).
              y;
        v.
          y =
          2 *
            (float)
              java.lang.Math.
                PI *
            state.
              getNormal(
                ).
              x;
        v.
          z =
          0;
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
        v =
          parent.
            transformVectorObjectToWorld(
              v);
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
              makeFromWV(
                state.
                  getNormal(
                    ),
                v));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        float qa =
          r.
            dx *
          r.
            dx +
          r.
            dy *
          r.
            dy +
          r.
            dz *
          r.
            dz;
        float qb =
          2 *
          (r.
             dx *
             r.
               ox +
             r.
               dy *
             r.
               oy +
             r.
               dz *
             r.
               oz);
        float qc =
          r.
            ox *
          r.
            ox +
          r.
            oy *
          r.
            oy +
          r.
            oz *
          r.
            oz -
          1;
        double[] t =
          org.sunflow.math.Solvers.
          solveQuadric(
            qa,
            qb,
            qc);
        if (t !=
              null) {
            if (t[0] >=
                  r.
                  getMax(
                    ) ||
                  t[1] <=
                  r.
                  getMin(
                    ))
                return;
            if (t[0] >
                  r.
                  getMin(
                    ))
                r.
                  setMax(
                    (float)
                      t[0]);
            else
                r.
                  setMax(
                    (float)
                      t[1]);
            state.
              setIntersection(
                0,
                0,
                0);
        }
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public Sphere() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "31VWjP0Hhf6fT2kbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XpjdV6//7M4/efPvP/X97M7s/wCxDfWCaicAAA==");
}
