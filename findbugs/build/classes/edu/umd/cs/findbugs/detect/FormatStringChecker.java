package edu.umd.cs.findbugs.detect;
public class FormatStringChecker extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    final edu.umd.cs.findbugs.BugReporter bugReporter;
    public FormatStringChecker(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    enum FormatState {
        NONE, READY_FOR_FORMAT, EXPECTING_ASSIGNMENT; 
        private FormatState() {  }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za2wcxXnuzq84ju04dpKGxHldkBzSOx4JlDpQHMdOHM4P" +
                                                                  "bMcqDuSy3puzN97bXXbn7It5JlWV8IOHQoC0Bf+oDBUoJVFV1FYqKBUqj0JS" +
                                                                  "gVBL2hKg/cOjqElboGoo7ffN7N4+7s4m/KilG8/NzDff+zV37GNSbpmkmWos" +
                                                                  "xvYZ1Ip1aKxPMi2aalclyxqEtaT8aET6x+73e64Nk4phUjsmWd2yZNFOhaop" +
                                                                  "a5isUDSLSZpMrR5KUwjRZ1KLmhMSU3RtmDQpVlfGUBVZYd16iuKBIclMkIUS" +
                                                                  "Y6YykmW0y76AkRUJoCTOKYm3BbdbE6RG1o197vGlnuPtnh08mXFxWYzUJ/ZK" +
                                                                  "E1I8yxQ1nlAs1pozyWWGru4bVXUWozkW26tuskWwI7GpQARrTtR9euHBsXou" +
                                                                  "gkWSpumMs2f1U0tXJ2gqQerc1Q6VZqzbyF0kkiDzPYcZiSYcpHFAGgekDrfu" +
                                                                  "KaB+AdWymXads8OcmyoMGQliZLX/EkMypYx9TR+nGW6oYjbvHBi4XZXnVnBZ" +
                                                                  "wOLDl8WPPLq7/icRUjdM6hRtAMmRgQgGSIZBoDQzQk2rLZWiqWGyUANlD1BT" +
                                                                  "kVRlytZ0g6WMahLLgvodseBi1qAmx+nKCvQIvJlZmelmnr00Nyj7W3lalUaB" +
                                                                  "18Uur4LDTlwHBqsVIMxMS2B3NkjZuKKlGFkZhMjzGL0RDgBoZYayMT2PqkyT" +
                                                                  "YIE0CBNRJW00PgCmp43C0XIdDNBkZFnJS1HWhiSPS6M0iRYZONcntuDUPC4I" +
                                                                  "BGGkKXiM3wRaWhbQkkc/H/dsvv92bbsWJiGgOUVlFemfD0DNAaB+mqYmBT8Q" +
                                                                  "gDXrE49Ii587FCYEDjcFDoszP7vj/A0bmk++LM5cUuRM78heKrOkPDNS+/ry" +
                                                                  "9pZrI0hGlaFbCirfxzn3sj57pzVnQIRZnL8RN2PO5sn+F2++52n6UZhUd5EK" +
                                                                  "WVezGbCjhbKeMRSVmtuoRk2J0VQXmUe1VDvf7yKVME8oGhWrvem0RVkXKVP5" +
                                                                  "UoXOv4OI0nAFiqga5oqW1p25IbExPs8ZhJAy+JBy+Gwi4u8qHBih8TE9Q+OS" +
                                                                  "LGmKpsf7TB35t+IQcUZAtmPxNBjTSHbUilumHOemQ1PZeDaTisuWu5miDMDi" +
                                                                  "nbqZkZgwq/YxKo9TM4Ywxv8LUQ45XjQZCoEylgdDgQpetF1XU9RMykeyWzrO" +
                                                                  "P5N8VZgZuoYtK0a+CXhjgDcmWzEHb0zgjRXBG3XWQIMkFOKoG5EWYQOgwXGI" +
                                                                  "BRCMa1oGbt2x59CaCBifMYkKwaNrfEmp3Q0YTpRPyscbFkytPnvFC2FSliAN" +
                                                                  "ksyykoo5ps0cBazyuO3gNSOQrtysscqTNTDdmboMjJm0VPawb6nSJ6iJ64w0" +
                                                                  "em5wchp6b7x0RilKPzl5dHL/0N2Xh0nYnygQZTnEOATvw/CeD+PRYIAodm/d" +
                                                                  "wfc/Pf7InbobKnyZx0mYBZDIw5qgcQTFk5TXr5KeTT53Z5SLfR6EciaB60GU" +
                                                                  "bA7i8EWiVieqIy9VwHAa7UPFLUfG1WzM1CfdFW61C3FoEgaMJhQgkCeE6waM" +
                                                                  "x986/cFVXJJO7qjzJP0Bylo98Qova+CRaaFrkYMmpXDu7aN9Dz388cFd3Bzh" +
                                                                  "xNpiCKM4tkOcAu2ABL/78m1n3jk782bYNWFGKg1TgSqI5jgzjf+FvxB8vsAP" +
                                                                  "BhlcEMGmod2OeKvyIc9A1Je6xEHwU8HR0DqiOzWwQyWtSCMqRQf6vG7dFc/+" +
                                                                  "9f56oW8VVhxz2TD3Be7617aQe17d/VkzvyYkY/J1BegeExF9kXtzm2lK+5CO" +
                                                                  "3P43VnzvJelxyA0Qjy1livIQS7hACNfgJi6Ly/m4MbB3DQ7rLK+R+/3IUyQl" +
                                                                  "5QffPLdg6Nzz5zm1/irLq/huyWgVZiS0AMiaiD1c5Q35uLvYwHFJDmhYEoxU" +
                                                                  "2yVrDC7beLLnlnr15AVAOwxoZag/rF4TQmfOZ0v26fLKP/zqhcV7Xo+QcCep" +
                                                                  "VnUp1SlxjyPzwNSpNQZRN2d86wZBx2QVDPVcHqRAQgULqIWVxfXbkTEY18jU" +
                                                                  "z5f8dPOPps9yuzTEHZdw+AhArysh5w6oPl13r93591N7Pn/xn8DxDlKpmylF" +
                                                                  "k1TgtqV0tOO9gXvD0n/3qiMH/vyvAlXxOFekggnAD8ePPbas/fqPOLwbcBA6" +
                                                                  "mivMZxC0Xdgrn858El5T8eswqRwm9bJdUw9JahZ9fRjqSMsptKHu9u37a0JR" +
                                                                  "ALXmA+ryYLDzoA2GOjePwhxP43xBwCxR+aQGPhtts9wYNEtC+GQHB7mUjy04" +
                                                                  "bOAaLWPQImRHoNOCicWrdwZkoLYYKcOOgiOMwZee3p4OHk9FUMXxGzjcKCxk" +
                                                                  "czGDdP74ia15qmtxrflLUL2zBNU47cGhF4c+HG5yCK3v72jbenOys7cfP91t" +
                                                                  "g8WIHpqb6FCA6FUOoXMRfctXILqx49t9He2DXT3bkm0DA13bero7eooSfuvc" +
                                                                  "hIdzxQkI53HbaD2eTTB8rSjVSPAmaObAkelU7xNXiHK/wV+co/f/+Hf/eS12" +
                                                                  "9N1XilSBFXYj6CIMIz5ftdbNGyzXCd+uPfyXX0RHt1xMoYZrzXOUYvh9JXCw" +
                                                                  "vnQoCpLy0oEPlw1eP7bnImqulQFZBq98qvvYK9sulQ+HeTcpokNBF+oHavXH" +
                                                                  "hGqTQtusDfoiw1pv3VPUCiIBM/SYgpthQ3ZFjd+XgkvxjIERLSaqdQ5kzZKW" +
                                                                  "J3HQoZyZwKDYm+YEGbMATBWmKlzYImDG52Qr6F1gcxroaIIW5c+Lef8se9/B" +
                                                                  "4Q64i7NhzZL+wGp4SSNa4+kn156+e3rtezzhVykW2CGYbZFe3QNz7tg7H72x" +
                                                                  "YMUz3N7L0Kq5WoOPHIVvGL6nCU52nUdchmGQ2QR/bynB5xiZ7+nGHFuIXVxD" +
                                                                  "ByJbWvCKJF4+5Gem66qWTO/8veDYeZ2oAV9NZ1XVm/488wrDpGmFk14jkqHB" +
                                                                  "/z3AyLLSpIEKxYSzcb8AOczIoiIgDPDbU+/phxmpdk8zEpZ920fB2O1tRiIw" +
                                                                  "ejd/AEuwidPHjILIN5AdsZjn1ea9nuXV+njfQhFpZ4lTQcD7lOlTv/mkbr8A" +
                                                                  "9Nda/MXPBg3CnXkrcuV8Fn2Ax7e86c2HgsTCk9j+lnw95HeJarnW7VlI8Z6l" +
                                                                  "0S2NMGPE+OOkU2OCcdW6gQb3cXUG27dCcSXlXNNgY0vNTe8KZlfPIaWk3JVJ" +
                                                                  "Djx75uDVPD3VTSjQ1ImnZ/Hau9j32us8M7T6XkGLyjEpv3/8vpdXfzi0iD9v" +
                                                                  "CZEh5dfmhN9dZ+fqEM/VYSKeKi7x8WTTwZurpPzaBuWaqj+9+ZRgrVTI8cPc" +
                                                                  "8dgXpz648+wrEVIBQQKdSTIp5A7w2FLvx94LooMw2wpQkGVqBTQ6MerHtoWG" +
                                                                  "/Gq+vWfk66XuxgfxIo8k0M5MUnOLntVSeG00kNKyhuHdFcHsK1vVXdDLfgnZ" +
                                                                  "5Vl3CqgGLvaALXo3oaJZ1J6AQi05eHNfR3Korb+rbUuCV8czBmyGOjjNj+Pw" +
                                                                  "Q87EjDBlHJ8sZRS4fIIPOW/TRXIikAcXQ/7yLV8hNs1SIXp7OZzuwGEnDrfk" +
                                                                  "fK8WQUvvzopfCZLy8ekdPbefv/oJ8WoCop6asg2kUrzN5Eug1SVvc+6q2N5y" +
                                                                  "ofbEvHVhOxf5Xm283PGMBCLiDxzLAq8IVjT/mHBmZvPzpw5VvAE+vouEJFDT" +
                                                                  "rsJuLGdkIQLvSrgO6PmNiVtEa8v3912/If23P/IW2HbY5aXPQ7f50FtdJ8Y/" +
                                                                  "u4E/SpdD9qA53iZu3af1U3kCeveqrKbclqVdqVL+tcDnX4ysKfhZYG5/gmph" +
                                                                  "vrvi+7GiuIshgLuSV11jIa9Jeeu9db98sCHSCenax473+kqIfvmK1Pv7hVui" +
                                                                  "1vOCLCdcN5JMdBuG7cpVMOUkvCaO4DI403p71VOY4tff8ttO8ykOr/8PsxiD" +
                                                                  "mpkcAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/4VXvlZcdv1fQ04pyKopAAA=");
    }
    edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState
      state;
    java.lang.String formatString;
    int stackDepth;
    edu.umd.cs.findbugs.OpcodeStack.Item[]
      arguments;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) {
        state =
          edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
            NONE;
        super.
          visit(
            code);
        arguments =
          null;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (stack.
                                            getStackDepth(
                                              ) <
                                            stackDepth) {
                                          state =
                                            edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                              NONE;
                                          stackDepth =
                                            0;
                                          arguments =
                                            null;
                                      }
                                      if (seen ==
                                            ANEWARRAY &&
                                            stack.
                                            getStackDepth(
                                              ) >=
                                            2) {
                                          java.lang.Object size =
                                            stack.
                                            getStackItem(
                                              0).
                                            getConstant(
                                              );
                                          java.lang.Object formatStr =
                                            stack.
                                            getStackItem(
                                              1).
                                            getConstant(
                                              );
                                          if (size instanceof java.lang.Integer &&
                                                formatStr instanceof java.lang.String) {
                                              arguments =
                                                (new edu.umd.cs.findbugs.OpcodeStack.Item[(java.lang.Integer)
                                                                                            size]);
                                              this.
                                                formatString =
                                                (java.lang.String)
                                                  formatStr;
                                              state =
                                                edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                  READY_FOR_FORMAT;
                                              stackDepth =
                                                stack.
                                                  getStackDepth(
                                                    );
                                          }
                                      }
                                      else
                                          if (state ==
                                                edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                  READY_FOR_FORMAT &&
                                                seen ==
                                                DUP) {
                                              state =
                                                edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                  EXPECTING_ASSIGNMENT;
                                          }
                                          else
                                              if (state ==
                                                    edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                      EXPECTING_ASSIGNMENT &&
                                                    stack.
                                                    getStackDepth(
                                                      ) ==
                                                    stackDepth +
                                                    3 &&
                                                    seen ==
                                                    AASTORE) {
                                                  java.lang.Object pos =
                                                    stack.
                                                    getStackItem(
                                                      1).
                                                    getConstant(
                                                      );
                                                  edu.umd.cs.findbugs.OpcodeStack.Item value =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  if (pos instanceof java.lang.Integer) {
                                                      int index =
                                                        (java.lang.Integer)
                                                          pos;
                                                      if (index >=
                                                            0 &&
                                                            index <
                                                            arguments.
                                                              length) {
                                                          arguments[index] =
                                                            value;
                                                          state =
                                                            edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                              READY_FOR_FORMAT;
                                                      }
                                                      else {
                                                          state =
                                                            edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                              NONE;
                                                      }
                                                  }
                                                  else {
                                                      state =
                                                        edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                          NONE;
                                                  }
                                              }
                                              else
                                                  if (state ==
                                                        edu.umd.cs.findbugs.detect.FormatStringChecker.FormatState.
                                                          READY_FOR_FORMAT &&
                                                        (seen ==
                                                           INVOKESPECIAL ||
                                                           seen ==
                                                           INVOKEVIRTUAL ||
                                                           seen ==
                                                           INVOKESTATIC ||
                                                           seen ==
                                                           INVOKEINTERFACE) &&
                                                        stack.
                                                        getStackDepth(
                                                          ) ==
                                                        stackDepth) {
                                                      java.lang.String cl =
                                                        getClassConstantOperand(
                                                          );
                                                      java.lang.String nm =
                                                        getNameConstantOperand(
                                                          );
                                                      java.lang.String sig =
                                                        getSigConstantOperand(
                                                          );
                                                      edu.umd.cs.findbugs.ba.XMethod m =
                                                        getXMethodOperand(
                                                          );
                                                      if ((m ==
                                                             null ||
                                                             m.
                                                             isVarArgs(
                                                               )) &&
                                                            sig.
                                                            indexOf(
                                                              "Ljava/lang/String;[Ljava/lang/Object;)") >=
                                                            0 &&
                                                            ("java/util/Formatter".
                                                               equals(
                                                                 cl) &&
                                                               "format".
                                                               equals(
                                                                 nm) ||
                                                               "java/lang/String".
                                                               equals(
                                                                 cl) &&
                                                               "format".
                                                               equals(
                                                                 nm) ||
                                                               "java/io/PrintStream".
                                                               equals(
                                                                 cl) &&
                                                               "format".
                                                               equals(
                                                                 nm) ||
                                                               "java/io/PrintStream".
                                                               equals(
                                                                 cl) &&
                                                               "printf".
                                                               equals(
                                                                 nm) ||
                                                               cl.
                                                               endsWith(
                                                                 "Writer") &&
                                                               "format".
                                                               equals(
                                                                 nm) ||
                                                               cl.
                                                               endsWith(
                                                                 "Writer") &&
                                                               "printf".
                                                               equals(
                                                                 nm)) ||
                                                            cl.
                                                            endsWith(
                                                              "Logger") &&
                                                            nm.
                                                            endsWith(
                                                              "fmt")) {
                                                          if (formatString.
                                                                indexOf(
                                                                  '\n') >=
                                                                0) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "VA_FORMAT_STRING_USES_NEWLINE",
                                                                    NORMAL_PRIORITY).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addCalledMethod(
                                                                      this).
                                                                    addString(
                                                                      formatString).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.StringAnnotation.
                                                                        FORMAT_STRING_ROLE).
                                                                    addSourceLine(
                                                                      this));
                                                          }
                                                          try {
                                                              java.lang.String[] signatures =
                                                                new java.lang.String[arguments.
                                                                                       length];
                                                              for (int i =
                                                                     0;
                                                                   i <
                                                                     signatures.
                                                                       length;
                                                                   i++) {
                                                                  signatures[i] =
                                                                    arguments[i].
                                                                      getSignature(
                                                                        );
                                                              }
                                                              edu.umd.cs.findbugs.formatStringChecker.Formatter.
                                                                check(
                                                                  formatString,
                                                                  signatures);
                                                          }
                                                          catch (edu.umd.cs.findbugs.formatStringChecker.IllegalFormatConversionException e) {
                                                              if (e.
                                                                    getConversion(
                                                                      ) ==
                                                                    'b') {
                                                                  bugReporter.
                                                                    reportBug(
                                                                      new edu.umd.cs.findbugs.BugInstance(
                                                                        this,
                                                                        "VA_FORMAT_STRING_BAD_CONVERSION_TO_BOOLEAN",
                                                                        HIGH_PRIORITY).
                                                                        addClassAndMethod(
                                                                          this).
                                                                        addCalledMethod(
                                                                          this).
                                                                        addType(
                                                                          e.
                                                                            getArgumentSignature(
                                                                              )).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.TypeAnnotation.
                                                                            FOUND_ROLE).
                                                                        addString(
                                                                          e.
                                                                            getFormatSpecifier(
                                                                              )).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.StringAnnotation.
                                                                            FORMAT_SPECIFIER_ROLE).
                                                                        addString(
                                                                          formatString).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.StringAnnotation.
                                                                            FORMAT_STRING_ROLE).
                                                                        addValueSource(
                                                                          arguments[e.
                                                                                      getArgIndex(
                                                                                        )],
                                                                          getMethod(
                                                                            ),
                                                                          getPC(
                                                                            )).
                                                                        addSourceLine(
                                                                          this));
                                                              }
                                                              else
                                                                  if (e.
                                                                        getArgumentSignature(
                                                                          ).
                                                                        charAt(
                                                                          0) ==
                                                                        '[' &&
                                                                        e.
                                                                        getConversion(
                                                                          ) ==
                                                                        's') {
                                                                      bugReporter.
                                                                        reportBug(
                                                                          new edu.umd.cs.findbugs.BugInstance(
                                                                            this,
                                                                            "VA_FORMAT_STRING_BAD_CONVERSION_FROM_ARRAY",
                                                                            HIGH_PRIORITY).
                                                                            addClassAndMethod(
                                                                              this).
                                                                            addCalledMethod(
                                                                              this).
                                                                            addType(
                                                                              e.
                                                                                getArgumentSignature(
                                                                                  )).
                                                                            describe(
                                                                              edu.umd.cs.findbugs.TypeAnnotation.
                                                                                FOUND_ROLE).
                                                                            addString(
                                                                              e.
                                                                                getFormatSpecifier(
                                                                                  )).
                                                                            describe(
                                                                              edu.umd.cs.findbugs.StringAnnotation.
                                                                                FORMAT_SPECIFIER_ROLE).
                                                                            addString(
                                                                              formatString).
                                                                            describe(
                                                                              edu.umd.cs.findbugs.StringAnnotation.
                                                                                FORMAT_STRING_ROLE).
                                                                            addValueSource(
                                                                              arguments[e.
                                                                                          getArgIndex(
                                                                                            )],
                                                                              getMethod(
                                                                                ),
                                                                              getPC(
                                                                                )).
                                                                            addSourceLine(
                                                                              this));
                                                                  }
                                                                  else {
                                                                      java.lang.String aSig =
                                                                        e.
                                                                        getArgumentSignature(
                                                                          );
                                                                      char conversion =
                                                                        e.
                                                                        getConversion(
                                                                          );
                                                                      if ((conversion ==
                                                                             't' ||
                                                                             conversion ==
                                                                             'T') &&
                                                                            aSig.
                                                                            charAt(
                                                                              0) ==
                                                                            'L') {
                                                                          edu.umd.cs.findbugs.classfile.ClassDescriptor argDescriptor =
                                                                            edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                                            createClassDescriptorFromFieldSignature(
                                                                              aSig);
                                                                          assert argDescriptor !=
                                                                            null: "sig started with L, should get descriptor";
                                                                          java.lang.String arg =
                                                                            argDescriptor.
                                                                            toDottedClassName(
                                                                              );
                                                                          try {
                                                                              if (arg.
                                                                                    equals(
                                                                                      "java.time.LocalDate") ||
                                                                                    edu.umd.cs.findbugs.ba.Hierarchy.
                                                                                    isSubtype(
                                                                                      arg,
                                                                                      java.util.Date.class.
                                                                                        getName(
                                                                                          )) ||
                                                                                    edu.umd.cs.findbugs.ba.Hierarchy.
                                                                                    isSubtype(
                                                                                      arg,
                                                                                      java.util.Calendar.class.
                                                                                        getName(
                                                                                          )) ||
                                                                                    edu.umd.cs.findbugs.ba.Hierarchy.
                                                                                    isSubtype(
                                                                                      arg,
                                                                                      "java.time.temporal.TemporalAccessor")) {
                                                                                  return;
                                                                              }
                                                                          }
                                                                          catch (java.lang.ClassNotFoundException e1) {
                                                                              edu.umd.cs.findbugs.ba.AnalysisContext.
                                                                                reportMissingClass(
                                                                                  e1);
                                                                          }
                                                                      }
                                                                      bugReporter.
                                                                        reportBug(
                                                                          new edu.umd.cs.findbugs.BugInstance(
                                                                            this,
                                                                            "VA_FORMAT_STRING_BAD_CONVERSION",
                                                                            HIGH_PRIORITY).
                                                                            addClassAndMethod(
                                                                              this).
                                                                            addCalledMethod(
                                                                              this).
                                                                            addType(
                                                                              aSig).
                                                                            describe(
                                                                              edu.umd.cs.findbugs.TypeAnnotation.
                                                                                FOUND_ROLE).
                                                                            addString(
                                                                              e.
                                                                                getFormatSpecifier(
                                                                                  )).
                                                                            describe(
                                                                              edu.umd.cs.findbugs.StringAnnotation.
                                                                                FORMAT_SPECIFIER_ROLE).
                                                                            addString(
                                                                              formatString).
                                                                            describe(
                                                                              edu.umd.cs.findbugs.StringAnnotation.
                                                                                FORMAT_STRING_ROLE).
                                                                            addValueSource(
                                                                              arguments[e.
                                                                                          getArgIndex(
                                                                                            )],
                                                                              getMethod(
                                                                                ),
                                                                              getPC(
                                                                                )).
                                                                            addSourceLine(
                                                                              this));
                                                                  }
                                                          }
                                                          catch (java.lang.IllegalArgumentException e) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "VA_FORMAT_STRING_ILLEGAL",
                                                                    HIGH_PRIORITY).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addCalledMethod(
                                                                      this).
                                                                    addString(
                                                                      formatString).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.StringAnnotation.
                                                                        FORMAT_STRING_ROLE).
                                                                    addSourceLine(
                                                                      this));
                                                          }
                                                          catch (edu.umd.cs.findbugs.formatStringChecker.MissingFormatArgumentException e) {
                                                              if (e.
                                                                    pos <
                                                                    0) {
                                                                  bugReporter.
                                                                    reportBug(
                                                                      new edu.umd.cs.findbugs.BugInstance(
                                                                        this,
                                                                        "VA_FORMAT_STRING_NO_PREVIOUS_ARGUMENT",
                                                                        HIGH_PRIORITY).
                                                                        addClassAndMethod(
                                                                          this).
                                                                        addCalledMethod(
                                                                          this).
                                                                        addString(
                                                                          e.
                                                                            formatSpecifier).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.StringAnnotation.
                                                                            FORMAT_SPECIFIER_ROLE).
                                                                        addString(
                                                                          formatString).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.StringAnnotation.
                                                                            FORMAT_STRING_ROLE).
                                                                        addSourceLine(
                                                                          this));
                                                              }
                                                              else {
                                                                  bugReporter.
                                                                    reportBug(
                                                                      new edu.umd.cs.findbugs.BugInstance(
                                                                        this,
                                                                        "VA_FORMAT_STRING_MISSING_ARGUMENT",
                                                                        HIGH_PRIORITY).
                                                                        addClassAndMethod(
                                                                          this).
                                                                        addCalledMethod(
                                                                          this).
                                                                        addString(
                                                                          e.
                                                                            formatSpecifier).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.StringAnnotation.
                                                                            FORMAT_SPECIFIER_ROLE).
                                                                        addString(
                                                                          formatString).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.StringAnnotation.
                                                                            FORMAT_STRING_ROLE).
                                                                        addInt(
                                                                          e.
                                                                            pos +
                                                                            1).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.IntAnnotation.
                                                                            INT_EXPECTED_ARGUMENTS).
                                                                        addInt(
                                                                          arguments.
                                                                            length).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.IntAnnotation.
                                                                            INT_ACTUAL_ARGUMENTS).
                                                                        addSourceLine(
                                                                          this));
                                                              }
                                                          }
                                                          catch (edu.umd.cs.findbugs.formatStringChecker.ExtraFormatArgumentsException e) {
                                                              int priority =
                                                                NORMAL_PRIORITY;
                                                              java.lang.String pattern =
                                                                "VA_FORMAT_STRING_EXTRA_ARGUMENTS_PASSED";
                                                              if (e.
                                                                    used ==
                                                                    0) {
                                                                  priority =
                                                                    HIGH_PRIORITY;
                                                                  if (formatString.
                                                                        indexOf(
                                                                          "{0") >=
                                                                        0 ||
                                                                        formatString.
                                                                        indexOf(
                                                                          "{1") >=
                                                                        0) {
                                                                      pattern =
                                                                        "VA_FORMAT_STRING_EXPECTED_MESSAGE_FORMAT_SUPPLIED";
                                                                  }
                                                              }
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    pattern,
                                                                    priority).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addCalledMethod(
                                                                      this).
                                                                    addString(
                                                                      formatString).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.StringAnnotation.
                                                                        FORMAT_STRING_ROLE).
                                                                    addInt(
                                                                      e.
                                                                        used).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.IntAnnotation.
                                                                        INT_EXPECTED_ARGUMENTS).
                                                                    addInt(
                                                                      e.
                                                                        provided).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.IntAnnotation.
                                                                        INT_ACTUAL_ARGUMENTS).
                                                                    addSourceLine(
                                                                      this));
                                                          }
                                                          catch (edu.umd.cs.findbugs.formatStringChecker.FormatterNumberFormatException e) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "VA_FORMAT_STRING_ILLEGAL",
                                                                    NORMAL_PRIORITY).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addCalledMethod(
                                                                      this).
                                                                    addString(
                                                                      formatString).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.StringAnnotation.
                                                                        FORMAT_STRING_ROLE).
                                                                    addString(
                                                                      "Can\'t use " +
                                                                      e.
                                                                        getTxt(
                                                                          ) +
                                                                      " for " +
                                                                      e.
                                                                        getKind(
                                                                          )).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.StringAnnotation.
                                                                        STRING_MESSAGE).
                                                                    addSourceLine(
                                                                      this));
                                                          }
                                                      }
                                                  }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "e/wVm7/9F/qlrrdtHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HPj+I3YwNc3DKQAA");
}
