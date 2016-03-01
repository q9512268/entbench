package org.apache.batik.gvt.font;
public class GVTLineMetrics {
    protected float ascent;
    protected int baselineIndex;
    protected float[] baselineOffsets;
    protected float descent;
    protected float height;
    protected float leading;
    protected int numChars;
    protected float strikethroughOffset;
    protected float strikethroughThickness;
    protected float underlineOffset;
    protected float underlineThickness;
    protected float overlineOffset;
    protected float overlineThickness;
    public GVTLineMetrics(java.awt.font.LineMetrics lineMetrics) { super(
                                                                     );
                                                                   this.ascent =
                                                                     lineMetrics.
                                                                       getAscent(
                                                                         );
                                                                   this.
                                                                     baselineIndex =
                                                                     lineMetrics.
                                                                       getBaselineIndex(
                                                                         );
                                                                   this.
                                                                     baselineOffsets =
                                                                     lineMetrics.
                                                                       getBaselineOffsets(
                                                                         );
                                                                   this.
                                                                     descent =
                                                                     lineMetrics.
                                                                       getDescent(
                                                                         );
                                                                   this.
                                                                     height =
                                                                     lineMetrics.
                                                                       getHeight(
                                                                         );
                                                                   this.
                                                                     leading =
                                                                     lineMetrics.
                                                                       getLeading(
                                                                         );
                                                                   this.
                                                                     numChars =
                                                                     lineMetrics.
                                                                       getNumChars(
                                                                         );
                                                                   this.
                                                                     strikethroughOffset =
                                                                     lineMetrics.
                                                                       getStrikethroughOffset(
                                                                         );
                                                                   this.
                                                                     strikethroughThickness =
                                                                     lineMetrics.
                                                                       getStrikethroughThickness(
                                                                         );
                                                                   this.
                                                                     underlineOffset =
                                                                     lineMetrics.
                                                                       getUnderlineOffset(
                                                                         );
                                                                   this.
                                                                     underlineThickness =
                                                                     lineMetrics.
                                                                       getUnderlineThickness(
                                                                         );
                                                                   this.
                                                                     overlineOffset =
                                                                     -this.
                                                                        ascent;
                                                                   this.
                                                                     overlineThickness =
                                                                     this.
                                                                       underlineThickness;
    }
    public GVTLineMetrics(java.awt.font.LineMetrics lineMetrics,
                          float scaleFactor) {
        super(
          );
        this.
          ascent =
          lineMetrics.
            getAscent(
              ) *
            scaleFactor;
        this.
          baselineIndex =
          lineMetrics.
            getBaselineIndex(
              );
        this.
          baselineOffsets =
          lineMetrics.
            getBaselineOffsets(
              );
        for (int i =
               0;
             i <
               baselineOffsets.
                 length;
             i++) {
            this.
              baselineOffsets[i] *=
              scaleFactor;
        }
        this.
          descent =
          lineMetrics.
            getDescent(
              ) *
            scaleFactor;
        this.
          height =
          lineMetrics.
            getHeight(
              ) *
            scaleFactor;
        this.
          leading =
          lineMetrics.
            getLeading(
              );
        this.
          numChars =
          lineMetrics.
            getNumChars(
              );
        this.
          strikethroughOffset =
          lineMetrics.
            getStrikethroughOffset(
              ) *
            scaleFactor;
        this.
          strikethroughThickness =
          lineMetrics.
            getStrikethroughThickness(
              ) *
            scaleFactor;
        this.
          underlineOffset =
          lineMetrics.
            getUnderlineOffset(
              ) *
            scaleFactor;
        this.
          underlineThickness =
          lineMetrics.
            getUnderlineThickness(
              ) *
            scaleFactor;
        this.
          overlineOffset =
          -this.
             ascent;
        this.
          overlineThickness =
          this.
            underlineThickness;
    }
    public GVTLineMetrics(float ascent, int baselineIndex,
                          float[] baselineOffsets,
                          float descent,
                          float height,
                          float leading,
                          int numChars,
                          float strikethroughOffset,
                          float strikethroughThickness,
                          float underlineOffset,
                          float underlineThickness,
                          float overlineOffset,
                          float overlineThickness) {
        super(
          );
        this.
          ascent =
          ascent;
        this.
          baselineIndex =
          baselineIndex;
        this.
          baselineOffsets =
          baselineOffsets;
        this.
          descent =
          descent;
        this.
          height =
          height;
        this.
          leading =
          leading;
        this.
          numChars =
          numChars;
        this.
          strikethroughOffset =
          strikethroughOffset;
        this.
          strikethroughThickness =
          strikethroughThickness;
        this.
          underlineOffset =
          underlineOffset;
        this.
          underlineThickness =
          underlineThickness;
        this.
          overlineOffset =
          overlineOffset;
        this.
          overlineThickness =
          overlineThickness;
    }
    public float getAscent() { return ascent;
    }
    public int getBaselineIndex() { return baselineIndex;
    }
    public float[] getBaselineOffsets() {
        return baselineOffsets;
    }
    public float getDescent() { return descent;
    }
    public float getHeight() { return height;
    }
    public float getLeading() { return leading;
    }
    public int getNumChars() { return numChars;
    }
    public float getStrikethroughOffset() {
        return strikethroughOffset;
    }
    public float getStrikethroughThickness() {
        return strikethroughThickness;
    }
    public float getUnderlineOffset() { return underlineOffset;
    }
    public float getUnderlineThickness() {
        return underlineThickness;
    }
    public float getOverlineOffset() { return overlineOffset;
    }
    public float getOverlineThickness() {
        return overlineThickness;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hoG+GnoK/1z1PyVBvapfMAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F4WopdlGt94gcGESGgLUhJetcr89xKBB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ay2TCDPRdb0+MEpRuUmHbMNSN50KtGxVgrQ56NuS3HOsxbJtJUMx8KnGcE3M" +
       "5SBEiigirP0gReu1Xq+GTZFxD0NDswmHcyEpViA7At6AAqHmOujiWKoT8djw" +
       "OqsJDg0E1LTkGJ2X16FhLCaRqtd52po2RrUyq2O+RavLJK728Q2uNkuIrlMi" +
       "YSBzhRLN4jKARKYol002Jo1Ga427xLIrOLVGeQbWRRrPUeSaJ1EdH/iGUYVC" +
       "fp1UlHrJs9E61/X7dJXFEt9C2jg+tyO6zGwELozRFToZusKm2ewEFay+kPl6" +
       "Q3I3g0jm5rzojT2v6Pa56jSNl9jMbi/rpjj0uOYgHZXrHKMQ6LzKFpHNJK3O" +
       "17RT430UePguP/YbqM+zatgLq1xHUv3NuGOsOKFW2ZS6DtdI1oJhI+lGdbpQ" +
       "13YGMJIi9GbWinhXGTab+Wuy/35jr94ezN8yHh6G1k00y/irG3i7lhzZ7z18" +
       "M5v/3Vk4cYD2yJvZI1ujhexg0GNnnXHODwV96r0vviRRv4pc3G3L9oLCPYHj" +
       "vtWUI9k80tT2ZJJ7CCOHkp0wed8OxvtOviDeEz397fBbtoI6e4v4wl3n5N2T" +
       "JRcB2JUcNPfbeYeCvXDbDR892pO7lD3Mto1/ZkfuZ249uYfPyXtVljwQFC4D" +
       "cq1rNnn3HC/dBMeHs4fZTtyLO44v3nqOj5+Tl6n1hUeDwkNHOB7dLd6zfN1N" +
       "sMzVNNt7/Pkdy5+/9Syhc/LemiVvCgr3ApaYfJqevvlm2WWT8Fd27H7l1rND" +
       "z8lrZElpOwl7+/3rPbnyrRi6z+zIfebWk2ufk4dnydu3Q0ce2Qjfs/vRmzUx" +
       "2dD95o7db956dtQ5eUyW9IPCKwC70dEd9T29wc0OXrb3+sUdvS/eenrvPCfv" +
       "x7NkFhQeAfTGZ2zN75nOb5ZptnP7uzumv3vrma7OydOyRAgKrz3J9Phe656s" +
       "eLNksy3rL+/IfvnWk/XPyQuzxN46jekphwX2LJ2bZZltfv/xjuUf33qWP3lO" +
       "3nuyJA0KrzrK8qzhfPfNEs3OUn1tR/Rrt57oh87J+wdZ8n4QKgOi1LXHF/Yk" +
       "P3CzJLNA5893JP/81pP8uXPyPpklHw0KrzxC8qzB/NkbOgQZFB44/gFY9jXL" +
       "a6758HT7saT4uZcu3f3ql6Z/tj1jfvBB4z1k4W4lNM2jB4CP3N/perKi5fzv" +
       "2R4HdnNSvwwMzpmfpQWF27N/GeALv7Qt/48B/9PKB4XbQHq05KdB2HuyZFC4" +
       "I/9/tNxngGfel8tOaOY3R4u8DFoHRbLbz2714fjhju2J6WT7Oc9rjmpPvjR7" +
       "6AcNxpFF1lPHjh7nnwgfHBMOtx8JPy9+/qX+6N3fq/3q9mMu0eTTNGvlbrJw" +
       "1/a7srzR7KjxE2e2dtDWnb1nvv/Ab9zz9MGy7YEt4L0mH8H2+OlfTuGWG+Tf" +
       "OqVffPVvve3XXvpGftbk/wOT9Pmbuz0AAA==");
}
