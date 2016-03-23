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
           "9/iFP9mD7pChK+pBYicpdpz7iwySmfAw2wPJ36nvpxOT3S781FHkeuhsVDkx" +
           "7dmYchz0QT+HzvuXbhZGHgFP68DVWmfDyDmo6LyxQHmsaK/lzU+f8trvg985" +
           "8PxP/uTj+cBuZ71KHmzvjx7t7z7YhS5ZDkiUeMXV7YLEqyLo4ZMbU7gNI93Z" +
           "p4+gdvEsb8t586bdzLVbmlEzb4j03LkIOl/ZR/cLH6JvLsZtEUi347ltAde+" +
           "EBaZMMAyLFexC4UREXANW712KIoEMmNgS9eWNnrI/JXCDfJV29+lk2f4JX5k" +
           "foGZ33NMjPFAZvqef3j+i7/2xNeALfag85vcToAJnpiRjfNk/Vc/8b6H73rh" +
           "6+8pgirYhoU3v8N7Nqcq3kLqvDvIGzZvuENRH8xFFbw4UHVGCaNBERB1rZD2" +
           "B7ogH1gO2C42B5ko/MzVr60+9M1P7rLMs/52Blh/1wvv/v7+e1/YO5HbP3FD" +
           "en0SZ5ffF0y/4kDDAfTYD5qlwKC+8elnfv+3nnnnjqurpzPVNjiIffKv/vuL" +
           "+x/8+p/fJHW63fb+Dwsb3W13ayGNH/4YaWZMEnWUTgyuuXGXzWVaEWtqLVvE" +
           "teU6QunRfBixnURpr/hoU0s2zlJbBCJZGm6rfpyxTXRe1TOuMtGnQ4rzlfVi" +
           "KLAiQo7g8rSxskbKhG0TU2woxEvMpsRhx/MRYjZq882h1KcrNOWZBoNU42qM" +
           "RlXdwXDVRfVMzXphFUXLdRQ2dJTip8KsbK+choONFsbAN6VOc17rtcTI9pyg" +
           "zNBcIi2UjU1QcHWMZEanORv1eitDysrEerxWpQ7Vl52AGMueY078ejAIut3O" +
           "IFhYiDOcDFLVk6rDaDSerSWr567pdYi12s2k3jIHrcnYp6Xt3PIyXa0JLZPl" +
           "ImtEtFc2TS8QemxiK0Hhwg4S6vpM53muMR+qazWqG5QwHtVdsj7sq5gkid6a" +
           "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" +
           "Yy9+tSh9/S9Chz0P/x8AAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d8rB8RP+iMO//g9vZJc7cR8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
