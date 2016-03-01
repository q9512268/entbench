package edu.umd.cs.findbugs.detect;
public class FindFieldSelfAssignment extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fsa.debug");
    int state;
    public FindFieldSelfAssignment(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { state =
                                                              0;
                                                            lastMethodCall =
                                                              -1;
                                                            if (DEBUG) {
                                                                java.lang.System.
                                                                  out.
                                                                  println(
                                                                    getXMethod(
                                                                      ));
                                                            }
                                                            super.
                                                              visit(
                                                                obj);
                                                            possibleOverwrite =
                                                              null;
                                                            if (DEBUG) {
                                                                java.lang.System.
                                                                  out.
                                                                  println(
                                                                    );
                                                            }
                                                            initializedFields.
                                                              clear(
                                                                );
    }
    int register;
    int lastMethodCall;
    java.util.Set<java.lang.String> initializedFields =
      new java.util.HashSet<java.lang.String>(
      );
    edu.umd.cs.findbugs.ba.XField possibleOverwrite;
    @java.lang.Override
    public void sawOpcode(int seen) { if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            printf(
                                              "%5d %12s %s%n",
                                              getPC(
                                                ),
                                              OPCODE_NAMES[seen],
                                              stack);
                                      }
                                      if (seen ==
                                            PUTFIELD) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.OpcodeStack.Item next =
                                            stack.
                                            getStackItem(
                                              1);
                                          if (possibleOverwrite !=
                                                null &&
                                                possibleOverwrite.
                                                equals(
                                                  getXFieldOperand(
                                                    ))) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "SA_FIELD_SELF_ASSIGNMENT",
                                                    edu.umd.cs.findbugs.Priorities.
                                                      HIGH_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addReferencedField(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                          possibleOverwrite =
                                            null;
                                          if (stack.
                                                getStackDepth(
                                                  ) >=
                                                4 &&
                                                getNextOpcode(
                                                  ) ==
                                                PUTFIELD) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item third =
                                                stack.
                                                getStackItem(
                                                  2);
                                              edu.umd.cs.findbugs.OpcodeStack.Item fourth =
                                                stack.
                                                getStackItem(
                                                  3);
                                              edu.umd.cs.findbugs.ba.XField f2 =
                                                third.
                                                getXField(
                                                  );
                                              int registerNumber2 =
                                                fourth.
                                                getRegisterNumber(
                                                  );
                                              if (f2 !=
                                                    null &&
                                                    f2.
                                                    equals(
                                                      getXFieldOperand(
                                                        )) &&
                                                    registerNumber2 >=
                                                    0 &&
                                                    registerNumber2 ==
                                                    third.
                                                    getFieldLoadedFromRegister(
                                                      ) &&
                                                    !third.
                                                    sameValue(
                                                      top) &&
                                                    (third.
                                                       getPC(
                                                         ) ==
                                                       -1 ||
                                                       third.
                                                       getPC(
                                                         ) >
                                                       lastMethodCall)) {
                                                  possibleOverwrite =
                                                    f2;
                                              }
                                          }
                                          edu.umd.cs.findbugs.ba.XField f =
                                            top.
                                            getXField(
                                              );
                                          int registerNumber =
                                            next.
                                            getRegisterNumber(
                                              );
                                          if (f !=
                                                null &&
                                                f.
                                                equals(
                                                  getXFieldOperand(
                                                    )) &&
                                                registerNumber >=
                                                0 &&
                                                registerNumber ==
                                                top.
                                                getFieldLoadedFromRegister(
                                                  ) &&
                                                (top.
                                                   getPC(
                                                     ) ==
                                                   -1 ||
                                                   top.
                                                   getPC(
                                                     ) >
                                                   lastMethodCall)) {
                                              int priority =
                                                NORMAL_PRIORITY;
                                              edu.umd.cs.findbugs.LocalVariableAnnotation possibleMatch =
                                                edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                findMatchingIgnoredParameter(
                                                  getClassContext(
                                                    ),
                                                  getMethod(
                                                    ),
                                                  getNameConstantOperand(
                                                    ),
                                                  getSigConstantOperand(
                                                    ));
                                              if (possibleMatch !=
                                                    null) {
                                                  priority--;
                                              }
                                              else {
                                                  possibleMatch =
                                                    edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                      findUniqueBestMatchingParameter(
                                                        getClassContext(
                                                          ),
                                                        getMethod(
                                                          ),
                                                        getNameConstantOperand(
                                                          ),
                                                        getSigConstantOperand(
                                                          ));
                                              }
                                              if (possibleMatch ==
                                                    null) {
                                                  java.lang.String signature =
                                                    stack.
                                                    getLVValue(
                                                      registerNumber).
                                                    getSignature(
                                                      );
                                                  for (int i =
                                                         0;
                                                       i <
                                                         stack.
                                                         getNumLocalValues(
                                                           );
                                                       i++) {
                                                      if (i !=
                                                            register) {
                                                          edu.umd.cs.findbugs.OpcodeStack.Item lvValue =
                                                            stack.
                                                            getLVValue(
                                                              i);
                                                          if (lvValue !=
                                                                null &&
                                                                lvValue.
                                                                getSignature(
                                                                  ).
                                                                equals(
                                                                  signature)) {
                                                              priority--;
                                                              break;
                                                          }
                                                      }
                                                  }
                                              }
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "SA_FIELD_SELF_ASSIGNMENT",
                                                    priority).
                                                    addClassAndMethod(
                                                      this).
                                                    addReferencedField(
                                                      this).
                                                    addOptionalAnnotation(
                                                      possibleMatch).
                                                    addSourceLine(
                                                      this));
                                          }
                                      }
                                      else {
                                          possibleOverwrite =
                                            null;
                                      }
                                      if (isMethodCall(
                                            )) {
                                          lastMethodCall =
                                            getPC(
                                              );
                                      }
                                      switch (state) {
                                          case 0:
                                              if (seen ==
                                                    DUP) {
                                                  state =
                                                    6;
                                              }
                                              break;
                                          case 6:
                                              if (isRegisterStore(
                                                    )) {
                                                  state =
                                                    7;
                                                  register =
                                                    getRegisterOperand(
                                                      );
                                              }
                                              else {
                                                  state =
                                                    0;
                                              }
                                              break;
                                          case 7:
                                              if (isRegisterStore(
                                                    ) &&
                                                    register ==
                                                    getRegisterOperand(
                                                      )) {
                                                  bugReporter.
                                                    reportBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "SA_LOCAL_DOUBLE_ASSIGNMENT",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        add(
                                                          edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                            getLocalVariableAnnotation(
                                                              getMethod(
                                                                ),
                                                              register,
                                                              getPC(
                                                                ),
                                                              getPC(
                                                                ) -
                                                                1)).
                                                        addSourceLine(
                                                          this));
                                              }
                                              state =
                                                0;
                                              break;
                                          default:
                                              break;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwcxRWfO3/G3x/5Ih9O4jiJHMIdSfkQGFLsi50YzrFr" +
       "O1ZxgMve3py98d7uZnfOvgRMIW2VlIqUkhAogvxRBfEhIKgqpS0FpUKFUJJK" +
       "UApJKYFCpQYoKikC2kKhb2Z2bz9u90IqVEu7npuZ9+a9mfd+783bh99HZYaO" +
       "WrBCImS7ho1It0IGBN3AqZgsGMYw9CXEO0uED687tfGSMCofRXXjgtEnCgbu" +
       "kbCcMkbRQkkxiKCI2NiIcYpSDOjYwPqkQCRVGUWzJKM3o8mSKJE+NYXphBFB" +
       "j6NGgRBdSmYJ7jUZELQwDpJEmSTRTu9wRxzViKq23Z4+1zE95hihMzP2WgZB" +
       "DfGtwqQQzRJJjsYlg3TkdHSupsrbx2SVRHCORLbKF5pbcGX8woItaH2s/uNP" +
       "bxtvYFvQLCiKSph6xiA2VHkSp+Ko3u7tlnHG2IZuRCVxVO2YTFBb3Fo0CotG" +
       "YVFLW3sWSF+LlWwmpjJ1iMWpXBOpQAQtcTPRBF3ImGwGmMzAoZKYujNi0HZx" +
       "XluuZYGKd5wb3XfndQ0/KUH1o6heUoaoOCIIQWCRUdhQnEli3ehMpXBqFDUq" +
       "cNhDWJcEWdphnnSTIY0pAsnC8VvbQjuzGtbZmvZewTmCbnpWJKqeVy/NDMr8" +
       "VZaWhTHQdbatK9ewh/aDglUSCKanBbA7k6R0QlJSBC3yUuR1bLsKJgBpRQaT" +
       "cTW/VKkiQAdq4iYiC8pYdAhMTxmDqWUqGKBO0LxApnSvNUGcEMZwglqkZ94A" +
       "H4JZM9hGUBKCZnmnMU5wSvM8p+Q4n/c3XrbnemWDEkYhkDmFRZnKXw1ELR6i" +
       "QZzGOgY/4IQ1K+P7hdlP7Q4jBJNneSbzOU/ccPqKVS2Hj/A5833m9Ce3YpEk" +
       "xIPJuhcXxNovKaFiVGqqIdHDd2nOvGzAHOnIaYAws/Mc6WDEGjw8+OzVNz2E" +
       "3wujql5ULqpyNgN21CiqGU2Ssb4eK1gXCE71ohlYScXYeC+qgHZcUjDv7U+n" +
       "DUx6UanMuspV9hu2KA0s6BZVQVtS0qrV1gQyzto5DSFUAQ+6Fp7liP+x/wRJ" +
       "0XE1g6OCKCiSokYHdJXqb0QBcZKwt+PRNBhTMjtmRA1djDLTwalsNJtJRUXD" +
       "HkxhAmTRHvjNAHMIy+lOgzpKhoIupdP+n4vlqObNU6EQHMoCLyTI4E0bVDmF" +
       "9YS4L9vVffrRxAvc3KiLmHtG0BpYOwJrR0QjYq0d4WtHAtZGoRBbciaVgdsA" +
       "nOAEYAGAcU370LVXbtndWgLGp02VwvbTqa2uoBSzAcNC+YR4qKl2x5KTq58J" +
       "o9I4ahJEkhVkGmM69TFAL3HCdPCaJIQrO2osdkQNGu50VQSFdBwUPUwuleok" +
       "1mk/QTMdHKyYRr03GhxRfOVHh++aunnkW+eHUdgdKOiSZYBxlHyAwnsextu8" +
       "AOHHt37XqY8P7Z9WbahwRR4rYBZQUh1avUbh3Z6EuHKx8Hjiqek2tu0zAMqJ" +
       "AK4HKNniXcOFRB0WqlNdKkHhtKpnBJkOWXtcRcZ1dcruYdbayNozwSyqqWu2" +
       "wrPK9FX2n47O1uh7DrduamceLVjUuHxIu/f47975GttuK8DUOzKDIUw6HKBG" +
       "mTUx+Gq0zXZYxxjmvX7XwN473t+1mdkszFjqt2AbfccAzOAIYZu/e2TbiTdO" +
       "Hnw5bNs5gaieTUJylMsrSftRVRElYbXltjwAijI4HrWatk0K2KeUloSkjKlj" +
       "fVa/bPXjf9vTwO1Ahh7LjFadmYHdf04XuumF6z5pYWxCIg3K9p7Z0zjSN9uc" +
       "O3Vd2E7lyN380sIfPSfcCzEDcNqQdmAGvSHT16lQcyFw+8FKV3ZsEGuqDlGY" +
       "He6FbPb57H0B3RjGA7GxS+hrmeF0ErcfOpKshHjbyx/Ujnzw9GmmlTtLc9pE" +
       "n6B1cDOkr+U5YD/HC2IbBGMc5l1weOM1DfLhT4HjKHAUITUx+nVA05zLgszZ" +
       "ZRV//PUzs7e8WILCPahKVoVUj8CcEc0AL8DGOABxTvv6FdwIpirh1cBURQXK" +
       "F3TQg1jkf8TdGY2wQ9nx8zk/vez+AyeZNWqcx3xGX0Fjgwt9GaLbAPDQ7y/+" +
       "w/0/3D/Fs4X2YNTz0M39d7+c3PnWPwu2nOGdTybjoR+NPnzPvNja9xi9DTyU" +
       "ui1XGM8AvG3aNQ9lPgq3lv8mjCpGUYNo5tYjgpyl7jwK+aRhJdyQf7vG3bkh" +
       "T4Q68sC6wAt6jmW9kGfHUWjT2bRd60G5JnqEK+FZYQLACi/KhRBrXMVIVrD3" +
       "Svo6jx1fmKAKTZfg/gWSl4EnCbIHXRqLMCeoOmn7HO26iIMqfV9KX3HO7fJA" +
       "0+zOr3YO7R2Ep91crT1AlU3+qpTQZj+ApMEuI/TXgEeXuUW4g/rrurs2rXdn" +
       "EzRiD2WTBkR+KQNAP2nmyWsGtoi72wb+wq36HB8CPm/WA9FbR17depSFkUqa" +
       "WwxbJ+nIHCAHccSwBi70F/AXgudz+lBhaQfPN5tiZtK7OJ/1Uq8s6l4eBaLT" +
       "TW9M3HPqEa6A15c8k/Hufbd8Edmzj8cGfnVaWnB7cdLw6xNXh74SVLolxVZh" +
       "FD1/PTT95APTu7hUTe6LQDfccx955T9HI3e9+bxPplmRVFUZC0oe4EL59HCm" +
       "+3y4Uuu+V/+r25pKeiAz6UWVWUXalsW9KbffVRjZpOPA7GuZ7YumevRwIHNd" +
       "CefgcYGRL+8CzEjrTI+2PNvPBVR/F0Aeey8twgrsnToKT56uMc+I/hMcbQCF" +
       "EsmsKji2lP6c8OqpnaWeFFjMqfy/j543cD3pSy9ULYiaoEodj0HY4piU9Qg6" +
       "fZaCzoGny1yqK0DQbxcVNIiaoDq4s5M+VmKICbLsJ+53zlLcS+GJmQvGAsS9" +
       "pai4QdQENUoKOCwt42B+czNoOuuDfuzlKEio1zRW//jRIWzCjQ+FY/KeJ385" +
       "OrqiQeST/dDYU7V44P5K8bXMswyNqaTX2giK/BG02ZXIR1ixjEPoQlcy4xXt" +
       "zxsXVKkTA41ctJXBcOslvFU6cOy3H9Xf7JcGsaKcSeqlO3G8ZE01afsBCyCl" +
       "NIBQ1aohVzDoTHpDDSzwMV4chOvoa2/OSp9r7XwP1Kedd7th0lI9IeZmDc9s" +
       "r/nGm1zwJWfQOCH2ZhJDj5/YdRFD6PpJCa5HvNLLi6uzXcVV61bf4So6+u5J" +
       "Qjx16NYjS94daWbVJK4+lZxeJej/taaDhJiDhBGH/vkunUw52J0lIR5dJV1c" +
       "+aeXH+SqLQtQzU1zwz2fH3tn+uTzJagcrqA0qxN0DGknQZGgcq2TQdswtNYB" +
       "FWR7dZxaUsbYeZvn2pTvzd+mCToviDcL7IU1CbgiTGG9S80qKZbwuqNaVVbT" +
       "nKPMQur/V5+5EW6IX2Lr8pqb4EJTV9j1OmaJNFlm8d05CDG9ORbvHBpKDF89" +
       "0J0Y6Rzs7eyKdzNr1WAw1G2Zc4PNhGfcOZ8RXqfNOS8vjttQscj2/bNE4IXw" +
       "dJuKdAcg8M+KInAQNSCwphqGBPvZP4n1KV0yAzioutDvSpwUIt9kQO1R6Yki" +
       "KuVs0c7Ni8b+ypGn9OkQzbGt+Vv6Mj+R6LcCLMN1dx2rAqo6Q92gWjZLCw/u" +
       "3Hcg1X/fagvf0wTuvap2nownsexYOFyA3zy02je71+tuf/sXbWNdZ1MFpH0t" +
       "Z6jz0d+LikcEryjP7Xx33vDa8S1nUdBb5NklL8sH+x5+fv1y8fYw+1TBr5wF" +
       "nzjcRB0eaAC0yeqKO8Vd6i6qLYJntWkFq73mbdtZQXbKnCviU7wKYuYp33hK" +
       "QC2qPhYRNEEcx5GkiGUOSLSQH4nBiTBJXipSAXqFvo5CGsxilF/qWzqpSinb" +
       "Z465faYm7zN5kZocOASGoUspXMTNvkxthnbEeHw74j6FpfCsNzdu/VdxCkHM" +
       "/E+BZapsnVNF9vhd+noLvNUQpvo10XSU4/aevh24p7T79a9k93IEzQn41EBr" +
       "X3MLPnbyD3TiowfqK+cc2PQqw4r8R7Qa8Pp0Vpad1RlHu1zTcVpiytfwWg2/" +
       "EH5I0LzgTyEElfMG0+EfnORjiH8+JHC7sZrO2f8iqMqeTVBYdA1/Bhdkcxju" +
       "dPB2DsLNtQQGoQnRyTLmVb7xhDoaP0mGl3kMDxWGVXbAs84UO/Mkzrq4NwPs" +
       "y/KP1Qnx0IErN15/+qL7eF0eXH7Hjm08cargnwjyYLkkkJvFq3xD+6d1j81Y" +
       "ZoWVRi6w7TzzHaYMl6GQRu1lnqdobbTla9cnDl729LHd5S9B7rsZhQQ4v82F" +
       "xcCcloUotTleWJOwUqWO9ru3r12V/vtrrNyKeCK7IHh+Qhzde7z3sYlPrmDf" +
       "RsvgsHCOVSnXbVcGsTipuwoc/nlnrSvvJKi1sL5zxjyzFgKZ3WMFySKpJyWw" +
       "exw1sK0cienug20m4n2aZiaiJRGN+fVEYOoWamZN2pr5X9HoEaa1IgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HuywWr6rVG29hcJxYiDRQplPNQmdDHyyEktNO69o8Nhaq/1wZ89ai6xW2/bk" +
       "Noe6gtZVGtO1M25HJJw1YGOL7trGMoVRvhs20oGb2yqIUXQZwys7PaDotqg1" +
       "rWYwXo7ceL4eBK3aRtFiiVkolItvLaGVgo3K0q/VTIrBq8HMXLLTfl/NGsTa" +
       "IgSaG3MMWXe7Ft8dLSyfwxbBYOs1cCLKLGeABPMcbEctV5HqzYYhLzetfNpY" +
       "S55KYxzhCZG/mPDT7TqLTVfp62Taqtsg/DXwaJprCSJqGb4mJ0gf7kqyH7ni" +
       "dNDZmhrsemOwqWD8rYdWFpxQR2R9a1brfotvdeTOulMb9nPGraN9sC7VJuOZ" +
       "q+x6Nd7yUiOgYFWtzpggrYdttsXI7ZlfEX1ZQ1mHTNCcV0Xf2sVGOl9VkT7Z" +
       "GFbG+Yrf9fuOMSEqcN9wada2yDY8IvFWJIFw1GhbwSTQebEL9j8o0jW1tZrZ" +
       "iTbrVnvReBozDOExLrvjxxtRaWVmz5NnlQ3h1NaTXjYnQHSMRe26QCOTdR4G" +
       "9Wk6i3YINUMZN6sM++EUbSBwMG6BEAc4Zou0N5W2KocrN7V3y/F6vR5tB0Et" +
       "68FNDbXb6FLy5iJrNdMWn+ekvJw4TYJhE9RxA81TFN6RO6rbc1rVzpjUGlyn" +
       "2wojyWSY+rZdHWQqrjqe4MW8o89HdCoEc7oTJrUQrYrINg7D6Y7Scao1BBE1" +
       "Y+aa3sprYIs9Czc9g422qwjsrUXOXSgiwETe8pPUUxHXcUNuux1RFhqNG3lm" +
       "7/LBipJq88lgx1H+aDdP9SxFI6qiWrqbrKqVTd2typIlWyOWmMKG2F/S3lze" +
       "SNOqHzYWHdLryzI6XGFYcbzyu2/u2OeR8jTr+GLX93GOta96tkiePz4ZLH/X" +
       "oXOXgU6dDJ46gTz+1P78RWd9xe053dGjqFfei/HC4gPZk5fd7io/jn3qQ6+8" +
       "qtG/il49PGCcx9D9sef/sKNvdefUwFdf/xvF/ivLyZfhz33oG0/wP2J+4E3c" +
       "i3n6HJ/nSf765NNfIN6l/vxV6Nrxd+K7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rt2d7fTSuXPsUI+T0OXPfCN+8uzdlKfBgx7OA3r+hPZkpu+ymSulzewt5dwF" +
       "h3OXJJ7ywtWB7MuqqR8oqu7sD8aLe2MHuKfpJYkvvs4dif9QJJ+LoXvLLyAX" +
       "njduPUs7McjPnzXIB48N8pilR0+dh2/1MLQ0/XVs+O7bC2XBvz6ryHeChzhU" +
       "JPH/VJHF6/5K2VdfR01/XiT/GVhzJKe0rwLNFgV/fKKW/3KpWoriP31TCshi" +
       "6PFLLqEVN2reftc12P3VTfW3Xr113+OvCn9a3sM6vl55/xi6z0gc5/TFhlP5" +
       "636oG1Yp5P37aw5++feNGHri8ktyMXR9nymZ//q+yzdj6LELusRg/MPs6dbf" +
       "iqGbJ61j6Kp6pvovY+jGYXUMXQPp6crvgCJQWWT/2j+yu/dc+MGi8In9jAE8" +
       "U9fHWHblzJeYk4l89I2O0o+7nL7kdf5T4CTZX2O+o37m1dH0x7/d/NX9JTPg" +
       "nXleULlvDN3Y33c7hqxnL6V2ROs6+cJ3H/rt+58/gteH9gyf2P8p3p6++EZX" +
       "f+PH5R2s/J89/rvv/aevfrn8evF/AUZOj3ddLgAA");
}
