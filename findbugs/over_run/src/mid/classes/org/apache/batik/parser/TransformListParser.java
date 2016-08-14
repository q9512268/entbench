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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Ot/241zpDwU1o6AosFjX/wutunV6ax4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
