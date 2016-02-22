package org.sunflow.core.shader;
public class ViewGlobalPhotonsShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        return state.
          getGlobalRadiance(
            );
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public ViewGlobalPhotonsShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/9/ry+PFgRcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mgOq452uHE+8XAi0KA5c4Vj65aEDzd+TKfo14Lqwp/kL10/tXtdKTuVWsrWN" +
       "E7nDnZxgZ3+tHr5mrXI9aJEWZMnJfbJ7j5INt3e8T+czRDfJTm6ywougs7Gv" +
       "StE2ic0fsUQxgs7Jnmdrkntopf6Pyg8cnSVvsA/Ulhvtg+C6c09td/5k1Hbq" +
       "uIk/dF0TN915driq5SM8exO1vCsrnomg2+ZaxIN+mXlc13tMR5prWRZ67zg1" +
       "18+v/Bj6uS1rfMu+fe3ff2JmlT0+lxW/kVN98CY6+HBWvDeC7ggVKQLmtnfW" +
       "dB0LOZ14pnoo/vteifhroNAbnGdlCfn7rzk83x74Kp9+4eKt970w+pv8SOfg" +
       "UPY8A92qx7Z9NH96pH7WDzTdzKU7v82m+vntt6+HidvDtix7mldyzn9rS/87" +
       "EXTpJD1QQ3Y7SvYJYEBHyIAr7dWOEr0YQbcAoqz6Kf86qddtHnl96gi67hlN" +
       "ruy7f5SyD7ocPfLJEDn/98I+esbb/y9cVT7zQqf39pcrH98eOSm2tMkh4lYG" +
       "Orc9/TpA4MduONr+WGfbT/zgzs+ef93+1+LOLcOHBnyEt0euf6ZDOn6Un8Js" +
       "/ui+P3jT777wjTwT/H/L6U4TViIAAA==");
}
