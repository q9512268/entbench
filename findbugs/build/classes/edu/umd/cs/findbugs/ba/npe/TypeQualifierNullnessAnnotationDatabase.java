package edu.umd.cs.findbugs.ba.npe;
public class TypeQualifierNullnessAnnotationDatabase implements edu.umd.cs.findbugs.ba.INullnessAnnotationDatabase {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.npe.tq.debug");
    public final edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<javax.annotation.Nonnull>
      nonnullTypeQualifierValue;
    public TypeQualifierNullnessAnnotationDatabase() { super();
                                                       this.nonnullTypeQualifierValue =
                                                         edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                                                           getValue(
                                                             javax.annotation.Nonnull.class,
                                                             null);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.NullnessAnnotation getResolvedAnnotation(java.lang.Object o,
                                                                           boolean getMinimal) {
        edu.umd.cs.findbugs.log.Profiler profiler =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getProfiler(
            );
        profiler.
          start(
            this.
              getClass(
                ));
        try {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "getResolvedAnnotation: o=" +
                    o +
                    "...");
            }
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
              null;
            if (o instanceof edu.umd.cs.findbugs.ba.XMethodParameter) {
                edu.umd.cs.findbugs.ba.XMethodParameter param =
                  (edu.umd.cs.findbugs.ba.XMethodParameter)
                    o;
                tqa =
                  edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                    getEffectiveTypeQualifierAnnotation(
                      param.
                        getMethod(
                          ),
                      param.
                        getParameterNumber(
                          ),
                      nonnullTypeQualifierValue);
            }
            else
                if (o instanceof edu.umd.cs.findbugs.ba.XMethod ||
                      o instanceof edu.umd.cs.findbugs.ba.XField) {
                    tqa =
                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                        getEffectiveTypeQualifierAnnotation(
                          (edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject)
                            o,
                          nonnullTypeQualifierValue);
                }
            edu.umd.cs.findbugs.ba.NullnessAnnotation result =
              toNullnessAnnotation(
                tqa);
            if (DEBUG) {
                if (result ==
                      null) {
                    java.lang.System.
                      out.
                      println(
                        "   ===> not found");
                }
                else {
                    java.lang.System.
                      out.
                      println(
                        "   ===> " +
                        tqa +
                        "/" +
                        result.
                          toString(
                            ));
                }
            }
            return result;
        }
        finally {
            profiler.
              end(
                this.
                  getClass(
                    ));
        }
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.NullnessAnnotation getInheritedAnnotation(edu.umd.cs.findbugs.ba.XMethod m,
                                                                            int parameter) {
        edu.umd.cs.findbugs.log.Profiler profiler =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getProfiler(
            );
        profiler.
          start(
            this.
              getClass(
                ));
        try {
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
              getInheritedTypeQualifierAnnotation(
                m,
                parameter,
                nonnullTypeQualifierValue);
            edu.umd.cs.findbugs.ba.NullnessAnnotation result =
              toNullnessAnnotation(
                tqa);
            return result;
        }
        finally {
            profiler.
              end(
                this.
                  getClass(
                    ));
        }
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.NullnessAnnotation getInheritedAnnotation(edu.umd.cs.findbugs.ba.XMethod m) {
        edu.umd.cs.findbugs.log.Profiler profiler =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getProfiler(
            );
        profiler.
          start(
            this.
              getClass(
                ));
        try {
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
              getInheritedTypeQualifierAnnotation(
                m,
                nonnullTypeQualifierValue);
            edu.umd.cs.findbugs.ba.NullnessAnnotation result =
              toNullnessAnnotation(
                tqa);
            return result;
        }
        finally {
            profiler.
              end(
                this.
                  getClass(
                    ));
        }
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.NullnessAnnotation getDirectAnnotation(java.lang.Object o) {
        edu.umd.cs.findbugs.log.Profiler profiler =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getProfiler(
            );
        profiler.
          start(
            this.
              getClass(
                ));
        try {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "getDirectAnnotation: o=" +
                    o +
                    "...");
            }
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
              null;
            if (o instanceof edu.umd.cs.findbugs.ba.XMethodParameter) {
                edu.umd.cs.findbugs.ba.XMethodParameter param =
                  (edu.umd.cs.findbugs.ba.XMethodParameter)
                    o;
                tqa =
                  edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                    getDirectTypeQualifierAnnotation(
                      param.
                        getMethod(
                          ),
                      param.
                        getParameterNumber(
                          ),
                      nonnullTypeQualifierValue);
            }
            else
                if (o instanceof edu.umd.cs.findbugs.ba.XMethod ||
                      o instanceof edu.umd.cs.findbugs.ba.XField) {
                    tqa =
                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                        getEffectiveTypeQualifierAnnotation(
                          (edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject)
                            o,
                          nonnullTypeQualifierValue);
                }
            edu.umd.cs.findbugs.ba.NullnessAnnotation result =
              toNullnessAnnotation(
                tqa);
            if (DEBUG) {
                if (result ==
                      null) {
                    java.lang.System.
                      out.
                      println(
                        "   ===> not found");
                }
                else {
                    java.lang.System.
                      out.
                      println(
                        "   ===> " +
                        tqa +
                        "/" +
                        result.
                          toString(
                            ));
                }
            }
            return result;
        }
        finally {
            profiler.
              end(
                this.
                  getClass(
                    ));
        }
    }
    public static boolean assertsFirstParameterIsNonnull(edu.umd.cs.findbugs.ba.XMethod m) {
        return ("checkNonNull".
                  equalsIgnoreCase(
                    m.
                      getName(
                        )) ||
                  "checkNotNull".
                  equalsIgnoreCase(
                    m.
                      getName(
                        )) ||
                  "requireNonNull".
                  equals(
                    m.
                      getName(
                        )) ||
                  "isNotNull".
                  equalsIgnoreCase(
                    m.
                      getName(
                        )) ||
                  "assertNotNull".
                  equalsIgnoreCase(
                    m.
                      getName(
                        ))) &&
          m.
          getSignature(
            ).
          startsWith(
            "(Ljava/lang/Object;");
    }
    @java.lang.Override
    public boolean parameterMustBeNonNull(edu.umd.cs.findbugs.ba.XMethod m,
                                          int param) {
        if (DEBUG) {
            java.lang.System.
              out.
              print(
                "Checking " +
                m +
                " param " +
                param +
                " for @Nonnull...");
        }
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
          getEffectiveTypeQualifierAnnotation(
            m,
            param,
            nonnullTypeQualifierValue);
        if (tqa ==
              null &&
              param ==
              0) {
            java.lang.String name =
              m.
              getName(
                );
            java.lang.String signature =
              m.
              getSignature(
                );
            if ("main".
                  equals(
                    name) &&
                  "([Ljava/lang/String;)V".
                  equals(
                    signature) &&
                  m.
                  isStatic(
                    ) &&
                  m.
                  isPublic(
                    )) {
                return true;
            }
            else
                if (assertsFirstParameterIsNonnull(
                      m)) {
                    return true;
                }
                else
                    if ("compareTo".
                          equals(
                            name) &&
                          ")Z".
                          equals(
                            signature.
                              substring(
                                signature.
                                  indexOf(
                                    ';') +
                                  1)) &&
                          !m.
                          isStatic(
                            )) {
                        return true;
                    }
        }
        boolean answer =
          tqa !=
          null &&
          tqa.
            when ==
          javax.annotation.meta.When.
            ALWAYS;
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                answer
                  ? "yes"
                  : "no");
        }
        return answer;
    }
    private edu.umd.cs.findbugs.classfile.ClassDescriptor getNullnessAnnotationClassDescriptor(edu.umd.cs.findbugs.ba.NullnessAnnotation n) {
        if (n ==
              edu.umd.cs.findbugs.ba.NullnessAnnotation.
                CHECK_FOR_NULL) {
            return edu.umd.cs.findbugs.ba.jsr305.JSR305NullnessAnnotations.
                     CHECK_FOR_NULL;
        }
        else
            if (n ==
                  edu.umd.cs.findbugs.ba.NullnessAnnotation.
                    NONNULL) {
                return edu.umd.cs.findbugs.ba.jsr305.JSR305NullnessAnnotations.
                         NONNULL;
            }
            else
                if (n ==
                      edu.umd.cs.findbugs.ba.NullnessAnnotation.
                        NULLABLE) {
                    return edu.umd.cs.findbugs.ba.jsr305.JSR305NullnessAnnotations.
                             NULLABLE;
                }
                else
                    if (n ==
                          edu.umd.cs.findbugs.ba.NullnessAnnotation.
                            UNKNOWN_NULLNESS) {
                        return edu.umd.cs.findbugs.ba.jsr305.JSR305NullnessAnnotations.
                                 NULLABLE;
                    }
                    else {
                        throw new java.lang.IllegalArgumentException(
                          "Unknown NullnessAnnotation: " +
                          n);
                    }
    }
    private static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      PARAMETERS_ARE_NONNULL_BY_DEFAULT =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        javax.annotation.ParametersAreNonnullByDefault.class);
    private static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      RETURN_VALUES_ARE_NONNULL_BY_DEFAULT =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        edu.umd.cs.findbugs.annotations.ReturnValuesAreNonnullByDefault.class);
    @java.lang.Override
    public void addDefaultAnnotation(edu.umd.cs.findbugs.ba.AnnotationDatabase.Target target,
                                     java.lang.String c,
                                     edu.umd.cs.findbugs.ba.NullnessAnnotation n) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "addDefaultAnnotation: target=" +
                target +
                ", c=" +
                c +
                ", n=" +
                n);
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor classDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getClassDescriptorForDottedClassName(
            c);
        edu.umd.cs.findbugs.classfile.analysis.ClassInfo xclass;
        try {
            xclass =
              (edu.umd.cs.findbugs.classfile.analysis.ClassInfo)
                edu.umd.cs.findbugs.classfile.Global.
                getAnalysisCache(
                  ).
                getClassAnalysis(
                  edu.umd.cs.findbugs.ba.XClass.class,
                  classDesc);
        }
        catch (edu.umd.cs.findbugs.classfile.MissingClassException e) {
            return;
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            return;
        }
        if (n ==
              edu.umd.cs.findbugs.ba.NullnessAnnotation.
                NONNULL &&
              target ==
              edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                PARAMETER) {
            xclass.
              addAnnotation(
                new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
                  PARAMETERS_ARE_NONNULL_BY_DEFAULT));
            return;
        }
        else
            if (n ==
                  edu.umd.cs.findbugs.ba.NullnessAnnotation.
                    NONNULL &&
                  target ==
                  edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                    METHOD) {
                xclass.
                  addAnnotation(
                    new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
                      RETURN_VALUES_ARE_NONNULL_BY_DEFAULT));
                return;
            }
        edu.umd.cs.findbugs.classfile.ClassDescriptor defaultAnnotationType;
        if (target ==
              edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                ANY) {
            defaultAnnotationType =
              edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                DEFAULT_ANNOTATION;
        }
        else
            if (target ==
                  edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                    FIELD) {
                defaultAnnotationType =
                  edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                    DEFAULT_ANNOTATION_FOR_FIELDS;
            }
            else
                if (target ==
                      edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                        METHOD) {
                    defaultAnnotationType =
                      edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                        DEFAULT_ANNOTATION_FOR_METHODS;
                }
                else
                    if (target ==
                          edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                            PARAMETER) {
                        defaultAnnotationType =
                          edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                            DEFAULT_ANNOTATION_FOR_PARAMETERS;
                    }
                    else {
                        throw new java.lang.IllegalArgumentException(
                          "Unknown target for default annotation: " +
                          target);
                    }
        edu.umd.cs.findbugs.classfile.ClassDescriptor nullnessAnnotationType =
          getNullnessAnnotationClassDescriptor(
            n);
        edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotationValue =
          new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
          defaultAnnotationType);
        org.objectweb.asm.AnnotationVisitor v =
          annotationValue.
          getAnnotationVisitor(
            );
        v.
          visit(
            "value",
            org.objectweb.asm.Type.
              getObjectType(
                nullnessAnnotationType.
                  getClassName(
                    )));
        v.
          visitEnd(
            );
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Adding AnnotationValue " +
                annotationValue +
                " to class " +
                xclass);
        }
        xclass.
          addAnnotation(
            annotationValue);
    }
    @java.lang.Override
    public void addFieldAnnotation(java.lang.String cName,
                                   java.lang.String mName,
                                   java.lang.String mSig,
                                   boolean isStatic,
                                   edu.umd.cs.findbugs.ba.NullnessAnnotation annotation) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "addFieldAnnotation: annotate " +
                cName +
                "." +
                mName +
                " with " +
                annotation);
        }
        edu.umd.cs.findbugs.ba.XField xfield =
          edu.umd.cs.findbugs.ba.XFactory.
          createXField(
            cName,
            mName,
            mSig,
            isStatic);
        if (!(xfield instanceof edu.umd.cs.findbugs.classfile.analysis.FieldInfo)) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "  Field not found! " +
                    cName +
                    "." +
                    mName +
                    ":" +
                    mSig +
                    " " +
                    isStatic +
                    " " +
                    annotation);
            }
            return;
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor nullnessAnnotationType =
          getNullnessAnnotationClassDescriptor(
            annotation);
        edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotationValue =
          new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
          nullnessAnnotationType);
        ((edu.umd.cs.findbugs.classfile.analysis.FieldInfo)
           xfield).
          addAnnotation(
            annotationValue);
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.XMethod getXMethod(java.lang.String cName,
                                                     java.lang.String mName,
                                                     java.lang.String sig,
                                                     boolean isStatic) {
        edu.umd.cs.findbugs.classfile.ClassDescriptor classDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getClassDescriptorForDottedClassName(
            cName);
        edu.umd.cs.findbugs.classfile.analysis.ClassInfo xclass;
        try {
            xclass =
              (edu.umd.cs.findbugs.classfile.analysis.ClassInfo)
                edu.umd.cs.findbugs.classfile.Global.
                getAnalysisCache(
                  ).
                getClassAnalysis(
                  edu.umd.cs.findbugs.ba.XClass.class,
                  classDesc);
        }
        catch (edu.umd.cs.findbugs.classfile.MissingClassException e) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "  Class not found!");
            }
            return null;
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "  Class not found!");
            }
            return null;
        }
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          xclass.
          findMethod(
            mName,
            sig,
            isStatic);
        if (xmethod ==
              null) {
            xmethod =
              edu.umd.cs.findbugs.ba.XFactory.
                createXMethod(
                  cName,
                  mName,
                  sig,
                  isStatic);
        }
        return xmethod;
    }
    @java.lang.Override
    public void addMethodAnnotation(java.lang.String cName,
                                    java.lang.String mName,
                                    java.lang.String sig,
                                    boolean isStatic,
                                    edu.umd.cs.findbugs.ba.NullnessAnnotation annotation) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "addMethodAnnotation: annotate " +
                cName +
                "." +
                mName +
                " with " +
                annotation);
        }
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          getXMethod(
            cName,
            mName,
            sig,
            isStatic);
        if (xmethod ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor nullnessAnnotationType =
          getNullnessAnnotationClassDescriptor(
            annotation);
        edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotationValue =
          new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
          nullnessAnnotationType);
        xmethod.
          addAnnotation(
            annotationValue);
    }
    @java.lang.Override
    public void addMethodParameterAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                             java.lang.String cName,
                                             java.lang.String mName,
                                             java.lang.String sig,
                                             boolean isStatic,
                                             int param,
                                             edu.umd.cs.findbugs.ba.NullnessAnnotation annotation) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "addMethodParameterAnnotation: annotate " +
                cName +
                "." +
                mName +
                " param " +
                param +
                " with " +
                annotation);
        }
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          getXMethod(
            cName,
            mName,
            sig,
            isStatic);
        if (xmethod ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor nullnessAnnotationType =
          getNullnessAnnotationClassDescriptor(
            annotation);
        edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotationValue =
          new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
          nullnessAnnotationType);
        if (!xmethod.
              getClassName(
                ).
              equals(
                cName)) {
            if (edu.umd.cs.findbugs.SystemProperties.
                  ASSERTIONS_ENABLED) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Could not fully resolve method " +
                    cName +
                    "." +
                    mName +
                    sig +
                    " to apply annotation " +
                    annotation);
            }
            return;
        }
        if (edu.umd.cs.findbugs.SystemProperties.
              ASSERTIONS_ENABLED) {
            edu.umd.cs.findbugs.ba.SignatureParser parser =
              new edu.umd.cs.findbugs.ba.SignatureParser(
              sig);
            int numParams =
              parser.
              getNumParameters(
                );
            assert param <
              numParams;
        }
        xmethod.
          addParameterAnnotation(
            param,
            annotationValue);
    }
    @java.lang.Override
    public void loadAuxiliaryAnnotations() {
        edu.umd.cs.findbugs.ba.DefaultNullnessAnnotations.
          addDefaultNullnessAnnotations(
            this);
    }
    @javax.annotation.CheckForNull
    private edu.umd.cs.findbugs.ba.NullnessAnnotation toNullnessAnnotation(@javax.annotation.CheckForNull
                                                                           edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa) {
        if (tqa ==
              null ||
              tqa ==
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                OVERRIDES_BUT_NO_ANNOTATION) {
            return null;
        }
        if (tqa.
              when ==
              null) {
            new java.lang.NullPointerException(
              "TGA value with null when field").
              printStackTrace(
                );
            return null;
        }
        switch (tqa.
                  when) {
            case ALWAYS:
                return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                         NONNULL;
            case MAYBE:
                return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                         CHECK_FOR_NULL;
            case NEVER:
                return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                         CHECK_FOR_NULL;
            case UNKNOWN:
                return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                         UNKNOWN_NULLNESS;
        }
        throw new java.lang.IllegalStateException(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "m/w4LvIwf8W3R/4HtTKE1pcyAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e6z8WH3f/H77XpbdZReWZQvLLvwILIafx/Oyp5sAtsf2" +
       "zPgxD3s84yHhh59je/waP2Y8kyUBpABpEoLaJaUK2b+IoBEJqAI1SpuINmp5" +
       "5CElipLQKhC1kUpIUEGIpCp59Nhz75177+93f7srdtMr+VzP8TnH3+/nfL6P" +
       "Yx9/+luV25K4AkWht114YXrVzNOrrte8mm4jM7na55pDNU5Mg/TUJJFA3TX9" +
       "dZ+972++/xH7/suV2+eVB9UgCFM1dcIgGZtJ6K1Ng6vcd6ilPNNP0sr9nKuu" +
       "VThLHQ/mnCR9kqu85FTXtHKFOxYBBiLAQAS4FAHGD61Ap5eaQeaTRQ81SJNV" +
       "5Scql7jK7ZFeiJdWHj87SKTGqn80zLDUAIxwZ/FbBkqVnfO48tiJ7nudr1P4" +
       "oxD89L9+1/3/7pbKffPKfU4gFuLoQIgU3GReucc3fc2ME9wwTGNeeVlgmoZo" +
       "xo7qObtS7nnlgcRZBGqaxeYJSEVlFplxec8DcvfohW5xpqdhfKKe5Ziecfzr" +
       "NstTF0DXhw667jWki3qg4N0OECy2VN087nLr0gmMtPLa8z1OdLzCggag6x2+" +
       "mdrhya1uDVRQUXlgP3eeGixgMY2dYAGa3hZm4C5p5ZELBy2wjlR9qS7Ma2nl" +
       "4fPthvtLoNVdJRBFl7TyivPNypHALD1ybpZOzc+3hB/+8I8H3eByKbNh6l4h" +
       "/52g06PnOo1Ny4zNQDf3He95M/cL6kO/+aHLlQpo/Ipzjfdt/v1T33nHWx79" +
       "wpf2bf7ZDdoMNNfU02v6J7R7/+DV5BPtWwox7ozCxCkm/4zmJf2HR1eezCNg" +
       "eQ+djFhcvHp88Qvj/6q891fMv7pcubtXuV0PvcwHPHqZHvqR45kxYwZmrKam" +
       "0avcZQYGWV7vVe4A55wTmPvagWUlZtqr3OqVVbeH5W8AkQWGKCC6A5w7gRUe" +
       "n0dqapfneVSpVO4AR+Wd4HhHZf9X/k8rW9gOfRNWdTVwghAexmGhfwKbQaoB" +
       "bG3YAmTSskUCJ7EOl9QxjQzOfAPWk8NFTYWDyCznd5QBWwEkj4XM8wIzSQ42" +
       "31FTVVMT82oxTvT/8+Z5gcz9m0uXwKS9+rzL8IC1dUPPMONr+tMZQX3n1679" +
       "zuUTEzrCNK0QQJarQJarenL1WJarmnoVyHL1OcpSuXSpFOHlhUx7zoAZXwLf" +
       "AbzqPU+IP9Z/94dedwsga7S5FUxX0RS+2LmTB2/TK32qDihf+cLHNu+Tf7J6" +
       "uXL5rJcu9ABVdxfdh4VvPfGhV85b543Gve+D3/ibz/zCe8KDnZ5x+0fu4/qe" +
       "hfm/7jzicagDMGPzMPybH1M/f+0333PlcuVW4FOAH01VwHvgoh49f48zbuDJ" +
       "Y5da6HIbUNgKY1/1ikvHfvDu1I7DzaGmpMK95fnLAMYvKeyiBg7qyFDK/8XV" +
       "B6OifPmeOsWkndOidNk/Ika/9Ke//5f1Eu5j737fqXgpmumTpzxKMdh9pe94" +
       "2YEDUmyaoN2ffWz4rz76rQ++syQAaPH6G93wSlGSwJOAKQQw/9SXVl/9+tc+" +
       "8UeXD6RJQUjNNM/R8xMli/rK3TdREtzthw7yAI/kAcMsWHNlEvihAWitap5Z" +
       "sPTv7nsD8vm//vD9ex54oOaYRm959gEO9a8iKu/9nXf97aPlMJf0IiIeMDs0" +
       "27vZBw8j43Gsbgs58vf94Wv+zRfVXwIOGzjJxNmZpd+rlBhUykmDS/3fXJZX" +
       "z11DiuK1yWnyn7WvU5nLNf0jf/Ttl8rf/q3vlNKeTX1OzzWvRk/u6VUUj+Vg" +
       "+Feet/SumtigXeMLwo/e733h+2DEORhRB/E+GcTABeVnmHHU+rY7/tt/+u2H" +
       "3v0Ht1Qu05W7vVA1aLU0sspdgN1mYgPvlUdvP/L1mztBcX+pauU65fekeLj8" +
       "dQcQ8ImL/QtdZC4HE334/w487f3/4/9cB0LpWW4QsM/1n8Of/vgj5Nv+qux/" +
       "MPGi96P59W4ZZHmHvrVf8b93+XW3/5fLlTvmlfv1oxRSVr2sMJw5SJuS47wS" +
       "pJlnrp9Ngfbx/skTF/bq8+7l1G3PO5dDOADnRevi/O5z/uRVBcrvAgd+ZGr4" +
       "eX9yqVKevL3s8nhZXimKN5ZzcktauSOKnTXID4AhJ2W2mgI5nED1jgz6H8Hf" +
       "JXD8Q3EUoxcV+/D+AHmUYzx2kmREIHTd1qGICXPz2R7Gjg9c1PoovYLf88DX" +
       "lx//xq/uU6fzU3uusfmhp//FP1798NOXTyWsr78uZzzdZ5+0lti9tCjowlge" +
       "v9ldyh70//rMe/7Dp97zwb1UD5xNvyiwuvjVP/773736sT//8g3i9x1aGHqm" +
       "Guz9eVHWiuIde1SbF1rPPz+Z2+KozMBBHs0tecHcijee28vF6ZuKgio1p9PK" +
       "q4IwCEC+cCaBKHkL8HjzxbMlZlqSnkqjf8555ve+8r373rcH5uw0lyupo67n" +
       "+331T2+pvSS98vNl/Lq1yFHK9BswPylappXHLl6VlWPt5/AlJxiViec94Hjb" +
       "EUZv2zNz8YLlfm4S16tN+HrEjtPMf6pb7YnzirRSvSAz3He/en33ot+1M4S/" +
       "8QRf03v+NfHzX/1gq+TzfWsHZBGmIR0tgs9GzUMm+eSZhfENKXBN/8Znfu5L" +
       "j39TfrBc8exnuxCrDiJu8b91ZA+XSnu4fJSNvuECgY8kKoP8Nf2pj//D7/3l" +
       "e7725Vsqt4P8q3C0agxWO2A5dfWiBwWnB7gigbMO6AUc8L373mDZWpL2iJwP" +
       "nNSepJJp5a0XjV06t3MZZ7HU9sKNGRNhFhhlDDrr4O/Oouj01ZLm95zQ/LEC" +
       "m8Z5mhdXf6z0AO/KfwJkRM8BrRNlj8apPFBa8L1lDlCErNKtnb4IGP4gyeGi" +
       "eE1ShtQ1GR/3cIKjSk4Vzv4SfszL1x4GOYTrU5nNCYEfLul8upGwd0tn0oVK" +
       "fs51Ss/ddZZhUQHHt440+esLXOfmgrBYnJJF0TnjPx8f4mOcpyRqLF7Dx9Q1" +
       "YSAIE467RijXOhSNTzjpWMe33shIy0dPxYp6/0iiYyZ67EQgszqnaf48NXXB" +
       "8e0jTf/3BZq+9/lpemVMSZOxAOabm1AXKVu0feqc7O97Vtn3AfgSWDncVruK" +
       "Xq0Wvz94E+nedL10r3Q9/cpx8iGbcQJIdMX10GP07z9Qcf8U6pyQ9HMWMjlj" +
       "HFwYLJ78mb/4yO/+/Ou/Dnxkv3LbunCwwIJO3VHIimd8H/j0R1/zkqf//GfK" +
       "pRJwZ+IT2nffUYz6keen6iOFqmKYxbrJqUnKl6sb0zjRtndKHz4Fa6TwB9A2" +
       "ffl/7DaSHn78x8sq2cQnyFhu8+g64ZI1aa0XLkdgM3ZM+BQ5Y2KyO4ADqY9y" +
       "XEbU5bHdbpkpmghDA0nbzbWBi/KY3UR9T1dCJuotVlpvE7Kyw5EIXNXZbcMx" +
       "HVlU/OrYHfu0RI/JKiK7Yl/Ut220Lg+t2ryF9wYN2ar57TqS1evrzLIss40G" +
       "8UziCH65dBHZ4TWJCenpejbttZdTVzJWy9UUGbUR1grQucF2PRSVLVmdyPhW" +
       "ZNWBiIgyR2fIaNVf1YhkiY21gRLxwaS1UqquKLQkJhrr1dxxVg1hmfksMl/m" +
       "MiVPp33TjFLbXk9HvqjVKZ9d8vNxkKb4csM7WD/gR80+TFMJt2yK02hZN1zH" +
       "iGCvZaArVWdMxjI02hGQ7aQu+oQ05JdToZ9POcE0eH21sldIysj9Oq32UFpY" +
       "+bE2cqcAvNmI64T1dDUcxp6d9podnp6JQh/JMTU31SxYMVQ1EFVEq7VQ0e1O" +
       "5tBIicRmvx8kLV4gp4aLaXZY7zZW5CCtbbJGUN0iGjuXm1BvYyMs3ROFjkvu" +
       "qtSOWk6wWJl3w8auStpO6m8xjFqgCoulFMfiNr0eulMIg7MZkiKzsR92RbXm" +
       "tEUK5d0O0SAHHZx0hQ7dlcSVJAkdpNdy5ZFhYwg98eQ0XalaTE6oCeJMZRLG" +
       "N+l0vkBWmA+1pj3KHEnKjt0NjV0vqe/wOgv7MJmQK2HBbnYz2qdtAlE6m/6U" +
       "xUhlIG6JuuF1tq4eT6PVGNKpsTn2tfWiYSiM7dlxfzy0oEhf1kgy7S0kSpTT" +
       "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" +
       "6VGG7jZkM96uIBAgxtkAMwcEOlv0khHB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "n5Dtfv2Vn/vhTz7ztXJD6P8DNWEheEw/AAA=");
}
