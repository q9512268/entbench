package edu.umd.cs.findbugs;
public class FieldAnnotation extends edu.umd.cs.findbugs.PackageMemberAnnotation {
    private static final long serialVersionUID = 1L;
    public static final java.lang.String DEFAULT_ROLE = "FIELD_DEFAULT";
    public static final java.lang.String DID_YOU_MEAN_ROLE = "FIELD_DID_YOU_MEAN";
    public static final java.lang.String VALUE_OF_ROLE = "FIELD_VALUE_OF";
    public static final java.lang.String LOADED_FROM_ROLE = VALUE_OF_ROLE;
    public static final java.lang.String STORED_ROLE = "FIELD_STORED";
    public static final java.lang.String INVOKED_ON_ROLE = "FIELD_INVOKED_ON";
    public static final java.lang.String ARGUMENT_ROLE = "FIELD_ARGUMENT";
    private final java.lang.String fieldName;
    private final java.lang.String fieldSig;
    private java.lang.String fieldSourceSig;
    private final boolean isStatic;
    public FieldAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                           java.lang.String className, java.lang.String fieldName,
                           java.lang.String fieldSig,
                           boolean isStatic) { super(className, DEFAULT_ROLE);
                                               if (fieldSig.indexOf(
                                                              '.') >=
                                                     0) { assert false: "signatures should not be dotted: " +
                                                          fieldSig;
                                                          fieldSig =
                                                            fieldSig.
                                                              replace(
                                                                '.',
                                                                '/');
                                               }
                                               this.fieldName =
                                                 fieldName;
                                               this.fieldSig =
                                                 fieldSig;
                                               this.isStatic =
                                                 isStatic;
    }
    public FieldAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                           java.lang.String className, java.lang.String fieldName,
                           java.lang.String fieldSig,
                           java.lang.String fieldSourceSig,
                           boolean isStatic) { this(
                                                 className,
                                                 fieldName,
                                                 fieldSig,
                                                 isStatic);
                                               this.
                                                 fieldSourceSig =
                                                 fieldSourceSig;
    }
    public FieldAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                           java.lang.String className,
                           java.lang.String fieldName,
                           java.lang.String fieldSig,
                           int accessFlags) { this(
                                                className,
                                                fieldName,
                                                fieldSig,
                                                (accessFlags &
                                                   org.apache.bcel.Constants.
                                                     ACC_STATIC) !=
                                                  0);
    }
    public static edu.umd.cs.findbugs.FieldAnnotation fromVisitedField(edu.umd.cs.findbugs.visitclass.PreorderVisitor visitor) {
        return new edu.umd.cs.findbugs.FieldAnnotation(
          visitor.
            getDottedClassName(
              ),
          visitor.
            getFieldName(
              ),
          visitor.
            getFieldSig(
              ),
          visitor.
            getFieldIsStatic(
              ));
    }
    public static edu.umd.cs.findbugs.FieldAnnotation fromReferencedField(edu.umd.cs.findbugs.visitclass.DismantleBytecode visitor) {
        java.lang.String className =
          visitor.
          getDottedClassConstantOperand(
            );
        return new edu.umd.cs.findbugs.FieldAnnotation(
          className,
          visitor.
            getNameConstantOperand(
              ),
          visitor.
            getSigConstantOperand(
              ),
          visitor.
            getRefFieldIsStatic(
              ));
    }
    public static edu.umd.cs.findbugs.FieldAnnotation fromBCELField(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                                    java.lang.String className,
                                                                    org.apache.bcel.classfile.Field field) {
        return new edu.umd.cs.findbugs.FieldAnnotation(
          className,
          field.
            getName(
              ),
          field.
            getSignature(
              ),
          field.
            isStatic(
              ));
    }
    public static edu.umd.cs.findbugs.FieldAnnotation fromBCELField(org.apache.bcel.classfile.JavaClass jClass,
                                                                    org.apache.bcel.classfile.Field field) {
        return new edu.umd.cs.findbugs.FieldAnnotation(
          jClass.
            getClassName(
              ),
          field.
            getName(
              ),
          field.
            getSignature(
              ),
          field.
            isStatic(
              ));
    }
    public static edu.umd.cs.findbugs.FieldAnnotation fromFieldDescriptor(edu.umd.cs.findbugs.classfile.FieldDescriptor fieldDescriptor) {
        return new edu.umd.cs.findbugs.FieldAnnotation(
          fieldDescriptor.
            getClassDescriptor(
              ).
            getDottedClassName(
              ),
          fieldDescriptor.
            getName(
              ),
          fieldDescriptor.
            getSignature(
              ),
          fieldDescriptor.
            isStatic(
              ));
    }
    public static edu.umd.cs.findbugs.FieldAnnotation fromXField(edu.umd.cs.findbugs.ba.XField fieldDescriptor) {
        return new edu.umd.cs.findbugs.FieldAnnotation(
          fieldDescriptor.
            getClassName(
              ),
          fieldDescriptor.
            getName(
              ),
          fieldDescriptor.
            getSignature(
              ),
          fieldDescriptor.
            getSourceSignature(
              ),
          fieldDescriptor.
            isStatic(
              ));
    }
    public edu.umd.cs.findbugs.ba.XField toXField() {
        return edu.umd.cs.findbugs.ba.XFactory.
          createXField(
            className,
            fieldName,
            fieldSig,
            isStatic);
    }
    public edu.umd.cs.findbugs.classfile.FieldDescriptor toFieldDescriptor() {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getFieldDescriptor(
            this);
    }
    public java.lang.String getFieldName() {
        return fieldName;
    }
    public java.lang.String getFieldSignature() {
        return fieldSig;
    }
    public boolean isStatic() { return isStatic;
    }
    public static edu.umd.cs.findbugs.FieldAnnotation isRead(org.apache.bcel.generic.Instruction ins,
                                                             org.apache.bcel.generic.ConstantPoolGen cpg) {
        if (ins instanceof org.apache.bcel.generic.GETFIELD ||
              ins instanceof org.apache.bcel.generic.GETSTATIC) {
            org.apache.bcel.generic.FieldInstruction fins =
              (org.apache.bcel.generic.FieldInstruction)
                ins;
            java.lang.String className =
              fins.
              getClassName(
                cpg);
            return new edu.umd.cs.findbugs.FieldAnnotation(
              className,
              fins.
                getName(
                  cpg),
              fins.
                getSignature(
                  cpg),
              fins instanceof org.apache.bcel.generic.GETSTATIC);
        }
        else {
            return null;
        }
    }
    public static edu.umd.cs.findbugs.FieldAnnotation isWrite(org.apache.bcel.generic.Instruction ins,
                                                              org.apache.bcel.generic.ConstantPoolGen cpg) {
        if (ins instanceof org.apache.bcel.generic.PUTFIELD ||
              ins instanceof org.apache.bcel.generic.PUTSTATIC) {
            org.apache.bcel.generic.FieldInstruction fins =
              (org.apache.bcel.generic.FieldInstruction)
                ins;
            java.lang.String className =
              fins.
              getClassName(
                cpg);
            return new edu.umd.cs.findbugs.FieldAnnotation(
              className,
              fins.
                getName(
                  cpg),
              fins.
                getSignature(
                  cpg),
              fins instanceof org.apache.bcel.generic.PUTSTATIC);
        }
        else {
            return null;
        }
    }
    @java.lang.Override
    public void accept(edu.umd.cs.findbugs.BugAnnotationVisitor visitor) {
        visitor.
          visitFieldAnnotation(
            this);
    }
    @java.lang.Override
    protected java.lang.String formatPackageMember(java.lang.String key,
                                                   edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        if ("".
              equals(
                key) ||
              "hash".
              equals(
                key)) {
            return className +
            "." +
            fieldName;
        }
        else
            if ("givenClass".
                  equals(
                    key)) {
                java.lang.String primaryClassName =
                  primaryClass.
                  getClassName(
                    );
                if (className.
                      equals(
                        primaryClassName)) {
                    return getNameInClass(
                             primaryClass);
                }
                else {
                    return shorten(
                             primaryClass.
                               getPackageName(
                                 ),
                             className) +
                    "." +
                    fieldName;
                }
            }
            else
                if ("name".
                      equals(
                        key)) {
                    return fieldName;
                }
                else
                    if ("fullField".
                          equals(
                            key)) {
                        edu.umd.cs.findbugs.ba.SignatureConverter converter =
                          new edu.umd.cs.findbugs.ba.SignatureConverter(
                          fieldSig);
                        java.lang.StringBuilder result =
                          new java.lang.StringBuilder(
                          );
                        if (isStatic) {
                            result.
                              append(
                                "static ");
                        }
                        result.
                          append(
                            converter.
                              parseNext(
                                ));
                        result.
                          append(
                            ' ');
                        result.
                          append(
                            className);
                        result.
                          append(
                            '.');
                        result.
                          append(
                            fieldName);
                        return result.
                          toString(
                            );
                    }
                    else {
                        throw new java.lang.IllegalArgumentException(
                          "unknown key " +
                          key);
                    }
    }
    private java.lang.String getNameInClass(edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        if (primaryClass ==
              null) {
            return className +
            "." +
            fieldName;
        }
        java.lang.String givenPackageName =
          primaryClass.
          getPackageName(
            );
        java.lang.String thisPackageName =
          this.
          getPackageName(
            );
        if (thisPackageName.
              equals(
                givenPackageName)) {
            if (thisPackageName.
                  length(
                    ) ==
                  0) {
                return fieldName;
            }
            else {
                return className.
                  substring(
                    thisPackageName.
                      length(
                        ) +
                      1) +
                "." +
                fieldName;
            }
        }
        return className +
        "." +
        fieldName;
    }
    @java.lang.Override
    public int hashCode() { return className.
                              hashCode(
                                ) +
                              fieldName.
                              hashCode(
                                ) +
                              fieldSig.
                              hashCode(
                                ); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (!(o instanceof edu.umd.cs.findbugs.FieldAnnotation)) {
            return false;
        }
        edu.umd.cs.findbugs.FieldAnnotation other =
          (edu.umd.cs.findbugs.FieldAnnotation)
            o;
        return className.
          equals(
            other.
              className) &&
          fieldName.
          equals(
            other.
              fieldName) &&
          fieldSig.
          equals(
            other.
              fieldSig) &&
          isStatic ==
          other.
            isStatic;
    }
    @java.lang.Override
    public int compareTo(edu.umd.cs.findbugs.BugAnnotation o) {
        if (!(o instanceof edu.umd.cs.findbugs.FieldAnnotation)) {
            return this.
              getClass(
                ).
              getName(
                ).
              compareTo(
                o.
                  getClass(
                    ).
                  getName(
                    ));
        }
        edu.umd.cs.findbugs.FieldAnnotation other =
          (edu.umd.cs.findbugs.FieldAnnotation)
            o;
        int cmp;
        cmp =
          className.
            compareTo(
              other.
                className);
        if (cmp !=
              0) {
            return cmp;
        }
        cmp =
          fieldName.
            compareTo(
              other.
                fieldName);
        if (cmp !=
              0) {
            return cmp;
        }
        return fieldSig.
          compareTo(
            other.
              fieldSig);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.SourceLineAnnotation getSourceLines() {
        if (sourceLines ==
              null) {
            edu.umd.cs.findbugs.ba.AnalysisContext currentAnalysisContext =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                );
            if (currentAnalysisContext ==
                  null) {
                sourceLines =
                  new edu.umd.cs.findbugs.SourceLineAnnotation(
                    className,
                    sourceFileName,
                    -1,
                    -1,
                    -1,
                    -1);
            }
            else {
                edu.umd.cs.findbugs.ba.SourceInfoMap.SourceLineRange fieldLine =
                  currentAnalysisContext.
                  getSourceInfoMap(
                    ).
                  getFieldLine(
                    className,
                    fieldName);
                if (fieldLine ==
                      null) {
                    sourceLines =
                      new edu.umd.cs.findbugs.SourceLineAnnotation(
                        className,
                        sourceFileName,
                        -1,
                        -1,
                        -1,
                        -1);
                }
                else {
                    sourceLines =
                      new edu.umd.cs.findbugs.SourceLineAnnotation(
                        className,
                        sourceFileName,
                        fieldLine.
                          getStart(
                            ),
                        fieldLine.
                          getEnd(
                            ),
                        -1,
                        -1);
                }
            }
        }
        return sourceLines;
    }
    private static final java.lang.String
      ELEMENT_NAME =
      "Field";
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput)
          throws java.io.IOException { writeXML(
                                         xmlOutput,
                                         false,
                                         false);
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean addMessages,
                         boolean isPrimary)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.XMLAttributeList attributeList =
                                         new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                         ).
                                         addAttribute(
                                           "classname",
                                           getClassName(
                                             )).
                                         addAttribute(
                                           "name",
                                           getFieldName(
                                             )).
                                         addAttribute(
                                           "signature",
                                           getFieldSignature(
                                             ));
                                       if (fieldSourceSig !=
                                             null) {
                                           attributeList.
                                             addAttribute(
                                               "sourceSignature",
                                               fieldSourceSig);
                                       }
                                       attributeList.
                                         addAttribute(
                                           "isStatic",
                                           java.lang.String.
                                             valueOf(
                                               isStatic(
                                                 )));
                                       if (isPrimary) {
                                           attributeList.
                                             addAttribute(
                                               "primary",
                                               "true");
                                       }
                                       java.lang.String role =
                                         getDescription(
                                           );
                                       if (!DEFAULT_ROLE.
                                             equals(
                                               role)) {
                                           attributeList.
                                             addAttribute(
                                               "role",
                                               role);
                                       }
                                       xmlOutput.
                                         openTag(
                                           ELEMENT_NAME,
                                           attributeList);
                                       getSourceLines(
                                         ).
                                         writeXML(
                                           xmlOutput,
                                           addMessages,
                                           false);
                                       if (addMessages) {
                                           xmlOutput.
                                             openTag(
                                               edu.umd.cs.findbugs.BugAnnotation.
                                                 MESSAGE_TAG);
                                           xmlOutput.
                                             writeText(
                                               this.
                                                 toString(
                                                   ));
                                           xmlOutput.
                                             closeTag(
                                               edu.umd.cs.findbugs.BugAnnotation.
                                                 MESSAGE_TAG);
                                       }
                                       xmlOutput.
                                         closeTag(
                                           ELEMENT_NAME);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVbC3AcxZnuXT0s62E9jB/Y+C0wNngXSDA4AoMeK3nt1SOS" +
       "pYDMsR7NtqTBszvDTK+8EueLcVWCc0k4X2ITcpeYuytSEMrEVC4pQoWkDKmD" +
       "5HCuKpALhBSQIqmCQMhBXR1cQQ7u/7tndmZnZ8aWSiKqmtZsP/6//+9/9N/T" +
       "M6feIlWmQdbSHIuxaZ2asUSODUiGSTOdqmSae6EuLX+tQvrvW1/v2xEl1aNk" +
       "yaRk9sqSSbsVqmbMUbJGyZlMysnU7KM0gyMGDGpSY0piipYbJcsUM5nVVUVW" +
       "WK+WodhhRDJSpFlizFDG8owmLQKMrEnBTOJ8JvF2b3NbitTLmj7tdF/p6t7p" +
       "asGeWYeXyUhT6jZpSornmaLGU4rJ2goGuUzX1OkJVWMxWmCx29SrLQh2p64u" +
       "g2DjI43vfnBssolDsFTK5TTGxTMHqampUzSTIo1ObUKlWfN28jekIkXqXJ0Z" +
       "aU3ZTOPANA5MbWmdXjD7BprLZzs1Lg6zKVXrMk6IkQ2lRHTJkLIWmQE+Z6BQ" +
       "wyzZ+WCQdn1RWiFlmYgnLosf/9qtTd+tII2jpFHJDeF0ZJgEAyajACjNjlHD" +
       "bM9kaGaUNOdA2UPUUCRVmbE03WIqEzmJ5UH9NixYmdepwXk6WIEeQTYjLzPN" +
       "KIo3zg3K+lU1rkoTIOtyR1YhYTfWg4C1CkzMGJfA7qwhlQeUXIaRdd4RRRlb" +
       "90AHGLooS9mkVmRVmZOggrQIE1Gl3ER8CEwvNwFdqzQwQIORVYFEEWtdkg9I" +
       "EzSNFunpNyCaoNdiDgQOYWSZtxunBFpa5dGSSz9v9V139x25XbkoicCcM1RW" +
       "cf51MGitZ9AgHacGBT8QA+u3pu6Rlv/oaJQQ6LzM01n0efSv37nx8rVnfir6" +
       "rPbp0z92G5VZWr5/bMkvLurcsqMCp1Gja6aCyi+RnHvZgNXSVtAhwiwvUsTG" +
       "mN14ZvCpmw8/RN+MktokqZY1NZ8FO2qWtayuqNTooTlqSIxmkmQxzWU6eXuS" +
       "LIL7lJKjorZ/fNykLEkqVV5VrfHfANE4kECIauFeyY1r9r0usUl+X9AJIYvg" +
       "IvVwbSfij/9nZDQ+qWVpXJKlnJLT4gOGhvKbcYg4Y4DtZHwcjGksP2HGTUOO" +
       "c9OhmXw8n83EZdNp5FHSce4YdtQXlHoBZVt6MBIB2C/yOr0K/rJLUzPUSMvH" +
       "8x2Jd76TfkYYFDqBhQojm4BZDJjFZDNmM4t5mJFIhPO4AJkKtYJSDoB7Q3yt" +
       "3zL0V7v3H91YAfakH6wERCug68aSdabTiQF24E7Lp1saZja8fOVPoqQyRVok" +
       "meUlFZeNdmMCApJ8wPLZ+jFYgZyFYL1rIcAVzNBkkMCgQQuCRaVGm6IG1jNy" +
       "gYuCvUyhQ8aDFwnf+ZMz9x68c+SzV0RJtDT2I8sqCFs4fAAjdjEyt3p93o9u" +
       "412vv3v6nkOa4/0li4m9BpaNRBk2eq3AC09a3rpe+n76R4daOeyLITozCbwJ" +
       "At9aL4+S4NJmB2qUpQYEHteMrKRik41xLZs0tINODTfPZn5/AZhFHXrbKrhu" +
       "ttyP/8fW5TqWK4Q5o515pOALwfVD+jdf+I8/fILDba8Zja7FfoiyNlecQmIt" +
       "PCI1O2a716AU+r1078BXT7x11z5us9Bjkx/DViw7IT6BCgHmz/309l+/8vL9" +
       "v4wW7TzCYKHOj0G+UygKifWkNkRI4HaJMx+IcypEA7Sa1uEc2KcyrkhjKkXH" +
       "+nPjxVd+/493Nwk7UKHGNqPLz03Aqb+wgxx+5tb31nIyERnXWQczp5sI3ksd" +
       "yu2GIU3jPAp3Prvm609L34RlAEKvqcxQHk0rOQaVXPKVkHbxkbikxsSSivXb" +
       "eVEaDtDlhvJjJriukgVNTVlr11UD++WjrQO/F+vShT4DRL9lD8a/PPL8bWe5" +
       "HdRgcMB6ZNTgcn0IIi4jbBL6+Qj+InB9iBfqBSvEGtDSaS1E64srka4XYOZb" +
       "QlLHUgHih1peOfCN1x8WAnhXak9nevT4334Uu/u4UK5IZzaVZRTuMSKlEeJg" +
       "0Yaz2xDGhY/ofu30oR8+eOguMauW0sU5Abnnw7/6v7Oxe3/7M5+1YdGYpqlU" +
       "EhHtk2jxwu7RRUv1I4Tq+kLj48daKrohtCRJTT6n3J6nyYybKmRkZn7MpTAn" +
       "VeIVbvFQOYxEtoIeePXVfBpXFCdD+GQIb9uNxcWmO8KWqsuVdKflY798u2Hk" +
       "7R+/w0UuzdrdAaVX0gXezVhcgniv8K6AuyRzEvp98kzfLU3qmQ+A4ihQlCFV" +
       "NfsNWHsLJeHH6l216MUnfrJ8/y8qSLSb1KqalOmWeCQniyGEUnMSlu2CfsON" +
       "IoIcrIGiiYtKyoQvq0AvXucfHxJZnXGPnvnBiu9d98DJl3ko0zmJNeVhOmNF" +
       "sIx/mMZyMxaXlQe/oKEeDVbxOVc5kaK0+BTnNBqi9luwGOZNe7AYEXj0zRE6" +
       "rNgbiMeUJdTU7PEIGuoRzQqpHih487WWy+O/61337YxUKNbG0eWh+LNHuM14" +
       "CH5ZLCQHv7H5wE80rOaVDZiZlqSCPLV0spGHnrvmPx/4+3sOivAUEmw941a+" +
       "36+OHXn1f8tcmCdfPvHXM340fuobqzp3vsnHO1kQjm4tlGfTkEk6Y696KPs/" +
       "0Y3V/xYli0ZJk2zt3UckNY+5xSjsV017Qw/7+5L20r2n2Gi1FbO8i7wLgIut" +
       "N/9yx9RKVhI/nZTrQtQLqugaywCv8douz+uXOGt3SoPN8Bd/f+zs3216BbDZ" +
       "TaqmcN4AiWuB78vj84HPnzqxpu74b7/Io4hFnxvetPAFXm7FYpvYFsCCohvK" +
       "FKytkDiZ/JkDA6GUnKR6EqiVIVOGVMPkDyNGqGGCxoeTXefykEoVpPJ3Ecd3" +
       "uQPMnMsBzOJEcY5kJ1w7rInuKMeWkYbuZCLVle5KdLcPp/Zi/ZcC0MHbGBZ3" +
       "YnHEg8iKEEaM1Fv004P9qUQxcrjk+vIs5doFV5vFrs1PrhZLrmRX+ub+4XRv" +
       "or0PG0/MWbggbow0u5kESnjPLCXEbtdbPK/3k3CJkHCkPTWcSPd3Y8PJOUsX" +
       "xAkMxGYQKNl9c5DsBovfDeWS4f9/wuKBOUsTRB0fvva3dyW60t2D/b2BAj04" +
       "S4Gug6vdYtnup6p6oaqhvf2DiS6sPj1n0YL4MFInyAdK9cgspeqCq9Pi1ukn" +
       "VZOQKtk30r8H+PZzB/vBnCUL4gU5r8MiULrH5mCECYtjIsS92gd7hnsTfTwy" +
       "PjFn2YI4gXvZDAIle/L8JWvB2k1w9Vj8esokI/zm3/0lieLtYT8hmkOIMrKY" +
       "Py/vsxZ8rwDPzFKAjXAlLV7JAAGenYsAQUQZqeECDCkTfvN/7vznX2/Pf4/F" +
       "ak/A/F/0nz8Pfoc9U68LoQd2Kqau5Q2ZBgjwmzlYUK/FsDdAgFfnooAgoqAA" +
       "xRSHPPj7U575/+78588TSsjIInnRVfz3+nYVT7bx9xshLn040KVXhjCAaJ9I" +
       "JbhH97X3+nr0myHyFPz2afyvmngOBlxMXTsago8B1gSd3fBHLvcfOX4y0/+t" +
       "K6PWLqsDPJhp+jaVTlHVRWo5UirZHPXy0ypnp/HSkq/87rHWiY7ZPCLHurXn" +
       "eAiOv9dBTr81eL/lncrTR95YtXfn5P5ZPO1e50HJS/Lbvad+1nOJ/JUoP5oT" +
       "W6CyI73SQW2lG59ag7K8kSt9fLSpqFeMFOQquI5Yej3itVbHcvxdTSw7Pq4W" +
       "RNGz2bYfmOHvlYzE/A5bphRTYfy8NzZgUA2fGo1glWbg9CKVwfv3SA1Wfgip" +
       "wrihZfkgmukunq2uPL/THcdxPpq3xyfvl+rgariOWYgdmzcdBFEM18EV59BB" +
       "l2JmYbuu0o5pRmVwFo708hAtrMKiiZGlqIXioUnGDoKR2iLCkeaFQjgO130W" +
       "HvfNG8JBFD1gRB1S222Y12nGREzSJXmSxsZkqsY4unhQK+yPI3dJCKo4ych6" +
       "yOAQ1Y7ORMoPzw0LiecpS/pT84ZnEEV/PItOHAzlbmlK4osPgrGZ47Y9BFNc" +
       "+SNXnAPTKxcyCjxqIfDovGEaRDE8CmzziwIeE+2ipmwouh2Iu0OAxfOHyI1W" +
       "CPAM9sDbvlDwXg7X4xYYj88bvEEUw+Fd4wfvmBS7yfH9kRA4R7EYYKQW4bzJ" +
       "z0g/vQAo8uQcn/Q/acn8ZAiKWPg86Q8aGiIsDWnD/UZkP+TvTHNg+IwDg7QA" +
       "MKy2jekpS5anZg9D0NAQUY2QNjz5jmQZaWaaj3P1OHjkFsos1sJ11hLq7Ozx" +
       "CBoaIvNnQ9pw1xSZga3QBBUHKsVnAw4UdywUFLh9fc6S57nZQxE0NETcL4W0" +
       "3Y3FXWAaNhRD9puJHjyOLgAeS7EN/eVFS6gXZ49H0NAQmb8e0vaPWBz37vgd" +
       "GE4s1PJzKVyvWbK8FgLD7JafIIqzzJgm8KUORY4lrbem7G0P9N0c1Nc+wxvQ" +
       "NLWH5ji6D4Qg/zAW/8xItWIOUsm7YP3LQuG+Ba73LZTenzfcgyj6444CPojF" +
       "QxyJx0JQ+iEW/8rIIsX8jAH7VQ9M31sAmPgJPnSLVAma4v95wsQfGcbKX/AK" +
       "JBaeGF3qlxh15Cec7bh77/90CJDPYPEEmBu+baKLNwC8555TmpJxsPU86a4v" +
       "YlucXYtzxts/RQ1DydBgdcxdIcuwDeJFpNbCsHY2CmFksW5osDdnNOPRS0MI" +
       "zUDLdfasvk9L+PbKUQ/H/uUQvbyKxfO4FcAXJJn1Vngvf6Xe4cYV8kKgQrD1" +
       "2YWAnq9YG4DDZgumzSHQY/FSKcJ1IUP9LR9FeYUj86cQ1N7G4g+MLIFlHJOZ" +
       "ZM7e1roBe2MBokMjtq2AiV5riXXtbIwxKDoEEQuB4M8hbR9i8S6s6pOSOdlp" +
       "PcGdcIB57y9kSRcCB+tsO1J2ij4X3IKIhUdV17sp4p0a5B2tCwY02ohFFURP" +
       "enteEg/lnSQpWv3xw8nNEA8+rGPASNnZ4lzgDCIWDueGcy5SHMOLQvBdj8Vy" +
       "hq9W4QvUdK9WarHRFR8/xOuxLQYc9lmo7JsPiIOIhYCzLaQtjsVmEQjFqSN+" +
       "/2KG5g9OP5+n+tFLP36keca1DTgULHAK84F0ELE5GHMhq8Zu6k3155meF8Fi" +
       "ZzgV8WK8osWS/YkC5lu2E3RgcS1E5oOYzQJNBPXnDvo7/kLoDwOHQxZgh+YD" +
       "/SBiHtwqige80Rt4VOUFh+rTgQlCtJN3GMJiTzCWqY8BywIjjZ4DMnylemXZ" +
       "N5XiO0D5Oycba1acHH6eH9EWv9WrT5Ga8byqul/SdN1X6wYdV7ga6sUrmzoH" +
       "4BYwNB9z5S9QiFucdnSf6J1mpNbpzUhULmkeg02W1cxIBZTuRgpV0Ii347pt" +
       "5Jf5uUpJAutaAYRrrHbDyQ8Rl50rR3Odo28qOX/mX7faZ8V58X1rWj59cnff" +
       "He9s/5b47kdWpZkZpFKXIovEJ0icKJ43bwikZtOq3rXlgyWPLL7YPplvFhN2" +
       "3GG1E4nJXrArHXW/yvNRjNla/Dbm1/df9+OfH61+NorxPyKB+vaVv99b0PMG" +
       "WbMvVf7JxIhk8K912rb8w/TOy8f/6zf2u7SR0vemvf3T8uhXX0g+cuC9G/nn" +
       "lFWgK1rgLx53TecGqTxllHx/sQTNUsKPcopJNcDXUKzFr8QY2Vj++Un5t3W1" +
       "qnaQGh1aPsff72hIkTqnRmjCc0Sf13XPAKfGUh2W/AXLNh7awTTTqV5dt7/O" +
       "SejcN3t8Aod4gzc6zW/xbub/AeoxyM3oPgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mbcjUqq23a4dTes+8Hcew3IjoTKktmKH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "xumYSgAA");
}
