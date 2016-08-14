package org.apache.batik.svggen.font.table;
public class CmapFormat4 extends org.apache.batik.svggen.font.table.CmapFormat {
    public int language;
    private int segCountX2;
    private int searchRange;
    private int entrySelector;
    private int rangeShift;
    private int[] endCode;
    private int[] startCode;
    private int[] idDelta;
    private int[] idRangeOffset;
    private int[] glyphIdArray;
    private int segCount;
    private int first;
    private int last;
    protected CmapFormat4(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          raf);
        format =
          4;
        segCountX2 =
          raf.
            readUnsignedShort(
              );
        segCount =
          segCountX2 /
            2;
        endCode =
          (new int[segCount]);
        startCode =
          (new int[segCount]);
        idDelta =
          (new int[segCount]);
        idRangeOffset =
          (new int[segCount]);
        searchRange =
          raf.
            readUnsignedShort(
              );
        entrySelector =
          raf.
            readUnsignedShort(
              );
        rangeShift =
          raf.
            readUnsignedShort(
              );
        last =
          -1;
        for (int i =
               0;
             i <
               segCount;
             i++) {
            endCode[i] =
              raf.
                readUnsignedShort(
                  );
            if (endCode[i] >
                  last)
                last =
                  endCode[i];
        }
        raf.
          readUnsignedShort(
            );
        for (int i =
               0;
             i <
               segCount;
             i++) {
            startCode[i] =
              raf.
                readUnsignedShort(
                  );
            if (i ==
                  0 ||
                  startCode[i] <
                  first)
                first =
                  startCode[i];
        }
        for (int i =
               0;
             i <
               segCount;
             i++) {
            idDelta[i] =
              raf.
                readUnsignedShort(
                  );
        }
        for (int i =
               0;
             i <
               segCount;
             i++) {
            idRangeOffset[i] =
              raf.
                readUnsignedShort(
                  );
        }
        int count =
          (length -
             16 -
             segCount *
             8) /
          2;
        glyphIdArray =
          (new int[count]);
        for (int i =
               0;
             i <
               count;
             i++) {
            glyphIdArray[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public int getFirst() { return first; }
    public int getLast() { return last; }
    public int mapCharCode(int charCode) { try { if (charCode < 0 ||
                                                       charCode >=
                                                       65534) return 0;
                                                 for (int i = 0; i <
                                                                   segCount;
                                                      i++) { if (endCode[i] >=
                                                                   charCode) {
                                                                 if (startCode[i] <=
                                                                       charCode) {
                                                                     if (idRangeOffset[i] >
                                                                           0) {
                                                                         return glyphIdArray[idRangeOffset[i] /
                                                                                               2 +
                                                                                               (charCode -
                                                                                                  startCode[i]) -
                                                                                               (segCount -
                                                                                                  i)];
                                                                     }
                                                                     else {
                                                                         return (idDelta[i] +
                                                                                   charCode) %
                                                                           65536;
                                                                     }
                                                                 }
                                                                 else {
                                                                     break;
                                                                 }
                                                             }
                                                 }
                                           }
                                           catch (java.lang.ArrayIndexOutOfBoundsException e) {
                                               java.lang.System.
                                                 err.
                                                 println(
                                                   "error: Array out of bounds - " +
                                                   e.
                                                     getMessage(
                                                       ));
                                           }
                                           return 0;
    }
    public java.lang.String toString() { return new java.lang.StringBuffer(
                                           80).
                                           append(
                                             super.
                                               toString(
                                                 )).
                                           append(
                                             ", segCountX2: ").
                                           append(
                                             segCountX2).
                                           append(
                                             ", searchRange: ").
                                           append(
                                             searchRange).
                                           append(
                                             ", entrySelector: ").
                                           append(
                                             entrySelector).
                                           append(
                                             ", rangeShift: ").
                                           append(
                                             rangeShift).
                                           append(
                                             ", endCode: ").
                                           append(
                                             intToStr(
                                               endCode)).
                                           append(
                                             ", startCode: ").
                                           append(
                                             intToStr(
                                               startCode)).
                                           append(
                                             ", idDelta: ").
                                           append(
                                             intToStr(
                                               idDelta)).
                                           append(
                                             ", idRangeOffset: ").
                                           append(
                                             intToStr(
                                               idRangeOffset)).
                                           toString(
                                             );
    }
    private static java.lang.String intToStr(int[] array) {
        int nSlots =
          array.
            length;
        java.lang.StringBuffer workBuff =
          new java.lang.StringBuffer(
          nSlots *
            8);
        workBuff.
          append(
            '[');
        for (int i =
               0;
             i <
               nSlots;
             i++) {
            workBuff.
              append(
                array[i]);
            if (i <
                  nSlots -
                  1) {
                workBuff.
                  append(
                    ',');
            }
        }
        workBuff.
          append(
            ']');
        return workBuff.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AtYnuMlFo3DR6i4r6/KsbfW1lo27OI5/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("X75F8/bdbR09VOySHR7QBJrNM373LnaHdlnP5slnDjcTi7/L0KlDfcc2E4+d" +
       "74Dyb+xPnnfusvi+/vlPvvaGyv985eL+J4dBDN0Xe/732Npas481dam4/7FD" +
       "GNfz5h8F12AfxuD0nuaRoO/2S8p/u03ef8+Tr8fQVV2LqcM92iO9/td32nU7" +
       "3uBZsj0CruG+bMNvv2x/en7ehaKr/x1DV4BsffkW0f7kvYqWf30Z7Ys2+vaI" +
       "duGoAFfIcO028t2fJ5di6H2O7BOGHB58VTqS8cLl9yDjwwcyfnxfxo9/24fv" +
       "wiO3yXssTx4Cphl7R9vfv3sk28PvQbZcrOLcwuv7sr1+F7IVX4/nBVO90yBu" +
       "C0meu42UebsXngRSmm48zgU9JeVTdyNlCozh2DHb/MDgY7cc6t8dRFe++Mb1" +
       "q4++If7L3dmDg8Pi9/Whq8vEto8f0Tp2f9kPtaVZSH3f7sCWX0hRiqHn3vkI" +
       "cAxdig++lF94aVdzL4aeuF3NGLo3/zlepRJDj55TJf/QUtwcL4/E0I3T5QGU" +
       "4vd4OTSGrh2VA03tbo4X+QsxdA8okt++7B98p/meuzr8nF44ObMc8tE72vOx" +
       "yej5E0cHin/vOPjMn+z+weMV5Utv9Lgf+mbj53dHchVbzrK8lat96MrudHDR" +
       "aH5U4NlzWzto63L3xW89+Mv3vXAwvT24A3zkJMewPX324VfS8ePiuGr29x/9" +
       "le/9xTf+sPim9P8AMez16XczAAA=");
}
