package org.apache.batik.transcoder.image;
public class TIFFTranscoder extends org.apache.batik.transcoder.image.ImageTranscoder implements panda.runtime.PANDA_Attributable {
    public int PANDA_attribute() { return org.apache.batik.apps.rasterizer.PandaMode.
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
          1445630120000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "efjO5659ruBGDjheLzSM/wHbrivnyiIAAA==");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "mfEbIs6dCxk4ty/OndsycP4N8lmnDrHq");
        java.lang.String jlc$ClassType$jl5$1 =
          ("GfhsPuLFG8p7Jz+h79z9QwfJ3QM57WRXl3YuZeDy4cxet5QeOC6lezNw/xvv" +
           "2XcevpVs3vp6ZPNQBh7JwKNvoGzedlw2T2TgyTSG7jx6KzNrNsC284Frro1v" +
           "rzorn3rx4u33vzj6ozzTc3Ad+XwPul1PHOfoZcIjz+eCUNPNfILnt8md/Jy8" +
           "81QMPXbLtEUMnTX3T/o7b992fDqG3nKTjjF0IT6W59jvB4Pj8cl+gH7+/yhe" +
           "CVA4xAMRZPtwFAUD2zeAkj1WskuPN9gJX76Vso6kIJ+44fmPSbY3/K8qn36x" +
           "w/7Uq5VPbG9Ngu34ZpNRAQes27aJtZxolqR67IbU9mmdo5763l2fOf/kflLz" +
           "ri3Dh2vkCG9vvX7Kq+kGcZ6k2vyz+z/7Y7/y4tfym3v/D3fuj/F4MQAA");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "67MpPMNILhGPm9H/TdzcCE+77fztZeImmAbh4FCjG/Io7D6QASeV4RhQiWMm" +
       "W/ImLjlWRhHrZotv4LEyejyMzUGoqwGF7jJkRtslQWfUcDiuvdYjf2sBF67s" +
       "Q/+1svnJsQueLbZqtlw7SJWaWhyk8OcBRxHLP0mBRY3+LNOzjG/lWHlbRT8Z" +
       "w86cSHVMr5znCWyOMlI/hlp2HXq3Hfr4dT8jlaOaLLnK//a1Kz/HyBS/YfEk" +
       "M6vgbtm6DxVPHG6snXl483l+n5C/s2wAJE5lFcVbaHveq3WDpmQuV4NVdlvR" +
       "/2yx/Bd0O6ik5bz4P7EmnoJaucxEUJv7wzvvNEROcB7w599euheAg0sHRb31" +
       "4iV5EXAUSPD1jO6YeuXVg4ib0lV2LuSvNfOmnHE1U3rK08W+HMX/PXBgPGv9" +
       "fwAJ9vCdffdeWn3UulARFWFiArlMAvC27nbyNdyiktwcXtXdS69MearuBien" +
       "TLU27IblHA/wrIMXPBt7s0vBf0EJ8fzXDo7Pf07/YRgry8ApM3Ceg4P6GDXW" +
       "a1lVshNOFab9/MVUVte9w4GDHt9ZFTzLbIy48WrwwkNOL6hs8Pd+KxytGqIC" +
       "9qUHugH8KzKyFOwOQ+im5ZG0rx+rEsiN63S+j/M5XS+AFKwrimRpKPD5PVBC" +
       "PPj8hXhK1x8Lk7oYBI4q0Rw/ZW8YVweoOGr4Unh1EpXk6G0KRrOAyYSb2faO" +
       "yflevF1kpKWwSCm8cS20kK+EL2YgnyZDn9X5pVOIkNpXi6az6ZaS3sHmK7n/" +
       "AM2ao7/+HAAA");
    public panda.runtime.PANDA_Attributable PANDA_copy() {
        org.apache.batik.transcoder.image.TIFFTranscoder PANDA_ld =
          new org.apache.batik.transcoder.image.TIFFTranscoder(
          );
        return PANDA_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uiiQW0GO9SAKauFE8PEuMiFUDZ4ja1NFiUy04Gmjj4DUixoZxzVNrd21A2fh" +
       "SGWil7glfVoPt+GMnoZWNauwpmduo8pwtM0wcwTPdM7eVqhKJST0WdmoUiqp" +
       "66UecPCoojoOjFp1oS+KFjJuEpM+pUh9Gav0Jao3wkfbMuZwXLeSRNOoCXb6" +
       "XUsaVjsuyKieW7JR15W6jk6S9a1cqhvyENX9pFJvbeaMGfRNc1OCK5TfrNfW" +
       "gzUQHBy6njWlSAwrN5dYpmWrCWXx/QA4Tr/Wk2ClK9mbkUHG8aKKLn1HnqjD" +
       "CIs9rAJqB2WChQwmR4t1p9tdzIJqdS0ESLVddVW8zTQGZEzXFdUUKqxWElLU" +
       "byhpJ7IxY6aqDcRGvJE6ajiDMRk3Z5KqVytKw5hUaLybrfx2JY0q8iArd+PM" +
       "G49mSB1fT+ZLvrow5AVWmmh8oyRXOVwVawkbCybizasrXls150EPlYVqw9Bq" +
       "U55EjXmwrm0S2hNqG7424sh6E67VeGWNo5hVQcazXlPolARuGXl84GLeFh91" +
       "ba6hN1cGsm7WG+URbnqVIb5GpnBgzjCHyOryotvS1E2Wpt0o20ZUytnrdTxY" +
       "rNaVrr0lQ2yU6GgPUUvNZlUrYf0qu5nNljKRRGUatQyailPFLC+rmrhsYrW0" +
       "hK5Wa4+vZ+ZsOawusQCNnaFXmnGbNeCdF4Fjl+dqezBFHCL0e4Mh49KxxiEL" +
       "dCLIjVUQsm7Y6QULiug7bcxoRQRTN6YSRs9irLRooEzIMyw9sLq816TgsbZV" +
       "yXYJRY1tIuu05+Fzq9YhnS5MB2irMcQFXayNLOACjCfBtDdwXGlkUZEcJKva" +
       "oL3RnQ2znXSDZdbtoE5vMUpidygZE7Vlpytt5hjVmOg00HgIlyogY4MKPdUH" +
       "c3mZuBkq9CRFsjYLjFOJ0Zoa8GWPAKotDVhuCwhwJcqdj8aYnGENVaBEJqpv" +
       "fVLacIBh2HLDKjVdIpQR1bQx5rgKpwwGfh+GlUp/C1MbQoBnRnvBNFbmPPEa" +
       "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");
}
