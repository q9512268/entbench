package org.apache.xml.serializer;
final class WriterToUTF8Buffered extends java.io.Writer implements org.apache.xml.serializer.WriterChain {
    private static final int BYTES_MAX = 16 * 1024;
    private static final int CHARS_MAX = BYTES_MAX / 3;
    private final java.io.OutputStream m_os;
    private final byte[] m_outputBytes;
    private final char[] m_inputChars;
    private int count;
    public WriterToUTF8Buffered(java.io.OutputStream out) { super();
                                                            m_os = out;
                                                            m_outputBytes =
                                                              (new byte[BYTES_MAX +
                                                                          3]);
                                                            m_inputChars =
                                                              (new char[CHARS_MAX +
                                                                          2]);
                                                            count =
                                                              0;
    }
    public void write(final int c) throws java.io.IOException {
        if (count >=
              BYTES_MAX)
            flushBuffer(
              );
        if (c <
              128) {
            m_outputBytes[count++] =
              (byte)
                c;
        }
        else
            if (c <
                  2048) {
                m_outputBytes[count++] =
                  (byte)
                    (192 +
                       (c >>
                          6));
                m_outputBytes[count++] =
                  (byte)
                    (128 +
                       (c &
                          63));
            }
            else
                if (c <
                      65536) {
                    m_outputBytes[count++] =
                      (byte)
                        (224 +
                           (c >>
                              12));
                    m_outputBytes[count++] =
                      (byte)
                        (128 +
                           (c >>
                              6 &
                              63));
                    m_outputBytes[count++] =
                      (byte)
                        (128 +
                           (c &
                              63));
                }
                else {
                    m_outputBytes[count++] =
                      (byte)
                        (240 +
                           (c >>
                              18));
                    m_outputBytes[count++] =
                      (byte)
                        (128 +
                           (c >>
                              12 &
                              63));
                    m_outputBytes[count++] =
                      (byte)
                        (128 +
                           (c >>
                              6 &
                              63));
                    m_outputBytes[count++] =
                      (byte)
                        (128 +
                           (c &
                              63));
                }
    }
    public void write(final char[] chars, final int start,
                      final int length) throws java.io.IOException {
        int lengthx3 =
          3 *
          length;
        if (lengthx3 >=
              BYTES_MAX -
              count) {
            flushBuffer(
              );
            if (lengthx3 >
                  BYTES_MAX) {
                int split =
                  length /
                  CHARS_MAX;
                final int chunks;
                if (length %
                      CHARS_MAX >
                      0)
                    chunks =
                      split +
                        1;
                else
                    chunks =
                      split;
                int end_chunk =
                  start;
                for (int chunk =
                       1;
                     chunk <=
                       chunks;
                     chunk++) {
                    int start_chunk =
                      end_chunk;
                    end_chunk =
                      start +
                        (int)
                          ((long)
                             length *
                             chunk /
                             chunks);
                    final char c =
                      chars[end_chunk -
                              1];
                    int ic =
                      chars[end_chunk -
                              1];
                    if (c >=
                          55296 &&
                          c <=
                          56319) {
                        if (end_chunk <
                              start +
                              length) {
                            end_chunk++;
                        }
                        else {
                            end_chunk--;
                        }
                    }
                    int len_chunk =
                      end_chunk -
                      start_chunk;
                    this.
                      write(
                        chars,
                        start_chunk,
                        len_chunk);
                }
                return;
            }
        }
        final int n =
          length +
          start;
        final byte[] buf_loc =
          m_outputBytes;
        int count_loc =
          count;
        int i =
          start;
        {
            char c;
            for (;
                 i <
                   n &&
                   (c =
                      chars[i]) <
                   128;
                 i++)
                buf_loc[count_loc++] =
                  (byte)
                    c;
        }
        for (;
             i <
               n;
             i++) {
            final char c =
              chars[i];
            if (c <
                  128)
                buf_loc[count_loc++] =
                  (byte)
                    c;
            else
                if (c <
                      2048) {
                    buf_loc[count_loc++] =
                      (byte)
                        (192 +
                           (c >>
                              6));
                    buf_loc[count_loc++] =
                      (byte)
                        (128 +
                           (c &
                              63));
                }
                else
                    if (c >=
                          55296 &&
                          c <=
                          56319) {
                        char high;
                        char low;
                        high =
                          c;
                        i++;
                        low =
                          chars[i];
                        buf_loc[count_loc++] =
                          (byte)
                            (240 |
                               high +
                               64 >>
                               8 &
                               240);
                        buf_loc[count_loc++] =
                          (byte)
                            (128 |
                               high +
                               64 >>
                               2 &
                               63);
                        buf_loc[count_loc++] =
                          (byte)
                            (128 |
                               (low >>
                                  6 &
                                  15) +
                               (high <<
                                  4 &
                                  48));
                        buf_loc[count_loc++] =
                          (byte)
                            (128 |
                               low &
                               63);
                    }
                    else {
                        buf_loc[count_loc++] =
                          (byte)
                            (224 +
                               (c >>
                                  12));
                        buf_loc[count_loc++] =
                          (byte)
                            (128 +
                               (c >>
                                  6 &
                                  63));
                        buf_loc[count_loc++] =
                          (byte)
                            (128 +
                               (c &
                                  63));
                    }
        }
        count =
          count_loc;
    }
    public void write(final java.lang.String s) throws java.io.IOException {
        final int length =
          s.
          length(
            );
        int lengthx3 =
          3 *
          length;
        if (lengthx3 >=
              BYTES_MAX -
              count) {
            flushBuffer(
              );
            if (lengthx3 >
                  BYTES_MAX) {
                final int start =
                  0;
                int split =
                  length /
                  CHARS_MAX;
                final int chunks;
                if (length %
                      CHARS_MAX >
                      0)
                    chunks =
                      split +
                        1;
                else
                    chunks =
                      split;
                int end_chunk =
                  0;
                for (int chunk =
                       1;
                     chunk <=
                       chunks;
                     chunk++) {
                    int start_chunk =
                      end_chunk;
                    end_chunk =
                      start +
                        (int)
                          ((long)
                             length *
                             chunk /
                             chunks);
                    s.
                      getChars(
                        start_chunk,
                        end_chunk,
                        m_inputChars,
                        0);
                    int len_chunk =
                      end_chunk -
                      start_chunk;
                    final char c =
                      m_inputChars[len_chunk -
                                     1];
                    if (c >=
                          55296 &&
                          c <=
                          56319) {
                        end_chunk--;
                        len_chunk--;
                        if (chunk ==
                              chunks) {
                            
                        }
                    }
                    this.
                      write(
                        m_inputChars,
                        0,
                        len_chunk);
                }
                return;
            }
        }
        s.
          getChars(
            0,
            length,
            m_inputChars,
            0);
        final char[] chars =
          m_inputChars;
        final int n =
          length;
        final byte[] buf_loc =
          m_outputBytes;
        int count_loc =
          count;
        int i =
          0;
        {
            char c;
            for (;
                 i <
                   n &&
                   (c =
                      chars[i]) <
                   128;
                 i++)
                buf_loc[count_loc++] =
                  (byte)
                    c;
        }
        for (;
             i <
               n;
             i++) {
            final char c =
              chars[i];
            if (c <
                  128)
                buf_loc[count_loc++] =
                  (byte)
                    c;
            else
                if (c <
                      2048) {
                    buf_loc[count_loc++] =
                      (byte)
                        (192 +
                           (c >>
                              6));
                    buf_loc[count_loc++] =
                      (byte)
                        (128 +
                           (c &
                              63));
                }
                else
                    if (c >=
                          55296 &&
                          c <=
                          56319) {
                        char high;
                        char low;
                        high =
                          c;
                        i++;
                        low =
                          chars[i];
                        buf_loc[count_loc++] =
                          (byte)
                            (240 |
                               high +
                               64 >>
                               8 &
                               240);
                        buf_loc[count_loc++] =
                          (byte)
                            (128 |
                               high +
                               64 >>
                               2 &
                               63);
                        buf_loc[count_loc++] =
                          (byte)
                            (128 |
                               (low >>
                                  6 &
                                  15) +
                               (high <<
                                  4 &
                                  48));
                        buf_loc[count_loc++] =
                          (byte)
                            (128 |
                               low &
                               63);
                    }
                    else {
                        buf_loc[count_loc++] =
                          (byte)
                            (224 +
                               (c >>
                                  12));
                        buf_loc[count_loc++] =
                          (byte)
                            (128 +
                               (c >>
                                  6 &
                                  63));
                        buf_loc[count_loc++] =
                          (byte)
                            (128 +
                               (c &
                                  63));
                    }
        }
        count =
          count_loc;
    }
    public void flushBuffer() throws java.io.IOException {
        if (count >
              0) {
            m_os.
              write(
                m_outputBytes,
                0,
                count);
            count =
              0;
        }
    }
    public void flush() throws java.io.IOException { flushBuffer(
                                                       );
                                                     m_os.
                                                       flush(
                                                         );
    }
    public void close() throws java.io.IOException { flushBuffer(
                                                       );
                                                     m_os.
                                                       close(
                                                         );
    }
    public java.io.OutputStream getOutputStream() { return m_os;
    }
    public java.io.Writer getWriter() { return null; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "H1pbtnY5JwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n7+5LaT7iy2xo9N9poXmD771JnaJ0lts");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/I2OT48UnwulM2fETmwknjg1cHTy4qnXOxmF6aLh5D/EPnqzQ3/Fj7Avfur5" +
       "F5TJz1XOHWyJMlHpUuR6H7TUjWqdGPiu3Sbt6f3xx8H16QOhP3129/PYUDe2" +
       "wA/vDH1me3bvmGBaEPzBjQlO/95juPvDSTeVVS//7aXg+3d58a+i0oUkN8cN" +
       "N/02rqEcz+Tvv95+38nd4xtZYwSubx5Y45u3xxrnjz30i0d7wzu7vHpzw/1h" +
       "QfCdvPiPhwbIb759rOyfvFVlnwRjPbvj3X3f1qn/VkHwvddT8X/mxX+9iYr/" +
       "7a2q+G4w1i8fqPjLt0fFEz8+7J1/He32LuTVP49Kb9OsONR3ZxzP6PiDt6rj" +
       "g2DE3z7Q8bdvv45XXk/H+/Picn4uJtfxtHZ7b7sd2r1yoN0rt1+7d7+edvlP" +
       "rnsP7X4fDc/4597Db0G7h/LGp8BYrx5o9+rt1+79t3j2dF48EZWurNTo5NG/" +
       "nBY+VvHJt6BiQfYuIO1rByq+dvtVrN7iWT0v9sFqCFTcraiHS869h0vOieZC" +
       "XejNqJtGpXfc6AxzfiDzndf9m2L3DwD5ay9cuevhF+b/endy5fCU/qVx6S4t" +
       "tqyTR+RO1C96gaoZhTEu7Q7MeYWGH45K77ppFhGVLh/f5MLvfWjH1QYGOM0V" +
       "lc6D8iQNDriPaaLSxV3lJEkfcAGSvDrI53MPTfdOpBsH7lCA3AOvZ9YjlpNn" +
       "evOTG8V/Vw5PWcS7f69ck7/+woj6+HcbP7c7UyxbYpblvdw1Lt25O95cdJqf" +
       "1HjfTXs77Ovi4Onv3/uNS08dpk/37gQ+ds0Tsr33xgd4u7YXFUdus196+B88" +
       "+/de+KPidOH/BfZGL8RUNAAA");
}
