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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NOytQb7ff+f/AaikIrzMOwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7Dz2F2f793Xt5t9fLvJProk2U12Q7NR9pNtybbMEoit" +
       "ty1ZsiXbspNwkfWwZMmSrJdl0+WRgSYlnTQTkpCEZKftBEqZJDBMQ9vpwKTD" +
       "kEChzMBQWmBgKcO0tAGadKbAFBp6JPt+9373u9/dvdkNntGxLJ3H7/c///M7" +
       "58jn6LN/VrojCktQ4LubuevH14wsvrZwa9fiTWBE1zpcTVTDyNBxV40iGVw7" +
       "0t78Mw/8xV9/yLp6WLpzWnqt6nl+rMa270UDI/Ld1NC50gMnV0nXWEZx6Sq3" +
       "UFMVTmLbhTk7ip/jSq85lTQuPc0dQ4ABBBhAgAsIcOskFkh0n+ElSzxPoXpx" +
       "tCp9b+mAK90ZaDm8uPSmGzMJ1FBd7rMRCwYghyv57xEgVSTOwtKT17nvON9E" +
       "+KMQ/JEf/a6rP3tb6YFp6QHbk3I4GgARg0KmpXuXxnJmhFFL1w19WnrQMwxd" +
       "MkJbde1tgXtaeiiy554aJ6Fx3Uj5xSQwwqLME8vdq+XcwkSL/fA6PdM2XP34" +
       "1x2mq84B10dOuO4YUvl1QPAeGwALTVUzjpPc7tieHpeeOJviOsenuyACSHrX" +
       "0ogt/3pRt3squFB6aFd3rurNYSkObW8Oot7hJ6CUuPT4LTPNbR2omqPOjaO4" +
       "9NjZeOLuFoh1d2GIPElcevhstCInUEuPn6mlU/XzZ71v/+D3eIx3WGDWDc3N" +
       "8V8Bid54JtHAMI3Q8DRjl/Det3EfUx/5+fcflkog8sNnIu/i/Ot/8LV3vv2N" +
       "X/zlXZxvOSeOMFsYWnykfWZ2/2+8Hn+meVsO40rgR3Ze+TcwL9xf3N95LgtA" +
       "y3vkeo75zWvHN784+NLk+3/K+Mph6R62dKfmu8kS+NGDmr8MbNcIacMzQjU2" +
       "dLZ0t+HpeHGfLd0FzjnbM3ZXBdOMjJgt3e4Wl+70i9/ARCbIIjfRXeDc9kz/" +
       "+DxQY6s4z4JSqXQXOEoSOODS7lN8xyUDtvylAaua6tmeD4uhn/PPK9TTVTg2" +
       "InCug7uBD8+A/zvPVq414MhPQuCQsB/OYRV4hWXsbsJROp8bHmwCS8HSiKbA" +
       "97Xc3YK/q4KynPHV9cEBqIzXn5UCF7Qixnd1IzzSPpK0ya99/uhXD683jb2t" +
       "gHiB0q7tSrtWlHZtV9q1vLRr+9JKBwdFIa/LS93VNqgrB7R6oIf3PiO9p/Pd" +
       "73/zbcDNgvXtwNB5VPjWsoyf6ARbqKEGnLX0xY+vf2D0feXD0uGN+pojBZfu" +
       "yZOLuSpeV7+nz7ar8/J94H1/8hc//bHn/ZMWdoNg7xv+zSnzhvvmszYNfc3Q" +
       "gRSeZP+2J9UvHP38808flm4HagAUMFaBxwJxeePZMm5owM8di2HO5Q5A2PTD" +
       "permt44V7J7YCv31yZWisu8vzh8ENpZL++AGF8/vvjbIw9ftnCOvtDMsCrF9" +
       "hxR8+r/8+v9ACnMf6/IDp3o6yYifO6UFeWYPFK3+wRMfkEPDAPF+/+Pij3z0" +
       "z973rsIBQIynzivw6TzEgQaAKgRm/qFfXv3Oi3/wmd86PHGaGHSGycy1tWxH" +
       "8m/B5wAcX8+PnFx+YdeOH8L3YvLkdTUJ8pK/9QQb0BUXNLncg54eektft01b" +
       "nblG7rF/88BbKl/40w9e3fmEC64cu9TbXzqDk+t/r136/l/9rr98Y5HNgZb3" +
       "ayf2O4m2E8vXnuTcCkN1k+PIfuA33/CJL6ufBrILpC6yt0ahXqXCHqWiAsuF" +
       "LaAihM/cq+bBE9HphnBjWzs1/jjSPvRbX71v9NVf+FqB9sYBzOl659XguZ2r" +
       "5cGTGcj+0bOtnlEjC8RDv9h791X3i38NcpyCHDWgXZEQAsHJbvCSfew77vrd" +
       "f/+Lj3z3b9xWOqRK97i+qlNq0eBKdwNPNyILaFUWfOc7d968vgKCqwXV0k3k" +
       "dw7yWPHrYQDwmVtrDZWPP06a62P/V3Bn7/2jv7rJCIXKnNPtnkk/hT/7qcfx" +
       "7/hKkf6kueep35jdLMJgrHaStvpTy/9z+OY7f+mwdNe0dFXbDwRHqpvkjWgK" +
       "Bj/R8egQDBZvuH/jQGbXaz93Xc5ef1ZqThV7VmhOxB+c57Hz83vOaEt+lF4P" +
       "jvJeW8pnteWgVJy8s0jypiJ8Og/+flEnh6ApR8VIMwal257qFgU8E5duIwWu" +
       "iP0wGFcXLpIzurYbmu0EKw+RPGjtqrl+S5d47kbAODiqe8DVmwADebk/H0xc" +
       "i4y9BOU3urcgkJ8SeUAeI39UHAgiOZAnRxzbI48kUmwNWrIwyG/TZ5Bzl0T+" +
       "neBA9siR85Af3JOfSy8b7BO3AHtEkFRryMnngZYvCfqt4KjtQdduBn29pygq" +
       "mAXj+rkRPvRH//Qzf/kD78MOc8G7I81dG7SaU47QS/L5yD/87Eff8JqP/OEH" +
       "is4B5Pxknum7Xjb7+/Ysjyh2IMkX64MY2kvQwaX7YTX8/EMvOp/6k8/thsxn" +
       "xeBMZOP9H/nhv732wY8cnpqoPHXTXOF0mt1kpcB5XwE2l9c3XVRKkYL67z/9" +
       "/L/7yefft0P10I3DbhLMKj/32//v1659/A9/5Zzx3W1gSnWmpt/9DdR0fV/T" +
       "9XNqOj95D7j8/fnJ8mVX073H1cS1pMIjzTM4vZeP87X51eZeBI7F4DzFSm6p" +
       "WHcFoZ2CkUQB9Bjjlf5QkI+AaJ3XYtJL4nsCHOweH3MLfM9fYL7NDdDuxYUe" +
       "xdJHQ6lFk+fB+95LwnsKHP09PPEW8H7wZcO7uocHZhBHbZJme+dB/KFLQnwW" +
       "HMoe4vgWED/wsiE+fgqiTEryEd4aEEeS3BqcK5D/+JJgIXAc7cF+1y3Afvhl" +
       "g33sXLBkjzgP6o+8fKiP5VcxUOSP7qLuvm/S8teeaDRugf5Ti40Q/QD9O87j" +
       "35oB1cGP1TwoPZun+sT5vG7LT996sxQ81BrQR11ysjP+Ec60BkVSbS+S+dc8" +
       "Lt2ugaLPUP3kJam+A1D8+J7qx2+mGpcOny2ewfz45Rg8cswgx340aPVo8ogT" +
       "xudVzk9cEvF3AKSf2CP+xPmIi0cfn7sc4kfPQcywNHMe5M9fEjIYfh1+cg/5" +
       "k+dBvu1ZW89/feFymO85xsye6/Y/9w24/Y/tYf7YeTDvfFaNNNvOL/z85ZDe" +
       "d4y0JeEsex7YX/gG3OBTe7CfOg/s3c/mz5U0NSws+0uXw3v1GG+uLbm0nAf5" +
       "S5eE3AJQP72H/OnzIN/zrJqAkThQlaLb/Y/foGq0hrKw8+DzUP/6JVF/G0D7" +
       "wh71C+e3t+Kx43+6HNrXHqMVhrI4lI/ElnxuW/vtl4S7E8UcyR3Va41r5fz3" +
       "71+y8S9c7enjhygjI4zAHPjphds4D9AzLxsQ6CfuP+knON+bP/eBP/7Qr/2T" +
       "p14EXUTnuIvIY4P+8ED8GHn1nfmPP74c9sdz7FLxrJRTo5gvnswYeg7/3E7D" +
       "9W+aWr58SvGjVxk0YlvHH64yw5G+VlGWUNJg3bHS8NGpthJrJNXOYs5eV6us" +
       "1CVjdcusnVBVKW1p87OwbGxHakpEW2axDMNNVdNIqFOzJTcQCEImJ3VItkTS" +
       "79XYwaZqT7wK6c6Y1ZjEFlbPJh1N6iQkZi8SYVLx1aEHw1iDbyTbaMuvpGZF" +
       "9rY9ZLDlENhswCmcGjCMIPzSNDsKyXvhdDUP2L4Qu9Bi4Gh8oyrgs7g9dDfr" +
       "yWDeNTqR0kAWQbXSHITYGmUkc8iO5X5CiwBJr2XYmh9MUClyLInAJwG76FPd" +
       "YWVuB65A1C0edyoD18I3owVp0c5mNJiklZW97NLehDU6kzI+afjl5XJYnszd" +
       "+ZSsDiubGalmfDfZ9sqDyMGHulKl1qsy1VZ8LdwSaWeJi74wsJK5vvb7/c2i" +
       "0yGcoTtHlKXOdEdBFDbKDa4rLG1B19fWrEGzCbGsBxOJriTwEIYaCw4tI1rb" +
       "H+PoyubnjQHd7dJdB+6POvKQqtWqm+1g0cBH8KC7sqccuuA3vXg4igO8I9H9" +
       "7rIX11qcGkL9buzyLhZaPBVLsTS1rYFdCymb7SQWnlmsjCJDGp8p/DpCuVZz" +
       "VTFmg6rWiOaiZ43qoq3o2xEWo+FwUWvXpYm70IeS327xLltu+dtJJiF92xsu" +
       "+pW+5Y9UsYVWpFHbndcmoV5xJNqlJpSzbk2jsdlZjFZ8rUKFNu7OB5HhTp1V" +
       "UGd6mNrbpEHaCOZR0GLCaN4Zk1VSFOdGSx90hnIbk9eiGrGeWJXIVbdaoTJb" +
       "3tKxG81bmRRvRq1qmExH2xFJGiSuym1h0JaGuu2LWXfssYKrUWRTqoWmww5U" +
       "tNLX14uAXkrOeIqkwaKGe1wPLQ/m5FAdJ2Evk/R2l1NrYy2URWjNIwjT7NdH" +
       "At5ptSuySw2yNBStcjdUJmO63l6MumafiCAcJ3SaseghnBA6i9MDox4FUS31" +
       "OGEDazHDVKqG2RPxCMPmGwFxKMq1BuJiU6tPx4oCJUkYtVeV5TJgq6JFbRgn" +
       "tStuKni8anQC15h4aBT1IEOZ+VU9TUx/A9GbQYUcsfHKY6stZDbsdv2pPO0G" +
       "iBONVvOED+yOw7gjSTGzptWTW+ZoIK1Et6zRW97HM7wWLbDhTOnCa6ObOS1y" +
       "6PaZZo3dBHGILCOChpSKwKLycE0qtsaOWUjTYVqlLU0eEX2U9budrm0tu3U7" +
       "tbP+zBP9/kwLIDwO/Cm9NhtITMOranuyqXTXQttypaYyYFvdaBJAM84h6IEM" +
       "3LLXmvKWwTYMJJ3Ha7Enmyk8DAZExqZIu8/1aTzVQwenlVjyNvZy1cGURdVA" +
       "dOD/bLq0VVqZ9OxNvFZWeLxuyuP1bFRZ9vz6kEqYYFImW+62Q8aDVbxQy5VB" +
       "w28a7SpV34gm3FgiplEd+fRUNdMl6HcnzclKmqh2iLZrkVdDh9vGetMTlY2E" +
       "jMX20OmL/NwnSIGKVDxW8fXa2nZ0aux0vQ5jruh2IwsIWBDaUwLhqhnXIAQI" +
       "qi9jk6jrtQFKbdcyNccsB62Fda6HqNVmrTcxYUDc87a+Q4U+SioLS0Z4dzog" +
       "0yazmrksAnUldKIia11kGau5wqctFGURoiWzLaHVqMXxKGYcE/ZjppxNVg61" +
       "poWVZ1GOSQ8bZcKvhqu0gTsQGsojO4r7ZWHbZ0brcY2Gm2WFSCvlDIK1dcUr" +
       "pzO0OalbglObBpjI+Vxr2XAwFW+qozK+pEwCg0k5raJizMwgY9mWvbEhudG6" +
       "0efSVlImFgRqGSYgw0BUXTeJbMY7GrleZlXKxhUmkrY10VxTqOiTHNznIZ4o" +
       "k2RFd4NYXcK6TC9XkO+2EIyab3R6Ul6EU6s9yUQ6EMjh1LUV2DahKEJEEzHg" +
       "fmWpYek649TxQue5LrGF5xDiNCwdkVVkOZmz9iKYU/A8nMqEgSV4qxYKKW6u" +
       "MqaR4uEqq0HyYk4RVlVb4aTu99YpGaEM2q+gnKHZWa8XKgJUncSdpUBXsaQd" +
       "1dggcaCuooiVDYphPY9LCZXydXrrzVKqMRDKaMiP5m0XH7PuQEFVZNOQeapq" +
       "zLd+pG8TXYzISbvKKJ6FoOv1rNbgjbk+l4d20qovhqQOU9Vk05EihOmFZjoD" +
       "NVOtQrXhikzWlj5jVwHjk0jCsCLXLqv+hlhhWeA1vE7IG9DYmatCG3IsnHTM" +
       "SQXRkKnX4yczlG+bnAlxdAOtQP04sdTZNDQIarle89XmBnI007DGjSYSLuUU" +
       "Xs1WKqyAXgsxvKZZs0MF7kEEltiDeIut1L6XZPIGCLdZc3R8Oqgk9Zm3UdwN" +
       "hJKbTZNztXrmEwQ3lQGXxVJEhbiiYGaHGC4Cki6j8UafB1vKW6zxaFqx2g2s" +
       "j2dGk0Mb8raLOzyEJaNGoC+HQlytkaNsoaJZM0PTZtvVJ8jEtlMriVebZJXq" +
       "I0ubw11VpBpLLajotmaN0rVNoCTKM+X5piyh/rwGdzfJZFh2O0xPohRk0pG9" +
       "GToJCEIDo5GKZa2MpYqNyvRmMhgiXS+sVBKuPBu1dX0pweKSdOU53tatfm9k" +
       "Dfl4ivoJSZRX2GLMSY01I8prZ7Gp9oh5g0l8bRBvxpbjE9G0gdYpC+t21hKF" +
       "MYrYpmuolfJwS59UXWjgpwZL1lMRxmZtoraZKB1rDdk1tpF4aXvdE2hq1tN4" +
       "Z1TuVDI1bLtx1zFGzKCKrsjp3A1Uz2iKU0V2MF30Ap3sIBjS8iLQX3UYaVJx" +
       "eGWKyBWPcdcVGJ6nKWbp5NAy7DLHTB1hoKyH0/HYGjjGpkPwQ9kU2uuEsLSO" +
       "b3mDdXlcrg95QvTlii0vN+ORbMBQUotagoFy9kiTeWOSDmCYQyCvLoOhIsVN" +
       "1A4YhG2FNdeKOrVqG496S05e4BRHz2fBiiLCoc40RL/RbCLdzaAKfIaPe41F" +
       "E0YgtNFY1BIilUFzGWmbESKNeckIwzjQRw7KcU1mu9xoomnCMwutq/HYX3ne" +
       "tNJtejwKRo4pDE80o6twyIJsVsZSrNst3UJYCzI5hJZmTtdHPHOVJlCjVpcI" +
       "0skoaVkZO+nIUaWB0qgM/IUABfN026K41FLxbEOP9JbXq1rqNh42y6HoM24U" +
       "15vpqiwj66m1NhAwHtMxmI7TqsM3uFacVHyBbzQgF1WWPK8QVSBYYdVYsnW1" +
       "ymFGH8NMaI02e1M/kYdtbRPT6JyQRo6WsY2xwbSzXodmqhjTmzb5tZS1V3U2" +
       "UEOxjfWJ6SC0ZRhZIZC2oNorW0XweafZnTFsnTEaSZNvb2bsZFrRGGQ8tMzt" +
       "2iTYGUGQJivjc7ppzVm3onkxMqvKLRw0Q9oAtQzFWzcKZqbSxmbyBJ2lw8HG" +
       "sblW2bAF0J/q/pjRbXlhm3i/hhBoc+DYyXyVBN0R5gI/zaoqoXYMcUiqqjig" +
       "KgS0Xa9T0aNQyKOnoGeFFTDk8UYwo9Q4JBpnqBmHHslunQHdHCdwVUxpL5iE" +
       "WkKME2jdVmwxHgurBpLgIcaoi7DemymriUqyEmMhKzlGZHO6mC6iVZSKvMSt" +
       "6hOkBht1FKnjjuzZCaf4qGUZWA9rIIMGvBo4m+Zy6aPzZbiy9S495p0q31Ak" +
       "D0PVDYcFfC+qbiZ4dzgXrL5eT2riYD1KmoRAMTw6qLAbC6tSHBYRWpT6jRrR" +
       "EOiapOmsx4tjpjpAFmiq4LBAtk2+hXbFccc3Ma0zqkh1F+NgZTpHeHm7Xuiy" +
       "urZp3TOV8tgzx05gbByqNlvpEdnv9B0zJdxQYFCV7dhVdCIvlCnNUvWuucW4" +
       "FRMqZdFYUSqFNkJnyc2jxqxONT1CC0S8n2E9e1EODUtNFaJp+Cq6XhErt6ts" +
       "3LaRJN7Ewps9Dev6mJIG80pEYDFhY1NvjvLjRbVrN314WwN1iOHTqTAuO06q" +
       "gk6qERgewN6Rt/7CrlbYOSZ0qkzLpvuRJ3YQclAdrmuzbZj1DWYxUVSMa67Q" +
       "EMM3jKBKVX0LMeUtWy+7RjbFOqlUg5cWZCBjNSQI1q0OYq4RyWsPp2KbT+oB" +
       "R5MOW1fq4YJ1wsqQq7ftaLReh2Z3toX6MjwVmK0DLcE0Llup83igNgjE94aN" +
       "UXU5rPWrGkWzNayeWJoEwU6i0tRoFifhsKJ4zNIyhtwKngedMQRtjJmImzwX" +
       "jUTGdJCKL/XQRupFDBg2+4oZmqwIRTBW5lLKYIn+rD5QNyjuLtctKjNXXKdu" +
       "VxJniFNGt1Mfx4YqErEMbVpSo80vwjaikV0rQSvtaeLVpdWC7FLZDHIEvmYM" +
       "SS3bUvFMY/qUTDBDehSCAX975rbq0XqscSy7WrFleqbjgTCZCg0hEztNPmyX" +
       "hUVTjjvdHlFt4BlK0xNvsh41J7gzLXeEjR1WJ9hYRJ2kQo2XOCymawxNKnaa" +
       "VpAFm3VN19i6o1FNtchpxfbbY9uXB67RbuNbI7BacNaWaWIhrPvLRLS0UeZA" +
       "PYyphKwCBjphVpfMQRXLItHGws3GTIBg23EwtKKBIMuTddQedGPRYI2+OkAH" +
       "/mS1JRWr5iRLDV9Cxrw173Xm0rbX7A6FeVjujyHLT1aR5JSn1USy/biC+9HW" +
       "6/vTEdPTzWBeDhW6Do3E3qobdkdUGwsqeBsnm41NaPgTmJt4AyGw5vWJm6Vk" +
       "DVcnZWMrd4ZqtpzZcROycNpKu1rZR/zhKugnAtWtinC9TleJijsUK1KWpYJc" +
       "p7vhEuCIrciPuEa/L3pVPq2kkb/t+VWNRVozS9DnmL5daVJgxIuKJIQeP04Y" +
       "fuRjsejP4zI30Ef1sqLI3a6RdCVnqvADpj5yGrxkj+0a0RtNQp6Y9Cq6kLAj" +
       "TKsM2uv2oulKizbcLdMVYAyl3m0Fqq2W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "cnn6Be2o2KqR938v7tvRi5dtR6f3adyiHe1r4pGzOx7biWkaYcHvty/g/rt5" +
       "8Btx6SHN8oNhcDrtGUv85iuwxKP5xScAqT/fW+LPX0VLnIjo6UcCf3wB6f+W" +
       "By/GpStLWy82wRbJTqj+4SugmitEvt/p8Ot7ql//plDdNaJdf/HVC6j+7zz4" +
       "Sv7IKX9/C1DO6ERMCq5/+kodHFTrbQ/s0u6+XyWup1n8zQX3vp4HfwkEIYnU" +
       "Yq3/aaf9q8uwy+LSXfvnIPm2+sduegPO7q0t2udfeODKoy8M//Ouezl+s8rd" +
       "XOmKmbju6V3Qp87vDELDtAumd+/2RBe6fnhHXHr9RfMYIEv5Vw728PZdkitx" +
       "6dFbJMl3Rxcnp+O/BgwXzsYH9iq+T8e7Py7dcxIPZLU7OR3lwbh0G4iSnz4U" +
       "HGvPqU22u/3j2U6WHjvlNbvH8A+9VHVcT3L6VQ/58KB4adHx895k99qiI+2n" +
       "X+j0vudr9R/fvWpCc9XtNs/lCujJd2+92Pfkp3fCns3tOK87mWf++v6fufst" +
       "x8+3798BPvHgU9ieOP9dDuQyiIu3L2z/zaP/6tv/xQt/UOwy/v9qLD+pTUoA" +
       "AA==");
}
