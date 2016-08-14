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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AzSh6tzMPNFr+2aNamIyy8/Q/JMZ4U4+fRgqS5kqKZbmkCLvM6lJMVIODCCy" +
       "es3xEE+Aca/5ZVWheMJifzPPPiU1nL8TAR9zvsQ/ZRLPJ3OFQU5OcMQJrSrx" +
       "bQ02LYxUikiXyUYJ8HVBMcAVLorqozd5Y/NrHk4IUyycVME5u6EZ4oZqXRjh" +
       "81SWoGE9dr4DixWE3qYLJr27XErxKGjOuKrKVFBOEgxD5BQEQ4xapBkmm2vi" +
       "NH/fZTAM+cXBmhLIgtNcqKowuyBdFpvmLyPb/8eQg8U5qDWSomomMiiwdIy7" +
       "jB3RTiV6LqIQboCGLs65zQF7FpXQu294uNgOD93vMjwg7EI+FTYdxXEAu0/D" +
       "ZnkJx76YU9uBzYoS5t9X4hsu+UO4kxJqNSkpAXvpLFw51MnbC0ugvQybDYzU" +
       "CbKsittUPdEncGFe5DjaxlPgaIvxWysQu9byjbUlHA2J+FCxWwUNDSgvrID2" +
       "fv/rLhjcekZHeuS9WnqU4vEuwr/GpYhNGxfXrhKiTGCzHQq7hIpy3KwI8l5D" +
       "MjzuXIvwC0ox7jhHKp9CVwff0cG5okpSDXaQlO0g8qwcJD1LB0lxqaRP5iBG" +
       "iW9ZbPbkHSRdykGmZuogjoHveC8MPId7pIX3pfBwf2nRdUzzCqF47+GG6iWH" +
       "L3varLfsa351sNJOZmXZffzseq/SdJqUuJbqzMNofl4VupKR0wJNhJEK/OF2" +
       "td+E/wQUMn7wUB5B64b8NCONXkioP/ivG+4zjNQ4cFCBmS9ukM8DdgDB12s1" +
       "27LP8SXbroXDPrVwzrSx5W598NXRopOp0bULs6agjuY3a+2FR3bQ2t06fnhr" +
       "/xWvf/Br5nUkURampxFLLZS85qUnq+T17pS5sdm4qnrb3p5339y19tKl4DqU" +
       "mzZuTGCj/OrQMs/9HKM1f03nmSObHvzlgarHocTfTkICFK3bi68+5LSsTpq3" +
       "x4rPT2FFwC8Otbd9ae9F65N/e9Y+cw8VXinxwsfFJ4/ufOL6pUdaykhtlFRK" +
       "oKccv5OxZa8yRMVJfYzUS0ZXDkgELFAhFxzOzkM7F/DOLZeLJc76fC/eU4No" +
       "V3wwXXy7rwZMmuodalbBwIsLlVqnx16bFGz4ZDXNM8Dpca1euB+Gc6gNMNh4" +
       "rE/T7EteNRs07u2Z4JR7O3/Ft6/8F9KM9Ex1LwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sGNKaweUCAcGloJNLa/N8xzfkEi72u+3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7MWAgbdyyBiRDDfr0YjmJFeUDCOP9A001ejNPKGVTc6OfMNBhCQY8rWUHlk0" +
       "MYQ4shFrVQJKJ3PWa6dzrIm1EKUzwrmRuLb9MWRv+1UkX40miErimDvtJmu2" +
       "09PMHlZvRPVGmxl3pqIS+mJvHAppHk6z5qLZ7YxE3g+4oKbMgcplc5UsYbna" +
       "IHlYmTTiWsvwrBDKFlsDwsKmN1/PedkNMpJhpGmnuZl7m+qs3g6mTbC1QjZe" +
       "qMBBE4a7u3o3HjpIbzN3cykB8l9BXDhhI6g7GLJ1owZ77pRTBtvcMeVw4Ksz" +
       "Y7amcHIIK3arU20y02gWbOAMCcezBkmmeIeLFa0r612w/xiBVXVZVdMOiKVe" +
       "lkYGSSNQYnBMK5hr8m5txQ7JD/2hqm6bXCbJnR3PCrQBbG1ak8Te2iQYErXI" +
       "LAexj22TUI9jJJ2h1XbLwCF9jox8AU5TUdy1w1Ri3cTXZEfBUrBVcISNl9Vb" +
       "CtnPEaknjoB4A1Wu6wlW7astc8SOLCQkoFmbiPURH9XaSUNCaL7NwRAZt6AO" +
       "2R2yXSKrMymKFo8lf+MO3xeWj3+PjlSunHbR8Pk7eCK6b3pTUTxz9Bi8/Ltc" +
       "Of/A0olDHZXiNfNj552ULF8xf/oDL7yocb9cP3zevowr98V+8Occfas7J4Yq" +
       "TgW/7fwn+Gx5UPT4kMZvfuDrj87eYb3nDo6hPXEK5+kh/z770m/336z+9YuV" +
       "u46ObNxyhPXmTs/dfFDj/lCPk9Cb3XRc47EjyT5eSOxZcL39QLJvP/2C4Vh3" +
       "Z79feeuJ9yu3OXD05du0/V5R/Ju48oCpx4dsFFX9Y5P5t6/0EP3kmGXFF454" +
       "LMl+urJ/1VU5/P0hebxQ8ngmexf3Qjh8tfHYuSdRRr6mH1I980O9yy3n++pt" +
       "RPbfiuI/7kVWTMEnXlQS/p0jth8oiK/cju1DTA+dPKS1P9D29WPR/6cfQ/SP" +
       "FpXFS/L3HWB430/QvC6VVJei275mKw/M7V+zvfgrT//u+158+r+UZ87utSNB" +
       "DtHQPONc9Yk+33rpK9/40qse+1x5RrN8B1h60ekD6beeN7/pGHkJ/8EjqTxZ" +
       "COE5cH3pQCrlb1zRfgKnfkPd0/RQD4tT6v7a9swzThf/mcxT8vy1I2VdODjd" +
       "e/TC63uHL2//9JW0f7S6XHZ0z4yts1683QUmLm6/G2Tn+efJMyWO7+nFgczD" +
       "tv3hZNu/fvTRAmjMzgT/hT34crKiePp8L73wwG3aiuM4F+6LK3erBZg99tuQ" +
       "Xz1wtmP/frpoewu43n9gRe8/y7e+fuzNZ3R9/qDr86/QFYjoiVJEchpfN3wv" +
       "vk6Cgi9t4OAjkLLL/7oNB48Ulf8zrtxbUC9COThLj/covu/osnccfr71Y4Sf" +
       "Mnd4DGjuvn3f/e+dRP6zI89Jy/rO0WwPHgTcS6P9bPvfuKL+mO4mB0EERVsT" +
       "JMZpBDyuWE7GtrrWw7Hs6c6hV/9ZTFMqsnKmXxROfeEtB059ofpDOnVR/KAc" +
       "tCjefKv3FtWXiuLy+e4Ipi17v5I7Nm7ThhRFceLhwkN7JLehbWUl2v0/z9yG" +
       "sFMUT8aVB2XH8dWFH2qsXIrnzUf2feFNP4Z9v76ovAZE8cyBfT/zk7Hvw5X1" +
       "wPXfevbHHkUY6AuzvrMLLEEvzmMX9F870ubrShlgt5EPWRQ/CxIQzS+Eg3qy" +
       "s4vs6JRflYnMa27H5SHQp87/KqUYn/IM/3zbpQ5tl/2RbHfwI9ouVUpi8Eq2" +
       "O7tNm1AU/JHtDm5nu+KBVZW29447sb2sOCJ387c9xccJj9zy6eD+czf1cy9e" +
       "ufcNL87/3T51Ovwk7T6mcq+ROM7Js+Qn7i8HoW7YpXzv258sD0rY744rP3Wu" +
       "cuPKpeKnQHzhXXt6GazpZ9GDTAGUJym1uHL1NCVYlcvfk3RmXLn/mA4kI/ub" +
       "kyQrMDogKW7XwaFN1s+EfZg+XT8jfcr21vHISZ8vl8KHX0ldJ3bAT9+UEpdf" +
       "gR7uMZPxwQG3z79Ij37h261f3n/Iozpynhej3Auy1/03RQfZ6+nDcidHOxzr" +
       "8uDZ7z/0q/c9c7infmgP+Dj+nMD2xNlfyhBuEJfftuT/9A3/+O1/98U/KA/G" +
       "/z8tvQfWnjsAAA==");
}
