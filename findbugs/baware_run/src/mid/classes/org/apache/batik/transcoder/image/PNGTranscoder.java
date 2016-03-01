package org.apache.batik.transcoder.image;
public class PNGTranscoder extends org.apache.batik.transcoder.image.ImageTranscoder implements panda.runtime.PANDA_Attributable {
    public int PANDA_attribute() { return org.apache.batik.apps.rasterizer.PandaMode.
                                            LOW_MODE; }
    public PNGTranscoder() { super();
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
    private org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter getWriteAdapter(java.lang.String className) {
        org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter adapter;
        try {
            java.lang.Class clazz =
              java.lang.Class.
              forName(
                className);
            adapter =
              (org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter)
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
        java.io.OutputStream ostream =
          output.
          getOutputStream(
            );
        if (ostream ==
              null) {
            throw new org.apache.batik.transcoder.TranscoderException(
              org.apache.batik.transcoder.image.resources.Messages.
                formatMessage(
                  "png.badoutput",
                  null));
        }
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
        org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter adapter =
          getWriteAdapter(
            ("org.apache.batik.ext.awt.image.codec.png.PNGTranscoderIntern" +
             "alCodecWriteAdapter"));
        if (adapter ==
              null) {
            adapter =
              getWriteAdapter(
                ("org.apache.batik.transcoder.image.PNGTranscoderImageIOWriteA" +
                 "dapter"));
        }
        if (adapter ==
              null) {
            throw new org.apache.batik.transcoder.TranscoderException(
              "Could not write PNG file because no WriteAdapter is availble");
        }
        adapter.
          writeImage(
            this,
            img,
            output);
    }
    public static interface WriteAdapter {
        void writeImage(org.apache.batik.transcoder.image.PNGTranscoder transcoder,
                        java.awt.image.BufferedImage img,
                        org.apache.batik.transcoder.TranscoderOutput output)
              throws org.apache.batik.transcoder.TranscoderException;
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "ctc+X3AjB5yuFxrG/wAkQFZNxSIAAA==");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "LqTk3BGce7en5Pzr5LP2t63qKflsNuLF");
        java.lang.String jlc$ClassType$jl5$1 =
          ("G+K9l32g793zQwfJg2Oc9tJbS3uXUnJ5O7PXjNKDJ1G6LyUPvP6efe+RW2Hz" +
           "pteCzcMpeTQlj72O2Lz5JDZPpuSpOIDu2r2QmVarYNv54DXXxTdXnKVPvXDx" +
           "jgdeGP9Rlug5voZ8noTumIemuXuPcOf5nOspcz2b4PlNbif7Tt57OoAev2XW" +
           "IoBu04++9Pfesun4TAC98SYdA+hCcCLPcdQPBp/Hp/sB/tn/3XZFwGHbDkSQ" +
           "zcNuExRs30CT9LGc3ne8wU748q2UtZOBfPKG33/9cHOz/6r06Re61E+9Uv7E" +
           "5sIk2I4nScoFfGDdvsmrZUzTHNXjN+R2xOtc++nv3f2Z808d5TTv3gi8XSM7" +
           "sr3p+hmvhuUGWY4q+ScPfPbtv/bC17JLe/8Py3EYOnAxAAA=");
    }
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_GAMMA =
      new org.apache.batik.transcoder.keys.FloatKey(
      );
    public static final float[] DEFAULT_CHROMA =
      { 0.3127F,
    0.329F,
    0.64F,
    0.33F,
    0.3F,
    0.6F,
    0.15F,
    0.06F };
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_INDEXED =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public panda.runtime.PANDA_Attributable PANDA_copy() {
        org.apache.batik.transcoder.image.PNGTranscoder PANDA_ld =
          new org.apache.batik.transcoder.image.PNGTranscoder(
          );
        return PANDA_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8UYMXd7kxjz2u7Pb9GvfOgFP33gLNi6W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("g/dC55aDv/f9LQfnV66DKsUPst3CcMpLCtA/IHHUaz9+zdM2185TPL+/v//C" +
       "jfdfO1hUDumLtreyUvy3O64Uf3GHtr/Mi/8CZuZYvbzm7x/Pwn+9m1lIY+jh" +
       "U2rn95IeP3eveHcXVvn8q1fuf+erwr/Z3Rk4vK/6AAPdryeOc/IayYn3i0Go" +
       "6VYh/AO7SyWFyfKTs/Owfza2Y+g+69D7LkC7jvfG0Lvu0BHY5vjHyX6XYujq" +
       "2X6Af/H/JN1lwOGYLoYu7l5OkjwcQ/cAkvz1keAw0pA3R6oiko6NnV44kSAd" +
       "hEQxh4+92RwedTl5nS4/ti5ujh8eMSe7u+M3lS+82hu8+N3ar+yu8ymOvN3m" +
       "XO5noEu7m4VHx9TP3pbbIa+L9Avfe+Q3H3jPYcL3yE7g4yg4Idszt747R7pB" +
       "XNx22/6Td/7WB3711T8tjhf/D4Irw3vSLwAA");
}
