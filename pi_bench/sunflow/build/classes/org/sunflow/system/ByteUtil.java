package org.sunflow.system;
public class ByteUtil {
    public static final byte[] get2Bytes(int i) { byte[] b = new byte[2];
                                                  b[0] = (byte) (i & 255);
                                                  b[1] = (byte) (i >> 8 &
                                                                   255);
                                                  return b; }
    public static final byte[] get4Bytes(int i) { byte[] b = new byte[4];
                                                  b[0] = (byte) (i & 255);
                                                  b[1] = (byte) (i >> 8 &
                                                                   255);
                                                  b[2] = (byte) (i >> 16 &
                                                                   255);
                                                  b[3] = (byte) (i >> 24 &
                                                                   255);
                                                  return b; }
    public static final byte[] get4BytesInv(int i) { byte[] b = new byte[4];
                                                     b[3] = (byte) (i & 255);
                                                     b[2] = (byte) (i >> 8 &
                                                                      255);
                                                     b[1] = (byte) (i >> 16 &
                                                                      255);
                                                     b[0] = (byte) (i >> 24 &
                                                                      255);
                                                     return b; }
    public static final byte[] get8Bytes(long i) { byte[] b = new byte[8];
                                                   b[0] = (byte) (i & 255);
                                                   b[1] = (byte) ((long) ((long)
                                                                            i >>
                                                                            (long)
                                                                              8) &
                                                                    (long)
                                                                      255);
                                                   b[2] =
                                                     (byte)
                                                       ((long)
                                                          ((long)
                                                             i >>
                                                             (long)
                                                               16) &
                                                          (long)
                                                            255);
                                                   b[3] =
                                                     (byte)
                                                       ((long)
                                                          ((long)
                                                             i >>
                                                             (long)
                                                               24) &
                                                          (long)
                                                            255);
                                                   b[4] =
                                                     (byte)
                                                       ((long)
                                                          ((long)
                                                             i >>
                                                             (long)
                                                               32) &
                                                          (long)
                                                            255);
                                                   b[5] =
                                                     (byte)
                                                       ((long)
                                                          ((long)
                                                             i >>
                                                             (long)
                                                               40) &
                                                          (long)
                                                            255);
                                                   b[6] =
                                                     (byte)
                                                       ((long)
                                                          ((long)
                                                             i >>
                                                             (long)
                                                               48) &
                                                          (long)
                                                            255);
                                                   b[7] =
                                                     (byte)
                                                       ((long)
                                                          ((long)
                                                             i >>
                                                             (long)
                                                               56) &
                                                          (long)
                                                            255);
                                                   return b;
    }
    public static final long toLong(byte[] in) { return (long)
                                                          ((long)
                                                             toInt(
                                                               in[0],
                                                               in[1],
                                                               in[2],
                                                               in[3]) |
                                                             (long)
                                                               toInt(
                                                                 in[4],
                                                                 in[5],
                                                                 in[6],
                                                                 in[7]) <<
                                                             (long)
                                                               32);
    }
    public static final int toInt(byte in0, byte in1, byte in2,
                                  byte in3) { return in0 &
                                                255 |
                                                (in1 &
                                                   255) <<
                                                8 |
                                                (in2 &
                                                   255) <<
                                                16 |
                                                (in3 &
                                                   255) <<
                                                24; }
    public static final int toInt(byte[] in) { return toInt(
                                                        in[0],
                                                        in[1],
                                                        in[2],
                                                        in[3]);
    }
    public static final int toInt(byte[] in, int ofs) { return toInt(
                                                                 in[ofs +
                                                                      0],
                                                                 in[ofs +
                                                                      1],
                                                                 in[ofs +
                                                                      2],
                                                                 in[ofs +
                                                                      3]);
    }
    public static final int floatToHalf(float f) { int i =
                                                     java.lang.Float.
                                                     floatToRawIntBits(
                                                       f);
                                                   int s =
                                                     i >>
                                                     16 &
                                                     32768;
                                                   int e =
                                                     (i >>
                                                        23 &
                                                        255) -
                                                     (127 -
                                                        15);
                                                   int m =
                                                     i &
                                                     8388607;
                                                   if (e <=
                                                         0) {
                                                       if (e <
                                                             -10) {
                                                           return 0;
                                                       }
                                                       m =
                                                         (m |
                                                            8388608) >>
                                                           1 -
                                                           e;
                                                       if ((m &
                                                              4096) ==
                                                             4096)
                                                           m +=
                                                             8192;
                                                       return s |
                                                         m >>
                                                         13;
                                                   }
                                                   else
                                                       if (e ==
                                                             255 -
                                                             (127 -
                                                                15)) {
                                                           if (m ==
                                                                 0) {
                                                               return s |
                                                                 31744;
                                                           }
                                                           else {
                                                               m >>=
                                                                 13;
                                                               return s |
                                                                 31744 |
                                                                 m |
                                                                 (m ==
                                                                    0
                                                                    ? 0
                                                                    : 1);
                                                           }
                                                       }
                                                       else {
                                                           if ((m &
                                                                  4096) ==
                                                                 4096) {
                                                               m +=
                                                                 8192;
                                                               if ((m &
                                                                      8388608) ==
                                                                     8388608) {
                                                                   m =
                                                                     0;
                                                                   e +=
                                                                     1;
                                                               }
                                                           }
                                                           if (e >
                                                                 30) {
                                                               return s |
                                                                 31744;
                                                           }
                                                           return s |
                                                             e <<
                                                             10 |
                                                             m >>
                                                             13;
                                                       }
    }
    public ByteUtil() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jfJXfLvq/7KCi4cCIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d/rk/+pN//Kd/+L5Py93G/x/CURlLnQsAAA=");
}
