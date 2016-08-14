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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Azl9hyt/HwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fkykKgAA");
}
