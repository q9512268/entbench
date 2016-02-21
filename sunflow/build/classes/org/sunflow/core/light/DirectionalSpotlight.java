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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nvjZb/7RV3+vPF76P5cr406+KwAA");
}
