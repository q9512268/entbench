package org.apache.batik.util.io;
public class ASCIIDecoder extends org.apache.batik.util.io.AbstractCharDecoder {
    public ASCIIDecoder(java.io.InputStream is) { super(is); }
    public int readChar() throws java.io.IOException { if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           return END_OF_STREAM;
                                                       }
                                                       int result = buffer[position++];
                                                       if (result < 0) { charError(
                                                                           "ASCII");
                                                       }
                                                       return result;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6eSorttE28z72EFd50n8LfbI/wetY6BMjBQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9/z+O377pW/l9a//Bd4U0x+PHwAA");
}
