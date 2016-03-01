package edu.umd.cs.findbugs.ba.ch;
class ClassVertex extends edu.umd.cs.findbugs.graph.AbstractVertex<edu.umd.cs.findbugs.ba.ch.InheritanceEdge,edu.umd.cs.findbugs.ba.ch.ClassVertex> {
    private static final int FINISHED = 1;
    private static final int APPLICATION_CLASS = 2;
    private static final int INTERFACE = 4;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor;
    @javax.annotation.CheckForNull
    private final edu.umd.cs.findbugs.ba.XClass xclass;
    private int flags;
    private edu.umd.cs.findbugs.ba.ch.ClassVertex directSuperclass;
    @java.lang.Override
    public java.lang.String toString() { return classDescriptor.toString(
                                                                  ); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.ba.ch.ClassVertex)) {
                                                    return false;
                                                }
                                                return classDescriptor.
                                                  equals(
                                                    ((edu.umd.cs.findbugs.ba.ch.ClassVertex)
                                                       o).
                                                      classDescriptor);
    }
    @java.lang.Override
    public int hashCode() { return classDescriptor.hashCode(
                                                     ); }
    private ClassVertex(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor,
                        edu.umd.cs.findbugs.ba.XClass xclass) {
        super(
          );
        this.
          classDescriptor =
          classDescriptor;
        this.
          xclass =
          xclass;
        this.
          flags =
          0;
        if (xclass.
              isInterface(
                )) {
            setInterface(
              );
        }
    }
    private ClassVertex(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor,
                        boolean isInterfaceEdge) {
        super(
          );
        this.
          classDescriptor =
          classDescriptor;
        this.
          xclass =
          null;
        this.
          flags =
          0;
        if (isInterfaceEdge) {
            setInterface(
              );
        }
    }
    public static edu.umd.cs.findbugs.ba.ch.ClassVertex createResolvedClassVertex(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor,
                                                                                  edu.umd.cs.findbugs.ba.XClass xclass) {
        return new edu.umd.cs.findbugs.ba.ch.ClassVertex(
          classDescriptor,
          xclass);
    }
    public static edu.umd.cs.findbugs.ba.ch.ClassVertex createMissingClassVertex(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor,
                                                                                 boolean isInterface) {
        return new edu.umd.cs.findbugs.ba.ch.ClassVertex(
          classDescriptor,
          isInterface);
    }
    public edu.umd.cs.findbugs.classfile.ClassDescriptor getClassDescriptor() {
        return classDescriptor;
    }
    @javax.annotation.Nullable
    public edu.umd.cs.findbugs.ba.XClass getXClass() {
        return xclass;
    }
    public boolean isResolved() { return xclass !=
                                    null;
    }
    public void setFinished(boolean finished) {
        setFlag(
          FINISHED,
          finished);
    }
    public boolean isFinished() { return isFlagSet(
                                           FINISHED);
    }
    public void markAsApplicationClass() {
        setFlag(
          APPLICATION_CLASS,
          true);
    }
    public boolean isApplicationClass() {
        return isFlagSet(
                 APPLICATION_CLASS);
    }
    private void setInterface() { setFlag(
                                    INTERFACE,
                                    true);
    }
    public boolean isInterface() { return isFlagSet(
                                            INTERFACE);
    }
    public void setDirectSuperclass(edu.umd.cs.findbugs.ba.ch.ClassVertex target) {
        this.
          directSuperclass =
          target;
    }
    public edu.umd.cs.findbugs.ba.ch.ClassVertex getDirectSuperclass() {
        return directSuperclass;
    }
    private void setFlag(int flag, boolean enable) {
        if (enable) {
            flags |=
              flag;
        }
        else {
            flags &=
              ~flag;
        }
    }
    private boolean isFlagSet(int flag) {
        return (flags &
                  flag) !=
          0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "R+5W+fFmi78i4nZZxl/xbfn/AZ9hjFJzOgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gonfkDVjyDa6U6Q+pyheaTCoTDYTry7O");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
