package org.apache.xalan.extensions;
public class ExtensionNamespacesManager {
    private java.util.Vector m_extensions = new java.util.Vector();
    private java.util.Vector m_predefExtensions = new java.util.Vector(7);
    private java.util.Vector m_unregisteredExtensions = new java.util.Vector(
      );
    public ExtensionNamespacesManager() { super();
                                          setPredefinedNamespaces(); }
    public void registerExtension(java.lang.String namespace) { if (namespaceIndex(
                                                                      namespace,
                                                                      m_extensions) ==
                                                                      -1) {
                                                                    int predef =
                                                                      namespaceIndex(
                                                                        namespace,
                                                                        m_predefExtensions);
                                                                    if (predef !=
                                                                          -1)
                                                                        m_extensions.
                                                                          add(
                                                                            m_predefExtensions.
                                                                              get(
                                                                                predef));
                                                                    else
                                                                        if (!m_unregisteredExtensions.
                                                                              contains(
                                                                                namespace))
                                                                            m_unregisteredExtensions.
                                                                              add(
                                                                                namespace);
                                                                }
    }
    public void registerExtension(org.apache.xalan.extensions.ExtensionNamespaceSupport extNsSpt) {
        java.lang.String namespace =
          extNsSpt.
          getNamespace(
            );
        if (namespaceIndex(
              namespace,
              m_extensions) ==
              -1) {
            m_extensions.
              add(
                extNsSpt);
            if (m_unregisteredExtensions.
                  contains(
                    namespace))
                m_unregisteredExtensions.
                  remove(
                    namespace);
        }
    }
    public int namespaceIndex(java.lang.String namespace,
                              java.util.Vector extensions) {
        for (int i =
               0;
             i <
               extensions.
               size(
                 );
             i++) {
            if (((org.apache.xalan.extensions.ExtensionNamespaceSupport)
                   extensions.
                   get(
                     i)).
                  getNamespace(
                    ).
                  equals(
                    namespace))
                return i;
        }
        return -1;
    }
    public java.util.Vector getExtensions() {
        return m_extensions;
    }
    public void registerUnregisteredNamespaces() {
        for (int i =
               0;
             i <
               m_unregisteredExtensions.
               size(
                 );
             i++) {
            java.lang.String ns =
              (java.lang.String)
                m_unregisteredExtensions.
                get(
                  i);
            org.apache.xalan.extensions.ExtensionNamespaceSupport extNsSpt =
              defineJavaNamespace(
                ns);
            if (extNsSpt !=
                  null)
                m_extensions.
                  add(
                    extNsSpt);
        }
    }
    public org.apache.xalan.extensions.ExtensionNamespaceSupport defineJavaNamespace(java.lang.String ns) {
        return defineJavaNamespace(
                 ns,
                 ns);
    }
    public org.apache.xalan.extensions.ExtensionNamespaceSupport defineJavaNamespace(java.lang.String ns,
                                                                                     java.lang.String classOrPackage) {
        if (null ==
              ns ||
              ns.
              trim(
                ).
              length(
                ) ==
              0)
            return null;
        java.lang.String className =
          classOrPackage;
        if (className.
              startsWith(
                "class:"))
            className =
              className.
                substring(
                  6);
        int lastSlash =
          className.
          lastIndexOf(
            '/');
        if (-1 !=
              lastSlash)
            className =
              className.
                substring(
                  lastSlash +
                    1);
        if (null ==
              className ||
              className.
              trim(
                ).
              length(
                ) ==
              0)
            return null;
        try {
            org.apache.xalan.extensions.ExtensionHandler.
              getClassForName(
                className);
            return new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              ns,
              "org.apache.xalan.extensions.ExtensionHandlerJavaClass",
              new java.lang.Object[] { ns,
              "javaclass",
              className });
        }
        catch (java.lang.ClassNotFoundException e) {
            return new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              ns,
              "org.apache.xalan.extensions.ExtensionHandlerJavaPackage",
              new java.lang.Object[] { ns,
              "javapackage",
              className +
              "." });
        }
    }
    private void setPredefinedNamespaces() {
        java.lang.String uri =
          org.apache.xalan.templates.Constants.
            S_EXTENSIONS_JAVA_URL;
        java.lang.String handlerClassName =
          "org.apache.xalan.extensions.ExtensionHandlerJavaPackage";
        java.lang.String lang =
          "javapackage";
        java.lang.String lib =
          "";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXTENSIONS_OLD_JAVA_URL;
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXTENSIONS_LOTUSXSL_JAVA_URL;
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_BUILTIN_EXTENSIONS_URL;
        handlerClassName =
          "org.apache.xalan.extensions.ExtensionHandlerJavaClass";
        lang =
          "javaclass";
        lib =
          "org.apache.xalan.lib.Extensions";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_BUILTIN_OLD_EXTENSIONS_URL;
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXTENSIONS_REDIRECT_URL;
        lib =
          "org.apache.xalan.lib.Redirect";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXTENSIONS_PIPE_URL;
        lib =
          "org.apache.xalan.lib.PipeDocument";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXTENSIONS_SQL_URL;
        lib =
          "org.apache.xalan.lib.sql.XConnection";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXSLT_COMMON_URL;
        lib =
          "org.apache.xalan.lib.ExsltCommon";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXSLT_MATH_URL;
        lib =
          "org.apache.xalan.lib.ExsltMath";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXSLT_SETS_URL;
        lib =
          "org.apache.xalan.lib.ExsltSets";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXSLT_DATETIME_URL;
        lib =
          "org.apache.xalan.lib.ExsltDatetime";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXSLT_DYNAMIC_URL;
        lib =
          "org.apache.xalan.lib.ExsltDynamic";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
        uri =
          org.apache.xalan.templates.Constants.
            S_EXSLT_STRINGS_URL;
        lib =
          "org.apache.xalan.lib.ExsltStrings";
        m_predefExtensions.
          add(
            new org.apache.xalan.extensions.ExtensionNamespaceSupport(
              uri,
              handlerClassName,
              new java.lang.Object[] { uri,
              lang,
              lib }));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SPwXnCn2oA8iAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bz7+z3/4l178Wnmh+/8AhuRfsqstAAA=");
}
