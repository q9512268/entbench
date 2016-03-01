package edu.umd.cs.findbugs.util;
public class TestDesktopIntegration extends javax.swing.JPanel {
    private static java.lang.String[] propertyNames = { "java.version", "java.vendor",
    "java.vendor.url",
    "java.home",
    "java.vm.specification.version",
    "java.vm.specification.vendor",
    "java.vm.specification.name",
    "java.vm.version",
    "java.vm.vendor",
    "java.vm.name",
    "java.specification.version",
    "java.specification.vendor",
    "java.specification.name",
    "java.class.version",
    "java.class.path",
    "java.library.path",
    "java.io.tmpdir",
    "java.compiler",
    "java.ext.dirs",
    "os.name",
    "os.arch",
    "os.version",
    "file.separator",
    "path.separator",
    "line.separator",
    "user.name",
    "user.home",
    "user.dir" };
    public static void main(java.lang.String[] args) throws java.lang.Exception {
        java.lang.String u =
          edu.umd.cs.findbugs.SystemProperties.
          getProperty(
            "findbugs.browserTestURL",
            "http://findbugs.sourceforge.net/");
        url =
          new java.net.URL(
            u);
        javax.swing.SwingUtilities.
          invokeLater(
            new java.lang.Runnable(
              ) {
                @java.lang.Override
                public void run() {
                    createAndShowGUI(
                      );
                }
            });
    }
    private static void createAndShowGUI() { javax.swing.JFrame frame =
                                               new javax.swing.JFrame(
                                               "FindBugs browser integration Test");
                                             frame.setDefaultCloseOperation(
                                                     javax.swing.JFrame.
                                                       EXIT_ON_CLOSE);
                                             frame.add(new edu.umd.cs.findbugs.util.TestDesktopIntegration(
                                                         ));
                                             frame.
                                               pack(
                                                 );
                                             frame.
                                               setLocationRelativeTo(
                                                 null);
                                             frame.
                                               setVisible(
                                                 true);
    }
    javax.swing.JTextArea console = new javax.swing.JTextArea(
      24,
      80);
    static java.net.URL url;
    class ConsoleWriter extends java.io.Writer {
        @java.lang.Override
        public void close() throws java.io.IOException {
            
        }
        @java.lang.Override
        public void flush() throws java.io.IOException {
            
        }
        @java.lang.Override
        public void write(char[] cbuf, int off, int len)
              throws java.io.IOException { console.
                                             append(
                                               new java.lang.String(
                                                 cbuf,
                                                 off,
                                                 len));
        }
        public ConsoleWriter() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "xqiP2CttPv4vVUOWpukcAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "a8pCp7qKyQnDhi24q3TXSMukaUpHjaqeqcygm2/qqjQlW92qu1w1coqproMF" +
           "2zVMtLvZrW2+u0hmkbnq5RvXnjQVlUMifbzbwuKUmAE73dK5MhgzdaWuOJyF" +
           "L1ZLjJGQtYZXDDeobPpxWkXialynvJxWmlMyJWjXwa35jOolu3ZXxh2XlHWF" +
           "n8lGQIp9RxORoa9KcN7oLtKKKuTtFu4KvUxSo2Tus7NpkuWIlZh4pOnLjBUQ" +
           "iZX5OatY/NYMQP7aIuSh0K7zC0nEK1y82NA+Q2r1bD3Nwmm7O9OqxLQ+Me2N" +
           "pgwHux5V40dEo91sEUBaoVptRe4ijGOSJ1N1ndfN2s7TEJ2tzUYNHSSa8Xzs" +
           "2mhLGcudEV/pMFvG6lWzupZkEleH3XRSB1pX6QEwQYrogycMF0/VcLrqr7sR" +
           "NumiLVmr5dIOHLlutBTrraZqkOl22pUdz9KC+cTL0B4/rMxFeQ33+n5DWhGN" +
           "eMb0a2S3mimORqnDTb2K6sIcqxI9Mln3WauVTplaMst5uEHoa7KOKN5wV6Uc" +
           "1rYbu1qlMnJbcb9uEWud7o31dItoYlWaG4hbzZOa0ohWHbjRazfYkTTzLRRk" +
           "qRXS83nwNOC5yCpUaUNviEs5zdkdwzXpzLAxXlmGsCrFU77NJ/TKdhI161AG" +
           "HDrOYEGvkJ2A2l15N0Fz3hDzyOFRMk35dW0tiZwcZisDPM2+pnjMff23d9Pw" +
           "QHmpclwSW7p4MdH7Np6w84sXPBx/4KimcvkWt8qnbt6g4grhkZuVvcrrgw+9" +
           "9ZlnTe7D1YPDG0s5ha4cViPP3uC96ub3JGxZ8ju5RvvkW//54elrF2/6NgoF" +
           "j51j8jzJX2Gf+5Pe9xo/cwDddnypdkMx8izSk2ev0u6OrTSL/emZC7VHjtV6" +
           "tVDX94DvGw7V+oaLL+sv3J5LpT3sreAWt8HJublLh6WYwyu3/f2zE1xnOCo3" +
           "rLBQWYmXFY2fQreDiJXsaw2TU4YkpdDldeCYJxYWnLWwe44t7HitB08u27i1" +
           "FceOad3CKG+83y0HVjdqb36ovfl3Xntvu1h7xd91CfBTRfPW4qLTzZKyCrk9" +
           "UcmP31QlxfCP/J+Fb5by7j/Rd0b4245975U3972yUrG/cnz2Fx//0x999vG/" +
           "LS/773QSSYuJeH5B4fsUzlef++KXP3fvIx8pi2OXdS3ZO8f5NwZufCHgTJ2/" +
           "ZP+eY4UUhgA9Blgn9/rY/6aQ/p0pxgrErJ3NT6o3tOabrhUflXz/H1bJL/RB" +
           "Y3H4Ssh53y5vTN+fX4JKc/j5iw3h4PhMOT5OrriWP08XFy12G9iQovu+MD9e" +
           "8mBP52w4KV2cdAPfKipjR3MvPAo1x2+ZgMn8QuZXe+bLxYrm8Vu46EduMfex" +
           "onluH8R8a8/7LcB/Iy896BfKphx55lv5/8eL5l1ghU1RET/n/+/+Dvp/nkL3" +
           "nim+H6kV/jZL+MC1H7rh1aH96y7GR569eudLnhX/fO+ZR6+k3DWE7rQz1z1d" +
           "IzrVvxLGlu2U2rhrXzEKy5/fT6GHbsYbsNzip5Th9/bgfwis5wLwFKx92D0N" +
           "/YkUuvsEOoUOjDPTn0qhOw6ngd2C9vTkp8EQmCy6nwmP1HjfkXXutZtfOpvS" +
           "HO/pg9+qVHEqC3r8TAgtX+s6SjWy/YtdTxkffbY/evPXGh/eV9wNV9vtCip3" +
           "gmi3L/4fpysvvym1I1pX6Ce+cd/H7nrlUV51357hk5PgFG+PXVzSprwwLYvQ" +
           "u99+yW/+wC89+4WyEPa/lMTUpm8nAAA=");
    }
    java.io.PrintWriter writer = new java.io.PrintWriter(
      new edu.umd.cs.findbugs.util.TestDesktopIntegration.ConsoleWriter(
        ));
    static final boolean SHOW_CONSOLE = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "showConsole");
    static final boolean SHOW_FILE_CHOOSER = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "showFileChooser");
    public TestDesktopIntegration() { super(
                                        );
                                      setLayout(
                                        new java.awt.BorderLayout(
                                          ));
                                      javax.swing.JPanel top =
                                        new javax.swing.JPanel(
                                        );
                                      top.
                                        setLayout(
                                          new java.awt.FlowLayout(
                                            ));
                                      add(
                                        top,
                                        SHOW_CONSOLE
                                          ? java.awt.BorderLayout.
                                              NORTH
                                          : java.awt.BorderLayout.
                                              CENTER);
                                      if (SHOW_CONSOLE) {
                                          javax.swing.JScrollPane scrollPane =
                                            new javax.swing.JScrollPane(
                                            console,
                                            javax.swing.ScrollPaneConstants.
                                              VERTICAL_SCROLLBAR_ALWAYS,
                                            javax.swing.ScrollPaneConstants.
                                              HORIZONTAL_SCROLLBAR_ALWAYS);
                                          console.
                                            setEditable(
                                              false);
                                          console.
                                            setLineWrap(
                                              true);
                                          add(
                                            scrollPane);
                                      }
                                      else {
                                          add(
                                            new javax.swing.JLabel(
                                              "These buttons should view " +
                                              url),
                                            java.awt.BorderLayout.
                                              NORTH);
                                      }
                                      if (edu.umd.cs.findbugs.util.LaunchBrowser.
                                            desktopFeasible(
                                              )) {
                                          javax.swing.JButton desktop =
                                            new javax.swing.JButton(
                                            "Use java.awt.Desktop");
                                          desktop.
                                            addActionListener(
                                              new java.awt.event.ActionListener(
                                                ) {
                                                  @java.lang.Override
                                                  public void actionPerformed(java.awt.event.ActionEvent e) {
                                                      try {
                                                          writer.
                                                            println(
                                                              "Launch via desktop of " +
                                                              url);
                                                          edu.umd.cs.findbugs.util.LaunchBrowser.
                                                            viaDesktop(
                                                              url.
                                                                toURI(
                                                                  ));
                                                          writer.
                                                            println(
                                                              "Launch via desktop completed");
                                                      }
                                                      catch (java.lang.Throwable e1) {
                                                          writer.
                                                            println(
                                                              "Launch via desktop failed");
                                                          e1.
                                                            printStackTrace(
                                                              writer);
                                                      }
                                                      writer.
                                                        flush(
                                                          );
                                                  }
                                              });
                                          top.
                                            add(
                                              desktop);
                                      }
                                      else {
                                          writer.
                                            println(
                                              "Desktop unavailable");
                                          edu.umd.cs.findbugs.util.LaunchBrowser.
                                            desktopException.
                                            printStackTrace(
                                              writer);
                                      }
                                      if (edu.umd.cs.findbugs.util.LaunchBrowser.
                                            webstartFeasible(
                                              )) {
                                          javax.swing.JButton jnlp =
                                            new javax.swing.JButton(
                                            "Use jnlp");
                                          jnlp.
                                            addActionListener(
                                              new java.awt.event.ActionListener(
                                                ) {
                                                  @java.lang.Override
                                                  public void actionPerformed(java.awt.event.ActionEvent e) {
                                                      try {
                                                          writer.
                                                            println(
                                                              "Launch via jnlp of " +
                                                              url);
                                                          edu.umd.cs.findbugs.util.JavaWebStart.
                                                            viaWebStart(
                                                              url);
                                                          writer.
                                                            println(
                                                              "Launch via jnlp completed");
                                                      }
                                                      catch (java.lang.Throwable e1) {
                                                          writer.
                                                            println(
                                                              "Launch via jnlp failed");
                                                          e1.
                                                            printStackTrace(
                                                              writer);
                                                      }
                                                      writer.
                                                        flush(
                                                          );
                                                  }
                                              });
                                          top.
                                            add(
                                              jnlp);
                                      }
                                      javax.swing.JButton exec =
                                        new javax.swing.JButton(
                                        "exec " +
                                        edu.umd.cs.findbugs.util.LaunchBrowser.
                                          execCommand);
                                      top.
                                        add(
                                          exec);
                                      if (edu.umd.cs.findbugs.util.LaunchBrowser.
                                            launchViaExec) {
                                          exec.
                                            addActionListener(
                                              new java.awt.event.ActionListener(
                                                ) {
                                                  @java.lang.Override
                                                  public void actionPerformed(java.awt.event.ActionEvent e) {
                                                      try {
                                                          writer.
                                                            println(
                                                              "Launch via exec " +
                                                              edu.umd.cs.findbugs.util.LaunchBrowser.
                                                                execCommand);
                                                          writer.
                                                            println(
                                                              "url: " +
                                                              url);
                                                          java.lang.Process p =
                                                            edu.umd.cs.findbugs.util.LaunchBrowser.
                                                            launchViaExec(
                                                              url);
                                                          java.lang.Thread.
                                                            sleep(
                                                              3000);
                                                          int exitValue =
                                                            p.
                                                            exitValue(
                                                              );
                                                          writer.
                                                            println(
                                                              "Exit code: " +
                                                              exitValue);
                                                          writer.
                                                            println(
                                                              "Launch via exec completed");
                                                      }
                                                      catch (java.lang.Throwable e1) {
                                                          writer.
                                                            println(
                                                              "Launch via exec threw exception");
                                                          e1.
                                                            printStackTrace(
                                                              writer);
                                                      }
                                                      writer.
                                                        flush(
                                                          );
                                                  }
                                              });
                                      }
                                      else {
                                          exec.
                                            disable(
                                              );
                                      }
                                      if (SHOW_FILE_CHOOSER) {
                                          javax.swing.JButton chooseFile =
                                            new javax.swing.JButton(
                                            "Choose file");
                                          top.
                                            add(
                                              chooseFile);
                                          chooseFile.
                                            addActionListener(
                                              new java.awt.event.ActionListener(
                                                ) {
                                                  @java.lang.Override
                                                  public void actionPerformed(java.awt.event.ActionEvent e) {
                                                      final javax.swing.JFileChooser fc =
                                                        new javax.swing.JFileChooser(
                                                        );
                                                      int retvel =
                                                        fc.
                                                        showOpenDialog(
                                                          TestDesktopIntegration.this);
                                                      if (retvel ==
                                                            javax.swing.JFileChooser.
                                                              APPROVE_OPTION) {
                                                          java.io.File file =
                                                            fc.
                                                            getSelectedFile(
                                                              );
                                                          try {
                                                              writer.
                                                                println(
                                                                  "File choosen:");
                                                              writer.
                                                                println(
                                                                  "File path: " +
                                                                  file.
                                                                    getAbsolutePath(
                                                                      ));
                                                              writer.
                                                                println(
                                                                  "File canonical path: " +
                                                                  file.
                                                                    getCanonicalPath(
                                                                      ));
                                                              writer.
                                                                println(
                                                                  "File uri: " +
                                                                  file.
                                                                    toURI(
                                                                      ));
                                                              writer.
                                                                println(
                                                                  "File url: " +
                                                                  file.
                                                                    toURL(
                                                                      ));
                                                          }
                                                          catch (java.lang.Exception e1) {
                                                              e1.
                                                                printStackTrace(
                                                                  writer);
                                                          }
                                                          writer.
                                                            flush(
                                                              );
                                                      }
                                                  }
                                              });
                                      }
                                      if (SHOW_CONSOLE) {
                                          writer.
                                            println(
                                              "System properties:");
                                          java.util.TreeSet<java.lang.String> props =
                                            new java.util.TreeSet<java.lang.String>(
                                            );
                                          for (java.lang.Object o
                                                :
                                                java.lang.System.
                                                 getProperties(
                                                   ).
                                                 keySet(
                                                   )) {
                                              if (o instanceof java.lang.String) {
                                                  props.
                                                    add(
                                                      (java.lang.String)
                                                        o);
                                              }
                                          }
                                          props.
                                            addAll(
                                              java.util.Arrays.
                                                asList(
                                                  propertyNames));
                                          for (java.lang.String p
                                                :
                                                props) {
                                              try {
                                                  writer.
                                                    println(
                                                      "  " +
                                                      p +
                                                      "=" +
                                                      java.lang.System.
                                                        getProperty(
                                                          p));
                                              }
                                              catch (java.lang.Throwable e) {
                                                  writer.
                                                    println(
                                                      "Unable to get property " +
                                                      p);
                                              }
                                          }
                                          try {
                                              java.lang.Class<?> serviceManagerClass =
                                                java.lang.Class.
                                                forName(
                                                  "javax.jnlp.ServiceManager");
                                              java.lang.reflect.Method getServiceNamesMethod =
                                                serviceManagerClass.
                                                getMethod(
                                                  "getServiceNames",
                                                  new java.lang.Class[] {  });
                                              java.lang.reflect.Method lookupMethod =
                                                serviceManagerClass.
                                                getMethod(
                                                  "lookup",
                                                  new java.lang.Class[] { java.lang.String.class });
                                              java.lang.String[] serviceNames =
                                                (java.lang.String[])
                                                  getServiceNamesMethod.
                                                  invoke(
                                                    null,
                                                    new java.lang.Object[] {  });
                                              writer.
                                                println(
                                                  "JNLP service providers:");
                                              for (java.lang.String s
                                                    :
                                                    serviceNames) {
                                                  java.lang.Object o =
                                                    lookupMethod.
                                                    invoke(
                                                      null,
                                                      new java.lang.Object[] { s });
                                                  writer.
                                                    println(
                                                      "  " +
                                                      s +
                                                      " = " +
                                                      o.
                                                        getClass(
                                                          ).
                                                        getName(
                                                          ));
                                              }
                                          }
                                          catch (java.lang.Exception e) {
                                              writer.
                                                println(
                                                  "unable to get JNLP service provider:");
                                              e.
                                                printStackTrace(
                                                  writer);
                                          }
                                          java.lang.String sampleURL =
                                            java.lang.System.
                                            getProperty(
                                              "findbugs.sampleURL");
                                          if (sampleURL !=
                                                null) {
                                              try {
                                                  java.net.URL u =
                                                    new java.net.URL(
                                                    sampleURL);
                                                  writer.
                                                    println(
                                                      "Checking access to " +
                                                      u);
                                                  java.net.URLConnection c =
                                                    u.
                                                    openConnection(
                                                      );
                                                  writer.
                                                    println(
                                                      "Content type: " +
                                                      c.
                                                        getContentType(
                                                          ));
                                                  writer.
                                                    println(
                                                      "Content length: " +
                                                      c.
                                                        getContentLength(
                                                          ));
                                              }
                                              catch (java.lang.Throwable e) {
                                                  e.
                                                    printStackTrace(
                                                      writer);
                                              }
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Dj9XGCEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rmZnV8475okqnnwrVZzx5RfPnayVlzCP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("T8GS/TXMu8pXXqPoT3y3+XP72zKKLeV50cvDY+ja/uLOyUnaC5f2dtzXVeKl" +
       "7z3+1Ufef4wOj+8JPjXkM7S99/5XU/qOH5eXSfJ//O5/+MG/+9rvl9vN/w8o" +
       "I8lkHSsAAA==");
}
