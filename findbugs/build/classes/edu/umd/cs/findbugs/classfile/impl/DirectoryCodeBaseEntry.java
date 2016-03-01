package edu.umd.cs.findbugs.classfile.impl;
public class DirectoryCodeBaseEntry extends edu.umd.cs.findbugs.classfile.impl.AbstractScannableCodeBaseEntry {
    private final edu.umd.cs.findbugs.classfile.impl.DirectoryCodeBase codeBase;
    private final java.lang.String realResourceName;
    public DirectoryCodeBaseEntry(edu.umd.cs.findbugs.classfile.impl.DirectoryCodeBase codeBase,
                                  java.lang.String realResourceName) {
        super(
          );
        this.
          codeBase =
          codeBase;
        this.
          realResourceName =
          realResourceName;
    }
    @java.lang.Override
    public int getNumBytes() { java.io.File fullPath = codeBase.getFullPathOfResource(
                                                                  realResourceName);
                               return (int) fullPath.length(
                                                       );
    }
    @java.lang.Override
    public java.io.InputStream openResource() throws java.io.IOException {
        return codeBase.
          openFile(
            realResourceName);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.impl.AbstractScannableCodeBase getCodeBase() {
        return codeBase;
    }
    @java.lang.Override
    public java.lang.String getRealResourceName() {
        return realResourceName;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ClassDescriptor getClassDescriptor()
          throws edu.umd.cs.findbugs.classfile.InvalidClassFileFormatException {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptorFromResourceName(
            getResourceName(
              ));
    }
    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (obj ==
              null ||
              obj.
              getClass(
                ) !=
              this.
              getClass(
                )) {
            return false;
        }
        edu.umd.cs.findbugs.classfile.impl.DirectoryCodeBaseEntry other =
          (edu.umd.cs.findbugs.classfile.impl.DirectoryCodeBaseEntry)
            obj;
        return this.
                 codeBase.
          equals(
            other.
              codeBase) &&
          this.
            realResourceName.
          equals(
            other.
              realResourceName);
    }
    @java.lang.Override
    public int hashCode() { return 7919 * codeBase.
                              hashCode(
                                ) +
                              realResourceName.
                              hashCode(
                                ); }
    @java.lang.Override
    public java.lang.String toString() { return getCodeBase(
                                                  ) +
                                         ":" +
                                         getResourceName(
                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fczgUHF74eiIhr2Mv+Lb8v8Au+sahO4iAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HD+uXhwVP//kP/zgj7/+W9X9+f8DxJXgwGAtAAA=");
}
