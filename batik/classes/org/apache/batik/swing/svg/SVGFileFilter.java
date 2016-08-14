package org.apache.batik.swing.svg;
public class SVGFileFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(java.io.File f) { boolean accept = false;
                                            java.lang.String fileName = null;
                                            if (f != null) { if (f.isDirectory(
                                                                     )) {
                                                                 accept =
                                                                   true;
                                                             }
                                                             else {
                                                                 fileName =
                                                                   f.
                                                                     getPath(
                                                                       ).
                                                                     toLowerCase(
                                                                       );
                                                                 if (fileName.
                                                                       endsWith(
                                                                         ".svg") ||
                                                                       fileName.
                                                                       endsWith(
                                                                         ".svgz"))
                                                                     accept =
                                                                       true;
                                                             }
                                            }
                                            return accept;
    }
    public java.lang.String getDescription() { return ".svg, .svgz";
    }
    public SVGFileFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kCAAAA==");
}
