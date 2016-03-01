package org.apache.batik.ext.awt.color;
public class ICCColorSpaceExt extends java.awt.color.ICC_ColorSpace {
    public static final int PERCEPTUAL = 0;
    public static final int RELATIVE_COLORIMETRIC = 1;
    public static final int ABSOLUTE_COLORIMETRIC = 2;
    public static final int SATURATION = 3;
    public static final int AUTO = 4;
    static final java.awt.color.ColorSpace sRGB = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_sRGB);
    int intent;
    public ICCColorSpaceExt(java.awt.color.ICC_Profile p, int intent) { super(
                                                                          p);
                                                                        this.
                                                                          intent =
                                                                          intent;
                                                                        switch (intent) {
                                                                            case AUTO:
                                                                            case RELATIVE_COLORIMETRIC:
                                                                            case ABSOLUTE_COLORIMETRIC:
                                                                            case SATURATION:
                                                                            case PERCEPTUAL:
                                                                                break;
                                                                            default:
                                                                                throw new java.lang.IllegalArgumentException(
                                                                                  );
                                                                        }
                                                                        if (intent !=
                                                                              AUTO) {
                                                                            byte[] hdr =
                                                                              p.
                                                                              getData(
                                                                                java.awt.color.ICC_Profile.
                                                                                  icSigHead);
                                                                            hdr[java.awt.color.ICC_Profile.
                                                                                  icHdrRenderingIntent] =
                                                                              (byte)
                                                                                intent;
                                                                        }
    }
    public float[] intendedToRGB(float[] values) {
        switch (intent) {
            case ABSOLUTE_COLORIMETRIC:
                return absoluteColorimetricToRGB(
                         values);
            case PERCEPTUAL:
            case AUTO:
                return perceptualToRGB(
                         values);
            case RELATIVE_COLORIMETRIC:
                return relativeColorimetricToRGB(
                         values);
            case SATURATION:
                return saturationToRGB(
                         values);
            default:
                throw new java.lang.Error(
                  "invalid intent:" +
                  intent);
        }
    }
    public float[] perceptualToRGB(float[] values) {
        return toRGB(
                 values);
    }
    public float[] relativeColorimetricToRGB(float[] values) {
        float[] ciexyz =
          toCIEXYZ(
            values);
        return sRGB.
          fromCIEXYZ(
            ciexyz);
    }
    public float[] absoluteColorimetricToRGB(float[] values) {
        return perceptualToRGB(
                 values);
    }
    public float[] saturationToRGB(float[] values) {
        return perceptualToRGB(
                 values);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KsBHKWsGes9QQmrcHa/JzUzyHQVO2Z4HrxVfcnVla3JxBIbMWZnVpTVfzRna" +
       "nCVIU++zDXm1NdNBbYVA9BjZNbs4jsxkCJ36vZ7qzZGRE/N8FaKi1dwz6OqA" +
       "zXpZvKzp3Yg1aGqEIP18UJ11Iy3OppjdDOqTNPebG9czOgG7YXC3p2XUOMpS" +
       "dIRooSgEbLvnzGu6lI0VaQ0hk1aCMQTc0zDZ8mifnsuSkaNyQM9gMkXgIcTW" +
       "1GFbMKSagDWoGr1hB4Iz1pCW4yQNrLkcVmeWj9OZGlTzaahV53LPlVtTbRIj" +
       "TkIa8BQiYc8WJSQdblG0OO74m3d2DPNweax0FFKyAr4KCv7qHZy07IueK5IX" +
       "j47dyr9LlTNhCCeO3U7crVSK25+nbhUpUl5yffZjr7+xZH+udvHgPK4bV+6P" +
       "/eCHHD3VnRNNFVFRL9/6moYpA2WO70p+9WP/6cnpB6wP38HF+jNncJ5t8ueZ" +
       "N7/Uf4/2Uxcrdx3dnNwUwnO60iun70suh3qchN701K3JU0eWfbSw2LPgGR5Y" +
       "dnj2QPN47G7ygvJC4X37sT9z5XfhKDzhxVsbsLyq3d+IvvG3X/jKj7/xwu+X" +
       "13L32ZGkhGhonhPzc6LOt9786jd+88GnPl9GBNytKtFew7PBUjfHQp0KcSrh" +
       "P3BkkCcL/Z85e3QeV/TvafQJaMSFywNpFORKLzkMc/l/01F23qnoPYbjK/FN" +
       "Y3h09vnFw9Ptf3ybE/n3nSKES47umfuIovKc+5cOLgiK9s/cxD96fEqMO76n" +
       "F+EAh2X7cBjbv34UVAcKs3OR/vweadnZCS45z0lP3kt/6TZlXy6SXwH20Qpc" +
       "ezVuI/6VbP//791G5l8UyZtx5cHyHmCpL6c+38eOQZc8+bm3O5E+2epe+dMT" +
       "u6DJDx348Ye+pxO7RFoK/M5ttPy3RfIv48qVQAfuGcSJ4pyn52//WfUsglX0" +
       "Az3175Oe//42en69SH4/rrwr1B2liKcoZ5wNaCa0tfM0/tr3QmPvQGPv+6Tx" +
       "f72Nxv+tSL4JNFbUyHeS+G01/i/fC19O");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("DzROv08a/8mtNb5Q9vc/gS9HRRBvyaTn6fnHd6JnFleuno0ALMKZnrgpHHkf" +
       "Qqt9/o0r9z3+hviv9kveYZjr/XTlPiNxnJNhEifyl4JQN+xSwfv3QRNBqdG9" +
       "ceXp24cnFpRX/C+AX7i0r3U5rjxxq1px5S6QnpR+EHD3edJAEqQnJa8CW5yV" +
       "BP2X/0/KPRpXLh/LgRVmnzkp8hhoHYgU2ceDwyXkqXMCvY4Nn104vYU8Gs9H" +
       "3m48T+w6Xzi11Skjzw/3dck+9vyG9oU3qPGPfbv9c/twQM1R8rxo5T6wK9lH" +
       "Jh7tDZ+7ZWuHbV0avPSdh37x/hcP97EP7QEfT4YT2J45P/aOcIO4jJbL/+Hj" +
       "v/TDf+eN3y3DW/4PBK8zFxIwAAA=");
}
