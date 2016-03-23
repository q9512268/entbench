package org.sunflow.core.light;
public class PointLight implements org.sunflow.core.LightSource {
    private org.sunflow.math.Point3 lightPoint;
    private org.sunflow.image.Color power;
    public PointLight() { super();
                          lightPoint = new org.sunflow.math.Point3(0, 0, 0);
                          power = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        lightPoint =
          pl.
            getPoint(
              "center",
              lightPoint);
        power =
          pl.
            getColor(
              "power",
              power);
        return true;
    }
    public int getNumSamples() { return 1; }
    public void getSamples(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Vector3 d =
          org.sunflow.math.Point3.
          sub(
            lightPoint,
            state.
              getPoint(
                ),
            new org.sunflow.math.Vector3(
              ));
        if (org.sunflow.math.Vector3.
              dot(
                d,
                state.
                  getNormal(
                    )) >
              0 &&
              org.sunflow.math.Vector3.
              dot(
                d,
                state.
                  getGeoNormal(
                    )) >
              0) {
            org.sunflow.core.LightSample dest =
              new org.sunflow.core.LightSample(
              );
            dest.
              setShadowRay(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  lightPoint));
            float scale =
              1.0F /
              (float)
                (4 *
                   java.lang.Math.
                     PI *
                   lightPoint.
                   distanceToSquared(
                     state.
                       getPoint(
                         )));
            dest.
              setRadiance(
                power,
                power);
            dest.
              getDiffuseRadiance(
                ).
              mul(
                scale);
            dest.
              getSpecularRadiance(
                ).
              mul(
                scale);
            dest.
              traceShadow(
                state);
            state.
              addSample(
                dest);
        }
    }
    public void getPhoton(double randX1, double randY1, double randX2,
                          double randY2,
                          org.sunflow.math.Point3 p,
                          org.sunflow.math.Vector3 dir,
                          org.sunflow.image.Color power) { p.set(
                                                               lightPoint);
                                                           float phi =
                                                             (float)
                                                               (2 *
                                                                  java.lang.Math.
                                                                    PI *
                                                                  randX1);
                                                           float s =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 randY1 *
                                                                   (1.0F -
                                                                      randY1));
                                                           dir.
                                                             x =
                                                             (float)
                                                               java.lang.Math.
                                                               cos(
                                                                 phi) *
                                                               s;
                                                           dir.
                                                             y =
                                                             (float)
                                                               java.lang.Math.
                                                               sin(
                                                                 phi) *
                                                               s;
                                                           dir.
                                                             z =
                                                             (float)
                                                               (1 -
                                                                  2 *
                                                                  randY1);
                                                           power.
                                                             set(
                                                               this.
                                                                 power);
    }
    public float getPower() { return power.getLuminance();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vxsvHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "81//Uy9/uqzz/B+OHPaJiycAAA==");
}
