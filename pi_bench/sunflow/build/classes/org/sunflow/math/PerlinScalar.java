package org.sunflow.math;
public final class PerlinScalar {
    private static final float[] G1 = { -1, 1 };
    private static final float[][] G2 = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0,
    -1 } };
    private static final float[][] G3 = { { 1, 1, 0 }, { -1, 1, 0 }, { 1,
    -1,
    0 },
    { -1,
    -1,
    0 },
    { 1,
    0,
    1 },
    { -1,
    0,
    1 },
    { 1,
    0,
    -1 },
    { -1,
    0,
    -1 },
    { 0,
    1,
    1 },
    { 0,
    -1,
    1 },
    { 0,
    1,
    -1 },
    { 0,
    -1,
    -1 },
    { 1,
    1,
    0 },
    { -1,
    1,
    0 },
    { 0,
    -1,
    1 },
    { 0,
    -1,
    -1 } };
    private static final float[][] G4 = { { -1, -1, -1, 0 }, { -1, -1, 1,
    0 },
    { -1,
    1,
    -1,
    0 },
    { -1,
    1,
    1,
    0 },
    { 1,
    -1,
    -1,
    0 },
    { 1,
    -1,
    1,
    0 },
    { 1,
    1,
    -1,
    0 },
    { 1,
    1,
    1,
    0 },
    { -1,
    -1,
    0,
    -1 },
    { -1,
    1,
    0,
    -1 },
    { 1,
    -1,
    0,
    -1 },
    { 1,
    1,
    0,
    -1 },
    { -1,
    -1,
    0,
    1 },
    { -1,
    1,
    0,
    1 },
    { 1,
    -1,
    0,
    1 },
    { 1,
    1,
    0,
    1 },
    { -1,
    0,
    -1,
    -1 },
    { 1,
    0,
    -1,
    -1 },
    { -1,
    0,
    -1,
    1 },
    { 1,
    0,
    -1,
    1 },
    { -1,
    0,
    1,
    -1 },
    { 1,
    0,
    1,
    -1 },
    { -1,
    0,
    1,
    1 },
    { 1,
    0,
    1,
    1 },
    { 0,
    -1,
    -1,
    -1 },
    { 0,
    -1,
    -1,
    1 },
    { 0,
    -1,
    1,
    -1 },
    { 0,
    -1,
    1,
    1 },
    { 0,
    1,
    -1,
    -1 },
    { 0,
    1,
    -1,
    1 },
    { 0,
    1,
    1,
    -1 },
    { 0,
    1,
    1,
    1 } };
    private static final int[] p = { 151, 160, 137, 91, 90, 15, 131, 13, 201,
    95,
    96,
    53,
    194,
    233,
    7,
    225,
    140,
    36,
    103,
    30,
    69,
    142,
    8,
    99,
    37,
    240,
    21,
    10,
    23,
    190,
    6,
    148,
    247,
    120,
    234,
    75,
    0,
    26,
    197,
    62,
    94,
    252,
    219,
    203,
    117,
    35,
    11,
    32,
    57,
    177,
    33,
    88,
    237,
    149,
    56,
    87,
    174,
    20,
    125,
    136,
    171,
    168,
    68,
    175,
    74,
    165,
    71,
    134,
    139,
    48,
    27,
    166,
    77,
    146,
    158,
    231,
    83,
    111,
    229,
    122,
    60,
    211,
    133,
    230,
    220,
    105,
    92,
    41,
    55,
    46,
    245,
    40,
    244,
    102,
    143,
    54,
    65,
    25,
    63,
    161,
    1,
    216,
    80,
    73,
    209,
    76,
    132,
    187,
    208,
    89,
    18,
    169,
    200,
    196,
    135,
    130,
    116,
    188,
    159,
    86,
    164,
    100,
    109,
    198,
    173,
    186,
    3,
    64,
    52,
    217,
    226,
    250,
    124,
    123,
    5,
    202,
    38,
    147,
    118,
    126,
    255,
    82,
    85,
    212,
    207,
    206,
    59,
    227,
    47,
    16,
    58,
    17,
    182,
    189,
    28,
    42,
    223,
    183,
    170,
    213,
    119,
    248,
    152,
    2,
    44,
    154,
    163,
    70,
    221,
    153,
    101,
    155,
    167,
    43,
    172,
    9,
    129,
    22,
    39,
    253,
    19,
    98,
    108,
    110,
    79,
    113,
    224,
    232,
    178,
    185,
    112,
    104,
    218,
    246,
    97,
    228,
    251,
    34,
    242,
    193,
    238,
    210,
    144,
    12,
    191,
    179,
    162,
    241,
    81,
    51,
    145,
    235,
    249,
    14,
    239,
    107,
    49,
    192,
    214,
    31,
    181,
    199,
    106,
    157,
    184,
    84,
    204,
    176,
    115,
    121,
    50,
    45,
    127,
    4,
    150,
    254,
    138,
    236,
    205,
    93,
    222,
    114,
    67,
    29,
    24,
    72,
    243,
    141,
    128,
    195,
    78,
    66,
    215,
    61,
    156,
    180,
    151,
    160,
    137,
    91,
    90,
    15,
    131,
    13,
    201,
    95,
    96,
    53,
    194,
    233,
    7,
    225,
    140,
    36,
    103,
    30,
    69,
    142,
    8,
    99,
    37,
    240,
    21,
    10,
    23,
    190,
    6,
    148,
    247,
    120,
    234,
    75,
    0,
    26,
    197,
    62,
    94,
    252,
    219,
    203,
    117,
    35,
    11,
    32,
    57,
    177,
    33,
    88,
    237,
    149,
    56,
    87,
    174,
    20,
    125,
    136,
    171,
    168,
    68,
    175,
    74,
    165,
    71,
    134,
    139,
    48,
    27,
    166,
    77,
    146,
    158,
    231,
    83,
    111,
    229,
    122,
    60,
    211,
    133,
    230,
    220,
    105,
    92,
    41,
    55,
    46,
    245,
    40,
    244,
    102,
    143,
    54,
    65,
    25,
    63,
    161,
    1,
    216,
    80,
    73,
    209,
    76,
    132,
    187,
    208,
    89,
    18,
    169,
    200,
    196,
    135,
    130,
    116,
    188,
    159,
    86,
    164,
    100,
    109,
    198,
    173,
    186,
    3,
    64,
    52,
    217,
    226,
    250,
    124,
    123,
    5,
    202,
    38,
    147,
    118,
    126,
    255,
    82,
    85,
    212,
    207,
    206,
    59,
    227,
    47,
    16,
    58,
    17,
    182,
    189,
    28,
    42,
    223,
    183,
    170,
    213,
    119,
    248,
    152,
    2,
    44,
    154,
    163,
    70,
    221,
    153,
    101,
    155,
    167,
    43,
    172,
    9,
    129,
    22,
    39,
    253,
    19,
    98,
    108,
    110,
    79,
    113,
    224,
    232,
    178,
    185,
    112,
    104,
    218,
    246,
    97,
    228,
    251,
    34,
    242,
    193,
    238,
    210,
    144,
    12,
    191,
    179,
    162,
    241,
    81,
    51,
    145,
    235,
    249,
    14,
    239,
    107,
    49,
    192,
    214,
    31,
    181,
    199,
    106,
    157,
    184,
    84,
    204,
    176,
    115,
    121,
    50,
    45,
    127,
    4,
    150,
    254,
    138,
    236,
    205,
    93,
    222,
    114,
    67,
    29,
    24,
    72,
    243,
    141,
    128,
    195,
    78,
    66,
    215,
    61,
    156,
    180 };
    public static final float snoise(float x) { int xf = (int) java.lang.Math.
                                                           floor(
                                                             x);
                                                int X = xf & 255;
                                                x -= xf;
                                                float u = fade(x);
                                                int A = p[X];
                                                int B = p[X + 1];
                                                return lerp(u, grad(p[A],
                                                                    x), grad(
                                                                          p[B],
                                                                          x -
                                                                            1));
    }
    public static final float snoise(float x, float y) { int xf = (int) java.lang.Math.
                                                                    floor(
                                                                      x);
                                                         int yf =
                                                           (int)
                                                             java.lang.Math.
                                                             floor(
                                                               y);
                                                         int X = xf &
                                                           255;
                                                         int Y = yf &
                                                           255;
                                                         x -= xf;
                                                         y -= yf;
                                                         float u =
                                                           fade(
                                                             x);
                                                         float v =
                                                           fade(
                                                             y);
                                                         int A = p[X] +
                                                           Y;
                                                         int B = p[X +
                                                                     1] +
                                                           Y;
                                                         return lerp(
                                                                  v,
                                                                  lerp(
                                                                    u,
                                                                    grad(
                                                                      p[A],
                                                                      x,
                                                                      y),
                                                                    grad(
                                                                      p[B],
                                                                      x -
                                                                        1,
                                                                      y)),
                                                                  lerp(
                                                                    u,
                                                                    grad(
                                                                      p[A +
                                                                          1],
                                                                      x,
                                                                      y -
                                                                        1),
                                                                    grad(
                                                                      p[B +
                                                                          1],
                                                                      x -
                                                                        1,
                                                                      y -
                                                                        1)));
    }
    public static final float snoise(float x, float y, float z) {
        int xf =
          (int)
            java.lang.Math.
            floor(
              x);
        int yf =
          (int)
            java.lang.Math.
            floor(
              y);
        int zf =
          (int)
            java.lang.Math.
            floor(
              z);
        int X =
          xf &
          255;
        int Y =
          yf &
          255;
        int Z =
          zf &
          255;
        x -=
          xf;
        y -=
          yf;
        z -=
          zf;
        float u =
          fade(
            x);
        float v =
          fade(
            y);
        float w =
          fade(
            z);
        int A =
          p[X] +
          Y;
        int AA =
          p[A] +
          Z;
        int AB =
          p[A +
              1] +
          Z;
        int B =
          p[X +
              1] +
          Y;
        int BA =
          p[B] +
          Z;
        int BB =
          p[B +
              1] +
          Z;
        return lerp(
                 w,
                 lerp(
                   v,
                   lerp(
                     u,
                     grad(
                       p[AA],
                       x,
                       y,
                       z),
                     grad(
                       p[BA],
                       x -
                         1,
                       y,
                       z)),
                   lerp(
                     u,
                     grad(
                       p[AB],
                       x,
                       y -
                         1,
                       z),
                     grad(
                       p[BB],
                       x -
                         1,
                       y -
                         1,
                       z))),
                 lerp(
                   v,
                   lerp(
                     u,
                     grad(
                       p[AA +
                           1],
                       x,
                       y,
                       z -
                         1),
                     grad(
                       p[BA +
                           1],
                       x -
                         1,
                       y,
                       z -
                         1)),
                   lerp(
                     u,
                     grad(
                       p[AB +
                           1],
                       x,
                       y -
                         1,
                       z -
                         1),
                     grad(
                       p[BB +
                           1],
                       x -
                         1,
                       y -
                         1,
                       z -
                         1))));
    }
    public static final float snoise(float x, float y, float z, float w) {
        int xf =
          (int)
            java.lang.Math.
            floor(
              x);
        int yf =
          (int)
            java.lang.Math.
            floor(
              y);
        int zf =
          (int)
            java.lang.Math.
            floor(
              z);
        int wf =
          (int)
            java.lang.Math.
            floor(
              w);
        int X =
          xf &
          255;
        int Y =
          yf &
          255;
        int Z =
          zf &
          255;
        int W =
          wf &
          255;
        x -=
          xf;
        y -=
          yf;
        z -=
          zf;
        w -=
          wf;
        float u =
          fade(
            x);
        float v =
          fade(
            y);
        float t =
          fade(
            z);
        float s =
          fade(
            w);
        int A =
          p[X] +
          Y;
        int AA =
          p[A] +
          Z;
        int AB =
          p[A +
              1] +
          Z;
        int B =
          p[X +
              1] +
          Y;
        int BA =
          p[B] +
          Z;
        int BB =
          p[B +
              1] +
          Z;
        int AAA =
          p[AA] +
          W;
        int AAB =
          p[AA +
              1] +
          W;
        int ABA =
          p[AB] +
          W;
        int ABB =
          p[AB +
              1] +
          W;
        int BAA =
          p[BA] +
          W;
        int BAB =
          p[BA +
              1] +
          W;
        int BBA =
          p[BB] +
          W;
        int BBB =
          p[BB +
              1] +
          W;
        return lerp(
                 s,
                 lerp(
                   t,
                   lerp(
                     v,
                     lerp(
                       u,
                       grad(
                         p[AAA],
                         x,
                         y,
                         z,
                         w),
                       grad(
                         p[BAA],
                         x -
                           1,
                         y,
                         z,
                         w)),
                     lerp(
                       u,
                       grad(
                         p[ABA],
                         x,
                         y -
                           1,
                         z,
                         w),
                       grad(
                         p[BBA],
                         x -
                           1,
                         y -
                           1,
                         z,
                         w))),
                   lerp(
                     v,
                     lerp(
                       u,
                       grad(
                         p[AAB],
                         x,
                         y,
                         z -
                           1,
                         w),
                       grad(
                         p[BAB],
                         x -
                           1,
                         y,
                         z -
                           1,
                         w)),
                     lerp(
                       u,
                       grad(
                         p[ABB],
                         x,
                         y -
                           1,
                         z -
                           1,
                         w),
                       grad(
                         p[BBB],
                         x -
                           1,
                         y -
                           1,
                         z -
                           1,
                         w)))),
                 lerp(
                   t,
                   lerp(
                     v,
                     lerp(
                       u,
                       grad(
                         p[AAA +
                             1],
                         x,
                         y,
                         z,
                         w -
                           1),
                       grad(
                         p[BAA +
                             1],
                         x -
                           1,
                         y,
                         z,
                         w -
                           1)),
                     lerp(
                       u,
                       grad(
                         p[ABA +
                             1],
                         x,
                         y -
                           1,
                         z,
                         w -
                           1),
                       grad(
                         p[BBA +
                             1],
                         x -
                           1,
                         y -
                           1,
                         z,
                         w -
                           1))),
                   lerp(
                     v,
                     lerp(
                       u,
                       grad(
                         p[AAB +
                             1],
                         x,
                         y,
                         z -
                           1,
                         w -
                           1),
                       grad(
                         p[BAB +
                             1],
                         x -
                           1,
                         y,
                         z -
                           1,
                         w -
                           1)),
                     lerp(
                       u,
                       grad(
                         p[ABB +
                             1],
                         x,
                         y -
                           1,
                         z -
                           1,
                         w -
                           1),
                       grad(
                         p[BBB +
                             1],
                         x -
                           1,
                         y -
                           1,
                         z -
                           1,
                         w -
                           1)))));
    }
    public static final float snoise(org.sunflow.math.Point2 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y);
    }
    public static final float snoise(org.sunflow.math.Point3 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z);
    }
    public static final float snoise(org.sunflow.math.Point3 p, float t) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t);
    }
    public static final float noise(float x) { return 0.5F + 0.5F *
                                                 snoise(
                                                   x); }
    public static final float noise(float x, float y) { return 0.5F +
                                                          0.5F *
                                                          snoise(
                                                            x,
                                                            y); }
    public static final float noise(float x, float y, float z) { return 0.5F +
                                                                   0.5F *
                                                                   snoise(
                                                                     x,
                                                                     y,
                                                                     z);
    }
    public static final float noise(float x, float y, float z, float t) {
        return 0.5F +
          0.5F *
          snoise(
            x,
            y,
            z,
            t);
    }
    public static final float noise(org.sunflow.math.Point2 p) { return 0.5F +
                                                                   0.5F *
                                                                   snoise(
                                                                     p.
                                                                       x,
                                                                     p.
                                                                       y);
    }
    public static final float noise(org.sunflow.math.Point3 p) { return 0.5F +
                                                                   0.5F *
                                                                   snoise(
                                                                     p.
                                                                       x,
                                                                     p.
                                                                       y,
                                                                     p.
                                                                       z);
    }
    public static final float noise(org.sunflow.math.Point3 p, float t) {
        return 0.5F +
          0.5F *
          snoise(
            p.
              x,
            p.
              y,
            p.
              z,
            t);
    }
    public static final float pnoise(float xi, float period) { float x =
                                                                 xi %
                                                                 period +
                                                                 (xi <
                                                                    0
                                                                    ? period
                                                                    : 0);
                                                               return ((period -
                                                                          x) *
                                                                         noise(
                                                                           x) +
                                                                         x *
                                                                         noise(
                                                                           x -
                                                                             period)) /
                                                                 period;
    }
    public static final float pnoise(float xi, float yi, float w,
                                     float h) { float x =
                                                  xi %
                                                  w +
                                                  (xi <
                                                     0
                                                     ? w
                                                     : 0);
                                                float y =
                                                  yi %
                                                  h +
                                                  (yi <
                                                     0
                                                     ? h
                                                     : 0);
                                                float w_x =
                                                  w -
                                                  x;
                                                float h_y =
                                                  h -
                                                  y;
                                                float x_w =
                                                  x -
                                                  w;
                                                float y_h =
                                                  y -
                                                  h;
                                                return (noise(
                                                          x,
                                                          y) *
                                                          w_x *
                                                          h_y +
                                                          noise(
                                                            x_w,
                                                            y) *
                                                          x *
                                                          h_y +
                                                          noise(
                                                            x_w,
                                                            y_h) *
                                                          x *
                                                          y +
                                                          noise(
                                                            x,
                                                            y_h) *
                                                          w_x *
                                                          y) /
                                                  (w *
                                                     h); }
    public static final float pnoise(float xi, float yi, float zi,
                                     float w,
                                     float h,
                                     float d) { float x =
                                                  xi %
                                                  w +
                                                  (xi <
                                                     0
                                                     ? w
                                                     : 0);
                                                float y =
                                                  yi %
                                                  h +
                                                  (yi <
                                                     0
                                                     ? h
                                                     : 0);
                                                float z =
                                                  zi %
                                                  d +
                                                  (zi <
                                                     0
                                                     ? d
                                                     : 0);
                                                float w_x =
                                                  w -
                                                  x;
                                                float h_y =
                                                  h -
                                                  y;
                                                float d_z =
                                                  d -
                                                  z;
                                                float x_w =
                                                  x -
                                                  w;
                                                float y_h =
                                                  y -
                                                  h;
                                                float z_d =
                                                  z -
                                                  d;
                                                float xy =
                                                  x *
                                                  y;
                                                float h_yXd_z =
                                                  h_y *
                                                  d_z;
                                                float h_yXz =
                                                  h_y *
                                                  z;
                                                float w_xXy =
                                                  w_x *
                                                  y;
                                                return (noise(
                                                          x,
                                                          y,
                                                          z) *
                                                          w_x *
                                                          h_yXd_z +
                                                          noise(
                                                            x,
                                                            y_h,
                                                            z) *
                                                          w_xXy *
                                                          d_z +
                                                          noise(
                                                            x_w,
                                                            y,
                                                            z) *
                                                          x *
                                                          h_yXd_z +
                                                          noise(
                                                            x_w,
                                                            y_h,
                                                            z) *
                                                          xy *
                                                          d_z +
                                                          noise(
                                                            x_w,
                                                            y_h,
                                                            z_d) *
                                                          xy *
                                                          z +
                                                          noise(
                                                            x,
                                                            y,
                                                            z_d) *
                                                          w_x *
                                                          h_yXz +
                                                          noise(
                                                            x,
                                                            y_h,
                                                            z_d) *
                                                          w_xXy *
                                                          z +
                                                          noise(
                                                            x_w,
                                                            y,
                                                            z_d) *
                                                          x *
                                                          h_yXz) /
                                                  (w *
                                                     h *
                                                     d); }
    public static final float pnoise(float xi, float yi, float zi,
                                     float ti,
                                     float w,
                                     float h,
                                     float d,
                                     float p) { float x =
                                                  xi %
                                                  w +
                                                  (xi <
                                                     0
                                                     ? w
                                                     : 0);
                                                float y =
                                                  yi %
                                                  h +
                                                  (yi <
                                                     0
                                                     ? h
                                                     : 0);
                                                float z =
                                                  zi %
                                                  d +
                                                  (zi <
                                                     0
                                                     ? d
                                                     : 0);
                                                float t =
                                                  ti %
                                                  p +
                                                  (ti <
                                                     0
                                                     ? p
                                                     : 0);
                                                float w_x =
                                                  w -
                                                  x;
                                                float h_y =
                                                  h -
                                                  y;
                                                float d_z =
                                                  d -
                                                  z;
                                                float p_t =
                                                  p -
                                                  t;
                                                float x_w =
                                                  x -
                                                  w;
                                                float y_h =
                                                  y -
                                                  h;
                                                float z_d =
                                                  z -
                                                  d;
                                                float t_p =
                                                  t -
                                                  p;
                                                float xy =
                                                  x *
                                                  y;
                                                float d_zXp_t =
                                                  d_z *
                                                  p_t;
                                                float zXp_t =
                                                  z *
                                                  p_t;
                                                float zXt =
                                                  z *
                                                  t;
                                                float d_zXt =
                                                  d_z *
                                                  t;
                                                float w_xXy =
                                                  w_x *
                                                  y;
                                                float w_xXh_y =
                                                  w_x *
                                                  h_y;
                                                float xXh_y =
                                                  x *
                                                  h_y;
                                                return (noise(
                                                          x,
                                                          y,
                                                          z,
                                                          t) *
                                                          w_xXh_y *
                                                          d_zXp_t +
                                                          noise(
                                                            x_w,
                                                            y,
                                                            z,
                                                            t) *
                                                          xXh_y *
                                                          d_zXp_t +
                                                          noise(
                                                            x_w,
                                                            y_h,
                                                            z,
                                                            t) *
                                                          xy *
                                                          d_zXp_t +
                                                          noise(
                                                            x,
                                                            y_h,
                                                            z,
                                                            t) *
                                                          w_xXy *
                                                          d_zXp_t +
                                                          noise(
                                                            x_w,
                                                            y_h,
                                                            z_d,
                                                            t) *
                                                          xy *
                                                          zXp_t +
                                                          noise(
                                                            x,
                                                            y,
                                                            z_d,
                                                            t) *
                                                          w_xXh_y *
                                                          zXp_t +
                                                          noise(
                                                            x,
                                                            y_h,
                                                            z_d,
                                                            t) *
                                                          w_xXy *
                                                          zXp_t +
                                                          noise(
                                                            x_w,
                                                            y,
                                                            z_d,
                                                            t) *
                                                          xXh_y *
                                                          zXp_t +
                                                          noise(
                                                            x,
                                                            y,
                                                            z,
                                                            t_p) *
                                                          w_xXh_y *
                                                          d_zXt +
                                                          noise(
                                                            x_w,
                                                            y,
                                                            z,
                                                            t_p) *
                                                          xXh_y *
                                                          d_zXt +
                                                          noise(
                                                            x_w,
                                                            y_h,
                                                            z,
                                                            t_p) *
                                                          xy *
                                                          d_zXt +
                                                          noise(
                                                            x,
                                                            y_h,
                                                            z,
                                                            t_p) *
                                                          w_xXy *
                                                          d_zXt +
                                                          noise(
                                                            x_w,
                                                            y_h,
                                                            z_d,
                                                            t_p) *
                                                          xy *
                                                          zXt +
                                                          noise(
                                                            x,
                                                            y,
                                                            z_d,
                                                            t_p) *
                                                          w_xXh_y *
                                                          zXt +
                                                          noise(
                                                            x,
                                                            y_h,
                                                            z_d,
                                                            t_p) *
                                                          w_xXy *
                                                          zXt +
                                                          noise(
                                                            x_w,
                                                            y,
                                                            z_d,
                                                            t_p) *
                                                          xXh_y *
                                                          zXt) /
                                                  (w *
                                                     h *
                                                     d *
                                                     t); }
    public static final float pnoise(org.sunflow.math.Point2 p,
                                     float periodx,
                                     float periody) { return pnoise(
                                                               p.
                                                                 x,
                                                               p.
                                                                 y,
                                                               periodx,
                                                               periody);
    }
    public static final float pnoise(org.sunflow.math.Point3 p,
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
    public static final float pnoise(org.sunflow.math.Point3 p,
                                     float t,
                                     org.sunflow.math.Vector3 pperiod,
                                     float tperiod) { return pnoise(
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
    public static final float spnoise(float xi, float period) {
        float x =
          xi %
          period +
          (xi <
             0
             ? period
             : 0);
        return ((period -
                   x) *
                  snoise(
                    x) +
                  x *
                  snoise(
                    x -
                      period)) /
          period;
    }
    public static final float spnoise(float xi, float yi,
                                      float w,
                                      float h) { float x =
                                                   xi %
                                                   w +
                                                   (xi <
                                                      0
                                                      ? w
                                                      : 0);
                                                 float y =
                                                   yi %
                                                   h +
                                                   (yi <
                                                      0
                                                      ? h
                                                      : 0);
                                                 float w_x =
                                                   w -
                                                   x;
                                                 float h_y =
                                                   h -
                                                   y;
                                                 float x_w =
                                                   x -
                                                   w;
                                                 float y_h =
                                                   y -
                                                   h;
                                                 return (snoise(
                                                           x,
                                                           y) *
                                                           w_x *
                                                           h_y +
                                                           snoise(
                                                             x_w,
                                                             y) *
                                                           x *
                                                           h_y +
                                                           snoise(
                                                             x_w,
                                                             y_h) *
                                                           x *
                                                           y +
                                                           snoise(
                                                             x,
                                                             y_h) *
                                                           w_x *
                                                           y) /
                                                   (w *
                                                      h);
    }
    public static final float spnoise(float xi, float yi,
                                      float zi,
                                      float w,
                                      float h,
                                      float d) { float x =
                                                   xi %
                                                   w +
                                                   (xi <
                                                      0
                                                      ? w
                                                      : 0);
                                                 float y =
                                                   yi %
                                                   h +
                                                   (yi <
                                                      0
                                                      ? h
                                                      : 0);
                                                 float z =
                                                   zi %
                                                   d +
                                                   (zi <
                                                      0
                                                      ? d
                                                      : 0);
                                                 float w_x =
                                                   w -
                                                   x;
                                                 float h_y =
                                                   h -
                                                   y;
                                                 float d_z =
                                                   d -
                                                   z;
                                                 float x_w =
                                                   x -
                                                   w;
                                                 float y_h =
                                                   y -
                                                   h;
                                                 float z_d =
                                                   z -
                                                   d;
                                                 float xy =
                                                   x *
                                                   y;
                                                 float h_yXd_z =
                                                   h_y *
                                                   d_z;
                                                 float h_yXz =
                                                   h_y *
                                                   z;
                                                 float w_xXy =
                                                   w_x *
                                                   y;
                                                 return (snoise(
                                                           x,
                                                           y,
                                                           z) *
                                                           w_x *
                                                           h_yXd_z +
                                                           snoise(
                                                             x,
                                                             y_h,
                                                             z) *
                                                           w_xXy *
                                                           d_z +
                                                           snoise(
                                                             x_w,
                                                             y,
                                                             z) *
                                                           x *
                                                           h_yXd_z +
                                                           snoise(
                                                             x_w,
                                                             y_h,
                                                             z) *
                                                           xy *
                                                           d_z +
                                                           snoise(
                                                             x_w,
                                                             y_h,
                                                             z_d) *
                                                           xy *
                                                           z +
                                                           snoise(
                                                             x,
                                                             y,
                                                             z_d) *
                                                           w_x *
                                                           h_yXz +
                                                           snoise(
                                                             x,
                                                             y_h,
                                                             z_d) *
                                                           w_xXy *
                                                           z +
                                                           snoise(
                                                             x_w,
                                                             y,
                                                             z_d) *
                                                           x *
                                                           h_yXz) /
                                                   (w *
                                                      h *
                                                      d);
    }
    public static final float spnoise(float xi, float yi,
                                      float zi,
                                      float ti,
                                      float w,
                                      float h,
                                      float d,
                                      float p) { float x =
                                                   xi %
                                                   w +
                                                   (xi <
                                                      0
                                                      ? w
                                                      : 0);
                                                 float y =
                                                   yi %
                                                   h +
                                                   (yi <
                                                      0
                                                      ? h
                                                      : 0);
                                                 float z =
                                                   zi %
                                                   d +
                                                   (zi <
                                                      0
                                                      ? d
                                                      : 0);
                                                 float t =
                                                   ti %
                                                   p +
                                                   (ti <
                                                      0
                                                      ? p
                                                      : 0);
                                                 float w_x =
                                                   w -
                                                   x;
                                                 float h_y =
                                                   h -
                                                   y;
                                                 float d_z =
                                                   d -
                                                   z;
                                                 float p_t =
                                                   p -
                                                   t;
                                                 float x_w =
                                                   x -
                                                   w;
                                                 float y_h =
                                                   y -
                                                   h;
                                                 float z_d =
                                                   z -
                                                   d;
                                                 float t_p =
                                                   t -
                                                   p;
                                                 float xy =
                                                   x *
                                                   y;
                                                 float d_zXp_t =
                                                   d_z *
                                                   p_t;
                                                 float zXp_t =
                                                   z *
                                                   p_t;
                                                 float zXt =
                                                   z *
                                                   t;
                                                 float d_zXt =
                                                   d_z *
                                                   t;
                                                 float w_xXy =
                                                   w_x *
                                                   y;
                                                 float w_xXh_y =
                                                   w_x *
                                                   h_y;
                                                 float xXh_y =
                                                   x *
                                                   h_y;
                                                 return (snoise(
                                                           x,
                                                           y,
                                                           z,
                                                           t) *
                                                           w_xXh_y *
                                                           d_zXp_t +
                                                           snoise(
                                                             x_w,
                                                             y,
                                                             z,
                                                             t) *
                                                           xXh_y *
                                                           d_zXp_t +
                                                           snoise(
                                                             x_w,
                                                             y_h,
                                                             z,
                                                             t) *
                                                           xy *
                                                           d_zXp_t +
                                                           snoise(
                                                             x,
                                                             y_h,
                                                             z,
                                                             t) *
                                                           w_xXy *
                                                           d_zXp_t +
                                                           snoise(
                                                             x_w,
                                                             y_h,
                                                             z_d,
                                                             t) *
                                                           xy *
                                                           zXp_t +
                                                           snoise(
                                                             x,
                                                             y,
                                                             z_d,
                                                             t) *
                                                           w_xXh_y *
                                                           zXp_t +
                                                           snoise(
                                                             x,
                                                             y_h,
                                                             z_d,
                                                             t) *
                                                           w_xXy *
                                                           zXp_t +
                                                           snoise(
                                                             x_w,
                                                             y,
                                                             z_d,
                                                             t) *
                                                           xXh_y *
                                                           zXp_t +
                                                           snoise(
                                                             x,
                                                             y,
                                                             z,
                                                             t_p) *
                                                           w_xXh_y *
                                                           d_zXt +
                                                           snoise(
                                                             x_w,
                                                             y,
                                                             z,
                                                             t_p) *
                                                           xXh_y *
                                                           d_zXt +
                                                           snoise(
                                                             x_w,
                                                             y_h,
                                                             z,
                                                             t_p) *
                                                           xy *
                                                           d_zXt +
                                                           snoise(
                                                             x,
                                                             y_h,
                                                             z,
                                                             t_p) *
                                                           w_xXy *
                                                           d_zXt +
                                                           snoise(
                                                             x_w,
                                                             y_h,
                                                             z_d,
                                                             t_p) *
                                                           xy *
                                                           zXt +
                                                           snoise(
                                                             x,
                                                             y,
                                                             z_d,
                                                             t_p) *
                                                           w_xXh_y *
                                                           zXt +
                                                           snoise(
                                                             x,
                                                             y_h,
                                                             z_d,
                                                             t_p) *
                                                           w_xXy *
                                                           zXt +
                                                           snoise(
                                                             x_w,
                                                             y,
                                                             z_d,
                                                             t_p) *
                                                           xXh_y *
                                                           zXt) /
                                                   (w *
                                                      h *
                                                      d *
                                                      t);
    }
    public static final float spnoise(org.sunflow.math.Point2 p,
                                      float periodx,
                                      float periody) { return spnoise(
                                                                p.
                                                                  x,
                                                                p.
                                                                  y,
                                                                periodx,
                                                                periody);
    }
    public static final float spnoise(org.sunflow.math.Point3 p,
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
    public static final float spnoise(org.sunflow.math.Point3 p,
                                      float t,
                                      org.sunflow.math.Vector3 pperiod,
                                      float tperiod) { return spnoise(
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
    private static final float fade(float t) { return t *
                                                 t *
                                                 t *
                                                 (t *
                                                    (t *
                                                       6 -
                                                       15) +
                                                    10); }
    private static final float lerp(float t, float a, float b) {
        return a +
          t *
          (b -
             a);
    }
    private static final float grad(int hash, float x) { int h =
                                                           hash &
                                                           1;
                                                         return x *
                                                           G1[h];
    }
    private static final float grad(int hash, float x, float y) {
        int h =
          hash &
          3;
        return x *
          G2[h][0] +
          y *
          G2[h][1];
    }
    private static final float grad(int hash, float x, float y,
                                    float z) { int h = hash &
                                                 15;
                                               return x *
                                                 G3[h][0] +
                                                 y *
                                                 G3[h][1] +
                                                 z *
                                                 G3[h][2];
    }
    private static final float grad(int hash, float x, float y,
                                    float z,
                                    float w) { int h = hash &
                                                 31;
                                               return x *
                                                 G4[h][0] +
                                                 y *
                                                 G4[h][1] +
                                                 z *
                                                 G4[h][2] +
                                                 w *
                                                 G4[h][3];
    }
    public PerlinScalar() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yyhSmhNzmrcd0wLhHjPoDJYSJ+qxOKpx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "nPT37vvMGz/59NfX72X+P2DthbPCTwAA");
}
