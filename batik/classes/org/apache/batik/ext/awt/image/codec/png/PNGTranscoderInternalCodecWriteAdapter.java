package org.apache.batik.ext.awt.image.codec.png;
public class PNGTranscoderInternalCodecWriteAdapter implements org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.PNGTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        int n =
          -1;
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_INDEXED)) {
            n =
              ((java.lang.Integer)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_INDEXED)).
                intValue(
                  );
            if (n ==
                  1 ||
                  n ==
                  2 ||
                  n ==
                  4 ||
                  n ==
                  8)
                img =
                  org.apache.batik.ext.awt.image.rendered.IndexImage.
                    getIndexedImage(
                      img,
                      1 <<
                        n);
        }
        org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam params =
          org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
          getDefaultEncodeParam(
            img);
        if (params instanceof org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB) {
            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
               params).
              setBackgroundRGB(
                new int[] { 255,
                255,
                255 });
        }
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_GAMMA)) {
            float gamma =
              ((java.lang.Float)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_GAMMA)).
              floatValue(
                );
            if (gamma >
                  0) {
                params.
                  setGamma(
                    gamma);
            }
            params.
              setChromaticity(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  DEFAULT_CHROMA);
        }
        else {
            params.
              setSRGBIntent(
                org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
                  INTENT_PERCEPTUAL);
        }
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int numPix =
          (int)
            (1000 /
               PixSzMM +
               0.5);
        params.
          setPhysicalDimension(
            numPix,
            numPix,
            1);
        try {
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder pngEncoder =
              new org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder(
              ostream,
              params);
            pngEncoder.
              encode(
                img);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public PNGTranscoderInternalCodecWriteAdapter() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BQPlLfByFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "j/Jri80fvfHzb/2d57+Zp07/F5tXtOLrIQAA");
}
