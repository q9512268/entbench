package edu.umd.cs.findbugs.classfile.engine.bcel;
public class ObligationDataflowFactory extends edu.umd.cs.findbugs.classfile.engine.bcel.AnalysisFactory<edu.umd.cs.findbugs.ba.obl.ObligationDataflow> {
    private static final boolean DEBUG_PRINTCFG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "oa.printcfg");
    public ObligationDataflowFactory() { super("Obligation dataflow",
                                               edu.umd.cs.findbugs.ba.obl.ObligationDataflow.class);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.obl.ObligationDataflow analyze(edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache,
                                                                 edu.umd.cs.findbugs.classfile.MethodDescriptor methodDescriptor)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        edu.umd.cs.findbugs.ba.CFG cfg =
          analysisCache.
          getMethodAnalysis(
            edu.umd.cs.findbugs.ba.CFG.class,
            methodDescriptor);
        edu.umd.cs.findbugs.ba.DepthFirstSearch dfs =
          analysisCache.
          getMethodAnalysis(
            edu.umd.cs.findbugs.ba.DepthFirstSearch.class,
            methodDescriptor);
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            methodDescriptor);
        org.apache.bcel.generic.ConstantPoolGen cpg =
          analysisCache.
          getClassAnalysis(
            org.apache.bcel.generic.ConstantPoolGen.class,
            methodDescriptor.
              getClassDescriptor(
                ));
        edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase database =
          analysisCache.
          getDatabase(
            edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase.class);
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
          analysisCache.
          getMethodAnalysis(
            edu.umd.cs.findbugs.ba.type.TypeDataflow.class,
            methodDescriptor);
        edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow invDataflow =
          analysisCache.
          getMethodAnalysis(
            edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow.class,
            methodDescriptor);
        edu.umd.cs.findbugs.ba.obl.ObligationFactory factory =
          database.
          getFactory(
            );
        edu.umd.cs.findbugs.ba.obl.ObligationAnalysis analysis =
          new edu.umd.cs.findbugs.ba.obl.ObligationAnalysis(
          dfs,
          xmethod,
          cpg,
          factory,
          database,
          typeDataflow,
          invDataflow,
          analysisCache.
            getErrorLogger(
              ));
        edu.umd.cs.findbugs.ba.obl.ObligationDataflow dataflow =
          new edu.umd.cs.findbugs.ba.obl.ObligationDataflow(
          cfg,
          analysis);
        edu.umd.cs.findbugs.log.Profiler profiler =
          analysisCache.
          getProfiler(
            );
        profiler.
          start(
            analysis.
              getClass(
                ));
        try {
            dataflow.
              execute(
                );
        }
        finally {
            profiler.
              end(
                analysis.
                  getClass(
                    ));
        }
        if (DEBUG_PRINTCFG) {
            java.lang.System.
              out.
              println(
                "Dataflow CFG:");
            edu.umd.cs.findbugs.ba.DataflowCFGPrinter.
              printCFG(
                dataflow,
                java.lang.System.
                  out);
        }
        return dataflow;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "podv09nJEcsHIm1fYV3avPofQik2uK4eAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vQC+2IllsXuf4NzTC65VXnCY+yvHBUfVgKPTnbkPv/n53xD3NXcfO3FP01fm" +
       "KdHxmxMd1CbNWI+cMAmiSo6PX5Hj2slEnrDE3pxlb2XqG9M4lYbKdTMsZ7Bi" +
       "/VfKYp9AN7SyuzgT8yP34rnUjoPlvQ4zz6OguBwFj51FwZm0t893FyeZGUWO" +
       "Yb5J4NzjuCKB3nPf49TybOjdb7gDcri3oP/yq7cefter0r+rThTP7hY8wkIP" +
       "W6nrXtzKv1C/Hkam5VS2euSwsR9WPz+fQC++5fPfBHqw/Kl0+bkD/ecS6M5b" +
       "oU+g64fKReLPJ9Azb0oMYv+sfpHwbyXQU/cgTIAJTqoXR7+aQDfPRyfQkX6p" +
       "+28DtznpTqAHQHmx84ugCXSW1S+Fbw45YrqMkwt3QH7GefU3/9Uf3frEYSf/" +
       "8rlEdQ3ohPQq3Td+5wHk0eTOz1ZQ9eBSi6s5fJiFHorLkQn03P2vFFW8DocO" +
       "j57hSOWEi6sInUDh/817C6dxeuWuxP/zZ+anAdt969ccrvApGXz50uHNvef+" +
       "rj707opf/cansOps5lbmxE5iGrOTy12Xj4LPr0e8dOnC1z29467+7a/8zNee" +
       "/335qeomz8ERSrGaeVjph52gzrUKdY5O1scX7iPwiUTVyfVd/Se+8Ce/+Xsv" +
       "f/PrD0DXwZJU4okWmWDJAiB/vwtwFxncmYEaCajA4vb4gdrx7cqfT/z29lnr" +
       "2f0IgMz3410d1F25RlFeIQPoaEYESFqNku2zV1bSNAwv9lYR8NhZBHywtM3x" +
       "vXKUv1+tpK/lH4+gD78Fa50pe5r43K6C+8J5VHlEd7ET+PxTPRYXxbuzxZS6" +
       "K+PCECdYqvKp8gTz4VNnu8dB2eFMt9Ll05fOt8Hyce1yWnW2ct3+s06WLmRi" +
       "H7iv143Tw+XEu/pXXh1xP/5d7EuHeyBgHoviZFpvHK6knOVLz9+X2ymv64MX" +
       "v/f4rzzywmlu9/hB4PMs5oJs77v3pQvKC5PqmkTxj9/1D3/g77z6zeow738D" +
       "3gMCFjMqAAA=");
}
