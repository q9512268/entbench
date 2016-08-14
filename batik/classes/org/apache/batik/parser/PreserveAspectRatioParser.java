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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
