package org.apache.batik.dom.svg;
public class SVGOMViewElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGViewElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      2);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                                    SVG_MAGNIFY_VALUE);
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMViewElement() { super(
                                     ); }
    public SVGOMViewElement(java.lang.String prefix,
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
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_VIEW_TAG;
    }
    public org.w3c.dom.svg.SVGStringList getViewTarget() {
        throw new java.lang.UnsupportedOperationException(
          "SVGViewElement.getViewTarget is not implemented");
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
        return new org.apache.batik.dom.svg.SVGOMViewElement(
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZB3Ep1D/yQ2grgIYyoC1zx+i/vw7g/rC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("CcGfVgTfPgf6fy2zbwHoyWnoZ1bvn90AyupK+FmQfu4Q5c+987L9n+fUfbfM" +
       "/ltau/NQu4mgOFLtJ66h2kcXkNMycu+YAX95Awx4viws2712yIDX3nEGXLjt" +
       "nLo7yuxiWnsIMOAa16pHzLh8DjOu16zkzYWbboA35ZqvfS9IXz7kzZffed48" +
       "eE7dw2V2Ka29D/Cm/2aX8U+dw6HDG/gTrtx3A1x5+ogrv3nIld98u1x5Uyfn" +
       "wtPn1D1bZo+ntYcBV64XP6GeQH3iBqA+UBY+CtJXDqF+5Z2Hek4w3YUymO7C" +
       "88Ap8o2cC3TjSNaXTsv6uKKCC90A3CfLwi5Iv38I9/ffebgfPqfu+8usA9w2" +
       "INmzYULHoT/LE6zdtxVjBth2NnK4jIF85Ko/LRwE2mu/8uq9tz/8qvTvquDZ" +
       "42D4O5ja7ebWdU+HXZ16vjWMDdOuuHDHQRBWWEEbAFTXiy1JazeBvJzwhf4B" +
       "NZ3W3n0takAJ8tOUzKEynKYEfkD1fZqOB1vMCV1au/Xg4TTJFPQOSMrHWXik" +
       "adeODjwOiDk6JB6cJh85rVbVznT/m0nouMnpwNzybFj94+ToHLc9+M/JS9qX" +
       "Xh1xP/Kd9i8cBAZrrrLfl73cztRuO4hRrjotz4JPXre3o75uHT733Xt+9Y5n" +
       "j86t9xxM+ETFT83tiWuH4Pa9MK2CZve/8fCXP/SLr369Cn35fyju/rwKNAAA");
}
