package edu.umd.cs.findbugs.detect;
public class FindHEmismatch extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.StatelessDetector {
    static final java.util.regex.Pattern mapPattern = java.util.regex.Pattern.
      compile(
        "[^y]HashMap<L([^;<]*);");
    static final java.util.regex.Pattern hashTablePattern = java.util.regex.Pattern.
      compile(
        "Hashtable<L([^;<]*);");
    static final java.util.regex.Pattern setPattern = java.util.regex.Pattern.
      compile(
        "[^y]HashSet<L([^;<]*);");
    static final java.util.regex.Pattern predicateOverAnInstance =
      java.util.regex.Pattern.
      compile(
        "\\(L([^;]+);\\)Z");
    boolean isApplicationClass;
    boolean hasFields;
    boolean visibleOutsidePackage;
    boolean hasHashCode;
    boolean hasEqualsObject;
    boolean hashCodeIsAbstract;
    boolean equalsObjectIsAbstract;
    boolean equalsMethodIsInstanceOfEquals;
    boolean hasCompareToObject;
    boolean hasCompareToBridgeMethod;
    boolean hasEqualsSelf;
    boolean hasEqualsOther;
    boolean hasCompareToSelf;
    boolean extendsObject;
    edu.umd.cs.findbugs.MethodAnnotation equalsMethod;
    edu.umd.cs.findbugs.MethodAnnotation equalsOtherMethod;
    edu.umd.cs.findbugs.classfile.ClassDescriptor equalsOtherClass;
    edu.umd.cs.findbugs.MethodAnnotation compareToMethod;
    edu.umd.cs.findbugs.MethodAnnotation compareToObjectMethod;
    edu.umd.cs.findbugs.MethodAnnotation compareToSelfMethod;
    edu.umd.cs.findbugs.MethodAnnotation hashCodeMethod;
    final java.util.HashSet<java.lang.String> nonHashableClasses;
    final java.util.Map<java.lang.String,edu.umd.cs.findbugs.BugInstance>
      potentialBugs;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public FindHEmismatch(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        nonHashableClasses =
          new java.util.HashSet<java.lang.String>(
            );
        potentialBugs =
          new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.BugInstance>(
            );
    }
    public boolean isHashableClassName(java.lang.String dottedClassName) {
        return !nonHashableClasses.
          contains(
            dottedClassName);
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        if (!obj.
              isClass(
                )) {
            return;
        }
        if ("java.lang.Object".
              equals(
                getDottedClassName(
                  ))) {
            return;
        }
        int accessFlags =
          obj.
          getAccessFlags(
            );
        if ((accessFlags &
               ACC_INTERFACE) !=
              0) {
            return;
        }
        visibleOutsidePackage =
          obj.
            isPublic(
              ) ||
            obj.
            isProtected(
              );
        java.lang.String whereEqual =
          getDottedClassName(
            );
        boolean inheritedHashCodeIsFinal =
          false;
        boolean inheritedEqualsIsFinal =
          false;
        boolean inheritedEqualsIsAbstract =
          false;
        boolean inheritedEqualsFromAbstractClass =
          false;
        edu.umd.cs.findbugs.ba.XMethod inheritedEquals =
          null;
        if (!hasEqualsObject) {
            edu.umd.cs.findbugs.ba.XClass we =
              edu.umd.cs.findbugs.Lookup.
              findImplementor(
                getXClass(
                  ),
                "equals",
                "(Ljava/lang/Object;)Z",
                false,
                bugReporter);
            if (we ==
                  null ||
                  we.
                  equals(
                    getXClass(
                      ))) {
                whereEqual =
                  "java.lang.Object";
            }
            else {
                inheritedEqualsFromAbstractClass =
                  we.
                    isAbstract(
                      );
                whereEqual =
                  we.
                    getClassDescriptor(
                      ).
                    getDottedClassName(
                      );
                inheritedEquals =
                  we.
                    findMethod(
                      "equals",
                      "(Ljava/lang/Object;)Z",
                      false);
                if (inheritedEquals !=
                      null) {
                    inheritedEqualsIsFinal =
                      inheritedEquals.
                        isFinal(
                          );
                    inheritedEqualsIsAbstract =
                      inheritedEquals.
                        isAbstract(
                          );
                }
            }
        }
        boolean usesDefaultEquals =
          "java.lang.Object".
          equals(
            whereEqual);
        java.lang.String whereHashCode =
          getDottedClassName(
            );
        if (!hasHashCode) {
            edu.umd.cs.findbugs.ba.XClass wh =
              edu.umd.cs.findbugs.Lookup.
              findSuperImplementor(
                getXClass(
                  ),
                "hashCode",
                "()I",
                false,
                bugReporter);
            if (wh ==
                  null) {
                whereHashCode =
                  "java.lang.Object";
            }
            else {
                whereHashCode =
                  wh.
                    getClassDescriptor(
                      ).
                    getDottedClassName(
                      );
                edu.umd.cs.findbugs.ba.XMethod m =
                  wh.
                  findMethod(
                    "hashCode",
                    "()I",
                    false);
                if (m !=
                      null &&
                      m.
                      isFinal(
                        )) {
                    inheritedHashCodeIsFinal =
                      true;
                }
            }
        }
        boolean usesDefaultHashCode =
          "java.lang.Object".
          equals(
            whereHashCode);
        if (!hasEqualsObject &&
              !hasEqualsSelf &&
              hasEqualsOther) {
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              usesDefaultEquals
                ? "EQ_OTHER_USE_OBJECT"
                : "EQ_OTHER_NO_OBJECT",
              NORMAL_PRIORITY).
              addClass(
                this).
              addMethod(
                equalsOtherMethod).
              addClass(
                equalsOtherClass);
            bugReporter.
              reportBug(
                bug);
        }
        if (!hasEqualsObject &&
              hasEqualsSelf) {
            if (usesDefaultEquals) {
                int priority =
                  HIGH_PRIORITY;
                if (usesDefaultHashCode ||
                      obj.
                      isAbstract(
                        )) {
                    priority++;
                }
                if (!visibleOutsidePackage) {
                    priority++;
                }
                java.lang.String bugPattern =
                  "EQ_SELF_USE_OBJECT";
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  bugPattern,
                  priority).
                  addClass(
                    getDottedClassName(
                      ));
                if (equalsMethod !=
                      null) {
                    bug.
                      addMethod(
                        equalsMethod);
                }
                bugReporter.
                  reportBug(
                    bug);
            }
            else {
                int priority =
                  NORMAL_PRIORITY;
                if (hasFields) {
                    priority--;
                }
                if (obj.
                      isAbstract(
                        )) {
                    priority++;
                }
                java.lang.String bugPattern =
                  "EQ_SELF_NO_OBJECT";
                java.lang.String superclassName =
                  obj.
                  getSuperclassName(
                    );
                if ("java.lang.Enum".
                      equals(
                        superclassName)) {
                    bugPattern =
                      "EQ_DONT_DEFINE_EQUALS_FOR_ENUM";
                    priority =
                      HIGH_PRIORITY;
                }
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  bugPattern,
                  priority).
                  addClass(
                    getDottedClassName(
                      ));
                if (equalsMethod !=
                      null) {
                    bug.
                      addMethod(
                        equalsMethod);
                }
                bugReporter.
                  reportBug(
                    bug);
            }
        }
        if ((hasCompareToObject ||
               hasCompareToSelf) &&
              usesDefaultEquals) {
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "EQ_COMPARETO_USE_OBJECT_EQUALS",
              obj.
                isAbstract(
                  )
                ? edu.umd.cs.findbugs.Priorities.
                    LOW_PRIORITY
                : edu.umd.cs.findbugs.Priorities.
                    NORMAL_PRIORITY).
              addClass(
                this);
            if (compareToSelfMethod !=
                  null) {
                bug.
                  addMethod(
                    compareToSelfMethod);
            }
            else {
                bug.
                  addMethod(
                    compareToObjectMethod);
            }
            bugReporter.
              reportBug(
                bug);
        }
        if (!hasCompareToObject &&
              !hasCompareToBridgeMethod &&
              hasCompareToSelf) {
            if (!extendsObject) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "CO_SELF_NO_OBJECT",
                      NORMAL_PRIORITY).
                      addClass(
                        getDottedClassName(
                          )).
                      addMethod(
                        compareToMethod));
            }
        }
        if (hasHashCode &&
              !hashCodeIsAbstract &&
              !(hasEqualsObject ||
                  hasEqualsSelf)) {
            int priority =
              LOW_PRIORITY;
            if (usesDefaultEquals) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "HE_HASHCODE_USE_OBJECT_EQUALS",
                      priority).
                      addClass(
                        getDottedClassName(
                          )).
                      addMethod(
                        hashCodeMethod));
            }
            else
                if (!inheritedEqualsIsFinal) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "HE_HASHCODE_NO_EQUALS",
                          priority).
                          addClass(
                            getDottedClassName(
                              )).
                          addMethod(
                            hashCodeMethod));
                }
        }
        if (equalsObjectIsAbstract) {
            
        }
        else
            if (!hasHashCode &&
                  (hasEqualsObject ||
                     hasEqualsSelf)) {
                edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals equalsKind =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getEqualsKindSummary(
                    ).
                  get(
                    new edu.umd.cs.findbugs.ClassAnnotation(
                      obj.
                        getClassName(
                          )));
                if (equalsKind ==
                      edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                        ALWAYS_FALSE) {
                    return;
                }
                if (usesDefaultHashCode) {
                    int priority =
                      HIGH_PRIORITY;
                    if (equalsMethodIsInstanceOfEquals) {
                        priority +=
                          2;
                    }
                    else
                        if (obj.
                              isAbstract(
                                ) ||
                              !hasEqualsObject) {
                            priority++;
                        }
                    if (priority ==
                          HIGH_PRIORITY) {
                        nonHashableClasses.
                          add(
                            getDottedClassName(
                              ));
                    }
                    if (!visibleOutsidePackage) {
                        priority++;
                    }
                    edu.umd.cs.findbugs.BugInstance bug =
                      new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "HE_EQUALS_USE_HASHCODE",
                      priority).
                      addClass(
                        getDottedClassName(
                          ));
                    if (equalsMethod !=
                          null) {
                        bug.
                          addMethod(
                            equalsMethod);
                    }
                    bugReporter.
                      reportBug(
                        bug);
                }
                else
                    if (!inheritedHashCodeIsFinal &&
                          !whereHashCode.
                          startsWith(
                            "java.util.Abstract")) {
                        int priority =
                          LOW_PRIORITY;
                        if (hasEqualsObject &&
                              inheritedEqualsIsAbstract) {
                            priority++;
                        }
                        if (hasFields) {
                            priority--;
                        }
                        if (equalsMethodIsInstanceOfEquals ||
                              !hasEqualsObject) {
                            priority +=
                              2;
                        }
                        else
                            if (obj.
                                  isAbstract(
                                    )) {
                                priority++;
                            }
                        edu.umd.cs.findbugs.BugInstance bug =
                          new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "HE_EQUALS_NO_HASHCODE",
                          priority).
                          addClass(
                            getDottedClassName(
                              ));
                        if (equalsMethod !=
                              null) {
                            bug.
                              addMethod(
                                equalsMethod);
                        }
                        bugReporter.
                          reportBug(
                            bug);
                    }
            }
        if (!hasHashCode &&
              !hasEqualsObject &&
              !hasEqualsSelf &&
              !usesDefaultEquals &&
              usesDefaultHashCode &&
              !obj.
              isAbstract(
                ) &&
              inheritedEqualsFromAbstractClass) {
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "HE_INHERITS_EQUALS_USE_HASHCODE",
              NORMAL_PRIORITY).
              addClass(
                getDottedClassName(
                  ));
            if (equalsMethod !=
                  null) {
                bug.
                  addMethod(
                    equalsMethod);
            }
            bugReporter.
              reportBug(
                bug);
        }
        if (!hasEqualsObject &&
              !hasEqualsSelf &&
              !usesDefaultEquals &&
              !obj.
              isAbstract(
                ) &&
              hasFields &&
              inheritedEquals !=
              null &&
              !inheritedEqualsIsFinal &&
              !inheritedEqualsFromAbstractClass &&
              !inheritedEquals.
              getClassDescriptor(
                ).
              getSimpleName(
                ).
              contains(
                "Abstract") &&
              !"java/lang/Enum".
              equals(
                inheritedEquals.
                  getClassDescriptor(
                    ).
                  getClassName(
                    ))) {
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "EQ_DOESNT_OVERRIDE_EQUALS",
              NORMAL_PRIORITY);
            edu.umd.cs.findbugs.SourceLineAnnotation sourceLine =
              new edu.umd.cs.findbugs.SourceLineAnnotation(
              getDottedClassName(
                ),
              obj.
                getSourceFileName(
                  ),
              1,
              1,
              0,
              0);
            bug.
              addClass(
                getDottedClassName(
                  )).
              add(
                sourceLine);
            bug.
              addMethod(
                inheritedEquals).
              describe(
                edu.umd.cs.findbugs.MethodAnnotation.
                  METHOD_DID_YOU_MEAN_TO_OVERRIDE);
            bugReporter.
              reportBug(
                bug);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        extendsObject =
          "java.lang.Object".
            equals(
              getDottedSuperclassName(
                ));
        hasFields =
          false;
        hasHashCode =
          false;
        hasCompareToObject =
          false;
        hasCompareToBridgeMethod =
          false;
        hasCompareToSelf =
          false;
        hasEqualsObject =
          false;
        hasEqualsSelf =
          false;
        hasEqualsOther =
          false;
        hashCodeIsAbstract =
          false;
        equalsObjectIsAbstract =
          false;
        equalsMethodIsInstanceOfEquals =
          false;
        equalsMethod =
          null;
        equalsOtherMethod =
          null;
        compareToMethod =
          null;
        compareToSelfMethod =
          null;
        compareToObjectMethod =
          null;
        hashCodeMethod =
          null;
        equalsOtherClass =
          null;
        isApplicationClass =
          edu.umd.cs.findbugs.ba.AnalysisContext.
            currentAnalysisContext(
              ).
            isApplicationClass(
              obj);
    }
    @java.lang.Override
    public boolean shouldVisitCode(org.apache.bcel.classfile.Code obj) {
        if (isApplicationClass) {
            return true;
        }
        java.lang.String name =
          getMethod(
            ).
          getName(
            );
        if ("hashCode".
              equals(
                name) ||
              "equals".
              equals(
                name)) {
            return true;
        }
        return false;
    }
    public static int opcode(byte[] code, int offset) {
        return code[offset] &
          255;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) {
        int accessFlags =
          obj.
          getAccessFlags(
            );
        if ((accessFlags &
               ACC_STATIC) !=
              0) {
            return;
        }
        if (!obj.
              getName(
                ).
              startsWith(
                "this$") &&
              !edu.umd.cs.findbugs.bcel.BCELUtil.
              isSynthetic(
                obj) &&
              !obj.
              isTransient(
                )) {
            hasFields =
              true;
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        int accessFlags =
          obj.
          getAccessFlags(
            );
        if ((accessFlags &
               ACC_STATIC) !=
              0) {
            return;
        }
        java.lang.String name =
          obj.
          getName(
            );
        java.lang.String sig =
          obj.
          getSignature(
            );
        if ((accessFlags &
               ACC_ABSTRACT) !=
              0) {
            if ("equals".
                  equals(
                    name) &&
                  sig.
                  equals(
                    "(L" +
                    getClassName(
                      ) +
                    ";)Z")) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "EQ_ABSTRACT_SELF",
                      LOW_PRIORITY).
                      addClass(
                        getDottedClassName(
                          )));
                return;
            }
            else
                if ("compareTo".
                      equals(
                        name) &&
                      sig.
                      equals(
                        "(L" +
                        getClassName(
                          ) +
                        ";)I")) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "CO_ABSTRACT_SELF",
                          LOW_PRIORITY).
                          addClass(
                            getDottedClassName(
                              )));
                    return;
                }
        }
        boolean sigIsObject =
          "(Ljava/lang/Object;)Z".
          equals(
            sig);
        if ("hashCode".
              equals(
                name) &&
              "()I".
              equals(
                sig)) {
            hasHashCode =
              true;
            if (obj.
                  isAbstract(
                    )) {
                hashCodeIsAbstract =
                  true;
            }
            hashCodeMethod =
              edu.umd.cs.findbugs.MethodAnnotation.
                fromVisitedMethod(
                  this);
        }
        else
            if (obj.
                  isPublic(
                    ) &&
                  "equals".
                  equals(
                    name)) {
                java.util.regex.Matcher m =
                  predicateOverAnInstance.
                  matcher(
                    sig);
                if (m.
                      matches(
                        )) {
                    if (sigIsObject) {
                        equalsMethod =
                          edu.umd.cs.findbugs.MethodAnnotation.
                            fromVisitedMethod(
                              this);
                        hasEqualsObject =
                          true;
                        if (obj.
                              isAbstract(
                                )) {
                            equalsObjectIsAbstract =
                              true;
                        }
                        else
                            if (!obj.
                                  isNative(
                                    )) {
                                org.apache.bcel.classfile.Code code =
                                  obj.
                                  getCode(
                                    );
                                byte[] codeBytes =
                                  code.
                                  getCode(
                                    );
                                if (codeBytes.
                                      length ==
                                      9) {
                                    int op0 =
                                      opcode(
                                        codeBytes,
                                        0);
                                    int op1 =
                                      opcode(
                                        codeBytes,
                                        1);
                                    int op2 =
                                      opcode(
                                        codeBytes,
                                        2);
                                    int op5 =
                                      opcode(
                                        codeBytes,
                                        5);
                                    int op6 =
                                      opcode(
                                        codeBytes,
                                        6);
                                    int op7 =
                                      opcode(
                                        codeBytes,
                                        7);
                                    int op8 =
                                      opcode(
                                        codeBytes,
                                        8);
                                    if ((op0 ==
                                           ALOAD_0 &&
                                           op1 ==
                                           ALOAD_1 ||
                                           op0 ==
                                           ALOAD_1 &&
                                           op1 ==
                                           ALOAD_0) &&
                                          (op2 ==
                                             IF_ACMPEQ ||
                                             op2 ==
                                             IF_ACMPNE) &&
                                          (op5 ==
                                             ICONST_0 ||
                                             op5 ==
                                             ICONST_1) &&
                                          op6 ==
                                          IRETURN &&
                                          (op7 ==
                                             ICONST_0 ||
                                             op7 ==
                                             ICONST_1) &&
                                          op8 ==
                                          IRETURN) {
                                        equalsMethodIsInstanceOfEquals =
                                          true;
                                    }
                                }
                                else
                                    if (codeBytes.
                                          length ==
                                          11) {
                                        int op0 =
                                          opcode(
                                            codeBytes,
                                            0);
                                        int op1 =
                                          opcode(
                                            codeBytes,
                                            1);
                                        int op2 =
                                          opcode(
                                            codeBytes,
                                            2);
                                        int op5 =
                                          opcode(
                                            codeBytes,
                                            5);
                                        int op6 =
                                          opcode(
                                            codeBytes,
                                            6);
                                        int op9 =
                                          opcode(
                                            codeBytes,
                                            9);
                                        int op10 =
                                          opcode(
                                            codeBytes,
                                            10);
                                        if ((op0 ==
                                               ALOAD_0 &&
                                               op1 ==
                                               ALOAD_1 ||
                                               op0 ==
                                               ALOAD_1 &&
                                               op1 ==
                                               ALOAD_0) &&
                                              (op2 ==
                                                 IF_ACMPEQ ||
                                                 op2 ==
                                                 IF_ACMPNE) &&
                                              (op5 ==
                                                 ICONST_0 ||
                                                 op5 ==
                                                 ICONST_1) &&
                                              op6 ==
                                              GOTO &&
                                              (op9 ==
                                                 ICONST_0 ||
                                                 op9 ==
                                                 ICONST_1) &&
                                              op10 ==
                                              IRETURN) {
                                            equalsMethodIsInstanceOfEquals =
                                              true;
                                        }
                                    }
                                    else
                                        if (codeBytes.
                                              length ==
                                              5 &&
                                              (codeBytes[1] &
                                                 255) ==
                                              INSTANCEOF ||
                                              codeBytes.
                                                length ==
                                              15 &&
                                              (codeBytes[1] &
                                                 255) ==
                                              INSTANCEOF &&
                                              (codeBytes[11] &
                                                 255) ==
                                              INVOKESPECIAL) {
                                            equalsMethodIsInstanceOfEquals =
                                              true;
                                        }
                            }
                    }
                    else
                        if (sig.
                              equals(
                                "(L" +
                                getClassName(
                                  ) +
                                ";)Z")) {
                            hasEqualsSelf =
                              true;
                            if (equalsMethod ==
                                  null) {
                                equalsMethod =
                                  edu.umd.cs.findbugs.MethodAnnotation.
                                    fromVisitedMethod(
                                      this);
                            }
                        }
                        else {
                            java.lang.String arg =
                              m.
                              group(
                                1);
                            if (getSuperclassName(
                                  ).
                                  equals(
                                    arg)) {
                                org.apache.bcel.classfile.JavaClass findSuperImplementor =
                                  edu.umd.cs.findbugs.Lookup.
                                  findSuperDefiner(
                                    getThisClass(
                                      ),
                                    name,
                                    sig,
                                    bugReporter);
                                if (findSuperImplementor ==
                                      null) {
                                    hasEqualsOther =
                                      true;
                                    equalsOtherMethod =
                                      edu.umd.cs.findbugs.MethodAnnotation.
                                        fromVisitedMethod(
                                          this);
                                    equalsOtherClass =
                                      edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                        createClassDescriptor(
                                          arg);
                                }
                            }
                        }
                }
            }
            else
                if ("compareTo".
                      equals(
                        name) &&
                      sig.
                      endsWith(
                        ")I") &&
                      !obj.
                      isStatic(
                        )) {
                    edu.umd.cs.findbugs.MethodAnnotation tmp =
                      edu.umd.cs.findbugs.MethodAnnotation.
                      fromVisitedMethod(
                        this);
                    if (edu.umd.cs.findbugs.bcel.BCELUtil.
                          isSynthetic(
                            obj)) {
                        hasCompareToBridgeMethod =
                          true;
                    }
                    if ("(Ljava/lang/Object;)I".
                          equals(
                            sig)) {
                        hasCompareToObject =
                          true;
                        compareToObjectMethod =
                          (compareToMethod =
                             tmp);
                    }
                    else
                        if (sig.
                              equals(
                                "(L" +
                                getClassName(
                                  ) +
                                ";)I")) {
                            hasCompareToSelf =
                              true;
                            compareToSelfMethod =
                              (compareToMethod =
                                 tmp);
                        }
                }
    }
    org.apache.bcel.classfile.Method findMethod(org.apache.bcel.classfile.JavaClass clazz,
                                                java.lang.String name,
                                                java.lang.String sig) {
        org.apache.bcel.classfile.Method[] m =
          clazz.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method aM
              :
              m) {
            if (aM.
                  getName(
                    ).
                  equals(
                    name) &&
                  aM.
                  getSignature(
                    ).
                  equals(
                    sig)) {
                return aM;
            }
        }
        return null;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            INVOKEVIRTUAL ||
                                            seen ==
                                            INVOKEINTERFACE) {
                                          java.lang.String className =
                                            getClassConstantOperand(
                                              );
                                          if ("java/util/Map".
                                                equals(
                                                  className) ||
                                                "java/util/HashMap".
                                                equals(
                                                  className) ||
                                                "java/util/LinkedHashMap".
                                                equals(
                                                  className) ||
                                                "java/util/concurrent/ConcurrentHashMap".
                                                equals(
                                                  className) ||
                                                className.
                                                contains(
                                                  "Hash") &&
                                                edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                instanceOf(
                                                  edu.umd.cs.findbugs.util.ClassName.
                                                    toDottedClassName(
                                                      className),
                                                  "java.util.Map")) {
                                              if ("put".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;".
                                                    equals(
                                                      getSigConstantOperand(
                                                        )) &&
                                                    stack.
                                                    getStackDepth(
                                                      ) >=
                                                    3) {
                                                  check(
                                                    1);
                                              }
                                              else
                                                  if (("get".
                                                         equals(
                                                           getNameConstantOperand(
                                                             )) ||
                                                         "remove".
                                                         equals(
                                                           getNameConstantOperand(
                                                             ))) &&
                                                        getSigConstantOperand(
                                                          ).
                                                        startsWith(
                                                          "(Ljava/lang/Object;)") &&
                                                        stack.
                                                        getStackDepth(
                                                          ) >=
                                                        2) {
                                                      check(
                                                        0);
                                                  }
                                          }
                                          else
                                              if ("java/util/Set".
                                                    equals(
                                                      className) ||
                                                    "java/util/HashSet".
                                                    equals(
                                                      className) ||
                                                    className.
                                                    contains(
                                                      "Hash") &&
                                                    edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                    instanceOf(
                                                      edu.umd.cs.findbugs.util.ClassName.
                                                        toDottedClassName(
                                                          className),
                                                      "java.util.Set")) {
                                                  if ("add".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) ||
                                                        "contains".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) ||
                                                        "remove".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) &&
                                                        "(Ljava/lang/Object;)Z".
                                                        equals(
                                                          getSigConstantOperand(
                                                            )) &&
                                                        stack.
                                                        getStackDepth(
                                                          ) >=
                                                        2) {
                                                      check(
                                                        0);
                                                  }
                                              }
                                      } }
    private void check(int pos) { edu.umd.cs.findbugs.OpcodeStack.Item item =
                                    stack.
                                    getStackItem(
                                      pos);
                                  org.apache.bcel.classfile.JavaClass type =
                                    null;
                                  try { type =
                                          item.
                                            getJavaClass(
                                              );
                                  }
                                  catch (java.lang.ClassNotFoundException e) {
                                      edu.umd.cs.findbugs.ba.AnalysisContext.
                                        reportMissingClass(
                                          e);
                                  }
                                  if (type ==
                                        null) {
                                      return;
                                  }
                                  java.lang.String typeName =
                                    type.
                                    getClassName(
                                      );
                                  if (typeName.
                                        startsWith(
                                          "java.lang")) {
                                      return;
                                  }
                                  int priority =
                                    NORMAL_PRIORITY;
                                  edu.umd.cs.findbugs.OpcodeStack.Item collection =
                                    stack.
                                    getStackItem(
                                      edu.umd.cs.findbugs.visitclass.PreorderVisitor.
                                        getNumberArguments(
                                          getSigConstantOperand(
                                            )));
                                  java.lang.String collectionSignature =
                                    collection.
                                    getSignature(
                                      );
                                  if (collectionSignature.
                                        indexOf(
                                          "Tree") >=
                                        0 ||
                                        collectionSignature.
                                        indexOf(
                                          "Sorted") >=
                                        0 ||
                                        collectionSignature.
                                        indexOf(
                                          "SkipList") >=
                                        0) {
                                      return;
                                  }
                                  if (collectionSignature.
                                        indexOf(
                                          "Hash") >=
                                        0) {
                                      priority--;
                                  }
                                  if (!edu.umd.cs.findbugs.ba.AnalysisContext.
                                        currentAnalysisContext(
                                          ).
                                        isApplicationClass(
                                          type)) {
                                      priority++;
                                  }
                                  if (type.
                                        isAbstract(
                                          ) ||
                                        type.
                                        isInterface(
                                          )) {
                                      priority++;
                                  }
                                  potentialBugs.
                                    put(
                                      type.
                                        getClassName(
                                          ),
                                      new edu.umd.cs.findbugs.BugInstance(
                                        this,
                                        "HE_USE_OF_UNHASHABLE_CLASS",
                                        priority).
                                        addClassAndMethod(
                                          this).
                                        addTypeOfNamedClass(
                                          type.
                                            getClassName(
                                              )).
                                        describe(
                                          edu.umd.cs.findbugs.TypeAnnotation.
                                            UNHASHABLE_ROLE).
                                        addCalledMethod(
                                          this).
                                        addSourceLine(
                                          this));
    }
    @javax.annotation.CheckForNull
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    java.lang.String findHashedClassInSignature(java.lang.String sig) {
        java.util.regex.Matcher m =
          mapPattern.
          matcher(
            sig);
        if (m.
              find(
                )) {
            return m.
              group(
                1).
              replace(
                '/',
                '.');
        }
        m =
          hashTablePattern.
            matcher(
              sig);
        if (m.
              find(
                )) {
            return m.
              group(
                1).
              replace(
                '/',
                '.');
        }
        m =
          setPattern.
            matcher(
              sig);
        if (m.
              find(
                )) {
            return m.
              group(
                1).
              replace(
                '/',
                '.');
        }
        return null;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Signature obj) {
        if (!isApplicationClass) {
            return;
        }
        java.lang.String sig =
          obj.
          getSignature(
            );
        java.lang.String className =
          findHashedClassInSignature(
            sig);
        if (className ==
              null) {
            return;
        }
        if (className.
              startsWith(
                "java.lang")) {
            return;
        }
        org.apache.bcel.classfile.JavaClass type =
          null;
        try {
            type =
              org.apache.bcel.Repository.
                lookupClass(
                  className);
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              reportMissingClass(
                e);
        }
        if (type ==
              null) {
            return;
        }
        int priority =
          NORMAL_PRIORITY;
        if (sig.
              indexOf(
                "Hash") >=
              0) {
            priority--;
        }
        if (type.
              isAbstract(
                ) ||
              type.
              isInterface(
                )) {
            priority++;
        }
        if (!edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              isApplicationClass(
                type)) {
            priority++;
        }
        edu.umd.cs.findbugs.BugInstance bug =
          null;
        if (visitingField(
              )) {
            bug =
              new edu.umd.cs.findbugs.BugInstance(
                this,
                "HE_SIGNATURE_DECLARES_HASHING_OF_UNHASHABLE_CLASS",
                priority).
                addClass(
                  this).
                addVisitedField(
                  this).
                addTypeOfNamedClass(
                  className).
                describe(
                  edu.umd.cs.findbugs.TypeAnnotation.
                    UNHASHABLE_ROLE);
        }
        else
            if (visitingMethod(
                  )) {
                bug =
                  new edu.umd.cs.findbugs.BugInstance(
                    this,
                    "HE_SIGNATURE_DECLARES_HASHING_OF_UNHASHABLE_CLASS",
                    priority).
                    addClassAndMethod(
                      this).
                    addTypeOfNamedClass(
                      className).
                    describe(
                      edu.umd.cs.findbugs.TypeAnnotation.
                        UNHASHABLE_ROLE);
            }
            else {
                bug =
                  new edu.umd.cs.findbugs.BugInstance(
                    this,
                    "HE_SIGNATURE_DECLARES_HASHING_OF_UNHASHABLE_CLASS",
                    priority).
                    addClass(
                      this).
                    addClass(
                      this).
                    addTypeOfNamedClass(
                      className).
                    describe(
                      edu.umd.cs.findbugs.TypeAnnotation.
                        UNHASHABLE_ROLE);
            }
        potentialBugs.
          put(
            className,
            bug);
    }
    @java.lang.Override
    public void report() { for (java.util.Map.Entry<java.lang.String,edu.umd.cs.findbugs.BugInstance> e
                                 :
                                 potentialBugs.
                                  entrySet(
                                    )) { if (!isHashableClassName(
                                                e.
                                                  getKey(
                                                    ))) {
                                             edu.umd.cs.findbugs.BugInstance bug =
                                               e.
                                               getValue(
                                                 );
                                             bugReporter.
                                               reportBug(
                                                 bug);
                                         }
                           } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVcC3AcxZnuXdmyrIf18BO/HzKcH+xiLsBxAoMsJBBeW8IS" +
       "TpAD69FsSxo8OzOe6ZXWJobAhcK5HIQjBLgr8FVdQSCcA1TuqLyOlKnUBUiA" +
       "q3AkQMIjXKg6AnEdVF7UQZL7/+7endnZ6RErsOOq6R1N99/9/X///f9/v3z0" +
       "OJntuWQltViKHXCol+q12KDmejTXY2qeNwzfsvqdddqvr3pz57lJUj9C5k1o" +
       "3g5d82ifQc2cN0JWGJbHNEun3k5Kc0gx6FKPupMaM2xrhCw0vP68Yxq6wXbY" +
       "OYoFdmtuhrRrjLnGaIHRflkBIysygCTNkaS7w9ldGdKs284Bv/iSQPGeQA6W" +
       "zPtteYy0Za7WJrV0gRlmOmN4rKvokk2ObR4YN22WokWWuto8S4rg0sxZVSJY" +
       "+0jr796/daKNi2C+Zlk24+x5u6hnm5M0lyGt/tdek+a9/eRaUpchTYHCjHRm" +
       "So2modE0NFri1i8F6FuoVcj32JwdVqqp3tERECNrKitxNFfLy2oGOWaooYFJ" +
       "3jkxcLu6zK3gsorFL29K337nVW1fryOtI6TVsIYQjg4gGDQyAgKl+VHqet25" +
       "HM2NkHYLOnuIuoZmGgdlT3d4xrilsQJ0f0ks+LHgUJe36csK+hF4cws6s90y" +
       "e2NcoeRfs8dMbRx4XeTzKjjsw+/AYKMBwNwxDfROkszaZ1g5RlaFKco8dm6H" +
       "AkA6J0/ZhF1uapalwQfSIVTE1Kzx9BConjUORWfboIAuI0uVlaKsHU3fp43T" +
       "LGpkqNygyIJSc7kgkISRheFivCbopaWhXgr0z/Gd591yjXWJlSQJwJyjuon4" +
       "m4BoZYhoFx2jLoVxIAibN2bu0BY9djhJCBReGCosynzjM+9euHnlsSdFmWUR" +
       "ZQZGr6Y6y+r3js770fKeDefWIYwGx/YM7PwKzvkoG5Q5XUUHLMyico2YmSpl" +
       "Htv1/Ss++yB9O0ka+0m9bpuFPOhRu27nHcOk7sXUoq7GaK6fzKVWrofn95M5" +
       "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" +
       "YG9EAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bhL8t4NL3IMXLwH/uzcA/6B6In8nKvvb55D93quwKfIemXwJsj+8kRSeQrZz" +
       "Y/esfftFrC32MPKl2d3adkcN5cD0QRR/jpIvvgpK1D0l6iWU/LcbeQzykTJd" +
       "zuE/eRXznr7HpV+C66s38v3ks7PJ5ej+x02iex5c5h6deQm6/30DdA/Lp03Q" +
       "5dj+4iaxPQsua4/NugTbN16B4S58rcth/dUrh5WvMZbeDi5nD8u5GNbB4cWw" +
       "DvLb4wD1Iddzc5+5WDrMdUHNA8C3Xh4AcjHwx07tCP2w+dJv/vu/uPL+Xax1" +
       "NnIsNgX3Vc/X+4PfvwW+J3r2R4pV3VslMSxc9jvp0m1hXjIqPXX5BmPR1i4s" +
       "vGfHl2IB5uIVmTeeLArmhHJqtFN/30+PbMS5VT5QJOfffWdizYsZcU3uOde4" +
       "X/iDDzaKUPJKHh9FqjLd73ueXXM92Yd44cxe6IWsuiZ/+TM//GtP/9n84WKT" +
       "a8eVHG899Qvczb2sHBSyclja7WU8dwngPaJiifia/P2f+Jvf/NMXv/j5W0q3" +
       "06W78+U3oDpKz41KVy/bGz7dwLNTcNcBtV6gS/fvapuuXgzufhAfOn56vBEB" +
       "TPFlbRfrCuf2K/LdVdtL1ADzYrfQmSfOLvvdHfv+6dxCHO79ZsThvUHpba+A" +
       "fcfU7/Wv9FAh+vcXQpSvbBZLDKczfWCfcLrNcdemAktcm7cnvTZGE4WQ5auD" +
       "B8SRJD5w0sjOyqYX5Ow2hs8sH5fSswbl4JabNChVcHl7yN4lBuUtr8Sg3Od7" +
       "wOuKTNHGwEyblz2444aD8vCZhfuX6ed9J/oJsvMmrxYNXzmjCLcUNBYLcUXu" +
       "t7zabvPKbyp6KQZnnt8+eQzmsv2OI8Hd9Z0nyPmWBruW8vTp6w/ft7/y4Xso" +
       "f/rWYsR2f+tLhu87Lx6+w6h0hx+YGzFSzwzkPdLJHk7+qHIO4jtvCLFoKD04" +
       "iEq3wVfRq3kDe0l/GYhb8tvvyJNz66crW372aEl9rgYh8IOfXdlowcJzc2j3" +
       "FQMKz2gr7bn6Cz/0Xz/yGz/yzJeAFe+XbtvkmxVApU/pHBPnB0/+zqc/9vg9" +
       "H/2jHyq2AoHkc89L/+tdORb65sh6LCeL8+JAVmkxjIbF7p2q5JQVTRin6LGj" +
       "0q02gPiqqY2+dUHVwl776G84l3GkLadLN14oThb0tGoTG0HUdiBT5dSkQyxt" +
       "e8Owj2Eq3+xxU7/dabTIkEu95mg7UhvLBd/3pLYhD+pUb7zCaD1oknNlzOFy" +
       "uzqN13Q2sgfuDJuZ7TXStsbD3mox0Bttl1DmJDobL2kUKqMgMnOXjQkRhKPR" +
       "ujGpMq0W1IIWEARpLWiDbCujvhvF/NiO5uaAWuCeXV5X4UHHUVfThQCvVSbZ" +
       "auFmrSjKehMg/raO2v3ZqoXXraqH6HWlCZvaWIZlptLnu32JYojYRaz6QK7o" +
       "aYMcsLE/FIdwGhh4UtmwjaaQrhvJQhJGgkcqThQbwSRY0W5X7FETzbawXhZm" +
       "Oj5lLJFDk5atdJVBCDdr2AYyuTHbVcftBr9lo0gVsspSRPl+MK/oE9sZOUwt" +
       "GGw8y4JH0qQmMDDMexbPx5HX5GqBXgnT5ZzrC+XKKkBbDUgRB4wJ4+WlbcG1" +
       "clqPG4br1IcVO+tGUKSoVllsQepEnPmyMRUofEVNHM6DHU8hKgwZmFWzSTbI" +
       "2JvLKwTuJ8p8vfaRiJgQOBMMzChlSI3OYK874kXPE8g+srJSmY4b2wGih15A" +
       "0nBrgCCoO+erWpCNol5jOg97wnil1/RuZ5y19YFdnlNrNYLr1BBmLEqgR27c" +
       "i72l09UVe4ootTQw7XDcr2gVKyzTlD7rq0hDDgdlg6zJSdgIW5VMhRnZUyda" +
       "2FSG0iStLdTpdrBahUkZaguDIZYwSdrRJiMr3IrLql6f2CI5kL2m4jSottVu" +
       "9CvQ0iCrseiLdjLWuN58SlQH27SF4Z67mo0mvCZ5vXbcq8RzWxyE1AzR/Boy" +
       "pbu+tWYyPev1ORm1dKvHTQyVNDe45Pkibyz0oLKFukq9Vc1WQNRtbtxP+tkq" +
       "9tyaU8O8pWB4ZAqvaG+e9tqmxMBSXMGElrIy+jg2Ubu4F2budjUst9SYcu2Q" +
       "U0iHn02W42U3aAiNrBwgqxBFK9pA7aga3xOSbgoJQ5RNBtuN5XXr4/piNqPo" +
       "YWbKHiw4nG9T0aYKcWG5nGGtUcUSyxWnJfkxyY6MSQyjLiWPLDRczLw12hUH" +
       "DW07mPOBp7mt+rDe7NdSGl+XO17GqMtp1apaDlSdbJpoC5t0mTEmrD1CqTFi" +
       "M4k301B0yp3NRJDHQ11Wh/qWVWfTZg0tD1GiysKUI1bdKTM0E5RVV2JGlxeY" +
       "F27xYKBwvTI29Cp8GsCVetn3g5VXARqwaAZOBd04y5G8btNMhdIAJc5WbW6G" +
       "UsWcjHmlUse7lYUlQ/VZTyeVsJOGbSIRRnVNWHqNBq8hcBJIqpJCA8hue2RS" +
       "6w04sstY+HTA65m/iP2ZP/QrPLcOLYfjWJwnnc7UW48MB5Iwva3SMJoajaFP" +
       "t9K6yieyWLe2TNuwVxVpNnfXGhUlnj2ro3OqXM+jW6fKIRpX7y+BjhsNMdMd" +
       "1ejFUTUdklSDXTkDp6JhfciJhcWizYgYK8MVpUzhfmYterwRhPmZRKUi8FjX" +
       "80ZcDcSmThWurYhpDVWYxaKFxpsR1+9b/lRr9x2105ux2ViaGsv5RulKAj7T" +
       "eBjZTB00bZRr9U4E14aDVpXOTJufZUNWDPEGkS7ZOdNAeSqslJW1OTWRSgx3" +
       "YyfRdHyG6hlCiGSsWmuHRy1/TAhUwCqb7tKcW253xW/xSNSadDXtw5CLtm2c" +
       "7hsp5Dc7q2xM9bUtiVgC6wtrarbuygYdGMGIgnqxqpFLBKrb1a3c5yCu63ag" +
       "cX1SxbhkMY8kTJpzaIBKHXo9H6M+j2IBVKmrQwRViQaeLfgJMN0mb7E8vvXG" +
       "Rme7mkGxVnaq83KrxcZuMBqzi8XEJPGBISyNAWQ1BaG/7lZnSKUpsPaw2y17" +
       "zBJe8A1cS33TWC29GdYCpKkxwrLrgG+tCcpfJb446ToNdZOwrXK2kjJ40lJb" +
       "Wjzf9NfEykcXdt3Wpv3VtrxAGURsBNQMzIdqrPEQwU7hFaJ3h22hnCyxzEGC" +
       "xKpXDWpGbDqjmbK0eJhsksg8JKtJhLayrTqytirr9cl2ttEhvClvySWazChO" +
       "ndU6xIQD8svXWy0f1pCR0oLsBcl3BaurwAMC6HmPGU6dKs7MNh0jTrntZNMO" +
       "/VYtWo2mqLpMWw2qa6n6xEDMDgy1MY4RA6at84sAdvvNMhRUSRVpzSb1fstn" +
       "upVonmmpLq+ccbzSKQ9MD2V6q88WuMkLoodbK4kZrH1zU/baSsitGyay2Xbi" +
       "kSID42dCULRhY3YzXFcrE7JKj9hK1iLsOWkABemgWNzBoG3gppAGQZPqtGdO" +
       "BY9eNnqSZ0NbRV9FaIKUW3NzuZXimpH0Z2PIWtUbrdZABQOzVSMo6VFzN1TW" +
       "jK5RsCi3mkMWkupM0IAqJjfiRtZ0KWOtLsrQIyyhvK5e4SKyOsGseXkC7Ezb" +
       "hGNr3W1JtiAOF2JnGTbdLYKrLaEbtaSxLcaUFCVEvxFVdCzszOM6NiI28Nbt" +
       "i9OtYg5dH9DHCeS4Sa2JrcjACdNhrAXjmw1HtIZis65v25jXqM/BFIEZC80f" +
       "4bCzpBtJ5K/KDCcsKzJa58BsGqjjybgR0v1ejSY7aXkWEquNXteHxgpzBz7n" +
       "jLYYSc3N7rAq6cAiEFhZW/sEi+LRcs6m3Wa/q+CT8ppbd6e9XoOp8dhmNUmb" +
       "hF+P4bmJ6B6bOgtcXxuTSuaS/jZqGwZWbseDQBro8HJACQ67StDNaD5vstOe" +
       "7YYzlFlN0H57TKCMudYHqECtlI5Z1+UO213C3Nzioq5RGZGzcdmc4kN2LPOW" +
       "S5nKSDIWbCupl3ti4g0UgugZGZ62egi6RQ0x1uomSbebYppkfEAIBtcDc0VK" +
       "RJHuDaFEahIsBRFYnVphUELCnWpGBnyD7VXxTooFmTUc+u1WdUNLG3SlQn1D" +
       "78Hl6lhYBLVWALVm5TUPV2ZyL5bMRmPtJBVCHE6aC7SLcRNqEtTswCApBGpC" +
       "uIFu06SBi9gaTN7LyA5Ira+Vm5bmWqjS0kZuzxS2cmUZwQ1OnC9Ex9T6syVB" +
       "2lBiOvTGbzZQSINtaoFVyYSFLY8fSoChCDtXgtpoXjcYBjOg1VaLoJhj1USe" +
       "GECyJy08i6HZms3o2siZd6M4mLFoZ7wBPpO4qS5mCyYjk8RFEDtamj7B0Gy1" +
       "ZlToabLIUCGem52WYKYcOZ2t8Exmtkl7y1Yx3fW7K3ldsfENHzFiX21bZUii" +
       "FU3X1iOeGa9FSxTHdE2gNmLbtubGRmK6wXBjwFxdghtoW7Wa4dyYVbGh044W" +
       "MrSl9RYxIcnatJK1m6PWGBVr4xoFUJnNgeMlqsFwIVtVmZaxmNfirkaWGYvR" +
       "sGHWlqg51oZ8Rchwf+10tYlObVfCpBwRmuCoeGPamZcdnUWqPKMDXEsej3S0" +
       "TPbXm6qWoW1mNbZhs8ZCQQeb2Fy7J8zCDjQ30yYpzcdkh/T95gjmAxVacKzV" +
       "0jCZNuLWok3VeTy1cr5wtcE4Qu2u5CeDxkzGNDTt1ogY+FJYvzGV8TI2ShNy" +
       "MVvR3Gwl62NGVs1Kp77stXy7SSYGjEa4rklLngZ8CwUkHkz7QsqYiOF0y/Vm" +
       "NbEr2DZFlzWsRiIYRCX2fGI27RHPRbPmBul36KnBRa5lj4M23ZTxud0FVqEz" +
       "48SqvCKY+nIsGMD3hO0qr0OzWcgDvveagPVVVRy4SpfmB/3eBl3PaqbPwL7V" +
       "WE1qTNumZ9tOdV01nTnDDSOS0TZIZdp0hF5TI5Zwp65Eaysg2GaDDLqDbjBu" +
       "6uRqmHQnCxdD5+Qi00hagVIWXU6U6XQhM0ZkbMxmR97W+thgRU6x2lhNqcHa" +
       "6yk0x9UYAeEYyOlREFWXo5WlrabKlKwBWsflLJojPttXAyLA/IlU61DWqCLi" +
       "EceEojGv9rbDKhDumQfX1zNp6Gqd0Gog8QzG4lWTDz1DGJmyWhEDXaHSWiyt" +
       "1uNKmepniQT8PoPGyEzFoiWwtLq40HmxWx1qKbnmJbVLGCBAqvVwK+7hGe30" +
       "WgauYiwPoZVylYGg7Zjoz2gCI2a6PEC0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "WByw/38dGZilMVMAAA==");
}
