package org.apache.batik.svggen;
public class SVGPaint implements org.apache.batik.svggen.SVGConverter {
    private org.apache.batik.svggen.SVGLinearGradient svgLinearGradient;
    private org.apache.batik.svggen.SVGTexturePaint svgTexturePaint;
    private org.apache.batik.svggen.SVGColor svgColor;
    private org.apache.batik.svggen.SVGCustomPaint svgCustomPaint;
    private org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    public SVGPaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        this.
          svgLinearGradient =
          new org.apache.batik.svggen.SVGLinearGradient(
            generatorContext);
        this.
          svgTexturePaint =
          new org.apache.batik.svggen.SVGTexturePaint(
            generatorContext);
        this.
          svgCustomPaint =
          new org.apache.batik.svggen.SVGCustomPaint(
            generatorContext);
        this.
          svgColor =
          new org.apache.batik.svggen.SVGColor(
            generatorContext);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { java.util.List paintDefs =
                                                 new java.util.LinkedList(
                                                 svgLinearGradient.
                                                   getDefinitionSet(
                                                     ));
                                               paintDefs.addAll(svgTexturePaint.
                                                                  getDefinitionSet(
                                                                    ));
                                               paintDefs.
                                                 addAll(
                                                   svgCustomPaint.
                                                     getDefinitionSet(
                                                       ));
                                               paintDefs.
                                                 addAll(
                                                   svgColor.
                                                     getDefinitionSet(
                                                       ));
                                               return paintDefs;
    }
    public org.apache.batik.svggen.SVGTexturePaint getTexturePaintConverter() {
        return svgTexturePaint;
    }
    public org.apache.batik.svggen.SVGLinearGradient getGradientPaintConverter() {
        return svgLinearGradient;
    }
    public org.apache.batik.svggen.SVGCustomPaint getCustomPaintConverter() {
        return svgCustomPaint;
    }
    public org.apache.batik.svggen.SVGColor getColorConverter() {
        return svgColor;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Paint paint) {
        org.apache.batik.svggen.SVGPaintDescriptor paintDesc =
          svgCustomPaint.
          toSVG(
            paint);
        if (paintDesc ==
              null) {
            if (paint instanceof java.awt.Color)
                paintDesc =
                  org.apache.batik.svggen.SVGColor.
                    toSVG(
                      (java.awt.Color)
                        paint,
                      generatorContext);
            else
                if (paint instanceof java.awt.GradientPaint)
                    paintDesc =
                      svgLinearGradient.
                        toSVG(
                          (java.awt.GradientPaint)
                            paint);
                else
                    if (paint instanceof java.awt.TexturePaint)
                        paintDesc =
                          svgTexturePaint.
                            toSVG(
                              (java.awt.TexturePaint)
                                paint);
        }
        return paintDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZiWY9Y9yy2sanr3YKfjPgf8B1zOaI/YhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
