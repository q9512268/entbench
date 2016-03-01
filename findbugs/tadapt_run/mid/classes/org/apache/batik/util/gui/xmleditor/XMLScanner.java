package org.apache.batik.util.gui.xmleditor;
public class XMLScanner {
    public static final int TEMP_ERROR_CONTEXT = -2;
    public static final int EOF_CONTEXT = -1;
    public static final int DEFAULT_CONTEXT = 0;
    public static final int COMMENT_CONTEXT = 1;
    public static final int ELEMENT_CONTEXT = 2;
    public static final int CHARACTER_DATA_CONTEXT = 3;
    public static final int ATTRIBUTE_NAME_CONTEXT = 4;
    public static final int ATTRIBUTE_VALUE_CONTEXT = 5;
    public static final int XML_DECLARATION_CONTEXT = 6;
    public static final int DOCTYPE_CONTEXT = 7;
    public static final int ENTITY_CONTEXT = 8;
    public static final int ELEMENT_DECLARATION_CONTEXT = 9;
    public static final int CDATA_CONTEXT = 10;
    public static final int PI_CONTEXT = 11;
    private int position;
    private java.lang.String string;
    private int current;
    private int scanValue;
    private int startOffset;
    public XMLScanner() { super();
                          reset(); }
    public void reset() { position = 0;
                          startOffset = 0; }
    public void setString(java.lang.String string) { this.string = string;
    }
    protected int nextChar() { try { current = (int) string.charAt(position);
                                     position++; }
                               catch (java.lang.Exception ex) { current =
                                                                  -1; }
                               return current; }
    protected int skipSpaces() { do  { nextChar(); }while(current != -1 &&
                                                            org.apache.batik.xml.XMLUtilities.
                                                            isXMLSpace(
                                                              (char)
                                                                current)); 
                                 return current; }
    public int getScanValue() { return scanValue; }
    public int getStartOffset() { return startOffset; }
    public int scan(int context) { nextChar();
                                   switch (context) { case XML_DECLARATION_CONTEXT:
                                                          scanValue =
                                                            scanXMLDeclaration(
                                                              );
                                                          break;
                                                      case DOCTYPE_CONTEXT:
                                                          scanValue =
                                                            scanDOCTYPE(
                                                              );
                                                          break;
                                                      case COMMENT_CONTEXT:
                                                          scanValue =
                                                            scanComment(
                                                              );
                                                          break;
                                                      case ELEMENT_CONTEXT:
                                                          scanValue =
                                                            scanElement(
                                                              );
                                                          break;
                                                      case ATTRIBUTE_NAME_CONTEXT:
                                                          scanValue =
                                                            scanAttributeName(
                                                              );
                                                          break;
                                                      case ATTRIBUTE_VALUE_CONTEXT:
                                                          scanValue =
                                                            scanAttributeValue(
                                                              );
                                                          break;
                                                      case CDATA_CONTEXT:
                                                          scanValue =
                                                            scanCDATA(
                                                              );
                                                          break;
                                                      default:
                                                          scanValue =
                                                            scanCharacterData(
                                                              );
                                                          break;
                                   }
                                   return position;
    }
    private int scanCharacterData() { while (current !=
                                               -1) {
                                          if (current ==
                                                '<') {
                                              nextChar(
                                                );
                                              if (current ==
                                                    '?') {
                                                  position =
                                                    position -
                                                      2;
                                                  return XML_DECLARATION_CONTEXT;
                                              }
                                              else
                                                  if (current ==
                                                        '!') {
                                                      nextChar(
                                                        );
                                                      if (current ==
                                                            'D') {
                                                          position =
                                                            position -
                                                              3;
                                                          return DOCTYPE_CONTEXT;
                                                      }
                                                      else
                                                          if (current ==
                                                                '-') {
                                                              nextChar(
                                                                );
                                                              if (current ==
                                                                    '-') {
                                                                  position =
                                                                    position -
                                                                      4;
                                                                  return COMMENT_CONTEXT;
                                                              }
                                                          }
                                                          else
                                                              if (current ==
                                                                    '[') {
                                                                  if (nextChar(
                                                                        ) ==
                                                                        'C') {
                                                                      if (nextChar(
                                                                            ) ==
                                                                            'D') {
                                                                          if (nextChar(
                                                                                ) ==
                                                                                'A') {
                                                                              if (nextChar(
                                                                                    ) ==
                                                                                    'T') {
                                                                                  if (nextChar(
                                                                                        ) ==
                                                                                        'A') {
                                                                                      if (nextChar(
                                                                                            ) ==
                                                                                            '[') {
                                                                                          position =
                                                                                            position -
                                                                                              9;
                                                                                          return CDATA_CONTEXT;
                                                                                      }
                                                                                  }
                                                                              }
                                                                          }
                                                                      }
                                                                  }
                                                              }
                                                  }
                                                  else {
                                                      position =
                                                        position -
                                                          2;
                                                      return ELEMENT_CONTEXT;
                                                  }
                                          }
                                          nextChar(
                                            );
                                      }
                                      if (current ==
                                            -1) {
                                          return EOF_CONTEXT;
                                      }
                                      return CHARACTER_DATA_CONTEXT;
    }
    private int scanXMLDeclaration() { position =
                                         position +
                                           2;
                                       while (current !=
                                                -1) {
                                           if (current ==
                                                 '?') {
                                               if (nextChar(
                                                     ) ==
                                                     '>') {
                                                   return CHARACTER_DATA_CONTEXT;
                                               }
                                               else {
                                                   return TEMP_ERROR_CONTEXT;
                                               }
                                           }
                                           nextChar(
                                             );
                                       }
                                       if (current ==
                                             -1) {
                                           return EOF_CONTEXT;
                                       }
                                       return XML_DECLARATION_CONTEXT;
    }
    private int scanDOCTYPE() { position =
                                  position +
                                    3;
                                boolean end =
                                  true;
                                while (current !=
                                         -1) {
                                    if (current ==
                                          '[') {
                                        end =
                                          false;
                                    }
                                    else
                                        if (current ==
                                              ']') {
                                            end =
                                              true;
                                        }
                                        else
                                            if (current ==
                                                  '>' &&
                                                  end ==
                                                  true) {
                                                return CHARACTER_DATA_CONTEXT;
                                            }
                                    nextChar(
                                      );
                                }
                                if (current ==
                                      -1) {
                                    return EOF_CONTEXT;
                                }
                                return DOCTYPE_CONTEXT;
    }
    private int scanComment() { while (current !=
                                         -1) {
                                    if (current ==
                                          '-') {
                                        if (nextChar(
                                              ) ==
                                              '-') {
                                            if (nextChar(
                                                  ) ==
                                                  '>') {
                                                return CHARACTER_DATA_CONTEXT;
                                            }
                                        }
                                    }
                                    nextChar(
                                      );
                                }
                                if (current ==
                                      -1) {
                                    return EOF_CONTEXT;
                                }
                                return COMMENT_CONTEXT;
    }
    private int scanElement() { while (current !=
                                         -1) {
                                    if (current ==
                                          '>') {
                                        return CHARACTER_DATA_CONTEXT;
                                    }
                                    else
                                        if (org.apache.batik.xml.XMLUtilities.
                                              isXMLSpace(
                                                (char)
                                                  current)) {
                                            return ATTRIBUTE_NAME_CONTEXT;
                                        }
                                    nextChar(
                                      );
                                }
                                if (current ==
                                      -1) {
                                    return EOF_CONTEXT;
                                }
                                return ELEMENT_CONTEXT;
    }
    private int scanAttributeName() { while (current !=
                                               -1) {
                                          if (current ==
                                                '=') {
                                              return ATTRIBUTE_VALUE_CONTEXT;
                                          }
                                          else
                                              if (current ==
                                                    '/') {
                                                  position--;
                                                  return ELEMENT_CONTEXT;
                                              }
                                              else
                                                  if (current ==
                                                        '>') {
                                                      position--;
                                                      return ELEMENT_CONTEXT;
                                                  }
                                          nextChar(
                                            );
                                      }
                                      if (current ==
                                            -1) {
                                          return EOF_CONTEXT;
                                      }
                                      return ATTRIBUTE_NAME_CONTEXT;
    }
    private int scanAttributeValue() { int delim =
                                         '\"';
                                       while (current !=
                                                -1) {
                                           if (current ==
                                                 '\"' ||
                                                 current ==
                                                 '\'') {
                                               delim =
                                                 current;
                                               break;
                                           }
                                           nextChar(
                                             );
                                       }
                                       nextChar(
                                         );
                                       while (current !=
                                                -1) {
                                           if (current ==
                                                 delim) {
                                               return ELEMENT_CONTEXT;
                                           }
                                           nextChar(
                                             );
                                       }
                                       if (current ==
                                             -1) {
                                           return EOF_CONTEXT;
                                       }
                                       return ATTRIBUTE_VALUE_CONTEXT;
    }
    private int scanCDATA() { while (current !=
                                       -1) {
                                  if (current ==
                                        ']') {
                                      if (nextChar(
                                            ) ==
                                            ']') {
                                          if (nextChar(
                                                ) ==
                                                '>') {
                                              return CHARACTER_DATA_CONTEXT;
                                          }
                                      }
                                  }
                                  nextChar(
                                    );
                              }
                              if (current ==
                                    -1) {
                                  return EOF_CONTEXT;
                              }
                              return CDATA_CONTEXT;
    }
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
      ("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" +
       "m4Oy1F+3Mr+HI2R1kJjuVEgzq6tV6TSp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("L7P6gHelQKnifrPpZAlj8HGl3ujzCRTFSh2ympjIUZo6nIxBGw3iMmt2O0O3" +
       "pCz9VOCI4rSmLZRgVRxavuXwWXPEmWHVs3iTpnKo1gjpMhaLTkWThruhGdZ1" +
       "p7KqhVUFq040fSQ56zERN+TEarsUz46iTIFRC2YWFJhZe1XfrQRLf1Bsj/HU" +
       "dTm4XqnBWqSPHOCD8vOKIMtVdTIwI6So1vvpGJ5FTY9ZSyRw0SxcQZpyTbKL" +
       "YkQtHLDkqy0sbuCpggWL42bJooslvm2jo8akVKNNcVTPRuvlQmu6ZbVOR0Vy" +
       "Sq+NkesH7Vkw9YQQw1fRKrLDCkMja0Nt4sqglJIuUqblVdUaLVWnBs8Ye4WY" +
       "ZmXWYSDQqa1p1qxZo06GougP5dtvf3G6bcG7Nlua+0eY38Jm5jbpsTx4cn/z" +
       "d/M5Vzh27PXQ5u9G8oHdmanALzx8vZPJmyMkX/z0Cy9p/S/BZ3eny7iwcFvo" +
       "eh+w9Fi3DhV1EZT09PWPy7Cbg9kHp55+/dN/8qDwocXHT3GW85FjOI8X+Y/Z" +
       "L3+Teo/602cLN+2fgXrdkfGjmZ45evLpgq+Hke8IR84/PbzfspvzlPeDp7lr" +
       "2ebxbfWDvrv2nvr7tn2/Sbvm4b0zt5+Qlp/8OXMuLNzi64EeXnPrOHYNbV93" +
       "zpx/o13jwzXkL87cdJRs/tfwh3ZkP3RjyJ45EPjNDasHT2D8UB7cm/8zoof7" +
       "fyCduXjA8L63wfDu/GX+5w22Y4idhiEA5fluqKuhrr1hr773hLSn8uCxsHCr" +
       "AwYNvpA3pwZ7BxQff7sU8z+CejuKvVN24pkn35Bb5YS0ah5cCQsXgqXhDb29" +
       "Kx2H2EFvg93F/OW7wCPu2Ik3fjx++IQ0NA9+MCzcMQfaeeSvuwN+z7xdfrn1" +
       "nuz4TW48P/qENDYPyLBwZ87v2H+ABwypt8vwHvB8dMfwozeG4SEj09tQGZ1A" +
       "c5IHPDCe+d+vx8gN3wa5jVh+lPCTO3KfPC25V9+w+9QT0nJVPPMx4GfkvHLD" +
       "IgNb5bfkUD5G8urbJZmfP3x5R/LlG0/SPSFtlQdmWLg7JzlmmRaY9vPrA3sH" +
       "Iw5YLt8uy9zSvLpj+eqNZ/mJE9KezYM4/ysesNwdrzpGL7kR9L69o/ftG0/v" +
       "uRPS/mYefHpHD3dte+9kxgG9v3Ej6P3Zjt6f3Xh6P3NC2ot58PyOXn6f9PX0" +
       "fuoG2JkzZ7d5t983lt7fPyHtH+bB393ZGTQEbpoShXpv51YfIvn3boCdOXP/" +
       "juT9N57kPzkh7eU8+Lmdndknea0Z/+ffLst3AsC7y0xnrnNj6+2w/OUT0v5l" +
       "HvzS7iTS5qzeMXL/9DTkUuD4HVwQzG87PfC6q8rb67XqV166eOv9L4n/fnNH" +
       "bv8K7G1M4dZZZFmHL6ccip/zfH1mbAjftr2q4m1YvBIWnngTlxcBzf34ph/+" +
       "9Tb7r4aFd143e1i4CYSHxb8RFu69pjjwKPKvw7LfDAuXjsuC9dzm+7Dct0DL" +
       "HciFhXPbyGGR3wFIgEge/TfepumPnrfb3gZKtycgHzikbttthbvfqCMPbRA8" +
       "cWRZv7mUvrcEj7bX0q+qX32p2/vE92pf2l4WBHNwluWl3MoUzm/vLW4KzZfx" +
       "j123tL2yzrWf+v6dv3jbk3tbDnduAR+o/iFsj1z7Zh5he+HmLl32L+7/Zx/8" +
       "+Zf+YHOn6P8Bzy0ghC1AAAA=");
}
