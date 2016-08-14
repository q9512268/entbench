package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFTranscoderInternalCodecWriteAdapter implements org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.TIFFTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam params =
          new org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam(
          );
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int numPix =
          (int)
            (1000 *
               100 /
               PixSzMM +
               0.5);
        int denom =
          100 *
          100;
        long[] rational =
          { numPix,
        denom };
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] fields =
          { new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_RESOLUTION_UNIT,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_SHORT,
          1,
          new char[] { (char)
                         3 }),
        new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_X_RESOLUTION,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_RATIONAL,
          1,
          new long[][] { rational }),
        new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_Y_RESOLUTION,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_RATIONAL,
          1,
          new long[][] { rational }) };
        params.
          setExtraFields(
            fields);
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.TIFFTranscoder.
                  KEY_COMPRESSION_METHOD)) {
            java.lang.String method =
              (java.lang.String)
                hints.
                get(
                  org.apache.batik.transcoder.image.TIFFTranscoder.
                    KEY_COMPRESSION_METHOD);
            if ("packbits".
                  equals(
                    method)) {
                params.
                  setCompression(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam.
                      COMPRESSION_PACKBITS);
            }
            else
                if ("deflate".
                      equals(
                        method)) {
                    params.
                      setCompression(
                        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam.
                          COMPRESSION_DEFLATE);
                }
                else {
                    
                }
        }
        try {
            int w =
              img.
              getWidth(
                );
            int h =
              img.
              getHeight(
                );
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                img.
                getSampleModel(
                  );
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageEncoder tiffEncoder =
              new org.apache.batik.ext.awt.image.codec.tiff.TIFFImageEncoder(
              ostream,
              params);
            int bands =
              sppsm.
              getNumBands(
                );
            int[] off =
              new int[bands];
            for (int i =
                   0;
                 i <
                   bands;
                 i++)
                off[i] =
                  i;
            java.awt.image.SampleModel sm =
              new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              w,
              h,
              bands,
              w *
                bands,
              off);
            java.awt.image.RenderedImage rimg =
              new org.apache.batik.ext.awt.image.rendered.FormatRed(
              org.apache.batik.ext.awt.image.GraphicsUtil.
                wrap(
                  img),
              sm);
            tiffEncoder.
              encode(
                rimg);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public TIFFTranscoderInternalCodecWriteAdapter() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Qtxz4haH5/8HWMxc+IgWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
