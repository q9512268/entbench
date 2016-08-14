package org.apache.batik.ext.awt.image.renderable;
public class DiffuseLightingRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.DiffuseLightingRable {
    private double surfaceScale;
    private double kd;
    private org.apache.batik.ext.awt.image.Light light;
    private java.awt.geom.Rectangle2D litRegion;
    private float[] kernelUnitLength = null;
    public DiffuseLightingRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                    java.awt.geom.Rectangle2D litRegion,
                                    org.apache.batik.ext.awt.image.Light light,
                                    double kd,
                                    double surfaceScale,
                                    double[] kernelUnitLength) { super(
                                                                   src,
                                                                   null);
                                                                 setLight(
                                                                   light);
                                                                 setKd(
                                                                   kd);
                                                                 setSurfaceScale(
                                                                   surfaceScale);
                                                                 setLitRegion(
                                                                   litRegion);
                                                                 setKernelUnitLength(
                                                                   kernelUnitLength);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return (java.awt.geom.Rectangle2D)
                 litRegion.
                 clone(
                   );
    }
    public java.awt.geom.Rectangle2D getLitRegion() {
        return getBounds2D(
                 );
    }
    public void setLitRegion(java.awt.geom.Rectangle2D litRegion) {
        touch(
          );
        this.
          litRegion =
          litRegion;
    }
    public org.apache.batik.ext.awt.image.Light getLight() {
        return light;
    }
    public void setLight(org.apache.batik.ext.awt.image.Light light) {
        touch(
          );
        this.
          light =
          light;
    }
    public double getSurfaceScale() { return surfaceScale;
    }
    public void setSurfaceScale(double surfaceScale) {
        touch(
          );
        this.
          surfaceScale =
          surfaceScale;
    }
    public double getKd() { return kd; }
    public void setKd(double kd) { touch(
                                     );
                                   this.kd =
                                     kd; }
    public double[] getKernelUnitLength() {
        if (kernelUnitLength ==
              null)
            return null;
        double[] ret =
          new double[2];
        ret[0] =
          kernelUnitLength[0];
        ret[1] =
          kernelUnitLength[1];
        return ret;
    }
    public void setKernelUnitLength(double[] kernelUnitLength) {
        touch(
          );
        if (kernelUnitLength ==
              null) {
            this.
              kernelUnitLength =
              null;
            return;
        }
        if (this.
              kernelUnitLength ==
              null)
            this.
              kernelUnitLength =
              (new float[2]);
        this.
          kernelUnitLength[0] =
          (float)
            kernelUnitLength[0];
        this.
          kernelUnitLength[1] =
          (float)
            kernelUnitLength[1];
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.geom.Rectangle2D aoiR =
          aoi.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D.
          intersect(
            aoiR,
            getBounds2D(
              ),
            aoiR);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        java.awt.Rectangle devRect =
          at.
          createTransformedShape(
            aoiR).
          getBounds(
            );
        if (devRect.
              width ==
              0 ||
              devRect.
                height ==
              0) {
            return null;
        }
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
        double scaleX =
          java.lang.Math.
          sqrt(
            sx *
              sx +
              shy *
              shy);
        double scaleY =
          java.lang.Math.
          sqrt(
            sy *
              sy +
              shx *
              shx);
        if (scaleX ==
              0 ||
              scaleY ==
              0) {
            return null;
        }
        if (kernelUnitLength !=
              null) {
            if (kernelUnitLength[0] >
                  0 &&
                  scaleX >
                  1 /
                  kernelUnitLength[0])
                scaleX =
                  1 /
                    kernelUnitLength[0];
            if (kernelUnitLength[1] >
                  0 &&
                  scaleY >
                  1 /
                  kernelUnitLength[1])
                scaleY =
                  1 /
                    kernelUnitLength[1];
        }
        java.awt.geom.AffineTransform scale =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scaleX,
            scaleY);
        devRect =
          scale.
            createTransformedShape(
              aoiR).
            getBounds(
              );
        aoiR.
          setRect(
            aoiR.
              getX(
                ) -
              2 /
              scaleX,
            aoiR.
              getY(
                ) -
              2 /
              scaleY,
            aoiR.
              getWidth(
                ) +
              4 /
              scaleX,
            aoiR.
              getHeight(
                ) +
              4 /
              scaleY);
        rc =
          (java.awt.image.renderable.RenderContext)
            rc.
            clone(
              );
        rc.
          setAreaOfInterest(
            aoiR);
        rc.
          setTransform(
            scale);
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              getSource(
                ).
                createRendering(
                  rc));
        org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap =
          new org.apache.batik.ext.awt.image.rendered.BumpMap(
          cr,
          surfaceScale,
          scaleX,
          scaleY);
        cr =
          new org.apache.batik.ext.awt.image.rendered.DiffuseLightingRed(
            kd,
            light,
            bumpMap,
            devRect,
            1 /
              scaleX,
            1 /
              scaleY,
            isColorSpaceLinear(
              ));
        java.awt.geom.AffineTransform shearAt =
          new java.awt.geom.AffineTransform(
          sx /
            scaleX,
          shy /
            scaleX,
          shx /
            scaleY,
          sy /
            scaleY,
          tx,
          ty);
        if (!shearAt.
              isIdentity(
                )) {
            java.awt.RenderingHints rh =
              rc.
              getRenderingHints(
                );
            java.awt.Rectangle padRect =
              new java.awt.Rectangle(
              devRect.
                x -
                1,
              devRect.
                y -
                1,
              devRect.
                width +
                2,
              devRect.
                height +
                2);
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                padRect,
                org.apache.batik.ext.awt.image.PadMode.
                  REPLICATE,
                rh);
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                shearAt,
                rh);
        }
        return cr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8f8BXL9Y3mYvAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "s8uqvPGgkctZvJJrLRgVILADrOb1RS3O");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("QCAeIzM6bUDKwsk7sQZhbcqiVhgjZhZNeANbRGxk4aQrRQiaXSeIBH+Vz7pB" +
       "Pppu211/pkneRAdZ/AzkLzLPMKE/GMjDjlFdbgc7IoTG0IyH7NUMIocOIoUb" +
       "IvRGjE4R0agJtuKTOW9RTq2jDIK8mzd6tAv1InUTO1pz3UYEuas1q+vYWmx5" +
       "vuHGmqS1qi7hr/wwrMUdadyzfHSV9ep1Gpmo1V1H9gajeO2TEtsbW5LDEJzA" +
       "srS5HSBuGuFTIsdgmQ6F9i6lulV6JVL5OI/h3nAWrOP+UCQlFNbaMFqrswQn" +
       "OnOh6Q+Q3E12vKliO42UDb4hdfqiuRjG6BDtuHBDEp2uvmiCgN7quyupLadY" +
       "V9w4HWoNkRGiIdiK7gpNW4hRFH1/8UrtV17fq743lm81j05LgvhYNHzhdbzN" +
       "S0/83nf0Nr78u1A5OFl3+P/Eu/8TP0idO3yD+oFbO0tW/PL22M3OUpaHMD73" +
       "0RdfUqafr58/eJv8/rByT+h6326psWqd4Gh/EEo8QvNgwfy3gSIcoBFO/5Jx" +
       "LK8b/4zxnr28z3iz/W/OaPu3RfVlwKyuhvvXssWD2rF+/vW3ett6csRT4Mqz" +
       "Xk+B8vwBuOdvD7hzxwS1kuDVMxD+flH9DkAYHCK84Yvm2DWUY9T/6RZQv7V4" +
       "WPxmds2plNur0v95RtvXiuoPw8p9QKWYGzlK0MCLR41jeH90q/CKA3zOATzn" +
       "9sP70zPa/qyo/jis3A/g0df8nniM7xu3arRNUKIDfNFtN9pGQXDuws1BnrtY" +
       "VOeKn7tPgfyvRyDPnb8FkKUjfQSUFw5AvnDblXjuwTPa3lxUbwgrF0slHv5O" +
       "fYztgdvhdb7/ANv333YFtkoQj58B8ImiegQADE4APKG8R28BYBkz3gHKDx0A" +
       "/KHbr7ynz2h7X1E9FVYuFTHj9HGMY4jvulUdtkD59AHET992HXZLLPAZOJGi" +
       "qgOcwfU4T6iycauqLDzqjx/g/PHbr0rsjLYiMJwDucpdQJUj5ZQCP3CrCnwC" +
       "lJ86APZTf0kKnJyBrjiDcI4C6IJDdCfUNrwFdG8pHr4HlJ89QPezt19t4hlt" +
       "31VUi7DypkJtpw6vFPTYMczlrSrxO0H5pQOYv3TblYiVeLQzsJYoJIA1uDHW" +
       "Eypd3wLWRw5V+qUDrF+6rVjLe7AReffROffrNh5seXnwhVwJ3T9DLHFR2cA5" +
       "yb4qheq+M9ivHE70tlMT7QlUhSrujkXmvB6RpWHl4Zt9alN8N/DwdR8F7j9k" +
       "k7/w0qWLb31p8e/3p78PPza7h65c1CLLOnkc98T1Bc9XNaMU6j37U5BeifzD" +
       "YeW9r3k7FxaHSg9vCkDnvnc/ykfDyuNnjwL8hnEorMNePwAkcLNeYeUOUJ+k" +
       "/nhYefONqAElqE9SfiKsXD5NCeYv/5+k+yTAc0wXVi7sL06S/A0wOiApLg/O" +
       "OwFroF77/hddB6EvyWF5eowqjuMDrZYnyPZb4b0pP3xyFZXr8MFvZUlHXU5+" +
       "aVOwUX5xenioONp/c/qc/MWXhpPv+Tr8+f2XPrIl5XkxykW6cvf+o6Ny0OJg" +
       "8jtuOtrhWBfI937zgZ+/56nD3fkDe4aPV/QJ3t5+489qCNsLyw9h8n/61n/8" +
       "7D946XfLk1D/F1Z9c8sKPAAA");
}
