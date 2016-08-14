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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "c9gvWkZ/05tJbb6g9MVaqzlxi935kBtRutRDBnUhHWFIV0F9gg1ozA7KXhT5" +
           "Ar7hx1O5Y2qM30edIZ1yilq2uXU6rxsYsul2VZkQ4zjVEGe8mCx0G2u508J6" +
           "3GvjyMBI62anws/8ZlFpMn1D4YwZ3dadVAjQhjuXipzanxtht0Wqk9RXahXP" +
           "LaM1AjCV6gpeTppD3Ed9jeVWTdno18huYi02UpOuhYTh44g6RiJi6NMx63eW" +
           "o4iBewbWRnjDpKPUtjZxPOAlV6bnPdm3kw7viVXaMI1K2a/Ohm6oNQeONaHI" +
           "rhIJnEyU/VlKVtrzodAMHEGoD0yQm9btoYxG8qLdxgy6X+lTcmAmQn8UK4yg" +
           "E3GDBgiG2cWkaY8arFtwqW4reoEyqzgh9je0MBnwi5U21snyUmKCmB60RYHw" +
           "5ka3JpYCESbYQUG11xyV1iMrbbOuVi7g2qS+RGvtcO7KLGf3GxiqMWvgophn" +
           "2y4S43xSiDGaHaFtyVYK2lQiK2u5a8qVAT4zGkTcn5WrnDZasn6pWm5wPb28" +
           "rLZn+KLg0IhkOkkr6fgDebqOXUwoGERKKhNO6qG+E5iSjdjLPro0ehIq9zmM" +
           "F2WOn+moXzTrQ0SUscZA7hBGnPh2gCFVNCrLsOzyU0qrNmmyOSWbtSmppmHb" +
           "LhnrWoccRHCbWg18VFW7A3PhgWllJLRBeUEjPD3TfA8RlHVlJBh+0GynAqeI" +
           "BEDtoPJITRvNoj2MKtLYkFbyQsSMrgf3arNmGE8qlbHBNVgMcROMFrnAXNcI" +
           "ZiPZG3zR0txqzSsFpJkC0aOV2igUyKLTWMXtUZmtAj5ScMHsgKdkAk9bHZ5a" +
           "rM0JtVaSdoVlukV2E7hUl9CUUKsqvak3r/U8lPSNUCuHshvwqFMbyJ5BsDrR" +
           "6C2amkSjYmnaXZYGZjoOHGozDly2McYKjZhpE6SIFKOlWvBov08162gdW5Ds" +
           "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");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "sYP6TjAD3bTh+bCueJYsxTrLQHVolndfZrdJqG3DEq7ba4MJ+8EUlY9qctrN" +
           "44dvV26zzzNsIa7nKWoMHiud0THy3xxKIU9bi75xie8y0rPTDVULpx98i6do" +
           "4dtJLSRbxlIUb+P2PFfqBsnI3CG1oo0LoHkMEuA2ClHALeeZG3FMsE5R1DIj" +
           "K/iU/XhpT4JDgrQUVfBfL90TFNW4dFDC4sFLchpCCSTscVp3nNrIZ0g29kSF" +
           "t/MhP3wU4ttyu/h6EGelr1j5p0mnsCzxcRLO9dM7+h66eddT4qAmKXhigkmZ" +
           "C+AvzoyF4lxRUpojq3L7mlv1z1WvcjCsSSjslsxiT17HAc50Nj+3BU4xZqRw" +
           "mHn7zJaXfnqk8jK0uj0oBMk+b0/xgJjXLUDFPYniJgdAxo9XnWueGL9nfebP" +
           "v+IjuI2jS0rTD0lXz+69crz1DBzD5vagCoBnkueT633j6i4ijRpJVCebXXlQ" +
           "EaTIWPF10HqW05h9tOR+sd1ZV1hlx3yKOoqHh+KPI3BcGSPGNs1S03YPnuuu" +
           "+L6ZOvhm6XqAwV3xDFgZASJiliobSvTqujNboUs6h4Hh4CTBFzn3t/kjuz3/" +
           "H0Rmo6y2GAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AAA=");
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4t3d/wULChy9Ni0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Da9WixOCrnGrSK+QbK0pp+Whm8USwrXr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
