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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aYu+uwUuAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "imGHzzoIGpp2NtVMUqc7qZAsV7twZ411");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("AsmhfOSiiknzVavB5Pi0z3nZTK/ZW8pjatIGnQ0dBh/wcSO1Uz4SG+1xjUU3" +
       "fmvX6mijKdjQJjxLoyBrnzsw0m3QyxbeaLREQQeeDaQfXXHSFellM92ixtq2" +
       "VtIwA0ubWCZmats7CBGCXjZL1GzXaPGzkZgi43U9WUq1Xpfred4yytVVYqDW" +
       "BCGnYebgRDdf1mU8JGroeLHxFBmScBLpyZkCD5aEmjHrHur5s4nhpoN5YrZX" +
       "3RbEK3NqpWPLfuroDrHwIS/Y4AGDziy+3WrUw9XE0gQZkyR350pIb1YfjVV8" +
       "sRiIYMUITthhF7g4GBgmj4v6FMZpWUygZCsk7Xb7g8UrsV95c6/q3lK+lTw6" +
       "QWk5WNHwpTfxNi478Vve0Zv28u9C5eC03eH/E+/1T/zYdO7wDeiHbuwMWfGr" +
       "2iPXO19ZHr74wsdffkXlvoicP3gb/MG4ckfsBx9wtFRzTnC0PwAlHaG5v2D+" +
       "u0ARD9CIp3+lOJbXtX+ieO9e3me8mf6XZ7T9q6L6KmDW0OL9a9XiQfVYP//i" +
       "O70tPTniKXDlGa+nQXnhANwLNwfcuWOCaknw+hkIf7+ofgcgjA4RXvNFceqb" +
       "6jHqf38DqN9RPCx+D7viNMrNVel/O6PtG0X1h3HlLqDSjp94alTrFY9qx/D+" +
       "6EbhFQf3vAN43s2H9ydntP1pUf1xXLkbwKOv+K3wGN+3btRoUVCSA3zJTTfa" +
       "WkFw7sL1QZ67WFTnip+yT4H8T0cgz52/AZClI30IlBcPQL5405V47v4z2t5W" +
       "VPfElYulEg9/gz7Gdu/N8Do/dIDth266AusliEfPAPh4UT0EAEYnAJ5Q3sM3" +
       "ALCMGU+A8qMHAH/05ivvmTPa3l9UT8eV+4qYcfqoxTHEd9+oDuugfOYA4mdu" +
       "ug5bJZbmGTjxokIAzuhqnCdUWbtRVRYe9ccPcP74zVdl54y2IjCcA7nKbUCV" +
       "I/WUAj90owp8HJSfOgD2U39OCmTPQFecIThHAXTRIboTahveALq3Fw/fC8rP" +
       "HqD72ZuvNumMtu8tKiGuvLVQ26mDKQV95xjm/EaV+D2g/NIBzF+66UrslHj0" +
       "M7CWKGSANbo21hMqXd0A1ocOVfqVA6xfualYy3uwEXnP0fn2qzYek/Ly4Ku5" +
       "Enp4hljSonKBc1JCTY61fWewXzmc6J2nJtoTaCpV3B2LzHszIsviyoPX+8Sm" +
       "+F7gwas+FNx/3KZ86ZX7Lr7jFeHf7E99H36AdgdduagnjnPyqO2J6wtBqOlm" +
       "KdQ79iccgxL5R+PK+97wdi4uDowe3hSAzv3AfpSPx5VHzx4F+A3zUFiHvX4Y" +
       "SOB6veLKLaA+Sf3JuPK2a1EDSlCfpPxUXLl0mhLMX/4/SfcSwHNMF1cu7C9O" +
       "kvw1MDogKS4PzisBa6De+P63vYriUFbi8vQXVRzDB1otT4Dtt8J7U37w5Coq" +
       "1+H938mSjrqc/MKmYKP8CvXwwHCy/w71eeXLrwzZ7/9m84v7L3wUR97tilEu" +
       "0pXb9x8blYMWh46fuO5oh2NdIN/37Xt//o6nD3fn9+4ZPl7RJ3h77Nqf0/Td" +
       "IC4/gNn9o3f8g+f+3iu/W55k+t8vvJ9yHjwAAA==");
}
