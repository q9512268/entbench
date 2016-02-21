package org.sunflow.image;
public final class ChromaticitySpectrum extends org.sunflow.image.SpectralCurve {
    private static final float[] S0Amplitudes = { 0.04F, 6.0F, 29.6F, 55.3F,
    57.3F,
    61.8F,
    61.5F,
    68.8F,
    63.4F,
    65.8F,
    94.8F,
    104.8F,
    105.9F,
    96.8F,
    113.9F,
    125.6F,
    125.5F,
    121.3F,
    121.3F,
    113.5F,
    113.1F,
    110.8F,
    106.5F,
    108.8F,
    105.3F,
    104.4F,
    100.0F,
    96.0F,
    95.1F,
    89.1F,
    90.5F,
    90.3F,
    88.4F,
    84.0F,
    85.1F,
    81.9F,
    82.6F,
    84.9F,
    81.3F,
    71.9F,
    74.3F,
    76.4F,
    63.3F,
    71.7F,
    77.0F,
    65.2F,
    47.7F,
    68.6F,
    65.0F,
    66.0F,
    61.0F,
    53.3F,
    58.9F,
    61.9F };
    private static final float[] S1Amplitudes = { 0.02F, 4.5F, 22.4F, 42.0F,
    40.6F,
    41.6F,
    38.0F,
    42.4F,
    38.5F,
    35.0F,
    43.4F,
    46.3F,
    43.9F,
    37.1F,
    36.7F,
    35.9F,
    32.6F,
    27.9F,
    24.3F,
    20.1F,
    16.2F,
    13.2F,
    8.6F,
    6.1F,
    4.2F,
    1.9F,
    0.0F,
    -1.6F,
    -3.5F,
    -3.5F,
    -5.8F,
    -7.2F,
    -8.6F,
    -9.5F,
    -10.9F,
    -10.7F,
    -12.0F,
    -14.0F,
    -13.6F,
    -12.0F,
    -13.3F,
    -12.9F,
    -10.6F,
    -11.6F,
    -12.2F,
    -10.2F,
    -7.8F,
    -11.2F,
    -10.4F,
    -10.6F,
    -9.7F,
    -8.3F,
    -9.3F,
    -9.8F };
    private static final float[] S2Amplitudes = { 0.0F, 2.0F, 4.0F, 8.5F,
    7.8F,
    6.7F,
    5.3F,
    6.1F,
    3.0F,
    1.2F,
    -1.1F,
    -0.5F,
    -0.7F,
    -1.2F,
    -2.6F,
    -2.9F,
    -2.8F,
    -2.6F,
    -2.6F,
    -1.8F,
    -1.5F,
    -1.3F,
    -1.2F,
    -1.0F,
    -0.5F,
    -0.3F,
    0.0F,
    0.2F,
    0.5F,
    2.1F,
    3.2F,
    4.1F,
    4.7F,
    5.1F,
    6.7F,
    7.3F,
    8.6F,
    9.8F,
    10.2F,
    8.3F,
    9.6F,
    8.5F,
    7.0F,
    7.6F,
    8.0F,
    6.7F,
    5.2F,
    7.4F,
    6.8F,
    7.0F,
    6.4F,
    5.5F,
    6.1F,
    6.5F };
    private static final org.sunflow.image.RegularSpectralCurve kS0Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S0Amplitudes,
      300,
      830);
    private static final org.sunflow.image.RegularSpectralCurve kS1Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S1Amplitudes,
      300,
      830);
    private static final org.sunflow.image.RegularSpectralCurve kS2Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S2Amplitudes,
      300,
      830);
    private static final org.sunflow.image.XYZColor S0xyz = kS0Spectrum.toXYZ(
                                                                          );
    private static final org.sunflow.image.XYZColor S1xyz = kS1Spectrum.toXYZ(
                                                                          );
    private static final org.sunflow.image.XYZColor S2xyz = kS2Spectrum.toXYZ(
                                                                          );
    private final float M1;
    private final float M2;
    public ChromaticitySpectrum(float x, float y) { super();
                                                    M1 = (-1.3515F - 1.7703F *
                                                            x +
                                                            5.9114F *
                                                            y) / (0.0241F +
                                                                    0.2562F *
                                                                    x -
                                                                    0.7341F *
                                                                    y);
                                                    M2 = (0.03F - 31.4424F *
                                                            x +
                                                            30.0717F *
                                                            y) / (0.0241F +
                                                                    0.2562F *
                                                                    x -
                                                                    0.7341F *
                                                                    y); }
    public float sample(float lambda) { return kS0Spectrum.sample(lambda) +
                                          M1 *
                                          kS1Spectrum.
                                          sample(
                                            lambda) +
                                          M2 *
                                          kS2Spectrum.
                                          sample(
                                            lambda); }
    public static final org.sunflow.image.XYZColor get(float x, float y) {
        float M1 =
          (-1.3515F -
             1.7703F *
             x +
             5.9114F *
             y) /
          (0.0241F +
             0.2562F *
             x -
             0.7341F *
             y);
        float M2 =
          (0.03F -
             31.4424F *
             x +
             30.0717F *
             y) /
          (0.0241F +
             0.2562F *
             x -
             0.7341F *
             y);
        float X =
          S0xyz.
          getX(
            ) +
          M1 *
          S1xyz.
          getX(
            ) +
          M2 *
          S2xyz.
          getX(
            );
        float Y =
          S0xyz.
          getY(
            ) +
          M1 *
          S1xyz.
          getY(
            ) +
          M2 *
          S2xyz.
          getY(
            );
        float Z =
          S0xyz.
          getZ(
            ) +
          M1 *
          S1xyz.
          getZ(
            ) +
          M2 *
          S2xyz.
          getZ(
            );
        return new org.sunflow.image.XYZColor(
          X,
          Y,
          Z);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfXAV1RW/7yWEkA/ygYQYCR9JwAniexBU1CiKAST4ApkE" +
                                                              "GQ1I2Oy7L1nYt7vu3pe8oFRl2oqdKYMtKnY0f1QslOLH2Dp1pmrptH6NHzN+" +
                                                              "1VqnWp2OpbW0UkfbEVt7zr27bz/e20dJp2Zmb/bt3nvu+d1zzu/cc/foCTLF" +
                                                              "MskcqrEYGzeoFVutsV7JtGiyS5UsayM8G5TvKZE+2Xp8/SVRUjZApo9IVo8s" +
                                                              "WXSNQtWkNUCaFc1ikiZTaz2lSRzRa1KLmqMSU3RtgMxUrO60oSqywnr0JMUO" +
                                                              "myQzQeokxkxlKMNoty2AkeYEaBLnmsRXBl93JkiVrBvjbvdGT/cuzxvsmXbn" +
                                                              "shipTWyXRqV4hilqPKFYrDNrkvMMXR0fVnUWo1kW265eaC/BusSFeUvQ8mjN" +
                                                              "Z6f2jdTyJZghaZrOODyrj1q6OkqTCVLjPl2t0rR1I/kaKUmQSk9nRtoSzqRx" +
                                                              "mDQOkzpo3V6gfTXVMukuncNhjqQyQ0aFGJnvF2JIppS2xfRynUFCObOx88GA" +
                                                              "dl4OrUCZB/Gu8+L779la+1gJqRkgNYrWj+rIoASDSQZgQWl6iJrWymSSJgdI" +
                                                              "nQbG7qemIqnKTtvS9ZYyrEksA+Z3lgUfZgxq8jndtQI7AjYzIzPdzMFLcYey" +
                                                              "f01JqdIwYG1wsQqEa/A5AKxQQDEzJYHf2UNKdyhakpG5wRE5jG3XQAcYOjVN" +
                                                              "2Yiem6pUk+ABqRcuokracLwfXE8bhq5TdHBAk5GmUKG41oYk75CG6SB6ZKBf" +
                                                              "r3gFvabxhcAhjMwMduOSwEpNASt57HNi/WV7b9LWalESAZ2TVFZR/0oYNCcw" +
                                                              "qI+mqEkhDsTAqkWJu6WGp/ZECYHOMwOdRZ+f3nzyysVzjj0v+pxToM+Goe1U" +
                                                              "ZoPywaHpr87uar+kBNUoN3RLQeP7kPMo67XfdGYNYJiGnER8GXNeHut79vpb" +
                                                              "j9CPoqSim5TJuppJgx/VyXraUFRqXk01akqMJrvJNKolu/j7bjIV7hOKRsXT" +
                                                              "DamURVk3KVX5ozKd/4YlSoEIXKIKuFe0lO7cGxIb4fdZgxBSDReph2sqEX/8" +
                                                              "PyNSfERP07gkS5qi6fFeU0f8aFAtKcUZteA+CW8NPW5ltJSqj8UtU47r5nDu" +
                                                              "t5IGy8e7Rkw9jaGksPF+A2SYmXQMXc34KibJItIZY5EIGGF2kAJUiJ61upqk" +
                                                              "5qC8P3PV6pMPD74o3AtDwl4jRhbCfDF7vhifL1ZoPhKJ8GnOwnmFncFKOyDe" +
                                                              "gXCr2vtvWLdtT0sJOJgxVgpLjF1bfImnyyUFh8kH5b+ve3/Z2l2Xvh4lUeCN" +
                                                              "IUg8Lv/P8/A/Ji5Tl2kS6CcsDzhcGA9n/oI6kGMHxm7bdMsSroOX0FHgFOAi" +
                                                              "HN6LNJyboi0YyIXk1tx+/LNH7t6luyHtyxBOYssbiUzREjRmEPygvGie9Pjg" +
                                                              "U7vaoqQU6Acol0kQIsBmc4Jz+Bij02FfxFIOgFO6mZZUfOVQZgUD+4+5T7iX" +
                                                              "1fH7s8C0lRhCc+Fqt2OK/8e3DQa2s4RXoq8EUHB2v7zfuP83r/xpGV9uJxHU" +
                                                              "eDJ4P2WdHvJBYfWcZupc19toUgr9fneg97t3nbh9M/c76NFaaMI2bLuAdMCE" +
                                                              "sMzfeP7Gt9979+AbUddXGWTfzBBsYrI5kPicVBQBCbMtdPUB8lIhTtBr2q7V" +
                                                              "wCuVlCINqRSD44uaBUsf/8veWuEHKjxx3Gjx6QW4z8++itz64tZ/zOFiIjIm" +
                                                              "T3fN3G6CkWe4kleapjSOemRve6353uek+4HbgU8tZSflFBnlaxD1xyvu5foz" +
                                                              "QxZEnZIGM4za2aajd5u8p633DyKTnF1ggOg383D825ve2v4SN3I5xjU+R9zV" +
                                                              "nqhdaQ57PKxWLP6X8BeB69944aLjA8Ha9V126piXyx2GkQXN24ts9vwA4rvq" +
                                                              "39tx3/GHBIBgbg10pnv2f+vL2N79wnJiA9KatwfwjhGbEAEHm4tRu/nFZuEj" +
                                                              "1vzxkV0/O7zrdqFVvT+drobd4kO//tdLsQO/f6EAf0MI6ZLYRi5DZ87R71l+" +
                                                              "6whIq+6oeXJffckaYI1uUp7RlBsztDvplQk7KCsz5DGXu7XhD7zg0DSMRBaB" +
                                                              "FfDBct5ewHWJ5zQiXCPC312NTZvlZVC/xTw75UF53xsfV2/6+OmTHLV/q+0l" +
                                                              "jB7JEEteh80CXPJZwSy1VrJGoN8Fx9ZvqVWPnQKJAyBRhv2ltcGEFJn10Yvd" +
                                                              "e8rU3/7ilw3bXi0h0TWkApY5uUbiTE2mAUVSawSya9a44krBEGPl0NRyqCQP" +
                                                              "PAbl3MLhvjptMB6gO5+Y9ZPLDk28y5lJUNE5fHglpndfMuXlmZsLjry+/M1D" +
                                                              "d949JvynSDQExjV+vkEd2v3BP/MWmKe+AgESGD8QP3pfU9eKj/h4Nwfh6NZs" +
                                                              "/pYEsrQ7tuNI+tNoS9kzUTJ1gNTKdjm0SVIzyOwDUAJYTo0EJZPvvX87L/au" +
                                                              "nbkcOzsYoZ5pg9nP6/alzOfibsI7Gy24Aq7pdi4oDya8COE31/EhC3nbjs1i" +
                                                              "br4SRqYapgIlM2heZvHKC+NW0SQ1kHEaHekFZmGkqn/JSiy2WSYJfuur7HP8" +
                                                              "y+lexPqWymd/bj3w4WPCKwqxe6CWOHyoXH4n/Sxnd5zyopxyHPkMuJps5ZoE" +
                                                              "Iw/971tcWTdp3HAoMb4Rik5tWKU9EF7ORvormAVJY0F43HhWdeIHra/cMtH6" +
                                                              "PqeQcsUC74I8VqC684z5+Oh7H71W3fww36uVYjq0udVfFudXvb5iltukBpuk" +
                                                              "oNs80sfffaKD7ZI7CrtkFG/Px2YrF3UxOKZKtWE2wnteaucu/LeCkRLQC28V" +
                                                              "m5WWebYN+LuR2RsOjEeoanWN4t7FeSdKBkWP5U4U4GW2QMZq9nFcD4fuEkbF" +
                                                              "N5fMSLBsKr9WQElzQqqBReFGDU7w3O4/N21cMbLtDAqBuQGbB0X+sOfoC1cv" +
                                                              "lL8T5UcRgp/yjjD8gzr9rFRhUpYxNX/6bXGdQBEGxmYRt1qR7HtLkXe3YXMz" +
                                                              "0JKM5hPWLtL969y7ej2ZzjYj/lxlVwDYrsXmemHta0JTZZ+fbC+Bq8FmmtoQ" +
                                                              "st0TQrZ4uwWbG4R75xNsbYhkJNilLsHiMzkA5I4zBHI5XM32dI0hQPZNGkhj" +
                                                              "iGQE0lEcyJ1nCCRNRM1HnP8FgByYNJAwyYxU7uhf4hxBOHxS4MSijw5nVMkU" +
                                                              "PSW1K2OO0gDieyeBeJ6t17wQxN+fNOIwyRzxUgcxPpoI4HhgEjjm27PND8Fx" +
                                                              "ZNI4wiRzHB3FcPzoDHHgBqzVnq01BMdjk8YRJhkIsX9Jdnyn43tN+b533fUD" +
                                                              "sJ3XzQC+H08CX5utRVsIvicnjS9MMuJbCvjwxxMBBE9NAsECe54FIQh+NWkE" +
                                                              "YZIRQUcIgmf+ewR4SMz551x7nnNDELxUZEe1pZDydUWEMhLtWYp3ywOav/x/" +
                                                              "0PwNbF7BKTsKTflmkSmzp99G5vThf1UkcObu0cdT2RLcdzeHfRbhZyMHd++f" +
                                                              "SG54cKlTlFzBoPrWjfNVOkpVjyixFXXVwGUns+CK2WrEgsvi4hfbp/zDv7Ch" +
                                                              "gY2RZ+sjjkA+LLJzOo7N+1gISpCheZZa7hrhg9PZ3XeogA96A7g5E2OYd9jK" +
                                                              "dxTBXTAOzw+Nw1lFxAYgR10HWe4uzCdFFuZTbE5AtTFMebXxhLsqfz3zVclC" +
                                                              "3VHoOwYexDTmfS0VX/jkhydqymdNXPuWqNOcr3BVCVKeyqiq96zAc19mmDSl" +
                                                              "cAhV4uRAnIZ9wUhdXrYAtuL/udanRMcvIVl6OjI8gON3nk6RKCwMdMLbEsPJ" +
                                                              "RnPzs5FvC5SN+GMtt6AzT7egnvBs9VVQ/Hu0U+1kxBfpQfmRiXXrbzp50YPi" +
                                                              "UF9WpZ2cjyuhghXfF3IV0/xQaY6ssrXtp6Y/Om2BE/B1QmHXa8/xOE0vxJ2B" +
                                                              "Nm0KnHhbbbmD77cPXvb0y3vKXoOKfTOJSFCsbs4/PsoaGWCizYn8Q1OoJvlR" +
                                                              "fGf798ZXLE797R1+PkdEyTo7vP+gPO3zvTvnW5FYlEzrBrtrSZrl51qrxrU+" +
                                                              "Ko+avhPYsiE9o+WOAqaj80n4nZqvir2Y1bmn+EGIkZb8w+j8j2QV4BzUvAql" +
                                                              "o5jqQH2ZMQzvW76qXdhcnMVVBrcbTPQYhnMK/xxfdcPAKIs04I9V/wFhdWFH" +
                                                              "aCIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Vg5anPm+cNfRjsa6f/Dy249+7YGXjoz1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "0T3gE1U8he25O1/WItwgLq9X5b/y5D/4yN974/fKTd3/C4Vj2+wcLgAA";
}
