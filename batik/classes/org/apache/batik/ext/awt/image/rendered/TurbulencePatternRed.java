package org.apache.batik.ext.awt.image.rendered;
public final class TurbulencePatternRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static final class StitchInfo {
        int width;
        int height;
        int wrapX;
        int wrapY;
        StitchInfo() { super(); }
        StitchInfo(org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
            super(
              );
            this.
              width =
              stitchInfo.
                width;
            this.
              height =
              stitchInfo.
                height;
            this.
              wrapX =
              stitchInfo.
                wrapX;
            this.
              wrapY =
              stitchInfo.
                wrapY;
        }
        final void assign(org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
            this.
              width =
              stitchInfo.
                width;
            this.
              height =
              stitchInfo.
                height;
            this.
              wrapX =
              stitchInfo.
                wrapX;
            this.
              wrapY =
              stitchInfo.
                wrapY;
        }
        final void doubleFrequency() { width *= 2;
                                       height *= 2;
                                       wrapX *= 2;
                                       wrapY *= 2;
                                       wrapX -= PerlinN;
                                       wrapY -= PerlinN; }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "AXNsW+WuJgAA");
    }
    private org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo
      stitchInfo =
      null;
    private static final java.awt.geom.AffineTransform
      IDENTITY =
      new java.awt.geom.AffineTransform(
      );
    private double baseFrequencyX;
    private double baseFrequencyY;
    private int numOctaves;
    private int seed;
    private java.awt.geom.Rectangle2D tile;
    private java.awt.geom.AffineTransform txf;
    private boolean isFractalNoise;
    private int[] channels;
    double[] tx = { 1, 0 };
    double[] ty = { 0, 1 };
    private static final int RAND_m = 2147483647;
    private static final int RAND_a = 16807;
    private static final int RAND_q = 127773;
    private static final int RAND_r = 2836;
    private static final int BSize = 256;
    private static final int BM = 255;
    private static final double PerlinN = 4096;
    private final int[] latticeSelector = new int[BSize +
                                                    1];
    private final double[] gradient = new double[(BSize +
                                                    1) *
                                                   8];
    public double getBaseFrequencyX() { return baseFrequencyX;
    }
    public double getBaseFrequencyY() { return baseFrequencyY;
    }
    public int getNumOctaves() { return numOctaves;
    }
    public int getSeed() { return seed; }
    public java.awt.geom.Rectangle2D getTile() { return (java.awt.geom.Rectangle2D)
                                                          tile.
                                                          clone(
                                                            );
    }
    public boolean isFractalNoise() { return isFractalNoise;
    }
    public boolean[] getChannels() { boolean[] channels =
                                       new boolean[4];
                                     for (int i =
                                            0;
                                          i <
                                            this.
                                              channels.
                                              length;
                                          i++)
                                         channels[this.
                                                    channels[i]] =
                                           true;
                                     return channels;
    }
    public final int setupSeed(int seed) {
        if (seed <=
              0)
            seed =
              -(seed %
                  (RAND_m -
                     1)) +
                1;
        if (seed >
              RAND_m -
              1)
            seed =
              RAND_m -
                1;
        return seed;
    }
    public final int random(int seed) { int result =
                                          RAND_a *
                                          (seed %
                                             RAND_q) -
                                          RAND_r *
                                          (seed /
                                             RAND_q);
                                        if (result <=
                                              0)
                                            result +=
                                              RAND_m;
                                        return result;
    }
    private void initLattice(int seed) { double u;
                                         double v;
                                         double s;
                                         int i;
                                         int j;
                                         int k;
                                         int s1;
                                         int s2;
                                         seed =
                                           setupSeed(
                                             seed);
                                         for (k =
                                                0;
                                              k <
                                                4;
                                              k++) {
                                             for (i =
                                                    0;
                                                  i <
                                                    BSize;
                                                  i++) {
                                                 u =
                                                   (seed =
                                                      random(
                                                        seed)) %
                                                     (BSize +
                                                        BSize) -
                                                     BSize;
                                                 v =
                                                   (seed =
                                                      random(
                                                        seed)) %
                                                     (BSize +
                                                        BSize) -
                                                     BSize;
                                                 s =
                                                   1 /
                                                     java.lang.Math.
                                                     sqrt(
                                                       u *
                                                         u +
                                                         v *
                                                         v);
                                                 gradient[i *
                                                            8 +
                                                            k *
                                                            2] =
                                                   u *
                                                     s;
                                                 gradient[i *
                                                            8 +
                                                            k *
                                                            2 +
                                                            1] =
                                                   v *
                                                     s;
                                             }
                                         }
                                         for (i =
                                                0;
                                              i <
                                                BSize;
                                              i++)
                                             latticeSelector[i] =
                                               i;
                                         while (--i >
                                                  0) {
                                             k =
                                               latticeSelector[i];
                                             j =
                                               (seed =
                                                  random(
                                                    seed)) %
                                                 BSize;
                                             latticeSelector[i] =
                                               latticeSelector[j];
                                             latticeSelector[j] =
                                               k;
                                             s1 =
                                               i <<
                                                 3;
                                             s2 =
                                               j <<
                                                 3;
                                             for (j =
                                                    0;
                                                  j <
                                                    8;
                                                  j++) {
                                                 s =
                                                   gradient[s1 +
                                                              j];
                                                 gradient[s1 +
                                                            j] =
                                                   gradient[s2 +
                                                              j];
                                                 gradient[s2 +
                                                            j] =
                                                   s;
                                             }
                                         }
                                         latticeSelector[BSize] =
                                           latticeSelector[0];
                                         for (j =
                                                0;
                                              j <
                                                8;
                                              j++)
                                             gradient[BSize *
                                                        8 +
                                                        j] =
                                               gradient[j];
    }
    private static final double s_curve(final double t) {
        return t *
          t *
          (3 -
             2 *
             t);
    }
    private static final double lerp(double t,
                                     double a,
                                     double b) {
        return a +
          t *
          (b -
             a);
    }
    private final void noise2(final double[] noise,
                              double vec0,
                              double vec1) {
        int b0;
        int b1;
        final int i;
        final int j;
        final double rx0;
        final double rx1;
        final double ry0;
        final double ry1;
        final double sx;
        final double sy;
        vec0 +=
          PerlinN;
        b0 =
          (int)
            vec0 &
            BM;
        i =
          latticeSelector[b0];
        j =
          latticeSelector[b0 +
                            1];
        rx0 =
          vec0 -
            (int)
              vec0;
        rx1 =
          rx0 -
            1.0;
        sx =
          s_curve(
            rx0);
        vec1 +=
          PerlinN;
        b0 =
          (int)
            vec1;
        b1 =
          (j +
             b0 &
             BM) <<
            3;
        b0 =
          (i +
             b0 &
             BM) <<
            3;
        ry0 =
          vec1 -
            (int)
              vec1;
        ry1 =
          ry0 -
            1.0;
        sy =
          s_curve(
            ry0);
        switch (channels.
                  length) {
            case 4:
                noise[3] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   6] +
                        ry0 *
                        gradient[b0 +
                                   7],
                      rx1 *
                        gradient[b1 +
                                   6] +
                        ry0 *
                        gradient[b1 +
                                   7]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   6] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   7],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   6] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   7]));
            case 3:
                noise[2] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   4] +
                        ry0 *
                        gradient[b0 +
                                   5],
                      rx1 *
                        gradient[b1 +
                                   4] +
                        ry0 *
                        gradient[b1 +
                                   5]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   4] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   5],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   4] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   5]));
            case 2:
                noise[1] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   2] +
                        ry0 *
                        gradient[b0 +
                                   3],
                      rx1 *
                        gradient[b1 +
                                   2] +
                        ry0 *
                        gradient[b1 +
                                   3]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   2] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   3],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   2] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   3]));
            case 1:
                noise[0] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   0] +
                        ry0 *
                        gradient[b0 +
                                   1],
                      rx1 *
                        gradient[b1 +
                                   0] +
                        ry0 *
                        gradient[b1 +
                                   1]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   0] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   1],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   0] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   1]));
        }
    }
    private final void noise2Stitch(final double[] noise,
                                    final double vec0,
                                    final double vec1,
                                    final org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
        int b0;
        int b1;
        final int i;
        final int j;
        final int b00;
        final int b10;
        final int b01;
        final int b11;
        double t;
        final double rx0;
        final double rx1;
        final double ry0;
        final double ry1;
        final double sx;
        final double sy;
        t =
          vec0 +
            PerlinN;
        b0 =
          (int)
            t;
        b1 =
          b0 +
            1;
        if (b1 >=
              stitchInfo.
                wrapX) {
            if (b0 >=
                  stitchInfo.
                    wrapX) {
                b0 -=
                  stitchInfo.
                    width;
                b1 -=
                  stitchInfo.
                    width;
            }
            else {
                b1 -=
                  stitchInfo.
                    width;
            }
        }
        i =
          latticeSelector[b0 &
                            BM];
        j =
          latticeSelector[b1 &
                            BM];
        rx0 =
          t -
            (int)
              t;
        rx1 =
          rx0 -
            1.0;
        sx =
          s_curve(
            rx0);
        t =
          vec1 +
            PerlinN;
        b0 =
          (int)
            t;
        b1 =
          b0 +
            1;
        if (b1 >=
              stitchInfo.
                wrapY) {
            if (b0 >=
                  stitchInfo.
                    wrapY) {
                b0 -=
                  stitchInfo.
                    height;
                b1 -=
                  stitchInfo.
                    height;
            }
            else {
                b1 -=
                  stitchInfo.
                    height;
            }
        }
        b00 =
          (i +
             b0 &
             BM) <<
            3;
        b10 =
          (j +
             b0 &
             BM) <<
            3;
        b01 =
          (i +
             b1 &
             BM) <<
            3;
        b11 =
          (j +
             b1 &
             BM) <<
            3;
        ry0 =
          t -
            (int)
              t;
        ry1 =
          ry0 -
            1.0;
        sy =
          s_curve(
            ry0);
        switch (channels.
                  length) {
            case 4:
                noise[3] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   6] +
                        ry0 *
                        gradient[b00 +
                                   7],
                      rx1 *
                        gradient[b10 +
                                   6] +
                        ry0 *
                        gradient[b10 +
                                   7]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   6] +
                        ry1 *
                        gradient[b01 +
                                   7],
                      rx1 *
                        gradient[b11 +
                                   6] +
                        ry1 *
                        gradient[b11 +
                                   7]));
            case 3:
                noise[2] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   4] +
                        ry0 *
                        gradient[b00 +
                                   5],
                      rx1 *
                        gradient[b10 +
                                   4] +
                        ry0 *
                        gradient[b10 +
                                   5]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   4] +
                        ry1 *
                        gradient[b01 +
                                   5],
                      rx1 *
                        gradient[b11 +
                                   4] +
                        ry1 *
                        gradient[b11 +
                                   5]));
            case 2:
                noise[1] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   2] +
                        ry0 *
                        gradient[b00 +
                                   3],
                      rx1 *
                        gradient[b10 +
                                   2] +
                        ry0 *
                        gradient[b10 +
                                   3]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   2] +
                        ry1 *
                        gradient[b01 +
                                   3],
                      rx1 *
                        gradient[b11 +
                                   2] +
                        ry1 *
                        gradient[b11 +
                                   3]));
            case 1:
                noise[0] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   0] +
                        ry0 *
                        gradient[b00 +
                                   1],
                      rx1 *
                        gradient[b10 +
                                   0] +
                        ry0 *
                        gradient[b10 +
                                   1]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   0] +
                        ry1 *
                        gradient[b01 +
                                   1],
                      rx1 *
                        gradient[b11 +
                                   0] +
                        ry1 *
                        gradient[b11 +
                                   1]));
        }
    }
    private final int turbulence_4(double pointX,
                                   double pointY,
                                   final double[] fSum) {
        double n;
        double ratio =
          255;
        int i;
        int j;
        int b0;
        int b1;
        int nOctave;
        double px;
        double py;
        double rx0;
        double rx1;
        double ry0;
        double ry1;
        double sx;
        double sy;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   0)));
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            px =
              pointX +
                PerlinN;
            b0 =
              (int)
                px &
                BM;
            i =
              latticeSelector[b0];
            j =
              latticeSelector[b0 +
                                1];
            rx0 =
              px -
                (int)
                  px;
            rx1 =
              rx0 -
                1.0;
            sx =
              s_curve(
                rx0);
            py =
              pointY +
                PerlinN;
            b0 =
              (int)
                py &
                BM;
            b1 =
              b0 +
                1 &
                BM;
            b1 =
              (j +
                 b0 &
                 BM) <<
                3;
            b0 =
              (i +
                 b0 &
                 BM) <<
                3;
            ry0 =
              py -
                (int)
                  py;
            ry1 =
              ry0 -
                1.0;
            sy =
              s_curve(
                ry0);
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               0] +
                    ry0 *
                    gradient[b0 +
                               1],
                  rx1 *
                    gradient[b1 +
                               0] +
                    ry0 *
                    gradient[b1 +
                               1]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               1],
                  rx1 *
                    gradient[b1 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               1]));
            if (n <
                  0)
                fSum[0] -=
                  n *
                    ratio;
            else
                fSum[0] +=
                  n *
                    ratio;
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               2] +
                    ry0 *
                    gradient[b0 +
                               3],
                  rx1 *
                    gradient[b1 +
                               2] +
                    ry0 *
                    gradient[b1 +
                               3]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               3],
                  rx1 *
                    gradient[b1 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               3]));
            if (n <
                  0)
                fSum[1] -=
                  n *
                    ratio;
            else
                fSum[1] +=
                  n *
                    ratio;
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               4] +
                    ry0 *
                    gradient[b0 +
                               5],
                  rx1 *
                    gradient[b1 +
                               4] +
                    ry0 *
                    gradient[b1 +
                               5]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               5],
                  rx1 *
                    gradient[b1 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               5]));
            if (n <
                  0)
                fSum[2] -=
                  n *
                    ratio;
            else
                fSum[2] +=
                  n *
                    ratio;
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               6] +
                    ry0 *
                    gradient[b0 +
                               7],
                  rx1 *
                    gradient[b1 +
                               6] +
                    ry0 *
                    gradient[b1 +
                               7]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               7],
                  rx1 *
                    gradient[b1 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               7]));
            if (n <
                  0)
                fSum[3] -=
                  n *
                    ratio;
            else
                fSum[3] +=
                  n *
                    ratio;
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
        }
        i =
          (int)
            fSum[0];
        if ((i &
               -256) ==
              0)
            j =
              i <<
                16;
        else
            j =
              (i &
                 -2147483648) !=
                0
                ? 0
                : 16711680;
        i =
          (int)
            fSum[1];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                8;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 65280;
        i =
          (int)
            fSum[2];
        if ((i &
               -256) ==
              0)
            j |=
              i;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 255;
        i =
          (int)
            fSum[3];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                24;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : -16777216;
        return j;
    }
    private final void turbulence(final int[] rgb,
                                  double pointX,
                                  double pointY,
                                  final double[] fSum,
                                  final double[] noise) {
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   0)));
        double ratio =
          255;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        switch (channels.
                  length) {
            case 4:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[3] <
                          0)
                        fSum[3] -=
                          noise[3] *
                            ratio;
                    else
                        fSum[3] +=
                          noise[3] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[3] =
                  (int)
                    fSum[3];
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 3:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 2:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 1:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
        }
    }
    private final void turbulenceStitch(final int[] rgb,
                                        double pointX,
                                        double pointY,
                                        final double[] fSum,
                                        final double[] noise,
                                        org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
        double ratio =
          1;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   0)));
        switch (channels.
                  length) {
            case 4:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[3] <
                          0)
                        fSum[3] -=
                          noise[3] *
                            ratio;
                    else
                        fSum[3] +=
                          noise[3] *
                            ratio;
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[3] =
                  (int)
                    (fSum[3] *
                       255);
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[2] =
                  (int)
                    (fSum[2] *
                       255);
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    (fSum[1] *
                       255);
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 3:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[2] =
                  (int)
                    (fSum[2] *
                       255);
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    (fSum[1] *
                       255);
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 2:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[1] =
                  (int)
                    (fSum[1] *
                       255);
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 1:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
        }
    }
    private final int turbulenceFractal_4(double pointX,
                                          double pointY,
                                          final double[] fSum) {
        int b0;
        int b1;
        int nOctave;
        int i;
        int j;
        double px;
        double py;
        double rx0;
        double rx1;
        double ry0;
        double ry1;
        double sx;
        double sy;
        double ratio =
          127.5;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   127.5)));
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            px =
              pointX +
                PerlinN;
            b0 =
              (int)
                px &
                BM;
            i =
              latticeSelector[b0];
            j =
              latticeSelector[b0 +
                                1];
            rx0 =
              px -
                (int)
                  px;
            rx1 =
              rx0 -
                1.0;
            sx =
              s_curve(
                rx0);
            py =
              pointY +
                PerlinN;
            b0 =
              (int)
                py &
                BM;
            b1 =
              b0 +
                1 &
                BM;
            b1 =
              (j +
                 b0 &
                 BM) <<
                3;
            b0 =
              (i +
                 b0 &
                 BM) <<
                3;
            ry0 =
              py -
                (int)
                  py;
            ry1 =
              ry0 -
                1.0;
            sy =
              s_curve(
                ry0);
            fSum[0] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               0] +
                    ry0 *
                    gradient[b0 +
                               1],
                  rx1 *
                    gradient[b1 +
                               0] +
                    ry0 *
                    gradient[b1 +
                               1]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               1],
                  rx1 *
                    gradient[b1 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               1])) *
                ratio;
            fSum[1] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               2] +
                    ry0 *
                    gradient[b0 +
                               3],
                  rx1 *
                    gradient[b1 +
                               2] +
                    ry0 *
                    gradient[b1 +
                               3]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               3],
                  rx1 *
                    gradient[b1 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               3])) *
                ratio;
            fSum[2] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               4] +
                    ry0 *
                    gradient[b0 +
                               5],
                  rx1 *
                    gradient[b1 +
                               4] +
                    ry0 *
                    gradient[b1 +
                               5]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               5],
                  rx1 *
                    gradient[b1 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               5])) *
                ratio;
            fSum[3] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               6] +
                    ry0 *
                    gradient[b0 +
                               7],
                  rx1 *
                    gradient[b1 +
                               6] +
                    ry0 *
                    gradient[b1 +
                               7]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               7],
                  rx1 *
                    gradient[b1 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               7])) *
                ratio;
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
        }
        i =
          (int)
            fSum[0];
        if ((i &
               -256) ==
              0)
            j =
              i <<
                16;
        else
            j =
              (i &
                 -2147483648) !=
                0
                ? 0
                : 16711680;
        i =
          (int)
            fSum[1];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                8;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 65280;
        i =
          (int)
            fSum[2];
        if ((i &
               -256) ==
              0)
            j |=
              i;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 255;
        i =
          (int)
            fSum[3];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                24;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : -16777216;
        return j;
    }
    private final void turbulenceFractal(final int[] rgb,
                                         double pointX,
                                         double pointY,
                                         final double[] fSum,
                                         final double[] noise) {
        double ratio =
          127.5;
        int nOctave;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   127.5)));
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            noise2(
              noise,
              pointX,
              pointY);
            switch (channels.
                      length) {
                case 4:
                    fSum[3] +=
                      noise[3] *
                        ratio;
                case 3:
                    fSum[2] +=
                      noise[2] *
                        ratio;
                case 2:
                    fSum[1] +=
                      noise[1] *
                        ratio;
                case 1:
                    fSum[0] +=
                      noise[0] *
                        ratio;
            }
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
        }
        switch (channels.
                  length) {
            case 4:
                rgb[3] =
                  (int)
                    fSum[3];
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 3:
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 2:
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 1:
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
        }
    }
    private final void turbulenceFractalStitch(final int[] rgb,
                                               double pointX,
                                               double pointY,
                                               final double[] fSum,
                                               final double[] noise,
                                               org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
        double ratio =
          127.5;
        int nOctave;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   127.5)));
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            noise2Stitch(
              noise,
              pointX,
              pointY,
              stitchInfo);
            switch (channels.
                      length) {
                case 4:
                    fSum[3] +=
                      noise[3] *
                        ratio;
                case 3:
                    fSum[2] +=
                      noise[2] *
                        ratio;
                case 2:
                    fSum[1] +=
                      noise[1] *
                        ratio;
                case 1:
                    fSum[0] +=
                      noise[0] *
                        ratio;
            }
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
            stitchInfo.
              doubleFrequency(
                );
        }
        switch (channels.
                  length) {
            case 4:
                rgb[3] =
                  (int)
                    fSum[3];
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 3:
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 2:
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 1:
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster dest) {
        if (dest ==
              null)
            throw new java.lang.IllegalArgumentException(
              "Cannot generate a noise pattern into a null raster");
        int w =
          dest.
          getWidth(
            );
        int h =
          dest.
          getHeight(
            );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        int minX =
          dest.
          getMinX(
            );
        int minY =
          dest.
          getMinY(
            );
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            dest.
            getSampleModel(
              );
        int dstOff =
          dstDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              dest.
              getSampleModelTranslateX(
                ),
            minY -
              dest.
              getSampleModelTranslateY(
                ));
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int dstAdjust =
          sppsm.
          getScanlineStride(
            ) -
          w;
        int i;
        int end;
        int dp =
          dstOff;
        final int[] rgb =
          new int[4];
        final double[] fSum =
          { 0,
        0,
        0,
        0 };
        final double[] noise =
          { 0,
        0,
        0,
        0 };
        final double tx0;
        final double tx1;
        final double ty0;
        final double ty1;
        tx0 =
          tx[0];
        tx1 =
          tx[1];
        ty0 =
          ty[0] -
            w *
            tx0;
        ty1 =
          ty[1] -
            w *
            tx1;
        double[] p =
          { minX,
        minY };
        txf.
          transform(
            p,
            0,
            p,
            0,
            1);
        double point_0 =
          p[0];
        double point_1 =
          p[1];
        if (isFractalNoise) {
            if (stitchInfo ==
                  null) {
                if (channels.
                      length ==
                      4) {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            destPixels[dp] =
                              turbulenceFractal_4(
                                point_0,
                                point_1,
                                fSum);
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
                else {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            turbulenceFractal(
                              rgb,
                              point_0,
                              point_1,
                              fSum,
                              noise);
                            destPixels[dp] =
                              rgb[3] <<
                                24 |
                                rgb[0] <<
                                16 |
                                rgb[1] <<
                                8 |
                                rgb[2];
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
            }
            else {
                org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo si =
                  new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo(
                  );
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    for (end =
                           dp +
                             w;
                         dp <
                           end;
                         dp++) {
                        si.
                          assign(
                            this.
                              stitchInfo);
                        turbulenceFractalStitch(
                          rgb,
                          point_0,
                          point_1,
                          fSum,
                          noise,
                          si);
                        destPixels[dp] =
                          rgb[3] <<
                            24 |
                            rgb[0] <<
                            16 |
                            rgb[1] <<
                            8 |
                            rgb[2];
                        point_0 +=
                          tx0;
                        point_1 +=
                          tx1;
                    }
                    point_0 +=
                      ty0;
                    point_1 +=
                      ty1;
                    dp +=
                      dstAdjust;
                }
            }
        }
        else {
            if (stitchInfo ==
                  null) {
                if (channels.
                      length ==
                      4) {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            destPixels[dp] =
                              turbulence_4(
                                point_0,
                                point_1,
                                fSum);
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
                else {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            turbulence(
                              rgb,
                              point_0,
                              point_1,
                              fSum,
                              noise);
                            destPixels[dp] =
                              rgb[3] <<
                                24 |
                                rgb[0] <<
                                16 |
                                rgb[1] <<
                                8 |
                                rgb[2];
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
            }
            else {
                org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo si =
                  new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo(
                  );
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    for (end =
                           dp +
                             w;
                         dp <
                           end;
                         dp++) {
                        si.
                          assign(
                            this.
                              stitchInfo);
                        turbulenceStitch(
                          rgb,
                          point_0,
                          point_1,
                          fSum,
                          noise,
                          si);
                        destPixels[dp] =
                          rgb[3] <<
                            24 |
                            rgb[0] <<
                            16 |
                            rgb[1] <<
                            8 |
                            rgb[2];
                        point_0 +=
                          tx0;
                        point_1 +=
                          tx1;
                    }
                    point_0 +=
                      ty0;
                    point_1 +=
                      ty1;
                    dp +=
                      dstAdjust;
                }
            }
        }
        return dest;
    }
    public TurbulencePatternRed(double baseFrequencyX,
                                double baseFrequencyY,
                                int numOctaves,
                                int seed,
                                boolean isFractalNoise,
                                java.awt.geom.Rectangle2D tile,
                                java.awt.geom.AffineTransform txf,
                                java.awt.Rectangle devRect,
                                java.awt.color.ColorSpace cs,
                                boolean alpha) {
        super(
          );
        this.
          baseFrequencyX =
          baseFrequencyX;
        this.
          baseFrequencyY =
          baseFrequencyY;
        this.
          seed =
          seed;
        this.
          isFractalNoise =
          isFractalNoise;
        this.
          tile =
          tile;
        this.
          txf =
          txf;
        if (this.
              txf ==
              null)
            this.
              txf =
              IDENTITY;
        int nChannels =
          cs.
          getNumComponents(
            );
        if (alpha)
            nChannels++;
        channels =
          (new int[nChannels]);
        for (int i =
               0;
             i <
               channels.
                 length;
             i++)
            channels[i] =
              i;
        txf.
          deltaTransform(
            tx,
            0,
            tx,
            0,
            1);
        txf.
          deltaTransform(
            ty,
            0,
            ty,
            0,
            1);
        double[] vecX =
          { 0.5,
        0 };
        double[] vecY =
          { 0,
        0.5 };
        txf.
          deltaTransform(
            vecX,
            0,
            vecX,
            0,
            1);
        txf.
          deltaTransform(
            vecY,
            0,
            vecY,
            0,
            1);
        double dx =
          java.lang.Math.
          max(
            java.lang.Math.
              abs(
                vecX[0]),
            java.lang.Math.
              abs(
                vecY[0]));
        int maxX =
          -((int)
              java.lang.Math.
              round(
                (java.lang.Math.
                   log(
                     dx) +
                   java.lang.Math.
                   log(
                     baseFrequencyX)) /
                  java.lang.Math.
                  log(
                    2)));
        double dy =
          java.lang.Math.
          max(
            java.lang.Math.
              abs(
                vecX[1]),
            java.lang.Math.
              abs(
                vecY[1]));
        int maxY =
          -((int)
              java.lang.Math.
              round(
                (java.lang.Math.
                   log(
                     dy) +
                   java.lang.Math.
                   log(
                     baseFrequencyY)) /
                  java.lang.Math.
                  log(
                    2)));
        this.
          numOctaves =
          numOctaves >
            maxX
            ? maxX
            : numOctaves;
        this.
          numOctaves =
          this.
            numOctaves >
            maxY
            ? maxY
            : this.
                numOctaves;
        if (this.
              numOctaves <
              1 &&
              numOctaves >
              1)
            this.
              numOctaves =
              1;
        if (this.
              numOctaves >
              8)
            this.
              numOctaves =
              8;
        if (tile !=
              null) {
            double lowFreq =
              java.lang.Math.
              floor(
                tile.
                  getWidth(
                    ) *
                  baseFrequencyX) /
              tile.
              getWidth(
                );
            double highFreq =
              java.lang.Math.
              ceil(
                tile.
                  getWidth(
                    ) *
                  baseFrequencyX) /
              tile.
              getWidth(
                );
            if (baseFrequencyX /
                  lowFreq <
                  highFreq /
                  baseFrequencyX)
                this.
                  baseFrequencyX =
                  lowFreq;
            else
                this.
                  baseFrequencyX =
                  highFreq;
            lowFreq =
              java.lang.Math.
                floor(
                  tile.
                    getHeight(
                      ) *
                    baseFrequencyY) /
                tile.
                getHeight(
                  );
            highFreq =
              java.lang.Math.
                ceil(
                  tile.
                    getHeight(
                      ) *
                    baseFrequencyY) /
                tile.
                getHeight(
                  );
            if (baseFrequencyY /
                  lowFreq <
                  highFreq /
                  baseFrequencyY)
                this.
                  baseFrequencyY =
                  lowFreq;
            else
                this.
                  baseFrequencyY =
                  highFreq;
            stitchInfo =
              new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo(
                );
            stitchInfo.
              width =
              (int)
                (tile.
                   getWidth(
                     ) *
                   this.
                     baseFrequencyX);
            stitchInfo.
              height =
              (int)
                (tile.
                   getHeight(
                     ) *
                   this.
                     baseFrequencyY);
            stitchInfo.
              wrapX =
              (int)
                (tile.
                   getX(
                     ) *
                   this.
                     baseFrequencyX +
                   PerlinN +
                   stitchInfo.
                     width);
            stitchInfo.
              wrapY =
              (int)
                (tile.
                   getY(
                     ) *
                   this.
                     baseFrequencyY +
                   PerlinN +
                   stitchInfo.
                     height);
            if (stitchInfo.
                  width ==
                  0)
                stitchInfo.
                  width =
                  1;
            if (stitchInfo.
                  height ==
                  0)
                stitchInfo.
                  height =
                  1;
        }
        initLattice(
          seed);
        java.awt.image.ColorModel cm;
        if (alpha)
            cm =
              new java.awt.image.DirectColorModel(
                cs,
                32,
                16711680,
                65280,
                255,
                -16777216,
                false,
                java.awt.image.DataBuffer.
                  TYPE_INT);
        else
            cm =
              new java.awt.image.DirectColorModel(
                cs,
                24,
                16711680,
                65280,
                255,
                0,
                false,
                java.awt.image.DataBuffer.
                  TYPE_INT);
        int tileSize =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        init(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          devRect,
          cm,
          cm.
            createCompatibleSampleModel(
              tileSize,
              tileSize),
          0,
          0,
          null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "j/8fjRQBJbdGAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mgNvPGz5kFUPoymLddVBI56Zm6JWqQTy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "KxPYq8MgrqorTaoJM0MZrkkjbGO2iB7mMMVaBMWbiTtaK9UVCOOdWVJc1IuC" +
       "LQ2F8XQ8a0tO5E3R4bhUmhuILK1LwWBcDbnJurJOncBLiTFEtcYyoQ1hOGrU" +
       "BXEzg4vDdZXwyYCcUhPDojorsihHkNnWitOxw1t1j1lVTNxvt7pDs9/U12Vs" +
       "nvBOhbHDTr3KjAykhg1sN0TpJtwYiLLozCZOEYIg0pmFniK3E3oUhX0OwZwI" +
       "gze4KC4dEyU2qgemUxEjxlNszRmwyAjDoq4OYdU3K8W43m8SquZVl1W4hQ17" +
       "MBhrctUMW2o3nVsbsd0PsHq/ZcN8yYEF0SbXpQlMzhe01+biNs5bo5LVmPUI" +
       "B+aaGDQN8DhQkGDcmhntVjQZ02FzOh5vGFXmWCUam21eHNmT+npNuOSMWRVp" +
       "r9Zb1pkG5TkazgAfOZ1yMC7Y9JhH+rPQIGEwvw5lMCUcNoLNhOnZYZ8Ml+K6" +
       "tpHdsGpCTdVkR2h/IXcRBMkWs+299voep9yTPx46fO3PtOCskQeu44nJGes4" +
       "jy95OnzClv+y9WK7drbbY0/Y8pL37ZZSBH7h/rNe8svfW/jgtz/2uDz40fL+" +
       "bt0FHBZuC13vtZayVqxjTT0/3//pKx/0ZcsK/2QH409OPug74n/6ur1Xb+V3" +
       "9sKgPeScc+0sez0QvqaE6NULg4+eEL7h6Z5UHW/5LJJ/viP5588+Sfqcc4Ms" +
       "651CUjhBkrgBkndlB18C0qd2JD/17JMUzjmXPe3dG4eF5wCSzJVLlY8ITm6U" +
       "4AtA+vSO4KeffYLKOeeyZ6d7bwkLtwCC3MGa5yNq4g1Qe2F28AGQPrOj9pln" +
       "n9rqnHPZwT1rS218sHj6iJp9A9Semx18OUif21H73LNP7a3nnHtbliWnr3g+" +
       "Yvi0q+fPYZitpM+Xin9hx/ALzz7D7z7n3Duz7F+EhdtB57UPlk5nBU8sgQTj" +
       "59Lbtwi327Dw6LO2JnGsJOGpyx6/2pdIjnrytPXIe+8+WKnynqd3znkvZNmP" +
       "52M7q/Wuq9ciZ3+fyLInr15cnGvG9rJ57ez/z5/Td99/zrkfyLL3ZWd+eYvk" +
       "nLI/uFPTXJm/40aVObNEX9op85euQ5mvkuUJxHtHKv+6HPaHzqH0Y1n2wyCM" +
       "CZQw8k4xuB+4UZrZGwv/tKP5T19Nmj9zDs2fy7KfCAs3+6Iju/YJjk/eAMf8" +
       "ZYSvB0Aubutut9djl958bfR+5Rx6T2XZLwHjZDhGSG3XqOUFTy5OWruGfMT7" +
       "l2+A98uyg68CCF+74/3a6+B9+sq/syVQzVn+3jkS+P0s+y3gW4NHpchfH3s9" +
       "OGf62zfK9CGApLxjWn62mV44Klo9ynJef3oO5z/Lsk9kS84U3ztB+I9uNJCn" +
       "AdE37Ai/4XqH7Zuvieuvn+D638/h+tdZ9ikwgJ0srqhk/371iO1f3ihbUG9v" +
       "9xrs3jufRbYX81IXT7DNsm/OaX3xHMp/m2WfCwt3bClvX4U9QfzzN0A8C/Kz" +
       "lzr3/mZH/G++Ot18xPnXc17/eA7nbEXz3pcA5/DwbeBH81jhmLX+Pzfa2TCA" +
       "L2/r7r/lWeR8U17qpuzvB04QP2S/f9vZ7Pdvz7KLYeHSEfsr+3v/phvl/kZA" +
       "Y7ceev9jzyL3m/NSN5/J/VDl959/jgBemGV3h4W7jwRwmtrv33Ojav8w0E10" +
       "W3e7/aqr/f7Lz+H9YJa9JCw894j3bhp1Uvv3738WNODCh3fUf+Rrrf2vPUcI" +
       "UJa9Oizcc5UQTvT+wzcqgg6gvru9ceGT/18GQescOTySZdlC+qvkcOpYqN+A" +
       "NF6cHQQu4OILtnW322uUxjmT6uMTtSu+obL95sPUN8LstVFWDELFz0l3zhFI" +
       "9gWU/Tdlryy7XoqJYfZe1T5+JAHkeiSQhIXnnfapiezjPfdd9R2+7bfjpCcf" +
       "v+vWFz4++c/b15gPvu92G1W4VY0s6/jHNo7t3+z5imrk8rktz+/0cjrDsPCq" +
       "a/woBuB8sJsR2R9sW+DCwgPntxAWbsq3x2vxYeG+s2qFhQsgP15aAHI6rTQo" +
       "CfLjJb8J2OuTJcH18+3xco8Cx3ZUDoRy253jRRagdVAk25W8A+2pXusXRJBF" +
       "EGYDBfRmstW9+46rff5g4d6n05VjzwIevOIN5vxTjgdvG0fbjzk+Kv3k433m" +
       "W7/Y+NHtR7UkS9xsslZupQq3bL/vlTeavbH88jNbO2jr5t7DX77zp2575cHT" +
       "hTu3gI+G4DFsLz39C1Yd2wvzb05tfvGFP/f6Dz/+F/nLlv8PjUgty2NTAAA=");
}
