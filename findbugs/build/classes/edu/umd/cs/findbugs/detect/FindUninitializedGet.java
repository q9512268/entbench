package edu.umd.cs.findbugs.detect;
public class FindUninitializedGet extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    java.util.Set<edu.umd.cs.findbugs.FieldAnnotation> initializedFields =
      new java.util.HashSet<edu.umd.cs.findbugs.FieldAnnotation>(
      );
    java.util.Set<edu.umd.cs.findbugs.FieldAnnotation> declaredFields = new java.util.HashSet<edu.umd.cs.findbugs.FieldAnnotation>(
      );
    java.util.Set<edu.umd.cs.findbugs.FieldAnnotation> containerFields =
      new java.util.HashSet<edu.umd.cs.findbugs.FieldAnnotation>(
      );
    java.util.Collection<edu.umd.cs.findbugs.BugInstance> pendingBugs =
      new java.util.LinkedList<edu.umd.cs.findbugs.BugInstance>(
      );
    edu.umd.cs.findbugs.BugInstance uninitializedFieldReadAndCheckedForNonnull;
    boolean inConstructor;
    boolean thisOnTOS = false;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public FindUninitializedGet(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) { pendingBugs.
                                                                   clear(
                                                                     );
                                                                 declaredFields.
                                                                   clear(
                                                                     );
                                                                 containerFields.
                                                                   clear(
                                                                     );
                                                                 super.
                                                                   visit(
                                                                     obj);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) {
        super.
          visit(
            obj);
        edu.umd.cs.findbugs.FieldAnnotation f =
          edu.umd.cs.findbugs.FieldAnnotation.
          fromVisitedField(
            this);
        declaredFields.
          add(
            f);
    }
    @java.lang.Override
    public void visitAnnotation(java.lang.String annotationClass,
                                java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                boolean runtimeVisible) {
        if (!visitingField(
               )) {
            return;
        }
        if (edu.umd.cs.findbugs.detect.UnreadFields.
              isInjectionAttribute(
                annotationClass)) {
            containerFields.
              add(
                edu.umd.cs.findbugs.FieldAnnotation.
                  fromVisitedField(
                    this));
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        super.
          visit(
            obj);
        initializedFields.
          clear(
            );
        thisOnTOS =
          false;
        inConstructor =
          "<init>".
            equals(
              getMethodName(
                )) &&
            getMethodSig(
              ).
            indexOf(
              getClassName(
                )) ==
            -1;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (!inConstructor) {
            return;
        }
        uninitializedFieldReadAndCheckedForNonnull =
          null;
        super.
          visit(
            obj);
        for (edu.umd.cs.findbugs.BugInstance bug
              :
              pendingBugs) {
            bugReporter.
              reportBug(
                bug);
        }
        pendingBugs.
          clear(
            );
    }
    @java.lang.Override
    public void sawBranchTo(int target) { java.util.Iterator<edu.umd.cs.findbugs.BugInstance> i =
                                            pendingBugs.
                                            iterator(
                                              );
                                          while (i.
                                                   hasNext(
                                                     )) {
                                              edu.umd.cs.findbugs.BugInstance bug =
                                                i.
                                                next(
                                                  );
                                              if (bug.
                                                    getPrimarySourceLineAnnotation(
                                                      ).
                                                    getStartBytecode(
                                                      ) >=
                                                    target) {
                                                  i.
                                                    remove(
                                                      );
                                              }
                                          }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (!inConstructor) {
                                          return;
                                      }
                                      if (uninitializedFieldReadAndCheckedForNonnull !=
                                            null) {
                                          if (seen ==
                                                NEW &&
                                                getClassConstantOperand(
                                                  ).
                                                endsWith(
                                                  "Exception")) {
                                              uninitializedFieldReadAndCheckedForNonnull.
                                                raisePriority(
                                                  );
                                          }
                                          uninitializedFieldReadAndCheckedForNonnull =
                                            null;
                                      }
                                      if (seen ==
                                            ALOAD_0) {
                                          thisOnTOS =
                                            true;
                                          return;
                                      }
                                      if (seen ==
                                            PUTFIELD &&
                                            getClassConstantOperand(
                                              ).
                                            equals(
                                              getClassName(
                                                ))) {
                                          initializedFields.
                                            add(
                                              edu.umd.cs.findbugs.FieldAnnotation.
                                                fromReferencedField(
                                                  this));
                                      }
                                      else
                                          if (thisOnTOS &&
                                                seen ==
                                                GETFIELD &&
                                                getClassConstantOperand(
                                                  ).
                                                equals(
                                                  getClassName(
                                                    ))) {
                                              edu.umd.cs.findbugs.detect.UnreadFieldsData unreadFields =
                                                edu.umd.cs.findbugs.ba.AnalysisContext.
                                                currentAnalysisContext(
                                                  ).
                                                getUnreadFieldsData(
                                                  );
                                              edu.umd.cs.findbugs.ba.XField xField =
                                                edu.umd.cs.findbugs.ba.XFactory.
                                                createReferencedXField(
                                                  this);
                                              edu.umd.cs.findbugs.FieldAnnotation f =
                                                edu.umd.cs.findbugs.FieldAnnotation.
                                                fromReferencedField(
                                                  this);
                                              int nextOpcode =
                                                255 &
                                                codeBytes[getPC(
                                                            ) +
                                                            3];
                                              if (nextOpcode !=
                                                    POP &&
                                                    !initializedFields.
                                                    contains(
                                                      f) &&
                                                    declaredFields.
                                                    contains(
                                                      f) &&
                                                    !containerFields.
                                                    contains(
                                                      f) &&
                                                    !unreadFields.
                                                    isContainerField(
                                                      xField)) {
                                                  edu.umd.cs.findbugs.LocalVariableAnnotation possibleTarget =
                                                    edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                    findMatchingIgnoredParameter(
                                                      getClassContext(
                                                        ),
                                                      getMethod(
                                                        ),
                                                      getNameConstantOperand(
                                                        ),
                                                      xField.
                                                        getSignature(
                                                          ));
                                                  if (possibleTarget ==
                                                        null) {
                                                      possibleTarget =
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
                                                  int priority =
                                                    unreadFields.
                                                    getReadFields(
                                                      ).
                                                    contains(
                                                      xField)
                                                    ? NORMAL_PRIORITY
                                                    : LOW_PRIORITY;
                                                  boolean priorityLoweredBecauseOfIfNonnullTest =
                                                    false;
                                                  if (possibleTarget !=
                                                        null) {
                                                      priority--;
                                                  }
                                                  else {
                                                      edu.umd.cs.findbugs.ba.FieldSummary fieldSummary =
                                                        edu.umd.cs.findbugs.ba.AnalysisContext.
                                                        currentAnalysisContext(
                                                          ).
                                                        getFieldSummary(
                                                          );
                                                      if (fieldSummary.
                                                            callsOverriddenMethodsFromSuperConstructor(
                                                              getClassDescriptor(
                                                                ))) {
                                                          priority++;
                                                      }
                                                      else
                                                          if (nextOpcode ==
                                                                IFNONNULL) {
                                                              priority++;
                                                              priorityLoweredBecauseOfIfNonnullTest =
                                                                true;
                                                          }
                                                  }
                                                  edu.umd.cs.findbugs.BugInstance bug =
                                                    new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "UR_UNINIT_READ",
                                                    priority).
                                                    addClassAndMethod(
                                                      this).
                                                    addField(
                                                      f).
                                                    addOptionalAnnotation(
                                                      possibleTarget).
                                                    addSourceLine(
                                                      this);
                                                  pendingBugs.
                                                    add(
                                                      bug);
                                                  if (priorityLoweredBecauseOfIfNonnullTest) {
                                                      uninitializedFieldReadAndCheckedForNonnull =
                                                        bug;
                                                  }
                                                  initializedFields.
                                                    add(
                                                      f);
                                              }
                                          }
                                          else
                                              if (seen ==
                                                    INVOKESPECIAL &&
                                                    !("<init>".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) &&
                                                        !getClassConstantOperand(
                                                           ).
                                                        equals(
                                                          getClassName(
                                                            ))) ||
                                                    seen ==
                                                    INVOKESTATIC &&
                                                    "doPrivileged".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    "java/security/AccessController".
                                                    equals(
                                                      getClassConstantOperand(
                                                        )) ||
                                                    seen ==
                                                    INVOKEVIRTUAL &&
                                                    getClassConstantOperand(
                                                      ).
                                                    equals(
                                                      getClassName(
                                                        )) ||
                                                    seen ==
                                                    INVOKEVIRTUAL &&
                                                    "start".
                                                    equals(
                                                      getNameConstantOperand(
                                                        ))) {
                                                  inConstructor =
                                                    false;
                                              }
                                      thisOnTOS =
                                        false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUaa3AV1fncm5CEJOTJywABQsAh4r2iAkMjKIQEgjcPScjU" +
       "oF42e0+SJXt3l929yQ2KFmcstBVqFR/tKD9aHJWq0E7py8fQsfVRtTNaq6IV" +
       "beu0qHUq01E72mq/75y9dx939wKVSmb2ZO855/vO933ne56zD75PJhg6qaeK" +
       "GTHHNWpEWhWzW9ANmmiRBcPohb64eGeB8M9rjncuD5OiflIxLBgdomDQNonK" +
       "CaOfzJIUwxQUkRqdlCYQolunBtVHBVNSlX4yRTLak5osiZLZoSYoTugT9Bip" +
       "FkxTlwZSJm23EJhkVgwoiTJKoqu8w80xUi6q2rg9fbpjeotjBGcm7bUMk1TF" +
       "tgijQjRlSnI0Jhlmc1on52mqPD4kq2aEps3IFnmJJYL1sSU5Img4VPnRp7cM" +
       "VzER1AqKopqMPWMDNVR5lCZipNLubZVp0thKricFMVLmmGySxlhm0SgsGoVF" +
       "M9zas4D6SVRJJVtUxo6ZwVSkiUiQSea6kWiCLiQtNN2MZsBQYlq8M2Dgdk6W" +
       "W85lDou3nxfde+c1VT8uIJX9pFJSepAcEYgwYZF+EChNDlDdWJVI0EQ/qVZg" +
       "s3uoLgmytM3a6RpDGlIEMwXbnxELdqY0qrM1bVnBPgJveko0VT3L3iBTKOvX" +
       "hEFZGAJep9q8cg7bsB8YLJWAMH1QAL2zQApHJCVhktleiCyPjZfDBAAtTlJz" +
       "WM0uVagI0EFquIrIgjIU7QHVU4Zg6gQVFFA3SV0gUpS1JogjwhCNo0Z65nXz" +
       "IZg1kQkCQUwyxTuNYYJdqvPskmN/3u+8ZM+1yjolTEJAc4KKMtJfBkD1HqAN" +
       "dJDqFOyAA5Y3xe4Qpj62K0wITJ7imczn/Oy6E5ctqj/yNJ8zw2dO18AWKppx" +
       "cf9AxQszWxYuL0AySjTVkHDzXZwzK+u2RprTGniYqVmMOBjJDB7Z8OSVXztA" +
       "3wuT0nZSJKpyKgl6VC2qSU2Sqb6WKlQXTJpoJxOpkmhh4+2kGN5jkkJ5b9fg" +
       "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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TY5clqumZTJlXd92YhfnWnJ/TaA6Xa8m");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6yy2F4JIB1km0VOKG25Shqyu2nMcE9iNQHm6RTZiDa2B3U7cWCFwV1eCBt8i" +
       "ja5HdXw7wser/krtRI1avI28HtYuM41yRGKsyo5Ru2Gm0ZQoNyVk5sZmfYE0" +
       "6pt446oJ3JPkbbftAiTrbXx8UgPrNbto2cpYi6ZL209llmkInaqccQ7MTLVu" +
       "qGhWazzmOQT2G8hWnhNjZ13F0WRd5tMatBSXY9PpcbAl4XgZU/xmw0NCeaqn" +
       "w8pkmyFJ1kzNYRtqIOtVfzwfQRpdVQNjWB4JeKZRNQVjoLi6lIhe2lymq1rD" +
       "2bQXY3UUMW44TJh+ywzYer2M4VDF96wk7m/b3DDhVZ7GKm1HH4vRECHULbMO" +
       "x3gbJpBp1elg6bqC8EazMkixsEJwIb2tcMPpYrKZ2XqdXEek2kwgsxGOqmvZ" +
       "Mjc4jr/wQn6M9ptv7HjvoeIk8yTacmVjecGvv4ETvF3Rk3ny9MkhcPG7o7QX" +
       "oXfmEPjMm5STQJinL3r/koe0arYWRUQRsuaF+an8uy4LuSxO5D/34ZdeVtlf" +
       "qF45Ot3+x/nptue/z9bWmn1m4DtvHVMwKCJOT+M2fuvDf/ao8IPGB99A1Nrj" +
       "e3Tud/nPBq98ufse5eeulK6eRHHcFAt7vtFze++dQy1OQlc4F8HxrvORY9fB" +
       "RRzNA7F/GH860zfpzEGhMztN2Qs/2gthesoL9UPZlxVDO1womr174ZYHcx7S" +
       "8loupqfo56u3CGP6kzz5Sly6vQhbuPBwee2Z6qlW/tF5rbzvRCtP6Hr4zEvs" +
       "tRaGpqrdQpFvDjAqMv7gvDSfKO1iYkrH/2+6NB+/XJrFK76ij/9xC0l+O0++" +
       "eSzJ/OFPT6X23y+VWp79je9aPi64hCP5CG+OfK6eQtivv86X0Y+ci2S7VXwN" +
       "KAaZB7df8Pr5asF+8VLqdb5+vmTYvNkHilGK985i/nz63vk9l893/o2CdhT8" +
       "tSMh7+We/Q77uw4LAV3wlvozeXpwcLnGHDySZ/5VfBQydBrHsac7f/091p0n" +
       "S7u47tLx/5tuW09cLusdzhbieOwWonp3nnzfxcZ18Oj3WEB5ELB5JCDzeyKg" +
       "xy4XUNtTtUIE77uFeKp58gOXiOeZ77F4vh9c6yPxrN988ewtR1dNNy54fv4W" +
       "8sDzBItL90byphWCFdwQvD2pNL7HUnkKXB86ksqH3lSp5NS/ULDJ3EIEwzzp" +
       "AicMiID1FaBFewKg3kQBpHHpLRd91pDHaL/jpu+pdt8AKb/68rW73v7y5D8X" +
       "kf0n3+nczZTuWia2fTZU9sz9HX6oLc1CPHfvAmcLoD8Q49Kjl39zEZfu2N3k" +
       "lB9Mdk3mYOW4oEkMxj+6PVv7h+PSPae149IV5Vzxjbh051Ex0FGQni1cgCxQ" +
       "mN8q/rHNv/fCwKctoBLMFa8AV9d09RP/++Dc+nK6ODz8Wq/5T5qc/WxgP9x0" +
       "kOy+h7uhfP5levij36r/wu6zBQBDWZb3chdTunP3BcWJm/3kpb0d93UH9cx3" +
       "HvjC3U8fbwke2BF8qvxnaHv84m8EOo4fF1H92b98+689/4svf7WIrPi/Hook" +
       "raY4AAA=");
}
