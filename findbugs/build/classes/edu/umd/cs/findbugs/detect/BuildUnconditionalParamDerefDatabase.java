package edu.umd.cs.findbugs.detect;
public abstract class BuildUnconditionalParamDerefDatabase implements edu.umd.cs.findbugs.Detector {
    public static final boolean VERBOSE_DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug.nullarg.verbose");
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug.nullarg") ||
      VERBOSE_DEBUG;
    public final edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<javax.annotation.Nonnull>
      nonnullTypeQualifierValue;
    protected abstract void reportBug(edu.umd.cs.findbugs.BugInstance bug);
    public BuildUnconditionalParamDerefDatabase() { super(
                                                      );
                                                    this.
                                                      nonnullTypeQualifierValue =
                                                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                                                        getValue(
                                                          javax.annotation.Nonnull.class,
                                                          null);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        boolean fullAnalysis =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getBoolProperty(
            edu.umd.cs.findbugs.FindBugsAnalysisFeatures.
              INTERPROCEDURAL_ANALYSIS_OF_REFERENCED_CLASSES);
        if (!fullAnalysis &&
              !edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              isApplicationClass(
                classContext.
                  getJavaClass(
                    ))) {
            return;
        }
        if (VERBOSE_DEBUG) {
            java.lang.System.
              out.
              println(
                "Visiting class " +
                classContext.
                  getJavaClass(
                    ).
                  getClassName(
                    ));
        }
        for (org.apache.bcel.classfile.Method m
              :
              classContext.
               getMethodsInCallOrder(
                 )) {
            considerMethod(
              classContext,
              m);
        }
    }
    private void considerMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                org.apache.bcel.classfile.Method method) {
        boolean hasReferenceParameters =
          false;
        for (org.apache.bcel.generic.Type argument
              :
              method.
               getArgumentTypes(
                 )) {
            if (argument instanceof org.apache.bcel.generic.ReferenceType) {
                hasReferenceParameters =
                  true;
            }
        }
        if (hasReferenceParameters &&
              classContext.
              getMethodGen(
                method) !=
              null) {
            if (VERBOSE_DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Check " +
                    method);
            }
            analyzeMethod(
              classContext,
              method);
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method) {
        org.apache.bcel.classfile.JavaClass jclass =
          classContext.
          getJavaClass(
            );
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            jclass,
            method);
        try {
            edu.umd.cs.findbugs.ba.CFG cfg =
              classContext.
              getCFG(
                method);
            edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow =
              classContext.
              getValueNumberDataflow(
                method);
            edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefDataflow dataflow =
              classContext.
              getUnconditionalValueDerefDataflow(
                method);
            edu.umd.cs.findbugs.ba.SignatureParser parser =
              new edu.umd.cs.findbugs.ba.SignatureParser(
              method.
                getSignature(
                  ));
            int paramLocalOffset =
              method.
              isStatic(
                )
              ? 0
              : 1;
            java.util.BitSet unconditionalDerefSet =
              new java.util.BitSet(
              );
            edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefSet entryFact =
              dataflow.
              getResultFact(
                cfg.
                  getEntry(
                    ));
            java.util.Iterator<java.lang.String> paramIterator =
              parser.
              parameterSignatureIterator(
                );
            int i =
              0;
            while (paramIterator.
                     hasNext(
                       )) {
                java.lang.String paramSig =
                  paramIterator.
                  next(
                    );
                edu.umd.cs.findbugs.ba.vna.ValueNumber paramVN =
                  vnaDataflow.
                  getAnalysis(
                    ).
                  getEntryValue(
                    paramLocalOffset);
                handleParameter: if (entryFact.
                                       isUnconditionallyDereferenced(
                                         paramVN)) {
                    edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation directTypeQualifierAnnotation =
                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                      getDirectTypeQualifierAnnotation(
                        xmethod,
                        i,
                        nonnullTypeQualifierValue);
                    edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation typeQualifierAnnotation =
                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                      getEffectiveTypeQualifierAnnotation(
                        xmethod,
                        i,
                        nonnullTypeQualifierValue);
                    boolean implicitNullCheckForEquals =
                      false;
                    if (directTypeQualifierAnnotation ==
                          null &&
                          "equals".
                          equals(
                            method.
                              getName(
                                )) &&
                          "(Ljava/lang/Object;)Z".
                          equals(
                            method.
                              getSignature(
                                )) &&
                          !method.
                          isStatic(
                            )) {
                        implicitNullCheckForEquals =
                          true;
                        org.apache.bcel.classfile.Code code =
                          method.
                          getCode(
                            );
                        org.apache.bcel.classfile.ConstantPool cp =
                          jclass.
                          getConstantPool(
                            );
                        byte[] codeBytes =
                          code.
                          getCode(
                            );
                        for (org.apache.bcel.classfile.CodeException e
                              :
                              code.
                               getExceptionTable(
                                 )) {
                            org.apache.bcel.classfile.ConstantClass cl =
                              (org.apache.bcel.classfile.ConstantClass)
                                cp.
                                getConstant(
                                  e.
                                    getCatchType(
                                      ));
                            int endPC =
                              e.
                              getEndPC(
                                );
                            int startPC =
                              e.
                              getStartPC(
                                );
                            int handlerPC =
                              e.
                              getHandlerPC(
                                );
                            if (startPC ==
                                  0 &&
                                  endPC +
                                  1 ==
                                  handlerPC &&
                                  handlerPC ==
                                  codeBytes.
                                    length -
                                  3 &&
                                  (codeBytes[handlerPC +
                                               1] &
                                     255) ==
                                  org.apache.bcel.Constants.
                                    ICONST_0 &&
                                  (codeBytes[handlerPC +
                                               2] &
                                     255) ==
                                  org.apache.bcel.Constants.
                                    IRETURN &&
                                  edu.umd.cs.findbugs.detect.FindNullDeref.
                                    catchTypesForNull.
                                  contains(
                                    cl.
                                      getBytes(
                                        cp))) {
                                return;
                            }
                        }
                        typeQualifierAnnotation =
                          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
                            getValue(
                              nonnullTypeQualifierValue,
                              javax.annotation.meta.When.
                                MAYBE);
                    }
                    if (typeQualifierAnnotation !=
                          null &&
                          typeQualifierAnnotation.
                            when ==
                          javax.annotation.meta.When.
                            ALWAYS) {
                        unconditionalDerefSet.
                          set(
                            i);
                    }
                    else
                        if (isCaught(
                              classContext,
                              method,
                              entryFact,
                              paramVN)) {
                            
                        }
                        else
                            if (typeQualifierAnnotation ==
                                  null) {
                                unconditionalDerefSet.
                                  set(
                                    i);
                            }
                            else {
                                int paramLocal =
                                  xmethod.
                                  isStatic(
                                    )
                                  ? i
                                  : i +
                                  1;
                                int priority =
                                  edu.umd.cs.findbugs.Priorities.
                                    NORMAL_PRIORITY;
                                if (typeQualifierAnnotation.
                                      when !=
                                      javax.annotation.meta.When.
                                        UNKNOWN) {
                                    priority--;
                                }
                                if (xmethod.
                                      isStatic(
                                        ) ||
                                      xmethod.
                                      isFinal(
                                        ) ||
                                      xmethod.
                                      isPrivate(
                                        ) ||
                                      "<init>".
                                      equals(
                                        xmethod.
                                          getName(
                                            )) ||
                                      jclass.
                                      isFinal(
                                        )) {
                                    priority--;
                                }
                                if (directTypeQualifierAnnotation ==
                                      null) {
                                    priority++;
                                }
                                java.lang.String bugPattern =
                                  implicitNullCheckForEquals
                                  ? "NP_EQUALS_SHOULD_HANDLE_NULL_ARGUMENT"
                                  : "NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE";
                                reportBug(
                                  new edu.umd.cs.findbugs.BugInstance(
                                    this,
                                    bugPattern,
                                    priority).
                                    addClassAndMethod(
                                      jclass,
                                      method).
                                    add(
                                      edu.umd.cs.findbugs.LocalVariableAnnotation.
                                        getParameterLocalVariableAnnotation(
                                          method,
                                          paramLocal)));
                            }
                }
                i++;
                if ("D".
                      equals(
                        paramSig) ||
                      "J".
                      equals(
                        paramSig)) {
                    paramLocalOffset +=
                      2;
                }
                else {
                    paramLocalOffset +=
                      1;
                }
            }
            if (unconditionalDerefSet.
                  isEmpty(
                    )) {
                if (VERBOSE_DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "\tResult is empty");
                }
                return;
            }
            if (VERBOSE_DEBUG) {
                edu.umd.cs.findbugs.ba.ClassContext.
                  dumpDataflowInformation(
                    method,
                    cfg,
                    vnaDataflow,
                    classContext.
                      getIsNullValueDataflow(
                        method),
                    dataflow,
                    classContext.
                      getTypeDataflow(
                        method));
            }
            edu.umd.cs.findbugs.ba.interproc.ParameterProperty property =
              new edu.umd.cs.findbugs.ba.interproc.ParameterProperty(
              );
            property.
              setParamsWithProperty(
                unconditionalDerefSet);
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getUnconditionalDerefParamDatabase(
                ).
              setProperty(
                xmethod.
                  getMethodDescriptor(
                    ),
                property);
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Unconditional deref: " +
                    xmethod +
                    "=" +
                    property);
            }
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getLookupFailureCallback(
                ).
              logError(
                "Error analyzing " +
                xmethod +
                " for unconditional deref training",
                e);
        }
    }
    public boolean isCaught(edu.umd.cs.findbugs.ba.ClassContext classContext,
                            org.apache.bcel.classfile.Method method,
                            edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefSet entryFact,
                            edu.umd.cs.findbugs.ba.vna.ValueNumber paramVN) {
        boolean caught =
          true;
        java.util.Set<edu.umd.cs.findbugs.ba.Location> dereferenceSites =
          entryFact.
          getDerefLocationSet(
            paramVN);
        if (dereferenceSites !=
              null &&
              !dereferenceSites.
              isEmpty(
                )) {
            org.apache.bcel.classfile.ConstantPool cp =
              classContext.
              getJavaClass(
                ).
              getConstantPool(
                );
            for (edu.umd.cs.findbugs.ba.Location loc
                  :
                  dereferenceSites) {
                if (!edu.umd.cs.findbugs.detect.FindNullDeref.
                      catchesNull(
                        cp,
                        method.
                          getCode(
                            ),
                        loc)) {
                    caught =
                      false;
                }
            }
        }
        return caught;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "N/wPgzvy1qIXntA8/opv8/8DWU3kvrokAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "q5Eqr78+8cGXXpann6wdHJ10TqLKvZHr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/bilJIp15nt33/lqZlKWiJ1esP7hB7/15Pzd2vteR9nI0xfovIjyNyaf+vzg" +
       "HdIvHVQun1y33lS8dh7o+QvH24ESxYEzP3fV+pYT8T9eSLsFHvJI/OTFm65T" +
       "7d+sViA3L3ALsSvl4fnH95Z0oWbg0nnlPX0r5XXj7TEDJY5P36Hu4HeK5tfB" +
       "twPFc4MIgN7y0DRxdfnUan/j1c5Lz36l7Pjk+fqWd4FndiSk2esQ0qXS9l+L" +
       "YN52m9ul0niPiixLPP/yDsL5g6L558CXyyuks6DFwO+eCuT3zgvkgROBnNDz" +
       "6Onx9zRRgkCXlTt4/qtK8YFj87pxJMUbr1eK/C2leHAaYl45Jv0ZN9geCp4g" +
       "acqhKCnWYVkWW1T7HblYienf30GOXy6aL0SVh4pCCMB5sIe7IMQv/gBWVcpj" +
       "CB73SB7uD18eRfOlctbX7sDrN4rmK1HlQcERrCxXbsnqn/wArD5WdP4oeL56" +
       "xOpXfzgOdFc54a5TVo/1j97GleSikvDwXIVheU9bVhhySnQM/47bwCeOcFgC" +
       "7O+DSqK+dQfJfqdo/itY+PQQF+KtVjrh+FSo/+31CDWNKtdfS4VkUe71xE2l" +
       "3PvyY+nTL1+75/GXF/+pLBI8KRG+l6rco8aWdbY658z7FQ+g10uO7t3X6njl" +
       "v7+IKk/evpwzqlzZv5ScfG8P8pdR5bFbgAARHb+enf1XUeW+09lR5UA6O3yp" +
       "ElWuHg1HlcugPTt4GXSBweL1Lu8Wl4j7Mqb00rmLz1PVPPpqqjkBOVtlePEO" +
       "fhLvy+1vSJ95eUT/9Hdbn9xXOYJ4lOcFlnuoytV9weVJUvDsbbEd47oyfO77" +
       "D/32vW8/TmAe2hN86kRnaHv61iWFhO1FZRFg/s8e/913/ZOXv1beaf5f7t2M" +
       "xgUxAAA=");
}
