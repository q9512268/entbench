package org.apache.batik.dom.svg;
public class SVGOMForeignObjectElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGForeignObjectElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
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
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMForeignObjectElement() {
        super(
          );
    }
    public SVGOMForeignObjectElement(java.lang.String prefix,
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
        x =
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_FOREIGN_OBJECT_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_FOREIGN_OBJECT_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_FOREIGN_OBJECT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMForeignObjectElement(
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
       "ZgLds/t/ut71BLp8Ui+BLu4Tp6sgoHdQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("pUzWgiOTq5x3F92P5MCy1fjIi71wyhE9tLLdWnzojSbsuMnpZ32l87p7yn7k" +
       "aKb7x+zPq197ZTj+1OvNr+6fFaqOvN2WvdxHQ/fuXzgeO6tP3ra3o74uDp75" +
       "/gNfv/TUkWP9wF7gE4s/Jdv7bv2Ar+sGye7J3fbXH/nlj/6TV761u3j+f72g" +
       "MHxjMAAA");
}
