package org.apache.batik.apps.svgbrowser;
public class SVGInputHandler implements org.apache.batik.apps.svgbrowser.SquiggleInputHandler {
    public static final java.lang.String[] SVG_MIME_TYPES = { "image/svg+xml" };
    public static final java.lang.String[] SVG_FILE_EXTENSIONS = { ".svg",
    ".svgz" };
    public java.lang.String[] getHandledMimeTypes() { return SVG_MIME_TYPES;
    }
    public java.lang.String[] getHandledExtensions() { return SVG_FILE_EXTENSIONS;
    }
    public java.lang.String getDescription() { return ""; }
    public void handle(org.apache.batik.util.ParsedURL purl, org.apache.batik.apps.svgbrowser.JSVGViewerFrame svgViewerFrame) {
        svgViewerFrame.
          getJSVGCanvas(
            ).
          loadSVGDocument(
            purl.
              toString(
                ));
    }
    public boolean accept(java.io.File f) { return f != null &&
                                              f.
                                              isFile(
                                                ) &&
                                              accept(
                                                f.
                                                  getPath(
                                                    )); }
    public boolean accept(org.apache.batik.util.ParsedURL purl) {
        if (purl ==
              null) {
            return false;
        }
        java.lang.String path =
          purl.
          getPath(
            );
        if (path ==
              null)
            return false;
        return accept(
                 path);
    }
    public boolean accept(java.lang.String path) { if (path ==
                                                         null)
                                                       return false;
                                                   for (int i =
                                                          0;
                                                        i <
                                                          SVG_FILE_EXTENSIONS.
                                                            length;
                                                        i++) {
                                                       if (path.
                                                             endsWith(
                                                               SVG_FILE_EXTENSIONS[i])) {
                                                           return true;
                                                       }
                                                   }
                                                   return false;
    }
    public SVGInputHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Odz/D+MPsrK/IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T0OX9+exyk6LTdRn7tjbUV+X+i987+Gv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PPD8UeLz8J7hE4c+xdvTtz9l1Nt6UXkuKP/H7/5H7/uHr/xhuSf2fwEcldYr" +
       "Cy0AAA==");
}
