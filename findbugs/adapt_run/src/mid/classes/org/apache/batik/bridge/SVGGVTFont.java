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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3iVn/RbRq9GOL9HtqWZrsx5teKKRurzp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "yoKFFVoAAA==");
}
