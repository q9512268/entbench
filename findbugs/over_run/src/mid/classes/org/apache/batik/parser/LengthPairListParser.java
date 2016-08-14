package org.apache.batik.parser;
public class LengthPairListParser extends org.apache.batik.parser.LengthListParser {
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { ((org.apache.batik.parser.LengthListHandler)
                                 lengthHandler).startLengthList();
                              current = reader.read();
                              skipSpaces();
                              try { for (; ; ) { lengthHandler.startLength(
                                                                 );
                                                 parseLength();
                                                 lengthHandler.endLength(
                                                                 );
                                                 skipCommaSpaces();
                                                 lengthHandler.startLength(
                                                                 );
                                                 parseLength();
                                                 lengthHandler.endLength(
                                                                 );
                                                 skipSpaces();
                                                 if (current == -1) { break;
                                                 }
                                                 if (current != ';') { reportUnexpectedCharacterError(
                                                                         current);
                                                 }
                                                 current =
                                                   reader.
                                                     read(
                                                       );
                                                 skipSpaces(
                                                   ); } }
                              catch (java.lang.NumberFormatException e) {
                                  reportUnexpectedCharacterError(
                                    current);
                              }
                              ((org.apache.batik.parser.LengthListHandler)
                                 lengthHandler).endLengthList(
                                                  ); }
    public LengthPairListParser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
