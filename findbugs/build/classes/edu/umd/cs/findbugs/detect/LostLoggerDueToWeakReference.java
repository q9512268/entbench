package edu.umd.cs.findbugs.detect;
public class LostLoggerDueToWeakReference extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static final java.util.List<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      methods =
      java.util.Arrays.
      asList(
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "java/util/logging/Logger",
          "getLogger",
          "(Ljava/lang/String;)Ljava/util/logging/Logger;",
          true),
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "java/util/logging/Logger",
          "getLogger",
          ("(Ljava/lang/String;Ljava/lang/String;)Ljava/util/logging/Log" +
           "ger;"),
          true));
    final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    final java.util.HashSet<java.lang.String> namesOfSetterMethods =
      new java.util.HashSet<java.lang.String>(
      );
    public LostLoggerDueToWeakReference(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        namesOfSetterMethods.
          add(
            "addHandler");
        namesOfSetterMethods.
          add(
            "setUseParentHandlers");
        namesOfSetterMethods.
          add(
            "setLevel");
        namesOfSetterMethods.
          add(
            "setFilter");
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (hasInterestingMethod(
              classContext.
                getJavaClass(
                  ).
                getConstantPool(
                  ),
              methods)) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) {
        if (getMethodSig(
              ).
              indexOf(
                "Logger") ==
              -1) {
            sawGetLogger =
              -1;
            loggerEscaped =
              (loggerImported =
                 false);
            super.
              visit(
                code);
            if (sawGetLogger >=
                  0 &&
                  !loggerEscaped &&
                  !loggerImported) {
                bugAccumulator.
                  reportAccumulatedBugs(
                    );
            }
            else {
                bugAccumulator.
                  clearBugs(
                    );
            }
        }
    }
    int sawGetLogger;
    boolean loggerEscaped;
    boolean loggerImported;
    @java.lang.Override
    public void sawOpcode(int seen) { if (loggerEscaped ||
                                            loggerImported) {
                                          return;
                                      }
                                      switch (seen) {
                                          case INVOKESTATIC:
                                              if ("java/util/logging/Logger".
                                                    equals(
                                                      getClassConstantOperand(
                                                        )) &&
                                                    "getLogger".
                                                    equals(
                                                      getNameConstantOperand(
                                                        ))) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  if (!"".
                                                        equals(
                                                          item.
                                                            getConstant(
                                                              ))) {
                                                      sawGetLogger =
                                                        getPC(
                                                          );
                                                  }
                                                  break;
                                              }
                                              checkForImport(
                                                );
                                              break;
                                          case INVOKEVIRTUAL:
                                              if ("java/util/logging/Logger".
                                                    equals(
                                                      getClassConstantOperand(
                                                        )) &&
                                                    namesOfSetterMethods.
                                                    contains(
                                                      getNameConstantOperand(
                                                        ))) {
                                                  int priority =
                                                    HIGH_PRIORITY;
                                                  if (getMethod(
                                                        ).
                                                        isStatic(
                                                          ) &&
                                                        "main".
                                                        equals(
                                                          getMethodName(
                                                            )) &&
                                                        "([Ljava/lang/String;)V".
                                                        equals(
                                                          getMethodSig(
                                                            ))) {
                                                      priority =
                                                        NORMAL_PRIORITY;
                                                  }
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                    stack.
                                                    getItemMethodInvokedOn(
                                                      this);
                                                  edu.umd.cs.findbugs.BugInstance bug =
                                                    new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "LG_LOST_LOGGER_DUE_TO_WEAK_REFERENCE",
                                                    priority).
                                                    addClassAndMethod(
                                                      this).
                                                    addValueSource(
                                                      item,
                                                      this);
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      bug,
                                                      this);
                                                  break;
                                              }
                                              checkForImport(
                                                );
                                              checkForMethodExportImport(
                                                );
                                              break;
                                          case INVOKEINTERFACE:
                                          case INVOKESPECIAL:
                                              checkForImport(
                                                );
                                              checkForMethodExportImport(
                                                );
                                              break;
                                          case CHECKCAST:
                                              java.lang.String sig =
                                                getClassConstantOperand(
                                                  );
                                              if (sig.
                                                    indexOf(
                                                      "Logger") >=
                                                    0) {
                                                  loggerImported =
                                                    true;
                                              }
                                              break;
                                          case GETFIELD:
                                          case GETSTATIC:
                                              checkForImport(
                                                );
                                              break;
                                          case PUTFIELD:
                                          case PUTSTATIC:
                                              checkForFieldEscape(
                                                );
                                              break;
                                          default:
                                              break;
                                      } }
    private void checkForImport() { if (getSigConstantOperand(
                                          ).
                                          endsWith(
                                            "Logger;")) {
                                        loggerImported =
                                          true;
                                    } }
    private void checkForMethodExportImport() {
        int numArguments =
          edu.umd.cs.findbugs.visitclass.PreorderVisitor.
          getNumberArguments(
            getSigConstantOperand(
              ));
        for (int i =
               0;
             i <
               numArguments;
             i++) {
            edu.umd.cs.findbugs.OpcodeStack.Item item =
              stack.
              getStackItem(
                i);
            if (item.
                  getSignature(
                    ).
                  endsWith(
                    "Logger;")) {
                loggerEscaped =
                  true;
            }
        }
        java.lang.String sig =
          getSigConstantOperand(
            );
        int pos =
          sig.
          indexOf(
            ')');
        int loggerPos =
          sig.
          indexOf(
            "Logger");
        if (0 <=
              loggerPos &&
              loggerPos <
              pos) {
            loggerEscaped =
              true;
        }
    }
    private void checkForFieldEscape() { java.lang.String sig =
                                           getSigConstantOperand(
                                             );
                                         if (sig.
                                               indexOf(
                                                 "Logger") >=
                                               0) {
                                             loggerEscaped =
                                               true;
                                         }
                                         edu.umd.cs.findbugs.OpcodeStack.Item item =
                                           stack.
                                           getStackItem(
                                             0);
                                         if (item.
                                               getSignature(
                                                 ).
                                               endsWith(
                                                 "Logger;")) {
                                             loggerEscaped =
                                               true;
                                         }
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
      ("H4sIAAAAAAAAAL17C8zsWH3f3Ht377737t7dZWGBZR93CcvA5xmPPZ7R0pSx" +
       "PZ4Zjz0vjz2Pllz8HHv8fs+YbBqoWmgjCE2XhEpklVYkTSOSjaqSVopSbVW1" +
       "gQYqUaVNqFqgVatCUlRQG1qVPHrsme95v+8uC6Sf5DP2efn//P3/5/h8n/lm" +
       "6c4wKJU919quLDc6UDfRwdpCD6Ktp4YHNIOOxCBUFcISw3AK6m7Kz/z6te98" +
       "9+P6Q5dLV5elR0THcSMxMlwnnKihayWqwpSuHde2LdUOo9JDzFpMRCiODAti" +
       "jDB6gSndd2JoVLrBHJIAARIgQAJUkAC1jnuBQQ+oTmwT+QjRiUK/9BOlS0zp" +
       "qifn5EWlp09P4omBaO+nGRUcgBnuzp8FwFQxeBOUnjrifcfzLQx/ogy99HM/" +
       "9tA/vFK6tixdMxwuJ0cGRETgJcvS/bZqS2oQthRFVZalhx1VVTg1METLyAq6" +
       "l6XrobFyxCgO1CMh5ZWxpwbFO48ld7+c8xbEcuQGR+xphmoph093apa4Ary+" +
       "4ZjXHYdUXg8YvNcAhAWaKKuHQ+4wDUeJSm87O+KIxxt90AEMvctWI909etUd" +
       "jggqStd3urNEZwVxUWA4K9D1TjcGb4lKT1w4aS5rT5RNcaXejEpvPNtvtGsC" +
       "ve4pBJEPiUqPne1WzAS09MQZLZ3QzzcH7/nYB5yuc7mgWVFlK6f/bjDoyTOD" +
       "JqqmBqojq7uB97+T+VnxDb/1kculEuj82JnOuz7/+Me//d53Pfnq53Z93nxO" +
       "n6G0VuXopvxp6cEvvYV4vnklJ+Nuzw2NXPmnOC/Mf7RveWHjAc97w9GMeePB" +
       "YeOrk3+5+MlfUf/wcuneXumq7FqxDezoYdm1PcNSg47qqIEYqUqvdI/qKETR" +
       "3ivdBe4Zw1F3tUNNC9WoV7rDKqquusUzEJEGpshFdBe4NxzNPbz3xEgv7jde" +
       "qVS6C1yl+8F1UNr9Fb9RyYF011YhURYdw3GhUeDm/IeQ6kQSkK0OacCYpHgV" +
       "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" +
       "6RQJNZWhRhyfpOVq1ErNnss0BrHQHFYs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("t9+P04GpbOFZX9pUm1OkAjIm1ODLKl1t2tt+Yz2VKK3W5DGmZkWS2MUzVMmS" +
       "erJsgfhYl5Y0CgszdFoV8IyfT2EY6tT4iojAvun4crkMpdhyMKmwEylsmkSS" +
       "Eo4wbocdEFTULsByt7lWel0Y2XTg9XxQD8Z8Text0CZmqxWTVRhqrg2Tcreu" +
       "DtmE3NBpq5VvQf3m69sae7jY8Ts6pfd97PXtmp7Oi+eOdkaLv6ulMye7TuyM" +
       "ntrBD4PSWy86fFfsR3/6Qy+9rAx/sXp5v2X6M1Hpnsj13m2piWqdmOrq7T8a" +
       "776XHH+p/+0P/cET0x/V3/86zim97QydZ6f8B+xnPt95u/wzl0tXjr7b33Iq" +
       "8vSgF858VgzUKA6c6alv9m89fVboPeAi9pIlzu45H+vu/I9J79jp/syBkzOH" +
       "Vp4975uYJO70sj+YWszzpdscXPm3efEFYGTFV+mTQ8/ddk1cQzm2uS+etrn7" +
       "j2zuiMbrJz5XJmoQGIp6GzO99XhJUfH505J9Clz0XrL0n4tkn3SD1YHoibKu" +
       "Hkiyap34jEq4ilpM8V9vI9Rv5MXXotKdhVDzh987Ftp/ulBoefV/+IHF8yy4" +
       "lL14lB+qePLHjxcd/tdtmP9OXvwP4P2hmA49GcjrjAC+9ecngPygaulpcP3C" +
       "XgC/8HoF0D5XACf4u3TpNm0FhP9xVHoQWI5sUu7+c9EZAfzJa32oeC0O3w2u" +
       "X9pz+Es/fA4fuE3btby4Oyo9ccjhDijbm5zP87i9dM8Pyu3bwfUbe25/44fP" +
       "7Ztu0/bmvHg0Kj1yyG1xBm33wfIMm4+9HjY3+Umx2xwAzk8zvvGW/0jYnaKX" +
       "f+3la3c//jL/e8UZ2KOT7vcwpbu12LJOHio7cX/VC1TNKIRxz+6IWfFN/9Iz" +
       "QJUXn1KOSld3NzkHl57eDXkOyOOcIRF4//72ZO93RKV7j3tHpcvyqeZyVLpr" +
       "3xyVroDyZOMBqAKN+S3kHYLzu84NezlK79CGi4CgyIJqN9hcOp3FHPng9ddS" +
       "14nE59kLT2Gx8e4/Sm7Kr7xMDz7w7fov7g74gniRZfksdzOlu3ZnjY/Sk6cv" +
       "nO1wrqvd57/74K/f89xhKvXgjuBjUz9B29vOP03btr2oOP+a/ZPH/9F7/v7L" +
       "Xym+z/4/S/equugzAAA=");
}
