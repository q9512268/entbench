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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1+6d+Yf9wS0R+MjNOkav4Ctv2/VIVrz24OQk/517iVPZIydXUPbl+sDNLn/y" +
       "r9bn3v3Ms+rg08WdvRM/KYIuRK7385a20qwjrE4DTm+4+Rd6L7/7OjyJ+sq7" +
       "//m+yRPGk6/grP2hE3KeZPnbvee/Rr1O+dAOdPrgXOq6W7njg64eP426GGhR" +
       "HDiTY2dSDxxY9tbMYhXwFPYsW7jxefeND6RyL9iu/YkD1VOHBGRO8PaXOHF9" +
       "R1asI+hSqEXEyeOstxzxmCcj6MzKNdVDV0pe7sDg6Fx5Q3Sg+71Z4+vBg+3p" +
       "jv3f6H5Utfe/RN+vZ8V7gdrz42rnRjtU8emfQsX8yPF+8Dyxp+ITr1TF5suq" +
       "+LETfTt5387+Wd7rbnYWmd+BtRJF8w6CBJBvD/RNd5ceHPTl03wiKz4UQedV" +
       "Nx+Zvb7z0EoffiVWSiLo1iP3cNlFwr3XXepvL6KVzz976ZZ7np3+VX4VdXBZ" +
       "fIGBbtFjyzp67nukfs4LNN3M5b6wPQX28j/PRdA9N7FHdk+TV3Jpf3NL/5kI" +
       "unySPoLO5n+P0n02gi4e0gFW28pRks9F0GlAklU/773sQfH2EHRrnuTUcXg9" +
       "sPldL2fzI4j82DEczf/RYh/z4u2/WlxTvvBsp/+2F6uf3t6eKZaUphmXWxjo" +
       "/PYi7wA3H7kpt31e59qP//iOL1547T7G37EV+NDdj8j20I2vp1q2F+UXSukf" +
       "3PN7b/rMs9/Oz4L/B6qqO9sBIwAA");
}
