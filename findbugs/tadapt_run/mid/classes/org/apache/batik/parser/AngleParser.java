package org.apache.batik.parser;
public class AngleParser extends org.apache.batik.parser.NumberParser {
    protected org.apache.batik.parser.AngleHandler angleHandler = org.apache.batik.parser.DefaultAngleHandler.
                                                                    INSTANCE;
    public void setAngleHandler(org.apache.batik.parser.AngleHandler handler) {
        angleHandler =
          handler;
    }
    public org.apache.batik.parser.AngleHandler getAngleHandler() {
        return angleHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { angleHandler.startAngle();
                              current = reader.read();
                              skipSpaces();
                              try { float f = parseFloat();
                                    angleHandler.angleValue(f);
                                    s: if (current != -1) { switch (current) {
                                                                case 13:
                                                                case 10:
                                                                case 32:
                                                                case 9:
                                                                    break s;
                                                            }
                                                            switch (current) {
                                                                case 'd':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'e') {
                                                                        reportCharacterExpectedError(
                                                                          'e',
                                                                          current);
                                                                        break;
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
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      deg(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                case 'g':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'r') {
                                                                        reportCharacterExpectedError(
                                                                          'r',
                                                                          current);
                                                                        break;
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
                                                                        break;
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
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      grad(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                case 'r':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'a') {
                                                                        reportCharacterExpectedError(
                                                                          'a',
                                                                          current);
                                                                        break;
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
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      rad(
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
                                    }
                                    skipSpaces(
                                      );
                                    if (current !=
                                          -1) {
                                        reportError(
                                          "end.of.stream.expected",
                                          new java.lang.Object[] { new java.lang.Integer(
                                            current) });
                                    } }
                              catch (java.lang.NumberFormatException e) {
                                  reportUnexpectedCharacterError(
                                    current);
                              }
                              angleHandler.
                                endAngle(
                                  ); }
    public AngleParser() { super(); }
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
       "7YX5hVD6B/f+3ls/+9x38lzu/wA3qYt+3SIAAA==");
}
