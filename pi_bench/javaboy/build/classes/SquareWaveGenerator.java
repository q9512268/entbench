class SquareWaveGenerator {
    public static final int CHAN_LEFT = 1;
    public static final int CHAN_RIGHT = 2;
    public static final int CHAN_MONO = 4;
    int totalLength;
    int cyclePos;
    int cycleLength;
    int amplitude;
    int dutyCycle;
    int channel;
    int sampleRate;
    int initialEnvelope;
    int numStepsEnvelope;
    boolean increaseEnvelope;
    int counterEnvelope;
    int gbFrequency;
    int timeSweep;
    int numSweep;
    boolean decreaseSweep;
    int counterSweep;
    public SquareWaveGenerator(int waveLength, int ampl, int duty, int chan,
                               int rate) { super();
                                           cycleLength = waveLength;
                                           amplitude = ampl;
                                           cyclePos = 0;
                                           dutyCycle = duty;
                                           channel = chan;
                                           sampleRate = rate; }
    public SquareWaveGenerator(int rate) { super();
                                           dutyCycle = 4;
                                           cyclePos = 0;
                                           channel = CHAN_LEFT | CHAN_RIGHT;
                                           cycleLength = 2;
                                           totalLength = 0;
                                           sampleRate = rate;
                                           amplitude = 32;
                                           counterSweep = 0; }
    public void setSampleRate(int sr) { sampleRate = sr; }
    public void setDutyCycle(int duty) { switch (duty) { case 0: dutyCycle =
                                                                   1;
                                                                 break; case 1:
                                                             dutyCycle =
                                                               2;
                                                             break;
                                                         case 2:
                                                             dutyCycle =
                                                               4;
                                                             break;
                                                         case 3:
                                                             dutyCycle =
                                                               6;
                                                             break; } }
    public void setFrequency(int gbFrequency) { try { float frequency = 131072 /
                                                        2048;
                                                      if (gbFrequency != 2048) {
                                                          frequency =
                                                            (float)
                                                              131072 /
                                                              (float)
                                                                (2048 -
                                                                   gbFrequency);
                                                      }
                                                      this.gbFrequency = gbFrequency;
                                                      if (frequency != 0) {
                                                          cycleLength =
                                                            256 *
                                                              sampleRate /
                                                              (int)
                                                                frequency;
                                                      }
                                                      else {
                                                          cycleLength =
                                                            65535;
                                                      }
                                                      if (cycleLength == 0)
                                                          cycleLength =
                                                            1; }
                                                catch (java.lang.ArithmeticException e) {
                                                    
                                                } }
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
    public void setSweep(int time, int num, boolean decrease) { timeSweep =
                                                                  (time +
                                                                     1) /
                                                                    2;
                                                                numSweep =
                                                                  num;
                                                                decreaseSweep =
                                                                  decrease;
                                                                counterSweep =
                                                                  0;
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
    public void setLength3(int gbLength) { if (gbLength == -1) { totalLength =
                                                                   -1;
                                           }
                                           else {
                                               totalLength =
                                                 (256 -
                                                    gbLength) /
                                                   4;
                                           } }
    public void setVolume3(int volume) { switch (volume) { case 0:
                                                               amplitude =
                                                                 0;
                                                               break;
                                                           case 1:
                                                               amplitude =
                                                                 32;
                                                               break;
                                                           case 2:
                                                               amplitude =
                                                                 16;
                                                               break;
                                                           case 3:
                                                               amplitude =
                                                                 8;
                                                               break;
                                         } }
    public void play(byte[] b, int length, int offset) { int val =
                                                           0;
                                                         if (totalLength !=
                                                               0) {
                                                             totalLength--;
                                                             if (timeSweep !=
                                                                   0) {
                                                                 counterSweep++;
                                                                 if (counterSweep >
                                                                       timeSweep) {
                                                                     if (decreaseSweep) {
                                                                         setFrequency(
                                                                           gbFrequency -
                                                                             (gbFrequency >>
                                                                                numSweep));
                                                                     }
                                                                     else {
                                                                         setFrequency(
                                                                           gbFrequency +
                                                                             (gbFrequency >>
                                                                                numSweep));
                                                                     }
                                                                     counterSweep =
                                                                       0;
                                                                 }
                                                             }
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
                                                             for (int r =
                                                                    offset;
                                                                  r <
                                                                    offset +
                                                                    length;
                                                                  r++) {
                                                                 if (cycleLength !=
                                                                       0) {
                                                                     if (8 *
                                                                           cyclePos /
                                                                           cycleLength >=
                                                                           dutyCycle) {
                                                                         val =
                                                                           amplitude;
                                                                     }
                                                                     else {
                                                                         val =
                                                                           -amplitude;
                                                                     }
                                                                 }
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
       "N28wrDAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9tuTqTZO4l6zOQ0qKgOtLcEth1CtTCkd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FxLXUZxprYFtZ9O2CII8U+WdaYtDwM4unSybSFVrRRMn89UUF0fAgw8seAPZ" +
       "KimgZTbo8xliJGQqTlBt1lq30npIa8FcUA2l3B+snAXMST604qxwjVRYvlFz" +
       "bNG0AywIbXwGg93YlhmsBabVpSXeSPqC4JJRpcVbchgJgu26RBdPW+kmJL02" +
       "toEMDp7AGryhqq0k6OUPvp59Nn8k9t3be1T3cPHo8Sj71rSb+YVv3MbTuPSi" +
       "R6xHT2uP/k6lb554Wlu0fPywW1B68qIM2yJ76bMfeeFFmf7lypX9Y9xm/vzd" +
       "8/+GrWwU+8RQV8FI7744D4UsEoyPk0G+9JE/f2L+4/oHbiMd8q1ncJ4d8lfJ" +
       "l3538MPS379SuuMoNeSm1OfTnZ45nRByNVCiOHDnp9JCnjySbJFL9A5QPrSX" +
       "7IfOPgc/nsibZqjI8XjnThGKaxcnDh08eKbBicShg2t5dV9UeiBUIuboPeW5" +
       "D3o3niEfadXB1dvJMMpPHNx9mvlToHx0z/yjrxPzJ2/B/K159XhUuh8w7514" +
       "h33wyDHJH3ytJN8Nygt7ki+8TiTfdQuSUF5d35E8+eLtJMmnXyvJt4PyuT3J" +
       "z71OJOu3IJl7vYNy/qJdidCjd/8nKVZeK0UclJf3FF/+66F4x7FrR46qLxSE" +
       "Orcgi+bVe6LSGwDZE293T7J99rWyzdOKvrhn+8XXnS15C7b5i6KDYVS6N3dP" +
       "+9d8J6mOXivV66D81p7qb71Ouru8BcF8QT+Yg0Uw/6TiMNXoJMNLc+4uY/g0" +
       "KF/aM/zS68RQuQXD/OXgwQd21rljiJyheGmu3vezlHx1T/GrrxPF9S0oFpjs" +
       "HUUu/4ZGOUvRea0UEVC+tqf4tb9WkwSB1tMXB1pFIv4uJf7Ff/rUVz744lP/" +
       "pcjBvtcIOSHoBNo531Sd6PPtl77+zT984MlfL773uFMUwl0kdPZjtJu/NTv1" +
       "CVkB//4jgeS5A0W60YUCOTd+EbeR4vt+6dgHFZP3/C0m9mN5lYK+vi2cXTa3" +
       "t5Viff6HQv4uUfN0lsAuHznd5Zw+fkInduH8I5fd90Qs/tSpiS2+YzyMduPd" +
       "l4zPSS+/iFM/9Z3GL+8+bZFsIcvyUe4Fc7D7ymY/Bye/TTg72uFYdw/f9b0H" +
       "P3/f04fR/YM7wMf6eQLbW8//jgRz/Kj48iP7F2/6wnv+2YtfK7Ka/z+5rZs/" +
       "YDoAAA==");
}
