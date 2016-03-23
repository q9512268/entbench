package org.sunflow.core.light;
public class TriangleMeshLight extends org.sunflow.core.primitive.TriangleMesh implements org.sunflow.core.Shader {
    private org.sunflow.image.Color radiance;
    private int numSamples;
    public TriangleMeshLight() { super();
                                 radiance = org.sunflow.image.Color.WHITE;
                                 numSamples = 4; }
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
        return super.
          update(
            pl,
            api);
    }
    public void init(java.lang.String name, org.sunflow.SunflowAPI api) {
        api.
          geometry(
            name,
            this);
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
          instance(
            name +
            ".instance",
            name);
        for (int i =
               0,
               j =
                 0;
             i <
               triangles.
                 length;
             i +=
               3,
               j++) {
            org.sunflow.core.light.TriangleMeshLight.TriangleLight t =
              new org.sunflow.core.light.TriangleMeshLight.TriangleLight(
              j);
            java.lang.String lname =
              java.lang.String.
              format(
                "%s.light[%d]",
                name,
                j);
            api.
              light(
                lname,
                t);
        }
    }
    private class TriangleLight implements org.sunflow.core.LightSource {
        private int tri3;
        private float area;
        private org.sunflow.math.Vector3 ng;
        TriangleLight(int tri) { super();
                                 tri3 = 3 * tri;
                                 int a = triangles[tri3 + 0];
                                 int b = triangles[tri3 + 1];
                                 int c = triangles[tri3 + 2];
                                 org.sunflow.math.Point3 v0p = getPoint(
                                                                 a);
                                 org.sunflow.math.Point3 v1p = getPoint(
                                                                 b);
                                 org.sunflow.math.Point3 v2p = getPoint(
                                                                 c);
                                 ng = org.sunflow.math.Point3.normal(
                                                                v0p,
                                                                v1p,
                                                                v2p);
                                 area = 0.5F * ng.length();
                                 ng.normalize(); }
        public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
            return true;
        }
        public int getNumSamples() { return numSamples; }
        private final boolean intersectTriangleKensler(org.sunflow.core.Ray r) {
            int a =
              3 *
              triangles[tri3 +
                          0];
            int b =
              3 *
              triangles[tri3 +
                          1];
            int c =
              3 *
              triangles[tri3 +
                          2];
            float edge0x =
              points[b +
                       0] -
              points[a +
                       0];
            float edge0y =
              points[b +
                       1] -
              points[a +
                       1];
            float edge0z =
              points[b +
                       2] -
              points[a +
                       2];
            float edge1x =
              points[a +
                       0] -
              points[c +
                       0];
            float edge1y =
              points[a +
                       1] -
              points[c +
                       1];
            float edge1z =
              points[a +
                       2] -
              points[c +
                       2];
            float nx =
              edge0y *
              edge1z -
              edge0z *
              edge1y;
            float ny =
              edge0z *
              edge1x -
              edge0x *
              edge1z;
            float nz =
              edge0x *
              edge1y -
              edge0y *
              edge1x;
            float v =
              r.
              dot(
                nx,
                ny,
                nz);
            float iv =
              1 /
              v;
            float edge2x =
              points[a +
                       0] -
              r.
                ox;
            float edge2y =
              points[a +
                       1] -
              r.
                oy;
            float edge2z =
              points[a +
                       2] -
              r.
                oz;
            float va =
              nx *
              edge2x +
              ny *
              edge2y +
              nz *
              edge2z;
            float t =
              iv *
              va;
            if (t <=
                  0)
                return false;
            float ix =
              edge2y *
              r.
                dz -
              edge2z *
              r.
                dy;
            float iy =
              edge2z *
              r.
                dx -
              edge2x *
              r.
                dz;
            float iz =
              edge2x *
              r.
                dy -
              edge2y *
              r.
                dx;
            float v1 =
              ix *
              edge1x +
              iy *
              edge1y +
              iz *
              edge1z;
            float beta =
              iv *
              v1;
            if (beta <
                  0)
                return false;
            float v2 =
              ix *
              edge0x +
              iy *
              edge0y +
              iz *
              edge0z;
            if ((v1 +
                   v2) *
                  v >
                  v *
                  v)
                return false;
            float gamma =
              iv *
              v2;
            if (gamma <
                  0)
                return false;
            r.
              setMax(
                t -
                  0.001F);
            return true;
        }
        public void getSamples(org.sunflow.core.ShadingState state) {
            if (numSamples ==
                  0)
                return;
            org.sunflow.math.Vector3 n =
              state.
              getNormal(
                );
            org.sunflow.math.Point3 p =
              state.
              getPoint(
                );
            org.sunflow.math.Vector3 p0 =
              org.sunflow.math.Point3.
              sub(
                getPoint(
                  triangles[tri3 +
                              0]),
                p,
                new org.sunflow.math.Vector3(
                  ));
            if (org.sunflow.math.Vector3.
                  dot(
                    p0,
                    ng) >=
                  0)
                return;
            org.sunflow.math.Vector3 p1 =
              org.sunflow.math.Point3.
              sub(
                getPoint(
                  triangles[tri3 +
                              1]),
                p,
                new org.sunflow.math.Vector3(
                  ));
            org.sunflow.math.Vector3 p2 =
              org.sunflow.math.Point3.
              sub(
                getPoint(
                  triangles[tri3 +
                              2]),
                p,
                new org.sunflow.math.Vector3(
                  ));
            if (org.sunflow.math.Vector3.
                  dot(
                    p0,
                    n) <=
                  0 &&
                  org.sunflow.math.Vector3.
                  dot(
                    p1,
                    n) <=
                  0 &&
                  org.sunflow.math.Vector3.
                  dot(
                    p2,
                    n) <=
                  0)
                return;
            p0.
              normalize(
                );
            p1.
              normalize(
                );
            p2.
              normalize(
                );
            float dot =
              org.sunflow.math.Vector3.
              dot(
                p2,
                p0);
            org.sunflow.math.Vector3 h =
              new org.sunflow.math.Vector3(
              );
            h.
              x =
              p2.
                x -
                dot *
                p0.
                  x;
            h.
              y =
              p2.
                y -
                dot *
                p0.
                  y;
            h.
              z =
              p2.
                z -
                dot *
                p0.
                  z;
            float hlen =
              h.
              length(
                );
            if (hlen >
                  1.0E-6F)
                h.
                  div(
                    hlen);
            else
                return;
            org.sunflow.math.Vector3 n0 =
              org.sunflow.math.Vector3.
              cross(
                p0,
                p1,
                new org.sunflow.math.Vector3(
                  ));
            float len0 =
              n0.
              length(
                );
            if (len0 >
                  1.0E-6F)
                n0.
                  div(
                    len0);
            else
                return;
            org.sunflow.math.Vector3 n1 =
              org.sunflow.math.Vector3.
              cross(
                p1,
                p2,
                new org.sunflow.math.Vector3(
                  ));
            float len1 =
              n1.
              length(
                );
            if (len1 >
                  1.0E-6F)
                n1.
                  div(
                    len1);
            else
                return;
            org.sunflow.math.Vector3 n2 =
              org.sunflow.math.Vector3.
              cross(
                p2,
                p0,
                new org.sunflow.math.Vector3(
                  ));
            float len2 =
              n2.
              length(
                );
            if (len2 >
                  1.0E-6F)
                n2.
                  div(
                    len2);
            else
                return;
            float cosAlpha =
              org.sunflow.math.MathUtils.
              clamp(
                -org.sunflow.math.Vector3.
                  dot(
                    n2,
                    n0),
                -1.0F,
                1.0F);
            float cosBeta =
              org.sunflow.math.MathUtils.
              clamp(
                -org.sunflow.math.Vector3.
                  dot(
                    n0,
                    n1),
                -1.0F,
                1.0F);
            float cosGamma =
              org.sunflow.math.MathUtils.
              clamp(
                -org.sunflow.math.Vector3.
                  dot(
                    n1,
                    n2),
                -1.0F,
                1.0F);
            float alpha =
              (float)
                java.lang.Math.
                acos(
                  cosAlpha);
            float beta =
              (float)
                java.lang.Math.
                acos(
                  cosBeta);
            float gamma =
              (float)
                java.lang.Math.
                acos(
                  cosGamma);
            float area =
              alpha +
              beta +
              gamma -
              (float)
                java.lang.Math.
                  PI;
            float cosC =
              org.sunflow.math.MathUtils.
              clamp(
                org.sunflow.math.Vector3.
                  dot(
                    p0,
                    p1),
                -1.0F,
                1.0F);
            float salpha =
              (float)
                java.lang.Math.
                sin(
                  alpha);
            float product =
              salpha *
              cosC;
            int samples =
              state.
              getDiffuseDepth(
                ) >
              0
              ? 1
              : numSamples;
            org.sunflow.image.Color c =
              org.sunflow.image.Color.
              mul(
                area /
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
                float phi =
                  (float)
                    randX *
                  area -
                  alpha +
                  (float)
                    java.lang.Math.
                      PI;
                float sinPhi =
                  (float)
                    java.lang.Math.
                    sin(
                      phi);
                float cosPhi =
                  (float)
                    java.lang.Math.
                    cos(
                      phi);
                float u =
                  cosPhi +
                  cosAlpha;
                float v =
                  sinPhi -
                  product;
                float q =
                  (-v +
                     cosAlpha *
                     (cosPhi *
                        -v +
                        sinPhi *
                        u)) /
                  (salpha *
                     (sinPhi *
                        -v -
                        cosPhi *
                        u));
                float q1 =
                  1.0F -
                  q *
                  q;
                if (q1 <
                      0.0F)
                    q1 =
                      0.0F;
                float sqrtq1 =
                  (float)
                    java.lang.Math.
                    sqrt(
                      q1);
                float ncx =
                  q *
                  p0.
                    x +
                  sqrtq1 *
                  h.
                    x;
                float ncy =
                  q *
                  p0.
                    y +
                  sqrtq1 *
                  h.
                    y;
                float ncz =
                  q *
                  p0.
                    z +
                  sqrtq1 *
                  h.
                    z;
                dot =
                  p1.
                    dot(
                      ncx,
                      ncy,
                      ncz);
                float z =
                  1.0F -
                  (float)
                    randY *
                  (1.0F -
                     dot);
                float z1 =
                  1.0F -
                  z *
                  z;
                if (z1 <
                      0.0F)
                    z1 =
                      0.0F;
                org.sunflow.math.Vector3 nd =
                  new org.sunflow.math.Vector3(
                  );
                nd.
                  x =
                  ncx -
                    dot *
                    p1.
                      x;
                nd.
                  y =
                  ncy -
                    dot *
                    p1.
                      y;
                nd.
                  z =
                  ncz -
                    dot *
                    p1.
                      z;
                nd.
                  normalize(
                    );
                float sqrtz1 =
                  (float)
                    java.lang.Math.
                    sqrt(
                      z1);
                org.sunflow.math.Vector3 result =
                  new org.sunflow.math.Vector3(
                  );
                result.
                  x =
                  z *
                    p1.
                      x +
                    sqrtz1 *
                    nd.
                      x;
                result.
                  y =
                  z *
                    p1.
                      y +
                    sqrtz1 *
                    nd.
                      y;
                result.
                  z =
                  z *
                    p1.
                      z +
                    sqrtz1 *
                    nd.
                      z;
                if (org.sunflow.math.Vector3.
                      dot(
                        result,
                        n) >
                      0 &&
                      org.sunflow.math.Vector3.
                      dot(
                        result,
                        state.
                          getGeoNormal(
                            )) >
                      0 &&
                      org.sunflow.math.Vector3.
                      dot(
                        result,
                        ng) <
                      0) {
                    org.sunflow.core.Ray shadowRay =
                      new org.sunflow.core.Ray(
                      state.
                        getPoint(
                          ),
                      result);
                    if (!intersectTriangleKensler(
                           shadowRay))
                        continue;
                    org.sunflow.core.LightSample dest =
                      new org.sunflow.core.LightSample(
                      );
                    dest.
                      setShadowRay(
                        shadowRay);
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
        }
        public void getPhoton(double randX1, double randY1,
                              double randX2,
                              double randY2,
                              org.sunflow.math.Point3 p,
                              org.sunflow.math.Vector3 dir,
                              org.sunflow.image.Color power) {
            double s =
              java.lang.Math.
              sqrt(
                1 -
                  randX2);
            float u =
              (float)
                (randY2 *
                   s);
            float v =
              (float)
                (1 -
                   s);
            float w =
              1 -
              u -
              v;
            int index0 =
              3 *
              triangles[tri3 +
                          0];
            int index1 =
              3 *
              triangles[tri3 +
                          1];
            int index2 =
              3 *
              triangles[tri3 +
                          2];
            p.
              x =
              w *
                points[index0 +
                         0] +
                u *
                points[index1 +
                         0] +
                v *
                points[index2 +
                         0];
            p.
              y =
              w *
                points[index0 +
                         1] +
                u *
                points[index1 +
                         1] +
                v *
                points[index2 +
                         1];
            p.
              z =
              w *
                points[index0 +
                         2] +
                u *
                points[index1 +
                         2] +
                v *
                points[index2 +
                         2];
            p.
              x +=
              0.001F *
                ng.
                  x;
            p.
              y +=
              0.001F *
                ng.
                  y;
            p.
              z +=
              0.001F *
                ng.
                  z;
            org.sunflow.math.OrthoNormalBasis onb =
              org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                ng);
            u =
              (float)
                (2 *
                   java.lang.Math.
                     PI *
                   randX1);
            s =
              java.lang.Math.
                sqrt(
                  randY1);
            onb.
              transform(
                new org.sunflow.math.Vector3(
                  (float)
                    (java.lang.Math.
                       cos(
                         u) *
                       s),
                  (float)
                    (java.lang.Math.
                       sin(
                         u) *
                       s),
                  (float)
                    java.lang.Math.
                    sqrt(
                      1 -
                        randY1)),
                dir);
            org.sunflow.image.Color.
              mul(
                (float)
                  java.lang.Math.
                    PI *
                  area,
                radiance,
                power);
        }
        public float getPower() { return radiance.copy1().
                                    mul(
                                      (float)
                                        java.lang.Math.
                                          PI *
                                        area).
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
      ("H4sIAAAAAAAAALU6a8zjWHWeb3ZnZmcfMzvLPlj2zfDYNR3n5TjpUljbeTmx" +
       "4ySO7SRtGfxMnPj9imPYFlAptFSA2gW2Eqz6A0pLFxZVoLZCVEsrCghUiQr1" +
       "JRVQVam0FIn9UVqVFnrtfO95bFfQSL6+uT7n3HPOPefc43P97PegGwMfgl3H" +
       "3MxNJ7ykJeGlpYleCjeuFlzq0uhA8gNNJU0pCMZg7LLyyKfP/eCH71+c34FO" +
       "zaA7JNt2Qik0HDsYaYFjxppKQ+cORpumZgUhdJ5eSrGERKFhIrQRhI/T0M2H" +
       "UEPoIr3HAgJYQAALSM4Cgh9AAaRbNTuyyAxDssPAg34JOkFDp1wlYy+EHj5K" +
       "xJV8ydolM8glABTOZP8FIFSOnPjQQ/uyb2W+QuAPwMhTH3rT+T88CZ2bQecM" +
       "m8vYUQATIZhkBt1iaZas+QGuqpo6g263NU3lNN+QTCPN+Z5BFwJjbkth5Gv7" +
       "SsoGI1fz8zkPNHeLksnmR0ro+Pvi6YZmqnv/btRNaQ5kvetA1q2ErWwcCHjW" +
       "AIz5uqRoeyg3rAxbDaEHj2Psy3ixBwAA6mlLCxfO/lQ32BIYgC5s186U7DnC" +
       "hb5hzwHojU4EZgmhe69JNNO1Kykraa5dDqF7jsMNto8A1E25IjKUELrzOFhO" +
       "CazSvcdW6dD6fK//+ve+xe7YOznPqqaYGf9nANIDx5BGmq75mq1oW8RbHqM/" +
       "KN31+XfvQBAAvvMY8Bbmj976whOve+D5L29hXnEVGFZeakp4WfmofNvX7yMf" +
       "rZ/M2DjjOoGRLf4RyXPzH+w+eTxxgefdtU8xe3hp7+Hzo7+Yvu0T2nd3oLMU" +
       "dEpxzMgCdnS74liuYWp+W7M1Xwo1lYJu0myVzJ9T0GnQpw1b246yuh5oIQXd" +
       "YOZDp5z8P1CRDkhkKjoN+oatO3t9VwoXeT9xIQg6DS6oCa7boe0vv4fQGFk4" +
       "loa4BjLwnUz0ANHsUAZqXSBBZOums0YCX0Ecf77/X3F8DTGN+SJExsAz7Lmp" +
       "MVqwoLORS5l1uf9PdJNMnvPrEyeAqu877ugm8JGOY6qaf1l5KiKaL3zq8ld3" +
       "9g1/VxMh9Fow46XdGS9lM17KZ7x0xYzQiRP5RC/LZt6uJ1iNFfBrEPFueZT7" +
       "xe6b3/3ISWBI7voGoMoMFLl24CUPIgGVxzsFmCP0/NPrtwu/XNiBdo5G0Ixb" +
       "MHQ2Qx9kcW8/vl087jlXo3vuXd/5wXMffNI58KEjIXnXta/EzFzzkeN69R1F" +
       "U0GwOyD/2EPSZy9//smLO9ANwN9BjAslYJMgfDxwfI4jLvr4XrjLZLkRCKw7" +
       "viWZ2aO9GHU2XPjO+mAkX/Db8n5mrzdnNnsfuO7cNeL8nj29w83al20NJFu0" +
       "Y1Lk4fTnOPcjf/uX/1LO1b0Xec8d2ss4LXz8kLdnxM7lfn37gQ2MfU0DcP/w" +
       "9OC3PvC9d/18bgAA4pVXm/Bi1pLAy8ESAjW/88ve333rmx/9xs6B0YRgu4tk" +
       "01CSfSGzcejsdYQEs736gB8QLUzgXpnVXORty1EN3ZBkU8us9L/Pvar42X97" +
       "7/mtHZhgZM+MXvfiBA7GX05Ab/vqm/7jgZzMCSXbrQ50dgC2DYF3HFDGfV/a" +
       "ZHwkb/+r+3/7S9JHQDAFASwwUi2PSVCuAyhfNCSX/7G8vXTsWTFrHgwOG/9R" +
       "/zqUVVxW3v+N798qfP9PX8i5PZqWHF5rRnIf35pX1jyUAPJ3H/f0jhQsAFzl" +
       "+f4vnDef/yGgOAMUFbAXB6wPAk1yxDJ2oW88/fdf+PO73vz1k9BOCzprOpLa" +
       "knIng24C1g2iC4hRifvGJ7aLuz4DmvO5qNAVwm+N4p78X5bYPXrt+NLKsooD" +
       "F73nv1hTfsc//ucVSsgjy1U202P4M+TZD99LvuG7Of6Bi2fYDyRXBl+QgR3g" +
       "lj5h/fvOI6e+uAOdnkHnld30TpDMKHOcGUhpgr2cD6SAR54fTU+2e/Hj+yHs" +
       "vuPh5dC0x4PLQdAH/Qw66589Fk9uybT8CnBd2HW1C8fjyQko77wxR3k4by9m" +
       "zWv23Pe06xsx2Lt3/ffH4HcCXD/KroxYNrDdaS+Qu9v9Q/v7vQv2ozO+pBqZ" +
       "BDmBO0Po7sMblGGBrCpzUcffhrasLWXNE9sZ0Wsa0s9eKeYdu2LecQ0xe9cQ" +
       "M+uSue4aIXQW5OycZLkm8ILrmuTANywQR+Pd/Ax58sK3Vh/+zie3uddx+zsG" +
       "rL37qV//8aX3PrVzKON95RVJ52GcbdabM3lrzmnm0Q9fb5Yco/XPzz35ud97" +
       "8l1bri4czd+aQNRP/vX/fO3S09/+ylVSiZMgNz+2KvSLrsqWtxPAdG4sXcIu" +
       "FbL/s6vr/WTWfS3YIoL8HQVg6IYtmXsLcffSVC7uGZUA3lmAf19cmtieIZ3P" +
       "Q1PmSZe2if4xXhv/Z16BJm87IEY74J3hPf/0/q+975XfAlrpQjfGme8C9R2a" +
       "sR9lr1G/+uwH7r/5qW+/J9/xgCFxT7zTeVtGVbuexFnzpqy5vCfqvZmonBP5" +
       "ikZLQcjkm5Sm7ks7OCTPOARbnfMTSBve9tZOJaDwvR8tzBrThBcSEWaQmEZ8" +
       "AkHI6ppmQhKVlNQdzfygMg9KVT5Ig15zwhtVoTstyzDGDAZyX6sgZSxKWXnO" +
       "04UpblG+xE9DlpN6C344DyRuLEijbihxvbArYWJILgWPMr1uV5FFo0UPIl3v" +
       "x114JvKUYWEphoVJOfXtst2JWbVWrWuw43kywRRW02LLopeEL5DxyKM5b9aq" +
       "pCXQWg2mMQ0GxaaFiAPMnJbLBG+bza4lrbwEFmXaYR3RU8SISltMwShY0rhX" +
       "6puMNKJKLmeg3rJp9gvydMEI1Q0c9ppeENDV+njRmnslrs21+k2LtZpBsC5Z" +
       "Cj1tjzSiNeVQI+iqSICoBYGypbVcWWMoTajoEg5o3pPUiEvabYPBXKHp2u12" +
       "r+1UnFYU9yyLmzlSvOQEwaZmrunMyh4XBs32hvLJQjpUJHkxh6MO75QVgixx" +
       "bmQxXkkNXVeKlmG3smgMKw5W8MZChG0IlGsZ7SJtdduswaKcwqyl0dxKRdvn" +
       "mY5XrVoip+vOhCiJq+LI3dDz+WgxqyxGBteThJAR2vDMJYapmKrsuO+UUGwi" +
       "WIuZw9LLTa3XsetLDe4XNoUl0WwvRiHeVZbrDTUdN6gm4U3cdkMMMRtkd45K" +
       "rdaSPOCJ/kjoCeQksq1NwfT4VYDXI51ZB+xsnni15UoVa014bqHWyJKqlqDE" +
       "61G5h5jiiO/xq2rDbxQEwYlwrDNUmhIxmlldY7xm0cjUm+NRxUmZenmwUrW0" +
       "1iBwXCqKUuByml11lVWJxPt4MOE5PmyPKnixznLDlreYr1lpSXNii/JKfWOE" +
       "jpo+N9VHVKdY5HW85/XU9XDD0JTaqM3MNYcVWV/uqjo86Zcq1ajRKIHcgsN7" +
       "a3RpCIKQIPSYLMKzeamwHhZ7CkdMe4ncXq6MdLJMhl18SHWxiEqmBbqcRiXX" +
       "N2VNicmug47EeSmZzDhrWKaTUn88QRE5gDmYMZN2KLVk0qrCozKjzYQOxhV1" +
       "Eae42WqmUZ0CC2xKKSNwSowKGFev9FauU+c3vidxU0bvK2a1ZBK8tETxvuj2" +
       "lowM7ILzkklcqacoR+glyjGbSWRYo4Bc+hTMe52qz8Nibc0Pu00HOKPTqzvk" +
       "uDzpbzixEpeC4dBw545eWIf9ZkLUESYFax6Zbnsp8Up/zPMT3m+08TGOsdba" +
       "nLW56rIq9ucbVCaibswiM7W0mgpC1zUXlSbZbXBVr2AXPZekqs0CHTGlzbBs" +
       "IF5hifPklPVQZEVMKF4WqyVPsYLBpqKkUtmKBw2s5tn4XC1j0yaVwI02Pygt" +
       "ybbCKCO7QUwYDqeIQdgs2C076MJpm2SGRbwdqyunM5DDReL0GKbDrKa9tTqm" +
       "LKvTrQFtMm19CCcLeDJKEYUjN5tQI116Q7YtcdaVRgKznpTFKbdqzrVgyhbp" +
       "ueQmtRWOSRVm3rPpYpuXiDXumUMz6KmTaq8hJHa35dLAqBGKG7XJqtqZepGN" +
       "rhHWn5WrsB6Tbm/eQkbJZu7jvRI3oMyxTcn2uAOnLbQhBzFCE1WOxVRODwbC" +
       "amUi6x7bancafs2HmUJKk/XQrFXYGDOwFRrWyQDfrDYkgw86EtLpV4Dv+Is6" +
       "6XAp79j9Rj/sjQ0X3fSl4rJXZDSlqVWXY3mNNNSN0Qr6Ab1Mx5i8XMrIurqu" +
       "ESU3Jtx6g9Vby3VDb/u4NvDDCZKawICUSAR+x/gbHB0VoyHeW4yFtNd2N+WO" +
       "PHSJsUMvSv1BLFeKelmOmBqZKF2jWZ4ZpfUAJ1oBNQNML4RyHHdiFO6GRFKr" +
       "zWbsgmngniq30G6HVIqrzbwbbIql4pzB3TVlOH21IIcdfICKTSoQeMPpFO3K" +
       "rNWrYTAmkssazggjuxuFg9TC3TQpiXGXqtYjBCP7xtqmrDauWqm5wn1B7jC2" +
       "6hpWv5J6G60OT+uIMHF7CoGsWyktiqSymJtlXGrKdbfnx3U1psudOlzUZGI2" +
       "kyO9nLiaD4Kd2MDKqB6XxXqtrlaqcVEw6SjWqpMliS0m4TxIHbpiTdC1aNRn" +
       "PYnEUCRtLxJfAOBEZUFQZq9VCxrSbE4VZ8uSPi0SghAjdpdL+6W4hbbnUUgt" +
       "JZeugQjWSKkNIa9loMB5XwxrmlOelumWJxEe6nkjHJ5SRH/QqFXMeGKl02kf" +
       "kZv1kgrLdbE7RTXUTEwyWaRsp8Ct6lXc82uaum5g6KYcIqrW9Ue1WXNk1rl2" +
       "UKzp9ACOeauP6XEjXrtMarcDjp4sKkmtZ5c9LxT1ooamOj4ar7BgLc4MBZ9N" +
       "9TLmDlx9PcV6Zo1dec6iYCzlulYXOaU4t3CUSEXdNKyesxqX9VgX5V5LqtYc" +
       "HC2u65Zv2XWena1G2nzZ12Vf1xbCohhUCBS1WIyUEW0uUHQ6Top2VGGLnMxi" +
       "zJwXhSnnrkceBfZoQx2R82VRmvICsliQa9VixvTYlkWh3+WkatOq9hR8XCrU" +
       "jaDQYQrmhBMmQU8Qo0Sot7ihLxDOyCmteErl7GbKz/u2tW52l85wqLkYhwOL" +
       "HpIzazhyJwWnIQH1E1pZLSzKmzmDOHZF8VIjxakosgcLH97UpZLqI22Fp0qt" +
       "tUVEcDExcWLI+86Y77VkuKmvWxXaIhrVypQoDIHHJEuhOghhEPWG5Q5nDSi3" +
       "2cdUhMUovqhpzbVfwWuLzhivKUjc7ThTtkOoJM3UyuTcYltWQVOkyrBaamya" +
       "XhHkJdxGmdZL+hhG4ApQVr0SCv1J4Ndb2NRlVRhRkclwpSI61gLuZFglVuVG" +
       "9AiPg6qMhgXZURv1ScmvFKSOFdjCcBpzo6qzsTDGH8b+vFzoecGY2RRFBZ1t" +
       "hitYTCdKm1wQZo3S4E5S22yGsG0LNVWwNQEx9a7eFpAICzCWCJ32Eq+NuyhF" +
       "Cgtk3iiiKF+NJy2sU6+X4daiVkgZf25PvQU7xBaa3bY5R3Ul1/fsHo9SnZJu" +
       "o5o6aWwK4aiDIEYjjcaSmGUOUhp2Q36NuJVBDDKnsK1jJkL3Yh8uNTyUxWQQ" +
       "6mwNTgsuDESPBuVJMlcmG6fQgllCwSc26dTTLnD0kpt4w2BacjWkaIHsUWE5" +
       "ebCQ5Ek5VsWBQqE2LKytSZ0UprEoDFZNTFRjtlCU54P+umC2muNCucTKlCTL" +
       "TbIWVft1vWViXcOKYqfRZ/vcos0xLMsIbscfjnABkSd6YTrrkVPfC/lCvCGW" +
       "jfpY5LR116qKA1KKFbDMJbixbIsIGq97mhpGQ0zWYKIqTLt1uDEy0XQ6Ww2b" +
       "oVJj6epkXFYrzTDQEk3yG70a12rJjBWJy2jRLS87stNfGP1KwmqWiE2tEK6o" +
       "EpvJ4nZi0ij7G8PD9fa6GJIbT68XjXGbrdj9fmK4Y6FXKknoXCGXXomN5LAW" +
       "dwWHkUy+Z2l9mIt5b9OylQ3SsUipNmvZaLnZNepzpSKNtFUktnEC7/f4VOHR" +
       "esHv9FSkogvBCmSGo7VRGXSWxVVLrdFGx+zDiLlo1JVkKdYxg+RmSLE473hc" +
       "b8QLQnmupZ6QONaYWygheCOhnYBHREZ3GmaZqyR8rQEStoZJIAJL8Y1akSA0" +
       "uNwexvOURTfEQmzSqd31HXwxdIZTXTNWk4HJrn1xGo16FAjQQirPN4HdJKb6" +
       "WMamtjaSy8Kwa/E2OrZrYbU9aU0Gm40+8GeLSm0wGcRtJmK8oSCaBu5N+KHJ" +
       "r2RzsrEmfYITV6g4m/hmcaNrltwDb9z9AjcUMXqJdrpKR3X6chued3wZTeNQ" +
       "nA3gKqKUUyGa1XSvs25IARF2STwp+L2w1t0I/XF3GFgbutWaIXx7siYrRtTl" +
       "YdYvVjV4EMYwb4lG201ky6yyTQWu27JuzZqDIkL6laHj2CVDBGTjTl0p8WWb" +
       "r3c5jq+3Wt3hCEity/pggvJyWpl63DKgnCgmq00eqUz7qu61uRI79fCpPxHa" +
       "g0FtE/RLcNdipoP5zE46E46j3MJcnXbCZMPWibCNuWSSwOTIMjzNoDv1jlY3" +
       "FNhEEm4W4PRQBm+bP5e9hnov7fX49rwSsH/+B96KswfSS3gD3j56OGtetV83" +
       "yn+noGNnRocr0QflyRNXLV/l5yvcQspqpYEP3X+tY7+8FPPRdzz1jMp+rLiz" +
       "W/blQ+im0HF/xtRizTw01Q2A0mPXLjsx+annQTnyS+/413vHb1i8+SUcsjx4" +
       "jM/jJH+fefYr7Vcrv7kDndwvTl5xHnsU6fGjJcmzvhZGvj0+Upi8f1/zeYHu" +
       "5eC6d1fz9x6v2B2s7dXLda/d2saxqvpODrCzt1YPXLFWuR60UPOzsv0e2F2H" +
       "wbjtHR9Q+Qy/dp26/fuy5ldC6FTkqlKoXa1Sc1p2HFOT7AMrfeeL1WkOz5IP" +
       "vP3o+VARXA/tqu2hn6ra9p3qN3KoD19H9Gey5kNhdiJrhFctUcWOoR5I/fRP" +
       "IHXuldmp2I92pf7RT0fqE0cd+/6rOrZhz7MvKLScwh9cRyPPZc3vhtDNcy0c" +
       "7Za8s6H2gRI+/pMu/RsAu6e2uNv7T3Xpn83ZzaH+5DqCfi5rPhNCtwaKFAJP" +
       "GiyccHuW+DsHon72pYiagAh/xfF0dtZ2zxUfu2w/0FA+9cy5M3c/w/9NfkK7" +
       "/xHFTTR0Ro9M8/DRyKH+KdfXdCOX4abtQYmb3/7sWAQ4ODQPoRvze87xF7bQ" +
       "Xwyh88ehgblnt8NgXwaWcAgMRILd3mGgr4bQSQCUdb/m7tnha67gxd2r6h85" +
       "xE9OHNozdu0l1/2FF9P9PsrhY91sn8k/QdrbE6LtR0iXleee6fbf8kL1Y9tj" +
       "ZcWU0jSjcoaGTm9PuPf3lYevSW2P1qnOoz+87dM3vWpvD7xty/CB7R7i7cGr" +
       "n+E2LTfMT13TP777M6//+DPfzIvv/wuc1vz1GyYAAA==");
}
