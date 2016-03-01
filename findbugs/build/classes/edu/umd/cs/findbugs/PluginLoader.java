package edu.umd.cs.findbugs;
public class PluginLoader {
    private static final java.lang.String XPATH_PLUGIN_SHORT_DESCRIPTION =
      "/MessageCollection/Plugin/ShortDescription";
    private static final java.lang.String XPATH_PLUGIN_WEBSITE = "/FindbugsPlugin/@website";
    private static final java.lang.String XPATH_PLUGIN_PROVIDER = "/FindbugsPlugin/@provider";
    private static final java.lang.String XPATH_PLUGIN_PLUGINID = "/FindbugsPlugin/@pluginid";
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.debug.PluginLoader");
    static boolean lazyInitialization = false;
    static java.util.LinkedList<edu.umd.cs.findbugs.PluginLoader> partiallyInitialized =
      new java.util.LinkedList<edu.umd.cs.findbugs.PluginLoader>(
      );
    private static int nextUnknownId;
    private java.lang.ClassLoader classLoader;
    private final java.lang.ClassLoader classLoaderForResources;
    private final edu.umd.cs.findbugs.Plugin plugin;
    private final boolean corePlugin;
    boolean initialPlugin;
    boolean cannotDisable;
    private boolean optionalPlugin;
    private final java.net.URL loadedFrom;
    private final java.lang.String jarName;
    private final java.net.URI loadedFromUri;
    java.lang.String parentId;
    static java.util.HashSet<java.lang.String> loadedPluginIds = new java.util.HashSet<java.lang.String>(
      );
    static { if (DEBUG) { java.lang.System.out.println("Debugging plugin loading. FindBugs version " +
                                                       edu.umd.cs.findbugs.Version.
                                                         getReleaseWithDateIfDev(
                                                           ));
             }
             loadInitialPlugins(); }
    @java.lang.Deprecated
    public PluginLoader(java.net.URL url)
          throws edu.umd.cs.findbugs.PluginException {
        this(
          url,
          toUri(
            url),
          null,
          false,
          true);
    }
    @java.lang.Deprecated
    public PluginLoader(java.net.URL url,
                        java.lang.ClassLoader parent)
          throws edu.umd.cs.findbugs.PluginException {
        this(
          url,
          toUri(
            url),
          parent,
          false,
          true);
    }
    public boolean hasParent() { return parentId !=
                                   null &&
                                   parentId.
                                   length(
                                     ) >
                                   0; }
    private PluginLoader(@javax.annotation.Nonnull
                         java.net.URL url,
                         java.net.URI uri,
                         java.lang.ClassLoader parent,
                         boolean isInitial,
                         boolean optional)
          throws edu.umd.cs.findbugs.PluginException {
        super(
          );
        java.net.URL[] loaderURLs =
          createClassloaderUrls(
            url);
        classLoaderForResources =
          new java.net.URLClassLoader(
            loaderURLs);
        loadedFrom =
          url;
        loadedFromUri =
          uri;
        jarName =
          getJarName(
            url);
        corePlugin =
          false;
        initialPlugin =
          isInitial;
        optionalPlugin =
          optional;
        plugin =
          init(
            );
        if (!hasParent(
               )) {
            classLoader =
              new java.net.URLClassLoader(
                loaderURLs,
                parent);
        }
        else {
            if (parent !=
                  edu.umd.cs.findbugs.PluginLoader.class.
                  getClassLoader(
                    )) {
                throw new java.lang.IllegalArgumentException(
                  "Can\'t specify parentid " +
                  parentId +
                  " and provide a seperate class loader");
            }
            edu.umd.cs.findbugs.Plugin parentPlugin =
              edu.umd.cs.findbugs.Plugin.
              getByPluginId(
                parentId);
            if (parentPlugin !=
                  null) {
                parent =
                  parentPlugin.
                    getClassLoader(
                      );
                classLoader =
                  new java.net.URLClassLoader(
                    loaderURLs,
                    parent);
            }
        }
        if (classLoader ==
              null) {
            if (!lazyInitialization) {
                throw new java.lang.IllegalStateException(
                  "Can\'t find parent plugin " +
                  parentId);
            }
            partiallyInitialized.
              add(
                this);
        }
        else {
            loadPluginComponents(
              );
            edu.umd.cs.findbugs.Plugin.
              putPlugin(
                loadedFromUri,
                plugin);
        }
    }
    private static void finishLazyInitialization() {
        if (!lazyInitialization) {
            throw new java.lang.IllegalStateException(
              "Not in lazy initialization mode");
        }
        while (!partiallyInitialized.
                 isEmpty(
                   )) {
            boolean changed =
              false;
            java.util.LinkedList<java.lang.String> unresolved =
              new java.util.LinkedList<java.lang.String>(
              );
            java.util.Set<java.lang.String> needed =
              new java.util.TreeSet<java.lang.String>(
              );
            for (java.util.Iterator<edu.umd.cs.findbugs.PluginLoader> i =
                   partiallyInitialized.
                   iterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.PluginLoader pluginLoader =
                  i.
                  next(
                    );
                java.lang.String pluginId =
                  pluginLoader.
                  getPlugin(
                    ).
                  getPluginId(
                    );
                assert pluginLoader.
                  hasParent(
                    );
                java.lang.String parentid =
                  pluginLoader.
                    parentId;
                edu.umd.cs.findbugs.Plugin parent =
                  edu.umd.cs.findbugs.Plugin.
                  getByPluginId(
                    parentid);
                if (parent !=
                      null) {
                    i.
                      remove(
                        );
                    try {
                        java.net.URL[] loaderURLs =
                          edu.umd.cs.findbugs.PluginLoader.
                          createClassloaderUrls(
                            pluginLoader.
                              loadedFrom);
                        pluginLoader.
                          classLoader =
                          new java.net.URLClassLoader(
                            loaderURLs,
                            parent.
                              getClassLoader(
                                ));
                        pluginLoader.
                          loadPluginComponents(
                            );
                        edu.umd.cs.findbugs.Plugin.
                          putPlugin(
                            pluginLoader.
                              loadedFromUri,
                            pluginLoader.
                              plugin);
                    }
                    catch (edu.umd.cs.findbugs.PluginException e) {
                        throw new java.lang.RuntimeException(
                          "Unable to load plugin " +
                          pluginId,
                          e);
                    }
                    changed =
                      true;
                }
                else {
                    unresolved.
                      add(
                        pluginId);
                    needed.
                      add(
                        parentid);
                }
            }
            if (!changed) {
                java.lang.String msg =
                  "Unable to load parent plugins " +
                needed +
                " in order to load " +
                unresolved;
                java.lang.System.
                  err.
                  println(
                    msg);
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    msg);
                msg =
                  "Available plugins are " +
                  edu.umd.cs.findbugs.Plugin.
                    getAllPluginIds(
                      );
                java.lang.System.
                  err.
                  println(
                    msg);
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    msg);
                for (java.util.Iterator<edu.umd.cs.findbugs.PluginLoader> i =
                       partiallyInitialized.
                       iterator(
                         );
                     i.
                       hasNext(
                         );
                     ) {
                    edu.umd.cs.findbugs.Plugin.
                      removePlugin(
                        i.
                          next(
                            ).
                          loadedFromUri);
                }
                partiallyInitialized.
                  clear(
                    );
            }
        }
        lazyInitialization =
          false;
    }
    @javax.annotation.Nonnull
    private static java.net.URL[] createClassloaderUrls(@javax.annotation.Nonnull
                                                        java.net.URL url)
          throws edu.umd.cs.findbugs.PluginException {
        java.util.List<java.net.URL> urls =
          new java.util.ArrayList<java.net.URL>(
          );
        urls.
          add(
            url);
        java.util.jar.Manifest mf =
          null;
        java.io.File f =
          new java.io.File(
          url.
            getPath(
              ));
        if (!f.
              isDirectory(
                )) {
            java.util.jar.JarInputStream jis =
              null;
            try {
                jis =
                  new java.util.jar.JarInputStream(
                    url.
                      openStream(
                        ));
                mf =
                  jis.
                    getManifest(
                      );
            }
            catch (java.io.IOException ioe) {
                throw new edu.umd.cs.findbugs.PluginException(
                  "Failed loading manifest for plugin jar: " +
                  url,
                  ioe);
            }
            finally {
                edu.umd.cs.findbugs.io.IO.
                  close(
                    jis);
            }
        }
        else {
            java.io.File manifest =
              guessManifest(
                f);
            if (manifest !=
                  null) {
                java.io.FileInputStream is =
                  null;
                try {
                    is =
                      new java.io.FileInputStream(
                        manifest);
                    mf =
                      new java.util.jar.Manifest(
                        is);
                }
                catch (java.io.IOException e) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      "Failed loading manifest for plugin jar: " +
                      url,
                      e);
                }
                finally {
                    edu.umd.cs.findbugs.io.IO.
                      close(
                        is);
                }
            }
        }
        if (mf !=
              null) {
            try {
                addClassPathFromManifest(
                  url,
                  urls,
                  mf);
            }
            catch (java.net.MalformedURLException e) {
                throw new edu.umd.cs.findbugs.PluginException(
                  "Failed loading manifest for plugin jar: " +
                  url,
                  e);
            }
        }
        return urls.
          toArray(
            new java.net.URL[urls.
                               size(
                                 )]);
    }
    private static void addClassPathFromManifest(@javax.annotation.Nonnull
                                                 java.net.URL url,
                                                 @javax.annotation.Nonnull
                                                 java.util.List<java.net.URL> urls,
                                                 @javax.annotation.Nonnull
                                                 java.util.jar.Manifest mf)
          throws java.net.MalformedURLException {
        java.util.jar.Attributes atts =
          mf.
          getMainAttributes(
            );
        if (atts ==
              null) {
            return;
        }
        java.lang.String classPath =
          atts.
          getValue(
            java.util.jar.Attributes.Name.
              CLASS_PATH);
        if (classPath !=
              null) {
            java.lang.String jarRoot =
              url.
              toString(
                );
            jarRoot =
              jarRoot.
                substring(
                  0,
                  jarRoot.
                    lastIndexOf(
                      '/') +
                    1);
            java.lang.String[] jars =
              classPath.
              split(
                ",");
            for (java.lang.String jar
                  :
                  jars) {
                jar =
                  jarRoot +
                  jar.
                    trim(
                      );
                urls.
                  add(
                    new java.net.URL(
                      jar));
            }
        }
    }
    @javax.annotation.CheckForNull
    private static java.io.File guessManifest(@javax.annotation.Nonnull
                                              java.io.File parent) {
        java.io.File file =
          new java.io.File(
          parent,
          "MANIFEST.MF");
        if (!file.
              isFile(
                )) {
            file =
              new java.io.File(
                parent,
                "META-INF/MANIFEST.MF");
        }
        if (!file.
              isFile(
                )) {
            file =
              new java.io.File(
                parent,
                "../META-INF/MANIFEST.MF");
        }
        if (file.
              isFile(
                )) {
            return file;
        }
        return null;
    }
    @java.lang.Deprecated
    public PluginLoader() throws edu.umd.cs.findbugs.PluginException {
        super(
          );
        classLoader =
          getClass(
            ).
            getClassLoader(
              );
        classLoaderForResources =
          classLoader;
        corePlugin =
          true;
        initialPlugin =
          true;
        optionalPlugin =
          false;
        loadedFrom =
          computeCoreUrl(
            );
        try {
            loadedFromUri =
              loadedFrom.
                toURI(
                  );
        }
        catch (java.net.URISyntaxException e) {
            throw new java.lang.IllegalArgumentException(
              "Failed to parse uri: " +
              loadedFrom);
        }
        jarName =
          getJarName(
            loadedFrom);
        plugin =
          init(
            );
        loadPluginComponents(
          );
        edu.umd.cs.findbugs.Plugin.
          putPlugin(
            null,
            plugin);
    }
    @java.lang.Deprecated
    public PluginLoader(boolean fake, java.net.URL url)
          throws edu.umd.cs.findbugs.PluginException {
        super(
          );
        classLoader =
          getClass(
            ).
            getClassLoader(
              );
        classLoaderForResources =
          classLoader;
        corePlugin =
          false;
        initialPlugin =
          true;
        optionalPlugin =
          false;
        loadedFrom =
          url;
        try {
            loadedFromUri =
              loadedFrom.
                toURI(
                  );
        }
        catch (java.net.URISyntaxException e) {
            throw new java.lang.IllegalArgumentException(
              "Failed to parse uri: " +
              loadedFrom);
        }
        jarName =
          getJarName(
            loadedFrom);
        plugin =
          null;
    }
    private static java.net.URL computeCoreUrl() {
        java.net.URL from;
        java.lang.String findBugsClassFile =
          edu.umd.cs.findbugs.util.ClassName.
          toSlashedClassName(
            edu.umd.cs.findbugs.FindBugs.class) +
        ".class";
        java.net.URL me =
          edu.umd.cs.findbugs.FindBugs.class.
          getClassLoader(
            ).
          getResource(
            findBugsClassFile);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "FindBugs.class loaded from " +
                me);
        }
        if (me ==
              null) {
            throw new java.lang.IllegalStateException(
              "Failed to load " +
              findBugsClassFile);
        }
        try {
            java.lang.String u =
              me.
              toString(
                );
            if (u.
                  startsWith(
                    "jar:") &&
                  u.
                  endsWith(
                    "!/" +
                    findBugsClassFile)) {
                u =
                  u.
                    substring(
                      4,
                      u.
                        indexOf(
                          "!/"));
                from =
                  new java.net.URL(
                    u);
            }
            else
                if (u.
                      endsWith(
                        findBugsClassFile)) {
                    u =
                      u.
                        substring(
                          0,
                          u.
                            indexOf(
                              findBugsClassFile));
                    from =
                      new java.net.URL(
                        u);
                }
                else {
                    throw new java.lang.IllegalArgumentException(
                      "Unknown url shema: " +
                      u);
                }
        }
        catch (java.net.MalformedURLException e) {
            throw new java.lang.IllegalArgumentException(
              "Failed to parse url: " +
              me);
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Core class files loaded from " +
                from);
        }
        return from;
    }
    public java.net.URL getURL() { return loadedFrom;
    }
    public java.net.URI getURI() { return loadedFromUri;
    }
    private static java.net.URI toUri(java.net.URL url)
          throws edu.umd.cs.findbugs.PluginException {
        try {
            return url.
              toURI(
                );
        }
        catch (java.net.URISyntaxException e) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Bad uri: " +
              url,
              e);
        }
    }
    private static java.lang.String getJarName(java.net.URL url) {
        java.lang.String location =
          url.
          getPath(
            );
        int i =
          location.
          lastIndexOf(
            '/');
        location =
          location.
            substring(
              i +
                1);
        return location;
    }
    public java.lang.ClassLoader getClassLoader() {
        if (classLoader ==
              null) {
            throw new java.lang.IllegalStateException(
              "Plugin not completely initialized; classloader not set yet");
        }
        return classLoader;
    }
    public edu.umd.cs.findbugs.Plugin loadPlugin()
          throws edu.umd.cs.findbugs.PluginException {
        return getPlugin(
                 );
    }
    public edu.umd.cs.findbugs.Plugin getPlugin() {
        if (plugin ==
              null) {
            throw new java.lang.AssertionError(
              "plugin not already loaded");
        }
        return plugin;
    }
    private static java.net.URL resourceFromPlugin(java.net.URL u,
                                                   java.lang.String args)
          throws java.net.MalformedURLException {
        java.lang.String path =
          u.
          getPath(
            );
        if (path.
              endsWith(
                ".zip") ||
              path.
              endsWith(
                ".jar")) {
            return new java.net.URL(
              "jar:" +
              u.
                toString(
                  ) +
              "!/" +
              args);
        }
        else
            if (path.
                  endsWith(
                    "/")) {
                return new java.net.URL(
                  u.
                    toString(
                      ) +
                  args);
            }
            else {
                return new java.net.URL(
                  u.
                    toString(
                      ) +
                  "/" +
                  args);
            }
    }
    public java.net.URL getResource(java.lang.String name) {
        if (isCorePlugin(
              )) {
            java.net.URL url =
              getCoreResource(
                name);
            if (url !=
                  null &&
                  edu.umd.cs.findbugs.io.IO.
                  verifyURL(
                    url)) {
                return url;
            }
        }
        if (loadedFrom !=
              null) {
            try {
                java.net.URL url =
                  resourceFromPlugin(
                    loadedFrom,
                    name);
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Trying to load " +
                        name +
                        " from " +
                        url);
                }
                if (edu.umd.cs.findbugs.io.IO.
                      verifyURL(
                        url)) {
                    return url;
                }
            }
            catch (java.net.MalformedURLException e) {
                assert true;
            }
        }
        if (classLoaderForResources instanceof java.net.URLClassLoader) {
            java.net.URLClassLoader urlClassLoader =
              (java.net.URLClassLoader)
                classLoaderForResources;
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Trying to load " +
                    name +
                    " using URLClassLoader.findResource");
                java.lang.System.
                  out.
                  println(
                    "  from urls: " +
                    java.util.Arrays.
                      asList(
                        urlClassLoader.
                          getURLs(
                            )));
            }
            java.net.URL url =
              urlClassLoader.
              findResource(
                name);
            if (url ==
                  null) {
                url =
                  urlClassLoader.
                    findResource(
                      "/" +
                      name);
            }
            if (edu.umd.cs.findbugs.io.IO.
                  verifyURL(
                    url)) {
                return url;
            }
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Trying to load " +
                name +
                " using ClassLoader.getResource");
        }
        java.net.URL url =
          classLoaderForResources.
          getResource(
            name);
        if (url ==
              null) {
            url =
              classLoaderForResources.
                getResource(
                  "/" +
                  name);
        }
        if (edu.umd.cs.findbugs.io.IO.
              verifyURL(
                url)) {
            return url;
        }
        return null;
    }
    @javax.annotation.CheckForNull
    static java.net.URL getCoreResource(java.lang.String name) {
        java.net.URL u =
          loadFromFindBugsPluginDir(
            name);
        if (u !=
              null) {
            return u;
        }
        u =
          loadFromFindBugsEtcDir(
            name);
        if (u !=
              null) {
            return u;
        }
        u =
          edu.umd.cs.findbugs.PluginLoader.class.
            getResource(
              name);
        if (u !=
              null) {
            return u;
        }
        u =
          edu.umd.cs.findbugs.PluginLoader.class.
            getResource(
              "/" +
              name);
        return u;
    }
    @javax.annotation.CheckForNull
    public static java.net.URL loadFromFindBugsEtcDir(java.lang.String name) {
        java.lang.String findBugsHome =
          edu.umd.cs.findbugs.DetectorFactoryCollection.
          getFindBugsHome(
            );
        if (findBugsHome !=
              null) {
            java.io.File f =
              new java.io.File(
              new java.io.File(
                new java.io.File(
                  findBugsHome),
                "etc"),
              name);
            if (f.
                  canRead(
                    )) {
                try {
                    return f.
                      toURL(
                        );
                }
                catch (java.net.MalformedURLException e) {
                    assert true;
                }
            }
        }
        return null;
    }
    @javax.annotation.CheckForNull
    public static java.net.URL loadFromFindBugsPluginDir(java.lang.String name) {
        java.lang.String findBugsHome =
          edu.umd.cs.findbugs.DetectorFactoryCollection.
          getFindBugsHome(
            );
        if (findBugsHome !=
              null) {
            java.io.File f =
              new java.io.File(
              new java.io.File(
                new java.io.File(
                  findBugsHome),
                "plugin"),
              name);
            if (f.
                  canRead(
                    )) {
                try {
                    return f.
                      toURI(
                        ).
                      toURL(
                        );
                }
                catch (java.net.MalformedURLException e) {
                    assert true;
                }
            }
        }
        return null;
    }
    private static <T> java.lang.Class<? extends T> getClass(java.lang.ClassLoader loader,
                                                             @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                             java.lang.String className,
                                                             java.lang.Class<T> type)
          throws edu.umd.cs.findbugs.PluginException {
        try {
            return loader.
              loadClass(
                className).
              asSubclass(
                type);
        }
        catch (java.lang.ClassNotFoundException e) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Unable to load " +
              className,
              e);
        }
        catch (java.lang.ClassCastException e) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Cannot cast " +
              className +
              " to " +
              type.
                getName(
                  ),
              e);
        }
    }
    private edu.umd.cs.findbugs.Plugin init()
          throws edu.umd.cs.findbugs.PluginException {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Loading plugin from " +
                loadedFrom);
        }
        org.dom4j.Document pluginDescriptor =
          getPluginDescriptor(
            );
        java.util.List<org.dom4j.Document> messageCollectionList =
          getMessageDocuments(
            );
        edu.umd.cs.findbugs.Plugin constructedPlugin =
          constructMinimalPlugin(
            pluginDescriptor,
            messageCollectionList);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Loaded " +
                constructedPlugin.
                  getPluginId(
                    ) +
                " from " +
                loadedFrom);
        }
        return constructedPlugin;
    }
    private void loadPluginComponents() throws edu.umd.cs.findbugs.PluginException {
        org.dom4j.Document pluginDescriptor =
          getPluginDescriptor(
            );
        java.util.List<org.dom4j.Document> messageCollectionList =
          getMessageDocuments(
            );
        java.util.List<org.dom4j.Node> cloudNodeList =
          edu.umd.cs.findbugs.xml.XMLUtil.
          selectNodes(
            pluginDescriptor,
            "/FindbugsPlugin/Cloud");
        for (org.dom4j.Node cloudNode
              :
              cloudNodeList) {
            java.lang.String cloudClassname =
              cloudNode.
              valueOf(
                "@cloudClass");
            java.lang.String cloudId =
              cloudNode.
              valueOf(
                "@id");
            java.lang.String usernameClassname =
              cloudNode.
              valueOf(
                "@usernameClass");
            boolean onlineStorage =
              java.lang.Boolean.
              valueOf(
                cloudNode.
                  valueOf(
                    "@onlineStorage"));
            java.lang.String propertiesLocation =
              cloudNode.
              valueOf(
                "@properties");
            boolean disabled =
              java.lang.Boolean.
              valueOf(
                cloudNode.
                  valueOf(
                    "@disabled")) &&
              !cloudId.
              equals(
                edu.umd.cs.findbugs.cloud.CloudFactory.
                  DEFAULT_CLOUD);
            if (disabled) {
                continue;
            }
            boolean hidden =
              java.lang.Boolean.
              valueOf(
                cloudNode.
                  valueOf(
                    "@hidden")) &&
              !cloudId.
              equals(
                edu.umd.cs.findbugs.cloud.CloudFactory.
                  DEFAULT_CLOUD);
            java.lang.Class<? extends edu.umd.cs.findbugs.cloud.Cloud> cloudClass =
              getClass(
                classLoader,
                cloudClassname,
                edu.umd.cs.findbugs.cloud.Cloud.class);
            java.lang.Class<? extends edu.umd.cs.findbugs.cloud.username.NameLookup> usernameClass =
              getClass(
                classLoader,
                usernameClassname,
                edu.umd.cs.findbugs.cloud.username.NameLookup.class);
            org.dom4j.Node cloudMessageNode =
              findMessageNode(
                messageCollectionList,
                "/MessageCollection/Cloud[@id=\'" +
                cloudId +
                "\']",
                "Missing Cloud description for cloud " +
                cloudId);
            java.lang.String description =
              getChildText(
                cloudMessageNode,
                "Description").
              trim(
                );
            java.lang.String details =
              getChildText(
                cloudMessageNode,
                "Details").
              trim(
                );
            edu.umd.cs.findbugs.PropertyBundle properties =
              new edu.umd.cs.findbugs.PropertyBundle(
              );
            if (propertiesLocation !=
                  null &&
                  propertiesLocation.
                  length(
                    ) >
                  0) {
                java.net.URL properiesURL =
                  classLoader.
                  getResource(
                    propertiesLocation);
                if (properiesURL ==
                      null) {
                    continue;
                }
                properties.
                  loadPropertiesFromURL(
                    properiesURL);
            }
            java.util.List<org.dom4j.Node> propertyNodes =
              edu.umd.cs.findbugs.xml.XMLUtil.
              selectNodes(
                cloudNode,
                "Property");
            for (org.dom4j.Node node
                  :
                  propertyNodes) {
                java.lang.String key =
                  node.
                  valueOf(
                    "@key");
                java.lang.String value =
                  node.
                  getText(
                    ).
                  trim(
                    );
                properties.
                  setProperty(
                    key,
                    value);
            }
            edu.umd.cs.findbugs.cloud.CloudPlugin cloudPlugin =
              new edu.umd.cs.findbugs.cloud.CloudPluginBuilder(
              ).
              setFindbugsPluginId(
                plugin.
                  getPluginId(
                    )).
              setCloudid(
                cloudId).
              setClassLoader(
                classLoader).
              setCloudClass(
                cloudClass).
              setUsernameClass(
                usernameClass).
              setHidden(
                hidden).
              setProperties(
                properties).
              setDescription(
                description).
              setDetails(
                details).
              setOnlineStorage(
                onlineStorage).
              createCloudPlugin(
                );
            plugin.
              addCloudPlugin(
                cloudPlugin);
        }
        try {
            java.util.List<org.dom4j.Node> componentNodeList =
              edu.umd.cs.findbugs.xml.XMLUtil.
              selectNodes(
                pluginDescriptor,
                "/FindbugsPlugin/PluginComponent");
            for (org.dom4j.Node componentNode
                  :
                  componentNodeList) {
                java.lang.String componentKindname =
                  componentNode.
                  valueOf(
                    "@componentKind");
                if (componentKindname ==
                      null) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      "Missing @componentKind for " +
                      plugin.
                        getPluginId(
                          ) +
                      " loaded from " +
                      loadedFrom);
                }
                java.lang.String componentClassname =
                  componentNode.
                  valueOf(
                    "@componentClass");
                if (componentClassname ==
                      null) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      "Missing @componentClassname for " +
                      plugin.
                        getPluginId(
                          ) +
                      " loaded from " +
                      loadedFrom);
                }
                java.lang.String componentId =
                  componentNode.
                  valueOf(
                    "@id");
                if (componentId ==
                      null) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      "Missing @id for " +
                      plugin.
                        getPluginId(
                          ) +
                      " loaded from " +
                      loadedFrom);
                }
                try {
                    java.lang.String propertiesLocation =
                      componentNode.
                      valueOf(
                        "@properties");
                    boolean disabled =
                      java.lang.Boolean.
                      valueOf(
                        componentNode.
                          valueOf(
                            "@disabled"));
                    org.dom4j.Node filterMessageNode =
                      findMessageNode(
                        messageCollectionList,
                        "/MessageCollection/PluginComponent[@id=\'" +
                        componentId +
                        "\']",
                        "Missing Cloud description for PluginComponent " +
                        componentId);
                    java.lang.String description =
                      getChildText(
                        filterMessageNode,
                        "Description").
                      trim(
                        );
                    java.lang.String details =
                      getChildText(
                        filterMessageNode,
                        "Details").
                      trim(
                        );
                    edu.umd.cs.findbugs.PropertyBundle properties =
                      new edu.umd.cs.findbugs.PropertyBundle(
                      );
                    if (propertiesLocation !=
                          null &&
                          propertiesLocation.
                          length(
                            ) >
                          0) {
                        java.net.URL properiesURL =
                          classLoaderForResources.
                          getResource(
                            propertiesLocation);
                        if (properiesURL ==
                              null) {
                            edu.umd.cs.findbugs.ba.AnalysisContext.
                              logError(
                                "Could not load properties for " +
                                plugin.
                                  getPluginId(
                                    ) +
                                " component " +
                                componentId +
                                " from " +
                                propertiesLocation);
                            continue;
                        }
                        properties.
                          loadPropertiesFromURL(
                            properiesURL);
                    }
                    java.util.List<org.dom4j.Node> propertyNodes =
                      edu.umd.cs.findbugs.xml.XMLUtil.
                      selectNodes(
                        componentNode,
                        "Property");
                    for (org.dom4j.Node node
                          :
                          propertyNodes) {
                        java.lang.String key =
                          node.
                          valueOf(
                            "@key");
                        java.lang.String value =
                          node.
                          getText(
                            );
                        properties.
                          setProperty(
                            key,
                            value);
                    }
                    java.lang.Class<?> componentKind =
                      classLoader.
                      loadClass(
                        componentKindname);
                    loadComponentPlugin(
                      plugin,
                      componentKind,
                      componentClassname,
                      componentId,
                      disabled,
                      description,
                      details,
                      properties);
                }
                catch (java.lang.RuntimeException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "Unable to load ComponentPlugin " +
                        componentId +
                        " : " +
                        componentClassname +
                        " implementing " +
                        componentKindname,
                        e);
                }
            }
            if (!edu.umd.cs.findbugs.FindBugs.
                  isNoMains(
                    )) {
                java.util.List<org.dom4j.Node> findBugsMainList =
                  edu.umd.cs.findbugs.xml.XMLUtil.
                  selectNodes(
                    pluginDescriptor,
                    "/FindbugsPlugin/FindBugsMain");
                for (org.dom4j.Node main
                      :
                      findBugsMainList) {
                    java.lang.String className =
                      main.
                      valueOf(
                        "@class");
                    if (className ==
                          null) {
                        throw new edu.umd.cs.findbugs.PluginException(
                          "Missing @class for FindBugsMain in plugin" +
                          plugin.
                            getPluginId(
                              ) +
                          " loaded from " +
                          loadedFrom);
                    }
                    java.lang.String cmd =
                      main.
                      valueOf(
                        "@cmd");
                    if (cmd ==
                          null) {
                        throw new edu.umd.cs.findbugs.PluginException(
                          "Missing @cmd for for FindBugsMain in plugin " +
                          plugin.
                            getPluginId(
                              ) +
                          " loaded from " +
                          loadedFrom);
                    }
                    java.lang.String kind =
                      main.
                      valueOf(
                        "@kind");
                    boolean analysis =
                      java.lang.Boolean.
                      valueOf(
                        main.
                          valueOf(
                            "@analysis"));
                    org.dom4j.Element mainMessageNode =
                      (org.dom4j.Element)
                        findMessageNode(
                          messageCollectionList,
                          "/MessageCollection/FindBugsMain[@cmd=\'" +
                          cmd +
                          "\']/Description",
                          "Missing FindBugsMain description for cmd " +
                          cmd);
                    java.lang.String description =
                      mainMessageNode.
                      getTextTrim(
                        );
                    try {
                        java.lang.Class<?> mainClass =
                          classLoader.
                          loadClass(
                            className);
                        plugin.
                          addFindBugsMain(
                            mainClass,
                            cmd,
                            description,
                            kind,
                            analysis);
                    }
                    catch (java.lang.Exception e) {
                        java.lang.String msg =
                          "Unable to load FindBugsMain " +
                        cmd +
                        " : " +
                        className +
                        " in plugin " +
                        plugin.
                          getPluginId(
                            ) +
                        " loaded from " +
                        loadedFrom;
                        edu.umd.cs.findbugs.PluginException e2 =
                          new edu.umd.cs.findbugs.PluginException(
                          msg,
                          e);
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          logError(
                            msg,
                            e2);
                    }
                }
            }
            java.util.List<org.dom4j.Node> detectorNodeList =
              edu.umd.cs.findbugs.xml.XMLUtil.
              selectNodes(
                pluginDescriptor,
                "/FindbugsPlugin/Detector");
            int detectorCount =
              0;
            for (org.dom4j.Node detectorNode
                  :
                  detectorNodeList) {
                java.lang.String className =
                  detectorNode.
                  valueOf(
                    "@class");
                java.lang.String speed =
                  detectorNode.
                  valueOf(
                    "@speed");
                java.lang.String disabled =
                  detectorNode.
                  valueOf(
                    "@disabled");
                java.lang.String reports =
                  detectorNode.
                  valueOf(
                    "@reports");
                java.lang.String requireJRE =
                  detectorNode.
                  valueOf(
                    "@requirejre");
                java.lang.String hidden =
                  detectorNode.
                  valueOf(
                    "@hidden");
                if (speed ==
                      null ||
                      speed.
                      length(
                        ) ==
                      0) {
                    speed =
                      "fast";
                }
                java.lang.Class<?> detectorClass =
                  null;
                if (!edu.umd.cs.findbugs.FindBugs.
                      isNoAnalysis(
                        )) {
                    detectorClass =
                      classLoader.
                        loadClass(
                          className);
                    if (!edu.umd.cs.findbugs.Detector.class.
                          isAssignableFrom(
                            detectorClass) &&
                          !edu.umd.cs.findbugs.Detector2.class.
                          isAssignableFrom(
                            detectorClass)) {
                        throw new edu.umd.cs.findbugs.PluginException(
                          "Class " +
                          className +
                          " does not implement Detector or Detector2");
                    }
                }
                edu.umd.cs.findbugs.DetectorFactory factory =
                  new edu.umd.cs.findbugs.DetectorFactory(
                  plugin,
                  className,
                  detectorClass,
                  !"true".
                    equals(
                      disabled),
                  speed,
                  reports,
                  requireJRE);
                if (java.lang.Boolean.
                      valueOf(
                        hidden).
                      booleanValue(
                        )) {
                    factory.
                      setHidden(
                        true);
                }
                factory.
                  setPositionSpecifiedInPluginDescriptor(
                    detectorCount++);
                plugin.
                  addDetectorFactory(
                    factory);
                org.dom4j.Node node =
                  findMessageNode(
                    messageCollectionList,
                    "/MessageCollection/Detector[@class=\'" +
                    className +
                    "\']/Details",
                    "Missing Detector description for detector " +
                    className);
                org.dom4j.Element details =
                  (org.dom4j.Element)
                    node;
                java.lang.String detailHTML =
                  details.
                  getText(
                    );
                java.lang.StringBuilder buf =
                  new java.lang.StringBuilder(
                  );
                buf.
                  append(
                    ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//" +
                     "EN\">\n"));
                buf.
                  append(
                    ("<HTML><HEAD><TITLE>Detector Description</TITLE></HEAD><BODY>" +
                     "\n"));
                buf.
                  append(
                    detailHTML);
                buf.
                  append(
                    "</BODY></HTML>\n");
                factory.
                  setDetailHTML(
                    buf.
                      toString(
                        ));
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Could not instantiate detector class: " +
              e,
              e);
        }
        org.dom4j.Node orderingConstraintsNode =
          pluginDescriptor.
          selectSingleNode(
            "/FindbugsPlugin/OrderingConstraints");
        if (orderingConstraintsNode !=
              null) {
            java.util.List<org.dom4j.Element> elements =
              edu.umd.cs.findbugs.xml.XMLUtil.
              selectNodes(
                orderingConstraintsNode,
                "./SplitPass|./WithinPass");
            for (org.dom4j.Element constraintElement
                  :
                  elements) {
                edu.umd.cs.findbugs.plan.DetectorFactorySelector earlierSelector =
                  getConstraintSelector(
                    constraintElement,
                    plugin,
                    "Earlier");
                edu.umd.cs.findbugs.plan.DetectorFactorySelector laterSelector =
                  getConstraintSelector(
                    constraintElement,
                    plugin,
                    "Later");
                edu.umd.cs.findbugs.plan.DetectorOrderingConstraint constraint =
                  new edu.umd.cs.findbugs.plan.DetectorOrderingConstraint(
                  earlierSelector,
                  laterSelector);
                constraint.
                  setSingleSource(
                    earlierSelector instanceof edu.umd.cs.findbugs.plan.SingleDetectorFactorySelector);
                if ("SplitPass".
                      equals(
                        constraintElement.
                          getName(
                            ))) {
                    plugin.
                      addInterPassOrderingConstraint(
                        constraint);
                }
                else {
                    plugin.
                      addIntraPassOrderingConstraint(
                        constraint);
                }
            }
        }
        java.util.List<org.dom4j.Node> categoryNodeListGlobal =
          edu.umd.cs.findbugs.xml.XMLUtil.
          selectNodes(
            pluginDescriptor,
            "/FindbugsPlugin/BugCategory");
        for (org.dom4j.Node categoryNode
              :
              categoryNodeListGlobal) {
            java.lang.String key =
              categoryNode.
              valueOf(
                "@category");
            if ("".
                  equals(
                    key)) {
                throw new edu.umd.cs.findbugs.PluginException(
                  "BugCategory element with missing category attribute");
            }
            edu.umd.cs.findbugs.BugCategory bc =
              plugin.
              addOrCreateBugCategory(
                key);
            boolean hidden =
              java.lang.Boolean.
              valueOf(
                categoryNode.
                  valueOf(
                    "@hidden"));
            if (hidden) {
                bc.
                  setHidden(
                    hidden);
            }
        }
        for (org.dom4j.Document messageCollection
              :
              messageCollectionList) {
            java.util.List<org.dom4j.Node> categoryNodeList =
              edu.umd.cs.findbugs.xml.XMLUtil.
              selectNodes(
                messageCollection,
                "/MessageCollection/BugCategory");
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "found " +
                    categoryNodeList.
                      size(
                        ) +
                    " categories in " +
                    plugin.
                      getPluginId(
                        ));
            }
            for (org.dom4j.Node categoryNode
                  :
                  categoryNodeList) {
                java.lang.String key =
                  categoryNode.
                  valueOf(
                    "@category");
                if ("".
                      equals(
                        key)) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      "BugCategory element with missing category attribute");
                }
                edu.umd.cs.findbugs.BugCategory bc =
                  plugin.
                  addOrCreateBugCategory(
                    key);
                java.lang.String shortDesc =
                  getChildText(
                    categoryNode,
                    "Description");
                bc.
                  setShortDescription(
                    shortDesc);
                try {
                    java.lang.String abbrev =
                      getChildText(
                        categoryNode,
                        "Abbreviation");
                    if (bc.
                          getAbbrev(
                            ) ==
                          null) {
                        bc.
                          setAbbrev(
                            abbrev);
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "category " +
                                key +
                                " abbrev -> " +
                                abbrev);
                        }
                    }
                    else
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "rejected abbrev \'" +
                                abbrev +
                                "\' for category " +
                                key +
                                ": " +
                                bc.
                                  getAbbrev(
                                    ));
                        }
                }
                catch (edu.umd.cs.findbugs.PluginException pe) {
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "missing Abbreviation for category " +
                            key +
                            "/" +
                            shortDesc);
                    }
                }
                try {
                    java.lang.String details =
                      getChildText(
                        categoryNode,
                        "Details");
                    if (bc.
                          getDetailText(
                            ) ==
                          null) {
                        bc.
                          setDetailText(
                            details);
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "category " +
                                key +
                                " details -> " +
                                details);
                        }
                    }
                    else
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "rejected details [" +
                                details +
                                "] for category " +
                                key +
                                ": [" +
                                bc.
                                  getDetailText(
                                    ) +
                                ']');
                        }
                }
                catch (edu.umd.cs.findbugs.PluginException pe) {
                    
                }
            }
        }
        java.util.List<org.dom4j.Node> bugPatternNodeList =
          edu.umd.cs.findbugs.xml.XMLUtil.
          selectNodes(
            pluginDescriptor,
            "/FindbugsPlugin/BugPattern");
        for (org.dom4j.Node bugPatternNode
              :
              bugPatternNodeList) {
            java.lang.String type =
              bugPatternNode.
              valueOf(
                "@type");
            java.lang.String abbrev =
              bugPatternNode.
              valueOf(
                "@abbrev");
            java.lang.String category =
              bugPatternNode.
              valueOf(
                "@category");
            boolean experimental =
              java.lang.Boolean.
              parseBoolean(
                bugPatternNode.
                  valueOf(
                    "@experimental"));
            java.lang.String query =
              "/MessageCollection/BugPattern[@type=\'" +
            type +
            "\']";
            org.dom4j.Node messageNode =
              findMessageNode(
                messageCollectionList,
                query,
                "messages.xml missing BugPattern element for type " +
                type);
            org.dom4j.Node bugsUrlNode =
              messageNode.
              getDocument(
                ).
              selectSingleNode(
                "/MessageCollection/Plugin/" +
                (experimental
                   ? "AllBugsUrl"
                   : "BugsUrl"));
            java.lang.String bugsUrl =
              bugsUrlNode ==
              null
              ? null
              : bugsUrlNode.
              getText(
                );
            java.lang.String shortDesc =
              getChildText(
                messageNode,
                "ShortDescription");
            java.lang.String longDesc =
              getChildText(
                messageNode,
                "LongDescription");
            java.lang.String detailText =
              getChildText(
                messageNode,
                "Details");
            int cweid =
              0;
            try {
                java.lang.String cweString =
                  bugPatternNode.
                  valueOf(
                    "@cweid");
                if (cweString.
                      length(
                        ) >
                      0) {
                    cweid =
                      java.lang.Integer.
                        parseInt(
                          cweString);
                }
            }
            catch (java.lang.RuntimeException e) {
                assert true;
            }
            edu.umd.cs.findbugs.BugPattern bugPattern =
              new edu.umd.cs.findbugs.BugPattern(
              type,
              abbrev,
              category,
              experimental,
              shortDesc,
              longDesc,
              detailText,
              bugsUrl,
              cweid);
            try {
                java.lang.String deprecatedStr =
                  bugPatternNode.
                  valueOf(
                    "@deprecated");
                boolean deprecated =
                  deprecatedStr.
                  length(
                    ) >
                  0 &&
                  java.lang.Boolean.
                  valueOf(
                    deprecatedStr).
                  booleanValue(
                    );
                if (deprecated) {
                    bugPattern.
                      setDeprecated(
                        deprecated);
                }
            }
            catch (java.lang.RuntimeException e) {
                assert true;
            }
            plugin.
              addBugPattern(
                bugPattern);
        }
        java.util.Set<java.lang.String> definedBugCodes =
          new java.util.HashSet<java.lang.String>(
          );
        for (org.dom4j.Document messageCollection
              :
              messageCollectionList) {
            java.util.List<org.dom4j.Node> bugCodeNodeList =
              edu.umd.cs.findbugs.xml.XMLUtil.
              selectNodes(
                messageCollection,
                "/MessageCollection/BugCode");
            for (org.dom4j.Node bugCodeNode
                  :
                  bugCodeNodeList) {
                java.lang.String abbrev =
                  bugCodeNode.
                  valueOf(
                    "@abbrev");
                if ("".
                      equals(
                        abbrev)) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      "BugCode element with missing abbrev attribute");
                }
                if (definedBugCodes.
                      contains(
                        abbrev)) {
                    continue;
                }
                java.lang.String description =
                  bugCodeNode.
                  getText(
                    );
                java.lang.String query =
                  "/FindbugsPlugin/BugCode[@abbrev=\'" +
                abbrev +
                "\']";
                org.dom4j.Node fbNode =
                  pluginDescriptor.
                  selectSingleNode(
                    query);
                int cweid =
                  0;
                if (fbNode !=
                      null) {
                    try {
                        cweid =
                          java.lang.Integer.
                            parseInt(
                              fbNode.
                                valueOf(
                                  "@cweid"));
                    }
                    catch (java.lang.RuntimeException e) {
                        assert true;
                    }
                }
                edu.umd.cs.findbugs.BugCode bugCode =
                  new edu.umd.cs.findbugs.BugCode(
                  abbrev,
                  description,
                  cweid);
                plugin.
                  addBugCode(
                    bugCode);
                definedBugCodes.
                  add(
                    abbrev);
            }
        }
        org.dom4j.Node node =
          pluginDescriptor.
          selectSingleNode(
            "/FindbugsPlugin/EngineRegistrar");
        if (node !=
              null) {
            java.lang.String engineClassName =
              node.
              valueOf(
                "@class");
            if (engineClassName ==
                  null) {
                throw new edu.umd.cs.findbugs.PluginException(
                  "EngineRegistrar element with missing class attribute");
            }
            try {
                java.lang.Class<?> engineRegistrarClass =
                  classLoader.
                  loadClass(
                    engineClassName);
                if (!edu.umd.cs.findbugs.classfile.IAnalysisEngineRegistrar.class.
                      isAssignableFrom(
                        engineRegistrarClass)) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      engineRegistrarClass +
                      " does not implement IAnalysisEngineRegistrar");
                }
                plugin.
                  setEngineRegistrarClass(
                    engineRegistrarClass.
                      <edu.umd.cs.findbugs.classfile.IAnalysisEngineRegistrar>
                    asSubclass(
                      edu.umd.cs.findbugs.classfile.IAnalysisEngineRegistrar.class));
            }
            catch (java.lang.ClassNotFoundException e) {
                throw new edu.umd.cs.findbugs.PluginException(
                  "Could not instantiate analysis engine registrar class: " +
                  e,
                  e);
            }
        }
        try {
            java.net.URL bugRankURL =
              getResource(
                edu.umd.cs.findbugs.BugRanker.
                  FILENAME);
            if (bugRankURL ==
                  null) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "No " +
                        edu.umd.cs.findbugs.BugRanker.
                          FILENAME +
                        " for plugin " +
                        plugin.
                          getPluginId(
                            ));
                }
            }
            edu.umd.cs.findbugs.BugRanker ranker =
              new edu.umd.cs.findbugs.BugRanker(
              bugRankURL);
            plugin.
              setBugRanker(
                ranker);
        }
        catch (java.io.IOException e) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Couldn\'t parse \"" +
              edu.umd.cs.findbugs.BugRanker.
                FILENAME +
              "\"",
              e);
        }
    }
    private edu.umd.cs.findbugs.Plugin constructMinimalPlugin(org.dom4j.Document pluginDescriptor,
                                                              java.util.List<org.dom4j.Document> messageCollectionList)
          throws edu.umd.cs.findbugs.plugins.DuplicatePluginIdError {
        java.lang.String pluginId =
          pluginDescriptor.
          valueOf(
            XPATH_PLUGIN_PLUGINID);
        if ("".
              equals(
                pluginId)) {
            synchronized (edu.umd.cs.findbugs.PluginLoader.class)  {
                pluginId =
                  "plugin" +
                  nextUnknownId++;
            }
        }
        cannotDisable =
          java.lang.Boolean.
            parseBoolean(
              pluginDescriptor.
                valueOf(
                  "/FindbugsPlugin/@cannotDisable"));
        java.lang.String de =
          pluginDescriptor.
          valueOf(
            "/FindbugsPlugin/@defaultenabled");
        if (de !=
              null &&
              "false".
              equals(
                de.
                  toLowerCase(
                    ).
                  trim(
                    ))) {
            optionalPlugin =
              true;
        }
        if (optionalPlugin) {
            cannotDisable =
              false;
        }
        if (!loadedPluginIds.
              add(
                pluginId)) {
            edu.umd.cs.findbugs.Plugin existingPlugin =
              edu.umd.cs.findbugs.Plugin.
              getByPluginId(
                pluginId);
            java.net.URL u =
              existingPlugin ==
              null
              ? null
              : existingPlugin.
              getPluginLoader(
                ).
              getURL(
                );
            if (cannotDisable &&
                  initialPlugin) {
                throw new edu.umd.cs.findbugs.plugins.DuplicatePluginIdError(
                  pluginId,
                  loadedFrom,
                  u);
            }
            else {
                throw new edu.umd.cs.findbugs.plugins.DuplicatePluginIdException(
                  pluginId,
                  loadedFrom,
                  u);
            }
        }
        parentId =
          pluginDescriptor.
            valueOf(
              "/FindbugsPlugin/@parentid");
        java.lang.String version =
          pluginDescriptor.
          valueOf(
            "/FindbugsPlugin/@version");
        java.lang.String releaseDate =
          pluginDescriptor.
          valueOf(
            "/FindbugsPlugin/@releaseDate");
        if ((releaseDate ==
               null ||
               releaseDate.
               length(
                 ) ==
               0) &&
              isCorePlugin(
                )) {
            releaseDate =
              edu.umd.cs.findbugs.Version.
                CORE_PLUGIN_RELEASE_DATE;
        }
        java.util.Date parsedDate =
          parseDate(
            releaseDate);
        edu.umd.cs.findbugs.Plugin constructedPlugin =
          new edu.umd.cs.findbugs.Plugin(
          pluginId,
          version,
          parsedDate,
          this,
          !optionalPlugin,
          cannotDisable);
        java.lang.String provider =
          pluginDescriptor.
          valueOf(
            XPATH_PLUGIN_PROVIDER).
          trim(
            );
        if (!"".
              equals(
                provider)) {
            constructedPlugin.
              setProvider(
                provider);
        }
        java.lang.String website =
          pluginDescriptor.
          valueOf(
            XPATH_PLUGIN_WEBSITE).
          trim(
            );
        if (!"".
              equals(
                website)) {
            try {
                constructedPlugin.
                  setWebsite(
                    website);
            }
            catch (java.net.URISyntaxException e1) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Plugin " +
                    constructedPlugin.
                      getPluginId(
                        ) +
                    " has invalid website: " +
                    website,
                    e1);
            }
        }
        java.lang.String updateUrl =
          pluginDescriptor.
          valueOf(
            "/FindbugsPlugin/@update-url").
          trim(
            );
        if (!"".
              equals(
                updateUrl)) {
            try {
                constructedPlugin.
                  setUpdateUrl(
                    updateUrl);
            }
            catch (java.net.URISyntaxException e1) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Plugin " +
                    constructedPlugin.
                      getPluginId(
                        ) +
                    " has invalid update check URL: " +
                    website,
                    e1);
            }
        }
        org.dom4j.Node pluginShortDesc =
          null;
        try {
            pluginShortDesc =
              findMessageNode(
                messageCollectionList,
                XPATH_PLUGIN_SHORT_DESCRIPTION,
                "no plugin description");
        }
        catch (edu.umd.cs.findbugs.PluginException e) {
            
        }
        if (pluginShortDesc !=
              null) {
            constructedPlugin.
              setShortDescription(
                pluginShortDesc.
                  getText(
                    ).
                  trim(
                    ));
        }
        org.dom4j.Node detailedDescription =
          null;
        try {
            detailedDescription =
              findMessageNode(
                messageCollectionList,
                "/MessageCollection/Plugin/Details",
                "no plugin description");
        }
        catch (edu.umd.cs.findbugs.PluginException e) {
            
        }
        if (detailedDescription !=
              null) {
            constructedPlugin.
              setDetailedDescription(
                detailedDescription.
                  getText(
                    ).
                  trim(
                    ));
        }
        java.util.List<org.dom4j.Node> globalOptionNodes =
          edu.umd.cs.findbugs.xml.XMLUtil.
          selectNodes(
            pluginDescriptor,
            "/FindbugsPlugin/GlobalOptions/Property");
        for (org.dom4j.Node optionNode
              :
              globalOptionNodes) {
            java.lang.String key =
              optionNode.
              valueOf(
                "@key");
            java.lang.String value =
              optionNode.
              getText(
                ).
              trim(
                );
            constructedPlugin.
              setMyGlobalOption(
                key,
                value);
        }
        return constructedPlugin;
    }
    public org.dom4j.Document getPluginDescriptor()
          throws edu.umd.cs.findbugs.PluginException,
        edu.umd.cs.findbugs.PluginDoesntContainMetadataException {
        org.dom4j.Document pluginDescriptor;
        java.lang.String name =
          "findbugs.xml";
        java.net.URL findbugsXML_URL =
          getResource(
            name);
        if (findbugsXML_URL ==
              null) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Couldn\'t find \"" +
              name +
              "\" in plugin " +
              this);
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "PluginLoader found " +
                name +
                " at: " +
                findbugsXML_URL);
        }
        if (jarName !=
              null &&
              !findbugsXML_URL.
              toString(
                ).
              contains(
                jarName) &&
              !(corePlugin &&
                  findbugsXML_URL.
                  toString(
                    ).
                  endsWith(
                    "etc/findbugs.xml"))) {
            java.lang.String classloaderName =
              classLoader.
              getClass(
                ).
              getName(
                );
            if (classLoader instanceof java.net.URLClassLoader) {
                classloaderName +=
                  java.util.Arrays.
                    asList(
                      ((java.net.URLClassLoader)
                         classLoader).
                        getURLs(
                          ));
            }
            throw new edu.umd.cs.findbugs.PluginDoesntContainMetadataException(
              (corePlugin
                 ? "Core plugin"
                 : "Plugin ") +
              jarName +
              " doesn\'t contain findbugs.xml; got " +
              findbugsXML_URL +
              " from " +
              classloaderName);
        }
        org.dom4j.io.SAXReader reader =
          new org.dom4j.io.SAXReader(
          );
        java.io.Reader r =
          null;
        try {
            r =
              edu.umd.cs.findbugs.charsets.UTF8.
                bufferedReader(
                  findbugsXML_URL.
                    openStream(
                      ));
            pluginDescriptor =
              reader.
                read(
                  r);
        }
        catch (org.dom4j.DocumentException e) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Couldn\'t parse \"" +
              findbugsXML_URL +
              "\" using " +
              reader.
                getClass(
                  ).
                getName(
                  ),
              e);
        }
        catch (java.io.IOException e) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Couldn\'t open \"" +
              findbugsXML_URL +
              "\"",
              e);
        }
        finally {
            edu.umd.cs.findbugs.io.IO.
              close(
                r);
        }
        return pluginDescriptor;
    }
    private static java.util.List<java.lang.String> getPotentialMessageFiles() {
        java.util.Locale locale =
          java.util.Locale.
          getDefault(
            );
        java.lang.String language =
          locale.
          getLanguage(
            );
        java.lang.String country =
          locale.
          getCountry(
            );
        java.util.List<java.lang.String> potential =
          new java.util.ArrayList<java.lang.String>(
          3);
        if (country !=
              null) {
            potential.
              add(
                "messages_" +
                language +
                "_" +
                country +
                ".xml");
        }
        potential.
          add(
            "messages_" +
            language +
            ".xml");
        potential.
          add(
            "messages.xml");
        return potential;
    }
    private java.util.List<org.dom4j.Document> getMessageDocuments()
          throws edu.umd.cs.findbugs.PluginException {
        java.util.ArrayList<org.dom4j.Document> messageCollectionList =
          new java.util.ArrayList<org.dom4j.Document>(
          );
        edu.umd.cs.findbugs.PluginException caught =
          null;
        for (java.lang.String m
              :
              getPotentialMessageFiles(
                )) {
            try {
                addCollection(
                  messageCollectionList,
                  m);
            }
            catch (edu.umd.cs.findbugs.PluginException e) {
                caught =
                  e;
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Error loading localized message file:" +
                    m,
                    e);
            }
        }
        if (messageCollectionList.
              isEmpty(
                )) {
            if (caught !=
                  null) {
                throw caught;
            }
            throw new edu.umd.cs.findbugs.PluginException(
              "No message.xml files found");
        }
        return messageCollectionList;
    }
    private <T> void loadComponentPlugin(edu.umd.cs.findbugs.Plugin plugin,
                                         java.lang.Class<T> componentKind,
                                         @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                         java.lang.String componentClassname,
                                         java.lang.String filterId,
                                         boolean disabled,
                                         java.lang.String description,
                                         java.lang.String details,
                                         edu.umd.cs.findbugs.PropertyBundle properties)
          throws edu.umd.cs.findbugs.PluginException {
        java.lang.Class<? extends T> componentClass =
          null;
        if (!edu.umd.cs.findbugs.FindBugs.
              isNoAnalysis(
                ) ||
              componentKind ==
              edu.umd.cs.findbugs.bugReporter.BugReporterDecorator.class) {
            componentClass =
              getClass(
                classLoader,
                componentClassname,
                componentKind);
        }
        edu.umd.cs.findbugs.ComponentPlugin<T> componentPlugin =
          new edu.umd.cs.findbugs.ComponentPlugin<T>(
          plugin,
          filterId,
          classLoader,
          componentClass,
          properties,
          !disabled,
          description,
          details);
        plugin.
          addComponentPlugin(
            componentKind,
            componentPlugin);
    }
    private static java.util.Date parseDate(java.lang.String releaseDate) {
        if (releaseDate ==
              null ||
              releaseDate.
              length(
                ) ==
              0) {
            return null;
        }
        try {
            java.text.SimpleDateFormat releaseDateFormat =
              new java.text.SimpleDateFormat(
              edu.umd.cs.findbugs.updates.UpdateChecker.
                PLUGIN_RELEASE_DATE_FMT,
              java.util.Locale.
                ENGLISH);
            java.util.Date result =
              releaseDateFormat.
              parse(
                releaseDate);
            return result;
        }
        catch (java.text.ParseException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "unable to parse date " +
                releaseDate,
                e);
            return null;
        }
    }
    private static edu.umd.cs.findbugs.plan.DetectorFactorySelector getConstraintSelector(org.dom4j.Element constraintElement,
                                                                                          edu.umd.cs.findbugs.Plugin plugin,
                                                                                          java.lang.String singleDetectorElementName)
          throws edu.umd.cs.findbugs.PluginException {
        org.dom4j.Node node =
          constraintElement.
          selectSingleNode(
            "./" +
            singleDetectorElementName);
        if (node !=
              null) {
            java.lang.String detectorClass =
              node.
              valueOf(
                "@class");
            return new edu.umd.cs.findbugs.plan.SingleDetectorFactorySelector(
              plugin,
              detectorClass);
        }
        node =
          constraintElement.
            selectSingleNode(
              "./" +
              singleDetectorElementName +
              "Category");
        if (node !=
              null) {
            boolean spanPlugins =
              java.lang.Boolean.
              valueOf(
                node.
                  valueOf(
                    "@spanplugins")).
              booleanValue(
                );
            java.lang.String categoryName =
              node.
              valueOf(
                "@name");
            if (!"".
                  equals(
                    categoryName)) {
                if ("reporting".
                      equals(
                        categoryName)) {
                    return new edu.umd.cs.findbugs.plan.ReportingDetectorFactorySelector(
                      spanPlugins
                        ? null
                        : plugin);
                }
                else
                    if ("training".
                          equals(
                            categoryName)) {
                        return new edu.umd.cs.findbugs.plan.ByInterfaceDetectorFactorySelector(
                          spanPlugins
                            ? null
                            : plugin,
                          edu.umd.cs.findbugs.TrainingDetector.class);
                    }
                    else
                        if ("interprocedural".
                              equals(
                                categoryName)) {
                            return new edu.umd.cs.findbugs.plan.ByInterfaceDetectorFactorySelector(
                              spanPlugins
                                ? null
                                : plugin,
                              edu.umd.cs.findbugs.InterproceduralFirstPassDetector.class);
                        }
                        else {
                            throw new edu.umd.cs.findbugs.PluginException(
                              "Invalid category name " +
                              categoryName +
                              " in constraint selector node");
                        }
            }
        }
        node =
          constraintElement.
            selectSingleNode(
              "./" +
              singleDetectorElementName +
              "Subtypes");
        if (node !=
              null) {
            boolean spanPlugins =
              java.lang.Boolean.
              valueOf(
                node.
                  valueOf(
                    "@spanplugins")).
              booleanValue(
                );
            java.lang.String superName =
              node.
              valueOf(
                "@super");
            if (!"".
                  equals(
                    superName)) {
                try {
                    java.lang.Class<?> superClass =
                      java.lang.Class.
                      forName(
                        superName);
                    return new edu.umd.cs.findbugs.plan.ByInterfaceDetectorFactorySelector(
                      spanPlugins
                        ? null
                        : plugin,
                      superClass);
                }
                catch (java.lang.ClassNotFoundException e) {
                    throw new edu.umd.cs.findbugs.PluginException(
                      "Unknown class " +
                      superName +
                      " in constraint selector node");
                }
            }
        }
        throw new edu.umd.cs.findbugs.PluginException(
          "Invalid constraint selector node");
    }
    private void addCollection(java.util.List<org.dom4j.Document> messageCollectionList,
                               java.lang.String filename)
          throws edu.umd.cs.findbugs.PluginException {
        java.net.URL messageURL =
          getResource(
            filename);
        if (messageURL !=
              null) {
            org.dom4j.io.SAXReader reader =
              new org.dom4j.io.SAXReader(
              );
            try {
                java.io.Reader stream =
                  edu.umd.cs.findbugs.charsets.UTF8.
                  bufferedReader(
                    messageURL.
                      openStream(
                        ));
                org.dom4j.Document messageCollection;
                try {
                    messageCollection =
                      reader.
                        read(
                          stream);
                }
                finally {
                    stream.
                      close(
                        );
                }
                messageCollectionList.
                  add(
                    messageCollection);
            }
            catch (java.io.IOException e) {
                throw new edu.umd.cs.findbugs.PluginException(
                  "Couldn\'t parse \"" +
                  messageURL +
                  "\"",
                  e);
            }
            catch (org.dom4j.DocumentException e) {
                throw new edu.umd.cs.findbugs.PluginException(
                  "Couldn\'t parse \"" +
                  messageURL +
                  "\"",
                  e);
            }
        }
    }
    private static org.dom4j.Node findMessageNode(java.util.List<org.dom4j.Document> messageCollectionList,
                                                  java.lang.String xpath,
                                                  java.lang.String missingMsg)
          throws edu.umd.cs.findbugs.PluginException {
        for (org.dom4j.Document document
              :
              messageCollectionList) {
            org.dom4j.Node node =
              document.
              selectSingleNode(
                xpath);
            if (node !=
                  null) {
                return node;
            }
        }
        throw new edu.umd.cs.findbugs.PluginException(
          missingMsg);
    }
    private static java.lang.String findMessageText(java.util.List<org.dom4j.Document> messageCollectionList,
                                                    java.lang.String xpath,
                                                    java.lang.String missingMsg) {
        for (org.dom4j.Document document
              :
              messageCollectionList) {
            org.dom4j.Node node =
              document.
              selectSingleNode(
                xpath);
            if (node !=
                  null) {
                return node.
                  getText(
                    ).
                  trim(
                    );
            }
        }
        return missingMsg;
    }
    private static java.lang.String getChildText(org.dom4j.Node node,
                                                 java.lang.String childName)
          throws edu.umd.cs.findbugs.PluginException {
        org.dom4j.Node child =
          node.
          selectSingleNode(
            childName);
        if (child ==
              null) {
            throw new edu.umd.cs.findbugs.PluginException(
              "Could not find child \"" +
              childName +
              "\" for node");
        }
        return child.
          getText(
            );
    }
    public static edu.umd.cs.findbugs.PluginLoader getPluginLoader(java.net.URL url,
                                                                   java.lang.ClassLoader parent,
                                                                   boolean isInitial,
                                                                   boolean optional)
          throws edu.umd.cs.findbugs.PluginException {
        java.net.URI uri =
          toUri(
            url);
        edu.umd.cs.findbugs.Plugin plugin =
          edu.umd.cs.findbugs.Plugin.
          getPlugin(
            uri);
        if (plugin !=
              null) {
            edu.umd.cs.findbugs.PluginLoader loader =
              plugin.
              getPluginLoader(
                );
            assert loader.
              getClassLoader(
                ).
              getParent(
                ).
              equals(
                parent);
            return loader;
        }
        return new edu.umd.cs.findbugs.PluginLoader(
          url,
          uri,
          parent,
          isInitial,
          optional);
    }
    @javax.annotation.Nonnull
    public static synchronized edu.umd.cs.findbugs.PluginLoader getCorePluginLoader() {
        edu.umd.cs.findbugs.Plugin plugin =
          edu.umd.cs.findbugs.Plugin.
          getPlugin(
            null);
        if (plugin !=
              null) {
            return plugin.
              getPluginLoader(
                );
        }
        throw new java.lang.IllegalStateException(
          "Core plugin not loaded yet!");
    }
    public boolean isCorePlugin() { return corePlugin;
    }
    static void installStandardPlugins() {
        java.lang.String homeDir =
          edu.umd.cs.findbugs.DetectorFactoryCollection.
          getFindBugsHome(
            );
        if (homeDir ==
              null) {
            return;
        }
        java.io.File home =
          new java.io.File(
          homeDir);
        loadPlugins(
          home);
    }
    private static void loadPlugins(java.io.File home) {
        if (home.
              canRead(
                ) &&
              home.
              isDirectory(
                )) {
            loadPluginsInDir(
              new java.io.File(
                home,
                "plugin"),
              false);
            loadPluginsInDir(
              new java.io.File(
                home,
                "optionalPlugin"),
              true);
        }
    }
    static void installUserInstalledPlugins() {
        java.lang.String homeDir =
          java.lang.System.
          getProperty(
            "user.home");
        if (homeDir ==
              null) {
            return;
        }
        java.io.File homeFindBugs =
          new java.io.File(
          new java.io.File(
            homeDir),
          ".findbugs");
        loadPlugins(
          homeFindBugs);
    }
    private static void loadPluginsInDir(java.io.File pluginDir,
                                         boolean optional) {
        java.io.File[] contentList =
          pluginDir.
          listFiles(
            );
        if (contentList ==
              null) {
            return;
        }
        for (java.io.File file
              :
              contentList) {
            if (file.
                  getName(
                    ).
                  endsWith(
                    ".jar")) {
                try {
                    java.net.URL url =
                      file.
                      toURI(
                        ).
                      toURL(
                        );
                    if (edu.umd.cs.findbugs.io.IO.
                          verifyURL(
                            url)) {
                        loadInitialPlugin(
                          url,
                          true,
                          optional);
                        if (edu.umd.cs.findbugs.FindBugs.
                              DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "Found plugin: " +
                                file.
                                  toString(
                                    ));
                        }
                    }
                }
                catch (java.net.MalformedURLException e) {
                    
                }
            }
        }
    }
    static synchronized void loadInitialPlugins() {
        lazyInitialization =
          true;
        loadCorePlugin(
          );
        if (edu.umd.cs.findbugs.util.JavaWebStart.
              isRunningViaJavaWebstart(
                )) {
            installWebStartPlugins(
              );
        }
        else {
            installStandardPlugins(
              );
            installUserInstalledPlugins(
              );
        }
        java.util.Set<java.util.Map.Entry<java.lang.Object,java.lang.Object>> entrySet =
          edu.umd.cs.findbugs.SystemProperties.
          getAllProperties(
            ).
          entrySet(
            );
        for (java.util.Map.Entry<?,?> e
              :
              entrySet) {
            if (e.
                  getKey(
                    ) instanceof java.lang.String &&
                  e.
                  getValue(
                    ) instanceof java.lang.String &&
                  ((java.lang.String)
                     e.
                     getKey(
                       )).
                  startsWith(
                    "findbugs.plugin.")) {
                try {
                    java.lang.String value =
                      (java.lang.String)
                        e.
                        getValue(
                          );
                    if (value.
                          startsWith(
                            "file:") &&
                          !value.
                          endsWith(
                            ".jar") &&
                          !value.
                          endsWith(
                            "/")) {
                        value +=
                          "/";
                    }
                    java.net.URL url =
                      edu.umd.cs.findbugs.util.JavaWebStart.
                      resolveRelativeToJnlpCodebase(
                        value);
                    java.lang.System.
                      out.
                      println(
                        "Loading " +
                        e.
                          getKey(
                            ) +
                        " from " +
                        url);
                    loadInitialPlugin(
                      url,
                      true,
                      false);
                }
                catch (java.net.MalformedURLException e1) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        java.lang.String.
                          format(
                            "Bad URL for plugin: %s=%s",
                            e.
                              getKey(
                                ),
                            e.
                              getValue(
                                )),
                        e1);
                }
            }
        }
        if (edu.umd.cs.findbugs.Plugin.
              getAllPlugins(
                ).
              size(
                ) >
              1 &&
              edu.umd.cs.findbugs.util.JavaWebStart.
              isRunningViaJavaWebstart(
                )) {
            try {
                java.lang.System.
                  setSecurityManager(
                    null);
            }
            catch (java.lang.Throwable e) {
                assert true;
            }
        }
        finishLazyInitialization(
          );
    }
    private static void loadCorePlugin() {
        try {
            edu.umd.cs.findbugs.Plugin plugin =
              edu.umd.cs.findbugs.Plugin.
              getPlugin(
                null);
            if (plugin !=
                  null) {
                throw new java.lang.IllegalStateException(
                  "Already loaded");
            }
            edu.umd.cs.findbugs.PluginLoader pluginLoader =
              new edu.umd.cs.findbugs.PluginLoader(
              );
            plugin =
              pluginLoader.
                getPlugin(
                  );
            edu.umd.cs.findbugs.Plugin.
              putPlugin(
                null,
                plugin);
        }
        catch (edu.umd.cs.findbugs.PluginException e1) {
            throw new java.lang.IllegalStateException(
              "Unable to load core plugin",
              e1);
        }
    }
    private static void loadInitialPlugin(java.net.URL u,
                                          boolean initial,
                                          boolean optional) {
        try {
            getPluginLoader(
              u,
              edu.umd.cs.findbugs.PluginLoader.class.
                getClassLoader(
                  ),
              initial,
              optional);
        }
        catch (edu.umd.cs.findbugs.plugins.DuplicatePluginIdException ignored) {
            assert true;
        }
        catch (edu.umd.cs.findbugs.PluginException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Unable to load plugin from " +
                u,
                e);
            if (DEBUG) {
                e.
                  printStackTrace(
                    );
            }
        }
    }
    static void installWebStartPlugins() {
        java.net.URL pluginListProperties =
          getCoreResource(
            "pluginlist.properties");
        java.io.BufferedReader in =
          null;
        if (pluginListProperties !=
              null) {
            try {
                edu.umd.cs.findbugs.DetectorFactoryCollection.
                  jawsDebugMessage(
                    pluginListProperties.
                      toString(
                        ));
                java.net.URL base =
                  getUrlBase(
                    pluginListProperties);
                in =
                  edu.umd.cs.findbugs.charsets.UTF8.
                    bufferedReader(
                      pluginListProperties.
                        openStream(
                          ));
                while (true) {
                    java.lang.String plugin =
                      in.
                      readLine(
                        );
                    if (plugin ==
                          null) {
                        break;
                    }
                    java.net.URL url =
                      new java.net.URL(
                      base,
                      plugin);
                    try {
                        java.net.URLConnection connection =
                          url.
                          openConnection(
                            );
                        java.lang.String contentType =
                          connection.
                          getContentType(
                            );
                        edu.umd.cs.findbugs.DetectorFactoryCollection.
                          jawsDebugMessage(
                            "contentType : " +
                            contentType);
                        if (connection instanceof java.net.HttpURLConnection) {
                            ((java.net.HttpURLConnection)
                               connection).
                              disconnect(
                                );
                        }
                        loadInitialPlugin(
                          url,
                          true,
                          false);
                    }
                    catch (java.io.IOException e) {
                        edu.umd.cs.findbugs.DetectorFactoryCollection.
                          jawsDebugMessage(
                            "error loading " +
                            url +
                            " : " +
                            e.
                              getMessage(
                                ));
                    }
                }
            }
            catch (java.io.IOException e) {
                edu.umd.cs.findbugs.DetectorFactoryCollection.
                  jawsDebugMessage(
                    "error : " +
                    e.
                      getMessage(
                        ));
            }
            finally {
                edu.umd.cs.findbugs.util.Util.
                  closeSilently(
                    in);
            }
        }
    }
    private static java.net.URL getUrlBase(java.net.URL pluginListProperties)
          throws java.net.MalformedURLException {
        java.lang.String urlname =
          pluginListProperties.
          toString(
            );
        java.net.URL base =
          pluginListProperties;
        int pos =
          urlname.
          indexOf(
            "!/");
        if (pos >=
              0 &&
              urlname.
              startsWith(
                "jar:")) {
            urlname =
              urlname.
                substring(
                  4,
                  pos);
            base =
              new java.net.URL(
                urlname);
        }
        return base;
    }
    @java.lang.Override
    public java.lang.String toString() { if (plugin ==
                                               null) {
                                             return java.lang.String.
                                               format(
                                                 "PluginLoader(%s)",
                                                 loadedFrom);
                                         }
                                         return java.lang.String.
                                           format(
                                             "PluginLoader(%s, %s)",
                                             plugin.
                                               getPluginId(
                                                 ),
                                             loadedFrom);
    }
    public static class Summary {
        public final java.lang.String id;
        public final java.lang.String description;
        public final java.lang.String provider;
        public final java.lang.String webbsite;
        public Summary(java.lang.String id,
                       java.lang.String description,
                       java.lang.String provider,
                       java.lang.String website) {
            super(
              );
            this.
              id =
              id;
            this.
              description =
              description;
            this.
              provider =
              provider;
            this.
              webbsite =
              website;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "vbf99ktfK65E/g+Ip4pH6B8AAA==");
    }
    public static edu.umd.cs.findbugs.PluginLoader.Summary validate(java.io.File file)
          throws java.lang.IllegalArgumentException {
        java.lang.String path =
          file.
          getPath(
            );
        if (!file.
              getName(
                ).
              endsWith(
                ".jar")) {
            java.lang.String message =
              "File " +
            path +
            " is not a .jar file";
            throw new java.lang.IllegalArgumentException(
              message);
        }
        if (!file.
              isFile(
                ) ||
              !file.
              canRead(
                )) {
            java.lang.String message =
              "File " +
            path +
            " is not a file or is not readable";
            throw new java.lang.IllegalArgumentException(
              message);
        }
        if (file.
              length(
                ) ==
              0) {
            java.lang.String message =
              "File " +
            path +
            " is empty";
            throw new java.lang.IllegalArgumentException(
              message);
        }
        java.util.zip.ZipFile zip =
          null;
        try {
            zip =
              new java.util.zip.ZipFile(
                file);
            java.util.zip.ZipEntry findbugsXML =
              zip.
              getEntry(
                "findbugs.xml");
            if (findbugsXML ==
                  null) {
                throw new java.lang.IllegalArgumentException(
                  "plugin doesn\'t contain a findbugs.xml file");
            }
            java.util.zip.ZipEntry messagesXML =
              zip.
              getEntry(
                "messages.xml");
            if (messagesXML ==
                  null) {
                throw new java.lang.IllegalArgumentException(
                  "plugin doesn\'t contain a messages.xml file");
            }
            org.dom4j.Document pluginDocument =
              parseDocument(
                zip.
                  getInputStream(
                    findbugsXML));
            java.lang.String pluginId =
              pluginDocument.
              valueOf(
                XPATH_PLUGIN_PLUGINID).
              trim(
                );
            java.lang.String provider =
              pluginDocument.
              valueOf(
                XPATH_PLUGIN_PROVIDER).
              trim(
                );
            java.lang.String website =
              pluginDocument.
              valueOf(
                XPATH_PLUGIN_WEBSITE).
              trim(
                );
            java.util.List<org.dom4j.Document> msgDocuments =
              new java.util.ArrayList<org.dom4j.Document>(
              3);
            for (java.lang.String msgFile
                  :
                  getPotentialMessageFiles(
                    )) {
                java.util.zip.ZipEntry msgEntry =
                  zip.
                  getEntry(
                    msgFile);
                if (msgEntry ==
                      null) {
                    continue;
                }
                org.dom4j.Document msgDocument =
                  parseDocument(
                    zip.
                      getInputStream(
                        msgEntry));
                msgDocuments.
                  add(
                    msgDocument);
            }
            java.lang.String shortDesc =
              findMessageText(
                msgDocuments,
                XPATH_PLUGIN_SHORT_DESCRIPTION,
                "");
            return new edu.umd.cs.findbugs.PluginLoader.Summary(
              pluginId,
              shortDesc,
              provider,
              website);
        }
        catch (org.dom4j.DocumentException e) {
            throw new java.lang.IllegalArgumentException(
              e);
        }
        catch (java.io.IOException e) {
            throw new java.lang.IllegalArgumentException(
              e);
        }
        finally {
            edu.umd.cs.findbugs.util.Util.
              closeSilently(
                zip);
        }
    }
    private static org.dom4j.Document parseDocument(@javax.annotation.WillClose
                                                    java.io.InputStream in)
          throws org.dom4j.DocumentException {
        java.io.Reader r =
          edu.umd.cs.findbugs.charsets.UTF8.
          bufferedReader(
            in);
        try {
            org.dom4j.io.SAXReader reader =
              new org.dom4j.io.SAXReader(
              );
            org.dom4j.Document d =
              reader.
              read(
                r);
            return d;
        }
        finally {
            edu.umd.cs.findbugs.util.Util.
              closeSilently(
                r);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9ODgfoqE6Z6jgB8NgOwcTFZSMrVEtDyo");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("fbiabsALgscXAlDb4W/LZVUDeG4LyMMXuUXXOG7ABdoAeAIm9Ve3tdU6ALgI" +
       "OPqD4OwPYyZKMopSN4AfJI52y/0EdvYv2otJOz9N3Gum1onn9pzjMtGyLzwY" +
       "BVLsyCjExuPGcZr8c4RIyV5IKyUWIDRKQB6+3yi6lZJaajjv6nTC3+hFZR+P" +
       "aXS9RmqnZpq6WKIZ4/CELTIsBsbnCQDmVSp3sphZSrGM+xk1/QvYwCx2gImD" +
       "qzWkpNaaQ2wLqGhrM4orDtEUDMFOJaUnXcvcp5V7DVdTdy6dVszdznClqyDH" +
       "DJZlgE+XwKlrrDReSjEY2Gn2U2DxTDZHQWw1Jc2Q/NvgenNLDx8Uj8QBTPZR" +
       "Us93HESZHUXby9ExOQ+bh6DWPZL4mwezS37+iv9kk3r/4YbaWYd7f8yfOrZ/" +
       "VmlSgtQO5lIp94uGXd/HZU1tUGdDM4mlU9k5suhBwM9HrkD87K/Y5+iNvPRn" +
       "wWg6pSkJq0XZN1MyXmRTEoHUnfn3cAsy8ettWXsMSl86x6Et2qdj74ubUQ5n" +
       "11sxlkhfhtie47831q8eObyp4xPvrvoS/0EWNaXsYU8kT0yQ8fy3YRjRSMlb" +
       "G93UbFrjNi47PvmBCUvtB9Sn8g47ejDXMbFkI4hgFgd4jufXSqymwo+WvHTH" +
       "ud8+emDcs2ES2kpCCozR1tIXUeezOZPM35oofSW+/brA1ctu3X3eisF3XmG/" +
       "i8Fkv+gF397y/WrfTS/GH9j+uzXs561qQAK0PHtDduvuTJem7jSL3q/v/wrG" +
       "+qJXMILdK/15gbKvXKxPYKBu3+EjEfgWRqzg3BFDh+kOTAbziD7IX3+iPZu1" +
       "T1hemWXaZ/p5EmwvOHqEfcVvD/wfseyUZ3hwAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iWotcBOSojKBt+kqNkuGpZWJV8ICXIUS");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Y9wfXIFxL0sPgvrrP7ll3E/efvv2FxfZ");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "P/rh38s2Z///AJkUSsGxgQAA");
}
