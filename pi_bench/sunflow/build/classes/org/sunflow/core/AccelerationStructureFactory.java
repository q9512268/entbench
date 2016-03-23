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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7UsGr7fsypDB1nP8kS3n/wOMiEiw8BQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "e1FZV87+4DW/9+bfev6bZW3rfwC0KRpIGB8AAA==");
}
