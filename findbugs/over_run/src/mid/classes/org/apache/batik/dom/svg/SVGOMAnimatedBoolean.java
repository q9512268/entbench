package org.apache.batik.dom.svg;
public class SVGOMAnimatedBoolean extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedBoolean {
    protected boolean defaultValue;
    protected boolean valid;
    protected boolean baseVal;
    protected boolean animVal;
    protected boolean changing;
    public SVGOMAnimatedBoolean(org.apache.batik.dom.svg.AbstractElement elt,
                                java.lang.String ns,
                                java.lang.String ln,
                                boolean val) { super(elt, ns, ln);
                                               defaultValue = val; }
    public boolean getBaseVal() { if (!valid) { update(); }
                                  return baseVal; }
    protected void update() { org.w3c.dom.Attr attr = element.getAttributeNodeNS(
                                                                namespaceURI,
                                                                localName);
                              if (attr == null) { baseVal = defaultValue;
                              }
                              else {
                                  baseVal =
                                    attr.
                                      getValue(
                                        ).
                                      equals(
                                        "true");
                              }
                              valid = true; }
    public void setBaseVal(boolean baseVal) throws org.w3c.dom.DOMException {
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
    public boolean getAnimVal() { if (hasAnimVal) { return animVal;
                                  }
                                  if (!valid) { update(); }
                                  return baseVal; }
    public void setAnimatedValue(boolean animVal) { hasAnimVal = true;
                                                    this.animVal =
                                                      animVal;
                                                    fireAnimatedAttributeListeners(
                                                      ); }
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
              ((org.apache.batik.anim.values.AnimatableBooleanValue)
                 val).
                getValue(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableBooleanValue(
          target,
          getBaseVal(
            ));
    }
    public void attrAdded(org.w3c.dom.Attr node,
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
      ("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" +
       "Dq3CH1v+C2EuWC52IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R9YGKkvswlkTnWLVVRXwV8NhxslXsFjzLLGqpqvBhuP4tu8v+dqQyTWuR3Wj" +
       "lhdtAUiUD2Kmj2uUPMfHHuVxjQWbN3a5M4zCmaApC2mCIoi2UZEmyiX0YDRf" +
       "8IOkxWyoRSLPjLlFiLysyGTeYDGl2pqo2yktjJqEMHUaEyMSVIdVJkxNrCUo" +
       "ijWqTF2xB1V17mozcqMkTRFGwh5Gw3G+SmvLMaJadW0INdtDyUirVamBwtF0" +
       "g8a8se2t3cT37UDF0Ki5zqNVdSk3fcVdA9/P2a5rRmm8HXkmn3cVojbsb1gn" +
       "IAfLuIu1R9HMZRlbsSdTCYrdbiuD3NwDMWK8tICTa57UlBbACQWypeB2bU5o" +
       "VB40M3NYpQJai3im3lJTlm93TFbZLerQLMvy0cJujdyxEIy9NRlx2TwYMJPm" +
       "GmdWrSSqJY1GnwuywaghsHqyHA5X3shl1Z3u7ujEEnaCmgn15cylQppFqOHS" +
       "DrmGLXHd9RjgmIE456hFlK2tNv40n0IdpMo1XDEgqhQ7bmtWj1inuIUMR80R" +
       "Te+4dtCRFN4E6USbMOdm0Fa3Pd5Dlv1k5kebNkG3lLlJisC6DCPtQqZEo8R2" +
       "XpXbIRKCVGJAeZaxCbQJv84kNMpocbtZIpsezbbbWdrGGIGY10cY0WpOQErq" +
       "kUi2aombsblB5nVuUk9spjVNUbitT6Y0qoey0m+nqxDOvV2MulriSkJH8VSD" +
       "GRAozqZYO4cswqttYdbqLy1dY2EU2qlQfWBjjXadQnKjA4VzMg0ZveamuBvk" +
       "OD7f5ePA41cr3KohrASPIhSEKJVEJzWpTUe6kDerUVtdVznS4WWP6TRW1YE4" +
       "0qYZM++J/kpOxoTQHsNslfe7/E4eNbdNjGz0KUOd2lqtgeaB1dtGPShZaaY2" +
       "CLugPzTHB3IL5zPNcdvdIRMkrUHIUQK2STkjMseZuSaai2rYDVuTtepNN0Gk" +
       "swMYVutdzAnd/oTGRnHkjWpql+mMbINYdLZV24ERa+45hJQi/Ulz2pk1Ntp6" +
       "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" +
       "FowOSIrXqnvklvU3vIx16kthH88vnEr1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("D22s9MSH3khjx11OX6MrPg/Ku+JHqXy0vy3+vPjqyyP6x19vfXF/jU80hTwv" +
       "RrlCVS7vbxQefw48dcfRjsa6b/DMdx741asfOPp0eWDP8Im9n+LtydvfmetZ" +
       "bljecsv/4SO/9sN/5+U/Ko/A/y9OM8JNxC8AAA==");
}
