package org.apache.batik.dom.svg;
public abstract class SVGGraphicsElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.apache.batik.dom.svg.SVGMotionAnimatableElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_TRANSFORM_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList
      transform;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected java.awt.geom.AffineTransform motionTransform;
    protected SVGGraphicsElement() { super(); }
    protected SVGGraphicsElement(java.lang.String prefix,
                                 org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() { super.
                                                     initializeAllLiveAttributes(
                                                       );
                                                   initializeLiveAttributes(
                                                     );
    }
    private void initializeLiveAttributes() { transform =
                                                createLiveAnimatedTransformList(
                                                  null,
                                                  SVG_TRANSFORM_ATTRIBUTE,
                                                  "");
                                              externalResourcesRequired =
                                                createLiveAnimatedBoolean(
                                                  null,
                                                  SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                                                  false);
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getBBox(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getTransform() {
        return transform;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public java.lang.String getXMLlang() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLLang(
            this);
    }
    public void setXMLlang(java.lang.String lang) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_LANG_QNAME,
          lang);
    }
    public java.lang.String getXMLspace() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            this);
    }
    public void setXMLspace(java.lang.String space) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_SPACE_QNAME,
          space);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    public java.awt.geom.AffineTransform getMotionTransform() {
        return motionTransform;
    }
    public void updateOtherValue(java.lang.String type,
                                 org.apache.batik.anim.values.AnimatableValue val) {
        if (type.
              equals(
                "motion")) {
            if (motionTransform ==
                  null) {
                motionTransform =
                  new java.awt.geom.AffineTransform(
                    );
            }
            if (val ==
                  null) {
                motionTransform.
                  setToIdentity(
                    );
            }
            else {
                org.apache.batik.anim.values.AnimatableMotionPointValue p =
                  (org.apache.batik.anim.values.AnimatableMotionPointValue)
                    val;
                motionTransform.
                  setToTranslation(
                    p.
                      getX(
                        ),
                    p.
                      getY(
                        ));
                motionTransform.
                  rotate(
                    p.
                      getAngle(
                        ));
            }
            org.apache.batik.dom.svg.SVGOMDocument d =
              (org.apache.batik.dom.svg.SVGOMDocument)
                ownerDocument;
            d.
              getAnimatedAttributeListener(
                ).
              otherAnimationChanged(
                this,
                type);
        }
        else {
            super.
              updateOtherValue(
                type,
                val);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0fae9xRbcB97bbug92w3d48OB/01tnU3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/Q+e+6PtEe//B2ax6HW3PgAA");
}
