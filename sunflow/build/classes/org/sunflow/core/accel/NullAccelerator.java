package org.sunflow.core.accel;
public class NullAccelerator implements org.sunflow.core.AccelerationStructure {
    private org.sunflow.core.PrimitiveList primitives;
    private int n;
    public NullAccelerator() { super();
                               primitives = null;
                               n = 0; }
    public void build(org.sunflow.core.PrimitiveList primitives) { this.primitives =
                                                                     primitives;
                                                                   n =
                                                                     primitives.
                                                                       getNumPrimitives(
                                                                         );
    }
    public void intersect(org.sunflow.core.Ray r, org.sunflow.core.IntersectionState state) {
        for (int i =
               0;
             i <
               n;
             i++)
            primitives.
              intersectPrimitive(
                r,
                i,
                state);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "p8Xaw61uGDz7LuIr8z+JY1X2YhgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
