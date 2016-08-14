package org.apache.batik.extension.svg;
public class GlyphIterator {
    public static final java.text.AttributedCharacterIterator.Attribute PREFORMATTED =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PREFORMATTED;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    public static final char SOFT_HYPHEN = 173;
    public static final char ZERO_WIDTH_SPACE = 8203;
    public static final char ZERO_WIDTH_JOINER = 8205;
    int idx = -1;
    int chIdx = -1;
    int lineIdx = -1;
    int aciIdx = -1;
    int charCount = -1;
    float adv = 0;
    float adj = 0;
    int runLimit = 0;
    int lineBreakRunLimit = 0;
    int lineBreakCount = 0;
    org.apache.batik.gvt.font.GVTFont font = null;
    int fontStart = 0;
    float maxAscent = 0;
    float maxDescent = 0;
    float maxFontSize = 0;
    float width = 0;
    char ch = 0;
    int numGlyphs = 0;
    java.text.AttributedCharacterIterator aci;
    org.apache.batik.gvt.font.GVTGlyphVector gv;
    float[] gp;
    java.awt.font.FontRenderContext frc;
    int[] leftShiftIdx = null;
    float[] leftShiftAmt = null;
    int leftShift = 0;
    java.awt.geom.Point2D gvBase = null;
    public GlyphIterator(java.text.AttributedCharacterIterator aci,
                         org.apache.batik.gvt.font.GVTGlyphVector gv) {
        super(
          );
        this.
          aci =
          aci;
        this.
          gv =
          gv;
        this.
          idx =
          0;
        this.
          chIdx =
          0;
        this.
          lineIdx =
          0;
        this.
          aciIdx =
          aci.
            getBeginIndex(
              );
        this.
          charCount =
          gv.
            getCharacterCount(
              idx,
              idx);
        this.
          ch =
          aci.
            first(
              );
        this.
          frc =
          gv.
            getFontRenderContext(
              );
        this.
          font =
          (org.apache.batik.gvt.font.GVTFont)
            aci.
            getAttribute(
              GVT_FONT);
        if (font ==
              null) {
            font =
              new org.apache.batik.gvt.font.AWTGVTFont(
                aci.
                  getAttributes(
                    ));
        }
        fontStart =
          aciIdx;
        this.
          maxFontSize =
          -java.lang.Float.
             MAX_VALUE;
        this.
          maxAscent =
          -java.lang.Float.
             MAX_VALUE;
        this.
          maxDescent =
          -java.lang.Float.
             MAX_VALUE;
        this.
          runLimit =
          aci.
            getRunLimit(
              TEXT_COMPOUND_ID);
        this.
          lineBreakRunLimit =
          aci.
            getRunLimit(
              FLOW_LINE_BREAK);
        java.lang.Object o =
          aci.
          getAttribute(
            FLOW_LINE_BREAK);
        this.
          lineBreakCount =
          o ==
            null
            ? 0
            : 1;
        this.
          numGlyphs =
          gv.
            getNumGlyphs(
              );
        this.
          gp =
          gv.
            getGlyphPositions(
              0,
              this.
                numGlyphs +
                1,
              null);
        this.
          gvBase =
          new java.awt.geom.Point2D.Float(
            gp[0],
            gp[1]);
        this.
          adv =
          getCharWidth(
            );
        this.
          adj =
          getCharAdvance(
            );
    }
    public GlyphIterator(org.apache.batik.extension.svg.GlyphIterator gi) {
        super(
          );
        gi.
          copy1(
            this);
    }
    public org.apache.batik.extension.svg.GlyphIterator copy1() {
        return new org.apache.batik.extension.svg.GlyphIterator(
          this);
    }
    public org.apache.batik.extension.svg.GlyphIterator copy1(org.apache.batik.extension.svg.GlyphIterator gi) {
        if (gi ==
              null)
            return new org.apache.batik.extension.svg.GlyphIterator(
              this);
        gi.
          idx =
          this.
            idx;
        gi.
          chIdx =
          this.
            chIdx;
        gi.
          aciIdx =
          this.
            aciIdx;
        gi.
          charCount =
          this.
            charCount;
        gi.
          adv =
          this.
            adv;
        gi.
          adj =
          this.
            adj;
        gi.
          runLimit =
          this.
            runLimit;
        gi.
          ch =
          this.
            ch;
        gi.
          numGlyphs =
          this.
            numGlyphs;
        gi.
          gp =
          this.
            gp;
        gi.
          gvBase =
          this.
            gvBase;
        gi.
          lineBreakRunLimit =
          this.
            lineBreakRunLimit;
        gi.
          lineBreakCount =
          this.
            lineBreakCount;
        gi.
          frc =
          this.
            frc;
        gi.
          font =
          this.
            font;
        gi.
          fontStart =
          this.
            fontStart;
        gi.
          maxAscent =
          this.
            maxAscent;
        gi.
          maxDescent =
          this.
            maxDescent;
        gi.
          maxFontSize =
          this.
            maxFontSize;
        gi.
          leftShift =
          this.
            leftShift;
        gi.
          leftShiftIdx =
          this.
            leftShiftIdx;
        gi.
          leftShiftAmt =
          this.
            leftShiftAmt;
        return gi;
    }
    public int getGlyphIndex() { return idx; }
    public char getChar() { return ch; }
    public int getACIIndex() { return aciIdx; }
    public float getAdv() { return adv; }
    public java.awt.geom.Point2D getOrigin() { return gvBase;
    }
    public float getAdj() { return adj; }
    public float getMaxFontSize() { if (aciIdx >= fontStart) {
                                        int newFS =
                                          aciIdx +
                                          charCount;
                                        updateLineMetrics(
                                          newFS);
                                        fontStart =
                                          newFS;
                                    }
                                    return maxFontSize; }
    public float getMaxAscent() { if (aciIdx >= fontStart) {
                                      int newFS =
                                        aciIdx +
                                        charCount;
                                      updateLineMetrics(
                                        newFS);
                                      fontStart =
                                        newFS;
                                  }
                                  return maxAscent; }
    public float getMaxDescent() { if (aciIdx >= fontStart) {
                                       int newFS =
                                         aciIdx +
                                         charCount;
                                       updateLineMetrics(
                                         newFS);
                                       fontStart =
                                         newFS;
                                   }
                                   return maxDescent; }
    public boolean isLastChar() { return idx == numGlyphs -
                                    1; }
    public boolean done() { return idx >= numGlyphs; }
    public boolean isBreakChar() { switch (ch) { case org.apache.batik.extension.svg.GlyphIterator.
                                                        ZERO_WIDTH_SPACE:
                                                     return true;
                                                 case org.apache.batik.extension.svg.GlyphIterator.
                                                        ZERO_WIDTH_JOINER:
                                                     return false;
                                                 case org.apache.batik.extension.svg.GlyphIterator.
                                                        SOFT_HYPHEN:
                                                     return true;
                                                 case ' ':
                                                 case '\t':
                                                     return true;
                                                 default:
                                                     return false;
                                   } }
    protected boolean isPrinting(char tstCH) {
        switch (ch) {
            case org.apache.batik.extension.svg.GlyphIterator.
                   ZERO_WIDTH_SPACE:
                return false;
            case org.apache.batik.extension.svg.GlyphIterator.
                   ZERO_WIDTH_JOINER:
                return false;
            case org.apache.batik.extension.svg.GlyphIterator.
                   SOFT_HYPHEN:
                return true;
            case ' ':
            case '\t':
                return false;
            default:
                return true;
        }
    }
    public int getLineBreaks() { int ret =
                                   0;
                                 if (aciIdx +
                                       charCount >=
                                       lineBreakRunLimit) {
                                     ret =
                                       lineBreakCount;
                                     aci.
                                       setIndex(
                                         aciIdx +
                                           charCount);
                                     lineBreakRunLimit =
                                       aci.
                                         getRunLimit(
                                           FLOW_LINE_BREAK);
                                     aci.
                                       setIndex(
                                         aciIdx);
                                     java.lang.Object o =
                                       aci.
                                       getAttribute(
                                         FLOW_LINE_BREAK);
                                     lineBreakCount =
                                       o ==
                                         null
                                         ? 0
                                         : 1;
                                 }
                                 return ret;
    }
    public void nextChar() { if (ch == SOFT_HYPHEN ||
                                   ch ==
                                   ZERO_WIDTH_SPACE ||
                                   ch ==
                                   ZERO_WIDTH_JOINER) {
                                 gv.
                                   setGlyphVisible(
                                     idx,
                                     false);
                                 float chAdv =
                                   getCharAdvance(
                                     );
                                 adj -=
                                   chAdv;
                                 addLeftShift(
                                   idx,
                                   chAdv);
                             }
                             aciIdx += charCount;
                             ch = aci.setIndex(
                                        aciIdx);
                             idx++;
                             charCount = gv.
                                           getCharacterCount(
                                             idx,
                                             idx);
                             if (idx == numGlyphs)
                                 return;
                             if (aciIdx >=
                                   runLimit) {
                                 updateLineMetrics(
                                   aciIdx);
                                 runLimit =
                                   aci.
                                     getRunLimit(
                                       TEXT_COMPOUND_ID);
                                 font =
                                   (org.apache.batik.gvt.font.GVTFont)
                                     aci.
                                     getAttribute(
                                       GVT_FONT);
                                 if (font ==
                                       null) {
                                     font =
                                       new org.apache.batik.gvt.font.AWTGVTFont(
                                         aci.
                                           getAttributes(
                                             ));
                                 }
                                 fontStart =
                                   aciIdx;
                             }
                             float chAdv =
                               getCharAdvance(
                                 );
                             adj += chAdv;
                             if (isPrinting(
                                   )) { chIdx =
                                          idx;
                                        float chW =
                                          getCharWidth(
                                            );
                                        adv =
                                          adj -
                                            (chAdv -
                                               chW);
                             } }
    protected void addLeftShift(int idx, float chAdv) {
        if (leftShiftIdx ==
              null) {
            leftShiftIdx =
              (new int[1]);
            leftShiftIdx[0] =
              idx;
            leftShiftAmt =
              (new float[1]);
            leftShiftAmt[0] =
              chAdv;
        }
        else {
            int[] newLeftShiftIdx =
              new int[leftShiftIdx.
                        length +
                        1];
            java.lang.System.
              arraycopy(
                leftShiftIdx,
                0,
                newLeftShiftIdx,
                0,
                leftShiftIdx.
                  length);
            newLeftShiftIdx[leftShiftIdx.
                              length] =
              idx;
            leftShiftIdx =
              newLeftShiftIdx;
            float[] newLeftShiftAmt =
              new float[leftShiftAmt.
                          length +
                          1];
            java.lang.System.
              arraycopy(
                leftShiftAmt,
                0,
                newLeftShiftAmt,
                0,
                leftShiftAmt.
                  length);
            newLeftShiftAmt[leftShiftAmt.
                              length] =
              chAdv;
            leftShiftAmt =
              newLeftShiftAmt;
        }
    }
    protected void updateLineMetrics(int end) {
        org.apache.batik.gvt.font.GVTLineMetrics glm =
          font.
          getLineMetrics(
            aci,
            fontStart,
            end,
            frc);
        float ascent =
          glm.
          getAscent(
            );
        float descent =
          glm.
          getDescent(
            );
        float fontSz =
          font.
          getSize(
            );
        if (ascent >
              maxAscent)
            maxAscent =
              ascent;
        if (descent >
              maxDescent)
            maxDescent =
              descent;
        if (fontSz >
              maxFontSize)
            maxFontSize =
              fontSz;
    }
    public org.apache.batik.extension.svg.LineInfo newLine(java.awt.geom.Point2D.Float loc,
                                                           float lineWidth,
                                                           boolean partial,
                                                           java.awt.geom.Point2D.Float verticalAlignOffset) {
        if (ch ==
              SOFT_HYPHEN) {
            gv.
              setGlyphVisible(
                idx,
                true);
        }
        int lsi =
          0;
        int nextLSI;
        if (leftShiftIdx !=
              null)
            nextLSI =
              leftShiftIdx[lsi];
        else
            nextLSI =
              idx +
                1;
        for (int ci =
               lineIdx;
             ci <=
               idx;
             ci++) {
            if (ci ==
                  nextLSI) {
                leftShift +=
                  leftShiftAmt[lsi++];
                if (lsi <
                      leftShiftIdx.
                        length)
                    nextLSI =
                      leftShiftIdx[lsi];
            }
            gv.
              setGlyphPosition(
                ci,
                new java.awt.geom.Point2D.Float(
                  gp[2 *
                       ci] -
                    leftShift,
                  gp[2 *
                       ci +
                       1]));
        }
        leftShiftIdx =
          null;
        leftShiftAmt =
          null;
        float lineInfoChW;
        int hideIdx;
        if (chIdx !=
              0 ||
              isPrinting(
                )) {
            lineInfoChW =
              getCharWidth(
                chIdx);
            hideIdx =
              chIdx +
                1;
        }
        else {
            lineInfoChW =
              0;
            hideIdx =
              0;
        }
        int lineInfoIdx =
          idx +
          1;
        float lineInfoAdv =
          adv;
        float lineInfoAdj =
          adj;
        while (!done(
                  )) {
            adv =
              0;
            adj =
              0;
            if (ch ==
                  ZERO_WIDTH_SPACE ||
                  ch ==
                  ZERO_WIDTH_JOINER)
                gv.
                  setGlyphVisible(
                    idx,
                    false);
            ch =
              0;
            nextChar(
              );
            if (isPrinting(
                  ))
                break;
            lineInfoIdx =
              idx +
                1;
            lineInfoAdj +=
              adj;
        }
        for (int i =
               hideIdx;
             i <
               lineInfoIdx;
             i++) {
            gv.
              setGlyphVisible(
                i,
                false);
        }
        maxAscent =
          -java.lang.Float.
             MAX_VALUE;
        maxDescent =
          -java.lang.Float.
             MAX_VALUE;
        maxFontSize =
          -java.lang.Float.
             MAX_VALUE;
        org.apache.batik.extension.svg.LineInfo ret =
          new org.apache.batik.extension.svg.LineInfo(
          loc,
          aci,
          gv,
          lineIdx,
          lineInfoIdx,
          lineInfoAdj,
          lineInfoAdv,
          lineInfoChW,
          lineWidth,
          partial,
          verticalAlignOffset);
        lineIdx =
          idx;
        return ret;
    }
    public boolean isPrinting() { if (aci.
                                        getAttribute(
                                          PREFORMATTED) ==
                                        java.lang.Boolean.
                                          TRUE)
                                      return true;
                                  return isPrinting(
                                           ch);
    }
    public float getCharAdvance() { return getCharAdvance(
                                             idx);
    }
    public float getCharWidth() { return getCharWidth(
                                           idx);
    }
    protected float getCharAdvance(int gvIdx) {
        return gp[2 *
                    gvIdx +
                    2] -
          gp[2 *
               gvIdx];
    }
    protected float getCharWidth(int gvIdx) {
        java.awt.geom.Rectangle2D lcBound =
          gv.
          getGlyphVisualBounds(
            gvIdx).
          getBounds2D(
            );
        java.awt.geom.Point2D lcLoc =
          gv.
          getGlyphPosition(
            gvIdx);
        return (float)
                 (lcBound.
                    getX(
                      ) +
                    lcBound.
                    getWidth(
                      ) -
                    lcLoc.
                    getX(
                      ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pjCFTc8fD6g1Qhsd3GkP6dmQaONyT2c2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+Hdv/jfP/WF+vNr/A+0eElJXXQAA");
}
