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
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "7/z913/0mW/lVyr/A4lp+2gSKAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "GSVwP/6j/g/3vqQRRS0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMV7e+zsWH2ff/fum2XvZRfYhbK7wF4SwYTrGXs8jywvz4xn" +
           "xo+Z8dgz9oyTsHj8GL/t8WPGNhBgpQS0KxFUFkqrsOofS1siAlFV2koNKVXV" +
           "kCgRVaIofUQNaYTSNBSJVdWkCm3psef3vvf+du8uaUfyscfne77n+znf7/l+" +
           "v8c+/sr3oTujEKoEvpOtHT++rqXxdcvBrsdZoEXXKQZj5TDS1K4jR9EM3HtK" +
           "efuvXfnLH37GuHoJukuCHpI9z4/l2PS9iNMi39lqKgNdOblLOJobxdBVxpK3" +
           "MpzEpgMzZhQ/yUCvOdU0hq4xRyLAQAQYiACXIsD4CRVo9FrNS9xu0UL24mgD" +
           "/Tx0wEB3BUohXgy97SyTQA5l95ANWyIAHO4p/gsAVNk4DaG3HmPfY74B8Ocq" +
           "8HN/54NX//Fl6IoEXTE9vhBHAULEoBMJut/V3JUWRriqaqoEvc7TNJXXQlN2" +
           "zLyUW4IejMy1J8dJqB0PUnEzCbSw7PNk5O5XCmxhosR+eAxPNzVHPfp3p+7I" +
           "a4D1jSdY9wj7xX0A8D4TCBbqsqIdNbnDNj01hh4/3+IY4zUaEICmd7tabPjH" +
           "Xd3hyeAG9OBed47srWE+Dk1vDUjv9BPQSwy9+ZZMi7EOZMWW19pTMfTIeTp2" +
           "XwWo7i0HomgSQ284T1ZyAlp68zktndLP98fv+fSHvaF3qZRZ1RSnkP8e0Oix" +
           "c404TddCzVO0fcP738V8Xn7jNz51CYIA8RvOEe9p/tlHXvzATz32zd/a0/yt" +
           "m9BMVpamxE8pL6we+L23dN/ZvlyIcU/gR2ah/DPIS/NnD2ueTAMw8954zLGo" +
           "vH5U+U3uN5cf/xXte5eg+0joLsV3EhfY0esU3w1MRwsHmqeFcqypJHSv5qnd" +
           "sp6E7gbXjOlp+7sTXY+0mITucMpbd/nlfzBEOmBRDNHd4Nr0dP/oOpBjo7xO" +
           "AwiCHgIH9Ag4NGj/K88xFMGG72qwrMie6fkwG/oF/kKhnirDsRaBaxXUBj68" +
           "AvZvv7t2vQlHfhICg4T9cA3LwCoMbV9ZzlN5F8OmC4wBBspRgYZUmATnlCzu" +
           "XS+ML/j/021ajMbV3cEBUNRbzrsJB8ywoe+Ahk8pzyUd4sWvPvU7l46nzeE4" +
           "xlAT9H193/f1su/SxYK+r5d9Xz/q+/pJ39e6yUqDDg7Kfl9fCLI3DqBaGzgJ" +
           "4D7vfyf/c9SHPvX2y8Aqg90dQC8FKXxrL949cStk6TwVYNvQN7+w+4Twseol" +
           "6NJZd1wID27dVzRnCyd67CyvnZ+GN+N75ZN//pdf+/xH/ZMJeca/H/qJG1sW" +
           "8/zt54c59BVNBZ7zhP273ip//alvfPTaJegO4DyAw4xlYODAFz12vo8z8/3J" +
           "I99ZYLkTANb90JWdourI4d0XG6G/O7lT6v+B8vp1YIzvKSbA/eB4+nBGlOei" +
           "9qGgKF+/t5dCaedQlL75vXzwxX//7f+KlsN95MavnAqMvBY/ecp1FMyulE7i" +
           "dSc2MAs1DdD9py+wn/3c9z/5M6UBAIonbtbhtaLsApcBVAiG+Rd+a/MfvvPH" +
           "L/zBpWOjgdKz2O65ABvo5CdOxAAexwHTrzCWa3PP9VVTN+WVoxXG+b+uvKP2" +
           "9f/26at79TvgzpH1/NRLMzi5/6YO9PHf+eBfPVayOVCKiHcyVCdkezf60Aln" +
           "PAzlrJAj/cTvP/p3vyV/EThk4AQjM9dKv3aphH4JNHrHredLyWQfAZ7/B098" +
           "+2PPP/GfgRwSdI8ZgdwBD9c3CUmn2vzgK9/53u+/9tGvliZ6x0qOSn9w3/lY" +
           "fmOoPhOBS3O6/1hFDxQaeQM4wkMVhefNrySFiwLZX78hhn76lfgfPykEK1m8" +
           "u3Auxy7mnbcesn6B7GSWPvLXE2f19J/+z1J9NziXmwTnc+0l+Cu//Obu+75X" +
           "tj+Z5UXrx9Ib3THQyklb5Ffc/3Hp7Xf9m0vQ3RJ0VTlMFwXZSYq5I4Fxj45y" +
           "SJBSnqk/m+7sY/uTx17sLec9zKluz/uXkzAArgvq0gT2LmWvogOo1Nt7yhZv" +
           "K8trRfGTewuNQWKbrBwTmP6duunJzuFs/RH4HYDj/xRHYQLFjX1sfrB7mCC8" +
           "9ThDCEAMusvRvHVsXKw/NjRd4He2h8kR/NEHv2P/8p//6j7xOa+sc8Tap557" +
           "5kfXP/3cpVPp5hM3ZHyn2+xTznI0XlsUeAqke9tFvZQt+v/lax/9F//oo5/c" +
           "S/Xg2eSJAGuDX/3D//2717/wJ799k0h8Gcy24g8apMeWfeQMDifL3o0UqgcJ" +
           "pu9phUc6qtsHYtO/fpzcg8r0JnPkXbce41E5u08M9VtP/8WbZ+8zPnQbEfjx" +
           "c2N0nuWXR1/57cFPKH/7EnT52GxvyPzPNnryrLHeF2pgqeLNzpjso3uTLcfv" +
           "5vZ6UFy+v6TAy7p3Ho8NdBhtiv/LC+p+pijmwNyVYvD3urqA/IMpFARB6QEH" +
           "5Y3rFxB/qCgej06nMGfVc2qh+ZTymT/4wWuFH/zGizd4r7MReyQHT57M6LcW" +
           "Nvzw+XxtKEcGoKt/c/yzV51v/rAMI6+RFeDzo0kIXG96Jr4fUt9593/8V//6" +
           "jR/6vcvQpT50n+PLal8uUyXoXpCjaJEBEs80eP8H9oFgVwTuqyVU6AbwexN9" +
           "pPy3DybN45BSRBPoveDQD0OKfj6kHPoo89Y+KiqXw8W9D+yVH0P3coPOUx0G" +
           "79L7iHTc31sK9m8FtvLr++725xja/FiT+1VoqiCr74CwyyuhGcRgyUp4WzP0" +
           "PVfz4qMVxf/7Tveq6B36u+I0jEF6kMXaDW6k1FNRBEcq2N1CBeW0OzX8RdEt" +
           "50RR+Dc6u+LvqCgmN3qv4j+377ZsXRTCBbPq5y+o+3hRfKQofnYvyQW0T6fQ" +
           "PncuSrkorL1w6i1t/MSKy9y1Bg7j0IqNW1jxL9x8CKEju73smt45iy3SfegK" +
           "BN0x3rPen3/cxiMHQQRH2/UKLD8iLYTHvqqxpmJrIeCnOX8zFvtyOi1HZnBr" +
           "63z2aGh/6RVZ5zOv0DqfLZk981LW+fkL6r5QFM8dW+czF1nn37vBOn/xb8A6" +
           "v/iS1imfwD4ly/O3Kcuj4LAOZbFuIcsLLyHLHSoI0DfzZnevfN/RZO+cjF96" +
           "+TKWy5y3QRcscw5l/OoFechxKCqenR0+Sq2dk+lrtzlury9oDmXa3UKmr7/E" +
           "uN2pFEurY/s/Jc0/ffnSvOFohLJDabIbpDk4fmpQJrMkWM6ttfDBP/37L/zV" +
           "Jz7ZulSsiO/cFusdkH1cPaEbJ8Wj7F/8yucefc1zf/Js+aDgiPWvXzDB3TND" +
           "fpkjejdD+I1XgDA/RJjfBGFx8RtHCv/Nly/egBvfTLxvvQLxPnwo3ocvEK8U" +
           "4dsvX7wOM7+ZeP/2JcXbT8SDA2BlyPXm9Wrx/w9v3u/l4vL9N3b+sOUo147W" +
           "kIIWRiDlvWY5zaM10ClT2b8JOCck/rKFBPb5wAkzxvfWTz773c/87i898R1g" +
           "nNSRcRbU/xJomP08cfUDxZ/v3B6eNxd4+DIAMnIUj8rHTJp6DOl8KgaWHa8c" +
           "UvzQ64f1iMSPfqO5LKO4UNM9ZdAyGYOc4iRPE0ID71Xj3Owi6HwakaGCj9Lp" +
           "zB/IbUvRkEYmTeAk8uJEMcaEQTtdVVk21oEkz6Qqz6PEdEjHsxWfOLOGIA5l" +
           "a2aGciWtatxAd7glkoTwCsvVBE7QxXY7XTNyPs5yN0f1NoZu4UXNy9N6nZvL" +
           "q07gBjwSzDeu0J5YQujCg4o4o0YDtzalxmOlW4VXZFODE3EbVqkKE68FSjci" +
           "CclEacYNqWAU2xt7Nh5blCDYVXfD9TfhZlk1DWvcscSgyo9SUWBXGTGTVmQe" +
           "mkbGidJIDKbmbmYxXYnKCbfbR6mOEcf4ejcy0VEyddKVTTPbaae2FEi+qk8r" +
           "HaSfDWy6J+8wo97CGpTJOvVljbdSjh71bcoQxVmNn4+VYJDQC0Q1I2kjS4yw" +
           "cqZJlPLpyEslwwhc1gmRlqyiqiTk42W2EPqCtSD43ADkVXtiLQXGZfvIpsqY" +
           "mKmmo1ZE2RaeLG1ps9uKa7K/Rjt+KLd6BrdbVEOBY9JOvULu3BpdGdqDwYBy" +
           "uZnNL3pdJ7FFz2XxSX/qrqg86HeQxA5ksZZrVR4gYKbNBFZFFlsOTSckETFD" +
           "QIjiSJzq+El1PaeCLTmSsYTyHWK1ynproTfG6J7g8NiwySCG6KK0QzM4kSzp" +
           "qD/MpKq8xWtDAelQcwIh077hBgTPALDZNtiqRMZN7KHI26pIakSm4/VuP9ri" +
           "bmcw27FK5PSHamSEjh7wE1uiwWDNcXwQdDyGTJjVYk73xW6nwXUTcm1uJMQQ" +
           "PLwSc2OcQ7br9XqFxlxKzFWt0Z+44sS1m2RN0JLBMu0Inf6iMyB3kUEwqel1" +
           "+rLcZAZ8ljc8wWnXMESqGZxv4xqO8eaIblktoGa/zXerVW5dpRUen/IVud/E" +
           "5huvXZconMcpdIN3lJxdWZu2PGzWbFHp56QgLcdSdUVPuZpRl5odo7kiwh7a" +
           "3eY2WesuZmNnPGzIWC+n3Q0iJZvpxJWXGccRnlxBKTKrwQnbEI2KR5FAdxRr" +
           "c7O5R+yW8IBb8XXG3M5FAhNk2xxxRkwRgmj1FlkFUOG6YIibhdmgjGVOi5Ht" +
           "p7MK3YctuD6hlzbeFYTpqN0k5WolbS5ESoV7jYCoMoNdvT3fLVt8S9G2FmUa" +
           "jFmbTGsUMXcFoZvPVyDjZjvJHDOwYDesC9JiGtfWbBvVUaHTVOjphp+PlJE5" +
           "lTx+QLFdmjHBukBK6S2/s9MWIU3drkL31/7A3RByk+S8tmi2Kh7sIeJsQ6Lp" +
           "dkngg8GGHlerPjEgwjE+nyLZpEnAAjNL25FebdRJUh4Hc3XQjxg5FplYDOvI" +
           "rLHZqWZNT9qSBg4paSyN6rxPkaPewlt2R92JgldRqWf7eLSY0WhbiMJxJVPc" +
           "qaptdG2Ch9G6QWWjTbxYS51Js8Nww56RhoNFmFY0erjOpmRXVnqbQJpN3JDn" +
           "fc3XyaXoC0NysXJpk6qR06bHcM6yklFEe6tuxZVelbHWWO1JvbVMGLY5bowm" +
           "s6zGkVW0i/CW2FxZ8LLFoqu4r8BUB0zNdIOQAwp4CVeoh1pd2FqtbMVYKAdv" +
           "edE1camzspmWJc5Ipr7uC1KzVjWYMSogDVuSuvZw7Q5WBDUVveYwXeWMPwpV" +
           "FdvFte2Qqeh4d5mk7Dpcq22EznpYX1RCldt53YXa9+A+uZtvezUZbeBZBW6N" +
           "CGcxriF93skdvS1mSQDGKqEEHVfGCpbuVvNBMO2h7RwdJ5U6Foujdjuv4C4l" +
           "xDvOVwZZx1pPnU6+UipJxSMajdZ4a3CjCp9SQRSLje5olYR6r2NOWx2Z1D15" +
           "4U4MUZkvm9TcV7uj2aoyz6XmjhvpqGMnOQ3jRDtuYkFFWrNsa+0FWYaO0J4j" +
           "5COfIPtOOhSmjWU2YayhsmF6c3YzzRs8UsdYWK/n1fV42svwoYuSMCbatYyY" +
           "s25s1JMRKSStnsiROjVhGj47r4zhStfjcmXudbq1IFuGCa3Z29UCS7h2oOeR" +
           "FI9iYWxMO4kSRNp26NFtLMQq2NTs27jXmGx4B9ixavkq65iaEmjLNtEiKn1P" +
           "ZJfZlqmTeNSceFxHma+bLW28ZMSd6m6nLr0yJ/1obQcdYTWebyl10mmBdS9q" +
           "t1Q66KD2yLIZl1FWM62xGAmmGe8qROZo/Z2h9wi6hqLCMm3pPB+I1e3aDXIi" +
           "lczFvO1gmi0hWBD1qWa/VZn4LLptCtVxvbtcJVgiLbydvG20042zhOOVh3bY" +
           "XDEtUfXXPRRbNUa9tp0myUTxUm/JDxBmwrvLOducsOvFNt3BFNxxdRfuYXR3" +
           "7JBaxIW5KtH8rjfjOsZy1xTrAJxWreizwdzjOFV2CVYRV7M+ymjOJJijPcOL" +
           "HY1haC8amLhCt5XUGrqtIZH0tuP+qMcspyZQbE8frJluxPsbwe01httdr8VG" +
           "I31irStEvzbllqxg2jW2LZINgY1bhrxRw9G2GguVnFQUI9Wl5YjbyvNtv9GG" +
           "0S2bMVHTEsUOZiXoEG1iTQFtGitpNpshUU415FybyBOsD0/oXdce50bc2gwH" +
           "rKTVNQSekJ6ILsnQDHmkzTsRDuyyC8Mw6NiztImUOFjL7CUtqhK2B9MNMcla" +
           "UksUM8rwNddyxpJgtsKFx40iS26KwYrjRlQ4IWpkNrIHoVnX0DrWYqwp6m5R" +
           "pybYsReSzGIzpNDRdpwhray5y1kJnvWx5kzVBsvZNK3mWaONMQqKztYNlsTs" +
           "VdLT8Za7M/tWE5MnAqVondF8YCiIm1jLuD+Q6fmkg2RcfYiv0hjrdMNKP435" +
           "RCfo2Krrbc5j/FWvszatbicQKiTOJmTeV2ohEoW7amiNNZ5NdI+d1QU9GiyS" +
           "yXiKMX5iN7IKQTtxW6a0kaO3Rl04jptIy9j4fRKxR/SQdlO6OpI2Sbgm86pG" +
           "bPQIq9T6A60/s5dwfUdggEnHGSJmsqMQYiJMsbgitLswNTApnXHXxmRSW1jD" +
           "3SJfUFjWTKvchg25cIZOG16l4YXe3GlidGPBmoHabg+Nauo55AptyhhTnZiq" +
           "k9srjPJcdGhGdrTbrhkLySq+lGGK6W0HNGvz1HQRVWudYNaV+putTAxYxrOc" +
           "WrMSo0M8snb8whapvt1gGGqMIXbG+GrDkzqLxA/YxpiTabYxmrsRlTG8RRNY" +
           "1W2JCN/twm5Oeg2YHouLJRF3Q1/S80nALONGJe36fRGlF3gwgdFW36Pz6rix" +
           "nuo7fzeP+Wy7arRYBqlPd4tx0PUUem3XhxUY433SD0lsO2lgMrLDulZEabGR" +
           "5ouB1bc9xdlgNbrG5cvqeI4JUlKxtnDaX6xQIdQAYcWfLhy52XSi5Xg4blsD" +
           "mTXr2RprLBdSFwl1SxsKC8ck0pWTVYbTlBhNDZAcSdMQhvnlpIaoenstp8xI" +
           "H0x1kqqhcRvbrtZRJxnOogHVq6RtZxt7Uq9iDI182GrYRM9SmDQYYTgSc4nb" +
           "2q77lQWmxupkSblTer0wUFcSm6qCjHE2HSwEIh238JyY6IbUrEcbEibFFpa4" +
           "tmikZETXd6sWHImslfU9tr/rdtEavVJQK/U3YElhMimG7sy2qHdrzWquwbTF" +
           "ooNRfUikWCuvwysUa4njZmuXwbiLwUR9PqzOtgNz1Wh7uawNEk2aVwZItRZn" +
           "y2UL8XR+5Pdz2U55szpHdNqbzlV3I035GZgOXL2iVZx6OKqv2SBu882NxXqI" +
           "E2OyWIk7FkyJqDqls+qIrQ/ratAP8yDmVptcGdZHwEdhI2YwNjS0kmcaK+yA" +
           "248Sqh1umitWbCjb9SjoNLotFZ2R1Y2PofPN0Ap3ysBYzZKkOyFXQUy0E9od" +
           "9ADHtZCoO2oSILumMkIXo6alJ3UWyWd64HjtLGOkpE1t17tubziPPI4aW6Iy" +
           "IAm5sqkJlXDi42JbiwR005SGpE1GjYzptqTFHBmodWk9zVahMEcqLQuv6OmO" +
           "6jG2v65nNVLbZtmqR3MtybacVX3KqPYwskEg7CDprqJ16C1JNWYkp+jhWlbr" +
           "hGTKm2ZvAjfc5aLXbPpD3/UVEekltrA24EY1F3x+JMNczLNE2kUCI202OyBe" +
           "T0J5rvRYut6sxvN6ba3U1PacxlhvZCny0NsN8yj0CGSbV9JwiGOInvlRNrZs" +
           "1WbJbW81nUmSPmhnVd0Oe049m4wZadYkWJJu8BGIQy6CWdlyo3TBUmXcabii" +
           "6TYycocFaW0ubpp1uteHE1zKqZYTamq3zfUjM2orwPktiWqq2oqIdoW5xcJY" +
           "7vSFGhDG3JFW2zIX6QRu0t2AcxPbTgSy3V3gqEdF6gLbuv5qVp9EyBANWSYf" +
           "Ma4uuXHMbQVfiWdcJuV5vYov1oS+6OKhOTF3w8z3wBJXZlvYYFH17WXCdhYV" +
           "03R7vgpWMp4Bx7MpJdublG+t8HikskKK5N7GT2lHIkdchces9g6Wxx5teGFd" +
           "c1gvWFrRyDQ2ylCZoR261wYrlk5zOJ9HrFWhN/gyQEPR1nRl1Av60nxImxXb" +
           "QEOlrdBg/cvT4xHRhlWE8Po1jcaocG26ESYReta0EHudig7jxmxPqE4TodM2" +
           "EBR1qU4ukx3eHroBbrg5nk+H6NDWd21NH+KI1GuvfRIs7hrMqJ/7iZwEMewS" +
           "3qrJd+AhqUikK2wbTrKoDccxN53ou77UJVLK34yTzqK/q8Ai0UcFbJHiElpv" +
           "dONMobuRMmZwddESguYMMWq2A9bySz4z");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("6Uq7N1GlynaQT12lJi5MVucmsdrtZWN9Mt+CrJyJRGwa2R18XjHMoL1R8FSK" +
           "wbJnjY4EWujuto0VZ6nVfiS5Ej4emB1DJcaJkfeQacQ04MlmkGAit1wrk8SO" +
           "U+C5pK467XQGFdhHdIrQqGjMgTDViuM0I2Z5ZVoPbawixBsKh2G8ajVhnjRY" +
           "ZhxZxk4SwxhrVbb0MCUVl5gvNs2qslm2aHs6zPOd75m8ao68MReJWzvEvHqj" +
           "HQ9MRF9pSypdI7hHdLEaTqrV6dzaaDSBIjqJGbUNX8msdaqNFwaG6u6wrrRb" +
           "qM/bnbW0zZt5H6x+qN0uWy2qdQQb8pPIWy/q4by/qrTrisAu1s4cGccblB4v" +
           "KsigyqFLVQ/nWJBs0c7c5lZjw+l1qQrHNOwZghg2V7eay+lmuxvRCy2YGSGx" +
           "ZA3G1TZ1iW8MnI2s132OtEb5mF1bIxg1AzHuY5tad1yj+uxmMotHDSZoOm4k" +
           "ztNOddkwghazQBRqkohV3agsBKXV3EwGvLBj4YYFr0Hit5lyHF/Fcfy97y0e" +
           "j/3F7T22e135GPJ4d7LllM/Y/ug2nsylt3xffXcQmls5LncXuCf738qn9A9C" +
           "53a7nnqke+otOlS853/0VhuSy30qLzz93PPq5Eu1S4eP/skYuutwn/gJn3v3" +
           "L7SOZXi44F28nXn2UIZnzz9WPhmBV7r94ke3rjsoWfw1kNSMeof7L758Mtw/" +
           "fKkHoafZnUNWbCMu3vtDnz1E9tnbRfbfb4rs4ITgmRLCay6AV+wzOrgrhu45" +
           "3EwWnQV4cPerAPjaI/N54RDgC7cBEHoprR08fEHdm4riwRi6MwocMz47Rw4e" +
           "ehWYSrKi3XcPMX33x6O0Uy96Byeae+ICiO8oisdi6F6v3LJr5jd99XjH1jfV" +
           "E+iPv1p1vgmguLZvuz+/KnVePvF4g5OihIdcAL1eFO+OoftL7XYN2fM055yS" +
           "r78KpG8sbj4BEH75EOmXfzxKvgDu+y6AW7zkOWjHxaZMN0hirdyJWlI+c4L3" +
           "p18t3seA6H92iPfPbhfvS/rYA+qCOqYoCOCEYv/kDdofnWDrvwps5RcbjwMx" +
           "XzzE9uKPH9sF2y0OFkUxBbYqb7VQXhd7uf1yw+7gBB/3anX3DuA6DvZt9+dX" +
           "j+9UFPFLIKsLQKpF8XMxdOU0SG7QKVuf4Pzg7eBMgfMqvvk4es2K3P6ebZCR" +
           "PHLDh2z7j6+Urz5/5Z6Hn5//u/1u9KMPpO5loHv0xHFOb1M+dX1XEGq6WY7X" +
           "vfstjuWWsAM3hn7yZYoHrPzoskB24Ow5BDH02MUcQDArz6dbRTH0yK1axdBl" +
           "UJ6m3sbQ629GDShBeZoyi6Gr5ylB/+X5NN1HYui+EzqQJO0vTpN8DHAHJMXl" +
           "x4MjXZ56Zb7fTZ4enE0lj0wGevClTOZU9vnEmU2s5YeOR/uBk/2njk8pX3ue" +
           "Gn/4xcaX9t+bKI6c5wWXexjo7v2nLyXTYk/x227J7YjXXcN3/vCBX7v3HUf5" +
           "7AN7gU/m2ynZHr/5Vx6EG8Tldxn5P3/4n7znHz7/x+X2kv8LGcQEUIE6AAA=");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ubz1eBOi/N15wSbEqYXaSrHi9NitNk3L1aaPv+f5F9TxJ6oHhwvcQlK5OwnC" +
       "H3S1jeaeYlUcEHj7rVfW2HLP+GTh9Tff80ePzH7EfPdr2Fp68zk5z7P8F+yL" +
       "v9X7AeVnDyq3HS/D3rCbfbbRM2cXX++JtCSN/NmZJdjHji37hsJij1cqB4eW" +
       "PbjF9s5NveBS6QD7sT+3f3BQEhyUz9NTY75IKrdZfgIM+9ZbG7bcuNivQL7w" +
       "z576wk++8NQflGv/l614IUd4ZNxkW/xUm2+9+NVvfOm+xz5Z7pXdvpLjvebn" +
       "zxPceFzgzCmAUq17jw31jsIuyEWGOlp0xl77vue1TrrSwjDcu2N0wV7Mc0Xh" +
       "JZV7ig3xNNGmPaKk2xwL+mBB+xAYHHYv6P6aVHb/D7eRlQC4Jhz6BsyNeqVG" +
       "Xa14Fx3tYf/VdZ6dM8+jhTWeAGb5tUPz/NrePOvvq4SryFKBaATwPV6JrDCx" +
       "fIP0N1YU+J7mJ0dm+f/faXaziLx9tUu0Y3e7dLi3frxM/nezS5XSx99/cxg4" +
       "OJ4MjueBO13NN/ZnKkrqnwmzm0IDCJfXn+yYdNzA14q9z6O6/TkAK7h+fKwI" +
       "VGY3ldTeS1p2VhRPXRBEP3dB3c8XxYeSyh1KIcxe9gvIP5pVirg9mdv8V9t5" +
       "OM1hL/mxb76ueIkC2/CHGMN/f8D4tpM5+2dOipL0Exfo9otF8U+KwQyMI5w5" +
       "7zmbwFJPlP+n34PyJW49CZRWD5VXvz/Kn3YS4FKPli51gsZEqhfnJdQSOEoG" +
       "v3KBST5TFC8llStKpMlJsUcfRMUO+zmQKQfyykW6nNkVOzsBTuVtma48q/zr" +
       "yde++LH8pRf3m17FRJZUoFsdF7zxxGJxtOSCWfbUQbJv937o5T/8b4sfO0qI" +
       "XlcUnz2e0e4/vTG/P8Tw8q3h4rNHcPEbf0m4KIoPHEPFr94IFcXjB4viZy+I" +
       "/c+WzH711WL/P1xQ9/mi+FxR/OO9JBfQfiE7FfSf+h78vjxg8zag5S8c+sov" +
       "fF/9vlSkJPjdC7T5vaL4UlIeF9hoUXIr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("x76/aPFG8I/2wu6vZxy7bFAUXz72nx/6bjKiIC3Ss1u72ZeP3OwPvis3+8p3" +
       "6WZfLpl95dXc7OsX1P1RUfyPYzf7ykVu9sfn55f/+D242hPFS1B/8JlDV/vM" +
       "a3C1E3temPEXj58urVxSffsC3f60KL4FwNTQknLkD1G4ZHGi8SuvReMMpMYn" +
       "XlQciHr4hlPO+5O5yidfuHL5TS/Mf3f/mXB0evbuYeWynrru6fMrp+7vDCNN" +
       "t0rx796fZgnLy58nlbf9Jb08qVw+ui3F/7OSQ3Ec5vGLOYCkpLyebnV7Unn4" +
       "Vq3ApxYoT1PfBVKqm1EDSlCeprwHYMF5StB/eT1Ndx+w9wkdyBX2N6dJrgLu" +
       "gKS4fSA8goRT52T2x4yyfYw9fNpzy+F/8NWG/9Rn/1NnZrvyFPzRh3XKHU6q" +
       "L73AjH7iFfQT+xOJiivnecHlMvj82x+OLJkWH+dP3pLbEa876ae/c/+n7n7r" +
       "0bx5/17gkyg6Jdubb37kj/TCpDykl3/mTb/yw7/4wu+XB4X+L6b08wqeMAAA");
}
