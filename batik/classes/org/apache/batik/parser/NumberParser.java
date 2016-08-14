package org.apache.batik.parser;
public abstract class NumberParser extends org.apache.batik.parser.AbstractParser {
    protected float parseFloat() throws org.apache.batik.parser.ParseException,
        java.io.IOException { int mant = 0;
                              int mantDig = 0;
                              boolean mantPos = true;
                              boolean mantRead = false;
                              int exp = 0;
                              int expDig = 0;
                              int expAdj = 0;
                              boolean expPos = true;
                              switch (current) { case '-': mantPos = false;
                                                 case '+':
                                                     current =
                                                       reader.
                                                         read(
                                                           ); }
                              m1: switch (current) { default: reportUnexpectedCharacterError(
                                                                current);
                                                              return 0.0F;
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
                                                                 case '.':
                                                                 case 'e':
                                                                 case 'E':
                                                                     break m1;
                                                                 default:
                                                                     return 0.0F;
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
                              if (current == '.') { current =
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
                                                                return 0.0F;
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
                                                                            if (!mantRead) {
                                                                                return 0.0F;
                                                                            }
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
                              switch (current) {
                                  case 'e':
                                  case 'E':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                              return 0.0F;
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
                                                      return 0.0F;
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
                              return buildFloat(
                                       mant,
                                       exp);
    }
    public static float buildFloat(int mant,
                                   int exp) {
        if (exp <
              -125 ||
              mant ==
              0) {
            return 0.0F;
        }
        if (exp >=
              128) {
            return mant >
              0
              ? java.lang.Float.
                  POSITIVE_INFINITY
              : java.lang.Float.
                  NEGATIVE_INFINITY;
        }
        if (exp ==
              0) {
            return mant;
        }
        if (mant >=
              1 <<
              26) {
            mant++;
        }
        return (float)
                 (exp >
                    0
                    ? mant *
                    pow10[exp]
                    : mant /
                    pow10[-exp]);
    }
    private static final double[] pow10 =
      new double[128];
    static { for (int i = 0; i < pow10.length;
                  i++) { pow10[i] = java.lang.Math.
                                      pow(
                                        10,
                                        i);
             } }
    public NumberParser() { super(); }
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
       "gyCdsJ6rLIEee0pkdRBD6LDByh9ae3WDLmoCSDHrQGZEnDamhT8VZrwiqPW1" +
       "vWLilGP8PtZerC2+reS2pkUYRqvTbDOyegEONgBE10xrBoL0Rc+sSznfXBi4" +
       "SSyH89YEU801OuoKeyHzxCk1mvKLACzAIips2UGnYxpDMhc7TdQe8XK8xXaO" +
       "IImKjHIuPFOT/VgMbXkIIz2Wdfe9rEVIAqVHSZ/QgjBgSZTE80VdVpYro9+z" +
       "kbmPO9OugIw7mD2kvc5IV/DhWpR67Wyzr8Ew5lpbdNRv1yVxhcw6/WLcayRy" +
       "T5/Qsuk7znKR9aiIyjIvRnlV8CI2ZhPM2O/m2ibke43JvLfgV0qj8HAm6OFy" +
       "KxqqOcx1E16HrTm+zVo7dJA1EXWJcKsN54x5GeaIRLe6EtPejIs808TVSpgF" +
       "qZ7S3A6V4L3K8ROwbuYpZ2+bqjhrisDyUJCYZT294KQpvUsW4mLhBzt4lxbG" +
       "hAw0aququy0RtQezXtPW65qspsm2OSVbbLZZFEGr2VXgfb8pNvfKEHfQbboz" +
       "1W6Uchy53RkFm1Fu2OtsdUTadfDhUjGxsbR2snmng+w4dU1nURt2ZLc27gGr" +
       "lsxMj/J64qm1nqHMjZCkhJrhZFTBZZSBtPsh0h23G5jMdxk7oFRdUYwxo4sj" +
       "LS2E0aAVOBGjcTXU1lByZ4WiNjXNsaut4Qa5XkWUPlf9JFSNHTYAOVGkdeSO" +
       "C1byLd2fz7dbSQqG9lrYdermft+rR8PGWPW22rI9mLb3AR0OLLg+XKOSJ0xY" +
       "p7lfItJIboZxo77d9HqB3HfsJVjUKFfLKZ3kdLDr/Y5yO/wjb26b/mR1InF6" +
       "AQ9252VH9iZ24sWDztAS6Lq2jJNI05Pi9Ei2+t14wFXYuesCqDwufO5+l+7V" +
       "UeGnP/Tqa4bw042j47MdKYEeTYLwW10zM91zqA6nccYpGW8r0T8PnheOyXjh" +
       "8qn5mRTuYu8KmCSMgsTUE9M4CPMBx02futR36Xjwffe7061uc4lCN8PT07vT" +
       "00Q7uE0Lp33VNK+VxScS6LFqOOkGWnKvs5aHV6c9lXZ/8uuds5xn55IQnzkR" +
       "3OePhfj5NyHEs3NW4p4iPDqD+u6qqKA+9wBB/0JZfAZIYJnarlFJoGz59Bmz" +
       "/+bNMFsk0OPn79XLi8Fn7vpO5/Btif7Z125cf/q12R8dri9Ovv94lIWur1LX" +
       "PX+Pc65+LYzMlV3R/ujhVies/n4lgZ6+j1WU965VpSL3lw/wv5pANy/DA01X" +
       "/+fhfh3I5gwOoDpUzoP8RgI9BEDK6r8Lv66JosfufRBQceWi756K/amvJ/Zz" +
       "7v7ihYPu6uupk0Pp9PD91Mv6515j+O//avenD/fhuqvt9yWW6yz0yOFq/vRg" +
       "+z33xXaC6xr10tee+PlH33sSQJ44EHxmuOdoe9e9L5wJL0yqK+L9rzz9i9/+" +
       "M6/9eXV8+g9eFwf+1iYAAA==");
}
