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
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "o41fb7o1+/vjH/7gJ3W960Zzb4N9NTe5mcHfswGsF4WnnqAoL+39y/Sta1I7" +
       "R3EFMztgpSDL77WdfvmuBeLDUX6Xax0mcu6A/USNfqgv0ykzdcUP7vOy+zoF" +
       "9+uz8LTZ+9oWdEfXc7hLLM69XAgjzXMMfzHP2AVsnmekSlIkxm/9Ngp6chDq" +
       "cxzY7Drxz28WdfnPv9jRpPH+c/5roVp4+myl+kZvjzDSgM4eQDnJub6Zxyhv" +
       "Y/MaI+MMyjr9ABYArcIBVUq6RvrVrTLSAniGbE2HRm+kMNKbGemDPEb6IzYX" +
       "GakAI63zoCB2v+Oa5NKtMgkeyPfZeu0bvUnCSPNofC3P2N+wucLIWNVkmmlF" +
       "UsASH/4/LJHxXs5rmnNOquR3S3gdUm9dh2Qi/hyRlWLSzaTwpJV5Pjjm/w46" +
       "0Gla/w92i2eOb2q/9/rKp6y7WVEWdvMcPxbqXuuaOAu/c0O5ObyKNy68Mf7s" +
       "mPlOoqqyBHY3c4bH4pCMIxreq00PXFwaddn7y/dOrH7ul8PFb0Clv51EBEYm" +
       "bM+9OMpoJuS97fHc+h5SFb9RbVz4+NCaJT1//S2/miPWeWBm+PxuseuRd1vP" +
       "9n+8lv8dVQQ5mGb4jdb6IWULFQd032FhPKYaAf8n5HawzTcu24s3+YzU5p6V" +
       "cv//KJPVQaqvc7wPjhtj3R4n7foylqlpAQK3x3OeHLZwD60PpVp3vE3TnKNk" +
       "TOO+eSC0eIuM5a/4Vv4/NE2yFyggAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+f8Awy/uPrMqAAA=");
}
