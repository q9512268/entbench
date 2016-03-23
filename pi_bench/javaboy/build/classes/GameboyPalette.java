class GameboyPalette {
    short[] data = new short[4];
    int[] gbcData = new int[4];
    int[] colours = { -1, -5592406, -11184811, -16777216 };
    public GameboyPalette(int c1, int c2, int c3, int c4) { super();
                                                            data[0] = (short)
                                                                        c1;
                                                            data[1] = (short)
                                                                        c2;
                                                            data[2] = (short)
                                                                        c3;
                                                            data[3] = (short)
                                                                        c4;
    }
    public GameboyPalette(int pal) { super();
                                     decodePalette(pal); }
    public void setColours(int c1, int c2, int c3, int c4) { colours[0] =
                                                               c1;
                                                             colours[1] =
                                                               c2;
                                                             colours[2] =
                                                               c3;
                                                             colours[3] =
                                                               c4; }
    public byte getGbcColours(int entryNo, boolean high) { if (high) { return (byte)
                                                                                (gbcData[entryNo] >>
                                                                                   8);
                                                           }
                                                           else {
                                                               return (byte)
                                                                        (gbcData[entryNo] &
                                                                           255);
                                                           }
    }
    public void setGbcColours(int entryNo,
                              boolean high,
                              int dat) { if (high) {
                                             gbcData[entryNo] =
                                               gbcData[entryNo] &
                                                 255 |
                                                 dat <<
                                                 8;
                                         }
                                         else {
                                             gbcData[entryNo] =
                                               gbcData[entryNo] &
                                                 65280 |
                                                 dat;
                                         }
                                         int red =
                                           (gbcData[entryNo] &
                                              31) <<
                                           3;
                                         int green =
                                           (gbcData[entryNo] &
                                              992) >>
                                           2;
                                         int blue =
                                           (gbcData[entryNo] &
                                              31744) >>
                                           7;
                                         data[0] =
                                           0;
                                         data[1] =
                                           1;
                                         data[2] =
                                           2;
                                         data[3] =
                                           3;
                                         java.awt.Color c =
                                           new java.awt.Color(
                                           red,
                                           green,
                                           blue);
                                         colours[entryNo] =
                                           c.
                                             getRGB(
                                               );
    }
    public void decodePalette(int pal) { data[0] =
                                           (short)
                                             (pal &
                                                3);
                                         data[1] =
                                           (short)
                                             ((pal &
                                                 12) >>
                                                2);
                                         data[2] =
                                           (short)
                                             ((pal &
                                                 48) >>
                                                4);
                                         data[3] =
                                           (short)
                                             ((pal &
                                                 192) >>
                                                6);
    }
    public int getRgbEntry(int e) { return colours[data[e]];
    }
    public short getEntry(int e) { return data[e];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aKmDIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
