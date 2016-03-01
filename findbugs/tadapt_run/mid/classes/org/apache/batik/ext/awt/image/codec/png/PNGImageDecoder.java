package org.apache.batik.ext.awt.image.codec.png;
public class PNGImageDecoder extends org.apache.batik.ext.awt.image.codec.util.ImageDecoderImpl {
    public PNGImageDecoder(java.io.InputStream input, org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam param) {
        super(
          input,
          param);
    }
    public java.awt.image.RenderedImage decodeAsRenderedImage(int page)
          throws java.io.IOException { if (page != 0) { throw new java.io.IOException(
                                                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                            getString(
                                                              "PNGImageDecoder19"));
                                       }
                                       return new org.apache.batik.ext.awt.image.codec.png.PNGImage(
                                         input,
                                         (org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam)
                                           param);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYb3ATxxVfyf+FwX8AQwwYMIIpTqIrk6Q0EU1jhI1FZFu1" +
       "CTM1bcTqtLIOn+6Ou5UtO3EJzKS4+cBkgpPSTPAnMmkzJGQ6zbTTThh32mmS" +
       "SVMGmrb5M03a6Yekf5gJX+J2aJu+3T3pTifJIZ+qGa1Ou+/tvvf2t7/39i5c" +
       "Q3WWiboNrKVwiE4bxArF2XMcmxZJRVRsWQehNyE/9uczx5d+23TCj+rH0KoM" +
       "tgZlbJF+hagpawxtUjSLYk0m1hAhKaYRN4lFzElMFV0bQ2sVK5o1VEVW6KCe" +
       "IkzgEDZjqA1TairJHCVRewKKNse4NRK3Rur1CoRjqFnWjWlHobNEIeIaY7JZ" +
       "Zz2LotbYUTyJpRxVVCmmWDScN9Gthq5Oj6s6DZE8DR1V77IDcSB2V1kYul9q" +
       "+eTG45lWHobVWNN0yl20Roilq5MkFUMtTm+fSrLWMfQtVBNDK1zCFAVjhUUl" +
       "WFSCRQv+OlJg/Uqi5bIRnbtDCzPVGzIziKKtpZMY2MRZe5o4txlmaKS271wZ" +
       "vN1S9Law3R4Xn7xVmv/ug60/rEEtY6hF0UaZOTIYQWGRMQgoySaJafWmUiQ1" +
       "hto02PBRYipYVWbs3W63lHEN0xxAoBAW1pkziMnXdGIFOwm+mTmZ6mbRvTQH" +
       "lf2vLq3icfC1w/FVeNjP+sHBgAKGmWkM2LNVaicULcVxVKpR9DF4PwiAakOW" +
       "0IxeXKpWw9CB2gVEVKyNS6MAPm0cROt0gKDJsVZlUhZrA8sTeJwkKFrvlYuL" +
       "IZBq4oFgKhSt9YrxmWCXOj275Nqfa0N7Tj+kDWh+5AObU0RWmf0rQKnLozRC" +
       "0sQkcA6EYnNP7Cnc8cqcHyEQXusRFjI/fvj6fbd1Lb4mZDZUkBlOHiUyTcjn" +
       "k6uubIzsvLuGmdFo6JbCNr/Ec37K4vZIOG8A03QUZ2SDocLg4sivvv7I8+Tv" +
       "fhSIonpZV3NZwFGbrGcNRSXmfqIRE1OSiqImoqUifDyKGuA5pmhE9A6n0xah" +
       "UVSr8q56nf+HEKVhChaiADwrWlovPBuYZvhz3kAINcAXNcP3biQ+/JeiaSmj" +
       "Z4mEZawpmi7FTZ35zzaUcw6x4DkFo4YuJQH/E7fvCu2WLD1nAiAl3RyXMKAi" +
       "Q8QgP6d4ikpKFsAgycBNsmQA0OJD+6Osax9hfWaIQdD4fy6eZ5FZPeXzwaZt" +
       "9FKGCqdtQFdBNiHP5/b2XX8x8YaAIztCdkwp+jJYEBIWhLgFnGDBghC3IMQt" +
       "CIEFIY8FyOfjC69hlgikwD5PAGMAZTfvHP3mgSNz3TUAUWOqFjaJie4oS2ER" +
       "h1oK+SAhX7gysnT5zcDzfuQH9klCCnPySLAkj4g0aOoySQGRVcsoBVaVqueQ" +
       "inagxbNTJw4d/yK3w50a2IR1wGpMPc4IvbhE0EsJleZtOfXRJxefmtUdcijJ" +
       "NYUUWabJOKfbu81e5xNyzxb8cuKV2aAf1QKRAXlTDIcNeLHLu0YJ94QLPM58" +
       "aQSH07qZxSobKpBvgGZMfcrp4fhr489rYItXsMPYCd+wfTr5LxvtMFi7TuCV" +
       "YcbjBc8TXxk1zr39m7/ewcNdSCktrlpglNCwi8bYZO2csNocCB40CQG5P56N" +
       "n3ny2qnDHH8gsa3SgkHWRoC+YAshzI++duydD94//5bfwSyFPJ5LQkmULzrJ" +
       "+lFgGScZzh17gAZVYAOGmuADGqBSSSs4qRJ2SP7dsn3Xy/843SpwoEJPAUa3" +
       "ffYETv8te9Ejbzy41MWn8cksDTsxc8QEt692Zu41TTzN7MifuLrpe6/ic5Al" +
       "gJktZYZwsvXzGPi55+upranooahm5CgkXWLjHsZ2fx4SEfzBzw0HxJ18Fom3" +
       "d7Bg8nURH7uHNUHLfbBKz66rFEvIj7/18cpDH1+6ziNRWsu5cTSIjbCALmu2" +
       "52H6dV4SG8BWBuTuXBz6Rqu6eANmHIMZZaBsa9gE9suXoM6Wrmt49+e/6Dhy" +
       "pQb5+1FA1XGqH/MDjJrg5BArA3ScN756nwDOVCM0rdxVVOY826vNlVHQlzUo" +
       "37eZn6z70Z7nFt7ngBUI3WCr8z87WNNTRC7/1HuTpxu5JTOYaFO1+obXZudP" +
       "zi+khp/dJaqQ9tKaoQ9K4hd+/59fh87+6fUKSaeJ6sbtKpkkqmtNliG2lmWI" +
       "QV7+Oey2++pSzXtPrG8uTw5spq4q1N9Tnfq9C7x68m+dB+/NHPkcrL/ZEyjv" +
       "lD8YvPD6/h3yE35ewQrCL6t8S5XC7pDBoiaBUl1jbrGelRy+3cWtvYVtWQi+" +
       "NrTEbznzVkBFkc+qqXpOp6+4V0H3XrEb42guadG4qWSBniftevZix9KxXzbM" +
       "7CvUqpVUhOT91uDlnw58mOBxb2QbW/TWtam95rgr97QKNz6Fjw++/2VfZj7r" +
       "EJVhe8QuT7cU61PDYODeucyFstQFabb9g4lnPnpBuOCt3z3CZG7+sU9Dp+cF" +
       "6MUlZ1vZPcOtIy46wh3WjOX5OVhmFa7R/+HF2Z99f/aU32bKKEU1in3/LN2n" +
       "Dm/QhaX1u8796/i33x6GMiGKGnOacixHoqlS2DVYuaRrF5xbkQNC22YWcYp8" +
       "PRBc3n2oCmzKkslwX14mBjtgXI8X+1+DS1eKZ4leuIdqQLdwq2CJpKC+kas7" +
       "+aVcKMyaEcGD994c47KOSB5ShafQZVS8vuxCLi6R8osLLY3rFh74Ay+2ihe9" +
       "ZkBwOqeqrlC6w1pvmCStcH+bRSIy+A/kqS/cbCaF7YaWe2EK7UmoIm9Gm6I6" +
       "/uvWnYbqcHld0FKK0bW1HoabZDUtsA9at/RxitZUkgZJaN2SJylq9UrC+vzX" +
       "LfcoRQFHDoo18eAWmYPZQYQ9fscowOeemwoyT2RuILC3Y3lfeZ7lWFv7WVhz" +
       "JdZtJdzDXwkVjmdOvBQC4lw4MPTQ9S89K6phWcUzM/wVAhxKUZgXs8/WqrMV" +
       "5qof2Hlj1UtN2wtc0SYMdnLCBlfJFYFjajDMd3pKRStYrBjfOb/n0ptz9VeB" +
       "5Q4jH4bzfNj1Qka8fYB6Mwep8XCsEv1AbuZVbDjwlyOX//mur53XMDZhdS2n" +
       "kZDPXHovnjaMp/2oKQqghJOfH0MBxdo3rY0QedIsYbP6pJ7Tim+PVrEDitnr" +
       "Ih4ZO6Ari73sNkVRdzlfl98wobybIuZeNrvNjiX5OmcY7lEe2ZSgSpGYahKx" +
       "QcOwE1Xd73jkDYOT0DOsIf8DhbZnVPcVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
class PNGChunk {
    int length;
    int type;
    byte[] data;
    int crc;
    final java.lang.String typeString;
    PNGChunk(int length, int type, byte[] data,
             int crc) { super();
                        this.length = length;
                        this.type = type;
                        this.data = data;
                        this.crc = crc;
                        typeString = "" +
                                     (char)
                                       (type >>>
                                          24 &
                                          255) +
                                     (char)
                                       (type >>>
                                          16 &
                                          255) +
                                     (char)
                                       (type >>>
                                          8 &
                                          255) +
                                     (char)
                                       (type &
                                          255);
    }
    public int getLength() { return length;
    }
    public int getType() { return type; }
    public java.lang.String getTypeString() {
        return typeString;
    }
    public byte[] getData() { return data;
    }
    public byte getByte(int offset) { return data[offset];
    }
    public int getInt1(int offset) { return data[offset] &
                                       255;
    }
    public int getInt2(int offset) { return (data[offset] &
                                               255) <<
                                       8 |
                                       data[offset +
                                              1] &
                                       255;
    }
    public int getInt4(int offset) { return (data[offset] &
                                               255) <<
                                       24 |
                                       (data[offset +
                                               1] &
                                          255) <<
                                       16 |
                                       (data[offset +
                                               2] &
                                          255) <<
                                       8 |
                                       data[offset +
                                              3] &
                                       255;
    }
    public java.lang.String getString4(int offset) {
        return "" +
        (char)
          data[offset] +
        (char)
          data[offset +
                 1] +
        (char)
          data[offset +
                 2] +
        (char)
          data[offset +
                 3];
    }
    public boolean isType(java.lang.String typeName) {
        return typeString.
          equals(
            typeName);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0KdENnG39F/H+4EwvCYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e9Dj1nUfv92VdrWWtCvJlmTVelmrpDLiDwQJEuSs7RgA" +
       "SYAkCJIACZJIHRlvgMQbIAkgVWN5prXTeFxPIrvuTKK/nD4yip1Jmkk7eVSd" +
       "TJqkzqTjTCbpYxKnaWeS1HVrTydpJm7rXoDfe3c/SdG6/WZweXHvORfnd865" +
       "5x5c3O+1r5fuicIS5Ht2athevK8l8f7Sru3Hqa9F+z2mNpLCSFNJW4qiCWh7" +
       "UXnvT1/78299xrx+oXSvWHpEcl0vlmLLcyNOizx7o6lM6dpxa9vWnCguXWeW" +
       "0kaC17Flw4wVxTeZ0jtOsMalG8yhCDAQAQYiwIUIMH5MBZge0Ny1Q+YckhtH" +
       "QelvlfaY0r2+kosXl549PYgvhZJzMMyoQABGuJLfCwBUwZyEpWeOsO8w3wL4" +
       "sxD8yt///us/c7F0TSxds1w+F0cBQsTgIWLpfkdzZC2McFXVVLH0kKtpKq+F" +
       "lmRbWSG3WHo4sgxXitehdqSkvHHta2HxzGPN3a/k2MK1EnvhETzd0mz18O4e" +
       "3ZYMgPXRY6w7hJ28HQC8agHBQl1StEOWSyvLVePS02c5jjDe6AMCwHrZ0WLT" +
       "O3rUJVcCDaWHd7azJdeA+Ti0XAOQ3uOtwVPi0hN3HDTXtS8pK8nQXoxLj5+l" +
       "G+26ANV9hSJylrj0rrNkxUjASk+csdIJ+3yd/cCnf8Cl3QuFzKqm2Ln8VwDT" +
       "U2eYOE3XQs1VtB3j/e9jPic9+kufvFAqAeJ3nSHe0fz83/zmh7/nqdd/fUfz" +
       "125DM5SXmhK/qHxBfvAr7yFfaF7Mxbjie5GVG/8U8sL9Rwc9NxMfzLxHj0bM" +
       "O/cPO1/n/tXiYz+pfe1C6Wq3dK/i2WsH+NFDiuf4lq2FlOZqoRRrard0n+aq" +
       "ZNHfLV0GdcZytV3rUNcjLe6WLtlF071ecQ9UpIMhchVdBnXL1b3Dui/FZlFP" +
       "/NLB3z3gog/qxW9cSmHTczRYUiTXcj14FHo5/tygrirBsRaBugp6fQ+Wgf+v" +
       "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" +
       "+deylw/wvfwdwvfYOfjenRcPx6WrAN8u");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("eBYQj6Pn3iNvA+IjeWMePX/oAOIP3XWInypgPHcOxOfz4qm4dK8VHR03PPMh" +
       "67LsebYmuceon34rqJO4dOXwLGl+Qu7xWw677w5oK1989dqVx16d/t7uyNXh" +
       "Ier7mNIVfW3bJ8+4nKjf64eabhV6uG93pMAvcMFx6a+/2aOucemiv/uMure/" +
       "467EpRtvhjs/b5H/nuQFGnvqfF7AVfye5GrEpcfvxAXkA+VJ6ptx6Z23owaU" +
       "oDxJ+aG4dP0sJXh+8XuSDgdefkwH/GFXOUnSAqMDkrza3p0tOf3ReXeEKdk7" +
       "nRQfRbuH38hpTuTRz506bFL8E8XhmZ317t8oXlS+9GqP/YFv1n9id4pVsaUs" +
       "y0e5wpQu7w7UFoPm536eveNoh2PdS7/wrQd/+r7nDzPzB3cCH8+/E7I9ffuz" +
       "o23Hj4vTntk/e+yffuAfvfoHxefm/wsBRuas3TIAAA==");
}
class PNGImage extends org.apache.batik.ext.awt.image.codec.util.SimpleRenderedImage {
    public static final int PNG_COLOR_GRAY =
      0;
    public static final int PNG_COLOR_RGB =
      2;
    public static final int PNG_COLOR_PALETTE =
      3;
    public static final int PNG_COLOR_GRAY_ALPHA =
      4;
    public static final int PNG_COLOR_RGB_ALPHA =
      6;
    private static final java.lang.String[]
      colorTypeNames =
      { "Grayscale",
    "Error",
    "Truecolor",
    "Index",
    "Grayscale with alpha",
    "Error",
    "Truecolor with alpha" };
    public static final int PNG_FILTER_NONE =
      0;
    public static final int PNG_FILTER_SUB =
      1;
    public static final int PNG_FILTER_UP =
      2;
    public static final int PNG_FILTER_AVERAGE =
      3;
    public static final int PNG_FILTER_PAETH =
      4;
    private int[][] bandOffsets = { null,
    { 0 },
    { 0,
    1 },
    { 0,
    1,
    2 },
    { 0,
    1,
    2,
    3 } };
    private int bitDepth;
    private int colorType;
    private int compressionMethod;
    private int filterMethod;
    private int interlaceMethod;
    private int paletteEntries;
    private byte[] redPalette;
    private byte[] greenPalette;
    private byte[] bluePalette;
    private byte[] alphaPalette;
    private int bkgdRed;
    private int bkgdGreen;
    private int bkgdBlue;
    private int grayTransparentAlpha;
    private int redTransparentAlpha;
    private int greenTransparentAlpha;
    private int blueTransparentAlpha;
    private int maxOpacity;
    private int[] significantBits = null;
    private boolean suppressAlpha = false;
    private boolean expandPalette = false;
    private boolean output8BitGray = false;
    private boolean outputHasAlphaPalette =
      false;
    private boolean performGammaCorrection =
      false;
    private boolean expandGrayAlpha = false;
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam
      decodeParam =
      null;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    private boolean emitProperties = true;
    private float fileGamma = 45455 / 100000.0F;
    private float userExponent = 1.0F;
    private float displayExponent = 2.2F;
    private float[] chromaticity = null;
    private int sRGBRenderingIntent = -1;
    private int postProcess = POST_NONE;
    private static final int POST_NONE = 0;
    private static final int POST_GAMMA =
      1;
    private static final int POST_GRAY_LUT =
      2;
    private static final int POST_GRAY_LUT_ADD_TRANS =
      3;
    private static final int POST_PALETTE_TO_RGB =
      4;
    private static final int POST_PALETTE_TO_RGBA =
      5;
    private static final int POST_ADD_GRAY_TRANS =
      6;
    private static final int POST_ADD_RGB_TRANS =
      7;
    private static final int POST_REMOVE_GRAY_TRANS =
      8;
    private static final int POST_REMOVE_RGB_TRANS =
      9;
    private static final int POST_EXP_MASK =
      16;
    private static final int POST_GRAY_ALPHA_EXP =
      POST_NONE |
      POST_EXP_MASK;
    private static final int POST_GAMMA_EXP =
      POST_GAMMA |
      POST_EXP_MASK;
    private static final int POST_GRAY_LUT_ADD_TRANS_EXP =
      POST_GRAY_LUT_ADD_TRANS |
      POST_EXP_MASK;
    private static final int POST_ADD_GRAY_TRANS_EXP =
      POST_ADD_GRAY_TRANS |
      POST_EXP_MASK;
    private java.util.List<java.io.InputStream>
      streamVec =
      new java.util.ArrayList<java.io.InputStream>(
      );
    private java.io.DataInputStream dataStream;
    private int bytesPerPixel;
    private int inputBands;
    private int outputBands;
    private int chunkIndex = 0;
    private java.util.List textKeys = new java.util.ArrayList(
      );
    private java.util.List textStrings = new java.util.ArrayList(
      );
    private java.util.List ztextKeys = new java.util.ArrayList(
      );
    private java.util.List ztextStrings =
      new java.util.ArrayList(
      );
    private java.awt.image.WritableRaster
      theTile;
    private int[] gammaLut = null;
    private void initGammaLut(int bits) {
        double exp =
          (double)
            userExponent /
          (fileGamma *
             displayExponent);
        int numSamples =
          1 <<
          bits;
        int maxOutSample =
          bits ==
          16
          ? 65535
          : 255;
        gammaLut =
          (new int[numSamples]);
        for (int i =
               0;
             i <
               numSamples;
             i++) {
            double gbright =
              (double)
                i /
              (numSamples -
                 1);
            double gamma =
              java.lang.Math.
              pow(
                gbright,
                exp);
            int igamma =
              (int)
                (gamma *
                   maxOutSample +
                   0.5);
            if (igamma >
                  maxOutSample) {
                igamma =
                  maxOutSample;
            }
            gammaLut[i] =
              igamma;
        }
    }
    private final byte[][] expandBits = { null,
    { (byte)
        0,
    (byte)
      255 },
    { (byte)
        0,
    (byte)
      85,
    (byte)
      170,
    (byte)
      255 },
    null,
    { (byte)
        0,
    (byte)
      17,
    (byte)
      34,
    (byte)
      51,
    (byte)
      68,
    (byte)
      85,
    (byte)
      102,
    (byte)
      119,
    (byte)
      136,
    (byte)
      153,
    (byte)
      170,
    (byte)
      187,
    (byte)
      204,
    (byte)
      221,
    (byte)
      238,
    (byte)
      255 } };
    private int[] grayLut = null;
    private void initGrayLut(int bits) { int len =
                                           1 <<
                                           bits;
                                         grayLut =
                                           (new int[len]);
                                         if (performGammaCorrection) {
                                             java.lang.System.
                                               arraycopy(
                                                 gammaLut,
                                                 0,
                                                 grayLut,
                                                 0,
                                                 len);
                                         }
                                         else {
                                             for (int i =
                                                    0;
                                                  i <
                                                    len;
                                                  i++) {
                                                 grayLut[i] =
                                                   expandBits[bits][i];
                                             }
                                         }
    }
    public PNGImage(java.io.InputStream stream,
                    org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam decodeParam)
          throws java.io.IOException { super(
                                         );
                                       if (!stream.
                                             markSupported(
                                               )) {
                                           stream =
                                             new java.io.BufferedInputStream(
                                               stream);
                                       }
                                       java.io.DataInputStream distream =
                                         new java.io.DataInputStream(
                                         stream);
                                       if (decodeParam ==
                                             null) {
                                           decodeParam =
                                             new org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam(
                                               );
                                       }
                                       this.
                                         decodeParam =
                                         decodeParam;
                                       this.
                                         suppressAlpha =
                                         decodeParam.
                                           getSuppressAlpha(
                                             );
                                       this.
                                         expandPalette =
                                         decodeParam.
                                           getExpandPalette(
                                             );
                                       this.
                                         output8BitGray =
                                         decodeParam.
                                           getOutput8BitGray(
                                             );
                                       this.
                                         expandGrayAlpha =
                                         decodeParam.
                                           getExpandGrayAlpha(
                                             );
                                       if (decodeParam.
                                             getPerformGammaCorrection(
                                               )) {
                                           this.
                                             userExponent =
                                             decodeParam.
                                               getUserExponent(
                                                 );
                                           this.
                                             displayExponent =
                                             decodeParam.
                                               getDisplayExponent(
                                                 );
                                           performGammaCorrection =
                                             true;
                                           output8BitGray =
                                             true;
                                       }
                                       this.
                                         generateEncodeParam =
                                         decodeParam.
                                           getGenerateEncodeParam(
                                             );
                                       if (emitProperties) {
                                           properties.
                                             put(
                                               "file_type",
                                               "PNG v. 1.0");
                                       }
                                       try {
                                           long magic =
                                             distream.
                                             readLong(
                                               );
                                           if (magic !=
                                                 -8552249625308161526L) {
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder0");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }
                                       catch (java.lang.Exception e) {
                                           e.
                                             printStackTrace(
                                               );
                                           java.lang.String msg =
                                             org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                             getString(
                                               "PNGImageDecoder1");
                                           throw new java.lang.RuntimeException(
                                             msg);
                                       }
                                       do  {
                                           try {
                                               org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk;
                                               java.lang.String chunkType =
                                                 getChunkType(
                                                   distream);
                                               if (chunkType.
                                                     equals(
                                                       "IHDR")) {
                                                   chunk =
                                                     readChunk(
                                                       distream);
                                                   parse_IHDR_chunk(
                                                     chunk);
                                               }
                                               else
                                                   if (chunkType.
                                                         equals(
                                                           "PLTE")) {
                                                       chunk =
                                                         readChunk(
                                                           distream);
                                                       parse_PLTE_chunk(
                                                         chunk);
                                                   }
                                                   else
                                                       if (chunkType.
                                                             equals(
                                                               "IDAT")) {
                                                           chunk =
                                                             readChunk(
                                                               distream);
                                                           streamVec.
                                                             add(
                                                               new java.io.ByteArrayInputStream(
                                                                 chunk.
                                                                   getData(
                                                                     )));
                                                       }
                                                       else
                                                           if (chunkType.
                                                                 equals(
                                                                   "IEND")) {
                                                               chunk =
                                                                 readChunk(
                                                                   distream);
                                                               parse_IEND_chunk(
                                                                 chunk);
                                                               break;
                                                           }
                                                           else
                                                               if (chunkType.
                                                                     equals(
                                                                       "bKGD")) {
                                                                   chunk =
                                                                     readChunk(
                                                                       distream);
                                                                   parse_bKGD_chunk(
                                                                     chunk);
                                                               }
                                                               else
                                                                   if (chunkType.
                                                                         equals(
                                                                           "cHRM")) {
                                                                       chunk =
                                                                         readChunk(
                                                                           distream);
                                                                       parse_cHRM_chunk(
                                                                         chunk);
                                                                   }
                                                                   else
                                                                       if (chunkType.
                                                                             equals(
                                                                               "gAMA")) {
                                                                           chunk =
                                                                             readChunk(
                                                                               distream);
                                                                           parse_gAMA_chunk(
                                                                             chunk);
                                                                       }
                                                                       else
                                                                           if (chunkType.
                                                                                 equals(
                                                                                   "hIST")) {
                                                                               chunk =
                                                                                 readChunk(
                                                                                   distream);
                                                                               parse_hIST_chunk(
                                                                                 chunk);
                                                                           }
                                                                           else
                                                                               if (chunkType.
                                                                                     equals(
                                                                                       "iCCP")) {
                                                                                   chunk =
                                                                                     readChunk(
                                                                                       distream);
                                                                                   parse_iCCP_chunk(
                                                                                     chunk);
                                                                               }
                                                                               else
                                                                                   if (chunkType.
                                                                                         equals(
                                                                                           "pHYs")) {
                                                                                       chunk =
                                                                                         readChunk(
                                                                                           distream);
                                                                                       parse_pHYs_chunk(
                                                                                         chunk);
                                                                                   }
                                                                                   else
                                                                                       if (chunkType.
                                                                                             equals(
                                                                                               "sBIT")) {
                                                                                           chunk =
                                                                                             readChunk(
                                                                                               distream);
                                                                                           parse_sBIT_chunk(
                                                                                             chunk);
                                                                                       }
                                                                                       else
                                                                                           if (chunkType.
                                                                                                 equals(
                                                                                                   "sRGB")) {
                                                                                               chunk =
                                                                                                 readChunk(
                                                                                                   distream);
                                                                                               parse_sRGB_chunk(
                                                                                                 chunk);
                                                                                           }
                                                                                           else
                                                                                               if (chunkType.
                                                                                                     equals(
                                                                                                       "tEXt")) {
                                                                                                   chunk =
                                                                                                     readChunk(
                                                                                                       distream);
                                                                                                   parse_tEXt_chunk(
                                                                                                     chunk);
                                                                                               }
                                                                                               else
                                                                                                   if (chunkType.
                                                                                                         equals(
                                                                                                           "tIME")) {
                                                                                                       chunk =
                                                                                                         readChunk(
                                                                                                           distream);
                                                                                                       parse_tIME_chunk(
                                                                                                         chunk);
                                                                                                   }
                                                                                                   else
                                                                                                       if (chunkType.
                                                                                                             equals(
                                                                                                               "tRNS")) {
                                                                                                           chunk =
                                                                                                             readChunk(
                                                                                                               distream);
                                                                                                           parse_tRNS_chunk(
                                                                                                             chunk);
                                                                                                       }
                                                                                                       else
                                                                                                           if (chunkType.
                                                                                                                 equals(
                                                                                                                   "zTXt")) {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               parse_zTXt_chunk(
                                                                                                                 chunk);
                                                                                                           }
                                                                                                           else {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               java.lang.String type =
                                                                                                                 chunk.
                                                                                                                 getTypeString(
                                                                                                                   );
                                                                                                               byte[] data =
                                                                                                                 chunk.
                                                                                                                 getData(
                                                                                                                   );
                                                                                                               if (encodeParam !=
                                                                                                                     null) {
                                                                                                                   encodeParam.
                                                                                                                     addPrivateChunk(
                                                                                                                       type,
                                                                                                                       data);
                                                                                                               }
                                                                                                               if (emitProperties) {
                                                                                                                   java.lang.String key =
                                                                                                                     "chunk_" +
                                                                                                                   chunkIndex++ +
                                                                                                                   ':' +
                                                                                                                   type;
                                                                                                                   properties.
                                                                                                                     put(
                                                                                                                       key.
                                                                                                                         toLowerCase(
                                                                                                                           ),
                                                                                                                       data);
                                                                                                               }
                                                                                                           }
                                           }
                                           catch (java.lang.Exception e) {
                                               e.
                                                 printStackTrace(
                                                   );
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder2");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }while(true); 
                                       if (significantBits ==
                                             null) {
                                           significantBits =
                                             (new int[inputBands]);
                                           for (int i =
                                                  0;
                                                i <
                                                  inputBands;
                                                i++) {
                                               significantBits[i] =
                                                 bitDepth;
                                           }
                                           if (emitProperties) {
                                               properties.
                                                 put(
                                                   "significant_bits",
                                                   significantBits);
                                           }
                                       } }
    private static java.lang.String getChunkType(java.io.DataInputStream distream) {
        try {
            distream.
              mark(
                8);
            distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            distream.
              reset(
                );
            java.lang.String typeString =
              "";
            typeString +=
              (char)
                (type >>
                   24);
            typeString +=
              (char)
                (type >>
                   16 &
                   255);
            typeString +=
              (char)
                (type >>
                   8 &
                   255);
            typeString +=
              (char)
                (type &
                   255);
            return typeString;
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private static org.apache.batik.ext.awt.image.codec.png.PNGChunk readChunk(java.io.DataInputStream distream) {
        try {
            int length =
              distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            byte[] data =
              new byte[length];
            distream.
              readFully(
                data);
            int crc =
              distream.
              readInt(
                );
            return new org.apache.batik.ext.awt.image.codec.png.PNGChunk(
              length,
              type,
              data,
              crc);
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private void parse_IHDR_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        tileWidth =
          (width =
             chunk.
               getInt4(
                 0));
        tileHeight =
          (height =
             chunk.
               getInt4(
                 4));
        bitDepth =
          chunk.
            getInt1(
              8);
        if (bitDepth !=
              1 &&
              bitDepth !=
              2 &&
              bitDepth !=
              4 &&
              bitDepth !=
              8 &&
              bitDepth !=
              16) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder3");
            throw new java.lang.RuntimeException(
              msg);
        }
        maxOpacity =
          (1 <<
             bitDepth) -
            1;
        colorType =
          chunk.
            getInt1(
              9);
        if (colorType !=
              PNG_COLOR_GRAY &&
              colorType !=
              PNG_COLOR_RGB &&
              colorType !=
              PNG_COLOR_PALETTE &&
              colorType !=
              PNG_COLOR_GRAY_ALPHA &&
              colorType !=
              PNG_COLOR_RGB_ALPHA) {
            java.lang.System.
              out.
              println(
                org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder4"));
        }
        if (colorType ==
              PNG_COLOR_RGB &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder5");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_PALETTE &&
              bitDepth ==
              16) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder6");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_GRAY_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder7");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_RGB_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder8");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (emitProperties) {
            properties.
              put(
                "color_type",
                colorTypeNames[colorType]);
        }
        if (generateEncodeParam) {
            if (colorType ==
                  PNG_COLOR_PALETTE) {
                encodeParam =
                  new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette(
                    );
            }
            else
                if (colorType ==
                      PNG_COLOR_GRAY ||
                      colorType ==
                      PNG_COLOR_GRAY_ALPHA) {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray(
                        );
                }
                else {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB(
                        );
                }
            decodeParam.
              setEncodeParam(
                encodeParam);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setBitDepth(
                bitDepth);
        }
        if (emitProperties) {
            properties.
              put(
                "bit_depth",
                new java.lang.Integer(
                  bitDepth));
        }
        if (performGammaCorrection) {
            float gamma =
              1.0F /
              2.2F *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
            }
        }
        compressionMethod =
          chunk.
            getInt1(
              10);
        if (compressionMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder9");
            throw new java.lang.RuntimeException(
              msg);
        }
        filterMethod =
          chunk.
            getInt1(
              11);
        if (filterMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder10");
            throw new java.lang.RuntimeException(
              msg);
        }
        interlaceMethod =
          chunk.
            getInt1(
              12);
        if (interlaceMethod ==
              0) {
            if (encodeParam !=
                  null) {
                encodeParam.
                  setInterlacing(
                    false);
            }
            if (emitProperties) {
                properties.
                  put(
                    "interlace_method",
                    "None");
            }
        }
        else
            if (interlaceMethod ==
                  1) {
                if (encodeParam !=
                      null) {
                    encodeParam.
                      setInterlacing(
                        true);
                }
                if (emitProperties) {
                    properties.
                      put(
                        "interlace_method",
                        "Adam7");
                }
            }
            else {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder11");
                throw new java.lang.RuntimeException(
                  msg);
            }
        bytesPerPixel =
          bitDepth ==
            16
            ? 2
            : 1;
        switch (colorType) {
            case PNG_COLOR_GRAY:
                inputBands =
                  1;
                outputBands =
                  1;
                if (output8BitGray &&
                      bitDepth <
                      8) {
                    postProcess =
                      POST_GRAY_LUT;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
            case PNG_COLOR_RGB:
                inputBands =
                  3;
                bytesPerPixel *=
                  3;
                outputBands =
                  3;
                if (performGammaCorrection) {
                    postProcess =
                      POST_GAMMA;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_PALETTE:
                inputBands =
                  1;
                bytesPerPixel =
                  1;
                outputBands =
                  expandPalette
                    ? 3
                    : 1;
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGB;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_GRAY_ALPHA:
                inputBands =
                  2;
                bytesPerPixel *=
                  2;
                if (suppressAlpha) {
                    outputBands =
                      1;
                    postProcess =
                      POST_REMOVE_GRAY_TRANS;
                }
                else {
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                    if (expandGrayAlpha) {
                        postProcess |=
                          POST_EXP_MASK;
                        outputBands =
                          4;
                    }
                    else {
                        outputBands =
                          2;
                    }
                }
                break;
            case PNG_COLOR_RGB_ALPHA:
                inputBands =
                  4;
                bytesPerPixel *=
                  4;
                outputBands =
                  !suppressAlpha
                    ? 4
                    : 3;
                if (suppressAlpha) {
                    postProcess =
                      POST_REMOVE_RGB_TRANS;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
        }
    }
    private void parse_IEND_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk)
          throws java.lang.Exception { int textLen =
                                         textKeys.
                                         size(
                                           );
                                       java.lang.String[] textArray =
                                         new java.lang.String[2 *
                                                                textLen];
                                       for (int i =
                                              0;
                                            i <
                                              textLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               textKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               textStrings.
                                               get(
                                                 i);
                                           textArray[2 *
                                                       i] =
                                             key;
                                           textArray[2 *
                                                       i +
                                                       1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "text_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setText(
                                               textArray);
                                       }
                                       int ztextLen =
                                         ztextKeys.
                                         size(
                                           );
                                       java.lang.String[] ztextArray =
                                         new java.lang.String[2 *
                                                                ztextLen];
                                       for (int i =
                                              0;
                                            i <
                                              ztextLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               ztextKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               ztextStrings.
                                               get(
                                                 i);
                                           ztextArray[2 *
                                                        i] =
                                             key;
                                           ztextArray[2 *
                                                        i +
                                                        1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "ztext_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setCompressedText(
                                               ztextArray);
                                       }
                                       java.io.InputStream seqStream =
                                         new java.io.SequenceInputStream(
                                         java.util.Collections.
                                           enumeration(
                                             streamVec));
                                       java.io.InputStream infStream =
                                         new java.util.zip.InflaterInputStream(
                                         seqStream,
                                         new java.util.zip.Inflater(
                                           ));
                                       dataStream =
                                         new java.io.DataInputStream(
                                           infStream);
                                       int depth =
                                         bitDepth;
                                       if (colorType ==
                                             PNG_COLOR_GRAY &&
                                             bitDepth <
                                             8 &&
                                             output8BitGray) {
                                           depth =
                                             8;
                                       }
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             expandPalette) {
                                           depth =
                                             8;
                                       }
                                       int bytesPerRow =
                                         (outputBands *
                                            width *
                                            depth +
                                            7) /
                                         8;
                                       int scanlineStride =
                                         depth ==
                                         16
                                         ? bytesPerRow /
                                         2
                                         : bytesPerRow;
                                       theTile =
                                         createRaster(
                                           width,
                                           height,
                                           outputBands,
                                           scanlineStride,
                                           depth);
                                       if (performGammaCorrection &&
                                             gammaLut ==
                                             null) {
                                           initGammaLut(
                                             bitDepth);
                                       }
                                       if (postProcess ==
                                             POST_GRAY_LUT ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS_EXP) {
                                           initGrayLut(
                                             bitDepth);
                                       }
                                       decodeImage(
                                         interlaceMethod ==
                                           1);
                                       sampleModel =
                                         theTile.
                                           getSampleModel(
                                             );
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             !expandPalette) {
                                           if (outputHasAlphaPalette) {
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette,
                                                   alphaPalette);
                                           }
                                           else {
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette);
                                           }
                                       }
                                       else
                                           if (colorType ==
                                                 PNG_COLOR_GRAY &&
                                                 bitDepth <
                                                 8 &&
                                                 !output8BitGray) {
                                               byte[] palette =
                                                 expandBits[bitDepth];
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   palette.
                                                     length,
                                                   palette,
                                                   palette,
                                                   palette);
                                           }
                                           else {
                                               colorModel =
                                                 createComponentColorModel(
                                                   sampleModel);
                                           }
    }
    private static final int[] GrayBits8 =
      { 8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayAlphaBits8 =
      { 8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayBits16 =
      { 16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayAlphaBits16 =
      { 16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayBits32 =
      { 32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] GrayAlphaBits32 =
      { 32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBBits8 =
      { 8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBABits8 =
      { 8,
    8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBBits16 =
      { 16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBABits16 =
      { 16,
    16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBBits32 =
      { 32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBABits32 =
      { 32,
    32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static java.awt.image.ColorModel createComponentColorModel(java.awt.image.SampleModel sm) {
        int type =
          sm.
          getDataType(
            );
        int bands =
          sm.
          getNumBands(
            );
        java.awt.image.ComponentColorModel cm =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            switch (bands) {
                case 1:
                    cm =
                      colorModelGray8;
                    break;
                case 2:
                    cm =
                      colorModelGrayAlpha8;
                    break;
                case 3:
                    cm =
                      colorModelRGB8;
                    break;
                case 4:
                    cm =
                      colorModelRGBA8;
                    break;
            }
        }
        else
            if (type ==
                  java.awt.image.DataBuffer.
                    TYPE_USHORT) {
                switch (bands) {
                    case 1:
                        cm =
                          colorModelGray16;
                        break;
                    case 2:
                        cm =
                          colorModelGrayAlpha16;
                        break;
                    case 3:
                        cm =
                          colorModelRGB16;
                        break;
                    case 4:
                        cm =
                          colorModelRGBA16;
                        break;
                }
            }
            else
                if (type ==
                      java.awt.image.DataBuffer.
                        TYPE_INT) {
                    switch (bands) {
                        case 1:
                            cm =
                              colorModelGray32;
                            break;
                        case 2:
                            cm =
                              colorModelGrayAlpha32;
                            break;
                        case 3:
                            cm =
                              colorModelRGB32;
                            break;
                        case 4:
                            cm =
                              colorModelRGBA32;
                            break;
                    }
                }
        return cm;
    }
    private void parse_PLTE_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        paletteEntries =
          chunk.
            getLength(
              ) /
            3;
        redPalette =
          (new byte[paletteEntries]);
        greenPalette =
          (new byte[paletteEntries]);
        bluePalette =
          (new byte[paletteEntries]);
        int pltIndex =
          0;
        if (performGammaCorrection) {
            if (gammaLut ==
                  null) {
                initGammaLut(
                  bitDepth ==
                    16
                    ? 16
                    : 8);
            }
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                byte r =
                  chunk.
                  getByte(
                    pltIndex++);
                byte g =
                  chunk.
                  getByte(
                    pltIndex++);
                byte b =
                  chunk.
                  getByte(
                    pltIndex++);
                redPalette[i] =
                  (byte)
                    gammaLut[r &
                               255];
                greenPalette[i] =
                  (byte)
                    gammaLut[g &
                               255];
                bluePalette[i] =
                  (byte)
                    gammaLut[b &
                               255];
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                redPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                greenPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                bluePalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
            }
        }
    }
    private void parse_bKGD_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        switch (colorType) {
            case PNG_COLOR_PALETTE:
                int bkgdIndex =
                  chunk.
                  getByte(
                    0) &
                  255;
                bkgdRed =
                  redPalette[bkgdIndex] &
                    255;
                bkgdGreen =
                  greenPalette[bkgdIndex] &
                    255;
                bkgdBlue =
                  bluePalette[bkgdIndex] &
                    255;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette)
                       encodeParam).
                      setBackgroundPaletteIndex(
                        bkgdIndex);
                }
                break;
            case PNG_COLOR_GRAY:
            case PNG_COLOR_GRAY_ALPHA:
                int bkgdGray =
                  chunk.
                  getInt2(
                    0);
                bkgdRed =
                  (bkgdGreen =
                     (bkgdBlue =
                        bkgdGray));
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                       encodeParam).
                      setBackgroundGray(
                        bkgdGray);
                }
                break;
            case PNG_COLOR_RGB:
            case PNG_COLOR_RGB_ALPHA:
                bkgdRed =
                  chunk.
                    getInt2(
                      0);
                bkgdGreen =
                  chunk.
                    getInt2(
                      2);
                bkgdBlue =
                  chunk.
                    getInt2(
                      4);
                int[] bkgdRGB =
                  new int[3];
                bkgdRGB[0] =
                  bkgdRed;
                bkgdRGB[1] =
                  bkgdGreen;
                bkgdRGB[2] =
                  bkgdBlue;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                       encodeParam).
                      setBackgroundRGB(
                        bkgdRGB);
                }
                break;
        }
        int r =
          0;
        int g =
          0;
        int b =
          0;
        if (bitDepth <
              8) {
            r =
              expandBits[bitDepth][bkgdRed];
            g =
              expandBits[bitDepth][bkgdGreen];
            b =
              expandBits[bitDepth][bkgdBlue];
        }
        else
            if (bitDepth ==
                  8) {
                r =
                  bkgdRed;
                g =
                  bkgdGreen;
                b =
                  bkgdBlue;
            }
            else
                if (bitDepth ==
                      16) {
                    r =
                      bkgdRed >>
                        8;
                    g =
                      bkgdGreen >>
                        8;
                    b =
                      bkgdBlue >>
                        8;
                }
        if (emitProperties) {
            properties.
              put(
                "background_color",
                new java.awt.Color(
                  r,
                  g,
                  b));
        }
    }
    private void parse_cHRM_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          chunk.
            getInt4(
              0) /
            100000.0F;
        chromaticity[1] =
          chunk.
            getInt4(
              4) /
            100000.0F;
        chromaticity[2] =
          chunk.
            getInt4(
              8) /
            100000.0F;
        chromaticity[3] =
          chunk.
            getInt4(
              12) /
            100000.0F;
        chromaticity[4] =
          chunk.
            getInt4(
              16) /
            100000.0F;
        chromaticity[5] =
          chunk.
            getInt4(
              20) /
            100000.0F;
        chromaticity[6] =
          chunk.
            getInt4(
              24) /
            100000.0F;
        chromaticity[7] =
          chunk.
            getInt4(
              28) /
            100000.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setChromaticity(
                chromaticity);
        }
        if (emitProperties) {
            properties.
              put(
                "white_point_x",
                new java.lang.Float(
                  chromaticity[0]));
            properties.
              put(
                "white_point_y",
                new java.lang.Float(
                  chromaticity[1]));
            properties.
              put(
                "red_x",
                new java.lang.Float(
                  chromaticity[2]));
            properties.
              put(
                "red_y",
                new java.lang.Float(
                  chromaticity[3]));
            properties.
              put(
                "green_x",
                new java.lang.Float(
                  chromaticity[4]));
            properties.
              put(
                "green_y",
                new java.lang.Float(
                  chromaticity[5]));
            properties.
              put(
                "blue_x",
                new java.lang.Float(
                  chromaticity[6]));
            properties.
              put(
                "blue_y",
                new java.lang.Float(
                  chromaticity[7]));
        }
    }
    private void parse_gAMA_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        fileGamma =
          chunk.
            getInt4(
              0) /
            100000.0F;
        float exp =
          performGammaCorrection
          ? displayExponent /
          userExponent
          : 1.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setGamma(
                fileGamma *
                  exp);
        }
        if (emitProperties) {
            properties.
              put(
                "gamma",
                new java.lang.Float(
                  fileGamma *
                    exp));
        }
    }
    private void parse_hIST_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (redPalette ==
              null) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder18");
            throw new java.lang.RuntimeException(
              msg);
        }
        int length =
          redPalette.
            length;
        int[] hist =
          new int[length];
        for (int i =
               0;
             i <
               length;
             i++) {
            hist[i] =
              chunk.
                getInt2(
                  2 *
                    i);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setPaletteHistogram(
                hist);
        }
    }
    private void parse_iCCP_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        java.lang.String name =
          "";
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            name +=
              (char)
                b;
        }
    }
    private void parse_pHYs_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int xPixelsPerUnit =
          chunk.
          getInt4(
            0);
        int yPixelsPerUnit =
          chunk.
          getInt4(
            4);
        int unitSpecifier =
          chunk.
          getInt1(
            8);
        if (encodeParam !=
              null) {
            encodeParam.
              setPhysicalDimension(
                xPixelsPerUnit,
                yPixelsPerUnit,
                unitSpecifier);
        }
        if (emitProperties) {
            properties.
              put(
                "x_pixels_per_unit",
                new java.lang.Integer(
                  xPixelsPerUnit));
            properties.
              put(
                "y_pixels_per_unit",
                new java.lang.Integer(
                  yPixelsPerUnit));
            properties.
              put(
                "pixel_aspect_ratio",
                new java.lang.Float(
                  (float)
                    xPixelsPerUnit /
                    yPixelsPerUnit));
            if (unitSpecifier ==
                  1) {
                properties.
                  put(
                    "pixel_units",
                    "Meters");
            }
            else
                if (unitSpecifier !=
                      0) {
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder12");
                    throw new java.lang.RuntimeException(
                      msg);
                }
        }
    }
    private void parse_sBIT_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            significantBits =
              (new int[3]);
        }
        else {
            significantBits =
              (new int[inputBands]);
        }
        for (int i =
               0;
             i <
               significantBits.
                 length;
             i++) {
            int bits =
              chunk.
              getByte(
                i);
            int depth =
              colorType ==
              PNG_COLOR_PALETTE
              ? 8
              : bitDepth;
            if (bits <=
                  0 ||
                  bits >
                  depth) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder13");
                throw new java.lang.RuntimeException(
                  msg);
            }
            significantBits[i] =
              bits;
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setSignificantBits(
                significantBits);
        }
        if (emitProperties) {
            properties.
              put(
                "significant_bits",
                significantBits);
        }
    }
    private void parse_sRGB_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        sRGBRenderingIntent =
          chunk.
            getByte(
              0);
        fileGamma =
          45455 /
            100000.0F;
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          31270 /
            10000.0F;
        chromaticity[1] =
          32900 /
            10000.0F;
        chromaticity[2] =
          64000 /
            10000.0F;
        chromaticity[3] =
          33000 /
            10000.0F;
        chromaticity[4] =
          30000 /
            10000.0F;
        chromaticity[5] =
          60000 /
            10000.0F;
        chromaticity[6] =
          15000 /
            10000.0F;
        chromaticity[7] =
          6000 /
            10000.0F;
        if (performGammaCorrection) {
            float gamma =
              fileGamma *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
                encodeParam.
                  setChromaticity(
                    chromaticity);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
                properties.
                  put(
                    "white_point_x",
                    new java.lang.Float(
                      chromaticity[0]));
                properties.
                  put(
                    "white_point_y",
                    new java.lang.Float(
                      chromaticity[1]));
                properties.
                  put(
                    "red_x",
                    new java.lang.Float(
                      chromaticity[2]));
                properties.
                  put(
                    "red_y",
                    new java.lang.Float(
                      chromaticity[3]));
                properties.
                  put(
                    "green_x",
                    new java.lang.Float(
                      chromaticity[4]));
                properties.
                  put(
                    "green_y",
                    new java.lang.Float(
                      chromaticity[5]));
                properties.
                  put(
                    "blue_x",
                    new java.lang.Float(
                      chromaticity[6]));
                properties.
                  put(
                    "blue_y",
                    new java.lang.Float(
                      chromaticity[7]));
            }
        }
    }
    private void parse_tEXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        byte b;
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        for (int i =
               textIndex;
             i <
               chunk.
               getLength(
                 );
             i++) {
            value.
              append(
                (char)
                  chunk.
                  getByte(
                    i));
        }
        textKeys.
          add(
            key.
              toString(
                ));
        textStrings.
          add(
            value.
              toString(
                ));
    }
    private void parse_tIME_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int year =
          chunk.
          getInt2(
            0);
        int month =
          chunk.
          getInt1(
            2) -
          1;
        int day =
          chunk.
          getInt1(
            3);
        int hour =
          chunk.
          getInt1(
            4);
        int minute =
          chunk.
          getInt1(
            5);
        int second =
          chunk.
          getInt1(
            6);
        java.util.TimeZone gmt =
          java.util.TimeZone.
          getTimeZone(
            "GMT");
        java.util.GregorianCalendar cal =
          new java.util.GregorianCalendar(
          gmt);
        cal.
          set(
            year,
            month,
            day,
            hour,
            minute,
            second);
        java.util.Date date =
          cal.
          getTime(
            );
        if (encodeParam !=
              null) {
            encodeParam.
              setModificationTime(
                date);
        }
        if (emitProperties) {
            properties.
              put(
                "timestamp",
                date);
        }
    }
    private void parse_tRNS_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            int entries =
              chunk.
              getLength(
                );
            if (entries >
                  paletteEntries) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder14");
                throw new java.lang.RuntimeException(
                  msg);
            }
            alphaPalette =
              (new byte[paletteEntries]);
            for (int i =
                   0;
                 i <
                   entries;
                 i++) {
                alphaPalette[i] =
                  chunk.
                    getByte(
                      i);
            }
            for (int i =
                   entries;
                 i <
                   paletteEntries;
                 i++) {
                alphaPalette[i] =
                  (byte)
                    255;
            }
            if (!suppressAlpha) {
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGBA;
                    outputBands =
                      4;
                }
                else {
                    outputHasAlphaPalette =
                      true;
                }
            }
        }
        else
            if (colorType ==
                  PNG_COLOR_GRAY) {
                grayTransparentAlpha =
                  chunk.
                    getInt2(
                      0);
                if (!suppressAlpha) {
                    if (bitDepth <
                          8) {
                        output8BitGray =
                          true;
                        maxOpacity =
                          255;
                        postProcess =
                          POST_GRAY_LUT_ADD_TRANS;
                    }
                    else {
                        postProcess =
                          POST_ADD_GRAY_TRANS;
                    }
                    if (expandGrayAlpha) {
                        outputBands =
                          4;
                        postProcess |=
                          POST_EXP_MASK;
                    }
                    else {
                        outputBands =
                          2;
                    }
                    if (encodeParam !=
                          null) {
                        ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                           encodeParam).
                          setTransparentGray(
                            grayTransparentAlpha);
                    }
                }
            }
            else
                if (colorType ==
                      PNG_COLOR_RGB) {
                    redTransparentAlpha =
                      chunk.
                        getInt2(
                          0);
                    greenTransparentAlpha =
                      chunk.
                        getInt2(
                          2);
                    blueTransparentAlpha =
                      chunk.
                        getInt2(
                          4);
                    if (!suppressAlpha) {
                        outputBands =
                          4;
                        postProcess =
                          POST_ADD_RGB_TRANS;
                        if (encodeParam !=
                              null) {
                            int[] rgbTrans =
                              new int[3];
                            rgbTrans[0] =
                              redTransparentAlpha;
                            rgbTrans[1] =
                              greenTransparentAlpha;
                            rgbTrans[2] =
                              blueTransparentAlpha;
                            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                               encodeParam).
                              setTransparentRGB(
                                rgbTrans);
                        }
                    }
                }
                else
                    if (colorType ==
                          PNG_COLOR_GRAY_ALPHA ||
                          colorType ==
                          PNG_COLOR_RGB_ALPHA) {
                        java.lang.String msg =
                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                          getString(
                            "PNGImageDecoder15");
                        throw new java.lang.RuntimeException(
                          msg);
                    }
    }
    private void parse_zTXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int textIndex =
          0;
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        byte b;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        chunk.
          getByte(
            textIndex++);
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        try {
            int length =
              chunk.
              getLength(
                ) -
              textIndex;
            byte[] data =
              chunk.
              getData(
                );
            java.io.InputStream cis =
              new java.io.ByteArrayInputStream(
              data,
              textIndex,
              length);
            java.io.InputStream iis =
              new java.util.zip.InflaterInputStream(
              cis);
            int c;
            while ((c =
                      iis.
                        read(
                          )) !=
                     -1) {
                value.
                  append(
                    (char)
                      c);
            }
            ztextKeys.
              add(
                key.
                  toString(
                    ));
            ztextStrings.
              add(
                value.
                  toString(
                    ));
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
        }
    }
    private java.awt.image.WritableRaster createRaster(int width,
                                                       int height,
                                                       int bands,
                                                       int scanlineStride,
                                                       int bitDepth) {
        java.awt.image.DataBuffer dataBuffer;
        java.awt.image.WritableRaster ras =
          null;
        java.awt.Point origin =
          new java.awt.Point(
          0,
          0);
        if (bitDepth <
              8 &&
              bands ==
              1) {
            dataBuffer =
              new java.awt.image.DataBufferByte(
                height *
                  scanlineStride);
            ras =
              java.awt.image.Raster.
                createPackedRaster(
                  dataBuffer,
                  width,
                  height,
                  bitDepth,
                  origin);
        }
        else
            if (bitDepth <=
                  8) {
                dataBuffer =
                  new java.awt.image.DataBufferByte(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
            else {
                dataBuffer =
                  new java.awt.image.DataBufferUShort(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
        return ras;
    }
    private static void decodeSubFilter(byte[] curr,
                                        int count,
                                        int bpp) {
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int val;
            val =
              curr[i] &
                255;
            val +=
              curr[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                val;
        }
    }
    private static void decodeUpFilter(byte[] curr,
                                       byte[] prev,
                                       int count) {
        for (int i =
               0;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            int prior =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   prior);
        }
    }
    private static void decodeAverageFilter(byte[] curr,
                                            byte[] prev,
                                            int count,
                                            int bpp) {
        int raw;
        int priorPixel;
        int priorRow;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            raw =
              curr[i] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   priorRow /
                   2);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            raw =
              curr[i] &
                255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   (priorPixel +
                      priorRow) /
                   2);
        }
    }
    private static void decodePaethFilter(byte[] curr,
                                          byte[] prev,
                                          int count,
                                          int bpp) {
        int raw;
        int priorPixel;
        int priorRow;
        int priorRowPixel;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            raw =
              curr[i] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   priorRow);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            raw =
              curr[i] &
                255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            priorRow =
              prev[i] &
                255;
            priorRowPixel =
              prev[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                (raw +
                   org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
                   paethPredictor(
                     priorPixel,
                     priorRow,
                     priorRowPixel));
        }
    }
    private void processPixels(int process,
                               java.awt.image.Raster src,
                               java.awt.image.WritableRaster dst,
                               int xOffset,
                               int step,
                               int y,
                               int width) {
        int srcX;
        int dstX;
        int[] ps =
          src.
          getPixel(
            0,
            0,
            (int[])
              null);
        int[] pd =
          dst.
          getPixel(
            0,
            0,
            (int[])
              null);
        dstX =
          xOffset;
        switch (process) {
            case POST_NONE:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    for (int i =
                           0;
                         i <
                           inputBands;
                         i++) {
                        int x =
                          ps[i];
                        ps[i] =
                          gammaLut[x];
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    pd[0] =
                      grayLut[ps[0]];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      grayLut[val];
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGB:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGBA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    pd[3] =
                      alphaPalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    if (r ==
                          redTransparentAlpha &&
                          g ==
                          greenTransparentAlpha &&
                          b ==
                          blueTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int g =
                      ps[0];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[g];
                    }
                    else {
                        pd[0] =
                          g;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    int gamma =
                      gammaLut[val];
                    pd[0] =
                      gamma;
                    pd[1] =
                      gamma;
                    pd[2] =
                      gamma;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_ALPHA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int val2 =
                      grayLut[val];
                    pd[0] =
                      val2;
                    pd[1] =
                      val2;
                    pd[2] =
                      val2;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
        }
    }
    private void decodePass(java.awt.image.WritableRaster imRas,
                            int xOffset,
                            int yOffset,
                            int xStep,
                            int yStep,
                            int passWidth,
                            int passHeight) {
        if (passWidth ==
              0 ||
              passHeight ==
              0) {
            return;
        }
        int bytesPerRow =
          (inputBands *
             passWidth *
             bitDepth +
             7) /
          8;
        int eltsPerRow =
          bitDepth ==
          16
          ? bytesPerRow /
          2
          : bytesPerRow;
        byte[] curr =
          new byte[bytesPerRow];
        byte[] prior =
          new byte[bytesPerRow];
        java.awt.image.WritableRaster passRow =
          createRaster(
            passWidth,
            1,
            inputBands,
            eltsPerRow,
            bitDepth);
        java.awt.image.DataBuffer dataBuffer =
          passRow.
          getDataBuffer(
            );
        int type =
          dataBuffer.
          getDataType(
            );
        byte[] byteData =
          null;
        short[] shortData =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            byteData =
              ((java.awt.image.DataBufferByte)
                 dataBuffer).
                getData(
                  );
        }
        else {
            shortData =
              ((java.awt.image.DataBufferUShort)
                 dataBuffer).
                getData(
                  );
        }
        int srcY;
        int dstY;
        for (srcY =
               0,
               dstY =
                 yOffset;
             srcY <
               passHeight;
             srcY++,
               dstY +=
                 yStep) {
            int filter =
              0;
            try {
                filter =
                  dataStream.
                    read(
                      );
                dataStream.
                  readFully(
                    curr,
                    0,
                    bytesPerRow);
            }
            catch (java.lang.Exception e) {
                e.
                  printStackTrace(
                    );
            }
            switch (filter) {
                case PNG_FILTER_NONE:
                    break;
                case PNG_FILTER_SUB:
                    decodeSubFilter(
                      curr,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_UP:
                    decodeUpFilter(
                      curr,
                      prior,
                      bytesPerRow);
                    break;
                case PNG_FILTER_AVERAGE:
                    decodeAverageFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_PAETH:
                    decodePaethFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                default:
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder16");
                    throw new java.lang.RuntimeException(
                      msg);
            }
            if (bitDepth <
                  16) {
                java.lang.System.
                  arraycopy(
                    curr,
                    0,
                    byteData,
                    0,
                    bytesPerRow);
            }
            else {
                int idx =
                  0;
                for (int j =
                       0;
                     j <
                       eltsPerRow;
                     j++) {
                    shortData[j] =
                      (short)
                        (curr[idx] <<
                           8 |
                           curr[idx +
                                  1] &
                           255);
                    idx +=
                      2;
                }
            }
            processPixels(
              postProcess,
              passRow,
              imRas,
              xOffset,
              xStep,
              dstY,
              passWidth);
            byte[] tmp =
              prior;
            prior =
              curr;
            curr =
              tmp;
        }
    }
    private void decodeImage(boolean useInterlacing) {
        if (!useInterlacing) {
            decodePass(
              theTile,
              0,
              0,
              1,
              1,
              width,
              height);
        }
        else {
            decodePass(
              theTile,
              0,
              0,
              8,
              8,
              (width +
                 7) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              4,
              0,
              8,
              8,
              (width +
                 3) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              0,
              4,
              4,
              8,
              (width +
                 3) /
                4,
              (height +
                 3) /
                8);
            decodePass(
              theTile,
              2,
              0,
              4,
              4,
              (width +
                 1) /
                4,
              (height +
                 3) /
                4);
            decodePass(
              theTile,
              0,
              2,
              2,
              4,
              (width +
                 1) /
                2,
              (height +
                 1) /
                4);
            decodePass(
              theTile,
              1,
              0,
              2,
              2,
              width /
                2,
              (height +
                 1) /
                2);
            decodePass(
              theTile,
              0,
              1,
              1,
              2,
              width,
              height /
                2);
        }
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        if (tileX !=
              0 ||
              tileY !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder17");
            throw new java.lang.IllegalArgumentException(
              msg);
        }
        return theTile;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "g9XUIM6RlJw9gZNVC8Bx7PNd7B5iUCC8");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "UfiCvVmLroZHkeid24YOOHjb8pf5r1LjuQZIPyhMBnRm4nHLgQTWwwnKzZTe" +
       "aTCNDWLpcPZzxMEfUXJEX1+5URIw+WvL4DZOvZ2S6X2hxp8pxk8r7c2UTFLT" +
       "AhX7tFLdSslYGRXIB6k1908pGeWUG3JCas15J8Tx9pzAn31a8/0MGnw+HyXl" +
       "/Maa5V4oHbLg7X1m1jWf2CclszNEWg18h8PP+9RjzB56+QufghMX2A8Rji5l" +
       "Z5YVG9Okp4E0ZJrF7uBd205tPO/jeTezA1KC0bi2YQOWMjBMKvCsd42/8AkU" +
       "7TS2lpYtq3zZzAND7jpoRnYNyHAucL7RTsi3J1ILvsdEsx+fP0yF/RJ7ejr7" +
       "wKMxXt1xwu5nLy3f6ye+lcSnQfCzkh99gu8Eq/kJFYt6zUyKHLoybN9hbj0z" +
       "Y1HlW+c+/9nvfSNQNJPwY00mqSgi0S27X2vuNM1r/eSgerBL3HHfTiqN9JL1" +
       "iRY9ujZVTwZkEsaajF4fg9bWgaeAcF3JTiQZXHAiCSVT7T8x3ocTSAYrTyDh" +
       "vzuO4Q9ZyVargWFGwg2mKQ4fCb7MNG+a6ICCT+I/Xf8HrA0+Kc+UAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wanjh9CH3v8Y9sV/lh5/5FqSo18U3+z9QTB5dGzuB6Z/c/mlt/385cztw8wD" +
       "yiZSFWU7ShrsEERnwUH4CqLZE/tPRlrrsOLJQ9f5gtNu7dhpTzu1o14HfE9y" +
       "J9/vOuXHnpdoGQLbezf9+3tP+7G051nXcYIEmkSo6Zr/4B/+qw/+r7e/s3w5" +
       "aUjX5gk60MoDR/mYKAmIv+ZD3/zCu9/z6a9LHc1B0Xh6+pek6RNJ8oVp/V5J" +
       "vr4S+KEgja1DII7hyPbGH/0j+LsEtn9ItqSk5Id1MPIgtomIHj8MiTzQ0d4H" +
       "GuANjKXY3g2iVx2cbT0d35gCVzvfRIXQWx78fev9n/nBdcR32lROZda+9j3/" +
       "4h+vf+N7Lh+Ls192U6h7/Jh1rJ3Wxb1JwiSN7yVnnSU9ovHHH37Lv/2+t7xz" +
       "TfXgyagRB4OiH/ytv/+16+/79C9vCTuugBHBuk9K0nKSNNaqfXJnS3zjSTtJ" +
       "Gua3bOzkW7bYSfKFSPxo8uVLzqrkJKGShE51wISZe48qq0fUkh/5U7Rv2pM2" +
       "B7b3bWjfdwZtSqTsR/ucI9pOlcJ5Ht9GrO5JXADbt26Iv/UM4qvJF2s/4odP" +
       "NoYbVarTrG6DtveERsH2bRvobzsD+rbkS7Af9EMnjGI3c3h+5ucnv94Gtu/Y" +
       "ML//JuZM+uXLd6CGmds935gDJ3Mz731gjOamg1gGNL0AtOmX7/Y4aUyydiAf" +
       "+Ncv+/jbPvCyP0i71zuMAHj1qq9vGfAeO+avPvT7f/bJe1/4Q2noe3UkB2v/" +
       "fnqm4OaJgBPj+5T8nkPtPJwo4zGwXdpo59Law9642cN+0eOzSA6MWeSG2ivX" +
       "kePja8f9eOq2H1/PEnzJmx+n2Tp+g6nSOPf46x93tMVmz5fL09FbvuT69etv" +
       "fvJVnhcfxEDHupB1vq3B0huT5KsP6uqfb6+ry4dmdVhDt9mao68HuKkR/bPN" +
       "iZPytwaBKQhmu46WRKIH+x4+CNQO53jAzvgmUj/z6t31T6fVcBQ0/OJX/elj" +
       "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" +
       "eybV463BqDh2NTpXwOvqrGuy08Fg0O9j");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("XmdCzATPXTL1iuT1qli/OfEsGBGWctGrVhbF1oLo9ZhpNF/VWJrCCDdYrWpz" +
       "vlAYTz1ygoqS3J/BxS6KoKo6acFwv9KW2tZ0sJyXUNeRh5LGFcN+rCnt3nAh" +
       "O3ZkTWZ2vj7Ow4uOVpyscMRkupzB9WycoUPNdIdScd5cTHsuFM7liCnykkXn" +
       "LAEb1Kme5U17RZaOYMKb9KsVOsg7i8hqFhdOYMII1h02STecqUvatTCBx6wg" +
       "Znpc3y27nueQdUyg3Wqr1FrIsJVn3KAihjpk1lvFKC/N+8hAUppLppajw14r" +
       "bLdQoYdhVY/JCW1Tg4uEA88aA76VRawsTs46tX6nL7pKn63PWLgny7Tvqjg9" +
       "xWt9ajyx47DHm4SqiQjG61hONFTSauva3IqnYhaDBmBXscpGg05DZhXMztYX" +
       "Vb/eqwaIPK2VulMuCEWiFYABEVk1JvlmUR5WaxwWFlVmpq4ofMblzEWt59R4" +
       "jovI0WzWLzdR3M51maGO4/Ai7hdowfDdXKhNZr4QdYQ61Xdm2WEHJZXaqtFo" +
       "VS3bzeaHfdzuclkmDPuc5yzKIx4yI21g2xgPxbqyiDs9r5ntKhjMdUfCYK7N" +
       "ZBWWq5qiMFhQJiV52lLmlR6NTYXxiJ7T5c4KglCEmfIVf0XS5dWCa3SEsjLr" +
       "CK4J92C1i6CoR4ym5S4uDFBsyNfCQbYrtfpc6Descr8y9HVZGVlcwDVFddrU" +
       "EFfrZCMsB0l5SOaWjtdrWlCDrlfMXpkwlvGKN7SZx/JZ3TO1Waw57a7jmmLA" +
       "jhGvSkULeIgVKuWcClBV0essIyqYQS0rG1cEpGo33JY7Q9VCS8XkVaU4JKKK" +
       "XfFhB5diLPK1tjYW28u575ZyMiPJCB4OOI5DlJxHslQTCJ3twVB93F1q08CZ" +
       "1f06hAhjZjb0xo5QmApTrIsotiCWBEIMibCMaoHT932ZknrV8rDb7ErjRhvO" +
       "LcDJiex8VpYDm3WK0sxq8UynDE3HmjG05Ah802G9GEfoAg2pob3kTcsUuPxw" +
       "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" +
       "vzYkF8Qq5ulBX3H0VteXjXynETGmaBWj");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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");
}
