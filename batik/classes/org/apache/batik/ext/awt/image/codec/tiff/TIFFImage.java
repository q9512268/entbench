package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFImage extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public static final int COMP_NONE = 1;
    public static final int COMP_FAX_G3_1D = 2;
    public static final int COMP_FAX_G3_2D = 3;
    public static final int COMP_FAX_G4_2D = 4;
    public static final int COMP_LZW = 5;
    public static final int COMP_JPEG_OLD = 6;
    public static final int COMP_JPEG_TTN2 = 7;
    public static final int COMP_PACKBITS = 32773;
    public static final int COMP_DEFLATE = 32946;
    private static final int TYPE_UNSUPPORTED = -1;
    private static final int TYPE_BILEVEL = 0;
    private static final int TYPE_GRAY_4BIT = 1;
    private static final int TYPE_GRAY = 2;
    private static final int TYPE_GRAY_ALPHA = 3;
    private static final int TYPE_PALETTE = 4;
    private static final int TYPE_RGB = 5;
    private static final int TYPE_RGB_ALPHA = 6;
    private static final int TYPE_YCBCR_SUB = 7;
    private static final int TYPE_GENERIC = 8;
    private static final int TIFF_JPEG_TABLES = 347;
    private static final int TIFF_YCBCR_SUBSAMPLING = 530;
    org.apache.batik.ext.awt.image.codec.util.SeekableStream stream;
    int tileSize;
    int tilesX;
    int tilesY;
    long[] tileOffsets;
    long[] tileByteCounts;
    char[] colormap;
    int sampleSize;
    int compression;
    byte[] palette;
    int numBands;
    int chromaSubH;
    int chromaSubV;
    long tiffT4Options;
    long tiffT6Options;
    int fillOrder;
    int predictor;
    com.sun.image.codec.jpeg.JPEGDecodeParam decodeParam = null;
    boolean colorConvertJPEG = false;
    java.util.zip.Inflater inflater = null;
    boolean isBigEndian;
    int imageType;
    boolean isWhiteZero = false;
    int dataType;
    boolean decodePaletteAsShorts;
    boolean tiled;
    private org.apache.batik.ext.awt.image.codec.tiff.TIFFFaxDecoder decoder =
      null;
    private org.apache.batik.ext.awt.image.codec.tiff.TIFFLZWDecoder lzwDecoder =
      null;
    private static final java.awt.image.Raster decodeJPEG(byte[] data,
                                                          com.sun.image.codec.jpeg.JPEGDecodeParam decodeParam,
                                                          boolean colorConvert,
                                                          int minX,
                                                          int minY) {
        java.io.ByteArrayInputStream jpegStream =
          new java.io.ByteArrayInputStream(
          data);
        com.sun.image.codec.jpeg.JPEGImageDecoder decoder =
          decodeParam ==
          null
          ? com.sun.image.codec.jpeg.JPEGCodec.
          createJPEGDecoder(
            jpegStream)
          : com.sun.image.codec.jpeg.JPEGCodec.
          createJPEGDecoder(
            jpegStream,
            decodeParam);
        java.awt.image.Raster jpegRaster;
        try {
            jpegRaster =
              colorConvert
                ? decoder.
                decodeAsBufferedImage(
                  ).
                getWritableTile(
                  0,
                  0)
                : decoder.
                decodeAsRaster(
                  );
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        return jpegRaster.
          createTranslatedChild(
            minX,
            minY);
    }
    private final void inflate(byte[] deflated, byte[] inflated) {
        inflater.
          setInput(
            deflated);
        try {
            inflater.
              inflate(
                inflated);
        }
        catch (java.util.zip.DataFormatException dfe) {
            throw new java.lang.RuntimeException(
              "TIFFImage17" +
              ": " +
              dfe.
                getMessage(
                  ));
        }
        inflater.
          reset(
            );
    }
    private static java.awt.image.SampleModel createPixelInterleavedSampleModel(int dataType,
                                                                                int tileWidth,
                                                                                int tileHeight,
                                                                                int bands) {
        int[] bandOffsets =
          new int[bands];
        for (int i =
               0;
             i <
               bands;
             i++)
            bandOffsets[i] =
              i;
        return new java.awt.image.PixelInterleavedSampleModel(
          dataType,
          tileWidth,
          tileHeight,
          bands,
          tileWidth *
            bands,
          bandOffsets);
    }
    private long[] getFieldAsLongs(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field) {
        long[] value =
          null;
        if (field.
              getType(
                ) ==
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT) {
            char[] charValue =
              field.
              getAsChars(
                );
            value =
              (new long[charValue.
                          length]);
            for (int i =
                   0;
                 i <
                   charValue.
                     length;
                 i++) {
                value[i] =
                  charValue[i] &
                    65535;
            }
        }
        else
            if (field.
                  getType(
                    ) ==
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG) {
                value =
                  field.
                    getAsLongs(
                      );
            }
            else {
                throw new java.lang.RuntimeException(
                  );
            }
        return value;
    }
    public TIFFImage(org.apache.batik.ext.awt.image.codec.util.SeekableStream stream,
                     org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam param,
                     int directory) throws java.io.IOException {
        super(
          );
        this.
          stream =
          stream;
        if (param ==
              null) {
            param =
              new org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam(
                );
        }
        decodePaletteAsShorts =
          param.
            getDecodePaletteAsShorts(
              );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory dir =
          param.
          getIFDOffset(
            ) ==
          null
          ? new org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory(
          stream,
          directory)
          : new org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory(
          stream,
          param.
            getIFDOffset(
              ).
            longValue(
              ),
          directory);
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField sfield =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_SAMPLES_PER_PIXEL);
        int samplesPerPixel =
          sfield ==
          null
          ? 1
          : (int)
              sfield.
              getAsLong(
                0);
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField planarConfigurationField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_PLANAR_CONFIGURATION);
        char[] planarConfiguration =
          planarConfigurationField ==
          null
          ? (new char[] { 1 })
          : planarConfigurationField.
          getAsChars(
            );
        if (planarConfiguration[0] !=
              1 &&
              samplesPerPixel !=
              1) {
            throw new java.lang.RuntimeException(
              "TIFFImage0");
        }
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField bitsField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_BITS_PER_SAMPLE);
        char[] bitsPerSample =
          null;
        if (bitsField !=
              null) {
            bitsPerSample =
              bitsField.
                getAsChars(
                  );
        }
        else {
            bitsPerSample =
              (new char[] { 1 });
            for (int i =
                   1;
                 i <
                   bitsPerSample.
                     length;
                 i++) {
                if (bitsPerSample[i] !=
                      bitsPerSample[0]) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage1");
                }
            }
        }
        sampleSize =
          bitsPerSample[0];
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField sampleFormatField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_SAMPLE_FORMAT);
        char[] sampleFormat =
          null;
        if (sampleFormatField !=
              null) {
            sampleFormat =
              sampleFormatField.
                getAsChars(
                  );
            for (int l =
                   1;
                 l <
                   sampleFormat.
                     length;
                 l++) {
                if (sampleFormat[l] !=
                      sampleFormat[0]) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage2");
                }
            }
        }
        else {
            sampleFormat =
              (new char[] { 1 });
        }
        boolean isValidDataFormat =
          false;
        switch (sampleSize) {
            case 1:
            case 4:
            case 8:
                if (sampleFormat[0] !=
                      3) {
                    dataType =
                      java.awt.image.DataBuffer.
                        TYPE_BYTE;
                    isValidDataFormat =
                      true;
                }
                break;
            case 16:
                if (sampleFormat[0] !=
                      3) {
                    dataType =
                      sampleFormat[0] ==
                        2
                        ? java.awt.image.DataBuffer.
                            TYPE_SHORT
                        : java.awt.image.DataBuffer.
                            TYPE_USHORT;
                    isValidDataFormat =
                      true;
                }
                break;
            case 32:
                if (sampleFormat[0] ==
                      3)
                    isValidDataFormat =
                      false;
                else {
                    dataType =
                      java.awt.image.DataBuffer.
                        TYPE_INT;
                    isValidDataFormat =
                      true;
                }
                break;
        }
        if (!isValidDataFormat) {
            throw new java.lang.RuntimeException(
              "TIFFImage3");
        }
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField compField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_COMPRESSION);
        compression =
          compField ==
            null
            ? COMP_NONE
            : compField.
            getAsInt(
              0);
        int photometricType =
          (int)
            dir.
            getFieldAsLong(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_PHOTOMETRIC_INTERPRETATION);
        imageType =
          TYPE_UNSUPPORTED;
        switch (photometricType) {
            case 0:
                isWhiteZero =
                  true;
            case 1:
                if (sampleSize ==
                      1 &&
                      samplesPerPixel ==
                      1) {
                    imageType =
                      TYPE_BILEVEL;
                }
                else
                    if (sampleSize ==
                          4 &&
                          samplesPerPixel ==
                          1) {
                        imageType =
                          TYPE_GRAY_4BIT;
                    }
                    else
                        if (sampleSize %
                              8 ==
                              0) {
                            if (samplesPerPixel ==
                                  1) {
                                imageType =
                                  TYPE_GRAY;
                            }
                            else
                                if (samplesPerPixel ==
                                      2) {
                                    imageType =
                                      TYPE_GRAY_ALPHA;
                                }
                                else {
                                    imageType =
                                      TYPE_GENERIC;
                                }
                        }
                break;
            case 2:
                if (sampleSize %
                      8 ==
                      0) {
                    if (samplesPerPixel ==
                          3) {
                        imageType =
                          TYPE_RGB;
                    }
                    else
                        if (samplesPerPixel ==
                              4) {
                            imageType =
                              TYPE_RGB_ALPHA;
                        }
                        else {
                            imageType =
                              TYPE_GENERIC;
                        }
                }
                break;
            case 3:
                if (samplesPerPixel ==
                      1 &&
                      (sampleSize ==
                         4 ||
                         sampleSize ==
                         8 ||
                         sampleSize ==
                         16)) {
                    imageType =
                      TYPE_PALETTE;
                }
                break;
            case 4:
                if (sampleSize ==
                      1 &&
                      samplesPerPixel ==
                      1) {
                    imageType =
                      TYPE_BILEVEL;
                }
                break;
            case 6:
                if (compression ==
                      COMP_JPEG_TTN2 &&
                      sampleSize ==
                      8 &&
                      samplesPerPixel ==
                      3) {
                    colorConvertJPEG =
                      param.
                        getJPEGDecompressYCbCrToRGB(
                          );
                    imageType =
                      colorConvertJPEG
                        ? TYPE_RGB
                        : TYPE_GENERIC;
                }
                else {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField chromaField =
                      dir.
                      getField(
                        TIFF_YCBCR_SUBSAMPLING);
                    if (chromaField !=
                          null) {
                        chromaSubH =
                          chromaField.
                            getAsInt(
                              0);
                        chromaSubV =
                          chromaField.
                            getAsInt(
                              1);
                    }
                    else {
                        chromaSubH =
                          (chromaSubV =
                             2);
                    }
                    if (chromaSubH *
                          chromaSubV ==
                          1) {
                        imageType =
                          TYPE_GENERIC;
                    }
                    else
                        if (sampleSize ==
                              8 &&
                              samplesPerPixel ==
                              3) {
                            imageType =
                              TYPE_YCBCR_SUB;
                        }
                }
                break;
            default:
                if (sampleSize %
                      8 ==
                      0) {
                    imageType =
                      TYPE_GENERIC;
                }
        }
        if (imageType ==
              TYPE_UNSUPPORTED) {
            throw new java.lang.RuntimeException(
              "TIFFImage4");
        }
        java.awt.Rectangle bounds =
          new java.awt.Rectangle(
          0,
          0,
          (int)
            dir.
            getFieldAsLong(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_WIDTH),
          (int)
            dir.
            getFieldAsLong(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_LENGTH));
        numBands =
          samplesPerPixel;
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField efield =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_EXTRA_SAMPLES);
        int extraSamples =
          efield ==
          null
          ? 0
          : (int)
              efield.
              getAsLong(
                0);
        int tileWidth;
        int tileHeight;
        if (dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_TILE_OFFSETS) !=
              null) {
            tiled =
              true;
            tileWidth =
              (int)
                dir.
                getFieldAsLong(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_WIDTH);
            tileHeight =
              (int)
                dir.
                getFieldAsLong(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_LENGTH);
            tileOffsets =
              dir.
                getField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_OFFSETS).
                getAsLongs(
                  );
            tileByteCounts =
              getFieldAsLongs(
                dir.
                  getField(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                      TIFF_TILE_BYTE_COUNTS));
        }
        else {
            tiled =
              false;
            tileWidth =
              dir.
                getField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_WIDTH) !=
                null
                ? (int)
                    dir.
                    getFieldAsLong(
                      org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                        TIFF_TILE_WIDTH)
                : bounds.
                    width;
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField field =
              dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_ROWS_PER_STRIP);
            if (field ==
                  null) {
                tileHeight =
                  dir.
                    getField(
                      org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                        TIFF_TILE_LENGTH) !=
                    null
                    ? (int)
                        dir.
                        getFieldAsLong(
                          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                            TIFF_TILE_LENGTH)
                    : bounds.
                        height;
            }
            else {
                long l =
                  field.
                  getAsLong(
                    0);
                long infinity =
                  1;
                infinity =
                  (infinity <<
                     32) -
                    1;
                if (l ==
                      infinity) {
                    tileHeight =
                      bounds.
                        height;
                }
                else {
                    tileHeight =
                      (int)
                        l;
                }
            }
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField tileOffsetsField =
              dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_STRIP_OFFSETS);
            if (tileOffsetsField ==
                  null) {
                throw new java.lang.RuntimeException(
                  "TIFFImage5");
            }
            else {
                tileOffsets =
                  getFieldAsLongs(
                    tileOffsetsField);
            }
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField tileByteCountsField =
              dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_STRIP_BYTE_COUNTS);
            if (tileByteCountsField ==
                  null) {
                throw new java.lang.RuntimeException(
                  "TIFFImage6");
            }
            else {
                tileByteCounts =
                  getFieldAsLongs(
                    tileByteCountsField);
            }
        }
        tilesX =
          (bounds.
             width +
             tileWidth -
             1) /
            tileWidth;
        tilesY =
          (bounds.
             height +
             tileHeight -
             1) /
            tileHeight;
        tileSize =
          tileWidth *
            tileHeight *
            numBands;
        isBigEndian =
          dir.
            isBigEndian(
              );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField fillOrderField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_FILL_ORDER);
        if (fillOrderField !=
              null) {
            fillOrder =
              fillOrderField.
                getAsInt(
                  0);
        }
        else {
            fillOrder =
              1;
        }
        switch (compression) {
            case COMP_NONE:
            case COMP_PACKBITS:
                break;
            case COMP_DEFLATE:
                inflater =
                  new java.util.zip.Inflater(
                    );
                break;
            case COMP_FAX_G3_1D:
            case COMP_FAX_G3_2D:
            case COMP_FAX_G4_2D:
                if (sampleSize !=
                      1) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage7");
                }
                if (compression ==
                      3) {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField t4OptionsField =
                      dir.
                      getField(
                        org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                          TIFF_T4_OPTIONS);
                    if (t4OptionsField !=
                          null) {
                        tiffT4Options =
                          t4OptionsField.
                            getAsLong(
                              0);
                    }
                    else {
                        tiffT4Options =
                          0;
                    }
                }
                if (compression ==
                      4) {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField t6OptionsField =
                      dir.
                      getField(
                        org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                          TIFF_T6_OPTIONS);
                    if (t6OptionsField !=
                          null) {
                        tiffT6Options =
                          t6OptionsField.
                            getAsLong(
                              0);
                    }
                    else {
                        tiffT6Options =
                          0;
                    }
                }
                decoder =
                  new org.apache.batik.ext.awt.image.codec.tiff.TIFFFaxDecoder(
                    fillOrder,
                    tileWidth,
                    tileHeight);
                break;
            case COMP_LZW:
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField predictorField =
                  dir.
                  getField(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                      TIFF_PREDICTOR);
                if (predictorField ==
                      null) {
                    predictor =
                      1;
                }
                else {
                    predictor =
                      predictorField.
                        getAsInt(
                          0);
                    if (predictor !=
                          1 &&
                          predictor !=
                          2) {
                        throw new java.lang.RuntimeException(
                          "TIFFImage8");
                    }
                    if (predictor ==
                          2 &&
                          sampleSize !=
                          8) {
                        throw new java.lang.RuntimeException(
                          sampleSize +
                          "TIFFImage9");
                    }
                }
                lzwDecoder =
                  new org.apache.batik.ext.awt.image.codec.tiff.TIFFLZWDecoder(
                    tileWidth,
                    predictor,
                    samplesPerPixel);
                break;
            case COMP_JPEG_OLD:
                throw new java.lang.RuntimeException(
                  "TIFFImage15");
            case COMP_JPEG_TTN2:
                if (!(sampleSize ==
                        8 &&
                        (imageType ==
                           TYPE_GRAY &&
                           samplesPerPixel ==
                           1 ||
                           imageType ==
                           TYPE_PALETTE &&
                           samplesPerPixel ==
                           1 ||
                           imageType ==
                           TYPE_RGB &&
                           samplesPerPixel ==
                           3))) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage16");
                }
                if (dir.
                      isTagPresent(
                        TIFF_JPEG_TABLES)) {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField jpegTableField =
                      dir.
                      getField(
                        TIFF_JPEG_TABLES);
                    byte[] jpegTable =
                      jpegTableField.
                      getAsBytes(
                        );
                    java.io.ByteArrayInputStream tableStream =
                      new java.io.ByteArrayInputStream(
                      jpegTable);
                    com.sun.image.codec.jpeg.JPEGImageDecoder decoder =
                      com.sun.image.codec.jpeg.JPEGCodec.
                      createJPEGDecoder(
                        tableStream);
                    decoder.
                      decodeAsRaster(
                        );
                    decodeParam =
                      decoder.
                        getJPEGDecodeParam(
                          );
                }
                break;
            default:
                throw new java.lang.RuntimeException(
                  "TIFFImage10");
        }
        java.awt.image.ColorModel colorModel =
          null;
        java.awt.image.SampleModel sampleModel =
          null;
        switch (imageType) {
            case TYPE_BILEVEL:
            case TYPE_GRAY_4BIT:
                sampleModel =
                  new java.awt.image.MultiPixelPackedSampleModel(
                    dataType,
                    tileWidth,
                    tileHeight,
                    sampleSize);
                if (imageType ==
                      TYPE_BILEVEL) {
                    byte[] map =
                      new byte[] { (byte)
                                     (isWhiteZero
                                        ? 255
                                        : 0),
                    (byte)
                      (isWhiteZero
                         ? 0
                         : 255) };
                    colorModel =
                      new java.awt.image.IndexColorModel(
                        1,
                        2,
                        map,
                        map,
                        map);
                }
                else {
                    byte[] map =
                      new byte[16];
                    if (isWhiteZero) {
                        for (int i =
                               0;
                             i <
                               map.
                                 length;
                             i++)
                            map[i] =
                              (byte)
                                (255 -
                                   16 *
                                   i);
                    }
                    else {
                        for (int i =
                               0;
                             i <
                               map.
                                 length;
                             i++)
                            map[i] =
                              (byte)
                                (16 *
                                   i);
                    }
                    colorModel =
                      new java.awt.image.IndexColorModel(
                        4,
                        16,
                        map,
                        map,
                        map);
                }
                break;
            case TYPE_GRAY:
            case TYPE_GRAY_ALPHA:
            case TYPE_RGB:
            case TYPE_RGB_ALPHA:
                int[] reverseOffsets =
                  new int[numBands];
                for (int i =
                       0;
                     i <
                       numBands;
                     i++) {
                    reverseOffsets[i] =
                      numBands -
                        1 -
                        i;
                }
                sampleModel =
                  new java.awt.image.PixelInterleavedSampleModel(
                    dataType,
                    tileWidth,
                    tileHeight,
                    numBands,
                    numBands *
                      tileWidth,
                    reverseOffsets);
                if (imageType ==
                      TYPE_GRAY) {
                    colorModel =
                      new java.awt.image.ComponentColorModel(
                        java.awt.color.ColorSpace.
                          getInstance(
                            java.awt.color.ColorSpace.
                              CS_GRAY),
                        new int[] { sampleSize },
                        false,
                        false,
                        java.awt.Transparency.
                          OPAQUE,
                        dataType);
                }
                else
                    if (imageType ==
                          TYPE_RGB) {
                        colorModel =
                          new java.awt.image.ComponentColorModel(
                            java.awt.color.ColorSpace.
                              getInstance(
                                java.awt.color.ColorSpace.
                                  CS_sRGB),
                            new int[] { sampleSize,
                            sampleSize,
                            sampleSize },
                            false,
                            false,
                            java.awt.Transparency.
                              OPAQUE,
                            dataType);
                    }
                    else {
                        int transparency =
                          java.awt.Transparency.
                            OPAQUE;
                        if (extraSamples ==
                              1) {
                            transparency =
                              java.awt.Transparency.
                                TRANSLUCENT;
                        }
                        else
                            if (extraSamples ==
                                  2) {
                                transparency =
                                  java.awt.Transparency.
                                    BITMASK;
                            }
                        colorModel =
                          createAlphaComponentColorModel(
                            dataType,
                            numBands,
                            extraSamples ==
                              1,
                            transparency);
                    }
                break;
            case TYPE_GENERIC:
            case TYPE_YCBCR_SUB:
                int[] bandOffsets =
                  new int[numBands];
                for (int i =
                       0;
                     i <
                       numBands;
                     i++) {
                    bandOffsets[i] =
                      i;
                }
                sampleModel =
                  new java.awt.image.PixelInterleavedSampleModel(
                    dataType,
                    tileWidth,
                    tileHeight,
                    numBands,
                    numBands *
                      tileWidth,
                    bandOffsets);
                colorModel =
                  null;
                break;
            case TYPE_PALETTE:
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField cfield =
                  dir.
                  getField(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                      TIFF_COLORMAP);
                if (cfield ==
                      null) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage11");
                }
                else {
                    colormap =
                      cfield.
                        getAsChars(
                          );
                }
                if (decodePaletteAsShorts) {
                    numBands =
                      3;
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_BYTE) {
                        dataType =
                          java.awt.image.DataBuffer.
                            TYPE_USHORT;
                    }
                    sampleModel =
                      createPixelInterleavedSampleModel(
                        dataType,
                        tileWidth,
                        tileHeight,
                        numBands);
                    colorModel =
                      new java.awt.image.ComponentColorModel(
                        java.awt.color.ColorSpace.
                          getInstance(
                            java.awt.color.ColorSpace.
                              CS_sRGB),
                        new int[] { 16,
                        16,
                        16 },
                        false,
                        false,
                        java.awt.Transparency.
                          OPAQUE,
                        dataType);
                }
                else {
                    numBands =
                      1;
                    if (sampleSize ==
                          4) {
                        sampleModel =
                          new java.awt.image.MultiPixelPackedSampleModel(
                            java.awt.image.DataBuffer.
                              TYPE_BYTE,
                            tileWidth,
                            tileHeight,
                            sampleSize);
                    }
                    else
                        if (sampleSize ==
                              8) {
                            sampleModel =
                              createPixelInterleavedSampleModel(
                                java.awt.image.DataBuffer.
                                  TYPE_BYTE,
                                tileWidth,
                                tileHeight,
                                numBands);
                        }
                        else
                            if (sampleSize ==
                                  16) {
                                dataType =
                                  java.awt.image.DataBuffer.
                                    TYPE_USHORT;
                                sampleModel =
                                  createPixelInterleavedSampleModel(
                                    java.awt.image.DataBuffer.
                                      TYPE_USHORT,
                                    tileWidth,
                                    tileHeight,
                                    numBands);
                            }
                    int bandLength =
                      colormap.
                        length /
                      3;
                    byte[] r =
                      new byte[bandLength];
                    byte[] g =
                      new byte[bandLength];
                    byte[] b =
                      new byte[bandLength];
                    int gIndex =
                      bandLength;
                    int bIndex =
                      bandLength *
                      2;
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_SHORT) {
                        for (int i =
                               0;
                             i <
                               bandLength;
                             i++) {
                            r[i] =
                              param.
                                decodeSigned16BitsTo8Bits(
                                  (short)
                                    colormap[i]);
                            g[i] =
                              param.
                                decodeSigned16BitsTo8Bits(
                                  (short)
                                    colormap[gIndex +
                                               i]);
                            b[i] =
                              param.
                                decodeSigned16BitsTo8Bits(
                                  (short)
                                    colormap[bIndex +
                                               i]);
                        }
                    }
                    else {
                        for (int i =
                               0;
                             i <
                               bandLength;
                             i++) {
                            r[i] =
                              param.
                                decode16BitsTo8Bits(
                                  colormap[i] &
                                    65535);
                            g[i] =
                              param.
                                decode16BitsTo8Bits(
                                  colormap[gIndex +
                                             i] &
                                    65535);
                            b[i] =
                              param.
                                decode16BitsTo8Bits(
                                  colormap[bIndex +
                                             i] &
                                    65535);
                        }
                    }
                    colorModel =
                      new java.awt.image.IndexColorModel(
                        sampleSize,
                        bandLength,
                        r,
                        g,
                        b);
                }
                break;
            default:
                throw new java.lang.RuntimeException(
                  "TIFFImage4");
        }
        java.util.Map properties =
          new java.util.HashMap(
          );
        properties.
          put(
            "tiff_directory",
            dir);
        init(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          bounds,
          colorModel,
          sampleModel,
          0,
          0,
          properties);
    }
    public org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory getPrivateIFD(long offset)
          throws java.io.IOException { return new org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory(
                                         stream,
                                         offset,
                                         0);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public synchronized java.awt.image.Raster getTile(int tileX,
                                                      int tileY) {
        if (tileX <
              0 ||
              tileX >=
              tilesX ||
              tileY <
              0 ||
              tileY >=
              tilesY) {
            throw new java.lang.IllegalArgumentException(
              "TIFFImage12");
        }
        byte[] bdata =
          null;
        short[] sdata =
          null;
        int[] idata =
          null;
        java.awt.image.SampleModel sampleModel =
          getSampleModel(
            );
        java.awt.image.WritableRaster tile =
          makeTile(
            tileX,
            tileY);
        java.awt.image.DataBuffer buffer =
          tile.
          getDataBuffer(
            );
        int dataType =
          sampleModel.
          getDataType(
            );
        if (dataType ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            bdata =
              ((java.awt.image.DataBufferByte)
                 buffer).
                getData(
                  );
        }
        else
            if (dataType ==
                  java.awt.image.DataBuffer.
                    TYPE_USHORT) {
                sdata =
                  ((java.awt.image.DataBufferUShort)
                     buffer).
                    getData(
                      );
            }
            else
                if (dataType ==
                      java.awt.image.DataBuffer.
                        TYPE_SHORT) {
                    sdata =
                      ((java.awt.image.DataBufferShort)
                         buffer).
                        getData(
                          );
                }
                else
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_INT) {
                        idata =
                          ((java.awt.image.DataBufferInt)
                             buffer).
                            getData(
                              );
                    }
        byte bswap;
        short sswap;
        int iswap;
        long save_offset =
          0;
        try {
            save_offset =
              stream.
                getFilePointer(
                  );
            stream.
              seek(
                tileOffsets[tileY *
                              tilesX +
                              tileX]);
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        int byteCount =
          (int)
            tileByteCounts[tileY *
                             tilesX +
                             tileX];
        java.awt.Rectangle newRect;
        if (!tiled)
            newRect =
              tile.
                getBounds(
                  );
        else
            newRect =
              new java.awt.Rectangle(
                tile.
                  getMinX(
                    ),
                tile.
                  getMinY(
                    ),
                tileWidth,
                tileHeight);
        int unitsInThisTile =
          newRect.
            width *
          newRect.
            height *
          numBands;
        byte[] data =
          compression !=
          COMP_NONE ||
          imageType ==
          TYPE_PALETTE
          ? (new byte[byteCount])
          : null;
        if (imageType ==
              TYPE_BILEVEL) {
            try {
                if (compression ==
                      COMP_PACKBITS) {
                    stream.
                      readFully(
                        data,
                        0,
                        byteCount);
                    int bytesInThisTile;
                    if (newRect.
                          width %
                          8 ==
                          0) {
                        bytesInThisTile =
                          newRect.
                            width /
                            8 *
                            newRect.
                              height;
                    }
                    else {
                        bytesInThisTile =
                          (newRect.
                             width /
                             8 +
                             1) *
                            newRect.
                              height;
                    }
                    decodePackbits(
                      data,
                      bytesInThisTile,
                      bdata);
                }
                else
                    if (compression ==
                          COMP_LZW) {
                        stream.
                          readFully(
                            data,
                            0,
                            byteCount);
                        lzwDecoder.
                          decode(
                            data,
                            bdata,
                            newRect.
                              height);
                    }
                    else
                        if (compression ==
                              COMP_FAX_G3_1D) {
                            stream.
                              readFully(
                                data,
                                0,
                                byteCount);
                            decoder.
                              decode1D(
                                bdata,
                                data,
                                0,
                                newRect.
                                  height);
                        }
                        else
                            if (compression ==
                                  COMP_FAX_G3_2D) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                decoder.
                                  decode2D(
                                    bdata,
                                    data,
                                    0,
                                    newRect.
                                      height,
                                    tiffT4Options);
                            }
                            else
                                if (compression ==
                                      COMP_FAX_G4_2D) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    decoder.
                                      decodeT6(
                                        bdata,
                                        data,
                                        0,
                                        newRect.
                                          height,
                                        tiffT6Options);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        inflate(
                                          data,
                                          bdata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_NONE) {
                                            stream.
                                              readFully(
                                                bdata,
                                                0,
                                                byteCount);
                                        }
                stream.
                  seek(
                    save_offset);
            }
            catch (java.io.IOException ioe) {
                throw new java.lang.RuntimeException(
                  "TIFFImage13");
            }
        }
        else
            if (imageType ==
                  TYPE_PALETTE) {
                if (sampleSize ==
                      16) {
                    if (decodePaletteAsShorts) {
                        short[] tempData =
                          null;
                        int unitsBeforeLookup =
                          unitsInThisTile /
                          3;
                        int entries =
                          unitsBeforeLookup *
                          2;
                        try {
                            if (compression ==
                                  COMP_PACKBITS) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                byte[] byteArray =
                                  new byte[entries];
                                decodePackbits(
                                  data,
                                  entries,
                                  byteArray);
                                tempData =
                                  (new short[unitsBeforeLookup]);
                                interpretBytesAsShorts(
                                  byteArray,
                                  tempData,
                                  unitsBeforeLookup);
                            }
                            else
                                if (compression ==
                                      COMP_LZW) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    byte[] byteArray =
                                      new byte[entries];
                                    lzwDecoder.
                                      decode(
                                        data,
                                        byteArray,
                                        newRect.
                                          height);
                                    tempData =
                                      (new short[unitsBeforeLookup]);
                                    interpretBytesAsShorts(
                                      byteArray,
                                      tempData,
                                      unitsBeforeLookup);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        byte[] byteArray =
                                          new byte[entries];
                                        inflate(
                                          data,
                                          byteArray);
                                        tempData =
                                          (new short[unitsBeforeLookup]);
                                        interpretBytesAsShorts(
                                          byteArray,
                                          tempData,
                                          unitsBeforeLookup);
                                    }
                                    else
                                        if (compression ==
                                              COMP_NONE) {
                                            tempData =
                                              (new short[byteCount /
                                                           2]);
                                            readShorts(
                                              byteCount /
                                                2,
                                              tempData);
                                        }
                            stream.
                              seek(
                                save_offset);
                        }
                        catch (java.io.IOException ioe) {
                            throw new java.lang.RuntimeException(
                              "TIFFImage13");
                        }
                        if (dataType ==
                              java.awt.image.DataBuffer.
                                TYPE_USHORT) {
                            int cmapValue;
                            int count =
                              0;
                            int lookup;
                            int len =
                              colormap.
                                length /
                              3;
                            int len2 =
                              len *
                              2;
                            for (int i =
                                   0;
                                 i <
                                   unitsBeforeLookup;
                                 i++) {
                                lookup =
                                  tempData[i] &
                                    65535;
                                cmapValue =
                                  colormap[lookup +
                                             len2];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup +
                                             len];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                            }
                        }
                        else
                            if (dataType ==
                                  java.awt.image.DataBuffer.
                                    TYPE_SHORT) {
                                int cmapValue;
                                int count =
                                  0;
                                int lookup;
                                int len =
                                  colormap.
                                    length /
                                  3;
                                int len2 =
                                  len *
                                  2;
                                for (int i =
                                       0;
                                     i <
                                       unitsBeforeLookup;
                                     i++) {
                                    lookup =
                                      tempData[i] &
                                        65535;
                                    cmapValue =
                                      colormap[lookup +
                                                 len2];
                                    sdata[count++] =
                                      (short)
                                        cmapValue;
                                    cmapValue =
                                      colormap[lookup +
                                                 len];
                                    sdata[count++] =
                                      (short)
                                        cmapValue;
                                    cmapValue =
                                      colormap[lookup];
                                    sdata[count++] =
                                      (short)
                                        cmapValue;
                                }
                            }
                    }
                    else {
                        try {
                            if (compression ==
                                  COMP_PACKBITS) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                int bytesInThisTile =
                                  unitsInThisTile *
                                  2;
                                byte[] byteArray =
                                  new byte[bytesInThisTile];
                                decodePackbits(
                                  data,
                                  bytesInThisTile,
                                  byteArray);
                                interpretBytesAsShorts(
                                  byteArray,
                                  sdata,
                                  unitsInThisTile);
                            }
                            else
                                if (compression ==
                                      COMP_LZW) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    byte[] byteArray =
                                      new byte[unitsInThisTile *
                                                 2];
                                    lzwDecoder.
                                      decode(
                                        data,
                                        byteArray,
                                        newRect.
                                          height);
                                    interpretBytesAsShorts(
                                      byteArray,
                                      sdata,
                                      unitsInThisTile);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        byte[] byteArray =
                                          new byte[unitsInThisTile *
                                                     2];
                                        inflate(
                                          data,
                                          byteArray);
                                        interpretBytesAsShorts(
                                          byteArray,
                                          sdata,
                                          unitsInThisTile);
                                    }
                                    else
                                        if (compression ==
                                              COMP_NONE) {
                                            readShorts(
                                              byteCount /
                                                2,
                                              sdata);
                                        }
                            stream.
                              seek(
                                save_offset);
                        }
                        catch (java.io.IOException ioe) {
                            throw new java.lang.RuntimeException(
                              "TIFFImage13");
                        }
                    }
                }
                else
                    if (sampleSize ==
                          8) {
                        if (decodePaletteAsShorts) {
                            byte[] tempData =
                              null;
                            int unitsBeforeLookup =
                              unitsInThisTile /
                              3;
                            try {
                                if (compression ==
                                      COMP_PACKBITS) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    tempData =
                                      (new byte[unitsBeforeLookup]);
                                    decodePackbits(
                                      data,
                                      unitsBeforeLookup,
                                      tempData);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        tempData =
                                          (new byte[unitsBeforeLookup]);
                                        lzwDecoder.
                                          decode(
                                            data,
                                            tempData,
                                            newRect.
                                              height);
                                    }
                                    else
                                        if (compression ==
                                              COMP_JPEG_TTN2) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            java.awt.image.Raster tempTile =
                                              decodeJPEG(
                                                data,
                                                decodeParam,
                                                colorConvertJPEG,
                                                tile.
                                                  getMinX(
                                                    ),
                                                tile.
                                                  getMinY(
                                                    ));
                                            int[] tempPixels =
                                              new int[unitsBeforeLookup];
                                            tempTile.
                                              getPixels(
                                                tile.
                                                  getMinX(
                                                    ),
                                                tile.
                                                  getMinY(
                                                    ),
                                                tile.
                                                  getWidth(
                                                    ),
                                                tile.
                                                  getHeight(
                                                    ),
                                                tempPixels);
                                            tempData =
                                              (new byte[unitsBeforeLookup]);
                                            for (int i =
                                                   0;
                                                 i <
                                                   unitsBeforeLookup;
                                                 i++) {
                                                tempData[i] =
                                                  (byte)
                                                    tempPixels[i];
                                            }
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                tempData =
                                                  (new byte[unitsBeforeLookup]);
                                                inflate(
                                                  data,
                                                  tempData);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_NONE) {
                                                    tempData =
                                                      (new byte[byteCount]);
                                                    stream.
                                                      readFully(
                                                        tempData,
                                                        0,
                                                        byteCount);
                                                }
                                stream.
                                  seek(
                                    save_offset);
                            }
                            catch (java.io.IOException ioe) {
                                throw new java.lang.RuntimeException(
                                  "TIFFImage13");
                            }
                            int cmapValue;
                            int count =
                              0;
                            int lookup;
                            int len =
                              colormap.
                                length /
                              3;
                            int len2 =
                              len *
                              2;
                            for (int i =
                                   0;
                                 i <
                                   unitsBeforeLookup;
                                 i++) {
                                lookup =
                                  tempData[i] &
                                    255;
                                cmapValue =
                                  colormap[lookup +
                                             len2];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup +
                                             len];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                            }
                        }
                        else {
                            try {
                                if (compression ==
                                      COMP_PACKBITS) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    decodePackbits(
                                      data,
                                      unitsInThisTile,
                                      bdata);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        lzwDecoder.
                                          decode(
                                            data,
                                            bdata,
                                            newRect.
                                              height);
                                    }
                                    else
                                        if (compression ==
                                              COMP_JPEG_TTN2) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            tile.
                                              setRect(
                                                decodeJPEG(
                                                  data,
                                                  decodeParam,
                                                  colorConvertJPEG,
                                                  tile.
                                                    getMinX(
                                                      ),
                                                  tile.
                                                    getMinY(
                                                      )));
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                inflate(
                                                  data,
                                                  bdata);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_NONE) {
                                                    stream.
                                                      readFully(
                                                        bdata,
                                                        0,
                                                        byteCount);
                                                }
                                stream.
                                  seek(
                                    save_offset);
                            }
                            catch (java.io.IOException ioe) {
                                throw new java.lang.RuntimeException(
                                  "TIFFImage13");
                            }
                        }
                    }
                    else
                        if (sampleSize ==
                              4) {
                            int padding =
                              newRect.
                                width %
                              2 ==
                              0
                              ? 0
                              : 1;
                            int bytesPostDecoding =
                              (newRect.
                                 width /
                                 2 +
                                 padding) *
                              newRect.
                                height;
                            if (decodePaletteAsShorts) {
                                byte[] tempData =
                                  null;
                                try {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    stream.
                                      seek(
                                        save_offset);
                                }
                                catch (java.io.IOException ioe) {
                                    throw new java.lang.RuntimeException(
                                      "TIFFImage13");
                                }
                                if (compression ==
                                      COMP_PACKBITS) {
                                    tempData =
                                      (new byte[bytesPostDecoding]);
                                    decodePackbits(
                                      data,
                                      bytesPostDecoding,
                                      tempData);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        tempData =
                                          (new byte[bytesPostDecoding]);
                                        lzwDecoder.
                                          decode(
                                            data,
                                            tempData,
                                            newRect.
                                              height);
                                    }
                                    else
                                        if (compression ==
                                              COMP_DEFLATE) {
                                            tempData =
                                              (new byte[bytesPostDecoding]);
                                            inflate(
                                              data,
                                              tempData);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_NONE) {
                                                tempData =
                                                  data;
                                            }
                                int bytes =
                                  unitsInThisTile /
                                  3;
                                data =
                                  (new byte[bytes]);
                                int srcCount =
                                  0;
                                int dstCount =
                                  0;
                                for (int j =
                                       0;
                                     j <
                                       newRect.
                                         height;
                                     j++) {
                                    for (int i =
                                           0;
                                         i <
                                           newRect.
                                             width /
                                           2;
                                         i++) {
                                        data[dstCount++] =
                                          (byte)
                                            ((tempData[srcCount] &
                                                240) >>
                                               4);
                                        data[dstCount++] =
                                          (byte)
                                            (tempData[srcCount++] &
                                               15);
                                    }
                                    if (padding ==
                                          1) {
                                        data[dstCount++] =
                                          (byte)
                                            ((tempData[srcCount++] &
                                                240) >>
                                               4);
                                    }
                                }
                                int len =
                                  colormap.
                                    length /
                                  3;
                                int len2 =
                                  len *
                                  2;
                                int cmapValue;
                                int lookup;
                                int count =
                                  0;
                                for (int i =
                                       0;
                                     i <
                                       bytes;
                                     i++) {
                                    lookup =
                                      data[i] &
                                        255;
                                    cmapValue =
                                      colormap[lookup +
                                                 len2];
                                    sdata[count++] =
                                      (short)
                                        (cmapValue &
                                           65535);
                                    cmapValue =
                                      colormap[lookup +
                                                 len];
                                    sdata[count++] =
                                      (short)
                                        (cmapValue &
                                           65535);
                                    cmapValue =
                                      colormap[lookup];
                                    sdata[count++] =
                                      (short)
                                        (cmapValue &
                                           65535);
                                }
                            }
                            else {
                                try {
                                    if (compression ==
                                          COMP_PACKBITS) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        decodePackbits(
                                          data,
                                          bytesPostDecoding,
                                          bdata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_LZW) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            lzwDecoder.
                                              decode(
                                                data,
                                                bdata,
                                                newRect.
                                                  height);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                inflate(
                                                  data,
                                                  bdata);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_NONE) {
                                                    stream.
                                                      readFully(
                                                        bdata,
                                                        0,
                                                        byteCount);
                                                }
                                    stream.
                                      seek(
                                        save_offset);
                                }
                                catch (java.io.IOException ioe) {
                                    throw new java.lang.RuntimeException(
                                      "TIFFImage13");
                                }
                            }
                        }
            }
            else
                if (imageType ==
                      TYPE_GRAY_4BIT) {
                    try {
                        if (compression ==
                              COMP_PACKBITS) {
                            stream.
                              readFully(
                                data,
                                0,
                                byteCount);
                            int bytesInThisTile;
                            if (newRect.
                                  width %
                                  8 ==
                                  0) {
                                bytesInThisTile =
                                  newRect.
                                    width /
                                    2 *
                                    newRect.
                                      height;
                            }
                            else {
                                bytesInThisTile =
                                  (newRect.
                                     width /
                                     2 +
                                     1) *
                                    newRect.
                                      height;
                            }
                            decodePackbits(
                              data,
                              bytesInThisTile,
                              bdata);
                        }
                        else
                            if (compression ==
                                  COMP_LZW) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                lzwDecoder.
                                  decode(
                                    data,
                                    bdata,
                                    newRect.
                                      height);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    inflate(
                                      data,
                                      bdata);
                                }
                                else {
                                    stream.
                                      readFully(
                                        bdata,
                                        0,
                                        byteCount);
                                }
                        stream.
                          seek(
                            save_offset);
                    }
                    catch (java.io.IOException ioe) {
                        throw new java.lang.RuntimeException(
                          "TIFFImage13");
                    }
                }
                else {
                    try {
                        if (sampleSize ==
                              8) {
                            if (compression ==
                                  COMP_NONE) {
                                stream.
                                  readFully(
                                    bdata,
                                    0,
                                    byteCount);
                            }
                            else
                                if (compression ==
                                      COMP_LZW) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    lzwDecoder.
                                      decode(
                                        data,
                                        bdata,
                                        newRect.
                                          height);
                                }
                                else
                                    if (compression ==
                                          COMP_PACKBITS) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        decodePackbits(
                                          data,
                                          unitsInThisTile,
                                          bdata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_JPEG_TTN2) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            tile.
                                              setRect(
                                                decodeJPEG(
                                                  data,
                                                  decodeParam,
                                                  colorConvertJPEG,
                                                  tile.
                                                    getMinX(
                                                      ),
                                                  tile.
                                                    getMinY(
                                                      )));
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                inflate(
                                                  data,
                                                  bdata);
                                            }
                        }
                        else
                            if (sampleSize ==
                                  16) {
                                if (compression ==
                                      COMP_NONE) {
                                    readShorts(
                                      byteCount /
                                        2,
                                      sdata);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        byte[] byteArray =
                                          new byte[unitsInThisTile *
                                                     2];
                                        lzwDecoder.
                                          decode(
                                            data,
                                            byteArray,
                                            newRect.
                                              height);
                                        interpretBytesAsShorts(
                                          byteArray,
                                          sdata,
                                          unitsInThisTile);
                                    }
                                    else
                                        if (compression ==
                                              COMP_PACKBITS) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            int bytesInThisTile =
                                              unitsInThisTile *
                                              2;
                                            byte[] byteArray =
                                              new byte[bytesInThisTile];
                                            decodePackbits(
                                              data,
                                              bytesInThisTile,
                                              byteArray);
                                            interpretBytesAsShorts(
                                              byteArray,
                                              sdata,
                                              unitsInThisTile);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                byte[] byteArray =
                                                  new byte[unitsInThisTile *
                                                             2];
                                                inflate(
                                                  data,
                                                  byteArray);
                                                interpretBytesAsShorts(
                                                  byteArray,
                                                  sdata,
                                                  unitsInThisTile);
                                            }
                            }
                            else
                                if (sampleSize ==
                                      32 &&
                                      dataType ==
                                      java.awt.image.DataBuffer.
                                        TYPE_INT) {
                                    if (compression ==
                                          COMP_NONE) {
                                        readInts(
                                          byteCount /
                                            4,
                                          idata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_LZW) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            byte[] byteArray =
                                              new byte[unitsInThisTile *
                                                         4];
                                            lzwDecoder.
                                              decode(
                                                data,
                                                byteArray,
                                                newRect.
                                                  height);
                                            interpretBytesAsInts(
                                              byteArray,
                                              idata,
                                              unitsInThisTile);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_PACKBITS) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                int bytesInThisTile =
                                                  unitsInThisTile *
                                                  4;
                                                byte[] byteArray =
                                                  new byte[bytesInThisTile];
                                                decodePackbits(
                                                  data,
                                                  bytesInThisTile,
                                                  byteArray);
                                                interpretBytesAsInts(
                                                  byteArray,
                                                  idata,
                                                  unitsInThisTile);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_DEFLATE) {
                                                    stream.
                                                      readFully(
                                                        data,
                                                        0,
                                                        byteCount);
                                                    byte[] byteArray =
                                                      new byte[unitsInThisTile *
                                                                 4];
                                                    inflate(
                                                      data,
                                                      byteArray);
                                                    interpretBytesAsInts(
                                                      byteArray,
                                                      idata,
                                                      unitsInThisTile);
                                                }
                                }
                        stream.
                          seek(
                            save_offset);
                    }
                    catch (java.io.IOException ioe) {
                        throw new java.lang.RuntimeException(
                          "TIFFImage13");
                    }
                    switch (imageType) {
                        case TYPE_GRAY:
                        case TYPE_GRAY_ALPHA:
                            if (isWhiteZero) {
                                if (dataType ==
                                      java.awt.image.DataBuffer.
                                        TYPE_BYTE &&
                                      !(getColorModel(
                                          ) instanceof java.awt.image.IndexColorModel)) {
                                    for (int l =
                                           0;
                                         l <
                                           bdata.
                                             length;
                                         l +=
                                           numBands) {
                                        bdata[l] =
                                          (byte)
                                            (255 -
                                               bdata[l]);
                                    }
                                }
                                else
                                    if (dataType ==
                                          java.awt.image.DataBuffer.
                                            TYPE_USHORT) {
                                        int ushortMax =
                                          java.lang.Short.
                                            MAX_VALUE -
                                          java.lang.Short.
                                            MIN_VALUE;
                                        for (int l =
                                               0;
                                             l <
                                               sdata.
                                                 length;
                                             l +=
                                               numBands) {
                                            sdata[l] =
                                              (short)
                                                (ushortMax -
                                                   sdata[l]);
                                        }
                                    }
                                    else
                                        if (dataType ==
                                              java.awt.image.DataBuffer.
                                                TYPE_SHORT) {
                                            for (int l =
                                                   0;
                                                 l <
                                                   sdata.
                                                     length;
                                                 l +=
                                                   numBands) {
                                                sdata[l] =
                                                  (short)
                                                    ~sdata[l];
                                            }
                                        }
                                        else
                                            if (dataType ==
                                                  java.awt.image.DataBuffer.
                                                    TYPE_INT) {
                                                long uintMax =
                                                  (long)
                                                    java.lang.Integer.
                                                      MAX_VALUE -
                                                  (long)
                                                    java.lang.Integer.
                                                      MIN_VALUE;
                                                for (int l =
                                                       0;
                                                     l <
                                                       idata.
                                                         length;
                                                     l +=
                                                       numBands) {
                                                    idata[l] =
                                                      (int)
                                                        (uintMax -
                                                           idata[l]);
                                                }
                                            }
                            }
                            break;
                        case TYPE_RGB:
                            if (sampleSize ==
                                  8 &&
                                  compression !=
                                  COMP_JPEG_TTN2) {
                                for (int i =
                                       0;
                                     i <
                                       unitsInThisTile;
                                     i +=
                                       3) {
                                    bswap =
                                      bdata[i];
                                    bdata[i] =
                                      bdata[i +
                                              2];
                                    bdata[i +
                                            2] =
                                      bswap;
                                }
                            }
                            else
                                if (sampleSize ==
                                      16) {
                                    for (int i =
                                           0;
                                         i <
                                           unitsInThisTile;
                                         i +=
                                           3) {
                                        sswap =
                                          sdata[i];
                                        sdata[i] =
                                          sdata[i +
                                                  2];
                                        sdata[i +
                                                2] =
                                          sswap;
                                    }
                                }
                                else
                                    if (sampleSize ==
                                          32) {
                                        if (dataType ==
                                              java.awt.image.DataBuffer.
                                                TYPE_INT) {
                                            for (int i =
                                                   0;
                                                 i <
                                                   unitsInThisTile;
                                                 i +=
                                                   3) {
                                                iswap =
                                                  idata[i];
                                                idata[i] =
                                                  idata[i +
                                                          2];
                                                idata[i +
                                                        2] =
                                                  iswap;
                                            }
                                        }
                                    }
                            break;
                        case TYPE_RGB_ALPHA:
                            if (sampleSize ==
                                  8) {
                                for (int i =
                                       0;
                                     i <
                                       unitsInThisTile;
                                     i +=
                                       4) {
                                    bswap =
                                      bdata[i];
                                    bdata[i] =
                                      bdata[i +
                                              3];
                                    bdata[i +
                                            3] =
                                      bswap;
                                    bswap =
                                      bdata[i +
                                              1];
                                    bdata[i +
                                            1] =
                                      bdata[i +
                                              2];
                                    bdata[i +
                                            2] =
                                      bswap;
                                }
                            }
                            else
                                if (sampleSize ==
                                      16) {
                                    for (int i =
                                           0;
                                         i <
                                           unitsInThisTile;
                                         i +=
                                           4) {
                                        sswap =
                                          sdata[i];
                                        sdata[i] =
                                          sdata[i +
                                                  3];
                                        sdata[i +
                                                3] =
                                          sswap;
                                        sswap =
                                          sdata[i +
                                                  1];
                                        sdata[i +
                                                1] =
                                          sdata[i +
                                                  2];
                                        sdata[i +
                                                2] =
                                          sswap;
                                    }
                                }
                                else
                                    if (sampleSize ==
                                          32) {
                                        if (dataType ==
                                              java.awt.image.DataBuffer.
                                                TYPE_INT) {
                                            for (int i =
                                                   0;
                                                 i <
                                                   unitsInThisTile;
                                                 i +=
                                                   4) {
                                                iswap =
                                                  idata[i];
                                                idata[i] =
                                                  idata[i +
                                                          3];
                                                idata[i +
                                                        3] =
                                                  iswap;
                                                iswap =
                                                  idata[i +
                                                          1];
                                                idata[i +
                                                        1] =
                                                  idata[i +
                                                          2];
                                                idata[i +
                                                        2] =
                                                  iswap;
                                            }
                                        }
                                    }
                            break;
                        case TYPE_YCBCR_SUB:
                            int pixelsPerDataUnit =
                              chromaSubH *
                              chromaSubV;
                            int numH =
                              newRect.
                                width /
                              chromaSubH;
                            int numV =
                              newRect.
                                height /
                              chromaSubV;
                            byte[] tempData =
                              new byte[numH *
                                         numV *
                                         (pixelsPerDataUnit +
                                            2)];
                            java.lang.System.
                              arraycopy(
                                bdata,
                                0,
                                tempData,
                                0,
                                tempData.
                                  length);
                            int samplesPerDataUnit =
                              pixelsPerDataUnit *
                              3;
                            int[] pixels =
                              new int[samplesPerDataUnit];
                            int bOffset =
                              0;
                            int offsetCb =
                              pixelsPerDataUnit;
                            int offsetCr =
                              offsetCb +
                              1;
                            int y =
                              newRect.
                                y;
                            for (int j =
                                   0;
                                 j <
                                   numV;
                                 j++) {
                                int x =
                                  newRect.
                                    x;
                                for (int i =
                                       0;
                                     i <
                                       numH;
                                     i++) {
                                    int Cb =
                                      tempData[bOffset +
                                                 offsetCb];
                                    int Cr =
                                      tempData[bOffset +
                                                 offsetCr];
                                    int k =
                                      0;
                                    while (k <
                                             samplesPerDataUnit) {
                                        pixels[k++] =
                                          tempData[bOffset++];
                                        pixels[k++] =
                                          Cb;
                                        pixels[k++] =
                                          Cr;
                                    }
                                    bOffset +=
                                      2;
                                    tile.
                                      setPixels(
                                        x,
                                        y,
                                        chromaSubH,
                                        chromaSubV,
                                        pixels);
                                    x +=
                                      chromaSubH;
                                }
                                y +=
                                  chromaSubV;
                            }
                            break;
                    }
                }
        return tile;
    }
    private void readShorts(int shortCount,
                            short[] shortArray) {
        int byteCount =
          2 *
          shortCount;
        byte[] byteArray =
          new byte[byteCount];
        try {
            stream.
              readFully(
                byteArray,
                0,
                byteCount);
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        interpretBytesAsShorts(
          byteArray,
          shortArray,
          shortCount);
    }
    private void readInts(int intCount, int[] intArray) {
        int byteCount =
          4 *
          intCount;
        byte[] byteArray =
          new byte[byteCount];
        try {
            stream.
              readFully(
                byteArray,
                0,
                byteCount);
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        interpretBytesAsInts(
          byteArray,
          intArray,
          intCount);
    }
    private void interpretBytesAsShorts(byte[] byteArray,
                                        short[] shortArray,
                                        int shortCount) {
        int j =
          0;
        int firstByte;
        int secondByte;
        if (isBigEndian) {
            for (int i =
                   0;
                 i <
                   shortCount;
                 i++) {
                firstByte =
                  byteArray[j++] &
                    255;
                secondByte =
                  byteArray[j++] &
                    255;
                shortArray[i] =
                  (short)
                    ((firstByte <<
                        8) +
                       secondByte);
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   shortCount;
                 i++) {
                firstByte =
                  byteArray[j++] &
                    255;
                secondByte =
                  byteArray[j++] &
                    255;
                shortArray[i] =
                  (short)
                    ((secondByte <<
                        8) +
                       firstByte);
            }
        }
    }
    private void interpretBytesAsInts(byte[] byteArray,
                                      int[] intArray,
                                      int intCount) {
        int j =
          0;
        if (isBigEndian) {
            for (int i =
                   0;
                 i <
                   intCount;
                 i++) {
                intArray[i] =
                  (byteArray[j++] &
                     255) <<
                    24 |
                    (byteArray[j++] &
                       255) <<
                    16 |
                    (byteArray[j++] &
                       255) <<
                    8 |
                    byteArray[j++] &
                    255;
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   intCount;
                 i++) {
                intArray[i] =
                  byteArray[j++] &
                    255 |
                    (byteArray[j++] &
                       255) <<
                    8 |
                    (byteArray[j++] &
                       255) <<
                    16 |
                    (byteArray[j++] &
                       255) <<
                    24;
            }
        }
    }
    private byte[] decodePackbits(byte[] data,
                                  int arraySize,
                                  byte[] dst) {
        if (dst ==
              null) {
            dst =
              (new byte[arraySize]);
        }
        int srcCount =
          0;
        int dstCount =
          0;
        byte repeat;
        byte b;
        try {
            while (dstCount <
                     arraySize) {
                b =
                  data[srcCount++];
                if (b >=
                      0 &&
                      b <=
                      127) {
                    for (int i =
                           0;
                         i <
                           b +
                           1;
                         i++) {
                        dst[dstCount++] =
                          data[srcCount++];
                    }
                }
                else
                    if (b <=
                          -1 &&
                          b >=
                          -127) {
                        repeat =
                          data[srcCount++];
                        for (int i =
                               0;
                             i <
                               -b +
                               1;
                             i++) {
                            dst[dstCount++] =
                              repeat;
                        }
                    }
                    else {
                        srcCount++;
                    }
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException ae) {
            throw new java.lang.RuntimeException(
              "TIFFImage14");
        }
        return dst;
    }
    private java.awt.image.ComponentColorModel createAlphaComponentColorModel(int dataType,
                                                                              int numBands,
                                                                              boolean isAlphaPremultiplied,
                                                                              int transparency) {
        java.awt.image.ComponentColorModel ccm =
          null;
        int[] RGBBits =
          null;
        java.awt.color.ColorSpace cs =
          null;
        switch (numBands) {
            case 2:
                cs =
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY);
                break;
            case 4:
                cs =
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_sRGB);
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  );
        }
        int componentSize =
          0;
        switch (dataType) {
            case java.awt.image.DataBuffer.
                   TYPE_BYTE:
                componentSize =
                  8;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_USHORT:
            case java.awt.image.DataBuffer.
                   TYPE_SHORT:
                componentSize =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_INT:
                componentSize =
                  32;
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  );
        }
        RGBBits =
          (new int[numBands]);
        for (int i =
               0;
             i <
               numBands;
             i++) {
            RGBBits[i] =
              componentSize;
        }
        ccm =
          new java.awt.image.ComponentColorModel(
            cs,
            RGBBits,
            true,
            isAlphaPremultiplied,
            transparency,
            dataType);
        return ccm;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bM//AxyQC8nFVwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LIN3zwL9z1cApfag1AWgRc37a1cpXgD0fCP49Svg0ntc+gLcour97avgimgX" +
       "ZZ5iZ2dq93eugDve444vwL07P/nDq9gs3qf7DIGeBfs/Lgn7DWBj9rDM+bDX" +
       "3pif/OnlYB/M37TsmzVIl+yf2VT4whWA2T0wez7wwUP5yf+9HPDDBfCRMbAI" +
       "NSEJGj8L+8+fOXbR+X8x2GZ77NlN2KXi5K/Ppi0d4oG+ZP7KK/9VOYXzN5fE" +
       "yU/me5z52TjXbrsFzt2xZWuslWln6Ofa7ZcEehHY+D0Qfw7QvbfSTw4UCWfh" +
       "POcrgPO8Z4RzVrV97aEr4Ah7HOEcnEdugfOcHGf34SmKwtIrz3/5VLy73b3C" +
       "/OC/ePxXvvWDj/9+8a7sbiuayyESGmd89DsR58+e/tyf/OpzH/1o8Yng9oUc" +
       "7V7WnP5aevPH0Bu+cRbY9x2p4aFclIdB0b1zp4XdMS69+Vl+iFqElmpoEDvH" +
       "Eddydt/FXcNyj750fWUz2NlBo3hEu/NviEu3255r+L5fOmU1X3MFnyPurUY8" +
       "x2pefQuruT+3mu421lBvvfusf+1lp7Bec0ms/COOtMeSzsGCbuV7FM/OvyD5" +
       "BdGjRxk8uM/g2v279HfHuLT8Sn6v7Fmhlr8S3h7azFcxt7MNSDH3oyhOv5cf" +
       "5upqHmr5dWdrueimvPqGmvFOW3ON3Sfo3Jdda/jpUfoHu0jF76P3/sVrUxQY" +
       "spZ/qzm894LDbwJHozDAzfQm0rD02vO9E1U4ieP307/wzv/1Yu715lsv8SH1" +
       "Zaec1+kk/yX19C/hr1K+56B029Hb6puGaNwY6ckb31HfG2rxOnS5G95UP7pT" +
       "fqG/nebz3SsLFRe/j7+llI7N/Rp5wT063xFx6Q4lV/XuyVwQfJqe9imVSxbe" +
       "54PtjfvC+8ZzCi93i8J7byQ7/vlNh9kV/Mmb9khvOgfpnJfex5VjPnwj1KJo" +
       "/+n3NNMlXnEfqenNe6Y3n8O0uAXTXb5sa3GsnXJxL8nDPAaKySf2Lu4TOxen" +
       "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" +
       "bjUovL5JAQ5C007molmvJY0mE5sV+xsL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "XvRTr/vRD/5usQD0/wdMpHiioGcAAA==");
}
