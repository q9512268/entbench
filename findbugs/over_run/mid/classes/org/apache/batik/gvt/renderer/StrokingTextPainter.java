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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYa2wU1xW+u7bXD4xfgO3wMGAMkgndKXmUVqZNYMHFZI1X" +
           "tmOpS5vl7uzd3cGzM8PMHXsxJYSoDVZ+oEiQlDbBf0rUCJEQRY1atQql6itV" +
           "miLSqM1DTdrmR1IlSOFHQ1rapufeO7MzO7vrKL9qybOz955z7nl+59y9cA01" +
           "WCbqN7CWwVF62CBWNMHeE9i0SCamYsuahNWU/PBfTx278Yfm42EUSaK2PLZG" +
           "ZWyRYYWoGSuJ1iiaRbEmE2sfIRnGkTCJRcwZTBVdS6IVijVSMFRFVuioniGM" +
           "YAqbcdSJKTWVtE3JiCOAorVxro3EtZF2BAmG4qhV1o3DHsPKMoaYb4/RFrzz" +
           "LIo64gfxDJZsqqhSXLHoUNFEtxq6ejin6jRKijR6UL3TccTe+J0Vbuh/tv2j" +
           "m4/kO7gblmFN0yk30Ronlq7OkEwctXuru1VSsA6h+1FdHC3xEVM0EHcPleBQ" +
           "CQ517fWoQPulRLMLMZ2bQ11JEUNmClG0vlyIgU1ccMQkuM4goYk6tnNmsHZd" +
           "yVo33AETH71VOv2d+zqeq0PtSdSuaBNMHRmUoHBIEhxKCmliWjsyGZJJok4N" +
           "Aj5BTAWrypwT7S5LyWmY2pACrlvYom0Qk5/p+QoiCbaZtkx1s2RelieV860h" +
           "q+Ic2Nrt2SosHGbrYGCLAoqZWQy557DUTytahudROUfJxoF7gABYGwuE5vXS" +
           "UfUahgXUJVJExVpOmoDk03JA2qBDCpo812oIZb42sDyNcyRFUW+QLiG2gKqZ" +
           "O4KxULQiSMYlQZRWBqLki8+1fdtPHtH2aGEUAp0zRFaZ/kuAqS/ANE6yxCRQ" +
           "B4KxdXP8Mdz9wnwYISBeESAWND/65vW7t/RdflHQrKpCM5Y+SGSaks+l266u" +
           "jg1+qY6p0WTolsKCX2Y5r7KEszNUNABpuksS2WbU3bw8/uuvPXCevB9GLSMo" +
           "IuuqXYA86pT1gqGoxPwq0YiJKcmMoGaiZWJ8fwQ1wntc0YhYHctmLUJHUL3K" +
           "lyI6/w4uyoII5qIWeFe0rO6+G5jm+XvRQAjVwz9qRiiSQPxPfFJkSnm9QCQs" +
           "Y03RdClh6sx+FlCOOcSC9wzsGrqUhvyf/tzW6DbJ0m0TElLSzZyEISvyRGxK" +
           "uRkqQUgyEBeTZZcOuZqbhMJKYJ7HUZZ7xv/l1CLzxbLZUAjCtDoIEirU1x5d" +
           "BQkp+bS9c/f1Z1IviQRkReN4kaIhODoqjo7yo6NwdNQ9Olrl6AH2Hsvb2jQK" +
           "hfjZy5kyIj0guNMAE4DTrYMT39h7YL6/DvLSmGWxYqSbKvpWzMMTtwmk5AtX" +
           "x29cebnlfBiFAXLS0Le85jFQ1jxE7zN1mWQAvWq1ERdKpdqNo6oe6PKZ2eNT" +
           "xz7P9fD3AyawAaCMsScYipeOGAjiQDW57Sfe++jiY0d1DxHKGozbFys4GdD0" +
           "ByMdND4lb16Hn0+9cHQgjOoBvQCxKYSOgWFf8IwywBlywZvZ0gQGZ3WzgFW2" +
           "5SJuC82b+qy3wlOwk78vhxC3swrshVKcckqSf7LdboM9e0TKspwJWMGbw5cn" +
           "jLOv/f7vt3N3u32k3TcATBA65MMuJqyLo1Snl4KTJiFA9+cziVOPXjuxn+cf" +
           "UGyoduAAe8YAsyCE4OZvv3jo9bffOvdq2MtZCs3bTsMcVCwZ2cRsalvESJbn" +
           "nj6AfSogAcuagXs1yEolq+C0SliR/Lt949bnPzjZIfJAhRU3jbZ8ugBv/Zad" +
           "6IGX7rvRx8WEZNZ7PZ95ZALQl3mSd5gmPsz0KB5/Zc13f4PPQmsAOLaUOcIR" +
           "to77oM5iWe2rWzYQTthpiyZMpQCBmHHa1cXuG4d+2Ti3y21F1VgE5T3W6JWf" +
           "7Hk3xQPdxOqbrTPbl/oqd4eZ82VZhwjAJ/AXgv//sn/meLYggL8r5nSfdaX2" +
           "YxhF0H5wkXmx3ATpaNfb00+897QwIdieA8Rk/vTDn0RPnhbREzPMhooxws8j" +
           "5hhhDnt8kWm3frFTOMfwuxeP/vSpoyeEVl3lHXk3DJxP//E/v4ue+ctvqwB8" +
           "neLMobezdC4BcXcwOsKkyNaz/zz20GtjgBwjqMnWlEM2Gcn4ZcIQZtlpX7i8" +
           "6Ygv+I1joaEotBmiwBa2cT16YYjiKYhnaTRH9ALMFKDjbbs4zR2cRippjLjG" +
           "iO+NsMeA5cfY8nj6RvGU/MirHy6d+vDSde6T8lneDymj2BAB6WSPjSwgPcF+" +
           "tgdbeaC74/K+r3eol2+CxCRIlKFzW2MmNMpiGQA51A2Nb/z8F90Hrtah8DBq" +
           "UXWcGcYcy1EzgCix8tCci8ZddwsQmWWo0sFNRRXGs7JdWx0QdhcMykt47sc9" +
           "P9z+g4W3OHYJsFpVKt91FW2X3wO9jvHBm4+/87Mb328UGbZIvQT4ev81pqYf" +
           "/NvHFU7mDbJKCQX4k9KFJ1bGvvI+5/c6FePeUKycaqCXe7y3nS/8I9wf+VUY" +
           "NSZRh+zcuaawajP8T8I9w3IvYnAvK9svvzOIAXmo1IlXB2vYd2ywR/oLo56W" +
           "FUGgLd4CnWLc6RjjwbYYQvwlyVk2scfmyn5Ti5uihjTJKbwdbhMNlj33ssd+" +
           "kQqjNfNsslzLHpA/4ZwzUUNLvKiWtbgBimCqrKZj+jPquBakTzqnTNbQMb+o" +
           "jrW4KWrEmRkWZ/Z1OKCnsoieYmsTfw6yxxandkuH86/1weuKf2zwahYxGFpT" +
           "60bJe8K5B08vZMae3Bp2wPEumFSci75fDkXNpXndhd+tn3nmB216K36FEDdn" +
           "+ZmF9qaehXv/xIfN0u22Ffp61lZVf3n43iOGSbIKV7xVFItoEUcoWrOodhQ1" +
           "ua/cnDnBdz9Fy6vxQdLB0095nKKOICUrIPbpp/sWRS0eHThXvPhJToB0IGGv" +
           "84br3A6O0wxXogJXiqHywJbSacWnpb0vFzaUITL/3cjt3bb45QjGr4W9+45c" +
           "/8KTYnqWVTw3x39ngI4tBvnSHWV9TWmurMiewZttzzZvdLOrUyjsFcQqX18G" +
           "PAoZrEetDIyW1kBpwnz93PZLL89HXgGg349CmKJl+ysRuGjY0Oj2x6vNJoDB" +
           "fOodannnwJWP3wh18UbnTDN9i3Gk5FOX3kxkDeN7YdQ8ghqgeEiRt4ddh7Vx" +
           "Is+YZaNOJK3bWuknpjaW0Jj9psQ94zh0aWmV3b4o6q+c+ipvpDADzBJzJ5Pu" +
           "jE7+imixDcO/yz0bE3MU8zTkWio+ahjOuLtkM/e8YXDseJw9dv0P16abvRwW" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZecwkaVmvmdk5WWZmF9hdVvYe1KXxq6quPl3Arb6Pqj6q" +
           "qru6SmWos7uq676rcBVIFISIm7AsmMD+BdGQ5YiRaGIwa4yKgZhgiFciEGMi" +
           "BknYP0QjKr5V/d0zs7DxD7/kq36r3ud93uf8Pe/x4neh874HlRzbSNeGHewp" +
           "SbCnG9W9IHUUf29EVGeC5yty2xB8nwHfbkqPf+Ha93/w7Ob6WegCD71OsCw7" +
           "EALNtnxK8W0jUmQCunb0tWsoph9A1wldiAQ4DDQDJjQ/eIqAXnNsaADdIA5E" +
           "gIEIMBABLkSA8SMqMOi1ihWa7XyEYAW+C/0ydIaALjhSLl4APXaSiSN4grnP" +
           "ZlZoADhcyt+XQKlicOJBjx7qvtP5FoU/WoKf+9g7r//uOegaD13TLDoXRwJC" +
           "BGASHrrbVExR8XxclhWZh+6xFEWmFU8TDC0r5Oahe31tbQlB6CmHRso/ho7i" +
           "FXMeWe5uKdfNC6XA9g7VUzXFkA/ezquGsAa63nek607DXv4dKHhFA4J5qiAp" +
           "B0Pu2mqWHECPnB5xqOONMSAAQy+aSrCxD6e6yxLAB+jene8MwVrDdOBp1hqQ" +
           "nrdDMEsAPXhHprmtHUHaCmvlZgA9cJputusCVJcLQ+RDAugNp8kKTsBLD57y" +
           "0jH/fHfytg+/2xpYZwuZZUUycvkvgUEPnxpEKariKZak7Abe/RbieeG+L33g" +
           "LAQB4jecIt7R/P4vvfz0Wx9+6cs7mp+4Dc1U1BUpuCl9Srz6tTe1n2yey8W4" +
           "5Ni+ljv/hOZF+M/2e55KHJB59x1yzDv3Djpfov6Me89nlO+cha4MoQuSbYQm" +
           "iKN7JNt0NEPx+oqleEKgyEPosmLJ7aJ/CF0EbUKzlN3Xqar6SjCE7jKKTxfs" +
           "4h2YSAUschNdBG3NUu2DtiMEm6KdOBAE3QX+ocsQdGEGFX+73wDy4I1tKrAg" +
           "CZZm2fDMs3P9c4dasgAHig/aMuh1bFgE8b/9GXSvDvt26IGAhG1vDQsgKjbK" +
           "rhNeRwEMXCIDv3h5dNkgVtcMSKyZUMTxXh57zv/LrElui+vxmTPATW86DRIG" +
           "yK+BbQAON6Xnwlb35c/d/MrZw6TZt2IAPQWm3ttNvVdMvQem3juYeu82U9/I" +
           "2+1NaG2hM2eKuV+fC7MLD+DcLYAJAKB3P0n/4uhdH3j8HIhLJ859lZPCd8bx" +
           "9hGwDAv4lEB0Qy99PH7v8leQs9DZk4CcKwA+XcmHz3IYPYTLG6cT8XZ8r73/" +
           "29///PPP2EcpeQLh95Hi1pF5pj9+2tSeLSkywM4j9m95VPjizS89c+MsdBeA" +
           "DwCZAbBdjkYPn57jRMY/dYCeuS7ngcKq7ZmCkXcdQN6VYOPZ8dGXIgauFu17" +
           "gI2v5SnwAMiF5X5OFL957+uc/Pn6XczkTjulRYHOb6edT/7tX/4LVpj7AMiv" +
           "HSuNtBI8dQw8cmbXCpi45ygGGE9RAN0/fHz2kY9+9/0/XwQAoHjidhPeyJ9t" +
           "ABrAhcDMv/pl9++++Y1Pff3sUdAEoHqGoqFJyaGSl3Kdrr6CkmC2nzySB4CP" +
           "AVIxj5obC8u0ZU3VBNFQ8ij9r2tvRr/4rx++vosDA3w5CKO3/mgGR9/f2ILe" +
           "85V3/vvDBZszUl78jmx2RLZD1NcdccY9T0hzOZL3/tVDv/XnwicBNgM89LVM" +
           "KSDuXGGDc2DQk6+wAPI0E3gj2i8a8DP3fnP7iW9/dlcQTleYU8TKB5774A/3" +
           "Pvzc2WNl+IlbKuHxMbtSXITRa3ce+SH4OwP+/yf/zz2Rf9hB8b3t/Xrw6GFB" +
           "cJwEqPPYK4lVTNH7588/84e/88z7d2rce7IKdcEi67N//d9f3fv4t/7iNqB2" +
           "DgBV/oIVAr4BVO3C5EIc7K0V2wRFDBCUO4UScEHzluK5l0tdmBwq+t6ePx7x" +
           "j2PKSesfW/vdlJ79+vdeu/zeH71cCHRy8Xg8hUjB2Znvav54NLfG/acBdCD4" +
           "G0BXeWnyC9eNl34AOPKAowRKhT/1ADInJxJun/r8xb//4z+5711fOwed7UFX" +
           "DFuQe0KBXdBlABqKvwHVIHF+7uld0sR5Fl0vVIVuUX6Xaw8UbxdeOfp6+drv" +
           "CPke+M+pIb7vH//jFiMUgH2bgDw1nodf/MSD7Xd8pxh/hJz56IeTW8scWCcf" +
           "jS1/xvy3s49f+NOz0EUeui7tL8KXghHmeMSDhad/sDIHC/UT/ScXkbsV01OH" +
           "leFNpzPi2LSnMfsoEkE7p87bV24H028EtqX2EYw6DdNnoKIxLoY8Vjxv5I+f" +
           "2qFi3vzpgmklgM6LylorsBjboXv+fEf+IHaOxO/o9N5Jke4HotD7ItF3EIn6" +
           "cUQ6BxYQtxOIfpUCPQIEYfYFYu4gEPfjCHRRkKPcXfnrz54Siv+RQhVMkjOg" +
           "GJ0v79X3kPz9Xbef9lwxLahafrELAyNUzRKMAznu1w3pxgEqLsGuDOTGDd2o" +
           "HyDV9SKt8yjc221lTsla+bFlBWl79YgZYYNd0Yf+6dmv/uYT3wS5NYLOR3nc" +
           "g5Q6NuMkzDeKv/biRx96zXPf+lBRhIEdZ893rz+dc92+ksb5o3C5cqDqg7mq" +
           "dLHCJQQ/IIu6qciH2iLH9KkFoPra/wdtg7tfHFT8IX7wRy45oRwv0IQthXVx" +
           "1akk6nqKxWQfJ7drSx6vzMXS5SccOejxQ3QVmFOHrkZGPcxkTOpnZGNGDlZ+" +
           "MuJou7PkS3ZXmxsdsaUi3qI96s4pDhWCuWvUtGBpagTtkmiHkT2TQocGPe0N" +
           "5qgnOKGqTOtkNq1H3phouqk4zZrVala3jFK1mTYlHEHZtuhO6m02XvZq5XaL" +
           "nZADpdvUELotmJwfCpsJu4BnLZVJyvUGp5qVcndBC+PyjOD7PJtSHMfafToc" +
           "oZomUGLX7JZ9dUhZ/S3THlFSzDOtpUzXhktNX9Jkj+otQxBvWp/kcFeUZHo0" +
           "Zthl0MVGWnuK294y8WysG/C9cgs3+xV3s0RtrDPwZ2PSFjixAlM9L8uIoV2r" +
           "rNWkM+J9193QK2JgLya9bpC4NUXXrJpOjTWdqi0IjJEkRimNkKUYbuAgKutm" +
           "Bd5O62vRMHsTJN1iCGVbhlufbruxFKxCL0SXtI/XNiW0Jw/aWNJdkkh3IM0M" +
           "pTVvz6toXWXt+Sw0KIIkSL4szlF01F1MzLbRRyIjHa4XqCSR821IVtY2t60F" +
           "1sT0B7ycLm0Mw7vMoI4up1FZLmWu4iKzgJbpUGgBq1Pmwh60ht1NMm6bhsbq" +
           "ftrnRyN7W5ngerXF4KyXOjFTp6tEyppc2cHbnhFxtonMt1XYKc1trS0KfLBN" +
           "UL9MKYamLBs1ZOOWhlJ54gVl2vYHfdHj+m0Ct12enafVar2zYNJA2IQyNV2o" +
           "o8Tu1dd4i+vHYbcareiFuhA269VitBx1k6UzNe3OFsFGeNltddqO3UDL9pAX" +
           "K2W/k06klOot2NKc0Prl9djlp5VxsiDmGk1yxpyn2JZLbLVGCVXlYDYIBmWh" +
           "313gDpJRPYGHtyHu0jA+6dbSpE3NW2CsvJo1SDlrxlbMDemW0qVxdtKBa9WI" +
           "rQcwJavGYO6NnTZZ5Up0nxa2fsko12qhvkZLLldzEJaxDX/cXpW5qlcfd/1s" +
           "spjgLSfc+nSZFReYGDfgMIxmq7YStZp9gibtYRi6Kw5v1BwGXbt9O5nFLsJp" +
           "o7FkknZf0Hh21FDjORpbgYRwG24gBSaxGA1AnI2B62twXAlTezisukNW6SmI" +
           "N62V+lXdLK0iao7ryzhrupSm0fNZMlN7oy1tmU0QVD6HYJTcNjY1Pyn1jPZ0" +
           "KtHtZpz5fc9dbKJUhYOMrXXEEWIiTNcg6IxPu0M6Sql+Mg6prTtfrNNuS2F4" +
           "XpqGvCtuyNGYG9UHC56vJxFsoG0iS0SCX+B6O+jYw67mAVyqyq351imJdFOC" +
           "VZRHh5E2p7aUMqlsheFm2rFd3a6ndm0Sy5N5c2p4Rg0flAd+JJb1+Xij6nxa" +
           "3aZDHVmHExLvVjqMx5EM1tzUOaIGdyKCNvtswrm0OI4cNiNJJojNbRUPVkm5" +
           "KSmiZagtrYevCBohlEZV781RPenWswlqsnM8Yl20S8ljR3Ynds1WarMxX1Ym" +
           "TJLVZ021g+GpEONCm/RpidMcZdrHdW3eYat1WlVKJV3jEBntJINx387EXupX" +
           "+nIHaaWkPOlUDBGtDSyk1JQG87U+tVvRvJ2MOXq6ZntqYxincctIYz7ikfW8" +
           "z2Nstu6x5So9CtuNslhyUyw2pvG23og2SRvzY8/fLMeStHVptU7Iok02FYQZ" +
           "+048Ysm+GFclSyemEazWowCbYCFW3gJUwpkWXquSZDhyU8JGacuojJkRMEez" +
           "JGXacjpb6WFilSR10U9tOcRxpcHhftruVqZ8FGG63RRVdRrJbpkM+LaPiYxP" +
           "Sst2zJclyheMqEuPRMvSa7hK22tcCoX1ykfTrm24pTZCGxoFE0Gz0hStWabz" +
           "Q3WEb6gFpot8I1y3IpgX5Nqwv6p7EZU02C4/4eszvlnlcWJuYCYtV9fmzM+Q" +
           "casK8xKKqZXZbG76+JQQFlNpSAV2vW6TVY1Vyh6bcXMm2DhaypPOvN0yBwMB" +
           "lVZhvyKXyoyGpWW0hy7X3SqDsbURq9YHWyyZz+Rk6ooeMxMN2HblisI3ykt+" +
           "E+v4CMZX6wiGfQs2FYJbr4mGV7VoVRZApiebHjKoxtuVmWA44wgTVUSQUqNZ" +
           "n8dDWVPwBrWFI6ZjIdTM2ohUN5uRG9tOYr+hVzebTccKGlvWxFSvx0xJNQ4T" +
           "ZQZHtGOnSndpYMZgtcU6o2QGw104qoRKSQoiN241LIUgbVHJ5HalJa2keOqP" +
           "t+lEyOAsKyP9QF+3Yt0lLdbokuW+ZFV4aTjnA8NZ1bVGjVtHpSGq20LXDlqm" +
           "FreEssSgNY7TtTG3sQSGGjRxguyNO7oo+pWMAh7WHEcn9L42LU18UsGrkso1" +
           "gLOpqL+ASc0bpDW5FHVoWakxDcNSOqmpg4LaqrH0TKfj9UzqlYK1LCpCu16B" +
           "xyUPU2yjXGoD7B0a417GlklzQjpaf45XUbw8EeGs0WsiAw+Uikan5S5WrNSX" +
           "OClFu9m6rSWNoC1pDV6WY39usqyN+L0JRa36fn0kswkylzcSmW6DSt2XmrNm" +
           "VlpXWGw64EZ+z1mOgyYK0muFxdOmHg1aZqUEN+qkiJUbi77ID6M5U1GiBuq4" +
           "nApPokFvUTcBFI7b81Vl2xz3RqjYj6JhqQpLtZ4yUxbjVBLc9kqpp5hFw41h" +
           "M1ZLywU3oXlqU8pAJgixoM8aTN6DDSPOwqNx04+ibDrEV6YNlk+rVjni5HIa" +
           "U7BN2NUa21v014RcaVssIdUoXY9FjptHsZEut2VfUs3UqjJaNdQ2OjMai7EM" +
           "AHhi6Bjm+3JpO3f1iTrxfSMjBg4OV/g4WywmRDTW2EBctzSz7XpjXi/pMzds" +
           "CVsmcy1mIs5JsWTrHlsZs17XpLYsD/PodNy2fFtTONNn1BjUykSw5G04aNRg" +
           "NFbCsVrOYmHDJf2ew9QQcaQ0xtUW0oh4UlCwllOOZ93Q7NGSVq+qne1q4qws" +
           "eSOXAguzzFYZrY2xWq/bka0Sb/aarqBsVhGcDNUJEpbLPdWpoQa/VDGrgmnT" +
           "Pi0Ox8t6suwNA7u7kGzWm9ryZo6GAixZHasFSncvrUXJXCZaCNKsWuPxdNhe" +
           "eMOZ6Diwz1I0ogwYMMNsM2LsFjLs96NGRfQwvDZF4mRlr0crzR2k8UikBYm1" +
           "HBGJepmwGDIEjEl6gIlipTrX+16FbZYqVQlujBnOctklE2MJ1rTWw0rQiix6" +
           "wC6bDGuGHqkpMR8EWcZHMjH1Fqnu96S5u0Ib/Rlu815XCTrDlEW3LSe2siY2" +
           "4wmi0Rys1v01Vmm2zfHIKKU+FfZ1Dpnq5aQWTUZ2p6UCtQXLsgDaz7B4gzYW" +
           "osV0Jk0N62+rvekK2ybbjjKpc/K8sd64a6WrUUFFljf1ZTL0SxwvTKajMSay" +
           "4dZydIFFRnrT8efNSrZBBNZcYmLFrrklqaQ5kdPBO1lrlI2qs1Dv1kuaqSUd" +
           "aQqnGSJ2MXLRyJgtq9klYaNPQyLYkjCoGquOr4ziphwhM7QmiBEVs2B3Uhws" +
           "xa9uO3VPsXM8vBEDu6i849XsmJLbTwgdnawWr3edvlI5frJ6dC4E5SdXD93p" +
           "1qs4w/vU+557QZ5+Gj27f55WB9vi/cvI43wC6PLhncLBPhh91fcSQJoHbrkp" +
           "3d3uSZ974dql+19Y/E1xHn94A3eZgC6poWEcP7E51r7geIqqFYJf3p3fOMXP" +
           "BwPooVeULoAuHTQLdX59N+43Auj1txsXQOfA8zjlswF0/TRlfsyT/x6n+0gA" +
           "XTmiA8bdNY6TPA+4A5K8+THnNocMu6Ou5MxJxx6G070/agN+LBaeOHFIWNxt" +
           "7/uBDHe32zelz78wmrz75dqndxcMkiFkWc7lEgFd3N11HF7jPHZHbge8Lgye" +
           "/MHVL1x+80F0Xd0JfJQQx2R75Pan+V3TCYrz9+wP7v+9t/32C98ozjz+F9nZ" +
           "+mt0IAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "kokBw7AfDxtb+M4bBp7yUBN+6f8vi6IKJccfAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public StrokingTextPainter() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vswb2+cD4+URw9jnIxnsvTmWSLbH1sU7kh3NXa2xlT2WJ2jz3GOkixuY2QSt" +
       "b3Db0W+N88rF8zIOny6Gaz/v/X4fXl7z5iVEKXGxUR0gD/w79Bw3UdPQfQP3" +
       "CJzLfDxR6832G2aPsI2eEyRTX527f+9fVJ5fxlb59Z6lHUcK11xYVlt/9DGF" +
       "FW/wFl54mPCbnS9+W33jXNg6KPCqwkrebHS+8uOOd5N0164K92ET1urZscPa" +
       "rLOVNtsNrMuTgzvypJaQsMi4Yb8m2TSqG+QgZChiSkOSMhhJSENiGk/uRMW0" +
       "tuP/jK3hvtTMol0ce2if/PF3lx9YvPbbjPjP+Wzg2OWfuuXtVw/tOHGM7Rsi" +
       "/SZZ5Hf6WHzkibvF8wN2vG0l+kP7F069d3bNbWG+0zcBk7M5y2xr7G2tXpHu" +
       "XZ6jWbj9Fcrv7U91KxKTXbHk0H/t/svXusNkTJRUZRVpS1aMpgs3ZSqNbL9D" +
       "s+xjNvqAqRUmV+dwT9YkoYWalnN5gTMX7wWmWN7xG9xqv+HjBX7v7QXCsBLT" +
       "dNUEPRLTXh7hsgDZUNcA7ZFFk+/AAcH1nn7RcdTiwvpxANZcgOdabPeT/lUQ" +
       "/01WWnIm39yE4Z3ld6xJj2SP7Dt4ON396BKm2pMKjwpXKtmh7/3r//xL44Nv" +
       "v+Bx8jTWVLWrZXGrKDvanGKghbhtqZOe+trbi8tPXyh7/d7p44sPilDSbJ9j" +
       "oIX+RuFu4Pl9/zEjcWNmYwknQHNcRLlFPt557IX2K1P3hunBNdvNLDrwLqzU" +
       "VGgu1bpoZnWl0EDm5od2Ng7ZArge4EP7gFu9bXUq1m078ruUemKARFrS89Qg" +
       "NDEgbzIm42AuOiiazoH7JK/qofHDmXXBHjw+uAkfhyoLY/61cD3CO/9IAB2Y" +
       "fFYc3v2qurCFGYWWWc/yNesu0EqrFDupEbbBHEgXtIyUMpa2UnZmBTA3DxOo" +
       "XK6hgzACjwPiOsQrU9rKHXJk16S3Nj/8u+8xU3Xv/bsKiwcOfuWzxnsOMrNl" +
       "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" +
       "xj/crBxLmdc0NOvwAfznw/8DeyBM9jZDAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZDoLctBDOnW/6Q30SRbXJay99TAcpylWRwwxLKM93+S9sFIWybFBJk3VFjaa" +
       "19AQRtgsDagxYrc0yOh1PLGvDGpLpI5stnPXRuu6zrZS0qZrk8pGalq4seKz" +
       "vuFFQD0nIdGlmNXQiyU3MROE3pqSPaB6JrqeNkacLYxMT/LdwaBZ5YWlq5jV" +
       "4WZU69UZs2LyPKzNTQoJyZU0xcTuDHQzNncbQ93qS/VxsE45o1OB5yjHb6Zo" +
       "b0GPOug69Gw+gDLTZZhwuhEUBSOEcWvQnRJUO+m4SNJZrFFRIPV2dzwXp7Jt" +
       "wJoS15y0hdPQYja1NY/3WmF77QXpurleQQauxRJuJcuxVXMrHo+O1kScII1Q" +
       "HtSzmkNKWtfzItESbWllze1No2VVtXqTbLTJNbt2N8JmoxCjQcf2jImRjYd4" +
       "PK0JY7yajHle4IezKTMIGbRDkhFWHpprU+u4HboPVMCb0ED1Vz1vXkbTEaMj" +
       "5nrT9SNQAgm1ejVRslG5kfZ7pI2Z9S2xqdcSDvJ8bFWbCOISM4fIBMes8QDG" +
       "1fEyqbsM75iIrHhbfC5suY7LlWW/2ppEaGpu8LWKo6TZdOkxIo/MQYsC/qA7" +
       "o5MhunYXaWXab00ZdJqMRuIUOEgt3A6izbITtybSaFu35STCxaEZKWgw7Gtb" +
       "f9SYdkerYZWmQrOxdFbbsbZANtRY6S6YQJ9Isj1mmA5p95uEN97E3tgt25OJ" +
       "gc1aCR21ewLiLip0phNturXCIV4LbX+ly5blDmApXGEJYa0q283Qrc6ArStx" +
       "dVjliHlUa7Rpj6oKS3SIbFnPKJvWuLLt616v64b1yHMnlXIvgwYk0RCQFRQR" +
       "vSCF1tUBJ3c2rQU0dyS0pgijAWHV6V6iGWlHbTWHXX9Z1dp2GC9DeJlladJr" +
       "TTs6jYvKjDTWQrUiw7QqluM+nGxDuatpKNXIyGaf7q5RTo/bIbJGDbORhH7E" +
       "IKslv6CsIMUHuI6owlIwR7QSb4PO1B5bGlwTym59DWMLxOdH0xExTTQvhDqm" +
       "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" +
       "LhPTfqwBhzSN18asPcCk1mwTW5MVXeY7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
