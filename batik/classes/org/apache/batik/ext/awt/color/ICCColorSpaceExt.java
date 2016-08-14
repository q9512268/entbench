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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zLgkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4veTyrsjzZWLnItyxVmASiJLuUjjr34v");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NPYPNfa/Txr/99to/D+K4htAY3kVB26avK3G/+174cvZocbZ90njP3lrjS+V" +
       "4/0v4MtxkcxbMulFev7xnei5TSrXzmcJFilPj9+SlrxPpVU+9/rV+971uvCv" +
       "99vaUbrr/ePKfXrquqdTKU7VL4eRplulgvfvEyvCUqN7k8pTt09hLCiv+F8A" +
       "v3R53+pKUnn8rVollbtAeVr6QcDdF0kDSVCelrwGbHFeEoxf/j8t92hSuXIi" +
       "B3aYfeW0yGOgdyBSVN8VHm0hT16QDHZi+O2ls2Hi8Xw+8nbzeSqyfP5MOFNm" +
       "oB/Fbuk+B/2m8vnXSfrHvgX/7D5lUHHlPC96uQ9EHvvsxeP479m37O2or8uj" +
       "F7/90C/c/8JRrPrQHvDJYjiF7emL8/MGXpiUGXX5P3rXL/3Q33v9d8sUmP8L" +
       "906mfhowAAA=");
}
