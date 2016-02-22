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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
