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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "LAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6+2qH5xk+FiR4Z/dZK/883nwq2Hp8UAJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("b7ize929xdg15JNB+LW32lY83fCeIIo3ozi4mENBMHdGEKdx/pubpP27PPgS" +
       "kIF2ExkU4jzB+y9vA2+xlf84uMaHeMdvF2/rLfH+1l7a3uur52+0u1+cT+ok" +
       "kuIdv106fttluFco7jitaOYrefCbYelu2S1K5n+/eCKl/3C7UnofAHxmV3Z3" +
       "v7NS+v3rSyn/+9U8+FqR6w/y4OtACoWMZoayxcPQN1ZRuHvldwrwN24X8GXQ" +
       "/A92ZXf3Owv4j28J8J/kwR+GpYsF4BNT2AP7zdsA+3BpZ/hn792V3d3vLNj/" +
       "eZO07+bBn4WlS8DmieIdXXHQd/fe95UTjH9+uwP6JMB2OOns7ncW41/eJO2v" +
       "8uAvwGy0ewl5+A7y1AB+/3bBPQVAPXEI7ok7Du7g/I1ntkJRD+7Jg4OwdCGw" +
       "DG/sHZ0tOYF4cOYOGOTZ5w8hPn/nIT70VhDflQf3A1vMIYI10Vq8Ls4Hbhfn" +
       "0wDf4avls9e8Wr59nE/eCvEcPJ0H7wlL7yiIZyAClk32gD52J4AGh0CDOw/0" +
       "hVsC+oE8eO4I6Cg/zLFnnAfP3y7QZwHALx8C/fKdB1q/JaCNPEDC0gMF0Ikv" +
       "OoF9LdbKHSCicw/vyu7udxYrcUtY23nwI4CNCqxjSbT3cX7oDswm57hDnNyd" +
       "x8neEk4+D6j8fGKB01K2ezDp24X5DID3s4cwf/bOwxTeinR/PA+mYen+nHQL" +
       "pc3Pk++hnN0uyg8CdL94iPIX7zxK9ZYGM/8S5EAMS48Wg8n7ClgFxAoeeApY" +
       "5edHzPZQr+4ALd312q7s7n5nUftvNba5h3ewBoyUj+2NfNsD5+3ATID4bvSp" +
       "R35u/dFrPj3bfS4lfeH1i/c88vr0P++Ozh590nQvU7pHjWz79DHjU/Hznq+o" +
       "u3nx3t2hY68A9tGw9MgNlnX5pwBFJO/6QbbL/zHg/e7nD0t3FffT+T4OGO0k" +
       "H6hqFzmd5e+FpbMgSx796d3JPLBovHyjNebuTNROPMnuHOejpxWm8E0feqsB" +
       "OLU/8+xV5yiLzwGPzjxGuw8CX5K++DrNfvR79V/ZfaAh2WKW5bXcw5Tu3n0r" +
       "UlSan5t87w1rO6rrfO/9P3jgN+597mjH54Fdh0+U91Tfnrr+1xCdtRcW3y9k" +
       "//qRf/HDv/b6N4ujYf8PTuTSwqc5AAA=");
}
