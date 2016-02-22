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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wFSRTofOR0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
