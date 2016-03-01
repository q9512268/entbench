package org.apache.batik.gvt.font;
public class FontFamilyResolver {
    public static final org.apache.batik.gvt.font.AWTFontFamily defaultFont =
      new org.apache.batik.gvt.font.AWTFontFamily(
      "SansSerif");
    protected static final java.util.Map fonts = new java.util.HashMap();
    protected static final java.util.List awtFontFamilies = new java.util.ArrayList(
      );
    protected static final java.util.List awtFonts = new java.util.ArrayList(
      );
    static { fonts.put("sans-serif", "SansSerif");
             fonts.put("serif", "Serif");
             fonts.put("times", "Serif");
             fonts.put("times new roman", "Serif");
             fonts.put("cursive", "Dialog");
             fonts.put("fantasy", "Symbol");
             fonts.put("monospace", "Monospaced");
             fonts.put("monospaced", "Monospaced");
             fonts.put("courier", "Monospaced");
             java.awt.GraphicsEnvironment env;
             env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment(
                                                  );
             java.lang.String[] fontNames = env.getAvailableFontFamilyNames(
                                                  );
             int nFonts = fontNames != null ? fontNames.length : 0;
             for (int i = 0; i < nFonts; i++) { fonts.put(fontNames[i].
                                                            toLowerCase(
                                                              ),
                                                          fontNames[i]);
                                                java.util.StringTokenizer st =
                                                  new java.util.StringTokenizer(
                                                  fontNames[i]);
                                                java.lang.String fontNameWithoutSpaces =
                                                  "";
                                                while (st.
                                                         hasMoreTokens(
                                                           )) {
                                                    fontNameWithoutSpaces +=
                                                      st.
                                                        nextToken(
                                                          );
                                                }
                                                fonts.put(
                                                        fontNameWithoutSpaces.
                                                          toLowerCase(
                                                            ),
                                                        fontNames[i]);
                                                java.lang.String fontNameWithDashes =
                                                  fontNames[i].
                                                  replace(
                                                    ' ',
                                                    '-');
                                                if (!fontNameWithDashes.
                                                      equals(
                                                        fontNames[i])) {
                                                    fonts.
                                                      put(
                                                        fontNameWithDashes.
                                                          toLowerCase(
                                                            ),
                                                        fontNames[i]);
                                                }
             }
             awtFontFamilies.add(defaultFont);
             awtFonts.add(new org.apache.batik.gvt.font.AWTGVTFont(
                            defaultFont.
                              getFamilyName(
                                ),
                            0,
                            12));
             java.util.Collection fontValues = fonts.
               values(
                 );
             java.util.Iterator iter = fontValues.
               iterator(
                 );
             while (iter.hasNext()) { java.lang.String fontFamily =
                                        (java.lang.String)
                                          iter.
                                          next(
                                            );
                                      org.apache.batik.gvt.font.AWTFontFamily awtFontFamily =
                                        new org.apache.batik.gvt.font.AWTFontFamily(
                                        fontFamily);
                                      awtFontFamilies.
                                        add(
                                          awtFontFamily);
                                      org.apache.batik.gvt.font.AWTGVTFont font =
                                        new org.apache.batik.gvt.font.AWTGVTFont(
                                        fontFamily,
                                        0,
                                        12);
                                      awtFonts.
                                        add(
                                          font);
             } }
    protected static final java.util.Map resolvedFontFamilies =
      new java.util.HashMap(
      );
    public static java.lang.String lookup(java.lang.String familyName) {
        return (java.lang.String)
                 fonts.
                 get(
                   familyName.
                     toLowerCase(
                       ));
    }
    public static org.apache.batik.gvt.font.GVTFontFamily resolve(java.lang.String familyName) {
        familyName =
          familyName.
            toLowerCase(
              );
        org.apache.batik.gvt.font.GVTFontFamily resolvedFF =
          (org.apache.batik.gvt.font.GVTFontFamily)
            resolvedFontFamilies.
            get(
              familyName);
        if (resolvedFF ==
              null) {
            java.lang.String awtFamilyName =
              (java.lang.String)
                fonts.
                get(
                  familyName);
            if (awtFamilyName !=
                  null) {
                resolvedFF =
                  new org.apache.batik.gvt.font.AWTFontFamily(
                    awtFamilyName);
            }
            resolvedFontFamilies.
              put(
                familyName,
                resolvedFF);
        }
        return resolvedFF;
    }
    public static org.apache.batik.gvt.font.GVTFontFamily resolve(org.apache.batik.gvt.font.UnresolvedFontFamily fontFamily) {
        return resolve(
                 fontFamily.
                   getFamilyName(
                     ));
    }
    public static org.apache.batik.gvt.font.GVTFontFamily getFamilyThatCanDisplay(char c) {
        for (int i =
               0;
             i <
               awtFontFamilies.
               size(
                 );
             i++) {
            org.apache.batik.gvt.font.AWTFontFamily fontFamily =
              (org.apache.batik.gvt.font.AWTFontFamily)
                awtFontFamilies.
                get(
                  i);
            org.apache.batik.gvt.font.AWTGVTFont font =
              (org.apache.batik.gvt.font.AWTGVTFont)
                awtFonts.
                get(
                  i);
            if (font.
                  canDisplay(
                    c) &&
                  fontFamily.
                  getFamilyName(
                    ).
                  indexOf(
                    "Song") ==
                  -1) {
                return fontFamily;
            }
        }
        return null;
    }
    public FontFamilyResolver() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "W9ety/KKD7nldZ3t15AAjv8B35Gc9psgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8z0/9dJXy/Oa/wcOnDLVDCsAAA==");
}
