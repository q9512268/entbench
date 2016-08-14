package org.apache.batik.transcoder.image;
public class TIFFTranscoder extends org.apache.batik.transcoder.image.ImageTranscoder implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          LOW_MODE; }
    public TIFFTranscoder() { super();
                              hints.put(KEY_FORCE_TRANSPARENT_WHITE,
                                        java.lang.Boolean.
                                          FALSE); }
    public org.apache.batik.bridge.UserAgent getUserAgent() { return this.
                                                                       userAgent;
    }
    public java.awt.image.BufferedImage createImage(int width,
                                                    int height) {
        return new java.awt.image.BufferedImage(
          width,
          height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
    }
    private org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter getWriteAdapter(java.lang.String className) {
        org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter adapter;
        try {
            java.lang.Class clazz =
              java.lang.Class.
              forName(
                className);
            adapter =
              (org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter)
                clazz.
                newInstance(
                  );
            return adapter;
        }
        catch (java.lang.ClassNotFoundException e) {
            return null;
        }
        catch (java.lang.InstantiationException e) {
            return null;
        }
        catch (java.lang.IllegalAccessException e) {
            return null;
        }
    }
    public void writeImage(java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        boolean forceTransparentWhite =
          false;
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_FORCE_TRANSPARENT_WHITE)) {
            forceTransparentWhite =
              ((java.lang.Boolean)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_FORCE_TRANSPARENT_WHITE)).
                booleanValue(
                  );
        }
        if (forceTransparentWhite) {
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                img.
                getSampleModel(
                  );
            forceTransparentWhite(
              img,
              sppsm);
        }
        org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter adapter =
          getWriteAdapter(
            ("org.apache.batik.ext.awt.image.codec.tiff.TIFFTranscoderInte" +
             "rnalCodecWriteAdapter"));
        if (adapter ==
              null) {
            adapter =
              getWriteAdapter(
                ("org.apache.batik.transcoder.image.TIFFTranscoderImageIOWrite" +
                 "Adapter"));
        }
        if (adapter ==
              null) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ("Could not write TIFF file because no WriteAdapter is availbl" +
               "e"));
        }
        adapter.
          writeImage(
            this,
            img,
            output);
    }
    public static interface WriteAdapter {
        void writeImage(org.apache.batik.transcoder.image.TIFFTranscoder transcoder,
                        java.awt.image.BufferedImage img,
                        org.apache.batik.transcoder.TranscoderOutput output)
              throws org.apache.batik.transcoder.TranscoderException;
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471188907000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471188907000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "37v5pvmRXUShsgO/H7lgZ3HiGLEHvW4z");
        java.lang.String jlc$ClassType$jl5$1 =
          ("+/MMfD+jdRYcNzaSEb4hFrZ3MQPnDy1s79YMXHiDLGxvZxeNnNmlG3bYy4/g" +
           "e3e9jh3yXnbHae9yBu7eDep1K+iBkwq6NwP3v5GmdmY3okYGPpOzffjlVPWW" +
           "12tSew9l4JEMPPoG6uutJ/X1RAaejEPojuNXOrPmBdhHPXDNvfLtXWj51164" +
           "dNv9L4z/IE/vHN1XvkBDt2mRaR6/iXjs+bzrq5qRD/DCNqOTH473ngqhx142" +
           "VxFCtxiHx/u9t20Rnw6hN98EMYQuhieSG4d4MDhKn8YD9PPv4/0QQGHXD8TY" +
           "7cPxLijYmoAu2WM1uzF5g73d3S83Wcfyjk/c8EDTj7b/AnBV/uQLXeanXqp+" +
           "fHvlEmww0zSjAk4Mt26zaTnRLDP12A2pHdI633nqu3f++oUnDzOZd24F3q2b" +
           "Y7K95fp5LtJywzwzlf7G/f/4R/7eC1/Jr/39f3wxcsCZMQAA");
    }
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_FORCE_TRANSPARENT_WHITE =
      org.apache.batik.transcoder.image.ImageTranscoder.
        KEY_FORCE_TRANSPARENT_WHITE;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_COMPRESSION_METHOD =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ph0AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.image.TIFFTranscoder ENT_ld =
          new org.apache.batik.transcoder.image.TIFFTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tu0Ubg1b2w4u+UsV3YJANZmi/fEiaQoitjNUNTS0miCrgz6x4xorbsU1GXsw" +
       "wLpoNDOa0zQejGKGqm13fjxka+pQmXZhtTokh6k2bZlchPncyKkbSpcOq8vI" +
       "9oURPK4rrT7MyqhXwVyMJ0A93u8YPiX5ILN3xkwLVjyDhRtyOuI4itPHur1Y" +
       "RbKfZ15N3zWtlPUtnWlUGDhndhhTyeC4RouyLjQ7FtaoDBAbsWc8w3TbFYQY" +
       "biZ4RVe5SYQNZiQvylh9phswRVTmgIV2e7hqJTGxiDt8uCPzlVnp+1E9YOBQ" +
       "ZsR24nOSSvVdBDMyNpro9QXij6OIpGoqpaeIzay3DjKakquovmt22ShK+0tN" +
       "Z2K1tTaIheL1+/VZH7dHLr5Z0wKomY2k1RvxGF7bDtvojDA8kwYvaDCHdLq8" +
       "PBGY/q5NsToO+1XGRWMMlkE813Gb16ztBrzMDc265TgzKUGzho8kTDslQgIb" +
       "jFTWk0lVq1MVZTI3FI6SWae6UGxq7DpbduaJa4P28EpmD0m9y7MLIaHmTWy2" +
       "yEd1eZrMEVMy8ExX11wzbC0zW+F5Aq3Nt1vDzdwZKLBHWiWag1oax2u2xqzd" +
       "VO1Va/2cs5VlL6/k8HYqUP6mFZpV8NL8wgvF67T3+nY0Hi83b05OSG23WQzM" +
       "Xseb/H7omaJ578neV/m7DF04VTu7C3+6NXvpeKPonYafHEapn1iecVjs3OFJ" +
       "ElmLNCn204stjHfd63S03L747MdeelnnP4ccHO17mwn0SBKEf981NoZ7Zr7L" +
       "gNL7771Vw5aHw6f7sb/9sb94SvoO80Ov45Tp3Rf4vEjyH7Ov/C71Pu3HDqAH" +
       "TnZn7zi2Po906/ye7NXISNLIl87tzL7rRP1XjrceLx2p/9J+4/Qjd26cftuN" +
       "darG1joNEuO5/WHKDctPbhT6V4/0bzz3/I0P3/iu/Zw37thBVcMwPozUODEi" +
       "Kzeiw55f7IwZH1a9xYuHQ16+zfJE79b3iDdefD4Ms1PTupfNnGO6GP0YmODe" +
       "5xs/cJ+xTxTNRxLozefEKUG1M4a9SqAHrKMvLUqD/+hrbV2dnajsePFEjrcW" +
       "nc+ACzuSA7u473tGBRf99FLpp3vvvI9cn77P2E8WzacS6NGVkUxiI8JXxpFo" +
       "wMeeuWP1FpGlr4zD85ClEn70DSihOGaEboLrhSMlvPB3o4SDEuCgePyhsimh" +
       "fu4+6vhc0bycQG/SIgMYPF2cVZ9EnHKjWN0mR0fYnXRZnLjqp0ClIn72jSri" +
       "OXDhR4rAX48iEuhKGFkbwPddtXHpVF2zEuCX76OILxbNKwl0DdiFHFmJgetq" +
       "CHz2WBkvvN4j/pt3UCm19fk3oK3yiJoE1/RIW9O/c7P5+WN5P/DNHAUZEZ8m" +
       "YZqUVF+9u/qPCcLfHMFephlhkUFKmv+iaH4tga5uC2WeGt6F8PTgJrD0Ux3/" +
       "+hvQcZkcnoXuSA4/9c0lh4uJuezQgnC3TxLnTaTMASWEq9944YZvbG/cBeC5" +
       "w8PD52994MZRgtmDlyNvJGv84X2zxpfvM/bHRfP7CfTwsWjF8/ZU+3/werSf" +
       "JdBj52UuzvmfvONzvP0nZNovvnzt4be/PPm35dchJ595PTKEHl6mrnv2WPbM" +
       "/eUwMpZWyfsj+0Pavcb+5G4B/6JXJ9BD1onZ/cc94lcT6B33QQTmevpwFu8/" +
       "J9D1i3iAfvl/Fu6/AgqncAl0eX9zFuTPQU4GIMXtX4THLoa8dowqXehU2dml" +
       "M6XfkS+Ui/jEay3iCcrZz1OKcrH84PK4tEv3n1ze1r7wMsN9+OuNz+0/j9Fc" +
       "Nc8LKg8PoSv7L3VOysNn7kntmNbl/vPfeOyXHnnvcSn72J7hUyc4w9u77/4t" +
       "Ss8Lk/LrkfxX3/7Fb//5l/+0PPv8f/ALNiYJKwAA");
}
