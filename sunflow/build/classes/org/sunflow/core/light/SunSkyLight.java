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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1sC1BUIs4Hp/6cPytJ/EMW2vOwufMZ2O");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "4VQAAA==");
}
