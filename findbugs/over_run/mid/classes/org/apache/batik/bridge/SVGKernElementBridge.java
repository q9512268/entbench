package org.apache.batik.bridge;
public abstract class SVGKernElementBridge extends org.apache.batik.bridge.AbstractSVGBridge {
    public org.apache.batik.gvt.font.Kern createKern(org.apache.batik.bridge.BridgeContext ctx,
                                                     org.w3c.dom.Element kernElement,
                                                     org.apache.batik.bridge.SVGGVTFont font) {
        java.lang.String u1 =
          kernElement.
          getAttributeNS(
            null,
            SVG_U1_ATTRIBUTE);
        java.lang.String u2 =
          kernElement.
          getAttributeNS(
            null,
            SVG_U2_ATTRIBUTE);
        java.lang.String g1 =
          kernElement.
          getAttributeNS(
            null,
            SVG_G1_ATTRIBUTE);
        java.lang.String g2 =
          kernElement.
          getAttributeNS(
            null,
            SVG_G2_ATTRIBUTE);
        java.lang.String k =
          kernElement.
          getAttributeNS(
            null,
            SVG_K_ATTRIBUTE);
        if (k.
              length(
                ) ==
              0) {
            k =
              SVG_KERN_K_DEFAULT_VALUE;
        }
        float kernValue =
          java.lang.Float.
          parseFloat(
            k);
        int firstGlyphLen =
          0;
        int secondGlyphLen =
          0;
        int[] firstGlyphSet =
          null;
        int[] secondGlyphSet =
          null;
        java.util.List firstUnicodeRanges =
          new java.util.ArrayList(
          );
        java.util.List secondUnicodeRanges =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          u1,
          ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            if (token.
                  startsWith(
                    "U+")) {
                firstUnicodeRanges.
                  add(
                    new org.apache.batik.gvt.font.UnicodeRange(
                      token));
            }
            else {
                int[] glyphCodes =
                  font.
                  getGlyphCodesForUnicode(
                    token);
                if (firstGlyphSet ==
                      null) {
                    firstGlyphSet =
                      glyphCodes;
                    firstGlyphLen =
                      glyphCodes.
                        length;
                }
                else {
                    if (firstGlyphLen +
                          glyphCodes.
                            length >
                          firstGlyphSet.
                            length) {
                        int sz =
                          firstGlyphSet.
                            length *
                          2;
                        if (sz <
                              firstGlyphLen +
                              glyphCodes.
                                length)
                            sz =
                              firstGlyphLen +
                                glyphCodes.
                                  length;
                        int[] tmp =
                          new int[sz];
                        java.lang.System.
                          arraycopy(
                            firstGlyphSet,
                            0,
                            tmp,
                            0,
                            firstGlyphLen);
                        firstGlyphSet =
                          tmp;
                    }
                    for (int i =
                           0;
                         i <
                           glyphCodes.
                             length;
                         i++)
                        firstGlyphSet[firstGlyphLen++] =
                          glyphCodes[i];
                }
            }
        }
        st =
          new java.util.StringTokenizer(
            u2,
            ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            if (token.
                  startsWith(
                    "U+")) {
                secondUnicodeRanges.
                  add(
                    new org.apache.batik.gvt.font.UnicodeRange(
                      token));
            }
            else {
                int[] glyphCodes =
                  font.
                  getGlyphCodesForUnicode(
                    token);
                if (secondGlyphSet ==
                      null) {
                    secondGlyphSet =
                      glyphCodes;
                    secondGlyphLen =
                      glyphCodes.
                        length;
                }
                else {
                    if (secondGlyphLen +
                          glyphCodes.
                            length >
                          secondGlyphSet.
                            length) {
                        int sz =
                          secondGlyphSet.
                            length *
                          2;
                        if (sz <
                              secondGlyphLen +
                              glyphCodes.
                                length)
                            sz =
                              secondGlyphLen +
                                glyphCodes.
                                  length;
                        int[] tmp =
                          new int[sz];
                        java.lang.System.
                          arraycopy(
                            secondGlyphSet,
                            0,
                            tmp,
                            0,
                            secondGlyphLen);
                        secondGlyphSet =
                          tmp;
                    }
                    for (int i =
                           0;
                         i <
                           glyphCodes.
                             length;
                         i++)
                        secondGlyphSet[secondGlyphLen++] =
                          glyphCodes[i];
                }
            }
        }
        st =
          new java.util.StringTokenizer(
            g1,
            ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            int[] glyphCodes =
              font.
              getGlyphCodesForName(
                token);
            if (firstGlyphSet ==
                  null) {
                firstGlyphSet =
                  glyphCodes;
                firstGlyphLen =
                  glyphCodes.
                    length;
            }
            else {
                if (firstGlyphLen +
                      glyphCodes.
                        length >
                      firstGlyphSet.
                        length) {
                    int sz =
                      firstGlyphSet.
                        length *
                      2;
                    if (sz <
                          firstGlyphLen +
                          glyphCodes.
                            length)
                        sz =
                          firstGlyphLen +
                            glyphCodes.
                              length;
                    int[] tmp =
                      new int[sz];
                    java.lang.System.
                      arraycopy(
                        firstGlyphSet,
                        0,
                        tmp,
                        0,
                        firstGlyphLen);
                    firstGlyphSet =
                      tmp;
                }
                for (int i =
                       0;
                     i <
                       glyphCodes.
                         length;
                     i++)
                    firstGlyphSet[firstGlyphLen++] =
                      glyphCodes[i];
            }
        }
        st =
          new java.util.StringTokenizer(
            g2,
            ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            int[] glyphCodes =
              font.
              getGlyphCodesForName(
                token);
            if (secondGlyphSet ==
                  null) {
                secondGlyphSet =
                  glyphCodes;
                secondGlyphLen =
                  glyphCodes.
                    length;
            }
            else {
                if (secondGlyphLen +
                      glyphCodes.
                        length >
                      secondGlyphSet.
                        length) {
                    int sz =
                      secondGlyphSet.
                        length *
                      2;
                    if (sz <
                          secondGlyphLen +
                          glyphCodes.
                            length)
                        sz =
                          secondGlyphLen +
                            glyphCodes.
                              length;
                    int[] tmp =
                      new int[sz];
                    java.lang.System.
                      arraycopy(
                        secondGlyphSet,
                        0,
                        tmp,
                        0,
                        secondGlyphLen);
                    secondGlyphSet =
                      tmp;
                }
                for (int i =
                       0;
                     i <
                       glyphCodes.
                         length;
                     i++)
                    secondGlyphSet[secondGlyphLen++] =
                      glyphCodes[i];
            }
        }
        int[] firstGlyphs;
        if (firstGlyphLen ==
              0 ||
              firstGlyphLen ==
              firstGlyphSet.
                length) {
            firstGlyphs =
              firstGlyphSet;
        }
        else {
            firstGlyphs =
              (new int[firstGlyphLen]);
            java.lang.System.
              arraycopy(
                firstGlyphSet,
                0,
                firstGlyphs,
                0,
                firstGlyphLen);
        }
        int[] secondGlyphs;
        if (secondGlyphLen ==
              0 ||
              secondGlyphLen ==
              secondGlyphSet.
                length) {
            secondGlyphs =
              secondGlyphSet;
        }
        else {
            secondGlyphs =
              (new int[secondGlyphLen]);
            java.lang.System.
              arraycopy(
                secondGlyphSet,
                0,
                secondGlyphs,
                0,
                secondGlyphLen);
        }
        org.apache.batik.gvt.font.UnicodeRange[] firstRanges;
        firstRanges =
          (new org.apache.batik.gvt.font.UnicodeRange[firstUnicodeRanges.
                                                        size(
                                                          )]);
        firstUnicodeRanges.
          toArray(
            firstRanges);
        org.apache.batik.gvt.font.UnicodeRange[] secondRanges;
        secondRanges =
          (new org.apache.batik.gvt.font.UnicodeRange[secondUnicodeRanges.
                                                        size(
                                                          )]);
        secondUnicodeRanges.
          toArray(
            secondRanges);
        return new org.apache.batik.gvt.font.Kern(
          firstGlyphs,
          secondGlyphs,
          firstRanges,
          secondRanges,
          kernValue);
    }
    public SVGKernElementBridge() { super(); }
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
       "4X2//57ffvnbeQvrfwFgQIw5Jh8AAA==");
}
