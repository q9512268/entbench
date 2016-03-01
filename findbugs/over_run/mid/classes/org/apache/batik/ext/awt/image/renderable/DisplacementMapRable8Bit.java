package org.apache.batik.ext.awt.image.renderable;
public class DisplacementMapRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.DisplacementMapRable {
    private double scale;
    private org.apache.batik.ext.awt.image.ARGBChannel xChannelSelector;
    private org.apache.batik.ext.awt.image.ARGBChannel yChannelSelector;
    public DisplacementMapRable8Bit(java.util.List sources, double scale,
                                    org.apache.batik.ext.awt.image.ARGBChannel xChannelSelector,
                                    org.apache.batik.ext.awt.image.ARGBChannel yChannelSelector) {
        super(
          );
        setSources(
          sources);
        setScale(
          scale);
        setXChannelSelector(
          xChannelSelector);
        setYChannelSelector(
          yChannelSelector);
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return ((org.apache.batik.ext.awt.image.renderable.Filter)
                                                               getSources(
                                                                 ).
                                                               get(
                                                                 0)).
                                                       getBounds2D(
                                                         );
    }
    public void setScale(double scale) { touch();
                                         this.scale =
                                           scale;
    }
    public double getScale() { return scale; }
    public void setSources(java.util.List sources) {
        if (sources.
              size(
                ) !=
              2) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        init(
          sources,
          null);
    }
    public void setXChannelSelector(org.apache.batik.ext.awt.image.ARGBChannel xChannelSelector) {
        if (xChannelSelector ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        touch(
          );
        this.
          xChannelSelector =
          xChannelSelector;
    }
    public org.apache.batik.ext.awt.image.ARGBChannel getXChannelSelector() {
        return xChannelSelector;
    }
    public void setYChannelSelector(org.apache.batik.ext.awt.image.ARGBChannel yChannelSelector) {
        if (yChannelSelector ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        touch(
          );
        this.
          yChannelSelector =
          yChannelSelector;
    }
    public org.apache.batik.ext.awt.image.ARGBChannel getYChannelSelector() {
        return yChannelSelector;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        org.apache.batik.ext.awt.image.renderable.Filter displaced =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            getSources(
              ).
            get(
              0);
        org.apache.batik.ext.awt.image.renderable.Filter map =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            getSources(
              ).
            get(
              1);
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        double sx =
          at.
          getScaleX(
            );
        double sy =
          at.
          getScaleY(
            );
        double shx =
          at.
          getShearX(
            );
        double shy =
          at.
          getShearY(
            );
        double tx =
          at.
          getTranslateX(
            );
        double ty =
          at.
          getTranslateY(
            );
        double atScaleX =
          java.lang.Math.
          sqrt(
            sx *
              sx +
              shy *
              shy);
        double atScaleY =
          java.lang.Math.
          sqrt(
            sy *
              sy +
              shx *
              shx);
        float scaleX =
          (float)
            (scale *
               atScaleX);
        float scaleY =
          (float)
            (scale *
               atScaleY);
        if (scaleX ==
              0 &&
              scaleY ==
              0)
            return displaced.
              createRendering(
                rc);
        java.awt.geom.AffineTransform srcAt =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            atScaleX,
            atScaleY);
        java.awt.Shape origAOI =
          rc.
          getAreaOfInterest(
            );
        if (origAOI ==
              null)
            origAOI =
              getBounds2D(
                );
        java.awt.geom.Rectangle2D aoiR =
          origAOI.
          getBounds2D(
            );
        java.awt.image.renderable.RenderContext srcRc =
          new java.awt.image.renderable.RenderContext(
          srcAt,
          aoiR,
          rh);
        java.awt.image.RenderedImage mapRed =
          map.
          createRendering(
            srcRc);
        if (mapRed ==
              null)
            return null;
        aoiR =
          new java.awt.geom.Rectangle2D.Double(
            aoiR.
              getX(
                ) -
              scale /
              2,
            aoiR.
              getY(
                ) -
              scale /
              2,
            aoiR.
              getWidth(
                ) +
              scale,
            aoiR.
              getHeight(
                ) +
              scale);
        java.awt.geom.Rectangle2D displacedRect =
          displaced.
          getBounds2D(
            );
        if (!aoiR.
              intersects(
                displacedRect))
            return null;
        aoiR =
          aoiR.
            createIntersection(
              displacedRect);
        srcRc =
          new java.awt.image.renderable.RenderContext(
            srcAt,
            aoiR,
            rh);
        java.awt.image.RenderedImage displacedRed =
          displaced.
          createRendering(
            srcRc);
        if (displacedRed ==
              null)
            return null;
        mapRed =
          convertSourceCS(
            mapRed);
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed(
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              displacedRed),
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              mapRed),
          xChannelSelector,
          yChannelSelector,
          scaleX,
          scaleY,
          rh);
        java.awt.geom.AffineTransform resAt =
          new java.awt.geom.AffineTransform(
          sx /
            atScaleX,
          shy /
            atScaleX,
          shx /
            atScaleY,
          sy /
            atScaleY,
          tx,
          ty);
        if (!resAt.
              isIdentity(
                ))
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                resAt,
                rh);
        return cr;
    }
    public java.awt.Shape getDependencyRegion(int srcIndex,
                                              java.awt.geom.Rectangle2D outputRgn) {
        return super.
          getDependencyRegion(
            srcIndex,
            outputRgn);
    }
    public java.awt.Shape getDirtyRegion(int srcIndex,
                                         java.awt.geom.Rectangle2D inputRgn) {
        return super.
          getDirtyRegion(
            srcIndex,
            inputRgn);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "eMUmAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DOtS6M9EZUc1ZqNxS2Jqsz7cJgYjnpyD3UEXhlvKDhFkpZZDsErX5rZoVxdD" +
       "izc8m1NJ0+Im413LwNsDKhe7fCLNDRWOTLzG17erHb9WUs1bkPAKuJfJ0Nmw" +
       "sdQMaTGCFHmC1HwgftQ3VAj4IY4S51VyBo0IxFGVYDZjugtNaor0OsRmmxwS" +
       "EUluO61h1oAgN/Aco6Ph7pBi+tUVF3TaW4QlWDga1/PYYAJckbrcko6sCcyJ" +
       "rDjo8X3f9sfZbqBJO6YhBSPLpWV1Sw/JUV1YNvE530LqUDsmV6q4VSFxrJJO" +
       "0EfY+aBtk0IAbBtvrw1X5UVU5Exs6Inz/gx1TGKt6OigvrBXE3aor+sOwtQ3" +
       "2aqNNRZZW2V4B8Ow54qjlu//9o6AHixPu47vQWzs8szH+zZOefZVTxbJ+47P" +
       "CMvfpcrhN/Ojv6e/jJ2cbF84Oln7yJv7Elwc4b/7Vrckyo8cn3/xpZcV9gvI" +
       "0Qejj8SVe2PP/w5bTVX7FEf3gZ6eufVZO1NeEjk58P61F//zY/OPGC98G9+G" +
       "nzjD59kuf4555UvD98s/cbFyx/Hx9w3XV65v9Oz1h96XQzVOQnd+3dH3u48V" +
       "9Eihj6fAQx4qiDx7iHtiAjc/wf3g3oTO+W7zU+fU/XSR/ERcuU9X466XuEpU" +
       "6x/ZwTvK885C77rqOQecKgOAuq0eUpQW+ZOvd+54esCy4Meu/zb9fvBMD7FP" +
       "bw/2CycEHy4JvnCOAH62SP5aXLknUuNZ8c3gpieuqWcqJ6D/+psA/VBR+Bh4" +
       "1oeg17df4b90Tt3fKpJXAV79EG8pphNsX3yzCi0+975wiO2F26rQ8r16PNo7" +
       "i86feL3RGmVSZl87Ryz/qEh+Ja5cLsxgfzmnKPm5E8H8vTcrGAw8ziGrzm23" +
       "9P3n2986B+I/K5IvxZWHAcTVTT72nML6T98E1tKjPVOS7n/b22/gv3tO3b8p" +
       "kn8BYOo3h4mdwPyd26HSFw9hvvj/SKX/8RysXyuSf7dX6fp8lf7+7VDpjx5i" +
       "/dHbr9L/dk7dfy+Sr+9VejOYp1T6X98E");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zOILdOm+fvwQ5o/fVpUehdUPHIfVG5ZTXJk9vNFb9vVntxbLhYtF4f+KK1fk" +
       "UBVjdd/YdPWjgd51ZqA9gaqQxduJyP70TYisXGMWt3y+dSiyb90ekV0sCS7e" +
       "LBbfYbrl9aC/WsrggXPk83CR3Ls3m77qF+hdecep+tGa8PjeUSGjmSH6J1K5" +
       "cPnNSgVEpgtX9m33f2+bVAr2rpyI4IlzRFBsBy48BmAWIjDD+BB9Ufq2E6zv" +
       "/HawbuPKo7e6AFrcZnv0hmvs+6vX8i++fOWeR17m/2V5B/L4evS9dOUeLbHt" +
       "0/dETuUv+aGqmaU07t3fGvFLYB+MK0+/4W1KXKzCj14KQBc+sO8FiiuPn99L" +
       "XLnLPJouR60OgARu1QrYJ0hPUyNx5a03owaUID1NWY8rV89SgvHLv6fpWgDP" +
       "CV1cubTPnCb5MOgdkBTZZ/0jWyff+L4Ok6I4FOW459nFXddYDYFWy83Ufou3" +
       "d2aPnjb/0pc89HqWdNzk9P3Pgo3yfySOdmHJ5PAO46svU+Pv+0bzC/v7p7It" +
       "5nnRyz105e79Vdiy02In9+Qtezvq6xLx9Dcf+OK97zvadT6wZ/hkKp7i7Ymb" +
       "X/bEHT8ur2fmf+eRX/rOn33598qbH/8HMvJQIbwyAAA=");
}
