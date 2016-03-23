class VoluntaryWaveGenerator {
    public static final int CHAN_LEFT = 1;
    public static final int CHAN_RIGHT = 2;
    public static final int CHAN_MONO = 4;
    int totalLength;
    int cyclePos;
    int cycleLength;
    int amplitude;
    int channel;
    int sampleRate;
    int volumeShift;
    byte[] waveform = new byte[32];
    public VoluntaryWaveGenerator(int waveLength, int ampl, int duty, int chan,
                                  int rate) { super();
                                              cycleLength = waveLength;
                                              amplitude = ampl;
                                              cyclePos = 0;
                                              channel = chan;
                                              sampleRate = rate; }
    public VoluntaryWaveGenerator(int rate) { super();
                                              cyclePos = 0;
                                              channel = CHAN_LEFT | CHAN_RIGHT;
                                              cycleLength = 2;
                                              totalLength = 0;
                                              sampleRate = rate;
                                              amplitude = 32; }
    public void setSampleRate(int sr) { sampleRate = sr; }
    public void setFrequency(int gbFrequency) { float frequency = (int) ((float)
                                                                           65536 /
                                                                           (float)
                                                                             (2048 -
                                                                                gbFrequency));
                                                cycleLength =
                                                  (int)
                                                    ((float)
                                                       (256.0F *
                                                          sampleRate) /
                                                       (float)
                                                         frequency);
                                                if (cycleLength ==
                                                      0)
                                                    cycleLength =
                                                      1;
    }
    public void setChannel(int chan) { channel = chan;
    }
    public void setLength(int gbLength) { if (gbLength ==
                                                -1) {
                                              totalLength =
                                                -1;
                                          }
                                          else {
                                              totalLength =
                                                (256 -
                                                   gbLength) /
                                                  4;
                                          } }
    public void setSamplePair(int address, int value) {
        waveform[address *
                   2] =
          (byte)
            ((value &
                240) >>
               4);
        waveform[address *
                   2 +
                   1] =
          (byte)
            (value &
               15);
    }
    public void setVolume(int volume) { switch (volume) {
                                            case 0:
                                                volumeShift =
                                                  5;
                                                break;
                                            case 1:
                                                volumeShift =
                                                  0;
                                                break;
                                            case 2:
                                                volumeShift =
                                                  1;
                                                break;
                                            case 3:
                                                volumeShift =
                                                  2;
                                                break;
                                        } }
    public void play(byte[] b, int length, int offset) {
        int val;
        if (totalLength !=
              0) {
            totalLength--;
            for (int r =
                   offset;
                 r <
                   offset +
                   length;
                 r++) {
                int samplePos =
                  31 *
                  cyclePos /
                  cycleLength;
                val =
                  JavaBoy.
                    unsign(
                      waveform[samplePos %
                                 32]) >>
                    volumeShift <<
                    1;
                if ((channel &
                       CHAN_LEFT) !=
                      0)
                    b[r *
                        2] +=
                      val;
                if ((channel &
                       CHAN_RIGHT) !=
                      0)
                    b[r *
                        2 +
                        1] +=
                      val;
                if ((channel &
                       CHAN_MONO) !=
                      0)
                    b[r] +=
                      val;
                cyclePos =
                  (cyclePos +
                     256) %
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
       "bQ8MfUNb+Su+xf8P1vrhitYnAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "naD4P94uxevgIg8okt8dihcu3Z7ihcvl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wz8FbqQ8a3m09XiC4bfeLsMGuKYHDKffGYYX98cYdwyPaV69A83HyuLKSUNl" +
       "JSM8TfXCO94u1dIdCQdUhe/SYL7vDiyfKosn9oMp7PYAzzB899tlCINLOWCo" +
       "fGcYXjoO0r9wZkQ/cAeuL5XF88Cx+rZ0xvFceOGeTiPd9lit75+za7U/vZNf" +
       "OB24j8zl8bt9+kSsf+FUhN4d/z+Mpsn+HwBuyp97Y8T86NfbP78/CCrb0nZb" +
       "9vIgVXlgfyb1KCI/d9veDvu6f/jSNx/9lYdePMweHt0DPh62E9ieOf/UJeb4" +
       "8e6c5Pafvvsfvfr33vji7gzQ/wdeTOzAlzEAAA==");
}
