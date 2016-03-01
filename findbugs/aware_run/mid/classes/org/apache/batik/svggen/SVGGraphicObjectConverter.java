package org.apache.batik.svggen;
public abstract class SVGGraphicObjectConverter implements org.apache.batik.svggen.SVGSyntax {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    public SVGGraphicObjectConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              org.apache.batik.svggen.ErrorConstants.
                ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
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
       "yyh4IQAA");
}
