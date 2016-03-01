package edu.umd.cs.findbugs.ba.jsr305;
public class TypeQualifierValue<A extends java.lang.annotation.Annotation> {
    public static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "tqv.debug");
    public static final boolean DEBUG_CLASSLOADING = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "tqv.debug.classloading");
    private static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      EXCLUSIVE_ANNOTATION =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      instance(
        ).
      getClassDescriptor(
        javax.annotation.meta.Exclusive.class);
    private static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      EXHAUSTIVE_ANNOTATION =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      instance(
        ).
      getClassDescriptor(
        javax.annotation.meta.Exhaustive.class);
    public final edu.umd.cs.findbugs.classfile.ClassDescriptor typeQualifier;
    public final java.lang.Class<A> typeQualifierClass;
    public final A proxy;
    @javax.annotation.CheckForNull
    public final java.lang.Object value;
    private final boolean isStrict;
    private final boolean isExclusive;
    private final boolean isExhaustive;
    @javax.annotation.CheckForNull
    private final javax.annotation.meta.TypeQualifierValidator<A>
      validator;
    private TypeQualifierValue(edu.umd.cs.findbugs.classfile.ClassDescriptor typeQualifier,
                               @javax.annotation.CheckForNull
                               java.lang.Object value) { super(
                                                           );
                                                         this.
                                                           typeQualifier =
                                                           typeQualifier;
                                                         this.
                                                           value =
                                                           value;
                                                         boolean isStrict1 =
                                                           false;
                                                         boolean isExclusive1 =
                                                           false;
                                                         boolean isExhaustive1 =
                                                           false;
                                                         javax.annotation.meta.TypeQualifierValidator<A> validator1 =
                                                           null;
                                                         java.lang.Class<A> qualifierClass =
                                                           null;
                                                         edu.umd.cs.findbugs.ba.XClass xclass =
                                                           null;
                                                         A proxy1 =
                                                           null;
                                                         try {
                                                             xclass =
                                                               edu.umd.cs.findbugs.classfile.Global.
                                                                 getAnalysisCache(
                                                                   ).
                                                                 getClassAnalysis(
                                                                   edu.umd.cs.findbugs.ba.XClass.class,
                                                                   typeQualifier);
                                                             edu.umd.cs.findbugs.ba.XMethod whenMethod =
                                                               xclass.
                                                               findMethod(
                                                                 "when",
                                                                 "()Ljavax/annotation/meta/When;",
                                                                 false);
                                                             if (whenMethod ==
                                                                   null) {
                                                                 isStrict1 =
                                                                   true;
                                                             }
                                                             for (edu.umd.cs.findbugs.ba.XMethod xmethod
                                                                   :
                                                                   xclass.
                                                                    getXMethods(
                                                                      )) {
                                                                 if ("value".
                                                                       equals(
                                                                         xmethod.
                                                                           getName(
                                                                             )) &&
                                                                       xmethod.
                                                                       getSignature(
                                                                         ).
                                                                       startsWith(
                                                                         "()")) {
                                                                     isExhaustive1 =
                                                                       xmethod.
                                                                         getAnnotation(
                                                                           EXHAUSTIVE_ANNOTATION) !=
                                                                         null;
                                                                     if (isExhaustive1) {
                                                                         isExclusive1 =
                                                                           true;
                                                                     }
                                                                     else {
                                                                         isExclusive1 =
                                                                           xmethod.
                                                                             getAnnotation(
                                                                               EXCLUSIVE_ANNOTATION) !=
                                                                             null;
                                                                     }
                                                                     break;
                                                                 }
                                                             }
                                                         }
                                                         catch (edu.umd.cs.findbugs.ba.MissingClassException e) {
                                                             edu.umd.cs.findbugs.ba.AnalysisContext.
                                                               currentAnalysisContext(
                                                                 ).
                                                               getLookupFailureCallback(
                                                                 ).
                                                               reportMissingClass(
                                                                 e.
                                                                   getClassNotFoundException(
                                                                     ));
                                                         }
                                                         catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                             edu.umd.cs.findbugs.ba.AnalysisContext.
                                                               logError(
                                                                 "Error looking up annotation class " +
                                                                 typeQualifier.
                                                                   toDottedClassName(
                                                                     ),
                                                                 e);
                                                         }
                                                         this.
                                                           isStrict =
                                                           isStrict1;
                                                         this.
                                                           isExclusive =
                                                           isExclusive1;
                                                         this.
                                                           isExhaustive =
                                                           isExhaustive1;
                                                         if (xclass !=
                                                               null) {
                                                             edu.umd.cs.findbugs.classfile.ClassDescriptor checkerName =
                                                               edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                               createClassDescriptor(
                                                                 typeQualifier.
                                                                   getClassName(
                                                                     ) +
                                                                 "$Checker");
                                                             if (!edu.umd.cs.findbugs.SystemProperties.
                                                                    RUNNING_IN_ECLIPSE) {
                                                                 try {
                                                                     edu.umd.cs.findbugs.classfile.Global.
                                                                       getAnalysisCache(
                                                                         ).
                                                                       getClassAnalysis(
                                                                         edu.umd.cs.findbugs.classfile.analysis.ClassData.class,
                                                                         checkerName);
                                                                     java.lang.SecurityManager m =
                                                                       java.lang.System.
                                                                       getSecurityManager(
                                                                         );
                                                                     if (m ==
                                                                           null) {
                                                                         if (DEBUG_CLASSLOADING) {
                                                                             java.lang.System.
                                                                               out.
                                                                               println(
                                                                                 "Setting ValidationSecurityManager");
                                                                         }
                                                                         java.lang.System.
                                                                           setSecurityManager(
                                                                             edu.umd.cs.findbugs.ba.jsr305.ValidationSecurityManager.
                                                                               INSTANCE);
                                                                     }
                                                                     java.lang.Class<?> c =
                                                                       edu.umd.cs.findbugs.ba.jsr305.ValidatorClassLoader.
                                                                         INSTANCE.
                                                                       loadClass(
                                                                         checkerName.
                                                                           getDottedClassName(
                                                                             ));
                                                                     if (javax.annotation.meta.TypeQualifierValidator.class.
                                                                           isAssignableFrom(
                                                                             c)) {
                                                                         java.lang.Class<? extends javax.annotation.meta.TypeQualifierValidator<A>> validatorClass =
                                                                           (java.lang.Class<? extends javax.annotation.meta.TypeQualifierValidator<A>>)
                                                                             c.
                                                                             asSubclass(
                                                                               javax.annotation.meta.TypeQualifierValidator.class);
                                                                         validator1 =
                                                                           getValidator(
                                                                             validatorClass);
                                                                         qualifierClass =
                                                                           getQualifierClass(
                                                                             typeQualifier);
                                                                         java.lang.reflect.InvocationHandler handler =
                                                                           new java.lang.reflect.InvocationHandler(
                                                                           ) {
                                                                             @java.lang.Override
                                                                             public java.lang.Object invoke(java.lang.Object arg0,
                                                                                                            java.lang.reflect.Method arg1,
                                                                                                            java.lang.Object[] arg2)
                                                                                   throws java.lang.Throwable {
                                                                                 if ("value".
                                                                                       equals(
                                                                                         arg1.
                                                                                           getName(
                                                                                             ))) {
                                                                                     return TypeQualifierValue.this.
                                                                                              value;
                                                                                 }
                                                                                 throw new java.lang.UnsupportedOperationException(
                                                                                   "Can\'t handle " +
                                                                                   arg1);
                                                                             }
                                                                         };
                                                                         proxy1 =
                                                                           qualifierClass.
                                                                             cast(
                                                                               java.lang.reflect.Proxy.
                                                                                 newProxyInstance(
                                                                                   edu.umd.cs.findbugs.ba.jsr305.ValidatorClassLoader.
                                                                                     INSTANCE,
                                                                                   new java.lang.Class[] { qualifierClass },
                                                                                   handler));
                                                                     }
                                                                 }
                                                                 catch (java.lang.ClassNotFoundException e) {
                                                                     assert true;
                                                                 }
                                                                 catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                                     assert true;
                                                                 }
                                                                 catch (java.lang.Exception e) {
                                                                     edu.umd.cs.findbugs.ba.AnalysisContext.
                                                                       logError(
                                                                         "Unable to construct type qualifier checker " +
                                                                         checkerName,
                                                                         e);
                                                                 }
                                                                 catch (java.lang.Throwable e) {
                                                                     edu.umd.cs.findbugs.ba.AnalysisContext.
                                                                       logError(
                                                                         "Unable to construct type qualifier checker " +
                                                                         checkerName +
                                                                         " due to " +
                                                                         e.
                                                                           getClass(
                                                                             ).
                                                                           getSimpleName(
                                                                             ) +
                                                                         ":" +
                                                                         e.
                                                                           getMessage(
                                                                             ));
                                                                 }
                                                             }
                                                             else
                                                                 if (DEBUG_CLASSLOADING) {
                                                                     java.lang.SecurityManager m =
                                                                       java.lang.System.
                                                                       getSecurityManager(
                                                                         );
                                                                     if (m ==
                                                                           null) {
                                                                         if (DEBUG_CLASSLOADING) {
                                                                             java.lang.System.
                                                                               out.
                                                                               println(
                                                                                 "Setting ValidationSecurityManager");
                                                                         }
                                                                         java.lang.System.
                                                                           setSecurityManager(
                                                                             edu.umd.cs.findbugs.ba.jsr305.ValidationSecurityManager.
                                                                               INSTANCE);
                                                                     }
                                                                 }
                                                         }
                                                         this.
                                                           validator =
                                                           validator1;
                                                         this.
                                                           typeQualifierClass =
                                                           qualifierClass;
                                                         this.
                                                           proxy =
                                                           proxy1;
    }
    private static <A extends java.lang.annotation.Annotation> javax.annotation.meta.TypeQualifierValidator<A> getValidator(java.lang.Class<? extends javax.annotation.meta.TypeQualifierValidator<A>> checkerClass)
          throws java.lang.InstantiationException,
        java.lang.IllegalAccessException {
        return checkerClass.
          newInstance(
            );
    }
    @java.lang.SuppressWarnings("unchecked") 
    private static <A> java.lang.Class<A> getQualifierClass(edu.umd.cs.findbugs.classfile.ClassDescriptor typeQualifier)
          throws java.lang.ClassNotFoundException {
        java.lang.String className =
          typeQualifier.
          getDottedClassName(
            );
        if (DEBUG_CLASSLOADING) {
            java.lang.System.
              out.
              println(
                "Getting qualifier class for " +
                className);
        }
        if (className.
              startsWith(
                "javax.annotation")) {
            return (java.lang.Class<A>)
                     java.lang.Class.
                     forName(
                       className);
        }
        try {
            edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                ).
              getClassAnalysis(
                edu.umd.cs.findbugs.classfile.analysis.ClassData.class,
                typeQualifier);
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            throw new java.lang.ClassNotFoundException(
              "No class data found for " +
              className);
        }
        edu.umd.cs.findbugs.ba.jsr305.ValidatorClassLoader validatorLoader =
          edu.umd.cs.findbugs.ba.jsr305.ValidatorClassLoader.
            INSTANCE;
        return (java.lang.Class<A>)
                 validatorLoader.
                 loadClass(
                   typeQualifier.
                     getDottedClassName(
                       ));
    }
    static byte[] loadClassData(java.lang.String name)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        edu.umd.cs.findbugs.classfile.ClassDescriptor d =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptorFromDottedClassName(
            name);
        edu.umd.cs.findbugs.classfile.analysis.ClassData data =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getClassAnalysis(
            edu.umd.cs.findbugs.classfile.analysis.ClassData.class,
            d);
        return data.
          getData(
            );
    }
    static class Data {
        edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.lang.Object,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>
          typeQualifierMap =
          new edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.lang.Object,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>(
          );
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>
          allKnownTypeQualifiers =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>(
          );
        public Data() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "eff499vL5jBqKgAA");
    }
    private static java.lang.ThreadLocal<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.Data>
      instance =
      new java.lang.ThreadLocal<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.Data>(
      ) {
        @java.lang.Override
        protected edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.Data initialValue() {
            return new edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.Data(
              );
        }
    };
    public static void clearInstance() { instance.
                                           remove(
                                             );
    }
    public boolean canValidate(@javax.annotation.CheckForNull
                               java.lang.Object constantValue) {
        if (validator ==
              null) {
            return false;
        }
        return true;
    }
    public javax.annotation.meta.When validate(@javax.annotation.CheckForNull
                                               java.lang.Object constantValue) {
        if (validator ==
              null) {
            throw new java.lang.IllegalStateException(
              "No validator");
        }
        edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            );
        edu.umd.cs.findbugs.log.Profiler profiler =
          analysisCache.
          getProfiler(
            );
        profiler.
          start(
            validator.
              getClass(
                ));
        try {
            return edu.umd.cs.findbugs.ba.jsr305.ValidationSecurityManager.
              sandboxedValidation(
                proxy,
                validator,
                constantValue);
        }
        catch (java.lang.Exception e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error executing custom validator for " +
                typeQualifier +
                " " +
                constantValue,
                e);
            return javax.annotation.meta.When.
                     UNKNOWN;
        }
        finally {
            profiler.
              end(
                validator.
                  getClass(
                    ));
        }
    }
    @java.lang.SuppressWarnings("rawtypes") 
    @javax.annotation.Nonnull
    public static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> getValue(edu.umd.cs.findbugs.classfile.ClassDescriptor desc,
                                                                               @javax.annotation.CheckForNull
                                                                               java.lang.Object value) {
        edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.lang.Object,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> map =
          instance.
            get(
              ).
            typeQualifierMap;
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> result =
          map.
          get(
            desc,
            value);
        if (result !=
              null) {
            return result;
        }
        result =
          new edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue(
            desc,
            value);
        map.
          put(
            desc,
            value,
            result);
        instance.
          get(
            ).
          allKnownTypeQualifiers.
          add(
            result);
        return result;
    }
    @java.lang.SuppressWarnings("unchecked") 
    @javax.annotation.Nonnull
    public static <A extends java.lang.annotation.Annotation> edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<A> getValue(java.lang.Class<A> clazz,
                                                                                                                           @javax.annotation.CheckForNull
                                                                                                                           java.lang.Object value) {
        return (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<A>)
                 getValue(
                   edu.umd.cs.findbugs.classfile.DescriptorFactory.
                     createClassDescriptor(
                       clazz),
                   value);
    }
    public static java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> getAllKnownTypeQualifiers() {
        return java.util.Collections.
          unmodifiableSet(
            instance.
              get(
                ).
              allKnownTypeQualifiers);
    }
    public static java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> getComplementaryExclusiveTypeQualifierValue(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv) {
        assert tqv.
          isExclusiveQualifier(
            );
        java.util.LinkedList<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> result =
          new java.util.LinkedList<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>(
          );
        for (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> t
              :
              instance.
                get(
                  ).
                allKnownTypeQualifiers) {
            if (t.
                  typeQualifier.
                  equals(
                    tqv.
                      typeQualifier) &&
                  !edu.umd.cs.findbugs.util.Util.
                  nullSafeEquals(
                    t.
                      value,
                    tqv.
                      value)) {
                result.
                  add(
                    t);
            }
        }
        return result;
    }
    public static boolean hasMultipleVariants(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv) {
        int count =
          0;
        for (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> t
              :
              instance.
                get(
                  ).
                allKnownTypeQualifiers) {
            if (t.
                  typeQualifier.
                  equals(
                    tqv.
                      typeQualifier)) {
                count++;
            }
        }
        return count >
          1;
    }
    public edu.umd.cs.findbugs.classfile.ClassDescriptor getTypeQualifierClassDescriptor() {
        return typeQualifier;
    }
    public boolean isStrictQualifier() { return isStrict;
    }
    public boolean isExclusiveQualifier() {
        return isExclusive;
    }
    public boolean isExhaustiveQualifier() {
        return isExhaustive;
    }
    @java.lang.Override
    public int hashCode() { int result = typeQualifier.
                              hashCode(
                                );
                            if (value != null) {
                                result +=
                                  37 *
                                    value.
                                    hashCode(
                                      );
                            }
                            return result;
    }
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (!(o instanceof edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue)) {
            return false;
        }
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> other =
          (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>)
            o;
        return typeQualifier.
          equals(
            other.
              typeQualifier) &&
          edu.umd.cs.findbugs.util.Util.
          nullSafeEquals(
            value,
            other.
              value);
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.StringBuilder buf =
                                           new java.lang.StringBuilder(
                                           );
                                         buf.
                                           append(
                                             typeQualifier.
                                               toString(
                                                 ));
                                         if (value !=
                                               null) {
                                             buf.
                                               append(
                                                 ':');
                                             buf.
                                               append(
                                                 value.
                                                   toString(
                                                     ));
                                         }
                                         return buf.
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "t9f/D4kfy4yWSgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BNg6dQfRxlQq3RDzfIenPFdL4rC38aXm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
