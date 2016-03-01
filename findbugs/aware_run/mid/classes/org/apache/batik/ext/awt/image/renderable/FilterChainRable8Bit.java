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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rBqKRg6VFIHHqZpTmgSrMhrj07b9l1N/fukD+9/kfDUJOoOrRwzMKb2hlh8M" +
       "nCjx4fF73vn1+E+qzLSi3T80evSm/XudPHzdXz8tcjIPiiVSHo/+YOzgvdPj" +
       "nR9wfSc6ofa8XPFmBvHb0V38UOZf4dbI78KkapA0ilYSvlGQs7jmByHxNOzM" +
       "HBL1gvbCJNLMmDry0XemNzK6hvXGRWcThXeUxveJnlBYj7PYCs8SK0os8YbC" +
       "EOEvl3OVBbxsx+I8O/JUaboEhzXqCT11AZ0y0pTiS4+n81mclu/xxePiAh72" +
       "BrLDBuvTpQzE0VErFT3UMr71t1XbV9ppZikVU/Jyo/for7rfG+Jxuhq35/W2" +
       "F1wb73I97dokGk0QX8JPCJ4v8EHjscJM6prjVmZ5Tj611DRcmwHU9ECI7Wx+" +
       "a8u97z9sQvDy0CNM9+678cvoTfvM4GueT+YVHRHcOuYZxYSDxQa0bm7QKFyj" +
       "671DOx9/cOcNplXNhdn2KjhMPvzH/74Qvesvz5VI0Sok64yJsSGUz6NavLNj" +
       "Qoosuu+zXde/tg42/h5SnVWkrVnakyxkbJWRHXZNl3PycVhsgcOpgSRvIcyC" +
       "uW1j2YFFwqRkp28kW1W8Di62KHuxzzowM4oFWKwtJryfdgnCX4EN6z0Wp8q0" +
       "GJOYTmvMTh+L5UCL/bQZqRMxjR7gZwGsWuqxNVOmrfPhiVujxX1sNQJt9dNm" +
       "pCbvXXszv6jcLAB0+ZHBg5KViXI6PN2Wnd0+KK8JROmnzcgEUVc1G+Dirw6w" +
       "T0iWgrbza0xgr2Vcrw+0PYHQ/LQZqbcnMG0lzMs8xl4fYGzOGXRhflD+EyHW" +
       "Ydz+7c5/nUQknzte8vWPmnYXS8qZFwibXBkj9Cy/exsenQ9ct29/ct39i8JW" +
       "xnklkJ6p2vkyHaWyC0o9j/XenKqX31Y5CcqyV8Yrjt86rb745Io9zfY5ly70" +
       "3+G8Azxz3d+nr+8c2VzGkXSOB7+3y5/2Hnxu9QLx1jC/cDPzoaKLukKljsI9" +
       "pVanLKsrhbtIa54xDUiQefCoFmNUL8kdTnrIlj9s+akGnB1+FND2YyzuYeSs" +
       "NGVd3oyJbyDOCrn3VMu5IG/HijivvrPwXNwBzw4LxY7yHeCn6gFp5QgcAu/1" +
       "YIAXHsHiAfCCUcILXOO7WGwwHbAJAuWoKiUdzzx42p7JU2OPBW9P+Z7xUw0A" +
       "/nhA2xNY/KI0Na7wUOPwmaPGzRaKm8t3gJ/qqajxTIAXnsPiqdLU4F541PHC" +
       "06ftBb4NzoXnbgvK3afwQok90E81AOSrAW1/wOIlRiaBA7Ja3gUe6EfPDAEw" +
       "rT1s2X+4fAL4qfoTYBnv9a0A/G9j8QYjDS4C2DmEywHHT9sBU7FpATxPWSie" +
       "Kt8BfqoB+D4IaDuBxbuAPV2MfZmD/b3Txt6MTTPgecEC8EL52P1UA/CNB7R9" +
       "hsU/IAkC7K4zioP6n2eG8ufDc8wy/Vj5qP1U/Sm/FHsNVfhDD1Vi5RcA3XBD" +
       "d5H9yzNDdjwOv2vZ/2750P1UA5A1BLThJWioFo6lMOEr1KySNBavLCR6qO60" +
       "cU/GplnwfGwZ/3H5uP1US0+5fWyYnL98Xq0L2ogkGua1c2hGgE/mYNHCSK2W" +
       "P0lwuX4srHTIkxpVDauqTAWlFPWEnOPLqafty7Ox6ZvQteUP83dZvvRVDfbl" +
       "N/K+LDpy9fNX6z8SuA+jAf5djEU7BFhRpwKjprKkpO2BZnoGMgVosgf/cny5" +
       "sHxf5iClKfUxE+/bpxX9G4b5rwPiI/sbqqfu3/An/kEt/3m/PkGqU1lZdl8H" +
       "u94jmk5TEp+LevNymN+jhToYaf/KR1mGZyv7D4QUusTspZOR2cG9MFIp2e6y" +
       "tZYzMs1Pi5EKKN3SK8FXpaRBEkq35GpGGr2SMD7/7ZZbA3gcOUYi5otbpBd6" +
       "BxF8XZu/k1n21c/+y4cNpguidfw3qTvDooATyaecijl5FfenQxyU/0ePfZLO" +
       "mv/TMyQe2r9m7Y6T37rf/HQpysL27dhLXYJUmV9Read4Gp/r25vdV6S7/fNJ" +
       "j9bMt28kmkyDnUU9w7Vdx2F5akje6Z7vekZb/vPe6wcuffLFvZFXwiS0iYQE" +
       "iImbij+F5LSsTuZsSpS6Wd4o6PyTY0ftO5uPfvpGqJl/cSLmXfTsII0h8bYn" +
       "j/elNO3uMKnpAUbCPOX4d5qV25R+Ko7qBRfVkWG+AXFfJcgkXGkCxgXuGcuh" +
       "E/O1+OmbkdbiO/vifweoldUxqvPtDbuZ6Lm/yGqau5V7drMZ39HTQMmhRK+m" +
       "WR8rInxG4pqGISUk8Aj/P6pbGWG2JwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aAzdD8yH+4mnRUj3au8889htwHukqHwS");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("XN87gPe9O2rAw4z2kaMzZGQoB2tTjfanx8685ybQ31cUz8XQheAoyb1etnBe" +
       "8X1Hl71jhVy+DYW8o6h8DxD9QB/77zuukB8+Usg1Kf2kvD04nl8qonMTJf1o" +
       "UTRABFNDXY71fWfTWx0O9MSpgfYEukYXv45V1rwVlWVgib/emd7igOJj1/wb" +
       "YX+CXv3VVy/e++irs39THms9OuV+HwvdaySOc/LQ14n7c0GoG2ap0Pv2R8CC" +
       "EnU/hp5/0w9JcfE0cPijAHOmt+dCx9BTN+cSQ/eYh4o67MXG0GM36hVDd4Hy" +
       "JDVw0LdejxpQgvIk5SSGLp2mBOOX3yfpZgDPMV0MndvfnCRZAO6ApLhdHh19" +
       "ab/5p0pMieJQVg8eLPdO+9jJ+VKuig+/kc8cdTl5gLcYtPxjy+GzX7L/a8tL" +
       "6pdfHXAf+m7rC/sDxKoj53nB5V4WOr8/y1wyLZ4fn7kht0Ne56jnv//gr933" +
       "rsNn3Qf3Ah/P3ROyPX3907o9N4jL87X5P3j013/k7736B+VBkv8LPCtlMXE0" +
       "AAA=");
}
