package edu.umd.cs.findbugs.detect;
public class ReadReturnShouldBeChecked extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    boolean sawRead = false;
    boolean sawSkip = false;
    boolean recentCallToAvailable = false;
    int sawAvailable = 0;
    boolean wasBufferedInputStream = false;
    edu.umd.cs.findbugs.BugAccumulator accumulator;
    private int locationOfCall;
    private java.lang.String lastCallClass = null;
    private java.lang.String lastCallMethod = null;
    private java.lang.String lastCallSig = null;
    public ReadReturnShouldBeChecked(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { sawAvailable =
                                                              0;
                                                            sawRead =
                                                              false;
                                                            sawSkip =
                                                              false;
                                                            super.
                                                              visit(
                                                                obj);
                                                            accumulator.
                                                              reportAccumulatedBugs(
                                                                );
    }
    private boolean isInputStream() { if (lastCallClass.startsWith(
                                                          "[")) {
                                          return false;
                                      }
                                      return (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                instanceOf(
                                                  lastCallClass,
                                                  "java.io.InputStream") ||
                                                edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                instanceOf(
                                                  lastCallClass,
                                                  "java.io.DataInput") ||
                                                edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                instanceOf(
                                                  lastCallClass,
                                                  "java.io.Reader")) &&
                                        !edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                        instanceOf(
                                          lastCallClass,
                                          "java.io.ByteArrayInputStream");
    }
    private boolean isBufferedInputStream() {
        try {
            if (lastCallClass.
                  startsWith(
                    "[")) {
                return false;
            }
            return org.apache.bcel.Repository.
              instanceOf(
                lastCallClass,
                "java.io.BufferedInputStream");
        }
        catch (java.lang.ClassNotFoundException e) {
            return false;
        }
    }
    private boolean isImageIOInputStream() {
        try {
            if (lastCallClass.
                  startsWith(
                    "[")) {
                return false;
            }
            return org.apache.bcel.Repository.
              instanceOf(
                lastCallClass,
                "javax.imageio.stream.ImageInputStream");
        }
        catch (java.lang.ClassNotFoundException e) {
            return false;
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            INVOKEVIRTUAL ||
                                            seen ==
                                            INVOKEINTERFACE) {
                                          lastCallClass =
                                            getDottedClassConstantOperand(
                                              );
                                          lastCallMethod =
                                            getNameConstantOperand(
                                              );
                                          lastCallSig =
                                            getSigConstantOperand(
                                              );
                                      }
                                      if (seen ==
                                            INVOKEVIRTUAL ||
                                            seen ==
                                            INVOKEINTERFACE) {
                                          if ("available".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "()I".
                                                equals(
                                                  getSigConstantOperand(
                                                    )) ||
                                                getNameConstantOperand(
                                                  ).
                                                startsWith(
                                                  "get") &&
                                                getNameConstantOperand(
                                                  ).
                                                endsWith(
                                                  "Length") &&
                                                "()I".
                                                equals(
                                                  getSigConstantOperand(
                                                    )) ||
                                                "java/io/File".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "length".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "()J".
                                                equals(
                                                  getSigConstantOperand(
                                                    ))) {
                                              sawAvailable =
                                                70;
                                              return;
                                          }
                                      }
                                      sawAvailable--;
                                      if ((seen ==
                                             INVOKEVIRTUAL ||
                                             seen ==
                                             INVOKEINTERFACE) &&
                                            "read".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            ("([B)I".
                                               equals(
                                                 getSigConstantOperand(
                                                   )) ||
                                               "([BII)I".
                                               equals(
                                                 getSigConstantOperand(
                                                   )) ||
                                               "([C)I".
                                               equals(
                                                 getSigConstantOperand(
                                                   )) ||
                                               "([CII)I".
                                               equals(
                                                 getSigConstantOperand(
                                                   ))) &&
                                            isInputStream(
                                              )) {
                                          sawRead =
                                            true;
                                          recentCallToAvailable =
                                            sawAvailable >
                                              0;
                                          locationOfCall =
                                            getPC(
                                              );
                                          return;
                                      }
                                      if ((seen ==
                                             INVOKEVIRTUAL ||
                                             seen ==
                                             INVOKEINTERFACE) &&
                                            ("skip".
                                               equals(
                                                 getNameConstantOperand(
                                                   )) &&
                                               "(J)J".
                                               equals(
                                                 getSigConstantOperand(
                                                   )) ||
                                               "skipBytes".
                                               equals(
                                                 getNameConstantOperand(
                                                   )) &&
                                               "(I)I".
                                               equals(
                                                 getSigConstantOperand(
                                                   ))) &&
                                            isInputStream(
                                              ) &&
                                            !isImageIOInputStream(
                                               )) {
                                          wasBufferedInputStream =
                                            isBufferedInputStream(
                                              );
                                          sawSkip =
                                            true;
                                          locationOfCall =
                                            getPC(
                                              );
                                          recentCallToAvailable =
                                            sawAvailable >
                                              0 &&
                                              !wasBufferedInputStream;
                                          return;
                                      }
                                      if (seen ==
                                            POP ||
                                            seen ==
                                            POP2) {
                                          if (sawRead) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "RR_NOT_CHECKED",
                                                    recentCallToAvailable
                                                      ? LOW_PRIORITY
                                                      : NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addCalledMethod(
                                                      lastCallClass,
                                                      lastCallMethod,
                                                      lastCallSig,
                                                      false),
                                                  edu.umd.cs.findbugs.SourceLineAnnotation.
                                                    fromVisitedInstruction(
                                                      getClassContext(
                                                        ),
                                                      this,
                                                      locationOfCall));
                                          }
                                          else
                                              if (sawSkip) {
                                                  accumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "SR_NOT_CHECKED",
                                                        wasBufferedInputStream
                                                          ? HIGH_PRIORITY
                                                          : (recentCallToAvailable
                                                               ? LOW_PRIORITY
                                                               : NORMAL_PRIORITY)).
                                                        addClassAndMethod(
                                                          this).
                                                        addCalledMethod(
                                                          lastCallClass,
                                                          lastCallMethod,
                                                          lastCallSig,
                                                          false),
                                                      edu.umd.cs.findbugs.SourceLineAnnotation.
                                                        fromVisitedInstruction(
                                                          getClassContext(
                                                            ),
                                                          this,
                                                          locationOfCall));
                                              }
                                      }
                                      sawRead =
                                        false;
                                      sawSkip =
                                        false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KIh0i1d8W/MfThEXt8siAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Pe5y+iZX4XbL+8pHLjLe31h+Tf3Km73h");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("x76F/eT+JhnwKLtdMcqDHHR1f6nt2M0+f+FoR2NdYV7+9mM/89BLRyHBY3vA" +
       "JxpwCttz51/bohw/Ki9a7f7xO//hh//um79TnjD9XySx4y5ILgAA");
}
