package edu.umd.cs.findbugs.detect;
public class BuildCheckReturnAnnotationDatabase extends edu.umd.cs.findbugs.visitclass.AnnotationVisitor {
    private static final java.lang.String DEFAULT_ANNOTATION_ANNOTATION_CLASS =
      "DefaultAnnotation";
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    private static final java.util.Map<java.lang.String,edu.umd.cs.findbugs.ba.AnnotationDatabase.Target>
      defaultKind =
      new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.ba.AnnotationDatabase.Target>(
      );
    static { defaultKind.put("", edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                                   ANY);
             defaultKind.put("ForParameters", edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                                                PARAMETER);
             defaultKind.put("ForMethods",
                             edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                               METHOD);
             defaultKind.put("ForFields",
                             edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                               FIELD); }
    public BuildCheckReturnAnnotationDatabase() {
        super(
          );
    }
    static java.lang.String simpleClassName(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                            java.lang.String className) {
        int i =
          className.
          lastIndexOf(
            '.');
        if (i <
              0) {
            return className;
        }
        return className.
          substring(
            i +
              1);
    }
    @java.lang.Override
    public void visitAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                java.lang.String annotationClassName,
                                java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                boolean runtimeVisible) {
        java.lang.String annotationClassSimpleName =
          simpleClassName(
            annotationClassName);
        if (annotationClassSimpleName.
              startsWith(
                DEFAULT_ANNOTATION_ANNOTATION_CLASS)) {
            annotationClassSimpleName =
              annotationClassSimpleName.
                substring(
                  DEFAULT_ANNOTATION_ANNOTATION_CLASS.
                    length(
                      ));
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target annotationTarget =
              defaultKind.
              get(
                annotationClassSimpleName);
            if (annotationTarget !=
                  edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                    METHOD) {
                return;
            }
            org.apache.bcel.classfile.ElementValue v =
              map.
              get(
                "value");
            if (v instanceof org.apache.bcel.classfile.ClassElementValue) {
                handleClassElementValue(
                  (org.apache.bcel.classfile.ClassElementValue)
                    v,
                  map,
                  annotationTarget);
            }
            else
                if (v instanceof org.apache.bcel.classfile.ArrayElementValue) {
                    for (org.apache.bcel.classfile.ElementValue v2
                          :
                          ((org.apache.bcel.classfile.ArrayElementValue)
                             v).
                           getElementValuesArray(
                             )) {
                        if (v2 instanceof org.apache.bcel.classfile.ClassElementValue) {
                            handleClassElementValue(
                              (org.apache.bcel.classfile.ClassElementValue)
                                v2,
                              map,
                              annotationTarget);
                        }
                    }
                }
            return;
        }
        edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation n;
        if (annotationClassName.
              equals(
                javax.annotation.CheckReturnValue.class.
                  getName(
                    ))) {
            org.apache.bcel.classfile.ElementValue v =
              map.
              get(
                "when");
            if (v instanceof org.apache.bcel.classfile.EnumElementValue) {
                org.apache.bcel.classfile.EnumElementValue when =
                  (org.apache.bcel.classfile.EnumElementValue)
                    v;
                java.lang.String w =
                  simpleClassName(
                    when.
                      getEnumValueString(
                        ));
                if ("NEVER".
                      equals(
                        w) ||
                      "UNKNOWN".
                      equals(
                        w)) {
                    n =
                      edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                        CHECK_RETURN_VALUE_IGNORE;
                }
                else
                    if ("MAYBE".
                          equals(
                            w)) {
                        n =
                          edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                            CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE;
                    }
                    else
                        if ("ALWAYS".
                              equals(
                                w)) {
                            n =
                              edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                CHECK_RETURN_VALUE_HIGH;
                        }
                        else {
                            return;
                        }
            }
            else {
                n =
                  edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                    CHECK_RETURN_VALUE_MEDIUM;
            }
        }
        else
            if (annotationClassName.
                  equals(
                    edu.umd.cs.findbugs.annotations.CheckReturnValue.class.
                      getName(
                        ))) {
                n =
                  edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                    parse(
                      getAnnotationParameterAsString(
                        map,
                        "priority"));
            }
            else
                if ("CheckReturnValue".
                      equals(
                        annotationClassSimpleName)) {
                    n =
                      edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                        CHECK_RETURN_VALUE_MEDIUM;
                }
                else {
                    return;
                }
        if (n ==
              null) {
            return;
        }
        if (visitingMethod(
              )) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getCheckReturnAnnotationDatabase(
                ).
              addDirectAnnotation(
                edu.umd.cs.findbugs.ba.XFactory.
                  createXMethod(
                    this),
                n);
        }
        else {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getCheckReturnAnnotationDatabase(
                ).
              addDefaultAnnotation(
                edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
                  METHOD,
                getDottedClassName(
                  ),
                n);
        }
    }
    private void handleClassElementValue(org.apache.bcel.classfile.ClassElementValue value,
                                         java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                         edu.umd.cs.findbugs.ba.AnnotationDatabase.Target annotationTarget) {
        if ("CheckReturnValue".
              equals(
                simpleClassName(
                  value.
                    getClassString(
                      )))) {
            edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation n =
              edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
              parse(
                getAnnotationParameterAsString(
                  map,
                  "priority"));
            if (n !=
                  null) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getCheckReturnAnnotationDatabase(
                    ).
                  addDefaultAnnotation(
                    annotationTarget,
                    getDottedClassName(
                      ),
                    n);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2Av+F6+YKgORIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ttrf5YerIyVQNNM4UjXD2R9cFLeWjorr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("hMbxKW3R27/T3n7546fORNg/jKFrqu87huKVHP3SPYzwb4vi1fj4eAs/770X" +
       "iN639S39YJgvvO4hwo0zxx4gIw4t3XjdA4J7WLO4nQXtwPOxY2t+7I1ak7iX" +
       "NU+4hu9uj9JHLxrll4vCLSl/7R6a/k9F8eUYetJUPP3Y3S+S+rWDdr/yRtw+" +
       "i6HnXv9uVXFR5K23Xf/cX1nUfuGV6w88+cr098rrRafXCh8cQg8sE8c5e65/" +
       "5v1qEBpLqxTvwf0pf1D++70Yeuru18Bi6Or+pZTjd/dD/iCGnrjDkBh8//j1" +
       "bO8/jKGHDr1j6LJ2rvlbIAKOm2PoCijPNv5XUAUai9c/Cu55DlfGRGn9M+dx" +
       "UlHph9ml24OwNNyN1zPcmQnr+bseFI+S/RXeW9oXX2HYH/tu6/P7+1OAmzwv" +
       "qDwwhK7tr3KdTivP3pXaCa2r1Avfe/QXH3znyRT46J7hQ9ic4e0dd76s1HOD" +
       "uLxelP/rJ3/lB3/ulW+Ux17/D/zc1i5ZLQAA");
}
