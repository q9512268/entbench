public class JavaBoy extends java.applet.Applet implements java.lang.Runnable, java.awt.event.KeyListener, java.awt.event.WindowListener, java.awt.event.MouseListener, java.awt.event.ActionListener, java.awt.event.ItemListener, ent.runtime.ENT_Attributable {
    int[] HACK = new int[] { 0, 0, 0 };
    public int ENT_attribute() { if (ent.runtime.ENT_Util.Battery.percentRemaining(
                                                                    ) >=
                                       0.75) { return EntMode.HIGH_MODE;
                                 }
                                 else
                                     if (ent.runtime.ENT_Util.
                                           Battery.
                                           percentRemaining(
                                             ) >=
                                           0.5) {
                                         return EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return EntMode.
                                                  LOW_MODE;
                                     } }
    private final int WIDTH = 160;
    private final int HEIGHT = 144;
    private final java.lang.String WEBSITE_URL = "http://www.millstone.demon.co.uk/download/javaboy";
    private static final java.lang.String hexChars = "0123456789ABCDEF";
    private static java.lang.String versionString = "0.92";
    private boolean appletRunning = true;
    public static boolean runningAsApplet;
    private java.awt.Image backBuffer;
    private boolean gameRunning;
    private boolean fullFrame = true;
    private boolean saveToWebEnable = false;
    public static java.lang.String[] schemeNames = { "Standard colours",
    "LCD shades",
    "Midnight garden",
    "Psychadelic" };
    public static int[][] schemeColours = { { -1, -5592406, -11184811,
    -16777216,
    -1,
    -5592406,
    -11184811,
    -16777216,
    -1,
    -5592406,
    -11184811,
    -16777216 },
    { -64,
    -4013026,
    -7039488,
    -10131968,
    -64,
    -4013026,
    -7039488,
    -10131968,
    -64,
    -4013026,
    -7039488,
    -10131968 },
    { -4144897,
    -12566273,
    -16776961,
    -16777088,
    -4128832,
    -16728064,
    -16744448,
    -16760832,
    -4128832,
    -16728064,
    -16744448,
    -16760832 },
    { -16129,
    -8355585,
    -4194112,
    -8388480,
    -192,
    -4145152,
    -49088,
    -8388608,
    -8323073,
    -16727872,
    -16744320,
    -16760832 } };
    Cartridge cartridge;
    Dmgcpu dmgcpu;
    GraphicsChip graphicsChip;
    GameLink gameLink;
    short breakpointInstr;
    short breakpointAddr = -1;
    short breakpointBank;
    GameBoyScreen mainWindow;
    java.lang.String debuggerQueue = null;
    boolean debuggerPending = false;
    boolean debuggerActive = false;
    java.awt.Image doubleBuffer;
    static int[] keyCodes = { 38, 40, 37, 39, 90, 88, 10, 8 };
    boolean keyListener = false;
    java.awt.CheckboxMenuItem soundCheck;
    boolean imageSizeChanged = false;
    int stripTimer = 0;
    java.awt.PopupMenu popupMenu;
    long lastClickTime = 0;
    public static void debugLog(java.lang.String s) { java.lang.System.
                                                        out.println(
                                                              "Debug: " +
                                                              s);
    }
    public static short unsign(byte b) { if (b < 0) { return (short)
                                                               (256 +
                                                                  b);
                                         }
                                         else {
                                             return b;
                                         } }
    public static short unsign(short b) { if (b < 0) { return (short)
                                                                (256 +
                                                                   b);
                                          }
                                          else {
                                              return b;
                                          } }
    public static java.lang.String hexByte(int b) { java.lang.String s =
                                                      new java.lang.Character(
                                                      hexChars.
                                                        charAt(
                                                          b >>
                                                            4)).
                                                      toString(
                                                        );
                                                    s = s + new java.lang.Character(
                                                          hexChars.
                                                            charAt(
                                                              b &
                                                                15)).
                                                          toString(
                                                            );
                                                    return s;
    }
    public static java.lang.String hexWord(int w) { return new java.lang.String(
                                                      hexByte(
                                                        (w &
                                                           65280) >>
                                                          8) +
                                                      hexByte(
                                                        w &
                                                          255));
    }
    public void paint(java.awt.Graphics g) { if (dmgcpu !=
                                                   null) {
                                                 int stripLength =
                                                   300;
                                                 int x =
                                                   getSize(
                                                     ).
                                                     width /
                                                   2 -
                                                   dmgcpu.
                                                     graphicsChip.
                                                   getWidth(
                                                     ) /
                                                   2;
                                                 int y =
                                                   getSize(
                                                     ).
                                                     height /
                                                   2 -
                                                   dmgcpu.
                                                     graphicsChip.
                                                   getHeight(
                                                     ) /
                                                   2;
                                                 if (stripTimer >
                                                       stripLength &&
                                                       !fullFrame &&
                                                       !imageSizeChanged) {
                                                     dmgcpu.
                                                       graphicsChip.
                                                       draw(
                                                         g,
                                                         x,
                                                         y,
                                                         this);
                                                 }
                                                 else {
                                                     java.awt.Graphics bufferGraphics =
                                                       doubleBuffer.
                                                       getGraphics(
                                                         );
                                                     if (dmgcpu.
                                                           graphicsChip.
                                                           isFrameReady(
                                                             )) {
                                                         bufferGraphics.
                                                           setColor(
                                                             new java.awt.Color(
                                                               255,
                                                               255,
                                                               255));
                                                         bufferGraphics.
                                                           fillRect(
                                                             0,
                                                             0,
                                                             getSize(
                                                               ).
                                                               width,
                                                             getSize(
                                                               ).
                                                               height);
                                                         dmgcpu.
                                                           graphicsChip.
                                                           draw(
                                                             bufferGraphics,
                                                             x,
                                                             y,
                                                             this);
                                                         int stripPos =
                                                           getSize(
                                                             ).
                                                             height -
                                                           40;
                                                         if (stripTimer <
                                                               10) {
                                                             stripPos =
                                                               getSize(
                                                                 ).
                                                                 height -
                                                                 stripTimer *
                                                                 4;
                                                         }
                                                         if (stripTimer >=
                                                               stripLength -
                                                               10) {
                                                             stripPos =
                                                               getSize(
                                                                 ).
                                                                 height -
                                                                 40 +
                                                                 (stripTimer -
                                                                    (stripLength -
                                                                       10)) *
                                                                 4;
                                                         }
                                                         bufferGraphics.
                                                           setColor(
                                                             new java.awt.Color(
                                                               0,
                                                               0,
                                                               255));
                                                         bufferGraphics.
                                                           fillRect(
                                                             0,
                                                             stripPos,
                                                             getSize(
                                                               ).
                                                               width,
                                                             44);
                                                         bufferGraphics.
                                                           setColor(
                                                             new java.awt.Color(
                                                               128,
                                                               128,
                                                               255));
                                                         bufferGraphics.
                                                           fillRect(
                                                             0,
                                                             stripPos,
                                                             getSize(
                                                               ).
                                                               width,
                                                             2);
                                                         if (stripTimer <
                                                               stripLength) {
                                                             if (stripTimer <
                                                                   stripLength /
                                                                   2) {
                                                                 bufferGraphics.
                                                                   setColor(
                                                                     new java.awt.Color(
                                                                       255,
                                                                       255,
                                                                       255));
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "JavaBoy - Neil Millstone",
                                                                     2,
                                                                     stripPos +
                                                                       12);
                                                                 bufferGraphics.
                                                                   setColor(
                                                                     new java.awt.Color(
                                                                       255,
                                                                       255,
                                                                       255));
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "www.millstone.demon.co.uk",
                                                                     2,
                                                                     stripPos +
                                                                       24);
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "/download/javaboy",
                                                                     2,
                                                                     stripPos +
                                                                       36);
                                                             }
                                                             else {
                                                                 bufferGraphics.
                                                                   setColor(
                                                                     new java.awt.Color(
                                                                       255,
                                                                       255,
                                                                       255));
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "ROM: " +
                                                                     cartridge.
                                                                       getCartName(
                                                                         ),
                                                                     2,
                                                                     stripPos +
                                                                       12);
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "Double click for options",
                                                                     2,
                                                                     stripPos +
                                                                       24);
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "Emulator version: " +
                                                                     versionString,
                                                                     2,
                                                                     stripPos +
                                                                       36);
                                                             }
                                                         }
                                                         stripTimer++;
                                                         g.
                                                           drawImage(
                                                             doubleBuffer,
                                                             0,
                                                             0,
                                                             this);
                                                     }
                                                     else {
                                                         dmgcpu.
                                                           graphicsChip.
                                                           draw(
                                                             bufferGraphics,
                                                             x,
                                                             y,
                                                             this);
                                                     }
                                                 }
                                             }
                                             else {
                                                 g.
                                                   setColor(
                                                     new java.awt.Color(
                                                       0,
                                                       0,
                                                       0));
                                                 g.
                                                   fillRect(
                                                     0,
                                                     0,
                                                     160,
                                                     144);
                                                 g.
                                                   setColor(
                                                     new java.awt.Color(
                                                       255,
                                                       255,
                                                       255));
                                                 g.
                                                   drawRect(
                                                     0,
                                                     0,
                                                     160,
                                                     144);
                                                 g.
                                                   drawString(
                                                     "JavaBoy (tm)",
                                                     10,
                                                     10);
                                                 g.
                                                   drawString(
                                                     "Version " +
                                                     versionString,
                                                     10,
                                                     20);
                                                 g.
                                                   drawString(
                                                     "Charging flux capacitor...",
                                                     10,
                                                     40);
                                                 g.
                                                   drawString(
                                                     "Loading game ROM...",
                                                     10,
                                                     50);
                                             }
    }
    public void mouseClicked(java.awt.event.MouseEvent e) {
        long doubleClickTime =
          java.lang.System.
          currentTimeMillis(
            ) -
          lastClickTime;
        if (doubleClickTime <=
              250) {
            popupMenu.
              show(
                e.
                  getComponent(
                    ),
                e.
                  getX(
                    ),
                e.
                  getY(
                    ));
        }
        lastClickTime =
          java.lang.System.
            currentTimeMillis(
              );
    }
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
    }
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.System.
          out.
          println(
            e.
              getActionCommand(
                ));
        if (e.
              getActionCommand(
                ).
              equals(
                "Size: 1x")) {
            dmgcpu.
              graphicsChip.
              setMagnify(
                1);
            imageSizeChanged =
              true;
        }
        else
            if (e.
                  getActionCommand(
                    ).
                  equals(
                    "Size: 2x")) {
                dmgcpu.
                  graphicsChip.
                  setMagnify(
                    2);
                imageSizeChanged =
                  true;
            }
            else
                if (e.
                      getActionCommand(
                        ).
                      equals(
                        "Size: 3x")) {
                    dmgcpu.
                      graphicsChip.
                      setMagnify(
                        3);
                    imageSizeChanged =
                      true;
                }
                else
                    if (e.
                          getActionCommand(
                            ).
                          equals(
                            "Size: 4x")) {
                        dmgcpu.
                          graphicsChip.
                          setMagnify(
                            4);
                        imageSizeChanged =
                          true;
                    }
                    else
                        if (e.
                              getActionCommand(
                                ).
                              equals(
                                "Define Controls")) {
                            new DefineControls(
                              );
                        }
                        else
                            if (e.
                                  getActionCommand(
                                    ).
                                  equals(
                                    "FrameSkip: 0")) {
                                dmgcpu.
                                  graphicsChip.
                                  frameSkip =
                                  1;
                            }
                            else
                                if (e.
                                      getActionCommand(
                                        ).
                                      equals(
                                        "FrameSkip: 1")) {
                                    dmgcpu.
                                      graphicsChip.
                                      frameSkip =
                                      2;
                                }
                                else
                                    if (e.
                                          getActionCommand(
                                            ).
                                          equals(
                                            "FrameSkip: 2")) {
                                        dmgcpu.
                                          graphicsChip.
                                          frameSkip =
                                          3;
                                    }
                                    else
                                        if (e.
                                              getActionCommand(
                                                ).
                                              equals(
                                                "FrameSkip: 3")) {
                                            dmgcpu.
                                              graphicsChip.
                                              frameSkip =
                                              4;
                                        }
                                        else
                                            if (e.
                                                  getActionCommand(
                                                    ).
                                                  equals(
                                                    "Reset")) {
                                                dmgcpu.
                                                  reset(
                                                    );
                                            }
                                            else
                                                if (e.
                                                      getActionCommand(
                                                        ).
                                                      equals(
                                                        "Save")) {
                                                    try {
                                                        dmgcpu.
                                                          cartridge.
                                                          saveBatteryRAMToWeb(
                                                            new java.net.URL(
                                                              getParameter(
                                                                "SAVERAMURL")),
                                                            getParameter(
                                                              "USERNAME"),
                                                            dmgcpu);
                                                    }
                                                    catch (java.net.MalformedURLException ex) {
                                                        
                                                    }
                                                }
                                                else
                                                    if (e.
                                                          getActionCommand(
                                                            ).
                                                          equals(
                                                            "Load")) {
                                                        try {
                                                            dmgcpu.
                                                              cartridge.
                                                              loadBatteryRAMFromWeb(
                                                                new java.net.URL(
                                                                  getParameter(
                                                                    "LOADRAMURL")),
                                                                getParameter(
                                                                  "USERNAME"),
                                                                dmgcpu);
                                                            java.lang.System.
                                                              out.
                                                              println(
                                                                "Resetting...");
                                                        }
                                                        catch (java.lang.Exception ex) {
                                                            
                                                        }
                                                    }
                                                    else
                                                        if (e.
                                                              getActionCommand(
                                                                ).
                                                              equals(
                                                                "JavaBoy Website")) {
                                                            try {
                                                                getAppletContext(
                                                                  ).
                                                                  showDocument(
                                                                    new java.net.URL(
                                                                      WEBSITE_URL),
                                                                    "_new");
                                                            }
                                                            catch (java.net.MalformedURLException ex) {
                                                                
                                                            }
                                                        }
    }
    public void itemStateChanged(java.awt.event.ItemEvent e) {
        setSoundEnable(
          soundCheck.
            getState(
              ));
    }
    public void setSoundEnable(boolean on) {
        soundCheck.
          setState(
            on);
        if (dmgcpu.
              soundChip !=
              null) {
            dmgcpu.
              soundChip.
              channel1Enable =
              on;
            dmgcpu.
              soundChip.
              channel2Enable =
              on;
            dmgcpu.
              soundChip.
              channel3Enable =
              on;
            dmgcpu.
              soundChip.
              channel4Enable =
              on;
        }
    }
    public void activateDebugger() { debuggerActive =
                                       true;
    }
    public void deactivateDebugger() { debuggerActive =
                                         false;
    }
    public void update(java.awt.Graphics g) {
        paint(
          g);
        fullFrame =
          true;
    }
    public void drawNextFrame() { fullFrame =
                                    false;
                                  repaint(
                                    ); }
    public void keyTyped(java.awt.event.KeyEvent e) {
        
    }
    public void keyPressed(java.awt.event.KeyEvent e) {
        int key =
          e.
          getKeyCode(
            );
        if (key ==
              keyCodes[0]) {
            dmgcpu.
              ioHandler.
              padUp =
              true;
            dmgcpu.
              triggerInterruptIfEnabled(
                dmgcpu.
                  INT_P10);
        }
        else
            if (key ==
                  keyCodes[1]) {
                dmgcpu.
                  ioHandler.
                  padDown =
                  true;
                dmgcpu.
                  triggerInterruptIfEnabled(
                    dmgcpu.
                      INT_P10);
            }
            else
                if (key ==
                      keyCodes[2]) {
                    dmgcpu.
                      ioHandler.
                      padLeft =
                      true;
                    dmgcpu.
                      triggerInterruptIfEnabled(
                        dmgcpu.
                          INT_P10);
                }
                else
                    if (key ==
                          keyCodes[3]) {
                        dmgcpu.
                          ioHandler.
                          padRight =
                          true;
                        dmgcpu.
                          triggerInterruptIfEnabled(
                            dmgcpu.
                              INT_P10);
                    }
                    else
                        if (key ==
                              keyCodes[4]) {
                            dmgcpu.
                              ioHandler.
                              padA =
                              true;
                            dmgcpu.
                              triggerInterruptIfEnabled(
                                dmgcpu.
                                  INT_P10);
                        }
                        else
                            if (key ==
                                  keyCodes[5]) {
                                dmgcpu.
                                  ioHandler.
                                  padB =
                                  true;
                                dmgcpu.
                                  triggerInterruptIfEnabled(
                                    dmgcpu.
                                      INT_P10);
                            }
                            else
                                if (key ==
                                      keyCodes[6]) {
                                    dmgcpu.
                                      ioHandler.
                                      padStart =
                                      true;
                                    dmgcpu.
                                      triggerInterruptIfEnabled(
                                        dmgcpu.
                                          INT_P10);
                                }
                                else
                                    if (key ==
                                          keyCodes[7]) {
                                        dmgcpu.
                                          ioHandler.
                                          padSelect =
                                          true;
                                        dmgcpu.
                                          triggerInterruptIfEnabled(
                                            dmgcpu.
                                              INT_P10);
                                    }
        switch (key) {
            case java.awt.event.KeyEvent.
                   VK_F1:
                if (dmgcpu.
                      graphicsChip.
                      frameSkip !=
                      1)
                    dmgcpu.
                      graphicsChip.
                      frameSkip--;
                if (runningAsApplet)
                    showStatus(
                      "Frameskip now " +
                      dmgcpu.
                        graphicsChip.
                        frameSkip);
                break;
            case java.awt.event.KeyEvent.
                   VK_F2:
                if (dmgcpu.
                      graphicsChip.
                      frameSkip !=
                      10)
                    dmgcpu.
                      graphicsChip.
                      frameSkip++;
                if (runningAsApplet)
                    showStatus(
                      "Frameskip now " +
                      dmgcpu.
                        graphicsChip.
                        frameSkip);
                break;
            case java.awt.event.KeyEvent.
                   VK_F5:
                dmgcpu.
                  terminateProcess(
                    );
                activateDebugger(
                  );
                java.lang.System.
                  out.
                  println(
                    "- Break into debugger");
                break;
        }
    }
    public void keyReleased(java.awt.event.KeyEvent e) {
        int key =
          e.
          getKeyCode(
            );
        if (key ==
              keyCodes[0]) {
            dmgcpu.
              ioHandler.
              padUp =
              false;
            dmgcpu.
              triggerInterruptIfEnabled(
                dmgcpu.
                  INT_P10);
        }
        else
            if (key ==
                  keyCodes[1]) {
                dmgcpu.
                  ioHandler.
                  padDown =
                  false;
                dmgcpu.
                  triggerInterruptIfEnabled(
                    dmgcpu.
                      INT_P10);
            }
            else
                if (key ==
                      keyCodes[2]) {
                    dmgcpu.
                      ioHandler.
                      padLeft =
                      false;
                    dmgcpu.
                      triggerInterruptIfEnabled(
                        dmgcpu.
                          INT_P10);
                }
                else
                    if (key ==
                          keyCodes[3]) {
                        dmgcpu.
                          ioHandler.
                          padRight =
                          false;
                        dmgcpu.
                          triggerInterruptIfEnabled(
                            dmgcpu.
                              INT_P10);
                    }
                    else
                        if (key ==
                              keyCodes[4]) {
                            dmgcpu.
                              ioHandler.
                              padA =
                              false;
                            dmgcpu.
                              triggerInterruptIfEnabled(
                                dmgcpu.
                                  INT_P10);
                        }
                        else
                            if (key ==
                                  keyCodes[5]) {
                                dmgcpu.
                                  ioHandler.
                                  padB =
                                  false;
                                dmgcpu.
                                  triggerInterruptIfEnabled(
                                    dmgcpu.
                                      INT_P10);
                            }
                            else
                                if (key ==
                                      keyCodes[6]) {
                                    dmgcpu.
                                      ioHandler.
                                      padStart =
                                      false;
                                    dmgcpu.
                                      triggerInterruptIfEnabled(
                                        dmgcpu.
                                          INT_P10);
                                }
                                else
                                    if (key ==
                                          keyCodes[7]) {
                                        dmgcpu.
                                          ioHandler.
                                          padSelect =
                                          false;
                                        dmgcpu.
                                          triggerInterruptIfEnabled(
                                            dmgcpu.
                                              INT_P10);
                                    }
    }
    public void displayDebuggerHelp() { java.lang.System.
                                          out.
                                          println(
                                            ("Enter a command followed by it\'s parameters (all values in " +
                                             "hex):"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "?                     Display this help screen");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("c [script]            Execute _c_ommands from script file [d" +
                                             "efault.scp]"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "s                     Re_s_et CPU");
                                        java.lang.System.
                                          out.
                                          println(
                                            "r                     Show current register values");
                                        java.lang.System.
                                          out.
                                          println(
                                            "r reg val             Set value of register reg to value val");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("e addr val [val] ...  Write values to RAM / ROM starting at " +
                                             "address addr"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "d addr len            Hex _D_ump len bytes starting at addr");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("i addr len            D_i_sassemble len instructions startin" +
                                             "g at addr"));
                                        java.lang.System.
                                          out.
                                          println(
                                            ("p len                 Disassemble len instructions starting " +
                                             "at current PC"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "n                     Show interrupt state");
                                        java.lang.System.
                                          out.
                                          println(
                                            "n 1|0                 Enable/disable interrupts");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("t [len]               Execute len instructions starting at c" +
                                             "urrent PC [1]"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "g                     Execute forever");
                                        java.lang.System.
                                          out.
                                          println(
                                            "o                     Output Gameboy screen to applet window");
                                        java.lang.System.
                                          out.
                                          println(
                                            "b addr                Set breakpoint at addr");
                                        java.lang.System.
                                          out.
                                          println(
                                            "k [keyname]           Toggle Gameboy key");
                                        java.lang.System.
                                          out.
                                          println(
                                            "m bank                _M_ap to ROM bank");
                                        java.lang.System.
                                          out.
                                          println(
                                            "m                     Display current ROM mapping");
                                        java.lang.System.
                                          out.
                                          println(
                                            "q                     Quit debugger interface");
                                        java.lang.System.
                                          out.
                                          println(
                                            "<CTRL> + C            Quit JavaBoy");
    }
    public void hexDump(int address, int length) {
        int start =
          address &
          65520;
        int lines =
          length /
          16;
        if (lines ==
              0)
            lines =
              1;
        for (int l =
               0;
             l <
               lines;
             l++) {
            java.lang.System.
              out.
              print(
                JavaBoy.
                  hexWord(
                    start +
                      l *
                      16) +
                "   ");
            for (int r =
                   start +
                   l *
                   16;
                 r <
                   start +
                   l *
                   16 +
                   16;
                 r++) {
                java.lang.System.
                  out.
                  print(
                    JavaBoy.
                      hexByte(
                        unsign(
                          dmgcpu.
                            addressRead(
                              r))) +
                    " ");
            }
            java.lang.System.
              out.
              print(
                "   ");
            for (int r =
                   start +
                   l *
                   16;
                 r <
                   start +
                   l *
                   16 +
                   16;
                 r++) {
                char c =
                  (char)
                    dmgcpu.
                    addressRead(
                      r);
                if (c >=
                      32 &&
                      c <=
                      128) {
                    java.lang.System.
                      out.
                      print(
                        c);
                }
                else {
                    java.lang.System.
                      out.
                      print(
                        ".");
                }
            }
            java.lang.System.
              out.
              println(
                "");
        }
    }
    public void showRegisterValues() { java.lang.System.
                                         out.
                                         println(
                                           "- Register values");
                                       java.lang.System.
                                         out.
                                         print(
                                           "A = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 a) +
                                           "    BC = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 b) +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 c));
                                       java.lang.System.
                                         out.
                                         print(
                                           "    DE = " +
                                           JavaBoy.
                                             hexByte(
                                               dmgcpu.
                                                 d) +
                                           JavaBoy.
                                             hexByte(
                                               dmgcpu.
                                                 e));
                                       java.lang.System.
                                         out.
                                         print(
                                           "    HL = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 hl));
                                       java.lang.System.
                                         out.
                                         print(
                                           "    PC = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 pc));
                                       java.lang.System.
                                         out.
                                         println(
                                           "    SP = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 sp));
                                       java.lang.System.
                                         out.
                                         println(
                                           "F = " +
                                           JavaBoy.
                                             hexByte(
                                               unsign(
                                                 (short)
                                                   dmgcpu.
                                                     f)));
    }
    public void getDebuggerMenuChoice() {
        java.lang.String command =
          new java.lang.String(
          "");
        char b =
          0;
        if (dmgcpu !=
              null)
            dmgcpu.
              terminate =
              false;
        if (!debuggerActive) {
            if (debuggerPending) {
                debuggerPending =
                  false;
                executeDebuggerCommand(
                  debuggerQueue);
            }
        }
        else {
            java.lang.System.
              out.
              println(
                );
            java.lang.System.
              out.
              print(
                "Enter command (\'?\' for help)> ");
            while (b !=
                     10 &&
                     appletRunning) {
                try {
                    b =
                      (char)
                        java.lang.System.
                          in.
                        read(
                          );
                }
                catch (java.io.IOException e) {
                    
                }
                if (b >=
                      32)
                    command =
                      command +
                      b;
            }
        }
        if (appletRunning)
            executeDebuggerCommand(
              command);
    }
    public void executeDebuggerScript(java.lang.String fn) {
        java.io.InputStream is =
          null;
        java.io.BufferedReader in =
          null;
        try {
            if (JavaBoy.
                  runningAsApplet) {
                is =
                  new java.net.URL(
                    getDocumentBase(
                      ),
                    fn).
                    openStream(
                      );
            }
            else {
                is =
                  new java.io.FileInputStream(
                    new java.io.File(
                      fn));
            }
            in =
              new java.io.BufferedReader(
                new java.io.InputStreamReader(
                  is));
            java.lang.String line;
            while ((line =
                      in.
                        readLine(
                          )) !=
                     null &&
                     !dmgcpu.
                        terminate &&
                     appletRunning) {
                executeDebuggerCommand(
                  line);
            }
            in.
              close(
                );
        }
        catch (java.io.IOException e) {
            java.lang.System.
              out.
              println(
                "Can\'t open script file \'" +
                fn +
                "\'!");
        }
    }
    public void queueDebuggerCommand(java.lang.String command) {
        debuggerQueue =
          command;
        debuggerPending =
          true;
    }
    public void executeDebuggerCommand(java.lang.String commands) {
        java.util.StringTokenizer commandTokens =
          new java.util.StringTokenizer(
          commands,
          ";");
        while (commandTokens.
                 hasMoreTokens(
                   )) {
            executeSingleDebuggerCommand(
              commandTokens.
                nextToken(
                  ));
        }
    }
    public void setupKeyboard() { if (!keyListener) {
                                      if (!runningAsApplet) {
                                          java.lang.System.
                                            out.
                                            println(
                                              "Starting key controls");
                                          mainWindow.
                                            addKeyListener(
                                              this);
                                          mainWindow.
                                            requestFocus(
                                              );
                                      }
                                      else {
                                          addKeyListener(
                                            this);
                                      }
                                      keyListener =
                                        true;
                                  } }
    public void executeSingleDebuggerCommand(java.lang.String command) {
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          command,
          " \n");
        try {
            switch (st.
                      nextToken(
                        ).
                      charAt(
                        0)) {
                case '?':
                    displayDebuggerHelp(
                      );
                    break;
                case 'd':
                    try {
                        int address =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Dumping " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from " +
                            JavaBoy.
                              hexWord(
                                address));
                        hexDump(
                          address,
                          length);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'d\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'i':
                    try {
                        int address =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Dissasembling " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from " +
                            JavaBoy.
                              hexWord(
                                address));
                        dmgcpu.
                          disassemble(
                            address,
                            length);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'i\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'p':
                    try {
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Dissasembling " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from program counter (" +
                            JavaBoy.
                              hexWord(
                                dmgcpu.
                                  pc) +
                            ")");
                        dmgcpu.
                          disassemble(
                            dmgcpu.
                              pc,
                            length);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'p\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'k':
                    try {
                        java.lang.String keyName =
                          st.
                          nextToken(
                            );
                        dmgcpu.
                          ioHandler.
                          toggleKey(
                            keyName);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'k\' command.");
                    }
                    break;
                case 'r':
                    try {
                        java.lang.String reg =
                          st.
                          nextToken(
                            );
                        try {
                            int val =
                              java.lang.Integer.
                              valueOf(
                                st.
                                  nextToken(
                                    ),
                                16).
                              intValue(
                                );
                            if (dmgcpu.
                                  setRegister(
                                    reg,
                                    val)) {
                                java.lang.System.
                                  out.
                                  println(
                                    "- Set register " +
                                    reg +
                                    " to " +
                                    JavaBoy.
                                      hexWord(
                                        val) +
                                    ".");
                            }
                            else {
                                java.lang.System.
                                  out.
                                  println(
                                    "Invalid register name \'" +
                                    reg +
                                    "\'.");
                            }
                        }
                        catch (java.util.NoSuchElementException e) {
                            java.lang.System.
                              out.
                              println(
                                "Missing value");
                        }
                        catch (java.lang.NumberFormatException e) {
                            java.lang.System.
                              out.
                              println(
                                "Error parsing hex value.");
                        }
                    }
                    catch (java.util.NoSuchElementException e) {
                        showRegisterValues(
                          );
                    }
                    break;
                case 's':
                    java.lang.System.
                      out.
                      println(
                        "- CPU Reset");
                    dmgcpu.
                      reset(
                        );
                    break;
                case 'o':
                    repaint(
                      );
                    break;
                case 'c':
                    try {
                        java.lang.String fn =
                          st.
                          nextToken(
                            );
                        java.lang.System.
                          out.
                          println(
                            "* Starting execution of script \'" +
                            fn +
                            "\'");
                        executeDebuggerScript(
                          fn);
                        java.lang.System.
                          out.
                          println(
                            "* Script execution finished");
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "* Starting execution of default script");
                        executeDebuggerScript(
                          "default.scp");
                        java.lang.System.
                          out.
                          println(
                            "* Script execution finished");
                    }
                    break;
                case 'q':
                    cartridge.
                      restoreMapping(
                        );
                    java.lang.System.
                      out.
                      println(
                        "- Quitting debugger");
                    deactivateDebugger(
                      );
                    break;
                case 'e':
                    int address;
                    try {
                        address =
                          java.lang.Integer.
                            valueOf(
                              st.
                                nextToken(
                                  ),
                              16).
                            intValue(
                              );
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                        break;
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Missing address.");
                        break;
                    }
                    java.lang.System.
                      out.
                      print(
                        "- Written data starting at " +
                        JavaBoy.
                          hexWord(
                            address) +
                        " (");
                    if (!st.
                          hasMoreTokens(
                            )) {
                        java.lang.System.
                          out.
                          println(
                            "");
                        java.lang.System.
                          out.
                          println(
                            "Missing data value(s)");
                        break;
                    }
                    try {
                        while (st.
                                 hasMoreTokens(
                                   )) {
                            short data =
                              (byte)
                                java.lang.Integer.
                                valueOf(
                                  st.
                                    nextToken(
                                      ),
                                  16).
                                intValue(
                                  );
                            dmgcpu.
                              addressWrite(
                                address++,
                                data);
                        }
                        java.lang.System.
                          out.
                          println(
                            ")");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "");
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'b':
                    try {
                        if (breakpointAddr !=
                              -1) {
                            cartridge.
                              saveMapping(
                                );
                            cartridge.
                              mapRom(
                                breakpointBank);
                            dmgcpu.
                              addressWrite(
                                breakpointAddr,
                                breakpointInstr);
                            cartridge.
                              restoreMapping(
                                );
                            breakpointAddr =
                              -1;
                            java.lang.System.
                              out.
                              println(
                                "- Clearing original breakpoint");
                            dmgcpu.
                              setBreakpoint(
                                false);
                        }
                        int addr =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Setting breakpoint at " +
                            JavaBoy.
                              hexWord(
                                addr));
                        breakpointAddr =
                          (short)
                            addr;
                        breakpointInstr =
                          (short)
                            dmgcpu.
                            addressRead(
                              addr);
                        breakpointBank =
                          (short)
                            cartridge.
                              currentBank;
                        dmgcpu.
                          addressWrite(
                            addr,
                            82);
                        dmgcpu.
                          setBreakpoint(
                            true);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'b\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'g':
                    setupKeyboard(
                      );
                    cartridge.
                      restoreMapping(
                        );
                    dmgcpu.
                      execute(
                        -1);
                    break;
                case 'n':
                    try {
                        int state =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        if (state ==
                              1) {
                            dmgcpu.
                              interruptsEnabled =
                              true;
                        }
                        else {
                            dmgcpu.
                              interruptsEnabled =
                              false;
                        }
                    }
                    catch (java.util.NoSuchElementException e) {
                        
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    java.lang.System.
                      out.
                      print(
                        "- Interrupts are ");
                    if (dmgcpu.
                          interruptsEnabled)
                        java.lang.System.
                          out.
                          println(
                            "enabled.");
                    else
                        java.lang.System.
                          out.
                          println(
                            "disabled.");
                    break;
                case 'm':
                    try {
                        int bank =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Mapping ROM bank " +
                            JavaBoy.
                              hexByte(
                                bank) +
                            " to 4000 - 7FFFF");
                        cartridge.
                          saveMapping(
                            );
                        cartridge.
                          mapRom(
                            bank);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "- ROM Mapper state:");
                        java.lang.System.
                          out.
                          println(
                            cartridge.
                              getMapInfo(
                                ));
                    }
                    break;
                case 't':
                    try {
                        cartridge.
                          restoreMapping(
                            );
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Executing " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from program counter (" +
                            JavaBoy.
                              hexWord(
                                dmgcpu.
                                  pc) +
                            ")");
                        dmgcpu.
                          execute(
                            length);
                        if (dmgcpu.
                              pc ==
                              breakpointAddr) {
                            dmgcpu.
                              addressWrite(
                                breakpointAddr,
                                breakpointInstr);
                            breakpointAddr =
                              -1;
                            java.lang.System.
                              out.
                              println(
                                "- Breakpoint instruction restored");
                        }
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "- Executing instruction at program counter (" +
                            JavaBoy.
                              hexWord(
                                dmgcpu.
                                  pc) +
                            ")");
                        dmgcpu.
                          execute(
                            1);
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                default:
                    java.lang.System.
                      out.
                      println(
                        "Command not recognized.  Try looking at the help page.");
            }
        }
        catch (java.util.NoSuchElementException e) {
            
        }
    }
    public void windowClosed(java.awt.event.WindowEvent e) {
        
    }
    public void windowClosing(java.awt.event.WindowEvent e) {
        dispose(
          );
        java.lang.System.
          exit(
            0);
    }
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowIconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowOpened(java.awt.event.WindowEvent e) {
        
    }
    public void windowActivated(java.awt.event.WindowEvent e) {
        
    }
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        
    }
    public JavaBoy() { super(); }
    public JavaBoy(java.lang.String cartName) {
        super(
          );
    }
    public void einit() { mainWindow = new GameBoyScreen(
                                         "JavaBoy " +
                                         versionString,
                                         this);
                          mainWindow.init(
                                       );
                          mainWindow.setVisible(
                                       true);
                          this.requestFocus(
                                 );
                          mainWindow.addWindowListener(
                                       this);
    }
    public static void main(java.lang.String[] args) {
        java.lang.System.
          out.
          println(
            "JavaBoy (tm) Version " +
            versionString +
            " (c) 2005 Neil Millstone (application)");
        runningAsApplet =
          false;
        JavaBoy djavaBoy =
          new JavaBoy(
          "");
        JavaBoy javaBoy =
          djavaBoy;
        javaBoy.
          einit(
            );
        if (args.
              length >
              0) {
            if (args[0].
                  equals(
                    "server")) {
                javaBoy.
                  gameLink =
                  new TCPGameLink(
                    null);
            }
            else
                if (args[0].
                      equals(
                        "client")) {
                    javaBoy.
                      gameLink =
                      new TCPGameLink(
                        null,
                        args[1]);
                }
        }
        java.lang.Thread p =
          new java.lang.Thread(
          javaBoy);
        p.
          start(
            );
    }
    public void start() { java.lang.Thread p =
                            new java.lang.Thread(
                            this);
                          runningAsApplet =
                            true;
                          setupKeyboard();
                          java.lang.System.
                            out.println("JavaBoy (tm) Version " +
                                        versionString +
                                        " (c) 2005 Neil Millstone (applet)");
                          cartridge = new Cartridge(
                                        getParameter(
                                          "ROMIMAGE"),
                                        this);
                          dmgcpu = new Dmgcpu(
                                     cartridge,
                                     null,
                                     this);
                          dmgcpu.graphicsChip.
                            setMagnify(
                              getSize(
                                ).
                                width /
                                160);
                          this.requestFocus(
                                 );
                          p.start();
                          saveToWebEnable =
                            getParameter(
                              "SAVERAMURL") !=
                              null;
                          popupMenu = new java.awt.PopupMenu(
                                        );
                          popupMenu.add("JavaBoy " +
                                        versionString);
                          popupMenu.add("-");
                          popupMenu.add("Define Controls");
                          popupMenu.add(soundCheck =
                                          new java.awt.CheckboxMenuItem(
                                            "Sound"));
                          popupMenu.add("-");
                          popupMenu.add("Reset");
                          if (saveToWebEnable) {
                              popupMenu.
                                add(
                                  "Save");
                              popupMenu.
                                add(
                                  "Load");
                          }
                          popupMenu.add("-");
                          popupMenu.add("Size: 1x");
                          popupMenu.add("Size: 2x");
                          popupMenu.add("Size: 3x");
                          popupMenu.add("Size: 4x");
                          popupMenu.add("-");
                          popupMenu.add("FrameSkip: 0");
                          popupMenu.add("FrameSkip: 1");
                          popupMenu.add("FrameSkip: 2");
                          popupMenu.add("FrameSkip: 3");
                          popupMenu.add("-");
                          popupMenu.add("JavaBoy Website");
                          popupMenu.addActionListener(
                                      this);
                          soundCheck.addItemListener(
                                       this);
                          setSoundEnable(
                            getParameter(
                              "SOUND") ==
                              null ||
                              getParameter(
                                "SOUND").
                              equals(
                                "ON"));
                          addMouseListener(
                            this);
                          add(popupMenu);
                          cartridge.outputCartInfo(
                                      ); }
    public void run() { if (runningAsApplet) {
                            java.lang.System.
                              out.
                              println(
                                "Starting...");
                            do  {
                                dmgcpu.
                                  reset(
                                    );
                                dmgcpu.
                                  execute(
                                    -1);
                            }while(appletRunning); 
                        }
                        do  { try { getDebuggerMenuChoice(
                                      );
                                    java.lang.Thread.
                                      sleep(
                                        1);
                                    this.
                                      requestFocus(
                                        );
                              }
                              catch (java.lang.InterruptedException e) {
                                  java.lang.System.
                                    out.
                                    println(
                                      "Interrupted!");
                                  break;
                              } }while(appletRunning); 
                        dispose();
                        java.lang.System.
                          out.println("Thread terminated");
    }
    public void dispose() { if (cartridge !=
                                  null) cartridge.
                                          dispose(
                                            );
                            if (dmgcpu !=
                                  null) dmgcpu.
                                          dispose(
                                            );
    }
    public void init() { requestFocus();
                         doubleBuffer = createImage(
                                          getSize(
                                            ).
                                            width,
                                          getSize(
                                            ).
                                            height);
    }
    public void stop() { java.lang.System.
                           out.println("Applet stopped");
                         appletRunning = false;
                         if (dmgcpu != null)
                             dmgcpu.
                               terminate =
                               true; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457189885000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        JavaBoy ENT_ld =
          new JavaBoy(
          );
        ENT_ld.
          HACK =
          this.
            HACK;
        ENT_ld.
          appletRunning =
          this.
            appletRunning;
        ENT_ld.
          backBuffer =
          this.
            backBuffer;
        ENT_ld.
          gameRunning =
          this.
            gameRunning;
        ENT_ld.
          fullFrame =
          this.
            fullFrame;
        ENT_ld.
          saveToWebEnable =
          this.
            saveToWebEnable;
        ENT_ld.
          cartridge =
          this.
            cartridge;
        ENT_ld.
          dmgcpu =
          this.
            dmgcpu;
        ENT_ld.
          graphicsChip =
          this.
            graphicsChip;
        ENT_ld.
          gameLink =
          this.
            gameLink;
        ENT_ld.
          breakpointInstr =
          this.
            breakpointInstr;
        ENT_ld.
          breakpointAddr =
          this.
            breakpointAddr;
        ENT_ld.
          breakpointBank =
          this.
            breakpointBank;
        ENT_ld.
          mainWindow =
          this.
            mainWindow;
        ENT_ld.
          debuggerQueue =
          this.
            debuggerQueue;
        ENT_ld.
          debuggerPending =
          this.
            debuggerPending;
        ENT_ld.
          debuggerActive =
          this.
            debuggerActive;
        ENT_ld.
          doubleBuffer =
          this.
            doubleBuffer;
        ENT_ld.
          keyListener =
          this.
            keyListener;
        ENT_ld.
          soundCheck =
          this.
            soundCheck;
        ENT_ld.
          imageSizeChanged =
          this.
            imageSizeChanged;
        ENT_ld.
          stripTimer =
          this.
            stripTimer;
        ENT_ld.
          popupMenu =
          this.
            popupMenu;
        ENT_ld.
          lastClickTime =
          this.
            lastClickTime;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457189885000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dutFo7+gCumoj8Ux0ZlHTT9qrvjWrJgW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "PLdHWW7+Pw88L5gwO8gmzA7eeaJ5Cucwve35shcDhttZ7oMrmuU+SeSCqbKD" +
       "bKrs4AfD3J2Kbuu7zu/tzJQdnnJ9sD1P7eDUeWoXELuFr8w/vqZxwZzZQTZn" +
       "dvDPwtwd2YKlHYa3PVWWVd12Pc/Braznucmqu2Aq7ODDWfCvsxMWQ8Hfrbrb" +
       "ngd7JJe748WbvJv/V0vs31zw7KNZ8Ith7sCPduvr0tOkL6P1UkCntKVVunpa" +
       "v3nBs+x424OPh7m7s3khJ9gZVx/82u1SexGghGypIVdP7bMXPPvdLPgPYfYD" +
       "cKeMyO9cBa83bHm94ep5/ckFz/40C/4T4BWEzs601sEf3gav9erR7Di7G1eP" +
       "3qnc3OrR3WWu6wjJcZPNKtLtb9Stl1WuH5ny9jTyk0+evH79+lNPf+01ZSmY" +
       "T25SbZeINtA+SB9qerC+PzPRDb+TcJj6hsgzsx3/FMBhnuOYMzOcOJH/MMeJ" +
       "qDOzHJ2Vf5jhKOLM5Dtn2B9m2ok+M+vRwcuHmY4izky+OQj5MO3m09mkT5xB" +
       "fMT6RNy5ksrOBT4ppuzz2fVw48G9R5VxY/QlWbNjdE/nzGIvyZgddHs6YxZ7" +
       "Zsbjo2gPMx3HnC3ok+fCHsn7ZOSF2bYHt+5m3EZfmHVztupuzk3s2RlPnH56" +
       "lO1E3JmZTpwDepjnRNTZWn50TOeRgh/FnJlh95zMw2y78We/7egsy6O3HcWc" +
       "meHopMnD9EcRZya/4cDHwyw3RGbZDleZH2d8+rmvLD/4i4tWlh9ccKT8QXak" +
       "/MGfhbl7Ds101pN8+Lgn+fNb6Uni4x8hdY9OLd+ey7k2v9c3PwETb2abXn6y" +
       "A1rvNHnksrcdZTn5w5XZzzysfwH58CcZos1vID8j/fR7e9Rbv1z9sc0PZ0qm" +
       "kKZZKfcQubs3v+G5LjT7WYdXn1vaYVl3dZ/6mwc/dO/rDndjPLgBfFxbJ7C9" +
       "6uxfqWxbbrhuCulHXvZz3/Av3/vH61/b+v9dRFKSmnoAAA==");
}
