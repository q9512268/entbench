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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVaeezkVn33/rLZbEKS3QRykJJ7oQ2Gnz3jObtAY894TnsO" +
       "e8YzNi2Lb3vG9zHjMU05pAIqEkVtCFSC/Sv0oIHQqggkBAqtWkAgJBCih1RC" +
       "q0qlpQjyR2lV2tJnz+/eI01VtSPNm2e/73vve37e9703z/wAujEMINhzrY1u" +
       "udGumkS7C6u8G208NdztUeWRGISq0rDEMJyAd5fkRz517sc/+YBxfgc6I0Av" +
       "Fx3HjcTIdJ2QUUPXWqkKBZ07fEtaqh1G0HlqIa5EJI5MC6HMMLpIQS870jWC" +
       "LlD7LCCABQSwgOQsIPghFeh0m+rEdiPrITpR6EO/Ap2ioDOenLEXQQ8fH8QT" +
       "A9HeG2aUSwBGOJs9c0CovHMSQA8dyL6V+QqBPwgjT37oLef/8AbonACdMx02" +
       "Y0cGTERgEgG61VZtSQ1CXFFURYDucFRVYdXAFC0zzfkWoDtDU3fEKA7UAyVl" +
       "L2NPDfI5DzV3q5zJFsRy5AYH4mmmain7TzdqlqgDWe8+lHUrYSt7DwS8xQSM" +
       "BZooq/tdTi9NR4mgB0/2OJDxQh8QgK432WpkuAdTnXZE8AK6c2s7S3R0hI0C" +
       "09EB6Y1uDGaJoPuuOWima0+Ul6KuXoqge0/SjbZNgOrmXBFZlwi66yRZPhKw" +
       "0n0nrHTEPj8YvOH9b3M6zk7Os6LKVsb/WdDpgROdGFVTA9WR1W3HW19LPSXe" +
       "/fn37kAQIL7rBPGW5jO//MLjr3vguS9vaX7mKjRDaaHK0SX5aen2b7yq8Vj9" +
       "hoyNs54bmpnxj0meu/9or+Vi4oHIu/tgxKxxd7/xOebP+Hd8XP3+DnRLFzoj" +
       "u1ZsAz+6Q3Ztz7TUoK06aiBGqtKFblYdpZG3d6GbQJ0yHXX7dqhpoRp1odNW" +
       "/uqMmz8DFWlgiExFN4G66Wjuft0TIyOvJx4EQefBF7oLfO+Htp/8N4JUxHBt" +
       "FRFl0TEdFxkFbiZ/ZlBHEZFIDUFdAa2ei0jA/5evL+xWkdCNA+CQiBvoiAi8" +
       "wlC3jVmMhmqADOIshvLQC3Yzd/P+ryZKMonPr0+dAsZ41UkosEAUdVxLUYNL" +
       "8pMxQb7wyUtf3TkIjT1dAfACs+1uZ9vNZ9vdzrZ7dDbo1Kl8kldks26tDWy1" +
       "BFEP8PDWx9hf6r31vY/cANzMW58Gis5IkWvDcuMQJ7o5GsrAWaHnPrx+J/d2" +
       "dAfaOY6vGafg1S1Z91GGigfod+FkXF1t3HPv+d6Pn33qCfcwwo4B9l7gX9kz" +
       "C9xHTuo0cGVVAVB4OPxrHxI/fenzT1zYgU4DNAAIGInAYwG4PHByjmMBfHEf" +
       "DDNZbgQCa25gi1bWtI9gt0RG4K4P3+TGvj2v3wF0/PPQXnHMxbPWl3tZ+Yqt" +
       "c2RGOyFFDrZvZL2P/sXX/wHL1b2Py+eOrHSsGl08ggXZYOfyqL/j0AcmgaoC" +
       "ur/+8Og3P/iD97w5dwBA8ejVJryQlQ2AAcCEQM2/+mX/L5//ztPf2jl0mggs" +
       "hrFkmXKyFfKn4HMKfP8z+2bCZS+2cXxnYw9MHjpAEy+b+TWHvAFcsUDIZR50" +
       "YerYrmJqpihZauax/37u1YVP/9P7z299wgJv9l3qdS8+wOH7VxLQO776ln95" +
       "IB/mlJyta4f6OyTbguXLD0fGg0DcZHwk7/zm/b/1JfGjAHYB1IVmquboBeX6" +
       "gHIDorku4LxETrQVs+LB8GggHI+1I/nHJfkD3/rRbdyPvvBCzu3xBOao3WnR" +
       "u7h1tax4KAHD33My6jtiaAC60nODXzxvPfcTMKIARpQBdoXDAABOcsxL9qhv" +
       "vOmvvvgnd7/1GzdAOy3oFssVlZaYBxx0M/B0NTQAViXeLzy+9eb12X0YT6Ar" +
       "hN86yL3502nA4GPXxppWln8chuu9/za0pHf97b9eoYQcZa6y7J7oLyDPfOS+" +
       "xpu+n/c/DPes9wPJlSAMcrXDvsWP2/+888iZP92BbhKg8/JeIsiJVpwFkQCS" +
       "n3A/OwTJ4rH244nMdtW+eABnrzoJNUemPQk0h+AP6hl1Vr/lBLa8ch9bfriH" +
       "LT88iS2noLzyeN7l4by8kBU/m9vkhgi6yQvMFYhLENRhnnNGgA/TEa18qsfA" +
       "k+euCygw3quvbbw8ULa5zOXffvTrb7/86N/kvnbWDIGIeKBfJbk60udHzzz/" +
       "/W/edv8nc2w+LYnhVtiTWemVSeexXDJn+NYD3WR+Cd0OvvqebvQtJG3+V1d8" +
       "KTAVXUVYrt0CgOOsshSbFkECm2SbEtWJiJxgP934/5s8uX74jQLTBuvHai9r" +
       "RZ648/nlR773iW1GejLWThCr733y1366+/4nd47sAx69IhU/2me7F8gNdlvu" +
       "Zhl3D19vlrxH6++ffeJzv/vEe7Zc3Xk8qyXBpu0T3/6Pr+1++LtfuUr6dEZx" +
       "wZqlHkDUqb0EKHu+mBX9/ViZXT1WdrLqz2VFaz80zliqo0dGTjnYkyP7YSLo" +
       "BuCrWbXnJQdT7mzHyZ/vivYWmgwowEbDdVRxnz3Qts3fTHf3YJMHGpMrmA+g" +
       "117bpHQeG4ew9qV3/eN9kzcZb30JiduDJ0xycsjfo5/5Svs18m/sQDccgNwV" +
       "O8DjnS4eh7ZbAhVsWZ3JMYC7f2uPXH9Z8eh11lbzOm3LrNABhMmZfrfmuA65" +
       "k0DbVCwrsazAtyqvXHOxu7i1+imQE91Y3K3uotmzfw2wPXAg8pgX3bOw5Av7" +
       "eRIHNvnAJhcWVnXfF84f+sl2Z3yCycf+20wCf7n9cDDKBZvs9/3dB772648+" +
       "DwKmB924ypYwYPYjM243F+9+5oP3v+zJ774vTwKB442eIs8/no2avjRR78tE" +
       "ZXM4o8QwovNcTVUOpD0RRKeB2f7n0ka3P9cphV18/0MVeLGYTJNkps6VVUCk" +
       "AkwSccdYdyR3RIlNGW1GIu+Vhk1eGKFjwmfFXizFGOdU11GhSiHaMGKUCbsk" +
       "orFmE1MT9yb8gItEZkB2SVdS2KU0NqKiKXZ7ui6iTFNEG2Nk6bH6uou0xZkt" +
       "OZ5drmKo7jXcoKqmyrCo2U7TcWwYlm1xMJ92bcMtCoNpr9ew2ikXEp3IrdXr" +
       "ul3VBSoM27Qgqs3QHa0mQ8RAJ9om0NpTkcEnTHnWbFQYuYN3mP5sWeNx21x6" +
       "hEFOSSastxuaZzZLSrugayRvLvv60J0v+hU02zUwlMd5Q77hr+f1pum3xgvG" +
       "45me3JML+LSdlsKN2KZoOzK7LkoIHUvs+9J82pmM6IE40tCpYqN+rab7DRFm" +
       "GZ3hTZEptwyZXhoSs5SpATdXhyYb9Lpu2qO83ioabJJhUHI4KxY7FRv2RkFz" +
       "jczppkKTDNPqzTa9xABxOup2J6HARFpUtPh0khgSOuHGU6ZM19Y6W0jsokVz" +
       "uIhX5kXVQr2QKvX7RbEyn82pribQ5LS4BPKjSQr3erHRKHq+vagvabo8ZkS4" +
       "ENL9pBgFA3FY3xC9SWVDdyRdXSPTUSsmfV0ZR+IEnWIDku728aXeWvfJkhO2" +
       "KyHbEBJZb3J9o7nW/ITSzc1gprRjujI2GBa3xzRRbGAFT7QMZ2gVtDHLGJLk" +
       "eqTFYZanmC5FwZbILPnxYlaMG7Elwmu9WukQnNDle6ZK6kS14DXNVOizQnOx" +
       "WWDNWbHjag26OUYXY3td8Re+pTMlfOaXkgZDzKZuQUf0aUnAI3LcagxdWsSW" +
       "tidVZ0SnndLdcacxc+nNap5QHu4LpYo+Xpt+s+QnNkv00XWPqYUThw3hzUqJ" +
       "pxNzRo9tIiXdcBPNa2yz7fabLb85LSw6IY6U1rTbqk3VlmFomEGQjZLm43RP" +
       "KycTNaY4ZKqMehy1oOsGmqx4g55tRAKEVKdc7aZFmKv5ri1ORdE1ULVZ5cJy" +
       "cSYgHFqWGL29FB3C8oT6JB5Rjt0s1Ks13IQ7JM/NWd30g75AGClngp3pssiG" +
       "WCnkAjwke9VoPOREtipukEZ53pALCUt3EMlGXcHusAbv2XXTX4Sjqu4S3GDc" +
       "KszxsMIuuVEkkDV9rdbKbqNPinC/V4HpMonQA7gh9xN+Mhvwpa7b7/XNZOWh" +
       "lljRCI9JmgtJH47tum14FD4qYVShxM4ZN+VadGdMC1ON1W284bdpFV6qCePS" +
       "irBAFxgZeSXVmzcnI7PeaoPMrS8ODRJnQLDhfWFgtBzRl5ORr6s0IcdgqxzK" +
       "nUmnLaBiwYTxVbchce2Ykn2Ukeyi35Klhjvjl1bsckY5MgecXRxxeFyepzBc" +
       "11bz1khOOviECCNiqUzQuSWI4kLxxqqErrWWW9Tmk15SDtRet92dEWOmD5Ar" +
       "kdFhQBGTDVcR/e4SJdqw1G+k/CZBOkvdSzC3THcYR40wjJbC2qBbdSSctLvL" +
       "YbUyXFb7htucVYP5aDCrIlV9CQ9HkqUpTbVKtTBR3CReTxXpcntA6SVdaxHS" +
       "sFVeCxo2KIlMyOHMsokzXXyA19NZazAxSqVa0S6tvFno6WvW4ibrcFOVur2o" +
       "26UrsO/CJcEIBL5YZ5JiCy8ReGIPtAqnDZGJXUkQNV0kHo1VCr3CHOPrlM0z" +
       "y8qMwRbLgjufz6LCguzEwVqr1hf1jaDJbcIsjkXatsLerFiV8ZgksHWJUjRs" +
       "ThloFHewtVmVG+xYCFGSa6yFyBOkkTsYNagq4nFIvzkat4SSWQF5pi0swprH" +
       "dQa1QirpVGtZpNfTTh8LWnhDs3p90uim3nxlYHVlbaVYEY1KYmdW4rGB5c6w" +
       "ud6oI8WoX283vQTmAfhODJIVaQ5D4llfNny1RFeQsTIjg4gdprV6SlerNbOD" +
       "9xpE0gXQ0aFVgky0DT5bN2OeKvbD1QQbK4kSzXR0lawwadMaCc0uWEawdkFc" +
       "YRxZV/lIq7IbAjQuW0FpszCnY8Kao8KsBA+8YhTr6FzwCXvDt01WmYQkb4RO" +
       "PBw4aZ0JyuUONx6uCZ8RiaFbkDurcFVy20zPKrNwXYjn7VRUqSllNK2x4aP9" +
       "zbiIS01v2kQDMmm2WAGVKhVnECYzW3CW47RfM4gC7KdyidtwBV2n1oNFOsVg" +
       "uNrXFlJKT+XIGChVI1EMHgujQMIUXptrKaFu6gOEMqcCXC3D0hJgfDWZVwsb" +
       "PlKrTlFo6UGLX/iuSXdKurKaJKJawOZFaTGf+IZbCDfFybLdGMgKXJsuKnOY" +
       "tDdDpFkZsTgHwNqZx+qSLFamJVUfBMOwG2l+l6sjWqmyYGRLGpeVVDdYe6pE" +
       "S3ohY7g04nouzK25sVKJB7FbiwodVGZaaDfkleHAHsditY7bpWmYLdPWzK8Q" +
       "Q9kIm4kZ9vqiThTZbqgLzHrVZG2aoCYEOUXVOUbwJNEsTOtC2NOrTSUl43Kr" +
       "ItRgajBpo+FKJhto2RiPuO5iJS1W9S4yXVm1QbEuKEGjp9ZSWIdrtdWwvpYF" +
       "vqwxHSqd1b21E1eqYyPdCC4tCGWMrQRNZ12VJrOibAuDkYVQfMe1pzrfk0gD" +
       "QPGiOhMaZFxgK9iIGWOWK63KUaXrTGGyLs6jWoKtukO+Mt1sxo21HisbB+/W" +
       "+EpJXc0n5flgTvObDdWq0/iMrmKdMryZoCo8XsMUm3JRwZ7RWqPpoZUp6g1Q" +
       "prEBULgRi0i/jFZ7lTWjpfWoZdEGWIkdGZdDtVCwUh5BwgwzDcLQl91SinY6" +
       "KzeMVzI+KTdr8kBlFam6WcRkZ4SXKknVLRsSuyYZbNWpI7C/UbEqLMwKmj3q" +
       "+yu9N6qisIbU6HmwlirKpkCzAKoDC3fE7ghwqqCjsT9PuCU76yCBsxgWkeJY" +
       "b1SnPdtjWxGN9eYoWmh7PMvX4JpbH0ruVBABSps0aTCCy8XU2l42kQAeJ9HS" +
       "8KfFCtuIRh1Gmnj8nF4Z9rw3I5bmGk03WhhzdVLWfdzUGabWGTWCpkZUi6ty" +
       "ixfGgiU2F7ivuzMJrxOdtDZn28E0nmzw1E4XorJp2CIsdRVj0EVXownDKNhA" +
       "4e05qrsUXSizDtaCmY5YaBL96goe2ViEybQkVSjWSTh8hjX7XtUfOYGHOYG+" +
       "StslVR1I/TjorJvFINUrg0ZSm0xbk5psO7Y845INkTqkHqaLWaUhFwttXdoo" +
       "UbQkY9K2xsMx3zc7MMXPKmVv4/ZjgadnrNwsmhVrwmidcSuOQ9ObNCiZtMYO" +
       "zi38qdgutwUB8fFoZnq1pGE1OLscRCV+nCTqQCVqs8mKRKOwugzHfZzjJKlN" +
       "M9VmaPPBSm91Os220CexjURNhqIOz5qV0jw0uyQ74eSe1zDlJjGmuPHcpogG" +
       "q5fa8JqqKBYM42mpWvTTrlkw0tKwHsqR05sH9VGn0EzaNlxjObrdVlC8lbK1" +
       "ZICZfI/G/WkvEKaW1ZWn7U2wJrqhHa2IoI4zhBctykXgbBrcMymTtDmsS1QK" +
       "xIwPS50R1ZUYrhbDbKmyrnNmI07BmsXOidLamyx7HbqkaYNmARuMMCl1aJ3h" +
       "VLterLRsm1bDma3Ua2aotf1abC98pEpX6lR1sOqxps5OK3yoolGUglwWxVp9" +
       "3ozdcneGJU5Z7bYNv2Mu2FpqVXmSR1KYQyYcMZgSJT2ZV+qyCRNGYV22uy6i" +
       "khzcWC+HzHCx2NTdQb027ZuYWdLTrjGqhKXUh5GlRteZwcRkUSSUovqwx4oI" +
       "xius1EkKaVUIlBQjqmiBnDG65FYHtB76BFYrlSozY4hFThizfaVWqY80X6gF" +
       "y0K0ckIpKKI0WSIoJZQTat5geGpcqa+X86ZZq9YUX900l661EHWynUZ9Jt5M" +
       "imsh5Rk5Ztuqj4oNgcbAOuX6WBSVytEQGzvzkO8mJU4hpiLN6vEIIROpMvUW" +
       "6IyJOcXHWb5d1HhZ66uB7IpUt+quvG6wtIhBwtpCrzAaN1YT1cGctmybXK0s" +
       "qD7TmTqtIi5YNbBpW/j9gTBHI8cbtGYE0S77dqDO1YnUsnmi0jbwUnuIzAbD" +
       "2PYF4IF0WFioWL9WWs8QXUEseFVcEyHYsL7xjdlW9t0vbYt9R36acHDpDnbW" +
       "WcPqJeyik+udf0XQWVECS64oR8nBUWv+OXedK64j1wBQdtR3/7Uu2vNjvqff" +
       "9eRlZfixws7euQwbQTdHrvd6S12p1pGhtidpygEbr8iGfwB8H9lj45GTp+GH" +
       "WrhCvFNgEi9wI1WOVGWrzOscFX3kRNuJo73XXOuuNr+lJRNZ9Q5O3g5OAk13" +
       "tzs8aMunuZwVT0XQLXn3luWK0dXOSW7UDlpy637oxc5IjopzQon37ivu23tK" +
       "/PZLUOLhGSl5VRXuHFK9OS9yqmevo+g/yIqPAw1IsWkpuQayN08fCvv7L0XY" +
       "JIJuPXpfnl343XvFf3O2/yeRP3n53Nl7Lk//fHstsf+fj5sp6KwWW9bR+5kj" +
       "9TNeoGpmzvvN29saL//5bATdcw2vyO5T80rO7me29J+LoPMn6YGl89+jdF8A" +
       "ujmkA0NtK0dJvhhBNwCSrPrH3ou6KL4X3lsFJaeOx+6B2u98MbUfCfdHjx1S" +
       "5/+Y2j9Qjrf/mbokP3u5N3jbC5WPbe+5ZUtM02yUsxR00/bK/eBQ+uFrjrY/" +
       "1pnOYz+5/VM3v3ofQG7fMnzouEd4e/DqF8mk7UX51W/62Xv+6A2/c/k7+dHn" +
       "fwHdRaDPyiYAAA==");
}
