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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xN7UrDArVs59f8zUJIMw+XJepzm40xii");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "0z4AAA==");
}
