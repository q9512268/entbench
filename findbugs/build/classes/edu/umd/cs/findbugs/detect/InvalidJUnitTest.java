package edu.umd.cs.findbugs.detect;
public class InvalidJUnitTest extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private static final int SEEN_NOTHING = 0;
    private static final int SEEN_ALOAD_0 = 1;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private int state;
    public InvalidJUnitTest(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    boolean directChildOfTestCase;
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (!enabled(
               )) {
            return;
        }
        org.apache.bcel.classfile.JavaClass jClass =
          classContext.
          getJavaClass(
            );
        edu.umd.cs.findbugs.ba.XClass xClass =
          classContext.
          getXClass(
            );
        try {
            if (!isJunit3TestCase(
                   xClass)) {
                return;
            }
            if ((jClass.
                   getAccessFlags(
                     ) &
                   ACC_ABSTRACT) ==
                  0) {
                if (!hasTestMethods(
                       jClass)) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "IJU_NO_TESTS",
                          LOW_PRIORITY).
                          addClass(
                            jClass));
                }
            }
            directChildOfTestCase =
              "junit.framework.TestCase".
                equals(
                  jClass.
                    getSuperclassName(
                      ));
            jClass.
              accept(
                this);
        }
        catch (java.lang.ClassNotFoundException cnfe) {
            bugReporter.
              reportMissingClass(
                cnfe);
        }
    }
    private boolean isJunit3TestCase(edu.umd.cs.findbugs.ba.XClass jClass)
          throws java.lang.ClassNotFoundException { edu.umd.cs.findbugs.classfile.ClassDescriptor sDesc =
                                                      jClass.
                                                      getSuperclassDescriptor(
                                                        );
                                                    if (sDesc ==
                                                          null) {
                                                        return false;
                                                    }
                                                    java.lang.String sName =
                                                      sDesc.
                                                      getClassName(
                                                        );
                                                    if (sName.
                                                          equals(
                                                            "junit/framework/TestCase")) {
                                                        return true;
                                                    }
                                                    if (sName.
                                                          equals(
                                                            "java/lang/Object")) {
                                                        return false;
                                                    }
                                                    try {
                                                        edu.umd.cs.findbugs.ba.XClass sClass =
                                                          edu.umd.cs.findbugs.classfile.Global.
                                                          getAnalysisCache(
                                                            ).
                                                          getClassAnalysis(
                                                            edu.umd.cs.findbugs.ba.XClass.class,
                                                            sDesc);
                                                        if (sClass ==
                                                              null) {
                                                            return false;
                                                        }
                                                        return isJunit3TestCase(
                                                                 sClass);
                                                    }
                                                    catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                        return false;
                                                    }
    }
    private boolean hasTestMethods(org.apache.bcel.classfile.JavaClass jClass) {
        boolean foundTest =
          false;
        org.apache.bcel.classfile.Method[] methods =
          jClass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method m
              :
              methods) {
            if (m.
                  isPublic(
                    ) &&
                  m.
                  getName(
                    ).
                  startsWith(
                    "test") &&
                  m.
                  getSignature(
                    ).
                  equals(
                    "()V")) {
                return true;
            }
            if (m.
                  getName(
                    ).
                  startsWith(
                    "runTest") &&
                  m.
                  getSignature(
                    ).
                  endsWith(
                    "()V")) {
                return true;
            }
        }
        if (hasSuite(
              methods)) {
            return true;
        }
        try {
            org.apache.bcel.classfile.JavaClass sClass =
              jClass.
              getSuperClass(
                );
            if (sClass !=
                  null) {
                return hasTestMethods(
                         sClass);
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              reportMissingClass(
                e);
        }
        return false;
    }
    private boolean hasSuite(org.apache.bcel.classfile.Method[] methods) {
        for (org.apache.bcel.classfile.Method m
              :
              methods) {
            if (m.
                  getName(
                    ).
                  equals(
                    "suite") &&
                  m.
                  isPublic(
                    ) &&
                  m.
                  isStatic(
                    ) &&
                  m.
                  getSignature(
                    ).
                  equals(
                    "()Ljunit/framework/Test;")) {
                return true;
            }
        }
        return false;
    }
    private boolean enabled() { return true;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (getMethodName(
              ).
              equals(
                "suite") &&
              !obj.
              isStatic(
                )) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "IJU_SUITE_NOT_STATIC",
                  NORMAL_PRIORITY).
                  addClassAndMethod(
                    this));
        }
        if (getMethodName(
              ).
              equals(
                "suite") &&
              obj.
              getSignature(
                ).
              startsWith(
                "()") &&
              obj.
              isStatic(
                )) {
            if (!obj.
                  getSignature(
                    ).
                  equals(
                    "()Ljunit/framework/Test;") &&
                  !obj.
                  getSignature(
                    ).
                  equals(
                    "()Ljunit/framework/TestSuite;") ||
                  !obj.
                  isPublic(
                    )) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "IJU_BAD_SUITE_METHOD",
                      NORMAL_PRIORITY).
                      addClassAndMethod(
                        this));
            }
        }
    }
    private boolean sawSuperCall;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (!directChildOfTestCase &&
              (getMethodName(
                 ).
                 equals(
                   "setUp") ||
                 getMethodName(
                   ).
                 equals(
                   "tearDown")) &&
              !getMethod(
                 ).
              isPrivate(
                ) &&
              getMethodSig(
                ).
              equals(
                "()V")) {
            sawSuperCall =
              false;
            super.
              visit(
                obj);
            if (sawSuperCall) {
                return;
            }
            org.apache.bcel.classfile.JavaClass we =
              edu.umd.cs.findbugs.Lookup.
              findSuperImplementor(
                getThisClass(
                  ),
                getMethodName(
                  ),
                "()V",
                bugReporter);
            if (we !=
                  null &&
                  !we.
                  getClassName(
                    ).
                  equals(
                    "junit.framework.TestCase")) {
                int offset =
                  0;
                if (getMethodName(
                      ).
                      equals(
                        "tearDown")) {
                    offset =
                      obj.
                        getCode(
                          ).
                        length -
                        1;
                }
                org.apache.bcel.classfile.Method superMethod =
                  edu.umd.cs.findbugs.Lookup.
                  findImplementation(
                    we,
                    getMethodName(
                      ),
                    "()V");
                org.apache.bcel.classfile.Code superCode =
                  superMethod.
                  getCode(
                    );
                if (superCode !=
                      null &&
                      superCode.
                        getCode(
                          ).
                        length >
                      3) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          getMethodName(
                            ).
                            equals(
                              "setUp")
                            ? "IJU_SETUP_NO_SUPER"
                            : "IJU_TEARDOWN_NO_SUPER",
                          NORMAL_PRIORITY).
                          addClassAndMethod(
                            this).
                          addMethod(
                            we,
                            superMethod).
                          describe(
                            edu.umd.cs.findbugs.MethodAnnotation.
                              METHOD_OVERRIDDEN).
                          addSourceLine(
                            this,
                            offset));
                }
            }
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (state) {
                                          case SEEN_NOTHING:
                                              if (seen ==
                                                    ALOAD_0) {
                                                  state =
                                                    SEEN_ALOAD_0;
                                              }
                                              break;
                                          case SEEN_ALOAD_0:
                                              if (seen ==
                                                    INVOKESPECIAL &&
                                                    getNameConstantOperand(
                                                      ).
                                                    equals(
                                                      getMethodName(
                                                        )) &&
                                                    getSigConstantOperand(
                                                      ).
                                                    equals(
                                                      "()V")) {
                                                  sawSuperCall =
                                                    true;
                                              }
                                              state =
                                                SEEN_NOTHING;
                                              break;
                                          default:
                                              state =
                                                SEEN_NOTHING;
                                      } }
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
       "14tdjUhV3c/ttyDym3nxG1HpqhlSsWtG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9aOzieJV/4me/9mbvW1+M5Xlpyj2ocrsvxCVXfcC40D2wdOGfqCoun1QpB3m" +
       "2VQHFFDFieK+dRtj/HZefCMq3beUw1wVw5OUu1Pa+OY71caHwfXCoTZeeHe1" +
       "EZQ+emtsK1I0doezL/2j67/7qZeu/8cie+GSGQpygAXGObl8p8b84JXXv/d7" +
       "733kq0Um0J3KoZlc3k+CvDnH8UzqYsH+FT89ttRbL9wp9e+v+HP+0TnWd29z" +
       "WvnkmX3sblt3jV0WXXEq+J1DJnLaF3eDjph632n38Vw9T5E5atuliJnewXEi" +
       "KWhMz+Xyl/xi7u+c2v7OW7zTJvjfbtP2Rl78SVS6S8152olwm+7/I919//vb" +
       "9PlhXvxBVLoELJ6PzWjf8//wndp6nsD184e2/vPvjq2f4v9C6TZthQn8KMoz" +
       "L/Ml0vZE+7N3IFqxw+anrF86FO1Lb1e02+6w+c/XCxmu3Ea+PEfpwj3AHIqt" +
       "M+/x6rF0Fy7dcmvMq3/tnWyChfCPgetrh8J/7V0V/sjPHr01MOCeVpzCXvjQ" +
       "bdTzSF68/xbqefAvWD3XwfWtQ/V86123Da4Q8MnbCP90XlwHIXAobxhfBfra" +
       "U8CNd1EBKYgg9hNq8+zAD96Uvb/LOFe/+tL9lz7w0vQPdzvJUVb4vYPSpUVs" +
       "26eTtE7d3+0H+sIsVHPvLmWrQNcLtaj08K0zfQHs725yri9Ud0NggPDnDAEw" +
       "eHR7ujcalS6f9I5KF9Uzzc/mCLNrjkp3gPJ048dAFWjMb3/CP7LsZ87NfcwA" +
       "l2CdeBU8ZJiu0Sm49oL0wqmHl0NjK/Dr2pvh16lHp+tngoLivxdHDyfx7t8X" +
       "z6uvvkSNfuqN5pd3CbPA2bbbnMolsH/vcncP9+/TKVn71I5o3d1/6kf3/eq9" +
       "Hz16GLtvx/CJ4Z/i7bHzs1MJx4+KfNLtb3zg1577xy99p8iX+391PxioFDMA" +
       "AA==");
}
