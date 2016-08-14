package org.apache.batik.ext.awt.image.codec.imageio;
public class TIFFTranscoderImageIOWriteAdapter implements org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.TIFFTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        org.apache.batik.ext.awt.image.spi.ImageWriter writer =
          org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
          getInstance(
            ).
          getWriterFor(
            "image/tiff");
        org.apache.batik.ext.awt.image.spi.ImageWriterParams params =
          new org.apache.batik.ext.awt.image.spi.ImageWriterParams(
          );
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int PixSzInch =
          (int)
            (25.4 /
               PixSzMM +
               0.5);
        params.
          setResolution(
            PixSzInch);
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
                  setCompressionMethod(
                    "PackBits");
            }
            else
                if ("deflate".
                      equals(
                        method)) {
                    params.
                      setCompressionMethod(
                        "Deflate");
                }
                else
                    if ("lzw".
                          equals(
                            method)) {
                        params.
                          setCompressionMethod(
                            "LZW");
                    }
                    else
                        if ("jpeg".
                              equals(
                                method)) {
                            params.
                              setCompressionMethod(
                                "JPEG");
                        }
                        else {
                            
                        }
        }
        try {
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
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
            writer.
              writeImage(
                rimg,
                ostream,
                params);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public TIFFTranscoderImageIOWriteAdapter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1444739551000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1YfWwUxxWfO38fBn8AhhIw4ByoGLgNCh+qTFrAtcPRs321" +
                                                              "HaqalmO8O+dbvLe77M7aZ6cukH6A8geKgkNpFPwXUduIhKhq1EpVkKtKTaI0" +
                                                              "jaBRmw81adU/mn4ghX9CK9qmb2Z2b/f2zob815Nubm72vTfvvXnv997slZuo" +
                                                              "xrZQh4l1BSfolEnsRJrN09iyidKtYdsehtWM/Pifzp+8/duG01FUO4KW5bDd" +
                                                              "J2Ob9KpEU+wRtE7VbYp1mdj9hCiMI20Rm1gTmKqGPoJWqnYyb2qqrNI+QyGM" +
                                                              "4DC2UqgFU2qpow4lSVcARetTXBuJayPtDxN0pVCjbJhTPsOaEobuwDNGm/f3" +
                                                              "sylqTh3HE1hyqKpJKdWmXQULbTUNbWpMM2iCFGjiuLbLdcSh1K4yN3S82PTx" +
                                                              "nSdyzdwNy7GuG5SbaA8S29AmiJJCTf5qj0by9gn0TVSVQksCxBTFU96mEmwq" +
                                                              "waaevT4VaL+U6E6+2+DmUE9SrSkzhSjaWCrExBbOu2LSXGeQUE9d2zkzWLuh" +
                                                              "aK133CETn9oqzX7vaPOPq1DTCGpS9SGmjgxKUNhkBBxK8qPEsvcrClFGUIsO" +
                                                              "Bz5ELBVr6rR72q22OqZj6kAIeG5hi45JLL6n7ys4SbDNcmRqWEXzsjyo3H81" +
                                                              "WQ2Pga1tvq3Cwl62DgbGVFDMymKIPZelelzVFR5HpRxFG+NfAgJgrcsTmjOK" +
                                                              "W1XrGBZQqwgRDetj0hAEnz4GpDUGhKDFY20BoczXJpbH8RjJULQ6TJcWj4Cq" +
                                                              "gTuCsVC0MkzGJcEprQmdUuB8bvbvPfeoflCPogjorBBZY/ovAab2ENMgyRKL" +
                                                              "QB4IxsbO1AXc9vLZKEJAvDJELGh++o1b+7a1z78qaO6rQDMwepzINCNfHl12" +
                                                              "fW33ls9VMTXqTcNW2eGXWM6zLO0+6SqYgDRtRYnsYcJ7OD/4q6+eeo78PYpi" +
                                                              "SVQrG5qThzhqkY28qWrEepjoxMKUKEnUQHSlmz9PojqYp1SdiNWBbNYmNImq" +
                                                              "Nb5Ua/D/4KIsiGAuisFc1bOGNzcxzfF5wUQI1cEXdcJXQuKTYANF56WckScS" +
                                                              "lrGu6oaUtgxmPztQjjnEhrkCT01DGoX4H9++I7FHsg3HgoCE+U7JsMYkDJGR" +
                                                              "I4KA5yqepJKah4CQZMAnWcxVQxpO9vYOW1i32bKVZKvJga9YKiX7FWxCCCZY" +
                                                              "cJr/n2oVmDeXT0YicNBrwzCjQYYeNDRgz8izzoGeWy9kXhchzNLOPQeK+kGv" +
                                                              "hNArwfXioAx6JbguCa5XwtUrcVe9UCTC1VnB9BMxBxEzDtgD4N+4Zejrh46d" +
                                                              "7aiCYDcnq+G4GenmsmLY7YOUV1ky8pXrg7fffCP2XBRFAcdGoRj6FSleUpFE" +
                                                              "QbUMmSgAiQvVJg+fpYWrUUU90PzFydOHTz7A9QgWGSawBvCRsadZaShuEQ+D" +
                                                              "SyW5TWc+/PjqhRnDh5mSquUV2zJOhl4d4cMPG5+ROzfglzIvz8SjqBogEcoA" +
                                                              "xZC2gLDt4T1KUKzLqwjMlnowOGtYeayxRx6Mx2jOMib9FR6VLWxYKQKUhUNI" +
                                                              "QV5MHhoyL739m78+yD3p1Z2mQMMwRGhXAOuYsFaOai1+dA1bhADdHy6mzz91" +
                                                              "88wRHlpAcX+lDeNs7AaMg9MBD37n1RPvfPD+5beifjhSKPbOKPRNBW7Lik/g" +
                                                              "E4Hvf9mX4RNbEDjV2u2C5YYiWpps582+boCbGoAEC474IzoEn5pV8ahGWC78" +
                                                              "u2nTjpf+ca5ZHLcGK160bLu7AH/9MwfQqdeP3m7nYiIyq9u+/3wyUQyW+5L3" +
                                                              "WxaeYnoUTt9Y9/1X8CUoKwDltjpNODoj7g/ED3An94XExwdDz3azIW4HY7w0" +
                                                              "jQL9VUZ+4q2Plh7+6Notrm1pgxY89z5sdokoEqcAm21F7uBVC/7LnraZbFxV" +
                                                              "AB1WhUHnILZzIGznfP/XmrX5O7DtCGwrAyTbAxYAWKEklFzqmrp3f/HLtmPX" +
                                                              "q1C0F8U0Ayu9mCccaoBIJ3YOQLVgfmGf0GOyHoZm7g9U5iHm9PWVj7Mnb1J+" +
                                                              "ANM/W/WTvT+Ye59HoQi7+1x2/mcTHz/Lhq0iSNl0W6HoGv6p9Qqo9xtwTUBm" +
                                                              "hM9XU/RQGezTIqy7yF+K9fEgyjNnr1uoY+Ld3uXHZueUgWd3iL6mtbQL6YEm" +
                                                              "+/nf/efXiYt/fK1CSWqghrldIxNEK9HcQhvLKkUfbyh9lNtz43bVe0+ubiwv" +
                                                              "EkxS+wIloHPhEhDe4JXH/rZm+PO5Y58C/deHHBUW+aO+K689vFl+Msp7YgH8" +
                                                              "Zb10KVNX0GWwqUWg+deZWWxlKc+djmKALGHxEIfvbjdAdoVzR8A0jzY2dBdZ" +
                                                              "eRzGPJYKrCFoqOJnVeVF2QOfNso8xrU8afwu5ICTZUVJ4R2HR7RtMem+zAGH" +
                                                              "mg7lNh4OqRspTQrp3gT2FGRiskPnMo+y4csUxSZZgggFLbRlkTuupeahnk24" +
                                                              "twRppvWD8Wc+fF5kSvhKESImZ2cf/yRxblZkjbh33V929QnyiLsX17SZDdsL" +
                                                              "PJEW2YVz9P7l6szPfzhzJurifJKi6glDFXe3PWwYFAjUdW9AyBb2FeAKfdcO" +
                                                              "kmHm6rI7s7jnyS/MNdWvmnvk97yLKd7FGqFJyDqaFkiJYHrUmhbJqtyMRlFW" +
                                                              "TP6jVwqhRbpfiurcGbcvL6ScgDbtXqRQVMN/g7wU2q/FeYFLLca8yzUJl76F" +
                                                              "uCiqgjFIPU3RikrUQAljkHKGouYwJezPf4N0pyDYfTpomcQkSPItkA4kbPpt" +
                                                              "00uvZp7U7J6fEJfaQqS83O0RjeNdYqvIEuz0mAv4OxkPaB3xViYjX5071P/o" +
                                                              "rd3Pik5T1vD0NL/Dp1Cd6GeLYL1xQWmerNqDW+4se7Fhk5cZJZ1uUDce8oAu" +
                                                              "vCtcE2q97HixA3vn8t5rb5ytvQE5fQRFMEXLjwTeiAhPQf/mQCU5kgpWwMCb" +
                                                              "Pd4VdsX+fOzNf74baeWthFsz2xfjyMjnr72Xzprm01HUkIRQ0xVSGEEx1f7i" +
                                                              "lD5I5AloeuodXT3hkKQCiTRqOHrx9c0yln6Yva/hnnEdurS4yi4hFHWUo1P5" +
                                                              "xQy6rEliHWDSeQELlTfHNINPC+y1RgWr4Gx2XPrXye++PQDwUKJ4UFqd7YwW" +
                                                              "K2Xw7ZBfOl2gFH1+VSbVZ5pu398wx0/VNDmgXeRGXxDUjIKiSKdp/g9IciUy" +
                                                              "5RUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZXtRfveQ/uEbf//tv/38t/L65/8ClgWvG9EhAAA=");
}
