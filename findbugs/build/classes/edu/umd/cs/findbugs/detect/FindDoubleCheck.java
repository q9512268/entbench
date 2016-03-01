package edu.umd.cs.findbugs.detect;
public class FindDoubleCheck extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    static final boolean DEBUG = false;
    int stage = 0;
    int startPC;
    int endPC;
    int assignPC;
    int count;
    boolean sawMonitorEnter;
    java.util.Set<edu.umd.cs.findbugs.FieldAnnotation> fields = new java.util.HashSet<edu.umd.cs.findbugs.FieldAnnotation>(
      );
    java.util.Set<edu.umd.cs.findbugs.FieldAnnotation> twice = new java.util.HashSet<edu.umd.cs.findbugs.FieldAnnotation>(
      );
    edu.umd.cs.findbugs.FieldAnnotation pendingFieldLoad;
    edu.umd.cs.findbugs.ba.XField currentDoubleCheckField;
    int countSinceGetReference;
    int countSinceGetBoolean;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.NoSideEffectMethodsDatabase
      nse;
    public FindDoubleCheck(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          nse =
          edu.umd.cs.findbugs.classfile.Global.
            getAnalysisCache(
              ).
            getDatabase(
              edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.NoSideEffectMethodsDatabase.class);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                getFullyQualifiedMethodName(
                  ));
        }
        super.
          visit(
            obj);
        fields.
          clear(
            );
        twice.
          clear(
            );
        stage =
          0;
        count =
          0;
        countSinceGetReference =
          1000;
        countSinceGetBoolean =
          1000;
        sawMonitorEnter =
          false;
        pendingFieldLoad =
          null;
        currentDoubleCheckField =
          null;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            println(
                                              getPC(
                                                ) +
                                              "\t" +
                                              OPCODE_NAMES[seen] +
                                              "\t" +
                                              stage +
                                              "\t" +
                                              count +
                                              "\t" +
                                              countSinceGetReference);
                                      }
                                      if (seen ==
                                            MONITORENTER) {
                                          sawMonitorEnter =
                                            true;
                                      }
                                      if (seen ==
                                            GETFIELD ||
                                            seen ==
                                            GETSTATIC) {
                                          pendingFieldLoad =
                                            edu.umd.cs.findbugs.FieldAnnotation.
                                              fromReferencedField(
                                                this);
                                          if (DEBUG) {
                                              java.lang.System.
                                                out.
                                                println(
                                                  "\t" +
                                                  pendingFieldLoad);
                                          }
                                          java.lang.String sig =
                                            getSigConstantOperand(
                                              );
                                          if ("Z".
                                                equals(
                                                  sig)) {
                                              countSinceGetBoolean =
                                                0;
                                              countSinceGetReference++;
                                          }
                                          else
                                              if (sig.
                                                    startsWith(
                                                      "L") ||
                                                    sig.
                                                    startsWith(
                                                      "[")) {
                                                  countSinceGetBoolean++;
                                                  countSinceGetReference =
                                                    0;
                                              }
                                      }
                                      else {
                                          countSinceGetReference++;
                                      }
                                      switch (stage) {
                                          case 0:
                                              if ((seen ==
                                                     IFNULL ||
                                                     seen ==
                                                     IFNONNULL) &&
                                                    countSinceGetReference <
                                                    5 ||
                                                    (seen ==
                                                       IFEQ ||
                                                       seen ==
                                                       IFNE) &&
                                                    countSinceGetBoolean <
                                                    5) {
                                                  int b =
                                                    getBranchOffset(
                                                      );
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "branch offset is : " +
                                                          b);
                                                  }
                                                  if (b >
                                                        0 &&
                                                        !(seen ==
                                                            IFNULL &&
                                                            b >
                                                            9) &&
                                                        !(seen ==
                                                            IFEQ &&
                                                            (b >
                                                               9 &&
                                                               b <
                                                               34)) &&
                                                        !(seen ==
                                                            IFNE &&
                                                            (b >
                                                               9 &&
                                                               b <
                                                               34)) &&
                                                        !sawMonitorEnter) {
                                                      fields.
                                                        add(
                                                          pendingFieldLoad);
                                                      startPC =
                                                        getPC(
                                                          );
                                                      stage =
                                                        1;
                                                  }
                                              }
                                              count =
                                                0;
                                              break;
                                          case 1:
                                              if (seen ==
                                                    MONITORENTER) {
                                                  stage =
                                                    2;
                                                  count =
                                                    0;
                                              }
                                              else
                                                  if ((seen ==
                                                         IFNULL ||
                                                         seen ==
                                                         IFNONNULL) &&
                                                        countSinceGetReference <
                                                        5 ||
                                                        (seen ==
                                                           IFEQ ||
                                                           seen ==
                                                           IFNE) &&
                                                        countSinceGetBoolean <
                                                        5) {
                                                      int b =
                                                        getBranchOffset(
                                                          );
                                                      if (b >
                                                            0 &&
                                                            (seen ==
                                                               IFNONNULL ||
                                                               b <
                                                               10)) {
                                                          fields.
                                                            add(
                                                              pendingFieldLoad);
                                                          startPC =
                                                            getPC(
                                                              );
                                                          count =
                                                            0;
                                                      }
                                                  }
                                                  else {
                                                      count++;
                                                      if (count >
                                                            10) {
                                                          stage =
                                                            0;
                                                      }
                                                  }
                                              break;
                                          case 2:
                                              if ((seen ==
                                                     IFNULL ||
                                                     seen ==
                                                     IFNONNULL) &&
                                                    countSinceGetReference <
                                                    5 ||
                                                    (seen ==
                                                       IFEQ ||
                                                       seen ==
                                                       IFNE) &&
                                                    countSinceGetBoolean <
                                                    5) {
                                                  if (getBranchOffset(
                                                        ) >=
                                                        0 &&
                                                        fields.
                                                        contains(
                                                          pendingFieldLoad)) {
                                                      endPC =
                                                        getPC(
                                                          );
                                                      stage++;
                                                      twice.
                                                        add(
                                                          pendingFieldLoad);
                                                      break;
                                                  }
                                              }
                                              count++;
                                              if (count >
                                                    10) {
                                                  stage =
                                                    0;
                                              }
                                              break;
                                          case 3:
                                              if (seen ==
                                                    PUTFIELD ||
                                                    seen ==
                                                    PUTSTATIC) {
                                                  edu.umd.cs.findbugs.FieldAnnotation f =
                                                    edu.umd.cs.findbugs.FieldAnnotation.
                                                    fromReferencedField(
                                                      this);
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "\t" +
                                                          f);
                                                  }
                                                  if (twice.
                                                        contains(
                                                          f) &&
                                                        !getNameConstantOperand(
                                                           ).
                                                        startsWith(
                                                          "class$") &&
                                                        !"Ljava/lang/String;".
                                                        equals(
                                                          getSigConstantOperand(
                                                            ))) {
                                                      edu.umd.cs.findbugs.ba.XField declaration =
                                                        getXFieldOperand(
                                                          );
                                                      if (declaration ==
                                                            null ||
                                                            !declaration.
                                                            isVolatile(
                                                              )) {
                                                          bugReporter.
                                                            reportBug(
                                                              new edu.umd.cs.findbugs.BugInstance(
                                                                this,
                                                                "DC_DOUBLECHECK",
                                                                NORMAL_PRIORITY).
                                                                addClassAndMethod(
                                                                  this).
                                                                addField(
                                                                  f).
                                                                describe(
                                                                  "FIELD_ON").
                                                                addSourceLineRange(
                                                                  this,
                                                                  startPC,
                                                                  endPC));
                                                      }
                                                      else {
                                                          if (declaration.
                                                                isReferenceType(
                                                                  )) {
                                                              currentDoubleCheckField =
                                                                declaration;
                                                              assignPC =
                                                                getPC(
                                                                  );
                                                          }
                                                      }
                                                      stage++;
                                                  }
                                              }
                                              break;
                                          case 4:
                                              if (currentDoubleCheckField !=
                                                    null) {
                                                  switch (seen) {
                                                      case MONITOREXIT:
                                                          stage++;
                                                          break;
                                                      case INVOKEINTERFACE:
                                                      case INVOKESPECIAL:
                                                      case INVOKEVIRTUAL:
                                                          if (nse.
                                                                is(
                                                                  getMethodDescriptorOperand(
                                                                    ),
                                                                  edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.MethodSideEffectStatus.
                                                                    OBJ,
                                                                  edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.MethodSideEffectStatus.
                                                                    SE)) {
                                                              checkStackValue(
                                                                getNumberArguments(
                                                                  getMethodDescriptorOperand(
                                                                    ).
                                                                    getSignature(
                                                                      )));
                                                          }
                                                          break;
                                                      case PUTFIELD:
                                                          checkStackValue(
                                                            1);
                                                          break;
                                                      case DASTORE:
                                                      case FASTORE:
                                                      case SASTORE:
                                                      case LASTORE:
                                                      case BASTORE:
                                                      case CASTORE:
                                                      case AASTORE:
                                                      case IASTORE:
                                                          checkStackValue(
                                                            2);
                                                          break;
                                                  }
                                              }
                                              break;
                                          default:
                                              break;
                                      } }
    private void checkStackValue(int arg) {
        edu.umd.cs.findbugs.OpcodeStack.Item item =
          getStack(
            ).
          getStackItem(
            arg);
        if (item.
              getXField(
                ) ==
              currentDoubleCheckField) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "DC_PARTIALLY_CONSTRUCTED",
                  NORMAL_PRIORITY).
                  addClassAndMethod(
                    this).
                  addField(
                    currentDoubleCheckField).
                  describe(
                    "FIELD_ON").
                  addSourceLine(
                    this).
                  addSourceLine(
                    this,
                    assignPC).
                  describe(
                    "SOURCE_LINE_STORED"));
            stage++;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pplHBUUtGrPnhG8lHbiOvdK36/8Dk9HZhCYpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rCTDKUd5fnvUxrV0Sg06C6xVl4fA0XGO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("WhcdiAFGAZfZQWig8VCeBtEYR1dDEiXNgb9SG0hsw53pNOr4C2I+0/uqppII" +
       "3HXFWg3JwrKVdTKbp4zIcQdkiFCLvpcssmRWx1hOmrnwIqOFmh1VBqziDOP2" +
       "aOl6aMdudZysxyMZhON4aIwbHLwe8UqA8ase2mLQJJFDSBZXa3sVwwLXwxh1" +
       "DcMM27A63Z5pxEwbZgxlUomVZDxPg7FYF0f0DAQkNVH0+M3K4dvdlpkqjmF7" +
       "3GC6jR2z0R8v+2Gltl221N6UogfjVRNpSttRGXJ6LU7vymoaVE09xmuO2p43" +
       "5uRYNzfweAVP40p5ObMqDdX24WYsZvpmK7twH6ySCu6Rkp+2JUTmm5NMrTvN" +
       "VoqvgjqSjhe2Y6Ijme/iKKQm/HKTzCoqwWQdtddqQWnUmkVSmwIxWTVhF0h9" +
       "GKY1Btr4goRA0FCvq3Qy9Gx1QCPwCJo6Hu6u59uwE0ZRI954fmQlLrVZd1K7" +
       "3l1lLRtlhHSDVAiXRl1ft4y0PZ9uwfwDNOPQptWvWaFgdqokX17hcjQ3gR90" +
       "BhjPx/2Q9ox+yxnIJpWqo1oTanXsNlhvuBCgKPqD+ZHXf7uzo7i3FqeOx3eS" +
       "LQfJK37/Dk7bdlXP5tnzx8e9xeee0t491lPHvWfeDkVh6amLrhoX90c++5FX" +
       "X1Opn61ePjxHZ+LSfbEffL+jpZpzaqgrb/6SeHfKe3J96dc/8odPcO81PnAH" +
       "lzffsYdzf8h/NPncl/rvUn7qcunK8WWmW+6An+308t6LxFCLk9DjzlxkeuqY" +
       "s8UFyvw2RO+Qs739g/QT2d2iBZcKLdjJvqg7uYW3d5PvGT/UD6RAUgztQFY0" +
       "Z/dmMr/EfEhyPsile/cGOXWV79KDeXYlLt1dvIQ+91w39U31WMku3XVWyR48" +
       "VrJjUNdPvZJMtTA0Ve1N9PLWS3Z5waXSWVbm78zmh6yc/z9lZf7z/QUrnnwT" +
       "Nj2dZ48BfY6kNRUovppL/dJDJ2x5/EK25LWP/GUYkF80L70A0tcPGfD1O2XA" +
       "b35vDHjhTRhQzrMbcemakr9rZPND0+KC4B4bnr/dgf+Z25RguL274PnF1sdv" +
       "+dfJ7p8Syudfu3bvY6/x/6G4Dn38b4b7xqV7l4njnL5feOr5niDUlmbBgPt2" +
       "tw2DgiA4Lj1x8euouHTP7qGQRXXXpRGXHjmnSwzmP3w83boVl+4/aR2XLitn" +
       "ql+OS1cPq+PSFZCfrnwvKAKV+eMPBUfr6qVz3+nmq36nkYVQOgVqP8wunbXd" +
       "x07i+u0kdMrcP3fhbZNJsvvX0E3l9deG5I98p/mzu7vewP5st/ko945LV3fX" +
       "zo+N8rMXjnY01j2DF7770C/d9/yRA3loB/hEvU9he8f5F6u7bhAXV6G3//yx" +
       "f/Ken3vtG8VbsP8Dxy4fw8w1AAA=");
}
