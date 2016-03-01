package org.apache.batik.gvt.font;
public class MultiGlyphVector implements org.apache.batik.gvt.font.GVTGlyphVector {
    org.apache.batik.gvt.font.GVTGlyphVector[] gvs;
    int[] nGlyphs;
    int[] off;
    int nGlyph;
    public MultiGlyphVector(java.util.List gvs) { super();
                                                  int nSlots = gvs.size();
                                                  this.gvs = (new org.apache.batik.gvt.font.GVTGlyphVector[nSlots]);
                                                  this.nGlyphs = (new int[nSlots]);
                                                  this.off = (new int[nSlots]);
                                                  java.util.Iterator iter =
                                                    gvs.
                                                    iterator(
                                                      );
                                                  int i = 0;
                                                  while (iter.hasNext()) {
                                                      off[i] =
                                                        nGlyph;
                                                      org.apache.batik.gvt.font.GVTGlyphVector gv =
                                                        (org.apache.batik.gvt.font.GVTGlyphVector)
                                                          iter.
                                                          next(
                                                            );
                                                      this.
                                                        gvs[i] =
                                                        gv;
                                                      nGlyphs[i] =
                                                        gv.
                                                          getNumGlyphs(
                                                            );
                                                      nGlyph +=
                                                        nGlyphs[i];
                                                      i++;
                                                  }
                                                  nGlyphs[i -
                                                            1]++;
    }
    public int getNumGlyphs() { return nGlyph; }
    int getGVIdx(int glyphIdx) { if (glyphIdx > nGlyph) return -1;
                                 if (glyphIdx == nGlyph) return gvs.
                                                                  length -
                                                           1;
                                 for (int i = 0; i < nGlyphs.
                                                       length;
                                      i++) if (glyphIdx -
                                                 off[i] <
                                                 nGlyphs[i])
                                               return i;
                                 return -1; }
    public org.apache.batik.gvt.font.GVTFont getFont() { throw new java.lang.IllegalArgumentException(
                                                           "Can\'t be correctly Implemented");
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        return gvs[0].
          getFontRenderContext(
            );
    }
    public int getGlyphCode(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphCode(
            glyphIndex -
              off[idx]);
    }
    public java.awt.font.GlyphJustificationInfo getGlyphJustificationInfo(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphJustificationInfo(
            glyphIndex -
              off[idx]);
    }
    public java.awt.Shape getGlyphLogicalBounds(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphLogicalBounds(
            glyphIndex -
              off[idx]);
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphMetrics(
            glyphIndex -
              off[idx]);
    }
    public java.awt.Shape getGlyphOutline(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphOutline(
            glyphIndex -
              off[idx]);
    }
    public java.awt.geom.Rectangle2D getGlyphCellBounds(int glyphIndex) {
        return getGlyphLogicalBounds(
                 glyphIndex).
          getBounds2D(
            );
    }
    public java.awt.geom.Point2D getGlyphPosition(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphPosition(
            glyphIndex -
              off[idx]);
    }
    public java.awt.geom.AffineTransform getGlyphTransform(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphTransform(
            glyphIndex -
              off[idx]);
    }
    public java.awt.Shape getGlyphVisualBounds(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphVisualBounds(
            glyphIndex -
              off[idx]);
    }
    public void setGlyphPosition(int glyphIndex,
                                 java.awt.geom.Point2D newPos) {
        int idx =
          getGVIdx(
            glyphIndex);
        gvs[idx].
          setGlyphPosition(
            glyphIndex -
              off[idx],
            newPos);
    }
    public void setGlyphTransform(int glyphIndex,
                                  java.awt.geom.AffineTransform newTX) {
        int idx =
          getGVIdx(
            glyphIndex);
        gvs[idx].
          setGlyphTransform(
            glyphIndex -
              off[idx],
            newTX);
    }
    public void setGlyphVisible(int glyphIndex,
                                boolean visible) {
        int idx =
          getGVIdx(
            glyphIndex);
        gvs[idx].
          setGlyphVisible(
            glyphIndex -
              off[idx],
            visible);
    }
    public boolean isGlyphVisible(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          isGlyphVisible(
            glyphIndex -
              off[idx]);
    }
    public int[] getGlyphCodes(int beginGlyphIndex,
                               int numEntries,
                               int[] codeReturn) {
        int[] ret =
          codeReturn;
        if (ret ==
              null)
            ret =
              (new int[numEntries]);
        int[] tmp =
          null;
        int gvIdx =
          getGVIdx(
            beginGlyphIndex);
        int gi =
          beginGlyphIndex -
          off[gvIdx];
        int i =
          0;
        org.apache.batik.gvt.font.GVTGlyphVector gv;
        while (numEntries !=
                 0) {
            int len =
              numEntries;
            if (gi +
                  len >
                  nGlyphs[gvIdx])
                len =
                  nGlyphs[gvIdx] -
                    gi;
            gv =
              gvs[gvIdx];
            if (i ==
                  0) {
                gv.
                  getGlyphCodes(
                    gi,
                    len,
                    ret);
            }
            else {
                if (tmp ==
                      null ||
                      tmp.
                        length <
                      len)
                    tmp =
                      (new int[len]);
                gv.
                  getGlyphCodes(
                    gi,
                    len,
                    tmp);
                java.lang.System.
                  arraycopy(
                    tmp,
                    0,
                    ret,
                    i,
                    len);
            }
            gi =
              0;
            gvIdx++;
            numEntries -=
              len;
            i +=
              len;
        }
        return ret;
    }
    public float[] getGlyphPositions(int beginGlyphIndex,
                                     int numEntries,
                                     float[] positionReturn) {
        float[] ret =
          positionReturn;
        if (ret ==
              null)
            ret =
              (new float[numEntries *
                           2]);
        float[] tmp =
          null;
        int gvIdx =
          getGVIdx(
            beginGlyphIndex);
        int gi =
          beginGlyphIndex -
          off[gvIdx];
        int i =
          0;
        org.apache.batik.gvt.font.GVTGlyphVector gv;
        while (numEntries !=
                 0) {
            int len =
              numEntries;
            if (gi +
                  len >
                  nGlyphs[gvIdx])
                len =
                  nGlyphs[gvIdx] -
                    gi;
            gv =
              gvs[gvIdx];
            if (i ==
                  0) {
                gv.
                  getGlyphPositions(
                    gi,
                    len,
                    ret);
            }
            else {
                if (tmp ==
                      null ||
                      tmp.
                        length <
                      len *
                      2)
                    tmp =
                      (new float[len *
                                   2]);
                gv.
                  getGlyphPositions(
                    gi,
                    len,
                    tmp);
                java.lang.System.
                  arraycopy(
                    tmp,
                    0,
                    ret,
                    i,
                    len *
                      2);
            }
            gi =
              0;
            gvIdx++;
            numEntries -=
              len;
            i +=
              len *
                2;
        }
        return ret;
    }
    public java.awt.geom.Rectangle2D getLogicalBounds() {
        java.awt.geom.Rectangle2D ret =
          null;
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            java.awt.geom.Rectangle2D b =
              gvs[idx].
              getLogicalBounds(
                );
            if (ret ==
                  null)
                ret =
                  b;
            else
                ret.
                  add(
                    b);
        }
        return ret;
    }
    public java.awt.Shape getOutline() { java.awt.geom.GeneralPath ret =
                                           null;
                                         for (int idx =
                                                0;
                                              idx <
                                                gvs.
                                                  length;
                                              idx++) {
                                             java.awt.Shape s =
                                               gvs[idx].
                                               getOutline(
                                                 );
                                             if (ret ==
                                                   null)
                                                 ret =
                                                   new java.awt.geom.GeneralPath(
                                                     s);
                                             else
                                                 ret.
                                                   append(
                                                     s,
                                                     false);
                                         }
                                         return ret;
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
    public java.awt.geom.Rectangle2D getBounds2D(java.text.AttributedCharacterIterator aci) {
        java.awt.geom.Rectangle2D ret =
          null;
        int begin =
          aci.
          getBeginIndex(
            );
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              gvs[idx];
            int end =
              gv.
              getCharacterCount(
                0,
                gv.
                  getNumGlyphs(
                    )) +
              1;
            java.awt.geom.Rectangle2D b =
              gvs[idx].
              getBounds2D(
                new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                  aci,
                  begin,
                  end));
            if (ret ==
                  null)
                ret =
                  b;
            else
                ret.
                  add(
                    b);
            begin =
              end;
        }
        return ret;
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        java.awt.geom.Rectangle2D ret =
          null;
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            java.awt.geom.Rectangle2D b =
              gvs[idx].
              getGeometricBounds(
                );
            if (ret ==
                  null)
                ret =
                  b;
            else
                ret.
                  add(
                    b);
        }
        return ret;
    }
    public void performDefaultLayout() { for (int idx =
                                                0;
                                              idx <
                                                gvs.
                                                  length;
                                              idx++) {
                                             gvs[idx].
                                               performDefaultLayout(
                                                 );
                                         }
    }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        int idx1 =
          getGVIdx(
            startGlyphIndex);
        int idx2 =
          getGVIdx(
            endGlyphIndex);
        int ret =
          0;
        for (int idx =
               idx1;
             idx <=
               idx2;
             idx++) {
            int gi1 =
              startGlyphIndex -
              off[idx];
            int gi2 =
              endGlyphIndex -
              off[idx];
            if (gi2 >=
                  nGlyphs[idx]) {
                gi2 =
                  nGlyphs[idx] -
                    1;
            }
            ret +=
              gvs[idx].
                getCharacterCount(
                  gi1,
                  gi2);
            startGlyphIndex +=
              gi2 -
                gi1 +
                1;
        }
        return ret;
    }
    public void draw(java.awt.Graphics2D g2d,
                     java.text.AttributedCharacterIterator aci) {
        int begin =
          aci.
          getBeginIndex(
            );
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              gvs[idx];
            int end =
              gv.
              getCharacterCount(
                0,
                gv.
                  getNumGlyphs(
                    )) +
              1;
            gv.
              draw(
                g2d,
                new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                  aci,
                  begin,
                  end));
            begin =
              end;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "73HkdR2tNXoN/uj+P5zQLyLuPgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OdbQVlhOiKTxvM4OJL3RblARAelzM6ad");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "5KJ8ihQ6jvI3gfLLLz3B+dprwPmS/GK+1/c9e5zveY5wvv4CnG/IBRaV7jn2" +
       "fap9TvNfdqz5uuo5l1hVjkRXt9VK54SHxrWGA68Cx4f2PHzoOeLhgvnyYJSL" +
       "blS6+4iHo3fJjlh40VkWGM90o9MM9K7VDbwWHB/dM/DR54iB+QUM5LvjDjiw" +
       "eDhigA9EN8zfATqi4P6zFLQ0DRjE2VwFFfy1Gv+j4Pj4noqPP0dUaBdQke8v" +
       "OxB3AdJuF7UZxkcTwjkPIF0D2OJ9qbzcL+/B/vL1AXtqS2O+S+5gXKAKLkCc" +
       "72M+cID6h1dS//PbvBLPVE4YcK+VgQE4fm3PwK89Nwy8qUD5jgsY+Du5eBtQ" +
       "//C8+ucJyQncp67HgP/WHu5vXX+4VxqxmyXPs1XRLZD+/QtYeE8ungbTXnii" +
       "+aZUvPB6moOfuFZ3/0pwfG7PweeeIwv/8AU4n8nFB0BUZ4bnYb7rBOYHr9WR" +
       "PQCO39/D/P3rA/OGkzs/bzkWbytA/fwFgH8hFz8Tle44vcYpcr7tBO/HrnVY" +
       "HwHH9/Z4v/cc4S1STjbK5/cRSg+WLnvRWr2+e9Zd08lfpfSCFjgrVkFHm+N/" +
       "MA2lVzLrGzXbE6PzFlD8zm8bHvyT/bbqg1+/Mu0X75I/+PRfb5c8aLYonf++" +
       "YJf8wb+4IO23c/GbeUqw68kFeT+b7v7/ygV5/lUuPnkquDk9vx18+sQEPnWt" +
       "AT1Qv4MHd2V3/6/dBE4D+dIFaX+Qi3+zi2HPrGHz6288wfhvr9WtgXj14NIe" +
       "46Xrj/GrF6T9cS7+Q1S6DWC88pLsP14PdK/fo3v99UF3Yj0Hv1qIAssF9+gO" +
       "8nt0B1+7COe13HYrNPVh0OX+Hmf/+uA87QrAguHRYsGQ3y281IqiwJTiSFVw" +
       "QwxEOVIDIlKL1+4LvN+7gIv8/tzB/4hKzwdc7BS60jmn0v/zOqzDD960J+NN" +
       "112lDy+4M3eY35k7PNgvwcHCqriXciXDPbyWW21F6Plq0GF9j1K//ijvuSDt" +
       "3lzcAdZUvhrkUXVH1cTYjnavta7PhJeHd17rHeWHQJf3txQPrtMtxXMril2M" +
       "efjABYgfysXLdnPOsdLjYFyLl0ZP7i0f3netwwrSD35yD/cnrivcI0t+4fHS" +
       "vx+IvmHKexP83wXSxy9g4VIuHgWLRiUQN+fG+dXfD/AUTGznvwGTf9DipZd9" +
       "gWr31ST5l56565aXPDP9d7uXz4++bHTrqHSLFtv26TfzT53f5AeqZhaU3FrI" +
       "O/0CRi0qveyq90EBOm3/dOgQ3eVvAE2/Uv7ipfszOZ8AuM7nBKFd8f90vjeA" +
       "yeAkX1S6aXdyOksrf1kvyN/AOmz7R0N36uWw3acM0p1/fulphSqecdzzbMNx" +
       "XOT091Ry7158K+zo/eGY2X8T5JPPkOMf+Xb9Z3ffc5FtcbvNa7llVLp592mZ" +
       "otL8HeRXXrW2o7puGjz253d+6tZHj54T37nr8Ilyn+rbg1f+eErX8aPicyfb" +
       "f/aSX3n9zz3z5eLtuP8H0lBnzcRNAAA=");
}
