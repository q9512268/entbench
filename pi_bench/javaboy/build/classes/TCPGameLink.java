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
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
