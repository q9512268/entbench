package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFLZWDecoder {
    byte[][] stringTable;
    byte[] data = null;
    byte[] uncompData;
    int tableIndex;
    int bitsToGet = 9;
    int bytePointer;
    int bitPointer;
    int dstIndex;
    int w;
    int h;
    int predictor;
    int samplesPerPixel;
    int nextData = 0;
    int nextBits = 0;
    int[] andTable = { 511, 1023, 2047, 4095 };
    public TIFFLZWDecoder(int w, int predictor, int samplesPerPixel) { super(
                                                                         );
                                                                       this.
                                                                         w =
                                                                         w;
                                                                       this.
                                                                         predictor =
                                                                         predictor;
                                                                       this.
                                                                         samplesPerPixel =
                                                                         samplesPerPixel;
    }
    public byte[] decode(byte[] data, byte[] uncompData,
                         int h) { if (data[0] == (byte)
                                                   0 &&
                                        data[1] ==
                                        (byte)
                                          1) { throw new java.lang.UnsupportedOperationException(
                                                 "TIFFLZWDecoder0");
                                  }
                                  initializeStringTable(
                                    );
                                  this.data =
                                    data;
                                  this.h =
                                    h;
                                  this.uncompData =
                                    uncompData;
                                  bytePointer =
                                    0;
                                  bitPointer =
                                    0;
                                  dstIndex =
                                    0;
                                  nextData =
                                    0;
                                  nextBits =
                                    0;
                                  int code;
                                  int oldCode =
                                    0;
                                  byte[] string;
                                  while ((code =
                                            getNextCode(
                                              )) !=
                                           257 &&
                                           dstIndex !=
                                           uncompData.
                                             length) {
                                      if (code ==
                                            256) {
                                          initializeStringTable(
                                            );
                                          code =
                                            getNextCode(
                                              );
                                          if (code ==
                                                257) {
                                              break;
                                          }
                                          writeString(
                                            stringTable[code]);
                                          oldCode =
                                            code;
                                      }
                                      else {
                                          if (code <
                                                tableIndex) {
                                              string =
                                                stringTable[code];
                                              writeString(
                                                string);
                                              addStringToTable(
                                                stringTable[oldCode],
                                                string[0]);
                                              oldCode =
                                                code;
                                          }
                                          else {
                                              string =
                                                stringTable[oldCode];
                                              string =
                                                composeString(
                                                  string,
                                                  string[0]);
                                              writeString(
                                                string);
                                              addStringToTable(
                                                string);
                                              oldCode =
                                                code;
                                          }
                                      }
                                  }
                                  if (predictor ==
                                        2) {
                                      int count;
                                      for (int j =
                                             0;
                                           j <
                                             h;
                                           j++) {
                                          count =
                                            samplesPerPixel *
                                              (j *
                                                 w +
                                                 1);
                                          for (int i =
                                                 samplesPerPixel;
                                               i <
                                                 w *
                                                 samplesPerPixel;
                                               i++) {
                                              uncompData[count] +=
                                                uncompData[count -
                                                             samplesPerPixel];
                                              count++;
                                          }
                                      }
                                  }
                                  return uncompData;
    }
    public void initializeStringTable() {
        stringTable =
          (new byte[4096][]);
        for (int i =
               0;
             i <
               256;
             i++) {
            stringTable[i] =
              (new byte[1]);
            stringTable[i][0] =
              (byte)
                i;
        }
        tableIndex =
          258;
        bitsToGet =
          9;
    }
    public void writeString(byte[] string) {
        for (int i =
               0;
             i <
               string.
                 length;
             i++) {
            uncompData[dstIndex++] =
              string[i];
        }
    }
    public void addStringToTable(byte[] oldString,
                                 byte newString) {
        int length =
          oldString.
            length;
        byte[] string =
          new byte[length +
                     1];
        java.lang.System.
          arraycopy(
            oldString,
            0,
            string,
            0,
            length);
        string[length] =
          newString;
        stringTable[tableIndex++] =
          string;
        if (tableIndex ==
              511) {
            bitsToGet =
              10;
        }
        else
            if (tableIndex ==
                  1023) {
                bitsToGet =
                  11;
            }
            else
                if (tableIndex ==
                      2047) {
                    bitsToGet =
                      12;
                }
    }
    public void addStringToTable(byte[] string) {
        stringTable[tableIndex++] =
          string;
        if (tableIndex ==
              511) {
            bitsToGet =
              10;
        }
        else
            if (tableIndex ==
                  1023) {
                bitsToGet =
                  11;
            }
            else
                if (tableIndex ==
                      2047) {
                    bitsToGet =
                      12;
                }
    }
    public byte[] composeString(byte[] oldString,
                                byte newString) {
        int length =
          oldString.
            length;
        byte[] string =
          new byte[length +
                     1];
        java.lang.System.
          arraycopy(
            oldString,
            0,
            string,
            0,
            length);
        string[length] =
          newString;
        return string;
    }
    public int getNextCode() { try { nextData =
                                       nextData <<
                                         8 |
                                         data[bytePointer++] &
                                         255;
                                     nextBits +=
                                       8;
                                     if (nextBits <
                                           bitsToGet) {
                                         nextData =
                                           nextData <<
                                             8 |
                                             data[bytePointer++] &
                                             255;
                                         nextBits +=
                                           8;
                                     }
                                     int code =
                                       nextData >>
                                       nextBits -
                                       bitsToGet &
                                       andTable[bitsToGet -
                                                  9];
                                     nextBits -=
                                       bitsToGet;
                                     return code;
                               }
                               catch (java.lang.ArrayIndexOutOfBoundsException e) {
                                   return 257;
                               } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+Tb+WfJffxC8vAotAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pt2sWRQfDnA/2K61oKvQZNcVZn4NH+VW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0AEePxgcNp67Ei2GescZtE042w5lR+gMMhHhw/msnxMbKFu61tQRpc1iglrq" +
       "titYgB0nA3PMrdG6ncIujIP6GkMnoRB2DLzWak0Z6H67aTvxTki9mQGxPRqz" +
       "sFZvuEVJDNNDLKwrtNOO5dpsRBNsNtkRijbc0hbvST1/JqVsgtBkBk9rqt/Z" +
       "texsSvi+HlnJcrnMOkGWjfpbfIt7TdkkZiQX9rcduYb7Odt0cAXbpStyvpKs" +
       "7lq1sbwG12p+Uzb4fttZKzDpOk61L6Er3rVWSDZFtl5zqAhRFdaqNEM0OsGM" +
       "rbkOWDjxY0JrdGgmlxssSfrzJEjsvJpHU7jfbVAjrZrpbWOKdEdy5phEPlxV" +
       "mbo5HDW3mNDROR2YglG1pDETef0wbUEDu8bN0YWZzvudbacGbbcru2ED33me" +
       "p8TA6aK5ovhiz2zwWivWxyjGLWjTZKojbA4v1rRjUzlvtHmbHidVTSOZPCPA" +
       "zMvtIHrjopw4TlRLWozFJcSSIrHEBR9lqA5X5VfVhT7V9XzQyXpB0uv1frDY" +
       "3vrT29t2e6jcYTw6Bm+77SLhv9/Gzto+af9m/mjjvHK4M3/q6PSJnfky5yMH" +
       "u6xxVHnsvNPt5QG9z374hRfV2c/WLx5sybaTyr1JEL7b1TLNPVHV3ftN4iMY" +
       "5WmgR8D1ngMY7zn7guBY0OtUdqFU2V5RZ7aHLx3rlD8KysN/Fx46fyf5wmuL" +
       "4P6kcpdaHtEpSx4p+cIDt9q+PFndGUHLs7hvB9cnDwT95Csj6En0j90k7Yki" +
       "eCSpvN7yraQ8qKJxJ46R3WgDNwss9Vj4N32vwr8TXD9zIPzPvDLCXzjOwJdS" +
       "vusmGrhWBG9PKq/ZADbTjnbjLzx5LOM7vlcZ++D6xQMZf/GVkfHEe5fSiJel" +
       "MJ2bCPqXiqCZVK7IqnrQx0HZy2ekveVu/K2kLU5av3wg7cuvUo+iNxF0VATv" +
       "vbWg7/seBC0JqjiF85UDQb/yanYrfRNp2SLAk+IQqxcG8bEFn6Qo4nsQ9XIR" +
       "+Si4fv9A1N9/ZUQ9KcT7b5L2gSJYgAFqaAml5cnggIGbx+Itb0e8PKk8ePob" +
       "leLA/SPXfUu3//5L+fyLl+9544vCv9mfdj38RuteonKPnrruyRO+J57vCiNN" +
       "t0qx792f9w1LWbSk8sx3/SUN4NriVghwQd2XN5PK1e+mfHFOrrifLOsklcdv" +
       "XhaUKu8nSxWfgZ1XKqlcAuHJ3Ouk8rob5QY5QXgyJ4i6cjYnaL+8n8y3SSr3" +
       "HecDU/D+4WSWHagdZCkePxTe4A3r/gh3fuG063JoPJWHb2U8J7ydp06d1iy/" +
       "0jw8WZnuv9N8TvnCi1PqQ99Gfnb/fYziyrtdUcs9ROXu/ac6ZaXF6cwnz63t" +
       "sK67sGe+8+Av3fv0of/04B7w8YA7ge2JG3+MMvTCpPx8ZPeP3/jL7/n5F/+g" +
       "fOH7/wHEIyUZPjsAAA==");
}
