package edu.umd.cs.findbugs.ba;
public class MethodBytecodeSet extends java.util.BitSet {
    @java.lang.Override
    public java.lang.String toString() { java.lang.StringBuilder buf = new java.lang.StringBuilder(
                                           "[");
                                         for (int i = nextSetBit(
                                                        0); i >= 0;
                                              i =
                                                nextSetBit(
                                                  i +
                                                    1)) { buf.append(
                                                                org.apache.bcel.Constants.
                                                                  OPCODE_NAMES[i]).
                                                            append(
                                                              ", ");
                                         }
                                         buf.setLength(
                                               buf.
                                                 length(
                                                   ) -
                                                 2);
                                         buf.append(
                                               "]");
                                         return buf.
                                           toString(
                                             ); }
    public MethodBytecodeSet() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sw2UoBMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "27YX5n3c9A9e93tv/a0Xv5H3kv4Xw3HPb48eAAA=");
}
