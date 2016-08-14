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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+IbSrrklSJyNk2jdZZhN7CpamZP1DqdN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "yKRDc0QAAA==");
}
