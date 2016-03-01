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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6lLCrniRDNtRQnZi3NsqsGoPDWFVnQciVjP5aIuPWiHc4IfIFJYGfXExFvxq" +
       "QvuqG8pWudXZSP6gww6F9toyxhJVHkkkXyNRijLJhu5s2Ha9W6GWrDKJqhnl" +
       "aJiB9VVhbIw7vCgRI9oTYXITYySOt3gkhBzGCmeTDtHvLSnKtpmsai+iSlLt" +
       "iD1Bw5Z2e1vJEibb8CHLGBm/asLGxJQGM9PwqVTcWCOMsUCW4tBKvevD4rDi" +
       "WmoguJjpkmOYLw9qXavKzdqo0PZZz5irM7nW2CLa2EGaomEypMY0Tcwl+2mj" +
       "4ZHjaNKSWwyX1WPYnMlMqtoTCeO6KQ+NvGF5O1ITb9jQOpVQWCqoMLRYGNG4" +
       "6Xrt2bZpjmWXFapLMRg7M0ZBKcYVNdhfLjOYajhdXSbG40458EXfStfrJt+Z" +
       "aul2grsuSiyXbi+yEZ5es1OHD6DOgnHkkV8R+ZrGVwI+NlB4rk4RU6zbC1zo" +
       "jI1w7i5NhoOatNUJ2FW6VHFx3FmOR/BwZYWrHppQjKapUafV9nyYFfw+FEIL" +
       "qD8ZW41h342nHVIdrjzfp+odKVA9pW+buGhZ4XiAz1dbf5S6omL3RSKUzAmz" +
       "GShEhetXBARxeqvKRt6S4nw+UZG6SPSnswnvSEORgMXaYNJaD00MijFP0M1e" +
       "c0IrNoKRKFmVze5Qm6HCsl/plzGtXqsnA3pkEcOmlS1nkN8Nh6P+pj1qI7NV" +
       "4vMtPZ4izUm6rPuCMu5FSXuUatOO6srttF6t+2WqvGmsubXHiM0p4JaljPZF" +
       "Zh6MBErwKdIXlQYxloK226bCsiwbrAv3WpQz4HsEu2lpOqfOFMjSQrtDbI2o" +
       "zaZddNnHmr0tYIOyS2fSerOF12tiPc9W1VUEVWjfX+odMvIxaaquyXUoTRFx" +
       "Sg9GRt+uLNWKLkvkUGxPN1lbkAW/g4ZS3egYNj/jGbjhkGzX0lNvMo2ipA87" +
       "KwnWtQGyaVYTSy+bHTFCiZk5q07bcWzKJoRODXxem01UdepHrXo87I7rBNur" +
       "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" +
       "03aaecHv3sUOz67o2Tz5zOGGYPF3uXTq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("QN+xDcFj5zdK+Tf0J887c1l8P//CJ197Qx/+HHxx/7MBF5fui/3gQ46xNpxj" +
       "XV0q8j9+CON63v2j4OL2YXCn9yWPBH23X0P+223K/nuefD0uXZ0bMX64z3qk" +
       "1//6Tjtnxzs8S7ZHwDXal230nZftz84vu1AM9b/j0hUgG63eItqffrui5V9Q" +
       "+H3R+O+MaBeOKrCFDNduI9/9eXIpLr3HVYPuQg0PvgwdyXjh8rch48MHMn58" +
       "X8aPf8en78Ijtyl7LE8eAqYZ+0db2L97JNvD34ZsuVjFuYTX92V7/S5kK74A" +
       "ywVTvdMkbgtJnruNlHm/F54EUlpeLOSCnpLyqbuRMgXGcOwYbX4g8LFbDvTv" +
       "DqFrX3rj+tVH3xD/5e5swcFB8fvo0lUzcZzjR7CO5S8HoWFahdT37Q5kBYUU" +
       "5bj03Dsf8Y1Ll+KDr90XXtq13ItLT9yuZVy6N/853gSOS4+e0yT/WFJkjtev" +
       "x6Ubp+sDKMXv8XrNuHTtqB7oapc5XuUvxaV7QJU8+3Jw8K3lQ3d1uDm9cNKz" +
       "HPLRO9rzMWf0/InP/8W/dhx8qk92/9zxivblNwbsD32z8XO7I7eao2ZZ3stV" +
       "unRld/q36DT/3P/sub0d9HWZePFbD/7yfS8cuLcHd4CPFskxbE+ffbgVc4O4" +
       "OI6a/f1Hf+X7fuGNPyy+C/0/ZpzSZHMzAAA=");
}
