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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Gne8P3Pf/S+s4Ec4SRwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fScAAA==");
}
