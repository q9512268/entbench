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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "org5FzqylGJKq4m7vW6lXg5mWaWNw/Jo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "BvwMPRB50AlLr1B8LVPDwEg0M1+TyDc1eZ01+4v5DnRmJ+a+kTx6zEiORyl0" +
       "hTwPXeXjlIsxVp/Z6eozF9DV0TE2x8Q+tjrYBVdlLNazKlQ2PkOd+VzLvUFY" +
       "elDXwiIFHOTjVQoJHz9Uz/B5qKeYg/zqzFu8dpt2u7+Iel5zlnryzJ4sZFFO" +
       "jVB6cxEhH0y397awdH8m7GC7lAiBofv6BS+4Ht7+5LBDLV1/Hlp6dGdEt13b" +
       "aenaV1RL+0I+dqwwCL4R5jPDtp6z0JJ3hrlEeWAWEwbdDSqHcv77iMO1nq/L" +
       "ye0E3GkAvKjLeU1Yui/Y2PmQf9tINfUc13vU5bzrDKHfnQdp5nozsxltV6Ld" +
       "u3Yo8zueh8zFCL03ZQ2B3aSCO2+aVHA513FUyCLLx27MMju4cs82y+0+LK2/" +
       "qvN0M3+7v7i2Zoed4ur+zKa/p5xPnN50R7A/rvXE+U17798Nmdz74Fl26JVO" +
       "nt+0948vN78py7ZI7Z09v2nvQ2dcezYPftDbzW/KSM6I++Fku3/fGXH+eR68" +
       "J8znX8rqwWjgvdcfFoz3Pt+CkTmAO8NdwQi/NgXjwaxdsls4Zbv/Sk+8k103" +
       "qARrfeY7caD5FSYfVG0oK83P7qeZX53ZfreSaXKgk5Mt/2P7lv+Tl7L8j17S" +
       "8j9WGNtHz7P8f3PGtZ/Ng08cWP5Hz7L8T+0s/7kz4vy7PPjRrBLMLZ+wb7L7" +
       "cycB3Yrdv3dn99/5lbH72w46bEWHo3Alu6rvl84Q9bN58Jmw9HCx8oTra2G+" +
       "eEFwZPj/UcHPXf3pPMEbmcD/Yif4D391BP/ooeC/fobgv5EH/yUsvfi44Cc8" +
       "7889377DKzJxd1OMt/uvuNi72bWFaL9/htj/PQ9+Oyw9sD/bQ1nNjO00D/1Q" +
       "4HOXdzpD4Cfyk2/MBP3CTuAvfGUEPqlPuXvNUEj2xTOk/j958IWw9PJtnxI2" +
       "3YWcTxRw7KzFgOSz027oUL7yWBv6tKiFrv74IrpK8sXr9lfUz5cHf+Smf/Wx" +
       "/fcUyseeffDulz47/o3tijH7/0LiHqp09zwyzaNL/x45vjOz47lRqO+eInzA" +
       "LeT/q7D02lvu/ISl2/NdUQj+cpv+y2HpqVtJny+ekO+Ppv3bTO1np81SFfsj" +
       "qW67EpYeOS1VWLotC4/Gvj0rxyfFzmJm4dGYd4Wlq8djZvkX+6Px7s3aPYfx" +
       "wtKd24OjUe7P7p5FyQ8fcPdN57w+vK/ZquZr6jV4FoS+rIRc1ovZVsKPHClP" +
       "23eO5y6JdOTt4ZM3rPJR/J+Z/RU5ou1/mrmufPxZknnHl4Af2S74r5hymuZ3" +
       "uZsq3bX93wPFTfNVPV5x6t3273Vn77VffuAn7nnV/vvIB7bAh2X7CNvjJ6+u" +
       "37XcsFgPP/2Zl/7U63/02d8tFpH+/9ESRMsAaAAA");
}
