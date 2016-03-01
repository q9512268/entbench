package org.apache.batik.bridge;
public class SVGAnimateColorElementBridge extends org.apache.batik.bridge.SVGAnimateElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_COLOR_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateColorElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatableValue from =
          parseAnimatableValue(
            SVG_FROM_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue to =
          parseAnimatableValue(
            SVG_TO_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue by =
          parseAnimatableValue(
            SVG_BY_ATTRIBUTE);
        return new org.apache.batik.anim.ColorAnimation(
          timedElement,
          this,
          parseCalcMode(
            ),
          parseKeyTimes(
            ),
          parseKeySplines(
            ),
          parseAdditive(
            ),
          parseAccumulate(
            ),
          parseValues(
            ),
          from,
          to,
          by);
    }
    protected boolean canAnimateType(int type) { return type ==
                                                   org.apache.batik.util.SVGTypes.
                                                     TYPE_COLOR ||
                                                   type ==
                                                   org.apache.batik.util.SVGTypes.
                                                     TYPE_PAINT;
    }
    protected boolean checkValueType(org.apache.batik.anim.values.AnimatableValue v) {
        if (v instanceof org.apache.batik.anim.values.AnimatablePaintValue) {
            return ((org.apache.batik.anim.values.AnimatablePaintValue)
                      v).
              getPaintType(
                ) ==
              org.apache.batik.anim.values.AnimatablePaintValue.
                PAINT_COLOR;
        }
        return v instanceof org.apache.batik.anim.values.AnimatableColorValue;
    }
    public SVGAnimateColorElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "g94uu3AZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F+bXfukf3P17b/2NZ7+RXz38HxBZzbr2JAAA");
}
