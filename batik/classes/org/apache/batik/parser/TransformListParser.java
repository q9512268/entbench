package org.apache.batik.parser;
public class TransformListParser extends org.apache.batik.parser.NumberParser {
    protected org.apache.batik.parser.TransformListHandler transformListHandler;
    public TransformListParser() { super();
                                   transformListHandler = org.apache.batik.parser.DefaultTransformListHandler.
                                                            INSTANCE;
    }
    public void setTransformListHandler(org.apache.batik.parser.TransformListHandler handler) {
        transformListHandler =
          handler;
    }
    public org.apache.batik.parser.TransformListHandler getTransformListHandler() {
        return transformListHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { transformListHandler.
                                startTransformList(
                                  );
                              loop: for (; ; ) { try {
                                                     current =
                                                       reader.
                                                         read(
                                                           );
                                                     switch (current) {
                                                         case 13:
                                                         case 10:
                                                         case 32:
                                                         case 9:
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
                                                         case -1:
                                                             break loop;
                                                         default:
                                                             reportUnexpectedCharacterError(
                                                               current);
                                                             skipTransform(
                                                               );
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
                              skipSpaces(
                                );
                              if (current !=
                                    -1) {
                                  reportError(
                                    "end.of.stream.expected",
                                    new java.lang.Object[] { new java.lang.Integer(
                                      current) });
                              }
                              transformListHandler.
                                endTransformList(
                                  ); }
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
                              transformListHandler.
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
                                      transformListHandler.
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
                              transformListHandler.
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
                                      transformListHandler.
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
                              transformListHandler.
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
                                      transformListHandler.
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
                              transformListHandler.
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
                                  transformListHandler.
                                    skewX(
                                      sk);
                              }
                              else {
                                  transformListHandler.
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZC5AURxnu3eOe3Du85HHA3YXII7tBgyR1iDkuRzjcgyuO" +
       "UHokLH2zvXfDzc4MM713C4gS1AJjhUIEQjShokVMTCUhpVJq5VFooiEVo5Wn" +
       "Bg2xjFXBRDSUZbREjf/fPbMzO/uAq/K2antnu///7/6//h/99zxygZTbFmlh" +
       "Oo/wHSazI90676OWzRJdGrXtjdAXV+4uo3/bcn7djWFSMUDqh6ndq1CbrVaZ" +
       "lrAHyBxVtznVFWavYyyBHH0Ws5k1Srlq6ANkqmr3pExNVVTeayQYEmyiVow0" +
       "Uc4tdTDNWY8jgJM5MVhJVKwk2hkc7oiRWsUwd3jkM3zkXb4RpEx5c9mcNMa2" +
       "0VEaTXNVi8ZUm3dkLLLYNLQdQ5rBIyzDI9u0ZQ4Ea2PL8iBofbzhg0sHhxsF" +
       "BFdRXTe4UM/ewGxDG2WJGGnwers1lrK3k8+TshiZ7CPmpD3mThqFSaMwqaut" +
       "RwWrr2N6OtVlCHW4K6nCVHBBnMzPFWJSi6YcMX1izSChiju6C2bQdl5WW6ll" +
       "nopHFkcP372l8XtlpGGANKh6Py5HgUVwmGQAAGWpQWbZnYkESwyQJh02u59Z" +
       "KtXUnc5ON9vqkE55GrbfhQU70yazxJweVrCPoJuVVrhhZdVLCoNy/pUnNToE" +
       "uk7zdJUarsZ+ULBGhYVZSQp257BMGlH1BCdzgxxZHds/DQTAWplifNjITjVJ" +
       "p9BBmqWJaFQfivaD6elDQFpugAFanMwsKhSxNqkyQodYHC0yQNcnh4CqWgCB" +
       "LJxMDZIJSbBLMwO75NufC+tWHNilr9HDJARrTjBFw/VPBqaWANMGlmQWAz+Q" +
       "jLWLYkfptKf2hwkB4qkBYknzw89dvGlJy+kzkmZWAZr1g9uYwuPKicH6l2Z3" +
       "LbyxDJdRZRq2ipufo7nwsj5npCNjQoSZlpWIgxF38PSGn392z8PsvTCp6SEV" +
       "iqGlU2BHTYqRMlWNWbcwnVmUs0QPqWZ6okuM95BKeI6pOpO965NJm/EeMkkT" +
       "XRWG+A8QJUEEQlQDz6qeNNxnk/Jh8ZwxCSGV8CW18G0h8iN+OdkSHTZSLEoV" +
       "qqu6Ee2zDNTfjkLEGQRsh6ODYPUjUdtIW2CCUcMailKwg2HmDJjoX1Z0o0V1" +
       "O2lYKYw6wuesCNqZOeEzZFDHq8ZCIYB/dtD5NfCbNYaWYFZcOZxe1X3xsfgL" +
       "0rDQGRx0OFkMk0bkpBExaUROGikwKQmFxFxTcHK5zbBJI+DuQFK7sP/2tVv3" +
       "t5aBfZljkwBhJG3NyTtdXkxwA3lcOdlct3P+uaXPhMmkGGmmCk9TDdNIpzUE" +
       "AUoZcXy4dhAykpcY5vkSA2Y0y1BYAuJSsQThSKkyRpmF/ZxM8Ulw0xY6aLR4" +
       "0ii4fnL62Ngdm75wXZiEc3MBTlkOYQzZ+zCCZyN1ezAGFJLbsO/8ByeP7ja8" +
       "aJCTXNycmMeJOrQGrSEIT1xZNI+eij+1u13AXg3RmlPwLgiELcE5coJNhxu4" +
       "UZcqUBhNhGo45GJcw4ctY8zrEWbaJJ6ngFlMdl3wo447il8cnWZiO12aNdpZ" +
       "QAuRGD7Zb973m1/+6eMCbjeHNPiSfz/jHb64hcKaRYRq8sx2o8UY0L15rO/r" +
       "Ry7s2yxsFijaCk3Yjm0XxCvYQoD5y2e2v/HWuROvhj0755C404Nw/slklcR+" +
       "UlNCSZhtgbceiHsaRAa0mvZbdbBPNanSQY2hY/274eqlp/58oFHagQY9rhkt" +
       "ubwAr/8jq8ieF7b8o0WICSmYdz3MPDIZzK/yJHdaFt2B68jc8fKce56j90Fa" +
       "gFBsqzuZiK5EYEDEpi0T+l8n2usDY8uxudr2G3+uf/nOR3Hl4Kvv1216/+mL" +
       "YrW5Byz/XvdSs0OaFzYLMiB+ejA4raH2MNBdf3rdbY3a6UsgcQAkKhBw7fUW" +
       "hMdMjmU41OWVZ3/yzLStL5WR8GpSoxk0sZoKJyPVYN3MHobImjE/dZPc3LEq" +
       "aBqFqiRP+bwOBHhu4a3rTplcgL3zR9N/sOLB4+eElZlSxqxsVJ2dE1XFMd1z" +
       "7IdfWf7ag187OiYT/cLi0SzAN+Nf67XBvX/4Zx7kIo4VOIQE+Aeij9w7s2vl" +
       "e4LfCyjI3Z7JT1AQlD3ejz2c+nu4teJnYVI5QBoV51i8iWppdNMBOAra7lkZ" +
       "js4547nHOnmG6cgGzNnBYOabNhjKvMQIz0iNz3WB6FWPW3gDfNscx24LRq8Q" +
       "EQ89guUa0S7C5lo3WFSblsFhlSwRiBd1JcRCvuL+jLyG6gk4PwkBMzhZckVp" +
       "3GGS8RXbG7BZK5fRUcia5dA12CzOLlZ8KoIHKn9w88yVoE/OKXbmFef1E3sP" +
       "H0+sf2CpNNjm3HNkN5RJj77+n19Ejv3++QLHl2pumNdqbJRpvjmrccocF+kV" +
       "5YBnb2/WH3r7x+1Dq8Zz5sC+lsucKvD/XFBiUXGvCy7lub3vzty4cnjrOI4P" +
       "cwNwBkV+t/eR529ZoBwKi9pHOkJezZTL1JFr/jUWgyJP35jjBG25Kbwbvssd" +
       "A1heOIUXsJ1sYizGGkghIek1+LdPSGUlcswQNls5CGG8kOHbJeNhn6Wm4Mgw" +
       "6hRV0d3Nb43ce/5RaZbB4BcgZvsP3/lh5MBhaaKyTG3LqxT9PLJUFctulOh8" +
       "CJ8QfP+LX9QJO/AXQlyXUy/NyxZMmBUsMr/UssQUq985ufuJh3bvCzsYfYaT" +
       "SaOGmvD8n5bw/yvIZtjRaYr+27LbPM/d2pXONq8cv4UUYy1hALtKjO3GZhSM" +
       "Y6iwcQgT81AZmwBURPKY7fiO60OlUInlJ4hirCU03x8YC4uxsJs7FhTLHaLq" +
       "684ozMwGJCCXZ0PViPSsz46Jae7E5oucVCYMwYl/NQ/QL00UoGhrexxU9owf" +
       "0GKsJQC9pzCg+Per2NwlqL6JzWFOJgs4eym31EwAkyMTicmzjmLPjh+TYqwl" +
       "MPnOFWHyEDbfcjHZgLkuaCffnihM4EgVqpcy5e+4MCnKWgKT718RJqeweYyT" +
       "eoGJCE1aPiwnJwqWuaBT0tEtOX5YirGWgOX0FcHyU2ye4KRGwNKvUC0IyZMT" +
       "BQmcZ0P3O3rdP35IirGWgOTFK4LkV9icwQpCQDLCxgKIPD9RiLSCOmcdtc6O" +
       "H5FirCUQOVv8ICjB+B02r3FSZ4+oZjahBwB5/f8BSAaSXoHrUKzjZ+S9c5Hv" +
       "CZTHjjdUTT9+669FhZG9y6+FWiGZ1jR/pel7rjAtlpRJolbWnab4+SOcWook" +
       "abx7Eg9i8W9L+nc4aQzSc1Iufv1074J3eXQgSj74SS5wUgYk+PgX0z0CtBc7" +
       "MaxL4xskCU8mlFsGZvdk6uX2xFc5tuUc18V7MLfoScs3YXHl5PG163Zd/MQD" +
       "8kZQ0ejOnShlcoxUysvJbOE0v6g0V1bFmoWX6h+vvto9LTfJBXsWPstnop1g" +
       "jyZawczAdZndnr01e+PEiqdf3F/xMhQGm0mIgiVtzr+uyJhpqFg3x7ya1fce" +
       "VdzjdSz8xo6VS5J//a24ECJ510BB+rjy6oO3v3JoxomWMJncQ8qhEGAZcY9y" +
       "8w59A1NGrQFSp9rdGVgiSFGp1kOq0rq6Pc16EjFSjwZL8Q2ZwMWBsy7bi/fJ" +
       "nLTmFzj5t/A1mjHGrFVGWk+gmDoocr0et4DOqT3Tphlg8HqyWzklX/e4cvNX" +
       "Gp482Fy2GpwuRx2/+Eo7PZita/3v7ESHrMewSWVwn8H647Fe03RLscq7TOEF" +
       "ISJpsJ+T0CLZGwhUIXH1HQqLR2zK/wdh/ufMjh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
