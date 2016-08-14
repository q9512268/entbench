package org.apache.batik.gvt.font;
public class GVTFontFace implements org.apache.batik.util.SVGConstants {
    protected java.lang.String familyName;
    protected float unitsPerEm;
    protected java.lang.String fontWeight;
    protected java.lang.String fontStyle;
    protected java.lang.String fontVariant;
    protected java.lang.String fontStretch;
    protected float slope;
    protected java.lang.String panose1;
    protected float ascent;
    protected float descent;
    protected float strikethroughPosition;
    protected float strikethroughThickness;
    protected float underlinePosition;
    protected float underlineThickness;
    protected float overlinePosition;
    protected float overlineThickness;
    public GVTFontFace(java.lang.String familyName, float unitsPerEm, java.lang.String fontWeight,
                       java.lang.String fontStyle,
                       java.lang.String fontVariant,
                       java.lang.String fontStretch,
                       float slope,
                       java.lang.String panose1,
                       float ascent,
                       float descent,
                       float strikethroughPosition,
                       float strikethroughThickness,
                       float underlinePosition,
                       float underlineThickness,
                       float overlinePosition,
                       float overlineThickness) { super();
                                                  this.familyName =
                                                    familyName;
                                                  this.unitsPerEm =
                                                    unitsPerEm;
                                                  this.fontWeight =
                                                    fontWeight;
                                                  this.fontStyle =
                                                    fontStyle;
                                                  this.fontVariant =
                                                    fontVariant;
                                                  this.fontStretch =
                                                    fontStretch;
                                                  this.slope = slope;
                                                  this.panose1 = panose1;
                                                  this.ascent = ascent;
                                                  this.descent = descent;
                                                  this.strikethroughPosition =
                                                    strikethroughPosition;
                                                  this.strikethroughThickness =
                                                    strikethroughThickness;
                                                  this.underlinePosition =
                                                    underlinePosition;
                                                  this.underlineThickness =
                                                    underlineThickness;
                                                  this.overlinePosition =
                                                    overlinePosition;
                                                  this.overlineThickness =
                                                    overlineThickness;
    }
    public GVTFontFace(java.lang.String familyName) { this(familyName,
                                                           1000,
                                                           SVG_FONT_FACE_FONT_WEIGHT_DEFAULT_VALUE,
                                                           SVG_FONT_FACE_FONT_STYLE_DEFAULT_VALUE,
                                                           SVG_FONT_FACE_FONT_VARIANT_DEFAULT_VALUE,
                                                           SVG_FONT_FACE_FONT_STRETCH_DEFAULT_VALUE,
                                                           0,
                                                           SVG_FONT_FACE_PANOSE_1_DEFAULT_VALUE,
                                                           800,
                                                           200,
                                                           300,
                                                           50,
                                                           -75,
                                                           50,
                                                           800,
                                                           50);
    }
    public java.lang.String getFamilyName() {
        return familyName;
    }
    public boolean hasFamilyName(java.lang.String family) {
        java.lang.String ffname =
          familyName;
        if (ffname.
              length(
                ) <
              family.
              length(
                )) {
            return false;
        }
        ffname =
          ffname.
            toLowerCase(
              );
        int idx =
          ffname.
          indexOf(
            family.
              toLowerCase(
                ));
        if (idx ==
              -1) {
            return false;
        }
        if (ffname.
              length(
                ) >
              family.
              length(
                )) {
            boolean quote =
              false;
            if (idx >
                  0) {
                char c =
                  ffname.
                  charAt(
                    idx -
                      1);
                switch (c) {
                    default:
                        return false;
                    case ' ':
                        loop: for (int i =
                                     idx -
                                     2;
                                   i >=
                                     0;
                                   --i) {
                            switch (ffname.
                                      charAt(
                                        i)) {
                                default:
                                    return false;
                                case ' ':
                                    continue;
                                case '\"':
                                case '\'':
                                    quote =
                                      true;
                                    break loop;
                            }
                        }
                        break;
                    case '\"':
                    case '\'':
                        quote =
                          true;
                    case ',':
                }
            }
            if (idx +
                  family.
                  length(
                    ) <
                  ffname.
                  length(
                    )) {
                char c =
                  ffname.
                  charAt(
                    idx +
                      family.
                      length(
                        ));
                switch (c) {
                    default:
                        return false;
                    case ' ':
                        loop: for (int i =
                                     idx +
                                     family.
                                     length(
                                       ) +
                                     1;
                                   i <
                                     ffname.
                                     length(
                                       );
                                   i++) {
                            switch (ffname.
                                      charAt(
                                        i)) {
                                default:
                                    return false;
                                case ' ':
                                    continue;
                                case '\"':
                                case '\'':
                                    if (!quote) {
                                        return false;
                                    }
                                    break loop;
                            }
                        }
                        break;
                    case '\"':
                    case '\'':
                        if (!quote) {
                            return false;
                        }
                    case ',':
                }
            }
        }
        return true;
    }
    public java.lang.String getFontWeight() {
        return fontWeight;
    }
    public java.lang.String getFontStyle() {
        return fontStyle;
    }
    public float getUnitsPerEm() { return unitsPerEm;
    }
    public float getAscent() { return ascent;
    }
    public float getDescent() { return descent;
    }
    public float getStrikethroughPosition() {
        return strikethroughPosition;
    }
    public float getStrikethroughThickness() {
        return strikethroughThickness;
    }
    public float getUnderlinePosition() {
        return underlinePosition;
    }
    public float getUnderlineThickness() {
        return underlineThickness;
    }
    public float getOverlinePosition() { return overlinePosition;
    }
    public float getOverlineThickness() {
        return overlineThickness;
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
      ("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" +
       "88gb+At5/sG48PRVgWt5jAPHdw8iabOQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("icfOCrHMI0y+9Mprr6v0l0sXd4ECjbhwR+wHH3a0peYcGfVu0NPzZ7/3H+QR" +
       "pocv39965b89Ov6I+dHriGV74gTOk13+/cEbv9t9v/JzFws3HbyKvyr29Xij" +
       "F46/gL8UanESeuNjr+EfO1DC/fuCf3GnhBdPPnk+VPPpj50/uDWTvOz0OIz/" +
       "cU7ZD7Pkv8eFuw0txo+/vD80re9fT+BGfuNPDgg+kN18ElzyjqB8YwiejES5" +
       "UDib5YWL2c0fAZamFB2yPO0Z8W2y7zua5B2S/4t3Qf5Au1/dkf/qDdfuhcvn" +
       "lN2XJZd22j0eanBA8MKd75bg4+D62o7g1248wfeeU/ZYljwUF+7aETyMWTjk" +
       "9/C74HffPr/f2vH7rRvP7wPnlD2XJU9vFTg5HsNySPCZd0swCzd4a0fwrRtP" +
       "EDmnLHsrdmEP+H9AsHn4uvuQHPRuyWUxAr+3I/d7N57cT55Tli32F/5KXLgE" +
       "yLW109i98G7ZZREG39yx++aNZ0eeUzbIEjwuPALYcWdGBRxy7b5brlngwrd2" +
       "XL9147kK55TNsoSNCz92kuvxV7yHZLl3SzZ7V/6dHdnv3HiyyjllmQO98GJc" +
       "eE/udE6LUzjk+bahc2/HM3vr/t0dz+/eeJ7+OWWLLJnHhQeP8jxLofa7JZpF" +
       "vv3pjuif3niiHzun7OUsWcaFBwBR+rTIiUOaqxtht3++o/nnN57mJ84p+1SW" +
       "vLK1W/rUEIxDnn/rumKR48KdRz7Lyb4xeOSqL/22X6cpv/r65dsffn3y7/Iv" +
       "Uw6+ILuDKtyuJ45zNDL3SP7WINR0Kyd/xzZON8gZvQo8zplfCsWFm7OfDO2F" +
       "z2zr/zwgf1r9uHATSI/W/FwWRHOiZly4Jf89Wu8Xwep1WC8LlMszR6t8AfQO" +
       "qmTZLwa57I5/SbENZV5vj5CPHDWdfH99/9tp4qDJ0U9cssNg/k3m/sEt2X6V" +
       "+ZLyldeJ4cd+gH55+4mN4khpmvVyO1W4bfu1T95pdvh76sze9vu6tffcj+75" +
       "tTue3T+o3rMFfGjGR7A9cfr3LB03iPMvUNKvPfyPfvyXXv/DPOjl/wGuu9MF" +
       "LDsAAA==");
}
