package org.apache.batik.svggen;
public class SVGTransform extends org.apache.batik.svggen.AbstractSVGConverter {
    private static double radiansToDegrees = 180.0 / java.lang.Math.PI;
    public SVGTransform(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return new org.apache.batik.svggen.SVGTransformDescriptor(
          toSVGTransform(
            gc));
    }
    public final java.lang.String toSVGTransform(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVGTransform(
                 gc.
                   getTransformStack(
                     ));
    }
    public final java.lang.String toSVGTransform(org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        int nTransforms =
          transformStack.
            length;
        java.util.Stack presentation =
          new java.util.Stack(
          ) {
            public java.lang.Object push(java.lang.Object o) {
                java.lang.Object element;
                if (((org.apache.batik.ext.awt.g2d.TransformStackElement)
                       o).
                      isIdentity(
                        )) {
                    element =
                      pop(
                        );
                }
                else {
                    super.
                      push(
                        o);
                    element =
                      null;
                }
                return element;
            }
            public java.lang.Object pop() {
                java.lang.Object element =
                  null;
                if (!super.
                      empty(
                        )) {
                    element =
                      super.
                        pop(
                          );
                }
                return element;
            }
        };
        boolean canConcatenate =
          false;
        int i =
          0;
        int j =
          0;
        int next =
          0;
        org.apache.batik.ext.awt.g2d.TransformStackElement element =
          null;
        while (i <
                 nTransforms) {
            next =
              i;
            if (element ==
                  null) {
                element =
                  (org.apache.batik.ext.awt.g2d.TransformStackElement)
                    transformStack[i].
                    clone(
                      );
                next++;
            }
            canConcatenate =
              true;
            for (j =
                   next;
                 j <
                   nTransforms;
                 j++) {
                canConcatenate =
                  element.
                    concatenate(
                      transformStack[j]);
                if (!canConcatenate)
                    break;
            }
            i =
              j;
            element =
              (org.apache.batik.ext.awt.g2d.TransformStackElement)
                presentation.
                push(
                  element);
        }
        if (element !=
              null) {
            presentation.
              push(
                element);
        }
        int nPresentations =
          presentation.
          size(
            );
        java.lang.StringBuffer transformStackBuffer =
          new java.lang.StringBuffer(
          nPresentations *
            8);
        for (i =
               0;
             i <
               nPresentations;
             i++) {
            transformStackBuffer.
              append(
                convertTransform(
                  (org.apache.batik.ext.awt.g2d.TransformStackElement)
                    presentation.
                    get(
                      i)));
            transformStackBuffer.
              append(
                SPACE);
        }
        java.lang.String transformValue =
          transformStackBuffer.
          toString(
            ).
          trim(
            );
        return transformValue;
    }
    final java.lang.String convertTransform(org.apache.batik.ext.awt.g2d.TransformStackElement transformElement) {
        java.lang.StringBuffer transformString =
          new java.lang.StringBuffer(
          );
        double[] transformParameters =
          transformElement.
          getTransformParameters(
            );
        switch (transformElement.
                  getType(
                    ).
                  toInt(
                    )) {
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_TRANSLATE:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_TRANSLATE);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_ROTATE:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_ROTATE);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          radiansToDegrees *
                            transformParameters[0]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_SCALE:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_SCALE);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_SHEAR:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_MATRIX);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        1);
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        1);
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        0);
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        0);
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_GENERAL:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_MATRIX);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[2]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[3]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[4]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[5]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            default:
                throw new java.lang.Error(
                  );
        }
        return transformString.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0iIQYlocU/ymSPlCnwfYeyEEVAwCKuYPKPs54kvdjwH+kuJw6tH11E9aX90x" +
       "1foOr8yrZBMAGSqNAi9mnjUfH3j7zImZCw7yG285g3cr9fmfGvNfEn0PhNxO" +
       "dax5MGfHwJUlkcoJmX6KpTH2GEysV9wg6HUKtlZt+MiF3ZrnZ6gPFKKm6Sin" +
       "HLRqEvZriKIykIZ1pyzoYluGBR/79LPdCO5UNJVgu9SAOfFsI2tR520XJnMF" +
       "Dz8mDs8382QDfpwS8PJkibmnWHMI8E5i5xJilCB/RmCIB1w8QDec4zR7S6x/" +
       "ljXfz0M6NrrLRbV7/29Ua2BTi+F7zsKg5y4C1UKFAK26BLPSSfZ/cF1+uhdL" +
       "6PEIa16g/Io2TgxaTJPTF6/JHEW1Xtuwi/K8vH9liOd36eBUXdXcqVv+JALe" +
       "fiKvhdtKKqso3nucpx/RDZKSuRy14lYnqt4/UjS3SLXArmi8ww99TNC/BvIH" +
       "6cGT+W8v3RsU1bh0wEp0vCQnIYyBhHVP6bbhVhYrXTogzRhYoqCmTqF/YuRC" +
       "/rraMcGcC5nAU4q3+pCZ/5vJTm9Z8Y8muD5Obdp8+7mvPipe5yQFT04yLjMA" +
       "RMVDoVPYLi7KzeYV2bjss1lPVC+xk2ODOLAbG5d5fK4DfFpn3jA/8HRltjkv" +
       "WCf3rzn8ys7ICUgaW1AIA/JtyX8UyOlZqLq3xAtdrCDL8Fe19pr3ho99eirU" +
       "yN9erPqgudSKhHT/4dO9KV3/YRhVd6EKuLuQHH+xWLtN7SPSuOG7p0VGtKzq" +
       "ZKRZzHUxq624ZiyFznRG2esuRS35t9b8F+8aRZsgxk2Mu5X8fFeBrK57Z7lm" +
       "EyKhiPKjLBHv1nXrul55nGte13lsnuUo+19Uo7tbSx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/uKLf1Yerv1/mc3nMaopAAA=");
}
