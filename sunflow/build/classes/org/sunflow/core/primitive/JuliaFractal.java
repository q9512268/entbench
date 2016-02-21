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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "afYp92FudU3DJRjo51Hsv9GUoJIyJQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hhHImtRlZcpIl1QPodJe1DMZrJos401fWHbTcEkQCu1Rm1kbW/nCxDSXPjnl" +
       "28TCY5ZCp0uWjdRvcW3JHxKrlLcnNM+0nLFNiD0vnDQrozFlcFWCtqYV3OGa" +
       "FIlmnYBk+gOGbwkuMWfZjV3T6v3yej2mZrIa4vJca6uB2SEnbQdtk+LaQ2KK" +
       "5zuK6DPKcuV1mmjmNVrswJZ0WhRnlMRIlBpG8xkhLzpB2co242iJiag+lI0x" +
       "Ua5teLYlTCedyoTrrCW6u8pGY3Yy5yppU/S9rbydqiwvjkIFJ7Oy2aw4C6kl" +
       "ja1FNfKaAtHCBtM5v541p2t0EPLOTLJwJg2t9dwiZG8UelYfHdstw5tmg67K" +
       "1LlqFxkC8QfOer6csxrVVkulEJ6R7Hq8Wg5EZmvEXYbBR23WGRgCu+4KWM3j" +
       "rbG38DKhO2mLTIWftyhHCmdSs+a3O9SiYy90PwpLbToixUoWcSmlbJbNruSO" +
       "JXk902d8rdsJ5zDHh0uci61GqraFCtKfJ16HsFtMz+dHNJqtGL/G931CEGda" +
       "u7PlAlnHcQKf+U1LJnuD0PKnraGJN1fl+Wo0tYftDRGstT5eMlBqnI7E5oS1" +
       "t0tpZg7JocLUlxJFazHRyYgO7oTowOCt/oBetjhitvB5edjruU6jzrWkDaJ4" +
       "ycgfjRncGQ8Em6JLrUVbaK5IyV85a6Fi0KzDTscwvwk53q/yuIkPMgOfiCad" +
       "wN2mlswjsVHPvLE4N1pOv9eULWvj0B6a6F2noZVqHdLklyO7PyB4BR7XuNLW" +
       "k8KV0uy3TMrhxYXV9uRwMx62E2SZVgzdK5UpvsNTtmetXaHUolWpK5UtXmza" +
       "sTdyZ62ywJNZV+16fjwcl40G1uX4UVhNDNQBonFIux+gQsPt6nWOXa1wYjId" +
       "sbpgs2tX1EnMIJGqUh6tjMawM8KG9JyEuUEyjnsmIKQ2dcbrsl3L9NQypc9p" +
       "YirwI98c47DHdgZzIWSp2SpgmtRELPelbF3H8veQwSTsir2u2qqsPKnmO1O2" +
       "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" +
       "fn9I9uRJMn73jQ+ZQgZP3UE+z+XNDSCf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2FeBSZznM1dlz7M1yT0W22Pv1VI+Cq5vHYjtW98dsZ1k6pU79H00b14GDgHi" +
       "b0taAV84HTB+8ZjND70bNtMIeuhkiWder/b0bbXku/pn5effvHbfU28K/7ao" +
       "cjyqUb6/B92nx7Z9srzoxP0V4MK6VTB//67YyC84qkXQMxfXnYLszj/J4KXq" +
       "blQTpB1nR4H4mH+dJMMi6METZMAaDu5OEn0sgi4Dovz2e/1zjll3xVbppRPZ" +
       "JXRiM7vxTnI+GnKyFjLPSIuS/sPsMd4V9d9SvvQmO/jBbzZ/aleLqdhSVpQY" +
       "3NeDru7KQo8y0BcvnO1wriv0R779yC/c//JhtvzIDvCxjZ7A9sL5hY+k40dF" +
       "qWL2D576xY/99JtfLU59/y+JmFd3azEAAA==");
}
