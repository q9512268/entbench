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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jGFgpIkcxx+L/wstaoGJxTAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NQZtahX1VsjIZDbDvJ2LK8PJpg4ed5m6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "HichPwAA");
}
