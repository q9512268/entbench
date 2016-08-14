package org.apache.batik.extension.svg;
public class FlowExtGlyphLayout extends org.apache.batik.gvt.text.GlyphLayout {
    public FlowExtGlyphLayout(java.text.AttributedCharacterIterator aci, int[] charMap,
                              java.awt.geom.Point2D offset,
                              java.awt.font.FontRenderContext frc) {
        super(
          aci,
          charMap,
          offset,
          frc);
    }
    public static void textWrapTextChunk(java.text.AttributedCharacterIterator[] acis,
                                         java.util.List chunkLayouts,
                                         java.util.List flowRects) {
        org.apache.batik.gvt.font.GVTGlyphVector[] gvs =
          new org.apache.batik.gvt.font.GVTGlyphVector[acis.
                                                         length];
        java.util.List[] chunkLineInfos =
          new java.util.List[acis.
                               length];
        org.apache.batik.extension.svg.GlyphIterator[] gis =
          new org.apache.batik.extension.svg.GlyphIterator[acis.
                                                             length];
        java.util.Iterator clIter =
          chunkLayouts.
          iterator(
            );
        java.util.Iterator flowRectsIter =
          flowRects.
          iterator(
            );
        org.apache.batik.extension.svg.RegionInfo currentRegion =
          null;
        float y0;
        float x0;
        float width;
        float height =
          0;
        if (flowRectsIter.
              hasNext(
                )) {
            currentRegion =
              (org.apache.batik.extension.svg.RegionInfo)
                flowRectsIter.
                next(
                  );
            height =
              (float)
                currentRegion.
                getHeight(
                  );
        }
        boolean lineHeightRelative =
          true;
        float lineHeight =
          1.0F;
        float nextLineMult =
          0.0F;
        float dy =
          0.0F;
        java.awt.geom.Point2D.Float verticalAlignOffset =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        float prevBotMargin =
          0;
        for (int chunk =
               0;
             clIter.
               hasNext(
                 );
             chunk++) {
            java.text.AttributedCharacterIterator aci =
              acis[chunk];
            if (currentRegion !=
                  null) {
                java.util.List extraP =
                  (java.util.List)
                    aci.
                    getAttribute(
                      FLOW_EMPTY_PARAGRAPH);
                if (extraP !=
                      null) {
                    java.util.Iterator epi =
                      extraP.
                      iterator(
                        );
                    while (epi.
                             hasNext(
                               )) {
                        org.apache.batik.extension.svg.MarginInfo emi =
                          (org.apache.batik.extension.svg.MarginInfo)
                            epi.
                            next(
                              );
                        float inc =
                          prevBotMargin >
                          emi.
                          getTopMargin(
                            )
                          ? prevBotMargin
                          : emi.
                          getTopMargin(
                            );
                        if (dy +
                              inc <=
                              height &&
                              !emi.
                              isFlowRegionBreak(
                                )) {
                            dy +=
                              inc;
                            prevBotMargin =
                              emi.
                                getBottomMargin(
                                  );
                        }
                        else {
                            if (!flowRectsIter.
                                  hasNext(
                                    )) {
                                currentRegion =
                                  null;
                                break;
                            }
                            currentRegion =
                              (org.apache.batik.extension.svg.RegionInfo)
                                flowRectsIter.
                                next(
                                  );
                            height =
                              (float)
                                currentRegion.
                                getHeight(
                                  );
                            verticalAlignOffset =
                              new java.awt.geom.Point2D.Float(
                                0,
                                0);
                            dy =
                              0;
                            prevBotMargin =
                              0;
                        }
                    }
                    if (currentRegion ==
                          null)
                        break;
                }
            }
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
            int numGlyphs =
              gv.
              getNumGlyphs(
                );
            aci.
              first(
                );
            org.apache.batik.extension.svg.MarginInfo mi =
              (org.apache.batik.extension.svg.MarginInfo)
                aci.
                getAttribute(
                  FLOW_PARAGRAPH);
            if (mi ==
                  null) {
                continue;
            }
            if (currentRegion ==
                  null) {
                for (int idx =
                       0;
                     idx <
                       numGlyphs;
                     idx++)
                    gv.
                      setGlyphVisible(
                        idx,
                        false);
                continue;
            }
            float inc =
              prevBotMargin >
              mi.
              getTopMargin(
                )
              ? prevBotMargin
              : mi.
              getTopMargin(
                );
            if (dy +
                  inc <=
                  height) {
                dy +=
                  inc;
            }
            else {
                if (!flowRectsIter.
                      hasNext(
                        )) {
                    currentRegion =
                      null;
                    break;
                }
                currentRegion =
                  (org.apache.batik.extension.svg.RegionInfo)
                    flowRectsIter.
                    next(
                      );
                height =
                  (float)
                    currentRegion.
                    getHeight(
                      );
                verticalAlignOffset =
                  new java.awt.geom.Point2D.Float(
                    0,
                    0);
                dy =
                  mi.
                    getTopMargin(
                      );
            }
            prevBotMargin =
              mi.
                getBottomMargin(
                  );
            float leftMargin =
              mi.
              getLeftMargin(
                );
            float rightMargin =
              mi.
              getRightMargin(
                );
            if (((org.apache.batik.gvt.text.GlyphLayout)
                   layouts.
                   get(
                     0)).
                  isLeftToRight(
                    )) {
                leftMargin +=
                  mi.
                    getIndent(
                      );
            }
            else {
                rightMargin +=
                  mi.
                    getIndent(
                      );
            }
            x0 =
              (float)
                currentRegion.
                getX(
                  ) +
                leftMargin;
            y0 =
              (float)
                currentRegion.
                getY(
                  );
            width =
              (float)
                (currentRegion.
                   getWidth(
                     ) -
                   (leftMargin +
                      rightMargin));
            height =
              (float)
                currentRegion.
                getHeight(
                  );
            java.util.List lineInfos =
              new java.util.LinkedList(
              );
            chunkLineInfos[chunk] =
              lineInfos;
            float prevDesc =
              0.0F;
            org.apache.batik.extension.svg.GlyphIterator gi =
              new org.apache.batik.extension.svg.GlyphIterator(
              aci,
              gv);
            gis[chunk] =
              gi;
            org.apache.batik.extension.svg.GlyphIterator breakGI =
              null;
            org.apache.batik.extension.svg.GlyphIterator newBreakGI =
              null;
            if (!gi.
                  done(
                    ) &&
                  !gi.
                  isPrinting(
                    )) {
                updateVerticalAlignOffset(
                  verticalAlignOffset,
                  currentRegion,
                  dy);
                lineInfos.
                  add(
                    gi.
                      newLine(
                        new java.awt.geom.Point2D.Float(
                          x0,
                          y0 +
                            dy),
                        width,
                        true,
                        verticalAlignOffset));
            }
            org.apache.batik.extension.svg.GlyphIterator lineGI =
              gi.
              copy1(
                );
            boolean firstLine =
              true;
            while (!gi.
                     done(
                       )) {
                boolean doBreak =
                  false;
                boolean partial =
                  false;
                if (gi.
                      isPrinting(
                        ) &&
                      gi.
                      getAdv(
                        ) >
                      width) {
                    if (breakGI ==
                          null) {
                        if (!flowRectsIter.
                              hasNext(
                                )) {
                            currentRegion =
                              null;
                            gi =
                              lineGI.
                                copy1(
                                  gi);
                            break;
                        }
                        currentRegion =
                          (org.apache.batik.extension.svg.RegionInfo)
                            flowRectsIter.
                            next(
                              );
                        x0 =
                          (float)
                            currentRegion.
                            getX(
                              ) +
                            leftMargin;
                        y0 =
                          (float)
                            currentRegion.
                            getY(
                              );
                        width =
                          (float)
                            (currentRegion.
                               getWidth(
                                 ) -
                               (leftMargin +
                                  rightMargin));
                        height =
                          (float)
                            currentRegion.
                            getHeight(
                              );
                        verticalAlignOffset =
                          new java.awt.geom.Point2D.Float(
                            0,
                            0);
                        dy =
                          firstLine
                            ? mi.
                            getTopMargin(
                              )
                            : 0;
                        prevDesc =
                          0;
                        gi =
                          lineGI.
                            copy1(
                              gi);
                        continue;
                    }
                    gi =
                      breakGI.
                        copy1(
                          gi);
                    nextLineMult =
                      1;
                    doBreak =
                      true;
                    partial =
                      false;
                }
                else
                    if (gi.
                          isLastChar(
                            )) {
                        nextLineMult =
                          1;
                        doBreak =
                          true;
                        partial =
                          true;
                    }
                int lnBreaks =
                  gi.
                  getLineBreaks(
                    );
                if (lnBreaks !=
                      0) {
                    if (doBreak)
                        nextLineMult -=
                          1;
                    nextLineMult +=
                      lnBreaks;
                    doBreak =
                      true;
                    partial =
                      true;
                }
                if (!doBreak) {
                    if (gi.
                          isBreakChar(
                            ) ||
                          breakGI ==
                          null ||
                          !breakGI.
                          isBreakChar(
                            )) {
                        newBreakGI =
                          gi.
                            copy1(
                              newBreakGI);
                        gi.
                          nextChar(
                            );
                        if (gi.
                              getChar(
                                ) !=
                              org.apache.batik.extension.svg.GlyphIterator.
                                ZERO_WIDTH_JOINER) {
                            org.apache.batik.extension.svg.GlyphIterator tmpGI =
                              breakGI;
                            breakGI =
                              newBreakGI;
                            newBreakGI =
                              tmpGI;
                        }
                    }
                    else {
                        gi.
                          nextChar(
                            );
                    }
                    continue;
                }
                float lineSize =
                  gi.
                  getMaxAscent(
                    ) +
                  gi.
                  getMaxDescent(
                    );
                float lineBoxHeight;
                if (lineHeightRelative)
                    lineBoxHeight =
                      gi.
                        getMaxFontSize(
                          ) *
                        lineHeight;
                else
                    lineBoxHeight =
                      lineHeight;
                float halfLeading =
                  (lineBoxHeight -
                     lineSize) /
                  2;
                float ladv =
                  prevDesc +
                  halfLeading +
                  gi.
                  getMaxAscent(
                    );
                float newDesc =
                  halfLeading +
                  gi.
                  getMaxDescent(
                    );
                dy +=
                  ladv;
                float bottomEdge =
                  newDesc;
                if (newDesc <
                      gi.
                      getMaxDescent(
                        ))
                    bottomEdge =
                      gi.
                        getMaxDescent(
                          );
                if (dy +
                      bottomEdge >
                      height) {
                    if (!flowRectsIter.
                          hasNext(
                            )) {
                        currentRegion =
                          null;
                        gi =
                          lineGI.
                            copy1(
                              gi);
                        break;
                    }
                    float oldWidth =
                      width;
                    currentRegion =
                      (org.apache.batik.extension.svg.RegionInfo)
                        flowRectsIter.
                        next(
                          );
                    x0 =
                      (float)
                        currentRegion.
                        getX(
                          ) +
                        leftMargin;
                    y0 =
                      (float)
                        currentRegion.
                        getY(
                          );
                    width =
                      (float)
                        (currentRegion.
                           getWidth(
                             ) -
                           (leftMargin +
                              rightMargin));
                    height =
                      (float)
                        currentRegion.
                        getHeight(
                          );
                    verticalAlignOffset =
                      new java.awt.geom.Point2D.Float(
                        0,
                        0);
                    dy =
                      firstLine
                        ? mi.
                        getTopMargin(
                          )
                        : 0;
                    prevDesc =
                      0;
                    if (oldWidth >
                          width ||
                          lnBreaks !=
                          0) {
                        gi =
                          lineGI.
                            copy1(
                              gi);
                    }
                    continue;
                }
                prevDesc =
                  newDesc +
                    (nextLineMult -
                       1) *
                    lineBoxHeight;
                nextLineMult =
                  0.0F;
                updateVerticalAlignOffset(
                  verticalAlignOffset,
                  currentRegion,
                  dy +
                    bottomEdge);
                lineInfos.
                  add(
                    gi.
                      newLine(
                        new java.awt.geom.Point2D.Float(
                          x0,
                          y0 +
                            dy),
                        width,
                        partial,
                        verticalAlignOffset));
                x0 -=
                  leftMargin;
                width +=
                  leftMargin +
                    rightMargin;
                leftMargin =
                  mi.
                    getLeftMargin(
                      );
                rightMargin =
                  mi.
                    getRightMargin(
                      );
                x0 +=
                  leftMargin;
                width -=
                  leftMargin +
                    rightMargin;
                firstLine =
                  false;
                lineGI =
                  gi.
                    copy1(
                      lineGI);
                breakGI =
                  null;
            }
            dy +=
              prevDesc;
            int idx =
              gi.
              getGlyphIndex(
                );
            while (idx <
                     numGlyphs)
                gv.
                  setGlyphVisible(
                    idx++,
                    false);
            if (mi.
                  isFlowRegionBreak(
                    )) {
                currentRegion =
                  null;
                if (flowRectsIter.
                      hasNext(
                        )) {
                    currentRegion =
                      (org.apache.batik.extension.svg.RegionInfo)
                        flowRectsIter.
                        next(
                          );
                    height =
                      (float)
                        currentRegion.
                        getHeight(
                          );
                    dy =
                      0;
                    prevBotMargin =
                      0;
                    verticalAlignOffset =
                      new java.awt.geom.Point2D.Float(
                        0,
                        0);
                }
            }
        }
        for (int chunk =
               0;
             chunk <
               acis.
                 length;
             chunk++) {
            java.util.List lineInfos =
              chunkLineInfos[chunk];
            if (lineInfos ==
                  null)
                continue;
            java.text.AttributedCharacterIterator aci =
              acis[chunk];
            aci.
              first(
                );
            org.apache.batik.extension.svg.MarginInfo mi =
              (org.apache.batik.extension.svg.MarginInfo)
                aci.
                getAttribute(
                  FLOW_PARAGRAPH);
            if (mi ==
                  null) {
                continue;
            }
            int justification =
              mi.
              getJustification(
                );
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              gvs[chunk];
            if (gv ==
                  null)
                break;
            org.apache.batik.extension.svg.GlyphIterator gi =
              gis[chunk];
            layoutChunk(
              gv,
              gi.
                getOrigin(
                  ),
              justification,
              lineInfos);
        }
    }
    public static void updateVerticalAlignOffset(java.awt.geom.Point2D.Float verticalAlignOffset,
                                                 org.apache.batik.extension.svg.RegionInfo region,
                                                 float maxDescent) {
        float freeSpace =
          (float)
            region.
            getHeight(
              ) -
          maxDescent;
        verticalAlignOffset.
          setLocation(
            0,
            region.
              getVerticalAlignment(
                ) *
              freeSpace);
    }
    public static void layoutChunk(org.apache.batik.gvt.font.GVTGlyphVector gv,
                                   java.awt.geom.Point2D origin,
                                   int justification,
                                   java.util.List lineInfos) {
        java.util.Iterator lInfoIter =
          lineInfos.
          iterator(
            );
        int numGlyphs =
          gv.
          getNumGlyphs(
            );
        float[] gp =
          gv.
          getGlyphPositions(
            0,
            numGlyphs +
              1,
            null);
        java.awt.geom.Point2D.Float lineLoc =
          null;
        float lineAdv =
          0;
        float lineVAdv =
          0;
        float xOrig =
          (float)
            origin.
            getX(
              );
        float yOrig =
          (float)
            origin.
            getY(
              );
        float xScale =
          1;
        float xAdj =
          0;
        float charW =
          0;
        float lineWidth =
          0;
        boolean partial =
          false;
        float verticalAlignOffset =
          0;
        int lineEnd =
          0;
        int i;
        java.awt.geom.Point2D.Float pos =
          new java.awt.geom.Point2D.Float(
          );
        for (i =
               0;
             i <
               numGlyphs;
             i++) {
            if (i ==
                  lineEnd) {
                xOrig +=
                  lineAdv;
                if (!lInfoIter.
                      hasNext(
                        ))
                    break;
                org.apache.batik.extension.svg.LineInfo li =
                  (org.apache.batik.extension.svg.LineInfo)
                    lInfoIter.
                    next(
                      );
                lineEnd =
                  li.
                    getEndIdx(
                      );
                lineLoc =
                  li.
                    getLocation(
                      );
                lineAdv =
                  li.
                    getAdvance(
                      );
                lineVAdv =
                  li.
                    getVisualAdvance(
                      );
                charW =
                  li.
                    getLastCharWidth(
                      );
                lineWidth =
                  li.
                    getLineWidth(
                      );
                partial =
                  li.
                    isPartialLine(
                      );
                verticalAlignOffset =
                  li.
                    getVerticalAlignOffset(
                      ).
                    y;
                xAdj =
                  0;
                xScale =
                  1;
                switch (justification) {
                    case 0:
                    default:
                        break;
                    case 1:
                        xAdj =
                          (lineWidth -
                             lineVAdv) /
                            2;
                        break;
                    case 2:
                        xAdj =
                          lineWidth -
                            lineVAdv;
                        break;
                    case 3:
                        if (!partial &&
                              lineEnd !=
                              i +
                              1) {
                            xScale =
                              (lineWidth -
                                 charW) /
                                (lineVAdv -
                                   charW);
                        }
                        break;
                }
            }
            pos.
              x =
              lineLoc.
                x +
                (gp[2 *
                      i] -
                   xOrig) *
                xScale +
                xAdj;
            pos.
              y =
              lineLoc.
                y +
                (gp[2 *
                      i +
                      1] -
                   yOrig +
                   verticalAlignOffset);
            gv.
              setGlyphPosition(
                i,
                pos);
        }
        pos.
          x =
          xOrig;
        pos.
          y =
          yOrig;
        if (lineLoc !=
              null) {
            pos.
              x =
              lineLoc.
                x +
                (gp[2 *
                      i] -
                   xOrig) *
                xScale +
                xAdj;
            pos.
              y =
              lineLoc.
                y +
                (gp[2 *
                      i +
                      1] -
                   yOrig) +
                verticalAlignOffset;
        }
        gv.
          setGlyphPosition(
            i,
            pos);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "92ahJqcgY4pTW5VdwrVNf393q+jwa6cc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/o3vlsN1wKyre9iDK3+BHL5w2+IHLnEPOLL9KVhPmJf3oEAGmgblkfDt0tNc" +
       "0Opni8m9+8xsr76BVr92Dz7/flH82xR62C0vX5X6fIGzX/pOOLtNoccv3+kq" +
       "Lqi8/dJV0v31R/XzL9948G0v8/9+f/nj+IriQzT0oJG57tnj5jP1a2GsG3ZJ" +
       "wkP7I7uw/Hs9hZ66t36mQNvX++Psr+xh/iCFnrg7DIjgJ/WzUP8thW5ehALq" +
       "Xf6f7fe1FLp+2i+Fru0rZ7t8HcwJdCmqfxSeXMu5o6KU13TOcHZ75XyCciK1" +
       "x99IamdymmfPOe3yZvDxyXXGHcWGL7w8HP/Et5qf3V/iUl05z4tRHqShB/b3" +
       "yU5Ov99519GOx7rWf/7bj/7KQ88du/9H9xM+NbIzc3v6zjemKC9MyztO+T95" +
       "26+99xdf/kp5JPh/ASTEYG+yLQAA");
}
