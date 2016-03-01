package edu.umd.cs.findbugs.ba;
@java.lang.Deprecated
public class NullnessAnnotationDatabase extends edu.umd.cs.findbugs.ba.AnnotationDatabase<edu.umd.cs.findbugs.ba.NullnessAnnotation> implements edu.umd.cs.findbugs.ba.INullnessAnnotationDatabase {
    public NullnessAnnotationDatabase() { super();
                                          setAddClassOnly(true);
                                          loadAuxiliaryAnnotations();
                                          setAddClassOnly(false); }
    @java.lang.Override
    public void loadAuxiliaryAnnotations() { edu.umd.cs.findbugs.ba.DefaultNullnessAnnotations.
                                               addDefaultNullnessAnnotations(
                                                 this); }
    @java.lang.Override
    public boolean parameterMustBeNonNull(edu.umd.cs.findbugs.ba.XMethod m,
                                          int param) { if (param ==
                                                             0) {
                                                           if ("equals".
                                                                 equals(
                                                                   m.
                                                                     getName(
                                                                       )) &&
                                                                 "(Ljava/lang/Object;)Z".
                                                                 equals(
                                                                   m.
                                                                     getSignature(
                                                                       )) &&
                                                                 !m.
                                                                 isStatic(
                                                                   )) {
                                                               return false;
                                                           }
                                                           else
                                                               if ("main".
                                                                     equals(
                                                                       m.
                                                                         getName(
                                                                           )) &&
                                                                     "([Ljava/lang/String;)V".
                                                                     equals(
                                                                       m.
                                                                         getSignature(
                                                                           )) &&
                                                                     m.
                                                                     isStatic(
                                                                       ) &&
                                                                     m.
                                                                     isPublic(
                                                                       )) {
                                                                   return true;
                                                               }
                                                               else
                                                                   if (edu.umd.cs.findbugs.ba.npe.TypeQualifierNullnessAnnotationDatabase.
                                                                         assertsFirstParameterIsNonnull(
                                                                           m)) {
                                                                       return true;
                                                                   }
                                                                   else
                                                                       if ("compareTo".
                                                                             equals(
                                                                               m.
                                                                                 getName(
                                                                                   )) &&
                                                                             m.
                                                                             getSignature(
                                                                               ).
                                                                             endsWith(
                                                                               ";)Z") &&
                                                                             !m.
                                                                             isStatic(
                                                                               )) {
                                                                           return true;
                                                                       }
                                                       }
                                                       if (!anyAnnotations(
                                                              edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                                                NONNULL)) {
                                                           return false;
                                                       }
                                                       edu.umd.cs.findbugs.ba.XMethodParameter xmp =
                                                         new edu.umd.cs.findbugs.ba.XMethodParameter(
                                                         m,
                                                         param);
                                                       edu.umd.cs.findbugs.ba.NullnessAnnotation resolvedAnnotation =
                                                         getResolvedAnnotation(
                                                           xmp,
                                                           true);
                                                       return resolvedAnnotation ==
                                                         edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                                           NONNULL;
    }
    @javax.annotation.CheckForNull
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.NullnessAnnotation getResolvedAnnotation(final java.lang.Object o,
                                                                           boolean getMinimal) {
        edu.umd.cs.findbugs.log.Profiler profiler =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getProfiler(
            );
        profiler.
          start(
            this.
              getClass(
                ));
        try {
            if (o instanceof edu.umd.cs.findbugs.ba.XMethodParameter) {
                edu.umd.cs.findbugs.ba.XMethodParameter mp =
                  (edu.umd.cs.findbugs.ba.XMethodParameter)
                    o;
                edu.umd.cs.findbugs.ba.XMethod m =
                  mp.
                  getMethod(
                    );
                int parameterNumber =
                  mp.
                  getParameterNumber(
                    );
                if (parameterNumber ==
                      0) {
                    if ("equals".
                          equals(
                            m.
                              getName(
                                )) &&
                          "(Ljava/lang/Object;)Z".
                          equals(
                            m.
                              getSignature(
                                )) &&
                          !m.
                          isStatic(
                            )) {
                        return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                 CHECK_FOR_NULL;
                    }
                    else
                        if ("main".
                              equals(
                                m.
                                  getName(
                                    )) &&
                              "([Ljava/lang/String;)V".
                              equals(
                                m.
                                  getSignature(
                                    )) &&
                              m.
                              isStatic(
                                ) &&
                              m.
                              isPublic(
                                )) {
                            return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                     NONNULL;
                        }
                        else
                            if (edu.umd.cs.findbugs.ba.npe.TypeQualifierNullnessAnnotationDatabase.
                                  assertsFirstParameterIsNonnull(
                                    m)) {
                                return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                         NONNULL;
                            }
                            else
                                if ("compareTo".
                                      equals(
                                        m.
                                          getName(
                                            )) &&
                                      m.
                                      getSignature(
                                        ).
                                      endsWith(
                                        ";)Z") &&
                                      !m.
                                      isStatic(
                                        )) {
                                    return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                             NONNULL;
                                }
                }
            }
            else
                if (o instanceof edu.umd.cs.findbugs.ba.XMethod) {
                    edu.umd.cs.findbugs.ba.XMethod m =
                      (edu.umd.cs.findbugs.ba.XMethod)
                        o;
                    java.lang.String name =
                      m.
                      getName(
                        );
                    java.lang.String signature =
                      m.
                      getSignature(
                        );
                    if (!m.
                          isStatic(
                            ) &&
                          ("clone".
                             equals(
                               name) &&
                             "()Ljava/lang/Object;".
                             equals(
                               signature) ||
                             "toString".
                             equals(
                               name) &&
                             "()Ljava/lang/String;".
                             equals(
                               signature) ||
                             m.
                             isPrivate(
                               ) &&
                             "readResolve".
                             equals(
                               name) &&
                             "()Ljava/lang/Object;".
                             equals(
                               signature))) {
                        edu.umd.cs.findbugs.ba.NullnessAnnotation result =
                          super.
                          getDirectAnnotation(
                            m);
                        if (result !=
                              null) {
                            return result;
                        }
                        return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                 NONNULL;
                    }
                }
                else
                    if (o instanceof edu.umd.cs.findbugs.ba.XField) {
                        edu.umd.cs.findbugs.ba.XField f =
                          (edu.umd.cs.findbugs.ba.XField)
                            o;
                        if (f.
                              getName(
                                ).
                              startsWith(
                                "this$")) {
                            return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                     NONNULL;
                        }
                    }
            edu.umd.cs.findbugs.ba.NullnessAnnotation result =
              super.
              getResolvedAnnotation(
                o,
                getMinimal);
            return result;
        }
        finally {
            profiler.
              end(
                this.
                  getClass(
                    ));
        }
    }
    @java.lang.Override
    public void addDefaultMethodAnnotation(java.lang.String name,
                                           edu.umd.cs.findbugs.ba.NullnessAnnotation annotation) {
        super.
          addDefaultMethodAnnotation(
            name,
            annotation);
    }
    @java.lang.Override
    public void addDefaultAnnotation(edu.umd.cs.findbugs.ba.AnnotationDatabase.Target target,
                                     java.lang.String c,
                                     edu.umd.cs.findbugs.ba.NullnessAnnotation n) {
        super.
          addDefaultAnnotation(
            target,
            c,
            n);
    }
    @java.lang.Override
    public void addFieldAnnotation(java.lang.String name,
                                   java.lang.String name2,
                                   java.lang.String sig,
                                   boolean isStatic,
                                   edu.umd.cs.findbugs.ba.NullnessAnnotation annotation) {
        super.
          addFieldAnnotation(
            name,
            name2,
            sig,
            isStatic,
            annotation);
    }
    @java.lang.Override
    public void addMethodAnnotation(java.lang.String name,
                                    java.lang.String name2,
                                    java.lang.String sig,
                                    boolean isStatic,
                                    edu.umd.cs.findbugs.ba.NullnessAnnotation annotation) {
        super.
          addMethodAnnotation(
            name,
            name2,
            sig,
            isStatic,
            annotation);
    }
    @java.lang.Override
    public void addMethodParameterAnnotation(java.lang.String name,
                                             java.lang.String name2,
                                             java.lang.String sig,
                                             boolean isStatic,
                                             int param,
                                             edu.umd.cs.findbugs.ba.NullnessAnnotation annotation) {
        super.
          addMethodParameterAnnotation(
            name,
            name2,
            sig,
            isStatic,
            param,
            annotation);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rv8CRhv0dqcnAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gEbdpGsIxj18Pdn7z0Lorn1vwEw51fzn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("IHw5bAYBEihPNv4FqAKN+eu3vFuH+1wkB+GJRNGfNV764n/4k6sf2F2on04P" +
       "KCKrQ9KzdF/63Uvlu8NrHyk+E27L1yAf/Q4KuhzkPUPoifPzjgteu7v/u4/V" +
       "v0itvAc8yKH6F79D6H2vW7rj+SmVb/gY6WtFVDfSAYILV07lRNx8La8rffs6" +
       "97kvvVArUh6uxkZghJo6PczoPp01ts+kfPZUlvdNV/u68tXP/uznn/wj/sEi" +
       "fXe3sLkcWOoV8tQObfdCYbsXoV025rvOmfDhjIokt+vKT3zyW1/82nNf/sIl" +
       "6Ar4vMuNUvI18PkXQgfnZb2fZHBtCt46gAp8KN67ozacZaGfh3r4wHHtcSpl" +
       "CP3gebyL/JczGZd53rjlJprfdiNHzdk+duarNPK8k62FRt9zrNFP5Nj82FmN" +
       "ztf1ttyhX7ic/qQPvfs7QOtY2EM+0AOFsZ7IM8ozX042Ap1+EKdaHHd9KoyI" +
       "63xr0m+1KaLQKQ803rvXt5y0mPK3T5vie8Hz1kOWb92ZovIGmEk+fJ7qlX8G" +
       "HFrj92OYY4N892sa5AnSHL+35ZQX7jjXAPLWNx1D+c68uXMWyrzPWwsdeDTX" +
       "mQsPFYzzhblA7NYir3ikaHvbdzBo3vh4UZzKXQS7Zl55300qwY5/pvLCqT/3" +
       "m/gDr3ku8dBeDzsa2DaVPHHvNTf345FOJvGe9UN0tPsflevKZ18aMO9/tfaL" +
       "uyRiYNnb7aGh377LZy6Y5qdRT57L7YjXFfLpb977K3e+6+jk7N6dnPvw6sTc" +
       "Hr95xi5he2GRY7v952/5pz/091/6cpG29/8B3jU6Zzo0AAA=");
}
