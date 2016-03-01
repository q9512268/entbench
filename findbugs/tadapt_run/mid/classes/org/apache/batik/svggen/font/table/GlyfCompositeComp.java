package org.apache.batik.svggen.font.table;
public class GlyfCompositeComp {
    public static final short ARG_1_AND_2_ARE_WORDS = 1;
    public static final short ARGS_ARE_XY_VALUES = 2;
    public static final short ROUND_XY_TO_GRID = 4;
    public static final short WE_HAVE_A_SCALE = 8;
    public static final short MORE_COMPONENTS = 32;
    public static final short WE_HAVE_AN_X_AND_Y_SCALE = 64;
    public static final short WE_HAVE_A_TWO_BY_TWO = 128;
    public static final short WE_HAVE_INSTRUCTIONS = 256;
    public static final short USE_MY_METRICS = 512;
    private int firstIndex;
    private int firstContour;
    private short argument1;
    private short argument2;
    private short flags;
    private int glyphIndex;
    private double xscale = 1.0;
    private double yscale = 1.0;
    private double scale01 = 0.0;
    private double scale10 = 0.0;
    private int xtranslate = 0;
    private int ytranslate = 0;
    private int point1 = 0;
    private int point2 = 0;
    protected GlyfCompositeComp(java.io.ByteArrayInputStream bais) { super(
                                                                       );
                                                                     flags =
                                                                       (short)
                                                                         (bais.
                                                                            read(
                                                                              ) <<
                                                                            8 |
                                                                            bais.
                                                                            read(
                                                                              ));
                                                                     glyphIndex =
                                                                       bais.
                                                                         read(
                                                                           ) <<
                                                                         8 |
                                                                         bais.
                                                                         read(
                                                                           );
                                                                     if ((flags &
                                                                            ARG_1_AND_2_ARE_WORDS) !=
                                                                           0) {
                                                                         argument1 =
                                                                           (short)
                                                                             (bais.
                                                                                read(
                                                                                  ) <<
                                                                                8 |
                                                                                bais.
                                                                                read(
                                                                                  ));
                                                                         argument2 =
                                                                           (short)
                                                                             (bais.
                                                                                read(
                                                                                  ) <<
                                                                                8 |
                                                                                bais.
                                                                                read(
                                                                                  ));
                                                                     }
                                                                     else {
                                                                         argument1 =
                                                                           (short)
                                                                             bais.
                                                                             read(
                                                                               );
                                                                         argument2 =
                                                                           (short)
                                                                             bais.
                                                                             read(
                                                                               );
                                                                     }
                                                                     if ((flags &
                                                                            ARGS_ARE_XY_VALUES) !=
                                                                           0) {
                                                                         xtranslate =
                                                                           argument1;
                                                                         ytranslate =
                                                                           argument2;
                                                                     }
                                                                     else {
                                                                         point1 =
                                                                           argument1;
                                                                         point2 =
                                                                           argument2;
                                                                     }
                                                                     if ((flags &
                                                                            WE_HAVE_A_SCALE) !=
                                                                           0) {
                                                                         int i =
                                                                           (short)
                                                                             (bais.
                                                                                read(
                                                                                  ) <<
                                                                                8 |
                                                                                bais.
                                                                                read(
                                                                                  ));
                                                                         xscale =
                                                                           (yscale =
                                                                              (double)
                                                                                i /
                                                                                (double)
                                                                                  16384);
                                                                     }
                                                                     else
                                                                         if ((flags &
                                                                                WE_HAVE_AN_X_AND_Y_SCALE) !=
                                                                               0) {
                                                                             short i =
                                                                               (short)
                                                                                 (bais.
                                                                                    read(
                                                                                      ) <<
                                                                                    8 |
                                                                                    bais.
                                                                                    read(
                                                                                      ));
                                                                             xscale =
                                                                               (double)
                                                                                 i /
                                                                                 (double)
                                                                                   16384;
                                                                             i =
                                                                               (short)
                                                                                 (bais.
                                                                                    read(
                                                                                      ) <<
                                                                                    8 |
                                                                                    bais.
                                                                                    read(
                                                                                      ));
                                                                             yscale =
                                                                               (double)
                                                                                 i /
                                                                                 (double)
                                                                                   16384;
                                                                         }
                                                                         else
                                                                             if ((flags &
                                                                                    WE_HAVE_A_TWO_BY_TWO) !=
                                                                                   0) {
                                                                                 int i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 xscale =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                                 i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 scale01 =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                                 i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 scale10 =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                                 i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 yscale =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                             }
    }
    public void setFirstIndex(int idx) { firstIndex =
                                           idx;
    }
    public int getFirstIndex() { return firstIndex;
    }
    public void setFirstContour(int idx) {
        firstContour =
          idx;
    }
    public int getFirstContour() { return firstContour;
    }
    public short getArgument1() { return argument1;
    }
    public short getArgument2() { return argument2;
    }
    public short getFlags() { return flags;
    }
    public int getGlyphIndex() { return glyphIndex;
    }
    public double getScale01() { return scale01;
    }
    public double getScale10() { return scale10;
    }
    public double getXScale() { return xscale;
    }
    public double getYScale() { return yscale;
    }
    public int getXTranslate() { return xtranslate;
    }
    public int getYTranslate() { return ytranslate;
    }
    public int scaleX(int x, int y) { return java.lang.Math.
                                        round(
                                          (float)
                                            (x *
                                               xscale +
                                               y *
                                               scale10));
    }
    public int scaleY(int x, int y) { return java.lang.Math.
                                        round(
                                          (float)
                                            (x *
                                               scale01 +
                                               y *
                                               yscale));
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
       "KfIh4czhGtgvxBGsE9M+7K5Am2qsTC0M");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LjdKxdUECsVuiRIjpVEcqnNICzK+wTRsJUZDp6ygSwEp8PUwHfbQCPIa3aZa" +
       "H2ibOrvgUswBMhqHxKxloNYwXvlynVtBXKtbVGeex2nzsl8Vaj0HbQzVIjFp" +
       "rSgLNQ3Iq0sNIUY3FFoqSc1yV4SslZZm/YZxsV4ew6NSoviEtummfagsTSI7" +
       "aoytdhny+qiFm8DuJ2g/UprTJkqhAxiBSoI0hpwZ0YfA9kd2G6uq2pTiYR/o" +
       "vxhxMGbECqHqYiJC+kSNwhnbGhtBxcb7ENUeEXJTd/tru7/BFCwMh6FUQVuL" +
       "FqTq8qLGmlRTgSGir4pSRXL5Jk1w8xbNsPG8yCc1JigtIZHcjBSLw8AIIjAb" +
       "DZv8eraBU07u6RvD7tftCkmZEIWS/VmMww1opWEba2LwRqerxFPb7s+hmj4d" +
       "WK3WksKhisqNIsvzyvjI8vCkkdhNfrDA19a4zNRKw2nSSiqlQUTKHdsrAs+9" +
       "x/L1BWWXFhHs11uax8iC1t0UERpy2oOe3Yo7DLeBA19qbbB+LU7Wlfl4WK/h" +
       "YYXXBrXRyh3SdcmPxJgZGZpEciULZkXMrctDT64tNjMEtlnMQmzDj+EGIZUi" +
       "sS5ZLclPo/LCT2tpVxWwNuyPx6IF1Qhj2eHjflvDV3ENnoN9V+TS0pDaFJsC" +
       "WWuwrG+COTgShbgKSQN7bFdjhhjVypyqD2eUqrOrZtGgNjJQn+JKQV007ugW" +
       "Q5kbo5WMmZWgK0M0DvhyYzooerRhbYwgRWmpE5PFIj6vrIawxqTDTZOvVq3+" +
       "JrTFuRRCFKt7wqwXhsDOxNY6VBekYHsNk1T8CkYpG43rcFGAWRVWVsNkHtqN" +
       "zUgu9zm56bdFiFajcdx02q0mA7fb7Xdnrz0fON9rz9flr3GvHe5fmY2skUvn" +
       "eLN5yimK/G11//CcaP53qXDsiPiRt995yQd3pwR9r/DIaaf489NSn/rgCy/K" +
       "o58pX9ydp6SDwt2B477TVDaKeaSp7IDt06efDKPySwyH5/y+9MH//tDse7T3" +
       "nuOU85uP4Tze5M9Rn/2N3lulv3OxcNu1U383XK+4vtIz15/1u8dTgtCzZ9ed" +
       "+Hvk2si+Jhuxt4JH2I2scPx3hUNpniamXMh53uFx1QuHBV7MClx4x7ECR86z" +
       "XtjLgrcFhdf6SoCdecbg9o2jy9dU68LbX+6l+dGesoQLV68xv5wlZr+fKzvm" +
       "yq1hfpTYM2fk5ROuDkgvj5LOB+yQYONVEMxFm52i0HcE9b8i0fbOYJkZjAtI" +
       "ULh8INrDMxkXSoc8O69WkNnP++aOp3nrBUmfkcdkwRBQXN5A8agoR6+CYm4D" +
       "s8Mx7o6ie+sp7p+RJ2QBHxTuBRTb151fOeT3fbeCX7DjF9x6fsYZeVYWqNfz" +
       "g4/xW75aft+VF93+xbeeX3RGXpIFXlC4K1PRaydqDrn5t8KOvm/H7X23ntvf" +
       "PCPvR7LgB7d2tHf90ZxDgj/0Kgjef0Dw2R3BZ289wR8/I+8nsuBHs4NHSkAf" +
       "OaVyyO7Dt4LdD+/Y/fCtZ/f3zsj7ZBZ87Ai73XGXQ3Y/+WrZZc7iczt2z916" +
       "dj97Rt7PZcE/AO4lYDenr516OiT307eC3I/tyP3YrSf3j8/I+0IWfG5LbnES" +
       "uc/fCrPy/I7c87ee3K+ekfdrWfDPt2ZlPrvuZNEhwV++FQRf2BF84dYT/PIZ" +
       "ef86C764Jbg4jeDLnhF8OYIPgOfFHcEXbw3Bi3mB/CJJfnhp64R+9Qyqv5sF" +
       "v5VdI8qUdH6M47+7FRw/veP46b9Kjv/pDI5/kAVfO+C4OMbxZU8LXnfLDuzs" +
       "b7glnN13fPCG/2CwvXUvfe7Fy3e96UXmq/lF2Ws34+8mC3epoWkevXl2JH7J" +
       "9RRVz+nfvb2H5uZMvhkUnnj5e8xB4Y78MxfIN7Y1/0dQePismmD/mH0crfI/" +
       "g8KbTqmSjWUeOVr+j4PClePlAZT882i5PwMr2mE50NQ2crTId4LCbaBIFv2L" +
       "7e2X60++bW/7xdujdQ8e0b/ta5X7X06kR16HPHndS4z831UcvHAIt/+wYl/6" +
       "/IvE8Ae+Xf+Z7aVhyRTSNGvlLrJw5/b+ct5o9tLi8VNbO2jrUv+p79z3C3e/" +
       "5eAFy31bwIdz4Qi2N598PbdruUF+oTb9pTf9k3f97Itfy+8M/j+a5k+HR0QA" +
       "AA==");
}
