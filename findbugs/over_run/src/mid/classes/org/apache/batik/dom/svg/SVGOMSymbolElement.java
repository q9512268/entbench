package org.apache.batik.dom.svg;
public class SVGOMSymbolElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGSymbolElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      1);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMSymbolElement() { super(
                                       );
    }
    public SVGOMSymbolElement(java.lang.String prefix,
                              org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_SYMBOL_TAG;
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
    public short getZoomAndPan() { return org.apache.batik.dom.svg.SVGZoomAndPanSupport.
                                     getZoomAndPan(
                                       this);
    }
    public void setZoomAndPan(short val) {
        org.apache.batik.dom.svg.SVGZoomAndPanSupport.
          setZoomAndPan(
            this,
            val);
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFitToViewBox.getViewBox is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMSymbolElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "U0+Ggaq4431zxY/wvXmz+B4F6aP7+D76");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7uP7V2eU/UFBvpJAFwG++WhYvPE4he6rN4GuvCjw/SC9so/ulXcH3bkjBrxk" +
       "+HdnQPxaQf4QQIxPQDxmoH90swos7kL89D7En373FfiNM8r+tCD/MYHu2lNg" +
       "HCrqafv8k5vV4LMgvboP79X/Rxr8b2dg/E5B/ivAGJ/EeEyF37oJjOXyXviY" +
       "n93H+LPvugrPQWeUlTcQvptA9wAVymDrjfsap/jXW0lui8GmJDlC/ec3q9ni" +
       "6uYv7KP+hXdbs+duLeFdOgP6fQW5CKDHx6Gf1O25u24CZXlx4BmQfnkf5S+/" +
       "+7p93xlljxXkwT3/Kln6lgiyg+DwiesEhwcv3vniBuuhAB66CQE8V2QW9b64" +
       "L4AvvvsCePaMMrggVxLoQSCA61wJORDG1TOEcaNqpWyeuQnZFHMe+kGQvrQv" +
       "my+9+7LBzihrFwRNoEeBbLpvd2Xj6TMktH9P40gqtZuQyvsPpPLlfal8+Z1K" +
       "5W3D7HPdM8qogryUQA8Bqdzolo1zBBW/CagPFJmPgPR7+1B/792HOjmjbFqQ" +
       "IQjLfX07DjT9QNeXj+v6sKCEO7oJuE8VmW2Q3tqH+9a7D/flM8qUgshg4wA0" +
       "e/qq3OH1t/kR1g+/o3uWCXT/tffni5vAD1/zB569P52ov/r6pTseel38w/IK" +
       "+eEfQ+4cQncYqesev3x47PlCGOnG3mnDnXtXEcMS3ArgutGtqgS6BdBiyOfM" +
       "PW4ngd5zPW7ACehxTn/fHI5zgkig/D7OtwaLzBFfAl3YezjOkoDWAUvxmIYH" +
       "tnbmvxGmSe4Wijk4rtg72Xj4uHmVgcj9b6epwyrHL6kXpxTlf7AOThTSvX9h" +
       "vax+4fX++KPfbv7i3iV51VV2u6KVO4bQ7Xv39ctGi1OJp27Y2kFbF+hnv3vv" +
       "r935zMEJyr17Az4y9WNje+L619G7XpiUF8h3v/nQFz/0917/WnkN7P8CpnJl" +
       "GRw3AAA=");
}
