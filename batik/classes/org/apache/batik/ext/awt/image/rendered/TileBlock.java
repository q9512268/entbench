package org.apache.batik.ext.awt.image.rendered;
public class TileBlock {
    int occX;
    int occY;
    int occW;
    int occH;
    int xOff;
    int yOff;
    int w;
    int h;
    int benefit;
    boolean[] occupied;
    TileBlock(int occX, int occY, int occW, int occH, boolean[] occupied,
              int xOff,
              int yOff,
              int w,
              int h) { super();
                       this.occX = occX;
                       this.occY = occY;
                       this.occW = occW;
                       this.occH = occH;
                       this.xOff = xOff;
                       this.yOff = yOff;
                       this.w = w;
                       this.h = h;
                       this.occupied = occupied;
                       for (int y = 0; y < h; y++) for (int x = 0; x < w;
                                                        x++) if (!occupied[x +
                                                                             xOff +
                                                                             occW *
                                                                             (y +
                                                                                yOff)])
                                                                 benefit++;
    }
    public java.lang.String toString() { java.lang.String ret =
                                           "";
                                         for (int y =
                                                0;
                                              y <
                                                occH;
                                              y++) {
                                             for (int x =
                                                    0;
                                                  x <
                                                    occW +
                                                    1;
                                                  x++) {
                                                 if (x ==
                                                       xOff ||
                                                       x ==
                                                       xOff +
                                                       w) {
                                                     if (y ==
                                                           yOff ||
                                                           y ==
                                                           yOff +
                                                           h -
                                                           1)
                                                         ret +=
                                                           "+";
                                                     else
                                                         if (y >
                                                               yOff &&
                                                               y <
                                                               yOff +
                                                               h -
                                                               1)
                                                             ret +=
                                                               "|";
                                                         else
                                                             ret +=
                                                               " ";
                                                 }
                                                 else
                                                     if (y ==
                                                           yOff &&
                                                           x >
                                                           xOff &&
                                                           x <
                                                           xOff +
                                                           w)
                                                         ret +=
                                                           "-";
                                                     else
                                                         if (y ==
                                                               yOff +
                                                               h -
                                                               1 &&
                                                               x >
                                                               xOff &&
                                                               x <
                                                               xOff +
                                                               w)
                                                             ret +=
                                                               "_";
                                                         else
                                                             ret +=
                                                               " ";
                                                 if (x ==
                                                       occW)
                                                     continue;
                                                 if (occupied[x +
                                                                y *
                                                                occW])
                                                     ret +=
                                                       "*";
                                                 else
                                                     ret +=
                                                       ".";
                                             }
                                             ret +=
                                               "\n";
                                         }
                                         return ret;
    }
    int getXLoc() { return occX + xOff; }
    int getYLoc() { return occY + yOff; }
    int getWidth() { return w; }
    int getHeight() { return h; }
    int getBenefit() { return benefit; }
    int getWork() { return w * h + 1; }
    static int getWork(org.apache.batik.ext.awt.image.rendered.TileBlock[] blocks) {
        int ret =
          0;
        for (int i =
               0;
             i <
               blocks.
                 length;
             i++)
            ret +=
              blocks[i].
                getWork(
                  );
        return ret;
    }
    org.apache.batik.ext.awt.image.rendered.TileBlock[] getBestSplit() {
        if (simplify(
              ))
            return null;
        if (benefit ==
              w *
              h)
            return new org.apache.batik.ext.awt.image.rendered.TileBlock[] { this };
        return splitOneGo(
                 );
    }
    public org.apache.batik.ext.awt.image.rendered.TileBlock[] splitOneGo() {
        boolean[] filled =
          (boolean[])
            occupied.
            clone(
              );
        java.util.List items =
          new java.util.ArrayList(
          );
        for (int y =
               yOff;
             y <
               yOff +
               h;
             y++)
            for (int x =
                   xOff;
                 x <
                   xOff +
                   w;
                 x++) {
                if (!filled[x +
                              y *
                              occW]) {
                    int cw =
                      xOff +
                      w -
                      x;
                    for (int cx =
                           x;
                         cx <
                           x +
                           cw;
                         cx++)
                        if (filled[cx +
                                     y *
                                     occW])
                            cw =
                              cx -
                                x;
                        else
                            filled[cx +
                                     y *
                                     occW] =
                              true;
                    int ch =
                      1;
                    for (int cy =
                           y +
                           1;
                         cy <
                           yOff +
                           h;
                         cy++) {
                        int cx =
                          x;
                        for (;
                             cx <
                               x +
                               cw;
                             cx++)
                            if (filled[cx +
                                         cy *
                                         occW])
                                break;
                        if (cx !=
                              x +
                              cw)
                            break;
                        for (cx =
                               x;
                             cx <
                               x +
                               cw;
                             cx++)
                            filled[cx +
                                     cy *
                                     occW] =
                              true;
                        ch++;
                    }
                    items.
                      add(
                        new org.apache.batik.ext.awt.image.rendered.TileBlock(
                          occX,
                          occY,
                          occW,
                          occH,
                          occupied,
                          x,
                          y,
                          cw,
                          ch));
                    x +=
                      cw -
                        1;
                }
            }
        org.apache.batik.ext.awt.image.rendered.TileBlock[] ret =
          new org.apache.batik.ext.awt.image.rendered.TileBlock[items.
                                                                  size(
                                                                    )];
        items.
          toArray(
            ret);
        return ret;
    }
    public boolean simplify() { boolean[] workOccupied =
                                  occupied;
                                for (int y =
                                       0;
                                     y <
                                       h;
                                     y++) {
                                    int x;
                                    for (x =
                                           0;
                                         x <
                                           w;
                                         x++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (x !=
                                          w)
                                        break;
                                    yOff++;
                                    y--;
                                    h--;
                                }
                                if (h == 0)
                                    return true;
                                for (int y =
                                       h -
                                       1;
                                     y >=
                                       0;
                                     y--) {
                                    int x;
                                    for (x =
                                           0;
                                         x <
                                           w;
                                         x++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (x !=
                                          w)
                                        break;
                                    h--;
                                }
                                for (int x =
                                       0;
                                     x <
                                       w;
                                     x++) {
                                    int y;
                                    for (y =
                                           0;
                                         y <
                                           h;
                                         y++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (y !=
                                          h)
                                        break;
                                    xOff++;
                                    x--;
                                    w--;
                                }
                                for (int x =
                                       w -
                                       1;
                                     x >=
                                       0;
                                     x--) {
                                    int y;
                                    for (y =
                                           0;
                                         y <
                                           h;
                                         y++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (y !=
                                          h)
                                        break;
                                    w--;
                                }
                                return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Hr/TNr9ij8MrL7z0skr/YunC/kNQLILu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jzz/x2xto9nHhnpHUecO2Xg4H/4xcAz32RiefuR6BPQHfcH4++e0/fu8+NcR" +
       "dDnyjp6Bfu1Irr93t6eCxwc8he1g2wPk7mNz3wA26K6w/tM5bd/Kiz+KoEtL" +
       "LZpTXgGlfITqj98KVOE+qvAtRfU/zmn7n3nxnR2qxe2o/vubRXWtIN39pW8p" +
       "qj+/c9teMcv/ASYIUAmmur8v4QjWn71ZWHnl+X1Yz7+VsPaunNP2QF7cB9wA" +
       "gNXTzKURncS1d/HN4sp9xwv7uF54S3E9ck7bo3nxUARdAbhax147HQF7+K1Y" +
       "XS/uA3vxLQX29Dlt+UB7j+9Wl+AFq1OonngTqHJA0CPg+Pl9VD//BlAVXv6r" +
       "Z0I72GKTnzcPZyve2t2AoAv7b8R3vxG0enu2LeNyGAWSEuV7iNWpph5sPfvL" +
       "nO6Y/E7LJX9ttYfuv7ncq54t4wt5tUg+9vOOvBgVFpD3Qm7fIJWf0nnB3L7j" +
       "qVD+btqid34+P8fybp7T9uN50cxbPrzj5BzaD6W733O2+uzlKdjec3e08g+8" +
       "CSsv0qrHwfH5fSv//Fu6dofntOWq2utE0AOFUwoj1rcLt7SHHEHrvglo+Uvx" +
       "4k39K/vQXnmjC/iuadqecE5bvmNnbwqcbpgDo12t651Cx74JdO/KL/4QOL6x" +
       "j+4bbz065Zy2fGPb3odBBhCaDsCnb3OiDx1hu/VGsKUg5B5+zpBv0n70tq+o" +
       "dl/+KF9++erl977M/5vdXt+Dr3Pup6DLemzbx3dfHqtf9AMQ8gq49+92t/kF" +
       "BjuCfuR1fm0BgB5Uc+73VrsRvAh64vwRIui+4vd4ryCCHr1Trwi6B5THqeMI" +
       "evdZ1IASlMcpgRivnaYE8xe/x+k+CozyiC6CLu4qx0l+BowOSPLqx3bu6+Tm" +
       "i90m2XTnNx89bqJF/nfXdOLYTdozJ/YvFl/ZHewKjXff2d1SvvLyYPzR72G/" +
       "uPsgQrGlLMtHuUxBl3bfZhSD5jtLn7rjaAdjXew99/13/vL9zx7c9r1zx/DR" +
       "cjnG25Nnf4ZAOn5UfDiQ/dP3/pMP/v2X/6DYC/L/Afmj+wz+OAAA");
}
