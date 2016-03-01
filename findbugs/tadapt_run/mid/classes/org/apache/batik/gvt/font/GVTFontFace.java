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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7krfctt/+K1//tAnf++mwkWicAmISQEuPvN8hTuAy1EDHcwaifdTn9iOuPj2" +
       "zC5zqoWryOcJj17tk4a74To83Sdl4VNZ8OzVI/2sqifEf2HrM3I95q32ztEP" +
       "lQXtPOvjWUBsgWPXxHFb9pH8vwfOH4ZEtt49nBse+d+MNX/lP/2vqxSdT2mn" +
       "jMwT9UX4zS89in/8e3n9w7klq/14cvWUD/YGh3XLv2j/j4tP3/ovLhZuEwuX" +
       "5d3GYyJZUeaxRbDYDvZ3I2Bzciz/+MJ5u0p84WDu/MBJ13Ck25Oz2uGQBPGs" +
       "dBa/dGIiuyeT8pO7Zz9+zGguFPLIZGs3eXglCz60P2/c4fluCFCqSt52LSxc" +
       "0iTbsDb0rv/iod3lBjB9JwMYHoeXrSCf2sF76gx4L54BL4uKB7gixwgDVvXb" +
       "9oF/OYLrpevElYnq6R2up8/ApV4TrmzFN1WNhR6eJi/tXcjrmR2uZ87AZV0L" +
       "rjsyXONwY52qRvs6YWWqu7KDdeUMWMG1wLozgwUM3wBj5jRg4bsA9uwO2LNn" +
       "AEuvGRhYMaihrJ8G7FPXCexR8HxwB+yDZwD79LUAuyWw3O34P2nzr1wnpMfA" +
       "86EdpA+dAemz1wLpNk9y3EAtnSann7lOUO8Hz4d3oD58BqjPXwuoW6VAVrdG" +
       "dVJQr14npg+A57kdpufOwPT6NQlKUc8E9fPXCer53bMfPw3Ul68F1INgw2aY" +
       "arZJihY6e2SbchLiG9cJEdo9+/HTIH7lWiA+dAwipxuy6ahb/3IS41evE2M2" +
       "Fj+yw/iRMzD+/WvBeF/kgHVi9qLlPBG+eZ3wsnH50R28j54B79euBd79B/DO" +
       "Fd8/uE58mY/d2+HbOwPfP74WfJfd9TtL75+8C+XCO3TwGejeuibl7qM7V3i/" +
       "9Y7w8uaSC2CldUt5r76XO8u3TwdwUxb9MPBjQf6yOduIGY5k7SN6eGnJV/Z3" +
       "hBPVD4DIriytepZ90gfXrhkXWJXfc7hhplxn8cLPfvfVb37+me+ApXOvcMs6" +
       "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" +
       "u4N+NCzcEbreRy11rVpHer0btPT82ef2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("g/z26OHh+duv/NdHuY/rn7yOu2hPnMB5ssm/N3jzdzoflP/2xcJNB0fpV91r" +
       "PV7pheMH6Jd8NYx8hzt2jP7YgRLu3xf8izslvHjyzfGhmk9/bfzhrZnkeaff" +
       "o/jv5+T9KAv+W1i4e6GGxPHD90PT+sH1XLzIE/74gOADWeKT4JnvCM5vDMGT" +
       "N0kuFM5meeFilvhjwFKXgkOWp73jvW3uupYqOYfk/+w9kD/Q7q/uyP/qDdfu" +
       "hXvPybsvCy7ttHv8qsABwQt3vleCj4Pn6zuCX7/xBN9/Tt5jWfBQWLhrR/Dw" +
       "zsEhv4ffA7/79vn95o7fb954fh86J++5LHh6q0D++B2UQ4LPvFeC2XWBt3cE" +
       "377xBJFz8rJTrQt7wP8DgtjhcfUhOfi9ksvO+H93R+53bzy5nzonD8uCvxAW" +
       "LgFyLfU0di+8V3bZDYFv7dh968az65+TN8gCIiw8AtiNzzzVP+Taea9cs4sH" +
       "395x/faN5zo9J0/IglFY+ImTXI8f0R6SHb9XstlZ93d3ZL9748nK5+RlDvTC" +
       "i2HhfbnTOe2ewSHPd7z69k48s1Pz7+14fu/G83TPyVtlwTIsPHiU51kKNd8r" +
       "0ezm2p/siP7JjSf6qXPyXs6CdVh4ABBlTrv5cEgzvhF2+6c7mn9642l+5py8" +
       "n8mCV7Z2y5x6heKQ51+/rrvEYeHOI5/VZN8IPHLVV3zbL8/kX37j3tsffoP/" +
       "t/mXJQdfh91BFW7XIss6erP2SPxWz1c1Iyd/x/aerZczehV4nDO/9AkLN2c/" +
       "GdoLn9+W/zlA/rTyYeEmEB4t+Xp2CeZEybBwS/57tNwvgNnrsFx20S2PHC3y" +
       "JdA6KJJFv+zlsjv+JcT2KnKy3UI+ctR08vX1/e+kiYMqRz9RyTaD+feW+xu3" +
       "aPvF5Uvy197o0Z/6Ye2r209kZEtK06yV26nCbduvdfJGs83fU2e2tt/WreRz" +
       "P77nV+54dn+jes8W8KEZH8H2xOnfo7RtL8y/IEm//vA//Mm/88Yf5JdW/h8P" +
       "dfLCCDsAAA==");
}
