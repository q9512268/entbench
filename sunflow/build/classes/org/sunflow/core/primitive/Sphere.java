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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8LaDNeuE27LX9RkHLP4pLQCWR2aAvy+BPJCzH0Tt/YD7CVjenK9S4VXWqceP" +
       "nYzvfG6DqCcasnf/HihuX/jNv98KHf/Dm7NsRhVU09crZIIoHtPKmMqsDaWf" +
       "F3FuUnuv5on3X2lPds1lL2F9LXfZLdjvFTCJtfn3Br8prz/+12W7HhzbO4dt" +
       "YYUPTr/I7/afefOhNdITQV6xih0hp9LNZur0AgtKDQKlucqmyXoW8KBa5fjJ" +
       "QuYWS+FpsPykwR9UIn9zp2NNj8PK3bGyAKsvZwT5igYLOBuDhkDhzZzNJmvy" +
       "kg2J763RPm7WpwtkpT2sGYJkntbjkJizCxPmIEPpUZM6/i3q4Y9E90oz7dE/" +
       "Cf9dOguDoGs8Hf7a8Lv73uIrXc5cy8HX41bggp7tsI41IRZDHQVOoNn2hA82" +
       "XBv/1vUXhD3+gt9HTGaOffXD0JFjIrbEqWhVzsHEyyNORj7rWgtp4Ry9fz57" +
       "8MenDx4KWlA/TFHZqKYpBKvOUgScenBRNorC1m2Ha39ytKGoF6K2D5WnVXl/" +
       "mvTFsz23zEyPemB1D1KuH1tWsx2ZosBaO1V+nDW7xPvm/zFLs44unffvdFx+" +
       "MRtbDU+T5fJNc4+WfKw+Xw5kp+Yl3jBIwVEm1I/htJrZyDVOFgiEA6yBIq8m" +
       "SeinNEOJd2lpNW7agpfnCObjcA7u0jxomvOAJt+S2uBptiBpnjua+VgL5J69" +
       "lquzL8nznqSoSLbuXTwrwH4q3JLDvJ0pgPXXWfMliuoBayduBN530Qy1r4bz" +
       "6HZX4cvzsAq1bGwFPK0WlK1zX4V8rAWg+naBse+w5gRFdQDjQDrlIMmJD7tw" +
       "fHMe4KhiY/cjEebI/p4bHPlYC4d4c86GODSGWSCyKznC1Z4pANo51jxP0ULd" +
       "IHC6IV7m2TyueEKT4y6Wp+cLywF4tlmAbJs7lvlYfUgUcUOKbCwX5WA5iKdc" +
       "7wGKthyKPnazaIpa3IX8fAHIf8aaV+AcKNusjquykZdcdH80D+iyqo1fYQ1b" +
       "EA3PHd18rAUm/esCY5dY8wvwQQjcLgwlSDI7dre7iFz8fyCSgfpOXFSxU9WS" +
       "nLtucT8rvXiytnzxyUfe5WcE5w61Gkq3RFpRPCWHt/wohThKyHxa1eIkqvOv" +
       "KxQty39vBucYPWvKlwXX7yGb+bkgBtmXl+waRVUeMsqKIP7mJfojbFRAxF7f" +
       "121/ruNHSnaNHRJ3tplA7rGRI994N+QdFu8dCitV+V8Odi2XFn86xKSzJ3cM" +
       "HLj5sefEHY6k4OlpJqUKKjhxU+ScdlrzSrNllW7vuFNzrmK1XVpm3SF5bePr" +
       "D8mT37cs811qmO3O3caVU5vP/3Km9G0oinejAAbX3O258BdIdWb0NBwzd0dy" +
       "K1U4GfLbls6OE1MPrkv843f8RI5EZbs8P31MGnnyct+58dtb+B13CVTNJDOC" +
       "KmVz25Q6SKQJI6vsrWE+idmfDxwHC74FTi+7zIOUlVvM516BVoKzEIPXHEwM" +
       "FM5Vbo99ys06IKZ13cfg9njOL+Ni+2Dog//FIv26bt+EndB5PCr5S6db/JU1" +
       "t/8L8Im1p30cAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T9/0B09/Jz9r+z+7EWy/jicAAA==");
}
