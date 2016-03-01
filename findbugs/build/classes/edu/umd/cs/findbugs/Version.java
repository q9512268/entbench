package edu.umd.cs.findbugs;
public class Version {
    public static final int MAJOR = 3;
    public static final int MINOR = 0;
    public static final int PATCHLEVEL = 1;
    public static final boolean IS_DEVELOPMENT = true;
    public static final int RELEASE_CANDIDATE = 0;
    public static final java.lang.String GIT_REVISION = java.lang.System.
      getProperty(
        "git.revision",
        "UNKNOWN");
    private static final java.lang.String COMPUTED_DATE;
    public static final java.lang.String DATE;
    public static final java.lang.String CORE_PLUGIN_RELEASE_DATE;
    private static final java.lang.String COMPUTED_ECLIPSE_DATE;
    private static final java.lang.String COMPUTED_PLUGIN_RELEASE_DATE;
    private static java.lang.String applicationName = "";
    private static java.lang.String applicationVersion = "";
    static { java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
               "HH:mm:ss z, dd MMMM, yyyy",
               java.util.Locale.
                 ENGLISH);
             java.text.SimpleDateFormat eclipseDateFormat = new java.text.SimpleDateFormat(
               "yyyyMMdd",
               java.util.Locale.
                 ENGLISH);
             java.text.SimpleDateFormat releaseDateFormat =
               new java.text.SimpleDateFormat(
               edu.umd.cs.findbugs.updates.UpdateChecker.
                 PLUGIN_RELEASE_DATE_FMT,
               java.util.Locale.
                 ENGLISH);
             java.util.Date now = new java.util.Date();
             COMPUTED_DATE = dateFormat.format(now);
             COMPUTED_ECLIPSE_DATE = eclipseDateFormat.format(
                                                         now);
             java.lang.String tmp = releaseDateFormat.format(
                                                        now);
             COMPUTED_PLUGIN_RELEASE_DATE = tmp; }
    public static final int PREVIEW = 0;
    private static final java.lang.String RELEASE_SUFFIX_WORD;
    static { java.lang.String suffix;
             if (RELEASE_CANDIDATE > 0) { suffix = "rc" +
                                                   RELEASE_CANDIDATE;
             }
             else
                 if (PREVIEW >
                       0) {
                     suffix =
                       "preview" +
                       PREVIEW;
                 }
                 else {
                     suffix =
                       "dev-" +
                       COMPUTED_ECLIPSE_DATE;
                     if (!"Unknown".
                           equals(
                             GIT_REVISION)) {
                         suffix +=
                           "-" +
                           GIT_REVISION;
                     }
                 }
             RELEASE_SUFFIX_WORD = suffix; }
    public static final java.lang.String RELEASE_BASE = MAJOR +
    "." +
    MINOR +
    "." +
    PATCHLEVEL;
    public static final java.lang.String COMPUTED_RELEASE =
      RELEASE_BASE +
    (IS_DEVELOPMENT
       ? "-" +
     RELEASE_SUFFIX_WORD
       : "");
    public static final java.lang.String RELEASE;
    private static final java.lang.String COMPUTED_ECLIPSE_UI_VERSION =
      RELEASE_BASE +
    "." +
    COMPUTED_ECLIPSE_DATE;
    static { java.lang.Class<edu.umd.cs.findbugs.Version> c =
               edu.umd.cs.findbugs.Version.class;
             java.net.URL u = c.getResource(c.getSimpleName(
                                                ) + ".class");
             boolean fromFile = "file".equals(u.getProtocol(
                                                  ));
             java.io.InputStream in = null;
             java.lang.String release = null;
             java.lang.String date = null;
             java.lang.String plugin_release_date = null;
             if (!fromFile) { try { java.util.Properties versionProperties =
                                      new java.util.Properties(
                                      );
                                    in = edu.umd.cs.findbugs.Version.class.
                                           getResourceAsStream(
                                             "version.properties");
                                    if (in != null) { versionProperties.
                                                        load(
                                                          in);
                                                      release =
                                                        (java.lang.String)
                                                          versionProperties.
                                                          get(
                                                            "release.number");
                                                      date =
                                                        (java.lang.String)
                                                          versionProperties.
                                                          get(
                                                            "release.date");
                                                      plugin_release_date =
                                                        (java.lang.String)
                                                          versionProperties.
                                                          get(
                                                            "plugin.release.date");
                                    } }
                              catch (java.lang.Exception e) {
                                  assert true;
                              }
                              finally { edu.umd.cs.findbugs.util.Util.
                                          closeSilently(
                                            in); }
             }
             if (release == null) { release = COMPUTED_RELEASE;
             }
             if (date == null) { date = COMPUTED_DATE;
             }
             if (plugin_release_date == null) { plugin_release_date =
                                                  COMPUTED_PLUGIN_RELEASE_DATE;
             }
             RELEASE = release;
             DATE = date;
             CORE_PLUGIN_RELEASE_DATE = plugin_release_date;
             java.util.Date parsedDate;
             try { java.text.SimpleDateFormat fmt =
                     new java.text.SimpleDateFormat(
                     edu.umd.cs.findbugs.updates.UpdateChecker.
                       PLUGIN_RELEASE_DATE_FMT,
                     java.util.Locale.
                       ENGLISH);
                   parsedDate = fmt.parse(CORE_PLUGIN_RELEASE_DATE);
             }
             catch (java.text.ParseException e) {
                 if (edu.umd.cs.findbugs.SystemProperties.
                       ASSERTIONS_ENABLED) {
                     e.
                       printStackTrace(
                         );
                 }
                 parsedDate =
                   null;
             }
             releaseDate = parsedDate; }
    public static final java.lang.String WEBSITE =
      "http://findbugs.sourceforge.net";
    public static final java.lang.String DOWNLOADS_WEBSITE =
      "http://prdownloads.sourceforge.net/findbugs";
    public static final java.lang.String SUPPORT_EMAIL =
      "http://findbugs.sourceforge.net/reportingBugs.html";
    private static java.util.Date releaseDate;
    public static void registerApplication(java.lang.String name,
                                           java.lang.String version) {
        applicationName =
          name;
        applicationVersion =
          version;
    }
    @javax.annotation.CheckForNull
    public static java.lang.String getApplicationName() {
        return applicationName;
    }
    @javax.annotation.CheckForNull
    public static java.lang.String getApplicationVersion() {
        return applicationVersion;
    }
    public static void main(java.lang.String[] argv)
          throws java.lang.InterruptedException {
        if (!IS_DEVELOPMENT &&
              RELEASE_CANDIDATE !=
              0) {
            throw new java.lang.IllegalStateException(
              "Non developmental version, but is release candidate " +
              RELEASE_CANDIDATE);
        }
        if (argv.
              length ==
              0) {
            printVersion(
              false);
            return;
        }
        java.lang.String arg =
          argv[0];
        if ("-release".
              equals(
                arg)) {
            java.lang.System.
              out.
              println(
                RELEASE);
        }
        else
            if ("-date".
                  equals(
                    arg)) {
                java.lang.System.
                  out.
                  println(
                    DATE);
            }
            else
                if ("-props".
                      equals(
                        arg)) {
                    java.lang.System.
                      out.
                      println(
                        "release.base=" +
                        RELEASE_BASE);
                    java.lang.System.
                      out.
                      println(
                        "release.number=" +
                        COMPUTED_RELEASE);
                    java.lang.System.
                      out.
                      println(
                        "release.date=" +
                        COMPUTED_DATE);
                    java.lang.System.
                      out.
                      println(
                        "plugin.release.date=" +
                        COMPUTED_PLUGIN_RELEASE_DATE);
                    java.lang.System.
                      out.
                      println(
                        "eclipse.ui.version=" +
                        COMPUTED_ECLIPSE_UI_VERSION);
                    java.lang.System.
                      out.
                      println(
                        "findbugs.website=" +
                        WEBSITE);
                    java.lang.System.
                      out.
                      println(
                        "findbugs.downloads.website=" +
                        DOWNLOADS_WEBSITE);
                    java.lang.System.
                      out.
                      println(
                        "findbugs.git.revision=" +
                        GIT_REVISION);
                }
                else
                    if ("-plugins".
                          equals(
                            arg)) {
                        edu.umd.cs.findbugs.DetectorFactoryCollection.
                          instance(
                            );
                        for (edu.umd.cs.findbugs.Plugin p
                              :
                              edu.umd.cs.findbugs.Plugin.
                               getAllPlugins(
                                 )) {
                            java.lang.System.
                              out.
                              println(
                                "Plugin: " +
                                p.
                                  getPluginId(
                                    ));
                            java.lang.System.
                              out.
                              println(
                                "  description: " +
                                p.
                                  getShortDescription(
                                    ));
                            java.lang.System.
                              out.
                              println(
                                "     provider: " +
                                p.
                                  getProvider(
                                    ));
                            java.lang.String version =
                              p.
                              getVersion(
                                );
                            if (version !=
                                  null &&
                                  version.
                                  length(
                                    ) >
                                  0) {
                                java.lang.System.
                                  out.
                                  println(
                                    "      version: " +
                                    version);
                            }
                            java.lang.String website =
                              p.
                              getWebsite(
                                );
                            if (website !=
                                  null &&
                                  website.
                                  length(
                                    ) >
                                  0) {
                                java.lang.System.
                                  out.
                                  println(
                                    "      website: " +
                                    website);
                            }
                            java.lang.System.
                              out.
                              println(
                                );
                        }
                    }
                    else
                        if ("-configuration".
                              equals(
                                arg)) {
                            printVersion(
                              true);
                        }
                        else {
                            usage(
                              );
                            java.lang.System.
                              exit(
                                1);
                        }
    }
    private static void usage() { java.lang.System.
                                    err.println("Usage: " +
                                                edu.umd.cs.findbugs.Version.class.
                                                  getName(
                                                    ) +
                                                "  [(-release|-date|-props|-configuration)]");
    }
    public static java.lang.String getReleaseWithDateIfDev() {
        if (IS_DEVELOPMENT) {
            return RELEASE +
            " (" +
            DATE +
            ")";
        }
        return RELEASE;
    }
    @javax.annotation.CheckForNull
    public static java.util.Date getReleaseDate() {
        return releaseDate;
    }
    public static void printVersion(boolean justPrintConfiguration)
          throws java.lang.InterruptedException {
        java.lang.System.
          out.
          println(
            "FindBugs " +
            edu.umd.cs.findbugs.Version.
              COMPUTED_RELEASE);
        if (justPrintConfiguration) {
            for (edu.umd.cs.findbugs.Plugin plugin
                  :
                  edu.umd.cs.findbugs.Plugin.
                   getAllPlugins(
                     )) {
                java.lang.System.
                  out.
                  printf(
                    "Plugin %s, version %s, loaded from %s%n",
                    plugin.
                      getPluginId(
                        ),
                    plugin.
                      getVersion(
                        ),
                    plugin.
                      getPluginLoader(
                        ).
                      getURL(
                        ));
                if (plugin.
                      isCorePlugin(
                        )) {
                    java.lang.System.
                      out.
                      println(
                        "  is core plugin");
                }
                if (plugin.
                      isInitialPlugin(
                        )) {
                    java.lang.System.
                      out.
                      println(
                        "  is initial plugin");
                }
                if (plugin.
                      isEnabledByDefault(
                        )) {
                    java.lang.System.
                      out.
                      println(
                        "  is enabled by default");
                }
                if (plugin.
                      isGloballyEnabled(
                        )) {
                    java.lang.System.
                      out.
                      println(
                        "  is globally enabled");
                }
                edu.umd.cs.findbugs.Plugin parent =
                  plugin.
                  getParentPlugin(
                    );
                if (parent !=
                      null) {
                    java.lang.System.
                      out.
                      println(
                        "  has parent plugin " +
                        parent.
                          getPluginId(
                            ));
                }
                for (edu.umd.cs.findbugs.cloud.CloudPlugin cloudPlugin
                      :
                      plugin.
                       getCloudPlugins(
                         )) {
                    java.lang.System.
                      out.
                      printf(
                        "  cloud %s%n",
                        cloudPlugin.
                          getId(
                            ));
                    java.lang.System.
                      out.
                      printf(
                        "     %s%n",
                        cloudPlugin.
                          getDescription(
                            ));
                }
                for (edu.umd.cs.findbugs.DetectorFactory factory
                      :
                      plugin.
                       getDetectorFactories(
                         )) {
                    java.lang.System.
                      out.
                      printf(
                        "  detector %s%n",
                        factory.
                          getShortName(
                            ));
                }
                java.lang.System.
                  out.
                  println(
                    );
            }
            printPluginUpdates(
              true,
              10);
        }
        else {
            printPluginUpdates(
              false,
              3);
        }
    }
    private static void printPluginUpdates(boolean verbose,
                                           int secondsToWait)
          throws java.lang.InterruptedException {
        edu.umd.cs.findbugs.DetectorFactoryCollection dfc =
          edu.umd.cs.findbugs.DetectorFactoryCollection.
          instance(
            );
        if (dfc.
              getUpdateChecker(
                ).
              updateChecksGloballyDisabled(
                )) {
            if (verbose) {
                java.lang.System.
                  out.
                  println(
                    );
                java.lang.System.
                  out.
                  print(
                    "Update checking globally disabled");
            }
            return;
        }
        if (verbose) {
            java.lang.System.
              out.
              println(
                );
            java.lang.System.
              out.
              print(
                "Checking for plugin updates...");
        }
        edu.umd.cs.findbugs.util.FutureValue<java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate>> updateHolder =
          dfc.
          getUpdates(
            );
        try {
            java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> updates =
              updateHolder.
              get(
                secondsToWait,
                java.util.concurrent.TimeUnit.
                  SECONDS);
            if (updates.
                  isEmpty(
                    )) {
                if (verbose) {
                    java.lang.System.
                      out.
                      println(
                        "none!");
                }
            }
            else {
                java.lang.System.
                  out.
                  println(
                    );
                for (edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate update
                      :
                      updates) {
                    java.lang.System.
                      out.
                      println(
                        update);
                    java.lang.System.
                      out.
                      println(
                        );
                }
            }
        }
        catch (java.util.concurrent.TimeoutException e) {
            if (verbose) {
                java.lang.System.
                  out.
                  println(
                    "Timeout while trying to get updates");
            }
        }
    }
    public Version() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "amh6pcYKXNeHNyKSr4yKNrQkdtRKSGHu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "NgTgUQDmvr1c3XdRdTv5/f8mvFjfpOzdRRYDtiaRstRPUZe8COq2IUBlQNWV" +
       "PXVXfkSW9X03KXt/kT0dl14BLOtwFx0hmbFRhEJ0F6SenrKt73kR9L6heIgA" +
       "Ol+5p/eVPyJ6f/YmZT9XZH8nLt13TO9h2MdfHpP5d3/ES0gRcfG6PRde90Pk" +
       "wl53i1t7S+6z51a4tFPdXy6yX4xL9wTAusbHC+pJIf8HL1aFOTDkPgT/0g0h" +
       "+C9ChU/4nHaRsVuSPvl8ND9XZJ8AjteWZsFJlqY3DrR9UNBJyp83dPe6U2px" +
       "6Y49A4sDgA/fcPh+d2Bc/fSz99/5imfH/2G3Bh8e6r6LKd25AL7ayfNaJ65v" +
       "D0J9YW65cNfu9NZ28bv062AZOuMgbww6219uafq1Xe1/GpfuPq4dly6r1xX/" +
       "C0DBvjgu3QLyk4W/DR6BwuLys8Hh6nDi0MPulFq+WzgePiENu33gledj5Ykd" +
       "3WPX+T/b/3VwuGdKdv/t4Jr6mWd73Lu/1/jE7kCr6iibTdHLncBV2Z2t3bsq" +
       "J89ine7tsK/bO0/84L5fvesNh3vE+3aAjyXzBLZHzz4xSrlBvD3jufnnr/iN" +
       "n/hHz/7x9qzb/wNq3SF/hEIAAA==");
}
