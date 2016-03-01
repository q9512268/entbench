package edu.umd.cs.findbugs.detect;
public class IntCast2LongAsInstant extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    final edu.umd.cs.findbugs.BugReporter bugReporter;
    int lastConstantForSIPUSH;
    edu.umd.cs.findbugs.detect.TrainLongInstantfParams.LongInstantParameterDatabase
      database =
      new edu.umd.cs.findbugs.detect.TrainLongInstantfParams.LongInstantParameterDatabase(
      );
    public IntCast2LongAsInstant(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          <edu.umd.cs.findbugs.detect.TrainLongInstantfParams.LongInstantParameterDatabase,
        edu.umd.cs.findbugs.classfile.MethodDescriptor,
        edu.umd.cs.findbugs.ba.interproc.ParameterProperty>
        loadPropertyDatabaseFromResource(
          database,
          "longInstant.db",
          "long instant database");
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            SIPUSH) {
                                          lastConstantForSIPUSH =
                                            getIntConstant(
                                              );
                                      }
                                      if (seen ==
                                            INVOKEINTERFACE ||
                                            seen ==
                                            INVOKEVIRTUAL ||
                                            seen ==
                                            INVOKESPECIAL ||
                                            seen ==
                                            INVOKESTATIC) {
                                          java.lang.String signature =
                                            getSigConstantOperand(
                                              );
                                          int numberArguments =
                                            edu.umd.cs.findbugs.visitclass.PreorderVisitor.
                                            getNumberArguments(
                                              signature);
                                          for (int i =
                                                 0;
                                               i <
                                                 numberArguments;
                                               i++) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                stack.
                                                getStackItem(
                                                  numberArguments -
                                                    1 -
                                                    i);
                                              if (item.
                                                    getSpecialKind(
                                                      ) ==
                                                    edu.umd.cs.findbugs.OpcodeStack.Item.
                                                      RESULT_OF_I2L) {
                                                  edu.umd.cs.findbugs.ba.interproc.ParameterProperty property =
                                                    database.
                                                    getProperty(
                                                      getMethodDescriptorOperand(
                                                        ));
                                                  if (property !=
                                                        null &&
                                                        property.
                                                        hasProperty(
                                                          i)) {
                                                      int priority =
                                                        NORMAL_PRIORITY;
                                                      if (getPrevOpcode(
                                                            1) ==
                                                            I2L &&
                                                            getPrevOpcode(
                                                              2) ==
                                                            IMUL &&
                                                            getPrevOpcode(
                                                              3) ==
                                                            SIPUSH &&
                                                            lastConstantForSIPUSH ==
                                                            1000) {
                                                          priority =
                                                            HIGH_PRIORITY;
                                                      }
                                                      else
                                                          if (getPrevOpcode(
                                                                1) ==
                                                                I2L &&
                                                                getPrevOpcode(
                                                                  2) ==
                                                                IMUL &&
                                                                getPrevOpcode(
                                                                  4) ==
                                                                SIPUSH &&
                                                                lastConstantForSIPUSH ==
                                                                1000) {
                                                              priority =
                                                                HIGH_PRIORITY;
                                                          }
                                                      edu.umd.cs.findbugs.BugInstance bug =
                                                        new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "ICAST_INT_2_LONG_AS_INSTANT",
                                                        priority).
                                                        addClassAndMethod(
                                                          this).
                                                        addCalledMethod(
                                                          this).
                                                        addValueSource(
                                                          item,
                                                          this).
                                                        addSourceLine(
                                                          this);
                                                      bugReporter.
                                                        reportBug(
                                                          bug);
                                                  }
                                              }
                                          }
                                      } }
    @java.lang.Override
    public void report() {  }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        classContext.
          getJavaClass(
            ).
          accept(
            this);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/OkcHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d/0H9/zeU7/zwjezM+3/BZgi69WVJgAA");
}
