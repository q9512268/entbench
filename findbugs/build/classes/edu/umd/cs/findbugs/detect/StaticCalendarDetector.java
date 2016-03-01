package edu.umd.cs.findbugs.detect;
public class StaticCalendarDetector extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static final boolean DEBUG = java.lang.Boolean.getBoolean("debug.staticcal");
    private static final java.lang.String PROP_SKIP_SYNCHRONIZED_CHECK = "staticcal.skipsynccheck";
    private final edu.umd.cs.findbugs.BugReporter reporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private java.lang.String currentClass;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor calendarType =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.util.Calendar.class);
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor dateFormatType =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.text.DateFormat.class);
    private org.apache.bcel.classfile.Method currentMethod = null;
    private edu.umd.cs.findbugs.ba.CFG currentCFG;
    private edu.umd.cs.findbugs.ba.LockDataflow currentLockDataFlow;
    private final java.util.Map<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.BugInstance>
      pendingBugs =
      new java.util.HashMap<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.BugInstance>(
      );
    public StaticCalendarDetector(edu.umd.cs.findbugs.BugReporter aReporter) {
        super(
          );
        reporter =
          aReporter;
        bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            reporter);
    }
    edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 = edu.umd.cs.findbugs.ba.AnalysisContext.
      currentAnalysisContext(
        ).
      getSubtypes2(
        );
    private boolean sawDateClass;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass someObj) {
        currentClass =
          someObj.
            getClassName(
              );
        currentMethod =
          null;
        currentCFG =
          null;
        currentLockDataFlow =
          null;
        sawDateClass =
          false;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.ConstantPool pool) {
        for (org.apache.bcel.classfile.Constant constant
              :
              pool.
               getConstantPool(
                 )) {
            if (constant instanceof org.apache.bcel.classfile.ConstantClass) {
                org.apache.bcel.classfile.ConstantClass cc =
                  (org.apache.bcel.classfile.ConstantClass)
                    constant;
                java.lang.String className =
                  cc.
                  getBytes(
                    pool);
                if ("java/util/Calendar".
                      equals(
                        className) ||
                      "java/text/DateFormat".
                      equals(
                        className)) {
                    sawDateClass =
                      true;
                    break;
                }
                try {
                    edu.umd.cs.findbugs.classfile.ClassDescriptor cDesc =
                      edu.umd.cs.findbugs.classfile.DescriptorFactory.
                      createClassDescriptor(
                        className);
                    if (subtypes2.
                          isSubtype(
                            cDesc,
                            calendarType) ||
                          subtypes2.
                          isSubtype(
                            cDesc,
                            dateFormatType)) {
                        sawDateClass =
                          true;
                        break;
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    reporter.
                      reportMissingClass(
                        e);
                }
            }
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field aField) {
        if (aField.
              isPrivate(
                )) {
            return;
        }
        java.lang.String superclassName =
          getSuperclassName(
            );
        if (!aField.
              isStatic(
                ) &&
              !"java/lang/Enum".
              equals(
                superclassName)) {
            return;
        }
        if (!aField.
              isPublic(
                ) &&
              !aField.
              isProtected(
                )) {
            return;
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor classOfField =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptorFromFieldSignature(
            aField.
              getSignature(
                ));
        java.lang.String tBugType =
          null;
        int priority =
          aField.
          isPublic(
            ) &&
          aField.
          isFinal(
            ) &&
          aField.
          getName(
            ).
          equals(
            aField.
              getName(
                ).
              toUpperCase(
                )) &&
          getThisClass(
            ).
          isPublic(
            )
          ? HIGH_PRIORITY
          : NORMAL_PRIORITY;
        if (classOfField !=
              null) {
            try {
                if (subtypes2.
                      isSubtype(
                        classOfField,
                        calendarType)) {
                    tBugType =
                      "STCAL_STATIC_CALENDAR_INSTANCE";
                    priority++;
                }
                else
                    if (subtypes2.
                          isSubtype(
                            classOfField,
                            dateFormatType)) {
                        tBugType =
                          "STCAL_STATIC_SIMPLE_DATE_FORMAT_INSTANCE";
                    }
                if (getClassContext(
                      ).
                      getXClass(
                        ).
                      usesConcurrency(
                        )) {
                    priority--;
                }
                if (tBugType !=
                      null) {
                    pendingBugs.
                      put(
                        getXField(
                          ),
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          tBugType,
                          priority).
                          addClass(
                            currentClass).
                          addField(
                            this));
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  reportMissingClass(
                    e);
            }
        }
    }
    @java.lang.Override
    public void visitMethod(org.apache.bcel.classfile.Method obj) {
        if (sawDateClass) {
            try {
                super.
                  visitMethod(
                    obj);
                currentMethod =
                  obj;
                currentLockDataFlow =
                  getClassContext(
                    ).
                    getLockDataflow(
                      currentMethod);
                currentCFG =
                  getClassContext(
                    ).
                    getCFG(
                      currentMethod);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                reporter.
                  logError(
                    ("Synchronization check in Static Calendar Detector caught an " +
                     "error."),
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                reporter.
                  logError(
                    ("Synchronization check in Static Calendar Detector caught an " +
                     "error."),
                    e);
            }
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (sawDateClass) {
            super.
              visit(
                obj);
            bugAccumulator.
              reportAccumulatedBugs(
                );
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            GETSTATIC) {
                                          edu.umd.cs.findbugs.ba.XField f =
                                            getXFieldOperand(
                                              );
                                          if (pendingBugs.
                                                containsKey(
                                                  f)) {
                                              if (!isLocked(
                                                     )) {
                                                  reporter.
                                                    reportBug(
                                                      pendingBugs.
                                                        remove(
                                                          f));
                                              }
                                          }
                                      }
                                      if (seen !=
                                            INVOKEVIRTUAL) {
                                          return;
                                      }
                                      try {
                                          java.lang.String className =
                                            getClassConstantOperand(
                                              );
                                          if (className.
                                                startsWith(
                                                  "[")) {
                                              return;
                                          }
                                          edu.umd.cs.findbugs.classfile.ClassDescriptor cDesc =
                                            edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                            createClassDescriptor(
                                              className);
                                          boolean isCalendar =
                                            subtypes2.
                                            isSubtype(
                                              cDesc,
                                              calendarType);
                                          boolean isDateFormat =
                                            subtypes2.
                                            isSubtype(
                                              cDesc,
                                              dateFormatType);
                                          if (!isCalendar &&
                                                !isDateFormat) {
                                              return;
                                          }
                                          int numArguments =
                                            getNumberArguments(
                                              getSigConstantOperand(
                                                ));
                                          edu.umd.cs.findbugs.OpcodeStack.Item invokedOn =
                                            stack.
                                            getStackItem(
                                              numArguments);
                                          edu.umd.cs.findbugs.ba.XField field =
                                            invokedOn.
                                            getXField(
                                              );
                                          if (field ==
                                                null ||
                                                !field.
                                                isStatic(
                                                  )) {
                                              return;
                                          }
                                          if ("<clinit>".
                                                equals(
                                                  getMethodName(
                                                    )) &&
                                                field.
                                                getClassName(
                                                  ).
                                                equals(
                                                  getDottedClassName(
                                                    ))) {
                                              return;
                                          }
                                          java.lang.String invokedName =
                                            getNameConstantOperand(
                                              );
                                          if (invokedName.
                                                startsWith(
                                                  "get")) {
                                              return;
                                          }
                                          if ("equals".
                                                equals(
                                                  invokedName) &&
                                                numArguments ==
                                                1) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item passedAsArgument =
                                                stack.
                                                getStackItem(
                                                  0);
                                              field =
                                                passedAsArgument.
                                                  getXField(
                                                    );
                                              if (field ==
                                                    null ||
                                                    !field.
                                                    isStatic(
                                                      )) {
                                                  return;
                                              }
                                          }
                                          if (!edu.umd.cs.findbugs.SystemProperties.
                                                getBoolean(
                                                  PROP_SKIP_SYNCHRONIZED_CHECK)) {
                                              if (isLocked(
                                                    )) {
                                                  return;
                                              }
                                          }
                                          java.lang.String tBugType;
                                          if (isCalendar) {
                                              tBugType =
                                                "STCAL_INVOKE_ON_STATIC_CALENDAR_INSTANCE";
                                          }
                                          else
                                              if (isDateFormat) {
                                                  tBugType =
                                                    "STCAL_INVOKE_ON_STATIC_DATE_FORMAT_INSTANCE";
                                              }
                                              else {
                                                  throw new java.lang.IllegalStateException(
                                                    "Not possible");
                                              }
                                          int priority;
                                          if (amVisitingMainMethod(
                                                )) {
                                              priority =
                                                LOW_PRIORITY;
                                          }
                                          else {
                                              if (getClassContext(
                                                    ).
                                                    getXClass(
                                                      ).
                                                    usesConcurrency(
                                                      )) {
                                                  priority =
                                                    NORMAL_PRIORITY;
                                              }
                                              else {
                                                  priority =
                                                    LOW_PRIORITY;
                                              }
                                              if (invokedName.
                                                    startsWith(
                                                      "set") ||
                                                    "format".
                                                    equals(
                                                      invokedName) ||
                                                    "add".
                                                    equals(
                                                      invokedName) ||
                                                    "clear".
                                                    equals(
                                                      invokedName) ||
                                                    "parse".
                                                    equals(
                                                      invokedName) ||
                                                    "applyPattern".
                                                    equals(
                                                      invokedName)) {
                                                  priority--;
                                              }
                                          }
                                          bugAccumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                tBugType,
                                                priority).
                                                addClassAndMethod(
                                                  this).
                                                addCalledMethod(
                                                  this).
                                                addOptionalField(
                                                  field),
                                              this);
                                      }
                                      catch (java.lang.ClassNotFoundException e) {
                                          edu.umd.cs.findbugs.ba.AnalysisContext.
                                            reportMissingClass(
                                              e);
                                      } }
    private boolean isLocked() { try { if (currentMethod !=
                                             null &&
                                             currentLockDataFlow !=
                                             null &&
                                             currentCFG !=
                                             null) {
                                           java.util.Collection<edu.umd.cs.findbugs.ba.Location> tLocations =
                                             currentCFG.
                                             getLocationsContainingInstructionWithOffset(
                                               getPC(
                                                 ));
                                           for (edu.umd.cs.findbugs.ba.Location tLoc
                                                 :
                                                 tLocations) {
                                               edu.umd.cs.findbugs.ba.LockSet lockSet =
                                                 currentLockDataFlow.
                                                 getFactAtLocation(
                                                   tLoc);
                                               if (lockSet.
                                                     getNumLockedObjects(
                                                       ) >
                                                     0) {
                                                   return true;
                                               }
                                           }
                                       } }
                                 catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                                     reporter.
                                       logError(
                                         ("Synchronization check in Static Calendar Detector caught an " +
                                          "error."),
                                         e);
                                 }
                                 return false;
    }
    @java.lang.Override
    public void report() { for (edu.umd.cs.findbugs.BugInstance bug
                                 :
                                 pendingBugs.
                                  values(
                                    )) { reporter.
                                           reportBug(
                                             bug);
                           } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+vbY/wBx2c/3FjAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A1RCZYjMwHahVimTiTMURuqQtehV0E9o");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "48fFlzrZv33Dv3n3l17+VnGZ4/8BrTGQjIA8AAA=");
}
