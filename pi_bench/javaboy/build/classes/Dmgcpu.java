class Dmgcpu {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    public int sp;
    public int pc;
    public int hl;
    int instrCount = 0;
    boolean interruptsEnabled = false;
    int ieDelay = -1;
    boolean timaEnabled = false;
    int instrsPerTima = 6000;
    boolean inInterrupt = false;
    boolean breakpointEnable = false;
    final short F_ZERO = 128;
    final short F_SUBTRACT = 64;
    final short F_HALFCARRY = 32;
    final short F_CARRY = 16;
    final short INSTRS_PER_VBLANK = 9000;
    final short BASE_INSTRS_PER_HBLANK = 60;
    short INSTRS_PER_HBLANK = BASE_INSTRS_PER_HBLANK;
    final short BASE_INSTRS_PER_DIV = 33;
    short INSTRS_PER_DIV = BASE_INSTRS_PER_DIV;
    public final short INT_VBLANK = 1;
    public final short INT_LCDC = 2;
    public final short INT_TIMA = 4;
    public final short INT_SER = 8;
    public final short INT_P10 = 16;
    java.lang.String[] registerNames = { "B", "C", "D", "E", "H", "L", "(HL)",
    "A" };
    java.lang.String[] aluOperations = { "ADD", "ADC", "SUB", "SBC", "AND",
    "XOR",
    "OR",
    "CP" };
    java.lang.String[] shiftOperations = { "RLC", "RRC", "RL", "RR", "SLA",
    "SRA",
    "SWAP",
    "SRL" };
    byte[] mainRam = new byte[32768];
    byte[] oam = new byte[256];
    Cartridge cartridge;
    GraphicsChip graphicsChip;
    SoundChip soundChip;
    GameLink gameLink;
    IoHandler ioHandler;
    java.awt.Component applet;
    boolean terminate;
    boolean running = false;
    boolean gbcFeatures = true;
    boolean allowGbcFeatures = true;
    int gbcRamBank = 1;
    public Dmgcpu(Cartridge c, GameLink l, java.awt.Component a) { super(
                                                                     );
                                                                   cartridge =
                                                                     c;
                                                                   gameLink =
                                                                     l;
                                                                   if (gameLink !=
                                                                         null)
                                                                       gameLink.
                                                                         setDmgcpu(
                                                                           this);
                                                                   graphicsChip =
                                                                     new TileBasedGraphicsChip(
                                                                       a,
                                                                       this);
                                                                   checkEnableGbc(
                                                                     );
                                                                   boolean java1point3 =
                                                                     true;
                                                                   java.lang.String version =
                                                                     java.lang.System.
                                                                     getProperty(
                                                                       "java.version");
                                                                   java1point3 =
                                                                     !(version.
                                                                         startsWith(
                                                                           "1.0") ||
                                                                         version.
                                                                         startsWith(
                                                                           "1.1"));
                                                                   if (java1point3) {
                                                                       soundChip =
                                                                         new SoundChip(
                                                                           );
                                                                   }
                                                                   ioHandler =
                                                                     new IoHandler(
                                                                       this);
                                                                   applet =
                                                                     a;
    }
    public void dispose() { graphicsChip.
                              dispose(
                                ); }
    public void terminateProcess() { terminate =
                                       true;
    }
    public final short addressRead(int addr) {
        addr =
          addr &
            65535;
        switch (addr &
                  61440) {
            case 0:
            case 4096:
            case 8192:
            case 12288:
            case 16384:
            case 20480:
            case 24576:
            case 28672:
                return cartridge.
                  addressRead(
                    addr);
            case 32768:
            case 36864:
                return graphicsChip.
                  addressRead(
                    addr -
                      32768);
            case 40960:
            case 45056:
                return cartridge.
                  addressRead(
                    addr);
            case 49152:
                return mainRam[addr -
                                 49152];
            case 53248:
                return mainRam[addr -
                                 53248 +
                                 gbcRamBank *
                                 4096];
            case 57344:
                return mainRam[addr -
                                 57344];
            case 61440:
                if (addr <
                      65024) {
                    return mainRam[addr -
                                     57344];
                }
                else
                    if (addr <
                          65280) {
                        return (short)
                                 (oam[addr -
                                        65024] &
                                    255);
                    }
                    else {
                        return ioHandler.
                          ioRead(
                            addr -
                              65280);
                    }
            default:
                java.lang.System.
                  out.
                  println(
                    "Tried to read address " +
                    addr +
                    ".  pc = " +
                    JavaBoy.
                      hexWord(
                        pc));
                return 255;
        }
    }
    public final void addressWrite(int addr,
                                   int data) {
        switch (addr &
                  61440) {
            case 0:
            case 4096:
            case 8192:
            case 12288:
            case 16384:
            case 20480:
            case 24576:
            case 28672:
                if (!running) {
                    cartridge.
                      debuggerAddressWrite(
                        addr,
                        data);
                }
                else {
                    cartridge.
                      addressWrite(
                        addr,
                        data);
                }
                break;
            case 32768:
            case 36864:
                graphicsChip.
                  addressWrite(
                    addr -
                      32768,
                    (byte)
                      data);
                break;
            case 40960:
            case 45056:
                cartridge.
                  addressWrite(
                    addr,
                    data);
                break;
            case 49152:
                mainRam[addr -
                          49152] =
                  (byte)
                    data;
                break;
            case 53248:
                mainRam[addr -
                          53248 +
                          gbcRamBank *
                          4096] =
                  (byte)
                    data;
                break;
            case 57344:
                mainRam[addr -
                          57344] =
                  (byte)
                    data;
                break;
            case 61440:
                if (addr <
                      65024) {
                    try {
                        mainRam[addr -
                                  57344] =
                          (byte)
                            data;
                    }
                    catch (java.lang.ArrayIndexOutOfBoundsException e) {
                        java.lang.System.
                          out.
                          println(
                            "Address error: " +
                            addr +
                            " pc = " +
                            JavaBoy.
                              hexWord(
                                pc));
                    }
                }
                else
                    if (addr <
                          65280) {
                        oam[addr -
                              65024] =
                          (byte)
                            data;
                    }
                    else {
                        ioHandler.
                          ioWrite(
                            addr -
                              65280,
                            (short)
                              data);
                    }
                break;
        }
    }
    public final void addressWriteOld(int addr,
                                      int data) {
        if (addr <
              32768) {
            if (!running) {
                cartridge.
                  debuggerAddressWrite(
                    addr,
                    data);
            }
            else {
                cartridge.
                  addressWrite(
                    addr,
                    data);
            }
        }
        else
            if (addr <
                  40960) {
                try {
                    graphicsChip.
                      addressWrite(
                        addr -
                          32768,
                        (byte)
                          data);
                }
                catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    java.lang.System.
                      out.
                      println(
                        "Error address " +
                        addr);
                }
            }
            else
                if (addr <
                      49152) {
                    cartridge.
                      addressWrite(
                        addr,
                        data);
                }
                else
                    if (addr <
                          57344) {
                        mainRam[addr -
                                  49152] =
                          (byte)
                            data;
                    }
                    else
                        if (addr <
                              65024) {
                            mainRam[addr -
                                      57344] =
                              (byte)
                                data;
                        }
                        else
                            if (addr <
                                  65280) {
                                oam[addr -
                                      65024] =
                                  (byte)
                                    data;
                            }
                            else
                                if (addr <=
                                      65535) {
                                    if (addr ==
                                          65408) {
                                        
                                    }
                                    ioHandler.
                                      ioWrite(
                                        addr -
                                          65280,
                                        (short)
                                          data);
                                }
                                else {
                                    java.lang.System.
                                      out.
                                      println(
                                        "Attempt to write to address " +
                                        JavaBoy.
                                          hexWord(
                                            addr));
                                }
    }
    public boolean setRegister(java.lang.String reg,
                               int value) {
        if (reg.
              equals(
                "a") ||
              reg.
              equals(
                "acc")) {
            a =
              (short)
                value;
        }
        else
            if (reg.
                  equals(
                    "b")) {
                b =
                  (short)
                    value;
            }
            else
                if (reg.
                      equals(
                        "c")) {
                    c =
                      (short)
                        value;
                }
                else
                    if (reg.
                          equals(
                            "d")) {
                        d =
                          (short)
                            value;
                    }
                    else
                        if (reg.
                              equals(
                                "e")) {
                            e =
                              (short)
                                value;
                        }
                        else
                            if (reg.
                                  equals(
                                    "f")) {
                                f =
                                  (short)
                                    value;
                            }
                            else
                                if (reg.
                                      equals(
                                        "h")) {
                                    hl =
                                      hl &
                                        255 |
                                        value <<
                                        8;
                                }
                                else
                                    if (reg.
                                          equals(
                                            "l")) {
                                        hl =
                                          hl &
                                            65280 |
                                            value;
                                    }
                                    else
                                        if (reg.
                                              equals(
                                                "sp")) {
                                            sp =
                                              value;
                                        }
                                        else
                                            if (reg.
                                                  equals(
                                                    "pc") ||
                                                  reg.
                                                  equals(
                                                    "ip")) {
                                                pc =
                                                  value;
                                            }
                                            else
                                                if (reg.
                                                      equals(
                                                        "bc")) {
                                                    b =
                                                      (short)
                                                        (value >>
                                                           8);
                                                    c =
                                                      (short)
                                                        (value &
                                                           255);
                                                }
                                                else
                                                    if (reg.
                                                          equals(
                                                            "de")) {
                                                        d =
                                                          (short)
                                                            (value >>
                                                               8);
                                                        e =
                                                          (short)
                                                            (value &
                                                               255);
                                                    }
                                                    else
                                                        if (reg.
                                                              equals(
                                                                "hl")) {
                                                            hl =
                                                              value;
                                                        }
                                                        else {
                                                            return false;
                                                        }
        return true;
    }
    public void setBC(int value) { b = (short)
                                         ((value &
                                             65280) >>
                                            8);
                                   c = (short)
                                         (value &
                                            255);
    }
    public void setDE(int value) { d = (short)
                                         ((value &
                                             65280) >>
                                            8);
                                   e = (short)
                                         (value &
                                            255);
    }
    public void setHL(int value) { hl = value;
    }
    public final int registerRead(int regNum) {
        switch (regNum) {
            case 0:
                return b;
            case 1:
                return c;
            case 2:
                return d;
            case 3:
                return e;
            case 4:
                return (short)
                         ((hl &
                             65280) >>
                            8);
            case 5:
                return (short)
                         (hl &
                            255);
            case 6:
                return JavaBoy.
                  unsign(
                    addressRead(
                      hl));
            case 7:
                return a;
            default:
                return -1;
        }
    }
    public final void registerWrite(int regNum,
                                    int data) {
        switch (regNum) {
            case 0:
                b =
                  (short)
                    data;
                return;
            case 1:
                c =
                  (short)
                    data;
                return;
            case 2:
                d =
                  (short)
                    data;
                return;
            case 3:
                e =
                  (short)
                    data;
                return;
            case 4:
                hl =
                  hl &
                    255 |
                    data <<
                    8;
                return;
            case 5:
                hl =
                  hl &
                    65280 |
                    data;
                return;
            case 6:
                addressWrite(
                  hl,
                  data);
                return;
            case 7:
                a =
                  (short)
                    data;
                return;
            default:
                return;
        }
    }
    public void checkEnableGbc() { if ((cartridge.
                                          rom[323] &
                                          128) ==
                                         128 &&
                                         allowGbcFeatures) {
                                       gbcFeatures =
                                         true;
                                   }
                                   else {
                                       gbcFeatures =
                                         false;
                                   } }
    public void reset() { checkEnableGbc(
                            );
                          setDoubleSpeedCpu(
                            false);
                          graphicsChip.dispose(
                                         );
                          cartridge.reset(
                                      );
                          interruptsEnabled =
                            false;
                          ieDelay = -1;
                          pc = 256;
                          sp = 65534;
                          f = 176;
                          gbcRamBank = 1;
                          instrCount = 0;
                          if (gbcFeatures) {
                              a =
                                17;
                          }
                          else {
                              a =
                                1;
                          }
                          for (int r = 0;
                               r <
                                 32768;
                               r++) { mainRam[r] =
                                        0;
                          }
                          setBC(19);
                          setDE(216);
                          setHL(333);
                          JavaBoy.debugLog(
                                    "CPU reset");
                          ioHandler.reset(
                                      ); }
    public void setDoubleSpeedCpu(boolean enabled) {
        if (enabled) {
            INSTRS_PER_HBLANK =
              BASE_INSTRS_PER_HBLANK *
                2;
            INSTRS_PER_DIV =
              BASE_INSTRS_PER_DIV *
                2;
        }
        else {
            INSTRS_PER_HBLANK =
              BASE_INSTRS_PER_HBLANK;
            INSTRS_PER_DIV =
              BASE_INSTRS_PER_DIV;
        }
    }
    public final void checkInterrupts() {
        int intFlags =
          ioHandler.
            registers[15];
        int ieReg =
          ioHandler.
            registers[255];
        if ((intFlags &
               ieReg) !=
              0) {
            sp -=
              2;
            addressWrite(
              sp +
                1,
              pc >>
                8);
            addressWrite(
              sp,
              pc &
                255);
            interruptsEnabled =
              false;
            if ((intFlags &
                   ieReg &
                   INT_VBLANK) !=
                  0) {
                pc =
                  64;
                intFlags -=
                  INT_VBLANK;
            }
            else
                if ((intFlags &
                       ieReg &
                       INT_LCDC) !=
                      0) {
                    pc =
                      72;
                    intFlags -=
                      INT_LCDC;
                }
                else
                    if ((intFlags &
                           ieReg &
                           INT_TIMA) !=
                          0) {
                        pc =
                          80;
                        intFlags -=
                          INT_TIMA;
                    }
                    else
                        if ((intFlags &
                               ieReg &
                               INT_SER) !=
                              0) {
                            pc =
                              88;
                            intFlags -=
                              INT_SER;
                        }
                        else
                            if ((intFlags &
                                   ieReg &
                                   INT_P10) !=
                                  0) {
                                pc =
                                  96;
                                intFlags -=
                                  INT_P10;
                            }
            ioHandler.
              registers[15] =
              (byte)
                intFlags;
            inInterrupt =
              true;
        }
    }
    public final void triggerInterrupt(int intr) {
        ioHandler.
          registers[15] |=
          intr;
    }
    public final void triggerInterruptIfEnabled(int intr) {
        if ((ioHandler.
               registers[255] &
               (short)
                 intr) !=
              0)
            ioHandler.
              registers[15] |=
              intr;
    }
    public final void initiateInterrupts() {
        if (timaEnabled &&
              instrCount %
              instrsPerTima ==
              0) {
            if (JavaBoy.
                  unsign(
                    ioHandler.
                      registers[5]) ==
                  0) {
                ioHandler.
                  registers[5] =
                  ioHandler.
                    registers[6];
                if ((ioHandler.
                       registers[255] &
                       INT_TIMA) !=
                      0)
                    triggerInterrupt(
                      INT_TIMA);
            }
            ioHandler.
              registers[5]++;
        }
        if (instrCount %
              INSTRS_PER_DIV ==
              0) {
            ioHandler.
              registers[4]++;
        }
        if (instrCount %
              INSTRS_PER_HBLANK ==
              0) {
            int cline =
              JavaBoy.
              unsign(
                ioHandler.
                  registers[68]) +
              1;
            if (cline ==
                  152)
                cline =
                  0;
            if ((ioHandler.
                   registers[255] &
                   INT_LCDC) !=
                  0 &&
                  (ioHandler.
                     registers[65] &
                     64) !=
                  0 &&
                  JavaBoy.
                  unsign(
                    ioHandler.
                      registers[69]) ==
                  cline &&
                  (ioHandler.
                     registers[64] &
                     128) !=
                  0 &&
                  cline <
                  144) {
                triggerInterrupt(
                  INT_LCDC);
            }
            if ((ioHandler.
                   registers[255] &
                   INT_LCDC) !=
                  0 &&
                  (ioHandler.
                     registers[65] &
                     8) !=
                  0 &&
                  (ioHandler.
                     registers[64] &
                     128) !=
                  0 &&
                  cline <
                  144) {
                triggerInterrupt(
                  INT_LCDC);
            }
            if (gbcFeatures &&
                  ioHandler.
                    hdmaRunning) {
                ioHandler.
                  performHdma(
                    );
            }
            if (JavaBoy.
                  unsign(
                    ioHandler.
                      registers[68]) ==
                  143) {
                for (int r =
                       144;
                     r <
                       170;
                     r++) {
                    graphicsChip.
                      notifyScanline(
                        r);
                }
                if ((ioHandler.
                       registers[64] &
                       128) !=
                      0 &&
                      (ioHandler.
                         registers[255] &
                         INT_VBLANK) !=
                      0) {
                    triggerInterrupt(
                      INT_VBLANK);
                    if ((ioHandler.
                           registers[65] &
                           16) !=
                          0 &&
                          (ioHandler.
                             registers[255] &
                             INT_LCDC) !=
                          0) {
                        triggerInterrupt(
                          INT_LCDC);
                    }
                }
                boolean speedThrottle =
                  true;
                if (!JavaBoy.
                       runningAsApplet) {
                    GameBoyScreen g =
                      (GameBoyScreen)
                        applet;
                    speedThrottle =
                      g.
                        viewSpeedThrottle.
                        getState(
                          );
                }
                if (speedThrottle &&
                      graphicsChip.
                        frameWaitTime >=
                      0) {
                    try {
                        java.lang.Thread.
                          sleep(
                            graphicsChip.
                              frameWaitTime);
                    }
                    catch (java.lang.InterruptedException e) {
                        
                    }
                }
            }
            graphicsChip.
              notifyScanline(
                JavaBoy.
                  unsign(
                    ioHandler.
                      registers[68]));
            ioHandler.
              registers[68] =
              (byte)
                (JavaBoy.
                   unsign(
                     ioHandler.
                       registers[68]) +
                   1);
            if (JavaBoy.
                  unsign(
                    ioHandler.
                      registers[68]) >=
                  153) {
                ioHandler.
                  registers[68] =
                  0;
                if (soundChip !=
                      null)
                    soundChip.
                      outputSound(
                        );
                graphicsChip.
                  frameDone =
                  false;
                if (JavaBoy.
                      runningAsApplet) {
                    ((JavaBoy)
                       applet).
                      drawNextFrame(
                        );
                }
                else {
                    ((GameBoyScreen)
                       applet).
                      repaint(
                        );
                }
                try {
                    while (!graphicsChip.
                              frameDone) {
                        java.lang.Thread.
                          sleep(
                            1);
                    }
                }
                catch (java.lang.InterruptedException e) {
                    
                }
            }
        }
    }
    public final void execute(int numInstr) {
        terminate =
          false;
        short newf;
        int dat;
        running =
          true;
        graphicsChip.
          startTime =
          java.lang.System.
            currentTimeMillis(
              );
        int b1;
        int b2;
        int b3;
        int offset;
        for (int r =
               0;
             r !=
               numInstr &&
               !terminate;
             r++) {
            instrCount++;
            b1 =
              JavaBoy.
                unsign(
                  addressRead(
                    pc));
            offset =
              addressRead(
                pc +
                  1);
            b3 =
              JavaBoy.
                unsign(
                  addressRead(
                    pc +
                      2));
            b2 =
              JavaBoy.
                unsign(
                  (short)
                    offset);
            switch (b1) {
                case 0:
                    pc++;
                    break;
                case 1:
                    pc +=
                      3;
                    b =
                      b3;
                    c =
                      b2;
                    break;
                case 2:
                    pc++;
                    addressWrite(
                      b <<
                        8 |
                        c,
                      a);
                    break;
                case 3:
                    pc++;
                    c++;
                    if (c ==
                          256) {
                        b++;
                        c =
                          0;
                        if (b ==
                              256) {
                            b =
                              0;
                        }
                    }
                    break;
                case 4:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (b) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            b =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            b =
                              16;
                            break;
                        default:
                            b++;
                            break;
                    }
                    break;
                case 5:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (b) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            b =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            b =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            b =
                              0;
                            break;
                        default:
                            b--;
                            break;
                    }
                    break;
                case 6:
                    pc +=
                      2;
                    b =
                      b2;
                    break;
                case 7:
                    pc++;
                    f =
                      0;
                    a <<=
                      1;
                    if ((a &
                           256) !=
                          0) {
                        f |=
                          F_CARRY;
                        a |=
                          1;
                        a &=
                          255;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 8:
                    pc +=
                      3;
                    addressWrite(
                      (b3 <<
                         8) +
                        b2 +
                        1,
                      (sp &
                         65280) >>
                        8);
                    addressWrite(
                      (b3 <<
                         8) +
                        b2,
                      sp &
                        255);
                    break;
                case 9:
                    pc++;
                    hl =
                      hl +
                        ((b <<
                            8) +
                           c);
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 10:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            (b <<
                               8) +
                              c));
                    break;
                case 11:
                    pc++;
                    c--;
                    if ((c &
                           65280) !=
                          0) {
                        c =
                          255;
                        b--;
                        if ((b &
                               65280) !=
                              0) {
                            b =
                              255;
                        }
                    }
                    break;
                case 12:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (c) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            c =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            c =
                              16;
                            break;
                        default:
                            c++;
                            break;
                    }
                    break;
                case 13:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (c) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            c =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            c =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            c =
                              0;
                            break;
                        default:
                            c--;
                            break;
                    }
                    break;
                case 14:
                    pc +=
                      2;
                    c =
                      b2;
                    break;
                case 15:
                    pc++;
                    if ((a &
                           1) ==
                          1) {
                        f =
                          F_CARRY;
                    }
                    else {
                        f =
                          0;
                    }
                    a >>=
                      1;
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        a |=
                          128;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 16:
                    pc +=
                      2;
                    if (gbcFeatures) {
                        if ((ioHandler.
                               registers[77] &
                               1) ==
                              1) {
                            int newKey1Reg =
                              ioHandler.
                                registers[77] &
                              254;
                            if ((newKey1Reg &
                                   128) ==
                                  128) {
                                setDoubleSpeedCpu(
                                  false);
                                newKey1Reg &=
                                  127;
                            }
                            else {
                                setDoubleSpeedCpu(
                                  true);
                                newKey1Reg |=
                                  128;
                            }
                            ioHandler.
                              registers[77] =
                              (byte)
                                newKey1Reg;
                        }
                    }
                    break;
                case 17:
                    pc +=
                      3;
                    d =
                      b3;
                    e =
                      b2;
                    break;
                case 18:
                    pc++;
                    addressWrite(
                      (d <<
                         8) +
                        e,
                      a);
                    break;
                case 19:
                    pc++;
                    e++;
                    if (e ==
                          256) {
                        d++;
                        e =
                          0;
                        if (d ==
                              256) {
                            d =
                              0;
                        }
                    }
                    break;
                case 20:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (d) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            d =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            d =
                              16;
                            break;
                        default:
                            d++;
                            break;
                    }
                    break;
                case 21:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (d) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            d =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            d =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            d =
                              0;
                            break;
                        default:
                            d--;
                            break;
                    }
                    break;
                case 22:
                    pc +=
                      2;
                    d =
                      b2;
                    break;
                case 23:
                    pc++;
                    if ((a &
                           128) ==
                          128) {
                        newf =
                          F_CARRY;
                    }
                    else {
                        newf =
                          0;
                    }
                    a <<=
                      1;
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        a |=
                          1;
                    }
                    a &=
                      255;
                    if (a ==
                          0) {
                        newf |=
                          F_ZERO;
                    }
                    f =
                      newf;
                    break;
                case 24:
                    pc +=
                      2 +
                        offset;
                    break;
                case 25:
                    pc++;
                    hl =
                      hl +
                        ((d <<
                            8) +
                           e);
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 26:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            (d <<
                               8) +
                              e));
                    break;
                case 27:
                    pc++;
                    e--;
                    if ((e &
                           65280) !=
                          0) {
                        e =
                          255;
                        d--;
                        if ((d &
                               65280) !=
                              0) {
                            d =
                              255;
                        }
                    }
                    break;
                case 28:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (e) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            e =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            e =
                              16;
                            break;
                        default:
                            e++;
                            break;
                    }
                    break;
                case 29:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (e) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            e =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            e =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            e =
                              0;
                            break;
                        default:
                            e--;
                            break;
                    }
                    break;
                case 30:
                    pc +=
                      2;
                    e =
                      b2;
                    break;
                case 31:
                    pc++;
                    if ((a &
                           1) ==
                          1) {
                        newf =
                          F_CARRY;
                    }
                    else {
                        newf =
                          0;
                    }
                    a >>=
                      1;
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        a |=
                          128;
                    }
                    if (a ==
                          0) {
                        newf |=
                          F_ZERO;
                    }
                    f =
                      newf;
                    break;
                case 32:
                    if ((f &
                           128) ==
                          0) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 33:
                    pc +=
                      3;
                    hl =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 34:
                    pc++;
                    addressWrite(
                      hl,
                      a);
                    hl =
                      hl +
                        1 &
                        65535;
                    break;
                case 35:
                    pc++;
                    hl =
                      hl +
                        1 &
                        65535;
                    break;
                case 36:
                    pc++;
                    f &=
                      F_CARRY;
                    switch ((hl &
                               65280) >>
                              8) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            hl =
                              hl &
                                255;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                255 |
                                16;
                            break;
                        default:
                            hl =
                              hl +
                                256;
                            break;
                    }
                    break;
                case 37:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch ((hl &
                               65280) >>
                              8) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                255 |
                                65280;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                255 |
                                3840;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            hl =
                              hl &
                                255;
                            break;
                        default:
                            hl =
                              hl &
                                255 |
                                (hl &
                                   65280) -
                                256;
                            break;
                    }
                    break;
                case 38:
                    pc +=
                      2;
                    hl =
                      hl &
                        255 |
                        b2 <<
                        8;
                    break;
                case 39:
                    pc++;
                    int upperNibble =
                      (a &
                         240) >>
                      4;
                    int lowerNibble =
                      a &
                      15;
                    newf =
                      (short)
                        (f &
                           F_SUBTRACT);
                    if ((f &
                           F_SUBTRACT) ==
                          0) {
                        if ((f &
                               F_CARRY) ==
                              0) {
                            if (upperNibble <=
                                  8 &&
                                  lowerNibble >=
                                  10 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  6;
                            }
                            if (upperNibble <=
                                  9 &&
                                  lowerNibble <=
                                  3 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  6;
                            }
                            if (upperNibble >=
                                  10 &&
                                  lowerNibble <=
                                  9 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  96;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble >=
                                  9 &&
                                  lowerNibble >=
                                  10 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble >=
                                  10 &&
                                  lowerNibble <=
                                  3 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                        }
                        else {
                            if (upperNibble <=
                                  2 &&
                                  lowerNibble <=
                                  9 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  96;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble <=
                                  2 &&
                                  lowerNibble >=
                                  10 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble <=
                                  3 &&
                                  lowerNibble <=
                                  3 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                        }
                    }
                    else {
                        if ((f &
                               F_CARRY) ==
                              0) {
                            if (upperNibble <=
                                  8 &&
                                  lowerNibble >=
                                  6 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  250;
                            }
                        }
                        else {
                            if (upperNibble >=
                                  7 &&
                                  lowerNibble <=
                                  9 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  160;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble >=
                                  6 &&
                                  lowerNibble >=
                                  6 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  154;
                                newf |=
                                  F_CARRY;
                            }
                        }
                    }
                    a &=
                      255;
                    if (a ==
                          0)
                        newf |=
                          F_ZERO;
                    f =
                      newf;
                    break;
                case 40:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 41:
                    pc++;
                    hl =
                      hl +
                        hl;
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 42:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    hl++;
                    break;
                case 43:
                    pc++;
                    if (hl ==
                          0) {
                        hl =
                          65535;
                    }
                    else {
                        hl--;
                    }
                    break;
                case 44:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (hl &
                              255) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            hl =
                              hl &
                                65280;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            hl++;
                            break;
                        default:
                            hl++;
                            break;
                    }
                    break;
                case 45:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (hl &
                              255) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                65280 |
                                255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                65280 |
                                15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            hl =
                              hl &
                                65280;
                            break;
                        default:
                            hl =
                              hl &
                                65280 |
                                (hl &
                                   255) -
                                1;
                            break;
                    }
                    break;
                case 46:
                    pc +=
                      2;
                    hl =
                      hl &
                        65280 |
                        b2;
                    break;
                case 47:
                    pc++;
                    short mask =
                      128;
                    a =
                      (short)
                        (~a &
                           255);
                    f =
                      (short)
                        (f &
                           (F_CARRY |
                              F_ZERO) |
                           F_SUBTRACT |
                           F_HALFCARRY);
                    break;
                case 48:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 49:
                    pc +=
                      3;
                    sp =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 50:
                    pc++;
                    addressWrite(
                      hl,
                      a);
                    hl--;
                    break;
                case 51:
                    pc++;
                    sp =
                      sp +
                        1 &
                        65535;
                    break;
                case 52:
                    pc++;
                    f &=
                      F_CARRY;
                    dat =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    switch (dat) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            addressWrite(
                              hl,
                              0);
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            addressWrite(
                              hl,
                              16);
                            break;
                        default:
                            addressWrite(
                              hl,
                              dat +
                                1);
                            break;
                    }
                    break;
                case 53:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    dat =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    switch (dat) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            addressWrite(
                              hl,
                              255);
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            addressWrite(
                              hl,
                              15);
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            addressWrite(
                              hl,
                              0);
                            break;
                        default:
                            addressWrite(
                              hl,
                              dat -
                                1);
                            break;
                    }
                    break;
                case 54:
                    pc +=
                      2;
                    addressWrite(
                      hl,
                      b2);
                    break;
                case 55:
                    pc++;
                    f &=
                      F_ZERO;
                    f |=
                      F_CARRY;
                    break;
                case 56:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 57:
                    pc++;
                    hl =
                      hl +
                        sp;
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 58:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    hl =
                      hl -
                        1 &
                        65535;
                    break;
                case 59:
                    pc++;
                    sp =
                      sp -
                        1 &
                        65535;
                    break;
                case 60:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (a) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            a =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            a =
                              16;
                            break;
                        default:
                            a++;
                            break;
                    }
                    break;
                case 61:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (a) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            a =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            a =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            a =
                              0;
                            break;
                        default:
                            a--;
                            break;
                    }
                    break;
                case 62:
                    pc +=
                      2;
                    a =
                      b2;
                    break;
                case 63:
                    pc++;
                    if ((f &
                           F_CARRY) ==
                          0) {
                        f =
                          (short)
                            (f &
                               F_ZERO |
                               F_CARRY);
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_ZERO);
                    }
                    break;
                case 82:
                    if (breakpointEnable) {
                        terminate =
                          true;
                        java.lang.System.
                          out.
                          println(
                            "- Breakpoint reached");
                    }
                    else {
                        pc++;
                    }
                    break;
                case 118:
                    interruptsEnabled =
                      true;
                    while (ioHandler.
                             registers[15] ==
                             0) {
                        initiateInterrupts(
                          );
                        instrCount++;
                    }
                    pc++;
                    break;
                case 175:
                    pc++;
                    a =
                      0;
                    f =
                      128;
                    break;
                case 192:
                    if ((f &
                           F_ZERO) ==
                          0) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 193:
                    pc++;
                    c =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    b =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp +
                              1));
                    sp +=
                      2;
                    break;
                case 194:
                    if ((f &
                           F_ZERO) ==
                          0) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 195:
                    pc =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 196:
                    if ((f &
                           F_ZERO) ==
                          0) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 197:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp,
                      c);
                    addressWrite(
                      sp +
                        1,
                      b);
                    break;
                case 198:
                    pc +=
                      2;
                    f =
                      0;
                    if (((a &
                            15) +
                           (b2 &
                              15) &
                           240) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a +=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        if (a ==
                              256) {
                            f |=
                              F_ZERO +
                                F_CARRY +
                                F_HALFCARRY;
                            a =
                              0;
                        }
                        else {
                            f |=
                              F_CARRY +
                                F_HALFCARRY;
                            a &=
                              255;
                        }
                    }
                    break;
                case 207:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      8;
                    break;
                case 200:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 201:
                    pc =
                      (JavaBoy.
                         unsign(
                           addressRead(
                             sp +
                               1)) <<
                         8) +
                        JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    sp +=
                      2;
                    break;
                case 202:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 203:
                    pc +=
                      2;
                    int regNum =
                      b2 &
                      7;
                    int data =
                      registerRead(
                        regNum);
                    if ((b2 &
                           192) ==
                          0) {
                        switch (b2 &
                                  248) {
                            case 0:
                                if ((data &
                                       128) ==
                                      128) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data <<=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      1;
                                }
                                data &=
                                  255;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 8:
                                if ((data &
                                       1) ==
                                      1) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data >>=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      128;
                                }
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 16:
                                if ((data &
                                       128) ==
                                      128) {
                                    newf =
                                      F_CARRY;
                                }
                                else {
                                    newf =
                                      0;
                                }
                                data <<=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      1;
                                }
                                data &=
                                  255;
                                if (data ==
                                      0) {
                                    newf |=
                                      F_ZERO;
                                }
                                f =
                                  newf;
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 24:
                                if ((data &
                                       1) ==
                                      1) {
                                    newf =
                                      F_CARRY;
                                }
                                else {
                                    newf =
                                      0;
                                }
                                data >>=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      128;
                                }
                                if (data ==
                                      0) {
                                    newf |=
                                      F_ZERO;
                                }
                                f =
                                  newf;
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 32:
                                if ((data &
                                       128) ==
                                      128) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data <<=
                                  1;
                                data &=
                                  255;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 40:
                                short topBit =
                                  0;
                                topBit =
                                  (short)
                                    (data &
                                       128);
                                if ((data &
                                       1) ==
                                      1) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data >>=
                                  1;
                                data |=
                                  topBit;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 48:
                                data =
                                  (short)
                                    ((data &
                                        15) <<
                                       4 |
                                       (data &
                                          240) >>
                                       4);
                                if (data ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 56:
                                if ((data &
                                       1) ==
                                      1) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data >>=
                                  1;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                        }
                    }
                    else {
                        int bitNumber =
                          (b2 &
                             56) >>
                          3;
                        if ((b2 &
                               192) ==
                              64) {
                            mask =
                              (short)
                                (1 <<
                                   bitNumber);
                            if ((data &
                                   mask) !=
                                  0) {
                                f =
                                  (short)
                                    (f &
                                       F_CARRY |
                                       F_HALFCARRY);
                            }
                            else {
                                f =
                                  (short)
                                    (f &
                                       F_CARRY |
                                       F_HALFCARRY +
                                       F_ZERO);
                            }
                        }
                        if ((b2 &
                               192) ==
                              128) {
                            mask =
                              (short)
                                (255 -
                                   (1 <<
                                      bitNumber));
                            data =
                              (short)
                                (data &
                                   mask);
                            registerWrite(
                              regNum,
                              data);
                        }
                        if ((b2 &
                               192) ==
                              192) {
                            mask =
                              (short)
                                (1 <<
                                   bitNumber);
                            data =
                              (short)
                                (data |
                                   mask);
                            registerWrite(
                              regNum,
                              data);
                        }
                    }
                    break;
                case 204:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 205:
                    pc +=
                      3;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 206:
                    pc +=
                      2;
                    if ((f &
                           F_CARRY) !=
                          0) {
                        b2++;
                    }
                    f =
                      0;
                    if (((a &
                            15) +
                           (b2 &
                              15) &
                           240) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a +=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        if (a ==
                              256) {
                            f |=
                              F_ZERO +
                                F_CARRY +
                                F_HALFCARRY;
                            a =
                              0;
                        }
                        else {
                            f |=
                              F_CARRY +
                                F_HALFCARRY;
                            a &=
                              255;
                        }
                    }
                    break;
                case 199:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      0;
                    break;
                case 208:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 209:
                    pc++;
                    e =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    d =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp +
                              1));
                    sp +=
                      2;
                    break;
                case 210:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 212:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 213:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp,
                      e);
                    addressWrite(
                      sp +
                        1,
                      d);
                    break;
                case 214:
                    pc +=
                      2;
                    f =
                      F_SUBTRACT;
                    if (((a &
                            15) -
                           (b2 &
                              15) &
                           65520) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a -=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        a &=
                          255;
                        f |=
                          F_CARRY;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 215:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      16;
                    break;
                case 216:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 217:
                    interruptsEnabled =
                      true;
                    inInterrupt =
                      false;
                    pc =
                      (JavaBoy.
                         unsign(
                           addressRead(
                             sp +
                               1)) <<
                         8) +
                        JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    sp +=
                      2;
                    break;
                case 218:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 220:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 222:
                    pc +=
                      2;
                    if ((f &
                           F_CARRY) !=
                          0) {
                        b2++;
                    }
                    f =
                      F_SUBTRACT;
                    if (((a &
                            15) -
                           (b2 &
                              15) &
                           65520) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a -=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        a &=
                          255;
                        f |=
                          F_CARRY;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 223:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      24;
                    break;
                case 224:
                    pc +=
                      2;
                    addressWrite(
                      65280 +
                        b2,
                      a);
                    break;
                case 225:
                    pc++;
                    hl =
                      (JavaBoy.
                         unsign(
                           addressRead(
                             sp +
                               1)) <<
                         8) +
                        JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    sp +=
                      2;
                    break;
                case 226:
                    pc++;
                    addressWrite(
                      65280 +
                        c,
                      a);
                    break;
                case 229:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp +
                        1,
                      hl >>
                        8);
                    addressWrite(
                      sp,
                      hl &
                        255);
                    break;
                case 230:
                    pc +=
                      2;
                    a &=
                      b2;
                    if (a ==
                          0) {
                        f =
                          F_ZERO;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 231:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      32;
                    break;
                case 232:
                    pc +=
                      2;
                    sp =
                      sp +
                        offset;
                    if ((sp &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        sp &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 233:
                    pc++;
                    pc =
                      hl;
                    break;
                case 234:
                    pc +=
                      3;
                    addressWrite(
                      (b3 <<
                         8) +
                        b2,
                      a);
                    break;
                case 238:
                    pc +=
                      2;
                    a ^=
                      b2;
                    if (a ==
                          0) {
                        f =
                          F_ZERO;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 239:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      40;
                    break;
                case 240:
                    pc +=
                      2;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            65280 +
                              b2));
                    break;
                case 241:
                    pc++;
                    f =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp +
                              1));
                    sp +=
                      2;
                    break;
                case 242:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            65280 +
                              c));
                    break;
                case 243:
                    pc++;
                    interruptsEnabled =
                      false;
                    break;
                case 245:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp,
                      f);
                    addressWrite(
                      sp +
                        1,
                      a);
                    break;
                case 246:
                    pc +=
                      2;
                    a |=
                      b2;
                    if (a ==
                          0) {
                        f =
                          F_ZERO;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 247:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      48;
                    break;
                case 248:
                    pc +=
                      2;
                    hl =
                      sp +
                        offset;
                    if ((hl &
                           65536) !=
                          0) {
                        f =
                          F_CARRY;
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 249:
                    pc++;
                    sp =
                      hl;
                    break;
                case 250:
                    pc +=
                      3;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            (b3 <<
                               8) +
                              b2));
                    break;
                case 251:
                    pc++;
                    ieDelay =
                      1;
                    break;
                case 254:
                    pc +=
                      2;
                    f =
                      0;
                    if (b2 ==
                          a) {
                        f |=
                          F_ZERO;
                    }
                    else {
                        if (a <
                              b2) {
                            f |=
                              F_CARRY;
                        }
                    }
                    break;
                case 255:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      56;
                    break;
                default:
                    if ((b1 &
                           192) ==
                          128) {
                        pc++;
                        int operand =
                          registerRead(
                            b1 &
                              7);
                        switch ((b1 &
                                   56) >>
                                  3) {
                            case 1:
                                if ((f &
                                       F_CARRY) !=
                                      0) {
                                    operand++;
                                }
                            case 0:
                                f =
                                  0;
                                if (((a &
                                        15) +
                                       (operand &
                                          15) &
                                       240) !=
                                      0) {
                                    f |=
                                      F_HALFCARRY;
                                }
                                a +=
                                  operand;
                                if (a ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                if ((a &
                                       65280) !=
                                      0) {
                                    if (a ==
                                          256) {
                                        f |=
                                          F_ZERO +
                                            F_CARRY +
                                            F_HALFCARRY;
                                        a =
                                          0;
                                    }
                                    else {
                                        f |=
                                          F_CARRY +
                                            F_HALFCARRY;
                                        a &=
                                          255;
                                    }
                                }
                                break;
                            case 3:
                                if ((f &
                                       F_CARRY) !=
                                      0) {
                                    operand++;
                                }
                            case 2:
                                f =
                                  F_SUBTRACT;
                                if (((a &
                                        15) -
                                       (operand &
                                          15) &
                                       65520) !=
                                      0) {
                                    f |=
                                      F_HALFCARRY;
                                }
                                a -=
                                  operand;
                                if ((a &
                                       65280) !=
                                      0) {
                                    a &=
                                      255;
                                    f |=
                                      F_CARRY;
                                }
                                if (a ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                break;
                            case 4:
                                a &=
                                  operand;
                                if (a ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                break;
                            case 5:
                                a ^=
                                  operand;
                                if (a ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                break;
                            case 6:
                                a |=
                                  operand;
                                if (a ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                break;
                            case 7:
                                f =
                                  F_SUBTRACT;
                                if (a ==
                                      operand) {
                                    f |=
                                      F_ZERO;
                                }
                                if (a <
                                      operand) {
                                    f |=
                                      F_CARRY;
                                }
                                if ((a &
                                       15) <
                                      (operand &
                                         15)) {
                                    f |=
                                      F_HALFCARRY;
                                }
                                break;
                        }
                    }
                    else
                        if ((b1 &
                               192) ==
                              64) {
                            pc++;
                            registerWrite(
                              (b1 &
                                 56) >>
                                3,
                              registerRead(
                                b1 &
                                  7));
                        }
                        else {
                            java.lang.System.
                              out.
                              println(
                                "Unrecognized opcode (" +
                                JavaBoy.
                                  hexByte(
                                    b1) +
                                ")");
                            terminate =
                              true;
                            pc++;
                            break;
                        }
            }
            if (ieDelay !=
                  -1) {
                if (ieDelay >
                      0) {
                    ieDelay--;
                }
                else {
                    interruptsEnabled =
                      true;
                    ieDelay =
                      -1;
                }
            }
            if (interruptsEnabled) {
                checkInterrupts(
                  );
            }
            cartridge.
              update(
                );
            initiateInterrupts(
              );
        }
        running =
          false;
        terminate =
          false;
    }
    public void setBreakpoint(boolean on) {
        breakpointEnable =
          on;
    }
    public java.lang.String disassemble(int address,
                                        int numInstr) {
        java.lang.System.
          out.
          println(
            "Addr  Data      Instruction");
        for (int r =
               0;
             r <
               numInstr;
             r++) {
            short b1 =
              JavaBoy.
              unsign(
                addressRead(
                  address));
            short offset =
              addressRead(
                address +
                  1);
            short b3 =
              JavaBoy.
              unsign(
                addressRead(
                  address +
                    2));
            short b2 =
              JavaBoy.
              unsign(
                offset);
            java.lang.String instr =
              new java.lang.String(
              "Unknown Opcode! (" +
              java.lang.Integer.
                toHexString(
                  JavaBoy.
                    unsign(
                      b1)) +
              ")");
            byte instrLength =
              1;
            switch (b1) {
                case 0:
                    instr =
                      "NOP";
                    break;
                case 1:
                    instr =
                      "LD BC, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 2:
                    instr =
                      "LD (BC), A";
                    break;
                case 3:
                    instr =
                      "INC BC";
                    break;
                case 4:
                    instr =
                      "INC B";
                    break;
                case 5:
                    instr =
                      "DEC B";
                    break;
                case 6:
                    instr =
                      "LD B, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 7:
                    instr =
                      "RLC A";
                    break;
                case 8:
                    instr =
                      "LD (" +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2) +
                      "), SP";
                    instrLength =
                      3;
                    break;
                case 9:
                    instr =
                      "ADD HL, BC";
                    break;
                case 10:
                    instr =
                      "LD A, (BC)";
                    break;
                case 11:
                    instr =
                      "DEC BC";
                    break;
                case 12:
                    instr =
                      "INC C";
                    break;
                case 13:
                    instr =
                      "DEC C";
                    break;
                case 14:
                    instr =
                      "LD C, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 15:
                    instr =
                      "RRC A";
                    break;
                case 16:
                    instr =
                      "STOP";
                    instrLength =
                      2;
                    break;
                case 17:
                    instr =
                      "LD DE, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 18:
                    instr =
                      "LD (DE), A";
                    break;
                case 19:
                    instr =
                      "INC DE";
                    break;
                case 20:
                    instr =
                      "INC D";
                    break;
                case 21:
                    instr =
                      "DEC D";
                    break;
                case 22:
                    instr =
                      "LD D, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 23:
                    instr =
                      "RL A";
                    break;
                case 24:
                    instr =
                      "JR " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 25:
                    instr =
                      "ADD HL, DE";
                    break;
                case 26:
                    instr =
                      "LD A, (DE)";
                    break;
                case 27:
                    instr =
                      "DEC DE";
                    break;
                case 28:
                    instr =
                      "INC E";
                    break;
                case 29:
                    instr =
                      "DEC E";
                    break;
                case 30:
                    instr =
                      "LD E, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 31:
                    instr =
                      "RR A";
                    break;
                case 32:
                    instr =
                      "JR NZ, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset) +
                      ": " +
                      offset;
                    instrLength =
                      2;
                    break;
                case 33:
                    instr =
                      "LD HL, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 34:
                    instr =
                      "LD (HL+), A";
                    break;
                case 35:
                    instr =
                      "INC HL";
                    break;
                case 36:
                    instr =
                      "INC H";
                    break;
                case 37:
                    instr =
                      "DEC H";
                    break;
                case 38:
                    instr =
                      "LD H, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 39:
                    instr =
                      "DAA";
                    break;
                case 40:
                    instr =
                      "JR Z, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 41:
                    instr =
                      "ADD HL, HL";
                    break;
                case 42:
                    instr =
                      "LDI A, (HL)";
                    break;
                case 43:
                    instr =
                      "DEC HL";
                    break;
                case 44:
                    instr =
                      "INC L";
                    break;
                case 45:
                    instr =
                      "DEC L";
                    break;
                case 46:
                    instr =
                      "LD L, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 47:
                    instr =
                      "CPL";
                    break;
                case 48:
                    instr =
                      "JR NC, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 49:
                    instr =
                      "LD SP, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 50:
                    instr =
                      "LD (HL-), A";
                    break;
                case 51:
                    instr =
                      "INC SP";
                    break;
                case 52:
                    instr =
                      "INC (HL)";
                    break;
                case 53:
                    instr =
                      "DEC (HL)";
                    break;
                case 54:
                    instr =
                      "LD (HL), " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 55:
                    instr =
                      "SCF";
                    break;
                case 56:
                    instr =
                      "JR C, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 57:
                    instr =
                      "ADD HL, SP";
                    break;
                case 58:
                    instr =
                      "LD A, (HL-)";
                    break;
                case 59:
                    instr =
                      "DEC SP";
                    break;
                case 60:
                    instr =
                      "INC A";
                    break;
                case 61:
                    instr =
                      "DEC A";
                    break;
                case 62:
                    instr =
                      "LD A, " +
                      JavaBoy.
                        hexByte(
                          JavaBoy.
                            unsign(
                              b2));
                    instrLength =
                      2;
                    break;
                case 63:
                    instr =
                      "CCF";
                    break;
                case 118:
                    instr =
                      "HALT";
                    break;
                case 192:
                    instr =
                      "RET NZ";
                    break;
                case 193:
                    instr =
                      "POP BC";
                    break;
                case 194:
                    instr =
                      "JP NZ, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 195:
                    instr =
                      "JP " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 196:
                    instr =
                      "CALL NZ, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 197:
                    instr =
                      "PUSH BC";
                    break;
                case 198:
                    instr =
                      "ADD A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 199:
                    instr =
                      "RST 00";
                    break;
                case 200:
                    instr =
                      "RET Z";
                    break;
                case 201:
                    instr =
                      "RET";
                    break;
                case 202:
                    instr =
                      "JP Z, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 204:
                    instr =
                      "CALL Z, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 205:
                    instr =
                      "CALL " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 206:
                    instr =
                      "ADC A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 207:
                    instr =
                      "RST 08";
                    break;
                case 208:
                    instr =
                      "RET NC";
                    break;
                case 209:
                    instr =
                      "POP DE";
                    break;
                case 210:
                    instr =
                      "JP NC, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 212:
                    instr =
                      "CALL NC, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 213:
                    instr =
                      "PUSH DE";
                    break;
                case 214:
                    instr =
                      "SUB A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 215:
                    instr =
                      "RST 10";
                    break;
                case 216:
                    instr =
                      "RET C";
                    break;
                case 217:
                    instr =
                      "RETI";
                    break;
                case 218:
                    instr =
                      "JP C, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 220:
                    instr =
                      "CALL C, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 222:
                    instr =
                      "SBC A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 223:
                    instr =
                      "RST 18";
                    break;
                case 224:
                    instr =
                      "LDH (FF" +
                      JavaBoy.
                        hexByte(
                          b2 &
                            255) +
                      "), A";
                    instrLength =
                      2;
                    break;
                case 225:
                    instr =
                      "POP HL";
                    break;
                case 226:
                    instr =
                      "LDH (FF00 + C), A";
                    break;
                case 229:
                    instr =
                      "PUSH HL";
                    break;
                case 230:
                    instr =
                      "AND " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 231:
                    instr =
                      "RST 20";
                    break;
                case 232:
                    instr =
                      "ADD SP, " +
                      JavaBoy.
                        hexByte(
                          offset);
                    instrLength =
                      2;
                    break;
                case 233:
                    instr =
                      "JP (HL)";
                    break;
                case 234:
                    instr =
                      "LD (" +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2) +
                      "), A";
                    instrLength =
                      3;
                    break;
                case 238:
                    instr =
                      "XOR " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 239:
                    instr =
                      "RST 28";
                    break;
                case 240:
                    instr =
                      "LDH A, (FF" +
                      JavaBoy.
                        hexByte(
                          b2) +
                      ")";
                    instrLength =
                      2;
                    break;
                case 241:
                    instr =
                      "POP AF";
                    break;
                case 242:
                    instr =
                      "LD A, (FF00 + C)";
                    break;
                case 243:
                    instr =
                      "DI";
                    break;
                case 245:
                    instr =
                      "PUSH AF";
                    break;
                case 246:
                    instr =
                      "OR " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 247:
                    instr =
                      "RST 30";
                    break;
                case 248:
                    instr =
                      "LD HL, SP + " +
                      JavaBoy.
                        hexByte(
                          offset);
                    instrLength =
                      2;
                    break;
                case 249:
                    instr =
                      "LD SP, HL";
                    break;
                case 250:
                    instr =
                      "LD A, (" +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2) +
                      ")";
                    instrLength =
                      3;
                    break;
                case 251:
                    instr =
                      "EI";
                    break;
                case 254:
                    instr =
                      "CP " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 255:
                    instr =
                      "RST 38";
                    break;
            }
            if (JavaBoy.
                  unsign(
                    b1) >=
                  64 &&
                  JavaBoy.
                  unsign(
                    b1) <=
                  127 &&
                  JavaBoy.
                  unsign(
                    b1) !=
                  118) {
                int sourceRegister =
                  b1 &
                  7;
                int destRegister =
                  (b1 &
                     56) >>
                  3;
                instr =
                  "LD " +
                  registerNames[destRegister] +
                  ", " +
                  registerNames[sourceRegister];
            }
            if (JavaBoy.
                  unsign(
                    b1) >=
                  128 &&
                  JavaBoy.
                  unsign(
                    b1) <=
                  191) {
                int sourceRegister =
                  JavaBoy.
                  unsign(
                    b1) &
                  7;
                int operation =
                  (JavaBoy.
                     unsign(
                       b1) &
                     56) >>
                  3;
                instr =
                  aluOperations[operation] +
                  " A, " +
                  registerNames[sourceRegister];
            }
            if (JavaBoy.
                  unsign(
                    b1) ==
                  203) {
                int operation;
                int sourceRegister;
                int bitNumber;
                instrLength =
                  2;
                switch ((JavaBoy.
                           unsign(
                             b2) &
                           192) >>
                          6) {
                    case 0:
                        operation =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          shiftOperations[operation] +
                          " " +
                          registerNames[sourceRegister];
                        break;
                    case 1:
                        bitNumber =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          "BIT " +
                          bitNumber +
                          ", " +
                          registerNames[sourceRegister];
                        break;
                    case 2:
                        bitNumber =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          "RES " +
                          bitNumber +
                          ", " +
                          registerNames[sourceRegister];
                        break;
                    case 3:
                        bitNumber =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          "SET " +
                          bitNumber +
                          ", " +
                          registerNames[sourceRegister];
                        break;
                }
            }
            java.lang.System.
              out.
              print(
                JavaBoy.
                  hexWord(
                    address) +
                ": " +
                JavaBoy.
                  hexByte(
                    JavaBoy.
                      unsign(
                        b1)));
            if (instrLength >=
                  2) {
                java.lang.System.
                  out.
                  print(
                    " " +
                    JavaBoy.
                      hexByte(
                        JavaBoy.
                          unsign(
                            b2)));
            }
            else {
                java.lang.System.
                  out.
                  print(
                    "   ");
            }
            if (instrLength ==
                  3) {
                java.lang.System.
                  out.
                  print(
                    " " +
                    JavaBoy.
                      hexByte(
                        JavaBoy.
                          unsign(
                            b3)) +
                    "  ");
            }
            else {
                java.lang.System.
                  out.
                  print(
                    "     ");
            }
            java.lang.System.
              out.
              println(
                instr);
            address +=
              instrLength;
        }
        return null;
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
      ("H4sIAAAAAAAAALV8e7DjWHmn751HzwzDdM8AAwzM0DADDJi0LFu27AyQsSTb" +
       "ki1btmT5IR4dvWzJej8ti8zyKMiQkAxUMrAsm0D+IMkuIZBKJZVUJaHYDdlA" +
       "SLFJKpVN9gEktbUhm2QDtbtJNuwme2T7Pvr2ffTt6blV51xZOufo9/vO933n" +
       "O+dI+uxf5+4I/FzedczV3HTCK2oSXlmY5SvhylWDK2263Bf9QFVwUwyCITh3" +
       "VX7NL1z82+9+RLu0m7tTyL1ItG0nFEPdsQNWDRwzVhU6d/HgbMNUrSDMXaIX" +
       "YixCUaibEK0H4RN07gWHqoa5x+g9CBCAAAEI0BoCVD8oBSq9ULUjC89qiHYY" +
       "eLl/ltuhc3e6cgYvzL362kZc0RetbTP9NQPQwl3Z7xEgta6c+LnL+9w3nK8j" +
       "/NE89Ow/f+elX7wtd1HIXdRtLoMjAxAhuImQu9dSLUn1g7qiqIqQu99WVYVT" +
       "fV009XSNW8g9EOhzWwwjX90XUnYyclV/fc8Dyd0rZ9z8SA4df5/eTFdNZe/X" +
       "HTNTnAOuDx5w3TBsZucBwXt0AMyfibK6V+V2Q7eVMPeqozX2OT7WAQVA1QuW" +
       "GmrO/q1ut0VwIvfApu9M0Z5DXOjr9hwUvcOJwF3C3EMnNprJ2hVlQ5yrV8Pc" +
       "y46W628ugVJ3rwWRVQlzLzlabN0S6KWHjvTSof75696bn3mXTdq7a8yKKpsZ" +
       "/rtApUeOVGLVmeqrtqxuKt77Rvpj4oO/8cHdXA4UfsmRwpsyv/ID33nyTY98" +
       "8cubMq84pgwjLVQ5vCp/Wrrv91+Jv6F2WwbjLtcJ9Kzzr2G+Vv/+9soTiQss" +
       "78H9FrOLV/YufpH9d9P3fEb9y93cPVTuTtkxIwvo0f2yY7m6qfot1VZ9MVQV" +
       "Kne3aiv4+jqVuwCOad1WN2eZ2SxQQyp3u7k+daez/g1ENANNZCK6AI51e+bs" +
       "HbtiqK2PEze3/bsDpNL2eP0/zD0JaY6lQqIs2rrtQH3fyfgHkGqHEpCtBrn6" +
       "1c1BpjaSs4ICX4YIay670ZXslHsL2kgynJeWOztAhK88asAm0H3SMRXVvyo/" +
       "G2GN73zu6ld39xV6yzDM3blpL7ezs27mxVm7m14AMjSANQI/de8buHe0v/+D" +
       "r7kNdL+7vB0IICsKnewu8QP7pdZeSgZKlPvix5fvHb27sJvbvdbvZVjAqXuy" +
       "6v3MW+17pceO6vtx7V58+lt/+/mPPeUcaP41jnRrkNfXzAzqNUel5juyqgAX" +
       "ddD8Gy+Lv3z1N556bDd3O7BS4JlCEWgSMPpHjt7jGsN6Ys9JZVzuAIRnjm+J" +
       "ZnZpz7PcE2q+szw4s+7O+9bH9wMZ35Vp2n0gPbtVvfX/7OqL3Cx/8ab7s047" +
       "wmLtBN/CuT/5x1/7i9Ja3Hv+8uKhEYhTwycO2WjW2MW1Nd5/oANDX1VBuf/y" +
       "8f6Pf/Svn37bWgFAiUePu+FjWY4D2wRdCMT8gS97f/KNr3/6D3cPlAZomxtJ" +
       "pi4n+yR3Mk4XTiEJ7va6AzzAxk1gI5nWPMbblqPoM12UTDXT0v978bXwL//V" +
       "M5c2emCCM3tq9KazGzg4/3Is956vvvPvHlk3syNnY8yBzA6KbRzXiw5arvu+" +
       "uMpwJO/9g4f/xW+LPwlcIHA7gZ6qa09y21oGt62ZvyTM3Y2LPhhGlLm6d+au" +
       "FrDLzOj2TjywblxchlcyqTo28AvrLofWBd64zq9k4lq3nFtfQ7PsVcFh07nW" +
       "Og9FElflj/zht184+vYXvrPmem0oclhTuqL7xEY5s+xyApp/6VE/QYqBBsoh" +
       "X+y9/ZL5xe+CFgXQogzG34DxgRNKrtGrbek7LvzHf/ObD37/79+W223m7jEd" +
       "UWmKaxPN3Q1sQw004L8S9/ue3KjGMrOIS2uquevIb1TqZetfMAD4hpO9UzOL" +
       "JA4M/GX/wJjS+/7s768TwtovHTOAHqkvQJ/9iYfwt/7luv6Bg8hqP5Jc75hB" +
       "1HVQt/gZ63/vvubO39rNXRByl+RtSDcSzSgzOwGEMcFenAfCvmuuXxuSbMbf" +
       "J/Yd4CuPOqdDtz3qmg4GBHCclc6O7znijdaG+iBI5a2hlo96o53c+qCxrvLq" +
       "df5Ylr1+20Obpv4J/O2A9I9Zys5nJzZj6gP4dmC/vD+yu2CE2hFP786+r1vA" +
       "g8XbeAZ66oFvGD/xrZ/fxCpH++5IYfWDz/7wP1155tndQxHio9cFaYfrbKLE" +
       "tXBemGVUZg2vPu0u6xrNP//8U7/2r556eoPqgWvjnQYI53/+j/7f7175+De/" +
       "cswQfRuIZTeuPsurWdbcSPOJE03jyfN33OikjlvTBP0gZQfMESTj5wHJO85C" +
       "Ih+H5J3PAxLlLCTKcUjU5wGJcRYS9Tgk5vOAxD8Lyew4JMGNI1kHPi8FCd0i" +
       "QU9AsjoeyU52+PgenN3APQ5P+jzgec8N4XGP1d73Pg94nr4hPJp5HJ4PnlNz" +
       "XgzSm7d43nwCnmfO0BwwaQdBOu5EG393FNKHzwnpUZDeuoX01hMgffQMSPev" +
       "1xH8yA2Dhp0FihuPQK8vb/D0w9wFyXFMVbSPAP7YOQE/AFJ9C7h+AuBPnQH4" +
       "gq4SqimujhPgT50Tz8Mg4Vs8+Al4fuYMPC8IdUvcii479YkjmH72nJgeAonY" +
       "YiJOwPTzZ2B64VrPgr7qDwG44yT1uZuQVGuLqnUCql86S1K6Te0p23GS+uVz" +
       "YnoNSO0tpvYJmH7tDEyXJF8VDdcBVrDpw+OA/fqNA8tmernLIDFbYMx1wHb2" +
       "Z6BZYHslE8lc9R/4s5/69N+99+nqbjapuiPOAmAQR106KNeLsvXHH/zsRx9+" +
       "wbPf/NB60glafk/W6L89wQ2GIAzWbdHcI3tn86rQYJnjDPwOMBXxjwZhv3kT" +
       "vAdb3oNjeGcHXwKnn8wOfu8U3/2VfYfZvMrx2JCt48PszFePAPz9mwDIbQFy" +
       "pwC8nB388Y0AfEHzKlmnm3idZafHIfyTm0DIbxHypyC8lB1880YQXmhePRHd" +
       "n54T3etAGm/RjU9G9+jj2cG3bgTd/VSPG7Lc1X6DvTrC6HqvcxzOvzgnzjeA" +
       "9M4tzneeIsU3ZwffvhGcD2J1rnH1EFjyRLDfOacbK4J0dQv26nVgN27s788a" +
       "xW8I2f+5CTFKW2TSKWJ8dXbwTzcixhcdFSNBjY5BupM7pwzfBJK8RSofL8Od" +
       "C2fI8L6zYd1147Cydc3c60HStrC0UwSYCWnnvuPx7WaHj1/rFane8GRr2bl4" +
       "EyiNLUrjFJQZkp0HbxjlXRlKGifw4zC+9CYw2luM9ikYb88af+R8GIdUt34c" +
       "xlfdBEZvi9E7BeNdWeOvu2GMFzKMXIM9DuLrbwJiuIUYngIxG152rpwPYh8u" +
       "HAcROqcpw1mZLcT4BFOunBX/+upcD0Co2RMtNQDx1mtPXl1bL2tvFss++TOP" +
       "fu3dn3z0T9dru3fpwUj06/78mG3JQ3W+/dlv/OUfvPDhz613T26XxGCzuHh0" +
       "P/f67dprdmHXwO/dF0Q211xPBHa2gtjZdNjV6xcQv/eyF4mB7kVOqD6+2Xy4" +
       "HKy3ri+vY7/Lm73ct73jcpchGld79W6Du/yWy7a63F55l2hJT73typUr73ji" +
       "Da676ayXhIcjz0259YVsQXpnu0G27rusN9661y34DSvMnaZqzzfbkNnMZOct" +
       "2xtn7e9uKu0BedEBENx0bDUL0veubTbzdOfK/k48uJhch9TPvfHk/u+uu+Fg" +
       "xfq33/ffHxq+Vfv+c+ziveqIehxt8l93P/uV1uvkH9vN3ba/fn3dNv21lZ64" +
       "dtX6Hl8NI98eXrN2/fBG+Gv5bSSfZa9di3j9+9gdlB3ulGt8lmXTATkT9aZn" +
       "Tik+SXJHrB09p7VnKymrrZInJ1j7286ydjBZYtzMHLbdtPOWI6jefk5UbwHp" +
       "XVtU6QmopDNQXQw0fRaejku+iQWfd29xvfsEXPoZuC5Yom6zG+3deWK//Wxp" +
       "Zr06+vVt+1/fuJzuTe3hc8Ap+epYjNWto3L8vYcCbm2DGwEemczeLq1C9WR/" +
       "5eyJKr5Bf5WVbe77Kvt6X5WdJrOsfb3zyU53N7dd186ywSk29dQp196dZe/K" +
       "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" +
       "EM/5Ea0YrOag+ULUFKrWUvP5juBqmiHa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+fX1t33+P9ASwwqzXQAA");
}
