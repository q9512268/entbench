package org.apache.batik.transcoder.svg2svg;
public class PrettyPrinter {
    public static final int DOCTYPE_CHANGE = 0;
    public static final int DOCTYPE_REMOVE = 1;
    public static final int DOCTYPE_KEEP_UNCHANGED = 2;
    protected org.apache.batik.xml.XMLScanner scanner;
    protected org.apache.batik.transcoder.svg2svg.OutputManager output;
    protected java.io.Writer writer;
    protected org.apache.batik.transcoder.ErrorHandler errorHandler = org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                                                        DEFAULT_ERROR_HANDLER;
    protected java.lang.String newline = "\n";
    protected boolean format = true;
    protected int tabulationWidth = 4;
    protected int documentWidth = 80;
    protected int doctypeOption = DOCTYPE_KEEP_UNCHANGED;
    protected java.lang.String publicId;
    protected java.lang.String systemId;
    protected java.lang.String xmlDeclaration;
    protected int type;
    public void setXMLDeclaration(java.lang.String s) { xmlDeclaration =
                                                          s; }
    public void setDoctypeOption(int i) { doctypeOption = i; }
    public void setPublicId(java.lang.String s) { publicId = s; }
    public void setSystemId(java.lang.String s) { systemId = s; }
    public void setNewline(java.lang.String s) { newline = s; }
    public java.lang.String getNewline() { return newline; }
    public void setFormat(boolean b) { format = b; }
    public boolean getFormat() { return format; }
    public void setTabulationWidth(int i) { tabulationWidth = java.lang.Math.
                                                                max(
                                                                  i,
                                                                  0);
    }
    public int getTabulationWidth() { return tabulationWidth; }
    public void setDocumentWidth(int i) { documentWidth = java.lang.Math.
                                                            max(
                                                              i,
                                                              0);
    }
    public int getDocumentWidth() { return documentWidth; }
    public void print(java.io.Reader r, java.io.Writer w) throws org.apache.batik.transcoder.TranscoderException,
        java.io.IOException { try { scanner = new org.apache.batik.xml.XMLScanner(
                                                r);
                                    output = new org.apache.batik.transcoder.svg2svg.OutputManager(
                                               this,
                                               w);
                                    writer =
                                      w;
                                    type =
                                      scanner.
                                        next(
                                          );
                                    printXMLDecl(
                                      );
                                    misc1: for (;
                                                ;
                                                ) {
                                        switch (type) {
                                            case org.apache.batik.xml.LexicalUnits.
                                                   S:
                                                output.
                                                  printTopSpaces(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   COMMENT:
                                                output.
                                                  printComment(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   PI_START:
                                                printPI(
                                                  );
                                                break;
                                            default:
                                                break misc1;
                                        }
                                    }
                                    printDoctype(
                                      );
                                    misc2: for (;
                                                ;
                                                ) {
                                        scanner.
                                          clearBuffer(
                                            );
                                        switch (type) {
                                            case org.apache.batik.xml.LexicalUnits.
                                                   S:
                                                output.
                                                  printTopSpaces(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   COMMENT:
                                                output.
                                                  printComment(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   PI_START:
                                                printPI(
                                                  );
                                                break;
                                            default:
                                                break misc2;
                                        }
                                    }
                                    if (type !=
                                          org.apache.batik.xml.LexicalUnits.
                                            START_TAG) {
                                        throw fatalError(
                                                "element",
                                                null);
                                    }
                                    printElement(
                                      );
                                    misc3: for (;
                                                ;
                                                ) {
                                        switch (type) {
                                            case org.apache.batik.xml.LexicalUnits.
                                                   S:
                                                output.
                                                  printTopSpaces(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   COMMENT:
                                                output.
                                                  printComment(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   PI_START:
                                                printPI(
                                                  );
                                                break;
                                            default:
                                                break misc3;
                                        }
                                    } }
                              catch (org.apache.batik.xml.XMLException e) {
                                  errorHandler.
                                    fatalError(
                                      new org.apache.batik.transcoder.TranscoderException(
                                        e.
                                          getMessage(
                                            )));
                              } }
    protected void printXMLDecl() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { if (xmlDeclaration ==
                                    null) {
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          XML_DECL_START) {
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      char[] space1 =
                                        getCurrentValue(
                                          );
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              VERSION_IDENTIFIER) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "version" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      char[] space2 =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space2 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              EQ) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "=" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      char[] space3 =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space3 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      char[] version =
                                        getCurrentValue(
                                          );
                                      char versionDelim =
                                        scanner.
                                        getStringDelimiter(
                                          );
                                      char[] space4 =
                                        null;
                                      char[] space5 =
                                        null;
                                      char[] space6 =
                                        null;
                                      char[] encoding =
                                        null;
                                      char encodingDelim =
                                        0;
                                      char[] space7 =
                                        null;
                                      char[] space8 =
                                        null;
                                      char[] space9 =
                                        null;
                                      char[] standalone =
                                        null;
                                      char standaloneDelim =
                                        0;
                                      char[] space10 =
                                        null;
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space4 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  ENCODING_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space5 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space6 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              encoding =
                                                getCurrentValue(
                                                  );
                                              encodingDelim =
                                                scanner.
                                                  getStringDelimiter(
                                                    );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space7 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  STANDALONE_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space8 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space9 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              standalone =
                                                getCurrentValue(
                                                  );
                                              standaloneDelim =
                                                scanner.
                                                  getStringDelimiter(
                                                    );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space10 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              PI_END) {
                                          throw fatalError(
                                                  "pi.end",
                                                  null);
                                      }
                                      output.
                                        printXMLDecl(
                                          space1,
                                          space2,
                                          space3,
                                          version,
                                          versionDelim,
                                          space4,
                                          space5,
                                          space6,
                                          encoding,
                                          encodingDelim,
                                          space7,
                                          space8,
                                          space9,
                                          standalone,
                                          standaloneDelim,
                                          space10);
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              }
                              else {
                                  output.
                                    printString(
                                      xmlDeclaration);
                                  output.
                                    printNewline(
                                      );
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          XML_DECL_START) {
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              VERSION_IDENTIFIER) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "version" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              EQ) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "=" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  ENCODING_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  STANDALONE_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              PI_END) {
                                          throw fatalError(
                                                  "pi.end",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              } }
    protected void printPI() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { char[] target =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              char[] space =
                                {  };
                              if (type ==
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  space =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      PI_DATA) {
                                  throw fatalError(
                                          "pi.data",
                                          null);
                              }
                              char[] data =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      PI_END) {
                                  throw fatalError(
                                          "pi.end",
                                          null);
                              }
                              output.printPI(
                                       target,
                                       space,
                                       data);
                              type = scanner.
                                       next(
                                         );
    }
    protected void printDoctype() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { switch (doctypeOption) {
                                  default:
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              DOCTYPE_START) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          char[] space1 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NAME) {
                                              throw fatalError(
                                                      "name",
                                                      null);
                                          }
                                          char[] root =
                                            getCurrentValue(
                                              );
                                          char[] space2 =
                                            null;
                                          java.lang.String externalId =
                                            null;
                                          char[] space3 =
                                            null;
                                          char[] string1 =
                                            null;
                                          char string1Delim =
                                            0;
                                          char[] space4 =
                                            null;
                                          char[] string2 =
                                            null;
                                          char string2Delim =
                                            0;
                                          char[] space5 =
                                            null;
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space2 =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PUBLIC_IDENTIFIER:
                                                      externalId =
                                                        "PUBLIC";
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      space3 =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      string1 =
                                                        getCurrentValue(
                                                          );
                                                      string1Delim =
                                                        scanner.
                                                          getStringDelimiter(
                                                            );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      space4 =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      string2 =
                                                        getCurrentValue(
                                                          );
                                                      string2Delim =
                                                        scanner.
                                                          getStringDelimiter(
                                                            );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space5 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         SYSTEM_IDENTIFIER:
                                                      externalId =
                                                        "SYSTEM";
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      space3 =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      string1 =
                                                        getCurrentValue(
                                                          );
                                                      string1Delim =
                                                        scanner.
                                                          getStringDelimiter(
                                                            );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space4 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                              }
                                          }
                                          if (doctypeOption ==
                                                DOCTYPE_CHANGE) {
                                              if (publicId !=
                                                    null) {
                                                  externalId =
                                                    "PUBLIC";
                                                  string1 =
                                                    publicId.
                                                      toCharArray(
                                                        );
                                                  string1Delim =
                                                    '\"';
                                                  if (systemId !=
                                                        null) {
                                                      string2 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                      string2Delim =
                                                        '\"';
                                                  }
                                              }
                                              else
                                                  if (systemId !=
                                                        null) {
                                                      externalId =
                                                        "SYSTEM";
                                                      string1 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                      string1Delim =
                                                        '\"';
                                                      string2 =
                                                        null;
                                                  }
                                          }
                                          output.
                                            printDoctypeStart(
                                              space1,
                                              root,
                                              space2,
                                              externalId,
                                              space3,
                                              string1,
                                              string1Delim,
                                              space4,
                                              string2,
                                              string2Delim,
                                              space5);
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  LSQUARE_BRACKET) {
                                              output.
                                                printCharacter(
                                                  '[');
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              dtd: for (;
                                                        ;
                                                        ) {
                                                  switch (type) {
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             S:
                                                          output.
                                                            printSpaces(
                                                              getCurrentValue(
                                                                ),
                                                              true);
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             COMMENT:
                                                          output.
                                                            printComment(
                                                              getCurrentValue(
                                                                ));
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             PI_START:
                                                          printPI(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             PARAMETER_ENTITY_REFERENCE:
                                                          output.
                                                            printParameterEntityReference(
                                                              getCurrentValue(
                                                                ));
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             ELEMENT_DECLARATION_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printElementDeclaration(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             ATTLIST_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printAttlist(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             NOTATION_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printNotation(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             ENTITY_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printEntityDeclaration(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             RSQUARE_BRACKET:
                                                          output.
                                                            printCharacter(
                                                              ']');
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break dtd;
                                                      default:
                                                          throw fatalError(
                                                                  "xml",
                                                                  null);
                                                  }
                                              }
                                          }
                                          char[] endSpace =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              endSpace =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  END_CHAR) {
                                              throw fatalError(
                                                      "end",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          output.
                                            printDoctypeEnd(
                                              endSpace);
                                      }
                                      else {
                                          if (doctypeOption ==
                                                DOCTYPE_CHANGE) {
                                              java.lang.String externalId =
                                                "PUBLIC";
                                              char[] string1 =
                                                org.apache.batik.util.SVGConstants.
                                                  SVG_PUBLIC_ID.
                                                toCharArray(
                                                  );
                                              char[] string2 =
                                                org.apache.batik.util.SVGConstants.
                                                  SVG_SYSTEM_ID.
                                                toCharArray(
                                                  );
                                              if (publicId !=
                                                    null) {
                                                  string1 =
                                                    publicId.
                                                      toCharArray(
                                                        );
                                                  if (systemId !=
                                                        null) {
                                                      string2 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                  }
                                              }
                                              else
                                                  if (systemId !=
                                                        null) {
                                                      externalId =
                                                        "SYSTEM";
                                                      string1 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                      string2 =
                                                        null;
                                                  }
                                              output.
                                                printDoctypeStart(
                                                  new char[] { ' ' },
                                                  new char[] { 's',
                                                  'v',
                                                  'g' },
                                                  new char[] { ' ' },
                                                  externalId,
                                                  new char[] { ' ' },
                                                  string1,
                                                  '\"',
                                                  new char[] { ' ' },
                                                  string2,
                                                  '\"',
                                                  null);
                                              output.
                                                printDoctypeEnd(
                                                  null);
                                          }
                                      }
                                      break;
                                  case DOCTYPE_REMOVE:
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              DOCTYPE_START) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NAME) {
                                              throw fatalError(
                                                      "name",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PUBLIC_IDENTIFIER:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         SYSTEM_IDENTIFIER:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                              }
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  LSQUARE_BRACKET) {
                                              do  {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }while(type !=
                                                       org.apache.batik.xml.LexicalUnits.
                                                         RSQUARE_BRACKET); 
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  END_CHAR) {
                                              throw fatalError(
                                                      "end",
                                                      null);
                                          }
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                              } }
    protected java.lang.String printElement()
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { char[] name =
                                getCurrentValue(
                                  );
                              java.lang.String nameStr =
                                new java.lang.String(
                                name);
                              java.util.List attributes =
                                new java.util.LinkedList(
                                );
                              char[] space =
                                null;
                              type = scanner.
                                       next(
                                         );
                              while (type ==
                                       org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  space =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          NAME) {
                                      char[] attName =
                                        getCurrentValue(
                                          );
                                      char[] space1 =
                                        null;
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space1 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              EQ) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "=" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      char[] space2 =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space2 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING &&
                                            type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              FIRST_ATTRIBUTE_FRAGMENT) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      char valueDelim =
                                        scanner.
                                        getStringDelimiter(
                                          );
                                      boolean hasEntityRef =
                                        false;
                                      java.lang.StringBuffer sb =
                                        new java.lang.StringBuffer(
                                        );
                                      sb.
                                        append(
                                          getCurrentValue(
                                            ));
                                      loop: for (;
                                                 ;
                                                 ) {
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          switch (type) {
                                              case org.apache.batik.xml.LexicalUnits.
                                                     STRING:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     FIRST_ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     LAST_ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ATTRIBUTE_FRAGMENT:
                                                  sb.
                                                    append(
                                                      getCurrentValue(
                                                        ));
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     CHARACTER_REFERENCE:
                                                  hasEntityRef =
                                                    true;
                                                  sb.
                                                    append(
                                                      "&#");
                                                  sb.
                                                    append(
                                                      getCurrentValue(
                                                        ));
                                                  sb.
                                                    append(
                                                      ";");
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ENTITY_REFERENCE:
                                                  hasEntityRef =
                                                    true;
                                                  sb.
                                                    append(
                                                      "&");
                                                  sb.
                                                    append(
                                                      getCurrentValue(
                                                        ));
                                                  sb.
                                                    append(
                                                      ";");
                                                  break;
                                              default:
                                                  break loop;
                                          }
                                      }
                                      attributes.
                                        add(
                                          new org.apache.batik.transcoder.svg2svg.OutputManager.AttributeInfo(
                                            space,
                                            attName,
                                            space1,
                                            space2,
                                            new java.lang.String(
                                              sb),
                                            valueDelim,
                                            hasEntityRef));
                                      space =
                                        null;
                                  }
                              }
                              output.printElementStart(
                                       name,
                                       attributes,
                                       space);
                              switch (type) {
                                  default:
                                      throw fatalError(
                                              "xml",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         EMPTY_ELEMENT_END:
                                      output.
                                        printElementEnd(
                                          null,
                                          null);
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         END_CHAR:
                                      output.
                                        printCharacter(
                                          '>');
                                      type =
                                        scanner.
                                          next(
                                            );
                                      printContent(
                                        allowSpaceAtStart(
                                          nameStr));
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              END_TAG) {
                                          throw fatalError(
                                                  "end.tag",
                                                  null);
                                      }
                                      name =
                                        getCurrentValue(
                                          );
                                      type =
                                        scanner.
                                          next(
                                            );
                                      space =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      output.
                                        printElementEnd(
                                          name,
                                          space);
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              END_CHAR) {
                                          throw fatalError(
                                                  "end",
                                                  null);
                                      }
                              }
                              type = scanner.
                                       next(
                                         );
                              return nameStr;
    }
    boolean allowSpaceAtStart(java.lang.String tagName) {
        return true;
    }
    protected void printContent(boolean spaceAtStart)
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { boolean preceedingSpace =
                                false;
                              content: for (;
                                            ;
                                            ) {
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             COMMENT:
                                          output.
                                            printComment(
                                              getCurrentValue(
                                                ));
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          preceedingSpace =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PI_START:
                                          printPI(
                                            );
                                          preceedingSpace =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             CHARACTER_DATA:
                                          preceedingSpace =
                                            output.
                                              printCharacterData(
                                                getCurrentValue(
                                                  ),
                                                spaceAtStart,
                                                preceedingSpace);
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          spaceAtStart =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             CDATA_START:
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  CHARACTER_DATA) {
                                              throw fatalError(
                                                      "character.data",
                                                      null);
                                          }
                                          output.
                                            printCDATASection(
                                              getCurrentValue(
                                                ));
                                          if (scanner.
                                                next(
                                                  ) !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  SECTION_END) {
                                              throw fatalError(
                                                      "section.end",
                                                      null);
                                          }
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          preceedingSpace =
                                            false;
                                          spaceAtStart =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             START_TAG:
                                          java.lang.String name =
                                            printElement(
                                              );
                                          spaceAtStart =
                                            allowSpaceAtStart(
                                              name);
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             CHARACTER_REFERENCE:
                                          output.
                                            printCharacterEntityReference(
                                              getCurrentValue(
                                                ),
                                              spaceAtStart,
                                              preceedingSpace);
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          spaceAtStart =
                                            false;
                                          preceedingSpace =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITY_REFERENCE:
                                          output.
                                            printEntityReference(
                                              getCurrentValue(
                                                ),
                                              spaceAtStart);
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          spaceAtStart =
                                            false;
                                          preceedingSpace =
                                            false;
                                          break;
                                      default:
                                          break content;
                                  }
                              } }
    protected void printNotation() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { int t = scanner.
                                next(
                                  );
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              char[] space1 =
                                getCurrentValue(
                                  );
                              t = scanner.
                                    next(
                                      );
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         NAME) {
                                  throw fatalError(
                                          "name",
                                          null);
                              }
                              char[] name =
                                getCurrentValue(
                                  );
                              t = scanner.
                                    next(
                                      );
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              char[] space2 =
                                getCurrentValue(
                                  );
                              t = scanner.
                                    next(
                                      );
                              java.lang.String externalId =
                                null;
                              char[] space3 =
                                null;
                              char[] string1 =
                                null;
                              char string1Delim =
                                0;
                              char[] space4 =
                                null;
                              char[] string2 =
                                null;
                              char string2Delim =
                                0;
                              switch (t) {
                                  default:
                                      throw fatalError(
                                              "notation.definition",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         PUBLIC_IDENTIFIER:
                                      externalId =
                                        "PUBLIC";
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      space3 =
                                        getCurrentValue(
                                          );
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      string1 =
                                        getCurrentValue(
                                          );
                                      string1Delim =
                                        scanner.
                                          getStringDelimiter(
                                            );
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space4 =
                                            getCurrentValue(
                                              );
                                          t =
                                            scanner.
                                              next(
                                                );
                                          if (t ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  STRING) {
                                              string2 =
                                                getCurrentValue(
                                                  );
                                              string2Delim =
                                                scanner.
                                                  getStringDelimiter(
                                                    );
                                              t =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                      }
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         SYSTEM_IDENTIFIER:
                                      externalId =
                                        "SYSTEM";
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      space3 =
                                        getCurrentValue(
                                          );
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      string1 =
                                        getCurrentValue(
                                          );
                                      string1Delim =
                                        scanner.
                                          getStringDelimiter(
                                            );
                                      t =
                                        scanner.
                                          next(
                                            );
                              }
                              char[] space5 =
                                null;
                              if (t == org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  space5 =
                                    getCurrentValue(
                                      );
                                  t =
                                    scanner.
                                      next(
                                        );
                              }
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              output.printNotation(
                                       space1,
                                       name,
                                       space2,
                                       externalId,
                                       space3,
                                       string1,
                                       string1Delim,
                                       space4,
                                       string2,
                                       string2Delim,
                                       space5);
                              scanner.next(
                                        );
    }
    protected void printAttlist() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              char[] space =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      NAME) {
                                  throw fatalError(
                                          "name",
                                          null);
                              }
                              char[] name =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              output.printAttlistStart(
                                       space,
                                       name);
                              while (type ==
                                       org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  space =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (type !=
                                        org.apache.batik.xml.LexicalUnits.
                                          NAME) {
                                      break;
                                  }
                                  name =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (type !=
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      throw fatalError(
                                              "space",
                                              null);
                                  }
                                  char[] space2 =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  output.
                                    printAttName(
                                      space,
                                      name,
                                      space2);
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             CDATA_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ID_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             IDREF_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             IDREFS_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITY_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITIES_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             NMTOKEN_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             NMTOKENS_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             NOTATION_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          output.
                                            printSpaces(
                                              getCurrentValue(
                                                ),
                                              false);
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  LEFT_BRACE) {
                                              throw fatalError(
                                                      "left.brace",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          java.util.List names =
                                            new java.util.LinkedList(
                                            );
                                          space =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NAME) {
                                              throw fatalError(
                                                      "name",
                                                      null);
                                          }
                                          name =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          space2 =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space2 =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          names.
                                            add(
                                              new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                space,
                                                name,
                                                space2));
                                          loop: for (;
                                                     ;
                                                     ) {
                                              switch (type) {
                                                  default:
                                                      break loop;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PIPE:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              NAME) {
                                                          throw fatalError(
                                                                  "name",
                                                                  null);
                                                      }
                                                      name =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space2 =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space2 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      names.
                                                        add(
                                                          new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                            space,
                                                            name,
                                                            space2));
                                              }
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  RIGHT_BRACE) {
                                              throw fatalError(
                                                      "right.brace",
                                                      null);
                                          }
                                          output.
                                            printEnumeration(
                                              names);
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             LEFT_BRACE:
                                          type =
                                            scanner.
                                              next(
                                                );
                                          names =
                                            new java.util.LinkedList(
                                              );
                                          space =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NMTOKEN) {
                                              throw fatalError(
                                                      "nmtoken",
                                                      null);
                                          }
                                          name =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          space2 =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space2 =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          names.
                                            add(
                                              new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                space,
                                                name,
                                                space2));
                                          loop: for (;
                                                     ;
                                                     ) {
                                              switch (type) {
                                                  default:
                                                      break loop;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PIPE:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              NMTOKEN) {
                                                          throw fatalError(
                                                                  "nmtoken",
                                                                  null);
                                                      }
                                                      name =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space2 =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space2 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      names.
                                                        add(
                                                          new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                            space,
                                                            name,
                                                            space2));
                                              }
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  RIGHT_BRACE) {
                                              throw fatalError(
                                                      "right.brace",
                                                      null);
                                          }
                                          output.
                                            printEnumeration(
                                              names);
                                          type =
                                            scanner.
                                              next(
                                                );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      output.
                                        printSpaces(
                                          getCurrentValue(
                                            ),
                                          true);
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  switch (type) {
                                      default:
                                          throw fatalError(
                                                  "default.decl",
                                                  null);
                                      case org.apache.batik.xml.LexicalUnits.
                                             REQUIRED_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             IMPLIED_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             FIXED_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          output.
                                            printSpaces(
                                              getCurrentValue(
                                                ),
                                              false);
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  STRING &&
                                                type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  FIRST_ATTRIBUTE_FRAGMENT) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                      case org.apache.batik.xml.LexicalUnits.
                                             STRING:
                                      case org.apache.batik.xml.LexicalUnits.
                                             FIRST_ATTRIBUTE_FRAGMENT:
                                          output.
                                            printCharacter(
                                              scanner.
                                                getStringDelimiter(
                                                  ));
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          loop: for (;
                                                     ;
                                                     ) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         STRING:
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         ATTRIBUTE_FRAGMENT:
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         FIRST_ATTRIBUTE_FRAGMENT:
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         LAST_ATTRIBUTE_FRAGMENT:
                                                      output.
                                                        printCharacters(
                                                          getCurrentValue(
                                                            ));
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         CHARACTER_REFERENCE:
                                                      output.
                                                        printString(
                                                          "&#");
                                                      output.
                                                        printCharacters(
                                                          getCurrentValue(
                                                            ));
                                                      output.
                                                        printCharacter(
                                                          ';');
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         ENTITY_REFERENCE:
                                                      output.
                                                        printCharacter(
                                                          '&');
                                                      output.
                                                        printCharacters(
                                                          getCurrentValue(
                                                            ));
                                                      output.
                                                        printCharacter(
                                                          ';');
                                                      break;
                                                  default:
                                                      break loop;
                                              }
                                          }
                                          output.
                                            printCharacter(
                                              scanner.
                                                getStringDelimiter(
                                                  ));
                                  }
                                  space =
                                    null;
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              output.printAttlistEnd(
                                       space);
                              type = scanner.
                                       next(
                                         );
    }
    protected void printEntityDeclaration()
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { writer.write(
                                       "<!ENTITY");
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              type = scanner.
                                       next(
                                         );
                              boolean pe =
                                false;
                              switch (type) {
                                  default:
                                      throw fatalError(
                                              "xml",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         NAME:
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         PERCENT:
                                      pe =
                                        true;
                                      writer.
                                        write(
                                          '%');
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              NAME) {
                                          throw fatalError(
                                                  "name",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              type = scanner.
                                       next(
                                         );
                              switch (type) {
                                  case org.apache.batik.xml.LexicalUnits.
                                         STRING:
                                  case org.apache.batik.xml.LexicalUnits.
                                         FIRST_ATTRIBUTE_FRAGMENT:
                                      char sd =
                                        scanner.
                                        getStringDelimiter(
                                          );
                                      writer.
                                        write(
                                          sd);
                                      loop: for (;
                                                 ;
                                                 ) {
                                          switch (type) {
                                              case org.apache.batik.xml.LexicalUnits.
                                                     STRING:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     FIRST_ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     LAST_ATTRIBUTE_FRAGMENT:
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ENTITY_REFERENCE:
                                                  writer.
                                                    write(
                                                      '&');
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  writer.
                                                    write(
                                                      ';');
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     PARAMETER_ENTITY_REFERENCE:
                                                  writer.
                                                    write(
                                                      '&');
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  writer.
                                                    write(
                                                      ';');
                                                  break;
                                              default:
                                                  break loop;
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      writer.
                                        write(
                                          sd);
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          writer.
                                            write(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              END_CHAR) {
                                          throw fatalError(
                                                  "end",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          ">");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      return;
                                  case org.apache.batik.xml.LexicalUnits.
                                         PUBLIC_IDENTIFIER:
                                      writer.
                                        write(
                                          "PUBLIC");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          " \"");
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      writer.
                                        write(
                                          "\" \"");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      writer.
                                        write(
                                          '\"');
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         SYSTEM_IDENTIFIER:
                                      writer.
                                        write(
                                          "SYSTEM");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          " \"");
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      writer.
                                        write(
                                          '\"');
                              }
                              type = scanner.
                                       next(
                                         );
                              if (type ==
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  writer.
                                    write(
                                      getCurrentValue(
                                        ));
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (!pe &&
                                        type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          NDATA_IDENTIFIER) {
                                      writer.
                                        write(
                                          "NDATA");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              NAME) {
                                          throw fatalError(
                                                  "name",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              writer.write(
                                       '>');
                              type = scanner.
                                       next(
                                         );
    }
    protected void printElementDeclaration()
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { writer.write(
                                       "<!ELEMENT");
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              type = scanner.
                                       next(
                                         );
                              switch (type) {
                                  default:
                                      throw fatalError(
                                              "name",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         NAME:
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                              }
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              switch (type =
                                        scanner.
                                          next(
                                            )) {
                                  case org.apache.batik.xml.LexicalUnits.
                                         EMPTY_IDENTIFIER:
                                      writer.
                                        write(
                                          "EMPTY");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         ANY_IDENTIFIER:
                                      writer.
                                        write(
                                          "ANY");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         LEFT_BRACE:
                                      writer.
                                        write(
                                          '(');
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          writer.
                                            write(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      mixed: switch (type) {
                                          case org.apache.batik.xml.LexicalUnits.
                                                 PCDATA_IDENTIFIER:
                                              writer.
                                                write(
                                                  "#PCDATA");
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              for (;
                                                   ;
                                                   ) {
                                                  switch (type) {
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             S:
                                                          writer.
                                                            write(
                                                              getCurrentValue(
                                                                ));
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             PIPE:
                                                          writer.
                                                            write(
                                                              '|');
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          if (type ==
                                                                org.apache.batik.xml.LexicalUnits.
                                                                  S) {
                                                              writer.
                                                                write(
                                                                  getCurrentValue(
                                                                    ));
                                                              type =
                                                                scanner.
                                                                  next(
                                                                    );
                                                          }
                                                          if (type !=
                                                                org.apache.batik.xml.LexicalUnits.
                                                                  NAME) {
                                                              throw fatalError(
                                                                      "name",
                                                                      null);
                                                          }
                                                          writer.
                                                            write(
                                                              getCurrentValue(
                                                                ));
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             RIGHT_BRACE:
                                                          writer.
                                                            write(
                                                              ')');
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break mixed;
                                                  }
                                              }
                                          case org.apache.batik.xml.LexicalUnits.
                                                 NAME:
                                          case org.apache.batik.xml.LexicalUnits.
                                                 LEFT_BRACE:
                                              printChildren(
                                                );
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      RIGHT_BRACE) {
                                                  throw fatalError(
                                                          "right.brace",
                                                          null);
                                              }
                                              writer.
                                                write(
                                                  ')');
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         QUESTION:
                                                      writer.
                                                        write(
                                                          '?');
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         STAR:
                                                      writer.
                                                        write(
                                                          '*');
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PLUS:
                                                      writer.
                                                        write(
                                                          '+');
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                              }
                                      }
                              }
                              if (type ==
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  writer.
                                    write(
                                      getCurrentValue(
                                        ));
                                  type =
                                    scanner.
                                      next(
                                        );
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              writer.write(
                                       '>');
                              scanner.next(
                                        );
    }
    protected void printChildren() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { int op = 0;
                              loop: for (;
                                         ;
                                         ) {
                                  switch (type) {
                                      default:
                                          throw new java.lang.RuntimeException(
                                            "Invalid XML");
                                      case org.apache.batik.xml.LexicalUnits.
                                             NAME:
                                          writer.
                                            write(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             LEFT_BRACE:
                                          writer.
                                            write(
                                              '(');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              writer.
                                                write(
                                                  getCurrentValue(
                                                    ));
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          printChildren(
                                            );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  RIGHT_BRACE) {
                                              throw fatalError(
                                                      "right.brace",
                                                      null);
                                          }
                                          writer.
                                            write(
                                              ')');
                                          type =
                                            scanner.
                                              next(
                                                );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             RIGHT_BRACE:
                                          break loop;
                                      case org.apache.batik.xml.LexicalUnits.
                                             STAR:
                                          writer.
                                            write(
                                              '*');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             QUESTION:
                                          writer.
                                            write(
                                              '?');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PLUS:
                                          writer.
                                            write(
                                              '+');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             PIPE:
                                          if (op !=
                                                0 &&
                                                op !=
                                                type) {
                                              throw new java.lang.RuntimeException(
                                                "Invalid XML");
                                          }
                                          writer.
                                            write(
                                              '|');
                                          op =
                                            type;
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             COMMA:
                                          if (op !=
                                                0 &&
                                                op !=
                                                type) {
                                              throw new java.lang.RuntimeException(
                                                "Invalid XML");
                                          }
                                          writer.
                                            write(
                                              ',');
                                          op =
                                            type;
                                          type =
                                            scanner.
                                              next(
                                                );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              } }
    protected char[] getCurrentValue() { int off =
                                           scanner.
                                           getStart(
                                             ) +
                                           scanner.
                                           getStartOffset(
                                             );
                                         int len =
                                           scanner.
                                           getEnd(
                                             ) +
                                           scanner.
                                           getEndOffset(
                                             ) -
                                           off;
                                         char[] result =
                                           new char[len];
                                         char[] buffer =
                                           scanner.
                                           getBuffer(
                                             );
                                         java.lang.System.
                                           arraycopy(
                                             buffer,
                                             off,
                                             result,
                                             0,
                                             len);
                                         return result;
    }
    protected org.apache.batik.transcoder.TranscoderException fatalError(java.lang.String key,
                                                                         java.lang.Object[] params)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscoderException result =
          new org.apache.batik.transcoder.TranscoderException(
          key);
        errorHandler.
          fatalError(
            result);
        return result;
    }
    public PrettyPrinter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WhzFNBEpjOAUUxdqjUCbWtjw2rPmcMLW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "DsK2Cw9uJbn9DQqr29yEJd+GSY4DSLfkhQbl0xUFCvT5HOKpdhvXPS3fsiA9" +
       "3PLlb7C1rSntvylQlruNoU6M3Zvr/LOUg+/bfWd0cPXmFrX5KHrzkuvo/dYl" +
       "U7MXx9/YHbzRTY7q35vtPXL8AU/LdGwt3xzj8NnLD2d0RxtLgYfJTZF+fYt0" +
       "01h+/dQZ9vu3z3j2tjypg7mikoPZYj8j+w/seuumT7/6Nvr0k4fe+8u7Pv3l" +
       "O9OnD45VtAmMD67sVHH9F6/bzSBubgPuof7pc+o/zwsf6Z66Uff57Y3E0FOU" +
       "6W6ES72YIvkzno3zZJQnb9+iOCOvmGx/O6eGsRd+apMh/5fiQSso3D+XA9nc" +
       "fNW8PpqIbxjht2IDCRgkrtshKd/i5fEbNmbbbiamfPq5y/c+9pzwn7ce8HDD" +
       "r/v6hXvnoWme3JHjxPkl19Pm+kYv923SB7eylYPCU+f4TD7fE2B7tjGed24L" +
       "q0HhVWcUBvI5vjhZDlT30H450NU2vyfzrUANx/mAO9menMxiBYWLIEt+am+M" +
       "s5tsbefxk/0rV0nh4RdTyYkX4k9dN35tdtI7fOUcbvfSu6Z85rku8yPfrP78" +
       "dtMjENBkWV7LvWCo2e6/tBtqTm7TsV/bYV2XOk//5YOfve8Nh6/YH9wCPu7r" +
       "J7C99ua7ChGWG2z2Acp+7bFfeds/e+6PNvuh/H+4bBKD4lAAAA==");
}
