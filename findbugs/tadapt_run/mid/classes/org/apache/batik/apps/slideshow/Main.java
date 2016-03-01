package org.apache.batik.apps.slideshow;
public class Main extends javax.swing.JComponent {
    org.apache.batik.gvt.renderer.StaticRenderer renderer;
    org.apache.batik.bridge.UserAgent userAgent;
    org.apache.batik.bridge.DocumentLoader loader;
    org.apache.batik.bridge.BridgeContext ctx;
    java.awt.image.BufferedImage image;
    java.awt.image.BufferedImage display;
    java.io.File[] files;
    static int duration = 3000;
    static int frameDelay = duration + 7000;
    volatile boolean done = false;
    public Main(java.io.File[] files, java.awt.Dimension size) { super();
                                                                 setBackground(
                                                                   java.awt.Color.
                                                                     black);
                                                                 this.
                                                                   files =
                                                                   files;
                                                                 org.apache.batik.bridge.UserAgentAdapter ua =
                                                                   new org.apache.batik.bridge.UserAgentAdapter(
                                                                   );
                                                                 renderer =
                                                                   new org.apache.batik.gvt.renderer.StaticRenderer(
                                                                     );
                                                                 userAgent =
                                                                   ua;
                                                                 loader =
                                                                   new org.apache.batik.bridge.DocumentLoader(
                                                                     userAgent);
                                                                 ctx =
                                                                   new org.apache.batik.bridge.BridgeContext(
                                                                     userAgent,
                                                                     loader);
                                                                 ua.
                                                                   setBridgeContext(
                                                                     ctx);
                                                                 if (size ==
                                                                       null) {
                                                                     size =
                                                                       java.awt.Toolkit.
                                                                         getDefaultToolkit(
                                                                           ).
                                                                         getScreenSize(
                                                                           );
                                                                 }
                                                                 setPreferredSize(
                                                                   size);
                                                                 setDoubleBuffered(
                                                                   false);
                                                                 addMouseListener(
                                                                   new java.awt.event.MouseAdapter(
                                                                     ) {
                                                                       public void mouseClicked(java.awt.event.MouseEvent me) {
                                                                           if (done)
                                                                               java.lang.System.
                                                                                 exit(
                                                                                   0);
                                                                           else
                                                                               togglePause(
                                                                                 );
                                                                       }
                                                                   });
                                                                 size.
                                                                   width +=
                                                                   2;
                                                                 size.
                                                                   height +=
                                                                   2;
                                                                 display =
                                                                   new java.awt.image.BufferedImage(
                                                                     size.
                                                                       width,
                                                                     size.
                                                                       height,
                                                                     java.awt.image.BufferedImage.
                                                                       TYPE_INT_BGR);
                                                                 java.lang.Thread t =
                                                                   new org.apache.batik.apps.slideshow.Main.RenderThread(
                                                                   );
                                                                 t.
                                                                   start(
                                                                     );
                                                                 javax.swing.JWindow w =
                                                                   new javax.swing.JWindow(
                                                                   );
                                                                 w.
                                                                   setBackground(
                                                                     java.awt.Color.
                                                                       black);
                                                                 w.
                                                                   getContentPane(
                                                                     ).
                                                                   setBackground(
                                                                     java.awt.Color.
                                                                       black);
                                                                 w.
                                                                   getContentPane(
                                                                     ).
                                                                   add(
                                                                     this);
                                                                 w.
                                                                   pack(
                                                                     );
                                                                 w.
                                                                   setLocation(
                                                                     new java.awt.Point(
                                                                       -1,
                                                                       -1));
                                                                 w.
                                                                   setVisible(
                                                                     true);
    }
    class RenderThread extends java.lang.Thread {
        RenderThread() { super("RenderThread");
                         setDaemon(true);
        }
        public void run() { renderer.setDoubleBuffered(
                                       true);
                            for (int i = 0;
                                 i <
                                   files.
                                     length;
                                 i++) { org.apache.batik.gvt.GraphicsNode gvtRoot =
                                          null;
                                        org.apache.batik.bridge.GVTBuilder builder =
                                          new org.apache.batik.bridge.GVTBuilder(
                                          );
                                        try {
                                            java.lang.String fileName =
                                              files[i].
                                              toURL(
                                                ).
                                              toString(
                                                );
                                            java.lang.System.
                                              out.
                                              println(
                                                "Reading: " +
                                                fileName);
                                            org.w3c.dom.Document svgDoc =
                                              loader.
                                              loadDocument(
                                                fileName);
                                            java.lang.System.
                                              out.
                                              println(
                                                "Building: " +
                                                fileName);
                                            gvtRoot =
                                              builder.
                                                build(
                                                  ctx,
                                                  svgDoc);
                                            java.lang.System.
                                              out.
                                              println(
                                                "Rendering: " +
                                                fileName);
                                            renderer.
                                              setTree(
                                                gvtRoot);
                                            org.w3c.dom.Element elt =
                                              ((org.w3c.dom.svg.SVGDocument)
                                                 svgDoc).
                                              getRootElement(
                                                );
                                            renderer.
                                              setTransform(
                                                org.apache.batik.bridge.ViewBox.
                                                  getViewTransform(
                                                    null,
                                                    elt,
                                                    display.
                                                      getWidth(
                                                        ),
                                                    display.
                                                      getHeight(
                                                        ),
                                                    ctx));
                                            renderer.
                                              updateOffScreen(
                                                display.
                                                  getWidth(
                                                    ),
                                                display.
                                                  getHeight(
                                                    ));
                                            java.awt.Rectangle r =
                                              new java.awt.Rectangle(
                                              0,
                                              0,
                                              display.
                                                getWidth(
                                                  ),
                                              display.
                                                getHeight(
                                                  ));
                                            renderer.
                                              repaint(
                                                r);
                                            java.lang.System.
                                              out.
                                              println(
                                                "Painting: " +
                                                fileName);
                                            image =
                                              renderer.
                                                getOffScreen(
                                                  );
                                            setTransition(
                                              image);
                                        }
                                        catch (java.lang.Exception ex) {
                                            ex.
                                              printStackTrace(
                                                );
                                        }
                            }
                            if (transitionThread !=
                                  null) {
                                try {
                                    transitionThread.
                                      join(
                                        );
                                }
                                catch (java.lang.InterruptedException ie) {
                                    
                                }
                                done =
                                  true;
                                setCursor(
                                  new java.awt.Cursor(
                                    java.awt.Cursor.
                                      WAIT_CURSOR));
                            } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YbWwUxxmeO39gO8ZfBEMgGDAHkh16WzclUWRKAw4Opmd8" +
           "sgGpdptjbnfOt3hvd9idtc9OXUKkBis/UBSclEbBv4jaRiREVaNWioIcVWoS" +
           "pWkEjdp8qEmr/mj6gRT+hFa0Td+Z2b3d27NN+qeWbm9v5p133o9nnvcdX7yG" +
           "ahwbdVJsajjJpilxkmn+nsa2Q7Q+AzvOYRjNqI//8ezJG7+pPxVHtaOoKY+d" +
           "QRU7pF8nhuaMok266TBsqsQ5RIjGV6Rt4hB7EjPdMkfRWt0ZKFBDV3U2aGmE" +
           "CxzFdgq1YsZsPesyMuApYGhzSlijCGuUvVGB3hRqVC06HSzYULagLzTHZQvB" +
           "fg5DLanjeBIrLtMNJaU7rLdoo7uoZUyPGxZLkiJLHjd2eYE4mNpVEYbOl5o/" +
           "u/lEvkWEYQ02TYsJF51h4ljGJNFSqDkY3W+QgnMCfRdVpdBtIWGGEil/UwU2" +
           "VWBT399ACqxfTUy30GcJd5ivqZaq3CCGtpYrodjGBU9NWtgMGuqY57tYDN5u" +
           "KXnrpzvi4lN3KfPff6jlJ1WoeRQ16+YIN0cFIxhsMgoBJYUssZ29mka0UdRq" +
           "QsJHiK1jQ5/xst3m6OMmZi5AwA8LH3QpscWeQawgk+Cb7arMskvu5QSovF81" +
           "OQOPg6/tga/Sw34+Dg426GCYncOAPW9J9YRuagJH5StKPia+AQKwdFWBsLxV" +
           "2qraxDCA2iREDGyOKyMAPnMcRGssgKAtsLaMUh5ritUJPE4yDK2PyqXlFEjV" +
           "i0DwJQytjYoJTZClDZEshfJz7dDuMw+bB8w4ioHNGlENbv9tsKgjsmiY5IhN" +
           "4BzIhY3dqadx+6tzcYRAeG1EWMr87DvX79/ZsfiGlNm4hMxQ9jhRWUa9kG26" +
           "cmdf131V3Iw6ajk6T36Z5+KUpb2Z3iIFpmkvaeSTSX9ycfiX33zkefK3OGoY" +
           "QLWqZbgFwFGrahWobhD7QWISGzOiDaB6Ymp9Yn4ArYL3lG4SOTqUyzmEDaBq" +
           "QwzVWuI3hCgHKniIGuBdN3OW/04xy4v3IkUIVcMH1cNnCsk/8c0QUfJWgShY" +
           "xaZuWkratrj/PKGCc4gD7xrMUkvJAv4nvtSTvFdxLNcGQCqWPa5gQEWeyEn4" +
           "QR3FMXSNOHlrShnEupnkcKP/r42K3OM1U7EYJOPOKBUYcIoOWIZG7Iw67+7b" +
           "f/3FzFsSZvxoeLFiqAd2S8rdkmK3JN8tWdotyXdLDENOAOd5m2ANxWJix9u5" +
           "CTL1kLgJoADg4MaukW8fPDbXWQWYo1M8D1x0R0VN6gu4wif4jHrxyvCNd95u" +
           "eD6O4kAnWahJQWFIlBUGWddsSyUaMNNyJcKnSWX5orCkHWjx3NSpoye/LOwI" +
           "cz1XWAM0xZenOUOXtkhEz/hSeptPf/LZpadnreC0lxUPv+ZVrOQk0hnNb9T5" +
           "jNq9Bb+ceXU2EUfVwEzAxgxSx4muI7pHGZn0+sTMfakDh3OWXcAGn/LZtIHl" +
           "bWsqGBHAaxXvt0OK6/jp4i9F77iJbz7bTvlznQQqx0zEC0H8Xxuh59/79V/u" +
           "FuH2a0RzqLiPENYb4iWurE0wUGsAwcM2ISD3+3Pps09dOz0m8AcS25baMMGf" +
           "fcBHkEII8/feOPH+xx9deDdewiwqlvtWt4JvHN6BGUBnBpx0DpbEERPAqOd0" +
           "nDUIPxv/at7e8/Lfz7TI9Bsw4qNn560VBON37EOPvPXQjQ6hJqbychqEKhCT" +
           "HL0m0LzXtvE0t6N46uqmH7yOzwPbA8M6+gwRpIk817lRdwv/k+L5lcjcLv5I" +
           "OGHMlx+rUNuTUZ9499PVRz+9fF1YW943hVM8iGmvRBV/bC+C+nVRfjmAnTzI" +
           "fXXx0LdajMWboHEUNKpAmc6QDfRULAOEJ12z6oPXftF+7EoVivejBsPCWj8W" +
           "ZwvVA6g5xRlakX79fq9O8Ey3yDRXOM/juXnpTO0vUCZiO/PzdT/d/cOFjwSW" +
           "JIo2hiG1gz+6S+gSM9XRQhVGV5kGG21arpcQfdCFR+cXtKHnemTFbyuvz/uh" +
           "/Xzht//+VfLcH95cohDUer1gsCFn7q0VzD0o+qyAde69eqPqwyfXN1aSNtfU" +
           "sQwldy9PydENXn/0rxsO78kf+x/YeHMkSlGVPx68+OaDO9Qn46JVlERc0WKW" +
           "L+oNxws2tQn0xCZ3i4+sFtjtLOW1mefrDvjMenmdXZoRBSTEs4s/dsq4QzKo" +
           "m4UbVoSGmlZQuMKBHVlh7gh/pBiqsl0T0t21wvXJ1gtAv5NeA6rMtn088ewn" +
           "L0ioRbvViDCZm3/88+SZeQk72dJvq+iqw2tkWy9MbJFB+Bz+YvD5D/9w+/mA" +
           "bOva+rzeckupuaS0KNC7gllii/4/X5p95Uezp+NePB5gqHrS0uU94h7+GJRJ" +
           "uO+LUQQf2FNkqDHcMQmx9VDrv0ivBWavr7jWyauI+uJCc926hSO/ExW+dF1o" +
           "hNqYcw0jBM8wVGupTXK68K5RUiwVX+OA+VsYxOCC478LJ3Jy6XG47Sy5FKLH" +
           "v8KyBbioR2UZqhHfYTmgoIZADo6AfAmLgPoqEOGvjPpBbRGMzG94SRntYqyS" +
           "dkUm194qkyGe3VZ2EMRt3OcSV97HM+qlhYOHHr5+z3Oyb4F7/MyMuL3BZVS2" +
           "UCU+2rqsNl9X7YGum00v1W/3cdgqDQ5YYmPo0O4BjqC8Gm2IVHcnUSry71/Y" +
           "ffntudqrcOTGUAwztGYsdBeWFz9oEVwgy7FUmORD/9MRjUdvw5+OvfOPD2Jt" +
           "oqR5ZaFjpRUZ9ezlD9M5Sp+Jo/oBVAPHjBRH4XLvPDBtDhN1EopvnWvqJ1wy" +
           "oAE+s5Zrli7uTRzVmN/URWS8gK4ujfK+l6HOSvKovAtAtZ8i9j6uXXB0hMFd" +
           "SsOzRX6hXcIryE3P+X+efOy9ITh1ZYaHta1y3GypGIT/LxBUhxb+GCtKyqrK" +
           "pAYp9SkMi6xSKuhjTjj9mJTmEgzFuin9L+wVhUrfEwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "uWFeN07/4HW/97bffv5beRnqfwDztQce/x4AAA==");
    }
    volatile java.lang.Thread transitionThread =
      null;
    public void setTransition(java.awt.image.BufferedImage newImg) {
        synchronized (this)  {
            while (transitionThread !=
                     null) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
            transitionThread =
              new org.apache.batik.apps.slideshow.Main.TransitionThread(
                newImg);
            transitionThread.
              start(
                );
        }
    }
    long startLastTransition = 0;
    volatile boolean paused = false;
    public void togglePause() { synchronized (this)  {
                                    paused =
                                      !paused;
                                    java.awt.Cursor c;
                                    if (paused) {
                                        c =
                                          new java.awt.Cursor(
                                            java.awt.Cursor.
                                              WAIT_CURSOR);
                                    }
                                    else {
                                        c =
                                          new java.awt.Cursor(
                                            java.awt.Cursor.
                                              DEFAULT_CURSOR);
                                        if (transitionThread !=
                                              null) {
                                            synchronized (transitionThread)  {
                                                transitionThread.
                                                  notifyAll(
                                                    );
                                            }
                                        }
                                    }
                                    setCursor(
                                      c);
                                } }
    class TransitionThread extends java.lang.Thread {
        java.awt.image.BufferedImage src;
        int blockw = 75;
        int blockh = 75;
        public TransitionThread(java.awt.image.BufferedImage bi) {
            super(
              "TransitionThread");
            setDaemon(
              true);
            src =
              bi;
        }
        public void run() { int xblocks =
                              (display.
                                 getWidth(
                                   ) +
                                 blockw -
                                 1) /
                              blockw;
                            int yblocks =
                              (display.
                                 getHeight(
                                   ) +
                                 blockh -
                                 1) /
                              blockh;
                            int nblocks =
                              xblocks *
                              yblocks;
                            int tblock = duration /
                              nblocks;
                            java.awt.Point[] rects =
                              new java.awt.Point[nblocks];
                            for (int y = 0;
                                 y <
                                   yblocks;
                                 y++) for (int x =
                                             0;
                                           x <
                                             xblocks;
                                           x++)
                                          rects[y *
                                                  xblocks +
                                                  x] =
                                            new java.awt.Point(
                                              x,
                                              y);
                            java.awt.Graphics2D g2d =
                              display.
                              createGraphics(
                                );
                            g2d.setColor(
                                  java.awt.Color.
                                    black);
                            long currTrans =
                              java.lang.System.
                              currentTimeMillis(
                                );
                            while (currTrans -
                                     startLastTransition <
                                     frameDelay) {
                                try {
                                    long stime =
                                      frameDelay -
                                      (currTrans -
                                         startLastTransition);
                                    if (stime >
                                          500) {
                                        java.lang.System.
                                          gc(
                                            );
                                        currTrans =
                                          java.lang.System.
                                            currentTimeMillis(
                                              );
                                        stime =
                                          frameDelay -
                                            (currTrans -
                                               startLastTransition);
                                    }
                                    if (stime >
                                          0)
                                        sleep(
                                          stime);
                                }
                                catch (java.lang.InterruptedException ie) {
                                    
                                }
                                currTrans =
                                  java.lang.System.
                                    currentTimeMillis(
                                      );
                            }
                            synchronized (this)  {
                                while (paused) {
                                    try {
                                        wait(
                                          );
                                    }
                                    catch (java.lang.InterruptedException ie) {
                                        
                                    }
                                }
                            }
                            long last = startLastTransition =
                              java.lang.System.
                                currentTimeMillis(
                                  );
                            for (int i = 0;
                                 i <
                                   rects.
                                     length;
                                 i++) { int idx =
                                          (int)
                                            (java.lang.Math.
                                               random(
                                                 ) *
                                               (rects.
                                                  length -
                                                  i));
                                        java.awt.Point pt =
                                          rects[idx];
                                        java.lang.System.
                                          arraycopy(
                                            rects,
                                            idx +
                                              1,
                                            rects,
                                            idx +
                                              1 -
                                              1,
                                            rects.
                                              length -
                                              i -
                                              idx -
                                              1);
                                        int x =
                                          pt.
                                            x *
                                          blockw;
                                        int y =
                                          pt.
                                            y *
                                          blockh;
                                        int w =
                                          blockw;
                                        int h =
                                          blockh;
                                        if (x +
                                              w >
                                              src.
                                              getWidth(
                                                ))
                                            w =
                                              src.
                                                getWidth(
                                                  ) -
                                                x;
                                        if (y +
                                              h >
                                              src.
                                              getHeight(
                                                ))
                                            h =
                                              src.
                                                getHeight(
                                                  ) -
                                                y;
                                        synchronized (display)  {
                                            g2d.
                                              fillRect(
                                                x,
                                                y,
                                                w,
                                                h);
                                            java.awt.image.BufferedImage sub;
                                            sub =
                                              src.
                                                getSubimage(
                                                  x,
                                                  y,
                                                  w,
                                                  h);
                                            g2d.
                                              drawImage(
                                                sub,
                                                null,
                                                x,
                                                y);
                                        }
                                        repaint(
                                          x,
                                          y,
                                          w,
                                          h);
                                        long current =
                                          java.lang.System.
                                          currentTimeMillis(
                                            );
                                        try {
                                            long dt =
                                              current -
                                              last;
                                            if (dt <
                                                  tblock)
                                                sleep(
                                                  tblock -
                                                    dt);
                                        }
                                        catch (java.lang.InterruptedException ie) {
                                            
                                        }
                                        last =
                                          current;
                            }
                            synchronized (Main.this)  {
                                transitionThread =
                                  null;
                                Main.this.
                                  notifyAll(
                                    );
                            } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3yMgZaknGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Rn7Y9j+EbkC5uyIAAA==");
    }
    public void paint(java.awt.Graphics g) {
        java.awt.Graphics2D g2d =
          (java.awt.Graphics2D)
            g;
        if (display ==
              null)
            return;
        g2d.
          drawImage(
            display,
            null,
            0,
            0);
    }
    public static void readFileList(java.lang.String file,
                                    java.util.List fileVec) {
        java.io.BufferedReader br;
        try {
            br =
              new java.io.BufferedReader(
                new java.io.FileReader(
                  file));
        }
        catch (java.io.FileNotFoundException fnfe) {
            java.lang.System.
              err.
              println(
                "Unable to open file-list: " +
                file);
            return;
        }
        try {
            java.net.URL flURL =
              new java.io.File(
              file).
              toURL(
                );
            java.lang.String line;
            while ((line =
                      br.
                        readLine(
                          )) !=
                     null) {
                java.lang.String str =
                  line;
                int idx =
                  str.
                  indexOf(
                    '#');
                if (idx !=
                      -1)
                    str =
                      str.
                        substring(
                          0,
                          idx);
                str =
                  str.
                    trim(
                      );
                if (str.
                      length(
                        ) ==
                      0)
                    continue;
                try {
                    java.net.URL imgURL =
                      new java.net.URL(
                      flURL,
                      str);
                    fileVec.
                      add(
                        imgURL.
                          getFile(
                            ));
                }
                catch (java.net.MalformedURLException mue) {
                    java.lang.System.
                      err.
                      println(
                        "Can\'t make sense of line:\n  " +
                        line);
                }
            }
        }
        catch (java.io.IOException ioe) {
            java.lang.System.
              err.
              println(
                "Error while reading file-list: " +
                file);
        }
        finally {
            try {
                br.
                  close(
                    );
            }
            catch (java.io.IOException ioe) {
                
            }
        }
    }
    public static void main(java.lang.String[] args) {
        java.util.List fileVec =
          new java.util.ArrayList(
          );
        java.awt.Dimension d =
          null;
        if (args.
              length ==
              0) {
            showUsage(
              );
            return;
        }
        for (int i =
               0;
             i <
               args.
                 length;
             i++) {
            if (args[i].
                  equals(
                    "-h") ||
                  args[i].
                  equals(
                    "-help") ||
                  args[i].
                  equals(
                    "--help")) {
                showUsage(
                  );
                return;
            }
            else
                if (args[i].
                      equals(
                        "--")) {
                    i++;
                    while (i <
                             args.
                               length) {
                        fileVec.
                          add(
                            args[i++]);
                    }
                    break;
                }
                else
                    if (args[i].
                          equals(
                            "-fl") ||
                          args[i].
                          equals(
                            "--file-list")) {
                        if (i +
                              1 ==
                              args.
                                length) {
                            java.lang.System.
                              err.
                              println(
                                "Must provide name of file list file after " +
                                args[i]);
                            break;
                        }
                        readFileList(
                          args[i +
                                 1],
                          fileVec);
                        i++;
                    }
                    else
                        if (args[i].
                              equals(
                                "-ft") ||
                              args[i].
                              equals(
                                "--frame-time")) {
                            if (i +
                                  1 ==
                                  args.
                                    length) {
                                java.lang.System.
                                  err.
                                  println(
                                    "Must provide time in millis after " +
                                    args[i]);
                                break;
                            }
                            try {
                                frameDelay =
                                  java.lang.Integer.
                                    decode(
                                      args[i +
                                             1]).
                                    intValue(
                                      );
                                i++;
                            }
                            catch (java.lang.NumberFormatException nfe) {
                                java.lang.System.
                                  err.
                                  println(
                                    "Can\'t parse frame time: " +
                                    args[i +
                                           1]);
                            }
                        }
                        else
                            if (args[i].
                                  equals(
                                    "-tt") ||
                                  args[i].
                                  equals(
                                    "--transition-time")) {
                                if (i +
                                      1 ==
                                      args.
                                        length) {
                                    java.lang.System.
                                      err.
                                      println(
                                        "Must provide time in millis after " +
                                        args[i]);
                                    break;
                                }
                                try {
                                    duration =
                                      java.lang.Integer.
                                        decode(
                                          args[i +
                                                 1]).
                                        intValue(
                                          );
                                    i++;
                                }
                                catch (java.lang.NumberFormatException nfe) {
                                    java.lang.System.
                                      err.
                                      println(
                                        "Can\'t parse transition time: " +
                                        args[i +
                                               1]);
                                }
                            }
                            else
                                if (args[i].
                                      equals(
                                        "-ws") ||
                                      args[i].
                                      equals(
                                        "--window-size")) {
                                    if (i +
                                          1 ==
                                          args.
                                            length) {
                                        java.lang.System.
                                          err.
                                          println(
                                            "Must provide window size [w,h] after " +
                                            args[i]);
                                        break;
                                    }
                                    try {
                                        int idx =
                                          args[i +
                                                 1].
                                          indexOf(
                                            ',');
                                        int w;
                                        int h;
                                        if (idx ==
                                              -1)
                                            w =
                                              (h =
                                                 java.lang.Integer.
                                                   decode(
                                                     args[i +
                                                            1]).
                                                   intValue(
                                                     ));
                                        else {
                                            java.lang.String wStr =
                                              args[i +
                                                     1].
                                              substring(
                                                0,
                                                idx);
                                            java.lang.String hStr =
                                              args[i +
                                                     1].
                                              substring(
                                                idx +
                                                  1);
                                            w =
                                              java.lang.Integer.
                                                decode(
                                                  wStr).
                                                intValue(
                                                  );
                                            h =
                                              java.lang.Integer.
                                                decode(
                                                  hStr).
                                                intValue(
                                                  );
                                        }
                                        d =
                                          new java.awt.Dimension(
                                            w,
                                            h);
                                        i++;
                                    }
                                    catch (java.lang.NumberFormatException nfe) {
                                        java.lang.System.
                                          err.
                                          println(
                                            "Can\'t parse window size: " +
                                            args[i +
                                                   1]);
                                    }
                                }
                                else
                                    fileVec.
                                      add(
                                        args[i]);
        }
        java.io.File[] files =
          new java.io.File[fileVec.
                             size(
                               )];
        for (int i =
               0;
             i <
               fileVec.
               size(
                 );
             i++) {
            try {
                files[i] =
                  new java.io.File(
                    (java.lang.String)
                      fileVec.
                      get(
                        i));
            }
            catch (java.lang.Exception ex) {
                ex.
                  printStackTrace(
                    );
            }
        }
        new org.apache.batik.apps.slideshow.Main(
          files,
          d);
    }
    public static void showUsage() { java.lang.System.
                                       out.
                                       println(
                                         "Options:\n" +
                                         ("                                 -- : Remaining args are fil" +
                                          "e names\n") +
                                         "                         -fl <file>\n" +
                                         ("                 --file-list <file> : file contains list of " +
                                          "images to\n") +
                                         "                                      show one per line\n" +
                                         "             -ws <width>[,<height>]\n" +
                                         ("    -window-size <width>[,<height>] : Set the size of slides" +
                                          "how window\n") +
                                         ("                                      defaults to full scree" +
                                          "n\n") +
                                         "                          -ft <int>\n" +
                                         ("                 --frame-time <int> : Amount of time in mill" +
                                          "isecs to\n") +
                                         "                                      show each frame.\n" +
                                         ("                                      Includes transition ti" +
                                          "me.\n") +
                                         "                          -tt <int>\n" +
                                         ("            --transition-time <int> : Amount of time in mill" +
                                          "isecs to\n") +
                                         ("                                      transition between fra" +
                                          "mes.\n") +
                                         "                             <file> : SVG file to display");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "m20sAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sr7xAkbhokCi1+RoA+bGimlDZDgYEIQn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
