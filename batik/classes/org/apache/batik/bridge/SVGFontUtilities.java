package org.apache.batik.bridge;
public abstract class SVGFontUtilities implements org.apache.batik.util.SVGConstants {
    public static java.util.List getFontFaces(org.w3c.dom.Document doc, org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map fontFamilyMap =
          ctx.
          getFontFamilyMap(
            );
        java.util.List ret =
          (java.util.List)
            fontFamilyMap.
            get(
              doc);
        if (ret !=
              null)
            return ret;
        ret =
          new java.util.LinkedList(
            );
        org.w3c.dom.NodeList fontFaceElements =
          doc.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_FONT_FACE_TAG);
        org.apache.batik.bridge.SVGFontFaceElementBridge fontFaceBridge;
        fontFaceBridge =
          (org.apache.batik.bridge.SVGFontFaceElementBridge)
            ctx.
            getBridge(
              SVG_NAMESPACE_URI,
              SVG_FONT_FACE_TAG);
        for (int i =
               0;
             i <
               fontFaceElements.
               getLength(
                 );
             i++) {
            org.w3c.dom.Element fontFaceElement =
              (org.w3c.dom.Element)
                fontFaceElements.
                item(
                  i);
            ret.
              add(
                fontFaceBridge.
                  createFontFace(
                    ctx,
                    fontFaceElement));
        }
        org.apache.batik.css.engine.CSSEngine engine =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             doc).
          getCSSEngine(
            );
        java.util.List sms =
          engine.
          getFontFaces(
            );
        java.util.Iterator iter =
          sms.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.css.engine.FontFaceRule ffr =
              (org.apache.batik.css.engine.FontFaceRule)
                iter.
                next(
                  );
            ret.
              add(
                org.apache.batik.bridge.CSSFontFace.
                  createCSSFontFace(
                    engine,
                    ffr));
        }
        return ret;
    }
    public static org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.w3c.dom.Element textElement,
                                                                        org.apache.batik.bridge.BridgeContext ctx,
                                                                        java.lang.String fontFamilyName,
                                                                        java.lang.String fontWeight,
                                                                        java.lang.String fontStyle) {
        java.lang.String fontKeyName =
          fontFamilyName.
          toLowerCase(
            ) +
        " " +
        fontWeight +
        " " +
        fontStyle;
        java.util.Map fontFamilyMap =
          ctx.
          getFontFamilyMap(
            );
        org.apache.batik.gvt.font.GVTFontFamily fontFamily =
          (org.apache.batik.gvt.font.GVTFontFamily)
            fontFamilyMap.
            get(
              fontKeyName);
        if (fontFamily !=
              null) {
            return fontFamily;
        }
        org.w3c.dom.Document doc =
          textElement.
          getOwnerDocument(
            );
        java.util.List fontFaces =
          (java.util.List)
            fontFamilyMap.
            get(
              doc);
        if (fontFaces ==
              null) {
            fontFaces =
              getFontFaces(
                doc,
                ctx);
            fontFamilyMap.
              put(
                doc,
                fontFaces);
        }
        java.util.Iterator iter =
          fontFaces.
          iterator(
            );
        java.util.List svgFontFamilies =
          new java.util.LinkedList(
          );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.bridge.FontFace fontFace =
              (org.apache.batik.bridge.FontFace)
                iter.
                next(
                  );
            if (!fontFace.
                  hasFamilyName(
                    fontFamilyName)) {
                continue;
            }
            java.lang.String fontFaceStyle =
              fontFace.
              getFontStyle(
                );
            if (fontFaceStyle.
                  equals(
                    SVG_ALL_VALUE) ||
                  fontFaceStyle.
                  indexOf(
                    fontStyle) !=
                  -1) {
                org.apache.batik.gvt.font.GVTFontFamily ffam =
                  fontFace.
                  getFontFamily(
                    ctx);
                if (ffam !=
                      null)
                    svgFontFamilies.
                      add(
                        ffam);
            }
        }
        if (svgFontFamilies.
              size(
                ) ==
              1) {
            fontFamilyMap.
              put(
                fontKeyName,
                svgFontFamilies.
                  get(
                    0));
            return (org.apache.batik.gvt.font.GVTFontFamily)
                     svgFontFamilies.
                     get(
                       0);
        }
        else
            if (svgFontFamilies.
                  size(
                    ) >
                  1) {
                java.lang.String fontWeightNumber =
                  getFontWeightNumberString(
                    fontWeight);
                java.util.List fontFamilyWeights =
                  new java.util.ArrayList(
                  svgFontFamilies.
                    size(
                      ));
                java.util.Iterator ffiter =
                  svgFontFamilies.
                  iterator(
                    );
                while (ffiter.
                         hasNext(
                           )) {
                    org.apache.batik.gvt.font.GVTFontFace fontFace;
                    fontFace =
                      ((org.apache.batik.gvt.font.GVTFontFamily)
                         ffiter.
                         next(
                           )).
                        getFontFace(
                          );
                    java.lang.String fontFaceWeight =
                      fontFace.
                      getFontWeight(
                        );
                    fontFaceWeight =
                      getFontWeightNumberString(
                        fontFaceWeight);
                    fontFamilyWeights.
                      add(
                        fontFaceWeight);
                }
                java.util.List newFontFamilyWeights =
                  new java.util.ArrayList(
                  fontFamilyWeights);
                for (int i =
                       100;
                     i <=
                       900;
                     i +=
                       100) {
                    java.lang.String weightString =
                      java.lang.String.
                      valueOf(
                        i);
                    boolean matched =
                      false;
                    int minDifference =
                      1000;
                    int minDifferenceIndex =
                      0;
                    for (int j =
                           0;
                         j <
                           fontFamilyWeights.
                           size(
                             );
                         j++) {
                        java.lang.String fontFamilyWeight =
                          (java.lang.String)
                            fontFamilyWeights.
                            get(
                              j);
                        if (fontFamilyWeight.
                              indexOf(
                                weightString) >
                              -1) {
                            matched =
                              true;
                            break;
                        }
                        java.util.StringTokenizer st =
                          new java.util.StringTokenizer(
                          fontFamilyWeight,
                          " ,");
                        while (st.
                                 hasMoreTokens(
                                   )) {
                            int weightNum =
                              java.lang.Integer.
                              parseInt(
                                st.
                                  nextToken(
                                    ));
                            int difference =
                              java.lang.Math.
                              abs(
                                weightNum -
                                  i);
                            if (difference <
                                  minDifference) {
                                minDifference =
                                  difference;
                                minDifferenceIndex =
                                  j;
                            }
                        }
                    }
                    if (!matched) {
                        java.lang.String newFontFamilyWeight =
                          newFontFamilyWeights.
                          get(
                            minDifferenceIndex) +
                        ", " +
                        weightString;
                        newFontFamilyWeights.
                          set(
                            minDifferenceIndex,
                            newFontFamilyWeight);
                    }
                }
                for (int i =
                       0;
                     i <
                       svgFontFamilies.
                       size(
                         );
                     i++) {
                    java.lang.String fontFaceWeight =
                      (java.lang.String)
                        newFontFamilyWeights.
                        get(
                          i);
                    if (fontFaceWeight.
                          indexOf(
                            fontWeightNumber) >
                          -1) {
                        fontFamilyMap.
                          put(
                            fontKeyName,
                            svgFontFamilies.
                              get(
                                i));
                        return (org.apache.batik.gvt.font.GVTFontFamily)
                                 svgFontFamilies.
                                 get(
                                   i);
                    }
                }
                fontFamilyMap.
                  put(
                    fontKeyName,
                    svgFontFamilies.
                      get(
                        0));
                return (org.apache.batik.gvt.font.GVTFontFamily)
                         svgFontFamilies.
                         get(
                           0);
            }
            else {
                org.apache.batik.gvt.font.GVTFontFamily gvtFontFamily =
                  new org.apache.batik.gvt.font.UnresolvedFontFamily(
                  fontFamilyName);
                fontFamilyMap.
                  put(
                    fontKeyName,
                    gvtFontFamily);
                return gvtFontFamily;
            }
    }
    protected static java.lang.String getFontWeightNumberString(java.lang.String fontWeight) {
        if (fontWeight.
              equals(
                SVG_NORMAL_VALUE)) {
            return SVG_400_VALUE;
        }
        else
            if (fontWeight.
                  equals(
                    SVG_BOLD_VALUE)) {
                return SVG_700_VALUE;
            }
            else
                if (fontWeight.
                      equals(
                        SVG_ALL_VALUE)) {
                    return "100, 200, 300, 400, 500, 600, 700, 800, 900";
                }
        return fontWeight;
    }
    public SVGFontUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwUxxWfO2NjG3+cjT+AgAFjoHzdBSW0oSYk2NhgejYu" +
       "Nm5rA8fc3tzd4r3dZXfOPpumJYna0D9KEYVAK+FKFRRoaYiqRm3aELmKlA8l" +
       "rUSKmqZRaKT0j6QtSVDU9A/69WZm93Zv786ItljaufXMmzfz3vvN773ZSzdQ" +
       "qWmgFqLSIJ3QiRnsUmk/NkwS61SwaQ5CX0Q6VYI/3vde30Y/KhtGNUls9krY" +
       "JN0yUWLmMFokqybFqkTMPkJibEa/QUxijGEqa+owapTNnpSuyJJMe7UYYQJD" +
       "2AijOkypIUfTlPRYCihaFIadhPhOQlu8w+1hVCVp+oQjPs8l3ukaYZIpZy2T" +
       "okD4AB7DoTSVlVBYNml7xkBrdE2ZSCgaDZIMDR5QNlgu2BHekOeC1qdrP7l1" +
       "LBngLpiLVVWj3DxzFzE1ZYzEwqjW6e1SSMo8iL6CSsJojkuYorawvWgIFg3B" +
       "ora1jhTsvpqo6VSnxs2htqYyXWIbomhprhIdGzhlqennewYN5dSynU8Ga5dk" +
       "rRVW5pl4ck3oxKl9gZ+UoNphVCurA2w7EmyCwiLD4FCSihLD3BKLkdgwqlMh" +
       "2APEkLEiT1qRrjflhIppGsJvu4V1pnVi8DUdX0EcwTYjLVHNyJoX54Cy/iuN" +
       "KzgBtjY5tgoLu1k/GFgpw8aMOAbcWVNmjcpqjKLF3hlZG9s+BwIwdXaK0KSW" +
       "XWqWiqED1QuIKFhNhAYAemoCREs1AKBB0YKiSpmvdSyN4gSJMER65PrFEEhV" +
       "cEewKRQ1esW4JojSAk+UXPG50bfp6CF1u+pHPthzjEgK2/8cmNTimbSLxIlB" +
       "4ByIiVWrw0/ipitH/AiBcKNHWMj87Ms3H17bMv2ykLmngMzO6AEi0Yh0Nlpz" +
       "dWHnqo0lbBvlumbKLPg5lvNT1m+NtGd0YJimrEY2GLQHp3e9+KXDPyR/8aPK" +
       "HlQmaUo6BTiqk7SULivE2EZUYmBKYj2ogqixTj7eg2bDe1hWiejdGY+bhPag" +
       "WQrvKtP4/+CiOKhgLqqEd1mNa/a7jmmSv2d0hFAAHrQZnhASf/yXopFQUkuR" +
       "EJawKqtaqN/QmP1mCBgnCr5NhqKA+tGQqaUNgGBIMxIhDDhIEmsgasixBAkN" +
       "DG3rBvfsBqvBYvAlA5l+d9VnmHVzx30+cPxC77FX4MRs15QYMSLSiXRH182n" +
       "Iq8KSLFjYPmFok/BikGxYpCvGBQrBr0rIp+PL9TAVhbRhdiMwikHmq1aNbB3" +
       "x/4jrSUAK318FjiWibbmpJtOhwps/o5Il+urJ5deX/+CH80Ko3os0TRWWPbY" +
       "YiSAl6RR6+hWRSEROflgiSsfsERmaBKJAR0VywuWlnJtjBisn6IGlwY7W7Fz" +
       "GSqeKwruH02fHn906Kv3+pE/NwWwJUuBvdj0fkbcWYJu8x79Qnprn3jvk8tP" +
       "PqI5JJCTU+xUmDeT2dDqhYLXPRFp9RL8TOTKI23c7RVA0hTDoQL+a/GukcMx" +
       "7TZfM1vKweC4ZqSwwoZsH1fSpKGNOz0co3WsaRRwZRDybJBT/YMD+pnf/+b9" +
       "+7gn7axQ60rnA4S2u5iIKavnnFPnIHLQIATk3j7d/+2TN54Y4XAEiWWFFmxj" +
       "bScwEEQHPPi1lw+++cfrZ6/5HQhTSMXpKFQ0GW5Lw7/hzwfPv9jD2IN1CBap" +
       "77SobEmWy3S28gpnb8BqChx9Bo623SrAUI7LOKoQdn7+Ubt8/TN/PRoQ4Vag" +
       "x0bL2tsrcPrnd6DDr+77ewtX45NYVnX854gJqp7raN5iGHiC7SPz6OuLvvMS" +
       "PgOkD0RrypOEcyfi/kA8gBu4L+7l7f2esc+wZrnpxnjuMXJVPxHp2LWPqoc+" +
       "ev4m321u+eSOey/W2wWKRBRgsYeQ1eRwORtt0lnbnIE9NHuJajs2k6Ds/um+" +
       "PQFl+hYsOwzLSkC75k4DeDKTAyVLunT2H371QtP+qyXI340qFQ3HujE/cKgC" +
       "kE7MJFBsRn/oYbGP8XI702RQnofyOlgUFheOb1dKpzwikz9v/umm81PXOSx1" +
       "oeMet8IVvF3FmrW8389e11FUjqPADrDZTNZv/K92Br+51Pv4+zyKWvMyBN8t" +
       "5Ids4crcvahYRcOrsbOPnZiK7Ty3XtQd9blVQhcUwT/+3T9fC55+55UCKaqC" +
       "avo6hYwRxbW9ErZkTn7p5cWew3Fv1xx/99m2RMedpBbW13Kb5MH+XwxGrC6e" +
       "KrxbeemxPy8Y3JzcfwdZYrHHnV6VF3svvbJthXTczytbkSDyKuLcSe1ux8Ki" +
       "BoESXmVmsp5qfsaWZbHSzKCxDJ71FlbWe8+YoPMZMVhm8suFg0AO3LoZtHrY" +
       "xS/U2VhsYFgcv08KxrRUcKsmpVPEujfB4PJipUwH/7FuOHzbIzOQGGbNIEVV" +
       "CUJZBdTNrh65aGMwGkjD8dqFxznOI9KelYGmto0ftwqAtxSQdZX4R3/5i+Hh" +
       "lQFJCLcWUpxb2l84Xy69lXrxT2LC/AIThFzjhdA3h9448BoHWjlDdja8LlTD" +
       "CXAl50A2ODXMB/XwXLSCc1Ektz3/Yw0L0+DeKqfgqhUalFMkxu7NzAarRr6r" +
       "+nkqyCEKJ2g/GlW2fPjADx4Ubl1a5EA78s9+/p2rZyYvXxIkxdxL0ZpiN/38" +
       "zwusOFs+Q4HpAORv2z47/f67Q3v9FiZrWJPM2Eivcac2USvoWSz7svV3Qy5O" +
       "hOqt36h97lh9STfQYg8qT6vywTTpieVSw2wzHXUBx7nROkQRYE0wwyoginyr" +
       "7dT0AGt2i/dN/2VWZB0dwp7+LDaXsLF18CQsbCbumI5Y88UCVFRMo4cjSrmq" +
       "UjsGc91UZAGODe2zBQI8SOwzQ1B8ZmD9j/OG7/XwDBz0ddZMUlSd5aCUrEzY" +
       "mlfmEV1ijAbjIBfcNjTokecROXQXIrKQjW2A5wPLfx/cSUQgreuGRuGck1ih" +
       "wDTMoNjjOAvwjmdPzuDZU6w5StF8y7NfIHIiSfvS7JuXK0yO6771/3BdBuDg" +
       "vVCz6m9e3sc68YFJemqqtrx5avcbvHjJfgSqAlKPpxXFdVTdx7ZMN0hc5mZW" +
       "iYpZ5z/fo6i5SG6EFC1e+M6nhPz3YbdeeYpK+a9b7hxFlY4cqBIvbpELFJWA" +
       "CHu9qBc4GeJrU8aXX9dy5zfezvnZKe5LHmNW/rHUJr90v0Xgl6d29B26+elz" +
       "4pIpKXhykmmZA5QnrrLZ+mtpUW22rrLtq27VPF2x3ObonEuue28cAgBQfiFc" +
       "4Ll1mW3Zy9ebZzc9/+sjZa9DdhlBPgwUM+L6VCk8BVe3NJQiI+F8aodalV8H" +
       "21d9d2Lz2viHb/Erg5UKFhaXj0jXzu/97fF5Z+HaOKcHlUK1TjLDqFI2t06o" +
       "u4g0ZgyjatnsysAWQYuMlZy8UcPAidnB4X6x3Fmd7WVfH+ASkfe9tMA3G7he" +
       "jROjQ0urMSvzzHF6cr7iWoCvTOu6Z4LT4ypxTJGsRDVTEgn36rp9dS9DOj+j" +
       "tBCdiGLxOf7Kmiv/AeW6ljdIGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6e+zrZnW+v/be3l7a3tsW2tKVPm+BYvg5sZM42WWAncR5" +
       "2EmcOInj8Lj4FT/iV/xOWDdg2ihDY2wrrEhQ7Q8YGyoUJtA2TUydpg0QaBIT" +
       "2ksaoG3SYAxE/4ChsY19dn7v+0AVWyR/+fL5fOc7bx+fk2e+A50OfAj2XGut" +
       "WW64q6bhrmmVd8O1pwa7XabMin6gKnVLDIIxWLssP/yp8z/40fv0CzvQmTl0" +
       "p+g4biiGhusEIzVwrVhVGOj84WrTUu0ghC4wphiLSBQaFsIYQXiJgV50ZGsI" +
       "XWT2SUAACQggAclJQIhDKLDpVtWJ7Hq2Q3TCYAX9AnSKgc54ckZeCD10HIkn" +
       "+qK9h4bNOQAYzma/p4CpfHPqQw8e8L7l+QqG3w8jT/72Wy78wQ3Q+Tl03nC4" +
       "jBwZEBGCQ+bQLbZqS6ofEIqiKnPodkdVFU71DdEyNjndc+iOwNAcMYx89UBI" +
       "2WLkqX5+5qHkbpEz3vxIDl3/gL2FoVrK/q/TC0vUAK93HfK65ZDK1gGD5wxA" +
       "mL8QZXV/y41Lw1FC6IGTOw54vEgDALD1JlsNdffgqBsdESxAd2x1Z4mOhnCh" +
       "bzgaAD3tRuCUELr3mkgzWXuivBQ19XII3XMSjt3eAlA354LItoTQS06C5ZiA" +
       "lu49oaUj+vlO/7XvfZvTdnZymhVVtjL6z4JN95/YNFIXqq86srrdeMurmA+I" +
       "d33uiR0IAsAvOQG8hfnDn3/+Da++/7kvbGF+5iowA8lU5fCy/BHptq/cV3+s" +
       "dkNGxlnPDYxM+cc4z82f3btzKfWA5911gDG7ubt/87nRXwpv/7j67R3oXAc6" +
       "I7tWZAM7ul12bc+wVL+lOqovhqrSgW5WHaWe3+9AN4E5YzjqdnWwWARq2IFu" +
       "tPKlM27+G4hoAVBkIroJzA1n4e7PPTHU83nqQRB0AVzQ68CFQNtP/h1Cb0R0" +
       "11YRURYdw3ER1ncz/gNEdUIJyFZHJGD1SyRwIx+YIOL6GiICO9DVvRuSbyia" +
       "inDTFgXEMwFcA46BLDMj8/5/0acZdxeSU6eA4O876fYW8Ji2aymqf1l+MiKb" +
       "z3/y8pd2DtxgTy4h9Epw4u72xN38xN3tibsnT4ROncoPenF28la7QDdL4OUg" +
       "/t3yGPfm7lufePgGYFZeciMQbAaKXDsM1w/jQiePfjIwTui5p5J3TH+xsAPt" +
       "HI+nGbVg6Vy2nc2i4EG0u3jSj66G9/y7vvmDZz/wuHvoUccC9J6jX7kzc9SH" +
       "T8rVd2VVAaHvEP2rHhQ/e/lzj1/cgW4E3g8iXigCCwXB5P6TZxxz2Ev7wS/j" +
       "5TRgeOH6tmhlt/Yj1rlQ993kcCVX+G35/HYg49dDe8Mxk87u3ull44u3BpIp" +
       "7QQXeXD9Oc778N/91bewXNz7cfj8kScbp4aXjvh+hux87uW3H9rA2FdVAPeP" +
       "T7G/9f7vvOuNuQEAiEeuduDFbKwDnwcqBGL+5S+s/v7rX/vIV3cOjSYED79I" +
       "sgw53TL5Y/A5Ba7/ya6MuWxh67d31PeCx4MH0cPLTn75IW0gjljA2TILujhx" +
       "bFcxFoYoWWpmsf91/tHiZ//9vRe2NmGBlX2TevVPRnC4/lISevuX3vIf9+do" +
       "TsnZc+xQfodg2+B45yFmwvfFdUZH+o6/ftkHPy9+GIRZENoCY6Pm0QrK5QHl" +
       "CizksoDzETlxD82GB4KjjnDc147kG5fl9331e7dOv/enz+fUHk9Yjuq9J3qX" +
       "tqaWDQ+mAP3dJ72+LQY6gCs913/TBeu5HwGMc4BRBjEsGPgg6KTHrGQP+vRN" +
       "//Bnf37XW79yA7RDQecsV1QoMXc46GZg6Wqgg3iVeq9/w9aak7P7YTuFrmB+" +
       "ayD35L9uAAQ+du1YQ2X5xqG73vOfA0t65z/98Aoh5FHmKo/ZE/vnyDMfurf+" +
       "um/n+w/dPdt9f3plIAa52eFe9OP293cePvMXO9BNc+iCvJf4TUUrypxoDpKd" +
       "YD8bBMnhsfvHE5ftU/rSQTi772SoOXLsyUBz+AAA8ww6m587VPhj6SngiKfR" +
       "XXy3kP1+Q77xoXy8mA2v2Eo9m74SeGyQJ5Bgx8JwRCvH81gILMaSL+776BQk" +
       "lEDEF00Lz9G8BKTQuXVkzOxus7BtrMpGbEtFPq9c0xou7dMKtH/bITLGBQnd" +
       "e/7lfV/+9Ue+DlTUhU7HmfiAZo6c2I+yHPdXnnn/y1705DfekwcgEH2m7/40" +
       "9sMMK309jrOhkQ3NfVbvzVjl8ic4IwZhL48TqpJze13LZH3DBqE13kvgkMfv" +
       "+PryQ9/8xDY5O2mGJ4DVJ5781R/vvvfJnSMp8SNXZKVH92zT4pzoW/ck7EMP" +
       "Xe+UfAf1r88+/ie/9/i7tlTdcTzBa4L3l0/8zX9/efepb3zxKtnFjZb7Uyg2" +
       "vPUz7VLQIfY/zFRY8MkkTfnFAO2bLQyWzTFMaARluu2NQnJ8weWEJdrXNdUU" +
       "or5d9onqQsbCjVLyMWU+WwxYL7K7giMWGjW6KUwJGqZoajRyRcFYjWxMbDI2" +
       "bRFVy59wtL2aj0R6XDArw5CbNiY1AqnU+Lldw+YxXq10QssUo8WsZ28WGyyO" +
       "+ziOzbmNMlzxtkatGK7TxYbGyAkm9hLpLxOuUuQScViuzwrDylToIFisqFhB" +
       "QGg9bPUnVlBb+kK3X1hPeMbuUe5ytZao1XLcY5ddQ2qKyHCSGmaruRJhNxG9" +
       "cd/xuGjd7fZUfCIIw24DJQxzsFx7nclibLEjoW7oItURFZ3VB0MrqiZwUZ/W" +
       "px7sDk02qFpYtBSFecebr9Gxu2yUCBJvuGNuak1JoW9beLokfaWJzrm6Jjbm" +
       "nV5jVB72LS1Cyba6HKj14krxWdwqMqSjMZ7BTKe8iTXSDbVpFufCppmsTL6i" +
       "Fjmu51YNplLngq5rLiPB9cUk5rUOpWEkmBdNfRzE3sqtTDknDVA9XAnrGd+R" +
       "XFv3fL2jtDa6tVIdR02Eflnh1s6k2hLLytIfTfmyZ5XkJeamtFXT5vDE7XuA" +
       "x8gn0ARv2ut6YjCNElXnDJ1pYCTNLBUtWVk9HSXY5pJpGuPiauSbC0vveF4r" +
       "6MZRaVr0nKlRbUyUWaEpJ2PBZKbt/rrrzsql+hoxoj690cjQFMqh5jJRcYm0" +
       "KM1LqmJvQEgyP+3bpuytTJqhMN2at2oBTCadRJmJdIHm+Bm/4o1Vs1EcRh2a" +
       "0vs6IRCq7dZHzaBI0CRZEGiD8+wYsNkvaVy31xxVQJigmk19KjfVhB4Ni2rA" +
       "l4AkOWIJT2Zsq1yQFl6lThUj2Guzob4xmxqNIlXZ7o8NW+KYtGORJXLdMaa8" +
       "nxQQwzPCNkIYpEz323zPrOK9AGsXcakXo+slYztabzOoEE2jIOiFvuVtFL7t" +
       "rNyCJZExeC+TaIbVylbcHxdtuB+2lILQNWy/KaAtZtj2MLUG07MGux4hVZGl" +
       "29bQFiduhRwbqyXOTRgjbqLN+USwSVowUVdbGenYxFUNlRpqUecN1VRaAizp" +
       "rKjxQz+mQ7aEwHVjQOsas1o1laLdFxERN22bi1GloFME0faHc0cnuAWynrke" +
       "NZwso1GzKyb0KhRXfWRos0W7TmpO3S/39RVNwGFruBInfa1FdnppR2809E7T" +
       "DjQxMFKSWPYbLcwn40VArmJSiAmLKFuwUps6dnu6SbECLLNpHcepWak3Corl" +
       "odDjGM6YjdrFKup0VlWaYyhTYG3gwQhpLFup4NXjFjn0Sb/gdzyYZWpjYqpL" +
       "I10xeomxbNurotiXSCxFSqbPTQgaK1Yp0+ANSbK9bjjQEw+8GJY7Fhz53bKi" +
       "zoBA2tUC7WJuUBiPeJ6VBMHgCKsyGlVgnR9xzdFgYWkGFyyC5sgWSbpLjArT" +
       "dRLxltMNTdIInEqnZSUCzuPUpsWtVDrxo3YBXbSdWqFCxxjsNZF+wifdSUTG" +
       "illYLIFtC92omuK1oeP5DmbGy2rIsqtOudutjydwOrEb6hhVGitdYGbsiPJq" +
       "I6Y6HozpDorJ+GhKFPRxwx0ysIi0oqXcS/HxfNErxnSi1kvzFZck7jxoFxec" +
       "R7f6g01BdjE+EEejZD5qrKUuOUaEXgP2nAUCSzUY1xxcTIeVgu8QJQ6NykaH" +
       "FmPHoVin02aGHWK8xExcQWB03C+XhNIMGDTPU5SdmhInJ83msM2yRtFKYBiW" +
       "F/68gpTbQ33M9WYeTQ0LLb7MJDiib5IFG9fMBtrpF+uk6OE450pNm19jHFrV" +
       "PEeqkqu6ntZIt4JinE9MOjgzoN2h4uDwRAqryLiPsCN3WJqKWlqQGDQMfJn1" +
       "HaXSaPgwjqtJOCuV+8LUmVXLJa278nBf7JeNVtuo4xy7qQwiJo57HKsNlo3C" +
       "yF97g6a8XhjIkqhqZFRiYNzCF6gayHAy9x0vdcyoN+tO2bTtoQzPrlwZVuOS" +
       "jaEgPKjcQF0jPJrw9IgcaYGggmAySgajMCxYjuR0mrV+O+qKZoAuK40AiWyY" +
       "HVIWrAvBINkw3LKOl5elhtqgx8R6ykTOGG1jeHEYsvBqPetgpcKKGmLtyGwi" +
       "Mq3Vl02816XIYOQgriC12OqsgxfQ0dBxF+uBpU0oXR1IRYX2NsALNrUYnGdX" +
       "i+xswKVFV+2pYbUzjSmMsn2+ilVrarFITcwVSzT8xnzcn8cIXUNJHy4X2bgE" +
       "b9Y0H/fWZL8aljtKUJJ9ORZ1YSQP/EAasM7coPHxGpuFQ6UmWdOhLk+SMQJj" +
       "49qiXi7D5fKkTouruhi7FV1IRqnE15r+fDl2cK8s82qCUXExTZFazUZHPfCq" +
       "SUp8EaOlcq8Nz5K05dcrKu2nkqraKbuuClh3Iy8SZS747bYzrUwpLIhjqRvq" +
       "s7G8WYfSkmus6YiRObUYpVXaIN0mN7OnduCVV4tA5OdSm9vQ9bTRxYuUJfFq" +
       "FRZctjfvTXW7GkSUViAGGOPOw7YvpBwyQad6IFCaHBeqdOqPJjId2N6UbUbm" +
       "giyxXcObJG0Ep6JBeyN1NoNhqyX1O83ptD7pzkll3Pf1Slls9ZLW0mxUlRWV" +
       "bpxBp0arltCyQ7ewCJMVEabcECRRpRGGlA24rVtDqltnZH7ipRJqVUuzdaVm" +
       "zfx0jDJ1hOiMdWpj6gqB6bVSqUq6bd60GoopVhlr3KjPCKtcINBBY9YjkVky" +
       "Y7i6XGwuww2GCEmBKcANlV4ttJU+ES2qt0wjvL8hRH/kV3zYAalRvUl3UQ1p" +
       "WTy6YE2ikZYmklUUy00CrwY1GPFQf74W4lnaWaZKyhTmntFHsOomiYIBFcDD" +
       "UtsjBqMY3ZRwZFHBh1hco4y5z3fZHto0YlmU0QkXuzy3wYN4ig3X5YE+WIVY" +
       "Ra/hll7jxouhoFVX40q8TsZjz1CnXIImm/ZsQqa4MxoshyOhWUiStasZztrH" +
       "lXGBaIWogSh9BJ3yc7KgJB4OMw1xFjBUsVofBlJdiuxOWahWJ/UpNeq5Jdnk" +
       "fHs1MYOWXCtO5kRr0FDRDTnsVDngkMMiWZ3bjZqJDFo4kGGD3BQUZd6bWJxS" +
       "FusTv7kRbGthN6dFwyQks0Mu5L4JUj1VHg1mw1nHp4cmjxLlhGUWKSJzk6Hm" +
       "q1FrFLXkZdHQk8a45/ZNc0DEiWkr7CZqzCeVpMyFVHWN9xeddsfgFjGHd6MZ" +
       "XVgPKjheRDBSIaOGFk/rm4pdU7FArlQFqqvaq1Xop2UxlqW4bXYXGrciLJr1" +
       "0hmlTMdKis97/YIul+05bwjevLxBFm7FKHOtSpOqF1W4V3F0doMJkqKqgkfD" +
       "Yk3C9ZSyhJK8Ijux5DUZqssT9XZUW5FyqaV2/UlVnM1qyrq8Waib2JnTaplp" +
       "230e8duTrl8rxIWZZlUUtEaiFVi1NiWv49Ezfb207TlRHjq+z8xhO/QmPIqC" +
       "ebhC8SlLoSk2kFynGUUqWpUJjRwuDEouMVbR5rH5uqZK841cQ+DAnIu1hqJb" +
       "JKslkx7MVKb1ZZWcqli/OzQ6MFUVXUW0ptU2WlRqCsps0NhoS0jT18oTkBqK" +
       "M7NgzjYRUsMXVHkOt8UBLbetCV0cm0xjRXXQsFBxo5JWmGtrUwydYB0Q/FCI" +
       "etZ8XZ3ILGEoDlmaVVIQQRWcny7aMMEtF2ot7BFYC9dVczQwh4XI73HxZtOm" +
       "KrKPG7xbj8eDqDIvMePS2kvH3VYwakzHTc3BKr5XU7haY2DCZkjWFaPFpIMF" +
       "TttGjBAqX7FMpdMaEkT2+vamF/YGfXteLDjo34AX5+xG6wW8OaZXP3Bnr0hx" +
       "VpSC0BflMD2onuaf89epnh6pMJ3ar1o8fEW5PH8N5qatgy5e9lb9smu1d/I3" +
       "6o+888mnlcFHizt7RTw+hG4OXe81lhqr1om61quuXT3o5d2tw+LS59/5b/eO" +
       "X6e/9QWUzx84QedJlL/fe+aLrZfLv7kD3XBQarqi73Z806XjBaZzvhpGvjM+" +
       "VmZ62YES7s5k/gi4intKKF69hH0d5ebWtDWkE4XSnS3Uvu5enOkuweRdxbV3" +
       "G64c2epe0xXcfPRafRAy/9prj+bHxNepx/58NqxC6BZNDbP2CZX1LY+VWY6r" +
       "cSQmuW1clv94+I2vfHjz7DPbKookBmoIwdfqIl/ZyM56FY9ep99y2F/8futn" +
       "n/vWP0/fvG99LzpQxh0ZG3ddTxn70rrtaDl4Wzr/pUM/9X9Sheeo1PIF54CG" +
       "B7PF14BL26NB+z80iNM51Ol9Lu48ahBZZx/YQ3ZrfRB8tkOO69euo/XfyIYn" +
       "QujWA63bhrXeP+YVV5iWFoe7CwC325qOT8DnAnz3TyHA+7LFMri+uyfA774Q" +
       "AYJI5PluqMqhqlxbjqe2QfFQOE9fRzi/kw1PhdBL94TDq4amh9sK7GHlt3XI" +
       "/QdfCPdpCF042arMei33XPE3iG3rXv7k0+fP3v305G/zbt1Be/1mBjq7iCzr" +
       "aGn8yPyM56sLI2fn5m2h3Mu/PhZCd18jcITQme0kJ/l3t/AfB9SehA+h0/n3" +
       "UbhPhNC5QziAajs5CvKpELoBgGTTT3tXKapvOwTpqSPPkz1byYV8x08S8sGW" +
       "o828LK7kf0PZf15E7F74evbpbv9tz1c+um0mypa42WRYzjLQTdu+5sEz56Fr" +
       "YtvHdab92I9u+9TNj+5HqNu2BB/a7RHaHrh6t65pe2HeX9v80d2fee3Hnv5a" +
       "XuP/X7MUpj4fJAAA");
}
