package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFEncodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam {
    public static final int COMPRESSION_NONE = 1;
    public static final int COMPRESSION_GROUP3_1D = 2;
    public static final int COMPRESSION_GROUP3_2D = 3;
    public static final int COMPRESSION_GROUP4 = 4;
    public static final int COMPRESSION_LZW = 5;
    public static final int COMPRESSION_JPEG_BROKEN = 6;
    public static final int COMPRESSION_JPEG_TTN2 = 7;
    public static final int COMPRESSION_PACKBITS = 32773;
    public static final int COMPRESSION_DEFLATE = 32946;
    private int compression = COMPRESSION_NONE;
    private boolean writeTiled = false;
    private int tileWidth;
    private int tileHeight;
    private java.util.Iterator extraImages;
    private org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] extraFields;
    private boolean convertJPEGRGBToYCbCr = true;
    private com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam = null;
    private int deflateLevel = java.util.zip.Deflater.DEFAULT_COMPRESSION;
    public TIFFEncodeParam() { super(); }
    public int getCompression() { return compression; }
    public void setCompression(int compression) { switch (compression) { case COMPRESSION_NONE:
                                                                         case COMPRESSION_PACKBITS:
                                                                         case COMPRESSION_JPEG_TTN2:
                                                                         case COMPRESSION_DEFLATE:
                                                                             break;
                                                                         default:
                                                                             throw new java.lang.Error(
                                                                               "TIFFEncodeParam0");
                                                  }
                                                  this.
                                                    compression =
                                                    compression;
    }
    public boolean getWriteTiled() { return writeTiled;
    }
    public void setWriteTiled(boolean writeTiled) {
        this.
          writeTiled =
          writeTiled;
    }
    public void setTileSize(int tileWidth,
                            int tileHeight) {
        this.
          tileWidth =
          tileWidth;
        this.
          tileHeight =
          tileHeight;
    }
    public int getTileWidth() { return tileWidth;
    }
    public int getTileHeight() { return tileHeight;
    }
    public synchronized void setExtraImages(java.util.Iterator extraImages) {
        this.
          extraImages =
          extraImages;
    }
    public synchronized java.util.Iterator getExtraImages() {
        return extraImages;
    }
    public void setDeflateLevel(int deflateLevel) {
        if (deflateLevel <
              1 &&
              deflateLevel >
              9 &&
              deflateLevel !=
              java.util.zip.Deflater.
                DEFAULT_COMPRESSION) {
            throw new java.lang.Error(
              "TIFFEncodeParam1");
        }
        this.
          deflateLevel =
          deflateLevel;
    }
    public int getDeflateLevel() { return deflateLevel;
    }
    public void setJPEGCompressRGBToYCbCr(boolean convertJPEGRGBToYCbCr) {
        this.
          convertJPEGRGBToYCbCr =
          convertJPEGRGBToYCbCr;
    }
    public boolean getJPEGCompressRGBToYCbCr() {
        return convertJPEGRGBToYCbCr;
    }
    public void setJPEGEncodeParam(com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam) {
        if (jpegEncodeParam !=
              null) {
            jpegEncodeParam =
              (com.sun.image.codec.jpeg.JPEGEncodeParam)
                jpegEncodeParam.
                clone(
                  );
            jpegEncodeParam.
              setTableInfoValid(
                false);
            jpegEncodeParam.
              setImageInfoValid(
                true);
        }
        this.
          jpegEncodeParam =
          jpegEncodeParam;
    }
    public com.sun.image.codec.jpeg.JPEGEncodeParam getJPEGEncodeParam() {
        return jpegEncodeParam;
    }
    public void setExtraFields(org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] extraFields) {
        this.
          extraFields =
          extraFields;
    }
    public org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] getExtraFields() {
        return extraFields;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YIZzfeGAr+YuKfjgyvxISDw+WVO+eHL3r8wN/eyHPFUxUp5Iy7Lz5VHHfSm4" +
       "w4TEeawyXyXlL8mFSxhZc97b+IzMwh8EEg6b8qWMNJ2PPCOz+a9Tdg4jjcGy" +
       "ICVlY8KsVBUjS/ykGCmB1Fm6hpEFXqWhJKTOknWM1LpLQvv811luISMVdjlG" +
       "Ss0bZ5ElUDsUwdsLzFfo4InjFVvz7eCMuY281Gke/BBh4VRWlRNxfiqAFPBP" +
       "+bLbpOlu66TzxOTOzls++Odvmp8qiLIwMYG1VMZImfnVBK+0pODU1Flbtq7S" +
       "HWvOzX10zurspvQ8U2F7fC61BxEu3EIa2nK96z1+oyn3Ov9LRzb/6JcHS8+E" +
       "SWgvCQmMzN9b+B51RkvrpGFvrPAd0n5B5x8YNK/52viW9Yn3Xsm9sJz/frq7" +
       "/KD4wtF9z9+95EhjmFR2gJkpcZrhL3hvG1d6qDiqD5BqyWjLgIpQiyTIeS+o" +
       "zsVhJ+BHfpwXi87q3FP80IWRlYXv5hZ+HlQhq2NU36qmFb4ZVx0jlfYTs2dc" +
       "u9VpTXMJ2E+srsR0CJM9GewNsMfB2C5Ny766POeQxp2P6DVT8KO48Hp+i3eX" +
       "/A34UNpn5jsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1YypVxTMVa1pkGxCfLNxmonAG27DwTB7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gnODIJGGM2PsxJZQgclhUU2oOGT94ihRmiWVjYkFk9SYKGlBw6o17MN1Mca0" +
       "yWzlY612j9xQ2qZSJjhL6rbYWOepscaZI7Q9qeuMl2gemNS6oV5NGiSGEX51" +
       "yrTnjm0u8b7tmkPJ0WG+SClEq1heyWKqBZgQLHhiUXSWpGPEJNzSZ80W5RvC" +
       "cO4jA25O2JS1ZpZ9T5MDnkDHQg1YOYbLpItVdcdcF516EeJLMysOAtxbLSmk" +
       "F8hM2cQmjrfEQoVbTaNwYdIOxrGyqMd1ySFcLa1WOnR53QDmMU97Y9X0MYpT" +
       "4+JAgEEcMrNQAdjmcDmwlk1aQcHMvOH0J15cb7tx7EaNYbProVOM9mojg1+Y" +
       "AlcrLWENXfkrhjUWgu1VUV7kh0ki6au4V0M1U1fXHQEXKAGbJigGc1EctFmP" +
       "ms2hJRh9hZlqbayoFOuS6Gply2uQI6XtUU6zVgEyWVWamzZDDBiq2axPFIvH" +
       "6iCoo32MWKXMaJXqFbUpVIdri5skWGtdBAMw1Ku2cQrTw7LHDeZBPdRYdhSB" +
       "Lhkr5XqJsZW+qal80wRyp6d27LWVZC0YKM70HGwyqzfBxMvYWOYUm82rFkm4" +
       "NTAJXE+ATajTkiX2nA6Hs1i6DKdQpzvg/MBBvUXNZmcbZTmbxhLBTTCmOw5C" +
       "2Jl2q8J6ZiUjtITxAw+bgIFNGZhtQnCHI90V5KXXq4wsMWmjixU+SKaODSxv" +
       "VEUUdAMiZ94hxEVKw/aQNSQZCptpwMJc3Ou1uwkuGqwezSSfXjMzdMCzWDMG" +
       "o6Zhy7yhJptkOK310DXMJoYKZXOAaXuWqgqFecVp2FVXy02UtIfNuDgWuaJC" +
       "M1UPjVlI2dA8OUpGLtzeIEwKizStDq1aXBNaihRvJpuJyaAWOUy0mdxA5sV2" +
       "2os1tNVa1ufoetxjOxWeJ7i0KDWExbK2WsnUpk2I5hTt+iI+Wg2hjUERFl4m" +
       "rbrmtsjJeqx1ugJn2ONemXGZfhSh5bIZtoc9cbEyqaFfms/gljlq+qMYhKYp" +
       "qTq1NvBjYpQiCtELpxW0TBkKhONaTRyMzQGbqPoaI3mcL86ZucuZYb0upAkn" +
       "cKnpF4vcIrJcdK0z7bg3pcpib9a2VFvEu8WSyzVHZdKcB2sQlo4jLp2US2no" +
       "+W7UR0cVElGJehlPWmG11ZYqdrdRT8tFZ2NXuajBDNI5VO/I9BAttobjZUT0" +
       "rV4KBsAiDpcHRuS5FBl5PLYo2TAOJ+iU7UJwJdLHjaldnfhWw++kkOqBkKLb" +
       "rMUB2UgbxQbc0lYWOagsO4YrzzyNqWoRVV7U10193YTx9Wa8YpZtt69vhLYy" +
       "LDqpL2qdIk6rbjzRUWRdJXm01B4PzOkkgrVZkTb72rrCjqr1tUXOazMxKa1M" +
       "dSr4lYUcNkRXmPQ6lVbR9/xBiej0GpQSs35PxSsEzG6Qep3nlH7iVvh6UxTQ" +
       "LldDabeoV5UJhFVrI9a1YeAiMewNb8iWl//2ypa978iX8fff4FiZSJbxf65g" +
       "ZXub9VCWPLr/xCP/3Fg4tuv/0BOPvOS9u/3nu0cGr7ush2Dbh6/ZhUPPZrJd" +
       "ePdf6t2OfAfex9/11NML7mfLe09/+ezJvuP+iJk9RTmE5g7Q0msu/di0lz+9" +
       "PNgy+pl3ff0+4Y3a265gI/wrjuE83uTP9575HeqH5H9xunDd/gbSC166OVrp" +
       "saPbRs94ShB6tnBk8+j9+8o5m+nifnC8faectx9/HHWg/os/i3rV1nzyvIvu" +
       "fD519wl592TJuaDwkqUSEMc2qezb3Kk7XuhpyuFmswunbt9neOueyT25Y/jk" +
       "tWF46qAAm1N56ASaD2fJywFN/wjNiz5Nihx9cUD9/qugfld28UFwfGxH/WPX" +
       "XrmlE/JyAsWgcDtQ7nh/o09W8qMHBF97tbrNHlw/uyP47DXX7UdzJq8/geUb" +
       "swQBLP1jLE89esASvVqW2X7BT+9YfvrasDydF8j3+bIHZnySsjtZQgSFWwHV" +
       "jOVQT5VjRJtXQTR3RtmuqM/tiH7u2turcEKemCWgC9623NI72Ol1wI+/Wn4v" +
       "B8cf7vj94bXn97YT8uZZ8uZtfxSObhk7IPhjV0Ew326Z7Vr9+o7g16+AYG6I" +
       "rwLS9ze2rHmODYxrcVL3zH//x/2bvza7V+2Fbp5vz/r1XBzWCaJaZ8ly67Bb" +
       "B7vYjhm7dhWyynbZ5ePSX+7g/uUVyypr0HhBi3j7CXlPZEm0HX4P0Twm2Vyt" +
       "D74Q1K1kD4QTXwvH/v3dHb9/bXrKBYP2T50gnPdlyT8OCmeBDTSP7rM5bATv" +
       "vlqP8ABAdGZbd/t9bT3CB07I++kseRJQXF5A8bBP+OdXq0oaoL1rR/Gua67K" +
       "7Rj9r0/g+bEs+XBQ+AGgymwr114MdmR/2mGlfuRqwy7gjU7dt2N837VX6idP" +
       "yHsuSz4ByC5PIHs4BPv5q1UvAXDv3j47dcHbZ1et3i/lrH7lBMa/miW/HBTu" +
       "3Kn36E69w3r91FVQzSKTwo8AULstqacueBHp6vX6WyfkfSZLngcslxdjWfjS" +
       "AcvfuFqFIoVsf+6WJXPNFfq7OZ3Pn0D197Pks4eGX3JvJ/FhZf6Xq6B5T3bx" +
       "UQBouKM5vPbK/JMT8r6cJX90aOTdZ1j43QOGX7wShgnw48de/8/eZb73gn8j" +
       "2f6Dhvzs02dvvufp0X/b7tve+5eLW5jCzWpomodfPT10fiNwJaqeU79l+yKq" +
       "m/P5X0Hh1Ze9cRnMcrOvXCX/c1v/a0HhkcupHxRuyL8P1/3zoPDAyXVBLX0/" +
       "gNvV+r9B4d5L1QoK14H0cOm/CAovvVhpUBKkh0t+JyicO14S3D//Plzuu0Hh" +
       "zEG5oHDj9uRwke+B1kGR7PRv3FzfR3fTbt8tTraR8L2HDH27VHfnC1nPfpXD" +
       "r/5nIsj/52ZvTSrkd69nPPd0h337t+s/u/3rAdmU0jRr5WamcNP2XxDyRrN1" +
       "rYcu2dpeWzfSr/7eS37xlkf31uBesgV80OkOYXvFxd/zb1lukL+Zn/6He375" +
       "9T/39JfyN5T/P24R+RCASAAA");
}
