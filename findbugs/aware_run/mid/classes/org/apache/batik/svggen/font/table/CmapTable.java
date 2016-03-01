package org.apache.batik.svggen.font.table;
public class CmapTable implements org.apache.batik.svggen.font.table.Table {
    private int version;
    private int numTables;
    private org.apache.batik.svggen.font.table.CmapIndexEntry[] entries;
    private org.apache.batik.svggen.font.table.CmapFormat[] formats;
    protected CmapTable(org.apache.batik.svggen.font.table.DirectoryEntry de,
                        java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        long fp =
          raf.
          getFilePointer(
            );
        version =
          raf.
            readUnsignedShort(
              );
        numTables =
          raf.
            readUnsignedShort(
              );
        entries =
          (new org.apache.batik.svggen.font.table.CmapIndexEntry[numTables]);
        formats =
          (new org.apache.batik.svggen.font.table.CmapFormat[numTables]);
        for (int i =
               0;
             i <
               numTables;
             i++) {
            entries[i] =
              new org.apache.batik.svggen.font.table.CmapIndexEntry(
                raf);
        }
        for (int i =
               0;
             i <
               numTables;
             i++) {
            raf.
              seek(
                fp +
                  entries[i].
                  getOffset(
                    ));
            int format =
              raf.
              readUnsignedShort(
                );
            formats[i] =
              org.apache.batik.svggen.font.table.CmapFormat.
                create(
                  format,
                  raf);
        }
    }
    public org.apache.batik.svggen.font.table.CmapFormat getCmapFormat(short platformId,
                                                                       short encodingId) {
        for (int i =
               0;
             i <
               numTables;
             i++) {
            if (entries[i].
                  getPlatformId(
                    ) ==
                  platformId &&
                  entries[i].
                  getEncodingId(
                    ) ==
                  encodingId) {
                return formats[i];
            }
        }
        return null;
    }
    public int getType() { return cmap; }
    public java.lang.String toString() { java.lang.StringBuffer sb =
                                           new java.lang.StringBuffer(
                                           numTables *
                                             8).
                                           append(
                                             "cmap\n");
                                         for (int i =
                                                0;
                                              i <
                                                numTables;
                                              i++) {
                                             sb.
                                               append(
                                                 '\t').
                                               append(
                                                 entries[i].
                                                   toString(
                                                     )).
                                               append(
                                                 '\n');
                                         }
                                         for (int i =
                                                0;
                                              i <
                                                numTables;
                                              i++) {
                                             sb.
                                               append(
                                                 '\t').
                                               append(
                                                 formats[i].
                                                   toString(
                                                     )).
                                               append(
                                                 '\n');
                                         }
                                         return sb.
                                           toString(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2PQfo444QAgeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "S39ZHqz/PwpmvjsrKQAA");
}
