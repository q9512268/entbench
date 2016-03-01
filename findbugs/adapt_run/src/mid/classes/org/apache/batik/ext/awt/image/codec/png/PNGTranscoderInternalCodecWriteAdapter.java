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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "S7NyUmbmUx1rVtK0ouspXCH7tU5iJ0HP00eC4nQXhWkKQrk8Itipoo43LDwZ" +
       "t2pwvboekstSjZbYGkIuBw1FUHRTj4JGmeJby8kMF0PWHa7MRN1UaLSgDI0R" +
       "SaY6umG4he5ink7J5bZG6RGCVeuxVKshSWE4qjY65V61Vq7gKcJOI2NTI6ky" +
       "mKjOtM2yiLFLesoXPSrVZpZAjjGvWCLmLiESLt6YrMsNtyA02kkVbAOTiFsV" +
       "bADbphJrMKaJTceRiXBTLioMgrFdsjCFI3YM9s0sddiyQfvzZEnAZSZtsQpP" +
       "eJ2SXZoXKHPmlky/4gWrlaCv2OmUaLa1YnfcxVusBXfaLZxae1q3RWMdhkF7" +
       "BDaemGYrrfdcpBlYSHuw0mpUuYxrs7keRWkp3mCMUxIUN3KLhorbKYrPbGqW" +
       "mg0GqUdeKZGnLKtwyxEhJnU0WVKCXtdqq7pnzBiMQdc1CiTNeGj2dby85tIi" +
       "Q7vVqqcW4tkKdWHZ73WTWTRy0eYiGKnMotHrNwZOo8X2p4zCDGsVujrpz6ki" +
       "yWD62MWSzDFxzawBkKD1il6N5UALgs2iNlwZpDEVZqqWpLXCnJiY8GwjdF3w" +
       "DC8J3LhaHjmIDysrH+4oakPszRtY0W8p1lwfGjERr7W6KJAa2elhdZiXCjPX" +
       "KqqKotmJzS2ishSsQqkfdAtlTJW6Ba2gIbDmDbBCV51V0gVNyamBrtcpK6zT" +
       "hEeLK59m6x2L7+lkpT3RVhxTqic9304XAUHPZr3puoVumhjhLmKs0Dc1blEq" +
       "l/rGaLKmClI6GBhugMlKgbNgJZ56hY6BVoSyU2k2kdIAIRC0xSd+AzVrE77M" +
       "O8gynPrqpkkUGJXSl2Vm1TfKhVgaeB2LmBOJq0wNjm8I0nDY05WAIGw/aVpc" +
       "YdqytV5Hx2CLNyosbXt4fe5VZzRZ6sOw1ZixIU2h7CDupNUJvSj3unQUUGur" +
       "GbFoo7+YcLhjiWll2Y7nlJUsfGcwqXRGfLGoCk0mUNGZC56hcVOhKhMvcrS2" +
       "BlOF3oYeuY5Kk1Sj0oOH5RFmb8CYV+lwAYvxCo2tTQZByGIiFOZk3B02Pb2J" +
       "tUeFihoUa3C5qE28uKOlkiD5dJoos8hDsVaTLS/h0kpu6E59wYktc7Ka8KM2" +
       "Jc64KBUqY2SozSQ0ntWaNbIPNzpIrzqe80QbIUsm35s2/ca0OuZRY7wikVgS" +
       "W/yirKvxZKVp0lrrTQm+tw4MskKVW23Fr8tUf9op1agVvq4GZa6iT8MVMd+0" +
       "+yCRXGl2maUwYV0fTSgSnRuJ6wpsMpmYw2nDB/Ascyt7UF6O2h5O1NGxhhsT" +
       "jRgs8bUFw8QckatRU6TGcGmsWdxcEPxqUhygk2GBahEc36H7JYAJKt038UIa" +
       "OOvZEhmsNnFtpcETdF2EadrqIVh/PI0ZC+RwSChOI3w1q6jSvBqiDjqvpZVK" +
       "YLdMJxEtkBAJ/aS9wkmA0tyaq859edR1KupqmG7seOX4dp1krToJopUthsOF" +
       "UqXGjTpRLYhkc2JPSU6Fi8MQK44ItA/XKmlrBWvkiqcDtwMSL5TpjUdTrK6p" +
       "m3juwZOarIzZhYVv+lxHBhu+ipVnZsUgRnSV0vyZ0ofFBVNcuMtix7Rs8Hjo" +
       "L6MyarcL1lIsJ87QLUedcFXC1khzSU9ErtSzjTXt2vVFMZwl42iMWkl3DdYP" +
       "NmmT8lf6nBG1QqTStdo6wRmC9ZyFwHsl0/TGvjg0lGkTR4fieMrMKhwT9du+" +
       "oqVIbe1MPG6s88JsoTRmNMU7AmmgC4WBcaFTFqjZvMniePbq8a7X9/Z3Z/6i" +
       "e3QYAl76sonW63jr2U49nDWPHRX38s/5w8L54e+x4t6xAsiZw5fqd15X9I2O" +
       "KrsHdd8T1d4rxyu82evg/Tc7KMlfBT/5wRdeVAafQvYOqk98BN0Wud47LHWl" +
       "Wif0CaC33/y1t5efE+2qIl/64L/cO/mZxXteR933wVN6nhb5u72XvtJ6XP71" +
       "PejsUY3kuhOsk0xXT1ZGLgZqFAfO5ER95P4j97wh88YV8H3HgXuevHHt9Yah" +
       "dCYPpW0AnSrunT2oaB04FH6dDj3kuy+vdeyq/USsZaVnpZNdHRI9+WrCdzIH" +
       "ceTFUa5tdErbMyfD71W13QlsJLLqZQ7OZb4va9wIurjOYnGn4OjYtuEi6JaV" +
       "ayi7/eT9uCrCiWJhBD3+2k45sjLtPdcd6W6PIeXPvnjp1re+OP3rvNB/dFR4" +
       "GwPdqsWWdbyqdqx/3gtUzcgtvW1bY/Pyn2cj6G2v9Ygmgs6CNjfrmS33hyLo" +
       "ymvhjqBz+e9x3uci6IFX5wVcxpEfDrh+LYLuuRkX0A+0x6lfiKA334gaUIL2" +
       "OOVHI+jyaUpw//z3ON1vgQjZ0UXQ+W3nOMkngHRAknVf9G5QZ9wWTZMzx5Dq" +
       "AHvzkLrrx4XUEcvx841sCfK/ChwiUbz9s8A1+XMv0v33vlL91PZ8RbakzSaT" +
       "cisDXdge9Ryh2cM3lXYo63z7iR/e8fnbHjtE3ju2Cu8w5phuD974AKNhe1F+" +
       "5LD5w7f+/jt/+8Vv5mXP/wX0a/YOwyEAAA==");
}
