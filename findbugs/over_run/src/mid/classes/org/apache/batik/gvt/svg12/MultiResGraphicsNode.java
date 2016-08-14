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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUaaZAU1fnN7Mly7CX3DYvJcswISIhZNMJyLc6y4w5uzKIu" +
       "vT1vZht6upvunt0BJYgpA7ESy1I0JBF+KBq1QKwYYzQlIRVvFAuiiYjxTJUa" +
       "pEqSUkxIYr7vve7pnp7ppjaauFX9trvf97333cfr2XeKVBg6maYJSlKImJs0" +
       "akTieB8XdIMmW2XBMNbA2x7xprdv23rm90O2hUllNxnRJxjtomDQ5RKVk0Y3" +
       "mSgphikoIjVWU5pEjLhODar3C6akKt1kpGS0ZTRZEiWzXU1SBOgS9BipF0xT" +
       "l3qzJm2zFjDJ5BijJsqoiS72ArTEyDBR1TY5COMKEFpdcwibcfYzTFIXWy/0" +
       "C9GsKcnRmGSYLTmdzNJUeVNaVs0IzZmR9fICSxCrYguKxDDtodpPzt7SV8fE" +
       "0CgoimoyFo1OaqhyP03GSK3zdplMM8ZG8h1SFiNDXcAmaYrZm0Zh0yhsavPr" +
       "QAH1w6mSzbSqjB3TXqlSE5Egk0wtXEQTdCFjLRNnNMMK1abFO0MGbqfkubXV" +
       "7WHx9lnRnT+6pu7nZaS2m9RKSgLJEYEIEzbpBoHSTC/VjcXJJE12k3oFFJ6g" +
       "uiTI0mZL2w2GlFYEMwsmYIsFX2Y1qrM9HVmBJoE3PSuaqp5nL8WMynqqSMlC" +
       "Gngd5fDKOVyO74HBGgkI01MC2J6FUr5BUpLMjgox8jw2XQYAgFqVoWafmt+q" +
       "XBHgBWngJiILSjqaAONT0gBaoYIJ6szWfBZFWWuCuEFI0x6TjPHCxfkUQA1h" +
       "gkAUk4z0grGVQEvjPFpy6efU6kU3X6usVMIkBDQnqSgj/UMBaZIHqZOmqE7B" +
       "DzjisJmxO4RRT+wIEwLAIz3AHObR605fOnvSoWc5zPgSMB2966lo9oh7e0cc" +
       "ndDafFEZklGtqYaEyi/gnHlZ3JppyWkQaUblV8TJiD15qPPpb1//AD0ZJjVt" +
       "pFJU5WwG7KheVDOaJFN9BVWoLpg02UaGUCXZyubbSBXcxySF8rcdqZRBzTZS" +
       "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" +
       "5DUNnTnEUPT/ALcOHDMhKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SqqTFqCgAE+Ij8JhEB2fKT8bue3DlOeO4fmx89B5qtvzwHkyr4H3grp0yj1W" +
       "FgmWXaiUUPHussbby/SpIvnpUt0Xi9d3JqBR21OdQ+T5Efi7AJ7/VzyFQxYZ" +
       "e8e83j2Mc952HOgEwHcuO4ZnJcvb246LbBeA6eYwxoNeuP6N9a9+63P7+O28" +
       "oc4RGx958e/96OBjL148FTU/eUPgerrOPnIuNfG6IiEywN3bb9dLWYP87194" +
       "4V/+kxc+vOfq+tkYsAeWOJ/79//3Dw8+9c3fu0lYcQmM/eKjGWTHXn1xr+Zj" +
       "YCvBqzA7iJN9zyjQ9ahsH13Y/sHxGgUUZjcZH8/eWsdMiTUnTvo7H/ofjwo/" +
       "t3zfqwgrnjino/NN/lPm5d/r/5T29y9WLh277A0LmLOVnjvrqFciA6y4POGM" +
       "u751766l/va+WiRPl6Yrv5891kSl1ESlpP2F25S9p0hk4Nxaoeq9ZW5D/r6s" +
       "UuY3zsJz8fK5Q3j+3H4U7H5yUMlL/TICHboAJw9nPrwkOMLpv77OsyNPvX48" +
       "BRM2oImPHOq0mxbfzxXJ4giClreDoCLplmYgioQsEqpI1BsHU/HJFcn0xtFR" +
       "fIv7bsvaRTK/jdH925SFReIWyXv3nNyGNs7KuEw9UtHTNywx9po+2OvzcI+i" +
       "rArdptltkTwRnw72z475U5swz2sf/+Pvvk767r/63g3T4dnYllGD506miLcV" +
       "wPjw+ZXNQI2XgK7xCvu3rjmv/LCMlO5XNeBD8TgC66vsTCR8SH33Pf/p3/z2" +
       "m973tUuVi2TliuOrOqmWi4rKfSCaN+IlWJplwc+/ez+YtsXwulaKWrlB+L1l" +
       "Hym/ruyd6WxY/Ch43nU4LN91PvY/9LgP3Nzj9qolEhB/Rlp8bszfdTTmb9n4" +
       "mXnkrDWm6rbc/nhe+63JN7/26fwLL++niSJcTCrVW+2k3biZVyy/bhPLntpj" +
       "+X7/b7zy5/9Nes/FQ7HuL5JfOh6qbzmZcCLDPOB9MzleiRUkHw2CoLJfKhVp" +
       "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" +
       "eRzE9yPPljFT8V2JBMtgjJXTZBfIrAJr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LSBGH6yJRK0x1KUs2uw2k7BO7/rKihu3MERSmQDSV/Wq3h7gJKKLA59LzR1M" +
       "dSViF/FItRtwQrwKlQ2hzJpRt8a3CSWodmeuZ8obUwjUZq+vO0u6yg3ioNtl" +
       "Bpt+3dqZ9khEMF6xGJVnJLE7EAZc0kvA8hxee6QZIRbGLiSJksldx4a1CQnN" +
       "GHE93zqwwTUSyJ7gu83CjnYDkmuP/bUu4mHEtiwmZtrozlRymeW0eJ2i5KCv" +
       "TGCwVOMiEhHAUh6XxLGCEiLrCV5P5ASoA5ZfA4JZjiadTrHV9O9e3RbY68vd" +
       "vuNroysHKwr+9avY5cpOnboe74uWf5crh1cMj35P7YueOqa5cLSz+I4bzr7K" +
       "QyJe6h/fDy4OUd56q4uj5UH8Zz704kv6+LO1o3MNOqncl/jBuxxjYziner1n" +
       "f+R39mJYcQrBH3LMn9/JPdHJDdq9UGp3r6pzp3IXzsr40PER6NFFwTpR1vuz" +
       "25zmfatIvpFUHgyO7h1wqn14s+n8HuXGt/UTw33zTtuTp7s6p5HrRWZxXPbF" +
       "Q4188bXRyKW9Q96M+8u6ny72V1n3SdnA92+jmr8oku8mlXs11dGIw+tpPzhR" +
       "wPd+DAUUZwyVZ8DzlUMFfOW1UcAp/i/cdZuyy0Xmj5LKdctIjm+c4CdHKMdS" +
       "Xqj8uFK+Ezy/fyjl77/2Ul67Tdn1IrkfIBGQsm/4rpFEu5sK+cBrYcqvHgr5" +
       "1ddeyMduU/Z4kTy8NyVf3Hy4pSkf+TGkLJG3ODb8k0Mp/+S1l/Kdtyl7tkie" +
       "TCpXgJTjNCluqR/h3oPHuMcv1cO7uWWdp34MeR8pMn8aPF8/lPfrr428F04I" +
       "qJLJ5m2EbhVJLalcLfz31OXvI8nfftNL4zdQlm3VX40ysqTyhpvdOi+u0D5y" +
       "w7/A7P9tQ/v8S1fvffgl8T/sr6Me/WvFfXTlXjN1nNO3Ak+9Xw4iw7RLVd23" +
       "vwASlOx2ksqjt74Sn1TuLn8Lxi+8e18DRBxvuFmNpHIJpKcp+0nl2nlK0GL5" +
       "e5qOAu52QgemkP3LaRIGtA5Iilc2ODLLMzdlvLOIk0jVzhgyu3AqbDj0wVIL" +
       "1+9kreMqpy93F5cyyv9jOronl3KHdz++8BLFvv97zc/uL5drjpqXJ/f30pV7" +
       "9vfcy0aLu3Zvv2VrR21dHjzzwwd//b6nj8KgB/cMn4yHU7w9cfOb3D03SMq7" +
       "1/m/ePhLP/uPX/rT8rj1/wMwFKcwYDYAAA==");
}
