package org.apache.batik.gvt.flow;
public class FlowTextPainter extends org.apache.batik.gvt.renderer.StrokingTextPainter {
    protected static org.apache.batik.gvt.TextPainter singleton = new org.apache.batik.gvt.flow.FlowTextPainter(
      );
    public static org.apache.batik.gvt.TextPainter getInstance() {
        return singleton;
    }
    public java.util.List getTextRuns(org.apache.batik.gvt.TextNode node,
                                      java.text.AttributedCharacterIterator aci) {
        java.util.List textRuns =
          node.
          getTextRuns(
            );
        if (textRuns !=
              null) {
            return textRuns;
        }
        java.text.AttributedCharacterIterator[] chunkACIs =
          getTextChunkACIs(
            aci);
        textRuns =
          computeTextRuns(
            node,
            aci,
            chunkACIs);
        aci.
          first(
            );
        java.util.List rgns =
          (java.util.List)
            aci.
            getAttribute(
              FLOW_REGIONS);
        if (rgns !=
              null) {
            java.util.Iterator i =
              textRuns.
              iterator(
                );
            java.util.List chunkLayouts =
              new java.util.ArrayList(
              );
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun tr =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                i.
                next(
                  );
            java.util.List layouts =
              new java.util.ArrayList(
              );
            chunkLayouts.
              add(
                layouts);
            layouts.
              add(
                tr.
                  getLayout(
                    ));
            while (i.
                     hasNext(
                       )) {
                tr =
                  (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                    i.
                    next(
                      );
                if (tr.
                      isFirstRunInChunk(
                        )) {
                    layouts =
                      new java.util.ArrayList(
                        );
                    chunkLayouts.
                      add(
                        layouts);
                }
                layouts.
                  add(
                    tr.
                      getLayout(
                        ));
            }
            textWrap(
              chunkACIs,
              chunkLayouts,
              rgns,
              fontRenderContext);
        }
        node.
          setTextRuns(
            textRuns);
        return node.
          getTextRuns(
            );
    }
    public static final char SOFT_HYPHEN = 173;
    public static final char ZERO_WIDTH_SPACE = 8203;
    public static final char ZERO_WIDTH_JOINER = 8205;
    public static final char SPACE = ' ';
    public static final java.text.AttributedCharacterIterator.Attribute
      WORD_LIMIT =
      org.apache.batik.gvt.flow.TextLineBreaks.
        WORD_LIMIT;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_REGIONS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_REGIONS;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      LINE_HEIGHT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LINE_HEIGHT;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    protected static java.util.Set szAtts = new java.util.HashSet(
      );
    static { szAtts.add(java.awt.font.TextAttribute.SIZE);
             szAtts.add(GVT_FONT);
             szAtts.add(LINE_HEIGHT); }
    public static boolean textWrap(java.text.AttributedCharacterIterator[] acis,
                                   java.util.List chunkLayouts,
                                   java.util.List flowRects,
                                   java.awt.font.FontRenderContext frc) {
        org.apache.batik.gvt.font.GVTGlyphVector[] gvs =
          new org.apache.batik.gvt.font.GVTGlyphVector[acis.
                                                         length];
        org.apache.batik.gvt.flow.WordInfo[][] wordInfos =
          new org.apache.batik.gvt.flow.WordInfo[acis.
                                                   length][];
        java.util.Iterator clIter =
          chunkLayouts.
          iterator(
            );
        float prevBotMargin =
          0;
        int numWords =
          0;
        org.apache.batik.gvt.flow.BlockInfo[] blockInfos =
          new org.apache.batik.gvt.flow.BlockInfo[acis.
                                                    length];
        float[] topSkip =
          new float[acis.
                      length];
        for (int chunk =
               0;
             clIter.
               hasNext(
                 );
             chunk++) {
            java.text.AttributedCharacterIterator aci =
              acis[chunk];
            java.util.List gvl =
              new java.util.LinkedList(
              );
            java.util.List layouts =
              (java.util.List)
                clIter.
                next(
                  );
            java.util.Iterator iter =
              layouts.
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                org.apache.batik.gvt.text.GlyphLayout gl =
                  (org.apache.batik.gvt.text.GlyphLayout)
                    iter.
                    next(
                      );
                gvl.
                  add(
                    gl.
                      getGlyphVector(
                        ));
            }
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              new org.apache.batik.gvt.font.MultiGlyphVector(
              gvl);
            gvs[chunk] =
              gv;
            wordInfos[chunk] =
              doWordAnalysis(
                gv,
                aci,
                numWords,
                frc);
            aci.
              first(
                );
            org.apache.batik.gvt.flow.BlockInfo bi =
              (org.apache.batik.gvt.flow.BlockInfo)
                aci.
                getAttribute(
                  FLOW_PARAGRAPH);
            bi.
              initLineInfo(
                frc);
            blockInfos[chunk] =
              bi;
            if (prevBotMargin >
                  bi.
                  getTopMargin(
                    ))
                topSkip[chunk] =
                  prevBotMargin;
            else
                topSkip[chunk] =
                  bi.
                    getTopMargin(
                      );
            prevBotMargin =
              bi.
                getBottomMargin(
                  );
            numWords +=
              wordInfos[chunk].
                length;
        }
        java.util.Iterator frIter =
          flowRects.
          iterator(
            );
        org.apache.batik.gvt.flow.RegionInfo currentRegion =
          null;
        int currWord =
          0;
        int chunk =
          0;
        java.util.List lineInfos =
          new java.util.LinkedList(
          );
        while (frIter.
                 hasNext(
                   )) {
            currentRegion =
              (org.apache.batik.gvt.flow.RegionInfo)
                frIter.
                next(
                  );
            org.apache.batik.gvt.flow.FlowRegions fr =
              new org.apache.batik.gvt.flow.FlowRegions(
              currentRegion.
                getShape(
                  ));
            while (chunk <
                     wordInfos.
                       length) {
                org.apache.batik.gvt.flow.WordInfo[] chunkInfo =
                  wordInfos[chunk];
                org.apache.batik.gvt.flow.BlockInfo bi =
                  blockInfos[chunk];
                org.apache.batik.gvt.flow.WordInfo wi =
                  chunkInfo[currWord];
                java.lang.Object flowLine =
                  wi.
                  getFlowLine(
                    );
                double lh =
                  java.lang.Math.
                  max(
                    wi.
                      getLineHeight(
                        ),
                    bi.
                      getLineHeight(
                        ));
                org.apache.batik.gvt.flow.LineInfo li =
                  new org.apache.batik.gvt.flow.LineInfo(
                  fr,
                  bi,
                  true);
                double newY =
                  li.
                  getCurrentY(
                    ) +
                  topSkip[chunk];
                topSkip[chunk] =
                  0;
                if (li.
                      gotoY(
                        newY))
                    break;
                while (!li.
                         addWord(
                           wi)) {
                    newY =
                      li.
                        getCurrentY(
                          ) +
                        lh *
                        0.1;
                    if (li.
                          gotoY(
                            newY))
                        break;
                }
                if (fr.
                      done(
                        ))
                    break;
                currWord++;
                for (;
                     currWord <
                       chunkInfo.
                         length;
                     currWord++) {
                    wi =
                      chunkInfo[currWord];
                    if (wi.
                          getFlowLine(
                            ) ==
                          flowLine &&
                          li.
                          addWord(
                            wi))
                        continue;
                    li.
                      layout(
                        );
                    lineInfos.
                      add(
                        li);
                    li =
                      null;
                    flowLine =
                      wi.
                        getFlowLine(
                          );
                    lh =
                      java.lang.Math.
                        max(
                          wi.
                            getLineHeight(
                              ),
                          bi.
                            getLineHeight(
                              ));
                    if (!fr.
                          newLine(
                            lh))
                        break;
                    li =
                      new org.apache.batik.gvt.flow.LineInfo(
                        fr,
                        bi,
                        false);
                    while (!li.
                             addWord(
                               wi)) {
                        newY =
                          li.
                            getCurrentY(
                              ) +
                            lh *
                            0.1;
                        if (li.
                              gotoY(
                                newY))
                            break;
                    }
                    if (fr.
                          done(
                            ))
                        break;
                }
                if (li !=
                      null) {
                    li.
                      setParaEnd(
                        true);
                    li.
                      layout(
                        );
                }
                if (fr.
                      done(
                        ))
                    break;
                chunk++;
                currWord =
                  0;
                if (bi.
                      isFlowRegionBreak(
                        ))
                    break;
                if (!fr.
                      newLine(
                        lh))
                    break;
            }
            if (chunk ==
                  wordInfos.
                    length)
                break;
        }
        boolean overflow =
          chunk <
          wordInfos.
            length;
        while (chunk <
                 wordInfos.
                   length) {
            org.apache.batik.gvt.flow.WordInfo[] chunkInfo =
              wordInfos[chunk];
            while (currWord <
                     chunkInfo.
                       length) {
                org.apache.batik.gvt.flow.WordInfo wi =
                  chunkInfo[currWord];
                int numGG =
                  wi.
                  getNumGlyphGroups(
                    );
                for (int gg =
                       0;
                     gg <
                       numGG;
                     gg++) {
                    org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
                      wi.
                      getGlyphGroup(
                        gg);
                    org.apache.batik.gvt.font.GVTGlyphVector gv =
                      ggi.
                      getGlyphVector(
                        );
                    int end =
                      ggi.
                      getEnd(
                        );
                    for (int g =
                           ggi.
                           getStart(
                             );
                         g <=
                           end;
                         g++) {
                        gv.
                          setGlyphVisible(
                            g,
                            false);
                    }
                }
                currWord++;
            }
            chunk++;
            currWord =
              0;
        }
        return overflow;
    }
    static int[] allocWordMap(int[] wordMap, int sz) { if (wordMap !=
                                                             null) {
                                                           if (sz <=
                                                                 wordMap.
                                                                   length) {
                                                               return wordMap;
                                                           }
                                                           if (sz <
                                                                 wordMap.
                                                                   length *
                                                                 2) {
                                                               sz =
                                                                 wordMap.
                                                                   length *
                                                                   2;
                                                           }
                                                       }
                                                       int[] ret =
                                                         new int[sz];
                                                       int ext =
                                                         wordMap !=
                                                         null
                                                         ? wordMap.
                                                             length
                                                         : 0;
                                                       if (sz <
                                                             ext) {
                                                           ext =
                                                             sz;
                                                       }
                                                       if (ext !=
                                                             0) {
                                                           java.lang.System.
                                                             arraycopy(
                                                               wordMap,
                                                               0,
                                                               ret,
                                                               0,
                                                               ext);
                                                       }
                                                       java.util.Arrays.
                                                         fill(
                                                           ret,
                                                           ext,
                                                           sz,
                                                           -1);
                                                       return ret;
    }
    static org.apache.batik.gvt.flow.WordInfo[] doWordAnalysis(org.apache.batik.gvt.font.GVTGlyphVector gv,
                                                               java.text.AttributedCharacterIterator aci,
                                                               int numWords,
                                                               java.awt.font.FontRenderContext frc) {
        int numGlyphs =
          gv.
          getNumGlyphs(
            );
        int[] glyphWords =
          new int[numGlyphs];
        int[] wordMap =
          allocWordMap(
            null,
            10);
        int maxWord =
          0;
        int aciIdx =
          aci.
          getBeginIndex(
            );
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int cnt =
              gv.
              getCharacterCount(
                i,
                i);
            aci.
              setIndex(
                aciIdx);
            java.lang.Integer integer =
              (java.lang.Integer)
                aci.
                getAttribute(
                  WORD_LIMIT);
            int minWord =
              integer.
              intValue(
                ) -
              numWords;
            if (minWord >
                  maxWord) {
                maxWord =
                  minWord;
                wordMap =
                  allocWordMap(
                    wordMap,
                    maxWord +
                      1);
            }
            aciIdx++;
            for (int c =
                   1;
                 c <
                   cnt;
                 c++) {
                aci.
                  setIndex(
                    aciIdx);
                integer =
                  (java.lang.Integer)
                    aci.
                    getAttribute(
                      WORD_LIMIT);
                int cWord =
                  integer.
                  intValue(
                    ) -
                  numWords;
                if (cWord >
                      maxWord) {
                    maxWord =
                      cWord;
                    wordMap =
                      allocWordMap(
                        wordMap,
                        maxWord +
                          1);
                }
                if (cWord <
                      minWord) {
                    wordMap[minWord] =
                      cWord;
                    minWord =
                      cWord;
                }
                else
                    if (cWord >
                          minWord) {
                        wordMap[cWord] =
                          minWord;
                    }
                aciIdx++;
            }
            glyphWords[i] =
              minWord;
        }
        int words =
          0;
        org.apache.batik.gvt.flow.WordInfo[] cWordMap =
          new org.apache.batik.gvt.flow.WordInfo[maxWord +
                                                   1];
        for (int i =
               0;
             i <=
               maxWord;
             i++) {
            int nw =
              wordMap[i];
            if (nw ==
                  -1) {
                cWordMap[i] =
                  new org.apache.batik.gvt.flow.WordInfo(
                    words++);
            }
            else {
                int word =
                  nw;
                nw =
                  wordMap[i];
                while (nw !=
                         -1) {
                    word =
                      nw;
                    nw =
                      wordMap[word];
                }
                wordMap[i] =
                  word;
                cWordMap[i] =
                  cWordMap[word];
            }
        }
        wordMap =
          null;
        org.apache.batik.gvt.flow.WordInfo[] wordInfos =
          new org.apache.batik.gvt.flow.WordInfo[words];
        for (int i =
               0;
             i <=
               maxWord;
             i++) {
            org.apache.batik.gvt.flow.WordInfo wi =
              cWordMap[i];
            wordInfos[wi.
                        getIndex(
                          )] =
              cWordMap[i];
        }
        aciIdx =
          aci.
            getBeginIndex(
              );
        int aciEnd =
          aci.
          getEndIndex(
            );
        char ch =
          aci.
          setIndex(
            aciIdx);
        int aciWordStart =
          aciIdx;
        org.apache.batik.gvt.font.GVTFont gvtFont =
          (org.apache.batik.gvt.font.GVTFont)
            aci.
            getAttribute(
              GVT_FONT);
        float lineHeight =
          1.0F;
        java.lang.Float lineHeightFloat =
          (java.lang.Float)
            aci.
            getAttribute(
              LINE_HEIGHT);
        if (lineHeightFloat !=
              null)
            lineHeight =
              lineHeightFloat.
                floatValue(
                  );
        int runLimit =
          aci.
          getRunLimit(
            szAtts);
        org.apache.batik.gvt.flow.WordInfo prevWI =
          null;
        float[] lastAdvAdj =
          new float[numGlyphs];
        float[] advAdj =
          new float[numGlyphs];
        boolean[] hideLast =
          new boolean[numGlyphs];
        boolean[] hide =
          new boolean[numGlyphs];
        boolean[] space =
          new boolean[numGlyphs];
        float[] glyphPos =
          gv.
          getGlyphPositions(
            0,
            numGlyphs +
              1,
            null);
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            char pch =
              ch;
            ch =
              aci.
                setIndex(
                  aciIdx);
            java.lang.Integer integer =
              (java.lang.Integer)
                aci.
                getAttribute(
                  WORD_LIMIT);
            org.apache.batik.gvt.flow.WordInfo theWI =
              cWordMap[integer.
                         intValue(
                           ) -
                         numWords];
            if (theWI.
                  getFlowLine(
                    ) ==
                  null)
                theWI.
                  setFlowLine(
                    aci.
                      getAttribute(
                        FLOW_LINE_BREAK));
            if (prevWI ==
                  null) {
                prevWI =
                  theWI;
            }
            else
                if (prevWI !=
                      theWI) {
                    org.apache.batik.gvt.font.GVTLineMetrics lm =
                      gvtFont.
                      getLineMetrics(
                        aci,
                        aciWordStart,
                        aciIdx,
                        frc);
                    prevWI.
                      addLineMetrics(
                        gvtFont,
                        lm);
                    prevWI.
                      addLineHeight(
                        lineHeight);
                    aciWordStart =
                      aciIdx;
                    prevWI =
                      theWI;
                }
            int chCnt =
              gv.
              getCharacterCount(
                i,
                i);
            if (chCnt ==
                  1) {
                char nch;
                float kern;
                switch (ch) {
                    case SOFT_HYPHEN:
                        hideLast[i] =
                          true;
                        nch =
                          aci.
                            next(
                              );
                        aci.
                          previous(
                            );
                        kern =
                          gvtFont.
                            getHKern(
                              pch,
                              nch);
                        advAdj[i] =
                          -(glyphPos[2 *
                                       i +
                                       2] -
                              glyphPos[2 *
                                         i] +
                              kern);
                        break;
                    case ZERO_WIDTH_JOINER:
                        hide[i] =
                          true;
                        break;
                    case ZERO_WIDTH_SPACE:
                        hide[i] =
                          true;
                        break;
                    case SPACE:
                        space[i] =
                          true;
                        nch =
                          aci.
                            next(
                              );
                        aci.
                          previous(
                            );
                        kern =
                          gvtFont.
                            getHKern(
                              pch,
                              nch);
                        lastAdvAdj[i] =
                          -(glyphPos[2 *
                                       i +
                                       2] -
                              glyphPos[2 *
                                         i] +
                              kern);
                    default:
                }
            }
            aciIdx +=
              chCnt;
            if (aciIdx >
                  runLimit &&
                  aciIdx <
                  aciEnd) {
                org.apache.batik.gvt.font.GVTLineMetrics lm =
                  gvtFont.
                  getLineMetrics(
                    aci,
                    aciWordStart,
                    runLimit,
                    frc);
                prevWI.
                  addLineMetrics(
                    gvtFont,
                    lm);
                prevWI.
                  addLineHeight(
                    lineHeight);
                prevWI =
                  null;
                aciWordStart =
                  aciIdx;
                aci.
                  setIndex(
                    aciIdx);
                gvtFont =
                  (org.apache.batik.gvt.font.GVTFont)
                    aci.
                    getAttribute(
                      GVT_FONT);
                java.lang.Float f =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      LINE_HEIGHT);
                lineHeight =
                  f.
                    floatValue(
                      );
                runLimit =
                  aci.
                    getRunLimit(
                      szAtts);
            }
        }
        org.apache.batik.gvt.font.GVTLineMetrics lm =
          gvtFont.
          getLineMetrics(
            aci,
            aciWordStart,
            runLimit,
            frc);
        prevWI.
          addLineMetrics(
            gvtFont,
            lm);
        prevWI.
          addLineHeight(
            lineHeight);
        int[] wordGlyphCounts =
          new int[words];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int word =
              glyphWords[i];
            int cWord =
              cWordMap[word].
              getIndex(
                );
            glyphWords[i] =
              cWord;
            wordGlyphCounts[cWord]++;
        }
        cWordMap =
          null;
        int[][] wordGlyphs =
          new int[words][];
        int[] wordGlyphGroupsCounts =
          new int[words];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int cWord =
              glyphWords[i];
            int[] wgs =
              wordGlyphs[cWord];
            if (wgs ==
                  null) {
                wgs =
                  (wordGlyphs[cWord] =
                     (new int[wordGlyphCounts[cWord]]));
                wordGlyphCounts[cWord] =
                  0;
            }
            int cnt =
              wordGlyphCounts[cWord];
            wgs[cnt] =
              i;
            if (cnt ==
                  0) {
                wordGlyphGroupsCounts[cWord]++;
            }
            else {
                if (wgs[cnt -
                          1] !=
                      i -
                      1)
                    wordGlyphGroupsCounts[cWord]++;
            }
            wordGlyphCounts[cWord]++;
        }
        for (int i =
               0;
             i <
               words;
             i++) {
            int cnt =
              wordGlyphGroupsCounts[i];
            org.apache.batik.gvt.flow.GlyphGroupInfo[] wordGlyphGroups =
              new org.apache.batik.gvt.flow.GlyphGroupInfo[cnt];
            if (cnt ==
                  1) {
                int[] glyphs =
                  wordGlyphs[i];
                int start =
                  glyphs[0];
                int end =
                  glyphs[glyphs.
                           length -
                           1];
                wordGlyphGroups[0] =
                  new org.apache.batik.gvt.flow.GlyphGroupInfo(
                    gv,
                    start,
                    end,
                    hide,
                    hideLast[end],
                    glyphPos,
                    advAdj,
                    lastAdvAdj,
                    space);
            }
            else {
                int glyphGroup =
                  0;
                int[] glyphs =
                  wordGlyphs[i];
                int prev =
                  glyphs[0];
                int start =
                  prev;
                for (int j =
                       1;
                     j <
                       glyphs.
                         length;
                     j++) {
                    if (prev +
                          1 !=
                          glyphs[j]) {
                        int end =
                          glyphs[j -
                                   1];
                        wordGlyphGroups[glyphGroup] =
                          new org.apache.batik.gvt.flow.GlyphGroupInfo(
                            gv,
                            start,
                            end,
                            hide,
                            hideLast[end],
                            glyphPos,
                            advAdj,
                            lastAdvAdj,
                            space);
                        start =
                          glyphs[j];
                        glyphGroup++;
                    }
                    prev =
                      glyphs[j];
                }
                int end =
                  glyphs[glyphs.
                           length -
                           1];
                wordGlyphGroups[glyphGroup] =
                  new org.apache.batik.gvt.flow.GlyphGroupInfo(
                    gv,
                    start,
                    end,
                    hide,
                    hideLast[end],
                    glyphPos,
                    advAdj,
                    lastAdvAdj,
                    space);
            }
            wordInfos[i].
              setGlyphGroups(
                wordGlyphGroups);
        }
        return wordInfos;
    }
    public FlowTextPainter() { super(); }
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
       "kTUGfjMynVncaUybNsateKofUpsZE6It");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
