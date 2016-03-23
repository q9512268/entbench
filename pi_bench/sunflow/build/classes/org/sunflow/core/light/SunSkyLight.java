package org.sunflow.core.light;
public class SunSkyLight implements org.sunflow.core.LightSource, org.sunflow.core.PrimitiveList, org.sunflow.core.Shader {
    private int numSkySamples;
    private org.sunflow.math.OrthoNormalBasis basis;
    private org.sunflow.math.Vector3 sunDirWorld;
    private float turbidity;
    private org.sunflow.math.Vector3 sunDir;
    private org.sunflow.image.SpectralCurve sunSpectralRadiance;
    private org.sunflow.image.Color sunColor;
    private float sunTheta;
    private double zenithY;
    private double zenithx;
    private double zenithy;
    private final double[] perezY = new double[5];
    private final double[] perezx = new double[5];
    private final double[] perezy = new double[5];
    private float jacobian;
    private float[] colHistogram;
    private float[][] imageHistogram;
    private static final float[] solAmplitudes = { 165.5F, 162.3F, 211.2F,
    258.8F,
    258.2F,
    242.3F,
    267.6F,
    296.6F,
    305.4F,
    300.6F,
    306.6F,
    288.3F,
    287.1F,
    278.2F,
    271.0F,
    272.3F,
    263.6F,
    255.0F,
    250.6F,
    253.1F,
    253.5F,
    251.3F,
    246.3F,
    241.7F,
    236.8F,
    232.1F,
    228.2F,
    223.4F,
    219.7F,
    215.3F,
    211.0F,
    207.3F,
    202.4F,
    198.7F,
    194.3F,
    190.7F,
    186.3F,
    182.6F };
    private static final org.sunflow.image.RegularSpectralCurve solCurve =
      new org.sunflow.image.RegularSpectralCurve(
      solAmplitudes,
      380,
      750);
    private static final float[] k_oWavelengths = { 300, 305, 310, 315, 320,
    325,
    330,
    335,
    340,
    345,
    350,
    355,
    445,
    450,
    455,
    460,
    465,
    470,
    475,
    480,
    485,
    490,
    495,
    500,
    505,
    510,
    515,
    520,
    525,
    530,
    535,
    540,
    545,
    550,
    555,
    560,
    565,
    570,
    575,
    580,
    585,
    590,
    595,
    600,
    605,
    610,
    620,
    630,
    640,
    650,
    660,
    670,
    680,
    690,
    700,
    710,
    720,
    730,
    740,
    750,
    760,
    770,
    780,
    790 };
    private static final float[] k_oAmplitudes = { 10.0F, 4.8F, 2.7F, 1.35F,
    0.8F,
    0.38F,
    0.16F,
    0.075F,
    0.04F,
    0.019F,
    0.007F,
    0.0F,
    0.003F,
    0.003F,
    0.004F,
    0.006F,
    0.008F,
    0.009F,
    0.012F,
    0.014F,
    0.017F,
    0.021F,
    0.025F,
    0.03F,
    0.035F,
    0.04F,
    0.045F,
    0.048F,
    0.057F,
    0.063F,
    0.07F,
    0.075F,
    0.08F,
    0.085F,
    0.095F,
    0.103F,
    0.11F,
    0.12F,
    0.122F,
    0.12F,
    0.118F,
    0.115F,
    0.12F,
    0.125F,
    0.13F,
    0.12F,
    0.105F,
    0.09F,
    0.079F,
    0.067F,
    0.057F,
    0.048F,
    0.036F,
    0.028F,
    0.023F,
    0.018F,
    0.014F,
    0.011F,
    0.01F,
    0.009F,
    0.007F,
    0.004F,
    0.0F,
    0.0F };
    private static final float[] k_gWavelengths = { 759, 760, 770, 771 };
    private static final float[] k_gAmplitudes = { 0, 3.0F, 0.21F, 0 };
    private static final float[] k_waWavelengths = { 689, 690, 700, 710, 720,
    730,
    740,
    750,
    760,
    770,
    780,
    790,
    800 };
    private static final float[] k_waAmplitudes = { 0.0F, 0.016F, 0.024F,
    0.0125F,
    1.0F,
    0.87F,
    0.061F,
    0.001F,
    1.0E-5F,
    1.0E-5F,
    6.0E-4F,
    0.0175F,
    0.036F };
    private static final org.sunflow.image.IrregularSpectralCurve k_oCurve =
      new org.sunflow.image.IrregularSpectralCurve(
      k_oWavelengths,
      k_oAmplitudes);
    private static final org.sunflow.image.IrregularSpectralCurve k_gCurve =
      new org.sunflow.image.IrregularSpectralCurve(
      k_gWavelengths,
      k_gAmplitudes);
    private static final org.sunflow.image.IrregularSpectralCurve k_waCurve =
      new org.sunflow.image.IrregularSpectralCurve(
      k_waWavelengths,
      k_waAmplitudes);
    public SunSkyLight() { super();
                           numSkySamples = 64;
                           sunDirWorld = new org.sunflow.math.Vector3(1, 1,
                                                                      1);
                           turbidity = 6;
                           basis = org.sunflow.math.OrthoNormalBasis.makeFromWV(
                                                                       new org.sunflow.math.Vector3(
                                                                         0,
                                                                         0,
                                                                         1),
                                                                       new org.sunflow.math.Vector3(
                                                                         0,
                                                                         1,
                                                                         0));
                           initSunSky(); }
    private org.sunflow.image.SpectralCurve computeAttenuatedSunlight(float theta,
                                                                      float turbidity) {
        float[] data =
          new float[91];
        final double alpha =
          1.3;
        final double lozone =
          0.35;
        final double w =
          2.0;
        double beta =
          0.0460836582205 *
          turbidity -
          0.04586025928522;
        double m =
          1.0 /
          (java.lang.Math.
             cos(
               theta) +
             9.4E-4 *
             java.lang.Math.
             pow(
               1.6386 -
                 theta,
               -1.253));
        for (int i =
               0,
               lambda =
                 350;
             lambda <=
               800;
             i++,
               lambda +=
                 5) {
            double tauR =
              java.lang.Math.
              exp(
                -m *
                  0.008735 *
                  java.lang.Math.
                  pow(
                    (double)
                      lambda /
                      1000.0,
                    -4.08));
            double tauA =
              java.lang.Math.
              exp(
                -m *
                  beta *
                  java.lang.Math.
                  pow(
                    (double)
                      lambda /
                      1000.0,
                    -alpha));
            double tauO =
              java.lang.Math.
              exp(
                -m *
                  k_oCurve.
                  sample(
                    lambda) *
                  lozone);
            double tauG =
              java.lang.Math.
              exp(
                -1.41 *
                  k_gCurve.
                  sample(
                    lambda) *
                  m /
                  java.lang.Math.
                  pow(
                    1.0 +
                      118.93 *
                      k_gCurve.
                      sample(
                        lambda) *
                      m,
                    0.45));
            double tauWA =
              java.lang.Math.
              exp(
                -0.2385 *
                  k_waCurve.
                  sample(
                    lambda) *
                  w *
                  m /
                  java.lang.Math.
                  pow(
                    1.0 +
                      20.07 *
                      k_waCurve.
                      sample(
                        lambda) *
                      w *
                      m,
                    0.45));
            double amp =
              solCurve.
              sample(
                lambda) *
              tauR *
              tauA *
              tauO *
              tauG *
              tauWA;
            data[i] =
              (float)
                amp;
        }
        return new org.sunflow.image.RegularSpectralCurve(
          data,
          350,
          800);
    }
    private double perezFunction(final double[] lam,
                                 double theta,
                                 double gamma,
                                 double lvz) {
        double den =
          (1.0 +
             lam[0] *
             java.lang.Math.
             exp(
               lam[1])) *
          (1.0 +
             lam[2] *
             java.lang.Math.
             exp(
               lam[3] *
                 sunTheta) +
             lam[4] *
             java.lang.Math.
             cos(
               sunTheta) *
             java.lang.Math.
             cos(
               sunTheta));
        double num =
          (1.0 +
             lam[0] *
             java.lang.Math.
             exp(
               lam[1] /
                 java.lang.Math.
                 cos(
                   theta))) *
          (1.0 +
             lam[2] *
             java.lang.Math.
             exp(
               lam[3] *
                 gamma) +
             lam[4] *
             java.lang.Math.
             cos(
               gamma) *
             java.lang.Math.
             cos(
               gamma));
        return lvz *
          num /
          den;
    }
    private void initSunSky() { sunDirWorld.
                                  normalize(
                                    );
                                sunDir = basis.
                                           untransform(
                                             sunDirWorld,
                                             new org.sunflow.math.Vector3(
                                               ));
                                sunDir.normalize(
                                         );
                                sunTheta =
                                  (float)
                                    java.lang.Math.
                                    acos(
                                      org.sunflow.math.MathUtils.
                                        clamp(
                                          sunDir.
                                            z,
                                          -1,
                                          1));
                                if (sunDir.
                                      z >
                                      0) {
                                    sunSpectralRadiance =
                                      computeAttenuatedSunlight(
                                        sunTheta,
                                        turbidity);
                                    sunColor =
                                      org.sunflow.image.RGBSpace.
                                        SRGB.
                                        convertXYZtoRGB(
                                          sunSpectralRadiance.
                                            toXYZ(
                                              ).
                                            mul(
                                              1.0E-4F)).
                                        constrainRGB(
                                          );
                                }
                                else {
                                    sunSpectralRadiance =
                                      new org.sunflow.image.ConstantSpectralCurve(
                                        0);
                                }
                                float theta2 =
                                  sunTheta *
                                  sunTheta;
                                float theta3 =
                                  sunTheta *
                                  theta2;
                                float T =
                                  turbidity;
                                float T2 =
                                  turbidity *
                                  turbidity;
                                double chi =
                                  (4.0 /
                                     9.0 -
                                     T /
                                     120.0) *
                                  (java.lang.Math.
                                     PI -
                                     2.0 *
                                     sunTheta);
                                zenithY =
                                  (4.0453 *
                                     T -
                                     4.971) *
                                    java.lang.Math.
                                    tan(
                                      chi) -
                                    0.2155 *
                                    T +
                                    2.4192;
                                zenithY *=
                                  1000;
                                zenithx =
                                  (0.00165 *
                                     theta3 -
                                     0.00374 *
                                     theta2 +
                                     0.00208 *
                                     sunTheta +
                                     0) *
                                    T2 +
                                    (-0.02902 *
                                       theta3 +
                                       0.06377 *
                                       theta2 -
                                       0.03202 *
                                       sunTheta +
                                       0.00394) *
                                    T +
                                    (0.11693 *
                                       theta3 -
                                       0.21196 *
                                       theta2 +
                                       0.06052 *
                                       sunTheta +
                                       0.25885);
                                zenithy =
                                  (0.00275 *
                                     theta3 -
                                     0.0061 *
                                     theta2 +
                                     0.00316 *
                                     sunTheta +
                                     0) *
                                    T2 +
                                    (-0.04212 *
                                       theta3 +
                                       0.0897 *
                                       theta2 -
                                       0.04153 *
                                       sunTheta +
                                       0.00515) *
                                    T +
                                    (0.15346 *
                                       theta3 -
                                       0.26756 *
                                       theta2 +
                                       0.06669 *
                                       sunTheta +
                                       0.26688);
                                perezY[0] =
                                  0.17872 *
                                    T -
                                    1.46303;
                                perezY[1] =
                                  -0.3554 *
                                    T +
                                    0.42749;
                                perezY[2] =
                                  -0.02266 *
                                    T +
                                    5.32505;
                                perezY[3] =
                                  0.12064 *
                                    T -
                                    2.57705;
                                perezY[4] =
                                  -0.06696 *
                                    T +
                                    0.37027;
                                perezx[0] =
                                  -0.01925 *
                                    T -
                                    0.25922;
                                perezx[1] =
                                  -0.06651 *
                                    T +
                                    8.1E-4;
                                perezx[2] =
                                  -4.1E-4 *
                                    T +
                                    0.21247;
                                perezx[3] =
                                  -0.06409 *
                                    T -
                                    0.89887;
                                perezx[4] =
                                  -0.00325 *
                                    T +
                                    0.04517;
                                perezy[0] =
                                  -0.01669 *
                                    T -
                                    0.26078;
                                perezy[1] =
                                  -0.09495 *
                                    T +
                                    0.00921;
                                perezy[2] =
                                  -0.00792 *
                                    T +
                                    0.21023;
                                perezy[3] =
                                  -0.04405 *
                                    T -
                                    1.65369;
                                perezy[4] =
                                  -0.01092 *
                                    T +
                                    0.05291;
                                final int w =
                                  32;
                                final int h =
                                  32;
                                imageHistogram =
                                  (new float[w][h]);
                                colHistogram =
                                  (new float[w]);
                                float du =
                                  1.0F /
                                  w;
                                float dv =
                                  1.0F /
                                  h;
                                for (int x =
                                       0;
                                     x <
                                       w;
                                     x++) {
                                    for (int y =
                                           0;
                                         y <
                                           h;
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
                                          getSkyRGB(
                                            getDirection(
                                              u,
                                              v));
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
                                      imageHistogram[x][h -
                                                          1];
                                    if (x >
                                          0)
                                        colHistogram[x] +=
                                          colHistogram[x -
                                                         1];
                                    for (int y =
                                           0;
                                         y <
                                           h;
                                         y++)
                                        imageHistogram[x][y] /=
                                          imageHistogram[x][h -
                                                              1];
                                }
                                for (int x =
                                       0;
                                     x <
                                       w;
                                     x++)
                                    colHistogram[x] /=
                                      colHistogram[w -
                                                     1];
                                jacobian =
                                  (float)
                                    (2 *
                                       java.lang.Math.
                                         PI *
                                       java.lang.Math.
                                         PI) /
                                    (w *
                                       h);
    }
    public boolean update(org.sunflow.core.ParameterList pl,
                          org.sunflow.SunflowAPI api) {
        org.sunflow.math.Vector3 up =
          pl.
          getVector(
            "up",
            null);
        org.sunflow.math.Vector3 east =
          pl.
          getVector(
            "east",
            null);
        if (up !=
              null &&
              east !=
              null)
            basis =
              org.sunflow.math.OrthoNormalBasis.
                makeFromWV(
                  up,
                  east);
        else
            if (up !=
                  null)
                basis =
                  org.sunflow.math.OrthoNormalBasis.
                    makeFromW(
                      up);
        numSkySamples =
          pl.
            getInt(
              "samples",
              numSkySamples);
        sunDirWorld =
          pl.
            getVector(
              "sundir",
              sunDirWorld);
        turbidity =
          pl.
            getFloat(
              "turbidity",
              turbidity);
        initSunSky(
          );
        return true;
    }
    public void init(java.lang.String name,
                     org.sunflow.SunflowAPI api) {
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
        api.
          light(
            name +
            ".light",
            this);
    }
    private org.sunflow.image.Color getSkyRGB(org.sunflow.math.Vector3 dir) {
        if (dir.
              z <
              0)
            return org.sunflow.image.Color.
                     BLACK;
        if (dir.
              z <
              0.001F)
            dir.
              z =
              0.001F;
        dir.
          normalize(
            );
        double theta =
          java.lang.Math.
          acos(
            org.sunflow.math.MathUtils.
              clamp(
                dir.
                  z,
                -1,
                1));
        double gamma =
          java.lang.Math.
          acos(
            org.sunflow.math.MathUtils.
              clamp(
                org.sunflow.math.Vector3.
                  dot(
                    dir,
                    sunDir),
                -1,
                1));
        double x =
          perezFunction(
            perezx,
            theta,
            gamma,
            zenithx);
        double y =
          perezFunction(
            perezy,
            theta,
            gamma,
            zenithy);
        double Y =
          perezFunction(
            perezY,
            theta,
            gamma,
            zenithY) *
          1.0E-4;
        org.sunflow.image.XYZColor c =
          org.sunflow.image.ChromaticitySpectrum.
          get(
            (float)
              x,
            (float)
              y);
        float X =
          (float)
            (c.
               getX(
                 ) *
               Y /
               c.
               getY(
                 ));
        float Z =
          (float)
            (c.
               getZ(
                 ) *
               Y /
               c.
               getY(
                 ));
        return org.sunflow.image.RGBSpace.
                 SRGB.
          convertXYZtoRGB(
            X,
            (float)
              Y,
            Z);
    }
    public int getNumSamples() { return 1 +
                                   numSkySamples;
    }
    public void getPhoton(double randX1, double randY1,
                          double randX2,
                          double randY2,
                          org.sunflow.math.Point3 p,
                          org.sunflow.math.Vector3 dir,
                          org.sunflow.image.Color power) {
        
    }
    public float getPower() { return 0; }
    public void getSamples(org.sunflow.core.ShadingState state) {
        if (org.sunflow.math.Vector3.
              dot(
                sunDirWorld,
                state.
                  getGeoNormal(
                    )) >
              0 &&
              org.sunflow.math.Vector3.
              dot(
                sunDirWorld,
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
                  sunDirWorld));
            dest.
              getShadowRay(
                ).
              setMax(
                java.lang.Float.
                  MAX_VALUE);
            dest.
              setRadiance(
                sunColor,
                sunColor);
            dest.
              traceShadow(
                state);
            state.
              addSample(
                dest);
        }
        int n =
          state.
          getDiffuseDepth(
            ) >
          0
          ? 1
          : numSkySamples;
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
            org.sunflow.math.Vector3 localDir =
              getDirection(
                su,
                sv);
            org.sunflow.math.Vector3 dir =
              basis.
              transform(
                localDir,
                new org.sunflow.math.Vector3(
                  ));
            if (org.sunflow.math.Vector3.
                  dot(
                    dir,
                    state.
                      getGeoNormal(
                        )) >
                  0 &&
                  org.sunflow.math.Vector3.
                  dot(
                    dir,
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
                      dir));
                dest.
                  getShadowRay(
                    ).
                  setMax(
                    java.lang.Float.
                      MAX_VALUE);
                org.sunflow.image.Color radiance =
                  getSkyRGB(
                    localDir);
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
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public int getNumPrimitives() { return 1;
    }
    public float getPrimitiveBound(int primID,
                                   int i) {
        return 0;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        return null;
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
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        if (state.
              includeLights(
                ))
            state.
              setShader(
                this);
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        return getSkyRGB(
                 basis.
                   untransform(
                     state.
                       getRay(
                         ).
                       getDirection(
                         ))).
          constrainRGB(
            );
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Q3D/afLO2F9iUBEbcqJn+C3enf1/jnIN5oFFAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "atOE1xkDbWuddNjwYzqptcstpVNuaL2S");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "gvyrYOlnH/lX7/rnr/x+PmP+/wOpXNAVqVQAAA==");
}
