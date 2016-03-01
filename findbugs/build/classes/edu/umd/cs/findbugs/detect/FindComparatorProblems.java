package edu.umd.cs.findbugs.detect;
public class FindComparatorProblems extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor FLOAT_DESCRIPTOR =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/Float",
      "compare",
      "(FF)I",
      true);
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      DOUBLE_DESCRIPTOR =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/Double",
      "compare",
      "(DD)I",
      true);
    private boolean isComparator;
    private int lastEmptyStackPC;
    private java.util.List<int[]> twoDoublesInStack;
    private final edu.umd.cs.findbugs.BugAccumulator accumulator;
    public FindComparatorProblems(edu.umd.cs.findbugs.BugReporter reporter) {
        super(
          );
        this.
          accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            reporter);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        boolean comparator =
          edu.umd.cs.findbugs.ba.ch.Subtypes2.
          instanceOf(
            classContext.
              getClassDescriptor(
                ),
            "java.util.Comparator");
        boolean comparable =
          edu.umd.cs.findbugs.ba.ch.Subtypes2.
          instanceOf(
            classContext.
              getClassDescriptor(
                ),
            "java.lang.Comparable");
        isComparator =
          comparator;
        if (comparator ||
              comparable) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public boolean shouldVisitCode(org.apache.bcel.classfile.Code obj) {
        return !getMethodDescriptor(
                  ).
          isStatic(
            ) &&
          (isComparator &&
             getMethodName(
               ).
             equals(
               "compare") &&
             getMethodSig(
               ).
             endsWith(
               ")I") ||
             getMethodName(
               ).
             equals(
               "compareTo") &&
             getMethodSig(
               ).
             equals(
               "(L" +
               getClassName(
                 ) +
               ";)I"));
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        this.
          twoDoublesInStack =
          new java.util.ArrayList<int[]>(
            );
        this.
          lastEmptyStackPC =
          0;
        super.
          visit(
            obj);
        this.
          accumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (getStack().getStackDepth(
                                                       ) ==
                                            0) { this.lastEmptyStackPC =
                                                   getPC(
                                                     ); }
                                      if ((seen == DCMPG ||
                                             seen ==
                                             DCMPL ||
                                             seen ==
                                             FCMPL ||
                                             seen ==
                                             FCMPG) && getStack(
                                                         ).
                                            getStackDepth(
                                              ) ==
                                            2) { int[] startEnd =
                                                   new int[] { this.
                                                                 lastEmptyStackPC,
                                                 getPC(
                                                   ) };
                                                 for (java.util.Iterator<int[]> iterator =
                                                        twoDoublesInStack.
                                                        iterator(
                                                          );
                                                      iterator.
                                                        hasNext(
                                                          );
                                                      ) {
                                                     int[] oldStartEnd =
                                                       iterator.
                                                       next(
                                                         );
                                                     if (codeEquals(
                                                           oldStartEnd,
                                                           startEnd)) {
                                                         edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                                                           getStack(
                                                             ).
                                                           getStackItem(
                                                             0);
                                                         edu.umd.cs.findbugs.OpcodeStack.Item item2 =
                                                           getStack(
                                                             ).
                                                           getStackItem(
                                                             1);
                                                         accumulator.
                                                           accumulateBug(
                                                             new edu.umd.cs.findbugs.BugInstance(
                                                               "CO_COMPARETO_INCORRECT_FLOATING",
                                                               NORMAL_PRIORITY).
                                                               addClassAndMethod(
                                                                 this).
                                                               addType(
                                                                 item1.
                                                                   getSignature(
                                                                     )).
                                                               addMethod(
                                                                 item1.
                                                                   getSignature(
                                                                     ).
                                                                   equals(
                                                                     "D")
                                                                   ? DOUBLE_DESCRIPTOR
                                                                   : FLOAT_DESCRIPTOR).
                                                               describe(
                                                                 edu.umd.cs.findbugs.MethodAnnotation.
                                                                   SHOULD_CALL).
                                                               addValueSource(
                                                                 item1,
                                                                 this).
                                                               addValueSource(
                                                                 item2,
                                                                 this),
                                                             this);
                                                         iterator.
                                                           remove(
                                                             );
                                                         return;
                                                     }
                                                 }
                                                 twoDoublesInStack.
                                                   add(
                                                     startEnd);
                                      }
                                      if (seen ==
                                            IRETURN) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                            stack.
                                            getStackItem(
                                              0);
                                          java.lang.Object o =
                                            top.
                                            getConstant(
                                              );
                                          if (o instanceof java.lang.Integer &&
                                                ((java.lang.Integer)
                                                   o).
                                                intValue(
                                                  ) ==
                                                java.lang.Integer.
                                                  MIN_VALUE) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "CO_COMPARETO_RESULTS_MIN_VALUE",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                      } }
    private boolean codeEquals(int[] oldStartEnd,
                               int[] startEnd) {
        int oldStart =
          oldStartEnd[0];
        int oldEnd =
          oldStartEnd[1];
        int start =
          startEnd[0];
        int end =
          startEnd[1];
        if (end -
              start !=
              oldEnd -
              oldStart) {
            return false;
        }
        for (int i =
               start;
             i <
               end;
             i++) {
            if (getCodeByte(
                  i) !=
                  getCodeByte(
                    i -
                      start +
                      oldStart)) {
                return false;
            }
        }
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "i58DlGiimACB08Wc0ae9KjScj3Fv7Jcj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GACqSW/QgBtyLTXJJJ4udG3jVylMUQTBqHApNqSMlsbSGWE1Ym6qSq32poJr" +
       "KLXaJKYoGjO4jpIjyWwyhFFbtJGWTBIiEgMElXEKHtEUNx7JxFRZhNKyisoD" +
       "bxN6Q7vbEWgEYWx0u5CGrYbiuIMFutg2EgZZsYoIbEug4a3BpB1cHBnuUlSM" +
       "xobnt9C2UelZVIJxMBODEz7AfCvEG6jslnZHqx5KjJSaVcuSZegtWAjqKzAn" +
       "LBdNJVvS437Z1wmaJaHRbLKa+FTMU8pM6fn17hJCN30HiaSuFTaRwXbWbLcz" +
       "C9A3Lwtdai63ZW/ATmaKsk62ZDwalGebITx1AR7USKaZJuCkrbYdmxoqcIBL" +
       "stkhPD8ZT1CvgbVWVWFLtheNykyTjCqkmOsu5GiJXcb0lo5FUA8caBu6gcCK" +
       "2Eql0GgzwnqabaVJ7DaoHq/Lk3BW6wxDDsIRpa4IUG9Rg/XxZD1l/U4kt/sE" +
       "pKKsiW576sJjYn7qNPwUxp0xPDVrIh9U0FCETABFPFFjVlIitpCNSaGLxFQj" +
       "fFUXOLbSgi2bUBZlOcOo8UoJehunGrXSUO53qDJGG4TvLbumS+FdcUxazbAC" +
       "Dp0V1ozn0XCwaBH0pKMriKctZyxj6i1eoXujwHFHTo+haFuMBoLlMDzbShML" +
       "wztQyppCk7GWBEG8//152OzLby+cd38RuTy6IWs7WF7xT99GxC47Ebw+CgcX" +
       "P5dLZ25VnggHnwo7x1HpsYsuvhYf1j/z0Vde1YXPInsHMeoPJaW7Ez94r2Os" +
       "DOfEUHcU+b9z+prb+8DTOCCjcTYqfczo+Z+X35OdF5A/c9/qmfOi0jN1x8TB" +
       "t5hinDdvEY3/T3ny+2BFig+wJ7ueG1dd+ZZ+vED/7vQC3Xu0QEc0PnDiy9zK" +
       "iCJLN26xpjffjDoj2QfzwqfB0zyQbPOHItnH/Wi+rwaqtjD2Z5rhnLh9Q/q6" +
       "UQzxR7cQ6p/myX9PSlfjhZ86+qgQLeiYF3/wWHz/40Lx5cVf/38RVKGCT4CH" +
       "ORAU8wMVVP76P/MGl/YuFsOl2/PCP0tKdxS6lb/8l2Pmv/tDZv4Z8PQPmO//" +
       "wJm3Cwav3oL5+/PkCvAYsboWAu1g9Y8FcOmeH54A3pkXPp5XHwhg/XYF0D5X" +
       "AHvHH81eLpKC03ffQgqP58nDSelKLoB2mKo7v3lsBJce+V6fZU5dlExKD51/" +
       "2zu/uvrITf9ssvsHCe3zr1696+FXh/9298H+8J8Y7mZLd5mp45y8QXgifzmI" +
       "DNMq5HD37j5hULD0bFJ69OLL6Enp8i6T037p+q7Le5LSg+d0ScD8B9mTrSEg" +
       "ruPWSWlPO1W9n5TuPKhOSreB9GQlAopAZZ6tBIfu7IVzN4rcr+0Us7i21Cqo" +
       "9qPs0ulN8shgH/heC3ViX33mwis6XLr7Z6Eb2uuvdvmf+Hb9s7vb3MDDbrf5" +
       "KHexpTt3F8uPPpU/deFoh2Nd7jz3nft+5e5nD3fq+3YEH2v5CdqeOP/qdHHp" +
       "LL/Ysv3HD/+j9/3Sq18tPln+Xz6Orn/DNQAA");
}
