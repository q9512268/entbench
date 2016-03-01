package edu.umd.cs.findbugs.detect;
public class InstanceFieldLoadStreamFactory implements edu.umd.cs.findbugs.detect.StreamFactory {
    private final java.lang.String streamBaseClass;
    private java.lang.String bugPatternType;
    public InstanceFieldLoadStreamFactory(java.lang.String streamBaseClass) {
        super(
          );
        this.
          streamBaseClass =
          streamBaseClass;
    }
    public edu.umd.cs.findbugs.detect.InstanceFieldLoadStreamFactory setBugPatternType(java.lang.String bugPatternType) {
        this.
          bugPatternType =
          bugPatternType;
        return this;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.detect.Stream createStream(edu.umd.cs.findbugs.ba.Location location,
                                                          org.apache.bcel.generic.ObjectType type,
                                                          org.apache.bcel.generic.ConstantPoolGen cpg,
                                                          edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback) {
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
                GETFIELD) {
            return null;
        }
        java.lang.String fieldClass =
          type.
          getClassName(
            );
        try {
            if (fieldClass.
                  startsWith(
                    "[")) {
                return null;
            }
            if (!edu.umd.cs.findbugs.ba.Hierarchy.
                  isSubtype(
                    fieldClass,
                    streamBaseClass)) {
                return null;
            }
            edu.umd.cs.findbugs.detect.Stream stream =
              new edu.umd.cs.findbugs.detect.Stream(
              location,
              fieldClass,
              streamBaseClass);
            stream.
              setIsOpenOnCreation(
                true);
            stream.
              setOpenLocation(
                location);
            if (bugPatternType !=
                  null) {
                stream.
                  setInteresting(
                    bugPatternType);
            }
            return stream;
        }
        catch (java.lang.ClassNotFoundException e) {
            lookupFailureCallback.
              reportMissingClass(
                e);
            return null;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u7zLmqv/AXzCEJ5iGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
