package edu.umd.cs.findbugs;
public abstract class ResourceTrackingDetector<Resource, ResourceTrackerType extends edu.umd.cs.findbugs.ba.ResourceTracker<Resource>> implements edu.umd.cs.findbugs.Detector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "rtd.debug");
    private static final java.lang.String DEBUG_METHOD_NAME = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "rtd.method");
    protected edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    protected edu.umd.cs.findbugs.BugReporter bugReporter;
    public ResourceTrackingDetector(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    public abstract boolean prescreen(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                      org.apache.bcel.classfile.Method method,
                                      boolean mightClose);
    public abstract ResourceTrackerType getResourceTracker(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                           org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException;
    public abstract void inspectResult(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                       org.apache.bcel.generic.MethodGen methodGen,
                                       edu.umd.cs.findbugs.ba.CFG cfg,
                                       edu.umd.cs.findbugs.ba.Dataflow<edu.umd.cs.findbugs.ba.ResourceValueFrame,edu.umd.cs.findbugs.ba.ResourceValueAnalysis<Resource>> dataflow,
                                       Resource resource);
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        final org.apache.bcel.classfile.JavaClass jclass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.classfile.Method[] methodList =
          jclass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  isAbstract(
                    ) ||
                  method.
                  isNative(
                    )) {
                continue;
            }
            org.apache.bcel.generic.MethodGen methodGen =
              classContext.
              getMethodGen(
                method);
            if (methodGen ==
                  null) {
                continue;
            }
            if (DEBUG_METHOD_NAME !=
                  null &&
                  !DEBUG_METHOD_NAME.
                  equals(
                    method.
                      getName(
                        ))) {
                continue;
            }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    ("------------------------------------------------------------" +
                     "----------"));
                java.lang.System.
                  out.
                  println(
                    "Analyzing " +
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        methodGen));
                java.lang.System.
                  out.
                  println(
                    ("------------------------------------------------------------" +
                     "----------"));
            }
            try {
                ResourceTrackerType resourceTracker =
                  getResourceTracker(
                    classContext,
                    method);
                boolean mightClose =
                  mightCloseResource(
                    classContext,
                    method,
                    resourceTracker);
                if (!prescreen(
                       classContext,
                       method,
                       mightClose)) {
                    continue;
                }
                edu.umd.cs.findbugs.ResourceCollection<Resource> resourceCollection =
                  buildResourceCollection(
                    classContext,
                    method,
                    resourceTracker);
                if (resourceCollection.
                      isEmpty(
                        )) {
                    continue;
                }
                analyzeMethod(
                  classContext,
                  method,
                  resourceTracker,
                  resourceCollection);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Error analyzing method " +
                    method.
                      toString(
                        ),
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Error analyzing method " +
                    method.
                      toString(
                        ),
                    e);
            }
            bugAccumulator.
              reportAccumulatedBugs(
                );
        }
    }
    private edu.umd.cs.findbugs.ResourceCollection<Resource> buildResourceCollection(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                                                     org.apache.bcel.classfile.Method method,
                                                                                     ResourceTrackerType resourceTracker)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ResourceCollection<Resource> resourceCollection =
          new edu.umd.cs.findbugs.ResourceCollection<Resource>(
          );
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            Resource resource =
              resourceTracker.
              isResourceCreation(
                location.
                  getBasicBlock(
                    ),
                location.
                  getHandle(
                    ),
                cpg);
            if (resource !=
                  null) {
                resourceCollection.
                  addCreatedResource(
                    location,
                    resource);
            }
        }
        return resourceCollection;
    }
    private boolean mightCloseResource(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                       org.apache.bcel.classfile.Method method,
                                       ResourceTrackerType resourceTracker)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            if (resourceTracker.
                  mightCloseResource(
                    location.
                      getBasicBlock(
                        ),
                    location.
                      getHandle(
                        ),
                    cpg)) {
                return true;
            }
        }
        return false;
    }
    public void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                              org.apache.bcel.classfile.Method method,
                              ResourceTrackerType resourceTracker,
                              edu.umd.cs.findbugs.ResourceCollection<Resource> resourceCollection)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        try {
            edu.umd.cs.findbugs.ba.CFG cfg =
              classContext.
              getCFG(
                method);
            edu.umd.cs.findbugs.ba.DepthFirstSearch dfs =
              classContext.
              getDepthFirstSearch(
                method);
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        methodGen));
            }
            for (java.util.Iterator<Resource> i =
                   resourceCollection.
                   resourceIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                Resource resource =
                  i.
                  next(
                    );
                edu.umd.cs.findbugs.ba.ResourceValueAnalysis<Resource> analysis =
                  new edu.umd.cs.findbugs.ba.ResourceValueAnalysis<Resource>(
                  methodGen,
                  cfg,
                  dfs,
                  resourceTracker,
                  resource);
                edu.umd.cs.findbugs.ba.Dataflow<edu.umd.cs.findbugs.ba.ResourceValueFrame,edu.umd.cs.findbugs.ba.ResourceValueAnalysis<Resource>> dataflow =
                  new edu.umd.cs.findbugs.ba.Dataflow<edu.umd.cs.findbugs.ba.ResourceValueFrame,edu.umd.cs.findbugs.ba.ResourceValueAnalysis<Resource>>(
                  cfg,
                  analysis);
                edu.umd.cs.findbugs.log.Profiler profiler =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getProfiler(
                    );
                profiler.
                  start(
                    resourceTracker.
                      getClass(
                        ));
                try {
                    dataflow.
                      execute(
                        );
                }
                finally {
                    profiler.
                      end(
                        resourceTracker.
                          getClass(
                            ));
                }
                inspectResult(
                  classContext,
                  methodGen,
                  cfg,
                  dataflow,
                  resource);
            }
        }
        catch (java.lang.RuntimeException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Exception while analyzing " +
                methodGen.
                  getClassName(
                    ) +
                "." +
                methodGen.
                  getName(
                    ) +
                ":" +
                methodGen.
                  getSignature(
                    ),
                e);
        }
    }
    @java.lang.Override
    public void report() {  }
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
      ("H4sIAAAAAAAAAL17acwk6VlYz8zOzuzhndldH+tlvd5jbHa3l6mu7q4+Mja4" +
       "+qiju6q6u/qsSvC4zu667+qqhgVsKbGFhbGSNRjJNgIZhSBjkygWPxCWI0Js" +
       "B0iyCCV2JDCKCDEQK15FEBQndt6q/vo7er5vdjYe80n1dn3v8bzP/TxV71Of" +
       "+WbhYuAXiq5jpkvTCa8rSXhdN5HrYeoqwfUehQwFP1DktikEwQT03ZSe+Y0r" +
       "f/Ptj66uni/cyxceFWzbCYVQc+yAVQLHjBWZKlw56u2aihWEhauULsQCFIWa" +
       "CVFaEN6gCg8cWxoWrlE7FCCAAgRQgHIUIPRoFlj0BsWOrHa2QrDDwCv8ROEc" +
       "VbjXlTL0wsLTJ4G4gi9YB2CGOQUAwuXs/xkgKl+c+IWnDmnf0nwLwR8rQi//" +
       "/Huv/osLhSt84YpmjzN0JIBECDbhCw9aiiUqfoDKsiLzhYdtRZHHiq8JprbJ" +
       "8eYLjwTa0hbCyFcOmZR1Rq7i53sece5BKaPNj6TQ8Q/JUzXFlHf/XVRNYQlo" +
       "ffMRrVsKsawfEHi/BhDzVUFSdkvuMTRbDgtv319xSOO1PpgAll6ylHDlHG51" +
       "jy2AjsIjW9mZgr2ExqGv2Usw9aITgV3CwuNnAs147QqSISyVm2Hhsf15w+0Q" +
       "mHVfzohsSVh40/60HBKQ0uN7Ujomn28y7/rIj9mEfT7HWVYkM8P/Mlj05N4i" +
       "VlEVX7ElZbvwwReonxPe/NsfOl8ogMlv2pu8nfObP/7qe1588otf3s75gVPm" +
       "DERdkcKb0qfFh155ov1880KGxmXXCbRM+Ccoz9V/eDByI3GB5b35EGI2eH03" +
       "+EX233A/9WvKX50v3E8W7pUcM7KAHj0sOZarmYqPK7biC6Eik4X7FFtu5+Nk" +
       "4RK4pzRb2fYOVDVQQrJwj5l33evk/wMWqQBExqJL4F6zVWd37wrhKr9P3EKh" +
       "cBVchcvgQgrbv2rWhAUJWjmWAgmSYGu2Aw19J6M/gBQ7FAFvV5AKlEmMlgEU" +
       "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" +
       "A7pUgeWB4gybgUyLxbRZK0ZT2ZXUdo8a");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AAA=");
}
