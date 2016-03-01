package org.apache.batik.dom.svg;
public abstract class SVGOMTextPositioningElement extends org.apache.batik.dom.svg.SVGOMTextContentElement implements org.w3c.dom.svg.SVGTextPositioningElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextContentElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_DX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_DY_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_ROTATE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      dx;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      dy;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList
      rotate;
    protected SVGOMTextPositioningElement() {
        super(
          );
    }
    protected SVGOMTextPositioningElement(java.lang.String prefix,
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
          createLiveAnimatedLengthList(
            null,
            SVG_X_ATTRIBUTE,
            getDefaultXValue(
              ),
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH);
        y =
          createLiveAnimatedLengthList(
            null,
            SVG_Y_ATTRIBUTE,
            getDefaultYValue(
              ),
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH);
        dx =
          createLiveAnimatedLengthList(
            null,
            SVG_DX_ATTRIBUTE,
            "",
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH);
        dy =
          createLiveAnimatedLengthList(
            null,
            SVG_DY_ATTRIBUTE,
            "",
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH);
        rotate =
          createLiveAnimatedNumberList(
            null,
            SVG_ROTATE_ATTRIBUTE,
            "",
            true);
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getDx() {
        return dx;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getDy() {
        return dy;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getRotate() {
        return rotate;
    }
    protected java.lang.String getDefaultXValue() {
        return "";
    }
    protected java.lang.String getDefaultYValue() {
        return "";
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
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kiA8WbIOjONsSUB5xf/Jci/E0OXjcjF0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("cRc5WeRF0Dookkc/EBwyyuuc1edqLW7Ee/GhI3/hhC++N7aCax59vXE7qnLy" +
       "VmPuvxf3+Q997WR3o/+G+tVXetxPfrf6S7tblaojb7d5Kw8w0P27C55H/voz" +
       "t23tsK2L3ee+9/DXLj17+G3x8E7gY8M/IdvTt76/2HKDuLhxuP21t//K+7/4" +
       "yh8UR/T/D7iiu7FoMQAA");
}
