package org.sunflow.core.primitive;
public class ParticleSurface implements org.sunflow.core.PrimitiveList {
    private float[] particles;
    private float r;
    private float r2;
    private int n;
    public ParticleSurface() { super();
                               particles = null;
                               r = (r2 = 1);
                               n = 0; }
    public int getNumPrimitives() { return n; }
    public float getPrimitiveBound(int primID, int i) { float c = particles[primID *
                                                                              3 +
                                                                              (i >>>
                                                                                 1)];
                                                        return (i &
                                                                  1) ==
                                                          0
                                                          ? c -
                                                          r
                                                          : c +
                                                          r;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          );
        for (int i =
               0,
               i3 =
                 0;
             i <
               n;
             i++,
               i3 +=
                 3)
            bounds.
              include(
                particles[i3],
                particles[i3 +
                            1],
                particles[i3 +
                            2]);
        bounds.
          include(
            bounds.
              getMinimum(
                ).
              x -
              r,
            bounds.
              getMinimum(
                ).
              y -
              r,
            bounds.
              getMinimum(
                ).
              z -
              r);
        bounds.
          include(
            bounds.
              getMaximum(
                ).
              x +
              r,
            bounds.
              getMaximum(
                ).
              y +
              r,
            bounds.
              getMaximum(
                ).
              z +
              r);
        return o2w ==
          null
          ? bounds
          : o2w.
          transform(
            bounds);
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        int i3 =
          primID *
          3;
        float ocx =
          r.
            ox -
          particles[i3 +
                      0];
        float ocy =
          r.
            oy -
          particles[i3 +
                      1];
        float ocz =
          r.
            oz -
          particles[i3 +
                      2];
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
             ocx +
             r.
               dy *
             ocy +
             r.
               dz *
             ocz);
        float qc =
          ocx *
          ocx +
          ocy *
          ocy +
          ocz *
          ocz -
          r2;
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
                primID,
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
        org.sunflow.math.Point3 localPoint =
          state.
          getInstance(
            ).
          transformWorldToObject(
            state.
              getPoint(
                ));
        localPoint.
          x -=
          particles[3 *
                      state.
                      getPrimitiveID(
                        ) +
                      0];
        localPoint.
          y -=
          particles[3 *
                      state.
                      getPrimitiveID(
                        ) +
                      1];
        localPoint.
          z -=
          particles[3 *
                      state.
                      getPrimitiveID(
                        ) +
                      2];
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
        state.
          setShader(
            state.
              getInstance(
                ).
              getShader(
                0));
        state.
          setModifier(
            state.
              getInstance(
                ).
              getModifier(
                0));
        org.sunflow.math.Vector3 worldNormal =
          state.
          getInstance(
            ).
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
    public boolean update(org.sunflow.core.ParameterList pl,
                          org.sunflow.SunflowAPI api) {
        org.sunflow.core.ParameterList.FloatParameter p =
          pl.
          getPointArray(
            "particles");
        if (p !=
              null)
            particles =
              p.
                data;
        r =
          pl.
            getFloat(
              "radius",
              r);
        r2 =
          r *
            r;
        n =
          pl.
            getInt(
              "num",
              n);
        return particles !=
          null &&
          n <=
          particles.
            length /
          3;
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
       "b8x0yRoqxA0P775Dl/4P1owK9PojAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FRKrfBgU7Uhs2nsjtrNMPXCHsetFdRVo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("B3BGuOIAxThvPT9/wual+94Jm1lSuXbh9l9xlenRm+4W7+/Dal9+/dq9j7w+" +
       "/Q/7yxTHd1avspV7zY3rnr15cqZ9Gai0aZf8X93fQwlLph5JKo/d/lZicUHk" +
       "LI+XHt7PegyE4YuzgL8o/s6CPZFU3ncGDCjEUess0NNJ5S4AVDSfCW/xjW5/" +
       "Dye7dCY1qZxx7jfeTtQnU85ekyu+zJdXvI+/om/2l7xf0b7yOsP95Futn9tf" +
       "09NcJc8LLPeylSv7G4Ml0uJL/DO3xXaM6zL9oe8+8ItXXzhOtR7YE3yqpmdo" +
       "e+rWd+K6XpiUt9jyX33kl3/k51//0/KT4f8D4udssXsvAAA=");
}
