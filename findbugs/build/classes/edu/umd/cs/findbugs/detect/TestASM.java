package edu.umd.cs.findbugs.detect;
import static org.apache.bcel.Constants.*;
public class TestASM extends edu.umd.cs.findbugs.asm.ClassNodeDetector {
    public TestASM(edu.umd.cs.findbugs.BugReporter bugReporter) { super(bugReporter);
    }
    @java.lang.Override
    public org.objectweb.asm.MethodVisitor visitMethod(final int access,
                                                       final java.lang.String name,
                                                       final java.lang.String desc,
                                                       final java.lang.String signature,
                                                       final java.lang.String[] exceptions) {
        if (java.lang.Character.
              isUpperCase(
                name.
                  charAt(
                    0))) {
            edu.umd.cs.findbugs.BugInstance bug0 =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "NM_METHOD_NAMING_CONVENTION",
              NORMAL_PRIORITY).
              addClass(
                this).
              addMethod(
                this.
                  name,
                name,
                desc,
                access);
            bugReporter.
              reportBug(
                bug0);
        }
        return new edu.umd.cs.findbugs.asm.AbstractFBMethodVisitor(
          ) {
            int
              prevOpcode;
            int
              prevPC;
            @java.lang.Override
            public void visitInsn(int opcode) {
                prevOpcode =
                  opcode;
                prevPC =
                  getPC(
                    );
            }
            @java.lang.Override
            public void visitMethodInsn(int opcode,
                                        java.lang.String owner,
                                        java.lang.String invokedName,
                                        java.lang.String invokedDesc,
                                        boolean itf) {
                if (prevPC +
                      1 ==
                      getPC(
                        ) &&
                      prevOpcode ==
                      I2D &&
                      opcode ==
                      INVOKESTATIC &&
                      "java/lang/Math".
                      equals(
                        owner) &&
                      "ceil".
                      equals(
                        invokedName) &&
                      "(D)D".
                      equals(
                        invokedDesc)) {
                    edu.umd.cs.findbugs.BugInstance bug0 =
                      new edu.umd.cs.findbugs.BugInstance(
                      TestASM.this,
                      "ICAST_INT_CAST_TO_DOUBLE_PASSED_TO_CEIL",
                      NORMAL_PRIORITY);
                    edu.umd.cs.findbugs.MethodAnnotation methodAnnotation =
                      edu.umd.cs.findbugs.MethodAnnotation.
                      fromForeignMethod(
                        TestASM.this.
                          name,
                        name,
                        desc,
                        access);
                    bug0.
                      addClass(
                        TestASM.this).
                      addMethod(
                        methodAnnotation);
                    bugReporter.
                      reportBug(
                        bug0);
                }
            }
        };
    }
    @java.lang.Override
    public org.objectweb.asm.FieldVisitor visitField(int access,
                                                     java.lang.String name,
                                                     java.lang.String desc,
                                                     java.lang.String signature,
                                                     java.lang.Object value) {
        if ((access &
               org.objectweb.asm.Opcodes.
                 ACC_STATIC) !=
              0 &&
              (access &
                 org.objectweb.asm.Opcodes.
                   ACC_FINAL) !=
              0 &&
              (access &
                 org.objectweb.asm.Opcodes.
                   ACC_PUBLIC) !=
              0 &&
              !name.
              equals(
                name.
                  toUpperCase(
                    ))) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NM_FIELD_NAMING_CONVENTION",
                  edu.umd.cs.findbugs.Priorities.
                    LOW_PRIORITY).
                  addClass(
                    this).
                  addField(
                    this.
                      name,
                    name,
                    desc,
                    access));
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
      ("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");
}
