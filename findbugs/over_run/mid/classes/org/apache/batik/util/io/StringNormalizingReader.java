package org.apache.batik.util.io;
public class StringNormalizingReader extends org.apache.batik.util.io.NormalizingReader {
    protected java.lang.String string;
    protected int length;
    protected int next;
    protected int line = 1;
    protected int column;
    public StringNormalizingReader(java.lang.String s) { super();
                                                         string = s;
                                                         length = s.length(
                                                                      ); }
    public int read() throws java.io.IOException { int result = length ==
                                                     next
                                                     ? -1
                                                     : string.
                                                     charAt(
                                                       next++);
                                                   if (result <= 13) { switch (result) {
                                                                           case 13:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                               int c =
                                                                                 length ==
                                                                                 next
                                                                                 ? -1
                                                                                 : string.
                                                                                 charAt(
                                                                                   next);
                                                                               if (c ==
                                                                                     10) {
                                                                                   next++;
                                                                               }
                                                                               return 10;
                                                                           case 10:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                       }
                                                   }
                                                   return result;
    }
    public int getLine() { return line; }
    public int getColumn() { return column;
    }
    public void close() throws java.io.IOException {
        string =
          null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dT1TTG8cAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o9s//ejvPv3N7LD7/wAssH+laycAAA==");
}
