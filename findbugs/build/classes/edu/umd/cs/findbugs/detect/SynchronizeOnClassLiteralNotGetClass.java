package edu.umd.cs.findbugs.detect;
public class SynchronizeOnClassLiteralNotGetClass extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public SynchronizeOnClassLiteralNotGetClass(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) { boolean interesting =
                                                               !getMethod(
                                                                  ).
                                                               isStatic(
                                                                 ) &&
                                                               !getThisClass(
                                                                  ).
                                                               isFinal(
                                                                 );
                                                             if (interesting) {
                                                                 pendingBug =
                                                                   null;
                                                                 super.
                                                                   visit(
                                                                     code);
                                                                 assert pendingBug ==
                                                                   null;
                                                             }
    }
    int state = 0;
    boolean seenPutStatic;
    boolean seenGetStatic;
    edu.umd.cs.findbugs.BugInstance pendingBug;
    @java.lang.Override
    public void sawOpcode(int seen) { if (pendingBug !=
                                            null) {
                                          if (seen ==
                                                PUTSTATIC) {
                                              java.lang.String classConstantOperand =
                                                getClassConstantOperand(
                                                  );
                                              java.lang.String thisClassName =
                                                getThisClass(
                                                  ).
                                                getClassName(
                                                  ).
                                                replace(
                                                  '.',
                                                  '/');
                                              if (classConstantOperand.
                                                    equals(
                                                      thisClassName)) {
                                                  seenPutStatic =
                                                    true;
                                              }
                                          }
                                          else
                                              if (seen ==
                                                    GETSTATIC) {
                                                  java.lang.String classConstantOperand =
                                                    getClassConstantOperand(
                                                      );
                                                  java.lang.String thisClassName =
                                                    getThisClass(
                                                      ).
                                                    getClassName(
                                                      ).
                                                    replace(
                                                      '.',
                                                      '/');
                                                  if (classConstantOperand.
                                                        equals(
                                                          thisClassName)) {
                                                      seenGetStatic =
                                                        true;
                                                  }
                                              }
                                              else
                                                  if (seen ==
                                                        MONITOREXIT) {
                                                      int priority =
                                                        LOW_PRIORITY;
                                                      if (seenPutStatic ||
                                                            seenGetStatic) {
                                                          priority--;
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
                                                              for (edu.umd.cs.findbugs.classfile.ClassDescriptor sub
                                                                    :
                                                                    directSubtypes) {
                                                                  pendingBug.
                                                                    addClass(
                                                                      sub).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.ClassAnnotation.
                                                                        SUBCLASS_ROLE);
                                                              }
                                                              priority--;
                                                          }
                                                      }
                                                      catch (java.lang.ClassNotFoundException e) {
                                                          bugReporter.
                                                            reportMissingClass(
                                                              e);
                                                      }
                                                      pendingBug.
                                                        setPriority(
                                                          priority);
                                                      bugReporter.
                                                        reportBug(
                                                          pendingBug);
                                                      pendingBug =
                                                        null;
                                                  }
                                          return;
                                      }
                                      switch (state) {
                                          case 0:
                                              if (seen ==
                                                    ALOAD_0) {
                                                  state =
                                                    1;
                                              }
                                              break;
                                          case 1:
                                              if (seen ==
                                                    INVOKEVIRTUAL &&
                                                    "getClass".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    "()Ljava/lang/Class;".
                                                    equals(
                                                      getSigConstantOperand(
                                                        ))) {
                                                  state =
                                                    2;
                                              }
                                              else {
                                                  state =
                                                    0;
                                              }
                                              break;
                                          case 2:
                                              if (seen ==
                                                    DUP) {
                                                  state =
                                                    3;
                                              }
                                              else {
                                                  state =
                                                    0;
                                              }
                                              break;
                                          case 3:
                                              if (isRegisterStore(
                                                    )) {
                                                  state =
                                                    4;
                                              }
                                              else {
                                                  state =
                                                    0;
                                              }
                                              break;
                                          case 4:
                                              if (seen ==
                                                    MONITORENTER) {
                                                  pendingBug =
                                                    new edu.umd.cs.findbugs.BugInstance(
                                                      this,
                                                      "WL_USING_GETCLASS_RATHER_THAN_CLASS_LITERAL",
                                                      NORMAL_PRIORITY).
                                                      addClassAndMethod(
                                                        this).
                                                      addSourceLine(
                                                        this);
                                              }
                                              state =
                                                0;
                                              seenGetStatic =
                                                (seenPutStatic =
                                                   false);
                                              break;
                                          default:
                                              break;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bLj8X3Rx6xIjHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zyYAAA==");
}
