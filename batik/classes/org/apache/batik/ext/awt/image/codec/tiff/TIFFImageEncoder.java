package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFImageEncoder extends org.apache.batik.ext.awt.image.codec.util.ImageEncoderImpl {
    private static final int TIFF_UNSUPPORTED = -1;
    private static final int TIFF_BILEVEL_WHITE_IS_ZERO = 0;
    private static final int TIFF_BILEVEL_BLACK_IS_ZERO = 1;
    private static final int TIFF_GRAY = 2;
    private static final int TIFF_PALETTE = 3;
    private static final int TIFF_RGB = 4;
    private static final int TIFF_CMYK = 5;
    private static final int TIFF_YCBCR = 6;
    private static final int TIFF_CIELAB = 7;
    private static final int TIFF_GENERIC = 8;
    private static final int COMP_NONE = 1;
    private static final int COMP_JPEG_TTN2 = 7;
    private static final int COMP_PACKBITS = 32773;
    private static final int COMP_DEFLATE = 32946;
    private static final int TIFF_JPEG_TABLES = 347;
    private static final int TIFF_YCBCR_SUBSAMPLING = 530;
    private static final int TIFF_YCBCR_POSITIONING = 531;
    private static final int TIFF_REF_BLACK_WHITE = 532;
    private static final int EXTRA_SAMPLE_UNSPECIFIED = 0;
    private static final int EXTRA_SAMPLE_ASSOCIATED_ALPHA = 1;
    private static final int EXTRA_SAMPLE_UNASSOCIATED_ALPHA = 2;
    private static final int DEFAULT_ROWS_PER_STRIP = 8;
    public TIFFImageEncoder(java.io.OutputStream output, org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam param) {
        super(
          output,
          param);
        if (this.
              param ==
              null) {
            this.
              param =
              new org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam(
                );
        }
    }
    public void encode(java.awt.image.RenderedImage im) throws java.io.IOException {
        writeFileHeader(
          );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam encodeParam =
          (org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam)
            param;
        java.util.Iterator iter =
          encodeParam.
          getExtraImages(
            );
        if (iter !=
              null) {
            int ifdOffset =
              8;
            java.awt.image.RenderedImage nextImage =
              im;
            org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam nextParam =
              encodeParam;
            boolean hasNext;
            do  {
                hasNext =
                  iter.
                    hasNext(
                      );
                ifdOffset =
                  encode(
                    nextImage,
                    nextParam,
                    ifdOffset,
                    !hasNext);
                if (hasNext) {
                    java.lang.Object obj =
                      iter.
                      next(
                        );
                    if (obj instanceof java.awt.image.RenderedImage) {
                        nextImage =
                          (java.awt.image.RenderedImage)
                            obj;
                        nextParam =
                          encodeParam;
                    }
                    else
                        if (obj instanceof java.lang.Object[]) {
                            java.lang.Object[] o =
                              (java.lang.Object[])
                                obj;
                            nextImage =
                              (java.awt.image.RenderedImage)
                                o[0];
                            nextParam =
                              (org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam)
                                o[1];
                        }
                }
            }while(hasNext); 
        }
        else {
            encode(
              im,
              encodeParam,
              8,
              true);
        }
    }
    private int encode(java.awt.image.RenderedImage im,
                       org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam encodeParam,
                       int ifdOffset,
                       boolean isLast) throws java.io.IOException {
        int compression =
          encodeParam.
          getCompression(
            );
        boolean isTiled =
          encodeParam.
          getWriteTiled(
            );
        int minX =
          im.
          getMinX(
            );
        int minY =
          im.
          getMinY(
            );
        int width =
          im.
          getWidth(
            );
        int height =
          im.
          getHeight(
            );
        java.awt.image.SampleModel sampleModel =
          im.
          getSampleModel(
            );
        int[] sampleSize =
          sampleModel.
          getSampleSize(
            );
        for (int i =
               1;
             i <
               sampleSize.
                 length;
             i++) {
            if (sampleSize[i] !=
                  sampleSize[0]) {
                throw new java.lang.Error(
                  "TIFFImageEncoder0");
            }
        }
        int numBands =
          sampleModel.
          getNumBands(
            );
        if ((sampleSize[0] ==
               1 ||
               sampleSize[0] ==
               4) &&
              numBands !=
              1) {
            throw new java.lang.Error(
              "TIFFImageEncoder1");
        }
        int dataType =
          sampleModel.
          getDataType(
            );
        switch (dataType) {
            case java.awt.image.DataBuffer.
                   TYPE_BYTE:
                if (sampleSize[0] !=
                      1 &&
                      sampleSize[0] ==
                      4 &&
                      sampleSize[0] !=
                      8) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder2");
                }
                break;
            case java.awt.image.DataBuffer.
                   TYPE_SHORT:
            case java.awt.image.DataBuffer.
                   TYPE_USHORT:
                if (sampleSize[0] !=
                      16) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder3");
                }
                break;
            case java.awt.image.DataBuffer.
                   TYPE_INT:
            case java.awt.image.DataBuffer.
                   TYPE_FLOAT:
                if (sampleSize[0] !=
                      32) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder4");
                }
                break;
            default:
                throw new java.lang.Error(
                  "TIFFImageEncoder5");
        }
        boolean dataTypeIsShort =
          dataType ==
          java.awt.image.DataBuffer.
            TYPE_SHORT ||
          dataType ==
          java.awt.image.DataBuffer.
            TYPE_USHORT;
        java.awt.image.ColorModel colorModel =
          im.
          getColorModel(
            );
        if (colorModel !=
              null &&
              colorModel instanceof java.awt.image.IndexColorModel &&
              dataType !=
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            throw new java.lang.Error(
              "TIFFImageEncoder6");
        }
        java.awt.image.IndexColorModel icm =
          null;
        int sizeOfColormap =
          0;
        char[] colormap =
          null;
        int imageType =
          TIFF_UNSUPPORTED;
        int numExtraSamples =
          0;
        int extraSampleType =
          EXTRA_SAMPLE_UNSPECIFIED;
        if (colorModel instanceof java.awt.image.IndexColorModel) {
            icm =
              (java.awt.image.IndexColorModel)
                colorModel;
            int mapSize =
              icm.
              getMapSize(
                );
            if (sampleSize[0] ==
                  1 &&
                  numBands ==
                  1) {
                if (mapSize !=
                      2) {
                    throw new java.lang.IllegalArgumentException(
                      "TIFFImageEncoder7");
                }
                byte[] r =
                  new byte[mapSize];
                icm.
                  getReds(
                    r);
                byte[] g =
                  new byte[mapSize];
                icm.
                  getGreens(
                    g);
                byte[] b =
                  new byte[mapSize];
                icm.
                  getBlues(
                    b);
                if ((r[0] &
                       255) ==
                      0 &&
                      (r[1] &
                         255) ==
                      255 &&
                      (g[0] &
                         255) ==
                      0 &&
                      (g[1] &
                         255) ==
                      255 &&
                      (b[0] &
                         255) ==
                      0 &&
                      (b[1] &
                         255) ==
                      255) {
                    imageType =
                      TIFF_BILEVEL_BLACK_IS_ZERO;
                }
                else
                    if ((r[0] &
                           255) ==
                          255 &&
                          (r[1] &
                             255) ==
                          0 &&
                          (g[0] &
                             255) ==
                          255 &&
                          (g[1] &
                             255) ==
                          0 &&
                          (b[0] &
                             255) ==
                          255 &&
                          (b[1] &
                             255) ==
                          0) {
                        imageType =
                          TIFF_BILEVEL_WHITE_IS_ZERO;
                    }
                    else {
                        imageType =
                          TIFF_PALETTE;
                    }
            }
            else
                if (numBands ==
                      1) {
                    imageType =
                      TIFF_PALETTE;
                }
        }
        else
            if (colorModel ==
                  null) {
                if (sampleSize[0] ==
                      1 &&
                      numBands ==
                      1) {
                    imageType =
                      TIFF_BILEVEL_BLACK_IS_ZERO;
                }
                else {
                    imageType =
                      TIFF_GENERIC;
                    if (numBands >
                          1) {
                        numExtraSamples =
                          numBands -
                            1;
                    }
                }
            }
            else {
                java.awt.color.ColorSpace colorSpace =
                  colorModel.
                  getColorSpace(
                    );
                switch (colorSpace.
                          getType(
                            )) {
                    case java.awt.color.ColorSpace.
                           TYPE_CMYK:
                        imageType =
                          TIFF_CMYK;
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_GRAY:
                        imageType =
                          TIFF_GRAY;
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_Lab:
                        imageType =
                          TIFF_CIELAB;
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_RGB:
                        if (compression ==
                              COMP_JPEG_TTN2 &&
                              encodeParam.
                              getJPEGCompressRGBToYCbCr(
                                )) {
                            imageType =
                              TIFF_YCBCR;
                        }
                        else {
                            imageType =
                              TIFF_RGB;
                        }
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_YCbCr:
                        imageType =
                          TIFF_YCBCR;
                        break;
                    default:
                        imageType =
                          TIFF_GENERIC;
                        break;
                }
                if (imageType ==
                      TIFF_GENERIC) {
                    numExtraSamples =
                      numBands -
                        1;
                }
                else
                    if (numBands >
                          1) {
                        numExtraSamples =
                          numBands -
                            colorSpace.
                            getNumComponents(
                              );
                    }
                if (numExtraSamples ==
                      1 &&
                      colorModel.
                      hasAlpha(
                        )) {
                    extraSampleType =
                      colorModel.
                        isAlphaPremultiplied(
                          )
                        ? EXTRA_SAMPLE_ASSOCIATED_ALPHA
                        : EXTRA_SAMPLE_UNASSOCIATED_ALPHA;
                }
            }
        if (imageType ==
              TIFF_UNSUPPORTED) {
            throw new java.lang.Error(
              "TIFFImageEncoder8");
        }
        if (compression ==
              COMP_JPEG_TTN2) {
            if (imageType ==
                  TIFF_PALETTE) {
                throw new java.lang.Error(
                  "TIFFImageEncoder11");
            }
            else
                if (!(sampleSize[0] ==
                        8 &&
                        (imageType ==
                           TIFF_GRAY ||
                           imageType ==
                           TIFF_RGB ||
                           imageType ==
                           TIFF_YCBCR))) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder9");
                }
        }
        int photometricInterpretation =
          -1;
        switch (imageType) {
            case TIFF_BILEVEL_WHITE_IS_ZERO:
                photometricInterpretation =
                  0;
                break;
            case TIFF_BILEVEL_BLACK_IS_ZERO:
                photometricInterpretation =
                  1;
                break;
            case TIFF_GRAY:
            case TIFF_GENERIC:
                photometricInterpretation =
                  1;
                break;
            case TIFF_PALETTE:
                photometricInterpretation =
                  3;
                icm =
                  (java.awt.image.IndexColorModel)
                    colorModel;
                sizeOfColormap =
                  icm.
                    getMapSize(
                      );
                byte[] r =
                  new byte[sizeOfColormap];
                icm.
                  getReds(
                    r);
                byte[] g =
                  new byte[sizeOfColormap];
                icm.
                  getGreens(
                    g);
                byte[] b =
                  new byte[sizeOfColormap];
                icm.
                  getBlues(
                    b);
                int redIndex =
                  0;
                int greenIndex =
                  sizeOfColormap;
                int blueIndex =
                  2 *
                  sizeOfColormap;
                colormap =
                  (new char[sizeOfColormap *
                              3]);
                for (int i =
                       0;
                     i <
                       sizeOfColormap;
                     i++) {
                    int tmp =
                      255 &
                      r[i];
                    colormap[redIndex++] =
                      (char)
                        (tmp <<
                           8 |
                           tmp);
                    tmp =
                      255 &
                        g[i];
                    colormap[greenIndex++] =
                      (char)
                        (tmp <<
                           8 |
                           tmp);
                    tmp =
                      255 &
                        b[i];
                    colormap[blueIndex++] =
                      (char)
                        (tmp <<
                           8 |
                           tmp);
                }
                sizeOfColormap *=
                  3;
                break;
            case TIFF_RGB:
                photometricInterpretation =
                  2;
                break;
            case TIFF_CMYK:
                photometricInterpretation =
                  5;
                break;
            case TIFF_YCBCR:
                photometricInterpretation =
                  6;
                break;
            case TIFF_CIELAB:
                photometricInterpretation =
                  8;
                break;
            default:
                throw new java.lang.Error(
                  "TIFFImageEncoder8");
        }
        int tileWidth;
        int tileHeight;
        if (isTiled) {
            tileWidth =
              encodeParam.
                getTileWidth(
                  ) >
                0
                ? encodeParam.
                getTileWidth(
                  )
                : im.
                getTileWidth(
                  );
            tileHeight =
              encodeParam.
                getTileHeight(
                  ) >
                0
                ? encodeParam.
                getTileHeight(
                  )
                : im.
                getTileHeight(
                  );
        }
        else {
            tileWidth =
              width;
            tileHeight =
              encodeParam.
                getTileHeight(
                  ) >
                0
                ? encodeParam.
                getTileHeight(
                  )
                : DEFAULT_ROWS_PER_STRIP;
        }
        com.sun.image.codec.jpeg.JPEGEncodeParam jep =
          null;
        if (compression ==
              COMP_JPEG_TTN2) {
            jep =
              encodeParam.
                getJPEGEncodeParam(
                  );
            int maxSubH =
              jep.
              getHorizontalSubsampling(
                0);
            int maxSubV =
              jep.
              getVerticalSubsampling(
                0);
            for (int i =
                   1;
                 i <
                   numBands;
                 i++) {
                int subH =
                  jep.
                  getHorizontalSubsampling(
                    i);
                if (subH >
                      maxSubH) {
                    maxSubH =
                      subH;
                }
                int subV =
                  jep.
                  getVerticalSubsampling(
                    i);
                if (subV >
                      maxSubV) {
                    maxSubV =
                      subV;
                }
            }
            int factorV =
              8 *
              maxSubV;
            tileHeight =
              (int)
                ((float)
                   tileHeight /
                   (float)
                     factorV +
                   0.5F) *
                factorV;
            if (tileHeight <
                  factorV) {
                tileHeight =
                  factorV;
            }
            if (isTiled) {
                int factorH =
                  8 *
                  maxSubH;
                tileWidth =
                  (int)
                    ((float)
                       tileWidth /
                       (float)
                         factorH +
                       0.5F) *
                    factorH;
                if (tileWidth <
                      factorH) {
                    tileWidth =
                      factorH;
                }
            }
        }
        int numTiles;
        if (isTiled) {
            numTiles =
              (width +
                 tileWidth -
                 1) /
                tileWidth *
                ((height +
                    tileHeight -
                    1) /
                   tileHeight);
        }
        else {
            numTiles =
              (int)
                java.lang.Math.
                ceil(
                  (double)
                    height /
                    (double)
                      tileHeight);
        }
        long[] tileByteCounts =
          new long[numTiles];
        long bytesPerRow =
          (long)
            java.lang.Math.
            ceil(
              sampleSize[0] /
                8.0 *
                tileWidth *
                numBands);
        long bytesPerTile =
          bytesPerRow *
          tileHeight;
        for (int i =
               0;
             i <
               numTiles;
             i++) {
            tileByteCounts[i] =
              bytesPerTile;
        }
        if (!isTiled) {
            long lastStripRows =
              height -
              tileHeight *
              (numTiles -
                 1);
            tileByteCounts[numTiles -
                             1] =
              lastStripRows *
                bytesPerRow;
        }
        long totalBytesOfData =
          bytesPerTile *
          (numTiles -
             1) +
          tileByteCounts[numTiles -
                           1];
        long[] tileOffsets =
          new long[numTiles];
        java.util.SortedSet fields =
          new java.util.TreeSet(
          );
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_WIDTH,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_LONG,
              1,
              new long[] { width }));
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_LENGTH,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_LONG,
              1,
              new long[] { height }));
        char[] shortSampleSize =
          new char[numBands];
        for (int i =
               0;
             i <
               numBands;
             i++)
            shortSampleSize[i] =
              (char)
                sampleSize[i];
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_BITS_PER_SAMPLE,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              numBands,
              shortSampleSize));
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_COMPRESSION,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              1,
              new char[] { (char)
                             compression }));
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_PHOTOMETRIC_INTERPRETATION,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              1,
              new char[] { (char)
                             photometricInterpretation }));
        if (!isTiled) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_STRIP_OFFSETS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileOffsets));
        }
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_SAMPLES_PER_PIXEL,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              1,
              new char[] { (char)
                             numBands }));
        if (!isTiled) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_ROWS_PER_STRIP,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  1,
                  new long[] { tileHeight }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_STRIP_BYTE_COUNTS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileByteCounts));
        }
        if (colormap !=
              null) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_COLORMAP,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  sizeOfColormap,
                  colormap));
        }
        if (isTiled) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_WIDTH,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  1,
                  new long[] { tileWidth }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_LENGTH,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  1,
                  new long[] { tileHeight }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_OFFSETS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileOffsets));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_BYTE_COUNTS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileByteCounts));
        }
        if (numExtraSamples >
              0) {
            char[] extraSamples =
              new char[numExtraSamples];
            for (int i =
                   0;
                 i <
                   numExtraSamples;
                 i++) {
                extraSamples[i] =
                  (char)
                    extraSampleType;
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_EXTRA_SAMPLES,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  numExtraSamples,
                  extraSamples));
        }
        if (dataType !=
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            char[] sampleFormat =
              new char[numBands];
            if (dataType ==
                  java.awt.image.DataBuffer.
                    TYPE_FLOAT) {
                sampleFormat[0] =
                  3;
            }
            else
                if (dataType ==
                      java.awt.image.DataBuffer.
                        TYPE_USHORT) {
                    sampleFormat[0] =
                      1;
                }
                else {
                    sampleFormat[0] =
                      2;
                }
            for (int b =
                   1;
                 b <
                   numBands;
                 b++) {
                sampleFormat[b] =
                  sampleFormat[0];
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_SAMPLE_FORMAT,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  numBands,
                  sampleFormat));
        }
        com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam =
          null;
        com.sun.image.codec.jpeg.JPEGImageEncoder jpegEncoder =
          null;
        int jpegColorID =
          0;
        if (compression ==
              COMP_JPEG_TTN2) {
            jpegColorID =
              com.sun.image.codec.jpeg.JPEGDecodeParam.
                COLOR_ID_UNKNOWN;
            switch (imageType) {
                case TIFF_GRAY:
                case TIFF_PALETTE:
                    jpegColorID =
                      com.sun.image.codec.jpeg.JPEGDecodeParam.
                        COLOR_ID_GRAY;
                    break;
                case TIFF_RGB:
                    jpegColorID =
                      com.sun.image.codec.jpeg.JPEGDecodeParam.
                        COLOR_ID_RGB;
                    break;
                case TIFF_YCBCR:
                    jpegColorID =
                      com.sun.image.codec.jpeg.JPEGDecodeParam.
                        COLOR_ID_YCbCr;
                    break;
            }
            java.awt.image.Raster tile00 =
              im.
              getTile(
                0,
                0);
            jpegEncodeParam =
              com.sun.image.codec.jpeg.JPEGCodec.
                getDefaultJPEGEncodeParam(
                  tile00,
                  jpegColorID);
            modifyEncodeParam(
              jep,
              jpegEncodeParam,
              numBands);
            jpegEncodeParam.
              setImageInfoValid(
                false);
            jpegEncodeParam.
              setTableInfoValid(
                true);
            java.io.ByteArrayOutputStream tableStream =
              new java.io.ByteArrayOutputStream(
              );
            jpegEncoder =
              com.sun.image.codec.jpeg.JPEGCodec.
                createJPEGEncoder(
                  tableStream,
                  jpegEncodeParam);
            jpegEncoder.
              encode(
                tile00);
            byte[] tableData =
              tableStream.
              toByteArray(
                );
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_JPEG_TABLES,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_UNDEFINED,
                  tableData.
                    length,
                  tableData));
            jpegEncoder =
              null;
        }
        if (imageType ==
              TIFF_YCBCR) {
            char subsampleH =
              1;
            char subsampleV =
              1;
            if (compression ==
                  COMP_JPEG_TTN2) {
                subsampleH =
                  (char)
                    jep.
                    getHorizontalSubsampling(
                      0);
                subsampleV =
                  (char)
                    jep.
                    getVerticalSubsampling(
                      0);
                for (int i =
                       1;
                     i <
                       numBands;
                     i++) {
                    char subH =
                      (char)
                        jep.
                        getHorizontalSubsampling(
                          i);
                    if (subH >
                          subsampleH) {
                        subsampleH =
                          subH;
                    }
                    char subV =
                      (char)
                        jep.
                        getVerticalSubsampling(
                          i);
                    if (subV >
                          subsampleV) {
                        subsampleV =
                          subV;
                    }
                }
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_YCBCR_SUBSAMPLING,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  2,
                  new char[] { subsampleH,
                  subsampleV }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_YCBCR_POSITIONING,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  1,
                  new char[] { (char)
                                 (compression ==
                                    COMP_JPEG_TTN2
                                    ? 1
                                    : 2) }));
            long[][] refbw;
            if (compression ==
                  COMP_JPEG_TTN2) {
                refbw =
                  (new long[][] { { 0,
                   1 },
                   { 255,
                   1 },
                   { 128,
                   1 },
                   { 255,
                   1 },
                   { 128,
                   1 },
                   { 255,
                   1 } });
            }
            else {
                refbw =
                  (new long[][] { { 15,
                   1 },
                   { 235,
                   1 },
                   { 128,
                   1 },
                   { 240,
                   1 },
                   { 128,
                   1 },
                   { 240,
                   1 } });
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_REF_BLACK_WHITE,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_RATIONAL,
                  6,
                  refbw));
        }
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] extraFields =
          encodeParam.
          getExtraFields(
            );
        if (extraFields !=
              null) {
            java.util.List extantTags =
              new java.util.ArrayList(
              fields.
                size(
                  ));
            java.util.Iterator fieldIter =
              fields.
              iterator(
                );
            while (fieldIter.
                     hasNext(
                       )) {
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField fld =
                  (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                    fieldIter.
                    next(
                      );
                extantTags.
                  add(
                    new java.lang.Integer(
                      fld.
                        getTag(
                          )));
            }
            int numExtraFields =
              extraFields.
                length;
            for (int i =
                   0;
                 i <
                   numExtraFields;
                 i++) {
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField fld =
                  extraFields[i];
                java.lang.Integer tagValue =
                  new java.lang.Integer(
                  fld.
                    getTag(
                      ));
                if (!extantTags.
                      contains(
                        tagValue)) {
                    fields.
                      add(
                        fld);
                    extantTags.
                      add(
                        tagValue);
                }
            }
        }
        int dirSize =
          getDirectorySize(
            fields);
        tileOffsets[0] =
          ifdOffset +
            dirSize;
        java.io.OutputStream outCache =
          null;
        byte[] compressBuf =
          null;
        java.io.File tempFile =
          null;
        int nextIFDOffset =
          0;
        boolean skipByte =
          false;
        java.util.zip.Deflater deflater =
          null;
        boolean jpegRGBToYCbCr =
          false;
        if (compression ==
              COMP_NONE) {
            int numBytesPadding =
              0;
            if (sampleSize[0] ==
                  16 &&
                  tileOffsets[0] %
                  2 !=
                  0) {
                numBytesPadding =
                  1;
                tileOffsets[0]++;
            }
            else
                if (sampleSize[0] ==
                      32 &&
                      tileOffsets[0] %
                      4 !=
                      0) {
                    numBytesPadding =
                      (int)
                        (4 -
                           tileOffsets[0] %
                           4);
                    tileOffsets[0] +=
                      numBytesPadding;
                }
            for (int i =
                   1;
                 i <
                   numTiles;
                 i++) {
                tileOffsets[i] =
                  tileOffsets[i -
                                1] +
                    tileByteCounts[i -
                                     1];
            }
            if (!isLast) {
                nextIFDOffset =
                  (int)
                    (tileOffsets[0] +
                       totalBytesOfData);
                if ((nextIFDOffset &
                       1) !=
                      0) {
                    nextIFDOffset++;
                    skipByte =
                      true;
                }
            }
            writeDirectory(
              ifdOffset,
              fields,
              nextIFDOffset);
            if (numBytesPadding !=
                  0) {
                for (int padding =
                       0;
                     padding <
                       numBytesPadding;
                     padding++) {
                    output.
                      write(
                        (byte)
                          0);
                }
            }
        }
        else {
            if (output instanceof org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream) {
                ((org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream)
                   output).
                  seek(
                    tileOffsets[0]);
            }
            else {
                outCache =
                  output;
                try {
                    tempFile =
                      java.io.File.
                        createTempFile(
                          "jai-SOS-",
                          ".tmp");
                    tempFile.
                      deleteOnExit(
                        );
                    java.io.RandomAccessFile raFile =
                      new java.io.RandomAccessFile(
                      tempFile,
                      "rw");
                    output =
                      new org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream(
                        raFile);
                }
                catch (java.lang.Exception e) {
                    output =
                      new java.io.ByteArrayOutputStream(
                        (int)
                          totalBytesOfData);
                }
            }
            int bufSize =
              0;
            switch (compression) {
                case COMP_PACKBITS:
                    bufSize =
                      (int)
                        (bytesPerTile +
                           (bytesPerRow +
                              127) /
                           128 *
                           tileHeight);
                    break;
                case COMP_JPEG_TTN2:
                    bufSize =
                      0;
                    if (imageType ==
                          TIFF_YCBCR &&
                          colorModel !=
                          null &&
                          colorModel.
                          getColorSpace(
                            ).
                          getType(
                            ) ==
                          java.awt.color.ColorSpace.
                            TYPE_RGB) {
                        jpegRGBToYCbCr =
                          true;
                    }
                    break;
                case COMP_DEFLATE:
                    bufSize =
                      (int)
                        bytesPerTile;
                    deflater =
                      new java.util.zip.Deflater(
                        encodeParam.
                          getDeflateLevel(
                            ));
                    break;
                default:
                    bufSize =
                      0;
            }
            if (bufSize !=
                  0) {
                compressBuf =
                  (new byte[bufSize]);
            }
        }
        int[] pixels =
          null;
        float[] fpixels =
          null;
        boolean checkContiguous =
          sampleSize[0] ==
          1 &&
          sampleModel instanceof java.awt.image.MultiPixelPackedSampleModel &&
          dataType ==
          java.awt.image.DataBuffer.
            TYPE_BYTE ||
          sampleSize[0] ==
          8 &&
          sampleModel instanceof java.awt.image.ComponentSampleModel;
        byte[] bpixels =
          null;
        if (compression !=
              COMP_JPEG_TTN2) {
            if (dataType ==
                  java.awt.image.DataBuffer.
                    TYPE_BYTE) {
                bpixels =
                  (new byte[tileHeight *
                              tileWidth *
                              numBands]);
            }
            else
                if (dataTypeIsShort) {
                    bpixels =
                      (new byte[2 *
                                  tileHeight *
                                  tileWidth *
                                  numBands]);
                }
                else
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_INT ||
                          dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_FLOAT) {
                        bpixels =
                          (new byte[4 *
                                      tileHeight *
                                      tileWidth *
                                      numBands]);
                    }
        }
        int lastRow =
          minY +
          height;
        int lastCol =
          minX +
          width;
        int tileNum =
          0;
        for (int row =
               minY;
             row <
               lastRow;
             row +=
               tileHeight) {
            int rows =
              isTiled
              ? tileHeight
              : java.lang.Math.
              min(
                tileHeight,
                lastRow -
                  row);
            int size =
              rows *
              tileWidth *
              numBands;
            for (int col =
                   minX;
                 col <
                   lastCol;
                 col +=
                   tileWidth) {
                java.awt.image.Raster src =
                  im.
                  getData(
                    new java.awt.Rectangle(
                      col,
                      row,
                      tileWidth,
                      rows));
                boolean useDataBuffer =
                  false;
                if (compression !=
                      COMP_JPEG_TTN2) {
                    if (checkContiguous) {
                        if (sampleSize[0] ==
                              8) {
                            java.awt.image.ComponentSampleModel csm =
                              (java.awt.image.ComponentSampleModel)
                                src.
                                getSampleModel(
                                  );
                            int[] bankIndices =
                              csm.
                              getBankIndices(
                                );
                            int[] bandOffsets =
                              csm.
                              getBandOffsets(
                                );
                            int pixelStride =
                              csm.
                              getPixelStride(
                                );
                            int lineStride =
                              csm.
                              getScanlineStride(
                                );
                            if (pixelStride !=
                                  numBands ||
                                  lineStride !=
                                  bytesPerRow) {
                                useDataBuffer =
                                  false;
                            }
                            else {
                                useDataBuffer =
                                  true;
                                for (int i =
                                       0;
                                     useDataBuffer &&
                                       i <
                                       numBands;
                                     i++) {
                                    if (bankIndices[i] !=
                                          0 ||
                                          bandOffsets[i] !=
                                          i) {
                                        useDataBuffer =
                                          false;
                                    }
                                }
                            }
                        }
                        else {
                            java.awt.image.MultiPixelPackedSampleModel mpp =
                              (java.awt.image.MultiPixelPackedSampleModel)
                                src.
                                getSampleModel(
                                  );
                            if (mpp.
                                  getNumBands(
                                    ) ==
                                  1 &&
                                  mpp.
                                  getDataBitOffset(
                                    ) ==
                                  0 &&
                                  mpp.
                                  getPixelBitStride(
                                    ) ==
                                  1) {
                                useDataBuffer =
                                  true;
                            }
                        }
                    }
                    if (!useDataBuffer) {
                        if (dataType ==
                              java.awt.image.DataBuffer.
                                TYPE_FLOAT) {
                            fpixels =
                              src.
                                getPixels(
                                  col,
                                  row,
                                  tileWidth,
                                  rows,
                                  fpixels);
                        }
                        else {
                            pixels =
                              src.
                                getPixels(
                                  col,
                                  row,
                                  tileWidth,
                                  rows,
                                  pixels);
                        }
                    }
                }
                int index;
                int pixel =
                  0;
                int k =
                  0;
                switch (sampleSize[0]) {
                    case 1:
                        if (useDataBuffer) {
                            byte[] btmp =
                              ((java.awt.image.DataBufferByte)
                                 src.
                                 getDataBuffer(
                                   )).
                              getData(
                                );
                            java.awt.image.MultiPixelPackedSampleModel mpp =
                              (java.awt.image.MultiPixelPackedSampleModel)
                                src.
                                getSampleModel(
                                  );
                            int lineStride =
                              mpp.
                              getScanlineStride(
                                );
                            int inOffset =
                              mpp.
                              getOffset(
                                col -
                                  src.
                                  getSampleModelTranslateX(
                                    ),
                                row -
                                  src.
                                  getSampleModelTranslateY(
                                    ));
                            if (lineStride ==
                                  (int)
                                    bytesPerRow) {
                                java.lang.System.
                                  arraycopy(
                                    btmp,
                                    inOffset,
                                    bpixels,
                                    0,
                                    (int)
                                      bytesPerRow *
                                      rows);
                            }
                            else {
                                int outOffset =
                                  0;
                                for (int j =
                                       0;
                                     j <
                                       rows;
                                     j++) {
                                    java.lang.System.
                                      arraycopy(
                                        btmp,
                                        inOffset,
                                        bpixels,
                                        outOffset,
                                        (int)
                                          bytesPerRow);
                                    inOffset +=
                                      lineStride;
                                    outOffset +=
                                      (int)
                                        bytesPerRow;
                                }
                            }
                        }
                        else {
                            index =
                              0;
                            for (int i =
                                   0;
                                 i <
                                   rows;
                                 i++) {
                                for (int j =
                                       0;
                                     j <
                                       tileWidth /
                                       8;
                                     j++) {
                                    pixel =
                                      pixels[index++] <<
                                        7 |
                                        pixels[index++] <<
                                        6 |
                                        pixels[index++] <<
                                        5 |
                                        pixels[index++] <<
                                        4 |
                                        pixels[index++] <<
                                        3 |
                                        pixels[index++] <<
                                        2 |
                                        pixels[index++] <<
                                        1 |
                                        pixels[index++];
                                    bpixels[k++] =
                                      (byte)
                                        pixel;
                                }
                                if (tileWidth %
                                      8 >
                                      0) {
                                    pixel =
                                      0;
                                    for (int j =
                                           0;
                                         j <
                                           tileWidth %
                                           8;
                                         j++) {
                                        pixel |=
                                          pixels[index++] <<
                                            7 -
                                            j;
                                    }
                                    bpixels[k++] =
                                      (byte)
                                        pixel;
                                }
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                rows *
                                  ((tileWidth +
                                      7) /
                                     8));
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                    case 4:
                        index =
                          0;
                        for (int i =
                               0;
                             i <
                               rows;
                             i++) {
                            for (int j =
                                   0;
                                 j <
                                   tileWidth /
                                   2;
                                 j++) {
                                pixel =
                                  pixels[index++] <<
                                    4 |
                                    pixels[index++];
                                bpixels[k++] =
                                  (byte)
                                    pixel;
                            }
                            if ((tileWidth &
                                   1) ==
                                  1) {
                                pixel =
                                  pixels[index++] <<
                                    4;
                                bpixels[k++] =
                                  (byte)
                                    pixel;
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                rows *
                                  ((tileWidth +
                                      1) /
                                     2));
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                    case 8:
                        if (compression !=
                              COMP_JPEG_TTN2) {
                            if (useDataBuffer) {
                                byte[] btmp =
                                  ((java.awt.image.DataBufferByte)
                                     src.
                                     getDataBuffer(
                                       )).
                                  getData(
                                    );
                                java.awt.image.ComponentSampleModel csm =
                                  (java.awt.image.ComponentSampleModel)
                                    src.
                                    getSampleModel(
                                      );
                                int inOffset =
                                  csm.
                                  getOffset(
                                    col -
                                      src.
                                      getSampleModelTranslateX(
                                        ),
                                    row -
                                      src.
                                      getSampleModelTranslateY(
                                        ));
                                int lineStride =
                                  csm.
                                  getScanlineStride(
                                    );
                                if (lineStride ==
                                      (int)
                                        bytesPerRow) {
                                    java.lang.System.
                                      arraycopy(
                                        btmp,
                                        inOffset,
                                        bpixels,
                                        0,
                                        (int)
                                          bytesPerRow *
                                          rows);
                                }
                                else {
                                    int outOffset =
                                      0;
                                    for (int j =
                                           0;
                                         j <
                                           rows;
                                         j++) {
                                        java.lang.System.
                                          arraycopy(
                                            btmp,
                                            inOffset,
                                            bpixels,
                                            outOffset,
                                            (int)
                                              bytesPerRow);
                                        inOffset +=
                                          lineStride;
                                        outOffset +=
                                          (int)
                                            bytesPerRow;
                                    }
                                }
                            }
                            else {
                                for (int i =
                                       0;
                                     i <
                                       size;
                                     i++) {
                                    bpixels[i] =
                                      (byte)
                                        pixels[i];
                                }
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                size);
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_JPEG_TTN2) {
                                    long startPos =
                                      getOffset(
                                        output);
                                    if (jpegEncoder ==
                                          null ||
                                          jpegEncodeParam.
                                          getWidth(
                                            ) !=
                                          src.
                                          getWidth(
                                            ) ||
                                          jpegEncodeParam.
                                          getHeight(
                                            ) !=
                                          src.
                                          getHeight(
                                            )) {
                                        jpegEncodeParam =
                                          com.sun.image.codec.jpeg.JPEGCodec.
                                            getDefaultJPEGEncodeParam(
                                              src,
                                              jpegColorID);
                                        modifyEncodeParam(
                                          jep,
                                          jpegEncodeParam,
                                          numBands);
                                        jpegEncoder =
                                          com.sun.image.codec.jpeg.JPEGCodec.
                                            createJPEGEncoder(
                                              output,
                                              jpegEncodeParam);
                                    }
                                    if (jpegRGBToYCbCr) {
                                        java.awt.image.WritableRaster wRas =
                                          null;
                                        if (src instanceof java.awt.image.WritableRaster) {
                                            wRas =
                                              (java.awt.image.WritableRaster)
                                                src;
                                        }
                                        else {
                                            wRas =
                                              src.
                                                createCompatibleWritableRaster(
                                                  );
                                            wRas.
                                              setRect(
                                                src);
                                        }
                                        if (wRas.
                                              getMinX(
                                                ) !=
                                              0 ||
                                              wRas.
                                              getMinY(
                                                ) !=
                                              0) {
                                            wRas =
                                              wRas.
                                                createWritableTranslatedChild(
                                                  0,
                                                  0);
                                        }
                                        java.awt.image.BufferedImage bi =
                                          new java.awt.image.BufferedImage(
                                          colorModel,
                                          wRas,
                                          false,
                                          null);
                                        jpegEncoder.
                                          encode(
                                            bi);
                                    }
                                    else {
                                        jpegEncoder.
                                          encode(
                                            src.
                                              createTranslatedChild(
                                                0,
                                                0));
                                    }
                                    long endPos =
                                      getOffset(
                                        output);
                                    tileByteCounts[tileNum++] =
                                      (int)
                                        (endPos -
                                           startPos);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        int numCompressedBytes =
                                          deflate(
                                            deflater,
                                            bpixels,
                                            compressBuf);
                                        tileByteCounts[tileNum++] =
                                          numCompressedBytes;
                                        output.
                                          write(
                                            compressBuf,
                                            0,
                                            numCompressedBytes);
                                    }
                        break;
                    case 16:
                        int ls =
                          0;
                        for (int i =
                               0;
                             i <
                               size;
                             i++) {
                            int value =
                              pixels[i];
                            bpixels[ls++] =
                              (byte)
                                ((value &
                                    65280) >>
                                   8);
                            bpixels[ls++] =
                              (byte)
                                (value &
                                   255);
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                size *
                                  2);
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                    case 32:
                        if (dataType ==
                              java.awt.image.DataBuffer.
                                TYPE_INT) {
                            int li =
                              0;
                            for (int i =
                                   0;
                                 i <
                                   size;
                                 i++) {
                                int value =
                                  pixels[i];
                                bpixels[li++] =
                                  (byte)
                                    ((value &
                                        -16777216) >>>
                                       24);
                                bpixels[li++] =
                                  (byte)
                                    ((value &
                                        16711680) >>>
                                       16);
                                bpixels[li++] =
                                  (byte)
                                    ((value &
                                        65280) >>>
                                       8);
                                bpixels[li++] =
                                  (byte)
                                    (value &
                                       255);
                            }
                        }
                        else {
                            int lf =
                              0;
                            for (int i =
                                   0;
                                 i <
                                   size;
                                 i++) {
                                int value =
                                  java.lang.Float.
                                  floatToIntBits(
                                    fpixels[i]);
                                bpixels[lf++] =
                                  (byte)
                                    ((value &
                                        -16777216) >>>
                                       24);
                                bpixels[lf++] =
                                  (byte)
                                    ((value &
                                        16711680) >>>
                                       16);
                                bpixels[lf++] =
                                  (byte)
                                    ((value &
                                        65280) >>>
                                       8);
                                bpixels[lf++] =
                                  (byte)
                                    (value &
                                       255);
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                size *
                                  4);
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                }
            }
        }
        if (compression ==
              COMP_NONE) {
            if (skipByte) {
                output.
                  write(
                    (byte)
                      0);
            }
        }
        else {
            int totalBytes =
              0;
            for (int i =
                   1;
                 i <
                   numTiles;
                 i++) {
                int numBytes =
                  (int)
                    tileByteCounts[i -
                                     1];
                totalBytes +=
                  numBytes;
                tileOffsets[i] =
                  tileOffsets[i -
                                1] +
                    numBytes;
            }
            totalBytes +=
              (int)
                tileByteCounts[numTiles -
                                 1];
            nextIFDOffset =
              isLast
                ? 0
                : ifdOffset +
                dirSize +
                totalBytes;
            if ((nextIFDOffset &
                   1) !=
                  0) {
                nextIFDOffset++;
                skipByte =
                  true;
            }
            if (outCache ==
                  null) {
                if (skipByte) {
                    output.
                      write(
                        (byte)
                          0);
                }
                org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream sos =
                  (org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream)
                    output;
                long savePos =
                  sos.
                  getFilePointer(
                    );
                sos.
                  seek(
                    ifdOffset);
                writeDirectory(
                  ifdOffset,
                  fields,
                  nextIFDOffset);
                sos.
                  seek(
                    savePos);
            }
            else
                if (tempFile !=
                      null) {
                    java.io.FileInputStream fileStream =
                      new java.io.FileInputStream(
                      tempFile);
                    output.
                      close(
                        );
                    output =
                      outCache;
                    writeDirectory(
                      ifdOffset,
                      fields,
                      nextIFDOffset);
                    byte[] copyBuffer =
                      new byte[8192];
                    int bytesCopied =
                      0;
                    while (bytesCopied <
                             totalBytes) {
                        int bytesRead =
                          fileStream.
                          read(
                            copyBuffer);
                        if (bytesRead ==
                              -1) {
                            break;
                        }
                        output.
                          write(
                            copyBuffer,
                            0,
                            bytesRead);
                        bytesCopied +=
                          bytesRead;
                    }
                    fileStream.
                      close(
                        );
                    tempFile.
                      delete(
                        );
                    if (skipByte) {
                        output.
                          write(
                            (byte)
                              0);
                    }
                }
                else
                    if (output instanceof java.io.ByteArrayOutputStream) {
                        java.io.ByteArrayOutputStream memoryStream =
                          (java.io.ByteArrayOutputStream)
                            output;
                        output =
                          outCache;
                        writeDirectory(
                          ifdOffset,
                          fields,
                          nextIFDOffset);
                        memoryStream.
                          writeTo(
                            output);
                        if (skipByte) {
                            output.
                              write(
                                (byte)
                                  0);
                        }
                    }
                    else {
                        throw new java.lang.IllegalStateException(
                          );
                    }
        }
        return nextIFDOffset;
    }
    private int getDirectorySize(java.util.SortedSet fields) {
        int numEntries =
          fields.
          size(
            );
        int dirSize =
          2 +
          numEntries *
          12 +
          4;
        java.util.Iterator iter =
          fields.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField field =
              (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                iter.
                next(
                  );
            int valueSize =
              field.
              getCount(
                ) *
              sizeOfType[field.
                           getType(
                             )];
            if (valueSize >
                  4) {
                dirSize +=
                  valueSize;
            }
        }
        return dirSize;
    }
    private void writeFileHeader() throws java.io.IOException {
        output.
          write(
            'M');
        output.
          write(
            'M');
        output.
          write(
            0);
        output.
          write(
            42);
        writeLong(
          8);
    }
    private void writeDirectory(int thisIFDOffset,
                                java.util.SortedSet fields,
                                int nextIFDOffset)
          throws java.io.IOException { int numEntries =
                                         fields.
                                         size(
                                           );
                                       long offsetBeyondIFD =
                                         thisIFDOffset +
                                         12 *
                                         numEntries +
                                         4 +
                                         2;
                                       java.util.List tooBig =
                                         new java.util.ArrayList(
                                         );
                                       writeUnsignedShort(
                                         numEntries);
                                       java.util.Iterator iter =
                                         fields.
                                         iterator(
                                           );
                                       while (iter.
                                                hasNext(
                                                  )) {
                                           org.apache.batik.ext.awt.image.codec.tiff.TIFFField field =
                                             (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                                               iter.
                                               next(
                                                 );
                                           int tag =
                                             field.
                                             getTag(
                                               );
                                           writeUnsignedShort(
                                             tag);
                                           int type =
                                             field.
                                             getType(
                                               );
                                           writeUnsignedShort(
                                             type);
                                           int count =
                                             field.
                                             getCount(
                                               );
                                           int valueSize =
                                             getValueSize(
                                               field);
                                           writeLong(
                                             type ==
                                               org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                 TIFF_ASCII
                                               ? valueSize
                                               : count);
                                           if (valueSize >
                                                 4) {
                                               writeLong(
                                                 offsetBeyondIFD);
                                               offsetBeyondIFD +=
                                                 valueSize;
                                               tooBig.
                                                 add(
                                                   field);
                                           }
                                           else {
                                               writeValuesAsFourBytes(
                                                 field);
                                           }
                                       }
                                       writeLong(
                                         nextIFDOffset);
                                       for (int i =
                                              0;
                                            i <
                                              tooBig.
                                              size(
                                                );
                                            i++) {
                                           writeValues(
                                             (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                                               tooBig.
                                               get(
                                                 i));
                                       } }
    private static int getValueSize(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field) {
        int type =
          field.
          getType(
            );
        int count =
          field.
          getCount(
            );
        int valueSize =
          0;
        if (type ==
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_ASCII) {
            for (int i =
                   0;
                 i <
                   count;
                 i++) {
                byte[] stringBytes =
                  field.
                  getAsString(
                    i).
                  getBytes(
                    );
                valueSize +=
                  stringBytes.
                    length;
                if (stringBytes[stringBytes.
                                  length -
                                  1] !=
                      0) {
                    valueSize++;
                }
            }
        }
        else {
            valueSize =
              count *
                sizeOfType[type];
        }
        return valueSize;
    }
    private static final int[] sizeOfType =
      { 0,
    1,
    1,
    2,
    4,
    8,
    1,
    1,
    2,
    4,
    8,
    4,
    8 };
    private void writeValuesAsFourBytes(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field)
          throws java.io.IOException { int dataType =
                                         field.
                                         getType(
                                           );
                                       int count =
                                         field.
                                         getCount(
                                           );
                                       switch (dataType) {
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_BYTE:
                                               byte[] bytes =
                                                 field.
                                                 getAsBytes(
                                                   );
                                               if (count >
                                                     4)
                                                   count =
                                                     4;
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++)
                                                   output.
                                                     write(
                                                       bytes[i]);
                                               for (int i =
                                                      0;
                                                    i <
                                                      4 -
                                                      count;
                                                    i++)
                                                   output.
                                                     write(
                                                       0);
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SHORT:
                                               char[] chars =
                                                 field.
                                                 getAsChars(
                                                   );
                                               if (count >
                                                     2)
                                                   count =
                                                     2;
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++)
                                                   writeUnsignedShort(
                                                     chars[i]);
                                               for (int i =
                                                      0;
                                                    i <
                                                      2 -
                                                      count;
                                                    i++)
                                                   writeUnsignedShort(
                                                     0);
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_LONG:
                                               long[] longs =
                                                 field.
                                                 getAsLongs(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeLong(
                                                     longs[i]);
                                               }
                                               break;
                                       } }
    private void writeValues(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field)
          throws java.io.IOException { int dataType =
                                         field.
                                         getType(
                                           );
                                       int count =
                                         field.
                                         getCount(
                                           );
                                       switch (dataType) {
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_BYTE:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SBYTE:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_UNDEFINED:
                                               byte[] bytes =
                                                 field.
                                                 getAsBytes(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   output.
                                                     write(
                                                       bytes[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SHORT:
                                               char[] chars =
                                                 field.
                                                 getAsChars(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeUnsignedShort(
                                                     chars[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SSHORT:
                                               short[] shorts =
                                                 field.
                                                 getAsShorts(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeUnsignedShort(
                                                     shorts[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_LONG:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SLONG:
                                               long[] longs =
                                                 field.
                                                 getAsLongs(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeLong(
                                                     longs[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_FLOAT:
                                               float[] floats =
                                                 field.
                                                 getAsFloats(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   int intBits =
                                                     java.lang.Float.
                                                     floatToIntBits(
                                                       floats[i]);
                                                   writeLong(
                                                     intBits);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_DOUBLE:
                                               double[] doubles =
                                                 field.
                                                 getAsDoubles(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   long longBits =
                                                     java.lang.Double.
                                                     doubleToLongBits(
                                                       doubles[i]);
                                                   writeLong(
                                                     longBits >>>
                                                       32);
                                                   writeLong(
                                                     longBits &
                                                       4294967295L);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_RATIONAL:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SRATIONAL:
                                               long[][] rationals =
                                                 field.
                                                 getAsRationals(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeLong(
                                                     rationals[i][0]);
                                                   writeLong(
                                                     rationals[i][1]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_ASCII:
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   byte[] stringBytes =
                                                     field.
                                                     getAsString(
                                                       i).
                                                     getBytes(
                                                       );
                                                   output.
                                                     write(
                                                       stringBytes);
                                                   if (stringBytes[stringBytes.
                                                                     length -
                                                                     1] !=
                                                         (byte)
                                                           0) {
                                                       output.
                                                         write(
                                                           (byte)
                                                             0);
                                                   }
                                               }
                                               break;
                                           default:
                                               throw new java.lang.Error(
                                                 "TIFFImageEncoder10");
                                       } }
    private void writeUnsignedShort(int s)
          throws java.io.IOException { output.
                                         write(
                                           (s &
                                              65280) >>>
                                             8);
                                       output.
                                         write(
                                           s &
                                             255);
    }
    private void writeLong(long l) throws java.io.IOException {
        output.
          write(
            (int)
              ((l &
                  -16777216) >>>
                 24));
        output.
          write(
            (int)
              ((l &
                  16711680) >>>
                 16));
        output.
          write(
            (int)
              ((l &
                  65280) >>>
                 8));
        output.
          write(
            (int)
              (l &
                 255));
    }
    private long getOffset(java.io.OutputStream out)
          throws java.io.IOException { if (out instanceof java.io.ByteArrayOutputStream) {
                                           return ((java.io.ByteArrayOutputStream)
                                                     out).
                                             size(
                                               );
                                       }
                                       else
                                           if (out instanceof org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream) {
                                               return ((org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream)
                                                         out).
                                                 getFilePointer(
                                                   );
                                           }
                                           else {
                                               throw new java.lang.IllegalStateException(
                                                 );
                                           }
    }
    private static int compressPackBits(byte[] data,
                                        int numRows,
                                        int bytesPerRow,
                                        byte[] compData) {
        int inOffset =
          0;
        int outOffset =
          0;
        for (int i =
               0;
             i <
               numRows;
             i++) {
            outOffset =
              packBits(
                data,
                inOffset,
                bytesPerRow,
                compData,
                outOffset);
            inOffset +=
              bytesPerRow;
        }
        return outOffset;
    }
    private static int packBits(byte[] input,
                                int inOffset,
                                int inCount,
                                byte[] output,
                                int outOffset) {
        int inMax =
          inOffset +
          inCount -
          1;
        int inMaxMinus1 =
          inMax -
          1;
        while (inOffset <=
                 inMax) {
            int run =
              1;
            byte replicate =
              input[inOffset];
            while (run <
                     127 &&
                     inOffset <
                     inMax &&
                     input[inOffset] ==
                     input[inOffset +
                             1]) {
                run++;
                inOffset++;
            }
            if (run >
                  1) {
                inOffset++;
                output[outOffset++] =
                  (byte)
                    -(run -
                        1);
                output[outOffset++] =
                  replicate;
            }
            run =
              0;
            int saveOffset =
              outOffset;
            while (run <
                     128 &&
                     (inOffset <
                        inMax &&
                        input[inOffset] !=
                        input[inOffset +
                                1] ||
                        inOffset <
                        inMaxMinus1 &&
                        input[inOffset] !=
                        input[inOffset +
                                2])) {
                run++;
                output[++outOffset] =
                  input[inOffset++];
            }
            if (run >
                  0) {
                output[saveOffset] =
                  (byte)
                    (run -
                       1);
                outOffset++;
            }
            if (inOffset ==
                  inMax) {
                if (run >
                      0 &&
                      run <
                      128) {
                    output[saveOffset]++;
                    output[outOffset++] =
                      input[inOffset++];
                }
                else {
                    output[outOffset++] =
                      (byte)
                        0;
                    output[outOffset++] =
                      input[inOffset++];
                }
            }
        }
        return outOffset;
    }
    private static int deflate(java.util.zip.Deflater deflater,
                               byte[] inflated,
                               byte[] deflated) {
        deflater.
          setInput(
            inflated);
        deflater.
          finish(
            );
        int numCompressedBytes =
          deflater.
          deflate(
            deflated);
        deflater.
          reset(
            );
        return numCompressedBytes;
    }
    private static void modifyEncodeParam(com.sun.image.codec.jpeg.JPEGEncodeParam src,
                                          com.sun.image.codec.jpeg.JPEGEncodeParam dst,
                                          int nbands) {
        dst.
          setDensityUnit(
            src.
              getDensityUnit(
                ));
        dst.
          setXDensity(
            src.
              getXDensity(
                ));
        dst.
          setYDensity(
            src.
              getYDensity(
                ));
        dst.
          setRestartInterval(
            src.
              getRestartInterval(
                ));
        for (int i =
               0;
             i <
               4;
             i++) {
            com.sun.image.codec.jpeg.JPEGQTable tbl =
              src.
              getQTable(
                i);
            if (tbl !=
                  null)
                dst.
                  setQTable(
                    i,
                    tbl);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0KSyEvE2pxNO1amp9TCcV32r7IDu1Rfi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Vt2uio2I1AXCVMgKcIariE9gUDzZNtezdTRdmjV4KsuDOr9KpyjqwgG+Kcfh" +
       "hJxRuA7jdcLG1flovR6rTr2FVbreoCzMs7kMdeRYRarVtFZbDhct26pVNsM6" +
       "FhshrzW77Vk2CdtaN8ySZlPjypSWikEd83SftmhIWpbR4YZaJurSFWspacgT" +
       "3uanaOLPIHSijginMtk6aKvTlVPTW8Vdzut2EmrRrRJ0pKoGxEUd2pwzKT+3" +
       "/LVGJR6TdjqGXp7R2Kw8WeOSqo9JVBksrUYbVdSOA3fKclhB1vFgbJQjyPAy" +
       "oYZ37EkQrja0h0vxoloW/ZBMap22Zmy7ZQpGtQU03NZSZRKvUcvs2Ry84PCF" +
       "WV8xG1KcKEjmUbQEL2AVfAAMWjrMzIabulRbM92kNtuq7VnHDTN1LQxXuEUO" +
       "zYQkY3bh1tKsuek1gqzP6opJTZuMIE8XG55x4g6SDLBk6TTny7TOj1ugb3Lr" +
       "tYvCaNRVW1pNmzjdirT1OItKZXzdXg6adZan22yLU2Wv6TvsmK0kUXcAOwgq" +
       "VL3GCN9kjRhvlSMlA3XDoSDSbjjnxYSyWIlsieCjBx43FeBuC2ltOVoakxY9" +
       "lDtjZLLklGSxrFqmv9zIwL02HAdTxUamDlZQ1gL6CYx5e+3JVQQJFXELvPtM" +
       "6psbl9xI9cCtetDckR1pEQYSbFa0crdSNr2yVuusZbWcNtYk1lEjR+LRbNRZ" +
       "TBEhbW1r9NDvDYIqVFO1DUGut5kxd2bUDNI6FRnPmtsOyYzFNAToQ7vZDtVm" +
       "WukyjcRd81uM4KXOplzrQjS3WWZ2ulTbNMnRHlXHUdobRuFAFExt5M/hDGtA" +
       "sbGqLsp1gwjro814kdq+y/a9qKWPteHCGusYPG2o66XT0KZ9mp4v8GplOIQX" +
       "ukJl1Uq1Lvkthm6vZWTRGo6J4QRzFlVgd7ojg6sM1K00XwwSWPUNjReXI9si" +
       "yj0WMOrHYmi1p/i0J28mTjzXcWJT76bZsD/sr0nd7iJNEpRlO4gReKZA9sxO" +
       "C9bH8ire1nptI3TSdbcxmJhhjVyLFdMy+GY4ZLWODklOs89WayjwNzqIRaPz" +
       "imTVuny4GoQVc6VMsTVbb1qbrhwSC3pQmYix22w1y7I9V1XN81cbt1lb8HFf" +
       "SDVf4tQJW+GNpM1ptT5V46dwjYNHgZvRwCo2cJ0N201drDedtkam68yQtGlN" +
       "5DPwTbNBkrFXqXRg3+2oeNPq2VijaqbV6TRKMyeZOfJqporTsLy2lxkn8VGG" +
       "Ao9oVBv75AqTyh5DGMqKMH2EqIXOtgox8zQwF0HDc4m5OY2mcGtpESIXrdau" +
       "sSLUUUOiF33QuDzdGPp2k/BgTG/6sFmGCJ2tZvQojPoDSuSWTn2Mh8Bjdbmg" +
       "tW4abkVaQ76/GFM4+KywoJ7o9NaZGHvlQbueMFZjsySnCdNBywPCkWGMHjCp" +
       "D+wQFyGrfp0GDp83xdH+wljMZ7qbluVqL9kY7grq4NUtj5I80hltuYaoGmqD" +
       "F7lFCG9ZS1IRfoFkFNGr2+kQwhzgjwwTOcS0edORqlGGZIQ/l2ZVl2/z8xFm" +
       "xAhkCho0U5cjhcHCZcWfgy9QtcnFsDPpTzKsGRuJPO+u9LQWmO2sXfdEFxqO" +
       "uvVmbcgZLN8yF4uGTdYtP/a1VhVrdxo2NOCotDYi+lxoAtcfE1RLnvbR+jCt" +
       "r1TPHa6rfX9YXmzcNGvP9f7U5mebiWsO2+qE9iyEIUfVOcxSM6beqzfLlAPV" +
       "EbLDw9JcoIA1SZxEXlibUKpgSq8sjfqdjlgbZ17ZYHTY8sWgu1LIbpzJIm04" +
       "a32WGHOK8BzdSgl/tWg5TBxXNuv2ZGLjWF1QBT2j9YSZN9phpNMC+Mamx0Qq" +
       "o1baEDbStDG0VzpDQBOWpwxI8raI0uNHxBxX6KZqu77WTNG5OgzKI8GbhVw0" +
       "ITpTRO4R3LI8Jjh45Q5tJ5nXcKSWIcB90damtOlBhG3iyzlu6nUoI1ez1Ibm" +
       "c1Y3uxq54GR8WW/DttRBSVOMQzURpShzRWQ+hRx/Qrp1YzYQkOEmGYzdbLnm" +
       "wcheFtx1o9oYLKNN0F6rVgS63JqYlduykNpDrlGVJtbAHrcl0VS4znq68idM" +
       "zdoYwGkEH6cwvYnrtm+s/JDwWcGJrDYydXTYE7Za0ielsm+rlaAC9aAhxRED" +
       "vD0ILCucDMoqz6DRLO3Jhi+Oauq8DJFjj3RaMTtutCKH1omkWy5bQ7NujDYK" +
       "o9DAMmLYxMoCu5d6NvDXmn5Ncm0pmldkugZsBTFclJU5xgoSjC/L2605atIo" +
       "GFCqw8DOwrirOepKjrpBki2hiIOGk2Y3FbqduOHQXo1P2tEY5zOrum6i07hG" +
       "2WpWxahRXSWjtNZRwmxabWyhTStoD0WWYKXptL2e8xCyoet8ly+31xTelvhk" +
       "bXrjfjoLjaRWNVXQ9MwW6fpeix1XB0RTGowZhHf81mA8JhLPWzWXZWeaEAov" +
       "Tt14Ek0rwczutlYTuRLUBz2/0sBn/oy16xO+b2os1mq4LNFoR9t1uqaA4PhO" +
       "Gid9pooK0qzWj/VYskUA0QkSPYrRrr10Ak7VYGvTIG1ivrQg8FEjb7G0axG9" +
       "Xu/d786XbN55sSWbh4slqKMDm6bdzgspX2BVJjmxZHe0mlzaL7Ffe8jvxBJ7" +
       "Qfn4fgkuDEpP3ugcZrGL/eMfeuFFlfpE9WB/xkWISvdGnv9VtrbR7BNFPZjH" +
       "Lz1+BKM4YvU28Bh7GMbplf5jRq8TWbFd5G3JWcuQJ5eOXx+V3lgsrR0f32E1" +
       "V9UCTS3O7hQLjDcp4NHD9d8RhSSK5ufrtEU+Jg+GUemyVpwAOnMVbeMZ6vHC" +
       "5ehmC2gn1z5Piasgeww8H9mL6yMXFdf4THHdWRDk26IvkYcsdy92lvHECaj1" +
       "0Sr+KUncLXuerUk7yb3/bInnr9iCIF95vPTeI9Eel1qI8X23K8anS6W79sp/" +
       "12nlv0UxHm8DeOYG2wBYaVt0nKvKv2J+99e/N/vUS7tjHfkekahUvtFZ+OuP" +
       "4+dnJ8/ZwHLilPSfYO98+XO/P/3aw675miMxPJNz/Y7zxHCt+hdHUjgviPJz" +
       "7vnBk0vboqHW5yzcZ3lgR6WHdC2CjUDLj46lnJGdbk7nNpqz2BnzZoBf2PMh" +
       "vDrNeZKPv3szbf2mPPiGqPTgNjAiDTVsbahJanHG7JJwzOcHb5fPGuBP2/Op" +
       "vjp83nE8ABUtcik4qrKe1/Cuw6puUOWl7WFQ4or/P3YzYb2QBx+NSg8UwjrS" +
       "i1Oy+ge3Ias35InPAsDftwf+fReQVbGPaLd/7JWMLvWLWcribGIhhhfPUbjv" +
       "z4Pvikr3g46zO2x4faf57ttVpg4QzM/vBfTzr6oNzCv7voKRl26mDJ/Mgx+I" +
       "So8VylDwGvZC1IuDfhoVI+pJpfjB2+X5qwCvn9/z/Pm/Jp5/6mY8/3Qe/HhU" +
       "es0Jnk8x+hO3yyiw7Jf3J0EvX3cS9HYZ3ff0f3czRn8xD34uKj1SMCq4+YUo" +
       "YPhYgVHkFL8vvwojwOXRnt/Rq96wzYKd/3gzfj+TB58G3m/BL77bP3WSzV+9" +
       "DTYLx/0JwN5+6/rl67au33azVgou/tvN2PydPPhNwCawTrvrRgoZHbP5W7dr" +
       "u78CsCfv2ZQvwObNbPfe1S2qvPuoyjfmNTwNWPzXuyp3v7e/61UODFXXoD5w" +
       "7zglMMB3g6sj7sYIPNcBZbxam2tfSTXJWR75nfLexJ694fbzhxtuv3iOsE9u" +
       "uM1pHy7MQx773PWbbfPkR/Pg9dfvni20YFdtkTsP3njOEPnn57z7izz40zx4" +
       "ZofkHNq/3G0u5Y5xF8l/eE6Wv8qD34/y+wAcP9DCML/VqG/sbqY6MUL/we12" +
       "gzcB9Y/33SB+FbvBXQXVXYdyPsn8+tC6H9xzYwkc3JcHd0S7q56u5/zgztvl" +
       "/CnA8Sf2nH/iVeR87+0eOm+PHX/aZIZ/BdaWthTt3PbPHenCwevOkUSusgcP" +
       "gq9bdZf3lCAeug1BPJonNoEAfmQviE/+9QnibUCVr4Sxe43TavqafiU/6Xbt" +
       "5/3Bs8dK8uZzRPPWPHgyKj1c3POSXlvIiVHx4KmLCCnZH8E7eX1SfhfM49dd" +
       "6La7hEz55IsP3vOGF4Xf3J3HOLwo7F68dM8ytu2TV2uciF8G/XppFJK7d3fR" +
       "hl/w9FVR6e2v2OEHFjb/yVk4+Mpd/kpUeu6V5M/3xue/J/PWo9JT5+cFuYrf" +
       "k7laUenxG+WKSneA8CR1Nyq97ixqQAnCk5TvAu1wmhLUX/yepHtPVLrvmC4q" +
       "Xd5FTpL0QemAJI8O/EONvLVLeIKR49vJbhB7/ES32k2UPnIzRTsx5fnsNfMr" +
       "xaWCh+cuYno/jfOpF8fk13+x9YndJU+KLWX5jEfpHrx09+6+qaLQ/OzGMzcs" +
       "7bCsy8O3f+mBH7n3LYczNQ/sAB938RPY3nT2jUqI40fFHUjZT73hJ971Ay/+" +
       "TnFXy/8H9uNnoO1RAAA=");
}
