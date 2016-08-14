package org.apache.batik.gvt.text;
public class GlyphLayout implements org.apache.batik.gvt.text.TextSpanLayout {
    private org.apache.batik.gvt.font.GVTGlyphVector gv;
    private org.apache.batik.gvt.font.GVTFont font;
    private org.apache.batik.gvt.font.GVTLineMetrics metrics;
    private java.text.AttributedCharacterIterator aci;
    private java.awt.geom.Point2D advance;
    private java.awt.geom.Point2D offset;
    private float xScale = 1;
    private float yScale = 1;
    private org.apache.batik.gvt.text.TextPath textPath;
    private java.awt.geom.Point2D textPathAdvance;
    private int[] charMap;
    private boolean vertical;
    private boolean adjSpacing = true;
    private float[] glyphAdvances;
    private boolean isAltGlyph;
    private boolean layoutApplied = false;
    private boolean spacingApplied = false;
    private boolean pathApplied = false;
    public static final java.text.AttributedCharacterIterator.Attribute FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_EMPTY_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_EMPTY_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      LINE_HEIGHT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LINE_HEIGHT;
    public static final java.text.AttributedCharacterIterator.Attribute
      VERTICAL_ORIENTATION =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        VERTICAL_ORIENTATION;
    public static final java.text.AttributedCharacterIterator.Attribute
      VERTICAL_ORIENTATION_ANGLE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        VERTICAL_ORIENTATION_ANGLE;
    public static final java.text.AttributedCharacterIterator.Attribute
      HORIZONTAL_ORIENTATION_ANGLE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        HORIZONTAL_ORIENTATION_ANGLE;
    private static final java.text.AttributedCharacterIterator.Attribute
      X =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        X;
    private static final java.text.AttributedCharacterIterator.Attribute
      Y =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        Y;
    private static final java.text.AttributedCharacterIterator.Attribute
      DX =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        DX;
    private static final java.text.AttributedCharacterIterator.Attribute
      DY =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        DY;
    private static final java.text.AttributedCharacterIterator.Attribute
      ROTATION =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ROTATION;
    private static final java.text.AttributedCharacterIterator.Attribute
      BASELINE_SHIFT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        BASELINE_SHIFT;
    private static final java.text.AttributedCharacterIterator.Attribute
      WRITING_MODE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WRITING_MODE;
    private static final java.lang.Integer WRITING_MODE_TTB = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                                WRITING_MODE_TTB;
    private static final java.lang.Integer ORIENTATION_AUTO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ORIENTATION_AUTO;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    protected static java.util.Set runAtts = new java.util.HashSet(
      );
    static { runAtts.add(X);
             runAtts.add(Y);
             runAtts.add(DX);
             runAtts.add(DY);
             runAtts.add(ROTATION);
             runAtts.add(BASELINE_SHIFT); }
    protected static java.util.Set szAtts = new java.util.HashSet(
      );
    static { szAtts.add(java.awt.font.TextAttribute.SIZE);
             szAtts.add(GVT_FONT);
             szAtts.add(LINE_HEIGHT); }
    public GlyphLayout(java.text.AttributedCharacterIterator aci,
                       int[] charMap,
                       java.awt.geom.Point2D offset,
                       java.awt.font.FontRenderContext frc) {
        super(
          );
        this.
          aci =
          aci;
        this.
          offset =
          offset;
        this.
          font =
          getFont(
            );
        this.
          charMap =
          charMap;
        this.
          metrics =
          font.
            getLineMetrics(
              aci,
              aci.
                getBeginIndex(
                  ),
              aci.
                getEndIndex(
                  ),
              frc);
        this.
          gv =
          null;
        this.
          aci.
          first(
            );
        this.
          vertical =
          aci.
            getAttribute(
              WRITING_MODE) ==
            WRITING_MODE_TTB;
        this.
          textPath =
          (org.apache.batik.gvt.text.TextPath)
            aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                TEXTPATH);
        org.apache.batik.gvt.font.AltGlyphHandler altGlyphHandler =
          (org.apache.batik.gvt.font.AltGlyphHandler)
            this.
              aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                ALT_GLYPH_HANDLER);
        if (altGlyphHandler !=
              null) {
            this.
              gv =
              altGlyphHandler.
                createGlyphVector(
                  frc,
                  this.
                    font.
                    getSize(
                      ),
                  this.
                    aci);
            if (this.
                  gv !=
                  null) {
                this.
                  isAltGlyph =
                  true;
            }
        }
        if (this.
              gv ==
              null) {
            this.
              gv =
              font.
                createGlyphVector(
                  frc,
                  this.
                    aci);
        }
    }
    public org.apache.batik.gvt.font.GVTGlyphVector getGlyphVector() {
        return this.
                 gv;
    }
    public java.awt.geom.Point2D getOffset() {
        return offset;
    }
    public void setScale(float xScale, float yScale,
                         boolean adjSpacing) {
        if (vertical)
            xScale =
              1;
        else
            yScale =
              1;
        if (xScale !=
              this.
                xScale ||
              yScale !=
              this.
                yScale ||
              adjSpacing !=
              this.
                adjSpacing) {
            this.
              xScale =
              xScale;
            this.
              yScale =
              yScale;
            this.
              adjSpacing =
              adjSpacing;
            spacingApplied =
              false;
            glyphAdvances =
              null;
            pathApplied =
              false;
        }
    }
    public void setOffset(java.awt.geom.Point2D offset) {
        if (offset.
              getX(
                ) !=
              this.
                offset.
              getX(
                ) ||
              offset.
              getY(
                ) !=
              this.
                offset.
              getY(
                )) {
            if (layoutApplied ||
                  spacingApplied) {
                float dx =
                  (float)
                    (offset.
                       getX(
                         ) -
                       this.
                         offset.
                       getX(
                         ));
                float dy =
                  (float)
                    (offset.
                       getY(
                         ) -
                       this.
                         offset.
                       getY(
                         ));
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
                java.awt.geom.Point2D.Float pos =
                  new java.awt.geom.Point2D.Float(
                  );
                for (int i =
                       0;
                     i <=
                       numGlyphs;
                     i++) {
                    pos.
                      x =
                      gp[2 *
                           i] +
                        dx;
                    pos.
                      y =
                      gp[2 *
                           i +
                           1] +
                        dy;
                    gv.
                      setGlyphPosition(
                        i,
                        pos);
                }
            }
            this.
              offset =
              offset;
            pathApplied =
              false;
        }
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int glyphIndex) {
        return gv.
          getGlyphMetrics(
            glyphIndex);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics() {
        return metrics;
    }
    public boolean isVertical() { return vertical;
    }
    public boolean isOnATextPath() { return textPath !=
                                       null;
    }
    public int getGlyphCount() { return gv.
                                   getNumGlyphs(
                                     ); }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        return gv.
          getCharacterCount(
            startGlyphIndex,
            endGlyphIndex);
    }
    public boolean isLeftToRight() { aci.
                                       first(
                                         );
                                     int bidiLevel =
                                       ((java.lang.Integer)
                                          aci.
                                          getAttribute(
                                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                              BIDI_LEVEL)).
                                       intValue(
                                         );
                                     return (bidiLevel &
                                               1) ==
                                       0;
    }
    private final void syncLayout() { if (!pathApplied) {
                                          doPathLayout(
                                            );
                                      } }
    public void draw(java.awt.Graphics2D g2d) {
        syncLayout(
          );
        gv.
          draw(
            g2d,
            aci);
    }
    public java.awt.geom.Point2D getAdvance2D() {
        adjustTextSpacing(
          );
        return advance;
    }
    public java.awt.Shape getOutline() { syncLayout(
                                           );
                                         return gv.
                                           getOutline(
                                             );
    }
    public float[] getGlyphAdvances() { if (glyphAdvances !=
                                              null)
                                            return glyphAdvances;
                                        if (!spacingApplied)
                                            adjustTextSpacing(
                                              );
                                        int numGlyphs =
                                          gv.
                                          getNumGlyphs(
                                            );
                                        float[] glyphPos =
                                          gv.
                                          getGlyphPositions(
                                            0,
                                            numGlyphs +
                                              1,
                                            null);
                                        glyphAdvances =
                                          (new float[numGlyphs +
                                                       1]);
                                        int off =
                                          0;
                                        if (isVertical(
                                              ))
                                            off =
                                              1;
                                        float start =
                                          glyphPos[off];
                                        for (int i =
                                               0;
                                             i <
                                               numGlyphs +
                                               1;
                                             i++) {
                                            glyphAdvances[i] =
                                              glyphPos[2 *
                                                         i +
                                                         off] -
                                                start;
                                        }
                                        return glyphAdvances;
    }
    public java.awt.Shape getDecorationOutline(int decorationType) {
        syncLayout(
          );
        java.awt.Shape g =
          new java.awt.geom.GeneralPath(
          );
        if ((decorationType &
               DECORATION_UNDERLINE) !=
              0) {
            ((java.awt.geom.GeneralPath)
               g).
              append(
                getUnderlineShape(
                  ),
                false);
        }
        if ((decorationType &
               DECORATION_STRIKETHROUGH) !=
              0) {
            ((java.awt.geom.GeneralPath)
               g).
              append(
                getStrikethroughShape(
                  ),
                false);
        }
        if ((decorationType &
               DECORATION_OVERLINE) !=
              0) {
            ((java.awt.geom.GeneralPath)
               g).
              append(
                getOverlineShape(
                  ),
                false);
        }
        return g;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        syncLayout(
          );
        return gv.
          getBounds2D(
            aci);
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        syncLayout(
          );
        java.awt.geom.Rectangle2D gvB;
        java.awt.geom.Rectangle2D decB;
        gvB =
          gv.
            getGeometricBounds(
              );
        decB =
          getDecorationOutline(
            DECORATION_ALL).
            getBounds2D(
              );
        return gvB.
          createUnion(
            decB);
    }
    public java.awt.geom.Point2D getTextPathAdvance() {
        syncLayout(
          );
        if (textPath !=
              null) {
            return textPathAdvance;
        }
        else {
            return getAdvance2D(
                     );
        }
    }
    public int getGlyphIndex(int charIndex) {
        int numGlyphs =
          getGlyphCount(
            );
        int j =
          0;
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int count =
              getCharacterCount(
                i,
                i);
            for (int n =
                   0;
                 n <
                   count;
                 n++) {
                int glyphCharIndex =
                  charMap[j++];
                if (charIndex ==
                      glyphCharIndex)
                    return i;
                if (j >=
                      charMap.
                        length)
                    return -1;
            }
        }
        return -1;
    }
    public int getLastGlyphIndex(int charIndex) {
        int numGlyphs =
          getGlyphCount(
            );
        int j =
          charMap.
            length -
          1;
        for (int i =
               numGlyphs -
               1;
             i >=
               0;
             --i) {
            int count =
              getCharacterCount(
                i,
                i);
            for (int n =
                   0;
                 n <
                   count;
                 n++) {
                int glyphCharIndex =
                  charMap[j--];
                if (charIndex ==
                      glyphCharIndex)
                    return i;
                if (j <
                      0)
                    return -1;
            }
        }
        return -1;
    }
    public double getComputedOrientationAngle(int index) {
        if (isGlyphOrientationAuto(
              )) {
            if (isVertical(
                  )) {
                char ch =
                  aci.
                  setIndex(
                    index);
                if (isLatinChar(
                      ch))
                    return 90.0;
                else
                    return 0.0;
            }
            return 0.0;
        }
        else {
            return getGlyphOrientationAngle(
                     );
        }
    }
    public java.awt.Shape getHighlightShape(int beginCharIndex,
                                            int endCharIndex) {
        syncLayout(
          );
        if (beginCharIndex >
              endCharIndex) {
            int temp =
              beginCharIndex;
            beginCharIndex =
              endCharIndex;
            endCharIndex =
              temp;
        }
        java.awt.geom.GeneralPath shape =
          null;
        int numGlyphs =
          getGlyphCount(
            );
        java.awt.geom.Point2D.Float[] topPts =
          new java.awt.geom.Point2D.Float[2 *
                                            numGlyphs];
        java.awt.geom.Point2D.Float[] botPts =
          new java.awt.geom.Point2D.Float[2 *
                                            numGlyphs];
        int ptIdx =
          0;
        int currentChar =
          0;
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int glyphCharIndex =
              charMap[currentChar];
            if (glyphCharIndex >=
                  beginCharIndex &&
                  glyphCharIndex <=
                  endCharIndex &&
                  gv.
                  isGlyphVisible(
                    i)) {
                java.awt.Shape gbounds =
                  gv.
                  getGlyphLogicalBounds(
                    i);
                if (gbounds !=
                      null) {
                    if (shape ==
                          null)
                        shape =
                          new java.awt.geom.GeneralPath(
                            );
                    float[] pts =
                      new float[6];
                    int count =
                      0;
                    int type =
                      -1;
                    java.awt.geom.PathIterator pi =
                      gbounds.
                      getPathIterator(
                        null);
                    java.awt.geom.Point2D.Float firstPt =
                      null;
                    while (!pi.
                             isDone(
                               )) {
                        type =
                          pi.
                            currentSegment(
                              pts);
                        if (type ==
                              java.awt.geom.PathIterator.
                                SEG_MOVETO ||
                              type ==
                              java.awt.geom.PathIterator.
                                SEG_LINETO) {
                            if (count >
                                  4)
                                break;
                            if (count ==
                                  4) {
                                if (firstPt ==
                                      null ||
                                      firstPt.
                                        x !=
                                      pts[0] ||
                                      firstPt.
                                        y !=
                                      pts[1])
                                    break;
                            }
                            else {
                                java.awt.geom.Point2D.Float pt;
                                pt =
                                  new java.awt.geom.Point2D.Float(
                                    pts[0],
                                    pts[1]);
                                if (count ==
                                      0)
                                    firstPt =
                                      pt;
                                switch (count) {
                                    case 0:
                                        botPts[ptIdx] =
                                          pt;
                                        break;
                                    case 1:
                                        topPts[ptIdx] =
                                          pt;
                                        break;
                                    case 2:
                                        topPts[ptIdx +
                                                 1] =
                                          pt;
                                        break;
                                    case 3:
                                        botPts[ptIdx +
                                                 1] =
                                          pt;
                                        break;
                                }
                            }
                        }
                        else
                            if (type ==
                                  java.awt.geom.PathIterator.
                                    SEG_CLOSE) {
                                if (count <
                                      4 ||
                                      count >
                                      5)
                                    break;
                            }
                            else {
                                break;
                            }
                        count++;
                        pi.
                          next(
                            );
                    }
                    if (pi.
                          isDone(
                            )) {
                        if (botPts[ptIdx] !=
                              null &&
                              (topPts[ptIdx].
                                 x !=
                                 topPts[ptIdx +
                                          1].
                                   x ||
                                 topPts[ptIdx].
                                   y !=
                                 topPts[ptIdx +
                                          1].
                                   y))
                            ptIdx +=
                              2;
                    }
                    else {
                        addPtsToPath(
                          shape,
                          topPts,
                          botPts,
                          ptIdx);
                        ptIdx =
                          0;
                        shape.
                          append(
                            gbounds,
                            false);
                    }
                }
            }
            currentChar +=
              getCharacterCount(
                i,
                i);
            if (currentChar >=
                  charMap.
                    length)
                currentChar =
                  charMap.
                    length -
                    1;
        }
        addPtsToPath(
          shape,
          topPts,
          botPts,
          ptIdx);
        return shape;
    }
    public static final double eps = 1.0E-5;
    public static boolean epsEQ(double a,
                                double b) {
        return a +
          eps >
          b &&
          a -
          eps <
          b;
    }
    public static int makeConvexHull(java.awt.geom.Point2D.Float[] pts,
                                     int numPts) {
        java.awt.geom.Point2D.Float tmp;
        for (int i =
               1;
             i <
               numPts;
             i++) {
            if (pts[i].
                  x <
                  pts[i -
                        1].
                    x ||
                  pts[i].
                    x ==
                  pts[i -
                        1].
                    x &&
                  pts[i].
                    y <
                  pts[i -
                        1].
                    y) {
                tmp =
                  pts[i];
                pts[i] =
                  pts[i -
                        1];
                pts[i -
                      1] =
                  tmp;
                i =
                  0;
                continue;
            }
        }
        java.awt.geom.Point2D.Float pt0 =
          pts[0];
        java.awt.geom.Point2D.Float pt1 =
          pts[numPts -
                1];
        java.awt.geom.Point2D.Float dxdy =
          new java.awt.geom.Point2D.Float(
          pt1.
            x -
            pt0.
              x,
          pt1.
            y -
            pt0.
              y);
        float soln;
        float c =
          dxdy.
            y *
          pt0.
            x -
          dxdy.
            x *
          pt0.
            y;
        java.awt.geom.Point2D.Float[] topList =
          new java.awt.geom.Point2D.Float[numPts];
        java.awt.geom.Point2D.Float[] botList =
          new java.awt.geom.Point2D.Float[numPts];
        botList[0] =
          (topList[0] =
             pts[0]);
        int nTopPts =
          1;
        int nBotPts =
          1;
        for (int i =
               1;
             i <
               numPts -
               1;
             i++) {
            java.awt.geom.Point2D.Float pt =
              pts[i];
            soln =
              dxdy.
                x *
                pt.
                  y -
                dxdy.
                  y *
                pt.
                  x +
                c;
            if (soln <
                  0) {
                while (nBotPts >=
                         2) {
                    pt0 =
                      botList[nBotPts -
                                2];
                    pt1 =
                      botList[nBotPts -
                                1];
                    float dx =
                      pt1.
                        x -
                      pt0.
                        x;
                    float dy =
                      pt1.
                        y -
                      pt0.
                        y;
                    float c0 =
                      dy *
                      pt0.
                        x -
                      dx *
                      pt0.
                        y;
                    soln =
                      dx *
                        pt.
                          y -
                        dy *
                        pt.
                          x +
                        c0;
                    if (soln >
                          eps)
                        break;
                    if (soln >
                          -eps) {
                        if (pt1.
                              y <
                              pt.
                                y)
                            pt =
                              pt1;
                        nBotPts--;
                        break;
                    }
                    nBotPts--;
                }
                botList[nBotPts++] =
                  pt;
            }
            else {
                while (nTopPts >=
                         2) {
                    pt0 =
                      topList[nTopPts -
                                2];
                    pt1 =
                      topList[nTopPts -
                                1];
                    float dx =
                      pt1.
                        x -
                      pt0.
                        x;
                    float dy =
                      pt1.
                        y -
                      pt0.
                        y;
                    float c0 =
                      dy *
                      pt0.
                        x -
                      dx *
                      pt0.
                        y;
                    soln =
                      dx *
                        pt.
                          y -
                        dy *
                        pt.
                          x +
                        c0;
                    if (soln <
                          -eps)
                        break;
                    if (soln <
                          eps) {
                        if (pt1.
                              y >
                              pt.
                                y)
                            pt =
                              pt1;
                        nTopPts--;
                        break;
                    }
                    nTopPts--;
                }
                topList[nTopPts++] =
                  pt;
            }
        }
        java.awt.geom.Point2D.Float pt =
          pts[numPts -
                1];
        while (nBotPts >=
                 2) {
            pt0 =
              botList[nBotPts -
                        2];
            pt1 =
              botList[nBotPts -
                        1];
            float dx =
              pt1.
                x -
              pt0.
                x;
            float dy =
              pt1.
                y -
              pt0.
                y;
            float c0 =
              dy *
              pt0.
                x -
              dx *
              pt0.
                y;
            soln =
              dx *
                pt.
                  y -
                dy *
                pt.
                  x +
                c0;
            if (soln >
                  eps)
                break;
            if (soln >
                  -eps) {
                if (pt1.
                      y >=
                      pt.
                        y)
                    nBotPts--;
                break;
            }
            nBotPts--;
        }
        while (nTopPts >=
                 2) {
            pt0 =
              topList[nTopPts -
                        2];
            pt1 =
              topList[nTopPts -
                        1];
            float dx =
              pt1.
                x -
              pt0.
                x;
            float dy =
              pt1.
                y -
              pt0.
                y;
            float c0 =
              dy *
              pt0.
                x -
              dx *
              pt0.
                y;
            soln =
              dx *
                pt.
                  y -
                dy *
                pt.
                  x +
                c0;
            if (soln <
                  -eps)
                break;
            if (soln <
                  eps) {
                if (pt1.
                      y <=
                      pt.
                        y)
                    nTopPts--;
                break;
            }
            nTopPts--;
        }
        java.lang.System.
          arraycopy(
            topList,
            0,
            pts,
            0,
            nTopPts);
        int i =
          nTopPts;
        pts[i++] =
          pts[numPts -
                1];
        for (int n =
               nBotPts -
               1;
             n >
               0;
             n--,
               i++)
            pts[i] =
              botList[n];
        return i;
    }
    public static void addPtsToPath(java.awt.geom.GeneralPath shape,
                                    java.awt.geom.Point2D.Float[] topPts,
                                    java.awt.geom.Point2D.Float[] botPts,
                                    int numPts) {
        if (numPts <
              2)
            return;
        if (numPts ==
              2) {
            shape.
              moveTo(
                topPts[0].
                  x,
                topPts[0].
                  y);
            shape.
              lineTo(
                topPts[1].
                  x,
                topPts[1].
                  y);
            shape.
              lineTo(
                botPts[1].
                  x,
                botPts[1].
                  y);
            shape.
              lineTo(
                botPts[0].
                  x,
                botPts[0].
                  y);
            shape.
              lineTo(
                topPts[0].
                  x,
                topPts[0].
                  y);
            return;
        }
        java.awt.geom.Point2D.Float[] boxes =
          new java.awt.geom.Point2D.Float[8];
        java.awt.geom.Point2D.Float[] chull =
          new java.awt.geom.Point2D.Float[8];
        boxes[4] =
          topPts[0];
        boxes[5] =
          topPts[1];
        boxes[6] =
          botPts[1];
        boxes[7] =
          botPts[0];
        java.awt.geom.Area[] areas =
          new java.awt.geom.Area[numPts /
                                   2];
        int nAreas =
          0;
        for (int i =
               2;
             i <
               numPts;
             i +=
               2) {
            boxes[0] =
              boxes[4];
            boxes[1] =
              boxes[5];
            boxes[2] =
              boxes[6];
            boxes[3] =
              boxes[7];
            boxes[4] =
              topPts[i];
            boxes[5] =
              topPts[i +
                       1];
            boxes[6] =
              botPts[i +
                       1];
            boxes[7] =
              botPts[i];
            float delta;
            float sz;
            float dist;
            delta =
              boxes[2].
                x -
                boxes[0].
                  x;
            dist =
              delta *
                delta;
            delta =
              boxes[2].
                y -
                boxes[0].
                  y;
            dist +=
              delta *
                delta;
            sz =
              (float)
                java.lang.Math.
                sqrt(
                  dist);
            delta =
              boxes[6].
                x -
                boxes[4].
                  x;
            dist =
              delta *
                delta;
            delta =
              boxes[6].
                y -
                boxes[4].
                  y;
            dist +=
              delta *
                delta;
            sz +=
              (float)
                java.lang.Math.
                sqrt(
                  dist);
            delta =
              (boxes[0].
                 x +
                 boxes[1].
                   x +
                 boxes[2].
                   x +
                 boxes[3].
                   x -
                 (boxes[4].
                    x +
                    boxes[5].
                      x +
                    boxes[6].
                      x +
                    boxes[7].
                      x)) /
                4;
            dist =
              delta *
                delta;
            delta =
              (boxes[0].
                 y +
                 boxes[1].
                   y +
                 boxes[2].
                   y +
                 boxes[3].
                   y -
                 (boxes[4].
                    y +
                    boxes[5].
                      y +
                    boxes[6].
                      y +
                    boxes[7].
                      y)) /
                4;
            dist +=
              delta *
                delta;
            dist =
              (float)
                java.lang.Math.
                sqrt(
                  dist);
            java.awt.geom.GeneralPath gp =
              new java.awt.geom.GeneralPath(
              );
            if (dist <
                  sz) {
                java.lang.System.
                  arraycopy(
                    boxes,
                    0,
                    chull,
                    0,
                    8);
                int npts =
                  makeConvexHull(
                    chull,
                    8);
                gp.
                  moveTo(
                    chull[0].
                      x,
                    chull[0].
                      y);
                for (int n =
                       1;
                     n <
                       npts;
                     n++)
                    gp.
                      lineTo(
                        chull[n].
                          x,
                        chull[n].
                          y);
                gp.
                  closePath(
                    );
            }
            else {
                mergeAreas(
                  shape,
                  areas,
                  nAreas);
                nAreas =
                  0;
                if (i ==
                      2) {
                    gp.
                      moveTo(
                        boxes[0].
                          x,
                        boxes[0].
                          y);
                    gp.
                      lineTo(
                        boxes[1].
                          x,
                        boxes[1].
                          y);
                    gp.
                      lineTo(
                        boxes[2].
                          x,
                        boxes[2].
                          y);
                    gp.
                      lineTo(
                        boxes[3].
                          x,
                        boxes[3].
                          y);
                    gp.
                      closePath(
                        );
                    shape.
                      append(
                        gp,
                        false);
                    gp.
                      reset(
                        );
                }
                gp.
                  moveTo(
                    boxes[4].
                      x,
                    boxes[4].
                      y);
                gp.
                  lineTo(
                    boxes[5].
                      x,
                    boxes[5].
                      y);
                gp.
                  lineTo(
                    boxes[6].
                      x,
                    boxes[6].
                      y);
                gp.
                  lineTo(
                    boxes[7].
                      x,
                    boxes[7].
                      y);
                gp.
                  closePath(
                    );
            }
            areas[nAreas++] =
              new java.awt.geom.Area(
                gp);
        }
        mergeAreas(
          shape,
          areas,
          nAreas);
    }
    public static void mergeAreas(java.awt.geom.GeneralPath shape,
                                  java.awt.geom.Area[] shapes,
                                  int nShapes) {
        while (nShapes >
                 1) {
            int n =
              0;
            for (int i =
                   1;
                 i <
                   nShapes;
                 i +=
                   2) {
                shapes[i -
                         1].
                  add(
                    shapes[i]);
                shapes[n++] =
                  shapes[i -
                           1];
                shapes[i] =
                  null;
            }
            if ((nShapes &
                   1) ==
                  1)
                shapes[n -
                         1].
                  add(
                    shapes[nShapes -
                             1]);
            nShapes =
              nShapes /
                2;
        }
        if (nShapes ==
              1)
            shape.
              append(
                shapes[0],
                false);
    }
    public org.apache.batik.gvt.text.TextHit hitTestChar(float x,
                                                         float y) {
        syncLayout(
          );
        org.apache.batik.gvt.text.TextHit textHit =
          null;
        int currentChar =
          0;
        for (int i =
               0;
             i <
               gv.
               getNumGlyphs(
                 );
             i++) {
            java.awt.Shape gbounds =
              gv.
              getGlyphLogicalBounds(
                i);
            if (gbounds !=
                  null) {
                java.awt.geom.Rectangle2D gbounds2d =
                  gbounds.
                  getBounds2D(
                    );
                if (gbounds.
                      contains(
                        x,
                        y)) {
                    boolean isRightHalf =
                      x >
                      gbounds2d.
                      getX(
                        ) +
                      gbounds2d.
                      getWidth(
                        ) /
                      2.0;
                    boolean isLeadingEdge =
                      !isRightHalf;
                    int charIndex =
                      charMap[currentChar];
                    textHit =
                      new org.apache.batik.gvt.text.TextHit(
                        charIndex,
                        isLeadingEdge);
                    return textHit;
                }
            }
            currentChar +=
              getCharacterCount(
                i,
                i);
            if (currentChar >=
                  charMap.
                    length)
                currentChar =
                  charMap.
                    length -
                    1;
        }
        return textHit;
    }
    protected org.apache.batik.gvt.font.GVTFont getFont() {
        aci.
          first(
            );
        org.apache.batik.gvt.font.GVTFont gvtFont =
          (org.apache.batik.gvt.font.GVTFont)
            aci.
            getAttribute(
              GVT_FONT);
        if (gvtFont !=
              null)
            return gvtFont;
        return new org.apache.batik.gvt.font.AWTGVTFont(
          aci.
            getAttributes(
              ));
    }
    protected java.awt.Shape getOverlineShape() {
        double y =
          metrics.
          getOverlineOffset(
            );
        float overlineThickness =
          metrics.
          getOverlineThickness(
            );
        y +=
          overlineThickness;
        aci.
          first(
            );
        java.lang.Float dy =
          (java.lang.Float)
            aci.
            getAttribute(
              DY);
        if (dy !=
              null)
            y +=
              dy.
                floatValue(
                  );
        java.awt.Stroke overlineStroke =
          new java.awt.BasicStroke(
          overlineThickness);
        java.awt.geom.Rectangle2D logicalBounds =
          gv.
          getLogicalBounds(
            );
        return overlineStroke.
          createStrokedShape(
            new java.awt.geom.Line2D.Double(
              logicalBounds.
                getMinX(
                  ) +
                overlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y,
              logicalBounds.
                getMaxX(
                  ) -
                overlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y));
    }
    protected java.awt.Shape getUnderlineShape() {
        double y =
          metrics.
          getUnderlineOffset(
            );
        float underlineThickness =
          metrics.
          getUnderlineThickness(
            );
        y +=
          underlineThickness *
            1.5;
        java.awt.BasicStroke underlineStroke =
          new java.awt.BasicStroke(
          underlineThickness);
        aci.
          first(
            );
        java.lang.Float dy =
          (java.lang.Float)
            aci.
            getAttribute(
              DY);
        if (dy !=
              null)
            y +=
              dy.
                floatValue(
                  );
        java.awt.geom.Rectangle2D logicalBounds =
          gv.
          getLogicalBounds(
            );
        return underlineStroke.
          createStrokedShape(
            new java.awt.geom.Line2D.Double(
              logicalBounds.
                getMinX(
                  ) +
                underlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y,
              logicalBounds.
                getMaxX(
                  ) -
                underlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y));
    }
    protected java.awt.Shape getStrikethroughShape() {
        double y =
          metrics.
          getStrikethroughOffset(
            );
        float strikethroughThickness =
          metrics.
          getStrikethroughThickness(
            );
        java.awt.Stroke strikethroughStroke =
          new java.awt.BasicStroke(
          strikethroughThickness);
        aci.
          first(
            );
        java.lang.Float dy =
          (java.lang.Float)
            aci.
            getAttribute(
              DY);
        if (dy !=
              null)
            y +=
              dy.
                floatValue(
                  );
        java.awt.geom.Rectangle2D logicalBounds =
          gv.
          getLogicalBounds(
            );
        return strikethroughStroke.
          createStrokedShape(
            new java.awt.geom.Line2D.Double(
              logicalBounds.
                getMinX(
                  ) +
                strikethroughThickness /
                2.0,
              offset.
                getY(
                  ) +
                y,
              logicalBounds.
                getMaxX(
                  ) -
                strikethroughThickness /
                2.0,
              offset.
                getY(
                  ) +
                y));
    }
    protected void doExplicitGlyphLayout() {
        this.
          gv.
          performDefaultLayout(
            );
        float baselineAscent =
          vertical
          ? (float)
              gv.
              getLogicalBounds(
                ).
              getWidth(
                )
          : metrics.
          getAscent(
            ) +
          java.lang.Math.
          abs(
            metrics.
              getDescent(
                ));
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
        float verticalFirstOffset =
          0.0F;
        float horizontalFirstOffset =
          0.0F;
        boolean glyphOrientationAuto =
          isGlyphOrientationAuto(
            );
        int glyphOrientationAngle =
          0;
        if (!glyphOrientationAuto) {
            glyphOrientationAngle =
              getGlyphOrientationAngle(
                );
        }
        int i =
          0;
        int aciStart =
          aci.
          getBeginIndex(
            );
        int aciIndex =
          0;
        char ch =
          aci.
          first(
            );
        int runLimit =
          aciIndex +
          aciStart;
        java.lang.Float x =
          null;
        java.lang.Float y =
          null;
        java.lang.Float dx =
          null;
        java.lang.Float dy =
          null;
        java.lang.Float rotation =
          null;
        java.lang.Object baseline =
          null;
        float shift_x_pos =
          0;
        float shift_y_pos =
          0;
        float curr_x_pos =
          (float)
            offset.
            getX(
              );
        float curr_y_pos =
          (float)
            offset.
            getY(
              );
        java.awt.geom.Point2D.Float pos =
          new java.awt.geom.Point2D.Float(
          );
        boolean hasArabicTransparent =
          false;
        while (i <
                 numGlyphs) {
            if (aciIndex +
                  aciStart >=
                  runLimit) {
                runLimit =
                  aci.
                    getRunLimit(
                      runAtts);
                x =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      X);
                y =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      Y);
                dx =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      DX);
                dy =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      DY);
                rotation =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      ROTATION);
                baseline =
                  aci.
                    getAttribute(
                      BASELINE_SHIFT);
            }
            org.apache.batik.gvt.font.GVTGlyphMetrics gm =
              gv.
              getGlyphMetrics(
                i);
            if (i ==
                  0) {
                if (isVertical(
                      )) {
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            verticalFirstOffset =
                              0.0F;
                        }
                        else {
                            float advY =
                              gm.
                              getVerticalAdvance(
                                );
                            float asc =
                              metrics.
                              getAscent(
                                );
                            float dsc =
                              metrics.
                              getDescent(
                                );
                            verticalFirstOffset =
                              asc +
                                (advY -
                                   (asc +
                                      dsc)) /
                                2;
                        }
                    }
                    else {
                        if (glyphOrientationAngle ==
                              0) {
                            float advY =
                              gm.
                              getVerticalAdvance(
                                );
                            float asc =
                              metrics.
                              getAscent(
                                );
                            float dsc =
                              metrics.
                              getDescent(
                                );
                            verticalFirstOffset =
                              asc +
                                (advY -
                                   (asc +
                                      dsc)) /
                                2;
                        }
                        else {
                            verticalFirstOffset =
                              0.0F;
                        }
                    }
                }
                else {
                    if (glyphOrientationAngle ==
                          270) {
                        horizontalFirstOffset =
                          (float)
                            gm.
                            getBounds2D(
                              ).
                            getHeight(
                              );
                    }
                    else {
                        horizontalFirstOffset =
                          0;
                    }
                }
            }
            else {
                if (glyphOrientationAuto &&
                      verticalFirstOffset ==
                      0.0F &&
                      !isLatinChar(
                         ch)) {
                    float advY =
                      gm.
                      getVerticalAdvance(
                        );
                    float asc =
                      metrics.
                      getAscent(
                        );
                    float dsc =
                      metrics.
                      getDescent(
                        );
                    verticalFirstOffset =
                      asc +
                        (advY -
                           (asc +
                              dsc)) /
                        2;
                }
            }
            float ox =
              0.0F;
            float oy =
              0.0F;
            float glyphOrientationRotation =
              0.0F;
            float glyphRotation =
              0.0F;
            if (ch !=
                  java.text.CharacterIterator.
                    DONE) {
                if (vertical) {
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            glyphOrientationRotation =
                              (float)
                                (java.lang.Math.
                                   PI /
                                   2.0F);
                        }
                        else {
                            glyphOrientationRotation =
                              0.0F;
                        }
                    }
                    else {
                        glyphOrientationRotation =
                          (float)
                            java.lang.Math.
                            toRadians(
                              glyphOrientationAngle);
                    }
                    if (textPath !=
                          null) {
                        x =
                          null;
                    }
                }
                else {
                    glyphOrientationRotation =
                      (float)
                        java.lang.Math.
                        toRadians(
                          glyphOrientationAngle);
                    if (textPath !=
                          null) {
                        y =
                          null;
                    }
                }
                if (rotation ==
                      null ||
                      rotation.
                      isNaN(
                        )) {
                    glyphRotation =
                      glyphOrientationRotation;
                }
                else {
                    glyphRotation =
                      rotation.
                        floatValue(
                          ) +
                        glyphOrientationRotation;
                }
                if (x !=
                      null &&
                      !x.
                      isNaN(
                        )) {
                    if (i ==
                          0)
                        shift_x_pos =
                          (float)
                            (x.
                               floatValue(
                                 ) -
                               offset.
                               getX(
                                 ));
                    curr_x_pos =
                      x.
                        floatValue(
                          ) -
                        shift_x_pos;
                }
                if (dx !=
                      null &&
                      !dx.
                      isNaN(
                        )) {
                    curr_x_pos +=
                      dx.
                        floatValue(
                          );
                }
                if (y !=
                      null &&
                      !y.
                      isNaN(
                        )) {
                    if (i ==
                          0)
                        shift_y_pos =
                          (float)
                            (y.
                               floatValue(
                                 ) -
                               offset.
                               getY(
                                 ));
                    curr_y_pos =
                      y.
                        floatValue(
                          ) -
                        shift_y_pos;
                }
                if (dy !=
                      null &&
                      !dy.
                      isNaN(
                        )) {
                    curr_y_pos +=
                      dy.
                        floatValue(
                          );
                }
                else
                    if (i >
                          0) {
                        curr_y_pos +=
                          gp[i *
                               2 +
                               1] -
                            gp[i *
                                 2 -
                                 1];
                    }
                float baselineAdjust =
                  0.0F;
                if (baseline !=
                      null) {
                    if (baseline instanceof java.lang.Integer) {
                        if (baseline ==
                              java.awt.font.TextAttribute.
                                SUPERSCRIPT_SUPER) {
                            baselineAdjust =
                              baselineAscent *
                                0.5F;
                        }
                        else
                            if (baseline ==
                                  java.awt.font.TextAttribute.
                                    SUPERSCRIPT_SUB) {
                                baselineAdjust =
                                  -baselineAscent *
                                    0.5F;
                            }
                    }
                    else
                        if (baseline instanceof java.lang.Float) {
                            baselineAdjust =
                              ((java.lang.Float)
                                 baseline).
                                floatValue(
                                  );
                        }
                    if (vertical) {
                        ox =
                          baselineAdjust;
                    }
                    else {
                        oy =
                          -baselineAdjust;
                    }
                }
                if (vertical) {
                    oy +=
                      verticalFirstOffset;
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            ox +=
                              metrics.
                                getStrikethroughOffset(
                                  );
                        }
                        else {
                            java.awt.geom.Rectangle2D glyphBounds =
                              gv.
                              getGlyphVisualBounds(
                                i).
                              getBounds2D(
                                );
                            ox -=
                              (float)
                                (glyphBounds.
                                   getMaxX(
                                     ) -
                                   gp[2 *
                                        i] -
                                   glyphBounds.
                                   getWidth(
                                     ) /
                                   2);
                        }
                    }
                    else {
                        java.awt.geom.Rectangle2D glyphBounds =
                          gv.
                          getGlyphVisualBounds(
                            i).
                          getBounds2D(
                            );
                        if (glyphOrientationAngle ==
                              0) {
                            ox -=
                              (float)
                                (glyphBounds.
                                   getMaxX(
                                     ) -
                                   gp[2 *
                                        i] -
                                   glyphBounds.
                                   getWidth(
                                     ) /
                                   2);
                        }
                        else
                            if (glyphOrientationAngle ==
                                  180) {
                                ox +=
                                  (float)
                                    (glyphBounds.
                                       getMaxX(
                                         ) -
                                       gp[2 *
                                            i] -
                                       glyphBounds.
                                       getWidth(
                                         ) /
                                       2);
                            }
                            else
                                if (glyphOrientationAngle ==
                                      90) {
                                    ox +=
                                      metrics.
                                        getStrikethroughOffset(
                                          );
                                }
                                else {
                                    ox -=
                                      metrics.
                                        getStrikethroughOffset(
                                          );
                                }
                    }
                }
                else {
                    ox +=
                      horizontalFirstOffset;
                    if (glyphOrientationAngle ==
                          90) {
                        oy -=
                          gm.
                            getHorizontalAdvance(
                              );
                    }
                    else
                        if (glyphOrientationAngle ==
                              180) {
                            oy -=
                              metrics.
                                getAscent(
                                  );
                        }
                }
            }
            pos.
              x =
              curr_x_pos +
                ox;
            pos.
              y =
              curr_y_pos +
                oy;
            gv.
              setGlyphPosition(
                i,
                pos);
            if (org.apache.batik.gvt.text.ArabicTextHandler.
                  arabicCharTransparent(
                    ch)) {
                hasArabicTransparent =
                  true;
            }
            else {
                if (vertical) {
                    float advanceY =
                      0;
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            advanceY =
                              gm.
                                getHorizontalAdvance(
                                  );
                        }
                        else {
                            advanceY =
                              gm.
                                getVerticalAdvance(
                                  );
                        }
                    }
                    else {
                        if (glyphOrientationAngle ==
                              0 ||
                              glyphOrientationAngle ==
                              180) {
                            advanceY =
                              gm.
                                getVerticalAdvance(
                                  );
                        }
                        else
                            if (glyphOrientationAngle ==
                                  90) {
                                advanceY =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                            }
                            else {
                                advanceY =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                                gv.
                                  setGlyphTransform(
                                    i,
                                    java.awt.geom.AffineTransform.
                                      getTranslateInstance(
                                        0,
                                        advanceY));
                            }
                    }
                    curr_y_pos +=
                      advanceY;
                }
                else {
                    float advanceX =
                      0;
                    if (glyphOrientationAngle ==
                          0) {
                        advanceX =
                          gm.
                            getHorizontalAdvance(
                              );
                    }
                    else
                        if (glyphOrientationAngle ==
                              180) {
                            advanceX =
                              gm.
                                getHorizontalAdvance(
                                  );
                            gv.
                              setGlyphTransform(
                                i,
                                java.awt.geom.AffineTransform.
                                  getTranslateInstance(
                                    advanceX,
                                    0));
                        }
                        else {
                            advanceX =
                              gm.
                                getVerticalAdvance(
                                  );
                        }
                    curr_x_pos +=
                      advanceX;
                }
            }
            if (!epsEQ(
                   glyphRotation,
                   0)) {
                java.awt.geom.AffineTransform glyphTransform =
                  gv.
                  getGlyphTransform(
                    i);
                if (glyphTransform ==
                      null) {
                    glyphTransform =
                      new java.awt.geom.AffineTransform(
                        );
                }
                java.awt.geom.AffineTransform rotAt;
                if (epsEQ(
                      glyphRotation,
                      java.lang.Math.
                        PI /
                        2)) {
                    rotAt =
                      new java.awt.geom.AffineTransform(
                        0,
                        1,
                        -1,
                        0,
                        0,
                        0);
                }
                else
                    if (epsEQ(
                          glyphRotation,
                          java.lang.Math.
                            PI)) {
                        rotAt =
                          new java.awt.geom.AffineTransform(
                            -1,
                            0,
                            0,
                            -1,
                            0,
                            0);
                    }
                    else
                        if (epsEQ(
                              glyphRotation,
                              3 *
                                java.lang.Math.
                                  PI /
                                2)) {
                            rotAt =
                              new java.awt.geom.AffineTransform(
                                0,
                                -1,
                                1,
                                0,
                                0,
                                0);
                        }
                        else {
                            rotAt =
                              java.awt.geom.AffineTransform.
                                getRotateInstance(
                                  glyphRotation);
                        }
                glyphTransform.
                  concatenate(
                    rotAt);
                gv.
                  setGlyphTransform(
                    i,
                    glyphTransform);
            }
            aciIndex +=
              gv.
                getCharacterCount(
                  i,
                  i);
            if (aciIndex >=
                  charMap.
                    length)
                aciIndex =
                  charMap.
                    length -
                    1;
            ch =
              aci.
                setIndex(
                  aciIndex +
                    aciStart);
            i++;
        }
        pos.
          x =
          curr_x_pos;
        pos.
          y =
          curr_y_pos;
        gv.
          setGlyphPosition(
            i,
            pos);
        advance =
          new java.awt.geom.Point2D.Float(
            (float)
              (curr_x_pos -
                 offset.
                 getX(
                   )),
            (float)
              (curr_y_pos -
                 offset.
                 getY(
                   )));
        if (hasArabicTransparent) {
            ch =
              aci.
                first(
                  );
            aciIndex =
              0;
            i =
              0;
            int transparentStart =
              -1;
            while (i <
                     numGlyphs) {
                if (org.apache.batik.gvt.text.ArabicTextHandler.
                      arabicCharTransparent(
                        ch)) {
                    if (transparentStart ==
                          -1)
                        transparentStart =
                          i;
                }
                else {
                    if (transparentStart !=
                          -1) {
                        java.awt.geom.Point2D loc =
                          gv.
                          getGlyphPosition(
                            i);
                        org.apache.batik.gvt.font.GVTGlyphMetrics gm =
                          gv.
                          getGlyphMetrics(
                            i);
                        int tyS =
                          0;
                        int txS =
                          0;
                        float advX =
                          0;
                        float advY =
                          0;
                        if (vertical) {
                            if (glyphOrientationAuto ||
                                  glyphOrientationAngle ==
                                  90)
                                advY =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                            else
                                if (glyphOrientationAngle ==
                                      270)
                                    advY =
                                      0;
                                else
                                    if (glyphOrientationAngle ==
                                          0)
                                        advX =
                                          gm.
                                            getHorizontalAdvance(
                                              );
                                    else
                                        advX =
                                          -gm.
                                            getHorizontalAdvance(
                                              );
                        }
                        else {
                            if (glyphOrientationAngle ==
                                  0)
                                advX =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                            else
                                if (glyphOrientationAngle ==
                                      90)
                                    advY =
                                      gm.
                                        getHorizontalAdvance(
                                          );
                                else
                                    if (glyphOrientationAngle ==
                                          180)
                                        advX =
                                          0;
                                    else
                                        advY =
                                          -gm.
                                            getHorizontalAdvance(
                                              );
                        }
                        float baseX =
                          (float)
                            (loc.
                               getX(
                                 ) +
                               advX);
                        float baseY =
                          (float)
                            (loc.
                               getY(
                                 ) +
                               advY);
                        for (int j =
                               transparentStart;
                             j <
                               i;
                             j++) {
                            java.awt.geom.Point2D locT =
                              gv.
                              getGlyphPosition(
                                j);
                            org.apache.batik.gvt.font.GVTGlyphMetrics gmT =
                              gv.
                              getGlyphMetrics(
                                j);
                            float locX =
                              (float)
                                locT.
                                getX(
                                  );
                            float locY =
                              (float)
                                locT.
                                getY(
                                  );
                            float tx =
                              0;
                            float ty =
                              0;
                            float advT =
                              gmT.
                              getHorizontalAdvance(
                                );
                            if (vertical) {
                                if (glyphOrientationAuto ||
                                      glyphOrientationAngle ==
                                      90)
                                    locY =
                                      baseY -
                                        advT;
                                else
                                    if (glyphOrientationAngle ==
                                          270)
                                        locY =
                                          baseY +
                                            advT;
                                    else
                                        if (glyphOrientationAngle ==
                                              0)
                                            locX =
                                              baseX -
                                                advT;
                                        else
                                            locX =
                                              baseX +
                                                advT;
                            }
                            else {
                                if (glyphOrientationAngle ==
                                      0)
                                    locX =
                                      baseX -
                                        advT;
                                else
                                    if (glyphOrientationAngle ==
                                          90)
                                        locY =
                                          baseY -
                                            advT;
                                    else
                                        if (glyphOrientationAngle ==
                                              180)
                                            locX =
                                              baseX +
                                                advT;
                                        else
                                            locY =
                                              baseY +
                                                advT;
                            }
                            locT =
                              new java.awt.geom.Point2D.Double(
                                locX,
                                locY);
                            gv.
                              setGlyphPosition(
                                j,
                                locT);
                            if (txS !=
                                  0 ||
                                  tyS !=
                                  0) {
                                java.awt.geom.AffineTransform at;
                                at =
                                  java.awt.geom.AffineTransform.
                                    getTranslateInstance(
                                      tx,
                                      ty);
                                at.
                                  concatenate(
                                    gv.
                                      getGlyphTransform(
                                        i));
                                gv.
                                  setGlyphTransform(
                                    i,
                                    at);
                            }
                        }
                        transparentStart =
                          -1;
                    }
                }
                aciIndex +=
                  gv.
                    getCharacterCount(
                      i,
                      i);
                if (aciIndex >=
                      charMap.
                        length)
                    aciIndex =
                      charMap.
                        length -
                        1;
                ch =
                  aci.
                    setIndex(
                      aciIndex +
                        aciStart);
                i++;
            }
        }
        layoutApplied =
          true;
        spacingApplied =
          false;
        glyphAdvances =
          null;
        pathApplied =
          false;
    }
    protected void adjustTextSpacing() { if (spacingApplied)
                                             return;
                                         if (!layoutApplied)
                                             doExplicitGlyphLayout(
                                               );
                                         aci.
                                           first(
                                             );
                                         java.lang.Boolean customSpacing =
                                           (java.lang.Boolean)
                                             aci.
                                             getAttribute(
                                               org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                 CUSTOM_SPACING);
                                         if (customSpacing !=
                                               null &&
                                               customSpacing.
                                               booleanValue(
                                                 )) {
                                             advance =
                                               doSpacing(
                                                 (java.lang.Float)
                                                   aci.
                                                   getAttribute(
                                                     org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                       KERNING),
                                                 (java.lang.Float)
                                                   aci.
                                                   getAttribute(
                                                     org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                       LETTER_SPACING),
                                                 (java.lang.Float)
                                                   aci.
                                                   getAttribute(
                                                     org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                       WORD_SPACING));
                                             layoutApplied =
                                               false;
                                         }
                                         applyStretchTransform(
                                           !adjSpacing);
                                         spacingApplied =
                                           true;
                                         pathApplied =
                                           false;
    }
    protected java.awt.geom.Point2D doSpacing(java.lang.Float kern,
                                              java.lang.Float letterSpacing,
                                              java.lang.Float wordSpacing) {
        boolean autoKern =
          true;
        boolean doWordSpacing =
          false;
        boolean doLetterSpacing =
          false;
        float kernVal =
          0.0F;
        float letterSpacingVal =
          0.0F;
        if (kern !=
              null &&
              !kern.
              isNaN(
                )) {
            kernVal =
              kern.
                floatValue(
                  );
            autoKern =
              false;
        }
        if (letterSpacing !=
              null &&
              !letterSpacing.
              isNaN(
                )) {
            letterSpacingVal =
              letterSpacing.
                floatValue(
                  );
            doLetterSpacing =
              true;
        }
        if (wordSpacing !=
              null &&
              !wordSpacing.
              isNaN(
                )) {
            doWordSpacing =
              true;
        }
        int numGlyphs =
          gv.
          getNumGlyphs(
            );
        float dx =
          0.0F;
        float dy =
          0.0F;
        java.awt.geom.Point2D[] newPositions =
          new java.awt.geom.Point2D[numGlyphs +
                                      1];
        java.awt.geom.Point2D prevPos =
          gv.
          getGlyphPosition(
            0);
        int prevCode =
          gv.
          getGlyphCode(
            0);
        float x =
          (float)
            prevPos.
            getX(
              );
        float y =
          (float)
            prevPos.
            getY(
              );
        java.awt.geom.Point2D lastCharAdvance =
          new java.awt.geom.Point2D.Double(
          advance.
            getX(
              ) -
            (gv.
               getGlyphPosition(
                 numGlyphs -
                   1).
               getX(
                 ) -
               x),
          advance.
            getY(
              ) -
            (gv.
               getGlyphPosition(
                 numGlyphs -
                   1).
               getY(
                 ) -
               y));
        try {
            org.apache.batik.gvt.font.GVTFont font =
              gv.
              getFont(
                );
            if (numGlyphs >
                  1 &&
                  (doLetterSpacing ||
                     !autoKern)) {
                for (int i =
                       1;
                     i <=
                       numGlyphs;
                     ++i) {
                    java.awt.geom.Point2D gpos =
                      gv.
                      getGlyphPosition(
                        i);
                    int currCode;
                    currCode =
                      i ==
                        numGlyphs
                        ? -1
                        : gv.
                        getGlyphCode(
                          i);
                    dx =
                      (float)
                        gpos.
                        getX(
                          ) -
                        (float)
                          prevPos.
                          getX(
                            );
                    dy =
                      (float)
                        gpos.
                        getY(
                          ) -
                        (float)
                          prevPos.
                          getY(
                            );
                    if (autoKern) {
                        if (vertical)
                            dy +=
                              letterSpacingVal;
                        else
                            dx +=
                              letterSpacingVal;
                    }
                    else {
                        if (vertical) {
                            float vKern =
                              0;
                            if (currCode !=
                                  -1)
                                vKern =
                                  font.
                                    getVKern(
                                      prevCode,
                                      currCode);
                            dy +=
                              kernVal -
                                vKern +
                                letterSpacingVal;
                        }
                        else {
                            float hKern =
                              0;
                            if (currCode !=
                                  -1)
                                hKern =
                                  font.
                                    getHKern(
                                      prevCode,
                                      currCode);
                            dx +=
                              kernVal -
                                hKern +
                                letterSpacingVal;
                        }
                    }
                    x +=
                      dx;
                    y +=
                      dy;
                    newPositions[i] =
                      new java.awt.geom.Point2D.Float(
                        x,
                        y);
                    prevPos =
                      gpos;
                    prevCode =
                      currCode;
                }
                for (int i =
                       1;
                     i <=
                       numGlyphs;
                     ++i) {
                    if (newPositions[i] !=
                          null) {
                        gv.
                          setGlyphPosition(
                            i,
                            newPositions[i]);
                    }
                }
            }
            if (vertical) {
                lastCharAdvance.
                  setLocation(
                    lastCharAdvance.
                      getX(
                        ),
                    lastCharAdvance.
                      getY(
                        ) +
                      kernVal +
                      letterSpacingVal);
            }
            else {
                lastCharAdvance.
                  setLocation(
                    lastCharAdvance.
                      getX(
                        ) +
                      kernVal +
                      letterSpacingVal,
                    lastCharAdvance.
                      getY(
                        ));
            }
            dx =
              0.0F;
            dy =
              0.0F;
            prevPos =
              gv.
                getGlyphPosition(
                  0);
            x =
              (float)
                prevPos.
                getX(
                  );
            y =
              (float)
                prevPos.
                getY(
                  );
            if (numGlyphs >
                  1 &&
                  doWordSpacing) {
                for (int i =
                       1;
                     i <
                       numGlyphs;
                     i++) {
                    java.awt.geom.Point2D gpos =
                      gv.
                      getGlyphPosition(
                        i);
                    dx =
                      (float)
                        gpos.
                        getX(
                          ) -
                        (float)
                          prevPos.
                          getX(
                            );
                    dy =
                      (float)
                        gpos.
                        getY(
                          ) -
                        (float)
                          prevPos.
                          getY(
                            );
                    boolean inWS =
                      false;
                    int beginWS =
                      i;
                    int endWS =
                      i;
                    org.apache.batik.gvt.font.GVTGlyphMetrics gm =
                      gv.
                      getGlyphMetrics(
                        i);
                    while (gm.
                             getBounds2D(
                               ).
                             getWidth(
                               ) <
                             0.01 ||
                             gm.
                             isWhitespace(
                               )) {
                        if (!inWS)
                            inWS =
                              true;
                        if (i ==
                              numGlyphs -
                              1) {
                            break;
                        }
                        ++i;
                        ++endWS;
                        gpos =
                          gv.
                            getGlyphPosition(
                              i);
                        gm =
                          gv.
                            getGlyphMetrics(
                              i);
                    }
                    if (inWS) {
                        int nWS =
                          endWS -
                          beginWS;
                        float px =
                          (float)
                            prevPos.
                            getX(
                              );
                        float py =
                          (float)
                            prevPos.
                            getY(
                              );
                        dx =
                          (float)
                            (gpos.
                               getX(
                                 ) -
                               px) /
                            (nWS +
                               1);
                        dy =
                          (float)
                            (gpos.
                               getY(
                                 ) -
                               py) /
                            (nWS +
                               1);
                        if (vertical) {
                            dy +=
                              wordSpacing.
                                floatValue(
                                  ) /
                                (nWS +
                                   1);
                        }
                        else {
                            dx +=
                              wordSpacing.
                                floatValue(
                                  ) /
                                (nWS +
                                   1);
                        }
                        for (int j =
                               beginWS;
                             j <=
                               endWS;
                             ++j) {
                            x +=
                              dx;
                            y +=
                              dy;
                            newPositions[j] =
                              new java.awt.geom.Point2D.Float(
                                x,
                                y);
                        }
                    }
                    else {
                        dx =
                          (float)
                            (gpos.
                               getX(
                                 ) -
                               prevPos.
                               getX(
                                 ));
                        dy =
                          (float)
                            (gpos.
                               getY(
                                 ) -
                               prevPos.
                               getY(
                                 ));
                        x +=
                          dx;
                        y +=
                          dy;
                        newPositions[i] =
                          new java.awt.geom.Point2D.Float(
                            x,
                            y);
                    }
                    prevPos =
                      gpos;
                }
                java.awt.geom.Point2D gPos =
                  gv.
                  getGlyphPosition(
                    numGlyphs);
                x +=
                  (float)
                    (gPos.
                       getX(
                         ) -
                       prevPos.
                       getX(
                         ));
                y +=
                  (float)
                    (gPos.
                       getY(
                         ) -
                       prevPos.
                       getY(
                         ));
                newPositions[numGlyphs] =
                  new java.awt.geom.Point2D.Float(
                    x,
                    y);
                for (int i =
                       1;
                     i <=
                       numGlyphs;
                     ++i) {
                    if (newPositions[i] !=
                          null) {
                        gv.
                          setGlyphPosition(
                            i,
                            newPositions[i]);
                    }
                }
            }
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
        }
        double advX =
          gv.
          getGlyphPosition(
            numGlyphs -
              1).
          getX(
            ) -
          gv.
          getGlyphPosition(
            0).
          getX(
            );
        double advY =
          gv.
          getGlyphPosition(
            numGlyphs -
              1).
          getY(
            ) -
          gv.
          getGlyphPosition(
            0).
          getY(
            );
        java.awt.geom.Point2D newAdvance =
          new java.awt.geom.Point2D.Double(
          advX +
            lastCharAdvance.
            getX(
              ),
          advY +
            lastCharAdvance.
            getY(
              ));
        return newAdvance;
    }
    protected void applyStretchTransform(boolean stretchGlyphs) {
        if (xScale ==
              1 &&
              yScale ==
              1)
            return;
        java.awt.geom.AffineTransform scaleAT =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            xScale,
            yScale);
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
        float initX =
          gp[0];
        float initY =
          gp[1];
        java.awt.geom.Point2D.Float pos =
          new java.awt.geom.Point2D.Float(
          );
        for (int i =
               0;
             i <=
               numGlyphs;
             i++) {
            float dx =
              gp[2 *
                   i] -
              initX;
            float dy =
              gp[2 *
                   i +
                   1] -
              initY;
            pos.
              x =
              initX +
                dx *
                xScale;
            pos.
              y =
              initY +
                dy *
                yScale;
            gv.
              setGlyphPosition(
                i,
                pos);
            if (stretchGlyphs &&
                  i !=
                  numGlyphs) {
                java.awt.geom.AffineTransform glyphTransform =
                  gv.
                  getGlyphTransform(
                    i);
                if (glyphTransform !=
                      null) {
                    glyphTransform.
                      preConcatenate(
                        scaleAT);
                    gv.
                      setGlyphTransform(
                        i,
                        glyphTransform);
                }
                else {
                    gv.
                      setGlyphTransform(
                        i,
                        scaleAT);
                }
            }
        }
        advance =
          new java.awt.geom.Point2D.Float(
            (float)
              (advance.
                 getX(
                   ) *
                 xScale),
            (float)
              (advance.
                 getY(
                   ) *
                 yScale));
        layoutApplied =
          false;
    }
    protected void doPathLayout() { if (pathApplied)
                                        return;
                                    if (!spacingApplied)
                                        adjustTextSpacing(
                                          );
                                    getGlyphAdvances(
                                      );
                                    if (textPath ==
                                          null) {
                                        pathApplied =
                                          true;
                                        return;
                                    }
                                    boolean horizontal =
                                      !isVertical(
                                         );
                                    boolean glyphOrientationAuto =
                                      isGlyphOrientationAuto(
                                        );
                                    int glyphOrientationAngle =
                                      0;
                                    if (!glyphOrientationAuto) {
                                        glyphOrientationAngle =
                                          getGlyphOrientationAngle(
                                            );
                                    }
                                    float pathLength =
                                      textPath.
                                      lengthOfPath(
                                        );
                                    float startOffset =
                                      textPath.
                                      getStartOffset(
                                        );
                                    int numGlyphs =
                                      gv.
                                      getNumGlyphs(
                                        );
                                    for (int i =
                                           0;
                                         i <
                                           numGlyphs;
                                         i++) {
                                        gv.
                                          setGlyphVisible(
                                            i,
                                            true);
                                    }
                                    float glyphsLength;
                                    if (horizontal) {
                                        glyphsLength =
                                          (float)
                                            gv.
                                            getLogicalBounds(
                                              ).
                                            getWidth(
                                              );
                                    }
                                    else {
                                        glyphsLength =
                                          (float)
                                            gv.
                                            getLogicalBounds(
                                              ).
                                            getHeight(
                                              );
                                    }
                                    if (pathLength ==
                                          0.0F ||
                                          glyphsLength ==
                                          0.0F) {
                                        pathApplied =
                                          true;
                                        textPathAdvance =
                                          advance;
                                        return;
                                    }
                                    java.awt.geom.Point2D firstGlyphPosition =
                                      gv.
                                      getGlyphPosition(
                                        0);
                                    float glyphOffset =
                                      0;
                                    float currentPosition;
                                    if (horizontal) {
                                        glyphOffset =
                                          (float)
                                            firstGlyphPosition.
                                            getY(
                                              );
                                        currentPosition =
                                          (float)
                                            (firstGlyphPosition.
                                               getX(
                                                 ) +
                                               startOffset);
                                    }
                                    else {
                                        glyphOffset =
                                          (float)
                                            firstGlyphPosition.
                                            getX(
                                              );
                                        currentPosition =
                                          (float)
                                            (firstGlyphPosition.
                                               getY(
                                                 ) +
                                               startOffset);
                                    }
                                    char ch =
                                      aci.
                                      first(
                                        );
                                    int start =
                                      aci.
                                      getBeginIndex(
                                        );
                                    int currentChar =
                                      0;
                                    int lastGlyphDrawn =
                                      -1;
                                    float lastGlyphAdvance =
                                      0;
                                    for (int i =
                                           0;
                                         i <
                                           numGlyphs;
                                         i++) {
                                        java.awt.geom.Point2D currentGlyphPos =
                                          gv.
                                          getGlyphPosition(
                                            i);
                                        float glyphAdvance =
                                          0;
                                        float nextGlyphOffset =
                                          0;
                                        java.awt.geom.Point2D nextGlyphPosition =
                                          gv.
                                          getGlyphPosition(
                                            i +
                                              1);
                                        if (horizontal) {
                                            glyphAdvance =
                                              (float)
                                                (nextGlyphPosition.
                                                   getX(
                                                     ) -
                                                   currentGlyphPos.
                                                   getX(
                                                     ));
                                            nextGlyphOffset =
                                              (float)
                                                (nextGlyphPosition.
                                                   getY(
                                                     ) -
                                                   currentGlyphPos.
                                                   getY(
                                                     ));
                                        }
                                        else {
                                            glyphAdvance =
                                              (float)
                                                (nextGlyphPosition.
                                                   getY(
                                                     ) -
                                                   currentGlyphPos.
                                                   getY(
                                                     ));
                                            nextGlyphOffset =
                                              (float)
                                                (nextGlyphPosition.
                                                   getX(
                                                     ) -
                                                   currentGlyphPos.
                                                   getX(
                                                     ));
                                        }
                                        java.awt.geom.Rectangle2D glyphBounds =
                                          gv.
                                          getGlyphOutline(
                                            i).
                                          getBounds2D(
                                            );
                                        float glyphWidth =
                                          (float)
                                            glyphBounds.
                                            getWidth(
                                              );
                                        float glyphHeight =
                                          (float)
                                            glyphBounds.
                                            getHeight(
                                              );
                                        float glyphMidX =
                                          0;
                                        if (glyphWidth >
                                              0) {
                                            glyphMidX =
                                              (float)
                                                (glyphBounds.
                                                   getX(
                                                     ) +
                                                   glyphWidth /
                                                   2.0F);
                                            glyphMidX -=
                                              (float)
                                                currentGlyphPos.
                                                getX(
                                                  );
                                        }
                                        float glyphMidY =
                                          0;
                                        if (glyphHeight >
                                              0) {
                                            glyphMidY =
                                              (float)
                                                (glyphBounds.
                                                   getY(
                                                     ) +
                                                   glyphHeight /
                                                   2.0F);
                                            glyphMidY -=
                                              (float)
                                                currentGlyphPos.
                                                getY(
                                                  );
                                        }
                                        float charMidPos;
                                        if (horizontal) {
                                            charMidPos =
                                              currentPosition +
                                                glyphMidX;
                                        }
                                        else {
                                            charMidPos =
                                              currentPosition +
                                                glyphMidY;
                                        }
                                        java.awt.geom.Point2D charMidPoint =
                                          textPath.
                                          pointAtLength(
                                            charMidPos);
                                        if (charMidPoint !=
                                              null) {
                                            float angle =
                                              textPath.
                                              angleAtLength(
                                                charMidPos);
                                            java.awt.geom.AffineTransform glyphPathTransform =
                                              new java.awt.geom.AffineTransform(
                                              );
                                            if (horizontal) {
                                                glyphPathTransform.
                                                  rotate(
                                                    angle);
                                            }
                                            else {
                                                glyphPathTransform.
                                                  rotate(
                                                    angle -
                                                      java.lang.Math.
                                                        PI /
                                                      2);
                                            }
                                            if (horizontal) {
                                                glyphPathTransform.
                                                  translate(
                                                    0,
                                                    glyphOffset);
                                            }
                                            else {
                                                glyphPathTransform.
                                                  translate(
                                                    glyphOffset,
                                                    0);
                                            }
                                            if (horizontal) {
                                                glyphPathTransform.
                                                  translate(
                                                    -glyphMidX,
                                                    0.0F);
                                            }
                                            else {
                                                glyphPathTransform.
                                                  translate(
                                                    0.0F,
                                                    -glyphMidY);
                                            }
                                            java.awt.geom.AffineTransform glyphTransform =
                                              gv.
                                              getGlyphTransform(
                                                i);
                                            if (glyphTransform !=
                                                  null) {
                                                glyphPathTransform.
                                                  concatenate(
                                                    glyphTransform);
                                            }
                                            gv.
                                              setGlyphTransform(
                                                i,
                                                glyphPathTransform);
                                            gv.
                                              setGlyphPosition(
                                                i,
                                                charMidPoint);
                                            lastGlyphDrawn =
                                              i;
                                            lastGlyphAdvance =
                                              glyphAdvance;
                                        }
                                        else {
                                            gv.
                                              setGlyphVisible(
                                                i,
                                                false);
                                        }
                                        currentPosition +=
                                          glyphAdvance;
                                        glyphOffset +=
                                          nextGlyphOffset;
                                        currentChar +=
                                          gv.
                                            getCharacterCount(
                                              i,
                                              i);
                                        if (currentChar >=
                                              charMap.
                                                length)
                                            currentChar =
                                              charMap.
                                                length -
                                                1;
                                        ch =
                                          aci.
                                            setIndex(
                                              currentChar +
                                                start);
                                    }
                                    if (lastGlyphDrawn >
                                          -1) {
                                        java.awt.geom.Point2D lastGlyphPos =
                                          gv.
                                          getGlyphPosition(
                                            lastGlyphDrawn);
                                        if (horizontal) {
                                            textPathAdvance =
                                              new java.awt.geom.Point2D.Double(
                                                lastGlyphPos.
                                                  getX(
                                                    ) +
                                                  lastGlyphAdvance,
                                                lastGlyphPos.
                                                  getY(
                                                    ));
                                        }
                                        else {
                                            textPathAdvance =
                                              new java.awt.geom.Point2D.Double(
                                                lastGlyphPos.
                                                  getX(
                                                    ),
                                                lastGlyphPos.
                                                  getY(
                                                    ) +
                                                  lastGlyphAdvance);
                                        }
                                    }
                                    else {
                                        textPathAdvance =
                                          new java.awt.geom.Point2D.Double(
                                            0,
                                            0);
                                    }
                                    layoutApplied =
                                      false;
                                    spacingApplied =
                                      false;
                                    pathApplied =
                                      true;
    }
    protected boolean isLatinChar(char c) {
        if (c <
              255 &&
              java.lang.Character.
              isLetterOrDigit(
                c)) {
            return true;
        }
        java.lang.Character.UnicodeBlock block =
          java.lang.Character.UnicodeBlock.
          of(
            c);
        if (block ==
              java.lang.Character.UnicodeBlock.
                BASIC_LATIN ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_1_SUPPLEMENT ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_EXTENDED_ADDITIONAL ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_EXTENDED_A ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_EXTENDED_B ||
              block ==
              java.lang.Character.UnicodeBlock.
                ARABIC ||
              block ==
              java.lang.Character.UnicodeBlock.
                ARABIC_PRESENTATION_FORMS_A ||
              block ==
              java.lang.Character.UnicodeBlock.
                ARABIC_PRESENTATION_FORMS_B) {
            return true;
        }
        return false;
    }
    protected boolean isGlyphOrientationAuto() {
        if (!isVertical(
               ))
            return false;
        aci.
          first(
            );
        java.lang.Integer vOrient =
          (java.lang.Integer)
            aci.
            getAttribute(
              VERTICAL_ORIENTATION);
        if (vOrient !=
              null) {
            return vOrient ==
              ORIENTATION_AUTO;
        }
        return true;
    }
    protected int getGlyphOrientationAngle() {
        int glyphOrientationAngle =
          0;
        aci.
          first(
            );
        java.lang.Float angle;
        if (isVertical(
              )) {
            angle =
              (java.lang.Float)
                aci.
                getAttribute(
                  VERTICAL_ORIENTATION_ANGLE);
        }
        else {
            angle =
              (java.lang.Float)
                aci.
                getAttribute(
                  HORIZONTAL_ORIENTATION_ANGLE);
        }
        if (angle !=
              null) {
            glyphOrientationAngle =
              (int)
                angle.
                floatValue(
                  );
        }
        if (glyphOrientationAngle !=
              0 ||
              glyphOrientationAngle !=
              90 ||
              glyphOrientationAngle !=
              180 ||
              glyphOrientationAngle !=
              270) {
            while (glyphOrientationAngle <
                     0) {
                glyphOrientationAngle +=
                  360;
            }
            while (glyphOrientationAngle >=
                     360) {
                glyphOrientationAngle -=
                  360;
            }
            if (glyphOrientationAngle <=
                  45 ||
                  glyphOrientationAngle >
                  315) {
                glyphOrientationAngle =
                  0;
            }
            else
                if (glyphOrientationAngle >
                      45 &&
                      glyphOrientationAngle <=
                      135) {
                    glyphOrientationAngle =
                      90;
                }
                else
                    if (glyphOrientationAngle >
                          135 &&
                          glyphOrientationAngle <=
                          225) {
                        glyphOrientationAngle =
                          180;
                    }
                    else {
                        glyphOrientationAngle =
                          270;
                    }
        }
        return glyphOrientationAngle;
    }
    public boolean hasCharacterIndex(int index) {
        for (int n =
               0;
             n <
               charMap.
                 length;
             n++) {
            if (index ==
                  charMap[n])
                return true;
        }
        return false;
    }
    public boolean isAltGlyph() { return this.
                                           isAltGlyph;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "87ZecvTjd/N/HhA3tN3spazVMVLJ/48B");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("qzRS9KCXuza7rqnta96bdf+01fYjJ3VcYcfOFzvGiM/4h7JoG4s8b9a36vMv" +
       "2H/+ro0PP7136jNhEtpGQholc7YVv9d5PJszydJtseIXcPdpJnvl/4Y1X5nY" +
       "dPLQH19gTx6Rovdle8sPxJ+996Kf37TwrmVhUt1BpqTQZbAXTjdPpLv1+JjZ" +
       "j/v2WsZBRaglpRkFb/eehWas4b/OYbwIOmfmz+K/nqBkZfGLzYv/Ycd0I7NL" +
       "N9l9daxmZoxUO2d4z3jeVZzLZj0CzhnRlZjig6oQoGBvgD0OxLZks/Z736cv" +
       "zLKB3OUfsKDhDrGv+G34/wH07b+bPGsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1Oy4A6WnAQ/bZopEncBFudJczNbNRXfJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "8X4T4PtzO94/d/fb9VcvyPv1PPlYWHiZ");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("HmxM8cl5iCh0TjH9+FUHFcD53P/xHdOP332mv31B3n/Kk38fFp48nEU7Y8rl" +
       "5LDyt646BgCh4f1/ueP6l5fkeofTTAd/eAHhfLHzg08BJ6SJwfEazYcTaida" +
       "9ffuwg0dDzy4rbvdX53pSSKfuSDvf+TJp29fJ/2Y3Z9dhl0KOvqJkCR/X+GT" +
       "t701ePumW+knP3TtgZd/aPzJ7bsAD99G+yBZeGAZmebJt4+d+H6f6ytLfUP5" +
       "wU36qLvh8X/CwivOHZIBW5XvcrQHn9+W/8uw8MRZ5cPCAUhPlvwbMEI4XTIs" +
       "3LvZnyh3zz4Q4nG5sHDf9svJIveCs4Mi+df73MP44MQabdvXtaVba/vkSYXZ" +
       "0H/8+VriqMrJ12XmQ9LN+50P31EWMbsFFD/8ocHw6z9b+9Ht6zolU8yy/CwP" +
       "kIX7t28O3Zw0f8/Za8892+G57uu94QuP/tSDrz+8z/TRLeBj5T2B7emz343Z" +
       "sdxw8zbL7Gdf/s/f8mMf+t3Ngn3/D2X8tNx4ewAA");
}
