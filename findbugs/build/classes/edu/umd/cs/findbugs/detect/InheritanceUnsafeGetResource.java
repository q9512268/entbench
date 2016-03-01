package edu.umd.cs.findbugs.detect;
public class InheritanceUnsafeGetResource extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private boolean classIsFinal;
    private boolean classIsVisibleToOtherPackages;
    private boolean methodIsStatic;
    int state = 0;
    int sawGetClass;
    boolean reportedForThisClass;
    java.lang.String stringConstant;
    int prevOpcode;
    public InheritanceUnsafeGetResource(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) { classIsFinal =
                                                                   obj.
                                                                     isFinal(
                                                                       );
                                                                 reportedForThisClass =
                                                                   false;
                                                                 classIsVisibleToOtherPackages =
                                                                   obj.
                                                                     isPublic(
                                                                       ) ||
                                                                     obj.
                                                                     isProtected(
                                                                       );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        methodIsStatic =
          obj.
            isStatic(
              );
        state =
          0;
        sawGetClass =
          -100;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (reportedForThisClass) {
                                          return;
                                      }
                                      switch (seen) {
                                          case LDC:
                                              org.apache.bcel.classfile.Constant constantValue =
                                                getConstantRefOperand(
                                                  );
                                              if (constantValue instanceof org.apache.bcel.classfile.ConstantClass) {
                                                  sawGetClass =
                                                    -100;
                                              }
                                              else
                                                  if (constantValue instanceof org.apache.bcel.classfile.ConstantString) {
                                                      stringConstant =
                                                        ((org.apache.bcel.classfile.ConstantString)
                                                           constantValue).
                                                          getBytes(
                                                            getConstantPool(
                                                              ));
                                                  }
                                              break;
                                          case ALOAD_0:
                                              state =
                                                1;
                                              break;
                                          case INVOKEVIRTUAL:
                                              if ("java/lang/Class".
                                                    equals(
                                                      getClassConstantOperand(
                                                        )) &&
                                                    ("getResource".
                                                       equals(
                                                         getNameConstantOperand(
                                                           )) ||
                                                       "getResourceAsStream".
                                                       equals(
                                                         getNameConstantOperand(
                                                           ))) &&
                                                    sawGetClass +
                                                    10 >=
                                                    getPC(
                                                      )) {
                                                  int priority =
                                                    NORMAL_PRIORITY;
                                                  if (prevOpcode ==
                                                        LDC &&
                                                        stringConstant !=
                                                        null &&
                                                        stringConstant.
                                                        length(
                                                          ) >
                                                        0 &&
                                                        stringConstant.
                                                        charAt(
                                                          0) ==
                                                        '/') {
                                                      priority =
                                                        LOW_PRIORITY;
                                                  }
                                                  else {
                                                      priority =
                                                        adjustPriority(
                                                          priority);
                                                  }
                                                  bugReporter.
                                                    reportBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "UI_INHERITANCE_UNSAFE_GETRESOURCE",
                                                        priority).
                                                        addClassAndMethod(
                                                          this).
                                                        addSourceLine(
                                                          this));
                                                  reportedForThisClass =
                                                    true;
                                              }
                                              else
                                                  if (state ==
                                                        1 &&
                                                        !methodIsStatic &&
                                                        !classIsFinal &&
                                                        classIsVisibleToOtherPackages &&
                                                        "getClass".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) &&
                                                        "()Ljava/lang/Class;".
                                                        equals(
                                                          getSigConstantOperand(
                                                            ))) {
                                                      sawGetClass =
                                                        getPC(
                                                          );
                                                  }
                                              state =
                                                0;
                                              break;
                                          default:
                                              state =
                                                0;
                                              break;
                                      }
                                      if (seen !=
                                            LDC) {
                                          stringConstant =
                                            null;
                                      }
                                      prevOpcode =
                                        seen;
    }
    private int adjustPriority(int priority) {
        try {
            edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                );
            if (!subtypes2.
                  hasSubtypes(
                    getClassDescriptor(
                      ))) {
                priority++;
            }
            else {
                java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> mySubtypes =
                  subtypes2.
                  getSubtypes(
                    getClassDescriptor(
                      ));
                java.lang.String myPackagename =
                  getThisClass(
                    ).
                  getPackageName(
                    );
                for (edu.umd.cs.findbugs.classfile.ClassDescriptor c
                      :
                      mySubtypes) {
                    if (c.
                          equals(
                            getClassDescriptor(
                              ))) {
                        continue;
                    }
                    if (!c.
                          getPackageName(
                            ).
                          equals(
                            myPackagename)) {
                        priority--;
                        break;
                    }
                }
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            bugReporter.
              reportMissingClass(
                e);
        }
        return priority;
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
       "3AwYzrMCyirjDaGsVIx0UJHrG0no4FXCVcAUAxhRqqFok/B78+1ouJCnHC92" +
       "RKmridI8LUuqKPbjka+WqIbaqamijK8a5ZSYxdHK8tmRMNb9bklW5lE5EIfi" +
       "tCeuZ05XWTH8uu6UVgbXG6YjrdQVHKc3nMykyOpl01AsoxDVdhPOgk7VU+jt" +
       "ZCvJ3jqb4K62GszrTdpS7A3fXfvbEcwfNvV6daIqfGlOCtogApXUSCu0u3BS" +
       "rRdJtj/yGt25LYwUz1LGVjStNy21thFbsiUxsrKx1TlnS40pz9JMPGJqgJuL" +
       "Hb+2JNGBn4XVUXcO0am7lUmUXCWoA2++UyUuIkB9osq1eincGnJX5myRdDLX" +
       "HwsOyyfskKd3gZ6kMZUE7iSq9A000VmgWMFKXvOcJZmT9tp0pC4YGuKgris9" +
       "cbgzK3q/JW6SLsuFSTMzSb0qrNegTzhEbWHKPmsJorVSqVrPpGhObJnr5lLk" +
       "UccPJ+i63lE4oxssNY4NujYXhMIAn400f5557VCkMbU218V2Oei5g0ZnyIDl" +
       "GIyZ2Elsey2QkbhNbXldmtptQJfsCIRVgWJLVZaWlhOuR/RGZR5vTcLSDB93" +
       "ezuq0WJYN0ppr0x1TMMNu/pstQ2mvrhcakO+XWrb2mhYo7qqu9Jb046J9/DO" +
       "aD2QOH8bB8OaUBk16VLH2uziegbSOaO3mM2o2Wtxu5QrraA9lkxivMZJlCg3" +
       "NAD8cnk6T8Ydsal7WrfbaJO0x1WHOKuq/mjODLImNdbjsYE7O3YVTfjNsLzb" +
       "ZDHjxqg+KCvGKKqPV2Tc8DNNWTcWwB93NWaJrhWijIm7RFEMmZPckulU/WCw" +
       "oWqNnYD6eGU2nLS4aBtxa4V0ZvTCjQmUrGMApegGj1dVgDtx2I3LbLL1ZEPb" +
       "mQE/0rOBHDTXmZOs7ZY8FozBoJKqw37Nshmv3C0JtaTU7Ud2aeQvgnhW0zJa" +
       "Yuzm0qJ9M3RMpaLgWjtKM6C3l6Y4poe4tpxOwjaLYQOL13r1maPaHYmf7IaN" +
       "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" +
       "tyNe19gXf/D4rz3ywaMF9/E94BNTP4Xt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "/RdfJGo7flxc/dn9+nv+zkf/xhu/V5zR/G+Uwq274ywAAA==";
}
