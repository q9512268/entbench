package org.sunflow.core.light;
public class DirectionalSpotlight implements org.sunflow.core.LightSource {
    private org.sunflow.math.Point3 src;
    private org.sunflow.math.Vector3 dir;
    private org.sunflow.math.OrthoNormalBasis basis;
    private float r;
    private float r2;
    private org.sunflow.image.Color radiance;
    public DirectionalSpotlight() { super();
                                    src = new org.sunflow.math.Point3(0, 0,
                                                                      0);
                                    dir = new org.sunflow.math.Vector3(0,
                                                                       0,
                                                                       -1);
                                    dir.normalize();
                                    basis = org.sunflow.math.OrthoNormalBasis.
                                              makeFromW(
                                                dir);
                                    r = 1;
                                    r2 = r * r;
                                    radiance = org.sunflow.image.Color.WHITE;
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        src =
          pl.
            getPoint(
              "source",
              src);
        dir =
          pl.
            getVector(
              "dir",
              dir);
        dir.
          normalize(
            );
        r =
          pl.
            getFloat(
              "radius",
              r);
        basis =
          org.sunflow.math.OrthoNormalBasis.
            makeFromW(
              dir);
        r2 =
          r *
            r;
        radiance =
          pl.
            getColor(
              "radiance",
              radiance);
        return true;
    }
    public int getNumSamples() { return 1; }
    public int getLowSamples() { return 1; }
    public void getSamples(org.sunflow.core.ShadingState state) {
        if (org.sunflow.math.Vector3.
              dot(
                dir,
                state.
                  getGeoNormal(
                    )) <
              0 &&
              org.sunflow.math.Vector3.
              dot(
                dir,
                state.
                  getNormal(
                    )) <
              0) {
            float x =
              state.
                getPoint(
                  ).
                x -
              src.
                x;
            float y =
              state.
                getPoint(
                  ).
                y -
              src.
                y;
            float z =
              state.
                getPoint(
                  ).
                z -
              src.
                z;
            float t =
              x *
              dir.
                x +
              y *
              dir.
                y +
              z *
              dir.
                z;
            if (t >=
                  0.0) {
                x -=
                  t *
                    dir.
                      x;
                y -=
                  t *
                    dir.
                      y;
                z -=
                  t *
                    dir.
                      z;
                if (x *
                      x +
                      y *
                      y +
                      z *
                      z <=
                      r2) {
                    org.sunflow.math.Point3 p =
                      new org.sunflow.math.Point3(
                      );
                    p.
                      x =
                      src.
                        x +
                        x;
                    p.
                      y =
                      src.
                        y +
                        y;
                    p.
                      z =
                      src.
                        z +
                        z;
                    org.sunflow.core.LightSample dest =
                      new org.sunflow.core.LightSample(
                      );
                    dest.
                      setShadowRay(
                        new org.sunflow.core.Ray(
                          state.
                            getPoint(
                              ),
                          p));
                    dest.
                      setRadiance(
                        radiance,
                        radiance);
                    dest.
                      traceShadow(
                        state);
                    state.
                      addSample(
                        dest);
                }
            }
        }
    }
    public void getPhoton(double randX1, double randY1, double randX2,
                          double randY2,
                          org.sunflow.math.Point3 p,
                          org.sunflow.math.Vector3 dir,
                          org.sunflow.image.Color power) { float phi =
                                                             (float)
                                                               (2 *
                                                                  java.lang.Math.
                                                                    PI *
                                                                  randX1);
                                                           float s =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 1.0F -
                                                                   randY1);
                                                           dir.
                                                             x =
                                                             r *
                                                               (float)
                                                                 java.lang.Math.
                                                                 cos(
                                                                   phi) *
                                                               s;
                                                           dir.
                                                             y =
                                                             r *
                                                               (float)
                                                                 java.lang.Math.
                                                                 sin(
                                                                   phi) *
                                                               s;
                                                           dir.
                                                             z =
                                                             0;
                                                           basis.
                                                             transform(
                                                               dir);
                                                           org.sunflow.math.Point3.
                                                             add(
                                                               src,
                                                               dir,
                                                               p);
                                                           dir.
                                                             set(
                                                               this.
                                                                 dir);
                                                           power.
                                                             set(
                                                               radiance).
                                                             mul(
                                                               (float)
                                                                 java.lang.Math.
                                                                   PI *
                                                                 r2);
    }
    public float getPower() { return radiance.copy1(
                                                ).
                                mul(
                                  (float)
                                    java.lang.Math.
                                      PI *
                                    r2).
                                getLuminance(
                                  ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
