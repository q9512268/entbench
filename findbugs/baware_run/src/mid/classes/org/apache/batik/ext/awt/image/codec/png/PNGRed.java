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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "w7E+w7A/4VW8xlfeMDAUhTbxaPZfU736IekmAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "sVKHidYMl225F/FDOOvHykrrdGRDdLyVJU6pCWeVStJSpmdMzzGy+SYRyZEu" +
           "rxg2Li2XquRMNb2Ztep0jx0JG2NFT1lGrxk6sZiU3Ey3rW0dnrfVwI8rMleW" +
           "HZpt1ZZTnpdYpGu0ynDVmpeySbmvmzjdy+AxJWPlMechVssYUiazwFpiA2HW" +
           "7iJshIxscdVlSmyCYV1srn2OXthLhJS2dSTqrqV0PvPYcG7MN14w3ii1Jkbj" +
           "SV2xxBKxkpWQMXsl1kfGHmw1kySpaZrZG4KMvufLWVhnOXEmMpG/SUlfE3m+" +
           "zzhp1zTtJjsZqBQJo3GP5LYUSVf6MYL2/A4vDTJbgOW47+pwtzcLCXJgdGKd" +
           "iOSOq2qcuBpFgT7ciIaE+4qP15Os6larqNq1mHyHpsdOJbHEqozVqssMTHaN" +
           "MSNNiFqVK3XXXomzRASTt3yJnbNmqbkQezjr8tse8AW8mE5Litvkcd+aTWdk" +
           "ahA8zS16s8lwuAC6JrXYp73+XEI2utaVNtRcHhmz/tLzwDzrd4kFIniy15c3" +
           "SB9XGV2eIcp4nM2H7RTtCiuyO1gOuh2lU90Y7lZpBUO6lqZGm2FaDEOLow0T" +
           "1zE2HoA2O32lMc9m7GhJytRskbYUujRihDZf29akRTOc88vVUBIZedkxanXW" +
           "xog62mmb7LhpwHp7W880XasvKqjV6k3qWW/S6GVRScK4WJxMFWQmSUErwuez" +
           "cW0jdpco020JNt3R19QowRSlURNatTUdtXr9jOjSwMMZSSMyUQlpEcvSolka" +
           "YWitWhsv1MSI+orVH6zS9rbfpoh4HPJYS0EGRHO9Yquy7rKoVjNnk6ZJzIal" +
           "lUJU6GVUhinLYf2I6VU80+4uW67KDe1AtWxj5MsjJwxEuLpYuI0RQq0qwWDJ" +
           "CPNGIrQrlQFCY01LlCrDKt/0vEq1NMajBm0vGwvcrgGz3GYw2qkSgT5aISuq" +
           "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" +
           "jbuBLzzEF3578F24/xx8D+bF5WN81dP4");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("Llx5u67lWXBlh/iybxO+x8/B9x158UgMXQP4ds6zgLj3nhcefRsQ89N8hfd8" +
           "+RDiy3cd4isFjOfOgZgfR7jwNMhCzOj47OGZ71xXFp5na7K7R/3MW0GdxtDV" +
           "o4OlReU7Ywh5iydTQV71xC2n5Hcnu5XPv3b96uOvzf5gd1rr6PT1fQPoqp7Y" +
           "9snjMSfuL/uhppuF+u7bnVHwC3WUY+h936psMXTJ332cvVDacYPE9Oa3wp0f" +
           "4Mh/T/KCTPDp83kBV/F7kuuvx9ATd+IC8oHyJPWHYugdt6MGlKA8SflCDN04" +
           "Swn6L35P0hFgcuzpgBntbk6SkKB1QJLfdv0jAzjxDXd3+im9cDqRPnaSj7yZ" +
           "rZ3IvZ87dXql+O+LoyM/ye7/L15UvvBab/QDX6//zO4krGLL223eytUBdGV3" +
           "KLdoND829O47tnbU1mXq/d946Ofve+9RNv/QTuD9tD0h2zO3P3bacfy4OCi6" +
           "/UeP/8MP/r3X/qj4iP1/AML4QJEWMwAA");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vsHISgYPUdJe3CvmXh8VI3qH0CkSLA/5");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "sULhN5jmDQOdTjXfLPp/xmpFsoSZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CAEL4LhjSuGjOawa4K2jP3qkIGNdTkQh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("spUuHjprDW5MYGE9nZRhQl+jw0jgpNUE7bNze92C8akw6AQS21EbHiQJg4mZ" +
       "zCstW+jX1kSru8R7E5we6LC8GrXWBN5pw7rQijrkCCIivNNCpripMDzWGFvj" +
       "UrOTsKNquT4cGc1xUy2KEai5Qt4f1ZvqaKSMpoWob2C0bQs1155wwqApi+qi" +
       "mjeXCreW154pSUMrCEuxryZ5dLQcN0rGugyh03jF173RXCXzglQN/Z5WmXtE" +
       "jax1JX4hW/TMXogRUZsuooDwcFNS59VKqawXbbkcEL0eHylScT700XmjH9rN" +
       "VhLHPjMjYA5djOzADNnmSORayLjB1fRie7iSjLnoGO6Qo2e8yihTESYYCiEW" +
       "pBb0IEkMtZlHcnOtV2RGXtsxxUFb7M5nZiOgobnBzaSSb6ojTxvVsXqxQDVG" +
       "LbJHDlc4vmKG68JqYhYa08hUVtwgTvRwDlk8PMPGfqSuFoNRHZ8TaJmByl6B" +
       "K05n4xqqW90VgZhrYjDk+JXdlpFiSzQktVeScbYYsyLDMuWhiAEyI7TSGfIw" +
       "2TbjMGFgmuLLpDkgRXfCwSMUdhK8XdZbhLRouEqHhGoeiq0VVaWX7bDDLeI5" +
       "XiPFttF32nOiP6FwvksunKjSX5dqBl7H7ZHY7aOkn7SZGiORvqWW2Kk7pnDH" +
       "bXYgG0es7jJeTfO6XS07PmK7fEA4tR5dluDxTFmTs46WxyKLmbQFWpsKbQeZ" +
       "F7qNVtecwjRGT/VSMKjBQ3/o2Z1g1ePNOYn2wp7RT1qCxwqSkC/HpLtwoc5Y" +
       "bPcrc5EX6oLjtnos1ey0BRkW6SLKlwlzPlSEkguNRtIsqc9EEl+Pa4MCTM1R" +
       "ujjUEX48cxhrwo/AL0m5NOr2C9iq2mzMlo5YE+e62W/RplZUW76FxUSnmCSd" +
       "xnhRmUZ+vz2bGcW2zUmNcdIuQTzR6q9mFWZec5wIqDlGQGUlXNKEY8sFa72m" +
       "oqAxqK77QqXplgrU3BtMeywidSZ6NQko1x6Nq6QcTkkX6LrhxKgqOiuDY1dJ" +
       "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" +
       "KF0tr1Dc7TvTKmcafUymsaBVqkuJ1l0U");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "/wHufVhUYLEAAA==");
}
