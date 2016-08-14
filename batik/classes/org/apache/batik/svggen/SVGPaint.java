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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "b37TH3J4J8fwPP6Kbx3/BZD51vHNIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ng9IJxMEyBfURf76uRj0UKFlFHwfPnTPD5+PQZegMtMqmzxTpreK5LuPXP5q" +
       "EJkbMMsf+vyfgb9L4Pt/xVcwKwr2c/Kj7cOFwdPHK4MAzF2PAMco1gNi1ItE" +
       "xVQPl8zAh567wIfOtthHyiKtFgm5F6Z+Txv7yFkNFKixQw1g99DA+B4aKLJU" +
       "qdYu8C8g4AKYJphhymn3CMl3X4DkNP05HMwbxPEU+GqHOGr3wLH6TnBcA+KB" +
       "WHi4vH/XxQuMkvCc5NwblPx58L1wKPkL95D89nci+cOF5Gmc+O6ZAfjgRfKf" +
       "kJ9D8bE3iKKwnUPS/e9dUBjfCYqb+rkpoihHz0lnvq50JbftJeClD1QO6gcl" +
       "A//u/d9XZD8EZvC43DiCFprpic6RQI9ZjnzryH9XYCMJQukty6kf6fdmOQsU" +
       "Qetgv/s6J2v3O5YVRPmHT5jRPtjIffq/fvY3/sYHvg5C8RB6YFOESRCBT/XI" +
       "pMXe9kde+dyTb3vpG58uFyRAoasf/YX6Nwqu+UWIi6SsSY6gPlFAZcsVPC3G" +
       "ybhcQ6hKifbCGWgamS5Yam0ON27Ii49+3f7J3//Z/abs/HRzjlj91Et//c8O" +
       "PvPS5VNb4Q/csRs93Wa/HS6FfvuhhiPomYt6KVt0//uXX/zHf/fFT+6levTs" +
       "xo7yUvdnf/v//sbB57/x1bvsMu53/DcxsMnNm/1qPGgd/dEroU205PncS3E5" +
       "bdK4ut7Bm11qLvrDRW8dU0l1Ph6TtpOlO5lyJ2vaoDv80K17Ap5gQ8GV3XEd" +
       "w91q7AdU2BGWlGH4Mmeu/NViTLZGVLKkRobPGtXu1G8NBv7A5/SVaVAm6YRW" +
       "FcnRfFJFFFdhV7izYupYjiMIoiBNRENgU61WlEEi9hadMMx6TBot2SkX1Fvk" +
       "bKH4qSNznd44ao7WVFoLqWatiYjNSTgaOUM7FWW+ly1JfpLaNVNmgqHthTN+" +
       "0SUp0d2ZzACVW7mPhZ2qOaacle2yNWG68JiVzQ4lYb5Yje0eSaPk0DbHI4HO" +
       "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" +
       "+XfL69j/DxAzfxrCLQAA");
}
