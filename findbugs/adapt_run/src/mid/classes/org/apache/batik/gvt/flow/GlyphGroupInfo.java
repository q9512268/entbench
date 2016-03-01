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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zs/OS6H4fPCP//ld5La/Plck/Jcpdk16Jvp/LnK3eq0jIFUu2P2vq7/76hoI" +
       "Nb2kOq0pW9K0N+GeEwoyKx13mcuplPgNNzg0DSOh+WAFvLHIwsK2mFdwzxUS" +
       "/Lzl/Yef21j1msBa3O88JdPbVz5/l/7nI2EkQT7fyK3tZjuAVTGxtMU/I8lx" +
       "zeAJPRXtBrFMSWYX6XI6RWEJ2bXCV8QJ/WiOv5e79Lvnxx0vXr2n4y1wlUFS" +
       "rViQT2GdFSlmXTQf7Tt85FD9jP08AZXjcrVtn78LKCzy82p3bpsGbC4W0Xeh" +
       "vQTwb7Hr/EJGquK6rlJJ83ouXi7LFPHnWQWVCN/1Okn0gzfueOeXx+6uEn4V" +
       "EBE8dFM+W6PGr3v7U760CmqGIkHCQz8Y3XfntJ7zj3B6J3kjdUemsKoDczi0" +
       "X38g9XG4vfK3YVI1SBple4e5XlLTmBIHQeFWdtsJu9C8/vwdktgOdOWKk5O9" +
       "UcrF1ls2uJd+Octb5k3CmCHCE+XlnGIub+dhczq3ThhPz2AwqaJJKqc7F9Kw" +
       "SrVhUdlfgE2f4Vg1LOiyeUpkOMQBGyxdo5gss32iVlX0SG5zC53F/GN2gX+s" +
       "4q7pKHvhoWNlb9w0ZUJhkYqztfmUoPP9HcnL4Jnr/jZt7fkjG0uoPmd6vMM7" +
       "5f2r9j23fK58U5jvjIVtC3bU+URd+RatNSlLm1p++G4XduV2EUbFZj43Hb+O" +
       "5jRMuIZF3NUD+rZgA9JVyGhCYfGA4QxLm5nFi6alKYPxMmfbzyY/svjePW/y" +
       "+i5DiscKbC/hXStyaWEa8pkJxyl2yXeKSAt0XIM1TJLCck03u+GMmzqbFb4a" +
       "RmIdrMZm6wkjLqx5XSqoFHziLV5fKua1F/+3gxY/NhvFysdGyq36qwpXPV7K" +
       "2BRZxng9IthyamxSAV50Q0Df97HZgY0pJAkYu5NDHA1yMadZyduzAqb7ATad" +
       "lntzmR88XI8Xh+QbX/mofv1HTx4tSED5e6lVktHlBOU5WBBM9m7kV0jWCIw7" +
       "6+DqyxrVg8d5CVAnyeBU1hozQc1M3s7LHl1R9fpTv27d+HIZCS8jteAkiWUS" +
       "38SSGtg9UmtEVxMZ44ILxUoaq4amkUMlBeBtNfL70/m9WuFK+ZuxFjhm2ytz" +
       "tnfHafvb7cX9jXj2deUBU4HPQ0g0+R5tETYtnPYmbO4Q89ziC+v/EPkubO6E" +
       "ipxqiWI87y6RZwcc7TbPdh+e9zrhe3ehZvyoGakdxu1fj57Wiqrnvi9B1P3Y" +
       "3M/IRFWy2PJA9gdKZD/JFiErSjH2Dwdqyo+akeoRJUFjktjqX+IR9JESBcWc" +
       "1Gmz6vQR9LFAQf2ooaSWEqPZama7R87HvwQ5n8LmF4zUoT27/Xn/qkTeE+GY" +
       "Y/Oe48P76UAd+VFDQDChyqTFXO6ZEqVshWOuzWeuj5QvBErpR81IeHgUz872" +
       "iPhiiSLiSV4BVETEVwJF9KNmpBxXBZ6v9Aj5hwAhM8WY5X6z3P8uZq5sQjDr" +
       "zfB7KcMfpey9bteexJp7FmSfFXQzSGO6cYZKR6nqmqpOFBv5JeOpcPTbYvR7" +
       "NeYAFdVy4QNGP9KAUuHdgL73sXkbAuYwZa6nddw1HIW/cyKvKEzQHuiY28h0" +
       "ONbZ8q8rHbofaQC8fwb0fYzN3yH4AvSBXA53QP9jfEDjo+9LbckvLR20H2kA" +
       "sM/9+0K82vwMts4AeqldQjiQj48P5FlwXGbLfVnpkP1IA2DVBfTVY1PJSH3W" +
       "xZ2SIIc8VDU+yDGPxW3x46Uj9yMNQBfUNxWbZkaaAHmssCBy0Ld8YfSYqsgM" +
       "OBI2hETp6P1IAxB2BPTNwaYNahZAvyKbSRzMM8fH4m1wjNiCj5SO2Y80AFc0" +
       "oG8BNvOhXrIx52pKB/dp44MbbZ2yhU+VjtuPNABbV0Dfedicg1sOmlcmOrAX" +
       "jg9s3JelbdnTpcP2Iw2AtjygrxebJSJ7xzwVsgO95wtD5+9wcdsyZss/Vjp0" +
       "P1IPPNdDkUUc40AA/nXYrIYUblHWj1U3H+V5KFU+qisJRxtrvrA2GrBrMicQ" +
       "v0zp2vAjDQAbD+jDRB66XNQy/bnthwP6itJBZ8Ct8r/twMepUwq+KRPfQcn7" +
       "9zRUT96z7k/i9U72W6UJMVKdTKuq+/G/67zSMGlS4eqaIJ478Zd8oc2MTPX9" +
       "4gQsin8odmiTGK8xclKx8YyUQeseuYWRRu9I2LLxf/c4IK11xkG9JE7cQ0CQ" +
       "MhiCpxnx4G8KTO68ZxDvSzLiiWNub5E1CZl0IpO4tiMdec/4+Nd/2Yf5afH9" +
       "35B8YM/K1VcePece8aGErErbtuEsdTFSJb7Z4JPiC4HZvrNl56pcMe/4xIdq" +
       "5mQ3OE1CYMetp7vKzVFYrgb6xjTPVwRWZ+5jgtf2Ln7yhR2Vh8IktIGEJEZa" +
       "NhS+WcoYaZPM3BAr9lZ5vWTyDxy6at/Z+NKnr4ea+fN6It7LtAVRDMk3P/lG" +
       "X9Iwbg+Tml5SAfs3muGvvS7aqvVTedTMe0ldGYf6KPc2ciI6soRfBnLN2Aqt" +
       "z93FD20YaS98X1/48VEt+Cw1l+DsOE295xVK2jDcvVyzS0UgQ02Drw3FVhmG" +
       "/aFC5WGuecPAtRr6Hl4s+x8Jk42R4isAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lcHEZqnQdH+p4Z1GfwOYtRB015yTsImK8+qAtbaGEDosM2pS21QPsHkcI7Al" +
       "utPKmMKyFoZ0wISH59NyjC7xsN9dLwJp6KqNTUUW6IUzW2aJ6QkBxzW6mj9A" +
       "aT+CbDnBTcemKquA8/TammFwzISjhg0jZh+rC5i9tnti0kJUoSzweplXkuHY" +
       "HXjVsFym0Km+EmFSUDuyjSJdtcxiNs+senIHGQrtciTPiQYtbqlFa2ZSBDpK" +
       "Bx7md6ya4vZnXMp4ppptZ1C8tg1OgrZlC2tbsdZXW9BiOk62ikQq9dCh060L" +
       "b6dGf0wklWmPqU7oQUtzKsiqDBRvtlQ7KqrwXk+PGGAANo49WKbYdLwMOt3M" +
       "GoiY2V8p1Q5URubpDBou1p1trFPbJVJbbsIpJ+J9uMnLqT9v9JLFVvHSMSFi" +
       "lVGlbTbwrjyfVUKacGYrbNjuEtUto+jyVl9lxFLFiYmiu36SeXy9Pu3Vp4vy" +
       "SJ1CXmCuq91JiiZjso0ZNVd0kq7bZAVMajaZhoc7YsWWWr0NXiu3l9s0Eud1" +
       "HWuJhL81mkJ1EWQjrcogMT7oulW+YYaTNYzr5W5Pbo3rdmIQjiUJY6Q+HlPJ" +
       "vCF4CSmmjIyivUEKvI0lqniOwLhNo5kMzQFegbyGtOr0y/Iq7dgLD94mWeKb" +
       "XcVcq7g2bdhTG9YNoSmgXW5UmVfKPJaQk1niczNPZdFRvZFZrfIaIjlnpbI1" +
       "0grTpSX16vi2xssbsByYqJy+KBuNLFoYiLEAnnpAKY6erqqmjeGStYz8tdVo" +
       "VjlkhjBQj+9IW5ijicZc78ttiO5YZDS2u3B7oy+3QVlxjICnhY7tJPZyWu7x" +
       "DZocNzVJq1JeVluPgB/fIUYmHATKWCKXnKx4Cs7X8e56M8L8+sDroJkQTGAc" +
       "mvrQ0pkYZJmazSDWQOscXhMIvSx22qN2a7FdTjpTtiaTSzFeSOwqk4yVjY3W" +
       "TTIK+Xq1Z3TnQlbHYYtbWNZ4YI1FtCmSE1Lc0GBqDr2wmU6bcm3dIGxssSEW" +
       "TF2aYdNahnD1lbzE4pHdjjKzifc1xgyNbUNNDCOlQ7zjjc3OdJSNKbamzYCP" +
       "UvOX3jJkO801RhtsqHETdbbm8aExA/6fuEVHQ4pr9Alh1dXnAxyJp45KrGYb" +
       "Wan5ur6pdnsSpG376z6ZjborawbXFxV2qMr1ZT3qqoGpjFp1c6NWzFk2RLZd" +
       "lFiPm1MCQ0ZcwzbJth2UGwNVc9YDHq50YYeIGahRrvTr8HrDJDFKGEtXH9nW" +
       "yAYMxDruZkqpA1P0Q4er9gi4LTbNiTircvS4i0ipDI97Pa0utoXytk1xqYSk" +
       "aE2wG1tmOGqawjCVVNlRFKLrxXGrua0M9PrMHM+W8Zxhmz14QU7CWt5u2oSb" +
       "3GS4UWZDZSET621fHfMZw9TNLupVN/bQatnYmIVn9QrR0SoBVW8O1+xiGvVS" +
       "DA77TUgPUZRRVRneLoSyaCcrbkg0VRHMaUO3tHk1Zj1X89iImNrzRozQhqvq" +
       "/gQwH+5tYCKxt/MoNVR6TONpthHjOdvANkkbKzc2mh5v5TiGRDusAFI5bqi3" +
       "HUHQ0ApBQP50FvVmgup2JbsqIN2yiPU7QnlpxTSfJtE6ImAqakaMpY3WlSyE" +
       "14TdHhFqu2y3+WatNh2OtpDqJ4sNV7MSuinXW0k9gpINY4TCZlnu85w50ny8" +
       "kfHCpFHLcAeyGgIOSzWBZsS+PumvlmWIgmp4NmYod4waS6VHo3hd1uuBBjMT" +
       "btpA56PY8uuB7lkTql9PNbef1mdbYWTExmom8fyq0YMHg9SENLTXr1ZThwJT" +
       "ENdGldaIAR53mPopStX7E7ZWl9P2epwNLEsarlSMrLZkt9ILWTSxGN3QILQ8" +
       "1CF4ZmKK2W0gWLM+Y6B+VdQMztCMukKRERmpyYqM9UlnTKu4jNKc1UK78joa" +
       "ulgt1BgDQtOevsS8EcKC5meMkYT4up+JnVk0V2upPeHEDS/JZcyeJyY88PHt" +
       "gofFRb3nJD2KpElZGS7GZUkLZorMMUiTiBqujK2lCVgIbmtKAsnlYd+PUEMp" +
       "m8NaL8EHCSHybcZBOMilpo3eRp2XJx5Y");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mRFmjHgrar0e48pyLU4MfcIYFVenZmatz2mwZvVqccCbTX8whIllkjWQThuu" +
       "zJRxoz6tQmhdJJNya1N1y+2YJeEGlop92G5ra3GbjSvCfFSB29EG6YgLj4KU" +
       "TguTqJWhcUTCR7Wui8bltE47KMyjVkwQxEc/mm8d/ac729J6uNi9O7xuart4" +
       "nvHtO9i1Sm+1Q3m42Xn4e/b4/7HNzmNHR6X8cOupW10pLS7FfP2zb7ypsz9b" +
       "Pb+/C9pISpeTIPwx11gb7rGm7t+dG548z/0gePh9MvjTe65HqG+Ac67g344Z" +
       "Zxz/ff+MvP+VB99NSg/NjeTYvaZiJ/mI1X9wuw3C482eQpgfapXeCx5hH6Fw" +
       "9xH+yRl5f5oHf5SULgGE48OTuiNsf/xOseW3AKV9bNJdx3bu0hl5V/LgQlK6" +
       "F2Aj98/9DpGdu/hOkeVT4hP7yD5x95E9ekbeY3lwNSk9eCCXR8d1RwCvvVOA" +
       "+WmUug9QvfsAnz0j7/k8eC/QdQDg4MYzySOQ73sHIPNzpdJT4NH3Qep3H+SH" +
       "z8jby4MPJKX7AMjuwZnQEbQPvtPxexo8i31oi7sPrX5G3l/KAyQp3b8P7fDw" +
       "9gge+k7h5SPn7cPz7j689hl5+YnPuY/lR/jGiWPXI3Qff6fo8hsOq310q7uP" +
       "jjsjj8+D/s7qDU4dLB8hHLwDhMX98Pw2wGYf4ebuIDx3VAAriDzjytm5/MrZ" +
       "OQmYvthI+Pys+qYHguvA0o9AT98B6Kt54uNF0d0vvfvD6pyR5+WBuTP1/OHZ" +
       "/BG2+Z1gS4F4nPwMI79T/sQNn3/tPlnSvvnm1UuPvyn8u92d44PPii4PSpfM" +
       "lesev+l5LH5vGBmmVWC+vLtLFRaEJknpPbf8OAQMWf6XE3wu3pUHaY/erHxS" +
       "ugDC4yWzpHTtdMmkdE/xf7zca2DqH5UDHsYucrzIZ0DroEgefX13Ye3kwfru" +
       "amy6uyn3xHGJKaA+crvBOOZ7v3Di3lrxod7BfdDV7lO9V7VvvUkPP/2D2s/u" +
       "PqnQXCXL8lYuDUr37b7uKBrN75Q+d8vWDtq6t/vSDx/6+csvHnjzD+0IPpLe" +
       "Y7Q9c/PvF0gvTIovDrJfevwffeTvvvm7xTn//wMSCovIQTkAAA==");
}
