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
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALWbC3AbxRnHV/Ijjh+x48R5x3EcJ5DEsfJ+4DyQ5bOtRJYU" +
                                                              "STYTpyDOp7Ot5CyJu5WjhIYSZkpSmNK0BAgdyLSdUJgUCNPCwEyBCcNAoVA6" +
                                                              "PFqgtEAZOoXStKRModPQ0v329vSy9mh3pp7RaXO3+/33t/vtt3vK7v3nUYWh" +
                                                              "o2Y1gTvwwZRqdEgJHJR1Q415NNkwIuReVLmjTP7kqg/8W5yocghNG5ONfkU2" +
                                                              "1J64qsWMIbQwnjCwnFBUw6+qMSgR1FVD1SdkHE8mhlBT3PCOp7S4Esf9yZgK" +
                                                              "GQZl3Yemyxjr8eE0Vr3MAEYLfaQmLloTl7v4cacP1SrJ1MFc9jl52T15TyDn" +
                                                              "eE7LwKjBt0+ekF1pHNdcvriBOzM6WplKagdHtSTuUDO4Y5+2gTXBTt+GSU3Q" +
                                                              "+lD9pxePjzXQJpghJxJJTPGMkGoktQk15kP1ubuSpo4b16DrUJkP1eRlxqjN" +
                                                              "Z4m6iKiLiFq0uVyk9nVqIj3uSVIcbFmqTClQIYwWFxpJybo8zswEaZ2JhSrM" +
                                                              "2GlhQtuSpTUpJyHettJ14o6rGn5chuqHUH08EYbqKKQSmIgMkQZVx4dV3XDH" +
                                                              "YmpsCE1PkM4Oq3pc1uKHWE83GvHRhIzTpPutZoGb6ZSqU81cW5F+JGx6WsFJ" +
                                                              "PYs3Qh2K/atiRJNHCeusHKtJ2AP3CWB1nFRMH5GJ37Ei5fvjiRhGi4pLZBnb" +
                                                              "dpEMpOiUcRWPJbNS5QmZ3ECNpotocmLUFSaulxglWSuSxAF1jOZxjUJbp2Rl" +
                                                              "vzyqRsEji/IFzUck11TaEFAEo6bibNQS6aV5Rb2U1z/n/VtvuTbRl3AiB6lz" +
                                                              "TFU0qH8NKdRcVCikjqi6SsaBWbB2he92edYTx5wIkcxNRZnNPI9+9cLl7c3n" +
                                                              "njPzzC+RJzC8T1VwVDk9PO3lBZ7lW8qgGlWppBGHzi8gp6MsyJ50ZlIkwszK" +
                                                              "WoSHHdbDc6Fn91x/Rv3Iiaq9qFJJaulx4kfTleR4Kq6peq+aUHUZqzEvmqom" +
                                                              "Yh763IumkLQvnlDNu4GREUPFXlSu0VuVSfpv0kQjxAQ0UTVJxxMjSSudkvEY" +
                                                              "TWdSCKEG8kFN5LMAmX/0G6PdrrHkuOqSFTkRTyRdQT0J/IaLRJxh0rZjrmHi" +
                                                              "9ftdRjKtExd0JfVRl0z8YExlD2gjhAd7I7QFwbVS/w+jGSCZccDhII28oHiI" +
                                                              "a2R09CW1mKpHlRPpLunCg9EXTPcBl2dtgFEz0ekwdTqojtlJlg5yOKj5maBn" +
                                                              "PiKtv5+MYxJIa5eHr9x59bHWMuI4qQPlpOkga2vBhOLJDXYrQkeVs411hxa/" +
                                                              "veZpJyr3oUZZwWlZg/nBrY+SyKPsZ4OzdphMNbmI35IX8WGq0pOKGiMBhxf5" +
                                                              "mZWq5ISqw32MZuZZsOYjGHku/mxQsv7o3MkDRwa/ttqJnIVBHiQrSHyC4kEI" +
                                                              "zdkQ3FY8uEvZrT/6wadnbz+czA3zglnDmuwmlQSG1mIHKG6eqLKiRX4k+sTh" +
                                                              "NtrsU0kYxjIZNiTCNRdrFESRTisiA0sVAR5J6uOyRv2DtXE1HtOTB3J3qGdO" +
                                                              "h0uT6aTgQkUVpMF8Wzh19xsvfbiOtqQV9+vzJuywijvzYg0Ya6RRZXrOIyO6" +
                                                              "qpJ8vzsZvPW280f3UnckOZaUEmyDq4fEGNI7pAW//tw1b77z9unXnDkXxmSy" +
                                                              "TQ+TNUuGssz8gvw5yOff8IH4ADfMONHoYcGqJRutUqC8LFc3Erc0MszBOdoG" +
                                                              "EsQN4yNxeVhTYfx8Xr90zSN/vqXB7G6N3LG8pf3LDeTuz+1C179w1WfN1IxD" +
                                                              "gXkz1365bGYwnpGz7NZ1+SDUI3PklYV3/ky+m4R1EkqN+CGVRkdE2wPRDtxA" +
                                                              "22I1va4verYJLkuNfB8vHEZ565uocvy1j+sGP37yAq1t4QIpv9/75VSn6UVm" +
                                                              "LxCxRYhdCqI1PJ2VguvsDKnD7OJA1ScbY8TY+nP+rzRo5y4S2SEiq5AQawR0" +
                                                              "Eh0zBa7EcldM+c1TT8+6+uUy5OxB1VpSjvXIdMChqcTTVWOMBNZMasflZj0O" +
                                                              "VFlzSQZNaqFJN6AXFpXuX2k8hWmPHHps9sNb7z31NnXLlGljPi2/DmJ9QYSl" +
                                                              "a/HcID/z6qZf3fvt2w+Ys/lyfmQrKjfnnwFt+Ib3/jGpX2hMK7HSKCo/5Lr/" +
                                                              "rnme7R/R8rngAqXbMpPnJxKgc2XXnhn/u7O18hknmjKEGhS29h2UtTSM6yGy" +
                                                              "3jOsBTFZHxc8L1y7mQuVzmzwXFAc2PJki8Nabl4kacgN6boiH5wDXShZzmh9" +
                                                              "5/sgnS5Nj4IqdXjJUnVU1Rvf+97pz44c3eyEMVYxAVUnrdKQy+dPwxL7xvtv" +
                                                              "W1hz4t2bacdbpndS+WX0uhwu7dQVyiC5ioQrg67WMcGJJ2Qtk60s9bfZNpXF" +
                                                              "qDayJyhFB/y7/IEr/IWTN0yQ4fSwQSba+DgJvhNsSbk2eLVyrC34vulgc0sU" +
                                                              "MPM13ef65uDr+16kob0KpvKI1ah5EzWZ8vOmjAa4dMA4tnHcovq4Dje+s/+u" +
                                                              "Dx4w61PspUWZ1WMnbvqi45YTZsg1XxqWTFq355cxXxyKarfYToWW6Pnj2cM/" +
                                                              "ve/wUbNWjYVLYIm84T3w63+92HHy3edLrMnK4uzFD8KGI7uwmlnY1CZQ9zfq" +
                                                              "Hz/eWNZD5nQvqkon4tekVW+s0JunGOnhvLbPvYzkPJyhwdSGkWMFiTnmtA3X" +
                                                              "zXDZZbrVVm7M6548RlqY27WUGCOQ8AEYJEbsHBwuu+ESKuHZPAnLs73+iNQr" +
                                                              "heDeFUVEowJEi5ncYhsiJySSwkQ8CYxqKJF/oL+rNFBKAKiVqbXaANFKZ4SB" +
                                                              "eBIWkE/y90b6SgEdFABawtSW2ACVQ+KIMBBPAqP5eT0UDQQj3oDf7bPpsRsE" +
                                                              "ANuYepsNYAUkbhIG5ElgVE0B3f5en1SK52YBnqVMbKkNTyUkbhXm4UlYPJ6A" +
                                                              "L1Cyf04I8CxjYstseKZA4i5hHp6ExRN0k7BXiuduAZ5LmNglNjxVkLhHmIcn" +
                                                              "Qd4ITB4p5JH8EXdvSaf7oQDUpUzxUhuoqZB4UBiKJ4HRDAoVCbn94Z5AqD/q" +
                                                              "84ZL9tbZ/xGsh3yWM9XlNmDVkHhUGIwngVGVuZgMeUvRPCZAs4JJrbChqYHE" +
                                                              "OWEangRG0yhNT0jaPSD5PXtKMT0lwLSSCa60YaqFxPPCTDwJjKaaruftLzmS" +
                                                              "fi6A08602m1w6iDxijAOTwKjhvz5ljeMXhWgWsUkV9lQTYPEW8JUPAmLylwW" +
                                                              "cal+K0DVwSQ7bKjqIfG+MBVPwpqavN1S6anpDwI8LibmsuGhLzbnhXl4Etml" +
                                                              "Q7c74i7F8xcBntVMbLUND/1R9VNhHp4ERrPyvS4QIm9OfVLIW7KvPhNgW8OE" +
                                                              "19iwNULiC2E2noS1jKC+xxtQDiQAtZYprrWBmgHGq4SheBIWlMfnDUYH3b6B" +
                                                              "UhHdMVUAah1TXGcDNROMTxeG4klgNN1aQlAX5AQLR6MA1nqmud4GqwmMzxPG" +
                                                              "4klYWJ6BUJhgcXtrvgDWBqa5wQZrFhhfIozFk7CWSEE3iRicOOhoE2DayAQ3" +
                                                              "2jDNBuPtwkw8CYwWUCbJ7+7ySdEut2dXbygw4O/m99oqAcJNTH6TDeEcML5B" +
                                                              "mJAngdHM7CLQhOKGxI0CZJuZ7GYbsrlgfLswGU/CmsOs31/s5jDHDgG2LUx4" +
                                                              "iw3bPDDeK8zGk7DYegJkCutx93t9e/ge2SfAdhkTvsyGbT4YDwqz8SQwas5n" +
                                                              "87BU2Dsk8Rl3CzB2sgp02jAuAON7hBl5EgX9d4Xk7e2L8NmGBNi2MuGtNmwL" +
                                                              "wfiwMBtPwvpFg/4saDtvKwJg25jqNhuwZjC+XxiMJ2F12i5pTzQc9Hn9Upjf" +
                                                              "aZoA23YmvN2GbREYx8JsPAlrTRIMeP0RG6y0ANYOprnDBqsFjB8WxuJJYNRi" +
                                                              "YoWksBQaJE4ZDkqeSDTkjngDfMrrBChZVvObQ7kYjN8oTMmTwKguu07mTd5H" +
                                                              "BZDcTM9tg9QKxr8ljMSTwGhu8c8etqHkuABeF9PussFbAsZPCuPxJDBqM18B" +
                                                              "+twhtydiLk8G/F5PoFsizunv5a/C7hQg9bBqeGxI28D494VJeRIYzWZ7Cv4b" +
                                                              "uB8IwHUz5W4buKVg/IwwHE/Ceuum0zg3mvxIAEpiipIN1DIw/hNhKJ5Ewfqr" +
                                                              "Wwp7Qt5ghLhnOOThMz4swNjDKtBjw3gJGH9cmJEnYb31/BcryycEyHqZbK8N" +
                                                              "2aVg/BlhMp6EFTi73GEJlijRcJ+3x8Y5nxXA62PafTZ4QON4SRiPJ4FRI1uD" +
                                                              "hfxefy+f65cCXF4m6rXhWgHGXxfm4klYXOGg22PL9YYA104mutOGayUYf1eY" +
                                                              "iyeR/SEZXLHvS150fi/AtosJ77JhawfjHwqz8SSsDR65IOLu3jkQtgH8kwCg" +
                                                              "j6n7bACh/o6/CQPyJKz/IPSRObsUzicCOP1Mq98GpwOMXxTG4UlYP1ACDncF" +
                                                              "8rkAk58J+m2YXCThLBdm4klY4T73I5ft7ghnhQBegGkHbPBWg/E6YTyeBEbz" +
                                                              "rF8nISrCy5u3x8v/313nNAG+IBMP2vCtAeOzhPl4Eta+xK5AwCe5/aWIZgsQ" +
                                                              "7WZyu22I1oLxRcJEPAkrZoTIa3YpnBYbHM6mQrqDchVGVfKwgXVZwbnq0L96" +
                                                              "xD8DQHPOt/be62gh71Ad3aV7+oYTp2KBe9Y42VGGKwkNTqZWaeqEqhWYIrWx" +
                                                              "zkTBBv45k05UmqcAlQdP1VfNPjXwOj1jkz2pV+tDVSNpTcvfYp6Xrkzp6kic" +
                                                              "1qDW3HBO998612HUVPJ8Fkbl8AU1dK41827EqKE4L0YV9Ds/3xaMqnP5MKo0" +
                                                              "E/lZtmJURrJAcluKtsIcnL9V3dxln3EUtrXV46jpyxw4r3uWFGzzpqdZrS3O" +
                                                              "afM8a1Q5e2qn/9oLG+8xzwgpmnzoEFip8aEp5kkkahSOzSzmWrNsVfYtvzjt" +
                                                              "oalLrQ4vOKOUXzdIk5d4Bz3PM6/o0IzRlj078+bprU/+4ljlK07k2IscMkYz" +
                                                              "9k4+j5BJpYkn7vVN3sA9KOv0NE/n8u8e3N4+8te3rI3/jsJzHsX5o8pr9175" +
                                                              "6nfmnG52ohovqiC+rGboQYnug4mQqkzoQ6gubkgZUkViJS5rBbvDp4FjynDO" +
                                                              "lbYLa8667F04PIZR6+SN8ZOP3FVryQOq3pVMJ2Jgps6HanJ3zJ4pdPbqdCpV" +
                                                              "VCB3h3UlXGW4dGSgN4g/Rn39qZR18qqiK0VHu/lbdt4ueXqT+nCQJiG1+z/E" +
                                                              "mFfx6T4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALWce6zj2HnYNbPv9e7O7Httr9f7mLW91u5QFEk9sl7bfIki" +
       "RZEUSb3YJBOSokiKFMWnSCnZJg6a2m0S10DXqQvYRv9Yo0Vgx2kRowVaFy7a" +
       "tCniFkjhPtHEQZCiCRIDMdAkRp00JSXduXfu3itHKnoBUUfkOR9/5zvf+c7H" +
       "75L88ndK90Rhqewv3JXpLuKbRhbfnLnIzXjlG9FNhkUENYyMCe6qUSTn+27p" +
       "L/7ytT/5/mes61dL9yqlx1XPW8RqbC+8SDSihbs0Jmzp2ule0jXmUVy6zs7U" +
       "pQokse0CrB3Fr7Old51pGpdusCcIQI4A5AjABgFAT2vljR42vGSOFy1UL46C" +
       "0l8tXWFL9/p6gReXXrhTiK+G6nwnRtj0IJdwf/F7kHdq0zgLS8/f7vu2z+/o" +
       "8GfLwFt/50ev/6O7SteU0jXbkwocPYeI85MopYfmxlwzwgidTIyJUnrUM4yJ" +
       "ZIS26trrDbdSeiyyTU+Nk9C4raRiZ+Ib4eacp5p7SC/6FiZ6vAhvd29qG+7k" +
       "5Nc9U1c1874+ddrXbQ9bxf68gw/aOVg4VXXjpMndju1N4tL7z7e43ccbnbxC" +
       "3vS+uRFbi9unuttT8x2lx7Zj56qeCUhxaHtmXvWeRZKfJS6951Khha59VXdU" +
       "07gVl545X0/YHsprPbBRRNEkLj15vtpGUj5K7zk3SmfG5zvcRz79417bu7ph" +
       "nhi6W/Dfnzd67lwj0ZgaoeHpxrbhQx9mf0F96uufuloq5ZWfPFd5W+cf/8R3" +
       "P/7qc9/4tW2d915Qh9dmhh7f0t/WHvmNZ/FXmncVGPf7i8guBv+Onm/MX9gd" +
       "eT3z85n31G2JxcGbJwe/If7r8U/9ovEHV0sP0qV79YWbzHM7elRfzH3bNULK" +
       "8IxQjY0JXXrA8Cb45jhdui8vs7ZnbPfy02lkxHTpbnez697F5neuomkuolDR" +
       "fXnZ9qaLk7KvxtamnPmlUul6/ik9mX+eLW3/Nt9xqQdYi7kBqLrq2d4CEMJF" +
       "0f8IMLxYy3VrAVpu9Q4QLZIwN0FgEZqAmtuBZewObJQgDSh5o8HCtPz/H0Kz" +
       "oifX0ytXciU/e36Ku/nsaC/ciRHe0t9KMPK7v3Tr16/eNvmdDuLSc/l5bm7P" +
       "c3Nznu0gnZyndOXKRvwTxfm2h3LtO/k8zj3cQ69IP8L82KdevCs3HD+9O1dd" +
       "URW43NHipzOf3vg3PTe/0jc+l35i8JOVq6Wrd3rMgjHf9WDRXCj83G1/duP8" +
       "TLlI7rVP/t6ffPUX3lyczpk7XPBuKr+zZTEVXzyvzXChG5PcuZ2K//Dz6tdu" +
       "ff3NG1dLd+fzO/dpsZrbYO4unjt/jjum5Osn7q3oyz15h6eLcK66G2XvfNKD" +
       "sRUu0tM9m2F+ZFN+NNfx+0u7zR1GWxx93C+2T2zNohi0c73YuM83JP8L/+Xf" +
       "/z60UfeJp712Zu2SjPj1M7O7EHZtM48fPbUBOTSMvN5vfk7425/9zif/ysYA" +
       "8hovXXTCG8UWz2d1PoS5mn/m14L/+u3fevtbV0+NJs6Xt0RzbT3bdvIv8r8r" +
       "+ef/FJ+ic8WO7cx8DN+5h+dv+we/OPMHTtlyT+HmE6uwoBt9b76Y2FNb1Vyj" +
       "sNg/u/Yy+LU//PT1rU24+Z4Tk3r1Bws43f9urPRTv/6jf/rcRswVvVipTvV3" +
       "Wm3r/h4/lYyGoboqOLJP/If3/d1/o34hd6S584rstbHxR6WNPkqbAaxsdFHe" +
       "bIFzx6rF5v3R2Ylw51w7E1Hc0j/zrT96ePBH//y7G9o7Q5Kz495V/de3plZs" +
       "ns9y8U+fn/VtNbLyevA3uB++7n7j+7lEJZeo5/4q4sPc1WR3WMmu9j33/bd/" +
       "8S+f+rHfuKt0tVV60F2ok5a6mXClB3JLNyIr91KZ/7GPb605vf/EMWeld3R+" +
       "ayDPbH7VcsBXLvc1rSKiOJ2uz/xv3tV++ne+9w4lbLzMBQvpufYK8OXPvwf/" +
       "6B9s2p9O96L1c9k73W8efZ22rf7i/I+vvnjvr14t3aeUruu70G6gukkxiZQ8" +
       "nIlO4r08/Lvj+J2hyXYdfv22O3v2vKs5c9rzjubU7eflonZRfvCcb3mm0DJ5" +
       "4mROvs/6ls1qsB3jAukmnUdiphE+9jt/7+0//cQnG1cLg75nWaDnWrl+Wo9L" +
       "igjyr3/5s+9711u//bObyX8i+uOb07+w2d4oNh/cjO9dRfFDuW+INsFonHfH" +
       "9lR3Q/xKXHpIHgvkrT7X4fght98UhNCe575suYuJgDcf+7bz+d/7yjbeOT/u" +
       "5yobn3rrb/7FzU+/dfVMlPnSOwK9s222keYG8+ENazGTXth3lk2L1v/86pv/" +
       "9B+8+ckt1WN3xkxkfknwlf/059+8+bnf/rcXLOJ35fHw1ukXW6jYoNupUrt0" +
       "Wr3+zkF/fjfoz18w6EUBK5x1UZD3jVixoYpN+86hojmZpEix2Nc9B9s/AvaF" +
       "HewLe2CvFoUfPgz2XRtYrt/FLmb9kSNYX9yxvriHdcMzOYaVJTlKbl/EahzB" +
       "+tKO9aU9rHcXBfcw1vee0estXpBpnkPZPXqeH8F+Y8d+Yw/7PUUhPoz9wQ07" +
       "ylEseRFqcgTqyzvUl/eg3lsUfuIYVJxn+Qu1+uYRqB/YoX5gD+p9ReGvHYMq" +
       "oLljuAj1Z45A/eAO9YN7UO8vCj93GOq1LSop4iQno9SFVvDzR/B+aMf7oT28" +
       "DxSFtw7jfXzDK4soJ7V4sXuLpaULdfzZA5lb+eeVHfMre5gfLAqfP4z5/u2C" +
       "LtIXgX7hCNAP70A/vAf0XUXh7cNAH9mAtkSy1yc5fHwR7peOwC3vcMt7cB8q" +
       "Cl8+DPeBrS3Q3Qut9itHkL66I311D+km9PmVw0ivn10iLjPZrx0B/NoO+LU9" +
       "wJurnn92DPB2/b0U+OtHAN/cAd/cA3ytKPyrY1wuTZAXu9xfPQIV2KECe1Cv" +
       "F4VvHrWQEaiMXoT6745ArexQK3tQHy0K3zoM9amzZsCLeaTbJkX6Qg3/xyOw" +
       "wR02uAf7saLw349Z1DbGcKnx/uYRvNUdb3UP7+NF4XeP4cVZWrg1QNn+he7s" +
       "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" +
       "0DWnbJRSfQCfR3wEgUCEzIg2YVJVtp/B");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "4t0ASkkAAA==");
}
