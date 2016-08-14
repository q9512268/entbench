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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xeX/Amw0VQRLGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bdsL82vD9A/v/v03/eYzX8uvLv4Pj0i2RxolAAA=");
}
