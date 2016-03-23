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
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HptqxeNQJMZf8W3JfwBRWI+0xSIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+zr1n2ffj/7+tqO7XvtJE7mxc7DN9kcdZeUKIlS7TSl" +
       "JFKiRJESKVIil9Wh+Jb4Et9i5qUN2iVYhiRonS4dWmMD0rUr3KQYmrbA1sHr" +
       "0BdaFGgQDNuKJW0xbFmyAPEfbYelXXdI/d73d++1m/gH8PyOzuN7Pt/n+R7y" +
       "vPytypUwqFR9z94Zthfd1LLo5tpu3ox2vhbeHFHNqRyEmtqz5TCcg7bnlff8" +
       "0rU//85nzOuHlfukyptl1/UiObI8N2S10LMTTaUq105bcVtzwqhynVrLiQzF" +
       "kWVDlBVGz1KVN52ZGlVuUMcQIAABAhCgEgKEnY4Ckx7W3NjpFTNkNwq3lX9U" +
       "OaAq9/lKAS+qvPs8EV8OZOeIzLTkAFC4v/gtAKbKyVlQedcJ73ueb2H4s1Xo" +
       "xX/2Q9f/zT2Va1LlmuVyBRwFgIjAIlLlIUdzVloQYqqqqVLlUVfTVE4LLNm2" +
       "8hK3VHkstAxXjuJAOxFS0Rj7WlCueSq5h5SCtyBWIi84YU+3NFs9/nVFt2UD" +
       "8Pr4Ka97DomiHTD4oAWABbqsaMdT7t1YrhpV3nlxxgmPN8ZgAJh61dEi0ztZ" +
       "6l5XBg2Vx/a6s2XXgLgosFwDDL3ixWCVqPLEbYkWsvZlZSMb2vNR5e0Xx033" +
       "XWDUA6UgiilR5a0Xh5WUgJaeuKClM/r5Fv3cpz7iDt3DErOqKXaB/34w6akL" +
       "k1hN1wLNVbT9xIfeT/2k/Pivf+KwUgGD33ph8H7Mr/7DV3/w+5565Xf2Y/72" +
       "JWOY1VpToueVz68e+cN39J7p3FPAuN/3QqtQ/jnOS/OfHvU8m/nA8x4/oVh0" +
       "3jzufIX9LfGHf0H75mHlQbJyn+LZsQPs6FHFc3zL1oKB5mqBHGkqWXlAc9Ve" +
       "2U9WroI6ZbnavpXR9VCLyMq9dtl0n1f+BiLSAYlCRFdB3XJ177juy5FZ1jO/" +
       "cvR3BTy1o3r5P6o0IdNzNMi3oGngFayHkOZGKyBWEyoMZeXtoDBQINIbyq4K" +
       "wN4sWv2/6cSsQHQ9PTgAwnrHRVe1gZUPPVvVgueVF+Mu/uoXnv+9wxPTPeIl" +
       "qjxwQrJycFBSektBei9yILANcD0QlB56hvsHow9/4j33AF376b2A22IodPvY" +
       "2Dt1VrIMSQqwmMorn0t/RPgofFg5PB/kCjig6cFi+rQITSch6MZF476M7rWP" +
       "f/3Pv/iTL3inZn4uah55360zC+95z0XBBZ6iqSAenZJ//7vkLz3/6y/cOKzc" +
       "C1wShKFIBmYDPPypi2uc86JnjyNSwcsVwLDuBY5sF13HYeTByAy89LSl1Ogj" +
       "Zf1RIOP7C7MqKh88srPyf9H7Zr8o37K3gEJpF7goI94HOP9n/vMf/C+kFPdx" +
       "cLx2ZrvhtOjZMw5ZELtWut6jpzYwDzQNjPtvn5v+xGe/9fG/XxoAGPH0ZQve" +
       "KMoecESgQiDmH/ud7X/52lc//5XDU6OJwI4Ur2xLyU6YPCh4unoHJsFq7zvF" +
       "AxzaBg5SWM0N3nU81dIteWVrhZX+5bX31r70vz91fW8HNmg5NqPvuzuB0/a/" +
       "1a388O/90F88VZI5UIoN5VRmp8P2UerNp5SxIJB3BY7sR7785E/9tvwzIN6B" +
       "GBNauVaGjYMjxylAvRVIou8Yih+XOoTKxveX5c2C/3JopexDiuKd4VlfOO9u" +
       "Z/KA55XPfOXbDwvf/vevluDPJxJnVT+R/Wf31lYU78oA+bdddPyhHJpgXOMV" +
       "+kPX7Ve+AyhKgKICds+QCUBgyc4ZytHoK1f/63/4j49/+A/vqRwSlQdtT1YJ" +
       "ufS5ygPA2LXQBDEp8z/4g3tdp4WJXy9ZrdzC/N5G3l7+egQAfOb24YYo8oBT" +
       "j337/2Xs1cf+9P/cIoQy0Fyy/V2YL0Ev//QTvR/4Zjn/1OOL2U9ltwZbkDOd" +
       "zq3/gvNnh++57zcPK1elynXlKCETZDsu/EgCSUh4nKWBpO1c//mEYr97PnsS" +
       "0d5xMdqcWfZirDkN8qBejC7qD14IL6Xn3QBP48jzGhfDy0GlrGDllHeX5Y2i" +
       "+DtHGtqT+mvwdwCe/1c8RXvRsN8RH+sdbcvvOtmX/WLXCTQD+AlIDYFa33t7" +
       "tZYetc82XvpXT//BR196+k9KK7zfCgHzWGBckv6cmfPtl7/2zS8//OQXysB9" +
       "70oO92K4mDfemhaey/ZKqT10IrXHCs4eB89Xj6T21T2rH3yNezi3jeVAW8iJ" +
       "diQS7yQN+G5JZHd2kmlgOSDQJ0c5HvTCY1/b/PTXf3Gfv130iAuDtU+8+E/+" +
       "+uanXjw8kzU/fUvienbOPnMuhfdwUeAFunffaZVyBvE/v/jCv/35Fz6+R/XY" +
       "+RwQB0ecX/xPf/X7Nz/3x797STJz72oXaSdh5Gy4fa4oxsf2vLjcng+L6t+N" +
       "gCdZrmyXyHEQpm3NNSKzHEwfMVL8Y6PKPcBwiurIz05WPdyTOg7y++2h8GeQ" +
       "l3uuVuw0x337TMvybp6ciUBndgv+oPL+2+t0UhrqafT57Y9944n5D5gffh0p" +
       "1jsv6OQiyX89efl3B+9Tfvywcs9JLLrlwHR+0rPnI9CDgQZOeO78XBx6cq+S" +
       "Un57fRTFe0sJ32E33NyhzykKEyhQKUS918wdhvtZZZ8/FWWjKLp76aO33Z6e" +
       "Ox88r4EHPQoD6G2CZ3i74HlsX2qZBhS/4AtwotcJhwLP9x/B+f7bwMnvAueq" +
       "L6uUpkeX2fvVlefZmuxegPmRNwDmj94FJjg/q6xlmKX/ffQCoB97AwB98i6A" +
       "rgBAvH8Zmn/6BqD58degxb6Xupfh+Yk3AM9P3QUPOECr2GVg/vkbAOZfvAYw" +
       "3cvA/Ms3AMzPvQZD5iI5uNSQf/4NAPSFuwB6oACkFWecyxB98XUieit4njtC" +
       "9NxtEH3pLojeZKqOzMaua7nGZZh+5a6Y9mHsABw/r9RvojfLOPvvLl/1nqIK" +
       "koD7wvJdZvFLOgbytrWt3DjOaAWQvYKN9cbaRo839Ounm/3+beAFoPhrBgo2" +
       "/UdOiVGeazz7yf/+md//9NNfA2nPqHIlKY4LYO8+syIdF+9a//HLn33yTS/+" +
       "8SfLMzfQAdf/xm+WQv6tO7FbFK+cY/WJglXOiwNFo+QwmpTHZE094fbCznAv" +
       "2HD/5txG174ybIQkdvxHCZLWxPiMdRNkGerDqTLjR0NXkbBehxUnMuOaWFPq" +
       "z01djDc0x4isrW6lRK1365K/9hM1RI12Z0z22jXLq27saWqyATujujTF1wb9" +
       "UBuv6Z4oiznHiyYZkHNiMOYjustOc12t50yjqi6XYx8hBBqpZ4jegZZIi4aQ" +
       "jtLpdtquupIIyWZUdUWzm06gJnOf4nyJtleGU9elQQtPRmqHJYd1uBMlaHs8" +
       "3ugjgtltghpjO7sWu13IolHlFrIfT2BnuV3VNd7g/Y0p17ZzPpyoy1m3vYFr" +
       "Gko5krfd1neqJ/SUEHd2+JZVxTDjYMQeVLN0sJ5k4xT3Lb23yGxlaLoGJ1Hd" +
       "xNn2kw49geB4oOBSVVIWc3G9Et0IDjB+l9OCtRN4B+J5ajh25IW1Hig1A1nN" +
       "sThQg10Gz5cjSVw6ci/31NU0tzMFlWmnivGcqtBZtMirLTuSJzTPSd1FhKpL" +
       "L7fREerItd6cHE06GzbwOFbGM7zr9T1eiBDBSaumvG0idGa0kr7l59s5u1lm" +
       "E6M9zeh5uOWUdLca1dJUGfjOmtkpg5WmLaIuOBlv7Ua96WTJUg1Xy3hjBjNm" +
       "Y0vCsN23dxRGdjfkIJUx2G7Ji0QYsdv+iKy7QtoxejUBt+dZlk3VjrllfVUc" +
       "RplOY1G9ualtFckB9t2beqNYsJu2aauzVcMY2tDYW8Hb2aTVD9SaIHgxtkJn" +
       "CuEQrOT0+c1MTZsjdNYUhMyS8NbMa6lmjeFTDPZERRKc9WjsL+xWr6+Sxgzm" +
       "Zh08izGYnuQTaskYWA8ejGx2w7ly3Z9vhsJ44K8xC4MYTjRMh14SfRLbrOEG" +
       "NWd6egp7O8zO86q2hDqWGSdwpG95dtyluYivuf3OptH1VK/nuWmTtdpkFSe5" +
       "ObFTY7slQjGnjnv4TiN8I2yu87qtMUu3v0TbU9rKzY2p5PImqjGSr807Lc5J" +
       "cjJNmKA9sDuENwjkcZ6ofu6qEmy6/liysAlNU8PhII1zsxFPIYmqQSg2hBPO" +
       "D1COqoXydKNkxABdMexEkKcLX+BcO+Q8eKPJ2zGKV5eGLot9xBz7c3gVmfLE" +
       "cgIS4uVgFyBxD0p5tp9iI7qG5cl23dwQdIe2Fsum1sY3ud1Wp3isqlBL32iL" +
       "LBgB0xcYesTBfWGlrrG+5E8GYd30Bhy9kdaRtRxWvV1ts0UxMYizGpTpvVnc" +
       "8Gx6QJp4WgtzQ4h4YxcpsrMZRzaVIkkrQKo44xMwL4qM0YrXfU4YjEakOWRk" +
       "brsjLHFoVOtYMNNFGnHZdLSiohjxA4zQnR1T83o1BtXntkFZ6LQRG45PTtUV" +
       "N8mXEdqa0yzvh8ZQoiZtfzzYUCi3M7rirh8r0HzW7Ktut6s5zaHfH6ADUprY" +
       "PEbutt1IYWyYtRwiEfNJtOx7ktlTqCk+NuhGaxqMGvNoGEQRnEukZ+l+NuCX" +
       "C0yeGRpLsRHJyUtl2BlMZETVtWyeomoSRqnaEqctMmluxZRTNWNSXfue63Nt" +
       "bYzCMhOMlgKioHgdc/Fdj8PUmWPW+YaaNKY8P2MFWJ5puJm2/dHAaADR55PQ" +
       "F7NGskrJQe6itYlJdf1shM77CjrIad2EhqNaLLrxtkdsJ2EDWwzHs2TY7yd6" +
       "PLUTZMc6aEw2W3WN7WfYQmwPZ82u1IU1Sl2rIV3b8mmwQ9BNrmkgmMa5njsk" +
       "L7XbE1x18FW3mmJEYywlUNDO19o0CRAoko1VM91xcr9BR7xl+oMZri62nmex" +
       "5KJqxd28Sxp5neZVumbO0Gw7a/m8vV3HFF6Va/W0Qw8gRDWcxqbXdx1SdJfC" +
       "ruugUEtOyIjrxNByVpcyYOQzrUW7jNtbYJ1MW7ThYLzhhWzYWPlLCUEQRrNj" +
       "Y2BhrBCqXpb7ZNjUMnihdn1JdJWElHwUVfpuspxQK0k2IBcOGvWpK1JUr6O1" +
       "AYb5zubgbbW64qeLXOpUaTZLXBNCNboGzYMR2h2yZoj0sACDaNEU5B2P9iBm" +
       "MRSakCRF9SrGpkOMYyYW29YaE2JBrNOu6OVxCzVVuA1NEGQ1zvlN7Imw3JA3" +
       "wWjYcC2axpmcz43xhAh3FJUNqsMQn62qzHazpuxdHswQd9qbqs5qkjkIpK7X" +
       "PtT0siWCIrHUlVJPk5B+ixPX4dTv28SKQ/MManSWDhRrbTRqVMkhtfMmgUG0" +
       "cBRtpmKk67AO2YSjGM2A1IWuMWykatKLB/qAQuIpTAUNQxU0c9oNu2wQw818" +
       "N6vma3mhQznwJHE0qAPOiXgTzMACfndLU6FobihBriUI0cksfWz5DU6fNKZi" +
       "08RXbF9Eem0SzcMVYhs9sb1EtK7S3knNdtJrjCRz2lvucndEIBY6GMV5ohMz" +
       "0Vz4qeFzIc/nOFabUVA8FZpWtZuMfAca0mNnm4x3Sqdam6Luut0hk1wbzMkm" +
       "T2NqPO6wU3+EduxaVxl6pCEZCMr3w3ozqsYQbPfDHu2MeITwkPVu5cySOeIh" +
       "VWkItd2034/kvldNJqRPEfac5TyZifL+Dt+RMDW22kSe1ZGp1q9yHT2sQ1U0" +
       "t2f02KuzWO4R9ojX6kZ1OlzDiQCyljWCK/UwckIjW0NtmHdRsT2CzZgR5HDl" +
       "WCKpoZOB4zOKuUsbDSqH7XgDqfBotaE2iybmTGt5lUywdr3ThulcJJVcw5fa" +
       "uBE49tZcZz7nz7rkfKC6vIIsh8twphIIxrLkvCehkYuulSq66qTBxt80FiGc" +
       "MJ1aQ1bmGbeZsbQN4pLObDkN52Wo2ZZpddqPc5kSVkJj3vY6E7JZnQyXECRw" +
       "nSaSJN0u11Zlh802UWPJbYRJxnSWESZT81arVZuCNIMNU6mN8IrcRretCQyh" +
       "RL/Tpul1Mxpoc5AX1YkaqSAqlq/x2YKAh1qc9tsIl/TSGS5QbMZ7yVrOZ31G" +
       "IBCOmYbRZgSSBkcV7U2HYaQVrtewcQ3HjEYcG2zd58Ne4KgCzpLjda+lDmdj" +
       "VlxmcyIb2j0ajajRcLaiavUqu1g18UhEh7GXtFZwvdkU2xDIqsNB2Oli08hx" +
       "W3M+63RyEjMWQor6DWKsxVArmeSSZtNwfe371bmFbYxdniwRPTX5cLkLVLyq" +
       "LTAOV2079aue2YQIsDPaDB8hbBtpwwKmMNWRPOk7c7BLjePlUhWWg1XYd2TD" +
       "0AcsHDW21LgzrgpCPhfxudLJxPYcS8y5qvjoqgdhIwu3msp4XBOYZAov6qnL" +
       "aJs8Z7bNbpRUHVl0a01jW8P7ywhvqHwArT0knGTJeslIvaURKxir8oOBFNVY" +
       "VbKELWv6E453Z+RyMIw6Tm6nUzS2iGjQ3QqdKTTuoypjkBQa0i7V7jWplqDk" +
       "C7GxU4GCdKTd69LQujdu9FNBE0WBQuaNPo81mnxn0tmK8Gy6QRKoOzE78IhY" +
       "9ZDR0jTsjoyN8WlMsrHlT1pY250x5tr1ej1/0CO60XyN7/qNHq+meLp1NJyk" +
       "NlC+YXrC1KhrBInYRFexp0K6GHERN5lPvC0jb6CgGm9dw1612tVtQPGzUTCF" +
       "m2gy70zW8BAPR4Lj5GMbRtupHwH7RTu7zQq1azJFyCbuZJbpOnXW0/ymQwhZ" +
       "BxpCPYXUGbtmR/iKHu2CLW4NmitlZ/NW4FPucuvtOmvgP9gCSfGMp2ZVShZ5" +
       "WljSCdQCHsEnyADrJ5bkmyoRjufqiKXWUTu2eaMfG3qs04FSt7vtRtzjkG3N" +
       "CgdTccjwTF6fwdp6o2ZiA1liTGdSwweOQUzbIqUNqWp37BMLWF+sx85EFyFw" +
       "NBpH6TDsUTVqkUozZlEdYD2qjxMZ1LdHG0112lJi8duNwFPEVuBShLW1TdwV" +
       "TWJWX4xnCwbuYJ4sypDAcnNbxGqqLaV1ygztdK7nEpuuRNK1GMYVWxOkzQkc" +
       "Nq1bksjoLMFTAjWl5ouaZS5csTMZq6K/1Sc2N9AXw+V4HkH1wdRIdBC3nIFI" +
       "LhpuL8KhgbNujgQfpCPEqDOddDIkqo71oLHGQypvan6V7Vd3zZXeWWZKtS0M" +
       "0+Zmznqr2a41bwyNOHGI1Hct3qlp7KJJLCHVJ0YtsY1QnOFQiZyJI9VuoibI" +
       "ZDJl7IwiNM2xQN+qtu4rCUJDXKxVw4VWtbX1iBpLbG/WWNXbcdIWQ2dok1s/" +
       "nDdVZaYwuV2D4I6FNhAtIqRZ1lYarE6wo11Lqsma2ySHK6S+Rqu46tbQXtJc" +
       "LmbC1ukuW1Ds+jza0nchs0DhptXLauIIl9BVOid0rrVZTvNJBtt21a1Nq4rc" +
       "lCaw7EVKQLbS7U4WiXUUhetpF29AmkRP4L7RWVtxmosBjvWiHDbpcTBkaDJZ" +
       "LvloMvSjbabRs9FE0tsLZKSnXXZBVuGMK47yH/hAcbz/8ut77fBo+Ybl5PLV" +
       "2kaLjt94HW8Wsjt/q6yc+Tt3e+fMe6kzn50rxUerJ293war8YPX5j734ksr8" +
       "bO3w6IUVF1UeiDz/79laotlnSF0p69r5yx1vAQ9+BAO/+HrslOtb2Dko5beX" +
       "2h2+cPyPO/R9vSj+JKpcCbRQu/R1/72JZ6mnUv/Tu73PObvCZcy+DzzTI2an" +
       "3xtmD04H/EY54M/uwPFfFMW3S/UYhq2NtV3R8I1TDl/9bjl8AjzHF8T877k6" +
       "Dw7u0Fd61F9GlTf5WlBcNBqqjnyBvb/6Lth75NhaP33E3qe/5wr8UMnHw3fg" +
       "8VpR3B9V7rM8VpPVy2z2Smh6QXTC88ED361KnwHPHx3x/EffG54PT782f6jA" +
       "+GjJ3DvuwPhTRfG2qHLV8haBFWnnFXvw9tfDZHb20p/vX/Luen/xJDs4HwdP" +
       "zOixu612JnQ+fe7LdXnr+Pgrc7y/d/y88sWXRvRHXm397P6ammLLeV5QuZ+q" +
       "XN3fmCuJFl+q331base07hs+851HfumB9x4H40f2gE/1dAbbOy+/E4Y7flTe" +
       "4sp/7W2//NzPvfTV8lX6/weSf0OYDi4AAA==");
}
