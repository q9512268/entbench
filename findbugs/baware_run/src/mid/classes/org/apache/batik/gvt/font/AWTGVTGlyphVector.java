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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "L1humqYXkEQCgf+uzgW0vzum9ufA0Sj01yjR/j9Gal9GDfO+q1DtePkr+Q5m" +
       "CONTvsHp+a9DOgd8+Y++NcFMMKnuMLKOu9FwmUbiGrkDiwOBFCyoZlhbQaZ4" +
       "wcq+K6ayG+C4TqjrOomyvxWpbBk1ZHNM2ZstNWPjEjiobTb++KjxPZS+l0dp" +
       "YiFKSzsh4tL8GBeM0wMxcZpGeKJA3N8QnB6JxElG7ZBhDKcNWQc36UJRqoXj" +
       "SkF/JZ8Tf6UtsU2tqy7rFlz4eD7NP5bX/PC85jd1qya9YFUfianqmXA0CbCb" +
       "JKr+l0hVy6gdUstU3arZWVVfZmQz3OP/MMDxkxeRwC0XYy6XcPxMJMcyasjH" +
       "GcdJo0tLRbH8bEyWp8OxQgy6QsLyv0eyLKN2yFAXZK1Dp4HpVIetxxJS4XBq" +
       "/jvQjj9t9CSWQjqCCftyI5XtoZm/UoiRjuSbQr/i51djsYSfX+s7Xwb5bYdh" +
       "6FTNhM+nom0Kpk/es1DVK+HLAwVP52GRYrNyCSyVdJrpcrrDuCjVeIb9a9Mb" +
       "UuH9uD6A77rh4rChSTcyVHU1DHV8/1wzGvJ33qCymHnc2gkuutex7MtbwS4+" +
       "fr701bvGDC3eOMfeJkm2xWfL88rgAD/f/d/jNl/bvSXGjvjkQNoZ7PL76w4/" +
       "v2pm6i6F3bbjC+ai232FRI2Fy+QqizpZK1O4ZTSN65npxZuPs5nmIraEfh9R" +
       "dxaLM7BYTqEKucYjmv+BWVhr7sK8/bGYjmguHCuFK1kpcUTnIx2RjNp1RIC5" +
       "paWk2Y90cG8C/yUfA2fJd4bdMCqGu+Dw+GFMwKbAsUrwvCocsJKySMBk1OCH" +
       "DJEECXHHFiZ7fANZbxH3KD0hSgbFFAJXGqsFG6slQgyLFEJGDVrv9YV3iSQb" +
       "weWDE9PpguUBSYZfRLbSLHhplkgyKlISGTUkpnog7JfUBbgdfRGbH2vEeGsk" +
       "3E6M5FZG7ZDKDsYmQ7SI0UkxGZ0Ex1ox1FoJo/WRjMqoHTLEBkwp33TGS40B" +
       "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" +
       "jsB/Vv8/IK9r6JlPAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Bhi/nZKPnIbSvWBk+a5dRbt7WLJvqn4RfUPWFHg6JzmgZfIZZsUJu8XLQ4X2" +
       "ha1w1xT1gkG757cCH0R0XUsRnCM//tJ+CqdonDz4j4d8/8mz+X6QP74xD7hD" +
       "5t9uKY4W6mfVd4ux83d+eG8Y8yoPduUcdsrdsDn3pi+jlusowmELgrjdDJTh" +
       "Xj6auwaR6VXE+6U3n+8d0IWRPvb9f+7df/ow9zb9y69j6um1p5yH00X+e/rD" +
       "v0C+Xvqmg9ItRyOBqya2r8z01JX+/92+Eka+w10xCnjNrj0K/u0aIw+eLDh8" +
       "wVj0v10Q99/z4BfBKEDKWb1rmQuSfyI9rSA/cp09/C3gIvY9nDinh/+Pa+/h" +
       "gIm+IZ1r8s6t6VCg3nT+PMrhHOi+ijOMw29cJ/ZHwUXuKSLPwf7paxo5uHvL" +
       "t0fx0JWGezdpYrH7mfITFP/edVKcO33UnmLqHIr/5JpaKz5hyc4hewKUH+j1" +
       "llLFTpH9p5+HFe7tye6dQ/ZfXpOfYZ22cH9xirS/+jwGav09af1zSPu7ayHt" +
       "TrGgacer01T9/XVS9Qi4BnuqBmdTdal0LVS9KADcUnazR/kr5ErCLl26TsIe" +
       "AtdwT9jwHMLuuBbCbhcCSdnZntM03XmdND0MLnpPE30OTfdcUzeWlXOJuvfz" +
       "8JyYPVHMOUQ9eE1yJeXKkGN7h730DWeqyGI+KHc0WAGY9N7+A90JAC+/dgB5" +
       "I5fqgJC/2CXd3c8A8MjZAIo5rXfkwTQPjvyQBw7V5OGYVpHzmB87Relrr5PS" +
       "JqDwc3tKP3cOpU9eH6Uvk30hOTFPtXD9dXAWra+/TlqfAjT+9Z7Wvz6H1rdc" +
       "H60Pacd0Hg0OzyX4i56X4KLY9NIl4IRULyOX8+m5S7ULSHrj1SS9wrSkJw6/" +
       "GcwVPwBt/YRpIYcifN+xS7lbG3BKXbaumUjgWt5zXNjQdbSnvvEPnvnlf/X4" +
       "pw5Kl/ql2+J8Shh4iCdqZKJ85cXXffj9r3nRs5/+xuKLF2gM9gP4fV+aQ/3i" +
       "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" +
       "LVgkwQstotCIGFTWnjTjnF5anZiMV5n0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
