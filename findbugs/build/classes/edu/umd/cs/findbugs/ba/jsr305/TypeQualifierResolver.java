package edu.umd.cs.findbugs.ba.jsr305;
public class TypeQualifierResolver {
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor typeQualifier =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        javax.annotation.meta.TypeQualifier.class);
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor typeQualifierNickname =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        javax.annotation.meta.TypeQualifierNickname.class);
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor typeQualifierDefault =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        javax.annotation.meta.TypeQualifierDefault.class);
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      elementTypeDescriptor =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.lang.annotation.ElementType.class);
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      googleNullable =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        "com/google/common/base/Nullable");
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      intellijNullable =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        "org/jetbrains/annotations/Nullable");
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      eclipseNullable =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        "org/eclipse/jdt/annotation/Nullable");
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      eclipseNonNull =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        "org/eclipse/jdt/annotation/NonNull");
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      eclipseNonNullByDefault =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        "org/eclipse/jdt/annotation/NonNullByDefault");
    public static java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> resolveTypeQualifiers(edu.umd.cs.findbugs.classfile.analysis.AnnotationValue value) {
        java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> result =
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>(
          );
        resolveTypeQualifierNicknames(
          value,
          result,
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
            ));
        return result;
    }
    public static java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> resolveTypeQualifierDefaults(java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> values,
                                                                                                                            java.lang.annotation.ElementType elementType) {
        java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> result =
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>(
          );
        for (edu.umd.cs.findbugs.classfile.analysis.AnnotationValue value
              :
              values) {
            resolveTypeQualifierDefaults(
              value,
              elementType,
              result);
        }
        return result;
    }
    private static void resolveTypeQualifierNicknames(edu.umd.cs.findbugs.classfile.analysis.AnnotationValue value,
                                                      java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> result,
                                                      java.util.LinkedList<edu.umd.cs.findbugs.classfile.ClassDescriptor> onStack) {
        edu.umd.cs.findbugs.classfile.ClassDescriptor annotationClass =
          value.
          getAnnotationClass(
            );
        if (onStack.
              contains(
                annotationClass)) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Cycle found in type nicknames: " +
                onStack);
            return;
        }
        try {
            onStack.
              add(
                annotationClass);
            try {
                if (annotationClass.
                      equals(
                        googleNullable) ||
                      annotationClass.
                      equals(
                        eclipseNullable) ||
                      annotationClass.
                      equals(
                        intellijNullable)) {
                    resolveTypeQualifierNicknames(
                      new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
                        edu.umd.cs.findbugs.ba.jsr305.JSR305NullnessAnnotations.
                          CHECK_FOR_NULL),
                      result,
                      onStack);
                    return;
                }
                if (annotationClass.
                      equals(
                        eclipseNonNull) ||
                      annotationClass.
                      equals(
                        eclipseNonNullByDefault)) {
                    resolveTypeQualifierNicknames(
                      new edu.umd.cs.findbugs.classfile.analysis.AnnotationValue(
                        edu.umd.cs.findbugs.ba.jsr305.JSR305NullnessAnnotations.
                          NONNULL),
                      result,
                      onStack);
                    return;
                }
                edu.umd.cs.findbugs.ba.XClass c =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    annotationClass);
                if (c.
                      getAnnotationDescriptors(
                        ).
                      contains(
                        typeQualifierNickname)) {
                    for (edu.umd.cs.findbugs.classfile.ClassDescriptor d
                          :
                          c.
                           getAnnotationDescriptors(
                             )) {
                        if (!d.
                              equals(
                                typeQualifierNickname)) {
                            resolveTypeQualifierNicknames(
                              c.
                                getAnnotation(
                                  d),
                              result,
                              onStack);
                        }
                    }
                }
                else
                    if (c.
                          getAnnotationDescriptors(
                            ).
                          contains(
                            typeQualifier)) {
                        result.
                          add(
                            value);
                    }
            }
            catch (edu.umd.cs.findbugs.classfile.MissingClassException e) {
                logMissingAnnotationClass(
                  e);
                return;
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Error resolving " +
                    annotationClass,
                    e);
                return;
            }
        }
        finally {
            onStack.
              removeLast(
                );
        }
    }
    public static void logMissingAnnotationClass(edu.umd.cs.findbugs.classfile.MissingClassException e) {
        edu.umd.cs.findbugs.classfile.ClassDescriptor c =
          e.
          getClassDescriptor(
            );
        if (c.
              getClassName(
                ).
              startsWith(
                "javax.annotation")) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getLookupFailureCallback(
                ).
              reportMissingClass(
                c);
        }
    }
    public static java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> resolveTypeQualifiers(java.util.Collection<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> values) {
        if (values.
              isEmpty(
                )) {
            return java.util.Collections.
              emptyList(
                );
        }
        java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> result =
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue>(
          );
        java.util.LinkedList<edu.umd.cs.findbugs.classfile.ClassDescriptor> onStack =
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
          );
        for (edu.umd.cs.findbugs.classfile.analysis.AnnotationValue value
              :
              values) {
            resolveTypeQualifierNicknames(
              value,
              result,
              onStack);
        }
        return result;
    }
    private static void resolveTypeQualifierDefaults(edu.umd.cs.findbugs.classfile.analysis.AnnotationValue value,
                                                     java.lang.annotation.ElementType defaultFor,
                                                     java.util.LinkedList<edu.umd.cs.findbugs.classfile.analysis.AnnotationValue> result) {
        try {
            edu.umd.cs.findbugs.ba.XClass c =
              edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                ).
              getClassAnalysis(
                edu.umd.cs.findbugs.ba.XClass.class,
                value.
                  getAnnotationClass(
                    ));
            edu.umd.cs.findbugs.classfile.analysis.AnnotationValue defaultAnnotation =
              c.
              getAnnotation(
                typeQualifierDefault);
            if (defaultAnnotation ==
                  null) {
                return;
            }
            for (java.lang.Object o
                  :
                  (java.lang.Object[])
                    defaultAnnotation.
                    getValue(
                      "value")) {
                if (o instanceof edu.umd.cs.findbugs.classfile.analysis.EnumValue) {
                    edu.umd.cs.findbugs.classfile.analysis.EnumValue e =
                      (edu.umd.cs.findbugs.classfile.analysis.EnumValue)
                        o;
                    if (e.
                          desc.
                          equals(
                            elementTypeDescriptor) &&
                          e.
                            value.
                          equals(
                            defaultFor.
                              name(
                                ))) {
                        for (edu.umd.cs.findbugs.classfile.ClassDescriptor d
                              :
                              c.
                               getAnnotationDescriptors(
                                 )) {
                            if (!d.
                                  equals(
                                    typeQualifierDefault)) {
                                resolveTypeQualifierNicknames(
                                  c.
                                    getAnnotation(
                                      d),
                                  result,
                                  new java.util.LinkedList<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
                                    ));
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (edu.umd.cs.findbugs.classfile.MissingClassException e) {
            logMissingAnnotationClass(
              e);
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error resolving " +
                value.
                  getAnnotationClass(
                    ),
                e);
        }
        catch (java.lang.ClassCastException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "ClassCastException " +
                value.
                  getAnnotationClass(
                    ),
                e);
        }
    }
    public TypeQualifierResolver() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "L240SaUqAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9S5LeOuFAjeqq2UazDkGmWdzRRI7VBioq0hAyxPHQmvIlvRwYTF19WlTSayM" +
       "jZVKryr0Rmsp0tfUsqJW+6RcqXpbzBl0FIxaRJSvqAEiVwXUp9HYhbc4S1b4" +
       "iEarjKXhKtn0E5xtcsBmq6qc1EJs1tyaWSqzOMInbLvcUMrmCKOzfs9SBxug" +
       "YXbkcGBbk9bYtpk1W3BaI8aUm9lbrlFmxlN6rrRJvVwh1v1Jh+9JC7qiLTbd" +
       "zEf7TaLaskS6kkxIvuqTVFYKbTZFtVXF1ZoGzRnEhFfaolNHNmO3JvJVfEw1" +
       "5gk/oKt+UCW7mW2KjQVHkxNRJ+c2Myl3pJGFubI1MJMAL5HYFukQPbLBy8YI" +
       "eAbiUBdnukn1qe6E54iKmPDYWhVFftEI6plRgjOSojpCl6Tp2Qxs6spUReaS" +
       "5S2seqdeApu/7oZaf5ts+KrokgzZXYN9h7ba9GbLN6yZ4snN7kprcg1Z4tla" +
       "l6Q4RRg06MlwImpsgmJtm2Gyvp/Uxmk8T3x+WPW1jKxJyCghNaNpbqa6RG+M" +
       "7nCQipju+hrjmEGgezLt9rQKrY8ao4a9IOjlqM+MyWWvMiFpggXa0ldMxdxW" +
       "1zCzGGjDbm1EpXS3tBE5TqaSBO/XEXQVC1IGK1VzQSuzKrWdSdZ8vHHHcL1e" +
       "ocztWl3Va/Yi3Tams2w8JgWXUBviWqjI3UrgD7woI7F41pnBBJ4Rvgr8KTNi" +
       "9LmKtSaMAw/IBrXVal2cqAgquiKiClme1yvl+ppJK7qpynOvNQgpogqzc8fg" +
       "Vbo0YWV25lic2sQa9RlRxYPMWXbKvp0mo6m1lTWfrFYDW+0tpKZPzTYlFSnH" +
       "pl8SOhE+qlp+hpHlxWCld7ZrapD0aGWZJTo7I4HEZpPGumlZdQZtb2CRmjJ3" +
       "W0Zaolr1ea+WLuesmDX6UhYuNhrsqKaqwVxTliV3bk3qdVMeKJX2OEbC+mit" +
       "4QTqG9M6qsxxsDPK+HY19gjK4OMYr09WTbSy7cW2xvdqDQ/QdVhdxUvOx2SE" +
       "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" +
       "8Ot58ukQesTfxe2ciuUJbj6HQrQMwhMh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("az9pvPS7//7Pr75/dwF8+jq7iFo8aHq23Ve+fBl5XXj9p4q5v2MpBYW27+ah" +
       "O4O8Zgg9eXEEZNHX7q76dccxIND5MSCPnRdrsdOi56WHqn74vICOvOzfnLoG" +
       "P18dN+SWfUP47Fc+iBe33FdjIzBCVRkfhGeeDvg4Doh67lTI5rkKuyF/4+Wf" +
       "/NxTfzR9qIjF2+kmh1VNvQI6cUAJewUlXIJ2QVVvvQDwAaIiPuWG/N6P/9Xv" +
       "fvOFr37+MnQFmH2+ViRfBcsihPYvCmE92cH1MXijQCuwgO7ftTYcrZjig6l8" +
       "8Cj3KCIqhJ69qO/ik8eZwKk8CNRyE9VvuJGj5N0+fma1Rp53srQwivteo1H8" +
       "uA+94xY0eKSAQ8J9sFgDJz435R9AThZ6IfRQkycF4cZYHNA3puSoBY7GdGFn" +
       "Hijco8/5ALYL4ygE+8ypkJYD6i92iJe/33eTkxxQZPzT05SW09jiAOriB0hp" +
       "l45r/atD4Z48Fu6Y9Pfp40/6RU//+SYM9vU8+YMQetN5DHbwcTM4HrNQ0Zdf" +
       "g4oeyjPz6Ar/QEWb21FRCN3l+UYsherFerp87CZ8psj8jdsx4mNSuRmzHdfK" +
       "y/6kqPFbF9JInv/brxFE3vr3isF25p2/fuliU/6NPPl2Uf4ntwAxz/6zPGHP" +
       "dFb08K2b2M9f5sl/C6E3n2c/h9E5Ox77mRMO2M+F0B2xayjHRvXfX4NRPZhn" +
       "tsDz8wdG9fM/wHV3xpU4N5r32JXoGkFwSN50KqteviLzfvfuvViLe3no396d" +
       "IfRDlqsd9HDsihxtBN870tbeldfKUrnj9WsH2vq1H7y2CsYoRHv0JmI/licP" +
       "XeQ+nWadvYdfK+vk5V88EPkLtyvyN2+NcPLkD/PkjwsBr99E+LflyRO3wLwn" +
       "pv3J29FBChR7bnB5Hh376Kv+w2X3Xxnyp1+6evcbX5r8QRFfffSfE/fw0N2r" +
       "yLJOBjOeeL/i+erKKLRzzy60sWCsvWcBMdw0+j2EruxecvR779i1KgM/7/xW" +
       "IXQJOLgnqqLADzinagjQHryerI2H0L3HtUFn8qniOtheDopD6DJITxY+D7JA" +
       "Yf76Tm/HvnsXuBAPfr9ZOnFcfPpCt7Ub7f4/6Yb88kvt3o99B/+FXeg44Jrt" +
       "Nu8F+IV37aLYjw51T13Y22FfV7hnvnv/r97z1sMD6P07wMfmfwLbE+fHZtO2" +
       "FxbR1Nt/8cbPPP+LL321COz5v5kGJUM2NgAA");
}
