package org.sunflow.core.filter;
public final class FilterFactory {
    public static final org.sunflow.core.Filter get(java.lang.String filter) {
        if (filter.
              equals(
                "box"))
            return new org.sunflow.core.filter.BoxFilter(
              1);
        else
            if (filter.
                  equals(
                    "gaussian"))
                return new org.sunflow.core.filter.GaussianFilter(
                  3);
            else
                if (filter.
                      equals(
                        "mitchell"))
                    return new org.sunflow.core.filter.MitchellFilter(
                      );
                else
                    if (filter.
                          equals(
                            "catmull-rom"))
                        return new org.sunflow.core.filter.CatmullRomFilter(
                          );
                    else
                        if (filter.
                              equals(
                                "blackman-harris"))
                            return new org.sunflow.core.filter.BlackmanHarrisFilter(
                              4);
                        else
                            if (filter.
                                  equals(
                                    "sinc"))
                                return new org.sunflow.core.filter.SincFilter(
                                  4);
                            else
                                if (filter.
                                      equals(
                                        "lanczos"))
                                    return new org.sunflow.core.filter.LanczosFilter(
                                      );
                                else
                                    if (filter.
                                          equals(
                                            "triangle"))
                                        return new org.sunflow.core.filter.TriangleFilter(
                                          2);
                                    else
                                        return null;
    }
    public FilterFactory() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3vE7L3477wz9L5K4NBRIHgAA");
}
