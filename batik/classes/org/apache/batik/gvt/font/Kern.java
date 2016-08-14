package org.apache.batik.gvt.font;
public class Kern {
    private int[] firstGlyphCodes;
    private int[] secondGlyphCodes;
    private org.apache.batik.gvt.font.UnicodeRange[] firstUnicodeRanges;
    private org.apache.batik.gvt.font.UnicodeRange[] secondUnicodeRanges;
    private float kerningAdjust;
    public Kern(int[] firstGlyphCodes, int[] secondGlyphCodes, org.apache.batik.gvt.font.UnicodeRange[] firstUnicodeRanges,
                org.apache.batik.gvt.font.UnicodeRange[] secondUnicodeRanges,
                float adjustValue) { super();
                                     this.firstGlyphCodes = firstGlyphCodes;
                                     this.secondGlyphCodes = secondGlyphCodes;
                                     this.firstUnicodeRanges = firstUnicodeRanges;
                                     this.secondUnicodeRanges = secondUnicodeRanges;
                                     this.kerningAdjust = adjustValue;
                                     if (firstGlyphCodes != null)
                                         java.util.Arrays.
                                           sort(
                                             this.
                                               firstGlyphCodes);
                                     if (secondGlyphCodes != null)
                                         java.util.Arrays.
                                           sort(
                                             this.
                                               secondGlyphCodes);
    }
    public boolean matchesFirstGlyph(int glyphCode, java.lang.String glyphUnicode) {
        if (firstGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                firstGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        if (glyphUnicode.
              length(
                ) <
              1)
            return false;
        char glyphChar =
          glyphUnicode.
          charAt(
            0);
        for (int i =
               0;
             i <
               firstUnicodeRanges.
                 length;
             i++) {
            if (firstUnicodeRanges[i].
                  contains(
                    glyphChar))
                return true;
        }
        return false;
    }
    public boolean matchesFirstGlyph(int glyphCode, char glyphUnicode) {
        if (firstGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                firstGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        for (int i =
               0;
             i <
               firstUnicodeRanges.
                 length;
             i++) {
            if (firstUnicodeRanges[i].
                  contains(
                    glyphUnicode))
                return true;
        }
        return false;
    }
    public boolean matchesSecondGlyph(int glyphCode, java.lang.String glyphUnicode) {
        if (secondGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                secondGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        if (glyphUnicode.
              length(
                ) <
              1)
            return false;
        char glyphChar =
          glyphUnicode.
          charAt(
            0);
        for (int i =
               0;
             i <
               secondUnicodeRanges.
                 length;
             i++) {
            if (secondUnicodeRanges[i].
                  contains(
                    glyphChar))
                return true;
        }
        return false;
    }
    public boolean matchesSecondGlyph(int glyphCode,
                                      char glyphUnicode) {
        if (secondGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                secondGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        for (int i =
               0;
             i <
               secondUnicodeRanges.
                 length;
             i++) {
            if (secondUnicodeRanges[i].
                  contains(
                    glyphUnicode))
                return true;
        }
        return false;
    }
    public float getAdjustValue() { return kerningAdjust;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8IGlJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GX5Pc/Kndx67UC31v5LaQ6ae7L8lVIcK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("yt5TTvwnb4bDrHCg8vxeeRjpsVtO/+5PrKqfe+Xafe94Rfid/bGgo1Ol9w9r" +
       "9xmp654+iHDq/nIY6YZd8XT//ltkWDFxJal9zx2/LhfUlH8lmRcu7+GvJrW3" +
       "3g4+qd1TtKchH0xq189DJrVL1f9puOtJ7eoJXFK7vL85DfJogb0AKW/fGt7m" +
       "28j+5EZ24WyCOVbBI6+nglM56caZ777VOe2j4wrp/qT2C+rnX2HGH/xm+zP7" +
       "s3iqK+d5ieW+Ye3K/lhghbQ88vDMHbEd4brcf/e3Hvr5+587ynIP7Qk+sdxT" +
       "tD11+4NvpBcm1VG1/B++45fe+/df+b3qU83/BalHhmVALwAA");
}
