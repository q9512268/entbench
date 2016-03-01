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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "otMw7G9NFbs48oaBRzzCWbr+AwL+n4HOJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QP/HPPm3x6AXhhreGvRv3SnoDriiA9DR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("u+/ah7T0dEFLxekTw3f3G6ZpecbRIZSihf9yzoD8YZ78HmhmNyC7swLOUf1b" +
       "j83v38HYPJZn5i/XPnYwNh97B2NTTOjPvt2MrxYC//Mc1N/Jk/8R52/zezrA" +
       "Z8XbW714uWfm+46hesfIv3UHyB/NM58G16sHyF99p8jfdlm7cPGcskt55h+f" +
       "Ap3n/NExuu/dAbr35Jn5G8lPHqD75LuP7so5ZQ/nyX1g4Zob8fg2rzaPkF64" +
       "/w6Qfl+e+Ry4Xj9A+vq7j/T7zynLzxpceBx4Z4708LXyMbQn7tRFnwHX5w+g" +
       "ff7dgXZicl4tMPzgOfheypPnY+h+zfc0wEkeuE476oUX7pSA8vOZXznA+JV3" +
       "ijF8u8WoesRCF9BzgGJ5sh9DD7nF6TM2cWIrcLZnXBV5J1jTGHrslgeF8yOP" +
       "T97094XdkXvti29cufzEG5N/tztJeHgs/l4GumwmjnPyMNKJ+7uD0DCtYiju" +
       "3Z32CApU4AHmveedkIyhiyDNNb9wfVcDPBc8ebsaQBqkJ6WbMfSeW0kDSZCe" +
       "lOyAoP2sJIjqi++TchTgxGO5GLp7d3NSBDw0XQQi+S1TeMmb6W4FfvKkkxUk" +
       "+sjb2euoyskDuTnc4k8oh+eWkt3fUG5oX3qDHvzot2uf3x0I1hw1y/JWLjPQ" +
       "PbuzyUWj+dmn9922tcO27qZe+u5DP3fvi4dPZA/tFD52+BO6PXvro7cdN4iL" +
       "w7LZLz7xj97/99/4neIwxP8HM7U/fx00AAA=");
}
