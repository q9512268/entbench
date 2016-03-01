package org.apache.batik.apps.rasterizer;
public class DefaultSVGConverterController implements org.apache.batik.apps.rasterizer.SVGConverterController {
    public boolean proceedWithComputedTask(org.apache.batik.transcoder.Transcoder transcoder,
                                           java.util.Map hints,
                                           java.util.List sources,
                                           java.util.List dest) {
        return true;
    }
    public boolean proceedWithSourceTranscoding(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                                java.io.File dest) {
        java.lang.System.
          out.
          println(
            "About to transcoder source of type: " +
            source.
              getClass(
                ).
              getName(
                ));
        return true;
    }
    public boolean proceedOnSourceTranscodingFailure(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                                     java.io.File dest,
                                                     java.lang.String errorCode) {
        return true;
    }
    public void onSourceTranscodingSuccess(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                           java.io.File dest) {
        
    }
    public DefaultSVGConverterController() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F2YXwsmf3PlHb/39F76VXUr9H5IQ1VQuJwAA");
}
