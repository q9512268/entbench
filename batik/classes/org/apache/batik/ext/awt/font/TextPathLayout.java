package org.apache.batik.ext.awt.font;
public class TextPathLayout {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ADJUST_SPACING = 0;
    public static final int ADJUST_GLYPHS = 1;
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path,
                                                   int align,
                                                   float startOffset,
                                                   float textLength,
                                                   int lengthAdjustMode) {
        java.awt.geom.GeneralPath newPath =
          new java.awt.geom.GeneralPath(
          );
        org.apache.batik.ext.awt.geom.PathLength pl =
          new org.apache.batik.ext.awt.geom.PathLength(
          path);
        float pathLength =
          pl.
          lengthOfPath(
            );
        if (glyphs ==
              null) {
            return newPath;
        }
        float glyphsLength =
          (float)
            glyphs.
            getVisualBounds(
              ).
            getWidth(
              );
        if (path ==
              null ||
              glyphs.
              getNumGlyphs(
                ) ==
              0 ||
              pl.
              lengthOfPath(
                ) ==
              0.0F ||
              glyphsLength ==
              0.0F) {
            return newPath;
        }
        float lengthRatio =
          textLength /
          glyphsLength;
        float currentPosition =
          startOffset;
        if (align ==
              ALIGN_END) {
            currentPosition +=
              pathLength -
                textLength;
        }
        else
            if (align ==
                  ALIGN_MIDDLE) {
                currentPosition +=
                  (pathLength -
                     textLength) /
                    2;
            }
        for (int i =
               0;
             i <
               glyphs.
               getNumGlyphs(
                 );
             i++) {
            java.awt.font.GlyphMetrics gm =
              glyphs.
              getGlyphMetrics(
                i);
            float charAdvance =
              gm.
              getAdvance(
                );
            java.awt.Shape glyph =
              glyphs.
              getGlyphOutline(
                i);
            if (lengthAdjustMode ==
                  ADJUST_GLYPHS) {
                java.awt.geom.AffineTransform scale =
                  java.awt.geom.AffineTransform.
                  getScaleInstance(
                    lengthRatio,
                    1.0F);
                glyph =
                  scale.
                    createTransformedShape(
                      glyph);
                charAdvance *=
                  lengthRatio;
            }
            float glyphWidth =
              (float)
                glyph.
                getBounds2D(
                  ).
                getWidth(
                  );
            float charMidPos =
              currentPosition +
              glyphWidth /
              2.0F;
            java.awt.geom.Point2D charMidPoint =
              pl.
              pointAtLength(
                charMidPos);
            if (charMidPoint !=
                  null) {
                float angle =
                  pl.
                  angleAtLength(
                    charMidPos);
                java.awt.geom.AffineTransform glyphTrans =
                  new java.awt.geom.AffineTransform(
                  );
                glyphTrans.
                  translate(
                    charMidPoint.
                      getX(
                        ),
                    charMidPoint.
                      getY(
                        ));
                glyphTrans.
                  rotate(
                    angle);
                glyphTrans.
                  translate(
                    charAdvance /
                      -2.0F,
                    0.0F);
                glyph =
                  glyphTrans.
                    createTransformedShape(
                      glyph);
                newPath.
                  append(
                    glyph,
                    false);
            }
            if (lengthAdjustMode ==
                  ADJUST_SPACING) {
                currentPosition +=
                  charAdvance *
                    lengthRatio;
            }
            else {
                currentPosition +=
                  charAdvance;
            }
        }
        return newPath;
    }
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path,
                                                   int align) {
        return layoutGlyphVector(
                 glyphs,
                 path,
                 align,
                 0.0F,
                 (float)
                   glyphs.
                   getVisualBounds(
                     ).
                   getWidth(
                     ),
                 ADJUST_SPACING);
    }
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path) {
        return layoutGlyphVector(
                 glyphs,
                 path,
                 ALIGN_START);
    }
    public TextPathLayout() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+T9NDGiJ3x0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eMe//OBPvPr71c3i/wX0uG4lHSgAAA==");
}
