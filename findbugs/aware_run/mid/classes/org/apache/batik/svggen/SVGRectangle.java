package org.apache.batik.svggen;
public class SVGRectangle extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    public SVGRectangle(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        svgLine =
          new org.apache.batik.svggen.SVGLine(
            generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Rectangle2D rect) {
        return toSVG(
                 (java.awt.geom.RectangularShape)
                   rect);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.RoundRectangle2D rect) {
        org.w3c.dom.Element svgRect =
          toSVG(
            (java.awt.geom.RectangularShape)
              rect);
        if (svgRect !=
              null &&
              svgRect.
              getTagName(
                ) ==
              SVG_RECT_TAG) {
            svgRect.
              setAttributeNS(
                null,
                SVG_RX_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcWidth(
                          ) /
                        2)));
            svgRect.
              setAttributeNS(
                null,
                SVG_RY_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcHeight(
                          ) /
                        2)));
        }
        return svgRect;
    }
    private org.w3c.dom.Element toSVG(java.awt.geom.RectangularShape rect) {
        if (rect.
              getWidth(
                ) >
              0 &&
              rect.
              getHeight(
                ) >
              0) {
            org.w3c.dom.Element svgRect =
              generatorContext.
                domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_RECT_TAG);
            svgRect.
              setAttributeNS(
                null,
                SVG_X_ATTRIBUTE,
                doubleString(
                  rect.
                    getX(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_Y_ATTRIBUTE,
                doubleString(
                  rect.
                    getY(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_WIDTH_ATTRIBUTE,
                doubleString(
                  rect.
                    getWidth(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_HEIGHT_ATTRIBUTE,
                doubleString(
                  rect.
                    getHeight(
                      )));
            return svgRect;
        }
        else {
            if (rect.
                  getWidth(
                    ) ==
                  0 &&
                  rect.
                  getHeight(
                    ) >
                  0) {
                java.awt.geom.Line2D line =
                  new java.awt.geom.Line2D.Double(
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ),
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ) +
                    rect.
                    getHeight(
                      ));
                return svgLine.
                  toSVG(
                    line);
            }
            else
                if (rect.
                      getWidth(
                        ) >
                      0 &&
                      rect.
                      getHeight(
                        ) ==
                      0) {
                    java.awt.geom.Line2D line =
                      new java.awt.geom.Line2D.Double(
                      rect.
                        getX(
                          ),
                      rect.
                        getY(
                          ),
                      rect.
                        getX(
                          ) +
                        rect.
                        getWidth(
                          ),
                      rect.
                        getY(
                          ));
                    return svgLine.
                      toSVG(
                        line);
                }
            return null;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2wU1xW+u8ZPDLYhYPMyYAwRj+yWQJpGpiHG4WG6xhYm" +
                                                              "SDVplrszd70DszOXmTv2mjQhULWgSkVpIAl9wJ8SVUWURFWj9k8oVdUmEU0j" +
                                                              "aNQmQU0f+dM2QQo/GtLS1zl3ZnZmZx8IVaqluTu+95xz73l959w5f53U2xbp" +
                                                              "4dRQaUJMcWYnRvB9hFo2Uwd0atu7YDatfPWPJw7d/HXz4ThpGCMzc9QeUqjN" +
                                                              "tmhMV+0xskgzbEENhdk7GFORY8RiNrMmqNBMY4zM0ezBPNc1RRNDpsqQYDe1" +
                                                              "UqSDCmFpGUewQU+AIItT8jRJeZpkf5SgL0VaFZNPBQzzSxgGQmtImw/2swVp" +
                                                              "T+2jEzTpCE1PpjRb9BUsspqb+tS4booEK4jEPv0+zxDbU/eVmaHnpbaPbz2d" +
                                                              "a5dmmE0NwxRSRXsns019gqkp0hbMbtZZ3j5AniR1KTI9RCxIb8rfNAmbJmFT" +
                                                              "X9+ACk4/gxlOfsCU6ghfUgNX8ECCLC0VwqlF856YEXlmkNAkPN0lM2i7pKit" +
                                                              "7+6Iis+uTp58/rH2H9SRtjHSphmjeBwFDiFgkzEwKMtnmGX3qypTx0iHAQ4f" +
                                                              "ZZZGde2g5+1ZtjZuUOFACPhmwUmHM0vuGdgKPAm6WY4iTKuoXlYGlfdffVan" +
                                                              "46Dr3EBXV8MtOA8KtmhwMCtLIfY8lmn7NUOVcVTKUdSx93NAAKyNeSZyZnGr" +
                                                              "aQaFCTLLDRGdGuPJUQg+YxxI600IQUvGWhWhaGtOlf10nKUF6YrSjbhLQNUs" +
                                                              "DYEsgsyJkklJ4KX5ES+F/HN9x4bjjxvbjDiJwZlVpuh4/unA1B1h2smyzGKQ" +
                                                              "By5j66rUc3TuK8fihADxnAixS/OjL954aE33pddcmgUVaIYz+5gi0srZzMwr" +
                                                              "CwdWPlCHx2jipq2h80s0l1k24q30FTggzdyiRFxM+IuXdv7i80+dYx/EScsg" +
                                                              "aVBM3clDHHUoZp5rOrO2MoNZVDB1kDQzQx2Q64OkEd5TmsHc2eFs1mZikEzT" +
                                                              "5VSDKf8HE2VBBJqoBd41I2v675yKnHwvcEJIIzykFZ5lxP2Tv4KwZM7MsyRV" +
                                                              "qKEZZnLEMlF/dKjEHGbDuwqr3ExmIP7337M2cX/SNh0LAjJpWuNJClGRY+5i" +
                                                              "0p4YH2dGcnT31p0gBUJMZwkMN/7/2qiAGs+ejMXAGQujUKBDFm0zdZVZaeWk" +
                                                              "s2nzjQvpy26YYWp4tgLwgt0S7m4JuVvC3S0R3o3EYnKTu3BX19vgq/2Q9QC7" +
                                                              "rStHv7B977GeOggzPjkNDI2kK8rK0EAADz6mp5XzV3befPONlnNxEgcEyUAZ" +
                                                              "CmpBb0ktcEuZZSpMBTCqVhV8ZExWrwMVz0EunZo8vPvQp+Q5wvCOAusBmZB9" +
                                                              "BEG5uEVvNK0ryW07+uePX3zuCTNI8JJ64Ze5Mk7EjZ6oS6PKp5VVS+jL6Vee" +
                                                              "6I2TaQBGAMCCQsIAtnVH9yjBjz4fi1GXJlA4a1p5quOSD6AtImeZk8GMjLUO" +
                                                              "+X4XuHg6JlQnPGu8DJO/uDqX49jpxibGTEQLifWfHeWn3/7VX9ZJc/tloS1U" +
                                                              "z0eZ6AtBEQqbJUGnIwjBXRZjQPe7UyMnnr1+dI+MP6BYVmnDXhwHAILAhWDm" +
                                                              "L7924J3fv3f2rXgQswJqsZOBtqZQVBLnSUsNJTHOg/MAlOmQMRg1vY8YEJVa" +
                                                              "VqMZnWGS/LNt+dqXPzze7saBDjN+GK25vYBgft4m8tTlx252SzExBUtpYLOA" +
                                                              "zMXn2YHkfsuiU3iOwuGri77xKj0NSA/oamsHmQTMmJe3eKguQVbXAAUPv03L" +
                                                              "6yKko9dLzqQc16GRpDwi1z6DQ68dTpjSnAy1SWnl6bc+mrH7o4s3pIalfVY4" +
                                                              "PoYo73NDEoflBRDfGQWnbdTOAd36Szsebdcv3QKJYyBRAYi1hy3AxUJJNHnU" +
                                                              "9Y3v/vRnc/deqSPxLaRFN6m6hcrEJM2QEczOAaQW+MaH3ICYbIKhXapKypRH" +
                                                              "Hyyu7N3NeS6kPw7+uPOHG7575j0ZiG7kLShi6JIyDJU9epD+H1771vs/ufmd" +
                                                              "RrfCr6yOeRG+rn8M65kjf/qkzMgS7Sp0HxH+seT5b88fePADyR/ADnIvK5TX" +
                                                              "IgDmgPfec/m/xXsafh4njWOkXfH64d1UdzCZx6AHtP0mGXrmkvXSfs5tXvqK" +
                                                              "sLowCnmhbaOAF9RAeEdqfJ8RwThsIMhCeO720v/uKMbFiHwZlCwr5LgShzU+" +
                                                              "pDRyS4N7E4tgyvQaQoEJkg1bIT8bF9fIRqRzkRbHB3DY7m62oVKMuksrcFhV" +
                                                              "PJL8a4h2S2GYC8KSYKYtqtbQymb87JGTZ9ThF9a6QTmrtEncDHeg7//mX79M" +
                                                              "nPrD6xW6kWZh8nt0NsH00J51sOXSslQYkv1+EFf3X71Zd+2ZrtbyTgIldVfp" +
                                                              "E1ZVz5noBq8e+ev8XQ/m9t5Bi7A4YqioyO8NnX996wrlmbi8srhhXHbVKWXq" +
                                                              "Kw3eFovB3czYVRLCPUXXzkaXdcGz3nPt+splukJUFItfNdYI5EdKyDwJfHRS" +
                                                              "JMaZmU8UW8l7H5ZbshoFQ8NhryD1woQI9wXOxiyYXKckVBCHl3Hm3aJl0NMa" +
                                                              "QV8OzDjRL6cfLTfVRk/fjXduqmqstU3VHTGV6Rhq1F5ODXtN4cB9e+E/+wPD" +
                                                              "HPifDSMhYh48w552w7cxTKoc7Kqx3plhXJs4OrVGc5Qzue+XahjmKA5PVjHM" +
                                                              "oTs3TEGQ1vC1CAt8V9knGPezgXLhTFtT55lHfitb8+LVvhWa2qyj6+H6E3pv" +
                                                              "4BbLavLwrW414vLnuCCdVaoA9K3uizz011z6rwvSHqUHO8jfMN1JQVoCOhDl" +
                                                              "voRJnhekDkjw9RT3PbO2VoNoUZ7TFLc8QymfgPsINFux0ipS9MOc2/khVHiW" +
                                                              "laC1/EbmI6vjfiVLKy+e2b7j8RuffsG9Wig6PXgQpUxPkUb3llNE56VVpfmy" +
                                                              "GratvDXzpeblcS+gOtwDB/G+IBRt/RC5HENifqTvtnuL7fc7ZzdcfONYw1Uo" +
                                                              "fXtIjAKq7SnvaArcgdKxJxUueaEvrfJK0Nfy/t43P3k3Nks2jsTtF7trcaSV" +
                                                              "ExevjWQ5/2acNA+SeqjUrCDbrYenDAjpCWhxmxxDO+CwQRUiMYMw5N8GZ2L8" +
                                                              "Uvx+Ji3jGXRGcRavpoL0lH0oq3Bdh556klmbULqsWJF65nAeXi3gZ6YKWoFv" +
                                                              "1p7++6GvvD0M+VVy8LC0RtvJFEtj+GtdUCvbXbD6D/zF4Pk3PuhSnMBf6DkH" +
                                                              "vC9XS4qfrjgvuGt16dQQ5x5t42UZBpxLtLggBZ/D4XwBKQSJreL8vxjkQA2m" +
                                                              "FwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hOUG+WVS+vv3/u7rPvXst/Pj2v8GYtMy2RAjAAA=");
}
