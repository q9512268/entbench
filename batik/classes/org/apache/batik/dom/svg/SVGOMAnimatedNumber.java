package org.apache.batik.dom.svg;
public class SVGOMAnimatedNumber extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedNumber {
    protected float defaultValue;
    protected boolean allowPercentage;
    protected boolean valid;
    protected float baseVal;
    protected float animVal;
    protected boolean changing;
    public SVGOMAnimatedNumber(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln,
                               float val) { this(elt, ns, ln, val, false);
    }
    public SVGOMAnimatedNumber(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln,
                               float val,
                               boolean allowPercentage) { super(elt, ns, ln);
                                                          defaultValue = val;
                                                          this.allowPercentage =
                                                            allowPercentage;
    }
    public float getBaseVal() { if (!valid) { update(); }
                                return baseVal; }
    protected void update() { org.w3c.dom.Attr attr = element.getAttributeNodeNS(
                                                                namespaceURI,
                                                                localName);
                              if (attr == null) { baseVal = defaultValue;
                              }
                              else {
                                  java.lang.String v =
                                    attr.
                                    getValue(
                                      );
                                  int len =
                                    v.
                                    length(
                                      );
                                  if (allowPercentage &&
                                        len >
                                        1 &&
                                        v.
                                        charAt(
                                          len -
                                            1) ==
                                        '%') {
                                      baseVal =
                                        0.01F *
                                          java.lang.Float.
                                          parseFloat(
                                            v.
                                              substring(
                                                0,
                                                len -
                                                  1));
                                  }
                                  else {
                                      baseVal =
                                        java.lang.Float.
                                          parseFloat(
                                            v);
                                  }
                              }
                              valid = true; }
    public void setBaseVal(float baseVal) throws org.w3c.dom.DOMException {
        try {
            this.
              baseVal =
              baseVal;
            valid =
              true;
            changing =
              true;
            element.
              setAttributeNS(
                namespaceURI,
                localName,
                java.lang.String.
                  valueOf(
                    baseVal));
        }
        finally {
            changing =
              false;
        }
    }
    public float getAnimVal() { if (hasAnimVal) { return animVal;
                                }
                                if (!valid) { update(); }
                                return baseVal; }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableNumberValue(
          target,
          getBaseVal(
            ));
    }
    protected void updateAnimatedValue(org.apache.batik.anim.values.AnimatableValue val) {
        if (val ==
              null) {
            hasAnimVal =
              false;
        }
        else {
            hasAnimVal =
              true;
            this.
              animVal =
              ((org.apache.batik.anim.values.AnimatableNumberValue)
                 val).
                getValue(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public void attrAdded(org.w3c.dom.Attr node, java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrModified(org.w3c.dom.Attr node,
                             java.lang.String oldv,
                             java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrRemoved(org.w3c.dom.Attr node,
                            java.lang.String oldv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
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
       "gOs3DqH/xusD/Z7jaulSeWqifoL1kbtg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fXPRvDGuPFhgPdrHOgf3odcKtwGu3z+E+/uvq6ZP4JZoHr8L0ieL5rtiUAQB" +
       "pFPN8dLbgD72qg6DAC+54OhkcQ7s0duOaO+PFStffOH6tbe9sPij8vTg8dHf" +
       "+5nKNT2x7dNHJE7d3+uHmm6WUrh/f2DCLwF9z2FWu+jYWFy5B7QFz5fes6d+" +
       "Jq68+SJqQAna05TvP3Sc05Rx5Wr5/zRdDWSUEzpQUOxvTpM0wOyApLhF/COv" +
       "hF/2rNup8rmMPNtLpwrgQxMrY9AjL6ew4yGnTykWRXN51v6owE32p+1vKV96" +
       "YTj6wW+2fn5/SlKx5TwvZrnGVO7bH9g8LpKfuuNsR3Pd23/6Ww/90v3vPiro" +
       "H9ozfGLup3h74uIjiYTjx+Uhwvwfv+2Xv/fvvvCVct/6/wHQo0UdBDEAAA==");
}
