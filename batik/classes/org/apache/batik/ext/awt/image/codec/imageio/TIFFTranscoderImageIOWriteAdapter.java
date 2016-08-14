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
    public static final long jlc$SourceLastModified$jl7 = 1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1YfWwcRxWfu/N37PgjiRPSxEkcJ5Id5zYRSWnltNR27ebS" +
                                                              "84diN4BDc5nbnfNtvLe72Z21zy6GtKhN4I8oCm6b0tZ/uWpBbVMhKkDQyqgS" +
                                                              "bVVAaomAgpoi8QfhI6IRUvkjQHkzs3u7t+ePhr846eb2Zt57896b997vzb54" +
                                                              "HZXbFmohOo3TaZPY8T6dDmPLJkqvhm17FOZS8pMx/I8T1wbvjKKKMbQ2i+0B" +
                                                              "GdukXyWaYo+hrapuU6zLxB4kRGEcwxaxiTWJqWroY2iDaidypqbKKh0wFMII" +
                                                              "jmEriRoxpZaadihJuAIo2poETSSuidQdXu5KolrZMKd98k0B8t7ACqPM+XvZ" +
                                                              "FDUkT+FJLDlU1aSkatOuvIX2mIY2Pa4ZNE7yNH5KO+i64EjyYIkLWl+p//jm" +
                                                              "hWwDd8E6rOsG5ebZR4ltaJNESaJ6f7ZPIzn7NPoqiiXRmgAxRW1Jb1MJNpVg" +
                                                              "U89anwq0ryO6k+s1uDnUk1RhykwhinYUCzGxhXOumGGuM0iooq7tnBms3V6w" +
                                                              "VlhZYuLje6S5J080fC+G6sdQvaqPMHVkUILCJmPgUJJLE8vuVhSijKFGHQ57" +
                                                              "hFgq1tQZ96SbbHVcx9SB4/fcwiYdk1h8T99XcI5gm+XI1LAK5mV4QLn/yjMa" +
                                                              "Hgdbm31bhYX9bB4MrFFBMSuDIe5clrIJVVco2hbmKNjYdj8QAGtljtCsUdiq" +
                                                              "TMcwgZpEiGhYH5dGIPT0cSAtNyAALYo2LyuU+drE8gQeJykWkSG6YbEEVNXc" +
                                                              "EYyFog1hMi4JTmlz6JQC53N98ND5h/TDehRFQGeFyBrTfw0wtYSYjpIMsQjk" +
                                                              "gWCs7Ug+gZtfOxdFCIg3hIgFzQ++cuOezpbFtwTNbUvQDKVPEZmm5IX02ne3" +
                                                              "9LbfGWNqVJmGrbLDL7KcZ9mwu9KVN6HCNBckssW4t7h49GdfOvNd8tcoqkmg" +
                                                              "CtnQnBzEUaNs5ExVI9Z9RCcWpkRJoGqiK718PYEq4Tmp6kTMDmUyNqEJVKbx" +
                                                              "qQqD/wcXZUAEc1ENPKt6xvCeTUyz/DlvIoQq4Ys64Csh8YmzgaJHpayRIxKW" +
                                                              "sa7qhjRsGcx+W4KKkwbfZqU0RP2EZBuOBSG4d3/8gGRY4xKGWMgSd5FlJ56i" +
                                                              "kpqDEJBkqEiyeFYNaTTR3z9qYd1m01aCzSaGvmCplHQr2ISgi7NwNP9fFMkz" +
                                                              "j62bikTgMLeES4kGWXjY0IA9Jc85PX03Xk69I8KUpZbra4oGQa+40CvO9eKF" +
                                                              "F/SKc13iXK+4q1d8Vb1QJMLVWc/0E3EFUTEB9QUKfG37yINHTp5rjUFAm1Nl" +
                                                              "cKSMtLUI6Hr9IuQhR0q+3FQ3s+Pq/jeiqCyJmrBMHawx3Oq2xqEiyhNu0ahN" +
                                                              "AwT6SLQ9gEQMQi1DJgoUwuUQyZVSZUwSi81TtD4gwcNJVhGk5VFqSf3R4qWp" +
                                                              "h499bV8URYvBh21ZDnWTsQ8zyChAQ1u46Cwlt/7stY8vPzFr+OWnCM08EC7h" +
                                                              "ZDa0hgMm7J6U3LEdv5p6bbaNu70a4IFiSGeovC3hPYqqW5eHFMyWKjA4Y1g5" +
                                                              "rLElz8c1NGsZU/4Mj+RGNmwQQc1CKKQgB5m7Rsxnf/vLP3+We9LDo/pAIzFC" +
                                                              "aFegBjJhTbzaNfoROWoRAnQfXBr+1uPXzx7n4QgUO5fasI2NvVD74HTAg4++" +
                                                              "dfr9D68uXIn6IUyhCXDS0EvluS3rP4FPBL7/YV9Wt9iEqF9NvW4R3V6ooibb" +
                                                              "ebevG9RTDUoJC462B3QIQzWj4rRGWP78q37X/lf/dr5BHLcGM160dK4uwJ//" +
                                                              "TA86886Jf7ZwMRGZ4bnvP59MgMQ6X3K3ZeFppkf+4fe2PvUmfhbgBkq8rc4Q" +
                                                              "XrUR9wfiB3iQ+2IfHw+E1j7Hhl12MMaL0yjQd6XkC1c+qjv20es3uLbFjVvw" +
                                                              "3Aew2SWiSJwCbLYHuYOHIvyXrTabbNyYBx02hgvVYWxnQdiBxcEvN2iLN2Hb" +
                                                              "MdhWhjJuD1lQ9PJFoeRSl1f+7qdvNJ98N4ai/ahGM7DSj3nCoWqIdGJnoRDn" +
                                                              "zc/fI/SYqoKhgfsDlXioZIKdwralz7cvZ1J+IjM/3Pj9Q8/PX+VhaQoZtwUF" +
                                                              "7uZjOxs6Rdiyx735grP4p8KDWu834KyAzAh/3kTRXSXgQQvg4OJHMWK0BbGC" +
                                                              "uX/rcr0V7wsXHpmbV4ae2y86oKbifqUP2vGXfv3vn8cv/eHtJYCtmhrmXo1M" +
                                                              "Eq1Ic9iyCG8GeNvp17wP1l7844/axntuBWrYXMsqYML+bwMjOpaHjrAqbz7y" +
                                                              "l82jd2dP3gJqbAu5MyzyOwMvvn3fbvlilPfYAjBKevNipq6gY2FTi8BlQmdm" +
                                                              "spk6nnM7C2G0hkVNG3xvd8PoYDjnRHnnMcmGvgIrj9Yaj2UJ1lBJifETjXmx" +
                                                              "uO9WY9Fj3MJzy+94epwMAzOFdzceUedK0n2ZQw41Hcpt/GJI3Uhx6kifTmBf" +
                                                              "XiYmO3Qu8yQbRiiqmWJpJBS0UPsKd2ZLzQEOTrq3Dmm26cOJZ669JPIpfEUJ" +
                                                              "EZNzc9/8JH5+TuSWuMftLLlKBXnEXY5r2sCGOMvwHSvtwjn6/3R59scvzJ6N" +
                                                              "uvhwP0Vlk4Yq7oJ3sGFU1KlD/2MBZRM9Zh4u6av2r6zYbiq5lYubpPzyfH3V" +
                                                              "xvkHfsNrQ+G2VwtZnnE0LZAkwYSpMC2SUblhtQKgTP5zeqmgWqH3pqjSfeIG" +
                                                              "mkIKhYbv00ihqJz/BnmnoJFbmRe41EIWuFwzcK1cjouiGIxB6lloopeiBkoY" +
                                                              "g5RnKGoIU8L+/DdI93UIf58Omi/xECR5DKQDCXs8a3oJ18DTnL1JiItrcz5S" +
                                                              "CpN3iBZ0lWgrsAR7RuYC/tbHK72OeO8Dt5f5I4MP3bj9OdGzyhqemeFvCZKo" +
                                                              "UnTGhfK9Y1lpnqyKw+03175SvcvLlaKeOagbj3moN7y/3Bxq4uy2Qi/3/sKh" +
                                                              "139xruI9yPLjKIIpWnc88M5FeAo6QQdw83jSR87AW0PeXXa1f3v67s7M33/P" +
                                                              "OxAXabcsT5+Srzz/4K8ublqALnRNAsJMV0h+DNWo9r3T+lEiT1pjqE61+/Kg" +
                                                              "IkhRsZZAVY6unnZIQkmitSz5MHsfxP3iurOuMMsuMxS1llar0isgdGtTxOox" +
                                                              "HF3hgAZQ688UvY7yENAxzRCDP1M4yvWltqfke79R/5MLTbF+KCBF5gTFV9pO" +
                                                              "uoCuwTdUPty6xVXcKWKp5IBpeneMWmyKiH9K0LB5iiId7mwAiNjfZ7i4p/kj" +
                                                              "G+b/C/RlP5V8FgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
