package org.apache.batik.gvt.font;
public class AWTGVTGlyphVector implements org.apache.batik.gvt.font.GVTGlyphVector {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    private java.awt.font.GlyphVector awtGlyphVector;
    private org.apache.batik.gvt.font.AWTGVTFont gvtFont;
    private java.text.CharacterIterator ci;
    private java.awt.geom.Point2D[] defaultGlyphPositions;
    private java.awt.geom.Point2D.Float[] glyphPositions;
    private java.awt.geom.AffineTransform[] glyphTransforms;
    private java.awt.Shape[] glyphOutlines;
    private java.awt.Shape[] glyphVisualBounds;
    private java.awt.Shape[] glyphLogicalBounds;
    private boolean[] glyphVisible;
    private org.apache.batik.gvt.font.GVTGlyphMetrics[] glyphMetrics;
    private java.awt.geom.GeneralPath outline;
    private java.awt.geom.Rectangle2D visualBounds;
    private java.awt.geom.Rectangle2D logicalBounds;
    private java.awt.geom.Rectangle2D bounds2D;
    private float scaleFactor;
    private float ascent;
    private float descent;
    private org.apache.batik.gvt.text.TextPaintInfo cacheTPI;
    public AWTGVTGlyphVector(java.awt.font.GlyphVector glyphVector,
                             org.apache.batik.gvt.font.AWTGVTFont font,
                             float scaleFactor,
                             java.text.CharacterIterator ci) { super(
                                                                 );
                                                               this.
                                                                 awtGlyphVector =
                                                                 glyphVector;
                                                               this.
                                                                 gvtFont =
                                                                 font;
                                                               this.
                                                                 scaleFactor =
                                                                 scaleFactor;
                                                               this.
                                                                 ci =
                                                                 ci;
                                                               org.apache.batik.gvt.font.GVTLineMetrics lineMetrics =
                                                                 gvtFont.
                                                                 getLineMetrics(
                                                                   "By",
                                                                   awtGlyphVector.
                                                                     getFontRenderContext(
                                                                       ));
                                                               ascent =
                                                                 lineMetrics.
                                                                   getAscent(
                                                                     );
                                                               descent =
                                                                 lineMetrics.
                                                                   getDescent(
                                                                     );
                                                               outline =
                                                                 null;
                                                               visualBounds =
                                                                 null;
                                                               logicalBounds =
                                                                 null;
                                                               bounds2D =
                                                                 null;
                                                               int numGlyphs =
                                                                 glyphVector.
                                                                 getNumGlyphs(
                                                                   );
                                                               glyphPositions =
                                                                 (new java.awt.geom.Point2D.Float[numGlyphs +
                                                                                                    1]);
                                                               glyphTransforms =
                                                                 (new java.awt.geom.AffineTransform[numGlyphs]);
                                                               glyphOutlines =
                                                                 (new java.awt.Shape[numGlyphs]);
                                                               glyphVisualBounds =
                                                                 (new java.awt.Shape[numGlyphs]);
                                                               glyphLogicalBounds =
                                                                 (new java.awt.Shape[numGlyphs]);
                                                               glyphVisible =
                                                                 (new boolean[numGlyphs]);
                                                               glyphMetrics =
                                                                 (new org.apache.batik.gvt.font.GVTGlyphMetrics[numGlyphs]);
                                                               for (int i =
                                                                      0;
                                                                    i <
                                                                      numGlyphs;
                                                                    i++) {
                                                                   glyphVisible[i] =
                                                                     true;
                                                               }
    }
    public org.apache.batik.gvt.font.GVTFont getFont() {
        return gvtFont;
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        return awtGlyphVector.
          getFontRenderContext(
            );
    }
    public int getGlyphCode(int glyphIndex) {
        return awtGlyphVector.
          getGlyphCode(
            glyphIndex);
    }
    public int[] getGlyphCodes(int beginGlyphIndex,
                               int numEntries,
                               int[] codeReturn) {
        return awtGlyphVector.
          getGlyphCodes(
            beginGlyphIndex,
            numEntries,
            codeReturn);
    }
    public java.awt.font.GlyphJustificationInfo getGlyphJustificationInfo(int glyphIndex) {
        return awtGlyphVector.
          getGlyphJustificationInfo(
            glyphIndex);
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
        if (tpi ==
              null)
            return null;
        if (!tpi.
               visible)
            return null;
        cacheTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
            tpi);
        java.awt.Shape outline =
          null;
        if (tpi.
              fillPaint !=
              null) {
            outline =
              getOutline(
                );
            bounds2D =
              outline.
                getBounds2D(
                  );
        }
        java.awt.Stroke stroke =
          tpi.
            strokeStroke;
        java.awt.Paint paint =
          tpi.
            strokePaint;
        if (stroke !=
              null &&
              paint !=
              null) {
            if (outline ==
                  null)
                outline =
                  getOutline(
                    );
            java.awt.geom.Rectangle2D strokeBounds =
              stroke.
              createStrokedShape(
                outline).
              getBounds2D(
                );
            if (bounds2D ==
                  null)
                bounds2D =
                  strokeBounds;
            else
                bounds2D.
                  add(
                    strokeBounds);
        }
        if (bounds2D ==
              null)
            return null;
        if (bounds2D.
              getWidth(
                ) ==
              0 ||
              bounds2D.
              getHeight(
                ) ==
              0)
            bounds2D =
              null;
        return bounds2D;
    }
    public java.awt.geom.Rectangle2D getLogicalBounds() {
        if (logicalBounds ==
              null) {
            computeGlyphLogicalBounds(
              );
        }
        return logicalBounds;
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
            float glyphX =
              0;
            float glyphY =
              -ascent /
              scaleFactor;
            float glyphWidth =
              glyphMetrics.
              getHorizontalAdvance(
                ) /
              scaleFactor;
            float glyphHeight =
              glyphMetrics.
              getVerticalAdvance(
                ) /
              scaleFactor;
            java.awt.geom.Rectangle2D glyphBounds =
              new java.awt.geom.Rectangle2D.Double(
              glyphX,
              glyphY,
              glyphWidth,
              glyphHeight);
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
                tr.
                  scale(
                    scaleFactor,
                    scaleFactor);
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
                      0.001 ||
                      java.lang.Math.
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
        logicalBounds =
          logicalBoundsPath.
            getBounds2D(
              );
        if (logicalBounds.
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
                    logicalBounds.
                      getMinY(
                        ),
                    width,
                    logicalBounds.
                      getHeight(
                        ));
            }
        }
        else
            if (logicalBounds.
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
                        logicalBounds.
                          getMinX(
                            ),
                        y,
                        logicalBounds.
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
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int glyphIndex) {
        if (glyphMetrics[glyphIndex] !=
              null)
            return glyphMetrics[glyphIndex];
        java.awt.geom.Point2D glyphPos =
          defaultGlyphPositions[glyphIndex];
        char c =
          ci.
          setIndex(
            ci.
              getBeginIndex(
                ) +
              glyphIndex);
        ci.
          setIndex(
            ci.
              getBeginIndex(
                ));
        org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
          org.apache.batik.gvt.font.AWTGVTFont.
          getGlyphGeometry(
            gvtFont,
            c,
            awtGlyphVector,
            glyphIndex,
            glyphPos);
        java.awt.geom.Rectangle2D gmB =
          v.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D bounds =
          new java.awt.geom.Rectangle2D.Double(
          gmB.
            getX(
              ) *
            scaleFactor,
          gmB.
            getY(
              ) *
            scaleFactor,
          gmB.
            getWidth(
              ) *
            scaleFactor,
          gmB.
            getHeight(
              ) *
            scaleFactor);
        float adv =
          (float)
            (defaultGlyphPositions[glyphIndex +
                                     1].
               getX(
                 ) -
               defaultGlyphPositions[glyphIndex].
               getX(
                 ));
        glyphMetrics[glyphIndex] =
          new org.apache.batik.gvt.font.GVTGlyphMetrics(
            adv *
              scaleFactor,
            ascent +
              descent,
            bounds,
            java.awt.font.GlyphMetrics.
              STANDARD);
        return glyphMetrics[glyphIndex];
    }
    public java.awt.Shape getGlyphOutline(int glyphIndex) {
        if (glyphOutlines[glyphIndex] ==
              null) {
            java.awt.geom.Point2D glyphPos =
              defaultGlyphPositions[glyphIndex];
            char c =
              ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ) +
                  glyphIndex);
            ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ));
            org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
              org.apache.batik.gvt.font.AWTGVTFont.
              getGlyphGeometry(
                gvtFont,
                c,
                awtGlyphVector,
                glyphIndex,
                glyphPos);
            java.awt.Shape glyphOutline =
              v.
              getOutline(
                );
            java.awt.geom.AffineTransform tr =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                getGlyphPosition(
                  glyphIndex).
                  getX(
                    ),
                getGlyphPosition(
                  glyphIndex).
                  getY(
                    ));
            java.awt.geom.AffineTransform glyphTransform =
              getGlyphTransform(
                glyphIndex);
            if (glyphTransform !=
                  null) {
                tr.
                  concatenate(
                    glyphTransform);
            }
            tr.
              scale(
                scaleFactor,
                scaleFactor);
            glyphOutlines[glyphIndex] =
              tr.
                createTransformedShape(
                  glyphOutline);
        }
        return glyphOutlines[glyphIndex];
    }
    private static final boolean outlinesPositioned;
    private static final boolean drawGlyphVectorWorks;
    private static final boolean glyphVectorTransformWorks;
    static { java.lang.String s = java.lang.System.
               getProperty(
                 "java.specification.version");
             if ("1.4".compareTo(s) <= 0) {
                 outlinesPositioned =
                   true;
                 drawGlyphVectorWorks =
                   true;
                 glyphVectorTransformWorks =
                   true;
             }
             else
                 if ("Mac OS X".
                       equals(
                         java.lang.System.
                           getProperty(
                             "os.name"))) {
                     outlinesPositioned =
                       true;
                     drawGlyphVectorWorks =
                       false;
                     glyphVectorTransformWorks =
                       false;
                 }
                 else {
                     outlinesPositioned =
                       false;
                     drawGlyphVectorWorks =
                       true;
                     glyphVectorTransformWorks =
                       false;
                 } }
    static boolean outlinesPositioned() {
        return outlinesPositioned;
    }
    public java.awt.geom.Rectangle2D getGlyphCellBounds(int glyphIndex) {
        return getGlyphLogicalBounds(
                 glyphIndex).
          getBounds2D(
            );
    }
    public java.awt.geom.Point2D getGlyphPosition(int glyphIndex) {
        return glyphPositions[glyphIndex];
    }
    public float[] getGlyphPositions(int beginGlyphIndex,
                                     int numEntries,
                                     float[] positionReturn) {
        if (positionReturn ==
              null) {
            positionReturn =
              (new float[numEntries *
                           2]);
        }
        for (int i =
               beginGlyphIndex;
             i <
               beginGlyphIndex +
               numEntries;
             i++) {
            java.awt.geom.Point2D glyphPos =
              getGlyphPosition(
                i);
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
        return glyphTransforms[glyphIndex];
    }
    public java.awt.Shape getGlyphVisualBounds(int glyphIndex) {
        if (glyphVisualBounds[glyphIndex] ==
              null) {
            java.awt.geom.Point2D glyphPos =
              defaultGlyphPositions[glyphIndex];
            char c =
              ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ) +
                  glyphIndex);
            ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ));
            org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
              org.apache.batik.gvt.font.AWTGVTFont.
              getGlyphGeometry(
                gvtFont,
                c,
                awtGlyphVector,
                glyphIndex,
                glyphPos);
            java.awt.geom.Rectangle2D glyphBounds =
              v.
              getOutlineBounds2D(
                );
            java.awt.geom.AffineTransform tr =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                getGlyphPosition(
                  glyphIndex).
                  getX(
                    ),
                getGlyphPosition(
                  glyphIndex).
                  getY(
                    ));
            java.awt.geom.AffineTransform glyphTransform =
              getGlyphTransform(
                glyphIndex);
            if (glyphTransform !=
                  null) {
                tr.
                  concatenate(
                    glyphTransform);
            }
            tr.
              scale(
                scaleFactor,
                scaleFactor);
            glyphVisualBounds[glyphIndex] =
              tr.
                createTransformedShape(
                  glyphBounds);
        }
        return glyphVisualBounds[glyphIndex];
    }
    public int getNumGlyphs() { return awtGlyphVector.
                                  getNumGlyphs(
                                    ); }
    public java.awt.Shape getOutline() { if (outline !=
                                               null)
                                             return outline;
                                         outline =
                                           new java.awt.geom.GeneralPath(
                                             );
                                         for (int i =
                                                0;
                                              i <
                                                getNumGlyphs(
                                                  );
                                              i++) {
                                             if (glyphVisible[i]) {
                                                 java.awt.Shape glyphOutline =
                                                   getGlyphOutline(
                                                     i);
                                                 outline.
                                                   append(
                                                     glyphOutline,
                                                     false);
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
        outline =
          tr.
            createTransformedShape(
              outline);
        return outline;
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        if (visualBounds ==
              null) {
            java.awt.Shape outline =
              getOutline(
                );
            visualBounds =
              outline.
                getBounds2D(
                  );
        }
        return visualBounds;
    }
    public void performDefaultLayout() { if (defaultGlyphPositions ==
                                               null) {
                                             awtGlyphVector.
                                               performDefaultLayout(
                                                 );
                                             defaultGlyphPositions =
                                               (new java.awt.geom.Point2D.Float[getNumGlyphs(
                                                                                  ) +
                                                                                  1]);
                                             for (int i =
                                                    0;
                                                  i <=
                                                    getNumGlyphs(
                                                      );
                                                  i++)
                                                 defaultGlyphPositions[i] =
                                                   awtGlyphVector.
                                                     getGlyphPosition(
                                                       i);
                                         }
                                         outline =
                                           null;
                                         visualBounds =
                                           null;
                                         logicalBounds =
                                           null;
                                         bounds2D =
                                           null;
                                         float shiftLeft =
                                           0;
                                         int i =
                                           0;
                                         for (;
                                              i <
                                                getNumGlyphs(
                                                  );
                                              i++) {
                                             glyphTransforms[i] =
                                               null;
                                             glyphVisualBounds[i] =
                                               null;
                                             glyphLogicalBounds[i] =
                                               null;
                                             glyphOutlines[i] =
                                               null;
                                             glyphMetrics[i] =
                                               null;
                                             java.awt.geom.Point2D glyphPos =
                                               defaultGlyphPositions[i];
                                             float x =
                                               (float)
                                                 (glyphPos.
                                                    getX(
                                                      ) *
                                                    scaleFactor -
                                                    shiftLeft);
                                             float y =
                                               (float)
                                                 (glyphPos.
                                                    getY(
                                                      ) *
                                                    scaleFactor);
                                             ci.
                                               setIndex(
                                                 i +
                                                   ci.
                                                   getBeginIndex(
                                                     ));
                                             if (glyphPositions[i] ==
                                                   null) {
                                                 glyphPositions[i] =
                                                   new java.awt.geom.Point2D.Float(
                                                     x,
                                                     y);
                                             }
                                             else {
                                                 glyphPositions[i].
                                                   x =
                                                   x;
                                                 glyphPositions[i].
                                                   y =
                                                   y;
                                             }
                                         }
                                         java.awt.geom.Point2D glyphPos =
                                           defaultGlyphPositions[i];
                                         glyphPositions[i] =
                                           new java.awt.geom.Point2D.Float(
                                             (float)
                                               (glyphPos.
                                                  getX(
                                                    ) *
                                                  scaleFactor -
                                                  shiftLeft),
                                             (float)
                                               (glyphPos.
                                                  getY(
                                                    ) *
                                                  scaleFactor));
    }
    public void setGlyphPosition(int glyphIndex,
                                 java.awt.geom.Point2D newPos) {
        glyphPositions[glyphIndex].
          x =
          (float)
            newPos.
            getX(
              );
        glyphPositions[glyphIndex].
          y =
          (float)
            newPos.
            getY(
              );
        outline =
          null;
        visualBounds =
          null;
        logicalBounds =
          null;
        bounds2D =
          null;
        if (glyphIndex !=
              getNumGlyphs(
                )) {
            glyphVisualBounds[glyphIndex] =
              null;
            glyphLogicalBounds[glyphIndex] =
              null;
            glyphOutlines[glyphIndex] =
              null;
            glyphMetrics[glyphIndex] =
              null;
        }
    }
    public void setGlyphTransform(int glyphIndex,
                                  java.awt.geom.AffineTransform newTX) {
        glyphTransforms[glyphIndex] =
          newTX;
        outline =
          null;
        visualBounds =
          null;
        logicalBounds =
          null;
        bounds2D =
          null;
        glyphVisualBounds[glyphIndex] =
          null;
        glyphLogicalBounds[glyphIndex] =
          null;
        glyphOutlines[glyphIndex] =
          null;
        glyphMetrics[glyphIndex] =
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
        visualBounds =
          null;
        logicalBounds =
          null;
        bounds2D =
          null;
        glyphVisualBounds[glyphIndex] =
          null;
        glyphLogicalBounds[glyphIndex] =
          null;
        glyphOutlines[glyphIndex] =
          null;
        glyphMetrics[glyphIndex] =
          null;
    }
    public boolean isGlyphVisible(int glyphIndex) {
        return glyphVisible[glyphIndex];
    }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        if (startGlyphIndex <
              0) {
            startGlyphIndex =
              0;
        }
        if (endGlyphIndex >=
              getNumGlyphs(
                )) {
            endGlyphIndex =
              getNumGlyphs(
                ) -
                1;
        }
        int charCount =
          0;
        int start =
          startGlyphIndex +
          ci.
          getBeginIndex(
            );
        int end =
          endGlyphIndex +
          ci.
          getBeginIndex(
            );
        for (char c =
               ci.
               setIndex(
                 start);
             ci.
               getIndex(
                 ) <=
               end;
             c =
               ci.
                 next(
                   )) {
            charCount +=
              org.apache.batik.gvt.text.ArabicTextHandler.
                getNumChars(
                  c);
        }
        return charCount;
    }
    public void draw(java.awt.Graphics2D graphics2D,
                     java.text.AttributedCharacterIterator aci) {
        int numGlyphs =
          getNumGlyphs(
            );
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                PAINT_INFO);
        if (tpi ==
              null)
            return;
        if (!tpi.
               visible)
            return;
        java.awt.Paint fillPaint =
          tpi.
            fillPaint;
        java.awt.Stroke stroke =
          tpi.
            strokeStroke;
        java.awt.Paint strokePaint =
          tpi.
            strokePaint;
        if (fillPaint ==
              null &&
              (strokePaint ==
                 null ||
                 stroke ==
                 null))
            return;
        boolean useHinting =
          drawGlyphVectorWorks;
        if (useHinting &&
              stroke !=
              null &&
              strokePaint !=
              null)
            useHinting =
              false;
        if (useHinting &&
              fillPaint !=
              null &&
              !(fillPaint instanceof java.awt.Color))
            useHinting =
              false;
        if (useHinting) {
            java.lang.Object v1 =
              graphics2D.
              getRenderingHint(
                java.awt.RenderingHints.
                  KEY_TEXT_ANTIALIASING);
            java.lang.Object v2 =
              graphics2D.
              getRenderingHint(
                java.awt.RenderingHints.
                  KEY_STROKE_CONTROL);
            if (v1 ==
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_ON &&
                  v2 ==
                  java.awt.RenderingHints.
                    VALUE_STROKE_PURE)
                useHinting =
                  false;
        }
        final int typeGRot =
          java.awt.geom.AffineTransform.
            TYPE_GENERAL_ROTATION;
        final int typeGTrans =
          java.awt.geom.AffineTransform.
            TYPE_GENERAL_TRANSFORM;
        if (useHinting) {
            java.awt.geom.AffineTransform at =
              graphics2D.
              getTransform(
                );
            int type =
              at.
              getType(
                );
            if ((type &
                   typeGTrans) !=
                  0 ||
                  (type &
                     typeGRot) !=
                  0)
                useHinting =
                  false;
        }
        if (useHinting) {
            for (int i =
                   0;
                 i <
                   numGlyphs;
                 i++) {
                if (!glyphVisible[i]) {
                    useHinting =
                      false;
                    break;
                }
                java.awt.geom.AffineTransform at =
                  glyphTransforms[i];
                if (at !=
                      null) {
                    int type =
                      at.
                      getType(
                        );
                    if ((type &
                           ~java.awt.geom.AffineTransform.
                              TYPE_TRANSLATION) ==
                          0) {
                        
                    }
                    else
                        if (glyphVectorTransformWorks &&
                              (type &
                                 typeGTrans) ==
                              0 &&
                              (type &
                                 typeGRot) ==
                              0) {
                            
                        }
                        else {
                            useHinting =
                              false;
                            break;
                        }
                }
            }
        }
        if (useHinting) {
            double sf =
              scaleFactor;
            double[] mat =
              new double[6];
            for (int i =
                   0;
                 i <
                   numGlyphs;
                 i++) {
                java.awt.geom.Point2D pos =
                  glyphPositions[i];
                double x =
                  pos.
                  getX(
                    );
                double y =
                  pos.
                  getY(
                    );
                java.awt.geom.AffineTransform at =
                  glyphTransforms[i];
                if (at !=
                      null) {
                    at.
                      getMatrix(
                        mat);
                    x +=
                      mat[4];
                    y +=
                      mat[5];
                    if (mat[0] !=
                          1 ||
                          mat[1] !=
                          0 ||
                          mat[2] !=
                          0 ||
                          mat[3] !=
                          1) {
                        mat[4] =
                          0;
                        mat[5] =
                          0;
                        at =
                          new java.awt.geom.AffineTransform(
                            mat);
                    }
                    else {
                        at =
                          null;
                    }
                }
                pos =
                  new java.awt.geom.Point2D.Double(
                    x /
                      sf,
                    y /
                      sf);
                awtGlyphVector.
                  setGlyphPosition(
                    i,
                    pos);
                awtGlyphVector.
                  setGlyphTransform(
                    i,
                    at);
            }
            graphics2D.
              scale(
                sf,
                sf);
            graphics2D.
              setPaint(
                fillPaint);
            graphics2D.
              drawGlyphVector(
                awtGlyphVector,
                0,
                0);
            graphics2D.
              scale(
                1 /
                  sf,
                1 /
                  sf);
            for (int i =
                   0;
                 i <
                   numGlyphs;
                 i++) {
                java.awt.geom.Point2D pos =
                  defaultGlyphPositions[i];
                awtGlyphVector.
                  setGlyphPosition(
                    i,
                    pos);
                awtGlyphVector.
                  setGlyphTransform(
                    i,
                    null);
            }
        }
        else {
            java.awt.Shape outline =
              getOutline(
                );
            if (fillPaint !=
                  null) {
                graphics2D.
                  setPaint(
                    fillPaint);
                graphics2D.
                  fill(
                    outline);
            }
            if (stroke !=
                  null &&
                  strokePaint !=
                  null) {
                graphics2D.
                  setStroke(
                    stroke);
                graphics2D.
                  setPaint(
                    strokePaint);
                graphics2D.
                  draw(
                    outline);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "i2lcabLp3BUSrPjLDMml7BTPlv0/vuDWLbRRAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "V1OptFtFa2TaMVNMFIeVEImouoFNUK+j");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "kmh0AFPcyOVsurqe2FK8nFM0QcW2N5hpo/aacb1Uz0cOqlMcrop+RJErI8sc" +
       "vu8P+lPNmPqTldj1Am0oRXV7Qo245qCabPWZwuDefEHxeIR3RTMaNWhrMpu0" +
       "Q2Ol1aSVtHQ0s2bJ0pJ24fZk7PMrGgSqFtoWeCuuQDFw7/RyNGq1Wl+Uf4Ij" +
       "r+8T3P3F18ajLcQrK/92f6l5HV/Z0hOrt46+1xZ/t5dObTs98b22KPnqE+vz" +
       "HgxLb3rh9Uu7L7X5pp9HzttKXOyA+tC7n3te4b6rerBf6/V0WLordNwvsNRY" +
       "tU70/dri/ueO6H55Tma+JuLde7rfffo78zFnzl578KYdZ89fd3bp7RfkPZMn" +
       "s3xbhFpsizhkzeMXsuaoZPGVev5Cn0RPdnoK/yP5wyq43rfH/76bj399QZ6d" +
       "J1pYesUe/0jdKKq/36V/yIzXXbkz8OxyBSv0G2DFvfnDfN3ds3tWPHtzWHHp" +
       "uMDHCszZBfz4ijwJ8wWC6m73B+4oxcrGjx2DjG4AZDFW8wVT37wH+c03B+Qt" +
       "x0bnY8fknlrUCDh8636Zz+43LMk3uG5Yct0ACmJ96TtJoPoQC9jFm/Ja9Xlp" +
       "o1qHy5P/f3STHuM+ay3ypfccLln5hrO5e9Va5Dz56CFHL33d1YuO839/Kk9+" +
       "+upVxIXYd90WtfP/f+kCxfvGC/Key5Nn85xf3VFyQdlvSne/X3tBmQ/myVfn" +
       "mx1OKHlQNH2s5e+6AS3Pt2MU24K+c6/l3/kiDeV/ewHKD+XJt+dLjvYo+1EQ" +
       "mpopFwu080Vnh/btyTN2Pp9duODM8zfAmVeV9uz53j1nvvemcuYQ0VPXtH2y" +
       "YNMPXsDCH8mTfx+WXgJY2D65YvSYGR++UWbkO0c+uWfGJ28OM05C+NgFeR/P" +
       "k58IS/cBeFftODmB8Sdv1ODnS4r/YI/xD16kofCLFwD95Tz5mbD04OFQuArt" +
       "vz5G+7M3gPZolf5f7tH+5fWifccLSvQ3Lsj7ZJ78Ghjz+ZEvQOevBltUO73O" +
       "LXZM5ZgBn7gBBuTxS+ktAMsHd3V3vy+CuP/wAi78UZ58Ot+/txf3fhdCXva3" +
       "j3G+4Hr+F1LrxwBFP7HH+RMvEs7PXYDzr/Lkz0/g3O/bO6XQn7kBnMX85Cng" +
       "6+/a1d39Xg/O8Qsq9D9ekPdPefK3569GPkb5dzdqiN8M0D2wR/nAiyPNg7vO" +
       "h3rwkjy5Nd8BeBiVqNaZ9vjgthsV6BMA4kN7qA+9SFAfvADqq/Lkvp3juWKP" +
       "eV44PQZ6/40CfRIAfGwP9LGbA/SFZhr5ZL44ruCNu353v2FpeqNTgI1p56fd" +
       "OH4L3BVh2eHs4sVqusCPnhlj5TOKgyf2M4qDN57NxYtnFAev//xmFKDbonb+" +
       "/wUzioPLF+Tl6+QP3prn/OqOkgvK1nYzioPHLyiTO9SD1+abi08pdFA0f6zR" +
       "j9yobwXBxQGy12jkRRq6X3wB0i/NE+wE0qNdDHnpZ4+Rvu1GvWvudfZHLBxc" +
       "dcTCTULavwApnSfE7tVQ76w948cu9qB7E977HOwP3Do451Sx6wV7Eot4Qd4s" +
       "T4a7Vz5sZBdQg2PLVuAb3agwc3zqHp968/EtL8jLA4WDt4eluwG+MwOkg3fc" +
       "DHTJHl1yc9CdMIjF7ja0wLK5AGdhic2LcL7geTLXEiJ9zR7n19x8KW4vyPvK" +
       "PIn20ZEK3F0e0Z8ZHcU3gLI44Q/MVg/ev0f5/puP8usuyHtvnrwL2BxX9XOb" +
       "2tmdw7M7RAXkXfqtY5zvvlGcoN7B7+xx/s5N19oiOEoLVBe82zvI3+0d/AsQ" +
       "CgZXh4In0b7/RtGSgK7P7tF+9sVB+2yB6PkL0H5HnnwL8J7BGd7zJNxvvQnC" +
       "vWVXdf978+H+WAHp+y6A++E8+S4wQQ2OXWh+bsgpsN99o2H+4wDkfup2y4s1" +
       "dfuxC3D+eJ78UFi6xwxOwTwxQz344RsNEh4D8B7dw3z0xZHpDutPXYD1p/Pk" +
       "o7sA8OiNKg4McbET+0TM8LEbVeE6gLkPdW+Bbyrc4v+j01LyF989X3INU969" +
       "3730QwXSX7mAC5/Ik18IS7fme49PqfMvXg/wFHDyqrN/84NMX33VAeO7Q7Hl" +
       "jzx/752ven7yP3YnpR0eXH0XXbpTiyzr5HGGJ+5vd31VMwue3FWk97gFjt8M" +
       "Sw+d+6kXwNP2X3oPPrkr/9vAN51VPizdAtKTJT8FbPrpkmHptuL3ZLnfBxHL" +
       "cbn8rIHi5mSRPwStgyL57f90D2V3YpPw7vzHdDdFfPVJjSoWEzzwQvI4qnLy" +
       "HN3820FxFPzhMTXR7jD4Z+QfeL7PfsXnGt+1O8dXtqTtNm/lTrp0x+5I4aLR" +
       "/Kibx89t7bCt28k3/8M9P3jXU4frBu7ZEXys3Sdoe93Zh+YSthsWx9xuf/xV" +
       "P/KF3/P87xa7pP8fj2Cud6NfAAA=");
}
