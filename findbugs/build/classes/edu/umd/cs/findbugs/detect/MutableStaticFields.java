package edu.umd.cs.findbugs.detect;
public class MutableStaticFields extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private static final java.util.Set<java.lang.String> COLLECTION_SUPERCLASSES =
      new java.util.HashSet<java.lang.String>(
      java.util.Arrays.
        asList(
          "java/util/Collection",
          "java/util/List",
          "java/util/Set",
          "java/util/Map",
          "java/util/AbstractList",
          "java/util/SortedSet",
          "java/util/SortedMap",
          "java/util/NavigableMap",
          "java/util/Dictionary"));
    private static final java.util.Set<java.lang.String> MUTABLE_COLLECTION_CLASSES =
      new java.util.HashSet<java.lang.String>(
      java.util.Arrays.
        asList(
          "java/util/ArrayList",
          "java/util/HashSet",
          "java/util/HashMap",
          "java/util/Hashtable",
          "java/util/IdentityHashMap",
          "java/util/LinkedHashSet",
          "java/util/LinkedList",
          "java/util/LinkedHashMap",
          "java/util/TreeSet",
          "java/util/TreeMap",
          "java/util/Properties"));
    private enum AllowedParameter {
        NONE, EMPTY_ARRAY; 
        private AllowedParameter() {  }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "W/8FliCaUeUbAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "KxIxJ4ecCxfLG+av4as8u8+A/+JkwKM01JmkKZQnGJ6815FlkVz41AdefEnj" +
           "fqJycJRsthLoytFJ8imfA8DmHffOovSL49rTHOavf+CPn5h8j/We13DI89Y9" +
           "IfdZ/pf+y5/vfKf67w6giycZzTsOks8T3Tqfx3wo0pM08ifnsplP5sWN7NQU" +
           "36ZR97L1F3ZHG4VZiw4fuE86/9/kxfsS6GqRFuOMYvDwPgQvFLXv/Zai7qcm" +
           "gSV9Oc8k3VXmsyN86D5tH8mLDwJehbjxfdLwwBOKI49deuyln3z2t37wpWf/" +
           "sDg1eMCOBTkiIvMuR+hnaL7+8pe/+juve/KV4pjtkiLHO1Pt3z2482rBuRsD" +
           "hdiPnJmuMAyh+03wx7IEur5/GHqcJj18bYeqYH7efMdNjt3tA/WVl6498KaX" +
           "pv9zp97xDYEHWegBI3Xdszn3M89XwFZp2IWcD+4y8GHx7z8m0BP3Fg3Ya/dQ" +
           "qPHjO5JPJtDjdyFJwPhHj2d7/6cEeui0dwIdqOea/zPw4KPmBLoIyrONPwmq" +
           "QGP++FPh/cFjnCpxcuYaxYfsl77w3//82vt32c7zudviJs0R6T7dF3/vIvJw" +
           "cvMjBeic+M4DLHQ5znsm0NP3vpVT8NolZh8+PZSE7n4o+frTM5Y8+XpYXPoJ" +
           "w+zYYc6kwvP2vPaVc3neu0/BbbXr3R5/9osv1Is07rWVHduJrk2OrgmdP3U8" +
           "PZa/de7q0F0n6bb6lU9/6HPP/LHweHEnZDcfuVi1bLcqsKM950Kx5xxAu6P9" +
           "ey3zI4mKQ9Lb6g984u++8EfPf+nzF6ErYGHmPi1HOsBgsHDudZXqLIObE/DU" +
           "BFQArR/dUdu+WZj1yHw3TmpPzuUT6F/ei3eR0987vs8vI+VrOyKD1Ndytk/t" +
           "bQ1pGJ5t3QHI/7cjvC+C3vltzN2J6scnPzcKj99zn7ONIVi/FEuMx7cnIt+6" +
           "LRCjLkGyBeK/EoLGC61C5p/Oi5cLJV7ZeV9efuZeps6rf6Eozh24QtkOPPcr" +
           "L5yPL07ilxvf6lThKJTIH4m8YLNzlwj2Xbef7u7K3VY//VJv8N5v1H9id4kB" +
           "zPJ2e+QbV3f3KU6iiGfuye2Y1xX6uW8++pkH334c7jy6v6ueCZzeevdLAi0v" +
           "TIpj/e0vvOnn3vVTL32pOL36BzzXMjjCKAAA");
    }
    private static final java.util.Map<java.lang.String,java.util.Map<java.lang.String,edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter>>
      MUTABLE_COLLECTION_METHODS =
      new java.util.HashMap<java.lang.String,java.util.Map<java.lang.String,edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter>>(
      );
    static { MUTABLE_COLLECTION_METHODS.put(
                                          "java/util/Arrays",
                                          java.util.Collections.
                                            singletonMap(
                                              "asList",
                                              edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter.
                                                EMPTY_ARRAY));
             java.util.Map<java.lang.String,edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter> listsMap =
               new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter>(
               );
             listsMap.put("newArrayList",
                          edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter.
                            NONE);
             listsMap.put("newLinkedList",
                          edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter.
                            NONE);
             MUTABLE_COLLECTION_METHODS.put(
                                          "com/google/common/collect/Lists",
                                          listsMap);
             java.util.Map<java.lang.String,edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter> setsMap =
               new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter>(
               );
             setsMap.put("newHashSet", edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter.
                                         NONE);
             setsMap.put("newTreeSet", edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter.
                                         NONE);
             MUTABLE_COLLECTION_METHODS.put(
                                          "com/google/common/collect/Sets",
                                          setsMap);
    }
    static java.lang.String extractPackage(java.lang.String c) {
        int i =
          c.
          lastIndexOf(
            '/');
        if (i <
              0) {
            return "";
        }
        return c.
          substring(
            0,
            i);
    }
    static boolean mutableSignature(java.lang.String sig) {
        return sig.
          equals(
            "Ljava/util/Hashtable;") ||
          sig.
          equals(
            "Ljava/util/Date;") ||
          sig.
          equals(
            "Ljava/sql/Date;") ||
          sig.
          equals(
            "Ljava/sql/Timestamp;") ||
          sig.
          charAt(
            0) ==
          '[';
    }
    java.util.LinkedList<edu.umd.cs.findbugs.ba.XField>
      seen =
      new java.util.LinkedList<edu.umd.cs.findbugs.ba.XField>(
      );
    boolean publicClass;
    boolean mutableCollectionJustCreated =
      false;
    boolean zeroOnTOS;
    boolean emptyArrayOnTOS;
    boolean inStaticInitializer;
    java.lang.String packageName;
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      readAnywhere =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      unsafeValue =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      mutableCollection =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      notFinal =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      outsidePackage =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      needsRefactoringToBeFinal =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      writtenInMethod =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      writtenTwiceInMethod =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Map<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.SourceLineAnnotation>
      firstFieldUse =
      new java.util.HashMap<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.SourceLineAnnotation>(
      );
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    private boolean isEclipseNLS;
    public MutableStaticFields(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        super.
          visit(
            obj);
        int flags =
          obj.
          getAccessFlags(
            );
        publicClass =
          (flags &
             ACC_PUBLIC) !=
            0 &&
            !getDottedClassName(
               ).
            startsWith(
              "sun.");
        packageName =
          extractPackage(
            getClassName(
              ));
        isEclipseNLS =
          "org.eclipse.osgi.util.NLS".
            equals(
              obj.
                getSuperclassName(
                  ));
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        zeroOnTOS =
          false;
        inStaticInitializer =
          getMethodName(
            ).
            equals(
              "<clinit>");
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        writtenInMethod.
          clear(
            );
        writtenTwiceInMethod.
          clear(
            );
        super.
          visit(
            obj);
        if (inStaticInitializer) {
            needsRefactoringToBeFinal.
              addAll(
                writtenTwiceInMethod);
        }
        writtenInMethod.
          clear(
            );
        writtenTwiceInMethod.
          clear(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (seen) {
                                          case GETSTATIC:
                                          case PUTSTATIC:
                                              edu.umd.cs.findbugs.ba.XField xField =
                                                getXFieldOperand(
                                                  );
                                              if (xField ==
                                                    null) {
                                                  break;
                                              }
                                              if (!interesting(
                                                     xField)) {
                                                  break;
                                              }
                                              boolean samePackage =
                                                packageName.
                                                equals(
                                                  extractPackage(
                                                    xField.
                                                      getFieldDescriptor(
                                                        ).
                                                      getSlashedClassName(
                                                        )));
                                              boolean initOnly =
                                                seen ==
                                                GETSTATIC ||
                                                getClassName(
                                                  ).
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                inStaticInitializer;
                                              boolean safeValue =
                                                seen ==
                                                GETSTATIC ||
                                                emptyArrayOnTOS ||
                                                edu.umd.cs.findbugs.ba.AnalysisContext.
                                                currentXFactory(
                                                  ).
                                                isEmptyArrayField(
                                                  xField) ||
                                                !mutableSignature(
                                                   getSigConstantOperand(
                                                     ));
                                              if (seen ==
                                                    GETSTATIC) {
                                                  readAnywhere.
                                                    add(
                                                      xField);
                                              }
                                              if (seen ==
                                                    PUTSTATIC) {
                                                  if (xField.
                                                        isFinal(
                                                          ) &&
                                                        mutableCollectionJustCreated) {
                                                      mutableCollection.
                                                        add(
                                                          xField);
                                                  }
                                                  if (!writtenInMethod.
                                                        add(
                                                          xField)) {
                                                      writtenTwiceInMethod.
                                                        add(
                                                          xField);
                                                  }
                                              }
                                              if (!samePackage) {
                                                  outsidePackage.
                                                    add(
                                                      xField);
                                              }
                                              if (!initOnly) {
                                                  notFinal.
                                                    add(
                                                      xField);
                                              }
                                              if (!safeValue) {
                                                  unsafeValue.
                                                    add(
                                                      xField);
                                              }
                                              if (inStaticInitializer &&
                                                    !firstFieldUse.
                                                    containsKey(
                                                      xField)) {
                                                  edu.umd.cs.findbugs.SourceLineAnnotation sla =
                                                    edu.umd.cs.findbugs.SourceLineAnnotation.
                                                    fromVisitedInstruction(
                                                      this);
                                                  firstFieldUse.
                                                    put(
                                                      xField,
                                                      sla);
                                              }
                                              break;
                                          case ANEWARRAY:
                                          case NEWARRAY:
                                              if (zeroOnTOS) {
                                                  emptyArrayOnTOS =
                                                    true;
                                              }
                                              zeroOnTOS =
                                                false;
                                              return;
                                          case ICONST_0:
                                              zeroOnTOS =
                                                true;
                                              emptyArrayOnTOS =
                                                false;
                                              return;
                                          case INVOKESPECIAL:
                                              if (inStaticInitializer &&
                                                    "<init>".
                                                    equals(
                                                      getMethodDescriptorOperand(
                                                        ).
                                                        getName(
                                                          ))) {
                                                  edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor =
                                                    getClassDescriptorOperand(
                                                      );
                                                  if (MUTABLE_COLLECTION_CLASSES.
                                                        contains(
                                                          classDescriptor.
                                                            getClassName(
                                                              ))) {
                                                      mutableCollectionJustCreated =
                                                        true;
                                                      return;
                                                  }
                                                  try {
                                                      edu.umd.cs.findbugs.ba.XClass xClass =
                                                        classDescriptor.
                                                        getXClass(
                                                          );
                                                      edu.umd.cs.findbugs.classfile.ClassDescriptor superclassDescriptor =
                                                        xClass.
                                                        getSuperclassDescriptor(
                                                          );
                                                      if (superclassDescriptor !=
                                                            null &&
                                                            MUTABLE_COLLECTION_CLASSES.
                                                            contains(
                                                              superclassDescriptor.
                                                                getClassName(
                                                                  ))) {
                                                          mutableCollectionJustCreated =
                                                            true;
                                                          for (edu.umd.cs.findbugs.ba.XMethod xMethod
                                                                :
                                                                xClass.
                                                                 getXMethods(
                                                                   )) {
                                                              if (xMethod !=
                                                                    null &&
                                                                    !"<init>".
                                                                    equals(
                                                                      xMethod.
                                                                        getName(
                                                                          )) &&
                                                                    !"<clinit>".
                                                                    equals(
                                                                      xMethod.
                                                                        getName(
                                                                          ))) {
                                                                  mutableCollectionJustCreated =
                                                                    false;
                                                                  break;
                                                              }
                                                          }
                                                          return;
                                                      }
                                                  }
                                                  catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                      
                                                  }
                                              }
                                              break;
                                          case INVOKESTATIC:
                                              if (inStaticInitializer) {
                                                  java.util.Map<java.lang.String,edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter> methods =
                                                    MUTABLE_COLLECTION_METHODS.
                                                    get(
                                                      getMethodDescriptorOperand(
                                                        ).
                                                        getSlashedClassName(
                                                          ));
                                                  if (methods !=
                                                        null) {
                                                      java.lang.String name =
                                                        getMethodDescriptorOperand(
                                                          ).
                                                        getName(
                                                          );
                                                      edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter allowedParameter =
                                                        methods.
                                                        get(
                                                          name);
                                                      if (allowedParameter ==
                                                            edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter.
                                                              NONE ||
                                                            allowedParameter ==
                                                            edu.umd.cs.findbugs.detect.MutableStaticFields.AllowedParameter.
                                                              EMPTY_ARRAY &&
                                                            !emptyArrayOnTOS) {
                                                          mutableCollectionJustCreated =
                                                            true;
                                                          return;
                                                      }
                                                  }
                                              }
                                              break;
                                      }
                                      zeroOnTOS =
                                        false;
                                      emptyArrayOnTOS =
                                        false;
                                      mutableCollectionJustCreated =
                                        false;
    }
    private boolean isCollection(java.lang.String signature) {
        if (signature.
              startsWith(
                "L") &&
              signature.
              endsWith(
                ";")) {
            java.lang.String fieldClass =
              signature.
              substring(
                1,
                signature.
                  length(
                    ) -
                  1);
            return COLLECTION_SUPERCLASSES.
              contains(
                fieldClass) ||
              MUTABLE_COLLECTION_CLASSES.
              contains(
                fieldClass);
        }
        return false;
    }
    private boolean interesting(edu.umd.cs.findbugs.ba.XField f) {
        if (!f.
              isPublic(
                ) &&
              !f.
              isProtected(
                )) {
            return false;
        }
        if (!f.
              isStatic(
                ) ||
              f.
              isSynthetic(
                ) ||
              f.
              isVolatile(
                )) {
            return false;
        }
        if (!f.
              isFinal(
                )) {
            return true;
        }
        boolean isArray =
          f.
          getSignature(
            ).
          charAt(
            0) ==
          '[';
        if (!(isArray ||
                isCollection(
                  f.
                    getSignature(
                      )))) {
            return false;
        }
        return true;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) {
        super.
          visit(
            obj);
        int flags =
          obj.
          getAccessFlags(
            );
        boolean isStatic =
          (flags &
             ACC_STATIC) !=
          0;
        if (!isStatic) {
            return;
        }
        boolean isVolatile =
          (flags &
             ACC_VOLATILE) !=
          0;
        if (isVolatile) {
            return;
        }
        boolean isFinal =
          (flags &
             ACC_FINAL) !=
          0;
        boolean isPublic =
          publicClass &&
          (flags &
             ACC_PUBLIC) !=
          0;
        boolean isProtected =
          publicClass &&
          (flags &
             ACC_PROTECTED) !=
          0;
        if (!isPublic &&
              !isProtected) {
            return;
        }
        boolean isArray =
          getFieldSig(
            ).
          charAt(
            0) ==
          '[';
        if (isFinal &&
              !(isArray ||
                  isCollection(
                    getFieldSig(
                      )))) {
            return;
        }
        if (isEclipseNLS &&
              getFieldSig(
                ).
              equals(
                "Ljava/lang/String;")) {
            return;
        }
        seen.
          add(
            getXField(
              ));
    }
    @java.lang.Override
    public void report() { for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 seen) { boolean isFinal =
                                           f.
                                           isFinal(
                                             );
                                         java.lang.String className =
                                           f.
                                           getClassName(
                                             );
                                         java.lang.String fieldSig =
                                           f.
                                           getSignature(
                                             );
                                         java.lang.String fieldName =
                                           f.
                                           getName(
                                             );
                                         boolean couldBeFinal =
                                           !isFinal &&
                                           !notFinal.
                                           contains(
                                             f);
                                         boolean couldBePackage =
                                           !outsidePackage.
                                           contains(
                                             f);
                                         boolean isMutableCollection =
                                           mutableCollection.
                                           contains(
                                             f);
                                         boolean movedOutofInterface =
                                           false;
                                         try {
                                             edu.umd.cs.findbugs.ba.XClass xClass =
                                               edu.umd.cs.findbugs.classfile.Global.
                                               getAnalysisCache(
                                                 ).
                                               getClassAnalysis(
                                                 edu.umd.cs.findbugs.ba.XClass.class,
                                                 f.
                                                   getClassDescriptor(
                                                     ));
                                             movedOutofInterface =
                                               couldBePackage &&
                                                 xClass.
                                                 isInterface(
                                                   );
                                         }
                                         catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                             assert true;
                                         }
                                         boolean isHashtable =
                                           fieldSig.
                                           equals(
                                             "Ljava/util/Hashtable;");
                                         boolean isArray =
                                           fieldSig.
                                           charAt(
                                             0) ==
                                           '[' &&
                                           unsafeValue.
                                           contains(
                                             f);
                                         boolean isReadAnywhere =
                                           readAnywhere.
                                           contains(
                                             f);
                                         java.lang.String bugType;
                                         int priority =
                                           NORMAL_PRIORITY;
                                         if (isFinal &&
                                               !isHashtable &&
                                               !isArray &&
                                               !isMutableCollection) {
                                             continue;
                                         }
                                         else
                                             if (movedOutofInterface) {
                                                 bugType =
                                                   "MS_OOI_PKGPROTECT";
                                             }
                                             else
                                                 if (couldBePackage &&
                                                       couldBeFinal &&
                                                       (isHashtable ||
                                                          isArray)) {
                                                     bugType =
                                                       "MS_FINAL_PKGPROTECT";
                                                 }
                                                 else
                                                     if (couldBeFinal &&
                                                           !isHashtable &&
                                                           !isArray) {
                                                         bugType =
                                                           "MS_SHOULD_BE_FINAL";
                                                         if (needsRefactoringToBeFinal.
                                                               contains(
                                                                 f)) {
                                                             bugType =
                                                               "MS_SHOULD_BE_REFACTORED_TO_BE_FINAL";
                                                         }
                                                         if (fieldName.
                                                               equals(
                                                                 fieldName.
                                                                   toUpperCase(
                                                                     )) ||
                                                               fieldSig.
                                                               charAt(
                                                                 0) ==
                                                               'L') {
                                                             priority =
                                                               HIGH_PRIORITY;
                                                         }
                                                     }
                                                     else
                                                         if (couldBePackage) {
                                                             bugType =
                                                               isMutableCollection
                                                                 ? "MS_MUTABLE_COLLECTION_PKGPROTECT"
                                                                 : "MS_PKGPROTECT";
                                                         }
                                                         else
                                                             if (isHashtable) {
                                                                 bugType =
                                                                   "MS_MUTABLE_HASHTABLE";
                                                                 if (!isFinal) {
                                                                     priority =
                                                                       HIGH_PRIORITY;
                                                                 }
                                                             }
                                                             else
                                                                 if (isArray) {
                                                                     bugType =
                                                                       "MS_MUTABLE_ARRAY";
                                                                     if (fieldSig.
                                                                           indexOf(
                                                                             'L') >=
                                                                           0 ||
                                                                           !isFinal) {
                                                                         priority =
                                                                           HIGH_PRIORITY;
                                                                     }
                                                                 }
                                                                 else
                                                                     if (isMutableCollection) {
                                                                         bugType =
                                                                           "MS_MUTABLE_COLLECTION";
                                                                         priority =
                                                                           HIGH_PRIORITY;
                                                                     }
                                                                     else
                                                                         if (!isFinal) {
                                                                             bugType =
                                                                               "MS_CANNOT_BE_FINAL";
                                                                         }
                                                                         else {
                                                                             throw new java.lang.IllegalStateException(
                                                                               "impossible");
                                                                         }
                                         if (!isReadAnywhere) {
                                             priority =
                                               LOW_PRIORITY;
                                         }
                                         edu.umd.cs.findbugs.BugInstance bug =
                                           new edu.umd.cs.findbugs.BugInstance(
                                           this,
                                           bugType,
                                           priority).
                                           addClass(
                                             className).
                                           addField(
                                             f);
                                         edu.umd.cs.findbugs.SourceLineAnnotation firstPC =
                                           firstFieldUse.
                                           get(
                                             f);
                                         if (firstPC !=
                                               null) {
                                             bug.
                                               addSourceLine(
                                                 firstPC);
                                         }
                                         bugReporter.
                                           reportBug(
                                             bug);
                           } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "D0Bceex7H0Ee4/IA94612Uy1VS6PMNBweTzOef5hhDxexubvYR/C/8OAWkzR" +
       "xn3ieOGjSutoHlfaPF0ZIY7ZemQosuhotyo82olvZUj6jyNk+AY2r4aEu3O/" +
       "pXAHThOzi8FYVB05a+GGIYsQzK8ixt7F5ueMVJt89+uT2i8+BqkVGFkY8D0d" +
       "r5YuK/v/IfE/L/IjJxprl57Y/jLfBZb+L6UB9nNjeVV1X350vVcbJh1TuNAb" +
       "xFVI/vE29gEjy8O/9YNoxAvX7vscJB4HmgNAGKxvv7pnz2WkzpnNSFz2DNcy" +
       "UmMPQ/6B1j1YD10wiK8NRtFVNgbeYJ4BKvGrqwxbUQgfmznVulkQHuY5seEn" +
       "94vPF1Bc2/u1oZfe+vLi/7/S8ukT2/rvePuar4pr7+C9+/YhlvoUqRE38DnS" +
       "qrLbeW5sRVzVW9e/t+DReeuKBwbNgmDHYdz3JbrBHg20l+W+O+FWe+lq+NmT" +
       "13/3+cPVL8ZJbBeJSaC/XeV3bQtG3iQrd6XKb1YVb4d1rL9/5saNY7/4Eb/N" +
       "TMRNrBXh89Py6LFXeh+d/PVN/N+N5oKyaIFfAt48ow1Recr0XNMKvmo333PV" +
       "jpE15Z+vz3u1bn6K1Ds9QhORt+0QwOmxVYctV+r+AkofbDOd6jMM+6pE1f0G" +
       "9+k7ggsotOFV/BXf2v4fNDfxtQg6AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDsWHle3zf7wrxZWIbJzDDDPByYxk/dUqtbnQEbdUut" +
       "3rR0q9XdEsEPrd3q1tbaWhIe25CExQ6YMoODXTCVuDAxBAxJmbJTLju4UtgQ" +
       "QxInlAOpMjgpJ8Zgqkw5dlImsXOk7vvuMve+N28A36pzru5Zv/8///+f/9fR" +
       "uR//VumWwC+VPddKF5YbXtaT8PLKQi+HqacHl/tDlJP9QNfalhwEE1B2RX3l" +
       "py7+5Xfeu7z3QulWqfSA7DhuKIem6wRjPXCtWNeGpYtHpaSl20FYune4kmMZ" +
       "ikLTgoZmED41LN11rGtYujQ8hAABCBCAABUQIPyoFej0It2J7HbeQ3bCYFP6" +
       "sdLBsHSrp+bwwtLjJwfxZF+298NwBQVghNvzv6eAqKJz4pceu0r7jubnEPz+" +
       "MvTMP/mRe//VTaWLUumi6fA5HBWACMEkUuluW7cV3Q9wTdM1qXSfo+sar/um" +
       "bJlZgVsq3R+YC0cOI1+/yqS8MPJ0v5jziHN3qzltfqSGrn+VPMPULe3wr1sM" +
       "S14AWl96ROuOwk5eDgi80wTAfENW9cMuN69NRwtLrzjd4yqNlwagAeh6m62H" +
       "S/fqVDc7Migo3b9bO0t2FhAf+qazAE1vcSMwS1h66NxBc157srqWF/qVsPTg" +
       "6Xbcrgq0uqNgRN4lLL3kdLNiJLBKD51apWPr8y3mde95i9N1LhSYNV21cvy3" +
       "g06Pnuo01g3d1x1V33W8+8nhz8ov/Y13XiiVQOOXnGq8a/OrP/rtN7z20c98" +
       "btfm75zRhlVWuhpeUT+s3PN7D7df07wph3G75wZmvvgnKC/En9vXPJV4QPNe" +
       "enXEvPLyYeVnxr8t/sTH9G9eKN3ZK92qulZkAzm6T3Vtz7R0n9Id3ZdDXeuV" +
       "7tAdrV3U90q3geeh6ei7UtYwAj3slW62iqJb3eJvwCIDDJGz6DbwbDqGe/js" +
       "yeGyeE68Uql0G0ilu0GCSruf4ndY0qGla+uQrMqO6bgQ57s5/QGkO6ECeLuE" +
       "DCBMSrQIoMBXoUJ0dC2CIluD1OCoUtND0A2io1BWLH2nU51C0C/nfby/rYmS" +
       "nOJ7twcHYDEePm0KLKBFXdfSdP+K+kzUIr/9y1d+98JV1djzKixdBvNeBvNe" +
       "VoPLh/Ne3s17+Yx5SwcHxXQvzuffrTtYtTXQf2AZ734N/6b+m9/5ypuAwHnb" +
       "mwHL86bQ+Qa6fWQxeoVdVIHYlj7zge1bpz9euVC6cNLS5phB0Z15dy63j1ft" +
       "4KXTGnbWuBff8fW//OTPPu0e6doJ0703Ac/tmavwK09z13dVwDhfPxr+ycfk" +
       "T1/5jacvXSjdDOwCsIWhDGQXmJlHT89xQpWfOjSLOS23AIIN17dlK686tGV3" +
       "hkvf3R6VFMt+T/F8H+DxXblsPwrSP9wLe/E7r33Ay/MX78QkX7RTVBRm9/W8" +
       "96Ev//s/QQp2H1roi8f2PF4PnzpmFfLBLhb6f9+RDEx8XQft/uAD3Pve/613" +
       "vLEQANDiibMmvJTnbWANwBICNv+jz22+8rWvfvhLF46EJgTbYqRYpppcJTIv" +
       "L915DSLBbD9whAdYFQtIcC41lwTHdjXTMHNRzqX0/158VfXTf/qee3dyYIGS" +
       "QzF67fUHOCp/eav0E7/7I//70WKYAzXf1Y54dtRsZyofOBoZ9305zXEkb/1P" +
       "j/zc78gfAkYXGLrAzPTCdh3sFScH9RKw852ln61oMdY91wfbWLG4UNH6ySK/" +
       "nDOmGKNU1CF59orguJKc1MNjXsoV9b1f+rMXTf/sN79dUHXSzTkuE7TsPbUT" +
       "wzx7LAHDv+y0RejKwRK0q32G+fv3Wp/5DhhRAiOqYG8PWB+YpeSEBO1b33Lb" +
       "f/2tf/vSN//eTaULndKdlitrHblQxtIdQAv0YAksWuL98Bt2QrC9HWT3FqSW" +
       "nkP8TngeLP56EAB8zfl2qLBtR6r84F+xlvK2//5/nsOEwgKdsTmf6i9BH//g" +
       "Q+0f+mbR/8gU5L0fTZ5rqoFHd9QX/pj9FxdeeetnL5Ruk0r3qnt3cSpbUa5g" +
       "EnCRgkMfEriUJ+pPuju7vf2pq6bu4dNm6Ni0p43Q0RYBnvPW+fOdp+zOy3Mu" +
       "T0GC9ypZOW13DkrFA150ebzIL+XZ3y3W5KawdJvnmzHwBYDCB8UmEwIcpiNb" +
       "e8X/G/BzANJf5ykfPS/YbeX3t/f+xGNXHQoPbGcva7PDIdme9FjmCi9w5Lg9" +
       "xHme5MH6P3n++vOREoTH3LJ3m89+8d/9xcW37jynk4JTeOb7rqf7feXLN8F3" +
       "hZd+urClNytyUDDudsDdIG8Zlh4738svxtop1V1H1JfOpv6BE+b5chFDeF5y" +
       "aDRedKRXoDovHAEGPH4dBlxRe/YV/tNfeUe9ENyLsQksvq5N9kHHSQt3tOs/" +
       "dSIQOZNFV9Svf/Ldn3v8G9MHCg9zx40cFgqsY/4b22v0QaHRF/aew6vOAbxH" +
       "VBjkK+qPfvCvv/gnT3/18zeVbgV7ZS7ssg+8S+C+Xj4vMDs+wKUJeCJAL6AE" +
       "9+x6gzChWNT94t1/tfTqth+WfvC8sfO487R3kIc2lrvV/ZYbOVphB04q2Z2R" +
       "5x2vLcTg7hcqBj8GtrLnwbqrlO/1t3R/Ie73FMKT25DLJIhYj1cCBXugUKgr" +
       "E5Ejr0zxcQ9vDclCwHLtOyAPJfDeo0F2hig5o2YXkZ0w1KW9s5LntTxr7Wob" +
       "55r81500SH8PpMYecu0cg7Q6xyDljwUxnTyjCihdECfSwiQn88ox27I3K3kL" +
       "5hTi9Q0i3oD0+j3i15+DePPdI6bJSZcl+GKIwY1IFtiVr2VgQHVemBZV/Alt" +
       "vqkgPQd6oSifv9Bp825vLmYppGyaP+6dw0GebYsW6fPAkRc/fUjFD99Y7HMJ" +
       "t3Il1orYA7TaveWY59mPnYY42EHMc/0MAX/7eRXH5Mh//nJU9M+lXtzLkXiO" +
       "HP3js+WodCg4Nwe67jxPEXnorM3gOZJyZqCY1z1zxkIdN//PT2CuDeLqojyz" +
       "s07H5AZAe+Ss5Vfky/Niua+9OO++wcV5EKQ37hfnjecszj+7zuLctQuKiq3p" +
       "2v4s55s2CNbi/csi6On7v7b+4Nc/sXNnTjuvpxrr73zmJ//m8nueuXDs9dsT" +
       "z3kDdrzP7hVcgfJFBdTkhLNxxixFj84ff/LpX/+lp9+xQ3X/yZdJ+c7zid//" +
       "f1+4/IE//PwZby1uU1zX0mXn1Kr8wg2uShWkN+1X5U3nrMqnrrMqD9s7S3EU" +
       "8vUj4BT6eu6S5m0+egrkv7xBkC8F6coe5JVzQP7qdUDekem+yzoTlj8L0a/d" +
       "IKKHQZL3iORzEP3mdRBd1G0vTItg+Fxc/+YGcT0GkrrHpZ6D67PXwfXA4Uvy" +
       "ngPENX8RvgvcTmP77RvE9jKQ9D02/RxsX7iuAdi9eGb2qqCfwvTFG8SEgrTY" +
       "Y1qcg+k/XwfT3UDQNdxJt0vd1492ZLaoHxXZtQ19XvzGPPvgtS3ul26QuNz5" +
       "M/fEmecQ99XrMTxyAtnQi+g6L/ryKUxfu0FMuXO63mNan4Ppf1wH033PsTdn" +
       "IfufL8ASHrr69jnI/vQ6yG533LCTR+9nAfrWC/Bm3D0g9xxAf34dQPe4URiY" +
       "mr4/rzkL1v+6QVit0s5hLx3+PgPWX10H1svzY7ZgrBvFmy0QAU3cln4u475z" +
       "gwgxkII9wuBshAcH1zPOW98MQ93pOXRxqnYGroMLN4grD22iPa7oHFy3XwfX" +
       "i/e4JltT1a8F7o4bBKfkbfbgtueAu3gdcC8yTD8IC99RCI6ZwhcYnLz6LO+U" +
       "dyNf1fNzsqO3tnn7t1/fgB7c+/x5cn9e+iRI6Z4n6Tk8efhsnhSUFN721ZD0" +
       "LuXonXVeVDmF7pHnjy4/2Cs9DtLb9ujedg66J85GV2w55NUNzAxI1TK9QGeG" +
       "Z3khB5eui6wYKTk4CEu3wJcbl3PSDp48e+4iYn91np2M2F+2stRLh680pyC0" +
       "BAt7aWU18urT23z3eQMKTrzNGbrO4qmf+qP3fuGnn/ga8Kn7pVvifGMDzvex" +
       "dzJMlH8R8PaPv/+Ru575w58qDmUAx/jXKH/+hpys6o2R9VBO1l5o5SCki3MU" +
       "XcspK4b4yDF6PgbCTwtAfMHUhi/9p91a0MMPf2ih0UZwrTqfI5xm80PamSXV" +
       "Mj1UI3hCeStkwWWDhBz1OzYrSbXyejaapxiRxU51XrH8hhbqjWbF4pI1ugqT" +
       "Ki05bRXGuwNyaExUcUiQ5LYuTTfypFlZ9ubbxlIatG2471bS9Xog2GIrHMw6" +
       "js/GRqwbYSOaBVjL9ezmLKw2sobjGFi9qUPz7QzmI0nqzzY+SdoZBeKa1Rge" +
       "tNaz1UTxhc2MGfWbsuHog2gNKUg5gxpubTOuWe1UXG8q5dlw6HXcmT+jTMHv" +
       "qFVzbUqTDQrxQ7JH2yFvot6E7HQqSl8MpptMcza9TRAQtSaPdNtEYNHrmdyn" +
       "p1wfbTlhOCa3warXsdojtK9aLIS0uuZq0otW3dWkA9l22AipgJLYGfA8UMqu" +
       "tlCPX/u2LfdsoeZ32IVrR9pkVJWsZDpT+zO73eeAQIcLE/bkWkRilDxOYsPQ" +
       "IXfcoudbod+vIBMKVlhqM5j5QsYrPbfKKrXmQG1KOmZZvMUPq35g0+FAH5ip" +
       "tKzwo2AWTWb2aC5kdU3mQj1UEUkkp2y1xzOt1SCDeytyLWC+JOMimontpRXa" +
       "mAoTi3CDkL7eTle0EM9RFzMiKJzMm/p47HV5mTUJnkbpJdES+50x2V4xkrz0" +
       "tJmcMUQ4sFfTUXOFVzuCNW2Gtqz4lKAKVVOftiCBz0R7orupplUkfFpvMQ06" +
       "ppNKgE10ilDdcr2MinW3QvjbSJ0vpl2q0TLs9nay6LYzguw36BplT1hP7ljU" +
       "NF4v+VUKI9vtBB+O7HHTJueWt1mZUqsFr8f9TX8AO8uUIhOOqumeigjbUZ8d" +
       "o3KnJ2gy1Sebg1rGMx2gyUxqUiIjYsPFghRnfGIkfrfV8eRGyPJ81oyb0yaE" +
       "4mi4SUSHlnGUh4VpXca6bkc0Ki1cc1OxwyVtnBiHPBDzYezQtcliSc+jVBmy" +
       "CoYadURp+qIeiR6tG+aCWBP2pCpItoNKlNJqp1G9Wm3Ol7OJQPkby+V6TadL" +
       "x1Rj3AWyQo37C6svbmt2e8E6S6uuRobT3fQgE2Xrc6sX1mG33EIUYcgG6KhK" +
       "eeWZvRGmjMkw4RC1yBDGkK5eWTPxQBVWoq8vFDIxG32dXhvWXBPqUBKSDC66" +
       "AjmuYgPUFRE/QSRCbHWxmOrxI8pZ9vAs6fecRk2pSK66HnIVebTm0Y1ZV62W" +
       "UDHKPj8mHTzraWYPbQWykIpNhVcjYd1MKjIhGxmrp7xmpS2fFfCpmQ6x8npF" +
       "bjqTmgOUAhdrZUbe9HB1iKZsIuDSAEqXI1yI4c3Gn802NqpzqO/VkW5lDQ2w" +
       "LT1X2VmHp/szQm3VU2k9qHZUJu3OJiM+4OFeEodbc96B3K4ygttGjcOV5RIy" +
       "WiGMiMbcojstW6OzLTWuNUdVZz0RGiO+L9pjLq1rCho1FUOvD/rl/nribio8" +
       "MRzyqW9bApp1W/K8D8OOEixx0+mlYynwBbg9oBGwnETHm9HyNtAmG6E5IY21" +
       "CFQQF7BkWVeIHmZuJ/wEa6gMUt0m5abRNbVEQYZ4X9fac5LbjkaZ52mE1lhg" +
       "g9F8oTSQLEM0DukybQ1jiT4TCMD8yn1ukCVUbWxwlIWO0Lgy49xGq7lBYVZr" +
       "lSmRj1ohmVgKRHkNt1KlcmUdDic45nkByquzpetmPtzjvUkWNJHOQCkbgUkD" +
       "MdJobaZzjVFzDZWpij6nmEXUkWRGi5TVwtYHVE1m/EaWalkZXbtRw+6M5Lk2" +
       "x2lK0Px1m0o7Xi2lPDjrKqTXmtjx3DdqQzKOkbkztOsZTTFhpTcM4a5EgI1n" +
       "uvBWUH1gN6Uq1tCggRVRnEMQfZRb0B1B7pJ9Tp5Ei4UtKtNht+suyIG/0KhF" +
       "taEF1YBsWhOyG48woFyYVJ1mGdyt6PKyBbuVDl1xa4gzLhOVeXPc4WIjaCjN" +
       "CJ0tTdqUzDEwpEyrq3WyjchWqhN7TdbbC82Yc06XQ9tl3Fm3RZ+1GgMaQ2gp" +
       "mFd001pTKbFwvbnhJL2Z7/btcf5tn1/Ws6E+D6ZtV1n1ulnA2tlsNqs5mLFZ" +
       "bhqtQVrRjHI0x7oKhDXCSB3ATQv1wRoGjktSci/jhc5oCAldjIf5UCSzYbyZ" +
       "cOVwom+k5pZYDai24I7TpLVOex4+41qanaFNBas0sXIwmyDtqrCO3bmwUTYC" +
       "wvcTKZ1kWzxymVGnFVEtrG5KyxbDVivEOJmu1xIGC9qmt5xueT9KxzY9gOfG" +
       "PEWaZjkwuC7Fzur0Uu1kdG2sreZxi5wnDdIZEdsK0VTLGN2NkRUXDhajqqt1" +
       "uTGkBjEmCQTbheIZlK4nbK1axZv6gOhWKmWIJtLGMoSSiNK2PW7UEOfpHFda" +
       "cK2rNTtE5BimXI+gLq9WXFkagpBl0/VYZewI+nLp84PxRBGQPpooWcU1vTIr" +
       "2C2tNmrWfXve7KlQ3zXabAB1mrEJDebiaIPgXa6/CvA5W+fUVbc9hxt2rw8t" +
       "GiMpGEbcZgMP1skKn8JduoVqwizDenS9g1d4Y9axZ9NOA6d8ejio6Gl7Wo/W" +
       "en2MuJNtM+6Wt1J9jVaJBYQQFFtTsS1BlltbzqYTxDcHUw6ZobEL6TAvts3Q" +
       "A5ZzO5k0Ul/B9K5RJdfp1va3ttgYhOtJVhUHEOY2yzzUFttDfEGQMT1z1g5w" +
       "gLoOp2aZW4V7wEINhCiNuRE2X6SrJTNau8YWL7dQpIoJxAZbVHWynVX7PYxE" +
       "xPKS7FuOp463kA1BfFzvsw4IczrWOG5zqsqVCS11HcdBbAebtUcp1GGcLbJZ" +
       "ZnGDD2e2HirlltoodyneaCRgOzVh1dSmozou87Vk2FK2JMxu445AIIbJIzjn" +
       "KFGyGSuZ48lDc6vPFL5cm7BxG+vPnZqxCplU4bcYpMUKKzdMjqnUvHXP7/Di" +
       "UIzbUKIw9WFnxnelKq0M+mwFYhUvQpsyBAxQG7KisdLmLIqTtyGGwBsSTtZM" +
       "iAzQ9hBSthLDtTCYkQ27vlJtJOQaUEVTu3K0JGYxQTS6yAoqS5jKclqlI9uU" +
       "ulBXJjVpOwsRnoj2trbFkUUsjnUmoIVWS+osli7cT1JDC+sK71Qt00XGZm24" +
       "BfaD2narwzq/kmceXJ+vw7TG+gwynKIjhOBUN/S4TtvQ5UzoIfTIGVlZVN2O" +
       "p5tataVteWyCE5zfR5spEZChlLaZmW5PHJFs1sdlbaTA2nzjaspmSxGBVDfZ" +
       "iYry5Lgy3PK02WXxxSocR6t+7A/H8UwfMWO1xzBNaFpm4dVwOlVcahL1lSk6" +
       "0WzFa1Qlv7r0t+2xFqhrtIe0+WU72CbioIMw/bCBGgq/DO01EF4co5VaZyqk" +
       "zLJMepEgshRVITarBI3m3MLhQkUe+Vu/z281AlsOyoSNZyZddXBnOJ7ylEhN" +
       "HT1EKoAiDUb5UaOrU/QMSYKuvBn5CrJFKDw21nRvhmga3QmXdo+T6lEgwZPN" +
       "VpfMFSU75KbedjWiN95GSBu1l6NqT/bgrk0TsIBhcnmQbj2wM3BlcxRYuNqF" +
       "MWtWC8sIPi2LyxUOsYtFI4h9o5fI6oZFLLdRHSU2NUeZpWebRgXjIB7NKpCZ" +
       "iX1SGWjYym3ERuJWaj0ML7OqZphQA2IzZj1jOkQz9CgMYckug9HMQjVVCGxu" +
       "/EL0ccmt8oonCyGBbTB8pCA87SzwdbOhsqmCGx6MNhEJnlYqI36uGRZN6qiB" +
       "4rO1v6hv3V46jWpTKetN3PJUplh6QgTBcpYNKpOukTKVFV0l0JnLLGB5PV9u" +
       "N9jQx9tm3WlVKpaXtax0jY7srYSkNUNpISC4EpZlAo2bM6ZFKWwTY/u97syq" +
       "KwZLMEpz0TGaVmttqyk3zzAswdar5XYuJZwZddEQFm2UqogqLAbYbNCPNG20" +
       "6VLDIVVXOYONhcUk6Ex5RN/CekApjWQFQcicHZSrKMay7CxIdbPOm9NwupC2" +
       "QJGJCB/oMLydIkvJxNtNklrjIkMlAzXt8ewqhpS5I3bQhdDeDlQMqRgY35zx" +
       "3JbXmSGMRetRzSr3+0SNtr0OWq6bHgEvVjjGtKx+PVwzvSlGruCZ1et5crMj" +
       "LF0qExarRKMFI6hN+QjyO9pQabnNwE/NboWL47XBUyOBtYdOY1BvznHeaGXO" +
       "ZNHENA4bu0JlWJt14U3Mk33fMDcjlGh5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "7WW/8rp//uxXiy+8/j9SGmNMS0cAAA==");
}
