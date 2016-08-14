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
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C+zjyHmfdu/2Huu7271zfLbPvvde7DulS4miRAl3TUJS" +
       "IkVSoihKokQmzZpvUXy/RFLpxbGBxEbTukZyTtw2uT7gtGlwidOiaYsWKa4o" +
       "0iRIEDSB0SRFa7tB0aR1DdgNErd1G5ek/u/9767X5xPA0Wg4M/z9vvm+b76Z" +
       "od74cu1SFNbqvmfnhu3F17Usvr6x29fj3Nei69SozUphpKmYLUXRvCi7oTz3" +
       "S1f+7OufXF+9WLtPrL1Tcl0vlmLTcyNOizx7q6mj2pXj0oGtOVFcuzraSFsJ" +
       "SGLTBkZmFL88qr3jRNO4dm10CAEoIAAFBKCCACDHtYpGD2tu4mBlC8mNo6D2" +
       "Q7ULo9p9vlLCi2vPnu7El0LJOeiGrRgUPTxQ/uYLUlXjLKw9c8R9z/kmwp+q" +
       "A6/91A9c/cf31K6ItSumOyvhKAWIuHiIWHvI0RxZCyNEVTVVrD3qapo600JT" +
       "ss1dhVusPRaZhivFSagdCaksTHwtrJ55LLmHlJJbmCixFx7R003NVg9/XdJt" +
       "ySi4Pn7Mdc8QL8sLgpfNAlioS4p22ORey3TVuPb02RZHHK/RRYWi6f2OFq+9" +
       "o0fd60pFQe2x/djZkmsAszg0XaOoeslLiqfEtSdu2Wkpa19SLMnQbsS195yt" +
       "x+5vFbUerARRNolr7zpbreqpGKUnzozSifH5MvPKJ37QHboXK8yqptgl/geK" +
       "Rk+dacRpuhZqrqLtGz700ugnpcd/5eMXa7Wi8rvOVN7X+Wd/+avf+11Pvfnr" +
       "+zrvO6fORN5oSnxD+Yz8yO+8H3uxd08J4wHfi8xy8E8xr9SfPbjzcuYXlvf4" +
       "UY/lzeuHN9/k/q3wwz+vfeli7TJZu0/x7MQp9OhRxXN809ZCQnO1UIo1law9" +
       "qLkqVt0na/cX+ZHpavvSia5HWkzW7rWrovu86nchIr3oohTR/UXedHXvMO9L" +
       "8brKZ37t4HOpuN5zkK++4xoLrD1HAyRFck3XA9jQK/lHgObGciHbNeCbN/aZ" +
       "Um1kLweiUAH4AqIbS2G+lLbaAXwvvF5W8d+GPrOSx9X0woVCxO8/a+B2YRtD" +
       "z1a18IbyWoIOvvqLN37z4pHCH0igsLDz+69duFB1+x3lc/ajVsjcKqy38GsP" +
       "vTj7S9SHPv7cPYW6+Om9hcAuFlWBW7tX7NjeycqrKYXS1d78dPoR/sONi7WL" +
       "p/1kia0oulw2Z0vvduTFrp21j/P6vfKxP/6zz/7kq96xpZxyvAcGfHPL0gCf" +
       "OyvF0FM0tXBpx92/9Iz0yzd+5dVrF2v3FlZdeLJYKjSvcBJPnX3GKUN8+dCp" +
       "lVwuFYR1L3Qku7x16Ikux+vQS49LquF9pMo/Wsj4gVIznyquDxyoavVd3n2n" +
       "X6bfsVeHctDOsKic5l+c+T/z+7/931qVuA/965UTM9ZMi18+YdNlZ1cq6330" +
       "WAfmoaYV9f7Tp9mf+NSXP/Z9lQIUNZ4/74HXyhQrbFmqNOpHfj34gy98/jOf" +
       "u3ikNBfiYlJLZNtUsiOSF0pO99+GZPG07zzGU/gEu7ChUmuuLVzHU03dlGRb" +
       "K7X0/155ofnL/+MTV/d6YBclh2r0XXfu4Lj8vWjth3/zB772VNXNBaWck45l" +
       "dlxt7+jeedwzEoZSXuLIPvK7T/6NX5N+pnCZhZuKzJ1WeZ5LlQzKuOTF28Ql" +
       "oekUo7E98OXAq499wfrpP/6FvZ8+6/jPVNY+/tpf+cb1T7x28cTs+PxNE9TJ" +
       "NvsZslKjh/cj8o3ic6G4/ry8ypEoC/Ye8jHswE0/c+SnfT8r6Dx7O1jVI/A/" +
       "+uyr//LnXv3YnsZjpyeHQRH7/MK//3+/df3TX/yNc/zVPcXEX/5onUkq1ECF" +
       "+qUqvV7CrGRcq+69XCZPRyedyGlxn4jBbiif/NxXHua/8q++WiE4HcSdtJmx" +
       "5O/l9UiZPFPSf/dZjzmUonVRD3qT+f6r9ptfL3oUix6VInKJJmHhnrNTFnZQ" +
       "+9L9/+Ff/5vHP/Q799Qu4rXLtiepuFQ5q9qDhZfQonXh2TP/e753byRp6Ruu" +
       "VlRrN5GvCp642Y0ABxYGnO9GyvTZMnnhZuO8VdMz4r+wN/Pj8RneZnyoMsGq" +
       "W6+USX8P/Hu+KY77uu+pfj1ye5PCyzjz2J2/5/9MbPmjf/i/bhroahY6x8rO" +
       "tBeBN376Cey7v1S1P54OytZPZTdPy0VMftwW/HnnTy8+d9+vXqzdL9auKgcB" +
       "Py/ZSelkxSLIjQ5XAcWi4NT90wHrPjp7+Wi6e/9ZMz/x2LMT0bF5Ffmydpm/" +
       "fGbuedehK37vwci/96zSVNHCXo9LSNfJIj43tPCxP/w7n/naRz7WvVg6v0vb" +
       "EnohlavH9ZikXFf86BufevIdr33xx6rJ4VBn5nsdrNJrZfKBanzvKbMfLOaO" +
       "qFqixAUd05XsCjEU1x7EhghzYzTA50fO4eqxVi3upFWT05w/WFxPHHB+4hzO" +
       "ZYYvA6Ay86HbAS6T7yuT7z9EerlCypHE8Fyo0l1CLYfnfQdQ33cbqPeWmfXd" +
       "Qd0LdTxhJuchNb95pJULKTNPHiB98iaktSrjnw+wdojoHXFhqPZIc419OH8W" +
       "U3CXmB458Iq1w+9zMKV3wPSAkiu2VqxuzgOUfQtCevoA0NO3APRDdxJSBejW" +
       "QvrwXWK6UlzPHGB65haYfuQOmB6UHN8240TVzkP0o3eJ6OHievYA0bO3QPRX" +
       "74DofmVd+H3NPg/PX7tLPOWt5w7wPHcLPD9xBzyXo1JEGleEVOdBeu1bUKTn" +
       "DyA9fwtIf/NOirQtF9/abG3q8XmY/tZdYiqV54UDTC/cAtPfvZO1pcWCtVxF" +
       "FRPPC7ee76s4fB8Rv/73n//tD7/+/H+uQrAHzKiYFZHQOGff5USbr7zxhS/9" +
       "7sNP/mK13LtXlqL9/Hh2w+rm/ahT20wV5oeOZPBYyePx4vr8gQyq77g2/pZ2" +
       "CGZBIoXauVsO394O94PcqOS/z3fiQiZ5rPm+XzujEn/vjiqx7+dCsQy8BF6H" +
       "r1f9/qO7m5fevbGVa4cLEV4LoyJyu7ax4ar9u+KTgcZ+U+8MSOibBlko2SPH" +
       "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" +
       "yT96qyTLc6XBAcnB20Tya7ch+b/L5H+W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("50JajB0fVZ2g+CdvleK14iIPKJJvD8UL99ya4oVLZeGfF26kfHfz6LjyBMNv" +
       "vFWGYHFNDxhOvz0ML+5ffawYHtO8chuaj5bJ5ZOGykpmeJrqhXe8VaqlO+IP" +
       "qPJv02C+7zYsnyyTx/eDyVfnhmcYvvutMmwVl3rAUP32MLzneJL+uTMj+oHb" +
       "cH2xTJ4rHKtvS2ccz4Xn7+oNplu+iuv755xm7d/4yS6cnriPzOWxOz36xFz/" +
       "/KkZuvo7weFsmuz/UHBD+ezrFPODX+387P7lUcWWdruylwdGtfv377EezcjP" +
       "3rK3w77uG7749Ud+6cEXDqOHR/aAj4ftBLanz39Tc+D4cfVu5e6fv/ufvPIP" +
       "Xv989d7Q/wdSs2V35zEAAA==");
}
