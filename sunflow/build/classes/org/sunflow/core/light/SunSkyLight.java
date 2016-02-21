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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R42eO7O7Qp8kl8rKCHpRkUja6LSqy7UE");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
