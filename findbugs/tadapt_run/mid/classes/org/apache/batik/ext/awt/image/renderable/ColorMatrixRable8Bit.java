package org.apache.batik.ext.awt.image.renderable;
public class ColorMatrixRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.ColorMatrixRable {
    private static float[][] MATRIX_LUMINANCE_TO_ALPHA = { { 0, 0, 0, 0, 0 },
    { 0,
    0,
    0,
    0,
    0 },
    { 0,
    0,
    0,
    0,
    0 },
    { 0.2125F,
    0.7154F,
    0.0721F,
    0,
    0 } };
    private int type;
    private float[][] matrix;
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public int getType() { return type; }
    public float[][] getMatrix() { return matrix; }
    private ColorMatrixRable8Bit() { super(); }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildMatrix(float[][] matrix) {
        if (matrix ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (matrix.
              length !=
              4) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        float[][] newMatrix =
          new float[4][];
        for (int i =
               0;
             i <
               4;
             i++) {
            float[] m =
              matrix[i];
            if (m ==
                  null) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            if (m.
                  length !=
                  5) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            newMatrix[i] =
              (new float[5]);
            for (int j =
                   0;
                 j <
                   5;
                 j++) {
                newMatrix[i][j] =
                  m[j];
            }
        }
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_MATRIX;
        filter.
          matrix =
          newMatrix;
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildSaturate(float s) {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_SATURATE;
        filter.
          matrix =
          (new float[][] { { 0.213F +
             0.787F *
             s,
           0.715F -
             0.715F *
             s,
           0.072F -
             0.072F *
             s,
           0,
           0 },
           { 0.213F -
             0.213F *
             s,
           0.715F +
             0.285F *
             s,
           0.072F -
             0.072F *
             s,
           0,
           0 },
           { 0.213F -
             0.213F *
             s,
           0.715F -
             0.715F *
             s,
           0.072F +
             0.928F *
             s,
           0,
           0 },
           { 0,
           0,
           0,
           1,
           0 } });
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildHueRotate(float a) {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_HUE_ROTATE;
        float cos =
          (float)
            java.lang.Math.
            cos(
              a);
        float sin =
          (float)
            java.lang.Math.
            sin(
              a);
        float a00 =
          0.213F +
          cos *
          0.787F -
          sin *
          0.213F;
        float a10 =
          0.213F -
          cos *
          0.212F +
          sin *
          0.143F;
        float a20 =
          0.213F -
          cos *
          0.213F -
          sin *
          0.787F;
        float a01 =
          0.715F -
          cos *
          0.715F -
          sin *
          0.715F;
        float a11 =
          0.715F +
          cos *
          0.285F +
          sin *
          0.14F;
        float a21 =
          0.715F -
          cos *
          0.715F +
          sin *
          0.715F;
        float a02 =
          0.072F -
          cos *
          0.072F +
          sin *
          0.928F;
        float a12 =
          0.072F -
          cos *
          0.072F -
          sin *
          0.283F;
        float a22 =
          0.072F +
          cos *
          0.928F +
          sin *
          0.072F;
        filter.
          matrix =
          (new float[][] { { a00,
           a01,
           a02,
           0,
           0 },
           { a10,
           a11,
           a12,
           0,
           0 },
           { a20,
           a21,
           a22,
           0,
           0 },
           { 0,
           0,
           0,
           1,
           0 } });
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildLuminanceToAlpha() {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_LUMINANCE_TO_ALPHA;
        filter.
          matrix =
          MATRIX_LUMINANCE_TO_ALPHA;
        return filter;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.image.RenderedImage srcRI =
          getSource(
            ).
          createRendering(
            rc);
        if (srcRI ==
              null)
            return null;
        return new org.apache.batik.ext.awt.image.rendered.ColorMatrixRed(
          convertSourceCS(
            srcRI),
          matrix);
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
       "AyTvP32IesyrWznFP3ct9uprx9637EgL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ykG/fMZh9m8Uya8BlKEW7c8Sb3h2uPMs9VjQ/+j7HRuenOUUpx4oCn8APN0D" +
       "TnXfGE6dBPX1M+r+RZF8FQA2DgEXBb9+DO6fvw5wl4rCh8AzOQA3eePB/cEZ" +
       "df+2SP5lBN0BwB1+S3r+GNrvvw5oxTcL6DHwsAfQ2Dce2n84o+6bRfLHe7lR" +
       "x98YjsH9yesAV150LOrlA3DyLYA7/qrVPcuGS3LLBv/tDJj/vUi+HUFvkmPL" +
       "Vo+B/sox0P/6eoFWwfOpA6Cf+qsBypYN/vzmQM+Vk/7vCLq3BLoo7khLkXYK" +
       "6p+9Xqg18Lx0APWlv0Ko5+4+A+o9RXIhgu4roZKxxhSfnE9hPXfx9WJtgec3" +
       "D7D+5huI9SSUh86oe7hI7o+gB0uYk9ix3OJLN+vhtm9Kp9A+8DrQvq0ofDd4" +
       "vnaA9mu3gPa1L7bvKj/c3XBxZcrswT8ClOCfOoMx7yySRyPokhJoQO77zpZr" +
       "HE709lMT7Rto6rB4O2bZY7fCsjSC3nKj28PFTciHr/u/h/1dfeWLL1+6860v" +
       "L//V/t7V4X36uybQnXps2ycvrp3IX/QDTd87qbv219j8EjUcQc++5nAlKm5A" +
       "HL4UYM5d2Y9Sj6DHzh4lgi5Yh4w67IVG0MM36xVBt4H0ZOsW4NWNWoOWID3Z" +
       "8rkIuny6JZi//D3Z7oMAz3G7CLq4z5xsgoPRQZMi2/EPNWH42uM7XA6jQFKi" +
       "UsjD4iIckGp5kWUf6p47Ea0eWFDpUr+v4R11OXl5uCCj/Keawxsw8f7faq4q" +
       "X3p5NP2R7zZ/fn95WbGlPC9GuXMC3bG/R10OWtyiefKmox2OdZF89nv3/fJd" +
       "7ziMvu/bE3xszSdoe/zGF4UJx4/Kq735r731H7z/7738h+VX9v8HrjmI7u00" +
       "AAA=");
}
