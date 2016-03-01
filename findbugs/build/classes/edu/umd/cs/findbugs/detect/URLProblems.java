package edu.umd.cs.findbugs.detect;
public class URLProblems extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor URL_EQUALS =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/net/URL",
      "equals",
      "(Ljava/lang/Object;)Z");
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      URL_HASHCODE =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/net/URL",
      "hashCode",
      "()I");
    static final java.lang.String[] BAD_SIGNATURES = { "Hashtable<Ljava/net/URL",
    "Map<Ljava/net/URL",
    "Set<Ljava/net/URL" };
    private static final java.lang.String[] HASHSET_KEY_METHODS =
      { "add",
    "contains",
    "remove" };
    private static final java.lang.String[] HASHMAP_KEY_METHODS =
      { "containsKey",
    "get",
    "remove" };
    private static final java.lang.String[] HASHMAP_TWO_ARG_KEY_METHODS =
      { "put" };
    private static final java.util.List<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      methods =
      java.util.Arrays.
      asList(
        URL_EQUALS,
        URL_HASHCODE,
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "add",
          "(Ljava/lang/Object;)Z"),
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "contains",
          "(Ljava/lang/Object;)Z"),
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "remove",
          "(Ljava/lang/Object;)Z"),
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "containsKey",
          "(Ljava/lang/Object;)Z"),
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "get",
          "(Ljava/lang/Object;)Ljava/lang/Object;"),
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "remove",
          "(Ljava/lang/Object;)Ljava/lang/Object;"),
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "put",
          "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"));
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator
      accumulator;
    private boolean hasInterestingMethodCalls;
    public URLProblems(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        this.
          hasInterestingMethodCalls =
          hasInterestingMethod(
            classContext.
              getJavaClass(
                ).
              getConstantPool(
                ),
            methods);
        super.
          visitClassContext(
            classContext);
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        accumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (this.
              hasInterestingMethodCalls) {
            super.
              visit(
                obj);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Signature obj) {
        java.lang.String sig =
          obj.
          getSignature(
            );
        for (java.lang.String s
              :
              BAD_SIGNATURES) {
            if (sig.
                  indexOf(
                    s) >=
                  0) {
                if (visitingField(
                      )) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "DMI_COLLECTION_OF_URLS",
                          HIGH_PRIORITY).
                          addClass(
                            this).
                          addVisitedField(
                            this));
                }
                else
                    if (visitingMethod(
                          )) {
                        bugReporter.
                          reportBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              "DMI_COLLECTION_OF_URLS",
                              HIGH_PRIORITY).
                              addClassAndMethod(
                                this));
                    }
                    else {
                        bugReporter.
                          reportBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              "DMI_COLLECTION_OF_URLS",
                              HIGH_PRIORITY).
                              addClass(
                                this).
                              addClass(
                                this));
                    }
            }
        }
    }
    void check(java.lang.String className,
               java.lang.String[] methodNames,
               int target,
               int url) { if (java.util.Arrays.
                                binarySearch(
                                  methodNames,
                                  getNameConstantOperand(
                                    )) <
                                0) { return;
                          }
                          if (stack.getStackDepth(
                                      ) <=
                                target) {
                              return;
                          }
                          edu.umd.cs.findbugs.OpcodeStack.Item targetItem =
                            stack.
                            getStackItem(
                              target);
                          edu.umd.cs.findbugs.OpcodeStack.Item urlItem =
                            stack.
                            getStackItem(
                              url);
                          if (!"Ljava/net/URL;".
                                equals(
                                  urlItem.
                                    getSignature(
                                      ))) {
                              return;
                          }
                          if (!targetItem.
                                getSignature(
                                  ).
                                equals(
                                  className)) {
                              return;
                          }
                          accumulator.accumulateBug(
                                        new edu.umd.cs.findbugs.BugInstance(
                                          this,
                                          "DMI_COLLECTION_OF_URLS",
                                          HIGH_PRIORITY).
                                          addClassAndMethod(
                                            this).
                                          addCalledMethod(
                                            this),
                                        this);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            INVOKEVIRTUAL ||
                                            seen ==
                                            INVOKEINTERFACE) {
                                          check(
                                            "Ljava/util/HashSet;",
                                            HASHSET_KEY_METHODS,
                                            1,
                                            0);
                                          check(
                                            "Ljava/util/HashMap;",
                                            HASHMAP_KEY_METHODS,
                                            1,
                                            0);
                                          check(
                                            "Ljava/util/HashMap;",
                                            HASHMAP_TWO_ARG_KEY_METHODS,
                                            2,
                                            1);
                                      }
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            (getMethodDescriptorOperand(
                                               ).
                                               equals(
                                                 URL_EQUALS) ||
                                               getMethodDescriptorOperand(
                                                 ).
                                               equals(
                                                 URL_HASHCODE))) {
                                          accumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "DMI_BLOCKING_METHODS_ON_URL",
                                                HIGH_PRIORITY).
                                                addClassAndMethod(
                                                  this).
                                                addCalledMethod(
                                                  this),
                                              this);
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PdrEOC0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "I1Hk2JqEfNhoMSsFXSozy6LqRjuCt1V+uxxANlQz4HUjDH16wwpQ2eE5ZxST" +
       "MQmbaTObkInQTmM0hpuLcoQLOC41JlU07JKo1rJnnMB7Qs9zaKC1+GqBQY22" +
       "ZGnyYmIL3Ul5RXs6omVuza3W4bi5WI7ZMMosu8Ni9Sa3TKtjhe176xk9IRCD" +
       "7c9bcxdTGBBbpysVC1prghOgPoRLMgQ1aJM0dASRPEDzcpTWWh0PqvbQhJ7x" +
       "HZFYanp9gpBGt1ylEgP3idm4pY8qVXti4x4+rzIcsSCXrZHEj2Nh3XCzesun" +
       "JXm57tidqb41IgNqK35jZGtqvKn2ISZJtsqi6a2mMFLvpCOkv6wpLd7ikMo0" +
       "VvAlHzIbtZkqzsplM3OTJCCgg6EWCcciojoynMobHJFnIFLBamI4rSxr9aYV" +
       "rgaTASV1J9OuyTeq1kTcbFTH61YUzWxNga1Uw209aiwIggUAgBo1EIbpLJ+G" +
       "up7gIbLiqbqN1aVMFVupQ9S8tLqkkQGNQivRJHt1jUa8urdM2lC6taH2epmw" +
       "Ajm0A9pga7wmlNd6f+gNsbaPGdmmLi6zTbuSKp0qgDRo2NMHszobZJEKdznO" +
       "rkNSMNuWZclgZ9B6jJVX2Xq6TnSq2q7DbaTdmHkNZNnV0ays4eTQnBoYSBUr" +
       "g+oEL3drI2obLyoz09DWPdlfjBmVjlNPEnUrxtmyNJ20CLc1pSsNZSJVZtpE" +
       "rVf0sukP4uXabNhJH5mUxZ4xTuVW2eMpaoX1F7OxVq72VhxlN2t01yhvlusx" +
       "M042yKheGUoKU0em1e5acScVvGPIIIOsIyQxUrZMe670YHKw3eA9mfIiilyN" +
       "V1I0gbubcRvSdKZGDqtzru2CwGi+yBBvs6KgyJbJ0aTj8t04RPtTe6jDU6TZ" +
       "DZcoSlJp2cECq+a5xlpzkB4Wtur4grPM7lB3sUjkGqFdwyIM7Eff6dT5ZjxG" +
       "/bDVVm0+RXzTRnqeJJUDfMAGU4YcAviaYwylCObIGLQmDFeZ6wHZFOYrihms" +
       "Y4ZbOcFU7/sGxzSn3aQxbtcEFo6aqQxv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "z9/1j1/6evHk+v8CAqs18gA6AAA=");
}
