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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "m3T/DyV8b8M1RQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMWcC7AjWXmYde/O7Jvd2eWxC2F3gVkMS9vTUkv9UA12ULfU" +
       "enRLaqnVkro39tDql1rq90Pqlr3GhjhLQRWQsDxcmKXK4BA7a3Al2LgqIcHl" +
       "ioHCdsqExCGpsDjEheOFClupYAdwyGlJd+6dO3Pv7Hg1ZVX1r36cc/r//nPO" +
       "f/7Tr2e+kzsbBjnIc63UsNzogpZEF2YWeiFKPS280GJRTg5CTaUsOQwHYN8l" +
       "5XW/de/3fvC+6bn93K1S7qWy47iRHJmuE/a10LUWmsrm7j3cW7M0O4xy59iZ" +
       "vJDhODItmDXD6CKbu+tI1ij3KHugAgxUgIEK8FoFuHKYCmR6iebENpXlkJ0o" +
       "9HM/n9tjc7d6SqZelHvtlYV4ciDb22K4NQEo4fZsewig1pmTIPeay+wb5quA" +
       "PwDBT33oZ879i1ty90q5e02Hz9RRgBIROImUu9vW7IkWhBVV1VQpd5+jaSqv" +
       "BaZsmau13lLu/tA0HDmKA+2ykbKdsacF63MeWu5uJWMLYiVyg8t4uqlZ6sHW" +
       "Wd2SDcD6ikPWDSGd7QeAd5pAsUCXFe0gy5m56ahR7pHjOS4zPsqABCDrbbYW" +
       "Td3LpzrjyGBH7v5N3VmyY8B8FJiOAZKedWNwlij3qhMLzWztycpcNrRLUe7B" +
       "4+m4zSGQ6o61IbIsUe7lx5OtSwK19KpjtXSkfr7TefN7ftZpOPtrnVVNsTL9" +
       "bweZHj6Wqa/pWqA5irbJePeb2A/Kr/jcO/dzOZD45ccSb9J89ueef8uPP/z5" +
       "L27S/L1rpOlOZpoSXVI+MbnnT15NPVa+JVPjds8NzazyryBfN39ue+Ri4oGe" +
       "94rLJWYHLxwc/Hz/D8Rf+A3tuf3cnc3crYprxTZoR/cpru2ZlhbUNUcL5EhT" +
       "m7k7NEel1sebudvAOms62mZvV9dDLWrmzljrXbe6621gIh0UkZnoNrBuOrp7" +
       "sO7J0XS9nni5XO4lYMndD5Y7c5vf+j/KjeGpa2uwrMiO6bgwF7gZf1ahjirD" +
       "kRaCdRUc9Vw4jB3dcpdwGCiwGxiXt21wIpjTAqAYr8iWHFzIWph3E8tOMq5z" +
       "y709YPJXH+/wFugrDddSteCS8lRM1p7/1KUv71/uAFuLRLmHwGkubE9zITvN" +
       "haOnye3trUt/WXa6TWWCqpiDTg3c3d2P8T/deus7X3cLaEXe8gywY5YUPtnr" +
       "UoduoLl2dgpoi7nPf3j5i8O35fdz+1e6z0xFsOvOLDuXOb3Lzu3R493mWuXe" +
       "++RffO/TH3zCPexAV/jjbb++OmfWL1933JiBq2gq8HSHxb/pNfJvX/rcE4/u" +
       "586Azg4cXCSDBgl8x8PHz3FF/7x44OsylrMAWHcDW7ayQwcO6s5oGrjLwz3r" +
       "Wr5nvX4fsPFrcltxRQvOjr7Uy+TLNq0iq7RjFGtf+pO899H//Mf/s7g294Hb" +
       "vffIQMZr0cUjXT0r7N51p77vsA0MAk0D6f7bh7n3f+A7Tz6+bgAgxflrnfDR" +
       "TFKgi4MqBGb+pS/6X3v265/46v5ho4nAWBdPLFNJNpA/Ar89sPy/bMngsh2b" +
       "bno/tfUVr7nsLLzszD92qBtwGxboXlkLelRwbFc1dVOeWFrWYn947+sLv/3t" +
       "95zbtAkL7DloUj9+/QIO97+SzP3Cl3/mrx5eF7OnZMPWof0Ok2184UsPS64E" +
       "gZxmeiS/+JWHfvkL8keBVwWeLDRX2to55db2yK0rML+2BbSW8LFjSCYeCY92" +
       "hCv72pHw4pLyvq9+9yXD7/6b59faXhmfHK33tuxd3DS1TLwmAcU/cLzXN+Rw" +
       "CtKVPt/5B+esz/8AlCiBEhUwKIfdAHia5IpWsk199rb/8nu//4q3/sktuX06" +
       "d6flyiotrztc7g7Q0rVwCpxU4v39t2xa8/J2IM6tUXNXwW8ayIPrrduBgo+d" +
       "7GvoLLw47K4Pfr9rTd7+3//6KiOsvcw1RtVj+SX4mV95FfVTz63zH3b3LPfD" +
       "ydXeF4Rih3mR37D/z/7rbv13+7nbpNw5ZRvnDWUrzjqRBGKb8CD4A7HgFcev" +
       "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" +
       "zvdLcuBMW6YiszANvDDcJqdKtV6yfN+N");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "5P8HdKX4F+JPAAA=");
}
