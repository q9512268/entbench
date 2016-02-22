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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+Vc/2mmUv+Lbov8DuLozXhYjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fKI5zfnleUVdnd9/avBn8wtlIF4Gb/RutKrrD9Udn67b61XzgwetV6c/VEZs" +
       "XFeFZQ/D8mW35vNsUnqMq14/jlGhrBJLFV+33V7N5p1lXVx7RwXmxqG0OuSq" +
       "qoUOUtTn3Tt6w3PHspbWf/CUGRWUVdrP/NdP/vbPPvP10kSTxuWsUl9pmTMj" +
       "ztOqcP0br3zqibe99I2fqRNQmX3Yy6/9fl0GTO+GuGqwqhkdQ328gsoGaaTq" +
       "lBwnszpP6FqN9q6eyUSWV6bW7KgqA1585OvOL/3Jrx4qrvNueI5Y//hLf/Mv" +
       "bnzipYtn6txnbik1z/Y51Lq10G8/0nDUePpuo9Q98D/+wov/7B+8+LGDVI/c" +
       "XLWNyo+SX/33f/7bNz79ja/epqC45AZvwLDJtX87hmNyePyjBAld7fh27jbT" +
       "orvbLVWifFFg82ixiJ04kMUyxygoAo8Xc2qj8ARJSkWvo2H9gsawedbj+LBg" +
       "cbw1skyZJ0lrOVkLvGdaKD31zN6U17YBLS34OcfNWyy3IEGIG6NBSzaneJL6" +
       "QFbohdrcI6PEiQotlTSgyIAeABgAAGSATmc8MKUmzCxEtlSMEtgqxAUiTVmO" +
       "zAiwvZ7EtjRcy4O+AvutnSZD7TasTVJ+EE4lI7ZDdy9PI1yOiGjZY7fEZuUU" +
       "rLTy4tDWaZIK53Ib2S+86SRi5CUScyFrbiMSTTMezhc9ZULNCMTJZitxa6xc" +
       "ggZ3qI1xxGYyCzp7tksmtkpYcyH24Fmqgb5ObSG9vd1J/a22B6cOFUkaEaKW" +
       "LMtBSzKtWJNnLAsX2pgPtnoQL+xZHLvgoBUom9LwAr3EZrpigzs4gQaJlqOo" +
       "RHpbsaDCbtt3t13aweyZQEXtbYeV1UhmlQ7OehPHn6oFuW/l0oAMOGSLs8t2" +
       "CAm9ocGthdbWBX0xw8ajyDWD3WzGUQrXZxcc6rpO07eYIY2jnkIVGx1LKHrf" +
       "2gSh2mL7nR4VAH4Kte02u/DCHjsFLY2d9WY2hogTUh9OWK+5NcNItMeysh/b" +
       "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");
}
