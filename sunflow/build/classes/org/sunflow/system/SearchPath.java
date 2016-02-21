package org.sunflow.system;
public class SearchPath {
    private java.util.LinkedList<java.lang.String> searchPath;
    private java.lang.String type;
    public SearchPath(java.lang.String type) { super();
                                               this.type = type;
                                               searchPath = new java.util.LinkedList<java.lang.String>(
                                                              ); }
    public void resetSearchPath() { searchPath.clear(); }
    public void addSearchPath(java.lang.String path) { java.io.File f =
                                                         new java.io.File(
                                                         path);
                                                       if (f.exists(
                                                               ) &&
                                                             f.
                                                             isDirectory(
                                                               )) {
                                                           try {
                                                               path =
                                                                 f.
                                                                   getCanonicalPath(
                                                                     );
                                                               for (java.lang.String prefix
                                                                     :
                                                                     searchPath)
                                                                   if (prefix.
                                                                         equals(
                                                                           path))
                                                                       return;
                                                               org.sunflow.system.UI.
                                                                 printInfo(
                                                                   org.sunflow.system.UI.Module.
                                                                     SYS,
                                                                   "Adding %s search path: \"%s\"",
                                                                   type,
                                                                   path);
                                                               searchPath.
                                                                 add(
                                                                   path);
                                                           }
                                                           catch (java.io.IOException e) {
                                                               org.sunflow.system.UI.
                                                                 printError(
                                                                   org.sunflow.system.UI.Module.
                                                                     SYS,
                                                                   "Invalid %s search path specification: \"%s\" - %s",
                                                                   type,
                                                                   path,
                                                                   e.
                                                                     getMessage(
                                                                       ));
                                                           }
                                                       }
                                                       else
                                                           org.sunflow.system.UI.
                                                             printError(
                                                               org.sunflow.system.UI.Module.
                                                                 SYS,
                                                               ("Invalid %s search path specification: \"%s\" - invalid direc" +
                                                                "tory"),
                                                               type,
                                                               path);
    }
    public java.lang.String resolvePath(java.lang.String filename) {
        if (filename.
              startsWith(
                "//"))
            filename =
              filename.
                substring(
                  2);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              SYS,
            "Resolving %s path \"%s\" ...",
            type,
            filename);
        java.io.File f =
          new java.io.File(
          filename);
        if (!f.
              isAbsolute(
                )) {
            for (java.lang.String prefix
                  :
                  searchPath) {
                org.sunflow.system.UI.
                  printDetailed(
                    org.sunflow.system.UI.Module.
                      SYS,
                    "  * searching: \"%s\" ...",
                    prefix);
                if (prefix.
                      endsWith(
                        java.io.File.
                          separator) ||
                      filename.
                      startsWith(
                        java.io.File.
                          separator))
                    f =
                      new java.io.File(
                        prefix +
                        filename);
                else
                    f =
                      new java.io.File(
                        prefix +
                        java.io.File.
                          separator +
                        filename);
                if (f.
                      exists(
                        )) {
                    return f.
                      getAbsolutePath(
                        );
                }
            }
        }
        return filename;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
