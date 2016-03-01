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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ixQ76bwUPW/G/9b7tSMglc65/9Mt33m9ExxGOylPacqGFG2Pe8eEjMtK9XnU" +
       "5aZCvMILDlXDSGg2aAErrnQLC3PYfPbBTVLI8vPxHzzxwrqyNwTq/Bboy47e" +
       "ufnFH+p/Oh5GEuRzRWbR1qGJnA8ZAhNrVvwzkjirMTquJ6MLQCxTktkiXU4l" +
       "qcacbOBL4oQWNbOwvXvmd+RHTS9vGWl6G4ymh5QrFsRHWHF58lYPzUf7jx0/" +
       "MnbqAR5QinHh2laQnfDn5vNZaTrXTTUWbcKtXm4vBvy7ynN/NSNlfbquUknz" +
       "2zA+tqbzWPb0nMyCb3DdoPjh0e+/+6tTD5QJuwrwDT66Sf/qVPu2vfMJX2Q5" +
       "OUAed+Gj74nuv29y6/zjnN4NxkjdlM5N10AdLu2ljyT/GW4sfTZMynpIjWxv" +
       "JldLagpDXA9MuOXsMGHDmdWevRkSmX9LJtm4wO+vPGz9aYDXCRSzrAVfK5QZ" +
       "IjwC9nCKC3k5C4uLuXbCDLa9qT5VgQhVklA0SeW0c6FapVq/SOTnYdFhuJoN" +
       "C1r+PInZ4QuxwH5K1yhGQqdN5J+KHsnsZaExn43MyLGRDm6e7oTPPXKq6Ohd" +
       "k6pyE08craFAWjm7sDH5GTy37W+TV80fWDeKjHKaz0L8Qz7csf+FpRfKd4X5" +
       "RljoN2cDnU3Ukq3VSpPCjl/LduaNQrdcL/kVyxfjWqFM3hbJzDmxsyd81gLa" +
       "uN2sB7uQUanCBgK6W5jJTMufIy1OGoxnNZt+NvEn83488hbP4tIkvwfxBSZe" +
       "8MrLAtjzotnyJvnZCvecAPXKd7720djVHz19MsdxZOe0HZLR4i6mmejIJ/o3" +
       "VG2SNQD9Lj+04sYa9dBn3HWPkWTws1anCbuydFYGbPcuKXvzmV/Xr3uliISX" +
       "kEpVl+JLJL6ZIBWQxVNrAPaEaeOb14jIOFQORQ2HSnLAczWlxJKawusq+f2q" +
       "7Ox4GlxNdnbc5M/8bSexVdgSFrNzc+tC1IwU67J8fUZX4znpMBbbhFi3FATy" +
       "fwi5A4vbBNMb8jH97jlgeoeH6XX5mO48B0zv8jBty8d01yiZNsLVbDNtLsD0" +
       "3kAbKEQNQqY7E4l8Qu45B0KOYLEXmA4XYPqDc8D0AZtpaCgfx33ngONDDseB" +
       "fBwfPgccH7U5lvXBdi2hsHx8D4yS7yS4Ztp8Zxbg+3ig1RWiZqQclkbKUGgc" +
       "n5f6BH0iQNC0y1DNMOS/UuI7q/Qw9DhZgsFgaqHjZL5H3Ldt90i888E5ztZn" +
       "PgPvrhuXqHQjVT1DjeH3ieyN0WS4lttiLPfPmgvUh4BLVhlAGhBBnw1oew6L" +
       "QzDfTBdn905+V+Pmfp4GPv3PnM5OcqOYbyKQgFTDpdlotNNMRB7bKUQaAPbV" +
       "gLbfY/EyLJB+yq6P6TJfIC7mw2cPs2ULbo0ecyHSAFzHAtrexuJNgfmGXMxH" +
       "zw7mGk4gfunRYy5EGoDreEDbCSz+CgYPmK9T4mIj5AH93tkBXQvXZlvyzaMH" +
       "XYg0ANipgLZPsfg7eCkA3UaV/gHmQ/2Ps4MaHdw2W/Rto0ddiLQwslBRQFsJ" +
       "Vn7OSCWgXugJey7sL87eqt5hy75j9LALkQZAqw5owy1NqFKs6ut0czAbc2jM" +
       "GWNGuKQerjtswe8IwMxL7/6VkVKLvyH3nfJXBgzoQ+scLuDz4px1F54iBhH/" +
       "jAx/Ga8GnfNBfE8XX0njzknkV8dcTO9yVPk0j0L887dKdBDpWqg5v9LCeLsW" +
       "i5vEyQMWvVjgEVKoMfcICR8lLOTcMyFuTRm5QvzMYzDAoC8KaLsECy7pBiFJ" +
       "QN+ovaMucDrB+0wNoL8Ui/qCC2viGS8sDBpkKlx77XWwd/TOpBBpAK55AW3z" +
       "sZjLSBX3oRbrNlTuRUMNLvBvnDFw3Enwbcw+W/p9pwGeJzEuRBoAri2gbRkW" +
       "rRA8LETcqdGlug/2ojOGPR6b0EsdsWU/MnrYhUgDoK0KaFuNRSekR5aC358l" +
       "eJhc4YLuGj3oNOQdmc8X8CxxUs4XVeIrIPnASHX5xJFr/yjeeDhf6lTFSHki" +
       "pareE3HPfalhQmTnM1UljvT4G7DQWka+9j9+XQFwnVvEELpRjLCOkYbgERgp" +
       "4f9eKpmRSYWoGCmC0ts7wch5+XpDTyi9PRXYk/l7An/+7+2ngs26/SDaihtv" +
       "Fx1Ghy54awiHmb3hEy8u0sJTZ3bFjg2QCaezAc9Guinr0JZ/ceecqKfEN3e9" +
       "8sGRZStuPnnlg+ILBFmVNm3CUcbESJn4GIIPiqfyMwqO5oxV2jbrs3GPVcx0" +
       "tua1QmB3HU3xpMUp8P0GWuRk33t6qznzuv6NffOefmlH6ZEwCa0hIYmR8Wty" +
       "X/GkjZRJpq2J5XvRu1oy+ScELZXvrjv8yZuhOn5ETsTLkYYgil5519NHuxKG" +
       "8b0wqWgHUwMTTfP3T4uGtZVU3mhmvTcu7dNTWua14DhcPhJu3PnM2BM6NlOL" +
       "X7Aw0pj7Cj33q55KVR+i5kIcHYcZ63uPkTIMbyuf2YVYzOVbNrC13liHYdjf" +
       "DpTyA0+g4fnGbTz0/hcwOvvvVisAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e+zr1n0ff9f2vdc3tu+1kzieG9uxfd3CUXOpB6kHbtKE" +
       "IiVRIiVRJEVK7BqHT4kUX+JLpDI3iYEtxoqmweZkCZD4n7l7ZG7SDQsyoOjg" +
       "YdjSokWBBl23FVvTFsOWLcuQDFu3NVu7Q+r3vr/7u3ZstwJ4RPJ8zznfz/k+" +
       "D3n46vege8IAKvmenS1sL7qhp9ENy0ZvRJmvhzcGNMrIQahruC2HIQ/uPac+" +
       "9ctX//iHn11euwBdlKB3yq7rRXJkem7I6qFnJ7pGQ1eP7nZs3Qkj6BptyYkM" +
       "x5Fpw7QZRjdp6B3HmkbQdfqABRiwAAMW4IIFGDuiAo3u193YwfMWshuFa+hn" +
       "oT0auuirOXsR9OTJTnw5kJ39bpgCAejhcn4tAFBF4zSA3neIfYf5FsCfK8Ev" +
       "/a2PXvtHd0FXJeiq6XI5OypgIgKDSNB9ju4oehBimqZrEvSgq+sapwembJvb" +
       "gm8Jeig0F64cxYF+OEn5zdjXg2LMo5m7T82xBbEaecEhPMPUbe3g6h7DlhcA" +
       "68NHWHcIu/l9APCKCRgLDFnVD5rcvTJdLYKeON3iEON1ChCAppccPVp6h0Pd" +
       "7crgBvTQTna27C5gLgpMdwFI7/FiMEoEPXrbTvO59mV1JS/05yLokdN0zK4K" +
       "UN1bTETeJILefZqs6AlI6dFTUjomn++NPviZj7uke6HgWdNVO+f/Mmj0+KlG" +
       "rG7oge6q+q7hfe+nPy8//KsvXoAgQPzuU8Q7mm/8lR985Ccff+3XdjQ/dgbN" +
       "WLF0NXpOfUV54Lffiz/buitn47LvhWYu/BPIC/Vn9mtupj6wvIcPe8wrbxxU" +
       "vsb+y/knv6J/9wJ0pQ9dVD07doAePah6jm/aetDTXT2QI13rQ/fqroYX9X3o" +
       "EjinTVff3R0bRqhHfehuu7h10SuuwRQZoIt8ii6Bc9M1vINzX46WxXnqQxB0" +
       "CRzQfeB4Etr9iv8ICuCl5+iwrMqu6XowE3g5/lygribDkR6Ccw3U+h6sAP1f" +
       "faByowGHXhwAhYS9YAHLQCuW+q6ysFN5E8GmA5QBBsLRgIQ0mAcstm1PXd3I" +
       "dc//Cxk1zefi2mZvD4jpvaedhA3si/Rs0O459aW43fnBV5/7jQuHRrM/ixFU" +
       "AUPf2A19oxi6cLBg6BvF0DcOhr5xODS0t1eM+K6chZ1SAJGugHMAbvO+Z7mf" +
       "GXzsxafuAtrob+4G8shJ4dt7b/zInfQLp6kCnYZe+8LmU8InyhegCyfdcM42" +
       "uHUlb87kzvPQSV4/bX5n9Xv109/54699/nnvyBBP+PV9/3Bry9y+nzo9wYGn" +
       "6hrwmEfdv/998tef+9Xnr1+A7gZOAzjKSAaKDXzQ46fHOGHnNw98Zo7lHgDY" +
       "8AJHtvOqA0d3JVoG3uboTiH5B4rzB8Ec5/MM3Q+Oyr4lFP957Tv9vHzXTlNy" +
       "oZ1CUfjkD3H+l//Nb/3nWjHdB+776rGAyOnRzWMuI+/sauEcHjzSAT7QdUD3" +
       "77/A/M3Pfe/TP10oAKB4+qwBr+clDlwFECGY5r/6a+t/++3ff+V3LhwqDZSe" +
       "xHb3OdjAID9+xAbwNDawu1xZrk9dx9NMw5QVW8+V8/9efaby9f/6mWs78dvg" +
       "zoH2/OSdOzi6/5fa0Cd/46P/6/Gimz01j3RHU3VEtnOf7zzqGQsCOcv5SD/1" +
       "rce++E35y8ARA+cXmlu98Gf3FtDvBY2ePSfbCUwHCCHZjxDw8w99e/Wl7/zS" +
       "zvufDieniPUXX/rrf3bjMy9dOBZzn74l7B1vs4u7hfbcv5PIn4HfHjj+ND9y" +
       "SeQ3dn73IXzf+b/v0Pv7fgrgPHkeW8UQ3f/0ted/5e89/+kdjIdOhpwOyKh+" +
       "6Xf/32/e+MIf/PoZHuwukE7kF9WjAoz5zO2nsJDDbkZe/jtP/9YnXn76D0G3" +
       "EnTZDEHahQWLM6L5sTbff/Xb3/3W/Y99tbDyuxU5LFi5cjoNujXLOZG8FHN6" +
       "36GWX86n8CoEXfnUTsl3/xHkvKVRRQlMDYQTTujxYFbyzFd3o3Zx8yCM/fkO" +
       "uDNzOC9qu3M0gi4pnmfr8s7bfyAPIYeB5BzD6OaTf+SLH/mTsa288Ef/u1CY" +
       "W0LIGbZyqr0Ev/qlR/Gf+m7R/siX560fT28Nt0BxjtpWv+L8zwtPXfwXF6BL" +
       "EnRN3V8MCLId5x5SAqoRHqwQwILhRP3JZHaXud08jFXvPW2sx4Y9HUWOjASc" +
       "59SFlu4CR158MN2DCgdKFi2eLMrrefETxXRfiMCyJVZsEzi4ewzTle2ibQ3c" +
       "tnV3sUvECnO76aeHorqwa1tcvzva9345FpAPe66eO9KDul3+YHo3DtcioDI9" +
       "Q+jvv73Qh4VFHc38N1/4L4/yP7X82BtIHJ44JcnTXf794au/3vtx9W9cgO46" +
       "lMMtC5WTjW6enP0rgQ5WVi5/QgaP7WRQzN/ZAtjLT6ndpBd1zx7ODbQfJPPr" +
       "nz6n7mfyQgTyU/PJ38nqHPKPpdApR1oURd2Nc9opefFEeDwJOympY0vk59TP" +
       "/s737xe+/09/cItlnsw5hrJ/80hb35fHkfeczjhJOVwCOuS10V++Zr/2w8KL" +
       "v0NWgSsKxwFIW9MTGco+9T2Xfu+f/fOHP/bbd0EXutAV25O1rlwke9C9IMvS" +
       "wyVImlP/wx/ZOeJN7pmvFVChW8DvtPWR4moXH/GTecsT4Hh6P295+nROtm9/" +
       "q7PFDx2Y292eqs4OpXGtoFPzwt4Nb9yW1R+BmeB1MDM/i5nwbWAmex3MiGcx" +
       "s30bmPnk62CGPIuZT71BZp4Cx/V9Zq7fhplP34mZFKytz2LmxbeBmc/ciZns" +
       "Nsz8wtvAzOfuwMze5ixOPv82cPKlO3GyPIuTL78NnPztO3BySQH5umFGZ/Hz" +
       "yhvk5xFwPLPPzzO34ecrd+DnMjCl2Dd1Lb++eYqhf3BHhope0r09EPeqNxo3" +
       "yvn1Pzx7yLvyUwqkNGHxyDS/og+4eI9lq9cPljSCHoQgRl237MZB/nLtKLfZ" +
       "PXQ8xWjtdTMKQtsDR53Rnru4+XP/4bO/+QtPfxtEtAF0T5JnhiCWHRtxFOeP" +
       "dP/aq5977B0v/cHPFQtnkDEwn+9c+0je66+cBzcvvn4C6qM5VK5I4mk5jIbF" +
       "olfXDtGeStDvBtnEj442evD7JBL2sYPfUJAJCZum7CyuGSFMxAg5ZonVgk6I" +
       "LmU2NnzLJFl6WaIdgtHr1KTFEsxYcvRSqeegZUly1ygjTRYi5nYo06anOMly" +
       "lVmHxcsdrsrYwZadmwJJU7gos7jIrrsCu6iwg+myNzJ1udXwHa2quVqf1bCo" +
       "6telRtBozSIjaRlJotclmNP6pihy7IrhEJvqEGwyNV1+aUjaSrR4fb1ai9HE" +
       "X+ulmVJr1SuoxgVdISF8miOtdjwJMFQK4wW3lP10jWhDgedoTvKHAStOU79n" +
       "ZvWJOOI1ih/1KqQ1aIfaml+ugz4eJxMknTSCgTLsUY7QI8ZCsuSshjHHrE5G" +
       "q6JjzgaBh7kl0l6a/soVrCouzt3ObFJ3XCJZOTO3KfR5MWtF3R7l+6bJOmMq" +
       "FQJuELj98mi2NGzB7Ui+szJm664hdeh+pK344ciatwQD3kruZFgx2kGPQ9fO" +
       "cNNgxdUqmmmVPrLtcg1tHguOy1VXeImd+6bUz9xhxoyGc83vDpa9hewQlVK5" +
       "W/ZKtmgG0todItu241cGbbbfkRwJa5kcJU+jvuEjFk3g49kwDesDTK+Via5P" +
       "1vh6X6s0p7VZLeF5kemi5Jq0qUgelT1rkeLDHsFh6Yha1WrTqK10kC2vT6pe" +
       "ZUouaiNWGAi8IlXX9a1NoqO5udpgoiaHxMCeDpitNlapEebOtwN+qBFDgm72" +
       "RpmLrDl5yTFVPNIaHWrZiTfkoi1SJj53JAJrORmHrLpdszZsZGulP++lOrGs" +
       "YhGeDqpzXJ8LYsgJ7Xbd4wbrAS2SpXIPaTF1T4wHhCl5qh0GQ9waRxw5WFT6" +
       "cEMUVqugZdhVE58thWbfxzuriVtS3M2qPBqsXHTeLFlOOo8aY6cxrdLTFO+T" +
       "YzUzA4rZyP2em3aoqoM7S15ccHjoLKsNtu7D8kqfd8aL5kbTpBbjAjXUk1ix" +
       "lmVmbG7RSdPgg0bFHkstNWiUQrmlrsggoGJq2k+zSUOdCiQigioqjjPRDiZt" +
       "dz0vDbN+lfW3vUkWwXpzHFktwpoLtMSvfHs2LdubObqW+IpP4V7FrlAjZ0lZ" +
       "zZnETRQBoaqtZFAVNmRlWKYcr9HZOHToSlzAUOupX4Y36cSeY6bqrdaI0OA6" +
       "jWijdJbJolV1iE633+vWHVzezFkGbjBme6WVB6Cf0OF8Z1mPhsm0wzfXNhOq" +
       "cthtkV1vxGge2bJaSCZt+zXgEPzyZpNRy7i1AhLoe21qGaBjX+yJXXawsLqd" +
       "CW+n5S7WjBd+Z0ZZ66aDdRQVRrjAdFSu0SMQAfeoOQ13UHxpzAR/HWGVLEl4" +
       "s6IazABrIAmOkSRbpZl+1k4XJNsL++imotVdbBwOJDbdiqtJGnQWfmrF+hIf" +
       "9r0JJRJIe4uNK8aobtcbyqg6Tk1qA+zT6zFce8bBQ1OQo2CppTOylCRMSbBl" +
       "dZxUeJQbmJ2NRpYnCptNytJWCBeTjgpPJdYj3crU04nFeNT1kNmYExbpVh42" +
       "2EpLkhN16zSnE4yksQ65jFmtTodbehC01lvYiEfAd8EwghBVRdNURupPhUEa" +
       "OFNq0JCBwlQ2pZKAIq3ZbJ216u5oK3Y5gkBomOD4ebfaxqvbTbO5zIZZdZyV" +
       "5yE6wRBPigacOnXSZksMF12erA2CeEwKzSTZToaiJ1l9MbDc6iTm4WrXT+aE" +
       "zfbwQLawZpfY2DMtTWoJ3MjaqJHWZ7LJNqZug9T4SkynIrGck4Y2imRkEFh9" +
       "fzlD4Vo0rtRLCF9taZsSMtR5YzUfOYyE+wglYBYPj2vuqJGmDarSCpDpdrRK" +
       "uKpmUlgDX+pKZC6oET/XHCvkWWONdFJqYXfr9tAPvAosNEtqs8SR42rcAd7M" +
       "U+Wti0RDBhnJRoISaikejPw0QIZ4R8Lq5YYgIjVEqZFxNkyGnYrfGwt9ZVvO" +
       "NL21LSflSbtJ1MTQc7Ko4rfnmj6XO6mOzgPJhYH3r9OaBAJNLMFeWlWISDaq" +
       "Ca6Eqyrt0iZvlfnyrIdWSAbtVmtxa0bDdkxlKRn0mBa3nbdFGU4by/USo0qL" +
       "brMfhHC68VwSj0m7XgmiKTFsdarhsL+pcduN3yeC4ZIljBnJxs0GXCHbExam" +
       "GaniW1G1BqNdaazFHl9lQ4K3USzVe36vjIP533ZmvrRgU4Rl6ZoVIyVJZRQN" +
       "iX0qoImgRPeVqNnCYLgkVFbbSkvPxszIBPGsrmymjAj34JbSiLjhwlbrKNwa" +
       "RrWa0+qkaW+c2YysrnvdXpXRm3rHGkZUa+ZOUVnCk2GfJuwZwfUWVRnrBIE7" +
       "ofEaMzcYpc0LdL+ZMCm53aabYJ2NNvwabitehjT02HC7ZMmHx0u014nZLSsq" +
       "bGXdG7hYU8KWo0BINtuVZQZDfh0P6kN6gqf8KlqZsylir1VZVcZtGvFAnFbG" +
       "m2SWOFqJJXmulfREu95DMmeJToJuyJIi2UWb9pzZTo2GlZbhoausMRadmC65" +
       "rNryxDUIF01GkswHM56fiopKRTMHSdpJ1sjcETziRrahrOPpyt1Wt1gpWitb" +
       "kVHKILDiSo3QPAb4cb0El+oRT6CTQbwJNgRfr3MGvBaYuJoYw8GsOkHHU0zX" +
       "Sj2rgbhxUm1ldXhruSNklK4szR6io0oZ0+i4alsZD/dEJDR4aZi5ft8S02Rg" +
       "a7S88IkZ1hrG41k47JGEo4l6wq44Z9aiB5GDbMalhOltW/KcmOEstw0wwaDQ" +
       "idS3NnjLxSm8tkJxJKbjmYITtNxa86iwmCyFlY2VOV0sq/Wu7AtrmBvz7lzr" +
       "LuOBN8IrQYnpuxIyidMNiVKVbNmbrLUROihRZOiGErARF6kNM7rHEk5db3g8" +
       "w8yodX281FZ1P+uUm2ogdzHRchohQaI9Pqs1xBIvNMuGSOiURVLytkw3J9uG" +
       "Ghqlrs8alIbMUNa2vFFVJdxpbbpa1wTOZ3DLhmktlkeTQFNpeCVkqWGJ6+6w" +
       "tlQGW8JJw0xrVha0HI+qYbsRT6ayi7cXVF1ELZBRxEY/q4x7XuqOpKg0Sjpu" +
       "s4YA96gwSNRfJRsjbXOS3hwGNBZZWy9ys0HiAuXWVQwA0hqNalmzBBIYzTDU" +
       "Ummsl0mJZhGz7ji61R/AXk3oVbnRhGjRVqmMhHO5pbXdGikyK5HfhBXAjBJn" +
       "WnfeUxg1pmbJ1hHgWVCLbbPPzVYdX7BLA3pA16V+W5ykwijAGLkj62Olglj9" +
       "cXcyZidVknNpTN2Kdjqg5E0crktGdd0Yp0jPTkeaq6joEG4qnJ4K2oLrBqOt" +
       "WorwSn8zrTcGTWMqzZCt6w/birIEGVMX4zNjY6IYkijt0VBpWmSrYdkL3dPJ" +
       "+myGOmOk2S5vk6bVjrKmVq5kpjQKaUEhRhEdEuXaClOozmQ0Wc8bHcRuTmIE" +
       "bZep8ZzuzBwMmc2ZNaE2iTImRb6ML4y0VnNBFCSIUG8b7Y3BLFSVbExRO5m1" +
       "NbO6DMm0SSAZ1wApHWjSlFJlUaqZYFkgmtJ6otorhZr2FqqLGvU2WTYnI7yc" +
       "VYjRcMzB07jfWMOTTYtYSouwu5DXpCXRKFmjtahVNpvNZgfdRpLLLJgkWMaz" +
       "NTmxBL5CWDpZM/VsVBbBMiKKTJoxGGeRTJdImxaWNtZbttvupuLpmzo92RIG" +
       "39bcVhktCSXGARlyj0lqjDtEx+p6PFcyagJCKuFrtheNRkO23QAMT2SMUYQF" +
       "rRhzGCwQBu1Stq4zdX5g9PGGs6mqTFid0opX1tWM5LDulsSiQE9B7FoYTg9k" +
       "3+R203B6K2RhxC47z9BOzyMCvUMoOLct4Ys541AtHnH6FoqRrVq0as8myUyy" +
       "kwxkGeRsvihjI9Nf0BITGouGjq+w2lQW4AXpTOAqEyJDmdQ2VRFmI6+saSY9" +
       "2YR2m510w4HgNsYcLi5m8WKgZ42Qbjb0dYQuswZqtWiMXk0kbL1BvU1WGa27" +
       "VFiPo7K6xRS1ag174qgXUxM9sKJwozf7m2FKN+C6sBIoOsnImmsMZu3F1puU" +
       "QpWOiS3ip5UuipjtJQlbWAr35GbPNUZto9OczcqutV25K6Gpqfy4lQnMqmwB" +
       "n9FsaJTWJnxxvUCTFo3rdCiaaNLJQCKTCNaiI1De0FD7ONu06TGvDrNuzLMO" +
       "Okm2w/mWwDy8Scl02MGzht82u4PJqOQl8jBWiaBdKm9GHt2cmvAax6uJ2eOa" +
       "IdH2V5SdNhozcaPB/Nhvt32MQlFMrG1DyaJBhljzWCUY2XzMTocjGkQQl+hu" +
       "ah13o6ibkgj7LX/T0wdbEO3aHhaY1YXCrsSAxZp0h1fXWs+OF3DVs8Y9hq0r" +
       "5U6oheIUxKtgvpwuCI8qU3I3HrGcvmJRGa+BqKYPlioyp+OeVfNG44nmqM1Z" +
       "E0/TaYjMBL0f9BkX48gZmg66AZxZOlgcGXWb73LkyvRloEY1kjFkezlxeHdY" +
       "mdpWwiO9BjERV3IJ5Oul2aS7cYWk06F91qLx8WquLDrswkeMlk75DsvNRa+H" +
       "O3g5ChsbdYmWZj7BZ2aLYWfzFWw3MBcuNUpVdxFW6zBHyOYySrpppbfMUETe" +
       "mKSj1JadrBmXwwEv1ZSutahOcFnfYmqrF5tuUB5IsKrr6poyOqOa3mqGPVbi" +
       "ophxXXtR6tPtriOMnBo+VZUON3CRXr/PmGsjG27WY9RLhaqlBGGtxwhqWo5i" +
       "uTJx2jVyWkv94dRvMuWeGLNgqRrV11t3Gyf1kWGMdcOxybrU2eByedmfO2xT" +
       "jLIZ3FtZEjvw19UBOkvYuOJlJU7t0NIsCaykmUnxcuyiHT7k6dV8vjBtFK20" +
       "RmScUr2mUt6sxQU53Qx53mBqPBL3IkmY1pylk/Bq3NBGvAh4Q4ilyiwHce5R" +
       "qu1hfWSP6VkD25R9q4FbtdoaRSmBLZnoqq+Sc1Wq12JmxfeHShYb1bkw344F" +
       "ZRTglZptknPNMgifz7ByaYEYbk/ht2V4qW7GSZIIZohh2Ic+lD/6+eYbeyT1" +
       "YPH07XD/n2U38opvvIGnTruqJ/NifviMsvhdhE7tGTv2jPLYGx0of+f02O22" +
       "9RX7Fl554aWXtfEvVi7sP7ysR9C9ked/wNYT3T7W1TuKc/6QjYfy7h8FB7XP" +
       "BnX6UekR0B/1xeDvnVP37/LiX0XQ5cg7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("enb5jaN5/d07Pc073uEpbAdbGSB3H5v7BrBBd4T1H8+p+05e/GEEXVro0Yz2" +
       "CijVI1R/9FagCvdRhW8pqv9+Tt3/yIvv7VDNb0X1394sqmsF6e6XvqWo/vT2" +
       "dXvFKP8HqCBAJZra/n6CI1h/8mZh5SfP78N6/q2EtXflnLr78uIe4AYALFI3" +
       "F8voJK69i28WV+47XtjH9cJbiuvhc+oeyYsHI+gKwNU+9rroCNhDb4V1vbgP" +
       "7MW3FNhT59TlHe09trMu0QtWp1A9/iZQ5YCgh8Hx8/uofv4NoCq8/NfPhHaw" +
       "NSa/bh2OVrxtuwFBF/bfZO/+Iyj789iYjClhFMhqlO8S1lhdO9hO9hc3+LG5" +
       "PT1n+auovfL+28g95Oz5v5CfFonJfk6SF8NCO/JW8K2bnvLLcV5Mbt3FVCjG" +
       "btiidX49O0crb55Tl6dTe6285qM7Ts6h/XC6+z9n+84elhfP3tYC3v8mLKBI" +
       "uR4Dxxf3LeCLb6ldU+fU5aLa60bQfYXDCiPOtwuXtQcfQeu9CWj5i+7i7fsr" +
       "+9BeeaPGfccUbk88py7fhbPHAocc5sDGrt7zTqHj3gS6d+Y3fwwc39pH9623" +
       "Hp16Tl2+WW3voyA7CE0H4DOynOjDR9ieeyPYUhCODz9fyDdlP3LLF1W7r4DU" +
       "r7589fJ7Xp7+693e3oMvde6loctGbNvHd1QeO7/oByAcFnDv3e1Y8wsMdgT9" +
       "xOv8ugIAPTjNud9b7XrwIujx83uIoHuK/+Otggh65HatIuguUB6njiPoXWdR" +
       "A0pQHqcE03jtNCUYv/g/TvdxoJRHdBF0cXdynORnQe+AJD/9xM59ndxQsdv4" +
       "mu785iPHVbTIDe+YahxbwD19Yk9i8cXdwU7PePfN3XPq114ejD7+g/ov7j6A" +
       "UG15u817uUxDl3bfYhSd5rtFn7xtbwd9XSSf/eEDv3zvMwdLwgd2DB+ZyzHe" +
       "njj7s4OO40fFhwLbf/Kef/zBv/vy7xf7O/4/Sj0+rgo5AAA=");
}
