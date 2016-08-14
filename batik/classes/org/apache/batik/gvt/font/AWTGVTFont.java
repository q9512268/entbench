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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A35lfwoYPQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18e9DraHmfz9k9Zy+wF/YCy3JZYJcUUHJkWbYld0mKLFm2" +
       "JUuWLVu2lSaLrrbusi6W7IQEmEmgpENCChTasH+khDYMAdopbWmblrRDApOE" +
       "mTAZmpJJoEmmIRdSaHNrti19JX+3853vfLub8xHP6LEsvZfn97zP7dX7yh/7" +
       "euVKHFWgMHC3SzdIrhl5cs12G9eSbWjE15hBQ1Ci2NBJV4njCbj2lPaaT973" +
       "58/8xOr+y5WrcuVBxfeDREmswI/HRhy4G0MfVO47vtpxDS9OKvcPbGWjwGli" +
       "ufDAipMnB5UXnKiaVJ4YHLIAAxZgwAJcsgATx6VApXsMP/XIoobiJ/G68kOV" +
       "S4PK1VAr2Esqr76+kVCJFO+gGaFEAFq4s/gtAVBl5TyqvOoI+x7zDYDfB8Hv" +
       "/Yfff/+/uK1yn1y5z/LFgh0NMJGATuTKCz3DU40oJnTd0OXKi3zD0EUjshTX" +
       "2pV8y5UHYmvpK0kaGUdCKi6moRGVfR5L7oVagS1KtSSIjuCZluHqh7+umK6y" +
       "BFhffIx1j5AurgOAd1uAschUNOOwyu2O5etJ5bHTNY4wPsGCAqDqHZ6RrIKj" +
       "rm73FXCh8sB+7FzFX8JiEln+EhS9EqSgl6Ty6E0bLWQdKpqjLI2nksojp8sJ" +
       "+1ug1F2lIIoqSeXh08XKlsAoPXpqlE6Mz9f5N777B/yef7nkWTc0t+D/TlDp" +
       "lacqjQ3TiAxfM/YVX/iGwfuVF//8Oy9XKqDww6cK78v86x/85pu+85Wf+dy+" +
       "zMvOKDNUbUNLntI+rN77ay8nX9+6rWDjzjCIrWLwr0Neqr9wcOfJPASW9+Kj" +
       "Foub1w5vfmb8i4u3ftT4o8uVu/uVq1rgph7QoxdpgRdarhF1Dd+IlMTQ+5W7" +
       "DF8ny/v9yh3gfGD5xv7q0DRjI+lXbnfLS1eD8jcQkQmaKER0Bzi3fDM4PA+V" +
       "ZFWe52GlUrkDHJU3gOO7KvtP+Z1UZvAq8AxY0RTf8gNYiIICfwwbfqIC2a5g" +
       "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" +
       "KGCeOJqwKx2xUogkBMalxlQdWZC4v2WA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
