package edu.umd.cs.findbugs.ba.jsr305;
public class TypeQualifierApplications {
    static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.getBoolean(
                                                                        "ctq.applications.debug");
    static final java.lang.String DEBUG_METHOD = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "ctq.applications.method");
    static final boolean DEBUG_DEFAULT_ANNOTATION = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.applications.default.debug");
    static final boolean CHECK_EXCLUSIVE = true;
    static final boolean CHECK_EXHAUSTIVE = true;
    static class Data {
        private final java.util.Map<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>>
          directObjectAnnotations =
          new java.util.HashMap<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>>(
          );
        private final java.util.HashMap<edu.umd.cs.findbugs.ba.XMethod,java.util.Map<java.lang.Integer,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>>>
          directParameterAnnotations =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.XMethod,java.util.Map<java.lang.Integer,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>>>(
          );
        private final java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,java.util.Map<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>
          effectiveObjectAnnotations =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,java.util.Map<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>(
          );
        private final java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.ba.XMethod,java.lang.Integer,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>
          effectiveParameterAnnotations =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.ba.XMethod,java.lang.Integer,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>(
          );
        public Data() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "q9TvmCQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "0prKibV0NWxpNxO0gw7TeCigOZdi9TpK1GFDz4Ww0kQpwld4OWRJnNH0tDOt" +
           "bNddosVjlCtn88E83yKBKi17jR6s1bGphqzn47kxylvdVq01oclqZRSxabaK" +
           "yYYoMT2/Z89rgwE+2nk1Tc5MYzoy1xt/4ItLtjZwgsga9wPa4OftYDXhKWlD" +
           "4+aYNUR9ztYlct7JJwnFkmtXVDhu2NwtxpxsbXxsiVTVeuCp9XFiDzyuKo+m" +
           "LU0N1bRvSbsx25NEdW16o4k2U6igsbXSkO3hXNDGl55LKHOW3+kTh3VX9b6w" +
           "XGW5LqDtjsSTm76/6rte2OGZmt+wbJ6lOb6ONiJ8UclotMb3OvEEZ1fCxAtH" +
           "sqRSFjW1J0is6C2NE9KOX0FryE6b23Rf2bBTiqLo0FoovV5CdNIqPMlcnG6x" +
           "Eo8sBrJZ39bMGK2znUyLEpHPapVareYhi9GStGmWkUnLGlIdciQzo34bd1Kl" +
           "hixmrD/IR7WVbqqInnL+esf3KmpNXbYZZ96ZmHocN3ZUBRso6MpTmpuq6SEd" +
           "zBAbIi02N3RNHi4kYoo5Mu0vWmh1sZzW6qtW7AuUs+B6rKXTansrsf2dsOiL" +
           "PTALh0zHGbzkByTd62P9ud236UD1J6QUjEhMHctTiumkgqlHfipR6Cwd0aiZ" +
           "zDuDjVxFzXFm59Rg0hzZgiHUKuP2YOP2GZ8adfiZ6w0mtVTEBo2kIs092KhN" +
           "YxSxl+yYUgajHZu3/HXuhCljTU14zAc5PfTnON4TUYvod1f6otvG52Mzcngv" +
           "chp5VNkKy6mr6kkWwJYaYZi77HjbzGJZa2KIA6KyrDbRTJyL/YniBqv1CMNq" +
           "E8Kqs0B/Yu6TXYpvqQQSMTg/W0VVgp9hXdIAODjYePFoSkuOQdYbG5qYqIS/" +
           "nsOoGDItrde2JbO2SdeJ4+J51SfjmrT2WaJOLCI0otYtYsaGVLKJQrg1ph1z" +
           "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" +
           "mhOw0+ATPO3X3SmOhW7exjd2MozqtVkq");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("8SqNdDraWG6Yjd4EhRtpj8GzpL4a5t1gNiadqBup05rfVbjhOhV4sHuaRagk" +
           "5UJLpZuM6NOpRfuzZVWMGzJsVqqbprR1qRFJkh/6UHHs8e23d/L0aHnIdnyh" +
           "2HbqRcNX38aJS3bxhFfKubLjs8ryLPFB6PKbeGe/7oXQey+7OVyeKX32p199" +
           "TRu+jl49PKD8ZgxdP7zQfXqcGLqnuJl5dGRY/z6vdwJ23n3HdfP9FWn11167" +
           "cf+Tr03+Q3m38fga8wMcdL8BAv7pi0Sn3q8HoQ4MsOy5v1ZUflO9AhXfA+7G" +
           "IxBz/1KK9L091bUYeuJiqhi6ulROd70eQ49f0DUG3B6+nu79QAw9eNIbDKae" +
           "aX44hu47bI6ha6A83XgDVIHG4vXm4UeZK3d+wS3N67E3O9A7ZRbPX3pHZ5Ds" +
           "/7PAbfXzr7H8j3+n9vr+2qbqKHlejHI/B923v0FaDlrcZHz20tGOxrrefeG7" +
           "j/z6A+8/MrRH9gyfOMgp3t538b3IjhvE5U3G/J89+Y8/+Pdf+3p5XPz/ALyq" +
           "OZPDMQAA");
    }
    private static java.lang.ThreadLocal<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.Data>
      instance =
      new java.lang.ThreadLocal<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.Data>(
      ) {
        @java.lang.Override
        protected edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.Data initialValue() {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "constructing TypeQualifierApplications.Data");
            }
            return new edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.Data(
              );
        }
    };
    public static void clearInstance() { instance.
                                           remove(
                                             );
    }
    private static java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.ba.XMethod,java.lang.Integer,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>> getEffectiveParameterAnnotations() {
        return instance.
                 get(
                   ).
                 effectiveParameterAnnotations;
    }
    private static java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,java.util.Map<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>> getEffectiveObjectAnnotations() {
        return instance.
                 get(
                   ).
                 effectiveObjectAnnotations;
    }
    private static java.util.HashMap<edu.umd.cs.findbugs.ba.XMethod,java.util.Map<java.lang.Integer,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>>> getDirectParameterAnnotations() {
        return instance.
                 get(
                   ).
                 directParameterAnnotations;
    }
    private static java.util.Map<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>> getDirectObjectAnnotations() {
        return instance.
                 get(
                   ).
                 directObjectAnnotations;
    }
    public static void updateAnnotations(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject object) {
        clearInstance(
          );
    }
    private static interface ComputeEffectiveTypeQualifierAnnotation {
        public edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation compute(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv);
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1456688264000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1456688264000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "7+MZ+GAGXsjARzPwsbMyvbUynZDpTRb7");
        java.lang.String jlc$ClassType$jl5$1 =
          ("xE36fuslKtIudDuhQ7+ZgX+egd8GOmSpkUX4xtZ635oP2jKHiKFz9uFlxdth" +
           "2r/KwO9k4Hcz8C8z8PsvkWnXhp6n1zkM4LbCzuCnbkLIiy+RaTm6N+349QcZ" +
           "+HQG/hC4AXMBfFd0PW7dpfm+Y6rebXPscxn4TAb+JAOfzcC/e4U4dnKdL9yk" +
           "7z9+l8z6fAb+NAP/CShX7O/uwxRvmy//JQNfynFl4MsZ+LPvlfl95SZ9X7tt" +
           "P/7nGfhqBr6eHS1+bE/W19Op8yvfNm6bcd/KwH/PwF9k4H9k4H99rxj3Vzfp" +
           "++vbZtz/y8C3M/A3MXRxy7i6k9+c/Yvb5dPe+QxAR3zay3R779wryacT/qqR" +
           "r3jx+gOODuTHdwcyleVewmUAXkrIVDeDPKrMUNx9uzzdu5CBSxm4F2hcotrx" +
           "K8POhzJw/zE7H8jAq18hP7a/G9XIwO/mKz56Q37v3ZMPeO3LPjgPdnz6vgxk" +
           "t6L2Htvt7La59PRpLj2RgadeeW+/94O34s0bb4c3b8jAMxkovIK8KZ3mTaa4" +
           "e8U0ht7wEq8bH9kR/l1eawZvba+55t8stv8aoP/GC5cvPPLC4D/kCbvj6/sX" +
           "GejCZOk4Jy/Ynni+MwjNiZ2z7eI2R5eHwHtYDD12UxrBKbF9yLa0h25n1UAI" +
           "fP1ZMbSvqSeHvhm8yl5nKDijjx5Pjn5rDF3ajQbI9FPdDRDsHHaDIBHAk50k" +
           "aAKd2WMruxecy+DaEPyBW2nEicTy0zfMsPSW23+Quap/7AWa/bFvYh/eXiwG" +
           "7wGbTYblAgPdtU2X5kiz1OOTN8R2hOvOzjPfvvfjF19/lKq+d0vwzhBP0Pa6" +
           "6ycySTeI89Tj5rcf+c03/9oLX8wvt/5/+xwGb7c0AAA=");
    }
    private static java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> getDirectAnnotation(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject m) {
        java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> result =
          getDirectObjectAnnotations(
            ).
          get(
            m);
        if (result !=
              null) {
            return result;
        }
        if (m.
              getAnnotationDescriptors(
                ).
              isEmpty(
                )) {
            return java.util.Collections.
              <edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>
            emptyList(
              );
        }
        result =
          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierResolver.
            resolveTypeQualifiers(
              m.
                getAnnotations(
                  ));
        if (result.
              size(
                ) ==
              0) {
            result =
              java.util.Collections.
                <edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>
              emptyList(
                );
        }
        getDirectObjectAnnotations(
          ).
          put(
            m,
            result);
        return result;
    }
    private static java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> getDirectAnnotation(edu.umd.cs.findbugs.ba.XMethod m,
                                                                                                                    int parameter) {
        java.util.HashMap<edu.umd.cs.findbugs.ba.XMethod,java.util.Map<java.lang.Integer,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>>> directParameterAnnotations =
          getDirectParameterAnnotations(
            );
        java.util.Map<java.lang.Integer,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>> map =
          directParameterAnnotations.
          get(
            m);
        if (map ==
              null) {
            int n =
              m.
              getNumParams(
                );
            if (m.
                  isVarArgs(
                    )) {
                n--;
            }
            map =
              new java.util.HashMap<java.lang.Integer,java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>>(
                n +
                  2);
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> a =
                  edu.umd.cs.findbugs.ba.jsr305.TypeQualifierResolver.
                  resolveTypeQualifiers(
                    m.
                      getParameterAnnotations(
                        i));
                if (!a.
                      isEmpty(
                        )) {
                    map.
                      put(
                        i,
                        a);
                }
            }
            if (map.
                  isEmpty(
                    )) {
                map =
                  java.util.Collections.
                    emptyMap(
                      );
            }
            directParameterAnnotations.
              put(
                m,
                map);
        }
        java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> result =
          map.
          get(
            parameter);
        if (result !=
              null) {
            return result;
        }
        return java.util.Collections.
          emptyList(
            );
    }
    public static void getDirectApplications(java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> result,
                                             edu.umd.cs.findbugs.ba.XMethod o,
                                             int parameter) {
        java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> values =
          getDirectAnnotation(
            o,
            parameter);
        for (edu.umd.cs.findbugs.classfile.analysis.AnnotationValue v
              :
              values) {
            constructTypeQualifierAnnotation(
              result,
              v);
        }
    }
    public static void getDirectApplications(java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> result,
                                             edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                             java.lang.annotation.ElementType e) {
        if (!o.
              getElementType(
                ).
              equals(
                e)) {
            return;
        }
        java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> values =
          getDirectAnnotation(
            o);
        for (edu.umd.cs.findbugs.classfile.analysis.AnnotationValue v
              :
              values) {
            constructTypeQualifierAnnotation(
              result,
              v);
        }
    }
    public static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation constructTypeQualifierAnnotation(edu.umd.cs.findbugs.classfile.analysis.AnnotationValue v) {
        assert v !=
          null;
        edu.umd.cs.findbugs.classfile.analysis.EnumValue whenValue =
          (edu.umd.cs.findbugs.classfile.analysis.EnumValue)
            v.
            getValue(
              "when");
        javax.annotation.meta.When when =
          whenValue ==
          null
          ? javax.annotation.meta.When.
              ALWAYS
          : javax.annotation.meta.When.
          valueOf(
            whenValue.
              value);
        edu.umd.cs.findbugs.classfile.ClassDescriptor annotationClass =
          v.
          getAnnotationClass(
            );
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv =
          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
          getValue(
            annotationClass,
            v.
              getValue(
                "value"));
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
          getValue(
            tqv,
            when);
        return tqa;
    }
    public static void constructTypeQualifierAnnotation(java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> set,
                                                        edu.umd.cs.findbugs.classfile.analysis.AnnotationValue v) {
        assert set !=
          null;
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
          constructTypeQualifierAnnotation(
            v);
        set.
          add(
            tqa);
    }
    private static void getApplicableScopedApplications(java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> result,
                                                        edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                                        java.lang.annotation.ElementType e) {
        if (!o.
              isSynthetic(
                )) {
            edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject outer =
              o.
              getContainingScope(
                );
            if (outer !=
                  null) {
                getApplicableScopedApplications(
                  result,
                  outer,
                  e);
            }
        }
        getDirectApplications(
          result,
          o,
          e);
    }
    private static java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> getApplicableScopedApplications(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                                                                                                               java.lang.annotation.ElementType e) {
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> result =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
          );
        getApplicableScopedApplications(
          result,
          o,
          e);
        return result;
    }
    private static java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> getApplicableScopedApplications(edu.umd.cs.findbugs.ba.XMethod o,
                                                                                                                               int parameter) {
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> result =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
          );
        java.lang.annotation.ElementType e =
          java.lang.annotation.ElementType.
            PARAMETER;
        getApplicableScopedApplications(
          result,
          o,
          e);
        getDirectApplications(
          result,
          o,
          parameter);
        return result;
    }
    public static java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> getApplicableApplications(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o) {
        return getApplicableScopedApplications(
                 o,
                 o.
                   getElementType(
                     ));
    }
    public static java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> getApplicableApplications(edu.umd.cs.findbugs.ba.XMethod o,
                                                                                                                        int parameter) {
        return getApplicableScopedApplications(
                 o,
                 parameter);
    }
    @javax.annotation.CheckForNull
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation findMatchingTypeQualifierAnnotation(java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> typeQualifierAnnotations,
                                                                                                             edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        for (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation typeQualifierAnnotation
              :
              typeQualifierAnnotations) {
            if (typeQualifierAnnotation.
                  typeQualifier.
                  equals(
                    typeQualifierValue)) {
                return typeQualifierAnnotation;
            }
        }
        return null;
    }
    @javax.annotation.CheckForNull
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getDefaultAnnotation(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                                                                              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                                                                              java.lang.annotation.ElementType elementType) {
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation result;
        java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> values =
          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierResolver.
          resolveTypeQualifierDefaults(
            o.
              getAnnotations(
                ),
            elementType);
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
          extractAnnotation(
            values,
            typeQualifierValue);
        if (tqa !=
              null) {
            return tqa;
        }
        if ((result =
               checkFindBugsDefaultAnnotation(
                 edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                   DEFAULT_ANNOTATION,
                 o,
                 typeQualifierValue)) !=
              null) {
            return result;
        }
        switch (elementType) {
            case FIELD:
                result =
                  checkFindBugsDefaultAnnotation(
                    edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                      DEFAULT_ANNOTATION_FOR_FIELDS,
                    o,
                    typeQualifierValue);
                break;
            case METHOD:
                result =
                  checkFindBugsDefaultAnnotation(
                    edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                      DEFAULT_ANNOTATION_FOR_METHODS,
                    o,
                    typeQualifierValue);
                break;
            case PARAMETER:
                result =
                  checkFindBugsDefaultAnnotation(
                    edu.umd.cs.findbugs.ba.jsr305.FindBugsDefaultAnnotations.
                      DEFAULT_ANNOTATION_FOR_PARAMETERS,
                    o,
                    typeQualifierValue);
                break;
            default:
                break;
        }
        if (result ==
              null) {
            edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotationValue =
              o.
              getAnnotation(
                edu.umd.cs.findbugs.ba.jsr305.TypeQualifierResolver.
                  eclipseNonNullByDefault);
            if (annotationValue !=
                  null) {
                java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> resolvedTypeQualifiers =
                  edu.umd.cs.findbugs.ba.jsr305.TypeQualifierResolver.
                  resolveTypeQualifiers(
                    annotationValue);
                tqa =
                  extractAnnotation(
                    resolvedTypeQualifiers,
                    typeQualifierValue);
                if (tqa !=
                      null) {
                    return tqa;
                }
            }
        }
        return result;
    }
    @javax.annotation.CheckForNull
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation checkFindBugsDefaultAnnotation(edu.umd.cs.findbugs.classfile.ClassDescriptor defaultAnnotation,
                                                                                                        edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                                                                                        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        if (DEBUG_DEFAULT_ANNOTATION) {
            java.lang.System.
              out.
              println(
                "Checking for " +
                defaultAnnotation +
                " containing " +
                typeQualifierValue +
                " on " +
                o);
        }
        edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotationValue =
          o.
          getAnnotation(
            defaultAnnotation);
        if (annotationValue ==
              null) {
            if (DEBUG_DEFAULT_ANNOTATION) {
                java.lang.System.
                  out.
                  println(
                    "   ===> no " +
                    defaultAnnotation);
            }
            return null;
        }
        java.lang.Object value =
          annotationValue.
          getValue(
            "value");
        if (value ==
              null) {
            if (DEBUG_DEFAULT_ANNOTATION) {
                java.lang.System.
                  out.
                  println(
                    "   ===> value is null");
            }
            return null;
        }
        java.lang.Object[] types;
        if (value instanceof java.lang.Object[]) {
            types =
              (java.lang.Object[])
                value;
        }
        else {
            types =
              (new java.lang.Object[] { value });
        }
        for (java.lang.Object obj
              :
              types) {
            if (!(obj instanceof org.objectweb.asm.Type)) {
                if (DEBUG_DEFAULT_ANNOTATION) {
                    java.lang.System.
                      out.
                      println(
                        "Found a non-Type value in value array of " +
                        defaultAnnotation.
                          toString(
                            ) +
                        " annotation");
                }
                continue;
            }
            org.objectweb.asm.Type type =
              (org.objectweb.asm.Type)
                obj;
            if (DEBUG_DEFAULT_ANNOTATION) {
                java.lang.System.
                  out.
                  println(
                    "  ===> checking " +
                    type.
                      getDescriptor(
                        ));
            }
            if (type.
                  getDescriptor(
                    ).
                  startsWith(
                    "[")) {
                continue;
            }
            edu.umd.cs.findbugs.classfile.ClassDescriptor typeDesc =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
              instance(
                ).
              getClassDescriptor(
                type.
                  getInternalName(
                    ));
            edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotation =
              new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
              typeDesc);
            java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> resolvedTypeQualifiers =
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierResolver.
              resolveTypeQualifiers(
                annotation);
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
              extractAnnotation(
                resolvedTypeQualifiers,
                typeQualifierValue);
            if (tqa !=
                  null) {
                return tqa;
            }
        }
        return null;
    }
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation extractAnnotation(java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> resolvedTypeQualifiers,
                                                                                           edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        for (edu.umd.cs.findbugs.classfile.analysis.AnnotationValue typeQualifier
              :
              resolvedTypeQualifiers) {
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
              constructTypeQualifierAnnotation(
                typeQualifier);
            if (tqa.
                  typeQualifier.
                  equals(
                    typeQualifierValue)) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "  ===> Found match " +
                        tqa);
                }
                return tqa;
            }
        }
        return null;
    }
    public static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getEffectiveTypeQualifierAnnotation(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                                                                                            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        if (o instanceof edu.umd.cs.findbugs.ba.XMethod) {
            edu.umd.cs.findbugs.ba.XMethod m =
              (edu.umd.cs.findbugs.ba.XMethod)
                o;
            if (m.
                  getName(
                    ).
                  startsWith(
                    "access$")) {
                edu.umd.cs.findbugs.ba.InnerClassAccessMap icam =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getInnerClassAccessMap(
                    );
                try {
                    edu.umd.cs.findbugs.ba.InnerClassAccess ica =
                      icam.
                      getInnerClassAccess(
                        m.
                          getClassName(
                            ),
                        m.
                          getName(
                            ));
                    if (ica !=
                          null &&
                          ica.
                          isLoad(
                            )) {
                        o =
                          ica.
                            getField(
                              );
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      reportMissingClass(
                        e);
                    return null;
                }
            }
        }
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
          computeEffectiveTypeQualifierAnnotation(
            typeQualifierValue,
            o);
        final edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o2 =
          o;
        if (CHECK_EXCLUSIVE &&
              tqa ==
              null &&
              typeQualifierValue.
              isExclusiveQualifier(
                )) {
            tqa =
              computeExclusiveQualifier(
                typeQualifierValue,
                new edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.ComputeEffectiveTypeQualifierAnnotation(
                  ) {
                    @java.lang.Override
                    public edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation compute(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv) {
                        return computeEffectiveTypeQualifierAnnotation(
                                 tqv,
                                 o2);
                    }
                    @java.lang.Override
                    public java.lang.String toString() {
                        return o2.
                          toString(
                            );
                    }
                });
        }
        return tqa;
    }
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation computeEffectiveTypeQualifierAnnotation(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                                                                                                 edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o) {
        java.util.Map<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> map =
          getEffectiveObjectAnnotations(
            ).
          get(
            typeQualifierValue);
        if (map ==
              null) {
            map =
              new java.util.HashMap<edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
                );
            getEffectiveObjectAnnotations(
              ).
              put(
                typeQualifierValue,
                map);
        }
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation result;
        if (map.
              containsKey(
                o)) {
            result =
              map.
                get(
                  o);
        }
        else {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Looking up application of " +
                    typeQualifierValue +
                    " on " +
                    o);
            }
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa;
            tqa =
              getDirectTypeQualifierAnnotation(
                o,
                typeQualifierValue);
            if (tqa ==
                  null &&
                  o instanceof edu.umd.cs.findbugs.ba.XMethod &&
                  !((edu.umd.cs.findbugs.ba.XMethod)
                      o).
                  isStatic(
                    ) &&
                  !((edu.umd.cs.findbugs.ba.XMethod)
                      o).
                  isPrivate(
                    ) &&
                  !"<init>".
                  equals(
                    ((edu.umd.cs.findbugs.ba.XMethod)
                       o).
                      getName(
                        ))) {
                tqa =
                  getInheritedTypeQualifierAnnotation(
                    (edu.umd.cs.findbugs.ba.XMethod)
                      o,
                    typeQualifierValue);
            }
            boolean methodOverrides =
              false;
            if (tqa ==
                  edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                    OVERRIDES_BUT_NO_ANNOTATION) {
                methodOverrides =
                  true;
                tqa =
                  null;
            }
            if (tqa ==
                  null) {
                tqa =
                  getDefaultTypeQualifierAnnotation(
                    o,
                    typeQualifierValue,
                    methodOverrides);
            }
            result =
              tqa;
            map.
              put(
                o,
                result);
            if (DEBUG &&
                  result !=
                  null) {
                java.lang.System.
                  out.
                  println(
                    "  => Answer: " +
                    result.
                      when +
                    " on " +
                    o);
            }
        }
        return result;
    }
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getDirectTypeQualifierAnnotation(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                                                                                          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation result;
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> applications =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
          );
        getDirectApplications(
          applications,
          o,
          o.
            getElementType(
              ));
        result =
          findMatchingTypeQualifierAnnotation(
            applications,
            typeQualifierValue);
        return result;
    }
    public static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getInheritedTypeQualifierAnnotation(edu.umd.cs.findbugs.ba.XMethod o,
                                                                                                            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        assert !o.
          isStatic(
            );
        edu.umd.cs.findbugs.ba.jsr305.ReturnTypeAnnotationAccumulator accumulator =
          new edu.umd.cs.findbugs.ba.jsr305.ReturnTypeAnnotationAccumulator(
          typeQualifierValue,
          o);
        try {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                ).
              traverseSupertypesDepthFirst(
                o.
                  getClassDescriptor(
                    ),
                accumulator);
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation result =
              accumulator.
              getResult(
                ).
              getEffectiveTypeQualifierAnnotation(
                );
            if (result ==
                  null &&
                  accumulator.
                  overrides(
                    )) {
                return edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                         OVERRIDES_BUT_NO_ANNOTATION;
            }
            return result;
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getLookupFailureCallback(
                ).
              reportMissingClass(
                e);
            return null;
        }
    }
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getDefaultTypeQualifierAnnotation(edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o,
                                                                                                           edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                                                                                           boolean stopAtClassScope) {
        if (o.
              isSynthetic(
                )) {
            return null;
        }
        java.lang.annotation.ElementType elementType =
          o.
          getElementType(
            );
        while (true) {
            o =
              o.
                getContainingScope(
                  );
            if (o ==
                  null) {
                return null;
            }
            if (stopAtClassScope &&
                  o instanceof edu.umd.cs.findbugs.ba.XClass) {
                return null;
            }
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation result;
            java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> applications =
              new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
              );
            getDirectApplications(
              applications,
              o,
              elementType);
            result =
              findMatchingTypeQualifierAnnotation(
                applications,
                typeQualifierValue);
            if (result !=
                  null) {
                assert false: "I don\'t think we should be looking here";
                return result;
            }
            result =
              getDefaultAnnotation(
                o,
                typeQualifierValue,
                elementType);
            if (result !=
                  null) {
                return result;
            }
        }
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getEffectiveTypeQualifierAnnotation(final edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                                                                            final int parameter,
                                                                                                            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
          computeEffectiveTypeQualifierAnnotation(
            typeQualifierValue,
            xmethod,
            parameter);
        if (CHECK_EXCLUSIVE &&
              tqa ==
              null &&
              typeQualifierValue.
              isExclusiveQualifier(
                )) {
            tqa =
              computeExclusiveQualifier(
                typeQualifierValue,
                new edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.ComputeEffectiveTypeQualifierAnnotation(
                  ) {
                    @java.lang.Override
                    public edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation compute(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv) {
                        return computeEffectiveTypeQualifierAnnotation(
                                 tqv,
                                 xmethod,
                                 parameter);
                    }
                    @java.lang.Override
                    public java.lang.String toString() {
                        return "parameter " +
                        parameter +
                        " of " +
                        xmethod;
                    }
                });
        }
        return tqa;
    }
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation computeEffectiveTypeQualifierAnnotation(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                                                                                                 edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                                                                                 int parameter) {
        if (DEBUG) {
            if (typeQualifierValue.
                  value !=
                  null) {
                java.lang.System.
                  out.
                  println(
                    "  Value is " +
                    typeQualifierValue.
                      value +
                    "(" +
                    typeQualifierValue.
                      value.
                      getClass(
                        ).
                      toString(
                        ) +
                    ")");
            }
        }
        java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.ba.XMethod,java.lang.Integer,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>> effectiveParameterAnnotations =
          getEffectiveParameterAnnotations(
            );
        edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.ba.XMethod,java.lang.Integer,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> map =
          effectiveParameterAnnotations.
          get(
            typeQualifierValue);
        if (map ==
              null) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "computeEffectiveTypeQualifierAnnotation: Creating map for " +
                    typeQualifierValue);
            }
            map =
              new edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.ba.XMethod,java.lang.Integer,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
                );
            effectiveParameterAnnotations.
              put(
                typeQualifierValue,
                map);
        }
        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation result;
        if (map.
              containsKey(
                xmethod,
                parameter)) {
            result =
              map.
                get(
                  xmethod,
                  parameter);
        }
        else {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Looking up application of " +
                    typeQualifierValue +
                    " on " +
                    xmethod +
                    " parameter " +
                    parameter);
            }
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa;
            if (xmethod.
                  isVarArgs(
                    ) &&
                  parameter ==
                  xmethod.
                  getNumParams(
                    ) -
                  1) {
                tqa =
                  null;
                if (DEBUG) {
                    java.lang.System.
                      out.
                      print(
                        "  vararg parameters don\'t get type qualifiers");
                }
            }
            else {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      print(
                        "  (1) Checking direct application...");
                }
                tqa =
                  getDirectTypeQualifierAnnotation(
                    xmethod,
                    parameter,
                    typeQualifierValue);
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        tqa !=
                          null
                          ? "FOUND"
                          : "none");
                }
                if (tqa ==
                      null &&
                      !xmethod.
                      isStatic(
                        ) &&
                      !xmethod.
                      isPrivate(
                        ) &&
                      !"<init>".
                      equals(
                        xmethod.
                          getName(
                            ))) {
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          print(
                            "  (2) Checking inherited...");
                    }
                    tqa =
                      getInheritedTypeQualifierAnnotation(
                        xmethod,
                        parameter,
                        typeQualifierValue);
                    if (DEBUG) {
                        if (tqa ==
                              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                                OVERRIDES_BUT_NO_ANNOTATION) {
                            java.lang.System.
                              out.
                              println(
                                "Overrides, no annotation inherited");
                        }
                        else
                            if (tqa !=
                                  null) {
                                java.lang.System.
                                  out.
                                  println(
                                    "Inherited " +
                                    tqa.
                                      when);
                            }
                            else {
                                java.lang.System.
                                  out.
                                  println(
                                    "Nothing inherited");
                            }
                    }
                }
                boolean overriddenMethod =
                  false;
                if (tqa ==
                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                        OVERRIDES_BUT_NO_ANNOTATION) {
                    overriddenMethod =
                      true;
                    tqa =
                      null;
                }
                if (tqa ==
                      null) {
                    if (xmethod.
                          isVariableSynthetic(
                            (xmethod.
                               isStatic(
                                 )
                               ? 0
                               : 1) +
                              parameter)) {
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              print(
                                "  (3) Skipping default for synthetic parameter");
                        }
                    }
                    else {
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              print(
                                "  (3) Checking default...");
                        }
                        tqa =
                          getDefaultTypeQualifierAnnotationForParameters(
                            xmethod,
                            typeQualifierValue,
                            overriddenMethod);
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                tqa !=
                                  null
                                  ? "FOUND"
                                  : "none");
                        }
                    }
                }
            }
            result =
              tqa;
            map.
              put(
                xmethod,
                parameter,
                result);
            if (DEBUG) {
                if (result ==
                      null) {
                    java.lang.System.
                      out.
                      println(
                        "  => Answer: no annotation on parameter " +
                        parameter +
                        " of " +
                        xmethod);
                }
                else {
                    java.lang.System.
                      out.
                      println(
                        "  => Answer: " +
                        result.
                          when +
                        " on parameter " +
                        parameter +
                        " of " +
                        xmethod);
                }
            }
        }
        if (!map.
              containsKey(
                xmethod,
                parameter)) {
            throw new java.lang.IllegalStateException(
              "Did not populate cache?");
        }
        return result;
    }
    @javax.annotation.CheckForNull
    @javax.annotation.CheckReturnValue
    public static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getDirectTypeQualifierAnnotation(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                                                                         int parameter,
                                                                                                         edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        edu.umd.cs.findbugs.ba.XMethod bridge =
          xmethod.
          bridgeTo(
            );
        if (bridge !=
              null) {
            xmethod =
              bridge;
        }
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> applications =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
          );
        getDirectApplications(
          applications,
          xmethod,
          parameter);
        if (DEBUG_METHOD !=
              null &&
              DEBUG_METHOD.
              equals(
                xmethod.
                  getName(
                    ))) {
            java.lang.System.
              out.
              println(
                "  Direct applications are: " +
                applications);
        }
        return findMatchingTypeQualifierAnnotation(
                 applications,
                 typeQualifierValue);
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getInheritedTypeQualifierAnnotation(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                                                                            int parameter,
                                                                                                            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        assert !xmethod.
          isStatic(
            );
        edu.umd.cs.findbugs.ba.jsr305.ParameterAnnotationAccumulator accumulator =
          new edu.umd.cs.findbugs.ba.jsr305.ParameterAnnotationAccumulator(
          typeQualifierValue,
          xmethod,
          parameter);
        try {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                ).
              traverseSupertypesDepthFirst(
                xmethod.
                  getClassDescriptor(
                    ),
                accumulator);
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation result =
              accumulator.
              getResult(
                ).
              getEffectiveTypeQualifierAnnotation(
                );
            if (result ==
                  null &&
                  accumulator.
                  overrides(
                    )) {
                return edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                         OVERRIDES_BUT_NO_ANNOTATION;
            }
            return result;
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getLookupFailureCallback(
                ).
              reportMissingClass(
                e);
            return null;
        }
    }
    @javax.annotation.CheckForNull
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getDefaultTypeQualifierAnnotationForParameters(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                                                                                        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                                                                                                        boolean stopAtMethodScope) {
        if (xmethod.
              isSynthetic(
                )) {
            return null;
        }
        if ("<init>".
              equals(
                xmethod.
                  getName(
                    )) &&
              xmethod.
              getClassDescriptor(
                ).
              isAnonymousClass(
                )) {
            return null;
        }
        if (xmethod.
              isPrivate(
                )) {
            stopAtMethodScope =
              true;
        }
        boolean stopAtClassScope =
          false;
        if (!xmethod.
              isPublic(
                ) &&
              !xmethod.
              isProtected(
                ) &&
              (xmethod.
                 isStatic(
                   ) ||
                 "<init>".
                 equals(
                   xmethod.
                     getName(
                       )))) {
            try {
                edu.umd.cs.findbugs.ba.XClass xclass =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    xmethod.
                      getClassDescriptor(
                        ));
                stopAtClassScope =
                  xclass.
                    isPrivate(
                      );
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Problem resolving class for " +
                    xmethod,
                    e);
            }
        }
        edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject o =
          xmethod;
        while (true) {
            if (o ==
                  null) {
                return null;
            }
            if (stopAtMethodScope &&
                  o instanceof edu.umd.cs.findbugs.ba.XClass) {
                return null;
            }
            java.util.Set<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> applications =
              new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
              );
            getDirectApplications(
              applications,
              o,
              java.lang.annotation.ElementType.
                PARAMETER);
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
              findMatchingTypeQualifierAnnotation(
                applications,
                typeQualifierValue);
            if (tqa !=
                  null) {
                assert false: "I think this code is dead; it shouldn\'t find anything";
                return tqa;
            }
            tqa =
              getDefaultAnnotation(
                o,
                typeQualifierValue,
                java.lang.annotation.ElementType.
                  PARAMETER);
            if (tqa !=
                  null) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Found default of " +
                        tqa +
                        " @ " +
                        o);
                }
                return tqa;
            }
            if (stopAtClassScope &&
                  o instanceof edu.umd.cs.findbugs.ba.XClass) {
                return null;
            }
            o =
              o.
                getContainingScope(
                  );
        }
    }
    private static edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation computeExclusiveQualifier(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                                                                                   edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.ComputeEffectiveTypeQualifierAnnotation c) {
        assert typeQualifierValue.
          isExclusiveQualifier(
            );
        boolean isExhaustive =
          CHECK_EXHAUSTIVE &&
          typeQualifierValue.
          isExhaustiveQualifier(
            );
        boolean allComplementaryValuesAreWhenEqualsNever =
          true;
        java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> complementaryTypeQualifierValues =
          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
          getComplementaryExclusiveTypeQualifierValue(
            typeQualifierValue);
        for (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> complementaryTypeQualifierValue
              :
              complementaryTypeQualifierValues) {
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation complementaryTqa =
              c.
              compute(
                complementaryTypeQualifierValue);
            if (complementaryTqa !=
                  null) {
                if (complementaryTqa.
                      when ==
                      javax.annotation.meta.When.
                        ALWAYS) {
                    return edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                      getValue(
                        typeQualifierValue,
                        javax.annotation.meta.When.
                          NEVER);
                }
                else
                    if (complementaryTqa.
                          when !=
                          javax.annotation.meta.When.
                            NEVER) {
                        allComplementaryValuesAreWhenEqualsNever =
                          false;
                    }
            }
            else {
                allComplementaryValuesAreWhenEqualsNever =
                  false;
            }
        }
        if (isExhaustive &&
              allComplementaryValuesAreWhenEqualsNever) {
            if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                  DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "*** application of " +
                    typeQualifierValue +
                    " on " +
                    c +
                    " is when=ALWAYS due to exhaustion");
            }
            return edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
              getValue(
                typeQualifierValue,
                javax.annotation.meta.When.
                  ALWAYS);
        }
        return null;
    }
    public TypeQualifierApplications() { super(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL19CbTr6F2f332zZzIzmck6SWZJJoSJ4cmSZcvODCGyLFuL" +
       "JVmWN4mSh3bL1mZtlh2GBAgkhZLktEOaHpJpTxvaQoeE0nLYCg2lLQn7lnTC" +
       "OSWhh9NOgPQQekIok0Il2Xd99955b96bvHP0WVff9v///usnfdJ7+kulm8Og" +
       "VPY9e23aXnRJT6NLc7t2KVr7eniJ6tX6chDqGmbLYTjMrl1W3/CTd//Vcx+c" +
       "3bNXukUq3Se7rhfJkeW54UAPPTvRtV7p7sOruK07YVS6pzeXExmII8sGelYY" +
       "PdYrveRI16j0SG+fBCAjAchIAAoSAPSwVdbppbobO1jeQ3ajcFn6rtKFXukW" +
       "X83Ji0oPHx/ElwPZ2Q3TLzjIRrgt/3ucMVV0ToPSQwe8b3m+guEfLgNP/uN3" +
       "3PNTF0t3S6W7LVfIyVEzIqJsEql0p6M7ih6EqKbpmlR6mavrmqAHlmxbm4Ju" +
       "qXRvaJmuHMWBfgBSfjH29aCY8xC5O9WctyBWIy84YM+wdFvb/+tmw5bNjNdX" +
       "HvK65bCTX88YvMPKCAsMWdX3u9y0sFwtKj14sscBj4/QWYOs662OHs28g6lu" +
       "cuXsQunerexs2TUBIQos18ya3uzF2SxR6f4zB82x9mV1IZv65aj06pPt+tuq" +
       "rNXtBRB5l6j0ipPNipEyKd1/QkpH5PMl9vH3v9Ml3L2CZk1X7Zz+27JOD5zo" +
       "NNANPdBdVd92vPMtvQ/Jr/zF9+2VSlnjV5xovG3zM9/55bd/0wOf/NS2zWtP" +
       "acMpc12NLqsfU+763ddhjzYv5mTc5nuhlQv/GOeF+vd3NY+lfmZ5rzwYMa+8" +
       "tF/5ycF/Fd/94/qf7ZXuIEu3qJ4dO5kevUz1HN+y9aCru3ogR7pGlm7XXQ0r" +
       "6snSrdl5z3L17VXOMEI9Iks32cWlW7zi7wwiIxsih+jW7NxyDW//3JejWXGe" +
       "+qVS6dbsKN2ZHc3S9l/xG5VcYOY5OiCrsmu5HtAPvJz/ENDdSMmwnQFGpkxK" +
       "bIZAGKhAoTq6FgOxowFqeFipyMA8DKqVWiFiPs7MJdPzAPV921K39n4p7+x/" +
       "3WdMcwzuWV24kInndSedg53ZFeHZmh5cVp+MW/iXP3751/cOjGWHXlRCMgIu" +
       "ZQRcUsNL+wRcUuRLWwIunUlA6cKFYt6X54RsVSIT6CJzDZnTvPNR4dup73jf" +
       "Gy5muuivbsqkkTcFzvbd2KEzIQuXqWYaXfrkh1ffPX5XZa+0d9wJ58Rnl+7I" +
       "u/dz13ngIh85aXynjXv3e5/9q0986Anv0AyPefWdd7iyZ27dbzgJc+CpGYKB" +
       "fjj8Wx6Sf/ryLz7xyF7ppsxlZG4ykjO1zjzQAyfnOGblj+17zJyXmzOGDS9w" +
       "ZDuv2ndzd0SzwFsdXinkf1dx/rIM4zeXdsUxO8hr7/Pz8uVbfcmFdoKLwiN/" +
       "i+B/9Jnf+mK1gHvfed99JBwKevTYEYeRD3Z34RpedqgDw0DXs3b//cP9f/TD" +
       "X3rvtxUKkLV442kTPpKXWOYoMhFmMH/fp5af+/wffewP9g6VJsoiZqxkOpdu" +
       "mfy77N+F7Pjb/MiZyy9sjf1ebOdxHjpwOX4+8zcc0pY5Hzszx1yDHhm5jqdl" +
       "Si0rtp5r7NfufhP403/+/nu2OmFnV/ZV6puef4DD669pld796+/46gPFMBfU" +
       "PPgd4nfYbOtR7zscGQ0CeZ3TkX73773+n/yq/NHMN2f+MLQ2euHiSgUepUKA" +
       "lQKLclECJ+qgvHgwPGoIx23tSJJyWf3gH/zFS8d/8UtfLqg9nuUclTsj+49t" +
       "VS0vHkqz4V910uoJOZxl7eBPsn/vHvuTz2UjStmIahbaQy7IfFB6TEt2rW++" +
       "9Q9/+Vde+R2/e7G01yndYXuy1pELgyvdnmm6Hs4y95X63/r2rTavbsuKewpW" +
       "S1cwv1WQVxd/3Z4R+OjZvqaTJymH5vrqv+Fs5Xv+x19fAULhZU6JzSf6S8DT" +
       "H7kfe9ufFf0PzT3v/UB6pV/OErrDvtCPO1/Ze8Mt/2WvdKtUukfdZYtj2Y5z" +
       "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" +
       "dgeMH8UKx8pcFe33PFQfoEu5jWrsArUU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "q2X/H8plvMwGYgAA");
}
