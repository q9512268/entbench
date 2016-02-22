package org.sunflow.core;
class AccelerationStructureFactory {
    static final org.sunflow.core.AccelerationStructure create(java.lang.String name,
                                                               int n,
                                                               boolean primitives) {
        if (name ==
              null ||
              name.
              equals(
                "auto")) {
            if (primitives) {
                if (n >
                      20000000)
                    return new org.sunflow.core.accel.UniformGrid(
                      );
                else
                    if (n >
                          2000000)
                        return new org.sunflow.core.accel.BoundingIntervalHierarchy(
                          );
                    else
                        if (n >
                              2)
                            return new org.sunflow.core.accel.KDTree(
                              );
                        else
                            return new org.sunflow.core.accel.NullAccelerator(
                              );
            }
            else {
                if (n >
                      2)
                    return new org.sunflow.core.accel.BoundingIntervalHierarchy(
                      );
                else
                    return new org.sunflow.core.accel.NullAccelerator(
                      );
            }
        }
        else
            if (name.
                  equals(
                    "uniformgrid"))
                return new org.sunflow.core.accel.UniformGrid(
                  );
            else
                if (name.
                      equals(
                        "null"))
                    return new org.sunflow.core.accel.NullAccelerator(
                      );
                else
                    if (name.
                          equals(
                            "kdtree"))
                        return new org.sunflow.core.accel.KDTree(
                          );
                    else
                        if (name.
                              equals(
                                "bih"))
                            return new org.sunflow.core.accel.BoundingIntervalHierarchy(
                              );
                        else {
                            org.sunflow.system.UI.
                              printWarning(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "Unrecognized intersection accelerator \"%s\" - using auto",
                                name);
                            return create(
                                     null,
                                     n,
                                     primitives);
                        }
    }
    public AccelerationStructureFactory() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DcOZtfsMXm+ZlSGDrWf5I1vO/Qcbp6/4+hQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
