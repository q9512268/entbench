package org.apache.batik.gvt.font;
public final class SVGGVTGlyphVector implements org.apache.batik.gvt.font.GVTGlyphVector {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    private org.apache.batik.gvt.font.GVTFont font;
    private org.apache.batik.gvt.font.Glyph[] glyphs;
    private java.awt.font.FontRenderContext frc;
    private java.awt.geom.GeneralPath outline;
    private java.awt.geom.Rectangle2D logicalBounds;
    private java.awt.geom.Rectangle2D bounds2D;
    private java.awt.Shape[] glyphLogicalBounds;
    private boolean[] glyphVisible;
    private java.awt.geom.Point2D endPos;
    private org.apache.batik.gvt.text.TextPaintInfo cacheTPI;
    public SVGGVTGlyphVector(org.apache.batik.gvt.font.GVTFont font,
                             org.apache.batik.gvt.font.Glyph[] glyphs,
                             java.awt.font.FontRenderContext frc) {
        super(
          );
        this.
          font =
          font;
        this.
          glyphs =
          glyphs;
        this.
          frc =
          frc;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
        glyphLogicalBounds =
          (new java.awt.Shape[glyphs.
                                length]);
        glyphVisible =
          (new boolean[glyphs.
                         length]);
        for (int i =
               0;
             i <
               glyphs.
                 length;
             i++) {
            glyphVisible[i] =
              true;
        }
        endPos =
          glyphs[glyphs.
                   length -
                   1].
            getPosition(
              );
        endPos =
          new java.awt.geom.Point2D.Float(
            (float)
              (endPos.
                 getX(
                   ) +
                 glyphs[glyphs.
                          length -
                          1].
                 getHorizAdvX(
                   )),
            (float)
              endPos.
              getY(
                ));
    }
    public org.apache.batik.gvt.font.GVTFont getFont() { return font;
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        return frc;
    }
    public int getGlyphCode(int glyphIndex) throws java.lang.IndexOutOfBoundsException {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex " +
              glyphIndex +
              " is out of bounds, should be between 0 and " +
              (glyphs.
                 length -
                 1));
        }
        return glyphs[glyphIndex].
          getGlyphCode(
            );
    }
    public int[] getGlyphCodes(int beginGlyphIndex, int numEntries,
                               int[] codeReturn) throws java.lang.IndexOutOfBoundsException,
        java.lang.IllegalArgumentException { if (numEntries <
                                                   0) {
                                                 throw new java.lang.IllegalArgumentException(
                                                   "numEntries argument value, " +
                                                   numEntries +
                                                   ", is illegal. It must be > 0.");
                                             }
                                             if (beginGlyphIndex <
                                                   0) {
                                                 throw new java.lang.IndexOutOfBoundsException(
                                                   "beginGlyphIndex " +
                                                   beginGlyphIndex +
                                                   " is out of bounds, should be between 0 and " +
                                                   (glyphs.
                                                      length -
                                                      1));
                                             }
                                             if (beginGlyphIndex +
                                                   numEntries >
                                                   glyphs.
                                                     length) {
                                                 throw new java.lang.IndexOutOfBoundsException(
                                                   "beginGlyphIndex + numEntries (" +
                                                   beginGlyphIndex +
                                                   "+" +
                                                   numEntries +
                                                   ") exceeds the number of glpyhs in this GlyphVector");
                                             }
                                             if (codeReturn ==
                                                   null) {
                                                 codeReturn =
                                                   (new int[numEntries]);
                                             }
                                             for (int i =
                                                    beginGlyphIndex;
                                                  i <
                                                    beginGlyphIndex +
                                                    numEntries;
                                                  i++) {
                                                 codeReturn[i -
                                                              beginGlyphIndex] =
                                                   glyphs[i].
                                                     getGlyphCode(
                                                       );
                                             }
                                             return codeReturn;
    }
    public java.awt.font.GlyphJustificationInfo getGlyphJustificationInfo(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              ".");
        }
        return null;
    }
    public java.awt.Shape getGlyphLogicalBounds(int glyphIndex) {
        if (glyphLogicalBounds[glyphIndex] ==
              null &&
              glyphVisible[glyphIndex]) {
            computeGlyphLogicalBounds(
              );
        }
        return glyphLogicalBounds[glyphIndex];
    }
    private void computeGlyphLogicalBounds() {
        float ascent =
          0;
        float descent =
          0;
        if (font !=
              null) {
            org.apache.batik.gvt.font.GVTLineMetrics lineMetrics =
              font.
              getLineMetrics(
                "By",
                frc);
            ascent =
              lineMetrics.
                getAscent(
                  );
            descent =
              lineMetrics.
                getDescent(
                  );
            if (descent <
                  0) {
                descent =
                  -descent;
            }
        }
        if (ascent ==
              0) {
            float maxAscent =
              0;
            float maxDescent =
              0;
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                if (!glyphVisible[i])
                    continue;
                org.apache.batik.gvt.font.GVTGlyphMetrics glyphMetrics =
                  getGlyphMetrics(
                    i);
                java.awt.geom.Rectangle2D glyphBounds =
                  glyphMetrics.
                  getBounds2D(
                    );
                ascent =
                  (float)
                    -glyphBounds.
                    getMinY(
                      );
                descent =
                  (float)
                    (glyphBounds.
                       getHeight(
                         ) -
                       ascent);
                if (ascent >
                      maxAscent)
                    maxAscent =
                      ascent;
                if (descent >
                      maxDescent)
                    maxDescent =
                      descent;
            }
            ascent =
              maxAscent;
            descent =
              maxDescent;
        }
        java.awt.Shape[] tempLogicalBounds =
          new java.awt.Shape[getNumGlyphs(
                               )];
        boolean[] rotated =
          new boolean[getNumGlyphs(
                        )];
        double maxWidth =
          -1;
        double maxHeight =
          -1;
        for (int i =
               0;
             i <
               getNumGlyphs(
                 );
             i++) {
            if (!glyphVisible[i]) {
                tempLogicalBounds[i] =
                  null;
                continue;
            }
            java.awt.geom.AffineTransform glyphTransform =
              getGlyphTransform(
                i);
            org.apache.batik.gvt.font.GVTGlyphMetrics glyphMetrics =
              getGlyphMetrics(
                i);
            java.awt.geom.Rectangle2D glyphBounds =
              new java.awt.geom.Rectangle2D.Double(
              0,
              -ascent,
              glyphMetrics.
                getHorizontalAdvance(
                  ),
              ascent +
                descent);
            if (glyphBounds.
                  isEmpty(
                    )) {
                if (i >
                      0) {
                    rotated[i] =
                      rotated[i -
                                1];
                }
                else {
                    rotated[i] =
                      true;
                }
            }
            else {
                java.awt.geom.Point2D p1 =
                  new java.awt.geom.Point2D.Double(
                  glyphBounds.
                    getMinX(
                      ),
                  glyphBounds.
                    getMinY(
                      ));
                java.awt.geom.Point2D p2 =
                  new java.awt.geom.Point2D.Double(
                  glyphBounds.
                    getMaxX(
                      ),
                  glyphBounds.
                    getMinY(
                      ));
                java.awt.geom.Point2D p3 =
                  new java.awt.geom.Point2D.Double(
                  glyphBounds.
                    getMinX(
                      ),
                  glyphBounds.
                    getMaxY(
                      ));
                java.awt.geom.Point2D gpos =
                  getGlyphPosition(
                    i);
                java.awt.geom.AffineTransform tr =
                  java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    gpos.
                      getX(
                        ),
                    gpos.
                      getY(
                        ));
                if (glyphTransform !=
                      null)
                    tr.
                      concatenate(
                        glyphTransform);
                tempLogicalBounds[i] =
                  tr.
                    createTransformedShape(
                      glyphBounds);
                java.awt.geom.Point2D tp1 =
                  new java.awt.geom.Point2D.Double(
                  );
                java.awt.geom.Point2D tp2 =
                  new java.awt.geom.Point2D.Double(
                  );
                java.awt.geom.Point2D tp3 =
                  new java.awt.geom.Point2D.Double(
                  );
                tr.
                  transform(
                    p1,
                    tp1);
                tr.
                  transform(
                    p2,
                    tp2);
                tr.
                  transform(
                    p3,
                    tp3);
                double tdx12 =
                  tp1.
                  getX(
                    ) -
                  tp2.
                  getX(
                    );
                double tdx13 =
                  tp1.
                  getX(
                    ) -
                  tp3.
                  getX(
                    );
                double tdy12 =
                  tp1.
                  getY(
                    ) -
                  tp2.
                  getY(
                    );
                double tdy13 =
                  tp1.
                  getY(
                    ) -
                  tp3.
                  getY(
                    );
                if (java.lang.Math.
                      abs(
                        tdx12) <
                      0.001 &&
                      java.lang.Math.
                      abs(
                        tdy13) <
                      0.001) {
                    rotated[i] =
                      false;
                }
                else
                    if (java.lang.Math.
                          abs(
                            tdx13) <
                          0.001 &&
                          java.lang.Math.
                          abs(
                            tdy12) <
                          0.001) {
                        rotated[i] =
                          false;
                    }
                    else {
                        rotated[i] =
                          true;
                    }
                java.awt.geom.Rectangle2D rectBounds;
                rectBounds =
                  tempLogicalBounds[i].
                    getBounds2D(
                      );
                if (rectBounds.
                      getWidth(
                        ) >
                      maxWidth)
                    maxWidth =
                      rectBounds.
                        getWidth(
                          );
                if (rectBounds.
                      getHeight(
                        ) >
                      maxHeight)
                    maxHeight =
                      rectBounds.
                        getHeight(
                          );
            }
        }
        java.awt.geom.GeneralPath logicalBoundsPath =
          new java.awt.geom.GeneralPath(
          );
        for (int i =
               0;
             i <
               getNumGlyphs(
                 );
             i++) {
            if (tempLogicalBounds[i] !=
                  null) {
                logicalBoundsPath.
                  append(
                    tempLogicalBounds[i],
                    false);
            }
        }
        java.awt.geom.Rectangle2D fullBounds =
          logicalBoundsPath.
          getBounds2D(
            );
        if (fullBounds.
              getHeight(
                ) <
              maxHeight *
              1.5) {
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                if (rotated[i])
                    continue;
                if (tempLogicalBounds[i] ==
                      null)
                    continue;
                java.awt.geom.Rectangle2D glyphBounds =
                  tempLogicalBounds[i].
                  getBounds2D(
                    );
                double x =
                  glyphBounds.
                  getMinX(
                    );
                double width =
                  glyphBounds.
                  getWidth(
                    );
                if (i <
                      getNumGlyphs(
                        ) -
                      1 &&
                      tempLogicalBounds[i +
                                          1] !=
                      null) {
                    java.awt.geom.Rectangle2D ngb =
                      tempLogicalBounds[i +
                                          1].
                      getBounds2D(
                        );
                    if (ngb.
                          getX(
                            ) >
                          x) {
                        double nw =
                          ngb.
                          getX(
                            ) -
                          x;
                        if (nw <
                              width *
                              1.15 &&
                              nw >
                              width *
                              0.85) {
                            double delta =
                              (nw -
                                 width) *
                              0.5;
                            width +=
                              delta;
                            ngb.
                              setRect(
                                ngb.
                                  getX(
                                    ) -
                                  delta,
                                ngb.
                                  getY(
                                    ),
                                ngb.
                                  getWidth(
                                    ) +
                                  delta,
                                ngb.
                                  getHeight(
                                    ));
                        }
                    }
                }
                tempLogicalBounds[i] =
                  new java.awt.geom.Rectangle2D.Double(
                    x,
                    fullBounds.
                      getMinY(
                        ),
                    width,
                    fullBounds.
                      getHeight(
                        ));
            }
        }
        else
            if (fullBounds.
                  getWidth(
                    ) <
                  maxWidth *
                  1.5) {
                for (int i =
                       0;
                     i <
                       getNumGlyphs(
                         );
                     i++) {
                    if (rotated[i])
                        continue;
                    if (tempLogicalBounds[i] ==
                          null)
                        continue;
                    java.awt.geom.Rectangle2D glyphBounds =
                      tempLogicalBounds[i].
                      getBounds2D(
                        );
                    double y =
                      glyphBounds.
                      getMinY(
                        );
                    double height =
                      glyphBounds.
                      getHeight(
                        );
                    if (i <
                          getNumGlyphs(
                            ) -
                          1 &&
                          tempLogicalBounds[i +
                                              1] !=
                          null) {
                        java.awt.geom.Rectangle2D ngb =
                          tempLogicalBounds[i +
                                              1].
                          getBounds2D(
                            );
                        if (ngb.
                              getY(
                                ) >
                              y) {
                            double nh =
                              ngb.
                              getY(
                                ) -
                              y;
                            if (nh <
                                  height *
                                  1.15 &&
                                  nh >
                                  height *
                                  0.85) {
                                double delta =
                                  (nh -
                                     height) *
                                  0.5;
                                height +=
                                  delta;
                                ngb.
                                  setRect(
                                    ngb.
                                      getX(
                                        ),
                                    ngb.
                                      getY(
                                        ) -
                                      delta,
                                    ngb.
                                      getWidth(
                                        ),
                                    ngb.
                                      getHeight(
                                        ) +
                                      delta);
                            }
                        }
                    }
                    tempLogicalBounds[i] =
                      new java.awt.geom.Rectangle2D.Double(
                        fullBounds.
                          getMinX(
                            ),
                        y,
                        fullBounds.
                          getWidth(
                            ),
                        height);
                }
            }
        java.lang.System.
          arraycopy(
            tempLogicalBounds,
            0,
            glyphLogicalBounds,
            0,
            getNumGlyphs(
              ));
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int idx) {
        if (idx <
              0 ||
              idx >
              glyphs.
                length -
              1)
            throw new java.lang.IndexOutOfBoundsException(
              "idx: " +
              idx +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        if (idx <
              glyphs.
                length -
              1) {
            if (font !=
                  null) {
                float hkern =
                  font.
                  getHKern(
                    glyphs[idx].
                      getGlyphCode(
                        ),
                    glyphs[idx +
                             1].
                      getGlyphCode(
                        ));
                float vkern =
                  font.
                  getVKern(
                    glyphs[idx].
                      getGlyphCode(
                        ),
                    glyphs[idx +
                             1].
                      getGlyphCode(
                        ));
                return glyphs[idx].
                  getGlyphMetrics(
                    hkern,
                    vkern);
            }
        }
        return glyphs[idx].
          getGlyphMetrics(
            );
    }
    public java.awt.Shape getGlyphOutline(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              ".");
        }
        return glyphs[glyphIndex].
          getOutline(
            );
    }
    public java.awt.geom.Rectangle2D getGlyphCellBounds(int glyphIndex) {
        return getGlyphLogicalBounds(
                 glyphIndex).
          getBounds2D(
            );
    }
    public java.awt.geom.Point2D getGlyphPosition(int glyphIndex) {
        if (glyphIndex ==
              glyphs.
                length)
            return endPos;
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        return glyphs[glyphIndex].
          getPosition(
            );
    }
    public float[] getGlyphPositions(int beginGlyphIndex,
                                     int numEntries,
                                     float[] positionReturn) {
        if (numEntries <
              0) {
            throw new java.lang.IllegalArgumentException(
              "numEntries argument value, " +
              numEntries +
              ", is illegal. It must be > 0.");
        }
        if (beginGlyphIndex <
              0) {
            throw new java.lang.IndexOutOfBoundsException(
              "beginGlyphIndex " +
              beginGlyphIndex +
              " is out of bounds, should be between 0 and " +
              (glyphs.
                 length -
                 1));
        }
        if (beginGlyphIndex +
              numEntries >
              glyphs.
                length +
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "beginGlyphIndex + numEntries (" +
              beginGlyphIndex +
              '+' +
              numEntries +
              ") exceeds the number of glpyhs in this GlyphVector");
        }
        if (positionReturn ==
              null) {
            positionReturn =
              (new float[numEntries *
                           2]);
        }
        if (beginGlyphIndex +
              numEntries ==
              glyphs.
                length +
              1) {
            numEntries--;
            positionReturn[numEntries *
                             2] =
              (float)
                endPos.
                getX(
                  );
            positionReturn[numEntries *
                             2 +
                             1] =
              (float)
                endPos.
                getY(
                  );
        }
        for (int i =
               beginGlyphIndex;
             i <
               beginGlyphIndex +
               numEntries;
             i++) {
            java.awt.geom.Point2D glyphPos;
            glyphPos =
              glyphs[i].
                getPosition(
                  );
            positionReturn[(i -
                              beginGlyphIndex) *
                             2] =
              (float)
                glyphPos.
                getX(
                  );
            positionReturn[(i -
                              beginGlyphIndex) *
                             2 +
                             1] =
              (float)
                glyphPos.
                getY(
                  );
        }
        return positionReturn;
    }
    public java.awt.geom.AffineTransform getGlyphTransform(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        return glyphs[glyphIndex].
          getTransform(
            );
    }
    public java.awt.Shape getGlyphVisualBounds(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        return glyphs[glyphIndex].
          getOutline(
            );
    }
    public java.awt.geom.Rectangle2D getBounds2D(java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              PAINT_INFO);
        if (bounds2D !=
              null &&
              org.apache.batik.gvt.text.TextPaintInfo.
              equivilent(
                tpi,
                cacheTPI))
            return bounds2D;
        java.awt.geom.Rectangle2D b =
          null;
        if (tpi.
              visible) {
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                if (!glyphVisible[i])
                    continue;
                java.awt.geom.Rectangle2D glyphBounds =
                  glyphs[i].
                  getBounds2D(
                    );
                if (glyphBounds ==
                      null)
                    continue;
                if (b ==
                      null)
                    b =
                      glyphBounds;
                else
                    b.
                      add(
                        glyphBounds);
            }
        }
        bounds2D =
          b;
        if (bounds2D ==
              null) {
            bounds2D =
              new java.awt.geom.Rectangle2D.Float(
                );
        }
        cacheTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
            tpi);
        return bounds2D;
    }
    public java.awt.geom.Rectangle2D getLogicalBounds() {
        if (logicalBounds ==
              null) {
            java.awt.geom.GeneralPath logicalBoundsPath =
              new java.awt.geom.GeneralPath(
              );
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                java.awt.Shape glyphLogicalBounds =
                  getGlyphLogicalBounds(
                    i);
                if (glyphLogicalBounds !=
                      null) {
                    logicalBoundsPath.
                      append(
                        glyphLogicalBounds,
                        false);
                }
            }
            logicalBounds =
              logicalBoundsPath.
                getBounds2D(
                  );
        }
        return logicalBounds;
    }
    public int getNumGlyphs() { if (glyphs !=
                                      null) {
                                    return glyphs.
                                             length;
                                }
                                return 0;
    }
    public java.awt.Shape getOutline() { if (outline ==
                                               null) {
                                             outline =
                                               new java.awt.geom.GeneralPath(
                                                 );
                                             for (int i =
                                                    0;
                                                  i <
                                                    glyphs.
                                                      length;
                                                  i++) {
                                                 if (glyphVisible[i]) {
                                                     java.awt.Shape glyphOutline =
                                                       glyphs[i].
                                                       getOutline(
                                                         );
                                                     if (glyphOutline !=
                                                           null) {
                                                         outline.
                                                           append(
                                                             glyphOutline,
                                                             false);
                                                     }
                                                 }
                                             }
                                         }
                                         return outline;
    }
    public java.awt.Shape getOutline(float x,
                                     float y) {
        java.awt.Shape outline =
          getOutline(
            );
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            x,
            y);
        java.awt.Shape translatedOutline =
          tr.
          createTransformedShape(
            outline);
        return translatedOutline;
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        return getOutline(
                 ).
          getBounds2D(
            );
    }
    public void performDefaultLayout() { logicalBounds =
                                           null;
                                         outline =
                                           null;
                                         bounds2D =
                                           null;
                                         float currentX =
                                           0;
                                         float currentY =
                                           0;
                                         for (int i =
                                                0;
                                              i <
                                                glyphs.
                                                  length;
                                              i++) {
                                             org.apache.batik.gvt.font.Glyph g =
                                               glyphs[i];
                                             g.
                                               setTransform(
                                                 null);
                                             glyphLogicalBounds[i] =
                                               null;
                                             java.lang.String uni =
                                               g.
                                               getUnicode(
                                                 );
                                             if (uni !=
                                                   null &&
                                                   uni.
                                                   length(
                                                     ) !=
                                                   0 &&
                                                   org.apache.batik.gvt.text.ArabicTextHandler.
                                                   arabicCharTransparent(
                                                     uni.
                                                       charAt(
                                                         0))) {
                                                 int j;
                                                 for (j =
                                                        i +
                                                          1;
                                                      j <
                                                        glyphs.
                                                          length;
                                                      j++) {
                                                     uni =
                                                       glyphs[j].
                                                         getUnicode(
                                                           );
                                                     if (uni ==
                                                           null ||
                                                           uni.
                                                           length(
                                                             ) ==
                                                           0)
                                                         break;
                                                     char ch =
                                                       uni.
                                                       charAt(
                                                         0);
                                                     if (!org.apache.batik.gvt.text.ArabicTextHandler.
                                                           arabicCharTransparent(
                                                             ch))
                                                         break;
                                                 }
                                                 if (j !=
                                                       glyphs.
                                                         length) {
                                                     org.apache.batik.gvt.font.Glyph bg =
                                                       glyphs[j];
                                                     float rEdge =
                                                       currentX +
                                                       bg.
                                                       getHorizAdvX(
                                                         );
                                                     for (int k =
                                                            i;
                                                          k <
                                                            j;
                                                          k++) {
                                                         g =
                                                           glyphs[k];
                                                         g.
                                                           setTransform(
                                                             null);
                                                         glyphLogicalBounds[i] =
                                                           null;
                                                         g.
                                                           setPosition(
                                                             new java.awt.geom.Point2D.Float(
                                                               rEdge -
                                                                 g.
                                                                 getHorizAdvX(
                                                                   ),
                                                               currentY));
                                                     }
                                                     i =
                                                       j;
                                                     g =
                                                       bg;
                                                 }
                                             }
                                             g.
                                               setPosition(
                                                 new java.awt.geom.Point2D.Float(
                                                   currentX,
                                                   currentY));
                                             currentX +=
                                               g.
                                                 getHorizAdvX(
                                                   );
                                         }
                                         endPos =
                                           new java.awt.geom.Point2D.Float(
                                             currentX,
                                             currentY);
    }
    public void setGlyphPosition(int glyphIndex,
                                 java.awt.geom.Point2D newPos)
          throws java.lang.IndexOutOfBoundsException {
        if (glyphIndex ==
              glyphs.
                length) {
            endPos =
              (java.awt.geom.Point2D)
                newPos.
                clone(
                  );
            return;
        }
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        glyphs[glyphIndex].
          setPosition(
            newPos);
        glyphLogicalBounds[glyphIndex] =
          null;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
    }
    public void setGlyphTransform(int glyphIndex,
                                  java.awt.geom.AffineTransform newTX) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        glyphs[glyphIndex].
          setTransform(
            newTX);
        glyphLogicalBounds[glyphIndex] =
          null;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
    }
    public void setGlyphVisible(int glyphIndex,
                                boolean visible) {
        if (visible ==
              glyphVisible[glyphIndex])
            return;
        glyphVisible[glyphIndex] =
          visible;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
        glyphLogicalBounds[glyphIndex] =
          null;
    }
    public boolean isGlyphVisible(int glyphIndex) {
        return glyphVisible[glyphIndex];
    }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        int numChars =
          0;
        if (startGlyphIndex <
              0) {
            startGlyphIndex =
              0;
        }
        if (endGlyphIndex >
              glyphs.
                length -
              1) {
            endGlyphIndex =
              glyphs.
                length -
                1;
        }
        for (int i =
               startGlyphIndex;
             i <=
               endGlyphIndex;
             i++) {
            org.apache.batik.gvt.font.Glyph glyph =
              glyphs[i];
            if (glyph.
                  getGlyphCode(
                    ) ==
                  -1) {
                numChars++;
            }
            else {
                java.lang.String glyphUnicode =
                  glyph.
                  getUnicode(
                    );
                numChars +=
                  glyphUnicode.
                    length(
                      );
            }
        }
        return numChars;
    }
    public void draw(java.awt.Graphics2D graphics2D,
                     java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              PAINT_INFO);
        if (!tpi.
               visible)
            return;
        for (int i =
               0;
             i <
               glyphs.
                 length;
             i++) {
            if (glyphVisible[i]) {
                glyphs[i].
                  draw(
                    graphics2D);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3GBwczaLBCvxgKV0iZ/i2Uv/C5vCWP83RwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kGwuO4tmGxv2XSs/OIH3V2jCWa7E1bSK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "L7htf+p1P/HNP/z87xevrP4/3M7r2H5WAAA=");
}
