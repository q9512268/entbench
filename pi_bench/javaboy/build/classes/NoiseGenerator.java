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
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lT+7taagCXxGCylJKdK2FG1JOHuEqMhI9TqUZYcrvMDJGiqGkcgi0AEWLLMz" +
       "/nspR3VhFhvh2Aiva8ZsgeH0pG7NOeLgHvHWVz4u3/DxU6c59+5A2uk4WgXN" +
       "FH01Zueg6M/yrnTNgjEA7S453rapSj7+OfTYDT2KED0a7Tosp2mXm7FaF437" +
       "3c9PTNnycgGJNpFSWRUSTQL32GQ8uEpqDMBKnNZWrTY9xXZ0kFWcVZLDfE4B" +
       "ztbZ/n6gMakxPnN3PH7WT1bcf/At7rI03sXMXHdsWJ7K8HfHmJ+L2fm5Ti6I" +
       "1KNBy7psFV8TouJuzLp4VQtm603e42MUExZ0ambFdF6IK8wMV3jCt6L2Cnn4" +
       "15f95v7vHdhuzqoQH+Ghm/qvdrn3pnc/yzE3HhD4uA0PfXfsyF3TGlae4vT2" +
       "yozUtencYA6iG5t2yeHkP6Lzin8RJeO6SZVobf02CHIK17tu2O4Ymf0gbA9d" +
       "9e6tixmn12cjjxlev+UY1hsTON1BIXNNfTsMmIx6ORfSEst4lnjtjsea5mxC" +
       "SHUtsFPrp3rNuz889OmNu5ZFcR0qGkLoIJUqu11bCneYtxzZP7Ns3zvf5Uaf" +
       "Mbs+04x5vgizC7gpFOBnHSzjBt+sMmBHUgTZs5xPCgHLyPiG5jVtPfHGpvVZ" +
       "PzbRtt7+0ax3i1sw50Faao211Ecw+DEAxVH8MMK4wiyJmeLDTtAQjJRydjpb" +
       "rmj25YflyQ8qepk12LIQfgrx4/ox8xM0REY9re1t7X7s7Pzy7PCxqiHVW2PV" +
       "57BD+MfN/lwQD+xISFeMlDFwHjLsVPrNzaYX+C15Aq+AtMIabUUA8N22rx/J" +
       "xRpEzUiJOCzKFPbkfkD3jEHCq6yhVgUA3RcKNIgahMqBBgt1f55YKyGttUZb" +
       "G4D1B6FYg6jBbgU89GSpBPVDeleeSMshNVpjNQYgvScUaRA1I+PEAVjrqOyH" +
       "8948cWJVszVScwDOB0NxBlGDZzNQpLQTwn8/qIfzhIru7UprsCsDoB4LhRpE" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NmvORJpaq6buNE2Ok5cgSEHhaGOqcVte");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("b8JZA0ZKprKJbDgeFRsxNIQ2UG0xnc7RvhrEAldBfU0q9ni4s1jXnbZtoX4r" +
       "jmNlte6YEkapLEVXpn06SCsLg9mw7Uo8hiRJb7jkeLlsxP7KFtjuAAR/elpu" +
       "UUJHMGEDjye8E8918HQelqYkFCuOxXOyUGyyq9KCZ/BKs2wOI28OYYwRp64L" +
       "6yWUgpfUOkRL+BrDsPe9L9uO+t75tskeyrf9Dk7ymnYtK/jLc+yEJWftbh5s" +
       "lB78HTsKemSjNK/56H6zoPD4Wad184NRX/jYSy/L/V8qXdjtoNaiwv2R5/8w" +
       "iM0U+0hX94Ce3nv26xAmfytxeNjkdz72F4/xP6J/+BwnLd91AufJLn+FeeX3" +
       "2j8gffpC4a6Doye3HKM+3ujm8QMnlwIlikF4f+zYyeMHms3PKj0J0os7zb54" +
       "cgv6cCJvmaH8DMl7toaQl519MGnv2okKRw4m7b0tyx6MCg+GSjQ6eDN76ibr" +
       "yjPkA6vau3yeE0zZjb1LxyV/AqRP7CT/xN+S5E/cRvKnsuwd2QtpJcIP3pHv" +
       "PXIo4uNvVsQOSJ/eifjp74+Idx0SAnKQvZoL9MO3ERbOsvdEhbcAYY+8BT0q" +
       "7TNvVtrrIH1uJ+3n/pYmtHEbGbMzkHvZO6LspPv+qZCjElberIQfBOnzOwk/" +
       "/32dz9Mc7m7V9sT8ndKrhwogbqOA7JDh3vu3vpxznRIp+ZckR5WAvVklICB9" +
       "aaeEL33/lfDbB6NdyzrPzlF8fTda/j8qPPc6PyMYLWMxUKbi6tYvEd5sF8mp" +
       "BLnY7JjziOkevGram+zeKO796On6yQ/Z5Yv8wfp+j33scNPe2E8O+r+w+yoh" +
       "+/1wtDuWnb+Uw23PVbIT3vtl2y8cDO/GwadJoDA5DenepS3SfLAtzCx7+rRJ" +
       "O2p55m3KclbVgDlLGa6tGLep7iWFQ3LL7/C3qZ29Bt7rA937trg5Yencuc7Y" +
       "3vJ9iO+f8vZ0exY12Tse9OwPWbh2pyGPxElPHYtu8u/V9iORePvF2vPSF1/u" +
       "sD/23eovbb9okGwxTbNe7usV7t1+XHEQzTxxZm/7fd1DPfO9y79+/9P7kdfl" +
       "LeBDjz2C7V2nfz5AOH6UH/hP/83b/9Wz/+Llr+cnWv8/Fu9qFEg4AAA=");
}
