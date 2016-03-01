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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dDrr+shv+snMd8dQmph8v1iCioyzSsnY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
