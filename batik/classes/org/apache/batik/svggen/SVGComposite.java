package org.apache.batik.svggen;
public class SVGComposite implements org.apache.batik.svggen.SVGConverter {
    private org.apache.batik.svggen.SVGAlphaComposite svgAlphaComposite;
    private org.apache.batik.svggen.SVGCustomComposite svgCustomComposite;
    public SVGComposite(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        this.
          svgAlphaComposite =
          new org.apache.batik.svggen.SVGAlphaComposite(
            generatorContext);
        this.
          svgCustomComposite =
          new org.apache.batik.svggen.SVGCustomComposite(
            generatorContext);
    }
    public java.util.List getDefinitionSet() { java.util.List compositeDefs =
                                                 new java.util.LinkedList(
                                                 svgAlphaComposite.
                                                   getDefinitionSet(
                                                     ));
                                               compositeDefs.addAll(
                                                               svgCustomComposite.
                                                                 getDefinitionSet(
                                                                   ));
                                               return compositeDefs;
    }
    public org.apache.batik.svggen.SVGAlphaComposite getAlphaCompositeConverter() {
        return svgAlphaComposite;
    }
    public org.apache.batik.svggen.SVGCustomComposite getCustomCompositeConverter() {
        return svgCustomComposite;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getComposite(
                     ));
    }
    public org.apache.batik.svggen.SVGCompositeDescriptor toSVG(java.awt.Composite composite) {
        if (composite instanceof java.awt.AlphaComposite)
            return svgAlphaComposite.
              toSVG(
                (java.awt.AlphaComposite)
                  composite);
        else
            return svgCustomComposite.
              toSVG(
                composite);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uN8Xr9h88B9yLaw4ch4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9ML8WcHmT2/+4zf+/uPfzq+1/h+PSEkI/igAAA==");
}
