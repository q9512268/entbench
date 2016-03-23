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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hBse3nNHLv0Pg2s+PeYjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sTO2kk43FeWUhSvuaDQlO31rghPedLHtGuHYJJZut9VnxrTVnsyWc1+exsiq" +
       "ttJbFSOqelIt4fRcnwg5ssKSJNT5ygjpsXy4XcxEk59I1pSMaxNboLa2I0pc" +
       "05+ryzlMLW20Ot0gi4Wzk2nOxUXfokSrx0Qjy9jhC5/2KyBJNrLFYOl17Wkt" +
       "7lYMcUf1kqkby52MEFVmt8jpebiWcaMfcAQhTG1x2Y+2va0RZD3DM4fKkl21" +
       "2SUjZm1rOcZ2ca9Vnze0bLgdqfKgv2w13SXcRFsaZdFWwrmxaIViLE/7fQwz" +
       "jGwz7GeLIO+ZjlAZzL2o7+cMX8trDFY1RyiRhWO5vTZwtobCOL+LwOjDdJb1" +
       "KuiEyVZ8bVqJFr3aejeS/FYAR1M7mMfdWXNDj6xxYzewPVLfTAifHWt86o+H" +
       "kZjOgxUuylwUJwrKLPlqf9bVhiRDb+csPx5NSCugcoGvpqlZpYiVGtb5ioFV" +
       "PXE2pt1NHUOdbI3q0Yq1w7U5Fra2RDNN1tpx7S7hDfm2364MK9jA38GSx1ti" +
       "xfeJcKu5/tTww0ifq73Y8qh5D5tSLcrI6/xcHW2biLcczXBi4PAOn1Uq2TTJ" +
       "RmgfMaeON/W8LbdQt9VZNyZwZF0nqqSR85OOtVZzicNEjB7n/V2Pzze7yMyJ" +
       "cbtdjd1QEh3Vkb3xFm5Tssjb7taTh2ad9HzNWi/GQ2otuXzUExWL6tQ8aivM" +
       "+rLp0/QmNhhRVEfVRXe97c5FeN7ZCZueC7Db9qQWLGx2eKMnBdGoKlsdcZ1P" +
       "t77fMGHNpnzSpCMQkvxptGbXAb2Zaf1RVWhs1+P1ZkSliEhmrp5QVqWqhQ0z" +
       "gJ0+Ic26ol1BNnE/4DNYJ+qVZqwi4zAJFMKqEgbuydSujXH5YiKFLWRiU3o7" +
       "bWh4t0ZY+dBtJbq9WrVGiNjCh9uVS0x3K1/e1btqpHh41SKmsoXRwKz6Jrlk" +
       "xyQ62ya1pl4npikakRXZrMeGPQuN9arbm/pIdWw1W832dOQzo67p12lUnAZB" +
       "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" +
       "O6vU/Xdou1EU14B1gGBEyFtgGOe95+dP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("1Lx079tRM4ug6xfO+hUHlx696fzw/syr8qXXrt/zyGvT/7A/OnF8LvUaB92j" +
       "x5Z19pzJmfoVYNK6Uep/bX/qxCuVeiSCHrv9GcTiOMhZHS89vO/1GFiGL/YC" +
       "8aL4O0v2RAS95wwZMIij2lmipyPoMiAqqs94t/g2tz91k106k5pAZ4L7g28F" +
       "9UmXs4fiii/y5THu46/n8f4g98vKl1/rDX78Tfzn9ofyFEvO84LLPRx0dX8+" +
       "sGRafIF/5rbcjnldYT/wnft/+doLx6nW/XuBT830jGxP3foEXMf2ovLMWv7r" +
       "j/zqD/38a39Wfir8/7iI+kFfLwAA");
}
