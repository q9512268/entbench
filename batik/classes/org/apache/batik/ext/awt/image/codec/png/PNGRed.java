package org.apache.batik.ext.awt.image.codec.png;
public class PNGRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static class PNGChunk {
        int length;
        int type;
        byte[] data;
        int crc;
        java.lang.String typeString;
        public PNGChunk(int length, int type, byte[] data, int crc) { super(
                                                                        );
                                                                      this.
                                                                        length =
                                                                        length;
                                                                      this.
                                                                        type =
                                                                        type;
                                                                      this.
                                                                        data =
                                                                        data;
                                                                      this.
                                                                        crc =
                                                                        crc;
                                                                      typeString =
                                                                        "";
                                                                      typeString +=
                                                                        (char)
                                                                          (type >>
                                                                             24);
                                                                      typeString +=
                                                                        (char)
                                                                          (type >>
                                                                             16 &
                                                                             255);
                                                                      typeString +=
                                                                        (char)
                                                                          (type >>
                                                                             8 &
                                                                             255);
                                                                      typeString +=
                                                                        (char)
                                                                          (type &
                                                                             255);
        }
        public int getLength() { return length;
        }
        public int getType() { return type;
        }
        public java.lang.String getTypeString() {
            return typeString;
        }
        public byte[] getData() { return data;
        }
        public byte getByte(int offset) {
            return data[offset];
        }
        public int getInt1(int offset) { return data[offset] &
                                           255;
        }
        public int getInt2(int offset) { return (data[offset] &
                                                   255) <<
                                           8 |
                                           data[offset +
                                                  1] &
                                           255;
        }
        public int getInt4(int offset) { return (data[offset] &
                                                   255) <<
                                           24 |
                                           (data[offset +
                                                   1] &
                                              255) <<
                                           16 |
                                           (data[offset +
                                                   2] &
                                              255) <<
                                           8 |
                                           data[offset +
                                                  3] &
                                           255;
        }
        public java.lang.String getString4(int offset) {
            java.lang.String s =
              new java.lang.String(
              );
            s +=
              (char)
                data[offset];
            s +=
              (char)
                data[offset +
                       1];
            s +=
              (char)
                data[offset +
                       2];
            s +=
              (char)
                data[offset +
                       3];
            return s;
        }
        public boolean isType(java.lang.String typeName) {
            return typeString.
              equals(
                typeName);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "zG8Rvv95Dr4/z4v/vsPXd6PymbX3P94O");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("fM4hPudbhO8bd8d3UJD91TG+yhl8X3878AWH+IJvDb6D+8/B92BeXDrGVzuN" +
           "7+DyW3Utz4IrO8SXfYvwPX4Ovm/Li0ci6CrAt3OeBcS99zx49C1AzE//Fd7z" +
           "pUOIL73tEF8uYDx3DsT8aMPB0yALMcPjs4pnvpldlj3P1iR3j/qZN4M6jaAr" +
           "RwdRi8Z3RhDyJk+ygrzqidtOzu9Oeyufe/XalcdfFX5/d7rr6ET2fQx0ZRnb" +
           "9smjNifql/xAW5qF+u7bnXfwC3WUI+h936xsEXTR333oPSjtuEFieuOb4c4P" +
           "g+S/J3lBJvj0+byAq/g9yfU3IuiJu3EB+UB5kvqFCHrHnagBJShPUn4ogq6f" +
           "pQTjF78n6XCwOPZ0wIx2lZMkJOgdkOTVrn9kACe+B+9OUqUHpxPpYyf5yBvZ" +
           "2onc+7lTJ2GK/8g4Oj4U7/4n45by+Vepwfd9rfHTu5Ozii1tt3kvVxjo8u4Q" +
           "b9FpfgTp3Xft7aivS733f/2hn7vvvUfZ/EM7gffL9oRsz9z5mCrh+FFxsHT7" +
           "Tx//Jx/8B6/+YfFB/P8BcrlD4CozAAA=");
    }
    public static final int PNG_COLOR_GRAY =
      0;
    public static final int PNG_COLOR_RGB =
      2;
    public static final int PNG_COLOR_PALETTE =
      3;
    public static final int PNG_COLOR_GRAY_ALPHA =
      4;
    public static final int PNG_COLOR_RGB_ALPHA =
      6;
    private static final java.lang.String[]
      colorTypeNames =
      { "Grayscale",
    "Error",
    "Truecolor",
    "Index",
    "Grayscale with alpha",
    "Error",
    "Truecolor with alpha" };
    public static final int PNG_FILTER_NONE =
      0;
    public static final int PNG_FILTER_SUB =
      1;
    public static final int PNG_FILTER_UP =
      2;
    public static final int PNG_FILTER_AVERAGE =
      3;
    public static final int PNG_FILTER_PAETH =
      4;
    private int[][] bandOffsets = { null,
    { 0 },
    { 0,
    1 },
    { 0,
    1,
    2 },
    { 0,
    1,
    2,
    3 } };
    private int bitDepth;
    private int colorType;
    private int compressionMethod;
    private int filterMethod;
    private int interlaceMethod;
    private int paletteEntries;
    private byte[] redPalette;
    private byte[] greenPalette;
    private byte[] bluePalette;
    private byte[] alphaPalette;
    private int bkgdRed;
    private int bkgdGreen;
    private int bkgdBlue;
    private int grayTransparentAlpha;
    private int redTransparentAlpha;
    private int greenTransparentAlpha;
    private int blueTransparentAlpha;
    private int maxOpacity;
    private int[] significantBits = null;
    private boolean suppressAlpha = false;
    private boolean expandPalette = false;
    private boolean output8BitGray = false;
    private boolean outputHasAlphaPalette =
      false;
    private boolean performGammaCorrection =
      false;
    private boolean expandGrayAlpha = false;
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam
      decodeParam =
      null;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    private boolean emitProperties = true;
    private float fileGamma = 45455 / 100000.0F;
    private float userExponent = 1.0F;
    private float displayExponent = 2.2F;
    private float[] chromaticity = null;
    private int sRGBRenderingIntent = -1;
    private int postProcess = POST_NONE;
    private static final int POST_NONE = 0;
    private static final int POST_GAMMA =
      1;
    private static final int POST_GRAY_LUT =
      2;
    private static final int POST_GRAY_LUT_ADD_TRANS =
      3;
    private static final int POST_PALETTE_TO_RGB =
      4;
    private static final int POST_PALETTE_TO_RGBA =
      5;
    private static final int POST_ADD_GRAY_TRANS =
      6;
    private static final int POST_ADD_RGB_TRANS =
      7;
    private static final int POST_REMOVE_GRAY_TRANS =
      8;
    private static final int POST_REMOVE_RGB_TRANS =
      9;
    private static final int POST_EXP_MASK =
      16;
    private static final int POST_GRAY_ALPHA_EXP =
      POST_NONE |
      POST_EXP_MASK;
    private static final int POST_GAMMA_EXP =
      POST_GAMMA |
      POST_EXP_MASK;
    private static final int POST_GRAY_LUT_ADD_TRANS_EXP =
      POST_GRAY_LUT_ADD_TRANS |
      POST_EXP_MASK;
    private static final int POST_ADD_GRAY_TRANS_EXP =
      POST_ADD_GRAY_TRANS |
      POST_EXP_MASK;
    private java.util.List<java.io.InputStream>
      streamVec =
      new java.util.ArrayList<java.io.InputStream>(
      );
    private java.io.DataInputStream dataStream;
    private int bytesPerPixel;
    private int inputBands;
    private int outputBands;
    private int chunkIndex = 0;
    private java.util.List textKeys = new java.util.ArrayList(
      );
    private java.util.List textStrings = new java.util.ArrayList(
      );
    private java.util.List ztextKeys = new java.util.ArrayList(
      );
    private java.util.List ztextStrings =
      new java.util.ArrayList(
      );
    private java.awt.image.WritableRaster
      theTile;
    private java.awt.Rectangle bounds;
    private java.util.Map properties = new java.util.HashMap(
      );
    private int[] gammaLut = null;
    private void initGammaLut(int bits) {
        double exp =
          (double)
            userExponent /
          (fileGamma *
             displayExponent);
        int numSamples =
          1 <<
          bits;
        int maxOutSample =
          bits ==
          16
          ? 65535
          : 255;
        gammaLut =
          (new int[numSamples]);
        for (int i =
               0;
             i <
               numSamples;
             i++) {
            double gbright =
              (double)
                i /
              (numSamples -
                 1);
            double gamma =
              java.lang.Math.
              pow(
                gbright,
                exp);
            int igamma =
              (int)
                (gamma *
                   maxOutSample +
                   0.5);
            if (igamma >
                  maxOutSample) {
                igamma =
                  maxOutSample;
            }
            gammaLut[i] =
              igamma;
        }
    }
    private final byte[][] expandBits = { null,
    { (byte)
        0,
    (byte)
      255 },
    { (byte)
        0,
    (byte)
      85,
    (byte)
      170,
    (byte)
      255 },
    null,
    { (byte)
        0,
    (byte)
      17,
    (byte)
      34,
    (byte)
      51,
    (byte)
      68,
    (byte)
      85,
    (byte)
      102,
    (byte)
      119,
    (byte)
      136,
    (byte)
      153,
    (byte)
      170,
    (byte)
      187,
    (byte)
      204,
    (byte)
      221,
    (byte)
      238,
    (byte)
      255 } };
    private int[] grayLut = null;
    private void initGrayLut(int bits) { int len =
                                           1 <<
                                           bits;
                                         grayLut =
                                           (new int[len]);
                                         if (performGammaCorrection) {
                                             java.lang.System.
                                               arraycopy(
                                                 gammaLut,
                                                 0,
                                                 grayLut,
                                                 0,
                                                 len);
                                         }
                                         else {
                                             for (int i =
                                                    0;
                                                  i <
                                                    len;
                                                  i++) {
                                                 grayLut[i] =
                                                   expandBits[bits][i];
                                             }
                                         }
    }
    public PNGRed(java.io.InputStream stream)
          throws java.io.IOException { this(
                                         stream,
                                         null);
    }
    public PNGRed(java.io.InputStream stream,
                  org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam decodeParam)
          throws java.io.IOException { super(
                                         );
                                       if (!stream.
                                             markSupported(
                                               )) {
                                           stream =
                                             new java.io.BufferedInputStream(
                                               stream);
                                       }
                                       java.io.DataInputStream distream =
                                         new java.io.DataInputStream(
                                         stream);
                                       if (decodeParam ==
                                             null) {
                                           decodeParam =
                                             new org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam(
                                               );
                                       }
                                       this.
                                         decodeParam =
                                         decodeParam;
                                       this.
                                         suppressAlpha =
                                         decodeParam.
                                           getSuppressAlpha(
                                             );
                                       this.
                                         expandPalette =
                                         decodeParam.
                                           getExpandPalette(
                                             );
                                       this.
                                         output8BitGray =
                                         decodeParam.
                                           getOutput8BitGray(
                                             );
                                       this.
                                         expandGrayAlpha =
                                         decodeParam.
                                           getExpandGrayAlpha(
                                             );
                                       if (decodeParam.
                                             getPerformGammaCorrection(
                                               )) {
                                           this.
                                             userExponent =
                                             decodeParam.
                                               getUserExponent(
                                                 );
                                           this.
                                             displayExponent =
                                             decodeParam.
                                               getDisplayExponent(
                                                 );
                                           performGammaCorrection =
                                             true;
                                           output8BitGray =
                                             true;
                                       }
                                       this.
                                         generateEncodeParam =
                                         decodeParam.
                                           getGenerateEncodeParam(
                                             );
                                       if (emitProperties) {
                                           properties.
                                             put(
                                               "file_type",
                                               "PNG v. 1.0");
                                       }
                                       try {
                                           long magic =
                                             distream.
                                             readLong(
                                               );
                                           if (magic !=
                                                 -8552249625308161526L) {
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder0");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }
                                       catch (java.lang.Exception e) {
                                           e.
                                             printStackTrace(
                                               );
                                           java.lang.String msg =
                                             org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                             getString(
                                               "PNGImageDecoder1");
                                           throw new java.lang.RuntimeException(
                                             msg);
                                       }
                                       do  {
                                           try {
                                               org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk;
                                               java.lang.String chunkType =
                                                 getChunkType(
                                                   distream);
                                               if (chunkType.
                                                     equals(
                                                       "IHDR")) {
                                                   chunk =
                                                     readChunk(
                                                       distream);
                                                   parse_IHDR_chunk(
                                                     chunk);
                                               }
                                               else
                                                   if (chunkType.
                                                         equals(
                                                           "PLTE")) {
                                                       chunk =
                                                         readChunk(
                                                           distream);
                                                       parse_PLTE_chunk(
                                                         chunk);
                                                   }
                                                   else
                                                       if (chunkType.
                                                             equals(
                                                               "IDAT")) {
                                                           chunk =
                                                             readChunk(
                                                               distream);
                                                           streamVec.
                                                             add(
                                                               new java.io.ByteArrayInputStream(
                                                                 chunk.
                                                                   getData(
                                                                     )));
                                                       }
                                                       else
                                                           if (chunkType.
                                                                 equals(
                                                                   "IEND")) {
                                                               chunk =
                                                                 readChunk(
                                                                   distream);
                                                               parse_IEND_chunk(
                                                                 chunk);
                                                               break;
                                                           }
                                                           else
                                                               if (chunkType.
                                                                     equals(
                                                                       "bKGD")) {
                                                                   chunk =
                                                                     readChunk(
                                                                       distream);
                                                                   parse_bKGD_chunk(
                                                                     chunk);
                                                               }
                                                               else
                                                                   if (chunkType.
                                                                         equals(
                                                                           "cHRM")) {
                                                                       chunk =
                                                                         readChunk(
                                                                           distream);
                                                                       parse_cHRM_chunk(
                                                                         chunk);
                                                                   }
                                                                   else
                                                                       if (chunkType.
                                                                             equals(
                                                                               "gAMA")) {
                                                                           chunk =
                                                                             readChunk(
                                                                               distream);
                                                                           parse_gAMA_chunk(
                                                                             chunk);
                                                                       }
                                                                       else
                                                                           if (chunkType.
                                                                                 equals(
                                                                                   "hIST")) {
                                                                               chunk =
                                                                                 readChunk(
                                                                                   distream);
                                                                               parse_hIST_chunk(
                                                                                 chunk);
                                                                           }
                                                                           else
                                                                               if (chunkType.
                                                                                     equals(
                                                                                       "iCCP")) {
                                                                                   chunk =
                                                                                     readChunk(
                                                                                       distream);
                                                                                   parse_iCCP_chunk(
                                                                                     chunk);
                                                                               }
                                                                               else
                                                                                   if (chunkType.
                                                                                         equals(
                                                                                           "pHYs")) {
                                                                                       chunk =
                                                                                         readChunk(
                                                                                           distream);
                                                                                       parse_pHYs_chunk(
                                                                                         chunk);
                                                                                   }
                                                                                   else
                                                                                       if (chunkType.
                                                                                             equals(
                                                                                               "sBIT")) {
                                                                                           chunk =
                                                                                             readChunk(
                                                                                               distream);
                                                                                           parse_sBIT_chunk(
                                                                                             chunk);
                                                                                       }
                                                                                       else
                                                                                           if (chunkType.
                                                                                                 equals(
                                                                                                   "sRGB")) {
                                                                                               chunk =
                                                                                                 readChunk(
                                                                                                   distream);
                                                                                               parse_sRGB_chunk(
                                                                                                 chunk);
                                                                                           }
                                                                                           else
                                                                                               if (chunkType.
                                                                                                     equals(
                                                                                                       "tEXt")) {
                                                                                                   chunk =
                                                                                                     readChunk(
                                                                                                       distream);
                                                                                                   parse_tEXt_chunk(
                                                                                                     chunk);
                                                                                               }
                                                                                               else
                                                                                                   if (chunkType.
                                                                                                         equals(
                                                                                                           "tIME")) {
                                                                                                       chunk =
                                                                                                         readChunk(
                                                                                                           distream);
                                                                                                       parse_tIME_chunk(
                                                                                                         chunk);
                                                                                                   }
                                                                                                   else
                                                                                                       if (chunkType.
                                                                                                             equals(
                                                                                                               "tRNS")) {
                                                                                                           chunk =
                                                                                                             readChunk(
                                                                                                               distream);
                                                                                                           parse_tRNS_chunk(
                                                                                                             chunk);
                                                                                                       }
                                                                                                       else
                                                                                                           if (chunkType.
                                                                                                                 equals(
                                                                                                                   "zTXt")) {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               parse_zTXt_chunk(
                                                                                                                 chunk);
                                                                                                           }
                                                                                                           else {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               java.lang.String type =
                                                                                                                 chunk.
                                                                                                                 getTypeString(
                                                                                                                   );
                                                                                                               byte[] data =
                                                                                                                 chunk.
                                                                                                                 getData(
                                                                                                                   );
                                                                                                               if (encodeParam !=
                                                                                                                     null) {
                                                                                                                   encodeParam.
                                                                                                                     addPrivateChunk(
                                                                                                                       type,
                                                                                                                       data);
                                                                                                               }
                                                                                                               if (emitProperties) {
                                                                                                                   java.lang.String key =
                                                                                                                     "chunk_" +
                                                                                                                   chunkIndex++ +
                                                                                                                   ':' +
                                                                                                                   type;
                                                                                                                   properties.
                                                                                                                     put(
                                                                                                                       key.
                                                                                                                         toLowerCase(
                                                                                                                           ),
                                                                                                                       data);
                                                                                                               }
                                                                                                           }
                                           }
                                           catch (java.lang.Exception e) {
                                               e.
                                                 printStackTrace(
                                                   );
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder2");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }while(true); 
                                       if (significantBits ==
                                             null) {
                                           significantBits =
                                             (new int[inputBands]);
                                           for (int i =
                                                  0;
                                                i <
                                                  inputBands;
                                                i++) {
                                               significantBits[i] =
                                                 bitDepth;
                                           }
                                           if (emitProperties) {
                                               properties.
                                                 put(
                                                   "significant_bits",
                                                   significantBits);
                                           }
                                       } }
    private static java.lang.String getChunkType(java.io.DataInputStream distream) {
        try {
            distream.
              mark(
                8);
            distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            distream.
              reset(
                );
            java.lang.String typeString =
              "" +
            (char)
              (type >>
                 24 &
                 255) +
            (char)
              (type >>
                 16 &
                 255) +
            (char)
              (type >>
                 8 &
                 255) +
            (char)
              (type &
                 255);
            return typeString;
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private static org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk readChunk(java.io.DataInputStream distream) {
        try {
            int length =
              distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            byte[] data =
              new byte[length];
            distream.
              readFully(
                data);
            int crc =
              distream.
              readInt(
                );
            return new org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk(
              length,
              type,
              data,
              crc);
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private void parse_IHDR_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        int width =
          chunk.
          getInt4(
            0);
        int height =
          chunk.
          getInt4(
            4);
        bounds =
          new java.awt.Rectangle(
            0,
            0,
            width,
            height);
        bitDepth =
          chunk.
            getInt1(
              8);
        int validMask =
          1 <<
          1 |
          1 <<
          2 |
          1 <<
          4 |
          1 <<
          8 |
          1 <<
          16;
        if ((1 <<
               bitDepth &
               validMask) ==
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder3");
            throw new java.lang.RuntimeException(
              msg);
        }
        maxOpacity =
          (1 <<
             bitDepth) -
            1;
        colorType =
          chunk.
            getInt1(
              9);
        if (colorType !=
              PNG_COLOR_GRAY &&
              colorType !=
              PNG_COLOR_RGB &&
              colorType !=
              PNG_COLOR_PALETTE &&
              colorType !=
              PNG_COLOR_GRAY_ALPHA &&
              colorType !=
              PNG_COLOR_RGB_ALPHA) {
            java.lang.System.
              out.
              println(
                org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder4"));
        }
        if (colorType ==
              PNG_COLOR_RGB &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder5");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_PALETTE &&
              bitDepth ==
              16) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder6");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_GRAY_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder7");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_RGB_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder8");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (emitProperties) {
            properties.
              put(
                "color_type",
                colorTypeNames[colorType]);
        }
        if (generateEncodeParam) {
            if (colorType ==
                  PNG_COLOR_PALETTE) {
                encodeParam =
                  new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette(
                    );
            }
            else
                if (colorType ==
                      PNG_COLOR_GRAY ||
                      colorType ==
                      PNG_COLOR_GRAY_ALPHA) {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray(
                        );
                }
                else {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB(
                        );
                }
            decodeParam.
              setEncodeParam(
                encodeParam);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setBitDepth(
                bitDepth);
        }
        if (emitProperties) {
            properties.
              put(
                "bit_depth",
                new java.lang.Integer(
                  bitDepth));
        }
        if (performGammaCorrection) {
            float gamma =
              1.0F /
              2.2F *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
            }
        }
        compressionMethod =
          chunk.
            getInt1(
              10);
        if (compressionMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder9");
            throw new java.lang.RuntimeException(
              msg);
        }
        filterMethod =
          chunk.
            getInt1(
              11);
        if (filterMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder10");
            throw new java.lang.RuntimeException(
              msg);
        }
        interlaceMethod =
          chunk.
            getInt1(
              12);
        if (interlaceMethod ==
              0) {
            if (encodeParam !=
                  null) {
                encodeParam.
                  setInterlacing(
                    false);
            }
            if (emitProperties) {
                properties.
                  put(
                    "interlace_method",
                    "None");
            }
        }
        else
            if (interlaceMethod ==
                  1) {
                if (encodeParam !=
                      null) {
                    encodeParam.
                      setInterlacing(
                        true);
                }
                if (emitProperties) {
                    properties.
                      put(
                        "interlace_method",
                        "Adam7");
                }
            }
            else {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder11");
                throw new java.lang.RuntimeException(
                  msg);
            }
        bytesPerPixel =
          bitDepth ==
            16
            ? 2
            : 1;
        switch (colorType) {
            case PNG_COLOR_GRAY:
                inputBands =
                  1;
                outputBands =
                  1;
                if (output8BitGray &&
                      bitDepth <
                      8) {
                    postProcess =
                      POST_GRAY_LUT;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
            case PNG_COLOR_RGB:
                inputBands =
                  3;
                bytesPerPixel *=
                  3;
                outputBands =
                  3;
                if (performGammaCorrection) {
                    postProcess =
                      POST_GAMMA;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_PALETTE:
                inputBands =
                  1;
                bytesPerPixel =
                  1;
                outputBands =
                  expandPalette
                    ? 3
                    : 1;
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGB;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_GRAY_ALPHA:
                inputBands =
                  2;
                bytesPerPixel *=
                  2;
                if (suppressAlpha) {
                    outputBands =
                      1;
                    postProcess =
                      POST_REMOVE_GRAY_TRANS;
                }
                else {
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                    if (expandGrayAlpha) {
                        postProcess |=
                          POST_EXP_MASK;
                        outputBands =
                          4;
                    }
                    else {
                        outputBands =
                          2;
                    }
                }
                break;
            case PNG_COLOR_RGB_ALPHA:
                inputBands =
                  4;
                bytesPerPixel *=
                  4;
                outputBands =
                  !suppressAlpha
                    ? 4
                    : 3;
                if (suppressAlpha) {
                    postProcess =
                      POST_REMOVE_RGB_TRANS;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
        }
    }
    private void parse_IEND_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk)
          throws java.lang.Exception { int textLen =
                                         textKeys.
                                         size(
                                           );
                                       java.lang.String[] textArray =
                                         new java.lang.String[2 *
                                                                textLen];
                                       for (int i =
                                              0;
                                            i <
                                              textLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               textKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               textStrings.
                                               get(
                                                 i);
                                           textArray[2 *
                                                       i] =
                                             key;
                                           textArray[2 *
                                                       i +
                                                       1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "text_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setText(
                                               textArray);
                                       }
                                       int ztextLen =
                                         ztextKeys.
                                         size(
                                           );
                                       java.lang.String[] ztextArray =
                                         new java.lang.String[2 *
                                                                ztextLen];
                                       for (int i =
                                              0;
                                            i <
                                              ztextLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               ztextKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               ztextStrings.
                                               get(
                                                 i);
                                           ztextArray[2 *
                                                        i] =
                                             key;
                                           ztextArray[2 *
                                                        i +
                                                        1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "ztext_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setCompressedText(
                                               ztextArray);
                                       }
                                       java.io.InputStream seqStream =
                                         new java.io.SequenceInputStream(
                                         java.util.Collections.
                                           enumeration(
                                             streamVec));
                                       java.io.InputStream infStream =
                                         new java.util.zip.InflaterInputStream(
                                         seqStream,
                                         new java.util.zip.Inflater(
                                           ));
                                       dataStream =
                                         new java.io.DataInputStream(
                                           infStream);
                                       int depth =
                                         bitDepth;
                                       if (colorType ==
                                             PNG_COLOR_GRAY &&
                                             bitDepth <
                                             8 &&
                                             output8BitGray) {
                                           depth =
                                             8;
                                       }
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             expandPalette) {
                                           depth =
                                             8;
                                       }
                                       int width =
                                         bounds.
                                           width;
                                       int height =
                                         bounds.
                                           height;
                                       int bytesPerRow =
                                         (outputBands *
                                            width *
                                            depth +
                                            7) /
                                         8;
                                       int scanlineStride =
                                         depth ==
                                         16
                                         ? bytesPerRow /
                                         2
                                         : bytesPerRow;
                                       theTile =
                                         createRaster(
                                           width,
                                           height,
                                           outputBands,
                                           scanlineStride,
                                           depth);
                                       if (performGammaCorrection &&
                                             gammaLut ==
                                             null) {
                                           initGammaLut(
                                             bitDepth);
                                       }
                                       if (postProcess ==
                                             POST_GRAY_LUT ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS_EXP) {
                                           initGrayLut(
                                             bitDepth);
                                       }
                                       decodeImage(
                                         interlaceMethod ==
                                           1);
                                       java.awt.image.SampleModel sm =
                                         theTile.
                                         getSampleModel(
                                           );
                                       java.awt.image.ColorModel cm;
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             !expandPalette) {
                                           if (outputHasAlphaPalette) {
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette,
                                                   alphaPalette);
                                           }
                                           else {
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette);
                                           }
                                       }
                                       else
                                           if (colorType ==
                                                 PNG_COLOR_GRAY &&
                                                 bitDepth <
                                                 8 &&
                                                 !output8BitGray) {
                                               byte[] palette =
                                                 expandBits[bitDepth];
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   palette.
                                                     length,
                                                   palette,
                                                   palette,
                                                   palette);
                                           }
                                           else {
                                               cm =
                                                 createComponentColorModel(
                                                   sm);
                                           }
                                       init(
                                         (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                           null,
                                         bounds,
                                         cm,
                                         sm,
                                         0,
                                         0,
                                         properties);
    }
    private static final int[] GrayBits8 =
      { 8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayAlphaBits8 =
      { 8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayBits16 =
      { 16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayAlphaBits16 =
      { 16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayBits32 =
      { 32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] GrayAlphaBits32 =
      { 32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBBits8 =
      { 8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBABits8 =
      { 8,
    8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBBits16 =
      { 16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBABits16 =
      { 16,
    16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBBits32 =
      { 32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBABits32 =
      { 32,
    32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static java.awt.image.ColorModel createComponentColorModel(java.awt.image.SampleModel sm) {
        int type =
          sm.
          getDataType(
            );
        int bands =
          sm.
          getNumBands(
            );
        java.awt.image.ComponentColorModel cm =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            switch (bands) {
                case 1:
                    cm =
                      colorModelGray8;
                    break;
                case 2:
                    cm =
                      colorModelGrayAlpha8;
                    break;
                case 3:
                    cm =
                      colorModelRGB8;
                    break;
                case 4:
                    cm =
                      colorModelRGBA8;
                    break;
            }
        }
        else
            if (type ==
                  java.awt.image.DataBuffer.
                    TYPE_USHORT) {
                switch (bands) {
                    case 1:
                        cm =
                          colorModelGray16;
                        break;
                    case 2:
                        cm =
                          colorModelGrayAlpha16;
                        break;
                    case 3:
                        cm =
                          colorModelRGB16;
                        break;
                    case 4:
                        cm =
                          colorModelRGBA16;
                        break;
                }
            }
            else
                if (type ==
                      java.awt.image.DataBuffer.
                        TYPE_INT) {
                    switch (bands) {
                        case 1:
                            cm =
                              colorModelGray32;
                            break;
                        case 2:
                            cm =
                              colorModelGrayAlpha32;
                            break;
                        case 3:
                            cm =
                              colorModelRGB32;
                            break;
                        case 4:
                            cm =
                              colorModelRGBA32;
                            break;
                    }
                }
        return cm;
    }
    private void parse_PLTE_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        paletteEntries =
          chunk.
            getLength(
              ) /
            3;
        redPalette =
          (new byte[paletteEntries]);
        greenPalette =
          (new byte[paletteEntries]);
        bluePalette =
          (new byte[paletteEntries]);
        int pltIndex =
          0;
        if (performGammaCorrection) {
            if (gammaLut ==
                  null) {
                initGammaLut(
                  bitDepth ==
                    16
                    ? 16
                    : 8);
            }
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                byte r =
                  chunk.
                  getByte(
                    pltIndex++);
                byte g =
                  chunk.
                  getByte(
                    pltIndex++);
                byte b =
                  chunk.
                  getByte(
                    pltIndex++);
                redPalette[i] =
                  (byte)
                    gammaLut[r &
                               255];
                greenPalette[i] =
                  (byte)
                    gammaLut[g &
                               255];
                bluePalette[i] =
                  (byte)
                    gammaLut[b &
                               255];
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                redPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                greenPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                bluePalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
            }
        }
    }
    private void parse_bKGD_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        switch (colorType) {
            case PNG_COLOR_PALETTE:
                int bkgdIndex =
                  chunk.
                  getByte(
                    0) &
                  255;
                bkgdRed =
                  redPalette[bkgdIndex] &
                    255;
                bkgdGreen =
                  greenPalette[bkgdIndex] &
                    255;
                bkgdBlue =
                  bluePalette[bkgdIndex] &
                    255;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette)
                       encodeParam).
                      setBackgroundPaletteIndex(
                        bkgdIndex);
                }
                break;
            case PNG_COLOR_GRAY:
            case PNG_COLOR_GRAY_ALPHA:
                int bkgdGray =
                  chunk.
                  getInt2(
                    0);
                bkgdRed =
                  (bkgdGreen =
                     (bkgdBlue =
                        bkgdGray));
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                       encodeParam).
                      setBackgroundGray(
                        bkgdGray);
                }
                break;
            case PNG_COLOR_RGB:
            case PNG_COLOR_RGB_ALPHA:
                bkgdRed =
                  chunk.
                    getInt2(
                      0);
                bkgdGreen =
                  chunk.
                    getInt2(
                      2);
                bkgdBlue =
                  chunk.
                    getInt2(
                      4);
                int[] bkgdRGB =
                  new int[3];
                bkgdRGB[0] =
                  bkgdRed;
                bkgdRGB[1] =
                  bkgdGreen;
                bkgdRGB[2] =
                  bkgdBlue;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                       encodeParam).
                      setBackgroundRGB(
                        bkgdRGB);
                }
                break;
        }
        if (emitProperties) {
            int r =
              0;
            int g =
              0;
            int b =
              0;
            if (colorType ==
                  PNG_COLOR_PALETTE ||
                  bitDepth ==
                  8) {
                r =
                  bkgdRed;
                g =
                  bkgdGreen;
                b =
                  bkgdBlue;
            }
            else
                if (bitDepth <
                      8) {
                    r =
                      expandBits[bitDepth][bkgdRed];
                    g =
                      expandBits[bitDepth][bkgdGreen];
                    b =
                      expandBits[bitDepth][bkgdBlue];
                }
                else
                    if (bitDepth ==
                          16) {
                        r =
                          bkgdRed >>
                            8;
                        g =
                          bkgdGreen >>
                            8;
                        b =
                          bkgdBlue >>
                            8;
                    }
            properties.
              put(
                "background_color",
                new java.awt.Color(
                  r,
                  g,
                  b));
        }
    }
    private void parse_cHRM_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          chunk.
            getInt4(
              0) /
            100000.0F;
        chromaticity[1] =
          chunk.
            getInt4(
              4) /
            100000.0F;
        chromaticity[2] =
          chunk.
            getInt4(
              8) /
            100000.0F;
        chromaticity[3] =
          chunk.
            getInt4(
              12) /
            100000.0F;
        chromaticity[4] =
          chunk.
            getInt4(
              16) /
            100000.0F;
        chromaticity[5] =
          chunk.
            getInt4(
              20) /
            100000.0F;
        chromaticity[6] =
          chunk.
            getInt4(
              24) /
            100000.0F;
        chromaticity[7] =
          chunk.
            getInt4(
              28) /
            100000.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setChromaticity(
                chromaticity);
        }
        if (emitProperties) {
            properties.
              put(
                "white_point_x",
                new java.lang.Float(
                  chromaticity[0]));
            properties.
              put(
                "white_point_y",
                new java.lang.Float(
                  chromaticity[1]));
            properties.
              put(
                "red_x",
                new java.lang.Float(
                  chromaticity[2]));
            properties.
              put(
                "red_y",
                new java.lang.Float(
                  chromaticity[3]));
            properties.
              put(
                "green_x",
                new java.lang.Float(
                  chromaticity[4]));
            properties.
              put(
                "green_y",
                new java.lang.Float(
                  chromaticity[5]));
            properties.
              put(
                "blue_x",
                new java.lang.Float(
                  chromaticity[6]));
            properties.
              put(
                "blue_y",
                new java.lang.Float(
                  chromaticity[7]));
        }
    }
    private void parse_gAMA_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        fileGamma =
          chunk.
            getInt4(
              0) /
            100000.0F;
        float exp =
          performGammaCorrection
          ? displayExponent /
          userExponent
          : 1.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setGamma(
                fileGamma *
                  exp);
        }
        if (emitProperties) {
            properties.
              put(
                "gamma",
                new java.lang.Float(
                  fileGamma *
                    exp));
        }
    }
    private void parse_hIST_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (redPalette ==
              null) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder18");
            throw new java.lang.RuntimeException(
              msg);
        }
        int length =
          redPalette.
            length;
        int[] hist =
          new int[length];
        for (int i =
               0;
             i <
               length;
             i++) {
            hist[i] =
              chunk.
                getInt2(
                  2 *
                    i);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setPaletteHistogram(
                hist);
        }
    }
    private void parse_iCCP_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.String name =
          "";
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            name +=
              (char)
                b;
        }
    }
    private void parse_pHYs_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        int xPixelsPerUnit =
          chunk.
          getInt4(
            0);
        int yPixelsPerUnit =
          chunk.
          getInt4(
            4);
        int unitSpecifier =
          chunk.
          getInt1(
            8);
        if (encodeParam !=
              null) {
            encodeParam.
              setPhysicalDimension(
                xPixelsPerUnit,
                yPixelsPerUnit,
                unitSpecifier);
        }
        if (emitProperties) {
            properties.
              put(
                "x_pixels_per_unit",
                new java.lang.Integer(
                  xPixelsPerUnit));
            properties.
              put(
                "y_pixels_per_unit",
                new java.lang.Integer(
                  yPixelsPerUnit));
            properties.
              put(
                "pixel_aspect_ratio",
                new java.lang.Float(
                  (float)
                    xPixelsPerUnit /
                    yPixelsPerUnit));
            if (unitSpecifier ==
                  1) {
                properties.
                  put(
                    "pixel_units",
                    "Meters");
            }
            else
                if (unitSpecifier !=
                      0) {
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder12");
                    throw new java.lang.RuntimeException(
                      msg);
                }
        }
    }
    private void parse_sBIT_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            significantBits =
              (new int[3]);
        }
        else {
            significantBits =
              (new int[inputBands]);
        }
        for (int i =
               0;
             i <
               significantBits.
                 length;
             i++) {
            int bits =
              chunk.
              getByte(
                i);
            int depth =
              colorType ==
              PNG_COLOR_PALETTE
              ? 8
              : bitDepth;
            if (bits <=
                  0 ||
                  bits >
                  depth) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder13");
                throw new java.lang.RuntimeException(
                  msg);
            }
            significantBits[i] =
              bits;
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setSignificantBits(
                significantBits);
        }
        if (emitProperties) {
            properties.
              put(
                "significant_bits",
                significantBits);
        }
    }
    private void parse_sRGB_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        sRGBRenderingIntent =
          chunk.
            getByte(
              0);
        fileGamma =
          45455 /
            100000.0F;
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          31270 /
            10000.0F;
        chromaticity[1] =
          32900 /
            10000.0F;
        chromaticity[2] =
          64000 /
            10000.0F;
        chromaticity[3] =
          33000 /
            10000.0F;
        chromaticity[4] =
          30000 /
            10000.0F;
        chromaticity[5] =
          60000 /
            10000.0F;
        chromaticity[6] =
          15000 /
            10000.0F;
        chromaticity[7] =
          6000 /
            10000.0F;
        if (performGammaCorrection) {
            float gamma =
              fileGamma *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
                encodeParam.
                  setChromaticity(
                    chromaticity);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
                properties.
                  put(
                    "white_point_x",
                    new java.lang.Float(
                      chromaticity[0]));
                properties.
                  put(
                    "white_point_y",
                    new java.lang.Float(
                      chromaticity[1]));
                properties.
                  put(
                    "red_x",
                    new java.lang.Float(
                      chromaticity[2]));
                properties.
                  put(
                    "red_y",
                    new java.lang.Float(
                      chromaticity[3]));
                properties.
                  put(
                    "green_x",
                    new java.lang.Float(
                      chromaticity[4]));
                properties.
                  put(
                    "green_y",
                    new java.lang.Float(
                      chromaticity[5]));
                properties.
                  put(
                    "blue_x",
                    new java.lang.Float(
                      chromaticity[6]));
                properties.
                  put(
                    "blue_y",
                    new java.lang.Float(
                      chromaticity[7]));
            }
        }
    }
    private void parse_tEXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        for (int i =
               textIndex;
             i <
               chunk.
               getLength(
                 );
             i++) {
            value.
              append(
                (char)
                  chunk.
                  getByte(
                    i));
        }
        textKeys.
          add(
            key.
              toString(
                ));
        textStrings.
          add(
            value.
              toString(
                ));
    }
    private void parse_tIME_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        int year =
          chunk.
          getInt2(
            0);
        int month =
          chunk.
          getInt1(
            2) -
          1;
        int day =
          chunk.
          getInt1(
            3);
        int hour =
          chunk.
          getInt1(
            4);
        int minute =
          chunk.
          getInt1(
            5);
        int second =
          chunk.
          getInt1(
            6);
        java.util.TimeZone gmt =
          java.util.TimeZone.
          getTimeZone(
            "GMT");
        java.util.GregorianCalendar cal =
          new java.util.GregorianCalendar(
          gmt);
        cal.
          set(
            year,
            month,
            day,
            hour,
            minute,
            second);
        java.util.Date date =
          cal.
          getTime(
            );
        if (encodeParam !=
              null) {
            encodeParam.
              setModificationTime(
                date);
        }
        if (emitProperties) {
            properties.
              put(
                "timestamp",
                date);
        }
    }
    private void parse_tRNS_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            int entries =
              chunk.
              getLength(
                );
            if (entries >
                  paletteEntries) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder14");
                throw new java.lang.RuntimeException(
                  msg);
            }
            alphaPalette =
              (new byte[paletteEntries]);
            for (int i =
                   0;
                 i <
                   entries;
                 i++) {
                alphaPalette[i] =
                  chunk.
                    getByte(
                      i);
            }
            for (int i =
                   entries;
                 i <
                   paletteEntries;
                 i++) {
                alphaPalette[i] =
                  (byte)
                    255;
            }
            if (!suppressAlpha) {
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGBA;
                    outputBands =
                      4;
                }
                else {
                    outputHasAlphaPalette =
                      true;
                }
            }
        }
        else
            if (colorType ==
                  PNG_COLOR_GRAY) {
                grayTransparentAlpha =
                  chunk.
                    getInt2(
                      0);
                if (!suppressAlpha) {
                    if (bitDepth <
                          8) {
                        output8BitGray =
                          true;
                        maxOpacity =
                          255;
                        postProcess =
                          POST_GRAY_LUT_ADD_TRANS;
                    }
                    else {
                        postProcess =
                          POST_ADD_GRAY_TRANS;
                    }
                    if (expandGrayAlpha) {
                        outputBands =
                          4;
                        postProcess |=
                          POST_EXP_MASK;
                    }
                    else {
                        outputBands =
                          2;
                    }
                    if (encodeParam !=
                          null) {
                        ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                           encodeParam).
                          setTransparentGray(
                            grayTransparentAlpha);
                    }
                }
            }
            else
                if (colorType ==
                      PNG_COLOR_RGB) {
                    redTransparentAlpha =
                      chunk.
                        getInt2(
                          0);
                    greenTransparentAlpha =
                      chunk.
                        getInt2(
                          2);
                    blueTransparentAlpha =
                      chunk.
                        getInt2(
                          4);
                    if (!suppressAlpha) {
                        outputBands =
                          4;
                        postProcess =
                          POST_ADD_RGB_TRANS;
                        if (encodeParam !=
                              null) {
                            int[] rgbTrans =
                              new int[3];
                            rgbTrans[0] =
                              redTransparentAlpha;
                            rgbTrans[1] =
                              greenTransparentAlpha;
                            rgbTrans[2] =
                              blueTransparentAlpha;
                            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                               encodeParam).
                              setTransparentRGB(
                                rgbTrans);
                        }
                    }
                }
                else
                    if (colorType ==
                          PNG_COLOR_GRAY_ALPHA ||
                          colorType ==
                          PNG_COLOR_RGB_ALPHA) {
                        java.lang.String msg =
                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                          getString(
                            "PNGImageDecoder15");
                        throw new java.lang.RuntimeException(
                          msg);
                    }
    }
    private void parse_zTXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        chunk.
          getByte(
            textIndex++);
        try {
            int length =
              chunk.
              getLength(
                ) -
              textIndex;
            byte[] data =
              chunk.
              getData(
                );
            java.io.InputStream cis =
              new java.io.ByteArrayInputStream(
              data,
              textIndex,
              length);
            java.io.InputStream iis =
              new java.util.zip.InflaterInputStream(
              cis);
            int c;
            while ((c =
                      iis.
                        read(
                          )) !=
                     -1) {
                value.
                  append(
                    (char)
                      c);
            }
            ztextKeys.
              add(
                key.
                  toString(
                    ));
            ztextStrings.
              add(
                value.
                  toString(
                    ));
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
        }
    }
    private java.awt.image.WritableRaster createRaster(int width,
                                                       int height,
                                                       int bands,
                                                       int scanlineStride,
                                                       int bitDepth) {
        java.awt.image.DataBuffer dataBuffer;
        java.awt.image.WritableRaster ras =
          null;
        java.awt.Point origin =
          new java.awt.Point(
          0,
          0);
        if (bitDepth <
              8 &&
              bands ==
              1) {
            dataBuffer =
              new java.awt.image.DataBufferByte(
                height *
                  scanlineStride);
            ras =
              java.awt.image.Raster.
                createPackedRaster(
                  dataBuffer,
                  width,
                  height,
                  bitDepth,
                  origin);
        }
        else
            if (bitDepth <=
                  8) {
                dataBuffer =
                  new java.awt.image.DataBufferByte(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
            else {
                dataBuffer =
                  new java.awt.image.DataBufferUShort(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
        return ras;
    }
    private static void decodeSubFilter(byte[] curr,
                                        int count,
                                        int bpp) {
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int val;
            val =
              curr[i] &
                255;
            val +=
              curr[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                val;
        }
    }
    private static void decodeUpFilter(byte[] curr,
                                       byte[] prev,
                                       int count) {
        for (int i =
               0;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            int prior =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   prior);
        }
    }
    private static void decodeAverageFilter(byte[] curr,
                                            byte[] prev,
                                            int count,
                                            int bpp) {
        for (int i =
               0;
             i <
               bpp;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorRow =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   priorRow /
                   2);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorPixel =
              curr[i -
                     bpp] &
              255;
            int priorRow =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   (priorPixel +
                      priorRow) /
                   2);
        }
    }
    private static int paethPredictor(int a,
                                      int b,
                                      int c) {
        int p =
          a +
          b -
          c;
        int pa =
          java.lang.Math.
          abs(
            p -
              a);
        int pb =
          java.lang.Math.
          abs(
            p -
              b);
        int pc =
          java.lang.Math.
          abs(
            p -
              c);
        if (pa <=
              pb &&
              pa <=
              pc) {
            return a;
        }
        else
            if (pb <=
                  pc) {
                return b;
            }
            else {
                return c;
            }
    }
    private static void decodePaethFilter(byte[] curr,
                                          byte[] prev,
                                          int count,
                                          int bpp) {
        int priorPixel;
        int priorRowPixel;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorRow =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   priorRow);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            int priorRow =
              prev[i] &
              255;
            priorRowPixel =
              prev[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                (raw +
                   paethPredictor(
                     priorPixel,
                     priorRow,
                     priorRowPixel));
        }
    }
    private void processPixels(int process,
                               java.awt.image.Raster src,
                               java.awt.image.WritableRaster dst,
                               int xOffset,
                               int step,
                               int y,
                               int width) {
        int srcX;
        int dstX;
        int[] ps =
          src.
          getPixel(
            0,
            0,
            (int[])
              null);
        int[] pd =
          dst.
          getPixel(
            0,
            0,
            (int[])
              null);
        dstX =
          xOffset;
        switch (process) {
            case POST_NONE:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    for (int i =
                           0;
                         i <
                           inputBands;
                         i++) {
                        int x =
                          ps[i];
                        ps[i] =
                          gammaLut[x];
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    pd[0] =
                      grayLut[ps[0]];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      grayLut[val];
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGB:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGBA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    pd[3] =
                      alphaPalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_RGB_TRANS:
                boolean flagGammaCorrection =
                  performGammaCorrection;
                int[] workGammaLut =
                  gammaLut;
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (flagGammaCorrection) {
                        pd[0] =
                          workGammaLut[r];
                        pd[1] =
                          workGammaLut[g];
                        pd[2] =
                          workGammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    if (r ==
                          redTransparentAlpha &&
                          g ==
                          greenTransparentAlpha &&
                          b ==
                          blueTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int g =
                      ps[0];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[g];
                    }
                    else {
                        pd[0] =
                          g;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    int gamma =
                      gammaLut[val];
                    pd[0] =
                      gamma;
                    pd[1] =
                      gamma;
                    pd[2] =
                      gamma;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_ALPHA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int val2 =
                      grayLut[val];
                    pd[0] =
                      val2;
                    pd[1] =
                      val2;
                    pd[2] =
                      val2;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
        }
    }
    private void decodePass(java.awt.image.WritableRaster imRas,
                            int xOffset,
                            int yOffset,
                            int xStep,
                            int yStep,
                            int passWidth,
                            int passHeight) {
        if (passWidth ==
              0 ||
              passHeight ==
              0) {
            return;
        }
        int bytesPerRow =
          (inputBands *
             passWidth *
             bitDepth +
             7) /
          8;
        int eltsPerRow =
          bitDepth ==
          16
          ? bytesPerRow /
          2
          : bytesPerRow;
        byte[] curr =
          new byte[bytesPerRow];
        byte[] prior =
          new byte[bytesPerRow];
        java.awt.image.WritableRaster passRow =
          createRaster(
            passWidth,
            1,
            inputBands,
            eltsPerRow,
            bitDepth);
        java.awt.image.DataBuffer dataBuffer =
          passRow.
          getDataBuffer(
            );
        int type =
          dataBuffer.
          getDataType(
            );
        byte[] byteData =
          null;
        short[] shortData =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            byteData =
              ((java.awt.image.DataBufferByte)
                 dataBuffer).
                getData(
                  );
        }
        else {
            shortData =
              ((java.awt.image.DataBufferUShort)
                 dataBuffer).
                getData(
                  );
        }
        int srcY;
        int dstY;
        for (srcY =
               0,
               dstY =
                 yOffset;
             srcY <
               passHeight;
             srcY++,
               dstY +=
                 yStep) {
            int filter =
              0;
            try {
                filter =
                  dataStream.
                    read(
                      );
                dataStream.
                  readFully(
                    curr,
                    0,
                    bytesPerRow);
            }
            catch (java.lang.Exception e) {
                e.
                  printStackTrace(
                    );
            }
            switch (filter) {
                case PNG_FILTER_NONE:
                    break;
                case PNG_FILTER_SUB:
                    decodeSubFilter(
                      curr,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_UP:
                    decodeUpFilter(
                      curr,
                      prior,
                      bytesPerRow);
                    break;
                case PNG_FILTER_AVERAGE:
                    decodeAverageFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_PAETH:
                    decodePaethFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                default:
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder16");
                    throw new java.lang.RuntimeException(
                      msg);
            }
            if (bitDepth <
                  16) {
                java.lang.System.
                  arraycopy(
                    curr,
                    0,
                    byteData,
                    0,
                    bytesPerRow);
            }
            else {
                int idx =
                  0;
                for (int j =
                       0;
                     j <
                       eltsPerRow;
                     j++) {
                    shortData[j] =
                      (short)
                        (curr[idx] <<
                           8 |
                           curr[idx +
                                  1] &
                           255);
                    idx +=
                      2;
                }
            }
            processPixels(
              postProcess,
              passRow,
              imRas,
              xOffset,
              xStep,
              dstY,
              passWidth);
            byte[] tmp =
              prior;
            prior =
              curr;
            curr =
              tmp;
        }
    }
    private void decodeImage(boolean useInterlacing) {
        int width =
          bounds.
            width;
        int height =
          bounds.
            height;
        if (!useInterlacing) {
            decodePass(
              theTile,
              0,
              0,
              1,
              1,
              width,
              height);
        }
        else {
            decodePass(
              theTile,
              0,
              0,
              8,
              8,
              (width +
                 7) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              4,
              0,
              8,
              8,
              (width +
                 3) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              0,
              4,
              4,
              8,
              (width +
                 3) /
                4,
              (height +
                 3) /
                8);
            decodePass(
              theTile,
              2,
              0,
              4,
              4,
              (width +
                 1) /
                4,
              (height +
                 3) /
                4);
            decodePass(
              theTile,
              0,
              2,
              2,
              4,
              (width +
                 1) /
                2,
              (height +
                 1) /
                4);
            decodePass(
              theTile,
              1,
              0,
              2,
              2,
              width /
                2,
              (height +
                 1) /
                2);
            decodePass(
              theTile,
              0,
              1,
              1,
              2,
              width,
              height /
                2);
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            theTile,
            wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        if (tileX !=
              0 ||
              tileY !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder17");
            throw new java.lang.IllegalArgumentException(
              msg);
        }
        return theTile;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QLKSoS/PtqlFR7rVi4cNMNnHoqEWoUw2");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("Gt3jG0aTpGSKJ9Dm1wsDU1Qn93oEA9UfahUqWyVgHvQNRlYy9BAF7cW9Yh7y" +
       "UTFidAidJMHyM99YTpKUTMlElwbjXjs/99FiOoXeTgmip30jkpWc12KWLHar" +
       "mGe8r/wIrRbKTpHAeN43jFMkJRe1GAamqE5e8NFiThUqT5WA+YNvMLKSnS3G" +
       "vWL2+qiYdULjaRIsb/rGcpqkZPcW4147Hvbb5AbNs4TesySIVGeIqRHJSob5" +
       "TldLo3Tk93B2WHZBUSgmVEUlIP7PN4iopOTsgaisWgCO65j/iUcox4AiXSjU" +
       "JVD+4RuKrGSIo3HVmrRC/umjQs4RuvrcUYTDvlH0SUouiKMRj1uNhCM+akQ8" +
       "e+OvLlhG+cYiK5nXiHSsD3t49JNr5+cKXYMSFBN8oxiUlOysEddRPjzRI5YT" +
       "QFNaaExLsEz3jUVWMozy2TbiXiUetu3kqmRIKKMSGLW+YVBJyQWjPAJyr5O5" +
       "PlrJZqFyswTMYb7ByEq2W4nr+B5e4CN+/LrQdZ4ExeG+UZwnKdnZSlxH9vAR" +
       "PlrJRULjRRIsx/rGIis5r5W4V8lxPqrkm0LZFgmM5b5hbJGUXNRK3OukWQGG" +
       "f+X46Rv2h0edFvyUXJ5iljO38MIiM2S/9sd+a2Lnlm074qtuWpR9SGdCg6Ap" +
       "c0FC36An8oo6gL2/P2dGbgXGYm4Ff81n1gYqu68oE2U5XX9bZwBLDZ/myJC3" +
       "iSu8FpNuSkYZSYO2iDviLKfz0K4NKSNu10PJ3Tj5ioo+YHY3m24cHQSmi2lf" +
       "oGhCWZojmWgpjgYUHJ2DSYySKsZR7g5ueJ1NR3wE6JiWpUNsAQsUbSDLo8PZ" +
       "Eu2nCr2ORlijKFHKUqiCMbFBwRJLTDz2S6dNuIQi9xNy0gP6GXXnjgB1bGnP" +
       "XDD9UwH006+MOlmJpaj7poK6rZhcCD2JpWtxxl2Wt6Uef+OxFl7sAhi/JTfB" +
       "+G2pi4CqMl4mf/XUUqWiUiLDlzKytiuIvBaTK8HdTFyEEW1dubwrypbzOJpr" +
       "yVOy9oWTpwSwp7xzIhMtxcl33TNkvSjvlykKfp0vjKcBhW+w+WruWO7KV8kf" +
       "IfDBF1vQhhH5t3mZ/NVLG61za6PVihLVLE1zPPrp1gbNhM7iEUbW3QrHuw+T" +
       "XZRMjUETprrLU6OslqlFD5gKcjC6S97v3wf3DO0R5Ozx7J5S0VLu+ZiCuZ9j" +
       "8nDOBTvbeppdXfCRkeTkLQHsLe+cyERLcfJrBSfPYfKLHCe9J7e4N8unR5CT" +
       "8GxeJn/1xIlUtBQnexWcvIrJ73KcxFZ2tbty8tJIctIggDV450QmWoqTdxSc" +
       "vIfJn3Kc9De0N7hy8ueR5KRbAOv2zolMtBQnnyo4+RsmH+c4GWjt7nHlpOQR" +
       "TvvCSVwAi3vnRCZagpNIWM5JBPcrh7/McWI0NXW6cRIhI8lJUgBLeudEJlqK" +
       "k2oFJ+MxGZXjxFx5etqVk5K3ffeFE/H7ouGiH0MtzYlMtBQnMxWcHIjJ1Bwn" +
       "6cZW17YTmTaSnIhfMggX/Q5CaU5koqU4OVTByQJMDrI5wY3QbpwcPJKcPCGA" +
       "PeGdE5loKU6WKjjBA4IiS3Kc0ObTqCsnh48kJ+I8s3DRaWilOZGJluKkWcFJ" +
       "CyYn2py0trvGsZGGkeTkQwHsQ++cyERLcdKl4AQPiYm025x0dXS7clLy1Pp9" +
       "4CQi7vtGnPd9S3MiFS3FSVTBCZ6BGVmb42Rzj6TtnDECnODByHgTOiJWVPBX" +
       "b5zIRB2QI8wQPAKGDLgljIuEgic8CS3Sj8fLsRl1bn9AqMfmaGAEOGLnAqwE" +
       "0y8UQC9UcMTS4d46lJboYCGUe5TCD/bPI2yzgrDzMaF4fiA7D7Q707uC/TiN" +
       "w69K/pCBX86wrX1LICz6BWDfnF0mKVHNmSCO8bJVwdmlmGyhbIMzcLbadKWs" +
       "5M8U+KXsBAAmfvQvUvR7ib4p2y4p0cFDmBUVdlBm83aNgjd8Khe5kpLxnLeG" +
       "Dbql9euu5I3ErVZ2tMVcgCh+PChS9NNDvsmTlSj1t6JObaeCt5sx2cF+2kin" +
       "A52WHjdiNMW2PQ3YlJX8aQG//nYcALtfACw6GN83ZfdJSvTob4rbq5F7MNlF" +
       "SXX2rGNgz9XbRuzOaQsAFOdGR55RUIeJy6j5jETUgbmcGVJu+8MUSiY6bhjn" +
       "jYQO97O5fETB5WOY/JSS0SY/OpLtdU87eCx56r9fHo8hpOx5XmbZs5555CIu" +
       "olIe3Uly0PVLBV2/xuRJyk7QYK6XdnL11EhxBdnKxYbV8qLtriW5kopKo9fA" +
       "Hob4ZQUbezH5be7Q8Vb0SAcdJQ/790EHexQ+G7AcJTAdVYKOQwvpqFSISukI" +
       "9TDIbynoeAeTNyipiKXMTXjOxbmFAWrJHxr2wQXbbzgVgBwnAB3nnQuZqANq" +
       "3uHDea3lEwUhn2LyIW500ylu+8V/d9t8fPRV8DFESRl/2m2mLTLFsVynU4ut" +
       "B6eMxu7cMbZi8o7VLwZJWPyaPIqPaiMVfZlEIu+QmfwDZ8pMS+8zGIOjWFrN" +
       "fjw+8iUlhwz3UTwlIZMvcIh8waTLgpTUDkcaf1QeX/NlI5TMVMuCFHvNl6qg" +
       "ZIpMCuyDND93FSUT3HJDTkjzc46BiaszJ+hnr/n5qqHDtPNBhfE3+VkmQOmQ" +
       "Bd9ONLOD3ZISNFnsiGY9XtfQm6aWFqPgBUP8CW7B2Tns52JLrnLNW/U1R3qm" +
       "U3umU5wEcdeOkzrO++jIm9gRV5FYQtu8GUupaiPl+NscGp/OhopOlcgvLVtW" +
       "2cp5n4/5wX5zs+vIqrnBdtPd325VpBk6JBOdfZq977rBsrRN6Vr2goccvbTz" +
       "2Ief2Vr2XJAEziABDWLzM/gBVvjYv56fNbRsyMxYZMYZbYVnheSffbRs3n9t" +
       "Ov6wvg9eRsNM7AlB7XR5/mjs+VvO/M1VU3bODJKqVvBEPDdlLak00ss3Jbv0" +
       "2AZrLRltpJuHwEQoxdASraQikzTOzeitcdnJUqMLTpaiZLZ93AY/ZmMYJ0mN" +
       "biNV9ie8ZpSHS6GA/YmoSkzZ2V0GWzcMLhttazfN7FFT+33NZJ1SxmX44DuR" +
       "yw5hb/HdvP8HHgBo09mbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL29CbTr2Fkm6jtVVSqVqkpVxiJDJamEJE6ubMu2LIoE5Emy" +
       "rMGWZMsSJDeaLEvWZE2WDQGSfk1CAoQhCWEBeUl3IEBnaMamu6Ff3oMGAqG7" +
       "kwUPAo+E6XWHaTE00wM6PEn2Ge659rnHt6o4a2nbx9rD9/373//+99beWx/5" +
       "08K1wC8UPdda6ZYbXteS8Lpp1a6HK08LruNEbSD5gaa2LCkIuPS3G8pL/+0D" +
       "f/MP3zZ78HLhLrHwsOQ4biiFhusEjBa4VqypROGBk187lmYHYeFBwpRiCYhC" +
       "wwIIIwgfJwpPP5U0LDxGHEEAUghACgHIIQDISaw00TM0J7JbWQrJCYNF4esK" +
       "l4jCXZ6SwQsLL7k5E0/yJXubzSBnkOZwT/b/OCWVJ078wqPH3DecbyH8niLw" +
       "7u9644M/eqXwgFh4wHDYDI6SggjTQsTCfbZmy5ofIKqqqWLhmY6mqazmG5Jl" +
       "rHPcYuGhwNAdKYx87VhI2Y+Rp/l5mSeSu0/JuPmRErr+Mb2poVnq0X/Xppak" +
       "p1yfc8J1w7Cb/Z4SvNdIgflTSdGOklydG44aFl58NsUxx8f6aYQ06d22Fs7c" +
       "46KuOlL6Q+GhTd1ZkqMDbOgbjp5GveZGaSlh4ZG9mWay9iRlLunajbDwvLPx" +
       "Bptbaayn5YLIkoSFZ5+NlueU1tIjZ2rpVP38KfXl3/o1DuZczjGrmmJl+O9J" +
       "E73oTCJGm2q+5ijaJuF9rybeKz3nZ95+uVBIIz/7TORNnH/3tX/xla950Sd+" +
       "cRPnS3bEoWVTU8Ibyofk+z/9gtar4CsZjHs8NzCyyr+Jea7+g+2dxxMvbXnP" +
       "Oc4xu3n96OYnmJ8XvuGHtT++XLi3V7hLca3ITvXomYpre4al+ajmaL4Uamqv" +
       "8DTNUVv5/V7h7vQ7YTja5ld6Og20sFe4auU/3eXm/6cimqZZZCK6O/1uOFP3" +
       "6LsnhbP8e+IVCoW706twX3q9vrD5yz/DggzMXFsDJEVyDMcFBr6b8Q8AzQnl" +
       "VLYzQE61fg4EbuSnKgi4vg5IqR7MtO2NrGVKyxAw7LT6AcVNKwzwUtUaUCij" +
       "qdczXfP+WUpJMq4PLi9dSqvhBWeNgJW2H8y1VM2/obw7anb+4mM3fvnycaPY" +
       "SiksZAVf3xR8PS84N6Bpwdfzgq/nBV9PC76+Kbhw6VJe3rMyAJsqTytsnjb9" +
       "1Cje9yr2Dfib3v7SK6muecurqbQvp1GB/ba5dWIserlJVFKNLXzifcu3jL++" +
       "dLlw+WYjm4FOf7o3Sz7ITOOxCXzsbOPale8Db/vC33z8vW92T5rZTVZ72/pv" +
       "TZm13peeFa/vKpqa2sOT7F/9qPQTN37mzY9dLlxNTUJqBkMpVdvUwrzobBk3" +
       "teLHjyxixuVaSnjq+rZkZbeOzNi94cx3lye/5PV+f/79mamMn56pdfrl0hs2" +
       "ar75zO4+7GXhszZ6klXaGRa5xX0d633fb/yXPwRzcR8Z5wdOdXesFj5+yiBk" +
       "mT2QN/1nnugA52taGu+33zf4zvf86du+KleANMbLdhX4WBa2UkOQVmEq5n/5" +
       "i4vPfv5zH/rVy8dKcylMe8RItgwlOSaZ/V649xySaWmvOMGTGhQrbW6Z1jw2" +
       "cmxXNaaGJFtapqX/+MDLyz/xJ9/64EYPrPSXIzV6ze0zOPn9+c3CN/zyG//2" +
       "RXk2l5SsQzuR2Um0jZV8+CRnxPelVYYjectnXvjdvyB9X2pvUxsXGGstN1uX" +
       "NjLImT873KY03Os9x4vCtPvSJDuvUCCP8eo8vH5eOrqTKJqXYcnTgVnw4uB0" +
       "o7m5XZ5yWG4o3/arf/6M8Z//p7/IWd7s8ZzWEVLyHt+oZRY8mqTZP/eshcCk" +
       "YJbGq36C+uoHrU/8Q5qjmOaopNYvoP3UTiU3adQ29rW7f/P//NnnvOnTVwqX" +
       "u4V7LVdSu1LeOAtPS1uFFsxSE5d4X/GVG61Y3pMGD2bfksKxYAq5YAobXXrk" +
       "1mYjbTVK2t1ssvAlWfDyW5VxX9IzVXN5Ywuzf0tH9QMdYnjbWvZvbvNyVM3d" +
       "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" +
       "s6I1NYOfZ3H2KAArxXHHlMJHC1g16CFH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "LAFMa7Uc1mdqz6S0UZL5WaPlWqmGjE0q");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "LYd5n8Px5CwL/jZEL/+nnMxrziF6PQu+NHufnRa2sjOljt4++u0nTG97bvU5" +
       "TPMTy16ewvnbLdO/fSqZNs5h+mVZAKatz9ckNaeaR3t2WGgc8pINRlMfSz9O" +
       "MshFVH2iCl9O2d61Sbv5fDIV/uqX5xLoniOd7G3hV5Gw8KCXnbF1o4e1mRv5" +
       "GWNntL75ZBD9pS3RX3qKiDK7IxzV98OnjitMFM3L3qOQp8vOQb9KngihQ7V3" +
       "CoF6AkLIz8nLNgd++ybt5vOQBvHK2zaII6KPnDnrg5Vsz9Ly7Vo53zedoxDZ" +
       "sZJXvyosPF9J20uo7Tgm5KiU599yoshNMXKJffWToDZXfnErsV98itTmnJdL" +
       "XM2Otro6P1aNAcF1dqqG9WQQ/cKW6BeeIqJfew7Rr8uC5TFROR3M7iR623Oc" +
       "L0D06ks3aTefTwHRt59DNOtXrv6LY6IKxpA7id72dISLEEW2RJGniOi7zyH6" +
       "3ix41zFRHSGRnURve+zyRYiyW6LsU0T0A+cQzQ7Nu/o9x0RnPZbbSfR7nwyi" +
       "6pao+hQR/cg5RD+WBR8+Jmq0WoOdRG/7or+LEHW2RJ2niOhPnUP0P2TBjx0T" +
       "9TAh2En0x58Mom/bEn3bU0T0584h+vNZ8H8cEw2avd2q+4kng+gHt0Q/+BQR" +
       "/W/nEP1MFvzyCdHsbQy7iH7qySD6C1uiv/AUEf1/ziH6uSz49WOiYWcS7iR6" +
       "2138FyG6fR/e1Vveh/ckEf3COUT/KAt+/4Roj9ztGf3Bk0H0z7dE//wpIvpX" +
       "5xD9myz4sxOiDMXuJPrnTwLRa9vJp2tnJ5+eJKLXCvuJXstGGVf/4Zjomtuj" +
       "uv/4BIhmb1zOpreubQ+S2nw+caLX8gjZe482h2KfDXKC951D/v4suDt7dWA+" +
       "7jk+1/bKvcfEr93zBIjnLwfBUojfsCX+DQcQv92EyJXjKdNLrznD+XnncH4k" +
       "Cx7O3uWYHwnKRnLXsDa0T9X3tWc9UdqZYn/zlvY7nzraW+45tcfOof2KLHhx" +
       "mL/EIaU98nayvu0L5m7H+itStu/dsn7Pk8j6ah7r6hnWJ9RL51DP1gBdK4aF" +
       "hzfUkVjz06H7Tv6veQL887fJvDzl/eEt/w8/JbV+SwP/8nOovz4LoLTWPUkL" +
       "ZwNfUw0ldPOjq2+csL7tW+RuV+uvS9n+uy3rW14p/xTWOnYOdTwLWmHhmUev" +
       "QE4FsLPO20+0C0NT1tvXSV/7lQPYn2PZ784j3H1ST88OC88+M/V0ylqfUYsT" +
       "AXHnCGiSBXRYeIa3eTVm/qaM4IxwbvsOudsJ58sKhbt+dZP2rk8/2cLZzfyM" +
       "DORzZJBN/F17Q5i/GCdXkuCsAN74RAVQTaFuz/S/e9eZ/k/Iwbn0PTkN5xyK" +
       "WUnXjONXgeenYZ/haD7RpzsvTblBW47QoRxfeRuOV+7NeazP4fi1WRCFhXsU" +
       "11tlb6RZ3OzD3PYM1XMI5gekPz8l9rotwdc9OQRPvVz4lLJ+4zks354Fb8lO" +
       "C9fC7DUF2b+jE5JvPYRkEhbu2jzg8QK/8LwzT3UHkjJP1eSG8rH3P3DPc98/" +
       "+vXLhatE4Wr2pqcso6cRhXumkWWdekXT6dc13eX52tTIST8tD+/3cvzvCguv" +
       "vOjTp7BwJQ0z2Ne+dZP6O8LCYxdJHRau5Z+n074nLLzo/LRpqvzzdKr3hYXn" +
       "7UuV4kvD07G/Jyw8a1fsNGYano75/nS0cTZmWn7+eTreB1O7dBIvrbDNl9NR" +
       "PpTmnkbJvn6/d9RRgLcRk5+/q1lTryNyEPqSEqZakGyeozzvdBvIlxTc9q3N" +
       "pxYHvGzve87IaLB9Dc7H349TX/MX9e/PXwN3TbGk9TrL5R6icPfU9W1p8xzl" +
       "UnL2lTqnczvK6y7sVf9w/7992suPlhvcvwF80h5PYXvxyXsjWq5lpXpiuE7w" +
       "WMf2wlX2drD1Tz33x7/8w+//XJaX9/8DFGb4uiixAAA=");
}
