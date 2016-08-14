class NoiseGenerator {
    public static final int CHAN_LEFT = 1;
    public static final int CHAN_RIGHT = 2;
    public static final int CHAN_MONO = 4;
    int totalLength;
    int cyclePos;
    int cycleLength;
    int amplitude;
    int channel;
    int sampleRate;
    int initialEnvelope;
    int numStepsEnvelope;
    boolean increaseEnvelope;
    int counterEnvelope;
    boolean[] randomValues;
    int dividingRatio;
    int polynomialSteps;
    int shiftClockFreq;
    int finalFreq;
    int cycleOffset;
    public NoiseGenerator(int waveLength, int ampl, int chan, int rate) {
        super(
          );
        cycleLength =
          waveLength;
        amplitude =
          ampl;
        cyclePos =
          0;
        channel =
          chan;
        sampleRate =
          rate;
        cycleOffset =
          0;
        randomValues =
          (new boolean[32767]);
        java.util.Random rand =
          new java.util.Random(
          );
        for (int r =
               0;
             r <
               32767;
             r++) {
            randomValues[r] =
              rand.
                nextBoolean(
                  );
        }
        cycleOffset =
          0;
    }
    public NoiseGenerator(int rate) { super();
                                      cyclePos = 0;
                                      channel = CHAN_LEFT | CHAN_RIGHT;
                                      cycleLength = 2;
                                      totalLength = 0;
                                      sampleRate = rate;
                                      amplitude = 32;
                                      randomValues = (new boolean[32767]);
                                      java.util.Random rand = new java.util.Random(
                                        );
                                      for (int r = 0; r < 32767; r++) {
                                          randomValues[r] =
                                            rand.
                                              nextBoolean(
                                                );
                                      }
                                      cycleOffset = 0; }
    public void setSampleRate(int sr) { sampleRate = sr; }
    public void setChannel(int chan) { channel = chan; }
    public void setEnvelope(int initialValue, int numSteps, boolean increase) {
        initialEnvelope =
          initialValue;
        numStepsEnvelope =
          numSteps;
        increaseEnvelope =
          increase;
        amplitude =
          initialValue *
            2;
    }
    public void setLength(int gbLength) { if (gbLength == -1) { totalLength =
                                                                  -1;
                                          }
                                          else {
                                              totalLength =
                                                (64 -
                                                   gbLength) /
                                                  4;
                                          } }
    public void setParameters(float dividingRatio, boolean polynomialSteps,
                              int shiftClockFreq) { this.dividingRatio =
                                                      (int)
                                                        dividingRatio;
                                                    if (!polynomialSteps) {
                                                        this.
                                                          polynomialSteps =
                                                          32767;
                                                        cycleLength =
                                                          32767 <<
                                                            8;
                                                        cycleOffset =
                                                          0;
                                                    }
                                                    else {
                                                        this.
                                                          polynomialSteps =
                                                          63;
                                                        cycleLength =
                                                          63 <<
                                                            8;
                                                        java.util.Random rand =
                                                          new java.util.Random(
                                                          );
                                                        cycleOffset =
                                                          (int)
                                                            (rand.
                                                               nextFloat(
                                                                 ) *
                                                               1000);
                                                    }
                                                    this.shiftClockFreq =
                                                      shiftClockFreq;
                                                    if (dividingRatio ==
                                                          0) dividingRatio =
                                                               0.5F;
                                                    finalFreq = (int)
                                                                  (4194304 /
                                                                     8 /
                                                                     dividingRatio) >>
                                                                  shiftClockFreq +
                                                                  1;
    }
    public void play(byte[] b, int length, int offset) {
        int val;
        if (totalLength !=
              0) {
            totalLength--;
            counterEnvelope++;
            if (numStepsEnvelope !=
                  0) {
                if (counterEnvelope %
                      numStepsEnvelope ==
                      0 &&
                      amplitude >
                      0) {
                    if (!increaseEnvelope) {
                        if (amplitude >
                              0)
                            amplitude -=
                              2;
                    }
                    else {
                        if (amplitude <
                              16)
                            amplitude +=
                              2;
                    }
                }
            }
            int step =
              finalFreq /
              (sampleRate >>
                 8);
            for (int r =
                   offset;
                 r <
                   offset +
                   length;
                 r++) {
                boolean value =
                  randomValues[cycleOffset +
                                 (cyclePos >>
                                    8) &
                                 32767];
                int v =
                  value
                  ? amplitude /
                  2
                  : -amplitude /
                  2;
                if ((channel &
                       CHAN_LEFT) !=
                      0)
                    b[r *
                        2] +=
                      v;
                if ((channel &
                       CHAN_RIGHT) !=
                      0)
                    b[r *
                        2 +
                        1] +=
                      v;
                if ((channel &
                       CHAN_MONO) !=
                      0)
                    b[r] +=
                      v;
                cyclePos =
                  (cyclePos +
                     step) %
                    cycleLength;
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xTYHTqnIPv6JX/v/B8b1FtcdLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cjVKwdI58GcrczCQ40oVatIzpFYaO67B");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GYzPjYc4V6rO56XOtKjSm4mgg0cVqLyADW2wEbwpaQ5qPZ+Ap/V6H1FM1K/g" +
       "dXk2MDo1JYrI0kDoDVJ3xRnmjAMr4dSO2ohBKH26XhqT4IGVk4Ql21Fwaj1s" +
       "FmtyqbvC6QoybiDFWRIJpuH3EqHi9ZajSLYGlTk1ry0EZrWWVwwq8VzYxWiR" +
       "qy/UMjeV1xXdx4qob1Nyg2EIwZivpl7YjqcTlKPCcijV/TFVVblKzIskv3Ko" +
       "wbrancJruAHGJUJFZYY4nm1Vffd8W2iP5FuCByeATQvLKv7yHLtk8Vk7nweb" +
       "qAe/Y0dIj2yi5i0f3+/mF54865RvfmjqCx976WW1/0ulC7vdVSwsPBi63g9a" +
       "2lqzjpC6D1B679mvSnr5G4vDgyi/+7H/8QT/Q4sPn+MU5rtO4DxJ8ld6r/x+" +
       "5/uUT18o3HNwLOW249fHO908fhjlkq+Fke/wx46kPHkg2fwc09MgvbiT7Isn" +
       "t6cPJ/K2GcrPl7xnqwh53dmHlvaunWhw5NDS3tuy7OGw8HCghdzBW9tTN2DX" +
       "rqEeaNXe5fOcbsoK9i4d5/wpkD6x4/wTf0ucP3UHzp/JsndkL6u1sHnw/nzv" +
       "sUMWn3yjLHZB+vSOxU+/OSzec+gQkIPs1ZyhH7wDs3CWvScsvAUwe+QN6VFu" +
       "n3uj3F4H6XM7bj/3tzSh9TvwmJ2P3MveH2Un5PdPjBzlEH2jHH4QpM/vOPz8" +
       "mzqfpxncvXPLlfL3Ta8eCqB9BwFkBxD33r+15dzXaaGWf4FyVAj4GxUCAtKX" +
       "dkL40psvhN8+GO1aRjw7Y/G13Wj5/7DQe10fHHCrSPK1ibS+/QuGN5dgfKrz" +
       "lJOdVz2i1gevqPaE3ZvIvR8+XXb54bw8ADhY+++zjh2K2ht78QH9C7uvGbL7" +
       "R8Pdce78ZV7Tch0tOxm+X7f9MsJwbxx87gQq49OQ7l3aIs0H28LMsmdPm9Cj" +
       "WmneoS73uDpQdSXDtWXjDs3duHDo+PIS/g6ts9fHe30ge8+SkhNWMDjX2dzb" +
       "vivxvFPeum7PsMZ7xwOi/SEL1+425JEY6pljkU/+Ddx+lBJtv4K7pXzx5S77" +
       "I9+p/tL2SwjFktI0o/IAU7h/+1HGQaTz1JnU9mndRz733cu//uCz+1HZ5S3g" +
       "Q2s+gu1dp3920La9MP9QIP1Xb/8Xz/+zl7+Wn4T9/7gwfcicOAAA");
}
