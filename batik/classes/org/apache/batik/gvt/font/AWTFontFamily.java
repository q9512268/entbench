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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
