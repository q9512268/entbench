package org.apache.batik.dom.svg;
public class SVGOMUseElement extends org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement implements org.w3c.dom.svg.SVGUseElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement.
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
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns:xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMUseShadowRoot
      shadowTree;
    protected SVGOMUseElement() { super();
    }
    public SVGOMUseElement(java.lang.String prefix,
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
            SVG_USE_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_USE_Y_DEFAULT_VALUE,
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
    }
    public java.lang.String getLocalName() {
        return SVG_USE_TAG;
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
    public org.w3c.dom.svg.SVGElementInstance getInstanceRoot() {
        throw new java.lang.UnsupportedOperationException(
          "SVGUseElement.getInstanceRoot is not implemented");
    }
    public org.w3c.dom.svg.SVGElementInstance getAnimatedInstanceRoot() {
        throw new java.lang.UnsupportedOperationException(
          "SVGUseElement.getAnimatedInstanceRoot is not implemented");
    }
    public org.w3c.dom.Node getCSSFirstChild() {
        if (shadowTree !=
              null) {
            return shadowTree.
              getFirstChild(
                );
        }
        return null;
    }
    public org.w3c.dom.Node getCSSLastChild() {
        return getCSSFirstChild(
                 );
    }
    public boolean isHiddenFromSelectors() {
        return true;
    }
    public void setUseShadowTree(org.apache.batik.dom.svg.SVGOMUseShadowRoot r) {
        shadowTree =
          r;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMUseElement(
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
       "uBfy2Ak+T3b5q4Mv/jb+TvlvnSncdvRC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8DWXza5u9NzVrwHPB2oUBy531cvAR64+sC+BtNnJf3PywH6v4VNP6095G/zV" +
       "U2j/OMu+EhXeZhy980Jtu2+s1KO3YWHe8BeOmdcvRYXbV56h7O3uH9zIC+a8" +
       "4MtHIrg7KyyC9NGdCD56IyKICuf8wFhJkfq6cvjnp9D+ZZZ9LSo8tJfD1ULI" +
       "6L+1B/z1mwB8X1b4KEgv7gC/eKM6f9/rYv2DU2j/IcteiQp362rU92TJHu7M" +
       "Fd3j+9c3gS+7alR4AqTP7vB99tbj+6+n0P44y74BbBTgmx76rCeu4bOufle6" +
       "B/+fbgX4X96B/+VbD/5/nkL7TpZ9awtezJ7/dI/rf9wsrqdA+sIO1xduPa7v" +
       "X592kHfxl1HhToBLOHx7ewzbd28WW7bw/eYO22/ecmwHbzqFlr0rOzgLFkGA" +
       "jTh6DbwHd3DuJsBljia/YvKVHbiv3HpwD55C+6Esuy8qXADgDtfI7O3w4cR8" +
       "8hoTcxdJHFbfC+L+mxVEFaSXd4J4+dYL4qlTaD+cZY9HhQeBIA49z3GBZOS3" +
       "7aE+cRNQ82qPg/Q7O6i/c+uhwqfQyln2TFS4CKC2WLZrBGHUWhi7q/7ZBbjj" +
       "Sh96yjEVP3uzuB8D6ZUd7lduPe73n0LLwvGD92xtHeDOXtXnsLPi6h7iczcB" +
       "8f6sMLsI8+oO4qu3HmLvFNogy7pR4QEjJAwFbO27geewanaT1QuuGSqem3ue" +
       "rUruHj9+E/jzq5w1kP5oh/+Pbg3+g32Fv5EDnZ0ihA9mGdiUXQzV6OjKS3ZN" +
       "Jqu8jxIP+JsA+o6s8D0gfWsH9Fs3CvR1dwYH2im0bIE9kHbu6jo34+Z7qPOb" +
       "tenseu53dlC/c+uhBqfQctfrAEt11XXmjE5MV/cmoGWRYKEJ0vd20L5366F9" +
       "+BTaR7JsA/Y1QIsnL3seXeCc7rGmN3RTGHi6E59/ZBfZH3rNZ2fbT6XkX3/p" +
       "wp0PvjT5t/kXEEefM93VL9ypxbZ9/O7sseezfqBqRi6Eu7Y3af0c2ccBqOtd" +
       "RosKt4E84/fgJ7e1fyoqvOVatUFNkB+v+TO71el4zahwR/7/eL1PRYXz+3pR" +
       "4ez24XiVnwW9gyrZ4wv+4dJXP+0G3WRMHn38gQeSvzDk8PBYZXv88tBxO8sj" +
       "3/teT2VHTY5/b5GdpuRfER6efMTb7wivyF96iRr++Ldrn99+7yHbUppmvdzZ" +
       "L5zbfnqSd5qdnjxx3d4O+zpLPP3de37jrqcOT3ru2TK8t/ljvD127S8rOo4f" +
       "5d9CpF958O+99++89If5Xbr/B1grZxLeOQAA");
}
