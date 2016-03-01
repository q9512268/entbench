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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RgqOuLhrs+sqb1v54fTvTl5hb7avZQw7");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("Vr3AMT0wXhLS0Tbme94wbtblXjR++L5zHntmT/nzYRK6jIQUi8y8rPCttaN6" +
       "1iCLL4v5vWS4VzHoy88bqt7c9OwHL4Vm0FMXhL3zdZGMoj/+pcde7hzU9bvC" +
       "ZHI7mZRCl0Bfqdu8PdOlxkeMvHcWlw/YT07xVavT0ZAV/GchVDJcoNNyd/El" +
       "/BZZVvj65sJ/TFCV1rapBn0ui9VM87yeNavr7lwqWTzlCiECShpsrT+2Qdf5" +
       "e6srZlPJ6zp21LK1+KPj/wEHHYP+9WcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Kz0jxCi/iVA+WW6PyOpYqtBLvVlD0nXDCclpewlPOmi5idU1kREkVIHFOJ1F" +
       "8qxTLgs1eFJZpDLR6NILkRcnccx30khGzbI+pWDeUSuz2dgMNk2CEIGViOjc" +
       "XvLCdIRZQ9fMpvPFqgKvllC9GVJTPSEr9MTsGnOPNNClzZFKheInWDUrk022" +
       "5hoYPMT8+YJS5j261Vt5a9pA1LTaFputnBuZ7VVnXhO5rGObGqs36kLGqWpD" +
       "awrqqq019dUMNpZhXAlqsNdhvCrbU1FLri9dQfNmq067JQhjh9CbOpJXZpLF" +
       "G1wLH1SzoNzX0RWLrJNg4NFmEKu1fD4yBpnfn5OjqkfGXsV3JL6c9BFqIAZx" +
       "onPNca+T96icUyC0kXViCVY4BXSZq9Sd3I8rNb6HIXq1gegxtNKRgT3Bg1Sr" +
       "sr5qIAEiR0JtOuyLE5tseGo4YKYxKdDCeoW4m7i2QvRmE5FUBqqR7BouyxFJ" +
       "lfFFRodYp6uTlBnNVV3XRKjXGlEbwc8GfWVAjAlpMx90oQYzQs1xglDdwapn" +
       "y9DSkTm10usvOqNKHxv1eSuqdm0odOp5I56uEGfcaeLoRK0CXXK9GAc9mTfK" +
       "y8qm3q4ver1kGNCDrsoxVYkiNdmSNn5lkof92ETq/QlSgcnRCu6t61g9a1M9" +
       "Y5PwlDONKHId4iQRtAYzv8fyFkTj7ZjleJeeMVl/g0jjgAfWlJby9owg8XG6" +
       "QRtST6xOO2UUjFHP80O+LJhtOxModYF0qMZqNhDKsBrCcI+qYo063DXnax44" +
       "pXq9nVDVRHeDnqMZrVanbrmUtMZrSN8m066MjGVv3hxFxCxCw6aKt42azYZB" +
       "u7wYROJ649tUODFyQSTduWu6a3sl0S29W5kYUShag6plNVSgWW7LgWNkrLdU" +
       "Dl9PnZFExv2VYeTtuWnPNrNVc4YgHiTa40GDpUI0FzJVpAcZLeaeWfeZlcB3" +
       "eLejWOmq6ZT7oWMqqL9Eehm16bhAvRWBqkfMbNhZj0cLY9Xq6fioAdd8cZQz" +
       "CZlxlKx12PUQ06hGJ6wmFWKtt8zVZBBVlj0N0acCglS71YaBzKbETJjOEtAn" +
       "q/Z4lkhIVcmb+giPJ8NJBg1lKYTmE7yHsFUx4YmossirNcjWkVmzulA4fjkt" +
       "DyOD9ggVaVYcBAIXoioBkuEGb4025YSiq9q831p4Wm+GEkNR12JIV71mWsmr" +
       "RtOTWFep2om7ENo+2+QSPHaZStbmFU8M5whCYfSEwZZRl0h641EW4DjrDyeC" +
       "lGOtNiQ2EXgzjOX2jJwY7HAW+fVVtU5sKhnCxDrftwE4G9JWM7pdniE6IkBl" +
       "xFvxg8BrAf9dl6kewThlAjjRDT3t6Fm2GsHQjBx5PrER8ulyEAvqUBpMxg1/" +
       "RM3bbsYM/XYd0m2uny96E4jFLYhqm6kQVparOG0KgpQKQRBIlczETbRddhyK" +
       "6Lphs1vH2dDjMGiqujjrkNKQRwLXReecQHlGE5bJsYcGKp/5zemgz0k4QTfm" +
       "vaot9WilSdXgnmu5yXSpeCafwVDFlOdYaxF2k9wcI1VIpBinCi0mTT5bk5zc" +
       "Mxx83RMsGiaqrek0QoKmrlTqa77W8ZXFYEBFuaB7qw4cqjJXW+q9cM6J4WJh" +
       "+E42dXqdlQ0CDUxwm0BMg0gjG9IsNFlbsCsCr+oMMsFVk7ZmpEcFLss01IRu" +
       "YD2FYUx+s7RTQjYteQzPKc1xB6rvDkZLW3f1FaQsoErTVCTPb7GRqm8kUgwW" +
       "azeX+/O82eaWaSbQ/GziytIyQRS2jnQHgQ/PAiIFIguZoEXM6XWbt4fZhg3I" +
       "dhnTm3Us7UkNKKWQ1aqjJZMmMlgmcq3HrWvteGIlTUMd00JjAnuapc4W81Ay" +
       "ByN9Ol7mrSAqZzQcKMAkW8p0Ls/mc7SPlsd55AasKqymHDeEpFiz6niWJkNB" +
       "CLhuGgtU1DXsdd8SWmV7gzqDtj6pb8ZU0g0IGQ943hipqr6OuVY2bCwRF42c" +
       "jJgws/F4PozGNGRWvMBD1TXWnA4RAsPKAmT2ZYPtz7swP+UFNuRnOL2mqpoN" +
       "lz0FY4WFXm0naH0xgkao29l0+TUyRwhV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "8OAje7ofuQTdm3uQHT0dfC7naz+2TYpSh/efz/nwwSI5SEr3akHcpYsSx1Ob" +
       "w8Mr8CxecVDETAf/YM/zH9x9ntvfxxvZvblooXpRk0c+9ivO3DT52V6x9WYQ" +
       "BKWb+nL4igtk95oieRTEnK5sa7jvrbR8kDrOrfbg8PpV7UG5VDp8w67u4VN3" +
       "UYinXl1wKu7YbRfv7FdoDp84SvZyeeYCuXxVkbweTD9kVZ0mMefvL3JienX4" +
       "9FWl8k4gjf1OF4e37XRxBakcL8EfPntKv95UNPOVJ9p9/3n69fitskQjTb5V" +
       "rSoXiK9YJjt8G5jduFpkaEXd+JTw3n7VwOj1APyP70n8+CWEd2fmdveviy2X" +
       "C1bLDovVssNily3TAiFSvF1GOhLg2btI3/wX3cBKjqVxlQW1rZUCg+rwl/fS" +
       "+OVLSuPaB14sTDykLsgrLO7hMCndD1zO0d7Y33JMbXQXJq2H/2VP7b/cfWpf" +
       "d0HeNxSJsJu0UistKqZwZzjTQ/GqHIHZP/zSnuOX7j5H44K8Yvvtw8UuYuCL" +
       "bfXPI/miew29GEkwYbvnFbu6u8+7SzK+IK9YJTv0ktIrAcliqwpbK95wlBrm" +
       "WUT9KxB9tDj5VkDw7Xuib7/7RC9YNjssls0ON4Co6nfzwLEUKznxLq3wVht8" +
       "lfWzLVHgSO79t7u6u8+7S/SC9bPDYv3s8DuB2srqMo2T/U0P+12LT5K8yqLZ" +
       "1rSCQPfe39+T/P27Q3LvoI88xfXjrU96+53TDz+6TbZUv+8CMRTLaocfSkoP" +
       "qv6JTZuPp+aHf/+qffzuUum+79/V3X1enf6Jqdz2xoDDC9bTDotJwOEPAY0G" +
       "4YezBoNXSxSTi2QvLt5bdqqzr7KgtmX7RsDyF/Zsf+Hua/QFC2qHP10kL4CQ" +
       "U90Gm2eO2Kssmr1qz+/+f7yru/u8a725/d3aFji+X6PYjX1L7ucuIP7zRfIz" +
       "IIiy4jGIk7wiiNrqxjHvF91P/sV4vw3w/dk975+9+/36Sxfk/UqRfCopvcqK" +
       "t6b45DpEmvinmH76qpMK4Hzu//Se6afv");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("PtPfuCDvPxfJf0xKTx6top2x5HJyWvnrV50DgNDw/j/fc/3zS3K9w2Wmw9+7" +
       "gHCxYfnh54ATMuX4eJ/lowW1E73623fhho4HHtzV3X1enelJIl+4IO//LpLP" +
       "377X+TG7P74MuxwM9BMhSfGuwidve5vw7g24yk9+7PoDr/4Y/9ndewCP3lL7" +
       "4Lj0gJ46zsm3i534fl8Qabq1pfzgNn002PL4f5PSa86dkgFbVXwUaA//bFf+" +
       "z5PSE2eVT0qHID1Z8q/ADOF0yaR07/bzRLl7DoAQj8slpft2X04WuRdcHRQp" +
       "vt4XHMUHJ/ZZ272OLd9Z2ydPKsyW/uMv1hM3q5x8VWYxJd2+9/noHWTpdL8J" +
       "4sc/Npx88xcbP7p7VafiyJtNcZUHxqX7d28N3V60eI/ZG8+92tG17hu85cuP" +
       "/tSDbz66z/TRHeBj5T2B7emz34vZdYNk+ybLzc+8+l+948c+9lvbTff+fzFJ" +
       "Ma+QewAA");
}
