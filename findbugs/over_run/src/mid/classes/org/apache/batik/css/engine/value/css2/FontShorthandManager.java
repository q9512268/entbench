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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "97zzlxDOvV+LEmNtVyo8fLiSEFV//z2D");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3v/abqyBpi3/Kh3+20H4mxn01KsKZ8fHWOcF/9fxnYNLBDPomnHm78cyfw1s" +
       "dTeZDLoPhOdzfhu46sWcAEX1fy7flasZdP0sH6j08HI+ywOgdJClfL0WnfS+" +
       "zqsbrL9Ks0TVDi5yuIyz3105NwM4dvbKZR57NZc5FTl/6aucNVR3oE9G+Jw9" +
       "PvP9wov09Ee+0fm5w6UzzVOL6hj1IQZ68HD/7XSW8NSlpZ2UdW30zLce+eLD" +
       "T5/MaB45AD7reOewPXn3G14DP8qqO1nFr739n/zAP3zxj6tDy/8HbaOJq5wu" +
       "AAA=");
}
