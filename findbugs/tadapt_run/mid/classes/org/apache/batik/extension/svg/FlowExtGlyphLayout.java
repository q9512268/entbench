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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Ox9Y4iT0NQy2rhuLVTpIVZ+oEv4su9uoR/EXw2fQ3gYr3JIUhbIyi1+kBXqA" +
       "OkdaAamByCnx7W2pjXyXGW6sfs7KOohy+L3bcOD4rmI64LBeYDEOV7s4fEc+" +
       "DuPXa3HYkA+s3LgGF3QHDqkiR+S+InOjONyLQ1rsogjtD+2QG+/AI2wW7CCk" +
       "IR5D/fKtjTdtO6f85EWiFijcnviu6c4fu6hm7p6HNCfWLs7tDjCkHrb9/rBw" +
       "/sbTWrCDkHSUQR0HmXydkqZxvIymmnvD9AWuhtadmZdKPcs+8dSDS7cvuup+" +
       "Ydl542ChR//k1988uGtk315Ra2LSZeTc8S7U82/x8QKkSLvi8+EHq76y/9jR" +
       "3mscH1bj8IB74qr9sCra7kcKhxeOu/n43SIx+hMctjNSh4f4G6ZkrIP/ramM" +
       "tomTr+QnT6zezkjpoK6I5mYYh++IietPAX8Lodxi2PPHQkLoo1NGORxuzUc4" +
       "IamAxCIIB/adWTD7NrVB6mEOTfNn3Dh20yQ8tmsJnXMs99kwYE+oXx25ef7j" +
       "mj9bxHW/x+FJRs7MGHHo+nqpCVAvqctVJamJi2kkeNxz11Onx13ngeVLhIRw" +
       "6HS5S0gqIDFggMDVzpfyXJEctEujVb3r+J1vL8WCAek50wrvXPy5iHEP43CA" +
       "kUkqvzLmJyJgzj+eujmz0O3k30djCTk97ycy8bOO/OhoTcW00Sv/Kq4inJ9e" +
       "qmKkIpFRVX/L43suM0yaULgiVaIuE6nvTUZmFw9eaJ1h5Ns/IniOMjJjfB6o" +
       "ZtxnP9c/GKkNckG88/9+umOMVHp0ULGIBz/Je7AnIMHHE4ZbeRR0PK9EfJbN" +
       "hvLLPe67qZ/lO199Nz8Ht/kvnk4OznTZ6WHf6Jq115286AFxAyyr0sgISpkU" +
       "I+XiMtrtlOaNK82RVba6+ZPqxyYucDJAndiwd7Jm+uJ0M+CFgQE0I3A9ajW5" +
       "t6SHd1/6zEvbyw5B7lpPQhI0quvzW+6skYF6ZH2s0A0J9JH85ral8uiGAx+9" +
       "FqrnjQwRDevsYhz98o5nXu9KGMa9YTKxnUyAgphm+X3A5cNaN5UHzZwLl7IB" +
       "PaO512vVGO0S/hrKLWMbdLL7Fn9BYKQx/+4p/1cVaB2GqLkCpaOYyYHeMmMY" +
       "/llu2bUCqkWdVNIf6zAM+9KtbAe3vGHgoQ5xsOr8H3jrYDLWIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KxzfuHuIhx40Utc9ewp6pn4tjHTDKkl4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("aH+StPep/z6Bnrq3fiZA2zf7U9Z/t8d5LYGeuDsOCGYn9bNYf5JANy9iAfUu" +
       "/8/C/ZcEun4Kl0DX9pWzIF8GcwIgRfUr4clNkjsqSnmz5AxnsyvnY/WJ1B5/" +
       "PamdCe/PnHPa5UXX4wPVdHgUG155qTf4wW80P7u/d6S6ym5X9PIgDz2wvwJ1" +
       "cij7jrv2dtzXNea5bz76cw89e+z+H91P+NTIzszt6Ttf8ul4YVJey9n90lt+" +
       "/j0/89IflydV/wclocOIgSwAAA==");
}
