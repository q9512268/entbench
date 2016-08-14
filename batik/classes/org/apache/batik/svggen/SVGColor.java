package org.apache.batik.svggen;
public class SVGColor extends org.apache.batik.svggen.AbstractSVGConverter {
    public static final java.awt.Color aqua = java.awt.Color.cyan;
    public static final java.awt.Color black = java.awt.Color.black;
    public static final java.awt.Color blue = java.awt.Color.blue;
    public static final java.awt.Color fuchsia = java.awt.Color.magenta;
    public static final java.awt.Color gray = java.awt.Color.gray;
    public static final java.awt.Color green = new java.awt.Color(0, 128,
                                                                  0);
    public static final java.awt.Color lime = java.awt.Color.green;
    public static final java.awt.Color maroon = new java.awt.Color(128, 0,
                                                                   0);
    public static final java.awt.Color navy = new java.awt.Color(0, 0, 128);
    public static final java.awt.Color olive = new java.awt.Color(128, 128,
                                                                  0);
    public static final java.awt.Color purple = new java.awt.Color(128, 0,
                                                                   128);
    public static final java.awt.Color red = java.awt.Color.red;
    public static final java.awt.Color silver = new java.awt.Color(192, 192,
                                                                   192);
    public static final java.awt.Color teal = new java.awt.Color(0, 128, 128);
    public static final java.awt.Color white = java.awt.Color.white;
    public static final java.awt.Color yellow = java.awt.Color.yellow;
    private static java.util.Map colorMap = new java.util.HashMap();
    static { colorMap.put(black, "black");
             colorMap.put(silver, "silver");
             colorMap.put(gray, "gray");
             colorMap.put(white, "white");
             colorMap.put(maroon, "maroon");
             colorMap.put(red, "red");
             colorMap.put(purple, "purple");
             colorMap.put(fuchsia, "fuchsia");
             colorMap.put(green, "green");
             colorMap.put(lime, "lime");
             colorMap.put(olive, "olive");
             colorMap.put(yellow, "yellow");
             colorMap.put(navy, "navy");
             colorMap.put(blue, "blue");
             colorMap.put(teal, "teal");
             colorMap.put(aqua, "aqua"); }
    public SVGColor(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Paint paint =
          gc.
          getPaint(
            );
        return toSVG(
                 (java.awt.Color)
                   paint,
                 generatorContext);
    }
    public static org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Color color,
                                                                   org.apache.batik.svggen.SVGGeneratorContext gc) {
        java.lang.String cssColor =
          (java.lang.String)
            colorMap.
            get(
              color);
        if (cssColor ==
              null) {
            java.lang.StringBuffer cssColorBuffer =
              new java.lang.StringBuffer(
              RGB_PREFIX);
            cssColorBuffer.
              append(
                color.
                  getRed(
                    ));
            cssColorBuffer.
              append(
                COMMA);
            cssColorBuffer.
              append(
                color.
                  getGreen(
                    ));
            cssColorBuffer.
              append(
                COMMA);
            cssColorBuffer.
              append(
                color.
                  getBlue(
                    ));
            cssColorBuffer.
              append(
                RGB_SUFFIX);
            cssColor =
              cssColorBuffer.
                toString(
                  );
        }
        float alpha =
          color.
          getAlpha(
            ) /
          255.0F;
        java.lang.String alphaString =
          gc.
          doubleString(
            alpha);
        return new org.apache.batik.svggen.SVGPaintDescriptor(
          cssColor,
          alphaString);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nMa9jk8X/geCdcUGNSYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+wBdubFMHOdsfc2Z++tBaCztUkQP7Ktt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gpLbR+LK45ewVvwYV94UUK/d2o9/b1y5dX58UXJS/D877vG48uDpOEBqf3N2" +
       "yJNx5R4wpLj93uBYzs9fJmd0EcWhqsWliLytEcZGmF2701WdqOOjbyf4M97t" +
       "I3f4pLLu/dh/JPzRTz5fe5Vif+TN9s/uqxo1R83zgsoNunL/vsDyxAd96FJq" +
       "x7SuE89+9+GvP/DMsb98eA/4VMfPYPvgxSWEQzeIy6K//Nce/7sv/tyrv1f+" +
       "ZvF/AejmFSmQMAAA");
}
