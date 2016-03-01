package edu.umd.cs.findbugs.ba;
public class CFGBuilderFactory {
    public static edu.umd.cs.findbugs.ba.CFGBuilder create(@javax.annotation.Nonnull
                                                           edu.umd.cs.findbugs.classfile.MethodDescriptor descriptor,
                                                           @javax.annotation.Nonnull
                                                           org.apache.bcel.generic.MethodGen methodGen) {
        return new edu.umd.cs.findbugs.ba.BetterCFGBuilder2(
          descriptor,
          methodGen);
    }
    public CFGBuilderFactory() { super(); }
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
       "AA==");
}
