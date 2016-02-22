package org.sunflow.core.filter;
public class CatmullRomFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return catrom1d(x) * catrom1d(y);
    }
    private float catrom1d(float x) { x = java.lang.Math.abs(x);
                                      float x2 = x * x;
                                      float x3 = x * x2;
                                      if (x >= 2) return 0;
                                      if (x < 1) return 3 * x3 - 5 * x2 +
                                                   2;
                                      return -x3 + 5 * x2 - 8 * x + 4; }
    public CatmullRomFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4C8wEALmy6CakFtoQ9vINAUcO5icwcIE" +
                                                              "NablGO/N3S3e2112Z+2zCW0SpYJ+UUSA0KrhL6ImURJQ1ait2kRUkZpESSsl" +
                                                              "ipqkVUilVir9QA2qlPxB2/S9md3bj7ONqJqTbm5v5s2b99785vfe7DNXSY1j" +
                                                              "ky5m8BSfspiT6jf4MLUdlu3TqePsgb6M+lgV/ef+KzvvTJLaUdJSoM6QSh02" +
                                                              "oDE964ySZZrhcGqozNnJWBZnDNvMYfYE5ZppjJJOzRksWrqmanzIzDIU2Evt" +
                                                              "NGmnnNvamMvZoKeAk2VpsEQRlihb48O9adKsmtZUIL44JN4XGkHJYrCWw0lb" +
                                                              "+iCdoIrLNV1Jaw7vLdnkNsvUp/K6yVOsxFMH9U1eCHakN1WEYNXF1g+vnyi0" +
                                                              "iRDMp4ZhcuGes5s5pj7BsmnSGvT266zoHCJfJVVp0hQS5qQ77S+qwKIKLOp7" +
                                                              "G0iB9fOY4Rb7TOEO9zXVWioaxMnKqBKL2rToqRkWNoOGeu75LiaDtyvK3kov" +
                                                              "K1w8fZty6rH9bT+qIq2jpFUzRtAcFYzgsMgoBJQVx5jtbM1mWXaUtBuw2SPM" +
                                                              "1qiuTXs73eFoeYNyF7bfDwt2uhazxZpBrGAfwTfbVblpl93LCUB5/2pyOs2D" +
                                                              "rwsDX6WHA9gPDjZqYJido4A7b0r1uGZkOVken1H2sfteEICpdUXGC2Z5qWqD" +
                                                              "QgfpkBDRqZFXRgB6Rh5Ea0wAoM3JklmVYqwtqo7TPMsgImNyw3IIpBpEIHAK" +
                                                              "J51xMaEJdmlJbJdC+3N15+bjh43tRpIkwOYsU3W0vwkmdcUm7WY5ZjM4B3Ji" +
                                                              "87r0GbrwhWNJQkC4MyYsZX7ywLUt67suvSJlbp1BZtfYQabyjHp+rOWNpX09" +
                                                              "d1ahGfWW6Wi4+RHPxSkb9kZ6SxYwzMKyRhxM+YOXdv/q/gefZn9LksZBUqua" +
                                                              "ulsEHLWrZtHSdGbfwwxmU86yg6SBGdk+MT5I6uA5rRlM9u7K5RzGB0m1Lrpq" +
                                                              "TfEfQpQDFRiiRnjWjJzpP1uUF8RzySKE1MGXKPCtIfIjfjm5XymYRaZQlRqa" +
                                                              "YSrDton+OwowzhjEtqA4rpHTzUnFsVXFtPPl/6ppMwXWBtwofZQXXV3fbRYH" +
                                                              "REcKIWZ9kspL6Nn8yUQCgr40fuR1OC3bTT3L7Ix6yt3Wf+25zGsSTngEvJhw" +
                                                              "8ilYMeWtmMIVU3LFVHxFkkiIhRbgynJnYV/G4YQDxTb3jHxlx4Fjq6oAUtZk" +
                                                              "NQQVRVdFUk1fQAM+d2fUCx3zplde3vhSklSnSQdVuUt1zBxb7TxwkjruHdvm" +
                                                              "MUhCQS5YEcoFmMRsU2VZoKLZcoKnpd6cYDb2c7IgpMHPVHgmldnzxIz2k0tn" +
                                                              "Jx/a+7UNSZKM0j8uWQPMhdOHkbTL5NwdP/Yz6W09euXDC2eOmAEBRPKJnwYr" +
                                                              "ZqIPq+JQiIcno65bQZ/PvHCkW4S9AQiaUzhQwH1d8TUi/NLrczX6Ug8O50y7" +
                                                              "SHUc8mPcyAu2ORn0CIy2Y9Mp4YoQihkoaP4LI9bj7/zmL58RkfQzQmsolY8w" +
                                                              "3htiIVTWIfimPUDkHpsxkHvv7PCjp68e3SfgCBKrZ1qwG9s+YB/YHYjg1185" +
                                                              "9O77l8+/lQwgzCENu2NQzZSELws+hk8Cvv/BLzIHdkgG6ejzaGxFmccsXHlt" +
                                                              "YBswmg4HH8HRfZ8BMNRyGh3TGZ6ff7Wu2fj834+3ye3WocdHy/obKwj6b9lG" +
                                                              "Hnxt/0ddQk1CxYwaxC8QkzQ9P9C81bbpFNpReujNZd97mT4OhA8k62jTTPAm" +
                                                              "EfEgYgM3iVhsEO0dsbHPYbPGCWM8eoxClU9GPfHWB/P2fvDiNWFttHQK7/sQ" +
                                                              "tXoliuQuwGIbiNdEeBxHF1rYLiqBDYviRLWdOgVQdselnV9u0y9dh2VHYVkV" +
                                                              "igpnlw08WYpAyZOuqfvdL19aeOCNKpIcII26SbMDVBw40gBIZ04BKLZkfXGL" +
                                                              "tGOyHpo2EQ9SEaGKDtyF5TPvb3/R4mJHpn+66Mebf3jusoClJXXcGla4VrQ9" +
                                                              "2KyXsMXH20vlYIlP7RzBCulMiOfFnCyqSAsyC2Bgl81Wt4ia6/zDp85ldz2x" +
                                                              "UVYXHdFaoB9K3Wd/++/XU2f/8OoMyaiBm9btOptgesimKlwykkmGREkXsNl7" +
                                                              "LSf/+LPu/LabSSLY13WDNIH/l4MT62ZPCnFTXn74r0v23FU4cBP5YHksnHGV" +
                                                              "Tw098+o9a9WTSVG/ylRQUfdGJ/WGAwuL2gwKdQPdxJ554jStLgOkHfGw2AOJ" +
                                                              "D5bIaZLELdCGTX95qsBh4xxT5yCLL80xNorNCCd1ecZHgIWixQTu7Yg75kDi" +
                                                              "14qQDCa84vfTwwfUY93Df5LQu2WGCVKu80nlO3vfPvi62KR6REU5NCFEAHpC" +
                                                              "KawNmxTCv2eOq2TUHuVIx/vjP7jyrLQnXrnHhNmxU9/8OHX8lDwW8nqzuuKG" +
                                                              "EZ4jrzgx61bOtYqYMfDnC0d+/uSRo0kv1vdyTLcm5eWdSJQruAXRGEpL7/5G" +
                                                              "6y9OdFQNwHEbJPWuoR1y2WA2Crk6xx0LBTW4DwUA9GzGHMpJYp1Pbp/HZo98" +
                                                              "3vw/8ip2bLNE/64ozBd4ePVxe5Mwn21qDMpJYUgS/+4XjVDtzAF4Fxu4WVUB" +
                                                              "4MWMIBbmJxCLDhxbAt8Wz6GWOWJRkWDgXFq2NgFFTikaoqY5NMacTwS5Skbn" +
                                                              "4Tmi8wg2hzmpVym3zeLGbCxED/w/QlTipC1+6cEMvbjiZYp8AaA+d661ftG5" +
                                                              "+94Waad8SW8GSsmBjtBhCB+MWstmOU141SyrGkv8fHumnCuvYhxfl+CDsPxb" +
                                                              "Uv67YG1cnpNq/AmLneSkKSTG8WCKp7DQacAdCOHjGcuvANpEYYJvSFLydUAp" +
                                                              "UVl8iOh33ij65SnhShzJU7zN8vnFle+z4E54bsfOw9c++4S8Cag6nZ5GLU3A" +
                                                              "KvK+UU6dK2fV5uuq3d5zveViwxqf7CI3kbBtAgMASFG1L4mVxk53uUJ+9/zm" +
                                                              "F399rPZNoOl9JEE5mb8v9C5JRgrqaxdqln3pSvaEMkPU7L0935+6a33uH78X" +
                                                              "dZ3Htktnl8+oo4++M3hx/KMt4vVJDfA4K42SRs25e8rYzdQJO0LFLYhGiu+1" +
                                                              "RBy88M0r9+KVkJNVleml8iINNe8ks7eZrpH1yLwp6Im8VvOrDdeyYhOCnlBG" +
                                                              "zUv+x+gD/jLpIcvy71O6Jc5kYSa2KIjJT4lHbJ7+L8UQYC3YFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "B2/4nWe/mZ+H/i/X027oRyEAAA==");
}
