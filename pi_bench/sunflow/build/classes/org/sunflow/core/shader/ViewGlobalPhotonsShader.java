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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wX+i0CPdxcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "D/h4wRkLuOEbAG/Zw5BsA1G0mQ4IK3jBLa39oLegOu2C0+NdVRMarl5wuXkB" +
       "T8Kiq4mzPG+bgEkimP8FTpvlpbUyH0yZXktzUJTJNaQ+Ls+8ZbWGgTGhNFfC" +
       "oFPobwgNaOxo7BjBqiTU/PYCOk17YDRbIQM4WXSFldW0SmZtI4BxcbbWE3KA" +
       "9/WQHKiLelhOnFZB8Yhw5WtY22Fb7TUuF6k+l5tVymNbnsb1elIUEkptADxs" +
       "xVK52Y6Xito2O6VhvVV3mBZYC26jTgpFmS/rdp2fOCKI5+hUtiii4dD62hDr" +
       "ypIl3MBCp/yGYNYzdMaWctWiuJiRRaNa61LtSV8uectwuR4JTiSzHawTSJHt" +
       "i2InX3Xosk6WOH00tEdVSufttlYs81WzVnVqqqYF7FKvoeVN3WjG2nzTqOST" +
       "sS40cgOriuETXrUbYXEo9Ee9kkg3WBgrGJgNF2ezcXttwq1Lp/WQjSJoPAFb" +
       "TqZFv0IsCzi6Kfj5wSbqt72I8WXAcyRZsxOsTqtsOW7NwUTI4WAZxxG9Dgtx" +
       "ZEjKPNhsNpJSG5I1lxqJZOjnYaI9jWZVQlvG7LJUjrRRb4iu9PZ4XBaZAa2q" +
       "Y5sdKgXNSIIF11kp5oLBGgC00KC05HP41FoSDIGJUXlcxxdhgFHiJMQmoMkW" +
       "S2hEDxQiGtVEh6K7ascrLNVueQikrtMUiowXAHNAy4lqkBW1wioCGHSkTRgU" +
       "K2JprBGLRt8t8OLM7C/9UtLF+nze7iXleCQM8fmw3iBWYFJsAbvU7OV1DeUq" +
       "oybf65aKxcmCJ5swpabUkQymaDsprvsSg64mOROjBupagYecN74xPf685eWd" +
       "QO/KDtsH1yDw4Jm+aL6Mk9f21WNp85qDAmP2OXuTAuORIsyp/YP9fdcUlrcF" +
       "5PS0+dCNbj+yk+Ynnn7uebX/yfzOXnFLjJDzkef/vA2WwD5R73ndjU/V3ezy" +
       "57Do8qWn/+UB/k3G215GWfmRE3yeJPmp7gtfab5Wef8OcstBCeaaa6njSFeO" +
       "F14uBCCKA5c/Vn556EDz96SKfhX8XtjT/IXrl3avayWnMivZ2saJ2uFOBrCz" +
       "v1YPX7NWmR5ABIK0OLkPdu9RMG77Wxu0shmim1Qnk7TxIuRs7KtytC1ij45Y" +
       "ohAh52aeZwPZPbRS/8fVB47Okg3YB2rLjPZB+L1zT213/nTUduq4iT90XRM3" +
       "XT29UgUZhWduopb3pM3TEXKbDqIRxEvN47reYzqyDtIq9N4laqafd/0E+rkt" +
       "HXzTvn3t//7UzCp9fDZtfj2D+vBNdPDRtHl/hNwRKnIEzW3vruk6FnJ66Znq" +
       "ofgfeDnir6FCb3CflRbk77/mynx7zat89vmLt973/Pivsyudg6vY8yxyqxbb" +
       "9tH66ZH+WT8AmplJd35bTfWzn9+6XkzcXral1dOsk3H+m1v4346QSyfhoRrS" +
       "n6Ngn4IGdAQMutJe7yjQCxFyCwRKu5/xr1N63daR16eORNc9o8mUffePU/YB" +
       "ytErnzQiZ/9Z2I+e8fZfC1eVzz3f7r39pfInt1dOii0nWYi4lUXObW+/DiLw" +
       "Yzektk/rLPPED+/8/PnX7O8Wd24ZPjTgI7w9cv07nYbjR9ktTPKH9/3+G37n" +
       "+W9mleD/A7CGRjxMIgAA");
}
