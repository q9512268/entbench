package org.apache.batik.transcoder.image;
public class PNGTranscoder extends org.apache.batik.transcoder.image.ImageTranscoder implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
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
          1471188907000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471188907000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "H5of2UYUKv3e90IXnCyOfUbsQLdsZn+T");
        java.lang.String jlc$ClassType$jl5$1 =
          ("gu+ltE6Bz41INILXxMJ2zqfg7IGF7dyWgnOvkYXtbO2injG7cN0BO9kX+M7d" +
           "t3BC3kmvOO1cTMGl7aRuWUEPHFfQvSm4/7U0td3tjOop+HTG9uGbqeoNt2pS" +
           "Ow+l4JEUPPoa6uuNx/X1RAqejAPozqM3OtNuHZyjHrjqTvnmHrT8ay9cuP3+" +
           "FyZ/nGV3Du8qn6Oh27XQNI9eRDzyfNb1VM3IJnhuk9DJPo53ngqgx26aqgig" +
           "M8bB5/3OmzaITwfQ62+AGEDng2PJjQM8GHxKn8QD9LP/R8flAYXtOBBjNw9H" +
           "h5TA0QQMSR/L6YXJ65ztLt1ssY6kHZ+47gdNN9xc/78if+KFdu/HXyp/bHPj" +
           "Ehww1+uUCvhiuG2TTMuIpompx65L7YDW2dZT37nr1889eZDIvGsj8HbfHJHt" +
           "DddOc5GWG2SJqfVv3P8v3vKPX/hyduvv/wNpoD2QlTEAAA==");
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.image.PNGTranscoder ENT_ld =
          new org.apache.batik.transcoder.image.PNGTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PlexrPW8V1kEcC9eih0G83B37Y3antcMuPGW5etJVZpODV9bSuXNkFKwBdyy" +
       "6n1sPKrkfFhihjBt2piuxUlprk+nxGZQ5WYSh01mTa8uKmMWw7zmWjAsb9qp" +
       "2uuk2nX8vrXVCFSYc/gUlQe6pvKrVpVizN7ChDOC7LlApWwzQ02V6tVGaDeJ" +
       "XBBc3dU8U9wSEk6SCgp3LGZJav6qG6aaPh6m1JSZuEPM5cwuUWvWCEPUMaKd" +
       "0EYdjTsbKdLp6sTpJJsmqYuZECNtmUdXfcfsK91IGJQzQenFdtqSMLRN6u1I" +
       "FNIl+Bhcpy3aCr1Sme2RJGusHZswBDTosnI7aMYs1qlK9hjzwhY7HWVOwyXH" +
       "qAWCwBeqfWLd5vrrmqmZ5azMuh124GRzkfaw2YJr1SVZrXHzKOE7M2e5aCub" +
       "rhOg49FUnZrMBIfF5gxrjboiIirtVTMttZdNNcY9KilzZj1copzMayRjcdPJ" +
       "sF8vsaRfU80UURCp2afQWLAwelNBQ25W0zftGq1vpkylsp4qfQaRUnwU1Ler" +
       "fjYsr5elptfczAhkUGpTOkn7KdFqDIQ63x6rlpv4FX/Zi0i9txrwM5R0jWlp" +
       "wmdSC564atIiVk7NdTOm3vX6+tb0WgN81eVNXeQWk54cjImR3G0DPaeVahsW" +
       "Sm1XkTbdVCAMrCmY1c1i2WFrGIXA6VqJlInqOpqgdlf+JmNpUuiMmW682rI0" +
       "1lxvDY0I60gQaBJwCh7bjHQfaRAdtbs2DZ+ZjvhGmGRStFCRTbUplY1Mny6l" +
       "KeHV524/7tJZybLGWT1rzttiLBhTs+cuI8EmCa/XHvblbdZj7cXKoBGsnJAT" +
       "c2C18bbVxVHbqNiaO7IIeTPQe1HUk2W4z7eSbrBtDojYtk21BqsJOdsm/fo8" +
       "UpVAThtN8MVBVRaNbamakM3Yrm1obN5cukTYa63obo1kOmFEoHJ7QGhivKow" +
       "lKqFU8bqar1Wf90j1h0x0yVh7M7nGR9PJlw9K8HUnBinvYbNyGwi4CpBMyOm" +
       "J1cwrxfHIrXd1haZXk10URTWZW9kd1vLKUolJN1oNL2sE5OYO/SRCjILJ1zQ" +
       "JLzWZkrFQgprHqZ2SuuWT8qIbAwXzawmbBRYDpUaOwlIdj0WtAFcRTareUrU" +
       "VXXe0SSvbjLTNYtOgJEoU5aaALZiskWuUU1G4pjCrM6IjFv9tEknHTlew3XC" +
       "GbOUNVgJpD9AWMfjo5KF2zgPll+5N1AqzeYWTpkewllTlSrNsE2rvFnpPRyh" +
       "Z7i6Xg3VAYYmnW5t26k3kyqTNGtsp6FPzaQ9HPEtxGgOiZDUJ/FmsBli4VDT" +
       "MwclwCruowq7rE+1mNIwcwYskRjr0iRaqcPSWApTW5izDY7eWJIYtcazfn3V" +
       "nKvTxZQwQrU8G+tJH+6UbbQZkKtaZ63gzVUji/iN1lltdQt1kHrY8XxPXW8x" +
       "AROdIE5ig0f8apol1aDjY2MOGS7w1Ji2XSxdmVZ3tq6NksCFDUZW2skwHa08" +
       "sYxLYjecuOxm7tbarRaTdChawrVtdxWKeqOvVJOANHmhMRADrFpVUswcqVut" +
       "EwysDb1qNQKakcp83xfdKtwkN/pwSWmmE+tObxiVSpyFNKSlPcj6FXHgTFuJ" +
       "b7YqPumufF1qWTG9IflRZx4yzf7EUmhOV1QV386pZNyt17S+5Nu87lRbXEmq" +
       "LvRQ7iODmANAjTtuQI/01mC65lltoRvZptTregqyTZKlPtRWuFyrbJCZuunX" +
       "SBfoq22RDhqPGvY2ayoktVZXKZjMLbFZjkmv6YscXWqXGkiNUcqDWo/pcaoa" +
       "JbChb7dInel7eq/lj7pSY71g0u2MYRnDaoGUhK0h3ZLqlWQEYJpEN+VaMI8W" +
       "xgQmKmLbpWAWhmttF1+s2rU4BKsN3JnbFa2E1lbbeo30VV3CbVlorxVrGDWF" +
       "WRvvZkrZjuY2HW/bpOJ3SkuxkYabYMIhNI1022JVijWRsUjSVTl/Me0Oxx1s" +
       "MrbX4/5MCaROI+oEZtjvdhE2mM1YZDxKV0tTdabL9RLdpIMmS1Xny+1wMOVt" +
       "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" +
       "vebrh+q+74c521YCOo78OCq4/umtrX/I");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8I43vI4ZYqmk+PmhV8HzW3nxRgRd3uTGPPa7sxv7iWecgKdvvgUbFwvBs9C5" +
       "heAzP9xCcHbFKiokz9/uFoRTHlLAfUFgy9c+cM1VNtfOtz+/v7//wo33XTtY" +
       "SnbURctbWR/+2x3Xh+/foe3P8+K/RND9h4rlv//ese3/693YPgXrzCmV8ztK" +
       "j5+7R7y7+yp94dUr97/z1dm/2d0fOLyf+gAJ3a/Gtn3ySsmJ94t+oKhGIfoD" +
       "uwsmhcHyE7bzYH82oiPoPuPQ5y5Au473RtC77tAR+Orxj5P9LkXQ1bP9AP/i" +
       "/0m6y4DDMV0EXdy9nCR5OILuAST56yP+YXxV3hyfivg5NnZ64URCdBAIxRw+" +
       "9mZzeNTl5NW6/Hi7uCl+eBQd7+6K35S++CoxfvF7jV/eXe2TbDHLci73k9Cl" +
       "3S3Do+PsZ27L7ZDXxeELP3jkNx54z2GC98hO4OMYOCHb07e+R4c5flTcfMv+" +
       "yTt/8/2/8uqfFMeQ/wdslp1dwi8AAA==");
}
