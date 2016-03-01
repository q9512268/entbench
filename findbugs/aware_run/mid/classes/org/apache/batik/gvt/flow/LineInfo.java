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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pzM3AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV8C7TrWHmez73zuHOZmTsMMDNMGB7zAAbDlR+SJXeAIOth" +
       "y5ZsWfI7KRdZb1mWZL0sGaYTWE1glZayyEAgK5nFaoGmZAIJTdK0XWRNWlqg" +
       "AdqkNE1pExLS5lGghbWapClp0y3Z53HPvefcuXMn6VlH27L26/v+/e///7e0" +
       "5ae/Xbg58AtFz7VT3XbDi2oSXrRs5GKYempwsc0ivOQHqkLYUhAMwLVL8oM/" +
       "e+FPvvd+464zhVtmhRdJjuOGUmi6TiCogWvHqsIWLhxepWx1GYSFu1hLiiUo" +
       "Ck0bYs0gfIwtvOBI1bDwMLsPAQIQIAAByiFA+GEpUOkO1YmWRFZDcsJgVfgb" +
       "hT22cIsnZ/DCwqsub8STfGm5a4bPGYAWzmXfR4BUXjnxC6884L7lfAXhDxah" +
       "J3/srXd95mzhwqxwwXTEDI4MQISgk1nh9qW6nKt+gCuKqswKL3RUVRFV35Rs" +
       "c5PjnhXuDkzdkcLIVw+ElF2MPNXP+zyU3O1yxs2P5ND1D+hppmor+99u1mxJ" +
       "B1zvOeS6ZUhn1wHB8yYA5muSrO5XuWlhOkpYeMXxGgccH+6AAqDqrUs1NNyD" +
       "rm5yJHChcPd27GzJ0SEx9E1HB0VvdiPQS1i4/8RGM1l7kryQdPVSWLjveDl+" +
       "mwVK3ZYLIqsSFl5yvFjeEhil+4+N0pHx+Xb3je97u9NyzuSYFVW2M/znQKWX" +
       "H6skqJrqq46sbive/jr2Q9I9n33PmUIBFH7JscLbMv/4Hd99y+tf/swXtmW+" +
       "7yplenNLlcNL8sfmd/7ay4hH62czGOc8NzCzwb+Mea7+/C7nscQDM++egxaz" +
       "zIv7mc8I/2r6Q59Uv3mmcJ4p3CK7drQEevRC2V16pq36TdVRfSlUFaZwm+oo" +
       "RJ7PFG4F56zpqNurPU0L1JAp3GTnl25x8+9ARBpoIhPRreDcdDR3/9yTQiM/" +
       "T7xCoXArOAq3g+NVhe1f/hkWZMhwlyokyZJjOi7E+27GPxtQR5GgUA3AuQJy" +
       "PReaA/1fvKF8EYUCN/KBQkKur0MS0ApD3WZCehxCmu2uoRw3AHMxUzbvr6ab" +
       "JGN713pvDwzEy46bARvMoJZrK6p/SX4yalDf/dSlXz1zMC12cgoLD4K+Lm77" +
       "upj3dRH0dTHr6+J+X4W9vbyLF2d9bscZZC3AfAeW8PZHxb/eftt7HjwLFMxb" +
       "3wREnBWFTjbIxKGFYHI7KAM1LTzz4fU7R0+UzhTOXG5ZM5zg0vmsOp/ZwwO7" +
       "9/DxGXW1di+8+w//5NMfetw9nFuXmerdlL+yZjZlHzwuUd+VVQUYwcPmX/dK" +
       "6Rcuffbxh88UbgJ2ANi+UAIyA2bl5cf7uGzqPrZvBjMuNwPCmusvJTvL2rdd" +
       "50PDd9eHV/KhvjM/fyGQ8QsyXX4RON64U+78M8t9kZelL96qRjZox1jkZvZN" +
       "oveTv/mVP6rm4t63yBeO+DhRDR87YgWyxi7k8/2Fhzow8FUVlPutD/M/+sFv" +
       "v/sHcgUAJR66WocPZykBZj8YQiDmH/7C6j9+/bc/9tUzh0oTAjcYzW1TTg5I" +
       "ZtcL508hCXp79SEeYEVsMMUyrXl46CxdxdRMaW6rmZb++YVHyr/wrffdtdUD" +
       "G1zZV6PXX7uBw+svbRR+6Fff+qcvz5vZkzMvdiizw2Jb0/iiw5Zx35fSDEfy" +
       "zl9/4COfl34SGFlg2AJzo+a26mwug7M585eEhUdOnpM0SARVzzDul37o5NIN" +
       "25UX2RQGcB49JUbyzSUY53jnV6DH7/764if+8Ge2PuO4EzpWWH3Pk3/rLy6+" +
       "78kzRzz1Q1c4y6N1tt46V9A7tmP9F+BvDxz/NzuyMc4ubK313cTOZbzywGd4" +
       "XgLovOo0WHkX9B98+vF/9lOPv3tL4+7LHRUF4rCf+Y3/86WLH/6dL17FKt46" +
       "d11blZwcJZSjfF2eXsxg5aNVyPO+P0teERw1R5eL90j8d0l+/1e/c8foO7/8" +
       "3bzHywPIo7OPk7ytfO7MkldmdO89bntbUmCAcvAz3R+8y37me6DFGWhRBt4j" +
       "6PnA6CeXzdVd6Ztv/dqv/It73vZrZwtn6MJ525UUWsrNXuE2YG/UwAD+IvG+" +
       "/y3b6bY+B5K7cqqFK8hvp+l9+beXnq5edBb/HRrN+/53z56/6xv/6woh5Lb+" +
       "Khp3rP4Mevon7ife/M28/qHRzWq/PLnSEYJY+bBu5ZPLPz7z4C3/8kzh1lnh" +
       "LnkXiI8kO8pM2QwEn8F+dA6C9cvyLw8kt1HTYwdO5WXHVf5It8fN/aGqgfOs" +
       "dHZ+/piFv2nfwj+4M34PHrfwe4X8hMurvCpPH86S1xxRTywsnNFy0ZS2DiFL" +
       "35Il3e0AEicOdutyKN8Hjod2UB46AcrgGlDOZ5FcSzV1Y7v2gfPrWyB/DTgA" +
       "xQUeQD0GdHidQO8Fx8M7oA+fAPSt1wB6ixTIqpP7iOkxOJeuE8594HhkB+eR" +
       "E+Co14Bzq6KeiEe7TjwvBcerd3hefQIe+xp4zhmsKilgIXU1QMvrBPRicLxm" +
       "B+g1JwAKrgVoLgVqplxXAxReJ6C7wfHaHaDXngBocw1AtwH30rRTzwiupuhn" +
       "ze1YHgH59ucA8tEdyEdPAPk3rwHy5rXrbxfLTxxD88PXieYCOIo7NMUT0Lz3" +
       "GmjyaOhqYP72dYJ5JThevwPz+hPAfOBaYHTdDIBXe+Rkr5bHdNsY6KlPPPSV" +
       "J5566HdzJ3zODIDtx339Kqv+I3W+8/TXv/nrdzzwqXzpcFOmv1nX54/fLrny" +
       "bshlNzlyvLcf8M+Wu4X7QTT9X7f0t59hwfrLWYxmwegACIaXcpT7S9+/wt6S" +
       "/SD4tScHwfk8bPpu5OWRcFYhC2T2dovVXIOy5Mf3leOjV1eOM9npa8G00UxH" +
       "sg9cha06+va+Q664H/GSgy7ObOvtY9wuCLLw4SJhu46arS3287Zra9O9eHDr" +
       "DWQmV4D1C687WSO5XDEOg53Pv+u/3T94s/G261hUv+KYwh5v8h9yT3+x+Wr5" +
       "A2cKZw9Cnyvuy11e6bHLA57zvhpGvjO4LOx5YCv/XH5b4WfJI7mITwm+f+6U" +
       "vH+UJZ8CoyVnot6OzCnFfzEpHDM7P/ocLPIbdmbnDSeYnX9yLUfvqGvxBDP4" +
       "T68TTxakXdzhuXgCnmeeBZ5mkxFz8R3D8yvPIRAq7fCUTsDz+WfhVgUwf9Sr" +
       "eq0vXCeil4CjvENUPgHRV64VKfo5nDz/xw6azzou3AkOfde8vrXD6fNqGee+" +
       "qegqJI6atApWLXF2D56TQt9MsqcWIF5s5AX2zfL/v85zYU1Ptrxf3Zf2b55m" +
       "ebPk72/lniUfO1CBf3elyc2+fiJLfupKG5p9/+ltt3ntLPn0Kabh66fk/W6W" +
       "/FaW/PwWySllf+8KE/NvnsPSprLTqMoJCvv71wqVc4XFlfiA+xFAf/Ac5jS8" +
       "AwSfAOjb1wB0Zm5mZ5VjUP77dUK5BxzIDgpyApT/eS3zkt2eFEPJz6Nz9Bii" +
       "P34OC5vaDlHtBETfu5YBzhBRjnI1PH/+7PFki/cCBA5shwe7As/ewc3dPEBh" +
       "QIilq/7d3/jox/70ne/GzmT3K2+Os/sgIEq467BcN8oeHv7I0x984AVP/s57" +
       "8/u5u6b3zlyd29lMzr4bAtujKsCABvnjyCOTG+TTQ5a9NO4J5FXM/N7Z58C7" +
       "vuNdvwrvrM3cMmQnd54AOsu7LUvOX4b0XI4UJ0dXA3rh2QPNjnwd944d0Hdc" +
       "dYAuHAoeRMNS+LVvf/Hv/ac3fudbYHjo/eHJer75TV/60pezk3tONqjHmNzO" +
       "4ZNLRI/jBUoU8/LHFq03a1mPxyjee50UswX+4zuKj58yFrm8H3zW4O8AwDPc" +
       "l0QCZ6ks/4FjQB+6JtAt2709wLRyEb2Y3S/be93J2pD7o2Mw7rVs+eH9G9Yj" +
       "1Q9AsP2wZaP7Qf6RebN9EH1sRmPPGiTQhTsPG2NdR3/svf/l/V/6uw99HahC" +
       "+zJVAIrNf4i6K5dC9fr43J/xEfMIgJWCkMufiKjKAaVjGnITiLSfO6XwJV9t" +
       "wQGD7/+x5TlRxeVk5kSTQSkU63NyTE4r2opo6eUi2myu1Tassuw4YQOWGaYz" +
       "XW8jdCtAK34wlDcwYqvSuLwm6T4dQR2dsog2hjXa7T7SNptrUSRWMe6tUSpi" +
       "iHWxtWD1pohxhtIft7GZpKSUkE4SqF7dFDfcJqpx427UWq1mjuL7EAT+URSC" +
       "oGJRLQeCN1w2Zx437oed/nCKBpwUTGoYa/OcWZFQum+ndZebw9rCQsspWkfb" +
       "k1KKMiV31cCWHCU7q4U4Zuc2UBy/3wS90gFiLlJlIAnNhdjRPE6y6c2g2en4" +
       "ekUcT/0RP1655ipdt6xyO5CpcTpM+4K7SIaJ0+O6XqhgJLPWhRZVVFx4GdfJ" +
       "gSt69HxsjUrRWllj+gLhW/Opomj2zCL7i3ARWkNrQ9LkWB0Sm/FiMGlzi+5E" +
       "qY1Gjjxy7WBcWdXCUFDS/piu6IY3i8sQZKPDYrfbwsubdr80GCuy0Im0se/W" +
       "BI9rD6NicSJB4nAcOMW+7okI6TmBxIXEUPYcWm/q6tLyk6hTamgCOuGkjtZL" +
       "xnRvgIybFoNPo4EIUSUu9UZNdLmp9ZqTlTvz54HTMBeTmTgoG3bkwFaVnQZa" +
       "sZe2mgkcMdCY9GhUaBhEjyTwKddYUIbCCtOxJ0lIt7001gtLcLkijpfpoT1S" +
       "wsiqjvueNCybzQHeENIqzC27/QXULSn9oUXMO7PmzPFmixpGk/KqWFZo0ZuI" +
       "TDPadGpRX8Z7xcaa9mm8Aea8uOZn0UJjVLM9XyjIiF/MmilKCS4uKUN3JnZr" +
       "lj1G2gHFlkyBE9rjktJa4xZVZ/t1rtMabvoIOx2XCGdV8chFa9SRSItKk3ox" +
       "GpSFxqpiyxSAlBIJxNXhgdVty9XUQJJIK3nWqFqteWVpRIlgxrQ7q4jRNm6f" +
       "1XChrnDDruhweImeRptB0pQcpKSVhf6KTFi6bpXUORoi5XoVYuikCkeVYO2X" +
       "VrOqSkajyqyBqS2rKSNKifWXFbJJD5voyoZ7pCPKiDOe1ZUSQpXXXa6EVH0q" +
       "9YyBKm2gGarJkInXaXFYrkqCWA4nXKdrCG4t5Zuu19lMy0O3NqcktjMfdLpS" +
       "4PETBeFWKgW7TWMUq2XOM9F2NFyh6QgZ1qB1aSUuqMmqw0gqLZXsHow1E2YO" +
       "y/WZnjTEhqB6hhqKTIzCjkAh/KrDl3x9ISIrs6ZRxWFJQ+QhgWxq1JgnVKMc" +
       "kta6QkK9shRYdEkJIZEj+tNZGSuXJnjHb3aaJufB6hRqDlcu1OqNYZwqdS0g" +
       "d6VrL4dKNIPbOEPKU0cjJX2to16pO3S6jGbjs7BaC0pqyzGYpRHyRNngLFbG" +
       "/bZj0b0ONsUY1/ARizRLfdPhRnRK9ziuPAh1ftEjfaWSykRrHpqVuDbkSG49" +
       "ZdfyaFrn6Ua/6ZaqQ86yZG1hqmoNqWP1xaCrlymxoWAJibcYq98O1RHQRpIe" +
       "2JWFWAW1+FYDm1prGDcGdH8KKy22bqV1lO31a/EUkwEk3GEmCy2KONnczCGD" +
       "QMdzqFIE8zstNbVKrYcON24wHLi471IiX1IZbchC6z7EioLCVg0DVUrJ1EZU" +
       "ornmhykxnXJx1yV4GMM29ZahNptDT3CpQeQsVx0BeEauJtVNZjUtonPUtLsa" +
       "65gVgvGK3eFSdyZNJ4ywQTzuGuF0Y0hjczC3FnAbLWpyr8lrUNFbQBPOGaF9" +
       "kVIX2KJVI4J1sUcFLLdEl7A0EXh5TjMddIKgQQ9SiyU0rmB+SJZXJXrJT43l" +
       "0OkBkfRtciNUi0UMWk40R4PtcmsyM2wKltfrNjmYOW0SdkKRIhi7gkZMo12b" +
       "EySl+tI8bOO1cDh03ZJPd+Q2X59UUTRVK5BcFcmgzwyrlrEIHdQl61CVrmFW" +
       "OKiWYVlvxW2zbVGtURmxpgPHWS4rUFcqIUKFAU6jJQIURaRdm6BrTG1M2PGw" +
       "iki11OpFukUFRQNpVaZtdY1PveJyIXGDKB7D3bk/oquqLqDUOnZMrG9OuTWy" +
       "MMzqeJauLI4TLGUhoKuWnSJJdxTV6lXXHiZU2EqFVexUhHo5HsypgaRLfF8t" +
       "CiWj3PKK6/IiQVFWaZC9qgaLGFGuQ+u12aLplKl0WxMJH3sCu2BmgjHvs2u7" +
       "3dG6tNmre+rSadFlDGIWg7VQbWhT1IfWnFZs+TGqszi7UCUwBn1pYqyEmm4k" +
       "AW2SNQLuwhjjdf1NpdSGNa3C87zbXHUGddeHVbnOGRDET7wK15xYidqm6AkZ" +
       "rRBRHFhkp9pMkW6CBdUiZdDmqFOsQ1KxrsRFmI7rQndl9cAE75IRwquaSU+C" +
       "DUs6Jr1ZpFZxbQY6qWPWQhquqXhT7ujwwnG7ZK+xIWoVlHKDahpFGoZrvQVc" +
       "4lOviiDeEmWXstaTV60NVl3G3eJKIDutRDA30lDtbSAJBBZou+l2K6spEhQr" +
       "HVxVk7DWYvrqrG8tRyuszQ3MOYLGQdkYjVhos5ggUZUfKU3XCBlL8ti0XxLJ" +
       "dXfRjA1Ncst4kYMlCFoX4QnaXNVoF+50RDyik8TEAnQRj61kxW0gVOERq14d" +
       "jDQe6qNoDNaMSNxKZ0E4oeYws5lpBOo3ELc0iSESTVIVGpsjrtMUiGLPWkLN" +
       "YtxzNsDxYONO22mVzfYmoWSo2YZgONz0aiUkUS2NYSYjP7TIWB8McG9eNddK" +
       "CzLnsyFkCZ2VPmvrlTSO0Bkj6TMySYmgKyYO15/5AbqpQa0xKbYZVF60MCrG" +
       "FiCcKxtlNS7P1A2Ph/EGxypNmp6jTXIAu0WXkhmND4w2HXdTQpiz837MoDUX" +
       "84iw6ZrLKK4PTXHZm617bdL1eLXPxPNFUF8AVQ+7Hj/G2cTszqdTs0YTJtUa" +
       "kp0pabUAA4Wxpl4Z89VqiLUkBakuFKFXW5Cr5rwYlwYQcO3FhbhoT124WYMr" +
       "zYow1xmjuWKMRplpzIOluMJGAo7JLXksslxvQpQr8EbCK0TPwBjO1eeQUxMb" +
       "PZazYX89BcFoxcOGjR6JiabVY5Zea7Xoi6OFT2DselaawzaOqVS9u4qrDZys" +
       "S4TVZ5rusmQMS2iljaOpK0iNrmzXlwGrB3jRtfsu4ANCAzJpElYUBNNAkiR9" +
       "Oe7Es1K5rG1QhFwyIdZvRoSAx0zPgPWRwJWZxPdigp9UJQNqb9pSJzAq0Wwz" +
       "VmY458aGBLAvp+ZAxJpYENi6vabK1c58ozH4Ai9Sup6aDY/0wiaLBLAhpwE6" +
       "aaVMGeq1OH6TpBodj7C0w3ZY2MWa5U088f1hGRK0Krdq+qNN3II6uMwrrQEz" +
       "GfQqUINAklllgEIYpBIpUuwugJqlWsIOPccrKgrCSN6sGq6RaCJgNao19qCZ" +
       "WrPK9KzGjMxgjBDqukmsUkpdGr0Bn5RWy4Gi9XgsqoCQWhBXPR3EDUgE94FH" +
       "9mG/VevWWAZZOoOJOZNpX+ghWtfzakmEs8IM46nJNOj53W6dj2mqhrv8qoaL" +
       "s7LYpRyb6c5wkx57tiGheqzo2NRU6oDrqtPYcIxf5pYzNBgio3LNWngNod+u" +
       "SkWarIwridlKl+vGmE7bxTnvtlaw1E3HIKITFpVpXN10FmGVZ4mqMaXmTT0k" +
       "BaTEw5yDQhurylUn1njtT8W678rYEqLLxaCimUVuTmNWWYhXQcRFBFHVDMx1" +
       "USxmtaZHJGBR6PhRMk18J5EnbHFj43UlbfixSlnKsGxhZCfBE5MaMgkqQg07" +
       "Gs6Ceq22XFf4SVmGDaVTSSeRyOLwDOaUOdD5NjEEThVjCHwNddqU0zawpJL0" +
       "gj4BFlmaSXaYcY9UIrSB4k5JwXo0BhvpoCp78QDpU/BkjdLNYT8ceuXiko9K" +
       "EomuRddmZkBJSpFU5nTSk2o0o9esBgi05bapISMX7tsVFiNK6mQgW7FF9GOp" +
       "RRI+woo9JnJWA1hCsTXXQZlBo4uN+CUzjF2elgbZqq8By4ovYAhEwPpwzCds" +
       "A3cDDVmz9FJu4/oA0xKVTfpBkY8hiE4mw6aZKmSLq8+BdYinm2Y7UThCHFrz" +
       "GJkv1jQMGdgkpufT+mTUki2iJwxJrue6M5oiNSuUFwnEl5t82GDqjTW2Tlfz" +
       "suTibnds9Jme25wuelg6kcqDGlMqragKvplIXtyu6QRTl6h+xltV6arVp5bL" +
       "SdqtRkBzHLwn1ov+nEYmILoNycVQEvCqgbebURlhaZlDisjGREI4JpVptVub" +
       "uYTTbsnltKOWnBG58VbLWdjzJxsYU2W1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
