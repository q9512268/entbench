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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sselfwGws/Vm/xgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zrVn33/bX33vb2cW9baLuOvm+7tWY/x3ESOxQKTmLH" +
       "jp237cTe4OJn4sSv2E7iGDoe2lY2pIJGy5gE/WODbaBC2TS0TRNTp2kDBJrE" +
       "hPaSBmibNBhDon/A0NjGjp3f+z5YxbRIPnHO+X6/5/s6H399Tl74NnQ6CiE4" +
       "8J3NxPHjXTOJd2dOeTfeBGa02+LLPTWMTKPuqFEkgL5L+kOfPv+9H7x/emEH" +
       "OqNAd6ie58dqbPteNDAj31mZBg+dP+ylHNONYugCP1NXKrKMbQfh7Sh+godu" +
       "OsIaQxf5fRUQoAICVEByFRDykAow3WJ6S7eecaheHC2gn4dO8dCZQM/Ui6EH" +
       "jwsJ1FB198T0cguAhBuy3xIwKmdOQuiBA9u3Nl9m8HMw8uyvveXC710HnVeg" +
       "87Y3zNTRgRIxmESBbnZNVzPDiDQM01Cg2zzTNIZmaKuOneZ6K9DtkT3x1HgZ" +
       "mgdOyjqXgRnmcx567mY9sy1c6rEfHphn2aZj7P86bTnqBNh656GtWwvprB8Y" +
       "eM4GioWWqpv7LNfPbc+IoftPchzYeJEDBID1rGvGU/9gqus9FXRAt29j56je" +
       "BBnGoe1NAOlpfwlmiaF7rio083Wg6nN1Yl6KobtP0vW2Q4DqxtwRGUsMvfok" +
       "WS4JROmeE1E6Ep9vd17/zNs8xtvJdTZM3cn0vwEw3XeCaWBaZmh6urllvPlx" +
       "/oPqnZ99zw4EAeJXnyDe0vzB219+02vve+nzW5qfvAJNV5uZenxJ/6h265df" +
       "U3+sel2mxg2BH9lZ8I9Znqd/b2/kiSQAK+/OA4nZ4O7+4EuDv5Df+QnzWzvQ" +
       "ORY6o/vO0gV5dJvuu4HtmGHT9MxQjU2DhW40PaOej7PQWXDP25657e1aVmTG" +
       "LHS9k3ed8fPfwEUWEJG56Cy4tz3L378P1Hia3ycBBEFnwQW9EVyPQtvPI1kT" +
       "Qzoy9V0TUXXVsz0f6YV+Zn+EmF6sAd9OEQ1k/RyJ/GUIUhDxwwmigjyYmnsD" +
       "WmgbExMZSk0auIcGeZphBOCu5QO7WbIF/z/TJJm1F9anToFAvOYkDDiAhfEd" +
       "wwwv6c8ua9TLn7r0xZ2DZbHnpxgqgJl3tzPv5jPvbmfevdrM0KlT+YSvyjTY" +
       "Rh3EbA5WP8DFmx8bvrn11vc8dB1It2B9PXB4RopcHZ7rh3jB5qiog6SFXvrQ" +
       "+l3SOwo70M5xnM20Bl3nMvZeho4HKHjx5Pq6ktzzT3/jey9+8Cn/cKUdA+49" +
       "ALicM1vAD530b+jrpgEg8VD84w+on7n02acu7kDXA1QASBirIHMByNx3co5j" +
       "C/mJfVDMbDkNDLb80FWdbGgfyc7F09BfH/bkgb81v78N+PimLLMfBhe8l+r5" +
       "dzZ6R5C1r9omSha0E1bkoPuGYfCRv/3Lb2K5u/fx+fyRJ97QjJ84ggmZsPP5" +
       "6r/tMAeE0DQB3T98qPeB57799M/mCQAoHr7ShBeztg6wAIQQuPkXP7/4u699" +
       "9aNf2TlMmhg8FJeaY+vJgZFZP3TuGkaC2R491AdgigMWXJY1F0XP9Q3bslXN" +
       "MbMs/c/zj6Cf+bdnLmzzwAE9+2n02h8t4LD/J2rQO7/4ln+/LxdzSs+eaYc+" +
       "OyTbAuUdh5LJMFQ3mR7Ju/7q3l//nPoRALkA5iI7NXPkgnIfQHnQkNz+x/N2" +
       "98QYmjX3R0eT//j6OlJ7XNLf/5Xv3CJ9509ezrU9XrwcjXVbDZ7YplfWPJAA" +
       "8XedXOmMGk0BXemlzs9dcF76AZCoAIk6wLGoGwLASY5lxh716bN//6d/dudb" +
       "v3wdtEND5xxfNQC0ZIsMuhFktxlNAVYlwRvftA3u+gbQXMhNhS4zfpsUd+e/" +
       "rgMKPnZ1fKGz2uNwid79H11He/c/fv8yJ+TIcoVH7gl+BXnhw/fUn/xWzn+4" +
       "xDPu+5LLQRjUaYe8xU+439156Myf70BnFeiCvlcESqqzzBaOAgqfaL8yBIXi" +
       "sfHjRcz2if3EAYS95iS8HJn2JLgcgj+4z6iz+3NH8eSH4HMKXP+dXZm7s47t" +
       "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" +
       "/ref/2q+p/4/pzUJzMwjAAA=");
}
