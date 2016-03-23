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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2nlqkH0Uf2fJagDNGTKQmB3dnSVqxJX7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("AFFx2/SP48eZTeD9QZ1sP988edYkykjwHS3ppMnZc3RFfl+e8D7OxZP9Ge9X" +
       "jC+/0RM+8q3WF/bn+AxHy/Oil8tc5dL+SGHZaZHPP3/H3o77usi8+O2HfvmB" +
       "9x1/ezy0Z/jUPM/w9p7bH5qjNn5cHnPLf+2JX/nBv/nGH5S74P8PwW6EU3ov" +
       "AAA=");
}
