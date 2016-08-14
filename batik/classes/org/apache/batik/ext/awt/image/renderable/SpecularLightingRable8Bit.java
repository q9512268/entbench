package org.apache.batik.ext.awt.image.renderable;
public class SpecularLightingRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.SpecularLightingRable {
    private double surfaceScale;
    private double ks;
    private double specularExponent;
    private org.apache.batik.ext.awt.image.Light light;
    private java.awt.geom.Rectangle2D litRegion;
    private float[] kernelUnitLength = null;
    public SpecularLightingRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                     java.awt.geom.Rectangle2D litRegion,
                                     org.apache.batik.ext.awt.image.Light light,
                                     double ks,
                                     double specularExponent,
                                     double surfaceScale,
                                     double[] kernelUnitLength) {
        super(
          src,
          null);
        setLight(
          light);
        setKs(
          ks);
        setSpecularExponent(
          specularExponent);
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
    public java.awt.geom.Rectangle2D getBounds2D() { return (java.awt.geom.Rectangle2D)
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
    public double getKs() { return ks; }
    public void setKs(double ks) { touch();
                                   this.ks = ks; }
    public double getSpecularExponent() { return specularExponent;
    }
    public void setSpecularExponent(double specularExponent) {
        touch(
          );
        this.
          specularExponent =
          specularExponent;
    }
    public double[] getKernelUnitLength() { if (kernelUnitLength ==
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
            if (scaleX >=
                  1 /
                  kernelUnitLength[0])
                scaleX =
                  1 /
                    kernelUnitLength[0];
            if (scaleY >=
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
          new org.apache.batik.ext.awt.image.rendered.SpecularLightingRed(
            ks,
            specularExponent,
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
       "Iz4zuCdaXSgY8dPtyCH+im+v/Q+XL30TSjIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HjvFAnEhVlFs1kTqrtuf8DVxOONWuNrs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
