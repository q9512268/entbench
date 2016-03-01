package org.apache.batik.parser;
public class PreserveAspectRatioParser extends org.apache.batik.parser.AbstractParser {
    protected org.apache.batik.parser.PreserveAspectRatioHandler preserveAspectRatioHandler;
    public PreserveAspectRatioParser() { super();
                                         preserveAspectRatioHandler = org.apache.batik.parser.DefaultPreserveAspectRatioHandler.
                                                                        INSTANCE;
    }
    public void setPreserveAspectRatioHandler(org.apache.batik.parser.PreserveAspectRatioHandler handler) {
        preserveAspectRatioHandler =
          handler;
    }
    public org.apache.batik.parser.PreserveAspectRatioHandler getPreserveAspectRatioHandler() {
        return preserveAspectRatioHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              parsePreserveAspectRatio(
                                ); }
    protected void parsePreserveAspectRatio()
          throws org.apache.batik.parser.ParseException,
        java.io.IOException { preserveAspectRatioHandler.
                                startPreserveAspectRatio(
                                  );
                              align: switch (current) {
                                  case 'n':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'o') {
                                          reportCharacterExpectedError(
                                            'o',
                                            current);
                                          skipIdentifier(
                                            );
                                          break align;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'n') {
                                          reportCharacterExpectedError(
                                            'o',
                                            current);
                                          skipIdentifier(
                                            );
                                          break align;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break align;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                                      preserveAspectRatioHandler.
                                        none(
                                          );
                                      break;
                                  case 'x':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'M') {
                                          reportCharacterExpectedError(
                                            'M',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          case 'a':
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              if (current !=
                                                    'x') {
                                                  reportCharacterExpectedError(
                                                    'x',
                                                    current);
                                                  skipIdentifier(
                                                    );
                                                  break align;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              if (current !=
                                                    'Y') {
                                                  reportCharacterExpectedError(
                                                    'Y',
                                                    current);
                                                  skipIdentifier(
                                                    );
                                                  break align;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              if (current !=
                                                    'M') {
                                                  reportCharacterExpectedError(
                                                    'M',
                                                    current);
                                                  skipIdentifier(
                                                    );
                                                  break align;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  case 'a':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'x') {
                                                          reportCharacterExpectedError(
                                                            'x',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      preserveAspectRatioHandler.
                                                        xMaxYMax(
                                                          );
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      break;
                                                  case 'i':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      switch (current) {
                                                          case 'd':
                                                              preserveAspectRatioHandler.
                                                                xMaxYMid(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'n':
                                                              preserveAspectRatioHandler.
                                                                xMaxYMin(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          default:
                                                              reportUnexpectedCharacterError(
                                                                current);
                                                              skipIdentifier(
                                                                );
                                                              break align;
                                                      }
                                              }
                                              break;
                                          case 'i':
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  case 'd':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'Y') {
                                                          reportCharacterExpectedError(
                                                            'Y',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'M') {
                                                          reportCharacterExpectedError(
                                                            'M',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      switch (current) {
                                                          case 'a':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              if (current !=
                                                                    'x') {
                                                                  reportCharacterExpectedError(
                                                                    'x',
                                                                    current);
                                                                  skipIdentifier(
                                                                    );
                                                                  break align;
                                                              }
                                                              preserveAspectRatioHandler.
                                                                xMidYMax(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'i':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              switch (current) {
                                                                  case 'd':
                                                                      preserveAspectRatioHandler.
                                                                        xMidYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      preserveAspectRatioHandler.
                                                                        xMidYMin(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  default:
                                                                      reportUnexpectedCharacterError(
                                                                        current);
                                                                      skipIdentifier(
                                                                        );
                                                                      break align;
                                                              }
                                                      }
                                                      break;
                                                  case 'n':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'Y') {
                                                          reportCharacterExpectedError(
                                                            'Y',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'M') {
                                                          reportCharacterExpectedError(
                                                            'M',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      switch (current) {
                                                          case 'a':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              if (current !=
                                                                    'x') {
                                                                  reportCharacterExpectedError(
                                                                    'x',
                                                                    current);
                                                                  skipIdentifier(
                                                                    );
                                                                  break align;
                                                              }
                                                              preserveAspectRatioHandler.
                                                                xMinYMax(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'i':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              switch (current) {
                                                                  case 'd':
                                                                      preserveAspectRatioHandler.
                                                                        xMinYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      preserveAspectRatioHandler.
                                                                        xMinYMin(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  default:
                                                                      reportUnexpectedCharacterError(
                                                                        current);
                                                                      skipIdentifier(
                                                                        );
                                                                      break align;
                                                              }
                                                      }
                                                      break;
                                                  default:
                                                      reportUnexpectedCharacterError(
                                                        current);
                                                      skipIdentifier(
                                                        );
                                                      break align;
                                              }
                                              break;
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                              skipIdentifier(
                                                );
                                      }
                                      break;
                                  default:
                                      if (current !=
                                            -1) {
                                          reportUnexpectedCharacterError(
                                            current);
                                          skipIdentifier(
                                            );
                                      }
                              }
                              skipCommaSpaces(
                                );
                              switch (current) {
                                  case 'm':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            't') {
                                          reportCharacterExpectedError(
                                            't',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      preserveAspectRatioHandler.
                                        meet(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case 's':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'l') {
                                          reportCharacterExpectedError(
                                            'l',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'i') {
                                          reportCharacterExpectedError(
                                            'i',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'c') {
                                          reportCharacterExpectedError(
                                            'c',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      preserveAspectRatioHandler.
                                        slice(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  default:
                                      if (current !=
                                            -1) {
                                          reportUnexpectedCharacterError(
                                            current);
                                          skipIdentifier(
                                            );
                                      }
                              }
                              skipSpaces(
                                );
                              if (current !=
                                    -1) {
                                  reportError(
                                    "end.of.stream.expected",
                                    new java.lang.Object[] { new java.lang.Integer(
                                      current) });
                              }
                              preserveAspectRatioHandler.
                                endPreserveAspectRatio(
                                  ); }
    protected void skipIdentifier() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            current =
              reader.
                read(
                  );
            switch (current) {
                case 13:
                case 10:
                case 32:
                case 9:
                    current =
                      reader.
                        read(
                          );
                    break loop;
                default:
                    if (current ==
                          -1) {
                        break loop;
                    }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4e5/gTP9soBmEBQFlhDyX7mAxsejGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
