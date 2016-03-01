package edu.umd.cs.findbugs.workflow;
public class CountByPackagePrefix {
    private static final java.lang.String USAGE = "Usage: <cmd> " + " <prefixLength> [<bugs.xml>]";
    public static void main(java.lang.String[] args) throws java.io.IOException,
        org.dom4j.DocumentException { edu.umd.cs.findbugs.DetectorFactoryCollection.
                                        instance(
                                          );
                                      if (args.length != 1 && args.
                                                                length !=
                                            2) { java.lang.System.
                                                   out.println(USAGE);
                                                 return; }
                                      int prefixLength = java.lang.Integer.
                                        parseInt(
                                          args[0]);
                                      edu.umd.cs.findbugs.BugCollection origCollection =
                                        new edu.umd.cs.findbugs.SortedBugCollection(
                                        );
                                      if (args.length ==
                                            1) { origCollection.
                                                   readXML(
                                                     java.lang.System.
                                                       in);
                                      }
                                      else {
                                          origCollection.
                                            readXML(
                                              args[1]);
                                      }
                                      java.util.Map<java.lang.String,java.lang.Integer> map =
                                        new java.util.TreeMap<java.lang.String,java.lang.Integer>(
                                        );
                                      java.util.Map<java.lang.String,java.lang.Integer> ncss =
                                        new java.util.TreeMap<java.lang.String,java.lang.Integer>(
                                        );
                                      for (edu.umd.cs.findbugs.BugInstance b
                                            :
                                            origCollection.
                                             getCollection(
                                               )) {
                                          java.lang.String prefix =
                                            edu.umd.cs.findbugs.util.ClassName.
                                            extractPackagePrefix(
                                              b.
                                                getPrimaryClass(
                                                  ).
                                                getPackageName(
                                                  ),
                                              prefixLength);
                                          java.lang.Integer v =
                                            map.
                                            get(
                                              prefix);
                                          if (v ==
                                                null) {
                                              map.
                                                put(
                                                  prefix,
                                                  1);
                                          }
                                          else {
                                              map.
                                                put(
                                                  prefix,
                                                  v +
                                                    1);
                                          }
                                      }
                                      for (edu.umd.cs.findbugs.PackageStats ps
                                            :
                                            origCollection.
                                             getProjectStats(
                                               ).
                                             getPackageStats(
                                               )) {
                                          java.lang.String prefix =
                                            edu.umd.cs.findbugs.util.ClassName.
                                            extractPackagePrefix(
                                              ps.
                                                getPackageName(
                                                  ),
                                              prefixLength);
                                          java.lang.Integer v =
                                            ncss.
                                            get(
                                              prefix);
                                          if (v ==
                                                null) {
                                              ncss.
                                                put(
                                                  prefix,
                                                  ps.
                                                    size(
                                                      ));
                                          }
                                          else {
                                              ncss.
                                                put(
                                                  prefix,
                                                  v +
                                                    ps.
                                                    size(
                                                      ));
                                          }
                                      }
                                      for (java.util.Map.Entry<java.lang.String,java.lang.Integer> e
                                            :
                                            map.
                                             entrySet(
                                               )) {
                                          java.lang.String prefix =
                                            e.
                                            getKey(
                                              );
                                          int warnings =
                                            e.
                                            getValue(
                                              );
                                          if (warnings ==
                                                0) {
                                              continue;
                                          }
                                          java.lang.Integer v =
                                            ncss.
                                            get(
                                              prefix);
                                          if (v ==
                                                null ||
                                                v.
                                                intValue(
                                                  ) ==
                                                0) {
                                              v =
                                                1;
                                          }
                                          int density =
                                            warnings *
                                            1000000 /
                                            v;
                                          if (warnings <
                                                3 ||
                                                v <
                                                2000) {
                                              java.lang.System.
                                                out.
                                                printf(
                                                  "%4s %4d %4d %s%n",
                                                  " ",
                                                  warnings,
                                                  v /
                                                    1000,
                                                  prefix);
                                          }
                                          else {
                                              java.lang.System.
                                                out.
                                                printf(
                                                  "%4d %4d %4d %s%n",
                                                  density,
                                                  warnings,
                                                  v /
                                                    1000,
                                                  prefix);
                                          }
                                      } }
    public CountByPackagePrefix() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/+Edv//I7zz/3Szp/79pG3Y1ICUAAA==");
}
