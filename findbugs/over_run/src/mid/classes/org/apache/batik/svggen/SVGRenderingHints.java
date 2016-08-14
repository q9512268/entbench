package org.apache.batik.svggen;
public class SVGRenderingHints extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGRenderingHints(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getRenderingHints(
                     ));
    }
    public static org.apache.batik.svggen.SVGHintsDescriptor toSVG(java.awt.RenderingHints hints) {
        java.lang.String colorInterpolation =
          SVG_AUTO_VALUE;
        java.lang.String colorRendering =
          SVG_AUTO_VALUE;
        java.lang.String textRendering =
          SVG_AUTO_VALUE;
        java.lang.String shapeRendering =
          SVG_AUTO_VALUE;
        java.lang.String imageRendering =
          SVG_AUTO_VALUE;
        if (hints !=
              null) {
            java.lang.Object rendering =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_RENDERING);
            if (rendering ==
                  java.awt.RenderingHints.
                    VALUE_RENDER_DEFAULT) {
                colorInterpolation =
                  SVG_AUTO_VALUE;
                colorRendering =
                  SVG_AUTO_VALUE;
                textRendering =
                  SVG_AUTO_VALUE;
                shapeRendering =
                  SVG_AUTO_VALUE;
                imageRendering =
                  SVG_AUTO_VALUE;
            }
            else
                if (rendering ==
                      java.awt.RenderingHints.
                        VALUE_RENDER_SPEED) {
                    colorInterpolation =
                      SVG_SRGB_VALUE;
                    colorRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    shapeRendering =
                      SVG_GEOMETRIC_PRECISION_VALUE;
                    imageRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                }
                else
                    if (rendering ==
                          java.awt.RenderingHints.
                            VALUE_RENDER_QUALITY) {
                        colorInterpolation =
                          SVG_LINEAR_RGB_VALUE;
                        colorRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                        textRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                        shapeRendering =
                          SVG_GEOMETRIC_PRECISION_VALUE;
                        imageRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                    }
            java.lang.Object fractionalMetrics =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_FRACTIONALMETRICS);
            if (fractionalMetrics ==
                  java.awt.RenderingHints.
                    VALUE_FRACTIONALMETRICS_ON) {
                textRendering =
                  SVG_OPTIMIZE_QUALITY_VALUE;
                shapeRendering =
                  SVG_GEOMETRIC_PRECISION_VALUE;
            }
            else
                if (fractionalMetrics ==
                      java.awt.RenderingHints.
                        VALUE_FRACTIONALMETRICS_OFF) {
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    shapeRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                }
                else
                    if (fractionalMetrics ==
                          java.awt.RenderingHints.
                            VALUE_FRACTIONALMETRICS_DEFAULT) {
                        textRendering =
                          SVG_AUTO_VALUE;
                        shapeRendering =
                          SVG_AUTO_VALUE;
                    }
            java.lang.Object antialiasing =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_ANTIALIASING);
            if (antialiasing ==
                  java.awt.RenderingHints.
                    VALUE_ANTIALIAS_ON) {
                textRendering =
                  SVG_OPTIMIZE_LEGIBILITY_VALUE;
                shapeRendering =
                  SVG_AUTO_VALUE;
            }
            else
                if (antialiasing ==
                      java.awt.RenderingHints.
                        VALUE_ANTIALIAS_OFF) {
                    textRendering =
                      SVG_GEOMETRIC_PRECISION_VALUE;
                    shapeRendering =
                      SVG_CRISP_EDGES_VALUE;
                }
                else
                    if (antialiasing ==
                          java.awt.RenderingHints.
                            VALUE_ANTIALIAS_DEFAULT) {
                        textRendering =
                          SVG_AUTO_VALUE;
                        shapeRendering =
                          SVG_AUTO_VALUE;
                    }
            java.lang.Object textAntialiasing =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_TEXT_ANTIALIASING);
            if (textAntialiasing ==
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_ON)
                textRendering =
                  SVG_GEOMETRIC_PRECISION_VALUE;
            else
                if (textAntialiasing ==
                      java.awt.RenderingHints.
                        VALUE_TEXT_ANTIALIAS_OFF)
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                else
                    if (textAntialiasing ==
                          java.awt.RenderingHints.
                            VALUE_TEXT_ANTIALIAS_DEFAULT)
                        textRendering =
                          SVG_AUTO_VALUE;
            java.lang.Object colorRenderingHint =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_COLOR_RENDERING);
            if (colorRenderingHint ==
                  java.awt.RenderingHints.
                    VALUE_COLOR_RENDER_DEFAULT)
                colorRendering =
                  SVG_AUTO_VALUE;
            else
                if (colorRenderingHint ==
                      java.awt.RenderingHints.
                        VALUE_COLOR_RENDER_QUALITY)
                    colorRendering =
                      SVG_OPTIMIZE_QUALITY_VALUE;
                else
                    if (colorRenderingHint ==
                          java.awt.RenderingHints.
                            VALUE_COLOR_RENDER_SPEED)
                        colorRendering =
                          SVG_OPTIMIZE_SPEED_VALUE;
            java.lang.Object interpolation =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_INTERPOLATION);
            if (interpolation ==
                  java.awt.RenderingHints.
                    VALUE_INTERPOLATION_NEAREST_NEIGHBOR)
                imageRendering =
                  SVG_OPTIMIZE_SPEED_VALUE;
            else
                if (interpolation ==
                      java.awt.RenderingHints.
                        VALUE_INTERPOLATION_BICUBIC ||
                      interpolation ==
                      java.awt.RenderingHints.
                        VALUE_INTERPOLATION_BILINEAR)
                    imageRendering =
                      SVG_OPTIMIZE_QUALITY_VALUE;
        }
        return new org.apache.batik.svggen.SVGHintsDescriptor(
          colorInterpolation,
          colorRendering,
          textRendering,
          shapeRendering,
          imageRendering);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5mqtiGijLjx+dlmZfHG33TB0lpb3/dC9vvzrf70XP/f7dypUjxZm0F0amSda" +
       "QGYURG4rQ/4J0an5qHX3let1nz6zvrUc9DmnniqQPlgd0sMC3nr8LxsO783N" +
       "fgk03xIyVJjljyYuvjO6XX4mKppNG8jLmtTSTUNBk4FQk0BXrXO1+MxqEb69" +
       "nmtv5S7rgWev49q9lRG1QlR4OFVtayg7b5rt3MB4gcWzX1HioyamOe8KIQ5x" +
       "uEa2P8iHSYYamAFg4YrorwEo9xFLNlXqXiLu4UPSjv49/1ue8YlhMX2/Z5N+" +
       "vjQIz6hjk9Ea5hTjAB922mHMX3dBRbDE9SlUETpqcK1taRuiuGVL+ytxlkwN" +
       "q87xIRW26mANqwq+lUw7++VNW2Soo6wn5Oi2vuw6al+h5FeW25q7lx/4jehL" +
       "vGtOK1T0TEHTAkkRTJBGapKMKvRttbGdii+A/u4qmnIXiRdxctOmn2eoPUwP" +
       "phPfQbpFhmI+HbCyX4IkjzJUByT89QR1zb6zmtmH09DGQbUAW0G6zEMfBkUm" +
       "Ug7qwg/rbuaHAIrfVgJ94q8CF6YK9p8FKfnV5YOHHrn21RftlkrW8NKSuFrC" +
       "Tdnu7jyo21aVm8urcWzgxprXWvqjTvh12Af2M2ZjIDaHIcApj4YNoX7D6vPa" +
       "jo8v7Ln0/unGK1BHjqIIZmjt0cBF3b6VQtNSABw+mgjWj8AfTqIVGor9cfaD" +
       "v38S6RQFE9l3jZ5aO1LymUufJjOUvhBFLeOoAcoeKc6gmGrdt6hPEXkeSntz" +
       "QVePF8i4AkGYNgq696/CGh66mMe8sIxj0NXeLG/JGeot+7+gwjUFeokFYu7j" +
       "3AX8h4pDgdLgapHftitoBb7Zff4fJ5/4aBJSq+TgQW5NViHt1ZngnxZ+4Wm3" +
       "Me0/8InA82/+cJfyCf7NUOeIc4Hf6t3gKS3aa3WpxASlDm3TeyIMKBVocUYw" +
       "/h4fvl/kFAxFBin9LyLzH0+tFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1Ze8zsxlX3/W7uM2nuTdqmacg7N4XE6Wd7X97VLaH2Prze" +
       "9dq7a3tfQG/8fqxfa3vX3i2BtlJpoVIpJSlBtPmrFVClDyEqkFBREIK2aoVU" +
       "FPGSaCqERKFUav6gIAqUsfd730eIkFhpZ2dnzjlzzpkzvzkz89L3oDNRCMGB" +
       "76wNx493tTTetZ3ybrwOtGi3w5T7Uhhpat2RokgAbdeUR7946Qc//Jh5eQc6" +
       "O4PeLHmeH0ux5XvRUIt8Z6WpDHTpsLXpaG4UQ5cZW1pJyDK2HISxovgqA91+" +
       "hDWGrjD7KiBABQSogOQqIMQhFWB6k+Yt3XrGIXlxtIB+HjrFQGcDJVMvhh45" +
       "LiSQQsndE9PPLQASzmf/R8ConDkNoYcPbN/afJ3Bz8PIc7/+nsu/exq6NIMu" +
       "WR6fqaMAJWIwyAy6w9VcWQsjQlU1dQbd5WmaymuhJTnWJtd7Bt0dWYYnxctQ" +
       "O3BS1rgMtDAf89BzdyiZbeFSif3wwDzd0hx1/98Z3ZEMYOs9h7ZuLWxl7cDA" +
       "ixZQLNQlRdtnuW1ueWoMPXSS48DGK11AAFjPuVps+gdD3eZJoAG6ezt3juQZ" +
       "CB+HlmcA0jP+EowSQ/fdVGjm60BS5pKhXYuhe0/S9bddgOpC7oiMJYbeepIs" +
       "lwRm6b4Ts3Rkfr7Hvuuj7/Xa3k6us6opTqb/ecD04AmmoaZroeYp2pbxjieZ" +
       "T0j3fPnDOxAEiN96gnhL8/s/99q7n3rw5a9uaX7sBjScbGtKfE35tHznN++v" +
       "P1E7nalxPvAjK5v8Y5bn4d/f67maBmDl3XMgMevc3e98efhn0/d9VvvuDnSR" +
       "hs4qvrN0QRzdpfhuYDlaSGmeFkqxptLQBc1T63k/DZ0DdcbytG0rp+uRFtPQ" +
       "bU7edNbP/wMX6UBE5qJzoG55ur9fD6TYzOtpAEHQOfCF7gBfGNp+8t8YshHT" +
       "dzVEUiTP8nykH/qZ/dmEeqqExFoE6iroDXxEBvE/fye2iyORvwxBQCJ+aCAS" +
       "iApT23Yi0cowNA/hR9QQqKxl0dUGARztZjEX/L+Olma2X05OnQLTcv9JUHDA" +
       "emr7DuC5pjy3JJuvff7a13cOFsme12LoCTDk7nbI3XzI3e2Qu9cNCZ06lY/0" +
       "lmzo7eSDqZsDEADweMcT/M92nvnwo6dB1AXJbcDvGSlyc5SuH8IGnYOjAmIX" +
       "evmF5P2jX0B3oJ3jcJupC5ouZuz9DCQPwPDKyWV2I7mXPvSdH3zhE8/6hwvu" +
       "GH7v4cD1nNk6fvSkY0Nf0VSAjIfin3xY+tK1Lz97ZQe6DYADAMRYAgEMsObB" +
       "k2McW89X97Exs+UMMFj3Q1dysq59QLsYm6GfHLbkM35nXr8L+Pj2LMDvB190" +
       "L+Lz36z3zUFWvmUbIdmknbAix96f5INP/fWf/1Mxd/c+TF86svHxWnz1CDRk" +
       "wi7lIHDXYQwIoaYBur97of9rz3/vQz+dBwCgeOxGA17JyjqABDCFwM0f/Ori" +
       "b1791qdf2TkMmhjsjUvZsZT0wMisHbp4CyPBaO841AdAiwMWXBY1V0TP9VVL" +
       "tyTZ0bIo/c9Lj2Nf+pePXt7GgQNa9sPoqdcXcNj+dhJ639ff828P5mJOKdnW" +
       "duizQ7ItXr75UDIRhtI60yN9/1888BtfkT4FkBegXWRttBzATu0tnEypt8YQ" +
       "fIuluYenfri3q+cTjeScT+blbuakXB6U9xWz4qHo6II5viaPpC3XlI+98v03" +
       "jb7/R6/lFh7Pe47GR08Krm5DMiseToH4t51Eh7YUmYCu9DL7M5edl38IJM6A" +
       "RAWgXcSFAF7SY9G0R33m3N/+8Z/c88w3T0M7Leii40tqS8oXJnQBrAgtMgGw" +
       "pcFPvXsbEMl5UFzOTYWuM34bSPfm/04DBZ+4OSa1srTlcFnf+x+cI3/g7//9" +
       "OifkaHSD3foE/wx56ZP31Z/+bs5/CAsZ94Pp9YgNUrxD3sJn3X/defTsn+5A" +
       "52bQZWUvfxxJzjJbbDOQM0X7SSXIMY/1H89/tpv91QPYu/8kJB0Z9iQgHe4U" +
       "oJ5RZ/WLRzHoR+BzCnz/O/tm7s4atrvu3fW9rf/hg70/CNJTYIWfKeziu2jG" +
       "T+RSHsnLK1nx49tpyqo/AaAgyhNXwKFbnuTkA5MxCDFHubIvfQQSWTAnV2wH" +
       "3183l/Nwyqzf3WZ/WxDMylIuYhsS+E3D511bqny3u/NQGOODRPIj//Cxb/zK" +
       "Y6+COe1AZ1aZv8FUHhmRXWa59S++9PwDtz/37Y/kyAaWdP8TzcvvzqSyt7I4" +
       "K6isaO+bel9mKp8nB4wUxb0cjDQ1t/aWodwPLRdg9movcUSevfvV+Se/87lt" +
       "Ungybk8Qax9+7pd/tPvR53aOpOKPXZcNH+XZpuO50m/a83AIPXKrUXKO1j9+" +
       "4dk//O1nP7TV6u7jiWUTnJs+95f/9Y3dF779tRvkLbc5/v9hYuPbX2mXIprY" +
       "/zDYVCqkSjocaxO5WhRWCR2JPU1wmYhvS/xKGhLdSVcqBXZTdex2dxM3Swwf" +
       "zWBYLcpFrjiJvFoVlyS0JxkOT8M+yzddk7C8amskTkx6JIiI1VqPJJcwut35" +
       "ghubqCPXUEyZV30N5Z2aV7bxIm71HQHTKlFR9TZBsikjY7VXXKVdd5EI7JCJ" +
       "JNzgWst5SvsePIl4N50Nh/YwGk9Vk7VGSC2peYKDIyNlGXSphTIYx+tCZzGI" +
       "RJFbNIdCSLroWBVj0xvPxrRCi7rFBc15NI3KdmCGlUZr4Y2XbHmxcNdra9oz" +
       "J/U6XTN7PoH33K7r1kvrHpck00JAD4JyuylJgtnrtQZEOOmSThFlC4lfEAh+" +
       "zHGoNoK1dETiUwPvTyseMWpi3QU5lbtB4JObMZpKqRs1jCBaWYoaqLZFc51l" +
       "Neyh/TibiqIXVbD6hotSOVj2upTFimI0KEceb3QxWO7j7KxbtBfsysf95tgU" +
       "jdnCWJUGi9GgazQHDlbTeb+EjBdWC6Ft06m3l7NEWihJP2XrBdGaiu7GXkVN" +
       "t9tLuPZsKfsAMxuxE9XkEVY0sWFV9VW0Zij9GK9pZi1wxc5yISB9e90maHLe" +
       "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" +
       "v8vf/MHbfu9dv/Xit/Krvv8BUzug+p4gAAA=");
}
