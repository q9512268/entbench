package edu.umd.cs.findbugs.gui2;
import static edu.umd.cs.findbugs.gui2.MainFrameHelper.*;
public class MainFrameMenu implements java.io.Serializable {
    private final edu.umd.cs.findbugs.gui2.MainFrame mainFrame;
    javax.swing.JMenuItem reconfigMenuItem = newJMenuItem("menu.reconfig",
                                                          "Reconfigure...",
                                                          java.awt.event.KeyEvent.
                                                            VK_F);
    javax.swing.JMenuItem redoAnalysis;
    javax.swing.JMenuItem closeProjectItem;
    edu.umd.cs.findbugs.gui2.RecentMenu recentMenuCache;
    javax.swing.JMenu recentMenu;
    javax.swing.JMenuItem preferencesMenuItem;
    javax.swing.JMenu viewMenu;
    javax.swing.JMenuItem saveMenuItem = newJMenuItem("menu.save_item",
                                                      "Save",
                                                      java.awt.event.KeyEvent.
                                                        VK_S);
    private java.lang.Class<?> osxAdapter;
    private java.lang.reflect.Method osxPrefsEnableMethod;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem groupByMenuItem;
    public MainFrameMenu(edu.umd.cs.findbugs.gui2.MainFrame mainFrame) {
        super(
          );
        this.
          mainFrame =
          mainFrame;
    }
    javax.swing.JMenuItem createRecentItem(final java.io.File f, final edu.umd.cs.findbugs.gui2.SaveType localSaveType) {
        if (edu.umd.cs.findbugs.gui2.MainFrame.
              GUI2_DEBUG) {
            java.lang.System.
              out.
              println(
                "createRecentItem(" +
                f +
                ", " +
                localSaveType +
                ")");
        }
        java.lang.String name =
          f.
          getName(
            );
        final javax.swing.JMenuItem item =
          new javax.swing.JMenuItem(
          name);
        item.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        mainFrame.
                          setCursor(
                            new java.awt.Cursor(
                              java.awt.Cursor.
                                WAIT_CURSOR));
                        if (!f.
                              exists(
                                )) {
                            javax.swing.JOptionPane.
                              showMessageDialog(
                                null,
                                edu.umd.cs.findbugs.L10N.
                                  getLocalString(
                                    "msg.proj_not_found",
                                    "This project can no longer be found"));
                            edu.umd.cs.findbugs.gui2.GUISaveState.
                              getInstance(
                                ).
                              fileNotFound(
                                f);
                            return;
                        }
                        edu.umd.cs.findbugs.gui2.GUISaveState.
                          getInstance(
                            ).
                          fileReused(
                            f);
                        recentMenuCache.
                          addRecentFile(
                            f);
                        if (!f.
                              exists(
                                )) {
                            throw new java.lang.IllegalStateException(
                              "User used a recent projects menu item that didn\'t exist.");
                        }
                        if (mainFrame.
                              getCurProject(
                                ) !=
                              null &&
                              mainFrame.
                              isProjectChanged(
                                )) {
                            int response =
                              javax.swing.JOptionPane.
                              showConfirmDialog(
                                mainFrame,
                                edu.umd.cs.findbugs.L10N.
                                  getLocalString(
                                    "dlg.save_current_changes",
                                    "The current project has been changed, Save current changes?"),
                                edu.umd.cs.findbugs.L10N.
                                  getLocalString(
                                    "dlg.save_changes",
                                    "Save Changes?"),
                                javax.swing.JOptionPane.
                                  YES_NO_CANCEL_OPTION,
                                javax.swing.JOptionPane.
                                  WARNING_MESSAGE);
                            if (response ==
                                  javax.swing.JOptionPane.
                                    YES_OPTION) {
                                if (mainFrame.
                                      getSaveFile(
                                        ) !=
                                      null) {
                                    mainFrame.
                                      getMainFrameLoadSaveHelper(
                                        ).
                                      save(
                                        );
                                }
                                else {
                                    mainFrame.
                                      getMainFrameLoadSaveHelper(
                                        ).
                                      saveAs(
                                        );
                                }
                            }
                            else
                                if (response ==
                                      javax.swing.JOptionPane.
                                        CANCEL_OPTION) {
                                    return;
                                }
                        }
                        edu.umd.cs.findbugs.gui2.SaveType st =
                          edu.umd.cs.findbugs.gui2.SaveType.
                          forFile(
                            f);
                        boolean result =
                          true;
                        switch (st) {
                            case XML_ANALYSIS:
                                result =
                                  mainFrame.
                                    openAnalysis(
                                      f,
                                      st);
                                break;
                            case FBP_FILE:
                                result =
                                  mainFrame.
                                    getMainFrameLoadSaveHelper(
                                      ).
                                    openFBPFile(
                                      f);
                                break;
                            case FBA_FILE:
                                result =
                                  mainFrame.
                                    getMainFrameLoadSaveHelper(
                                      ).
                                    openFBAFile(
                                      f);
                                break;
                            default:
                                mainFrame.
                                  error(
                                    "Wrong file type in recent menu item.");
                        }
                        if (!result) {
                            javax.swing.JOptionPane.
                              showMessageDialog(
                                edu.umd.cs.findbugs.gui2.MainFrame.
                                  getInstance(
                                    ),
                                "There was an error in opening the file",
                                "Recent Menu Opening Error",
                                javax.swing.JOptionPane.
                                  WARNING_MESSAGE);
                        }
                    }
                    finally {
                        mainFrame.
                          setCursor(
                            new java.awt.Cursor(
                              java.awt.Cursor.
                                DEFAULT_CURSOR));
                        mainFrame.
                          setSaveType(
                            localSaveType);
                    }
                }
            });
        item.
          setFont(
            item.
              getFont(
                ).
              deriveFont(
                edu.umd.cs.findbugs.gui2.Driver.
                  getFontSize(
                    )));
        return item;
    }
    javax.swing.JMenuBar createMainMenuBar() {
        javax.swing.JMenuBar menuBar =
          new javax.swing.JMenuBar(
          );
        javax.swing.JMenu fileMenu =
          newJMenu(
            "menu.file_menu",
            "File");
        fileMenu.
          setMnemonic(
            java.awt.event.KeyEvent.
              VK_F);
        javax.swing.JMenu editMenu =
          newJMenu(
            "menu.edit_menu",
            "Edit");
        editMenu.
          setMnemonic(
            java.awt.event.KeyEvent.
              VK_E);
        javax.swing.JMenuItem openMenuItem =
          newJMenuItem(
            "menu.open_item",
            "Open...",
            java.awt.event.KeyEvent.
              VK_O);
        recentMenu =
          newJMenu(
            "menu.recent_menu",
            "Recent");
        recentMenuCache =
          new edu.umd.cs.findbugs.gui2.RecentMenu(
            recentMenu);
        saveAsMenuItem =
          newJMenuItem(
            "menu.saveas_item",
            "Save As...",
            java.awt.event.KeyEvent.
              VK_A);
        javax.swing.JMenuItem importFilter =
          newJMenuItem(
            "menu.importFilter_item",
            "Import bug filters...");
        javax.swing.JMenuItem exportFilter =
          newJMenuItem(
            "menu.exportFilter_item",
            "Export bug filters...");
        javax.swing.JMenuItem exitMenuItem =
          null;
        if (!edu.umd.cs.findbugs.gui2.MainFrame.
               MAC_OS_X) {
            exitMenuItem =
              newJMenuItem(
                "menu.exit",
                "Exit",
                java.awt.event.KeyEvent.
                  VK_X);
            exitMenuItem.
              addActionListener(
                new java.awt.event.ActionListener(
                  ) {
                    @java.lang.Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mainFrame.
                          callOnClose(
                            );
                    }
                });
        }
        javax.swing.JMenu windowMenu =
          mainFrame.
          getGuiLayout(
            ).
          createWindowMenu(
            );
        javax.swing.JMenuItem newProjectMenuItem =
          null;
        if (!edu.umd.cs.findbugs.FindBugs.
              isNoAnalysis(
                )) {
            newProjectMenuItem =
              newJMenuItem(
                "menu.new_item",
                "New Project",
                java.awt.event.KeyEvent.
                  VK_N);
            attachAcceleratorKey(
              newProjectMenuItem,
              java.awt.event.KeyEvent.
                VK_N);
            newProjectMenuItem.
              addActionListener(
                new java.awt.event.ActionListener(
                  ) {
                    @java.lang.Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mainFrame.
                          createNewProjectFromMenuItem(
                            );
                    }
                });
        }
        reconfigMenuItem.
          setEnabled(
            false);
        attachAcceleratorKey(
          reconfigMenuItem,
          java.awt.event.KeyEvent.
            VK_F);
        reconfigMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (!mainFrame.
                          canNavigateAway(
                            )) {
                        return;
                    }
                    new edu.umd.cs.findbugs.gui2.NewProjectWizard(
                      mainFrame.
                        getCurProject(
                          ));
                }
            });
        javax.swing.JMenuItem mergeMenuItem =
          newJMenuItem(
            "menu.mergeAnalysis",
            "Merge Analysis...");
        mergeMenuItem.
          setEnabled(
            true);
        mergeMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      getMainFrameLoadSaveHelper(
                        ).
                      mergeAnalysis(
                        );
                }
            });
        if (!edu.umd.cs.findbugs.FindBugs.
              isNoAnalysis(
                )) {
            redoAnalysis =
              newJMenuItem(
                "menu.rerunAnalysis",
                "Redo Analysis",
                java.awt.event.KeyEvent.
                  VK_R);
            redoAnalysis.
              setEnabled(
                false);
            attachAcceleratorKey(
              redoAnalysis,
              java.awt.event.KeyEvent.
                VK_R);
            redoAnalysis.
              addActionListener(
                new java.awt.event.ActionListener(
                  ) {
                    @java.lang.Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mainFrame.
                          redoAnalysis(
                            );
                    }
                });
        }
        closeProjectItem =
          newJMenuItem(
            "menu.closeProject",
            "Close Project");
        closeProjectItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    mainFrame.
                      getMainFrameLoadSaveHelper(
                        ).
                      closeProject(
                        );
                    mainFrame.
                      clearBugCollection(
                        );
                }
            });
        closeProjectItem.
          setEnabled(
            false);
        openMenuItem.
          setEnabled(
            true);
        attachAcceleratorKey(
          openMenuItem,
          java.awt.event.KeyEvent.
            VK_O);
        openMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      getMainFrameLoadSaveHelper(
                        ).
                      open(
                        );
                }
            });
        saveAsMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      getMainFrameLoadSaveHelper(
                        ).
                      saveAs(
                        );
                }
            });
        exportFilter.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      getMainFrameLoadSaveHelper(
                        ).
                      exportFilter(
                        );
                }
            });
        importFilter.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      getMainFrameLoadSaveHelper(
                        ).
                      importFilter(
                        );
                }
            });
        saveMenuItem.
          setEnabled(
            false);
        attachAcceleratorKey(
          saveMenuItem,
          java.awt.event.KeyEvent.
            VK_S);
        saveMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      getMainFrameLoadSaveHelper(
                        ).
                      save(
                        );
                }
            });
        if (!edu.umd.cs.findbugs.FindBugs.
              isNoAnalysis(
                )) {
            fileMenu.
              add(
                newProjectMenuItem);
        }
        fileMenu.
          add(
            openMenuItem);
        fileMenu.
          add(
            recentMenu);
        fileMenu.
          addSeparator(
            );
        fileMenu.
          add(
            saveAsMenuItem);
        fileMenu.
          add(
            saveMenuItem);
        fileMenu.
          addSeparator(
            );
        fileMenu.
          add(
            reconfigMenuItem);
        if (!edu.umd.cs.findbugs.FindBugs.
              isNoAnalysis(
                )) {
            fileMenu.
              add(
                redoAnalysis);
        }
        fileMenu.
          addSeparator(
            );
        fileMenu.
          add(
            closeProjectItem);
        fileMenu.
          addSeparator(
            );
        fileMenu.
          add(
            importFilter);
        fileMenu.
          add(
            exportFilter);
        if (exitMenuItem !=
              null) {
            fileMenu.
              addSeparator(
                );
            fileMenu.
              add(
                exitMenuItem);
        }
        menuBar.
          add(
            fileMenu);
        javax.swing.JMenuItem cutMenuItem =
          new javax.swing.JMenuItem(
          new edu.umd.cs.findbugs.gui2.MainFrameMenu.CutAction(
            ));
        javax.swing.JMenuItem copyMenuItem =
          new javax.swing.JMenuItem(
          new edu.umd.cs.findbugs.gui2.MainFrameMenu.CopyAction(
            ));
        javax.swing.JMenuItem pasteMenuItem =
          new javax.swing.JMenuItem(
          new edu.umd.cs.findbugs.gui2.MainFrameMenu.PasteAction(
            ));
        preferencesMenuItem =
          newJMenuItem(
            "menu.preferences_menu",
            "Preferences...");
        groupByMenuItem =
          newJMenuItem(
            "menu.sortConfiguration",
            "Sort Configuration...");
        javax.swing.JMenuItem goToLineMenuItem =
          newJMenuItem(
            "menu.gotoLine",
            "Go to line...");
        attachAcceleratorKey(
          cutMenuItem,
          java.awt.event.KeyEvent.
            VK_X);
        attachAcceleratorKey(
          copyMenuItem,
          java.awt.event.KeyEvent.
            VK_C);
        attachAcceleratorKey(
          pasteMenuItem,
          java.awt.event.KeyEvent.
            VK_V);
        preferencesMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      preferences(
                        );
                }
            });
        groupByMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (!mainFrame.
                          canNavigateAway(
                            )) {
                        return;
                    }
                    edu.umd.cs.findbugs.gui2.SorterDialog.
                      getInstance(
                        ).
                      setLocationRelativeTo(
                        mainFrame);
                    edu.umd.cs.findbugs.gui2.SorterDialog.
                      getInstance(
                        ).
                      setVisible(
                        true);
                }
            });
        attachAcceleratorKey(
          goToLineMenuItem,
          java.awt.event.KeyEvent.
            VK_L);
        goToLineMenuItem.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainFrame.
                      getGuiLayout(
                        ).
                      makeSourceVisible(
                        );
                    try {
                        int num =
                          java.lang.Integer.
                          parseInt(
                            javax.swing.JOptionPane.
                              showInputDialog(
                                mainFrame,
                                "",
                                edu.umd.cs.findbugs.L10N.
                                  getLocalString(
                                    "dlg.go_to_line_lbl",
                                    "Go To Line") +
                                ":",
                                javax.swing.JOptionPane.
                                  QUESTION_MESSAGE));
                        mainFrame.
                          getSourceCodeDisplayer(
                            ).
                          showLine(
                            num);
                    }
                    catch (java.lang.NumberFormatException e) {
                        
                    }
                }
            });
        editMenu.
          add(
            cutMenuItem);
        editMenu.
          add(
            copyMenuItem);
        editMenu.
          add(
            pasteMenuItem);
        editMenu.
          addSeparator(
            );
        editMenu.
          add(
            goToLineMenuItem);
        editMenu.
          addSeparator(
            );
        if (!edu.umd.cs.findbugs.gui2.MainFrame.
               MAC_OS_X) {
            editMenu.
              add(
                preferencesMenuItem);
        }
        menuBar.
          add(
            editMenu);
        if (windowMenu !=
              null) {
            menuBar.
              add(
                windowMenu);
        }
        viewMenu =
          newJMenu(
            "menu.view_menu",
            "View");
        setViewMenu(
          );
        menuBar.
          add(
            viewMenu);
        final javax.swing.ActionMap map =
          mainFrame.
          getMainFrameTree(
            ).
          getTree(
            ).
          getActionMap(
            );
        javax.swing.JMenu navMenu =
          newJMenu(
            "menu.navigation",
            "Navigation");
        addNavItem(
          map,
          navMenu,
          "menu.expand",
          "Expand",
          "expand",
          java.awt.event.KeyEvent.
            VK_RIGHT);
        addNavItem(
          map,
          navMenu,
          "menu.collapse",
          "Collapse",
          "collapse",
          java.awt.event.KeyEvent.
            VK_LEFT);
        addNavItem(
          map,
          navMenu,
          "menu.up",
          "Up",
          "selectPrevious",
          java.awt.event.KeyEvent.
            VK_UP);
        addNavItem(
          map,
          navMenu,
          "menu.down",
          "Down",
          "selectNext",
          java.awt.event.KeyEvent.
            VK_DOWN);
        menuBar.
          add(
            navMenu);
        javax.swing.JMenu designationMenu =
          newJMenu(
            "menu.designation",
            "Designation");
        int i =
          0;
        int[] keyEvents =
          { java.awt.event.KeyEvent.
              VK_1,
        java.awt.event.KeyEvent.
          VK_2,
        java.awt.event.KeyEvent.
          VK_3,
        java.awt.event.KeyEvent.
          VK_4,
        java.awt.event.KeyEvent.
          VK_5,
        java.awt.event.KeyEvent.
          VK_6,
        java.awt.event.KeyEvent.
          VK_7,
        java.awt.event.KeyEvent.
          VK_8,
        java.awt.event.KeyEvent.
          VK_9 };
        for (java.lang.String key
              :
              edu.umd.cs.findbugs.I18N.
               instance(
                 ).
               getUserDesignationKeys(
                 true)) {
            java.lang.String name =
              edu.umd.cs.findbugs.I18N.
              instance(
                ).
              getUserDesignation(
                key);
            mainFrame.
              addDesignationItem(
                designationMenu,
                key,
                name,
                keyEvents[i++]);
        }
        menuBar.
          add(
            designationMenu);
        if (!edu.umd.cs.findbugs.gui2.MainFrame.
               MAC_OS_X) {
            javax.swing.JMenu helpMenu =
              newJMenu(
                "menu.help_menu",
                "Help");
            javax.swing.JMenuItem aboutItem =
              newJMenuItem(
                "menu.about_item",
                "About FindBugs");
            helpMenu.
              add(
                aboutItem);
            aboutItem.
              addActionListener(
                new java.awt.event.ActionListener(
                  ) {
                    @java.lang.Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mainFrame.
                          about(
                            );
                    }
                });
            javax.swing.JMenuItem updateItem =
              newJMenuItem(
                "menu.check_for_updates",
                "Check for Updates...");
            edu.umd.cs.findbugs.updates.UpdateChecker checker =
              edu.umd.cs.findbugs.DetectorFactoryCollection.
              instance(
                ).
              getUpdateChecker(
                );
            boolean disabled =
              checker.
              updateChecksGloballyDisabled(
                );
            updateItem.
              setEnabled(
                !disabled);
            if (disabled) {
                updateItem.
                  setToolTipText(
                    "Update checks disabled by plugin: " +
                    checker.
                      getPluginThatDisabledUpdateChecks(
                        ));
            }
            helpMenu.
              add(
                updateItem);
            updateItem.
              addActionListener(
                new java.awt.event.ActionListener(
                  ) {
                    @java.lang.Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        edu.umd.cs.findbugs.DetectorFactoryCollection.
                          instance(
                            ).
                          checkForUpdates(
                            true);
                    }
                });
            menuBar.
              add(
                helpMenu);
        }
        return menuBar;
    }
    void setViewMenu() { edu.umd.cs.findbugs.cloud.Cloud cloud =
                           mainFrame.
                           getBugCollection(
                             ) ==
                           null
                           ? null
                           : mainFrame.
                           getBugCollection(
                             ).
                           getCloud(
                             );
                         viewMenu.removeAll(
                                    );
                         viewMenu.add(groupByMenuItem);
                         if (cloud != null &&
                               cloud.
                               supportsCloudSummaries(
                                 )) { javax.swing.JMenuItem cloudReport =
                                        new javax.swing.JMenuItem(
                                        "Cloud summary");
                                      cloudReport.
                                        addActionListener(
                                          new java.awt.event.ActionListener(
                                            ) {
                                              @java.lang.Override
                                              public void actionPerformed(java.awt.event.ActionEvent e) {
                                                  mainFrame.
                                                    displayCloudReport(
                                                      );
                                              }
                                          });
                                      viewMenu.
                                        add(
                                          cloudReport);
                         }
                         if (mainFrame.getProjectPackagePrefixes(
                                         ).
                               size(
                                 ) >
                               0 &&
                               mainFrame.
                               getBugCollection(
                                 ) !=
                               null) { javax.swing.JMenuItem selectPackagePrefixMenu =
                                         new javax.swing.JMenuItem(
                                         "Select class search strings by project...");
                                       selectPackagePrefixMenu.
                                         addActionListener(
                                           new java.awt.event.ActionListener(
                                             ) {
                                               @java.lang.Override
                                               public void actionPerformed(java.awt.event.ActionEvent e) {
                                                   mainFrame.
                                                     selectPackagePrefixByProject(
                                                       );
                                               }
                                           });
                                       viewMenu.
                                         add(
                                           selectPackagePrefixMenu);
                         }
                         if (viewMenu.getItemCount(
                                        ) >
                               0) { viewMenu.
                                      addSeparator(
                                        );
                         }
                         javax.swing.ButtonGroup rankButtonGroup =
                           new javax.swing.ButtonGroup(
                           );
                         for (final edu.umd.cs.findbugs.gui2.ViewFilter.RankFilter r
                               :
                               edu.umd.cs.findbugs.gui2.ViewFilter.RankFilter.
                                values(
                                  )) { javax.swing.JRadioButtonMenuItem rbMenuItem =
                                         new javax.swing.JRadioButtonMenuItem(
                                         r.
                                           toString(
                                             ));
                                       edu.umd.cs.findbugs.gui.AnnotatedString.
                                         localiseButton(
                                           rbMenuItem,
                                           "menu.rankFilter_" +
                                           r.
                                             name(
                                               ).
                                             toLowerCase(
                                               java.util.Locale.
                                                 ENGLISH),
                                           r.
                                             toString(
                                               ),
                                           true);
                                       rankButtonGroup.
                                         add(
                                           rbMenuItem);
                                       if (r ==
                                             edu.umd.cs.findbugs.gui2.ViewFilter.RankFilter.
                                               ALL) {
                                           rbMenuItem.
                                             setSelected(
                                               true);
                                       }
                                       rbMenuItem.
                                         addActionListener(
                                           new java.awt.event.ActionListener(
                                             ) {
                                               @java.lang.Override
                                               public void actionPerformed(java.awt.event.ActionEvent e) {
                                                   mainFrame.
                                                     getViewFilter(
                                                       ).
                                                     setRank(
                                                       r);
                                                   mainFrame.
                                                     resetViewCache(
                                                       );
                                               }
                                           });
                                       viewMenu.
                                         add(
                                           rbMenuItem);
                         }
                         viewMenu.addSeparator(
                                    );
                         javax.swing.ButtonGroup priorityButtonGroup =
                           new javax.swing.ButtonGroup(
                           );
                         for (final edu.umd.cs.findbugs.gui2.ViewFilter.PriorityFilter r
                               :
                               edu.umd.cs.findbugs.gui2.ViewFilter.PriorityFilter.
                                values(
                                  )) { javax.swing.JRadioButtonMenuItem rbMenuItem =
                                         new javax.swing.JRadioButtonMenuItem(
                                         r.
                                           toString(
                                             ));
                                       edu.umd.cs.findbugs.gui.AnnotatedString.
                                         localiseButton(
                                           rbMenuItem,
                                           "menu.priorityFilter_" +
                                           r.
                                             name(
                                               ).
                                             toLowerCase(
                                               java.util.Locale.
                                                 ENGLISH),
                                           r.
                                             toString(
                                               ),
                                           true);
                                       priorityButtonGroup.
                                         add(
                                           rbMenuItem);
                                       if (r ==
                                             edu.umd.cs.findbugs.gui2.ViewFilter.PriorityFilter.
                                               ALL_BUGS) {
                                           rbMenuItem.
                                             setSelected(
                                               true);
                                       }
                                       rbMenuItem.
                                         addActionListener(
                                           new java.awt.event.ActionListener(
                                             ) {
                                               @java.lang.Override
                                               public void actionPerformed(java.awt.event.ActionEvent e) {
                                                   mainFrame.
                                                     getViewFilter(
                                                       ).
                                                     setPriority(
                                                       r);
                                                   mainFrame.
                                                     resetViewCache(
                                                       );
                                               }
                                           });
                                       viewMenu.
                                         add(
                                           rbMenuItem);
                         }
                         viewMenu.addSeparator(
                                    );
                         if (cloud != null &&
                               cloud.
                               getMode(
                                 ) ==
                               edu.umd.cs.findbugs.cloud.Cloud.Mode.
                                 COMMUNAL) {
                             javax.swing.ButtonGroup overallClassificationButtonGroup =
                               new javax.swing.ButtonGroup(
                               );
                             for (final edu.umd.cs.findbugs.gui2.ViewFilter.OverallClassificationFilter r
                                   :
                                   edu.umd.cs.findbugs.gui2.ViewFilter.OverallClassificationFilter.
                                    values(
                                      )) {
                                 if (!r.
                                       supported(
                                         cloud)) {
                                     continue;
                                 }
                                 javax.swing.JRadioButtonMenuItem rbMenuItem =
                                   new javax.swing.JRadioButtonMenuItem(
                                   r.
                                     toString(
                                       ));
                                 edu.umd.cs.findbugs.gui.AnnotatedString.
                                   localiseButton(
                                     rbMenuItem,
                                     "menu.classificatonFilter_" +
                                     r.
                                       name(
                                         ).
                                       toLowerCase(
                                         java.util.Locale.
                                           ENGLISH),
                                     r.
                                       toString(
                                         ),
                                     true);
                                 overallClassificationButtonGroup.
                                   add(
                                     rbMenuItem);
                                 if (r ==
                                       edu.umd.cs.findbugs.gui2.ViewFilter.OverallClassificationFilter.
                                         ALL) {
                                     rbMenuItem.
                                       setSelected(
                                         true);
                                 }
                                 rbMenuItem.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         @java.lang.Override
                                         public void actionPerformed(java.awt.event.ActionEvent e) {
                                             mainFrame.
                                               getViewFilter(
                                                 ).
                                               setClassification(
                                                 r);
                                             mainFrame.
                                               resetViewCache(
                                                 );
                                         }
                                     });
                                 viewMenu.
                                   add(
                                     rbMenuItem);
                             }
                             viewMenu.
                               addSeparator(
                                 );
                         }
                         javax.swing.ButtonGroup evalButtonGroup =
                           new javax.swing.ButtonGroup(
                           );
                         for (final edu.umd.cs.findbugs.gui2.ViewFilter.CloudFilter r
                               :
                               edu.umd.cs.findbugs.gui2.ViewFilter.CloudFilter.
                                values(
                                  )) { if (cloud !=
                                             null &&
                                             !r.
                                             supported(
                                               cloud)) {
                                           continue;
                                       }
                                       javax.swing.JRadioButtonMenuItem rbMenuItem =
                                         new javax.swing.JRadioButtonMenuItem(
                                         r.
                                           toString(
                                             ));
                                       edu.umd.cs.findbugs.gui.AnnotatedString.
                                         localiseButton(
                                           rbMenuItem,
                                           "menu.cloudFilter_" +
                                           r.
                                             name(
                                               ).
                                             toLowerCase(
                                               java.util.Locale.
                                                 ENGLISH),
                                           r.
                                             toString(
                                               ),
                                           true);
                                       evalButtonGroup.
                                         add(
                                           rbMenuItem);
                                       if (r ==
                                             edu.umd.cs.findbugs.gui2.ViewFilter.CloudFilter.
                                               ALL) {
                                           rbMenuItem.
                                             setSelected(
                                               true);
                                       }
                                       rbMenuItem.
                                         addActionListener(
                                           new java.awt.event.ActionListener(
                                             ) {
                                               @java.lang.Override
                                               public void actionPerformed(java.awt.event.ActionEvent e) {
                                                   mainFrame.
                                                     getViewFilter(
                                                       ).
                                                     setEvaluation(
                                                       r);
                                                   mainFrame.
                                                     resetViewCache(
                                                       );
                                               }
                                           });
                                       viewMenu.
                                         add(
                                           rbMenuItem);
                         }
                         viewMenu.addSeparator(
                                    );
                         javax.swing.ButtonGroup ageButtonGroup =
                           new javax.swing.ButtonGroup(
                           );
                         for (final edu.umd.cs.findbugs.gui2.ViewFilter.FirstSeenFilter r
                               :
                               edu.umd.cs.findbugs.gui2.ViewFilter.FirstSeenFilter.
                                values(
                                  )) { javax.swing.JRadioButtonMenuItem rbMenuItem =
                                         new javax.swing.JRadioButtonMenuItem(
                                         r.
                                           toString(
                                             ));
                                       edu.umd.cs.findbugs.gui.AnnotatedString.
                                         localiseButton(
                                           rbMenuItem,
                                           "menu.firstSeenFilter_" +
                                           r.
                                             name(
                                               ).
                                             toLowerCase(
                                               java.util.Locale.
                                                 ENGLISH),
                                           r.
                                             toString(
                                               ),
                                           true);
                                       ageButtonGroup.
                                         add(
                                           rbMenuItem);
                                       if (r ==
                                             edu.umd.cs.findbugs.gui2.ViewFilter.FirstSeenFilter.
                                               ALL) {
                                           rbMenuItem.
                                             setSelected(
                                               true);
                                       }
                                       rbMenuItem.
                                         addActionListener(
                                           new java.awt.event.ActionListener(
                                             ) {
                                               @java.lang.Override
                                               public void actionPerformed(java.awt.event.ActionEvent e) {
                                                   mainFrame.
                                                     getViewFilter(
                                                       ).
                                                     setFirstSeen(
                                                       r);
                                                   mainFrame.
                                                     resetViewCache(
                                                       );
                                               }
                                           });
                                       viewMenu.
                                         add(
                                           rbMenuItem);
                         }
                         viewMenu.addSeparator(
                                    );
                         final edu.umd.cs.findbugs.filter.Filter suppressionFilter =
                           edu.umd.cs.findbugs.gui2.MainFrame.
                           getInstance(
                             ).
                           getProject(
                             ).
                           getSuppressionFilter(
                             );
                         java.util.Collection<edu.umd.cs.findbugs.filter.Matcher> filters =
                           suppressionFilter.
                           getChildren(
                             );
                         javax.swing.JMenuItem filterMenu =
                           new javax.swing.JMenuItem(
                           filters.
                             isEmpty(
                               )
                             ? "Add Filters..."
                             : "Filters...");
                         filterMenu.addActionListener(
                                      new java.awt.event.ActionListener(
                                        ) {
                                          @java.lang.Override
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                              edu.umd.cs.findbugs.gui2.PreferencesFrame preferenceFrame =
                                                edu.umd.cs.findbugs.gui2.PreferencesFrame.
                                                getInstance(
                                                  );
                                              preferenceFrame.
                                                showFilterPane(
                                                  );
                                              preferenceFrame.
                                                setLocationRelativeTo(
                                                  mainFrame);
                                              preferenceFrame.
                                                setVisible(
                                                  true);
                                          }
                                      });
                         viewMenu.add(filterMenu);
                         for (final edu.umd.cs.findbugs.filter.Matcher m
                               :
                               filters) {
                             javax.swing.JCheckBoxMenuItem f =
                               new javax.swing.JCheckBoxMenuItem(
                               m.
                                 toString(
                                   ),
                               suppressionFilter.
                                 isEnabled(
                                   m));
                             viewMenu.
                               add(
                                 f);
                             f.
                               addItemListener(
                                 new java.awt.event.ItemListener(
                                   ) {
                                     @java.lang.Override
                                     public void itemStateChanged(java.awt.event.ItemEvent e) {
                                         boolean enabled =
                                           e.
                                           getStateChange(
                                             ) ==
                                           java.awt.event.ItemEvent.
                                             SELECTED;
                                         suppressionFilter.
                                           setEnabled(
                                             m,
                                             enabled);
                                         edu.umd.cs.findbugs.gui2.FilterActivity.
                                           notifyListeners(
                                             enabled
                                               ? edu.umd.cs.findbugs.gui2.FilterListener.Action.
                                                   FILTERING
                                               : edu.umd.cs.findbugs.gui2.FilterListener.Action.
                                                   UNFILTERING,
                                             null);
                                     }
                                 });
                         } }
    public void addFileToRecent(java.io.File xmlFile) {
        java.util.ArrayList<java.io.File> xmlFiles =
          edu.umd.cs.findbugs.gui2.GUISaveState.
          getInstance(
            ).
          getRecentFiles(
            );
        if (!xmlFiles.
              contains(
                xmlFile)) {
            edu.umd.cs.findbugs.gui2.GUISaveState.
              getInstance(
                ).
              addRecentFile(
                xmlFile);
        }
        this.
          recentMenuCache.
          addRecentFile(
            xmlFile);
    }
    public javax.swing.JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }
    public javax.swing.JMenuItem getReconfigMenuItem() {
        return reconfigMenuItem;
    }
    public void enableRecentMenu(boolean enable) {
        recentMenu.
          setEnabled(
            enable);
    }
    public javax.swing.JMenuItem getPreferencesMenuItem() {
        return preferencesMenuItem;
    }
    void setSaveMenu(edu.umd.cs.findbugs.gui2.MainFrame mainFrame) {
        java.io.File s =
          mainFrame.
          getSaveFile(
            );
        getSaveMenuItem(
          ).
          setEnabled(
            mainFrame.
              projectChanged(
                ) &&
              s !=
              null &&
              mainFrame.
              getSaveType(
                ) !=
              edu.umd.cs.findbugs.gui2.SaveType.
                FBP_FILE &&
              s.
              exists(
                ));
    }
    public void enablePreferencesMenuItem(boolean b) {
        getPreferencesMenuItem(
          ).
          setEnabled(
            b);
        if (edu.umd.cs.findbugs.gui2.MainFrame.
              MAC_OS_X) {
            if (osxPrefsEnableMethod !=
                  null) {
                java.lang.Object[] args =
                  { b };
                try {
                    osxPrefsEnableMethod.
                      invoke(
                        osxAdapter,
                        args);
                }
                catch (java.lang.Exception e) {
                    java.lang.System.
                      err.
                      println(
                        "Exception while enabling Preferences menu: " +
                        e);
                }
            }
        }
    }
    public void initOSX() throws java.lang.ClassNotFoundException,
        java.lang.NoSuchMethodException,
        java.lang.reflect.InvocationTargetException,
        java.lang.IllegalAccessException {
        osxAdapter =
          java.lang.Class.
            forName(
              "edu.umd.cs.findbugs.gui2.OSXAdapter");
        java.lang.reflect.Method registerMethod =
          osxAdapter.
          getDeclaredMethod(
            "registerMacOSXApplication",
            edu.umd.cs.findbugs.gui2.MainFrame.class);
        if (registerMethod !=
              null) {
            registerMethod.
              invoke(
                osxAdapter,
                mainFrame);
        }
        osxPrefsEnableMethod =
          osxAdapter.
            getDeclaredMethod(
              "enablePrefs",
              boolean.class);
    }
    public javax.swing.JMenuItem getCloseProjectItem() {
        return closeProjectItem;
    }
    public void enableOrDisableItems(edu.umd.cs.findbugs.Project curProject,
                                     edu.umd.cs.findbugs.BugCollection bugCollection) {
        boolean haveBugs =
          bugCollection !=
          null;
        boolean haveCodeToAnalyze =
          curProject !=
          null &&
          !curProject.
          getFileList(
            ).
          isEmpty(
            );
        redoAnalysis.
          setEnabled(
            haveBugs &&
              haveCodeToAnalyze);
        closeProjectItem.
          setEnabled(
            haveBugs);
        saveMenuItem.
          setEnabled(
            haveBugs);
        saveAsMenuItem.
          setEnabled(
            haveBugs);
        reconfigMenuItem.
          setEnabled(
            haveBugs);
        groupByMenuItem.
          setEnabled(
            haveBugs);
    }
    static class CutAction extends javax.swing.text.TextAction {
        public CutAction() { super(edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "txt.cut",
                                       "Cut"));
        }
        @java.lang.Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            javax.swing.text.JTextComponent text =
              getTextComponent(
                evt);
            if (text ==
                  null) {
                return;
            }
            text.
              cut(
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
           "4cL/AARV3W3eFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "G+Yl8/QPXvN7b/6t57+VV+H+B7As8FXwHwAA");
    }
    private void addNavItem(final javax.swing.ActionMap map,
                            javax.swing.JMenu navMenu,
                            java.lang.String menuNameKey,
                            java.lang.String menuNameDefault,
                            java.lang.String actionName,
                            int keyEvent) {
        javax.swing.JMenuItem toggleItem =
          newJMenuItem(
            menuNameKey,
            menuNameDefault);
        toggleItem.
          addActionListener(
            mainFrame.
              getMainFrameTree(
                ).
              treeActionAdapter(
                map,
                actionName));
        edu.umd.cs.findbugs.gui2.MainFrameHelper.
          attachAcceleratorKeyNoCtrl(
            toggleItem,
            keyEvent);
        navMenu.
          add(
            toggleItem);
    }
    static class CopyAction extends javax.swing.text.TextAction {
        public CopyAction() { super(edu.umd.cs.findbugs.L10N.
                                      getLocalString(
                                        "txt.copy",
                                        "Copy"));
        }
        @java.lang.Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            javax.swing.text.JTextComponent text =
              getTextComponent(
                evt);
            if (text ==
                  null) {
                return;
            }
            text.
              copy(
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
           "8/8DzBMjwuAUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "mt99y28+9+2sDPc/3FMrkvIfAAA=");
    }
    static class PasteAction extends javax.swing.text.TextAction {
        public PasteAction() { super(edu.umd.cs.findbugs.L10N.
                                       getLocalString(
                                         "txt.paste",
                                         "Paste"));
        }
        @java.lang.Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            javax.swing.text.JTextComponent text =
              getTextComponent(
                evt);
            if (text ==
                  null) {
                return;
            }
            text.
              paste(
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
           "kQ0X/gfiwPhH4hQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "b/tevn7n4tnqB1fXh2GQm+3WIp9x/3Xv0bN/sgedk6FL2kHiN1KcJHMcGSQ7" +
           "0WE2CJLDE/MnE5ftKf3kUQh7/enwcmzb08FlF/5BP4PO+heOx5Mfg88Z8P3v" +
           "7JuJOxvYHpf3kAdn9sNHh3YQrM4Ab70N2cf2i9n6t+dYHsnbK1nzs1s1Zd03" +
           "AbeO8owTrADHjeLkGz8VAxNztCuH2EcgAwU6uTJzsBzNa0DOnZtTxv3+Nm3b" +
           "BrSsRXIUW5Oo3NR8fm4LlZ9cd+2QcT7IAD/09899/Vcf+zbQaQu6Lc3kDVR5" +
           "bMdukiXF73/how/cce07H8qjFAhRwuPqvzyVYeVeieOsobKGPmT1csaq4Ceh" +
           "ZnDgVO3kgcXQc25f0ZT50HZB/E0PMj746Xu+Pf/Edz+7zeZO2+0pYOMD1z74" +
           "4/0PX9s7lkM/dl0ae3zNNo/OiX7VgYRD6JFX2iVfQf/D55/+g996+tktVfec" +
           "zAgpcOH57F/819f3P/6dr94gGbnV8f8Pio3vbDDliK0ffriRpCJLbbAamz24" +
           "0MJ0q1CosOWl6GorpklirKoGs0G9MmrYCaPONE7ie0uU5EKvg2lYpRtjKmps" +
           "eoirTRxMFhyNZNrUQuvajcWw6pV9TGlRhGgpzZFoq9KC5cYLvy6WBgbbsAbc" +
           "gG57ONUma67uYvCkiypmQsyRSqIW1K4LmyiOY5GI6wNvjEy5BTck6OLSlotS" +
           "0Z23xxt5QMxGEVLULc4uwhOfh3VjoyB0aTBqFOixx0tMMF4NJXnk2x5CdxeL" +
           "6kylk/km6oisGNtdh5JjSavYi+msCqZniNDFxBHtOn5ZJpsdeqCSo0Gvqori" +
           "rNNrCZ2kXl4grTkl2GJkNyRhUqj0/PFQ7RASXpuX8VqRM8k2zxvjoUyr2nxo" +
           "1CtcwxFLbQXcBjnc8vW40y8lUrG/Vtj6WOm1mVgrlpY9zk039aE+QrgU3axV" +
           "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" +
           "mfaSnzLlaR9cGt761uw68c6f7kZ3d355PXqAABe5bIL5KW4yqxtveCbfa1cC" +
           "y6sfF06XsY+XwHZ1ESi7rz1ws5eG/K72qWeuPa/3Pl3aO6gnTcD1/OABaIcn" +
           "uzA/cfNLaSd/ZdkVOb78zD9dHr5t+u6fonT70CkiT6P87c4LX22+Ufu1PeiW" +
           "o5LHde8/Jxc9ebLQcQFkg0noDU+UOx44WT4tA3H+4ECsP7hx+fTmOnrT1hRO" +
           "1erOHAjwoIZxOa8oKEsgxdTw4v1tOZ3K+vny+BVKfXnjx9BFJV/EG2FWJDa2" +
           "z1vCMfMag2t06tv6zu6Ck3Z355HdHRF2z67U0UuNMLR14xVM9QbluBi649gD" +
           "wSHaN/7v3haAfd1/3bPl9qlN+9zzF8+/9nnxL/OK+tFz2O0cdN5MHOd4KetY" +
           "/2wQGqadS+z2bWEryH+ejaH7b0YSkFr2k5P+/i34B2Po3huAx2Dvg+5x6F+J" +
           "oQs76Bja005MPxdD5w6mY+gW0B6f/AgYApNZ91pwKL3X5U88+9HSBmrJXmf3" +
           "h6DZSnh15qSjH+n6np9ULTkWGx474dT5+/KhAybbF+ar2uefb3Xf83L109uX" +
           "Ac1RNpsMy3kOOrd9pDhy4kduiu0Q11nm8R/d9YXb33AYbe7aErxzrWO0PXTj" +
           "MjzlBnFeON/8/mt/9y2/+fy38lrc/wDlXcbR+B8AAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2x//H7s+rHYhNQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GDS4mS6qvRLPWQk5ILseMkdXdQOontMQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "X9hR+gs3QOnZlviEWYJzavRrUJrdHbsgb83xoc7uTeTs5QoyCsh6bkfec6+o" +
       "IGfw2JyO4Bo05jbWiQqv3Urs2RN6kmL35VL8WkDpr+8o/vVXXnR/bq/s5rzs" +
       "5kPH4dG9eMyeF1FZ8FpzpWj+kcMKKr7xRMSNx8fKfOtpXlWveHXUV9tNPCX3" +
       "fkdyALTkqjYnQLRtWzNkG88vxhxVzCl5f5asgfUxXTPq89O9idi8EkvFC7uJ" +
       "eOGVn4hfukbZs1nyse1SQZ4V4n9M5sdfrrwJgLwv7Mj8witD5p6X/7qzHPrD" +
       "a567Omc6/URsHN8Wyxnz/DWY9uks+RXg+25VtR80zDB7ObxeclI4/v7L4Npd" +
       "h1r6Bzuuff1GudY8k2uX8gqXDjly6iYMnrOgK+cD5MH0XztOzlqSbzLdKOfK" +
       "567BsS9myW9GhTuAX9mTkzOs2WdvhE+rqPCqUzdis+t9D1112357Q1z53POX" +
       "b3vN88J/zi+FHt3ivp0t3KbHtn3yitWJ90vZhQczZ9/t2wtXfk7Jv4oKD523" +
       "bQT7gewnF4Hf3lb/N0C1zqgegbF3rydr/1vAoePaUeGicqr494AJ2hUDvoP0" +
       "ZOGXQRYozF6/sgvd3bpQD50Urnwzet/1eH3U5OTt0f0Y9m68/Z8Priiff57p" +
       "/ez3qp/Z3l5VbHmzyXq5jS3cur1Im3eanTQ8dm5vh31dop/64d1fuP1Nh6ci" +
       "d28BHwv6CWxvPPuqaNPxo/xy5+afv+afvOM3nv9WHpr5/wEBwMjAkEIAAA==");
}
