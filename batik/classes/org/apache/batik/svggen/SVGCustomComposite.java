package org.apache.batik.svggen;
public class SVGCustomComposite extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGCustomComposite(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getComposite(
                     ));
    }
    public org.apache.batik.svggen.SVGCompositeDescriptor toSVG(java.awt.Composite composite) {
        if (composite ==
              null)
            throw new java.lang.NullPointerException(
              );
        org.apache.batik.svggen.SVGCompositeDescriptor compositeDesc =
          (org.apache.batik.svggen.SVGCompositeDescriptor)
            descMap.
            get(
              composite);
        if (compositeDesc ==
              null) {
            org.apache.batik.svggen.SVGCompositeDescriptor desc =
              generatorContext.
                extensionHandler.
              handleComposite(
                composite,
                generatorContext);
            if (desc !=
                  null) {
                org.w3c.dom.Element def =
                  desc.
                  getDef(
                    );
                if (def !=
                      null)
                    defSet.
                      add(
                        def);
                descMap.
                  put(
                    composite,
                    desc);
            }
        }
        return compositeDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PhUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
