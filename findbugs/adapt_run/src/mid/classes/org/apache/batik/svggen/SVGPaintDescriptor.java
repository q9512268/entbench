package org.apache.batik.svggen;
public class SVGPaintDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String paintValue;
    private java.lang.String opacityValue;
    public SVGPaintDescriptor(java.lang.String paintValue, java.lang.String opacityValue) {
        super(
          );
        this.
          paintValue =
          paintValue;
        this.
          opacityValue =
          opacityValue;
    }
    public SVGPaintDescriptor(java.lang.String paintValue, java.lang.String opacityValue,
                              org.w3c.dom.Element def) { this(
                                                           paintValue,
                                                           opacityValue);
                                                         this.
                                                           def =
                                                           def;
    }
    public java.lang.String getPaintValue() { return paintValue;
    }
    public java.lang.String getOpacityValue() { return opacityValue;
    }
    public org.w3c.dom.Element getDef() { return def; }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_FILL_ATTRIBUTE,
            paintValue);
        attrMap.
          put(
            SVG_STROKE_ATTRIBUTE,
            paintValue);
        attrMap.
          put(
            SVG_FILL_OPACITY_ATTRIBUTE,
            opacityValue);
        attrMap.
          put(
            SVG_STROKE_OPACITY_ATTRIBUTE,
            opacityValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null)
            defSet.
              add(
                def);
        return defSet;
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
       "pBvE5aON/Bcf/7n3/fPX/qC8MPt/+/pW94oqAAA=");
}
