package org.apache.batik.gvt.text;
public class ArabicTextHandler {
    private static final int arabicStart = 1536;
    private static final int arabicEnd = 1791;
    private static final java.text.AttributedCharacterIterator.Attribute ARABIC_FORM =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_FORM;
    private static final java.lang.Integer ARABIC_NONE = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                           ARABIC_NONE;
    private static final java.lang.Integer ARABIC_ISOLATED =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_ISOLATED;
    private static final java.lang.Integer ARABIC_TERMINAL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_TERMINAL;
    private static final java.lang.Integer ARABIC_INITIAL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_INITIAL;
    private static final java.lang.Integer ARABIC_MEDIAL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_MEDIAL;
    private ArabicTextHandler() { super(); }
    public static java.text.AttributedString assignArabicForms(java.text.AttributedString as) {
        if (!containsArabic(
               as)) {
            return as;
        }
        java.text.AttributedCharacterIterator aci =
          as.
          getIterator(
            );
        int numChars =
          aci.
          getEndIndex(
            ) -
          aci.
          getBeginIndex(
            );
        int[] charOrder =
          null;
        if (numChars >=
              3) {
            char prevChar =
              aci.
              first(
                );
            char c =
              aci.
              next(
                );
            int i =
              1;
            for (char nextChar =
                   aci.
                   next(
                     );
                 nextChar !=
                   java.text.AttributedCharacterIterator.
                     DONE;
                 prevChar =
                   c,
                   c =
                     nextChar,
                   nextChar =
                     aci.
                       next(
                         ),
                   i++) {
                if (arabicCharTransparent(
                      c)) {
                    if (hasSubstitute(
                          prevChar,
                          nextChar)) {
                        if (charOrder ==
                              null) {
                            charOrder =
                              (new int[numChars]);
                            for (int j =
                                   0;
                                 j <
                                   numChars;
                                 j++) {
                                charOrder[j] =
                                  j +
                                    aci.
                                    getBeginIndex(
                                      );
                            }
                        }
                        int temp =
                          charOrder[i];
                        charOrder[i] =
                          charOrder[i -
                                      1];
                        charOrder[i -
                                    1] =
                          temp;
                    }
                }
            }
        }
        if (charOrder !=
              null) {
            java.lang.StringBuffer reorderedString =
              new java.lang.StringBuffer(
              numChars);
            char c;
            for (int i =
                   0;
                 i <
                   numChars;
                 i++) {
                c =
                  aci.
                    setIndex(
                      charOrder[i]);
                reorderedString.
                  append(
                    c);
            }
            java.text.AttributedString reorderedAS;
            reorderedAS =
              new java.text.AttributedString(
                reorderedString.
                  toString(
                    ));
            for (int i =
                   0;
                 i <
                   numChars;
                 i++) {
                aci.
                  setIndex(
                    charOrder[i]);
                java.util.Map attributes =
                  aci.
                  getAttributes(
                    );
                reorderedAS.
                  addAttributes(
                    attributes,
                    i,
                    i +
                      1);
            }
            if (charOrder[0] !=
                  aci.
                  getBeginIndex(
                    )) {
                aci.
                  setIndex(
                    charOrder[0]);
                java.lang.Float x =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                        X);
                java.lang.Float y =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                        Y);
                if (x !=
                      null &&
                      !x.
                      isNaN(
                        )) {
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          X,
                        new java.lang.Float(
                          java.lang.Float.
                            NaN),
                        charOrder[0],
                        charOrder[0] +
                          1);
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          X,
                        x,
                        0,
                        1);
                }
                if (y !=
                      null &&
                      !y.
                      isNaN(
                        )) {
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          Y,
                        new java.lang.Float(
                          java.lang.Float.
                            NaN),
                        charOrder[0],
                        charOrder[0] +
                          1);
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          Y,
                        y,
                        0,
                        1);
                }
            }
            as =
              reorderedAS;
        }
        aci =
          as.
            getIterator(
              );
        int runStart =
          -1;
        int idx =
          aci.
          getBeginIndex(
            );
        for (int c =
               aci.
               first(
                 );
             c !=
               java.text.AttributedCharacterIterator.
                 DONE;
             c =
               aci.
                 next(
                   ),
               idx++) {
            if (c >=
                  arabicStart &&
                  c <=
                  arabicEnd) {
                if (runStart ==
                      -1)
                    runStart =
                      idx;
            }
            else
                if (runStart !=
                      -1) {
                    as.
                      addAttribute(
                        ARABIC_FORM,
                        ARABIC_NONE,
                        runStart,
                        idx);
                    runStart =
                      -1;
                }
        }
        if (runStart !=
              -1)
            as.
              addAttribute(
                ARABIC_FORM,
                ARABIC_NONE,
                runStart,
                idx);
        aci =
          as.
            getIterator(
              );
        int end =
          aci.
          getBeginIndex(
            );
        java.lang.Integer currentForm =
          ARABIC_NONE;
        while (aci.
                 setIndex(
                   end) !=
                 java.text.AttributedCharacterIterator.
                   DONE) {
            int start =
              aci.
              getRunStart(
                ARABIC_FORM);
            end =
              aci.
                getRunLimit(
                  ARABIC_FORM);
            char currentChar =
              aci.
              setIndex(
                start);
            currentForm =
              (java.lang.Integer)
                aci.
                getAttribute(
                  ARABIC_FORM);
            if (currentForm ==
                  null) {
                continue;
            }
            int currentIndex =
              start;
            int prevCharIndex =
              start -
              1;
            while (currentIndex <
                     end) {
                char prevChar =
                  currentChar;
                currentChar =
                  aci.
                    setIndex(
                      currentIndex);
                while (arabicCharTransparent(
                         currentChar) &&
                         currentIndex <
                         end) {
                    currentIndex++;
                    currentChar =
                      aci.
                        setIndex(
                          currentIndex);
                }
                if (currentIndex >=
                      end) {
                    break;
                }
                java.lang.Integer prevForm =
                  currentForm;
                currentForm =
                  ARABIC_NONE;
                if (prevCharIndex >=
                      start) {
                    if (arabicCharShapesRight(
                          prevChar) &&
                          arabicCharShapesLeft(
                            currentChar)) {
                        prevForm =
                          new java.lang.Integer(
                            prevForm.
                              intValue(
                                ) +
                              1);
                        as.
                          addAttribute(
                            ARABIC_FORM,
                            prevForm,
                            prevCharIndex,
                            prevCharIndex +
                              1);
                        currentForm =
                          ARABIC_INITIAL;
                    }
                    else
                        if (arabicCharShaped(
                              currentChar)) {
                            currentForm =
                              ARABIC_ISOLATED;
                        }
                }
                else
                    if (arabicCharShaped(
                          currentChar)) {
                        currentForm =
                          ARABIC_ISOLATED;
                    }
                if (currentForm !=
                      ARABIC_NONE)
                    as.
                      addAttribute(
                        ARABIC_FORM,
                        currentForm,
                        currentIndex,
                        currentIndex +
                          1);
                prevCharIndex =
                  currentIndex;
                currentIndex++;
            }
        }
        return as;
    }
    public static boolean arabicChar(char c) {
        if (c >=
              arabicStart &&
              c <=
              arabicEnd) {
            return true;
        }
        return false;
    }
    public static boolean containsArabic(java.text.AttributedString as) {
        return containsArabic(
                 as.
                   getIterator(
                     ));
    }
    public static boolean containsArabic(java.text.AttributedCharacterIterator aci) {
        for (char c =
               aci.
               first(
                 );
             c !=
               java.text.AttributedCharacterIterator.
                 DONE;
             c =
               aci.
                 next(
                   )) {
            if (arabicChar(
                  c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean arabicCharTransparent(char c) {
        int charVal =
          c;
        if (charVal <
              1611 ||
              charVal >
              1773)
            return false;
        if (charVal <=
              1621 ||
              charVal ==
              1648 ||
              charVal >=
              1750 &&
              charVal <=
              1764 ||
              charVal >=
              1767 &&
              charVal <=
              1768 ||
              charVal >=
              1770) {
            return true;
        }
        return false;
    }
    private static boolean arabicCharShapesRight(char c) {
        int charVal =
          c;
        if (charVal >=
              1570 &&
              charVal <=
              1573 ||
              charVal ==
              1575 ||
              charVal ==
              1577 ||
              charVal >=
              1583 &&
              charVal <=
              1586 ||
              charVal ==
              1608 ||
              charVal >=
              1649 &&
              charVal <=
              1651 ||
              charVal >=
              1653 &&
              charVal <=
              1655 ||
              charVal >=
              1672 &&
              charVal <=
              1689 ||
              charVal ==
              1728 ||
              charVal >=
              1730 &&
              charVal <=
              1739 ||
              charVal ==
              1741 ||
              charVal ==
              1743 ||
              charVal >=
              1746 &&
              charVal <=
              1747 ||
              arabicCharShapesDuel(
                c)) {
            return true;
        }
        return false;
    }
    private static boolean arabicCharShapesDuel(char c) {
        int charVal =
          c;
        if (charVal ==
              1574 ||
              charVal ==
              1576 ||
              charVal >=
              1578 &&
              charVal <=
              1582 ||
              charVal >=
              1587 &&
              charVal <=
              1594 ||
              charVal >=
              1601 &&
              charVal <=
              1607 ||
              charVal >=
              1609 &&
              charVal <=
              1610 ||
              charVal >=
              1656 &&
              charVal <=
              1671 ||
              charVal >=
              1690 &&
              charVal <=
              1727 ||
              charVal ==
              1729 ||
              charVal ==
              1740 ||
              charVal ==
              1742 ||
              charVal >=
              1744 &&
              charVal <=
              1745 ||
              charVal >=
              1786 &&
              charVal <=
              1788) {
            return true;
        }
        return false;
    }
    private static boolean arabicCharShapesLeft(char c) {
        return arabicCharShapesDuel(
                 c);
    }
    private static boolean arabicCharShaped(char c) {
        return arabicCharShapesRight(
                 c);
    }
    public static boolean hasSubstitute(char ch1,
                                        char ch2) {
        if (ch1 <
              doubleCharFirst ||
              ch1 >
              doubleCharLast)
            return false;
        int[][] remaps =
          doubleCharRemappings[ch1 -
                                 doubleCharFirst];
        if (remaps ==
              null)
            return false;
        for (int i =
               0;
             i <
               remaps.
                 length;
             i++) {
            if (remaps[i][0] ==
                  ch2)
                return true;
        }
        return false;
    }
    public static int getSubstituteChar(char ch1,
                                        char ch2,
                                        int form) {
        if (form ==
              0)
            return -1;
        if (ch1 <
              doubleCharFirst ||
              ch1 >
              doubleCharLast)
            return -1;
        int[][] remaps =
          doubleCharRemappings[ch1 -
                                 doubleCharFirst];
        if (remaps ==
              null)
            return -1;
        for (int i =
               0;
             i <
               remaps.
                 length;
             i++) {
            if (remaps[i][0] ==
                  ch2)
                return remaps[i][form];
        }
        return -1;
    }
    public static int getSubstituteChar(char ch,
                                        int form) {
        if (form ==
              0)
            return -1;
        if (ch <
              singleCharFirst ||
              ch >
              singleCharLast)
            return -1;
        int[] chars =
          singleCharRemappings[ch -
                                 singleCharFirst];
        if (chars ==
              null)
            return -1;
        return chars[form -
                       1];
    }
    public static java.lang.String createSubstituteString(java.text.AttributedCharacterIterator aci) {
        int start =
          aci.
          getBeginIndex(
            );
        int end =
          aci.
          getEndIndex(
            );
        int numChar =
          end -
          start;
        java.lang.StringBuffer substString =
          new java.lang.StringBuffer(
          numChar);
        for (int i =
               start;
             i <
               end;
             i++) {
            char c =
              aci.
              setIndex(
                i);
            if (!arabicChar(
                   c)) {
                substString.
                  append(
                    c);
                continue;
            }
            java.lang.Integer form =
              (java.lang.Integer)
                aci.
                getAttribute(
                  ARABIC_FORM);
            if (charStartsLigature(
                  c) &&
                  i +
                  1 <
                  end) {
                char nextChar =
                  aci.
                  setIndex(
                    i +
                      1);
                java.lang.Integer nextForm =
                  (java.lang.Integer)
                    aci.
                    getAttribute(
                      ARABIC_FORM);
                if (form !=
                      null &&
                      nextForm !=
                      null) {
                    if (form.
                          equals(
                            ARABIC_TERMINAL) &&
                          nextForm.
                          equals(
                            ARABIC_INITIAL)) {
                        int substChar =
                          org.apache.batik.gvt.text.ArabicTextHandler.
                          getSubstituteChar(
                            c,
                            nextChar,
                            ARABIC_ISOLATED.
                              intValue(
                                ));
                        if (substChar >
                              -1) {
                            substString.
                              append(
                                (char)
                                  substChar);
                            i++;
                            continue;
                        }
                    }
                    else
                        if (form.
                              equals(
                                ARABIC_TERMINAL)) {
                            int substChar =
                              org.apache.batik.gvt.text.ArabicTextHandler.
                              getSubstituteChar(
                                c,
                                nextChar,
                                ARABIC_TERMINAL.
                                  intValue(
                                    ));
                            if (substChar >
                                  -1) {
                                substString.
                                  append(
                                    (char)
                                      substChar);
                                i++;
                                continue;
                            }
                        }
                        else
                            if (form.
                                  equals(
                                    ARABIC_MEDIAL) &&
                                  nextForm.
                                  equals(
                                    ARABIC_MEDIAL)) {
                                int substChar =
                                  org.apache.batik.gvt.text.ArabicTextHandler.
                                  getSubstituteChar(
                                    c,
                                    nextChar,
                                    ARABIC_MEDIAL.
                                      intValue(
                                        ));
                                if (substChar >
                                      -1) {
                                    substString.
                                      append(
                                        (char)
                                          substChar);
                                    i++;
                                    continue;
                                }
                            }
                }
            }
            if (form !=
                  null &&
                  form.
                  intValue(
                    ) >
                  0) {
                int substChar =
                  getSubstituteChar(
                    c,
                    form.
                      intValue(
                        ));
                if (substChar >
                      -1) {
                    c =
                      (char)
                        substChar;
                }
            }
            substString.
              append(
                c);
        }
        return substString.
          toString(
            );
    }
    public static boolean charStartsLigature(char c) {
        int charVal =
          c;
        if (charVal ==
              1611 ||
              charVal ==
              1612 ||
              charVal ==
              1613 ||
              charVal ==
              1614 ||
              charVal ==
              1615 ||
              charVal ==
              1616 ||
              charVal ==
              1617 ||
              charVal ==
              1618 ||
              charVal ==
              1570 ||
              charVal ==
              1571 ||
              charVal ==
              1573 ||
              charVal ==
              1575) {
            return true;
        }
        return false;
    }
    public static int getNumChars(char c) {
        if (isLigature(
              c))
            return 2;
        return 1;
    }
    public static boolean isLigature(char c) {
        int charVal =
          c;
        if (charVal <
              65136 ||
              charVal >
              65276)
            return false;
        if (charVal <=
              65138 ||
              charVal ==
              65140 ||
              charVal >=
              65142 &&
              charVal <=
              65151 ||
              charVal >=
              65269) {
            return true;
        }
        return false;
    }
    static int singleCharFirst = 1569;
    static int singleCharLast = 1610;
    static int[][] singleCharRemappings =
      { { 65152,
    -1,
    -1,
    -1 },
    { 65153,
    65154,
    -1,
    -1 },
    { 65155,
    65156,
    -1,
    -1 },
    { 65157,
    65158,
    -1,
    -1 },
    { 65159,
    65160,
    -1,
    -1 },
    { 65161,
    65162,
    65163,
    65164 },
    { 65165,
    65166,
    -1,
    -1 },
    { 65167,
    65168,
    65169,
    65170 },
    { 65171,
    65172,
    -1,
    -1 },
    { 65173,
    65174,
    65175,
    65176 },
    { 65177,
    65178,
    65179,
    65180 },
    { 65181,
    65182,
    65183,
    65184 },
    { 65185,
    65186,
    65187,
    65188 },
    { 65189,
    65190,
    65191,
    65192 },
    { 65193,
    65194,
    -1,
    -1 },
    { 65195,
    65196,
    -1,
    -1 },
    { 65197,
    65198,
    -1,
    -1 },
    { 65199,
    65200,
    -1,
    -1 },
    { 65201,
    65202,
    65203,
    65204 },
    { 65205,
    65206,
    65207,
    65208 },
    { 65209,
    65210,
    65211,
    65212 },
    { 65213,
    65214,
    65215,
    65216 },
    { 65217,
    65218,
    65219,
    65220 },
    { 65221,
    65222,
    65223,
    65224 },
    { 65225,
    65226,
    65227,
    65228 },
    { 65229,
    65230,
    65231,
    65232 },
    null,
    null,
    null,
    null,
    null,
    null,
    { 65233,
    65234,
    65235,
    65236 },
    { 65237,
    65238,
    65239,
    65240 },
    { 65241,
    65242,
    65243,
    65244 },
    { 65245,
    65246,
    65247,
    65248 },
    { 65249,
    65250,
    65251,
    65252 },
    { 65253,
    65254,
    65255,
    65256 },
    { 65257,
    65258,
    65259,
    65260 },
    { 65261,
    65262,
    -1,
    -1 },
    { 65263,
    65264,
    -1,
    -1 },
    { 65265,
    65266,
    65267,
    65268 } };
    static int doubleCharFirst = 1570;
    static int doubleCharLast = 1618;
    static int[][][] doubleCharRemappings =
      { { { 1604,
    65269,
    65270,
    -1,
    -1 } },
    { { 1604,
    65271,
    65272,
    -1,
    -1 } },
    null,
    { { 1604,
    65273,
    65274,
    -1,
    -1 } },
    null,
    { { 1604,
    65275,
    65276,
    -1,
    -1 } },
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    { { 32,
    65136,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65137 } },
    { { 32,
    65138,
    -1,
    -1,
    -1 } },
    { { 32,
    65140,
    -1,
    -1,
    -1 } },
    { { 32,
    65142,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65143 } },
    { { 32,
    65144,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65145 } },
    { { 32,
    65146,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65147 } },
    { { 32,
    65148,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65149 } },
    { { 32,
    65150,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65151 } } };
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
      ("H4sIAAAAAAAAAL18C9DsVn3f3mv7+u1rG2yMYwPGNsFecvXalbRxmrAP7a60" +
       "2l2tVtqHkmD0llbP1WNXu6nDY0IgpQMMMQnpEE86NW3CmEcY0qRDybjptMBA" +
       "mZKhDW2nkDCdSVpgBmbSJANt6ZF2v8f97r2ffX1xvhkdaaXz+P3+5///n/85" +
       "Ovqe+27phjgqlcPA3ZhukFzQs+TCwq1eSDahHl9g2ConR7GuNV05jgVw70n1" +
       "9Z86/zc//IB159nSOan0Ctn3g0RO7MCPeT0O3JWusaXzR3cpV/fipHQnu5BX" +
       "MpQmtguxdpw8wZZuPVY0KT3CHkCAAAQIQIAKCFD9KBcodLvup14zLyH7Sbws" +
       "/XLpDFs6F6o5vKT00MWVhHIke/tquIIBqOGm/PcEkCoKZ1HpdYfcd5wvIfyh" +
       "MvT0b77lzk9fVzovlc7b/jiHowIQCWhEKt3m6Z6iR3Fd03RNKt3l67o21iNb" +
       "du1tgVsq3R3bpi8naaQfCim/mYZ6VLR5JLnb1JxblKpJEB3SM2zd1Q5+3WC4" +
       "sgm43nvEdcewnd8HBG+xAbDIkFX9oMj1ju1rSem1J0sccnykBzKAojd6emIF" +
       "h01d78vgRunuXd+5sm9C4ySyfRNkvSFIQStJ6f4rVprLOpRVRzb1J5PSfSfz" +
       "cbtHINfNhSDyIknpnpPZippAL91/opeO9c93Bz/zvl/yu/7ZArOmq26O/yZQ" +
       "6DUnCvG6oUe6r+q7grc9zv6GfO/n3nO2VAKZ7zmReZfnD//h99/8ptc8/4Vd" +
       "np+4TJ6hstDV5En1WeWOrz7QfKx2XQ7jpjCI7bzzL2JeqD+3f/JEFgLLu/ew" +
       "xvzhhYOHz/P/fv72j+nfPlu6hS6dUwM39YAe3aUGXmi7etTRfT2SE12jSzfr" +
       "vtYsntOlG8E1a/v67u7QMGI9oUvXu8Wtc0HxG4jIAFXkIroRXNu+ERxch3Ji" +
       "FddZWCqVbgRH6TZwPFza/RXnpPQWyAo8HZJV2bf9AOKiIOcfQ7qfKEC2FqQA" +
       "rXegOEgjoIJQEJmQDPTA0vcPzBXo29w865Gs2KoALruyrwFWF3I9C1/2FrKc" +
       "453rM2eA+B84afwusJtu4Gp69KT6dNqgvv+JJ7909tAY9tJJSmXQ6IVdoxeK" +
       "Ri+ARi/kjV64pNHSmTNFW6/MG991M+gkB5g7cIS3PTb+Reat73n9dUC/wvX1" +
       "QMJ5VujK/rh55CDowg2qQEtLz394/Y7J2+CzpbMXO9YcMLh1S16cy93hodt7" +
       "5KRBXa7e8+/+q7/55G88FRyZ1kWeem/xl5bMLfb1J0UbBaquAR94VP3jr5P/" +
       "4MnPPfXI2dL1wA0A15fIQFWBV3nNyTYustwnDrxgzuUGQNgIIk9280cHruuW" +
       "xIqC9dGdos/vKK7v2qt16UFwkHvdLs7501eEefrKnY7knXaCReFl/8E4/O2v" +
       "f+V/YoW4Dxzy+WND3FhPnjjmBPLKzhfmfteRDgiRroN8//3D3K9/6Lvv/vlC" +
       "AUCOhy/X4CN52gTGD7oQiPldX1j+l29+49mvnT1SmqR0YxjZK+ATskOW+YPS" +
       "raewBM294QgQ8CIusLNcbR4RfS/QbMOWFVfP1fT/nH8U+YPvvO/OnSK44M6B" +
       "Hr3phSs4uv/qRuntX3rL376mqOaMmo9iR0I7yrZzja84qrkeRfImx5G9408f" +
       "/K3Py78NnCxwbLG91QtfVSqEUCp6DSr4P16kF048Q/LktfFx7b/YwI5FG0+q" +
       "H/ja926ffO+Pv1+gvThcOd7ZfTl8YqdfefK6DFT/qpOm3pVjC+SrPD/4hTvd" +
       "538IapRAjSpwX/EwAs4mu0g19rlvuPG//pt/e+9bv3pd6Wy7dIsbyFpbLqys" +
       "dDNQbz22gJ/Kwp97865z1zeB5M6CaukS8juluK/4dRcA+NiVHUw7jzaObPS+" +
       "Hwxd5Z3f+rtLhFC4lssMsifKS9BzH7m/+bPfLsof2Xhe+jXZpQ4YRGZHZdGP" +
       "ef/77OvP/buzpRul0p3qPuybyG6aW44EQp34IBYEoeFFzy8OW3Zj9BOHPuyB" +
       "k/7lWLMnvcuR4wfXee78+pYTDuXVuZRRcDy6N7VHTzqUYgjY9XEO6QINojRT" +
       "j+7+1u88+7fveDd5NlfoG1Y5dCCVO4/yDdI8uvzV5z704K1P//l7C4svlc4V" +
       "Vf9c0fxDRfpInvxk0b/X5ZdvTErn4iJQTQAd25fdvV/4Efg7A47/lx85yPzG" +
       "bmS/u7kPL153GF+EYKy7VS5GNBD2RsnpqsNFtgcc3mofX0FP3f1N5yN/9fFd" +
       "7HRST05k1t/z9D/60YX3PX32WMT68CVB4/Eyu6i16Ijb86SbW95Dp7VSlGj/" +
       "5Sef+uzvPvXuHaq7L46/KDC9+Ph//r9fvvDhP//iZYb960BsvRsZ8hTNkzfv" +
       "5Fq9ohn+9MVKAoPjDXslecNllCS/qIMe/lF+IZ7Ww3nSzpNOIYNuUrp511OU" +
       "r+U3BieQTq4SKUBRemyP9I2XIC0VF794dQBvrfP1Bt18sj3k+0WZe5ISVOj6" +
       "LnRKwPRCARMLrWkBKiqYYdCJXgx5jxw+O8HqLS+BVXnP6vErsDJeGqvBcEAd" +
       "sLrU0k/gNq8SNwWOn9rjftMVcAdXh/v8Hjc9HrJ1gWrlt50TMMOXABPaw7xw" +
       "BZirlwZToPg+Paizl4O5vkqYLXAge5jwFWA+dXUw7ziQ5oAW6Muj/OWrRNkE" +
       "B7ZHiV4B5a9cHcrb9yj7VOsKIN/14kHmsWXuxM7uRbk7Xwbkey8P8kyB77Cf" +
       "Y9s3QbQITL9tR7sI86QP+8cvARy6B3clCX7wxYC74wgcK18e269fJTbgfc6+" +
       "dY8NuwK233ox2F55hI3XPTkMwc8YjIWPXnmkLgLq3cD7zD9/+Ctve+bhvyhi" +
       "0pvsGIRC9ci8zJLLsTLfe+6b3/7T2x/8RDFxu16R411QdHKt6tKlqItWmAr8" +
       "tx0K5Y5cBvnFu/YqX5yTknWNywH5SoC8TqB+6iZ26OqdSNZsUJgDgWiyX8Y7" +
       "WHr4e2trpyvPXDwjPQ/mbIMd9905KanXCAhoQwzFK1MB0+FYj6BBoOmcrTp6" +
       "xMm+7h7w/vtopujuweHU5Mx+taOwjDz56IHS/97llf4sCGnDVHFt9SKPds7V" +
       "fXO3cFVY5LP7IStv4+yu4MGg/IqjQbnpBr6eT04Pnu1WZ+zgwuHaLXiYXYI2" +
       "Kj1+ZavqF8p9NH/5/Dv/1/3Cz1pvvYplmdeeMLqTVf5e/7kvdt6gfvBs6brD" +
       "2cwlC7sXF3ri4jnMLZGepJEvXDSTeXDXAYX8TnE5z+2EfsoM+7OnPPtcnvwh" +
       "mI+oufB3fXVK9uePzWMvUZZ/eqAsf3IFZSngHlOUPPn4oZL8zqVKkv/8ZJ78" +
       "/qW9nv/+zK7ZonSe/NEp0L94yrMv5cnn8+SPd0hOyfsfstKJQeafvIQBUNkP" +
       "MsoVBpn/+KJGZy1IlRcYnb/6EsCpe3DqFcD92YsanY/AXWl0/vpVYsMBpg/v" +
       "sWlXwPaNFzU6H2E7Njpf7P2LFu84aOlyLe5UJQxP6sM3X5BWAQPMLIHdoReI" +
       "C3D++y9PCRoLo7k4aHzVwlUfOVgcmOhRDHzYIwuXOPCdx5Yrdi+IToDsvmiQ" +
       "wL/ecVQZG/jmE+/9Hx/48vsf/iYIT5iDBZI8dwPIefJrv4/9Xf7je1fH5/6c" +
       "z7gYy3J16Rcrlbp2SKl3DPQwKV0P3NVLp5Tcw3YrMV0/+GMnShOrq5nkpzPV" +
       "G7Nth9usIdKIg6ERNSKhbjt83d6wfZFdwmpMj4PNlME1RUeHnBBv/dSbIKlE" +
       "cs2laoxImke3TYx3Z+KCyoLRdqiKXru3Zis9SzUbsLPkKJquGz2TsphmQ9c2" +
       "al2fqRxkcEp/OyTibewL44mDrYiugGEQhNW0GgTVMEGHwqQfx5vNaLmMeZOY" +
       "t+sRspxmRuzBMhsK7jiLKAYfbNrlwFlVt7VqWutWymPP645dZhp3XW8js1oT" +
       "UUaIwMwjLxYdQZamLD4Jo0F7JQapPM8YQeugc7bdjPl+ddSeuBY3W8rzgLI2" +
       "4mac8swiDNlev7pcN4Tmhqt7csY6HjmqQpqfjrdMG6lUGorBdHy9p/oNeOVh" +
       "7Dzm3eVYx8WsJ1V92wq5niVFbNVyHLwTNba95dbrwesOQyBikjSX1eHMDTtr" +
       "abkaKBCxljCp7RANjvIFra9YUyENQzlZDBjY2eqEwIYzL+Iwh4XdibPgK80F" +
       "N3b9kbwQhwt1uhBHejqtp7CylBRO0wO15fcdhDc3vVigcZe2LI/vDSdJn6up" +
       "EjMYZZ1tump1rFlbo3puRxwtULTXhbAmEcrdJbzY9jvuNKm3RX49dzut0aZF" +
       "C+MZvZQnjooLGteSepWOLyB1QZyM3fkAFQhNHjuyMG3gOIZT7W55PpBXNDqT" +
       "cbO77iiepEuKpViLWa8V+9AAVO+2Og0N79CTJrvKhqNmPIHrmYqMmikxjCbD" +
       "mpC0RoseBCO2tQABHtUUWRHlEXfKbqVJJPprkx31KIRyWb5v1Aec0HcbsGtW" +
       "OnKrt2Ha9UD1EJpcVMIRbIxoH3PLjjh1mWhgq/Xlorldt8vDccDo03I3YuBt" +
       "bVVDqllWweSWjfToZWPrxcEST8i6O1EqvRR1gtrY6derVCY4ioNpbDMjCcoW" +
       "qaYNrdu85K5WzqyKE/JqyMYwzvZhM3TLLkMs1axTZYZhaJEpXtuuyXEoBiQx" +
       "YkcisVqPql10VtOcKrEe1bmYqAeUMFgIqSL5Yq1cTeddvJ3wYkiaA6WXVv2B" +
       "yWMDl5uqQW8hQrwwWQJT9Sh0hCJaD/RMrSGnVHk5tURuCCtdRQzG1cbSFcpL" +
       "2HBXQccU+WajXZs1V3JviKtojWb7q1VzPbfCxjztm3qaiDxZbqmLtDyQONFY" +
       "OHYW2kulW4ZhjZwkGdkyw0prrgiV7oSogEg9qVBUZRtJ9jw1ecRZSijfmQ/L" +
       "md6V5mIQ8jxOoRk6dk1J7Cuj7ZyUlF6z1dH1Id8cNKFtC6pMeBMbYsBmVZgv" +
       "T63ytKZXLVjWqbncNsm2Z1XbA7hj9QeNaLFQZRPmTbRjJ5FLjexVD6ui7CKQ" +
       "UtsxhJa61qAhKjTW69qEWCw3YX0Vb7Jl2piPN3joCTo+42tmytF8ebSN5jAg" +
       "UUNJRV+ErZCZ2lOpOhYnYZUa9tf94Tip+osyVe1JNo/RruVONXvd8AdIZyo3" +
       "IlIcUN25mEZwfxrZKqx4+mZUgbP5EO4u1mG7zRsYi/qrtmJ5hEzZMx6OnLpX" +
       "XbcVcxPV8H6XxaLlICK5ZXOMlY2mQlTxarnaSvVgON6oU4kikyUdzBHDW63h" +
       "bd9WkLVrTDknFgeJzylSpYdKjV6f7Q6pnpHF7napaKq2ocNRpb4oA7YunW3K" +
       "nYrvTQaGltXWMQKzUdlQKjUqtjbppoxZG5bMgCE28NGsGQ26Q6O5qGRck6nr" +
       "nN4FznlQ1dZpCFfDgbMtj2ojJCWy6caO3VkKvCkhtcKlOIrcGVH2IYjtYK0y" +
       "ZA/M2EVcaRnXMUFYNWYwPamTKMIRGFStadpwZTUQQtrw03gg0o2lbY2Z3rZZ" +
       "H9Bj20qNaTpKW5VJtz6QW1KCoKEZ9JcBvZyIts1FRnU1mxmbAVbDeNrMGtZY" +
       "H3anqD6lW4TBUai66m/TWk1ZqxNKYrLKTGPVedxTtljf1aq2p9VbSG+w3WAc" +
       "A+nUEm+X522yP52qYWNTg4NKcy5g6FJUoUzWjWQ80zLHwzebVU1Sh32qXB80" +
       "WaOs0sRC5FZcFx/KSCzPZw6RwuoGDSa1udIr14f0iuymflfqTawZbXBaQhjz" +
       "BK+Zw9Gwvh5LRrMyCUkGitojYHkoPvEQDvIwZQOpJNlfUins1eQgDZXY5eKI" +
       "VlqNlezNGgkv9wWk4g59nWyF9LQVTkVzXCPM+ngVDTJkJngtVaE5zmcbCE5W" +
       "NJ1GFE/uOGxHRNBaU0Ege+J7KhEQcaOKQ0R/IhgYhKVgyBusx0QfKdd4HcKW" +
       "sqsYUNeQJH7LI3OruepOuhXc4CLcIcklBhRjFqCtJHHYaqs+0VEZJWrzrmrA" +
       "sxnSXftjb9kdz5M4IyctJ4y6qhD0Y7nlNvrxaFg1HJeUEDqwQqD/fWlWXVU9" +
       "f0qQK9Xju2ksCPoAilQEZeP1EllHSr9bWyyhcpnZhmw9mDS9qdmqoyMSm86w" +
       "bVbtpliXrZB2PPARy162lhs4HU5wMrPKUG0WzslYWayIWMH8LoWwLX6sVcgM" +
       "snBR6rNpzxPpKdYXpSXbIJg+GFllhl2ScI8dhbwLD9qkF+gh4o1daisNbZOr" +
       "uvWpsKzSrdk29PhqopQhg+ZrEY5lLTRRrGZj0k7XBpahQProKo5rNR4ZdmFu" +
       "GGY44+nz6gITeDoZQSJX4YctvI/gQX9RGYmTJAozGI/sqLNYmOWRiWmNTaO8" +
       "5GaIoRqG0a7XyXaKRNt6TV3xKy7YauqEr8wIqj6dpGhj1ZpS83hUH+kCjjQJ" +
       "ZNpJyEakrbbVLT7oEq0Mnk6j6dRKBlrcDkmS0iB9IaFbslyebjq9JcLG/HiM" +
       "e6KZlcPQQBdqE+ZkSFkRU19GJpjQyhjY0mYuh1ZRx55No1oymZeruhNraBdA" +
       "NpWOP+/T1c4Arms2Giuw6mzStqfMu6m5GMKrLtKQK0iSeGlENL1+T5HRRt2g" +
       "TcxT6g1TdCAmLKf9Rq/peQ0nsUxmNgnk7npbrXRGflNWW5GJoNNMn67HXTIL" +
       "zY1txi2mP6gQyUKKxxg/1FhgacMugqyoMbMmOnxXHGJxiquVuMJMLEJKTJdS" +
       "UUUVyS4k1MRKs7yZSOv5ugWbyLCzWrTrsZnWEryMbSptnQi0WqWDqwxrpmkT" +
       "30w0U60P8a24lrGhWN/wLRhN+3x9RjCLuBMTXERIYPRCe9Mmg26wTj1qkZg0" +
       "zrI67aSI2UkxBWW6AeGE0zXWqjLsYGWliZWqYlx3lwMhi2h31KIXgohDtea8" +
       "Q1WnVpeJHZfCK2xEKVgjqFcNWwym64HTz+hgjbohmhB1hiG2GclEPjbaiEoi" +
       "WF2jLTXViF47a6dbqfVIzhlpnjR25QawiMrAxtuTfuxAWQqxlZBm65K9VpBs" +
       "6jXqzECoGkEHGSmCakwG43A2MWbNMR4wwmKIZx1i7YwGCNSczDAnaMmLfoYh" +
       "GsKoVcZaU+WoNkCa/RHr2PCcV5CtQQ5HAhJqUE1p0vImarsEoW25hENUb1Vl" +
       "CIcci6gxhcOsNx8xQnc8tVS1gS3h4aozSbQyhKuC7EPcZM4gACJdpxOqVyaG" +
       "+jAtq8YKTarZcsaRY0zoBVnQn3Q6EKyg5RmB2DMF5jOhv5E5OyZqE6ttUGRP" +
       "alYNDS33FGeCQVsMoTCqJ2auQ46gibpq12x0LEz69jZS2sBku/ZQW5rxIJ16" +
       "NulK2SaCVgqt2H12mcW2P6HEKWRuBbzclDbhqg4iuQUZCBYbDRfBkhbAjGtL" +
       "VxrDiaYGRBBUwCAFwrr2IjNU1Wk7AVybOxs4nmItlBzWsAmOA+OEsM2sFm/Q" +
       "jby15j43cTbr8dyDJhVmoJhrVFbIpVDDcHQzbU1QBRM6NKYCEVRWsL2qhdty" +
       "BEZQGzLa+nQlxuNNmq4nQsdzawnr8izCTDVCHFvqSIZnGFmrsN6op1MurMdR" +
       "Fxadhb6pmmRrnSw6SqJPqZAmpfKUqM1Mc020YhwRpLjHDW2F1IM6o2amTpIz" +
       "BweTM86tpulqseW2jWqSrKekoXI8OyQH9nxlUS18Ii50r2qTpupyVnNuSbMa" +
       "ASWCKdQ8qMtt8XZT0d0h5olraovqtZZE9EzUqgchNyHlgKlXJDjEmyuFVYNG" +
       "OaooS682UkamOOuirXoww5iln2Z409LL6w687i4h2xWxGV9XjOYyipb6qE5t" +
       "uxvP2AQgSOj2F0yDyiShmnb6StXTlsaIMIOUsXS2GbW47YyqVZRRsF6vUk2Q" +
       "tpVZSA9Nl00gZjjzI5jnwtUqTjWzN8fm274EPLcjRt3lMOAZQSYMtyGahN6r" +
       "sIoie1tMLdPNlkFtoGWjqgQWhVVa2NDy5t1QE4GfHSlklXdVuznvkvwUTFD7" +
       "m23d5B03qHgzW0PxjQ4m0X3GVuCJzESsSrIIXJnzpNAkgNuXK5C3WEDpEO7z" +
       "jtOfC8xI3KQUQZcrhAeZUns5nK64MjrpbCeu2ibZteRk075Lr2pLGO+KjrXV" +
       "pp7WRl3Hlau8onGTGBF9ZE0vxCklcFStO4PHPba98bEWUVlnZToQNAFlNh0D" +
       "iBuedpjxeu6TkhrYuDGWaVlpmwMYlkSn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+2KIf2RP/CMvX0fvOX/kFM7P5MlvvgjOH74GzsX+7tx5fXrP+dM/Rs7HTLn4" +
       "PubM755C92N58s+S0r1qpMuJfsT4aCvPd444P3utBv0mAOwHe84/eHk472z5" +
       "M6dw/pd58smkdHcetu8+bGJts/hC/4RBf+pa9fohAP32Xdnd+eXi+/wpfP8k" +
       "Tz6blG4FKj1IvcOJxzFl/tc/hlnX2X2EefZljTC/fArRr+TJ55P8y8ArdOgX" +
       "roZnBrzAJd9z59+m3nfJP43Y/aMD9RPPnL/pVc+If7bbGX/wzwhuZks3Ganr" +
       "Hv+U8Nj1uTDSDbtgf/Puw8KwYPOfktKrr/ihOZh05qcc85mv7fJ/HYQgl8uf" +
       "lK4D6fGc/w0M3SdzJqUbivPxfN8AojzKl5TO7S6OZ/kLUDvIkl9+a7eX9eId" +
       "gbtvL7PdvOm+4wpULLvc/UL9cWwB5eGLtl4X/97jYJt0uvsHH0+qn3yGGfzS" +
       "9/GP7r7NVl15m8cqpZvY0o27z8SLSvOt1g9dsbaDus51H/vhHZ+6+dGDJZk7" +
       "doCPlPkYttde/jtoyguT4svl7R+96jM/8y+e+UbxBef/B8KClup3RQAA");
}
