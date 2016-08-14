package org.apache.batik.svggen.font.table;
public class CmapFormat0 extends org.apache.batik.svggen.font.table.CmapFormat {
    private int[] glyphIdArray = new int[256];
    private int first;
    private int last;
    protected CmapFormat0(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          raf);
        format =
          0;
        first =
          -1;
        for (int i =
               0;
             i <
               256;
             i++) {
            glyphIdArray[i] =
              raf.
                readUnsignedByte(
                  );
            if (glyphIdArray[i] >
                  0) {
                if (first ==
                      -1)
                    first =
                      i;
                last =
                  i;
            }
        }
    }
    public int getFirst() { return first; }
    public int getLast() { return last; }
    public int mapCharCode(int charCode) { if (0 <= charCode && charCode <
                                                 256) { return glyphIdArray[charCode];
                                           }
                                           else {
                                               return 0;
                                           } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7JxkHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qSbjlELwMY/HTMPC9FWl6Y4aK6enMX1ysmrm6dBcguyAxMOOPJDmnZ3ou9FI" +
       "qnjVLt/1bCGxMXQRMoEGd7Kh26a21lDvdIqt+I+8sSOCR8rTkJOPMzZ2u2j4" +
       "gTdwCrBverYorJNDo/J3FbrwQv/ModGZdztQcYj71N2+uSgPcD/9wZdfUdjP" +
       "1A6Oztj4GLo/9vz32Gqq2me6ulzWtRMxbhTdPw6u6pEY1YtnV6eK/r8eHb56" +
       "j7bPFsWPxdB1XY2Jk7O4U7v++Oudrpzt8E66PQau2pFutb973X72Hm0/VxT/" +
       "LoauAd1o6TbVfvqbVe0JcDWOVGv83ah26ZRgXhL8p3vo9/mi+I8x9CZH8nFD" +
       "CnFPUS/o+Nob0XELujrzgUbxqvltt30Otv+ESf7sKzeuP/7K4vf2L6uOPzO6" +
       "n4aua4ltn325d6Z+1Q9VzSxlv3//qs8v/34thp57/Y9HYuhKfPJi4Yt7zt+I" +
       "oSfvxRlD9xV/Z1l+O4YevwtLcRxbVs7S/24M3bxID0Qp/8/S/UEMPXBKB7ra" +
       "V86S/JcYugxIiuof+cenue95Q5/NbC+dx6WTmX709Wb6DJQ9f+5NS/lh4PFb" +
       "kWT/aeCL8udeoZjv/nrrM/uPOWRbyvOil+s0dG3/XcnJm5Vn79rbcV9Xh+/8" +
       "xsM/df87jsHx4b3ApyFyRra33/mzib7jx+WHDvnPPv7T3/Zjr/xxefL8fwEL" +
       "fEb5sSkAAA==");
}
