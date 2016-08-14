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
            java.lang.System.
              out.
              println(
                "HIT!\n");
            Cartridge dc =
              (Cartridge)
                ent.runtime.ENT_Runtime.
                putObj(
                  new Cartridge(
                    ("/home/acanino/Projects/entbench/pi_bench/javaboy/input/large" +
                     ".gbc"),
                    this),
                  new java.lang.Integer[] { EntMode.
                                              DYNAMIC_MODE });
            Cartridge cartridge =
              null;
            try {
                cartridge =
                  ent.runtime.ENT_Snapshot.
                    snapshot(
                      dc,
                      EntMode.
                        LOW_MODE,
                      ent.runtime.ENT_Runtime.
                        getObjMode(
                          this,
                          0),
                      false);
            }
            catch (java.lang.Exception e1) {
                cartridge =
                  ent.runtime.ENT_Snapshot.
                    forceSnapshot(
                      dc,
                      EntMode.
                        LOW_MODE,
                      ent.runtime.ENT_Runtime.
                        getObjMode(
                          this,
                          0),
                      false);
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
      1470153815000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/38izFbDiUAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470153815000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qKzhqU0Kg0JukPL1zrTT8sTYYRsY5tQ9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
