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
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVcDXQc1XV+u7Jl+UeWLP+BjY1/xI8NSBhiSGrjIK8kW2Yt" +
       "CcmWiSBeRrMjadDs7HjmrbQ2cQwOYAPFccA2hILTczCBugbTNJy0TaCkEAKF" +
       "0MNP2wAnEGhPA6EcoD2BNi6k9755s7M7O++td2P5nHkaz7x773e/d999b968" +
       "nWMfkomOTRZqJm2i2y3NaWozabdiO1oyZiiOswmuJdS7q5T/3vpe51eipLqf" +
       "TB9WnI2q4mjtumYknX6yQDcdqpiq5nRqWhIlum3N0exRhepps5/M1p2OlGXo" +
       "qk43ppMaVuhT7DiZoVBq6wMZqnVwBZQsiAOSZoakuSV4e1WcTFPT1na/+ml5" +
       "1WN5d7BmyrflUFIfv04ZVZozVDea47pDV2Vtcp6VNrYPGWnapGVp03XGSk7B" +
       "hvjKIgqWPFb36Yn9w/WMgpmKaaYpc8/p0Zy0Maol46TOv9pmaClnG/kmqYqT" +
       "qXmVKWmMe0abwWgzGPW89WsB+lrNzKRiaeYO9TRVWyoComRxoRJLsZUUV9PN" +
       "MIOGGsp9Z8Lg7aKct66XRS4ePK/5wN1b639QRer6SZ1u9iIcFUBQMNIPhGqp" +
       "Ac12WpJJLdlPZpjQ2L2arSuGvoO3dIOjD5kKzUDze7TgxYyl2cymzxW0I/hm" +
       "Z1SatnPuDbKA4v+bOGgoQ+DrHN9X18N2vA4OTtEBmD2oQNxxkQkjupmk5Myg" +
       "RM7HxiugAohOSml0OJ0zNcFU4AJpcEPEUMyh5l4IPXMIqk5MQwDalMwTKkWu" +
       "LUUdUYa0BEZkoF63ewtqTWZEoAgls4PVmCZopXmBVsprnw87V++73lxvRkkE" +
       "MCc11UD8U0FoYUCoRxvUbA36gSs4bXn8kDLnib1RQqDy7EBlt86PvvHJ5ecv" +
       "fOo5t878kDpdA9dpKk2oRwamv3xGbNlXqhBGjZV2dGz8As9ZL+vmd1ZlLcgw" +
       "c3Ia8WaTd/Opnme/dsNR7YMomdJBqtW0kUlBHM1Q0ylLNzR7nWZqtkK1ZAeZ" +
       "rJnJGLvfQSbBeVw3Nfdq1+Cgo9EOMsFgl6rT7P9A0SCoQIqmwLluDqa9c0uh" +
       "w+w8axH+byIcF/Nz9peSi5qH0ymt2dKbu+00uu40Q7IZAFqHmzFQBtLbmx1b" +
       "bW5NDalWpgkvWRVJZRHLzLFIBGg6I9hJDYjv9WkjqdkJ9UBmbdsnjyZecAMA" +
       "g5Z7QUm1q49EIkzNLNTrMg08jUCPg5Q3bVnv1zdcu3dJFTSxNTYBnMSqSwpS" +
       "f8zvll4uTajHG2p3LH5rxdNRMiFOGhSVZhQDM3mLPQQ5Qh3h3WjaAAwKfm5e" +
       "lJebcVCx06qWhNQgytFcS016VLPxOiWz8jR4Iwf2kWZx3g7FT566Z+zGvl0X" +
       "Rkm0MB2jyYmQSVC8G5NoLlk2BrthmN66Pe99evzQzrTfIQvyuzcsFUmiD0uC" +
       "DR2kJ6EuX6Q8nnhiZyOjfTIkTKpAgEMuWhi0UdDfV3m5E32pAYcH03ZKMfCW" +
       "x/EUOmynx/wrLAJnsPNZEBY12AGmw3GA9wj2F+/OsbCc60YsxlnAC5abL+u1" +
       "7v/lS+9fzOj20nhd3vjbq9FVeakDlTWwJDHDD9tNtqZBvV/d033XwQ/3XM1i" +
       "FmosDTPYiGUMUgY0IdB883PbXn/7rSOvRf04hw5iZQZgCpLNORlBnyZJnARr" +
       "Z/t4IPUY0Jsxaho3mxCf+qCuDBgadqz/qztrxeP/ua/ejQMDrnhhdH5pBf71" +
       "09eSG17Y+tlCpiai4tDnc+ZXc/PpTF9zi20r2xFH9sZXFnz358r9kJkhGzr6" +
       "Do0luCrGQRXz/DRKJscUG0a35JDmXalZB6kE84R3oYEpV8ZoE7KaNqEbsiZf" +
       "ySpcyMovIV1MM2H3LsPiLCe/6xT2zrwJTkLd/9rHtX0fP/kJ87VwhpQfKRsV" +
       "a5UbnFicnQX1c4Opbb3iDEO9Lz3VeU298dQJ0NgPGlWYFjhdNuTNbEFc8doT" +
       "J73x06fnXPtyFYm2kylGWkm2K6yLksnQNzRnGFJu1vrq5W5ojGGPqGeukiLn" +
       "iy5g85wZ3vBtKYuyptrxN3N/uPqhw2+xGLVcHfOZfBOOAgU5mc2z/bRw9NVL" +
       "//mh7xwac0fqZeJcGJA77fddxsDud/+niHKWBUNmEQH5/uZj982LrfmAyfvp" +
       "CKUbs8UjF6R0X/aio6nfRZdU/yxKJvWTepXPa/sUI4OdvB/mco432YW5b8H9" +
       "wnmZOwlZlUu3ZwRTYZ7ZYCL0R0w4x9p4XhvIfSwtzIFjJU8LK4O5L0LYSRcT" +
       "OYeVy7G4ID8ecqoiElWURJTCERhHud7MgAOjpZ6C5DjKZ3AXdV+r7m3s/ne3" +
       "zU8PEXDrzX64+Y6+f73uRZZ6a3A83uT5mTfawridl/frXcB/gH8ROL7AA4Hi" +
       "BXcm1BDj07FFufkYxqw0+AIONO9seHvkvvcecR0IRlqgsrb3wG1/aNp3wM2n" +
       "7qR+adG8Ol/Gndi77mBxFaJbLLPCJNp/c3znjx/eucdF1VA4RW2DJ7BH/uXz" +
       "F5vu+fXzITOuKp0/mGHXj+SmU7MK28Z1qPXWup/sb6hqh5G8g9RkTH1bRutI" +
       "FkbkJCczkNdY/sOCH6XcNWwYCJ3l0AbuOIzlGiy63eBrEeatjvLjnM2UrwR7" +
       "A3iyJWBRHweLKc+iGmbRHAeLtmcxGWbRGQeLY55FLcxidhwsfsOzOBhmcefJ" +
       "W2Szw7lwXMotXiqweKObIbE4r3jaJZKmJOpYYRB3jwPEvVh8C0xaobF26ziY" +
       "vMMzOWyEmdxXZtPjyWpucrXA5J1+Q/QUj04iaYorLPDoEktnTBoG9a4yoS6F" +
       "Yw03tkYA9btSqCJpSmawxSA7Y1GnzcRptbu4s9nNmOy8P+98KyWTBtJpQ1PM" +
       "YA7H/yaDifXeMl1tgKOFg20RuPqg1FWRNADXtVbNULaHNcn3y8S5AI4YtxQT" +
       "4DwmxSmSpmQq1VMKbwy8dDiA9ZEysc6Do5VbaxVg/WspVpE0JbUs0p1uGHEB" +
       "dBizP6yA2XXc3joB2r+TohVJA7O62eGFexizPy4T6xI4NnBrGwRYfyrFKpKm" +
       "pH7A1pQRKw39042FMMD/cPKAceggi+Do4ia7igBHcisJ+MjQhFQNaXbDu39+" +
       "5LMb93w5ig/HE0fx0QLmfPV+vc4MLm/fcuzggqkHfn07ezADzTeg0ufC5/oR" +
       "Cg8YuqkYgTl/tQQeJdXtif62nq5S+WkiPIPaRTPM0Oz0fAX0XcnxXRlCH578" +
       "I1y+HE9e9xv+pWI3RWpg8GhP9G5eu6mnJbYJr7wSwPxGBZh7ubFeCeZFePKO" +
       "FLNIDXSs9sT6lnh7rKWn52thoN+tAPRmbm2zBDSb2L8vBS1SA+NBe0II+Ldl" +
       "Aj4bji3c0hYx4KXn4sknUsAiNTBWd3T2burpTXS39ST61sZbOq8Ig/5fZUJf" +
       "BsdWbnOrhOvVePK/UugiNZTMWdvS25bIw79eiP/3ZSbhi+BIcMOJIvwsCXMv" +
       "RElYJF3IuBBxJFoB4wPc5oCE8cWovEbKuEgNJTODjLd29IWBn1wm3efDoXKr" +
       "qoDueindImlKppeGO+Pk4eJCPDkHjmFucFjCNQ4Qkbnhw1UUT5uw+KfAgFUr" +
       "0Q6ZvKNzk7ijRk6rwJURbmxE4grCjSyqxBWRdkpq0JV4rDUW5sjiChwxuSlT" +
       "4sgEVL6sEkdE2rkjmzo2toQ5srwCR7ZxU9skjtSg8osqcUSkHUYvdKS3rSfM" +
       "j4sr8INyS1TiBw63kVWV+CHSzv3oXnFhmB+ry8xNK7AOtzRa5Iebm1qluWlU" +
       "IA1POrY2pDvw8NCppDSncOtPbjGZvVFyly6vmfrs3zsP/McP3CXSsKXqwGaD" +
       "hx+qUd9MPcuWqtFmX+GggSy2c3TtLpUrT/KVee69lfeuvTJBXBo+S7xwnef7" +
       "4e8vfWnX4aXvsFdKNbrTp9gt9lDIJo08mY+Pvf3BK7ULHmUvbSfgCjy6Xxvc" +
       "3VK8eaVgTwpjrg7bOe7Gzmk0/1HF3Z0SfDZwQ8kV4lGyuXSQY3kVPJUYmjnk" +
       "bov4OkpeafkvtqKukAdkpg8kZqRNDZ/qvHvuxgM93ZTbGQQ3s0VIbbKg4BXX" +
       "Rua7/77oV9Pv/Le/bRxaW86OA7y2sMSeAvz/mdCAy8XtH4Ty892/nbdpzfC1" +
       "ZWweODMQHkGVf7Hx2PPrzlbvjLLNR+6LrKJNS4VCqwpfFkyxNZqxzcLXA0vd" +
       "pmet52eH81gDs/+HvriNDEruYTzgm+iJKja0GxeS6iNFV1naWWflvTaVPMhG" +
       "2spMlLhkuZ0nk6wgUVrSRJkVSEOiVIxMl4Vvu3hjR64IoN1WJtrL4Lie29sh" +
       "QDsmRbtDIE1JnTOsD1I53nLfKuB67S5ucZcA7zeleEXSMFymFN3scftMJLCK" +
       "Po0UD2CRjcxcJ3Mh0oXFTa47kiWUCQPbqRYeeOLceZPn2p+eZO7Eulfl8ubN" +
       "xXkTLyOyyDWhZiMJ1yyTxiIp6WF3Se4dxOI7WOguEkndu//InrqrzFhaCMdu" +
       "3qa7BbF0nzSWRNKUVKUVfGUY+VYA4/1lYpwNx03cyk0CjA9IMYqkKZmsenMQ" +
       "vHBJAOmRMpHOh+NmbutmAdKjUqQiaUqmDdmKNayrTmxYt7xhfdq6vIsB8H9Z" +
       "Ac23cPO3CMDL1/FF0kCzk86YyXzkk3u9KwHY5S7oz4RjDze8RwD7J1LYIml4" +
       "mhviG7Dw/18OAH2iAn73clN7BUCflgIVSQObenq9YiYNzc7x2+FdCcB+poJX" +
       "Zrdyw7cKYL8ohS2ShsmtYlmGxt6V/EkA5i8qCIPbuKHbBDBflcIUSQOX8EiQ" +
       "0k2Fhr0kibxWJtLT4bid27pdgPQNKVKRNAzfdsY04REkDOebZeI8A447uKU7" +
       "BDjfkeIUSVMydWhAbdfcXySEYS1jQZ9ZWwzHPm5tnwDre1KsIml4vlMMIz22" +
       "Tg74/Qq2B3ybm/y2APBHUsAiaUqmALkwhVuruHkr8MY08rEEajbMZO5fwUb8" +
       "PJOs5nxvmx08Q4p+K8E2dx3ZfeBwsuvBFd5CRAI7WNq6wNBGNSNP1Wx3ElY4" +
       "B8UdNUc5jKNB3nxHRZtbRKLiGVk0KrnHVhA/h26X1B0r7Wihk93RtJ702f+i" +
       "VKDIt7DihXVWGDNnwnGcu3e8fGZEohLvGyT3ZmFRC50nlzrZRnoHK0erc3RE" +
       "p48DHbM8Op7kPj0poUP2GFHIUq1EY4CJvBn6FkbHIglVS7CYBzlRSSYhuzg9" +
       "msL2ZbziszR/HFhiK7PYk09wn06cMpZEGgMk+I9hbo5yqWqSUIWruNFzYdrL" +
       "qdpi62xMzo+oZePF1SXg4VpXp/v3VHAl1HhSXK2WcMXIuISSunyuuoxkgK5L" +
       "x4EuJg7PQpEUdy4loSs8HwlFw3nxZr1Fa7E+Vx0SrjZi0Qpd0NFoD1+Hx3qH" +
       "fZ5KLoFVmrcXgJP7ubP7y+dJJFoqI0lWHqM4gkV7cauLRtfGAgGzaTyJOMi9" +
       "OVg+ESLRUkRoEiIwfKLXukS0tgWIUMaTiHu5N/eWT4RItBQRtoQIfESLplwi" +
       "1scDRJTc+V0BEfjUiYtTke9xb74nIaK8jCvSWIqfGyT87MZiBwxM3ls8bxDf" +
       "4tN0/XgOTI9ypx49ZTSJNJ7UwLRPwtV+LPbmvfEMG8VL7vD+YzrXM9y1Z8rv" +
       "XCJRib9/Jrl3PxaHKJmuDmvqiLsRE540A2TcPV5kwEnkJe7RS+WTIRKVOPyw" +
       "5N5RLB6AJINfqaABDkouxVbKQTM48BF35KPyORCJirPJYebs4xIifoTFY5TM" +
       "wGEnnYGY6LU0LRmzMgFS/mq8UkojYP2Ce/aFhJTyUopIo4SKpyX3fobFEzDD" +
       "ZZ0nt/PaCZD05HiRdAH4u9TV6f49FSQJNZYanl6WMPUqFi/g07itDw1pdv4u" +
       "9XyqXhzHISp6Lnfs3FNGlUhjKarellD1DhavU3J6kKqOQf83E/mcldwwXSln" +
       "54BnTdzDplPGmUijhJIPJfc+wuI3lDTopk51Bb8JJOiG740XT9D60UPcq0On" +
       "jCeRxlKxdUJC1udY/I6SSVpWUzNFc55Px2uIOxv+9rk63b8ChraFDnFC0RJD" +
       "XFWNmIqqKVhUwSQQHzFzv0QpJKRqwjgQUof35oE313CvrimfEJHoyUyNq2ZL" +
       "WJmLRT0lU5O6oziOlnJ/lxPd4HNScoPyyXCSzX2Yxsq9kM1bOnF/zJ91N1/M" +
       "z9fFdtDPLgUh71XA0oINXeyDWN7mq4z7SayEevzwhs7rP7nkQfe7JKqh7NiB" +
       "WqbGyST3EylMKW7gWizU5umqXr/sxPTHJp/lvVyY4QL223S+Tzf+giti4Vch" +
       "5gU+2uE05r7d8fqR1U/+Ym/1K1ESuZpEFEpmXl382YOslbHJgqvjxb8x71Ns" +
       "9jWRVcvu3b7m/MGP3vR+vxQp/JxEsH5C7b/rlx2PjXx2OfsC00TdTGpZ9j2G" +
       "1u1mj6aO2gU/WJ+Om9UUXPBiPHD6anNXcfGdkiXFv9Uv/vbPFCM9ptlr8e08" +
       "qqmNk6n+FbclAnveIIgCAv4V3nRYsl/yXsU2dFFSlYhvtCzvUwZTLRaYybBc" +
       "wra4VLH9u6i/asX/A6oV/PYbTwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV8ebDrWHmn7+3ldTdNv9cNNNDQzYNuoMHkSbZsy06ztG1Z" +
       "tmRZkiV5E8uLVlvWau026WGpkCYhaaikYRgmgfxBliEEUqmkkqokFDMhkxBS" +
       "TJJKZZJZgKSmJmSbQM1MkgkzyRzZvsu77y7vvn796p1z5bPp9/vO+b7znXMk" +
       "ffZvcncEfi7vudZyarnhFS0Nr8yt8pVw6WnBFZIqs5IfaGrTkoJAAGlXldf8" +
       "/MW/+85HZpd2c3eKuRdJjuOGUmi4TsBpgWvFmkrlLh6ktizNDsLcJWouxRIU" +
       "hYYFUUYQPkHlXnCoaph7jNqDAAEIEIAArSFA9YNSoNILNSeym1kNyQmDRe5f" +
       "5Hao3J2eksELc6++thFP8iV72wy7ZgBauCv7PQSk1pVTP3d5n/uG83WEP5qH" +
       "nv2X77r0C7flLoq5i4bDZ3AUACIENxFz99qaLWt+UFdVTRVz9zuapvKab0iW" +
       "sVrjFnMPBMbUkcLI1/aFlCVGnuav73kguXuVjJsfKaHr79PTDc1S937doVvS" +
       "FHB98IDrhiGepQOC9xgAmK9LirZX5XbTcNQw96qjNfY5PtYFBUDVC7YWztz9" +
       "W93uSCAh98Cm7yzJmUJ86BvOFBS9w43AXcLcQyc2msnakxRTmmpXw9zLjpZj" +
       "N1mg1N1rQWRVwtxLjhZbtwR66aEjvXSof/6GfvMz73Y6zu4as6opVob/LlDp" +
       "kSOVOE3XfM1RtE3Fe99IfUx68Nc/uJvLgcIvOVJ4U+aXv/fbT77pkS/+9qbM" +
       "K44pw8hzTQmvKp+W7/v9VzbfULstg3GX5wZG1vnXMF8Pf3ab80TqAc17cL/F" +
       "LPPKXuYXuX8/ee9ntL/azd1D5O5UXCuywTi6X3Ftz7A0v605mi+Fmkrk7tYc" +
       "tbnOJ3IXwDVlONomldH1QAuJ3O3WOulOd/0biEgHTWQiugCuDUd39649KZyt" +
       "r1Mvt/13BwjI9nr9N8wVoZlra5BnQKzvZtQDSHNCGYh1BmUDRXaXUOArEGZP" +
       "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" +
       "zKxgvT6Gx4qTjjmr2SmjVaKwzHdaNa2W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "L1x/G3X1Ky/9xTf/9Ce/tv4+z/8HstJ+DVtdAAA=");
}
