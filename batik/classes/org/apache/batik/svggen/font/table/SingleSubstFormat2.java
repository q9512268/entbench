package org.apache.batik.svggen.font.table;
public class SingleSubstFormat2 extends org.apache.batik.svggen.font.table.SingleSubst {
    private int coverageOffset;
    private int glyphCount;
    private int[] substitutes;
    private org.apache.batik.svggen.font.table.Coverage coverage;
    protected SingleSubstFormat2(java.io.RandomAccessFile raf, int offset)
          throws java.io.IOException { super();
                                       coverageOffset = raf.readUnsignedShort(
                                                              );
                                       glyphCount = raf.readUnsignedShort(
                                                          );
                                       substitutes = (new int[glyphCount]);
                                       for (int i = 0; i < glyphCount; i++) {
                                           substitutes[i] =
                                             raf.
                                               readUnsignedShort(
                                                 );
                                       }
                                       raf.seek(offset + coverageOffset);
                                       coverage = org.apache.batik.svggen.font.table.Coverage.
                                                    read(
                                                      raf); }
    public int getFormat() { return 2; }
    public int substitute(int glyphId) { int i = coverage.findGlyph(
                                                            glyphId);
                                         if (i > -1) { return substitutes[i];
                                         }
                                         return glyphId; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfZAUxRXv2/vguO87PgXugOPA4sNdNJBEzxjhvIMje3DF" +
                                                              "4ZU5lGVutnd3YHZmnOm924MQP6pSYKokiIgkwfsnGAhBoKhY0UpQUlZA40dF" +
                                                              "MRpjCfmqxEisSKViUjGJea97ZudjPwj52qrpne1+7/V7r1//3uveY++TSssk" +
                                                              "bVRjYTZmUCvcrbF+ybRovEuVLGsD9MXkR8ulP256d+2NIVI1RBpSktUnSxbt" +
                                                              "Uagat4ZIq6JZTNJkaq2lNI4c/Sa1qDkiMUXXhsgUxepNG6oiK6xPj1MkGJTM" +
                                                              "KGmWGDOV4QyjvbYARlqjoEmEaxJZERzujJI6WTfGXPLpHvIuzwhSpt25LEaa" +
                                                              "olukESmSYYoaiSoW68yaZLGhq2NJVWdhmmXhLepy2wVrosvzXNB+svHDj/ak" +
                                                              "mrgLJkmapjNunrWeWro6QuNR0uj2dqs0bd1NvkjKo6TWQ8xIR9SZNAKTRmBS" +
                                                              "x1qXCrSvp1om3aVzc5gjqcqQUSFG5vqFGJIppW0x/VxnkFDNbNs5M1g7J2et" +
                                                              "sDLPxEcWR/Y9uqnpVDlpHCKNijaA6sigBINJhsChND1MTWtFPE7jQ6RZg8Ue" +
                                                              "oKYiqco2e6VbLCWpSSwDy++4BTszBjX5nK6vYB3BNjMjM93MmZfgAWX/qkyo" +
                                                              "UhJsneraKizswX4wsEYBxcyEBHFns1RsVbQ4I7ODHDkbOz4HBMA6IU1ZSs9N" +
                                                              "VaFJ0EFaRIiokpaMDEDoaUkgrdQhAE1GZhQVir42JHmrlKQxjMgAXb8YAqqJ" +
                                                              "3BHIwsiUIBmXBKs0I7BKnvV5f+3Nu7drq7UQKQOd41RWUf9aYGoLMK2nCWpS" +
                                                              "2AeCsW5RdL809fSuECFAPCVALGi++4XLty5pO/O8oJlZgGbd8BYqs5h8aLjh" +
                                                              "1VldC28sRzWqDd1ScPF9lvNd1m+PdGYNQJipOYk4GHYGz6w/+/l7j9JLIVLT" +
                                                              "S6pkXc2kIY6aZT1tKCo1V1GNmhKj8V4ykWrxLj7eSybAe1TRqOhdl0hYlPWS" +
                                                              "CpV3Ven8N7goASLQRTXwrmgJ3Xk3JJbi71mDEDIBHlIHTysRH/7NSCqS0tM0" +
                                                              "IsmSpmh6pN/U0X4rAogzDL5NRYYh6rdGLD1jQghGdDMZkSAOUtQZGEkmqRZJ" +
                                                              "6IhQ0rBKIwMQUiodyAxbrEc30xK7IYwRZ/wf58qi3ZNGy8pgSWYFAUGFvbRa" +
                                                              "V+PUjMn7Miu7Lx+PvSiCDTeI7TFGlsP0YTF9mE8fFtOHcfownz6cPz0pK+Oz" +
                                                              "TkY1RBDAEm4FMAA0rls4cNeazbvayyH6jNEK8D+StvuyUpeLGA7Mx+QTLfXb" +
                                                              "5l64/rkQqYiSFklmGUnFJLPCTAJ8yVvtHV43DPnKTRtzPGkD852pyzQOqFUs" +
                                                              "fdhSqvURamI/I5M9Epykhts3UjylFNSfnDkwet/gPUtDJOTPFDhlJYAcsvcj" +
                                                              "vudwvCOIEIXkNu5898MT+3foLlb4Uo+TMfM40Yb2YFwE3ROTF82Rnoyd3tHB" +
                                                              "3T4RsJxJsPcAJtuCc/igqNOBdbSlGgxOYGyoOOT4uIalTH3U7eEB28zfJ0NY" +
                                                              "NODenAPPfHuz8m8cnWpgO00EOMZZwAqeNj4zYDz201d+9wnubifDNHpKgwHK" +
                                                              "Oj2ohsJaOH41u2G7waQU6N450P/wI+/v3MhjFijmFZqwA9suQDNYQnDzl56/" +
                                                              "+62LFw69HnLjnJGJhqkz2O40ns3ZiUOkvoSdMOECVyUARhUkYOB03K5BiCoJ" +
                                                              "Bfch7q2/Nc6//snf724SoaBCjxNJS64swO2/ZiW598VNf27jYspkTMyu21wy" +
                                                              "gfaTXMkrTFMaQz2y973W+tVz0mOQNwCrLWUb5fAb4m4IccunQxbhnIoeXi9p" +
                                                              "cT29Qga8s3oAyP14gHuOo0u/qaRhqUbsVHdD/2Z5V0f/r0Uau6YAg6CbciTy" +
                                                              "4OCbW17igVCN6ID9qEO9Z+8DiniisEmszsfwKYPnH/jgqmCHSBktXXbempNL" +
                                                              "XIaRBc0Xlqg0/QZEdrRc3Hrw3SeEAcHEHiCmu/Z9+ePw7n1iaUX1My+vAPHy" +
                                                              "iApImINNJ2o3t9QsnKPntyd2fO/Ijp1CqxZ/Lu+GUvWJN/7+UvjAz18okC7K" +
                                                              "FbuCXYbhngP3yf61EQbd9kDj9/e0lPcArvSS6oym3J2hvXGvRCjerMywZ7Hc" +
                                                              "qop3eE3DhWGkbBGsAe9eztVYmqeMHXqTnNDrXdedlamB4cz51mAz3/JCr38Z" +
                                                              "PbV7TN7z+gf1gx88c5m7wl/8e5GmTzLEOjRjswDXYVowNa6WrBTQLTuz9s4m" +
                                                              "9cxHIHEIJPItsc6ENJ314ZJNXTnhZz94burmV8tJqIfUqLoU75E4xJOJgK3U" +
                                                              "SkGGzxqfvVXgymg1NE34liU5xxDuGJLN68C9PbswanSnDcb3+banpn3n5sPj" +
                                                              "FzjGGULGTM5fgUWHL6fzI6SbVo6e/9RPDj+0f1SEWYlNE+Cb/td16vD9v/xL" +
                                                              "nst5Fi2wjwL8Q5FjB2d03XKJ87vpDLk7svmFEpQELu8NR9N/CrVX/TBEJgyR" +
                                                              "Jtk+sg1KagaTxBAcUyznHAfHOt+4/8gh6uvOXLqeFdzInmmDidS7PyqYby+4" +
                                                              "uRNrXDLbfpx3X+4sI/xlE2e5lreLsLnOSVUTDFOBYz0NJKraEkIZaZCxboIz" +
                                                              "kCjUsfcmkaWx7cMmJgT2F43KO/xWzLSrAKcaKGSFcM612Ej56hbjZqQmqY4Z" +
                                                              "qS49oxVUNXWVqrbBM9eebG4RVbWSqhbjZqTWwoymMDiiWv5bnFy64+lXgOud" +
                                                              "tWeftb7xm1NidxVKpoFz45HD1fLb6bM8meKMN/rLsGZ4bCeIb0Y2/ofnGLzN" +
                                                              "kEZZJEn1NJycWQrK7CRLOcek/6V4BOD5xRHH48fxb8575Z7xeb/gcFytWLAv" +
                                                              "oVAocHb38Hxw7OKl1+pbj/OCuQLrDTt9+S898u80fFcVfBUasRnhrzcVTGV3" +
                                                              "CAI7tnYU3swhRqqMzLCqQCVXmVA0SeUSO6Fb5U7BX7dis91w80CgWBMZE9Er" +
                                                              "3KXqGsWK0Rmb7GTT3B0RDGbzFDZJqy8j9HFzXXh9p2Hvr57uSK68mgMe9rVd" +
                                                              "4QiHv2fDmi0qvuRBVc7d/96MDbekNl/FWW12ICKCIr/Vd+yFVQvkvSF+DSVw" +
                                                              "P+/6ys/U6Uf7GpOyjKn56595bohsL4Ll+HqvWPJAVeTkevz9UImxh7F5EKJH" +
                                                              "xqUXkVKCfH9+MYEdg4an7ihzdVuVDeCu/m/gbruNTu1FcPfrJXG3GDcj1U5G" +
                                                              "c4J98b9wJdJl8wTsOljCrqyr31dy+vFPFQncV3n081RcBFGttdiVIi/tD92/" +
                                                              "bzy+7vHrHZBfCQdSphvXqXSEqh5RYtM/kFOjEcVPh2eprcbSoJNdQwMWcM1q" +
                                                              "SrCWCKOTJcZOYfNt0D9J7VsnFyS5r49dKYZKF78iXgv54Rp4ltnGLLt6PxRj" +
                                                              "LXxe4UZxqadLOONZbJ6CcsatEQLeePq/4Y0sFLH5l314Tpie93+DuCOXj483" +
                                                              "Vk8bv/1NkQude+w6AOdERlW9laznvcowaULhltWJutbgX+cYab/y5gOUYrnk" +
                                                              "dFZw/ghK7FKcjFTgl5flZUamFWGBvClevPQ/ZqQpSA+q8G8v3XlYJpcORIkX" +
                                                              "L8kbcJAGEnx903BgJ3x1N7HZMj805CJhypUiwYMm83wJk//15CS3jPjzKSaf" +
                                                              "GF+zdvvlTz4urtlkVdq2DaXUQjkjbvxyCXJuUWmOrKrVCz9qODlxvoNPzUJh" +
                                                              "d1PN9AT9IGwPA4NvRuACyurI3UO9dejmZ17eVfUalG8bSZkEVczG/FNY1sgA" +
                                                              "cG6M5l9SQDHBb8Y6F35t7JYliT+8zc+5RNQys4rTx+TXD991fu/0Q20hUttL" +
                                                              "KgF6aZYfD28b09ZTecQcIvWK1Z0FFUEKlEy+G5AG3CcS/inF/WK7sz7Xi5e0" +
                                                              "sBXyL3/yr7ZrVH2UmivhgBNHMVCE1ro9vv/E7L1XkzGMAIPb46lMe7DpzOJq" +
                                                              "QLTGon2G4dyN1X7a4ICxqniuf4+/YnPpn/0X9y2WHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PnxO1ScKVbkSn2gpTsZlyK+pJ9rWz+jTTsDGwf9naJvc+PgAiYfd4x9dE3Wx" +
       "y+ezZVaHMyNl2+jEWKYGO+kiMaMyVA/f5dY6G44trdEnEJFvOqSQJp7aWA1E" +
       "12PdTh0ZTyetgFuNfNscGvZGjz2yu+75o/WqygdT3hG7SFUlxrPAwnQ3zHEz" +
       "5kaCyVskpUkdVExVa7KxmvUwCjytVkFhAY1qMNxIM21Vqcy5OLZlYWat5qLL" +
       "Y5kSyURlK8/8DE8Fmoz7nfHSnrVTZ1JvttRKnRkKw9qsF3B2wntcLie8ZEgJ" +
       "Ig7DFiXOGcqWwrrDDBEF5qRa2LfNMb9crmODz7WAIVu+OWrlE6s2tklqPh6R" +
       "7oLsswIy3VqZvOrOnNDycReXckrEZ7vUooatxVwnlxM6GGTDdLdZc0FSb9K4" +
       "JPlOauOcy61WvmRy/qLV3koiTa7DOkMJC3Xtuss1rQXb+kaI/DjbLZleJc4G" +
       "fQuWbDcyaMp2pcBiUi9aaIvIb01TZlZNrboaxlVZrTGZbY381nwxbefDWYcT" +
       "me5oPnN7XF4Ll1jEZUHNdxuSsFOahhUq4ZTnCLKZhQRJDYNgUc1hIfdsos/I" +
       "TNwc1wyUqmtJ3KcnOa4sZvCqk4ZeIPSdYICNGNOSuq3YNHpDhlrH2Jrp18bz" +
       "RUJMcNSatmai0eY1f7QyQ8Wvay1BprFFwHGb/rZSQXrzeNezlk1v1MpWvUaP" +
       "scbWuNMYu6JudBdLOLS3Pr+m4mJLNjJ38WaJbGJ81cuVLd4bEF5cm8WCPEWG" +
       "KNsf9G2Z3SGD3rjbGvI1kYs7jCARVBUnpNnQ9O1AGvfxvi/xthGp03UXr5Hi" +
       "eiqYEVKnBm7kjKa5NTa6S7m96oYh1egNhpvY5Ic9d9kbxdUh2ht5mdDUKw0m" +
       "RdUoRPnpaMqqSG224PWOtCJ9ejyqe4V69a6GxYvmTKXb1Y7OpThGdCeY0KVJ" +
       "E2i9pJNtM2Bhtu1TjmiQstrurcK4uW5LtLWuCY6K1dvxbLcI+2qNUyZEx8kY" +
       "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" +
       "KpoNtwSkx/ab+WwwQNp6LrebaFNEc02GDYXYJgu6m/lC11cGcqM9yDcoO3Jq" +
       "lUC2YBZLp3TUnyedCgcgO21XdUIR9B4vxTNvHe0UYU4KDaw7RBNvxTfizXoW" +
       "huMdjYVTTFi6QrfKaTzHtgi5yaO9Jaqacae2aVcxY9Ebi3gHjxqjZUjGi1F1" +
       "5sooOZ83etVZn5R3RF+kwm3b6gyIHYhkO0F9kEVNNOVGrbZrjLVOJKjI1Bxk" +
       "db3vmtUwS2c9QUFVuNMa92XNZhyYWCxq9SE2woYRLKiVLSFMMzvjiEqfEzaT" +
       "CtzaxjDf4nWUDNitNfKarWanKQPEpxHaqQzCbDGhuoI2t7Vs1+GHbr5GiSY+" +
       "ogZ5yC9tYYTpg05lvMJVA5E81FzvVCEV+hqWwi5syFHKzNMaoUz0iFqSDbKv" +
       "WDW+SSoI1WnLnQ2lUk57M49Zx8KicBs1aipANGJCTD1FaHjVdm2m9AgySVRT" +
       "GJpw0u/UYXm3raDZIBqIPR2bqlwAUClccni4bs5WyRi2CdbCFWGyrmtBpMic" +
       "TzHqdDNeKONayEXYAhuxc0oR2ZXOJNV+h0KFGLge14yQjjpaiSMCbZtLI2si" +
       "swBxEuBSdNKa5DOLXuYawot5KKk0yzKiTLUwJZYSfEpr2iSEkVU1JuhB0wFQ" +
       "NA9MrdOo9FOMXVpIuyHYbTmDa4w9TVWtsml1WRWfOYuOI+28TPE3Ek+vnWRB" +
       "pYlsLCvKSpLhbdNg+VXk2SohbmBjPUKJkWIRc8Np6o7ISy6xIHsZ5mjZZAqD" +
       "ORdw3UrYJttZY+msqEBhZ0N7SbdtWaG6JO7lnWqjB4LBvMagA3FstatNjFpv" +
       "A97crMZuu7GhbBiuNTGuYU2s3YiTdJKo7NQsc+Y7JI0SxxbUsN6XlvzUsi05" +
       "y7fYkkr5hctGo0jAdp2Q7Tt55jOTHU+t1dqE6XTnnSG5AZtNJpulXWybRsMG" +
       "z3ZUzXLFGqoJOi85ZFvmRBsXlB0JE8yqFhtdhWyNm06Hm/YHPRDKt4hGM0Gp" +
       "lWPOK+2dUmnOmOk2RqJ5Xpkv+51OTU/h6rReXfNJQo8MAgTOK71fb8vVjjjX" +
       "lKkyzBajmlglCB4fOfi2Qja7ZANTONj0CHgxQuMdujSbWjXuLbd0A95GqBgJ" +
       "gzrvmtna6DGDsYDhtcjvZBmMo3Rtae/IcXc4kZGWM9bQfrBjqRAsTKTv1UlE" +
       "3TK1JSohQywPPTPVkQq88iaBB1eXnW19MTC63WK7/qNv7BjhkfLE5OS2iuWg" +
       "RcUPvIGTgn3Vs0WyPTmLKn9XoAs3HM6cRZ35RgMVX5GevNsllPJD2sff//Ir" +
       "KvtjtYOjc7JOAj2Q+MG/AS6qOWea2h97Jidi3Ciafxw81SMxqhePxE4V/ace" +
       "/336HnW/UCSfAsIa2tGlhNMz4dKwP/t6RzBnW7yTcl8DHuRIOeRfRrlLpwTN" +
       "kuBX76HhrxXJLyfQ9dOvERdU/MwbUTFPoEdvv8hRfJJ+/La7ZPv7T8onXrlx" +
       "7bFX+D/bf544vqP0AA1d01PHOftB60z+ShBpullq8MD+81ZQ/v12Aj33+uec" +
       "CXQ5OTlI/+ye8/cS6O334kyg+4u/syx/kECP3YWlON4sM2fp/ziBbl6kB6KU" +
       "/2fp/hQMxykdaGqfOUvyFwl0HyApsn8ZHJ+OHr6xWzb5pfOT+GTEH329ET8z" +
       "758/92mhvFZ4/Bkg3V8sfFH55CsU894vt35sf+tDASvbrmjlGg1d3V9AOfmU" +
       "8OxdWztu68rgnV95+FMPvOMYSR7eC3w6U87I9vSd71fgbpCUNyJ2v/jYz3/j" +
       "T7zyV+VR7v8Hv9SQi+8pAAA=");
}
