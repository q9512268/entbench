package org.apache.batik.gvt.flow;
class GlyphGroupInfo {
    int start;
    int end;
    int glyphCount;
    int lastGlyphCount;
    boolean hideLast;
    float advance;
    float lastAdvance;
    int range;
    org.apache.batik.gvt.font.GVTGlyphVector gv;
    boolean[] hide;
    public GlyphGroupInfo(org.apache.batik.gvt.font.GVTGlyphVector gv, int start,
                          int end,
                          boolean[] glyphHide,
                          boolean glyphGroupHideLast,
                          float[] glyphPos,
                          float[] advAdj,
                          float[] lastAdvAdj,
                          boolean[] space) { super();
                                             this.gv = gv;
                                             this.start = start;
                                             this.end = end;
                                             this.hide = (new boolean[this.
                                                                        end -
                                                                        this.
                                                                          start +
                                                                        1]);
                                             this.hideLast =
                                               glyphGroupHideLast;
                                             java.lang.System.
                                               arraycopy(
                                                 glyphHide,
                                                 this.
                                                   start,
                                                 this.
                                                   hide,
                                                 0,
                                                 this.
                                                   hide.
                                                   length);
                                             float adv = glyphPos[2 *
                                                                    end +
                                                                    2] -
                                               glyphPos[2 *
                                                          start];
                                             float ladv =
                                               adv;
                                             adv += advAdj[end];
                                             int glyphCount =
                                               end -
                                               start +
                                               1;
                                             for (int g =
                                                    start;
                                                  g <
                                                    end;
                                                  g++) { if (glyphHide[g])
                                                             glyphCount--;
                                             }
                                             int lastGlyphCount =
                                               glyphCount;
                                             for (int g =
                                                    end; g >=
                                                           start;
                                                  g--) { ladv +=
                                                           lastAdvAdj[g];
                                                         if (!space[g])
                                                             break;
                                                         lastGlyphCount--;
                                             }
                                             if (hideLast)
                                                 lastGlyphCount--;
                                             this.glyphCount =
                                               glyphCount;
                                             this.lastGlyphCount =
                                               lastGlyphCount;
                                             this.advance =
                                               adv;
                                             this.lastAdvance =
                                               ladv; }
    public org.apache.batik.gvt.font.GVTGlyphVector getGlyphVector() {
        return gv;
    }
    public int getStart() { return start; }
    public int getEnd() { return end; }
    public int getGlyphCount() { return glyphCount; }
    public int getLastGlyphCount() { return lastGlyphCount;
    }
    public boolean[] getHide() { return hide; }
    public boolean getHideLast() { return hideLast; }
    public float getAdvance() { return advance; }
    public float getLastAdvance() { return lastAdvance; }
    public void setRange(int range) { this.range = range;
    }
    public int getRange() { return this.range; }
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
       "DbdVqdcWPq8NwDi0WnQ5aTWUcX9Ubvus");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Wp5QSKNCzJPajNkKxEjgKI0dRFansmShFq/7q6HYbbDk1m1PPNj3KiFqbek+" +
       "LbUq6zIRwUK6apkx1whVVbQ1CJ/1bElqIW1yM4bSteG1HH8deDqzjEGcTtJO" +
       "VfNYZzwqD+aebE74TlMmhlZ1g2M9x+tCFG5EYT0dmO2AoyubMhHETGeKludO" +
       "s4k2ylZN1yGjPUQxnelOKyiKfvSj+RLUf7q9pbFHi1XAwyOmSwfJM75zG6tf" +
       "2c1WOg8XTQ9/zx//P7ZoemwLqpRvkj1zs2OkxSGZb3zujTfV0c/C5/dXU9tR" +
       "6YHI8/8CmHlrzrGmHtztP57c+/0guNh9MtjTa7dHqK+Dc67g344ZZ2wj/uCM" +
       "vP+VJ9+LSo8YWnTsnFOxIn3E6j+81ULj8WZPIcw3x0rvBdd8H+H87iP8kzPy" +
       "/jRP/jgqXQQIp4c7fkfYfnSn2PJTgYt9bIu7ju3cxTPyLuXJhah0H8CG7+8f" +
       "HiI7d8+dIstV4pP7yD5595E9fkbeE3lyOSo9fCCXR9t+RwCv3CnAfFdL3gco" +
       "332Az5+R92KevBfYOgCQuX5v8wjk++4AZL4/VXoGXOo+SPXug/zwGXl7efKB" +
       "qHQ/AEkd7C0dQfvgnY7fs+Ay96GZdx9a64y8v5gntaj04D60w03gI3j1O4WX" +
       "j9xqH97q7sPrnpGX7xyd+3h+FEA7sX17hO4Td4ouPykR76OL7z668Rl5bJ7Q" +
       "O6/HnNqgPkLI3AHC4rx4fqog3UeY3h2E544KNAoizziedi4/nnZuAVxfqEVs" +
       "vud9w43FxLPUI9D8HYC+nL98sii6+2V3f1jtM/JWeaLvXD17uMd/hM24HWwZ" +
       "EI+Tn2XkZ8yfuu6Tr91nSsq33rx88ck35/9udwb54FOiB5jSRT12nOOnQo/d" +
       "3+cHmm4VmB/YncnyC0KjqPSem34sAoYs/8sJPhfuyoN3j9+ofFS6ANLjJbdR" +
       "6crpklHp3uL/eLnXgOoflQMRxu7meJHPgtZBkfz29d3Bt5Mb9LtjtNnuxN1T" +
       "xyWmgPrYrQbjWOz90onzb8XHeQdnR+Pd53nXlG+/2R9+5ofNn919YqE40nab" +
       "t3KRKd2/+9qjaDQ/f/rCTVs7aOs+6pUfP/LzD7x8EM0/siP4SHqP0fbcjb9n" +
       "wFd+VHyBsP3lJ//RR/7em79XnBf4f0m5jtU1OQAA");
}
