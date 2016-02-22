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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fvmTv/us/P2Lj72Ds9IXL/B5keRfH37xK73vMv/iEfTA6RnDHTctbkd65faT" +
       "hYcTO8uTUL7tfOH5U/VXG33fAR3OLKGT9/mdv7MBvvu233cfDOTC4dhRBXB0" +
       "MmAv3DFglR7szE7K07cTsKfOg00O7444qHr4G/c5fvubZfFXM+hKHlt6Zt9t" +
       "W+uqEUW+rYdnpvrT32pT63wvVcVfOVVbdQrzHHhePlbby++O2s4L9Uv3aXuz" +
       "LP5eBr3HtTMhDyZ6EPt2eje5H/COrzJVMv/9d0PmW8cy33r3Zf5n92n7F2Xx" +
       "5YPMfLQ9lrms/EdnAn7l2xDwkROh0GMB0XdHwEu3B6/n7/CFyUK3vNAtr37Z" +
       "FYXfuI8afrMsvppBDwM13GfcH9xEnnWml3/17eplDx7+WC/8u6OXqxXA1btx" +
       "fwVkf8bhHtHXby96ZSGWxa4i+rv3UdV/LYv/AII7UJW4iLLDfYmvnWnlP34b" +
       "WqkmrzJyzo61Mnv33eF/3qftm2Xx3zLoWilctD2cfNtnsv3+O5Ftl0HvvdsN" +
       "o/K6xDN3XGE8XLszf+6N69eefmP6b6pLNqdX4x7ioWtO7vvnT7fPfV+JE9vx" +
       "KgkeOpx1x+Xr0tGF6H929SmDLlfvkulLlw7QlzPoxkVoYPPl6zzYtQx65BwY" +
       "mAWOv84DPQKCJAAqPx+N73L+czjj3106lxgcG0Ol5ye+lZ5PUc5fwSmTieoG" +
       "6cnEnx/ukL5qfukNVvjht1o/dbgCZPp6UZRUrvHQ1cNtpNPk4aV7UjuhdaX/" +
       "4W8+9vMPfegk0XnswPCZYZ7j7cW737dhgjirbsgUf/fpv/29P/3Gb1XHUf8P" +
       "Q39q5NorAAA=");
}
