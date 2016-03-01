package org.apache.batik.parser;
public class LengthParser extends org.apache.batik.parser.AbstractParser {
    protected org.apache.batik.parser.LengthHandler lengthHandler;
    public LengthParser() { super();
                            lengthHandler = org.apache.batik.parser.DefaultLengthHandler.
                                              INSTANCE; }
    public void setLengthHandler(org.apache.batik.parser.LengthHandler handler) {
        lengthHandler =
          handler;
    }
    public org.apache.batik.parser.LengthHandler getLengthHandler() {
        return lengthHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { lengthHandler.startLength();
                              current = reader.read();
                              skipSpaces();
                              parseLength();
                              skipSpaces();
                              if (current != -1) { reportError(
                                                     "end.of.stream.expected",
                                                     new java.lang.Object[] { new java.lang.Integer(
                                                       current) });
                              }
                              lengthHandler.endLength(
                                              ); }
    protected void parseLength() throws org.apache.batik.parser.ParseException,
        java.io.IOException { int mant = 0;
                              int mantDig = 0;
                              boolean mantPos = true;
                              boolean mantRead = false;
                              int exp = 0;
                              int expDig = 0;
                              int expAdj = 0;
                              boolean expPos = true;
                              int unitState = 0;
                              switch (current) { case '-':
                                                     mantPos =
                                                       false;
                                                 case '+':
                                                     current =
                                                       reader.
                                                         read(
                                                           );
                              }
                              m1: switch (current) {
                                  default:
                                      reportUnexpectedCharacterError(
                                        current);
                                      return;
                                  case '.':
                                      break;
                                  case '0':
                                      mantRead =
                                        true;
                                      l: for (;
                                              ;
                                              ) {
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              case '1':
                                              case '2':
                                              case '3':
                                              case '4':
                                              case '5':
                                              case '6':
                                              case '7':
                                              case '8':
                                              case '9':
                                                  break l;
                                              default:
                                                  break m1;
                                              case '0':
                                          }
                                      }
                                  case '1':
                                  case '2':
                                  case '3':
                                  case '4':
                                  case '5':
                                  case '6':
                                  case '7':
                                  case '8':
                                  case '9':
                                      mantRead =
                                        true;
                                      l: for (;
                                              ;
                                              ) {
                                          if (mantDig <
                                                9) {
                                              mantDig++;
                                              mant =
                                                mant *
                                                  10 +
                                                  (current -
                                                     '0');
                                          }
                                          else {
                                              expAdj++;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              default:
                                                  break l;
                                              case '0':
                                              case '1':
                                              case '2':
                                              case '3':
                                              case '4':
                                              case '5':
                                              case '6':
                                              case '7':
                                              case '8':
                                              case '9':
                                          }
                                      }
                              }
                              if (current == '.') {
                                  current =
                                    reader.
                                      read(
                                        );
                                  m2: switch (current) {
                                      default:
                                      case 'e':
                                      case 'E':
                                          if (!mantRead) {
                                              reportUnexpectedCharacterError(
                                                current);
                                              return;
                                          }
                                          break;
                                      case '0':
                                          if (mantDig ==
                                                0) {
                                              l: for (;
                                                      ;
                                                      ) {
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  expAdj--;
                                                  switch (current) {
                                                      case '1':
                                                      case '2':
                                                      case '3':
                                                      case '4':
                                                      case '5':
                                                      case '6':
                                                      case '7':
                                                      case '8':
                                                      case '9':
                                                          break l;
                                                      default:
                                                          break m2;
                                                      case '0':
                                                  }
                                              }
                                          }
                                      case '1':
                                      case '2':
                                      case '3':
                                      case '4':
                                      case '5':
                                      case '6':
                                      case '7':
                                      case '8':
                                      case '9':
                                          l: for (;
                                                  ;
                                                  ) {
                                              if (mantDig <
                                                    9) {
                                                  mantDig++;
                                                  mant =
                                                    mant *
                                                      10 +
                                                      (current -
                                                         '0');
                                                  expAdj--;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  default:
                                                      break l;
                                                  case '0':
                                                  case '1':
                                                  case '2':
                                                  case '3':
                                                  case '4':
                                                  case '5':
                                                  case '6':
                                                  case '7':
                                                  case '8':
                                                  case '9':
                                              }
                                          }
                                  }
                              }
                              boolean le = false;
                              es: switch (current) {
                                  case 'e':
                                      le =
                                        true;
                                  case 'E':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                              return;
                                          case 'm':
                                              if (!le) {
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  return;
                                              }
                                              unitState =
                                                1;
                                              break es;
                                          case 'x':
                                              if (!le) {
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  return;
                                              }
                                              unitState =
                                                2;
                                              break es;
                                          case '-':
                                              expPos =
                                                false;
                                          case '+':
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  default:
                                                      reportUnexpectedCharacterError(
                                                        current);
                                                      return;
                                                  case '0':
                                                  case '1':
                                                  case '2':
                                                  case '3':
                                                  case '4':
                                                  case '5':
                                                  case '6':
                                                  case '7':
                                                  case '8':
                                                  case '9':
                                              }
                                          case '0':
                                          case '1':
                                          case '2':
                                          case '3':
                                          case '4':
                                          case '5':
                                          case '6':
                                          case '7':
                                          case '8':
                                          case '9':
                                      }
                                      en: switch (current) {
                                          case '0':
                                              l: for (;
                                                      ;
                                                      ) {
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  switch (current) {
                                                      case '1':
                                                      case '2':
                                                      case '3':
                                                      case '4':
                                                      case '5':
                                                      case '6':
                                                      case '7':
                                                      case '8':
                                                      case '9':
                                                          break l;
                                                      default:
                                                          break en;
                                                      case '0':
                                                  }
                                              }
                                          case '1':
                                          case '2':
                                          case '3':
                                          case '4':
                                          case '5':
                                          case '6':
                                          case '7':
                                          case '8':
                                          case '9':
                                              l: for (;
                                                      ;
                                                      ) {
                                                  if (expDig <
                                                        3) {
                                                      expDig++;
                                                      exp =
                                                        exp *
                                                          10 +
                                                          (current -
                                                             '0');
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  switch (current) {
                                                      default:
                                                          break l;
                                                      case '0':
                                                      case '1':
                                                      case '2':
                                                      case '3':
                                                      case '4':
                                                      case '5':
                                                      case '6':
                                                      case '7':
                                                      case '8':
                                                      case '9':
                                                  }
                                              }
                                      }
                                  default:
                              }
                              if (!expPos) {
                                  exp =
                                    -exp;
                              }
                              exp += expAdj;
                              if (!mantPos) {
                                  mant =
                                    -mant;
                              }
                              lengthHandler.
                                lengthValue(
                                  org.apache.batik.parser.NumberParser.
                                    buildFloat(
                                      mant,
                                      exp));
                              switch (unitState) {
                                  case 1:
                                      lengthHandler.
                                        em(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      return;
                                  case 2:
                                      lengthHandler.
                                        ex(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      return;
                              }
                              switch (current) {
                                  case 'e':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          case 'm':
                                              lengthHandler.
                                                em(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          case 'x':
                                              lengthHandler.
                                                ex(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                      }
                                      break;
                                  case 'p':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          case 'c':
                                              lengthHandler.
                                                pc(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          case 't':
                                              lengthHandler.
                                                pt(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          case 'x':
                                              lengthHandler.
                                                px(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                      }
                                      break;
                                  case 'i':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'n') {
                                          reportCharacterExpectedError(
                                            'n',
                                            current);
                                          break;
                                      }
                                      lengthHandler.
                                        in(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case 'c':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'm') {
                                          reportCharacterExpectedError(
                                            'm',
                                            current);
                                          break;
                                      }
                                      lengthHandler.
                                        cm(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case 'm':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'm') {
                                          reportCharacterExpectedError(
                                            'm',
                                            current);
                                          break;
                                      }
                                      lengthHandler.
                                        mm(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case '%':
                                      lengthHandler.
                                        percentage(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                              } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "n2H8B83yNaguGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae8zkVnX3ftnNZjeP3QRIQpp3NpTE8Hk8nhmPGwqx52XP" +
       "2B7Py55xC4tf4/GMx+8Ze0xTHlKbqFQpKoGmLeSfBpWi8GgFoiqiSlW1gECV" +
       "qFBfUgFVlUpLkcgfpVVpS68933t3k0agjuTr63vPPfecc8/53de88D3oTBhA" +
       "sOfaG9N2o10jiXbndnk32nhGuNtmy4IShIZes5UwHIKyy9qDn7nwgx9+YHZx" +
       "B7pehl6jOI4bKZHlOmHfCF17begsdOGwtGEbyzCCLrJzZa0gq8iyEdYKo8dY" +
       "6MYjTSPoErsvAgJEQIAISC4CQh5SgUY3G85qWctaKE4U+tAvQqdY6HpPy8SL" +
       "oAeOM/GUQFnusRFyDQCHG7JvESiVN04C6P4D3bc6X6Hwh2Dkmd94x8U/uA66" +
       "IEMXLGeQiaMBISLQiQzdtDSWqhGEpK4bugzd6hiGPjACS7GtNJdbhm4LLdNR" +
       "olVgHBgpK1x5RpD3eWi5m7RMt2ClRW5woN7UMmx9/+vM1FZMoOvth7puNWxm" +
       "5UDB8xYQLJgqmrHf5PTCcvQIuu9kiwMdL3UAAWh6dmlEM/egq9OOAgqg27Zj" +
       "ZyuOiQyiwHJMQHrGXYFeIuiuazLNbO0p2kIxjcsRdOdJOmFbBajO5YbImkTQ" +
       "606S5ZzAKN11YpSOjM/3+Lc8/S6HdnZymXVDszP5bwCN7j3RqG9MjcBwNGPb" +
       "8KZH2Q8rt3/xqR0IAsSvO0G8pfn8L7z0+JvuffHLW5qfugpNV50bWnRZe169" +
       "5et31x4hrsvEuMFzQysb/GOa5+4v7NU8lngg8m4/4JhV7u5Xvtj/88l7PmF8" +
       "dwc6z0DXa669WgI/ulVzl55lG0HLcIxAiQydgc4Zjl7L6xnoLMizlmNsS7vT" +
       "aWhEDHTazouud/NvYKIpYJGZ6CzIW87U3c97SjTL84kHQdBZ8EA3gedeaPvL" +
       "3xFkIDN3aSCKpjiW4yJC4Gb6ZwPq6AoSGSHI66DWcxEV+P/izegujoTuKgAO" +
       "ibiBiSjAK2bGtjKL0dAIENZwzGiWh16wm7mb9//VUZJpfDE+dQoMxt0nocAG" +
       "UUS7tm4El7VnVlTjpU9d/urOQWjs2QqAF+htd9vbbt7b7ra33aO9QadO5Z28" +
       "Nut1O9pgrBYg6gEe3vTI4O3tdz714HXAzbz4NDB0RopcG5ZrhzjB5GioAWeF" +
       "Xnw2fq/47sIOtHMcXzNJQdH5rLmQoeIB+l06GVdX43vhye/84NMffsI9jLBj" +
       "gL0X+Fe2zAL3wZM2DVzN0AEUHrJ/9H7lc5e/+MSlHeg0QAOAgJECPBaAy70n" +
       "+zgWwI/tg2Gmyxmg8NQNloqdVe0j2PloFrjxYUk+2Lfk+VuBjW/MPPoO8Lxx" +
       "z8Xzd1b7Gi9LX7t1jmzQTmiRg+3PDryP/s1f/DOWm3sfly8cmekGRvTYESzI" +
       "mF3Io/7WQx8YBoYB6P7+WeGDH/rekz+XOwCgeOhqHV7K0hrAADCEwMy/9GX/" +
       "b7/1zee/sXPoNBGYDFeqbWnJgZJZOXT+ZZQEvb3hUB6AJTYIs8xrLo2cpatb" +
       "U0tRbSPz0v+68DD6uX99+uLWD2xQsu9Gb3plBoflr6eg93z1Hf9+b87mlJbN" +
       "ZYc2OyTbAuRrDjmTQaBsMjmS9/7lPb/5JeWjAGoBvIVWauSIBeU2gPJBQ3L9" +
       "H83T3RN1aJbcFx51/uPxdWTNcVn7wDe+f7P4/T9+KZf2+KLl6FhzivfY1r2y" +
       "5P4EsL/jZKTTSjgDdKUX+Z+/aL/4Q8BRBhw1gFdhNwAgkxzzjD3qM2f/7k/+" +
       "9PZ3fv06aKcJnbddRW8qeZBB54B3G+EM4FPive3x7eDGN4DkYq4qdIXyW6e4" +
       "M/86DQR85Nr40szWHIcheud/dm31ff/wH1cYIUeWq0y1J9rLyAsfuav21u/m" +
       "7Q9DPGt9b3Il8IL12WHb4ieW/7bz4PV/tgOdlaGL2t7iT1TsVRY4MljwhPsr" +
       "QrBAPFZ/fPGynakfO4Cwu0/Cy5FuT4LLIeCDfEad5c+fwJNbMis/Cp6H9kLt" +
       "oZN4cgrKM2/LmzyQp5ey5Kf3w/ecF7gRkNLQ9yL4R+B3Cjz/kz0Zu6xgOxPf" +
       "VttbDtx/sB7wwGx0s53POjSYJkFdzuV1EfTwy89Re9RbvMvSYpY8vhWifE3v" +
       "+pksqSengORnirv4biH77lxdu+uy7BsBQoX5Ahq0mFqOYuc2rEcgWmzt0r5G" +
       "IhAcuNeluY3vK3Axj4xsIHe3q9ATstb/z7ICz7/lkBnrggXt+//xA1/7tYe+" +
       "BdyzDZ1ZZ64DvPJIj/wqW+P/8gsfuufGZ779/hxwwXAJH25cfDzjKr6cxlnS" +
       "zRJhX9W7MlUH+UqFVcKIyzHS0HNtXzYqhcBagqlkvbeARZ647VuLj3znk9vF" +
       "6ckQPEFsPPXMr/xo9+lndo5sCR66YlV+tM12W5ALffOehQPogZfrJW/R/KdP" +
       "P/GFjz/x5Faq244vcBtg//bJv/rvr+0+++2vXGUlddp2f4yBjW626VLIkPs/" +
       "Fp1MJ8lITCSEQ1YEzjLTZlvdhFp91YviyOnTeG/c6298nGTDyqaRyAzdHs5S" +
       "J8L0GY6XA4w2ML1IbYJNQ1zF0w3pSYVec2K3fVuvD1pUiA77zXnUQn1Vo1rF" +
       "pK1GY2KijpwOXZ74yhzDsPl0raQlpqDO2yts7WCO0F0bU03DcAej13DL95Mh" +
       "37cnDazVUAOaaU4W6dpL1KbXoO1BIktFqqAMCxsKFnAcSZYlpT4RB2qvzqVF" +
       "yu+HjbHUKQzEoNdX/JYpJbLXCBrFxoaJ5+qswy7b3Ukn8KUey4lKOgt8xl8U" +
       "qKbedhOzlcpzn0SHiuV7dG1cj8xapxmOS6rfrvJEC+1NWLjV8gd6qyts0rqQ" +
       "pHV3KXUL0lgjrAorFWulqqVwZd+f95ctto8EmzY+bxd0DS75EcdsdIFh1yO4" +
       "mJDqBNHEpUIHS3kiqAnORjSTplxH8ezuyg0kWWLdysDoTRSnSaOVxUKB0da4" +
       "0BS54bDeKyT9YWUTK1RPmmsdixqjeieaERzR3BRHLd0vcOxi6fKWVGRcS4SZ" +
       "3qSo6ROpAes4ZTooyis6V+oWrQSNalVNHwmtZFVhhxgx78Mu56PtNslO3GIS" +
       "TObxYOKybYY0y+3Q8uaSZC+WmtlBlXHdnFT7o7AThNEIxjGRbfGjJC2RTDPE" +
       "65TTaHJrXw466axd4DBuIPYwejoeYB0nHKei15zA9cDhtfFEalWIRanDW27M" +
       "qRxPqtMQXfrtpM+XHXxRxqgCLiyqDZIKxrLam3dLoaigs1ajHsULcRQwKJ1U" +
       "6+WIbpiBTlPUCFspRanB2aEqtQOytOmDAYjNsZhwpDiq83F/7kqz4oJJWNPu" +
       "Ks3UtFPE1or40K8wgrKg5BajW+mwNhDxcbXF0aPWsq4M+XqjnTBNU+36rKNR" +
       "qTOvDvqmxcixwVBaUVg7KWEakm6jpREv8GyB2Sz1Wavd9qXUl5fjZpwWp4Hf" +
       "URXBKNSKTVotC1pStrXxaikUq2QhTJI2y7YHLXpTWMnT6Yomu9O20aqPui7q" +
       "tUWMl6sdrjjQqoq1CLj6qDdv+3KDXkz4fpuj4Wkc+y4PD/kW06JQ3tugtRna" +
       "Qjeu7uvTkjps91oNLWnMdWocsX2jQq0mMlgDqJtao7Ki6sMphTJrmkZQvuHO" +
       "FsSg0p7Enm9V9FbJHwpEcdLcpLWGRLSkCT/tu7V1gpRWJXEhi/1BFZZLbaqP" +
       "9TfCZF3r1KnWkG1MqKbPJa6LDetkleCqrJZOZwgr951WCCs1d2xy1KThjmrN" +
       "DhUMRHk5GUiLCo/XV3AktO2SpIZ6LVZ7Y5NSombScvtrG8QypSaBK9cYFWdo" +
       "KRE13YvFGdcjejV8qKLzMeGXqoXZuKlaMieO+NlSWWxKwaDQIdl6DMKnEDhs" +
       "EYarhhvMjWmtQ8bMwmUK5a5So+3qqtFxOLQ2ssjEEjex25SZjZTGnE2UGitH" +
       "jiurFoa0kQW8Fupdip+Q3JwudknelktLY9K0xoso2sB8QWDL6cTDQwoPw/Fs" +
       "2B8nnB27m6iUodgCZaeTdRJW1zYhSM1RXSIbZCNOKDIxpaIe1/sETFBGvOza" +
       "g3rsO/qwy4pDWSR5qrWc02hnbDRg1FVxokr1002dEnv0tA3HTClFZJxP67xc" +
       "rPHEQpgJPXMpEHLV4AoVBIEtBNNoblxYdNh2GRYaerA2B8wyaBfrQ28dmHbE" +
       "9dz6ithM50kC47pj4kQKm5VaBZ2QREDFrVqJnFMpCRMrYcVHRLUCo8GEEBed" +
       "1dAamwGzxDfzdmI359RAkh18jZOD2ZDRfBlF+iGqkYGtDmqjjTfrTVnB9keB" +
       "42CI0lnHZCK2astKAeEnNUxo4BRRo2xsqlW6fas3a7OegvPjeodKcV7bSBHf" +
       "gIkZXDWna5aNlxvELJTqBbNTkUJPj+PGUKNcc1oMUA3ZzNZ47HCYBit0uA4Q" +
       "AS9VvV51YDgTJakWVGRtlhwJljCEL9exoCGlhRoCAEBnqla3ypBhoRfN26QO" +
       "w/ZQJEJxgOgUs2gvaiY1bvrz9pLSsJUm847IY3KIwMhSc2QjGNEmodh9lO0g" +
       "tMDNeiRmYuGQIeeYPU97gqV1pr4rObbvM1ZZXhDN8gj2x6JsYqyKr9EkiYmx" +
       "MHaWrFEexe562cWs0oo0BUPFotmaxUUcIdIFsRaaJSd0RDCFxp0qhxFJxVK6" +
       "64EzL/lc2m4F/dqoX2oQjbQMKzw+rwgavu6Z8zkelsblZERK8hQbwcZmGkcY" +
       "Oi1Z86478JvSRiGiSOKKSdxISEHSxJpdcacYliKRxzVrLFFf9FY1rjOWiYVp" +
       "sE65Lvjcci2pQE90UUYtGkt13ZphFNLwZ/TMIYu6nESRgVrxOm506xPDHekL" +
       "Z0E2mIKYUOxIFToNeNGj6/ZIKCcpuxDZTkXXl6hndlrROFzKDCts5NGsFHie" +
       "ArbCiAyWC0FdlymAEKnTHySrZjQJ7KEtT1W5R/BOmW84ommO1akxnsJrU18L" +
       "IxVBUL86bwt4MnLDsuuyXhIV3KVleHKY+NK4yYxatW514RiE2pXEFiqO6TKm" +
       "is14zjWWujzwyfWa6TfBxDEb8Yij6rYuqY46GCL9XrNOjUR4Cg+rQBppMIFb" +
       "sCQ2uvS439ZUAe0SWHmkDOMOCiConVZqZYS0y960JMJWr6/F1kqLmkqXl0my" +
       "ZzG1Ikfw4443YkZCnBoVcpMuAxQrGuOEHpV8ZTAbxYgiEmt3vVawcqlEGOVh" +
       "HHVrNWpithfGkkYWJc3pK0a7WOLoyRjTl1Whyw42wlTthOmGm26aJSHE4LK5" +
       "URuU1opcGpfX7GQ19SezWRkPFmIUSmNJQJwasjJgogLHRVrt8qHre/ioqS/4" +
       "ijRoLmrlbm+ZmAC3ut2OXm6X1/5MgtGp7AcqUe1vgqbU7erVmbokglZD4Lsc" +
       "RcPkqlzzBKS4BrNwvDZbCIku62Yz9NYso640PxabYIMwqeFcuco0tSYh1aO0" +
       "rEqePrY6LXJDkOzKLfQnVW6eeum0vaQltTt1555cLqdheYOPp+QU5mFZrfOE" +
       "VIxlVSWIalk0g2ULrkSCM0mr3RDu+043bCkByhXMJBLgJk2Sob7C4nbZ8vyq" +
       "iEZSkStExmIyHKbIoFDUlcp83VWFgr5GS+U05Xmt3myX0aEoYXoJDqTWQGc6" +
       "YqXZFmuNFoIZiuuWNvOQXtEBgGYM7RToKk1aM2aINngE4IpR3lh9T+v2GYD4" +
       "8ABvNkdUzQCTpJ4OBoSxLNUnnZnKxKM6vmATRitVQaNpg9BHElZHnHKpOJlp" +
       "htqoFuXByqGWpcqEDggEmbHmcGAFxgZrLvpmKlrGyltgm7HdFqVFc4SjNDDo" +
       "nOMH8ZosbiZFHAg4Zap44NILeU4iS8oocc0FkQaYN1e7ARuUN54w6ZTb86jD" +
       "9GYKq43tClFmYkOMp8okqrCJ0KbTFQrWBmmIjxHMTUUSX29GpjZ03IAb9G2m" +
       "PF1TntCqKljsz2YtXiTHVrM8tiNEdeHicmQNtTbspUWng89i2Q5pYuR4XY0o" +
       "U3LacRIjnS3QdYtfWilXDYxmbe53woqUGNVQY1oKs5qQi2qJXQCnXMw5Di9u" +
       "jHUPlgpk0JXDsbeGCQQWxH6tFkyTABtU/ETb+HZ1zcFhby4LWGcjb1h+SHWJ" +
       "brKYcHEVl3VpXfL7bmuOzJ0VzyANfcCZfrvnFOkqVcU2vGKuWj2SzLZd5qvb" +
       "+d6ab/IP7p3Ahjer6L+KHd+26oEsefjg4CX/XX/yruLoGefhwReU7WLvudZ1" +
       "Ur6Dff59zzyndz+G7uwdGKoRdC5yvTfbxtqwT5yhPXrt3TqX36YdHmR96X3/" +
       "ctfwrbN3vorj+ftOyHmS5e9xL3yl9Qbt13eg6w6Ota645zve6LHjh1nnAyNa" +
       "Bc7w2JHWPcePyPG9Zz9/lSPyq59n5V6wHfsT57GnDglaOcETL3Ng++4sSSLQ" +
       "jRGxVxxuvf2IyygRdHrtWvqhL21e6fTgaGd5wepA+ddnhY+A5617yr/1J6P8" +
       "Ud1+9WXqns6SJ4He5gm9c7Md6vjUj6FjfmZ5N3ioPR2pV6tj7RV1fPZE3U5e" +
       "t7N/sveGax1N5hdnjUQzvIMwAeTbGwHL3WW6B3V5N7+VJR+MoLO6m7fMPt97" +
       "aKVnflwr3Q+e0Z6VRj95K3386lbKPn87Sz6aU30iS34ngm7MbbT1ihOKPv9q" +
       "FAVhddPRa8rszuXOK/4Ssb3G1z713IUb7nhu9Nf5Td3BVfs5FrphurLto0fk" +
       "R/LXe4ExtXLhz20PzL389fsRdMc1Rj67xsozubif2dJ/FgTCSfoIOpO/j9J9" +
       "PoLOH9IBVtvMUZI/iqDrAEmW/YL3im5IqmEUKFq0NVBy6vhkcmD2217J7Efm" +
       "n4eOzRr5H1X2EX61/avKZe3Tz7X5d71U+dj2elGzlTTNuNzAQme3N50Hs8QD" +
       "1+S2z+t6+pEf3vKZcw/vz2i3bAU+dNojst139bu8xtKL8tu39A/v+Oxbfve5" +
       "b+an4P8L7+bAt0EkAAA=");
}
