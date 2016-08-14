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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v977zIu7x1Zdz9y28DneZrvyytHfvwX31+BvB3z/N/syUFnBduZ9iNif/q8f" +
       "zv+el6n/XWexlQ/R+u9feeGf/4MXPrmF8dDJRUcTrKl/7Q//6nf3vvCtr99h" +
       "DjsPFO/nHtvKGW2cYfD9LLmZV5Wy5P1blVVfl9Fsad+R/7p4tpZa2ZL4aDJ4" +
       "x/8ZWIuP/+n/vs1z8jnsDoo71X4Ov/yLjxEf/E7e/mgyyVo/Gd8++4Ptw1Fb" +
       "9Ev2n+0+feFf70IX59A1aX9vks/eIETPwXo8ONiwgP3LifqTa+vtQvLm4WT5" +
       "+GnLOTbs6WnsSGMgn1Fn+SunZq4fyKR8AXzFfad592kv3IHyzPTOjpi7zw8B" +
       "bwzyHRCwDFV3RCsfhQqh+/AeTfVvCXhv3OSA+t59d/XlEXnrMy/96jPf+NhL" +
       "z/xJHqIu6QEAifvaHVb8x9p87+Vvfuf373/iy/ncf89CDLZwT2+Vbt8Jndjg" +
       "5Hzfdyidt2XCeCyLN/vS2dl63a3bve5Hrq8iMdBXEZg0f2gbmq5vZXI9l8j1" +
       "7Tbp+Q9dZwZk81YfZ5rc9Q9cd5TNfs1HRHvxwvN7e3sfuvls5sL7M8+1PCRn" +
       "xrC3pTt0keNTFJcliwNdaXfW1W6WfS5LPnSgnwuW4mjhMqck8rLtwHQInQOS" +
       "yrLiPi/ZkLv7K8p93h4+4o2wXEfJpuaDuu3qVHf3Dve9oDK+jXkfeu/dTYLJ" +
       "NXPkVr/18f/5GP/B5YffwLL0qVMWc7rLf8i8/HXqPdLf24XOHTrZbZvik41u" +
       "nnStK74CdvEOf8LBntjqI5ffVhlZ8sFcwmeEyvSMuo9myQY4mJSJequZM8g/" +
       "FkNH82ced2evFXe526PCj+zbfeUuUeHjZ0WFLPmxE+b2NqbZ5G8NRre4Hk00" +
       "98NCDuUUr594/bw+cOCjz+3z+txdeP3puywlcl4PODwPTFXLF9itUyz9zBtk" +
       "6Tr4yH2WyLuw9NnXw9K9tqKEA58DEUW5E2N/9zUZ2zr2Dlg0nUf3qntI9vvn" +
       "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" +
       "Iku+F0JXZH17x8TnD/BeOYL46puAmMez");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HwTfL+xD/IW3XKk7O2fU5bPIX4bQfcBs54rvngpoOb6/ehP4HsoKnwDfL+/j" +
       "++W3Ht/9Z9RdzZJLIKKG7vaKdqTk48qH8HYuv6E3DyH09Gs/A8weNL3jtnfK" +
       "27e10pdfunrp7S+N/8P2Nvzg/evlHnRJjSzr+MOAY/kLnq+oei6Ky9tnAl6O" +
       "79EQevysuSqELmwzGZKdR7aN3hlCj9yxUQjdk/07Tvt4CF07TQtmtvz/cbqn" +
       "gIcc0YFht5njJE+H0DlAkmWf8bbOt3Ny1XBocg+9lk6OLTSeOXFJnT8iP7hQ" +
       "jrbPyG9JX3mp0//Iq5Vf2b7ikywxTbNeLvWgi9sHhXmn2aX0u+7a20FfF9rP" +
       "fv+BX7/87oOlywNbho/s+BhvT935vVzT9sL8hVv6m2//J+//+y/9cX5X9v8A" +
       "UlmuDd0vAAA=");
}
