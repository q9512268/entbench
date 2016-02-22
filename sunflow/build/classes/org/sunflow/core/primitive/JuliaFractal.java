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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8VW5P78vRDu9lFexdtl/Ad7IGfFYJgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cCWCrliyo+7qHo8izYWr74Pl4ug75/ud");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fZbf+d7ofz+w3mG/zzdRGVh7vt8fkD11nIzbfWNsv5DB03eQz/N5cwPIJ/Yk" +
       "YBJn+czVtetasuAcie3x92spHwfXt/fF9u3vjdiOM/XqHfo+njevAIcA8bct" +
       "mMAXTgaMXzhi8yP3wmYaQQ8fLw/Na92eua3mfFcnLf7cW9fuf/qt2X8oKiQP" +
       "a5kfoKH7ldiyjpcmHbu/AlxY0QvmH9gVKnkFR7UIevb8mlWQ3XnHGbxQ3Y2q" +
       "g7Tj9CgQH/Ov42StCHroGBmwhv2740SfiKBLgCi//X7vjCPaXaFWeuFYdgkd" +
       "28xuvJecD4ccr6PMM9Ki9P8ge4x3xf+3xK+8RY1++N36z+zqOEVLyIryhPtp" +
       "6OqupPQwA33p3NkO5rrS+9h3Hv35B145yJYf3QE+stFj2F48u2iStL2oKHPM" +
       "/vHTv/CJv/fW14sT4/8PQg85IpMxAAA=");
}
