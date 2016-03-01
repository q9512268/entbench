package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    private boolean decodePaletteAsShorts = false;
    private java.lang.Long ifdOffset = null;
    private boolean convertJPEGYCbCrToRGB = true;
    public TIFFDecodeParam() { super(); }
    public void setDecodePaletteAsShorts(boolean decodePaletteAsShorts) {
        this.
          decodePaletteAsShorts =
          decodePaletteAsShorts;
    }
    public boolean getDecodePaletteAsShorts() { return decodePaletteAsShorts;
    }
    public byte decode16BitsTo8Bits(int s) { return (byte) (s >> 8 & 65535);
    }
    public byte decodeSigned16BitsTo8Bits(short s) { return (byte) (s + java.lang.Short.
                                                                          MIN_VALUE >>
                                                                      8);
    }
    public void setIFDOffset(long offset) { ifdOffset = new java.lang.Long(
                                                          offset);
    }
    public java.lang.Long getIFDOffset() { return ifdOffset;
    }
    public void setJPEGDecompressYCbCrToRGB(boolean convertJPEGYCbCrToRGB) {
        this.
          convertJPEGYCbCrToRGB =
          convertJPEGYCbCrToRGB;
    }
    public boolean getJPEGDecompressYCbCrToRGB() { return convertJPEGYCbCrToRGB;
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
       "oX/6OIS96Xx4OTXt+eBysgqAegFd1K+diycPFFJGwcMeuhp7Pp5cgMrKd5Yo" +
       "byvLm0Xxr47c90oQmluQGBz679fA7wJ4/rl4isGKhv0y/nDnMJd463EyEYAF" +
       "6lHtcMlx9DjWiYhf+2Ec3V3ZXGi6IEJtD9Mq+LmHP2//5F/8wj5lOq/Zc8D6" +
       "+5//wa8dfPD5i6cS1bffkiuextknq6XoXlcUZOErb7vbLCUG9b8/8dxv/Oxz" +
       "79tT9fDZtKsLvip+4b/+388efOQLv3+bVfuK4vuOLnv7cF6UaFG8ey/l+h2d" +
       "59vOqvZJ8AwPVTu8g2ond1BtUe2UTJMxdJ9pHGZ3JdyjMfRg6feFmR6wvrc6" +
       "R+j0FRKKgGd0SOjoDoRKL4fQR4E7bcFSTHPd3rKjdELBn/baRSd9jsTv+rok" +
       "7nV9ARj5JfQAP6gW/+XbE3FPUf1msJhF5acawDBMT3aOqHqj5ag3j8x/Dj7d" +
       "QCS6aTn4kTBvnAhz/71zjlbyZdMKLPOcZp7+wJ9/6LM/8vbPAyujoUvbIsoA" +
       "czw14ygpvib/3cc//Ob7n//CB8q1GUiVe6F7493FqM7dOC6K0mqNI1YfL1jl" +
       "y/SXlaN4WC6nunbMbe8UP0wMFuVbjeflcxtf/2S/Fg2Io99wLhmL9gyZinBS" +
       "tdF+OuFX/mTQ61BdacU0RDjrkPPZukusk9T2zUwmEqUF65iQ1Sot3NoqW7rr" +
       "J35/ElrWICX5UZeBM6Hv2NR6bIUxQvfNmFpq8QSfRYvGEHUDD2YmllGfLjfK" +
       "wsO4GMVaCdbP2k4QOHUNgRMOZIBqs9aqY8Z4q8MpM6cdVxZGNsvXqB6vkKJP" +
       "DeCVbs9yNgvjWa4Mej6pbjiYxLD5tg87NO7Vm9125NoD1ds4vMhqZjyz5glZ" +
       "b9NUVDftXBM2/o4f99s9QYwnqhOYplwb2RuXRQIim9vThbhpqkF3k093ZEdi" +
       "Scplwm7V32Foe5CpvUTh1+yq6qtzfRXV0o2kIUucI4ckyvlqhKzDSSDtUNZW" +
       "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");
}
