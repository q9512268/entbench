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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMWcC9DrWH3Y/X17777ZvbsEdqHsLuxdAouSK9uyLWsuSbFk" +
       "y7Is27JlWZZosugt2XpZbzvZkEBTGJhhaVkeGcIyE0hI0g1kWhIy09Ihk2mA" +
       "IUknlDahnbKkNEOaDVN2OiUpkFLJ9ve4373fd/ey3oln9Lce5xyd3//8z//8" +
       "j15Pf6twPvALgOdaS91yw0tqGl6aWdVL4dJTg0skVaVFP1AVzBKDYJzte0x+" +
       "+Lfv/s733mtc2C/cLBReKjqOG4qh6TrBSA1cK1YVqnD30d6WpdpBWLhAzcRY" +
       "BKPQtEDKDMLLVOGOY1nDwiPUQRXArApgVgVwXQWwcZQqy/QS1YlsLM8hOmGw" +
       "KPxcYY8q3OzJefXCwmuuLMQTfdHeFkOvCbISbs23JxnUOnPqF159yL5hvgr4" +
       "/QD45Ad/+sK/uqlwt1C423SYvDpyVokwO4lQuNNWbUn1g4aiqIpQuMdRVYVR" +
       "fVO0zNW63kLh3sDUHTGMfPVQSfnOyFP99TmPNHennLP5kRy6/iGeZqqWcrB1" +
       "XrNEPWN9+RHrhhDP92eAt5tZxXxNlNWDLOfmpqOEhYdO5jhkfKSbJciy3mKr" +
       "oeEenuqcI2Y7Cvdu2s4SHR1kQt909CzpeTfKzhIWXnlqobmuPVGei7r6WFi4" +
       "/2Q6enMoS3XbWhF5lrDwspPJ1iVlrfTKE610rH2+1X/je37GIZz9dZ0VVbby" +
       "+t+aZXrwRKaRqqm+6sjqJuOdb6A+IL78s+/cLxSyxC87kXiT5jM/+9ybfuzB" +
       "z31hk+YfXSPNQJqpcviY/HHprj99FfYoclNejVs9NzDzxr+CfG3+9PbI5dTL" +
       "et7LD0vMD146OPi50R/yP/+b6rP7hds7hZtl14rszI7ukV3bMy3Vb6uO6ouh" +
       "qnQKt6mOgq2Pdwq3ZOuU6aibvQNNC9SwUzhnrXfd7K63MxVpWRG5im7J1k1H" +
       "cw/WPTE01uupVygUXpIthXuz5fbC5rf+Dwt90HBtFRRl0TEdF6R9N+cPQNUJ" +
       "pUy3BhhEjma5CRj4Muj6+uG2nRUP0qqfVYeRRUv0L+V25e28xDRnuJDs7WXq" +
       "fdXJzm1l/YJwLUX1H5OfjNDWc5987Ev7h8a+pQ8LD2SnubQ9zaX8NJeOn6aw" +
       "t7cu/Ufy020aLlP7POvAmWu781Hmp8i3vPPhmzKL8ZJzmc7ypODpHhY76vKd" +
       "tWOTM7srfO5DyS9M3lrcL+xf6SrzKma7bs+z07mDO3Rkj5zsItcq9+53/NV3" +
       "PvWBx92jznKF79324atz5n3w4ZPK9F1ZVTKvdlT8G14t/s5jn338kf3Cuaxj" +
       "Z84sFDPjy/zEgyfPcUVfvHzg13KW8xmw5vq2aOWHDpzR7aHhu8nRnnUr37Ve" +
       "vyfT8asLW3GFteZHX+rl8kc2VpE32gmKtd/8Ccb7yJ//yf+E1uo+cLF3Hxu0" +
       "GDW8fKxb54Xdve7A9xzZwNhX1Szdf/sQ/b73f+sdb14bQJbi4rVO+Egusaw7" +
       "Z02YqfkXv7D46jNf+/hX9o+MJszGtUiyTDndQP4g++1ly//Llxwu37Hpkvdi" +
       "W7/w6kPH4OVn/tGjumUuwso6VW5Bj7CO7SqmZoqSpeYW+/27X1v6nb95z4WN" +
       "TVjZngOT+rHrF3C0/xVo4ee/9NN/++C6mD05H6KO9HeUbOP3XnpUcsP3xWVe" +
       "j/QXvvzAL31e/EjmQTOvFZgrde2ICmt9FNYNWFzrAlhL8MSxci4eCo53hCv7" +
       "2rFQ4jH5vV/59ksm3/53z61re2Uscrzde6J3eWNquXh1mhV/38leT4iBkaWr" +
       "fK7/Ty5Yn/teVqKQlShnA3Aw8DNPk15hJdvU52/5L7//By9/y5/eVNjHC7db" +
       "rqjg4rrDFW7LLF0NjMxJpd4/ftPGmpNbM3FhjVq4Cn5jIPevt27NKvjo6b4G" +
       "z0OJo+56/3cHlvS2//53Vylh7WWuMYKeyC+AT//yK7GffHad/6i757kfTK/2" +
       "vlnYdZS3/Jv2/9l/+OZ/v1+4RShckLcx3US0orwTCVkcExwEelncd8XxK2OS" +
       "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" +
       "rkiFH3rmtI2VS0VcHXltt4l3KFAedaDh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "dFa/d9+n3/iJp762fi/z/wOFmSby6k8AAA==");
}
