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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
