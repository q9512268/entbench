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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qnFbvipn4t4XeqHX+SM+Hf4vw5wGn9wxAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LpZh254zch3GhnUqGsQTy4LijmQNSxwk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LRqUJVVpvYXZSF/TkE6v1h9qy2ieFyBpiYlGvxxCDAL5mMvLjbYSI3CeGtkD" +
       "nJH5vo8bkKmCdYzI2o4/JIOg0hTBfYsXIbJdTNxQslpIHoHX3BRREGVextg6" +
       "LwhlshnVCggCXFSnYbfgyqg96q0S0StKeKNWSeYdARm7s/bEMVY1qQ6pC1/Q" +
       "BWldJt1uuVAolRmyW2opGLA/M0NsFuvtSR7M0WUfoUwzX2PY2KsRmkeyrUaL" +
       "azu1IhQtnWFhtbbnUUAFMTKixFWN1G2qBvHlubmcwWq9k19MdC2Q1iXgik2T" +
       "OM7n12WkosZsiV1MKXY4GZI+CxlIOZ5wujCddJghYDDVKLqAqkmzS9Kq78er" +
       "1YQo4AHjMDzXkR3amcJWkRgqTkzlKa0c9zyNmShrtT4rFCxeqQKHaLJGIj1c" +
       "JqUA87rLSrMXsmxsRBBmzZChzmMC1inrKmIb86C7nOXXJs4Fqm3CHjwX1515" +
       "fkTnOxIchJWwbQKnCEXRH0pflf2PG3uFd2/2tnL/cPRKR9KEv76Bt3TRgX3j" +
       "/Te82d/53JEDtQfe8B7YYs2lh4geOenMc3aA6FPve+lloferxbPb7d2Ol7vg" +
       "WfYP6mIg6geq2pxisvdhZFDS0yjv38J4/9EXzTuix79lfttGUCdvNZ+545S0" +
       "C2lwFoCVReDG728L7gv2zLkbPqa0I3cpjUy3n39qS+6nbj25+09JeyAN7vFy" +
       "lwG5xjWbxTuOl26C4/1pZLqj99KW40u3nuNjp6Slan3mYS933wGOB3eddyzf" +
       "dBMsMzVN9zB/bsvy5249y/wpaT+YBm/xchcBS0w8Tk/ferPs0kH4y1t2v3zr" +
       "2SGnpNXToLQZhJ3dPviOXPlWdN1ntuQ+c+vJNU9Ja6XBOzZdRx3YUN+x++Gb" +
       "NTFp131hy+4Lt55d75S0QRqQXu51gB1zcGd+R697s52X7uF+aUvvS7ee3vOn" +
       "pP1oGky93IOA3uiELf4d09nNMk13gH93y/R3bz1T+ZQ0NQ04L/fGo0wP79nu" +
       "yPI3Szbd+v7yluyXbz1Z95Q0Pw3MzaQxOebQwY6ldbMs0030P96y/ONbz/I9" +
       "p6S9Nw0SL/fAQZYndee7b5Zoeibra1uiX7v1RD98Sto/ToMPAFcZEO1dewxi" +
       "R/KDN0sydXT+YkvyL249yZ89Je2TafAxL/f6AyRP6syfvqHDlF7unsMfi6Vf" +
       "vjx0zYeom48n+c+9fOnON7w8+bPNefS9DxwvULk7JV/XDx4kPnB/3nZESc34" +
       "X9gcK7YzUr8EDM6Jn7B5udvSnxTwmV/c5P8VwP+4/F7uHAgP5vw0cHuP5vRy" +
       "t2e/B/N9BszMu3zpSc/s5mCWV0DtIEt6+9mNPhw+JLI5eR1tPv156KD2ZEuz" +
       "+16rMw4ssp46dIQ5+2R477ixv/lo+AX+8y+TzLu/W/3VzYdfvM4mSVrLnVTu" +
       "js03aFml6ZHlJ06sba+u851nvnfPb154em/Zds8G8E6TD2B77PivrFqG7WXf" +
       "RSVfesNvvf3XXv56dmbl/wM7MYViyz0AAA==");
}
