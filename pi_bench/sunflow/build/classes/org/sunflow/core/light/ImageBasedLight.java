package org.sunflow.core.light;
public class ImageBasedLight implements org.sunflow.core.PrimitiveList, org.sunflow.core.LightSource, org.sunflow.core.Shader {
    private org.sunflow.core.Texture texture;
    private org.sunflow.math.OrthoNormalBasis basis;
    private int numSamples;
    private float jacobian;
    private float[] colHistogram;
    private float[][] imageHistogram;
    private org.sunflow.math.Vector3[] samples;
    private org.sunflow.image.Color[] colors;
    public ImageBasedLight() { super();
                               texture = null;
                               updateBasis(new org.sunflow.math.Vector3(0,
                                                                        0,
                                                                        -1),
                                           new org.sunflow.math.Vector3(
                                             0,
                                             1,
                                             0));
                               numSamples = 64; }
    private void updateBasis(org.sunflow.math.Vector3 center, org.sunflow.math.Vector3 up) {
        if (center !=
              null &&
              up !=
              null) {
            basis =
              org.sunflow.math.OrthoNormalBasis.
                makeFromWV(
                  center,
                  up);
            basis.
              swapWU(
                );
            basis.
              flipV(
                );
        }
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        updateBasis(
          pl.
            getVector(
              "center",
              null),
          pl.
            getVector(
              "up",
              null));
        numSamples =
          pl.
            getInt(
              "samples",
              numSamples);
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            texture =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  true);
        if (texture ==
              null)
            return false;
        org.sunflow.image.Bitmap b =
          texture.
          getBitmap(
            );
        if (b ==
              null)
            return false;
        if (filename !=
              null) {
            imageHistogram =
              (new float[b.
                           getWidth(
                             )][b.
                                  getHeight(
                                    )]);
            colHistogram =
              (new float[b.
                           getWidth(
                             )]);
            float du =
              1.0F /
              b.
              getWidth(
                );
            float dv =
              1.0F /
              b.
              getHeight(
                );
            for (int x =
                   0;
                 x <
                   b.
                   getWidth(
                     );
                 x++) {
                for (int y =
                       0;
                     y <
                       b.
                       getHeight(
                         );
                     y++) {
                    float u =
                      (x +
                         0.5F) *
                      du;
                    float v =
                      (y +
                         0.5F) *
                      dv;
                    org.sunflow.image.Color c =
                      texture.
                      getPixel(
                        u,
                        v);
                    imageHistogram[x][y] =
                      c.
                        getLuminance(
                          ) *
                        (float)
                          java.lang.Math.
                          sin(
                            java.lang.Math.
                              PI *
                              v);
                    if (y >
                          0)
                        imageHistogram[x][y] +=
                          imageHistogram[x][y -
                                              1];
                }
                colHistogram[x] =
                  imageHistogram[x][b.
                                      getHeight(
                                        ) -
                                      1];
                if (x >
                      0)
                    colHistogram[x] +=
                      colHistogram[x -
                                     1];
                for (int y =
                       0;
                     y <
                       b.
                       getHeight(
                         );
                     y++)
                    imageHistogram[x][y] /=
                      imageHistogram[x][b.
                                          getHeight(
                                            ) -
                                          1];
            }
            for (int x =
                   0;
                 x <
                   b.
                   getWidth(
                     );
                 x++)
                colHistogram[x] /=
                  colHistogram[b.
                                 getWidth(
                                   ) -
                                 1];
            jacobian =
              (float)
                (2 *
                   java.lang.Math.
                     PI *
                   java.lang.Math.
                     PI) /
                (b.
                   getWidth(
                     ) *
                   b.
                   getHeight(
                     ));
        }
        if (pl.
              getBoolean(
                "fixed",
                samples !=
                  null)) {
            samples =
              (new org.sunflow.math.Vector3[numSamples]);
            colors =
              (new org.sunflow.image.Color[numSamples]);
            for (int i =
                   0;
                 i <
                   numSamples;
                 i++) {
                double randX =
                  (double)
                    i /
                  (double)
                    numSamples;
                double randY =
                  org.sunflow.math.QMC.
                  halton(
                    0,
                    i);
                int x =
                  0;
                while (randX >=
                         colHistogram[x] &&
                         x <
                         colHistogram.
                           length -
                         1)
                    x++;
                float[] rowHistogram =
                  imageHistogram[x];
                int y =
                  0;
                while (randY >=
                         rowHistogram[y] &&
                         y <
                         rowHistogram.
                           length -
                         1)
                    y++;
                float u =
                  (float)
                    (x ==
                       0
                       ? randX /
                       colHistogram[0]
                       : (randX -
                            colHistogram[x -
                                           1]) /
                       (colHistogram[x] -
                          colHistogram[x -
                                         1]));
                float v =
                  (float)
                    (y ==
                       0
                       ? randY /
                       rowHistogram[0]
                       : (randY -
                            rowHistogram[y -
                                           1]) /
                       (rowHistogram[y] -
                          rowHistogram[y -
                                         1]));
                float px =
                  x ==
                  0
                  ? colHistogram[0]
                  : colHistogram[x] -
                  colHistogram[x -
                                 1];
                float py =
                  y ==
                  0
                  ? rowHistogram[0]
                  : rowHistogram[y] -
                  rowHistogram[y -
                                 1];
                float su =
                  (x +
                     u) /
                  colHistogram.
                    length;
                float sv =
                  (y +
                     v) /
                  rowHistogram.
                    length;
                float invP =
                  (float)
                    java.lang.Math.
                    sin(
                      sv *
                        java.lang.Math.
                          PI) *
                  jacobian /
                  (numSamples *
                     px *
                     py);
                samples[i] =
                  getDirection(
                    su,
                    sv);
                basis.
                  transform(
                    samples[i]);
                colors[i] =
                  texture.
                    getPixel(
                      su,
                      sv).
                    mul(
                      invP);
            }
        }
        else {
            samples =
              null;
            colors =
              null;
        }
        return true;
    }
    public void init(java.lang.String name, org.sunflow.SunflowAPI api) {
        api.
          geometry(
            name,
            this);
        if (api.
              lookupGeometry(
                name) ==
              null) {
            return;
        }
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
        api.
          light(
            name +
            ".light",
            this);
    }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        if (state.
              includeLights(
                ))
            state.
              setShader(
                this);
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        if (r.
              getMax(
                ) ==
              java.lang.Float.
                POSITIVE_INFINITY)
            state.
              setIntersection(
                0,
                0,
                0);
    }
    public int getNumPrimitives() { return 1; }
    public float getPrimitiveBound(int primID, int i) { return 0;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        return null;
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public int getNumSamples() { return numSamples;
    }
    public void getSamples(org.sunflow.core.ShadingState state) {
        if (samples ==
              null) {
            int n =
              state.
              getDiffuseDepth(
                ) >
              0
              ? 1
              : numSamples;
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                double randX =
                  state.
                  getRandom(
                    i,
                    0,
                    n);
                double randY =
                  state.
                  getRandom(
                    i,
                    1,
                    n);
                int x =
                  0;
                while (randX >=
                         colHistogram[x] &&
                         x <
                         colHistogram.
                           length -
                         1)
                    x++;
                float[] rowHistogram =
                  imageHistogram[x];
                int y =
                  0;
                while (randY >=
                         rowHistogram[y] &&
                         y <
                         rowHistogram.
                           length -
                         1)
                    y++;
                float u =
                  (float)
                    (x ==
                       0
                       ? randX /
                       colHistogram[0]
                       : (randX -
                            colHistogram[x -
                                           1]) /
                       (colHistogram[x] -
                          colHistogram[x -
                                         1]));
                float v =
                  (float)
                    (y ==
                       0
                       ? randY /
                       rowHistogram[0]
                       : (randY -
                            rowHistogram[y -
                                           1]) /
                       (rowHistogram[y] -
                          rowHistogram[y -
                                         1]));
                float px =
                  x ==
                  0
                  ? colHistogram[0]
                  : colHistogram[x] -
                  colHistogram[x -
                                 1];
                float py =
                  y ==
                  0
                  ? rowHistogram[0]
                  : rowHistogram[y] -
                  rowHistogram[y -
                                 1];
                float su =
                  (x +
                     u) /
                  colHistogram.
                    length;
                float sv =
                  (y +
                     v) /
                  rowHistogram.
                    length;
                float invP =
                  (float)
                    java.lang.Math.
                    sin(
                      sv *
                        java.lang.Math.
                          PI) *
                  jacobian /
                  (n *
                     px *
                     py);
                org.sunflow.math.Vector3 dir =
                  getDirection(
                    su,
                    sv);
                basis.
                  transform(
                    dir);
                if (org.sunflow.math.Vector3.
                      dot(
                        dir,
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
                          dir));
                    dest.
                      getShadowRay(
                        ).
                      setMax(
                        java.lang.Float.
                          MAX_VALUE);
                    org.sunflow.image.Color radiance =
                      texture.
                      getPixel(
                        su,
                        sv);
                    dest.
                      setRadiance(
                        radiance,
                        radiance);
                    dest.
                      getDiffuseRadiance(
                        ).
                      mul(
                        invP);
                    dest.
                      getSpecularRadiance(
                        ).
                      mul(
                        invP);
                    dest.
                      traceShadow(
                        state);
                    state.
                      addSample(
                        dest);
                }
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   numSamples;
                 i++) {
                if (org.sunflow.math.Vector3.
                      dot(
                        samples[i],
                        state.
                          getGeoNormal(
                            )) >
                      0 &&
                      org.sunflow.math.Vector3.
                      dot(
                        samples[i],
                        state.
                          getNormal(
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
                          samples[i]));
                    dest.
                      getShadowRay(
                        ).
                      setMax(
                        java.lang.Float.
                          MAX_VALUE);
                    dest.
                      setRadiance(
                        colors[i],
                        colors[i]);
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
    public void getPhoton(double randX1, double randY1,
                          double randX2,
                          double randY2,
                          org.sunflow.math.Point3 p,
                          org.sunflow.math.Vector3 dir,
                          org.sunflow.image.Color power) {
        
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        return state.
          includeLights(
            )
          ? getColor(
              basis.
                untransform(
                  state.
                    getRay(
                      ).
                    getDirection(
                      ),
                  new org.sunflow.math.Vector3(
                    )))
          : org.sunflow.image.Color.
              BLACK;
    }
    private org.sunflow.image.Color getColor(org.sunflow.math.Vector3 dir) {
        float u;
        float v;
        double phi =
          0;
        double theta =
          0;
        phi =
          java.lang.Math.
            acos(
              dir.
                y);
        theta =
          java.lang.Math.
            atan2(
              dir.
                z,
              dir.
                x);
        u =
          (float)
            (0.5 -
               0.5 *
               theta /
               java.lang.Math.
                 PI);
        v =
          (float)
            (phi /
               java.lang.Math.
                 PI);
        return texture.
          getPixel(
            u,
            v);
    }
    private org.sunflow.math.Vector3 getDirection(float u,
                                                  float v) {
        org.sunflow.math.Vector3 dest =
          new org.sunflow.math.Vector3(
          );
        double phi =
          0;
        double theta =
          0;
        theta =
          u *
            2 *
            java.lang.Math.
              PI;
        phi =
          v *
            java.lang.Math.
              PI;
        double sin_phi =
          java.lang.Math.
          sin(
            phi);
        dest.
          x =
          (float)
            (-sin_phi *
               java.lang.Math.
               cos(
                 theta));
        dest.
          y =
          (float)
            java.lang.Math.
            cos(
              phi);
        dest.
          z =
          (float)
            (sin_phi *
               java.lang.Math.
               sin(
                 theta));
        return dest;
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public float getPower() { return 0; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "N5oLi0d8Cv8fh2KGZfs0AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zuxJWO/7tbIgi+pmkvVhYOBQduZMmEnq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zlBYk1TfRuZ0jbXKCdptV3raJMYMaEoIjod3UL0ZjFVvNVx2UmdI8EJFbrQ7" +
       "CFprirqK4mNZ1Mi61RuYZdwAz46ZKUZ7AmQTc7VqbdqhpfZ8lGoeSqk1xjeT" +
       "ORn3xZ5qZ2ZWG/t9MHmYJT6eENB87LbFrWqM2uOkO6kigxTf0nCHNla6jnXl" +
       "uSRLVi+i6kvNTuTtMOXbuhOijdZ8AaMKV8EnkRg0a1yCqVAHo9JWb2WLVJ9A" +
       "cVKocAqox6sL1eUxLOWtfm3oNMzOelvuW70qud0qg21ks3BgzPRRvRYFi1hN" +
       "lhU34xSzOaxpWLydmU4z4Dxp4YzboT9k5XiswINWlZqOpXDdZ0d8h7UWslZH" +
       "paw8nwRJy8XpviCxLOmkFSJWqiuzSo6aGcmmUavWlFHRjedNk0hBQMewuiFX" +
       "A2iN1qmNUOOlXkuZRjKhT/u23jeq0EIUIQcJiOm0ibNEvFnXA2EiwjAzQqkK" +
       "NqWqEZe1WoEB1SS8zHoqC0HUhCxDcmzPPHKpQIof1AbbjV+xvAjE9mBiT0ic" +
       "Mpdr3hqzxUYbWSA8VW9mjZXWdhFRnLdQI11O5PaqajdQbdUZbTZuq+soap2x" +
       "dWQV1OkYRPB+IkiI1WuJ5AbPWE7vguCsVe0zvjCDLZMWs2UTzEPhFYEaEIPM" +
       "fCfdjjNDg2ppI27Nu50pXuNEiImrW7G6iNtsKrYXeAsyyXJGWJgge2vPj5ok" +
       "bkq6O8ZgG59LgkqZm1pLWqXBqCM6C5vyaiqIEWvttM402743TOX5nJ1beFrR" +
       "4VZlRSQxkzKbhY+Dib7Bcg1qbAsuYvVxiI2ptuA1oGXqQXJl4TsCU3cpvSK3" +
       "unFrrSFDbLUOKp1O5235EuYfv7Sl1TuLVeTDvcaG1cwzvvESVk/TY98MD79u" +
       "FH/nSif2px77gnJsQ9QNByvWD1y2Y+Zwu0S++eyg2H2XFSu2ee7Wh6/4waIo" +
       "xGpCvtMr8Ev3X227crEh49kPPP2MPPol+Ox+if/dYemW0PV+wlJixTpG9p27" +
       "jw6XfjRqgeuNe8hvPPnR6Iipp34xOvG54djXj2eLpCj1/VM+SvyvPPmrsPSK" +
       "yJOFUEEPt/mcXCePXV0+GuQXftQS+fF+ToDPv9YVX0ehPXjopYJ/02ngT5GQ" +
       "/Au6Eir+cQl57fFi7O63MybyHs6Urs64M+fylz8MS+d2jLsSz86Lrmsp+10u" +
       "Bdv+9hrYVuyDzb8EfnDPtg9eV7YdqPKZGwp4rzoF+mvy5PYw33OuFxt1/voQ" +
       "4ZkL14qwCa5P7BF+4vogPP7hD4z4/VdUd91R8/MgSoHwwVPQP5on94aAJl/x" +
       "BF85XvkEM15/rcxgwPXpPTM+fX2YccOldvTVlzFjKmzzvHcdlHjkshJEvgMp" +
       "2O3/PeLZT5zCs2qevCks3aUfVD201idY9uZrYNmF/GX++f2ze5Z99vqw7DiS" +
       "t52S9448aYWlO1QlZCL7EGJwxM8CY/saMBYO8xFw/eIe4y9edytQfFN/V4GI" +
       "OAXtME/yqACgPYSKupEj56W1I7j9a4BbhAL5hp1n93Cf/bGYhMv3htBC6Otp" +
       "rUDKncKF3OSfGYel2wEX5q5vyQUHDnfK3ndZw0U+sBeomx6xaHINLCr2Gb0V" +
       "XJ/fs+jz11/qlVPy8q/nZ94D7CHgACqYANqlgv8XRzCFa1XufCvnc3uYz11/" +
       "mJtT8vKXZ6yw9Mqdcu83FZ/QbPtaDX6e/+U9wC9fV1HPyXuoQPLUKSjzPTNn" +
       "0rB0K0B5DOIxA729VohbcP3lHuJfXh+I54sC568Ug52T3UgsTsmd+ehRcqCe" +
       "d1+mnmMXuKjcXe0C6H9ZcOUfnsKxj+fJB0Hcn5tBzQ13J4iOMexD12rtc6H/" +
       "zp5h3/kxycQ/PQXhZ/Pkk2CKABBOQayT7xUteHOE8VPXgPGu/GW+yf+FPcYX" +
       "XirGK8+FjjDupkFnfvkUjJ/Pk38Wlm4GGIvNaicA/vNrAPjq/OVD4PrBHuAP" +
       "rg/AYy672NWsFUh+7RSUX8mTL4Sl2wDKnu7vIriCQUdIv3it+v12QPSNu7q7" +
       "32sX1yOkZx460srfOgXp83nyG8BaB5IQgpDzipr5r69VM4HrPXN+D/X89YF6" +
       "HMR/OCXvm3ny2zuBHbvJ7pTWsaDr6y8FGzD4F04chM1P9d1z2YH63SFw6YvP" +
       "XLj57me4/7Q7qnBwUPsWqnTzOrKs44ewjt2fA/OltV6AvmV3JMsrkPzHE3Pw" +
       "o8O5Yemm4rdwvd/alf4jEF6fLA1movnP8WJ/AszVsWL59uHd3fFC/yUs3QAK" +
       "5bd/6h24hGMbE3dH0dJdlHjPcTkoJvN3/SgWH1Y5flI0PwxQ/D+Dg4370e4/" +
       "GjwpfekZkvnp7zd+aXdSVbKELMtbuZkqnd8dmi0azTf/P3zV1g7aOoe/+Ye3" +
       "f/mWxw8Wpm7fEXwkk8doe/DKx0L7thcWBzmzr979lZ/8F8/8WbEz8/8DUepO" +
       "B2hCAAA=");
}
