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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
