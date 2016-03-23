class GameBoyScreen extends java.awt.Frame implements java.awt.event.ActionListener, java.awt.event.ComponentListener, java.awt.event.ItemListener {
    GraphicsChip graphicsChip = null;
    JavaBoy applet;
    java.awt.CheckboxMenuItem viewFrameCounter;
    java.awt.CheckboxMenuItem viewSpeedThrottle;
    java.awt.CheckboxMenuItem viewFrameSkip0;
    java.awt.CheckboxMenuItem viewFrameSkip1;
    java.awt.CheckboxMenuItem viewFrameSkip2;
    java.awt.CheckboxMenuItem viewFrameSkip3;
    java.awt.CheckboxMenuItem viewFrameSkip4;
    java.awt.CheckboxMenuItem soundChannel1Enable;
    java.awt.CheckboxMenuItem soundChannel2Enable;
    java.awt.CheckboxMenuItem soundChannel3Enable;
    java.awt.CheckboxMenuItem soundChannel4Enable;
    java.awt.CheckboxMenuItem soundFreq11;
    java.awt.CheckboxMenuItem soundFreq22;
    java.awt.CheckboxMenuItem soundFreq44;
    java.awt.CheckboxMenuItem soundBuffer200;
    java.awt.CheckboxMenuItem soundBuffer300;
    java.awt.CheckboxMenuItem soundBuffer400;
    java.awt.CheckboxMenuItem networkServer;
    java.awt.CheckboxMenuItem fileGameboyColor;
    java.awt.CheckboxMenuItem viewSingle;
    java.awt.CheckboxMenuItem viewDouble;
    java.awt.CheckboxMenuItem viewTriple;
    java.awt.CheckboxMenuItem viewQuadrouple;
    java.awt.CheckboxMenuItem view5;
    java.awt.CheckboxMenuItem view6;
    java.awt.CheckboxMenuItem networkPrinter;
    java.awt.TextField hostAddress;
    java.awt.Dialog connectDialog;
    java.awt.CheckboxMenuItem[] schemes = new java.awt.CheckboxMenuItem[JavaBoy.
                                                                          schemeNames.
                                                                          length];
    int viewSetting = 4;
    public GameBoyScreen(java.lang.String s, JavaBoy a) { super(s);
                                                          applet =
                                                            a;
                                                          this.addComponentListener(
                                                                 this);
                                                          java.awt.MenuBar menuBar =
                                                            new java.awt.MenuBar(
                                                            );
                                                          java.awt.MenuItem fileOpen =
                                                            new java.awt.MenuItem(
                                                            "Open ROM");
                                                          fileOpen.
                                                            setActionCommand(
                                                              "Open ROM");
                                                          fileOpen.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem fileEmulate =
                                                            new java.awt.MenuItem(
                                                            "Emulate");
                                                          fileEmulate.
                                                            setActionCommand(
                                                              "Emulate");
                                                          fileEmulate.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem fileReset =
                                                            new java.awt.MenuItem(
                                                            "Reset");
                                                          fileReset.
                                                            setActionCommand(
                                                              "Reset");
                                                          fileReset.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem filePause =
                                                            new java.awt.MenuItem(
                                                            "Pause");
                                                          filePause.
                                                            setActionCommand(
                                                              "Pause");
                                                          filePause.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem fileControls =
                                                            new java.awt.MenuItem(
                                                            "Define controls...");
                                                          fileControls.
                                                            setActionCommand(
                                                              "Controls");
                                                          fileControls.
                                                            addActionListener(
                                                              this);
                                                          fileGameboyColor =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Use Gameboy Color features");
                                                          fileGameboyColor.
                                                            addItemListener(
                                                              this);
                                                          fileGameboyColor.
                                                            setState(
                                                              true);
                                                          java.awt.MenuItem fileQuit =
                                                            new java.awt.MenuItem(
                                                            "Exit");
                                                          fileQuit.
                                                            setActionCommand(
                                                              "Exit");
                                                          fileQuit.
                                                            addActionListener(
                                                              this);
                                                          viewSingle =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: actual");
                                                          viewSingle.
                                                            addItemListener(
                                                              this);
                                                          viewDouble =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 2x");
                                                          viewDouble.
                                                            addItemListener(
                                                              this);
                                                          viewTriple =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 3x");
                                                          viewTriple.
                                                            addItemListener(
                                                              this);
                                                          viewQuadrouple =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 4x");
                                                          viewQuadrouple.
                                                            addItemListener(
                                                              this);
                                                          view5 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 5x");
                                                          view5.
                                                            addItemListener(
                                                              this);
                                                          view6 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 6x");
                                                          view6.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip0 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 0");
                                                          viewFrameSkip0.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip1 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 1");
                                                          viewFrameSkip1.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip2 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 2");
                                                          viewFrameSkip2.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip3 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 3");
                                                          viewFrameSkip3.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip4 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 4");
                                                          viewFrameSkip4.
                                                            addItemListener(
                                                              this);
                                                          viewFrameCounter =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame counter");
                                                          viewFrameCounter.
                                                            setActionCommand(
                                                              "Frame counter");
                                                          viewFrameCounter.
                                                            addActionListener(
                                                              this);
                                                          viewSpeedThrottle =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Speed throttle");
                                                          viewSpeedThrottle.
                                                            setActionCommand(
                                                              "Speed throttle");
                                                          viewSpeedThrottle.
                                                            addActionListener(
                                                              this);
                                                          viewSpeedThrottle.
                                                            setState(
                                                              true);
                                                          java.awt.CheckboxMenuItem viewStandardCols =
                                                            new java.awt.CheckboxMenuItem(
                                                            "Standard colours");
                                                          viewStandardCols.
                                                            addItemListener(
                                                              this);
                                                          viewStandardCols.
                                                            setState(
                                                              true);
                                                          java.awt.CheckboxMenuItem viewLcdCols =
                                                            new java.awt.CheckboxMenuItem(
                                                            "LCD shades");
                                                          viewLcdCols.
                                                            addItemListener(
                                                              this);
                                                          java.awt.CheckboxMenuItem viewGreenyCols =
                                                            new java.awt.CheckboxMenuItem(
                                                            "Greeny shades");
                                                          viewGreenyCols.
                                                            addItemListener(
                                                              this);
                                                          java.awt.MenuItem debugEnter =
                                                            new java.awt.MenuItem(
                                                            "Enter debugger");
                                                          debugEnter.
                                                            setActionCommand(
                                                              "Enter debugger");
                                                          debugEnter.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem debugExecuteScript =
                                                            new java.awt.MenuItem(
                                                            "Execute script");
                                                          debugExecuteScript.
                                                            setActionCommand(
                                                              "Execute script");
                                                          debugExecuteScript.
                                                            addActionListener(
                                                              this);
                                                          soundChannel1Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 1 (Square wave)");
                                                          soundChannel1Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel1Enable.
                                                            setState(
                                                              true);
                                                          soundChannel2Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 2 (Square wave)");
                                                          soundChannel2Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel2Enable.
                                                            setState(
                                                              true);
                                                          soundChannel3Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 3 (Voluntary wave)");
                                                          soundChannel3Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel3Enable.
                                                            setState(
                                                              true);
                                                          soundChannel4Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 4 (Noise)");
                                                          soundChannel4Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel4Enable.
                                                            setState(
                                                              true);
                                                          soundFreq11 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Sample rate: 11khz");
                                                          soundFreq11.
                                                            addItemListener(
                                                              this);
                                                          soundFreq22 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Sample rate: 22khz");
                                                          soundFreq22.
                                                            addItemListener(
                                                              this);
                                                          soundFreq44 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Sample rate: 44khz");
                                                          soundFreq44.
                                                            addItemListener(
                                                              this);
                                                          soundFreq44.
                                                            setState(
                                                              true);
                                                          soundBuffer200 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Buffer length: 200ms");
                                                          soundBuffer200.
                                                            addItemListener(
                                                              this);
                                                          soundBuffer200.
                                                            setState(
                                                              true);
                                                          soundBuffer300 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Buffer length: 300ms");
                                                          soundBuffer300.
                                                            addItemListener(
                                                              this);
                                                          soundBuffer400 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Buffer length: 400ms");
                                                          soundBuffer400.
                                                            addItemListener(
                                                              this);
                                                          java.awt.MenuItem networkConnect =
                                                            new java.awt.MenuItem(
                                                            "Connect to client");
                                                          networkConnect.
                                                            setActionCommand(
                                                              "Connect to client");
                                                          networkConnect.
                                                            addActionListener(
                                                              this);
                                                          networkServer =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Allow connections");
                                                          networkServer.
                                                            addItemListener(
                                                              this);
                                                          networkPrinter =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Emulate printer");
                                                          networkPrinter.
                                                            addItemListener(
                                                              this);
                                                          java.awt.Menu fileMenu =
                                                            new java.awt.Menu(
                                                            "File");
                                                          java.awt.Menu viewMenu =
                                                            new java.awt.Menu(
                                                            "View");
                                                          java.awt.Menu soundMenu =
                                                            new java.awt.Menu(
                                                            "Sound");
                                                          java.awt.Menu networkMenu =
                                                            new java.awt.Menu(
                                                            "Serial Port");
                                                          java.awt.Menu debugMenu =
                                                            new java.awt.Menu(
                                                            "Debug");
                                                          fileMenu.
                                                            add(
                                                              fileOpen);
                                                          fileMenu.
                                                            add(
                                                              fileReset);
                                                          fileMenu.
                                                            add(
                                                              filePause);
                                                          fileMenu.
                                                            add(
                                                              fileEmulate);
                                                          fileMenu.
                                                            add(
                                                              fileGameboyColor);
                                                          fileMenu.
                                                            add(
                                                              fileControls);
                                                          fileMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          fileMenu.
                                                            add(
                                                              fileQuit);
                                                          viewMenu.
                                                            add(
                                                              viewSingle);
                                                          viewMenu.
                                                            add(
                                                              viewDouble);
                                                          viewMenu.
                                                            add(
                                                              viewTriple);
                                                          viewMenu.
                                                            add(
                                                              viewQuadrouple);
                                                          viewMenu.
                                                            add(
                                                              view5);
                                                          viewMenu.
                                                            add(
                                                              view6);
                                                          viewMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip0);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip1);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip2);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip3);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip4);
                                                          viewMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          viewMenu.
                                                            add(
                                                              viewFrameCounter);
                                                          viewMenu.
                                                            add(
                                                              viewSpeedThrottle);
                                                          viewMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          for (int r =
                                                                 0;
                                                               r <
                                                                 JavaBoy.
                                                                   schemeNames.
                                                                   length;
                                                               r++) {
                                                              schemes[r] =
                                                                new java.awt.CheckboxMenuItem(
                                                                  JavaBoy.
                                                                    schemeNames[r]);
                                                              schemes[r].
                                                                addItemListener(
                                                                  this);
                                                              viewMenu.
                                                                add(
                                                                  schemes[r]);
                                                              if (r ==
                                                                    0)
                                                                  schemes[r].
                                                                    setState(
                                                                      true);
                                                          }
                                                          soundMenu.
                                                            add(
                                                              soundChannel1Enable);
                                                          soundMenu.
                                                            add(
                                                              soundChannel2Enable);
                                                          soundMenu.
                                                            add(
                                                              soundChannel3Enable);
                                                          soundMenu.
                                                            add(
                                                              soundChannel4Enable);
                                                          soundMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          soundMenu.
                                                            add(
                                                              soundFreq11);
                                                          soundMenu.
                                                            add(
                                                              soundFreq22);
                                                          soundMenu.
                                                            add(
                                                              soundFreq44);
                                                          soundMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          soundMenu.
                                                            add(
                                                              soundBuffer200);
                                                          soundMenu.
                                                            add(
                                                              soundBuffer300);
                                                          soundMenu.
                                                            add(
                                                              soundBuffer400);
                                                          networkMenu.
                                                            add(
                                                              networkConnect);
                                                          networkMenu.
                                                            add(
                                                              networkServer);
                                                          networkMenu.
                                                            add(
                                                              networkPrinter);
                                                          debugMenu.
                                                            add(
                                                              debugEnter);
                                                          debugMenu.
                                                            add(
                                                              debugExecuteScript);
                                                          menuBar.
                                                            add(
                                                              fileMenu);
                                                          menuBar.
                                                            add(
                                                              viewMenu);
                                                          menuBar.
                                                            add(
                                                              soundMenu);
                                                          menuBar.
                                                            add(
                                                              networkMenu);
                                                          menuBar.
                                                            add(
                                                              debugMenu);
                                                          setMenuBar(
                                                            menuBar);
    }
    public void init() { setWindowSize(viewSetting);
                         setMagnify(); }
    public void makeConnectDialog() { connectDialog =
                                        new java.awt.Dialog(
                                          this,
                                          "Game Link connect",
                                          true);
                                      java.awt.Panel p1 =
                                        new java.awt.Panel(
                                        );
                                      java.awt.Panel p2 =
                                        new java.awt.Panel(
                                        );
                                      java.awt.Panel p3 =
                                        new java.awt.Panel(
                                        );
                                      p1.
                                        add(
                                          new java.awt.Label(
                                            "Host address:"),
                                          "Center");
                                      hostAddress =
                                        new java.awt.TextField(
                                          35);
                                      p2.
                                        add(
                                          hostAddress,
                                          "Center");
                                      java.awt.Button connectButton =
                                        new java.awt.Button(
                                        "Connect");
                                      connectButton.
                                        setActionCommand(
                                          "Connect ok");
                                      connectButton.
                                        addActionListener(
                                          this);
                                      java.awt.Button cancelButton =
                                        new java.awt.Button(
                                        "Cancel");
                                      cancelButton.
                                        setActionCommand(
                                          "Connect cancel");
                                      cancelButton.
                                        addActionListener(
                                          this);
                                      p3.
                                        add(
                                          cancelButton,
                                          "West");
                                      p3.
                                        add(
                                          connectButton,
                                          "East");
                                      connectDialog.
                                        add(
                                          p1,
                                          "North");
                                      connectDialog.
                                        add(
                                          p2,
                                          "Center");
                                      connectDialog.
                                        add(
                                          p3,
                                          "South");
                                      connectDialog.
                                        setSize(
                                          350,
                                          125);
                                      connectDialog.
                                        setResizable(
                                          false);
                                      connectDialog.
                                        show(
                                          );
    }
    public void setGraphicsChip(GraphicsChip g) {
        graphicsChip =
          g;
    }
    public void update(java.awt.Graphics g) {
        paint(
          g);
    }
    public void clearWindow() { java.awt.Dimension d =
                                  getSize(
                                    );
                                java.awt.Graphics g =
                                  getGraphics(
                                    );
                                g.setColor(
                                    new java.awt.Color(
                                      255,
                                      255,
                                      255));
                                g.fillRect(
                                    0,
                                    0,
                                    d.
                                      width,
                                    d.
                                      height);
    }
    public void componentHidden(java.awt.event.ComponentEvent e) {
        
    }
    public void componentMoved(java.awt.event.ComponentEvent e) {
        
    }
    public void componentResized(java.awt.event.ComponentEvent e) {
        clearWindow(
          );
    }
    public void componentShown(java.awt.event.ComponentEvent e) {
        
    }
    public void setWindowSize(int mag) { setSize(
                                           175 *
                                             mag +
                                             20,
                                           174 *
                                             mag +
                                             20);
    }
    public void setSoundFreq() { if (applet.
                                       dmgcpu !=
                                       null &&
                                       applet.
                                         dmgcpu.
                                         soundChip.
                                         soundEnabled) {
                                     if (soundFreq11.
                                           getState(
                                             )) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           setSampleRate(
                                             11025);
                                     }
                                     if (soundFreq22.
                                           getState(
                                             )) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           setSampleRate(
                                             22050);
                                     }
                                     if (soundFreq44.
                                           getState(
                                             )) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           setSampleRate(
                                             44100);
                                     }
                                 } }
    public void setBufferLength() { if (applet.
                                          dmgcpu !=
                                          null &&
                                          applet.
                                            dmgcpu.
                                            soundChip.
                                            soundEnabled) {
                                        if (soundBuffer200.
                                              getState(
                                                )) {
                                            applet.
                                              dmgcpu.
                                              soundChip.
                                              setBufferLength(
                                                200);
                                        }
                                        if (soundBuffer300.
                                              getState(
                                                )) {
                                            applet.
                                              dmgcpu.
                                              soundChip.
                                              setBufferLength(
                                                300);
                                        }
                                        if (soundBuffer400.
                                              getState(
                                                )) {
                                            applet.
                                              dmgcpu.
                                              soundChip.
                                              setBufferLength(
                                                400);
                                        }
                                    } }
    public void setChannelEnable() { if (applet.
                                           dmgcpu !=
                                           null &&
                                           applet.
                                             dmgcpu.
                                             soundChip.
                                             soundEnabled) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel1Enable =
                                           soundChannel1Enable.
                                             getState(
                                               );
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel2Enable =
                                           soundChannel2Enable.
                                             getState(
                                               );
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel3Enable =
                                           soundChannel3Enable.
                                             getState(
                                               );
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel4Enable =
                                           soundChannel4Enable.
                                             getState(
                                               );
                                     } }
    public void setMagnify() { if (applet.
                                     dmgcpu !=
                                     null) {
                                   applet.
                                     dmgcpu.
                                     graphicsChip.
                                     setMagnify(
                                       viewSetting);
                               } }
    public void setFrameSkip() { if (applet.
                                       dmgcpu !=
                                       null) {
                                     if (viewFrameSkip0.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           1;
                                     }
                                     if (viewFrameSkip1.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           2;
                                     }
                                     if (viewFrameSkip2.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           3;
                                     }
                                     if (viewFrameSkip3.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           4;
                                     }
                                     if (viewFrameSkip4.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           5;
                                     }
                                 } }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.String command =
          e.
          getActionCommand(
            );
        if (command.
              equals(
                "Open ROM")) {
            if (applet.
                  dmgcpu !=
                  null) {
                applet.
                  dmgcpu.
                  terminate =
                  true;
                if (applet.
                      cartridge !=
                      null)
                    applet.
                      cartridge.
                      dispose(
                        );
                if (applet.
                      dmgcpu !=
                      null) {
                    applet.
                      dmgcpu.
                      dispose(
                        );
                    applet.
                      dmgcpu =
                      null;
                }
                clearWindow(
                  );
            }
            java.awt.FileDialog fd =
              new java.awt.FileDialog(
              this,
              "Open ROM");
            fd.
              show(
                );
            java.lang.String recovstr =
              java.lang.System.
              getenv(
                "PANDA_RECOVER");
            boolean recover =
              true;
            if (recovstr !=
                  null &&
                  recovstr.
                  equals(
                    "false")) {
                recover =
                  false;
            }
            Cartridge dc =
              new Cartridge(
              fd.
                getDirectory(
                  ) +
              fd.
                getFile(
                  ),
              this);
            Cartridge cartridge =
              null;
            if (fd.
                  getFile(
                    ) !=
                  null) {
                try {
                    cartridge =
                      dc;
                }
                catch (java.lang.Exception e1) {
                    cartridge =
                      dc;
                    if (recover) {
                        setWindowSize(
                          2);
                        setMagnify(
                          );
                    }
                }
                applet.
                  cartridge =
                  cartridge;
                applet.
                  dmgcpu =
                  new Dmgcpu(
                    applet.
                      cartridge,
                    applet.
                      gameLink,
                    this);
                if (applet.
                      gameLink !=
                      null)
                    applet.
                      gameLink.
                      setDmgcpu(
                        applet.
                          dmgcpu);
                setGraphicsChip(
                  applet.
                    dmgcpu.
                    graphicsChip);
                setSoundFreq(
                  );
                setBufferLength(
                  );
                setMagnify(
                  );
                setFrameSkip(
                  );
                setChannelEnable(
                  );
                applet.
                  dmgcpu.
                  allowGbcFeatures =
                  fileGameboyColor.
                    getState(
                      );
                applet.
                  dmgcpu.
                  reset(
                    );
            }
        }
        else
            if (command.
                  equals(
                    "Frame counter")) {
                viewFrameCounter.
                  setState(
                    !viewFrameCounter.
                      getState(
                        ));
            }
            else
                if (command.
                      equals(
                        "Speed throttle")) {
                    viewSpeedThrottle.
                      setState(
                        !viewSpeedThrottle.
                          getState(
                            ));
                }
                else
                    if (command.
                          equals(
                            "Emulate")) {
                        if (applet.
                              cartridge !=
                              null &&
                              applet.
                                cartridge.
                                cartridgeReady) {
                            applet.
                              queueDebuggerCommand(
                                "g");
                            applet.
                              dmgcpu.
                              terminate =
                              true;
                        }
                        else {
                            new ModalDialog(
                              this,
                              "Error",
                              "You need to load a ROM before",
                              "you select \'Emulate\'.");
                        }
                    }
                    else
                        if (command.
                              equals(
                                "Reset")) {
                            applet.
                              queueDebuggerCommand(
                                "s;g");
                            applet.
                              dmgcpu.
                              terminate =
                              true;
                        }
                        else
                            if (command.
                                  equals(
                                    "Pause")) {
                                applet.
                                  dmgcpu.
                                  terminate =
                                  true;
                            }
                            else
                                if (command.
                                      equals(
                                        "Controls")) {
                                    new DefineControls(
                                      );
                                }
                                else
                                    if (command.
                                          equals(
                                            "Execute script")) {
                                        if (applet.
                                              dmgcpu !=
                                              null) {
                                            java.awt.FileDialog fd =
                                              new java.awt.FileDialog(
                                              this,
                                              "Execute debugger script");
                                            fd.
                                              show(
                                                );
                                            applet.
                                              queueDebuggerCommand(
                                                "c " +
                                                fd.
                                                  getDirectory(
                                                    ) +
                                                fd.
                                                  getFile(
                                                    ));
                                            applet.
                                              dmgcpu.
                                              terminate =
                                              true;
                                        }
                                        else {
                                            new ModalDialog(
                                              this,
                                              "Error",
                                              "Load a ROM before executing a debugger script",
                                              "");
                                        }
                                    }
                                    else
                                        if (command.
                                              equals(
                                                "Enter debugger")) {
                                            if (applet.
                                                  dmgcpu !=
                                                  null) {
                                                applet.
                                                  debuggerActive =
                                                  true;
                                                applet.
                                                  dmgcpu.
                                                  terminate =
                                                  true;
                                            }
                                            else {
                                                new ModalDialog(
                                                  this,
                                                  "Error",
                                                  "Load a ROM before entering the debugger",
                                                  "");
                                            }
                                        }
                                        else
                                            if (command.
                                                  equals(
                                                    "1x")) {
                                                applet.
                                                  dmgcpu.
                                                  graphicsChip.
                                                  setMagnify(
                                                    1);
                                                setWindowSize(
                                                  1);
                                                clearWindow(
                                                  );
                                            }
                                            else
                                                if (command.
                                                      equals(
                                                        "2x")) {
                                                    applet.
                                                      dmgcpu.
                                                      graphicsChip.
                                                      setMagnify(
                                                        2);
                                                    setWindowSize(
                                                      2);
                                                    clearWindow(
                                                      );
                                                }
                                                else
                                                    if (command.
                                                          equals(
                                                            "3x")) {
                                                        applet.
                                                          dmgcpu.
                                                          graphicsChip.
                                                          setMagnify(
                                                            3);
                                                        setWindowSize(
                                                          3);
                                                        clearWindow(
                                                          );
                                                    }
                                                    else
                                                        if (command.
                                                              equals(
                                                                "4x")) {
                                                            applet.
                                                              dmgcpu.
                                                              graphicsChip.
                                                              setMagnify(
                                                                4);
                                                            setWindowSize(
                                                              4);
                                                            clearWindow(
                                                              );
                                                        }
                                                        else
                                                            if (command.
                                                                  equals(
                                                                    "Connect to client")) {
                                                                makeConnectDialog(
                                                                  );
                                                            }
                                                            else
                                                                if (command.
                                                                      equals(
                                                                        "Connect cancel")) {
                                                                    connectDialog.
                                                                      hide(
                                                                        );
                                                                    connectDialog =
                                                                      null;
                                                                }
                                                                else
                                                                    if (command.
                                                                          equals(
                                                                            "Connect ok")) {
                                                                        connectDialog.
                                                                          hide(
                                                                            );
                                                                        connectDialog =
                                                                          null;
                                                                        applet.
                                                                          gameLink =
                                                                          new TCPGameLink(
                                                                            this,
                                                                            hostAddress.
                                                                              getText(
                                                                                ));
                                                                        if (applet.
                                                                              dmgcpu !=
                                                                              null) {
                                                                            applet.
                                                                              dmgcpu.
                                                                              gameLink =
                                                                              applet.
                                                                                gameLink;
                                                                            applet.
                                                                              gameLink.
                                                                              setDmgcpu(
                                                                                applet.
                                                                                  dmgcpu);
                                                                        }
                                                                    }
                                                                    else
                                                                        if (command.
                                                                              equals(
                                                                                "Exit")) {
                                                                            applet.
                                                                              dispose(
                                                                                );
                                                                            java.lang.System.
                                                                              exit(
                                                                                0);
                                                                        }
    }
    public void setColourScheme(java.lang.String command) {
        if (applet.
              dmgcpu ==
              null) {
            new ModalDialog(
              this,
              "Error",
              "Load a ROM before selecting",
              "a colour scheme.");
            for (int r =
                   0;
                 r <
                   JavaBoy.
                     schemeNames.
                     length;
                 r++) {
                if (JavaBoy.
                      schemeNames[r] ==
                      command) {
                    schemes[r].
                      setState(
                        false);
                }
            }
        }
        else {
            for (int r =
                   0;
                 r <
                   JavaBoy.
                     schemeNames.
                     length;
                 r++) {
                if (JavaBoy.
                      schemeNames[r] ==
                      command) {
                    applet.
                      dmgcpu.
                      graphicsChip.
                      backgroundPalette.
                      setColours(
                        JavaBoy.
                          schemeColours[r][0],
                        JavaBoy.
                          schemeColours[r][1],
                        JavaBoy.
                          schemeColours[r][2],
                        JavaBoy.
                          schemeColours[r][3]);
                    applet.
                      dmgcpu.
                      graphicsChip.
                      obj1Palette.
                      setColours(
                        JavaBoy.
                          schemeColours[r][4],
                        JavaBoy.
                          schemeColours[r][5],
                        JavaBoy.
                          schemeColours[r][6],
                        JavaBoy.
                          schemeColours[r][7]);
                    applet.
                      dmgcpu.
                      graphicsChip.
                      obj2Palette.
                      setColours(
                        JavaBoy.
                          schemeColours[r][8],
                        JavaBoy.
                          schemeColours[r][9],
                        JavaBoy.
                          schemeColours[r][10],
                        JavaBoy.
                          schemeColours[r][11]);
                    applet.
                      dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        );
                }
                else {
                    schemes[r].
                      setState(
                        false);
                }
            }
        }
    }
    public void itemStateChanged(java.awt.event.ItemEvent e) {
        java.lang.String command =
          (java.lang.String)
            e.
            getItem(
              );
        java.lang.System.
          out.
          println(
            command);
        if (command.
              equals(
                "Channel 1 (Square wave)")) {
            if (applet.
                  dmgcpu !=
                  null) {
                applet.
                  dmgcpu.
                  soundChip.
                  channel1Enable =
                  soundChannel1Enable.
                    getState(
                      );
            }
        }
        else
            if (command.
                  equals(
                    "Channel 2 (Square wave)")) {
                if (applet.
                      dmgcpu !=
                      null) {
                    applet.
                      dmgcpu.
                      soundChip.
                      channel2Enable =
                      soundChannel2Enable.
                        getState(
                          );
                }
            }
            else
                if (command.
                      equals(
                        "Channel 3 (Voluntary wave)")) {
                    if (applet.
                          dmgcpu !=
                          null) {
                        applet.
                          dmgcpu.
                          soundChip.
                          channel3Enable =
                          soundChannel3Enable.
                            getState(
                              );
                    }
                }
                else
                    if (command.
                          equals(
                            "Channel 4 (Noise)")) {
                        if (applet.
                              dmgcpu !=
                              null) {
                            applet.
                              dmgcpu.
                              soundChip.
                              channel4Enable =
                              soundChannel4Enable.
                                getState(
                                  );
                        }
                    }
                    else
                        if (command.
                              equals(
                                "Size: actual")) {
                            viewSingle.
                              setState(
                                true);
                            viewDouble.
                              setState(
                                false);
                            viewTriple.
                              setState(
                                false);
                            viewQuadrouple.
                              setState(
                                false);
                            view5.
                              setState(
                                false);
                            view6.
                              setState(
                                false);
                            setMagnify(
                              );
                            setWindowSize(
                              1);
                        }
                        else
                            if (command.
                                  equals(
                                    "Size: 2x")) {
                                viewSingle.
                                  setState(
                                    false);
                                viewDouble.
                                  setState(
                                    true);
                                viewTriple.
                                  setState(
                                    false);
                                viewQuadrouple.
                                  setState(
                                    false);
                                view5.
                                  setState(
                                    false);
                                view6.
                                  setState(
                                    false);
                                setMagnify(
                                  );
                                setWindowSize(
                                  2);
                            }
                            else
                                if (command.
                                      equals(
                                        "Size: 3x")) {
                                    viewSingle.
                                      setState(
                                        false);
                                    viewDouble.
                                      setState(
                                        false);
                                    viewTriple.
                                      setState(
                                        true);
                                    viewQuadrouple.
                                      setState(
                                        false);
                                    view5.
                                      setState(
                                        false);
                                    view6.
                                      setState(
                                        false);
                                    setMagnify(
                                      );
                                    setWindowSize(
                                      3);
                                }
                                else
                                    if (command.
                                          equals(
                                            "Size: 4x")) {
                                        viewSingle.
                                          setState(
                                            false);
                                        viewDouble.
                                          setState(
                                            false);
                                        viewTriple.
                                          setState(
                                            false);
                                        viewQuadrouple.
                                          setState(
                                            true);
                                        view5.
                                          setState(
                                            false);
                                        view6.
                                          setState(
                                            false);
                                        setMagnify(
                                          );
                                        setWindowSize(
                                          4);
                                    }
                                    else
                                        if (command.
                                              equals(
                                                "Size: 5x")) {
                                            viewSingle.
                                              setState(
                                                false);
                                            viewDouble.
                                              setState(
                                                false);
                                            viewTriple.
                                              setState(
                                                false);
                                            viewQuadrouple.
                                              setState(
                                                false);
                                            view5.
                                              setState(
                                                true);
                                            view6.
                                              setState(
                                                false);
                                            setMagnify(
                                              );
                                            setWindowSize(
                                              5);
                                        }
                                        else
                                            if (command.
                                                  equals(
                                                    "Size: 6x")) {
                                                viewSingle.
                                                  setState(
                                                    false);
                                                viewDouble.
                                                  setState(
                                                    false);
                                                viewTriple.
                                                  setState(
                                                    false);
                                                viewQuadrouple.
                                                  setState(
                                                    false);
                                                view5.
                                                  setState(
                                                    false);
                                                view6.
                                                  setState(
                                                    true);
                                                setMagnify(
                                                  );
                                                setWindowSize(
                                                  6);
                                            }
                                            else
                                                if (command.
                                                      equals(
                                                        "Sample rate: 11khz")) {
                                                    soundFreq22.
                                                      setState(
                                                        false);
                                                    soundFreq44.
                                                      setState(
                                                        false);
                                                    soundFreq11.
                                                      setState(
                                                        true);
                                                    setSoundFreq(
                                                      );
                                                }
                                                else
                                                    if (command.
                                                          equals(
                                                            "Sample rate: 22khz")) {
                                                        soundFreq11.
                                                          setState(
                                                            false);
                                                        soundFreq44.
                                                          setState(
                                                            false);
                                                        soundFreq22.
                                                          setState(
                                                            true);
                                                        setSoundFreq(
                                                          );
                                                    }
                                                    else
                                                        if (command.
                                                              equals(
                                                                "Frame skip: 0")) {
                                                            viewFrameSkip0.
                                                              setState(
                                                                true);
                                                            viewFrameSkip1.
                                                              setState(
                                                                false);
                                                            viewFrameSkip2.
                                                              setState(
                                                                false);
                                                            viewFrameSkip3.
                                                              setState(
                                                                false);
                                                            viewFrameSkip4.
                                                              setState(
                                                                false);
                                                            setFrameSkip(
                                                              );
                                                        }
                                                        else
                                                            if (command.
                                                                  equals(
                                                                    "Frame skip: 1")) {
                                                                viewFrameSkip0.
                                                                  setState(
                                                                    false);
                                                                viewFrameSkip1.
                                                                  setState(
                                                                    true);
                                                                viewFrameSkip2.
                                                                  setState(
                                                                    false);
                                                                viewFrameSkip3.
                                                                  setState(
                                                                    false);
                                                                viewFrameSkip4.
                                                                  setState(
                                                                    false);
                                                                setFrameSkip(
                                                                  );
                                                            }
                                                            else
                                                                if (command.
                                                                      equals(
                                                                        "Frame skip: 2")) {
                                                                    viewFrameSkip0.
                                                                      setState(
                                                                        false);
                                                                    viewFrameSkip1.
                                                                      setState(
                                                                        false);
                                                                    viewFrameSkip2.
                                                                      setState(
                                                                        true);
                                                                    viewFrameSkip3.
                                                                      setState(
                                                                        false);
                                                                    viewFrameSkip4.
                                                                      setState(
                                                                        false);
                                                                    setFrameSkip(
                                                                      );
                                                                }
                                                                else
                                                                    if (command.
                                                                          equals(
                                                                            "Frame skip: 3")) {
                                                                        viewFrameSkip0.
                                                                          setState(
                                                                            false);
                                                                        viewFrameSkip1.
                                                                          setState(
                                                                            false);
                                                                        viewFrameSkip2.
                                                                          setState(
                                                                            false);
                                                                        viewFrameSkip3.
                                                                          setState(
                                                                            true);
                                                                        viewFrameSkip4.
                                                                          setState(
                                                                            false);
                                                                        setFrameSkip(
                                                                          );
                                                                    }
                                                                    else
                                                                        if (command.
                                                                              equals(
                                                                                "Frame skip: 4")) {
                                                                            viewFrameSkip0.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip1.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip2.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip3.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip4.
                                                                              setState(
                                                                                true);
                                                                            setFrameSkip(
                                                                              );
                                                                        }
                                                                        else
                                                                            if (command.
                                                                                  equals(
                                                                                    "Sample rate: 44khz")) {
                                                                                soundFreq11.
                                                                                  setState(
                                                                                    false);
                                                                                soundFreq22.
                                                                                  setState(
                                                                                    false);
                                                                                soundFreq44.
                                                                                  setState(
                                                                                    true);
                                                                                setSoundFreq(
                                                                                  );
                                                                            }
                                                                            else
                                                                                if (command.
                                                                                      equals(
                                                                                        "Buffer length: 200ms")) {
                                                                                    soundBuffer300.
                                                                                      setState(
                                                                                        false);
                                                                                    soundBuffer400.
                                                                                      setState(
                                                                                        false);
                                                                                    soundBuffer200.
                                                                                      setState(
                                                                                        true);
                                                                                    setBufferLength(
                                                                                      );
                                                                                }
                                                                                else
                                                                                    if (command.
                                                                                          equals(
                                                                                            "Buffer length: 300ms")) {
                                                                                        soundBuffer200.
                                                                                          setState(
                                                                                            false);
                                                                                        soundBuffer400.
                                                                                          setState(
                                                                                            false);
                                                                                        soundBuffer300.
                                                                                          setState(
                                                                                            true);
                                                                                        setBufferLength(
                                                                                          );
                                                                                    }
                                                                                    else
                                                                                        if (command.
                                                                                              equals(
                                                                                                "Buffer length: 400ms")) {
                                                                                            soundBuffer200.
                                                                                              setState(
                                                                                                false);
                                                                                            soundBuffer300.
                                                                                              setState(
                                                                                                false);
                                                                                            soundBuffer400.
                                                                                              setState(
                                                                                                true);
                                                                                            setBufferLength(
                                                                                              );
                                                                                        }
                                                                                        else
                                                                                            if (command.
                                                                                                  equals(
                                                                                                    "Use Gameboy Color features")) {
                                                                                                if (applet.
                                                                                                      dmgcpu !=
                                                                                                      null) {
                                                                                                    applet.
                                                                                                      dmgcpu.
                                                                                                      allowGbcFeatures =
                                                                                                      !applet.
                                                                                                         dmgcpu.
                                                                                                         allowGbcFeatures;
                                                                                                }
                                                                                                else {
                                                                                                    fileGameboyColor.
                                                                                                      setState(
                                                                                                        !fileGameboyColor.
                                                                                                          getState(
                                                                                                            ));
                                                                                                }
                                                                                            }
                                                                                            else
                                                                                                if (command.
                                                                                                      equals(
                                                                                                        "Allow connections")) {
                                                                                                    if (applet.
                                                                                                          gameLink ==
                                                                                                          null) {
                                                                                                        applet.
                                                                                                          gameLink =
                                                                                                          new TCPGameLink(
                                                                                                            this);
                                                                                                        if (applet.
                                                                                                              gameLink.
                                                                                                              serverRunning) {
                                                                                                            networkServer.
                                                                                                              setState(
                                                                                                                true);
                                                                                                        }
                                                                                                        else {
                                                                                                            networkServer.
                                                                                                              setState(
                                                                                                                false);
                                                                                                            applet.
                                                                                                              gameLink =
                                                                                                              null;
                                                                                                        }
                                                                                                        if (applet.
                                                                                                              dmgcpu !=
                                                                                                              null) {
                                                                                                            applet.
                                                                                                              dmgcpu.
                                                                                                              gameLink =
                                                                                                              applet.
                                                                                                                gameLink;
                                                                                                            applet.
                                                                                                              gameLink.
                                                                                                              setDmgcpu(
                                                                                                                applet.
                                                                                                                  dmgcpu);
                                                                                                        }
                                                                                                    }
                                                                                                    else {
                                                                                                        applet.
                                                                                                          gameLink.
                                                                                                          shutDown(
                                                                                                            );
                                                                                                        applet.
                                                                                                          gameLink =
                                                                                                          null;
                                                                                                        if (applet.
                                                                                                              dmgcpu !=
                                                                                                              null)
                                                                                                            applet.
                                                                                                              dmgcpu.
                                                                                                              gameLink =
                                                                                                              null;
                                                                                                    }
                                                                                                }
                                                                                                else
                                                                                                    if (command.
                                                                                                          equals(
                                                                                                            "Emulate printer")) {
                                                                                                        if (networkPrinter.
                                                                                                              getState(
                                                                                                                )) {
                                                                                                            if (applet.
                                                                                                                  gameLink !=
                                                                                                                  null) {
                                                                                                                applet.
                                                                                                                  gameLink.
                                                                                                                  shutDown(
                                                                                                                    );
                                                                                                                networkServer.
                                                                                                                  setState(
                                                                                                                    false);
                                                                                                            }
                                                                                                            applet.
                                                                                                              gameLink =
                                                                                                              new GameBoyPrinter(
                                                                                                                );
                                                                                                            applet.
                                                                                                              gameLink.
                                                                                                              setDmgcpu(
                                                                                                                applet.
                                                                                                                  dmgcpu);
                                                                                                            applet.
                                                                                                              dmgcpu.
                                                                                                              gameLink =
                                                                                                              applet.
                                                                                                                gameLink;
                                                                                                        }
                                                                                                        else {
                                                                                                            applet.
                                                                                                              gameLink.
                                                                                                              shutDown(
                                                                                                                );
                                                                                                            applet.
                                                                                                              gameLink =
                                                                                                              null;
                                                                                                        }
                                                                                                    }
                                                                                                    else {
                                                                                                        setColourScheme(
                                                                                                          command);
                                                                                                    }
    }
    public void paint(java.awt.Graphics g) {
        if (graphicsChip !=
              null) {
            java.awt.Dimension d =
              getSize(
                );
            int x =
              d.
                width /
              2 -
              graphicsChip.
                width /
              2;
            int y =
              d.
                height /
              2 -
              graphicsChip.
                height /
              2;
            boolean b =
              graphicsChip.
              draw(
                g,
                x,
                y +
                  20,
                this);
            if (viewFrameCounter.
                  getState(
                    )) {
                g.
                  setColor(
                    new java.awt.Color(
                      255,
                      255,
                      255));
                g.
                  fillRect(
                    0,
                    d.
                      height -
                      20,
                    d.
                      width,
                    20);
                g.
                  setColor(
                    new java.awt.Color(
                      0,
                      0,
                      0));
                g.
                  drawString(
                    graphicsChip.
                      getFPS(
                        ) +
                    " frames per second",
                    10,
                    d.
                      height -
                      7);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457189987000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xpePkTzoaqflGiUaNy/ezv/N/xHPGWW4XEAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457189987000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Vym7Wp6pO0WLM/M9gZFYUKV8HIUbfXEe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AA==");
}
