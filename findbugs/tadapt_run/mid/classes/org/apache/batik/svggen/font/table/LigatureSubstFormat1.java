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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
