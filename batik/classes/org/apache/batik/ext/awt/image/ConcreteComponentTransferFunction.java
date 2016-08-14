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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qtJZB659VZwfZr7wqYiR0kRKVd3vj1z3xYZJEwoHtUK8TeJH9PgOtiF4D8nI" +
       "ZP6LBoX6BVeCkTo/LkaKoHVTK4xML0QNlNC6KVUoY7yUMD7/ddPpjJQ5dLBd" +
       "FDduEhOkAwneWsL5YLtc7RxSipd0abGTnuOeNF4tzTjbXGdZ3K/sEQL+nV3m" +
       "jC8lvrTrk48eWLv+5jOfvk98MiCr0ugoSimPkRLx9QIXiueEjb7SMrKK1yz8" +
       "aOojUxZkduY1QmFnwcxxvJq0wY7FQH+a7XmdbrVk36q/dnD5Ez8bK34pTEKb" +
       "SEiCTcum/NeZaSNlkvpNsfy3SBslk7/nb114z8gVSxJ/fp2/MCbiSHeuP32f" +
       "fPLQ5pf31B1sCJPyDnAzLU7T/D3r1SPaBipvM3tJpWKtTIOKuDOX1JxXVFPR" +
       "9SX8Ao/jYsNZmX2KH5ww0pT/di7/M50yVR+m5go9pcVRTGWMlDtPxMx4jlpT" +
       "huFhcJ7YU4ntDdhcwwt/8Me+2DrDyLy8nDLd4CFhczZSeI88Q1/it3i38z/u" +
       "zXtLgysAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n3z5NYX5eeT87n07FUC3B477I6a6Uc0j");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("smzXo7xDHB/MxP4wONAdDvTka9m9pq5fx9nr/C3XEr5yRt2/yIrfCKD7NDXo" +
       "KgC/HiQHKsiqvrw31D99q9eIR8c+gTVrmq+aPrfD+txNxHpu/5Z6uz721TMA" +
       "/0FW/MsAugIA89na1Clo/9W7RZstA/A7tPxfJNqvn4H2j7Li32/N29D9fP/Z" +
       "KYD/w7sFnK0wmDvA5k0EfH7fKl9wGOet/uQM1P8tK/4YEBBAne2SlLxTMH/j" +
       "Zrh0ssOc3ETMt+yJdXwC+HfPAP5nWfHft87dlixLOgX3/3gXuC9nF+8Hx0s7" +
       "3C+9A9xvb/Xz3K1n1F3ILn4/gC5mAbxbfO0eQjsHvQto9xy48Wd20D5z86Fd" +
       "OaPu3qy4M4AuAWhctjEkt/oe213vAtt92cVsD8grO2yv3HxsD59R92hWPBBA" +
       "dx/w7nYzSU5je4QPvlvrPQKOV3cIX735CH/4jLpnsuKpALorm0qPrXPv8V29" +
       "Gfhe3+F7/ebjw8+oK2cFvMVHHFsw3+Mrvlt82Zr+L+3w/dLNx/f8GXVkVjwb" +
       "QHcCfM2jK+97eM+9W3jZTqQv7eB96ebD659RR2dFG+SmAB6zX8Lfg+u8E3Bx" +
       "AD3xlhvas825D173p5vtH0XkL7x2+dIDr43/9Xan18GfOW7vQ5cWoWke3Ut5" +
       "5PyC66mLrR5u3+6sdHNw4wB69OwMP4Buy78zJOf4ba9pAD14Wq8AugWUR1t/" +
       "JIDee6PWoCUoj7b8KJiBT7YE98+/j7aTAuiOfbsAurA9OdpEAaODJtmput3k" +
       "c3x7w3bDarx9znnwqOflE/29b2XTwy5HN5RnKsj/UnWweSrc/qnqBfmLr/Xo" +
       "j3+n/PPbDe2yKaVpNsqlPnRxu7c+HzTbgPXEqaMdjHWh84Hv3f0rtz998Nx0" +
       "91bgfRQcke2xG28eb1pukG/3Tn/9gX/43C+89of5bov/B4thj5XrNgAA");
}
