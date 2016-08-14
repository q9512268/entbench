package org.apache.batik.extension.svg;
public class BatikHistogramNormalizationFilter8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.extension.svg.BatikHistogramNormalizationFilter {
    private float trim = 0.01F;
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
    public float getTrim() { return trim; }
    public void setTrim(float trim) { this.trim = trim;
                                      touch(); }
    public BatikHistogramNormalizationFilter8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                                 float trim) {
        super(
          );
        setSource(
          src);
        setTrim(
          trim);
    }
    protected int[] histo = null;
    protected float slope;
    protected float intercept;
    public void computeHistogram(java.awt.image.renderable.RenderContext rc) {
        if (histo !=
              null)
            return;
        org.apache.batik.ext.awt.image.renderable.Filter src =
          getSource(
            );
        float scale =
          100.0F /
          src.
          getWidth(
            );
        float yscale =
          100.0F /
          src.
          getHeight(
            );
        if (scale >
              yscale)
            scale =
              yscale;
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scale,
            scale);
        rc =
          new java.awt.image.renderable.RenderContext(
            at,
            rc.
              getRenderingHints(
                ));
        java.awt.image.RenderedImage histRI =
          getSource(
            ).
          createRendering(
            rc);
        histo =
          new org.apache.batik.extension.svg.HistogramRed(
            convertSourceCS(
              histRI)).
            getHistogram(
              );
        int t =
          (int)
            (histRI.
               getWidth(
                 ) *
               histRI.
               getHeight(
                 ) *
               trim +
               0.5);
        int c;
        int i;
        for (c =
               0,
               i =
                 0;
             i <
               255;
             i++) {
            c +=
              histo[i];
            if (c >=
                  t)
                break;
        }
        int low =
          i;
        for (c =
               0,
               i =
                 255;
             i >
               0;
             i--) {
            c +=
              histo[i];
            if (c >=
                  t)
                break;
        }
        int hi =
          i;
        slope =
          255.0F /
            (hi -
               low);
        intercept =
          slope *
            -low /
            255.0F;
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
        computeHistogram(
          rc);
        java.awt.image.SampleModel sm =
          srcRI.
          getSampleModel(
            );
        int bands =
          sm.
          getNumBands(
            );
        org.apache.batik.ext.awt.image.TransferFunction[] tfs =
          new org.apache.batik.ext.awt.image.TransferFunction[bands];
        org.apache.batik.ext.awt.image.TransferFunction tf =
          new org.apache.batik.ext.awt.image.LinearTransfer(
          slope,
          intercept);
        for (int i =
               0;
             i <
               tfs.
                 length;
             i++)
            tfs[i] =
              tf;
        return new org.apache.batik.ext.awt.image.rendered.ComponentTransferRed(
          convertSourceCS(
            srcRI),
          tfs,
          null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "umQ1FOJF3Gp8a/8fRz4z3F0jAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uONa7v4qqfTZl6499I6X2D/aHzEfX/e8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Mqs8pMa2ffbM/0z+kh8oqlFyfmV/A8Av/oojnqfvv5ZFlQdAWvByobLv82BU" +
       "efLefQAGnuTP9roMjOp8r6hysfw/2+5qVLl62i6qXNpnzjZ5BNAEmhTZR/1j" +
       "hY1f+02lnhhGgSBFmGcX9+yA0IGsSxVQ5THuhTPL65H1lsp+/Lsp+6TL2btn" +
       "BRnlTezjM9p4fxf7lvS5lybzH3u19cv7u2+SLeR5McpDs8rl/TW8k3Ped99z" +
       "tOOxLo3e951HP3/l+eNw4dE9waeedIa2Z+5+0Wzg+FF5NSz/B+/4+z/4d1/6" +
       "Snko9r8B1n95eCIvAAA=");
}
