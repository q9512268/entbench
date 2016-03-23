package org.sunflow.image;
public final class ChromaticitySpectrum extends org.sunflow.image.SpectralCurve {
    private static final float[] S0Amplitudes = { 0.04F, 6.0F, 29.6F, 55.3F,
    57.3F,
    61.8F,
    61.5F,
    68.8F,
    63.4F,
    65.8F,
    94.8F,
    104.8F,
    105.9F,
    96.8F,
    113.9F,
    125.6F,
    125.5F,
    121.3F,
    121.3F,
    113.5F,
    113.1F,
    110.8F,
    106.5F,
    108.8F,
    105.3F,
    104.4F,
    100.0F,
    96.0F,
    95.1F,
    89.1F,
    90.5F,
    90.3F,
    88.4F,
    84.0F,
    85.1F,
    81.9F,
    82.6F,
    84.9F,
    81.3F,
    71.9F,
    74.3F,
    76.4F,
    63.3F,
    71.7F,
    77.0F,
    65.2F,
    47.7F,
    68.6F,
    65.0F,
    66.0F,
    61.0F,
    53.3F,
    58.9F,
    61.9F };
    private static final float[] S1Amplitudes = { 0.02F, 4.5F, 22.4F, 42.0F,
    40.6F,
    41.6F,
    38.0F,
    42.4F,
    38.5F,
    35.0F,
    43.4F,
    46.3F,
    43.9F,
    37.1F,
    36.7F,
    35.9F,
    32.6F,
    27.9F,
    24.3F,
    20.1F,
    16.2F,
    13.2F,
    8.6F,
    6.1F,
    4.2F,
    1.9F,
    0.0F,
    -1.6F,
    -3.5F,
    -3.5F,
    -5.8F,
    -7.2F,
    -8.6F,
    -9.5F,
    -10.9F,
    -10.7F,
    -12.0F,
    -14.0F,
    -13.6F,
    -12.0F,
    -13.3F,
    -12.9F,
    -10.6F,
    -11.6F,
    -12.2F,
    -10.2F,
    -7.8F,
    -11.2F,
    -10.4F,
    -10.6F,
    -9.7F,
    -8.3F,
    -9.3F,
    -9.8F };
    private static final float[] S2Amplitudes = { 0.0F, 2.0F, 4.0F, 8.5F,
    7.8F,
    6.7F,
    5.3F,
    6.1F,
    3.0F,
    1.2F,
    -1.1F,
    -0.5F,
    -0.7F,
    -1.2F,
    -2.6F,
    -2.9F,
    -2.8F,
    -2.6F,
    -2.6F,
    -1.8F,
    -1.5F,
    -1.3F,
    -1.2F,
    -1.0F,
    -0.5F,
    -0.3F,
    0.0F,
    0.2F,
    0.5F,
    2.1F,
    3.2F,
    4.1F,
    4.7F,
    5.1F,
    6.7F,
    7.3F,
    8.6F,
    9.8F,
    10.2F,
    8.3F,
    9.6F,
    8.5F,
    7.0F,
    7.6F,
    8.0F,
    6.7F,
    5.2F,
    7.4F,
    6.8F,
    7.0F,
    6.4F,
    5.5F,
    6.1F,
    6.5F };
    private static final org.sunflow.image.RegularSpectralCurve kS0Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S0Amplitudes,
      300,
      830);
    private static final org.sunflow.image.RegularSpectralCurve kS1Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S1Amplitudes,
      300,
      830);
    private static final org.sunflow.image.RegularSpectralCurve kS2Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S2Amplitudes,
      300,
      830);
    private static final org.sunflow.image.XYZColor S0xyz = kS0Spectrum.toXYZ(
                                                                          );
    private static final org.sunflow.image.XYZColor S1xyz = kS1Spectrum.toXYZ(
                                                                          );
    private static final org.sunflow.image.XYZColor S2xyz = kS2Spectrum.toXYZ(
                                                                          );
    private final float M1;
    private final float M2;
    public ChromaticitySpectrum(float x, float y) { super();
                                                    M1 = (-1.3515F - 1.7703F *
                                                            x +
                                                            5.9114F *
                                                            y) / (0.0241F +
                                                                    0.2562F *
                                                                    x -
                                                                    0.7341F *
                                                                    y);
                                                    M2 = (0.03F - 31.4424F *
                                                            x +
                                                            30.0717F *
                                                            y) / (0.0241F +
                                                                    0.2562F *
                                                                    x -
                                                                    0.7341F *
                                                                    y); }
    public float sample(float lambda) { return kS0Spectrum.sample(lambda) +
                                          M1 *
                                          kS1Spectrum.
                                          sample(
                                            lambda) +
                                          M2 *
                                          kS2Spectrum.
                                          sample(
                                            lambda); }
    public static final org.sunflow.image.XYZColor get(float x, float y) {
        float M1 =
          (-1.3515F -
             1.7703F *
             x +
             5.9114F *
             y) /
          (0.0241F +
             0.2562F *
             x -
             0.7341F *
             y);
        float M2 =
          (0.03F -
             31.4424F *
             x +
             30.0717F *
             y) /
          (0.0241F +
             0.2562F *
             x -
             0.7341F *
             y);
        float X =
          S0xyz.
          getX(
            ) +
          M1 *
          S1xyz.
          getX(
            ) +
          M2 *
          S2xyz.
          getX(
            );
        float Y =
          S0xyz.
          getY(
            ) +
          M1 *
          S1xyz.
          getY(
            ) +
          M2 *
          S2xyz.
          getY(
            );
        float Z =
          S0xyz.
          getZ(
            ) +
          M1 *
          S1xyz.
          getZ(
            ) +
          M2 *
          S2xyz.
          getZ(
            );
        return new org.sunflow.image.XYZColor(
          X,
          Y,
          Z);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZC2wcxRmeOzu240f8yMs4cV52ghLgLnahJDKEJMYhTs+J" +
                                                              "ZYeoODTOem/uvPHe7rI7Z59Nw6tqk74QhRBoC5aqhkdRSBAqfYgCqVB5CEoL" +
                                                              "pQWKgD5oC01RSatCW9rS/5/ZvX3c7aWxykk7tzs78898//z/988/e/QdMssy" +
                                                              "yRKqsRibNKgV69FYv2RaNNmtSpa1E+qG5dvKpL/ueWv7+iipGCJzRiWrT5Ys" +
                                                              "ukWhatIaIq2KZjFJk6m1ndIk9ug3qUXNcYkpujZE5itWb8ZQFVlhfXqSYoNd" +
                                                              "kpkgjRJjpjKSZbTXFsBIawJmEucziW8Kvu5KkFpZNybd5s2e5t2eN9gy445l" +
                                                              "MdKQ2CeNS/EsU9R4QrFYV84k5xi6OplWdRajORbbp15gq2Bb4oICFax4oP69" +
                                                              "D24abeAqmCtpms44PGuAWro6TpMJUu/W9qg0Y11FriFlCVLjacxIe8IZNA6D" +
                                                              "xmFQB63bCmZfR7VsplvncJgjqcKQcUKMLPcLMSRTythi+vmcQUIVs7HzzoB2" +
                                                              "WR6tQFkA8dZz4odu29PwYBmpHyL1ijaI05FhEgwGGQKF0swINa1NySRNDpFG" +
                                                              "DRZ7kJqKpCpT9ko3WUpak1gWlt9RC1ZmDWryMV1dwToCNjMrM93Mw0txg7Kf" +
                                                              "ZqVUKQ1YF7hYBcItWA8AqxWYmJmSwO7sLuVjipZkZGmwRx5j+yegAXStzFA2" +
                                                              "queHKtckqCBNwkRUSUvHB8H0tDQ0naWDAZqMtIQKRV0bkjwmpekwWmSgXb94" +
                                                              "Ba1mc0VgF0bmB5txSbBKLYFV8qzPO9svuvFqbasWJRGYc5LKKs6/BjotCXQa" +
                                                              "oClqUvAD0bF2TeKwtOCRg1FCoPH8QGPR5rufPrXx3CUnnhJtFhVps2NkH5XZ" +
                                                              "sHxkZM7zi7tXry/DaVQZuqXg4vuQcy/rt9905QxgmAV5ifgy5rw8MfDEFdfd" +
                                                              "R09GSXUvqZB1NZsBO2qU9YyhqNS8jGrUlBhN9pLZVEt28/e9pBLuE4pGRe2O" +
                                                              "VMqirJeUq7yqQufPoKIUiEAVVcO9oqV0596Q2Ci/zxmEkDq4SBNclUT8+D8j" +
                                                              "A/FRPUPjhhLvN3WEbsWBbEZAraNxK6ulVH0ibplyXDfT+WclA0sd7x419Qz6" +
                                                              "jsImBw3oaWYzMbQt4yORmkMscyciEVDz4qCTq+AfW3U1Sc1h+VB2c8+pY8PP" +
                                                              "CANCo7e1wMgqGC9mjxfj48WKjUciET7MPBxXrCSswxh4NFBq7erBT23be3BF" +
                                                              "GZiQMVEOSsSmK3yhpdt1e4erh+XjTXVTy1/veDxKyhOkSZJZVlIxUmwy08BB" +
                                                              "8pjtprUjEHRc7l/m4X4MWqYu0yRQT1gMsKVU6ePUxHpG5nkkOJEJfTAeHheK" +
                                                              "zp+cuH3i+l3Xro2SqJ/ucchZwFTYvR9JOk/G7UE3Lya3/sBb7x0/vF93Hd4X" +
                                                              "P5ywV9ATMawIGkJQPcPymmXSQ8OP7G/nap8NhMwkcCDguiXBMXx80uVwM2Kp" +
                                                              "AsAp3cxIKr5ydFzNwHYm3BpuoY38fh6YRQ062FK4Vtsex//x7QIDy4XCotHO" +
                                                              "Aig49188aNz58nNvf4yr2wkT9Z74PkhZl4eaUFgTJ6FG12x3mpRCu9du77/l" +
                                                              "1ncO7OY2Cy3aig3YjmU3UBIsIaj5s09d9cobrx95MeraOYPYnB2BLU4uDxLr" +
                                                              "SXUJkDDaKnc+QG0q+BhaTfvlGtinklKkEZWiY/2rfmXHQ3+6sUHYgQo1jhmd" +
                                                              "e3oBbv1Zm8l1z+x5fwkXE5ExtLo6c5sJvp7rSt5kmtIkziN3/QutX31SuhOY" +
                                                              "H9jWUqYoJ9Ao10HU7+voT4PZEQv8UsnAMozbsaizf698sL3/TRFnzirSQbSb" +
                                                              "f2/8y7te2vcsX+Qq9HysR9x1Hr8GhvBYWINQ/ofwi8D1H7xQ6VghOL2p2w4s" +
                                                              "y/KRxTByMPPVJbaCfgDx/U1vjN3x1v0CQDDyBhrTg4e+8GHsxkNi5cT2pK1g" +
                                                              "h+DtI7YoAg4W63F2y0uNwnts+cPx/Q/fu/+AmFWTP9j2wF7y/l/8+9nY7b96" +
                                                              "ugj3gwvpkthkno/GnKfuef7VEZAu/Xz9D25qKtsCrNFLqrKaclWW9ia9MmF/" +
                                                              "ZWVHPMvlbnx4hRccLg0jkTWwClixjpcX8Lmszc+I8BkR/m4rFistL4P6V8yz" +
                                                              "jx6Wb3rx3bpd7z56iqP2b8S9hNEnGULljVisQpUvDEa4rZI1Cu3OP7H9ygb1" +
                                                              "xAcgcQgkyrD7tHaYEF5zPnqxW8+q/OUPH1+w9/kyEt1CqkHNyS0SZ2oyGyiS" +
                                                              "WqMQmXPGJRsFQ0xUQdHAoZIC8AUV6KVLi/t/T8Zg3GOnvrfw2xfdM/06pypD" +
                                                              "yFjE+9fgZsEXmnk650aH+3524c/v+crhCWFRJfwj0K/5nzvUkRt+8/cClfNg" +
                                                              "WMRlAv2H4kfvaOnecJL3d6MS9m7PFW5wILK7fTvvy/wtuqLiR1FSOUQaZDt9" +
                                                              "2iWpWeT6IUgZLCenghTL996//Rd73a581F0c9FnPsMF46HWEcuYzejcEnoVL" +
                                                              "uAGuOXZ0qAqGwAjhN0O8y9m8XIPFeXz5yhipNEwFUmyYeYXFMzX0ZEWT1EAM" +
                                                              "anakFxmFkdrBtZswOWfZJFiy7yQgz8g8AAjvv7Lmicesb/7+QWEVxfg+kHvc" +
                                                              "e0+V/GrmCc73OOSF+clx5HPharEn1yI4enAGO2RZN6GHw4rxnZCVammV9oGH" +
                                                              "ORvvj0IsEsXKcM/w6G367rbnrp1u+zWnjSrFAvuB2FUk3/P0effoGydfqGs9" +
                                                              "xvdn5RgCbT71J8qFebAvveVar8ciJSi2gOjxeadoYBtdprjRRfE2hsVeLmo9" +
                                                              "mJ5KtTQb5S277HiFf5cwUgbzwtsxw+UuZ6uAz83M3mSgx0Geq2sU9yvOO5Fi" +
                                                              "KHosf8YAL3NFolSrj8X6OHSXEl6bc/Nvv9+e3nwmuQXWLTlN9oDPS2H91oQv" +
                                                              "f3AqT97wx5adG0b3nkGasDRgHUGR3+o7+vRlq+Sbo/wYQ3BVwfGHv1OXn6Gq" +
                                                              "TcqypuYPzm2uuYwJU8DiHL6+JWLz9SXefQaLa4CiZFxoYRclmn+uMNxhxYDh" +
                                                              "iYy2CeBjj50xYNmLxW5hKYnQ0LrTT8Xr4Vpg81BDCBV/MYSK8XYPFsPCNQrp" +
                                                              "tyFEMtJvh0u/WEcDQL50hkAuhqvVHq45BMgtMwbSHCIZgXSWBnLoDIFkiMgR" +
                                                              "ifNfBMjXZwwkTDIjNWODa53jDoeLipyODNB0VpVM0VJSu7PmeBDxHTNAvMye" +
                                                              "17IQxHfNGHGYZI64w0GMVd8I4Lh7BjiW26MtD8Fx/4xxhEnmODpL4Th2hjhw" +
                                                              "e9Zmj9YWguOhGeMIkwwUObg2Nznl2F5Loe198ooh2O3rZgDfd2aAr92eRXsI" +
                                                              "vsdmjC9MMuLrAHz48HAAwYkZIFhpj7MyBMGTM0YQJhkRdIYgeOp/R4BHzpx/" +
                                                              "zrbHOTsEwU9K7Mb2FJt8YwmhjET7OvBuXWDmP/0IZv4SFs/jkJ3Fhny5xJC5" +
                                                              "029B8/Phv1oSOMH3zMeT9xLcs7eGfWThZylHbjg0ndxxV4eTsmxkkK3rxnkq" +
                                                              "HaeqR5TYxk7lp4FqJwvhitnTiAXV4uIXG6rCw8KwroGtkmfrI45M3i6xlzqJ" +
                                                              "xZuYJkoQoXmUWucuwu9Ot+6lDyGwYsAIaIJzMzp+pw2ns4QminpmLNQzF5YQ" +
                                                              "G1BC1DWZda6q3i+hqn9gcQpylzTlucvDrp7+8v/QUw7ymmLfVfAsp7ng+6z4" +
                                                              "pigfm66vWjh9+UsiD3S++9VCMpLKqqr3tMFzX2GYNKVwULXi7IGfsEUijDQW" +
                                                              "RBRgNP6P0wbX5Q3LIaB6GjI81ON33kaVoCpohLdVhhOxlhZGLN82KRfx+2Ne" +
                                                              "xfNPp2KPC7f58i7+BdzJkbLiG/iwfHx62/arT338LvGhQFalKc7ZNZAhi28W" +
                                                              "+Txreag0R1bF1tUfzHlg9kqHFBrFhF07XuQxowHwTQPXtCVwim615w/TXzly" +
                                                              "0aM/PljxQpREdpOIBMnw7sIDqJyRBbbanSg8iIWclB/vd63+2uSGc1N/fpUf" +
                                                              "8RGREi8Obz8sD93ycu8DY+9v5J9cZwHf0Rw/Gbt0Uhug8rjpO9Wdg+Ym4bdw" +
                                                              "rgdbfXX5WvysxMiKwiPtwo9x1WAO1NysZ7UkiqmDHNitcfJrX2qaNYxAB7fG" +
                                                              "XjosL8VifQ61D+Y4nOgzDPvEP7LK4I7XE5ozRhbxW7xb/F8NQ0+4DCMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "h51wNZRYOK130ToRbJzAq8WV3dIxpgHdSOImQs9NFJ5UZUVxu/lW8bshlSVb" +
       "B+fV1mZG1AakT8ubRpIUl1NISR9MdUQdG5ksbt11M9p6gcHzSgfRwoXM2C5l" +
       "D/BhNOM2+BQhiJ5OK7iUztXNLo3CLK3MY6EeN3YkyqIgTsiqXdlHQAiXJ+Mx" +
       "TuvDnhsq5LrBoCPataaBQa7q49501bHqGwkeJQlVkVEntWNutWRm1ohy25Mp" +
       "0qNqLpcoaMOfUUSa4eK2W92gjtkVwzav9uZdHq24wAXxll+Zblw4XXNoc5Eq" +
       "3V5SG6+cetefSX7uxevJzkbieJ0O5mRb7zH1ymDJ7KjpSlY4kRGxli7Qmbvm" +
       "Jct2KjE7yrRs3db0dQ5C0aZh4NVsPbKZbIlrw7XDVZlgNiNXAbbwVLLWbLea" +
       "C5hdT4fkaj2hw0lrxAVelNMdNhokWhUEnh2pzTF4VTMbseYni56P4U1Wjdh0" +
       "M+21+oK6mi6bDuO2+7SpsyqvKyOlyRorIQUTSbtvjJbjtoijRtuVGd3Lx+1R" +
       "s7rwFmx1MZjGxMSWm+2sNxs1EjaXa0Sfy3rKqNvrroV+HUurXXaxJfsYoxFN" +
       "Q18idTZqk3QGY1mmdRx73PYYbKYhmqGlMiXYBrVeqvFY68ps30zT+XijIqOd" +
       "YyE0zrhyjSJdV0PGaCCobWWLiI2AQmR+FfaTcGsbLYplYyZo9HYY2Ws00rUp" +
       "9GnNMwg2b7LdGVtdcwPN5Lf9tSqPPZjHmr2dl8G7YNMbz8JOOqeGBLtB6EFE" +
       "rlNbM0CgMk6a8WrZtidwtS8k2JQOYcMcoLTm5Hg2aOFVhGqS8ERLau50zPbQ" +
       "HSvPqIyRQkLuKsuZJuRWb2OoVWebZQtMnoV2ZppD4Fgd0++Jss/js3VmEpaH" +
       "0f4gTTQ9cmZ6Y7XA4v6qWw9aKTlMA7cbmbYS9DGcRfV6Zu38QSbE64Hpcu7K" +
       "ni9jKU5jahxV6lY776brsAEWToMdCwIaL0WcEONs3fFsZsTtaHzNdWvNVq29" +
       "FLZi3QfRjuY7FPDXXm7tZlYsJe3AIypkAnPzlAAxDKMslEboEY5aqe8wT1cV" +
       "u15PloZGVeah3kanlQq1aLEeM/T9AI1YerdCuuvRcJHOmZVO9LtK2JnrRptb" +
       "8k1eHU3qk2q6WeEcyvTFZr1r9MnaeISiprhwW56rMduFpo0zSxO6zIhEhryS" +
       "VZCRnCmjiYcMJy1CwUmdqDS3u4G5YfQurKdKL6sjsBjMUJRkkq7G0aI1lAhh" +
       "JDQ0HSGXlVkWyKJa5WsbuhbNlV3PUinAfroZ0BpdJVYxl7lpL51xk1XUWqS6" +
       "Xa/hKTxb7ay8KrLwxDIyzuM7W2/cb7JOSoT9tj/I+eZmIzpTldT7IHBuwsm2" +
       "jlaQeNqVaiNY8eYKyXf5jk6ONzsybFNoLsVke12hEnxASULaU6p8Cnc3UXWu" +
       "xSoZGN6YWm7VytrGNts0ULcbZbXCl0keZqw+TPVJlLogWFk2xmD1FgrE3NR9" +
       "u90b6ZGkDIIV4oujddZoEkp3ZbghQy50havX2pU15ozVXXuSdCYEM8T6BIi1" +
       "3B2vbbIlkW1gmhxx1QrWbrGNRuPDHy62HL5xb1shj5W7PicX6wyLKD7883vY" +
       "7cje/rDsZMus/BVnh+fuaJ3ZMjtzsg0VZ+/P3OkaXXnT4Mufev2N7fjnawdH" +
       "ZzZEBD0Qud5fteREts50tT9wk09glFCeBM/hEYzDizt3p/TfQtilkrA9/y6c" +
       "H106rbC/vvAf73LA9K0i+aPigFi0vf0FN/SU43/8dvtLZ7u7QF65aV/sLSNH" +
       "5CH3QN7tFeUCHQenIkZPqf3vd6H2fxTJdyLosiqXp6JfOiX1v90LqVkEvft2" +
       "N9qK6zlP3XIzdn+bU/rKG9evPfnG/F/vj8CPb1w+wEDXlNiyzl4JOJO/3wtk" +
       "RS/BP7C/IOCVf98HRnPL6UAEXSn/S7x/uq/4ZxH00JmKEXT1KHemUrFjexlU" +
       "KrIH3vFW63O3nj6cO4PKLp23kxNWPv52rDxjWi+eOzcu7x4fn/HG+9vHr0pf" +
       "fWMw+vj36j+/v1UmWeKu3Mm/xkBX9xfc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("yk6Lc+IX7tjbcV/3917+/qNfe+ClY2N9dA/4VBXPYHvu9le4OjYIjYpLV7tf" +
       "e/IffegfvPEH5Ubw/wMmpyvyFC4AAA==");
}
