package edu.umd.cs.findbugs.ba.vna;
public abstract class ValueNumberSourceInfo {
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.BugAnnotation findAnnotationFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                                  edu.umd.cs.findbugs.ba.Location location,
                                                                                  edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                                  edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame,
                                                                                  @javax.annotation.CheckForNull
                                                                                  java.lang.String partialRole) {
        if (location.
              getHandle(
                ).
              getInstruction(
                ) instanceof org.apache.bcel.generic.ACONST_NULL) {
            edu.umd.cs.findbugs.StringAnnotation nullConstant =
              new edu.umd.cs.findbugs.StringAnnotation(
              "null");
            nullConstant.
              setDescription(
                edu.umd.cs.findbugs.StringAnnotation.
                  STRING_NONSTRING_CONSTANT_ROLE);
            return nullConstant;
        }
        edu.umd.cs.findbugs.LocalVariableAnnotation ann =
          edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findLocalAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame);
        if (ann !=
              null &&
              partialRole !=
              null) {
            ann.
              setDescription(
                "LOCAL_VARIABLE_" +
                partialRole);
        }
        if (ann !=
              null &&
              ann.
              isSignificant(
                )) {
            return ann;
        }
        edu.umd.cs.findbugs.FieldAnnotation field =
          edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findFieldAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame);
        if (field !=
              null) {
            if (partialRole !=
                  null) {
                field.
                  setDescription(
                    "FIELD_" +
                    partialRole);
            }
            return field;
        }
        if (ann !=
              null) {
            return ann;
        }
        return null;
    }
    @javax.annotation.Nonnull
    public static edu.umd.cs.findbugs.BugAnnotation findRequiredAnnotationFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                                          edu.umd.cs.findbugs.ba.Location location,
                                                                                          edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                                          edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame,
                                                                                          @javax.annotation.CheckForNull
                                                                                          java.lang.String partialRole) {
        edu.umd.cs.findbugs.BugAnnotation result =
          findAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame,
            partialRole);
        if (result !=
              null) {
            return result;
        }
        return new edu.umd.cs.findbugs.LocalVariableAnnotation(
          "?",
          -1,
          location.
            getHandle(
              ).
            getPosition(
              ));
    }
    public static edu.umd.cs.findbugs.LocalVariableAnnotation findLocalAnnotationFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                                                 edu.umd.cs.findbugs.ba.Location location,
                                                                                                 edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                                                 edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        if (vnaFrame ==
              null ||
              vnaFrame.
              isBottom(
                ) ||
              vnaFrame.
              isTop(
                )) {
            return null;
        }
        edu.umd.cs.findbugs.LocalVariableAnnotation localAnnotation =
          null;
        for (int i =
               0;
             i <
               vnaFrame.
               getNumLocals(
                 );
             i++) {
            if (valueNumber.
                  equals(
                    vnaFrame.
                      getValue(
                        i))) {
                org.apache.bcel.generic.InstructionHandle handle =
                  location.
                  getHandle(
                    );
                org.apache.bcel.generic.InstructionHandle prev =
                  handle.
                  getPrev(
                    );
                if (prev ==
                      null) {
                    continue;
                }
                int position1 =
                  prev.
                  getPosition(
                    );
                int position2 =
                  handle.
                  getPosition(
                    );
                localAnnotation =
                  edu.umd.cs.findbugs.LocalVariableAnnotation.
                    getLocalVariableAnnotation(
                      method,
                      i,
                      position1,
                      position2);
                if (localAnnotation !=
                      null) {
                    return localAnnotation;
                }
            }
        }
        return null;
    }
    public static edu.umd.cs.findbugs.FieldAnnotation findFieldAnnotationFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                                         edu.umd.cs.findbugs.ba.Location location,
                                                                                         edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                                         edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        edu.umd.cs.findbugs.ba.XField field =
          edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findXFieldFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame);
        if (field ==
              null) {
            return null;
        }
        return edu.umd.cs.findbugs.FieldAnnotation.
          fromXField(
            field);
    }
    public static edu.umd.cs.findbugs.ba.XField findXFieldFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                          edu.umd.cs.findbugs.ba.Location location,
                                                                          edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                          edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        if (vnaFrame ==
              null ||
              vnaFrame.
              isBottom(
                ) ||
              vnaFrame.
              isTop(
                )) {
            return null;
        }
        edu.umd.cs.findbugs.ba.vna.AvailableLoad load =
          vnaFrame.
          getLoad(
            valueNumber);
        if (load !=
              null) {
            return load.
              getField(
                );
        }
        return null;
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.BugAnnotation getFromValueNumber(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                                       org.apache.bcel.classfile.Method method,
                                                                       edu.umd.cs.findbugs.ba.Location location,
                                                                       int stackPos)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
          classContext.
          getValueNumberDataflow(
            method).
          getFactAtLocation(
            location);
        if (!vnaFrame.
              isValid(
                )) {
            return null;
        }
        edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
          vnaFrame.
          getStackValue(
            stackPos);
        if (valueNumber.
              hasFlag(
                edu.umd.cs.findbugs.ba.vna.ValueNumber.
                  CONSTANT_CLASS_OBJECT)) {
            return null;
        }
        edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
          findAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame,
            "VALUE_OF");
        return variableAnnotation;
    }
    public ValueNumberSourceInfo() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d/4Hf2XFP/8LNXHQSzYeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PnJIPvXyT7zu9578enbQ+v+daoo4xCkAAA==");
}
