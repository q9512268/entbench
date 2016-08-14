package org.apache.batik.svggen;
public class SVGFont extends org.apache.batik.svggen.AbstractSVGConverter {
    public static final float EXTRA_LIGHT = java.awt.font.TextAttribute.WEIGHT_EXTRA_LIGHT.
      floatValue(
        );
    public static final float LIGHT = java.awt.font.TextAttribute.
                                        WEIGHT_LIGHT.floatValue();
    public static final float DEMILIGHT = java.awt.font.TextAttribute.
                                            WEIGHT_DEMILIGHT.floatValue(
                                                               );
    public static final float REGULAR = java.awt.font.TextAttribute.
                                          WEIGHT_REGULAR.floatValue(
                                                           );
    public static final float SEMIBOLD = java.awt.font.TextAttribute.
                                           WEIGHT_SEMIBOLD.floatValue(
                                                             );
    public static final float MEDIUM = java.awt.font.TextAttribute.
                                         WEIGHT_MEDIUM.floatValue(
                                                         );
    public static final float DEMIBOLD = java.awt.font.TextAttribute.
                                           WEIGHT_DEMIBOLD.floatValue(
                                                             );
    public static final float BOLD = java.awt.font.TextAttribute.
                                       WEIGHT_BOLD.floatValue();
    public static final float HEAVY = java.awt.font.TextAttribute.
                                        WEIGHT_HEAVY.floatValue();
    public static final float EXTRABOLD = java.awt.font.TextAttribute.
                                            WEIGHT_EXTRABOLD.floatValue(
                                                               );
    public static final float ULTRABOLD = java.awt.font.TextAttribute.
                                            WEIGHT_ULTRABOLD.floatValue(
                                                               );
    public static final float POSTURE_REGULAR = java.awt.font.TextAttribute.
                                                  POSTURE_REGULAR.
      floatValue(
        );
    public static final float POSTURE_OBLIQUE = java.awt.font.TextAttribute.
                                                  POSTURE_OBLIQUE.
      floatValue(
        );
    static final float[] fontStyles = { POSTURE_REGULAR + (POSTURE_OBLIQUE -
                                                             POSTURE_REGULAR) /
      2 };
    static final java.lang.String[] svgStyles = { SVG_NORMAL_VALUE,
    SVG_ITALIC_VALUE };
    static final float[] fontWeights = { EXTRA_LIGHT + (LIGHT - EXTRA_LIGHT) /
      2.0F,
    LIGHT +
      (DEMILIGHT -
         LIGHT) /
      2.0F,
    DEMILIGHT +
      (REGULAR -
         DEMILIGHT) /
      2.0F,
    REGULAR +
      (SEMIBOLD -
         REGULAR) /
      2.0F,
    SEMIBOLD +
      (MEDIUM -
         SEMIBOLD) /
      2.0F,
    MEDIUM +
      (DEMIBOLD -
         MEDIUM) /
      2.0F,
    DEMIBOLD +
      (BOLD -
         DEMIBOLD) /
      2.0F,
    BOLD +
      (HEAVY -
         BOLD) /
      2.0F,
    HEAVY +
      (EXTRABOLD -
         HEAVY) /
      2.0F,
    EXTRABOLD +
      (ULTRABOLD -
         EXTRABOLD) };
    static final java.lang.String[] svgWeights = { SVG_100_VALUE,
    SVG_200_VALUE,
    SVG_300_VALUE,
    SVG_NORMAL_VALUE,
    SVG_500_VALUE,
    SVG_500_VALUE,
    SVG_600_VALUE,
    SVG_BOLD_VALUE,
    SVG_800_VALUE,
    SVG_800_VALUE,
    SVG_900_VALUE };
    static java.util.Map logicalFontMap = new java.util.HashMap();
    static { logicalFontMap.put("dialog", "sans-serif");
             logicalFontMap.put("dialoginput", "monospace");
             logicalFontMap.put("monospaced", "monospace");
             logicalFontMap.put("serif", "serif");
             logicalFontMap.put("sansserif", "sans-serif");
             logicalFontMap.put("symbol", "\'WingDings\'"); }
    static final int COMMON_FONT_SIZE = 100;
    final java.util.Map fontStringMap = new java.util.HashMap();
    public SVGFont(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public void recordFontUsage(java.lang.String string, java.awt.Font font) {
        java.awt.Font commonSizeFont =
          createCommonSizeFont(
            font);
        java.lang.String fontKey =
          commonSizeFont.
          getFamily(
            ) +
        commonSizeFont.
          getStyle(
            );
        org.apache.batik.svggen.SVGFont.CharListHelper chl =
          (org.apache.batik.svggen.SVGFont.CharListHelper)
            fontStringMap.
            get(
              fontKey);
        if (chl ==
              null) {
            chl =
              new org.apache.batik.svggen.SVGFont.CharListHelper(
                );
        }
        for (int i =
               0;
             i <
               string.
               length(
                 );
             i++) {
            char ch =
              string.
              charAt(
                i);
            chl.
              add(
                ch);
        }
        fontStringMap.
          put(
            fontKey,
            chl);
    }
    private static java.awt.Font createCommonSizeFont(java.awt.Font font) {
        java.util.Map attributes =
          new java.util.HashMap(
          font.
            getAttributes(
              ));
        attributes.
          put(
            java.awt.font.TextAttribute.
              SIZE,
            new java.lang.Float(
              COMMON_FONT_SIZE));
        attributes.
          remove(
            java.awt.font.TextAttribute.
              TRANSFORM);
        return new java.awt.Font(
          attributes);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getFont(
                     ),
                 gc.
                   getFontRenderContext(
                     ));
    }
    public org.apache.batik.svggen.SVGFontDescriptor toSVG(java.awt.Font font,
                                                           java.awt.font.FontRenderContext frc) {
        java.awt.font.FontRenderContext localFRC;
        localFRC =
          new java.awt.font.FontRenderContext(
            new java.awt.geom.AffineTransform(
              ),
            frc.
              isAntiAliased(
                ),
            frc.
              usesFractionalMetrics(
                ));
        java.lang.String fontSize =
          "" +
        doubleString(
          font.
            getSize2D(
              ));
        java.lang.String fontWeight =
          weightToSVG(
            font);
        java.lang.String fontStyle =
          styleToSVG(
            font);
        java.lang.String fontFamilyStr =
          familyToSVG(
            font);
        java.awt.Font commonSizeFont =
          createCommonSizeFont(
            font);
        java.lang.String fontKey =
          commonSizeFont.
          getFamily(
            ) +
        commonSizeFont.
          getStyle(
            );
        org.apache.batik.svggen.SVGFont.CharListHelper clh =
          (org.apache.batik.svggen.SVGFont.CharListHelper)
            fontStringMap.
            get(
              fontKey);
        if (clh ==
              null) {
            return new org.apache.batik.svggen.SVGFontDescriptor(
              fontSize,
              fontWeight,
              fontStyle,
              fontFamilyStr,
              null);
        }
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        org.apache.batik.svggen.SVGFontDescriptor fontDesc =
          (org.apache.batik.svggen.SVGFontDescriptor)
            descMap.
            get(
              fontKey);
        org.w3c.dom.Element fontDef;
        if (fontDesc !=
              null) {
            fontDef =
              fontDesc.
                getDef(
                  );
        }
        else {
            fontDef =
              domFactory.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_FONT_TAG);
            org.w3c.dom.Element fontFace =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FONT_FACE_TAG);
            java.lang.String svgFontFamilyString =
              fontFamilyStr;
            if (fontFamilyStr.
                  startsWith(
                    "\'") &&
                  fontFamilyStr.
                  endsWith(
                    "\'")) {
                svgFontFamilyString =
                  fontFamilyStr.
                    substring(
                      1,
                      fontFamilyStr.
                        length(
                          ) -
                        1);
            }
            fontFace.
              setAttributeNS(
                null,
                SVG_FONT_FAMILY_ATTRIBUTE,
                svgFontFamilyString);
            fontFace.
              setAttributeNS(
                null,
                SVG_FONT_WEIGHT_ATTRIBUTE,
                fontWeight);
            fontFace.
              setAttributeNS(
                null,
                SVG_FONT_STYLE_ATTRIBUTE,
                fontStyle);
            fontFace.
              setAttributeNS(
                null,
                SVG_UNITS_PER_EM_ATTRIBUTE,
                "" +
                COMMON_FONT_SIZE);
            fontDef.
              appendChild(
                fontFace);
            org.w3c.dom.Element missingGlyphElement =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_MISSING_GLYPH_TAG);
            int[] missingGlyphCode =
              new int[1];
            missingGlyphCode[0] =
              commonSizeFont.
                getMissingGlyphCode(
                  );
            java.awt.font.GlyphVector gv;
            gv =
              commonSizeFont.
                createGlyphVector(
                  localFRC,
                  missingGlyphCode);
            java.awt.Shape missingGlyphShape =
              gv.
              getGlyphOutline(
                0);
            java.awt.font.GlyphMetrics gm =
              gv.
              getGlyphMetrics(
                0);
            java.awt.geom.AffineTransform at =
              java.awt.geom.AffineTransform.
              getScaleInstance(
                1,
                -1);
            missingGlyphShape =
              at.
                createTransformedShape(
                  missingGlyphShape);
            missingGlyphElement.
              setAttributeNS(
                null,
                SVG_D_ATTRIBUTE,
                org.apache.batik.svggen.SVGPath.
                  toSVGPathData(
                    missingGlyphShape,
                    generatorContext));
            missingGlyphElement.
              setAttributeNS(
                null,
                SVG_HORIZ_ADV_X_ATTRIBUTE,
                java.lang.String.
                  valueOf(
                    gm.
                      getAdvance(
                        )));
            fontDef.
              appendChild(
                missingGlyphElement);
            fontDef.
              setAttributeNS(
                null,
                SVG_HORIZ_ADV_X_ATTRIBUTE,
                java.lang.String.
                  valueOf(
                    gm.
                      getAdvance(
                        )));
            java.awt.font.LineMetrics lm =
              commonSizeFont.
              getLineMetrics(
                "By",
                localFRC);
            fontFace.
              setAttributeNS(
                null,
                SVG_ASCENT_ATTRIBUTE,
                java.lang.String.
                  valueOf(
                    lm.
                      getAscent(
                        )));
            fontFace.
              setAttributeNS(
                null,
                SVG_DESCENT_ATTRIBUTE,
                java.lang.String.
                  valueOf(
                    lm.
                      getDescent(
                        )));
            fontDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FONT));
        }
        java.lang.String textUsingFont =
          clh.
          getNewChars(
            );
        clh.
          clearNewChars(
            );
        for (int i =
               textUsingFont.
               length(
                 ) -
               1;
             i >=
               0;
             i--) {
            char c =
              textUsingFont.
              charAt(
                i);
            java.lang.String searchStr =
              java.lang.String.
              valueOf(
                c);
            boolean foundGlyph =
              false;
            org.w3c.dom.NodeList fontChildren =
              fontDef.
              getChildNodes(
                );
            for (int j =
                   0;
                 j <
                   fontChildren.
                   getLength(
                     );
                 j++) {
                if (fontChildren.
                      item(
                        j) instanceof org.w3c.dom.Element) {
                    org.w3c.dom.Element childElement =
                      (org.w3c.dom.Element)
                        fontChildren.
                        item(
                          j);
                    if (childElement.
                          getAttributeNS(
                            null,
                            SVG_UNICODE_ATTRIBUTE).
                          equals(
                            searchStr)) {
                        foundGlyph =
                          true;
                        break;
                    }
                }
            }
            if (!foundGlyph) {
                org.w3c.dom.Element glyphElement =
                  domFactory.
                  createElementNS(
                    SVG_NAMESPACE_URI,
                    SVG_GLYPH_TAG);
                java.awt.font.GlyphVector gv;
                gv =
                  commonSizeFont.
                    createGlyphVector(
                      localFRC,
                      "" +
                      c);
                java.awt.Shape glyphShape =
                  gv.
                  getGlyphOutline(
                    0);
                java.awt.font.GlyphMetrics gm =
                  gv.
                  getGlyphMetrics(
                    0);
                java.awt.geom.AffineTransform at =
                  java.awt.geom.AffineTransform.
                  getScaleInstance(
                    1,
                    -1);
                glyphShape =
                  at.
                    createTransformedShape(
                      glyphShape);
                glyphElement.
                  setAttributeNS(
                    null,
                    SVG_D_ATTRIBUTE,
                    org.apache.batik.svggen.SVGPath.
                      toSVGPathData(
                        glyphShape,
                        generatorContext));
                glyphElement.
                  setAttributeNS(
                    null,
                    SVG_HORIZ_ADV_X_ATTRIBUTE,
                    java.lang.String.
                      valueOf(
                        gm.
                          getAdvance(
                            )));
                glyphElement.
                  setAttributeNS(
                    null,
                    SVG_UNICODE_ATTRIBUTE,
                    java.lang.String.
                      valueOf(
                        c));
                fontDef.
                  appendChild(
                    glyphElement);
            }
            else {
                break;
            }
        }
        org.apache.batik.svggen.SVGFontDescriptor newFontDesc =
          new org.apache.batik.svggen.SVGFontDescriptor(
          fontSize,
          fontWeight,
          fontStyle,
          fontFamilyStr,
          fontDef);
        if (fontDesc ==
              null) {
            descMap.
              put(
                fontKey,
                newFontDesc);
            defSet.
              add(
                fontDef);
        }
        return newFontDesc;
    }
    public static java.lang.String familyToSVG(java.awt.Font font) {
        java.lang.String fontFamilyStr =
          font.
          getFamily(
            );
        java.lang.String logicalFontFamily =
          (java.lang.String)
            logicalFontMap.
            get(
              font.
                getName(
                  ).
                toLowerCase(
                  ));
        if (logicalFontFamily !=
              null)
            fontFamilyStr =
              logicalFontFamily;
        else {
            final char QUOTE =
              '\'';
            fontFamilyStr =
              QUOTE +
              fontFamilyStr +
              QUOTE;
        }
        return fontFamilyStr;
    }
    public static java.lang.String styleToSVG(java.awt.Font font) {
        java.util.Map attrMap =
          font.
          getAttributes(
            );
        java.lang.Float styleValue =
          (java.lang.Float)
            attrMap.
            get(
              java.awt.font.TextAttribute.
                POSTURE);
        if (styleValue ==
              null) {
            if (font.
                  isItalic(
                    ))
                styleValue =
                  java.awt.font.TextAttribute.
                    POSTURE_OBLIQUE;
            else
                styleValue =
                  java.awt.font.TextAttribute.
                    POSTURE_REGULAR;
        }
        float style =
          styleValue.
          floatValue(
            );
        int i =
          0;
        for (i =
               0;
             i <
               fontStyles.
                 length;
             i++) {
            if (style <=
                  fontStyles[i])
                break;
        }
        return svgStyles[i];
    }
    public static java.lang.String weightToSVG(java.awt.Font font) {
        java.util.Map attrMap =
          font.
          getAttributes(
            );
        java.lang.Float weightValue =
          (java.lang.Float)
            attrMap.
            get(
              java.awt.font.TextAttribute.
                WEIGHT);
        if (weightValue ==
              null) {
            if (font.
                  isBold(
                    ))
                weightValue =
                  java.awt.font.TextAttribute.
                    WEIGHT_BOLD;
            else
                weightValue =
                  java.awt.font.TextAttribute.
                    WEIGHT_REGULAR;
        }
        float weight =
          weightValue.
          floatValue(
            );
        int i =
          0;
        for (i =
               0;
             i <
               fontWeights.
                 length;
             i++) {
            if (weight <=
                  fontWeights[i])
                break;
        }
        return svgWeights[i];
    }
    private static class CharListHelper {
        private int nUsed = 0;
        private int[] charList = new int[40];
        private java.lang.StringBuffer freshChars =
          new java.lang.StringBuffer(
          40);
        CharListHelper() { super(); }
        java.lang.String getNewChars() { return freshChars.
                                           toString(
                                             );
        }
        void clearNewChars() { freshChars =
                                 new java.lang.StringBuffer(
                                   40); }
        boolean add(int c) { int pos = binSearch(
                                         charList,
                                         nUsed,
                                         c);
                             if (pos >= 0) {
                                 return false;
                             }
                             if (nUsed ==
                                   charList.
                                     length) {
                                 int[] t =
                                   new int[nUsed +
                                             20];
                                 java.lang.System.
                                   arraycopy(
                                     charList,
                                     0,
                                     t,
                                     0,
                                     nUsed);
                                 charList =
                                   t;
                             }
                             pos = -pos -
                                     1;
                             java.lang.System.
                               arraycopy(
                                 charList,
                                 pos,
                                 charList,
                                 pos +
                                   1,
                                 nUsed -
                                   pos);
                             charList[pos] =
                               c;
                             freshChars.append(
                                          (char)
                                            c);
                             nUsed++;
                             return true;
        }
        static int binSearch(int[] list, int nUsed,
                             int chr) { int low =
                                          0;
                                        int high =
                                          nUsed -
                                          1;
                                        while (low <=
                                                 high) {
                                            int mid =
                                              low +
                                              high >>>
                                              1;
                                            int midVal =
                                              list[mid];
                                            if (midVal <
                                                  chr) {
                                                low =
                                                  mid +
                                                    1;
                                            }
                                            else
                                                if (midVal >
                                                      chr) {
                                                    high =
                                                      mid -
                                                        1;
                                                }
                                                else {
                                                    return mid;
                                                }
                                        }
                                        return -(low +
                                                   1);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "4Bd5bcnMMCS62Av/F+1bGxaMHwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "p/7l9/3Cq18qj+H/D3zDwRNzKgAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HskbS3MAZReWtvpoy2XdjX5Yfn7yWGZgbTE8HdaI7QFYHvPHUhAIo8om5kOU" +
       "kbIBWJp1shEZFsAZB0XptQDfJjDzzm3lj/3c+NbfHjAzXL+Vhmdr+t5DpeKf" +
       "Eo/xlQYO2JWe2jycyUJ4lllT438Z2foxN1ChWwI3PVS9Dt74ktXemz1VpHF1" +
       "sDR47eLi3+g9S56+YXTJX/iuQ6lkwPITVk8+xwKuPu+Ov/zWsxXz7+e7eUW4" +
       "CEMWVnjPU7KPSzJOQTj3K7H4LX/tzlpqcHU0G1ia9occmhY2NQ3LHkg3ZKrE" +
       "2SBveTmvM3VwGyOFMC98PaY5Wx8FJh17Y8ncksIFe7hBVhWKu1v2N3NDWlLD" +
       "6aMo+JjKmrxO5mdsgrRy6M6OwovTb331JzXx+snsRGPdggn2mvH3QpDfimDx" +
       "e6dydPeb87o2Dl4ziU3lhR7t8JL8duv4E81ni7cW8NMuc6sj65Qss1Nt5mKx" +
       "TKcsqSuZy8MljrocM1UBi5Vcvjm29t7M8e3vWLwGaYWIgjb1Ikfzd7J3y7Ci" +
       "QXNtrFkqgD/7vevXo3n4317LH20N8L//yMf/bg0gCoHdGIpb7hdrnrLM5Fnr" +
       "L5hAlWMe5rGlv+lq9gQ/OkmzxeJ5LF7A4kS2feLPl7A4nm1w+PtVc7/gBBav" +
       "B0sxVJzjWykWRfjlbXMWOdqWfUxt+CAPbZAtwfX7a0OoMh9t6A8gyvDMRWFb" +
       "qRQfNPeCns6EEKrKA8Iua7QdARDm5ANhRwBRSChAoV0I/u1BMPfkEfDjJNzv" +
       "3G0NtjsAwUJ/BFwL2nxOboLoMTJdVuOSKMh4JtoqaJlxxUlyhGF+bg8J0bKq" +
       "2TXr319sbUT6tHUd8O976Ke9vcuqRDsZ+k16ZtOJJbDj1sz4X0a2fRIZC5MS" +
       "4DQiXVKCxvDiCnVOq08pfX78khGVHb59Z7tc984F91xk8u2sgOjptP/JZcef" +
       "uWvn4XFz5xSjNCMrg67aZN/vwYPTHBmaS0YfNF945I1Xe66yZTQd9etTaV9c" +
       "4RzUgHrgt9Un43pCiyZpt6vg2W/pwv4srQ+ljzx5VGiBzC9O9epXvjn2zxv3" +
       "XFCAp3hThvA0BGC7oseWJF7wuXn8tvnlB45/gZ8lAeUYzm9tPj4gaIIQshra" +
       "WlvbtvQ1tW3p6uts6TXRdfKww1nzwklxbd3Jc63M5tpBa1IHA3xFfQ5f4QU5" +
       "NQc90AVz5YQR2dKFZZ75N+SYf8qVUaVH5f/QZ2fcVXGNylueYR8lgncKuk7E" +
       "DyTGdh8YjbXdfa6tzFdBusFU7RyZDlHZRarEDOeZjhe3LcesaYx5mekA9SBI" +
       "+9igrp747lkK+Oc6acMThlkYXTNPB3LkoKFtWFwGi3Sdiqoewz7dhhCnfiuU" +
       "oiFVijlC65hI6XKf5u7gGYmHoXNt7fy1xZVf52BolhEyUqLp0pDAqF9Aq85B" +
       "1sMhx9ZCV3A2yTlYiNcrQniZRtQpDN2gJhKq0intpMhMTsLh2cAp4Nnp+G0B" +
       "PH+2wP158koY1NWfL7auZV90wIiBuhdfEws364I2mL43yVk1koONu7BgsOJh" +
       "amdPsz3E0hx3KTZRQ9Qlzb45yRmcPAUMno/fFsPzmsWl1ybP4KCu/lbuaA2w" +
       "YGHaotGPcrPuoEqMuq+QhG7Jwdl9WNzk5ezyCW66+XH35lOlvjWgVdY1oVDA" +
       "XSh/k8fXsJ+1z8hBcSJrvzMHM0exOIgLECEhySNdyFKs2upwacIji3y5tARm" +
       "OW5hGv/EuBREcSIu3ZeDS+NYjOEaB1fsfky6+1Sq0lEL0tFPjElBFCdi0oM5" +
       "mPRTLB4AVRrmq0A/Ln3/k+BSCuKiZdS4UJubdf/dvLMt3j9aWTpntPs5cwPV" +
       "vlc9LUpKB5Ky7L7l43ov1nQ6IHHGTjPv/PDNjtAvGZkT4GHwFg9/wQmHfmG2" +
       "fxRyGm97cFn8r7vd46BUTjsgZb64mzzJSCE0wdenNNvdrQpyd3Ww9tQFkQGH" +
       "wKEOUZ1RPRXKzB9teZBZE8nDlXIuyVhH8f+bYK95k+3Wcu3w6CVbrntv3d3m" +
       "TU5RFnbuRCrlUVJiXirlRAuzln5uajat4s3LT0z/3tSldhI7w5ywo/JnOLqH" +
       "R3MhDbVhnueao1GTvu34/NiGR36zt/hZWCddSUICI6ddmX1lLKUlIbu+Mpp9" +
       "+6ZH0Pn9y9rlXxvZuGrgnT/ZC6lQ5lU8b/s+8dihq35369yxBQWkHBZokJ/T" +
       "FL/LtmlE6aDikN5LKiSjMQVTBCqSIGdc7ZmOiitgSsz5YrGzIl2L94AZWZx9" +
       "ryn79nSZrA5TvV5NKrj2w6OEcqfGlIxndzipaZ4OTo0lSiwFLHpSKA3Q1b5o" +
       "q6bZ177Kfqlxs+0PXPiFXuav+Hb8/4/2Ha23NAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p5v8Dfr5zxI/Kv/SpdINh1OeqxaDT1Z64uRE53ZPDULPHp+Y7jy4lceGf1th" +
       "FMkbNhy+YNL9mQvefbZI/k0+askFq7eSuaD455PSKSfyG9fhRMSd0UzOcSL/" +
       "7mU7kdv8SNv5kCLnk4d9vaq0s9K9XV97WwO9cvV07S2PrEPJN9ahE6hv3C77" +
       "PLKdBT6ymQM+sl2Cf/s7HqEHHewKA9MY98hbH7HVePfm3dJq/tTb9/f33/HE" +
       "4+5Or3NdvedIj7flzrex/3BA+Z+9TBsrkt8pkt8tki9ebUzF478qkt+/2jqK" +
       "5z/YdrupXSR/eIHQ//KCd39dJF8uks9tkVxQ9r9dpTz//jqUx9oJdH6O8nzt" +
       "ZSvPHcUINFENTd9ubL1wCt3XrwPdUzt063PQ/c+XPz7mqn0M3BdPgfvWywe3" +
       "WZ8thPH0DtzT54D7ztng9jbgDnDdbTmaIUtWsRhPS+6J5YOTvpaV4s2m0RX5" +
       "X4y+8oWPZy88v10dKMbgoFQ+b//x6i3QYgH8ggDh2M7U3xBvefHrfy2849JO" +
       "5e44yYS7L2LCgd3edbQOmNOXZ+6dVtvvXqNivDm/PrTr9kNX8X7vcCV74yvI" +
       "PA7RVO/ev/pHz333ve9vXSoWZ2+KiiW1nAvHfAoTFpug73v+ww/e8cxXfmGz" +
       "eJ23rBR4b3zZSnYPOqDpAXMFHzDjKxwpYoc+5YjcvZtePrm3H5D7kR25Hzlb" +
       "1fbuvkDVDtHdtQ0RC99ZaFqR+72TXd11UVcHojstv73LL0nQBkAumnxgrO1D" +
       "+5Wi1n3XFoHft7Tkxw5GG0H1/DykeGxpQcXrL51SKOJlA8p15e4jHaAcW3vi" +
       "F/7rhz7/9x/9cq4ovQNFKeDeknNT+Pl/Bn2leHjo2rA/UGDnNpEkJfkBvdl9" +
       "UJUC/llB3Y157KBdN0nBq9/WrfskfPCjhHlnCssCWwWsJttbLVmGiFzcYcuV" +
       "/pxfgD0B7acTy1yzPcLTKqRQxnnYmEfigqp4oAKpTaiBkz5HqBouK5LPsrxB" +
       "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" +
       "/xWptmBJEW3QXL0zMqZCH02ijoHawmBd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
