package edu.umd.cs.findbugs.detect;
@java.lang.Deprecated
public class BuildNonNullAnnotationDatabase extends edu.umd.cs.findbugs.visitclass.AnnotationVisitor {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug.annotation");
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
    private final edu.umd.cs.findbugs.ba.NullnessAnnotationDatabase
      database;
    public BuildNonNullAnnotationDatabase(@javax.annotation.CheckForNull
                                          edu.umd.cs.findbugs.ba.NullnessAnnotationDatabase database) {
        super(
          );
        this.
          database =
          database;
    }
    static java.lang.String lastPortion(java.lang.String className) {
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
    private void handleClassElementValue(org.apache.bcel.classfile.ClassElementValue value,
                                         edu.umd.cs.findbugs.ba.AnnotationDatabase.Target annotationTarget) {
        edu.umd.cs.findbugs.ba.NullnessAnnotation n =
          edu.umd.cs.findbugs.ba.NullnessAnnotation.Parser.
          parse(
            value.
              getClassString(
                ));
        if (n !=
              null) {
            database.
              addDefaultAnnotation(
                annotationTarget,
                getDottedClassName(
                  ),
                n);
        }
    }
    @java.lang.Override
    public void visitAnnotation(java.lang.String annotationClass,
                                java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                boolean runtimeVisible) {
        if (database ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.ba.NullnessAnnotation n =
          edu.umd.cs.findbugs.ba.NullnessAnnotation.Parser.
          parse(
            annotationClass);
        annotationClass =
          lastPortion(
            annotationClass);
        if (n ==
              null) {
            if (annotationClass.
                  startsWith(
                    "DefaultAnnotation")) {
                annotationClass =
                  annotationClass.
                    substring(
                      "DefaultAnnotation".
                        length(
                          ));
                edu.umd.cs.findbugs.ba.AnnotationDatabase.Target annotationTarget =
                  defaultKind.
                  get(
                    annotationClass);
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
                                  annotationTarget);
                            }
                        }
                    }
                return;
            }
        }
        else
            if (visitingMethod(
                  )) {
                database.
                  addDirectAnnotation(
                    edu.umd.cs.findbugs.ba.XFactory.
                      createXMethod(
                        this),
                    n);
            }
            else
                if (visitingField(
                      )) {
                    database.
                      addDirectAnnotation(
                        edu.umd.cs.findbugs.ba.XFactory.
                          createXField(
                            this),
                        n);
                }
    }
    @java.lang.Override
    public void visitSyntheticParameterAnnotation(int p,
                                                  boolean runtimeVisible) {
        if (database ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            this);
        edu.umd.cs.findbugs.ba.XMethodParameter xparameter =
          new edu.umd.cs.findbugs.ba.XMethodParameter(
          xmethod,
          p);
        database.
          addDirectAnnotation(
            xparameter,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
    }
    @java.lang.Override
    public void visitParameterAnnotation(int p,
                                         java.lang.String annotationClass,
                                         java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                         boolean runtimeVisible) {
        if (database ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.ba.NullnessAnnotation n =
          edu.umd.cs.findbugs.ba.NullnessAnnotation.Parser.
          parse(
            annotationClass);
        annotationClass =
          lastPortion(
            annotationClass);
        if (n ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            this);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Parameter " +
                p +
                " @" +
                annotationClass.
                  substring(
                    annotationClass.
                      lastIndexOf(
                        '/') +
                      1) +
                " in " +
                xmethod.
                  toString(
                    ));
        }
        edu.umd.cs.findbugs.ba.XMethodParameter xparameter =
          new edu.umd.cs.findbugs.ba.XMethodParameter(
          xmethod,
          p);
        database.
          addDirectAnnotation(
            xparameter,
            n);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8D8MHhnkwGwSms9f8W3BfwEJDCn7diUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kUc/Vbl8uDM7jqD7I9f7XktJFOsEqXvv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fnZDF7e39meav/aRP3li9n3aC2/gjsfbz/B5luRP069+afBu6ROXoSvHJ5x3" +
       "3Cs73ei5M/v7gRLFgTM7dbr55Old4CfBQx5qljy7C7y35vlm6u+84czR/KV9" +
       "hbSo8K/ucnb/b/Lk1Qh6AFgpGrvB0Y2MdO9En3297cuTNIuMnz6WMb9UBfHg" +
       "YQ9lZN+ojNi5Ml7e7YMfbdmX3GB9IHiCpCkHoqRYu0OR/PLXzv3yq5nK4Rl2" +
       "3iQqiH7hLnr5lTz5xQh6TBMc2VLuoHLu3m/i6vJeb7/0d9BbcQfHAc/7D/X2" +
       "/jeqt+8+V29X9qCy65LPkw8UdV8okiJXvOh8Ls82jrT+7ou1flbhyc4b7zyZ" +
       "YYr0t+9iid/Lky9FhyeT+/OXPPtX99r+9dc917l54nQqUYJAl5XXPbN5PRON" +
       "wfPDhyb64e+MiU669hkHu6I70V5p//UuSvtannwlgp4plMZunQiECLpUIKAS" +
       "KcGFavzqhWrMs//g76ywD4LnE4cK+8R3RmH3FBXuyT//qHCzPPkPez39+V30" +
       "9M08+R8R9Hihp9dXz//8DqonjaCn7n45Mr/p9fgdd7Z394yln33lxn2PvTL/" +
       "T8X9wOO7wPdT0H1qfpXrxPWaE+9XvUBR9UL0+3eXbbzi768i6ImL73BG0NXd" +
       "SyHDXxZNLuUn0ec0iUD/h68na1+JoOv72hF0WTpVfDWCrh0WAzcH6cnC+0EW" +
       "KMxfr3t3PVEurFig0ImTZS7PdIP00ulI5dimN18XOd68R46eAjQo5XeBXtfW" +
       "J2Kid154U4KOd9f1b0ufe2XI/MA3mj+1uzcJhMiynMp9FHRtd4XzOHJ55kJq" +
       "R7Su4s9+66Gfu/9dR1HWQzs59+PrBG9vP/+SImZ7UXGtMPvFx37++X/xyleK" +
       "g9T/B+ON9RdFMQAA");
}
