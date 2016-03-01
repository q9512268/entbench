package edu.umd.cs.findbugs.detect;
public class EqualsOperandShouldHaveClassCompatibleWithThis extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.FirstPassDetector {
    final edu.umd.cs.findbugs.BugReporter bugReporter;
    final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    final edu.umd.cs.findbugs.ba.ClassSummary classSummary = new edu.umd.cs.findbugs.ba.ClassSummary(
      );
    public EqualsOperandShouldHaveClassCompatibleWithThis(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        edu.umd.cs.findbugs.ba.AnalysisContext context =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            );
        context.
          setClassSummary(
            classSummary);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if ("equals".
              equals(
                getMethodName(
                  )) &&
              "(Ljava/lang/Object;)Z".
              equals(
                getMethodSig(
                  ))) {
            super.
              visit(
                obj);
            if (edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  isApplicationClass(
                    getThisClass(
                      ))) {
                bugAccumulator.
                  reportAccumulatedBugs(
                    );
            }
            bugAccumulator.
              clearBugs(
                );
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKEVIRTUAL) {
                                          if ("equals".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "(Ljava/lang/Object;)Z".
                                                equals(
                                                  getSigConstantOperand(
                                                    ))) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                stack.
                                                getStackItem(
                                                  1);
                                              edu.umd.cs.findbugs.classfile.ClassDescriptor c =
                                                edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                createClassDescriptorFromSignature(
                                                  item.
                                                    getSignature(
                                                      ));
                                              check(
                                                c);
                                          }
                                          else
                                              if ("java/lang/Class".
                                                    equals(
                                                      getClassConstantOperand(
                                                        )) &&
                                                    ("isInstance".
                                                       equals(
                                                         getNameConstantOperand(
                                                           )) ||
                                                       "cast".
                                                       equals(
                                                         getNameConstantOperand(
                                                           )))) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                    stack.
                                                    getStackItem(
                                                      1);
                                                  if ("Ljava/lang/Class;".
                                                        equals(
                                                          item.
                                                            getSignature(
                                                              ))) {
                                                      java.lang.Object value =
                                                        item.
                                                        getConstant(
                                                          );
                                                      if (value instanceof java.lang.String) {
                                                          edu.umd.cs.findbugs.classfile.ClassDescriptor c =
                                                            edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                            createClassDescriptor(
                                                              (java.lang.String)
                                                                value);
                                                          check(
                                                            c);
                                                      }
                                                  }
                                              }
                                      }
                                      else
                                          if (seen ==
                                                INSTANCEOF ||
                                                seen ==
                                                CHECKCAST) {
                                              check(
                                                getClassDescriptorOperand(
                                                  ));
                                          }
    }
    private void check(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        edu.umd.cs.findbugs.OpcodeStack.Item item =
          stack.
          getStackItem(
            0);
        if (item.
              isInitialParameter(
                ) &&
              item.
              getRegisterNumber(
                ) ==
              1) {
            edu.umd.cs.findbugs.classfile.ClassDescriptor thisClassDescriptor =
              getClassDescriptor(
                );
            if (c.
                  equals(
                    thisClassDescriptor)) {
                return;
            }
            edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                );
            try {
                if (!c.
                      isArray(
                        ) &&
                      (subtypes2.
                         isSubtype(
                           c,
                           thisClassDescriptor) ||
                         subtypes2.
                         isSubtype(
                           thisClassDescriptor,
                           c))) {
                    return;
                }
                org.apache.bcel.generic.Type thisType =
                  org.apache.bcel.generic.Type.
                  getType(
                    thisClassDescriptor.
                      getSignature(
                        ));
                org.apache.bcel.generic.Type cType =
                  org.apache.bcel.generic.Type.
                  getType(
                    c.
                      getSignature(
                        ));
                edu.umd.cs.findbugs.ba.IncompatibleTypes check =
                  edu.umd.cs.findbugs.ba.IncompatibleTypes.
                  getPriorityForAssumingCompatible(
                    thisType,
                    cType,
                    false);
                int priority =
                  check.
                  getPriority(
                    );
                if ("java/lang/Object".
                      equals(
                        getSuperclassName(
                          )) &&
                      edu.umd.cs.findbugs.util.ClassName.
                      isAnonymous(
                        getClassName(
                          ))) {
                    priority++;
                }
                bugAccumulator.
                  accumulateBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS",
                      priority).
                      addClassAndMethod(
                        this).
                      addType(
                        c).
                      describe(
                        edu.umd.cs.findbugs.TypeAnnotation.
                          FOUND_ROLE),
                    this);
                classSummary.
                  checksForEqualTo(
                    thisClassDescriptor,
                    c);
            }
            catch (java.lang.ClassNotFoundException e) {
                bugReporter.
                  reportMissingClass(
                    e);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1ZDWwUxxWeO///4D9+Y8CAMTQ25g7SkIaapICxw5GzfcKG" +
       "qqbBzO3O+Rbv7S67s/bZKSmhP9BWRSQhhFaJK1VESRAJqErUVvkpbZQGlLRS" +
       "0rRJ2kKqtlJpU9SgqklV2qZvZvduf+6HWGqlWtrxeOa9N+/NvPe9N+PTV1CZ" +
       "oaMWotAQndSIEepRaAzrBhG7ZWwYQzA2IjxUgv+6+3L/+iAqH0Z1SWz0Cdgg" +
       "vRKRRWMYLZYUg2JFIEY/ISLjiOnEIPo4ppKqDKO5khFJabIkSLRPFQkj2In1" +
       "KGrElOpS3KQkYgugaHEUNAlzTcKb/NNdUVQrqNqkQ77ARd7tmmGUKWctg6KG" +
       "6F48jsMmleRwVDJoV1pHqzRVnhyVVRoiaRraK6+zt2BbdF3OFrSerX//2tFk" +
       "A9+C2VhRVMrNM7YTQ5XHiRhF9c5oj0xSxj50DyqJohoXMUVt0cyiYVg0DItm" +
       "rHWoQPtZRDFT3So3h2YklWsCU4iiZV4hGtZxyhYT4zqDhEpq286ZwdqlWWst" +
       "K3NMfHBV+NhDuxu+U4Lqh1G9pAwydQRQgsIiw7ChJBUnurFJFIk4jBoVOOxB" +
       "oktYlqbsk24ypFEFUxOOP7MtbNDUiM7XdPYKzhFs002BqnrWvAR3KPuvsoSM" +
       "R8HWeY6tloW9bBwMrJZAMT2Bwe9sltIxSREpWuLnyNrYdicQAGtFitCkml2q" +
       "VMEwgJosF5GxMhoeBNdTRoG0TAUH1ClqLiiU7bWGhTE8SkaYR/roYtYUUFXx" +
       "jWAsFM31k3FJcErNvlNync+V/g1H7la2KkEUAJ1FIshM/xpgavExbScJohOI" +
       "A4uxtiN6HM97/nAQISCe6yO2aL77uasbO1vOnbdoFuahGYjvJQIdEU7G615b" +
       "1N2+voSpUamphsQO32M5j7KYPdOV1gBh5mUlsslQZvLc9h9/5sAp8m4QVUdQ" +
       "uaDKZgr8qFFQU5okE/0OohAdUyJGUBVRxG4+H0EV0I9KCrFGBxIJg9AIKpX5" +
       "ULnK/4YtSoAItkXV0JeUhJrpa5gmeT+tIYQq4EMUvhuR9XOjNXAgnFRTJIwF" +
       "rEiKGo7pKrPfCAPixGFvk+EEOFPcHDXChi6EuesQ0QybKTEsGM6kSCiwhXv2" +
       "mVg2BsABsCIOJlVTFrficcKPtxushQiKy+TTEk0OJSUjxMRp/wc6pNk+zZ4I" +
       "BOAIF/kBRIbY26rKItFHhGPm5p6rT428YjknCyh7hymKgEohUCkkGKGMSiFL" +
       "pdDMVEKBANdkDlPNciRwgzEAFED02vbBu7btOdxaAh6sTZTCGTLSVk9m63ZQ" +
       "J5MqRoQzTbOmll1a+2IQlUZRExYoqMQS1SZ9FCBQGLNRojYOOc9JPUtdqYfl" +
       "TF0VwE6dFEpBtpRKdZzobJyiOS4JmcTIICBcOC3l1R+dOzFx787PrwmioDfb" +
       "sCXLACgZe4zliGwuaPOjTD659Ycuv3/m+H7VwRtP+spk3RxOZkOr31f82zMi" +
       "dCzFz4w8v7+Nb3sV5AOKIX4Balv8a3jgrCuTGpgtlWBwQtVTWGZTmT2upkld" +
       "nXBGuBM38v4ccIsaFt/r4VtjBzz/zWbnaaydbzk98zOfFTz13DaoPfLWT//4" +
       "cb7dmSxV7yovBgntciEjE9bEMbDRcdshnRCgu3gi9sCDVw7t4j4LFMvzLdjG" +
       "Wh4MAIWq/qXz+95+59LJN4KOn1MoDcw4VFjprJFsHFUXMRJWW+noA8gqQzwy" +
       "r2nboYB/SgkJQ+SxwPpn/Yq1z/z5SIPlBzKMZNyo8/oCnPEbNqMDr+z+oIWL" +
       "CQgsszt75pBZ6WK2I3mTruNJpkf63tcXf+Nl/AgkHgB7Q5oiHL8DdqwzpRZA" +
       "9s+HNpvN0e1EU3VI5fxw13HqNby9mW0Ml4H43HrWrDDcQeKNQ1elNiIcfeO9" +
       "WTvfe+Eqt8pb6rl9og9rXZYbsmZlGsTP94PYVmwkge7mc/2fbZDPXQOJwyBR" +
       "gPrGGNABZNMeD7Kpyyp++cMX5+15rQQFe1G1rGKxF/NgRFUQBcRIAj6ntU9t" +
       "tJxgohKaBm4qyjE+Z4AdxJL8R9yT0ig/lKnvzX96w2PTl7g3apaMhZy/hKUM" +
       "D/ryC4MDAKd+9omfP3bf8Qmr5GgvjHo+vgX/GJDjB3/795wt53iXpxzy8Q+H" +
       "Tz/c3H37u5zfAR7G3ZbOTXMA3g7vTadSfwu2lr8URBXDqEGwC/SdWDZZOA9D" +
       "UWpkqnYo4j3z3gLTqqa6ssC6yA96rmX9kOekV+gzataf5UM5FvuoFb4OGwA6" +
       "/CgXQLxzJ2f5GG87WLM6AyplED9Y9mFKVRGRFNXEnUhjQ7dYUMraT7Imakm7" +
       "raBD9ngNYLVYp71aZwEDhiwDWNOfq2shborqQNdNgmCmTBlnriEAIK0FAMRF" +
       "6jNqxwyNYrknZKsVKmDUXUWNKsRN4WLFSqdBM5XC+mTGpOX5TIpj63Jh0/ps" +
       "2l3EprSj26qsbvynHPnKaHfCcaAhC9Yr8inWK8GFPQaabeE1oqoztFxc6F7E" +
       "73QnDx6bFgceXWtBSZP3rtEDV+knf/GvV0MnfnMhT3laRVVttUzGiewDr8Ue" +
       "8OrjV0YHCS7W3f+777eNbp5J1cjGWq5TF7K/l4ARHYXx0K/Kywf/1Dx0e3LP" +
       "DArAJb7t9It8ou/0hTtWCvcH+f3Ygqice7WXqcsLTNU6oaauDHngabm3CFsC" +
       "3622u9zqDwTHIXOxiXVDeYqdQsJ86d5XMrSo+mgIwx0+SUJxgcghHkPs9gg5" +
       "TyRck6kiFcM9rKGAl+MSlHxG0VwW06UUlIXj9tU8vL/pnbGHLz9pOa4/cfmI" +
       "yeFjX/0wdOSY5cTWY8fynPcGN4/14MGVbLB260P4CcD3b/YxC9gA+w3pqdu+" +
       "dS/NXrtZRtfRsmJq8SV6/3Bm/7OP7z8UtHcEvKV0XJVEB09ML57UZvEkewpN" +
       "vNJgyTE0ALGgSyIpAkEfpXxhA90aH9e8jrccvojtK5H/huMVElbA8Tz3UoYa" +
       "g2YcMM973DfF9giH22K/t3zjhjwMFt3cx8Nf3/nm3ld5+FcyvMkGnQtrAJdc" +
       "t6EG1nzRMuSAq/9likok+8XRq/Ac7/rW0lu+Uv/c0aaSXgDBCKo0FWmfSSKi" +
       "FwgqDDPuUsh5BXNgwdaGuSJFgQ7wOj58vEjMfZs1RwG9DTwxoAk2cH7Bcbj7" +
       "CjocG/7a/8K1atlcO3wJ2xsSM3Etiio0XRqHsPP5V00RicWBbXW+9OoCN5kn" +
       "WUPQJY2lWcZ1tsieP82aJwDnACitBOfa71PXK4I+yoamKZrhkxC7oyzIedm2" +
       "XmOFp6brK+dP73iT5+jsi2ktREnClGV3Fe3ql2s6SUjc4Fqrptb4r+coai78" +
       "kgVXcKvDTXvWYvkBRbPzsFBY3+66qX9EUbVDTVFQ8Ey/BA5iT0OQQuuePA9D" +
       "MMm6F7TM8XfmLftYgrMihtcp2SIr4Cp/7BPiBzv3egebZXG/X7DEx/8vkcEM" +
       "0/rPxIhwZnpb/91Xb3nUej8Bb5yaYlJqACmsp5xskbKsoLSMrPKt7dfqzlat" +
       "yOSdRkthJ8wWuty3GyJDY/7S7HtcMNqybwxvn9zwwk8Ol78OKXYXCmA4v125" +
       "l7a0ZkJ1uCuai4hQ0PFXj672b07e3pn4y6/4tdhG0EWF6eFS+sBbkbNjH2zk" +
       "D+FlcFgkzW+TWyaV7UQY1z3wWsdcGbP/UPB9sLdvVnaUvbbBRSa3NMh9o6yW" +
       "1Qmib1ZNRbQBusYZ8fyDxA6PalPTfAzOiCvDTFuYznYffHMk2qdpdqlRskzj" +
       "4f4tP2zxQc78a95lzcX/ANai9lCiHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+T3z9g/u/L03//azX82vHf4Xpd6KHIYnAAA=");
}
