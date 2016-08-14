package org.apache.batik.gvt.flow;
public class LineInfo {
    org.apache.batik.gvt.flow.FlowRegions fr;
    double lineHeight = -1;
    double ascent = -1;
    double descent = -1;
    double hLeading = -1;
    double baseline;
    int numGlyphs;
    int words = 0;
    int size = 0;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] ggis = null;
    int newSize = 0;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] newGGIS = null;
    int numRanges;
    double[] ranges;
    double[] rangeAdv;
    org.apache.batik.gvt.flow.BlockInfo bi = null;
    boolean paraStart;
    boolean paraEnd;
    protected static final int FULL_WORD = 0;
    protected static final int FULL_ADV = 1;
    public LineInfo(org.apache.batik.gvt.flow.FlowRegions fr, org.apache.batik.gvt.flow.BlockInfo bi,
                    boolean paraStart) { super();
                                         this.fr = fr;
                                         this.bi = bi;
                                         this.lineHeight = bi.getLineHeight(
                                                                );
                                         this.ascent = bi.getAscent(
                                                            );
                                         this.descent = bi.getDescent(
                                                             );
                                         this.hLeading = (lineHeight -
                                                            (ascent +
                                                               descent)) /
                                                           2;
                                         this.baseline = (float) (fr.
                                                                    getCurrentY(
                                                                      ) +
                                                                    hLeading +
                                                                    ascent);
                                         this.paraStart = paraStart;
                                         this.paraEnd = false;
                                         if (lineHeight > 0) { fr.
                                                                 newLineHeight(
                                                                   lineHeight);
                                                               updateRangeInfo(
                                                                 );
                                         } }
    public void setParaEnd(boolean paraEnd) { this.paraEnd = paraEnd;
    }
    public boolean addWord(org.apache.batik.gvt.flow.WordInfo wi) {
        double nlh =
          wi.
          getLineHeight(
            );
        if (nlh <=
              lineHeight)
            return insertWord(
                     wi);
        fr.
          newLineHeight(
            nlh);
        if (!updateRangeInfo(
               )) {
            if (lineHeight >
                  0)
                fr.
                  newLineHeight(
                    lineHeight);
            return false;
        }
        if (!insertWord(
               wi)) {
            if (lineHeight >
                  0)
                setLineHeight(
                  lineHeight);
            return false;
        }
        lineHeight =
          nlh;
        if (wi.
              getAscent(
                ) >
              ascent)
            ascent =
              wi.
                getAscent(
                  );
        if (wi.
              getDescent(
                ) >
              descent)
            descent =
              wi.
                getDescent(
                  );
        hLeading =
          (nlh -
             (ascent +
                descent)) /
            2;
        baseline =
          (float)
            (fr.
               getCurrentY(
                 ) +
               hLeading +
               ascent);
        return true;
    }
    public boolean insertWord(org.apache.batik.gvt.flow.WordInfo wi) {
        mergeGlyphGroups(
          wi);
        if (!assignGlyphGroupRanges(
               newSize,
               newGGIS))
            return false;
        swapGlyphGroupInfo(
          );
        return true;
    }
    static final float MAX_COMPRESS = 0.1F;
    static final float COMRESS_SCALE = 3;
    public boolean assignGlyphGroupRanges(int ggSz, org.apache.batik.gvt.flow.GlyphGroupInfo[] ggis) {
        int i =
          0;
        int r =
          0;
        while (r <
                 numRanges) {
            double range =
              ranges[2 *
                       r +
                       1] -
              ranges[2 *
                       r];
            float adv =
              0;
            float rangeAdvance =
              0;
            while (i <
                     ggSz) {
                org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
                  ggis[i];
                ggi.
                  setRange(
                    r);
                adv =
                  ggi.
                    getAdvance(
                      );
                double delta =
                  range -
                  (rangeAdvance +
                     adv);
                if (delta <
                      0)
                    break;
                i++;
                rangeAdvance +=
                  adv;
            }
            if (i ==
                  ggSz) {
                i--;
                rangeAdvance -=
                  adv;
            }
            org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
              ggis[i];
            float ladv =
              ggi.
              getLastAdvance(
                );
            while (rangeAdvance +
                     ladv >
                     range) {
                i--;
                ladv =
                  0;
                if (i <
                      0)
                    break;
                ggi =
                  ggis[i];
                if (r !=
                      ggi.
                      getRange(
                        ))
                    break;
                rangeAdvance -=
                  ggi.
                    getAdvance(
                      );
                ladv =
                  ggi.
                    getLastAdvance(
                      );
            }
            i++;
            rangeAdv[r] =
              rangeAdvance +
                ladv;
            r++;
            if (i ==
                  ggSz)
                return true;
        }
        return false;
    }
    public boolean setLineHeight(double lh) { fr.newLineHeight(
                                                   lh);
                                              if (updateRangeInfo(
                                                    )) { lineHeight =
                                                           lh;
                                                         return true;
                                              }
                                              if (lineHeight >
                                                    0) fr.
                                                         newLineHeight(
                                                           lineHeight);
                                              return false;
    }
    public double getCurrentY() { return fr.getCurrentY();
    }
    public boolean gotoY(double y) { if (fr.gotoY(y)) return true;
                                     if (lineHeight > 0) updateRangeInfo(
                                                           );
                                     this.baseline = (float)
                                                       (fr.
                                                          getCurrentY(
                                                            ) +
                                                          hLeading +
                                                          ascent);
                                     return false; }
    protected boolean updateRangeInfo() { fr.resetRange();
                                          int nr = fr.getNumRangeOnLine(
                                                        );
                                          if (nr == 0) return false;
                                          numRanges = nr;
                                          if (ranges == null) {
                                              rangeAdv =
                                                (new double[numRanges]);
                                              ranges =
                                                (new double[2 *
                                                              numRanges]);
                                          }
                                          else
                                              if (numRanges >
                                                    rangeAdv.
                                                      length) {
                                                  int sz =
                                                    2 *
                                                    rangeAdv.
                                                      length;
                                                  if (sz <
                                                        numRanges)
                                                      sz =
                                                        numRanges;
                                                  rangeAdv =
                                                    (new double[sz]);
                                                  ranges =
                                                    (new double[2 *
                                                                  sz]);
                                              }
                                          for (int r = 0;
                                               r <
                                                 numRanges;
                                               r++) { double[] rangeBounds =
                                                        fr.
                                                        nextRange(
                                                          );
                                                      double r0 =
                                                        rangeBounds[0];
                                                      if (r ==
                                                            0) {
                                                          double delta =
                                                            bi.
                                                            getLeftMargin(
                                                              );
                                                          if (paraStart) {
                                                              double indent =
                                                                bi.
                                                                getIndent(
                                                                  );
                                                              if (delta <
                                                                    -indent)
                                                                  delta =
                                                                    0;
                                                              else
                                                                  delta +=
                                                                    indent;
                                                          }
                                                          r0 +=
                                                            delta;
                                                      }
                                                      double r1 =
                                                        rangeBounds[1];
                                                      if (r ==
                                                            numRanges -
                                                            1)
                                                          r1 -=
                                                            bi.
                                                              getRightMargin(
                                                                );
                                                      ranges[2 *
                                                               r] =
                                                        r0;
                                                      ranges[2 *
                                                               r +
                                                               1] =
                                                        r1;
                                          }
                                          return true; }
    protected void swapGlyphGroupInfo() { org.apache.batik.gvt.flow.GlyphGroupInfo[] tmp =
                                            ggis;
                                          ggis = newGGIS;
                                          newGGIS =
                                            tmp;
                                          size = newSize;
                                          newSize =
                                            0; }
    protected void mergeGlyphGroups(org.apache.batik.gvt.flow.WordInfo wi) {
        int numGG =
          wi.
          getNumGlyphGroups(
            );
        newSize =
          0;
        if (ggis ==
              null) {
            newSize =
              numGG;
            newGGIS =
              (new org.apache.batik.gvt.flow.GlyphGroupInfo[numGG]);
            for (int i =
                   0;
                 i <
                   numGG;
                 i++)
                newGGIS[i] =
                  wi.
                    getGlyphGroup(
                      i);
        }
        else {
            int s =
              0;
            int i =
              0;
            org.apache.batik.gvt.flow.GlyphGroupInfo nggi =
              wi.
              getGlyphGroup(
                i);
            int nStart =
              nggi.
              getStart(
                );
            org.apache.batik.gvt.flow.GlyphGroupInfo oggi =
              ggis[size -
                     1];
            int oStart =
              oggi.
              getStart(
                );
            newGGIS =
              assureSize(
                newGGIS,
                size +
                  numGG);
            if (nStart <
                  oStart) {
                oggi =
                  ggis[s];
                oStart =
                  oggi.
                    getStart(
                      );
                while (s <
                         size &&
                         i <
                         numGG) {
                    if (nStart <
                          oStart) {
                        newGGIS[newSize++] =
                          nggi;
                        i++;
                        if (i <
                              numGG) {
                            nggi =
                              wi.
                                getGlyphGroup(
                                  i);
                            nStart =
                              nggi.
                                getStart(
                                  );
                        }
                    }
                    else {
                        newGGIS[newSize++] =
                          oggi;
                        s++;
                        if (s <
                              size) {
                            oggi =
                              ggis[s];
                            oStart =
                              oggi.
                                getStart(
                                  );
                        }
                    }
                }
            }
            while (s <
                     size) {
                newGGIS[newSize++] =
                  ggis[s++];
            }
            while (i <
                     numGG) {
                newGGIS[newSize++] =
                  wi.
                    getGlyphGroup(
                      i++);
            }
        }
    }
    public void layout() { if (size == 0) return;
                           assignGlyphGroupRanges(
                             size,
                             ggis);
                           org.apache.batik.gvt.font.GVTGlyphVector gv =
                             ggis[0].
                             getGlyphVector(
                               );
                           int justType = FULL_WORD;
                           double ggAdv = 0;
                           double gAdv = 0;
                           int[] rangeGG = new int[numRanges];
                           int[] rangeG = new int[numRanges];
                           org.apache.batik.gvt.flow.GlyphGroupInfo[] rangeLastGGI =
                             new org.apache.batik.gvt.flow.GlyphGroupInfo[numRanges];
                           org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
                             ggis[0];
                           int r = ggi.getRange(
                                         );
                           rangeGG[r]++;
                           rangeG[r] += ggi.
                                          getGlyphCount(
                                            );
                           for (int i = 1;
                                i <
                                  size;
                                i++) { ggi =
                                         ggis[i];
                                       r =
                                         ggi.
                                           getRange(
                                             );
                                       if (rangeLastGGI[r] ==
                                             null ||
                                             !rangeLastGGI[r].
                                             getHideLast(
                                               ))
                                           rangeGG[r]++;
                                       rangeLastGGI[r] =
                                         ggi;
                                       rangeG[r] +=
                                         ggi.
                                           getGlyphCount(
                                             );
                                       org.apache.batik.gvt.flow.GlyphGroupInfo pggi =
                                         ggis[i -
                                                1];
                                       int pr =
                                         pggi.
                                         getRange(
                                           );
                                       if (r !=
                                             pr)
                                           rangeG[pr] +=
                                             pggi.
                                               getLastGlyphCount(
                                                 ) -
                                               pggi.
                                               getGlyphCount(
                                                 );
                           }
                           rangeG[r] += ggi.
                                          getLastGlyphCount(
                                            ) -
                                          ggi.
                                          getGlyphCount(
                                            );
                           int currRange =
                             -1;
                           double locX = 0;
                           double range =
                             0;
                           double rAdv = 0;
                           r = -1;
                           ggi = null;
                           for (int i = 0;
                                i <
                                  size;
                                i++) { org.apache.batik.gvt.flow.GlyphGroupInfo pggi =
                                         ggi;
                                       int prevRange =
                                         currRange;
                                       ggi =
                                         ggis[i];
                                       currRange =
                                         ggi.
                                           getRange(
                                             );
                                       if (currRange !=
                                             prevRange) {
                                           locX =
                                             ranges[2 *
                                                      currRange];
                                           range =
                                             ranges[2 *
                                                      currRange +
                                                      1] -
                                               locX;
                                           rAdv =
                                             rangeAdv[currRange];
                                           int textAlign =
                                             bi.
                                             getTextAlignment(
                                               );
                                           if (paraEnd &&
                                                 textAlign ==
                                                 org.apache.batik.gvt.flow.BlockInfo.
                                                   ALIGN_FULL)
                                               textAlign =
                                                 org.apache.batik.gvt.flow.BlockInfo.
                                                   ALIGN_START;
                                           switch (textAlign) {
                                               default:
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_FULL:
                                                   {
                                                       double delta =
                                                         range -
                                                         rAdv;
                                                       if (justType ==
                                                             FULL_WORD) {
                                                           int numSp =
                                                             rangeGG[currRange] -
                                                             1;
                                                           if (numSp >=
                                                                 1)
                                                               ggAdv =
                                                                 delta /
                                                                   numSp;
                                                       }
                                                       else {
                                                           int numSp =
                                                             rangeG[currRange] -
                                                             1;
                                                           if (numSp >=
                                                                 1)
                                                               gAdv =
                                                                 delta /
                                                                   numSp;
                                                       }
                                                   }
                                                   break;
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_START:
                                                   break;
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_MIDDLE:
                                                   locX +=
                                                     (range -
                                                        rAdv) /
                                                       2;
                                                   break;
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_END:
                                                   locX +=
                                                     range -
                                                       rAdv;
                                                   break;
                                           }
                                       }
                                       else
                                           if (pggi !=
                                                 null &&
                                                 pggi.
                                                 getHideLast(
                                                   )) {
                                               gv.
                                                 setGlyphVisible(
                                                   pggi.
                                                     getEnd(
                                                       ),
                                                   false);
                                           }
                                       int start =
                                         ggi.
                                         getStart(
                                           );
                                       int end =
                                         ggi.
                                         getEnd(
                                           );
                                       boolean[] hide =
                                         ggi.
                                         getHide(
                                           );
                                       java.awt.geom.Point2D p2d =
                                         gv.
                                         getGlyphPosition(
                                           start);
                                       double deltaX =
                                         p2d.
                                         getX(
                                           );
                                       double advAdj =
                                         0;
                                       for (int g =
                                              start;
                                            g <=
                                              end;
                                            g++) {
                                           java.awt.geom.Point2D np2d =
                                             gv.
                                             getGlyphPosition(
                                               g +
                                                 1);
                                           if (hide[g -
                                                      start]) {
                                               gv.
                                                 setGlyphVisible(
                                                   g,
                                                   false);
                                               advAdj +=
                                                 np2d.
                                                   getX(
                                                     ) -
                                                   p2d.
                                                   getX(
                                                     );
                                           }
                                           else {
                                               gv.
                                                 setGlyphVisible(
                                                   g,
                                                   true);
                                           }
                                           p2d.
                                             setLocation(
                                               p2d.
                                                 getX(
                                                   ) -
                                                 deltaX -
                                                 advAdj +
                                                 locX,
                                               p2d.
                                                 getY(
                                                   ) +
                                                 baseline);
                                           gv.
                                             setGlyphPosition(
                                               g,
                                               p2d);
                                           p2d =
                                             np2d;
                                           advAdj -=
                                             gAdv;
                                       }
                                       if (ggi.
                                             getHideLast(
                                               ))
                                           locX +=
                                             ggi.
                                               getAdvance(
                                                 ) -
                                               advAdj;
                                       else
                                           locX +=
                                             ggi.
                                               getAdvance(
                                                 ) -
                                               advAdj +
                                               ggAdv;
                           } }
    public static org.apache.batik.gvt.flow.GlyphGroupInfo[] assureSize(org.apache.batik.gvt.flow.GlyphGroupInfo[] ggis,
                                                                        int sz) {
        if (ggis ==
              null) {
            if (sz <
                  10)
                sz =
                  10;
            return new org.apache.batik.gvt.flow.GlyphGroupInfo[sz];
        }
        if (sz <=
              ggis.
                length)
            return ggis;
        int nsz =
          ggis.
            length *
          2;
        if (nsz <
              sz)
            nsz =
              sz;
        return new org.apache.batik.gvt.flow.GlyphGroupInfo[nsz];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8CL+im+n/xfm/AGhcDgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "K13KRJ2JSkbXlutotbYxUUtYgT7bjkW+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/we90evy20UAAA==");
}
