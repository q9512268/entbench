package org.apache.batik.gvt.font;
public class AWTGVTFont implements org.apache.batik.gvt.font.GVTFont {
    protected java.awt.Font awtFont;
    protected float size;
    protected float scale;
    public AWTGVTFont(java.awt.Font font) { super();
                                            this.size = font.getSize2D();
                                            this.awtFont = font.deriveFont(
                                                                  FONT_SIZE);
                                            this.scale = size / awtFont.getSize2D(
                                                                          );
                                            initializeFontCache(awtFont);
    }
    public AWTGVTFont(java.awt.Font font, float scale) { super();
                                                         this.size =
                                                           font.
                                                             getSize2D(
                                                               ) *
                                                             scale;
                                                         this.awtFont =
                                                           font.
                                                             deriveFont(
                                                               FONT_SIZE);
                                                         this.scale =
                                                           size /
                                                             awtFont.
                                                             getSize2D(
                                                               );
                                                         initializeFontCache(
                                                           awtFont);
    }
    public AWTGVTFont(java.util.Map attributes) { super();
                                                  java.lang.Float sz =
                                                    (java.lang.Float)
                                                      attributes.
                                                      get(
                                                        java.awt.font.TextAttribute.
                                                          SIZE);
                                                  if (sz !=
                                                        null) {
                                                      this.
                                                        size =
                                                        sz.
                                                          floatValue(
                                                            );
                                                      attributes.
                                                        put(
                                                          java.awt.font.TextAttribute.
                                                            SIZE,
                                                          new java.lang.Float(
                                                            FONT_SIZE));
                                                      this.
                                                        awtFont =
                                                        new java.awt.Font(
                                                          attributes);
                                                  }
                                                  else {
                                                      this.
                                                        awtFont =
                                                        new java.awt.Font(
                                                          attributes);
                                                      this.
                                                        size =
                                                        awtFont.
                                                          getSize2D(
                                                            );
                                                  }
                                                  this.
                                                    scale =
                                                    size /
                                                      awtFont.
                                                      getSize2D(
                                                        );
                                                  initializeFontCache(
                                                    awtFont);
    }
    public AWTGVTFont(java.lang.String name, int style,
                      int size) { super();
                                  this.awtFont = new java.awt.Font(
                                                   name,
                                                   style,
                                                   (int)
                                                     FONT_SIZE);
                                  this.size = size;
                                  this.scale = size /
                                                 awtFont.
                                                 getSize2D(
                                                   );
                                  initializeFontCache(
                                    awtFont); }
    public boolean canDisplay(char c) { return awtFont.
                                          canDisplay(
                                            c); }
    public int canDisplayUpTo(char[] text, int start,
                              int limit) { return awtFont.
                                             canDisplayUpTo(
                                               text,
                                               start,
                                               limit);
    }
    public int canDisplayUpTo(java.text.CharacterIterator iter,
                              int start,
                              int limit) { return awtFont.
                                             canDisplayUpTo(
                                               iter,
                                               start,
                                               limit);
    }
    public int canDisplayUpTo(java.lang.String str) {
        return awtFont.
          canDisplayUpTo(
            str);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      char[] chars) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          new java.lang.String(
            chars));
        java.awt.font.GlyphVector gv =
          awtFont.
          createGlyphVector(
            frc,
            chars);
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          gv,
          this,
          scale,
          sci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.text.CharacterIterator ci) {
        if (ci instanceof java.text.AttributedCharacterIterator) {
            java.text.AttributedCharacterIterator aci =
              (java.text.AttributedCharacterIterator)
                ci;
            if (org.apache.batik.gvt.text.ArabicTextHandler.
                  containsArabic(
                    aci)) {
                java.lang.String str =
                  org.apache.batik.gvt.text.ArabicTextHandler.
                  createSubstituteString(
                    aci);
                return createGlyphVector(
                         frc,
                         str);
            }
        }
        java.awt.font.GlyphVector gv =
          awtFont.
          createGlyphVector(
            frc,
            ci);
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          gv,
          this,
          scale,
          ci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      int[] glyphCodes,
                                                                      java.text.CharacterIterator ci) {
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          awtFont.
            createGlyphVector(
              frc,
              glyphCodes),
          this,
          scale,
          ci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.lang.String str) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          awtFont.
            createGlyphVector(
              frc,
              str),
          this,
          scale,
          sci);
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size) {
        return new org.apache.batik.gvt.font.AWTGVTFont(
          awtFont,
          size /
            this.
              size);
    }
    public java.lang.String getFamilyName() {
        return awtFont.
          getFamily(
            );
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(char[] chars,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              chars,
              beginIndex,
              limit,
              frc),
          scale);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.text.CharacterIterator ci,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              ci,
              beginIndex,
              limit,
              frc),
          scale);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              str,
              frc),
          scale);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              str,
              beginIndex,
              limit,
              frc),
          scale);
    }
    public float getSize() { return size;
    }
    public float getHKern(int glyphCode1,
                          int glyphCode2) {
        return 0.0F;
    }
    public float getVKern(int glyphCode1,
                          int glyphCode2) {
        return 0.0F;
    }
    public static final float FONT_SIZE =
      48.0F;
    public static org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value getGlyphGeometry(org.apache.batik.gvt.font.AWTGVTFont font,
                                                                                         char c,
                                                                                         java.awt.font.GlyphVector gv,
                                                                                         int glyphIndex,
                                                                                         java.awt.geom.Point2D glyphPos) {
        org.apache.batik.gvt.font.AWTGlyphGeometryCache glyphCache =
          (org.apache.batik.gvt.font.AWTGlyphGeometryCache)
            fontCache.
            get(
              font.
                awtFont);
        org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
          glyphCache.
          get(
            c);
        if (v ==
              null) {
            java.awt.Shape outline =
              gv.
              getGlyphOutline(
                glyphIndex);
            java.awt.font.GlyphMetrics metrics =
              gv.
              getGlyphMetrics(
                glyphIndex);
            java.awt.geom.Rectangle2D gmB =
              metrics.
              getBounds2D(
                );
            if (org.apache.batik.gvt.font.AWTGVTGlyphVector.
                  outlinesPositioned(
                    )) {
                java.awt.geom.AffineTransform tr =
                  java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    -glyphPos.
                      getX(
                        ),
                    -glyphPos.
                      getY(
                        ));
                outline =
                  tr.
                    createTransformedShape(
                      outline);
            }
            v =
              new org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value(
                outline,
                gmB);
            glyphCache.
              put(
                c,
                v);
        }
        return v;
    }
    static java.util.Map fontCache = new java.util.HashMap(
      11);
    static void initializeFontCache(java.awt.Font awtFont) {
        if (!fontCache.
              containsKey(
                awtFont)) {
            fontCache.
              put(
                awtFont,
                new org.apache.batik.gvt.font.AWTGlyphGeometryCache(
                  ));
        }
    }
    static void putAWTGVTFont(org.apache.batik.gvt.font.AWTGVTFont font) {
        fontCache.
          put(
            font.
              awtFont,
            font);
    }
    static org.apache.batik.gvt.font.AWTGVTFont getAWTGVTFont(java.awt.Font awtFont) {
        return (org.apache.batik.gvt.font.AWTGVTFont)
                 fontCache.
                 get(
                   awtFont);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "P+YRjDAnOwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xzBBFIkaQ07SPg6iIx516gvMhunNolFz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "nlRWiddJAAA=");
}
