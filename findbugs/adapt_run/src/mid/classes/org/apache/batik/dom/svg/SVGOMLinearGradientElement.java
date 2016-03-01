package org.apache.batik.dom.svg;
public class SVGOMLinearGradientElement extends org.apache.batik.dom.svg.SVGOMGradientElement implements org.w3c.dom.svg.SVGLinearGradientElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMGradientElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x1;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y1;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x2;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y2;
    protected SVGOMLinearGradientElement() {
        super(
          );
    }
    public SVGOMLinearGradientElement(java.lang.String prefix,
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
        x1 =
          createLiveAnimatedLength(
            null,
            SVG_X1_ATTRIBUTE,
            SVG_LINEAR_GRADIENT_X1_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y1 =
          createLiveAnimatedLength(
            null,
            SVG_Y1_ATTRIBUTE,
            SVG_LINEAR_GRADIENT_Y1_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        x2 =
          createLiveAnimatedLength(
            null,
            SVG_X2_ATTRIBUTE,
            SVG_LINEAR_GRADIENT_X2_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y2 =
          createLiveAnimatedLength(
            null,
            SVG_Y2_ATTRIBUTE,
            SVG_LINEAR_GRADIENT_Y2_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_LINEAR_GRADIENT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX1() {
        return x1;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY1() {
        return y1;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX2() {
        return x2;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY2() {
        return y2;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMLinearGradientElement(
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
       "G2+sIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "B+q+QjQWLwAA");
}
