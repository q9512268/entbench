package org.apache.batik.svggen.font.table;
public class LigatureSubstFormat1 extends org.apache.batik.svggen.font.table.LigatureSubst {
    private int coverageOffset;
    private int ligSetCount;
    private int[] ligatureSetOffsets;
    private org.apache.batik.svggen.font.table.Coverage coverage;
    private org.apache.batik.svggen.font.table.LigatureSet[] ligatureSets;
    protected LigatureSubstFormat1(java.io.RandomAccessFile raf, int offset)
          throws java.io.IOException { super();
                                       coverageOffset = raf.readUnsignedShort(
                                                              );
                                       ligSetCount = raf.readUnsignedShort(
                                                           );
                                       ligatureSetOffsets = (new int[ligSetCount]);
                                       ligatureSets = (new org.apache.batik.svggen.font.table.LigatureSet[ligSetCount]);
                                       for (int i = 0; i < ligSetCount; i++) {
                                           ligatureSetOffsets[i] =
                                             raf.
                                               readUnsignedShort(
                                                 );
                                       }
                                       raf.seek(offset + coverageOffset);
                                       coverage = org.apache.batik.svggen.font.table.Coverage.
                                                    read(
                                                      raf);
                                       for (int i = 0; i < ligSetCount;
                                            i++) { ligatureSets[i] =
                                                     new org.apache.batik.svggen.font.table.LigatureSet(
                                                       raf,
                                                       offset +
                                                         ligatureSetOffsets[i]);
                                       } }
    public int getFormat() { return 1; }
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
       "23QlxpqVtA1024WP2vP5shaHim4GQlcsRZiOMxmqtNvlEq6tzQU1tJzcdOqO" +
       "G88UQ5My08pQFoXrFAU4c7cD01kdhWbhqk2lFXuVBYwtjZWQYrMKvpKYdq8E" +
       "zGWppOnN6hqdk4AhtFWtOhAmeptjp3V6XUKNlb1dw4GgUNePEomqWgmWCHBl" +
       "qstdZsJRtjSRlr3FJndKg2U3brU7XYxsdYQGHrPewcUgaWMLaeu5lEkkQXUT" +
       "2GRIUtUKs2xwO60sJvywalYHi2gabpKsK1TK1V1rNwMoU13UVIue7Fyvzu3I" +
       "udjISmSYVgeprUoTkhfcrblq87VxdxsJk4HUUoiu2B5a8Q5OMEugjaaA15W6" +
       "Ly2GaM0ReKFpkS7KB7ul3+iSdC3RKlu2mfnlNZN2tE6yZXut0PBLutmqramg" +
       "UyISomZMzZEouPYQQ8leaVnvL4Z12UWz9Q5oWxGX57ouKn5UZ4bdjE7j1daq" +
       "VUvCYowSYc/xVXaj1EuZAGnGFldXqAxGAHN3pLFWW1hIrrAULMaW2MAZiyY9" +
       "b2VeQMAlE23E9FhRGz2/1q07wnLZb7SoYE7Ya4do0067LsDIlOf0plJaiI1G" +
       "e9MPzF27hcdNTqUq3rgqRiBDB71ya9jAy+ggSitqyxf6OMkASbGzdXnlbAB0" +
       "aJNMXdMrOxTdHuzSjWIuuN5Y2WA9Y7FyaZ6fYeW53i9xPBkO1hnoohlbaZV2" +
       "ajmkKihYENPxolxWB4waJK1RrdsxMDCOgh06UhfaNt4NNWJKo4yl7OrOpqml" +
       "aKU8kRfV+bKixS0QNQOcmjgE1pBjYPRxvVUhMUYjUG2QDdSQaysQfjN9ZtMA" +
       "85k5Fu+geXaTbJoYIwKuj2IooA6Y0F19vZoLpZbItVyJkImkMTTmapxRUdLp" +
       "ijMdr7gMOajLG7kWdaxML+NWPCC3qbLr9cu0Fm/HI7Q1zzCHGKCDMmeVO1Ol" +
       "08wa7bFr1rcBwzmctu0MRq4wK3lrJbGTVOA2S8diAjliRovU011FmBiqxydK" +
       "V1muwo5utrEy76xKWXkoEL4Ed4StTQswgVBrNmY0F5QHQdSoLlkNT5VJG93y" +
       "PI2P2HFLI9tGUvGm03XEh6WRUq5G290ORhZ6oyoZw9jR5qpuiOhEpvhKHa2S" +
       "cjgsLzY9a2VTvUxuLPVRswnKCseCSV+jVtVxRRIJwuuOIxugvN/rm3M4NcPW" +
       "GijkstoYKKm4BthQR7HRtN2MCYWjmk6jqzb6KjvDcX6rMaVpi25XmTjaTMTZ" +
       "bFbr2VOiE0/5ejvkV9M2PRc1urtzp5vaduRNXFOsEaN2n0R7PNlG271ZaSHT" +
       "WhfAXXrxKewL7+xY4bHiBOX0Mo9pt/KKz72Dk4N91Qt5kp2eNhV/15BLF0DO" +
       "nTad+3iF5J/XnrnbHZ3iC+PnP/7a6xrzs5Wjk4PDToQ8GHn+99kgBva5pvbH" +
       "zdGpGDfy5p+ET+NEjMblQ68zRf9/z0PfvEfdv86TX4HCrsDJbY28oHFm2H/x" +
       "VkcyF774Rch77nQBJP+U/eRtN9H2t6fUL75+4/oTry//7f5zxuGG04Nj5Lq+" +
       "te3zH8LO5a/5AdCNQoUH95/F/OL1lQh58a1PByPkanR68P7lPedXI+Tpe3FG" +
       "yP356zzLb0fIE3dhyU8Di8x5+q9FyM3L9FCU4n2e7vci5KEzOtjUPnOe5A8i" +
       "5D5Ikmf/0D8cJpbf6f2c9MpFLz8d9cffatTPTYyXLnyMKK4lHj4cbPcXE19R" +
       "v/Q6RX/0O82f3d8XUW15t8tbuT5GHthfXTn9+PDCXVs7tHWN/OB3H/35B99/" +
       "mGqP7gU+myfnZHvuzjcz+o4fFXcpdv/8iV/6/n/8+h8VZ5//D4RNfhkvKgAA");
}
