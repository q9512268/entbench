package org.sunflow.core.primitive;
public class JuliaFractal implements org.sunflow.core.PrimitiveList {
    private static float BOUNDING_RADIUS = (float) java.lang.Math.sqrt(3);
    private static float BOUNDING_RADIUS2 = 3;
    private static float ESCAPE_THRESHOLD = 10.0F;
    private static float DELTA = 1.0E-4F;
    private float cx;
    private float cy;
    private float cz;
    private float cw;
    private int maxIterations;
    private float epsilon;
    public JuliaFractal() { super();
                            cw = -0.4F;
                            cx = 0.2F;
                            cy = 0.3F;
                            cz = -0.2F;
                            maxIterations = 15;
                            epsilon = 1.0E-5F; }
    public int getNumPrimitives() { return 1; }
    public float getPrimitiveBound(int primID, int i) { return (i & 1) ==
                                                          0
                                                          ? -BOUNDING_RADIUS
                                                          : BOUNDING_RADIUS;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          BOUNDING_RADIUS);
        if (o2w !=
              null)
            bounds =
              o2w.
                transform(
                  bounds);
        return bounds;
    }
    public void intersectPrimitive(org.sunflow.core.Ray r, int primID,
                                   org.sunflow.core.IntersectionState state) {
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
          BOUNDING_RADIUS2;
        float qt =
          r.
          getMin(
            );
        if (qc >
              0) {
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
            double[] t =
              org.sunflow.math.Solvers.
              solveQuadric(
                qa,
                qb,
                qc);
            if (t ==
                  null ||
                  t[0] >=
                  r.
                  getMax(
                    ) ||
                  t[1] <=
                  r.
                  getMin(
                    ))
                return;
            qt =
              (float)
                t[0];
        }
        float dist =
          java.lang.Float.
            POSITIVE_INFINITY;
        float rox =
          r.
            ox +
          qt *
          r.
            dx;
        float roy =
          r.
            oy +
          qt *
          r.
            dy;
        float roz =
          r.
            oz +
          qt *
          r.
            dz;
        float invRayLength =
          (float)
            (1 /
               java.lang.Math.
               sqrt(
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
                     dz));
        while (true) {
            float zw =
              rox;
            float zx =
              roy;
            float zy =
              roz;
            float zz =
              0;
            float zpw =
              1;
            float zpx =
              0;
            float zpy =
              0;
            float zpz =
              0;
            float dotz =
              0;
            for (int i =
                   0;
                 i <
                   maxIterations;
                 i++) {
                {
                    float nw =
                      zw *
                      zpw -
                      zx *
                      zpx -
                      zy *
                      zpy -
                      zz *
                      zpz;
                    float nx =
                      zw *
                      zpx +
                      zx *
                      zpw +
                      zy *
                      zpz -
                      zz *
                      zpy;
                    float ny =
                      zw *
                      zpy +
                      zy *
                      zpw +
                      zz *
                      zpx -
                      zx *
                      zpz;
                    zpz =
                      2 *
                        (zw *
                           zpz +
                           zz *
                           zpw +
                           zx *
                           zpy -
                           zy *
                           zpx);
                    zpw =
                      2 *
                        nw;
                    zpx =
                      2 *
                        nx;
                    zpy =
                      2 *
                        ny;
                }
                {
                    float nw =
                      zw *
                      zw -
                      zx *
                      zx -
                      zy *
                      zy -
                      zz *
                      zz +
                      cw;
                    zx =
                      2 *
                        zw *
                        zx +
                        cx;
                    zy =
                      2 *
                        zw *
                        zy +
                        cy;
                    zz =
                      2 *
                        zw *
                        zz +
                        cz;
                    zw =
                      nw;
                }
                dotz =
                  zw *
                    zw +
                    zx *
                    zx +
                    zy *
                    zy +
                    zz *
                    zz;
                if (dotz >
                      ESCAPE_THRESHOLD)
                    break;
            }
            float normZ =
              (float)
                java.lang.Math.
                sqrt(
                  dotz);
            dist =
              0.5F *
                normZ *
                (float)
                  java.lang.Math.
                  log(
                    normZ) /
                length(
                  zpw,
                  zpx,
                  zpy,
                  zpz);
            rox +=
              dist *
                r.
                  dx;
            roy +=
              dist *
                r.
                  dy;
            roz +=
              dist *
                r.
                  dz;
            qt +=
              dist;
            if (dist *
                  invRayLength <
                  epsilon)
                break;
            if (rox *
                  rox +
                  roy *
                  roy +
                  roz *
                  roz >
                  BOUNDING_RADIUS2)
                return;
        }
        if (!r.
              isInside(
                qt))
            return;
        if (dist *
              invRayLength <
              epsilon) {
            r.
              setMax(
                qt);
            state.
              setIntersection(
                0,
                0,
                0);
        }
    }
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
        float gx1w =
          p.
            x -
          DELTA;
        float gx1x =
          p.
            y;
        float gx1y =
          p.
            z;
        float gx1z =
          0;
        float gx2w =
          p.
            x +
          DELTA;
        float gx2x =
          p.
            y;
        float gx2y =
          p.
            z;
        float gx2z =
          0;
        float gy1w =
          p.
            x;
        float gy1x =
          p.
            y -
          DELTA;
        float gy1y =
          p.
            z;
        float gy1z =
          0;
        float gy2w =
          p.
            x;
        float gy2x =
          p.
            y +
          DELTA;
        float gy2y =
          p.
            z;
        float gy2z =
          0;
        float gz1w =
          p.
            x;
        float gz1x =
          p.
            y;
        float gz1y =
          p.
            z -
          DELTA;
        float gz1z =
          0;
        float gz2w =
          p.
            x;
        float gz2x =
          p.
            y;
        float gz2y =
          p.
            z +
          DELTA;
        float gz2z =
          0;
        for (int i =
               0;
             i <
               maxIterations;
             i++) {
            {
                float nw =
                  gx1w *
                  gx1w -
                  gx1x *
                  gx1x -
                  gx1y *
                  gx1y -
                  gx1z *
                  gx1z +
                  cw;
                gx1x =
                  2 *
                    gx1w *
                    gx1x +
                    cx;
                gx1y =
                  2 *
                    gx1w *
                    gx1y +
                    cy;
                gx1z =
                  2 *
                    gx1w *
                    gx1z +
                    cz;
                gx1w =
                  nw;
            }
            {
                float nw =
                  gx2w *
                  gx2w -
                  gx2x *
                  gx2x -
                  gx2y *
                  gx2y -
                  gx2z *
                  gx2z +
                  cw;
                gx2x =
                  2 *
                    gx2w *
                    gx2x +
                    cx;
                gx2y =
                  2 *
                    gx2w *
                    gx2y +
                    cy;
                gx2z =
                  2 *
                    gx2w *
                    gx2z +
                    cz;
                gx2w =
                  nw;
            }
            {
                float nw =
                  gy1w *
                  gy1w -
                  gy1x *
                  gy1x -
                  gy1y *
                  gy1y -
                  gy1z *
                  gy1z +
                  cw;
                gy1x =
                  2 *
                    gy1w *
                    gy1x +
                    cx;
                gy1y =
                  2 *
                    gy1w *
                    gy1y +
                    cy;
                gy1z =
                  2 *
                    gy1w *
                    gy1z +
                    cz;
                gy1w =
                  nw;
            }
            {
                float nw =
                  gy2w *
                  gy2w -
                  gy2x *
                  gy2x -
                  gy2y *
                  gy2y -
                  gy2z *
                  gy2z +
                  cw;
                gy2x =
                  2 *
                    gy2w *
                    gy2x +
                    cx;
                gy2y =
                  2 *
                    gy2w *
                    gy2y +
                    cy;
                gy2z =
                  2 *
                    gy2w *
                    gy2z +
                    cz;
                gy2w =
                  nw;
            }
            {
                float nw =
                  gz1w *
                  gz1w -
                  gz1x *
                  gz1x -
                  gz1y *
                  gz1y -
                  gz1z *
                  gz1z +
                  cw;
                gz1x =
                  2 *
                    gz1w *
                    gz1x +
                    cx;
                gz1y =
                  2 *
                    gz1w *
                    gz1y +
                    cy;
                gz1z =
                  2 *
                    gz1w *
                    gz1z +
                    cz;
                gz1w =
                  nw;
            }
            {
                float nw =
                  gz2w *
                  gz2w -
                  gz2x *
                  gz2x -
                  gz2y *
                  gz2y -
                  gz2z *
                  gz2z +
                  cw;
                gz2x =
                  2 *
                    gz2w *
                    gz2x +
                    cx;
                gz2y =
                  2 *
                    gz2w *
                    gz2y +
                    cy;
                gz2z =
                  2 *
                    gz2w *
                    gz2z +
                    cz;
                gz2w =
                  nw;
            }
        }
        float gradX =
          length(
            gx2w,
            gx2x,
            gx2y,
            gx2z) -
          length(
            gx1w,
            gx1x,
            gx1y,
            gx1z);
        float gradY =
          length(
            gy2w,
            gy2x,
            gy2y,
            gy2z) -
          length(
            gy1w,
            gy1x,
            gy1y,
            gy1z);
        float gradZ =
          length(
            gz2w,
            gz2x,
            gz2y,
            gz2z) -
          length(
            gz1w,
            gz1x,
            gz1y,
            gz1z);
        org.sunflow.math.Vector3 n =
          new org.sunflow.math.Vector3(
          (float)
            gradX,
          (float)
            gradY,
          (float)
            gradZ);
        state.
          getNormal(
            ).
          set(
            parent.
              transformNormalObjectToWorld(
                n));
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
        state.
          getPoint(
            ).
          x +=
          state.
            getNormal(
              ).
            x *
            epsilon *
            20;
        state.
          getPoint(
            ).
          y +=
          state.
            getNormal(
              ).
            y *
            epsilon *
            20;
        state.
          getPoint(
            ).
          z +=
          state.
            getNormal(
              ).
            z *
            epsilon *
            20;
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
    }
    private static float length(float w, float x, float y, float z) {
        return (float)
                 java.lang.Math.
                 sqrt(
                   w *
                     w +
                     x *
                     x +
                     y *
                     y +
                     z *
                     z);
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        maxIterations =
          pl.
            getInt(
              "iterations",
              maxIterations);
        epsilon =
          pl.
            getFloat(
              "epsilon",
              epsilon);
        cw =
          pl.
            getFloat(
              "cw",
              cw);
        cx =
          pl.
            getFloat(
              "cx",
              cx);
        cy =
          pl.
            getFloat(
              "cy",
              cy);
        cz =
          pl.
            getFloat(
              "cz",
              cz);
        return true;
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "F6KdXsKrWPvqfwFkvGmXTiYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "RSnCuYsRdNHW3M2+0vE40py79B5YLre9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("C77fPmD57e+P/g8C6x3W+2IR1YC1F+v9IdmTJ8m4/bnHEqUMnrqDfJ4rmqtA" +
       "PrGvApO4nc9ckj3P1iT3WGyPvVdL+Sg4vnMgtu98f8R2kqlX7vDso0XzMnAI" +
       "EH/7kgV84eaA8QvHbH7o3bCZRdBDJ0tDizq3p2+pMt9XRis/9+bl+556c/4f" +
       "yurIo+rl+ynovnVs2yfLkk5cXwQuvDZK5u/fFyn5JUeNCHrm7HpVkN35Jxk8" +
       "V9/3aoO043QvEB+L00kyJIIePEEGrOHg6iTRxyLoAiAqLj/u32Z7dl+klZ07" +
       "kV1CJxazq+8k56MuJ2soi4y0LPY/zB7jfbn/DeUrb5L0j3y7/TP7Gk7FlnZl" +
       "acJ9FHRpX056lIG+eOZoh2NdxD/y3Ud+/v6XD7PlR/aAj230BLYXbl8wOXT8" +
       "qCxx3P3jp37hY3/vza+Xu8X/H82794eFMQAA");
}
