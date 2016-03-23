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
      1457190440000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Gc/OxTP+mGlz+n8BJ3mlfs9MAAA=");
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
      1457190440000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vKb9Vs+YQcJSTWRHk0pC1Az4ij6orSl6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("QJVDfY3xcICTvWjAAHc55sP5Kphr/JoOalIXK0/qbr+6mowHNL4YEo2F0a4s" +
       "zbHLCosIaRDSROPh+qSDJuVOOyHaHKG0USTtMlxXKlr0ouhMhdGM5vlVOuOp" +
       "ikNSi0CCqDEwWYo8S+cBkyGSgvfxRcpKgjS3NWwqq0NlVUqd8RpdjlgJkbi6" +
       "NDDLktdFOXYWBwzWXy5W6tRRrCrZa/nEmDRx3YiLhhC3jJYiLrFMlcYOZ3jT" +
       "mTIC3cSbuYIk1MQVos3oqCIKTc426WFL62Vkv1HVlqthqEEMopTkhRiaVHet" +
       "ciUHzCba4nKVqSN8WCwqXt9TiqIkLmJmXYuceVBOuwuxOuwoRmdljglmwbX1" +
       "9qztMkJWsXwlts1WfdSxB7RXQoPSMpPKo2WWcS25v6ZQtVstA4ue1DpEt8qR" +
       "1VE5k0uw6Qeg5xARgzgIGE7HYTXTymVUoXtmxCo+PlYEosQLEMetBiMuE9We" +
       "tSjZ0mItTWWj6KxnyRTnEI1i+qWmbK/wZUmZFqdI1CPp6tysSxoceciAN7ji" +
       "pGUsPE3uDhxRHPREb+BwouYK8kxtlQcLzkWHfI8ReMzlcGKpsGSyCmYdPZot" +
       "FmjKaao1w0dqRlupkIhQcRhA2XAclAzLlhymNpRIg+wRXieZcq2WyllY07Gx" +
       "Vo6TtWWe5wJB0GRCxdsDX6Bma4+fyxE1TYQusiouEdZZjNeJVSRxFE71cgnr" +
       "egph+jrHIfLcKCZT01t6+nIxHgqlxkAoSZP6aLiqO7CLJsZosugHpXTOxDgW" +
       "+k1L7FS6zZGQc0SHTA/FSRGO+mD8W6UrbdAmVs15TZs2PA91VzyJ9XkHE1i9" +
       "Ic5KdtFbsyw+4o0hb0SzbmTHqEgDozpinV5HT9FOmSFhhaUENeTFOT7xw364" +
       "QNRZC66t2iYcZKWKhfaXSG3E9JQEziiHYVRFlV06UkjNXiTxqtqvoGs0wuNJ" +
       "H/TItKq6gcNz/ZZAo5zBVP3ijPaqw8liZqC4iMwweSW3xRU+VapWtT9k1KXd" +
       "cbPFYiSvAxKWoEEDo3m0Q/W7PI1NhhUMbrebEFyajjwX9bCsXuQyogbhnrae" +
       "QFKRsyUwfVt40+WQKk0W/Nil55WmKFjAqVgXHdfuczHCCuXilEDxVO26ynQs" +
       "mAxUkWtwxqWddDhkwdykE9c7dAhjFN3MiFkwpxNa6rMd2EaWRFnFm9iSorG5" +
       "RAvDrDfExYXaqfJynSxNJKqZtuop19e4zGO9Vdnm2EorRGZko90n5uuqiREm" +
       "yo07XV4WcSm2WrWRPiP6q8BFMSXDKytlCJdKTbEMr6D+cNSeKHgwqgHHy214" +
       "amNsmJXRotY1BtzY9NnmQIVG05amF0EPRNC2NuvWKl1ybi1HA6pHQw11Merp" +
       "bqJmrFvtE4SOTgdkZTqCvUwSzZYueqA/GuvmtDbR7XF3QdahMZaFJjHwGu1e" +
       "pipLgtZSpbrCeZMYVxuYiKedkZY4UcejipUeWRrbIqQ4bY8dBX0/kr2UnRFp" +
       "BWdiOuWEKE0IQoTSVV2z6fUYz9o8V/OlOdGkUaIyw/1EII0WvfT7EaEKMwSq" +
       "pMtw3JX1dasmYlN4viCmYyeUTaITN4hqEXOWUXPtWnSCiSoyQjDgpWIxxbIq" +
       "jrdTY+mMHayxBD6rZIr1GrGmhZmmMG3ZRbg2WccjnS6BGUM3o+ZJuyvoou3p" +
       "C9ozWp0aOaAFyBBRdoJJ3VQsIk0FzNcXczblivxaQsReeQgv0mw+iokOKiO0" +
       "KE2BFi4XLaipLM32bKkPq4So6aRUcoG9XKYjPRo1s6bYG/RwWx5WVayLrtcW" +
       "jNhJaCZFMMBkSgvoqV9KaminVlcXuDQeDpjQAG0nZ4k2ndgNTHBDWpZSXevJ" +
       "RGut1FJLwXN5mV3W0lLWKa06CsQFeNcrpjWvWlZVSukB698NI4z1kO58XCXp" +
       "Iuss7SYyoklKDXWKpBecPWuvpjo8nyHpPGz3m7V52q9ao1mJSARIadFdV+C6" +
       "cLc8Njup5FeoZlWrs8Dw2WOMYVxk1OW7mcTN7Rrw64SmXKssB50ywtNzDTeL" +
       "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");
}
class NoSaveDataException extends java.lang.Exception {
    public NoSaveDataException(java.lang.String s) {
        super(
          s);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457190440000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TB4v3ZbXyfwDuASpfa0PAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457190440000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MBu6MBxUipSx0pk6Ny4vUra2p5tSNBemQrMlCzQ8qthTtMCPlzRo3MvpbCAz" +
       "AjoctWrirDiSqYGP9oy6PVaKQi02KLLWoeutKPVbbTYeyjKpOGORlFyXhfvJ" +
       "WFLjZk1ISFlIEmVeqIPmakirTr9TSZpqGanOxTTt2wOSTRVlNOcIrNpyiZBh" +
       "XdRT9ZGCUm1ct7QuTHqqkThLt17ve+BahHPzKmGIbBOkQHpNLA1B4Xy8F8eK" +
       "HlBzVxerJUxrAa40n9qb8+2eW2BnKGIn6mpFybBDF6v1Jd6XGJO2jWIr1Rcx" +
       "Pk3RsmsVdNrbIwLSTw1R73DtQFzTK6cyWiJpbd2ey/U5X3GcyWQ+qCDFWRug" +
       "uVFLr2hKoeiCqooO/KEjOKu42ven4mhZb0pLLXaDXqmRFKSWFOIeOJPojl0a" +
       "7whWSSbq6ExdKz7WYsRCJSXRQmlUbhTV/jhkZ37NlpzpzIjDmTB1auwIra1D" +
       "Ye6h1tpyq8NRPKqQ/Xo7FkzVm495KgvrleeIHIfFFQ1fyUjPbtWGzF61IPed" +
       "WWvtUpXVWhr0S+G6wVDLZWMkz9bSqJrWCvCkXSbtSX2k82q3LJpFfOrp7VE7" +
       "kos9qdw050agFMbYxJr3pcpAnC9YwuAZpliBZ/OR1BPoHiqT/dJwRpQL1Rpw" +
       "8mnHlthB1LL0rlcpl2t7MmeVVa0htRuMK0+1CKWn02mX02cttZaOuuv+gKGn" +
       "/toZEri1pjEzWY/XrpU0A3bZHfLTmSLVmHBCNDouuqIJA1OGmGcU2/01Ylp8" +
       "aWbF3KIgMF2mJM67g4UwqeKrkDY7dMWN8G5tb4ZZRaPqLtFlt9MYz0f1UjBn" +
       "1vB0UqMrDU/sLmKxtiy6A6xic2J5OELLs4itGlV7JExnpXRRl6bDEVmIJhxd" +
       "RhuRCI+KoSaMYAz3loKykkyxE8ALbFKppnseghWmy7Q0NmZazUYxl3LNGp2M" +
       "I1mj24UCrHWMZTprLhKCbaYFTOdwgRlNRgUtQJJlA6umfr1FUcM+luhwkbdQ" +
       "ArV4S+gUdbEy9gZ+4JLhShCNZqXFo4v1mA5WpRK+ZKOAZFGqOK90pmTNQwPV" +
       "X7nGSO4QBa0eEbpkTadihWPr9aHfFOaLarHcixfFQp+zmAFOlJSAngtjFhGm" +
       "2DzBWuzClgmc4oRSx4T7vBXi5YllBW2xHlLkRHOLDbFaoMFdkXOwiF3SHcMu" +
       "w3GxjSE9zJljFmNUw6hFrUiUDOelZrqmcLkuOxMBBDbGdAug7KEwXLUWbtvo" +
       "soXOeN4YUXWVF/GkypDVJqx5jsbLLTfw+jLCYlxzOrXCGaM1RjUq6jZrnSI7" +
       "xqtuA65Pu4YhWyU2QS2V8JYyZZLwcG5qElecRouAYvSGWZTcMRqu0XJtVMLl" +
       "HkXMtKAbeDZS79cFD6eJphevJaehuB0b33MWoYcEeGtI89UEjQZ1Hzg1tke5" +
       "fFJmVlJCI+IiHpD00MGmE4VnexSlm5ZerZp8JU44HFE1a8AGchFrVTROwpFq" +
       "FeaTwpqociSKzAXZNRSLEwJwD0u0wlQ3V41FfV41W9Jer9gJZtqE99Y9w0AW" +
       "3prUaqD4Msu21aF6QDxdN9JGe+BJIPgaAxYuEzhK8U22NiBLdDS2vb6ik/ZS" +
       "hI2CFNalWJZbmuXudSdGa6HO/Z5LRGRMLLXFxFwuu2uSLjANOwRqD2Uaszw0" +
       "RmCFb0oK0Qw7pkBSUh/v+z3fxMm6vhf3W3QptYpJhx+XxAndXpf9vTQlRo6F" +
       "o/JytgzL0cJ1ZshcFDnLkJCROSg195hkPhZGUWfZoN0Ar+J26onudFifodN5" +
       "J9bRMdLk4nVEEQJWGyr1FVElhsOAtYM6Nzd6i5grGCsb7umjkjuqTPzAqfig" +
       "nxlOu7xZZVVPZhVFiKvioIWGEkuA/KR5RaKMFSfroAarymiG9y1eigO2oWUh" +
       "VaGZsZ5OfTShrWrPq3cIpCxU3XZ/LwnYMTCjJk2TbrXh7CXhTBar/Q7TTSZF" +
       "E7Ql9RQOeMpvNdRSIWjHVSVSrUG9vCgp2t7KWjaTmhhYaoEHHd7Hstbv4/+/" +
       "7vvu/FJx+Ij7Pq4T6c0PhLbPFQef46+AR58rtldVKGurH7rVQ23eUr/62euv" +
       "GNyX0J39K/5eDG7HfvAzjrkwnWOkbv5qFwQHzwn3bO80h7vpqePcHOrg8o/r" +
       "vI8I8MSxW0v+P4R9UXrJ5r8I1/TXX6HZT71T+dLmqUl31PU6f3NmoPObV6/D" +
       "B73HbkntgNa5zpPv3vXV2z9yoJK7NgxvrXiEt0du/q5DukGcv8Ss/+hDf/D0" +
       "77zy3fxe93+fPV913BkAAA==");
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
      1457190440000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZfXAVVxW/7+U75BsI318h4PDRvFKhTg1FQkgg9AViQnEM" +
       "Hy/79t0kS/btLrt3k5fUWGCmAzojQ1ug2AH+AlsZKky1UzvaGqda2mmtU9pq" +
       "q1PqqDOiFVvGsXVErefc3X378T4wjmSGm82995x7zrnn/M45lwvXSZGhk/lU" +
       "YU1sVKNGU5vCugTdoIlWWTCM7TAXEx8rEP6659rWe8KkuJdUDQpGpygYtF2i" +
       "csLoJfMkxWCCIlJjK6UJpOjSqUH1YYFJqtJLpktGR1KTJVFinWqC4oYdgh4l" +
       "tQJjuhQ3Ge2wGTAyLwqSRLgkkZbgcnOUVIiqNupun+nZ3upZwZ1J9yyDkZro" +
       "XmFYiJhMkiNRyWDNKZ2s0FR5dEBWWRNNsaa98hrbBFuiazJM0HCp+uObRwdr" +
       "uAmmCoqiMq6e0U0NVR6miSipdmfbZJo09pGvkoIomeLZzEhj1Dk0AodG4FBH" +
       "W3cXSF9JFTPZqnJ1mMOpWBNRIEYW+Zlogi4kbTZdXGbgUMps3TkxaLswra2l" +
       "ZYaKx1dEjj22p+bpAlLdS6olpQfFEUEIBof0gkFpMk51oyWRoIleUqvAZfdQ" +
       "XRJkacy+6TpDGlAEZsL1O2bBSVOjOj/TtRXcI+immyJT9bR6/dyh7L+K+mVh" +
       "AHStd3W1NGzHeVCwXALB9H4B/M4mKRySlAQjC4IUaR0b74MNQFqSpGxQTR9V" +
       "qAgwQeosF5EFZSDSA66nDMDWIhUcUGdkdk6maGtNEIeEARpDjwzs67KWYFcZ" +
       "NwSSMDI9uI1zgluaHbglz/1c37r2yAPKZiVMQiBzgooyyj8FiOYHiLppP9Up" +
       "xIFFWLE8ekKof/5wmBDYPD2w2drz7FdurF85f+Jla8+cLHu2xfdSkcXEs/Gq" +
       "N+a2LrunAMUo1VRDwsv3ac6jrMteaU5pgDD1aY642OQsTnS/9OX95+kHYVLe" +
       "QYpFVTaT4Ee1oprUJJnqm6hCdYHRRAcpo0qila93kBL4jkoKtWa39fcblHWQ" +
       "QplPFav8bzBRP7BAE5XDt6T0q863JrBB/p3SiP2zmpCCXdan9ZuRNZFBNUkj" +
       "mhTp0lVU3YgA2MTBrIMRdJS4OhoxdDHSKujgLIkB2oSz2v9KmEKJpo6EQmCs" +
       "ucFQlcHLN6tyguox8Zi5oe3Gd2KvWm6Armvrwkj5l2i8Rxim3S2dJBTirKYh" +
       "b8vmYLEhiD0Av4plPbu39B1uKIDL1kYKQV3c2uBLAq1ugDqoGhMv1lWOLbq6" +
       "6sUwKYySOkFkpiAjprfoA4AW4pAdUBVxSA8uSi/0oDSmF10VaQJAIhda21xK" +
       "1WGq4zwj0zwcnByC0RLJjeBZ5ScTJ0cO7HjwzjAJ+4EZjywCTEHyLoTTNGw2" +
       "BgMyG9/qQ9c+vnhiXHVD04f0ToLKoEQdGoKXHTRPTFy+UHgm9vx4Izd7GUAn" +
       "E8DVAZXmB8/wRX6zg6KoSyko3K/qSUHGJcfG5WxQV0fcGe6Ftfx7GrhFKYZC" +
       "HcSEaMcG/42r9RqOMyyvRT8LaMFR+t4e7fQ7r//xs9zcDqBXezJxD2XNHhBB" +
       "ZnUcLmpdt92uUwr73jvZ9ejx64d2cp+FHYuzHdiIYyuAB1whmPmhl/e9+/7V" +
       "s2+FXT9nkEXNOBQjqbSSIdSpJI+ScNpSVx4AIRmCGr2m8X4F/FPql4S4TDGw" +
       "/lm9ZNUzfz5SY/mBDDOOG628NQN3ftYGsv/VPZ/M52xCIiZB12buNgtZp7qc" +
       "W3RdGEU5UgeuzPvmZeE0YDTgoiGNUQ51RdwGRVzzmYxUcEqFsqb7u6N+AMAg" +
       "6zHjBgSrlIS7GbZTyV1dfeLhxq7fW2liVhYCa9/0JyPf2PHLva/xmy9FOMB5" +
       "PLfSE+wAGx63q7Fu5FP4CcG/f+M/vAmcsCC5rtXOCwvTiUHTUiD5sjyVnF+B" +
       "yHjd+0Onrj1lKRBMnIHN9PCxr3/adOSYdZ1WdbE4I8F7aawKw1IHh2aUblG+" +
       "UzhF+x8ujv/gyfFDllR1/lzZBqXgU7/412tNJ3/zShbQL4mrqkwFC8NWoz+n" +
       "EX2a/34spTZ+rfqHR+sK2gFMOkipqUj7TNqR8HKFAskw454LcysXPuFVDy+H" +
       "kdByvAfbrcrSic2ZKd6YHBA10/mzhvsd1llNVp3FGa7hy3em1SBcDcLXunBY" +
       "YnjR2H/Rnuo5Jh5966PKHR+9cIMby19+e8GnU9Csm6rFYSne1IxgttwsGIOw" +
       "b/XE1l018sRN4NgLHEWoOY1tOqTjlA+q7N1FJb/68Yv1fW8UkHA7KZdVIdEu" +
       "cNQnZQC31BiETJ7SvrDegpsRBNkarirJUD5jAiN+QXYsaUtqjEf/2PdnfG/t" +
       "E2euctiz72WOHfpQXPjSPG/i3Exz/s3Pvf3EwydGLEfME1YBupn/2CbHD/72" +
       "7xkm54k1S6QF6HsjF07Nbl33Aad3MxxSN6YyCyKoElzau84n/xZuKP5pmJT0" +
       "khrRbpp2CLKJeaMXGgXD6aSgsfKt+4t+q8JtTmfwucFQ9xwbzK3e6Clkvkip" +
       "9WcauOqC3Xam2R1MpyHCP+Kc5DN8XI7DHV5/SLMK5WHFSKEIcYjfHVaSxvGL" +
       "ONi5b3tOD9zlP6YK2O+xj9mTQ+K9lsQ40Ewhc1GDkAbUq/j9+YCQQ5MUsgzY" +
       "x+xjYjmE3JdXyFzUjBSYOu+17g7IqE9Sxgrg3mef0pdDxlReGXNRg4wAsPh5" +
       "X0DG0UnKWAvcBfsUIYeMD+aVMRc1g2xjUN0JlM6AoPvzCJrVKM6Pv3Hz1m0u" +
       "8IWd3FPn5p5uU1Gw7nKWqjZKgqwOIIJidYH5YF6ubpxn7bMHj51JbDu3Kmxn" +
       "qQ2Q+5iq3SHTYSoHUHeeD3U7+fuDC2HvVT3yu+caBzZMpq/Cufm36Jzw7wWA" +
       "n8tzA3lQlMsH/zR7+7rBvkm0SAsCVgqy/HbnhVc2LRUfCfPHFgtbMx5p/ETN" +
       "fkQt1ykzdcVfgSz2tymzwANStiekgo7r+hp3ohWZxX8u0jxVyeN51k7hcBxa" +
       "8lFq4HOoQa3npntxaLb8uQXgb1iVEm4MnLhVsOavDXCiV+PzD/uNMxM0G7c1" +
       "HJ+8cXKR5jHA+TxrF3A4B9GiqLZtcOKMa4dv3S47YC97wFbmwOTtkIs0j67P" +
       "5ll7DoenAbt1UwlY4Lu3ywL1IP5pW43Tk7dALtI8Wv4ksOb0JzbsTnURuS0l" +
       "Ug3BhtO9hMOPoMHBEqFbSAYsNHEbLFSGazNAvSu2mlf+awuFiWXhnKR5LPRm" +
       "dgvhn5f5hrdxeB1Mgc1Epil+/v8wRcr3fqhpWbo1q0BOhTy5zebHxZh+KzHS" +
       "JN7nG8xI/H8wnOxhWv+HERMvntmy9YEbd5+zno9EWRgbQy5ToD+1XrLSGWhR" +
       "Tm4Or+LNy25WXSpb4uTqWktg9zrneO6jF4yvYac1O/C2YjSmn1jePbv2hZ8d" +
       "Lr4CHctOEhLAj3dmthIpzYTUvzOa2YdDtuaPPs3LHh9dt7L/w1/zZo1Yffvc" +
       "3PuhVXr0nY5LQ5+s50/mRVCG0BTvcTaOKt1UHNZ9TX0VZlsBe2xuB9t8lelZ" +
       "fGxkpCHzTSPziRYa2RGqb1BNhaN1JVQH7oxTefiStqlpAQJ3xvPu026lRLQ+" +
       "QGEsCr7nPPnM0rhzbsoWGZs48V/4Jw4f/geeQrrgzBwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457190440000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JgAA");
}
