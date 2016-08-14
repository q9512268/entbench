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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WugHFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "owf+4O2//fI38jbY/wKgp2bxTh8AAA==");
}
