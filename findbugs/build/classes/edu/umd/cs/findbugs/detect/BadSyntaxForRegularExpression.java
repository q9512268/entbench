package edu.umd.cs.findbugs.detect;
public class BadSyntaxForRegularExpression extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public BadSyntaxForRegularExpression(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    private void singleDotPatternWouldBeSilly(int stackDepth, boolean ignorePasswordMasking) {
        if (ignorePasswordMasking &&
              stackDepth !=
              1) {
            throw new java.lang.IllegalArgumentException(
              "Password masking requires stack depth 1, but is " +
              stackDepth);
        }
        if (stack.
              getStackDepth(
                ) <
              stackDepth) {
            return;
        }
        edu.umd.cs.findbugs.OpcodeStack.Item it =
          stack.
          getStackItem(
            stackDepth);
        java.lang.Object value =
          it.
          getConstant(
            );
        if (value ==
              null ||
              !(value instanceof java.lang.String)) {
            return;
        }
        java.lang.String regex =
          (java.lang.String)
            value;
        boolean dotIsUsed =
          ".".
          equals(
            regex);
        if (!dotIsUsed &&
              !"|".
              equals(
                regex)) {
            return;
        }
        int priority =
          HIGH_PRIORITY;
        if (ignorePasswordMasking &&
              dotIsUsed) {
            priority =
              NORMAL_PRIORITY;
            edu.umd.cs.findbugs.OpcodeStack.Item top =
              stack.
              getStackItem(
                0);
            java.lang.Object topValue =
              top.
              getConstant(
                );
            if (topValue instanceof java.lang.String) {
                java.lang.String replacementString =
                  (java.lang.String)
                    topValue;
                if ("x".
                      equals(
                        replacementString.
                          toLowerCase(
                            )) ||
                      "-".
                      equals(
                        replacementString) ||
                      "*".
                      equals(
                        replacementString) ||
                      " ".
                      equals(
                        replacementString) ||
                      "\\*".
                      equals(
                        replacementString)) {
                    return;
                }
                if (replacementString.
                      length(
                        ) ==
                      1 &&
                      getMethodName(
                        ).
                      toLowerCase(
                        ).
                      indexOf(
                        "pass") >=
                      0) {
                    priority =
                      LOW_PRIORITY;
                }
            }
        }
        bugReporter.
          reportBug(
            new edu.umd.cs.findbugs.BugInstance(
              this,
              "RE_POSSIBLE_UNINTENDED_PATTERN",
              priority).
              addClassAndMethod(
                this).
              addCalledMethod(
                this).
              addSourceLine(
                this));
    }
    private void sawRegExPattern(int stackDepth) { sawRegExPattern(
                                                     stackDepth,
                                                     0); }
    private void sawRegExPattern(int stackDepth, int flags) {
        if (stack.
              getStackDepth(
                ) <
              stackDepth) {
            return;
        }
        edu.umd.cs.findbugs.OpcodeStack.Item it =
          stack.
          getStackItem(
            stackDepth);
        if (it.
              getSpecialKind(
                ) ==
              edu.umd.cs.findbugs.OpcodeStack.Item.
                FILE_SEPARATOR_STRING &&
              (flags &
                 java.util.regex.Pattern.
                   LITERAL) ==
              0) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "RE_CANT_USE_FILE_SEPARATOR_AS_REGULAR_EXPRESSION",
                  HIGH_PRIORITY).
                  addClassAndMethod(
                    this).
                  addCalledMethod(
                    this).
                  addSourceLine(
                    this));
            return;
        }
        java.lang.Object value =
          it.
          getConstant(
            );
        if (value ==
              null ||
              !(value instanceof java.lang.String)) {
            return;
        }
        java.lang.String regex =
          (java.lang.String)
            value;
        try {
            java.util.regex.Pattern.
              compile(
                regex,
                flags);
        }
        catch (java.util.regex.PatternSyntaxException e) {
            java.lang.String message =
              e.
              getMessage(
                );
            int eol =
              message.
              indexOf(
                '\n');
            if (eol >
                  0) {
                message =
                  message.
                    substring(
                      0,
                      eol);
            }
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "RE_BAD_SYNTAX_FOR_REGULAR_EXPRESSION",
              HIGH_PRIORITY).
              addClassAndMethod(
                this).
              addCalledMethod(
                this).
              addString(
                message).
              describe(
                edu.umd.cs.findbugs.StringAnnotation.
                  ERROR_MSG_ROLE).
              addString(
                regex).
              describe(
                edu.umd.cs.findbugs.StringAnnotation.
                  REGEX_ROLE);
            java.lang.String options =
              getOptions(
                flags);
            if (options.
                  length(
                    ) >
                  0) {
                bug.
                  addString(
                    "Regex flags: " +
                    options).
                  describe(
                    edu.umd.cs.findbugs.StringAnnotation.
                      STRING_MESSAGE);
            }
            bug.
              addSourceLine(
                this);
            bugReporter.
              reportBug(
                bug);
        }
    }
    private int getIntValue(int stackDepth, int defaultValue) {
        if (stack.
              getStackDepth(
                ) <
              stackDepth) {
            return defaultValue;
        }
        edu.umd.cs.findbugs.OpcodeStack.Item it =
          stack.
          getStackItem(
            stackDepth);
        java.lang.Object value =
          it.
          getConstant(
            );
        if (value ==
              null ||
              !(value instanceof java.lang.Integer)) {
            return defaultValue;
        }
        return ((java.lang.Number)
                  value).
          intValue(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKESTATIC &&
                                            "java/util/regex/Pattern".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "compile".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            getSigConstantOperand(
                                              ).
                                            startsWith(
                                              "(Ljava/lang/String;I)")) {
                                          sawRegExPattern(
                                            1,
                                            getIntValue(
                                              0,
                                              0));
                                      }
                                      else
                                          if (seen ==
                                                INVOKESTATIC &&
                                                "java/util/regex/Pattern".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "compile".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                getSigConstantOperand(
                                                  ).
                                                startsWith(
                                                  "(Ljava/lang/String;)")) {
                                              sawRegExPattern(
                                                0);
                                          }
                                          else
                                              if (seen ==
                                                    INVOKESTATIC &&
                                                    "java/util/regex/Pattern".
                                                    equals(
                                                      getClassConstantOperand(
                                                        )) &&
                                                    "matches".
                                                    equals(
                                                      getNameConstantOperand(
                                                        ))) {
                                                  sawRegExPattern(
                                                    1);
                                              }
                                              else
                                                  if (seen ==
                                                        INVOKEVIRTUAL &&
                                                        "java/lang/String".
                                                        equals(
                                                          getClassConstantOperand(
                                                            )) &&
                                                        "replaceAll".
                                                        equals(
                                                          getNameConstantOperand(
                                                            ))) {
                                                      sawRegExPattern(
                                                        1);
                                                      singleDotPatternWouldBeSilly(
                                                        1,
                                                        true);
                                                  }
                                                  else
                                                      if (seen ==
                                                            INVOKEVIRTUAL &&
                                                            "java/lang/String".
                                                            equals(
                                                              getClassConstantOperand(
                                                                )) &&
                                                            "replaceFirst".
                                                            equals(
                                                              getNameConstantOperand(
                                                                ))) {
                                                          sawRegExPattern(
                                                            1);
                                                          singleDotPatternWouldBeSilly(
                                                            1,
                                                            false);
                                                      }
                                                      else
                                                          if (seen ==
                                                                INVOKEVIRTUAL &&
                                                                "java/lang/String".
                                                                equals(
                                                                  getClassConstantOperand(
                                                                    )) &&
                                                                "matches".
                                                                equals(
                                                                  getNameConstantOperand(
                                                                    ))) {
                                                              sawRegExPattern(
                                                                0);
                                                              singleDotPatternWouldBeSilly(
                                                                0,
                                                                false);
                                                          }
                                                          else
                                                              if (seen ==
                                                                    INVOKEVIRTUAL &&
                                                                    "java/lang/String".
                                                                    equals(
                                                                      getClassConstantOperand(
                                                                        )) &&
                                                                    "split".
                                                                    equals(
                                                                      getNameConstantOperand(
                                                                        ))) {
                                                                  sawRegExPattern(
                                                                    0);
                                                                  singleDotPatternWouldBeSilly(
                                                                    0,
                                                                    false);
                                                              }
    }
    static void appendOption(java.lang.StringBuilder b,
                             int flags,
                             int mask,
                             java.lang.String name) {
        if ((flags &
               mask) ==
              0) {
            return;
        }
        if (b.
              length(
                ) >
              0) {
            b.
              append(
                " | ");
        }
        b.
          append(
            "Pattern." +
            name);
    }
    static java.lang.String getOptions(int flags) {
        java.lang.StringBuilder b =
          new java.lang.StringBuilder(
          );
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            CANON_EQ,
          "CANON_EQ");
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            CASE_INSENSITIVE,
          "CASE_INSENSITIVE");
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            COMMENTS,
          "COMMENTS");
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            DOTALL,
          "DOTALL");
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            LITERAL,
          "LITERAL");
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            MULTILINE,
          "MULTILINE");
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            UNICODE_CASE,
          "UNICODE_CASE");
        appendOption(
          b,
          flags,
          java.util.regex.Pattern.
            UNIX_LINES,
          "UNIX_LINES");
        return b.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a45E/gOVdD51+B4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06C6zrSHV+d9++t/t22fd2gYUuu8t+HpTd0OvYsWNHC5TE" +
       "TmInTuwkdn6lLP7biX/xJ3FCl/IRBRWVIrpQqGBVJOgHLZ+i0iJVVIsqCghE" +
       "RUv/LSDUqlCKBKpKq9KWjp17b+697+2D1dJG8mQ8c86Zc86cc+Z4Zh7/NnR9" +
       "FEKFwHfWpuPH+3oa788cfD9eB3q03+JwQQ4jXaMcOYpE0Pawet9HL37v+2+z" +
       "Lu1B56bQM2XP82M5tn0v6uuR7yx1jYMu7lrrju5GMXSJm8lLGU5i24E5O4of" +
       "4qCbjqHG0GXukAUYsAADFuCcBbi6gwJIz9C9xKUyDNmLowX0GugMB50L1Iy9" +
       "GLr3JJFADmX3gIyQSwAo3JC9D4FQOXIaQvccyb6V+QqB31GAH/3VV1762HXQ" +
       "xSl00fYGGTsqYCIGg0yhm13dVfQwqmqark2hWz1d1wZ6aMuOvcn5nkK3Rbbp" +
       "yXES6kdKyhqTQA/zMXeau1nNZAsTNfbDI/EMW3e0w7frDUc2gay372TdStjI" +
       "2oGAF2zAWGjIqn6IcnZue1oMPf80xpGMl9sAAKCed/XY8o+GOuvJoAG6bTt3" +
       "juyZ8CAObc8EoNf7CRglhu54UqKZrgNZncum/nAMPfc0nLDtAlA35orIUGLo" +
       "2afBckpglu44NUvH5ufb3Ze89dUe4+3lPGu66mT83wCQ7j6F1NcNPdQ9Vd8i" +
       "3vwg90759k++eQ+CAPCzTwFvYX7/57778hff/cRntzDPuwoMr8x0NX5Yfb9y" +
       "y5fupB6oXJexcUPgR3Y2+Sckz81fOOh5KA2A591+RDHr3D/sfKL/x5PXflD/" +
       "1h50gYXOqb6TuMCOblV9N7AdPWzqnh7Ksa6x0I26p1F5PwudB3XO9vRtK28Y" +
       "kR6z0Fknbzrn5+9ARQYgkanoPKjbnuEf1gM5tvJ6GkAQdB480M3guQfa/vL/" +
       "GPJhy3d1WFZlz/Z8WAj9TP4I1r1YAbq1YAMYk5KYERyFKpybjq4lcOJqsBrt" +
       "OjU9BmhwTdYGay+W04Yf9nUzceSwngbAUSKghf0MO/j/HzLNtHBpdeYMmKA7" +
       "T4cHB3gW4zuaHj6sPprU6t/98MOf3ztylwP9xRAJONgHHOyr0f4hB/tbDvav" +
       "yQF05kw+8LMyTrZWAeZ0DqIDiJs3PzD42dar3nzfdcAcg9VZMCEZKPzk4Zva" +
       "xRM2j5oqMGroiXetXjf8+eIetHcyDmfcg6YLGbqQRc+jKHn5tP9dje7FN33j" +
       "ex955yP+zhNPBPaDAHElZubg953Wc+irQIWhviP/4D3yxx/+5COX96CzIGqA" +
       "SBnLwLJBELr79BgnHP2hw6CZyXI9ENjwQ1d2sq7DSHchtkJ/tWvJDeCWvH4r" +
       "0PFNmeW/CDyXD1wh/896nxlk5bO2BpNN2ikp8qD80kHw3r/64jdLuboP4/fF" +
       "YyviQI8fOhYzMmIX8+hw684GxFDXAdzfv0v4lXd8+00/kxsAgLj/agNezkoK" +
       "xAowhUDNb/zs4q+/+pX3f3lvZzQxWDQTxbHV9EjIrB26cA0hwWgv3PEDYo4D" +
       "bDmzmsuS5/qabdiy4uiZlf7XxRcgH/+Xt17a2oEDWg7N6MU/nMCu/Sdq0Gs/" +
       "/8p/vzsnc0bN1rydznZg20D6zB3lahjK64yP9HV/ete7PyO/F4RkEAYje6Pn" +
       "ke3MgeNkTD0brItX89RaYvb1wA/BIpdPLpxDP5iX+5lichpQ3lfKiudHx53k" +
       "pB8ey2EeVt/25e88Y/idP/xuLtXJJOi4TXTk4KGtGWbFPSkg/5zTEYGRIwvA" +
       "YU90X3HJeeL7gOIUUFTByh/xIQhQ6QkLOoC+/vzffOqPbn/Vl66D9hrQBceX" +
       "tYacOyN0I/ACPbJAbEuDn3751ghWN4DiUi4qdIXwW+N5bv52FjD4wJPHoUaW" +
       "w+xc+bn/yTvK67/+H1coIY9AV1m6T+FP4cffcwf1sm/l+LtQkGHfnV4ZtEG+" +
       "t8NFP+j+29595z69B52fQpfUg2RyKDtJ5mBTkEBFhxkmSDhP9J9MhrYr/0NH" +
       "oe7O02Ho2LCng9BusQD1DDqrXzgVd3It3wme+w5c8r7TcecMlFeqOcq9eXk5" +
       "K37yYIa2pH4AfmfA8z/Zk7VnDdvV/DbqIKW45yinCMDqdZOys/+MRHEb4LIS" +
       "y4raljLxpGbykqyop2dApLke3Sf2cwKtq7N5XVZ9EQhJUZ5ZAwzghrKTK6Me" +
       "A7N31MuHbA5Bpg3s5PLMIQ7991Ju4tmM7G/T01O81n9kXoEJ37Ijxvkg033L" +
       "P7ztC798/1eBnbWg65eZDQDzOjZiN8mS/194/B133fTo196SR1gQWgYPKP/6" +
       "8oyqdC2Js6KbFfyhqHdkog78JFR1To7iTh4UdS2X9pruJYS2C9aO5UFmCz9y" +
       "21fn7/nGh7ZZ62lfOgWsv/nRX/zB/lsf3Tv2rXD/Fen6cZzt90LO9DMONBxC" +
       "915rlByj8U8feeQPfuuRN225uu1k5lsHH3Yf+ov//sL+u772uaukU2cd/2lM" +
       "bHxRYLCIrR7+OGRKT1IJ6Y8KHWIZcWHEJevNmoXJqJ0q9aZSswepGhMcG9qk" +
       "kEwtNR0PNrQnaqWpVSB1HU5LHkpEiL2YOIHfXM2H/eZCcqoDujuw3XDkKkM/" +
       "Sof+GrU1pVwsTlbxyEV6dhAs5kggkwWcIBBcgHk6aI/EJR0viVnJKzFJQS8Q" +
       "eDIWSKbmeE23x0sltzMreJ0ZMwqWLVJuzeNSO+4Vu8WaIXkL017iCFlKKu1y" +
       "ez71rQ7TVlzdd+WwEbuD2FfZsOsgel9yprPpGjFl3vC701lrZjGtqYQZbKPr" +
       "RWvdbXMdh1xOp+6Ao/pNc762x61kTblclOJMldI3dYIaJA2rZTBDLKGRWtMe" +
       "dhlYYAN4yfKl4mzQ8jb4jMVlCY+CQaeoeI2pPdDmc8Lw6HG7G9rObCSNZ52p" +
       "4kVyqa2aOqVNPKffp4pC7AEVDSsrskiZkSMNRSlB6A7jtucBu15rbB3RFdyg" +
       "1GSKks5w4AyqXcFt8ajFJQHTnHSrZTGJg/KQo8uUtEbUAJUlVifmblCk+kZ9" +
       "bazNeqsod3mdLfe1sGY6SKnb0Dosj5KrUEYdf7QYz+CuUadpNE1gDxvKfd8W" +
       "FbZsd5L+pFZXW9ac6jXmSdpLN5oYdovz7nxuLhRBNTvuIFzTru6Niit8gbSS" +
       "lSETUZPyArFLb3jHqhkRm1juKKVHM7+BN5stcSMjadMfej1NXniLMmJ1YZk2" +
       "l9Ka62xYiasSVnlYdstrl5/OFdye+Sgz4erVWqhMiHQiF1dDZdj2J3wRpWRb" +
       "oiWFWYmiRHSr/Byjq5se5g4bo3azHUvoXNko7HzkDtgwJvXqIkyrpjXHRv22" +
       "W09Z00HluuY7JbislhEUr6xwJOz7Tn1obdz5vB2GZM3l5bpbnU4sa97Z+EwX" +
       "5UxMndZ4YxwITq1qehZrx65TqLTGmwWudPix1w4CZ2ouJst4OmwJ1FwTJYSc" +
       "DhXPt4bDhF2Vx2LXKQnrKp60pYoYzYjxXBM6G8mc99QZ59KtlVYg5RHBuB2j" +
       "X3cqdNntdzvjttlHuvNwoHL2spO03GDTptRgvGT1tuzy5BADcI0KNog6YVLi" +
       "8E7a1EkLmYT+ImbqClb1q2u253sB5lRGHTwkQqda4CpEylNtt2FtRKqDwRMG" +
       "Zrp2f2IgHhuJ9mixXvgjYqMWkW6hY5Jaq6ooNNlbTSQybLseI855jtIaM9l2" +
       "ElxrrNZLtV7EyOqIKNPBSmwOi6V1aWquV2F72PPXyXJVrKfViTRRkyUMr72N" +
       "3eHmRcmsd11rhNJFX+W4kTxfyE3JC8zuuK8Z5RZeT9Cy3khVg57hAr8yLTti" +
       "KXnaGauNzjhqRBOQwrWarCuY7THrxA2F8lCySphMnIxpEcPHQ6US9kem6C38" +
       "ymjFSjO5aVqiN8U41UAK0izsd1yGgbsC5/nJoGz2A7/fLi3YVn9KjPq1Mekq" +
       "Y543mp12NTDH/YKCY6bZ7NV5sUehtDOJvFnQKyuT3hTtwK2GiLWUQKTJdLVk" +
       "0G47DAqqQPfLFXJCOMVpq1szy2onSDFh1Fv2Sc2ImmmMDbW+7eKisjQKhVl9" +
       "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");
}
