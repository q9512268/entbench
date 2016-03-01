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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qwOTUk0QhdijDYgSdIHQq4i7kAJnOOPb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "H3jhd4rvsvxfyo/hUvVRAAA=");
}
