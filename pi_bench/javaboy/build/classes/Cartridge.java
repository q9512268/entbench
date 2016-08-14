class Cartridge implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { if (rom.length >= 1048576) { return EntMode.
                                                                       HIGH_MODE;
                                 }
                                 else
                                     if (rom.
                                           length >=
                                           524288) {
                                         return EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return EntMode.
                                                  LOW_MODE;
                                     } }
    final int[][] romSizeTable = { { 0, 2 }, { 1, 4 }, { 2, 8 }, { 3,
    16 },
    { 4,
    32 },
    { 5,
    64 },
    { 6,
    128 },
    { 7,
    256 },
    { 82,
    72 },
    { 83,
    80 },
    { 84,
    96 } };
    final java.lang.String[] cartTypeTable = { "ROM Only", "ROM+MBC1",
    "ROM+MBC1+RAM",
    "ROM+MBC1+RAM+BATTERY",
    "Unknown",
    "ROM+MBC2",
    "ROM+MBC2+BATTERY",
    "Unknown",
    "ROM+RAM",
    "ROM+RAM+BATTERY",
    "Unknown",
    "Unsupported ROM+MMM01",
    "Unsupported ROM+MMM01+SRAM",
    "Unsupported ROM+MMM01+SRAM+BATTERY",
    "Unknown",
    "ROM+MBC3+TIMER+BATTERY",
    "ROM+MBC3+TIMER+RAM+BATTERY",
    "ROM+MBC3",
    "ROM+MBC3+RAM",
    "ROM+MBC3+RAM+BATTERY",
    "Unknown",
    "Unknown",
    "Unknown",
    "Unknown",
    "Unknown",
    "ROM+MBC5",
    "ROM+MBC5+RAM",
    "ROM+MBC5+RAM+BATTERY",
    "ROM+MBC5+RUMBLE",
    "ROM+MBC5+RUMBLE+RAM",
    "ROM+MBC5+RUMBLE+RAM+BATTERY" };
    final byte bNotCompressed = 0;
    final byte bZip = 1;
    final byte bJar = 2;
    final byte bGZip = 3;
    final byte SECONDS = 0;
    final byte MINUTES = 1;
    final byte HOURS = 2;
    final byte DAYS_LO = 3;
    final byte DAYS_HI = 4;
    public byte[] rom;
    public byte[] ram = new byte[65536];
    int numBanks;
    int cartType;
    int pageStart = 16384;
    int currentBank = 1;
    int savedBank = -1;
    int ramBank;
    int ramPageStart;
    boolean mbc1LargeRamMode = false;
    boolean ramEnabled;
    boolean disposed = false;
    java.awt.Component applet;
    java.lang.String romFileName;
    java.lang.String cartName;
    boolean cartridgeReady = false;
    boolean needsReset = false;
    int[] RTCReg = new int[5];
    long realTimeStart;
    long lastSecondIncrement;
    java.lang.String romIntFileName;
    public Cartridge(java.lang.String romFileName, java.awt.Component a) {
        super(
          );
        applet =
          a;
        this.
          romFileName =
          romFileName;
        java.io.InputStream is =
          null;
        try {
            is =
              openRom(
                romFileName,
                a);
            byte[] firstBank =
              new byte[16384];
            int total =
              16384;
            do  {
                total -=
                  is.
                    read(
                      firstBank,
                      16384 -
                        total,
                      total);
            }while(total >
                     0); 
            cartType =
              firstBank[327];
            numBanks =
              lookUpCartSize(
                firstBank[328]);
            rom =
              (new byte[16384 *
                          numBanks]);
            for (int r =
                   0;
                 r <
                   16384;
                 r++) {
                rom[r] =
                  firstBank[r];
            }
            total =
              16384 *
                (numBanks -
                   1);
            do  {
                total -=
                  is.
                    read(
                      rom,
                      rom.
                        length -
                        total,
                      total);
            }while(total >
                     0); 
            is.
              close(
                );
            JavaBoy.
              debugLog(
                "Loaded ROM \'" +
                romFileName +
                "\'.  " +
                numBanks +
                " banks, " +
                numBanks *
                  16 +
                "Kb.  " +
                getNumRAMBanks(
                  ) +
                " RAM banks.");
            JavaBoy.
              debugLog(
                "Type: " +
                cartTypeTable[cartType] +
                " (" +
                JavaBoy.
                  hexByte(
                    cartType) +
                ")");
            if (!verifyChecksum(
                   ) &&
                  a instanceof java.awt.Frame) {
                new ModalDialog(
                  (java.awt.Frame)
                    a,
                  "Warning",
                  "This cartridge has an invalid checksum.",
                  "It may not execute correctly.");
            }
            if (!JavaBoy.
                   runningAsApplet) {
                loadBatteryRam(
                  );
            }
            java.util.Calendar rightNow =
              java.util.Calendar.
              getInstance(
                );
            int days =
              rightNow.
              get(
                java.util.Calendar.
                  DAY_OF_YEAR);
            int hour =
              rightNow.
              get(
                java.util.Calendar.
                  HOUR_OF_DAY);
            int minute =
              rightNow.
              get(
                java.util.Calendar.
                  MINUTE);
            int second =
              rightNow.
              get(
                java.util.Calendar.
                  SECOND);
            RTCReg[SECONDS] =
              second;
            RTCReg[MINUTES] =
              minute;
            RTCReg[HOURS] =
              hour;
            RTCReg[DAYS_LO] =
              days &
                255;
            RTCReg[DAYS_HI] =
              (days &
                 511) >>
                8;
            realTimeStart =
              java.lang.System.
                currentTimeMillis(
                  );
            lastSecondIncrement =
              realTimeStart;
            cartridgeReady =
              true;
        }
        catch (java.io.IOException e) {
            java.lang.System.
              out.
              println(
                "Error opening ROM image \'" +
                romFileName +
                "\'!");
        }
        catch (java.lang.IndexOutOfBoundsException e) {
            new ModalDialog(
              (java.awt.Frame)
                a,
              "Error",
              "Loading the ROM image failed.",
              "The file is not a valid Gameboy ROM.");
        }
    }
    public boolean needsResetEnable() { if (needsReset) { needsReset =
                                                            false;
                                                          java.lang.System.
                                                            out.println(
                                                                  "Reset requested");
                                                          return true;
                                        }
                                        else {
                                            return false;
                                        } }
    public void resetSystem() { needsReset = true; }
    public void update() { long millisSinceLastUpdate = java.lang.System.
                             currentTimeMillis(
                               ) -
                             lastSecondIncrement;
                           while (millisSinceLastUpdate > 1000) {
                               millisSinceLastUpdate -=
                                 1000;
                               RTCReg[SECONDS]++;
                               if (RTCReg[SECONDS] ==
                                     60) {
                                   RTCReg[MINUTES]++;
                                   RTCReg[SECONDS] =
                                     0;
                                   if (RTCReg[MINUTES] ==
                                         60) {
                                       RTCReg[HOURS]++;
                                       RTCReg[MINUTES] =
                                         0;
                                       if (RTCReg[HOURS] ==
                                             24) {
                                           if (RTCReg[DAYS_LO] ==
                                                 255) {
                                               RTCReg[DAYS_LO] =
                                                 0;
                                               RTCReg[DAYS_HI] =
                                                 1;
                                           }
                                           else {
                                               RTCReg[DAYS_LO]++;
                                           }
                                           RTCReg[HOURS] =
                                             0;
                                       }
                                   }
                               }
                               lastSecondIncrement =
                                 java.lang.System.
                                   currentTimeMillis(
                                     );
                           } }
    java.lang.String stripExtention(java.lang.String filename) { int dotPosition =
                                                                   filename.
                                                                   lastIndexOf(
                                                                     '.');
                                                                 if (dotPosition !=
                                                                       -1) {
                                                                     return filename.
                                                                       substring(
                                                                         0,
                                                                         dotPosition);
                                                                 }
                                                                 else {
                                                                     return filename;
                                                                 }
    }
    public java.io.InputStream openRom(java.lang.String romFileName,
                                       java.awt.Component a) {
        byte bFormat;
        boolean bFoundGBROM =
          false;
        java.lang.String romName =
          "None";
        if (romFileName.
              toUpperCase(
                ).
              indexOf(
                "ZIP") >
              -1) {
            bFormat =
              bZip;
        }
        else
            if (romFileName.
                  toUpperCase(
                    ).
                  indexOf(
                    "JAR") >
                  -1) {
                bFormat =
                  bZip;
            }
            else
                if (romFileName.
                      toUpperCase(
                        ).
                      indexOf(
                        "GZ") >
                      -1) {
                    bFormat =
                      bGZip;
                }
                else {
                    bFormat =
                      bNotCompressed;
                }
        if (bFormat ==
              bNotCompressed) {
            try {
                romIntFileName =
                  stripExtention(
                    romFileName);
                if (JavaBoy.
                      runningAsApplet) {
                    return new java.net.URL(
                      ((java.applet.Applet)
                         a).
                        getDocumentBase(
                          ),
                      romFileName).
                      openStream(
                        );
                }
                else {
                    return new java.io.FileInputStream(
                      new java.io.File(
                        romFileName));
                }
            }
            catch (java.lang.Exception e) {
                java.lang.System.
                  out.
                  println(
                    "Cant open file");
                return null;
            }
        }
        if (bFormat ==
              bZip) {
            java.lang.System.
              out.
              println(
                "Loading ZIP Compressed ROM");
            java.util.zip.ZipInputStream zip;
            try {
                if (JavaBoy.
                      runningAsApplet) {
                    zip =
                      new java.util.zip.ZipInputStream(
                        new java.net.URL(
                          ((java.applet.Applet)
                             a).
                            getDocumentBase(
                              ),
                          romFileName).
                          openStream(
                            ));
                }
                else {
                    zip =
                      new java.util.zip.ZipInputStream(
                        new java.io.FileInputStream(
                          romFileName));
                }
                java.util.zip.ZipEntry ze;
                while ((ze =
                          zip.
                            getNextEntry(
                              )) !=
                         null) {
                    java.lang.String str =
                      ze.
                      getName(
                        );
                    if (str.
                          toUpperCase(
                            ).
                          indexOf(
                            ".GB") >
                          -1 ||
                          str.
                          toUpperCase(
                            ).
                          indexOf(
                            ".GBC") >
                          -1) {
                        bFoundGBROM =
                          true;
                        romIntFileName =
                          stripExtention(
                            str);
                        romName =
                          str;
                        break;
                    }
                }
                if (!bFoundGBROM) {
                    if (JavaBoy.
                          runningAsApplet) {
                        new ModalDialog(
                          (java.awt.Frame)
                            a,
                          "Error",
                          "No GBx ROM found!",
                          "");
                    }
                    java.lang.System.
                      err.
                      println(
                        "No GBx ROM found!");
                    throw new java.io.IOException(
                      "ERROR");
                }
                if (!JavaBoy.
                       runningAsApplet) {
                    java.lang.System.
                      out.
                      println(
                        "Found " +
                        romName);
                }
                return zip;
            }
            catch (java.lang.Exception e) {
                java.lang.System.
                  out.
                  println(
                    e);
                return null;
            }
        }
        if (bFormat ==
              bGZip) {
            java.lang.System.
              out.
              println(
                "Loading GZIP Compressed ROM");
            romIntFileName =
              stripExtention(
                romFileName);
            try {
                if (JavaBoy.
                      runningAsApplet) {
                    return new java.util.zip.GZIPInputStream(
                      new java.net.URL(
                        ((java.applet.Applet)
                           a).
                          getDocumentBase(
                            ),
                        romFileName).
                        openStream(
                          ));
                }
                else {
                    return new java.util.zip.GZIPInputStream(
                      new java.io.FileInputStream(
                        romFileName));
                }
            }
            catch (java.lang.Exception e) {
                java.lang.System.
                  out.
                  println(
                    "Can\'t open file");
                return null;
            }
        }
        return null;
    }
    public final byte addressRead(int addr) {
        if (addr >=
              40960 &&
              addr <=
              49151) {
            switch (cartType) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    {
                        if (ramBank >=
                              4) {
                            return (byte)
                                     RTCReg[ramBank -
                                              8];
                        }
                        else {
                            return ram[addr -
                                         40960 +
                                         ramPageStart];
                        }
                    }
                default:
                    {
                        return ram[addr -
                                     40960 +
                                     ramPageStart];
                    }
            }
        }
        if (addr <
              16384) {
            return (byte)
                     rom[addr];
        }
        else {
            return (byte)
                     rom[pageStart +
                           addr -
                           16384];
        }
    }
    public java.lang.String getMapInfo() {
        java.lang.String out;
        switch (cartType) {
            case 0:
            case 8:
            case 9:
                return "This ROM has no mapper.";
            case 1:
                return "MBC1: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to " +
                " 4000 - 7FFFF";
            case 2:
            case 3:
                out =
                  "MBC1: ROM bank " +
                  JavaBoy.
                    hexByte(
                      currentBank) +
                  " mapped to " +
                  " 4000 - 7FFFF.  ";
                if (mbc1LargeRamMode) {
                    out =
                      out +
                      "Cartridge is in 16MBit ROM/8KByte RAM Mode.";
                }
                else {
                    out =
                      out +
                      "Cartridge is in 4MBit ROM/32KByte RAM Mode.";
                }
                return out;
            case 5:
            case 6:
                return "MBC2: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to 4000 - 7FFF";
            case 25:
            case 28:
                return "MBC5: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to 4000 - 7FFF";
            case 26:
            case 27:
            case 29:
            case 30:
                return "MBC5: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to 4000 - 7FFF";
        }
        return "Unknown mapper.";
    }
    public void mapRom(int bankNo) { currentBank =
                                       bankNo;
                                     pageStart =
                                       16384 *
                                         bankNo;
    }
    public void reset() { mapRom(1); }
    public void saveMapping() { if (cartType !=
                                      0 &&
                                      savedBank ==
                                      -1)
                                    savedBank =
                                      currentBank;
    }
    public void restoreMapping() { if (savedBank !=
                                         -1) {
                                       java.lang.System.
                                         out.
                                         println(
                                           "- ROM Mapping restored to bank " +
                                           JavaBoy.
                                             hexByte(
                                               savedBank));
                                       addressWrite(
                                         8192,
                                         savedBank);
                                       savedBank =
                                         -1;
                                   } }
    public void debuggerAddressWrite(int addr,
                                     int data) {
        if (cartType ==
              0) {
            rom[addr] =
              (byte)
                data;
        }
        else {
            if (addr <
                  16384) {
                rom[addr] =
                  (byte)
                    data;
            }
            else {
                rom[pageStart +
                      addr -
                      16384] =
                  (byte)
                    data;
            }
        }
    }
    public final void addressWrite(int addr,
                                   int data) {
        int ramAddress =
          0;
        switch (cartType) {
            case 0:
                break;
            case 1:
            case 2:
            case 3:
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    if (ramEnabled) {
                        ramAddress =
                          addr -
                            40960 +
                            ramPageStart;
                        ram[ramAddress] =
                          (byte)
                            data;
                    }
                }
                if (addr >=
                      8192 &&
                      addr <=
                      16383) {
                    int bankNo =
                      data &
                      31;
                    if (bankNo ==
                          0)
                        bankNo =
                          1;
                    mapRom(
                      currentBank &
                        96 |
                        bankNo);
                }
                else
                    if (addr >=
                          24576 &&
                          addr <=
                          32767) {
                        if ((data &
                               1) ==
                              1) {
                            mbc1LargeRamMode =
                              true;
                        }
                        else {
                            mbc1LargeRamMode =
                              false;
                        }
                    }
                    else
                        if (addr <=
                              8191) {
                            if ((data &
                                   15) ==
                                  10) {
                                ramEnabled =
                                  true;
                            }
                            else {
                                ramEnabled =
                                  false;
                            }
                        }
                        else
                            if (addr <=
                                  24575 &&
                                  addr >=
                                  16384) {
                                if (mbc1LargeRamMode) {
                                    ramBank =
                                      data &
                                        3;
                                    ramPageStart =
                                      ramBank *
                                        8192;
                                }
                                else {
                                    mapRom(
                                      currentBank &
                                        31 |
                                        (data &
                                           3) <<
                                        5);
                                }
                            }
                break;
            case 5:
            case 6:
                if (addr >=
                      8192 &&
                      addr <=
                      16383 &&
                      (addr &
                         256) !=
                      0) {
                    int bankNo =
                      data &
                      31;
                    if (bankNo ==
                          0)
                        bankNo =
                          1;
                    mapRom(
                      bankNo);
                }
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    if (ramEnabled)
                        ram[addr -
                              40960 +
                              ramPageStart] =
                          (byte)
                            data;
                }
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                if (addr >=
                      8192 &&
                      addr <=
                      16383) {
                    int bankNo =
                      data &
                      127;
                    if (bankNo ==
                          0)
                        bankNo =
                          1;
                    mapRom(
                      bankNo);
                }
                else
                    if (addr <=
                          24575 &&
                          addr >=
                          16384) {
                        ramBank =
                          data;
                        if (ramBank <
                              4) {
                            ramPageStart =
                              ramBank *
                                8192;
                        }
                    }
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    if (ramBank <=
                          3) {
                        ram[addr -
                              40960 +
                              ramPageStart] =
                          (byte)
                            data;
                    }
                    else {
                        RTCReg[ramBank -
                                 8] =
                          data;
                    }
                }
                break;
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                if (addr >=
                      8192 &&
                      addr <=
                      12287) {
                    int bankNo =
                      currentBank &
                      65280 |
                      data;
                    mapRom(
                      bankNo);
                }
                if (addr >=
                      12288 &&
                      addr <=
                      16383) {
                    int bankNo =
                      currentBank &
                      255 |
                      (data &
                         1) <<
                      8;
                    mapRom(
                      bankNo);
                }
                if (addr >=
                      16384 &&
                      addr <=
                      24575) {
                    ramBank =
                      data &
                        7;
                    ramPageStart =
                      ramBank *
                        8192;
                }
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    ram[addr -
                          40960 +
                          ramPageStart] =
                      (byte)
                        data;
                }
                break;
        }
    }
    public int getNumRAMBanks() { switch (rom[329]) {
                                      case 0:
                                          {
                                              return 0;
                                          }
                                      case 1:
                                      case 2:
                                          {
                                              return 1;
                                          }
                                      case 3:
                                          {
                                              return 4;
                                          }
                                      case 4:
                                          {
                                              return 16;
                                          }
                                  }
                                  return 0;
    }
    public void loadBatteryRam() { java.lang.String saveRamFileName =
                                     romFileName;
                                   int numRamBanks;
                                   try { int dotPosition =
                                           romFileName.
                                           lastIndexOf(
                                             '.');
                                         if (dotPosition !=
                                               -1) {
                                             saveRamFileName =
                                               romFileName.
                                                 substring(
                                                   0,
                                                   dotPosition) +
                                               ".sav";
                                         }
                                         else {
                                             saveRamFileName =
                                               romFileName +
                                               ".sav";
                                         }
                                         numRamBanks =
                                           getNumRAMBanks(
                                             );
                                         if (cartType ==
                                               3 ||
                                               cartType ==
                                               9 ||
                                               cartType ==
                                               27 ||
                                               cartType ==
                                               30 ||
                                               cartType ==
                                               16 ||
                                               cartType ==
                                               19) {
                                             java.io.FileInputStream is =
                                               new java.io.FileInputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             is.
                                               read(
                                                 ram,
                                                 0,
                                                 numRamBanks *
                                                   8192);
                                             is.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Read SRAM from \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                         if (cartType ==
                                               6) {
                                             java.io.FileInputStream is =
                                               new java.io.FileInputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             is.
                                               read(
                                                 ram,
                                                 0,
                                                 512);
                                             is.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Read SRAM from \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                   }
                                   catch (java.io.IOException e) {
                                       java.lang.System.
                                         out.
                                         println(
                                           "Error loading battery RAM from \'" +
                                           saveRamFileName +
                                           "\'");
                                   } }
    public int getBatteryRamSize() { int numRamBanks;
                                     if (rom[329] ==
                                           6) {
                                         return 512;
                                     }
                                     else {
                                         return getNumRAMBanks(
                                                  ) *
                                           8192;
                                     } }
    public byte[] getBatteryRam() { return ram;
    }
    public boolean canSave() { return cartType ==
                                 3 ||
                                 cartType ==
                                 9 ||
                                 cartType ==
                                 27 ||
                                 cartType ==
                                 30 ||
                                 cartType ==
                                 6 ||
                                 cartType ==
                                 16 ||
                                 cartType ==
                                 19; }
    public void saveBatteryRam() { java.lang.String saveRamFileName =
                                     romFileName;
                                   int numRamBanks;
                                   numRamBanks =
                                     getNumRAMBanks(
                                       );
                                   try { int dotPosition =
                                           romFileName.
                                           lastIndexOf(
                                             '.');
                                         if (dotPosition !=
                                               -1) {
                                             saveRamFileName =
                                               romFileName.
                                                 substring(
                                                   0,
                                                   dotPosition) +
                                               ".sav";
                                         }
                                         else {
                                             saveRamFileName =
                                               romFileName +
                                               ".sav";
                                         }
                                         if (cartType ==
                                               3 ||
                                               cartType ==
                                               9 ||
                                               cartType ==
                                               27 ||
                                               cartType ==
                                               30 ||
                                               cartType ==
                                               16 ||
                                               cartType ==
                                               19) {
                                             java.io.FileOutputStream os =
                                               new java.io.FileOutputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             os.
                                               write(
                                                 ram,
                                                 0,
                                                 numRamBanks *
                                                   8192);
                                             os.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Written SRAM to \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                         if (cartType ==
                                               6) {
                                             java.io.FileOutputStream os =
                                               new java.io.FileOutputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             os.
                                               write(
                                                 ram,
                                                 0,
                                                 512);
                                             os.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Written SRAM to \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                   }
                                   catch (java.io.IOException e) {
                                       java.lang.System.
                                         out.
                                         println(
                                           "Error saving battery RAM to \'" +
                                           saveRamFileName +
                                           "\'");
                                   } }
    public void saveBatteryRAMToWeb(java.net.URL url,
                                    java.lang.String username,
                                    Dmgcpu cpu) {
        new WebSaveRAM(
          url,
          true,
          this,
          cpu,
          username);
    }
    public void loadBatteryRAMFromWeb(java.net.URL url,
                                      java.lang.String username,
                                      Dmgcpu cpu) {
        new WebSaveRAM(
          url,
          false,
          this,
          cpu,
          username);
    }
    public void dispose() { if (!JavaBoy.
                                   runningAsApplet) {
                                saveBatteryRam(
                                  );
                            }
                            disposed = true;
    }
    public boolean verifyChecksum() { int checkSum =
                                        (JavaBoy.
                                           unsign(
                                             rom[334]) <<
                                           8) +
                                        JavaBoy.
                                        unsign(
                                          rom[335]);
                                      int total =
                                        0;
                                      for (int r =
                                             0;
                                           r <
                                             rom.
                                               length;
                                           r++) {
                                          if (r !=
                                                334 &&
                                                r !=
                                                335) {
                                              total =
                                                total +
                                                  JavaBoy.
                                                  unsign(
                                                    rom[r]) &
                                                  65535;
                                          }
                                      }
                                      return checkSum ==
                                        total;
    }
    java.lang.String getCartName() { return cartName;
    }
    java.lang.String getRomFilename() { return romIntFileName;
    }
    public void outputCartInfo() { boolean checksumOk;
                                   cartName =
                                     new java.lang.String(
                                       rom,
                                       308,
                                       16);
                                   checksumOk =
                                     verifyChecksum(
                                       );
                                   java.lang.String s =
                                     "";
                                   for (int r =
                                          0;
                                        r <
                                          cartName.
                                          length(
                                            );
                                        r++) {
                                       if ((int)
                                             cartName.
                                             charAt(
                                               r) !=
                                             0 &&
                                             (int)
                                               cartName.
                                               charAt(
                                                 r) >=
                                             32 &&
                                             (int)
                                               cartName.
                                               charAt(
                                                 r) <=
                                             127) {
                                           s +=
                                             cartName.
                                               charAt(
                                                 r);
                                       }
                                   }
                                   cartName =
                                     s;
                                   java.lang.String infoString =
                                     "ROM Info: Name = " +
                                   cartName +
                                   ", Size = " +
                                   numBanks *
                                     128 +
                                   "Kbit, ";
                                   if (checksumOk) {
                                       infoString =
                                         infoString +
                                         "Checksum Ok.";
                                   }
                                   else {
                                       infoString =
                                         infoString +
                                         "Checksum invalid!";
                                   }
                                   JavaBoy.
                                     debugLog(
                                       infoString);
    }
    public int lookUpCartSize(int sizeByte) {
        int i =
          0;
        while (i <
                 romSizeTable.
                   length &&
                 romSizeTable[i][0] !=
                 sizeByte) {
            i++;
        }
        if (romSizeTable[i][0] ==
              sizeByte) {
            return romSizeTable[i][1];
        }
        else {
            return -1;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public Cartridge() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        Cartridge ENT_ld =
          new Cartridge(
          );
        ENT_ld.
          rom =
          this.
            rom;
        ENT_ld.
          ram =
          this.
            ram;
        ENT_ld.
          numBanks =
          this.
            numBanks;
        ENT_ld.
          cartType =
          this.
            cartType;
        ENT_ld.
          pageStart =
          this.
            pageStart;
        ENT_ld.
          currentBank =
          this.
            currentBank;
        ENT_ld.
          savedBank =
          this.
            savedBank;
        ENT_ld.
          ramBank =
          this.
            ramBank;
        ENT_ld.
          ramPageStart =
          this.
            ramPageStart;
        ENT_ld.
          mbc1LargeRamMode =
          this.
            mbc1LargeRamMode;
        ENT_ld.
          ramEnabled =
          this.
            ramEnabled;
        ENT_ld.
          disposed =
          this.
            disposed;
        ENT_ld.
          applet =
          this.
            applet;
        ENT_ld.
          romFileName =
          this.
            romFileName;
        ENT_ld.
          cartName =
          this.
            cartName;
        ENT_ld.
          cartridgeReady =
          this.
            cartridgeReady;
        ENT_ld.
          needsReset =
          this.
            needsReset;
        ENT_ld.
          RTCReg =
          this.
            RTCReg;
        ENT_ld.
          realTimeStart =
          this.
            realTimeStart;
        ENT_ld.
          lastSecondIncrement =
          this.
            lastSecondIncrement;
        ENT_ld.
          romIntFileName =
          this.
            romIntFileName;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV9CbTsyFlev/tmZ/bxjIexZ+bZHsOMm1y11Iu6GdugXtXq" +
       "VqtbrV4kY561dWuXWktrMYPxnIAXwDbJ2DEEj51zbEg4Y7ZAQk5iYhIcIDg+" +
       "wTGbSWxDWAPOYQKBgIOdUi93e3d5d97NPUfVUm36vr/++usvlUr3hS9nbvbc" +
       "TNaxjXhu2P6uHPm7mlHc9WNH9naJbrHPu54s1Qze8xgQd1V89U/e81dfeZ9y" +
       "707mFi7zAG9Zts/7qm15tOzZxlKWupl79mMbhmx6fubersYveSjwVQPqqp7/" +
       "dDfzdQeK+pknulsIEIAAAQjQCgKE7ecChe6SrcCspSV4y/cWme/MXOpmbnHE" +
       "FJ6fedXhShze5c1NNf0VA1DDben1GJBaFY7czJU97mvO1xB+fxZ67h99+70/" +
       "fTlzD5e5R7WGKRwRgPDBTbjMnaZsCrLrYZIkS1zmPkuWpaHsqryhJivcXOZ+" +
       "T51bvB+48p6Q0sjAkd3VPfcld6eYcnMD0bfdPXozVTak7dXNM4OfA64P7XNd" +
       "M2ym8YDgHSoA5s54Ud4WuUlXLcnPPH60xB7HJzogAyh6qyn7ir13q5ssHkRk" +
       "7l+3ncFbc2jou6o1B1lvtgNwFz/zyImVprJ2eFHn5/JVP/Pw0Xz9dRLIdftK" +
       "EGkRP/Pg0WyrmkArPXKklQ60z5d7r3/PWy3c2llhlmTRSPHfBgo9dqQQLc9k" +
       "V7ZEeV3wztd1P8A/9Il37mQyIPODRzKv8/zL73jxW7/psU/+8jrPK47JQwma" +
       "LPpXxY8Kd//aK2tPVS6nMG5zbE9NG/8Q85X69zcpT0cO6HkP7dWYJu5uEz9J" +
       "/wf2u35M/tOdzB3tzC2ibQQm0KP7RNt0VEN2W7Ilu7wvS+3M7bIl1Vbp7cyt" +
       "4LyrWvI6lprNPNlvZ24yVlG32KtrIKIZqCIV0a3gXLVm9vbc4X1ldR45mc3f" +
       "zeBANuerXz9TgxTblCFe5C3VsqG+a6f8PUi2fAHIVoEc9er6JFUbwY4hzxWh" +
       "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" +
       "LollE9BUFUNhmCKCkDE/0KbsTOdNFy6a");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2d5YGPBJBdGzXhQPo8rCIsM6lA2Bsz2KERaMBmgbigvAtMV81ijPexZE5CgR" +
       "RxrxqNik+xxKSyXLJJImR8h9uokjGgT1YwoF7pEQVRm1RVNlcjhMVKvXVrke" +
       "YTfG9pBJyiTLRFCBVoqdqD9Hak0eGTdYthTnvGZrkMOKJNNsjNvZSdhuIsZk" +
       "0BM5gwxKhsbRfC07Zmh4EdJwxNQSb0aU7TrhYARwewZe1aIxuoSFBck2TUk3" +
       "McZo1IyRnpCeQGdV1SOa8KRGWSO1oVqh1cJ5yqNqUpcbLgYxPxJapaE1VQD5" +
       "ilVWXJxUWW/CBDnalXJm2DVoFdQFHL0CMqySsdP21LY3NWBBak4q2QnAqtK1" +
       "BaN4enfaxshipdOmOst50JBzUrvcKEbjjgWw5vHlWDdzixGcmzTkqEZRhXEi" +
       "5Vxs5o2JMRBTLVrqSb7kmUIP5fv+RCHA7FgNWU3PB56MMLzDAWeuHnVK1ILS" +
       "DZEKx5O+1Ol14CmvLhgOCEJqBHVl5tWo9gx350Z1Os41FpQX8gNsaiZYOYLY" +
       "Tg+KYTWpS9kcU6/kdH66gPRhTegNCcukaoJBWz5cawkCPVO9Gd9RZnSHbRVH" +
       "QCe782ncKAt1mkRUG4GLPO71CoPGcCnrvcJy4nvLcLpIGgufnOjxklzUhPa8" +
       "I9XLYjUnDao1qdZoLBTSdBqEHHC0lucXBMt2zOGiV8NFCseyRBUY87AKD0Jn" +
       "TIT5eosoWyHCVAPXMgYJqwy4ci8a1WlkhHXH41FnPBQpmw+ynlCaZbt8kWL6" +
       "SSXveEHcHpeaCR7U57qtxMNOvkOM6JRje9ztCX1m2HcYJDdPoqHGNPUypnUY" +
       "TbPnpcTuag0WjxusSQXFUSleDDhzEi3wIJgHZs4w1URyRma7gNaGSK7DooW4" +
       "3ZpJfVyZ+H3VrS4bMjEZsr1BNCuzdF+GizIa4d5Y7FFNU8ln47yFdXmfm1oE" +
       "wplTXXfNmIvqxURY1gOIlYaLCBKaltk32SVNoKTkFu2c3lxwBnCdKkl1aPt1" +
       "C4PwyQDXBEJFB02cWxhtM9a9ybTu4pBRoiswTOK2MOjMqtjMSKrQuIplxRbd" +
       "bTCVHCbJPA6aol+Fe44LUTzOBLKSixuDcUfLGjHutfQspDntiJSwqMjUkyaO" +
       "s/gc5elaTyl6huaFZDtoLsFg1q/grC4uFmZ9To+mMjmKZSXR58XhIBfpeR1h" +
       "a41ZrE9qUg+bIwtlKEx4BesEtGrzI43pOjFkIW7JYymgeESIcdlx1aAaOaeq" +
       "F8bLVju/7GA6J3dCTMlzSb0axYUxb+T4/DDSbbXV9PJsPRjIWXOxzHbCkb8s" +
       "47o0VqbIoAQj3gQpQlhPLlOBIHTEJuXPyf7IxIoO1bQbZr6HGWDwjILCJJBi" +
       "3y4sDD1KhtPlwGlqUwJFPIbIjqpVnCo0Ir/QXJZIo2GBOcqiN+nios1SZp6e" +
       "1JzGsmdi3kIbLGQtx8IEsXAHY7dh4SRZKUggf7WbH0m8So3yqj2beKPpxJzg" +
       "RRM3lWhkKgmp2TTpN2i01pYNlKSjyNM9EaqCCQRcLXNMTFFyJ2IZsUqgo5KW" +
       "cNbABL5zhx56Y3mmFPh86LVL44CzGyMRNPe4zGAEznU6eHtBzcV4xE5kMaKL" +
       "MKfNhTkeiGSnIGKx2y0zDa0FGpmejeRG1i7DxRxhDtWaiUw7/W4o8kShzheY" +
       "BSl541y3VTA7tEiPbVHnbKnGlloMQWelIdqZYaM4AnPI1CGs6too6uSIynRK" +
       "V5AxpEfxHAkabXRaMEajeTULLfRatsoFclMJxHGxMRTE1gieKlVrEU3E3oSI" +
       "u8O+1mOMKRxNqh00SVSoYCz9YJmDyrOYq+n23IGXJbRdKtf01ogdM93AX0wY" +
       "NHaE+cyoYLTu0dNRJAq9aaOccCVa5erEwhnIBKkKCWn2wjaXpdx6x85FpXkJ" +
       "5ks416sUx13Sx0i70NXYIk7kSHNhVAsDAowTnoS2OL1hKM1wLkKaUog1F55X" +
       "S0o0KBoTBe4s6SxXIzoWTXWgDsJm29HIwevVolAmqVqtyTa6Xa0gNXGj1+nT" +
       "vFQrphwqKFzXUVHQe4a2LHHuGANTOdiJesDt8aPpYCqEyjhva9Rcj0a2bFVU" +
       "N6qYvbhuhk1sLtESWtMnLRaZx7JUs8tZTY8bTH1oiKHdGpV72dBWoP4YGkw4" +
       "YSQgzjJClgTJ+NaCI6DAqc8TLVZYOYwZJVLnMUL43CiwZoO+Xxvjeak8UQUV" +
       "tpv9/qqP23phMXGAsCiaZpSJPGNlptyOa3ZLjLIDqeWYQn+g+kLLyKHmCKL1" +
       "IREsncmoxuS7tkHqDXhqQ2xbRQsyC2GYqLlzAp90leykU8xPnIE96tgjpSVV" +
       "OdMe+D1onB1W5p4RiXW1DtfHJSXrogsGnTtcW0GTpTpAG1M+6jADrs8NFn2O" +
       "19odYCk7ND3qLEt4O5uMTLeMd1oUmNEFiZALG4wbSYlIhkzJi7sJ6HLjDu6j" +
       "oF+gSD/WFKjuQ16/OdaKHBEuCgtaHKlkbmHrWTrtE/a0D/oExS7btN5qAVvV" +
       "Vw0VOEMuKUWe1Jz2kLFbbfAua1CKHuZA88vToF2khqQxaUBlLR+N2bDiiUSN" +
       "xgy8bEEFUesMkz4qKMD0DdqUP8aXlXFRYKB+H/dQyi2EYVnrz2ucxFeQkVhy" +
       "pX7UHRDWNG90s36hVqrwYt+dBJWimMQRFC27smr6Sr4u1zuBySZIH1pinfJ4" +
       "Woy4Nl9ejsYCh8QTkbEUM6Hwfl4qtvsUpY2QAe44WJMSjTKS9ANzhMoy5OOG" +
       "IUxn5tRw8CZk1dBcGbecnlyKHKHUDzqab5RnXr3J1aSkntjKAlo6SmhRCeim" +
       "Gg/VCxpRcyqTfBdzWGLBoviwReVFEkZEEkJzTT1byI29fnuBlzS3AhFLu7gs" +
       "19vDoFyMBouxphEDXRsMkZHWho2GOK9XGFVmesW53EoQvjXjRZFo5aGgGbbi" +
       "/gJq9qMl7XKVMkQJU7RYiYK6Q0XahB55vU6uTkPOFIX13piqjFp5FR6wU73P" +
       "l/vzSp/Mk/IIRjC3ICzkliC6SaKI8KjehJpJsRGCWQtUl/Gyhmp6pRIXCo2F" +
       "CeUJ2RskMDGYN8aFYaWoNLhsQajnc0w0gPuymSu1hr0OxoXLUKtX8ohTz/aL" +
       "Phm2cWCZMSxdyHnP+ZaF7lstae3tkH8Ji1nRSQt4e2uBe3+HtlgfWAtc5Xz4" +
       "wFuAD/qZV8qWv+sGlq+a8m6jx1zFfN9VhcBfb0FxM4+etFV+tSPno88+97xE" +
       "fQze2awk8n7mdjAH+nuGvJSNA/dbv5pj72G9dbumemQnw4vXt5NBtfwrKVh+" +
       "A3a9v/BN6uzKk65trrYu7K635lx54xuuwLlCuYiW0izr/SdXGla6MievM+Lt" +
       "Fn413QXx9JVnrgDU8pUT6ikiBaRcPqkasl0/XMvx2brUZJvtzcOXuiXy0j85" +
       "bUvkpY+dkvajafBhP3PXIfmlOa/uL/V+5Dz7JI807SrbFXD8xQb0Xxxdkj7A" +
       "96g6H3xN8xQSP3VK2j9Pgxf8zL37b06s31dK45/a53jm2/SncLxtq75f3XD8" +
       "6sVz/MQpaf82DX4ufbMnpTeMPV82j33zYWmr0j7lf3WjlB8E6Hc2qrhz8ZQ/" +
       "fUraZ9Lgl/zMLYEj8SuFvfQL+8x++UaZPQRAPrZh9tg5mGWOJXVpn3Vuhf63" +
       "TmH2+TT4L37mbg90RgfMVIBJ3nw+ILfP8HM3wHC1b+wVANCTG4ZPXkzbHXjZ" +
       "fDWUISs+v38K1z9Mgy/6mVttR7bozfv9e7sjVXu3bTmBP/RdebMvccX9SzfA" +
       "Pd2OkAEteundG+7vPgf3a168P7mdr674/a9TuP9lGnwZdFpektKNZul7Zmm+" +
       "9+4T/Z83QDTdpZ9uDbn08Q3Rj198B/3qyWk7q3Hpb/zMHXPZJ3mnvfkUzAEV" +
       "/tsb7aSPA6Cf27D73MWwO9qCO3ecQvHONLgZ2CCTd4DyHrZBO7fcKD3QTS/9" +
       "zobe71x44+08dEraw2lwn5+52d2+aXiA2P0XMFJe+tKG2JcuntirT0lLa9t5" +
       "FHS69O14oJaOunoV8CC9M9/6PoveowDpH2zo/cHF09s9JS01uztPpa/vyZ5v" +
       "uycwfN2NMiwCsC9uGL54MQwPjB1X93vfN5/C9fVpUPQzL5NkIZjPZRdb29GJ" +
       "qx71B3bOfOv7FMbpHppMHoD/2obx187B+KwR43jazVNo42mA+Zk7+ZPpVm+A" +
       "7p2bHrrzjnXZ9e/FqjB9Slq6mW2HBCoMxo1eYNIYub8bap9h7wI66c7mVeOd" +
       "a141vnGG335K2lvSgAUM0y/zVMGcS3Zjmj86fHA32oYpw09tGH7q4hlqp6Sl" +
       "38jbkf3MfaAN9wmmn1Y50oyzG3VwXgnIfWZD8jMXT3J5StoqWICZ8yGSac7f" +
       "3ifo3ujM+eWA2Gc3BD978QSfPSXt76fBM8A5F3lrCIbLxaEJ886Zn3q4ni74" +
       "mxtqv3nx1N5zStr70uBd6RwL8DqxC777Rhk2AbO/2zD8u4theHn9XHF1DSZK" +
       "d64mSpbs747obhqX26bcUjfnohOs6P7QKaL4SBq8H0y5DooCIxl7IgtH5PGB" +
       "G5UHDpBvnl1dvnSh8kjh/eMV//TsQytmP3YK6xfS4GN+5sGDNhgjm65tXsv7" +
       "Ry7gacLlWza8b7l4Tf8Xp6T9XBr8FOjEm01xR6j99I3aJzCVvnzXhtpdF0/t" +
       "352S9otp8AnQiZeyq87imiKLuheYR8zUz99o4z0AmL1iw/AV52B4/KOggwQ+" +
       "c0pautlk51fARAWMLrWDe+P2mf3Hi1DLxzfMHr9QZp8/Je2/psGvrx08er0T" +
       "0bqW3G9cwOhy+YkNuScuXjH/8JS0P06D3wUM7cB3glXzbR5/HOx6v3cBTvrl" +
       "1oZh62IYXvP445QHWDvpA6ydL6/8WFsfOSnNY1y8G3mGtVoWSndVH14Wuund" +
       "17csdHT9ahUh2k68Xh7a+xrlaiVmlWhIm49eHU57cnd396mnv+mKvOSNJ9f5" +
       "1qs3YLgABXxF9dLT47Pw+1n447Nsv/iwzbe9Pjbz9msM28zb62Mz730pYZt7" +
       "L+L4uvc/Y7BX/X7UsUX2vjKwLbAXcZI0DmbeXJ6UtX8U/sG4Ywsd3T2/LXg0" +
       "/qQ7brayH7jfJubYAtuN5tvs2+tjM683gW+zrq9OUqrtvssDyrWNOlEpDubf" +
       "Xp+YeX9n88Ei+7HH6+neCtqepu7FHFtgvTN4m3l9dTzlg3t290gfjDy22DEb" +
       "aLeFj0k6SdgH9rkekPeB2LTgdu12v+jTL329ducrp63X7nzt5LTLqW3e+Rs/" +
       "c9vWlqWjyg/um9tzPVSPDn6hfAPp8KeT1199jdbvBzx80Eqv3lA481HwXpGD" +
       "37ROP1a5+vcJ2w9LBut/oHBV/Innid5bXyx9bP1NbdHgkySt5bZu5tb1571X" +
       "laYfp3zVibVt67oFf+ord//k7a/dvotw9xrwfmsdwPb48R+wbpiOv/rkdPJz" +
       "L/+Z1//o819YfUvw/wEkv0zj12IAAA==");
}
class NoSaveDataException extends java.lang.Exception {
    public NoSaveDataException(java.lang.String s) {
        super(
          s);
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
       "FBoAAA==");
}
class WebSaveRAM implements java.lang.Runnable, DialogListener {
    Cartridge cart;
    boolean save;
    java.net.URL url;
    Dmgcpu cpu;
    java.lang.String username;
    public WebSaveRAM(java.net.URL url, boolean save,
                      Cartridge cart,
                      Dmgcpu cpu,
                      java.lang.String username) {
        super(
          );
        this.
          url =
          url;
        this.
          save =
          save;
        this.
          cart =
          cart;
        this.
          cpu =
          cpu;
        this.
          username =
          username;
        if (!cart.
              canSave(
                )) {
            ModalDialog d =
              new ModalDialog(
              null,
              "Sorry",
              "This game does not",
              "have a save facility.");
        }
        else {
            if (save) {
                ModalDialog d =
                  new ModalDialog(
                  null,
                  "Confirm",
                  "Are you sure you want to save?",
                  this);
            }
            else {
                ModalDialog d =
                  new ModalDialog(
                  null,
                  "Confirm",
                  "Are you sure you want to load?",
                  this);
            }
        }
    }
    public void yesPressed() { java.lang.Thread t =
                                 new java.lang.Thread(
                                 this);
                               t.start();
    }
    public void noPressed() {  }
    public void run() { java.awt.Frame f =
                          new java.awt.Frame(
                          "Please Wait...");
                        f.setSize(200, 120);
                        try { if (save) {
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "Please wait, saving"),
                                      "North");
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "game data to web server..."),
                                      "Center");
                                  f.
                                    show(
                                      );
                                  saveRam(
                                    );
                                  new ModalDialog(
                                    null,
                                    "Sucess!",
                                    "Game data",
                                    "Saved ok.");
                              }
                              else {
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "Please wait, loading"),
                                      "North");
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "game data from web server..."),
                                      "Center");
                                  f.
                                    show(
                                      );
                                  loadRam(
                                    );
                                  new ModalDialog(
                                    null,
                                    "Success!",
                                    "Game data",
                                    "loaded ok.");
                              } }
                        catch (NoSaveDataException e) {
                            java.lang.System.
                              out.
                              println(
                                "Error! " +
                                e);
                            new ModalDialog(
                              null,
                              "Error!",
                              "No save data can be found on the server!",
                              e.
                                toString(
                                  ));
                        }
                        catch (java.lang.Exception e) {
                            java.lang.System.
                              out.
                              println(
                                "Error! " +
                                e);
                            new ModalDialog(
                              null,
                              "Error!",
                              "Load/Save error!  Report to site administrator.",
                              e.
                                toString(
                                  ));
                        }
                        f.hide(); }
    public void saveRam() throws java.lang.Exception {
        java.lang.String params =
          "";
        java.lang.String strUrl =
          url.
          toString(
            );
        int questionPos =
          strUrl.
          indexOf(
            "?");
        if (questionPos !=
              -1) {
            params =
              "&" +
              strUrl.
                substring(
                  questionPos +
                    1,
                  strUrl.
                    length(
                      ));
        }
        java.lang.System.
          out.
          println(
            "Params: (" +
            url +
            ") " +
            params);
        url =
          new java.net.URL(
            url.
              getProtocol(
                ),
            url.
              getHost(
                ),
            url.
              getPort(
                ),
            url.
              getFile(
                ) +
            "?user=" +
            java.net.URLEncoder.
              encode(
                username));
        java.net.HttpURLConnection conn =
          (java.net.HttpURLConnection)
            url.
            openConnection(
              );
        conn.
          setRequestMethod(
            "POST");
        conn.
          setRequestProperty(
            "Content-Type",
            "application/x-www-form-urlencoded");
        conn.
          setDoOutput(
            true);
        conn.
          setDoInput(
            true);
        conn.
          connect(
            );
        java.io.DataOutputStream printout =
          new java.io.DataOutputStream(
          conn.
            getOutputStream(
              ));
        java.lang.StringBuffer saveData =
          new java.lang.StringBuffer(
          "");
        byte[] ram =
          cart.
          getBatteryRam(
            );
        for (int r =
               0;
             r <
               cart.
               getBatteryRamSize(
                 );
             r++) {
            saveData.
              append(
                JavaBoy.
                  hexByte(
                    JavaBoy.
                      unsign(
                        ram[r])));
        }
        java.lang.String content =
          "romname=" +
        java.net.URLEncoder.
          encode(
            cart.
              getRomFilename(
                )) +
        "&gamename=" +
        java.net.URLEncoder.
          encode(
            cart.
              getCartName(
                )) +
        "&user=" +
        java.net.URLEncoder.
          encode(
            username) +
        "&datalength=" +
        cart.
          getBatteryRamSize(
            ) *
          2 +
        "&data0=" +
        saveData +
        params;
        java.lang.System.
          out.
          println(
            content);
        printout.
          writeBytes(
            content);
        printout.
          flush(
            );
        printout.
          close(
            );
        conn.
          disconnect(
            );
        java.io.DataInputStream input =
          new java.io.DataInputStream(
          conn.
            getInputStream(
              ));
        java.lang.String str;
        while (null !=
                 (str =
                    input.
                      readLine(
                        ))) {
            java.lang.System.
              out.
              println(
                str);
        }
        java.lang.System.
          out.
          println(
            "OK!");
    }
    public void loadRam() throws java.lang.Exception {
        java.lang.String params =
          "";
        java.lang.String strUrl =
          url.
          toString(
            );
        int questionPos =
          strUrl.
          indexOf(
            "?");
        if (questionPos !=
              -1) {
            params =
              "&" +
              strUrl.
                substring(
                  questionPos +
                    1,
                  strUrl.
                    length(
                      ));
        }
        java.lang.System.
          out.
          println(
            "Params: (" +
            url +
            ") " +
            params);
        url =
          new java.net.URL(
            url.
              getProtocol(
                ),
            url.
              getHost(
                ),
            url.
              getPort(
                ),
            url.
              getFile(
                ) +
            "?user=" +
            java.net.URLEncoder.
              encode(
                username) +
            params);
        java.net.HttpURLConnection conn =
          (java.net.HttpURLConnection)
            url.
            openConnection(
              );
        conn.
          setRequestMethod(
            "POST");
        conn.
          setRequestProperty(
            "Content-Type",
            "application/x-www-form-urlencoded");
        conn.
          setDoOutput(
            true);
        conn.
          setDoInput(
            true);
        conn.
          connect(
            );
        java.io.DataOutputStream printout =
          new java.io.DataOutputStream(
          conn.
            getOutputStream(
              ));
        java.lang.String content =
          "gamename=" +
        java.net.URLEncoder.
          encode(
            cart.
              getCartName(
                )) +
        "&romname=" +
        java.net.URLEncoder.
          encode(
            cart.
              getRomFilename(
                ));
        printout.
          writeBytes(
            content);
        printout.
          flush(
            );
        printout.
          close(
            );
        conn.
          disconnect(
            );
        java.io.DataInputStream input =
          new java.io.DataInputStream(
          conn.
            getInputStream(
              ));
        java.lang.String str;
        str =
          input.
            readLine(
              );
        if (str.
              equals(
                "NOSAVERAM")) {
            throw new NoSaveDataException(
              "");
        }
        if (str.
              startsWith(
                "ERROR")) {
            throw new java.lang.Exception(
              str);
        }
        int pos =
          0;
        try {
            for (int r =
                   0;
                 r <
                   cart.
                   getBatteryRamSize(
                     );
                 r++) {
                java.lang.String sub =
                  str.
                  substring(
                    r *
                      2,
                    r *
                      2 +
                      2);
                int val =
                  java.lang.Integer.
                  valueOf(
                    sub,
                    16).
                  intValue(
                    );
                cart.
                  ram[r] =
                  (byte)
                    val;
            }
        }
        catch (java.lang.Exception e) {
            throw e;
        }
        cpu.
          reset(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HD74Hw7BRxL5HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
