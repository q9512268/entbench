package org.apache.batik.bridge;
public abstract class SVGFontUtilities implements org.apache.batik.util.SVGConstants {
    public static java.util.List getFontFaces(org.w3c.dom.Document doc, org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map fontFamilyMap =
          ctx.
          getFontFamilyMap(
            );
        java.util.List ret =
          (java.util.List)
            fontFamilyMap.
            get(
              doc);
        if (ret !=
              null)
            return ret;
        ret =
          new java.util.LinkedList(
            );
        org.w3c.dom.NodeList fontFaceElements =
          doc.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_FONT_FACE_TAG);
        org.apache.batik.bridge.SVGFontFaceElementBridge fontFaceBridge;
        fontFaceBridge =
          (org.apache.batik.bridge.SVGFontFaceElementBridge)
            ctx.
            getBridge(
              SVG_NAMESPACE_URI,
              SVG_FONT_FACE_TAG);
        for (int i =
               0;
             i <
               fontFaceElements.
               getLength(
                 );
             i++) {
            org.w3c.dom.Element fontFaceElement =
              (org.w3c.dom.Element)
                fontFaceElements.
                item(
                  i);
            ret.
              add(
                fontFaceBridge.
                  createFontFace(
                    ctx,
                    fontFaceElement));
        }
        org.apache.batik.css.engine.CSSEngine engine =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             doc).
          getCSSEngine(
            );
        java.util.List sms =
          engine.
          getFontFaces(
            );
        java.util.Iterator iter =
          sms.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.css.engine.FontFaceRule ffr =
              (org.apache.batik.css.engine.FontFaceRule)
                iter.
                next(
                  );
            ret.
              add(
                org.apache.batik.bridge.CSSFontFace.
                  createCSSFontFace(
                    engine,
                    ffr));
        }
        return ret;
    }
    public static org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.w3c.dom.Element textElement,
                                                                        org.apache.batik.bridge.BridgeContext ctx,
                                                                        java.lang.String fontFamilyName,
                                                                        java.lang.String fontWeight,
                                                                        java.lang.String fontStyle) {
        java.lang.String fontKeyName =
          fontFamilyName.
          toLowerCase(
            ) +
        " " +
        fontWeight +
        " " +
        fontStyle;
        java.util.Map fontFamilyMap =
          ctx.
          getFontFamilyMap(
            );
        org.apache.batik.gvt.font.GVTFontFamily fontFamily =
          (org.apache.batik.gvt.font.GVTFontFamily)
            fontFamilyMap.
            get(
              fontKeyName);
        if (fontFamily !=
              null) {
            return fontFamily;
        }
        org.w3c.dom.Document doc =
          textElement.
          getOwnerDocument(
            );
        java.util.List fontFaces =
          (java.util.List)
            fontFamilyMap.
            get(
              doc);
        if (fontFaces ==
              null) {
            fontFaces =
              getFontFaces(
                doc,
                ctx);
            fontFamilyMap.
              put(
                doc,
                fontFaces);
        }
        java.util.Iterator iter =
          fontFaces.
          iterator(
            );
        java.util.List svgFontFamilies =
          new java.util.LinkedList(
          );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.bridge.FontFace fontFace =
              (org.apache.batik.bridge.FontFace)
                iter.
                next(
                  );
            if (!fontFace.
                  hasFamilyName(
                    fontFamilyName)) {
                continue;
            }
            java.lang.String fontFaceStyle =
              fontFace.
              getFontStyle(
                );
            if (fontFaceStyle.
                  equals(
                    SVG_ALL_VALUE) ||
                  fontFaceStyle.
                  indexOf(
                    fontStyle) !=
                  -1) {
                org.apache.batik.gvt.font.GVTFontFamily ffam =
                  fontFace.
                  getFontFamily(
                    ctx);
                if (ffam !=
                      null)
                    svgFontFamilies.
                      add(
                        ffam);
            }
        }
        if (svgFontFamilies.
              size(
                ) ==
              1) {
            fontFamilyMap.
              put(
                fontKeyName,
                svgFontFamilies.
                  get(
                    0));
            return (org.apache.batik.gvt.font.GVTFontFamily)
                     svgFontFamilies.
                     get(
                       0);
        }
        else
            if (svgFontFamilies.
                  size(
                    ) >
                  1) {
                java.lang.String fontWeightNumber =
                  getFontWeightNumberString(
                    fontWeight);
                java.util.List fontFamilyWeights =
                  new java.util.ArrayList(
                  svgFontFamilies.
                    size(
                      ));
                java.util.Iterator ffiter =
                  svgFontFamilies.
                  iterator(
                    );
                while (ffiter.
                         hasNext(
                           )) {
                    org.apache.batik.gvt.font.GVTFontFace fontFace;
                    fontFace =
                      ((org.apache.batik.gvt.font.GVTFontFamily)
                         ffiter.
                         next(
                           )).
                        getFontFace(
                          );
                    java.lang.String fontFaceWeight =
                      fontFace.
                      getFontWeight(
                        );
                    fontFaceWeight =
                      getFontWeightNumberString(
                        fontFaceWeight);
                    fontFamilyWeights.
                      add(
                        fontFaceWeight);
                }
                java.util.List newFontFamilyWeights =
                  new java.util.ArrayList(
                  fontFamilyWeights);
                for (int i =
                       100;
                     i <=
                       900;
                     i +=
                       100) {
                    java.lang.String weightString =
                      java.lang.String.
                      valueOf(
                        i);
                    boolean matched =
                      false;
                    int minDifference =
                      1000;
                    int minDifferenceIndex =
                      0;
                    for (int j =
                           0;
                         j <
                           fontFamilyWeights.
                           size(
                             );
                         j++) {
                        java.lang.String fontFamilyWeight =
                          (java.lang.String)
                            fontFamilyWeights.
                            get(
                              j);
                        if (fontFamilyWeight.
                              indexOf(
                                weightString) >
                              -1) {
                            matched =
                              true;
                            break;
                        }
                        java.util.StringTokenizer st =
                          new java.util.StringTokenizer(
                          fontFamilyWeight,
                          " ,");
                        while (st.
                                 hasMoreTokens(
                                   )) {
                            int weightNum =
                              java.lang.Integer.
                              parseInt(
                                st.
                                  nextToken(
                                    ));
                            int difference =
                              java.lang.Math.
                              abs(
                                weightNum -
                                  i);
                            if (difference <
                                  minDifference) {
                                minDifference =
                                  difference;
                                minDifferenceIndex =
                                  j;
                            }
                        }
                    }
                    if (!matched) {
                        java.lang.String newFontFamilyWeight =
                          newFontFamilyWeights.
                          get(
                            minDifferenceIndex) +
                        ", " +
                        weightString;
                        newFontFamilyWeights.
                          set(
                            minDifferenceIndex,
                            newFontFamilyWeight);
                    }
                }
                for (int i =
                       0;
                     i <
                       svgFontFamilies.
                       size(
                         );
                     i++) {
                    java.lang.String fontFaceWeight =
                      (java.lang.String)
                        newFontFamilyWeights.
                        get(
                          i);
                    if (fontFaceWeight.
                          indexOf(
                            fontWeightNumber) >
                          -1) {
                        fontFamilyMap.
                          put(
                            fontKeyName,
                            svgFontFamilies.
                              get(
                                i));
                        return (org.apache.batik.gvt.font.GVTFontFamily)
                                 svgFontFamilies.
                                 get(
                                   i);
                    }
                }
                fontFamilyMap.
                  put(
                    fontKeyName,
                    svgFontFamilies.
                      get(
                        0));
                return (org.apache.batik.gvt.font.GVTFontFamily)
                         svgFontFamilies.
                         get(
                           0);
            }
            else {
                org.apache.batik.gvt.font.GVTFontFamily gvtFontFamily =
                  new org.apache.batik.gvt.font.UnresolvedFontFamily(
                  fontFamilyName);
                fontFamilyMap.
                  put(
                    fontKeyName,
                    gvtFontFamily);
                return gvtFontFamily;
            }
    }
    protected static java.lang.String getFontWeightNumberString(java.lang.String fontWeight) {
        if (fontWeight.
              equals(
                SVG_NORMAL_VALUE)) {
            return SVG_400_VALUE;
        }
        else
            if (fontWeight.
                  equals(
                    SVG_BOLD_VALUE)) {
                return SVG_700_VALUE;
            }
            else
                if (fontWeight.
                      equals(
                        SVG_ALL_VALUE)) {
                    return "100, 200, 300, 400, 500, 600, 700, 800, 900";
                }
        return fontWeight;
    }
    public SVGFontUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GPaVOnSFe94w+Bl8kTXmfwAHnpLHtRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
