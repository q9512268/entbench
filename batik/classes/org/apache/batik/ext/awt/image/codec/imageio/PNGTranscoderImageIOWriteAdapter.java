package org.apache.batik.ext.awt.image.codec.imageio;
public class PNGTranscoderImageIOWriteAdapter implements org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter {
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
        org.apache.batik.ext.awt.image.spi.ImageWriter writer =
          org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
          getInstance(
            ).
          getWriterFor(
            "image/png");
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
        try {
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            writer.
              writeImage(
                img,
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
    public PNGTranscoderImageIOWriteAdapter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1YfWwcRxWfu/N3/J3ECWniJI4T4dS5TUQCrWxKY9dOLj1/" +
                                                              "KHYDODTnud0538Z7u5vdWfvsYkhbIIE/oii4bQqt/3JVQG1TISpA0MqoEm1V" +
                                                              "QGqJgIKaIvEH4SOiEVL5I0B5M7N7u7fnD8JfnHRzezPvvXnvzXvv92afu4HK" +
                                                              "bQu1Ep3G6YxJ7HifToexZROlV8O2PQpzKfmJGP77qeuDd0dRxRiqz2J7QMY2" +
                                                              "6VeJpthjaJuq2xTrMrEHCVEYx7BFbGJNYaoa+hjaqNqJnKmpskoHDIUwghPY" +
                                                              "SqImTKmlph1KEq4AirYlQROJayIdDi93JVGtbJgzPvnmAHlvYIVR5vy9bIoa" +
                                                              "k6fxFJYcqmpSUrVpV95Cd5qGNjOhGTRO8jR+WjvkuuBY8lCJC9pebPjg1sVs" +
                                                              "I3fBeqzrBuXm2ceJbWhTREmiBn+2TyM5+wz6Aool0boAMUXtSW9TCTaVYFPP" +
                                                              "Wp8KtK8jupPrNbg51JNUYcpMIYp2FgsxsYVzrphhrjNIqKKu7ZwZrN1RsFZY" +
                                                              "WWLiY3dK80+cavxuDDWMoQZVH2HqyKAEhU3GwKEklyaWfVhRiDKGmnQ47BFi" +
                                                              "qVhTZ92TbrbVCR1TB47fcwubdExi8T19X8E5gm2WI1PDKpiX4QHl/ivPaHgC" +
                                                              "bG3xbRUW9rN5MLBGBcWsDIa4c1nKJlVdoWh7mKNgY/v9QACslTlCs0ZhqzId" +
                                                              "wwRqFiGiYX1CGoHQ0yeAtNyAALQo2rKiUOZrE8uTeIKkWESG6IbFElBVc0cw" +
                                                              "Foo2hsm4JDilLaFTCpzPjcHuCw/pR/UoioDOCpE1pv86YGoNMR0nGWIRyAPB" +
                                                              "WLs3+Thuefl8FCEg3hgiFjTf//zNeztbl14XNHcsQzOUPk1kmpIX0/Vvbe3t" +
                                                              "uDvG1KgyDVtlh19kOc+yYXelK29ChWkpSGSLcW9x6fhPP3v2O+QvUVSTQBWy" +
                                                              "oTk5iKMm2ciZqkasI0QnFqZESaBqoiu9fD2BKuE5qepEzA5lMjahCVSm8akK" +
                                                              "g/8HF2VABHNRDTyresbwnk1Ms/w5byKEKuGL2uDbgcTno2yg6EtS1sgRCctY" +
                                                              "V3VDGrYMZr8tQcVJg2+zUhqiflKyDceCENx3IH5QMqwJCUMsZIm7yLITT1NJ" +
                                                              "zUEISDJUJFk8qyBw8MiohXWbzVoJNpkY+rSlUnJYwSbEXJxFo/l/okee+Wv9" +
                                                              "dCQCR7k1XEg0yMGjhgbsKXne6em7+ULqTRGkLLFcT1M0AGrFhVpxrhYvu6BW" +
                                                              "nKsS52rFXbXia6mFIhGuzQamnggqCIlJKC5Q3Ws7Rh48Nn6+LQbRbE6XwXky" +
                                                              "0rYilOv1K5AHGyn5SnPd7M5rB16NorIkasYydbDGQOuwNQHlUJ50K0ZtGvDP" +
                                                              "h6EdARhi+GkZMlGgCq4ER66UKmOKWGyeog0BCR5IsnIgrQxRy+qPli5PP3zi" +
                                                              "i/ujKFqMPGzLciiajH2Y4UUBF9rDFWc5uQ3nrn9w5fE5w689RVDmIXAJJ7Oh" +
                                                              "LRwvYfek5L078Eupl+faudurARsohlyGstsa3qOotHV5MMFsqQKDM4aVwxpb" +
                                                              "8nxcQ7OWMe3P8EBuYsNGEdMshEIKcoT55Ij59G9+8aePcU96YNQQ6CJGCO0K" +
                                                              "FEAmrJmXuiY/IkctQoDu3cvDX3/sxrmTPByBYtdyG7azsRcKH5wOePDLr595" +
                                                              "571ri1ejfghT6ACcNDRSeW7Lhg/hE4Hvv9mXFS02IYpXc69bQXcUSqjJdt7j" +
                                                              "6wbFVINCwoKj/QEdwlDNqDitEZY//2zYfeClv15oFMetwYwXLZ1rC/DnP9KD" +
                                                              "zr556h+tXExEZmDu+88nEwix3pd82LLwDNMj//Db2558DT8NWAP13VZnCS/Z" +
                                                              "iPsD8QM8xH2xn48HQ2ufYMNuOxjjxWkUaLpS8sWr79edeP+Vm1zb4q4teO4D" +
                                                              "2OwSUSROATbbhdzBgxD+y1ZbTDZuyoMOm8KF6ii2syDs4NLg5xq1pVuw7Rhs" +
                                                              "K0MRt4csKHr5olByqcsrf/uTV1vG34qhaD+q0Qys9GOecKgaIp3YWajDefNT" +
                                                              "9wo9pqtgaOT+QCUeKplgp7B9+fPty5mUn8jsDzZ9r/vZhWs8LE0h446gwD18" +
                                                              "7GBDpwhb9rgvX3AW/1R4OOv9BpwVkBnhz5sp6i7BDloABxc+igCjPQgVzPvb" +
                                                              "VuqreE+4+Mj8gjL0zAHR/TQX9yp90Io//6t//Sx++fdvLANr1dQw92lkimhF" +
                                                              "isOWRXAzwFtOv+S9W3/pDz9sn+i5HaRhc61rYAn7vx2M2LsycoRVee2RP28Z" +
                                                              "vSc7fhugsT3kzrDIbw8898aRPfKlKO+vBV6U9OXFTF1Bx8KmFoGLhM7MZDN1" +
                                                              "POV2FaJoHQuadvjud6NICqecqO48JNnQV2DlwVrjsSzDGqooMX6iMS8UpdsM" +
                                                              "RY9vK88sv93pcTIMyhTe23hEnasJ92UOOdR0KDfxMyFtI8WJs6q2vsC+vExM" +
                                                              "duZc5jgbRiiqmWZZJBS0UMcq12VLzQEKTrkXDmmu+b3Jp64/L9IpfDsJEZPz" +
                                                              "81/7MH5hXqSWuMLtKrlFBXnENY5r2siGOEvwnavtwjn6/3hl7kffmjsXddHh" +
                                                              "forKpgxVXAPvYsOoqFLd/2P5ZBM9Zh76wbWaV1ZpN5fcx8UdUn5hoaFq08ID" +
                                                              "v+aVoXDPq4UczziaFkiRYLpUmBbJqNyuWoFOJv85s1xMrdJ3U1TpPnH7TCGF" +
                                                              "Qrf330ihqJz/BnmnoYtbnRe41EISuFyzcKFciYuiGIxB6jnooJejBkoYg5Rn" +
                                                              "KWoMU8L+/DdI9yhEv08HnZd4CJJ8BaQDCXs8Z3r51siznL1DiIsLcz5SipF3" +
                                                              "if5zjWArsAQbRuYC/r7HK7yOeOMDV5eFY4MP3fz4M6JhlTU8O8vfDyRRpWiL" +
                                                              "C8V754rSPFkVRztu1b9YvdtLlaKGOagbD3koN7y53BLq4Oz2QiP3zmL3Kz8/" +
                                                              "X/E2JPlJFMEUrT8ZeNsiPAVtoAOoeTLp42bgfSFvLbs6vjFzT2fmb7/j7YeL" +
                                                              "s1tXpk/JV5998JeXNi9CC7ouAWGmKyQ/hmpU+74Z/TiRp6wxVKfafXlQEaSo" +
                                                              "WEugKkdXzzgkoSRRPUs+zN4Ecb+47qwrzLKbDEVtpcWq9P4Hrdo0sXoMR1c4" +
                                                              "nAHQ+jNFL6I8/HNMM8TgzxSOckOp7Sn5vq82/Phic6wfCkiROUHxlbaTLmBr" +
                                                              "8N2UD7ZubRUXilgqOWCa3gWjdtwUEf+koGHzFEX2urMBHGJ/n+Livskf2bDw" +
                                                              "H+RR3Ex2FgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3viFd/z2c9/Km6f/A2PFCZ3vIQAA");
}
