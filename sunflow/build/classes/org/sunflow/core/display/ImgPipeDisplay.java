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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "583vjKz4vGkHa9RiNBON8QWVNKo6iYyTLBFZf15ptvSgNfbduS9eNzb3tzx+" +
       "r1Us4F+g6yIJNE+fj/a/e+Tl8TMe5DxfiWxuu0x/5rEwsejLF3KsG7G4O+e4" +
       "sSleN8bNHuN43TQMwzXnkOs2EzkuZXeZXXQfFrczUs/FrTGSEDwFNtGOU7WJ" +
       "roDrItt0Ljppm6iUxBPYRMeBm8/tB2VAPYjF9yFQ4J16FFUNQLr/VEE63+Ym" +
       "h6NODqSlJJaB4Iky757E4hEG+wnh6daSAXQePQXo8LPNUrjW2bqsK4MOFvHC" +
       "c1Kprp/Hs71YBp9fYvEseDY9y4wsw9Q+ZQGMfnGqMJoLV8JWNHHiGJXqGlDX" +
       "Q1ICj7fK4PE2Fq8CRwk8Yho779wAHK+dDDhyjEzw554xaTK14IOW+AgjPzjW" +
       "WDtlbM1rguedDyUNEJmnsqrqPdZ7nqsNk6YUrlaDOOSLQ9Ifih1S7IQ4HN7t" +
       "Jz7z90SPw4w0BXtA7Ig3b7MjiJvbjOE5jj95G/0VjovQCB8/NBz6a+GuMmKN" +
       "KFo6spx7z1zIc+KxgeT4t/rxb8jjnz+CtfHcE6ZLIv1ZA1CwrHWSCe48bZXq" +
       "ykjVMCZbYBHOP276Dr+FUjs7w51xQm6ov+pvP9v2LyIOxyDK41nd3ArPkbYR" +
       "kTglzt1r9ZijLZ4564fpq5TpGmbPFn64oGnR3rt38+FqqJgPSljKk28XnpAK" +
       "TuIpIfdeecPF0295/02RMuFZKGjB5RZmjLA4BnZcbfFPpg74TR7w+SfHnLMv" +
       "8kvpzUPjBPnXXic0zIrvvQn5wNjyFdcc/cJ9Ig8uq9JWfqapB4VFSj5/Xpxd" +
       "Upojq3rZgmMTHho3zwksm4UhuRwzzcMBi8EeDISxLZAktjryueI39ix6/IXt" +
       "1S/DAqwnIYmRiesLk3Q5IwsH9fXxwjQIxHY8e9254Nujl56Z+vAtngYlBcnP" +
       "YPuEPHDH67GHNn9yGf+8WKVoSZrj2cPLR7VVVB42fTmVCcgUEi4Cx8GGb3y+" +
       "Fr+aMDKnMJ1U+K2pDrYxNZfoWeFCIcSsd2ucqNJ3xIadF+jg1nh2xwYs+nOI" +
       "PjBDIt5rGE62bcjguyJRPN6EMsSzQAl8av4/s6Q87fghAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "i1PuMmm1uF2mR7p+PG2nE5UKZsrc2qNY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Pd5n196WP/8Sxf3wq/Av7BOlZEvK84LKVQBun7N1HO+/457Ujmg9OHz224/8" +
       "0kPvOvo2eWSvNCdO4hRvb7u7rAe2F5V5RPmvvPkfvOczL32lPAf/P8kzC0f0" +
       "LAAA");
}
