package org.sunflow.core.display;
@java.lang.SuppressWarnings("serial") 
public class FastDisplay extends javax.swing.JPanel implements org.sunflow.core.Display {
    private javax.swing.JFrame frame;
    private java.awt.image.BufferedImage image;
    private int[] pixels;
    private org.sunflow.system.Timer t;
    private float seconds;
    private int frames;
    public FastDisplay() { super();
                           image = null;
                           frame = null;
                           t = new org.sunflow.system.Timer();
                           frames = 0;
                           seconds = 0; }
    public synchronized void imageBegin(int w, int h, int bucketSize) { if (frame !=
                                                                              null &&
                                                                              image !=
                                                                              null &&
                                                                              w ==
                                                                              image.
                                                                              getWidth(
                                                                                ) &&
                                                                              h ==
                                                                              image.
                                                                              getHeight(
                                                                                )) {
                                                                            frame.
                                                                              setSize(
                                                                                w,
                                                                                h);
                                                                        }
                                                                        else {
                                                                            pixels =
                                                                              (new int[w *
                                                                                         h]);
                                                                            image =
                                                                              new java.awt.image.BufferedImage(
                                                                                w,
                                                                                h,
                                                                                java.awt.image.BufferedImage.
                                                                                  TYPE_INT_ARGB);
                                                                            if (frame ==
                                                                                  null) {
                                                                                setPreferredSize(
                                                                                  new java.awt.Dimension(
                                                                                    w,
                                                                                    h));
                                                                                frame =
                                                                                  new javax.swing.JFrame(
                                                                                    "Sunflow v" +
                                                                                    org.sunflow.SunflowAPI.
                                                                                      VERSION);
                                                                                frame.
                                                                                  setDefaultCloseOperation(
                                                                                    javax.swing.JFrame.
                                                                                      EXIT_ON_CLOSE);
                                                                                frame.
                                                                                  addKeyListener(
                                                                                    new java.awt.event.KeyAdapter(
                                                                                      ) {
                                                                                        public void keyPressed(java.awt.event.KeyEvent e) {
                                                                                            if (e.
                                                                                                  getKeyCode(
                                                                                                    ) ==
                                                                                                  java.awt.event.KeyEvent.
                                                                                                    VK_ESCAPE)
                                                                                                java.lang.System.
                                                                                                  exit(
                                                                                                    0);
                                                                                        }
                                                                                    });
                                                                                frame.
                                                                                  setContentPane(
                                                                                    this);
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
                                                                        }
                                                                        t.
                                                                          start(
                                                                            );
    }
    public void imagePrepare(int x, int y,
                             int w,
                             int h,
                             int id) {  }
    public void imageUpdate(int x, int y,
                            int w,
                            int h,
                            org.sunflow.image.Color[] data) {
        int iw =
          image.
          getWidth(
            );
        int off =
          x +
          iw *
          y;
        iw -=
          w;
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++,
               off +=
                 iw)
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   index++,
                   off++)
                pixels[off] =
                  -16777216 |
                    data[index].
                    toRGB(
                      );
    }
    public void imageFill(int x, int y, int w,
                          int h,
                          org.sunflow.image.Color c) {
        int iw =
          image.
          getWidth(
            );
        int off =
          x +
          iw *
          y;
        iw -=
          w;
        int rgb =
          -16777216 |
          c.
          toRGB(
            );
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++,
               off +=
                 iw)
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   index++,
                   off++)
                pixels[off] =
                  rgb;
    }
    public synchronized void imageEnd() {
        image.
          setRGB(
            0,
            0,
            image.
              getWidth(
                ),
            image.
              getHeight(
                ),
            pixels,
            0,
            image.
              getWidth(
                ));
        repaint(
          );
        t.
          end(
            );
        seconds +=
          t.
            seconds(
              );
        frames++;
        if (seconds >
              1) {
            frame.
              setTitle(
                java.lang.String.
                  format(
                    "Sunflow v%s - %.2f fps",
                    org.sunflow.SunflowAPI.
                      VERSION,
                    frames /
                      seconds));
            frames =
              0;
            seconds =
              0;
        }
    }
    public synchronized void paint(java.awt.Graphics g) {
        if (image ==
              null)
            return;
        g.
          drawImage(
            image,
            0,
            0,
            null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BHie2dP5zOFh66lsbnkxcl+09RQz9D0r");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("09SdqA9O3O84nRX5NCmqfvE2h/P/Jk/+ZVy6p7jL7GiG5d30FHENtvSn0/cr" +
       "3+4A8ewwB/IoIlk+sH+O829WHnsluJkALhUVLh0I4EAUv3MbUfxennwZyLoQ" +
       "BRdqgRQWtxtfOmX8375dxnNFwPaMY3/pjBd1FicUVPIBm+Cp7ikofuMS9bau" +
       "Qg9i375znaXHVvvYWavdXbpjvrMPK73pheN/Pr7B+Nrt7OoMcOWJcyK4P7zx" +
       "pjF/LcKighuvDot53g1btM6TzW007Y9vU/Y/8uQbefIjO0puU/eb6e73P92m" +
       "zp/kyVfi0r2F3KaBKsWHSv3621Xq94OH3qsU/f/Fmr+aN7pw8dZ8X7gz//hn" +
       "AKMLvknLcQ64/vO3wXWB6d8DHmHPtfAWuD7VvV+9Ketnubj/NmVX8+TuuHRX" +
       "wSHhqecZvHDP22UwL9f3DOrfQQYvnF+THzyJp+mGUmBaSlSw98RtWH8qT0DT" +
       "S4FkefEB34++Fb5TYBlnIl/zML7Hb4ii30V+K59/5YG7Hntl+ju7eJfj6Oy7" +
       "6dJdeuI4Z6OuzuQvB6GmW4Uc7t7FYAUFC8/dzBnZx+LGpSv7XE7vhWu7FsAN" +
       "uHrYAqzM+c/ZamXA0Zlq+U3yLne20lFcugNUyrNQcDwR5yOwOMnTnPTCGc9m" +
       "ryWF9Tx0Xsj3nQj5ZFqfOHPlmgRAClE0k0KwJhjRrZrG++tTMAn1bxvvmP87" +
       "hrYPniuCkq4r9927+ON/9dL/Lu3iU0BXxUCHobSFn5jf0x97kQ8e6nYe1Hrz" +
       "KFEekO9ose/lsZ0v/Pfnr773537qJ4vhrmg7evIe3leEgyJviYXjuMDrCjP6" +
       "cPvJj//R7xexJXcVQYKgRtHvjQF9+Qy+mOaX4kVwS/7tZ9NjRT+ZtrNBujkx" +
       "xb+THMehJLt/KLmufOGVPvuhN5qf2wUJK46UZXkvdwHmdvHKe3GejSU67O24" +
       "r8u95791/y/e/dyxt3z/TmlOUeMMbe++uawJN4iLGNrsnz72j9/7c698pbg5" +
       "/79UwMib5zMAAA==");
}
