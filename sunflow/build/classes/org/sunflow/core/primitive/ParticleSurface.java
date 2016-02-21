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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YsAwnDuq2znqhoG7MBLjgey/tkIiOOgiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XZp36Las0Kw97PeFZQyyMRrvdxldnQXBuB/bdZ5H4J7BL/QKyAoXNW8xna2n" +
       "3EK2o3oWoImWNcKWEzloiKoqXsIwrK6zuqYoJbyOGzVJ8p3VquKFqTVn5HA6" +
       "k7cb3+GlYaPmCNKs0la33LY+FYVSQ8NZ0TTt4YhZYc5ytZwYQiqpHtJEFqPK" +
       "uDX3HWbijNfjaVfmPWxlyciaXIFnomiGKyXVAo6SPatfSZtjhFlVCEEi1K7F" +
       "zObr9Xi7hPV5e0mk3U07sHRCTNGktRlXe4yNTpcbi9WxLZfg1bIhKbWxNKYF" +
       "d2g4y4mbch1uorX76awNt3qUMo+Xa34qTmbeZjKr1GRNKrObgdvR2iNeJTOp" +
       "gQ/pUnk2ZzdC2iujYwpZMJVJOxLTilEbSWs8qkVTJ2DjnqqN1wbvN1rtrOwj" +
       "G5ORWnJr22YjvzYdkDVqOh5gsF8ODCyT1l4qdTajbjUmV6kl9DUxlKUeno1b" +
       "JL0YIhi+NepCT5zVOvZqvkZdsw0rXIhko8Z0JUtmec17o7qhUPyiNWKMTbPt" +
       "Z/2ZLyfaqjwelcYdo8JwE37IT/tTGszsbFu21+VVSJYkdM5QojZnZbEv0x3V" +
       "AEpyGRMNh9N6mVG3yzpSF5i+M20hmcRNa7RJuRuOWM69kGxm3SqtV4RsWkkn" +
       "UaYsCaarBXNYd41Ray6j7GSpreM15Q8NU1tNF1a377hSqUVUXX/eKTurGtsn" +
       "ewKdSALfCUZYHxWQVc0wq5K3ivtdmVhj5aZBbIfZxuHxXtASNNzsc0mMM+gy" +
       "TeK4HE3XE54ih7KwDmIOo+asxzCzikHNfKHS1AhFD7YphQiV2rDuVUdNXNqM" +
       "QpnEypLKioFs4SVjbDhSiZACZD1DJpLFbT11zGBZULNtZG4qsceg/GCkMfSQ" +
       "1eoDyuEawMIW2Yrq3qZK0Qy1rFSrkeuKc92v2OS4vEp9aQozGN5nZjMFl6xV" +
       "MOzXTGo8d4FtS76PrGvLKoyukMDrpcLQCvSASZ1B6GJCoPfE4TiASb5lz5vr" +
       "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" +
       "T9S8cPWdqJlG0LW9k335MaVHbzlLvDv/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qnzltWv3PfLa5N/tDkocn1G9MoDu02PbPnuq5Ez9EnBp3Sr0v7I7Y+IXSj0S" +
       "QY/d+cRhfvjjrI4XHt71egwsw/u9AF7kf2fJnoig950hAw5xVDtL9HQEXQRE" +
       "efUZ/zbf2nZnbNILZ1IT6Ay433g7U590OXsELv/CXhzpPv4aHu8Odb+sfPW1" +
       "3vAn3qz93O4InmLLWZZzuW8AXd6dBiyY5l/Un7kjt2Nel+gPv/XAL155/jjV" +
       "emAn8KmbnpHtqdufd2s7flScUMt+9ZFf/uGff+1Pik9//xcsUnszay8AAA==");
}
