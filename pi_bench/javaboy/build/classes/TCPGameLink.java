class TCPGameLink extends GameLink implements java.lang.Runnable {
    final int PORTNO = 1989;
    Dmgcpu dmgcpu;
    java.net.ServerSocket server;
    java.net.Socket client;
    java.io.BufferedInputStream inStream;
    java.io.BufferedOutputStream outStream;
    boolean terminate = false;
    boolean clientConnected = false;
    java.awt.Frame parent;
    public TCPGameLink(java.awt.Frame parent) { super();
                                                this.parent = parent;
                                                try { server = new java.net.ServerSocket(
                                                                 PORTNO);
                                                      new ModalDialog(
                                                        parent,
                                                        "Server startup succeeded!",
                                                        "Game Link server running",
                                                        "A client can now connect.");
                                                      java.lang.Thread t =
                                                        new java.lang.Thread(
                                                        this);
                                                      t.
                                                        start(
                                                          );
                                                      serverRunning =
                                                        true;
                                                }
                                                catch (java.lang.Exception e) {
                                                    new ModalDialog(
                                                      parent,
                                                      "Server startup failed",
                                                      "Cannot start server on port " +
                                                      PORTNO,
                                                      "Check that the port is not in use.");
                                                }
    }
    public TCPGameLink(java.awt.Frame parent,
                       java.lang.String ip) {
        super(
          );
        this.
          parent =
          parent;
        try {
            client =
              new java.net.Socket(
                java.net.InetAddress.
                  getByName(
                    ip),
                PORTNO);
            client.
              setTcpNoDelay(
                true);
            outStream =
              new java.io.BufferedOutputStream(
                client.
                  getOutputStream(
                    ));
            inStream =
              new java.io.BufferedInputStream(
                client.
                  getInputStream(
                    ));
            new ModalDialog(
              parent,
              "Connect succeeded!",
              "Connected to Game Link server.",
              "You may now start a two player game.");
            java.lang.Thread t =
              new java.lang.Thread(
              this);
            t.
              start(
                );
            clientConnected =
              true;
        }
        catch (java.lang.Exception e) {
            new ModalDialog(
              parent,
              "Connect failed",
              "Cannot connect to host " +
              ip +
              ":" +
              PORTNO,
              "Ensure \'allow connections\' is checked on the server.");
        }
    }
    public void setDmgcpu(Dmgcpu d) { dmgcpu =
                                        d;
    }
    public void shutDown() { terminate = true;
                             try { if (server !=
                                         null)
                                       server.
                                         close(
                                           );
                             }
                             catch (java.lang.Exception e) {
                                 
                             } }
    public void writeInt(java.io.OutputStream s,
                         int i) { int b1;
                                  int b2;
                                  int b3;
                                  int b4;
                                  b1 = i &
                                         255;
                                  b2 = (i &
                                          65280) >>
                                         8;
                                  b3 = (i &
                                          16711680) >>
                                         16;
                                  b4 = (i &
                                          -16777216) >>
                                         24;
                                  try { s.
                                          write(
                                            b1);
                                        s.
                                          write(
                                            b2);
                                        s.
                                          write(
                                            b3);
                                        s.
                                          write(
                                            b4);
                                  }
                                  catch (java.io.IOException e) {
                                      
                                  } }
    public void run() { while ((serverRunning ||
                                  clientConnected) &&
                                 !terminate) {
                            try {
                                if (serverRunning) {
                                    java.net.Socket conn =
                                      null;
                                    conn =
                                      server.
                                        accept(
                                          );
                                    java.lang.System.
                                      out.
                                      println(
                                        "Connection established!");
                                    outStream =
                                      new java.io.BufferedOutputStream(
                                        conn.
                                          getOutputStream(
                                            ));
                                    inStream =
                                      new java.io.BufferedInputStream(
                                        conn.
                                          getInputStream(
                                            ));
                                }
                                int data =
                                  0;
                                int clock;
                                int initial;
                                int b1;
                                int b2;
                                int b3;
                                int b4;
                                int v =
                                  0;
                                while (data !=
                                         -1 &&
                                         !terminate) {
                                    if (dmgcpu !=
                                          null) {
                                        v =
                                          dmgcpu.
                                            instrCount;
                                    }
                                    initial =
                                      inStream.
                                        read(
                                          );
                                    b1 =
                                      inStream.
                                        read(
                                          );
                                    b2 =
                                      inStream.
                                        read(
                                          );
                                    b3 =
                                      inStream.
                                        read(
                                          );
                                    b4 =
                                      inStream.
                                        read(
                                          );
                                    clock =
                                      b1 +
                                        (b2 <<
                                           8) +
                                        (b3 <<
                                           16) +
                                        (b4 <<
                                           24);
                                    data =
                                      inStream.
                                        read(
                                          );
                                    if (dmgcpu !=
                                          null) {
                                        while (!dmgcpu.
                                                  interruptsEnabled ||
                                                 (dmgcpu.
                                                    ioHandler.
                                                    registers[15] &
                                                    dmgcpu.
                                                      INT_SER) !=
                                                 0 &&
                                                 !terminate) {
                                            try {
                                                java.lang.Thread.
                                                  sleep(
                                                    5);
                                            }
                                            catch (java.lang.InterruptedException e) {
                                                
                                            }
                                        }
                                    }
                                    if (initial ==
                                          1) {
                                        outStream.
                                          write(
                                            0);
                                        writeInt(
                                          outStream,
                                          -1);
                                        outStream.
                                          write(
                                            dmgcpu.
                                              ioHandler.
                                              registers[1]);
                                        outStream.
                                          flush(
                                            );
                                        dmgcpu.
                                          ioHandler.
                                          registers[2] &=
                                          127;
                                        dmgcpu.
                                          ioHandler.
                                          registers[1] =
                                          (byte)
                                            data;
                                        dmgcpu.
                                          triggerInterrupt(
                                            dmgcpu.
                                              INT_SER);
                                    }
                                    else
                                        if (initial ==
                                              0) {
                                            dmgcpu.
                                              ioHandler.
                                              registers[2] &=
                                              127;
                                            dmgcpu.
                                              ioHandler.
                                              registers[1] =
                                              (byte)
                                                data;
                                            dmgcpu.
                                              triggerInterrupt(
                                                dmgcpu.
                                                  INT_SER);
                                        }
                                }
                            }
                            catch (java.io.IOException e) {
                                
                            }
                            clientConnected =
                              false;
                            new ModalDialog(
                              parent,
                              "Connection lost",
                              "The connection with the other",
                              "machine has been lost.");
                        } }
    public void send(byte b) { try { outStream.
                                       write(
                                         1);
                                     writeInt(
                                       outStream,
                                       dmgcpu.
                                         instrCount);
                                     outStream.
                                       write(
                                         b);
                                     outStream.
                                       flush(
                                         );
                                     try {
                                         java.lang.Thread.
                                           sleep(
                                             10);
                                     }
                                     catch (java.lang.InterruptedException e) {
                                         
                                     } }
                               catch (java.io.IOException e) {
                                   
                               } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "39r/DzAZ7oy1IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cSf752//py/9w89/rTis//9Rz6ogIywAAA==");
}
