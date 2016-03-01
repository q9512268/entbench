package edu.umd.cs.findbugs.detect;
public class EmptyZipFileEntry extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private int sawPutEntry;
    private java.lang.String streamType;
    public EmptyZipFileEntry(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {  }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { sawPutEntry =
                                                                -10000;
                                                              streamType =
                                                                ""; }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKEVIRTUAL && "putNextEntry".
                                            equals(
                                              getNameConstantOperand(
                                                ))) { streamType =
                                                        getClassConstantOperand(
                                                          );
                                                      if ("java/util/zip/ZipOutputStream".
                                                            equals(
                                                              streamType) ||
                                                            "java/util/jar/JarOutputStream".
                                                            equals(
                                                              streamType)) {
                                                          sawPutEntry =
                                                            getPC(
                                                              );
                                                      }
                                                      else {
                                                          streamType =
                                                            "";
                                                      }
                                      }
                                      else {
                                          if (getPC(
                                                ) -
                                                sawPutEntry <=
                                                7 &&
                                                seen ==
                                                INVOKEVIRTUAL &&
                                                "closeEntry".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                getClassConstantOperand(
                                                  ).
                                                equals(
                                                  streamType)) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "java/util/zip/ZipOutputStream".
                                                      equals(
                                                        streamType)
                                                      ? "AM_CREATES_EMPTY_ZIP_FILE_ENTRY"
                                                      : "AM_CREATES_EMPTY_JAR_FILE_ENTRY",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QIoaDR7Rw/ly0TBH/g1/xeHSfwE4nWcbHhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7935O2/4jWe/ku+c/zfEa5LVqCYAAA==");
}
