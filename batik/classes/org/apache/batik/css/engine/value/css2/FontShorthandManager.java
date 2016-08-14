package org.apache.batik.css.engine.value.css2;
public class FontShorthandManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ShorthandManager {
    public FontShorthandManager() { super(); }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    static org.w3c.css.sac.LexicalUnit NORMAL_LU = org.apache.batik.css.parser.CSSLexicalUnit.
      createString(
        org.w3c.css.sac.LexicalUnit.
          SAC_IDENT,
        org.apache.batik.util.CSSConstants.
          CSS_NORMAL_VALUE,
        null);
    static org.w3c.css.sac.LexicalUnit BOLD_LU = org.apache.batik.css.parser.CSSLexicalUnit.
      createString(
        org.w3c.css.sac.LexicalUnit.
          SAC_IDENT,
        org.apache.batik.util.CSSConstants.
          CSS_BOLD_VALUE,
        null);
    static org.w3c.css.sac.LexicalUnit MEDIUM_LU =
      org.apache.batik.css.parser.CSSLexicalUnit.
      createString(
        org.w3c.css.sac.LexicalUnit.
          SAC_IDENT,
        org.apache.batik.util.CSSConstants.
          CSS_MEDIUM_VALUE,
        null);
    static org.w3c.css.sac.LexicalUnit SZ_10PT_LU =
      org.apache.batik.css.parser.CSSLexicalUnit.
      createFloat(
        org.w3c.css.sac.LexicalUnit.
          SAC_POINT,
        10,
        null);
    static org.w3c.css.sac.LexicalUnit SZ_8PT_LU =
      org.apache.batik.css.parser.CSSLexicalUnit.
      createFloat(
        org.w3c.css.sac.LexicalUnit.
          SAC_POINT,
        8,
        null);
    static org.w3c.css.sac.LexicalUnit FONT_FAMILY_LU;
    static { org.w3c.css.sac.LexicalUnit lu;
             FONT_FAMILY_LU = org.apache.batik.css.parser.CSSLexicalUnit.
                                createString(
                                  org.w3c.css.sac.LexicalUnit.
                                    SAC_IDENT,
                                  "Dialog",
                                  null);
             lu = org.apache.batik.css.parser.CSSLexicalUnit.
                    createString(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_IDENT,
                      "Helvetica",
                      FONT_FAMILY_LU);
             org.apache.batik.css.parser.CSSLexicalUnit.
               createString(
                 org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT,
                 org.apache.batik.util.CSSConstants.
                   CSS_SANS_SERIF_VALUE,
                 lu); }
    protected static final java.util.Set values =
      new java.util.HashSet(
      );
    static { values.add(org.apache.batik.util.CSSConstants.
                          CSS_CAPTION_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_ICON_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_MENU_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_MESSAGE_BOX_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_SMALL_CAPTION_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_STATUS_BAR_VALUE); }
    public void handleSystemFont(org.apache.batik.css.engine.CSSEngine eng,
                                 org.apache.batik.css.engine.value.ShorthandManager.PropertyHandler ph,
                                 java.lang.String s,
                                 boolean imp) {
        org.w3c.css.sac.LexicalUnit fontStyle =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit fontVariant =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit fontWeight =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit lineHeight =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit fontFamily =
          FONT_FAMILY_LU;
        org.w3c.css.sac.LexicalUnit fontSize;
        if (s.
              equals(
                org.apache.batik.util.CSSConstants.
                  CSS_SMALL_CAPTION_VALUE)) {
            fontSize =
              SZ_8PT_LU;
        }
        else {
            fontSize =
              SZ_10PT_LU;
        }
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_FAMILY_PROPERTY,
            fontFamily,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_STYLE_PROPERTY,
            fontStyle,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_VARIANT_PROPERTY,
            fontVariant,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_WEIGHT_PROPERTY,
            fontWeight,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_SIZE_PROPERTY,
            fontSize,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_LINE_HEIGHT_PROPERTY,
            lineHeight,
            imp);
    }
    public void setValues(org.apache.batik.css.engine.CSSEngine eng,
                          org.apache.batik.css.engine.value.ShorthandManager.PropertyHandler ph,
                          org.w3c.css.sac.LexicalUnit lu,
                          boolean imp) { switch (lu.
                                                   getLexicalUnitType(
                                                     )) {
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_INHERIT:
                                                 return;
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_IDENT:
                                                 {
                                                     java.lang.String s =
                                                       lu.
                                                       getStringValue(
                                                         ).
                                                       toLowerCase(
                                                         );
                                                     if (values.
                                                           contains(
                                                             s)) {
                                                         handleSystemFont(
                                                           eng,
                                                           ph,
                                                           s,
                                                           imp);
                                                         return;
                                                     }
                                                 }
                                         }
                                         org.w3c.css.sac.LexicalUnit fontStyle =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontVariant =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontWeight =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontSize =
                                           null;
                                         org.w3c.css.sac.LexicalUnit lineHeight =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontFamily =
                                           null;
                                         org.apache.batik.css.engine.value.ValueManager[] vMgrs =
                                           eng.
                                           getValueManagers(
                                             );
                                         int fst;
                                         int fv;
                                         int fw;
                                         int fsz;
                                         int lh;
                                         fst =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_STYLE_PROPERTY);
                                         fv =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_VARIANT_PROPERTY);
                                         fw =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_WEIGHT_PROPERTY);
                                         fsz =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_SIZE_PROPERTY);
                                         lh =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_LINE_HEIGHT_PROPERTY);
                                         org.apache.batik.css.engine.value.IdentifierManager fstVM =
                                           (org.apache.batik.css.engine.value.IdentifierManager)
                                             vMgrs[fst];
                                         org.apache.batik.css.engine.value.IdentifierManager fvVM =
                                           (org.apache.batik.css.engine.value.IdentifierManager)
                                             vMgrs[fv];
                                         org.apache.batik.css.engine.value.IdentifierManager fwVM =
                                           (org.apache.batik.css.engine.value.IdentifierManager)
                                             vMgrs[fw];
                                         org.apache.batik.css.engine.value.css2.FontSizeManager fszVM =
                                           (org.apache.batik.css.engine.value.css2.FontSizeManager)
                                             vMgrs[fsz];
                                         org.apache.batik.css.engine.value.StringMap fstSM =
                                           fstVM.
                                           getIdentifiers(
                                             );
                                         org.apache.batik.css.engine.value.StringMap fvSM =
                                           fvVM.
                                           getIdentifiers(
                                             );
                                         org.apache.batik.css.engine.value.StringMap fwSM =
                                           fwVM.
                                           getIdentifiers(
                                             );
                                         org.apache.batik.css.engine.value.StringMap fszSM =
                                           fszVM.
                                           getIdentifiers(
                                             );
                                         boolean svwDone =
                                           false;
                                         org.w3c.css.sac.LexicalUnit intLU =
                                           null;
                                         while (!svwDone &&
                                                  lu !=
                                                  null) {
                                             switch (lu.
                                                       getLexicalUnitType(
                                                         )) {
                                                 case org.w3c.css.sac.LexicalUnit.
                                                        SAC_IDENT:
                                                     {
                                                         java.lang.String s =
                                                           lu.
                                                           getStringValue(
                                                             ).
                                                           toLowerCase(
                                                             ).
                                                           intern(
                                                             );
                                                         if (fontStyle ==
                                                               null &&
                                                               fstSM.
                                                               get(
                                                                 s) !=
                                                               null) {
                                                             fontStyle =
                                                               lu;
                                                             if (intLU !=
                                                                   null) {
                                                                 if (fontWeight ==
                                                                       null) {
                                                                     fontWeight =
                                                                       intLU;
                                                                     intLU =
                                                                       null;
                                                                 }
                                                                 else {
                                                                     throw createInvalidLexicalUnitDOMException(
                                                                             intLU.
                                                                               getLexicalUnitType(
                                                                                 ));
                                                                 }
                                                             }
                                                             break;
                                                         }
                                                         if (fontVariant ==
                                                               null &&
                                                               fvSM.
                                                               get(
                                                                 s) !=
                                                               null) {
                                                             fontVariant =
                                                               lu;
                                                             if (intLU !=
                                                                   null) {
                                                                 if (fontWeight ==
                                                                       null) {
                                                                     fontWeight =
                                                                       intLU;
                                                                     intLU =
                                                                       null;
                                                                 }
                                                                 else {
                                                                     throw createInvalidLexicalUnitDOMException(
                                                                             intLU.
                                                                               getLexicalUnitType(
                                                                                 ));
                                                                 }
                                                             }
                                                             break;
                                                         }
                                                         if (intLU ==
                                                               null &&
                                                               fontWeight ==
                                                               null &&
                                                               fwSM.
                                                               get(
                                                                 s) !=
                                                               null) {
                                                             fontWeight =
                                                               lu;
                                                             break;
                                                         }
                                                         svwDone =
                                                           true;
                                                         break;
                                                     }
                                                 case org.w3c.css.sac.LexicalUnit.
                                                        SAC_INTEGER:
                                                     if (intLU ==
                                                           null &&
                                                           fontWeight ==
                                                           null) {
                                                         intLU =
                                                           lu;
                                                         break;
                                                     }
                                                     svwDone =
                                                       true;
                                                     break;
                                                 default:
                                                     svwDone =
                                                       true;
                                                     break;
                                             }
                                             if (!svwDone)
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                         }
                                         if (lu ==
                                               null)
                                             throw createMalformedLexicalUnitDOMException(
                                                     );
                                         switch (lu.
                                                   getLexicalUnitType(
                                                     )) {
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_IDENT:
                                                 {
                                                     java.lang.String s =
                                                       lu.
                                                       getStringValue(
                                                         ).
                                                       toLowerCase(
                                                         ).
                                                       intern(
                                                         );
                                                     if (fszSM.
                                                           get(
                                                             s) !=
                                                           null) {
                                                         fontSize =
                                                           lu;
                                                         lu =
                                                           lu.
                                                             getNextLexicalUnit(
                                                               );
                                                     }
                                                 }
                                                 break;
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_EM:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_EX:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_PIXEL:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_CENTIMETER:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_MILLIMETER:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_INCH:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_POINT:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_PICA:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_INTEGER:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_REAL:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_PERCENTAGE:
                                                 fontSize =
                                                   lu;
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                                 break;
                                         }
                                         if (fontSize ==
                                               null) {
                                             if (intLU !=
                                                   null) {
                                                 fontSize =
                                                   intLU;
                                                 intLU =
                                                   null;
                                             }
                                             else {
                                                 throw createInvalidLexicalUnitDOMException(
                                                         lu.
                                                           getLexicalUnitType(
                                                             ));
                                             }
                                         }
                                         if (intLU !=
                                               null) {
                                             if (fontWeight ==
                                                   null) {
                                                 fontWeight =
                                                   intLU;
                                             }
                                             else {
                                                 throw createInvalidLexicalUnitDOMException(
                                                         intLU.
                                                           getLexicalUnitType(
                                                             ));
                                             }
                                         }
                                         if (lu ==
                                               null)
                                             throw createMalformedLexicalUnitDOMException(
                                                     );
                                         switch (lu.
                                                   getLexicalUnitType(
                                                     )) {
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_OPERATOR_SLASH:
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                                 if (lu ==
                                                       null)
                                                     throw createMalformedLexicalUnitDOMException(
                                                             );
                                                 lineHeight =
                                                   lu;
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                                 break;
                                         }
                                         if (lu ==
                                               null)
                                             throw createMalformedLexicalUnitDOMException(
                                                     );
                                         fontFamily =
                                           lu;
                                         if (fontStyle ==
                                               null)
                                             fontStyle =
                                               NORMAL_LU;
                                         if (fontVariant ==
                                               null)
                                             fontVariant =
                                               NORMAL_LU;
                                         if (fontWeight ==
                                               null)
                                             fontWeight =
                                               NORMAL_LU;
                                         if (lineHeight ==
                                               null)
                                             lineHeight =
                                               NORMAL_LU;
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_FAMILY_PROPERTY,
                                             fontFamily,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_STYLE_PROPERTY,
                                             fontStyle,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_VARIANT_PROPERTY,
                                             fontVariant,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_WEIGHT_PROPERTY,
                                             fontWeight,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_SIZE_PROPERTY,
                                             fontSize,
                                             imp);
                                         if (lh !=
                                               -1) {
                                             ph.
                                               property(
                                                 org.apache.batik.util.CSSConstants.
                                                   CSS_LINE_HEIGHT_PROPERTY,
                                                 lineHeight,
                                                 imp);
                                         }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/waPAFoYVLDixbZDVx84mOy9bZWAUUNuEahDS6fu/uPnz4Rvfv2pArWFKqYb" +
       "Z6p0jKoecafkuhvAbDev5bnJ3yvTrnvzwZaR9ZMpAGBf40mu+Pj/IlBiRTBM" +
       "/aI8cfVf5w2sG90+ibv8Ip85/VPe0X3kqYuXyteFeOFSZKV5Bc9cptZcCFeb" +
       "lKVNLRe0p2ex04BQaYJnnY2ddf7g4qLTB7tsIAxiLXKfu6PI2F3YHIKr2gjF" +
       "ygyvJveAQg5y6/mZx4Q9LOq27tG57WRRtfjVCjvaRND/cVbNGTi2jIiEkTi/" +
       "k7NQEGsRKzxQZOwhbH7GyEzFagOPLzG8rDumsgrH0ZgJYYEpY7b3Wx3bLu9t" +
       "ib3l+NWrsbkWT3iRO59vjsiehtd23vL23Xakz6sa5RDTvQe++0V43wFx8kXp" +
       "/vS86rmXR5TvhZPNStdUbBXO0fmXo3sevn3PNY5mt8C1YUjXVSpp/tCA/+7P" +
       "uPC571TBZwk8URsD0cnDJ4i1CER+X2TsODa/gcCk4Ncdbj0HPDjyiGuQp0+B" +
       "QXj2fSZS2VqxyRuEBbD6lC7jgpQ5jmNJsZDX3t/fwd8c6vWTD5Atjhk3Qp8q" +
       "qhd3c5Nynf5cZE/ewOYFcG6jnLV/wmI0hWV0Tv2ojX/8+RUjZWO6knR36cVT" +
       "tUt4R7reNvX+ye/S/gDWwruE/76CzWvYxFyzfVjEbH/D5l1IHiAB5QUdTvWW" +
       "a5v3/he2yYCrLfRJA2txc/O+s4pvg/I9B+sq5xwcfIEnJtnvdzWQYgynVdVb" +
       "LfK8lxsmHVa4ajWidiTSw08ZWfrlvr0AOvCHq/JPwfw5I00nZYY74VjWgIKx" +
       "hNiFogBGuBNS98jYPHDbnFmIh5FSaL2U5YB2PyVIwX+9dFWMVLt0sKh48ZLU" +
       "wOxAgq+1hnOAzz25wdogMJqQM3LoiBrtRKbEk38ST3SYdTIoZVm83wIwiPIv" +
       "9k5ATsfsO9TRg5t6rjhx7m3iW4SsSrt34yxT4dohPotks8SmwNmcuco3Lv9s" +
       "2r1VS5ygN10I7J7R+Z5D0wahz0DszvMV6q2WbL3+pUMXPPrbveXPQrjeQkok" +
       "RmZsyS+UZow0pOdbovnXK8io+ReE1uU/mlh3xvAHL/NSNBHXsQXB9An5+cOX" +
       "P3fd3EONITK1i0yBeE4zvIK7YULro/KYGSe1itWRARFhFkVSc+5u0/CYSZgT" +
       "crvY5qzN9uKXLEaa89OO/O9/1ao+Ts31elrjNRO4/U11e5zbQk6inTYMH4Pb" +
       "46ky/ED4chG+ShPRbsNw7oplaw3ucfYXTlQQ3ov5K741/QeTGkwRzSMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N2Le8aqbrYfbmOovvnT94be/NP+96h7V");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("yY3JR6jaw0bmeWcvMJz5vhLFumFXIjxyuM4QVa//ntbe//puu4GuLV+VDP/t" +
       "UPgbae3p1yycHh2BnS34v47uK1xQMK1d0U/t/ajMXwFd3a1MWnsAhGdzfguY" +
       "6vmcAEX1PpPv0uW0du00H2j08HE2y0OgdpCl/LwSHY++9msrDFeSNJbVg4kc" +
       "LvLsd5fOeABHxl6ZzOOvZTInRc5eGCu9huqO9PEMn3FH58Wff2nC/PDX2z97" +
       "uLCmenJRHcE+TNWuHu7OnXgJT19Y23FdV0bPfvPRLzzyzLFH8+gB8OnAO4Pt" +
       "qbvfDiP8KK3ucxW/+vZ/8v3/4KU/qg48/x9SntrpvC4AAA==");
}
