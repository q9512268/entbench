package org.apache.batik.bridge;
public final class SVGGVTFont implements org.apache.batik.gvt.font.GVTFont, org.apache.batik.util.SVGConstants {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    private float fontSize;
    private org.apache.batik.gvt.font.GVTFontFace fontFace;
    private java.lang.String[] glyphUnicodes;
    private java.lang.String[] glyphNames;
    private java.lang.String[] glyphLangs;
    private java.lang.String[] glyphOrientations;
    private java.lang.String[] glyphForms;
    private org.w3c.dom.Element[] glyphElements;
    private org.w3c.dom.Element[] hkernElements;
    private org.w3c.dom.Element[] vkernElements;
    private org.apache.batik.bridge.BridgeContext ctx;
    private org.w3c.dom.Element textElement;
    private org.w3c.dom.Element missingGlyphElement;
    private org.apache.batik.gvt.font.KerningTable hKerningTable;
    private org.apache.batik.gvt.font.KerningTable vKerningTable;
    private java.lang.String language;
    private java.lang.String orientation;
    private float scale;
    private org.apache.batik.gvt.font.GVTLineMetrics lineMetrics =
      null;
    public SVGGVTFont(float fontSize, org.apache.batik.gvt.font.GVTFontFace fontFace,
                      java.lang.String[] glyphUnicodes,
                      java.lang.String[] glyphNames,
                      java.lang.String[] glyphLangs,
                      java.lang.String[] glyphOrientations,
                      java.lang.String[] glyphForms,
                      org.apache.batik.bridge.BridgeContext ctx,
                      org.w3c.dom.Element[] glyphElements,
                      org.w3c.dom.Element missingGlyphElement,
                      org.w3c.dom.Element[] hkernElements,
                      org.w3c.dom.Element[] vkernElements,
                      org.w3c.dom.Element textElement) { super(
                                                           );
                                                         this.
                                                           fontFace =
                                                           fontFace;
                                                         this.
                                                           fontSize =
                                                           fontSize;
                                                         this.
                                                           glyphUnicodes =
                                                           glyphUnicodes;
                                                         this.
                                                           glyphNames =
                                                           glyphNames;
                                                         this.
                                                           glyphLangs =
                                                           glyphLangs;
                                                         this.
                                                           glyphOrientations =
                                                           glyphOrientations;
                                                         this.
                                                           glyphForms =
                                                           glyphForms;
                                                         this.
                                                           ctx =
                                                           ctx;
                                                         this.
                                                           glyphElements =
                                                           glyphElements;
                                                         this.
                                                           missingGlyphElement =
                                                           missingGlyphElement;
                                                         this.
                                                           hkernElements =
                                                           hkernElements;
                                                         this.
                                                           vkernElements =
                                                           vkernElements;
                                                         this.
                                                           scale =
                                                           fontSize /
                                                             fontFace.
                                                             getUnitsPerEm(
                                                               );
                                                         this.
                                                           textElement =
                                                           textElement;
                                                         this.
                                                           language =
                                                           org.apache.batik.dom.util.XMLSupport.
                                                             getXMLLang(
                                                               textElement);
                                                         org.apache.batik.css.engine.value.Value v =
                                                           org.apache.batik.bridge.CSSUtilities.
                                                           getComputedStyle(
                                                             textElement,
                                                             org.apache.batik.css.engine.SVGCSSEngine.
                                                               WRITING_MODE_INDEX);
                                                         if (v.
                                                               getStringValue(
                                                                 ).
                                                               startsWith(
                                                                 CSS_TB_VALUE)) {
                                                             this.
                                                               orientation =
                                                               SVG_V_VALUE;
                                                         }
                                                         else {
                                                             this.
                                                               orientation =
                                                               SVG_H_VALUE;
                                                         }
                                                         createKerningTables(
                                                           );
    }
    private void createKerningTables() { org.apache.batik.gvt.font.Kern[] hEntries =
                                           new org.apache.batik.gvt.font.Kern[hkernElements.
                                                                                length];
                                         for (int i =
                                                0;
                                              i <
                                                hkernElements.
                                                  length;
                                              i++) {
                                             org.w3c.dom.Element hkernElement =
                                               hkernElements[i];
                                             org.apache.batik.bridge.SVGHKernElementBridge hkernBridge =
                                               (org.apache.batik.bridge.SVGHKernElementBridge)
                                                 ctx.
                                                 getBridge(
                                                   hkernElement);
                                             org.apache.batik.gvt.font.Kern hkern =
                                               hkernBridge.
                                               createKern(
                                                 ctx,
                                                 hkernElement,
                                                 this);
                                             hEntries[i] =
                                               hkern;
                                         }
                                         hKerningTable =
                                           new org.apache.batik.gvt.font.KerningTable(
                                             hEntries);
                                         org.apache.batik.gvt.font.Kern[] vEntries =
                                           new org.apache.batik.gvt.font.Kern[vkernElements.
                                                                                length];
                                         for (int i =
                                                0;
                                              i <
                                                vkernElements.
                                                  length;
                                              i++) {
                                             org.w3c.dom.Element vkernElement =
                                               vkernElements[i];
                                             org.apache.batik.bridge.SVGVKernElementBridge vkernBridge =
                                               (org.apache.batik.bridge.SVGVKernElementBridge)
                                                 ctx.
                                                 getBridge(
                                                   vkernElement);
                                             org.apache.batik.gvt.font.Kern vkern =
                                               vkernBridge.
                                               createKern(
                                                 ctx,
                                                 vkernElement,
                                                 this);
                                             vEntries[i] =
                                               vkern;
                                         }
                                         vKerningTable =
                                           new org.apache.batik.gvt.font.KerningTable(
                                             vEntries);
    }
    public float getHKern(int glyphCode1,
                          int glyphCode2) {
        if (glyphCode1 <
              0 ||
              glyphCode1 >=
              glyphUnicodes.
                length ||
              glyphCode2 <
              0 ||
              glyphCode2 >=
              glyphUnicodes.
                length) {
            return 0.0F;
        }
        float ret;
        ret =
          hKerningTable.
            getKerningValue(
              glyphCode1,
              glyphCode2,
              glyphUnicodes[glyphCode1],
              glyphUnicodes[glyphCode2]);
        return ret *
          scale;
    }
    public float getVKern(int glyphCode1,
                          int glyphCode2) {
        if (glyphCode1 <
              0 ||
              glyphCode1 >=
              glyphUnicodes.
                length ||
              glyphCode2 <
              0 ||
              glyphCode2 >=
              glyphUnicodes.
                length) {
            return 0.0F;
        }
        float ret;
        ret =
          vKerningTable.
            getKerningValue(
              glyphCode1,
              glyphCode2,
              glyphUnicodes[glyphCode1],
              glyphUnicodes[glyphCode2]);
        return ret *
          scale;
    }
    public int[] getGlyphCodesForName(java.lang.String name) {
        java.util.List glyphCodes =
          new java.util.ArrayList(
          );
        for (int i =
               0;
             i <
               glyphNames.
                 length;
             i++) {
            if (glyphNames[i] !=
                  null &&
                  glyphNames[i].
                  equals(
                    name)) {
                glyphCodes.
                  add(
                    new java.lang.Integer(
                      i));
            }
        }
        int[] glyphCodeArray =
          new int[glyphCodes.
                    size(
                      )];
        for (int i =
               0;
             i <
               glyphCodes.
               size(
                 );
             i++) {
            glyphCodeArray[i] =
              ((java.lang.Integer)
                 glyphCodes.
                 get(
                   i)).
                intValue(
                  );
        }
        return glyphCodeArray;
    }
    public int[] getGlyphCodesForUnicode(java.lang.String unicode) {
        java.util.List glyphCodes =
          new java.util.ArrayList(
          );
        for (int i =
               0;
             i <
               glyphUnicodes.
                 length;
             i++) {
            if (glyphUnicodes[i] !=
                  null &&
                  glyphUnicodes[i].
                  equals(
                    unicode)) {
                glyphCodes.
                  add(
                    new java.lang.Integer(
                      i));
            }
        }
        int[] glyphCodeArray =
          new int[glyphCodes.
                    size(
                      )];
        for (int i =
               0;
             i <
               glyphCodes.
               size(
                 );
             i++) {
            glyphCodeArray[i] =
              ((java.lang.Integer)
                 glyphCodes.
                 get(
                   i)).
                intValue(
                  );
        }
        return glyphCodeArray;
    }
    private boolean languageMatches(java.lang.String glyphLang) {
        if (glyphLang ==
              null ||
              glyphLang.
              length(
                ) ==
              0) {
            return true;
        }
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          glyphLang,
          ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String s =
              st.
              nextToken(
                );
            if (s.
                  equals(
                    language) ||
                  s.
                  startsWith(
                    language) &&
                  s.
                  length(
                    ) >
                  language.
                  length(
                    ) &&
                  s.
                  charAt(
                    language.
                      length(
                        )) ==
                  '-') {
                return true;
            }
        }
        return false;
    }
    private boolean orientationMatches(java.lang.String glyphOrientation) {
        if (glyphOrientation ==
              null ||
              glyphOrientation.
              length(
                ) ==
              0) {
            return true;
        }
        return glyphOrientation.
          equals(
            orientation);
    }
    private boolean formMatches(java.lang.String glyphUnicode,
                                java.lang.String glyphForm,
                                java.text.AttributedCharacterIterator aci,
                                int currentIndex) {
        if (aci ==
              null ||
              glyphForm ==
              null ||
              glyphForm.
              length(
                ) ==
              0) {
            return true;
        }
        char c =
          aci.
          setIndex(
            currentIndex);
        java.lang.Integer form =
          (java.lang.Integer)
            aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                ARABIC_FORM);
        if (form ==
              null ||
              form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_NONE)) {
            return false;
        }
        if (glyphUnicode.
              length(
                ) >
              1) {
            boolean matched =
              true;
            for (int j =
                   1;
                 j <
                   glyphUnicode.
                   length(
                     );
                 j++) {
                c =
                  aci.
                    next(
                      );
                if (glyphUnicode.
                      charAt(
                        j) !=
                      c) {
                    matched =
                      false;
                    break;
                }
            }
            aci.
              setIndex(
                currentIndex);
            if (matched) {
                aci.
                  setIndex(
                    currentIndex +
                      glyphUnicode.
                      length(
                        ) -
                      1);
                java.lang.Integer lastForm =
                  (java.lang.Integer)
                    aci.
                    getAttribute(
                      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                        ARABIC_FORM);
                aci.
                  setIndex(
                    currentIndex);
                if (form !=
                      null &&
                      lastForm !=
                      null) {
                    if (form.
                          equals(
                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                              ARABIC_TERMINAL) &&
                          lastForm.
                          equals(
                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                              ARABIC_INITIAL)) {
                        return glyphForm.
                          equals(
                            org.apache.batik.util.SVGConstants.
                              SVG_ISOLATED_VALUE);
                    }
                    else
                        if (form.
                              equals(
                                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                  ARABIC_TERMINAL)) {
                            return glyphForm.
                              equals(
                                org.apache.batik.util.SVGConstants.
                                  SVG_TERMINAL_VALUE);
                        }
                        else
                            if (form.
                                  equals(
                                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                      ARABIC_MEDIAL) &&
                                  lastForm.
                                  equals(
                                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                      ARABIC_MEDIAL)) {
                                return glyphForm.
                                  equals(
                                    org.apache.batik.util.SVGConstants.
                                      SVG_MEDIAL_VALUE);
                            }
                }
            }
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_ISOLATED)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_ISOLATED_VALUE);
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_TERMINAL)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_TERMINAL_VALUE);
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_INITIAL)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_INITIAL_VALUE);
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_MEDIAL)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_MEDIAL_VALUE);
        }
        return false;
    }
    public boolean canDisplayGivenName(java.lang.String name) {
        for (int i =
               0;
             i <
               glyphNames.
                 length;
             i++) {
            if (glyphNames[i] !=
                  null &&
                  glyphNames[i].
                  equals(
                    name) &&
                  languageMatches(
                    glyphLangs[i]) &&
                  orientationMatches(
                    glyphOrientations[i])) {
                return true;
            }
        }
        return false;
    }
    public boolean canDisplay(char c) { for (int i =
                                               0;
                                             i <
                                               glyphUnicodes.
                                                 length;
                                             i++) {
                                            if (glyphUnicodes[i].
                                                  indexOf(
                                                    c) !=
                                                  -1 &&
                                                  languageMatches(
                                                    glyphLangs[i]) &&
                                                  orientationMatches(
                                                    glyphOrientations[i])) {
                                                return true;
                                            }
                                        }
                                        return false;
    }
    public int canDisplayUpTo(char[] text,
                              int start,
                              int limit) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          new java.lang.String(
            text));
        return canDisplayUpTo(
                 sci,
                 start,
                 limit);
    }
    public int canDisplayUpTo(java.text.CharacterIterator iter,
                              int start,
                              int limit) {
        java.text.AttributedCharacterIterator aci =
          null;
        if (iter instanceof java.text.AttributedCharacterIterator) {
            aci =
              (java.text.AttributedCharacterIterator)
                iter;
        }
        char c =
          iter.
          setIndex(
            start);
        int currentIndex =
          start;
        while (c !=
                 java.text.CharacterIterator.
                   DONE &&
                 currentIndex <
                 limit) {
            boolean foundMatchingGlyph =
              false;
            for (int i =
                   0;
                 i <
                   glyphUnicodes.
                     length;
                 i++) {
                if (glyphUnicodes[i].
                      indexOf(
                        c) ==
                      0 &&
                      languageMatches(
                        glyphLangs[i]) &&
                      orientationMatches(
                        glyphOrientations[i]) &&
                      formMatches(
                        glyphUnicodes[i],
                        glyphForms[i],
                        aci,
                        currentIndex)) {
                    if (glyphUnicodes[i].
                          length(
                            ) ==
                          1) {
                        foundMatchingGlyph =
                          true;
                        break;
                    }
                    else {
                        boolean matched =
                          true;
                        for (int j =
                               1;
                             j <
                               glyphUnicodes[i].
                               length(
                                 );
                             j++) {
                            c =
                              iter.
                                next(
                                  );
                            if (glyphUnicodes[i].
                                  charAt(
                                    j) !=
                                  c) {
                                matched =
                                  false;
                                break;
                            }
                        }
                        if (matched) {
                            foundMatchingGlyph =
                              true;
                            break;
                        }
                        else {
                            c =
                              iter.
                                setIndex(
                                  currentIndex);
                        }
                    }
                }
            }
            if (!foundMatchingGlyph) {
                return currentIndex;
            }
            c =
              iter.
                next(
                  );
            currentIndex =
              iter.
                getIndex(
                  );
        }
        return -1;
    }
    public int canDisplayUpTo(java.lang.String str) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return canDisplayUpTo(
                 sci,
                 0,
                 str.
                   length(
                     ));
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      char[] chars) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          new java.lang.String(
            chars));
        return createGlyphVector(
                 frc,
                 sci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.text.CharacterIterator ci) {
        java.text.AttributedCharacterIterator aci =
          null;
        if (ci instanceof java.text.AttributedCharacterIterator) {
            aci =
              (java.text.AttributedCharacterIterator)
                ci;
        }
        java.util.List glyphs =
          new java.util.ArrayList(
          );
        char c =
          ci.
          first(
            );
        while (c !=
                 java.text.CharacterIterator.
                   DONE) {
            boolean foundMatchingGlyph =
              false;
            for (int i =
                   0;
                 i <
                   glyphUnicodes.
                     length;
                 i++) {
                if (glyphUnicodes[i].
                      indexOf(
                        c) ==
                      0 &&
                      languageMatches(
                        glyphLangs[i]) &&
                      orientationMatches(
                        glyphOrientations[i]) &&
                      formMatches(
                        glyphUnicodes[i],
                        glyphForms[i],
                        aci,
                        ci.
                          getIndex(
                            ))) {
                    if (glyphUnicodes[i].
                          length(
                            ) ==
                          1) {
                        org.w3c.dom.Element glyphElement =
                          glyphElements[i];
                        org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
                          (org.apache.batik.bridge.SVGGlyphElementBridge)
                            ctx.
                            getBridge(
                              glyphElement);
                        org.apache.batik.gvt.text.TextPaintInfo tpi =
                          null;
                        if (aci !=
                              null) {
                            tpi =
                              (org.apache.batik.gvt.text.TextPaintInfo)
                                aci.
                                getAttribute(
                                  PAINT_INFO);
                        }
                        org.apache.batik.gvt.font.Glyph glyph =
                          glyphBridge.
                          createGlyph(
                            ctx,
                            glyphElement,
                            textElement,
                            i,
                            fontSize,
                            fontFace,
                            tpi);
                        glyphs.
                          add(
                            glyph);
                        foundMatchingGlyph =
                          true;
                        break;
                    }
                    else {
                        int current =
                          ci.
                          getIndex(
                            );
                        boolean matched =
                          true;
                        for (int j =
                               1;
                             j <
                               glyphUnicodes[i].
                               length(
                                 );
                             j++) {
                            c =
                              ci.
                                next(
                                  );
                            if (glyphUnicodes[i].
                                  charAt(
                                    j) !=
                                  c) {
                                matched =
                                  false;
                                break;
                            }
                        }
                        if (matched) {
                            org.w3c.dom.Element glyphElement =
                              glyphElements[i];
                            org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
                              (org.apache.batik.bridge.SVGGlyphElementBridge)
                                ctx.
                                getBridge(
                                  glyphElement);
                            org.apache.batik.gvt.text.TextPaintInfo tpi =
                              null;
                            if (aci !=
                                  null) {
                                aci.
                                  setIndex(
                                    ci.
                                      getIndex(
                                        ));
                                tpi =
                                  (org.apache.batik.gvt.text.TextPaintInfo)
                                    aci.
                                    getAttribute(
                                      PAINT_INFO);
                            }
                            org.apache.batik.gvt.font.Glyph glyph =
                              glyphBridge.
                              createGlyph(
                                ctx,
                                glyphElement,
                                textElement,
                                i,
                                fontSize,
                                fontFace,
                                tpi);
                            glyphs.
                              add(
                                glyph);
                            foundMatchingGlyph =
                              true;
                            break;
                        }
                        else {
                            c =
                              ci.
                                setIndex(
                                  current);
                        }
                    }
                }
            }
            if (!foundMatchingGlyph) {
                org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
                  (org.apache.batik.bridge.SVGGlyphElementBridge)
                    ctx.
                    getBridge(
                      missingGlyphElement);
                org.apache.batik.gvt.text.TextPaintInfo tpi =
                  null;
                if (aci !=
                      null) {
                    aci.
                      setIndex(
                        ci.
                          getIndex(
                            ));
                    tpi =
                      (org.apache.batik.gvt.text.TextPaintInfo)
                        aci.
                        getAttribute(
                          PAINT_INFO);
                }
                org.apache.batik.gvt.font.Glyph glyph =
                  glyphBridge.
                  createGlyph(
                    ctx,
                    missingGlyphElement,
                    textElement,
                    -1,
                    fontSize,
                    fontFace,
                    tpi);
                glyphs.
                  add(
                    glyph);
            }
            c =
              ci.
                next(
                  );
        }
        int numGlyphs =
          glyphs.
          size(
            );
        org.apache.batik.gvt.font.Glyph[] glyphArray =
          (org.apache.batik.gvt.font.Glyph[])
            glyphs.
            toArray(
              new org.apache.batik.gvt.font.Glyph[numGlyphs]);
        return new org.apache.batik.gvt.font.SVGGVTGlyphVector(
          this,
          glyphArray,
          frc);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      int[] glyphCodes,
                                                                      java.text.CharacterIterator ci) {
        int nGlyphs =
          glyphCodes.
            length;
        java.lang.StringBuffer workBuff =
          new java.lang.StringBuffer(
          nGlyphs);
        for (int i =
               0;
             i <
               nGlyphs;
             i++) {
            workBuff.
              append(
                glyphUnicodes[glyphCodes[i]]);
        }
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          workBuff.
            toString(
              ));
        return createGlyphVector(
                 frc,
                 sci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.lang.String str) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return createGlyphVector(
                 frc,
                 sci);
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size) {
        return new org.apache.batik.bridge.SVGGVTFont(
          size,
          fontFace,
          glyphUnicodes,
          glyphNames,
          glyphLangs,
          glyphOrientations,
          glyphForms,
          ctx,
          glyphElements,
          missingGlyphElement,
          hkernElements,
          vkernElements,
          textElement);
    }
    public java.lang.String getFamilyName() {
        return fontFace.
          getFamilyName(
            );
    }
    protected org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(int beginIndex,
                                                                      int limit) {
        if (lineMetrics !=
              null)
            return lineMetrics;
        float fontHeight =
          fontFace.
          getUnitsPerEm(
            );
        float scale =
          fontSize /
          fontHeight;
        float ascent =
          fontFace.
          getAscent(
            ) *
          scale;
        float descent =
          fontFace.
          getDescent(
            ) *
          scale;
        float[] baselineOffsets =
          new float[3];
        baselineOffsets[java.awt.Font.
                          ROMAN_BASELINE] =
          0;
        baselineOffsets[java.awt.Font.
                          CENTER_BASELINE] =
          (ascent +
             descent) /
            2 -
            ascent;
        baselineOffsets[java.awt.Font.
                          HANGING_BASELINE] =
          -ascent;
        float stOffset =
          fontFace.
          getStrikethroughPosition(
            ) *
          -scale;
        float stThickness =
          fontFace.
          getStrikethroughThickness(
            ) *
          scale;
        float ulOffset =
          fontFace.
          getUnderlinePosition(
            ) *
          scale;
        float ulThickness =
          fontFace.
          getUnderlineThickness(
            ) *
          scale;
        float olOffset =
          fontFace.
          getOverlinePosition(
            ) *
          -scale;
        float olThickness =
          fontFace.
          getOverlineThickness(
            ) *
          scale;
        lineMetrics =
          new org.apache.batik.gvt.font.GVTLineMetrics(
            ascent,
            java.awt.Font.
              ROMAN_BASELINE,
            baselineOffsets,
            descent,
            fontHeight,
            fontHeight,
            limit -
              beginIndex,
            stOffset,
            stThickness,
            ulOffset,
            ulThickness,
            olOffset,
            olThickness);
        return lineMetrics;
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(char[] chars,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return getLineMetrics(
                 beginIndex,
                 limit);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.text.CharacterIterator ci,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return getLineMetrics(
                 beginIndex,
                 limit);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   java.awt.font.FontRenderContext frc) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return getLineMetrics(
                 sci,
                 0,
                 str.
                   length(
                     ),
                 frc);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return getLineMetrics(
                 sci,
                 beginIndex,
                 limit,
                 frc);
    }
    public float getSize() { return fontSize;
    }
    public java.lang.String toString() { return fontFace.
                                           getFamilyName(
                                             ) +
                                         " " +
                                         fontFace.
                                           getFontWeight(
                                             ) +
                                         " " +
                                         fontFace.
                                           getFontStyle(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC3AcxZnuXT0sS9bT74f8lB38QAtJbDAyBluWZNlrWWfZ" +
       "qouMkUezI2ns2Z3xTK+0MufjURfwUQnhbAdIAiZXcWKOM4+EoxLuCPFdKgbH" +
       "kCvAzsOu4CN3dXGOOMFHQVIhgfv/7p6d2dmdWVZkb6umZ3a6/+7///p/de/M" +
       "nrhMyiyTzFUStJmOGYrV3Jag3ZJpKbFWTbKs7XCvX36wRHrn1ktdq8OkvI/U" +
       "DEvWFlmylHZV0WJWH2lUExaVErJidSlKDCm6TcVSzBGJqnqij0xVrc64oamy" +
       "SrfoMQUb9EpmlNRLlJrqQJIqnaIDShqjwEmEcRJZ561uiZJJsm6MOc1nuJq3" +
       "umqwZdwZy6KkLrpHGpEiSapqkahq0ZaUSZYbujY2pOm0WUnR5j3aSgHBpujK" +
       "LAgWPl373vv3D9cxCCZLiYROmXjWNsXStRElFiW1zt02TYlb+8hfk5IoqXI1" +
       "pqQpag8agUEjMKgtrdMKuK9WEsl4q87EoXZP5YaMDFGyILMTQzKluOimm/EM" +
       "PVRQITsjBmnnp6XlUmaJ+MXlkSMP3lr3rRJS20dq1UQPsiMDExQG6QNAlfiA" +
       "YlrrYjEl1kfqEzDZPYqpSpq6X8x0g6UOJSSahOm3YcGbSUMx2ZgOVjCPIJuZ" +
       "lKlupsUbZAolvpUNatIQyDrNkZVL2I73QcBKFRgzByXQO0FSuldNxCiZ56VI" +
       "y9i0GRoA6YS4Qof19FClCQlukAauIpqUGIr0gOolhqBpmQ4KaFIyy7dTxNqQ" +
       "5L3SkNKPGulp182roNVEBgSSUDLV24z1BLM0yzNLrvm53LXmvtsSGxNhEgKe" +
       "Y4qsIf9VQDTXQ7RNGVRMBeyAE05aFn1Amvbdg2FCoPFUT2Pe5tt/deXmFXNP" +
       "vsTbzM7RZuvAHkWm/fKxgZpX57QuXV2CbFQYuqXi5GdIzqysW9S0pAzwMNPS" +
       "PWJls115ctupz9zxuPJWmFR2knJZ15Jx0KN6WY8bqqaYHUpCMSWqxDrJRCUR" +
       "a2X1nWQCXEfVhMLvbh0ctBTaSUo1dqtcZ98BokHoAiGqhGs1Majb14ZEh9l1" +
       "yiCEVMNB1sKxkvAPO1OyIzKsx5WIJEsJNaFHuk0d5bci4HEGANvhyABo/d6I" +
       "pSdNUMGIbg5FJNCDYUVUDJhqbEiJ9PR2dPRubweEmlG9jGJ1nEKJJo+GQgD2" +
       "HK+pa2AlG3Utppj98pHk+rYrT/af4WqEqi+woGQhjNXMx2pmYzXzsZqdsUgo" +
       "xIaYgmPyuYSZ2As2DU510tKeXZt2H1xYAkpkjJYCjNh0YUZwaXUM3/bW/fJT" +
       "DdX7F7xx7ffDpDRKGiSZJiUNY8U6cwi8kLxXGOqkAQg7jvef7/L+GLZMXVZi" +
       "4Hz8ooDopUIfUUy8T8kUVw92bEIrjPhHhpz8k5MPjd7Ze/s1YRLOdPg4ZBn4" +
       "KiTvRjeddsdNXkPP1W/tPZfee+qBA7pj8hkRxA58WZQow0KvEnjh6ZeXzZee" +
       "7f/ugSYG+0RwyVQCEwJvN9c7RoZHabG9M8pSAQIP6mZc0rDKxriSDpv6qHOH" +
       "aWc9u54CalGFJjYVDlnYHDtj7TQDy+lcm1HPPFIw739jj/HIT3/0q08xuO1A" +
       "UeuK8D0KbXE5J+ysgbmhekdtt5uKAu1+/lD34S9evmcn01losSjXgE1YtoJT" +
       "gikEmD/70r6fXXzj2Nmwo+cUonNyAJKcVFpIvE8qA4SE0ZY4/IBz08APoNY0" +
       "7UiAfqqDqjSgKWhYf6xdfO2zv76vjuuBBndsNVqRvwPn/sz15I4zt/5uLusm" +
       "JGNwdTBzmnGPPdnpeZ1pSmPIR+rO1xq/9KL0CPh+8LeWul/hLpRhUJ1p62hP" +
       "PckBC+xSjcM0jIho9Mnu3fLBpu7/4pFmZg4C3m7qY5HP9/5kz8tskivQ8vE+" +
       "yl3tsmvwEC4Nq+PgfwifEBwf4IGg4w3u1RtaRWiZn44thpECzpcGJIOZAkQO" +
       "NFzc+/ClJ7gA3tjraawcPHLvh833HeEzxxOURVk5gpuGJylcHCxWI3cLgkZh" +
       "FO2/fOrAvzx24B7OVUNmuG2DbPKJH//p5eaH/uN0Dr8PJqRLPM38NCpz2nVP" +
       "yZwdLtKGv619/v6GknbwGp2kIplQ9yWVzpi7T8iwrOSAa7qc1IfdcAuHUwNR" +
       "ZRnOAt6ZQcnirDA0NEKbBzHSiSjUjllfxrIlrTxMVzmjt1Sd+p71tf/+Fock" +
       "l2p6EqXHjlfIF+KnmGoiL9cxzVjsrxmuwY5+Y9GPbj+66E2At49UqBYEHNDN" +
       "HBmdi+btExffeq268Unmf0tRxQVemalwdqabkcAyVmsd+OqY4WIa28zT2BwT" +
       "OycjJrOVnBMWHn/9unPH/+6BUY5bgGF46Gb8Yas2cNcvfs80LCsK5rAVD31f" +
       "5MTDs1rXvsXonXCE1E2p7KwGEHZoP/l4/N3wwvIfhMmEPlIni5VTr6Ql0cn3" +
       "AYaWvZyC1VVGfWbmz9PclnS4neM1Vtew3kDotoBSmqHt9UYqRJjb/0vW+hOs" +
       "XIbF1WxWwnjZjLaoJiSN0ayGoKIpiSE6zBq3CG+Ap5soKQGtwMsuMfM4wWHe" +
       "la0Jkx1NaNX0hILRwK7jCZyqN6fXcFCZyqEqjRmqsoUpnoP7z2sO/edzTUPr" +
       "C8nc8N7cPLkZfp8Hk77MX/u8rLx41//M2r52eHcBSdg8j0p5u/yHLSdOdyyR" +
       "D4XZMpErRNbyMpOoJVMNKk0F1sOJTNe3yGCnLq4JWCxnc8u+X5OeA8LmgLui" +
       "eEAdW9jsAdWRcZK5TgQ0N7PuYriflzuRaIsblIX+/d+Z/k9rjh99g+U8Rop4" +
       "NQW/trH+N3sKf7cuVhfr2UlsNLDWnekkqgIZrIUjKpKoKI/j/X+2RRTGE9yv" +
       "AUrOiL1OK/YQ3NiiWOxPO+/JCNLop+TmmB5vFjRZRonft3E64VTuDHIqWOzk" +
       "HgWLW7DYhcWBbNeBXyUs5GxfgN8H+bCMGou9AYp2MKDuXizuxsLgnAS0/Vy2" +
       "wuKNpK8WBoGJVWPp4gtsgJUBgx/CYrHlXrBleiLXxl2/fP/Zt6t7337hSlYI" +
       "zFyfbJEMnuHVY7EEs4zp3gX1RskahnafPtl1S5128n2WV1RJMqiatdWElXwq" +
       "YzUjWpdNOP+v35+2+9USEm4nlZDVxSBVwoUhmQgrMsUa1rVYyrjpZm5Lo2hd" +
       "dUxUkiW8L+isYja7OYWrYtpaZ2DD9XBcL6z1Ou+6Tujrw7n1tUQEwXKL7T1y" +
       "xc1cUE23e83ROyWV3es6u7b3d3a1b7WVIMJAQtfSnN5RjrUOQxyQIavqpApb" +
       "0jWl65BsMiM+jMUjfPwHfDFzpJ+Ed2fDcYPg7wYf6Y/nlh4WkRMMUx2BRYlH" +
       "6KqATimpwNS4BxZj+P16D/+PFcj/AjhaxFAtPvw/7QSux7MZ9aMWjGLujt87" +
       "PIx+s0BGF8GxRgy1xofRbwcy6kdNSfWQNmYM70ioMqQiVjqUubj9ToHczofj" +
       "RjHejT7cvhDIrR81KD3jtguSjpysfm8crK4Vg631YfUHgaz6UdusRiWxKPGy" +
       "eqpAVj8Bx01isJt8WH05kFU/akrqGatbTRWChpNHejl+ZRzgiqb8nIPj1wM5" +
       "9qO2wW3XzXhOVs8WyGoTHOvEYOt8WD0fyKoftW1g7vxmzMPthXFwu16Mt96H" +
       "2zcDufWjBm6H9ypmIojbX4yD21YxXqsPt5cCufWjBm5H8nH7qwK5nQvHBjHe" +
       "Bh9ufxvIrR81LGNlyjKhUQ+Pb4/DsNrEKG0+PL4XyKMfNSVVmD248scveHj9" +
       "XYG8XgVHuxit3YfXPwXy6kcNOW9ctSw1MdThMrBcPH8wDlfbIUbtyM1zqDSQ" +
       "Zz9qtK/NoLHA9Hb3DsUS/21Ad/NMuUJl45Bro+Bso49c1YFy+VGjJXoYDU30" +
       "cFtTILdz4OgU43X6cDslkFs/asjOcKMoKQ2lJyBrI9HD/NQCmZ8HxyYx/CYf" +
       "5hsDmfejBhPVnUCN/cz08Dq3QF5nwrFZjLbZh9emQF79qCkps2RJy5WshxYX" +
       "yOUK4tkYycHl8kAu/agBUfw5fYsCEy9btkZcFbgzH3UIPHKtCJCLVwVuXaTZ" +
       "Zh+UPOO3ehfbrOXszF3QBXl/TrBbZv/+zdbWPb0d6UdxcKne6PeMBvsh5thd" +
       "R47Gtn79WvtHhJsprL1142pNGVE0F3+z2PVg5oQugeOwkO2wd0IdUP1m04+U" +
       "tcy5vxFqC6jDJVoI+J8smwosSjOcNCPwbEmXjuhqzJn1dfm0+aNsN3hQqreN" +
       "81kh6rN5UFqeiVJlAKkHCfdm+iouKJa70g28O5+hXlbuCED0M1h0g68dUuhG" +
       "xJN5AQeyvygmZGeE3GcKh8yPNDdkDAsHkFgAILifGOrngPTmAGR3sQBZDMdF" +
       "IdXFwgHxI/WI6qhIaCaTd18AFngzpFEyBbBg6Vsr7j7Aei69tHf2xWuIEETg" +
       "ws+U7PyYm9b4PKE0SiNDih6PdEt0OMp+gLL3xIvZvbMfHhrh5uSFkYdA3kBE" +
       "t9vyRw9mulikN75DY+Pb+BZ8seVUwMZ36K6Aur/B4g6sMTgnAW3v9lPowI1v" +
       "ZjfxYtkNrl3eFTr3buF240eaz24OBcB0BIvPUzLdazdiAw+rkw409xUBGpac" +
       "LAKO63if/BwATXbw9iXNB82jAdD8PRZfpqTWzu23SBSs0XIHtVyRfMKArmuK" +
       "lMinZl8pFpaQCIWWCUCWFY6lH2k+LL8ZgOUzWJygpMG11BBwYs3XHFSeKBYq" +
       "sIIKie31UNbmfH5U/Eg9QpcyRkr3iWVUaKadHy/+SD+l7EsH/hcC0Pw3LJ6j" +
       "/OHB3DD+cxFgnGwr16MCi0fzwJjtw3xJ8ynXKwFw/DsWL2GqLSU2qJahSWMd" +
       "6oiS6OKPErhhOV0sWBqB22eEbM8UDosfaW5Y8nmgUnlYMnNgCe6HAXY+AMw3" +
       "sThHSaUDpgfDHxcBw1obw9MCiNOFY+hH6hG2hP9a6skJ8adHtsnyj7wXfqZk" +
       "6GMmbUAWj4zgo1L4mooalyiuADF72wCX7BkqOz/8/xrKlSv+hk35Bf9c8Td2" +
       "rvjOuHLFK+PMFTlfV/B7UK74h4C6P2Lxe6wxOCcBbT8oNFfcl7lI+7V/32G2" +
       "oPslJTWOPe0wtuv70jk6s6lLxbSp88IwzhduU36kATYFsW62E+tyR7g0dOHq" +
       "AOjwAY9wRR7owhOLCF24kffJzwVB50uaJ9KF5wQgMheL6fkQmVEERGZh3XIQ" +
       "Z7kQa3nhiPiRegT2PIjJH66DhS/fdsQ9x21KIqaY4qE3FP4yQ2dpAHJXY9FE" +
       "ST3fjmNLnV4l/Qpd3v1ZLwEDOu+W88cBWiSc4Xy5ag6g/UhzA42SoEsP1zCk" +
       "bghAcQ0WK3OhiBURB5lVxUTmuBDveOHI+JHm9mc2MqGkA09HADydWKz/CPC0" +
       "FhOe54WMzxcOjx9psOIIx7U9ABn0+OGtHwGZ7iIm6OEfCvF+WDgyfqS+3pxc" +
       "zwSXAkDBZ/TCt0CqDc4M1ivo2RBNZwc3vKsIaDRgHWS64VeFSK8WjoYfaYCw" +
       "iYA6JA6r+GSLQtuluKqN2Uu3mQ4We4qARaNtM+eEQOcCsGBl5iOHEw1Tp6DG" +
       "Sszz0GF1QJ++xuTOiw4EwHU7FiOQBQBcmb8bhq5x8Botlo+5Crj9UMj2YeG6" +
       "40fqEdi1kXLZwYa5HAbCvQEAfQ6Lz+YD6O4iAlRSy/vk54IA8iX1BShckwug" +
       "BwMA+hIWh/IBdLiYAM0RUs4pHCA/Un/DmunAciwAlm9g8Wg+WL5aTFhEjlxS" +
       "eHrtS+pvWDNz6U3ANm74GSxO5AOoGFu47PeTGSDdKiHlqsIB8iMNEDhgFzZ8" +
       "EovnKJkAYKSfIHdQKMYOLIvdoCslok9+LgwFP9IASc8E1L2CxSlKKqieftDJ" +
       "HbZf/HPAkIIkyfkfBXzlakbWP7LwfxGRnzxaWzH96I6f8PdC7X/6mBQlFYNJ" +
       "TXO/ZOi6LjdMZVBl4E2yXzlE5s9RMt3nzStKyvkF8hw+y9v/lJI6b3tKytjZ" +
       "3e4CyOO0g674hbvJG5SUQBO8vMjVIPOpMv6uZYpvms1244ewk7zPl6VJ3K/t" +
       "444N+0cc+52+JP9PnH75qaObum67surr/G8DZE3avx97qYqSCfwfDFin+F7g" +
       "At/e7L7KNy59v+bpiYvtp3zqOcOO6s529IskIdEycMZned6pt5rSr9b/7Nia" +
       "F145WP5amIR2kpBEyeSd2W+lpoykSRp3RrNfy+6VTPayf8vSL4+tXTH42wvs" +
       "PT2S9bavt32/fPb4rtcPzTg2N0yqOkmZmogpKfa67IaxxDZFHjH7SLVqtaWA" +
       "RehFlbSMd75rUDklNBmGi4CzOn0X/3SCkoXZL7xn/1VHpaaPKuZ6PZmIYTfV" +
       "UVLl3OEz43m1MmkYHgLnjphKLDdgsTqFswH62B/dYhj2/wGUnTKYdbaljda7" +
       "RRr+X3aJV+/8H7VJj94tSwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDs2Flev/tm98y8WWzPMMxmz4wZTztP3a1ePeMxUre6" +
       "pW5t3Wr1ImNm1NrV2peWumECOAFDIMTEYyCFGRKWGFwGTLADlQAxSbEYEyom" +
       "LImpYKCoxIQ4haEgJCZxjtR9l3ffvfetpqv0t6Rzjs73/ec///mPdKSPfL5w" +
       "axgUip5rrTXLjS4qaXTRtGoXo7WnhBf7ZI0Vg1CR25YYhmNw7iXpzR+98Fdf" +
       "fJ9+317hNqHwoOg4biRGhuuEIyV0rZUik4ULh2cxS7HDqHAfaYorEYojw4JI" +
       "I4yeJwuvO1I0KjxN7kOAAAQIQIByCBBymAsUukdxYrudlRCdKPQLf7dwjizc" +
       "5kkZvKjwpksv4omBaO8uw+YMwBXuyI4ngFReOA0KTx5w33K+jPAHitCr3/O1" +
       "9/2L84ULQuGC4XAZHAmAiEAlQuFuW7EXShAisqzIQuF+R1FkTgkM0TI2OW6h" +
       "8EBoaI4YxYFyoKTsZOwpQV7noebuljJuQSxFbnBATzUUS94/ulW1RA1wfeMh" +
       "1y3DbnYeELzLAMACVZSU/SK3LA1HjgpPHC9xwPHpAcgAit5uK5HuHlR1iyOC" +
       "E4UHtm1niY4GcVFgOBrIeqsbg1qiwiOnXjTTtSdKS1FTXooKDx/Px26TQK47" +
       "c0VkRaLCG45ny68EWumRY610pH0+T7/wnV/n4M5ejllWJCvDfwco9PixQiNF" +
       "VQLFkZRtwbufI79bfOPPf+teoQAyv+FY5m2en/n6L3z12x7/xK9u83zlCXmY" +
       "halI0UvSDy/u/fSj7be2zmcw7vDc0Mga/xLmufmzu5TnUw/0vDceXDFLvLif" +
       "+InRL8+/8cPKn+4V7iIKt0muFdvAju6XXNszLCXoKY4SiJEiE4U7FUdu5+lE" +
       "4XawTxqOsj3LqGqoREThFis/dZubHwMVqeASmYpuB/uGo7r7+54Y6fl+6hUK" +
       "hXvAVngRbLXC9pf/RwUe0l1bgURJdAzHhdjAzfiHkOJEC6BbHVoAq19CoRsH" +
       "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" +
       "qrMTh2/TkATCmI4PD7s1Jwm6wGcvBL2l");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "EnVF27DWu7B9Nx/KCeI3QPCxfZP97R3B374WglHhTi9wI2BYinz1Nxr35mcw" +
       "flcmODCMAcaXvk5z7ojZjm+0lz4LUH1pR/lLN6dND2es28iQ3hd79+TMlDNY" +
       "Z++r7L18JdbiTWB9/sK27Pb/prL+i5NY+2ewzk7uWVdibd8M1o/uWD96c1gf" +
       "sWvkkOsrZ3D9hkykV+K6vhlcd+HZ+ZsUnh2/E3O8hb/tDNbfnom/fyXW33yj" +
       "d1YfBmzrO9b1m8P6KIsPnJH2PZl4X1S4HTA8+C7GIbXvutHBB7Tq+V3Z7f/N" +
       "pfbPzkj7oUx8MCrcEbnbr4blJnDI7fuvhRsw/bsOP0mZfV/v4cs+brv9IKv0" +
       "E69duOOh1/jf3X6Fbf+jqXeShTvU2LKOfnvryP5tXqCo2w/g3JnLe72cxIej" +
       "wkOnfF8pKty23cn90I9t8/94VLjveP6ocGv+fzTfRwGfw3zgUtudo1l+Oiqc" +
       "B1my3Y9tp/eXfopt+wmydHtf4eGjNpA/AX/gSuo9KHL0o43ZbDn/uPD+R7bi" +
       "7eeFX5J+8rU+/XVfqP/I9qORkiVu8mruIAu3b79fmV80+1DXm0692v61bsPf" +
       "+sV7P3rnM/tPrO/dAj60xyPYnjj5C42Y7UX5NxU3P/vQx1740Gu/n78m+v8B" +
       "gGyqw/VZAAA=");
}
