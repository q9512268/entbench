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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qXTUIIdogVIdbihgpD3pzEUGW6zW3qgQrMEzdK1W6nqzDMNyI6Q1PPR0FpYS" +
       "fd1ZuqG7ljoltjpqrEtktSvilD50JDL0p/24Oel3A5rjm7GvCRvYXDhNNBlK" +
       "HduJxRCtsAbrm24SEt1KhexXk3BKD+ZKh0yE2JxNmbHRo8oRJ69rOLNgTNYS" +
       "TFcLYSocr4iA2UwVdrqBsWormQs4WrI8oxKP/MST/CYqxz5OwTrMNmMmMEzf" +
       "TRGTbsN9kwFZDTwqFMU1e5TbHomuRFiIA8TBqbifhj2TmuF4VhK/86e7ldyX" +
       "X8CO+t/gMpJtNH+Kajy9/YF7RwdS6VEvKv/c/TK9qGP3dSi7eDx0p253fun4" +
       "9DPPPa/3P1PaO+hziDF0Kfb8t9nG0rCPkcouf2+58wWrmzf7d/fvrzzzLw+O" +
       "3mG++6foMD5yis/TJH+3+8LXmm/Wfn0POnt0G7/lNcRJpBsn7+CXQyNOQnd0" +
       "4ib+0JFmX59p7AnwpQ40S92+y/cKtiK3fvEyvaToZfaSbHBj6PLMiA8u87k3" +
       "7RzJe6Vr3YnuTQxdOCCTNcYeuOX91Padivb5569cfN3zwl/nrdWj9x6XWOji" +
       "NLHt432MY/PzfmhMrZztS9uuhp//vDeGrp7ubsfQufw35/A9W7j3ATF3cDF0" +
       "fjs5DvJMDJ0FINn0g/5tOhrb9kx65qTTH+nq2ivp6licPHHCu/P3fYeemGzf" +
       "+N3UvvB8u/eel6qf2XZyNVvZbDIqF1nowrapfOTNj92R2iGt860nf3zvFy+9" +
       "6TDy7t0yvPOxY7w9cvtWKeX4cd7c3Pzh637/7b/9/LfzBsv/Aj7/dM+IHQAA");
}
