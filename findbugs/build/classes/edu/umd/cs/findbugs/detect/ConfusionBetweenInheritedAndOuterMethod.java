package edu.umd.cs.findbugs.detect;
public class ConfusionBetweenInheritedAndOuterMethod extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    edu.umd.cs.findbugs.BugInstance iteratorBug;
    public ConfusionBetweenInheritedAndOuterMethod(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visitJavaClass(org.apache.bcel.classfile.JavaClass obj) {
        isInnerClass =
          false;
        if (obj.
              getClassName(
                ).
              indexOf(
                '$') >=
              0) {
            super.
              visitJavaClass(
                obj);
            bugAccumulator.
              reportAccumulatedBugs(
                );
        }
    }
    boolean isInnerClass;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field f) { if (f.
                                                                 getName(
                                                                   ).
                                                                 startsWith(
                                                                   "this$")) {
                                                               isInnerClass =
                                                                 true;
                                                           } }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { if (isInnerClass &&
                                                                  !edu.umd.cs.findbugs.bcel.BCELUtil.
                                                                  isSynthetic(
                                                                    getMethod(
                                                                      ))) {
                                                                super.
                                                                  visit(
                                                                    obj);
                                                                iteratorBug =
                                                                  null;
                                                            }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (iteratorBug != null) {
                                          if (isRegisterStore(
                                                )) {
                                              org.apache.bcel.classfile.LocalVariableTable lvt =
                                                getMethod(
                                                  ).
                                                getLocalVariableTable(
                                                  );
                                              if (lvt !=
                                                    null) {
                                                  org.apache.bcel.classfile.LocalVariable localVariable =
                                                    lvt.
                                                    getLocalVariable(
                                                      getRegisterOperand(
                                                        ),
                                                      getNextPC(
                                                        ));
                                                  if (localVariable ==
                                                        null ||
                                                        localVariable.
                                                        getName(
                                                          ).
                                                        endsWith(
                                                          "$")) {
                                                      iteratorBug =
                                                        null;
                                                  }
                                              }
                                          }
                                          if (iteratorBug !=
                                                null) {
                                              bugAccumulator.
                                                accumulateBug(
                                                  iteratorBug,
                                                  this);
                                          }
                                          iteratorBug =
                                            null;
                                      }
                                      if (seen !=
                                            INVOKEVIRTUAL) {
                                          return;
                                      }
                                      if (!getClassName(
                                             ).
                                            equals(
                                              getClassConstantOperand(
                                                ))) {
                                          return;
                                      }
                                      edu.umd.cs.findbugs.ba.XMethod invokedMethod =
                                        edu.umd.cs.findbugs.ba.XFactory.
                                        createXMethod(
                                          getDottedClassConstantOperand(
                                            ),
                                          getNameConstantOperand(
                                            ),
                                          getSigConstantOperand(
                                            ),
                                          false);
                                      if (invokedMethod.
                                            isResolved(
                                              ) &&
                                            invokedMethod.
                                            getClassName(
                                              ).
                                            equals(
                                              getDottedClassConstantOperand(
                                                )) ||
                                            invokedMethod.
                                            isSynthetic(
                                              )) {
                                          return;
                                      }
                                      if (getStack(
                                            ).
                                            getStackItem(
                                              getNumberArguments(
                                                getSigConstantOperand(
                                                  ))).
                                            getRegisterNumber(
                                              ) !=
                                            0) {
                                          return;
                                      }
                                      java.lang.String possibleTargetClass =
                                        getDottedClassName(
                                          );
                                      java.lang.String superClassName =
                                        getDottedSuperclassName(
                                          );
                                      while (true) {
                                          int i =
                                            possibleTargetClass.
                                            lastIndexOf(
                                              '$');
                                          if (i <=
                                                0) {
                                              break;
                                          }
                                          possibleTargetClass =
                                            possibleTargetClass.
                                              substring(
                                                0,
                                                i);
                                          if (possibleTargetClass.
                                                equals(
                                                  superClassName)) {
                                              break;
                                          }
                                          edu.umd.cs.findbugs.ba.XMethod alternativeMethod =
                                            edu.umd.cs.findbugs.ba.XFactory.
                                            createXMethod(
                                              possibleTargetClass,
                                              getNameConstantOperand(
                                                ),
                                              getSigConstantOperand(
                                                ),
                                              false);
                                          if (alternativeMethod.
                                                isResolved(
                                                  ) &&
                                                alternativeMethod.
                                                getClassName(
                                                  ).
                                                equals(
                                                  possibleTargetClass)) {
                                              java.lang.String targetPackage =
                                                invokedMethod.
                                                getPackageName(
                                                  );
                                              java.lang.String alternativePackage =
                                                alternativeMethod.
                                                getPackageName(
                                                  );
                                              int priority =
                                                HIGH_PRIORITY;
                                              if (targetPackage.
                                                    equals(
                                                      alternativePackage)) {
                                                  priority++;
                                              }
                                              if (targetPackage.
                                                    startsWith(
                                                      "javax.swing") ||
                                                    targetPackage.
                                                    startsWith(
                                                      "java.awt")) {
                                                  priority +=
                                                    2;
                                              }
                                              if (invokedMethod.
                                                    getName(
                                                      ).
                                                    equals(
                                                      getMethodName(
                                                        ))) {
                                                  priority++;
                                              }
                                              edu.umd.cs.findbugs.BugInstance bug =
                                                new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "IA_AMBIGUOUS_INVOCATION_OF_INHERITED_OR_OUTER_METHOD",
                                                priority).
                                                addClassAndMethod(
                                                  this).
                                                addMethod(
                                                  invokedMethod).
                                                describe(
                                                  "METHOD_INHERITED").
                                                addMethod(
                                                  alternativeMethod).
                                                describe(
                                                  "METHOD_ALTERNATIVE_TARGET");
                                              if (invokedMethod.
                                                    getName(
                                                      ).
                                                    equals(
                                                      "iterator") &&
                                                    invokedMethod.
                                                    getSignature(
                                                      ).
                                                    equals(
                                                      "()Ljava/util/Iterator;") &&
                                                    edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                    instanceOf(
                                                      getDottedClassName(
                                                        ),
                                                      "java.lang.Iterable")) {
                                                  iteratorBug =
                                                    bug;
                                              }
                                              else {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      bug,
                                                      this);
                                              }
                                              break;
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UKaxONezpyg6fsRe6XDjv0gHs137HQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "h+EAE+FpY+YF8nBZoJHByGGviITtAC4MmSlcRQu0hSZM6TGVO2zB1/Zi3RBQ" +
       "WR5nueT4+hKTtuuprJPEcrdKsqKd7B3D3oOF9U70HDqsmVlf34ptJkrSzlKy" +
       "JtyiY3ExRkhiY8aTCEsGg04sa36HT2hXzyeE4PZQeCi3WDFZqd3C4fBep94d" +
       "9TI/VnFZapGYsLVb7GTeXKFOmqzcXWykrI97uEiEnW1WjKlg14vAklDEu7W1" +
       "zNNYTW7XlusBGSn1DtXB2zAhtFMz2hXaBCwohsRsWoPHdIJRZrqXNvl0lOKi" +
       "5uXRVmV60VSJQd5JpjUCrFBSzBx2IrQHR0JPa05LBMzWOlJL1zVuQTSSfNLM" +
       "mrRgDpJ0L+xtZi/Nxs5SD5Y7D02DJDV1qZ6zelvD2KDT6RAt3KLJdn8FHGTf" +
       "SCgHbYXr3N6RBoijNjeddxO/P/U7bczZOcvEyaJs5m8ifT4n4HxBdfpkCGC7" +
       "5abNtHBprN0iJ4bIa2yUOvN+ZzET5dFOIvPFfCBkQrOZJCMH4ycI1Rh2GnuL" +
       "ww0ptOfBek1xWiulkdZ2K0sjZTvmjX24M0EamBqtBeXkCFAIxfDBpNstt7sf" +
       "/vq24U9WJw6nV7Zg9112bL6Onfah67myeNfpAVX1dw26dM13/mD/7BQXKo92" +
       "3nG/m9jqWOczH3nlVX38WfTq8cnVnRR6LA3Cb3ON3HDPsXoYcHrP/Y+wDpdd" +
       "Z6eyv/iR//X07DusD30dd1LPXpLzMssf4T73S/1v0f75Veih0zPau67ILxK9" +
       "dPFk9gYImSz2ZxfOZ99x8V7o28CDHFsWuXz0dzZ3d3nBlcoLDnN/6XLh0gXF" +
       "C0FsHimholnGkaoZ7lH1MUR5x3vEKLlSTU/F55894JLik2XxAyn0RG4ndnpK" +
       "d8/znTyw9TOH+ycXHe7xU4c7FfCps4OpcW7Esa0bD/DRu+8RqoZ/fNGsz4Dn" +
       "/cdmff83xKzP3t+s1W1DxeOzDzDpj5TFv0qhRyqTlj9+6Mxq//q+ViubP/03" +
       "ts+z4KGO7UN9Q+zzzP3tQwa6UbH4yQeY56fL4vP3Mc8XvsHmeQE87LF52L99" +
       "81yKmIdsP61ofu4B9vhiWfwsQMtEKcahBkx4ySb/4W/RJtsUevfX+MFBeXv6" +
       "trs+kTp81qP9+Ks3H33rq9JvVXfup5/ePMZCj64z1z1/iXWufi2MjfUhrT12" +
       "uNIKq3//KYWevv8HEil07VCplPm1A8l/SaE33YMkBe8/rp4f/ZspdONsdApd" +
       "1S50/04KXT/uBnMGyvOd/w00gc6y+rvhSQy8917iVsFwmEExBYaiKqmDeHvl" +
       "YiY9ndinXu9w/FzyfeFCyqw+cDtJb9nhE7c72udfZfgPf6X12cMHBSAs9/uS" +
       "y6MsdP3wbcNpinzuvtxOeF0bvPjVJ77w2LtO0vkTB4HPQuScbM/e+/ae9sK0" +
       "um/f//Rbf/J9/+bV36vuI/4fY3h8BXkoAAA=");
}
