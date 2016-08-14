package org.apache.batik.gvt.svg12;
public class MultiResGraphicsNode extends org.apache.batik.gvt.AbstractGraphicsNode implements org.apache.batik.util.SVGConstants {
    java.lang.ref.SoftReference[] srcs;
    org.w3c.dom.Element[] srcElems;
    java.awt.Dimension[] minSz;
    java.awt.Dimension[] maxSz;
    java.awt.geom.Rectangle2D bounds;
    org.apache.batik.bridge.BridgeContext ctx;
    org.w3c.dom.Element multiImgElem;
    public MultiResGraphicsNode(org.w3c.dom.Element multiImgElem, java.awt.geom.Rectangle2D bounds,
                                org.w3c.dom.Element[] srcElems,
                                java.awt.Dimension[] minSz,
                                java.awt.Dimension[] maxSz,
                                org.apache.batik.bridge.BridgeContext ctx) {
        super(
          );
        this.
          multiImgElem =
          multiImgElem;
        this.
          srcElems =
          (new org.w3c.dom.Element[srcElems.
                                     length]);
        this.
          minSz =
          (new java.awt.Dimension[srcElems.
                                    length]);
        this.
          maxSz =
          (new java.awt.Dimension[srcElems.
                                    length]);
        this.
          ctx =
          ctx;
        for (int i =
               0;
             i <
               srcElems.
                 length;
             i++) {
            this.
              srcElems[i] =
              srcElems[i];
            this.
              minSz[i] =
              minSz[i];
            this.
              maxSz[i] =
              maxSz[i];
        }
        this.
          srcs =
          (new java.lang.ref.SoftReference[srcElems.
                                             length]);
        this.
          bounds =
          bounds;
    }
    public void primitivePaint(java.awt.Graphics2D g2d) { java.awt.geom.AffineTransform at =
                                                            g2d.
                                                            getTransform(
                                                              );
                                                          double scx =
                                                            java.lang.Math.
                                                            sqrt(
                                                              at.
                                                                getShearY(
                                                                  ) *
                                                                at.
                                                                getShearY(
                                                                  ) +
                                                                at.
                                                                getScaleX(
                                                                  ) *
                                                                at.
                                                                getScaleX(
                                                                  ));
                                                          double scy =
                                                            java.lang.Math.
                                                            sqrt(
                                                              at.
                                                                getShearX(
                                                                  ) *
                                                                at.
                                                                getShearX(
                                                                  ) +
                                                                at.
                                                                getScaleY(
                                                                  ) *
                                                                at.
                                                                getScaleY(
                                                                  ));
                                                          org.apache.batik.gvt.GraphicsNode gn =
                                                            null;
                                                          int idx =
                                                            -1;
                                                          double w =
                                                            bounds.
                                                            getWidth(
                                                              ) *
                                                            scx;
                                                          double minDist =
                                                            calcDist(
                                                              w,
                                                              minSz[0],
                                                              maxSz[0]);
                                                          int minIdx =
                                                            0;
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 minSz.
                                                                   length;
                                                               i++) {
                                                              double dist =
                                                                calcDist(
                                                                  w,
                                                                  minSz[i],
                                                                  maxSz[i]);
                                                              if (dist <
                                                                    minDist) {
                                                                  minDist =
                                                                    dist;
                                                                  minIdx =
                                                                    i;
                                                              }
                                                              if ((minSz[i] ==
                                                                     null ||
                                                                     w >=
                                                                     minSz[i].
                                                                       width) &&
                                                                    (maxSz[i] ==
                                                                       null ||
                                                                       w <=
                                                                       maxSz[i].
                                                                         width)) {
                                                                  if (idx ==
                                                                        -1 ||
                                                                        minIdx ==
                                                                        i) {
                                                                      idx =
                                                                        i;
                                                                  }
                                                              }
                                                          }
                                                          if (idx ==
                                                                -1)
                                                              idx =
                                                                minIdx;
                                                          gn =
                                                            getGraphicsNode(
                                                              idx);
                                                          if (gn ==
                                                                null)
                                                              return;
                                                          java.awt.geom.Rectangle2D gnBounds =
                                                            gn.
                                                            getBounds(
                                                              );
                                                          if (gnBounds ==
                                                                null)
                                                              return;
                                                          double gnDevW =
                                                            gnBounds.
                                                            getWidth(
                                                              ) *
                                                            scx;
                                                          double gnDevH =
                                                            gnBounds.
                                                            getHeight(
                                                              ) *
                                                            scy;
                                                          double gnDevX =
                                                            gnBounds.
                                                            getX(
                                                              ) *
                                                            scx;
                                                          double gnDevY =
                                                            gnBounds.
                                                            getY(
                                                              ) *
                                                            scy;
                                                          double gnDevX0;
                                                          double gnDevX1;
                                                          double gnDevY0;
                                                          double gnDevY1;
                                                          if (gnDevW <
                                                                0) {
                                                              gnDevX0 =
                                                                gnDevX +
                                                                  gnDevW;
                                                              gnDevX1 =
                                                                gnDevX;
                                                          }
                                                          else {
                                                              gnDevX0 =
                                                                gnDevX;
                                                              gnDevX1 =
                                                                gnDevX +
                                                                  gnDevW;
                                                          }
                                                          if (gnDevH <
                                                                0) {
                                                              gnDevY0 =
                                                                gnDevY +
                                                                  gnDevH;
                                                              gnDevY1 =
                                                                gnDevY;
                                                          }
                                                          else {
                                                              gnDevY0 =
                                                                gnDevY;
                                                              gnDevY1 =
                                                                gnDevY +
                                                                  gnDevH;
                                                          }
                                                          gnDevW =
                                                            (int)
                                                              (java.lang.Math.
                                                                 ceil(
                                                                   gnDevX1) -
                                                                 java.lang.Math.
                                                                 floor(
                                                                   gnDevX0));
                                                          gnDevH =
                                                            (int)
                                                              (java.lang.Math.
                                                                 ceil(
                                                                   gnDevY1) -
                                                                 java.lang.Math.
                                                                 floor(
                                                                   gnDevY0));
                                                          scx =
                                                            gnDevW /
                                                              gnBounds.
                                                              getWidth(
                                                                ) /
                                                              scx;
                                                          scy =
                                                            gnDevH /
                                                              gnBounds.
                                                              getHeight(
                                                                ) /
                                                              scy;
                                                          java.awt.geom.AffineTransform nat =
                                                            g2d.
                                                            getTransform(
                                                              );
                                                          nat =
                                                            new java.awt.geom.AffineTransform(
                                                              nat.
                                                                getScaleX(
                                                                  ) *
                                                                scx,
                                                              nat.
                                                                getShearY(
                                                                  ) *
                                                                scx,
                                                              nat.
                                                                getShearX(
                                                                  ) *
                                                                scy,
                                                              nat.
                                                                getScaleY(
                                                                  ) *
                                                                scy,
                                                              nat.
                                                                getTranslateX(
                                                                  ),
                                                              nat.
                                                                getTranslateY(
                                                                  ));
                                                          g2d.
                                                            setTransform(
                                                              nat);
                                                          gn.
                                                            paint(
                                                              g2d);
    }
    public double calcDist(double loc, java.awt.Dimension min,
                           java.awt.Dimension max) {
        if (min ==
              null) {
            if (max ==
                  null)
                return 1.0E11;
            else
                return java.lang.Math.
                  abs(
                    loc -
                      max.
                        width);
        }
        else {
            if (max ==
                  null)
                return java.lang.Math.
                  abs(
                    loc -
                      min.
                        width);
            else {
                double mid =
                  (max.
                     width +
                     min.
                       width) /
                  2.0;
                return java.lang.Math.
                  abs(
                    loc -
                      mid);
            }
        }
    }
    public java.awt.geom.Rectangle2D getPrimitiveBounds() {
        return bounds;
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        return bounds;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds() {
        return bounds;
    }
    public java.awt.Shape getOutline() { return bounds;
    }
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode(int idx) {
        if (srcs[idx] !=
              null) {
            java.lang.Object o =
              srcs[idx].
              get(
                );
            if (o !=
                  null)
                return (org.apache.batik.gvt.GraphicsNode)
                         o;
        }
        try {
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            org.apache.batik.gvt.GraphicsNode gn;
            gn =
              builder.
                build(
                  ctx,
                  srcElems[idx]);
            srcs[idx] =
              new java.lang.ref.SoftReference(
                gn);
            return gn;
        }
        catch (java.lang.Exception ex) {
            ex.
              printStackTrace(
                );
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2rgIZKPaTGnOmljSq9bazWF9iaYtdIdm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GQuHNU/UGEIg2LHbkDWNc5KZSgxMDzjPhgcBfg0dID0UCsRuVjfcnpB0xaYd" +
       "deMVviA3NtzDIEyQIrBIySA5htaZUG1ttJygZ2DhzQ6pmgIzVWQ5INn+RNty" +
       "JK+3OeC6XmsVBmg9QWQnAAJDaAiN2BU6QaiqRmAopSMyEgbmdoCR0dTe+DXa" +
       "aO0UcWs59S0Vw56/6aFrNSA22dJl8TllErbKKkqVnW+mfVbfYkSVH+VRHspW" +
       "1h7OaHKmN6YcVHeoQPKZRcAM+tTOndrSBuk0TFJtdfQ2iOZwM1nv6iO5i5hu" +
       "HZf8kdGOBLmndJvNndnYJeOBJ/CzkddYSDlX7afrWSoy6WDgdsMExzc4jv9M" +
       "sXX171/fltp95e7h8ZXRtYMVBf/mdeyaZadOao/3Wcu/S5XD64VHv6f2WU8d" +
       "+1w42ql84pqztPLQiV2Sx3eDi0OZR250abQ8vP/sh194UZ1+rn50TjKOK3fG" +
       "fvAuR9tqzqleb98fIZ69MFacarCHHLPnd4ZPdHKNdi+U2t2r6twp34WzMt5/" +
       "fKR6dIEQ7pX1/uwmp4PfLpJX4sq9wdFdBUayDm88nd/z3PqWemK4b73Wdufp" +
       "rs5p5GqRWRy/fflQI19+YzRyy94hr8f9JdVP5P011n1SNvD9m6jmL4vke3Hl" +
       "DkVylN7htbUfnCjg1R9DAcWZReUZ8HztUAFfe2MUcIr/C7fepOxSkfmjuHLV" +
       "0OLjWyqdkyOZYykvVH5cKd8Jnt8/lPL333gpr9yk7GqR3A2QCEhJar4Lwszd" +
       "dYW8540w5dcPhfz6Gy/kwzcpe7RIHtibki1uUtzQlA/+GFKWyFscQ/7JoZR/" +
       "8sZL+c6blD1bJE/GlbuAlNMkLm6oH+Hevce4x5rS4Z3dss5TP4a8DxaZPwme" +
       "bx7K+803Rt4LJwRUyWTzJkK3iqQeVy4X/nvqUviR5I9f9zL5NZRlW/DrUUYW" +
       "V958vdvoxdXaB6/595f9v2woX3jx8h0PvLj4j/trqkf/VnHnuHKHnjjO6ZuE" +
       "p94vBaGmW6Wq7txfKAlKdvG48tCNr8rHldvK34LxC+/e1wARx5uvVyOu3ALS" +
       "05RkXLlynhK0WP6epqOAu53QgSlk/3KahAatA5LidRIcmeWZ6zKOy1EcSsoZ" +
       "Q2YXToUNhz5YauHqa1nruMrpS9/FJY/yf5iO7tYlzOFdki++SE3e/2rzc/tL" +
       "54oj5eVNgDvGldv399/LRov7eY/fsLWjti4NnvnhvV+68+mjMOjePcMn4+EU" +
       "b49d/4Z33w3i8k52/i8f+MpP/+MX/7Q8vv3/n/pWGVw2AAA=");
}
