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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1CFVo9rEFR2bMoy922KCH2L9sGcTuTHxqFbNnBpGO/OasqDMR91JawKE18/j" +
       "kAx6BGbVUdytj1dzfCAQJj4TRTsXU2JsT2OkLk6hsMl0lsmiwU+knp0QDEes" +
       "HXRYk51hx2AG0/ZE0YSFGstdLJFpBkY6cA+tpigceaOwsW41FW+cr3t1YhSQ" +
       "TH+1UZzInNjeqg+nfq1Pd2A0WbJCPEGx+Vpu9dZxspx1a8mcx2wBatUnrTUM" +
       "B3lzEM1zFN22GA3DTF9y/dDseIw9NgOMd0NUnvV1dtLFOqQvL/I1+HzljAVm" +
       "sxu73wkbsMbMoGpb8RrNmeh3+locTXOzT+XVSZ2f+y1kWw3EONc3+qYZ1AWG" +
       "n2NSJjcdXOa3wYLyFoY8XVFio4WsArc/UTE18Nehp6WjEcyHbr2bD1mL6620" +
       "cE1LdIwE6hAGAoLNhoB28BGMV7VRVTLQOpalaJJsjZq1qhqoWtspktqGmKFB" +
       "IvowUQIKSVGBHNPrGJs19GbQVczNpkZvSVZF3NxoNEBvoyOpTkIMBszE7Wad" +
       "jT1AsNpw2rVtxI+bAqdM81anAU3qJOUP6bHdtvCmgYpd08y6uk+u+kOsya8R" +
       "b8NM5s1RvozWOLtwnZTsNZAxPKUEeCvCQ7qqwjOIrk4HuJYJcotseViv5cSm" +
       "ijLN/mA3CuCEwWQcgRK/NlWmwBm23a5lzQcJPYTsac57vtCAquuYzJZOw+Kt" +
       "+WxHE01X2jktrtkmalU4mWgOXV9Sk7rdZZYy3FvDrX51TPkaNDJdfm7qiIAr" +
       "dNIi+YTuyuoqmIsm2ALGSb+JDv1la9bcLZBRrjb77hDaTqZpi5svZXMeKFyN" +
       "GdEJB6MDsolHkRr29YkMlH2dIdoqFXJJNxtbiIj0nFpsSHXsjNMu6vgUXlU1" +
       "n7HDRGswM55fsTpG9qt2wM/5wqHY2zCtqk1u1WOtVTajXSMy2dbI7wnKuOq4" +
       "OKyxsrjieMwlo4YEZe0mKzemaKjFcyLvkD0DY1FOc/I4S5RotmtNm2C7aXWg" +
       "pkvnm9HCT3N3LvXDVt6uEbW2H8RDdqTufCUP5g14B8u7FbBrPcP12IagKK/S" +
       "a6GjNMdJkwV+vz5dVxmZVEfSsrfVdMuudyJ82TJyuTpFCKeJGPAaG5vAvbIZ" +
       "0Uq6CAy31ig0FBwYaS/JOufUea2W9tfrbBRPBx1aUDszX2HryEba8cN8q9bM" +
       "6hpZcDS2cmZr3knabWFDs4up08jyeCePWyHflJCkppljLusvaGKjaEPBI/oE" +
       "hsY9O9V4Y1LL6g2n5eUtUdntcrcpyb1Jre11RqS+3dWaNNIZVC1aajWXYMsi" +
       "WrMkYXOFWcXmhl03Qt7Dl92uCqN9RtMyb7cEFhPlUJDxzbbFuasq4jErG9IR" +
       "xE7gVRgwjc7GwhQYcgiuNuBaAi/NuEmT5hbOBHVFoW9UO5KHo5vWTFG7a9Ga" +
       "Z6LaottqB1ls8VGzzUU9qKo1OtBqAo/RWCaCSJFr0bqTseLMhrdjF4RmM9eh" +
       "lsmsS1PNLOPW2yETLFcWMHmZh7ta6rsrIojThmiNCInRBGfIcbhuRRYI0CRr" +
       "1WckXa3JOLdY+ZAbr4y0RqqQ4qwXOzqlcBydLrds7AebGFvMR+PdhO0GbkNf" +
       "DE1XQ1huYxliB9Jyp12vC+lWUBJusxu1mBYlwX1vOF1JFsJusDGjy+E6hxGF" +
       "IeFGo5EF8c5eIRuFjlB3E6QUgTlNISY69Unm7qKEba47WxTqE0EP6SAzZkGK" +
       "O7MtMXTeaePDqrJG0bUo4b1k7ASOrc4oQhsZut0aRlBVZnt0qz9zDXwkLvVk" +
       "3sspo86gib8ZaltOsxYKvVDitoPEmevEEqxGcFvbdOlxt82tY9hJ86mRo/Vd" +
       "uIsm7ZYBNmXOnYO90BxSWZ1CslmfbdZRquMnMT915Wlj7NuG1VOtKbPWoyXY" +
       "hJr9ftKZ2Q1pVweQjmTZUuZj9Mq32a1h0dWUb0koE2Zz2+sO4byziwmcxZeJ" +
       "yC+UZsiGs2hVHxumhW0yMstw3EBsOO33NhQWoWvVmOIQbfWwFoOv+iC251IN" +
       "6bcGC0w0iBFJ8/5sWk9Iep10mwmDsCQxjf3aOEVlQK85QIQ+zKjQtuOhwy2z" +
       "64YKcOcUm7YZ1RvhsUmMNdoPx6FsUFWikwkLSJrg4q468EJn2If8GUvg48hp" +
       "VIeS1shGBgU+fxJoCufkGFqFy/oOzpU5vjOMkUWt0wFwDuBbpdavW5nt+gBN" +
       "m4h3dC3jV4JmU/IYHY8Dn0317YonmGQyUZQqvthlubtOGEpjnB4E2bBTbdJz" +
       "z0UZu2utd4kp1KZJN7GrO3vS5BAbXUXDfKCNZ9hsldmYqUnugk9BBCc4IryV" +
       "ApIO2XXbEQmUzKFcBrGUCwLfBoiljHGqxBOWzFuQh6i4hbMenUFbW8Xb6YYz" +
       "uZSaBqhBN1kOEkLTMatVJaJ7pJ3WsQ3W4fPdvLWZjVF40NvZPa49Cug2TMYZ" +
       "m3RklFF3nYiDumPLxprWSCUlYeGjgm5uerlOCqa/JuhQm0BMO5ZQB5asRm06" +
       "nTp1yMb7QJNT1VkaqLsjhABN55FDxNnYjLfVlao4IyswOxkWSA1b8JepbXg9" +
       "LpXdQHWNbk/stkSMF41RM9jM1kOEGwthZx2ly8ica/zKcTVKAN+/LNEQbX9X" +
       "Uz2+MWjweT2dNiG0xmg+j202M1vuN6oU5pMsxo2tVjBvdYW+iDUnttvkp8R2" +
       "2doMhAYCZWwjqVZVlNugZqeroeDj/F3vKj7bjVd3nPBQeXJyksI0LKTo2L6K" +
       "E4N919NF8ezJWV35u3wx7XX2KP30rLRSnE49cbvMZHky9ekPvPCixPx8/eDo" +
       "jJmJKvdHrve9lryTrQvHrm+//SncpEzMnp59fvEDf/H48vu097yKLNCbLtB5" +
       "EeW/mrz0peFbxJ84qNx1chJ6U8r4/KAb588/rwRyFAfO8twp6BMnkn1DIbEn" +
       "wXPjSLI3bp2JuaUWXCq1YL/2F47wXzElUEiTT6JDtSEdDgPe006y9yW+990h" +
       "JfBPiuK9UeWeyF2ww+Mpnr1D1qEvh2Kge8f5+1IJf/iVjq3OTls2nKZ2Hisa" +
       "3wKewZHUBq9CagcntrO+k+iKv+8vAT56B1n8RFF8OKo8WMriJOdZWt0prz/2" +
       "d8Hr/IjX+d89r8DOnr29nZXpp/3h9Yu/8Mwf/siLz/zXMhtznx6yfNAN1Ftc" +
       "RTgz5lsvffUbf/zaJz5bZjnvFvhwbwgX73DcfEXj3M2LkvwHzmcwnwIMvrwX" +
       "yv4dVd79XWbLiysywCwgYBbQebM4zsf/Pc+QHttT444me6Jpi4gXzeJCkXx0" +
       "9+ei9Zenvz97nEz5hb+lnkSVy5bsqJF2q1Pou8BSFdWf8dKTKQ/2eI6pf+T0" +
       "wByzXEcuEqHHffuLALp7eHIjCHSmtyQ+3RNfTnZmY7qVKp+1yl+9Q9+vF8Uv" +
       "Ae8lFnTt2bgD+G+k+/en7gDzhaL4xCs5gU9+F06g3ISfBs9vHjmB33y128Qr" +
       "+rqfKwG+eAc2v1QUvxWVacWdHES3Y/S3Xw2jaVR54KzQitT3YzfdPtvfmBI/" +
       "++LV+x59cfWf9q7k+FbT/VTlPiW2rLNZxzP1y14gK3rJwf37HKRXvv5DVHn0" +
       "NntWkVAsKyW5/34P/x8B5xfhgRqV77NwfxpVrpzCAVT7ylmQPwM2BECK6pe9" +
       "Y7N4x+020K4QRgEvRkBM2F7ycpBeOh9ynQj/4VcS/pko7ZlzPr+8GXgcB8X7" +
       "u4HPiZ97kaTf++32z+/veogWn+cFlvuAe95fOzmJpZ6+LbZjXJeJt33nwc/f" +
       "/+xx3PfgnuBT1T1D25tufbFiYHtReRUi//VHf/md/+LFr5QJuP8PgY9UQbIp" +
       "AAA=");
}
