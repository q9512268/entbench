package org.apache.batik.gvt.renderer;
public class StrokingTextPainter extends org.apache.batik.gvt.renderer.BasicTextPainter {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_REGIONS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_REGIONS;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONTS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONTS;
    public static final java.text.AttributedCharacterIterator.Attribute
      BIDI_LEVEL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        BIDI_LEVEL;
    public static final java.text.AttributedCharacterIterator.Attribute
      XPOS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        X;
    public static final java.text.AttributedCharacterIterator.Attribute
      YPOS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        Y;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    public static final java.text.AttributedCharacterIterator.Attribute
      WRITING_MODE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WRITING_MODE;
    public static final java.lang.Integer WRITING_MODE_TTB = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                               WRITING_MODE_TTB;
    public static final java.lang.Integer WRITING_MODE_RTL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WRITING_MODE_RTL;
    public static final java.text.AttributedCharacterIterator.Attribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    public static final java.lang.Integer ADJUST_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ADJUST_SPACING;
    public static final java.lang.Integer ADJUST_ALL = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                         ADJUST_ALL;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      ALT_GLYPH_HANDLER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ALT_GLYPH_HANDLER;
    static java.util.Set extendedAtts = new java.util.HashSet(
      );
    static { extendedAtts.add(FLOW_PARAGRAPH);
             extendedAtts.add(TEXT_COMPOUND_ID);
             extendedAtts.add(GVT_FONT); }
    protected static org.apache.batik.gvt.TextPainter
      singleton =
      new org.apache.batik.gvt.renderer.StrokingTextPainter(
      );
    public static org.apache.batik.gvt.TextPainter getInstance() {
        return singleton;
    }
    public void paint(org.apache.batik.gvt.TextNode node,
                      java.awt.Graphics2D g2d) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        paintDecorations(
          textRuns,
          g2d,
          org.apache.batik.gvt.text.TextSpanLayout.
            DECORATION_UNDERLINE);
        paintDecorations(
          textRuns,
          g2d,
          org.apache.batik.gvt.text.TextSpanLayout.
            DECORATION_OVERLINE);
        paintTextRuns(
          textRuns,
          g2d);
        paintDecorations(
          textRuns,
          g2d,
          org.apache.batik.gvt.text.TextSpanLayout.
            DECORATION_STRIKETHROUGH);
    }
    protected void printAttrs(java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        int start =
          aci.
          getBeginIndex(
            );
        java.lang.System.
          out.
          print(
            "AttrRuns: ");
        while (aci.
                 current(
                   ) !=
                 java.text.CharacterIterator.
                   DONE) {
            int end =
              aci.
              getRunLimit(
                );
            java.lang.System.
              out.
              print(
                "" +
                (end -
                   start) +
                ", ");
            aci.
              setIndex(
                end);
            start =
              end;
        }
        java.lang.System.
          out.
          println(
            "");
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
        node.
          setTextRuns(
            textRuns);
        return node.
          getTextRuns(
            );
    }
    public java.util.List computeTextRuns(org.apache.batik.gvt.TextNode node,
                                          java.text.AttributedCharacterIterator aci,
                                          java.text.AttributedCharacterIterator[] chunkACIs) {
        int[][] chunkCharMaps =
          new int[chunkACIs.
                    length][];
        int chunkStart =
          aci.
          getBeginIndex(
            );
        for (int i =
               0;
             i <
               chunkACIs.
                 length;
             i++) {
            org.apache.batik.gvt.text.BidiAttributedCharacterIterator iter;
            iter =
              new org.apache.batik.gvt.text.BidiAttributedCharacterIterator(
                chunkACIs[i],
                fontRenderContext,
                chunkStart);
            chunkACIs[i] =
              iter;
            chunkCharMaps[i] =
              iter.
                getCharMap(
                  );
            chunkACIs[i] =
              createModifiedACIForFontMatching(
                chunkACIs[i]);
            chunkStart +=
              chunkACIs[i].
                getEndIndex(
                  ) -
                chunkACIs[i].
                getBeginIndex(
                  );
        }
        java.util.List textRuns =
          new java.util.ArrayList(
          );
        org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk chunk;
        org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk prevChunk =
          null;
        int currentChunk =
          0;
        java.awt.geom.Point2D location =
          node.
          getLocation(
            );
        do  {
            chunkACIs[currentChunk].
              first(
                );
            chunk =
              getTextChunk(
                node,
                chunkACIs[currentChunk],
                chunkCharMaps[currentChunk],
                textRuns,
                prevChunk);
            chunkACIs[currentChunk].
              first(
                );
            if (chunk !=
                  null) {
                location =
                  adjustChunkOffsets(
                    location,
                    textRuns,
                    chunk);
            }
            prevChunk =
              chunk;
            currentChunk++;
        }while(chunk !=
                 null &&
                 currentChunk <
                 chunkACIs.
                   length); 
        return textRuns;
    }
    protected java.text.AttributedCharacterIterator[] getTextChunkACIs(java.text.AttributedCharacterIterator aci) {
        java.util.List aciList =
          new java.util.ArrayList(
          );
        int chunkStartIndex =
          aci.
          getBeginIndex(
            );
        aci.
          first(
            );
        java.lang.Object writingMode =
          aci.
          getAttribute(
            WRITING_MODE);
        boolean vertical =
          writingMode ==
          WRITING_MODE_TTB;
        while (aci.
                 setIndex(
                   chunkStartIndex) !=
                 java.text.CharacterIterator.
                   DONE) {
            org.apache.batik.gvt.text.TextPath prevTextPath =
              null;
            for (int start =
                   chunkStartIndex,
                   end =
                     0;
                 aci.
                   setIndex(
                     start) !=
                   java.text.CharacterIterator.
                     DONE;
                 start =
                   end) {
                org.apache.batik.gvt.text.TextPath textPath =
                  (org.apache.batik.gvt.text.TextPath)
                    aci.
                    getAttribute(
                      TEXTPATH);
                if (start !=
                      chunkStartIndex) {
                    if (vertical) {
                        java.lang.Float runY =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              YPOS);
                        if (runY !=
                              null &&
                              !runY.
                              isNaN(
                                ))
                            break;
                    }
                    else {
                        java.lang.Float runX =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              XPOS);
                        if (runX !=
                              null &&
                              !runX.
                              isNaN(
                                ))
                            break;
                    }
                    if (prevTextPath ==
                          null &&
                          textPath !=
                          null)
                        break;
                    if (prevTextPath !=
                          null &&
                          textPath ==
                          null)
                        break;
                }
                prevTextPath =
                  textPath;
                if (aci.
                      getAttribute(
                        FLOW_PARAGRAPH) !=
                      null) {
                    end =
                      aci.
                        getRunLimit(
                          FLOW_PARAGRAPH);
                    aci.
                      setIndex(
                        end);
                    break;
                }
                end =
                  aci.
                    getRunLimit(
                      TEXT_COMPOUND_ID);
                if (start !=
                      chunkStartIndex)
                    continue;
                org.apache.batik.gvt.TextNode.Anchor anchor;
                anchor =
                  (org.apache.batik.gvt.TextNode.Anchor)
                    aci.
                    getAttribute(
                      ANCHOR_TYPE);
                if (anchor ==
                      org.apache.batik.gvt.TextNode.Anchor.
                        START)
                    continue;
                if (vertical) {
                    java.lang.Float runY =
                      (java.lang.Float)
                        aci.
                        getAttribute(
                          YPOS);
                    if (runY ==
                          null ||
                          runY.
                          isNaN(
                            ))
                        continue;
                }
                else {
                    java.lang.Float runX =
                      (java.lang.Float)
                        aci.
                        getAttribute(
                          XPOS);
                    if (runX ==
                          null ||
                          runX.
                          isNaN(
                            ))
                        continue;
                }
                for (int i =
                       start +
                       1;
                     i <
                       end;
                     i++) {
                    aci.
                      setIndex(
                        i);
                    if (vertical) {
                        java.lang.Float runY =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              YPOS);
                        if (runY ==
                              null ||
                              runY.
                              isNaN(
                                ))
                            break;
                    }
                    else {
                        java.lang.Float runX =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              XPOS);
                        if (runX ==
                              null ||
                              runX.
                              isNaN(
                                ))
                            break;
                    }
                    aciList.
                      add(
                        new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                          aci,
                          i -
                            1,
                          i));
                    chunkStartIndex =
                      i;
                }
            }
            int chunkEndIndex =
              aci.
              getIndex(
                );
            aciList.
              add(
                new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                  aci,
                  chunkStartIndex,
                  chunkEndIndex));
            chunkStartIndex =
              chunkEndIndex;
        }
        java.text.AttributedCharacterIterator[] aciArray =
          new java.text.AttributedCharacterIterator[aciList.
                                                      size(
                                                        )];
        java.util.Iterator iter =
          aciList.
          iterator(
            );
        for (int i =
               0;
             iter.
               hasNext(
                 );
             ++i) {
            aciArray[i] =
              (java.text.AttributedCharacterIterator)
                iter.
                next(
                  );
        }
        return aciArray;
    }
    protected static java.text.AttributedCharacterIterator createModifiedACIForFontMatching(java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        java.text.AttributedString as =
          null;
        int asOff =
          0;
        int begin =
          aci.
          getBeginIndex(
            );
        boolean moreChunks =
          true;
        int start;
        int end =
          aci.
          getRunStart(
            TEXT_COMPOUND_ID);
        while (moreChunks) {
            start =
              end;
            end =
              aci.
                getRunLimit(
                  TEXT_COMPOUND_ID);
            int aciLength =
              end -
              start;
            java.util.List fonts;
            fonts =
              (java.util.List)
                aci.
                getAttribute(
                  GVT_FONTS);
            float fontSize =
              12;
            java.lang.Float fsFloat =
              (java.lang.Float)
                aci.
                getAttribute(
                  java.awt.font.TextAttribute.
                    SIZE);
            if (fsFloat !=
                  null)
                fontSize =
                  fsFloat.
                    floatValue(
                      );
            if (fonts.
                  size(
                    ) ==
                  0) {
                fonts.
                  add(
                    org.apache.batik.gvt.font.FontFamilyResolver.
                      defaultFont.
                      deriveFont(
                        fontSize,
                        aci));
            }
            boolean[] fontAssigned =
              new boolean[aciLength];
            if (as ==
                  null)
                as =
                  new java.text.AttributedString(
                    aci);
            org.apache.batik.gvt.font.GVTFont defaultFont =
              null;
            int numSet =
              0;
            int firstUnset =
              start;
            boolean firstUnsetSet;
            for (int i =
                   0;
                 i <
                   fonts.
                   size(
                     );
                 i++) {
                int currentIndex =
                  firstUnset;
                firstUnsetSet =
                  false;
                aci.
                  setIndex(
                    currentIndex);
                org.apache.batik.gvt.font.GVTFont font =
                  (org.apache.batik.gvt.font.GVTFont)
                    fonts.
                    get(
                      i);
                if (defaultFont ==
                      null)
                    defaultFont =
                      font;
                while (currentIndex <
                         end) {
                    int displayUpToIndex =
                      font.
                      canDisplayUpTo(
                        aci,
                        currentIndex,
                        end);
                    java.lang.Object altGlyphElement;
                    altGlyphElement =
                      aci.
                        getAttribute(
                          ALT_GLYPH_HANDLER);
                    if (altGlyphElement !=
                          null) {
                        displayUpToIndex =
                          -1;
                    }
                    if (displayUpToIndex ==
                          -1) {
                        displayUpToIndex =
                          end;
                    }
                    if (displayUpToIndex <=
                          currentIndex) {
                        if (!firstUnsetSet) {
                            firstUnset =
                              currentIndex;
                            firstUnsetSet =
                              true;
                        }
                        currentIndex++;
                    }
                    else {
                        int runStart =
                          -1;
                        for (int j =
                               currentIndex;
                             j <
                               displayUpToIndex;
                             j++) {
                            if (fontAssigned[j -
                                               start]) {
                                if (runStart !=
                                      -1) {
                                    as.
                                      addAttribute(
                                        GVT_FONT,
                                        font,
                                        runStart -
                                          begin,
                                        j -
                                          begin);
                                    runStart =
                                      -1;
                                }
                            }
                            else {
                                if (runStart ==
                                      -1)
                                    runStart =
                                      j;
                            }
                            fontAssigned[j -
                                           start] =
                              true;
                            numSet++;
                        }
                        if (runStart !=
                              -1) {
                            as.
                              addAttribute(
                                GVT_FONT,
                                font,
                                runStart -
                                  begin,
                                displayUpToIndex -
                                  begin);
                        }
                        currentIndex =
                          displayUpToIndex +
                            1;
                    }
                }
                if (numSet ==
                      aciLength)
                    break;
            }
            int runStart =
              -1;
            org.apache.batik.gvt.font.GVTFontFamily prevFF =
              null;
            org.apache.batik.gvt.font.GVTFont prevF =
              defaultFont;
            for (int i =
                   0;
                 i <
                   aciLength;
                 i++) {
                if (fontAssigned[i]) {
                    if (runStart !=
                          -1) {
                        as.
                          addAttribute(
                            GVT_FONT,
                            prevF,
                            runStart +
                              asOff,
                            i +
                              asOff);
                        runStart =
                          -1;
                        prevF =
                          null;
                        prevFF =
                          null;
                    }
                }
                else {
                    char c =
                      aci.
                      setIndex(
                        start +
                          i);
                    org.apache.batik.gvt.font.GVTFontFamily fontFamily;
                    fontFamily =
                      org.apache.batik.gvt.font.FontFamilyResolver.
                        getFamilyThatCanDisplay(
                          c);
                    if (runStart ==
                          -1) {
                        runStart =
                          i;
                        prevFF =
                          fontFamily;
                        if (prevFF ==
                              null)
                            prevF =
                              defaultFont;
                        else
                            prevF =
                              fontFamily.
                                deriveFont(
                                  fontSize,
                                  aci);
                    }
                    else
                        if (prevFF !=
                              fontFamily) {
                            as.
                              addAttribute(
                                GVT_FONT,
                                prevF,
                                runStart +
                                  asOff,
                                i +
                                  asOff);
                            runStart =
                              i;
                            prevFF =
                              fontFamily;
                            if (prevFF ==
                                  null)
                                prevF =
                                  defaultFont;
                            else
                                prevF =
                                  fontFamily.
                                    deriveFont(
                                      fontSize,
                                      aci);
                        }
                }
            }
            if (runStart !=
                  -1) {
                as.
                  addAttribute(
                    GVT_FONT,
                    prevF,
                    runStart +
                      asOff,
                    aciLength +
                      asOff);
            }
            asOff +=
              aciLength;
            if (aci.
                  setIndex(
                    end) ==
                  java.text.AttributedCharacterIterator.
                    DONE) {
                moreChunks =
                  false;
            }
            start =
              end;
        }
        if (as !=
              null)
            return as.
              getIterator(
                );
        return aci;
    }
    protected org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk getTextChunk(org.apache.batik.gvt.TextNode node,
                                                                                       java.text.AttributedCharacterIterator aci,
                                                                                       int[] charMap,
                                                                                       java.util.List textRuns,
                                                                                       org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk prevChunk) {
        int beginChunk =
          0;
        if (prevChunk !=
              null)
            beginChunk =
              prevChunk.
                end;
        int endChunk =
          beginChunk;
        int begin =
          aci.
          getIndex(
            );
        if (aci.
              current(
                ) ==
              java.text.CharacterIterator.
                DONE)
            return null;
        java.awt.geom.Point2D.Float offset =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        java.awt.geom.Point2D.Float advance =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        boolean isChunkStart =
          true;
        org.apache.batik.gvt.text.TextSpanLayout layout =
          null;
        do  {
            int start =
              aci.
              getRunStart(
                extendedAtts);
            int end =
              aci.
              getRunLimit(
                extendedAtts);
            java.text.AttributedCharacterIterator runaci;
            runaci =
              new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                aci,
                start,
                end);
            int[] subCharMap =
              new int[end -
                        start];
            java.lang.System.
              arraycopy(
                charMap,
                start -
                  begin,
                subCharMap,
                0,
                subCharMap.
                  length);
            java.awt.font.FontRenderContext frc =
              fontRenderContext;
            java.awt.RenderingHints rh =
              node.
              getRenderingHints(
                );
            if (rh !=
                  null &&
                  rh.
                  get(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING) ==
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_OFF) {
                frc =
                  aaOffFontRenderContext;
            }
            layout =
              getTextLayoutFactory(
                ).
                createTextLayout(
                  runaci,
                  subCharMap,
                  offset,
                  frc);
            textRuns.
              add(
                new org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun(
                  layout,
                  runaci,
                  isChunkStart));
            java.awt.geom.Point2D layoutAdvance =
              layout.
              getAdvance2D(
                );
            advance.
              x +=
              (float)
                layoutAdvance.
                getX(
                  );
            advance.
              y +=
              (float)
                layoutAdvance.
                getY(
                  );
            ++endChunk;
            if (aci.
                  setIndex(
                    end) ==
                  java.text.CharacterIterator.
                    DONE)
                break;
            isChunkStart =
              false;
        }while(true); 
        return new org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk(
          beginChunk,
          endChunk,
          advance);
    }
    protected java.awt.geom.Point2D adjustChunkOffsets(java.awt.geom.Point2D location,
                                                       java.util.List textRuns,
                                                       org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk chunk) {
        org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun r =
          (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
            textRuns.
            get(
              chunk.
                begin);
        int anchorType =
          r.
          getAnchorType(
            );
        java.lang.Float length =
          r.
          getLength(
            );
        java.lang.Integer lengthAdj =
          r.
          getLengthAdjust(
            );
        boolean doAdjust =
          true;
        if (length ==
              null ||
              length.
              isNaN(
                ))
            doAdjust =
              false;
        int numChars =
          0;
        for (int n =
               chunk.
                 begin;
             n <
               chunk.
                 end;
             ++n) {
            r =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  n);
            java.text.AttributedCharacterIterator aci =
              r.
              getACI(
                );
            numChars +=
              aci.
                getEndIndex(
                  ) -
                aci.
                getBeginIndex(
                  );
        }
        if (lengthAdj ==
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                ADJUST_SPACING &&
              numChars ==
              1)
            doAdjust =
              false;
        float xScale =
          1;
        float yScale =
          1;
        r =
          (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
            textRuns.
            get(
              chunk.
                end -
                1);
        org.apache.batik.gvt.text.TextSpanLayout layout =
          r.
          getLayout(
            );
        org.apache.batik.gvt.font.GVTGlyphMetrics lastMetrics =
          layout.
          getGlyphMetrics(
            layout.
              getGlyphCount(
                ) -
              1);
        org.apache.batik.gvt.font.GVTLineMetrics lastLineMetrics =
          layout.
          getLineMetrics(
            );
        java.awt.geom.Rectangle2D lastBounds =
          lastMetrics.
          getBounds2D(
            );
        float halfLeading =
          (lastMetrics.
             getVerticalAdvance(
               ) -
             (lastLineMetrics.
                getAscent(
                  ) +
                lastLineMetrics.
                getDescent(
                  ))) /
          2;
        float lastW =
          (float)
            (lastBounds.
               getWidth(
                 ) +
               lastBounds.
               getX(
                 ));
        float lastH =
          (float)
            (halfLeading +
               lastLineMetrics.
               getAscent(
                 ) +
               (lastBounds.
                  getHeight(
                    ) +
                  lastBounds.
                  getY(
                    )));
        java.awt.geom.Point2D visualAdvance;
        if (!doAdjust) {
            visualAdvance =
              new java.awt.geom.Point2D.Float(
                (float)
                  (chunk.
                     advance.
                     getX(
                       ) +
                     lastW -
                     lastMetrics.
                     getHorizontalAdvance(
                       )),
                (float)
                  (chunk.
                     advance.
                     getY(
                       ) -
                     lastMetrics.
                     getVerticalAdvance(
                       ) +
                     lastH));
        }
        else {
            java.awt.geom.Point2D advance =
              chunk.
                advance;
            if (layout.
                  isVertical(
                    )) {
                if (lengthAdj ==
                      ADJUST_SPACING) {
                    yScale =
                      (float)
                        ((length.
                            floatValue(
                              ) -
                            lastH) /
                           (advance.
                              getY(
                                ) -
                              lastMetrics.
                              getVerticalAdvance(
                                )));
                }
                else {
                    double adv =
                      advance.
                      getY(
                        ) -
                      lastMetrics.
                      getVerticalAdvance(
                        ) +
                      lastH;
                    yScale =
                      (float)
                        (length.
                           floatValue(
                             ) /
                           adv);
                }
                visualAdvance =
                  new java.awt.geom.Point2D.Float(
                    0,
                    length.
                      floatValue(
                        ));
            }
            else {
                if (lengthAdj ==
                      ADJUST_SPACING) {
                    xScale =
                      (float)
                        ((length.
                            floatValue(
                              ) -
                            lastW) /
                           (advance.
                              getX(
                                ) -
                              lastMetrics.
                              getHorizontalAdvance(
                                )));
                }
                else {
                    double adv =
                      advance.
                      getX(
                        ) +
                      lastW -
                      lastMetrics.
                      getHorizontalAdvance(
                        );
                    xScale =
                      (float)
                        (length.
                           floatValue(
                             ) /
                           adv);
                }
                visualAdvance =
                  new java.awt.geom.Point2D.Float(
                    length.
                      floatValue(
                        ),
                    0);
            }
            java.awt.geom.Point2D.Float adv =
              new java.awt.geom.Point2D.Float(
              0,
              0);
            for (int n =
                   chunk.
                     begin;
                 n <
                   chunk.
                     end;
                 ++n) {
                r =
                  (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                    textRuns.
                    get(
                      n);
                layout =
                  r.
                    getLayout(
                      );
                layout.
                  setScale(
                    xScale,
                    yScale,
                    lengthAdj ==
                      ADJUST_SPACING);
                java.awt.geom.Point2D lAdv =
                  layout.
                  getAdvance2D(
                    );
                adv.
                  x +=
                  (float)
                    lAdv.
                    getX(
                      );
                adv.
                  y +=
                  (float)
                    lAdv.
                    getY(
                      );
            }
            chunk.
              advance =
              adv;
        }
        float dx =
          0.0F;
        float dy =
          0.0F;
        switch (anchorType) {
            case org.apache.batik.gvt.TextNode.Anchor.
                   ANCHOR_MIDDLE:
                dx =
                  (float)
                    (-visualAdvance.
                       getX(
                         ) /
                       2.0);
                dy =
                  (float)
                    (-visualAdvance.
                       getY(
                         ) /
                       2.0);
                break;
            case org.apache.batik.gvt.TextNode.Anchor.
                   ANCHOR_END:
                dx =
                  (float)
                    -visualAdvance.
                    getX(
                      );
                dy =
                  (float)
                    -visualAdvance.
                    getY(
                      );
                break;
            default:
                break;
        }
        r =
          (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
            textRuns.
            get(
              chunk.
                begin);
        layout =
          r.
            getLayout(
              );
        java.text.AttributedCharacterIterator runaci =
          r.
          getACI(
            );
        runaci.
          first(
            );
        boolean vertical =
          layout.
          isVertical(
            );
        java.lang.Float runX =
          (java.lang.Float)
            runaci.
            getAttribute(
              XPOS);
        java.lang.Float runY =
          (java.lang.Float)
            runaci.
            getAttribute(
              YPOS);
        org.apache.batik.gvt.text.TextPath textPath =
          (org.apache.batik.gvt.text.TextPath)
            runaci.
            getAttribute(
              TEXTPATH);
        float absX =
          (float)
            location.
            getX(
              );
        float absY =
          (float)
            location.
            getY(
              );
        float tpShiftX =
          0;
        float tpShiftY =
          0;
        if (runX !=
              null &&
              !runX.
              isNaN(
                )) {
            absX =
              runX.
                floatValue(
                  );
            tpShiftX =
              absX;
        }
        if (runY !=
              null &&
              !runY.
              isNaN(
                )) {
            absY =
              runY.
                floatValue(
                  );
            tpShiftY =
              absY;
        }
        if (vertical) {
            absY +=
              dy;
            tpShiftY +=
              dy;
            tpShiftX =
              0;
        }
        else {
            absX +=
              dx;
            tpShiftX +=
              dx;
            tpShiftY =
              0;
        }
        for (int n =
               chunk.
                 begin;
             n <
               chunk.
                 end;
             ++n) {
            r =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  n);
            layout =
              r.
                getLayout(
                  );
            runaci =
              r.
                getACI(
                  );
            runaci.
              first(
                );
            textPath =
              (org.apache.batik.gvt.text.TextPath)
                runaci.
                getAttribute(
                  TEXTPATH);
            if (vertical) {
                runX =
                  (java.lang.Float)
                    runaci.
                    getAttribute(
                      XPOS);
                if (runX !=
                      null &&
                      !runX.
                      isNaN(
                        )) {
                    absX =
                      runX.
                        floatValue(
                          );
                }
            }
            else {
                runY =
                  (java.lang.Float)
                    runaci.
                    getAttribute(
                      YPOS);
                if (runY !=
                      null &&
                      !runY.
                      isNaN(
                        )) {
                    absY =
                      runY.
                        floatValue(
                          );
                }
            }
            if (textPath ==
                  null) {
                layout.
                  setOffset(
                    new java.awt.geom.Point2D.Float(
                      absX,
                      absY));
                java.awt.geom.Point2D ladv =
                  layout.
                  getAdvance2D(
                    );
                absX +=
                  ladv.
                    getX(
                      );
                absY +=
                  ladv.
                    getY(
                      );
            }
            else {
                layout.
                  setOffset(
                    new java.awt.geom.Point2D.Float(
                      tpShiftX,
                      tpShiftY));
                java.awt.geom.Point2D ladv =
                  layout.
                  getAdvance2D(
                    );
                tpShiftX +=
                  (float)
                    ladv.
                    getX(
                      );
                tpShiftY +=
                  (float)
                    ladv.
                    getY(
                      );
                ladv =
                  layout.
                    getTextPathAdvance(
                      );
                absX =
                  (float)
                    ladv.
                    getX(
                      );
                absY =
                  (float)
                    ladv.
                    getY(
                      );
            }
        }
        return new java.awt.geom.Point2D.Float(
          absX,
          absY);
    }
    protected void paintDecorations(java.util.List textRuns,
                                    java.awt.Graphics2D g2d,
                                    int decorationType) {
        java.awt.Paint prevPaint =
          null;
        java.awt.Paint prevStrokePaint =
          null;
        java.awt.Stroke prevStroke =
          null;
        java.awt.geom.Rectangle2D decorationRect =
          null;
        double yLoc =
          0;
        double height =
          0;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null &&
                  tpi.
                    composite !=
                  null) {
                g2d.
                  setComposite(
                    tpi.
                      composite);
            }
            java.awt.Paint paint =
              null;
            java.awt.Stroke stroke =
              null;
            java.awt.Paint strokePaint =
              null;
            if (tpi !=
                  null) {
                switch (decorationType) {
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_UNDERLINE:
                        paint =
                          tpi.
                            underlinePaint;
                        stroke =
                          tpi.
                            underlineStroke;
                        strokePaint =
                          tpi.
                            underlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_OVERLINE:
                        paint =
                          tpi.
                            overlinePaint;
                        stroke =
                          tpi.
                            overlineStroke;
                        strokePaint =
                          tpi.
                            overlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_STRIKETHROUGH:
                        paint =
                          tpi.
                            strikethroughPaint;
                        stroke =
                          tpi.
                            strikethroughStroke;
                        strokePaint =
                          tpi.
                            strikethroughStrokePaint;
                        break;
                    default:
                        return;
                }
            }
            if (textRun.
                  isFirstRunInChunk(
                    )) {
                java.awt.Shape s =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                java.awt.geom.Rectangle2D r2d =
                  s.
                  getBounds2D(
                    );
                yLoc =
                  r2d.
                    getY(
                      );
                height =
                  r2d.
                    getHeight(
                      );
            }
            if (textRun.
                  isFirstRunInChunk(
                    ) ||
                  paint !=
                  prevPaint ||
                  stroke !=
                  prevStroke ||
                  strokePaint !=
                  prevStrokePaint) {
                if (decorationRect !=
                      null) {
                    if (prevPaint !=
                          null) {
                        g2d.
                          setPaint(
                            prevPaint);
                        g2d.
                          fill(
                            decorationRect);
                    }
                    if (prevStroke !=
                          null &&
                          prevStrokePaint !=
                          null) {
                        g2d.
                          setPaint(
                            prevStrokePaint);
                        g2d.
                          setStroke(
                            prevStroke);
                        g2d.
                          draw(
                            decorationRect);
                    }
                    decorationRect =
                      null;
                }
            }
            if ((paint !=
                   null ||
                   strokePaint !=
                   null) &&
                  !textRun.
                  getLayout(
                    ).
                  isVertical(
                    ) &&
                  !textRun.
                  getLayout(
                    ).
                  isOnATextPath(
                    )) {
                java.awt.Shape decorationShape =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                if (decorationRect ==
                      null) {
                    java.awt.geom.Rectangle2D r2d =
                      decorationShape.
                      getBounds2D(
                        );
                    decorationRect =
                      new java.awt.geom.Rectangle2D.Double(
                        r2d.
                          getX(
                            ),
                        yLoc,
                        r2d.
                          getWidth(
                            ),
                        height);
                }
                else {
                    java.awt.geom.Rectangle2D bounds =
                      decorationShape.
                      getBounds2D(
                        );
                    double minX =
                      java.lang.Math.
                      min(
                        decorationRect.
                          getX(
                            ),
                        bounds.
                          getX(
                            ));
                    double maxX =
                      java.lang.Math.
                      max(
                        decorationRect.
                          getMaxX(
                            ),
                        bounds.
                          getMaxX(
                            ));
                    decorationRect.
                      setRect(
                        minX,
                        yLoc,
                        maxX -
                          minX,
                        height);
                }
            }
            prevPaint =
              paint;
            prevStroke =
              stroke;
            prevStrokePaint =
              strokePaint;
        }
        if (decorationRect !=
              null) {
            if (prevPaint !=
                  null) {
                g2d.
                  setPaint(
                    prevPaint);
                g2d.
                  fill(
                    decorationRect);
            }
            if (prevStroke !=
                  null &&
                  prevStrokePaint !=
                  null) {
                g2d.
                  setPaint(
                    prevStrokePaint);
                g2d.
                  setStroke(
                    prevStroke);
                g2d.
                  draw(
                    decorationRect);
            }
        }
    }
    protected void paintTextRuns(java.util.List textRuns,
                                 java.awt.Graphics2D g2d) {
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null &&
                  tpi.
                    composite !=
                  null) {
                g2d.
                  setComposite(
                    tpi.
                      composite);
            }
            textRun.
              getLayout(
                ).
              draw(
                g2d);
        }
    }
    public java.awt.Shape getOutline(org.apache.batik.gvt.TextNode node) {
        java.awt.geom.GeneralPath outline =
          null;
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout textRunLayout =
              textRun.
              getLayout(
                );
            java.awt.geom.GeneralPath textRunOutline =
              new java.awt.geom.GeneralPath(
              textRunLayout.
                getOutline(
                  ));
            if (outline ==
                  null) {
                outline =
                  textRunOutline;
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    textRunOutline,
                    false);
            }
        }
        java.awt.Shape underline =
          getDecorationOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_UNDERLINE);
        java.awt.Shape strikeThrough =
          getDecorationOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_STRIKETHROUGH);
        java.awt.Shape overline =
          getDecorationOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_OVERLINE);
        if (underline !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    underline);
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    underline,
                    false);
            }
        }
        if (strikeThrough !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    strikeThrough);
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    strikeThrough,
                    false);
            }
        }
        if (overline !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    overline);
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    overline,
                    false);
            }
        }
        return outline;
    }
    public java.awt.geom.Rectangle2D getBounds2D(org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        java.awt.geom.Rectangle2D bounds =
          null;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout textRunLayout =
              textRun.
              getLayout(
                );
            java.awt.geom.Rectangle2D runBounds =
              textRunLayout.
              getBounds2D(
                );
            if (runBounds !=
                  null) {
                if (bounds ==
                      null)
                    bounds =
                      runBounds;
                else
                    bounds.
                      add(
                        runBounds);
            }
        }
        java.awt.Shape underline =
          getDecorationStrokeOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_UNDERLINE);
        if (underline !=
              null) {
            if (bounds ==
                  null)
                bounds =
                  underline.
                    getBounds2D(
                      );
            else
                bounds.
                  add(
                    underline.
                      getBounds2D(
                        ));
        }
        java.awt.Shape strikeThrough =
          getDecorationStrokeOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_STRIKETHROUGH);
        if (strikeThrough !=
              null) {
            if (bounds ==
                  null)
                bounds =
                  strikeThrough.
                    getBounds2D(
                      );
            else
                bounds.
                  add(
                    strikeThrough.
                      getBounds2D(
                        ));
        }
        java.awt.Shape overline =
          getDecorationStrokeOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_OVERLINE);
        if (overline !=
              null) {
            if (bounds ==
                  null)
                bounds =
                  overline.
                    getBounds2D(
                      );
            else
                bounds.
                  add(
                    overline.
                      getBounds2D(
                        ));
        }
        return bounds;
    }
    protected java.awt.Shape getDecorationOutline(java.util.List textRuns,
                                                  int decorationType) {
        java.awt.geom.GeneralPath outline =
          null;
        java.awt.Paint prevPaint =
          null;
        java.awt.Paint prevStrokePaint =
          null;
        java.awt.Stroke prevStroke =
          null;
        java.awt.geom.Rectangle2D decorationRect =
          null;
        double yLoc =
          0;
        double height =
          0;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            java.awt.Paint paint =
              null;
            java.awt.Stroke stroke =
              null;
            java.awt.Paint strokePaint =
              null;
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null) {
                switch (decorationType) {
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_UNDERLINE:
                        paint =
                          tpi.
                            underlinePaint;
                        stroke =
                          tpi.
                            underlineStroke;
                        strokePaint =
                          tpi.
                            underlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_OVERLINE:
                        paint =
                          tpi.
                            overlinePaint;
                        stroke =
                          tpi.
                            overlineStroke;
                        strokePaint =
                          tpi.
                            overlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_STRIKETHROUGH:
                        paint =
                          tpi.
                            strikethroughPaint;
                        stroke =
                          tpi.
                            strikethroughStroke;
                        strokePaint =
                          tpi.
                            strikethroughStrokePaint;
                        break;
                    default:
                        return null;
                }
            }
            if (textRun.
                  isFirstRunInChunk(
                    )) {
                java.awt.Shape s =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                java.awt.geom.Rectangle2D r2d =
                  s.
                  getBounds2D(
                    );
                yLoc =
                  r2d.
                    getY(
                      );
                height =
                  r2d.
                    getHeight(
                      );
            }
            if (textRun.
                  isFirstRunInChunk(
                    ) ||
                  paint !=
                  prevPaint ||
                  stroke !=
                  prevStroke ||
                  strokePaint !=
                  prevStrokePaint) {
                if (decorationRect !=
                      null) {
                    if (outline ==
                          null) {
                        outline =
                          new java.awt.geom.GeneralPath(
                            decorationRect);
                    }
                    else {
                        outline.
                          append(
                            decorationRect,
                            false);
                    }
                    decorationRect =
                      null;
                }
            }
            if ((paint !=
                   null ||
                   strokePaint !=
                   null) &&
                  !textRun.
                  getLayout(
                    ).
                  isVertical(
                    ) &&
                  !textRun.
                  getLayout(
                    ).
                  isOnATextPath(
                    )) {
                java.awt.Shape decorationShape =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                if (decorationRect ==
                      null) {
                    java.awt.geom.Rectangle2D r2d =
                      decorationShape.
                      getBounds2D(
                        );
                    decorationRect =
                      new java.awt.geom.Rectangle2D.Double(
                        r2d.
                          getX(
                            ),
                        yLoc,
                        r2d.
                          getWidth(
                            ),
                        height);
                }
                else {
                    java.awt.geom.Rectangle2D bounds =
                      decorationShape.
                      getBounds2D(
                        );
                    double minX =
                      java.lang.Math.
                      min(
                        decorationRect.
                          getX(
                            ),
                        bounds.
                          getX(
                            ));
                    double maxX =
                      java.lang.Math.
                      max(
                        decorationRect.
                          getMaxX(
                            ),
                        bounds.
                          getMaxX(
                            ));
                    decorationRect.
                      setRect(
                        minX,
                        yLoc,
                        maxX -
                          minX,
                        height);
                }
            }
            prevPaint =
              paint;
            prevStroke =
              stroke;
            prevStrokePaint =
              strokePaint;
        }
        if (decorationRect !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    decorationRect);
            }
            else {
                outline.
                  append(
                    decorationRect,
                    false);
            }
        }
        return outline;
    }
    protected java.awt.Shape getDecorationStrokeOutline(java.util.List textRuns,
                                                        int decorationType) {
        java.awt.geom.GeneralPath outline =
          null;
        java.awt.Paint prevPaint =
          null;
        java.awt.Paint prevStrokePaint =
          null;
        java.awt.Stroke prevStroke =
          null;
        java.awt.geom.Rectangle2D decorationRect =
          null;
        double yLoc =
          0;
        double height =
          0;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            java.awt.Paint paint =
              null;
            java.awt.Stroke stroke =
              null;
            java.awt.Paint strokePaint =
              null;
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null) {
                switch (decorationType) {
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_UNDERLINE:
                        paint =
                          tpi.
                            underlinePaint;
                        stroke =
                          tpi.
                            underlineStroke;
                        strokePaint =
                          tpi.
                            underlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_OVERLINE:
                        paint =
                          tpi.
                            overlinePaint;
                        stroke =
                          tpi.
                            overlineStroke;
                        strokePaint =
                          tpi.
                            overlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_STRIKETHROUGH:
                        paint =
                          tpi.
                            strikethroughPaint;
                        stroke =
                          tpi.
                            strikethroughStroke;
                        strokePaint =
                          tpi.
                            strikethroughStrokePaint;
                        break;
                    default:
                        return null;
                }
            }
            if (textRun.
                  isFirstRunInChunk(
                    )) {
                java.awt.Shape s =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                java.awt.geom.Rectangle2D r2d =
                  s.
                  getBounds2D(
                    );
                yLoc =
                  r2d.
                    getY(
                      );
                height =
                  r2d.
                    getHeight(
                      );
            }
            if (textRun.
                  isFirstRunInChunk(
                    ) ||
                  paint !=
                  prevPaint ||
                  stroke !=
                  prevStroke ||
                  strokePaint !=
                  prevStrokePaint) {
                if (decorationRect !=
                      null) {
                    java.awt.Shape s =
                      null;
                    if (prevStroke !=
                          null &&
                          prevStrokePaint !=
                          null)
                        s =
                          prevStroke.
                            createStrokedShape(
                              decorationRect);
                    else
                        if (prevPaint !=
                              null)
                            s =
                              decorationRect;
                    if (s !=
                          null) {
                        if (outline ==
                              null)
                            outline =
                              new java.awt.geom.GeneralPath(
                                s);
                        else
                            outline.
                              append(
                                s,
                                false);
                    }
                    decorationRect =
                      null;
                }
            }
            if ((paint !=
                   null ||
                   strokePaint !=
                   null) &&
                  !textRun.
                  getLayout(
                    ).
                  isVertical(
                    ) &&
                  !textRun.
                  getLayout(
                    ).
                  isOnATextPath(
                    )) {
                java.awt.Shape decorationShape =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                if (decorationRect ==
                      null) {
                    java.awt.geom.Rectangle2D r2d =
                      decorationShape.
                      getBounds2D(
                        );
                    decorationRect =
                      new java.awt.geom.Rectangle2D.Double(
                        r2d.
                          getX(
                            ),
                        yLoc,
                        r2d.
                          getWidth(
                            ),
                        height);
                }
                else {
                    java.awt.geom.Rectangle2D bounds =
                      decorationShape.
                      getBounds2D(
                        );
                    double minX =
                      java.lang.Math.
                      min(
                        decorationRect.
                          getX(
                            ),
                        bounds.
                          getX(
                            ));
                    double maxX =
                      java.lang.Math.
                      max(
                        decorationRect.
                          getMaxX(
                            ),
                        bounds.
                          getMaxX(
                            ));
                    decorationRect.
                      setRect(
                        minX,
                        yLoc,
                        maxX -
                          minX,
                        height);
                }
            }
            prevPaint =
              paint;
            prevStroke =
              stroke;
            prevStrokePaint =
              strokePaint;
        }
        if (decorationRect !=
              null) {
            java.awt.Shape s =
              null;
            if (prevStroke !=
                  null &&
                  prevStrokePaint !=
                  null)
                s =
                  prevStroke.
                    createStrokedShape(
                      decorationRect);
            else
                if (prevPaint !=
                      null)
                    s =
                      decorationRect;
            if (s !=
                  null) {
                if (outline ==
                      null)
                    outline =
                      new java.awt.geom.GeneralPath(
                        s);
                else
                    outline.
                      append(
                        s,
                        false);
            }
        }
        return outline;
    }
    public org.apache.batik.gvt.text.Mark getMark(org.apache.batik.gvt.TextNode node,
                                                  int index,
                                                  boolean leadingEdge) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        if (index <
              aci.
              getBeginIndex(
                ) ||
              index >
              aci.
              getEndIndex(
                ))
            return null;
        org.apache.batik.gvt.text.TextHit textHit =
          new org.apache.batik.gvt.text.TextHit(
          index,
          leadingEdge);
        return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
          node,
          textHit);
    }
    protected org.apache.batik.gvt.text.Mark hitTest(double x,
                                                     double y,
                                                     org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              textRun.
              getLayout(
                );
            org.apache.batik.gvt.text.TextHit textHit =
              layout.
              hitTestChar(
                (float)
                  x,
                (float)
                  y);
            if (textHit !=
                  null &&
                  layout.
                  getBounds2D(
                    ).
                  contains(
                    x,
                    y)) {
                return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
                  node,
                  textHit);
            }
        }
        return null;
    }
    public org.apache.batik.gvt.text.Mark selectFirst(org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        org.apache.batik.gvt.text.TextHit textHit =
          new org.apache.batik.gvt.text.TextHit(
          aci.
            getBeginIndex(
              ),
          false);
        return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
          node,
          textHit);
    }
    public org.apache.batik.gvt.text.Mark selectLast(org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        org.apache.batik.gvt.text.TextHit textHit =
          new org.apache.batik.gvt.text.TextHit(
          aci.
            getEndIndex(
              ) -
            1,
          false);
        return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
          node,
          textHit);
    }
    public int[] getSelected(org.apache.batik.gvt.text.Mark startMark,
                             org.apache.batik.gvt.text.Mark finishMark) {
        if (startMark ==
              null ||
              finishMark ==
              null) {
            return null;
        }
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark start;
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark finish;
        try {
            start =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                startMark;
            finish =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                finishMark;
        }
        catch (java.lang.ClassCastException cce) {
            throw new java.lang.Error(
              "This Mark was not instantiated by this TextPainter class!");
        }
        org.apache.batik.gvt.TextNode textNode =
          start.
          getTextNode(
            );
        if (textNode ==
              null)
            return null;
        if (textNode !=
              finish.
              getTextNode(
                ))
            throw new java.lang.Error(
              "Markers are from different TextNodes!");
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int[] result =
          new int[2];
        result[0] =
          start.
            getHit(
              ).
            getCharIndex(
              );
        result[1] =
          finish.
            getHit(
              ).
            getCharIndex(
              );
        java.util.List textRuns =
          getTextRuns(
            textNode,
            aci);
        java.util.Iterator trI =
          textRuns.
          iterator(
            );
        int startGlyphIndex =
          -1;
        int endGlyphIndex =
          -1;
        org.apache.batik.gvt.text.TextSpanLayout startLayout =
          null;
        org.apache.batik.gvt.text.TextSpanLayout endLayout =
          null;
        while (trI.
                 hasNext(
                   )) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun tr =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                trI.
                next(
                  );
            org.apache.batik.gvt.text.TextSpanLayout tsl =
              tr.
              getLayout(
                );
            if (startGlyphIndex ==
                  -1) {
                startGlyphIndex =
                  tsl.
                    getGlyphIndex(
                      result[0]);
                if (startGlyphIndex !=
                      -1)
                    startLayout =
                      tsl;
            }
            if (endGlyphIndex ==
                  -1) {
                endGlyphIndex =
                  tsl.
                    getGlyphIndex(
                      result[1]);
                if (endGlyphIndex !=
                      -1)
                    endLayout =
                      tsl;
            }
            if (startGlyphIndex !=
                  -1 &&
                  endGlyphIndex !=
                  -1)
                break;
        }
        if (startLayout ==
              null ||
              endLayout ==
              null)
            return null;
        int startCharCount =
          startLayout.
          getCharacterCount(
            startGlyphIndex,
            startGlyphIndex);
        int endCharCount =
          endLayout.
          getCharacterCount(
            endGlyphIndex,
            endGlyphIndex);
        if (startCharCount >
              1) {
            if (result[0] >
                  result[1] &&
                  startLayout.
                  isLeftToRight(
                    )) {
                result[0] +=
                  startCharCount -
                    1;
            }
            else
                if (result[1] >
                      result[0] &&
                      !startLayout.
                      isLeftToRight(
                        )) {
                    result[0] -=
                      startCharCount -
                        1;
                }
        }
        if (endCharCount >
              1) {
            if (result[1] >
                  result[0] &&
                  endLayout.
                  isLeftToRight(
                    )) {
                result[1] +=
                  endCharCount -
                    1;
            }
            else
                if (result[0] >
                      result[1] &&
                      !endLayout.
                      isLeftToRight(
                        )) {
                    result[1] -=
                      endCharCount -
                        1;
                }
        }
        return result;
    }
    public java.awt.Shape getHighlightShape(org.apache.batik.gvt.text.Mark beginMark,
                                            org.apache.batik.gvt.text.Mark endMark) {
        if (beginMark ==
              null ||
              endMark ==
              null) {
            return null;
        }
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark begin;
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark end;
        try {
            begin =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                beginMark;
            end =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                endMark;
        }
        catch (java.lang.ClassCastException cce) {
            throw new java.lang.Error(
              "This Mark was not instantiated by this TextPainter class!");
        }
        org.apache.batik.gvt.TextNode textNode =
          begin.
          getTextNode(
            );
        if (textNode ==
              null)
            return null;
        if (textNode !=
              end.
              getTextNode(
                ))
            throw new java.lang.Error(
              "Markers are from different TextNodes!");
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int beginIndex =
          begin.
          getHit(
            ).
          getCharIndex(
            );
        int endIndex =
          end.
          getHit(
            ).
          getCharIndex(
            );
        if (beginIndex >
              endIndex) {
            org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark tmpMark =
              begin;
            begin =
              end;
            end =
              tmpMark;
            int tmpIndex =
              beginIndex;
            beginIndex =
              endIndex;
            endIndex =
              tmpIndex;
        }
        java.util.List textRuns =
          getTextRuns(
            textNode,
            aci);
        java.awt.geom.GeneralPath highlightedShape =
          new java.awt.geom.GeneralPath(
          );
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              textRun.
              getLayout(
                );
            java.awt.Shape layoutHighlightedShape =
              layout.
              getHighlightShape(
                beginIndex,
                endIndex);
            if (layoutHighlightedShape !=
                  null &&
                  !layoutHighlightedShape.
                  getBounds(
                    ).
                  isEmpty(
                    )) {
                highlightedShape.
                  append(
                    layoutHighlightedShape,
                    false);
            }
        }
        return highlightedShape;
    }
    class TextChunk {
        public int begin;
        public int end;
        public java.awt.geom.Point2D advance;
        public TextChunk(int begin, int end,
                         java.awt.geom.Point2D advance) {
            super(
              );
            this.
              begin =
              begin;
            this.
              end =
              end;
            this.
              advance =
              new java.awt.geom.Point2D.Float(
                (float)
                  advance.
                  getX(
                    ),
                (float)
                  advance.
                  getY(
                    ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AAA=");
    }
    public class TextRun {
        protected java.text.AttributedCharacterIterator
          aci;
        protected org.apache.batik.gvt.text.TextSpanLayout
          layout;
        protected int anchorType;
        protected boolean firstRunInChunk;
        protected java.lang.Float length;
        protected java.lang.Integer lengthAdjust;
        public TextRun(org.apache.batik.gvt.text.TextSpanLayout layout,
                       java.text.AttributedCharacterIterator aci,
                       boolean firstRunInChunk) {
            super(
              );
            this.
              layout =
              layout;
            this.
              aci =
              aci;
            this.
              aci.
              first(
                );
            this.
              firstRunInChunk =
              firstRunInChunk;
            this.
              anchorType =
              org.apache.batik.gvt.TextNode.Anchor.
                ANCHOR_START;
            org.apache.batik.gvt.TextNode.Anchor anchor =
              (org.apache.batik.gvt.TextNode.Anchor)
                aci.
                getAttribute(
                  org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                    ANCHOR_TYPE);
            if (anchor !=
                  null) {
                this.
                  anchorType =
                  anchor.
                    getType(
                      );
            }
            if (aci.
                  getAttribute(
                    WRITING_MODE) ==
                  WRITING_MODE_RTL) {
                if (anchorType ==
                      org.apache.batik.gvt.TextNode.Anchor.
                        ANCHOR_START) {
                    anchorType =
                      org.apache.batik.gvt.TextNode.Anchor.
                        ANCHOR_END;
                }
                else
                    if (anchorType ==
                          org.apache.batik.gvt.TextNode.Anchor.
                            ANCHOR_END) {
                        anchorType =
                          org.apache.batik.gvt.TextNode.Anchor.
                            ANCHOR_START;
                    }
            }
            length =
              (java.lang.Float)
                aci.
                getAttribute(
                  org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                    BBOX_WIDTH);
            lengthAdjust =
              (java.lang.Integer)
                aci.
                getAttribute(
                  org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                    LENGTH_ADJUST);
        }
        public java.text.AttributedCharacterIterator getACI() {
            return aci;
        }
        public org.apache.batik.gvt.text.TextSpanLayout getLayout() {
            return layout;
        }
        public int getAnchorType() { return anchorType;
        }
        public java.lang.Float getLength() {
            return length;
        }
        public java.lang.Integer getLengthAdjust() {
            return lengthAdjust;
        }
        public boolean isFirstRunInChunk() {
            return firstRunInChunk;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public StrokingTextPainter() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "B1NxryML6wyKyVnNW1qSscTn7Lg9SkRJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "v+FfPPunxYnP/w+TeHkj8lMAAA==");
}
