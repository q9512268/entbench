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
    public void einit() { mainWindow = (GameBoyScreen)
                                         ent.runtime.ENT_Runtime.
                                         putObj(
                                           new GameBoyScreen(
                                             "JavaBoy " +
                                             versionString,
                                             this),
                                           new java.lang.Integer[] { ent.runtime.ENT_Runtime.
                                             getObjMode(
                                               this,
                                               0) });
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
          (JavaBoy)
            ent.runtime.ENT_Runtime.
            putObj(
              new JavaBoy(
                ""),
              new java.lang.Integer[] { EntMode.
                                          DYNAMIC_MODE });
        JavaBoy javaBoy =
          ent.runtime.ENT_Snapshot.
          snapshot(
            djavaBoy,
            EntMode.
              LOW_MODE,
            EntMode.
              HIGH_MODE,
            true);
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
                        mainWindow.actionPerformed(
                                     new java.awt.event.ActionEvent(
                                       this,
                                       0,
                                       "Open ROM"));
                        mainWindow.actionPerformed(
                                     new java.awt.event.ActionEvent(
                                       this,
                                       0,
                                       "Reset"));
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
      1470153778000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DDiRA3k61z6868A7f2Bm/x8GwMld02QAAA==");
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
      1470153778000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV9CbQsSVlm3Xt7p7tf0+wt3TzoRru79GUtWVVZNltWZlXl" +
       "UllL1poJ2OaeWblWrlXFMAIy0yiKHG0d3JA5ojMiKuKGODLMQVw5jHBwwZFl" +
       "GM64MIxwjuIcUZzIqrrLq7u91+/2PSejsiIjIr/vjz/++CNuRNR7v5y5OfAz" +
       "Wc+1FprlhleUeXhlapWuhAtPCa5QrVJX8ANFxiwhCAYg7nHpJe+79LWvv12/" +
       "ZzdzC595luA4biiEhusErBK4VqzIrcylw9i6pdhBmLmnNRViAYpCw4JaRhA+" +
       "1so840jWMPNQax8CBCBAAAK0ggChh6lAprsUJ7KxNIfghMEs828zO63MLZ6U" +
       "wgszL766EE/wBXtTTHfFAJRwW/p9BEitMs/9zOUD7mvOxwj/cBZ68j98xz3v" +
       "38tc4jOXDKefwpEAiBC8hM/caSu2qPgBKsuKzGee6SiK3Fd8Q7CM5Qo3n7k3" +
       "MDRHCCNfORBSGhl5ir9656Hk7pRSbn4kha5/QE81FEve/3azagka4PrcQ65r" +
       "ho00HhC8wwDAfFWQlP0sN5mGI4eZF23nOOD4EA0SgKy32kqouwevuskRQETm" +
       "3nXdWYKjQf3QNxwNJL3ZjcBbwsx9pxaaytoTJFPQlMfDzPO303XXj0Cq21eC" +
       "SLOEmedsJ1uVBGrpvq1aOlI/X26/7G2vcwhnd4VZViQrxX8byPTAViZWURVf" +
       "cSRlnfHOR1s/Ijz3t9+ym8mAxM/ZSrxO8xv/5quv+tYHPvz76zTfdEKajjhV" +
       "pPBx6d3i3Z94IfZIdS+FcZvnBkZa+VcxX6l/d/PksbkHWt5zD0pMH17Zf/hh" +
       "9ne5N7xH+dJu5g4yc4vkWpEN9OiZkmt7hqX4TcVRfCFUZDJzu+LI2Oo5mbkV" +
       "3LcMR1nHdlQ1UEIyc5O1irrFXX0HIlJBEamIbgX3hqO6+/eeEOqr+7mXyWRu" +
       "BVfmHeAKMuu/1WeYQSHdtRVIkATHcFyo67sp/wBSnFAEstUhz3h8fZOqjegu" +
       "oMCXIArc19zFlTTOu4hC5inSe5KdHSDEF243YQtoP+FasuI/Lj0Z1epf/cXH" +
       "/2j3QKU3HMPMrZsCMzs7q3KenRa8rgggRhM0SGCq7nyk/1rqO9/ykj2gAV5y" +
       "E5DBLkgKnW4xscMmTK4MlQT0KPPhdyRvHH1Xbjeze7XpS8GAqDvS7N3UYB0Y" +
       "poe2Vf6kci898ddf+6Ufeb17qPxX2dJNmzyeM21TL9kWm+9Kigys1GHxj14W" +
       "fu3x3379Q7uZm0BDBcYpFIAygXb/wPY7rmpbj+3bqZTLzYCw6vq2YKWP9o3L" +
       "HaHuu8lhzKo+717dPxPI+LZU2S5lMnu/tFa+9Wf69FleGj57Xf9ppW2xWNnB" +
       "l/e9n/zzj/9NcSXufZN56Ugn1FfCx44007SwS6sG+cxDHRj4igLSfeYd3R/6" +
       "4S8/8eqVAoAUD570wofSEAPNE1QhEPO/+/3Zpz/32Xd/avdAaXZC0E9FomVI" +
       "8wOSO5l1OzuVJHjbNx/iAc3cAq0k1ZqHho7tyoZqCKKlpFr6z5demv+1//O2" +
       "e9Z6YIGYfTX61vMLOIx/QS3zhj/6jn98YFXMjpR2M4cyO0y2tl3POiwZ9X1h" +
       "keKYv/GT9//o7wk/CawgsDyBsVRWxiSzkkFmVWnQiv+jq/DK1rN8GrwoOKr8" +
       "V7evI+7A49LbP/WVu0Zf+dBXV2iv9ieO1jUjeI+t1SsNLs9B8c/bbumEEOgg" +
       "Hfzh9mvusT78dVAiD0qUQCcadHxgR+ZXacYm9c23/sV/+8hzv/MTe5ndRuYO" +
       "yxXkhrBqZJnbgXYrgQ5M0Nx75avWtZukOn3PimrmGPlVxH3H1f9XNprxKyer" +
       "fxq+OA1eelypTsu6Jf6dtXquvj8HeGorlmlnf2Xd2a/e9Ioz6qyWBtXVo0Ia" +
       "fPuaTOmaeK/TPn/17SFQMY+cblcbqRt0aJqe/08dS3zTF/7fscpfWdQTev+t" +
       "/Dz03p+4D3vFl1b5D01bmvuB+fE+BbiMh3kL77H/Yfclt3x0N3Mrn7lH2vij" +
       "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" +
       "5gtsTtezDAvkbzVbeZqMjaoRlvyZzFbg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "9Wtc/x/qtqpE8noAAA==");
}
