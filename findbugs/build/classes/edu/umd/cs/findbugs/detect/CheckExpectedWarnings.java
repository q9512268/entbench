package edu.umd.cs.findbugs.detect;
public class CheckExpectedWarnings implements edu.umd.cs.findbugs.Detector2, edu.umd.cs.findbugs.NonReportingDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "cew.debug");
    private edu.umd.cs.findbugs.BugReporter reporter;
    private final edu.umd.cs.findbugs.BugCollection bugCollection;
    private boolean initialized = false;
    private java.util.Map<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Collection<edu.umd.cs.findbugs.BugInstance>>
      warningsByClass;
    private java.util.Map<edu.umd.cs.findbugs.classfile.MethodDescriptor,java.util.Collection<edu.umd.cs.findbugs.BugInstance>>
      warningsByMethod;
    private java.util.Map<edu.umd.cs.findbugs.classfile.FieldDescriptor,java.util.Collection<edu.umd.cs.findbugs.BugInstance>>
      warningsByField;
    private edu.umd.cs.findbugs.classfile.ClassDescriptor
      expectWarning;
    private edu.umd.cs.findbugs.classfile.ClassDescriptor
      noWarning;
    private edu.umd.cs.findbugs.classfile.ClassDescriptor
      desireWarning;
    private edu.umd.cs.findbugs.classfile.ClassDescriptor
      desireNoWarning;
    private boolean warned;
    public CheckExpectedWarnings(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        bugCollection =
          bugReporter.
            getBugCollection(
              );
        if (bugCollection !=
              null) {
            reporter =
              bugReporter;
            expectWarning =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
                createClassDescriptor(
                  edu.umd.cs.findbugs.annotations.ExpectWarning.class);
            noWarning =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
                createClassDescriptor(
                  edu.umd.cs.findbugs.annotations.NoWarning.class);
            desireWarning =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
                createClassDescriptor(
                  edu.umd.cs.findbugs.annotations.DesireWarning.class);
            desireNoWarning =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
                createClassDescriptor(
                  edu.umd.cs.findbugs.annotations.DesireNoWarning.class);
        }
    }
    @java.lang.Override
    public void visitClass(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        if (reporter ==
              null) {
            if (!warned) {
                java.lang.System.
                  err.
                  println(
                    ("*** NOTE ***: CheckExpectedWarnings disabled because bug rep" +
                     "orter doesn\'t use a BugCollection"));
                warned =
                  true;
            }
            return;
        }
        if (!initialized) {
            initialized =
              true;
            warningsByClass =
              new java.util.HashMap<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Collection<edu.umd.cs.findbugs.BugInstance>>(
                );
            warningsByMethod =
              new java.util.HashMap<edu.umd.cs.findbugs.classfile.MethodDescriptor,java.util.Collection<edu.umd.cs.findbugs.BugInstance>>(
                );
            warningsByField =
              new java.util.HashMap<edu.umd.cs.findbugs.classfile.FieldDescriptor,java.util.Collection<edu.umd.cs.findbugs.BugInstance>>(
                );
            for (java.util.Iterator<edu.umd.cs.findbugs.BugInstance> i =
                   bugCollection.
                   iterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.BugInstance warning =
                  i.
                  next(
                    );
                edu.umd.cs.findbugs.MethodAnnotation method =
                  warning.
                  getPrimaryMethod(
                    );
                if (method !=
                      null) {
                    edu.umd.cs.findbugs.classfile.MethodDescriptor methodDesc =
                      method.
                      toMethodDescriptor(
                        );
                    java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings =
                      warningsByMethod.
                      get(
                        methodDesc);
                    if (warnings ==
                          null) {
                        warnings =
                          new java.util.LinkedList<edu.umd.cs.findbugs.BugInstance>(
                            );
                        warningsByMethod.
                          put(
                            methodDesc,
                            warnings);
                    }
                    warnings.
                      add(
                        warning);
                }
                edu.umd.cs.findbugs.FieldAnnotation field =
                  warning.
                  getPrimaryField(
                    );
                if (field !=
                      null) {
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "primary field of " +
                            field +
                            " for " +
                            warning);
                    }
                    edu.umd.cs.findbugs.classfile.FieldDescriptor fieldDescriptor =
                      field.
                      toFieldDescriptor(
                        );
                    java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings =
                      warningsByField.
                      get(
                        fieldDescriptor);
                    if (warnings ==
                          null) {
                        warnings =
                          new java.util.LinkedList<edu.umd.cs.findbugs.BugInstance>(
                            );
                        warningsByField.
                          put(
                            fieldDescriptor,
                            warnings);
                    }
                    warnings.
                      add(
                        warning);
                }
                edu.umd.cs.findbugs.ClassAnnotation clazz =
                  warning.
                  getPrimaryClass(
                    );
                if (clazz !=
                      null) {
                    edu.umd.cs.findbugs.classfile.ClassDescriptor classDesc =
                      clazz.
                      getClassDescriptor(
                        );
                    if (field !=
                          null &&
                          classDesc.
                          equals(
                            field.
                              getClassDescriptor(
                                ))) {
                        continue;
                    }
                    if (method !=
                          null &&
                          classDesc.
                          equals(
                            method.
                              getClassDescriptor(
                                ))) {
                        continue;
                    }
                    java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings =
                      warningsByClass.
                      get(
                        classDesc);
                    if (warnings ==
                          null) {
                        warnings =
                          new java.util.LinkedList<edu.umd.cs.findbugs.BugInstance>(
                            );
                        warningsByClass.
                          put(
                            classDesc,
                            warnings);
                    }
                    warnings.
                      add(
                        warning);
                }
            }
        }
        edu.umd.cs.findbugs.ba.XClass xclass =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getClassAnalysis(
            edu.umd.cs.findbugs.ba.XClass.class,
            classDescriptor);
        java.util.List<? extends edu.umd.cs.findbugs.ba.XMethod> methods =
          xclass.
          getXMethods(
            );
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "CEW: checking " +
                xclass.
                  toString(
                    ));
        }
        if (xclass.
              isSynthetic(
                )) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Skipping synthetic classxclass " +
                    xclass.
                      toString(
                        ));
            }
            return;
        }
        check(
          xclass,
          expectWarning,
          true,
          HIGH_PRIORITY);
        check(
          xclass,
          desireWarning,
          true,
          NORMAL_PRIORITY);
        check(
          xclass,
          noWarning,
          false,
          HIGH_PRIORITY);
        check(
          xclass,
          desireNoWarning,
          false,
          NORMAL_PRIORITY);
        for (edu.umd.cs.findbugs.ba.XMethod xmethod
              :
              methods) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "CEW: checking " +
                    xmethod.
                      toString(
                        ));
            }
            if (xmethod.
                  isSynthetic(
                    )) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Skipping synthetic method " +
                        xmethod.
                          toString(
                            ));
                }
                continue;
            }
            check(
              xmethod,
              expectWarning,
              true,
              HIGH_PRIORITY);
            check(
              xmethod,
              desireWarning,
              true,
              NORMAL_PRIORITY);
            check(
              xmethod,
              noWarning,
              false,
              HIGH_PRIORITY);
            check(
              xmethod,
              desireNoWarning,
              false,
              NORMAL_PRIORITY);
        }
        for (edu.umd.cs.findbugs.ba.XField xfield
              :
              xclass.
               getXFields(
                 )) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "CEW: checking " +
                    xfield.
                      toString(
                        ));
            }
            if (xfield.
                  isSynthetic(
                    )) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Skipping synthetic field " +
                        xfield.
                          toString(
                            ));
                }
                continue;
            }
            check(
              xfield,
              expectWarning,
              true,
              HIGH_PRIORITY);
            check(
              xfield,
              desireWarning,
              true,
              NORMAL_PRIORITY);
            check(
              xfield,
              noWarning,
              false,
              HIGH_PRIORITY);
            check(
              xfield,
              desireNoWarning,
              false,
              NORMAL_PRIORITY);
        }
    }
    private void check(edu.umd.cs.findbugs.ba.XClass xclass,
                       edu.umd.cs.findbugs.classfile.ClassDescriptor annotation,
                       boolean expectWarnings,
                       int priority) { edu.umd.cs.findbugs.classfile.analysis.AnnotationValue expect =
                                         xclass.
                                         getAnnotation(
                                           annotation);
                                       if (expect ==
                                             null) {
                                           return;
                                       }
                                       if (DEBUG) {
                                           java.lang.System.
                                             out.
                                             println(
                                               "*** Found " +
                                               annotation +
                                               " annotation on " +
                                               xclass);
                                       }
                                       edu.umd.cs.findbugs.classfile.ClassDescriptor descriptor =
                                         xclass.
                                         getClassDescriptor(
                                           );
                                       java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings =
                                         warningsByClass.
                                         get(
                                           descriptor);
                                       check(
                                         expect,
                                         descriptor,
                                         warnings,
                                         expectWarnings,
                                         priority,
                                         descriptor);
    }
    private void check(edu.umd.cs.findbugs.ba.XMethod xmethod,
                       edu.umd.cs.findbugs.classfile.ClassDescriptor annotation,
                       boolean expectWarnings,
                       int priority) { edu.umd.cs.findbugs.classfile.analysis.AnnotationValue expect =
                                         xmethod.
                                         getAnnotation(
                                           annotation);
                                       if (expect ==
                                             null) {
                                           return;
                                       }
                                       if (DEBUG) {
                                           java.lang.System.
                                             out.
                                             println(
                                               "*** Found " +
                                               annotation +
                                               " annotation on " +
                                               xmethod);
                                       }
                                       edu.umd.cs.findbugs.classfile.FieldOrMethodDescriptor descriptor =
                                         xmethod.
                                         getMethodDescriptor(
                                           );
                                       java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings =
                                         warningsByMethod.
                                         get(
                                           descriptor);
                                       check(
                                         expect,
                                         descriptor,
                                         warnings,
                                         expectWarnings,
                                         priority,
                                         descriptor.
                                           getClassDescriptor(
                                             ));
    }
    private void check(edu.umd.cs.findbugs.ba.XField xfield,
                       edu.umd.cs.findbugs.classfile.ClassDescriptor annotation,
                       boolean expectWarnings,
                       int priority) { edu.umd.cs.findbugs.classfile.analysis.AnnotationValue expect =
                                         xfield.
                                         getAnnotation(
                                           annotation);
                                       if (expect ==
                                             null) {
                                           return;
                                       }
                                       if (DEBUG) {
                                           java.lang.System.
                                             out.
                                             println(
                                               "*** Found " +
                                               annotation +
                                               " annotation on " +
                                               xfield);
                                       }
                                       edu.umd.cs.findbugs.classfile.FieldOrMethodDescriptor descriptor =
                                         xfield.
                                         getFieldDescriptor(
                                           );
                                       java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings =
                                         warningsByField.
                                         get(
                                           descriptor);
                                       check(
                                         expect,
                                         descriptor,
                                         warnings,
                                         expectWarnings,
                                         priority,
                                         descriptor.
                                           getClassDescriptor(
                                             ));
    }
    private void check(edu.umd.cs.findbugs.classfile.analysis.AnnotationValue expect,
                       java.lang.Object descriptor,
                       java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings,
                       boolean expectWarnings,
                       int priority,
                       edu.umd.cs.findbugs.classfile.ClassDescriptor cd) {
        if (expect !=
              null) {
            java.lang.String expectedBugCodes =
              (java.lang.String)
                expect.
                getValue(
                  "value");
            edu.umd.cs.findbugs.classfile.analysis.EnumValue wantedConfidence =
              (edu.umd.cs.findbugs.classfile.analysis.EnumValue)
                expect.
                getValue(
                  "confidence");
            edu.umd.cs.findbugs.classfile.analysis.EnumValue wantedPriority =
              (edu.umd.cs.findbugs.classfile.analysis.EnumValue)
                expect.
                getValue(
                  "priority");
            java.lang.Integer num =
              (java.lang.Integer)
                expect.
                getValue(
                  "num");
            if (num ==
                  null) {
                num =
                  expectWarnings
                    ? 1
                    : 0;
            }
            java.lang.Integer rank =
              (java.lang.Integer)
                expect.
                getValue(
                  "rank");
            if (rank ==
                  null) {
                rank =
                  edu.umd.cs.findbugs.BugRanker.
                    VISIBLE_RANK_MAX;
            }
            int minPriority =
              edu.umd.cs.findbugs.annotations.Confidence.
                LOW.
              getConfidenceValue(
                );
            if (wantedConfidence !=
                  null) {
                minPriority =
                  edu.umd.cs.findbugs.annotations.Confidence.
                    valueOf(
                      wantedConfidence.
                        value).
                    getConfidenceValue(
                      );
            }
            else
                if (wantedPriority !=
                      null) {
                    minPriority =
                      edu.umd.cs.findbugs.annotations.Priority.
                        valueOf(
                          wantedPriority.
                            value).
                        getPriorityValue(
                          );
                }
            if (DEBUG) {
                if (warnings ==
                      null) {
                    java.lang.System.
                      out.
                      println(
                        "Checking " +
                        expectedBugCodes +
                        " against no bugs");
                }
                else {
                    java.lang.System.
                      out.
                      println(
                        "Checking " +
                        expectedBugCodes +
                        " against " +
                        warnings.
                          size(
                            ) +
                        " bugs");
                    for (edu.umd.cs.findbugs.BugInstance b
                          :
                          warnings) {
                        java.lang.System.
                          out.
                          println(
                            "  " +
                            b.
                              getType(
                                ));
                    }
                }
            }
            if (expectedBugCodes ==
                  null ||
                  expectedBugCodes.
                  trim(
                    ).
                  length(
                    ) ==
                  0) {
                checkAnnotation(
                  null,
                  warnings,
                  expectWarnings,
                  priority,
                  rank,
                  num,
                  descriptor,
                  minPriority,
                  cd);
            }
            else {
                java.util.StringTokenizer tok =
                  new java.util.StringTokenizer(
                  expectedBugCodes,
                  ",");
                while (tok.
                         hasMoreTokens(
                           )) {
                    java.lang.String bugCode =
                      tok.
                      nextToken(
                        ).
                      trim(
                        );
                    checkAnnotation(
                      bugCode,
                      warnings,
                      expectWarnings,
                      priority,
                      rank,
                      num,
                      descriptor,
                      minPriority,
                      cd);
                }
            }
        }
    }
    public void checkAnnotation(@javax.annotation.CheckForNull
                                java.lang.String bugCode,
                                java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings,
                                boolean expectWarnings,
                                int priority,
                                java.lang.Integer rank,
                                java.lang.Integer num,
                                java.lang.Object methodDescriptor,
                                int minPriority,
                                edu.umd.cs.findbugs.classfile.ClassDescriptor cd) {
        java.lang.String bugCodeMessage =
          bugCode !=
          null
          ? bugCode
          : "any bug";
        java.util.Collection<edu.umd.cs.findbugs.SourceLineAnnotation> bugs =
          countWarnings(
            warnings,
            bugCode,
            minPriority,
            rank);
        if (expectWarnings &&
              bugs.
              size(
                ) <
              num) {
            if (edu.umd.cs.findbugs.DetectorFactoryCollection.
                  instance(
                    ).
                  isDisabledByDefault(
                    bugCode)) {
                return;
            }
            edu.umd.cs.findbugs.BugInstance bug =
              makeWarning(
                "FB_MISSING_EXPECTED_WARNING",
                methodDescriptor,
                priority,
                cd).
              addString(
                bugCodeMessage);
            if (!bugs.
                  isEmpty(
                    )) {
                bug.
                  addString(
                    java.lang.String.
                      format(
                        "Expected %d bugs, saw %d",
                        num,
                        bugs.
                          size(
                            )));
            }
            reporter.
              reportBug(
                bug);
        }
        else
            if (bugs.
                  size(
                    ) >
                  num) {
                edu.umd.cs.findbugs.BugInstance bug =
                  makeWarning(
                    "FB_UNEXPECTED_WARNING",
                    methodDescriptor,
                    priority,
                    cd).
                  addString(
                    bugCodeMessage);
                if (!expectWarnings) {
                    for (edu.umd.cs.findbugs.SourceLineAnnotation s
                          :
                          bugs) {
                        reporter.
                          reportBug(
                            bug.
                              add(
                                s));
                    }
                }
                else
                    if (num >
                          1) {
                        bug.
                          addString(
                            java.lang.String.
                              format(
                                "Expected %d bugs, saw %d",
                                num,
                                bugs.
                                  size(
                                    )));
                        reporter.
                          reportBug(
                            bug);
                    }
            }
    }
    public edu.umd.cs.findbugs.BugInstance makeWarning(java.lang.String bugPattern,
                                                       java.lang.Object descriptor,
                                                       int priority,
                                                       edu.umd.cs.findbugs.classfile.ClassDescriptor cd) {
        edu.umd.cs.findbugs.BugInstance bug =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          bugPattern,
          priority).
          addClass(
            cd);
        if (descriptor instanceof edu.umd.cs.findbugs.classfile.FieldDescriptor) {
            bug.
              addField(
                (edu.umd.cs.findbugs.classfile.FieldDescriptor)
                  descriptor);
        }
        else
            if (descriptor instanceof edu.umd.cs.findbugs.classfile.MethodDescriptor) {
                bug.
                  addMethod(
                    (edu.umd.cs.findbugs.classfile.MethodDescriptor)
                      descriptor);
            }
            else
                if (descriptor instanceof edu.umd.cs.findbugs.classfile.ClassDescriptor) {
                    bug.
                      addClass(
                        (edu.umd.cs.findbugs.classfile.ClassDescriptor)
                          descriptor);
                }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Reporting " +
                bug);
        }
        return bug;
    }
    private static java.util.Collection<edu.umd.cs.findbugs.SourceLineAnnotation> countWarnings(java.util.Collection<edu.umd.cs.findbugs.BugInstance> warnings,
                                                                                                @javax.annotation.CheckForNull
                                                                                                java.lang.String bugCode,
                                                                                                int desiredPriority,
                                                                                                int rank) {
        java.util.Collection<edu.umd.cs.findbugs.SourceLineAnnotation> matching =
          new java.util.HashSet<edu.umd.cs.findbugs.SourceLineAnnotation>(
          );
        edu.umd.cs.findbugs.DetectorFactoryCollection i18n =
          edu.umd.cs.findbugs.DetectorFactoryCollection.
          instance(
            );
        boolean matchPattern =
          false;
        try {
            i18n.
              getBugCode(
                bugCode);
        }
        catch (java.lang.IllegalArgumentException e) {
            matchPattern =
              true;
        }
        if (warnings !=
              null) {
            for (edu.umd.cs.findbugs.BugInstance warning
                  :
                  warnings) {
                if (warning.
                      getPriority(
                        ) >
                      desiredPriority) {
                    continue;
                }
                if (warning.
                      getBugRank(
                        ) >
                      rank) {
                    continue;
                }
                if (bugCode ==
                      null) {
                    matching.
                      add(
                        warning.
                          getPrimarySourceLineAnnotation(
                            ));
                    matching.
                      addAll(
                        warning.
                          getAnotherInstanceSourceLineAnnotations(
                            ));
                    continue;
                }
                edu.umd.cs.findbugs.BugPattern pattern =
                  warning.
                  getBugPattern(
                    );
                java.lang.String match;
                if (matchPattern) {
                    match =
                      pattern.
                        getType(
                          );
                }
                else {
                    match =
                      pattern.
                        getAbbrev(
                          );
                }
                if (match.
                      equals(
                        bugCode)) {
                    matching.
                      add(
                        warning.
                          getPrimarySourceLineAnnotation(
                            ));
                    matching.
                      addAll(
                        warning.
                          getAnotherInstanceSourceLineAnnotations(
                            ));
                }
            }
        }
        return matching;
    }
    @java.lang.Override
    public void finishPass() { java.util.HashSet<edu.umd.cs.findbugs.BugPattern> claimedReported =
                                 new java.util.HashSet<edu.umd.cs.findbugs.BugPattern>(
                                 );
                               for (edu.umd.cs.findbugs.DetectorFactory d
                                     :
                                     edu.umd.cs.findbugs.DetectorFactoryCollection.
                                      instance(
                                        ).
                                      getFactories(
                                        )) {
                                   claimedReported.
                                     addAll(
                                       d.
                                         getReportedBugPatterns(
                                           ));
                               }
                               for (edu.umd.cs.findbugs.BugPattern b
                                     :
                                     edu.umd.cs.findbugs.DetectorFactoryCollection.
                                      instance(
                                        ).
                                      getBugPatterns(
                                        )) {
                                   java.lang.String category =
                                     b.
                                     getCategory(
                                       );
                                   if (!b.
                                         isDeprecated(
                                           ) &&
                                         !"EXPERIMENTAL".
                                         equals(
                                           category) &&
                                         !claimedReported.
                                         contains(
                                           b)) {
                                       edu.umd.cs.findbugs.ba.AnalysisContext.
                                         logError(
                                           "No detector claims " +
                                           b.
                                             getType(
                                               ));
                                   }
                               } }
    @java.lang.Override
    public java.lang.String getDetectorClassName() {
        return edu.umd.cs.findbugs.detect.CheckExpectedWarnings.class.
          getName(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BQj9bxCiMwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KdgEOErRoScJHMsT5Sednu0Kf+3I1L32tBk6NuxpI7RfJMB7Vjt7v/eU3fmh" +
       "DGUBPNROJanTduegkL+geZOn8vRKlvxwPid3xIVLQWgtgUcAFD7K/dMY0GF5" +
       "irNT/L8Bfwfg+X72ZL1nGdsF/ZHWzqt48sitCMCCdhfexqTOzWebCy0XmLLl" +
       "zqGCnnnkm/NPf+cLW2fp9NSeqqx/6Lm//zdXn33uwjEX9Y03eInH22zd1By7" +
       "B7KEzJTlqZuNkrcg/uuXnvmNf/jMB7dUPXLS4WqD/cQX/vD//u7VT/3p185Y" +
       "1S9Nfd/RFW9r97O0liXYFlXkXO15x9Hc3p/lPgUeeje39DlzK509twfZaztn" +
       "mowLd4c7Y5X9Lp2iSr51qh7JcjMV7++o6p9D1bvPpupCTlWWdA5JewDY02O2" +
       "fmd0nzrH6O5rnmLiPbcJ7VvAw+2Y4M5hQr8VaO+zPCA32a5N17Ks/inCjNsk" +
       "LNNhfkcYfw5hzq0Qdnm18xixdb7rAUL/1vNVUkymUXxsd/Sz1vO/9+/+6vL7" +
       "t9J/UpfzDfKu6el2X//jOyr3xVc+mjszd06VKFeKu4F5i7KaceHJ8zfbeV9b" +
       "Rb1vb34KZ5ufR0+shVfzrXwQpIcC9MB+YQPFWebqhNafDcB1teteF7/89Q/W" +
       "c6W+vLSAy6Vrg93e/6SLsXe7r504DzgTouvqd770s1996s/lR/ON3haNjCwY" +
       "uCfZ/8ZOQO7IBSRXFkDwm84heEdR7hFdV3/y09//vT975htfu6NwETir2Wqj" +
       "hGCTB3aRV887HznewZUBeMNBK7AKPbhtDeQmn9Td5D1ylHvkd8eFt5/Xd27h" +
       "T7nn2QmD46/0EPMTL1eUJ06ucvcmQXC8NBeD+39QMXgf8CVvAbojzncKlxk4" +
       "MJcP5sKTLeK5oT9eCIz7oy0aFcXrgzHXvi6jQhfF6NykrbLl70A+lMCH9p1s" +
       "PYGtbC5elKXHz/JibxDwV5zlKmdlz+Y11ieE6iAXqguFQ7f2fS+RiKz1z+SD" +
       "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" +
       "K7glFedCMFYn2qJsLpvkksdb2NTX7OqQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "8WvPfyMPz/p/8uDte7dAAAA=");
}
