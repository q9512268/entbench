package org.apache.batik.util;
public abstract class SVGTypes {
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_INTEGER = 1;
    public static final int TYPE_NUMBER = 2;
    public static final int TYPE_LENGTH = 3;
    public static final int TYPE_NUMBER_OPTIONAL_NUMBER = 4;
    public static final int TYPE_ANGLE = 5;
    public static final int TYPE_COLOR = 6;
    public static final int TYPE_PAINT = 7;
    public static final int TYPE_PERCENTAGE = 8;
    public static final int TYPE_TRANSFORM_LIST = 9;
    public static final int TYPE_URI = 10;
    public static final int TYPE_FREQUENCY = 11;
    public static final int TYPE_TIME = 12;
    public static final int TYPE_NUMBER_LIST = 13;
    public static final int TYPE_LENGTH_LIST = 14;
    public static final int TYPE_IDENT = 15;
    public static final int TYPE_CDATA = 16;
    public static final int TYPE_LENGTH_OR_INHERIT = 17;
    public static final int TYPE_IDENT_LIST = 18;
    public static final int TYPE_CLIP_VALUE = 19;
    public static final int TYPE_URI_OR_IDENT = 20;
    public static final int TYPE_CURSOR_VALUE = 21;
    public static final int TYPE_PATH_DATA = 22;
    public static final int TYPE_ENABLE_BACKGROUND_VALUE = 23;
    public static final int TYPE_TIME_VALUE_LIST = 24;
    public static final int TYPE_NUMBER_OR_INHERIT = 25;
    public static final int TYPE_FONT_FAMILY_VALUE = 26;
    public static final int TYPE_FONT_FACE_FONT_SIZE_VALUE = 27;
    public static final int TYPE_FONT_WEIGHT_VALUE = 28;
    public static final int TYPE_ANGLE_OR_IDENT = 29;
    public static final int TYPE_KEY_SPLINES_VALUE = 30;
    public static final int TYPE_POINTS_VALUE = 31;
    public static final int TYPE_PRESERVE_ASPECT_RATIO_VALUE = 32;
    public static final int TYPE_URI_LIST = 33;
    public static final int TYPE_LENGTH_LIST_OR_IDENT = 34;
    public static final int TYPE_CHARACTER_OR_UNICODE_RANGE_LIST = 35;
    public static final int TYPE_UNICODE_RANGE_LIST = 36;
    public static final int TYPE_FONT_VALUE = 37;
    public static final int TYPE_FONT_DESCRIPTOR_SRC_VALUE = 38;
    public static final int TYPE_FONT_SIZE_VALUE = 39;
    public static final int TYPE_BASELINE_SHIFT_VALUE = 40;
    public static final int TYPE_KERNING_VALUE = 41;
    public static final int TYPE_SPACING_VALUE = 42;
    public static final int TYPE_LINE_HEIGHT_VALUE = 43;
    public static final int TYPE_FONT_SIZE_ADJUST_VALUE = 44;
    public static final int TYPE_LANG = 45;
    public static final int TYPE_LANG_LIST = 46;
    public static final int TYPE_NUMBER_OR_PERCENTAGE = 47;
    public static final int TYPE_TIMING_SPECIFIER_LIST = 48;
    public static final int TYPE_BOOLEAN = 49;
    public static final int TYPE_RECT = 50;
    public SVGTypes() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALWbe3AbxR3HV3L8dmLHiZ23kzhOIC8rzhNweMiybF8iS0KS" +
                                                              "TeO0KGfpbCs5S5e7laME0hCmkJROM7SER3mkzBCmlAmEMqXtwBDSgRY6QGko" +
                                                              "pTymQOEP6AAzZKYQHgW6v709vaw96M7UMzpt7nZ/3/3s/va3e8ruiQ9RuaGj" +
                                                              "Vk1OxuV2vFdTjPYgpIOybihxjyobRoTcjcZu+OdNB879tfqgE1UMoWljstEf" +
                                                              "kw2lJ6GocWMILUgkDSwnY4rhV5Q4lAjqiqHoEzJOpJJDqClhSOOamoglcH8q" +
                                                              "rkCGQVn3oekyxnpiOI0ViRnAaKGP1sZFa+NyF2fo9KG6WErbmyswt6CAJ+8Z" +
                                                              "5B3P6RkYNfh2yhOyK40TqsuXMHBnRkcrtZS6d1RN4XYlg9t3qhtYQ2zxbZjU" +
                                                              "DK0P1X/yxY1jDbQZZsjJZApTRCOkGCl1Qon7UH3urldVxo3d6PuozIdq8zJj" +
                                                              "1OazRF1E1EVELd5cLlL7qUoyPe5JURxsWarQYlAhjBYXGtFkXR5nZoK0zsRC" +
                                                              "FWbstDChXZSltbq7CPHmla6jt17Z8HAZqh9C9YlkGKoTI5XARGSINKgyPqzo" +
                                                              "hjseV+JDaHqSdHhY0ROymtjHervRSIwmZZwmLmA1C9xMa4pONXNtRXqSsOnp" +
                                                              "GE7pWbwR6lTsX+UjqjxKWJtzrCZhD9wngDUJUjF9RCa+x4pM2ZVIxqkfFZbI" +
                                                              "MrZtJRlI0cpxBY+lslJTkjK5gRpNF1Hl5KgrTJwvOUqylqeIC+rU1zhGoa01" +
                                                              "ObZLHlWiGM0uzhc0H5Fc1bQhoAhGTcXZqCXSS3OLeimvfz70bz5yVbIv6UQO" +
                                                              "Uue4ElOh/rWkUEtRoZAyougKGQdmwboVvlvk5scPOxEimZuKMpt5fnv12ctW" +
                                                              "tZx+xswzr0SewPBOJYajsePD087M9yy/sAyqUaWljAR0fgE5HWVB9qQzo5FI" +
                                                              "05y1CA/brYenQ3/cds39yvtOVCOhilhKTY8TP5oeS41rCVXRe5WkostYiUuo" +
                                                              "WknGPfS5hCpJ2pdIKubdwMiIoWAJTVHprYoU/TdpohFiApqohqQTyZGUldZk" +
                                                              "PEbTGQ0h1EA+qIl85iPzj35jFHWNpcYVlxyTk4lkyhXUU8APHUpjjmKQdJw8" +
                                                              "1VKuYeL/u1Z3tG9yGam0ThzSldJHXTLxijHFfGg2SXiwN0LbExxN+/9LZIBy" +
                                                              "xh6Hg3TA/OLhr5KR05dS44oejR1Nd3nPPhh91nQtGA6sfTBqITrtpk471TE7" +
                                                              "0NJBDgc1PxP0zEekZ3aRMU6CbN3y8Pe27DjcWkacStszhTQrZF02adLx5IKB" +
                                                              "FcGjsRNnQudeeL7mfidykngxTCadXORvK4j85sSlp2JKnIQe3hxgxUEXP+qX" +
                                                              "rAc6fdueg4MH1tB65AdzMFhO4hAUD0IIzkq0FQ/iUnbrD733yclb9qdyw7lg" +
                                                              "drAmtUklIUq0FndmMXw0tmKR/Ej08f1tTjSFhB4SbrFMhgeJZC3FGgXRotOK" +
                                                              "vMBSRYBHUvq4rNK+ZuGyBo/pqT25O9TLpsOlyXQ4cIeiCtKgfXFYu+uVP/9r" +
                                                              "HW1JK77X503MYQV35sUUMNZIo8f0nHdFdEUh+f5xW/Cmmz88tJ26FsmxpJRg" +
                                                              "G1w9JJaQ3iEteN0zu199843jLzlz7ojJpJoeJuuTDGWZ+TX5c5DPV/CBOAA3" +
                                                              "zHjQ6GFBaVE2KmmgvCxXNxKfVDKAwTnaBpLE+RIjCXlYVWAs/Kd+accjHxxp" +
                                                              "MLtbJXcsb1n1zQZy9+d0oWuevfJcCzXjiMH8mGu/XDYz6M7IWXbrurwX6pE5" +
                                                              "+OKCnz0t30XCNwmZRmKfQqMgou2BaAeup23hotd1Rc82wqXNyPfxwmGUt46J" +
                                                              "xm586aOpgx+dOktrW7gQyu/3flnrNL3I7AUithCxS0FUhqfNGlxnZUgdZhUH" +
                                                              "nT7ZGCPG1p/2f7dBPf0FkR0isjESLo2ATiJdpsCVWO7yytd+/2TzjjNlyNmD" +
                                                              "atSUHO+R6YBD1cTTFWOMBMmMdullZj32VFlzRgZNaiFo9IWlu9M7rmHaAft+" +
                                                              "N+vXm39x7A3qhabbzaPF1xmwSCuOjXSlnRvWH7x+xztPnLun0pynl/NjWVG5" +
                                                              "2Z8H1OFr3/50Uk/QKFZiDVFUfsh14s65nkvep+Vz4QRKL8lMnl1IwM2VXXv/" +
                                                              "+MfO1oo/OFHlEGqIsVXtoKymYSQPkZWcYS11ycq34HnhqsxcgnRmw+X84lCW" +
                                                              "J1scyHKzGklDbkhPLfK62dCLXsv9rO98r6OTnelDUKV2iSxCRxW98e27j587" +
                                                              "eOgCJ4yq8gmoOmmVhlw+fxoWz9efuHlB7dG3fkT73jLdR+WX0uv5cFlJ3aEM" +
                                                              "kqtIgDLoOhwTnERSVjPZylKXm2VTWYzqItuC3uiAf6s/cIWfDto894IXsnB6" +
                                                              "2MBBPTFOAu4EWy6ebD63+6nKfd3WUrBUETPnVqP/hUf73o3SgF4FU3TEati8" +
                                                              "ydetj+ZNFA1wWQ2j18Z5i2rk2t/45q4733vArFGxpxZlVg4fveHr9iNHzUBr" +
                                                              "vhIsmbQqzy9jvhYU1W6xnQot0fPuyf2P3bf/kFmrxsIFrpe8vz3w8pfPtd/2" +
                                                              "1p9KrKrKEuy1DqKHI7s0ai5ubBOpouOuzw5c/0qAzOUSqkonE7vTihQv9OlK" +
                                                              "Iz2c1/q5l42cnzM4mNIwcqzQNDZdw3UTXCTTuTq5sa5r8khZxJxvUYmRAokt" +
                                                              "gAaJuJ2bwyUAl2AJ/+ZJWP4t+SPeXm8I7g0UESkCRIuZ3GIbIickxoWJeBIY" +
                                                              "1VIi/0B/V2mgpABQK1NrtQGilZ4QBuJJWEA+r7830lcKaI8A0BKmtsQGaAok" +
                                                              "DggD8SQwmpfXQ9FAMCIF/G6fTY9dIwDYxtTbbADLIXFYGJAngVENBXT7e33e" +
                                                              "Ujw/FOBZysSW2vBUQOInwjw8CYvHE/AFSvbPTwV4ljGxZTY8lZC4XZiHJ2Hx" +
                                                              "BN0k7JXiuUOA5zwmdp4NTxUk7hHm4UmQNwGTxxvyeP0Rd29JpzsuAHU+Uzzf" +
                                                              "BqoaEieEoXgSGM2gUJGQ2x/uCYT6oz4pXLK3HvgfwXrIZzlTXW4DVgOJR4TB" +
                                                              "eBIYVZlLypBUiuY3AjQrmNQKG5paSJwSpuFJYDSN0vSEvJcPeP2ebaWYnhBg" +
                                                              "WskEV9ow1UHiaWEmngRG1abrSf0lR9IzAjirmNYqG5ypkPiLMA5PAqOG/PmW" +
                                                              "N4zOCFCtZpKrbaimQeJVYSqehEVlLou4VK8JULUzyXYbqnpIvC1MxZOwpiap" +
                                                              "21t6anpHgMfFxFw2PPTF5n1hHp5EdunQ7Y64S/F8IMCzhomtseGhP6b+W5iH" +
                                                              "J4FRc77XBULkzanPG5JK9tXHAmwdTLjDhq0REl8Ks/EkrGUE9T3ugPpKAGot" +
                                                              "U1xrAzWDJBwVwlA8CQvK45OC0UG3b6BURHdUCkCtY4rrbKBmgvF6YSieBEbT" +
                                                              "rSUEdUFOsHA0CGCtZ5rrbbCawPhsYSyehIXlGQiFCRa3t+YIYG1gmhtssJrB" +
                                                              "+GJhLJ6EtUQKuknE4MRBR6sA00YmuNGGaRYYXyHMxJPAaD5l8vrdXT5vtMvt" +
                                                              "2dobCgz4u/m9tlKAcBOT32RDOBuMrxMm5ElgNDO7CDSheCHRsV6A7AIme4EN" +
                                                              "2RwwvlmYjCdhzWHW7y92c5jjYgG2C5nwhTZsc8G4V5iNJ2Gx9QTIFNbj7pd8" +
                                                              "2/ge2SPAdhETvsiGbR4Y9wuz8SQwasln87BUWBry8hkDAoydrAKdNozzwfgV" +
                                                              "wow8iYL+u8Ir9fZF+GzfEWDbzIQ327AtAOM7hNl4EtYvGvRnQdt5WxYAu5ip" +
                                                              "XmwD1gLGE8JgPAmr07Z6t0XDQZ/k94b5nbZTgO0SJnyJDdtCMK4Ls/EkrDVJ" +
                                                              "MCD5IzZYhgDWpUzzUhusRWD8KmEsngRGi0yskDfsDQ0SpwwHvZ5INOSOSAE+" +
                                                              "5dUClCyr+c2hXAzGfyBMyZPAaGp2ncybvK8TQHIzPbcNUisY/7EwEk8CoznF" +
                                                              "P3vYhpIjAnhdTLvLBm8JGL9FGI8ngVGb+QrQ5w65PRFzeTLglzyBbi9xTn8v" +
                                                              "fxV2qwCph1XDY0PaBsZ/LkzKk8BoFttZ8G3g7haA62bK3TZwS8H4fcJwPAnr" +
                                                              "rZtO49xo8ksBKC9T9NpALQPjvxKG4kkUrL+6vWFPSApGiHuGQx4+48MCjD2s" +
                                                              "Aj02jOeB8UeFGXkS1lvPt1hZPiZA1stke23IAMTxpDAZT8IKnF3usBeWKNFw" +
                                                              "n9Rj45xPCeD1Me0+G7zlYPw5YTyeBEaNbA0W8kv+Xj7X8wJcEhOVbLhWgPG/" +
                                                              "CXPxJCyucNDtseV6WYBrCxPdYsO1Eoy/IczFk8j+kAyu2PcNLzpvCrBtZcJb" +
                                                              "bdig6o53hdl4EtYGj1wQcXdvGQjbAL4nAOhj6j4bwNVg/CNhQJ6E9R+EPjJn" +
                                                              "l8I5K4DTz7T6bXDawfhnwjg8CesHSsDhrkA+F2DyM0G/DZOLJJxOYSaehBXu" +
                                                              "cz9y2e6OcJYJ4AWYdsAGbw0YrxXG40lgNNf6dRKiIry8ST0S/393nXUCfEEm" +
                                                              "HrTh6wDjM4X5eBLWvsSuQMDndftLETUJEF3O5C63IVoLxhcIE/EkrJgRIq/Z" +
                                                              "pXBabHAypWtDd1CuwqhKHjawLsdwrjr0rx7x9/7TnPPYnntDRwt4h+boPt3j" +
                                                              "1x49Fg/c2+FkRxi2Exqc0laryoSiFpgitbHONcFO/tmTTkyap/xiDx6rr5p1" +
                                                              "bODv9GxN9iRenQ9VjaRVNX+jeV66QtOVkQStQZ257Zzuv3V2YNRU8owVRlPg" +
                                                              "C2roXGPmXY9RQ3FejMrpd36+TRjV5PJhVGEm8rNchFEZyQLJTo22wmycv2Hd" +
                                                              "3GufcRS2tdXj6BsdOK97lhRs9KanVa0tzmnzvGo0dvLYFv9VZzfea54Niqny" +
                                                              "vn1gpdaHKs0TSNQoHJdZzLVm2aroW/7FtIeql1odXnA2Kb9ukCb1d9BzPHOL" +
                                                              "DssYbdkzM68e33zq+cMVLzqRYztyyBjN2D75VEJGS+to4XZfqS3cg7JOz/F0" +
                                                              "1ryz44VPX3M0WgcAYNN3i12JaOymU68HRzTtdieqllA58WclQ49MdO9NhpTY" +
                                                              "hF6wI7xiOJVOZg+2TgPXlOEkK20Z1qBTs3fh2BhGrZM3x08+SlejpvYoehdY" +
                                                              "BzNTC327Jq1p+U9py0bhsjoDLU18Lerr1zR2mqq2h7a8psFwdtIAueO/VXwR" +
                                                              "I5I+AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALWceazr2HnY9d7s45l5b/axPZ71je0ZzTxRlKgl442iSIoU" +
       "RVJctLBJXiiSEklxExdxSaaJg6Y2mtY10LHrArbRP2y0COw4KGK0QOtiijZt" +
       "irgFUrgrmjgIUjRBYiAGmgV10pSUdN+97869cqSi90LUueQ5H3/nO9/3ncPv" +
       "kvza90r3BH6p7LlWurDc8KaWhDdNC7oZpp4W3CQpiJX9QFMRSw4CId93S3np" +
       "l6798Q8+q1+/WrpXKj0uO44byqHhOgGnBa611lSqdO10L2ppdhCWrlOmvJYr" +
       "UWhYFcoIwjep0nvONA1LN6gThEqOUMkRKhuECnxaK2/0sOZENlK0kJ0wWJX+" +
       "aukKVbrXUwq8sPTinUI82ZftnRh204Ncwv3F36O8U5vGiV964Xbft31+V4c/" +
       "V668/Xd//Po/uqt0TSpdMxy+wFFyiDA/iVR6yNbsmeYHsKpqqlR61NE0ldd8" +
       "Q7aMbMMtlR4LjIUjh5Gv3VZSsTPyNH9zzlPNPaQUffMjJXT9292bG5qlnvx1" +
       "z9ySF3lfnzrt67aHWLE/7+CDRg7mz2VFO2ly99Jw1LD0/PkWt/t4o59XyJve" +
       "Z2uh7t4+1d2OnO8oPbYdO0t2FhU+9A1nkVe9x43ys4Sl910qtNC1JytLeaHd" +
       "CkvPnK/Hbg/ltR7YKKJoEpaePF9tIykfpfedG6Uz4/M9+iOf+Umn51zdMKua" +
       "YhX89+eNnjvXiNPmmq85irZt+NBr1Oflp7716aulUl75yXOVt3X+8U99/xOv" +
       "P/fOr27rvP+COszM1JTwlvKV2SO//izyavuuAuN+zw2MYvDv6PnG/NndkTcT" +
       "L/e8p25LLA7ePDn4Dvevpz/zC9rvXy09SJTuVVwrsnM7elRxbc+wNB/XHM2X" +
       "Q00lSg9ojopsjhOl+/IyZTjadi8znwdaSJTutja77nU3f+cqmuciChXdl5cN" +
       "Z+6elD051DflxCuVStfzT+nJ/PNsafuz+Q5Ltyq6a2sVWZEdw3ErrO8W/S8G" +
       "1FHlSqgFeVnNj3puZZbb//KN6s1mJXAjPzfIiusvKnJuFbq2PbhVCT/ChY0+" +
       "C0Pz/v+fIil6eT2+ciUfgGfPu7+Ve07PtVTNv6W8HXXQ7//irV+7etsddvoJ" +
       "S8/l57m5Pc/NzXm2A3hyntKVKxvxTxTn2x7KR2aZ+3ge/R56lf8x8ic+/dJd" +
       "uVF58d25WouqlcuDMHIaFYhN7FNy0yy984X4k6OfBq6Wrt4ZTQvGfNeDRXO2" +
       "iIG3Y92N8150kdxrn/rdP/7G599yT/3pjvC8c/N3tyzc9KXz2vRdRVPzwHcq" +
       "/rUX5G/e+tZbN66W7s59P493oZzbZx5Knjt/jjvc9c2T0Ff05Z68w3PXt2Vr" +
       "o+xdvHow1H03Pt2zGeZHNuVHcx0/X9pt7jDo4ujjXrF9YmsWxaCd68UmtH6U" +
       "9770X/7979U26j6JwtfOzGu8Fr55xvMLYdc2Pv7oqQ0Ivqbl9X7jC+zf+dz3" +
       "PvVXNgaQ13j5ohPeKLZI7vH5EOZq/rlfXf3X7/7mV75z9dRownzqi2aWoSTb" +
       "Tv5F/nMl//yf4lN0rtix9drHkF3oeOF27PCKM3/wlC2PIlbuZoUF3RAd21WN" +
       "uSHPLK2w2D+79kr1m3/wmetbm7DyPScm9foPF3C6/72d0s/82o//yXMbMVeU" +
       "YhY71d9ptW1ofPxUMuz7clpwJJ/8Dx/4e/9G/lIeZPPAFhiZtolVpY0+SpsB" +
       "BDa6KG+2lXPHwGLzfHDWEe70tTOrjVvKZ7/zhw+P/vCff39De+dy5ey4D2Tv" +
       "za2pFZsXklz80+e9vicHel6v/g79o9etd36QS5RyiUoerwLGz0NNcoeV7Grf" +
       "c99/+xf/8qmf+PW7Slex0oOWK6uYvHG40gO5pWuBnkepxPv4J7bWHN9/ErST" +
       "0rs6vzWQZzZ/NXLAVy+PNVix2jh112f+N2PNfva3//RdSthEmQsm2XPtpcrX" +
       "vvg+5GO/v2l/6u5F6+eSd4fffGV22hb8BfuPrr50769cLd0nla4ru2XfSLai" +
       "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" +
       "oAKZ5nSBgwjkxLogBUoLr48ggyZBPGkP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/+bmgev/C2YYgwUmSQAA");
}
