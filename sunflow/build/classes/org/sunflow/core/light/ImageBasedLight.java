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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IoNXbgyM5qLiEZ+i/wcwWeQ9IzUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NssVuZqKA9DrSCimVUVrl6tsiXTnFMM2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "e25+454v//i/eObP8h2a/x8fzX0NmEIAAA==");
}
