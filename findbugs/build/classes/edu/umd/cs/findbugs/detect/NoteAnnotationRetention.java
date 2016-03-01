package edu.umd.cs.findbugs.detect;
public class NoteAnnotationRetention extends edu.umd.cs.findbugs.visitclass.AnnotationVisitor implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.NonReportingDetector, edu.umd.cs.findbugs.FirstPassDetector {
    private boolean runtimeRetention;
    public NoteAnnotationRetention(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
    }
    @java.lang.Override
    public void visitAnnotation(java.lang.String annotationClass,
                                java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                boolean runtimeVisible) {
        if (!"java.lang.annotation.Retention".
              equals(
                annotationClass)) {
            return;
        }
        org.apache.bcel.classfile.EnumElementValue v =
          (org.apache.bcel.classfile.EnumElementValue)
            map.
            get(
              "value");
        if ("RUNTIME".
              equals(
                v.
                  getEnumValueString(
                    ))) {
            runtimeRetention =
              true;
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        runtimeRetention =
          false;
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        for (java.lang.String i
              :
              obj.
               getInterfaceNames(
                 )) {
            if ("java.lang.annotation.Annotation".
                  equals(
                    i)) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getAnnotationRetentionDatabase(
                    ).
                  setRuntimeRetention(
                    getDottedClassName(
                      ),
                    runtimeRetention);
            }
        }
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        if (!edu.umd.cs.findbugs.bcel.BCELUtil.
              preTiger(
                javaClass)) {
            javaClass.
              accept(
                this);
        }
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Xulby38BFWtT3skiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cn0vVHqyzzqf4sC/+g5z4J3gGR5yYPid");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kZKLgh9Z2oc2h2WO5Tr/4T6M+t2i+S0QK5aMOg16jl//7jvMryfBwx/yi//2" +
       "8Os0nX94n7E/KprfTypXozLOPEf4l76NhGdJ5fX3KCgrqmOevKukdV+GqXzm" +
       "lRsPvf6V+e+WNVXHpZIPM5WH9NRxThcpnHq/GkSabpUUPrwvWQjKf3+aVJ66" +
       "d8EbYMP+pUT+q3uQ/wJczQUgCdj/8PX07P8K9O5kdlK5rJwZ/kZSuXY4nFSu" +
       "gPb04F+ALjBYvP7P4EjSaxehWwpsaRhPVe4IRSeI+C+dcUQnh3nrr0szH4Oc" +
       "Lto6H0aN0n1Z8h3ls68Mx+/7eusn90VjAJs8L1YBccq1ff3acWD/7D1XO1rr" +
       "av+Fbz72cw8/f/QR8tge4RPZP4Xbmy6u0CLdIClrqvJffP2/eOdPvfKlMrP/" +
       "fwGBZpAtLS4AAA==");
}
