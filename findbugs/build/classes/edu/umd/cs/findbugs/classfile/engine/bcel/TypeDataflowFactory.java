package edu.umd.cs.findbugs.classfile.engine.bcel;
public class TypeDataflowFactory extends edu.umd.cs.findbugs.classfile.engine.bcel.AnalysisFactory<edu.umd.cs.findbugs.ba.type.TypeDataflow> {
    public TypeDataflowFactory() { super("type analysis", edu.umd.cs.findbugs.ba.type.TypeDataflow.class);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.type.TypeDataflow analyze(edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache,
                                                            edu.umd.cs.findbugs.classfile.MethodDescriptor descriptor)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        org.apache.bcel.generic.MethodGen methodGen =
          getMethodGen(
            analysisCache,
            descriptor);
        if (methodGen ==
              null) {
            throw new edu.umd.cs.findbugs.ba.MethodUnprofitableException(
              descriptor);
        }
        edu.umd.cs.findbugs.ba.CFG cfg =
          getCFG(
            analysisCache,
            descriptor);
        edu.umd.cs.findbugs.ba.DepthFirstSearch dfs =
          getDepthFirstSearch(
            analysisCache,
            descriptor);
        edu.umd.cs.findbugs.ba.type.ExceptionSetFactory exceptionSetFactory =
          getExceptionSetFactory(
            analysisCache,
            descriptor);
        org.apache.bcel.classfile.Method method =
          getMethod(
            analysisCache,
            descriptor);
        edu.umd.cs.findbugs.ba.type.TypeAnalysis typeAnalysis =
          new edu.umd.cs.findbugs.ba.type.TypeAnalysis(
          method,
          methodGen,
          cfg,
          dfs,
          edu.umd.cs.findbugs.ba.AnalysisContext.
            currentAnalysisContext(
              ).
            getLookupFailureCallback(
              ),
          exceptionSetFactory);
        if (edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getBoolProperty(
                edu.umd.cs.findbugs.ba.AnalysisFeatures.
                  MODEL_INSTANCEOF)) {
            typeAnalysis.
              setValueNumberDataflow(
                getValueNumberDataflow(
                  analysisCache,
                  descriptor));
        }
        typeAnalysis.
          setFieldStoreTypeDatabase(
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getFieldStoreTypeDatabase(
                ));
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
          new edu.umd.cs.findbugs.ba.type.TypeDataflow(
          cfg,
          typeAnalysis);
        try {
            typeDataflow.
              execute(
                );
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error performing type dataflow analysis of " +
                descriptor,
                e);
            throw e;
        }
        if (edu.umd.cs.findbugs.ba.type.TypeAnalysis.
              DEBUG ||
              edu.umd.cs.findbugs.ba.ClassContext.
                DUMP_DATAFLOW_ANALYSIS) {
            edu.umd.cs.findbugs.ba.ClassContext.
              dumpTypeDataflow(
                method,
                cfg,
                typeDataflow);
        }
        return typeDataflow;
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
      ("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" +
       "jtSqTqnpIDaD2GRquDSpYZM+PkG0YRiFFCoRJRubR84kGYpJLBLDuMcKyzHT" +
       "huWeGGJyTi40pwUmjswW54hRvsFy8+Kcxtr+ul8cxzWqItS6oYBjcLmlD1Qt" +
       "dupLohgJbn0miyzVLTh8rRBSE90LtV4FRsuzXOxIS1nptmWuE/RaPlFeR1Yj" +
       "79RHHb7QD8ER019h+LA/52aU0FklfL1oddqDUYtcLfo6LHXitegnWoIMklwH" +
       "n82owKxL8tTFEy2SG1h3JnUTLOILNEmHqGiGVZn1im17lrSmkhsP6zgm65oq" +
       "aqhqV+lkXufwNY54lNkJ++GyaTRQUbQluCeuMSRR0GahMGl0KzpWKi7G6Ghc" +
       "L2Iq7Jh2lVUX6GQoghw/wZAKSlo+NVspkRULONxYwt1GfmLWhhw6jeNKuV7O" +
       "KctoXtNJaj5xB/wq1+TwpFScs/OKHxYdFVYDxEKw0Gozemss2/68y/EkiNvu" +
       "LJREuSY6PXGMTVfJah3P/Ilqu2ZiVpeiq6/kERr4qkmJfLhWNBsYnCJjvemk" +
       "0/ccSqhiS7JSljqyuVALbU121k2lqop9t92b8PMR264S3Z4jhO3IgVHSU0Wz" +
       "XyaLrOo3IxjuRPCUWyu5LkHq/WWil01xMLN7vGIjrTBfD4SSnGcXfnep9lAf" +
       "w4rzKlxemUq16QxwAgniJcrl4SqzpGfWatJUgqovmWg+r+QMAmtXerqqM1q3" +
       "kjfQ9Qorj5jaujh2lsaa98SaOi72K41JOybyjJFzed8R6/bcagpBezktLJtL" +
       "Yl0OuYXeSKgaXaf58dgJwyYvSGNpjYpNZYQ3821DYpVquTakfA4WsFqeDjy/" +
       "uAI5GENTRWGu4JHRsEDKqdpC3KgW+Hlv1OLyXdrsOHY+19MJK/BCkMsUF+HQ" +
       "ZvtVtjnwDNnhXSRmV11MTySMqI9opRkMxguWmU04m2CkyPH8FjtdCx29J4d9" +
       "ashMvDBi8LE06btco4q40yI9QZA2r+cYolCLyQbjci11QpcNjyOQJj6ZdVFr" +
       "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" +
       "f/eZr2XFsf8GCq25ZsQnAAA=");
}
