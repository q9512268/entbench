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
       "eFCZF1eb5oiidTIugnt3MMufr4d0Oexs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+8yX87eO/z82/JbhcEgAAA==");
}
