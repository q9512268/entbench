package edu.umd.cs.findbugs.detect;
public class ExplicitSerialization extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.NonReportingDetector {
    static final edu.umd.cs.findbugs.ba.XMethod writeObject = edu.umd.cs.findbugs.ba.XFactory.
      createXMethod(
        "java.io.ObjectOutputStream",
        "writeObject",
        "(Ljava/lang/Object;)V",
        false);
    static final edu.umd.cs.findbugs.ba.XMethod readObject = edu.umd.cs.findbugs.ba.XFactory.
      createXMethod(
        "java.io.ObjectInputStream",
        "readObject",
        "()Ljava/lang/Object;",
        false);
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      ObjectOutputStream =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.io.ObjectOutputStream.class);
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      ObjectInputStream =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.io.ObjectInputStream.class);
    final edu.umd.cs.findbugs.detect.UnreadFieldsData unreadFields;
    final edu.umd.cs.findbugs.BugReporter bugReporter;
    public ExplicitSerialization(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        edu.umd.cs.findbugs.ba.AnalysisContext context =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            );
        unreadFields =
          context.
            getUnreadFieldsData(
              );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public boolean shouldVisit(org.apache.bcel.classfile.JavaClass obj) {
        edu.umd.cs.findbugs.ba.XClass xClass =
          getXClass(
            );
        return xClass.
          getCalledClassDescriptors(
            ).
          contains(
            ObjectOutputStream) ||
          xClass.
          getCalledClassDescriptors(
            ).
          contains(
            ObjectInputStream);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKEVIRTUAL &&
                                            writeObject.
                                            equals(
                                              getXMethodOperand(
                                                ))) { edu.umd.cs.findbugs.OpcodeStack.Item top =
                                                        stack.
                                                        getStackItem(
                                                          0);
                                                      java.lang.String signature =
                                                        top.
                                                        getSignature(
                                                          );
                                                      while (signature.
                                                               charAt(
                                                                 0) ==
                                                               '[') {
                                                          signature =
                                                            signature.
                                                              substring(
                                                                1);
                                                      }
                                                      edu.umd.cs.findbugs.classfile.ClassDescriptor c =
                                                        edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                        createClassDescriptorFromFieldSignature(
                                                          signature);
                                                      if (c ==
                                                            null ||
                                                            !edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                            instanceOf(
                                                              c,
                                                              java.io.Serializable.class)) {
                                                          return;
                                                      }
                                                      try {
                                                          edu.umd.cs.findbugs.ba.XClass xClass =
                                                            edu.umd.cs.findbugs.classfile.Global.
                                                            getAnalysisCache(
                                                              ).
                                                            getClassAnalysis(
                                                              edu.umd.cs.findbugs.ba.XClass.class,
                                                              c);
                                                          if (xClass.
                                                                isInterface(
                                                                  )) {
                                                              return;
                                                          }
                                                          if (xClass.
                                                                isSynthetic(
                                                                  )) {
                                                              return;
                                                          }
                                                          if (xClass.
                                                                isAbstract(
                                                                  )) {
                                                              return;
                                                          }
                                                          unreadFields.
                                                            strongEvidenceForIntendedSerialization(
                                                              c);
                                                      }
                                                      catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                          bugReporter.
                                                            logError(
                                                              "Error looking up xClass of " +
                                                              c,
                                                              e);
                                                      }
                                      }
                                      if (seen ==
                                            CHECKCAST) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                            stack.
                                            getStackItem(
                                              0);
                                          if (readObject.
                                                equals(
                                                  top.
                                                    getReturnValueOf(
                                                      ))) {
                                              edu.umd.cs.findbugs.classfile.ClassDescriptor c =
                                                getClassDescriptorOperand(
                                                  );
                                              if (!edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                    instanceOf(
                                                      c,
                                                      java.io.Serializable.class)) {
                                                  return;
                                              }
                                              try {
                                                  edu.umd.cs.findbugs.ba.XClass xClass =
                                                    edu.umd.cs.findbugs.classfile.Global.
                                                    getAnalysisCache(
                                                      ).
                                                    getClassAnalysis(
                                                      edu.umd.cs.findbugs.ba.XClass.class,
                                                      c);
                                                  if (xClass.
                                                        isInterface(
                                                          )) {
                                                      return;
                                                  }
                                                  if (xClass.
                                                        isSynthetic(
                                                          )) {
                                                      return;
                                                  }
                                                  if (xClass.
                                                        isAbstract(
                                                          )) {
                                                      return;
                                                  }
                                                  unreadFields.
                                                    strongEvidenceForIntendedSerialization(
                                                      c);
                                              }
                                              catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                  bugReporter.
                                                    logError(
                                                      "Error looking up xClass of " +
                                                      c,
                                                      e);
                                              }
                                          }
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
      ("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");
}
