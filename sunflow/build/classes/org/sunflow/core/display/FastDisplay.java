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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YP3UH1s0Ja2GkaCvFW0tGZMi0dGkAWWtNTOOaTHybJ41hYG9kuiePhgLzYHt" +
       "MjSBEGNJc6xQomTMFRYhVpw3krUhN5EygQPXjCcGTJcajbjrMsVp3aLmrAB3" +
       "V7Va0Zl3Z/6wV5onxXF7CgdJP9ZmyxBZqVEyI4Puoq3wqMg2qdUGJ1BMbIpe" +
       "Q0CJXg01O2V+bctTqTTF20O1gYHR8WGVRqa1EcZpFTXp4QFeRarVch3aFN1k" +
       "02zyUj3mhWlJx/0Oyi1q6HA6YeJBNWJSfIPGDUNdtbwiYjEtyJhj5UCGoJ4K" +
       "4hZlsVC6slsRIK26nnXrfDKDsQBxU7ppRTMYaprlsimovteqQDozqdkKE2Kw" +
       "Jut812uGcl12RXGxasQNNSmxVDSFxjDYoCFJUTbU9RhecLNuuG76nDIMoY7P" +
       "Nqf9bgpZqxXRrHi9lBcotdtPqnDQN4L6pEnZUFKkmzPRq86TfjgrlqpkR6Yg" +
       "1GpvaoMU7DRXszCA1JVdWliN1KZDQqZZ3lgIfmSs7emcTDWvtPAmgt1PA2HI" +
       "CiaIP+lhsRzMx45R1istnajQpjwn8UHY6rYQpjoCu5lEdodhxa8XJWxA1RoS" +
       "U9GHOImxFEZ15u5yHqpCr8OCvYCwNDEVqa20OR1GFbcBwpDS0DXqC0muyQin" +
       "4WvTRJvFiWYtFBKtlGJj3keBOVXKesu2e2YwCfsIN+bBvnzS6dZpO9pQ0Nwz" +
       "1k3B6pnVHk/0A4LzOLHRqzTZimfHMIHWJUKoW67NjmgRLo3xsKINMQ7tRPVG" +
       "aRyUGMMrofGmQ7VUk1IjfKwM9R7Co5w+CXyKh/rdBllOG7G1Bh6z1cqOc/7+" +
       "/R0zPZyfqB2lX62NRtbw8/dxkhTf4/DwXceJAPnfhcJeEs+Jw8gTt8Nn7nh8" +
       "m6e27NJZspuOZ+6WiJXfcnzqg6++Jo0/XTq7O56W/MJl33b+qiGHsnFirgt5" +
       "3TvCMz8jbYPn+R2ez+8fmh7z5q4XHFe9xBJXrm1pqSxtWb13cn7ueFWE4yIH" +
       "/dw9Dtn/VVb8C79wJb+nRGVVs+54Ghja");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mnS8fL/2zQ4CT06zx488S+W9u+ew/lb5sROCOzHgfA5wfo8Be6z4/Xuw4g+y" +
       "4guA1zkrJq7s8G5+S/H5Y8L/9bdKeCYI2I5w7DtOeA6zPMKglE1YB095h0H+" +
       "6xdm36bLzb1ct+/EsPGhJj9xUpO3l+yYbexSS+94mfifDm8nvnwvXTthzLLC" +
       "OGLmH99+i5i95mlQzu3Xgvnab6fNe2dFdA/p+9N7tP33rPhqVvzIFpN7wH49" +
       "3v7+x3vA/FlWfNEvPJjzjXEk3t8X9De/VUF/D3jInZiR/180/EtZpzNn7073" +
       "mQeyj38O7HZON6EZxh7Vf/EtUJ3b+e8BD7ujmr0Pqo9l7zfuSPpJKh66R9v1" +
       "rLjsFy7lFLYt6TSBZ658qwRm7cqOQOXbSOCZ03764aP8mY7LOytN9HLynroH" +
       "6c9mBeh63uE1y9+j+/H7oTsGmnEi0zVL23vytkz6bfa3+JnXrl164jXm97f5" +
       "LYcZ2pfJwiUlMIyTWVYn6hccV1a0nA+XtzlXTk7Ci3cKUHa5t37h4q6W4Xvm" +
       "xrYHCA2u7/cA3jr7OQlWBBSdAMtuibe1k0AHfuEcAMqqkHO4EKczroDllo34" +
       "zIloZyclufY8cprJV4+YfLSsT524Tg0cwAXPm/Mu8A6qd7eu/u5qFCxC9Zvm" +
       "N2b/kiHvkuXyJKRb4tUHl3/666/8r8I29wQMlU+0nzqbx47ZHfxhZPnwvmxn" +
       "Sax3zgqdAfQN2betLJfz5f/20vV3/8LP/FQ+3UV5i082wvfn6Z+N+yLhMA/w" +
       "ljicfgB5+iN/8od53silPCkQQOTj3p7Al63gzTi78M4TV7JvPx8fCvrRsp1M" +
       "ys2Qyf+l5DDHJNj+U8kt8bOv9Ufv/1r909ukYNHg0zQb5RIgbpufvGPnyTyh" +
       "/dEOx7rQfekbD/3y5RcPI+iHtkJzbDVO4PaOO/O6bTp+njOb/uMn/uG7f+G1" +
       "L+a34v8XNnJR3uszAAA=");
}
