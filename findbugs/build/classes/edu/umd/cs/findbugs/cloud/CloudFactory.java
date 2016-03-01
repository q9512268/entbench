package edu.umd.cs.findbugs.cloud;
public class CloudFactory {
    private static final java.lang.String FINDBUGS_NAMELOOKUP_CLASSNAME =
      "findbugs.namelookup.classname";
    private static final java.lang.String FINDBUGS_NAMELOOKUP_REQUIRED = "findbugs.namelookup.required";
    public static final java.lang.String FAIL_ON_CLOUD_ERROR_PROP = "findbugs.failOnCloudError";
    public static final boolean FAIL_ON_CLOUD_ERROR = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        FAIL_ON_CLOUD_ERROR_PROP,
        false);
    public static boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.cloud.debug",
        false);
    public static java.lang.String DEFAULT_CLOUD = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "findbugs.cloud.default");
    private static final java.util.logging.Logger LOGGER =
      java.util.logging.Logger.
      getLogger(
        edu.umd.cs.findbugs.cloud.CloudFactory.class.
          getName(
            ));
    @javax.annotation.Nonnull
    public static edu.umd.cs.findbugs.cloud.Cloud createCloudWithoutInitializing(edu.umd.cs.findbugs.BugCollection bc) {
        edu.umd.cs.findbugs.cloud.CloudPlugin plugin =
          getCloudPlugin(
            bc);
        if (plugin ==
              null) {
            LOGGER.
              log(
                java.util.logging.Level.
                  FINE,
                "default cloud " +
                DEFAULT_CLOUD +
                " not registered");
            return getPlainCloud(
                     bc);
        }
        LOGGER.
          log(
            java.util.logging.Level.
              FINE,
            "Using cloud plugin " +
            plugin.
              getId(
                ));
        try {
            java.lang.Class<? extends edu.umd.cs.findbugs.cloud.Cloud> cloudClass =
              plugin.
              getCloudClass(
                );
            java.util.Properties properties =
              bc.
              getProject(
                ).
              getCloudProperties(
                );
            java.lang.reflect.Constructor<? extends edu.umd.cs.findbugs.cloud.Cloud> constructor =
              cloudClass.
              getConstructor(
                edu.umd.cs.findbugs.cloud.CloudPlugin.class,
                edu.umd.cs.findbugs.BugCollection.class,
                java.util.Properties.class);
            edu.umd.cs.findbugs.cloud.Cloud cloud =
              constructor.
              newInstance(
                plugin,
                bc,
                properties);
            if (DEBUG) {
                bc.
                  getProject(
                    ).
                  getGuiCallback(
                    ).
                  showMessageDialog(
                    "constructed " +
                    cloud.
                      getClass(
                        ).
                      getName(
                        ));
            }
            LOGGER.
              log(
                java.util.logging.Level.
                  FINE,
                "constructed cloud plugin " +
                plugin.
                  getId(
                    ));
            if (!cloud.
                  availableForInitialization(
                    )) {
                handleInitializationException(
                  bc,
                  plugin,
                  new java.lang.IllegalStateException(
                    cloud.
                      getClass(
                        ).
                      getName(
                        ) +
                    " cloud " +
                    plugin.
                      getId(
                        ) +
                    " doesn\'t have information needed for initialization"));
            }
            return cloud;
        }
        catch (java.lang.reflect.InvocationTargetException e) {
            return handleInitializationException(
                     bc,
                     plugin,
                     e.
                       getCause(
                         ));
        }
        catch (java.lang.Exception e) {
            return handleInitializationException(
                     bc,
                     plugin,
                     e);
        }
    }
    public static edu.umd.cs.findbugs.cloud.CloudPlugin getCloudPlugin(edu.umd.cs.findbugs.BugCollection bc) {
        edu.umd.cs.findbugs.cloud.CloudPlugin plugin =
          null;
        edu.umd.cs.findbugs.Project project =
          bc.
          getProject(
            );
        assert project !=
          null;
        java.lang.String cloudId =
          project.
          getCloudId(
            );
        if (cloudId !=
              null) {
            plugin =
              edu.umd.cs.findbugs.DetectorFactoryCollection.
                instance(
                  ).
                getRegisteredClouds(
                  ).
                get(
                  cloudId);
            if (plugin ==
                  null &&
                  FAIL_ON_CLOUD_ERROR) {
                throw new java.lang.IllegalArgumentException(
                  "Cannot find registered cloud for " +
                  cloudId);
            }
        }
        if (plugin !=
              null) {
            edu.umd.cs.findbugs.Plugin fbplugin =
              edu.umd.cs.findbugs.Plugin.
              getByPluginId(
                plugin.
                  getFindbugsPluginId(
                    ));
            if (fbplugin !=
                  null &&
                  java.lang.Boolean.
                    FALSE.
                  equals(
                    project.
                      getPluginStatus(
                        fbplugin))) {
                plugin =
                  null;
            }
        }
        if (plugin ==
              null) {
            if (DEFAULT_CLOUD !=
                  null) {
                LOGGER.
                  log(
                    java.util.logging.Level.
                      FINE,
                    "Trying default cloud " +
                    DEFAULT_CLOUD);
            }
            cloudId =
              DEFAULT_CLOUD;
            plugin =
              edu.umd.cs.findbugs.DetectorFactoryCollection.
                instance(
                  ).
                getRegisteredClouds(
                  ).
                get(
                  cloudId);
        }
        return plugin;
    }
    public static edu.umd.cs.findbugs.cloud.Cloud handleInitializationException(edu.umd.cs.findbugs.BugCollection bc,
                                                                                edu.umd.cs.findbugs.cloud.CloudPlugin plugin,
                                                                                java.lang.Throwable e) {
        if (DEBUG) {
            bc.
              getProject(
                ).
              getGuiCallback(
                ).
              showMessageDialog(
                "failed " +
                e.
                  getMessage(
                    ) +
                e.
                  getClass(
                    ).
                  getName(
                    ));
        }
        LOGGER.
          log(
            java.util.logging.Level.
              WARNING,
            "Could not load cloud plugin " +
            plugin,
            e);
        if (edu.umd.cs.findbugs.SystemProperties.
              getBoolean(
                "findbugs.failIfUnableToConnectToCloud")) {
            java.lang.System.
              exit(
                1);
        }
        return getPlainCloud(
                 bc);
    }
    public static void initializeCloud(edu.umd.cs.findbugs.BugCollection bc,
                                       edu.umd.cs.findbugs.cloud.Cloud cloud)
          throws java.io.IOException { edu.umd.cs.findbugs.IGuiCallback callback =
                                         bc.
                                         getProject(
                                           ).
                                         getGuiCallback(
                                           );
                                       if (!cloud.
                                             availableForInitialization(
                                               )) {
                                           return;
                                       }
                                       if (DEBUG) {
                                           callback.
                                             showMessageDialog(
                                               "attempting to initialize " +
                                               cloud.
                                                 getClass(
                                                   ).
                                                 getName(
                                                   ));
                                       }
                                       if (!cloud.
                                             initialize(
                                               )) {
                                           throw new java.io.IOException(
                                             "Unable to connect to " +
                                             cloud.
                                               getCloudName(
                                                 ));
                                       }
                                       if (DEBUG) {
                                           callback.
                                             showMessageDialog(
                                               "initialized " +
                                               cloud.
                                                 getClass(
                                                   ).
                                                 getName(
                                                   ));
                                       } }
    @javax.annotation.Nonnull
    public static edu.umd.cs.findbugs.cloud.Cloud getPlainCloud(edu.umd.cs.findbugs.BugCollection bc) {
        edu.umd.cs.findbugs.cloud.DoNothingCloud cloud =
          new edu.umd.cs.findbugs.cloud.DoNothingCloud(
          bc);
        if (cloud.
              initialize(
                )) {
            return cloud;
        }
        throw new java.lang.IllegalStateException(
          "Unable to initialize DoNothingCloud");
    }
    public CloudFactory() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0XT80Y1Bsz7PE6haZWW9iEex6CBFb4eXukrJHnZ3Ztdl78669y8/b8l2XMg5" +
       "nfY1TXESp7+XAcSs8QdMrygvH/r74oGrhvddwJF7mcdKXpI/6nny1e2r+XuD" +
       "7KLQKBiLLhjdi9rcAFWjYqKrkhuSVhb82kz9dTU8V5h+vcIbznYsXeCG9KPo" +
       "OaZZIGzGdHOpS58OPWufQZhET5U57P2YNo8R1MSrGKpUVslcL4CNdBKVIJ3Q" +
       "K2PYKxbHZVNcM9n76HH3Pqot7KOAa0fmQ7bvQ72yJOmiWGYDfp3zGO3oUFj/" +
       "DwuWbqJj6+C53rT09ZfMd34US/uO/jzOmP2qjFt+TZvnCZqVxYQZNiHqgFmW" +
       "6VZN4QbHbOaMk1Nh9kVYlJWOWxC9NzH+yCWzqB9Fj8Eq7CRxnDYvWeaZY5+D" +
       "BuhFFr1fYdKcKWPyt2hzGo5aw5yUFnEh+o2vRHkeK9aF1TO2YV//BgzLUn8E" +
       "nltMM9xyyQzrR9FjlqBNihn2Gcbxg/JgZBhdkEPReMFabN2HtPkTod+pTJNi" +
       "GytYEzJEHSNo2qgsOEDk3W/AvAzFQ/BMmsaYvGTm9aM4FRJ8ViYsv6DNJ1CY" +
       "ARIkRE4wDpueMPzUF2xp93OXBFCh7Kh1fkqg914Liz5UGh/X+ONH66sXHB08" +
       "yyqNwgewWqgZMgDwzpsZx3ulouKMwLSuNe5pWPkfABxY5At4UG/zhWj6ylhQ" +
       "AdFYYgEB7uarc3YlQTX2bIKCvGt4BhyGzGGCKqB1DtZCFwzS1zrF2gmOaxjj" +
       "AisfcFd8Bb/Nmyq+HUXiSldxxT4kW4WQbnxKTvInju7sven81keN63de5A4e" +
       "pFRmwtnLuOQvFFPNvtQsWpU7Wr+c9fSMVVbZ6br+d8rGwgNCjV2VL/bcR2st" +
       "hWvpd45te+H1I5Vn4LS5GwU48NHu4qu+vKJDFbs7VnzGhMKTXZS3tf5g/Kp1" +
       "mU/+yC5TkXEmXeI/P8kP3fd29OmRL65hXy6nQwTgPLuD7BqX+jA/qroOrLNo" +
       "sHL08ozZwTRfXaGXfochaEXxeb3461WNKI9htUPWJbZf4cg70+6ximhX/akr" +
       "imeB3eO4orjZAE1qfYi/ZKxHUcyPGMGzCtuuE6XAZoKF7HL2St+a/w+745t+" +
       "UyIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a0fdceUyqM90XjoATaCzeLzsHyvtmTuh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fZ5Fdul8CHGyPk++mSqeiTrecy5WKNN5j/f1ZJ/Qe1v98ms09/HvtH5+n5Kl" +
       "2nKeF1geZivX9tlhJ7HBi/fEdozrav+l7z3+lUfeexzHPL4n+FS/z9D2wt1z" +
       "ngjHj8sspfyfvuMf/cgvvPYH5aXY/wPnkLG4Zy0AAA==");
}
