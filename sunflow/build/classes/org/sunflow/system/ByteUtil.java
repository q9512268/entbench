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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HzDe4qgbBk6mUDOfyf8G2a//SeAhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zs1l3n3F/uvblJ09wkpWkamqRpbqGp4Xo8nqdS2Pox" +
       "Y3vGnvGMx/Z4eKQeP2Y8fr9mPA7ZQle7rRZRCqQQJBr+aWFhQ1sQFUi73Q1C" +
       "QCteApVdHoKW1a5gKZWaPyiI8thjz+99H1WUZEfyGdvne77n+/m+/PU5fvEr" +
       "lUtxVIEC39ktHT+5bmTJ9bXTuJ7sAiO+3mcbvBrFhk44ahxPwb2ntXd8+urX" +
       "vv6R1X0HlcvzyptUz/MTNbF8L54Yse9sDJ2tXD2523UMN04q97FrdaPCaWI5" +
       "MGvFyVNs5Q2nhiaVa+yRCDAQAQYiwKUIMHZCBQa90fBSlyhGqF4Sh5V/W7nA" +
       "Vi4HWiFeUnn8LJNAjVT3kA1fIgAcrhTXEgBVDs6iytuPse8x3wD4oxD83E98" +
       "732/dEfl6rxy1fKEQhwNCJGASeaVe1zDXRhRjOm6oc8r93uGoQtGZKmOlZdy" +
       "zysPxNbSU5M0Mo6VVNxMAyMq5zzR3D1agS1KtcSPjuGZluHoR1eXTEddAqwP" +
       "nmDdI+wV9wHAuy0gWGSqmnE05KJteXpSeez8iGOM1waAAAy90zWSlX881UVP" +
       "BTcqD+xt56jeEhaSyPKWgPSSn4JZksrDt2Ra6DpQNVtdGk8nlYfO0/H7LkB1" +
       "V6mIYkhSefN5spITsNLD56x0yj5fGb7nw894tHdQyqwbmlPIfwUMevTcoIlh" +
       "GpHhacZ+4D3vZn9cffCzHzqoVADxm88R72l+5ftefu+3PfrS5/Y033wTmtFi" +
       "bWjJ09rHF/f+wduIJzt3FGJcCfzYKox/Bnnp/vxhz1NZACLvwWOORef1o86X" +
       "Jr+pfP/PG18+qNzNVC5rvpO6wI/u13w3sBwjogzPiNTE0JnKXYanE2U/U7kT" +
       "nLOWZ+zvjkwzNhKmctEpb132y2ugIhOwKFR0Jzi3PNM/Og/UZFWeZ0GlUrkT" +
       "HJV7wHFHZf8r/5OKBK9814BVTfUsz4f5yC/wFwb1dBVOjBic66A38OE49UzH" +
       "38JxpMF+tDy53sWJ4cL4LjHEAnXhX8HrxjkrMN23vXABqPtt54PdAXFC+45u" +
       "RE9rz6V49+VPPv3bB8fOf6iNpPLNYJLrh5Nc309y/WiSyoULJe9vKibbmxEY" +
       "wQbhDBLdPU8K39N/34feAZSXBduLQIMFKXzrfEucJACmTHMa8MLKS89vf0B6" +
       "f/WgcnA2cRYCglt3F8P5It0dp7Vr5wPmZnyvfvCvv/apH3/WPwmdM5n4MKJv" +
       "HFlE5DvOqzLyNUMHOe6E/bvfrn7m6c8+e+2gchGEOUhtiQpcEWSNR8/PcSYy" +
       "nzrKcgWWSwCw6Ueu6hRdR6np7mQV+duTO6WN7y3P7wc6frBy2Jzx3aL3TUHR" +
       "ftPeJwqjnUNRZtHvEIKP/fHv/V+0VPdRwr166hEmGMlTp4K8YHa1DOf7T3xg" +
       "GhkGoPvz5/kf++hXPvhdpQMAiiduNuG1oiVAcAMTAjX/+8+Ff/LFv/j4Fw5O" +
       "nCYBT7l04Vhatgf5r+B3ARz/UhwFuOLGPkAfIA6zxNuP00RQzPwtJ7KBhOGA" +
       "0Co86Jroub5umZa6cIzCY//p6juRz/zth+/b+4QD7hy51Ld9YwYn99+KV77/" +
       "t7/37x8t2VzQigfWif5OyPZZ8E0nnLEoUneFHNkP/OEjP/lb6sdAPgU5LLZy" +
       "o0xLlVIfldKA1VIXUNnC5/pqRfNYfDoQzsbaqcLiae0jX/jqG6Wv/reXS2nP" +
       "Vian7c6pwVN7Vyuat2eA/VvORz2txitAV39p+N33OS99HXCcA44aeBzHowjk" +
       "meyMlxxSX7rzT3/t1x983x/cUTnoVe52fFXvqWXAVe4Cnm7EK5CisuDfvHfv" +
       "zdsroLmvhFq5AfzeQR4qr+4AAj5561zTKwqLk3B96B9HzuID/+sfblBCmWVu" +
       "8jw9N34Ov/hTDxPf+eVy/Em4F6MfzW7MvaAIOxlb+3n37w7ecfk3Dip3ziv3" +
       "aYcVnqQ6aRFEc1DVxEdlH6gCz/SfrVD2j+OnjtPZ286nmlPTnk80JzkfnBfU" +
       "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" +
       "QjDh+J5RbOkc9e23Ny3/+vHHDaAzu6mk672k5WRF88RtPPWHb9P3I0XzQ0nl" +
       "klYIs5f9NuTPHS6TlunS+0aLqadH76W+Mb7vPfS8e1+n+C5tUhJ87Da4frpo" +
       "nt8Hcx0/co9nTrD+5KvFCoHjrYdY3/q6Y/2522D9z0Xz8aRyzzFWxtucg/uJ" +
       "18K0Z5LK6wRXLAk+cxu4v1I0n96btn0z0/7iq8D6SHHzCXDUD7HWX0esz5QE" +
       "v3YbrL9eNP8V5KPEZw83P8QToJ99FUDfVtx8HBztQ6Dt1xroxZL0YnH5/nNN" +
       "Sf+7t8H9+0XzOZDFEp/xys30+AT2518L2O85hP2e192+f3IbnH9WNF+4Bc4/" +
       "ei1wHo7d/7+WOA9Onp3lA2ufp/7PbcD+VdF86RZg//LVgv1WcJCHYMnXyag3" +
       "Kz4ugbpF3VeXL98G/NeK5m+TyhtK8qlPq455TgVfeSUqyJLKlaOvqYrPQR66" +
       "4ZPM/WeE2idfuHrlLS+I/3NfZx596ncXW7lipo5zevf+1PnlIDJMqxT8rv1e" +
       "flD+/XNSeeDGz7qKbfvypJTyn0rSC6DqfMMp0qRy5+HZaaI7QG0OiIrTi8FR" +
       "1XRqa33/ZUK2V/xDp61fauyBb6SxU29qT5yp5MvvXI/ehdL9l65Pa596oT98" +
       "5uXmJ/YfMWmOmucFlyug6N5/T1UyLd6nHr8ltyNel+knv37vp+9659G73717" +
       "gU888ZRsj938K6GuGyTldz35r77ll9/zsy/8Rfltwf8DaauGToAsAAA=");
}
