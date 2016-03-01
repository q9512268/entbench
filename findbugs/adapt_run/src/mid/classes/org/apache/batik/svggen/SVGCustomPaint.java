package org.apache.batik.svggen;
public class SVGCustomPaint extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGCustomPaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Paint paint) {
        org.apache.batik.svggen.SVGPaintDescriptor paintDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              paint);
        if (paintDesc ==
              null) {
            paintDesc =
              generatorContext.
                extensionHandler.
                handlePaint(
                  paint,
                  generatorContext);
            if (paintDesc !=
                  null) {
                org.w3c.dom.Element def =
                  paintDesc.
                  getDef(
                    );
                if (def !=
                      null)
                    defSet.
                      add(
                        def);
                descMap.
                  put(
                    paint,
                    paintDesc);
            }
        }
        return paintDesc;
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
       "vWggAAA=");
}
