package org.sunflow.math;
public class PerlinVector {
    private static final float P1x = 0.34F;
    private static final float P1y = 0.66F;
    private static final float P1z = 0.237F;
    private static final float P2x = 0.011F;
    private static final float P2y = 0.845F;
    private static final float P2z = 0.037F;
    private static final float P3x = 0.34F;
    private static final float P3y = 0.12F;
    private static final float P3z = 0.9F;
    public static final org.sunflow.math.Vector3 snoise(float x) { return new org.sunflow.math.Vector3(
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P1x),
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P2x),
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P3x));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y,
                                                        float z) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y,
                                                        float z,
                                                        float t) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t));
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point2 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y);
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point3 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z);
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point3 p,
                                                        float t) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t);
    }
    public static final org.sunflow.math.Vector3 noise(float x) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y,
                                                       float z) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y,
                                                       float z,
                                                       float t) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t));
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point2 p) {
        return noise(
                 p.
                   x,
                 p.
                   y);
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point3 p) {
        return noise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z);
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point3 p,
                                                       float t) {
        return noise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t);
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float period) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              period),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              period),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              period));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float w,
                                                        float h) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              w,
              h));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float z,
                                                        float w,
                                                        float h,
                                                        float d) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              w,
              h,
              d));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float z,
                                                        float t,
                                                        float w,
                                                        float h,
                                                        float d,
                                                        float p) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t,
              w,
              h,
              d,
              p));
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point2 p,
                                                        float periodx,
                                                        float periody) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 periodx,
                 periody);
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point3 p,
                                                        org.sunflow.math.Vector3 period) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 period.
                   x,
                 period.
                   y,
                 period.
                   z);
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point3 p,
                                                        float t,
                                                        org.sunflow.math.Vector3 pperiod,
                                                        float tperiod) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t,
                 pperiod.
                   x,
                 pperiod.
                   y,
                 pperiod.
                   z,
                 tperiod);
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float period) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              period),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              period),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              period));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float w,
                                                         float h) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              w,
              h));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float z,
                                                         float w,
                                                         float h,
                                                         float d) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              w,
              h,
              d));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float z,
                                                         float t,
                                                         float w,
                                                         float h,
                                                         float d,
                                                         float p) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t,
              w,
              h,
              d,
              p));
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point2 p,
                                                         float periodx,
                                                         float periody) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 periodx,
                 periody);
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point3 p,
                                                         org.sunflow.math.Vector3 period) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 period.
                   x,
                 period.
                   y,
                 period.
                   z);
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point3 p,
                                                         float t,
                                                         org.sunflow.math.Vector3 pperiod,
                                                         float tperiod) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t,
                 pperiod.
                   x,
                 pperiod.
                   y,
                 pperiod.
                   z,
                 tperiod);
    }
    public PerlinVector() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALWbC5AUxRmAe/beL+7B63gfcKC8bnlGqTsROEAOl2PlkCIH" +
       "4Zibnb0bmJ0ZZnrv9lAiklJIjMbo4SNRqmJhUAuFSsUyKR+FoYhamFT5SBQt" +
       "H3lUSaKUUik0FTSm/57endnZ7YG77F7V/jc32/13/1///fc/fT3HzqMiy0ST" +
       "ZQ034QFDtppWazgsmpYcaVVFy9pE7nVJDxaI/9p+rn1pABV3ohG9orVeEi15" +
       "jSKrEasTTVI0C4uaJFvtshyBGmFTtmSzT8SKrnWi0YrVFjNURVLwej0iQ4HN" +
       "ohlCtSLGptIdx3IbU4DRpBDpSZD2JLjC+3VzCFVKujHgFK93FW91fQMlY05b" +
       "FkY1oZ1inxiMY0UNhhQLNydMNMfQ1YEeVcdNcgI37VSXMATrQksyEEw7Uf3l" +
       "pXt7ayiCkaKm6ZiaZ22ULV3tkyMhVO3cXa3KMWs3+j4qCKEKV2GMGkPJRoOk" +
       "0SBpNGmtU4r0vkrW4rFWnZqDk5qKDQk6hNHUdCWGaIoxpiZM+0w0lGJmO61M" +
       "rG1IWWtbmWHioTnBwQe31/yqAFV3ompF64DuSKQTmDTSSYDKsW7ZtFZEInKk" +
       "E9VqZLA7ZFMRVWUPG+k6S+nRRBwnw5/EAjfjhmzSNh1WZByJbWZcwrqZMi9K" +
       "HYr9VRRVxR5i6xjHVtvCNXCfGFiukI6ZUZH4HatSuEvRIhhN8dZI2dh4IylA" +
       "qpbEZNyrp5oq1ERyA9XZLqKKWk+wg7ie1kOKFunEAU2MxnOVAmtDlHaJPXIX" +
       "eKSnXNj+ipQqoyCgCkajvcWoJjJK4z2j5Bqf8+0t99yirdUCSCB9jsiSCv2v" +
       "IJUmeyptlKOyKZN5YFesnB16QBzz4sEAQqTwaE9hu8xzt15YPnfyyVftMhOy" +
       "lNnQvVOWcJd0pHvEGxNbZy0tgG6UGrqlwOCnWU5nWZh905wwSIQZk9IIXzYl" +
       "vzy58fff3feU/GkAlbehYklX4zHiR7WSHjMUVTZvkDXZFLEcaUNlshZppd+3" +
       "oRJyHVI02b67IRq1ZNyGClV6q1infxNEUaICEJWTa0WL6slrQ8S99DphIIRK" +
       "yAdVkk8Zsn/ob4zag716TA6Kkqgpmh4MmzrYbwVJxOkmbHuDVlyLqnp/0DKl" +
       "oG72pP6OEfXBsGyS7myWwcGbwK+MnGtMgA0j+wWB4J3ondwqmRdrdTUim13S" +
       "YHzl6gvPdJ2xHQecnVlP4i1ppok10wTNNLmbQYJAtY+C5uyBI9h3kQlMImjl" +
       "rI7vrdtxcFoB8Rijv5Awg6LT0laSVmeWJ0Nzl3S8rmrP1A8XnAqgwhCqEyUc" +
       "F1VYGFaYPSTkSLvYrKzsJmuME+obXKEe1ihTl+QIiTS8kM+0lOp9sgn3MRrl" +
       "0pBciGDKBfnLQNb+o5MP9d+++bb5ARRIj+7QZBEJTFA9DDE5FXsbvbM6m97q" +
       "A+e+PP7AXt2Z32nLRXKVy6gJNkzzjr8XT5c0u0F8tuvFvY0UexmJv1gk84WE" +
       "tsneNtLCR3MyFIMtpcTgqG7GRBW+SjIux72m3u/coY5ZC2K07aPgQp4O0ih+" +
       "XYfx6Lt//MciSjIZ8KtdK3WHjJtdQQaU1dFwUut45CZTlkm5Dx4K33/o/IGt" +
       "1B1JienZGmwE2UqCCxkdQvCOV3ef/ejDI28HHBfGZJWNd5NkJUFtGfUt+RHI" +
       "57/wgcAAN+wAUdfKolRDKkwZ0PJMp28kYKlkJoFzNN6sETdUoorYrcowf76u" +
       "nrHg2c/uqbGHWyV3kt4y9/IKnPvjVqJ9Z7Z/NZmqESRYMB1+TjE7Co90NK8w" +
       "TXEA+pG4/c1JD78iPkriOYmhlrJHpmERUR6IDuASymI+lYs9310DYobl9vH0" +
       "aeRKbLqke9/+omrzFy9doL1Nz4zc475eNJptL7JHgTQ2HjGRFqbh2zEGyLEJ" +
       "0oex3kC1VrR6ibLFJ9u31agnL5FmO0mzEskZrA0mCY6JNFdipYtK3nv51Jgd" +
       "bxSgwBpUrupiZI1IJxwqI54uW70kriaM65fb/egvJaKG8kAZhDJuwChMyT6+" +
       "q2MGpiOy5zdjf91y9PCH1C0NW8cEWr8MQn1ahKVJuDPJn3rrmj8d/ekD/fYy" +
       "Posf2Tz16v+zQe3e/9d/Z4wLjWlZUgxP/c7gsUfGty77lNZ3ggvUbkxkLk8k" +
       "QDt1Fz4VuxiYVnw6gEo6UY3Ekt7NohqHed1JEj0rmQmTxDjt+/Skzc5QmlPB" +
       "c6I3sLma9YY1Z1kk11Aarqs8PjgOhnAO+ZQzHyz3+iBdLqvp+EKXSNTRRfze" +
       "+dcee7/li88InDWoqA86TpjUOKXa45BZ33ns0KSKwY/vosO+7JlRt4DKdbTx" +
       "mVTOAjGXOkIBRiWGqZBHLMKg2KKZOiYWKZqoJlL9pS5X79NfjArCCxLpyzYs" +
       "jR3xbosssUqMhN0+lkUuDO+QDjaG/2671rgsFexyo58I3r35nZ2v06BeCov4" +
       "piRO1xJNFnvXYlEDogk64uOynv4E99Z9tOuRc0/b/fH6p6ewfHDwR9823TNo" +
       "B1v7OWF6RqrurmM/K3h6N9WvFVpjzSfH9z7/xN4Ddq/q0rPe1eSh7uk/f/N6" +
       "00Mfv5YlGSMOSbwlFTKEVFI1Kh22bdKqH1a/cG9dwRqynreh0rim7I7LbZF0" +
       "Ty6x4t0u+s4TiOPdzDhY1jASZpN4Yy/ZIK8FcaPtTy3ceLcqc35UMH+ryDI/" +
       "4CJ0/dUXT8FFD8e94fImEBtBdGRxaV4T1KUH4HKLx5DeIRoylz0XJJ8Pshqy" +
       "zDwxFS6MYRvCa4IasiebIbuHYUgVa6WKZ0jL4qW0nYFhG8JrAgxZmMhmyJ5h" +
       "GDKCtTKC61pbbvoMLvYP2xBeE9SQrK71g2EYUs1aqeYZct3Yu8NwcdewDeE1" +
       "QQ3J6lo/HsZkr2Gt1HDnCFvLBodtCK8JMGRRVtc6NAxDalkrtdwRufi7n8DF" +
       "o8M2hNcENSSrax0eoiGzyaeOtVLHnSPRaBQufjlsQ3hNUEOyutZRH0MS2fsh" +
       "wOU8p3X6U4z4zwCuVBnBej2Jt5tG1+oj+wcPRzY8viDAHmW2Y5Lg68Y8Ve6T" +
       "VZeqiaApLeteT/cPnRT2gxH3/e23jT0rh7KlAfcmX2bTAv6eQvKI2fysyNuV" +
       "V/b/c/ymZb07hrA7McVDyavyyfXHXrthpnRfgG6W2rl1xiZreqXm9Dyk3JRx" +
       "3NTSM4/pqXFtgPGaST7JQR7ldVzHl7I76zyus471Uet5rBUcp9tCW3zZ57mX" +
       "pi/PQ/Kt6Ypl73zUY1SfsaFmb6UtcibCC5eb0f4PkHBjpZ1uPJdJsJ6ZWp9b" +
       "gjy1HkABqi+Qmv42xjd8ML4F4kwKI/x12kH1ej5RTWQ2TcwtKp5aD4QCR98W" +
       "D6+PfHj9BcRZHq/38smrgRnWkFtePLUeCIVUX6GHlwPtvA+0z0F8woN2Lp/Q" +
       "Gpl1jbmFxlObPaIlg9PYzN1+XdGwnZxf8gH4LYiLPIBf5hPg1czSq3MLkKd2" +
       "WABpCipU8AEK1SCKOACF4nwCnMssnZtbgDy13BVBqExNVmGCD6pJIEbzUI3J" +
       "F6oZ5DOf2TQ/t6h4ai+TfgizfCjNATEdo6JskBrzCWkxs2ZxbiHx1F5JhiFc" +
       "40NqKYgFHFIL80nqWmbStbklxVN7xQmGsNoH1w0grufgWp5PXC3Mrpbc4uKp" +
       "HVp+IXT4MLsZxHoOs/Z8MmM67d+5Y8ZTy49YX1MQog8kCcRWDqRt+YS0ilmz" +
       "KreQeGq5kIRKCkL3gbQbhMKBtDOfkNYya9bmFhJP7RWlCXt9SN0Gop9DKpHP" +
       "hCrETArllhRP7RUtgHf5kLobxB1wsCEbqjvziSrMbArnFhVP7RBD+sM+0H4O" +
       "4n4etMF8QtvErNuUW2g8tR4IxVRfcTZoHnxHffA9CeIXPHyP5RPfFmbnltzi" +
       "46n1QCil+kr98XlAPusD8jkQx3kgT+QT5DZm8bbcguSp5aevX3t4nfLhdRrE" +
       "izxeL+WT1w5m2I7c8uKpvcwKepri8Nl6Fd4CcYaHKq9brxFmUyS3qHhquesC" +
       "Szao6Y5/+ey/CrD/KpzlQcvb/utV5NPLrOvNLTSe2ivKO3x2XQXYdRU+wajE" +
       "ysoqb9uuwEplRqm5ZcVTO8TEw2erVfgGxEUutbzttQI1g5ln5JYaT+1wM49A" +
       "GZ9foAJEAY9foDCf/DAzFOeWH0/t/596BLw63CTHgajlkqzLJ8kEMzmRW5I8" +
       "tVecewRm+AC7CsQULrCGfAK7lVl2a26B8dReSfIRWOTDagmIeVxWTflktY8Z" +
       "tS+3rHhqh5Z9BFb4UGsF0cyl1pILagmMKt0vAcGJ9fqMdwft992kZw5Xl449" +
       "fPM79OBL6p20yhAqjcZV1X2m2nVdbJhyVKG06Y4YqqWHTgM3YlTj/QcbRoXw" +
       "CzobWGcXa8eowlUMaNhX7kI3YVRACsHlRtsR6rH7yLV9Vjxh/2dvghsJkESj" +
       "L0fSdchoetrhHPoyZvIgTdx+HbNLOn54XfstF77zuP2mi6SKe+gZqYoQKrHf" +
       "p6FK4TDOVK62pK7itbMujThRNiN5bCntTRt33+h4IiTQt1LGe179sBpTb4Cc" +
       "PdLy0h8OFr8ZQMJWJIgYjdyaeao+YcRNNGlrKPMo8mbRpO+kNM/62cCyudHP" +
       "36cH2JF9dHkiv3yX1Hn/u20ndn21nL79V6RoETlBj/uvGtA2ylKfmXaueQR4" +
       "lwivZVIODF9V6i688oTRtMxD3ZkvipUTZ5HNlXpci4CaqhCqcO7YI+E5vxQ3" +
       "DE8F5w4bOpDdIJro6kL8ryu03jCS7wu9bdD5JaWmnWvzXKIuSxuDXfJA9H+D" +
       "j2U0lz0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV8C7Dj1nke79VrV69drSVLViRZsle2ZSoLgABBciTZJkGC" +
       "eJAgCYIgidqW8CRAPAmAJEBbqewZx56mdtxGTp1OrM507GmdOrbbqcedpm7l" +
       "etrYE7eddNw2j2nsdtpJ2kgzVjpO07ipe0By9969e3nlla4mnMHhIfCfc/7v" +
       "O///n4NzAH7p5dxNUZjLB76TThw/vqQn8aWpU7wUp4EeXWJaxa4cRrpGOHIU" +
       "CeDc0+rbvnruT3/8afP8fu5mKfcm2fP8WI4t34t4PfKdha61cucOzjYc3Y3i" +
       "3PnWVF7I0Dy2HKhlRfETrdxth4rGuYutyypAQAUIqACtVYCqB1Kg0B26N3eJ" +
       "rITsxdEs93O5vVbu5kDN1Itzj1xdSSCHsrutprtGAGo4k/0WAah14STMPXwF" +
       "+wbzNYA/k4ee/1sfPP+Pbsidk3LnLK+fqaMCJWLQiJS73dVdRQ+jqqbpmpS7" +
       "y9N1ra+HluxYq7XeUu5CZE08OZ6H+hWSspPzQA/XbR4wd7uaYQvnauyHV+AZ" +
       "lu5ol3/dZDjyBGB98wHWDUIyOw8A3moBxUJDVvXLRW60LU+Lc289WuIKxoss" +
       "EABFb3H12PSvNHWjJ4MTuQubvnNkbwL149DyJkD0Jn8OWolz9++sNOM6kFVb" +
       "nuhPx7n7jsp1N5eA1Nk1EVmROHfPUbF1TaCX7j/SS4f652XuyU99yKO8/bXO" +
       "mq46mf5nQKGHjhTidUMPdU/VNwVvf3frl+U3f+MT+7kcEL7niPBG5usffuV9" +
       "jz/04rc3Mj9zjExHmepq/LT6eeXO336AeKxyQ6bGmcCPrKzzr0K+Nv/u9soT" +
       "SQA8781XaswuXrp88UX+X4+f+zX9j/dzt9K5m1XfmbvAju5SfTewHD1s6p4e" +
       "yrGu0bmzuqcR6+t07haQb1mevjnbMYxIj+ncjc761M3++jegyABVZBTdAvKW" +
       "Z/iX84Ecm+t8EuRyuVvAkbsdHGdzm8/6O85xkOm7OiSrsmd5PtQN/Qx/BOle" +
       "rABuTSiae4bjL6EoVCE/nFz57YLqoa4eAnVEPTPwS5ldBadeY5JhOL/c2wP0" +
       "PnDUuR3gF5TvaHr4tPr8vNZ45ctP/9b+FWPfoo9zD4JmLm2buZQ1c+lwM7m9" +
       "vXXtd2fNbToO0G4DBwah7fbH+h9gnvnE224AFhMsbwScZaLQ7ghLHLg8vQ5s" +
       "KrC73IufXX5E/Kvwfm7/6lCZqQhO3ZoV72YB7kogu3jURY6r99zH/+hPv/LL" +
       "z/oHznJV7N368LUlMx9821EyQ1/VNRDVDqp/98Py157+xrMX93M3AscGwSyW" +
       "gfGBOPHQ0Tau8sUnLse1DMtNALDhh67sZJcuB6NbYzP0lwdn1r185zp/F+D4" +
       "/tw2ucpas6tvCrL07o1VZJ12BMU6bj7VDz73O//2f6Brui+H2HOHBq2+Hj9x" +
       "yK2zys6tHfiuAxsQQl0Hcv/5s91f+szLH/8rawMAEm8/rsGLWUoAdwZdCGj+" +
       "2Ldnv/v9P/j89/YPjCYG49pccSw12YD8CfjsgeP/ZUcGLjuxcckLxDYuPHwl" +
       "MARZy+840A2ECAfYbmZBFwee62uWYcmKo2cW+3/PPYp87aVPnd/YhAPOXDap" +
       "x1+9goPzb6nlnvutD/7vh9bV7KnZEHXA34HYJu696aDmahjKaaZH8pF//+Cv" +
       "/Kb8ORBBQdSKrJW+DkS5NR+5dQfCay7y6xQ6cq2QJW+NDjvC1b52aCrxtPrp" +
       "7/3wDvGH//yVtbZXz0UO93tbDp7YmFqWPJyA6u896vWUHJlADnuRe/9558Uf" +
       "gxolUKMKBuCoE4JIk1xlJVvpm275vW9+683P/PYNuX0yd6vjyxoprx0udxZY" +
       "uh6ZIEglwXvft7Hm5RmQnF9DzV0DfmMg961/3Q4UfGx3rCGzqcSBu9735x1H" +
       "+eh//bNrSFhHmWNG0CPlJehLv3o/8Z4/Xpc/cPes9EPJtdEXTLsOyhZ+zf3R" +
       "/ttu/lf7uVuk3Hl1O6cTZWeeOZEE5jHR5YkemPdddf3qOclmAH7iSjh74Gio" +
       "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" +
       "zT7ou5/SCo48AbC3eVpivaK9FvgXJzwi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8M0s+afZ1qnnW5F+edX5vmue9tk854Me2NRvvNoq7eGm1ie+fi0J921JuO+0" +
       "Sdhfi+5fWdbfMPFvTmDi32XJt68wkf361gHa75wG2ge2aB84bbQ3HIhyRyD/" +
       "7gmQfz9LvrcL8n84DcgPbyE/fNqQb1yL3ngE8gHu/34C7j/Mkh/swv1fTgP3" +
       "xS3ui2+Qd1921HuvfSzPt7x4swn8ygkc/ChLXtrFwcunwcG7thy86y+Hg83m" +
       "6E92c7C3buzPd3Hw49Pg4PEtB4+fNgcHAW4vd8Xq9+44Ae25LDmzA+3e2deL" +
       "9lFwwFu08BvU4wdA33IC0J/Jkrvj3E3H4bznNHBiW5zYG9erh2LZ3qMngH1n" +
       "ljy8A+wjpwG2vAVbPm2wu0etPeQExGtkj+9A/LOngfjJLeInTxvxqwxae0+d" +
       "APu9WVLeAbtyGrC3ZTffb5D3/skaC30CzuwBgb36DpyN08BZ3+Ksv3E49zZY" +
       "BifgHGZJdwfO3mngpLY4qdPGefzYI58AVs2S9+8A+4HTGGhbW7CtNw7sYU91" +
       "TwCbvT6yZ2ZPqx+H1joNtN0t2u5po321CJWegDt7hm0v3oV7fhq4hS1u4bRx" +
       "37wWvfk43EcY+NgJDHw8S57bxcBHToOB0ZaB0WkzcGYteuZkBo5w8TdO4OKX" +
       "suSv7+Lik6fBxfu3XLz/tLk4NDP5kyOQP3cC5L+TJZ/dBflXTgPyM1vIz5w2" +
       "5KMx/VtrRF88Ae0/yJLP70L7hdNAq23RaqeN9iDMbUewtfYHvfy1E3B/PUu+" +
       "ugv3P3y9uN8JDnOL23zjevmwTX/zBLQZKXv/LM7dEh0L9xunAdfZwnXeuG4+" +
       "Pn6dsB64l60H7n17J/DXvSCYAQ+2wIPTBv7TD2cnrA/uZeuDe9/bScHrXiDM" +
       "KIi3FMSnTcFrGc9OWDTcyxYN936wk4zXvWr4zrXo5pOcNhknDGgnLBLu/a8s" +
       "eWkn5te9Sphh/vAW84dPG/PxI9pfnAD3J1nyZzvh/p/TgPvcFu5zpw33VYa0" +
       "/bO7ge/fliU37gK+f9P1AE/i3O2HXw3P3m2975p/lNj8C4L65RfOnbn3hcF/" +
       "Wr8dfeWfCs62cmeMueMcfhXxUP7mINQNa03C2XV6Z7BGcSHOnT+6FBznbsy+" +
       "Mi3379qI3RPnbjsklqHe5A4L3RfnbgBCWfYtwRrj1e9ibF6xTDZr0Pcd7vOM" +
       "sdyFV2Ps0Nbp26/a8Fz/Rcflzcn55k86nla/8gLDfegV/Aubt7FVR16t31g5" +
       "08rdsnkxfF1ptsH5yM7aLtd1M/XYj+/86tlHL2/G3rlR+MD+Dun21uNfd264" +
       "Qbx+QXn1T+79x0/+vRf+YP2q5v8HSqMG6TtFAAA=");
}
