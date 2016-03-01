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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bC5AbxZluae3d9T68D+PF+AW21w5+SX4QSG4JZFmvsYj2" +
       "Ubtrp26dy3o06pXGHs0MMy1bNjjETiUmUAUUGELAuJJg8iAOEBJyIQmc7y4k" +
       "EEIoO7njlYMAyZGcoQrywGDujvx/94xmNNLMsosKVU1rNN399/99/ffff/e0" +
       "jr5GplsmWWxIWlqKsd0GtWKDeD8omRZN96iSZY3A0zH5mhdvuurUr2fsi5La" +
       "UTIzK1l9smTRjQpV09YoWaBoFpM0mVr9lKaxxqBJLWrulJiia6NktmIlcoaq" +
       "yArr09MUC2yRzCRpkxgzlVSe0YQtgJGzk1ybONcm3u0v0JUkTbJu7HYrzC2p" +
       "0OPJw7I5tz2LkdbkdmmnFM8zRY0nFYt1FUyy0tDV3RlVZzFaYLHt6odtIi5L" +
       "friMhsX3tbz5zg3ZVk7DLEnTdMYhWkPU0tWdNJ0kLe7TXpXmrMvJZ0hNkjR6" +
       "CjPSmXQajUOjcWjUweuWAu2bqZbP9egcDnMk1RoyKsTIolIhhmRKOVvMINcZ" +
       "JNQzGzuvDGjPKaJ1utsH8eaV8YNf+nTr/TWkZZS0KNowqiODEgwaGQVCaS5F" +
       "Tas7nabpUdKmQYcPU1ORVGWP3dvtlpLRJJYHE3BowYd5g5q8TZcr6EnAZuZl" +
       "pptFeOPcqOxf08dVKQNYO1ysAuFGfA4AGxRQzByXwPbsKtN2KFqa21FpjSLG" +
       "zk9AAahal6MsqxebmqZJ8IC0CxNRJS0THwbj0zJQdLoOJmhyWwsQilwbkrxD" +
       "ytAxRub4yw2KLCg1gxOBVRiZ7S/GJUEvzfX1kqd/Xuu/8LortE1alERA5zSV" +
       "VdS/ESot9FUaouPUpDAORMWmFclbpI6Hro4SAoVn+wqLMv985RsfX7Xw2KOi" +
       "zLwKZQZS26nMxuQjqZnH5/cs/2gNqlFv6JaCnV+CnI+yQTunq2CAp+koSsTM" +
       "mJN5bOhn//jZu+nJKGlIkFpZV/M5sKM2Wc8ZikrNS6lGTYnRdILMoFq6h+cn" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eIzGuhRXFYCK0kPgzELY3IY2y2VIA5KjYDUPupo2bacDims6rabMVaFiSBKd" +
       "Romsx7hIyNQqoLieA8FiucjVS2tO3Ogp214vGEOrF6djXGX7LIv6qlwtDsSO" +
       "MMusQJWamNEi6VDlOaVpzozlqHgVkBRXlDrl1LcWg0UEvGjbbASoGanNGTwt" +
       "dxajsoV0h8u+FkF60XaUgbgmEmw+aC8YeBH5YptaDkxvvDJWlVGsj+VFxRA9" +
       "hyUqi6DLlmcq1UCdxXQtsniruYboYkWvxMVEapdq0tJ149S0aUSOp4NeWV+1" +
       "RctwUKxpqqsGVIGoCvBJ4jU8UVaQG8MbqQ71RWgqq8pmwqsDeqrWJuP2OliX" +
       "a7HdFZcDu9ynCWOKTOFIHjqrGT4K64g0AiNAv0atR4HAQm3Krrd9xgyx9izk" +
       "hl1sMZqqyEKEpZki8uF6WtmMKGmuor5mcE3f1IELFvSMNrO2KiN1AzwiARqQ" +
       "kg8xMBi1xHkajzvtfns+gsiiRjmkg60iumX5xZI36qg62zCgdd2H2jKxXONz" +
       "abnAq7Ue60GoPOvV2GKElCmWZYoJa3VVeIaMsQirbGp4DY1AvAxxNGzWoEZo" +
       "ldmS2gsCTjRbMphgip6ydFrwEiMrLNecbiCHcTCQDJn0V00YxtdBgAarDaY4" +
       "NUfG4p5R7ZE1mevw0NKyk0Su4Q5XXc8duL6g2HmKZfPcpIRueBVCwVSqHUdT" +
       "pN8w7B5vYvJsUJm4HFs20IE46zSmZaUduZbaaXvTaqWMDOeDls6EU7UdKN0J" +
       "MwJOWpPUpnYkLudyi+kVe+UZEbW4ut7QQ6CU+mxUoQaoTSdDUVwSUYP1nFK3" +
       "EgYlczJGeDE08eG8WqQj0uHLq4Sb94qcumzwokWNRhVvsYInqaXKxCZBZmNh" +
       "Ts7cACdZQt/IVrXvplCbb1dNbEYmS0kZd2lCmk+DOTfxfZuLSgqMKvI80OZo" +
       "S+6MyY684Wr9Lmog47oWhXMkNtqddbVphLrYWCal9konZ8a0OAcmHcy7qpHJ" +
       "Cv10GYw7xihVgS1Vp5CoIGsTm+ANUSIt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
