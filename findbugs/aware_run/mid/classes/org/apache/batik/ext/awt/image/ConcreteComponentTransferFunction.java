package org.apache.batik.ext.awt.image;
public class ConcreteComponentTransferFunction implements org.apache.batik.ext.awt.image.ComponentTransferFunction {
    private int type;
    private float slope;
    private float[] tableValues;
    private float intercept;
    private float amplitude;
    private float exponent;
    private float offset;
    private ConcreteComponentTransferFunction() { super(); }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getIdentityTransfer() {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          IDENTITY;
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getTableTransfer(float[] tableValues) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          TABLE;
        if (tableValues ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tableValues.
              length <
              2) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        f.
          tableValues =
          (new float[tableValues.
                       length]);
        java.lang.System.
          arraycopy(
            tableValues,
            0,
            f.
              tableValues,
            0,
            tableValues.
              length);
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getDiscreteTransfer(float[] tableValues) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          DISCRETE;
        if (tableValues ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tableValues.
              length <
              2) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        f.
          tableValues =
          (new float[tableValues.
                       length]);
        java.lang.System.
          arraycopy(
            tableValues,
            0,
            f.
              tableValues,
            0,
            tableValues.
              length);
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getLinearTransfer(float slope,
                                                                                             float intercept) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          LINEAR;
        f.
          slope =
          slope;
        f.
          intercept =
          intercept;
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getGammaTransfer(float amplitude,
                                                                                            float exponent,
                                                                                            float offset) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          GAMMA;
        f.
          amplitude =
          amplitude;
        f.
          exponent =
          exponent;
        f.
          offset =
          offset;
        return f;
    }
    public int getType() { return type; }
    public float getSlope() { return slope;
    }
    public float[] getTableValues() { return tableValues;
    }
    public float getIntercept() { return intercept;
    }
    public float getAmplitude() { return amplitude;
    }
    public float getExponent() { return exponent;
    }
    public float getOffset() { return offset;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "e+r6PZjDPn/LfYCvnpH3z/Lk12PovoUe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("DzSA34q3+12QZ33lUFG/8VZLgEfbPoE1L1rshj63h/W5m4j13OEK825v62tn" +
       "AP6DPPnnMXQFAObyfaVT0P6Ld4s2X8Ln9tBy/zfRfuMMtH+UJ/92p96OFRXn" +
       "yk4B/O/eLeB8d8DeA2zfRMDnD0sVmwV8UepPzkD9X/LkjwEBAdT5yUg5PAXz" +
       "N2+GSW/3MG9vIuZbDomVPwH8z84A/ud58l93xk3IjiOfgvu/vQvcl/OH94Pr" +
       "pT3cL70D3G9v5/LcrWfkXcgffj+GLuYOvLdxOjiAdg56F9Du2Tfjz+5B++zN" +
       "h3bljLx78+TOGLoEoE3zAx+F1g+x3fUusN2XP8zPdryyh+2Vm4/t4TPyHs2T" +
       "B2Lo7n3e3R0SKWjsEOGD71Z7j4Dr1T2Er958hD98Rt4zefJUDN2VD6XH9qgP" +
       "8V29Gfhe38P3+s3HVz0jr54n8A5f69hm9yG+8rvFl+/H/9Ievl+6+fiePyOv" +
       "nSfPxtCdAF/36K75Ibzn3i28/ITRl/fgffnmw6PPyGPyhACxKYDHHm6/H4Lr" +
       "vxNwaQw98ZYH1fNDtw9e90eb3Z9D1C++dvnSA6/x/3J3gmv/Dxy309AlI7Ht" +
       "o2ckj9xf8EPd2PXD7bsTk34Bjo+hR8+O8GPotuI7R3KO29WaxdCDp9WKoVtA" +
       "erT0R2PovTcqDUqC9GjJj4ER+GRJ8P7i+2g5OYbuOCwXQxd2N0eLaKB1UCS/" +
       "1XcHdI4fTdgdRE1385wHj1peMdDf+1Y6Pahy9KB43gXF36j2Dz4luz9SvaB+" +
       "6TWS+cR36z+/O6iu2nKW5a1coqGLuzPzRaP54aknTm1tv60L/Q987+5fuf3p" +
       "/XnT3TuBD73giGyP3fhQeNfx4+IYd/YPH/j7z/3Ca39YnJT4P5Bcpi/fNgAA");
}
