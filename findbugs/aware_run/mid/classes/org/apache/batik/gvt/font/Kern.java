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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "woIFhjQzp1xDQPG2coy5tyGwfl+PqxpIyRaiTtlg1U8FzLJAjnJlbSjJm4Gj" +
       "0/am08VREtnYcW/YNVpj3Cl7jkaJs5G4lH0DFAmjZMtxSUSSbm1ETrsVpA1P" +
       "DbQmsbraNGuDBbtpZPqCHo2qSAOTApLvr1QrMmYLeDjuDQdMGeeWFQxtlSdG" +
       "nywRvaRTHRhVY14j2Egd2mScTswpjrjKeOCMqdmcjNcu02/4LlWhtRmilegy" +
       "nmEmTkty1koNUM8GulZbca0Ek9mqLsKCYowl15MmI1xyEo3amCMsDe1eMk2W" +
       "IOrK7RmrbHQTjZEpn3Uxj50vTaqfOagCXhRBiWHj1TqlRjMc3jB9ChY02UiR" +
       "0Fb1hS3BjTHfqwhBKGapN60IWaXbkF2S4wUqieIejgzdiiP1CHcLgu2CoAdM" +
       "160AVyGRrJOmUYuolGNGJYciSve7Qrc6ompNYg6CPde0EpeKBhotSz5TF2hJ" +
       "GkwyqWsCn4K7SaVCYlbJ5tRZtzSbsZinCxMm9QdbddODeZRqiS0hqVAdg1Lc" +
       "uLPJfFa3+pVSgiapHtfWW7Thr2hdjxmGLUXNSqcWoRnO2v3OtkoIFYInmjWP" +
       "zFgfVFczrl11/Y4LV1bdWpnFWFZG59MqiScqW7OTnoN3aInX5oa/Cs0Zwhrt" +
       "uF1FM2lk83SlunXHNTPabuC1odTjMjsMunjS9X2U8sXqBl7aNgJX6yWkM5Cr" +
       "5Yrp1Fa0MubQiT7xuYHASlpf8KqDeFHldKdU0TeVtZTMy/ySJNakQ1XDzdSN" +
       "1uXy2onYGeH2IoytDUtKDx/ZKrZpedi25BsCTcnuOquAsLzw2YmQzae876cS" +
       "CFY1X81iDtNXDmpTzHSWjXpEdyqSruD4yyU37s2kcLPZYuG8LDad8gZbtcja" +
       "XDC1aBTXAwKRXK4TrjTWDqm4Im420563XPGdBB5KdTay66OG0nLhZkpvgoU0" +
       "jugWTiGjudVTupUZHqyWVZgR1lrWGzL2ZBO0+l6AkYxqIljJQDYLpJd0NxRq" +
       "w5u+MsN9YtmrMoLoWFyj1t6KuIDBY8ucCG6Po+aanXiYgpcCeK1kVFZipcW6" +
       "084yheVTLNhmii4F6CRT56xvwASDGE7UxOd1a8ysZl2z51eDbb+W1Wc0z/V7" +
       "0/KsJdLWgLW8OlNVhNGQaQwQg8oaq3Wzk0wYZNhLJgO+IfbnoS7wm2aNd9wM" +
       "JhazVVoyZLImg5cwM9GsBhdojbFKpR7VsxRsgzl0zdg4pt3Kuki33cXJCj5F" +
       "1WELaShNiXUmbSQBZc9iNKEqcLW6MeaE3tsIDjetBO3WWuY6PFPG1rVhF9Pm" +
       "VOizQocKpnRZhtHRpOEOp8PqDJu22DBWRQ+8XHNMZbyqpgarKokYDBGliikm" +
       "PFgoSmU6qDcbmDEr6Q3NXwY8TA2m9RXj0JOubRmpUbO5rQKqvk6wRqOsiral" +
       "TVMOMGTc5uqlsYxPSKNmVDpzHe/RfRHVKpNho+eQmcc58GQucdORCHzazdiU" +
       "yOL1wo2obVT3B9W+xssaJfWJJUmjwwwm10NLIsheHSHL+CDxumsLN9eW6YxF" +
       "dSpVaWmUBC474Cw+5dqVVlAC5octdRSdzhG8HKBmIxlrQ7eGBXgnoWOGajlM" +
       "0ii2LL705rZSHil2jY6OVpk2kQ987k3slqQnPoQc7bIVvyvQmeM4J3bZTmwR" +
       "Q/km9pP3OjFVfJD87IdffkUefq68d7C1/sMR9EDk+T9oKxvFPoHq8u57wREZ" +
       "jx3uQHIHZHBnN/uOGT1/p+/7d4I6s81/4sNF8VHjcwXUly/4GPDP8+bXgLwd" +
       "MZJ0JaSO9qzP27G6uvI8G7z3Hmvgn7zeftXJBe8lBeNACsZ3Xwrn7rtJuhgU" +
       "M3/3Asn8m7z56nmSyQe+ciyCf/HnFUG+0/vSgQhe+l4awr+/gN2v580fRtCj" +
       "B+zyx98HzvD7R98Nfj99wO+nvzf8/l4B9V8v4Pe/5c033wi//+XPwe8jhzHm" +
       "8wf8fv67w+9JTv703mOXiqX+VwQ9rCnR7ltAcSgg7z3hxH/yZjhMgQPlZ/Py" +
       "g0aP33Xqd3dSVfrCKzeuveMV4Xd3R34O");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("T5M+wELX1Ni2Tx4kOHF/xQ8U1Sh4emD3LdEvmLgaQd93z6/DgJr8Lyfz0pUd" +
       "/PUIeut58BF0H2hPQj4UQTfPQkbQ5eL/JNzNCLp+DBdBV3Y3J0EeA9gBSH77" +
       "Vv+cbxu7kxfppdMJ5kgFj76eCk7kpFunvtsW57MPjxvEuxPad6QvvtIdfOjb" +
       "1c/tztlJtphlOZZrLHR1d+SvQJofWXj2ntgOcV3pvPs7D//KA88fZrmHdwQf" +
       "W+4J2p4+/1Bb2/Gj4hha9g/e8ffe+3de+f3iU8v/BWl+FHU4LwAA");
}
