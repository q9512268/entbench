package org.apache.batik.anim.values;
public class AnimatablePreserveAspectRatioValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static final java.lang.String[] ALIGN_VALUES = { null, org.apache.batik.util.SVGConstants.
                                                                       SVG_NONE_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMINYMIN_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMIDYMIN_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMAXYMIN_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMINYMID_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMIDYMID_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMAXYMID_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMINYMAX_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMIDYMAX_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMAXYMAX_VALUE };
    protected static final java.lang.String[] MEET_OR_SLICE_VALUES =
      { null,
    org.apache.batik.util.SVGConstants.
      SVG_MEET_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_SLICE_VALUE };
    protected short align;
    protected short meetOrSlice;
    protected AnimatablePreserveAspectRatioValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatablePreserveAspectRatioValue(org.apache.batik.dom.anim.AnimationTarget target,
                                              short align,
                                              short meetOrSlice) {
        super(
          target);
        this.
          align =
          align;
        this.
          meetOrSlice =
          meetOrSlice;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue)
                result;
        }
        short newAlign;
        short newMeetOrSlice;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue toValue =
              (org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue)
                to;
            newAlign =
              toValue.
                align;
            newMeetOrSlice =
              toValue.
                meetOrSlice;
        }
        else {
            newAlign =
              align;
            newMeetOrSlice =
              meetOrSlice;
        }
        if (res.
              align !=
              newAlign ||
              res.
                meetOrSlice !=
              newMeetOrSlice) {
            res.
              align =
              align;
            res.
              meetOrSlice =
              meetOrSlice;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public short getAlign() { return align;
    }
    public short getMeetOrSlice() { return meetOrSlice;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue(
          target,
          org.w3c.dom.svg.SVGPreserveAspectRatio.
            SVG_PRESERVEASPECTRATIO_NONE,
          org.w3c.dom.svg.SVGPreserveAspectRatio.
            SVG_MEETORSLICE_MEET);
    }
    public java.lang.String toStringRep() {
        if (align <
              1 ||
              align >
              10) {
            return null;
        }
        java.lang.String value =
          ALIGN_VALUES[align];
        if (align ==
              org.w3c.dom.svg.SVGPreserveAspectRatio.
                SVG_PRESERVEASPECTRATIO_NONE) {
            return value;
        }
        if (meetOrSlice <
              1 ||
              meetOrSlice >
              2) {
            return null;
        }
        return value +
        ' ' +
        MEET_OR_SLICE_VALUES[meetOrSlice];
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
      ("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" +
       "dZsbnE42TgGbn37hp/5277Mv7B7LyJ6+JSk6PmableXc37dl7m/B3w74/m/2" +
       "ZUxlDdtV+cHafmpw7TA3CIJM/e84i6x8Cua/f+35f/7Lz39qy8aDJxMSGuTb" +
       "v/pHf/N7e1/602/eZg07DxQf5h7L5IRWzzB4Litu5F14Vrxvq7LSazKaLezb" +
       "8l8Xz9YSk6XLR4vB2/5Pz9E+8ef/+xbPydew2yju1HgFeennH6194Lv5+KPF" +
       "JBv9xPrW1R9sLY7GFr7i/sXuUxf+9S50UYGu6vv7lnz1BiFaAbl6dLCZAXub" +
       "E/0n8+5tknnjcLF87LTlHJv29DJ2pDFQz6Cz+t2nVq4fyqR8AXzYvtO887QX" +
       "7kB5Rb69I+bu8yPAG6N8dwQsY2J5qpPP0oiheym21eBuDil2QItAfe+8s/ry" +
       "iLz1mRf/8dPf+tiLT/9ZHqIuWRFgkgqnt9kNHBvz/Ze+/d0/uO/xr+Zr/12a" +
       "Gm3ZPb2NunWXdGLzk9N976F03pIJ49Es3uxLZ2frdTdv9bofvbZI1MhaJGDR" +
       "/JFtaLq2lcm1XCLXtluo5z50rdur0zc5qkuL195/zTNX+z0fUV3t+ef29vY+" +
       "dOOZzIX3V56reUjOjGFvC3foIseXKDErtANdTW+vq92s+mxWfOhAPxcc05vG" +
       "sxyylrdtJ27F0Dkgqayq7tOSTbm7n1Hu0/bQEW01x/fMbGk+6Ntmp5a/d7gn" +
       "Bp3rW4gPoXff2SS6uWaO3Oq3P/E/H5U+MPvw60hLnzxlMadR/kr3pW823qX/" +
       "9C507tDJbtkwnxx046Rr3R2aYIfvSScc7PGtPnL5bZWRFR/IJXxGqEzP6Pto" +
       "VqyAg+mZqLeaOQP8Y2voaP3M4+741eKueGtU+NF9uyfvEBU+cVZUyIofO2Fu" +
       "b+nStHSzJ9wU2VaN3g8LOSunaP3ka6f1/gMffXaf1mfvQOs/uEMqkdN6QOF5" +
       "YKrTPMFmTpH0U6+TpGvgq++TVL8DSZ97LSTd45pm3AtFEFHM2xH2j16VsK1j" +
       "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" +
       "8efedKXu7JzRl68ifx1D9wKzVczQPxXQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("cv7+5g3w92DW+Dj4fnGfv1988/m774y+K1lxCUTU2N9eswpmPq9xyN7O5df1" +
       "biGGnnr1p3zZo6S33fIOeft2Vv/qi1cuvfXFwX/Y3mgfvG+9zEKXJonjHL/c" +
       "P1a/EITmxMpFcXl71R/k/D0SQ4+dtVbF0IVtJeNk5+HtoLfH0MO3HRRDd2X/" +
       "jsM+FkNXT8OClS3/fxzuSeAhR3Bg2m3lOMhTMXQOgGTVp4Ot8+2czBoOTe7B" +
       "V9PJsUTj6RMXzfkj8YNL4WT7TPym/rUX29xHXiF/afsST3fUNM2wXGKhi9tH" +
       "gTnS7GL5HXfEdoDrQvOZH9z/a5ffeZC63L8l+MiOj9H25O3fvNFuEOev1NLf" +
       "fOs/e98/efFP8vuu/wfT6Mc/vS8AAA==");
}
