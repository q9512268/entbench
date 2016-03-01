package org.apache.batik.dom.svg;
public class SVGOMAnimatedString extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedString {
    protected java.lang.String animVal;
    public SVGOMAnimatedString(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln) { super(elt, ns, ln);
    }
    public java.lang.String getBaseVal() { return element.getAttributeNS(
                                                            namespaceURI,
                                                            localName); }
    public void setBaseVal(java.lang.String baseVal) throws org.w3c.dom.DOMException {
        element.
          setAttributeNS(
            namespaceURI,
            localName,
            baseVal);
    }
    public java.lang.String getAnimVal() { if (hasAnimVal) { return animVal;
                                           }
                                           return element.getAttributeNS(
                                                            namespaceURI,
                                                            localName);
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableStringValue(
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
              ((org.apache.batik.anim.values.AnimatableStringValue)
                 val).
                getString(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public void attrAdded(org.w3c.dom.Attr node, java.lang.String newv) {
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
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrRemoved(org.w3c.dom.Attr node,
                            java.lang.String oldv) {
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
      ("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" +
       "SMGIr0nT/gfAO6/IGR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
