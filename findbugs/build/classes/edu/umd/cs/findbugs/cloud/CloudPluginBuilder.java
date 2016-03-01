package edu.umd.cs.findbugs.cloud;
public class CloudPluginBuilder {
    private java.lang.String cloudid;
    private java.lang.ClassLoader classLoader;
    private java.lang.Class<? extends edu.umd.cs.findbugs.cloud.Cloud> cloudClass;
    private java.lang.Class<? extends edu.umd.cs.findbugs.cloud.username.NameLookup>
      usernameClass;
    private edu.umd.cs.findbugs.PropertyBundle properties;
    private java.lang.String description;
    private java.lang.String details;
    private boolean hidden;
    private boolean onlineStorage;
    private java.lang.String findbugsPluginId;
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setCloudid(java.lang.String cloudid) {
        this.
          cloudid =
          cloudid;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setClassLoader(java.lang.ClassLoader classLoader) {
        this.
          classLoader =
          classLoader;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setCloudClass(java.lang.Class<? extends edu.umd.cs.findbugs.cloud.Cloud> cloudClass) {
        this.
          cloudClass =
          cloudClass;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setUsernameClass(java.lang.Class<? extends edu.umd.cs.findbugs.cloud.username.NameLookup> usernameClass) {
        this.
          usernameClass =
          usernameClass;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setProperties(edu.umd.cs.findbugs.PropertyBundle properties) {
        this.
          properties =
          properties;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setDescription(java.lang.String description) {
        this.
          description =
          description;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setDetails(java.lang.String details) {
        this.
          details =
          details;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setHidden(boolean hidden) {
        this.
          hidden =
          hidden;
        return this;
    }
    public edu.umd.cs.findbugs.cloud.CloudPlugin createCloudPlugin() {
        return new edu.umd.cs.findbugs.cloud.CloudPlugin(
          findbugsPluginId,
          cloudid,
          classLoader,
          cloudClass,
          usernameClass,
          hidden,
          properties,
          description,
          details);
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setOnlineStorage(boolean onlineStorage) {
        this.
          onlineStorage =
          onlineStorage;
        return this;
    }
    public boolean isOnlineStorage() { return onlineStorage;
    }
    public edu.umd.cs.findbugs.cloud.CloudPluginBuilder setFindbugsPluginId(java.lang.String findbugsPluginId) {
        this.
          findbugsPluginId =
          findbugsPluginId;
        return this;
    }
    public java.lang.String getFindbugsPluginId() {
        return findbugsPluginId;
    }
    public CloudPluginBuilder() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9sR/AZT1THVwMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pLUtDNXKXLc2Emy+YRurTh1WGzZwjCS3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
