package org.sunflow.core.light;
public class SphereLight implements org.sunflow.core.LightSource, org.sunflow.core.Shader {
    private org.sunflow.image.Color radiance;
    private int numSamples;
    private org.sunflow.math.Point3 center;
    private float radius;
    private float r2;
    public SphereLight() { super();
                           radiance = org.sunflow.image.Color.WHITE;
                           numSamples = 4;
                           center = new org.sunflow.math.Point3();
                           radius = (r2 = 1); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        radiance =
          pl.
            getColor(
              "radiance",
              radiance);
        numSamples =
          pl.
            getInt(
              "samples",
              numSamples);
        radius =
          pl.
            getFloat(
              "radius",
              radius);
        r2 =
          radius *
            radius;
        center =
          pl.
            getPoint(
              "center",
              center);
        return true;
    }
    public void init(java.lang.String name, org.sunflow.SunflowAPI api) {
        api.
          light(
            name,
            this);
        api.
          geometry(
            name +
            ".geo",
            new org.sunflow.core.primitive.Sphere(
              ));
        api.
          shader(
            name +
            ".shader",
            this);
        api.
          parameter(
            "shaders",
            name +
            ".shader");
        api.
          parameter(
            "transform",
            org.sunflow.math.Matrix4.
              translation(
                center.
                  x,
                center.
                  y,
                center.
                  z).
              multiply(
                org.sunflow.math.Matrix4.
                  scale(
                    radius)));
        api.
          instance(
            name +
            ".instance",
            name +
            ".geo");
    }
    public int getNumSamples() { return numSamples; }
    public int getLowSamples() { return 1; }
    public boolean isVisible(org.sunflow.core.ShadingState state) {
        return state.
          getPoint(
            ).
          distanceToSquared(
            center) >
          r2;
    }
    public void getSamples(org.sunflow.core.ShadingState state) {
        if (getNumSamples(
              ) <=
              0)
            return;
        org.sunflow.math.Vector3 wc =
          org.sunflow.math.Point3.
          sub(
            center,
            state.
              getPoint(
                ),
            new org.sunflow.math.Vector3(
              ));
        float l2 =
          wc.
          lengthSquared(
            );
        if (l2 <=
              r2)
            return;
        float topX =
          wc.
            x +
          state.
            getNormal(
              ).
            x *
          radius;
        float topY =
          wc.
            y +
          state.
            getNormal(
              ).
            y *
          radius;
        float topZ =
          wc.
            z +
          state.
            getNormal(
              ).
            z *
          radius;
        if (state.
              getNormal(
                ).
              dot(
                topX,
                topY,
                topZ) <=
              0)
            return;
        float cosThetaMax =
          (float)
            java.lang.Math.
            sqrt(
              java.lang.Math.
                max(
                  0,
                  1 -
                    r2 /
                    org.sunflow.math.Vector3.
                    dot(
                      wc,
                      wc)));
        org.sunflow.math.OrthoNormalBasis basis =
          org.sunflow.math.OrthoNormalBasis.
          makeFromW(
            wc);
        int samples =
          state.
          getDiffuseDepth(
            ) >
          0
          ? 1
          : getNumSamples(
              );
        float scale =
          (float)
            (2 *
               java.lang.Math.
                 PI *
               (1 -
                  cosThetaMax));
        org.sunflow.image.Color c =
          org.sunflow.image.Color.
          mul(
            scale /
              samples,
            radiance);
        for (int i =
               0;
             i <
               samples;
             i++) {
            double randX =
              state.
              getRandom(
                i,
                0,
                samples);
            double randY =
              state.
              getRandom(
                i,
                1,
                samples);
            double cosTheta =
              (1 -
                 randX) *
              cosThetaMax +
              randX;
            double sinTheta =
              java.lang.Math.
              sqrt(
                1 -
                  cosTheta *
                  cosTheta);
            double phi =
              randY *
              2 *
              java.lang.Math.
                PI;
            org.sunflow.math.Vector3 dir =
              new org.sunflow.math.Vector3(
              (float)
                (java.lang.Math.
                   cos(
                     phi) *
                   sinTheta),
              (float)
                (java.lang.Math.
                   sin(
                     phi) *
                   sinTheta),
              (float)
                cosTheta);
            basis.
              transform(
                dir);
            float cosNx =
              org.sunflow.math.Vector3.
              dot(
                dir,
                state.
                  getNormal(
                    ));
            if (cosNx <=
                  0)
                continue;
            float ocx =
              state.
                getPoint(
                  ).
                x -
              center.
                x;
            float ocy =
              state.
                getPoint(
                  ).
                y -
              center.
                y;
            float ocz =
              state.
                getPoint(
                  ).
                z -
              center.
                z;
            float qa =
              org.sunflow.math.Vector3.
              dot(
                dir,
                dir);
            float qb =
              2 *
              (dir.
                 x *
                 ocx +
                 dir.
                   y *
                 ocy +
                 dir.
                   z *
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
            if (t ==
                  null)
                continue;
            org.sunflow.core.LightSample dest =
              new org.sunflow.core.LightSample(
              );
            dest.
              setShadowRay(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  dir));
            dest.
              getShadowRay(
                ).
              setMax(
                (float)
                  t[0] -
                  0.001F);
            dest.
              setRadiance(
                c,
                c);
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
                          org.sunflow.image.Color power) { float z =
                                                             (float)
                                                               (1 -
                                                                  2 *
                                                                  randX2);
                                                           float r =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 java.lang.Math.
                                                                   max(
                                                                     0,
                                                                     1 -
                                                                       z *
                                                                       z));
                                                           float phi =
                                                             (float)
                                                               (2 *
                                                                  java.lang.Math.
                                                                    PI *
                                                                  randY2);
                                                           float x =
                                                             r *
                                                             (float)
                                                               java.lang.Math.
                                                               cos(
                                                                 phi);
                                                           float y =
                                                             r *
                                                             (float)
                                                               java.lang.Math.
                                                               sin(
                                                                 phi);
                                                           p.
                                                             x =
                                                             center.
                                                               x +
                                                               x *
                                                               radius;
                                                           p.
                                                             y =
                                                             center.
                                                               y +
                                                               y *
                                                               radius;
                                                           p.
                                                             z =
                                                             center.
                                                               z +
                                                               z *
                                                               radius;
                                                           org.sunflow.math.OrthoNormalBasis basis =
                                                             org.sunflow.math.OrthoNormalBasis.
                                                             makeFromW(
                                                               new org.sunflow.math.Vector3(
                                                                 x,
                                                                 y,
                                                                 z));
                                                           phi =
                                                             (float)
                                                               (2 *
                                                                  java.lang.Math.
                                                                    PI *
                                                                  randX1);
                                                           float cosPhi =
                                                             (float)
                                                               java.lang.Math.
                                                               cos(
                                                                 phi);
                                                           float sinPhi =
                                                             (float)
                                                               java.lang.Math.
                                                               sin(
                                                                 phi);
                                                           float sinTheta =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 randY1);
                                                           float cosTheta =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 1 -
                                                                   randY1);
                                                           dir.
                                                             x =
                                                             cosPhi *
                                                               sinTheta;
                                                           dir.
                                                             y =
                                                             sinPhi *
                                                               sinTheta;
                                                           dir.
                                                             z =
                                                             cosTheta;
                                                           basis.
                                                             transform(
                                                               dir);
                                                           power.
                                                             set(
                                                               radiance);
                                                           power.
                                                             mul(
                                                               (float)
                                                                 (java.lang.Math.
                                                                    PI *
                                                                    java.lang.Math.
                                                                      PI *
                                                                    4 *
                                                                    r2));
    }
    public float getPower() { return radiance.
                                copy1(
                                  ).
                                mul(
                                  (float)
                                    (java.lang.Math.
                                       PI *
                                       java.lang.Math.
                                         PI *
                                       4 *
                                       r2)).
                                getLuminance(
                                  ); }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (!state.
              includeLights(
                ))
            return org.sunflow.image.Color.
                     BLACK;
        state.
          faceforward(
            );
        return state.
          isBehind(
            )
          ? org.sunflow.image.Color.
              BLACK
          : radiance;
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7Tw1yD6Kv7NkMEBzhgwkZkd3Z4mQsHIf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ICpum+5x/DizEbw/rJPu55snz5pEGQm+rSWdNDl7lq7I78vz3se5eLQ/8X1T" +
       "+vLrI+ajb7a+sD/LJ5lCnhe9XKYql/bHCstOi3z++bv2dtzXReLFbz30Cw98" +
       "4Pjb46E9w6fmeYa399354BxuuWF51C3/lSd+6ft/5vXfL3fC/z9fuFf/iC8A" +
       "AA==");
}
