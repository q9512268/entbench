package edu.umd.cs.findbugs.detect;
public class StreamResourceTracker implements edu.umd.cs.findbugs.ba.ResourceTracker<edu.umd.cs.findbugs.detect.Stream> {
    private final edu.umd.cs.findbugs.detect.StreamFactory[] streamFactoryList;
    private final edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback;
    private edu.umd.cs.findbugs.ResourceCollection<edu.umd.cs.findbugs.detect.Stream>
      resourceCollection;
    private final java.util.Map<edu.umd.cs.findbugs.ba.Location,edu.umd.cs.findbugs.detect.Stream>
      streamOpenLocationMap;
    private final java.util.HashSet<edu.umd.cs.findbugs.detect.Stream>
      uninterestingStreamEscapeSet;
    private final java.util.TreeSet<edu.umd.cs.findbugs.detect.StreamEscape>
      streamEscapeSet;
    private final java.util.Map<edu.umd.cs.findbugs.detect.Stream,edu.umd.cs.findbugs.detect.StreamEquivalenceClass>
      streamEquivalenceMap;
    public StreamResourceTracker(edu.umd.cs.findbugs.detect.StreamFactory[] streamFactoryList,
                                 edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback) {
        super(
          );
        this.
          streamFactoryList =
          streamFactoryList;
        this.
          lookupFailureCallback =
          lookupFailureCallback;
        this.
          streamOpenLocationMap =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.Location,edu.umd.cs.findbugs.detect.Stream>(
            );
        this.
          uninterestingStreamEscapeSet =
          new java.util.HashSet<edu.umd.cs.findbugs.detect.Stream>(
            );
        this.
          streamEscapeSet =
          new java.util.TreeSet<edu.umd.cs.findbugs.detect.StreamEscape>(
            );
        this.
          streamEquivalenceMap =
          new java.util.HashMap<edu.umd.cs.findbugs.detect.Stream,edu.umd.cs.findbugs.detect.StreamEquivalenceClass>(
            );
    }
    public void setResourceCollection(edu.umd.cs.findbugs.ResourceCollection<edu.umd.cs.findbugs.detect.Stream> resourceCollection) {
        this.
          resourceCollection =
          resourceCollection;
    }
    public void addStreamEscape(edu.umd.cs.findbugs.detect.Stream source,
                                edu.umd.cs.findbugs.ba.Location target) {
        edu.umd.cs.findbugs.detect.StreamEscape streamEscape =
          new edu.umd.cs.findbugs.detect.StreamEscape(
          source,
          target);
        streamEscapeSet.
          add(
            streamEscape);
        if (edu.umd.cs.findbugs.detect.FindOpenStream.
              DEBUG) {
            java.lang.System.
              out.
              println(
                "Adding potential stream escape " +
                streamEscape);
        }
    }
    public void markTransitiveUninterestingStreamEscapes() {
        for (java.util.Iterator<edu.umd.cs.findbugs.detect.StreamEscape> i =
               streamEscapeSet.
               iterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.detect.StreamEscape streamEscape =
              i.
              next(
                );
            if (!isStreamOpenLocation(
                   streamEscape.
                     target)) {
                if (edu.umd.cs.findbugs.detect.FindOpenStream.
                      DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Eliminating false stream escape " +
                        streamEscape);
                }
                i.
                  remove(
                    );
            }
        }
        for (java.util.Iterator<edu.umd.cs.findbugs.detect.Stream> i =
               resourceCollection.
               resourceIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.detect.Stream stream =
              i.
              next(
                );
            edu.umd.cs.findbugs.detect.StreamEquivalenceClass equivalenceClass =
              new edu.umd.cs.findbugs.detect.StreamEquivalenceClass(
              );
            equivalenceClass.
              addMember(
                stream);
            streamEquivalenceMap.
              put(
                stream,
                equivalenceClass);
        }
        java.util.Set<edu.umd.cs.findbugs.detect.Stream> orig =
          new java.util.HashSet<edu.umd.cs.findbugs.detect.Stream>(
          );
        do  {
            orig.
              clear(
                );
            orig.
              addAll(
                uninterestingStreamEscapeSet);
            for (edu.umd.cs.findbugs.detect.StreamEscape streamEscape
                  :
                  streamEscapeSet) {
                if (isUninterestingStreamEscape(
                      streamEscape.
                        source)) {
                    if (edu.umd.cs.findbugs.detect.FindOpenStream.
                          DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Propagating stream escape " +
                            streamEscape);
                    }
                    edu.umd.cs.findbugs.detect.Stream target =
                      streamOpenLocationMap.
                      get(
                        streamEscape.
                          target);
                    if (target ==
                          null) {
                        throw new java.lang.IllegalStateException(
                          );
                    }
                    uninterestingStreamEscapeSet.
                      add(
                        target);
                    edu.umd.cs.findbugs.detect.StreamEquivalenceClass sourceClass =
                      streamEquivalenceMap.
                      get(
                        streamEscape.
                          source);
                    edu.umd.cs.findbugs.detect.StreamEquivalenceClass targetClass =
                      streamEquivalenceMap.
                      get(
                        target);
                    if (sourceClass !=
                          targetClass) {
                        sourceClass.
                          addAll(
                            targetClass);
                        for (java.util.Iterator<edu.umd.cs.findbugs.detect.Stream> j =
                               targetClass.
                               memberIterator(
                                 );
                             j.
                               hasNext(
                                 );
                             ) {
                            edu.umd.cs.findbugs.detect.Stream stream =
                              j.
                              next(
                                );
                            streamEquivalenceMap.
                              put(
                                stream,
                                sourceClass);
                        }
                    }
                }
            }
        }while(!orig.
                 equals(
                   uninterestingStreamEscapeSet)); 
    }
    public boolean isUninterestingStreamEscape(edu.umd.cs.findbugs.detect.Stream stream) {
        return uninterestingStreamEscapeSet.
          contains(
            stream);
    }
    public void addStreamOpenLocation(edu.umd.cs.findbugs.ba.Location streamOpenLocation,
                                      edu.umd.cs.findbugs.detect.Stream stream) {
        if (edu.umd.cs.findbugs.detect.FindOpenStream.
              DEBUG) {
            java.lang.System.
              out.
              println(
                "Stream open location at " +
                streamOpenLocation);
        }
        streamOpenLocationMap.
          put(
            streamOpenLocation,
            stream);
        if (stream.
              isUninteresting(
                )) {
            uninterestingStreamEscapeSet.
              add(
                stream);
        }
    }
    public edu.umd.cs.findbugs.detect.StreamEquivalenceClass getStreamEquivalenceClass(edu.umd.cs.findbugs.detect.Stream stream) {
        return streamEquivalenceMap.
          get(
            stream);
    }
    private boolean isStreamOpenLocation(edu.umd.cs.findbugs.ba.Location location) {
        return streamOpenLocationMap.
          get(
            location) !=
          null;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.detect.Stream isResourceCreation(edu.umd.cs.findbugs.ba.BasicBlock basicBlock,
                                                                org.apache.bcel.generic.InstructionHandle handle,
                                                                org.apache.bcel.generic.ConstantPoolGen cpg) {
        if (resourceCollection !=
              null) {
            return resourceCollection.
              getCreatedResource(
                new edu.umd.cs.findbugs.ba.Location(
                  handle,
                  basicBlock));
        }
        org.apache.bcel.generic.Instruction ins =
          handle.
          getInstruction(
            );
        if (!(ins instanceof org.apache.bcel.generic.TypedInstruction)) {
            return null;
        }
        org.apache.bcel.generic.Type type =
          ((org.apache.bcel.generic.TypedInstruction)
             ins).
          getType(
            cpg);
        if (!(type instanceof org.apache.bcel.generic.ObjectType)) {
            return null;
        }
        edu.umd.cs.findbugs.ba.Location location =
          new edu.umd.cs.findbugs.ba.Location(
          handle,
          basicBlock);
        for (edu.umd.cs.findbugs.detect.StreamFactory aStreamFactoryList
              :
              streamFactoryList) {
            edu.umd.cs.findbugs.detect.Stream stream =
              aStreamFactoryList.
              createStream(
                location,
                (org.apache.bcel.generic.ObjectType)
                  type,
                cpg,
                lookupFailureCallback);
            if (stream !=
                  null) {
                return stream;
            }
        }
        return null;
    }
    public boolean isResourceOpen(edu.umd.cs.findbugs.ba.BasicBlock basicBlock,
                                  org.apache.bcel.generic.InstructionHandle handle,
                                  org.apache.bcel.generic.ConstantPoolGen cpg,
                                  edu.umd.cs.findbugs.detect.Stream resource,
                                  edu.umd.cs.findbugs.ba.ResourceValueFrame frame) {
        return resource.
          isStreamOpen(
            basicBlock,
            handle,
            cpg,
            frame);
    }
    @java.lang.Override
    public boolean isResourceClose(edu.umd.cs.findbugs.ba.BasicBlock basicBlock,
                                   org.apache.bcel.generic.InstructionHandle handle,
                                   org.apache.bcel.generic.ConstantPoolGen cpg,
                                   edu.umd.cs.findbugs.detect.Stream resource,
                                   edu.umd.cs.findbugs.ba.ResourceValueFrame frame) {
        return resource.
          isStreamClose(
            basicBlock,
            handle,
            cpg,
            frame,
            lookupFailureCallback);
    }
    @java.lang.Override
    public boolean mightCloseResource(edu.umd.cs.findbugs.ba.BasicBlock basicBlock,
                                      org.apache.bcel.generic.InstructionHandle handle,
                                      org.apache.bcel.generic.ConstantPoolGen cpg)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        return edu.umd.cs.findbugs.detect.Stream.
          mightCloseStream(
            basicBlock,
            handle,
            cpg);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.ResourceValueFrameModelingVisitor createVisitor(edu.umd.cs.findbugs.detect.Stream resource,
                                                                                  org.apache.bcel.generic.ConstantPoolGen cpg) {
        return new edu.umd.cs.findbugs.detect.StreamFrameModelingVisitor(
          cpg,
          this,
          resource);
    }
    @java.lang.Override
    public boolean ignoreImplicitExceptions(edu.umd.cs.findbugs.detect.Stream resource) {
        return resource.
          ignoreImplicitExceptions(
            );
    }
    @java.lang.Override
    public boolean ignoreExceptionEdge(edu.umd.cs.findbugs.ba.Edge edge,
                                       edu.umd.cs.findbugs.detect.Stream resource,
                                       org.apache.bcel.generic.ConstantPoolGen cpg) {
        return false;
    }
    @java.lang.Override
    public boolean isParamInstance(edu.umd.cs.findbugs.detect.Stream resource,
                                   int slot) {
        return resource.
          getInstanceParam(
            ) ==
          slot;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zxXP63zlrg83PainbfwV35b8P5qumkt1PAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C/Dr2Fmf/3ef2Wz2bu6G7BKSTTa5eWwU/rIt27JZCJEt" +
       "S5YtybJlW7Yg3Mh6v2W9bBkCCQwNAyUEugnpTLIznYa2pCEJTJnS6UDDlJKk" +
       "PAoMbUmHEsi0lOcMKY92Sgs9kv1/3v//v3e7d+sZHcvnnO+c8/2+73zfd3SO" +
       "/Kk/Ld0XhSUo8J1Md/z4UN3Eh5ZTP4yzQI0O+3Sdk8JIVTqOFEUTkHdLfuNn" +
       "r//VX3/IePRa6X6x9JjkeX4sxabvRWM18p1UVejS9ZPcrqO6UVx6lLakVIKT" +
       "2HRg2oziZ+jSy0+RxqWb9NEQYDAEGAwBLoYAYye1ANErVC9xOzmF5MXRqvSd" +
       "pQO6dH8g58OLS0+dbSSQQsndN8MVHIAWHsx/zwBTBfEmLL3hmPcdz7cx/GEI" +
       "fvZHv+3Rn7qndF0sXTc9Ph+ODAYRg07E0sOu6i7VMMIURVXE0is9VVV4NTQl" +
       "x9wW4xZLNyJT96Q4CdVjkPLMJFDDos8T5B6Wc97CRI798Jg9zVQd5ejXfZoj" +
       "6YDXV5/wuuOQyPMBgw+ZYGChJsnqEcm9tukpcen15ymOebw5ABUA6QOuGhv+" +
       "cVf3ehLIKN3Yyc6RPB3m49D0dFD1Pj8BvcSl11zaaI51IMm2pKu34tIT5+tx" +
       "uyJQ62UFEDlJXPqa89WKloCUXnNOSqfk86fsN37w272ed60Ys6LKTj7+BwHR" +
       "k+eIxqqmhqonqzvCh99Of0R69c9+37VSCVT+mnOVd3X++Xd89V3vePJzX9jV" +
       "+boL6gyXlirHt+RPLB/59dd2nm7dkw/jwcCPzFz4Zzgv1J/blzyzCcDMe/Vx" +
       "i3nh4VHh58a/uHjfJ9U/vlZ6iCrdL/tO4gI9eqXsu4HpqCGpemooxapClV6m" +
       "ekqnKKdKD4B72vTUXe5Q0yI1pkr3OkXW/X7xG0CkgSZyiB4A96an+Uf3gRQb" +
       "xf0mKJVKD4CrhIOrVtp9iu+4pMOG76qwJEue6fkwF/o5/xGsevESYGvAGlCm" +
       "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" +
       "RLSRTIdVaomvvdHQG7A4poREzykvxlJj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "SgAA");
}
