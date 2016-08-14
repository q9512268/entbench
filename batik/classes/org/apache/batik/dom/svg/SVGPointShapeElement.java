package org.apache.batik.dom.svg;
public abstract class SVGPointShapeElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGAnimatedPoints {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_POINTS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_POINTS_VALUE));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPoints
      points;
    protected SVGPointShapeElement() { super(); }
    public SVGPointShapeElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    private void initializeLiveAttributes() { points =
                                                createLiveAnimatedPoints(
                                                  null,
                                                  SVG_POINTS_ATTRIBUTE,
                                                  "");
    }
    public org.apache.batik.dom.svg.SVGOMAnimatedPoints getSVGOMAnimatedPoints() {
        return points;
    }
    public org.w3c.dom.svg.SVGPointList getPoints() {
        return points.
          getPoints(
            );
    }
    public org.w3c.dom.svg.SVGPointList getAnimatedPoints() {
        return points.
          getAnimatedPoints(
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
      ("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");
}
