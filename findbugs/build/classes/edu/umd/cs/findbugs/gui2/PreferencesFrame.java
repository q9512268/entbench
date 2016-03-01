package edu.umd.cs.findbugs.gui2;
@java.lang.SuppressWarnings("serial") 
public class PreferencesFrame extends edu.umd.cs.findbugs.gui2.FBDialog {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.
      getLogger(
        edu.umd.cs.findbugs.gui2.PreferencesFrame.class.
          getName(
            ));
    private static final int TAB_MIN = 1;
    private static final int TAB_MAX = 20;
    private static final int FONT_MIN = 10;
    private static final int FONT_MAX = 99;
    private static edu.umd.cs.findbugs.gui2.PreferencesFrame instance;
    private final edu.umd.cs.findbugs.gui2.CheckBoxList<edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox>
      filterCheckBoxList =
      new edu.umd.cs.findbugs.gui2.CheckBoxList<edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox>(
      );
    private javax.swing.JTextField tabTextField;
    private javax.swing.JTextField fontTextField;
    private javax.swing.JTextField packagePrefixLengthTextField;
    private final java.util.Map<edu.umd.cs.findbugs.Plugin,edu.umd.cs.findbugs.gui2.PreferencesFrame.EnabledSettings>
      pluginEnabledStatus =
      new java.util.HashMap<edu.umd.cs.findbugs.Plugin,edu.umd.cs.findbugs.gui2.PreferencesFrame.EnabledSettings>(
      );
    private javax.swing.JPanel pluginPanelCenter;
    private static class EnabledSettings {
        public boolean global;
        public java.lang.Boolean project;
        private EnabledSettings(boolean global,
                                java.lang.Boolean project) {
            super(
              );
            this.
              global =
              global;
            this.
              project =
              project;
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
           "v/JVDA6oHwAA");
    }
    public static edu.umd.cs.findbugs.gui2.PreferencesFrame getInstance() {
        if (instance ==
              null) {
            instance =
              new edu.umd.cs.findbugs.gui2.PreferencesFrame(
                );
        }
        return instance;
    }
    private boolean pluginsAdded = false;
    private final javax.swing.JPanel filterPane;
    private final javax.swing.JTabbedPane
      mainTabPane;
    public void showFilterPane() { mainTabPane.
                                     setSelectedComponent(
                                       filterPane);
    }
    private PreferencesFrame() { super();
                                 setTitle(
                                   edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "dlg.fil_sup_ttl",
                                       "Preferences"));
                                 setModal(
                                   true);
                                 mainTabPane =
                                   new javax.swing.JTabbedPane(
                                     );
                                 mainTabPane.
                                   add(
                                     "General",
                                     createPropertiesPane(
                                       ));
                                 filterPane =
                                   createFilterPane(
                                     );
                                 mainTabPane.
                                   add(
                                     edu.umd.cs.findbugs.L10N.
                                       getLocalString(
                                         "pref.filters",
                                         "Filters"),
                                     filterPane);
                                 mainTabPane.
                                   add(
                                     "Plugins",
                                     createPluginPane(
                                       ));
                                 edu.umd.cs.findbugs.gui2.MainFrame.
                                   getInstance(
                                     ).
                                   updateStatusBar(
                                     );
                                 getContentPane(
                                   ).setLayout(
                                       new javax.swing.BoxLayout(
                                         getContentPane(
                                           ),
                                         javax.swing.BoxLayout.
                                           Y_AXIS));
                                 javax.swing.JPanel top =
                                   new javax.swing.JPanel(
                                   );
                                 top.setLayout(
                                       new javax.swing.BoxLayout(
                                         top,
                                         javax.swing.BoxLayout.
                                           X_AXIS));
                                 top.add(
                                       javax.swing.Box.
                                         createHorizontalStrut(
                                           5));
                                 top.add(
                                       mainTabPane);
                                 top.add(
                                       javax.swing.Box.
                                         createHorizontalStrut(
                                           5));
                                 javax.swing.JPanel bottom =
                                   new javax.swing.JPanel(
                                   );
                                 bottom.setLayout(
                                          new javax.swing.BoxLayout(
                                            bottom,
                                            javax.swing.BoxLayout.
                                              X_AXIS));
                                 bottom.add(
                                          javax.swing.Box.
                                            createHorizontalGlue(
                                              ));
                                 bottom.add(
                                          new javax.swing.JButton(
                                            new javax.swing.AbstractAction(
                                              edu.umd.cs.findbugs.L10N.
                                                getLocalString(
                                                  "pref.close",
                                                  "Close")) {
                                                @java.lang.Override
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    handleWindowClose(
                                                      );
                                                    PreferencesFrame.this.
                                                      setVisible(
                                                        false);
                                                }
                                            }));
                                 bottom.add(
                                          javax.swing.Box.
                                            createHorizontalStrut(
                                              5));
                                 add(javax.swing.Box.
                                       createVerticalStrut(
                                         5));
                                 add(top);
                                 add(javax.swing.Box.
                                       createVerticalStrut(
                                         5));
                                 add(bottom);
                                 add(javax.swing.Box.
                                       createVerticalStrut(
                                         5));
                                 addComponentListener(
                                   new java.awt.event.ComponentAdapter(
                                     ) {
                                       @java.lang.Override
                                       public void componentShown(java.awt.event.ComponentEvent e) {
                                           resetPropertiesPane(
                                             );
                                       }
                                   });
                                 addWindowListener(
                                   new java.awt.event.WindowAdapter(
                                     ) {
                                       @java.lang.Override
                                       public void windowClosed(java.awt.event.WindowEvent e) {
                                           handleWindowClose(
                                             );
                                       }
                                   });
                                 setDefaultCloseOperation(
                                   HIDE_ON_CLOSE);
                                 pack(); }
    private void handleWindowClose() { javax.swing.tree.TreeModel bt =
                                         edu.umd.cs.findbugs.gui2.MainFrame.
                                         getInstance(
                                           ).
                                         getTree(
                                           ).
                                         getModel(
                                           );
                                       if (bt instanceof edu.umd.cs.findbugs.gui2.BugTreeModel) {
                                           ((edu.umd.cs.findbugs.gui2.BugTreeModel)
                                              bt).
                                             checkSorter(
                                               );
                                       }
                                       edu.umd.cs.findbugs.Project project =
                                         getCurrentProject(
                                           );
                                       boolean changed =
                                         pluginsAdded;
                                       pluginsAdded =
                                         false;
                                       java.util.List<java.lang.String> enabledPlugins =
                                         new java.util.ArrayList<java.lang.String>(
                                         );
                                       java.util.List<java.lang.String> disabledPlugins =
                                         new java.util.ArrayList<java.lang.String>(
                                         );
                                       for (java.util.Map.Entry<edu.umd.cs.findbugs.Plugin,edu.umd.cs.findbugs.gui2.PreferencesFrame.EnabledSettings> entry
                                             :
                                             pluginEnabledStatus.
                                              entrySet(
                                                )) {
                                           edu.umd.cs.findbugs.Plugin plugin =
                                             entry.
                                             getKey(
                                               );
                                           edu.umd.cs.findbugs.gui2.PreferencesFrame.EnabledSettings enabled =
                                             entry.
                                             getValue(
                                               );
                                           if (project !=
                                                 null) {
                                               java.lang.Boolean newSetting =
                                                 enabled.
                                                   project;
                                               java.lang.Boolean existingSetting =
                                                 project.
                                                 getPluginStatus(
                                                   plugin);
                                               boolean sameSettings =
                                                 java.util.Objects.
                                                 equals(
                                                   existingSetting,
                                                   newSetting);
                                               if (!sameSettings) {
                                                   project.
                                                     setPluginStatusTrinary(
                                                       plugin.
                                                         getPluginId(
                                                           ),
                                                       newSetting);
                                                   changed =
                                                     true;
                                               }
                                           }
                                           if (enabled.
                                                 global) {
                                               enabledPlugins.
                                                 add(
                                                   plugin.
                                                     getPluginId(
                                                       ));
                                           }
                                           else {
                                               disabledPlugins.
                                                 add(
                                                   plugin.
                                                     getPluginId(
                                                       ));
                                           }
                                           if (plugin.
                                                 isGloballyEnabled(
                                                   ) !=
                                                 enabled.
                                                   global) {
                                               plugin.
                                                 setGloballyEnabled(
                                                   enabled.
                                                     global);
                                               changed =
                                                 true;
                                           }
                                       }
                                       if (changed &&
                                             project !=
                                             null) {
                                           edu.umd.cs.findbugs.gui2.MainFrame.
                                             getInstance(
                                               ).
                                             updateBugTree(
                                               );
                                           edu.umd.cs.findbugs.gui2.MainFrame.
                                             getInstance(
                                               ).
                                             setProjectChanged(
                                               true);
                                       }
                                       if (project ==
                                             null) {
                                           edu.umd.cs.findbugs.gui2.GUISaveState.
                                             getInstance(
                                               ).
                                             setPluginsEnabled(
                                               enabledPlugins,
                                               disabledPlugins);
                                           edu.umd.cs.findbugs.gui2.GUISaveState.
                                             getInstance(
                                               ).
                                             save(
                                               );
                                       } }
    private edu.umd.cs.findbugs.Project getCurrentProject() {
        edu.umd.cs.findbugs.BugCollection bugCollection =
          edu.umd.cs.findbugs.gui2.MainFrame.
          getInstance(
            ).
          getBugCollection(
            );
        return bugCollection ==
          null
          ? null
          : bugCollection.
          getProject(
            );
    }
    private javax.swing.JPanel createPluginPane() {
        final javax.swing.JPanel pluginPanel =
          new javax.swing.JPanel(
          );
        pluginPanel.
          setLayout(
            new java.awt.BorderLayout(
              ));
        pluginPanelCenter =
          new javax.swing.JPanel(
            );
        pluginPanel.
          add(
            pluginPanelCenter,
            java.awt.BorderLayout.
              CENTER);
        pluginPanelCenter.
          setBorder(
            new javax.swing.border.EmptyBorder(
              10,
              10,
              10,
              10));
        pluginPanelCenter.
          setLayout(
            new java.awt.GridBagLayout(
              ));
        javax.swing.JButton addButton =
          new javax.swing.JButton(
          "Install new plugin...");
        javax.swing.JPanel south =
          new javax.swing.JPanel(
          );
        south.
          add(
            addButton);
        addButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    javax.swing.JFileChooser chooser =
                      new javax.swing.JFileChooser(
                      );
                    chooser.
                      addChoosableFileFilter(
                        new javax.swing.filechooser.FileFilter(
                          ) {
                            @java.lang.Override
                            public java.lang.String getDescription() {
                                return "FindBugs Plugin (*.jar)";
                            }
                            @java.lang.Override
                            public boolean accept(java.io.File f) {
                                if (f.
                                      isDirectory(
                                        )) {
                                    return true;
                                }
                                if (!f.
                                      canRead(
                                        )) {
                                    return false;
                                }
                                if (f.
                                      getName(
                                        ).
                                      endsWith(
                                        ".jar")) {
                                    return true;
                                }
                                return false;
                            }
                        });
                    chooser.
                      setDialogTitle(
                        "Select a FindBugs plugin jar");
                    int retvalue =
                      chooser.
                      showDialog(
                        PreferencesFrame.this,
                        "Install");
                    if (retvalue ==
                          javax.swing.JFileChooser.
                            APPROVE_OPTION) {
                        java.io.File f =
                          chooser.
                          getSelectedFile(
                            );
                        try {
                            edu.umd.cs.findbugs.Plugin plugin =
                              edu.umd.cs.findbugs.Plugin.
                              loadCustomPlugin(
                                f,
                                PreferencesFrame.this.
                                  getCurrentProject(
                                    ));
                            edu.umd.cs.findbugs.gui2.GUISaveState guiSaveState =
                              edu.umd.cs.findbugs.gui2.GUISaveState.
                              getInstance(
                                );
                            java.net.URL url =
                              f.
                              toURI(
                                ).
                              toURL(
                                );
                            guiSaveState.
                              addCustomPlugin(
                                url);
                            guiSaveState.
                              setPluginEnabled(
                                plugin.
                                  getPluginId(
                                    ));
                            plugin.
                              setGloballyEnabled(
                                true);
                            guiSaveState.
                              save(
                                );
                            pluginsAdded =
                              true;
                            rebuildPluginCheckboxes(
                              );
                        }
                        catch (edu.umd.cs.findbugs.PluginException e1) {
                            LOGGER.
                              log(
                                java.util.logging.Level.
                                  WARNING,
                                "Could not load " +
                                f.
                                  getPath(
                                    ),
                                e1);
                            javax.swing.JOptionPane.
                              showMessageDialog(
                                PreferencesFrame.this,
                                "Could not load " +
                                f.
                                  getPath(
                                    ) +
                                "\n\n" +
                                e1.
                                  getClass(
                                    ).
                                  getSimpleName(
                                    ) +
                                ": " +
                                e1.
                                  getMessage(
                                    ),
                                "Error Loading Plugin",
                                javax.swing.JOptionPane.
                                  ERROR_MESSAGE);
                        }
                        catch (java.net.MalformedURLException e1) {
                            LOGGER.
                              log(
                                java.util.logging.Level.
                                  WARNING,
                                "Could not load " +
                                f.
                                  getPath(
                                    ),
                                e1);
                            javax.swing.JOptionPane.
                              showMessageDialog(
                                PreferencesFrame.this,
                                "Could not load " +
                                f.
                                  getPath(
                                    ) +
                                "\n\n" +
                                e1.
                                  getClass(
                                    ).
                                  getSimpleName(
                                    ) +
                                ": " +
                                e1.
                                  getMessage(
                                    ),
                                "Error Loading Plugin",
                                javax.swing.JOptionPane.
                                  ERROR_MESSAGE);
                        }
                    }
                }
            });
        pluginPanel.
          add(
            south,
            java.awt.BorderLayout.
              SOUTH);
        return pluginPanel;
    }
    edu.umd.cs.findbugs.gui2.PreferencesFrame.EnabledSettings isEnabled(@javax.annotation.CheckForNull
                                                                        edu.umd.cs.findbugs.Project project,
                                                                        edu.umd.cs.findbugs.Plugin plugin) {
        return new edu.umd.cs.findbugs.gui2.PreferencesFrame.EnabledSettings(
          plugin.
            isGloballyEnabled(
              ),
          project ==
            null
            ? null
            : project.
            getPluginStatus(
              plugin));
    }
    private void rebuildPluginCheckboxes() {
        edu.umd.cs.findbugs.Project currentProject =
          getCurrentProject(
            );
        pluginPanelCenter.
          removeAll(
            );
        if (currentProject !=
              null) {
            java.awt.GridBagConstraints g =
              new java.awt.GridBagConstraints(
              );
            g.
              fill =
              java.awt.GridBagConstraints.
                NONE;
            g.
              insets =
              new java.awt.Insets(
                5,
                5,
                5,
                5);
            g.
              gridy =
              0;
            g.
              anchor =
              java.awt.GridBagConstraints.
                CENTER;
            g.
              gridx =
              2;
            pluginPanelCenter.
              add(
                new javax.swing.JLabel(
                  "Project Setting"),
                g);
        }
        java.util.Collection<edu.umd.cs.findbugs.Plugin> plugins =
          edu.umd.cs.findbugs.Plugin.
          getAllPlugins(
            );
        int added =
          0;
        for (final edu.umd.cs.findbugs.Plugin plugin
              :
              plugins) {
            if (plugin.
                  isCorePlugin(
                    )) {
                continue;
            }
            java.lang.String text =
              plugin.
              getShortDescription(
                );
            java.lang.String id =
              plugin.
              getPluginId(
                );
            if (text ==
                  null) {
                text =
                  id;
            }
            final java.net.URL url =
              plugin.
              getPluginLoader(
                ).
              getURL(
                );
            java.lang.String pluginUrlStr =
              url.
              toExternalForm(
                );
            if ("file".
                  equals(
                    url.
                      getProtocol(
                        ))) {
                try {
                    pluginUrlStr =
                      new java.io.File(
                        java.net.URLDecoder.
                          decode(
                            url.
                              getPath(
                                ),
                            "UTF-8")).
                        getAbsolutePath(
                          );
                }
                catch (java.io.UnsupportedEncodingException e) {
                    
                }
            }
            text =
              java.lang.String.
                format(
                  ("<html>%s<br><font style=\'font-weight:normal;font-style:ital" +
                   "ic\'>%s"),
                  text,
                  pluginUrlStr);
            edu.umd.cs.findbugs.gui2.PreferencesFrame.EnabledSettings enabled =
              isEnabled(
                currentProject,
                plugin);
            final javax.swing.JCheckBox checkGlobal =
              new javax.swing.JCheckBox(
              text,
              enabled.
                global);
            final boolean cannotDisable =
              plugin.
              isEnabledByDefault(
                ) &&
              plugin.
              cannotDisable(
                );
            if (cannotDisable) {
                if (!enabled.
                       global) {
                    throw new java.lang.IllegalStateException(
                      plugin.
                        getPluginId(
                          ) +
                      (" is enabled by default and cannot be disabled, but is disabl" +
                       "ed"));
                }
                checkGlobal.
                  setEnabled(
                    false);
            }
            else {
                checkGlobal.
                  addMouseListener(
                    new java.awt.event.MouseAdapter(
                      ) {
                        @java.lang.Override
                        public void mousePressed(java.awt.event.MouseEvent e) {
                            if (javax.swing.SwingUtilities.
                                  isRightMouseButton(
                                    e)) {
                                javax.swing.JPopupMenu menu =
                                  new javax.swing.JPopupMenu(
                                  );
                                javax.swing.JMenuItem item =
                                  new javax.swing.JMenuItem(
                                  "Uninstall " +
                                  plugin.
                                    getShortDescription(
                                      ) +
                                  "...");
                                item.
                                  addActionListener(
                                    new edu.umd.cs.findbugs.gui2.PreferencesFrame.UninstallClickListener(
                                      plugin,
                                      url));
                                menu.
                                  add(
                                    item);
                                menu.
                                  show(
                                    checkGlobal,
                                    e.
                                      getX(
                                        ),
                                    e.
                                      getY(
                                        ));
                            }
                        }
                    });
                checkGlobal.
                  addActionListener(
                    new java.awt.event.ActionListener(
                      ) {
                        @java.lang.Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            pluginEnabledStatus.
                              get(
                                plugin).
                              global =
                              checkGlobal.
                                isSelected(
                                  );
                        }
                    });
            }
            checkGlobal.
              setVerticalTextPosition(
                javax.swing.SwingConstants.
                  TOP);
            java.lang.String longText =
              plugin.
              getDetailedDescription(
                );
            if (longText !=
                  null) {
                checkGlobal.
                  setToolTipText(
                    "<html>" +
                    longText +
                    "</html>");
            }
            pluginEnabledStatus.
              put(
                plugin,
                enabled);
            java.awt.GridBagConstraints gbc =
              new java.awt.GridBagConstraints(
              );
            gbc.
              fill =
              java.awt.GridBagConstraints.
                BOTH;
            gbc.
              weightx =
              1;
            gbc.
              gridx =
              1;
            gbc.
              insets =
              new java.awt.Insets(
                0,
                5,
                0,
                5);
            gbc.
              gridy =
              added +
                1;
            gbc.
              anchor =
              java.awt.GridBagConstraints.
                NORTHWEST;
            pluginPanelCenter.
              add(
                checkGlobal,
                gbc);
            if (currentProject !=
                  null &&
                  !cannotDisable) {
                final javax.swing.JComboBox<java.lang.String> combo =
                  new edu.umd.cs.findbugs.gui2.WideComboBox<java.lang.String>(
                  new java.lang.String[] { "DEFAULT",
                  "DISABLED",
                  "ENABLED" });
                if (enabled.
                      project ==
                      null) {
                    combo.
                      setSelectedIndex(
                        0);
                }
                else {
                    combo.
                      setSelectedIndex(
                        enabled.
                          project
                          ? 2
                          : 1);
                }
                combo.
                  setRenderer(
                    new javax.swing.DefaultListCellRenderer(
                      ) {
                        @java.lang.Override
                        public java.awt.Component getListCellRendererComponent(javax.swing.JList list,
                                                                               java.lang.Object value,
                                                                               int index,
                                                                               boolean isSelected,
                                                                               boolean cellHasFocus) {
                            if (index ==
                                  -1) {
                                if (value.
                                      equals(
                                        "DEFAULT")) {
                                    value =
                                      "Default";
                                }
                                if (value.
                                      equals(
                                        "DISABLED")) {
                                    value =
                                      "Disabled";
                                }
                                if (value.
                                      equals(
                                        "ENABLED")) {
                                    value =
                                      "Enabled";
                                }
                            }
                            else {
                                if (value.
                                      equals(
                                        "DEFAULT")) {
                                    value =
                                      "Default (use global setting)";
                                }
                                if (value.
                                      equals(
                                        "DISABLED")) {
                                    value =
                                      "Disabled for this project";
                                }
                                if (value.
                                      equals(
                                        "ENABLED")) {
                                    value =
                                      "Enabled for this project";
                                }
                            }
                            return super.
                              getListCellRendererComponent(
                                list,
                                value,
                                index,
                                isSelected,
                                cellHasFocus);
                        }
                    });
                combo.
                  addActionListener(
                    new java.awt.event.ActionListener(
                      ) {
                        @java.lang.Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            java.lang.Boolean[] array =
                              { null,
                            false,
                            true };
                            int i =
                              combo.
                              getSelectedIndex(
                                );
                            if (i <
                                  0 ||
                                  i >
                                  2) {
                                return;
                            }
                            pluginEnabledStatus.
                              get(
                                plugin).
                              project =
                              array[i];
                        }
                    });
                gbc.
                  gridx =
                  2;
                gbc.
                  fill =
                  java.awt.GridBagConstraints.
                    NONE;
                gbc.
                  weightx =
                  0;
                pluginPanelCenter.
                  add(
                    combo,
                    gbc);
            }
            added++;
        }
        if (added ==
              0) {
            javax.swing.JLabel label =
              new javax.swing.JLabel(
              "<html>No plugins are loaded.<br> " +
              ("Try installing <u><font color=blue>fb-contrib</font></u> - o" +
               "r write your own<br>") +
              "plugin for your project\'s needs!");
            label.
              setCursor(
                java.awt.Cursor.
                  getPredefinedCursor(
                    java.awt.Cursor.
                      HAND_CURSOR));
            label.
              addMouseListener(
                new java.awt.event.MouseAdapter(
                  ) {
                    @java.lang.Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        try {
                            edu.umd.cs.findbugs.util.LaunchBrowser.
                              showDocument(
                                new java.net.URL(
                                  "https://sourceforge.net/projects/fb-contrib/"));
                        }
                        catch (java.net.MalformedURLException e1) {
                            throw new java.lang.IllegalStateException(
                              e1);
                        }
                    }
                });
            label.
              setBorder(
                new javax.swing.border.EmptyBorder(
                  10,
                  10,
                  10,
                  10));
            pluginPanelCenter.
              add(
                label);
        }
        PreferencesFrame.this.
          pack(
            );
    }
    private void addField(javax.swing.JPanel p,
                          java.awt.GridBagConstraints c,
                          int y,
                          java.lang.String lbl,
                          javax.swing.JComponent field) {
        c.
          gridy =
          y;
        javax.swing.JLabel l =
          new javax.swing.JLabel(
          lbl,
          javax.swing.SwingConstants.
            TRAILING);
        l.
          setLabelFor(
            field);
        c.
          anchor =
          java.awt.GridBagConstraints.
            LINE_END;
        c.
          gridx =
          0;
        p.
          add(
            l,
            c);
        c.
          anchor =
          java.awt.GridBagConstraints.
            LINE_START;
        c.
          gridx =
          1;
        p.
          add(
            field,
            c);
    }
    private javax.swing.JPanel createPropertiesPane() {
        javax.swing.JPanel contentPanel =
          new javax.swing.JPanel(
          new java.awt.BorderLayout(
            ));
        javax.swing.JPanel mainPanel =
          new javax.swing.JPanel(
          new java.awt.GridBagLayout(
            ));
        java.awt.GridBagConstraints c =
          new java.awt.GridBagConstraints(
          );
        c.
          ipadx =
          (c.
             ipady =
             5);
        float currFS =
          edu.umd.cs.findbugs.gui2.Driver.
          getFontSize(
            );
        tabTextField =
          new javax.swing.JTextField(
            java.lang.Integer.
              toString(
                edu.umd.cs.findbugs.gui2.GUISaveState.
                  getInstance(
                    ).
                  getTabSize(
                    )));
        tabTextField.
          setPreferredSize(
            new java.awt.Dimension(
              (int)
                (currFS *
                   4),
              (int)
                (currFS *
                   2)));
        addField(
          mainPanel,
          c,
          0,
          "Tab size",
          tabTextField);
        fontTextField =
          new javax.swing.JTextField(
            java.lang.Float.
              toString(
                edu.umd.cs.findbugs.gui2.GUISaveState.
                  getInstance(
                    ).
                  getFontSize(
                    )));
        fontTextField.
          setPreferredSize(
            new java.awt.Dimension(
              (int)
                (currFS *
                   6),
              (int)
                (currFS *
                   2)));
        addField(
          mainPanel,
          c,
          1,
          "Font size",
          fontTextField);
        packagePrefixLengthTextField =
          new javax.swing.JTextField(
            java.lang.Integer.
              toString(
                edu.umd.cs.findbugs.gui2.GUISaveState.
                  getInstance(
                    ).
                  getPackagePrefixSegments(
                    )));
        packagePrefixLengthTextField.
          setPreferredSize(
            new java.awt.Dimension(
              (int)
                (currFS *
                   4),
              (int)
                (currFS *
                   2)));
        addField(
          mainPanel,
          c,
          2,
          "Package prefix length",
          packagePrefixLengthTextField);
        contentPanel.
          add(
            mainPanel,
            java.awt.BorderLayout.
              CENTER);
        javax.swing.JPanel bottomPanel =
          new javax.swing.JPanel(
          );
        bottomPanel.
          add(
            new javax.swing.JButton(
              new javax.swing.AbstractAction(
                "Apply") {
                  @java.lang.Override
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                      changeTabSize(
                        );
                      changeFontSize(
                        );
                      changePackagePrefixLength(
                        );
                  }
              }));
        bottomPanel.
          add(
            new javax.swing.JButton(
              new javax.swing.AbstractAction(
                "Reset") {
                  @java.lang.Override
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                      resetPropertiesPane(
                        );
                  }
              }));
        contentPanel.
          add(
            bottomPanel,
            java.awt.BorderLayout.
              SOUTH);
        return contentPanel;
    }
    static class PluginWithDescription {
        public PluginWithDescription(java.lang.String description,
                                     edu.umd.cs.findbugs.cloud.CloudPlugin plugin) {
            super(
              );
            this.
              description =
              description;
        }
        final java.lang.String description;
        @java.lang.Override
        public java.lang.String toString() {
            return description;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "gFUyRW4WAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "odzsWRYnD7rNQtnzxhy/Hs0qBThckk4Em32m2UiUJmtqMyNfaKy5WsWySJuU" +
           "sRKX54oxy8/Q2Jo4w2EP75lEoeia1NCgGgiYIQ0cR7xWiYmrJduYKDXHYhYr" +
           "r+1rVnMloFMcq06RGJfbRRZeUwYdtwo4guUco1b0uy7Sw/D5pJoXy0pnMNSl" +
           "gRLG3JTWS0bi27qXjMcuHiNjp1+R+nh1MYLZCVtdlf3lcoHMmsKKG5aG4JTy" +
           "pvT4ov10J8j7s4PxwXvOz3AkTu5weZCNtb0+zK58Lh5/FTh8fbi9DILS8+Gj" +
           "d3q4yc6Gn3jPrReV3ifzO3uXaBI49++9p23lpAf0Z+98CKazR6vtzc6X3vMv" +
           "jwzePH/7T3Ht/fgxJY+L/D36pa+0Xif/5g50+uCe57bntKNMN47e7lz01TDy" +
           "7cGRO55HD9z6UOqux4A7r++59frJV893nqPXb0LhLheUz92l751pkYTQhdDZ" +
           "XI5m4bONnNXRyLnvIHJO7d+iXt1ejvSWqu/rinqXYDvhFjGEHjzxoWR/gOs/" +
           "8YMLCJeHb3vU3TxEyp958fKF17wo/HX2uHDwWHgPBV3QItM8fB13qH7OBSPo" +
           "maPu2VzOudnPB0Po4TtpFUJn0p9M+w9syJ8PoQdOIAde368epv6NELq4pQ6h" +
           "HflI960QOr/XHUKnQXm486OgCXSm1RfcEy7AN3eWyamjyXow21d/3A3Lofx+" +
           "+khiZk/u+0kUbR7db8qffbHDvOOVyic3LyOyKa3XqZQLFHR+80hzkIhP3lHa" +
           "vqxz7es/vPS5e57ZR4xLG4W36XFIt8dPfoYgLDfMHg7Wf/iaz7/xd178ZnZ/" +
           "93+R8redCyEAAA==");
    }
    private void changeTabSize() { int tabSize;
                                   try { tabSize =
                                           java.lang.Integer.
                                             decode(
                                               tabTextField.
                                                 getText(
                                                   ));
                                   }
                                   catch (java.lang.NumberFormatException exc) {
                                       javax.swing.JOptionPane.
                                         showMessageDialog(
                                           instance,
                                           "Error in tab size field.",
                                           "Tab Size Error",
                                           javax.swing.JOptionPane.
                                             INFORMATION_MESSAGE);
                                       return;
                                   }
                                   if (tabSize <
                                         TAB_MIN ||
                                         tabSize >
                                         TAB_MAX) {
                                       javax.swing.JOptionPane.
                                         showMessageDialog(
                                           instance,
                                           "Tab size exceedes range (" +
                                           TAB_MIN +
                                           " - " +
                                           TAB_MAX +
                                           ").",
                                           "Tab Size Excedes Range",
                                           javax.swing.JOptionPane.
                                             INFORMATION_MESSAGE);
                                       return;
                                   }
                                   if (tabSize !=
                                         edu.umd.cs.findbugs.gui2.GUISaveState.
                                         getInstance(
                                           ).
                                         getTabSize(
                                           )) {
                                       edu.umd.cs.findbugs.gui2.GUISaveState.
                                         getInstance(
                                           ).
                                         setTabSize(
                                           tabSize);
                                       edu.umd.cs.findbugs.gui2.MainFrame.
                                         getInstance(
                                           ).
                                         getSourceCodeDisplayer(
                                           ).
                                         clearCache(
                                           );
                                       edu.umd.cs.findbugs.gui2.MainFrame.
                                         getInstance(
                                           ).
                                         syncBugInformation(
                                           );
                                   } }
    private void changeFontSize() { float fontSize;
                                    try {
                                        fontSize =
                                          java.lang.Float.
                                            parseFloat(
                                              fontTextField.
                                                getText(
                                                  ));
                                    }
                                    catch (java.lang.NumberFormatException exc) {
                                        javax.swing.JOptionPane.
                                          showMessageDialog(
                                            instance,
                                            "Error in font size field.",
                                            "Font Size Error",
                                            javax.swing.JOptionPane.
                                              INFORMATION_MESSAGE);
                                        return;
                                    }
                                    if (fontSize <
                                          FONT_MIN ||
                                          fontSize >
                                          FONT_MAX) {
                                        javax.swing.JOptionPane.
                                          showMessageDialog(
                                            instance,
                                            "Font size exceedes range (" +
                                            FONT_MIN +
                                            " - " +
                                            FONT_MAX +
                                            ").",
                                            "Font Size Exceedes Range",
                                            javax.swing.JOptionPane.
                                              INFORMATION_MESSAGE);
                                        return;
                                    }
                                    if (fontSize !=
                                          edu.umd.cs.findbugs.gui2.GUISaveState.
                                          getInstance(
                                            ).
                                          getFontSize(
                                            )) {
                                        edu.umd.cs.findbugs.gui2.GUISaveState.
                                          getInstance(
                                            ).
                                          setFontSize(
                                            fontSize);
                                        javax.swing.JOptionPane.
                                          showMessageDialog(
                                            instance,
                                            "To implement the new font size please restart FindBugs.",
                                            "Changing Font",
                                            javax.swing.JOptionPane.
                                              INFORMATION_MESSAGE);
                                    } }
    private void changePackagePrefixLength() {
        int value;
        try {
            value =
              java.lang.Integer.
                parseInt(
                  packagePrefixLengthTextField.
                    getText(
                      ));
        }
        catch (java.lang.NumberFormatException exc) {
            javax.swing.JOptionPane.
              showMessageDialog(
                instance,
                "Error in package prefix length field.",
                "Package Prefix Length Error",
                javax.swing.JOptionPane.
                  INFORMATION_MESSAGE);
            return;
        }
        if (value <
              1 ||
              value >
              12) {
            javax.swing.JOptionPane.
              showMessageDialog(
                instance,
                "package prefix length exceedes range (" +
                1 +
                " - " +
                12 +
                ").",
                "package prefix lengthe exceedes range",
                javax.swing.JOptionPane.
                  INFORMATION_MESSAGE);
            return;
        }
        if (value !=
              edu.umd.cs.findbugs.gui2.GUISaveState.
              getInstance(
                ).
              getPackagePrefixSegments(
                )) {
            edu.umd.cs.findbugs.gui2.GUISaveState.
              getInstance(
                ).
              setPackagePrefixSegments(
                value);
            edu.umd.cs.findbugs.gui2.BugTreeModel bt =
              (edu.umd.cs.findbugs.gui2.BugTreeModel)
                edu.umd.cs.findbugs.gui2.MainFrame.
                getInstance(
                  ).
                getTree(
                  ).
                getModel(
                  );
            bt.
              needToRebuild(
                );
            bt.
              checkSorter(
                );
        }
    }
    private void resetPropertiesPane() { tabTextField.
                                           setText(
                                             java.lang.Integer.
                                               toString(
                                                 edu.umd.cs.findbugs.gui2.GUISaveState.
                                                   getInstance(
                                                     ).
                                                   getTabSize(
                                                     )));
                                         fontTextField.
                                           setText(
                                             java.lang.Float.
                                               toString(
                                                 edu.umd.cs.findbugs.gui2.GUISaveState.
                                                   getInstance(
                                                     ).
                                                   getFontSize(
                                                     )));
                                         rebuildPluginCheckboxes(
                                           );
    }
    private javax.swing.JPanel createFilterPane() {
        javax.swing.JButton addButton =
          new javax.swing.JButton(
          edu.umd.cs.findbugs.L10N.
            getLocalString(
              "dlg.add_dot_btn",
              "Add..."));
        javax.swing.JButton removeButton =
          new javax.swing.JButton(
          edu.umd.cs.findbugs.L10N.
            getLocalString(
              "dlg.remove_btn",
              "Remove"));
        javax.swing.JButton removeAllButton =
          new javax.swing.JButton(
          edu.umd.cs.findbugs.L10N.
            getLocalString(
              "dlg.remove_all_btn",
              "Remove All"));
        javax.swing.JPanel filterPanel =
          new javax.swing.JPanel(
          );
        filterPanel.
          setLayout(
            new java.awt.GridBagLayout(
              ));
        java.awt.GridBagConstraints gbc =
          new java.awt.GridBagConstraints(
          );
        gbc.
          gridheight =
          1;
        gbc.
          gridwidth =
          1;
        gbc.
          gridx =
          0;
        gbc.
          gridy =
          0;
        gbc.
          fill =
          java.awt.GridBagConstraints.
            BOTH;
        gbc.
          weightx =
          1;
        gbc.
          weighty =
          1;
        filterPanel.
          add(
            new javax.swing.JLabel(
              ("<HTML>These rules control which bugs are shown and which are" +
               " hidden in this project")),
            gbc);
        gbc.
          gridheight =
          4;
        gbc.
          gridwidth =
          1;
        gbc.
          gridx =
          0;
        gbc.
          gridy =
          1;
        gbc.
          fill =
          java.awt.GridBagConstraints.
            BOTH;
        gbc.
          weightx =
          1;
        gbc.
          weighty =
          1;
        filterPanel.
          add(
            new javax.swing.JScrollPane(
              filterCheckBoxList),
            gbc);
        updateFilterPanel(
          );
        gbc.
          gridheight =
          1;
        gbc.
          gridx =
          1;
        gbc.
          gridy =
          1;
        gbc.
          fill =
          java.awt.GridBagConstraints.
            HORIZONTAL;
        gbc.
          weightx =
          0;
        gbc.
          weighty =
          0;
        filterPanel.
          add(
            addButton,
            gbc);
        addButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    edu.umd.cs.findbugs.gui2.NewFilterFrame.
                      open(
                        );
                }
            });
        gbc.
          gridy =
          2;
        gbc.
          insets =
          new java.awt.Insets(
            5,
            0,
            0,
            0);
        filterPanel.
          add(
            removeButton,
            gbc);
        removeButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    java.lang.Object[] selected =
                      filterCheckBoxList.
                      getSelectedValues(
                        );
                    if (selected.
                          length ==
                          0) {
                        return;
                    }
                    for (java.lang.Object o
                          :
                          selected) {
                        edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox box =
                          (edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox)
                            o;
                        edu.umd.cs.findbugs.gui2.MainFrame.
                          getInstance(
                            ).
                          getProject(
                            ).
                          getSuppressionFilter(
                            ).
                          removeChild(
                            box.
                              getMatcher(
                                ));
                    }
                    edu.umd.cs.findbugs.gui2.FilterActivity.
                      notifyListeners(
                        edu.umd.cs.findbugs.gui2.FilterListener.Action.
                          UNFILTERING,
                        null);
                    edu.umd.cs.findbugs.gui2.MainFrame.
                      getInstance(
                        ).
                      setProjectChanged(
                        true);
                    updateFilterPanel(
                      );
                }
            });
        gbc.
          gridy =
          3;
        gbc.
          weighty =
          0;
        gbc.
          insets =
          new java.awt.Insets(
            5,
            0,
            0,
            0);
        filterPanel.
          add(
            removeAllButton,
            gbc);
        removeAllButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boolean needsRebuild =
                      false;
                    edu.umd.cs.findbugs.filter.Filter suppressionFilter =
                      edu.umd.cs.findbugs.gui2.MainFrame.
                      getInstance(
                        ).
                      getProject(
                        ).
                      getSuppressionFilter(
                        );
                    if (!suppressionFilter.
                          isEmpty(
                            )) {
                        needsRebuild =
                          true;
                    }
                    suppressionFilter.
                      clear(
                        );
                    if (needsRebuild) {
                        edu.umd.cs.findbugs.gui2.FilterActivity.
                          notifyListeners(
                            edu.umd.cs.findbugs.gui2.FilterListener.Action.
                              UNFILTERING,
                            null);
                    }
                    edu.umd.cs.findbugs.gui2.MainFrame.
                      getInstance(
                        ).
                      setProjectChanged(
                        true);
                    updateFilterPanel(
                      );
                }
            });
        gbc.
          gridy =
          4;
        gbc.
          weighty =
          1;
        gbc.
          insets =
          new java.awt.Insets(
            0,
            0,
            0,
            0);
        filterPanel.
          add(
            javax.swing.Box.
              createGlue(
                ),
            gbc);
        return filterPanel;
    }
    private static class MatchBox extends javax.swing.JCheckBox {
        edu.umd.cs.findbugs.filter.Matcher
          m;
        MatchBox(java.lang.String text, edu.umd.cs.findbugs.filter.Matcher m) {
            super(
              text);
            this.
              m =
              m;
        }
        edu.umd.cs.findbugs.filter.Matcher getMatcher() {
            return m;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "xrG/F/j25/kjG578H5a/lvfzFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    void updateFilterPanel() { java.util.ArrayList<edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox> boxes =
                                 new java.util.ArrayList<edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox>(
                                 );
                               final edu.umd.cs.findbugs.filter.Filter f =
                                 edu.umd.cs.findbugs.gui2.MainFrame.
                                 getInstance(
                                   ).
                                 getProject(
                                   ).
                                 getSuppressionFilter(
                                   );
                               for (final edu.umd.cs.findbugs.filter.Matcher m
                                     :
                                     f.
                                      getChildren(
                                        )) {
                                   edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox box =
                                     new edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox(
                                     m.
                                       toString(
                                         ),
                                     m);
                                   box.
                                     addItemListener(
                                       new java.awt.event.ItemListener(
                                         ) {
                                           @java.lang.Override
                                           public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                               boolean isSelected =
                                                 ((javax.swing.JCheckBox)
                                                    evt.
                                                    getSource(
                                                      )).
                                                 isSelected(
                                                   );
                                               boolean wasSelected =
                                                 f.
                                                 isEnabled(
                                                   m);
                                               if (isSelected ==
                                                     wasSelected) {
                                                   return;
                                               }
                                               f.
                                                 setEnabled(
                                                   m,
                                                   isSelected);
                                               updateFilters(
                                                 isSelected);
                                           }
                                       });
                                   box.
                                     setSelected(
                                       f.
                                         isEnabled(
                                           m));
                                   boxes.
                                     add(
                                       box);
                               }
                               filterCheckBoxList.
                                 setListData(
                                   boxes.
                                     toArray(
                                       new edu.umd.cs.findbugs.gui2.PreferencesFrame.MatchBox[boxes.
                                                                                                size(
                                                                                                  )]));
    }
    public static void updateFilters(boolean addedFilter) {
        edu.umd.cs.findbugs.gui2.FilterActivity.
          notifyListeners(
            addedFilter
              ? edu.umd.cs.findbugs.gui2.FilterListener.Action.
                  FILTERING
              : edu.umd.cs.findbugs.gui2.FilterListener.Action.
                  UNFILTERING,
            null);
        edu.umd.cs.findbugs.gui2.MainFrame.
          getInstance(
            ).
          setProjectChanged(
            true);
    }
    private class UninstallClickListener implements java.awt.event.ActionListener {
        private final edu.umd.cs.findbugs.Plugin
          plugin;
        private final java.net.URL url;
        public UninstallClickListener(edu.umd.cs.findbugs.Plugin plugin,
                                      java.net.URL url) {
            super(
              );
            this.
              plugin =
              plugin;
            this.
              url =
              url;
        }
        @java.lang.Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            int result =
              javax.swing.JOptionPane.
              showOptionDialog(
                PreferencesFrame.this,
                "Are you sure you want to uninstall " +
                plugin.
                  getShortDescription(
                    ) +
                "?" +
                "\n\nNo files will be deleted from your computer.",
                "",
                javax.swing.JOptionPane.
                  YES_NO_OPTION,
                javax.swing.JOptionPane.
                  QUESTION_MESSAGE,
                null,
                new java.lang.Object[] { "Uninstall",
                "Cancel" },
                "Cancel");
            if (result ==
                  0) {
                if (!edu.umd.cs.findbugs.gui2.GUISaveState.
                      getInstance(
                        ).
                      removeCustomPlugin(
                        url)) {
                    if ("file".
                          equals(
                            url.
                              getProtocol(
                                ))) {
                        java.lang.String path =
                          url.
                          toExternalForm(
                            );
                        try {
                            path =
                              new java.io.File(
                                java.net.URLDecoder.
                                  decode(
                                    url.
                                      getPath(
                                        ),
                                    "UTF-8")).
                                getAbsolutePath(
                                  );
                        }
                        catch (java.io.UnsupportedEncodingException ex) {
                            
                        }
                        try {
                            java.awt.datatransfer.StringSelection contents =
                              new java.awt.datatransfer.StringSelection(
                              path);
                            java.awt.Toolkit.
                              getDefaultToolkit(
                                ).
                              getSystemClipboard(
                                ).
                              setContents(
                                contents,
                                contents);
                        }
                        catch (java.lang.Exception e1) {
                            
                        }
                        javax.swing.JOptionPane.
                          showMessageDialog(
                            PreferencesFrame.this,
                            "The plugin could not be uninstalled automatically.\n\n" +
                            "You can try to delete this plugin manually: \n" +
                            path +
                            "\n\n(This path has been copied to your clipboard)",
                            "Error",
                            javax.swing.JOptionPane.
                              ERROR_MESSAGE);
                    }
                    else {
                        javax.swing.JOptionPane.
                          showMessageDialog(
                            PreferencesFrame.this,
                            "This plugin is not actually in the list of plugins...\n" +
                            "Not sure what to do...\n " +
                            url.
                              toExternalForm(
                                ) +
                            "\n\nPlugin URL\'s:\n" +
                            edu.umd.cs.findbugs.gui2.GUISaveState.
                              getInstance(
                                ).
                              getCustomPlugins(
                                ),
                            "Error",
                            javax.swing.JOptionPane.
                              ERROR_MESSAGE);
                    }
                }
                else {
                    javax.swing.JOptionPane.
                      showMessageDialog(
                        PreferencesFrame.this,
                        "Changes will take effect after you restart FindBugs.");
                }
            }
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
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "H6iTeAVPPAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rEz1sT4byYspWEYqBqWv5oKiIQNsS6J1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
