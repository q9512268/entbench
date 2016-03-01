package edu.umd.cs.findbugs.detect;
public class IOStreamFactory implements edu.umd.cs.findbugs.detect.StreamFactory {
    private final org.apache.bcel.generic.ObjectType baseClassType;
    private final org.apache.bcel.generic.ObjectType[] uninterestingSubclassTypeList;
    private final java.lang.String bugType;
    @java.lang.Override
    public java.lang.String toString() { return "IOStreamFactory(" + baseClassType +
                                         ")"; }
    public IOStreamFactory(java.lang.String baseClass, java.lang.String[] uninterestingSubclassList,
                           java.lang.String bugType) { super(
                                                         );
                                                       this.
                                                         baseClassType =
                                                         edu.umd.cs.findbugs.ba.ObjectTypeFactory.
                                                           getInstance(
                                                             baseClass);
                                                       this.
                                                         uninterestingSubclassTypeList =
                                                         (new org.apache.bcel.generic.ObjectType[uninterestingSubclassList.
                                                                                                   length]);
                                                       for (int i =
                                                              0;
                                                            i <
                                                              uninterestingSubclassList.
                                                                length;
                                                            ++i) {
                                                           this.
                                                             uninterestingSubclassTypeList[i] =
                                                             edu.umd.cs.findbugs.ba.ObjectTypeFactory.
                                                               getInstance(
                                                                 uninterestingSubclassList[i]);
                                                       }
                                                       this.
                                                         bugType =
                                                         bugType;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.detect.Stream createStream(edu.umd.cs.findbugs.ba.Location location,
                                                          org.apache.bcel.generic.ObjectType type,
                                                          org.apache.bcel.generic.ConstantPoolGen cpg,
                                                          edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback) {
        try {
            org.apache.bcel.generic.Instruction ins =
              location.
              getHandle(
                ).
              getInstruction(
                );
            if (ins.
                  getOpcode(
                    ) !=
                  org.apache.bcel.Constants.
                    NEW) {
                return null;
            }
            if (edu.umd.cs.findbugs.ba.Hierarchy.
                  isSubtype(
                    type,
                    baseClassType)) {
                boolean isUninteresting =
                  false;
                for (org.apache.bcel.generic.ObjectType aUninterestingSubclassTypeList
                      :
                      uninterestingSubclassTypeList) {
                    if (edu.umd.cs.findbugs.ba.Hierarchy.
                          isSubtype(
                            type,
                            aUninterestingSubclassTypeList)) {
                        isUninteresting =
                          true;
                        break;
                    }
                }
                edu.umd.cs.findbugs.detect.Stream result =
                  new edu.umd.cs.findbugs.detect.Stream(
                  location,
                  type.
                    getClassName(
                      ),
                  baseClassType.
                    getClassName(
                      )).
                  setIgnoreImplicitExceptions(
                    true);
                if (!isUninteresting) {
                    result.
                      setInteresting(
                        bugType);
                }
                return result;
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            lookupFailureCallback.
              reportMissingClass(
                e);
        }
        return null;
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
       "xU0qrCiON32Vj9K6Nu8lrVYwrHYVoGjmhlo1zViys8lcXw8qKrGNdozaFDob" +
       "EuASALtFI2x1DTm2RkJ5XQl7JaYvN4fsPFVtaRMp0abmcQwbyFGAsTK9yWb4" +
       "rrpOA3xVj+rrRoncyMJIJ9GgtJ4uAN9DTTzgt+3BbNY2kk2AZ1VaF5rhFN/V" +
       "3O66AyuoAI/9VdOmWpxCpEDu2ezQmS40nq0onbWfpCUy7brtJeDSHmkJ/RXY" +
       "pJWUsSfeQlKdiBmAQWoJS6q0zUgwsrHJ2BT91EVtu45RE7GuVrE069ccWqhM" +
       "u2KPonoW1e6X4MIaWYG8LvtW1mdAWmq5q37WGrSaw4lKC91sEkjsNginltio" +
       "b3DZmQNqUol529yk5U6qzlu+wpAixU5Qs9JqtzSWLY/Qahi2Jx6b6ZsJdLaK" +
       "5fTHYUlnGcvP7aFUqir8oBEDtUXxvbkK2MFwrgQWAxxzNRkMh/MR1yfVdZ8o" +
       "1ypzKmV2wJyHLNuZ8Ol8uI7wBRGMVEW2jIq6G/dSlWYXU9eNNE7yY6+V4THZ" +
       "pQUQx9mU6EdU1+wmXJvYkXWJ7eNVF2+YPjkRKFRYJGODXkVV2yNNfNq2vK4g" +
       "NXusM+zuGu3Uaklbf5guhUFJ0d3Y55WgOVizpcDq2KYkavhqQtotZuWvloxo" +
       "Ru1g2wwmpKSptGakgJqxOlkl+HLSRdN0a1d9divIuLSusbbbVL25ZnPlVn1k" +
       "BDLf3kxpBZdYq4XD1YcZPcWvlEprYYkPpf4qpWF9fzmat2cs8ACIQWqSsady" +
       "JKi1dlXQ0LYboyNtnHS6jLahtJi0AUtQIVo3o2pSXdTLQ3rRD+qG2lzplclE" +
       "nCzd5npkjeuR3ycUoNW4Er3toqTZ5ZL6MuA6WEsUs2CktLdkPW2NsqzWwtdY" +
       "w62LhjIiVzGgNlDxW9TGJJ6qYXVVGXMmvyTMuRDW1d2qtLVRNxs3t0vGDzh8" +
       "1dpqg1aMtYS01ab7JM5QoOFKhGTHPdLe9Grt2OxZ7I6F/iDL+Gi2aUtKdyxb" +
       "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" +
       "sWH9fwEjgLqAZCoAAA==");
}
