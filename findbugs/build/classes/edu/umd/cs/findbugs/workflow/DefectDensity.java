package edu.umd.cs.findbugs.workflow;
public class DefectDensity {
    private static void printRow(java.lang.Object ... values) { for (java.lang.Object s
                                                                      :
                                                                      values) {
                                                                    java.lang.System.
                                                                      out.
                                                                      print(
                                                                        s);
                                                                    java.lang.System.
                                                                      out.
                                                                      print(
                                                                        "\t");
                                                                }
                                                                java.lang.System.
                                                                  out.
                                                                  println(
                                                                    );
    }
    public static double density(int bugs,
                                 int ncss) {
        if (ncss ==
              0) {
            return java.lang.Double.
                     NaN;
        }
        long bugsPer10KNCSS =
          java.lang.Math.
          round(
            10000.0 *
              bugs /
              ncss);
        return bugsPer10KNCSS /
          10.0;
    }
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { if (args.
                                             length >
                                             1 ||
                                             args.
                                               length >
                                             0 &&
                                             "-help".
                                             equals(
                                               args[0])) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Usage: " +
                                               edu.umd.cs.findbugs.workflow.DefectDensity.class.
                                                 getName(
                                                   ) +
                                               " [<infile>]");
                                           java.lang.System.
                                             exit(
                                               1);
                                       }
                                       edu.umd.cs.findbugs.FindBugs.
                                         setNoAnalysis(
                                           );
                                       edu.umd.cs.findbugs.BugCollection origCollection =
                                         new edu.umd.cs.findbugs.SortedBugCollection(
                                         );
                                       int argCount =
                                         0;
                                       if (argCount ==
                                             args.
                                               length) {
                                           origCollection.
                                             readXML(
                                               java.lang.System.
                                                 in);
                                       }
                                       else {
                                           origCollection.
                                             readXML(
                                               args[argCount]);
                                       }
                                       edu.umd.cs.findbugs.ProjectStats stats =
                                         origCollection.
                                         getProjectStats(
                                           );
                                       printRow(
                                         "kind",
                                         "name",
                                         "density/KNCSS",
                                         "bugs",
                                         "NCSS");
                                       double projectDensity =
                                         density(
                                           stats.
                                             getTotalBugs(
                                               ),
                                           stats.
                                             getCodeSize(
                                               ));
                                       printRow(
                                         "project",
                                         origCollection.
                                           getCurrentAppVersion(
                                             ).
                                           getReleaseName(
                                             ),
                                         projectDensity,
                                         stats.
                                           getTotalBugs(
                                             ),
                                         stats.
                                           getCodeSize(
                                             ));
                                       for (edu.umd.cs.findbugs.PackageStats p
                                             :
                                             stats.
                                              getPackageStats(
                                                )) {
                                           if (p.
                                                 getTotalBugs(
                                                   ) >
                                                 4) {
                                               double packageDensity =
                                                 density(
                                                   p.
                                                     getTotalBugs(
                                                       ),
                                                   p.
                                                     size(
                                                       ));
                                               if (java.lang.Double.
                                                     isNaN(
                                                       packageDensity) ||
                                                     packageDensity <
                                                     projectDensity) {
                                                   continue;
                                               }
                                               printRow(
                                                 "package",
                                                 p.
                                                   getPackageName(
                                                     ),
                                                 packageDensity,
                                                 p.
                                                   getTotalBugs(
                                                     ),
                                                 p.
                                                   size(
                                                     ));
                                               for (edu.umd.cs.findbugs.PackageStats.ClassStats c
                                                     :
                                                     p.
                                                      getSortedClassStats(
                                                        )) {
                                                   if (c.
                                                         getTotalBugs(
                                                           ) >
                                                         4) {
                                                       double density =
                                                         density(
                                                           c.
                                                             getTotalBugs(
                                                               ),
                                                           c.
                                                             size(
                                                               ));
                                                       if (java.lang.Double.
                                                             isNaN(
                                                               density) ||
                                                             density <
                                                             packageDensity) {
                                                           continue;
                                                       }
                                                       printRow(
                                                         "class",
                                                         c.
                                                           getName(
                                                             ),
                                                         density,
                                                         c.
                                                           getTotalBugs(
                                                             ),
                                                         c.
                                                           size(
                                                             ));
                                                   }
                                               }
                                           }
                                       } }
    public DefectDensity() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uyd7LUTby+yVNlf+C9THXgjuGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yw2zMuv6j175B6//3ae/lZV6/he9wZKcNCYAAA==");
}
