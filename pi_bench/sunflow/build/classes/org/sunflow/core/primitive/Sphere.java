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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zRrTbfF1bdYBi3/Ki4DlkRng74sgD+TtB1F7P+B+Apq3FqpPeG114tGjx+Pb" +
       "n1tnVhFNuXt+H5S0L/z2P2+Fjv3xzVk2oyqmamtlOkFlj2oVOGXOhjLISzc3" +
       "qb1X9/j7r3Qme+ayl2Bf2212C/y9DIxYXXhv8Kvy+qN/W7Lz/tSeOWwLy3xw" +
       "+kV+b/DUmw+sEh8P8jrV3BHy6ttcpm4vsDCpTqEgV9BM7JnHg2qF4yfz0S0W" +
       "w9Nk+UmTP6jM/M2dDps+h5W7Y3URVl/OCPIVDRZxNoSGQrmNzmaTtXjJhs3v" +
       "zdEBrtZni2Sl3dgMQzLPaHFIzLmFCTrIcGbMYI5/m1Xwx6J7xJnO6J9N/108" +
       "C4NJ13wy/PWRd/e+xVe6El3LwdfjVuCCnu2wAZsQxlBXkXNnrj7hA01Xxr99" +
       "9QVTH3+Z7yOmM0e/9mHo8FEztsyz0Iq844iXxzwP+bRrLzYL5+j/y+kDPzl5" +
       "4GDQgvpBRirGVFWmguIsRcCpBxfkomjquuVQ/U+PNJX0Q9QOkMqMIu3L0IF4" +
       "rudWGJkxD6zu8cn1Y0tr3JEZCay2U+Unsdlpvm/8P7M0dvRovH+74/ILcWwl" +
       "PC2Wy7fMPVoKsfp8OZCbmhd5wyANB5jQoABn1Ox6PuNkkUDYjw0UeXVJyj6j" +
       "6nK8R80occMWvDRPMB+H02+P6kHTuANo8i2pA55WC5LWuaNZiLVI7tljuTp+" +
       "iZ73JCMlknXb4lkB/ClzTQ7xdqYI1t/A5jFGGgFrJ25MvG8zM9S+qlBgbncV" +
       "vnIHVqEex5bB025B2T73VSjEWgSq7xQZ+y42zzDSADAOZdIOkpz4kAvHt+4A" +
       "HDU4di8xw5zY33ODoxBr8RBvzdsQh1MCBiJexFE+7akioJ3B5nlG5ms6hdMN" +
       "9TLP5nGlE6oUd7E8eaewHIJniwXIlrljWYjVh0QJV6TExnJBHpY7hCnXe4Ci" +
       "I49iAO8TDbMWdyE/WwTyn2PzCpwDJZvVcVUceclF98d3AF2s2vjF1YgF0cjc" +
       "0S3EWsTo3xQZu4DNL8EHIXB7BChBkrmxu9VF5PxHgUgW6jvzogpPVYvybrjN" +
       "W1nxxeP1lQuPP/QuPyM4N6e1ULolMrLsKTm85Uc5xFFC4mbVmidRjX9dYmRJ" +
       "4XszOMdoOSZfNLn+ANnMzwUxiF9esiuM1HjIGBZB/M1L9CfYqIAIX9/XbH9u" +
       "4EdKvLwOmTe12UD+sZEj33w75B0W7x0Klqr8jwa7lsuYfzXExNPHtw3tv/6J" +
       "58w7HFEWpqdRSg1UcOZNkXPaaS8ozZZVvrXrVt2ZqpV2aZlzh+TVja8/JE9+" +
       "37LEd6lhdDp3G5dObDz7q5nyt6Eo3kUCArjmLs81v4lUd1bLwDFzVyS/UoWT" +
       "Ib9t6e56Zur+NYl//p6fyIlZ2S4tTB8TR5+4OHBm/OYmfrNdBlUzzY6SasnY" +
       "MqXsoOKEnlP21qFPCviXA8fBgm+e04uXeZCy8ov5/CvQanAWqvOaA8VA4Vzj" +
       "9tin3JwDYkbTfAxuj+f8Mm5uH4g++F8sMqhp9k3YoxqPR7lw6XSDv2Jz83+m" +
       "gDLecxwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Hz7z3fyc7f8B+wQgooAnAAA=");
}
