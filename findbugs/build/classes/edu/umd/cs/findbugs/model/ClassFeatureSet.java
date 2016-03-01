package edu.umd.cs.findbugs.model;
public class ClassFeatureSet implements edu.umd.cs.findbugs.xml.XMLWriteable {
    public static final java.lang.String CLASS_NAME_KEY = "Class:";
    public static final java.lang.String METHOD_NAME_KEY = "Method:";
    public static final java.lang.String CODE_LENGTH_KEY = "CodeLength:";
    public static final java.lang.String FIELD_NAME_KEY = "Field:";
    private java.lang.String className;
    private boolean isInterface;
    private final java.util.Set<java.lang.String> featureSet;
    public ClassFeatureSet() { super();
                               this.featureSet = new java.util.HashSet<java.lang.String>(
                                                   ); }
    public static final int MIN_CODE_LENGTH = 10;
    public edu.umd.cs.findbugs.model.ClassFeatureSet initialize(org.apache.bcel.classfile.JavaClass javaClass) {
        this.
          className =
          javaClass.
            getClassName(
              );
        this.
          isInterface =
          javaClass.
            isInterface(
              );
        addFeature(
          CLASS_NAME_KEY +
          transformClassName(
            javaClass.
              getClassName(
                )));
        for (org.apache.bcel.classfile.Method method
              :
              javaClass.
               getMethods(
                 )) {
            if (!isSynthetic(
                   method)) {
                java.lang.String transformedMethodSignature =
                  transformMethodSignature(
                    method.
                      getSignature(
                        ));
                if (method.
                      isStatic(
                        ) ||
                      !overridesSuperclassMethod(
                         javaClass,
                         method)) {
                    addFeature(
                      METHOD_NAME_KEY +
                      method.
                        getName(
                          ) +
                      ":" +
                      transformedMethodSignature);
                }
                org.apache.bcel.classfile.Code code =
                  method.
                  getCode(
                    );
                if (code !=
                      null &&
                      code.
                      getCode(
                        ) !=
                      null &&
                      code.
                        getCode(
                          ).
                        length >=
                      MIN_CODE_LENGTH) {
                    addFeature(
                      CODE_LENGTH_KEY +
                      method.
                        getName(
                          ) +
                      ":" +
                      transformedMethodSignature +
                      ":" +
                      code.
                        getCode(
                          ).
                        length);
                }
            }
        }
        for (org.apache.bcel.classfile.Field field
              :
              javaClass.
               getFields(
                 )) {
            if (!isSynthetic(
                   field)) {
                addFeature(
                  FIELD_NAME_KEY +
                  field.
                    getName(
                      ) +
                  ":" +
                  transformSignature(
                    field.
                      getSignature(
                        )));
            }
        }
        return this;
    }
    private boolean overridesSuperclassMethod(org.apache.bcel.classfile.JavaClass javaClass,
                                              org.apache.bcel.classfile.Method method) {
        if (method.
              isStatic(
                )) {
            return false;
        }
        try {
            org.apache.bcel.classfile.JavaClass[] superclassList =
              javaClass.
              getSuperClasses(
                );
            if (superclassList !=
                  null) {
                edu.umd.cs.findbugs.ba.JavaClassAndMethod match =
                  edu.umd.cs.findbugs.ba.Hierarchy.
                  findMethod(
                    superclassList,
                    method.
                      getName(
                        ),
                    method.
                      getSignature(
                        ),
                    edu.umd.cs.findbugs.ba.Hierarchy.
                      INSTANCE_METHOD);
                if (match !=
                      null) {
                    return true;
                }
            }
            org.apache.bcel.classfile.JavaClass[] interfaceList =
              javaClass.
              getAllInterfaces(
                );
            if (interfaceList !=
                  null) {
                edu.umd.cs.findbugs.ba.JavaClassAndMethod match =
                  edu.umd.cs.findbugs.ba.Hierarchy.
                  findMethod(
                    interfaceList,
                    method.
                      getName(
                        ),
                    method.
                      getSignature(
                        ),
                    edu.umd.cs.findbugs.ba.Hierarchy.
                      INSTANCE_METHOD);
                if (match !=
                      null) {
                    return true;
                }
            }
            return false;
        }
        catch (java.lang.ClassNotFoundException e) {
            return true;
        }
    }
    private boolean isSynthetic(org.apache.bcel.classfile.FieldOrMethod member) {
        if (edu.umd.cs.findbugs.bcel.BCELUtil.
              isSynthetic(
                member)) {
            return true;
        }
        java.lang.String name =
          member.
          getName(
            );
        if (name.
              startsWith(
                "class$")) {
            return true;
        }
        if (name.
              startsWith(
                "access$")) {
            return true;
        }
        return false;
    }
    public java.lang.String getClassName() {
        return className;
    }
    public void setClassName(java.lang.String className) {
        this.
          className =
          className;
    }
    public boolean isInterface() { return isInterface;
    }
    public void setInterface(boolean isInterface) {
        this.
          isInterface =
          isInterface;
    }
    public int getNumFeatures() { return featureSet.
                                    size(
                                      ); }
    public void addFeature(java.lang.String feature) {
        featureSet.
          add(
            feature);
    }
    public java.util.Iterator<java.lang.String> featureIterator() {
        return featureSet.
          iterator(
            );
    }
    public boolean hasFeature(java.lang.String feature) {
        return featureSet.
          contains(
            feature);
    }
    public static java.lang.String transformClassName(java.lang.String className) {
        int lastDot =
          className.
          lastIndexOf(
            '.');
        if (lastDot >=
              0) {
            java.lang.String pkg =
              className.
              substring(
                0,
                lastDot);
            if (!isUnlikelyToBeRenamed(
                   pkg)) {
                className =
                  className.
                    substring(
                      lastDot +
                        1);
            }
        }
        return className;
    }
    public static boolean isUnlikelyToBeRenamed(java.lang.String pkg) {
        return pkg.
          startsWith(
            "java.");
    }
    public static java.lang.String transformMethodSignature(java.lang.String signature) {
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          );
        buf.
          append(
            '(');
        edu.umd.cs.findbugs.ba.SignatureParser parser =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          signature);
        for (java.util.Iterator<java.lang.String> i =
               parser.
               parameterSignatureIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            java.lang.String param =
              i.
              next(
                );
            param =
              transformSignature(
                param);
            buf.
              append(
                param);
        }
        buf.
          append(
            ')');
        return buf.
          toString(
            );
    }
    public static java.lang.String transformSignature(java.lang.String signature) {
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          );
        int lastBracket =
          signature.
          lastIndexOf(
            '[');
        if (lastBracket >
              0) {
            buf.
              append(
                signature.
                  substring(
                    0,
                    lastBracket +
                      1));
            signature =
              signature.
                substring(
                  lastBracket +
                    1);
        }
        if (signature.
              startsWith(
                "L")) {
            signature =
              signature.
                substring(
                  1,
                  signature.
                    length(
                      ) -
                    1).
                replace(
                  '/',
                  '.');
            signature =
              transformClassName(
                signature);
            signature =
              "L" +
              signature.
                replace(
                  '.',
                  '/') +
              ";";
        }
        buf.
          append(
            signature);
        return buf.
          toString(
            );
    }
    public static final int MIN_FEATURES =
      5;
    public static final double MIN_MATCH =
      0.6;
    public static final double EXACT_CLASS_NAME_MATCH =
      MIN_MATCH +
      0.1;
    public static double similarity(edu.umd.cs.findbugs.model.ClassFeatureSet a,
                                    edu.umd.cs.findbugs.model.ClassFeatureSet b) {
        if (a.
              isInterface(
                ) !=
              b.
              isInterface(
                )) {
            return 0.0;
        }
        if (a.
              getNumFeatures(
                ) <
              MIN_FEATURES ||
              b.
              getNumFeatures(
                ) <
              MIN_FEATURES) {
            return a.
              getClassName(
                ).
              equals(
                b.
                  getClassName(
                    ))
              ? EXACT_CLASS_NAME_MATCH
              : 0.0;
        }
        int numMatch =
          0;
        int max =
          java.lang.Math.
          max(
            a.
              getNumFeatures(
                ),
            b.
              getNumFeatures(
                ));
        for (java.util.Iterator<java.lang.String> i =
               a.
               featureIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            java.lang.String feature =
              i.
              next(
                );
            if (b.
                  hasFeature(
                    feature)) {
                ++numMatch;
            }
        }
        return (double)
                 numMatch /
          (double)
            max;
    }
    public boolean similarTo(edu.umd.cs.findbugs.model.ClassFeatureSet other) {
        return similarity(
                 this,
                 other) >=
          MIN_MATCH;
    }
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { if (args.
                                             length !=
                                             2) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Usage: " +
                                               edu.umd.cs.findbugs.model.ClassFeatureSet.class.
                                                 getName(
                                                   ) +
                                               " <class 1> <class 2>");
                                           java.lang.System.
                                             exit(
                                               1);
                                       }
                                       org.apache.bcel.classfile.JavaClass a =
                                         org.apache.bcel.Repository.
                                         lookupClass(
                                           args[0]);
                                       org.apache.bcel.classfile.JavaClass b =
                                         org.apache.bcel.Repository.
                                         lookupClass(
                                           args[1]);
                                       edu.umd.cs.findbugs.model.ClassFeatureSet aFeatures =
                                         new edu.umd.cs.findbugs.model.ClassFeatureSet(
                                         ).
                                         initialize(
                                           a);
                                       edu.umd.cs.findbugs.model.ClassFeatureSet bFeatures =
                                         new edu.umd.cs.findbugs.model.ClassFeatureSet(
                                         ).
                                         initialize(
                                           b);
                                       java.lang.System.
                                         out.
                                         println(
                                           "Similarity is " +
                                           similarity(
                                             aFeatures,
                                             bFeatures));
                                       java.lang.System.
                                         out.
                                         println(
                                           "Classes are" +
                                           (aFeatures.
                                              similarTo(
                                                bFeatures)
                                              ? ""
                                              : " not") +
                                           " similar");
    }
    public static final java.lang.String ELEMENT_NAME =
      "ClassFeatureSet";
    public static final java.lang.String FEATURE_ELEMENT_NAME =
      "Feature";
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput)
          throws java.io.IOException { xmlOutput.
                                         openTag(
                                           ELEMENT_NAME,
                                           new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                             ).
                                             addAttribute(
                                               "class",
                                               className));
                                       for (java.util.Iterator<java.lang.String> i =
                                              featureIterator(
                                                );
                                            i.
                                              hasNext(
                                                );
                                            ) {
                                           java.lang.String feature =
                                             i.
                                             next(
                                               );
                                           xmlOutput.
                                             openCloseTag(
                                               FEATURE_ELEMENT_NAME,
                                               new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                                 ).
                                                 addAttribute(
                                                   "value",
                                                   feature));
                                       }
                                       xmlOutput.
                                         closeTag(
                                           ELEMENT_NAME);
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
       "VZFGRl+uBphBEoLtyP3VmuhMkEUZ6yzY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "fKk46Pf/AZyKMCUQTQAA");
}
