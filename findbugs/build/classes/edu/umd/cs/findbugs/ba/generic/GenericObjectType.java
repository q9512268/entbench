package edu.umd.cs.findbugs.ba.generic;
public class GenericObjectType extends org.apache.bcel.generic.ObjectType {
    final java.util.List<? extends org.apache.bcel.generic.ReferenceType>
      parameters;
    @javax.annotation.CheckForNull
    final java.lang.String variable;
    @javax.annotation.CheckForNull
    final org.apache.bcel.generic.ReferenceType extension;
    public org.apache.bcel.generic.ReferenceType produce() { return getTypeCategory(
                                                                      ).
                                                               produce(
                                                                 this);
    }
    @java.lang.Override
    public int hashCode() { return 13 * super.hashCode() + 9 * edu.umd.cs.findbugs.util.Util.
                              nullSafeHashcode(
                                parameters) +
                              7 *
                              edu.umd.cs.findbugs.util.Util.
                              nullSafeHashcode(
                                variable) +
                              edu.umd.cs.findbugs.util.Util.
                              nullSafeHashcode(
                                extension); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType)) {
                                                    return false;
                                                }
                                                if (!super.
                                                      equals(
                                                        o)) {
                                                    return false;
                                                }
                                                edu.umd.cs.findbugs.ba.generic.GenericObjectType that =
                                                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                                                    o;
                                                return edu.umd.cs.findbugs.util.Util.
                                                  nullSafeEquals(
                                                    this.
                                                      parameters,
                                                    that.
                                                      parameters) &&
                                                  edu.umd.cs.findbugs.util.Util.
                                                  nullSafeEquals(
                                                    this.
                                                      variable,
                                                    that.
                                                      variable) &&
                                                  edu.umd.cs.findbugs.util.Util.
                                                  nullSafeEquals(
                                                    this.
                                                      extension,
                                                    that.
                                                      extension);
    }
    public org.apache.bcel.generic.Type getUpperBound() {
        if ("+".
              equals(
                variable)) {
            return extension;
        }
        return this;
    }
    public org.apache.bcel.generic.Type getExtension() {
        return extension;
    }
    public java.lang.String getVariable() {
        return variable;
    }
    public edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory getTypeCategory() {
        if (hasParameters(
              ) &&
              variable ==
              null &&
              extension ==
              null) {
            return edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                     PARAMETERIZED;
        }
        else
            if (!hasParameters(
                   ) &&
                  variable !=
                  null &&
                  extension ==
                  null) {
                if ("*".
                      equals(
                        variable)) {
                    return edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                             WILDCARD;
                }
                else {
                    return edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                             TYPE_VARIABLE;
                }
            }
            else
                if (!hasParameters(
                       ) &&
                      variable !=
                      null &&
                      extension !=
                      null) {
                    if ("+".
                          equals(
                            variable)) {
                        return edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                                 WILDCARD_EXTENDS;
                    }
                    else
                        if ("-".
                              equals(
                                variable)) {
                            return edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                                     WILDCARD_SUPER;
                        }
                }
        throw new java.lang.IllegalStateException(
          "The Generic Object Type is badly initialized");
    }
    public boolean hasParameters() { return parameters !=
                                       null &&
                                       parameters.
                                       size(
                                         ) >
                                       0;
    }
    public int getNumParameters() { return parameters !=
                                      null
                                      ? parameters.
                                      size(
                                        )
                                      : 0;
    }
    public org.apache.bcel.generic.ReferenceType getParameterAt(int index) {
        if (index <
              getNumParameters(
                )) {
            return parameters.
              get(
                index);
        }
        else {
            throw new java.lang.IndexOutOfBoundsException(
              "The index " +
              index +
              " is too large for " +
              this);
        }
    }
    @javax.annotation.CheckForNull
    public java.util.List<? extends org.apache.bcel.generic.ReferenceType> getParameters() {
        if (parameters ==
              null) {
            return null;
        }
        return java.util.Collections.
          unmodifiableList(
            parameters);
    }
    GenericObjectType(@javax.annotation.Nonnull
                      java.lang.String variable) {
        this(
          variable,
          (org.apache.bcel.generic.ReferenceType)
            null);
    }
    GenericObjectType(@javax.annotation.Nonnull
                      java.lang.String wildcard,
                      @javax.annotation.CheckForNull
                      org.apache.bcel.generic.ReferenceType extension) {
        super(
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
            canonicalizeString(
              org.apache.bcel.generic.Type.
                OBJECT.
                getClassName(
                  )));
        this.
          variable =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
            canonicalizeString(
              wildcard);
        this.
          extension =
          extension;
        parameters =
          null;
    }
    GenericObjectType(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                      java.lang.String class_name,
                      java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters) {
        super(
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
            canonicalizeString(
              class_name));
        variable =
          null;
        extension =
          null;
        if (parameters ==
              null ||
              parameters.
              size(
                ) ==
              0) {
            throw new java.lang.IllegalStateException(
              "argument \'parameters\' must contain at least 1 parameter");
        }
        this.
          parameters =
          parameters;
    }
    public org.apache.bcel.generic.ObjectType getObjectType() {
        java.lang.String cName =
          edu.umd.cs.findbugs.util.ClassName.
          fromFieldSignature(
            getSignature(
              ));
        if (cName ==
              null) {
            throw new java.lang.IllegalStateException(
              "Can\'t provide ObjectType for " +
              this);
        }
        java.lang.String c =
          edu.umd.cs.findbugs.util.ClassName.
          toDottedClassName(
            cName);
        return edu.umd.cs.findbugs.ba.ObjectTypeFactory.
          getInstance(
            c);
    }
    public java.lang.String toString(boolean includeGenerics) {
        return getTypeCategory(
                 ).
          asString(
            this);
    }
    @java.lang.Override
    public java.lang.String toString() { return getTypeCategory(
                                                  ).
                                           asString(
                                             this);
    }
    public java.lang.String toPlainString() {
        return super.
          toString(
            );
    }
    public java.lang.String getGenericParametersAsString() {
        if (getTypeCategory(
              ) !=
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PARAMETERIZED) {
            throw new java.lang.IllegalStateException(
              toString(
                ) +
              " doesn\'t have generic parameters");
        }
        java.lang.String baseStringValue =
          super.
          toString(
            );
        java.lang.String fullStringValue =
          toString(
            );
        return fullStringValue.
          substring(
            baseStringValue.
              length(
                ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "N3DxfJa/4ttz/wc9cXTodTIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4fa8ZJNGTbbaBW2AiytuXTKnrj7F291J");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "L5QynPk+AAA=");
}
