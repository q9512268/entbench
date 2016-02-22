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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVZfWwUxxWfO39iG2wM5ivYBmOQTOgdpCFpZKCAwcHkDCdM" +
           "SGs+zNzenG9hb3fZnbXPTmmTSBEkShFJHEKrwB8VUVJKAq0aJVWTyFXUJjRJ" +
           "VdK0SVpBqjZVaVPUoKpJVdqm783u3X6c75ClxNKOZ2ffm3lf83tv5s5cIRWm" +
           "QVqYyiN8RGdmZKPK49QwWbJLoaa5HcYGpMfL6D/2XN5yW5hU9pNpaWr2StRk" +
           "3TJTkmY/aZZVk1NVYuYWxpLIETeYyYwhymVN7SdNstmT0RVZknmvlmRIsIMa" +
           "MTKdcm7ICYuzHmcCTppjIElUSBJdF/zcGSN1kqaPuORzPORdni9ImXHXMjlp" +
           "iO2jQzRqcVmJxmSTd2YNcqOuKSODisYjLMsj+5SVjgk2x1YWmKDtXP3H146m" +
           "G4QJZlBV1bhQz9zGTE0ZYskYqXdHNyosYx4gXydlMVLrIeakPZZbNAqLRmHR" +
           "nLYuFUg/lalWpksT6vDcTJW6hAJxstA/iU4NmnGmiQuZYYZq7ugumEHbBXlt" +
           "bS0LVHzsxujY43saflBG6vtJvaz2oTgSCMFhkX4wKMskmGGuSyZZsp9MV8HZ" +
           "fcyQqSKPOp5uNOVBlXIL3J8zCw5aOjPEmq6twI+gm2FJXDPy6qVEQDlvFSmF" +
           "DoKus1xdbQ27cRwUrJFBMCNFIe4clvL9sprkpDXIkdex/Q4gANaqDONpLb9U" +
           "uUphgDTaIaJQdTDaB6GnDgJphQYBaHAyr+ikaGudSvvpIBvAiAzQxe1PQDVF" +
           "GAJZOGkKkomZwEvzAl7y+OfKllVH7lY3qWESApmTTFJQ/lpgagkwbWMpZjDY" +
           "BzZj3dLYMTrrpcNhQoC4KUBs0zz/tatrl7WMv2bT3DABzdbEPibxAelUYtqF" +
           "+V0dt5WhGNW6ZsrofJ/mYpfFnS+dWR0QZlZ+RvwYyX0c3/azr95zmn0YJjU9" +
           "pFLSFCsDcTRd0jK6rDDjdqYyg3KW7CFTmJrsEt97SBX0Y7LK7NGtqZTJeA8p" +
           "V8RQpSbewUQpmAJNVAN9WU1pub5OeVr0szohpA4esgue+cT+E/852RJNaxkW" +
           "pRJVZVWLxg0N9TejgDgJsG06alpqStGGo6YhRTVj0H0fMTnLRHsy4PY4VZkS" +
           "wbjSP/MZs6jDjOFQCMw7P7i5FdgXmzQlyYwBacxav/HqswOv24GDwe5oz8ly" +
           "WCbiLBOxl4m4y7T3SYamKP2alkHMRGeQUEgsOBMlsH0JntgPexoI6jr6dm/e" +
           "e7itDIJIHy4HMyJpmy+5dLkbP4fWA9LZxqmjCy+teCVMymOkkUrcogrminXG" +
           "IKCQtN/ZqHUJSDsu+i/woD+mLUOTWBLAp1gWcGap1oaYgeOczPTMkMtNuAuj" +
           "xTPDhPKT8ePD9+74xvIwCfsBH5esAKxC9jjCdB6O24MbfaJ56w9d/vjssYOa" +
           "u+V9GSSX+Ao4UYe2YEgEzTMgLV1Anxt46WC7MPsUgGROYQsB2rUE1/AhSmcO" +
           "nVGXalA4pRkZquCnnI1reNrQht0REavTsWmywxZDKCCgAPbVffqJd3/xly8K" +
           "S+ZyQL0nefcx3unBHZysUSDMdDcitxuMAd3F4/FHH7tyaKcIR6BYNNGC7dh2" +
           "Ad6Ad8CC97924L33L516O+yGMCdVuiFDNcOyQpmZn8JfCJ7/4YNggQM2aDR2" +
           "Oci1IA9dOi69xBUOQEyBbY/R0X6nCnEop2SaUBhuoP/UL17x3N+ONNj+VmAk" +
           "Fy7Lrj+BOz53Pbnn9T2ftIhpQhImUdeALpmNzDPcmdcZBh1BObL3vtX8rVfp" +
           "CcB4wFVTHmUCKokwCBEeXClssVy0Nwe+3YrNYtMb5P595Cl2BqSjb380dcdH" +
           "L18V0vqrJa/je6neaYeR7QVYbDdxGh9049dZOrazsyDD7CBSbaJmGia7eXzL" +
           "rgZl/Bos2w/LSlBHmFsNAMysL5Yc6oqq3/7klVl7L5SRcDepUTSa7KZix5Ep" +
           "EOrMTAPWZvUvr7XlGK6GpkHYgxRYqGAAvdA6sX83ZnQuPDL6wuwfrnrq5CUR" +
           "l7o9xw2Cvxzh3wexojB3d/npX93666cePjZsp/aO4tAW4Jvz761K4r4//KvA" +
           "LwLUJig7Avz90TNPzOta86Hgd9EFuduzhSkLENrlvel05p/htsqfhklVP2mQ" +
           "nEJ4B1Us3Nj9UPyZueoYimXfd38hZ1ctnXn0nB9ENs+yQVxzUyX0kRr7UwMx" +
           "iJ4m9fA0OzHYHIzBEBGdzYJliWg7sFnmjYf8VNUlpuIknMn6MypmrT4rYUL2" +
           "kzOAiENOzXdTfK90uD3+ge30uRMw2HRNT0e/ueOdfW8IvK3G/Lo9p6gne0Ie" +
           "9uB4AzYRFKREMAXkiR5sfH//E5efseUJRk6AmB0ee/DTyJExGwbtqn5RQWHt" +
           "5bEr+4B0C0utIji6/3z24I+fPnjIlqrRX6NuhCPYM7/57xuR478/P0HpVCY7" +
           "JzPcyqF8tTPTb2pboQ0P1L94tLGsGxJtD6m2VPmAxXqS/girMq2Ex/buacGN" +
           "Okc1TDechJYCDti5FNsvYXOHHUyriuLQhsK4bXGCraVI3FI7brHpLQzVYtwY" +
           "qiPY2xYQMTFJEefC0+os0lpExHRJEYtxc1KdNOjgIBz0BFPcCRz81+fp3wUF" +
           "QELTFEbVoL/xdXfQCfIkNZwDzwJHxgVFNOQlNSzGDYKPQu0OCuJrJiCnVULO" +
           "7MRgJRT+gotYAsBqSfEE7MlTIdGfw8lCkeroMIDGEG6WXs0y2V1pxpTcIQM3" +
           "b3Oxg7DYuKfuGzuZ3PrkirBTcXyFk0rnfsKfGZt9mbFXnPvdNHNx2iN//FH7" +
           "4PrJnDtwrOU6Jwt8bwVEWVocH4OivHrfX+dtX5PeO4kjRGvARMEpv9t75vzt" +
           "S6RHwuKSw85/BZcjfqZOPybVGIxbhupHoUV59yN8kAg8bY7724Lh64ZcYSyB" +
           "y3QrochSIANOKzFhoOgM+SNr7kSRtRG7QpCjJUrWMWwe4OhW4MELTJMlJ4KC" +
           "8iFNTrqb6MHrbfbSlR8OrNfF+P2FZl3tWGF1CbNi81ChAYuxTmxAfH1YzPqd" +
           "EjY6hc2JnI02IHayJI4dc+1x8vOyRxSeTY5SmyZvj2Ks17PH2RL2+D42pzmZ" +
           "KuyxjUGGMAsM8r3PyyC3wNPraNU7eYMUYy29w1qKYre7zV4sYbJxbJ6Hg10m" +
           "z9gLoBk02gufhdGycBIovMDKadJc8uYLMsecgvty+45XevZkffXsk3e+I5JG" +
           "/h62DuA/ZSmK98zg6VfqBkvJwgZ19gnCLt5+DkIWSgLQaHeEtOdt0jc5qfWQ" +
           "cqwYRc9L9EsoTIEIuxf0nK6LxHVhxByGSsDruB5Vt/i6JNU55NyQJ3M6RhW+" +
           "aLqeL/Is3hsWzHfid4lcbrLsXyYGpLMnN2+5++otT9o3PJJCR0dxllqogO17" +
           "pHx+W1h0ttxclZs6rk07N2Vxrgzw3TB5ZRMRAXEsLmPmBW48zPb8xcd7p1a9" +
           "/Obhyreg3t9JQpSTGTsLD5NZ3YLCYmessNKHWkBcxXR2fHtkzbLU338njuvE" +
           "PhnML04Ph+VH3+05t/+TteIivAIqHJYVp9wNI+o2Jg0ZvmPDNAw6ir9QCDs4" +
           "5puaH8WrPk7aCk9MhRekNRA/zFivWarYg3DwqHVHfD+QOIFcY+l6gMEd8RwS" +
           "d9lpE60PITkQ69X13DXZRV3s0N3Fq+kPRBebP/0fxc226KIcAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/LI4/eO7/+iNv/vst/ND9v8DDhxjjdomAAA=");
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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaf3AU1R1/dyE/SAL5wY9AgIAh0AHxTikUmVAKCQGCF5Im" +
       "SDUIYbP37rKwt7vu7iWXKFbodEQ7OKgIttX0D7FQisLYOm2nxdKxotYfU631" +
       "54i0ddRWrNJWbdXWfr/v7d7u7d0txiGZ2Ze9t+993/t+vj/e9/veO/ouKTR0" +
       "UkcVM2QOatQItShmh6AbNNosC4axAep6xAMFwj+3vL1+aZAUdZPxfYLRJgoG" +
       "XS1ROWp0kxmSYpiCIlJjPaVR7NGhU4Pq/YIpqUo3mSQZrQlNlkTJbFOjFBts" +
       "FPQIqRJMU5d6kyZttQiYZEYEZhJmMwmv9H5ujJByUdUGneZTXM2bXV+wZcIZ" +
       "yzBJZWSb0C+Ek6YkhyOSYTamdHKxpsqDcVk1QzRlhrbJiy0I1kUWZ0FQf7zi" +
       "w0/29lUyCCYIiqKajD2jkxqq3E+jEVLh1LbINGFcS24gBRFS5mpskoaIPWgY" +
       "Bg3DoDa3TiuY/TiqJBPNKmPHtCkVaSJOyCQXZRLRBF1IWGQ62JyBQolp8c46" +
       "A7ez0txyLrNYvPPi8L4DWyofLCAV3aRCUrpwOiJMwoRBugFQmuilurEyGqXR" +
       "blKlgLC7qC4JsjRkSbrakOKKYCZB/DYsWJnUqM7GdLACOQJvelI0VT3NXowp" +
       "lPWrMCYLceB1ssMr53A11gODpRJMTI8JoHdWlzHbJSVqkpneHmkeG66ABtC1" +
       "OEHNPjU91BhFgApSzVVEFpR4uAtUT4lD00IVFFA3SW1eooi1JojbhTjtQY30" +
       "tOvgn6DVWAYEdjHJJG8zRgmkVOuRkks+765fdut1ylolSAIw5ygVZZx/GXSq" +
       "83TqpDGqU7AD3rF8fmS/MPnE7iAh0HiSpzFv87Prz61YUHfycd5mWo427b3b" +
       "qGj2iAd7xz87vXne0gKcRommGhIKP4NzZmUd1pfGlAYeZnKaIn4M2R9Pdp66" +
       "+sYj9J0gKW0lRaIqJxOgR1WimtAkmeprqEJ1waTRVjKWKtFm9r2VFMN7RFIo" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KgM03PRQZzgcWtko3giziks0rXXPNez6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NjQHs9qyxie2rfSraZmg1rJXzrSO3LcXbSoLy8g8KrdhT1nCbafNBVhEbniC" +
       "dmkTNBuwzmQ4TEAVnMxjauKV1d5QneL6VmfiJaxXQqM9twe1jlWvwX5nMQVb" +
       "56nQGMVGhKquWPPgYTe1Z/1Ow1YbU10MmkMsrbmdThtBt21jwU8CpF1f1OLx" +
       "yF+b+qY6h5KG4UN6zYCQ7nDtTqqVbYSi6FvzR2+/dnuP/x4qnnRey6rbP/X7" +
       "2G089UvOeNj7ppNEkOJ3V+ngdeqph8ensgOOjp+zPno6pyl/3XmlqwWuKaT5" +
       "e8THb5VfV7xD/Oi7nn9Bmv5S9dz+/c8iLN0TOu7fNOVYNk+NtXvhu74+K+eN" +
       "4Hj7ns+3Hz7kPpHNrUAXIjt4F3V0QvCxguDfnfGy6rN58Rth6c5AiOWbPhmP" +
       "HU06mZ/ffLGnsqcHOABcvFOogUPYAxZuA3DxvhQLgRRTW9z4jq1lsnRT/OdO" +
       "6IvXqPOC6ktnCOE/5cXnAVbJF4oH7J87AfzvXwnA6h6wetuA8+KLtwHzv5wB" +
       "82t58UcAZuY41gHMP34ZMItXaZfB8bN7mD97uzDfdGuYpwH86Rl1/zMvvhmW" +
       "zvtyIIcH6P77y0X3FDg+tEf3oe8Rur+8dd1RMd6fh6U7FO0Q21+8XGw9cHx8" +
       "j+3jryC2O06Wg/n1Wnp08Qyo9+XF+bB0sXhJ3ZFVzb4e8dFdLxfxGByf3iP+" +
       "9CuI+HxBdf4A8QH2h8/A/mhePAScXIGdyt9b+vIB+ksvF32eF/l7e/S/99eD" +
       "vqAhrrFRzUdtlna+sXT8H5aIl5WftF+wj5OdXrnOkuMg4ZHTQcIuhwJzzP3H" +
       "CDfLAjq6vH9RffTMi8l0HyflxY8eC+7o6RszgPLLt+fF1RtTeorJ3g1btM6v" +
       "lTPUrXpGXT0voLzG2HFyBm0j2f0/dQZNHu0dPR6W7i3kxriSEB5q9hMvV7NH" +
       "4PjCXqW+8Ndm10c/UABEzwCfL+NHbwFxYQEe10zzAPpbXwb0Io7MEyS+sof+" +
       "lduAfkYceRrA+Iy6PGA8GoSluwtwPVs6wEa8DGxFIsgT4PjqHttXbxcb9qLY" +
       "VmfU5aZ4BAL6exUhCOe7NJIDeMzL1doWOL6xh/eNV1BrT3uF14b7jOs8+6vv" +
       "C+5GE4MCoXwGei0v3hGW7t+nz1iuY8s3CEC4HQEkYGE/+VYkT3x/9IZPzHaf" +
       "RYmffOGBux95gfkPu1zb40+X7iFLdyuRaZ7OUz51fpfry4pWyOOeXdayW0AB" +
       "C8KlGz9bybOPi5OczyNnRxqA6T5FGpYu7M9OE8UgFgNE+enWPRbxpWK1uBJs" +
       "NVu9MiwQJjv5P3p6/ouw7WAZv++a1K5N2GOnUn8iF+AKAk7wwWKmBrdqGu7T" +
       "eIBY4RfN+c+/PpT3CeRFivNV8b57V3/6b5/789Iu2xV0VQx0+DnJpWOHc2mv" +
       "tZcOtTb/sOPmX0rQgH1TDh07/77hmf/x5gff8rF/+PPFcBfkHT95D28tPolo" +
       "3RaE49z4q+J49s726977J18qklXvLhLlAUXR741J7fkM/nSSK0KRLZvf+1hy" +
       "rLnXpu30hyo5M8XXk8eJrdHu+8mr4qdeGE5+/NvNX9p9KCOaQpblvdwNwO2+" +
       "2dmL83Rm8mFvx33dNXjzd+7/1XveePxU4f6d0pz4g1O8vf7msu5Zblh8R5L9" +
       "i0d+7S0fe+EPiwyu/w8jQ+J/1joAAA==");
}
