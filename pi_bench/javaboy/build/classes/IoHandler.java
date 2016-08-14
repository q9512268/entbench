class IoHandler {
    byte[] registers = new byte[256];
    Dmgcpu dmgcpu;
    boolean padLeft;
    boolean padRight;
    boolean padUp;
    boolean padDown;
    boolean padA;
    boolean padB;
    boolean padStart;
    boolean padSelect;
    boolean hdmaRunning;
    public IoHandler(Dmgcpu d) { super();
                                 dmgcpu = d;
                                 reset(); }
    public void reset() { java.lang.System.out.println("Hardware reset");
                          for (int r = 0; r < 255; r++) { ioWrite(r, (short)
                                                                       0);
                          }
                          ioWrite(64, (short) 145);
                          ioWrite(15, (short) 1);
                          hdmaRunning = false; }
    public void toggleKey(java.lang.String keyName) { if (keyName.equals(
                                                                    "a")) {
                                                          padA =
                                                            !padA;
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "- A is now " +
                                                              padA);
                                                      }
                                                      else
                                                          if (keyName.
                                                                equals(
                                                                  "b")) {
                                                              padB =
                                                                !padB;
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "- B is now " +
                                                                  padB);
                                                          }
                                                          else
                                                              if (keyName.
                                                                    equals(
                                                                      "up")) {
                                                                  padUp =
                                                                    !padUp;
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      "- Up is now " +
                                                                      padUp);
                                                              }
                                                              else
                                                                  if (keyName.
                                                                        equals(
                                                                          "down")) {
                                                                      padDown =
                                                                        !padDown;
                                                                      java.lang.System.
                                                                        out.
                                                                        println(
                                                                          "- Down is now " +
                                                                          padDown);
                                                                  }
                                                                  else
                                                                      if (keyName.
                                                                            equals(
                                                                              "left")) {
                                                                          padLeft =
                                                                            !padLeft;
                                                                          java.lang.System.
                                                                            out.
                                                                            println(
                                                                              "- Left is now " +
                                                                              padLeft);
                                                                      }
                                                                      else
                                                                          if (keyName.
                                                                                equals(
                                                                                  "right")) {
                                                                              padRight =
                                                                                !padRight;
                                                                              java.lang.System.
                                                                                out.
                                                                                println(
                                                                                  "- Right is now " +
                                                                                  padRight);
                                                                          }
                                                                          else
                                                                              if (keyName.
                                                                                    equals(
                                                                                      "select")) {
                                                                                  padSelect =
                                                                                    !padSelect;
                                                                                  java.lang.System.
                                                                                    out.
                                                                                    println(
                                                                                      "- Select is now " +
                                                                                      padSelect);
                                                                              }
                                                                              else
                                                                                  if (keyName.
                                                                                        equals(
                                                                                          "start")) {
                                                                                      padStart =
                                                                                        !padStart;
                                                                                      java.lang.System.
                                                                                        out.
                                                                                        println(
                                                                                          "- Start is now " +
                                                                                          padStart);
                                                                                  }
                                                                                  else {
                                                                                      java.lang.System.
                                                                                        out.
                                                                                        println(
                                                                                          "- Key name \'" +
                                                                                          keyName +
                                                                                          "\' not recognised");
                                                                                  }
    }
    public void performHdma() { int dmaSrc =
                                  (JavaBoy.
                                     unsign(
                                       registers[81]) <<
                                     8) +
                                  (JavaBoy.
                                     unsign(
                                       registers[82]) &
                                     240);
                                int dmaDst =
                                  ((JavaBoy.
                                      unsign(
                                        registers[83]) &
                                      31) <<
                                     8) +
                                  (JavaBoy.
                                     unsign(
                                       registers[84]) &
                                     240) +
                                  32768;
                                for (int r =
                                       0;
                                     r <
                                       16;
                                     r++) {
                                    dmgcpu.
                                      addressWrite(
                                        dmaDst +
                                          r,
                                        dmgcpu.
                                          addressRead(
                                            dmaSrc +
                                              r));
                                }
                                dmaSrc +=
                                  16;
                                dmaDst +=
                                  16;
                                registers[81] =
                                  (byte)
                                    ((dmaSrc &
                                        65280) >>
                                       8);
                                registers[82] =
                                  (byte)
                                    (dmaSrc &
                                       240);
                                registers[83] =
                                  (byte)
                                    ((dmaDst &
                                        7936) >>
                                       8);
                                registers[84] =
                                  (byte)
                                    (dmaDst &
                                       240);
                                int len =
                                  JavaBoy.
                                  unsign(
                                    registers[85]);
                                if (len ==
                                      0) {
                                    registers[85] =
                                      (byte)
                                        255;
                                    hdmaRunning =
                                      false;
                                }
                                else {
                                    len--;
                                    registers[85] =
                                      (byte)
                                        len;
                                } }
    public short ioRead(int num) { if (num <=
                                         75) {
                                       
                                   }
                                   switch (num) {
                                       case 65:
                                           int output =
                                             0;
                                           if (registers[68] ==
                                                 registers[69]) {
                                               output |=
                                                 4;
                                           }
                                           int cyclePos =
                                             dmgcpu.
                                               instrCount %
                                             dmgcpu.
                                               INSTRS_PER_HBLANK;
                                           int sectionLength =
                                             dmgcpu.
                                               INSTRS_PER_HBLANK /
                                             6;
                                           if (JavaBoy.
                                                 unsign(
                                                   registers[68]) >
                                                 144) {
                                               output |=
                                                 1;
                                           }
                                           else {
                                               if (cyclePos <=
                                                     sectionLength *
                                                     3) {
                                                   
                                               }
                                               else
                                                   if (cyclePos <=
                                                         sectionLength *
                                                         4) {
                                                       output |=
                                                         2;
                                                   }
                                                   else {
                                                       output |=
                                                         3;
                                                   }
                                           }
                                           return (byte)
                                                    (output |
                                                       registers[65] &
                                                       248);
                                       case 85:
                                           return (byte)
                                                    registers[85];
                                       case 105:
                                           if (dmgcpu.
                                                 gbcFeatures) {
                                               int palNumber =
                                                 (registers[104] &
                                                    56) >>
                                                 3;
                                               return dmgcpu.
                                                        graphicsChip.
                                                        gbcBackground[palNumber].
                                                 getGbcColours(
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[104]) &
                                                      6) >>
                                                     1,
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[104]) &
                                                      1) ==
                                                     1);
                                           }
                                           else {
                                               return registers[num];
                                           }
                                       case 107:
                                           if (dmgcpu.
                                                 gbcFeatures) {
                                               int palNumber =
                                                 (registers[106] &
                                                    56) >>
                                                 3;
                                               return dmgcpu.
                                                        graphicsChip.
                                                        gbcSprite[palNumber].
                                                 getGbcColours(
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[106]) &
                                                      6) >>
                                                     1,
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[106]) &
                                                      1) ==
                                                     1);
                                           }
                                           else {
                                               return registers[num];
                                           }
                                       default:
                                           return registers[num];
                                   } }
    public void ioWrite(int num, short data) {
        boolean soundOn =
          dmgcpu.
            soundChip !=
          null;
        if (num <=
              75) {
            
        }
        switch (num) {
            case 0:
                short output =
                  15;
                if ((data &
                       16) ==
                      0) {
                    if (padRight) {
                        output &=
                          ~1;
                    }
                    if (padLeft) {
                        output &=
                          ~2;
                    }
                    if (padUp) {
                        output &=
                          ~4;
                    }
                    if (padDown) {
                        output &=
                          ~8;
                    }
                }
                if ((data &
                       32) ==
                      0) {
                    if (padA) {
                        output &=
                          ~1;
                    }
                    if (padB) {
                        output &=
                          ~2;
                    }
                    if (padSelect) {
                        output &=
                          ~4;
                    }
                    if (padStart) {
                        output &=
                          ~8;
                    }
                }
                output |=
                  data &
                    240;
                registers[0] =
                  (byte)
                    output;
                break;
            case 2:
                registers[2] =
                  (byte)
                    data;
                if (dmgcpu.
                      gameLink !=
                      null) {
                    if ((JavaBoy.
                           unsign(
                             data) &
                           129) ==
                          129) {
                        dmgcpu.
                          gameLink.
                          send(
                            registers[1]);
                    }
                }
                else {
                    if ((registers[2] &
                           1) ==
                          1) {
                        registers[1] =
                          (byte)
                            255;
                        if (dmgcpu.
                              running)
                            dmgcpu.
                              triggerInterruptIfEnabled(
                                dmgcpu.
                                  INT_SER);
                        registers[2] &=
                          127;
                    }
                }
                break;
            case 4:
                registers[4] =
                  0;
                break;
            case 7:
                if ((data &
                       4) ==
                      0) {
                    dmgcpu.
                      timaEnabled =
                      false;
                }
                else {
                    dmgcpu.
                      timaEnabled =
                      true;
                }
                int instrsPerSecond =
                  dmgcpu.
                    INSTRS_PER_VBLANK *
                  60;
                int clockFrequency =
                  data &
                  3;
                switch (clockFrequency) {
                    case 0:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            4096;
                        break;
                    case 1:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            262144;
                        break;
                    case 2:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            65536;
                        break;
                    case 3:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            16384;
                        break;
                }
                break;
            case 16:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel1.
                      setSweep(
                        (JavaBoy.
                           unsign(
                             data) &
                           112) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          1);
                registers[16] =
                  (byte)
                    data;
                break;
            case 17:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel1.
                      setDutyCycle(
                        (JavaBoy.
                           unsign(
                             data) &
                           192) >>
                          6);
                    dmgcpu.
                      soundChip.
                      channel1.
                      setLength(
                        JavaBoy.
                          unsign(
                            data) &
                          63);
                }
                registers[17] =
                  (byte)
                    data;
                break;
            case 18:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel1.
                      setEnvelope(
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8);
                }
                registers[18] =
                  (byte)
                    data;
                break;
            case 19:
                registers[19] =
                  (byte)
                    data;
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel1.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[20]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[19]));
                }
                break;
            case 20:
                registers[20] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[20] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel1.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[17]) &
                              63);
                        dmgcpu.
                          soundChip.
                          channel1.
                          setEnvelope(
                            (JavaBoy.
                               unsign(
                                 registers[18]) &
                               240) >>
                              4,
                            JavaBoy.
                              unsign(
                                registers[18]) &
                              7,
                            (JavaBoy.
                               unsign(
                                 registers[18]) &
                               8) ==
                              8);
                    }
                    if ((registers[20] &
                           64) ==
                          0) {
                        dmgcpu.
                          soundChip.
                          channel1.
                          setLength(
                            -1);
                    }
                    dmgcpu.
                      soundChip.
                      channel1.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[20]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[19]));
                }
                break;
            case 23:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel2.
                      setEnvelope(
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8);
                }
                registers[23] =
                  (byte)
                    data;
                break;
            case 24:
                registers[24] =
                  (byte)
                    data;
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel2.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[25]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[24]));
                }
                break;
            case 25:
                registers[25] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[25] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel2.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[33]) &
                              63);
                        dmgcpu.
                          soundChip.
                          channel2.
                          setEnvelope(
                            (JavaBoy.
                               unsign(
                                 registers[23]) &
                               240) >>
                              4,
                            JavaBoy.
                              unsign(
                                registers[23]) &
                              7,
                            (JavaBoy.
                               unsign(
                                 registers[23]) &
                               8) ==
                              8);
                    }
                    if ((registers[25] &
                           64) ==
                          0) {
                        dmgcpu.
                          soundChip.
                          channel2.
                          setLength(
                            -1);
                    }
                    dmgcpu.
                      soundChip.
                      channel2.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[25]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[24]));
                }
                break;
            case 22:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel2.
                      setDutyCycle(
                        (JavaBoy.
                           unsign(
                             data) &
                           192) >>
                          6);
                    dmgcpu.
                      soundChip.
                      channel2.
                      setLength(
                        JavaBoy.
                          unsign(
                            data) &
                          63);
                }
                registers[22] =
                  (byte)
                    data;
                break;
            case 26:
                if (soundOn) {
                    if ((JavaBoy.
                           unsign(
                             data) &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel3.
                          setVolume(
                            (JavaBoy.
                               unsign(
                                 registers[28]) &
                               96) >>
                              5);
                    }
                    else {
                        dmgcpu.
                          soundChip.
                          channel3.
                          setVolume(
                            0);
                    }
                }
                registers[26] =
                  (byte)
                    data;
                break;
            case 27:
                registers[27] =
                  (byte)
                    data;
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setLength(
                        JavaBoy.
                          unsign(
                            data));
                break;
            case 28:
                registers[28] =
                  (byte)
                    data;
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setVolume(
                        (JavaBoy.
                           unsign(
                             registers[28]) &
                           96) >>
                          5);
                break;
            case 29:
                registers[29] =
                  (byte)
                    data;
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[30]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[29]));
                break;
            case 30:
                registers[30] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[25] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel3.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[27]));
                    }
                    dmgcpu.
                      soundChip.
                      channel3.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[30]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[29]));
                }
                break;
            case 32:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel4.
                      setLength(
                        JavaBoy.
                          unsign(
                            data) &
                          63);
                registers[32] =
                  (byte)
                    data;
                break;
            case 33:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel4.
                      setEnvelope(
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8);
                registers[33] =
                  (byte)
                    data;
                break;
            case 34:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel4.
                      setParameters(
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8,
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4);
                registers[34] =
                  (byte)
                    data;
                break;
            case 35:
                registers[35] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[35] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel4.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[32]) &
                              63);
                    }
                    if ((registers[35] &
                           64) ==
                          0) {
                        dmgcpu.
                          soundChip.
                          channel4.
                          setLength(
                            -1);
                    }
                }
                break;
            case 37:
                int chanData;
                registers[37] =
                  (byte)
                    data;
                if (soundOn) {
                    chanData =
                      0;
                    if ((JavaBoy.
                           unsign(
                             data) &
                           1) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_LEFT;
                    }
                    if ((JavaBoy.
                           unsign(
                             data) &
                           16) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_RIGHT;
                    }
                    dmgcpu.
                      soundChip.
                      channel1.
                      setChannel(
                        chanData);
                    chanData =
                      0;
                    if ((JavaBoy.
                           unsign(
                             data) &
                           2) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_LEFT;
                    }
                    if ((JavaBoy.
                           unsign(
                             data) &
                           32) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_RIGHT;
                    }
                    dmgcpu.
                      soundChip.
                      channel2.
                      setChannel(
                        chanData);
                    chanData =
                      0;
                    if ((JavaBoy.
                           unsign(
                             data) &
                           4) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_LEFT;
                    }
                    if ((JavaBoy.
                           unsign(
                             data) &
                           64) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_RIGHT;
                    }
                    dmgcpu.
                      soundChip.
                      channel3.
                      setChannel(
                        chanData);
                }
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setSamplePair(
                        num -
                          48,
                        JavaBoy.
                          unsign(
                            data));
                registers[num] =
                  (byte)
                    data;
                break;
            case 64:
                dmgcpu.
                  graphicsChip.
                  bgEnabled =
                  true;
                if ((data &
                       32) ==
                      32) {
                    dmgcpu.
                      graphicsChip.
                      winEnabled =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      winEnabled =
                      false;
                }
                if ((data &
                       16) ==
                      16) {
                    dmgcpu.
                      graphicsChip.
                      bgWindowDataSelect =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      bgWindowDataSelect =
                      false;
                }
                if ((data &
                       8) ==
                      8) {
                    dmgcpu.
                      graphicsChip.
                      hiBgTileMapAddress =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      hiBgTileMapAddress =
                      false;
                }
                if ((data &
                       4) ==
                      4) {
                    dmgcpu.
                      graphicsChip.
                      doubledSprites =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      doubledSprites =
                      false;
                }
                if ((data &
                       2) ==
                      2) {
                    dmgcpu.
                      graphicsChip.
                      spritesEnabled =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      spritesEnabled =
                      false;
                }
                if ((data &
                       1) ==
                      0) {
                    dmgcpu.
                      graphicsChip.
                      bgEnabled =
                      false;
                    dmgcpu.
                      graphicsChip.
                      winEnabled =
                      false;
                }
                registers[64] =
                  (byte)
                    data;
                break;
            case 65:
                registers[65] =
                  (byte)
                    data;
                break;
            case 66:
                registers[66] =
                  (byte)
                    data;
                break;
            case 67:
                registers[67] =
                  (byte)
                    data;
                break;
            case 70:
                int sourceAddress =
                  data <<
                  8;
                for (int i =
                       0;
                     i <
                       160;
                     i++) {
                    dmgcpu.
                      addressWrite(
                        65024 +
                          i,
                        dmgcpu.
                          addressRead(
                            sourceAddress +
                              i));
                }
                break;
            case 71:
                dmgcpu.
                  graphicsChip.
                  backgroundPalette.
                  decodePalette(
                    data);
                if (registers[num] !=
                      (byte)
                        data) {
                    registers[num] =
                      (byte)
                        data;
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        GraphicsChip.
                          TILE_BKG);
                }
                break;
            case 72:
                dmgcpu.
                  graphicsChip.
                  obj1Palette.
                  decodePalette(
                    data);
                if (registers[num] !=
                      (byte)
                        data) {
                    registers[num] =
                      (byte)
                        data;
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        GraphicsChip.
                          TILE_OBJ1);
                }
                break;
            case 73:
                dmgcpu.
                  graphicsChip.
                  obj2Palette.
                  decodePalette(
                    data);
                if (registers[num] !=
                      (byte)
                        data) {
                    registers[num] =
                      (byte)
                        data;
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        GraphicsChip.
                          TILE_OBJ2);
                }
                break;
            case 79:
                if (dmgcpu.
                      gbcFeatures) {
                    dmgcpu.
                      graphicsChip.
                      tileStart =
                      (data &
                         1) *
                        384;
                    dmgcpu.
                      graphicsChip.
                      vidRamStart =
                      (data &
                         1) *
                        8192;
                }
                registers[79] =
                  (byte)
                    data;
                break;
            case 85:
                if (!hdmaRunning &&
                      (registers[85] &
                         128) ==
                      0 &&
                      (data &
                         128) ==
                      0) {
                    int dmaSrc =
                      (JavaBoy.
                         unsign(
                           registers[81]) <<
                         8) +
                      (JavaBoy.
                         unsign(
                           registers[82]) &
                         240);
                    int dmaDst =
                      ((JavaBoy.
                          unsign(
                            registers[83]) &
                          31) <<
                         8) +
                      (JavaBoy.
                         unsign(
                           registers[84]) &
                         240) +
                      32768;
                    int dmaLen =
                      (JavaBoy.
                         unsign(
                           data) &
                         127) *
                      16 +
                      16;
                    if (dmaLen >
                          2048)
                        dmaLen =
                          2048;
                    for (int r =
                           0;
                         r <
                           dmaLen;
                         r++) {
                        dmgcpu.
                          addressWrite(
                            dmaDst +
                              r,
                            dmgcpu.
                              addressRead(
                                dmaSrc +
                                  r));
                    }
                }
                else {
                    if ((JavaBoy.
                           unsign(
                             data) &
                           128) ==
                          128) {
                        hdmaRunning =
                          true;
                        registers[85] =
                          (byte)
                            (data &
                               127);
                        break;
                    }
                    else
                        if (hdmaRunning &&
                              (JavaBoy.
                                 unsign(
                                   data) &
                                 128) ==
                              0) {
                            hdmaRunning =
                              false;
                        }
                }
                registers[85] =
                  (byte)
                    data;
                break;
            case 105:
                if (dmgcpu.
                      gbcFeatures) {
                    int palNumber =
                      (registers[104] &
                         56) >>
                      3;
                    dmgcpu.
                      graphicsChip.
                      gbcBackground[palNumber].
                      setGbcColours(
                        (JavaBoy.
                           unsign(
                             registers[104]) &
                           6) >>
                          1,
                        (JavaBoy.
                           unsign(
                             registers[104]) &
                           1) ==
                          1,
                        JavaBoy.
                          unsign(
                            data));
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        palNumber *
                          4);
                    if ((JavaBoy.
                           unsign(
                             registers[104]) &
                           128) !=
                          0) {
                        registers[104]++;
                    }
                }
                registers[105] =
                  (byte)
                    data;
                break;
            case 107:
                if (dmgcpu.
                      gbcFeatures) {
                    int palNumber =
                      (registers[106] &
                         56) >>
                      3;
                    dmgcpu.
                      graphicsChip.
                      gbcSprite[palNumber].
                      setGbcColours(
                        (JavaBoy.
                           unsign(
                             registers[106]) &
                           6) >>
                          1,
                        (JavaBoy.
                           unsign(
                             registers[106]) &
                           1) ==
                          1,
                        JavaBoy.
                          unsign(
                            data));
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        palNumber *
                          4 +
                          32);
                    if ((JavaBoy.
                           unsign(
                             registers[106]) &
                           128) !=
                          0) {
                        if ((registers[106] &
                               63) ==
                              63) {
                            registers[106] =
                              (byte)
                                128;
                        }
                        else {
                            registers[106]++;
                        }
                    }
                }
                registers[107] =
                  (byte)
                    data;
                break;
            case 112:
                if (dmgcpu.
                      gbcFeatures) {
                    if ((data &
                           7) ==
                          0 ||
                          (data &
                             7) ==
                          1) {
                        dmgcpu.
                          gbcRamBank =
                          1;
                    }
                    else {
                        dmgcpu.
                          gbcRamBank =
                          data &
                            7;
                    }
                }
                registers[112] =
                  (byte)
                    data;
                break;
            default:
                registers[num] =
                  (byte)
                    data;
                break;
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
      ("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" +
       "Ulv0cWIuAAA=");
}
