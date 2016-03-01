package edu.umd.cs.findbugs.updates;
public class UpdateChecker {
    public static final java.lang.String PLUGIN_RELEASE_DATE_FMT = "MM/dd/yyyy hh:mm aa z";
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.
      getLogger(
        edu.umd.cs.findbugs.updates.UpdateChecker.class.
          getName(
            ));
    private static final java.lang.String KEY_DISABLE_ALL_UPDATE_CHECKS =
      "noUpdateChecks";
    private static final java.lang.String KEY_REDIRECT_ALL_UPDATE_CHECKS =
      "redirectUpdateChecks";
    private static final boolean ENV_FB_NO_UPDATE_CHECKS = java.lang.System.
      getenv(
        "FB_NO_UPDATE_CHECKS") !=
      null;
    private final edu.umd.cs.findbugs.updates.UpdateCheckCallback
      dfc;
    private final java.util.List<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate>
      pluginUpdates =
      new java.util.concurrent.CopyOnWriteArrayList<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate>(
      );
    public UpdateChecker(edu.umd.cs.findbugs.updates.UpdateCheckCallback dfc) {
        super(
          );
        this.
          dfc =
          dfc;
    }
    public void checkForUpdates(java.util.Collection<edu.umd.cs.findbugs.Plugin> plugins,
                                final boolean force) {
        if (updateChecksGloballyDisabled(
              )) {
            dfc.
              pluginUpdateCheckComplete(
                pluginUpdates,
                force);
            return;
        }
        java.net.URI redirectUri =
          getRedirectURL(
            force);
        final java.util.concurrent.CountDownLatch latch;
        if (redirectUri !=
              null) {
            latch =
              new java.util.concurrent.CountDownLatch(
                1);
            startUpdateCheckThread(
              redirectUri,
              plugins,
              latch);
        }
        else {
            edu.umd.cs.findbugs.util.MultiMap<java.net.URI,edu.umd.cs.findbugs.Plugin> pluginsByUrl =
              new edu.umd.cs.findbugs.util.MultiMap<java.net.URI,edu.umd.cs.findbugs.Plugin>(
              java.util.HashSet.class);
            for (edu.umd.cs.findbugs.Plugin plugin
                  :
                  plugins) {
                java.net.URI uri =
                  plugin.
                  getUpdateUrl(
                    );
                if (uri ==
                      null) {
                    logError(
                      java.util.logging.Level.
                        FINE,
                      "Not checking for updates for " +
                      plugin.
                        getShortDescription(
                          ) +
                      " - no update-url attribute in plugin XML file");
                    continue;
                }
                pluginsByUrl.
                  add(
                    uri,
                    plugin);
            }
            latch =
              new java.util.concurrent.CountDownLatch(
                pluginsByUrl.
                  keySet(
                    ).
                  size(
                    ));
            for (java.net.URI uri
                  :
                  pluginsByUrl.
                   keySet(
                     )) {
                startUpdateCheckThread(
                  uri,
                  pluginsByUrl.
                    get(
                      uri),
                  latch);
            }
        }
        waitForCompletion(
          latch,
          force);
    }
    @javax.annotation.CheckForNull
    public java.net.URI getRedirectURL(final boolean force) {
        java.lang.String redirect =
          dfc.
          getGlobalOption(
            KEY_REDIRECT_ALL_UPDATE_CHECKS);
        java.lang.String sysprop =
          java.lang.System.
          getProperty(
            "findbugs.redirectUpdateChecks");
        if (sysprop !=
              null) {
            redirect =
              sysprop;
        }
        edu.umd.cs.findbugs.Plugin setter =
          dfc.
          getGlobalOptionSetter(
            KEY_REDIRECT_ALL_UPDATE_CHECKS);
        java.net.URI redirectUri =
          null;
        java.lang.String pluginName =
          setter ==
          null
          ? "<unknown plugin>"
          : setter.
          getShortDescription(
            );
        if (redirect !=
              null &&
              !"".
              equals(
                redirect.
                  trim(
                    ))) {
            try {
                redirectUri =
                  new java.net.URI(
                    redirect);
                logError(
                  java.util.logging.Level.
                    INFO,
                  "Redirecting all plugin update checks to " +
                  redirectUri +
                  " (" +
                  pluginName +
                  ")");
            }
            catch (java.net.URISyntaxException e) {
                java.lang.String error =
                  "Invalid update check redirect URI in " +
                pluginName +
                ": " +
                redirect;
                logError(
                  java.util.logging.Level.
                    SEVERE,
                  error);
                dfc.
                  pluginUpdateCheckComplete(
                    pluginUpdates,
                    force);
                throw new java.lang.IllegalStateException(
                  error);
            }
        }
        return redirectUri;
    }
    private long dontWarnAgainUntil() { java.util.prefs.Preferences prefs =
                                          java.util.prefs.Preferences.
                                          userNodeForPackage(
                                            edu.umd.cs.findbugs.updates.UpdateChecker.class);
                                        java.lang.String oldSeen =
                                          prefs.
                                          get(
                                            "last-plugin-update-seen",
                                            "");
                                        if (oldSeen ==
                                              null ||
                                              "".
                                              equals(
                                                oldSeen)) {
                                            return 0;
                                        }
                                        try {
                                            return java.lang.Long.
                                              parseLong(
                                                oldSeen) +
                                              DONT_REMIND_WINDOW;
                                        }
                                        catch (java.lang.Exception e) {
                                            return 0;
                                        }
    }
    static final long DONT_REMIND_WINDOW =
      3L *
      24 *
      60 *
      60 *
      1000;
    public boolean updatesHaveBeenSeenBefore(java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> updates) {
        long now =
          java.lang.System.
          currentTimeMillis(
            );
        java.util.prefs.Preferences prefs =
          java.util.prefs.Preferences.
          userNodeForPackage(
            edu.umd.cs.findbugs.updates.UpdateChecker.class);
        java.lang.String oldHash =
          prefs.
          get(
            "last-plugin-update-hash",
            "");
        java.lang.String newHash =
          java.lang.Integer.
          toString(
            buildPluginUpdateHash(
              updates));
        if (oldHash.
              equals(
                newHash) &&
              dontWarnAgainUntil(
                ) >
              now) {
            LOGGER.
              fine(
                ("Skipping update dialog because these updates have been seen " +
                 "before"));
            return true;
        }
        prefs.
          put(
            "last-plugin-update-hash",
            newHash);
        prefs.
          put(
            "last-plugin-update-seen",
            java.lang.Long.
              toString(
                now));
        return false;
    }
    private int buildPluginUpdateHash(java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> updates) {
        java.util.HashSet<java.lang.String> builder =
          new java.util.HashSet<java.lang.String>(
          );
        for (edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate update
              :
              updates) {
            builder.
              add(
                update.
                  getPlugin(
                    ).
                  getPluginId(
                    ) +
                update.
                  getVersion(
                    ));
        }
        return builder.
          hashCode(
            );
    }
    private void waitForCompletion(final java.util.concurrent.CountDownLatch latch,
                                   final boolean force) {
        edu.umd.cs.findbugs.util.Util.
          runInDameonThread(
            new java.lang.Runnable(
              ) {
                @java.lang.Override
                public void run() {
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Checking for version updates");
                    }
                    try {
                        if (!latch.
                              await(
                                15,
                                java.util.concurrent.TimeUnit.
                                  SECONDS)) {
                            logError(
                              java.util.logging.Level.
                                INFO,
                              "Update check timed out");
                        }
                        dfc.
                          pluginUpdateCheckComplete(
                            pluginUpdates,
                            force);
                    }
                    catch (java.lang.Exception ignored) {
                        assert true;
                    }
                }
            },
            "Plugin update checker");
    }
    public boolean updateChecksGloballyDisabled() {
        return ENV_FB_NO_UPDATE_CHECKS ||
          getPluginThatDisabledUpdateChecks(
            ) !=
          null;
    }
    public java.lang.String getPluginThatDisabledUpdateChecks() {
        java.lang.String disable =
          dfc.
          getGlobalOption(
            KEY_DISABLE_ALL_UPDATE_CHECKS);
        edu.umd.cs.findbugs.Plugin setter =
          dfc.
          getGlobalOptionSetter(
            KEY_DISABLE_ALL_UPDATE_CHECKS);
        java.lang.String pluginName =
          setter ==
          null
          ? "<unknown plugin>"
          : setter.
          getShortDescription(
            );
        java.lang.String disablingPlugin =
          null;
        if ("true".
              equalsIgnoreCase(
                disable)) {
            logError(
              java.util.logging.Level.
                INFO,
              "Skipping update checks due to " +
              KEY_DISABLE_ALL_UPDATE_CHECKS +
              "=true set by " +
              pluginName);
            disablingPlugin =
              pluginName;
        }
        else
            if (disable !=
                  null &&
                  !"false".
                  equalsIgnoreCase(
                    disable)) {
                java.lang.String error =
                  "Unknown value \'" +
                disable +
                "\' for " +
                KEY_DISABLE_ALL_UPDATE_CHECKS +
                " in " +
                pluginName;
                logError(
                  java.util.logging.Level.
                    SEVERE,
                  error);
                throw new java.lang.IllegalStateException(
                  error);
            }
        return disablingPlugin;
    }
    private void startUpdateCheckThread(final java.net.URI url,
                                        final java.util.Collection<edu.umd.cs.findbugs.Plugin> plugins,
                                        final java.util.concurrent.CountDownLatch latch) {
        if (url ==
              null) {
            logError(
              java.util.logging.Level.
                INFO,
              "Not checking for plugin updates w/ blank URL: " +
              getPluginNames(
                plugins));
            return;
        }
        final java.lang.String entryPoint =
          getEntryPoint(
            );
        if ((entryPoint.
               contains(
                 "edu.umd.cs.findbugs.FindBugsTestCase") ||
               entryPoint.
               contains(
                 "edu.umd.cs.findbugs.cloud.appEngine.AbstractWebCloudTest")) &&
              ("http".
                 equals(
                   url.
                     getScheme(
                       )) ||
                 "https".
                 equals(
                   url.
                     getScheme(
                       )))) {
            LOGGER.
              fine(
                ("Skipping update check because we\'re running in FindBugsTest" +
                 "Case and using ") +
                url.
                  getScheme(
                    ));
            return;
        }
        java.lang.Runnable r =
          new java.lang.Runnable(
          ) {
            @java.lang.Override
            public void run() {
                try {
                    actuallyCheckforUpdates(
                      url,
                      plugins,
                      entryPoint);
                }
                catch (java.lang.Exception e) {
                    if (e instanceof java.lang.IllegalStateException &&
                          e.
                          getMessage(
                            ).
                          contains(
                            "Shutdown in progress")) {
                        return;
                    }
                    logError(
                      e,
                      "Error doing update check at " +
                      url);
                }
                finally {
                    latch.
                      countDown(
                        );
                }
            }
        };
        if (DEBUG) {
            r.
              run(
                );
        }
        else {
            edu.umd.cs.findbugs.util.Util.
              runInDameonThread(
                r,
                "Check for updates");
        }
    }
    static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.updatecheck.debug");
    protected void actuallyCheckforUpdates(java.net.URI url,
                                           java.util.Collection<edu.umd.cs.findbugs.Plugin> plugins,
                                           java.lang.String entryPoint)
          throws java.io.IOException { LOGGER.
                                         fine(
                                           "Checking for updates at " +
                                           url +
                                           " for " +
                                           getPluginNames(
                                             plugins));
                                       if (DEBUG) {
                                           java.lang.System.
                                             out.
                                             println(
                                               url);
                                       }
                                       java.net.HttpURLConnection conn =
                                         (java.net.HttpURLConnection)
                                           url.
                                           toURL(
                                             ).
                                           openConnection(
                                             );
                                       conn.
                                         setDoInput(
                                           true);
                                       conn.
                                         setDoOutput(
                                           true);
                                       conn.
                                         setRequestMethod(
                                           "POST");
                                       conn.
                                         connect(
                                           );
                                       java.io.OutputStream out =
                                         conn.
                                         getOutputStream(
                                           );
                                       writeXml(
                                         out,
                                         plugins,
                                         entryPoint,
                                         true);
                                       if (DEBUG) {
                                           java.lang.System.
                                             out.
                                             println(
                                               "Sending");
                                           writeXml(
                                             java.lang.System.
                                               out,
                                             plugins,
                                             entryPoint,
                                             false);
                                       }
                                       int responseCode =
                                         conn.
                                         getResponseCode(
                                           );
                                       if (responseCode !=
                                             200) {
                                           logError(
                                             edu.umd.cs.findbugs.SystemProperties.
                                               ASSERTIONS_ENABLED
                                               ? java.util.logging.Level.
                                                   WARNING
                                               : java.util.logging.Level.
                                                   FINE,
                                             "Error checking for updates at " +
                                             url +
                                             ": " +
                                             responseCode +
                                             " - " +
                                             conn.
                                               getResponseMessage(
                                                 ));
                                       }
                                       else {
                                           parseUpdateXml(
                                             url,
                                             plugins,
                                             conn.
                                               getInputStream(
                                                 ));
                                       }
                                       conn.
                                         disconnect(
                                           );
    }
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("OBL_UNSATISFIED_OBLIGATION") 
    protected final void writeXml(java.io.OutputStream out,
                                  java.util.Collection<edu.umd.cs.findbugs.Plugin> plugins,
                                  java.lang.String entryPoint,
                                  boolean finish)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.OutputStreamXMLOutput xmlOutput =
                                         new edu.umd.cs.findbugs.xml.OutputStreamXMLOutput(
                                         out);
                                       try {
                                           xmlOutput.
                                             beginDocument(
                                               );
                                           xmlOutput.
                                             startTag(
                                               "findbugs-invocation");
                                           xmlOutput.
                                             addAttribute(
                                               "version",
                                               edu.umd.cs.findbugs.Version.
                                                 RELEASE);
                                           java.lang.String applicationName =
                                             edu.umd.cs.findbugs.Version.
                                             getApplicationName(
                                               );
                                           if (applicationName ==
                                                 null ||
                                                 "".
                                                 equals(
                                                   applicationName)) {
                                               int lastDot =
                                                 entryPoint.
                                                 lastIndexOf(
                                                   '.');
                                               if (lastDot ==
                                                     -1) {
                                                   applicationName =
                                                     entryPoint;
                                               }
                                               else {
                                                   applicationName =
                                                     entryPoint.
                                                       substring(
                                                         lastDot +
                                                           1);
                                               }
                                           }
                                           xmlOutput.
                                             addAttribute(
                                               "app-name",
                                               applicationName);
                                           java.lang.String applicationVersion =
                                             edu.umd.cs.findbugs.Version.
                                             getApplicationVersion(
                                               );
                                           if (applicationVersion ==
                                                 null) {
                                               applicationVersion =
                                                 "";
                                           }
                                           xmlOutput.
                                             addAttribute(
                                               "app-version",
                                               applicationVersion);
                                           xmlOutput.
                                             addAttribute(
                                               "entry-point",
                                               entryPoint);
                                           xmlOutput.
                                             addAttribute(
                                               "os",
                                               edu.umd.cs.findbugs.SystemProperties.
                                                 getProperty(
                                                   "os.name",
                                                   ""));
                                           xmlOutput.
                                             addAttribute(
                                               "java-version",
                                               getMajorJavaVersion(
                                                 ));
                                           java.util.Locale locale =
                                             java.util.Locale.
                                             getDefault(
                                               );
                                           xmlOutput.
                                             addAttribute(
                                               "language",
                                               locale.
                                                 getLanguage(
                                                   ));
                                           xmlOutput.
                                             addAttribute(
                                               "country",
                                               locale.
                                                 getCountry(
                                                   ));
                                           xmlOutput.
                                             addAttribute(
                                               "uuid",
                                               getUuid(
                                                 ));
                                           xmlOutput.
                                             stopTag(
                                               false);
                                           for (edu.umd.cs.findbugs.Plugin plugin
                                                 :
                                                 plugins) {
                                               xmlOutput.
                                                 startTag(
                                                   "plugin");
                                               xmlOutput.
                                                 addAttribute(
                                                   "id",
                                                   plugin.
                                                     getPluginId(
                                                       ));
                                               xmlOutput.
                                                 addAttribute(
                                                   "name",
                                                   plugin.
                                                     getShortDescription(
                                                       ));
                                               xmlOutput.
                                                 addAttribute(
                                                   "version",
                                                   plugin.
                                                     getVersion(
                                                       ));
                                               java.util.Date date =
                                                 plugin.
                                                 getReleaseDate(
                                                   );
                                               if (date !=
                                                     null) {
                                                   xmlOutput.
                                                     addAttribute(
                                                       "release-date",
                                                       java.lang.Long.
                                                         toString(
                                                           date.
                                                             getTime(
                                                               )));
                                               }
                                               xmlOutput.
                                                 stopTag(
                                                   true);
                                           }
                                           xmlOutput.
                                             closeTag(
                                               "findbugs-invocation");
                                           xmlOutput.
                                             flush(
                                               );
                                       }
                                       finally {
                                           if (finish) {
                                               xmlOutput.
                                                 finish(
                                                   );
                                           }
                                       } }
    @java.lang.SuppressWarnings({ "unchecked" }) 
    void parseUpdateXml(java.net.URI url,
                        java.util.Collection<edu.umd.cs.findbugs.Plugin> plugins,
                        @javax.annotation.WillClose
                        java.io.InputStream inputStream) {
        try {
            org.dom4j.Document doc =
              new org.dom4j.io.SAXReader(
              ).
              read(
                inputStream);
            if (DEBUG) {
                java.io.StringWriter stringWriter =
                  new java.io.StringWriter(
                  );
                org.dom4j.io.XMLWriter xmlWriter =
                  new org.dom4j.io.XMLWriter(
                  stringWriter);
                xmlWriter.
                  write(
                    doc);
                xmlWriter.
                  close(
                    );
                java.lang.System.
                  out.
                  println(
                    "UPDATE RESPONSE: " +
                    stringWriter.
                      toString(
                        ));
            }
            java.util.List<org.dom4j.Element> pluginEls =
              edu.umd.cs.findbugs.xml.XMLUtil.
              selectNodes(
                doc,
                "fb-plugin-updates/plugin");
            java.util.Map<java.lang.String,edu.umd.cs.findbugs.Plugin> map =
              new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.Plugin>(
              );
            for (edu.umd.cs.findbugs.Plugin p
                  :
                  plugins) {
                map.
                  put(
                    p.
                      getPluginId(
                        ),
                    p);
            }
            for (org.dom4j.Element pluginEl
                  :
                  pluginEls) {
                java.lang.String id =
                  pluginEl.
                  attributeValue(
                    "id");
                edu.umd.cs.findbugs.Plugin plugin =
                  map.
                  get(
                    id);
                if (plugin !=
                      null) {
                    checkPlugin(
                      pluginEl,
                      plugin);
                }
            }
        }
        catch (java.lang.Exception e) {
            logError(
              e,
              "Could not parse plugin version update for " +
              url);
        }
        finally {
            edu.umd.cs.findbugs.util.Util.
              closeSilently(
                inputStream);
        }
    }
    @java.lang.SuppressWarnings({ "unchecked" }) 
    private void checkPlugin(org.dom4j.Element pluginEl,
                             edu.umd.cs.findbugs.Plugin plugin) {
        for (org.dom4j.Element release
              :
              (java.util.List<org.dom4j.Element>)
                pluginEl.
                elements(
                  "release")) {
            checkPluginRelease(
              plugin,
              release);
        }
    }
    private void checkPluginRelease(edu.umd.cs.findbugs.Plugin plugin,
                                    org.dom4j.Element maxEl) {
        java.util.Date updateDate =
          parseReleaseDate(
            maxEl);
        java.util.Date installedDate =
          plugin.
          getReleaseDate(
            );
        if (updateDate !=
              null &&
              installedDate !=
              null &&
              updateDate.
              before(
                installedDate)) {
            return;
        }
        java.lang.String version =
          maxEl.
          attributeValue(
            "version");
        if (version.
              equals(
                plugin.
                  getVersion(
                    ))) {
            return;
        }
        java.lang.String url =
          maxEl.
          attributeValue(
            "url");
        java.lang.String message =
          maxEl.
          element(
            "message").
          getTextTrim(
            );
        pluginUpdates.
          add(
            new edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate(
              plugin,
              version,
              updateDate,
              url,
              message));
    }
    protected void logError(java.util.logging.Level level,
                            java.lang.String msg) {
        LOGGER.
          log(
            level,
            msg);
    }
    protected void logError(java.lang.Exception e,
                            java.lang.String msg) {
        LOGGER.
          log(
            java.util.logging.Level.
              INFO,
            msg,
            e);
    }
    @javax.annotation.CheckForNull
    private java.util.Date parseReleaseDate(org.dom4j.Element releaseEl) {
        java.text.SimpleDateFormat format =
          new java.text.SimpleDateFormat(
          PLUGIN_RELEASE_DATE_FMT);
        java.lang.String dateStr =
          releaseEl.
          attributeValue(
            "date");
        if (dateStr ==
              null) {
            return null;
        }
        try {
            return format.
              parse(
                dateStr);
        }
        catch (java.text.ParseException e) {
            throw new java.lang.IllegalArgumentException(
              "Error parsing " +
              dateStr +
              " using " +
              PLUGIN_RELEASE_DATE_FMT,
              e);
        }
    }
    private java.lang.String getPluginNames(java.util.Collection<edu.umd.cs.findbugs.Plugin> plugins) {
        java.lang.String text =
          "";
        boolean first =
          true;
        for (edu.umd.cs.findbugs.Plugin plugin
              :
              plugins) {
            text =
              (first
                 ? ""
                 : ", ") +
              plugin.
                getShortDescription(
                  );
            first =
              false;
        }
        return text;
    }
    private java.lang.String getEntryPoint() {
        java.lang.String lastFbClass =
          "<UNKNOWN>";
        for (java.lang.StackTraceElement s
              :
              java.lang.Thread.
               currentThread(
                 ).
               getStackTrace(
                 )) {
            java.lang.String cls =
              s.
              getClassName(
                );
            if (cls.
                  startsWith(
                    "edu.umd.cs.findbugs.")) {
                lastFbClass =
                  cls;
            }
        }
        return lastFbClass;
    }
    private static java.util.Random random =
      new java.util.Random(
      );
    private static synchronized java.lang.String getUuid() {
        try {
            java.util.prefs.Preferences prefs =
              java.util.prefs.Preferences.
              userNodeForPackage(
                edu.umd.cs.findbugs.updates.UpdateChecker.class);
            long uuid =
              prefs.
              getLong(
                "uuid",
                0);
            if (uuid ==
                  0) {
                uuid =
                  random.
                    nextLong(
                      );
                prefs.
                  putLong(
                    "uuid",
                    uuid);
            }
            return java.lang.Long.
              toString(
                uuid,
                16);
        }
        catch (java.lang.Throwable e) {
            return java.lang.Long.
              toString(
                42,
                16);
        }
    }
    private java.lang.String getMajorJavaVersion() {
        java.lang.String ver =
          edu.umd.cs.findbugs.SystemProperties.
          getProperty(
            "java.version",
            "");
        java.util.regex.Matcher m =
          java.util.regex.Pattern.
          compile(
            "^\\d+\\.\\d+").
          matcher(
            ver);
        if (m.
              find(
                )) {
            return m.
              group(
                );
        }
        return "";
    }
    public static class PluginUpdate {
        private final edu.umd.cs.findbugs.Plugin
          plugin;
        private final java.lang.String version;
        @javax.annotation.CheckForNull
        private final java.util.Date date;
        @javax.annotation.CheckForNull
        private final java.lang.String url;
        @javax.annotation.Nonnull
        private final java.lang.String message;
        private PluginUpdate(edu.umd.cs.findbugs.Plugin plugin,
                             java.lang.String version,
                             @javax.annotation.CheckForNull
                             java.util.Date date,
                             @javax.annotation.CheckForNull
                             java.lang.String url,
                             @javax.annotation.Nonnull
                             java.lang.String message) {
            super(
              );
            this.
              plugin =
              plugin;
            this.
              version =
              version;
            this.
              date =
              date;
            this.
              url =
              url;
            this.
              message =
              message;
        }
        public edu.umd.cs.findbugs.Plugin getPlugin() {
            return plugin;
        }
        public java.lang.String getVersion() {
            return version;
        }
        @javax.annotation.CheckForNull
        public java.util.Date getDate() {
            return date;
        }
        @javax.annotation.CheckForNull
        public java.lang.String getUrl() {
            return url;
        }
        @javax.annotation.Nonnull
        public java.lang.String getMessage() {
            return message;
        }
        @java.lang.Override
        public java.lang.String toString() {
            java.text.SimpleDateFormat format =
              new java.text.SimpleDateFormat(
              PLUGIN_RELEASE_DATE_FMT);
            java.lang.StringBuilder buf =
              new java.lang.StringBuilder(
              );
            java.lang.String name =
              getPlugin(
                ).
              isCorePlugin(
                )
              ? "FindBugs"
              : "FindBugs plugin " +
            getPlugin(
              ).
              getShortDescription(
                );
            buf.
              append(
                name +
                " " +
                getVersion(
                  ));
            if (date ==
                  null) {
                buf.
                  append(
                    " has been released");
            }
            else {
                buf.
                  append(
                    " was released " +
                    format.
                      format(
                        date));
            }
            buf.
              append(
                " (you have " +
                getPlugin(
                  ).
                  getVersion(
                    ) +
                ")");
            buf.
              append(
                "\n");
            buf.
              append(
                "   " +
                message.
                  replaceAll(
                    "\n",
                    "\n   "));
            if (url !=
                  null) {
                buf.
                  append(
                    "\nVisit " +
                    url +
                    " for details.");
            }
            return buf.
              toString(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { edu.umd.cs.findbugs.FindBugs.
                                         setNoAnalysis(
                                           );
                                       edu.umd.cs.findbugs.DetectorFactoryCollection dfc =
                                         edu.umd.cs.findbugs.DetectorFactoryCollection.
                                         instance(
                                           );
                                       edu.umd.cs.findbugs.updates.UpdateChecker checker =
                                         dfc.
                                         getUpdateChecker(
                                           );
                                       if (checker.
                                             updateChecksGloballyDisabled(
                                               )) {
                                           java.lang.System.
                                             out.
                                             println(
                                               "Update checkes are globally disabled");
                                       }
                                       java.net.URI redirect =
                                         checker.
                                         getRedirectURL(
                                           false);
                                       if (redirect !=
                                             null) {
                                           java.lang.System.
                                             out.
                                             println(
                                               "All update checks redirected to " +
                                               redirect);
                                       }
                                       checker.
                                         writeXml(
                                           java.lang.System.
                                             out,
                                           dfc.
                                             plugins(
                                               ),
                                           "UpdateChecker",
                                           true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3wbXBqOXDS5DP3gmQ3djSklNSkpDnNGdoYaLjgK2yArb3pByTX3VI0/HBEP5" +
       "C1DYGu9//scDA+fU8XrjQr7BsYH02NEK/r3kT5lvwFFeb9kzKWzPs3J3WwNs" +
       "41K36EU5OaZzbL/pXFip7Oiu18e2yt36nYR3i4df/9cva28qlJ2yDVKD1En3" +
       "ztsla6po0z3Mn5WiP0PZqiCF07AlbiS4brYyXrpPmIHF32XMtGGGfbGgL8iO" +
       "5pqtKXucz8zunbWy+sqP9JEvm0DkOB9JxmPPvXPreuYxakdFWMbq2+76Tvec" +
       "nJ1uc/elOWcHuCAocf7ksbtfWfZx/0y2tafLjyPHJR/+XmpYjY9Zjd9wRQty" +
       "ZDLGwdaWcf611eJFFb9+63FdtBUuouXSXH/om9d/v+eDV0sgFSOVmG1zkCBE" +
       "ZEoCbnvndgZNvXDXBlSQhc/QqSFpYxNuTGxD9ml214OS89x4s0CTv3cES7cx" +
       "QW1V0nIC2TbletnKdCplr2UqUnvGVrMXlvKTwC4ruuFb0IUB7DOs9BwDjr0S" +
       "gszMULQlFov3bukOx/tbeiKYCDJ1TUGlL1wgx9eXQllVXz/p7cGmbptny9jX" +
       "nrbFrBHj8M87nIHnwcl7b/Sx5GK4bjHEvSXPe6Py2rCJKvJw852/vfe1exo/" +
       "BNPaTKaN4jIQALTJ3pnGdyDff/KBRVUHPrqTLaKRb602i/F+0SMUFMzo6jxG" +
       "CFlRW1dnL2SrHZHOtvhVUHRdxch3GwkI/txou7+FklIJxJgUmC8VCeZWuE4a" +
       "Qz3pEgrfPBP53ZjCWrUt3Nq3Ef/Y4xj8W5Mf/Ex8ej6g8IjeVP8tMPj3Jorj" +
       "3Y7BN3gwhYWkyskJJZlrQCwi9LAKh0S/9pBIrzoHi3OzQ2D/yojjvYVtCLn2" +
       "BYHX7dUSS1SP3HzgcKLrhxeYMX4fJdOpkjpPEkYFycZqTl4I72Av06w9l/dn" +
       "3Pef/9Q03FrMfj0+WzzBjjz+vcQ7KXAO5Wc3fzy/99KR64rYel/iQMnJ8vGO" +
       "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" +
       "aHgPRQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1rk/d2T63nTWLJ1Y9qxROvYW4D7rnd3ffcYOZSaoMARXZaeilbN2aA9o9usZ" +
       "BlJVaAP+rszn3+Q4V2T5Spq1o/lMb8nLp7Pi63NW3ZLdfgMwCWEerEYAMtOV" +
       "7Z1p+Gvwtweuv8qubL2sYuvdH8R3IcaVoxjDB77u0UFPaHX6ByOyR6IceUCg" +
       "PHlAMfyhwj2Qy2BGsv1tiLi1nllZzQpsu3LjmjL3jiOKvCGrlcAF7ygCX0WR" +
       "Qn7DXgP1qHCHH5grAHpWSWVFK6d6G9Cjx7Za5OgQ7MeOVcf2DAPAvd8D/7dS" +
       "dgL8wQ2CnzG0ugO/eh5D73e9E2YoHyxdwEnuakye6JLSAdHhUKxHHqC93oEw" +
       "yJmCt0m8m/fvnkFieoNIiOCq7ZConYfEw4GmmgHQj7OoyDeGypMZKiOS6IxI" +
       "nL8+XGY3iMscXPUdLvVryJN5Y1A/SvbHBxR20GdPg3uxkRwEpgMigtUuBYGe" +
       "f/ALixdf+bFtenHWIp7prH37Cx/76/3veuHSiaTuqavyqpNjtoldDvF9OdiZ" +
       "j3nLRavkI6g/+szz//KfPv/RLVQPnk5RSJCB/9h/+Mtf3f/k7/3yOVHxHTPP" +
       "szXZPcMw6/oZ9mBW+yy4mjuGNa/BsOR8hl06YtgRr25RdSW7LZ2BanODUL0f" +
       "XMgOKuQaUH3ouqG6z7djYHO22hMCzjx7bbnh4lkYnUh6v9N86df+3Z9f/vCW" +
       "RacFLn/usRt6dtznfvuWyj3R09+dB663zuQw59ydwHWFWc+ocOXaz1DyubbS" +
       "dM+xIymc70gePv3AZz9/ROP7yaHpvf9kpLONJj92SjjPJ8GB0nEOuJ/63Efr" +
       "uexdXpkgwNZUfvdQ53RAeZxkPXfqQc+5RDpQXvnMd/7SW744fijP4Lf0yMCq" +
       "gWA0+9/cScleLiWXCttE7W3XAHgHUR7/Hih/+8W/+rU/fv7zv3wL8ECFu7NY" +
       "QgbGs+NGhf1rPfg6OcHTPLgjwCgQY9y/HQ18Vc7WHfsePKo9yrKiwjdea+7c" +
       "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" +
       "IYsdw6FkLVdj2FxG4rzRstj1Up1Ve8GwxVQojTOGqssCBTMFu6sK5FTWCHYU" +
       "97q1Ek6sBkZaQikNlmOirUhNr5I2Oi43WmgYCKYE3RqXlaZTrUnmVOGmohMy" +
       "klOZO9PqvJtOV5vOvGZtnGJi95WoVjPWYpnSyLjZG9GBLFVa1Q08knublVMq" +
       "r2SKqaqkwLQgoU6TJaGruWOlW0qLNiJyfXq69NHheIbGfiPlWsoqKM+bi95m" +
       "vuIbRlSaMywi1NhqixuhHoRGalVatz0RESp6OJnHLkMx6xqMNPXZRGupYrDY" +
       "1Cb81AmDdslDpWk4NUmsZQkTnIvrszpwjhW/2NDqaloMUODvZ6uptZ6tGnpD" +
       "RPrTqTaeECw8iep9KmoRM6fWA6leqSlWGShN17rQF615U+/gULXlE4nnr2Rx" +
       "Rs+RNs0011UMtWJZn6+TeovniwucbbFdr0GtK1WyAc1TSc/4po8Qoyk3/Vms" +
       "jqJmo8SImGQW2Zlvi73qxoREvY1YKVShazNkTJZr3TpwQZ16UeUgqIgEhqQU" +
       "tUBE18uoKVAkUAk2NdS6KPKz/sYv6SIIlCqVFVRU662FO+tUcHbRMSs9Funj" +
       "NE3O9OayjHSxaL1cIzgXOi2tN69RhDlZi2mVwDslZTEboUxRHIqiut6UIane" +
       "G2rr1QwjigFJVmdyWzM2C5uWFvO2A4lsdVrkwQTweiZiS1YkuBoxgA1nCKsW" +
       "t7D73MIn3H5L9SS5ZxndygYNZrCPbXgRHndKUBsjBzW8TEitGIGgUCHQoi40" +
       "xcAaBg0slNqlSp/sQgG84Gv2ak1R2gxZpN0JiBxgGp6s+2G13IXrJBAQeZrO" +
       "epAvUqbfYM243NQqmwiuu9IINquqDiHKSq40lzZd2RDjLlEmXTiNQluu+14p" +
       "hRm3NjEHpcF0aeJUqYHaM5OrzgJpIwb+wOm0KbgiMlGr1dJnLaPXNNmav4y6" +
       "YqykzTR2Z5NNMVwOEJoE8k4sWAyhE2cwWImDQIulRF6o1ISZLSvFRp1faYpL" +
       "l2MF0mx2orRjHPUUvbEIZ5E+0acJVNpUIlnvWZtBmx6B/MTxJUtCppaKrEfD" +
       "aDMleq21Kk8UvV4uazRFzZBiHabUCBNiLxY5sQ15DqJCq6JGjEuhQXHs2GmV" +
       "0wWOkVPSA0HjylWNaX8lEiJmc8O5AoE4nvKlpB/zrYRAHLtSrrJcE0mqYQnn" +
       "V7ACDL6SDCflccnt4BV+ZmuR21Vx3w4qwlJwV61xwIj2qsuv8WoQx9Ss1BGw" +
       "BsGGCLYmrKDEGWHKCCCToLwVPIsXbAJFM83sSjhBl3mhZffKayNBNHFo22Mx" +
       "hfyG0nJmfuRuEEt0gxkVYG2ryTQbbqftrhW7MYO4pNbqVmdWm1xx4kCrDzaV" +
       "AKe7K3rdrFWgla6VtcSDsP5A5rtyv2p1hmiPp2HfbakbQtehLjYaC+1BsOR7" +
       "cnc0q5cqJnAoJY4RKCb16lbSwil7NCmrbq/CBe1pm41WczBipCbKHG6tFx0o" +
       "Sry4UaQWdodOaENw8OYY16aTmKzKwxT2SSPQB9igBk8tfBIIEdxfwqQOSdXE" +
       "ak5qjA6RSVOz6kazY2njQTNiBhZMe4EFSw2sDxvruTRZbMIFTU/tYIivTaSH" +
       "duclDkJ8rBOkXtuE2XRYIaCNZ1kraRzhPbeCSW2xoQocV+YGcDs1lG4vmCea" +
       "xIhVnVZZf2H5A3IhURsFBJl2tdOooKtSfY3YkOrCAw3oyLAEUwGjW6XiJE0x" +
       "y0qLK2XY6IooW5sosJ5uIATpjurVQNJsyBwyLt1ctVi6DKkaMYXcWhFh1SFs" +
       "QD2NZSWuzwPpbnKzCA9cOqr0Y3WlwyKmTsM0mAo1JOL5tjfqTfmJAAuhUlkC" +
       "f6AMZrA3dKwSlOCVJjWZevrCqmAJOw/l6VyULYarDxqdidWIHEq3mpWeopBU" +
       "DzLbE2eUdps6X21EA4fyfElzN5Lq6PK6uVjBq4mts3yjafi03Db7RlzvyhOx" +
       "NE/TytJE3V67tpE3TL82W4uWUcOBiFfksoRQk7YSi22KGBR71LImzZZDhmqV" +
       "DYaOkJCoWY5kk+2Jzq5RMhxIKevRlYAd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
