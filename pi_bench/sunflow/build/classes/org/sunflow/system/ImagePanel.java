package org.sunflow.system;
@java.lang.SuppressWarnings("serial") 
public class ImagePanel extends javax.swing.JPanel implements org.sunflow.core.Display {
    private static final int[] BORDERS = { org.sunflow.image.Color.RED.toRGB(
                                                                         ),
    org.sunflow.image.Color.
      GREEN.
      toRGB(
        ),
    org.sunflow.image.Color.
      BLUE.
      toRGB(
        ),
    org.sunflow.image.Color.
      YELLOW.
      toRGB(
        ),
    org.sunflow.image.Color.
      CYAN.
      toRGB(
        ),
    org.sunflow.image.Color.
      MAGENTA.
      toRGB(
        ) };
    private java.awt.image.BufferedImage image;
    private float xo;
    private float yo;
    private float w;
    private float h;
    private long repaintCounter;
    private class ScrollZoomListener extends javax.swing.event.MouseInputAdapter implements java.awt.event.MouseWheelListener {
        int mx;
        int my;
        boolean dragging;
        boolean zooming;
        public void mousePressed(java.awt.event.MouseEvent e) { mx = e.getX(
                                                                         );
                                                                my = e.getY(
                                                                         );
                                                                switch (e.
                                                                          getButton(
                                                                            )) {
                                                                    case java.awt.event.MouseEvent.
                                                                           BUTTON1:
                                                                        dragging =
                                                                          true;
                                                                        zooming =
                                                                          false;
                                                                        break;
                                                                    case java.awt.event.MouseEvent.
                                                                           BUTTON2:
                                                                        {
                                                                            dragging =
                                                                              (zooming =
                                                                                 false);
                                                                            if ((e.
                                                                                   getModifiersEx(
                                                                                     ) &
                                                                                   java.awt.event.InputEvent.
                                                                                     CTRL_DOWN_MASK) ==
                                                                                  java.awt.event.InputEvent.
                                                                                    CTRL_DOWN_MASK)
                                                                                fit(
                                                                                  );
                                                                            else
                                                                                reset(
                                                                                  );
                                                                            break;
                                                                        }
                                                                    case java.awt.event.MouseEvent.
                                                                           BUTTON3:
                                                                        zooming =
                                                                          true;
                                                                        dragging =
                                                                          false;
                                                                        break;
                                                                    default:
                                                                        return;
                                                                }
                                                                repaint(
                                                                  );
        }
        public void mouseDragged(java.awt.event.MouseEvent e) {
            int mx2 =
              e.
              getX(
                );
            int my2 =
              e.
              getY(
                );
            if (dragging)
                drag(
                  mx2 -
                    mx,
                  my2 -
                    my);
            if (zooming)
                zoom(
                  mx2 -
                    mx,
                  my2 -
                    my);
            mx =
              mx2;
            my =
              my2;
        }
        public void mouseReleased(java.awt.event.MouseEvent e) {
            mouseDragged(
              e);
        }
        public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) {
            zoom(
              -20 *
                e.
                getWheelRotation(
                  ),
              0);
        }
        public ScrollZoomListener() { super(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ZEKnhqJX0/poqJG2m1Zo19QH+rgtjUZ4K6LbDcPvxHhThdvWKO7OpEJHqssB" +
           "03T49qC/Xo/nnQaHForccEI75cDyMRuXe4IsL7q+HniLuDapaJrTK4xNdE2Y" +
           "GlWuUX2UoftEtKnZS6LtY41iIJg4QkwMsddXZDxdys2mtjFq2nomcOkY5isc" +
           "pepEs1ipyJvacrqopPKC9COjKC8SSh9NEKpSxQ2l18HLtqxYrYU6jJCSZVpS" +
           "SaMXzKZarjgdd4WNmbKv6WGS0MUB8M+EgBtxSrhFt8tVRIkZsv0NW8EUQiF8" +
           "rNuqVL0GX1ZjB6U7Ka+S9EQTpsx8itO0tcYL3rxHLJJqPMbcYOPPzThWuU6K" +
           "CoqKUMNW03XEcj0x0mY8KfGjqMnPfEWwa2VU7Uyr8025Z3gqPabLs4Ei1Zp6" +
           "ucQwmGek/Yq01tFEHix7pXonaBOjdr3S6tXLSLFCRtFi4zVnQYtYTleDYa+E" +
           "9m3eDFlyw1TmSKuzQeJYUFuK4LuDdRQwfZcYBcu+VmsW1C5td8P+aomMCwt+" +
           "0bK6NgFyA2EwwoiBncUKK5VWDdGtMw1SGOKEkcwX5QbKlTdJzyLBPsGHeYlk" +
           "290xZS0rbYzFyTUsVKkSMhfnXaE6XcvN0modFCtjVumnrarNFxTWaHXNymi0" +
           "Llc6Tqht5o1IWJTrLOfP1HWIM3KIFyWCSkeSDIfrmlGQo8VkNoHDQBdTup7M" +
           "Cx0tpEgUaS2tkCgvlFa/3ggLZFs0W0uuF7ljVxdifd3hSJFZNZssUWiKSmna" +
           "W85s1o1FTW2VUJNZ9fRpVZoi8tIiU2Qp1/t4mwwIlY8HjXmtXd8oabswEPu6" +
           "1Sp5bMmZluZYnzEKw3EiVVsCCk8puy3xHMJFs4KzLqMUu0mRRkW2LSetJ+Fw" +
           "4tPzuoJQUxxJanhVmlf8RsQgtFtabJBqAdeTQa1frlaEEtaENRmGR8uKjDQG" +
           "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" +
           "v9Z/rfBbO9Dpg5PYK66ejyNdOn7+erMnBaFnscdOYe8/MEB27gftgueRPQM8" +
           "cvIk69DyV5o096Gt55y4Qjh13GSvvprJulk1x37mOhcQH8uKDwXQrWaGw3iS" +
           "70viVU9qIlsTD1306Zc6pDk6UN7w1JVaeXxPK4//XLWSvX40B/jkdQT/vax4" +
           "bl/wTnagKYlZ27OHQn7iZxUy68f2hMR+QUJ+/jpCfiErPhdAt+VCjiVD4v0r" +
           "pPz9n1XKGnioPSmpX4iDP3DNnHTo5V+6jh6+nBV/EkDnzQNEyo6u0MQXX44m" +
           "kgC688pr9n2O77/u/TzIfPdc8S3P9vsT4TPPnj9397PTv8mvow++EbmJhM7J" +
           "oWEcvfs5Uj/jeJKs5bLetL0JcvK/bwImr+QkO6jOKzm3f7EF/VYA3XIEFMwn" +
           "e7WjQN8OoNMAKKv+lbMv66P5Rw27fqxZylED4ZYTBi2RdwIwZ5w6kvn33CjX" +
           "+Z0vpfMDlKO30tlskX8ztZ/Zw+1XU5eFzz5LDN/+Yu0T21txweA3m4zKORI6" +
           "u72gP5gdHr4mtX1aZ7DHfnL75256zf40dvuW4UOXPsLbg1e/du6aTpBfFG/+" +
           "6O4/fMPvPPud/ID9/wDMaJFFzCYAAA==");
    }
    public ImagePanel() { super();
                          setPreferredSize(
                            new java.awt.Dimension(
                              640,
                              480));
                          image = null;
                          xo = (yo = 0);
                          w = (h = 0);
                          org.sunflow.system.ImagePanel.ScrollZoomListener listener =
                            new org.sunflow.system.ImagePanel.ScrollZoomListener(
                            );
                          addMouseListener(
                            listener);
                          addMouseMotionListener(
                            listener);
                          addMouseWheelListener(
                            listener); }
    public void save(java.lang.String filename) {
        org.sunflow.image.Bitmap.
          save(
            image,
            filename);
    }
    private synchronized void drag(int dx,
                                   int dy) {
        xo +=
          dx;
        yo +=
          dy;
        repaint(
          );
    }
    private synchronized void zoom(int dx,
                                   int dy) {
        int a =
          java.lang.Math.
          max(
            dx,
            dy);
        int b =
          java.lang.Math.
          min(
            dx,
            dy);
        if (java.lang.Math.
              abs(
                b) >
              java.lang.Math.
              abs(
                a))
            a =
              b;
        if (a ==
              0)
            return;
        float cx =
          getWidth(
            ) *
          0.5F;
        float cy =
          getHeight(
            ) *
          0.5F;
        float x =
          xo +
          (getWidth(
             ) -
             w) *
          0.5F;
        float y =
          yo +
          (getHeight(
             ) -
             h) *
          0.5F;
        float sx =
          cx -
          x;
        float sy =
          cy -
          y;
        if (w +
              a >
              100) {
            h =
              (w +
                 a) *
                h /
                w;
            sx =
              (w +
                 a) *
                sx /
                w;
            sy =
              (w +
                 a) *
                sy /
                w;
            w =
              w +
                a;
        }
        float x2 =
          cx -
          sx;
        float y2 =
          cy -
          sy;
        xo =
          x2 -
            (getWidth(
               ) -
               w) *
            0.5F;
        yo =
          y2 -
            (getHeight(
               ) -
               h) *
            0.5F;
        repaint(
          );
    }
    public synchronized void reset() { xo =
                                         (yo =
                                            0);
                                       if (image !=
                                             null) {
                                           w =
                                             image.
                                               getWidth(
                                                 );
                                           h =
                                             image.
                                               getHeight(
                                                 );
                                       }
                                       repaint(
                                         );
    }
    public synchronized void fit() { xo =
                                       (yo =
                                          0);
                                     if (image !=
                                           null) {
                                         float wx =
                                           java.lang.Math.
                                           max(
                                             getWidth(
                                               ) -
                                               10,
                                             100);
                                         float hx =
                                           wx *
                                           image.
                                           getHeight(
                                             ) /
                                           image.
                                           getWidth(
                                             );
                                         float hy =
                                           java.lang.Math.
                                           max(
                                             getHeight(
                                               ) -
                                               10,
                                             100);
                                         float wy =
                                           hy *
                                           image.
                                           getWidth(
                                             ) /
                                           image.
                                           getHeight(
                                             );
                                         if (hx >
                                               hy) {
                                             w =
                                               wy;
                                             h =
                                               hy;
                                         }
                                         else {
                                             w =
                                               wx;
                                             h =
                                               hx;
                                         }
                                         repaint(
                                           );
                                     } }
    public synchronized void imageBegin(int w,
                                        int h,
                                        int bucketSize) {
        if (image !=
              null &&
              w ==
              image.
              getWidth(
                ) &&
              h ==
              image.
              getHeight(
                )) {
            for (int y =
                   0;
                 y <
                   h;
                 y++) {
                for (int x =
                       0;
                     x <
                       w;
                     x++) {
                    int rgb =
                      image.
                      getRGB(
                        x,
                        y);
                    image.
                      setRGB(
                        x,
                        y,
                        ((rgb &
                            16711422) >>>
                           1) +
                          ((rgb &
                              16579836) >>>
                             2));
                }
            }
        }
        else {
            image =
              new java.awt.image.BufferedImage(
                w,
                h,
                java.awt.image.BufferedImage.
                  TYPE_INT_RGB);
            this.
              w =
              w;
            this.
              h =
              h;
            xo =
              (yo =
                 0);
        }
        repaintCounter =
          java.lang.System.
            nanoTime(
              );
        repaint(
          );
    }
    public synchronized void imagePrepare(int x,
                                          int y,
                                          int w,
                                          int h,
                                          int id) {
        int border =
          BORDERS[id %
                    BORDERS.
                      length];
        for (int by =
               0;
             by <
               h;
             by++) {
            for (int bx =
                   0;
                 bx <
                   w;
                 bx++) {
                if (bx ==
                      0 ||
                      bx ==
                      w -
                      1) {
                    if (5 *
                          by <
                          h ||
                          5 *
                          (h -
                             by -
                             1) <
                          h)
                        image.
                          setRGB(
                            x +
                              bx,
                            y +
                              by,
                            border);
                }
                else
                    if (by ==
                          0 ||
                          by ==
                          h -
                          1) {
                        if (5 *
                              bx <
                              w ||
                              5 *
                              (w -
                                 bx -
                                 1) <
                              w)
                            image.
                              setRGB(
                                x +
                                  bx,
                                y +
                                  by,
                                border);
                    }
            }
        }
        repaint(
          );
    }
    public synchronized void imageUpdate(int x,
                                         int y,
                                         int w,
                                         int h,
                                         org.sunflow.image.Color[] data) {
        if (image ==
              null ||
              data ==
              null)
            return;
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++)
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   index++)
                image.
                  setRGB(
                    x +
                      i,
                    y +
                      j,
                    data[index].
                      copy1(
                        ).
                      toNonLinear(
                        ).
                      toRGB(
                        ));
        repaint(
          );
    }
    public synchronized void imageFill(int x,
                                       int y,
                                       int w,
                                       int h,
                                       org.sunflow.image.Color c) {
        if (image ==
              null ||
              c ==
              null)
            return;
        int rgb =
          c.
          copy1(
            ).
          toNonLinear(
            ).
          toRGB(
            );
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++)
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   index++)
                image.
                  setRGB(
                    x +
                      i,
                    y +
                      j,
                    rgb);
        fastRepaint(
          );
    }
    public void imageEnd() { repaint(); }
    private void fastRepaint() { long t =
                                   java.lang.System.
                                   nanoTime(
                                     );
                                 if (repaintCounter +
                                       125000000 <
                                       t) {
                                     repaintCounter =
                                       t;
                                     repaint(
                                       );
                                 } }
    public synchronized void paintComponent(java.awt.Graphics g) {
        super.
          paintComponent(
            g);
        if (image ==
              null)
            return;
        int x =
          (int)
            java.lang.Math.
            round(
              xo +
                (getWidth(
                   ) -
                   w) *
                0.5F);
        int y =
          (int)
            java.lang.Math.
            round(
              yo +
                (getHeight(
                   ) -
                   h) *
                0.5F);
        int iw =
          (int)
            java.lang.Math.
            round(
              w);
        int ih =
          (int)
            java.lang.Math.
            round(
              h);
        int x0 =
          x -
          1;
        int y0 =
          y -
          1;
        int x1 =
          x +
          iw +
          1;
        int y1 =
          y +
          ih +
          1;
        g.
          setColor(
            java.awt.Color.
              WHITE);
        g.
          drawLine(
            x0,
            y0,
            x1,
            y0);
        g.
          drawLine(
            x1,
            y0,
            x1,
            y1);
        g.
          drawLine(
            x1,
            y1,
            x0,
            y1);
        g.
          drawLine(
            x0,
            y1,
            x0,
            y0);
        g.
          drawImage(
            image,
            x,
            y,
            iw,
            ih,
            this);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaf3AU1R1/dyE/SAL5wY9AgIAh0AHxTikUmVAKCQGCF5Im" +
       "SGsQwmbv3WVhb3fd3UsuUVTodEQ7OKgIttX0D7FQisLYOm2nxdKxotYfU631" +
       "54i0ddRWrNJWbdXWfr/v7d7u7d0txiGZ2Ze9t+993/t+vj/e9/veO/ouKTR0" +
       "UkcVM2QOatQItShmh6AbNNosC4axAep6xAMFwj+3vL1+aZAUdZPxfYLRJgoG" +
       "XS1ROWp0kxmSYpiCIlJjPaVR7NGhU4Pq/YIpqUo3mSQZrQlNlkTJbFOjFBts" +
       "FPQIqRJMU5d6kyZttQiYZEYEZhJmMwmv9H5ujJByUdUGneZTXM2bXV+wZcIZ" +
       "yzBJZWSb0C+Ek6YkhyOSYTamdHKxpsqDcVk1QzRlhrbJiy0I1kUWZ0FQf7zi" +
       "w0/29lUyCCYIiqKajD2jkxqq3E+jEVLh1LbINGFcQ64nBRFS5mpskoaIPWgY" +
       "Bg3DoDa3TiuY/TiqJBPNKmPHtCkVaSJOyCQXZRLRBF1IWGQ62JyBQolp8c46" +
       "A7ez0txyLrNYvPPi8L4DWyofLCAV3aRCUrpwOiJMwoRBugFQmuilurEyGqXR" +
       "blKlgLC7qC4JsjRkSbrakOKKYCZB/DYsWJnUqM7GdLACOQJvelI0VT3NXowp" +
       "lPWrMCYLceB1ssMr53A11gODpRJMTI8JoHdWlzHbJSVqkpneHmkeG66ABtC1" +
       "OEHNPjU91BhFgApSzVVEFpR4uAtUT4lD00IVFFA3SW1eooi1JojbhTjtQY30" +
       "tOvgn6DVWAYEdjHJJG8zRgmkVOuRkks+765fduu1ylolSAIw5ygVZZx/GXSq" +
       "83TqpDGqU7AD3rF8fmS/MPnE7iAh0HiSpzFv87Przq1YUHfycd5mWo427b3b" +
       "qGj2iAd7xz87vXne0gKcRommGhIKP4NzZmUd1pfGlAYeZnKaIn4M2R9Pdp66" +
       "6sYj9J0gKW0lRaIqJxOgR1WimtAkmeprqEJ1waTRVjKWKtFm9r2VFMN7RFIo" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9HDLdny64Uy6/mpZTdSoy840RMIDV5+h");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "R+R9sDoAAA==");
}
