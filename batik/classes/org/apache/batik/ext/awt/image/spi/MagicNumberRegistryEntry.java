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
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "1tWZ11+YERK0lgSIiMx+6MwHmKOPyNWUbcSJlXFY1tlSs3mUrLtWYK7neXcX" +
           "u2M+n/OkpcNzxUZZ2UcxvovuR6q5p5P2cNHLWkvdk1qBuGuySx/43yQsVl0T" +
           "qzcbGTtY2AMemZL2zDH2YjwaGv4MITp7fUgXbprMVvC+vesvhSkdKsqUaUsF" +
           "hwdLLZhY+irUFW6bNBCYKZC8uU5a+DjaNoR1kTlF23Lj3oQe5CweKyk/2etY" +
           "jPZ4Uq31eAmtNRJ4HWg9QeE5cTCmu2StvRemOTqqJamQG+oCGXXptFlLca2m" +
           "iUPNwoMpyq2nQztuUgvDsvB1o1cnmrUIrreBWhByNFGaoicOMD2a7BUkWmRS" +
           "jEmjTSNC8dFgELTpoTNtu/vhnKHWEcy3PTJlw3gSF/aQz/ucMSQFeDidGpyL" +
           "tQp53bOaVOy390rU8TOfHOkytVbqjmf1+8ZeylAa74YOi3R2jqPS9GxKo1Es" +
           "+mQYm8RMXhYUhhl2X1WFHbJqs3xuSYwOVuUfLZfrn31n2whPVTsmpyc1HJco" +
           "O374HewU3GNf6OhswLPvftWGUflw4aP/uc2mc3t5ULnb+MK9zmVUX5je+MRr" +
           "r2vs5+tHx7tQRAJdPT4uc0bnsMMtnPLwREn7OXB1j3noXt7wOhP+Xrtd99mH" +
           "/dn79P2jsnkjgZ4w9YTTZc0tP5lVe4pnqv78223KnCd6SbTrJ3t542PRxt+2" +
           "aCd7+8cbaM+cfAkY+WGa8Emky16F9+X74710+gWhQukGUZSGia71c1UPy43n" +
           "isg/L5svJdDDdszIiWrdbSPrYSUIXF32zzT2C+9EY3kCPX7uAMQJf7e+jQMV" +
           "wEyfu+OQ1+FgkvqF16898uzri/94+Mx4cnjoURp6xEhd9/w3n3PPV8NIN+xK" +
           "I48edt/D6vaVBHr57flMoAdAWwn2Swe8X02gF++Pl0APVffzWP8ugZ67FxYY" +
           "A7Tnof99Ar37btAAErTnIf9DAl2/DAnGr+7n4X4ngR47gwOefXg4D/K7gDoA" +
           "KR9/L7zLHu/hg1x+5WJUOTWcp9/OcM4FolcufFWpjv6dfIVKD4f/bqtffH08" +
           "/f5vNj9/OHuhunJRlFQeoaGHD8dATr9kfeCe1E5oXR1+6FtPfunRD56EticP" +
           "DJ/57zne3n/3gw59L0yqownFP3v2n3zkH7z++9WW8/8FGtGq9pMpAAA=");
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1wBr+GpfodfOQJDKZGuDe04LH3XFwVYC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("SwxY0fAgVtgNyjC6GFUCyvSQuJY1GvEow1Z1FrO8tmuw5YHbm7NNk1vMPbzj" +
       "6E4N9assltFGsGij7aW6qZgIPNbbW7E9RhejejpNhnFG060qwvMLf9DduLhK" +
       "YeaC3LZXbjkwBdZxNKajsik2X5LZKLVoW94SLkJZU4DaQkdK6Yo0cDSbrovU" +
       "nLOcdATZ5ZhrTeqLOIEabkIn/WyDWYLgQwNb9brD3ra5CHuJoauzCkTHVc8P" +
       "FMKWEZRW4e4o6DPbgOFHk7K9MvwwGCyWyGiMaUM4US0hjFBBs4NyrVmme9CS" +
       "9VrtRVAmY5Ij2pNw69Qpy5yyFi3M9SWleYlIDJ1WHc4CJ/P7VIakAMkCpT83" +
       "Ndpx0nKZnSt+tdxcSrjDV8v8ylGwaDpex2yyRJFFJfBdGu/WLCPoS1azYzQ6" +
       "JOFbYlADas30oTrhbDUYCDORV1OmzExpxkpQbQLF9liXXJp3JroTtY24lwpG" +
       "f4oSTWLreAmk432kM9wwtfqU6CNWT48W7aRcoShuMqriSXMkyBI9HoWZE6Kt" +
       "KZwx8BZFtDLWQPtNthO22+03vSl/PHb/7T0ee6h4tHeyM/6HeKiXXvR+LCrd" +
       "Iy3DKJDkaL/zsvjkL9WvHR1fu9lz7UdOvRp7WVRCf4D362wUqNL6zKv1fMfH" +
       "q261mb7YCfiJ9zzzrDL5ZPXS0VPXVlS6N3K9v2WriWqf0mS30WhxYkVuQOnH" +
       "gIZXjp7OX7ngwf557xwU3tkF4dYP5A+evOBevn/n4LGodP9KjRhVUux8i2PO" +
       "+MaTuB08ftsvLvb2PZxffA1Q9fEj+x5/Yew7OBvXh4+3ZhGOF0e7CBb2nd8r" +
       "dE7u6smWrkKk4wZB7EWq0ktl1ct3AhWNwDl5Q1S6km+BW3sgb5a2upO42dPf" +
       "u5eua6vSfkfLQfm2XoFEpUdutccj37P7yA3/vdn9X0T+3LMP3POKZ/n/sNvM" +
       "efyfjnup0j1abNund9adOr7sBapmFD6+d7fHqXipffDmqPTE8xdLVLoD0NyE" +
       "g5/YyWFR6bGL5aLSXcXvaakesPlWUqAPQE9zD6LSS2/GDTgBPc1JRqUHz3OC" +
       "/ovf03zjqHTfni8qXd4dnGaZgtYBS37IeMf50/wB8KR9BF1nEeXgFCgcVU0B" +
       "kleeL1VORE5vY897Lf65dbwnMN79d+u6/Plnh+O3fxf95G4bvWxLWZa3cg9V" +
       "unu3o79oNN9X+Opbtnbc1uXB67//kl+69zXHIPeSncL7Cj6l2+M337PeW3tR" +
       "scs8+1ev+Jdv/PSzf1C8bPv/6Xc+mFI3AAA=");
}
