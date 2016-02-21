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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bGrcNL2m9jC3umnyAPsyG7T/AJBJFgrrEwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
