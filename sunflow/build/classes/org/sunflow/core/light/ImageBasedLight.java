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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "LZe6YeDqixzDf/T/A4T6pISFMwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zkzvE8lkLljRZLgOhUHCrubNMdrXJ2hf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "L/3ov3j2z/Idlv8PzK+OFahCAAA=");
}
