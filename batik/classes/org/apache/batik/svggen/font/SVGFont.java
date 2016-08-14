package org.apache.batik.svggen.font;
public class SVGFont implements org.apache.batik.util.XMLConstants, org.apache.batik.util.SVGConstants, org.apache.batik.svggen.font.table.ScriptTags, org.apache.batik.svggen.font.table.FeatureTags {
    static final java.lang.String EOL;
    static final java.lang.String PROPERTY_LINE_SEPARATOR = "line.separator";
    static final java.lang.String PROPERTY_LINE_SEPARATOR_DEFAULT = "\n";
    static final int DEFAULT_FIRST = 32;
    static final int DEFAULT_LAST = 128;
    static { java.lang.String temp;
             try { temp = java.lang.System.getProperty(PROPERTY_LINE_SEPARATOR,
                                                       PROPERTY_LINE_SEPARATOR_DEFAULT);
             }
             catch (java.lang.SecurityException e) {
                 temp =
                   PROPERTY_LINE_SEPARATOR_DEFAULT;
             }
             EOL = temp; }
    private static java.lang.String QUOT_EOL = XML_CHAR_QUOT + EOL;
    private static java.lang.String CONFIG_USAGE = "SVGFont.config.usage";
    private static java.lang.String CONFIG_SVG_BEGIN = "SVGFont.config.svg.begin";
    private static java.lang.String CONFIG_SVG_TEST_CARD_START = "SVGFont.config.svg.test.card.start";
    private static java.lang.String CONFIG_SVG_TEST_CARD_END = "SVGFont.config.svg.test.card.end";
    protected static java.lang.String encodeEntities(java.lang.String s) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        for (int i =
               0;
             i <
               s.
               length(
                 );
             i++) {
            if (s.
                  charAt(
                    i) ==
                  XML_CHAR_LT) {
                sb.
                  append(
                    XML_ENTITY_LT);
            }
            else
                if (s.
                      charAt(
                        i) ==
                      XML_CHAR_GT) {
                    sb.
                      append(
                        XML_ENTITY_GT);
                }
                else
                    if (s.
                          charAt(
                            i) ==
                          XML_CHAR_AMP) {
                        sb.
                          append(
                            XML_ENTITY_AMP);
                    }
                    else
                        if (s.
                              charAt(
                                i) ==
                              XML_CHAR_APOS) {
                            sb.
                              append(
                                XML_ENTITY_APOS);
                        }
                        else
                            if (s.
                                  charAt(
                                    i) ==
                                  XML_CHAR_QUOT) {
                                sb.
                                  append(
                                    XML_ENTITY_QUOT);
                            }
                            else {
                                sb.
                                  append(
                                    s.
                                      charAt(
                                        i));
                            }
        }
        return sb.
          toString(
            );
    }
    protected static java.lang.String getContourAsSVGPathData(org.apache.batik.svggen.font.Glyph glyph,
                                                              int startIndex,
                                                              int count) {
        if (glyph.
              getPoint(
                startIndex).
              endOfContour) {
            return "";
        }
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        int offset =
          0;
        while (offset <
                 count) {
            org.apache.batik.svggen.font.Point point =
              glyph.
              getPoint(
                startIndex +
                  offset %
                  count);
            org.apache.batik.svggen.font.Point point_plus1 =
              glyph.
              getPoint(
                startIndex +
                  (offset +
                     1) %
                  count);
            org.apache.batik.svggen.font.Point point_plus2 =
              glyph.
              getPoint(
                startIndex +
                  (offset +
                     2) %
                  count);
            if (offset ==
                  0) {
                sb.
                  append(
                    PATH_MOVE).
                  append(
                    java.lang.String.
                      valueOf(
                        point.
                          x)).
                  append(
                    XML_SPACE).
                  append(
                    java.lang.String.
                      valueOf(
                        point.
                          y));
            }
            if (point.
                  onCurve &&
                  point_plus1.
                    onCurve) {
                if (point_plus1.
                      x ==
                      point.
                        x) {
                    sb.
                      append(
                        PATH_VERTICAL_LINE_TO).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus1.
                              y));
                }
                else
                    if (point_plus1.
                          y ==
                          point.
                            y) {
                        sb.
                          append(
                            PATH_HORIZONTAL_LINE_TO).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  x));
                    }
                    else {
                        sb.
                          append(
                            PATH_LINE_TO).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  x)).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  y));
                    }
                offset++;
            }
            else
                if (point.
                      onCurve &&
                      !point_plus1.
                         onCurve &&
                      point_plus2.
                        onCurve) {
                    sb.
                      append(
                        PATH_QUAD_TO).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus1.
                              x)).
                      append(
                        XML_SPACE).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus1.
                              y)).
                      append(
                        XML_SPACE).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus2.
                              x)).
                      append(
                        XML_SPACE).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus2.
                              y));
                    offset +=
                      2;
                }
                else
                    if (point.
                          onCurve &&
                          !point_plus1.
                             onCurve &&
                          !point_plus2.
                             onCurve) {
                        sb.
                          append(
                            PATH_QUAD_TO).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  x)).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  y)).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                midValue(
                                  point_plus1.
                                    x,
                                  point_plus2.
                                    x))).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                midValue(
                                  point_plus1.
                                    y,
                                  point_plus2.
                                    y)));
                        offset +=
                          2;
                    }
                    else
                        if (!point.
                               onCurve &&
                              !point_plus1.
                                 onCurve) {
                            sb.
                              append(
                                PATH_SMOOTH_QUAD_TO).
                              append(
                                java.lang.String.
                                  valueOf(
                                    midValue(
                                      point.
                                        x,
                                      point_plus1.
                                        x))).
                              append(
                                XML_SPACE).
                              append(
                                java.lang.String.
                                  valueOf(
                                    midValue(
                                      point.
                                        y,
                                      point_plus1.
                                        y)));
                            offset++;
                        }
                        else
                            if (!point.
                                   onCurve &&
                                  point_plus1.
                                    onCurve) {
                                sb.
                                  append(
                                    PATH_SMOOTH_QUAD_TO).
                                  append(
                                    java.lang.String.
                                      valueOf(
                                        point_plus1.
                                          x)).
                                  append(
                                    XML_SPACE).
                                  append(
                                    java.lang.String.
                                      valueOf(
                                        point_plus1.
                                          y));
                                offset++;
                            }
                            else {
                                java.lang.System.
                                  out.
                                  println(
                                    "drawGlyph case not catered for!!");
                                break;
                            }
        }
        sb.
          append(
            PATH_CLOSE);
        return sb.
          toString(
            );
    }
    protected static java.lang.String getSVGFontFaceElement(org.apache.batik.svggen.font.Font font) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        java.lang.String fontFamily =
          font.
          getNameTable(
            ).
          getRecord(
            org.apache.batik.svggen.font.table.Table.
              nameFontFamilyName);
        short unitsPerEm =
          font.
          getHeadTable(
            ).
          getUnitsPerEm(
            );
        java.lang.String panose =
          font.
          getOS2Table(
            ).
          getPanose(
            ).
          toString(
            );
        short ascent =
          font.
          getHheaTable(
            ).
          getAscender(
            );
        short descent =
          font.
          getHheaTable(
            ).
          getDescender(
            );
        int baseline =
          0;
        sb.
          append(
            XML_OPEN_TAG_START).
          append(
            SVG_FONT_FACE_TAG).
          append(
            EOL).
          append(
            XML_TAB).
          append(
            SVG_FONT_FAMILY_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            fontFamily).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_UNITS_PER_EM_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            unitsPerEm).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_PANOSE_1_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            panose).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_ASCENT_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            ascent).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_DESCENT_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            descent).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_ALPHABETIC_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            baseline).
          append(
            XML_CHAR_QUOT).
          append(
            XML_OPEN_TAG_END_NO_CHILDREN).
          append(
            EOL);
        return sb.
          toString(
            );
    }
    protected static void writeFontAsSVGFragment(java.io.PrintStream ps,
                                                 org.apache.batik.svggen.font.Font font,
                                                 java.lang.String id,
                                                 int first,
                                                 int last,
                                                 boolean autoRange,
                                                 boolean forceAscii)
          throws java.lang.Exception { int horiz_advance_x =
                                         font.
                                         getOS2Table(
                                           ).
                                         getAvgCharWidth(
                                           );
                                       ps.
                                         print(
                                           XML_OPEN_TAG_START);
                                       ps.
                                         print(
                                           SVG_FONT_TAG);
                                       ps.
                                         print(
                                           XML_SPACE);
                                       if (id !=
                                             null) {
                                           ps.
                                             print(
                                               SVG_ID_ATTRIBUTE);
                                           ps.
                                             print(
                                               XML_EQUAL_QUOT);
                                           ps.
                                             print(
                                               id);
                                           ps.
                                             print(
                                               XML_CHAR_QUOT);
                                           ps.
                                             print(
                                               XML_SPACE);
                                       }
                                       ps.
                                         print(
                                           SVG_HORIZ_ADV_X_ATTRIBUTE);
                                       ps.
                                         print(
                                           XML_EQUAL_QUOT);
                                       ps.
                                         print(
                                           horiz_advance_x);
                                       ps.
                                         print(
                                           XML_CHAR_QUOT);
                                       ps.
                                         print(
                                           XML_OPEN_TAG_END_CHILDREN);
                                       ps.
                                         print(
                                           getSVGFontFaceElement(
                                             font));
                                       org.apache.batik.svggen.font.table.CmapFormat cmapFmt =
                                         null;
                                       if (forceAscii) {
                                           cmapFmt =
                                             font.
                                               getCmapTable(
                                                 ).
                                               getCmapFormat(
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMacintosh,
                                                 org.apache.batik.svggen.font.table.Table.
                                                   encodingRoman);
                                       }
                                       else {
                                           cmapFmt =
                                             font.
                                               getCmapTable(
                                                 ).
                                               getCmapFormat(
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMicrosoft,
                                                 org.apache.batik.svggen.font.table.Table.
                                                   encodingUGL);
                                           if (cmapFmt ==
                                                 null) {
                                               cmapFmt =
                                                 font.
                                                   getCmapTable(
                                                     ).
                                                   getCmapFormat(
                                                     org.apache.batik.svggen.font.table.Table.
                                                       platformMicrosoft,
                                                     org.apache.batik.svggen.font.table.Table.
                                                       encodingUndefined);
                                           }
                                       }
                                       if (cmapFmt ==
                                             null) {
                                           throw new java.lang.Exception(
                                             "Cannot find a suitable cmap table");
                                       }
                                       org.apache.batik.svggen.font.table.GsubTable gsub =
                                         (org.apache.batik.svggen.font.table.GsubTable)
                                           font.
                                           getTable(
                                             org.apache.batik.svggen.font.table.Table.
                                               GSUB);
                                       org.apache.batik.svggen.font.table.SingleSubst initialSubst =
                                         null;
                                       org.apache.batik.svggen.font.table.SingleSubst medialSubst =
                                         null;
                                       org.apache.batik.svggen.font.table.SingleSubst terminalSubst =
                                         null;
                                       if (gsub !=
                                             null) {
                                           org.apache.batik.svggen.font.table.Script s =
                                             gsub.
                                             getScriptList(
                                               ).
                                             findScript(
                                               SCRIPT_TAG_ARAB);
                                           if (s !=
                                                 null) {
                                               org.apache.batik.svggen.font.table.LangSys ls =
                                                 s.
                                                 getDefaultLangSys(
                                                   );
                                               if (ls !=
                                                     null) {
                                                   org.apache.batik.svggen.font.table.Feature init =
                                                     gsub.
                                                     getFeatureList(
                                                       ).
                                                     findFeature(
                                                       ls,
                                                       FEATURE_TAG_INIT);
                                                   org.apache.batik.svggen.font.table.Feature medi =
                                                     gsub.
                                                     getFeatureList(
                                                       ).
                                                     findFeature(
                                                       ls,
                                                       FEATURE_TAG_MEDI);
                                                   org.apache.batik.svggen.font.table.Feature fina =
                                                     gsub.
                                                     getFeatureList(
                                                       ).
                                                     findFeature(
                                                       ls,
                                                       FEATURE_TAG_FINA);
                                                   initialSubst =
                                                     (org.apache.batik.svggen.font.table.SingleSubst)
                                                       gsub.
                                                       getLookupList(
                                                         ).
                                                       getLookup(
                                                         init,
                                                         0).
                                                       getSubtable(
                                                         0);
                                                   medialSubst =
                                                     (org.apache.batik.svggen.font.table.SingleSubst)
                                                       gsub.
                                                       getLookupList(
                                                         ).
                                                       getLookup(
                                                         medi,
                                                         0).
                                                       getSubtable(
                                                         0);
                                                   terminalSubst =
                                                     (org.apache.batik.svggen.font.table.SingleSubst)
                                                       gsub.
                                                       getLookupList(
                                                         ).
                                                       getLookup(
                                                         fina,
                                                         0).
                                                       getSubtable(
                                                         0);
                                               }
                                           }
                                       }
                                       ps.
                                         println(
                                           getGlyphAsSVG(
                                             font,
                                             font.
                                               getGlyph(
                                                 0),
                                             0,
                                             horiz_advance_x,
                                             initialSubst,
                                             medialSubst,
                                             terminalSubst,
                                             ""));
                                       try {
                                           if (first ==
                                                 -1) {
                                               if (!autoRange)
                                                   first =
                                                     DEFAULT_FIRST;
                                               else
                                                   first =
                                                     cmapFmt.
                                                       getFirst(
                                                         );
                                           }
                                           if (last ==
                                                 -1) {
                                               if (!autoRange)
                                                   last =
                                                     DEFAULT_LAST;
                                               else
                                                   last =
                                                     cmapFmt.
                                                       getLast(
                                                         );
                                           }
                                           for (int i =
                                                  first;
                                                i <=
                                                  last;
                                                i++) {
                                               int glyphIndex =
                                                 cmapFmt.
                                                 mapCharCode(
                                                   i);
                                               if (glyphIndex >
                                                     0) {
                                                   ps.
                                                     println(
                                                       getGlyphAsSVG(
                                                         font,
                                                         font.
                                                           getGlyph(
                                                             glyphIndex),
                                                         glyphIndex,
                                                         horiz_advance_x,
                                                         initialSubst,
                                                         medialSubst,
                                                         terminalSubst,
                                                         32 <=
                                                           i &&
                                                           i <=
                                                           127
                                                           ? encodeEntities(
                                                               java.lang.String.
                                                                 valueOf(
                                                                   (char)
                                                                     i))
                                                           : XML_CHAR_REF_PREFIX +
                                                         java.lang.Integer.
                                                           toHexString(
                                                             i) +
                                                         XML_CHAR_REF_SUFFIX));
                                               }
                                           }
                                           org.apache.batik.svggen.font.table.KernTable kern =
                                             (org.apache.batik.svggen.font.table.KernTable)
                                               font.
                                               getTable(
                                                 org.apache.batik.svggen.font.table.Table.
                                                   kern);
                                           if (kern !=
                                                 null) {
                                               org.apache.batik.svggen.font.table.KernSubtable kst =
                                                 kern.
                                                 getSubtable(
                                                   0);
                                               org.apache.batik.svggen.font.table.PostTable post =
                                                 (org.apache.batik.svggen.font.table.PostTable)
                                                   font.
                                                   getTable(
                                                     org.apache.batik.svggen.font.table.Table.
                                                       post);
                                               for (int i =
                                                      0;
                                                    i <
                                                      kst.
                                                      getKerningPairCount(
                                                        );
                                                    i++) {
                                                   ps.
                                                     println(
                                                       getKerningPairAsSVG(
                                                         kst.
                                                           getKerningPair(
                                                             i),
                                                         post));
                                               }
                                           }
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             err.
                                             println(
                                               e.
                                                 getMessage(
                                                   ));
                                       }
                                       ps.
                                         print(
                                           XML_CLOSE_TAG_START);
                                       ps.
                                         print(
                                           SVG_FONT_TAG);
                                       ps.
                                         println(
                                           XML_CLOSE_TAG_END);
    }
    protected static java.lang.String getGlyphAsSVG(org.apache.batik.svggen.font.Font font,
                                                    org.apache.batik.svggen.font.Glyph glyph,
                                                    int glyphIndex,
                                                    int defaultHorizAdvanceX,
                                                    java.lang.String attrib,
                                                    java.lang.String code) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        int firstIndex =
          0;
        int count =
          0;
        int i;
        int horiz_advance_x;
        horiz_advance_x =
          font.
            getHmtxTable(
              ).
            getAdvanceWidth(
              glyphIndex);
        if (glyphIndex ==
              0) {
            sb.
              append(
                XML_OPEN_TAG_START);
            sb.
              append(
                SVG_MISSING_GLYPH_TAG);
        }
        else {
            sb.
              append(
                XML_OPEN_TAG_START).
              append(
                SVG_GLYPH_TAG).
              append(
                XML_SPACE).
              append(
                SVG_UNICODE_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT).
              append(
                code).
              append(
                XML_CHAR_QUOT);
            sb.
              append(
                XML_SPACE).
              append(
                SVG_GLYPH_NAME_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT).
              append(
                font.
                  getPostTable(
                    ).
                  getGlyphName(
                    glyphIndex)).
              append(
                XML_CHAR_QUOT);
        }
        if (horiz_advance_x !=
              defaultHorizAdvanceX) {
            sb.
              append(
                XML_SPACE).
              append(
                SVG_HORIZ_ADV_X_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT).
              append(
                horiz_advance_x).
              append(
                XML_CHAR_QUOT);
        }
        if (attrib !=
              null) {
            sb.
              append(
                attrib);
        }
        if (glyph !=
              null) {
            sb.
              append(
                XML_SPACE).
              append(
                SVG_D_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT);
            for (i =
                   0;
                 i <
                   glyph.
                   getPointCount(
                     );
                 i++) {
                count++;
                if (glyph.
                      getPoint(
                        i).
                      endOfContour) {
                    sb.
                      append(
                        getContourAsSVGPathData(
                          glyph,
                          firstIndex,
                          count));
                    firstIndex =
                      i +
                        1;
                    count =
                      0;
                }
            }
            sb.
              append(
                XML_CHAR_QUOT);
        }
        sb.
          append(
            XML_OPEN_TAG_END_NO_CHILDREN);
        chopUpStringBuffer(
          sb);
        return sb.
          toString(
            );
    }
    protected static java.lang.String getGlyphAsSVG(org.apache.batik.svggen.font.Font font,
                                                    org.apache.batik.svggen.font.Glyph glyph,
                                                    int glyphIndex,
                                                    int defaultHorizAdvanceX,
                                                    org.apache.batik.svggen.font.table.SingleSubst arabInitSubst,
                                                    org.apache.batik.svggen.font.table.SingleSubst arabMediSubst,
                                                    org.apache.batik.svggen.font.table.SingleSubst arabTermSubst,
                                                    java.lang.String code) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        boolean substituted =
          false;
        int arabInitGlyphIndex =
          glyphIndex;
        int arabMediGlyphIndex =
          glyphIndex;
        int arabTermGlyphIndex =
          glyphIndex;
        if (arabInitSubst !=
              null) {
            arabInitGlyphIndex =
              arabInitSubst.
                substitute(
                  glyphIndex);
        }
        if (arabMediSubst !=
              null) {
            arabMediGlyphIndex =
              arabMediSubst.
                substitute(
                  glyphIndex);
        }
        if (arabTermSubst !=
              null) {
            arabTermGlyphIndex =
              arabTermSubst.
                substitute(
                  glyphIndex);
        }
        if (arabInitGlyphIndex !=
              glyphIndex) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  font.
                    getGlyph(
                      arabInitGlyphIndex),
                  arabInitGlyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_INITIAL_VALUE +
                  XML_CHAR_QUOT,
                  code));
            sb.
              append(
                EOL);
            substituted =
              true;
        }
        if (arabMediGlyphIndex !=
              glyphIndex) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  font.
                    getGlyph(
                      arabMediGlyphIndex),
                  arabMediGlyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_MEDIAL_VALUE +
                  XML_CHAR_QUOT,
                  code));
            sb.
              append(
                EOL);
            substituted =
              true;
        }
        if (arabTermGlyphIndex !=
              glyphIndex) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  font.
                    getGlyph(
                      arabTermGlyphIndex),
                  arabTermGlyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_TERMINAL_VALUE +
                  XML_CHAR_QUOT,
                  code));
            sb.
              append(
                EOL);
            substituted =
              true;
        }
        if (substituted) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  glyph,
                  glyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_ISOLATED_VALUE +
                  XML_CHAR_QUOT,
                  code));
        }
        else {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  glyph,
                  glyphIndex,
                  defaultHorizAdvanceX,
                  null,
                  code));
        }
        return sb.
          toString(
            );
    }
    protected static java.lang.String getKerningPairAsSVG(org.apache.batik.svggen.font.table.KerningPair kp,
                                                          org.apache.batik.svggen.font.table.PostTable post) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            XML_OPEN_TAG_START).
          append(
            SVG_HKERN_TAG).
          append(
            XML_SPACE);
        sb.
          append(
            SVG_G1_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT);
        sb.
          append(
            post.
              getGlyphName(
                kp.
                  getLeft(
                    )));
        sb.
          append(
            XML_CHAR_QUOT).
          append(
            XML_SPACE).
          append(
            SVG_G2_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT);
        sb.
          append(
            post.
              getGlyphName(
                kp.
                  getRight(
                    )));
        sb.
          append(
            XML_CHAR_QUOT).
          append(
            XML_SPACE).
          append(
            SVG_K_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT);
        sb.
          append(
            -kp.
              getValue(
                ));
        sb.
          append(
            XML_CHAR_QUOT).
          append(
            XML_OPEN_TAG_END_NO_CHILDREN);
        return sb.
          toString(
            );
    }
    protected static void writeSvgBegin(java.io.PrintStream ps) {
        ps.
          println(
            org.apache.batik.svggen.font.Messages.
              formatMessage(
                CONFIG_SVG_BEGIN,
                new java.lang.Object[] { SVG_PUBLIC_ID,
                SVG_SYSTEM_ID }));
    }
    protected static void writeSvgDefsBegin(java.io.PrintStream ps) {
        ps.
          println(
            XML_OPEN_TAG_START +
            SVG_DEFS_TAG +
            XML_OPEN_TAG_END_CHILDREN);
    }
    protected static void writeSvgDefsEnd(java.io.PrintStream ps) {
        ps.
          println(
            XML_CLOSE_TAG_START +
            SVG_DEFS_TAG +
            XML_CLOSE_TAG_END);
    }
    protected static void writeSvgEnd(java.io.PrintStream ps) {
        ps.
          println(
            XML_CLOSE_TAG_START +
            SVG_SVG_TAG +
            XML_CLOSE_TAG_END);
    }
    protected static void writeSvgTestCard(java.io.PrintStream ps,
                                           java.lang.String fontFamily) {
        ps.
          println(
            org.apache.batik.svggen.font.Messages.
              formatMessage(
                CONFIG_SVG_TEST_CARD_START,
                null));
        ps.
          println(
            fontFamily);
        ps.
          println(
            org.apache.batik.svggen.font.Messages.
              formatMessage(
                CONFIG_SVG_TEST_CARD_END,
                null));
    }
    public static final char ARG_KEY_START_CHAR =
      '-';
    public static final java.lang.String ARG_KEY_CHAR_RANGE_LOW =
      "-l";
    public static final java.lang.String ARG_KEY_CHAR_RANGE_HIGH =
      "-h";
    public static final java.lang.String ARG_KEY_ID =
      "-id";
    public static final java.lang.String ARG_KEY_ASCII =
      "-ascii";
    public static final java.lang.String ARG_KEY_TESTCARD =
      "-testcard";
    public static final java.lang.String ARG_KEY_AUTO_RANGE =
      "-autorange";
    public static final java.lang.String ARG_KEY_OUTPUT_PATH =
      "-o";
    public static void main(java.lang.String[] args) {
        try {
            java.lang.String path =
              parseArgs(
                args,
                null);
            java.lang.String low =
              parseArgs(
                args,
                ARG_KEY_CHAR_RANGE_LOW);
            java.lang.String high =
              parseArgs(
                args,
                ARG_KEY_CHAR_RANGE_HIGH);
            java.lang.String id =
              parseArgs(
                args,
                ARG_KEY_ID);
            java.lang.String ascii =
              parseArgs(
                args,
                ARG_KEY_ASCII);
            java.lang.String testCard =
              parseArgs(
                args,
                ARG_KEY_TESTCARD);
            java.lang.String outPath =
              parseArgs(
                args,
                ARG_KEY_OUTPUT_PATH);
            java.lang.String autoRange =
              parseArgs(
                args,
                ARG_KEY_AUTO_RANGE);
            java.io.PrintStream ps =
              null;
            java.io.FileOutputStream fos =
              null;
            if (outPath !=
                  null) {
                fos =
                  new java.io.FileOutputStream(
                    outPath);
                ps =
                  new java.io.PrintStream(
                    fos);
            }
            else {
                ps =
                  java.lang.System.
                    out;
            }
            if (path !=
                  null) {
                org.apache.batik.svggen.font.Font font =
                  org.apache.batik.svggen.font.Font.
                  create(
                    path);
                writeSvgBegin(
                  ps);
                writeSvgDefsBegin(
                  ps);
                writeFontAsSVGFragment(
                  ps,
                  font,
                  id,
                  low !=
                    null
                    ? java.lang.Integer.
                    parseInt(
                      low)
                    : -1,
                  high !=
                    null
                    ? java.lang.Integer.
                    parseInt(
                      high)
                    : -1,
                  autoRange !=
                    null,
                  ascii !=
                    null);
                writeSvgDefsEnd(
                  ps);
                if (testCard !=
                      null) {
                    java.lang.String fontFamily =
                      font.
                      getNameTable(
                        ).
                      getRecord(
                        org.apache.batik.svggen.font.table.Table.
                          nameFontFamilyName);
                    writeSvgTestCard(
                      ps,
                      fontFamily);
                }
                writeSvgEnd(
                  ps);
                if (fos !=
                      null) {
                    fos.
                      close(
                        );
                }
            }
            else {
                usage(
                  );
            }
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            java.lang.System.
              err.
              println(
                e.
                  getMessage(
                    ));
            usage(
              );
        }
    }
    private static void chopUpStringBuffer(java.lang.StringBuffer sb) {
        if (sb.
              length(
                ) <
              256) {
            return;
        }
        else {
            for (int i =
                   240;
                 i <
                   sb.
                   length(
                     );
                 i++) {
                if (sb.
                      charAt(
                        i) ==
                      ' ') {
                    sb.
                      setCharAt(
                        i,
                        '\n');
                    i +=
                      240;
                }
            }
        }
    }
    private static int midValue(int a, int b) {
        return a +
          (b -
             a) /
          2;
    }
    private static java.lang.String parseArgs(java.lang.String[] args,
                                              java.lang.String name) {
        for (int i =
               0;
             i <
               args.
                 length;
             i++) {
            if (name ==
                  null) {
                if (args[i].
                      charAt(
                        0) !=
                      ARG_KEY_START_CHAR) {
                    return args[i];
                }
            }
            else
                if (name.
                      equalsIgnoreCase(
                        args[i])) {
                    if (i <
                          args.
                            length -
                          1 &&
                          args[i +
                                 1].
                          charAt(
                            0) !=
                          ARG_KEY_START_CHAR) {
                        return args[i +
                                      1];
                    }
                    else {
                        return args[i];
                    }
                }
        }
        return null;
    }
    private static void usage() { java.lang.System.
                                    err.println(
                                          org.apache.batik.svggen.font.Messages.
                                            formatMessage(
                                              CONFIG_USAGE,
                                              null));
    }
    public SVGFont() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tmq8N9/vHReh4d7Hb/Fuz/8BkcvmSIk9AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jUKXmBP9vi1OwNA+bc7ri2UP2L3Le1t6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "bCmieUoAAA==");
}
