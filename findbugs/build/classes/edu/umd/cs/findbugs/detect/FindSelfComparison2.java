package edu.umd.cs.findbugs.detect;
import static org.apache.bcel.Constants.*;
public class FindSelfComparison2 implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public FindSelfComparison2(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.Method[] methodList =
          classContext.
          getJavaClass(
            ).
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  getCode(
                    ) ==
                  null) {
                continue;
            }
            try {
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.MethodUnprofitableException mue) {
                if (edu.umd.cs.findbugs.SystemProperties.
                      getBoolean(
                        "unprofitable.debug")) {
                    bugReporter.
                      logError(
                        "skipping unprofitable method in " +
                        getClass(
                          ).
                          getName(
                            ));
                }
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Detector " +
                    this.
                      getClass(
                        ).
                      getName(
                        ) +
                    " caught exception",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Detector " +
                    this.
                      getClass(
                        ).
                      getName(
                        ) +
                    " caught exception",
                    e);
            }
        }
    }
    static boolean booleanComparisonMethod(java.lang.String methodName) {
        return "equals".
          equals(
            methodName) ||
          "endsWith".
          equals(
            methodName) ||
          "startsWith".
          equals(
            methodName) ||
          "contains".
          equals(
            methodName) ||
          "equalsIgnoreCase".
          equals(
            methodName);
    }
    static boolean comparatorMethod(java.lang.String methodName) {
        return "compareTo".
          equals(
            methodName) ||
          "compareToIgnoreCase".
          equals(
            methodName);
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException { edu.umd.cs.findbugs.ba.CFG cfg =
                                                             classContext.
                                                             getCFG(
                                                               method);
                                                           edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow valueNumberDataflow =
                                                             classContext.
                                                             getValueNumberDataflow(
                                                               method);
                                                           org.apache.bcel.generic.ConstantPoolGen cpg =
                                                             classContext.
                                                             getConstantPoolGen(
                                                               );
                                                           org.apache.bcel.generic.MethodGen methodGen =
                                                             classContext.
                                                             getMethodGen(
                                                               method);
                                                           java.lang.String sourceFile =
                                                             classContext.
                                                             getJavaClass(
                                                               ).
                                                             getSourceFileName(
                                                               );
                                                           for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
                                                                  cfg.
                                                                  locationIterator(
                                                                    );
                                                                i.
                                                                  hasNext(
                                                                    );
                                                                ) {
                                                               edu.umd.cs.findbugs.ba.Location location =
                                                                 i.
                                                                 next(
                                                                   );
                                                               org.apache.bcel.generic.Instruction ins =
                                                                 location.
                                                                 getHandle(
                                                                   ).
                                                                 getInstruction(
                                                                   );
                                                               switch (ins.
                                                                         getOpcode(
                                                                           )) {
                                                                   case INVOKEVIRTUAL:
                                                                   case INVOKEINTERFACE:
                                                                       org.apache.bcel.generic.InvokeInstruction iins =
                                                                         (org.apache.bcel.generic.InvokeInstruction)
                                                                           ins;
                                                                       java.lang.String invoking =
                                                                         iins.
                                                                         getName(
                                                                           cpg);
                                                                       if (comparatorMethod(
                                                                             invoking) ||
                                                                             booleanComparisonMethod(
                                                                               invoking)) {
                                                                           if (methodGen.
                                                                                 getName(
                                                                                   ).
                                                                                 toLowerCase(
                                                                                   ).
                                                                                 indexOf(
                                                                                   "test") >=
                                                                                 0) {
                                                                               break;
                                                                           }
                                                                           if (methodGen.
                                                                                 getClassName(
                                                                                   ).
                                                                                 toLowerCase(
                                                                                   ).
                                                                                 indexOf(
                                                                                   "test") >=
                                                                                 0) {
                                                                               break;
                                                                           }
                                                                           if (classContext.
                                                                                 getJavaClass(
                                                                                   ).
                                                                                 getSuperclassName(
                                                                                   ).
                                                                                 toLowerCase(
                                                                                   ).
                                                                                 indexOf(
                                                                                   "test") >=
                                                                                 0) {
                                                                               break;
                                                                           }
                                                                           if (location.
                                                                                 getHandle(
                                                                                   ).
                                                                                 getNext(
                                                                                   ).
                                                                                 getInstruction(
                                                                                   ).
                                                                                 getOpcode(
                                                                                   ) ==
                                                                                 POP) {
                                                                               break;
                                                                           }
                                                                           java.lang.String sig =
                                                                             iins.
                                                                             getSignature(
                                                                               cpg);
                                                                           edu.umd.cs.findbugs.ba.SignatureParser parser =
                                                                             new edu.umd.cs.findbugs.ba.SignatureParser(
                                                                             sig);
                                                                           if (parser.
                                                                                 getNumParameters(
                                                                                   ) ==
                                                                                 1 &&
                                                                                 (booleanComparisonMethod(
                                                                                    invoking) &&
                                                                                    sig.
                                                                                    endsWith(
                                                                                      ";)Z") ||
                                                                                    comparatorMethod(
                                                                                      invoking) &&
                                                                                    sig.
                                                                                    endsWith(
                                                                                      ";)I"))) {
                                                                               checkForSelfOperation(
                                                                                 classContext,
                                                                                 location,
                                                                                 valueNumberDataflow,
                                                                                 "COMPARISON",
                                                                                 method,
                                                                                 methodGen,
                                                                                 sourceFile);
                                                                           }
                                                                       }
                                                                       break;
                                                                   case LOR:
                                                                   case LAND:
                                                                   case LXOR:
                                                                   case LSUB:
                                                                   case IOR:
                                                                   case IAND:
                                                                   case IXOR:
                                                                   case ISUB:
                                                                       checkForSelfOperation(
                                                                         classContext,
                                                                         location,
                                                                         valueNumberDataflow,
                                                                         "COMPUTATION",
                                                                         method,
                                                                         methodGen,
                                                                         sourceFile);
                                                                       break;
                                                                   case FCMPG:
                                                                   case DCMPG:
                                                                   case DCMPL:
                                                                   case FCMPL:
                                                                       break;
                                                                   case LCMP:
                                                                   case IF_ACMPEQ:
                                                                   case IF_ACMPNE:
                                                                   case IF_ICMPNE:
                                                                   case IF_ICMPEQ:
                                                                   case IF_ICMPGT:
                                                                   case IF_ICMPLE:
                                                                   case IF_ICMPLT:
                                                                   case IF_ICMPGE:
                                                                       checkForSelfOperation(
                                                                         classContext,
                                                                         location,
                                                                         valueNumberDataflow,
                                                                         "COMPARISON",
                                                                         method,
                                                                         methodGen,
                                                                         sourceFile);
                                                                       break;
                                                                   default:
                                                                       break;
                                                               }
                                                           }
    }
    private void checkForSelfOperation(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                       edu.umd.cs.findbugs.ba.Location location,
                                       edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow valueNumberDataflow,
                                       java.lang.String op,
                                       org.apache.bcel.classfile.Method method,
                                       org.apache.bcel.generic.MethodGen methodGen,
                                       java.lang.String sourceFile)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame frame =
          valueNumberDataflow.
          getFactAtLocation(
            location);
        if (!frame.
              isValid(
                )) {
            return;
        }
        org.apache.bcel.generic.Instruction ins =
          location.
          getHandle(
            ).
          getInstruction(
            );
        int opcode =
          ins.
          getOpcode(
            );
        int offset =
          1;
        if (opcode ==
              LCMP ||
              opcode ==
              LXOR ||
              opcode ==
              LAND ||
              opcode ==
              LOR ||
              opcode ==
              LSUB) {
            offset =
              2;
        }
        edu.umd.cs.findbugs.ba.vna.ValueNumber v0 =
          frame.
          getStackValue(
            0);
        edu.umd.cs.findbugs.ba.vna.ValueNumber v1 =
          frame.
          getStackValue(
            offset);
        if (!v1.
              equals(
                v0)) {
            return;
        }
        if (v0.
              hasFlag(
                edu.umd.cs.findbugs.ba.vna.ValueNumber.
                  CONSTANT_CLASS_OBJECT) ||
              v0.
              hasFlag(
                edu.umd.cs.findbugs.ba.vna.ValueNumber.
                  CONSTANT_VALUE)) {
            return;
        }
        int priority =
          HIGH_PRIORITY;
        if (opcode ==
              ISUB ||
              opcode ==
              LSUB ||
              opcode ==
              INVOKEINTERFACE ||
              opcode ==
              INVOKEVIRTUAL) {
            priority =
              NORMAL_PRIORITY;
        }
        edu.umd.cs.findbugs.ba.XField field =
          edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findXFieldFromValueNumber(
            method,
            location,
            v0,
            frame);
        edu.umd.cs.findbugs.BugAnnotation annotation;
        java.lang.String prefix;
        if (field !=
              null) {
            if (field.
                  isVolatile(
                    )) {
                return;
            }
            if (true) {
                return;
            }
        }
        else {
            annotation =
              edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                findLocalAnnotationFromValueNumber(
                  method,
                  location,
                  v0,
                  frame);
            prefix =
              "SA_LOCAL_SELF_";
            if (opcode ==
                  ISUB) {
                return;
            }
        }
        if (annotation ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.SourceLineAnnotation sourceLine =
          edu.umd.cs.findbugs.SourceLineAnnotation.
          fromVisitedInstruction(
            classContext,
            methodGen,
            sourceFile,
            location.
              getHandle(
                ));
        int line =
          sourceLine.
          getStartLine(
            );
        java.util.BitSet occursMultipleTimes =
          classContext.
          linesMentionedMultipleTimes(
            method);
        if (line >
              0 &&
              occursMultipleTimes.
              get(
                line)) {
            return;
        }
        edu.umd.cs.findbugs.BugInstance bug =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          prefix +
          op,
          priority).
          addClassAndMethod(
            methodGen,
            sourceFile);
        if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
            bug.
              addCalledMethod(
                classContext.
                  getConstantPoolGen(
                    ),
                (org.apache.bcel.generic.InvokeInstruction)
                  ins);
        }
        bug.
          add(
            annotation).
          addSourceLine(
            classContext,
            methodGen,
            sourceFile,
            location.
              getHandle(
                ));
        bugReporter.
          reportBug(
            bug);
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8c4K4o9FF5oE+TfRHQYQ9R4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
