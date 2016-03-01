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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OrJX+TpnXte5kR3iLuP/AeRsk0EwQQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ApG1ssHVsyLuzCppe8A1G3UceMUJP+um");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/8rjv/TOf/r8H232M/n/lRDH5L5QAAA=");
}
