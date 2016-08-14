package org.apache.batik.parser;
public class FragmentIdentifierParser extends org.apache.batik.parser.NumberParser {
    protected char[] buffer = new char[16];
    protected int bufferSize;
    protected org.apache.batik.parser.FragmentIdentifierHandler fragmentIdentifierHandler;
    public FragmentIdentifierParser() { super();
                                        fragmentIdentifierHandler = org.apache.batik.parser.DefaultFragmentIdentifierHandler.
                                                                      INSTANCE;
    }
    public void setFragmentIdentifierHandler(org.apache.batik.parser.FragmentIdentifierHandler handler) {
        fragmentIdentifierHandler =
          handler;
    }
    public org.apache.batik.parser.FragmentIdentifierHandler getFragmentIdentifierHandler() {
        return fragmentIdentifierHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { bufferSize = 0;
                              current = reader.read(
                                                 );
                              fragmentIdentifierHandler.
                                startFragmentIdentifier(
                                  );
                              ident: { java.lang.String id =
                                         null;
                                       switch (current) {
                                           case 'x':
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'p') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'o') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'i') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'n') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     't') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'e') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'r') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '(') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferSize =
                                                 0;
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'i') {
                                                   reportCharacterExpectedError(
                                                     'i',
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'd') {
                                                   reportCharacterExpectedError(
                                                     'd',
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '(') {
                                                   reportCharacterExpectedError(
                                                     '(',
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '\"' &&
                                                     current !=
                                                     '\'') {
                                                   reportCharacterExpectedError(
                                                     '\'',
                                                     current);
                                                   break ident;
                                               }
                                               char q =
                                                 (char)
                                                   current;
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               parseIdentifier(
                                                 );
                                               id =
                                                 getBufferContent(
                                                   );
                                               bufferSize =
                                                 0;
                                               fragmentIdentifierHandler.
                                                 idReference(
                                                   id);
                                               if (current !=
                                                     q) {
                                                   reportCharacterExpectedError(
                                                     q,
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     ')') {
                                                   reportCharacterExpectedError(
                                                     ')',
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     ')') {
                                                   reportCharacterExpectedError(
                                                     ')',
                                                     current);
                                               }
                                               break ident;
                                           case 's':
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'v') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'g') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'V') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'i') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'e') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'w') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '(') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferSize =
                                                 0;
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               parseViewAttributes(
                                                 );
                                               if (current !=
                                                     ')') {
                                                   reportCharacterExpectedError(
                                                     ')',
                                                     current);
                                               }
                                               break ident;
                                           default:
                                               if (current ==
                                                     -1 ||
                                                     !org.apache.batik.xml.XMLUtilities.
                                                     isXMLNameFirstCharacter(
                                                       (char)
                                                         current)) {
                                                   break ident;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               parseIdentifier(
                                                 );
                                       }
                                       id =
                                         getBufferContent(
                                           );
                                       fragmentIdentifierHandler.
                                         idReference(
                                           id);
                              }
                              fragmentIdentifierHandler.
                                endFragmentIdentifier(
                                  ); }
    protected void parseViewAttributes() throws org.apache.batik.parser.ParseException,
        java.io.IOException { boolean first =
                                true;
                              loop: for (;
                                         ;
                                         ) {
                                  switch (current) {
                                      case -1:
                                      case ')':
                                          if (first) {
                                              reportUnexpectedCharacterError(
                                                current);
                                              break loop;
                                          }
                                      default:
                                          break loop;
                                      case ';':
                                          if (first) {
                                              reportUnexpectedCharacterError(
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          break;
                                      case 'v':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'i') {
                                              reportCharacterExpectedError(
                                                'i',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'w') {
                                              reportCharacterExpectedError(
                                                'w',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              case 'B':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'o') {
                                                      reportCharacterExpectedError(
                                                        'o',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'x') {
                                                      reportCharacterExpectedError(
                                                        'x',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        '(') {
                                                      reportCharacterExpectedError(
                                                        '(',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float x =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ',') {
                                                      reportCharacterExpectedError(
                                                        ',',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float y =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ',') {
                                                      reportCharacterExpectedError(
                                                        ',',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float w =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ',') {
                                                      reportCharacterExpectedError(
                                                        ',',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float h =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ')') {
                                                      reportCharacterExpectedError(
                                                        ')',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    viewBox(
                                                      x,
                                                      y,
                                                      w,
                                                      h);
                                                  if (current !=
                                                        ')' &&
                                                        current !=
                                                        ';') {
                                                      reportCharacterExpectedError(
                                                        ')',
                                                        current);
                                                      break loop;
                                                  }
                                                  break;
                                              case 'T':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'a') {
                                                      reportCharacterExpectedError(
                                                        'a',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'r') {
                                                      reportCharacterExpectedError(
                                                        'r',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'g') {
                                                      reportCharacterExpectedError(
                                                        'g',
                                                        current);
                                                      break loop;
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
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        '(') {
                                                      reportCharacterExpectedError(
                                                        '(',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    startViewTarget(
                                                      );
                                                  id: for (;
                                                           ;
                                                           ) {
                                                      bufferSize =
                                                        0;
                                                      if (current ==
                                                            -1 ||
                                                            !org.apache.batik.xml.XMLUtilities.
                                                            isXMLNameFirstCharacter(
                                                              (char)
                                                                current)) {
                                                          reportUnexpectedCharacterError(
                                                            current);
                                                          break loop;
                                                      }
                                                      bufferize(
                                                        );
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      parseIdentifier(
                                                        );
                                                      java.lang.String s =
                                                        getBufferContent(
                                                          );
                                                      fragmentIdentifierHandler.
                                                        viewTarget(
                                                          s);
                                                      bufferSize =
                                                        0;
                                                      switch (current) {
                                                          case ')':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break id;
                                                          case ',':
                                                          case ';':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          default:
                                                              reportUnexpectedCharacterError(
                                                                current);
                                                              break loop;
                                                      }
                                                  }
                                                  fragmentIdentifierHandler.
                                                    endViewTarget(
                                                      );
                                                  break;
                                              default:
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  break loop;
                                          }
                                          break;
                                      case 'p':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                's') {
                                              reportCharacterExpectedError(
                                                's',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'v') {
                                              reportCharacterExpectedError(
                                                'v',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'A') {
                                              reportCharacterExpectedError(
                                                'A',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                's') {
                                              reportCharacterExpectedError(
                                                's',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'p') {
                                              reportCharacterExpectedError(
                                                'p',
                                                current);
                                              break loop;
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
                                              break loop;
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
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'R') {
                                              reportCharacterExpectedError(
                                                'R',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'a') {
                                              reportCharacterExpectedError(
                                                'a',
                                                current);
                                              break loop;
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
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                '(') {
                                              reportCharacterExpectedError(
                                                '(',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          parsePreserveAspectRatio(
                                            );
                                          if (current !=
                                                ')') {
                                              reportCharacterExpectedError(
                                                ')',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          break;
                                      case 't':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'a') {
                                              reportCharacterExpectedError(
                                                'a',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'n') {
                                              reportCharacterExpectedError(
                                                'n',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                's') {
                                              reportCharacterExpectedError(
                                                's',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'f') {
                                              reportCharacterExpectedError(
                                                'f',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'm') {
                                              reportCharacterExpectedError(
                                                'm',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                '(') {
                                              reportCharacterExpectedError(
                                                '(',
                                                current);
                                              break loop;
                                          }
                                          fragmentIdentifierHandler.
                                            startTransformList(
                                              );
                                          tloop: for (;
                                                      ;
                                                      ) {
                                              try {
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  switch (current) {
                                                      case ',':
                                                          break;
                                                      case 'm':
                                                          parseMatrix(
                                                            );
                                                          break;
                                                      case 'r':
                                                          parseRotate(
                                                            );
                                                          break;
                                                      case 't':
                                                          parseTranslate(
                                                            );
                                                          break;
                                                      case 's':
                                                          current =
                                                            reader.
                                                              read(
                                                                );
                                                          switch (current) {
                                                              case 'c':
                                                                  parseScale(
                                                                    );
                                                                  break;
                                                              case 'k':
                                                                  parseSkew(
                                                                    );
                                                                  break;
                                                              default:
                                                                  reportUnexpectedCharacterError(
                                                                    current);
                                                                  skipTransform(
                                                                    );
                                                          }
                                                          break;
                                                      default:
                                                          break tloop;
                                                  }
                                              }
                                              catch (org.apache.batik.parser.ParseException e) {
                                                  errorHandler.
                                                    error(
                                                      e);
                                                  skipTransform(
                                                    );
                                              }
                                          }
                                          fragmentIdentifierHandler.
                                            endTransformList(
                                              );
                                          break;
                                      case 'z':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'm') {
                                              reportCharacterExpectedError(
                                                'm',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'A') {
                                              reportCharacterExpectedError(
                                                'A',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'n') {
                                              reportCharacterExpectedError(
                                                'n',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'd') {
                                              reportCharacterExpectedError(
                                                'd',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'P') {
                                              reportCharacterExpectedError(
                                                'P',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'a') {
                                              reportCharacterExpectedError(
                                                'a',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'n') {
                                              reportCharacterExpectedError(
                                                'n',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                '(') {
                                              reportCharacterExpectedError(
                                                '(',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              case 'm':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'a') {
                                                      reportCharacterExpectedError(
                                                        'a',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'g') {
                                                      reportCharacterExpectedError(
                                                        'g',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'n') {
                                                      reportCharacterExpectedError(
                                                        'n',
                                                        current);
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'f') {
                                                      reportCharacterExpectedError(
                                                        'f',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'y') {
                                                      reportCharacterExpectedError(
                                                        'y',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    zoomAndPan(
                                                      true);
                                                  break;
                                              case 'd':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'i') {
                                                      reportCharacterExpectedError(
                                                        'i',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        's') {
                                                      reportCharacterExpectedError(
                                                        's',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'a') {
                                                      reportCharacterExpectedError(
                                                        'a',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'b') {
                                                      reportCharacterExpectedError(
                                                        'b',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'l') {
                                                      reportCharacterExpectedError(
                                                        'l',
                                                        current);
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    zoomAndPan(
                                                      false);
                                                  break;
                                              default:
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  break loop;
                                          }
                                          if (current !=
                                                ')') {
                                              reportCharacterExpectedError(
                                                ')',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                  }
                              } }
    protected void parseIdentifier() throws org.apache.batik.parser.ParseException,
        java.io.IOException { for (; ; ) {
                                  if (current ==
                                        -1 ||
                                        !org.apache.batik.xml.XMLUtilities.
                                        isXMLNameCharacter(
                                          (char)
                                            current)) {
                                      break;
                                  }
                                  bufferize(
                                    );
                                  current =
                                    reader.
                                      read(
                                        );
                              } }
    protected java.lang.String getBufferContent() {
        return new java.lang.String(
          buffer,
          0,
          bufferSize);
    }
    protected void bufferize() { if (bufferSize >=
                                       buffer.
                                         length) {
                                     char[] t =
                                       new char[buffer.
                                                  length *
                                                  2];
                                     java.lang.System.
                                       arraycopy(
                                         buffer,
                                         0,
                                         t,
                                         0,
                                         bufferSize);
                                     buffer =
                                       t;
                                 }
                                 buffer[bufferSize++] =
                                   (char)
                                     current;
    }
    protected void skipSpaces() throws java.io.IOException {
        if (current ==
              ',') {
            current =
              reader.
                read(
                  );
        }
    }
    protected void skipCommaSpaces() throws java.io.IOException {
        if (current ==
              ',') {
            current =
              reader.
                read(
                  );
        }
    }
    protected void parseMatrix() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'r') {
                                  reportCharacterExpectedError(
                                    'r',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'i') {
                                  reportCharacterExpectedError(
                                    'i',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'x') {
                                  reportCharacterExpectedError(
                                    'x',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float a = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float b = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float c = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float d = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float e = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float f = parseFloat(
                                          );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                matrix(
                                  a,
                                  b,
                                  c,
                                  d,
                                  e,
                                  f); }
    protected void parseRotate() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'o') {
                                  reportCharacterExpectedError(
                                    'o',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float theta =
                                parseFloat(
                                  );
                              skipSpaces(
                                );
                              switch (current) {
                                  case ')':
                                      fragmentIdentifierHandler.
                                        rotate(
                                          theta);
                                      return;
                                  case ',':
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                              }
                              float cx = parseFloat(
                                           );
                              skipCommaSpaces(
                                );
                              float cy = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                rotate(
                                  theta,
                                  cx,
                                  cy); }
    protected void parseTranslate() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'r') {
                                  reportCharacterExpectedError(
                                    'r',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'n') {
                                  reportCharacterExpectedError(
                                    'n',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    's') {
                                  reportCharacterExpectedError(
                                    's',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'l') {
                                  reportCharacterExpectedError(
                                    'l',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float tx = parseFloat(
                                           );
                              skipSpaces(
                                );
                              switch (current) {
                                  case ')':
                                      fragmentIdentifierHandler.
                                        translate(
                                          tx);
                                      return;
                                  case ',':
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                              }
                              float ty = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                translate(
                                  tx,
                                  ty); }
    protected void parseScale() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'l') {
                                  reportCharacterExpectedError(
                                    'l',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float sx = parseFloat(
                                           );
                              skipSpaces(
                                );
                              switch (current) {
                                  case ')':
                                      fragmentIdentifierHandler.
                                        scale(
                                          sx);
                                      return;
                                  case ',':
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                              }
                              float sy = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                scale(
                                  sx,
                                  sy); }
    protected void parseSkew() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'w') {
                                  reportCharacterExpectedError(
                                    'w',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              boolean skewX =
                                false;
                              switch (current) {
                                  case 'X':
                                      skewX =
                                        true;
                                  case 'Y':
                                      break;
                                  default:
                                      reportCharacterExpectedError(
                                        'X',
                                        current);
                                      skipTransform(
                                        );
                                      return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float sk = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              if (skewX) {
                                  fragmentIdentifierHandler.
                                    skewX(
                                      sk);
                              }
                              else {
                                  fragmentIdentifierHandler.
                                    skewY(
                                      sk);
                              } }
    protected void skipTransform() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            current =
              reader.
                read(
                  );
            switch (current) {
                case ')':
                    break loop;
                default:
                    if (current ==
                          -1) {
                        break loop;
                    }
            }
        }
    }
    protected void parsePreserveAspectRatio()
          throws org.apache.batik.parser.ParseException,
        java.io.IOException { fragmentIdentifierHandler.
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
                                            'n',
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
                                      fragmentIdentifierHandler.
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
                                                      fragmentIdentifierHandler.
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
                                                              fragmentIdentifierHandler.
                                                                xMaxYMid(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'n':
                                                              fragmentIdentifierHandler.
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
                                                              fragmentIdentifierHandler.
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
                                                                      fragmentIdentifierHandler.
                                                                        xMidYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      fragmentIdentifierHandler.
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
                                                              fragmentIdentifierHandler.
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
                                                                      fragmentIdentifierHandler.
                                                                        xMinYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      fragmentIdentifierHandler.
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
                                      fragmentIdentifierHandler.
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
                                      fragmentIdentifierHandler.
                                        slice(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                              }
                              fragmentIdentifierHandler.
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
                case -1:
                    break loop;
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ni7dG/vBDznqWnVOdfVgkVeuPpHQA1f3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kAx8fzf4BOj1t4Lfk11vR/7gpMJHiwr/9Cb77J/Lk1+LS49HanzDXeHr7kuu" +
       "fVM5EcKvv9mW5OmB9xhRvDlFwUUdMoK6M4w4jfPf3KTs3+XJFwEP9JvwoGDn" +
       "Cd5/eRt4i9cAj4OLO8TLvVW82Jvi/e29sr1XX8/f6M1AcX6pm8lqcPxm6vhN" +
       "melf6Y+Py4phvpwnvxWX7lb8omX+9wsnXPoPt8ul9wDAZ3Ztd/c7y6U/uD6X" +
       "8r9fyZOvFrX+ME++BrhQ8EgA8x8ax6G5TOLd68JTgL9+u4Avg+F/sGu7u99Z" +
       "wH98S4D/JE/+KC5dLACfmMIe2G/cBtiHSzvDP3vvru3ufmfB/s+blH03T/4s" +
       "Ll0CNt8p3u8Vh31374xfPsH457cr0CcBtsNJZ3e/sxj/8iZlf5UnfwFmo90L" +
       "zMP3l6cE+P3bBfcUAPXEIbgn7ji4g/M3ntkKRT24J08O4tKFyDYDLjg6e3IC" +
       "8eDMHTDIs88fQnz+zkN86M0gviNP7ge2mEPEfNeVrovzgdvF+TTAd/ha+uw1" +
       "r6VvH+eTt+J4Dp7Ok3fFpbcVjoeWgJfN9oA+dieARodAozsP9IVbAvq+PHnu" +
       "CCibHwTZM86D528X6LMA4JcOgX7pzgNt3RJQJE+qcemBAigfSl7kXIu1dgcc" +
       "0bmHd2139zuLtXNLWPE8eT/wRgVWTpacfZwfuAOzybnxIc7xncc5uiWcTJ70" +
       "8/OLBU5bTfdgDm4X5jMA3icPYX7yzsMU38zp/nieTOPS/bnTLZQ2P2++h1K4" +
       "XZQ/BND90iHKX7rzKLVbEmb+NciBFJceLYTJhCpYBaxVNApUOWbz42l7qJd3" +
       "wC3d9equ7e5+Z1GHbybbPMI7cIFHymV7o9j2wHsrMDPAvht9CpKfa3/0ms/P" +
       "dp9MyZ9/7eI9j7w2/c+7o7VHnzXdS5Xu0RLHOX0M+VT+fBCq2m5evHd3KDko" +
       "gH04Lj1yg2Vd/qlAkclJP9ju6n8URL/79ePSXcX9dL2PAY92Ug90tcucrvLT" +
       "ceksqJJnf2Z3qg8sGi/faI25O0+1Y0+2OwP66GmFKWLTh95MAKf2Z5696gxm" +
       "8Ung0XnJZPdR4EvyF14bjD78vdav7j7gkB1pu817uYcq3b37lqToND9z+e4b" +
       "9nbU13nyvT944Dfvfe5ox+eBHcEnynuKtqeu/7VE1w3i4vuG7b9+5F/8yK+/" +
       "9o3iWNn/AwNE/HqrOQAA");
}
