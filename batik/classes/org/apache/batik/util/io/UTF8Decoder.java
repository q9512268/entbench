package org.apache.batik.util.io;
public class UTF8Decoder extends org.apache.batik.util.io.AbstractCharDecoder {
    protected static final byte[] UTF8_BYTES = { 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    4,
    4,
    4,
    4,
    4,
    4,
    4,
    4,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0 };
    protected int nextChar = -1;
    public UTF8Decoder(java.io.InputStream is) { super(is); }
    public int readChar() throws java.io.IOException { if (nextChar != -1) {
                                                           int result =
                                                             nextChar;
                                                           nextChar =
                                                             -1;
                                                           return result;
                                                       }
                                                       if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           return END_OF_STREAM;
                                                       }
                                                       int b1 = buffer[position++] &
                                                         255;
                                                       switch (UTF8_BYTES[b1]) {
                                                           default:
                                                               charError(
                                                                 "UTF-8");
                                                           case 1:
                                                               return b1;
                                                           case 2:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               return (b1 &
                                                                         31) <<
                                                                 6 |
                                                                 buffer[position++] &
                                                                 63;
                                                           case 3:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b2 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b3 =
                                                                 buffer[position++];
                                                               if ((b2 &
                                                                      192) !=
                                                                     128 ||
                                                                     (b3 &
                                                                        192) !=
                                                                     128) {
                                                                   charError(
                                                                     "UTF-8");
                                                               }
                                                               return (b1 &
                                                                         31) <<
                                                                 12 |
                                                                 (b2 &
                                                                    63) <<
                                                                 6 |
                                                                 b3 &
                                                                 31;
                                                           case 4:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               b2 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               b3 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b4 =
                                                                 buffer[position++];
                                                               if ((b2 &
                                                                      192) !=
                                                                     128 ||
                                                                     (b3 &
                                                                        192) !=
                                                                     128 ||
                                                                     (b4 &
                                                                        192) !=
                                                                     128) {
                                                                   charError(
                                                                     "UTF-8");
                                                               }
                                                               int c =
                                                                 (b1 &
                                                                    31) <<
                                                                 18 |
                                                                 (b2 &
                                                                    63) <<
                                                                 12 |
                                                                 (b3 &
                                                                    31) <<
                                                                 6 |
                                                                 b4 &
                                                                 31;
                                                               nextChar =
                                                                 (c -
                                                                    65536) %
                                                                   1024 +
                                                                   56320;
                                                               return (c -
                                                                         65536) /
                                                                 1024 +
                                                                 55296;
                                                       }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cU7/EX/E5sf/BmcmLWfCGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
