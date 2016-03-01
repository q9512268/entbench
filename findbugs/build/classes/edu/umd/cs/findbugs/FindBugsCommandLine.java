package edu.umd.cs.findbugs;
public abstract class FindBugsCommandLine extends edu.umd.cs.findbugs.config.CommandLine {
    protected edu.umd.cs.findbugs.config.AnalysisFeatureSetting[] settingList =
      edu.umd.cs.findbugs.FindBugs.
        DEFAULT_EFFORT;
    protected edu.umd.cs.findbugs.Project project;
    protected boolean projectLoadedFromFile;
    public FindBugsCommandLine() { super();
                                   project = new edu.umd.cs.findbugs.Project(
                                               );
                                   startOptionGroup("General FindBugs options:");
                                   addOption("-project", "project", "analyze given project");
                                   addOption("-home", "home directory", "specify FindBugs home directory");
                                   addOption("-pluginList", "jar1[" + java.io.File.
                                                                        pathSeparator +
                                             "jar2...]",
                                             "specify list of plugin Jar files to load");
                                   addSwitchWithOptionalExtraPart(
                                     "-effort",
                                     "min|less|default|more|max",
                                     "set analysis effort level");
                                   addSwitch("-adjustExperimental",
                                             "lower priority of experimental Bug Patterns");
                                   addSwitch("-workHard",
                                             "ensure analysis effort is at least \'default\'");
                                   addSwitch("-conserveSpace",
                                             "same as -effort:min (for backward compatibility)");
    }
    public FindBugsCommandLine(boolean modernGui) {
        this(
          );
        addOption(
          "-f",
          "font size",
          "set font size");
        addSwitch(
          "-clear",
          "clear saved GUI settings and exit");
        addOption(
          "-priority",
          "thread priority",
          "set analysis thread priority");
        addOption(
          "-loadbugs",
          "saved analysis results",
          "load bugs from saved analysis results");
        makeOptionUnlisted(
          "-loadbugs");
        addOption(
          "-loadBugs",
          "saved analysis results",
          "load bugs from saved analysis results");
        addSwitch(
          "-d",
          "disable docking");
        addSwitch(
          "--nodock",
          "disable docking");
        addSwitchWithOptionalExtraPart(
          "-look",
          "plastic|gtk|native",
          "set UI look and feel");
    }
    public edu.umd.cs.findbugs.config.AnalysisFeatureSetting[] getSettingList() {
        return settingList;
    }
    @javax.annotation.Nonnull
    public edu.umd.cs.findbugs.Project getProject() {
        return project;
    }
    public boolean isProjectLoadedFromFile() {
        return projectLoadedFromFile;
    }
    @java.lang.Override
    protected void handleOption(java.lang.String option,
                                java.lang.String optionExtraPart) {
        if ("-effort".
              equals(
                option)) {
            if ("min".
                  equals(
                    optionExtraPart)) {
                settingList =
                  edu.umd.cs.findbugs.FindBugs.
                    MIN_EFFORT;
            }
            else
                if ("less".
                      equals(
                        optionExtraPart)) {
                    settingList =
                      edu.umd.cs.findbugs.FindBugs.
                        LESS_EFFORT;
                }
                else
                    if ("default".
                          equals(
                            optionExtraPart)) {
                        settingList =
                          edu.umd.cs.findbugs.FindBugs.
                            DEFAULT_EFFORT;
                    }
                    else
                        if ("more".
                              equals(
                                optionExtraPart)) {
                            settingList =
                              edu.umd.cs.findbugs.FindBugs.
                                MORE_EFFORT;
                        }
                        else
                            if ("max".
                                  equals(
                                    optionExtraPart)) {
                                settingList =
                                  edu.umd.cs.findbugs.FindBugs.
                                    MAX_EFFORT;
                            }
                            else {
                                throw new java.lang.IllegalArgumentException(
                                  "-effort:<value> must be one of min,default,more,max");
                            }
        }
        else
            if ("-workHard".
                  equals(
                    option)) {
                if (settingList !=
                      edu.umd.cs.findbugs.FindBugs.
                        MAX_EFFORT) {
                    settingList =
                      edu.umd.cs.findbugs.FindBugs.
                        MORE_EFFORT;
                }
            }
            else
                if ("-conserveSpace".
                      equals(
                        option)) {
                    settingList =
                      edu.umd.cs.findbugs.FindBugs.
                        MIN_EFFORT;
                }
                else
                    if ("-adjustExperimental".
                          equals(
                            option)) {
                        edu.umd.cs.findbugs.BugInstance.
                          setAdjustExperimental(
                            true);
                    }
                    else {
                        throw new java.lang.IllegalArgumentException(
                          "Don\'t understand option " +
                          option);
                    }
    }
    @java.lang.Override
    protected void handleOptionWithArgument(java.lang.String option,
                                            java.lang.String argument)
          throws java.io.IOException { if ("-home".
                                             equals(
                                               option)) {
                                           edu.umd.cs.findbugs.FindBugs.
                                             setHome(
                                               argument);
                                       }
                                       else
                                           if ("-pluginList".
                                                 equals(
                                                   option)) {
                                               java.lang.String pluginListStr =
                                                 argument;
                                               java.util.Map<java.lang.String,java.lang.Boolean> customPlugins =
                                                 getProject(
                                                   ).
                                                 getConfiguration(
                                                   ).
                                                 getCustomPlugins(
                                                   );
                                               java.util.StringTokenizer tok =
                                                 new java.util.StringTokenizer(
                                                 pluginListStr,
                                                 java.io.File.
                                                   pathSeparator);
                                               while (tok.
                                                        hasMoreTokens(
                                                          )) {
                                                   java.io.File file =
                                                     new java.io.File(
                                                     tok.
                                                       nextToken(
                                                         ));
                                                   java.lang.Boolean enabled =
                                                     java.lang.Boolean.
                                                     valueOf(
                                                       file.
                                                         isFile(
                                                           ));
                                                   customPlugins.
                                                     put(
                                                       file.
                                                         getAbsolutePath(
                                                           ),
                                                       enabled);
                                                   if (enabled.
                                                         booleanValue(
                                                           )) {
                                                       try {
                                                           edu.umd.cs.findbugs.Plugin.
                                                             loadCustomPlugin(
                                                               file,
                                                               getProject(
                                                                 ));
                                                       }
                                                       catch (edu.umd.cs.findbugs.PluginException e) {
                                                           throw new java.lang.IllegalStateException(
                                                             "Failed to load plugin " +
                                                             "specified by the \'-pluginList\', file: " +
                                                             file,
                                                             e);
                                                       }
                                                   }
                                               }
                                           }
                                           else
                                               if ("-project".
                                                     equals(
                                                       option)) {
                                                   loadProject(
                                                     argument);
                                               }
                                               else {
                                                   throw new java.lang.IllegalStateException(
                                                     );
                                               }
    }
    public void loadProject(java.lang.String arg)
          throws java.io.IOException { edu.umd.cs.findbugs.Project newProject =
                                         edu.umd.cs.findbugs.Project.
                                         readProject(
                                           arg);
                                       newProject.
                                         setConfiguration(
                                           project.
                                             getConfiguration(
                                               ));
                                       project =
                                         newProject;
                                       projectLoadedFromFile =
                                         true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DDccIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9nbc193UM1+//+fvefo4FLp/x/BeVU/x");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "9vaLXzN1HT8q3h9t/+0jv/A9/+KVLxUXZ/8fewudZTgtAAA=";
}
