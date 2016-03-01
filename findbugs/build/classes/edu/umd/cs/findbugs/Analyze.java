package edu.umd.cs.findbugs;
public class Analyze {
    private static org.apache.bcel.classfile.JavaClass serializable;
    private static org.apache.bcel.classfile.JavaClass collection;
    private static org.apache.bcel.classfile.JavaClass comparator;
    private static org.apache.bcel.classfile.JavaClass map;
    private static org.apache.bcel.classfile.JavaClass remote;
    private static java.lang.ClassNotFoundException storedException;
    static { try { serializable = edu.umd.cs.findbugs.ba.AnalysisContext.
                                    lookupSystemClass(
                                      "java.io.Serializable");
                   collection = edu.umd.cs.findbugs.ba.AnalysisContext.lookupSystemClass(
                                                                         "java.util.Collection");
                   map = edu.umd.cs.findbugs.ba.AnalysisContext.lookupSystemClass(
                                                                  "java.util.Map");
                   comparator = edu.umd.cs.findbugs.ba.AnalysisContext.
                                  lookupSystemClass(
                                    "java.util.Comparator");
             }
             catch (java.lang.ClassNotFoundException e) {
                 storedException =
                   e;
             }
             try { remote = edu.umd.cs.findbugs.ba.AnalysisContext.
                              lookupSystemClass(
                                "java.rmi.Remote"); }
             catch (java.lang.ClassNotFoundException e) {
                 if (storedException ==
                       null) {
                     storedException =
                       e;
                 }
             } }
    public static double isDeepSerializable(java.lang.String refSig)
          throws java.lang.ClassNotFoundException { if (storedException !=
                                                          null) {
                                                        throw storedException;
                                                    }
                                                    if (isPrimitiveComponentClass(
                                                          refSig)) {
                                                        return 1.0;
                                                    }
                                                    java.lang.String refName =
                                                      getComponentClass(
                                                        refSig);
                                                    if ("java.lang.Object".
                                                          equals(
                                                            refName)) {
                                                        return 0.99;
                                                    }
                                                    org.apache.bcel.classfile.JavaClass refJavaClass =
                                                      org.apache.bcel.Repository.
                                                      lookupClass(
                                                        refName);
                                                    return isDeepSerializable(
                                                             refJavaClass);
    }
    public static double isDeepRemote(java.lang.String refSig) {
        if (remote ==
              null) {
            return 0.1;
        }
        java.lang.String refName =
          getComponentClass(
            refSig);
        if ("java.lang.Object".
              equals(
                refName)) {
            return 0.99;
        }
        org.apache.bcel.classfile.JavaClass refJavaClass;
        try {
            refJavaClass =
              org.apache.bcel.Repository.
                lookupClass(
                  refName);
            return deepInstanceOf(
                     refJavaClass,
                     remote);
        }
        catch (java.lang.ClassNotFoundException e) {
            return 0.99;
        }
    }
    private static boolean isPrimitiveComponentClass(java.lang.String refSig) {
        int c =
          0;
        while (c <
                 refSig.
                 length(
                   ) &&
                 refSig.
                 charAt(
                   c) ==
                 '[') {
            c++;
        }
        return c >=
          refSig.
          length(
            ) ||
          refSig.
          charAt(
            c) !=
          'L';
    }
    public static java.lang.String getComponentClass(java.lang.String refSig) {
        while (refSig.
                 charAt(
                   0) ==
                 '[') {
            refSig =
              refSig.
                substring(
                  1);
        }
        if (refSig.
              charAt(
                0) ==
              'L') {
            return refSig.
              substring(
                1,
                refSig.
                  length(
                    ) -
                  1).
              replace(
                '/',
                '.');
        }
        return refSig;
    }
    public static double isDeepSerializable(org.apache.bcel.classfile.JavaClass x)
          throws java.lang.ClassNotFoundException {
        if (storedException !=
              null) {
            throw storedException;
        }
        double result =
          deepInstanceOf(
            x,
            serializable);
        if (result >=
              0.9) {
            return result;
        }
        result =
          java.lang.Math.
            max(
              result,
              deepInstanceOf(
                x,
                collection));
        if (result >=
              0.9) {
            return result;
        }
        result =
          java.lang.Math.
            max(
              result,
              deepInstanceOf(
                x,
                map));
        if (result >=
              0.9) {
            return result;
        }
        result =
          java.lang.Math.
            max(
              result,
              0.5 *
                deepInstanceOf(
                  x,
                  comparator));
        if (result >=
              0.9) {
            return result;
        }
        return result;
    }
    public static double deepInstanceOf(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                        java.lang.String x,
                                        @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                        java.lang.String y)
          throws java.lang.ClassNotFoundException {
        return deepInstanceOf(
                 edu.umd.cs.findbugs.ba.AnalysisContext.
                   currentAnalysisContext(
                     ).
                   lookupClass(
                     x),
                 edu.umd.cs.findbugs.ba.AnalysisContext.
                   currentAnalysisContext(
                     ).
                   lookupClass(
                     y));
    }
    public static double deepInstanceOf(org.apache.bcel.classfile.JavaClass x,
                                        org.apache.bcel.classfile.JavaClass y)
          throws java.lang.ClassNotFoundException {
        if (x.
              equals(
                y)) {
            return 1.0;
        }
        if ("java.lang.Object".
              equals(
                y.
                  getClassName(
                    ))) {
            return 1.0;
        }
        edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getSubtypes2(
            );
        edu.umd.cs.findbugs.classfile.ClassDescriptor xDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptor(
            x);
        edu.umd.cs.findbugs.classfile.ClassDescriptor yDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptor(
            y);
        boolean xIsSubtypeOfY =
          org.apache.bcel.Repository.
          instanceOf(
            x,
            y);
        if (xIsSubtypeOfY) {
            return 1.0;
        }
        boolean yIsSubtypeOfX =
          org.apache.bcel.Repository.
          instanceOf(
            y,
            x);
        if (!yIsSubtypeOfX) {
            if (x.
                  isFinal(
                    ) ||
                  y.
                  isFinal(
                    )) {
                return 0.0;
            }
            if (!x.
                  isInterface(
                    ) &&
                  !y.
                  isInterface(
                    )) {
                return 0.0;
            }
        }
        java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> transitiveCommonSubtypes =
          subtypes2.
          getTransitiveCommonSubtypes(
            xDesc,
            yDesc);
        if (transitiveCommonSubtypes.
              isEmpty(
                )) {
            for (edu.umd.cs.findbugs.classfile.ClassDescriptor c
                  :
                  subtypes2.
                   getSubtypes(
                     xDesc)) {
                edu.umd.cs.findbugs.ba.XClass cx;
                try {
                    cx =
                      edu.umd.cs.findbugs.classfile.Global.
                        getAnalysisCache(
                          ).
                        getClassAnalysis(
                          edu.umd.cs.findbugs.ba.XClass.class,
                          c);
                }
                catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                    continue;
                }
                if (!cx.
                      isAbstract(
                        ) &&
                      !cx.
                      isInterface(
                        )) {
                    if (x.
                          isAbstract(
                            ) ||
                          x.
                          isInterface(
                            )) {
                        return 0.2;
                    }
                    return 0.1;
                }
            }
            return 0.3;
        }
        java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> xButNotY =
          new java.util.HashSet<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
          subtypes2.
            getSubtypes(
              xDesc));
        xButNotY.
          removeAll(
            transitiveCommonSubtypes);
        for (edu.umd.cs.findbugs.classfile.ClassDescriptor c
              :
              xButNotY) {
            try {
                edu.umd.cs.findbugs.ba.XClass cx =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    c);
                if (!cx.
                      isAbstract(
                        ) &&
                      !cx.
                      isInterface(
                        )) {
                    return 0.7;
                }
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                continue;
            }
        }
        return 0.99;
    }
    public Analyze() { super(); }
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
