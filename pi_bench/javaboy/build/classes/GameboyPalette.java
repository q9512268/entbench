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
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YWQvfslqg0dsV9FDR6CGv+Jb7f8AZW83deggAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
