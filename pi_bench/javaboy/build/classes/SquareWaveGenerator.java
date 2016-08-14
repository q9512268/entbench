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
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaDXAV1RW+7+WHkBASwq9A+EtQQc0TRREjKDwSCT6SNEGk" +
       "QQmbfTfJwr7dZfe+8IJS0Q5Cf2SsBrWtMo5iUQbFOnWw0yq0juBfdUTbah3B" +
       "WkdtLa1Mq3ZqW3vO3X1v9+3b3fgyJDP3Zt/de+79znfPOfdn74FTpMjQyTSq" +
       "sDrWr1GjrkFhrYJu0HhUFgxjFZR1ivcUCP9Y93HzwjAp7iCjewVjpSgYtFGi" +
       "ctzoINWSYjBBEanRTGkcJVp1alC9T2CSqnSQ8ZLRlNBkSZTYSjVOscJqQY+R" +
       "MQJjutSVZLTJaoCR6hggiXAkkSXu1/UxMkpUtX67+iRH9ajjDdZM2H0ZjFTG" +
       "Ngh9QiTJJDkSkwxWn9LJeZoq9/fIKqujKVa3Qb7EomBF7JIcCmY9UfH5l3f0" +
       "VnIKxgqKojKuntFGDVXuo/EYqbBLG2SaMDaRb5GCGClzVGakNpbuNAKdRqDT" +
       "tLZ2LUBfTpVkIqpydVi6pWJNRECMzMxuRBN0IWE108oxQwslzNKdC4O2MzLa" +
       "mlrmqLj7vMjAPesqnywgFR2kQlLaEY4IIBh00gGE0kQX1Y0l8TiNd5AxCgx2" +
       "O9UlQZa2WCNdZUg9isCSMPxpWrAwqVGd92lzBeMIuulJkal6Rr1ublDWr6Ju" +
       "WegBXSfYupoaNmI5KFgqATC9WwC7s0QKN0pKnJHpbomMjrXXQAUQHZGgrFfN" +
       "dFWoCFBAqkwTkQWlJ9IOpqf0QNUiFQxQZ2Syb6PItSaIG4Ue2okW6arXar6C" +
       "WiM5ESjCyHh3Nd4SjNJk1yg5xudU8xW7blSWK2ESAsxxKsqIvwyEprmE2mg3" +
       "1Sn4gSk4am7sbmHCMzvDhEDl8a7KZp1DN52+6vxpR14w60zxqNPStYGKrFPc" +
       "2zX69anROQsLEEaJphoSDn6W5tzLWq039SkNIsyETIv4si798kjb0W9u208/" +
       "CZPSJlIsqnIyAXY0RlQTmiRT/WqqUF1gNN5ERlIlHuXvm8gIeI5JCjVLW7q7" +
       "DcqaSKHMi4pV/hso6oYmkKJSeJaUbjX9rAmslz+nNGL9FUGKWM/8PyMrI71q" +
       "gkYEUVAkRY206irqb0Qg4nQBt70RTeo0H9BsutT+iKGLkfZNSUGn1wl91MKu" +
       "6nX4XjvTDaZQg7GbQyEgd6rbtWXwiuWqHKd6pziQXNpw+vHOl02zQVO3dGdk" +
       "rEfjJBTibY7DTszBAqo3gtNC1Bw1p/2GFet3zioAK9E2FwJPYag6K2v2iNqe" +
       "nQ7HneLBqvItM0/Mey5MCmOkShBZUpBxMlii90CYETdanjiqC+YVO7zPcIR3" +
       "nJd0VaRxiC5+Yd5qpUTtozqWMzLO0UJ68kE3i/iHfk/85Mi9m29ZffOFYRLO" +
       "jujYZREEIxRvxTicibe1bk/2ardix8efH7x7q2r7dNYUkZ7ZciRRh1nuUXfT" +
       "0ynOnSE81fnM1lpO+0iIuUwAH4FwNs3dR1bIqE+HX9SlBBTuVvWEIOOrNMel" +
       "rFdXN9sl3BzH8OdxYBYl6ENTIG2wnIr/x7cTNMwnmuaLdubSgof3Re3a/W+9" +
       "+ueLOd3pmaDCMYW3U1bviD7YWBWPM2Nss12lUwr13r239a7dp3as5TYLNWq8" +
       "OqzFPApRR+BOsP2FTW+fPLH3zXDGzkMMpt9kF6xiUhklQ6jTiAAlobezbTwQ" +
       "vWRweLSa2msVsE+pWxK6ZIqO9Z+K2fOe+uuuStMOZChJm9H5gzdgl5+1lGx7" +
       "ed0X03gzIRFnT5szu5oZksfaLS/RdaEfcaRuOV79w2PC/RDcIaAa0hbKY2QR" +
       "56Ao29fRn9qTXQb4pZSAYeizppuLWteLO2tbPzCnkrM8BMx64x+J3L769xte" +
       "4YNcgp6P5ah3ucOvIUI4LKzSJP8r+AtB+h8mJB0LzLBdFbXmjhmZyUPTUoB8" +
       "TsBqL1uByNaqkxvv+/gxUwH35OqqTHcOfPerul0D5siZK5CanEWAU8ZchZjq" +
       "YLYQ0c0M6oVLNH50cOsvHtm6w0RVlT2fNsBy8bHf/feVunvfe9Ej0BdI1ipy" +
       "PpqtadDoe9ljYyq07DsVv7yjqqARYkYTKUkq0qYkbYo7W4QFlJHscgyWvbLh" +
       "BU7VcGAYCc2FMcCCy1wZL7yEQ7swA5BwgIS/W47ZbMMZTrOHz7Fu7hTvePPT" +
       "8tWfPnuaU5C98HZGj5WCZvI/BrOzkf+J7uluuWD0Qr35R5qvr5SPfAktdkCL" +
       "Iqw2jRYdJtZUVqyxaheN+MOvnpuw/vUCEm4kpbIqxBsFHrbJSIiX1OiFOTml" +
       "XXmVGS42Y5Ss5KqSHOVzCtBlp3sHg4aExrj7bnl64s+u2LfnBI9bGm+iOjcm" +
       "MytcMe+YjPk5mJ2XG+n8RF0jaJmYPcRrAoa4A7N2/qoJs1Wm7rEh0oQFbZr5" +
       "YgovxGlmatYahW9d7Wly/xsLfrvvB3dvNl0rIFC45Cb9u0XuuvX9f+WYG18V" +
       "eMQOl3xH5MB9k6OLP+Hy9vSM0rWp3GUdLHFs2Yv2Jz4Lzyp+PkxGdJBK0doq" +
       "rhbkJE56HbA9MtL7R9hOZr3P3uqY6/r6zPJjqjt4Obp1LwycMaGQZfm/vRYY" +
       "j+NyDqR5lvHMc9sdX3Ca3oSQ6ppgZ9dD9ar3H9j7xS07LgvjZFTUh9CBlUq7" +
       "XnMSd6S3HdhdXTbw3ve40afNrts0Y57PxewCbgoF+FgHc7nBN7cM1JEUQXbN" +
       "6eMCwDIyMrp8SXNnrKFxVSaOjbWtt2cw612fTcy5kOZbfc33IAYfeqE4jA9G" +
       "kFaYJTBTPNTx64KRUq5OW9PVyz31YXnqgwO9wOpsQYA+hfhw05D18esiPTwr" +
       "W5pbvNTZ+vXV4X2NgXS51dflOeoQ/rDdWwvigh0KaIqRMgbBQ4btSo+5OXUD" +
       "vy1P4KMhLbJ6W+QD/HY71u/MxeonzUiJ2C/KFPbwXkB3DYFhq6r53wPoQCBQ" +
       "P2kglQP1J3V3nlgrIEWt3qI+WH8ciNVPGuxWwENSloxTL6T3DQFpo9VXow/S" +
       "BwOR+kkD0niS9UeRWS+kD+WJtBxSk9VXkw/SRwOR+kkzMkLshVmZyl449+eJ" +
       "E1/FrJ5iPjifCMTpJw0x2MDBp22wW/GC+tM8oWIgbrE6a/GBeigQqp80w4Nh" +
       "2JcIcoPSR2VV88T7dJ54J0Bqs3ps88H7bCBeP2lGKmFn1M6oZgQBPpwn4MmQ" +
       "rrW6vNYH8POBgP2kAbCkiDqF3XAaMBe+FLOFJsx6x/OVYORdqipTQfFafTek" +
       "XJoeHYIprbGwrvHR9PVATf2kwZRENYln+EEjc3wIs8laq8e1PnjfCsTrJw2z" +
       "SU9Xo05hO6yI/V5Y3x5CjF5n9bbOB+vJQKx+0hCjmZSg7Zsp1byQvjeExYRg" +
       "9SX4IP0wEKmfNCwm0EH9gH6UJ9CJkOJWV3EfoKcCgfpJM1IO+yPumBm0L7nQ" +
       "/i1PtFWQeqz+enzQ/jMQrZ80wy9s3Ll8qf0sAGzKq9PMX9aHEkenvOaU9NpX" +
       "J9V+37L4edbeWwf2xFsenhe2jgGuQqNVtQtkCtHA0VQptpS1e1/Jv97ZW+F3" +
       "R9/5p5/X9izN5+MClk0b5PMB/p4OO865/gcCbijHbv3L5FWLe9fn8Z1guosl" +
       "d5OPrjzw4tVni3eG+adKc4+e84kzW6g+e2deqlOW1JXs87mazLjyc6FZkLZZ" +
       "47rNbYq25fidC/mJ8pr+50KhMlcFx7lQqByzYvA7g7L2zPrIawYs7FOleMay" +
       "QyPOxAESlofC2STVQNpuabo9f5L8RAcjaUoASdWYTQB3B5KWOZbloQqbj4nD" +
       "xcdcSAOWUgP58+EnOhgf5wbwgfvvUI3Jh3OydvJRO1x8zIS031Jqf/58+IkO" +
       "xkfA+XloAWYX4g6DsmhmM+RkY95wsbEC0kFLpYP5s+En6lK2wD4xsr8rvMR1" +
       "XxrAyzLMFsGaDnhxrD+dxCweLmLw8OeQpd2h/InxE/36xLQEEPMNzFbAsgyj" +
       "rrV2cLJyzXCxUgvpsKXa4fxZ8RMdzHmuD+BiHWbXwboE75OkD5GcZKwZLjJm" +
       "QzpmaXQsfzL8RAcjQwogA5dRobgZSUwyLnaxQYdz3n3NUum1/NnwEx2Mjb4A" +
       "Nni2yWRjNV5Lom429OFi42JIJyyVTuTPhp+od/jIvhya+YLPLwyY34uvLzt6" +
       "2HjowyfNj2de9wNc19Ee2VcivpM4+kF64b8gW71RkPosjPw/I9Eh3ZyKCjrT" +
       "pXgPTV/AOhPN4L5mtv9+wMHLnp/UvHrznpo/8i/HJZIBOwzYkHhc8XPIfHrg" +
       "5CfHy6sf5zuZQtyvIDXl7ruRuVcfs240clYr0HJ2mIYVcHhU2NVvralzTo7c" +
       "pfz3erNZc3Mausu0NJ47vnzwb1X8+43CsSxkpFjOHMIvRsnva3b7YesmGf6e" +
       "xKx7KfwDX1RWFYpXXNLvzFtpklqXuXkKLz2RhsImUt6ZwyE4ngDHfiDg3YOY" +
       "3c9IkYi4TDUCqj/s59WOAJBzVmffiwh9O6DtRzH7FoyfJgvu9e3NZ+QDuvf1" +
       "QOtWAQyF4zus+Qk5ZVrIFGfD/KRh/GB4HGcGNVm+xW82p8NJ0rzb3Cke3LOi" +
       "+cbTlz5s3g4TZWHLFmylDNzAvKhmuYHzVo27tXRbxcvnfDn6iZGz08FojAnY" +
       "DqNTbNLxdDmk4T2Mya6rU0Zt5gbV23uvePY3O4uPg9uvJSEBWFyb+7E9pSV1" +
       "Ur02lnv/BqIEv9NVP+dH/YvP7/77O5mv2tmXGNz1O8U3993wxp2T9k4Lk7Im" +
       "UiQpcZritwCW9SttVOzTO0i5ZDSkACK0Ar6TdblnNJ4rCHjnmfNi0VmeKcW7" +
       "hYzMyr3XlHsjs1RWN1N9qZpU4lbwKrNL0vEq63giqWkuAbvEEdGWmZHLnBIK" +
       "OmMrNS197YvAM3chX78K/Zo/4tNz/wfssHRJ9TAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Mt6q/xGqL5xC9ce3iOpBUMw9KvMcVP/pAlT37pX8XFH9yYWgdgZ8cADiYPga" +
       "dm1r0P/l1qK7ty8d9erh7fxUDyNw/3N16WDb8W+LT4bruyfip0DWvmeQ4B7h" +
       "/uPJaM81n/3Z//rJ3/9bT34N3CBQhzcIRW8RSJnv/z3/3xY//vzW+Dxa8OG9" +
       "JFR1Wo5iZvtUR9eOKJ1yerc73hugFD/0nn4tIpuHf/RUbs+a0+pYLGNlsW+3" +
       "mnwW4M1yJx6NVEgYjzvLQTvjCaHOs52ePRqtFEMwqCzEtLmhlxskxUMjlDBg" +
       "PmqFIgCPWpOR0uVcMYPWAbRMWoY2ERR5gbREW4tpucoEyDwQkZRDZtUULyMK" +
       "Yphrqj1E5nFF08sYvnGNIWdoLlbrCj6zHK0FPojaoRhWe8vQ7i5CiUqg/mLS" +
       "NfNldz6uWqk6IYa4hCP9TbZs+phFLPVsuvR5U4q7PXDPtfFIVuSlZavVkd2x" +
       "0LNVaupXZYfABZjgA5cfNeb02GFbNj8XJH455SKVCkZSecyMqGUS89M5LVCy" +
       "R4zrC9O0Zk3b5mdJtTLJGdufxLM6VrbGfVxeLtvanIH70HzZFXqsucBHlkBR" +
       "bZu3s1x0cZrS516AVwxyECTLwVRGRgrW8VatLkaRKrGS8InRRx3EgKYuOcjN" +
       "YOAtB8Diur32dJZ4lY4UKC26B/My05bHCtojeoSzmfZkm/WVhG0OtHHQFmJ6" +
       "DtOTliH4U5sM/LU2teq+SLHjDsFsmDwZt1iIFDtVqOHloyxyNuxAI2oczGxo" +
       "eeWEq4BeYimzbA7BnuuuM7M7hu2RQ8sdqUaSrQUEmb0OZI9mVQlyGoLFamgz" +
       "J8wc5vCJM5rLsEiw2nxi4lZE8Mww98WwmQXTnobDzqalM2SSOJQtO/VxWE0U" +
       "py2GdSoRdbM14w0p8T2ZXZHooGsGTYHAxYzAImg0YCF/4FJ9X/FWzDKczUbN" +
       "yag/75lh12C1rugR3VYzsDPBHokOhZOcHxjQiJ1Y3VE+msP8WqkPyZiXyV5t" +
       "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" +
       "dK61V3ZNgJm1XA8n0DxGTWUKIwmI3ySE");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qyVDE09Siu+0xO5aKWMd3Oen1UkIwY6bVloB2UlxsHmVtX5FSodYBcM4dJXC" +
       "8WrWYzdVrjFBcBzJch8WcLtG2xiQnzXy1XloxRkh4nwcT7mNwEEWOm/zdpMY" +
       "QM2wLmiK44K1C4n+0gWe2IKmK32githC2jDrEJk5/WgZgXViqywezP1JzVGy" +
       "QcjSUNoJ6ohpBaKdNJW009F64moO9K5FDrgVE7J8FceAU2IQdTHDGoPK3KvU" +
       "YnZTyYwo6o8pXCgejD33XPHI7Du39ijvrdtHk0eZu0sHKxq+fgtP6/LzHsEe" +
       "Pc09+rsu9fPE09xtz0cOh4Wlx87Lzt1mN332wy99RuN+pXpp/5gXK57Pe/5f" +
       "cfRUd05MdRnM9Mz5eSrMNjn5OFnktQ//j0eFH1+8cAvpko+fwnl6yl9jXv7d" +
       "3g+rf/tS6baj1JEb0qavH/Ts9Qkjl0M9TkJXuC5t5LEjyW5zjZ4A5YN7yX7w" +
       "9HPy44W8YYW2OSDv2SnCtu38xKKD+091OJFYdHClqO6JS/dFeswfvcc880Fw" +
       "6lnakVYdXL6VDKTixMGd1zN/EpSP7Jl/5E1i/thNmD9eVI/EpXsB8/aJd9wH" +
       "Dx6T/ME3SvIZUF7ak3zpTSL59E1Ilovq6o7kyRdzJ0k+9UZJvhuUz+1Jfu5N" +
       "IonehGTh9Q6g4kW8HhNHuQEnKVbfKEUKlFf2FF/5/lC87di1I0fVF7aEmjch" +
       "SxTVe+PSWwDZE29/T7J97o2yLdKOvrhn+8U3nS1zE7bFi6SDfly6u3BP+9eA" +
       "J6mSb5TqVVB+e0/1t98k3ZVuQrDY0A8EsAkWn2McpiKdZHhhTt5FDJ8C5bU9" +
       "w9feJIb6TRgWLw8PXthZ544hcorihbl838tW8pU9xa+8SRSDm1DcYnJ2FKfF" +
       "9zf6aYqrN0oRAeWre4pf/b6aJAi0njo/0Nom6u9S5j/zj5788gc+8+R/3uZo" +
       "321FUzlshuYZ32OdGPOtl7/2jT+877Hf2H4PcrsiR7tI6PSHbDd+p3bd52db" +
       "+PceCaTILdimI50rkDPjF2Ud677vl4590HbxXrzJwn60qHIw1nfk09vm+pZS" +
       "sM/+kMjfJXJen0Wwy1fOdzmpj5zQiV04/+BF1z0Riz953cJuv4E8jHaT3VeQ" +
       "z6uvfIZif/rb9V/ZffqiOvJmU8xyN1iD3Vc4+zU4+e3C6dkO57qz//R37//8" +
       "PU8dRvf37wAf6+cJbI+f/Z1JZ+XH2y9DNv/07V947z/+zFe3Wc//Hx/hb+Sc" +
       "OgAA");
}
