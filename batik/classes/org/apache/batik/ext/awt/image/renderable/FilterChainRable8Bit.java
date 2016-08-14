package org.apache.batik.ext.awt.image.renderable;
public class FilterChainRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.ext.awt.image.renderable.FilterChainRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private int filterResolutionX;
    private int filterResolutionY;
    private org.apache.batik.ext.awt.image.renderable.Filter chainSource;
    private org.apache.batik.ext.awt.image.renderable.FilterResRable filterRes;
    private org.apache.batik.ext.awt.image.renderable.PadRable crop;
    private java.awt.geom.Rectangle2D filterRegion;
    public FilterChainRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter source,
                                java.awt.geom.Rectangle2D filterRegion) {
        super(
          );
        if (source ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (filterRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        java.awt.geom.Rectangle2D padRect =
          (java.awt.geom.Rectangle2D)
            filterRegion.
            clone(
              );
        crop =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            source,
            padRect,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        this.
          chainSource =
          source;
        this.
          filterRegion =
          filterRegion;
        init(
          crop);
    }
    public int getFilterResolutionX() { return filterResolutionX;
    }
    public void setFilterResolutionX(int filterResolutionX) { touch(
                                                                );
                                                              this.
                                                                filterResolutionX =
                                                                filterResolutionX;
                                                              setupFilterRes(
                                                                );
    }
    public int getFilterResolutionY() { return filterResolutionY;
    }
    public void setFilterResolutionY(int filterResolutionY) {
        touch(
          );
        this.
          filterResolutionY =
          filterResolutionY;
        setupFilterRes(
          );
    }
    private void setupFilterRes() { if (filterResolutionX >=
                                          0) { if (filterRes ==
                                                     null) {
                                                   filterRes =
                                                     new org.apache.batik.ext.awt.image.renderable.FilterResRable8Bit(
                                                       );
                                                   filterRes.
                                                     setSource(
                                                       chainSource);
                                               }
                                               filterRes.
                                                 setFilterResolutionX(
                                                   filterResolutionX);
                                               filterRes.
                                                 setFilterResolutionY(
                                                   filterResolutionY);
                                    }
                                    else {
                                        filterRes =
                                          null;
                                    }
                                    if (filterRes !=
                                          null) {
                                        crop.
                                          setSource(
                                            filterRes);
                                    }
                                    else {
                                        crop.
                                          setSource(
                                            chainSource);
                                    } }
    public void setFilterRegion(java.awt.geom.Rectangle2D filterRegion) {
        if (filterRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        touch(
          );
        this.
          filterRegion =
          filterRegion;
    }
    public java.awt.geom.Rectangle2D getFilterRegion() {
        return filterRegion;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return crop;
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter chainSource) {
        if (chainSource ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Null Source for Filter Chain");
        }
        touch(
          );
        this.
          chainSource =
          chainSource;
        if (filterRes ==
              null) {
            crop.
              setSource(
                chainSource);
        }
        else {
            filterRes.
              setSource(
                chainSource);
        }
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public boolean paintRable(java.awt.Graphics2D g2d) {
        java.awt.Composite c =
          g2d.
          getComposite(
            );
        if (!org.apache.batik.ext.awt.image.SVGComposite.
               OVER.
              equals(
                c))
            return false;
        org.apache.batik.ext.awt.image.GraphicsUtil.
          drawImage(
            g2d,
            getSource(
              ));
        return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext context) {
        return crop.
          createRendering(
            context);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mVP+qcZDjlg8aaB/82+CRLzT/gu964qACykAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "O+6n1RLFpZsgfLgo7gcIo5MIjz30zAO3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("66HF0YY/OkD4R3fefE/cpO2pong0rtwPzNf1E0+NEOJq7zzz2G3Ae6SofBJc" +
       "3zmA9507asDDjPaRo3NoVCgHa1OJ9ifQzrznJtDfVxTPxZULwVGSe71s4fzK" +
       "9x1N9o4Vcvk2FPKOovI9QPQDfey/77hCfvBIIdek9OPy9uAYf6mI9k2UVDwu" +
       "nUFBBFNCTY61fWfTMw4HeuLUQHsCTWWKX8cqa9yKynKwxF/vXHBxyPGxa/61" +
       "sD9pr/zqqxfvffRV8d+UR2OPTsPfx1bu1RPHOXlw7MT9uSDUdLNU6H37Y2RB" +
       "iboXV55/0w9JcfE0cPijAHOG3HNh4spTN+cSV+4xDxV12IuNK4/dqFdcuQuU" +
       "J6mBg771etSAEpQnKcdx5dJpSjB++X2STgR4juniyrn9zUmSOeAOSIrbxdHx" +
       "GezNP1V2VlEcysrBg+XeaR87OV/KVfHhN/KZoy4nDwEXg5Z/gDl89kv2f4F5" +
       "Sfniq33+g99ufm5/CFlx5N2u4HIvWzm/Pw9dMi2eH5+5IbdDXufo57/34K/d" +
       "967DZ90H9wIfz90Tsj19/RO/pBvE5Rnd3T949Nd/+O+++gflYZT/C76behiZ" +
       "NAAA");
}
