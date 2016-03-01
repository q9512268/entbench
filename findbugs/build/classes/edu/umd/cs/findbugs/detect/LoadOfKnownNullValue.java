package edu.umd.cs.findbugs.detect;
public class LoadOfKnownNullValue implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public LoadOfKnownNullValue(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
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
            bugAccumulator.
              reportAccumulatedBugs(
                );
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException { java.util.BitSet lineMentionedMultipleTimes =
                                                             classContext.
                                                             linesMentionedMultipleTimes(
                                                               method);
                                                           java.util.BitSet linesWithLoadsOfNotDefinitelyNullValues =
                                                             null;
                                                           edu.umd.cs.findbugs.ba.CFG cfg =
                                                             classContext.
                                                             getCFG(
                                                               method);
                                                           edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow nullValueDataflow =
                                                             classContext.
                                                             getIsNullValueDataflow(
                                                               method);
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
                                                           if (lineMentionedMultipleTimes.
                                                                 cardinality(
                                                                   ) >
                                                                 0) {
                                                               linesWithLoadsOfNotDefinitelyNullValues =
                                                                 new java.util.BitSet(
                                                                   );
                                                               org.apache.bcel.classfile.LineNumberTable lineNumbers =
                                                                 method.
                                                                 getLineNumberTable(
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
                                                                   org.apache.bcel.generic.InstructionHandle handle =
                                                                     location.
                                                                     getHandle(
                                                                       );
                                                                   org.apache.bcel.generic.Instruction ins =
                                                                     handle.
                                                                     getInstruction(
                                                                       );
                                                                   if (!(ins instanceof org.apache.bcel.generic.ALOAD)) {
                                                                       continue;
                                                                   }
                                                                   edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
                                                                     nullValueDataflow.
                                                                     getFactAtLocation(
                                                                       location);
                                                                   if (!frame.
                                                                         isValid(
                                                                           )) {
                                                                       continue;
                                                                   }
                                                                   org.apache.bcel.generic.ALOAD load =
                                                                     (org.apache.bcel.generic.ALOAD)
                                                                       ins;
                                                                   int index =
                                                                     load.
                                                                     getIndex(
                                                                       );
                                                                   edu.umd.cs.findbugs.ba.npe.IsNullValue v =
                                                                     frame.
                                                                     getValue(
                                                                       index);
                                                                   if (!v.
                                                                         isDefinitelyNull(
                                                                           )) {
                                                                       int sourceLine =
                                                                         lineNumbers.
                                                                         getSourceLine(
                                                                           handle.
                                                                             getPosition(
                                                                               ));
                                                                       if (sourceLine >
                                                                             0) {
                                                                           linesWithLoadsOfNotDefinitelyNullValues.
                                                                             set(
                                                                               sourceLine);
                                                                       }
                                                                   }
                                                               }
                                                           }
                                                           java.util.IdentityHashMap<org.apache.bcel.generic.InstructionHandle,java.lang.Object> sometimesGood =
                                                             new java.util.IdentityHashMap<org.apache.bcel.generic.InstructionHandle,java.lang.Object>(
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
                                                               org.apache.bcel.generic.InstructionHandle handle =
                                                                 location.
                                                                 getHandle(
                                                                   );
                                                               org.apache.bcel.generic.Instruction ins =
                                                                 handle.
                                                                 getInstruction(
                                                                   );
                                                               if (!(ins instanceof org.apache.bcel.generic.ALOAD)) {
                                                                   continue;
                                                               }
                                                               edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
                                                                 nullValueDataflow.
                                                                 getFactAtLocation(
                                                                   location);
                                                               if (!frame.
                                                                     isValid(
                                                                       )) {
                                                                   continue;
                                                               }
                                                               org.apache.bcel.generic.ALOAD load =
                                                                 (org.apache.bcel.generic.ALOAD)
                                                                   ins;
                                                               int index =
                                                                 load.
                                                                 getIndex(
                                                                   );
                                                               edu.umd.cs.findbugs.ba.npe.IsNullValue v =
                                                                 frame.
                                                                 getValue(
                                                                   index);
                                                               if (!v.
                                                                     isDefinitelyNull(
                                                                       )) {
                                                                   sometimesGood.
                                                                     put(
                                                                       handle,
                                                                       null);
                                                               }
                                                           }
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
                                                               org.apache.bcel.generic.InstructionHandle handle =
                                                                 location.
                                                                 getHandle(
                                                                   );
                                                               org.apache.bcel.generic.Instruction ins =
                                                                 handle.
                                                                 getInstruction(
                                                                   );
                                                               if (!(ins instanceof org.apache.bcel.generic.ALOAD)) {
                                                                   continue;
                                                               }
                                                               if (sometimesGood.
                                                                     containsKey(
                                                                       handle)) {
                                                                   continue;
                                                               }
                                                               edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
                                                                 nullValueDataflow.
                                                                 getFactAtLocation(
                                                                   location);
                                                               if (!frame.
                                                                     isValid(
                                                                       )) {
                                                                   continue;
                                                               }
                                                               org.apache.bcel.generic.ALOAD load =
                                                                 (org.apache.bcel.generic.ALOAD)
                                                                   ins;
                                                               int index =
                                                                 load.
                                                                 getIndex(
                                                                   );
                                                               edu.umd.cs.findbugs.ba.npe.IsNullValue v =
                                                                 frame.
                                                                 getValue(
                                                                   index);
                                                               if (v.
                                                                     isDefinitelyNull(
                                                                       )) {
                                                                   org.apache.bcel.generic.InstructionHandle nextHandle =
                                                                     handle.
                                                                     getNext(
                                                                       );
                                                                   org.apache.bcel.generic.Instruction next =
                                                                     nextHandle.
                                                                     getInstruction(
                                                                       );
                                                                   int position =
                                                                     location.
                                                                     getHandle(
                                                                       ).
                                                                     getPosition(
                                                                       );
                                                                   int catchSizeANY =
                                                                     edu.umd.cs.findbugs.visitclass.Util.
                                                                     getSizeOfSurroundingTryBlock(
                                                                       method,
                                                                       "",
                                                                       position);
                                                                   if (catchSizeANY <
                                                                         java.lang.Integer.
                                                                           MAX_VALUE &&
                                                                         isNullTestedClose(
                                                                           classContext,
                                                                           load,
                                                                           nextHandle,
                                                                           next)) {
                                                                       continue;
                                                                   }
                                                                   org.apache.bcel.generic.InstructionHandle prevHandle =
                                                                     handle.
                                                                     getPrev(
                                                                       );
                                                                   edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                                                                     edu.umd.cs.findbugs.SourceLineAnnotation.
                                                                     fromVisitedInstruction(
                                                                       classContext,
                                                                       methodGen,
                                                                       sourceFile,
                                                                       handle);
                                                                   edu.umd.cs.findbugs.SourceLineAnnotation prevSourceLineAnnotation =
                                                                     edu.umd.cs.findbugs.SourceLineAnnotation.
                                                                     fromVisitedInstruction(
                                                                       classContext,
                                                                       methodGen,
                                                                       sourceFile,
                                                                       prevHandle);
                                                                   if (next instanceof org.apache.bcel.generic.ARETURN) {
                                                                       continue;
                                                                   }
                                                                   if (next instanceof org.apache.bcel.generic.GOTO) {
                                                                       org.apache.bcel.generic.InstructionHandle targ =
                                                                         ((org.apache.bcel.generic.BranchInstruction)
                                                                            next).
                                                                         getTarget(
                                                                           );
                                                                       if (targ.
                                                                             getInstruction(
                                                                               ) instanceof org.apache.bcel.generic.ARETURN) {
                                                                           continue;
                                                                       }
                                                                   }
                                                                   int startLine =
                                                                     sourceLineAnnotation.
                                                                     getStartLine(
                                                                       );
                                                                   if (startLine >
                                                                         0 &&
                                                                         lineMentionedMultipleTimes.
                                                                         get(
                                                                           startLine) &&
                                                                         linesWithLoadsOfNotDefinitelyNullValues.
                                                                         get(
                                                                           startLine)) {
                                                                       continue;
                                                                   }
                                                                   int previousLine =
                                                                     prevSourceLineAnnotation.
                                                                     getEndLine(
                                                                       );
                                                                   if (startLine <
                                                                         previousLine) {
                                                                       continue;
                                                                   }
                                                                   int priority =
                                                                     NORMAL_PRIORITY;
                                                                   if (!v.
                                                                         isChecked(
                                                                           )) {
                                                                       priority++;
                                                                   }
                                                                   edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
                                                                     null;
                                                                   try {
                                                                       edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                                                                         classContext.
                                                                         getValueNumberDataflow(
                                                                           method).
                                                                         getFactAfterLocation(
                                                                           location);
                                                                       if (vnaFrame.
                                                                             isValid(
                                                                               )) {
                                                                           edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                                                                             vnaFrame.
                                                                             getTopValue(
                                                                               );
                                                                           if (valueNumber.
                                                                                 hasFlag(
                                                                                   edu.umd.cs.findbugs.ba.vna.ValueNumber.
                                                                                     CONSTANT_CLASS_OBJECT)) {
                                                                               return;
                                                                           }
                                                                           variableAnnotation =
                                                                             edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                                                                               findAnnotationFromValueNumber(
                                                                                 method,
                                                                                 location,
                                                                                 valueNumber,
                                                                                 vnaFrame,
                                                                                 "VALUE_OF");
                                                                           if (variableAnnotation instanceof edu.umd.cs.findbugs.LocalVariableAnnotation) {
                                                                               edu.umd.cs.findbugs.LocalVariableAnnotation local =
                                                                                 (edu.umd.cs.findbugs.LocalVariableAnnotation)
                                                                                   variableAnnotation;
                                                                               if (!local.
                                                                                     isNamed(
                                                                                       )) {
                                                                                   priority++;
                                                                               }
                                                                           }
                                                                       }
                                                                   }
                                                                   catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                                                                       
                                                                   }
                                                                   catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                                                                       
                                                                   }
                                                                   bugAccumulator.
                                                                     accumulateBug(
                                                                       new edu.umd.cs.findbugs.BugInstance(
                                                                         this,
                                                                         "NP_LOAD_OF_KNOWN_NULL_VALUE",
                                                                         priority).
                                                                         addClassAndMethod(
                                                                           methodGen,
                                                                           sourceFile).
                                                                         addOptionalAnnotation(
                                                                           variableAnnotation),
                                                                       sourceLineAnnotation);
                                                               }
                                                           }
    }
    private boolean isNullTestedClose(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                      org.apache.bcel.generic.ALOAD load,
                                      org.apache.bcel.generic.InstructionHandle nextHandle,
                                      org.apache.bcel.generic.Instruction next) {
        if (!(next instanceof org.apache.bcel.generic.IFNULL)) {
            return false;
        }
        org.apache.bcel.generic.IFNULL ifNull =
          (org.apache.bcel.generic.IFNULL)
            next;
        org.apache.bcel.generic.InstructionHandle nextNextHandle =
          nextHandle.
          getNext(
            );
        if (nextNextHandle ==
              null) {
            return false;
        }
        org.apache.bcel.generic.Instruction nextInstruction =
          nextNextHandle.
          getInstruction(
            );
        if (!(nextInstruction instanceof org.apache.bcel.generic.ALOAD)) {
            return false;
        }
        org.apache.bcel.generic.ALOAD nextLoad =
          (org.apache.bcel.generic.ALOAD)
            nextInstruction;
        if (load.
              getIndex(
                ) !=
              nextLoad.
              getIndex(
                )) {
            return false;
        }
        org.apache.bcel.generic.InstructionHandle nextNextNextHandle =
          nextNextHandle.
          getNext(
            );
        if (nextNextNextHandle ==
              null) {
            return false;
        }
        org.apache.bcel.generic.Instruction nextNextNextInstruction =
          nextNextNextHandle.
          getInstruction(
            );
        if (!(nextNextNextInstruction instanceof org.apache.bcel.generic.INVOKEVIRTUAL)) {
            return false;
        }
        org.apache.bcel.generic.INVOKEVIRTUAL invokeVirtual =
          (org.apache.bcel.generic.INVOKEVIRTUAL)
            nextNextNextInstruction;
        java.lang.String methodName =
          invokeVirtual.
          getMethodName(
            classContext.
              getConstantPoolGen(
                ));
        java.lang.String methodSig =
          invokeVirtual.
          getSignature(
            classContext.
              getConstantPoolGen(
                ));
        if (!"close".
              equals(
                methodName)) {
            return false;
        }
        if (!"()V".
              equals(
                methodSig)) {
            return false;
        }
        org.apache.bcel.generic.InstructionHandle nextNextNextNextHandle =
          nextNextNextHandle.
          getNext(
            );
        if (ifNull.
              getTarget(
                ) !=
              nextNextNextNextHandle) {
            return false;
        }
        return true;
    }
    @java.lang.Override
    public void report() {  }
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
