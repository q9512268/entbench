package edu.umd.cs.findbugs.detect;
public class InitializeNonnullFieldsInConstructor extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    final edu.umd.cs.findbugs.BugReporter bugReporter;
    final java.util.HashSet<edu.umd.cs.findbugs.ba.XField> initializedFields =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    final java.util.HashSet<edu.umd.cs.findbugs.ba.XField> nonnullFields =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    final java.util.HashSet<edu.umd.cs.findbugs.ba.XField> nonnullStaticFields =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    public InitializeNonnullFieldsInConstructor(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void setupVisitorForClass(org.apache.bcel.classfile.JavaClass obj) {
        super.
          setupVisitorForClass(
            obj);
        nonnullFields.
          clear(
            );
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        super.
          visitAfter(
            obj);
        nonnullFields.
          clear(
            );
        nonnullStaticFields.
          clear(
            );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) { super.
                                                               visit(
                                                                 obj);
                                                             edu.umd.cs.findbugs.ba.XField f =
                                                               edu.umd.cs.findbugs.ba.XFactory.
                                                               createXField(
                                                                 this);
                                                             if (checkForInitialization(
                                                                   f) &&
                                                                   !f.
                                                                   isSynthetic(
                                                                     )) {
                                                                 if (f.
                                                                       isStatic(
                                                                         )) {
                                                                     nonnullStaticFields.
                                                                       add(
                                                                         f);
                                                                 }
                                                                 else {
                                                                     nonnullFields.
                                                                       add(
                                                                         f);
                                                                 }
                                                             }
    }
    public boolean checkForInitialization(edu.umd.cs.findbugs.ba.XField f) {
        if (!f.
              isReferenceType(
                ) ||
              f.
              isFinal(
                )) {
            return false;
        }
        edu.umd.cs.findbugs.ba.NullnessAnnotation annotation =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getNullnessAnnotationDatabase(
            ).
          getResolvedAnnotation(
            f,
            false);
        boolean isNonnull =
          annotation ==
          edu.umd.cs.findbugs.ba.NullnessAnnotation.
            NONNULL;
        return isNonnull;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) {
        boolean interesting =
          "<init>".
          equals(
            getMethodName(
              )) ||
          "<clinit>".
          equals(
            getMethodName(
              ));
        if (!interesting) {
            return;
        }
        secondaryConstructor =
          false;
        java.util.HashSet<edu.umd.cs.findbugs.ba.XField> needToInitialize =
          getMethod(
            ).
          isStatic(
            )
          ? nonnullStaticFields
          : nonnullFields;
        if (needToInitialize.
              isEmpty(
                )) {
            return;
        }
        super.
          visit(
            code);
        if (!secondaryConstructor &&
              !initializedFields.
              containsAll(
                needToInitialize)) {
            int priority =
              edu.umd.cs.findbugs.Priorities.
                NORMAL_PRIORITY;
            if (needToInitialize.
                  size(
                    ) -
                  initializedFields.
                  size(
                    ) ==
                  1 &&
                  needToInitialize.
                  size(
                    ) >
                  1) {
                priority =
                  edu.umd.cs.findbugs.Priorities.
                    HIGH_PRIORITY;
            }
            for (edu.umd.cs.findbugs.ba.XField f
                  :
                  needToInitialize) {
                if (initializedFields.
                      contains(
                        f)) {
                    continue;
                }
                edu.umd.cs.findbugs.BugInstance b =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR",
                  priority).
                  addClassAndMethod(
                    this).
                  addField(
                    f);
                bugReporter.
                  reportBug(
                    b);
            }
        }
        initializedFields.
          clear(
            );
    }
    boolean secondaryConstructor;
    @java.lang.Override
    public void sawOpcode(int seen) { if (secondaryConstructor) {
                                          return;
                                      }
                                      switch (seen) {
                                          case org.apache.bcel.Constants.
                                                 INVOKESPECIAL:
                                              if (!getMethod(
                                                     ).
                                                    isStatic(
                                                      ) &&
                                                    "<init>".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    isSelfOperation(
                                                      )) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item invokedOn =
                                                    stack.
                                                    getItemMethodInvokedOn(
                                                      this);
                                                  if (invokedOn.
                                                        isInitialParameter(
                                                          ) &&
                                                        invokedOn.
                                                        getRegisterNumber(
                                                          ) ==
                                                        0) {
                                                      secondaryConstructor =
                                                        true;
                                                  }
                                                  break;
                                              }
                                              break;
                                          case org.apache.bcel.Constants.
                                                 PUTFIELD:
                                              if (getMethod(
                                                    ).
                                                    isStatic(
                                                      )) {
                                                  return;
                                              }
                                              edu.umd.cs.findbugs.OpcodeStack.Item left =
                                                stack.
                                                getStackItem(
                                                  1);
                                              if (left.
                                                    isInitialParameter(
                                                      ) &&
                                                    left.
                                                    getRegisterNumber(
                                                      ) ==
                                                    0 &&
                                                    isSelfOperation(
                                                      )) {
                                                  edu.umd.cs.findbugs.ba.XField f =
                                                    getXFieldOperand(
                                                      );
                                                  if (f ==
                                                        null) {
                                                      break;
                                                  }
                                                  if (checkForInitialization(
                                                        f)) {
                                                      initializedFields.
                                                        add(
                                                          f);
                                                  }
                                              }
                                              break;
                                          case org.apache.bcel.Constants.
                                                 PUTSTATIC:
                                              if (!getMethod(
                                                     ).
                                                    isStatic(
                                                      )) {
                                                  break;
                                              }
                                              if (isSelfOperation(
                                                    )) {
                                                  edu.umd.cs.findbugs.ba.XField f =
                                                    getXFieldOperand(
                                                      );
                                                  if (f ==
                                                        null) {
                                                      break;
                                                  }
                                                  if (checkForInitialization(
                                                        f)) {
                                                      initializedFields.
                                                        add(
                                                          f);
                                                  }
                                              }
                                              break;
                                          default:
                                              break;
                                      } }
    public boolean isSelfOperation() { return getClassConstantOperand(
                                                ).
                                         equals(
                                           getClassName(
                                             ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zCqw1oDDNJNUS0YPlZNrNawzc4w7NP1cGHfGJE1n8mUoduen5vxqg//SQNy/" +
       "t7piyt6r32QZavbXAFWQayYBm7t/7Hov03SalJh0q3g3mRXPoWaTTAv+5tYk" +
       "ZfwFGQp9jYMsgGoxD4gJ51uv7t0RiOPObpMUiZ7lxVBoWMug7DC6F5fAFCzi" +
       "61LN9kIL8nY00B1xJWdZ+kpGtapnQt46IutuJp3uOl2lx5zA5tyaNP/VTUw8" +
       "sHd11w0nl97HvzkEx7hlC2IZGyXl/EvMbIreEIjNxlW2qvnU+EfHzLWLmVpO" +
       "sGMZ011OtQ3MVUN9meb7Ws1oyn67dnTfsude2VH2OlR560lIgPtbn/t1RUZL" +
       "Q220Pprb8LE7WC3N92xeviD50VvsCyHCG0QzgvfHxP7bj3Q+OvTZFexHHqVw" +
       "WTTDvkdZuVlZR8Vh3dM9yt8SHOdpCZqkMbdOPm0LcByUT86MXZoV6AoigDNj" +
       "XR2ON3PvjNIH3YxF12ia1a0q/p7GjHxrYL0c6mSv+Lb6v7t7zAd+JwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eI6d5J44bY9C6LHzUq2Kc89Pf/jlV/Th");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("r1Yu7h/xvhRD98R+8B4HBJPOMVJX7vzqbVBkmh29f/3Ch7/5qPjji/e/geyT" +
       "J07xeZrkPx585kudH9V+8SJ06fBt7G05cCcHPX/qtUxoxEnoiSfexD52MgME" +
       "BVdtX7O102fkR3N39gn+O3dzfyqN4FQqwjN+ON9TAkVbGHuqZji7dzx5Etde" +
       "T0mVYnoKOr99h3SEf5kX/7Q4jo+TQMpf7fkh5YfF6DNPQlPf0o/M7jdPmt39" +
       "h2Z3yOaNY697UiMMLd24g6XenjdQVHzupHLzV9sv7Cv3hTdVufnPf150+PId" +
       "tPaHefGFGLq3eBeKm/svvH/3SC9fPFcvefXv/cAaeBLavR+HDr7fdPN64nzz" +
       "2r2Oy/t99Q5K+pO8+EoM3V0o6ZR+/v0PTz8PHVgIt68f7k23ELvo8I07CP/N" +
       "vPgvMfQwUJ+2pPL0tf0UBOUga+tnjrTxZ6/1KuH1mMP79sV93w/FHB4/3xwI" +
       "XzcKEv/zDgr567z47+dYw7d/yN7yDLg+uK+eD7756jkFkZcsL87HXLh0vj4u" +
       "XM0rvwcWyUhZDwMNqPCUTr7/Q/aQPFXot/Z18ltvjk6Oy/fQHdrelhcPxNA1" +
       "KxIMxxwGeQ7RbV5x4dob8Yoshm6+nozZPP3v7bel9u/S0bXfeOXa1UdeGf/H" +
       "Imn0MGX8Hga6agJqx7Owjt1fDkLDtAqF3LPLyQoKKd8RQ4+en94bQ5d3N7kk" +
       "F35kN+SJGHrojCExeP7+7fHeT4MF6Kh3DF3UTjQ/G0NX9puBTYLyeOM7QRVo" +
       "zG+fCw58/N1n5l/kzr6zUCEGimoXXPthduFkgHhouDdea9qOxZTPnJsgNEh2" +
       "f824pX32lR77U9+p/eouIxbAznabU7nKQFd2ybmHkd9T51I7oHWZfu67D3zu" +
       "nmcPotQHdgwfmfsx3p44O/2UdIO4SBjd/vYjv/nCP3zla8Wr6P8Hf4knjDEz" +
       "AAA=");
}
