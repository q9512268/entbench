package org.apache.batik;
public final class Version {
    public static java.lang.String getVersion() { java.lang.Package pkg =
                                                    org.apache.batik.Version.class.
                                                    getPackage(
                                                      );
                                                  java.lang.String version =
                                                    null;
                                                  if (pkg != null) {
                                                      version =
                                                        pkg.
                                                          getImplementationVersion(
                                                            );
                                                  }
                                                  java.lang.String headURL =
                                                    ("$HeadURL: https://svn.apache.org/repos/asf/xmlgraphics/batik" +
                                                     "/tags/batik-1_7/sources/org/apache/batik/Version.java $");
                                                  java.lang.String prefix =
                                                    "$HeadURL: ";
                                                  java.lang.String suffix =
                                                    "/sources/org/apache/batik/Version.java $";
                                                  if (headURL.
                                                        startsWith(
                                                          prefix) &&
                                                        headURL.
                                                        endsWith(
                                                          suffix)) {
                                                      headURL =
                                                        headURL.
                                                          substring(
                                                            prefix.
                                                              length(
                                                                ),
                                                            headURL.
                                                              length(
                                                                ) -
                                                              suffix.
                                                              length(
                                                                ));
                                                      if (!headURL.
                                                            endsWith(
                                                              "/trunk")) {
                                                          int index1 =
                                                            headURL.
                                                            lastIndexOf(
                                                              '/');
                                                          int index2 =
                                                            headURL.
                                                            lastIndexOf(
                                                              '/',
                                                              index1 -
                                                                1);
                                                          java.lang.String name =
                                                            headURL.
                                                            substring(
                                                              index1 +
                                                                1);
                                                          java.lang.String type =
                                                            headURL.
                                                            substring(
                                                              index2 +
                                                                1,
                                                              index1);
                                                          java.lang.String tagPrefix =
                                                            "batik-";
                                                          if (type.
                                                                equals(
                                                                  "tags") &&
                                                                name.
                                                                startsWith(
                                                                  tagPrefix)) {
                                                              version =
                                                                name.
                                                                  substring(
                                                                    tagPrefix.
                                                                      length(
                                                                        )).
                                                                  replace(
                                                                    '_',
                                                                    '.');
                                                          }
                                                          else
                                                              if (type.
                                                                    equals(
                                                                      "branches")) {
                                                                  version +=
                                                                    "; " +
                                                                    name;
                                                              }
                                                      }
                                                  }
                                                  if (version ==
                                                        null) {
                                                      version =
                                                        "development version";
                                                  }
                                                  return version;
    }
    public Version() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AbGTRED4EgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XaCwHQAA");
}
