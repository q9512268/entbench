package edu.umd.cs.findbugs.ba.type;
public class StandardTypeMerger implements edu.umd.cs.findbugs.ba.type.TypeMerger, org.apache.bcel.Constants, edu.umd.cs.findbugs.ba.type.ExtendedTypes {
    private final edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback;
    private final edu.umd.cs.findbugs.ba.type.ExceptionSetFactory exceptionSetFactory;
    private static final org.apache.bcel.generic.ObjectType OBJECT_TYPE =
      edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.lang.Object");
    public StandardTypeMerger(edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback,
                              edu.umd.cs.findbugs.ba.type.ExceptionSetFactory exceptionSetFactory) {
        super(
          );
        this.
          lookupFailureCallback =
          lookupFailureCallback;
        this.
          exceptionSetFactory =
          exceptionSetFactory;
    }
    @java.lang.Override
    public org.apache.bcel.generic.Type mergeTypes(org.apache.bcel.generic.Type a,
                                                   org.apache.bcel.generic.Type b)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (a ==
              null) {
            return b;
        }
        if (b ==
              null) {
            return a;
        }
        byte aType =
          a.
          getType(
            );
        byte bType =
          b.
          getType(
            );
        if (aType ==
              T_TOP) {
            return b;
        }
        else
            if (bType ==
                  T_TOP) {
                return a;
            }
            else
                if (aType ==
                      T_BOTTOM ||
                      bType ==
                      T_BOTTOM) {
                    return edu.umd.cs.findbugs.ba.type.BottomType.
                      instance(
                        );
                }
                else
                    if (isReferenceType(
                          aType) &&
                          isReferenceType(
                            bType)) {
                        if (aType ==
                              T_NULL) {
                            return b;
                        }
                        else
                            if (bType ==
                                  T_NULL) {
                                return a;
                            }
                        org.apache.bcel.generic.ReferenceType aRef =
                          (org.apache.bcel.generic.ReferenceType)
                            a;
                        org.apache.bcel.generic.ReferenceType bRef =
                          (org.apache.bcel.generic.ReferenceType)
                            b;
                        return mergeReferenceTypes(
                                 aRef,
                                 bRef);
                    }
                    else
                        if (isReferenceType(
                              aType) ||
                              isReferenceType(
                                bType)) {
                            return edu.umd.cs.findbugs.ba.type.BottomType.
                              instance(
                                );
                        }
                        else
                            if (aType ==
                                  bType) {
                                return a;
                            }
                            else
                                if (isIntegerType(
                                      aType) &&
                                      isIntegerType(
                                        bType)) {
                                    return org.apache.bcel.generic.Type.
                                             INT;
                                }
                                else {
                                    return edu.umd.cs.findbugs.ba.type.BottomType.
                                      instance(
                                        );
                                }
    }
    protected boolean isReferenceType(byte type) {
        return type ==
          T_OBJECT ||
          type ==
          T_ARRAY ||
          type ==
          T_NULL ||
          type ==
          T_EXCEPTION;
    }
    protected boolean isObjectType(byte type) {
        return type ==
          T_OBJECT ||
          type ==
          T_EXCEPTION;
    }
    protected boolean isIntegerType(byte type) {
        return type ==
          T_INT ||
          type ==
          T_BYTE ||
          type ==
          T_BOOLEAN ||
          type ==
          T_CHAR ||
          type ==
          T_SHORT;
    }
    private static void updateExceptionSet(edu.umd.cs.findbugs.ba.type.ExceptionSet exceptionSet,
                                           org.apache.bcel.generic.ObjectType type) {
        if (type instanceof edu.umd.cs.findbugs.ba.type.ExceptionObjectType) {
            exceptionSet.
              addAll(
                ((edu.umd.cs.findbugs.ba.type.ExceptionObjectType)
                   type).
                  getExceptionSet(
                    ));
        }
        else {
            exceptionSet.
              addExplicit(
                type);
        }
    }
    protected org.apache.bcel.generic.ReferenceType mergeReferenceTypes(org.apache.bcel.generic.ReferenceType aRef,
                                                                        org.apache.bcel.generic.ReferenceType bRef)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (aRef.
              equals(
                bRef)) {
            return aRef;
        }
        byte aType =
          aRef.
          getType(
            );
        byte bType =
          bRef.
          getType(
            );
        try {
            if (isObjectType(
                  aType) &&
                  isObjectType(
                    bType) &&
                  ((aType ==
                      T_EXCEPTION ||
                      isThrowable(
                        aRef)) &&
                     (bType ==
                        T_EXCEPTION ||
                        isThrowable(
                          bRef)))) {
                edu.umd.cs.findbugs.ba.type.ExceptionSet union =
                  exceptionSetFactory.
                  createExceptionSet(
                    );
                if (aType ==
                      T_OBJECT &&
                      "Ljava/lang/Throwable;".
                      equals(
                        aRef.
                          getSignature(
                            ))) {
                    return aRef;
                }
                if (bType ==
                      T_OBJECT &&
                      "Ljava/lang/Throwable;".
                      equals(
                        bRef.
                          getSignature(
                            ))) {
                    return bRef;
                }
                updateExceptionSet(
                  union,
                  (org.apache.bcel.generic.ObjectType)
                    aRef);
                updateExceptionSet(
                  union,
                  (org.apache.bcel.generic.ObjectType)
                    bRef);
                org.apache.bcel.generic.Type t =
                  edu.umd.cs.findbugs.ba.type.ExceptionObjectType.
                  fromExceptionSet(
                    union);
                if (t instanceof org.apache.bcel.generic.ReferenceType) {
                    return (org.apache.bcel.generic.ReferenceType)
                             t;
                }
            }
            if (aRef instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType &&
                  bRef instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType &&
                  aRef.
                  getSignature(
                    ).
                  equals(
                    bRef.
                      getSignature(
                        ))) {
                edu.umd.cs.findbugs.ba.generic.GenericObjectType aG =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    aRef;
                edu.umd.cs.findbugs.ba.generic.GenericObjectType bG =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    bRef;
                if (aG.
                      getTypeCategory(
                        ) ==
                      bG.
                      getTypeCategory(
                        )) {
                    switch (aG.
                              getTypeCategory(
                                )) {
                        case PARAMETERIZED:
                            java.util.List<? extends org.apache.bcel.generic.ReferenceType> aP =
                              aG.
                              getParameters(
                                );
                            java.util.List<? extends org.apache.bcel.generic.ReferenceType> bP =
                              bG.
                              getParameters(
                                );
                            assert aP !=
                              null;
                            assert bP !=
                              null;
                            if (aP.
                                  size(
                                    ) !=
                                  bP.
                                  size(
                                    )) {
                                break;
                            }
                            java.util.ArrayList<org.apache.bcel.generic.ReferenceType> result =
                              new java.util.ArrayList<org.apache.bcel.generic.ReferenceType>(
                              aP.
                                size(
                                  ));
                            for (int i =
                                   0;
                                 i <
                                   aP.
                                   size(
                                     );
                                 i++) {
                                result.
                                  add(
                                    mergeReferenceTypes(
                                      aP.
                                        get(
                                          i),
                                      bP.
                                        get(
                                          i)));
                            }
                            edu.umd.cs.findbugs.ba.generic.GenericObjectType rOT =
                              edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                              getType(
                                aG.
                                  getClassName(
                                    ),
                                result);
                            return rOT;
                    }
                }
            }
            if (aRef instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                aRef =
                  ((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                     aRef).
                    getObjectType(
                      );
            }
            if (bRef instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                bRef =
                  ((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                     bRef).
                    getObjectType(
                      );
            }
            if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                  ENABLE_SUBTYPES2_FOR_COMMON_SUPERCLASS_QUERIES) {
                return edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getSubtypes2(
                    ).
                  getFirstCommonSuperclass(
                    aRef,
                    bRef);
            }
            else {
                return aRef.
                  getFirstCommonSuperclass(
                    bRef);
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            lookupFailureCallback.
              reportMissingClass(
                e);
            return org.apache.bcel.generic.Type.
                     OBJECT;
        }
    }
    private boolean isThrowable(org.apache.bcel.generic.ReferenceType ref) {
        try {
            edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                );
            return subtypes2.
              isSubtype(
                ref,
                org.apache.bcel.generic.Type.
                  THROWABLE);
        }
        catch (java.lang.ClassNotFoundException e) {
            lookupFailureCallback.
              reportMissingClass(
                e);
            return false;
        }
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
       "oftAfbbzKmgCncXnw/5tLnL3oTy9dCbB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("O7Kvcsoef6MpO0E5+/CpSArLx7zHCVyyf857U/3ia9T4R77d+On9wyvVlvO8" +
       "oPIgA13ZvwE7SQKfvyO1Y1qXyZe+8+iXHnrxOGF9dM/wqa2f4e25279ywh0/" +
       "Lt8l5f/s7T///T/z2u+X98r/B2GgvEdlLQAA");
}
