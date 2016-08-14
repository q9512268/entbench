class SoundChip {
    javax.sound.sampled.SourceDataLine soundLine;
    SquareWaveGenerator channel1;
    SquareWaveGenerator channel2;
    VoluntaryWaveGenerator channel3;
    NoiseGenerator channel4;
    boolean soundEnabled = false;
    boolean channel1Enable = true;
    boolean channel2Enable = true;
    boolean channel3Enable = true;
    boolean channel4Enable = true;
    int sampleRate = 44100;
    int bufferLengthMsec = 200;
    public SoundChip() { super();
                         soundLine = initSoundHardware();
                         channel1 = new SquareWaveGenerator(sampleRate);
                         channel2 = new SquareWaveGenerator(sampleRate);
                         channel3 = new VoluntaryWaveGenerator(sampleRate);
                         channel4 = new NoiseGenerator(sampleRate); }
    public javax.sound.sampled.SourceDataLine initSoundHardware() { try {
                                                                        javax.sound.sampled.AudioFormat format =
                                                                          new javax.sound.sampled.AudioFormat(
                                                                          javax.sound.sampled.AudioFormat.Encoding.
                                                                            PCM_SIGNED,
                                                                          sampleRate,
                                                                          8,
                                                                          2,
                                                                          2,
                                                                          sampleRate,
                                                                          true);
                                                                        javax.sound.sampled.DataLine.Info lineInfo =
                                                                          new javax.sound.sampled.DataLine.Info(
                                                                          javax.sound.sampled.SourceDataLine.class,
                                                                          format);
                                                                        if (!javax.sound.sampled.AudioSystem.
                                                                              isLineSupported(
                                                                                lineInfo)) {
                                                                            java.lang.System.
                                                                              out.
                                                                              println(
                                                                                "Error: Can\'t find audio output system!");
                                                                            soundEnabled =
                                                                              false;
                                                                        }
                                                                        else {
                                                                            javax.sound.sampled.SourceDataLine line =
                                                                              (javax.sound.sampled.SourceDataLine)
                                                                                javax.sound.sampled.AudioSystem.
                                                                                getLine(
                                                                                  lineInfo);
                                                                            int bufferLength =
                                                                              sampleRate /
                                                                              1000 *
                                                                              bufferLengthMsec;
                                                                            line.
                                                                              open(
                                                                                format,
                                                                                bufferLength);
                                                                            line.
                                                                              start(
                                                                                );
                                                                            soundEnabled =
                                                                              true;
                                                                            return line;
                                                                        }
                                                                    }
                                                                    catch (java.lang.Exception e) {
                                                                        java.lang.System.
                                                                          out.
                                                                          println(
                                                                            "Error: Audio system busy!");
                                                                        soundEnabled =
                                                                          false;
                                                                    }
                                                                    return null;
    }
    public void setSampleRate(int sr) { sampleRate =
                                          sr;
                                        soundLine.
                                          flush(
                                            );
                                        soundLine.
                                          close(
                                            );
                                        soundLine =
                                          initSoundHardware(
                                            );
                                        channel1.
                                          setSampleRate(
                                            sr);
                                        channel2.
                                          setSampleRate(
                                            sr);
                                        channel3.
                                          setSampleRate(
                                            sr);
                                        channel4.
                                          setSampleRate(
                                            sr);
    }
    public void setBufferLength(int time) {
        bufferLengthMsec =
          time;
        soundLine.
          flush(
            );
        soundLine.
          close(
            );
        soundLine =
          initSoundHardware(
            );
    }
    public void outputSound() { if (soundEnabled) {
                                    int numSamples;
                                    if (sampleRate /
                                          28 >=
                                          soundLine.
                                          available(
                                            ) *
                                          2) {
                                        numSamples =
                                          soundLine.
                                            available(
                                              ) *
                                            2;
                                    }
                                    else {
                                        numSamples =
                                          sampleRate /
                                            28 &
                                            65534;
                                    }
                                    byte[] b =
                                      new byte[numSamples];
                                    if (channel1Enable)
                                        channel1.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    if (channel2Enable)
                                        channel2.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    if (channel3Enable)
                                        channel3.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    if (channel4Enable)
                                        channel4.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    soundLine.
                                      write(
                                        b,
                                        0,
                                        numSamples);
                                } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZfZAURxXv3fvkjuM++P464LigkOQ2fAWTi5jjOMLhHlxx" +
       "iHoElt7ZvtuB2ZlhpudujwSTEK2AVUFEICSV4B+SClJEUpYptTQpYsqEVGKs" +
       "fBmjFbCMlmiSMmgZLVHjez0zOx97s9SlwlZN72x3v9fvvX7v9173nn6fVJgG" +
       "aWYqb+MjOjPbulTeSw2TZToVapqboC8lPVBG/77t4vqb4qSyn0zIUrNHoiZb" +
       "IzMlY/aT2bJqcqpKzFzPWAYpeg1mMmOIcllT+8lk2ezO6YosybxHyzCcsJka" +
       "SdJIOTfktMVZt8OAk9lJkCQhJEl0hIfbk2S8pOkj3vRpvumdvhGcmfPWMjlp" +
       "SO6gQzRhcVlJJGWTt+cNcq2uKSODisbbWJ637VCWOyZYl1xeZIKWJ+o/vHww" +
       "2yBMMJGqqsaFeuZGZmrKEMskSb3X26WwnLmLfIWUJUmtbzInrUl30QQsmoBF" +
       "XW29WSB9HVOtXKcm1OEup0pdQoE4mRdkolOD5hw2vUJm4FDNHd0FMWg7t6Ct" +
       "rWWRikeuTRx+YFvD98tIfT+pl9U+FEcCITgs0g8GZbk0M8yOTIZl+kmjCpvd" +
       "xwyZKvJuZ6ebTHlQpdyC7XfNgp2Wzgyxpmcr2EfQzbAkrhkF9QaEQzm/KgYU" +
       "Ogi6TvF0tTVcg/2gYI0MghkDFPzOISnfKasZTuaEKQo6tn4eJgBpVY7xrFZY" +
       "qlyl0EGabBdRqDqY6APXUwdhaoUGDmhwMiOSKdpap9JOOshS6JGheb32EMwa" +
       "JwyBJJxMDk8TnGCXZoR2ybc/76+/5cAd6lo1TmIgc4ZJCspfC0TNIaKNbIAZ" +
       "DOLAJhy/KHmUTnlqX5wQmDw5NNme88M7L916XfPZc/acmaPM2ZDewSSekk6k" +
       "J7wyq3PhTWUoRrWumTJufkBzEWW9zkh7XgeEmVLgiINt7uDZjc99+e5T7N04" +
       "qekmlZKmWDnwo0ZJy+mywozbmMoMylmmm4xjaqZTjHeTKnhPyiqzezcMDJiM" +
       "d5NyRXRVauI3mGgAWKCJauBdVgc0912nPCve8zpxPhXwJJx38c1JZyKr5ViC" +
       "SlSVVS3Ra2iov5kAxEmDbbMJXU7ZL+g2aW0kYRpSok+zQM6srLdhr/7JsMmj" +
       "tBOHYzEw5KxwGCsQAWs1JcOMlHTYWtV16XupF20XQbd29ORkXIElicUEp0nI" +
       "2t4OMOZOCEvAxfEL+7au276vpQz8QB8uB0vg1JZAfuj0YtcF3JR0pqlu97zz" +
       "i5+Nk/IkaaISt6iCcN9hDAKQSDudWBufhszhAfhcH4Bj5jE0iWUAP6KA3OFS" +
       "rQ0xA/s5meTj4KYXDKRENLiPKj85e2z4ns133RAn8SBm45IVADdI3otIW0DU" +
       "1nCsjsa3/r6LH545ukfzojaQBNzcVUSJOrSE9zpsnpS0aC59MvXUnlZh9nGA" +
       "qpxCFABgNYfXCIBCuwuwqEs1KDygGTmq4JBr4xqeNbRhr0c4YaN4nwRuUY1R" +
       "0gjPaidsxDeOTtGxnWo7LfpZSAsB4J/t0x/59ct/XirM7WJ9vS9J9zHe7sMX" +
       "ZNYkkKTRc9tNBmMw7+1jvd868v59W4TPwoz5oy3Yim0n4ApsIZj5a+d2vXXh" +
       "/InX456fc0iwVhrqlHxByRjqVFVCSVhtgScP4JMCwY1e0/oFFfxTHpBpWmEY" +
       "WP+pv2bxk+8daLD9QIEe142uuzIDr3/6KnL3i9v+2SzYxCTMj57NvGk26E70" +
       "OHcYBh1BOfL3vDr7wefpIwDfAJmmvJvZKChsQMSmLRf63yDaZaGxFdhcY/qd" +
       "PxhfvjomJR18/YO6zR88fUlIGyyE/HvdQ/V2272wWZAH9lPD4LSWmlmYt+zs" +
       "+tsblLOXgWM/cJQg+5sbDAC/fMAznNkVVb955tkp218pI/E1pEbRaGYNFUFG" +
       "xoF3MzMLuJnXP3ervbnD6NMNQlVSpHxRBxp4zuhb15XTuTD27h9N/cEtjx0/" +
       "L7xMt3nMFPTjEcoDqCrKaS+wT7224o3Hvnl02E7IC6PRLEQ37d8blPTe3/+r" +
       "yOQCx0YpFkL0/YnTD8/oXPmuoPcABalb88XpB0DZo11yKvePeEvlz+Okqp80" +
       "SE75upkqFoZpP5RsplvTQokbGA+WX3at0V4AzFlhMPMtG4YyL+3BO87G97oQ" +
       "eonAngHPYiewF4fRK0bES7cg+ZRoF2Fzvd8fCqxiJVhB7jUx92LFIqimcdIi" +
       "0nqb6G8zKRyPWKYNMrQhsdWUU5xqwye2n8Fmnb1ie6SzdgYlaoZnqSPR0gjl" +
       "+mzlsEkW6xNFzUm1lAXHYspiV52JfbssarAv0iHmlGyaEZJ/08eQf5kjwbII" +
       "+W8vKX8UtSf/Evz9pZCgW8co6Dx4ljtLLY8QVCopaBS1J+hS19BTNkMJDCFp" +
       "jJSydWaMKkyH50ZHiBsjVFBKqhBF7amwzFVhwnpNNiNFz30MN1nhLL4iQnSr" +
       "pOhR1BwwGsOzS8UMnAlWwVhp9llpEypWOQcFypBz1FrSu13a19r7Bxu1p49C" +
       "YM+bfDJx/+Y3d7wkyp9qrIk3uUjlq3ihdvbVXg227B/BJwbP//BBmbEDvwFC" +
       "O51z09zCwQmzTsn0EVIgsafpws6HLz5uKxDOFaHJbN/hr3/UduCwXdPYp+/5" +
       "RQdgP419ArfVwWYPSjev1CqCYs2fzuz5yck999lSNQXPkl2qlXv8V/99qe3Y" +
       "714Y5eBTldY0hVG1kMBjhWPNpOD+2Eqt3l//04NNZWugou4m1ZYq77JYdyaY" +
       "V6pMK+3bMO9k7+UaRz3cHE5ii2AfQp4+NEZPx9Bqd3z15ghPv7+kp98cQQ0x" +
       "6QK67ezYe2dI3ANXQdzD2HzDW35J9PJHrsLyD4aWXxq9/ENXYfnjoeWXRS//" +
       "7TEuPw2elc7yKyOW/05JX4mi5qTGLlc2AroIst1OHOPXXb73ezkpk53LS1/Y" +
       "4c/94Vg4MUb9ZsHT4UjYEaHfmZL6RVFz0pC2BuCknGTqIM/2mEzC/pMhgZ8o" +
       "IXB+tIULn8Atk29h39mAICjOjroIFIB4Yu/h45kNjy6OO8eyr0KRyTX9eoUN" +
       "McXHqhw5BY4ZPeLq06vZ355w6J0ftw6uGsu9DfY1X+FmBn/PAbBeFJ16wqI8" +
       "v/cvMzatzG4fwxXMnJCVwiy/23P6hdsWSIfi4p7XPkwU3Q8HidqDUF9jMG4Z" +
       "ahDc5xf2dSru16fh6XH2tSfsjp7nCJe4tvhyIYq0xDH8uRJj57B5hpNGWZW5" +
       "uPVbS43MMNTnOLDBc+KfXSnqSp9/saNDF/1PBa+FWuDZ4Si1Y+z2iCIN6ewD" +
       "lJOC62sljPIGNi9zUmcy3hcEsBBolQ9pcsYz0i+vlpEWwDPiaDoydiNFkV7J" +
       "SO+UMNIfsTnPST0YaZUPBbH7Tc8kF66WSfBAfq+j171jN0kUaQmNPygx9jds" +
       "3uWkVrO4btmRFLLEe5+EJfL+y3ldd89JDeJuCa9D2uzrkHwsmCMKUky+khS+" +
       "tDI/AMfin0MXOi37v8OUdOb4uvV3XLrxUftuVlLobpHja6Huta+JC/A7L5Kb" +
       "y6ty7cLLE54Yd42bqBptgb3NnOmzOCTjmI73ajNCF5dma+H+8q0Ttzz9i32V" +
       "r0Klv4XEKCcTtxRfHOV1C/LelmRxfQ+pStyoti98aGTldQN//a24miP2eWBW" +
       "9PyU9PpjW187NO1Ec5zUdpMKyMEsL260Vo+oG5k0ZPSTOtnsyoOIwEWmSuDw" +
       "MAFTD8X/FIVdHHPWFXrxZp+TluKzU/H/ITWKNsyMVa43wvGj1utx03Agg1m6" +
       "HiLwenzny302DuJuQOmWSvbounu0JAldOOv+yGouVite8W38/wHbmdPkVSAA" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "81m97yoAAA==");
}
