package edu.umd.cs.findbugs.detect;
public class SerializableIdiom extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "se.debug");
    static final boolean reportTransientFieldOfNonSerializableClass = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "reportTransientFieldOfNonSerializableClass");
    boolean sawSerialVersionUID;
    boolean isSerializable;
    boolean implementsSerializableDirectly;
    boolean isExternalizable;
    boolean isGUIClass;
    boolean isEjbImplClass;
    boolean isJSPClass;
    boolean foundSynthetic;
    boolean seenTransientField;
    boolean foundSynchronizedMethods;
    boolean writeObjectIsSynchronized;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    boolean isAbstract;
    private final java.util.List<edu.umd.cs.findbugs.BugInstance>
      fieldWarningList =
      new java.util.LinkedList<edu.umd.cs.findbugs.BugInstance>(
      );
    private final java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.ba.XField>
      fieldsThatMightBeAProblem =
      new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.ba.XField>(
      );
    private final java.util.HashMap<edu.umd.cs.findbugs.ba.XField,java.lang.Integer>
      transientFieldsUpdates =
      new java.util.HashMap<edu.umd.cs.findbugs.ba.XField,java.lang.Integer>(
      );
    private final java.util.HashSet<edu.umd.cs.findbugs.ba.XField>
      transientFieldsSetInConstructor =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    private final java.util.HashSet<edu.umd.cs.findbugs.ba.XField>
      transientFieldsSetToDefaultValueInConstructor =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    private boolean sawReadExternal;
    private boolean sawWriteExternal;
    private boolean sawReadObject;
    private boolean sawReadResolve;
    private boolean sawWriteObject;
    private boolean superClassImplementsSerializable;
    private boolean superClassHasReadObject;
    private boolean hasPublicVoidConstructor;
    private boolean superClassHasVoidConstructor;
    private boolean directlyImplementsExternalizable;
    private final boolean testingEnabled;
    public SerializableIdiom(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        testingEnabled =
          edu.umd.cs.findbugs.SystemProperties.
            getBoolean(
              "report_TESTING_pattern_in_standard_detectors");
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        classContext.
          getJavaClass(
            ).
          accept(
            this);
        flush(
          );
    }
    private void flush() { if (!isAbstract &&
                                 !(sawReadExternal &&
                                     sawWriteExternal ||
                                     sawReadObject &&
                                     sawWriteObject)) {
                               for (edu.umd.cs.findbugs.BugInstance aFieldWarningList
                                     :
                                     fieldWarningList) {
                                   bugReporter.
                                     reportBug(
                                       aFieldWarningList);
                               }
                           }
                           fieldWarningList.
                             clear(
                               ); }
    static final java.util.regex.Pattern anonymousInnerClassNamePattern =
      java.util.regex.Pattern.
      compile(
        ".+\\$\\d+");
    boolean isAnonymousInnerClass;
    boolean innerClassHasOuterInstance;
    private boolean isEnum;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        java.lang.String superClassname =
          obj.
          getSuperclassName(
            );
        isEnum =
          "java.lang.Enum".
            equals(
              superClassname);
        if (isEnum) {
            return;
        }
        int flags =
          obj.
          getAccessFlags(
            );
        isAbstract =
          (flags &
             ACC_ABSTRACT) !=
            0 ||
            (flags &
               ACC_INTERFACE) !=
            0;
        isAnonymousInnerClass =
          anonymousInnerClassNamePattern.
            matcher(
              getClassName(
                )).
            matches(
              );
        innerClassHasOuterInstance =
          false;
        for (org.apache.bcel.classfile.Field f
              :
              obj.
               getFields(
                 )) {
            if ("this$0".
                  equals(
                    f.
                      getName(
                        ))) {
                innerClassHasOuterInstance =
                  true;
                break;
            }
        }
        sawSerialVersionUID =
          false;
        isSerializable =
          (implementsSerializableDirectly =
             false);
        isExternalizable =
          false;
        directlyImplementsExternalizable =
          false;
        isGUIClass =
          false;
        isEjbImplClass =
          false;
        isJSPClass =
          false;
        seenTransientField =
          false;
        fieldsThatMightBeAProblem.
          clear(
            );
        transientFieldsUpdates.
          clear(
            );
        transientFieldsSetInConstructor.
          clear(
            );
        transientFieldsSetToDefaultValueInConstructor.
          clear(
            );
        java.lang.String[] interface_names =
          obj.
          getInterfaceNames(
            );
        for (java.lang.String interface_name
              :
              interface_names) {
            if ("java.io.Externalizable".
                  equals(
                    interface_name)) {
                directlyImplementsExternalizable =
                  true;
                isExternalizable =
                  true;
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Directly implements Externalizable: " +
                        getClassName(
                          ));
                }
            }
            else
                if ("java.io.Serializable".
                      equals(
                        interface_name)) {
                    implementsSerializableDirectly =
                      true;
                    isSerializable =
                      true;
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Directly implements Serializable: " +
                            getClassName(
                              ));
                    }
                    break;
                }
        }
        if (!isSerializable) {
            if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                  instanceOf(
                    obj,
                    "java.io.Externalizable")) {
                isExternalizable =
                  true;
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Indirectly implements Externalizable: " +
                        getClassName(
                          ));
                }
            }
            if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                  instanceOf(
                    obj,
                    "java.io.Serializable")) {
                isSerializable =
                  true;
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Indirectly implements Serializable: " +
                        getClassName(
                          ));
                }
            }
        }
        hasPublicVoidConstructor =
          false;
        superClassHasVoidConstructor =
          true;
        superClassHasReadObject =
          false;
        superClassImplementsSerializable =
          isSerializable &&
            !implementsSerializableDirectly;
        edu.umd.cs.findbugs.classfile.ClassDescriptor superclassDescriptor =
          getXClass(
            ).
          getSuperclassDescriptor(
            );
        if (superclassDescriptor !=
              null) {
            try {
                edu.umd.cs.findbugs.ba.XClass superXClass =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    superclassDescriptor);
                if (superXClass !=
                      null) {
                    superClassImplementsSerializable =
                      edu.umd.cs.findbugs.ba.AnalysisContext.
                        currentAnalysisContext(
                          ).
                        getSubtypes2(
                          ).
                        isSubtype(
                          superXClass.
                            getClassDescriptor(
                              ),
                          edu.umd.cs.findbugs.classfile.DescriptorFactory.
                            createClassDescriptor(
                              java.io.Serializable.class));
                    superClassHasVoidConstructor =
                      false;
                    for (edu.umd.cs.findbugs.ba.XMethod m
                          :
                          superXClass.
                           getXMethods(
                             )) {
                        if ("<init>".
                              equals(
                                m.
                                  getName(
                                    )) &&
                              "()V".
                              equals(
                                m.
                                  getSignature(
                                    )) &&
                              !m.
                              isPrivate(
                                )) {
                            superClassHasVoidConstructor =
                              true;
                        }
                        if ("readObject".
                              equals(
                                m.
                                  getName(
                                    )) &&
                              "(Ljava/io/ObjectInputStream;)V".
                              equals(
                                m.
                                  getSignature(
                                    )) &&
                              m.
                              isPrivate(
                                )) {
                            superClassHasReadObject =
                              true;
                        }
                    }
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                bugReporter.
                  reportMissingClass(
                    e);
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Error while analyzing " +
                    obj.
                      getClassName(
                        ),
                    e);
            }
        }
        isGUIClass =
          false;
        isEjbImplClass =
          false;
        if (true) {
            isEjbImplClass =
              edu.umd.cs.findbugs.ba.ch.Subtypes2.
                instanceOf(
                  obj,
                  "javax.ejb.SessionBean");
            isJSPClass =
              edu.umd.cs.findbugs.ba.ch.Subtypes2.
                isJSP(
                  obj);
            isGUIClass =
              edu.umd.cs.findbugs.ba.ch.Subtypes2.
                instanceOf(
                  obj,
                  "java.lang.Throwable") ||
                edu.umd.cs.findbugs.ba.ch.Subtypes2.
                instanceOf(
                  obj,
                  "java.awt.Component") ||
                edu.umd.cs.findbugs.ba.ch.Subtypes2.
                instanceOf(
                  obj,
                  "java.awt.Component$AccessibleAWTComponent") ||
                edu.umd.cs.findbugs.ba.ch.Subtypes2.
                instanceOf(
                  obj,
                  "java.awt.event.ActionListener") ||
                edu.umd.cs.findbugs.ba.ch.Subtypes2.
                instanceOf(
                  obj,
                  "java.util.EventListener");
            if (!isGUIClass) {
                org.apache.bcel.classfile.JavaClass o =
                  obj;
                while (o !=
                         null) {
                    if (o.
                          getClassName(
                            ).
                          startsWith(
                            "java.awt") ||
                          o.
                          getClassName(
                            ).
                          startsWith(
                            "javax.swing")) {
                        isGUIClass =
                          true;
                        break;
                    }
                    try {
                        o =
                          o.
                            getSuperClass(
                              );
                    }
                    catch (java.lang.ClassNotFoundException e) {
                        break;
                    }
                }
            }
        }
        foundSynthetic =
          false;
        foundSynchronizedMethods =
          false;
        writeObjectIsSynchronized =
          false;
        sawReadExternal =
          (sawWriteExternal =
             (sawReadObject =
                (sawReadResolve =
                   (sawWriteObject =
                      false))));
        if (isSerializable) {
            for (org.apache.bcel.classfile.Method m
                  :
                  obj.
                   getMethods(
                     )) {
                if ("readObject".
                      equals(
                        m.
                          getName(
                            )) &&
                      "(Ljava/io/ObjectInputStream;)V".
                      equals(
                        m.
                          getSignature(
                            ))) {
                    sawReadObject =
                      true;
                }
                else
                    if ("readResolve".
                          equals(
                            m.
                              getName(
                                )) &&
                          m.
                          getSignature(
                            ).
                          startsWith(
                            "()")) {
                        sawReadResolve =
                          true;
                    }
                    else
                        if ("readObjectNoData".
                              equals(
                                m.
                                  getName(
                                    )) &&
                              "()V".
                              equals(
                                m.
                                  getSignature(
                                    ))) {
                            sawReadObject =
                              true;
                        }
                        else
                            if ("writeObject".
                                  equals(
                                    m.
                                      getName(
                                        )) &&
                                  "(Ljava/io/ObjectOutputStream;)V".
                                  equals(
                                    m.
                                      getSignature(
                                        ))) {
                                sawWriteObject =
                                  true;
                            }
            }
            for (org.apache.bcel.classfile.Field f
                  :
                  obj.
                   getFields(
                     )) {
                if (f.
                      isTransient(
                        )) {
                    seenTransientField =
                      true;
                }
            }
        }
    }
    private boolean strongEvidenceForIntendedSerialization() {
        return implementsSerializableDirectly ||
          sawReadObject ||
          sawReadResolve ||
          sawWriteObject ||
          seenTransientField ||
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getUnreadFieldsData(
            ).
          existsStrongEvidenceForIntendedSerialization(
            this.
              getClassDescriptor(
                ));
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        if (isEnum) {
            return;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                getDottedClassName(
                  ));
            java.lang.System.
              out.
              println(
                "  hasPublicVoidConstructor: " +
                hasPublicVoidConstructor);
            java.lang.System.
              out.
              println(
                "  superClassHasVoidConstructor: " +
                superClassHasVoidConstructor);
            java.lang.System.
              out.
              println(
                "  isExternalizable: " +
                isExternalizable);
            java.lang.System.
              out.
              println(
                "  isSerializable: " +
                isSerializable);
            java.lang.System.
              out.
              println(
                "  isAbstract: " +
                isAbstract);
            java.lang.System.
              out.
              println(
                "  superClassImplementsSerializable: " +
                superClassImplementsSerializable);
            java.lang.System.
              out.
              println(
                "  isGUIClass: " +
                isGUIClass);
            java.lang.System.
              out.
              println(
                "  isEjbImplClass: " +
                isEjbImplClass);
            java.lang.System.
              out.
              println(
                "  isJSPClass: " +
                isJSPClass);
        }
        if (isSerializable &&
              !sawReadObject &&
              !sawReadResolve &&
              seenTransientField &&
              !superClassHasReadObject) {
            for (java.util.Map.Entry<edu.umd.cs.findbugs.ba.XField,java.lang.Integer> e
                  :
                  transientFieldsUpdates.
                   entrySet(
                     )) {
                edu.umd.cs.findbugs.ba.XField fieldX =
                  e.
                  getKey(
                    );
                int priority =
                  NORMAL_PRIORITY;
                if (transientFieldsSetInConstructor.
                      contains(
                        e.
                          getKey(
                            ))) {
                    priority--;
                }
                if (isGUIClass) {
                    priority++;
                }
                if (isEjbImplClass) {
                    priority++;
                }
                if (isJSPClass) {
                    priority++;
                }
                if (e.
                      getValue(
                        ) <
                      3) {
                    priority++;
                }
                if (transientFieldsSetToDefaultValueInConstructor.
                      contains(
                        e.
                          getKey(
                            ))) {
                    priority++;
                }
                if (obj.
                      isAbstract(
                        )) {
                    priority++;
                    if (priority <
                          edu.umd.cs.findbugs.Priorities.
                            LOW_PRIORITY) {
                        priority =
                          edu.umd.cs.findbugs.Priorities.
                            LOW_PRIORITY;
                    }
                }
                try {
                    double isSerializable =
                      edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                      isDeepSerializable(
                        fieldX.
                          getSignature(
                            ));
                    if (isSerializable <
                          0.6) {
                        priority++;
                    }
                }
                catch (java.lang.ClassNotFoundException e1) {
                    
                }
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "SE_TRANSIENT_FIELD_NOT_RESTORED",
                      priority).
                      addClass(
                        getThisClass(
                          )).
                      addField(
                        fieldX));
            }
        }
        if (isSerializable &&
              !isExternalizable &&
              !superClassHasVoidConstructor &&
              !superClassImplementsSerializable) {
            int priority =
              implementsSerializableDirectly ||
              seenTransientField
              ? HIGH_PRIORITY
              : (sawSerialVersionUID
                   ? NORMAL_PRIORITY
                   : LOW_PRIORITY);
            if (isGUIClass ||
                  isEjbImplClass ||
                  isJSPClass) {
                priority++;
            }
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "SE_NO_SUITABLE_CONSTRUCTOR",
                  priority).
                  addClass(
                    getThisClass(
                      ).
                      getClassName(
                        )));
        }
        int priority =
          isGUIClass ||
          isEjbImplClass ||
          isJSPClass
          ? LOW_PRIORITY
          : NORMAL_PRIORITY;
        if (obj.
              getClassName(
                ).
              endsWith(
                "_Stub")) {
            priority++;
        }
        if (isExternalizable &&
              !hasPublicVoidConstructor &&
              !isAbstract) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "SE_NO_SUITABLE_CONSTRUCTOR_FOR_EXTERNALIZATION",
                  directlyImplementsExternalizable
                    ? HIGH_PRIORITY
                    : NORMAL_PRIORITY).
                  addClass(
                    getThisClass(
                      ).
                      getClassName(
                        )));
        }
        if (!foundSynthetic) {
            priority++;
        }
        if (seenTransientField) {
            priority--;
        }
        if (!isAnonymousInnerClass &&
              !isExternalizable &&
              !isGUIClass &&
              !obj.
              isAbstract(
                ) &&
              isSerializable &&
              !isAbstract &&
              !sawSerialVersionUID &&
              !isEjbImplClass &&
              !isJSPClass) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "SE_NO_SERIALVERSIONID",
                  priority).
                  addClass(
                    this));
        }
        if (writeObjectIsSynchronized &&
              !foundSynchronizedMethods) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "WS_WRITEOBJECT_SYNC",
                  LOW_PRIORITY).
                  addClass(
                    this));
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        int accessFlags =
          obj.
          getAccessFlags(
            );
        boolean isSynchronized =
          (accessFlags &
             ACC_SYNCHRONIZED) !=
          0;
        if ("<init>".
              equals(
                getMethodName(
                  )) &&
              "()V".
              equals(
                getMethodSig(
                  )) &&
              (accessFlags &
                 ACC_PUBLIC) !=
              0) {
            hasPublicVoidConstructor =
              true;
        }
        if (!"<init>".
              equals(
                getMethodName(
                  )) &&
              isSynthetic(
                obj)) {
            foundSynthetic =
              true;
        }
        if ("readExternal".
              equals(
                getMethodName(
                  )) &&
              "(Ljava/io/ObjectInput;)V".
              equals(
                getMethodSig(
                  ))) {
            sawReadExternal =
              true;
            if (DEBUG &&
                  !obj.
                  isPrivate(
                    )) {
                java.lang.System.
                  out.
                  println(
                    "Non-private readExternal method in: " +
                    getDottedClassName(
                      ));
            }
        }
        else
            if ("writeExternal".
                  equals(
                    getMethodName(
                      )) &&
                  "(Ljava/io/Objectoutput;)V".
                  equals(
                    getMethodSig(
                      ))) {
                sawWriteExternal =
                  true;
                if (DEBUG &&
                      !obj.
                      isPrivate(
                        )) {
                    java.lang.System.
                      out.
                      println(
                        "Non-private writeExternal method in: " +
                        getDottedClassName(
                          ));
                }
            }
            else
                if ("readResolve".
                      equals(
                        getMethodName(
                          )) &&
                      getMethodSig(
                        ).
                      startsWith(
                        "()") &&
                      isSerializable) {
                    sawReadResolve =
                      true;
                    if (!"()Ljava/lang/Object;".
                          equals(
                            getMethodSig(
                              ))) {
                        bugReporter.
                          reportBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              "SE_READ_RESOLVE_MUST_RETURN_OBJECT",
                              HIGH_PRIORITY).
                              addClassAndMethod(
                                this));
                    }
                    else
                        if (obj.
                              isStatic(
                                )) {
                            bugReporter.
                              reportBug(
                                new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  "SE_READ_RESOLVE_IS_STATIC",
                                  HIGH_PRIORITY).
                                  addClassAndMethod(
                                    this));
                        }
                        else
                            if (obj.
                                  isPrivate(
                                    )) {
                                try {
                                    java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> subtypes =
                                      edu.umd.cs.findbugs.ba.AnalysisContext.
                                      currentAnalysisContext(
                                        ).
                                      getSubtypes2(
                                        ).
                                      getSubtypes(
                                        getClassDescriptor(
                                          ));
                                    if (subtypes.
                                          size(
                                            ) >
                                          1) {
                                        edu.umd.cs.findbugs.BugInstance bug =
                                          new edu.umd.cs.findbugs.BugInstance(
                                          this,
                                          "SE_PRIVATE_READ_RESOLVE_NOT_INHERITED",
                                          NORMAL_PRIORITY).
                                          addClassAndMethod(
                                            this);
                                        boolean nasty =
                                          false;
                                        for (edu.umd.cs.findbugs.classfile.ClassDescriptor subclass
                                              :
                                              subtypes) {
                                            if (!subclass.
                                                  equals(
                                                    getClassDescriptor(
                                                      ))) {
                                                edu.umd.cs.findbugs.ba.XClass xSub =
                                                  edu.umd.cs.findbugs.ba.AnalysisContext.
                                                  currentXFactory(
                                                    ).
                                                  getXClass(
                                                    subclass);
                                                if (xSub !=
                                                      null &&
                                                      xSub.
                                                      findMethod(
                                                        "readResolve",
                                                        "()Ljava/lang/Object;",
                                                        false) ==
                                                      null &&
                                                      xSub.
                                                      findMethod(
                                                        "writeReplace",
                                                        "()Ljava/lang/Object;",
                                                        false) ==
                                                      null) {
                                                    bug.
                                                      addClass(
                                                        subclass).
                                                      describe(
                                                        edu.umd.cs.findbugs.ClassAnnotation.
                                                          SUBCLASS_ROLE);
                                                    nasty =
                                                      true;
                                                }
                                            }
                                        }
                                        if (nasty) {
                                            bug.
                                              setPriority(
                                                HIGH_PRIORITY);
                                        }
                                        else
                                            if (!getThisClass(
                                                   ).
                                                  isPublic(
                                                    )) {
                                                bug.
                                                  setPriority(
                                                    LOW_PRIORITY);
                                            }
                                        bugReporter.
                                          reportBug(
                                            bug);
                                    }
                                }
                                catch (java.lang.ClassNotFoundException e) {
                                    bugReporter.
                                      reportMissingClass(
                                        e);
                                }
                            }
                }
                else
                    if ("readObject".
                          equals(
                            getMethodName(
                              )) &&
                          "(Ljava/io/ObjectInputStream;)V".
                          equals(
                            getMethodSig(
                              )) &&
                          isSerializable) {
                        sawReadObject =
                          true;
                        if (!obj.
                              isPrivate(
                                )) {
                            bugReporter.
                              reportBug(
                                new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  "SE_METHOD_MUST_BE_PRIVATE",
                                  isExternalizable
                                    ? NORMAL_PRIORITY
                                    : HIGH_PRIORITY).
                                  addClassAndMethod(
                                    this));
                        }
                    }
                    else
                        if ("readObjectNoData".
                              equals(
                                getMethodName(
                                  )) &&
                              "()V".
                              equals(
                                getMethodSig(
                                  )) &&
                              isSerializable) {
                            if (!obj.
                                  isPrivate(
                                    )) {
                                bugReporter.
                                  reportBug(
                                    new edu.umd.cs.findbugs.BugInstance(
                                      this,
                                      "SE_METHOD_MUST_BE_PRIVATE",
                                      isExternalizable
                                        ? NORMAL_PRIORITY
                                        : HIGH_PRIORITY).
                                      addClassAndMethod(
                                        this));
                            }
                        }
                        else
                            if ("writeObject".
                                  equals(
                                    getMethodName(
                                      )) &&
                                  "(Ljava/io/ObjectOutputStream;)V".
                                  equals(
                                    getMethodSig(
                                      )) &&
                                  isSerializable) {
                                sawWriteObject =
                                  true;
                                if (!obj.
                                      isPrivate(
                                        )) {
                                    bugReporter.
                                      reportBug(
                                        new edu.umd.cs.findbugs.BugInstance(
                                          this,
                                          "SE_METHOD_MUST_BE_PRIVATE",
                                          isExternalizable
                                            ? NORMAL_PRIORITY
                                            : HIGH_PRIORITY).
                                          addClassAndMethod(
                                            this));
                                }
                            }
        if (isSynchronized) {
            if ("readObject".
                  equals(
                    getMethodName(
                      )) &&
                  "(Ljava/io/ObjectInputStream;)V".
                  equals(
                    getMethodSig(
                      )) &&
                  isSerializable) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "RS_READOBJECT_SYNC",
                      isExternalizable
                        ? LOW_PRIORITY
                        : NORMAL_PRIORITY).
                      addClassAndMethod(
                        this));
            }
            else
                if ("writeObject".
                      equals(
                        getMethodName(
                          )) &&
                      "(Ljava/io/ObjectOutputStream;)V".
                      equals(
                        getMethodSig(
                          )) &&
                      isSerializable) {
                    writeObjectIsSynchronized =
                      true;
                }
                else {
                    foundSynchronizedMethods =
                      true;
                }
        }
        super.
          visit(
            obj);
    }
    boolean isSynthetic(org.apache.bcel.classfile.FieldOrMethod obj) {
        org.apache.bcel.classfile.Attribute[] a =
          obj.
          getAttributes(
            );
        for (org.apache.bcel.classfile.Attribute aA
              :
              a) {
            if (aA instanceof org.apache.bcel.classfile.Synthetic) {
                return true;
            }
        }
        return false;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (isSerializable) {
            super.
              visit(
                obj);
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            PUTFIELD) {
                                          edu.umd.cs.findbugs.ba.XField xField =
                                            getXFieldOperand(
                                              );
                                          if (xField !=
                                                null &&
                                                xField.
                                                getClassDescriptor(
                                                  ).
                                                equals(
                                                  getClassDescriptor(
                                                    ))) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item first =
                                                stack.
                                                getStackItem(
                                                  0);
                                              boolean isPutOfDefaultValue =
                                                first.
                                                isNull(
                                                  );
                                              if (!isPutOfDefaultValue &&
                                                    first.
                                                    getConstant(
                                                      ) !=
                                                    null &&
                                                    !first.
                                                    isArray(
                                                      )) {
                                                  java.lang.Object constant =
                                                    first.
                                                    getConstant(
                                                      );
                                                  if (constant instanceof java.lang.Number &&
                                                        ((java.lang.Number)
                                                           constant).
                                                        intValue(
                                                          ) ==
                                                        0 ||
                                                        constant.
                                                        equals(
                                                          java.lang.Boolean.
                                                            FALSE)) {
                                                      isPutOfDefaultValue =
                                                        true;
                                                  }
                                              }
                                              if (isPutOfDefaultValue) {
                                                  if ("<init>".
                                                        equals(
                                                          getMethodName(
                                                            ))) {
                                                      transientFieldsSetToDefaultValueInConstructor.
                                                        add(
                                                          xField);
                                                  }
                                              }
                                              else {
                                                  java.lang.String nameOfField =
                                                    getNameConstantOperand(
                                                      );
                                                  if (transientFieldsUpdates.
                                                        containsKey(
                                                          xField)) {
                                                      if ("<init>".
                                                            equals(
                                                              getMethodName(
                                                                ))) {
                                                          transientFieldsSetInConstructor.
                                                            add(
                                                              xField);
                                                      }
                                                      else {
                                                          transientFieldsUpdates.
                                                            put(
                                                              xField,
                                                              transientFieldsUpdates.
                                                                get(
                                                                  xField) +
                                                                1);
                                                      }
                                                  }
                                                  else
                                                      if (fieldsThatMightBeAProblem.
                                                            containsKey(
                                                              nameOfField)) {
                                                          try {
                                                              org.apache.bcel.classfile.JavaClass classStored =
                                                                first.
                                                                getJavaClass(
                                                                  );
                                                              if (classStored ==
                                                                    null) {
                                                                  return;
                                                              }
                                                              double isSerializable =
                                                                edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                                                                isDeepSerializable(
                                                                  classStored);
                                                              if (isSerializable <=
                                                                    0.2) {
                                                                  edu.umd.cs.findbugs.ba.XField f =
                                                                    fieldsThatMightBeAProblem.
                                                                    get(
                                                                      nameOfField);
                                                                  java.lang.String sig =
                                                                    f.
                                                                    getSignature(
                                                                      );
                                                                  java.lang.String genSig =
                                                                    "L" +
                                                                  classStored.
                                                                    getClassName(
                                                                      ).
                                                                    replace(
                                                                      '.',
                                                                      '/') +
                                                                  ";";
                                                                  if (!sig.
                                                                        equals(
                                                                          genSig)) {
                                                                      double bias =
                                                                        0.0;
                                                                      if (!"<init>".
                                                                            equals(
                                                                              getMethodName(
                                                                                ))) {
                                                                          bias =
                                                                            1.0;
                                                                      }
                                                                      int priority =
                                                                        computePriority(
                                                                          isSerializable,
                                                                          bias);
                                                                      fieldWarningList.
                                                                        add(
                                                                          new edu.umd.cs.findbugs.BugInstance(
                                                                            this,
                                                                            "SE_BAD_FIELD_STORE",
                                                                            priority).
                                                                            addClass(
                                                                              getThisClass(
                                                                                ).
                                                                                getClassName(
                                                                                  )).
                                                                            addField(
                                                                              f).
                                                                            addType(
                                                                              genSig).
                                                                            describe(
                                                                              "TYPE_FOUND").
                                                                            addSourceLine(
                                                                              this));
                                                                  }
                                                              }
                                                          }
                                                          catch (java.lang.ClassNotFoundException e) {
                                                              
                                                          }
                                                      }
                                              }
                                          }
                                      } }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) {
        int flags =
          obj.
          getAccessFlags(
            );
        java.lang.String genericSignature =
          obj.
          getGenericSignature(
            );
        if (genericSignature !=
              null &&
              genericSignature.
              startsWith(
                "T")) {
            return;
        }
        edu.umd.cs.findbugs.ba.FieldSummary fieldSummary =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getFieldSummary(
            );
        edu.umd.cs.findbugs.OpcodeStack.Item summary =
          fieldSummary.
          getSummary(
            getXField(
              ));
        java.lang.String fieldSig =
          summary.
          getSignature(
            );
        if (isEjbImplClass) {
            edu.umd.cs.findbugs.classfile.ClassDescriptor fieldType =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
              createClassDescriptorFromFieldSignature(
                fieldSig);
            if (fieldType !=
                  null) {
                if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      instanceOf(
                        fieldType,
                        "javax.ejb.SessionContext") ||
                      edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      instanceOf(
                        fieldType,
                        "javax.transaction.UserTransaction") ||
                      edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      instanceOf(
                        fieldType,
                        "javax.ejb.EJBHome") ||
                      edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      instanceOf(
                        fieldType,
                        "javax.ejb.EJBObject") ||
                      edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      instanceOf(
                        fieldType,
                        "javax.naming.Context")) {
                    if (testingEnabled &&
                          obj.
                          isTransient(
                            )) {
                        bugReporter.
                          reportBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              "TESTING",
                              NORMAL_PRIORITY).
                              addClass(
                                this).
                              addVisitedField(
                                this).
                              addString(
                                ("EJB implementation classes should not have fields of this ty" +
                                 "pe")));
                    }
                    return;
                }
            }
        }
        if (obj.
              isTransient(
                )) {
            if (isSerializable &&
                  !isExternalizable) {
                seenTransientField =
                  true;
                transientFieldsUpdates.
                  put(
                    getXField(
                      ),
                    0);
            }
            else
                if (reportTransientFieldOfNonSerializableClass) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "SE_TRANSIENT_FIELD_OF_NONSERIALIZABLE_CLASS",
                          NORMAL_PRIORITY).
                          addClass(
                            this).
                          addVisitedField(
                            this));
                }
        }
        else
            if (getClassName(
                  ).
                  indexOf(
                    "ObjectStreamClass") ==
                  -1 &&
                  isSerializable &&
                  !isExternalizable &&
                  fieldSig.
                  indexOf(
                    'L') >=
                  0 &&
                  !obj.
                  isTransient(
                    ) &&
                  !obj.
                  isStatic(
                    )) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Examining non-transient field with name: " +
                        getFieldName(
                          ) +
                        ", sig: " +
                        fieldSig);
                }
                edu.umd.cs.findbugs.ba.XField xfield =
                  getXField(
                    );
                org.apache.bcel.generic.Type type =
                  edu.umd.cs.findbugs.ba.type.TypeFrameModelingVisitor.
                  getType(
                    xfield);
                if (type instanceof org.apache.bcel.generic.ReferenceType) {
                    try {
                        org.apache.bcel.generic.ReferenceType rtype =
                          (org.apache.bcel.generic.ReferenceType)
                            type;
                        double isSerializable =
                          edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                          isDeepSerializable(
                            rtype);
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "  isSerializable: " +
                                isSerializable);
                        }
                        if (isSerializable <
                              1.0) {
                            fieldsThatMightBeAProblem.
                              put(
                                obj.
                                  getName(
                                    ),
                                xfield);
                        }
                        if (isSerializable <
                              0.9) {
                            org.apache.bcel.generic.ReferenceType problemType =
                              edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                              getLeastSerializableTypeComponent(
                                rtype);
                            int priority =
                              computePriority(
                                isSerializable,
                                0);
                            if (!strongEvidenceForIntendedSerialization(
                                   )) {
                                if (obj.
                                      getName(
                                        ).
                                      startsWith(
                                        "this$")) {
                                    priority =
                                      java.lang.Math.
                                        max(
                                          priority,
                                          NORMAL_PRIORITY);
                                }
                                if (innerClassHasOuterInstance) {
                                    if (isAnonymousInnerClass) {
                                        priority +=
                                          2;
                                    }
                                    else {
                                        priority +=
                                          1;
                                    }
                                }
                                if (isGUIClass ||
                                      isEjbImplClass ||
                                      isJSPClass) {
                                    priority++;
                                }
                            }
                            else
                                if (isGUIClass ||
                                      isEjbImplClass ||
                                      isJSPClass) {
                                    priority =
                                      java.lang.Math.
                                        max(
                                          priority,
                                          NORMAL_PRIORITY);
                                }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    "SE_BAD_FIELD: " +
                                    getThisClass(
                                      ).
                                      getClassName(
                                        ) +
                                    " " +
                                    obj.
                                      getName(
                                        ) +
                                    " " +
                                    isSerializable +
                                    " " +
                                    implementsSerializableDirectly +
                                    " " +
                                    sawSerialVersionUID +
                                    " " +
                                    isGUIClass +
                                    " " +
                                    isEjbImplClass);
                            }
                            if ("this$0".
                                  equals(
                                    obj.
                                      getName(
                                        ))) {
                                fieldWarningList.
                                  add(
                                    new edu.umd.cs.findbugs.BugInstance(
                                      this,
                                      "SE_BAD_FIELD_INNER_CLASS",
                                      priority).
                                      addClass(
                                        getThisClass(
                                          ).
                                          getClassName(
                                            )));
                            }
                            else
                                if (isSerializable <
                                      0.9) {
                                    fieldWarningList.
                                      add(
                                        new edu.umd.cs.findbugs.BugInstance(
                                          this,
                                          "SE_BAD_FIELD",
                                          priority).
                                          addClass(
                                            getThisClass(
                                              ).
                                              getClassName(
                                                )).
                                          addField(
                                            xfield).
                                          addType(
                                            problemType).
                                          describe(
                                            "TYPE_FOUND"));
                                }
                        }
                        else
                            if (!isGUIClass &&
                                  !isEjbImplClass &&
                                  !isJSPClass &&
                                  "this$0".
                                  equals(
                                    obj.
                                      getName(
                                        ))) {
                                fieldWarningList.
                                  add(
                                    new edu.umd.cs.findbugs.BugInstance(
                                      this,
                                      "SE_INNER_CLASS",
                                      implementsSerializableDirectly
                                        ? NORMAL_PRIORITY
                                        : LOW_PRIORITY).
                                      addClass(
                                        getThisClass(
                                          ).
                                          getClassName(
                                            )));
                            }
                    }
                    catch (java.lang.ClassNotFoundException e) {
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "Caught ClassNotFoundException");
                        }
                        bugReporter.
                          reportMissingClass(
                            e);
                    }
                }
            }
        if (!getFieldName(
               ).
              startsWith(
                "this") &&
              isSynthetic(
                obj)) {
            foundSynthetic =
              true;
        }
        if (!"serialVersionUID".
              equals(
                getFieldName(
                  ))) {
            return;
        }
        int mask =
          ACC_STATIC |
          ACC_FINAL;
        if (!"I".
              equals(
                fieldSig) &&
              !"J".
              equals(
                fieldSig)) {
            return;
        }
        if ((flags &
               mask) ==
              mask &&
              "I".
              equals(
                fieldSig)) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "SE_NONLONG_SERIALVERSIONID",
                  LOW_PRIORITY).
                  addClass(
                    this).
                  addVisitedField(
                    this));
            sawSerialVersionUID =
              true;
            return;
        }
        else
            if ((flags &
                   ACC_STATIC) ==
                  0) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "SE_NONSTATIC_SERIALVERSIONID",
                      NORMAL_PRIORITY).
                      addClass(
                        this).
                      addVisitedField(
                        this));
                return;
            }
            else
                if ((flags &
                       ACC_FINAL) ==
                      0) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "SE_NONFINAL_SERIALVERSIONID",
                          NORMAL_PRIORITY).
                          addClass(
                            this).
                          addVisitedField(
                            this));
                    return;
                }
        sawSerialVersionUID =
          true;
    }
    private int computePriority(double isSerializable,
                                double bias) {
        int priority =
          (int)
            (1.9 +
               isSerializable *
               3 +
               bias);
        if (strongEvidenceForIntendedSerialization(
              )) {
            priority--;
        }
        else
            if (sawSerialVersionUID &&
                  priority >
                  NORMAL_PRIORITY) {
                priority--;
            }
            else {
                priority =
                  java.lang.Math.
                    max(
                      priority,
                      NORMAL_PRIORITY);
            }
        return priority;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zxH2SJ+O/h/aXF7umUUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UHkfzzcdGVuTzrrBm1BOL4myDFK0QxntQUneCco3naHyDpBSr0BF4x3SeA9S" +
       "7o5UVNot+Z4o6G1XXA++7pLD43MgpTu06R60/B0Pj4+AmC0AoWbPyvBdtMBz" +
       "IFxyC2UB0kd2AD+yB6B6C4Bnt1Ce4i3bSkw79IeWtVMDDEwOcT7ImD0Kik7t" +
       "xHogaIyv766f64t2yeWgbED6/l1fvn9PX2637v56zUdu7sNFTF928f2rQfro" +
       "Dt1H96C73eL7k9oxJGBds+z5sKPJ5kUQL7EYn9tWtsT8gzuIP7gH4p7F+LO2" +
       "da/mZxPuizDdfiU+byM+OAgK98DXG9ezRcKDPWvtd2WHX3OzHj6uG+K1o/3X" +
       "3dbYNd1oZJf/+1lA2XbnHQLyz6woTGxr9cJ3/pfv/dXvefa3DwsHo8I9URah" +
       "xt7pqSEWZg8ufvsnP/Lmh176ne/MnyABXJHPCX/ytVm39qzX7+vWk1m3SDv0" +
       "RHnC+8E0f+hDlrKe5U2MT/VnFhTuNgDEV9zb4I3vQKv+EDn6TRmhU0HEmLPC" +
       "pWQmE8xcTLqluJgMBN/rV1YERs69FJo6HLeo+kaSdIblxiyNpAnrp3iXGheh" +
       "vo62K/0KlxD0TJtCeg9rSZqTtJF1LMWKOCRFZ1lDVr1wOBQ7S0SkwtqQ4Tbo" +
       "vL6ih8vlOsErLXhUQSm72JytMboswLqpNEqlqF4Cv6gV45HtmjOd49RVQg2V" +
       "ld/Q5vWu014KG2EdLpcDEVlqS1ouRnSlnhabKUwt+zRenZs6qc8wg4mbAxar" +
       "p4bV6VSY7lC0VduVGnPdGveWfLyqw/N4oZkiS5iuWIsIZlIuk5jQxVKzzbLM" +
       "bEObLkSwZsQN/UFrteq3yfIMGU1NYtQNO1YroPgh5y6iSKqu/FYs+M0lrI9W" +
       "Rrgkyu0J7zYTVyMnc2xGjUVIbZC0sFx0uGJUUyskMVp2xqNIcQ1ixQh0TVq4" +
       "iy4DNeFSSdbD9Zw3V7o5Zjmtp8mKvxnWHb04Ejv6oiFUAmiJtkNCkNVQnbtN" +
       "FcDvlBlPJ0YGyauQN4YEzUDweCrE9HiZiITK0Y2ysbbbPYEi0+acFMb0Ch4T" +
       "HBd2CWJI+XpbWy+ZwdxYB9xInsw7tRHaCEpS05LKLroeYotggFcXOrJadQwi" +
       "aRNWT9Vg2BrWlG5I9iC42h00fBl2Qp0PB7rDrEUBU+ekOmMjt7ooTvoey1mL" +
       "emiP4DZm+fbamYbJSLZUky4OWu7SkAeEJNQ8NxY3fgXCCZ11kd5mVi8iFcIk" +
       "x4oPDSGFaGrt/lzk4XodQda9qsd2Rxrjujyr6RvEY5Jeq8ewqc5165zV7eFz" +
       "l2RZu1chhppBuWYwoRXR2aRqd0KNiIkPlQjecqj2gFbH7dpmMZ72GhRprxFP" +
       "ljyrIpeXFXTh+eJiaMfqKjX7jFPShNVA5VaDFZqaU2EVtzYb1fLokug0G63W" +
       "bFgl+qPqcjxNJ6UpblW8lrlpjKi0NE00CB+3BssKC9gp9+TEL9ckyGNCOob7" +
       "ENALfc0KlUSsNRtjqIiNZF/rdtJxa+O0m1SNLVqSHleqRRivlksDejGNXEPC" +
       "ImaFzGpuYK6YCdTotyYUv/HmHbEOLSmfQz02aDUgal6lzPWgZpYaTWuNrstV" +
       "aL6Qo/q6AuP1ld1NEltTPXVB4QkXWRztr4ZyUuM6476zxpAp2Re1ki8VO8yY" +
       "GsJsexQzzJSigA/ggnXTi0YdVON6g8qwuW4O+jN4NtusUSbApgHeDhfjZDFd" +
       "GYyotMzptJeMhgzVtNywK1smS/ccASlaC2fMYHaNbfRYbEqSbFsnNuwMNlF7" +
       "BsdWmZwM0loJtqZaK+nVsXCozHsQwtsYMSiPDMKi+Wp5swgwBluMWb2/gJmY" +
       "n8GtmB+3WlV8TYBo0AcexS/rMMq0Fm2XMXQa6nLBbOUuY4WusTwqrlPc7Ug8" +
       "V61HOFqZ+5UeNGIZvs/RdJ+rwON2BZ5OCVfiWptabHD1USriJiCoWlxZXBC4" +
       "WmesL5iWKndJdljTzEbV4sd1lGisUbtR5w1cVGxFn7uEMuiuasWSP6xqUdho" +
       "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" +
       "fjDr9hAHrwqhXJQFAsLXwVhriiA8HU+m");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("q5LsxW2FjzboyG/RPNKozNd4xynFKb6MwLSDnasdpZmkZUqCuzBeS4u10UAs" +
       "t+oYiIOXerXUUSeyOy83ioqvYO3m1CyRaZeU2gN33mhW4bpWC4ZwGcy4pCY9" +
       "C2e6ry/bKaapI9moeyiVahGq+XWOw9AwYPpV3wwZaVVEvYVZqo1SzoApzOWl" +
       "BlJB6dSLmqN5o5YgTi/lzaYKVUpJSs+WPmUwzbpuEtPuKKRCtFmBGmqR6TdQ" +
       "QdEN16b1iWvOsQrulZJ+FUvhPjsyak0wjQusFi66VWoV13Q1jjuSp1WgpDOP" +
       "fY2s65E3bxehtKs0UnjQlgKdBvQ1KxYaNao1rqnM8HIH5R3cpvm6NkbZGSZ5" +
       "vRFJNGimPhAIbNOfVujJwoI68azL1+gBwyGbBreoGOxC34DQaYZjTjhhyFIH" +
       "C3Vz0KAbPFkewIJSq/EDfO57sWKya4hqOZ7g4XPVw4klzUA9pmb3kVlZLIdr" +
       "DcJ8Mmy0Ohi+mTEgQooaxXTawepcY8pO5VnFbswYpJkyG78YW964HVS0aTiQ" +
       "Fs0lzcmhxi0WTDQIKpbPIFMJtkp1rz1TtAlGCy46piTCbUjrtd6qLggtYDeO" +
       "hM+brYq0mndQIZj15pC9bmx69aTGViAm4fwGwoQsmEszqTSmA1uB5FTXHNdj" +
       "YF0lqklEeaVAbDbrjgaZg0pUSqMm2tFAbMKHI5jAPTooequ+zZcjjhst0W7N" +
       "9xbFbkiH3cawltoltNoqN7mKn8x1rAHb0EBdkmgwKMrNMTbSOWu6ZnV248am" +
       "og6qYm02rotE2sGpca0B980K3kLpRUonEwqnhU4wNdo9qJkOucAneZ7iir2F" +
       "iaV8mfBQjjNUgk963iK07Jjn6I3aRpY0bLdGHph/zSb9uQ+JHQN2cX0ML2WS" +
       "oJ1Ws6LqJBM0Z6LRk+o2QzR5coZDWEKNArgpUDTc2Ohadc4zCjTjpRa2Ng1l" +
       "0Mc9sx6y0nQSxEvNchVE6ZVbK3ozcZH1SFYirgtxCOOuasRSxofkkIo66mLO" +
       "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" +
       "nQ09SR0MxwHWwsqMsiINYT5fBxFpMMpIsxVz4Cit2rLFwJVhVBIXIUwOi6gJ" +
       "j5RJMlgu7QQuQTjwhxs4YktK0YH6WjWeNUxJblYks10u44JEIXZJ0QVKKiVT" +
       "u78EwezUxAdVeFpd8JWu3ByRI9zu9zqtatmeOY4l84kKrxQhHZPwgmOrKtOu" +
       "QOZQ9kS7m8YoTI6Ks5Ja4pf9RmjSNIIg7353tp3z0ctt57w236U6/kLEK9if" +
       "2u0XZtnbjrfy8t+9hXNfFTi1lXfm+S/fK7x534cf8vf8fvhbX3pZmv1I+XC3" +
       "DYkHhQcC23mnIUeycaqph279bPr2tYmT10h/8Vv/4EnqPeoHLvES/dPncJ5v" +
       "8kenn/zs4O3i3zgs3HX8UulNX+Q4W+mFc08ve3IQehZ15oXSNx8zm7/I/i6Q" +
       "Xtwx++L5TdIT2V28Q/o1W9nn107ehj73RvWzex5RzeWy+yhK1s7Bp861c+qt" +
       "6oN/kGWfAEqWP/x+uuqFW4WRrUknm7R/96zOPXysc8cYHz31VHQke54mybdQ" +
       "05vffc5OHHz87PbzEyB9147Z77oss70LmT3NyM/f4tovZNnPZi/3GqGffaHj" +
       "4NMnbPyT2+2Z3qJjucpkDxm+vOvYy6+Oytje6jrv8KIqXxdE2dg+CJp9heT6" +
       "CAgqF3/e0X95CxL+TZb9MiAhV5lzJPzKXpXIrv6jr0T4r8tO/jXQUmtbe/v3" +
       "r1b4n7/Ftd/Jss8Fhbf7gWdbq14ElBn4hn72hY1AtqRzHxvKmsBOiPmtr1Q7" +
       "ngOd2L0IfHDTi8BfkXZkN/tXeRf/4Bbd/6Ms+69B4cFc7IiyfTnrtOz/26sn" +
       "+5yBt4CWPr5j4OOvin08s98+tgNCzsSf34KlL2fZ/9hjHH/y6hGUe8bHC4XD" +
       "+7e1t3/vkKDCnXDz1fu52b4C751QdHjvfooOH8yyg6DwkOaffcX0mKjD2z5e" +
       "fjtVeRow8NiOicdeFVV5aj8dHVuS856+7hYsPJFlVy5WlMOrr7IlPQtoeXJH" +
       "z5N/9fScixru0qw8EDl89hZ8ZIHv4VMgaPT5zcwRAYXnOHn6VebkGcDFjR0n" +
       "N14VlXn6NhaU81C5BUdZ4H94fY/OlF49fq4emdQXdvx84bL8XDzyHm5O3uU6" +
       "pzP3Sna4fbj2sJP3vX0LXgZZ9u6gcCX7KlsYyLin2Z4WZF9pOLx2wtB7LuNV" +
       "YhAT3/TVsOwTSE/c9JXC7Zf1xB9/+cr9j79M/7v8w1nHX797YFK4XwkN4/SX" +
       "aE4d3+t4sqLl7Dyw/S5N/lbOIRYUntz/PbOMn/wgg3043VYhgsJjF1QJwP13" +
       "h6dLU2AkPykdFA7FM5cXQeG+3WVgwCA/fZEDp8DF7PDrnCPtvvDza7mab82Z" +
       "DABR3Ry17cVbo3jilL5tp7GP3k5Gpyakz+59CXcabj+ocEP81Msj7Bu+VP+R" +
       "7VfBgMGladbK/ZPCfdsPlOWNZtPGt+xt7aite9HnvvzITzzwtqMp7iNbwCe6" +
       "fwrb0xd/gqtnOkH+0az0px7/h+/6+Mufz5/1/H9v0lQ7/FMAAA==");
}
