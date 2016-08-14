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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ywGwKQ/gzlHJfq3GoWqvAlSoejyjOWzze7hyqIJIy0F1UQhUG7BYy0izAxXk" +
       "uKYi50FaXT5k8lJw/NZVS9SWwnXUBuFo5fgFkZbD75Mh+HVjcYUHv+1Zhqcp" +
       "8PEKF5KuKkAyF+twJ/a4zdfxyiEJIi0HSSIEkm1Y9DHSljfpVPWp3vy86mHy" +
       "G9sBQbekpVW6YZML2ZZqhVnL4Tpl832qcsiCSMtBtjsEsr1YDDLS4kDmnPJx" +
       "AJtdCNiArmjMC9anq2Wy1sF1l83xXZWDFURaDqz9IWDh4a0IZaTVAWuXKWkW" +
       "nphw0GovRKs7lQKNLGzFUUtVy1CtIL632ZWhFkRaDrWJENRuxIKJGFVkuoqV" +
       "dVyiz1plq4ALP6CC/T1kM/dQ5bgEkfrY9mw54T5DZJgD8PkQcI5icRPon1VK" +
       "//jmu22OcozUjulK0gXrSLXA2gLXYzbHj1UOVhBpGbA0DsjtIWDhFlPki6B/" +
       "ll//sOJWF5nj1RSjJ232nqwcmSDSEGT4wzs9cuCTiakjuq5SSSulm338yEHk" +
       "qyGQ4q5lZBKiCMtVTmWEn8H0Avp31XKJy+A6b6NyvnJAg0jL2atHQiD5BhYP" +
       "QpSuWH5ETruIPFQtC74Yrudttp6vHJEgUh/DNXwiNY7yieIk5/87Idj8MxaP" +
       "M9LoTZp5y5MuNE9US1g64frA5u+DyqEJIi0HDa9xX/rgZhlZQooOH3/6T3Gq" +
       "q0dXdbMb7ngi7bzwqVbX7sueyLO5cpZmSkrVJVbazvif8t/XiX7F3n3kJbE2" +
       "vPyDX+hEXvjjXujAsJwaf4e80Im8FlL3BhavYs0XxExC2v48SIyDXuhwqh+G" +
       "9PhLLP7VE2t6A4PIv7nadr5aCR6IdWSJ6FP8r0jbAklDeH4vpO43WLwrEpWC" +
       "TRV8PuDCcaFadhmSkkjM5ilWORxBpMEsR6MhdbXI628ZaQA4Sif+v6smEBtt" +
       "bjZWDkQQaWAMFHmRF5zt5hBI8HxjtCEEkuj0aqlKB/DTZ/PVVzkkQaSloxj+" +
       "G3LNFTzXxA38WP6zu2TPqGRKMqNmP6P8fDuHZlEIbEuxmMvIdIBNaNSGTYU6" +
       "FZ1XxT2kyB6b+T2V4xZEGsLt2pC69VistLePIH3nu4uljEx0VbXyi5XATdrm" +
       "Kl05IEGkIUxfFlJ3BRYfg8zdoCZmWZtoSsqqTJwrvKEgQ4heUq1XR0uBH3ur" +
       "PlL5Ln8gaaC5sYM+DsDmEHD6sLhKOOi81vWAtPCwyX2JFO2ulrCAK4ncarN3" +
       "S+XI3BJAWhoZx+rMzO9w9ZmSMarIwlxE2zkoO0IAG8RiKyO1SVMa90nPtj8F" +
       "RhCjtvi/ccOD5POKvqIVX37KD0w218+d/NSPxblV5+vMGQlSn8qqqveos+e+" +
       "zjBpSuH4zhAHnw3O3j5G5ge+sgCuU/b76ehe0V4CvSrVnp9oLmiZBL78LSEc" +
       "5/+97dLg+9x2jNSJG2+T/Xhex0zjrX12D5a0xT3CKc6G54SPWejFm78fnl1u" +
       "mfIk3o+v0EPx752dc2TZAfv7krOT12y78cKff018/CWr0sGD2Mv0BJkqvkPj" +
       "ndYUfavi7c3pq27L6g+bHpy2wjkX0yom7OrBQlcW8aRCxEDZWOD7MsrqzH8g" +
       "9ZPTG5/4/tG656IksptEYLlm7i4+RZ8zsiZp350o/vJkUDL5J1tdq/924sp1" +
       "qV+9xL9TIOLA66Lg9sPyC/fsff74vNOLo2R6P5miaEma48f7N01oO6g8Zg6R" +
       "RsXanIMpQi+KpBZ81tKEYizhl9AcFxvOxvxT/HSQkY7ik8bFH1w2qPo4NbkD" +
       "xG4aE2S6+0SsjO8gatYwfATuE3spsezFYksOVwPkcTix1TCcz2gaFhhcm/tK" +
       "p00ouJ/lt3h3+P8AwAwp4QtBAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nJTjNKhKETUxRHMZrbDxeBxZNooSG7pl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "23P/HyrKNqCQTQAA");
}
