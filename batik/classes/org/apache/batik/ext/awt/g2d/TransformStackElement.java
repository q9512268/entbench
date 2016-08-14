package org.apache.batik.ext.awt.g2d;
public abstract class TransformStackElement implements java.lang.Cloneable {
    private org.apache.batik.ext.awt.g2d.TransformType type;
    private double[] transformParameters;
    protected TransformStackElement(org.apache.batik.ext.awt.g2d.TransformType type,
                                    double[] transformParameters) {
        super(
          );
        this.
          type =
          type;
        this.
          transformParameters =
          transformParameters;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.g2d.TransformStackElement newElement =
                                        null;
                                      try { newElement = (org.apache.batik.ext.awt.g2d.TransformStackElement)
                                                           super.
                                                           clone(
                                                             );
                                      }
                                      catch (java.lang.CloneNotSupportedException ex) {
                                          
                                      }
                                      double[] transformParameters =
                                        new double[this.
                                                     transformParameters.
                                                     length];
                                      java.lang.System.
                                        arraycopy(
                                          this.
                                            transformParameters,
                                          0,
                                          transformParameters,
                                          0,
                                          transformParameters.
                                            length);
                                      newElement.
                                        transformParameters =
                                        transformParameters;
                                      return newElement;
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createTranslateElement(double tx,
                                                                                            double ty) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            TRANSLATE,
          new double[] { tx,
          ty }) {
            boolean isIdentity(double[] parameters) {
                return parameters[0] ==
                  0 &&
                  parameters[1] ==
                  0;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createRotateElement(double theta) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            ROTATE,
          new double[] { theta }) {
            boolean isIdentity(double[] parameters) {
                return java.lang.Math.
                  cos(
                    parameters[0]) ==
                  1;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createScaleElement(double scaleX,
                                                                                        double scaleY) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            SCALE,
          new double[] { scaleX,
          scaleY }) {
            boolean isIdentity(double[] parameters) {
                return parameters[0] ==
                  1 &&
                  parameters[1] ==
                  1;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createShearElement(double shearX,
                                                                                        double shearY) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            SHEAR,
          new double[] { shearX,
          shearY }) {
            boolean isIdentity(double[] parameters) {
                return parameters[0] ==
                  0 &&
                  parameters[1] ==
                  0;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createGeneralTransformElement(java.awt.geom.AffineTransform txf) {
        double[] matrix =
          new double[6];
        txf.
          getMatrix(
            matrix);
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            GENERAL,
          matrix) {
            boolean isIdentity(double[] m) {
                return m[0] ==
                  1 &&
                  m[2] ==
                  0 &&
                  m[4] ==
                  0 &&
                  m[1] ==
                  0 &&
                  m[3] ==
                  1 &&
                  m[5] ==
                  0;
            }
        };
    }
    abstract boolean isIdentity(double[] parameters);
    public boolean isIdentity() { return isIdentity(
                                           transformParameters);
    }
    public double[] getTransformParameters() {
        return transformParameters;
    }
    public org.apache.batik.ext.awt.g2d.TransformType getType() {
        return type;
    }
    public boolean concatenate(org.apache.batik.ext.awt.g2d.TransformStackElement stackElement) {
        boolean canConcatenate =
          false;
        if (type.
              toInt(
                ) ==
              stackElement.
                type.
              toInt(
                )) {
            canConcatenate =
              true;
            switch (type.
                      toInt(
                        )) {
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_TRANSLATE:
                    transformParameters[0] +=
                      stackElement.
                        transformParameters[0];
                    transformParameters[1] +=
                      stackElement.
                        transformParameters[1];
                    break;
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_ROTATE:
                    transformParameters[0] +=
                      stackElement.
                        transformParameters[0];
                    break;
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_SCALE:
                    transformParameters[0] *=
                      stackElement.
                        transformParameters[0];
                    transformParameters[1] *=
                      stackElement.
                        transformParameters[1];
                    break;
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_GENERAL:
                    transformParameters =
                      matrixMultiply(
                        transformParameters,
                        stackElement.
                          transformParameters);
                    break;
                default:
                    canConcatenate =
                      false;
            }
        }
        return canConcatenate;
    }
    private double[] matrixMultiply(double[] matrix1,
                                    double[] matrix2) {
        double[] product =
          new double[6];
        java.awt.geom.AffineTransform transform1 =
          new java.awt.geom.AffineTransform(
          matrix1);
        transform1.
          concatenate(
            new java.awt.geom.AffineTransform(
              matrix2));
        transform1.
          getMatrix(
            product);
        return product;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zOAhIFG6YEPD5SMJvGP/BXuHMmMVKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UP+bovhKVHloj3qhSPYtQP/rdwK0eQDa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/DMH/TtngP6PRfFvj0EbmhTcHPRv3y7oIXjCA9DhO2/ah27pydItlTdTNM+5" +
       "2tN109WOLqiUI/yXMwTyR0Xx+2CYvUD2dwzso/43l80f3IZsHikqi49yHzmQ" +
       "zUfehmzKBf2Zt1rxcEnwP89A/e2i+B9RcQtgogJ8JsgZiqpTH2zukj3P1iT3" +
       "GPk3bwP5w0Xlk+B55QD5K28X+VuGtXMXzmi7WFT+8Q2gi5rvHKP73m2ge1dR" +
       "WXzJ/PgBuo+/8+gun9H2YFHcAwLXWovYW3wSPUJ67t7bQPp9ReUz4PnUAdJP" +
       "vfNIv/+MtuKOwrlHgXUWSA8/Rx9De+x2TfQp8HzuANrn3hloJxbnlRLDD56B" +
       "78WieDaq3Kt4rgJ8kgueGw313HO364CKu5tfPsD45beLMXirYAQfeaFzzTOA" +
       "torialR5wClvrRGxHZm+vTtlqtDbwZpFlUdueom4uA75+Jv+fWF/5V75wmuX" +
       "Lz32Gvfv9rcMD6/F341XLumxbZ+8xHTi/U4/0HSzFMXd+1sifokKbGDefdbt" +
       "yahyAZQF5+eu7XuAfcHjt+oBqEF5krofVd51M2pACcqTlEOQtJ+mBFl9+fsk" +
       "3Rj4xGO6qHLn/uUkCdg0XQAkxSteWsnr2T4CP37SyEon+tBb6euoy8nLugXc" +
       "8p9QDu87xft/Q7mufPG1Kfkj32p/bn9ZWLGlPC9GuYRX7trfWy4HLe5MveeW" +
       "ox2Odef4xe8+8LN3v3C4I3tgz/CxwZ/g7embX8sdOn5UXqTNf+mxX3jvP3zt" +
       "d8tLFP8fr66PoR00AAA=");
}
