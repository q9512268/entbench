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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TTTX6KP4xfx/jlKreABFAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CHal6dfoqGbKkDWZ93pJc7CeroZdvOs0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Sdb9xXKGbmuOCOJ8swzbMjJC64ogRAtjbraYYVMur62tyshZi7BXkFqZRZjf" +
       "JRaGQbZ809Xhvlfd1rroZDJZ1AdcNdVTeGUPAg1r9zAMe3v+COIvbuzRyMuL" +
       "p0DHL+as7Eae8Uc38PQjfeEnoceP24pf/sztqnc8Tj1uO7XF6uDoQdS3XLiF" +
       "+tTz+HzX2GPnvbdTbIH80fd/5DmV/VTlcP+gk45K90ae/zZb22j2qb6/affo" +
       "9ZjuR3IyXwuOxZ7uxdnHhCcMu/4zwm/ZMfz8h64HL7sgL9/meXApKt291KLe" +
       "0e6pY/Ec3P1CD6dOt3cG2mP5zXyTyLN7aM/eemivviDvNXnycFR6xR7aVZsR" +
       "8wrSCc5HbgLn5fzmN4FD3+PUbw3Og5MCVAHoyesXONLmJ08ecpIAacrGEavv" +
       "ttN0U0Xz882RRTv5/tCDx/PNG9puJ3rHU4vBSJ0w5ImbYEgxHh8HR7BnSHBr" +
       "GHLHib2hTsg9s0sISONOZtft7v9Wb+SXfD+Ew81SDrwk1AKYAczjTMXSAtCe" +
       "Zt+etwdeTKfpCU+ut8PkAN3vODhovJQdJgfIS9thArotaufXF+wwOXjHBXn5" +
       "k/mDb81z3rWj5IKy7XT3XzlT5oTkgzcdjZg3nhoxtq0tJRsLlnG+n+fqAZNz" +
       "4uCtUemB0wMmLEg5GTFvu4kRk+/tLD0Djh/Yj5gfuE0mhLuAc+M8GUSl1xyh" +
       "pOIwMnVTKbZV55tJjvj21NU7vS8oXHCGvllbku80/eSeM5+8TZx51wWceXee" +
       "CFHplUecuWqvYl7jsydoxZtAe7xL9VN7tJ+6UbTvecEpc3VBXv6+8YEGVCB/" +
       "PTeOtGvBXndXy8Yz1RMG6DfBgHwaLb0FYNF2dXf/t0Hc2QVceE+eRFHp8pG4" +
       "h1oUmMrxVrE3v7DbeLpGwZT4ZsfA6wH537VnynfdJqZ84AKmfG+evP8UU9jd" +
       "pu0z2v9dN4Hz1flN4LcffHiP88O3CecPXoDzo3nyoXxT8pGt1+xTA/2HTqB+" +
       "/01ALdz+JwFRH99D/fhtgvojF0D9R3nyD6LSQ0dQuVNv8v7WCdAfulmgTwGS" +
       "Pr0H+ulbA/SFfME8pCo9UdptwSwd/Ucl7da6Za7p5K/0egEGzoqp78j/+8Z0" +
       "dN3NxnfptidF5zuCnzlyBH/qJTmCz79ER/AzhdI9n19f5Aj+3AV5n8+Tn81z" +
       "3rWj5IKy/2rvCP7TC8r8Qp58Oiq9/OwIKJy750+GwAtusH+hOQ1M6ge/sh8C" +
       "v3KbxvqXL0D6b/Lkl04hnQSSG+afFDia1R67egM0puvAul9dqmDFF292Jnsa" +
       "EP07e1b8zm1ixe9fwIp/nye/vVsX6O9fX4jPceZ+52anM+DZH3x1D/artxTs" +
       "kdyeflFv7BXI/+gCrvxJnnw1Kr0McKV9+i2hE2b84c0yA9jgw8Nd3d3/zTPj" +
       "NIT/eUHeX+TJf9/Nddd476cw/o9bsBB0+Mge4yO3HuNfn593mDdx8Fe7dR0m" +
       "dk6+FHBqXefrNzt6c3yP7/E9fsvxHV6wVnmYr1UeXopK9wF81/U+D29mufIY" +
       "3f6dxsNr3ml8aehOLTx8rkgKLBcsXB7mC5eHD1+E82aWK4+87MO373G+/dZL" +
       "8exK5em8fPXx8PG9gw1mmiJSut5YPLyZNcjiSyJvAui6e5TdW4/ygnfZDyt5" +
       "8hYwyfhakM+fuKZLsR3RUubF+eLzgXuCE7pZnKDeYbTHGd1qrd35179VoHrm" +
       "3Hn34E1FgfxB0WEdmNnw2pDiNOTGzUImAHHfu4f8vbcF8sGvF4j6FwiZzJM2" +
       "cKrCs07VGbidWyHhT+zhfuL2SPjnC0j8BXBzL/6QiUqXwxPHKX/v8wxY9mbD" +
       "xTcAsvbh4uEtChfPOoiHz16AM38x/lCMSg+a4RmYpZ8/gfltN+spvB7A+8k9" +
       "zJ+8PTLdYbUuwJpr6qG+iwuOncYOsMbFE7ITx+FwebMqXAOE7SOgwy/dUrjF" +
       "9fF3YvIIph9IvmEqOxf24D8XSJMLuJCv+B0GUelONZCSM+oc3gjwFHDymk/j" +
       "5d/5evSab3Puviep/MRzl+959XPT3919R+vom4/30qV79Ni2T3+p6NT5JT/Q" +
       "dLPgyb1F+qBf4Hh/VHrNuYuT++9j5DQfvm9X/rvBBHW98lHpDpCeLvlBYNPP" +
       "loxKdxX/p8t9H3BbTspFpUu7k9NFPgRaB0Xy0+/3j2R36g3N3aed0l2A8+hp" +
       "jSrgP/xC8jiucvozc3l4VHxF9egDPfHuO6rPKp99jmLe87X6p3afuVNsabvN" +
       "W7mHLt29++Je0Wj+kZ83nNvaUVuXiDd//cHP3fv00S6AB3cEn2j3KdqeuP43" +
       "5bqOHxVfgdv+zKt/6lt/7Lk/KF5R/f+tFOUG3lYAAA==");
}
