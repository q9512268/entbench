package org.apache.batik.bridge;
public class SVGFontFaceElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public SVGFontFaceElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FONT_FACE_TAG; }
    public org.apache.batik.bridge.SVGFontFace createFontFace(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element fontFaceElement) {
        java.lang.String familyNames =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_FAMILY_ATTRIBUTE);
        java.lang.String unitsPerEmStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_UNITS_PER_EM_ATTRIBUTE);
        if (unitsPerEmStr.
              length(
                ) ==
              0) {
            unitsPerEmStr =
              SVG_FONT_FACE_UNITS_PER_EM_DEFAULT_VALUE;
        }
        float unitsPerEm;
        try {
            unitsPerEm =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  unitsPerEmStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_UNITS_PER_EM_ATTRIBUTE,
              unitsPerEmStr });
        }
        java.lang.String fontWeight =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_WEIGHT_ATTRIBUTE);
        if (fontWeight.
              length(
                ) ==
              0) {
            fontWeight =
              SVG_FONT_FACE_FONT_WEIGHT_DEFAULT_VALUE;
        }
        java.lang.String fontStyle =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_STYLE_ATTRIBUTE);
        if (fontStyle.
              length(
                ) ==
              0) {
            fontStyle =
              SVG_FONT_FACE_FONT_STYLE_DEFAULT_VALUE;
        }
        java.lang.String fontVariant =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_VARIANT_ATTRIBUTE);
        if (fontVariant.
              length(
                ) ==
              0) {
            fontVariant =
              SVG_FONT_FACE_FONT_VARIANT_DEFAULT_VALUE;
        }
        java.lang.String fontStretch =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_STRETCH_ATTRIBUTE);
        if (fontStretch.
              length(
                ) ==
              0) {
            fontStretch =
              SVG_FONT_FACE_FONT_STRETCH_DEFAULT_VALUE;
        }
        java.lang.String slopeStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_SLOPE_ATTRIBUTE);
        if (slopeStr.
              length(
                ) ==
              0) {
            slopeStr =
              SVG_FONT_FACE_SLOPE_DEFAULT_VALUE;
        }
        float slope;
        try {
            slope =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  slopeStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              slopeStr });
        }
        java.lang.String panose1 =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_PANOSE_1_ATTRIBUTE);
        if (panose1.
              length(
                ) ==
              0) {
            panose1 =
              SVG_FONT_FACE_PANOSE_1_DEFAULT_VALUE;
        }
        java.lang.String ascentStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_ASCENT_ATTRIBUTE);
        if (ascentStr.
              length(
                ) ==
              0) {
            ascentStr =
              java.lang.String.
                valueOf(
                  unitsPerEm *
                    0.8);
        }
        float ascent;
        try {
            ascent =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  ascentStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              ascentStr });
        }
        java.lang.String descentStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_DESCENT_ATTRIBUTE);
        if (descentStr.
              length(
                ) ==
              0) {
            descentStr =
              java.lang.String.
                valueOf(
                  unitsPerEm *
                    0.2);
        }
        float descent;
        try {
            descent =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  descentStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              descentStr });
        }
        java.lang.String underlinePosStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_UNDERLINE_POSITION_ATTRIBUTE);
        if (underlinePosStr.
              length(
                ) ==
              0) {
            underlinePosStr =
              java.lang.String.
                valueOf(
                  -3 *
                    unitsPerEm /
                    40);
        }
        float underlinePos;
        try {
            underlinePos =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  underlinePosStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              underlinePosStr });
        }
        java.lang.String underlineThicknessStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_UNDERLINE_THICKNESS_ATTRIBUTE);
        if (underlineThicknessStr.
              length(
                ) ==
              0) {
            underlineThicknessStr =
              java.lang.String.
                valueOf(
                  unitsPerEm /
                    20);
        }
        float underlineThickness;
        try {
            underlineThickness =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  underlineThicknessStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              underlineThicknessStr });
        }
        java.lang.String strikethroughPosStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_STRIKETHROUGH_POSITION_ATTRIBUTE);
        if (strikethroughPosStr.
              length(
                ) ==
              0) {
            strikethroughPosStr =
              java.lang.String.
                valueOf(
                  3 *
                    ascent /
                    8);
        }
        float strikethroughPos;
        try {
            strikethroughPos =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  strikethroughPosStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              strikethroughPosStr });
        }
        java.lang.String strikethroughThicknessStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_STRIKETHROUGH_THICKNESS_ATTRIBUTE);
        if (strikethroughThicknessStr.
              length(
                ) ==
              0) {
            strikethroughThicknessStr =
              java.lang.String.
                valueOf(
                  unitsPerEm /
                    20);
        }
        float strikethroughThickness;
        try {
            strikethroughThickness =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  strikethroughThicknessStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              strikethroughThicknessStr });
        }
        java.lang.String overlinePosStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_OVERLINE_POSITION_ATTRIBUTE);
        if (overlinePosStr.
              length(
                ) ==
              0) {
            overlinePosStr =
              java.lang.String.
                valueOf(
                  ascent);
        }
        float overlinePos;
        try {
            overlinePos =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  overlinePosStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              overlinePosStr });
        }
        java.lang.String overlineThicknessStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_OVERLINE_THICKNESS_ATTRIBUTE);
        if (overlineThicknessStr.
              length(
                ) ==
              0) {
            overlineThicknessStr =
              java.lang.String.
                valueOf(
                  unitsPerEm /
                    20);
        }
        float overlineThickness;
        try {
            overlineThickness =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  overlineThicknessStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              overlineThicknessStr });
        }
        java.util.List srcs =
          null;
        org.w3c.dom.Element fontElt =
          org.apache.batik.bridge.SVGUtilities.
          getParentElement(
            fontFaceElement);
        if (!fontElt.
              getNamespaceURI(
                ).
              equals(
                SVG_NAMESPACE_URI) ||
              !fontElt.
              getLocalName(
                ).
              equals(
                SVG_FONT_TAG)) {
            srcs =
              getFontFaceSrcs(
                fontFaceElement);
        }
        return new org.apache.batik.bridge.SVGFontFace(
          fontFaceElement,
          srcs,
          familyNames,
          unitsPerEm,
          fontWeight,
          fontStyle,
          fontVariant,
          fontStretch,
          slope,
          panose1,
          ascent,
          descent,
          strikethroughPos,
          strikethroughThickness,
          underlinePos,
          underlineThickness,
          overlinePos,
          overlineThickness);
    }
    public java.util.List getFontFaceSrcs(org.w3c.dom.Element fontFaceElement) {
        org.w3c.dom.Element ffsrc =
          null;
        for (org.w3c.dom.Node n =
               fontFaceElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE &&
                  n.
                  getNamespaceURI(
                    ).
                  equals(
                    SVG_NAMESPACE_URI) &&
                  n.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_FACE_SRC_TAG)) {
                ffsrc =
                  (org.w3c.dom.Element)
                    n;
                break;
            }
        }
        if (ffsrc ==
              null)
            return null;
        java.util.List ret =
          new java.util.LinkedList(
          );
        for (org.w3c.dom.Node n =
               ffsrc.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE ||
                  !n.
                  getNamespaceURI(
                    ).
                  equals(
                    SVG_NAMESPACE_URI))
                continue;
            if (n.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_FACE_URI_TAG)) {
                org.w3c.dom.Element ffuri =
                  (org.w3c.dom.Element)
                    n;
                java.lang.String uri =
                  org.apache.batik.dom.util.XLinkSupport.
                  getXLinkHref(
                    ffuri);
                java.lang.String base =
                  org.apache.batik.dom.AbstractNode.
                  getBaseURI(
                    ffuri);
                org.apache.batik.util.ParsedURL purl;
                if (base !=
                      null)
                    purl =
                      new org.apache.batik.util.ParsedURL(
                        base,
                        uri);
                else
                    purl =
                      new org.apache.batik.util.ParsedURL(
                        uri);
                ret.
                  add(
                    purl);
                continue;
            }
            if (n.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_FACE_NAME_TAG)) {
                org.w3c.dom.Element ffname =
                  (org.w3c.dom.Element)
                    n;
                java.lang.String s =
                  ffname.
                  getAttribute(
                    "name");
                if (s.
                      length(
                        ) !=
                      0)
                    ret.
                      add(
                        s);
            }
        }
        return ret;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "psmD9AJrvvJvLN+wHGwYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CHxOgee/sydTd9ax3VZvr+3t7Q8cbO6um54Cq/V0Ybe8i2b4b8mpPJi3F7Pm" +
       "Z7Zmyl5/FizrIM9MAcZCtyUzn/ipELiYKV/cp86DTBXY5KJhlnMyrwW5ee5O" +
       "mfS72/RuG9CytpCT2LoEcVX3eeMWKt+5bj0kxjogU3z/P33wKx94+BvApm3o" +
       "dJzpG5jyyIxclCXPv/zi8/fe9Nw3359HKRCi+h+mLzyVUWWvJXHW0FnD7It6" +
       "TybqKN/2WSkIu3lgUZVc2mu6ct/XLRB/473MEHn69m+sPvqtT2+zvpN+ewJY" +
       "fd9zv/Kj3Wef2zmSaz98Wbp7FGebb+dM37KnYR968Fqz5BjMP7/09B/9ztPP" +
       "bLm6/XjmSIOD0af/6r++svuRb37pCqnI9abzExg2vKXSLAat6v6nywtqIZmk" +
       "qbXowV071Ss1V6t2G+2oMywQxkqoSpNEL/arqQ0XnLG3mTJCgcA3ZlkoYFiB" +
       "gDd1k2rp6FwbMqNJhY796gIdrebDKjfhZxPO7Aw81OVarqNL3NhCJdGtoAo7" +
       "KY2TIdr14di1RBPGFVimw6nbj3yLtKYwbKnwHEcW5Ti0NxxWI+YSM6XhoGOE" +
       "jXrbZ4waOBUlbZEza0WugIi9Eo13DASP0jYzj0tLuLGa8IOSFlFcQHb9eZtx" +
       "eUc3CjTjeaXxnI7ocjSjWzNuxBh0OxQc1/O0eokmvLCgdMc8z1tW3xlWrW5L" +
       "D3sNnzYZ1+uswnZY6lWdFZ/GWtQuo3OpQc0do8NJhXG1D2t9i0Bxp+YkaUFY" +
       "I/YKGw7wZNEM+JHpeRLDKGHBtTYo7Y/RarEnJRK3Gq65stKPlHSd9mcEshyG" +
       "0qxkIJW+MG4luFyf91JfiyZWwcBpMh4MndVoiPBwuSBxYi8BLEcO2yIsyhm4" +
       "khOVddRLvOqIjeJ5aeLXy9PJuC/6Tne+JDCOnwrdMBgMJ/HaFA0h0czmWGDj" +
       "xng4mchKoa9ZwUxNxVJK4OvucNwpTcdjmHRhpih6GlkjJQdOWMFI1oLD1lt0" +
       "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" +
       "L2Rt/uCu33vTb7/w9fxu/H8AWlnCr7AjAAA=");
}
