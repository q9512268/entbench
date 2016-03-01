package org.apache.batik.ext.awt.image.renderable;
public class GaussianBlurRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.GaussianBlurRable {
    private double stdDeviationX;
    private double stdDeviationY;
    public GaussianBlurRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                 double stdevX,
                                 double stdevY) { super(src, null);
                                                  setStdDeviationX(
                                                    stdevX);
                                                  setStdDeviationY(
                                                    stdevY); }
    public void setStdDeviationX(double stdDeviationX) { if (stdDeviationX <
                                                               0) {
                                                             throw new java.lang.IllegalArgumentException(
                                                               );
                                                         }
                                                         touch(
                                                           );
                                                         this.
                                                           stdDeviationX =
                                                           stdDeviationX;
    }
    public void setStdDeviationY(double stdDeviationY) { if (stdDeviationY <
                                                               0) {
                                                             throw new java.lang.IllegalArgumentException(
                                                               );
                                                         }
                                                         touch(
                                                           );
                                                         this.
                                                           stdDeviationY =
                                                           stdDeviationY;
    }
    public double getStdDeviationX() { return stdDeviationX;
    }
    public double getStdDeviationY() { return stdDeviationY;
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    static final double DSQRT2PI = java.lang.Math.
      sqrt(
        2 *
          java.lang.Math.
            PI) *
      3.0 /
      4.0;
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.awt.geom.Rectangle2D src =
          getSource(
            ).
          getBounds2D(
            );
        float dX =
          (float)
            (stdDeviationX *
               DSQRT2PI);
        float dY =
          (float)
            (stdDeviationY *
               DSQRT2PI);
        float radX =
          3 *
          dX /
          2;
        float radY =
          3 *
          dY /
          2;
        return new java.awt.geom.Rectangle2D.Float(
          (float)
            (src.
               getMinX(
                 ) -
               radX),
          (float)
            (src.
               getMinY(
                 ) -
               radY),
          (float)
            (src.
               getWidth(
                 ) +
               2 *
               radX),
          (float)
            (src.
               getHeight(
                 ) +
               2 *
               radY));
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public static final double eps = 1.0E-4;
    public static boolean eps_eq(double f1,
                                 double f2) {
        return f1 >=
          f2 -
          eps &&
          f1 <=
          f2 +
          eps;
    }
    public static boolean eps_abs_eq(double f1,
                                     double f2) {
        if (f1 <
              0)
            f1 =
              -f1;
        if (f2 <
              0)
            f2 =
              -f2;
        return eps_eq(
                 f1,
                 f2);
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
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
        double sdx =
          stdDeviationX *
          scaleX;
        double sdy =
          stdDeviationY *
          scaleY;
        java.awt.geom.AffineTransform srcAt;
        java.awt.geom.AffineTransform resAt;
        int outsetX;
        int outsetY;
        if (sdx <
              10 &&
              sdy <
              10 &&
              eps_eq(
                sdx,
                sdy) &&
              eps_abs_eq(
                sx /
                  scaleX,
                sy /
                  scaleY)) {
            srcAt =
              at;
            resAt =
              null;
            outsetX =
              0;
            outsetY =
              0;
        }
        else {
            if (sdx >
                  10) {
                scaleX =
                  scaleX *
                    10 /
                    sdx;
                sdx =
                  10;
            }
            if (sdy >
                  10) {
                scaleY =
                  scaleY *
                    10 /
                    sdy;
                sdy =
                  10;
            }
            srcAt =
              java.awt.geom.AffineTransform.
                getScaleInstance(
                  scaleX,
                  scaleY);
            resAt =
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
            outsetX =
              1;
            outsetY =
              1;
        }
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.Shape devShape =
          srcAt.
          createTransformedShape(
            aoi);
        java.awt.Rectangle devRect =
          devShape.
          getBounds(
            );
        outsetX +=
          org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit.
            surroundPixels(
              sdx,
              rh);
        outsetY +=
          org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit.
            surroundPixels(
              sdy,
              rh);
        devRect.
          x -=
          outsetX;
        devRect.
          y -=
          outsetY;
        devRect.
          width +=
          2 *
            outsetX;
        devRect.
          height +=
          2 *
            outsetY;
        java.awt.geom.Rectangle2D r;
        try {
            java.awt.geom.AffineTransform invSrcAt =
              srcAt.
              createInverse(
                );
            r =
              invSrcAt.
                createTransformedShape(
                  devRect).
                getBounds2D(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException nte) {
            r =
              aoi.
                getBounds2D(
                  );
            r =
              new java.awt.geom.Rectangle2D.Double(
                r.
                  getX(
                    ) -
                  outsetX /
                  scaleX,
                r.
                  getY(
                    ) -
                  outsetY /
                  scaleY,
                r.
                  getWidth(
                    ) +
                  2 *
                  outsetX /
                  scaleX,
                r.
                  getHeight(
                    ) +
                  2 *
                  outsetY /
                  scaleY);
        }
        java.awt.image.RenderedImage ri;
        ri =
          getSource(
            ).
            createRendering(
              new java.awt.image.renderable.RenderContext(
                srcAt,
                r,
                rh));
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          convertSourceCS(
            ri);
        if (!devRect.
              equals(
                cr.
                  getBounds(
                    ))) {
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                devRect,
                org.apache.batik.ext.awt.image.PadMode.
                  ZERO_PAD,
                rh);
        }
        cr =
          new org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit(
            cr,
            sdx,
            sdy,
            rh);
        if (resAt !=
              null &&
              !resAt.
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
        if (srcIndex !=
              0)
            outputRgn =
              null;
        else {
            float dX =
              (float)
                (stdDeviationX *
                   DSQRT2PI);
            float dY =
              (float)
                (stdDeviationY *
                   DSQRT2PI);
            float radX =
              3 *
              dX /
              2;
            float radY =
              3 *
              dY /
              2;
            outputRgn =
              new java.awt.geom.Rectangle2D.Float(
                (float)
                  (outputRgn.
                     getMinX(
                       ) -
                     radX),
                (float)
                  (outputRgn.
                     getMinY(
                       ) -
                     radY),
                (float)
                  (outputRgn.
                     getWidth(
                       ) +
                     2 *
                     radX),
                (float)
                  (outputRgn.
                     getHeight(
                       ) +
                     2 *
                     radY));
            java.awt.geom.Rectangle2D bounds =
              getBounds2D(
                );
            if (!outputRgn.
                  intersects(
                    bounds))
                return new java.awt.geom.Rectangle2D.Float(
                  );
            outputRgn =
              outputRgn.
                createIntersection(
                  bounds);
        }
        return outputRgn;
    }
    public java.awt.Shape getDirtyRegion(int srcIndex,
                                         java.awt.geom.Rectangle2D inputRgn) {
        java.awt.geom.Rectangle2D dirtyRegion =
          null;
        if (srcIndex ==
              0) {
            float dX =
              (float)
                (stdDeviationX *
                   DSQRT2PI);
            float dY =
              (float)
                (stdDeviationY *
                   DSQRT2PI);
            float radX =
              3 *
              dX /
              2;
            float radY =
              3 *
              dY /
              2;
            inputRgn =
              new java.awt.geom.Rectangle2D.Float(
                (float)
                  (inputRgn.
                     getMinX(
                       ) -
                     radX),
                (float)
                  (inputRgn.
                     getMinY(
                       ) -
                     radY),
                (float)
                  (inputRgn.
                     getWidth(
                       ) +
                     2 *
                     radX),
                (float)
                  (inputRgn.
                     getHeight(
                       ) +
                     2 *
                     radY));
            java.awt.geom.Rectangle2D bounds =
              getBounds2D(
                );
            if (!inputRgn.
                  intersects(
                    bounds))
                return new java.awt.geom.Rectangle2D.Float(
                  );
            dirtyRegion =
              inputRgn.
                createIntersection(
                  bounds);
        }
        return dirtyRegion;
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
       "gP/lP2v8587dHv+5Mgj846TyQIFf1QoZ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FDk/PAb7J3cB9h1F5nvAc+MA7I03RpPP3Rwl/uTRhLwlKhTK14OLxyXiN99B" +
       "Gg8XyX1J5bIemWpi7is7/uKwoydOdbQnMI1+8XUksnP334XIHj7Qj3Pv3tfd" +
       "/969yA5U4ywFv+D45R2yf1vK4Mk7yOe5InksqbwFWIaeGRbofX0rmIvD6BbI" +
       "6KEjGYm2Gp6QyjvuVipPV4oD7r1UmDdUKgV7Tx2L4NodRFBcDjj3PIBZiMCJ" +
       "kgP0Re7VY6wvvB6seVJ525m3VYurd4/dctV+fz1c/5VXLt/36Cvyvy4vbB5d" +
       "4b6frdxnpa578tLOifeLYWRaTimK+/dXeMISFZpUnn/NS62kWEwcfhRozrX2" +
       "rfy5pPLUnVtJKvc6h3PlsNb7k8pjt6sFlBOkJ6k/lFTeehZ1cf8jv4kSBzHY" +
       "aUrQf/l7ko4EeI7pgCvYv5wk6YPWAUnxyoSHit5/7WtTTIuTSNUTPHCLi7mJ" +
       "GYFRLaPC/Up1b8keO6n7pe195Mep0VGVk5dVCzbK/+M4XEym+//kuK5/9RVm" +
       "+NM/aP3i/rKs7qq7XdHKfWzl0v7ebtlosSB99ratHbZ1kX7+Rw997f53HS6e" +
       "H9ozfDwPT/D29Nk3UwkvTMq7pLt/+Oiv/tTffuUPyitA/w8xXnTPYDMAAA==");
}
