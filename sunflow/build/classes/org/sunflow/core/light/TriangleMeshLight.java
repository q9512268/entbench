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
          1447328137000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16e+zr1n0f78/2vdeO43vtJLbrxI6T3LR1lPwokaIec+tW" +
           "okRJfIkSRUpi197wJZISX+JLJFOvbYAtQVskQeukaZH4jzZFH0iTolvRAVs2" +
           "F0OXFk0DJC26F9akRYq264IlGJYtzbbskPq97yNxHUwAjw4Pv+ec7+t8zvc8" +
           "Pv5l6L4wgCq+Z2eG7UWHehodrm3sMMp8PTwkaYyTg1DXcFsOwxkou6m++Tev" +
           "fe0bHzCvH0CXJeg1sut6kRxZnhtO9dCzE12joWunpX1bd8IIuk6v5USG48iy" +
           "YdoKo2dp6FVnqkbQDfqYBRiwAAMW4JIFuHNKBSq9WndjBy9qyG4UbqF/BF2i" +
           "ocu+WrAXQW8634gvB7Jz1AxXSgBauFq8i0CosnIaQE+fyL6X+RaBP1iBX/i5" +
           "H7n+W/dA1yTomuXyBTsqYCICnUjQg47uKHoQdjRN1yToYVfXNV4PLNm28pJv" +
           "CXoktAxXjuJAP1FSURj7elD2eaq5B9VCtiBWIy84EW9l6bZ2/HbfypYNIOuj" +
           "p7LuJSSKciDgAxZgLFjJqn5c5d6N5WoR9MaLNU5kvEEBAlD1iqNHpnfS1b2u" +
           "DAqgR/a2s2XXgPkosFwDkN7nxaCXCHrijo0WuvZldSMb+s0IevwiHbf/BKju" +
           "LxVRVImg110kK1sCVnrigpXO2OfL7Pe9713u0D0oedZ01S74vwoqPXWh0lRf" +
           "6YHuqvq+4oNvoz8kP/qp9x5AECB+3QXiPc3v/OhXf/DtT730+3ua19+GZqys" +
           "dTW6qX5Meehzb8Cfad9TsHHV90KrMP45yUv3546+PJv6YOQ9etJi8fHw+ONL" +
           "03+7/PFf1//2AHpgBF1WPTt2gB89rHqOb9l6MNBdPZAjXRtB9+uuhpffR9AV" +
           "kKctV9+XjlerUI9G0L12WXTZK9+BilagiUJFV0Declfecd6XI7PMpz4EQQ+C" +
           "B2qA5+3Q/lf+R5AKm56jw7Iqu5brwVzgFfIXBnU1GY70EOQ18NX34DB2V7a3" +
           "g8NAhb3AOHlXvUCHbcswI3gGBopr2DqjhyZdlBwWzub//+kmLaS9vrt0CRji" +
           "DRdhwAYjaOjZmh7cVF+Iu/2vfuLmHx6cDIsjPUVQA/R4eNTjYdHjYdnj4S09" +
           "3jguKd+gS5fKbl9b8LG3PbDcBmAAQMcHn+F/mHzne998D3A6f3cvUHtBCt8Z" +
           "pPFT1BiV2KgC14Ve+vDuJ8Qfqx5AB+fRtuAdFD1QVOcKjDzBwhsXR9nt2r32" +
           "nr/+2ic/9Lx3Ot7OwfcRDNxasxjGb76o5cBTdQ0A42nzb3ta/u2bn3r+xgF0" +
           "L8AGgIeRDPwXQM1TF/s4N5yfPYbGQpb7gMArL3Bku/h0jGcPRGbg7U5LSvM/" +
           "VOYfBjq+Wvj368BTO3L48r/4+hq/SF+7d5fCaBekKKH3+3n/o//+s3+Dluo+" +
           "RulrZ+Y9Xo+ePYMMRWPXSgx4+NQHZoGuA7r//GHuZz/45ff8UOkAgOItt+vw" +
           "RpHiABGACYGa//Hvb//DF/7sY39ycOI0UHpetqt3kQ108t2nbABAscFoK5zl" +
           "huA6nmatLFkpXDeM/ve1t9Z++7++7/re/DYoOfaet3/rBk7Lv6sL/fgf/sj/" +
           "fKps5pJaTGinqjol26Pka05b7gSBnBV8pD/x+Sd//tPyRwHeAowLrVwvYevS" +
           "yXh55i5BTWA5wAjJ0UQAP//IFzYf+evf2IP8xVnjArH+3hd+8puH73vh4MzU" +
           "+pZbZrezdfbTa+k9r95b5Jvgdwk8/7d4CksUBXt4fQQ/wvinT0De91Mgzpvu" +
           "xlbZBfFXn3z+X/zq8+/Zi/HI+ZmlDwKn3/jT//OZww9/8Q9uA2P3gKih5PCw" +
           "5PCZMn1HwdKRKxXv/6BI3hiexYnzqj0TrN1UP/AnX3m1+JV/9dWyt/PR3tlh" +
           "wcj+XjcPFcnThaiPXQTFoRyagK7+EvsPr9svfQO0KIEWVRDihOMAIHR6bhAd" +
           "Ud935T/+7r959J2fuwc6IKAHbE/WCLnEI+h+AAQAlgG4p/4P/OB+QOyK0XG9" +
           "FBW6Rfj9QHq8fLt8d9ciimDtFM0e/7uxrbz7L/7XLUooQfg23nahvgR//CNP" +
           "4M/9bVn/FA2L2k+lt85aILA9rYv8uvM/Dt58+fcOoCsSdF09ippF2Y4LjJFA" +
           "pBgeh9Igsj73/XzUtw9xnj1B+zdcdPcz3V7E4VM3A/mCusg/cAF6S71/F3je" +
           "cQRP77gIvZegMjMsq7ypTG8Uyffsh3sEXfEDKwGjpWwZjUBfgYUWeWSP2kX6" +
           "bJGM9sZ87o6Gx8+z9XrwHB6xdXgHtrg7sFVk6ROO5ECXSxK4LNnzgUWFvjw5" +
           "usDm5O/BJnzEJnwHNqVvh80Dd2+714HQ9Wxs44Do8FDUixGEXuD1h74lr3uB" +
           "LwE73YccNg+rxbt6e27uicCCLlZsC8wJl8NyrVWoyHJl+5jFx9a2euMYJ0Ww" +
           "9gID6sbabh7zfb3EgsJ1D/cLlgv8ot82v2CsP3TaGO2Btc9PfekDn3n/W74A" +
           "BiQJ3ZcUgwWMwzM9snGxHPwnH//gk6964Ys/Vc7GQMXcN/J//b1Fq94dpC6y" +
           "JZ9lCG4di/pEISrvxYGq03IYMeVMqmsn0l5wpXtt7xVIG11rDevhqHP8o2uS" +
           "jnXU6dRNUCUJuRVVn6IkmY3H/AJvCPh8sCC7HaqXUdgI01SEiaN42qt5dt6Q" +
           "QBXSdzRHzatYIuNmNpn3t7vM8JYTqr/Gphk5MgVNmlqIKOIp3THnVctTDc/r" +
           "CCJPjfqmIAjcsBk7GjJM4lFfjSMnakrNbaWZVFZJpRmgFSLabBxkqm2VfNxt" +
           "oc60tvJhRojm2bwZDTxlXukmztDOzaBhV6IVik4Jm+EHGT2dyoka1AZym4o4" +
           "vm3iUlDxEL8Z4M0+wvgLYpA5IyREpVkA6vYH9qypNNSt7FBZErNsf4wH2pTa" +
           "mAoVy/Mx1nMDNVUMaVjnx/3NaGaSwa7FavyMJBg1Tddohqyb+ZCtU8J43koc" +
           "jHOwTqPhZEq2YAWe1xbOYjKnF4OJjLjmnEEtlViYLROVJa9OsZkaUSLbS3l2" +
           "3By2dwhipQJDots4HBA6JzmSmciKL403lpxoGDpQk2WsWmOfl2iSc8jx2Odi" +
           "33CXbGegxBHZEJleW6QUV82RQX+kN6mWyHSnriURxK4vsTI7VsNNOmrtdkEN" +
           "JQlt1pF8IpVtW6Tm1nA9nC6dnlZrruBxVa6up33Hnrb7rD01Opuxs8u6E9uO" +
           "TcJFEJeX/aU2snbNwdDh5/xarK0RzhfthG34M3e3yuJ50MmVnKSbY9fH490o" +
           "tG3MnEZzQckYFV+7tQbPTAPGaFRTTrRsk4blnjGqbpmBZFOcpTENEfEbW3cs" +
           "biauPRDCFSuPRrivzdzBtI5aYiA0zEmTp+xa30M9hJlYsY/oXY0cdXuOmTLb" +
           "leVtzWCTeU1ZWrJeVR80CDLDKUM2cXKHW1q0nFFp3zb9WWhSXBK3It2lOvnK" +
           "G8ATz5r0OBmYKePaG4ed6E7AS5K0Jkad5ibFXXrjrby8v0Knu023HiwnoTzD" +
           "0HjFLQKkBWuz9caR4oG07W6mNaauclRVIvxZCw3mC5/oKeRUSbeIFS45Hm9Y" +
           "9HjOaF2RmZCWlE7FlBnXx24UtJCBFuse3h7wc3bF886A8CpdtCl4poEJ7fky" +
           "kpp+TlGqv4pGnTY34+ZUa92edfUaLTr6TssG0zBNolHAy42lp9R7fEDtupTn" +
           "baS6CM+ZutJQ7FGFatdJEic3eK+2YXN0ZHEVSulnQirH06Vh+YKICuuNMmLs" +
           "bovdbjXfWDMKGjE72fTIcaPtsgMmXIoRtQvwLNUq1FIZ9H1HGurzEd0dbfWa" +
           "CNbuVX2GdNmhlHMw1w4FgQ38JdYfDQakPugsqxbVYU1fcmpBN2PYSrsZp70d" +
           "om8shFiOh4El9RbhYKgh6/F4rCrEOhnMhrNAG8I4NbVYE+kmI1OZVObIbrPs" +
           "4J2WpLsGlksx2m5PO1XMXUdzHPEH1RGGM/o6M1SWaM85N0+jSoyse2lrrltk" +
           "x18yBk1mTEjiaBXrSGNJ4o2wJ3UFaqbXKySYjzoo1dp0x8NpU4lhgbZ3hg7j" +
           "OIdX6/iKoX1qOXPqpqzV9U4cIc0ZLVfgCoybuMrQrWpvrpKsBlTbX9cbO1Xl" +
           "8F6W0EQ0mu3q7bHWl0ha6PC7Hu72e3JHHaMmNxl51ViwmNDnezvS7eHRkJ2m" +
           "2VLhp+taMHBYdZ1QGJEwrU61La0B2nTDFkUy8ID1cpZVBhpJV8UVLmzMPlfZ" +
           "TlacvoCbrXYj7scRuqmOZ3TDGzMavOngUy0gtN6sHrg64YWpxyVsXZstmug6" +
           "sB0Ub9a7lqpsCrSKOnwH79cpWUGxVm0XJgk6qyLz9VSsbkyKiNqEZhubXdhm" +
           "jd6Q7ZiZRirjBhgt0/V8XTUHzIBMYA9xSctk4THbCXO53V1XwnbWqrQNVoMn" +
           "Mx1rqHlthYSLrDoRcmqsb9e7DFebs0RaLObmUpvmdUrHKvqqrfm6BXe4Ph4E" +
           "OmZ2rOoaU0dC1gy68Mhgd7LiTLi46ap8zgSihmgVSd9UHXuSUDOyW1VWqpsE" +
           "dK0yrXF4lMyXubnmWl67NtVDuYGEeXMg+6sRbPZbfdeFTaMaDHuGawSz2piw" +
           "7eUMHzvzSW9s12S/Uh/hJC7JizaG5ZWQ440hLs+kfs4tVzBHDVsTZujr4oZW" +
           "qLrfzXc5NqxZ3cnQacXTuLoQNbOf6y6MtpgJ18Qq9emCFgdhFjYa3d2Kw7FV" +
           "Xpc4OKf6iGgkfanWCB2xM+fGOOsPcHfGBkIVjrdIzTd1MOfCAoaKNRFr1vxV" +
           "NZhYAISrWitNyO2QHZrErsp2KrYx0MyORrV4heHpvNtxt1wXpXNZi8xWajSU" +
           "TFSTXuagXLKu1Rrt0M13fmqAoTbMeo0tb9fQJc32o1ktGHbnyKYXCTLebLO8" +
           "k+dS4OeNDrHUjOlE3M6GSccwpxLO4OQkB9OyrcJw6DJNARY3AyORtQnjxA27" +
           "49tkp9qxsP5iFBiLvF/TaLlr9tyBMff8EV+f9WUC47kWKmCbejJCOa491ypY" +
           "K6iv6d1mswEWEqtZsltNdJ5sWtZYMuEdxy24Bl1B6jCLLzW/6i3NscKu3HZn" +
           "0HbRRtSmCTzlF5I7wpnqijczWKo2OWe9IlY47NbHOWFqFN+lqYxFV3anaaOe" +
           "iaRuVSLRadcX/d26KspbbDokzUpnuaQTl+wZSFeVe6QCnLgZU+OFqI970zZS" +
           "l3NXg9cy6nbiZrVPImmjM9stxlXXqLs4bqUAj6xNign0lA5FJ16mvVnsM3xd" +
           "XDO7yLa3y62FkkZGkIv6Kto6Ap4uljDrV4RskEUN1NJ7CVMhyAoW9htwp4Iq" +
           "5DiXer6Qzh2jxgheNGV0gu9W3F1jF6wqNUHV5s1J313jbo4Qm0FeTbBOVF/g" +
           "iy2OK6I9R/iAwSw94IW50hup5orUV4bbHa4ys0OJ3mKZ10QzqeHj3qTPbaqu" +
           "Z4+phOntVIteqzkOpmZBZIEyN/RSMOEQSTTWE3Rd8RKPHVYNbgimeU0kmj1e" +
           "zbAu10GsSj/raD2fqGsBXR8pAF/INj5JpP6W1sTMToQRloC4c+wJ6JhGk/XM" +
           "VmpeGnP1NrXqE6MWh/NoxQP+NWvg2DyZqou20eGZjRsTdYoHgeeuOvdyl54h" +
           "S3wdU20/IzA/5PI0GLpOgs9iG5v1nI1FulhfqImTTScN1C3uLSYKwUcEGKk+" +
           "jfZFb9YbOEsBS7O50uBVxWbbgYAiOCLGAcnxyTJgOIRpKLKKo+qO6KJL05RH" +
           "+RaThx28wSRgUUZ0go043kn9dr1GRAI69JaLndaLto0GZnWRNKYjse7Lttge" +
           "DjZZZKAh7dCbhi2l65Wt1pmqhPj8sgGwU4crGUmh9bSn6/Ck0eR03dxpg9ZC" +
           "UEaBvBUydGPOayJhoORwssFr3o6n2ymT7oRV2gi9ZpcI18awbplRd7DrLZIl" +
           "VbdjByGNmEVyVFutmHVj18wNuccPZ8NaC9Zl3h4HMmJWrOVyMEVsuaawdRAK" +
           "96N1xfO22xlC5obfJVoZOgjVhFjE7WhSxZp4koDZUzP6HNXChKCNwMY2YHvC" +
           "RvFRw6tgar/L0oM6bgRDKm3Js0UMAjpRojVhp9Td/jqOWx6/nTmyJK4HA0xa" +
           "tvs7EcmzYT4fq+yoGwkgkrRRdekDiHW55kgKeyOCcF1O0BdNDIEHvM8GPC1R" +
           "tcVgES6cqdDcCnN/Pessg1Z9VmmvNvRi0gt7RIrHWwVDhu2GudvUcj3jk2qy" +
           "IRQ4q5IDp2Lbw8CN9AXVEYPKwCX7dpvctn3YG+PNvObMrWyNewM3G4x7lNLU" +
           "e5QorDO3I27RUSWN+YpXAfzq/khcp1m1jdg+R3JramyisxSzVg0qU2uTEZ80" +
           "MSs2/ICoTsccjxLYAvf7K0rQW/OFHrljyZ+tiVUTGfhSXo9aXhTDdAY3fBPT" +
           "++tBvtLUoVJjFk7bR8xqnmKqtKD4GuMoqUP70XZtyTEmh5MazWFrhGcYPkKw" +
           "aDNJm8EaXWBoq9fnJs4wSFwTb3abTNNaaAY9bbRaFQVEc/LKhOktO8UNt9rU" +
           "xaG1oyWzvq3PUbLqhwI1SIimmC+qQTKsZSAAHNuEuhi5rViywQqpsZQXJjxh" +
           "m0TkTHVyUm2TBCmQVG6s1+liPY4VRKEUK9rRU0ZhVmSjJVQiWQfLGg4m+raf" +
           "2j2nhoyixQ5LqzaLcbbYWLCIt7QB0o6tes6KMw/boDMu21YRC+0SgcCs1rLa" +
           "7GlsGyHjoI035DkVTmOPQJO6Iudq2K0vdbBS/v5iCf2ul7e0f7jcxTg5gwUr" +
           "+uLD5mWs3tO77uec7A+Ve5ivgi6c5J3d/D/d3bx0vIfyhlvOtcpzq/1WRLFJ" +
           "++SdTmTLveiPvfuFF7XxL9cOjraOGxF0+eig/PxW6tvuvJXKlKfRp/uZn373" +
           "f3li9pz5zpdxoPXGC0xebPLXmI//weC71Z85gO452d285Zz8fKVnz+9pPhDo" +
           "URy4s3M7m0+e6P6xQtVPgue5I90/d3Fv7tTetzeksfeXC9vyByXBwbG1nrrF" +
           "WqUe9EgPirOSY7JHz5Lx+/8ONyp7eOEuG/+/UCTvByaMfU2O9NvtPF1RPM/W" +
           "ZffUcz/wrfadzvZSFvz0idpeUxQ+DZ7ukdq63xm1nRXqV+7y7deK5Bcj6NWG" +
           "HrGxw8uOb+/FRk4F/KVXIOBTRWFxuk4cCUi8DAEPygF+BkwuSHLp/FB+7S3O" +
           "MZWzsuI/vYsKfqdIPhFBj5f3SUJdjY4PsCndDe39GcRHTrXxyVegjWtFIQIe" +
           "90gb7nfG3BcU8eQtiuDBEtxyjeJKz/7k4HfvopHfK5J/GUEPAKc48ojb7sEm" +
           "nqWd6uVTr1Qvz4PnS0d6+dJ3Ri9XSoIrt+P+subFyv5+yB+fJscafOyWEwHO" +
           "A/5RHgjcvC2R5ciGXpwHe0HJyufvouD/VCR/FEH3AwVzphftD8k/farLz74C" +
           "XRYn+yUSf/1Il1//zkPKX97l218VyRcj6GohnLfbjx/hVLY/fzmypQCazt0n" +
           "Odb9936711HA1Pv4LTff9re11E+8eO3qYy8K/668gnFyo+p+Grq6im377IHe" +
           "mfxlP9BXezy6f3+855d/X7kw7ZwyFUH32Se8/7c99X+PoOsXqcGQKv7Okn0t" +
           "gl51hgxMP0e5s0Rfj6B7AFGR/Tv/NmdD+2PN9NKZiOTIa0qDPPKtDHJS5ewF" +
           "jSKKKS8eHkcc8f7q4U31ky+S7Lu+2vjl/QUR1ZbzvGjlKg1d2d9VOYla3nTH" +
           "1o7bujx85hsP/eb9bz0Orx7aM3zqwWd4e+Ptr2X0HT8qL1Lk//yxf/Z9v/Li" +
           "n5VHVf8P/gXLjxEqAAA=");
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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06eezjWHme3+wcO3vM7Cx7sOzNALsbOk5iO3G6FHAux0kc" +
       "27FztmXw8Zw48RVfcUy3BVQKLRWgdoGtBKv+AaWlC4sqUFsh2qUVBQSqRIV6" +
       "SQVUVSotRWL/KK26LfTZ+d0zs1sEaiQ/v7z3ve999/vee37mu8gp30NyrmNu" +
       "ZqYTXAZxcHlhEpeDjQv8y+0uwcueD7SaKfu+BNuuqA9/6vz3X3jf/MIOcnqK" +
       "3C7bthPIgeHYfh/4jhkBrYucP2htmMDyA+RCdyFHMhoGhol2DT94vIvcdGho" +
       "gFzq7pGAQhJQSAKakYBSB1Bw0C3ADq1aOkK2A3+F/CJyooucdtWUvAB56CgS" +
       "V/ZkaxcNn3EAMZxN/w8hU9ng2EMe3Od9y/NVDL8/hz75wTdd+IOTyPkpct6w" +
       "xZQcFRIRwEmmyM0WsBTg+ZSmAW2K3GYDoInAM2TTSDK6p8hF35jZchB6YF9I" +
       "aWPoAi+b80ByN6spb16oBo63z55uAFPb+3dKN+UZ5PXOA163HDbTdsjgOQMS" +
       "5umyCvaG3LA0bC1AHjg+Yp/HSx0IAIeesUAwd/anusGWYQNycas7U7ZnqBh4" +
       "hj2DoKecEM4SIPdcF2kqa1dWl/IMXAmQu4/D8dsuCHVjJoh0SIDccRwswwS1" +
       "dM8xLR3Sz3d7r3vPW+yWvZPRrAHVTOk/Cwfdf2xQH+jAA7YKtgNvfqz7AfnO" +
       "z71rB0Eg8B3HgLcwf/gLz7/xtfc/96UtzCuuAcMpC6AGV9SPKLd+7d7ao5WT" +
       "KRlnXcc3UuUf4Twzf3635/HYhZ535z7GtPPyXudz/b+YvPXj4Ds7yDkGOa06" +
       "ZmhBO7pNdSzXMIFHAxt4cgA0BrkR2Fot62eQM7DeNWywbeV03QcBg9xgZk2n" +
       "new/FJEOUaQiOgPrhq07e3VXDuZZPXYRBDkDH6QBn9uQ7S97B4iKzh0LoLIq" +
       "24btoLznpPynCrU1GQ2AD+sa7HUd1A9t3XTWqO+pqOPN9v+rjgdQ05jNA1SC" +
       "jmLPTMACf95NWy6nxub+/0wTp9xeWJ84ARVx7/EwYEIPajmmBrwr6pNhtfH8" +
       "J698ZWffLXblFCCPwBkv7854OZ3xcjbj5atmRE6cyCZ6WTrzVttQV0vo9TAe" +
       "3vyo+PPtN7/r4ZPQzNz1DVDQKSh6/bBcO4gTTBYNVWisyHNPrd82/KX8DrJz" +
       "NL6m1MKmc+lwPo2K+9Hv0nG/uhbe8+/89vef/cATzoGHHQnYu45/9cjUcR8+" +
       "LlfPUYEGQ+EB+scelD9z5XNPXNpBboDRAEbAQIYWC4PL/cfnOOLAj+8Fw5SX" +
       "U5Bh3fEs2Uy79iLYuWDuOeuDlkzht2b11JpvSi36XvjcsWvi2Tvtvd1Ny5dt" +
       "DSRV2jEusmD7M6L74b/9y3/BMnHvxeXzh1Y6EQSPH4oFKbLzmdffdmADkgcA" +
       "hPuHp/jffP933/mzmQFAiFdea8JLaVmDMQCqEIr5HV9a/d03v/GRr+8cGE0A" +
       "F8NQMQ013mcybUfOvQiTcLZXH9ADY4kJHS21mksD23I0QzdkxQSplf73+VcV" +
       "PvNv77mwtQMTtuyZ0WtfGsFB+8uryFu/8qb/uD9Dc0JN17IDmR2AbQPk7QeY" +
       "Kc+TNykd8dv+6r7f+qL8YRhqYXjzjQRkEQvJZIBkSkMz/h/LysvH+gpp8YB/" +
       "2PiP+tehnOOK+r6vf++W4ff+5PmM2qNJy2Fds7L7+Na80uLBGKK/67int2R/" +
       "DuHw53o/d8F87gWIcQoxqnCl9jkPBpr4iGXsQp868/ef//M73/y1k8hOEzln" +
       "OrLWlDMnQ26E1g2jC4xRsfuGN26Vuz4LiwsZq8hVzG+N4u7sX5r2PXr9+NJM" +
       "c44DF737vzhTefs//udVQsgiyzWW2mPjp+gzH7qn9vrvZOMPXDwdfX98dfCF" +
       "+dnB2OLHrX/fefj0F3aQM1Pkgrqb/A1lM0wdZwoTHn8vI4QJ4pH+o8nLdqV+" +
       "fD+E3Xs8vBya9nhwOQj6sJ5Cp/Vzx+LJzamUXwGfi7uudvF4PDmBZJU3ZEMe" +
       "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" +
       "GwUmAAA=");
}
