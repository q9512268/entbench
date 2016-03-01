package org.apache.batik.gvt.font;
public class AWTFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_DELIMITER;
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    protected java.awt.Font font;
    public AWTFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace) {
        super(
          );
        this.
          fontFace =
          fontFace;
    }
    public AWTFontFamily(java.lang.String familyName) { this(new org.apache.batik.gvt.font.GVTFontFace(
                                                               familyName));
    }
    public AWTFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace,
                         java.awt.Font font) { super();
                                               this.fontFace =
                                                 fontFace;
                                               this.font =
                                                 font; }
    public java.lang.String getFamilyName() { return fontFace.
                                                getFamilyName(
                                                  ); }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() {
        return fontFace;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        if (font !=
              null)
            return new org.apache.batik.gvt.font.AWTGVTFont(
              font,
              size);
        return deriveFont(
                 size,
                 aci.
                   getAttributes(
                     ));
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        if (font !=
              null)
            return new org.apache.batik.gvt.font.AWTGVTFont(
              font,
              size);
        java.util.Map fontAttributes =
          new java.util.HashMap(
          attrs);
        fontAttributes.
          put(
            java.awt.font.TextAttribute.
              SIZE,
            new java.lang.Float(
              size));
        fontAttributes.
          put(
            java.awt.font.TextAttribute.
              FAMILY,
            fontFace.
              getFamilyName(
                ));
        fontAttributes.
          remove(
            TEXT_COMPOUND_DELIMITER);
        return new org.apache.batik.gvt.font.AWTGVTFont(
          fontAttributes);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P9LMzzFIKwAA");
}
