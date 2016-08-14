package org.apache.batik.ext.awt.image.rendered;
public class IndexImage {
    private static class Counter {
        final int val;
        int count = 1;
        Counter(int val) { super();
                           this.val = val; }
        boolean add(int val) { if (this.val != val) return false;
                               count++;
                               return true; }
        int[] getRgb(int[] rgb) { rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        RED] = (val & 16711680) >>
                                                 16;
                                  rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        GRN] = (val & 65280) >>
                                                 8;
                                  rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        BLU] = val &
                                                 255;
                                  return rgb; }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "sry7n3EnLAE6qyqjIbYfii42H/0H+DTCWkgdAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "JtUpevEv3v7PvvfnX/vj6sjl/wH7kQN2FigAAA==");
    }
    private static class Cube {
        static final byte[] RGB_BLACK = new byte[] { 0,
        0,
        0 };
        int[] min = { 0, 0, 0 };
        int[] max = { 255, 255, 255 };
        boolean done = false;
        final org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][]
          colors;
        int count = 0;
        static final int RED = 0;
        static final int GRN = 1;
        static final int BLU = 2;
        Cube(org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colors,
             int count) { super();
                          this.colors = colors;
                          this.count = count;
        }
        public boolean isDone() { return done;
        }
        private boolean contains(int[] val) {
            int vRed =
              val[RED];
            int vGrn =
              val[GRN];
            int vBlu =
              val[BLU];
            return min[RED] <=
              vRed &&
              vRed <=
              max[RED] &&
              (min[GRN] <=
                 vGrn &&
                 vGrn <=
                 max[GRN]) &&
              (min[BLU] <=
                 vBlu &&
                 vBlu <=
                 max[BLU]);
        }
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube split() {
            int dr =
              max[RED] -
              min[RED] +
              1;
            int dg =
              max[GRN] -
              min[GRN] +
              1;
            int db =
              max[BLU] -
              min[BLU] +
              1;
            int c0;
            int c1;
            int splitChannel;
            if (dr >=
                  dg) {
                if (dr >=
                      db) {
                    splitChannel =
                      RED;
                    c0 =
                      GRN;
                    c1 =
                      BLU;
                }
                else {
                    splitChannel =
                      BLU;
                    c0 =
                      RED;
                    c1 =
                      GRN;
                }
            }
            else
                if (dg >=
                      db) {
                    splitChannel =
                      GRN;
                    c0 =
                      RED;
                    c1 =
                      BLU;
                }
                else {
                    splitChannel =
                      BLU;
                    c0 =
                      GRN;
                    c1 =
                      RED;
                }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube ret;
            ret =
              splitChannel(
                splitChannel,
                c0,
                c1);
            if (ret !=
                  null)
                return ret;
            ret =
              splitChannel(
                c0,
                splitChannel,
                c1);
            if (ret !=
                  null)
                return ret;
            ret =
              splitChannel(
                c1,
                splitChannel,
                c0);
            if (ret !=
                  null)
                return ret;
            done =
              true;
            return null;
        }
        private void normalize(int splitChannel,
                               int[] counts) {
            if (count ==
                  0) {
                return;
            }
            int iMin =
              min[splitChannel];
            int iMax =
              max[splitChannel];
            int loBound =
              -1;
            int hiBound =
              -1;
            for (int i =
                   iMin;
                 i <=
                   iMax;
                 i++) {
                if (counts[i] ==
                      0) {
                    continue;
                }
                loBound =
                  i;
                break;
            }
            for (int i =
                   iMax;
                 i >=
                   iMin;
                 i--) {
                if (counts[i] ==
                      0) {
                    continue;
                }
                hiBound =
                  i;
                break;
            }
            boolean flagChangedLo =
              loBound !=
              -1 &&
              iMin !=
              loBound;
            boolean flagChangedHi =
              hiBound !=
              -1 &&
              iMax !=
              hiBound;
            if (flagChangedLo) {
                min[splitChannel] =
                  loBound;
            }
            if (flagChangedHi) {
                max[splitChannel] =
                  hiBound;
            }
        }
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube splitChannel(int splitChannel,
                                                                             int c0,
                                                                             int c1) {
            if (min[splitChannel] ==
                  max[splitChannel]) {
                return null;
            }
            if (count ==
                  0) {
                return null;
            }
            int half =
              count /
              2;
            int[] counts =
              computeCounts(
                splitChannel,
                c0,
                c1);
            int tcount =
              0;
            int lastAdd =
              -1;
            int splitLo =
              min[splitChannel];
            int splitHi =
              max[splitChannel];
            for (int i =
                   min[splitChannel];
                 i <=
                   max[splitChannel];
                 i++) {
                int c =
                  counts[i];
                if (c ==
                      0) {
                    if (tcount ==
                          0 &&
                          i <
                          max[splitChannel])
                        min[splitChannel] =
                          i +
                            1;
                    continue;
                }
                if (tcount +
                      c <
                      half) {
                    lastAdd =
                      i;
                    tcount +=
                      c;
                    continue;
                }
                if (half -
                      tcount <=
                      tcount +
                      c -
                      half) {
                    if (lastAdd ==
                          -1) {
                        if (c ==
                              count) {
                            max[splitChannel] =
                              i;
                            return null;
                        }
                        else {
                            splitLo =
                              i;
                            splitHi =
                              i +
                                1;
                            tcount +=
                              c;
                            break;
                        }
                    }
                    splitLo =
                      lastAdd;
                    splitHi =
                      i;
                }
                else {
                    if (i ==
                          max[splitChannel]) {
                        if (c ==
                              count) {
                            return null;
                        }
                        else {
                            splitLo =
                              lastAdd;
                            splitHi =
                              i;
                            break;
                        }
                    }
                    tcount +=
                      c;
                    splitLo =
                      i;
                    splitHi =
                      i +
                        1;
                }
                break;
            }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube ret =
              new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube(
              colors,
              tcount);
            count =
              count -
                tcount;
            ret.
              min[splitChannel] =
              min[splitChannel];
            ret.
              max[splitChannel] =
              splitLo;
            min[splitChannel] =
              splitHi;
            ret.
              min[c0] =
              min[c0];
            ret.
              max[c0] =
              max[c0];
            ret.
              min[c1] =
              min[c1];
            ret.
              max[c1] =
              max[c1];
            normalize(
              splitChannel,
              counts);
            ret.
              normalize(
                splitChannel,
                counts);
            return ret;
        }
        private int[] computeCounts(int splitChannel,
                                    int c0,
                                    int c1) {
            int splitSh4 =
              (2 -
                 splitChannel) *
              4;
            int c0Sh4 =
              (2 -
                 c0) *
              4;
            int c1Sh4 =
              (2 -
                 c1) *
              4;
            int half =
              count /
              2;
            int[] counts =
              new int[256];
            int tcount =
              0;
            int minR =
              min[0];
            int minG =
              min[1];
            int minB =
              min[2];
            int maxR =
              max[0];
            int maxG =
              max[1];
            int maxB =
              max[2];
            int[] minIdx =
              { minR >>
              4,
            minG >>
              4,
            minB >>
              4 };
            int[] maxIdx =
              { maxR >>
              4,
            maxG >>
              4,
            maxB >>
              4 };
            int[] vals =
              { 0,
            0,
            0 };
            for (int i =
                   minIdx[splitChannel];
                 i <=
                   maxIdx[splitChannel];
                 i++) {
                int idx1 =
                  i <<
                  splitSh4;
                for (int j =
                       minIdx[c0];
                     j <=
                       maxIdx[c0];
                     j++) {
                    int idx2 =
                      idx1 |
                      j <<
                      c0Sh4;
                    for (int k =
                           minIdx[c1];
                         k <=
                           maxIdx[c1];
                         k++) {
                        int idx =
                          idx2 |
                          k <<
                          c1Sh4;
                        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] v =
                          colors[idx];
                        for (int iColor =
                               0;
                             iColor <
                               v.
                                 length;
                             iColor++) {
                            org.apache.batik.ext.awt.image.rendered.IndexImage.Counter c =
                              v[iColor];
                            vals =
                              c.
                                getRgb(
                                  vals);
                            if (contains(
                                  vals)) {
                                counts[vals[splitChannel]] +=
                                  c.
                                    count;
                                tcount +=
                                  c.
                                    count;
                            }
                        }
                    }
                }
            }
            return counts;
        }
        public java.lang.String toString() {
            return "Cube: [" +
            min[RED] +
            '-' +
            max[RED] +
            "] [" +
            min[GRN] +
            '-' +
            max[GRN] +
            "] [" +
            min[BLU] +
            '-' +
            max[BLU] +
            "] n:" +
            count;
        }
        public int averageColor() { if (count ==
                                          0) {
                                        return 0;
                                    }
                                    byte[] rgb =
                                      averageColorRGB(
                                        null);
                                    return rgb[RED] <<
                                      16 &
                                      16711680 |
                                      rgb[GRN] <<
                                      8 &
                                      65280 |
                                      rgb[BLU] &
                                      255;
        }
        public byte[] averageColorRGB(byte[] rgb) {
            if (count ==
                  0)
                return RGB_BLACK;
            float red =
              0;
            float grn =
              0;
            float blu =
              0;
            int minR =
              min[0];
            int minG =
              min[1];
            int minB =
              min[2];
            int maxR =
              max[0];
            int maxG =
              max[1];
            int maxB =
              max[2];
            int[] minIdx =
              { minR >>
              4,
            minG >>
              4,
            minB >>
              4 };
            int[] maxIdx =
              { maxR >>
              4,
            maxG >>
              4,
            maxB >>
              4 };
            int[] vals =
              new int[3];
            for (int i =
                   minIdx[0];
                 i <=
                   maxIdx[0];
                 i++) {
                int idx1 =
                  i <<
                  8;
                for (int j =
                       minIdx[1];
                     j <=
                       maxIdx[1];
                     j++) {
                    int idx2 =
                      idx1 |
                      j <<
                      4;
                    for (int k =
                           minIdx[2];
                         k <=
                           maxIdx[2];
                         k++) {
                        int idx =
                          idx2 |
                          k;
                        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] v =
                          colors[idx];
                        for (int iColor =
                               0;
                             iColor <
                               v.
                                 length;
                             iColor++) {
                            org.apache.batik.ext.awt.image.rendered.IndexImage.Counter c =
                              v[iColor];
                            vals =
                              c.
                                getRgb(
                                  vals);
                            if (contains(
                                  vals)) {
                                float weight =
                                  c.
                                    count /
                                  (float)
                                    count;
                                red +=
                                  vals[0] *
                                    weight;
                                grn +=
                                  vals[1] *
                                    weight;
                                blu +=
                                  vals[2] *
                                    weight;
                            }
                        }
                    }
                }
            }
            byte[] result =
              rgb ==
              null
              ? (new byte[3])
              : rgb;
            result[RED] =
              (byte)
                (red +
                   0.5F);
            result[GRN] =
              (byte)
                (grn +
                   0.5F);
            result[BLU] =
              (byte)
                (blu +
                   0.5F);
            return result;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FN9s8IhjZAuJwoYP80d8OvJ/Zva+A14uAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "otor4QxpdyXTGy8RqQpvlkF55Qv1aCss");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("ybHXmDFEtvbZWlCuMuEs67lbrOTN3ZYR1O26v0pVo5zyKjC28rTUwTsbQXdg" +
           "gdd0wxWjamNTmra9rStsKM/vV1lcs+crw3RadZVIZ6tMoXtefzkYN1qu2Syz" +
           "6oazqgpPtvF6daa21Ua6rI5qJa3MxlVdJJdqv+7AWbU1m7ebg3a7DaM0Ypvm" +
           "1khH/qpZFofpaEFom+pg684ZL0RoRTNZHAyObF11WDWF4Sj1JEMfx265CTcn" +
           "jWwjbaKhwfvl+qA8sGU2RNXqeLRB3Zo7cu1+qIIUcoRJpSmxVSoKMgbhphFa" +
           "HqWJ5WF7o24xdhlGCQzCQZQ0ZyhTr/IzIe0oHWmcruVaiR04jNXNFBd1N541" +
           "GEY9RKYxG2s4vuUuNqxTlWpCyYTrPpukDXipCHFzttlWq6PUmazriY46aHPa" +
           "5jumE7ctkPWXmA4MXHo8klbNmq8F5CajTG1pjtuUrQ3LUWOY1Yn1sGaoCYUk" +
           "6lx2dLiP9+yJO583k7lXdyerjr/gxWhJj3VxRLmkw/rNgdUv+ViJlBbGAG3X" +
           "FOAlNsRmbA21AV2heW/emyz7DNai+GaEdZfWvJUwa18SsLKG9VMGnqdyqYVU" +
           "k1ar9d78Mdtf3NzjvzcVjzOPdyRbTvGs7o9u4glfdsP313cGoZnKcbHbwN3v" +
           "hyue9t8PndnheuLR8Im36lD+3v/hG21CLvatvPjM8y9o/S8jFw5fIXRj6I7D" +
           "veH7fu7evRg75uHBvO/8Lc9zhzw8d/bx9F4Cr3c7xg9vXHdQdPE3gFMzIg73" +
           "Y3xlL+4fvNoD1ZPdnUGWbx3O9wFAnztE9rmbRfY/r4vsYE/wbAHhDefAy/cd" +
           "HdwRQ3cdbi6LTgM8uPMWAL7xyHxePAT44k0AhF5NawcPnlP3try4P4ZujwLH" +
           "jE/PkYMHbgFTQZa3+84hpu/8aJR24oUxvdfc4+dAfCIvHomhu71iC6+5ve4r" +
           "zNtS39T20B+9VXW+DaC4smu7O9+SOi/uPR69Lwp4lXOgV/PiJ2Po3kK7+FL2" +
           "PN05o+Srt4D0rfnNxwHCrxwi/cqPRsnnwH3fOXA/kBfNON+k6QZJrBc7UwvK" +
           "Z/d4f+pW8T4CWP+zQ7x/drN4X9XHHjDn1LF5QQInFPv7N3F/tMdG3QK24iuN" +
           "RwGbrxxie+VHj+2cbRsHs7wYAFsFK6tQNvK93X6xgZfe4xNvVXdPANdxsGu7" +
           "O986vhNRxC+AKOeA1PLiZ2Lo0kmQIt0uWu9xfuhmcGbAeeXfgBy9rq3c/B5u" +
           "kJE8dM3Ha7sPrtSvvnDprgdfGP+H3e70o4+i7mahuxaJ45zctnzi+o4g1Bdm" +
           "Ia+7d1sei+1jB24M/fhrZA9Y+dFljuzA2fUQxNAj5/cAgllxPtkqiqGHbtQq" +
           "hi6C8iR1GkNvvh41oATlScpNDF0+SwnGL84n6T4aQ/fs6UCStLs4SfJx0Dsg" +
           "yS8/ERzp8sSr993u8uzgdCp5ZDLQ/a9mMieyz8dPbWotPm482h+c7D5vfFr9" +
           "2gsM/5FX6l/efX+iOvJ2m/dyFwvdufsUpug032P8zhv2dtTXHZ0nf3Dfr939" +
           "xFE+e9+O4f18O8Hbo9f/6oN0g7j4TmP7Lx/8Z+/5Ry/8cbFN5f8BcdtUXXU6" +
           "AAA=");
    }
    static byte[][] computeRGB(int nCubes,
                               org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[] cubes) {
        byte[] r =
          new byte[nCubes];
        byte[] g =
          new byte[nCubes];
        byte[] b =
          new byte[nCubes];
        byte[] rgb =
          new byte[3];
        for (int i =
               0;
             i <
               nCubes;
             i++) {
            rgb =
              cubes[i].
                averageColorRGB(
                  rgb);
            r[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    RED];
            g[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    GRN];
            b[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    BLU];
        }
        byte[][] result =
          new byte[3][];
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 RED] =
          r;
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 GRN] =
          g;
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 BLU] =
          b;
        return result;
    }
    static void logRGB(byte[] r, byte[] g,
                       byte[] b) { java.lang.StringBuffer buff =
                                     new java.lang.StringBuffer(
                                     100);
                                   int nColors =
                                     r.
                                       length;
                                   for (int i =
                                          0;
                                        i <
                                          nColors;
                                        i++) {
                                       java.lang.String rgbStr =
                                         "(" +
                                       (r[i] +
                                          128) +
                                       ',' +
                                       (g[i] +
                                          128) +
                                       ',' +
                                       (b[i] +
                                          128) +
                                       "),";
                                       buff.
                                         append(
                                           rgbStr);
                                   }
                                   java.lang.System.
                                     out.
                                     println(
                                       "RGB:" +
                                       nColors +
                                       buff);
    }
    static java.util.List[] createColorList(java.awt.image.BufferedImage bi) {
        int w =
          bi.
          getWidth(
            );
        int h =
          bi.
          getHeight(
            );
        java.util.List[] colors =
          new java.util.ArrayList[1 <<
                                    12];
        for (int i_w =
               0;
             i_w <
               w;
             i_w++) {
            for (int i_h =
                   0;
                 i_h <
                   h;
                 i_h++) {
                int rgb =
                  bi.
                  getRGB(
                    i_w,
                    i_h) &
                  16777215;
                int idx =
                  (rgb &
                     15728640) >>>
                  12 |
                  (rgb &
                     61440) >>>
                  8 |
                  (rgb &
                     240) >>>
                  4;
                java.util.List v =
                  colors[idx];
                if (v ==
                      null) {
                    v =
                      new java.util.ArrayList(
                        );
                    v.
                      add(
                        new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter(
                          rgb));
                    colors[idx] =
                      v;
                }
                else {
                    java.util.Iterator i =
                      v.
                      iterator(
                        );
                    while (true) {
                        if (i.
                              hasNext(
                                )) {
                            if (((org.apache.batik.ext.awt.image.rendered.IndexImage.Counter)
                                   i.
                                   next(
                                     )).
                                  add(
                                    rgb))
                                break;
                        }
                        else {
                            v.
                              add(
                                new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter(
                                  rgb));
                            break;
                        }
                    }
                }
            }
        }
        return colors;
    }
    static org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] convertColorList(java.util.List[] colors) {
        final org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] EMPTY_COUNTER =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[0];
        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colorTbl =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[1 <<
                                                                           12][];
        for (int i =
               0;
             i <
               colors.
                 length;
             i++) {
            java.util.List cl =
              colors[i];
            if (cl ==
                  null) {
                colorTbl[i] =
                  EMPTY_COUNTER;
                continue;
            }
            int nSlots =
              cl.
              size(
                );
            colorTbl[i] =
              (org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[])
                cl.
                toArray(
                  new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[nSlots]);
            colors[i] =
              null;
        }
        return colorTbl;
    }
    public static java.awt.image.BufferedImage getIndexedImage(java.awt.image.BufferedImage bi,
                                                               int nColors) {
        int w =
          bi.
          getWidth(
            );
        int h =
          bi.
          getHeight(
            );
        java.util.List[] colors =
          createColorList(
            bi);
        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colorTbl =
          convertColorList(
            colors);
        colors =
          null;
        int nCubes =
          1;
        int fCube =
          0;
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[] cubes =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[nColors];
        cubes[0] =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube(
            colorTbl,
            w *
              h);
        while (nCubes <
                 nColors) {
            while (cubes[fCube].
                     isDone(
                       )) {
                fCube++;
                if (fCube ==
                      nCubes)
                    break;
            }
            if (fCube ==
                  nCubes) {
                break;
            }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube c =
              cubes[fCube];
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube nc =
              c.
              split(
                );
            if (nc !=
                  null) {
                if (nc.
                      count >
                      c.
                        count) {
                    org.apache.batik.ext.awt.image.rendered.IndexImage.Cube tmp =
                      c;
                    c =
                      nc;
                    nc =
                      tmp;
                }
                int j =
                  fCube;
                int cnt =
                  c.
                    count;
                for (int i =
                       fCube +
                       1;
                     i <
                       nCubes;
                     i++) {
                    if (cubes[i].
                          count <
                          cnt)
                        break;
                    cubes[j++] =
                      cubes[i];
                }
                cubes[j++] =
                  c;
                cnt =
                  nc.
                    count;
                while (j <
                         nCubes) {
                    if (cubes[j].
                          count <
                          cnt)
                        break;
                    j++;
                }
                for (int i =
                       nCubes;
                     i >
                       j;
                     i--)
                    cubes[i] =
                      cubes[i -
                              1];
                cubes[j++] =
                  nc;
                nCubes++;
            }
        }
        byte[][] rgbTbl =
          computeRGB(
            nCubes,
            cubes);
        java.awt.image.IndexColorModel icm =
          new java.awt.image.IndexColorModel(
          8,
          nCubes,
          rgbTbl[0],
          rgbTbl[1],
          rgbTbl[2]);
        java.awt.image.BufferedImage indexed =
          new java.awt.image.BufferedImage(
          w,
          h,
          java.awt.image.BufferedImage.
            TYPE_BYTE_INDEXED,
          icm);
        java.awt.Graphics2D g2d =
          indexed.
          createGraphics(
            );
        g2d.
          setRenderingHint(
            java.awt.RenderingHints.
              KEY_DITHERING,
            java.awt.RenderingHints.
              VALUE_DITHER_ENABLE);
        g2d.
          drawImage(
            bi,
            0,
            0,
            null);
        g2d.
          dispose(
            );
        int bits;
        for (bits =
               1;
             bits <=
               8;
             bits++) {
            if (1 <<
                  bits >=
                  nCubes)
                break;
        }
        if (bits >
              4) {
            return indexed;
        }
        if (bits ==
              3)
            bits =
              4;
        java.awt.image.ColorModel cm =
          new java.awt.image.IndexColorModel(
          bits,
          nCubes,
          rgbTbl[0],
          rgbTbl[1],
          rgbTbl[2]);
        java.awt.image.SampleModel sm;
        sm =
          new java.awt.image.MultiPixelPackedSampleModel(
            java.awt.image.DataBuffer.
              TYPE_BYTE,
            w,
            h,
            bits);
        java.awt.image.WritableRaster ras =
          java.awt.image.Raster.
          createWritableRaster(
            sm,
            new java.awt.Point(
              0,
              0));
        bi =
          indexed;
        indexed =
          new java.awt.image.BufferedImage(
            cm,
            ras,
            bi.
              isAlphaPremultiplied(
                ),
            null);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            bi,
            indexed);
        return indexed;
    }
    public IndexImage() { super(); }
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
       "/n++oO1zRfHZovjne0kuoP18firoP/ka");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/L68ZPM2oOUvHPrKL3xX/b5UpCT4/Qu0+YOi+GJSXhnY6FFyM8e+r+jxRvCN" +
       "9sLuf884dtmhKL507D/f/51kNn5apFk3d7MvHbnZH31Hbvbl79DNvlQy+/Ir" +
       "udnXLmj7k6L438du9uWL3OxPz68v/+U1uNrjRSVoP/j0oat9+lW42ok9L8zc" +
       "i7+fKq1cUn3rAt3+vCi+CcDU1JNy5g9RuGRxovHLr0bjHKS4J15UXIp66Lrb" +
       "zPsbuOonnr9855uen/3+Pt0/uiV7F12500gd5/QdllPPtweRblil+Hftb7QE" +
       "5c9fJZW3/Q29PKncefRYiv+XJYfiSsxjF3MASUn5e7rXrUnloZv1Aq9MoDxN" +
       "fQdIqW5EDShBeZryboAF5ynB+OXvabp7gb1P6ECusH84TXIFcAckxeP9wREk" +
       "nLors79qlO9j7KHTnltO/wOvNP2nXt+fPLPalbfdj16QU/ZwUX3x+eH4R19u" +
       "fnx/K1F15N2u4HIneI3bX5AsmRYv2U/clNsRr9upp7593yfveuvRunnfXuCT" +
       "KDol25tvfO2v6wZJeVFv9+k3/doP/OLzf1heFvr/fCg6v4YwAAA=");
}
