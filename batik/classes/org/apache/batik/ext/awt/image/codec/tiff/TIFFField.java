package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFField implements java.lang.Comparable, java.io.Serializable {
    public static final int TIFF_BYTE = 1;
    public static final int TIFF_ASCII = 2;
    public static final int TIFF_SHORT = 3;
    public static final int TIFF_LONG = 4;
    public static final int TIFF_RATIONAL = 5;
    public static final int TIFF_SBYTE = 6;
    public static final int TIFF_UNDEFINED = 7;
    public static final int TIFF_SSHORT = 8;
    public static final int TIFF_SLONG = 9;
    public static final int TIFF_SRATIONAL = 10;
    public static final int TIFF_FLOAT = 11;
    public static final int TIFF_DOUBLE = 12;
    int tag;
    int type;
    int count;
    java.lang.Object data;
    TIFFField() { super(); }
    public TIFFField(int tag, int type, int count, java.lang.Object data) {
        super(
          );
        this.
          tag =
          tag;
        this.
          type =
          type;
        this.
          count =
          count;
        this.
          data =
          data;
    }
    public int getTag() { return tag; }
    public int getType() { return type; }
    public int getCount() { return count; }
    public byte[] getAsBytes() { return (byte[]) data; }
    public char[] getAsChars() { return (char[]) data; }
    public short[] getAsShorts() { return (short[]) data; }
    public int[] getAsInts() { return (int[]) data; }
    public long[] getAsLongs() { return (long[]) data; }
    public float[] getAsFloats() { return (float[]) data; }
    public double[] getAsDoubles() { return (double[]) data; }
    public int[][] getAsSRationals() { return (int[][]) data; }
    public long[][] getAsRationals() { return (long[][]) data; }
    public int getAsInt(int index) { switch (type) { case TIFF_BYTE: case TIFF_UNDEFINED:
                                                         return ((byte[])
                                                                   data)[index] &
                                                           255;
                                                     case TIFF_SBYTE:
                                                         return ((byte[])
                                                                   data)[index];
                                                     case TIFF_SHORT:
                                                         return ((char[])
                                                                   data)[index] &
                                                           65535;
                                                     case TIFF_SSHORT:
                                                         return ((short[])
                                                                   data)[index];
                                                     case TIFF_SLONG:
                                                         return ((int[])
                                                                   data)[index];
                                                     default:
                                                         throw new java.lang.ClassCastException(
                                                           );
                                     } }
    public long getAsLong(int index) { switch (type) {
                                           case TIFF_BYTE:
                                           case TIFF_UNDEFINED:
                                               return ((byte[])
                                                         data)[index] &
                                                 255;
                                           case TIFF_SBYTE:
                                               return ((byte[])
                                                         data)[index];
                                           case TIFF_SHORT:
                                               return ((char[])
                                                         data)[index] &
                                                 65535;
                                           case TIFF_SSHORT:
                                               return ((short[])
                                                         data)[index];
                                           case TIFF_SLONG:
                                               return ((int[])
                                                         data)[index];
                                           case TIFF_LONG:
                                               return ((long[])
                                                         data)[index];
                                           default:
                                               throw new java.lang.ClassCastException(
                                                 );
                                       } }
    public float getAsFloat(int index) { switch (type) {
                                             case TIFF_BYTE:
                                                 return ((byte[])
                                                           data)[index] &
                                                   255;
                                             case TIFF_SBYTE:
                                                 return ((byte[])
                                                           data)[index];
                                             case TIFF_SHORT:
                                                 return ((char[])
                                                           data)[index] &
                                                   65535;
                                             case TIFF_SSHORT:
                                                 return ((short[])
                                                           data)[index];
                                             case TIFF_SLONG:
                                                 return ((int[])
                                                           data)[index];
                                             case TIFF_LONG:
                                                 return ((long[])
                                                           data)[index];
                                             case TIFF_FLOAT:
                                                 return ((float[])
                                                           data)[index];
                                             case TIFF_DOUBLE:
                                                 return (float)
                                                          ((double[])
                                                             data)[index];
                                             case TIFF_SRATIONAL:
                                                 int[] ivalue =
                                                   getAsSRational(
                                                     index);
                                                 return (float)
                                                          ((double)
                                                             ivalue[0] /
                                                             ivalue[1]);
                                             case TIFF_RATIONAL:
                                                 long[] lvalue =
                                                   getAsRational(
                                                     index);
                                                 return (float)
                                                          ((double)
                                                             lvalue[0] /
                                                             lvalue[1]);
                                             default:
                                                 throw new java.lang.ClassCastException(
                                                   );
                                         }
    }
    public double getAsDouble(int index) {
        switch (type) {
            case TIFF_BYTE:
                return ((byte[])
                          data)[index] &
                  255;
            case TIFF_SBYTE:
                return ((byte[])
                          data)[index];
            case TIFF_SHORT:
                return ((char[])
                          data)[index] &
                  65535;
            case TIFF_SSHORT:
                return ((short[])
                          data)[index];
            case TIFF_SLONG:
                return ((int[])
                          data)[index];
            case TIFF_LONG:
                return ((long[])
                          data)[index];
            case TIFF_FLOAT:
                return ((float[])
                          data)[index];
            case TIFF_DOUBLE:
                return ((double[])
                          data)[index];
            case TIFF_SRATIONAL:
                int[] ivalue =
                  getAsSRational(
                    index);
                return (double)
                         ivalue[0] /
                  ivalue[1];
            case TIFF_RATIONAL:
                long[] lvalue =
                  getAsRational(
                    index);
                return (double)
                         lvalue[0] /
                  lvalue[1];
            default:
                throw new java.lang.ClassCastException(
                  );
        }
    }
    public java.lang.String getAsString(int index) {
        return ((java.lang.String[])
                  data)[index];
    }
    public int[] getAsSRational(int index) {
        return ((int[][])
                  data)[index];
    }
    public long[] getAsRational(int index) {
        return ((long[][])
                  data)[index];
    }
    public int compareTo(java.lang.Object o) {
        if (o ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        int oTag =
          ((org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
             o).
          getTag(
            );
        if (tag <
              oTag) {
            return -1;
        }
        else
            if (tag >
                  oTag) {
                return 1;
            }
            else {
                return 0;
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WCv4f7qCuW0MTwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A6RgIkar44RmpOmwugDcGjNv9Pz5NGM0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "qbvmeZBzZL5clj2eX5/Zy/xnbr3Mv/+csu8pku/K1yulzJPe2RKfB4i3j3f4" +
       "dveb98lyEERAtNYXoZ9GWgiMc+vDmIqthYzsac6tcv0vZphyArGri/T3Hor0" +
       "P78hkf7gDYr095YM+uC1RPrD55T9qyL50JFIf/A8kf7ISZG+5qGRF+O9/2Av" +
       "0n9w60X6R88p+7Ei+eFD713s8D0t0yXCfCl328UdwN09rrz9FlvWwqp6uukd" +
       "me6XdoBy1v7scn/8b26FP/7CnpFfuPWM/Nlzyn6uSH7q0B/3HF++wjoVlrPy" +
       "mvx64x7iG3ecFG7WbOTTW5wx98OjiT7k4UvV9dnedllSfVXT9AuHpulXbsg0" +
       "ffIGTdMvlPz55LVM06+fU/abRfKrR6bpk+eZpt8+aZp++iYkujjFXqxjKy/s" +
       "xeWFWy/R/+2cst8vkt+JK/eVEt31k3xJd1qkC3LK8yX6HqO+E2n7ltmOnob5" +
       "3rr4pBAlx6GZnRllfjWHO1P0L6rl9Fxuzq55GOVa5qz4tfgr+4n9yq1n/p+f" +
       "U/aXRfKFuPLgbnnBlqovO6f5X64ki8x79zDfu+P/zYb9h4s9KnFiM3A0IpRV" +
       "M2/MyKYX7z9XdauWGC96rF2Ic3X79sKhffvyDdm3L92gfXuhxPWla9m3vz2n" +
       "7O+K5G+O7NuXzrNv/3DSvv3pzdq3XMQPDnZtd/dbKuIX7jinrDgTfCGX1QdK" +
       "Eb+ahB/9ePLEHuUTe5QHbyt5/a3lpPz4ZZp/4eAW/L598Mh+wEduzbQcHFfA" +
       "SvofPWduXl4kD+x+5C5XWmWzYwIfvAkCy2pfk0Op7QmsvUQEvuYcAovfGy88" +
       "friUHO1PtP3ZMYVfe7Pr5K/NseyXobv7S0Bh9RwKv7FIvv5wZVEGpAXKXz4m" +
       "8Y03u256dfnJnB2J8UtEInIOia0iAQ9j7l2EUsD8o2MaG7eCxh/a0/hDLxGN" +
       "2Dk0FkejL3zz0e98R+dJ//CYxrferKjma5KDH9nT+CMvEY30OTROimRwaImP" +
       "go3VkbstyRzeLCsLMvcv1g5u0Yu1K8h82zlkvr1IZnHl/sscTgH0x4+pFG7W" +
       "dTx2+s3XLaVyUFKin0OlWSSLuPiKUbFtQZuW32Q84TuU6/ok0/5TLOX3kopv" +
       "pz12xSdOd5/lVH7yuQfveuVz/O/v3iUefjrz7lHlrmXiOCc/T3QifzEItaVZ" +
       "En13mT4QlETkYeVTL/oziMVR/fxWYL/g79oXX4F9Me3Lg/X5/WTbdVx54vy2" +
       "eavyfrLVJq48drVWceW2PD1Z+zviysvOqp3XzNOTNd8VVx46XTMfv7yfrPee" +
       "3NMc18tXRLvMySrvzXvPqxTZ7w52wrSLnh87Ic673ULX3CBw1OTk1wQLcssP" +
       "5R5uKEmY/dafTzw3GL/jy80f3X3NUHHk7bbo5a5R5c7dhxXLTotNKa+7am+H" +
       "fV3sP/X3D/zU3V93uIHmgR3gY9U6ge01Z39DEHeDuPzq3/bnX/kzb/mx5/64" +
       "/GLV/we/HaL+wVgAAA==");
}
