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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Vz2ze+35N+LSXbHnP2vrqW4fGzC/2vDu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("65+RDorrX0evEr/2sf/28PhHlh+6gfslj53g82SXf3vwhd8i36n+1TOl2w5f" +
       "LL7mYtrVjZ67+nXi+VCPk9AdX/VS8ZGrD/4rIG128t+cPPg/muFTT/1Peav8" +
       "1VPq/nGefSUuvc08fHeG2jZjpvrhW7WoaPjXjqnXX49Lt6eeqR3p3d+/kRfV" +
       "RcGXD0Vwd15YBumjOxF89EZEEJfO+aGZKrH+unL456fU/cs8+1pceuhIDlcL" +
       "Ia//zSPAX78JwPflhY+C9OIO8Is3Oufve12sv39K3X/Is1fi0t2GHjOeqtjD" +
       "nbqiR/j+9U3gy68slZ4A6TM7fJ+59fj+6yl1f5Rn3wA6CvDNDnzWE9fwWVe/" +
       "cz0C/59uBfhf3YH/1VsP/n+eUvedPPvWPngpf/6TI1z/42ZxPQXS53e4Pn/r" +
       "cX3/+nV7RRd/EZfuBLimB2+Bj2H77s1iyxe+L+2wfemWY9t70yl1+Tu3vbNg" +
       "EQTYqMPXyUfg9s7dBLjc0RRXVb6yA/eVWw/uwVPqfijP7otLFwC4gzUyf8t8" +
       "YJhPXsMwd5HEAfmRIO6/WUE0QHp5J4iXb70gnjql7ofz7PG49CAQxIHnOS6Q" +
       "vPptR1CfuAmoBdnjIP32Dupv33qo1VPq4Dx7Ji5dBFAxQeiaYRRjS3P3WUB+" +
       "ke74pA897dgUP3uzuB8D6ZUd7lduPe73n1KXh+N779nXdYA7f+VfwM6LG0cQ" +
       "n7sJiPfnhfmFmld3EF+99RD7p9QN8qwblx4wI8rUNN3thp4j6PmNWC+8Zqh4" +
       "bu55tq64R/jJm8BfXAltgvSHO/x/eGvw7x0R/EwBVD5FCB/MM7Apuxjp8eHV" +
       "mfy6TU58FCXuTW4C6DvywveA9K0d0G/dKNDX3RnsLU6pyxfYPWXnrq5zw25+" +
       "BHV+szqdX/P9zg7qd2491PCUusL1OkBTXX2dO6MT5ureBLQ8Eiy1QfreDtr3" +
       "bj20D59S95E824B9DZjFk5dGDy+Czo6wbm/oxjHwdCc+I8kvxD/0mk/U9j+r" +
       "Un/9pQt3PviS+G+LLykOP326iynduUhs+/gd3GPPZ/1QX5iFEO7av5HrF8g+" +
       "DkBd71JbXLoN5Dm/ez+9T/2zcekt16IGlCA/Tvnzu9XpOGVcuqP4f5zuU3Hp" +
       "/BFdXDq7/3Cc5BdA74Akf3zBP1j6kNNu4ok8ffgRCRkq/tJUo4Njlf3jl4eO" +
       "61kR+d73elN22OT4dxv5aUrxxeHByUey/83hFfWLL/WGP/Ht5uf2vxtRbWW7" +
       "zXu5kymd2/+Epeg0Pz154rq9HfR1lnr6u/f8xl1PHZz03LPP8JHOH+PtsWt/" +
       "oUE4flx8U7H9yoN/971/86U/KO7k/T+BDYgFCjoAAA==");
}
