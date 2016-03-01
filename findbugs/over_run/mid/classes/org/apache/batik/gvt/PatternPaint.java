package org.apache.batik.gvt;
public class PatternPaint implements java.awt.Paint {
    private org.apache.batik.gvt.GraphicsNode node;
    private java.awt.geom.Rectangle2D patternRegion;
    private java.awt.geom.AffineTransform patternTransform;
    private org.apache.batik.ext.awt.image.renderable.Filter tile;
    private boolean overflow;
    private org.apache.batik.gvt.PatternPaintContext lastContext;
    public PatternPaint(org.apache.batik.gvt.GraphicsNode node, java.awt.geom.Rectangle2D patternRegion,
                        boolean overflow,
                        java.awt.geom.AffineTransform patternTransform) {
        super(
          );
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (patternRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
        this.
          patternRegion =
          patternRegion;
        this.
          overflow =
          overflow;
        this.
          patternTransform =
          patternTransform;
        org.apache.batik.gvt.CompositeGraphicsNode comp =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        comp.
          getChildren(
            ).
          add(
            node);
        org.apache.batik.ext.awt.image.renderable.Filter gnr =
          comp.
          getGraphicsNodeRable(
            true);
        java.awt.geom.Rectangle2D padBounds =
          (java.awt.geom.Rectangle2D)
            patternRegion.
            clone(
              );
        if (overflow) {
            java.awt.geom.Rectangle2D nodeBounds =
              comp.
              getBounds(
                );
            padBounds.
              add(
                nodeBounds);
        }
        tile =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            gnr,
            padBounds,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
    }
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() { return node;
    }
    public java.awt.geom.Rectangle2D getPatternRect() { return (java.awt.geom.Rectangle2D)
                                                                 patternRegion.
                                                                 clone(
                                                                   );
    }
    public java.awt.geom.AffineTransform getPatternTransform() {
        return patternTransform;
    }
    public boolean getOverflow() { return overflow; }
    public java.awt.PaintContext createContext(java.awt.image.ColorModel cm,
                                               java.awt.Rectangle deviceBounds,
                                               java.awt.geom.Rectangle2D userBounds,
                                               java.awt.geom.AffineTransform xform,
                                               java.awt.RenderingHints hints) {
        if (patternTransform !=
              null) {
            xform =
              new java.awt.geom.AffineTransform(
                xform);
            xform.
              concatenate(
                patternTransform);
        }
        if (lastContext !=
              null &&
              lastContext.
              getColorModel(
                ).
              equals(
                cm)) {
            double[] p =
              new double[6];
            double[] q =
              new double[6];
            xform.
              getMatrix(
                p);
            lastContext.
              getUsr2Dev(
                ).
              getMatrix(
                q);
            if (p[0] ==
                  q[0] &&
                  p[1] ==
                  q[1] &&
                  p[2] ==
                  q[2] &&
                  p[3] ==
                  q[3]) {
                if (p[4] ==
                      q[4] &&
                      p[5] ==
                      q[5])
                    return lastContext;
                else
                    return new org.apache.batik.gvt.PatternPaint.PatternPaintContextWrapper(
                      lastContext,
                      (int)
                        (q[4] -
                           p[4] +
                           0.5),
                      (int)
                        (q[5] -
                           p[5] +
                           0.5));
            }
        }
        lastContext =
          new org.apache.batik.gvt.PatternPaintContext(
            cm,
            xform,
            hints,
            tile,
            patternRegion,
            overflow);
        return lastContext;
    }
    public int getTransparency() { return TRANSLUCENT;
    }
    static class PatternPaintContextWrapper implements java.awt.PaintContext {
        org.apache.batik.gvt.PatternPaintContext
          ppc;
        int xShift;
        int yShift;
        PatternPaintContextWrapper(org.apache.batik.gvt.PatternPaintContext ppc,
                                   int xShift,
                                   int yShift) {
            super(
              );
            this.
              ppc =
              ppc;
            this.
              xShift =
              xShift;
            this.
              yShift =
              yShift;
        }
        public void dispose() {  }
        public java.awt.image.ColorModel getColorModel() {
            return ppc.
              getColorModel(
                );
        }
        public java.awt.image.Raster getRaster(int x,
                                               int y,
                                               int width,
                                               int height) {
            return ppc.
              getRaster(
                x +
                  xShift,
                y +
                  yShift,
                width,
                height);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "209/Iz/9/R9gw4L/XiUAAA==");
    }
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
      ("H4sIAAAAAAAAAL16e+zr1n0f77Xvvfb1417bcey6sRMnN2lsJj9KFCVKu00W" +
       "ieJDoh4UKYmUusWhKJKi+H5T7Nw2Gbp4LZAEjZNlReu/EiwtkqYYGmxD0cFF" +
       "kaZF0wHZiq0d0KYYNqxbG6DGsG5Y2nWH1O99H7ZhYwJ4fud3zvec8/18z/dx" +
       "Xl/7PnQpDCDYc62dbrnRgZpFB1urfhDtPDU86A/qnByE6pqw5DCcgrIXlPf+" +
       "6rW/+sHnNtcvQpeX0GOy47iRHBmuE/Jq6FqJuh5A105KSUu1wwi6PtjKiYzE" +
       "kWEhAyOMbg6gB041jaAbgyMWEMACAlhAShaQ9gkVaPSQ6sQ2UbSQnSj0oZ+A" +
       "Lgygy55SsBdBz57txJMD2T7shisRgB7uK/6fA1Bl4yyA3nOMfY/5FsBfgJGX" +
       "/8nHr//ze6BrS+ia4QgFOwpgIgKDLKEHbdVeqUHYXq/V9RJ6xFHVtaAGhmwZ" +
       "ecn3Eno0NHRHjuJAPRZSURh7alCOeSK5B5UCWxArkRscw9MM1Vof/XdJs2Qd" +
       "YH3nCdY9QqooBwCvGoCxQJMV9ajJvabhrCPo3edbHGO8wQIC0PSKrUYb93io" +
       "ex0ZFECP7ufOkh0dEaLAcHRAesmNwSgR9NQdOy1k7cmKKevqCxH05Hk6bl8F" +
       "qO4vBVE0iaDHz5OVPYFZeurcLJ2an++PfvQzP+4wzsWS57WqWAX/94FGz5xr" +
       "xKuaGqiOou4bPvj84IvyO3/jpYsQBIgfP0e8p/kX/+C1j33omVd/Z0/zw7eh" +
       "Ga+2qhK9oHx59fB330U817qnYOM+zw2NYvLPIC/VnzusuZl5wPLeedxjUXlw" +
       "VPkq/9uLn/pl9c8vQld70GXFtWIb6NEjimt7hqUGtOqogRyp6x50v+qsibK+" +
       "B10B+YHhqPvSsaaFatSD7rXKostu+T8QkQa6KER0BeQNR3OP8p4cbcp85kEQ" +
       "dAV80PPgew7a/8q/EbRCNq6tIrIiO4bjIlzgFviLCXXWMhKpIcivQa3nIiug" +
       "/+aHqwc4ErpxABQScQMdkYFWbNR9JaInEWgZAV1yOBlo7kGha97/l1GyAuv1" +
       "9MIFMA3vOu8ELGA/jGut1eAF5eW4Q772Ky/83sVjoziUEvA4YKiD/VAH5VAH" +
       "YKiD00NBFy6UI7yjGHI/yWCKTGDswA0++Jzw9/ufeOm99wDt8tJ7gXwLUuTO" +
       "3pg4cQ+90gkqQEehV7+UfnL+k5WL0MWzbrVgExRdLZpzhTM8dno3zpvT7fq9" +
       "9uk/+6tvfPFF98SwzvjpQ3u/tWVhr+89L9DAVdQ18IAn3T//HvmbL/zGizcu" +
       "QvcCJwAcXwTkVfiUZ86PccZubx75wALLJQBYcwNbtoqqI8d1NdoEbnpSUs70" +
       "w2X+ESDjBwpFfgJ8s0PNLv8WtY95RfqOvWYUk3YOReljPyJ4v/iH/+a/1Upx" +
       "H7nja6cCnKBGN0+5gKKza6WxP3KiA9NAVQHdH3+J+/wXvv/pHysVAFC873YD" +
       "3ihSApg+mEIg5p/+Hf+PvvcnX/6DiydKE4EYGK8sQ8mOQRbl0NW7gASjfeCE" +
       "H+BCLGBghdbcmDm2uzY0Q15ZaqGlf33t/dVv/sVnru/1wAIlR2r0odfv4KT8" +
       "hzrQT/3ex//XM2U3F5QihJ3I7IRs7xcfO+m5HQTyruAj++S/ffqfflv+ReBh" +
       "gVcLjVwtHdW9pQzuLZE/fieTpAPZ2xhKOHLX6hHlD5VjyGl0oKuuDaKDAjRT" +
       "t1S0Cxh47i5LosCwwcwmh2EEefHR75m/8Gdf34eI8zHnHLH60ss/87cHn3n5" +
       "4qnA/L5bYuPpNvvgXKrkQ/vZ/VvwuwC+/1t8xawWBXvn/ChxGCHecxwiPC8D" +
       "cJ69G1vlENR//caLv/7VFz+9h/Ho2bhEgmXX1//933zn4Et/+ru3cYNXVq5r" +
       "qbJzJNmnz0q2rWnAsqcBICiMtcSClLTPl+lBwXw5i1BZ1y6Sd4en3dTZSTi1" +
       "KHxB+dwf/OVD87/816+VfJ1dVZ62yqHs7aX4cJG8pxDKE+d9MiOHG0CHvTr6" +
       "e9etV38AelyCHhUQU8JxAGJBdsaGD6kvXfmPv/lb7/zEd++BLlLQVcuV15Rc" +
       "ukPofuCH1HADwkjm/d2P7c0wvQ8k10uo0C3g9+b7ZPnf/XdXQqpYFJ440yf/" +
       "z9hafeo//e9bhFDGgNvo5bn2S+Rrv/AU8dE/L9ufOOOi9TPZrfERLKBP2qK/" +
       "bP/Pi++9/K2L0JUldF05XJ3PZSsuXNwSrEjDoyU7WMGfqT+7utwvpW4eB5t3" +
       "nTeMU8OeDwMnCgnyBXWRv3rO8z9YSPkZ8CGHThE57/kvQGVmXDZ5tkxvFMmP" +
       "HDnaK15gJMCuyp6bERgXeJQiX9kHjSLtFAm3n0zyjhPfP8vWB8CHHbKF3YEt" +
       "8Q5sFVnhiKOHvP3yg1f1w+iDnmNNepOsfRh8Nw9Zu3kH1j7+Rli7fsjasSso" +
       "yj96jrsX3iR3T4Kvfchd+w7cqW+Eu3uBUR8Hh8otYaQwwcKlGTbYtxyA9Qhw" +
       "CEWEA6ZkRXtTOYVCe5MongYffYiCvgMK542guM9NwPbPctPif/wcV+6b5OpD" +
       "4OsdctW7A1fxG+HqAbBfiw73zEci/uDrLp4PG5wDkbwuiHLQ7AIw10voAX5Q" +
       "muZP3J7Ne4rsB8ECKiy39aAFiFWydcT3E1tLuXEUVOdgmw9M6sbWwo8wXC/D" +
       "QeG9DvZ743O8Nt8wr8DdP3zS2cAF2+yf/c+f+85n3/c94JP70KWk8JfAFZ8a" +
       "cRQXJw//6GtfePqBl//0Z8v1IJA790Xy+seKXv/x3RAXyaeK5B8eQX2qgCqU" +
       "W6gBmKxhuYRT18dosVN4/g6wFst9C2ija19lsLDXPvoNqkttkc2qvIgM8RCP" +
       "d+kAxsiQber+rtIbYG7qWmAOqvaMWju06Kz6PdSfV1WOs/N4Nx3BzVYtiPMx" +
       "2uZ7c7qvNXQeIXvWdJHwpD6dyrYXzvtBg17NRbnqz+Z0NfJ9VBY6HEVZEZ4H" +
       "tURu4SGN9zYNYZXkESjDnRoyxOqtepbjedJkZTufjvqWQHmiEYyiTiAZrJRx" +
       "grykwhrqLylz5XaVqIYETjKNOETC2cAw+ttl13PrvSpLhqIkVycjMR6ZA5td" +
       "bqm+2bCr26gXKj4/lC0qn9IsG7joxF641Vm3M+Pnq4Xbb1jCoMMPvbE5FwfD" +
       "ebdP8boWErxe55q2JUgdjwyqHd3DTHnZry7qCTMcxENXadY2wYRa5ejAXK7M" +
       "9ZpdWIS+42cVk1okVYvMdq5MByjC+nnMVrLxQPKX2tKwjFXCZkR3jnIjqZXB" +
       "Ls5TfoOml6zdWGTdaLScClWNkbvLvh3U1LngRiKV9LvyxBbkVcPoON506w/6" +
       "dpfvELmPcaI74TxvToQi7EzGm9zMs0m67Ih9U0pMc2PzbEeKZaqvLJf2Rh85" +
       "q3GX1hNlRDbqer2djBMiG9TxwK7V1UnVYwxmZGzlIRbqeqc3oniT2ER9YuNF" +
       "4ipfD0KCdubpuNutUhNzvrZiEU9Gs4SVs16gt926HA5G7qw/ThqqyQ7aziJn" +
       "B8P1aExZ8Gi81FqSVR1bHN2JWnib3bBxxqRtlDWIhb3k2i10J6IGylrxHJ4P" +
       "8c0i3sG0brSjVb2Nytt4YImBsO50UFcY+H1WnKa7bhO16j22Nk0n8xFuhxuz" +
       "wcbdmaP24rlne/S4R1XZbpuZUyzWW9KUufSIYZ7yor1BUzNswk6jvlLWSVUM" +
       "mmKfpyfjWWRRqqgR5m7dllfVEbkeEUnUHnYX0TTComgKt/oVt0cOm0OyHcsS" +
       "grv1/nwwdkE5vbWnZDu3BvZ4Z6QR08yGGjxuJqYoVRvtRXexjFlx2xzGfNNq" +
       "SKG5bAjtJW3XlhW+A3NjbMBUB7UcyUyugu02HkO0M3GuDjoasZ1bZkL3PDaf" +
       "zmduY0XKjNyeshTYssJct95pqGTTpzdia4LbCr822/58Xp9XcgfBxqyybVO+" +
       "r/O1zSzy8iTZhDwNS0m/15vO0spQTPFxz+gi8K6i20PZlWSSFfqzGt8ip2y1" +
       "QyK0N2UYOuio2ZLuTlG+rSGaEjECzLGkx69HytAgV/FiSjpbiu2IXUNLF+0K" +
       "Rie+YPW5rjLmfLkptZbegl8ssYzp2QTdxPqdSU9qVRpwIIq+XZdqYCMejRnT" +
       "RnqbdDjCxKi/0LGQ4pVBR3KE5nzjrzYIy7P9Zkcap4JImQpFiiiRT3A+ErfT" +
       "ZoqLq1ZtOtcZZYnhoi7t+LXYp1pwsHOx3nQXMTm21URHcuCoOSdmPEGlS6KL" +
       "q4StA59IGe3MbmwHo4meskK6HE/IHblBmv260GXwTU2LJMbJgPZr1SlDqKHe" +
       "IyicsMdZXOFrSnfNjWgkH/CtlqJNY2bl14JmImz63Jrd6pnETCicN0mnvpCk" +
       "XbtlSvUGX1NnVbI31IPtIKXSRWXrd+W6QG15zOkQY7GjE0qliRLemJ2QubJC" +
       "ZcPb1sJWbUTJsBbWF2PWi3stO5XGo2TFYAOsgdKt7Zh0G31uM2qnM64ZYeqo" +
       "gyFIK4YlxZnhKHAsVlNmWDXJeIFQgl6Nsa0V15mqC6s9WDtwfYSvakGlGqKK" +
       "1uwaiTkdrI3RCmgDs21vfM62LVyGkXUD77RgVt3ig157Jg2r3ZFF7SYo2ZR9" +
       "rENyiGbqE8NOkzodwDbM6+NkzrCsRZHeymMTe6OEmspO0apPMo3tBMO3vLkd" +
       "ccCfaXF9oMBDv+rlQX3UIZfDhuEMsdZwM54ta+GuBUJVNMktNm41FLUFDyru" +
       "cIIRtCuGHror3P963RnMNJXkF3zVM4Qh2NhUt8FileJWLKUjeZlTzeokmTBg" +
       "mqdczgY1k9WjmkE06UXPxKRhthjQM78z7fp2v9beBrKGJp6CaHLgjCcVchHr" +
       "yciVNQ71EB2Z1mhTHlJLnUvdXc4rlBqizRwdrTZdGtkEzR7HIVQHQ3uM0JtH" +
       "nLSEVZ0Y7cglr9umVBUs3dgx5mjLt6KG2MnrjTnZ7vXjtD1coznekhMM1yKy" +
       "jum+F9SphUg5lfVspPfGIyOaxI4zn8ek4ufNZhyPpC28w/jZdj73Gtt5hezD" +
       "sa4hychHRnhNAn3017yzplDL1DeIBQ9QpT3C1VaHaFvLsLHgENRx8qZA9/j2" +
       "2HRl3ROxqNIbxxpVcXO/vs1sZRfYksEwO0Lu4IPxIhBIXLTyXY5Go7raFQZa" +
       "p9MxM5Vh7OUyRbGJN4pHBLlNq0YFrdXTmlwXpUpVtXwYa9Q4z6418b49lbqS" +
       "xa8wRNCr7CboDNh8MagQjVw37J2E92ldxJehNENkiuacxWLJox2anrPNkcgT" +
       "stGYZ1NhFfs47MwRxHNqOZ3PzNhzK37gzyShlrVIwp5QO7tqbMzWcpA5QkSJ" +
       "HS/RWZma7GZzrEsKTreVbSlrPuwYHBHFmsNJmOEqXDJMuu66izFDDGyTOyGp" +
       "5CbS67p9meKmUY6kq7ED9gQJw9bYSHfStZbhwrAWImEsUbPAHksq4fBTnamY" +
       "imZ30Fo205QalsACU0OovjWeTC1dWeM7mSHqLToGKwMwhS1CtKf4cLDkZ268" +
       "mJkrvU336v18goV9cWRlTZsfSwq2W9WAL12hq3U4HNcarcoiYlshAxYb0cSI" +
       "0NQbp2a1bdi0ud0MWsquaopNZ8GPzFjJqGVit10FtU09rKDR0DC7mNhJMCSy" +
       "et5oG6eNVdTf2nGDUVt4dYfyGhE2M3Vp2T0crP8InOZZdzbE0KVpG7Rf5WaV" +
       "VVXp71JO2Jp1AXUTvbFipEZq83M/9Fe8XuvtUDSi8VmaNKrtBVMVJoHSnsFJ" +
       "IvKJMexSvs4yymLITYZ8OkNqFDWbdVZOe7gj3U43pDKfwDYOTbfam2i+FHtb" +
       "2CVGU36wkJitiLJsREwodFKd64v1bjgab7bV4c6Dt1u4lg0n67FiduYVIseI" +
       "VpUkem53PaemwtCu055vTzK4HtBDZVLLaxs1zEwiphux7ifmbqUtrAWCZLOt" +
       "3hrvEg2vDkmJNm0Yt2UBY+uhUF9oipqQWD1mEk1X88mkEm/XPoiK9a65Hg8N" +
       "a1HnR0tiULck0zUpGIWHVCueJ47v1hVxzcxgsUPamt/tmvEALD3FkKSkKG9t" +
       "W+Yq2GzXXM+eYonZQYakp+VLDB7PqgQ8w10kJ4RY4A03jhVfVptxzoPFnrgZ" +
       "dgTLHDckEizniK6m06q0UjbryVSrSoSkt2FsyfZ2VSGsVbGdt+WajK0ZhtP0" +
       "pvVutmhiNR2Gm8SyZfeX/mK4pmtOjROwNscKQkfrhuGECe1pjg5HCx9u1yV6" +
       "GhO5Mk7nkw6+My19GMHxLq+523pabXVNjOppztpKYHSncNxiVyWC1PGxtLVR" +
       "KgnddzYTAeE2GxzOmk0ZSVMljfpeAHwGDk+zDU6JqbZRrBUphYwpYttAZ5CB" +
       "02sjtXDF0TWVxhCmvoI5dJplNZoOO2IGi66Pp2OyO+s43WWFTOG+b3J83WKx" +
       "dSopeF7btltkyGSkSC18EcfWysKh61p1TSWKmqkTyZ9Etjnj2jQZa8NmNDUZ" +
       "WJQ1RAxHayRUR3keJb7q4LkN2AxSrh5YKxpZaGOVGPBNPzOFmj6KsaYgLfAR" +
       "kQ5wooU3BJMPKGS7tcYIvk2QijVFmWRarW/6M1lG2BnLmE2wsamrhtCMmx7Z" +
       "zSdo3rXynAem3ZCwuTzzhY2V8XMNdfqtFp53Ox5YbSzsJr/cxW0EQaem0zP9" +
       "PtZmB7xW89hukwEbmB4x2661XJoiitXDKiojDLOm2gPhDM3bqQ1r9gzToi2B" +
       "8AS3rVGZRmSUxszGTcHC6p45wwcDDM/RbBMzWndZbbg7A2bYleWmmhgECQxC" +
       "tkomahwaXlTDGvmURAXVISl8tAiblb6jwDLbEpoNTkMzdhIrsV+dE+O0Dnd2" +
       "GoViJJ4zk2ow7Fr1vhjVwhqsrTqUAjcjQ0P7Xu6M6nSvQ1rGDJ53YnQyc+Wu" +
       "bPVzl9Jdf+zUNTTisFRdSUktdSrhKhliBhbBfph5tNjK63nPm+VbrsoPbbFd" +
       "JamlYCZNKib81dJYZc3dTmhUF7zR8nFDoxuqsSD1hRdsrJW75hQp2NXAUj1o" +
       "uo2kaUV0rzHpyj5OohItywvSD1B9gVjAb0/nBtpgbRAAhN2M6YZEs7aoqPW6" +
       "Xumuqw3TFhEVScEmNJZRsLYHv498pNiyf+HNHSU8Up6aHD8v2FrlOdRPv4nT" +
       "gn3Vs0Xy/uMjqfJ3GTp3JX3qSOrU8fmFoxOah4/vIsojpeLc/+k7PSYoL0K+" +
       "/KmXX1mPv1K9eHgbcTOC7o9c78OWmqjWqREug56ev/MB/bB8S3FySv7tT/33" +
       "p6Yf3XziTdzSvvscn+e7/KXh136X/oDycxehe47PzG955XG20c2zJ+VXAzWK" +
       "A2d65rz86WOBF0er0I+A75OHAv/k+TPAkym9/QHgB/cqcZfLnq/fpe4bRfLV" +
       "CLqmq9HpG7yiuHKiSL/0esdOp/stC75yDLG4B4beD76XDiG+9PZD/Fd3qfv1" +
       "Ivk1oKYAInd0cK+UR57oCcJvvgWEP1wUFvWfPUT42bcf4bfuUvftInk1gh47" +
       "QXj2/P8E5m++BZiPFYXF3c7nD2F+/u2H+d271P27IvlOBD0AYI5PH8GfwPv9" +
       "twDvySM9/flDeD//9sC7VBJcuvVOfH/NQbiWGwyByVlHFI8eUxxfmJfKejKV" +
       "j0eHN6t7ouKexHB0BjjfsGThj+8ixf9SJH8YQQ8pgSpH6rkbg8fP+vLTtaWA" +
       "/+gtCPjakf5861DA33r79ee1u9T9jyL5i72vK+3Dk4s3L7vbnb3fYzinUH//" +
       "zaDOIujB01csxWOLJ295Arl/tqf8yivX7nvildl/KJ/oHD+tu38A3afFlnX6" +
       "xvVU/rIXqJpRYrp/f//qlX/+JoLecbsbHwAHpCWjf11SXoAi6Pp5ygi6VP49" +
       "TXdPBF09oYugy/vMaZLLoHdAUmSveLe5tNlfOWcXTsX1Q80oRfvo64n2uMnp" +
       "tzvFWqB8fHoUt+P989MXlG+80h/9+GuNr+zfDimWnOdFL/cNoCv7Z0zHsf/Z" +
       "O/Z21Ndl5rkfPPyr97//aJ3y8J7hEy09xdu7b/9Qh7S9qHxak//LJ37tR//Z" +
       "K39S3iH9P+uFrVkVLAAA");
}
