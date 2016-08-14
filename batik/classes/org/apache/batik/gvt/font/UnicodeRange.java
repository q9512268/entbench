package org.apache.batik.gvt.font;
public class UnicodeRange {
    private int firstUnicodeValue;
    private int lastUnicodeValue;
    public UnicodeRange(java.lang.String unicodeRange) { super();
                                                         if (unicodeRange.
                                                               startsWith(
                                                                 "U+") &&
                                                               unicodeRange.
                                                               length(
                                                                 ) >
                                                               2) { unicodeRange =
                                                                      unicodeRange.
                                                                        substring(
                                                                          2);
                                                                    int dashIndex =
                                                                      unicodeRange.
                                                                      indexOf(
                                                                        '-');
                                                                    java.lang.String firstValue;
                                                                    java.lang.String lastValue;
                                                                    if (dashIndex !=
                                                                          -1) {
                                                                        firstValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              0,
                                                                              dashIndex);
                                                                        lastValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              dashIndex +
                                                                                1);
                                                                    }
                                                                    else {
                                                                        firstValue =
                                                                          unicodeRange;
                                                                        lastValue =
                                                                          unicodeRange;
                                                                        if (unicodeRange.
                                                                              indexOf(
                                                                                '?') !=
                                                                              -1) {
                                                                            firstValue =
                                                                              firstValue.
                                                                                replace(
                                                                                  '?',
                                                                                  '0');
                                                                            lastValue =
                                                                              lastValue.
                                                                                replace(
                                                                                  '?',
                                                                                  'F');
                                                                        }
                                                                    }
                                                                    try {
                                                                        firstUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              firstValue,
                                                                              16);
                                                                        lastUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              lastValue,
                                                                              16);
                                                                    }
                                                                    catch (java.lang.NumberFormatException e) {
                                                                        firstUnicodeValue =
                                                                          -1;
                                                                        lastUnicodeValue =
                                                                          -1;
                                                                    }
                                                         }
                                                         else {
                                                             firstUnicodeValue =
                                                               -1;
                                                             lastUnicodeValue =
                                                               -1;
                                                         }
    }
    public boolean contains(java.lang.String unicode) {
        if (unicode.
              length(
                ) ==
              1) {
            int unicodeVal =
              unicode.
              charAt(
                0);
            return contains(
                     unicodeVal);
        }
        return false;
    }
    public boolean contains(int unicodeVal) {
        return unicodeVal >=
          firstUnicodeValue &&
          unicodeVal <=
          lastUnicodeValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2zSzZWZ5jSkimRZmTmxfEl1sXv4ve9VXFxsZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
