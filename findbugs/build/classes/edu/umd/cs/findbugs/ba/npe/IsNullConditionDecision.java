package edu.umd.cs.findbugs.ba.npe;
public class IsNullConditionDecision {
    @javax.annotation.CheckForNull
    private final edu.umd.cs.findbugs.ba.vna.ValueNumber value;
    @javax.annotation.CheckForNull
    private final edu.umd.cs.findbugs.ba.npe.IsNullValue ifcmpDecision;
    @javax.annotation.CheckForNull
    private final edu.umd.cs.findbugs.ba.npe.IsNullValue fallThroughDecision;
    public IsNullConditionDecision(@javax.annotation.CheckForNull
                                   edu.umd.cs.findbugs.ba.vna.ValueNumber value,
                                   @javax.annotation.CheckForNull
                                   edu.umd.cs.findbugs.ba.npe.IsNullValue ifcmpDecision,
                                   @javax.annotation.CheckForNull
                                   edu.umd.cs.findbugs.ba.npe.IsNullValue fallThroughDecision) {
        super(
          );
        this.
          value =
          value;
        assert !(ifcmpDecision ==
                   null &&
                   fallThroughDecision ==
                   null);
        this.
          ifcmpDecision =
          ifcmpDecision;
        this.
          fallThroughDecision =
          fallThroughDecision;
    }
    @java.lang.Override
    public int hashCode() { return edu.umd.cs.findbugs.util.Util.
                              nullSafeHashcode(
                                value) +
                              5 *
                              edu.umd.cs.findbugs.util.Util.
                              nullSafeHashcode(
                                ifcmpDecision) +
                              17 *
                              edu.umd.cs.findbugs.util.Util.
                              nullSafeHashcode(
                                fallThroughDecision); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.ba.npe.IsNullConditionDecision)) {
                                                    return false;
                                                }
                                                edu.umd.cs.findbugs.ba.npe.IsNullConditionDecision other =
                                                  (edu.umd.cs.findbugs.ba.npe.IsNullConditionDecision)
                                                    o;
                                                return edu.umd.cs.findbugs.util.Util.
                                                  nullSafeEquals(
                                                    value,
                                                    other.
                                                      value) &&
                                                  edu.umd.cs.findbugs.util.Util.
                                                  nullSafeEquals(
                                                    ifcmpDecision,
                                                    other.
                                                      ifcmpDecision) &&
                                                  edu.umd.cs.findbugs.util.Util.
                                                  nullSafeEquals(
                                                    fallThroughDecision,
                                                    other.
                                                      fallThroughDecision);
    }
    public edu.umd.cs.findbugs.ba.vna.ValueNumber getValue() {
        return value;
    }
    public boolean isRedundant() { return ifcmpDecision ==
                                     null ||
                                     fallThroughDecision ==
                                     null;
    }
    public boolean isEdgeFeasible(int edgeType) {
        edu.umd.cs.findbugs.ba.npe.IsNullValue decision =
          getDecision(
            edgeType);
        return decision !=
          null;
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.npe.IsNullValue getDecision(int edgeType) {
        switch (edgeType) {
            case edu.umd.cs.findbugs.ba.EdgeTypes.
                   IFCMP_EDGE:
                return ifcmpDecision;
            case edu.umd.cs.findbugs.ba.EdgeTypes.
                   FALL_THROUGH_EDGE:
                return fallThroughDecision;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Bad edge type: " +
                  edgeType);
        }
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.StringBuilder buf =
                                           new java.lang.StringBuilder(
                                           );
                                         buf.
                                           append(
                                             value !=
                                               null
                                               ? value.
                                               toString(
                                                 )
                                               : "NoValue,");
                                         buf.
                                           append(
                                             "ifcmp=");
                                         buf.
                                           append(
                                             ifcmpDecision !=
                                               null
                                               ? edu.umd.cs.findbugs.util.Strings.
                                               trimComma(
                                                 ifcmpDecision.
                                                   toString(
                                                     ))
                                               : "INFEASIBLE");
                                         buf.
                                           append(
                                             ",fallthru=");
                                         buf.
                                           append(
                                             fallThroughDecision !=
                                               null
                                               ? edu.umd.cs.findbugs.util.Strings.
                                               trimComma(
                                                 fallThroughDecision.
                                                   toString(
                                                     ))
                                               : "INFEASIBLE");
                                         return buf.
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "C1jdJB4mIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "enOhzCsAAA==");
}
