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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/3WV9AncAs3j90H6ZF59VwSSIICU1Rwv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("uQvoY6/qMgewkguuPub3uB696/r17sqw8qUXbl572wuzPypu/x1f671Ol67p" +
       "sW2fvuJw6vmKH2i6WazC9d2FB78A9D2HUe2ia19R6QFQ5zzvvWdH/UxUevNF" +
       "1IAS1Kcp339oOKcpo9Ll4v9pugqIKCd0IKHYPZwmQcDogCR/RP0jq4Rf9q7a" +
       "qfS58Dzp3qkE+FDFCh/0yMsJ7LjL6VuGedJc3KM/SnDj3U36O8qXX6BGP/TN" +
       "2s/vbjkqtpxl+SjX6NLV3YXL4yT5qXuOdjTWlf7T33rol66/+yihf2jH8Im6" +
       "n+LtiYuvFHYcPyouAWa/8rZ//L1/74WvFufO/w/F0KKc4DAAAA==");
}
