package org.sunflow.core.display;
public class FrameDisplay implements org.sunflow.core.Display {
    private java.lang.String filename;
    private org.sunflow.core.display.FrameDisplay.RenderFrame frame;
    public FrameDisplay() { this(null); }
    public FrameDisplay(java.lang.String filename) { super();
                                                     this.filename = filename;
                                                     frame = null; }
    public void imageBegin(int w, int h, int bucketSize) { if (frame == null) {
                                                               frame =
                                                                 new org.sunflow.core.display.FrameDisplay.RenderFrame(
                                                                   );
                                                               frame.
                                                                 imagePanel.
                                                                 imageBegin(
                                                                   w,
                                                                   h,
                                                                   bucketSize);
                                                               java.awt.Dimension screenRes =
                                                                 java.awt.Toolkit.
                                                                 getDefaultToolkit(
                                                                   ).
                                                                 getScreenSize(
                                                                   );
                                                               boolean needFit =
                                                                 false;
                                                               if (w >=
                                                                     screenRes.
                                                                     getWidth(
                                                                       ) -
                                                                     200 ||
                                                                     h >=
                                                                     screenRes.
                                                                     getHeight(
                                                                       ) -
                                                                     200) {
                                                                   frame.
                                                                     imagePanel.
                                                                     setPreferredSize(
                                                                       new java.awt.Dimension(
                                                                         (int)
                                                                           screenRes.
                                                                           getWidth(
                                                                             ) -
                                                                           200,
                                                                         (int)
                                                                           screenRes.
                                                                           getHeight(
                                                                             ) -
                                                                           200));
                                                                   needFit =
                                                                     true;
                                                               }
                                                               else
                                                                   frame.
                                                                     imagePanel.
                                                                     setPreferredSize(
                                                                       new java.awt.Dimension(
                                                                         w,
                                                                         h));
                                                               frame.
                                                                 pack(
                                                                   );
                                                               frame.
                                                                 setLocationRelativeTo(
                                                                   null);
                                                               frame.
                                                                 setVisible(
                                                                   true);
                                                               if (needFit)
                                                                   frame.
                                                                     imagePanel.
                                                                     fit(
                                                                       );
                                                           }
                                                           else
                                                               frame.
                                                                 imagePanel.
                                                                 imageBegin(
                                                                   w,
                                                                   h,
                                                                   bucketSize);
    }
    public void imagePrepare(int x, int y,
                             int w,
                             int h,
                             int id) { frame.
                                         imagePanel.
                                         imagePrepare(
                                           x,
                                           y,
                                           w,
                                           h,
                                           id);
    }
    public void imageUpdate(int x, int y,
                            int w,
                            int h,
                            org.sunflow.image.Color[] data) {
        frame.
          imagePanel.
          imageUpdate(
            x,
            y,
            w,
            h,
            data);
    }
    public void imageFill(int x, int y, int w,
                          int h,
                          org.sunflow.image.Color c) {
        frame.
          imagePanel.
          imageFill(
            x,
            y,
            w,
            h,
            c);
    }
    public void imageEnd() { frame.imagePanel.
                               imageEnd(
                                 );
                             if (filename !=
                                   null) frame.
                                           imagePanel.
                                           save(
                                             filename);
    }
    @java.lang.SuppressWarnings("serial") 
    private static class RenderFrame extends javax.swing.JFrame {
        org.sunflow.system.ImagePanel imagePanel;
        RenderFrame() { super("Sunflow v" +
                              org.sunflow.SunflowAPI.
                                VERSION);
                        setDefaultCloseOperation(
                          EXIT_ON_CLOSE);
                        addKeyListener(new java.awt.event.KeyAdapter(
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
                        imagePanel = new org.sunflow.system.ImagePanel(
                                       );
                        setContentPane(imagePanel);
                        pack(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5RQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUZbXAV1fW+l0+SQD4QgiEJEAIdPnwPLFadUAqEBIKPkBKk" +
       "bbCGzb77koV9u+vufckLiiIzLVSnDFUE2sH8KRR0EBinju20WlqnqKM4A9r6" +
       "wQi1ta0tdSrTqdra1p5z7+7bj/deMA68mb27e/ecc88593zed+x9UmSZpJFq" +
       "LMKGDWpF2jTWJZkWjbeqkmWth7leeX+B9I873+u8NUyKe8iEAclaI0sWbVeo" +
       "Grd6SIOiWUzSZGp1UhpHjC6TWtQclJiiaz1kkmJ1JA1VkRW2Ro9TBNggmTFS" +
       "LTFmKn0pRjtsAow0xICTKOckuiz4uSVGKmTdGHbBp3jAWz1fEDLprmUxUhXb" +
       "LA1K0RRT1GhMsVhL2iTzDF0d7ld1FqFpFtms3mSrYHXspiwVNJ2s/PCTPQNV" +
       "XAUTJU3TGRfPWkctXR2k8RipdGfbVJq07iL3koIYKfcAM9IccxaNwqJRWNSR" +
       "1oUC7sdTLZVs1bk4zKFUbMjIECMz/EQMyZSSNpkuzjNQKGW27BwZpJ2ekVZI" +
       "mSXiI/Oie/ffWfVkAansIZWK1o3syMAEg0V6QKE02UdNa1k8TuM9pFqDze6m" +
       "piKpylZ7p2sspV+TWAq231ELTqYMavI1XV3BPoJsZkpmupkRL8ENyn4rSqhS" +
       "P8g62ZVVSNiO8yBgmQKMmQkJ7M5GKdyiaHFGpgUxMjI23wYAgFqSpGxAzyxV" +
       "qEkwQWqEiaiS1h/tBtPT+gG0SAcDNBmpy0sUdW1I8hapn/aiRQbgusQngBrH" +
       "FYEojEwKgnFKsEt1gV3y7M/7nYt3362t0sIkBDzHqawi/+WA1BhAWkcT1KTg" +
       "BwKxYm5snzT5mV1hQgB4UgBYwDx9z+Wl8xtPvSBgpuaAWdu3mcqsVz7UN+Fs" +
       "feucWwuQjVJDtxTcfJ/k3Mu67C8taQMizOQMRfwYcT6eWnf6G9sfp5fCpKyD" +
       "FMu6mkqCHVXLetJQVGqupBo1JUbjHWQc1eKt/HsHKYHnmKJRMbs2kbAo6yCF" +
       "Kp8q1vk7qCgBJFBFZfCsaAndeTYkNsCf0wYhpAQuMh+uSiJ+/M7IhuiAnqRR" +
       "SZY0RdOjXaaO8ltRiDh9oNuBqJXSEqo+FLVMOaqb/Zl3WTdpNK5YhioNR9vB" +
       "NekK8RJB+zKuGeU0yjRxKBQCddcHnV0FP1mlq3Fq9sp7U8vbLh/vfUkYEhq/" +
       "rQ1GZsFyEXu5CC4XsZeLeJcjoRBf5TpcVmwobMcWcGyIrBVzur+5etOupgKw" +
       "JGOoEHQZBtAmX4Zpdb3fCdm98oma8VtnXFj4XJgUxkiNJLOUpGLCWGb2QyiS" +
       "t9jeWtEHucdNAdM9KQBzl6nLNA4RKF8qsKmU6oPUxHlGrvNQcBIUumI0f3rI" +
       "yT85dWDo/g33LQiTsD/q45JFELAQvQtjdSYmNwe9PRfdyp3vfXhi3zbd9Xtf" +
       "GnGyXxYmytAUtIOgenrludOlp3qf2dbM1T4O4jKTwI8g5DUG1/CFlRYnRKMs" +
       "pSBwQjeTkoqfHB2XsQFTH3JnuIFW8+frwCzK0c9q4ZpoOx6/49fJBo61wqDR" +
       "zgJS8BTw5W7j0Tde+csXubqdbFHpSfPdlLV4IhQSq+GxqNo12/UmpQD39oGu" +
       "hx95f+dGbrMAMTPXgs04tkJkgi0ENX/rhbvevHjh0GvhjJ2HGKToVB9UOumM" +
       "kDhPykYRElab7fIDEU6FWIBW03y7BvapJBSpT6XoWP+pnLXwqb/trhJ2oMKM" +
       "Y0bzr0zAnb9+Odn+0p0fNXIyIRkzrKszF0yE7Yku5WWmKQ0jH+n7zzV8/3np" +
       "UUgAEHQtZSvlcZRwHRC+aTdx+RfwcVHg2804zLK8xu/3L08l1Cvvee2D8Rs+" +
       "ePYy59ZfSnn3eo1ktAjzwmF2GsjXBoPTKskaALhFpzrvqFJPfQIUe4CiDPWD" +
       "tdaEwJj2WYYNXVTy1i+fm7zpbAEJt5MyVZfi7RJ3MjIOrJtaAxBT08ZXlorN" +
       "HSqFoYqLSrKEz5pABU/LvXVtSYNxZW/9Se2PFx8ZucCtzOAkGrI9qNY2rtrc" +
       "HoTjF3CYl22X+VADOxgSFs7fp0A5zdnGUikiSiW+0spRtv02HJbzT7fg0Cr0" +
       "0fI5VYcTywzxYWomy9T7sgxvUNxA9/irN//myPf2DYkSZ07+6B7Am/LvtWrf" +
       "jt9/nGWCPK7nKL8C+D3RYwfrWpdc4vhugEXs5nR2qoYk5eLe+Hjyn+Gm4l+H" +
       "SUkPqZLthmCDpKYwbPVAEWw5XQI0Db7v/oJWVG8tmQRSHwzunmWDod0tEeAZ" +
       "ofF5fCCaV+C+1Dt76Ny9thgi/OFrwhz5OBeHG5zgWWKYCjSNNBA9y0chykgp" +
       "VnkOg6tce+dG9vUrGdlX/fw3wlVtL1Wdh/9Nrjv1ZDOaD5uBSrGCchxo4Wcq" +
       "tJrXQX1LTT4VEE0aRbR0Lo/nv2ISqHODHj/V7+dTsti0OcMI25CvV+F91qEd" +
       "e0fiaw8vFO5W46//26C9feK3/305cuB3L+YoQ8cx3bhBpYNU9TCFBxUNPgdf" +
       "w9s411venvDQH37a3L98LBUkzjVeoUbE92kgxNz8MSPIyvM7/lq3fsnApjEU" +
       "g9MC6gySfGzNsRdXzpYfCvOeVbhxVq/rR2rxO2+ZSaE519b7XHimP53cYrux" +
       "485jTCf5UAOZoYDvaIG/McCt6k71WVDEK0mo2Qbt/vXGrk3yruaud4UlXZ8D" +
       "QcBNOhr97obXN7/MdV6Km5yR1LPBYAyecrRKiPAp/EJw/Q8vZB0n8A5RtNVu" +
       "RqdnulHDQPMfJYMEBIhuq7m45eB7TwgBgukiAEx37X3g08juvcItxJHGzKxT" +
       "BS+OONYQ4uCwHbmbMdoqHKP9zye2/ezotp1hO0PrjBQo9mmTN+VD/e1XueBz" +
       "xXcqf76npqAdnK2DlKY05a4U7Yj7Da7ESvV59sA9AXHNz+YY9c1IaC6oFifu" +
       "4wN/vGeUomI3DkMM0mBS6qfLab8iHGyHrQa8fZuRwkFdibuhM301Sg8+b/l9" +
       "B+ktsB1gwdh9Jx9qQAFFIhq6agoMfKWDo2htBIf9jFRwrXWZFDoaviN7XB0d" +
       "uFY6aoNrkS3oorHrKB/qZ9eR/7g7E0J4eyMs+47y07+wfvinJ4W75gpQgQO2" +
       "o0dK5fPJ0+86nnRvhm+UlqyG64zN9xkRVDo/7xGQNWwxmox28J2TNKo6h0pX" +
       "mSKGkFn5A5xHWyM/mvnKfSMz3+H9VKliQQKFEJvjKNOD88Gxi5fOjW84zhN1" +
       "IUZqO0L4z4Czj3h9J7dc15U4PJF2CpZab8HC7Rv7Kt00DIMEIxu+PpjmVB4b" +
       "xV2exuEQI+Wc3O1GHFJAwFsOXytvWUJERibOfWzekg91DN5yBb1yJn41ivZO" +
       "4/AMlHQcqV1R1YDunr1WuquDa7GtgMVj110+1FFkPTvKt1dxeBn6Fa6HNi0e" +
       "UMOZq9IPQ1D39g94wjAl638f8V+FfHyksrR25PbXhRM6/ydUQOmUSKmqt+fz" +
       "PBcbJk0oXKIK0QGKhH0+V69gtzTQ2dlPnO+3BMYFRqqCGJCq8eYFewcczwPG" +
       "sKbgT16gd6F0ASB8/KOR44xCdL/pkKebsJXIdT/pSrrPoHiPBjEo8r/enOyQ" +
       "En++9conRlZ33n35S4fF0aSsSlu3IpVyiF/ilDRT88/IS82hVbxqzicTTo6b" +
       "5eSWasGwa79TPUa2DKKagZteFzi3s5ozx3dvHlr87JldxecgXm8kIYmRiRuz" +
       "zwnSRgqarY2x7MIPwjs/UGyZ84PhJfMTfz/PT6aIKBTr88P3yj0Pv9FxcstH" +
       "S/l/PUVQgNI0P8BYMayto/Kg6asiJ6A9SniyxPVgq298ZhYPshlpyq6Ls4//" +
       "y8BYqLlcTwmfgyxT7s44icXXJqUMI4DgznhSzwM4bE+j9sH+emNrDMNpGxIG" +
       "98gHc6ccHD/mjzj86/81ZCFphR8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NG0vyu+npL9772++7Jee+HR+Vvn/BD6ExUYrAAA=");
}
