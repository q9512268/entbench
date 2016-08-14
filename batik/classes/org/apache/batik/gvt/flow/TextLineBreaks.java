package org.apache.batik.gvt.flow;
public class TextLineBreaks {
    public static final java.text.AttributedCharacterIterator.Attribute WORD_LIMIT =
      new org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute(
      "WORD_LIMIT");
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    static java.util.Set lineBrks = new java.util.HashSet(
      );
    static { lineBrks.add(FLOW_PARAGRAPH);
             lineBrks.add(FLOW_LINE_BREAK); }
    static int findComplexBreak(java.text.AttributedCharacterIterator aci) {
        int cnt =
          0;
        for (char ch =
               aci.
               current(
                 );
             ch ==
               java.text.AttributedCharacterIterator.
                 DONE;
             ch =
               aci.
                 next(
                   ),
               cnt++) {
            if (getCharCharClass(
                  ch) !=
                  CHAR_CLASS_SA)
                break;
        }
        return cnt;
    }
    public static void findLineBrk(java.text.AttributedString as) {
        java.text.AttributedCharacterIterator aci =
          as.
          getIterator(
            );
        if (aci.
              getEndIndex(
                ) ==
              0)
            return;
        char ch =
          aci.
          current(
            );
        char prevCh =
          (char)
            -1;
        byte cls =
          getCharCharClass(
            ch);
        if (cls ==
              CHAR_CLASS_LF)
            cls =
              CHAR_CLASS_BK;
        byte curCls =
          cls;
        byte prevCls =
          cls;
        byte prevPrevCls =
          -1;
        int wordCnt =
          0;
        int wordBegin =
          aci.
          getBeginIndex(
            );
        int ich =
          wordBegin +
          1;
        int lineEnd =
          aci.
          getRunLimit(
            lineBrks);
        if (cls >=
              CHAR_CLASS_CM)
            cls =
              CHAR_CLASS_AL;
        for (ch =
               aci.
                 next(
                   );
             ch !=
               java.text.AttributedCharacterIterator.
                 DONE;
             ich++,
               prevCh =
                 ch,
               ch =
                 aci.
                   next(
                     ),
               prevPrevCls =
                 prevCls,
               prevCls =
                 curCls) {
            if (ich ==
                  lineEnd) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich);
                wordBegin =
                  ich;
                cls =
                  getCharCharClass(
                    ch);
                curCls =
                  cls;
                prevCls =
                  cls;
                if (cls >=
                      CHAR_CLASS_CM)
                    cls =
                      CHAR_CLASS_AL;
                lineEnd =
                  aci.
                    getRunLimit(
                      lineBrks);
                continue;
            }
            curCls =
              getCharCharClass(
                ch);
            if (curCls ==
                  CHAR_CLASS_SP) {
                continue;
            }
            if (curCls ==
                  CHAR_CLASS_SA) {
                ich +=
                  findComplexBreak(
                    aci);
                ch =
                  aci.
                    previous(
                      );
                if (ch !=
                      java.text.AttributedCharacterIterator.
                        DONE)
                    prevCls =
                      getCharCharClass(
                        ch);
                ch =
                  aci.
                    next(
                      );
                if (ch !=
                      java.text.AttributedCharacterIterator.
                        DONE)
                    curCls =
                      (cls =
                         getCharCharClass(
                           ch));
                continue;
            }
            if (ch ==
                  CHAR_ZERO_WIDTH_JOINER ||
                  prevCh ==
                  CHAR_ZERO_WIDTH_JOINER)
                continue;
            if (curCls ==
                  CHAR_CLASS_BK ||
                  curCls ==
                  CHAR_CLASS_LF) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich);
                wordBegin =
                  ich;
                cls =
                  CHAR_CLASS_BK;
                continue;
            }
            if (prevCls ==
                  CHAR_CLASS_CR) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich -
                      1);
                wordBegin =
                  ich -
                    1;
                cls =
                  CHAR_CLASS_BK;
                continue;
            }
            if (curCls ==
                  CHAR_CLASS_CR) {
                continue;
            }
            if (curCls ==
                  CHAR_CLASS_CM) {
                if (prevCls ==
                      CHAR_CLASS_SP) {
                    cls =
                      CHAR_CLASS_ID;
                    if (prevPrevCls !=
                          -1) {
                        if (brkPairs[prevPrevCls][CHAR_CLASS_ID] ==
                              BREAK_ACTION_DIRECT) {
                            as.
                              addAttribute(
                                WORD_LIMIT,
                                new java.lang.Integer(
                                  wordCnt++),
                                wordBegin,
                                ich -
                                  1);
                            wordBegin =
                              ich -
                                1;
                        }
                        else {
                            
                        }
                    }
                }
                continue;
            }
            if (cls ==
                  CHAR_CLASS_BK) {
                cls =
                  curCls;
                continue;
            }
            byte brk =
              brkPairs[cls][curCls];
            if (brk ==
                  BREAK_ACTION_DIRECT) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich);
                wordBegin =
                  ich;
            }
            else
                if (brk ==
                      BREAK_ACTION_INDIRECT) {
                    if (prevCls ==
                          CHAR_CLASS_SP) {
                        as.
                          addAttribute(
                            WORD_LIMIT,
                            new java.lang.Integer(
                              wordCnt++),
                            wordBegin,
                            ich);
                        wordBegin =
                          ich;
                    }
                }
            cls =
              curCls;
        }
        as.
          addAttribute(
            WORD_LIMIT,
            new java.lang.Integer(
              wordCnt++),
            wordBegin,
            ich);
        wordBegin =
          ich;
        return;
    }
    public static byte[] stringToLineBreakClasses(java.lang.String s) {
        int len =
          s.
          length(
            );
        byte[] ret =
          new byte[len];
        for (int i =
               0;
             i <
               len;
             i++) {
            ret[i] =
              getCharCharClass(
                s.
                  charAt(
                    i));
        }
        return ret;
    }
    public static byte getCharCharClass(char ch) { if (ch <
                                                         QUICK_LUT_SIZE) {
                                                       if (quickLut ==
                                                             null)
                                                           buildQuickLut(
                                                             );
                                                       return quickLut[ch];
                                                   }
                                                   int len =
                                                     raw_data.
                                                       length;
                                                   int l =
                                                     0;
                                                   int r =
                                                     len /
                                                     2 -
                                                     1;
                                                   int entry =
                                                     (l +
                                                        r) /
                                                     2;
                                                   while (l <=
                                                            r) {
                                                       char min =
                                                         raw_data[2 *
                                                                    entry];
                                                       char max =
                                                         raw_data[2 *
                                                                    entry +
                                                                    1];
                                                       if (ch <
                                                             min)
                                                           r =
                                                             entry -
                                                               1;
                                                       else
                                                           if (ch >
                                                                 max)
                                                               l =
                                                                 entry +
                                                                   1;
                                                           else
                                                               break;
                                                       entry =
                                                         (l +
                                                            r) /
                                                           2;
                                                   }
                                                   return raw_classes[entry];
    }
    public static final char CHAR_ZERO_WIDTH_JOINER = 8205;
    protected static final int QUICK_LUT_SIZE = 256;
    protected static void buildQuickLut() { int entry = 0;
                                            quickLut = (new byte[QUICK_LUT_SIZE]);
                                            int i = 0;
                                            while (i < QUICK_LUT_SIZE) {
                                                int max =
                                                  raw_data[2 *
                                                             entry +
                                                             1];
                                                byte cls =
                                                  raw_classes[entry];
                                                while (i <=
                                                         max) {
                                                    quickLut[i] =
                                                      cls;
                                                    i++;
                                                    if (i >=
                                                          QUICK_LUT_SIZE)
                                                        break;
                                                }
                                                entry++;
                                            } }
    public static final byte BREAK_ACTION_DIRECT = 0;
    public static final byte BREAK_ACTION_INDIRECT = 1;
    public static final byte BREAK_ACTION_PROHIBITED = 2;
    public static final java.lang.String[] brkStrs = { "DB",
    "IB",
    "PB" };
    public static final byte CHAR_CLASS_OP = 0;
    public static final byte CHAR_CLASS_CL = 1;
    public static final byte CHAR_CLASS_QU = 2;
    public static final byte CHAR_CLASS_GL = 3;
    public static final byte CHAR_CLASS_NS = 4;
    public static final byte CHAR_CLASS_EX = 5;
    public static final byte CHAR_CLASS_SY = 6;
    public static final byte CHAR_CLASS_IS = 7;
    public static final byte CHAR_CLASS_PR = 8;
    public static final byte CHAR_CLASS_PO = 9;
    public static final byte CHAR_CLASS_NU = 10;
    public static final byte CHAR_CLASS_AL = 11;
    public static final byte CHAR_CLASS_ID = 12;
    public static final byte CHAR_CLASS_IN = 13;
    public static final byte CHAR_CLASS_HY = 14;
    public static final byte CHAR_CLASS_BA = 15;
    public static final byte CHAR_CLASS_BB = 16;
    public static final byte CHAR_CLASS_B2 = 17;
    public static final byte CHAR_CLASS_ZW = 18;
    public static final byte CHAR_CLASS_CM = 19;
    public static final byte CHAR_CLASS_SA = 20;
    public static final byte CHAR_CLASS_SP = 21;
    public static final byte CHAR_CLASS_BK = 22;
    public static final byte CHAR_CLASS_AI = CHAR_CLASS_AL;
    public static final byte CHAR_CLASS_CR = 24;
    public static final byte CHAR_CLASS_LF = 25;
    public static final byte CHAR_CLASS_SG = CHAR_CLASS_AL;
    public static final byte CHAR_CLASS_XX = CHAR_CLASS_AL;
    public static final byte CHAR_CLASS_CB = 28;
    public static final java.lang.String[] clsStrs = { "OP",
    "CL",
    "QU",
    "GL",
    "NS",
    "EX",
    "SY",
    "IS",
    "PR",
    "PO",
    "NU",
    "AL",
    "ID",
    "IN",
    "HY",
    "BA",
    "BB",
    "B2",
    "ZW",
    "CM",
    "SA",
    "SP",
    "BK",
    "AI",
    "CR",
    "LF",
    "SG",
    "XX",
    "CB" };
    static byte[][] brkPairs = { { 2, 2, 2, 2, 2, 2, 2, 2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    2,
    2,
    2,
    2,
    0,
    1,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 2,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    2,
    1 },
    { 1,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 1,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    1,
    1,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    1,
    1,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    1,
    0,
    0,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 1,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    2,
    2,
    1 },
    { 0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 } };
    static byte[] quickLut = null;
    static final char[] raw_data = { 0, 8, 9, 9, 10, 10, 11,
    11,
    12,
    12,
    13,
    13,
    14,
    31,
    32,
    32,
    33,
    33,
    34,
    34,
    35,
    35,
    36,
    36,
    37,
    37,
    38,
    38,
    39,
    39,
    40,
    40,
    41,
    41,
    42,
    42,
    43,
    43,
    44,
    44,
    45,
    45,
    46,
    46,
    47,
    47,
    48,
    57,
    58,
    59,
    60,
    62,
    63,
    63,
    64,
    90,
    91,
    91,
    92,
    92,
    93,
    93,
    94,
    122,
    123,
    123,
    124,
    124,
    125,
    125,
    126,
    126,
    127,
    159,
    160,
    160,
    161,
    161,
    162,
    162,
    163,
    165,
    166,
    166,
    167,
    168,
    169,
    169,
    170,
    170,
    171,
    171,
    172,
    172,
    173,
    173,
    174,
    175,
    176,
    176,
    177,
    177,
    178,
    179,
    180,
    180,
    181,
    181,
    182,
    186,
    187,
    187,
    188,
    191,
    192,
    197,
    198,
    198,
    199,
    207,
    208,
    208,
    209,
    214,
    215,
    216,
    217,
    221,
    222,
    225,
    226,
    229,
    230,
    230,
    231,
    231,
    232,
    234,
    235,
    235,
    236,
    237,
    238,
    239,
    240,
    240,
    241,
    241,
    242,
    243,
    244,
    246,
    247,
    250,
    251,
    251,
    252,
    252,
    253,
    253,
    254,
    254,
    255,
    256,
    257,
    257,
    258,
    272,
    273,
    273,
    274,
    274,
    275,
    275,
    276,
    282,
    283,
    283,
    284,
    293,
    294,
    295,
    296,
    298,
    299,
    299,
    300,
    304,
    305,
    307,
    308,
    311,
    312,
    312,
    313,
    318,
    319,
    322,
    323,
    323,
    324,
    324,
    325,
    327,
    328,
    330,
    331,
    332,
    333,
    333,
    334,
    337,
    338,
    339,
    340,
    357,
    358,
    359,
    360,
    362,
    363,
    363,
    364,
    461,
    462,
    462,
    463,
    463,
    464,
    464,
    465,
    465,
    466,
    466,
    467,
    467,
    468,
    468,
    469,
    469,
    470,
    470,
    471,
    471,
    472,
    472,
    473,
    473,
    474,
    474,
    475,
    475,
    476,
    476,
    477,
    592,
    593,
    593,
    594,
    608,
    609,
    609,
    610,
    710,
    711,
    711,
    712,
    712,
    713,
    715,
    716,
    716,
    717,
    717,
    718,
    719,
    720,
    720,
    721,
    727,
    728,
    731,
    732,
    732,
    733,
    733,
    734,
    750,
    768,
    879,
    884,
    912,
    913,
    937,
    938,
    944,
    945,
    961,
    962,
    962,
    963,
    969,
    970,
    1024,
    1025,
    1025,
    1026,
    1039,
    1040,
    1103,
    1104,
    1104,
    1105,
    1105,
    1106,
    1154,
    1155,
    1161,
    1162,
    1415,
    1417,
    1417,
    1418,
    1418,
    1425,
    1469,
    1470,
    1470,
    1471,
    1471,
    1472,
    1472,
    1473,
    1474,
    1475,
    1475,
    1476,
    1476,
    1488,
    1610,
    1611,
    1621,
    1632,
    1641,
    1642,
    1647,
    1648,
    1648,
    1649,
    1749,
    1750,
    1764,
    1765,
    1766,
    1767,
    1768,
    1769,
    1769,
    1770,
    1773,
    1776,
    1785,
    1786,
    1805,
    1807,
    1807,
    1808,
    1808,
    1809,
    1809,
    1810,
    1836,
    1840,
    1866,
    1920,
    1957,
    1958,
    1968,
    1969,
    1969,
    2305,
    2307,
    2309,
    2361,
    2364,
    2364,
    2365,
    2365,
    2366,
    2381,
    2384,
    2384,
    2385,
    2388,
    2392,
    2401,
    2402,
    2403,
    2404,
    2405,
    2406,
    2415,
    2416,
    2416,
    2433,
    2435,
    2437,
    2489,
    2492,
    2519,
    2524,
    2529,
    2530,
    2531,
    2534,
    2543,
    2544,
    2545,
    2546,
    2547,
    2548,
    2554,
    2562,
    2562,
    2565,
    2617,
    2620,
    2637,
    2649,
    2654,
    2662,
    2671,
    2672,
    2673,
    2674,
    2676,
    2689,
    2691,
    2693,
    2745,
    2748,
    2748,
    2749,
    2749,
    2750,
    2765,
    2768,
    2784,
    2790,
    2799,
    2817,
    2819,
    2821,
    2873,
    2876,
    2876,
    2877,
    2877,
    2878,
    2903,
    2908,
    2913,
    2918,
    2927,
    2928,
    2928,
    2946,
    2946,
    2947,
    3001,
    3006,
    3031,
    3047,
    3055,
    3056,
    3058,
    3073,
    3075,
    3077,
    3129,
    3134,
    3158,
    3168,
    3169,
    3174,
    3183,
    3202,
    3203,
    3205,
    3257,
    3262,
    3286,
    3294,
    3297,
    3302,
    3311,
    3330,
    3331,
    3333,
    3385,
    3390,
    3415,
    3424,
    3425,
    3430,
    3439,
    3458,
    3459,
    3461,
    3526,
    3530,
    3571,
    3572,
    3572,
    3585,
    3632,
    3633,
    3633,
    3634,
    3635,
    3636,
    3642,
    3647,
    3647,
    3648,
    3654,
    3655,
    3662,
    3663,
    3663,
    3664,
    3673,
    3674,
    3675,
    3713,
    3760,
    3761,
    3761,
    3762,
    3763,
    3764,
    3772,
    3773,
    3782,
    3784,
    3789,
    3792,
    3801,
    3804,
    3805,
    3840,
    3850,
    3851,
    3851,
    3852,
    3852,
    3853,
    3863,
    3864,
    3865,
    3866,
    3871,
    3872,
    3881,
    3882,
    3892,
    3893,
    3893,
    3894,
    3894,
    3895,
    3895,
    3896,
    3896,
    3897,
    3897,
    3898,
    3898,
    3899,
    3899,
    3900,
    3900,
    3901,
    3901,
    3902,
    3903,
    3904,
    3946,
    3953,
    3972,
    3973,
    3973,
    3974,
    3975,
    3976,
    3979,
    3984,
    4028,
    4030,
    4037,
    4038,
    4038,
    4039,
    4047,
    4096,
    4138,
    4140,
    4153,
    4160,
    4169,
    4170,
    4175,
    4176,
    4181,
    4182,
    4185,
    4256,
    4347,
    4352,
    4447,
    4448,
    4601,
    4608,
    4954,
    4961,
    4961,
    4962,
    4968,
    4969,
    4977,
    4978,
    5750,
    5760,
    5760,
    5761,
    5786,
    5787,
    5787,
    5788,
    5788,
    5792,
    5905,
    5906,
    5908,
    5920,
    5937,
    5938,
    5940,
    5941,
    5969,
    5970,
    5971,
    5984,
    6000,
    6002,
    6003,
    6016,
    6067,
    6068,
    6099,
    6100,
    6100,
    6101,
    6101,
    6102,
    6106,
    6107,
    6107,
    6108,
    6108,
    6112,
    6121,
    6144,
    6149,
    6150,
    6150,
    6151,
    6154,
    6155,
    6158,
    6160,
    6169,
    6176,
    6312,
    6313,
    6313,
    7680,
    8190,
    8192,
    8198,
    8199,
    8199,
    8200,
    8202,
    8203,
    8203,
    8204,
    8207,
    8208,
    8208,
    8209,
    8209,
    8210,
    8211,
    8212,
    8212,
    8213,
    8214,
    8215,
    8215,
    8216,
    8217,
    8218,
    8218,
    8219,
    8221,
    8222,
    8222,
    8223,
    8223,
    8224,
    8225,
    8226,
    8227,
    8228,
    8230,
    8231,
    8231,
    8232,
    8233,
    8234,
    8238,
    8239,
    8239,
    8240,
    8247,
    8248,
    8248,
    8249,
    8250,
    8251,
    8251,
    8252,
    8252,
    8253,
    8259,
    8260,
    8260,
    8261,
    8261,
    8262,
    8262,
    8263,
    8279,
    8287,
    8287,
    8288,
    8288,
    8289,
    8291,
    8298,
    8303,
    8304,
    8305,
    8308,
    8308,
    8309,
    8316,
    8317,
    8317,
    8318,
    8318,
    8319,
    8319,
    8320,
    8320,
    8321,
    8324,
    8325,
    8332,
    8333,
    8333,
    8334,
    8334,
    8352,
    8358,
    8359,
    8359,
    8360,
    8369,
    8400,
    8426,
    8448,
    8450,
    8451,
    8451,
    8452,
    8452,
    8453,
    8453,
    8454,
    8456,
    8457,
    8457,
    8458,
    8466,
    8467,
    8467,
    8468,
    8469,
    8470,
    8470,
    8471,
    8480,
    8481,
    8482,
    8483,
    8485,
    8486,
    8486,
    8487,
    8490,
    8491,
    8491,
    8492,
    8511,
    8512,
    8512,
    8513,
    8531,
    8532,
    8533,
    8534,
    8538,
    8539,
    8539,
    8540,
    8541,
    8542,
    8542,
    8543,
    8543,
    8544,
    8555,
    8556,
    8559,
    8560,
    8569,
    8570,
    8579,
    8592,
    8601,
    8602,
    8657,
    8658,
    8658,
    8659,
    8659,
    8660,
    8660,
    8661,
    8703,
    8704,
    8704,
    8705,
    8705,
    8706,
    8707,
    8708,
    8710,
    8711,
    8712,
    8713,
    8714,
    8715,
    8715,
    8716,
    8718,
    8719,
    8719,
    8720,
    8720,
    8721,
    8721,
    8722,
    8723,
    8724,
    8724,
    8725,
    8725,
    8726,
    8729,
    8730,
    8730,
    8731,
    8732,
    8733,
    8736,
    8737,
    8738,
    8739,
    8739,
    8740,
    8740,
    8741,
    8741,
    8742,
    8742,
    8743,
    8748,
    8749,
    8749,
    8750,
    8750,
    8751,
    8755,
    8756,
    8759,
    8760,
    8763,
    8764,
    8765,
    8766,
    8775,
    8776,
    8776,
    8777,
    8779,
    8780,
    8780,
    8781,
    8785,
    8786,
    8786,
    8787,
    8799,
    8800,
    8801,
    8802,
    8803,
    8804,
    8807,
    8808,
    8809,
    8810,
    8811,
    8812,
    8813,
    8814,
    8815,
    8816,
    8833,
    8834,
    8835,
    8836,
    8837,
    8838,
    8839,
    8840,
    8852,
    8853,
    8853,
    8854,
    8856,
    8857,
    8857,
    8858,
    8868,
    8869,
    8869,
    8870,
    8894,
    8895,
    8895,
    8896,
    8977,
    8978,
    8978,
    8979,
    9000,
    9001,
    9001,
    9002,
    9002,
    9003,
    9139,
    9140,
    9140,
    9141,
    9141,
    9142,
    9142,
    9143,
    9290,
    9312,
    9407,
    9408,
    9423,
    9424,
    9449,
    9450,
    9450,
    9451,
    9547,
    9548,
    9551,
    9552,
    9588,
    9589,
    9599,
    9600,
    9615,
    9616,
    9617,
    9618,
    9621,
    9622,
    9631,
    9632,
    9633,
    9634,
    9634,
    9635,
    9641,
    9642,
    9649,
    9650,
    9651,
    9652,
    9653,
    9654,
    9655,
    9656,
    9659,
    9660,
    9661,
    9662,
    9663,
    9664,
    9665,
    9666,
    9669,
    9670,
    9672,
    9673,
    9674,
    9675,
    9675,
    9676,
    9677,
    9678,
    9681,
    9682,
    9697,
    9698,
    9701,
    9702,
    9710,
    9711,
    9711,
    9712,
    9732,
    9733,
    9734,
    9735,
    9736,
    9737,
    9737,
    9738,
    9741,
    9742,
    9743,
    9744,
    9747,
    9750,
    9751,
    9753,
    9755,
    9756,
    9756,
    9757,
    9757,
    9758,
    9758,
    9759,
    9791,
    9792,
    9792,
    9793,
    9793,
    9794,
    9794,
    9795,
    9823,
    9824,
    9825,
    9826,
    9826,
    9827,
    9829,
    9830,
    9830,
    9831,
    9834,
    9835,
    9835,
    9836,
    9837,
    9838,
    9838,
    9839,
    9839,
    9840,
    10074,
    10075,
    10078,
    10081,
    10081,
    10082,
    10083,
    10084,
    10087,
    10088,
    10088,
    10089,
    10089,
    10090,
    10090,
    10091,
    10091,
    10092,
    10092,
    10093,
    10093,
    10094,
    10094,
    10095,
    10095,
    10096,
    10096,
    10097,
    10097,
    10098,
    10098,
    10099,
    10099,
    10100,
    10100,
    10101,
    10101,
    10102,
    10213,
    10214,
    10214,
    10215,
    10215,
    10216,
    10216,
    10217,
    10217,
    10218,
    10218,
    10219,
    10219,
    10224,
    10626,
    10627,
    10627,
    10628,
    10628,
    10629,
    10629,
    10630,
    10630,
    10631,
    10631,
    10632,
    10632,
    10633,
    10633,
    10634,
    10634,
    10635,
    10635,
    10636,
    10636,
    10637,
    10637,
    10638,
    10638,
    10639,
    10639,
    10640,
    10640,
    10641,
    10641,
    10642,
    10642,
    10643,
    10643,
    10644,
    10644,
    10645,
    10645,
    10646,
    10646,
    10647,
    10647,
    10648,
    10648,
    10649,
    10711,
    10712,
    10712,
    10713,
    10713,
    10714,
    10714,
    10715,
    10715,
    10716,
    10747,
    10748,
    10748,
    10749,
    10749,
    10750,
    11007,
    11904,
    12288,
    12289,
    12290,
    12291,
    12292,
    12293,
    12293,
    12294,
    12295,
    12296,
    12296,
    12297,
    12297,
    12298,
    12298,
    12299,
    12299,
    12300,
    12300,
    12301,
    12301,
    12302,
    12302,
    12303,
    12303,
    12304,
    12304,
    12305,
    12305,
    12306,
    12307,
    12308,
    12308,
    12309,
    12309,
    12310,
    12310,
    12311,
    12311,
    12312,
    12312,
    12313,
    12313,
    12314,
    12314,
    12315,
    12315,
    12316,
    12316,
    12317,
    12317,
    12318,
    12319,
    12320,
    12329,
    12330,
    12335,
    12336,
    12346,
    12347,
    12348,
    12349,
    12351,
    12353,
    12353,
    12354,
    12354,
    12355,
    12355,
    12356,
    12356,
    12357,
    12357,
    12358,
    12358,
    12359,
    12359,
    12360,
    12360,
    12361,
    12361,
    12362,
    12386,
    12387,
    12387,
    12388,
    12418,
    12419,
    12419,
    12420,
    12420,
    12421,
    12421,
    12422,
    12422,
    12423,
    12423,
    12424,
    12429,
    12430,
    12430,
    12431,
    12436,
    12437,
    12438,
    12441,
    12442,
    12443,
    12446,
    12447,
    12447,
    12448,
    12449,
    12450,
    12450,
    12451,
    12451,
    12452,
    12452,
    12453,
    12453,
    12454,
    12454,
    12455,
    12455,
    12456,
    12456,
    12457,
    12457,
    12458,
    12482,
    12483,
    12483,
    12484,
    12514,
    12515,
    12515,
    12516,
    12516,
    12517,
    12517,
    12518,
    12518,
    12519,
    12519,
    12520,
    12525,
    12526,
    12526,
    12527,
    12532,
    12533,
    12534,
    12535,
    12538,
    12539,
    12539,
    12540,
    12540,
    12541,
    12541,
    12542,
    12727,
    12784,
    12799,
    12800,
    55203,
    55296,
    57343,
    57344,
    63743,
    63744,
    64106,
    64256,
    64285,
    64286,
    64286,
    64287,
    64829,
    64830,
    64830,
    64831,
    64831,
    64848,
    65019,
    65020,
    65020,
    65024,
    65059,
    65072,
    65076,
    65077,
    65077,
    65078,
    65078,
    65079,
    65079,
    65080,
    65080,
    65081,
    65081,
    65082,
    65082,
    65083,
    65083,
    65084,
    65084,
    65085,
    65085,
    65086,
    65086,
    65087,
    65087,
    65088,
    65088,
    65089,
    65089,
    65090,
    65090,
    65091,
    65091,
    65092,
    65092,
    65093,
    65103,
    65104,
    65104,
    65105,
    65105,
    65106,
    65106,
    65108,
    65109,
    65110,
    65111,
    65112,
    65112,
    65113,
    65113,
    65114,
    65114,
    65115,
    65115,
    65116,
    65116,
    65117,
    65117,
    65118,
    65118,
    65119,
    65128,
    65129,
    65129,
    65130,
    65130,
    65131,
    65131,
    65136,
    65276,
    65279,
    65279,
    65281,
    65281,
    65282,
    65283,
    65284,
    65284,
    65285,
    65285,
    65286,
    65287,
    65288,
    65288,
    65289,
    65289,
    65290,
    65291,
    65292,
    65292,
    65293,
    65293,
    65294,
    65294,
    65295,
    65305,
    65306,
    65307,
    65308,
    65310,
    65311,
    65311,
    65312,
    65338,
    65339,
    65339,
    65340,
    65340,
    65341,
    65341,
    65342,
    65370,
    65371,
    65371,
    65372,
    65372,
    65373,
    65373,
    65374,
    65374,
    65375,
    65375,
    65376,
    65377,
    65378,
    65378,
    65379,
    65380,
    65381,
    65381,
    65382,
    65382,
    65383,
    65392,
    65393,
    65437,
    65438,
    65439,
    65440,
    65500,
    65504,
    65504,
    65505,
    65505,
    65506,
    65508,
    65509,
    65510,
    65512,
    65518,
    65529,
    65531,
    65532,
    65532,
    65533,
    65535 };
    static final byte[] raw_classes = { CHAR_CLASS_CM, CHAR_CLASS_BA,
    CHAR_CLASS_LF,
    CHAR_CLASS_CM,
    CHAR_CLASS_BK,
    CHAR_CLASS_CR,
    CHAR_CLASS_CM,
    CHAR_CLASS_SP,
    CHAR_CLASS_EX,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_IS,
    CHAR_CLASS_HY,
    CHAR_CLASS_IS,
    CHAR_CLASS_SY,
    CHAR_CLASS_NU,
    CHAR_CLASS_IS,
    CHAR_CLASS_AL,
    CHAR_CLASS_EX,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_PR,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_BA,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_GL,
    CHAR_CLASS_AI,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_AI,
    CHAR_CLASS_BB,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_QU,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_BB,
    CHAR_CLASS_AI,
    CHAR_CLASS_BB,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_IS,
    CHAR_CLASS_BA,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_PR,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_NS,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_SA,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_NS,
    CHAR_CLASS_BA,
    CHAR_CLASS_NS,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_BB,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_BA,
    CHAR_CLASS_ZW,
    CHAR_CLASS_CM,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_BA,
    CHAR_CLASS_B2,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_OP,
    CHAR_CLASS_QU,
    CHAR_CLASS_OP,
    CHAR_CLASS_QU,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_IN,
    CHAR_CLASS_BA,
    CHAR_CLASS_BK,
    CHAR_CLASS_CM,
    CHAR_CLASS_GL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_AI,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_NS,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_EX,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_NS,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CM,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_CM,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_SG,
    CHAR_CLASS_XX,
    CHAR_CLASS_ID,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_CM,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_NS,
    CHAR_CLASS_EX,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_ID,
    CHAR_CLASS_AL,
    CHAR_CLASS_GL,
    CHAR_CLASS_EX,
    CHAR_CLASS_ID,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_EX,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_ID,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_CB,
    CHAR_CLASS_AI };
    public TextLineBreaks() { super(); }
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
       "O1fV+aOPffZzv/bAW36onCiWw1XR+r2nH4ld/8TrmgdZJeT7jyXyeCGAZyqn" +
       "DCmuXLl+fvTll4JEjqwgya3+7bt51qVdeHapDM4u7R6HvfNdl+hxr39lhNB9" +
       "/tI7Lrlaus/5OtlZvOedly9fftcrL/v+8ch21eixK3ccrR/snwWUnVgk33/U" +
       "Pz94dv8cHvfPcdfcaWuusXuS841F8n37hgv6h7tKR0AeOwHStT1XK+ZqR3m7" +
       "5xaWd/n4YWaeubkOaVj5khv3P112w0k4/wvv+x/PCF9pvvsmHli89ZR6nCb5" +
       "A/THfgn7IuUfHVZuOw7ur3vSeW2lV64N6e8NtTgJXeGawP4tO+GX8iuSF86Z" +
       "U/7UOXk/UyQ/mUfzSiHfXXecU/xnN5VTtv49N2nrtbxT7tkr9j2vN0L865sz" +
       "+gfKAKVLITx/Zcyc5Zl+/gJo792jvff1xoFfuTjaLnUW2n97AbT37dHe93r+" +
       "/9MXR8uKZ6H99xdAe/8e7f3noC0R/aeLo8XOlO1vXgDtA3u0D5yD9vbi4ncv" +
       "jnbEn4X2v14A7YN7tA+eg/aO4uIPLo62Pz0L7ecvgPahPdqHzkF7Z3Hxvy6O" +
       "lp+dhfaPL4D24T3ah89Be1dx8RcXR0ucqQl/eQG0j+zRPnIO2rvzi4PbL46W" +
       "4c5Ae3DHBdA+ukf76Dlo7ymI338LaMdnoX3gAmgf26N97By09xbEH78Fn3CW" +
       "vz144gJoH9+jffwctPcVxJ+9OFrkLH978JYLoH1ij/aJc9DeXxB/8Ras7KwZ" +
       "zMFLF0D75B7tk+egLR5KHHzpLaAdnYX2yy6A9qk92qfOQVssFxyAF0eLn+Vv" +
       "D1oXQPv0Hu3T56B9qCD+FRdHiyJnoX3HBdC+aY/2Teegfbgg3rsFtOhZaPsX" +
       "QPvMHu0z56B9pCBO3QLaxllo6QugffMe7ZvPQftoQVy4ONr55Cy04gXQPrtH" +
       "++w5aB8riH/NxdF26bPQvusCaJ/bo33uHLSPF8TVW4jBzrQy7QJo37pH+9Zz" +
       "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" +
       "a3dcl0Kr+BxcY6rMsj2aFhvoYBoJrIOJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9bWuMx6eQorq1MRZGGT83Ais2WwRTofwRFqmVXm9hLOGN9a3Di4ILIuZHM4a" +
       "cH8U6tXFhN+QLOxAHiZGYxgBGj6u43W2FfMOkAyhTZSuZypYs5CJVZWGzeVg" +
       "OnQ1yoQDAary0BSj5ZHBLLGWRjeYtjPKZpq2VvpqbTgQask4jUkzhXQg0phx" +
       "2slmDSUUagE1wJuRGq/9FdQEBMbxOiJmjXo6XFXWsLCsNoDlYhJkC2dcC2KH" +
       "zvQqPIV1CF+m2zkMMjQ/tRKmQ6qq0wDQ7RpeGz273UmVRm86RJtLV7fHbLVn" +
       "gNG6v+3KANhl4gkq+lwkD+MWya8jeaumyLBH6U3IiJshbduq0bDRgO4BOh+E" +
       "6hZSqGm9sZ2qjYFIrBm7jqx9sDPwe1EvNLpraAYDWtXptZbgTGUWIIvRjRUt" +
       "kkHQULxmXJ1OzI7eHtfmiY80+JXemCWOVcf7kdkLrDXZ5BBcYuNxFZc8RUf7" +
       "s7jnTvvVltkFx7PhABJdto6ErYVlIypvKcyAzs242keXI9VGqd6aW1uujpvN" +
       "cKq1BpDqh6vEMK2xqCRURuVTNsZlXSZbgRtuMzM29MwY1QB2DCRGG2XGUNII" +
       "tGoLb0Eq3KGqgCfl8yq5jyozMoZaI8z289hiPnbWbW5U9ScZz21r/BZ3oiRe" +
       "Bzre6ywX9Lqe1UEjaBM1GRmIeYSax6FkszYDp0uK9ZcLz+R6/VGUZFJaHyDs" +
       "MsZ7jXWnrnVUDozbVKYTLs9uavOBGOmz6nrWJHSnlU9O1tzAsfXuyJl4TU8U" +
       "OMlYTpZAr9FwrDjEZ9KUGXNOGFjSMrQ0lFAX5EQP81Ez1w6tk49FjUiDfGo8" +
       "6k7jaDBwQhOuUbwirztVuKnaY4UB3EVSQ5rLpK1tiHDNzrl5sppWm7BuMiML" +
       "nEKgy8c1M2Jk3IPm460YKFspSBvDYVqXMLWWDPmBse0wGtKG8qGqmQ6pxSKl" +
       "knU+nZxsLMlSe/G273UtvxNPg253iUFq7M+kEb7qMLWaqyIiJ9GSykkTxGxP" +
       "WzgoNDgXZFv5AMIF+dxUhtBU4oBalKxdA0aDebiUWJX1jLADwV0R6HYVG/f4" +
       "qc9WuyvMNxNGQgdIF99MhmawWKFVbKWO6UavFnArsyvKS1tbsIgt4/JquGRt" +
       "JjXcPLzW1hzv90TMXxb1JSRANXzk8W6LFQwfZuttceINWdnRQFjExa7XA9k4" +
       "b5zsKQMqAOR0ms8cWRv1wOmKRvwpwa6XaW0odIhhe4pumzY3MbGuaDG4nGaG" +
       "hODdWbvvV8U+SCoi3NOqZH/IOQqVzpE5G7C6VT9quxi3yEFtatiEsGlEpDdg" +
       "B2l41DYewG1KxGcULxBgkwZRfsQajI4oAk+vmDSZbpixZrcXLRoRwxFOdlrG" +
       "gBh10Q4tKHn+yvGz5kjDDB8NZtNlzHJsYOQxQIHcG6UJq63nVZ0Q+L631YZg" +
       "lBJeyg4DDvFHGQt0OdllLHjodfvBdqxCEdIP0hRtcWydyYwmyjcStkU1ViZJ" +
       "Sdl6NEN4o2bo+QC6l0tCWTCZcF2x5XY7YxYTZyOxpThxzjrIUqtQzft0bJJI" +
       "za4yo56M9DHQsKZpfde2ZpNULWiabaS2zPO77Z6I0tS6KzaHvc5wKE8tfNCW" +
       "ILbelbcA7qD5uauQQH8e8LmOhcFUDgftCZ53WgA2zRiZ8zKrL7kS3CDjElKF" +
       "tC7b92eismj0EZ+b5d1C7LMn69ZcIPpZ36NyuVi5XLYsZeqbqrwyq/1sW486" +
       "MlXLPSjftlhQH6myjy2nE0OYmDzB8rV5dTAMRm6Tm2qo3py5dC5TfQOJDgeu" +
       "64xkaHVj3XP3cmyhEYz7nNoVx8NFElvNXltsEaONC+kzi2RsdNzNJ6euyWmW" +
       "098upO2amSFOM6qP0Aho8203GmHUlod70bi/SDNqMOmA0SjsjLfKnEl8ZjTf" +
       "NqbmCCRnk1YH2TQheIk1q3yvs1YL+0IVomNsA2Ydj7o27CS9dDshchOt11Z6" +
       "h95qbIZ3VjMph9LlO1NQ05kpmlbd8QxLliaKjVXCBuK0Spgbo8814pBuTzvJ" +
       "cpTHUkRn3hd9ZLSqz9s11lX6g66Uh/OjlbXUhWnWFocrTJjFhC+rrbkejFa6" +
       "4UKmt6A1oeagQjhYbXyxx61wZR1MyE6b5BJZjqsKnGiIp+Uj+RjlYWQmqQOq" +
       "O87mMjipK9wE5ghh1esuNuhSlKlmu9fd1hVTk5ugzS87ut9Ea3GYVhsNuQ3Y" +
       "DUrydAWpag2STFGC0mZZbUiOYtEexCDf1sPqagIHs7jD0E2O7cp+hvDNIHXX" +
       "Na6r4oIhA1gg1BaIS4KRYPHbRQiMLUGmp2w2lbX1QGz3h+F44oqI2p4tkarE" +
       "sXgDrDpTbM10mVxVTG+W2qJHTfDuSAVCD3Xwmlo3Jdhrco2ulg8ZTNIBmaXv" +
       "khhBdDzRphCwuh4O1VrobqoNPQM9p5pHSdN12lvD5rpL6b1J3O1pI4mYKZuF" +
       "pNbqswnWkUQUbrexOVY3MbJDYtFiWkWAZR7xQRt1nMfaxFaCt7jlzzSYwiGV" +
       "xyPXcLd9wud6qgEzik9LNWzZqdfE0KgaK2rcyYRoINAsHo2rG7zu51PaNric" +
       "9SfVYSPzhShZbsCO3hVUoLOUAVReJlssSH2/mvDDEe/5IwldbVcrYoutqSVs" +
       "hdqSXCvVkCeqa7PXbHuJBQ0WMh9jWQYFCqLVwwaPQApeTcbGZIn6+FwwIwfu" +
       "S6SoMJpImWtIbJN438QgmoLDkWsDlBe0B2G/F7WMNaUzUbjFgTBBUm+LWCzW" +
       "bvKJXYPmc6sRhKN8Wu8JajgamHnsYmQIC6BIf9DkonS4FVsLza63silL1hvx" +
       "VIyqPrSaCC5saeuJgJHbqRfU11I+sTV6skvQtlHHQr6zGsmgjm6WncZwgvki" +
       "BfbltpwMBxq3NX262gEdvyZWrXgTmq1NXaSkzlgc2VNiZDN2r+bMdKQHIwxp" +
       "RIRLDSS4w5GeFbZCIx0JUHNkQTV4KrFwK5C9FouRyDABx0luLENcYzm4wYVk" +
       "tlpUhc3Q4ccTK2w3LM30zA0GK61lp9nDImjqTZtkqme0ybjYypvm3nxSdxvk" +
       "QgAouB30G0YWY5EXmwyhBknWlHqYP/EVZz13RL693PbavdnWqaKQM9yCxDox" +
       "2OrSC/WUX84DIMOGE7Y+gLJJR0CaXXFDBowOu0OcloNG5gzErQVF3Azk2jJL" +
       "THttR4MMUnXS7aCJj1tMHtKausI2+AUwVNqwt+X1VptvwtW5oJNL3tKYxRiC" +
       "AMYBNIJVx5a2ycIWTJCiY/DhrDadBTEpeI3hSJ3YrUlVliUcVoG44c8Zf5Pi" +
       "eNCMwYbcNV0LJnrgdKT4C2oMK+gSqstM6K6bc08np15mZf2a2F9ii4TqQYYT" +
       "j7dDGpo7vFHdLDiVHi83+YxWmsIwlLZCDq4Dy2Fz7al5aAkkkgBaa3yxDgeM" +
       "XMcbbdIbehCZjVinpS2HDUCC6uxg6PZ4TJzXIziZE31wJU4kROHaQpDO0oEy" +
       "RgZcTcjv6YSpw5gxwnjQomsbHeh5c38WYlxNrjsSbiY+30ZkEtTrSyxZLKTF" +
       "dMpNInzUllZ4GxUUgMU6rCaCTpz4IJDZVVgI1KW2gNcDtAVbNtStqwzQa84j" +
       "l0RnPIsUrwUe3uT3B4+US03Hu4RdYJFpl/V8kbx0vDJX2S8c33AbnrLk0/uF" +
       "wCisvOVGm3+VH5d/5H2vvqaOv7d+tNdAHFfuiT3/y2xtrdlXkbpjt455DKP8" +
       "EqZ4ubG5h9E8vUB4wui5S+qnVjCvXjV9Iq689Ia26SgoHT5147XQwzcXyaNx" +
       "5WHdKjb8cnxb25QbTZWLuse9cfjY662PXU34lETKl3Kgym6vj8rR+Q1K5GTJ" +
       "+Q2J5ZmzxLL7Grbk96VzZFGsZh9eiiv3FbKg9htgnLV+uPYs9UQ0z9+CaMpX" +
       "zev58am9aD71/180pXGVDLbPYb5TJPW48nRUCkvwjrcc6161Mn3CdeMWuC4/" +
       "Xvji/Pj1Pde//tfD9U790XO4LhzT4Tty9Te0uDCe8ij4LQp/4ITbr7wFbsvP" +
       "YIrNY/5wz+0f3iy3f+vG3F7NzOicvOKF6EMirjywSCxbZU9e1TmsnnA5vBku" +
       "N3HlwWu3piv21nr6um0vd1s1Kj/02kN3P/Wa+Ou7j+6PtlO8h6rcrSe2ffVW" +
       "SFdd3+mHmm6VjN+z2xjJL7mZxJU33XDDvNxAi1MB+FDalZ/HlcfPKh9XbsvT" +
       "q0u+K9eF0yXjyh3l+epy744r956Uiyt37i6uLqLk1PMixaXqH/mnq77R3+0d" +
       "tTm4dlg66ozKo6/XGVeNZC9c8618uUHp0XftCbPfpOfjrw1HX/eF9vfutplT" +
       "bHm7LajcTVXu2u14VxItvo1//obUjmjdib/85w9+4p6XjsbGB3eAT/T4Kmxv" +
       "PXsft77jx+XOa9t/8dSPfsX3vfZb5RY3/w9yisdfOVYAAA==");
}
