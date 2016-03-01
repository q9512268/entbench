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
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "Jz+w/R8Q9EAxiiYAAA==");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PeJEAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "waqakEgtnpJKwiO8tYohrOtMRmFS7rUr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "v0T5/wEPEp+Lj1MAAA==");
}
