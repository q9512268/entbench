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
    public static final long jlc$SourceLastModified$jl7 = 1444739551000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1YfWwUxxWfu/PnYfAHYCgBA+ZAMR+3QSFBlWkLuDYcPdtX" +
                                                              "m1DVtBzj3Tnf4r3dZXfWPpy6QPoByh8oAofSKPgvorYRCVHVqJWqIFeVmkRp" +
                                                              "GkGjNh9q0qp/NP1ACv+EVrRN38zs3u7tnU3yX0+6ubnZ99689+a933uzV2+h" +
                                                              "WttCnSbWFZykJ0xiJzNsnsGWTZQeDdv2QVjNyo//6cLJO79tPB1FdSNoSR7b" +
                                                              "/TK2SZ9KNMUeQWtU3aZYl4k9QIjCODIWsYk1galq6CNouWqnCqamyirtNxTC" +
                                                              "CA5hK41aMaWWOupQknIFULQ2zbWRuDbSnjBBdxo1yYZ5wmdYVcbQE3jGaAv+" +
                                                              "fjZFLeljeAJLDlU1Ka3atLtooS2moZ0Y0wyaJEWaPKY95DriQPqhCjd0vtD8" +
                                                              "0d0n8i3cDUuxrhuUm2gPEdvQJoiSRs3+aq9GCvZx9E0US6NFAWKKEmlvUwk2" +
                                                              "lWBTz16fCrRfTHSn0GNwc6gnqc6UmUIUrS8XYmILF1wxGa4zSGigru2cGaxd" +
                                                              "V7LWO+6QiU9ukWa+d6TlxzHUPIKaVX2YqSODEhQ2GQGHksIosew9ikKUEdSq" +
                                                              "w4EPE0vFmjrlnnabrY7pmDoQAp5b2KJjEovv6fsKThJssxyZGlbJvBwPKvdf" +
                                                              "bU7DY2Bru2+rsLCPrYOBcRUUs3IYYs9lqRlXdYXHUTlHycbEl4AAWOsLhOaN" +
                                                              "0lY1OoYF1CZCRMP6mDQMwaePAWmtASFo8VibRyjztYnlcTxGshStDNNlxCOg" +
                                                              "auSOYCwULQ+TcUlwSqtCpxQ4n1sDu849qu/XoygCOitE1pj+i4CpI8Q0RHLE" +
                                                              "IpAHgrFpc/oibn/pbBQhIF4eIhY0P/3G7d1bO+ZeETT3VaEZHD1GZJqVr4wu" +
                                                              "ubG6p+uzMaZGg2nYKjv8Mst5lmXcJ91FE5CmvSSRPUx6D+eGfvXVU8+Sv0dR" +
                                                              "PIXqZENzChBHrbJRMFWNWPuITixMiZJCjURXevjzFKqHeVrViVgdzOVsQlOo" +
                                                              "RuNLdQb/Dy7KgQjmojjMVT1neHMT0zyfF02EUD18USd8u5D43M8Gis5LeaNA" +
                                                              "JCxjXdUNKWMZzH52oBxziA1zBZ6ahjQK8T++bXtyp2QbjgUBCfMdkmGNSRgi" +
                                                              "I08EAc9VPEkltQABIcmAT7KYqyB+YN9BC+s2W7VSbDE1+BVLpWSPgk2IwCSL" +
                                                              "TfP/Uqsi8+XSyUgEjnl1GGQ0yM/9hgbsWXnG2dt7+/nsayKAWdK5p0BRP6iV" +
                                                              "FGoluVockkGtJFclydVKumol76UWikS4NsuYeiLgIFzGAXgA+Zu6hr9+4OjZ" +
                                                              "zhhEujlZA2fNSDdVVMIeH6G8spKVr94YuvPG6/FnoygKIDYKldAvR4myciSq" +
                                                              "qWXIRAE8nK8weeAszV+KquqB5i5Nnj508gGuR7DCMIG1AI6MPcPqQmmLRBhZ" +
                                                              "qsltPvPBR9cuThs+xpSVLK/SVnAy6OoMn33Y+Ky8eR1+MfvSdCKKagAPoQZQ" +
                                                              "DDkL8NoR3qMMwrq9csBsaQCDc4ZVwBp75GF4nOYtY9Jf4UHZyoblIj5ZOIQU" +
                                                              "5JXkc8Pm5bd+89cHuSe9otMc6BaGCe0OAB0T1sYhrdWProMWIUD3h0uZC0/e" +
                                                              "OnOYhxZQbKi2YYKNPQBwcDrgwe+8cvzt99+78mbUD0cKld4ZhaapyG1Z9jF8" +
                                                              "IvD9L/sycGILAqTaelykXFeCSpPtvMnXDUBTA4hgwZF4RIfgU3MqHtUIy4V/" +
                                                              "N2/c/uI/zrWI49ZgxYuWrfcW4K9/Zi869dqROx1cTERmRdv3n08mKsFSX/Ie" +
                                                              "y8InmB7F0zfXfP9lfBlqCuC4rU4RDs2I+wPxA9zBfSHx8cHQs4fZkLCDMV6e" +
                                                              "RoHmKis/8eaHiw99eP0217a8Owueez82u0UUiVOAzTYgd/BKBf9lT9tNNq4o" +
                                                              "gg4rwqCzH9t5ELZjbuBrLdrcXdh2BLaVAZDtQQsArFgWSi51bf07v/hl+9Eb" +
                                                              "MRTtQ3HNwEof5gmHGiHSiZ0HTC2aX9gt9JhsgKGF+wNVeIg5fW314+wtmJQf" +
                                                              "wNTPVvxk1w9m3+NRKMLuPped/9nIx/vZsEUEKZtuLZZcwz91XvX0fgOuCciM" +
                                                              "8PlKinZVoD4twboL/GVQnwiCPPP1mvm6Jd7pXXlsZlYZfGa76GnayjuQXmiw" +
                                                              "n/vdf36dvPTHV6sUpEZqmNs0MkG0MsUttL6iUPTzZtIHuZ0378TePb+yqbJG" +
                                                              "MEkd81SAzfNXgPAGLz/2t1UHP58/+inAf23IUWGRP+q/+uq+TfL5KO+HBe5X" +
                                                              "9NHlTN1Bl8GmFoHGX2dmsZXFPHU6S/GxiIVDAr4PuPEhhVNHoDQPNjb0lFh5" +
                                                              "GMY9liqsIWSI8bOKeUEmfcog8/hW85TxW5C9To6VJIX3Gx7R1oWE+zIHHWo6" +
                                                              "lJt4KKRtpDwlFtTWF9hblInJzpzLPMKGL1MUn2T5IRS0UNcC11tLLUA1m3Av" +
                                                              "CNJ02/vjT3/wnEiU8G0iREzOzjz+cfLcjEgaceXaUHHrCfKIaxfXtIUN24o8" +
                                                              "jxbYhXP0/eXa9M9/OH0m6qJ8iqKaCUMV17adbBgS+NP9yWCQLewuUrTuXu0j" +
                                                              "A8yVFbdlccOTn59tblgx+8jveQtTuoU1QYeQczQtkBDB5KgzLZJTuRVNoqaY" +
                                                              "/EevFkELdL4U1bszbl5BSDkOPdonkUJRLf8N8lLovRbmBS61FPIu1yRc9+bj" +
                                                              "oigGY5B6iqJl1aiBEsYg5TRFLWFK2J//BulOQaz7dNAviUmQ5FsgHUjY9Num" +
                                                              "l10tPKfZDT8prrPFSGWt2ym6xnuEVokl2OYxF/C3MR7MOuJ9TFa+Nntg4NHb" +
                                                              "Dz8j2kxZw1NT/PaeRvWimS1B9fp5pXmy6vZ33V3yQuNGLzHK2tygbjziAVx4" +
                                                              "S7gq1HfZiVL79faVXddfP1t3E1L6MIpgipYeDrwLEZ6C5s2BOnI4Hax/gXd6" +
                                                              "vCXsjv/56Bv/fCfSxvsIt2J2LMSRlS9cfzeTM82noqgxBaGmK6Q4guKq/cUT" +
                                                              "+hCRJ6DjaXB09bhDUgok0qjh6KUXN0tY+mH2poZ7xnXo4tIqu4FQ1FkJTpW3" +
                                                              "MmixJom1l0nn5StU3BzTDD4tshcaVayCs9l++V8nv/vWIMBDmeJBafW2M1qq" +
                                                              "k8H3Qn7hdHFSNPmxbLrfNN2mv/EyP1XT5Hh2iRt9UVAzCooim03zf26ebpbf" +
                                                              "FQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2PzB63/vbb/13Lfzwuf/APQA/CXHIQAA");
}
