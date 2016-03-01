package org.apache.batik.svggen.font.table;
public class GlyfTable implements org.apache.batik.svggen.font.table.Table {
    private byte[] buf = null;
    private org.apache.batik.svggen.font.table.GlyfDescript[] descript;
    protected GlyfTable(org.apache.batik.svggen.font.table.DirectoryEntry de,
                        java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        buf =
          (new byte[de.
                      getLength(
                        )]);
        raf.
          read(
            buf);
    }
    public void init(int numGlyphs, org.apache.batik.svggen.font.table.LocaTable loca) {
        if (buf ==
              null) {
            return;
        }
        descript =
          (new org.apache.batik.svggen.font.table.GlyfDescript[numGlyphs]);
        java.io.ByteArrayInputStream bais =
          new java.io.ByteArrayInputStream(
          buf);
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int len =
              loca.
              getOffset(
                i +
                  1) -
              loca.
              getOffset(
                i);
            if (len >
                  0) {
                bais.
                  reset(
                    );
                bais.
                  skip(
                    loca.
                      getOffset(
                        i));
                short numberOfContours =
                  (short)
                    (bais.
                       read(
                         ) <<
                       8 |
                       bais.
                       read(
                         ));
                if (numberOfContours >=
                      0) {
                    descript[i] =
                      new org.apache.batik.svggen.font.table.GlyfSimpleDescript(
                        this,
                        numberOfContours,
                        bais);
                }
                else {
                    descript[i] =
                      new org.apache.batik.svggen.font.table.GlyfCompositeDescript(
                        this,
                        bais);
                }
            }
        }
        buf =
          null;
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            if (descript[i] ==
                  null)
                continue;
            descript[i].
              resolve(
                );
        }
    }
    public org.apache.batik.svggen.font.table.GlyfDescript getDescription(int i) {
        return descript[i];
    }
    public int getType() { return glyf; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vkWs89oeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/P8CipCOOaAqAAA=");
}
