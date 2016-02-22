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
          1456093649000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "so6qZD0qAAA=");
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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
