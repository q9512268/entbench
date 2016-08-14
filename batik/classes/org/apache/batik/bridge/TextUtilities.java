package org.apache.batik.bridge;
public abstract class TextUtilities implements org.apache.batik.util.CSSConstants, org.apache.batik.bridge.ErrorConstants {
    public static java.lang.String getElementContent(org.w3c.dom.Element e) {
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          );
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            switch (n.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    result.
                      append(
                        getElementContent(
                          (org.w3c.dom.Element)
                            n));
                    break;
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                case org.w3c.dom.Node.
                       TEXT_NODE:
                    result.
                      append(
                        n.
                          getNodeValue(
                            ));
            }
        }
        return result.
          toString(
            );
    }
    public static java.util.ArrayList svgHorizontalCoordinateArrayToUserSpace(org.w3c.dom.Element element,
                                                                              java.lang.String attrName,
                                                                              java.lang.String valueStr,
                                                                              org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            element);
        java.util.ArrayList values =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          valueStr,
          ", ",
          false);
        while (st.
                 hasMoreTokens(
                   )) {
            values.
              add(
                new java.lang.Float(
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      st.
                        nextToken(
                          ),
                      attrName,
                      uctx)));
        }
        return values;
    }
    public static java.util.ArrayList svgVerticalCoordinateArrayToUserSpace(org.w3c.dom.Element element,
                                                                            java.lang.String attrName,
                                                                            java.lang.String valueStr,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            element);
        java.util.ArrayList values =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          valueStr,
          ", ",
          false);
        while (st.
                 hasMoreTokens(
                   )) {
            values.
              add(
                new java.lang.Float(
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      st.
                        nextToken(
                          ),
                      attrName,
                      uctx)));
        }
        return values;
    }
    public static java.util.ArrayList svgRotateArrayToFloats(org.w3c.dom.Element element,
                                                             java.lang.String attrName,
                                                             java.lang.String valueStr,
                                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          valueStr,
          ", ",
          false);
        java.util.ArrayList values =
          new java.util.ArrayList(
          );
        java.lang.String s;
        while (st.
                 hasMoreTokens(
                   )) {
            try {
                s =
                  st.
                    nextToken(
                      );
                values.
                  add(
                    new java.lang.Float(
                      java.lang.Math.
                        toRadians(
                          org.apache.batik.bridge.SVGUtilities.
                            convertSVGNumber(
                              s))));
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  valueStr });
            }
        }
        return values;
    }
    public static java.lang.Float convertFontSize(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_SIZE_INDEX);
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public static java.lang.Float convertFontStyle(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_STYLE_INDEX);
        switch (v.
                  getStringValue(
                    ).
                  charAt(
                    0)) {
            case 'n':
                return java.awt.font.TextAttribute.
                         POSTURE_REGULAR;
            default:
                return java.awt.font.TextAttribute.
                         POSTURE_OBLIQUE;
        }
    }
    public static java.lang.Float convertFontStretch(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_STRETCH_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'u':
                if (s.
                      charAt(
                        6) ==
                      'c') {
                    return java.awt.font.TextAttribute.
                             WIDTH_CONDENSED;
                }
                else {
                    return java.awt.font.TextAttribute.
                             WIDTH_EXTENDED;
                }
            case 'e':
                if (s.
                      charAt(
                        6) ==
                      'c') {
                    return java.awt.font.TextAttribute.
                             WIDTH_CONDENSED;
                }
                else {
                    if (s.
                          length(
                            ) ==
                          8) {
                        return java.awt.font.TextAttribute.
                                 WIDTH_SEMI_EXTENDED;
                    }
                    else {
                        return java.awt.font.TextAttribute.
                                 WIDTH_EXTENDED;
                    }
                }
            case 's':
                if (s.
                      charAt(
                        6) ==
                      'c') {
                    return java.awt.font.TextAttribute.
                             WIDTH_SEMI_CONDENSED;
                }
                else {
                    return java.awt.font.TextAttribute.
                             WIDTH_SEMI_EXTENDED;
                }
            default:
                return java.awt.font.TextAttribute.
                         WIDTH_REGULAR;
        }
    }
    public static java.lang.Float convertFontWeight(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_WEIGHT_INDEX);
        float f =
          v.
          getFloatValue(
            );
        switch ((int)
                  f) {
            case 100:
                return java.awt.font.TextAttribute.
                         WEIGHT_EXTRA_LIGHT;
            case 200:
                return java.awt.font.TextAttribute.
                         WEIGHT_LIGHT;
            case 300:
                return java.awt.font.TextAttribute.
                         WEIGHT_DEMILIGHT;
            case 400:
                return java.awt.font.TextAttribute.
                         WEIGHT_REGULAR;
            case 500:
                return java.awt.font.TextAttribute.
                         WEIGHT_SEMIBOLD;
            default:
                return java.awt.font.TextAttribute.
                         WEIGHT_BOLD;
        }
    }
    public static org.apache.batik.gvt.TextNode.Anchor convertTextAnchor(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_ANCHOR_INDEX);
        switch (v.
                  getStringValue(
                    ).
                  charAt(
                    0)) {
            case 's':
                return org.apache.batik.gvt.TextNode.Anchor.
                         START;
            case 'm':
                return org.apache.batik.gvt.TextNode.Anchor.
                         MIDDLE;
            default:
                return org.apache.batik.gvt.TextNode.Anchor.
                         END;
        }
    }
    public static java.lang.Object convertBaselineShift(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              BASELINE_SHIFT_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            java.lang.String s =
              v.
              getStringValue(
                );
            switch (s.
                      charAt(
                        2)) {
                case 'p':
                    return java.awt.font.TextAttribute.
                             SUPERSCRIPT_SUPER;
                case 'b':
                    return java.awt.font.TextAttribute.
                             SUPERSCRIPT_SUB;
                default:
                    return null;
            }
        }
        else {
            return new java.lang.Float(
              v.
                getFloatValue(
                  ));
        }
    }
    public static java.lang.Float convertKerning(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              KERNING_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            return null;
        }
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public static java.lang.Float convertLetterSpacing(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              LETTER_SPACING_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            return null;
        }
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public static java.lang.Float convertWordSpacing(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              WORD_SPACING_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            return null;
        }
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public TextUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+Su+Rf4H3ST2qnMlAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LgVvQQ+wHjbq13C+H5F+VzDKqlWb+9MNGVKKRpnixjDwTj2OaltQL2HbHS0S" +
       "kQkmWGU17Jdnqb7COstwzG07vAg8L5zMtmYLlNJcu1LRNJBx2HUlXGFOTaLh" +
       "EO4st+1mpSb5LLcejVcNKxgkfomrLAWylgW4KjZqgqoEmtnrb2jCbG9XNE9E" +
       "Cw8X9FToaR2StZ2qaptpu7qpICQzLFvdRtg3K7ENBvAEMUz5tYOVmJolpXZL" +
       "KQ1k2BBoA9kkJpz2+t1mu6SBl0cHdhtTvGkkeDlSYwTxKAOtlYheZbwZ2pWx" +
       "HyzrcjdbeM1SreyvWtVshcSrTdIIG2O2FGles7xSa55eYnuuZ8SahnQp2MBA" +
       "8dBOsnk4WbCDlrzYUlGz1AjgVYXoeBE5HYAvD6e50GCeIHurbdcI7M1WGrRc" +
       "WDHMOTupkStpYvlLJ6xEHKyCz3/B7JmuSwayBj421Q2pSa1SOjZqYr1HNxiF" +
       "Nw3RcmcYs6pYC3Zu9vhubTsrm8oy5e0lsdJnAsZt65XBhF2BIkz18K4sbcNA" +
       "phaNtTCcxs1KK0S9rRfyi4o8D6qNuR0bblh833Gb0XztqROPXdKLTPXWTn1I" +
       "jeEi51SmXRgnkIgmtlG92VwZdB9pYFWMGU+TZjSRSkxSmmk1HGHY6soDcd/p" +
       "fH++HPBD39mKzMPF4tPRNqDlNPMHg+9gJWJ98wkP9ote94pSFIeiHK+PVuOL" +
       "v8vnrMafWLE8OFwFe+aGvZfdwjPDHG0GH5I+d6ttmn4Y+uEReb6o8+StNhWL" +
       "BZ1Pf+jlV5XxZyoH+zXkeQzdF/vBex01VZ0TQj4IOL371otXdLGnery2+fkP" +
       "/ekT7A8Y7/8Odm+ePiPnWZY/S7/224Pn5H96AN11tNJ5w27v6UHPn17fvD9U" +
       "4yT02FOrnE8e2ewtuYneDa737m323pvvoJzjC4Xz7fzuzDr9hf1G2N5+j+b2" +
       "yxD5uuK71/PjA6oXF+PW56zv/1jeRMChdTXejyk26L1iu2Jw7Mvxt1tVO8m5" +
       "6AiOtPBI3tkGF77XAv5d1MLFgupi/nNzFISDQ6Xccu+xW/zbH0YoGP/EOWr6" +
       "ybz5YAy9K0p13A/Nbb4q76C+HyqmJ8Zqsd3C+lykhkyQnyA4ufB52rNnYlaE" +
       "ywvyr06/8qVPbT/32m5dUxJBvodKtzrOceOJknz38NlzdkCPN/r/YvC9r3/1" +
       "f/I/fBiQbziyTG7E4uaWljnyrpvsLeWPPnbsIh+6XRdpgkvaCyLdcRfJmw8X" +
       "9P/iHMt/Km8+ARwJWJ5Xw9iUz7V7Tv3TN6r3XFQfO6PHT96GHt+Wd1bBFe1n" +
       "jP4/6vFnz9Hjv8qbT8fQY0CPszxzH+oOc3xx/xL66dPu8NZvB+Os4j5zG4p7" +
       "PO98F7he2s/40ndRcftMXSiuIPiVczT1q3nzSzF0Wfa9FHgcBnINY27Vw0i8" +
       "fLzNtNPdEf5/c7v484rilT3+V+4k/t88B//n8+b1uNi+PMIfb3ZHb37tGO1v" +
       "3C7a/L382T3az95JtF86B+1/yZsvxNAjp9CCqkI2zuD9T7eL9xq4vrjH+8U7" +
       "ifcPzsH75bz5vTg/knWEd66auhGfgfv7twH3mbwTAdc39nC/cSfhfvUcuF/L" +
       "mz86hpsfeep4srE/pQjC+eoNFYqexsXRqJGvqFdPEBdq+V+3oZaiGgUV6IWD" +
       "3djd/zullr86Ry3/J2/+PIbeuFdLFxQ/+Wk7xjC1+FAzJ/bTd8cRjrXwv283" +
       "Fp4Dor51r4W33kEtXLh0ay1cuCdvoBh6aK+FoRp6+4MKx4Fw4cLtYn0PEOja" +
       "Huu1O4n14XOwPpo3DxxbnFLjeFc03Yj4we9CZr/Q3CNu3knET56D+Om8efw4" +
       "s89B0XhzvG/5TvCuY+jBUwcn85Nfj99wFnt3flj+hVcv3/vmV7n/VpwdPDrj" +
       "ex8F3asljnPyoM6J+7uDUNXMQgP37Y7tBAWi52Lozbf4noqhu3c3ubwXnt3R" +
       "XwMxfJY+hi4V/0/SvSeG7j+mA6x2NydJ4Bi6C5Dkt+XCjt9a7z58Hz/pBkVu" +
       "eOTbafNoyMljhPn3U3Hu/XCpIJnsP9M+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9yo5+tFvNj6zO8YoO+J2m3O5l4Lu2Z2oLJjmyw3vuCW3Q15349e+9dAv3vfs" +
       "4ZfYQzuBj13yhGxP3/ycYN8N4uLra/vv3vxvv++zr/5hcbro7wFiAElAkDAA" +
       "AA==");
}
