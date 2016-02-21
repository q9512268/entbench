package org.sunflow.core.display;
@java.lang.SuppressWarnings("serial") 
public class ImgPipeDisplay extends javax.swing.JPanel implements org.sunflow.core.Display {
    private int ih;
    public ImgPipeDisplay() { super(); }
    public synchronized void imageBegin(int w, int h, int bucketSize) { ih =
                                                                          h;
                                                                        outputPacket(
                                                                          5,
                                                                          w,
                                                                          h,
                                                                          java.lang.Float.
                                                                            floatToRawIntBits(
                                                                              1.0F),
                                                                          0);
                                                                        java.lang.System.
                                                                          out.
                                                                          flush(
                                                                            );
    }
    public synchronized void imagePrepare(int x,
                                          int y,
                                          int w,
                                          int h,
                                          int id) {
        
    }
    public synchronized void imageUpdate(int x,
                                         int y,
                                         int w,
                                         int h,
                                         org.sunflow.image.Color[] data) {
        int xl =
          x;
        int xh =
          x +
          w -
          1;
        int yl =
          ih -
          1 -
          (y +
             h -
             1);
        int yh =
          ih -
          1 -
          y;
        outputPacket(
          2,
          xl,
          xh,
          yl,
          yh);
        byte[] rgba =
          new byte[4 *
                     (yh -
                        yl +
                        1) *
                     (xh -
                        xl +
                        1)];
        for (int j =
               0,
               idx =
                 0;
             j <
               h;
             j++) {
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   idx +=
                     4) {
                int rgb =
                  data[(h -
                          j -
                          1) *
                         w +
                         i].
                  toNonLinear(
                    ).
                  toRGB(
                    );
                int cr =
                  rgb >>
                  16 &
                  255;
                int cg =
                  rgb >>
                  8 &
                  255;
                int cb =
                  rgb &
                  255;
                rgba[idx +
                       0] =
                  (byte)
                    (cr &
                       255);
                rgba[idx +
                       1] =
                  (byte)
                    (cg &
                       255);
                rgba[idx +
                       2] =
                  (byte)
                    (cb &
                       255);
                rgba[idx +
                       3] =
                  (byte)
                    255;
            }
        }
        try {
            java.lang.System.
              out.
              write(
                rgba);
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public synchronized void imageFill(int x,
                                       int y,
                                       int w,
                                       int h,
                                       org.sunflow.image.Color c) {
        int xl =
          x;
        int xh =
          x +
          w -
          1;
        int yl =
          ih -
          1 -
          (y +
             h -
             1);
        int yh =
          ih -
          1 -
          y;
        outputPacket(
          2,
          xl,
          xh,
          yl,
          yh);
        int rgb =
          c.
          toNonLinear(
            ).
          toRGB(
            );
        int cr =
          rgb >>
          16 &
          255;
        int cg =
          rgb >>
          8 &
          255;
        int cb =
          rgb &
          255;
        byte[] rgba =
          new byte[4 *
                     (yh -
                        yl +
                        1) *
                     (xh -
                        xl +
                        1)];
        for (int j =
               0,
               idx =
                 0;
             j <
               h;
             j++) {
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   idx +=
                     4) {
                rgba[idx +
                       0] =
                  (byte)
                    (cr &
                       255);
                rgba[idx +
                       1] =
                  (byte)
                    (cg &
                       255);
                rgba[idx +
                       2] =
                  (byte)
                    (cb &
                       255);
                rgba[idx +
                       3] =
                  (byte)
                    255;
            }
        }
        try {
            java.lang.System.
              out.
              write(
                rgba);
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public synchronized void imageEnd() {
        outputPacket(
          4,
          0,
          0,
          0,
          0);
        java.lang.System.
          out.
          flush(
            );
    }
    private void outputPacket(int type, int d0,
                              int d1,
                              int d2,
                              int d3) { outputInt32(
                                          type);
                                        outputInt32(
                                          d0);
                                        outputInt32(
                                          d1);
                                        outputInt32(
                                          d2);
                                        outputInt32(
                                          d3);
    }
    private void outputInt32(int i) { java.lang.System.
                                        out.
                                        write(
                                          i >>
                                            24 &
                                            255);
                                      java.lang.System.
                                        out.
                                        write(
                                          i >>
                                            16 &
                                            255);
                                      java.lang.System.
                                        out.
                                        write(
                                          i >>
                                            8 &
                                            255);
                                      java.lang.System.
                                        out.
                                        write(
                                          i &
                                            255);
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
       "T4JSXDnPCypXgXD7fKzjb4C33ZPaEa0H");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("B89+85FffOgdR98rj+yN5gQkTvH2lrvrmvDCpMwRyn/1jb/8rk++9MXyjPv/" +
       "ANOhSN7kLAAA");
}
