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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "g/kMtx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VhgNNsMd4+N8m+Mnis1brOrbIZ/MpeE6G7OGMhm1tpUstZQBE0WE228TvOmQ" +
       "uFtjw17YSGO7upDodUB5S97mglHfbrF8sIhrHdMMkZq9cSc1oVnlBhxfH/gd" +
       "NsD1iF8Mt5xJUNwsYNiRKNlwd0vO/TbGYkpOBP0ISc1gPOFZebjSCLHfcElk" +
       "U2OIpF4jB2Lo56mjmS6z9n3RZHxerIYS0kX63EZpc0IdF4UQn7Z8UlrwsYm1" +
       "qaU96qO1pdZQLIVDaxw1aDNTopaj4o6rTUlOM8KZbQaNBOcdho93FXYcWAS5" +
       "GLnEcBjOaN/A19PuhKSTSYsj+20mDB3brLbwpoxQyHJNua2xvfAqzHxHOARZ" +
       "B32ju12vP5SmDoJudGlVG/Im7ji+OWvkI6GCsq2WQePBJJQ4zBHxOjIy7OqG" +
       "n8wlfBCyM4Wpuuk0H6aou94tm20MCScFMYnP0lhgVIsnArXfHEkrfU2FOuHA" +
       "bG3By2PUcAOXcd3cywdGPu+EsGlgUU0PN+yKc3FjWG329Qk/aXdzajvotd0t" +
       "79v1Ce4qthp0rXF9ZuHNbpcfpKwzWwWuyAO3sofMuN41sSDIhEGqE20ea7E4" +
       "rffnwnCx3dnOotZc2xJCtMT5ZjEU+xE+qXRFY7HqkeMNZeLj3FWxJeLLNLaa" +
       "VbhcSXhrNe4EW3I5n6ypTj4J0ybcGXW5nqLzdpWtTRZ6rznJ1y5S9XZsHghV" +
       "Y+73muBaV2e7DdPRMremNFoW16Pqy7Xrt1SLW7iU5ug7xGwEkUSlkjxParjb" +
       "IkTMqFRYD0+EAK67E77eNRB37S5wzQjqq6AmaqqG5WN4MTEJpmHnhACcgthM" +
       "8TW/REXTjqYCx1hBvPAzok75TogaUicjWqu5tfVFXKQUc73AeTYOlpkzN2UE" +
       "1ps+Q3X5MOztWmYgzT2pacRsW2XzdGDjRHNLNzYstjI3bVQwl6tWB2OmDDmx" +
       "J4KvtthFzZlWJjqlBV2lUV+s/G5HiE0naG676/GioW6nzBjrz9IQbdFwEnC+" +
       "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" +
       "ZT61q3Tq8OD4jOX7X8cGU7n1Wez4PnGnLwfK3d7PfPDFlxT6s7ViX6XofZFA" +
       "9yR+8E5HzVTn1NiXQE9vv/N+JVVuG56cHvz+B//HY+wPGu99A6exT52T83yX" +
       "v0i9/IfDt8o/cxG6dHyWcMsnHWeZnj97gnBvpCYpQPgz5whPHJui2NsrTwfR" +
       "Q1Og5zf4Tsx/J7uWXnHugOz0udy57aW7Y8OPyh3zXyhZP3eO9egIqbh/uSj+" +
       "VQLdr6vJye5h0RideOTPvdbe1Oley4Z/eaz/taMNzv6h/v2/H/1PK/FvXuXZ" +
       "bxTFrybQFaDgkY1mJ6r92t9BtYeKxmLrenSo2ujvX7XffpVnv1sUX0ygq4l/" +
       "soH6/hPdfvON6JaDED3+sqI4I370li+49l8dyZ9/6drVR15a/sn+GODoy6B7" +
       "SOiqljrO6bO1U/XLQaRqZin2PfuTtqD8+1ICPfvauAN8Ojk+dPmjPedXEujx" +
       "V+NMoLuKv9MsX02gR+7AUuxil5XT9F9LoOvn6YEo5f9puj9JoHtP6EBX+8pp" +
       "kj9LoEuApKj+eXCbHfD9eWZ+4RQ4HvpbacqHXsuUxyynP3QoALX8XO8I/NL9" +
       "B3s35S+8REzf953WZ/cfWsiOuCtfV1fJw3MK5xhAn7ljb0d9XR697bsP/Mo9" +
       "bzkC+wf2Ap/4/inZnrr9Jw0DN0jKjxB2v/HIv/6Bz730F+WG/P8HkhhQ2kcp" +
       "AAA=");
}
