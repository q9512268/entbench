package edu.umd.cs.findbugs.util;
public class SubtypeTypeMatcher implements edu.umd.cs.findbugs.util.TypeMatcher {
    private final org.apache.bcel.generic.ReferenceType supertype;
    public SubtypeTypeMatcher(org.apache.bcel.generic.ReferenceType supertype) {
        super(
          );
        this.
          supertype =
          supertype;
    }
    public SubtypeTypeMatcher(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor) {
        this(
          edu.umd.cs.findbugs.bcel.BCELUtil.
            getObjectTypeInstance(
              classDescriptor.
                toDottedClassName(
                  )));
    }
    @java.lang.Override
    public boolean matches(org.apache.bcel.generic.Type t) { if (!(t instanceof org.apache.bcel.generic.ReferenceType)) {
                                                                 return false;
                                                             }
                                                             edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
                                                               edu.umd.cs.findbugs.classfile.Global.
                                                               getAnalysisCache(
                                                                 );
                                                             edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                                                               analysisCache.
                                                               getDatabase(
                                                                 edu.umd.cs.findbugs.ba.ch.Subtypes2.class);
                                                             try {
                                                                 return subtypes2.
                                                                   isSubtype(
                                                                     (org.apache.bcel.generic.ReferenceType)
                                                                       t,
                                                                     supertype);
                                                             }
                                                             catch (java.lang.ClassNotFoundException e) {
                                                                 analysisCache.
                                                                   getErrorLogger(
                                                                     ).
                                                                   reportMissingClass(
                                                                     e);
                                                                 return false;
                                                             }
    }
    @java.lang.Override
    public java.lang.String toString() { return "+" +
                                         supertype.
                                           toString(
                                             );
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
