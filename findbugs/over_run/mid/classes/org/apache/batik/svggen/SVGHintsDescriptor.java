package org.apache.batik.svggen;
public class SVGHintsDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String colorInterpolation;
    private java.lang.String colorRendering;
    private java.lang.String textRendering;
    private java.lang.String shapeRendering;
    private java.lang.String imageRendering;
    public SVGHintsDescriptor(java.lang.String colorInterpolation, java.lang.String colorRendering,
                              java.lang.String textRendering,
                              java.lang.String shapeRendering,
                              java.lang.String imageRendering) { super(
                                                                   );
                                                                 if (colorInterpolation ==
                                                                       null ||
                                                                       colorRendering ==
                                                                       null ||
                                                                       textRendering ==
                                                                       null ||
                                                                       shapeRendering ==
                                                                       null ||
                                                                       imageRendering ==
                                                                       null)
                                                                     throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                                       org.apache.batik.svggen.ErrorConstants.
                                                                         ERR_HINT_NULL);
                                                                 this.
                                                                   colorInterpolation =
                                                                   colorInterpolation;
                                                                 this.
                                                                   colorRendering =
                                                                   colorRendering;
                                                                 this.
                                                                   textRendering =
                                                                   textRendering;
                                                                 this.
                                                                   shapeRendering =
                                                                   shapeRendering;
                                                                 this.
                                                                   imageRendering =
                                                                   imageRendering;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_COLOR_INTERPOLATION_ATTRIBUTE,
            colorInterpolation);
        attrMap.
          put(
            SVG_COLOR_RENDERING_ATTRIBUTE,
            colorRendering);
        attrMap.
          put(
            SVG_TEXT_RENDERING_ATTRIBUTE,
            textRendering);
        attrMap.
          put(
            SVG_SHAPE_RENDERING_ATTRIBUTE,
            shapeRendering);
        attrMap.
          put(
            SVG_IMAGE_RENDERING_ATTRIBUTE,
            imageRendering);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r6IYCFz6c+Z5RWFZ+FuGA/8D9TI6B3scAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/kaWAvhfTaj8krInAAA=");
}
