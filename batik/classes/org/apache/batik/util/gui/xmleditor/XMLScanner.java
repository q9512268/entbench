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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wfDqgD8Irhlq6+xwA3c4jzByoan5QhdwxZg5ljc4JxUY8Dv9ofVdriP2YI6g" +
       "fPAsMDUucAFVgplH8gblpIKSCRAX20Lr3TA9miOmFfAsNBUudME0HjMn8sbk" +
       "pIKSGYl4/zk98Rd5DNoiU/siF4ClmHk2b4BOKiip8I8W8p/LEdJi80nknSCV" +
       "YeblvCE5qaCktKvNDc/Jz48Hj6bJNHOYEsOVjoewzO+zw/BQUqxq4gi8+9gQ" +
       "lLl0StNPxuz2v5mj/dOJEfBI4jeL/X8y7MfkrUxDnaTZay1+rGEiU2nqq7Lx" +
       "Fcdm+p9zNB39aYmpfImD6X9zNd1JGgaGj2kavHZlo/hMHhQvNTUtdbDzY1c7" +
       "naQpvNLxnMyOUbJZ+kmOls6E5xJT1yUOln7maqmTNLyW6ZTTqPFJKJut/3Kx" +
       "NW7pXJTUyf4VEdvnoRSdrOWMxCGeRmY5fcFj7+2Hdu87GOm8Z4nXPO7cBORS" +
       "Rb1IEkYEKaWrSuwp7fiunX2ztM7C3pxw2x8fbRxalcv3ECyrG+WLB/49O66R" +
       "hc4nJHZTntr9/vTQyuHNOXzamG1jyd7lfe1HnrlqPn+bl32gNQ7pMj7spgs1" +
       "p59KlGoCjWly+jlEQ3Jc2ecFjOHLzXFdbvdEy3NsLpE8tHcSZS2zHm97JrnU" +
       "1WAygZJCvD5hnNCsx+QawzE3UjJuRBEjSWf2VI428dzPl7GghR0leErTecHN" +
       "4koT3MrceXEStWE3j57wz/cZAQ0u5MzDpA5DkUCTcd1Ta5ExewzIqMY6DKyr" +
       "TESrXMjIsvCOVzWFCjwVIralt8KlTxcSlrrUXYrJIli3ZZiv/mGOnaj3Wfws" +
       "Hit+MJx3mFg63J3F05RJg5OoC9QrXOpaMPkibMD0raLaoyauh6QQ0TwGRFRi" +
       "3Qx4ek00ve5EZJs1TqIuYIMudR2YXEVJ+RBMmLTl26JizVhRgYvkehPP+typ" +
       "cBJ1gbvepW4DJiF4OUQqbPsDi4zesSJjEjwbTUQbcyfDSdQ5mvYx1IMujOD9" +
       "Fw8HCwpu7Gw8DIwBD0wcz5yvM8FcNwoPWTZ9TqIuMHWXuhgmMiUTkQKMl7CF" +
       "ErTVHOVsfChjxQceVx81QR3NnQ8nURfM17vU7cbkWkqqkY917cHVsOfCqwyJ" +
       "N0CLkOvGihAMoCdMVCdyJ8RJ1AX0zS5138FkL75SACHmWZmNiRvHkolXTDiv" +
       "5M6Ek6gL2jtd6u7CZL/JhF+JRhOvrBYTB8aSiTMmnDO5M+Ek6oL2sEvdfZj8" +
       "0GQCb/lmMvGjMQyfHq/Rp/GbExOOoi5oH3Kp+ykmx8zwmbyq3WG+f6XwMeoR" +
       "8n8RPj21Jqja3PlwEnXBfMKl7klMHjPDZ5KPbJuux8eKkGmAxrxH5nG4LOdG" +
       "iJOoC+gXXOp+g8kz5tkRO+C18fDs/4KHOOz0rZuneGVqasY9d+NuNv/AwcqS" +
       "2oO9r7IDk+T96fIgKRmMSVLqpZ6UfJGqCYMiY6/cuOLDri54XqOk4XPcigX4" +
       "yTwbslcN8TcomeYoTkkBpKnNT1FSk7U57ODwJ7XtHyipsrelpJD9prZ7F5iz" +
       "2lFSZGRSm7wHlkATzJ42rhykn68at6jixnH6jNSRYmdtNaMNcMqpWUPaaRP7" +
       "Hw2Jk6GY8X8awvyxg2s7rj37hXuMK52wO9m5E3spC5Ji43Yp6xRPl+Y69pbo" +
       "q2jNgnMTHhw/L3EON9Ew2JolMyxXJi0wK1T0rem2+456Y/La4+uHVjzx671F" +
       "L3mJZwPBrfWkDZn3zeJqTCOzNgQzb9r0cRq7iNm84M4dKxcPnnmDXewixs2c" +
       "mc7tw/zJwxtfvm3qoTovKWsjhaIcEeLsItzqHXK3wI9o/aRC1ANxMBF6ETkp" +
       "7RrPhAjb5YnyEOPFpLMiWYoXgimpz7zBlHmNulRStgvaKiUmR7CbiiAps0qM" +
       "kbEd0MVU1SZglZhDiekAJtfEcTTAH8PBdlVNXPAqX6yyOMBnewvimQ+fY1nM" +
       "ffYfQIZVFe00AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VkKh44hcm34Y6LZPtRp+IKPtmplV7LYg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "zb287F/e/88/8HMv/f7mftL/Aw7zh2BdQAAA");
}
