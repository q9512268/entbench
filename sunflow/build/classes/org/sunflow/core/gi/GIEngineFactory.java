package org.sunflow.core.gi;
public final class GIEngineFactory {
    public static final org.sunflow.core.GIEngine create(org.sunflow.core.Options options) {
        java.lang.String type =
          options.
          getString(
            "gi.engine",
            null);
        if (type ==
              null ||
              type.
              equals(
                "null") ||
              type.
              equals(
                "none"))
            return null;
        else
            if (type.
                  equals(
                    "ambocc"))
                return new org.sunflow.core.gi.AmbientOcclusionGIEngine(
                  options);
            else
                if (type.
                      equals(
                        "fake"))
                    return new org.sunflow.core.gi.FakeGIEngine(
                      options);
                else
                    if (type.
                          equals(
                            "igi"))
                        return new org.sunflow.core.gi.InstantGI(
                          options);
                    else
                        if (type.
                              equals(
                                "irr-cache"))
                            return new org.sunflow.core.gi.IrradianceCacheGIEngine(
                              options);
                        else
                            if (type.
                                  equals(
                                    "path"))
                                return new org.sunflow.core.gi.PathTracingGIEngine(
                                  options);
                            else {
                                org.sunflow.system.UI.
                                  printWarning(
                                    org.sunflow.system.UI.Module.
                                      LIGHT,
                                    "Unrecognized GI engine type \"%s\" - ignoring",
                                    type);
                                return null;
                            }
    }
    public GIEngineFactory() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u0EeAAA=");
}
