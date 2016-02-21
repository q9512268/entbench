package org.sunflow.core.shader;
public class ViewCausticsShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        state.
          initCausticSamples(
            );
        org.sunflow.image.Color lr =
          org.sunflow.image.Color.
          black(
            );
        for (org.sunflow.core.LightSample sample
              :
              state)
            lr.
              madd(
                sample.
                  dot(
                    state.
                      getNormal(
                        )),
                sample.
                  getDiffuseRadiance(
                    ));
        return lr.
          mul(
            1.0F /
              (float)
                java.lang.Math.
                  PI);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public ViewCausticsShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OPIf8/N2H6EWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WqjiYkN7Po9Im131VI5XSEp1+cVYKdV0ojpEww22rAjuKhb01WhkVlJGaa16" +
       "01GPZDcYSzLlEQGPaHFkxRKmwSbS8VZyG2uFYhXnzAQjF7G6Hg5azFzoy6WF" +
       "PldFs2FwQR9brftcP7HKQUC5coMmW3BP3AxJyibazrpHcvSkjasYItKcRuiM" +
       "2u8uGnPB6lU8ulSGpWGnYNr6LO1xmN7btMLhclVEGqKI2FK3HnG2aGpWReqx" +
       "NZKpVmtjTu0LncSeNUk3aRTgOGTICTKZrLtFujSeIVId5VxBdlTYc0Jkrbu2" +
       "XZ6MKHusDKOeOIY7JKlLI6dMTFpzc94vFuhU6seEAuMbpF+HdXitVLuNdYkI" +
       "2rYymDHipO+vUGlALBb8Yo1aYiUa9l2Bs0rdUUWp6KZfWk1ouTR1p2UJZhFg" +
       "YJEsY8Hap+FZQ3Wa6jjtjuP6IF3oKo3SdjeuM7pg8a2FacFyO26MiQ5adzZ9" +
       "qzddWXOlTWkjsRz01w7FxiAQxZ5QHU4Bf3PhOv14wXr0mMYiqyRRi1UAo41o" +
       "3BU27ZI5c2xhNg/mM5SeceJyWvGKi43WYeFJhRikzCBxRyZlht1a2xTlEY31" +
       "fa4Xj2zURulqihpeBDZz9BhzK8sF4XfrMwqE93CIScKmux5v5sIaa+klj5qP" +
       "qanex6cTuQW3tMjD62o5Yr3CZmkiXCoVwlZ5uikuCysOM/3mas6WQjadLBVY" +
       "o20StiTgG/xqRTR1XMSb47CZaC19xUWrjTRotnqxWul21rqDLLTmiC9z1QmV" +
       "dorFut5aTvpcmthYt1NpkYrnYhzaj6ZWSyrRSo3oltRCgs+QsmkPksKmWG/W" +
       "qlZQpGhjYTenRdmriuVQpQDUFWS8Ytm637TMXmHgj1ZNxFhYVBRy00arM3Ul" +
       "klpbKl1bWaXYElrVQhxjTYmqd6kU5RjaE8gAo4NuD+NM2PTWdcQzYHzIIqnt" +
       "LYcrdtatLSiVwLn1rIOx442Gzft1a9FcT2cca4Rq1cPxsFGrWC12ILcriRQ2" +
       "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" +
       "C/f/wZt+9/lv5onc/wMKjhhOGiIAAA==");
}
