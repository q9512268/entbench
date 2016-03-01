package edu.umd.cs.findbugs.classfile.engine.bcel;
public class NonImplicitExceptionPostDominatorsAnalysis extends edu.umd.cs.findbugs.ba.PostDominatorsAnalysis {
    public NonImplicitExceptionPostDominatorsAnalysis(edu.umd.cs.findbugs.ba.CFG cfg,
                                                      edu.umd.cs.findbugs.ba.ReverseDepthFirstSearch rdfs,
                                                      edu.umd.cs.findbugs.ba.DepthFirstSearch dfs) {
        super(
          cfg,
          rdfs,
          dfs,
          new edu.umd.cs.findbugs.ba.EdgeChooser(
            ) {
              @java.lang.Override
              public boolean choose(edu.umd.cs.findbugs.ba.Edge edge) {
                  return !edge.
                    isExceptionEdge(
                      ) ||
                    edge.
                    isFlagSet(
                      edu.umd.cs.findbugs.ba.EdgeTypes.
                        EXPLICIT_EXCEPTIONS_FLAG);
              }
          });
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
      ("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");
}
