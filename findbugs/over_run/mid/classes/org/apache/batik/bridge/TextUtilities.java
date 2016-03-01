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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1afZAUxRXv3fvg7uC4D+RD0AMvB3jA7YYgXJkjiXAB7mAP" +
       "LncHmkNdZmd7dwdmZ8aZ3rvljEG0jCSVoiz5CEkK/iAYlCJqrFhGqySkkvKj" +
       "UCjUSvxIDIl/qDFU4I9AUhiT97pnd2ZnPy6ELbdqemenX7/u9+vXv35veo+f" +
       "J1WWSVoNSYtKAbbdoFagH+/7JdOi0W5VsqwheBqWv/fnPTsuv1m700+qh8nk" +
       "hGT1yZJFVytUjVrD5EZFs5ikydRaT2kUW/Sb1KLmiMQUXRsmUxWrN2moiqyw" +
       "Pj1KUWCTZIZIk8SYqURSjPbaChiZHeKjCfLRBFd4BbpCZJKsG9udBjNzGnS7" +
       "6lA26fRnMdIY2iqNSMEUU9RgSLFYV9okCw1d3R5XdRagaRbYqi61gVgbWpoH" +
       "Q+vTDZeuPJJo5DBMkTRNZ9xEa4BaujpCoyHS4DxdpdKkdQ/5NqkIkYkuYUba" +
       "QplOg9BpEDrN2OtIwejrqZZKduvcHJbRVG3IOCBGbspVYkimlLTV9PMxg4Ya" +
       "ZtvOG4O1c7LWZqbbY+K+hcG9P7i78ZkK0jBMGhRtEIcjwyAYdDIMgNJkhJrW" +
       "imiURodJkwYTPkhNRVKVMXu2my0lrkksBS6QgQUfpgxq8j4drGAmwTYzJTPd" +
       "zJoX405l/6qKqVIcbJ3m2CosXI3PwcA6BQZmxiTwPbtJ5TZFi3I/ym2RtbFt" +
       "HQhA0wlJyhJ6tqtKTYIHpFm4iCpp8eAgOJ8WB9EqHVzQ5L5WRClibUjyNilO" +
       "w4zM8Mr1iyqQquVAYBNGpnrFuCaYpZmeWXLNz/n1y3ffq/VofuKDMUeprOL4" +
       "J0KjFk+jARqjJoV1IBpOWhDaL017cZefEBCe6hEWMs996+Jti1pOviJkZhWQ" +
       "2RDZSmUWlo9EJp+9obv91gocRo2hWwpOfo7lfJX12zVdaQOYZlpWI1YGMpUn" +
       "B1765v3H6Cd+UtdLqmVdTSXBj5pkPWkoKjXXUI2aEqPRXlJLtWg3r+8lE+A+" +
       "pGhUPN0Qi1mU9ZJKlT+q1vlvgCgGKhCiOrhXtJieuTckluD3aYMQ0ggXWQfX" +
       "zUR8+DcjsWBCT9KgJEuaounBflNH+3FCOedQC+6jUGvowQj4/7aOxYHOoKWn" +
       "THDIoG7GgxJ4RYKKymDEVKJxGhyCpbQRAADjAVb0N+Nz6ymNNk8Z9flgOm7w" +
       "koEK66hHV6PUDMt7UytXXXwyfEo4Gi4OGy1G5kJ3AdFdgHcXEN0FcrojPh/v" +
       "5TrsVkw4TNc2WPjAvJPaB+9au2VXawV4mjFaCVij6Ly8najbYYgMrYfl42cH" +
       "Lp95ve6Yn/iBRCKwEznbQVvOdiB2M1OXaRT4qNjGkCHHYPGtoOA4yMkDozs3" +
       "7fgiH4eb4VFhFZATNu9HXs520eZd2YX0Njz80aWn9t+nO2s8Z8vI7HR5LZE6" +
       "Wr1z6jU+LC+YIz0bfvG+Nj+pBD4CDmYSrBmgtxZvHzkU0pWhY7SlBgyO6WZS" +
       "UrEqw6F1LGHqo84T7mxNWEwVfofu4BkgZ/KvDBoH3z798RKOZIb0G1y79SBl" +
       "XS6iQWXNnFKaHO8aMikFuT8e6N+z7/zDm7lrgcQXCnXYhmU3EAzMDiD40Cv3" +
       "vPOn94+85XfckcFOm4pA0JLmtlz3H/j44PoMLyQHfCBIornbZqo5WaoysOd5" +
       "ztiAtFRYzugcbRs1cD4lpkgRleJa+LRh7uJn/7a7UUy3Ck8y3rJofAXO8+tX" +
       "kvtP3X25havxybhpOvg5YoKJpziaV5imtB3Hkd75xo0/fFk6CJwOPGopY5RT" +
       "I+F4ED6Bt3Asgrxc4qlbhkWb5fbx3GXkCm7C8iNvXajfdOHERT7a3OjIPe99" +
       "ktElvEjMAnQWInaRQ9VYO83AcnoaxjDdSzo9kpUAZbecXH9no3ryCnQ7DN3K" +
       "QJ7WBhMIL53jSrZ01YR3f/2baVvOVhD/alKn6lJ0tcQXHKkFT6dWArgybXzt" +
       "NjGO0ZrMRpImeQgh6LMLT+eqpMH4BIz9cvovlh899D73QuF2s+zm/MdcXt6M" +
       "xUL+3I+3ixipkSLABTC0dBYl/mkogZJLvZ/fz2CkNY/YxWAHB7NRaEZ0XrE9" +
       "YJVp6mZWHOfixmLRDI/Ejjyw91B0w2OLRczRnBshrIIA+Ge/+/drgQPnXi2w" +
       "EdUy3ehQ6QhVXdbUQ5c35W0kfTzYc0iw843LFe89OmNS/h6CmlqK7BALiu8Q" +
       "3g5efuCvM4e+mthyFZvDbA9QXpVP9B1/dc08+VE/j1fFvpAX5+Y26nJDBp2a" +
       "FAJzDc3CJ/V8abVmneZ69JEFcHXYTtPhXVqCxUs6Y7XFUwbHFbkHN5XQ6iEV" +
       "nx0P2J42BT1tdIkciOrJAOZUVGN8HJtLkFEYiyFGmuKU2W14DmPnUaC2kS9G" +
       "jPMDIs7nFZ1YbBRj7/rfFjY+uI0/7s+a3IxVt8LVY5vcc9VAYnFHARDX2BrX" +
       "lAaxkquqxJ93YiHxImN80QhuJf+y0z0+SLUEyrznGCPzrZF4j24qYxhLqN26" +
       "bkYVSAEp31qG9I0WNQcNzNHQx10rE98GDKaAuwakUc4KYfn7rQ/tnD/h4jJB" +
       "B3MKSrvSoSWXlzXMOfa4JsTbCivPTYT+cu+pw/ofPvFnkpxCTYTkOqvvzAs9" +
       "H4b5Eq5BjsguHBc/rDDjrminMTtjixCmpXA9Yc8Y/2Zka1kDfVACWb+SBAcO" +
       "DilJGrW9PZNWfI69IdfPyiNeZ2qffeGnnbsW3XFYAH9TESp15J//xrmzB8ee" +
       "Oi6IH+FnZGGxNyf5r2swGp5bIqJ3nOgfa7588uMPNt3lt916Mhaj6SwBFYiV" +
       "sGpHHmNhhutxJ9FD9eKD/9rxnbc3QMjdS2pSmnJPivZGc7l5gpWKuPzLeVHg" +
       "MHUjFh1pjDwZ8S0w7CCBk1a8PKTVCVfEdthI2UhLsjVK/w9pYZHkfe8uwUWP" +
       "YLELqA24aBNkM4pciolQeMQB77vXDN4NWPUluCzbVKts4BXTeJXg/bgEeAex" +
       "2AcpA4A3gIFKBrDVEPSKLdOF1v5rRmsGVs2Ha7dt2+6yoVVMY+Egg6PFO3u8" +
       "BDzHsDgMmQkkyyPgW6thnxuE/CjDEA1OLOEAxqH6SXmgwuD9gG3YgbJBVUzj" +
       "eFA9VwKq57H4OYRXbqjYdvEO7rgDzDPlAQaD1aO2GUfLBkwxjeMB89sSwLyE" +
       "xQlGmnOAgXhcTnig+VV5oGmH67RtyOmyQVNM43jQnC0BzZtYnGL4xjcLze1U" +
       "iSeYB5nXrhmZVqxCqQu2HRfKhkwxjeMh834JZM5h8baDDL5gXaHJCfu8BKin" +
       "LS+Sj48w/iJ2PUQfbS5hjuA714wgzxEhg/P5hQbxXQ4Ei2ocD8HzJRD8OxYf" +
       "MnKdjeBKCCPxiGAwocQK5YLigMMB7KPyLMZ5MOBZtnmzygZYMY3jAfZpCcA+" +
       "w+ISI5NtwNZREzKHuGclXi4PLJAj+dptI9rLBksxjePA4qstDotvIhYVjh+F" +
       "KGMilswDx1dZtr3N12mb0lk2cIppHA+caSXAmYFFo7O33Q5hd2Fomq4emjQj" +
       "9TkHS/gqdUbeObY4e5WfPNRQM/3Qxt/zw43s+egkyN9jKVV1pVvu1KvaMGlM" +
       "4ZhOEm+bDW7XbEamF3lTwki1uMFR+1qEfCtQiVeekSr+7Zaby0idIweqxI1b" +
       "5GZGKkAEb9uNojyVFm/Jct4S8/U5dTycs03cBySYJPP/EWQS2FS/nYs/dWjt" +
       "+nsvLntMHNDIqjQ2hlomQtoqjoG40oq8vN6tLaOruqf9yuSna+dm0u2cAyL3" +
       "2Pj0gxPyw5SZnizcassm4+8cWX7i9V3Vb/iJbzPxSZCxb3ad4gukutJGyiSz" +
       "N4cKJeibJJMfpnTVfbDlzD/f9TXzN/BEpPQtpVqE5T0n3uuPGcaP/KS2l1Qp" +
       "WpSmh0mdYn19uzZA5REzJ9+vjugpLfuXg8nonhK+e+TI2IDWZ5/i2R0jrXl/" +
       "Jihwnlmn6qPUXInaUU2957VvyjDctRzZB7DoSCPS4GvhUJ9h2Eda/g6OvGHg" +
       "AvQtxx8P/hcrvKC3LCQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "md1xRMWVttucy300dO/uZGTBNF9ueNct");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("uR3xuoe8/q2Hf+H+546+xB7eCXzikqdke+bm5/06XpgUX1/bf//Wf/e9n33t" +
       "D4pTQv8fAqa2J3QwAAA=");
}
