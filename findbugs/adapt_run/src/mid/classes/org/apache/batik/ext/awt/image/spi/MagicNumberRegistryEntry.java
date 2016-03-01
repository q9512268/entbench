package org.apache.batik.ext.awt.image.spi;
public abstract class MagicNumberRegistryEntry extends org.apache.batik.ext.awt.image.spi.AbstractRegistryEntry implements org.apache.batik.ext.awt.image.spi.StreamRegistryEntry {
    public static final float PRIORITY = 1000;
    public static class MagicNumber {
        int offset;
        byte[] magicNumber;
        byte[] buffer;
        public MagicNumber(int offset, byte[] magicNumber) { super();
                                                             this.offset =
                                                               offset;
                                                             this.magicNumber =
                                                               (byte[])
                                                                 magicNumber.
                                                                 clone(
                                                                   );
                                                             buffer = (new byte[magicNumber.
                                                                                  length]);
        }
        int getReadlimit() { return offset + magicNumber.
                                               length; }
        boolean isMatch(java.io.InputStream is) throws java.io.StreamCorruptedException {
            int idx =
              0;
            is.
              mark(
                getReadlimit(
                  ));
            try {
                while (idx <
                         offset) {
                    int rn =
                      (int)
                        is.
                        skip(
                          offset -
                            idx);
                    if (rn ==
                          -1)
                        return false;
                    idx +=
                      rn;
                }
                idx =
                  0;
                while (idx <
                         buffer.
                           length) {
                    int rn =
                      is.
                      read(
                        buffer,
                        idx,
                        buffer.
                          length -
                          idx);
                    if (rn ==
                          -1)
                        return false;
                    idx +=
                      rn;
                }
                for (int i =
                       0;
                     i <
                       magicNumber.
                         length;
                     i++) {
                    if (magicNumber[i] !=
                          buffer[i])
                        return false;
                }
            }
            catch (java.io.IOException ioe) {
                return false;
            }
            finally {
                try {
                    is.
                      reset(
                        );
                }
                catch (java.io.IOException ioe) {
                    throw new java.io.StreamCorruptedException(
                      ioe.
                        getMessage(
                          ));
                }
            }
            return true;
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMUZa2wUx3l8Nn5h4wfBuDyMMQYJQu6AhJDUhAQOAyZnsDAg" +
           "1bQ5z+3N2Qt7u8vurH2GUCBVC80PigJJaRvcqiVpSwmgNlGfoVRJSyglFBIl" +
           "IbShSX7kQZDgR+O0tE2/mdm93dt7INSqtbSzezPf9833/r4ZH7mKRpkGatGx" +
           "GsdBOqQTM9jFvruwYZJ4WMGmuRZmo9Kjb+/bPvJKxc4AKu1BY/qx2SlhkyyT" +
           "iRI3e9BkWTUpViViriIkzjC6DGISYwBTWVN70DjZ7EjqiizJtFOLEwawHhsR" +
           "VIcpNeSYRUmHTYCiKRHOTYhzE1rsB2iLoCpJ04dchAkZCGHPGoNNuvuZFNVG" +
           "NuIBHLKorIQisknbUga6XdeUoT5Fo0GSosGNynxbESsj87PU0HK85uMbe/tr" +
           "uRrGYlXVKBfRXENMTRkg8QiqcWfbFZI0N6MvouIIGu0Bpqg14mwagk1DsKkj" +
           "rwsF3FcT1UqGNS4OdSiV6hJjiKKpmUR0bOCkTaaL8wwUyqktO0cGaZvT0jrm" +
           "9on4+O2h/V9/qPbHxaimB9XIajdjRwImKGzSAwolyRgxzMXxOIn3oDoVDN5N" +
           "DBkr8hbb2vWm3KdiaoELOGphk5ZODL6nqyuwJMhmWBLVjLR4Ce5U9q9RCQX3" +
           "gawNrqxCwmVsHgSslIExI4HB92yUkk2yGud+lImRlrH1QQAA1LIkof1aeqsS" +
           "FcMEqhcuomC1L9QNzqf2AegoDVzQ4L6WhyjTtY6lTbiPRClq9MN1iSWAquCK" +
           "YCgUjfODcUpgpQk+K3nsc3XVwj1b1RVqABUBz3EiKYz/0YDU5ENaQxLEIBAH" +
           "ArFqVuQJ3PD87gBCADzOByxgfvrw9QdmN518ScBMzAGzOraRSDQqHYqNOT8p" +
           "PPPeYsZGua6ZMjN+huQ8yrrslbaUDpmmIU2RLQadxZNrfve5HYfJlQCq7ECl" +
           "kqZYSfCjOklL6rJCjOVEJQamJN6BKogaD/P1DlQG3xFZJWJ2dSJhEtqBShQ+" +
           "Varx36CiBJBgKqqEb1lNaM63jmk//07pCKF6eNB4eEJI/PE3RQ+H+rUkCWEJ" +
           "q7KqhboMjcnPDMpzDjHhOw6ruhaKgf9vumNucEHI1CwDHDKkGX0hDF7RT8Qi" +
           "j1M8SENyEpwhZOpyqBP3ydIqi8XUGtIHKckYaldhCDIv1P/P+6eYfsYOFhWB" +
           "6Sb5E4cCMbdCU+LEiEr7rSXt149GzwinZIFka5ai5cBEUDAR5EzwNAtMBDkT" +
           "QWAimI+JVs8CKirifNzGGBPuA8bfBGkE4Ktmdn9hZe/ulmLwW32wBCzHQGdk" +
           "1bWwm2+cIhGVjpxfM3LubOXhAApASopBXXOLS2tGcRG10dAkEofslq/MOKk2" +
           "lL+w5OQDnTwwuHP99jmcD2+9YARHQapj6F0sy6e3aPXniVx0a3a9//GxJ7Zp" +
           "bsbIKEBO3czCZImoxW91v/BRaVYzfi76/LbWACqB7AYZnWKIQEiWTf49MhJS" +
           "m5PcmSzlIHBCM5JYYUtORq6k/YY26M5wd6zj37eBiWtYhE6A5147ZPmbrTbo" +
           "bBwv3Jf5jE8KXjzu69YPvvHyB3dydTt1psbTIHQT2ubJbYxYPc9ida4LrjUI" +
           "Abg/H+ja9/jVXRu4/wHEtFwbtrIxDDkNTAhq/vJLmy9efuvQqwHXZykUdysG" +
           "fVIqLWQ5k2lMASGZn7v8QG5UID8wr2ldp4JXygkZxxTCguQfNdPnPvfRnlrh" +
           "BwrMOG40++YE3PnPLEE7zjw00sTJFEmsNrs6c8FEwh/rUl5sGHiI8ZHaeWHy" +
           "N07hg1A6IF2b8hbCM3CA6yBgMq/2xC1rGLutmEm7DDkJhhiwy9mxhpHNL5Zt" +
           "WeqUqlwoAvJBs/PcL1a8F+WGLmfxzeaZ7NWeyF1s9Hm8rFYY4FP4K4LnX+xh" +
           "imcTojDUh+3q1JwuT7qeAu5nFugnM0UIbau/vOnJ958RIvjLtw+Y7N7/6KfB" +
           "PfuF9USPMy2rzfDiiD5HiMOGexh3UwvtwjGWvXds2y9/sG2X4Ko+s2K3Q0P6" +
           "zGv//EPwwF9O50j2xbLdp97J3DmdiBv81hEilc49+LftX3ljNWSODlRuqfJm" +
           "i3TEvTShSTOtmMdcbvfEJ7zCMdNQVDRLWKE5p0NwHxSb/3zsBz853Vt2UYiZ" +
           "2+V8HdQ7W898V/vTlQBDYXvenY7SScwnmkHYX4kgFW+KNv9Xq3fMkONQtpeA" +
           "B3dLhqxTaE7b1QHZ0NQkUanTMvzvN2UKn57f7T1aH3562svbh6e9Db7Tg8pl" +
           "E+olBF6OjteDc+3I5SsXqicf5QWmhMWv7QyZR4Xsk0BGg88tVsOGDpFd59sx" +
           "wV6f9XwvorDJECV+P2Y/l6ZyeHdzVpvBz8Vuhfzo0rfe/fXI98qEqxXIDz68" +
           "xr+vVmKPvPMJD7SshiBHyvDh94SOPDkhvOgKx3crM8Oelsru6MAWLu68w8m/" +
           "BlpKfxtAZT2oVrLPoOuxYrF61wPaNp2DKZxTM9Yzz1DiwNCW7jwm+XOWZ1t/" +
           "T+BNBCU0I+jrhCWLEK+CGzjGDD7OZMNsUUzY5x0UiMoqVjjePVBjFaL2id7/" +
           "Pjas0l2rOkWI/W6kdvlicsARTFMJq4TOmmhEZS2YPv7CYi7/mJrlH53cL11l" +
           "L7gwUnzpscaq7A6UUWvK01/Oyu9I/g1OPfLhhLWL+ntvobWc4vMOP8kfdh45" +
           "vXyG9FiAn52FbbPO3JlIbZkWrTQItQw1M5m3CLtyuwijsmEWNx3/HUprGHEN" +
           "i1ScLLDGT3wbwQskZkJh8QLgButbpuTuiNqTOuU9zJafjX924feH3+LNWwrl" +
           "zhWc3F0FthpkQ6vp7eMzTem5DopKe1+9Vr3+2onrWekgs23txHqbGyLTWW4e" +
           "7z8zrcBmP8DddXLV52uVkzd4Nh6NJUid5moDTnSpjCbXhh5V9uZvXmjoPV+M" +
           "AstQpaLh+DLMzwuoAhp1YvbDYTCl3/+AKIGDrHOt5aKiLOF50FIRLBP5XDH/" +
           "XpfZ946FZ47d987xN/d26O/IHfrI10KXFyBFndsC9muBODSwkWtxpyC0Na9c" +
           "Pp5ZKzDX3mhuHp53u579pWw282FTNDrpnofZ1Aofr1+9RV7Zfcc8e7d5eXj9" +
           "WkFe82GDSmNWIpGbzb0F2EwVzuSlJr+OdI3LbV2HfPc2Hk48PoZYLEzOd7XG" +
           "m99Dj+wfjq9+aq7T4t0PW9o3ni4dUR4SaR6qGO1GeMI2D2G/Ll0F5FNkPtQC" +
           "2eNQgbWn2fBtiqr6CHSxOK6wLp+7t2uG79zMW7Ij1id4reNEK23uV9664PlQ" +
           "fcI55dQuvmOd4tuh6hbtpgbBSb7Z8cJ4zemizVHCmmFYOhzd2lMS0Vky5USe" +
           "ZcOPKCqTzU5Mpf6b9YtlMU1TCFYLtIyc7pFb13gKot5zC+bI0fYf3KpBEDRm" +
           "/RdA3FxLR4dryscPr3td9NrO7XIVnJsTlqJ42zHPd6lukITMJawSlUfnrxcp" +
           "ark5n3BqhJEL9oLAO0VRU2E8KOb87cX6PUWN+bBgDxi90GehgcsFDZAweiH/" +
           "SFGtHxL2528v3CsUVbpwkDfEhxfkNaAOIOzzdd0xZa3bY4peOVWUmbPS7jPu" +
           "Zu7jSXPTMjoK/r8hp5GzxH+HotKx4ZWrtl6/+ylxAyYpeMsWRmU0nJzEZVy6" +
           "GZyal5pDq3TFzBtjjldMdxJnnWDYjf+JnuxEITZ01mZN8F0Pma3pW6KLhxae" +
           "OLu79AL0JhtQEYaQ35B9qkjpFvRqGyK57hegVeY3V22V7/ae++TNonreqyHR" +
           "kzcVwohK+05c6kro+jcDqKIDXE2NkxQ/8iwdUtcQacDIuK4ojWmWmj6GjmFB" +
           "g9n/jbhmbIVWp2fZDSrERfbNTfatMvRYg8RYwqgzMtW+9tnSde8q12xYJCam" +
           "afC1aKRT1+0rq9Jernld53nlQ56a/g1ByQ5HAB4AAA==");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "BG/8jVd+/RNvvPJvwDwS9IgVg9KsE23ukvEv8Hz7zW988zff9cKXq/h+UJHj" +
           "au3HrpZKd1ZClwqcyohPnLn1+0qbvQRc/h8cvPrwm0Dh/9V8o0SWBhINCWSe" +
           "qpEVJKCcor2dFfmeq3vJaZL7f7/oIb7rZdM89FsJsO0+ORjvuLTIWR65Tzj0" +
           "yh04h+Ln/pvoKJ/8t/+1cpM7MshdIuQKvwS/+ZPPd7//mxX/OZSX3C/md+Zg" +
           "4D3nvMjPuv/56OXr/+QIeliCbqondw0L2UlLgJSAf8SntxLgzuLS+OWq91Di" +
           "vXqWqt53NUQvLHs1iZyHBuiX1JWrHvJG2Xw0vwZVsMlVHB+o2ltl870H9Cm7" +
           "fyoBk1qe7FR8TQDKju5tDtUaWjYfCfKzbTpFrfL/e5ITvCv1AEWz7+kldJ6O" +
           "HUoHyz8+u2EBg/ldNvzD997wYRVS51b/+if/4/Oz7zc//g5qhvdf2cWrU/7M" +
           "8M1fYb5H/StH0ANne3DH3cxlplcvW/6xSAe3X97skv1fONi/st/B+GXzwcrE" +
           "1f8Pn1kCqiwBVbTSfcZ+oGyWYLfU0tSHnbkP+e388Avfh0Yum/fHFyury3tw" +
           "4Q75tvrZ3/r2uxbf/offuSPeLhcSQzl49dwHXypzwrNXy0hWjk1A13xL+IGb" +
           "zlvfrQD6cVkFCBOLEShy80tlxwn1Qw//7j/6x+/9+G88AB31oMccX9Z6clXB" +
           "QY+C0kmPTVAf58Gf+dgBY7OylrhZqQrdofzBD5+r/l2v+tTlGuQZ8K2f1CD1" +
           "q4XWSVTZd48q6CyQDndFZ4F0s6JUymZ7EEC/p7BXxCkTSONEnMY9xAnfRpzH" +
           "3fP6vvKeKzJF71Cm8v4NOZEJuYdM+duZSEkN4+7i7N9WnEM+uQbqyIeQY/y4" +
           "yi+fuPuCD5wg3fW4OmAp//GnMjxrO+qt02pmoUcxcOlbtoOfAtnNc5A7HFFc" +
           "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" +
           "X7plfMCPKQAA");
    }
    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[]
      magicNumbers;
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    int offset,
                                    byte[] magicNumber) {
        super(
          name,
          priority,
          ext,
          mimeType);
        magicNumbers =
          (new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[1]);
        magicNumbers[0] =
          new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
            offset,
            magicNumber);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    int offset,
                                    byte[] magicNumber) {
        this(
          name,
          PRIORITY,
          ext,
          mimeType,
          offset,
          magicNumber);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        super(
          name,
          priority,
          ext,
          mimeType);
        this.
          magicNumbers =
          magicNumbers;
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        this(
          name,
          PRIORITY,
          ext,
          mimeType,
          magicNumbers);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    int offset,
                                    byte[] magicNumber) {
        super(
          name,
          priority,
          exts,
          mimeTypes);
        magicNumbers =
          (new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[1]);
        magicNumbers[0] =
          new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
            offset,
            magicNumber);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    int offset,
                                    byte[] magicNumbers) {
        this(
          name,
          PRIORITY,
          exts,
          mimeTypes,
          offset,
          magicNumbers);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        super(
          name,
          priority,
          exts,
          mimeTypes);
        this.
          magicNumbers =
          magicNumbers;
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        this(
          name,
          PRIORITY,
          exts,
          mimeTypes,
          magicNumbers);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers,
                                    float priority) {
        super(
          name,
          priority,
          exts,
          mimeTypes);
        this.
          magicNumbers =
          magicNumbers;
    }
    public int getReadlimit() { int maxbuf =
                                  0;
                                for (int i =
                                       0;
                                     i <
                                       magicNumbers.
                                         length;
                                     i++) {
                                    int req =
                                      magicNumbers[i].
                                      getReadlimit(
                                        );
                                    if (req >
                                          maxbuf)
                                        maxbuf =
                                          req;
                                }
                                return maxbuf;
    }
    public boolean isCompatibleStream(java.io.InputStream is)
          throws java.io.StreamCorruptedException {
        for (int i =
               0;
             i <
               magicNumbers.
                 length;
             i++) {
            if (magicNumbers[i].
                  isMatch(
                    is))
                return true;
        }
        return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LNPV0Y7n+aV1n0vFyWYa4rNFc7E2U0cq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("R4nrTT2uWGs0V26jMW8tOjIdzSOpyHV7TbDmnqUij417Uq9CNSdBo052kIWE" +
       "g4yEtzugWqrYzJRA5slULMHVmoh1jb7JLKrjRolacLrVAuGPYFBVXrp1TW84" +
       "FdkjtfZykAo9YyTTS79HjnrTRnXUiXHYCyQBnobL1CWCsQ8WKEYpLgFPLarK" +
       "sgbXJiD3mILmrRsTVSqOO92E6GNDY6VXwdJlUAlSoUSN/E7fHrZBbAIlfXct" +
       "tpW4OawzHEtucLk9HIktBbM3hKTBoMBfjcDCwEaLOkIsuoO5z4+Nlk7AEiKu" +
       "5xLP9Xu2YPLVqr3kg9UqRQzfqGM6IqY2tuY9v+MPl3XNTjp4gS/NapHhYyBE" +
       "1/TCmmQprdlnCSuih8ymovglgY00pKdTC4nqD0aT2GsWFqup2OxEPd+0FHoy" +
       "GIUIIWwK85nfnVVIGZmZXas6H45Fmk/LKb+csbMFrw7XS5vp9x13vOg4pA0n" +
       "kTwa9+CEKAYqiyqJURvDrXjIp3Abdstjvax1541Gtr11z61tb92Xb80dnYj/" +
       "ETblkrPeb4XQBVkJQl9Ww92pyvyTvRS/enB99Ub70g8ce7X1+hCqvoL343zo" +
       "67J14tV4dmLjoZsdos9P+X3mA889rw0+i5472DWth9BdoeP+hKnHunmMku1B" +
       "oekRFxkD0I8BCi8f7K5fPmNj/rR09nLpbJVw8w31vcfO6MvO3+w9HEL3zPWQ" +
       "02XNzI4vZoBPH+lt75FbfvGw4+/+7OHjgNRHDvh75NXhb++kXu8/PFpF224U" +
       "bjWY83f6rM8pvCtHR7JylJbj+5Eb6hqegEV5dpInH6SUNU+G0OXsCJvlArtR" +
       "TH2LcaPd2zsVxzF1eXciZQ++pVcYIfTAzc5oZOdxH7juPzfb/4moX3j+4oU3" +
       "Pj/+t9uDmof/5biLgS7MItM8fjLu2PV519dnRi7ju7ZnlPKX0ntvD6FHX95Z" +
       "Qug20GYs7L1ti9cMoYfPxguhO/Lf41g44PlmWGAO0B6HpkLodTeCBpCgPQ7Z" +
       "DaFLpyHB/Pnvcbh+CN29gwuh89uL4yAsGB2AZJece2g/tVcQTxoHoetkRNk7" +
       "FhQOvCYPkpdfzlSOUI4fUc9mzf+xdXimL9r+Z+ua+sXnO/33fL/62e0RedWU" +
       "0zQb5QID3bk9rZ8Pmp0LfPNNRzsc6zz1xA/v/eW7Hj8McvduCd558DHaHrnx" +
       "eXTccsP8BHn6z9/4z57+3PN/kL8s+799we+qSjcAAA==");
}
