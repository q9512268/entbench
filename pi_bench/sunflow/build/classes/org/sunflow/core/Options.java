package org.sunflow.core;
public final class Options extends org.sunflow.core.ParameterList implements org.sunflow.core.RenderObject {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        for (java.util.Map.Entry<java.lang.String,org.sunflow.core.ParameterList.Parameter> e
              :
              pl.
                list.
               entrySet(
                 )) {
            list.
              put(
                e.
                  getKey(
                    ),
                e.
                  getValue(
                    ));
            e.
              getValue(
                ).
              check(
                );
        }
        return true;
    }
    public Options() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fPE5fsuGb/8XGh4q1YkUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
