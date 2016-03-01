package edu.umd.cs.findbugs.ba.jsr305;
public abstract class TypeQualifierDataflowAnalysis extends edu.umd.cs.findbugs.ba.AbstractDataflowAnalysis<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet> {
    static java.lang.String primitiveType(java.lang.String simpleClass) {
        if ("Integer".
              equals(
                simpleClass)) {
            return "int";
        }
        return simpleClass.
          toLowerCase(
            );
    }
    static boolean isIdentifyFunctionForTypeQualifiers(edu.umd.cs.findbugs.ba.XMethod m) {
        java.lang.String className =
          m.
          getClassName(
            );
        if (!className.
              startsWith(
                "java.lang")) {
            return false;
        }
        java.lang.String methodName =
          m.
          getName(
            );
        if (m.
              isStatic(
                )) {
            if (!"valueOf".
                  equals(
                    methodName)) {
                return false;
            }
            java.lang.String signature =
              m.
              getSignature(
                );
            if (signature.
                  charAt(
                    2) !=
                  ')') {
                return false;
            }
        }
        else {
            java.lang.String simpleClassName =
              edu.umd.cs.findbugs.util.ClassName.
              extractSimpleName(
                className);
            if (!methodName.
                  equals(
                    primitiveType(
                      simpleClassName) +
                    "Value")) {
                return false;
            }
            java.lang.String signature =
              m.
              getSignature(
                );
            if (signature.
                  charAt(
                    1) !=
                  ')') {
                return false;
            }
        }
        return true;
    }
    static final boolean DEBUG_VERBOSE = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.dataflow.debug.verbose");
    protected final edu.umd.cs.findbugs.ba.XMethod xmethod;
    protected final edu.umd.cs.findbugs.ba.CFG cfg;
    protected final edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow
      vnaDataflow;
    protected final edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>
      typeQualifierValue;
    protected final org.apache.bcel.generic.ConstantPoolGen cpg;
    private final java.util.Map<edu.umd.cs.findbugs.ba.Location,java.util.Set<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo>>
      sourceSinkMap;
    public TypeQualifierDataflowAnalysis(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                         edu.umd.cs.findbugs.ba.CFG cfg,
                                         edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow,
                                         org.apache.bcel.generic.ConstantPoolGen cpg,
                                         edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        super(
          );
        this.
          xmethod =
          xmethod;
        this.
          cfg =
          cfg;
        this.
          vnaDataflow =
          vnaDataflow;
        this.
          cpg =
          cpg;
        this.
          typeQualifierValue =
          typeQualifierValue;
        this.
          sourceSinkMap =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.Location,java.util.Set<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo>>(
            );
    }
    @java.lang.Override
    public void initEntryFact(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet result)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        result.
          makeValid(
            );
    }
    @java.lang.Override
    public boolean isFactValid(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact) {
        return fact.
          isValid(
            );
    }
    @java.lang.Override
    public void copy(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet source,
                     edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet dest) {
        dest.
          makeSameAs(
            source);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet createFact() {
        return new edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet(
          typeQualifierValue);
    }
    @java.lang.Override
    public boolean isTop(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact) {
        return fact.
          isTop(
            );
    }
    @java.lang.Override
    public void makeFactTop(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact) {
        fact.
          setTop(
            );
    }
    @java.lang.Override
    public void meetInto(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact,
                         edu.umd.cs.findbugs.ba.Edge edge,
                         edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet result)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (fact.
              isTop(
                ) ||
              result.
              isBottom(
                )) {
            return;
        }
        else
            if (fact.
                  isBottom(
                    ) ||
                  result.
                  isTop(
                    )) {
                result.
                  makeSameAs(
                    fact);
                return;
            }
        assert fact.
          isValid(
            );
        assert result.
          isValid(
            );
        result.
          mergeWith(
            fact);
    }
    @java.lang.Override
    public boolean same(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact1,
                        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact2) {
        return fact1.
          equals(
            fact2);
    }
    @java.lang.Override
    public void edgeTransfer(edu.umd.cs.findbugs.ba.Edge edge,
                             edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (!fact.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame targetVnaFrame =
          vnaDataflow.
          getStartFact(
            edge.
              getTarget(
                ));
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame sourceVnaFrame =
          vnaDataflow.
          getResultFact(
            edge.
              getSource(
                ));
        if (!targetVnaFrame.
              isValid(
                ) ||
              !sourceVnaFrame.
              isValid(
                )) {
            return;
        }
        int numSlotsToMerge =
          java.lang.Math.
          min(
            sourceVnaFrame.
              getNumSlots(
                ),
            targetVnaFrame.
              getNumSlots(
                ));
        for (int i =
               0;
             i <
               numSlotsToMerge;
             i++) {
            edu.umd.cs.findbugs.ba.vna.ValueNumber targetVN =
              targetVnaFrame.
              getValue(
                i);
            edu.umd.cs.findbugs.ba.vna.ValueNumber sourceVN =
              sourceVnaFrame.
              getValue(
                i);
            if (!targetVN.
                  equals(
                    sourceVN) &&
                  targetVN.
                  hasFlag(
                    edu.umd.cs.findbugs.ba.vna.ValueNumber.
                      PHI_NODE)) {
                if (DEBUG_VERBOSE) {
                    java.lang.System.
                      out.
                      println(
                        "Phi node: " +
                        fact.
                          valueNumberToString(
                            sourceVN) +
                        " -> " +
                        fact.
                          valueNumberToString(
                            targetVN));
                }
                propagateAcrossPhiNode(
                  fact,
                  sourceVN,
                  targetVN);
                if (DEBUG_VERBOSE) {
                    java.lang.String dir =
                      isForwards(
                        )
                      ? "forwards"
                      : "backwards";
                    java.lang.System.
                      out.
                      println(
                        "After propagating phi node " +
                        dir +
                        ": " +
                        fact.
                          toString(
                            ));
                }
            }
        }
    }
    protected abstract void propagateAcrossPhiNode(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact,
                                                   edu.umd.cs.findbugs.ba.vna.ValueNumber sourceVN,
                                                   edu.umd.cs.findbugs.ba.vna.ValueNumber targetVN);
    public abstract void registerSourceSinkLocations()
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException;
    protected void registerSourceSink(edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo sourceSinkInfo) {
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> set =
          sourceSinkMap.
          get(
            sourceSinkInfo.
              getLocation(
                ));
        if (set ==
              null) {
            set =
              new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo>(
                );
            sourceSinkMap.
              put(
                sourceSinkInfo.
                  getLocation(
                    ),
                set);
        }
        set.
          add(
            sourceSinkInfo);
    }
    public java.util.Set<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> getSourceSinkInfoSet(edu.umd.cs.findbugs.ba.Location location) {
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> result =
          sourceSinkMap.
          get(
            location);
        return result !=
          null
          ? result
          : java.util.Collections.
          <edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo>
        emptySet(
          );
    }
    @java.lang.Override
    public void transferInstruction(org.apache.bcel.generic.InstructionHandle handle,
                                    edu.umd.cs.findbugs.ba.BasicBlock basicBlock,
                                    edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet fact)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (!fact.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.Location location =
          new edu.umd.cs.findbugs.ba.Location(
          handle,
          basicBlock);
        org.apache.bcel.generic.Instruction i =
          handle.
          getInstruction(
            );
        if (i instanceof org.apache.bcel.generic.InvokeInstruction) {
            org.apache.bcel.generic.InvokeInstruction ii =
              (org.apache.bcel.generic.InvokeInstruction)
                i;
            edu.umd.cs.findbugs.ba.XMethod m =
              edu.umd.cs.findbugs.ba.XFactory.
              createXMethod(
                ii,
                cpg);
            if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierDataflowAnalysis.
                  isIdentifyFunctionForTypeQualifiers(
                    m)) {
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrameAtLocation =
                  vnaDataflow.
                  getFactAtLocation(
                    location);
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrameAfterInstruction =
                  vnaDataflow.
                  getFactAfterLocation(
                    location);
                edu.umd.cs.findbugs.ba.vna.ValueNumber in =
                  vnaFrameAtLocation.
                  getStackValue(
                    0);
                edu.umd.cs.findbugs.ba.vna.ValueNumber out =
                  vnaFrameAfterInstruction.
                  getStackValue(
                    0);
                fact.
                  copyInfo(
                    in,
                    out);
                return;
            }
        }
        java.util.Set<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> sourceSinkSet =
          sourceSinkMap.
          get(
            location);
        if (sourceSinkSet !=
              null) {
            if (DEBUG_VERBOSE) {
                java.lang.System.
                  out.
                  println(
                    "Modeling source/sink at " +
                    location.
                      toCompactString(
                        ) +
                    ": " +
                    sourceSinkSet.
                      toString(
                        ));
            }
            for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo sourceSinkInfo
                  :
                  sourceSinkSet) {
                fact.
                  modelSourceSink(
                    sourceSinkInfo);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AT1du+YTPAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0+/YbiQL7rQ5GLUkfAMR3W59PNsE5kzA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "7B0HKt/xklNZLQd89XIqr5TD/jauPGVHQ033YtvYkYlXnpYm/fDc+bISPjml" +
       "/StfA+3lOfnroHzfgfbvu13a33or2o8fRKK3e7iW0+OSLQ/cet7LDu1efEOj" +
       "l6l6UD60LSa9VlR3A42yPTvueXG4K06+3vQxYurb2gmnr9xzntMPnnD6BKFH" +
       "zxzwS/UwtDX9Fq7uxanmG0H54EE8H3xJxVPQ9GDJkidvoZpPFdXr48oDdlTw" +
       "CcjH1s6r4JU3XMqYovc1XwsLSg0dg/KRAws+8tKw4OrJtnLlwVM+HN2CD8UT" +
       "+ivPAKVQ/WBXXD92yoC3vXwMeLJohED52IEBH3tpGHCWtOu36HtHUTXiyv1q" +
       "qMuxXqhAya9T4vGXj/jSAF4DyqcPxH/6ZTKAwS04QBVVN67cZUdzP7ig+sTL" +
       "rPo4KL90IP6XXibiF7cgXigqFli/K69L4e9ZcFb5py8zC4ojj587sOBzLw0L" +
       "7jiJYg+KDHz36y7ZTHqaqZ/ySrmcmY+UA4yiejeIVF1dj4de7F/g1nteZmt5" +
       "HJQvHbj1pZeGWzf3lZtbaE3ReAWEo3dGh2DzjMW4L7O6FKcD//zAgD9/yRmg" +
       "njLg219IFYrTj1d2ceVBHajQPJS9yCiPnp9Vh/zl40ahCZUczPToHnr//0Vy" +
       "4/T45h+9aAv6+hf3Nl0B8/0lgz5wCxX6oaL6nrjy6iD0A9kEW09bDf0oYi17" +
       "7Gv6BTa+/2sIgsuTriABuPJ1Bz593e3y6a2X8+ksST/xQgrzz4rqOeCKQt20" +
       "o1gPT88yHh87jC4Q/sGvgfCHi0YCYPC6A+Gvu11zed8LZT7/rqTro7dgyk8X" +
       "1UdA6Px8mi+Q+oJnKm9BapHFVlCA1NsPpL79pfEMZ0j95ZKcn7sFqf+qqD4e" +
       "V15p6vH5U6qHQ7U/d0rsJ77WrK44bXn9QOz1l4bYg80fm/szl70FOzy8Lw7U" +
       "dSB7mqMfQzx5iYPoyJGtdhxfXZ961198IWP5laL6hbjyWHzwrGeWvaA5/+Yl" +
       "dLJZXHnDLT8HULxu+Zrnfatk/30N9ZMfvnbv4x9e/G75RvzJNzDuYyr3Gonj" +
       "nH3X58z13UGoG3Ypkvv2b/6UR6SvfB6gcsvMOq7cvb8ovcbn9lC/BXzqzaHi" +
       "ylVFPjv0twF3bzIUBDfHl2dH/w5IEk5Hg8nUc92/G1fuOXTHlTtAfbbzD0AT" +
       "6Cwu//Dc8ftjWRQfuHjrXkD7/3HFeMle42sfbipe9lGLv6eVTs6ew5dI9TLo" +
       "gm1fKoFf1IF88Bs++MPzPC3m+UIZ3n/x5HT8lS8Vp+PvPOR9FTHbm+iFFxev" +
       "nPt5YnmVR1/IjZ25L/vUpa87j5L9Z4FuqJ/6MDX+1i83Prr/MoPqyHlezHIv" +
       "U7ln/5GIctLi7umTl852PNfdg2e+8vDP3veW4zu9D+8RPvWNZ3B74uafQei5" +
       "QVx+uCD/hcc//U0//eEvlOfc/y+iEQDhrUkAAA==");
}
