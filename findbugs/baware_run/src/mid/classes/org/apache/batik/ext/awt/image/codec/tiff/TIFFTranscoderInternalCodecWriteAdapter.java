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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f6aQ+8/xFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/uEbf//tv/38t/Ia6P8CCSufzNYhAAA=");
}
