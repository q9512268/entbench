package edu.umd.cs.findbugs.detect;
public class CloneIdiom extends edu.umd.cs.findbugs.visitclass.DismantleBytecode implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor cloneDescriptor =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.lang.Cloneable.class);
    boolean isCloneable;
    boolean hasCloneMethod;
    boolean cloneIsDeprecated;
    edu.umd.cs.findbugs.MethodAnnotation cloneMethodAnnotation;
    boolean referencesCloneMethod;
    boolean invokesSuperClone;
    boolean isFinal;
    boolean cloneOnlyThrowsException;
    boolean check;
    boolean implementsCloneableDirectly;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public CloneIdiom(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        classContext.
          getJavaClass(
            ).
          accept(
            this);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if ("clone".
              equals(
                getMethodName(
                  )) &&
              getMethodSig(
                ).
              startsWith(
                "()")) {
            super.
              visit(
                obj);
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKESPECIAL &&
                                            "clone".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            getSigConstantOperand(
                                              ).
                                            startsWith(
                                              "()")) { invokesSuperClone =
                                                         true;
                                      } }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        implementsCloneableDirectly =
          false;
        invokesSuperClone =
          false;
        cloneOnlyThrowsException =
          false;
        isCloneable =
          false;
        check =
          false;
        isFinal =
          obj.
            isFinal(
              );
        if (obj.
              isInterface(
                )) {
            return;
        }
        if (obj.
              isAbstract(
                )) {
            return;
        }
        java.lang.String[] interface_names =
          obj.
          getInterfaceNames(
            );
        for (java.lang.String interface_name
              :
              interface_names) {
            if ("java.lang.Cloneable".
                  equals(
                    interface_name)) {
                implementsCloneableDirectly =
                  true;
                isCloneable =
                  true;
                break;
            }
        }
        edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getSubtypes2(
            );
        try {
            if (subtypes2.
                  isSubtype(
                    getClassDescriptor(
                      ),
                    cloneDescriptor)) {
                isCloneable =
                  true;
            }
            if (subtypes2.
                  isSubtype(
                    edu.umd.cs.findbugs.classfile.DescriptorFactory.
                      createClassDescriptorFromDottedClassName(
                        obj.
                          getSuperclassName(
                            )),
                    cloneDescriptor)) {
                implementsCloneableDirectly =
                  false;
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            bugReporter.
              reportMissingClass(
                e);
        }
        hasCloneMethod =
          false;
        referencesCloneMethod =
          false;
        check =
          true;
        super.
          visit(
            obj);
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        if (!check) {
            return;
        }
        if (cloneOnlyThrowsException) {
            return;
        }
        if (implementsCloneableDirectly &&
              !hasCloneMethod) {
            if (!referencesCloneMethod) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "CN_IDIOM",
                      NORMAL_PRIORITY).
                      addClass(
                        this));
            }
        }
        if (hasCloneMethod &&
              isCloneable &&
              !invokesSuperClone &&
              !isFinal &&
              obj.
              isPublic(
                )) {
            int priority =
              LOW_PRIORITY;
            if (obj.
                  isPublic(
                    ) ||
                  obj.
                  isProtected(
                    )) {
                priority =
                  NORMAL_PRIORITY;
            }
            try {
                edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getSubtypes2(
                    );
                java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> directSubtypes =
                  subtypes2.
                  getDirectSubtypes(
                    getClassDescriptor(
                      ));
                if (!directSubtypes.
                      isEmpty(
                        )) {
                    priority--;
                }
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "CN_IDIOM_NO_SUPER_CALL",
                  priority).
                  addClass(
                    this).
                  addMethod(
                    cloneMethodAnnotation);
                for (edu.umd.cs.findbugs.classfile.ClassDescriptor d
                      :
                      directSubtypes) {
                    bug.
                      addClass(
                        d).
                      describe(
                        edu.umd.cs.findbugs.ClassAnnotation.
                          SUBCLASS_ROLE);
                }
                bugReporter.
                  reportBug(
                    bug);
            }
            catch (java.lang.ClassNotFoundException e) {
                bugReporter.
                  reportMissingClass(
                    e);
            }
        }
        else
            if (hasCloneMethod &&
                  !isCloneable &&
                  !cloneOnlyThrowsException &&
                  !cloneIsDeprecated &&
                  !obj.
                  isAbstract(
                    )) {
                int priority =
                  edu.umd.cs.findbugs.Priorities.
                    NORMAL_PRIORITY;
                if (referencesCloneMethod) {
                    priority--;
                }
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "CN_IMPLEMENTS_CLONE_BUT_NOT_CLONEABLE",
                      priority).
                      addClass(
                        this).
                      addMethod(
                        cloneMethodAnnotation));
            }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.ConstantNameAndType obj) {
        java.lang.String methodName =
          obj.
          getName(
            getConstantPool(
              ));
        java.lang.String methodSig =
          obj.
          getSignature(
            getConstantPool(
              ));
        if (!"clone".
              equals(
                methodName)) {
            return;
        }
        if (!methodSig.
              startsWith(
                "()")) {
            return;
        }
        referencesCloneMethod =
          true;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (obj.
              isAbstract(
                ) ||
              edu.umd.cs.findbugs.bcel.BCELUtil.
              isSynthetic(
                obj)) {
            return;
        }
        if (!obj.
              isPublic(
                )) {
            return;
        }
        if (!"clone".
              equals(
                getMethodName(
                  ))) {
            return;
        }
        if (!getMethodSig(
               ).
              startsWith(
                "()")) {
            return;
        }
        hasCloneMethod =
          true;
        cloneIsDeprecated =
          getXMethod(
            ).
            isDeprecated(
              );
        cloneMethodAnnotation =
          edu.umd.cs.findbugs.MethodAnnotation.
            fromVisitedMethod(
              this);
        cloneOnlyThrowsException =
          edu.umd.cs.findbugs.ba.PruneUnconditionalExceptionThrowerEdges.
            doesMethodUnconditionallyThrowException(
              edu.umd.cs.findbugs.ba.XFactory.
                createXMethod(
                  this));
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "skqDm7NaPFFGPea+BQ02ZP8XKyHxB3spAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b85K9hmQJoeSndwRyT7thesD2ZcVQztY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KZp9+tjcU7WSxB/cQqjfLLLfiyv3lEItfvznE6H9t0uFVhR//a8snhcq+0t+" +
       "laPv76x4zmnEXaa7V7I/vYU8/qzI/hg4hEhOWV8BIjwnk/95h2VyAyTlUCbK" +
       "nTHGy1VmCEygNKyCzpX7LpfTlQeL7K6L9ebK3XdYRi+B9OlDGX36OyqjAv39" +
       "JYNP3IL57yqyR+PKAyXzmH54pnVKAo/dYQkU9V8+lMCX74iWfOBWjmV/nWkM" +
       "lhnMVYu1pRTLjVuIrIg/rjxzib48e4el9RxIXzmU1lfuiLSevVxa++W5FEL9" +
       "FgIqgq8rB5cICL7DAnoSpG8cCugb3xkBneate4u6XpF9MK7cG5anw+cYf+07" +
       "yPgOGOzJFenivueTN/37Yv+PAeXn3rp+3xNvCf+hvCV8fKv/fqZyn57Y9ulr" +
       "d6ee7/VDTTdLYdy/v4TnlxwyceWpy29tA873DwXeK/S+CxtXHrugSwzGP3w8" +
       "3XoKGDtpHVeuKmeqhbhy7bAaLIIgP10JYt+7QGXxCPZeh9qMXAS31MtSrQ96" +
       "ZuQA+7e1bgaQF2HGlVNh86GKlavlo7c7Pz7ucvoachFql/+fOQqLk/0/aF5X" +
       "vvTWcPzRbzW/sL8GDdDkeUHlPqZybX8j+zi0fu5Sake07h289O2Hfv7+F4+2" +
       "AQ/tAZ+o+ylsz1x855hw/Li8JZz/yyf++av/+K3fLY/s/z/WhXE12DQAAA==");
}
