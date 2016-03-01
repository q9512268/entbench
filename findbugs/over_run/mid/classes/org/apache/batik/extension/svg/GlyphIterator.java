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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC3AcxZnuXcuSLFu2ZIMxNn7LgI29e4bwih0SWQ977ZW0" +
       "JQkD4rEezY5WY+/uDDO9smzHvO6CfaQKqNg8cgFXQpzcHTHg45IicBfjS0IC" +
       "AcLZoTgDCRC4OiBADq7OOAS43P/39OzMzm63vIsKVU3vaLr/7u/7+++/nzMH" +
       "3iMTbYssMpVcSonQbaZmRxJ4n1AsW0u1ZRTb7oenSfWW3++5/sRvJt0YJrUD" +
       "ZOqwYnepiq116lomZQ+QuXrOpkpO1exuTUuhRMLSbM0aUahu5AbIqbody5oZ" +
       "XdVpl5HSMMFGxYqTZoVSSx/MUy3GM6BkfpyhiTI00dZgglVxMkU1zG2ewOwi" +
       "gTZfHKbNeuXZlDTFNysjSjRP9Uw0rtt01ahFzjGNzLZ0xqARbZRGNmfO54pY" +
       "Hz+/RA2LDk778OPbh5uYGmYouZxBGUW7V7ONzIiWipNp3tOOjJa1ryXXkQlx" +
       "MtmXmJKWuFtoFAqNQqEuXy8VoG/Ucvlsm8HoUDenWlNFQJQsLM7EVCwly7NJ" +
       "MMyQQz3l3JkwsF1QYOtWd4DiHedE9951TdPDE8i0ATJNz/UhHBVAUChkABSq" +
       "ZQc1y25NpbTUAGnOQYX3aZauZPTtvLan23o6p9A8mICrFnyYNzWLlenpCmoS" +
       "uFl5lRpWgd4QMyr+38ShjJIGrjM9rg7DTnwOBBt0AGYNKWB7XKRmi55LMTsq" +
       "lihwbNkACUC0LqvRYaNQVE1OgQdkumMiGSWXjvaB8eXSkHSiASZoMVsTZIq6" +
       "NhV1i5LWkpTMCqZLOFGQahJTBIpQcmowGcsJaml2oJZ89fNe9+pbd+TW5cIk" +
       "BJhTmppB/JNBaF5AqFcb0iwN2oEjOGVZ/E5l5k92hwmBxKcGEjtpHvnqB19Z" +
       "Pu/wk06aOWXS9Axu1lSaVPcPTj1yRtvSiycgjHrTsHWs/CLmrJUleMyqURM8" +
       "zcxCjhgZcSMP9/7iihvu194Jk4YYqVWNTD4LdtSsGllTz2jWWi2nWQrVUjEy" +
       "Scul2lh8jNTBfVzPac7TnqEhW6MxUpNhj2oN9j+oaAiyQBU1wL2eGzLce1Oh" +
       "w+x+1CSE1MFFpsDVQpw/9ktJNjpsZLWooio5PWdEE5aB/LFCmc/RbLhPQaxp" +
       "RAfB/resWBm5MGobeQsMMmpY6agCVjGsOZHYTrWcDYyj9kg6ujazzRyOUeRm" +
       "WBE0O/PzLnAUNTBjaygElXNG0DVkoFWtMzIpzUqqe/NrOj54MPm0Y3bYVLju" +
       "KFkOpUacUiOs1Eih1AiUGikqlYRCrLBTsHTHCqAOt4A3AHc8ZWnf1es37V40" +
       "AczP3FoDFRCGpGeWdE9tnttwfX1SPXCk98RzzzbcHyZh8CyD0D15fURLUR/h" +
       "dHGWoWopcFKi3sL1mFFx/1AWBzl899YbN17/VwyH3+1jhhPBY6F4Ap11oYiW" +
       "YHMvl++0XW99+NCdOw2v4Rf1I273VyKJ/mRRsGqD5JPqsgXKj5I/2dkSJjXg" +
       "pMAxUwUaEvi8ecEyivzKKtdHI5d6IDxkWFklg1GuY22gw5ax1XvCbK6Z3Z8C" +
       "VTwZG9osuDbzlsd+MXamieFpjo2izQRYsD7gS33mvcd+/fZ5TN1udzHN18/3" +
       "aXSVz0VhZtOZM2r2TLDf0jRI97u7E3vueG/Xlcz+IMXicgW2YNgGrklhBv21" +
       "J6998dVX9j8fLthsiEIfnR+E4c5ogSQ+Jw0SkmjnHh5wcRlo9Wg1LZfmwCr1" +
       "IV0ZzGjYSD6ZtmTlj969tcmxgww8cc1o+dgZeM9PX0NuePqaE/NYNiEVu1hP" +
       "Z14yx2/P8HJutSxlG+IYvfHo3G/+UrkXegDwura+XWOONMzbLYKaRckSJolj" +
       "h0hhLJdqGwbdqeARXK/gpj67xJWkR2hkCIwxsnZjP3MkGzU0bmYTX2BiURae" +
       "h/pkRRMW90UMWmx/2ypuvr6RVlK9/fn3Gze+f+gDpozioZrflLoUc5VjvRgs" +
       "GYXsTwv6sXWKPQzpvnC4+6qmzOGPIccByFEF72z3WOBKR4sMj6eeWPfSv/1s" +
       "5qYjE0i4kzRkDCXVqbA2TCZB49HsYfDCo+aXv+LYztZ6CJoYVVJCHqtrfnlD" +
       "6MialFXd9h+f9sPVf7/vFWazLIe5pc3xNm6pt5VvjhieicGyUiMXiQbqK+Q0" +
       "F7fyK+pHGIqYxAC6MGhnUasw6HAa4yUnp0R80OZIzGHPFto4dg52RGwC5PnQ" +
       "d1/+1huPn/hunTN8WiruOAJys/7ckxm86fU/lZgf6zLKDO0C8gPRA/fMbrvk" +
       "HSbv+W6UXjxa2rFD7+bJnnt/9nh4Ue0TYVI3QJpUPtnYqGTy6BEHYIBtuzMQ" +
       "mJAUxRcPlp2R4apC33RGsN/wFRvsNbwBBdxjarxvDHQUaJSkHa4zuXktCVpm" +
       "iLCbyx3jZOFSDJazKpyAtyvAOdtsSkMBgp5TMgEnfZqbcZkCKJmS6O3o7Ont" +
       "au3v72h3DTd6Uj6upRDnNSBmmVeMZZm9xSpYC9dSjvBsgQpSMhVgcBUGV5fh" +
       "frYgZ/CEnfGey5LxWHdHck1vR+sGfLwpwEWrkMs6uJbzEs8RcMlUzeUcQc6U" +
       "NPV3XN6fbOvpSvRc2t2ejLWXI5M9eTIYQzBZlBcZEZChVZNZwXNeUUKmHvrG" +
       "ZGdPd385EvkKa+QiuFbyolaWkAgVxk3Y5iMxmHynNWv669/ef+LGXReFcSgw" +
       "cQR9A7idJi9ddx4XDW4+cMfcyXtf+zrrdiDnBzDTr1atEBFKSib39XT2J9dd" +
       "kVjX0c2GAD6/jQtQfflBmyYsPQsjwhE+PX5o5olrf163vd2d+pYTcVJusLue" +
       "e2zdm0k24qzHiUa/67F8U4hWK+0b7jY58P8CfyG4/g8vhI0P8BdcaRuf7S4o" +
       "THdNE0cYkm4kQCG6c/qrW+556wGHQrDPCCTWdu+95S+RW/c6w0hnzWRxybKF" +
       "X8ZZN3HoYLAb0S2UlcIkOt98aOe//MPOXQ6q6cUrAB25fPaBFz59JnL3a0+V" +
       "mVrWqMN8JuYfL+A6QqB6HE61K+/96Pqbj/XAHCZG6vM5/dq8FksVdy91dn7Q" +
       "V1/ecozX5XB2WDeUhJZBNQTa1M4q2tS53FrPLdOm8OY6QhZMxpu7q24QoiLA" +
       "3Q109PYkL4u1969L9iVa2zrw+a4Aq29Wweo8XuR5ElaNePOdqlmJiqCk2cdq" +
       "fQ/0S73laN138rRYmXPguoCXeUEJLceL31+eDQnAr5FkRckEPeWk/xpvTfhz" +
       "i+/+VkzDF3599o//7g2a5A+qYHkRh3aRgOUj3iD/gVJiImkYV6nDsRQDeDCA" +
       "8sdVoLyYl3OxAOUhKUqRNCV1bKGwPM7Hq8C5mpe0WoDzCSlOkTQMVxVVF8D8" +
       "RRUwL+EFXSKA+YwUpkiawrQDXHWbkc/RckifrQJpKy+rVYD0N1KkImloU0pq" +
       "ZKx2B7MTQzm5lvd8FdTaOLg2AbVXpdRE0ozaZrw9FsD4WhUYO3gpHQKM/yXF" +
       "KJKG0aqVz8VxkFDOTt6sEOgi4swhiPtbBuh7UqAiaehe0EGssTRlS68E8R+r" +
       "QBzjZcYEiP9XilgkTcnUAmJhQzxeIdx5cMV5gXEB3I+lcEXSMLrDhT13Er1Q" +
       "uvTXaTh0fEw+qcKmuziWrvJMQjVSJiJpcH6Is48qVjmdhyZWgbSbl9UtQDpZ" +
       "ilQkDUizymirrWqOOgN+IjSlCqQ9vKweAdLpUqQiaUoaAGm7JoQ6o0KoZ8CV" +
       "4IUlBFBPl0IVScN8E6Cihfbp27VyWGdXiBVvenlpvQKsC6RYRdLQs23VU87G" +
       "ZxDlwgpRYlQ/L6dfgPIsKUqRNCVhlUEMjOVDZ1cIcSZcG3khGwUQI1KIImlo" +
       "STB1ZUvSdrk2H60QKW43X87LulyA9HwpUpE0jgpUHW/PD2C8oAptDvBSBgQY" +
       "V0sxiqShwtMjeHdhAOKXqrDJq3ghVwkgtkkhiqQRohncBCisDLFdMWcR4tEZ" +
       "b//zU5vqXnTWO8qvPQWOZry+4+n7jN++Ew7zvYubC7BmI4r5cJ3FYbFfSrRx" +
       "PSUAmWRxz8+wWuGObT24xxE+n4JwJWmJeJ3Lp91931/86+v3Lf4921er1+2N" +
       "itVqpcscmfHJvH/g1XeONs59kG1t1+CCHaq3MXjWqPQoUdEJIVYz09CANrDb" +
       "Y8HZgWOPTgJuao51lqwThPGWrXpczbLaDbO8jJZLO375n1AyYY4W8g9sqc7w" +
       "1lXbMkZOw31dN845VqEbkcKZLIgcLUGK63bBvawuxtXbGLrw6IkJL39j1pTS" +
       "8xSY2zzBaYll4loMFvDLm/4wu/+S4U0VHJSYH6jkYJb/2HXgqbVnqt8IswNd" +
       "zj5UyUGwYqFVxcuDDZZG81aueEFwUaHWQwnPeSxjVcf+L7sFGVIlcZh7aBOu" +
       "lWAVOjUuST7MdyRJsCrx3+CUNNReoddEL3MNdzDXCLxmRuo1RdLQ+QxZqmud" +
       "zr60spWP63HI1KvlUprFjxcGaFSw/8KALIRL4UAUAY28lIZImpIpGW2I9g3r" +
       "QzTmrNqF1hXEp2LqZuJsABH3lxJ9vI9yRUF10bRmZCELOhxnHsN11J9fYQ79" +
       "bgx2OMtSYk+4w9X7DSfpCTHtpQUveF2pF8THl2FwRalbw8dXFXCFrsNAkbSq" +
       "XZK4v8UAV4hCQw4SSdqvV9Q6R6owa5Vbliow69ukZi2S9pt1axabX2h9AOzt" +
       "VYwRNV6cJgB7pxSsSBpG3AWwzOoCSO+qwumleVlpAdJ7pUhF0tCbp0fWQIfp" +
       "+r1TC34P21MkYcBI49z2AP59Evyjvl6ngIP91ZLAkVUfDpZyjrszYZG5olPF" +
       "bJ9u/01796V6vrfSHYTeBgqnhrkio41oGV9WpzvNrADjdMwel4n2cBh7gsr0" +
       "iIoODIlEJW3uYUncDzF4ADtXw9y2ElOs9/T8YOUHgUSM7+Kw76qcsUg0wMrn" +
       "R9YzaocktA9j8KiA9mOfmfY0jMJllMc49scqpy0SlbD6lSTuGQyeoKQxrVHn" +
       "eBiMJnx9EmM+5i7JmMxZYtyLfJzDf7xy5iJRCbsXJHG4eBM6QkkdMMejRphm" +
       "l8f56PjUNvrIJzjwJyrnLBKV8HpdEvefGPyOksnAubUtVq6uX/nMvJvdun6a" +
       "g3+6ct4iUQm3P0ri3sfgbexVgHeKrZMc8yj/4TNTnoFR2LCPcNxHKqcsEpXQ" +
       "+rMk7hMMjkMPBJR7LD2t47nt0H0e6w/Hr6KPcejHKmctEhUzC9dK4uoxCLkV" +
       "vbm4osPh8aGMq0kvcdwvVU5ZJCqhNV0SdwoGjZRMBcpdgVV0j/rU8aE+F643" +
       "OP43KqcuEpXQmyeJW4DB6TAGd6j7dmU84mPuHJwccRysvMvRv1s5cZGohNwy" +
       "SdxyDJY4vXZX8SaPx/zM8XFrWOXHOfzjlTMXiUrYXSCJuwiDlRQPVccVm3Xc" +
       "LJ3kJELdoGFkNCVXbki4d9TT17njoy90iB9x0h9Vri+RqEQnayVxMQzWUFKT" +
       "chbJwl/0CLeND2FsGp9y1J9WTlgkKiHVJ4nDpY9wNwxxdNvZx3eGdn7ePZ+Z" +
       "N87RyQKwoTonB+dXwJuFvhUb6J4mmZZBNZVqqcB5t0ZJngHSPivexZhL1mnC" +
       "KgYDrNkkLJg767l0QClXjtvsJtTMCTRXbAxCUQm1rCQOX1UNDzt+Mu6e7GAp" +
       "vRFvWP/MzNkbPzDSD/E9Jue3MuYiUQm7bZK4HRhQSupz2qjnJQOesWbE0FOe" +
       "IsY86D6mItg67vnAYgNns0GuiPDVpeYvEg2Q9RYznXWsY4y2ZDMhjOTDfw2j" +
       "BSWVivvWwcI7PRX8zfioYAXg5wv6oZLtgLFVIBIVe4CDjOFeCfs7MbiNkua8" +
       "mVKohq2hS6OWzrYW/CoYc71yTBWwpbU5gEznPPTKm4NINMCwhuFwDh3NomRO" +
       "2WXClk48isiMhDk9DL7DlPJticL2Y/AtGD7ktK2oLbeMs8Z4yY69UJ8bMjyN" +
       "3jNuA7HQQa6Wg5VrVCQqUcFBSdzDGPxA1qMcGLfZVuhRjv3RymmLRCXU/lUS" +
       "dwiDR5zZFrrV1tSIu6HrG3qPeUr7pGdboZ9y/D+tnLpIVELvSUncrzD4mTPb" +
       "QuqXFY5BecR/Pj7OYxGgfoqjf0pOvJz/FImO5T+fl7B/AYPnxqr4fx8f/gsA" +
       "1lFO4mjl/EWiY/F/TcL/dQxeltf+b6t4QxgGZ0WvJeMJoVkln9hxPgujPrhv" +
       "Wv1p+y79D+ccivvplilxUj+Uz2T8r8D67mtNSxvSmdqmOC/EsteRwm9TMk/u" +
       "yymZACHrIN9yZN6lZLZYBgb2hXu/1H9T0hSUomQi+/Wn+x9wp146fHGB3fiT" +
       "HAdMkARvPzTdLsn3nqDzDvGos4Fc2Llya4icOlYN+Ta7FhcdRGEfR3IPjeSd" +
       "zyMl1Yf2re/e8cEF33O+HaFmlO3bMZfJcVLnfMaCZYoHTxYKc3Pzql239OOp" +
       "ByctcbfPmh3AnrnP8cwRT+6HTLSV2YEPK9gthe8rvLh/9aFnd9ceDZPQlSSk" +
       "UDLjytK3rUfNvEXmXxkv9z7cRsVi33xY1fDGpuf+9FJouvveJZ7/mSeTSKp7" +
       "Dr2cGDLNvwuTSTEyUceVdvYqePu2XK+mjlhFr9fVDhr5XOEY1VQ0bAU/nMQ0" +
       "wxXaWHiK3x6hZFHpq4al32NpyBhbNWsN5o7ZNAaO6uRN0x/LNLsHg92jqGmw" +
       "tWS8yzT5O5a19zLNmyY23QmT8J+9/w8kvc3uAU0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDs2Fle3ztv9vFsxvZ48HhmPDPe2n7qvVs1trFa6k2t" +
       "rbW2hPFDLalb6tbW2lvGgE0Su3AVduHxkiqYUJWBBDBgqFAsYcDgEGxMALsc" +
       "MCRgA0nY7ARXyiwBh0jqvsu779175y3hVum0rs72fef/z3/+o6NzPvaV0q2+" +
       "Vyq7jrlZmE5wUUuCi0uzeTHYuJp/EcWalOz5mgqbsu+z2bNLyqs+ft9f//0H" +
       "9Pv3S7dJpRfLtu0EcmA4tk9rvmNGmoqV7jt62jM1yw9K92NLOZKBMDBMADP8" +
       "4GmsdPexrEHpSewAApBBADIIQAEBgI5SZZlepNmhBec5ZDvw16VvL+1hpdtc" +
       "JYcXlB6/vBBX9mRrVwxVMMhKuCP/n89IFZkTr/TYIfct5ysIf6gMPPORt9//" +
       "U7eU7pNK9xk2k8NRMhBBVolUusfSrJnm+ZCqaqpUesDWNJXRPEM2jbTALZUe" +
       "9I2FLQehpx02Uv4wdDWvqPOo5e5Rcm5eqASOd0hvbmimevDfrXNTXmRcX3rE" +
       "dcuwnz/PCN5lZMC8uaxoB1kurAxbDUqPnsxxyPHJcZYgy3q7pQW6c1jVBVvO" +
       "HpQe3MrOlO0FwASeYS+ypLc6YVZLUHr41ELztnZlZSUvtEtB6aGT6ahtVJbq" +
       "zqIh8ixB6SUnkxUlZVJ6+ISUjsnnK8Sbvucd9tDeLzCrmmLm+O/IMr3yRCZa" +
       "m2ueZivaNuM9r8c+LL/0+fful0pZ4pecSLxN8zPf9tW3vuGVn/jUNs03XiUN" +
       "OVtqSnBJeW5272dfAb8OvCWHcYfr+EYu/MuYF+pP7WKeTtys5730sMQ88uJB" +
       "5Cfo/yh+549of7lfumtUuk1xzNDK9OgBxbFcw9S8gWZrnhxo6qh0p2arcBE/" +
       "Kt2e3WOGrW2fkvO5rwWj0gWzeHSbU/yfNdE8KyJvotuze8OeOwf3rhzoxX3i" +
       "lkql27OrdE92PVna/hW/QckCdMfSAFmRbcN2AMpzcv65QG1VBgLNz+7VLNZ1" +
       "gFmm/6s3Vi+2Ad8JvUwhAcdbAHKmFbq2jcz7qWb7GWPAjxbAwNy4+ijIuTne" +
       "xVzt3H/qCpO8Be6P9/Yy4bzipGkws141dExV8y4pz4Td3ld//NJn9g+7yq7t" +
       "gtIbslovbmu9WNR68bDWi1mtFy+rtbS3V1T2DXntWy3IZLjKrEFmJ+95HfMt" +
       "6Le+91W3ZOrnxhcyAexnSYHTzTV8ZD9GhZVUMiUufeKj8bv476jsl/Yvt7s5" +
       "4uzRXXl2KreWh1bxyZP97Wrl3veeP/vrn/jwO52jnneZId8ZhCtz5h36VSfb" +
       "1nMUTc1M5FHxr39M/ulLz7/zyf3ShcxKZJYxkDNNzozOK0/WcVnHfvrASOZc" +
       "bs0Izx3Pks086sCy3RXonhMfPSmEfm9x/0DWxnfnmv5Qdi13ql/85rEvdvPw" +
       "G7ZKkgvtBIvCCL+Zcb//C7/55/WiuQ/s9X3HRkBGC54+ZiPywu4rrMEDRzrA" +
       "epqWpfuDj1If/NBX3vPNhQJkKZ64WoVP5iGc2Qa50Kh//qn1733xD5/7/P6h" +
       "0uwF2SAZzkxDSQ5J5s9Ld51BMqvt1Ud4MhtjZt0u15onOdtyVGNuyDNTy7X0" +
       "H+57qvrTX/6e+7d6YGZPDtToDecXcPT85d3Sd37m7X/zyqKYPSUf447a7CjZ" +
       "1nC++KhkyPPkTY4jedfnHvmXvyZ/f2aCM7PnG6lWWLL9XcfJQb0kKD1V5MwH" +
       "74tQkI1ns2wkU2E9azsl65IH3fIg9Wuv6MuLKLg4z5Tx4oBni57Ma7lyFzoB" +
       "FNleX4QX8/Ysqi4Vcc08eNQ/3rcu777HXJ1Lygc+/1cv4v/qF79aNMblvtJx" +
       "VcJl9+mt9ubBY0lW/MtOGpKh7OtZusYniLfdb37i77MSpaxEJTOPPulltiy5" +
       "TPF2qW+9/fd/+ZMv/dbP3lLa75fuMh1Z7ctFHy7dmXUezdczM5i43/TWre7E" +
       "d2TB/QXV0hXkiwcPX9m73r9TvPdfvXfl4eN58NSVOnta1hPNv7fV/qK8otTu" +
       "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" +
       "r/m0k3WbPkKyQcvvkQuj4ce6QQWzbqi3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "PyyOUft/G6kEPVtdAAA=");
}
