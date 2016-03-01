package edu.umd.cs.findbugs.detect;
public class NoteJCIPAnnotation extends edu.umd.cs.findbugs.visitclass.AnnotationVisitor implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.NonReportingDetector {
    private static final java.lang.String NET_JCIP_ANNOTATIONS = "net.jcip.annotations.";
    private static final java.lang.String JSR305_CONCURRENT_ANNOTATIONS =
      "javax.annotation.concurrent.";
    public NoteJCIPAnnotation(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
    }
    @java.lang.Override
    public void visitAnnotation(java.lang.String annotationClass, java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                boolean runtimeVisible) { if (annotationClass.
                                                                startsWith(
                                                                  NET_JCIP_ANNOTATIONS)) {
                                                              annotationClass =
                                                                annotationClass.
                                                                  substring(
                                                                    NET_JCIP_ANNOTATIONS.
                                                                      length(
                                                                        ));
                                                          }
                                                          else
                                                              if (annotationClass.
                                                                    startsWith(
                                                                      JSR305_CONCURRENT_ANNOTATIONS)) {
                                                                  annotationClass =
                                                                    annotationClass.
                                                                      substring(
                                                                        JSR305_CONCURRENT_ANNOTATIONS.
                                                                          length(
                                                                            ));
                                                              }
                                                              else {
                                                                  return;
                                                              }
                                                          edu.umd.cs.findbugs.ba.JCIPAnnotationDatabase annotationDatabase =
                                                            edu.umd.cs.findbugs.ba.AnalysisContext.
                                                            currentAnalysisContext(
                                                              ).
                                                            getJCIPAnnotationDatabase(
                                                              );
                                                          org.apache.bcel.classfile.ElementValue value =
                                                            map.
                                                            get(
                                                              "value");
                                                          edu.umd.cs.findbugs.ba.ClassMember member;
                                                          if (visitingField(
                                                                )) {
                                                              member =
                                                                edu.umd.cs.findbugs.ba.XFactory.
                                                                  createXField(
                                                                    this);
                                                          }
                                                          else
                                                              if (visitingMethod(
                                                                    )) {
                                                                  member =
                                                                    edu.umd.cs.findbugs.ba.XFactory.
                                                                      createXMethod(
                                                                        this);
                                                              }
                                                              else {
                                                                  annotationDatabase.
                                                                    addEntryForClass(
                                                                      getDottedClassName(
                                                                        ),
                                                                      annotationClass,
                                                                      value);
                                                                  return;
                                                              }
                                                          annotationDatabase.
                                                            addEntryForClassMember(
                                                              member,
                                                              annotationClass,
                                                              value);
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
       "8EGDH+uDwUEW28/5KzQh8h8wkPf0CyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HR++6DPfB57+8fb0vz8+81IV/+13C3i6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dohlx3fxKjy/+jpy/ddl889BuK/keh60HPj8mRT/xT2lWHZ/4f9ZXk+BZ3ws" +
       "r/H3R17n+fzy64z9x7L5YlK7HlWpwiXGv/R9ZDwHunbn/afyMsdTd1y5PFwT" +
       "ND776s0H3vLq9HeqK0CnV/ke5GoP2Knnna+pn3u/HkaW7VTMPXiosIfVv99J" +
       "ak/f+2oWkMDhpaL7tw8gvwfcyl1AErD+8ev52b+f1B46m53UrhoXhr8OLP54" +
       "OKldA+35wf8CusBg+foH4YmSN+5GbqWrlWs6d9FEKTtBdnflTqdT7eMT36lo" +
       "eApy/o7R5ZA5Sg/XZm8bn3t1wP/wt9BfPNxxAtQUxXFMunG4bnWaxL1wT2wn" +
       "uK73X/z2o59/8B0nCeejB4LP1P4cbW+9+4UiahMm1RWg4p+95Z+87x+8+tWq" +
       "JP1/ASqP4HnNLAAA");
}
