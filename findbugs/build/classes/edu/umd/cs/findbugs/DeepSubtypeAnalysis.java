package edu.umd.cs.findbugs;
public class DeepSubtypeAnalysis {
    private static org.apache.bcel.classfile.JavaClass serializable;
    private static org.apache.bcel.classfile.JavaClass collection;
    private static org.apache.bcel.classfile.JavaClass comparator;
    private static org.apache.bcel.classfile.JavaClass map;
    private static org.apache.bcel.classfile.JavaClass remote;
    private static java.lang.ClassNotFoundException storedException;
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "dsa.debug");
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
    public static double isDeepSerializable(org.apache.bcel.generic.ReferenceType type)
          throws java.lang.ClassNotFoundException {
        if (type instanceof org.apache.bcel.generic.ArrayType) {
            org.apache.bcel.generic.ArrayType a =
              (org.apache.bcel.generic.ArrayType)
                type;
            org.apache.bcel.generic.Type t =
              a.
              getBasicType(
                );
            if (t instanceof org.apache.bcel.generic.ReferenceType) {
                type =
                  (org.apache.bcel.generic.ReferenceType)
                    t;
            }
            else {
                return 1.0;
            }
        }
        double result =
          isDeepSerializable(
            type.
              getSignature(
                ));
        if (type instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType &&
              edu.umd.cs.findbugs.ba.ch.Subtypes2.
              isContainer(
                type)) {
            edu.umd.cs.findbugs.ba.generic.GenericObjectType gt =
              (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                type;
            java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters =
              gt.
              getParameters(
                );
            if (parameters !=
                  null) {
                for (org.apache.bcel.generic.ReferenceType t
                      :
                      parameters) {
                    double r =
                      isDeepSerializable(
                        t);
                    if (result >
                          r) {
                        result =
                          r;
                    }
                }
            }
        }
        return result;
    }
    public static org.apache.bcel.generic.ReferenceType getLeastSerializableTypeComponent(org.apache.bcel.generic.ReferenceType type)
          throws java.lang.ClassNotFoundException {
        if (type instanceof org.apache.bcel.generic.ArrayType) {
            org.apache.bcel.generic.ArrayType a =
              (org.apache.bcel.generic.ArrayType)
                type;
            org.apache.bcel.generic.Type t =
              a.
              getBasicType(
                );
            if (t instanceof org.apache.bcel.generic.ReferenceType) {
                type =
                  (org.apache.bcel.generic.ReferenceType)
                    t;
            }
            else {
                return type;
            }
        }
        org.apache.bcel.generic.ReferenceType result =
          type;
        double value =
          isDeepSerializable(
            type.
              getSignature(
                ));
        if (type instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType &&
              edu.umd.cs.findbugs.ba.ch.Subtypes2.
              isContainer(
                type)) {
            edu.umd.cs.findbugs.ba.generic.GenericObjectType gt =
              (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                type;
            java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters =
              gt.
              getParameters(
                );
            if (parameters !=
                  null) {
                for (org.apache.bcel.generic.ReferenceType t
                      :
                      parameters) {
                    double r =
                      isDeepSerializable(
                        t);
                    if (value >
                          r) {
                        value =
                          r;
                        result =
                          getLeastSerializableTypeComponent(
                            t);
                    }
                }
            }
        }
        return result;
    }
    public static double isDeepSerializable(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                            java.lang.String refSig)
          throws java.lang.ClassNotFoundException {
        if (storedException !=
              null) {
            throw storedException;
        }
        if (isPrimitiveComponentClass(
              refSig)) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "regSig \"" +
                    refSig +
                    "\" is primitive component class");
            }
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
    public static double isDeepRemote(org.apache.bcel.generic.ReferenceType refType) {
        return isDeepRemote(
                 refType.
                   getSignature(
                     ));
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
            return edu.umd.cs.findbugs.Analyze.
              deepInstanceOf(
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
    public static java.lang.String getComponentClass(org.apache.bcel.generic.ReferenceType refType) {
        return getComponentClass(
                 refType.
                   getSignature(
                     ));
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
        if ("java.lang.Object".
              equals(
                x.
                  getClassName(
                    ))) {
            return 0.4;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "checking " +
                x.
                  getClassName(
                    ));
        }
        double result =
          edu.umd.cs.findbugs.Analyze.
          deepInstanceOf(
            x,
            serializable);
        if (result >=
              0.9) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Direct high serializable result: " +
                    result);
            }
            return result;
        }
        if (x.
              isFinal(
                )) {
            return result;
        }
        double collectionResult =
          edu.umd.cs.findbugs.Analyze.
          deepInstanceOf(
            x,
            collection);
        double mapResult =
          edu.umd.cs.findbugs.Analyze.
          deepInstanceOf(
            x,
            map);
        if (x.
              isInterface(
                ) ||
              x.
              isAbstract(
                )) {
            result =
              java.lang.Math.
                max(
                  result,
                  java.lang.Math.
                    max(
                      mapResult,
                      collectionResult) *
                    0.95);
            if (result >=
                  0.9) {
                return result;
            }
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptor(
            x);
        edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getSubtypes2(
            );
        java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> directSubtypes =
          subtypes2.
          getDirectSubtypes(
            classDescriptor);
        directSubtypes.
          remove(
            classDescriptor);
        double confidence =
          0.6;
        if (x.
              isAbstract(
                ) ||
              x.
              isInterface(
                )) {
            confidence =
              0.8;
            result =
              java.lang.Math.
                max(
                  result,
                  0.4);
        }
        else
            if (directSubtypes.
                  isEmpty(
                    )) {
                confidence =
                  0.2;
            }
        double confidence2 =
          (1 +
             confidence) /
          2;
        result =
          java.lang.Math.
            max(
              result,
              confidence2 *
                collectionResult);
        if (result >=
              0.9) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "High collection result: " +
                    result);
            }
            return result;
        }
        result =
          java.lang.Math.
            max(
              result,
              confidence2 *
                mapResult);
        if (result >=
              0.9) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "High map result: " +
                    result);
            }
            return result;
        }
        result =
          java.lang.Math.
            max(
              result,
              confidence2 *
                0.5 *
                edu.umd.cs.findbugs.Analyze.
                deepInstanceOf(
                  x,
                  comparator));
        if (result >=
              0.9) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "High comparator result: " +
                    result);
            }
            return result;
        }
        for (edu.umd.cs.findbugs.classfile.ClassDescriptor subtype
              :
              directSubtypes) {
            org.apache.bcel.classfile.JavaClass subJavaClass =
              org.apache.bcel.Repository.
              lookupClass(
                subtype.
                  getDottedClassName(
                    ));
            result =
              java.lang.Math.
                max(
                  result,
                  confidence *
                    edu.umd.cs.findbugs.Analyze.
                    deepInstanceOf(
                      subJavaClass,
                      serializable));
            if (result >=
                  0.9) {
                return result;
            }
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "No high results; max: " +
                result);
        }
        return result;
    }
    public static double deepInstanceOf(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                        java.lang.String x,
                                        @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                        java.lang.String y)
          throws java.lang.ClassNotFoundException {
        return edu.umd.cs.findbugs.Analyze.
          deepInstanceOf(
            x,
            y);
    }
    public static double deepInstanceOf(org.apache.bcel.classfile.JavaClass x,
                                        org.apache.bcel.classfile.JavaClass y)
          throws java.lang.ClassNotFoundException {
        return edu.umd.cs.findbugs.Analyze.
          deepInstanceOf(
            x,
            y);
    }
    public DeepSubtypeAnalysis() { super(
                                     ); }
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
      ("H4sIAAAAAAAAALV7e9Dj1nUfdiXtSmtZu5JsSVZkWbJWsSWmC5Ig+MjGqQmA" +
       "AEgCBAkSAIm2lvEiABLvBwHSVeM4o8ptZhxPKqfuxNE/dZo6leO000ySaZNR" +
       "J23jNJm26XjSd+zJdCZuE3fiSZtm4rbuBfi9d1errSTO3PsB93Hu+Z17zsG5" +
       "j++1b0H3xBFUCXxnazp+cs3Ik2srB72WbAMjvjZg0LESxYaOO0ocz0DZC9oH" +
       "f/7yn3zns9aV89AFGXpY8Tw/URLb92LeiH1nY+gMdPm4tOcYbpxAV5iVslHg" +
       "NLEdmLHj5DoDvetE1wS6yhyyAAMWYMACXLIAd49bgU7vNrzUxYseipfEIfRX" +
       "oHMMdCHQCvYS6OnTRAIlUtwDMuMSAaBwb/EuAlBl5zyCnjrCvsd8A+DPVeBX" +
       "/ubHrvyDu6DLMnTZ9qYFOxpgIgGDyND9ruGqRhR3dd3QZehBzzD0qRHZimPv" +
       "Sr5l6KHYNj0lSSPjSEhFYRoYUTnmseTu1wpsUaolfnQEb2kbjn74ds/SUUyA" +
       "9ZFjrHuEZFEOAF6yAWPRUtGMwy53r21PT6APnO1xhPHqEDQAXS+6RmL5R0Pd" +
       "7SmgAHpoP3eO4pnwNIlszwRN7/FTMEoCPX5LooWsA0VbK6bxQgI9drbdeF8F" +
       "Wt1XCqLokkDvPduspARm6fEzs3Rifr41+oHPfMKjvfMlz7qhOQX/94JOT57p" +
       "xBtLIzI8zdh3vP955ieUR37l0+chCDR+75nG+za/+Je//dHve/L1r+7bfM9N" +
       "2nDqytCSF7Qvqg/89hP4c527CjbuDfzYLib/FPJS/ccHNdfzAFjeI0cUi8pr" +
       "h5Wv8/988cmfNf7gPHSpD13QfCd1gR49qPluYDtGRBmeESmJofeh+wxPx8v6" +
       "PnQRPDO2Z+xLueUyNpI+dLdTFl3wy3cgoiUgUYjoIni2vaV/+BwoiVU+5wEE" +
       "QRdBgu4H6WFo/yv/JtDHYMt3DVjRFM/2fHgc+QX+GDa8RAWyteAlUCY1NWM4" +
       "jjS4VB1DT+HU1WEtPq4kDCOYpmohx66nONvYjq8VjYN3fIS8wHglO3cOiP+J" +
       "s8bvALuhfUc3ohe0V1Ks9+2fe+E3zx8Zw4F0EuhDYMBrYMBrWnztcMBrNxkQ" +
       "OneuHOc9xcD7KQYTtAamDpzg/c9N/9Lg45/+4F1At4LsbiDdoil8a1+MHzuH" +
       "fukCNaCh0Oufz35Y/KHqeej8aadaMAuKLhXdx4UrPHJ5V88a083oXn75m3/y" +
       "lZ940T82q1Ne+sDab+xZWOsHz4o18jUgscg4Jv/8U8ovvPArL149D90NXABw" +
       "e4kC1BR4lCfPjnHKaq8fesACyz0A8NKPXMUpqg7d1qXEivzsuKSc7wfK5weB" +
       "jJ+GDrJTel3UPhwU+Xv2+lFM2hkUpYf9yDT4qX/3L/8rUor70BlfPvF5mxrJ" +
       "9RMOoCB2uTT1B491YBYZBmj3nz8//huf+9bLf6FUANDimZsNeLXIcWD4YAqB" +
       "mF/6avjvv/67X/za+WOlScAXMFUdW8v3IL8LfudA+r9FKsAVBXvjfQg/8CBP" +
       "HbmQoBj5e495A87EAeZWaNBVwXN93V7aiuoYhcb+78vP1n7hDz9zZa8TDig5" +
       "VKnvuz2B4/L3YdAnf/Nj/+vJksw5rfiYHcvvuNneQz58TLkbRcq24CP/4X/z" +
       "/r/168pPAV8L/Fts74zSZUGlPKByAqulLCplDp+pqxfZB+KThnDa1k4EHS9o" +
       "n/3aH71b/KNf/XbJ7emo5eS8s0pwfa9qRfZUDsg/etbqaSW2QLvG66O/eMV5" +
       "/TuAogwoauBTHXMR8Dn5KS05aH3Pxf/wT37tkY//9l3QeRK65PiKTiqlwUH3" +
       "AU03Ygu4qzz48x/da3N2L8iulFChG8DvFeSx8u0SYPC5W/sasgg6js31sT/j" +
       "HPVTv/enNwih9DI3+dae6S/Dr33hcfwH/6Dsf2zuRe8n8xv9MAjQjvvWf9b9" +
       "n+c/eOGfnYcuytAV7SD6ExUnLYxIBhFPfBgSggjxVP3p6GX/qb5+5M6eOOtq" +
       "Tgx71tEc+3/wXLQuni+d8S2lK3kepPcc+Jb3nPUt56Dy4aNll6fL/GqRfaic" +
       "k/MJdDGI7A2wS2DUcRlolkM8l0D3x4dBJbClsuN7E+gZPzKvKSDMsoxrqmY4" +
       "18pIuPjAXxsA2GWUtHdnRY4UWXevBM1bKsz103A+DNIjB3AeuQWc4S3gFI9E" +
       "kfUOUVzSjsy7KKHOMMf8fzD32AFzj92COf5OmDt0szdjbnqHzBUfmccPmHv8" +
       "Fswt3jRzd7lKcDOu5Dvk6ipITxxw9cQtuPr4m+bqQmS4fmLcjDHlDhn7fpCe" +
       "PGDsyVswZr5pxi7HYBYNvZdrRnDkqIDFPFX618Id7NcQIz8h/dQ7bngGhfXm" +
       "UbyvKOVBeuoAxVO3QBHcHMVdxygS4HxsEEMeormH6GEC9cYeexzZLgg5Nger" +
       "G/jFh76+/sI3v7xfuZx1z2caG59+5a9/99pnXjl/Yr34zA1LtpN99mvGkr93" +
       "l0wWH7yn32iUsgf5+1958R/93Rdf3nP10OnVTw8s7r/8O//nt659/hu/cZOg" +
       "+6Lq+46hnJ2h8LYztOfvHAiU7qlfa12rFu+ffIM5+HA5B0WWHE7AoytHu3oY" +
       "PIlguQ805erKaR2q1ZVjtdqvkc8w+dybZhKI8YFjYowPlts/+l8++1s/9szX" +
       "gUgG0D2b4rsGZHdixFFa7ED81dc+9/53vfKNHy0jQxAWTp9T//ijBdW/dmdQ" +
       "Hy+gTv000gxGiRO2DOAM/Qjt5gSeXQLCQP8toE2ufIFuxP3u4Y8RlaWUaTkv" +
       "LbmtUW/sVjlfZ2iNZ+iZlfvjyGLMwRQX2liucoMsnlZb6TCaodEQGSFLQ6Y6" +
       "SF2u13ZNMqiIuGiOpoK5cXxTsWCs2wv6IinWhotk1LVrZh/rC2RokiJRW6My" +
       "NVCGZOI6DIJuwGqy3pDyykDtxS0kSNB2RekgrRxttRF27DWpHSFXq2tAze3N" +
       "qJVgIxNf7dFTYhAl62yG1SdkTdsMO2yFIuYpUptbaw/FB2t4aK1UXqPMMT8U" +
       "1+1FX5ouAsxihTUfdBxcyfMGxhFKOMaFfOrw9LSPuR1KqEt830lElBXwxYIc" +
       "C2qIsXJ1KPW2dTfeLSheJvDpQFu7YDXfcleWHZCOmGQ2udECEknFcMKmHCvP" +
       "sCnViVerrsOvq852hC/kCOeidUtShuvKWpZFUhnIZCc2VXVi1/PZQpowhM2z" +
       "dRqtNLTIECYM1hV4SdTGEjehQr/NB2wupGNBj+PqopP3N+vdcOFOUxu1+Y5j" +
       "pVXcZClfxLSO3xRxojMehqC6KYbt0dZj/VpvItoBizA8Nqr2JW5HGd1tt6EP" +
       "5XTDcQ2uHs2dhJlWGZHJPXU+226ceg3ZVlejKbfmnSElYBlvUd1s2zW70xU7" +
       "CK1U30750SroNrGp3LK5cNrvbVqtgZuOmtNqf9WdBas2jdcUhUrmqNtFJbZf" +
       "Md16czgbzXfNUGpMdBeWQ33dn9Sbo1XYlKyoviCqvoRL2IIOhl0m3aXtnTLc" +
       "OgM+UFtGha+pTNvAh1jEL5StMBPgGp6TZjeYqqjbZ/BV0MTwhRf0qWqyDqkh" +
       "wU1p1hTavNJrTzuTIKKq00FH746kXo0YNQTMJKsLBaamWq+dT+N6RZqPR7vA" +
       "hWe+nAqREC6sHuEOMNFx6HaqU1Gu8+F6qAQzqasDtfVr8Twl81DjLHONNczF" +
       "MhbmO3ha0TdzWd82PY+RfYeXVs0ekvpbjrHX2qwtonI9UptbgpX8GskTWewh" +
       "CovOAXi9GtBixrJVdOXYi+1sblBRJqMVuDK1Okx1GxprFw3ZwMXSrT9zJjvX" +
       "5mfwLAwFsmaORg6DOl2nrs1Vo7omN6y2tsSwBiuuMBHXG3c634XeUIQzpS/E" +
       "XbyvhLhedQah6iAzCV/BRD3qCf2wgdNiG8/MmgXDu7adNoe24oskRmL8QFBY" +
       "IvWjJlWjM67rdfXVVOm6o6FLrVdKatnOIOZmcsCzKMfavjpL++JU1Sy232/q" +
       "to2NqUGfn0iDJF8v+77fYPI1a5l0JVjCNBNTzTrgb9r0yLya7LTlUhlU+qm0" +
       "MEg7HpEWSvUXbLdP8OvJam3FmeDy3Z4Z5Rqv2tloIWTZLLEUgdtEchNM8jyp" +
       "VCvpsM8C36J62dzvp+vhrL0LtE2O7XyPzo1xrQ0rtY2KWPUZLpPTcc0EK8GJ" +
       "tphUQ9fLZu7AqCA1Ca13FW7Ss0R5LrCYH4SxrQzpmc9hptZ0hLxpc51FFus0" +
       "3bemueaNaNMkSWHpMSG8IVUrqmzH6x2OrOzupN2gyIaqYx2shbZq1RSBO2Rl" +
       "pGoVQica8DKtdWrjfs8DUrQXAjmuURSJ5Ey7zc7IkYLga5jyOpG+q3NGN6gv" +
       "8AjPM9NGKuxsywX22EtIaj51uo3A8OWJprg0K4sqyc9ztKqo4aAmEfyi5vsu" +
       "inGTCrwZE+56vJnTzR2q5wOas3xtIVYbmt9EcLRf56VdXht7EsdzCD80jWZS" +
       "yZbpJl2ypoxodJ+0ZbWH1Vt03F1pvThj+8vNHKU6nTZaqa6ihqD36ovJql3t" +
       "BYQoR/EGX1V6G4yF4XavNzctSRo2vU28qclKp2kps9WWX6BxYxSspXHu01wV" +
       "GVI4Jaz9aW/FkJ0lt3QdQfU2u8gXgyh1JX8rekya9FlvHJFu2xsxlVYz7Es7" +
       "fLFeSBbSpgmGmW87GUcvw3SFY5rLb4z5XB6h7RltMmOi05LWY5lvrbuDvDHO" +
       "cH3Xj8XVeNtOOqqom7EWZPWWhVCqM/UZq4HWN5tdngCDdHdzMtgQqWR0KnW8" +
       "5pLyeiYwLGmq8SQdT9pLiTeBvxXdyUKml4JUFVckaeobN9jYsLANl1ymdlfs" +
       "MOvXF3M+anDqjg7YraIY8yUVySiaIOPakJp4yBoPZFLud7pOJ5O76IJbiVSm" +
       "jdxEStPEmCyixtR20hGGW90wZDFZItH2Mop3VMru4rRN260m0pRpQkW4XQ3P" +
       "jCmygnFv1qRNmKkiorfm4U6Fl2CDm6idBqp2551aTC13HWnT1FsVLR1LCLzd" +
       "LshKa2bbk9Vm01hVNW2pcs1mZYUYCNJL60zckXLbz3q91nLa7rgbhzZ6c3TW" +
       "5tYLfybYntwc47v+IGwBH2MOVuKOI3C3GnTqKuK46Ky3NIxpq8bt1HlMNxHU" +
       "5PtGTw+XA9iLq2SquRtTklZqozeEicWiv+x4VFrb9bYdcRFx4xlZV9aThHXq" +
       "vSGGcgK1a093htHSJlzoNVi0n8gks9N6dLuPjlbDXOjM+Z5J8TWnt5j2A2G1" +
       "JCqYIg7WVJ0gtCrCENIYpabbNKmqOkmtCKmVNZdZaPBOGuYmrlvZqJonWoUZ" +
       "h0yIRT1n0AtZtV2NKXUStGmPWePEwEuzwOyOdKfex9Ykm04UdEKOWBO2UMXH" +
       "K1FnbUSE0zU7U1LBCECD2q6GXbG3q3W8cIhkrbFAu2JgcquhtTCNHOMlp9rY" +
       "DcMxGZDLsQCHUYNyc6zuD9Z0K56Ek/HCDPNqF1/5mpdGPbu2wVIq0FvDfqY1" +
       "uXrM1BVjSyeiQPeGwCC45Xw0JyUi7s+acSJKaTdcaXOxNWcFWcIUVDTxCjlL" +
       "pfUQTTBnCi9dqtnatexuNm1oiT2h5U0wxQiaYJFNYHARpo5HZqVNx9HWrqZA" +
       "GLaCmNVKNLdqsNHOx2NmmuTjFmuheqKn3eVCj6JtjfTj/sAazfheZTke0Z2O" +
       "AcfLJaEv0EUbdoig31zQgwrc4OiBX42jVsRyI2cy9/BKo1IzKXrWCuuhoFrj" +
       "eVTR6R28ylv6so1Pw6TZEo2OtGO3+RwG4aW26mwQ19p2m3k/pELWkoTluAFm" +
       "Gc5IL7KSYKZo3ma0qlRippJiO0HYhLOJ2BSUWcdWOgt1jrMYm8KDOtGrtSzR" +
       "7OzUnowrWwJt8x4IntiFziiNxULNOiCOJjfOkps43IBEUHJNrZ1M0BEPF1ad" +
       "rGnMVjIM41Q8qI6XaA1zQit02lZ1xfqp6HH8eqvX6u3mOESzdnOIoDqMpDKd" +
       "NNvAHOwWlQbajCOR9gbLkkWvvhsvHcpIYWGzm6UpndQ6tLPR0FlTgPFsWYdb" +
       "Dbyj64NRQ0RdfSf6A0kbql5Ln1mJ3A692WAmtjIp7jBRNlLxuEMZtUatglXU" +
       "heCRwHmtc75WRTBhuUxsG+Hd3Nto4dJpirm7tQeIz7aZZM43gl2Goloj40cL" +
       "8G2oijumwS2qMDHLzUo2b+uNZQTzWC8L+RCNrfYGN3a7OGim5NR36UA1c0kd" +
       "iS24Ndt2ETZBsmS06XZMWBXZaU70FlsOzrI5OsVTx4uJ1WBKpkpsmSLBqRRl" +
       "a6wO18OuncosInRhrsd2BzaiaKIkout6t882Zi4yS4QGvrDqrpaRBmPOw2HN" +
       "bIsdvh0bUs+sMDu2MbeHnpXGiFRR9WBCcIPF1twt3XTQQ/lqPPeXI8+cSwui" +
       "yesaXc3Bd11nMakZ49WMn/VY3naryDbrNJVuc5JJS9RUghXMdXs5E3eRAR3h" +
       "opFi7cUk0npdPme689mmaMtnEr3DtxLBbIcSY1jGfIy5KFgEbVqzwVqig6wt" +
       "u5tGnZnKokXQPTvORIxiJcnkSJukmnaXIqlBjfM74pDYziSsvhvN4roqmqQ2" +
       "za15k6KGKqZYvflo0MZD3VZXjaqjxuh4ZjnCJK/jMbZaG8Pqppcl3ZAZyB3T" +
       "MRdKsA5yvEGZuh97iQo3hW68HrLjNUMQzYhfLaxkmM0XMunGsiu3e1W637LG" +
       "TYFoDWps5smGs8E6OktJPEEvWGCsQtoKLH7tiZYmTcJt2FwQsZ2t8Eag9blR" +
       "wtfGGLmNJDGf272GHg0tTd+kZG2TwKMl7EyI2Wbu4B7T2owaNSRFg4QTcoza" +
       "JOuWV+EdLMS03pAeRrsFLsOL0LZaslIjSCq08pCPh3bQcpfrSdhy5d52OKqP" +
       "zFqXXC3NZoDNB3azptrDrcjanbzRVgmlygYpWfWIbdzhELUyEbFUr9cUEBiS" +
       "ucHRCTzX9bE6I2oJEg77cWuU0nOgi9O+WBPaqdwwmx1GxtSVAyw8mXtoUFnE" +
       "2wBxUgrNkDmT25qu9pGlvlNbjCWNOpud3ggSerRCOu2Y3optdp0MuB42sFfe" +
       "Yo6MRG9UY92tp9K41hStiWEgHl+PNjsx76iRgCCtkdqe9vVJszYaAG32Wxos" +
       "qBtbrS7nWgpPBusRucZ3MD4Ito3JdsoKOTIf9Ud8J5m1CX1GoGl3vtu1I7Hh" +
       "aq2+Hfd3aTwY94bBWpd3oQuTLJl4rI1S6Myv1notlCDE8WyJ1TXK24Qxk6l2" +
       "1ZSqk2XLbht1pRalAy/s5NbSkgmSZlln5NgwOp3nDJxXtArpE9TW7Ha7H/lI" +
       "sU3xuTvbPnmw3Ck6ulqxclpFxUt3sEOyr3q6yJ492lwsfxegWx9bnjjagYq9" +
       "uPff6sZEuQ/3xU+98qrO/XTt/MGR2CcS6L7ED/6cY2wM5wSpdwFKz996z5Et" +
       "L4wcH9X8+qf+2+OzH7Q+fgeH0R84w+dZkl9iX/sN6nu1Hz8P3XV0cHPDVZbT" +
       "na6fPq65FBlJGnmzU4c27z+9bVsBCT2QLHp22/Z47m6+8/zhEzvPZ44dzx2c" +
       "6x9sEz579rzGLI5hbe301ZSS0t+7OaXidb8t/JUi+zsJ9JAdlzcPzh4Pndmn" +
       "u6D76WFVqYI/c7tNupMnh2XB3z6SWbmz3QWJO5AZ9/bLrHh9rWzwj28nil8t" +
       "sl9MoKdNI2EMJU5OCqOQaLFz63uGV55Xv3Ysg196CzI40hvvQAbeOyODl8oG" +
       "X72dDP5Fkf3aTdWhqPn7x6D/6VsF/SxIP3IA+kfeyYn/2hsc4v9Okf2rBLp/" +
       "j5c/Ooc6gfRfvx1IXz5A+vI7Ob3feAOkv1dk//GNkf6nt4D0e4rCBkg/eYD0" +
       "J+8UKXEHSP/wDZD+9yL7/QR6nx0fHR0dme7RYfb2GPY33+oEF4f1XzqA/aV3" +
       "UpX/9A1g/1mR/TEIHYD7uhHuS8dw/8fbAffLB3C//A7q87m7bw333IWi8Lu3" +
       "h3sOeju88y8fwP3ldwYuVUK6chvvfO6hInvXm/DO5+5/q6A/BAZ+et93//dt" +
       "An3+uNVLxxP9xO2QP1lkjybQAzrAfRihccszqB97O1BXD1BX3xnU1PF8f/h2" +
       "qJ8vsmduh/rqnaDOE+jhm1wxLe7IPXbDHfb9vWvt5169fO+jrwr/trxleXQ3" +
       "+j4GuneZOs7JK00nni8EkbG0S2nct7/g");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FJSYaoCBm9x7TQCxg8eC53PVfetGAl06bp1A57VT1a0EunhQnUB3gfxk5feD" +
       "IlBZPF7fX5Y4fcS+v8iV78Pqx05qRekmH7qdWE8sk545tbgp/2XgcCGS7v9p" +
       "4AXtK68ORp/4dvOn93c+NUfZ7Qoq9zLQxf3105JosZh5+pbUDmldoJ/7zgM/" +
       "f9+zhwuvB/YMH2voCd4+cPNLlT03SMprkLtfevQf/sDPvPq75Yn//wNkeT5M" +
       "yzEAAA==");
}
