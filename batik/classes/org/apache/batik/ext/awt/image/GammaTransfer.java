package org.apache.batik.ext.awt.image;
public class GammaTransfer implements org.apache.batik.ext.awt.image.TransferFunction {
    public byte[] lutData;
    public float amplitude;
    public float exponent;
    public float offset;
    public GammaTransfer(float amplitude, float exponent, float offset) {
        super(
          );
        this.
          amplitude =
          amplitude;
        this.
          exponent =
          exponent;
        this.
          offset =
          offset;
    }
    private void buildLutData() { lutData = (new byte[256]);
                                  int j;
                                  int v;
                                  for (j = 0; j <= 255; j++) { v = (int) java.lang.Math.
                                                                     round(
                                                                       255 *
                                                                         (amplitude *
                                                                            java.lang.Math.
                                                                            pow(
                                                                              j /
                                                                                255.0F,
                                                                              exponent) +
                                                                            offset));
                                                               if (v >
                                                                     255) {
                                                                   v =
                                                                     (byte)
                                                                       255;
                                                               }
                                                               else
                                                                   if (v <
                                                                         0) {
                                                                       v =
                                                                         (byte)
                                                                           0;
                                                                   }
                                                               lutData[j] =
                                                                 (byte)
                                                                   (v &
                                                                      255);
                                  } }
    public byte[] getLookupTable() { buildLutData(
                                       );
                                     return lutData;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EK/YvPlvYVGLz/wcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JwAA");
}
