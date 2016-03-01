package edu.umd.cs.findbugs.gui2;
@java.lang.SuppressWarnings("serial") 
public class NewProjectWizard extends edu.umd.cs.findbugs.gui2.FBDialog {
    private final javax.swing.border.EmptyBorder border = new javax.swing.border.EmptyBorder(
      5,
      5,
      5,
      5);
    private edu.umd.cs.findbugs.Project project;
    private boolean projectChanged = false;
    private boolean projectNameChanged = false;
    private final edu.umd.cs.findbugs.gui2.FBFileChooser chooser =
      new edu.umd.cs.findbugs.gui2.FBFileChooser(
      );
    private final javax.swing.filechooser.FileFilter directoryOrArchive =
      new javax.swing.filechooser.FileFilter(
      ) {
        @java.lang.Override
        public boolean accept(java.io.File f) {
            java.lang.String fileName =
              f.
              getName(
                ).
              toLowerCase(
                );
            return f.
              isDirectory(
                ) ||
              fileName.
              endsWith(
                ".jar") ||
              fileName.
              endsWith(
                ".ear") ||
              fileName.
              endsWith(
                ".war") ||
              fileName.
              endsWith(
                ".zip") ||
              fileName.
              endsWith(
                ".sar") ||
              fileName.
              endsWith(
                ".class");
        }
        @java.lang.Override
        public java.lang.String getDescription() {
            return edu.umd.cs.findbugs.L10N.
              getLocalString(
                "file.accepted_extensions",
                "Class archive files (*.class, *.[jwes]ar, *.zip)");
        }
    };
    private final javax.swing.JList<java.lang.String> analyzeList =
      new javax.swing.JList<java.lang.String>(
      );
    private final javax.swing.DefaultListModel<java.lang.String> analyzeModel =
      new javax.swing.DefaultListModel<java.lang.String>(
      );
    private final javax.swing.JTextField projectName = new javax.swing.JTextField(
      );
    private final javax.swing.JList<java.lang.String> auxList =
      new javax.swing.JList<java.lang.String>(
      );
    private final javax.swing.DefaultListModel<java.lang.String>
      auxModel =
      new javax.swing.DefaultListModel<java.lang.String>(
      );
    private final javax.swing.JList<java.lang.String> sourceList =
      new javax.swing.JList<java.lang.String>(
      );
    private final javax.swing.DefaultListModel<java.lang.String>
      sourceModel =
      new javax.swing.DefaultListModel<java.lang.String>(
      );
    private final javax.swing.JButton finishButton = new javax.swing.JButton(
      );
    private final javax.swing.JButton cancelButton = new javax.swing.JButton(
      edu.umd.cs.findbugs.L10N.
        getLocalString(
          "dlg.cancel_btn",
          "Cancel"));
    private final javax.swing.JComboBox<edu.umd.cs.findbugs.cloud.CloudPlugin>
      cloudSelector =
      new javax.swing.JComboBox<edu.umd.cs.findbugs.cloud.CloudPlugin>(
      );
    private final javax.swing.JComponent[] wizardComponents =
      new javax.swing.JComponent[4];
    private int currentPanel;
    private boolean isNewProject;
    static class CloudComboBoxRenderer extends javax.swing.plaf.basic.BasicComboBoxRenderer {
        @java.lang.Override
        public java.awt.Component getListCellRendererComponent(javax.swing.JList list,
                                                               java.lang.Object value,
                                                               int index,
                                                               boolean isSelected,
                                                               boolean cellHasFocus) {
            edu.umd.cs.findbugs.cloud.CloudPlugin plugin =
              (edu.umd.cs.findbugs.cloud.CloudPlugin)
                value;
            if (isSelected) {
                setBackground(
                  list.
                    getSelectionBackground(
                      ));
                setForeground(
                  list.
                    getSelectionForeground(
                      ));
                if (-1 <
                      index) {
                    if (plugin ==
                          null) {
                        list.
                          setToolTipText(
                            "No cloud plugin specified by project");
                    }
                    else {
                        list.
                          setToolTipText(
                            plugin.
                              getDetails(
                                ));
                    }
                }
            }
            else {
                setBackground(
                  list.
                    getBackground(
                      ));
                setForeground(
                  list.
                    getForeground(
                      ));
            }
            setFont(
              list.
                getFont(
                  ));
            setText(
              value ==
                null
                ? "<default>"
                : plugin.
                getDescription(
                  ));
            return this;
        }
        public CloudComboBoxRenderer() { super(
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
           "lkfAJ/gjG879D5EzM9mjFwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9JsvfC0vAP8Pc0oW2FsiAAA=");
    }
    public NewProjectWizard() { this(null);
                                finishButton.
                                  setEnabled(
                                    false);
    }
    public NewProjectWizard(edu.umd.cs.findbugs.Project curProject) {
        super(
          );
        project =
          curProject;
        if (project ==
              null) {
            edu.umd.cs.findbugs.gui2.ProjectSettings.
              newInstance(
                );
            project =
              new edu.umd.cs.findbugs.Project(
                );
            isNewProject =
              true;
        }
        boolean temp =
          false;
        if (curProject ==
              null) {
            setTitle(
              edu.umd.cs.findbugs.L10N.
                getLocalString(
                  "dlg.new_item",
                  "New Project"));
        }
        else {
            setTitle(
              edu.umd.cs.findbugs.L10N.
                getLocalString(
                  "dlg.reconfig",
                  "Reconfigure"));
            temp =
              true;
        }
        final boolean reconfig =
          temp;
        javax.swing.JPanel mainPanel =
          new javax.swing.JPanel(
          );
        mainPanel.
          setBorder(
            new javax.swing.border.EmptyBorder(
              5,
              5,
              5,
              5));
        mainPanel.
          setLayout(
            new javax.swing.BoxLayout(
              mainPanel,
              javax.swing.BoxLayout.
                Y_AXIS));
        wizardComponents[0] =
          createFilePanel(
            edu.umd.cs.findbugs.L10N.
              getLocalString(
                "dlg.class_jars_dirs_lbl",
                "Class archives and directories to analyze:"),
            analyzeList,
            analyzeModel,
            javax.swing.JFileChooser.
              FILES_AND_DIRECTORIES,
            directoryOrArchive,
            "Choose Class Archives and Directories to Analyze",
            false,
            "http://findbugs.sourceforge.net/manual/gui.html#d0e1087");
        wizardComponents[1] =
          createFilePanel(
            edu.umd.cs.findbugs.L10N.
              getLocalString(
                "dlg.aux_class_lbl",
                "Auxiliary class locations:"),
            auxList,
            auxModel,
            javax.swing.JFileChooser.
              FILES_AND_DIRECTORIES,
            directoryOrArchive,
            "Choose Auxilliary Class Archives and Directories",
            false,
            "http://findbugs.sourceforge.net/FAQ.html#q4");
        wizardComponents[2] =
          createFilePanel(
            edu.umd.cs.findbugs.L10N.
              getLocalString(
                "dlg.source_dirs_lbl",
                "Source directories:"),
            sourceList,
            sourceModel,
            javax.swing.JFileChooser.
              FILES_AND_DIRECTORIES,
            null,
            "Choose Source Directories",
            true,
            "http://findbugs.sourceforge.net/manual/gui.html#d0e1087");
        javax.swing.JPanel cloudPanel =
          new javax.swing.JPanel(
          new java.awt.BorderLayout(
            ));
        cloudPanel.
          add(
            new javax.swing.JLabel(
              "Store bug reviews in:"),
            java.awt.BorderLayout.
              NORTH);
        cloudPanel.
          add(
            cloudSelector,
            java.awt.BorderLayout.
              CENTER);
        wizardComponents[3] =
          cloudPanel;
        javax.swing.ListCellRenderer<edu.umd.cs.findbugs.cloud.CloudPlugin> aRenderer =
          new edu.umd.cs.findbugs.gui2.NewProjectWizard.CloudComboBoxRenderer(
          );
        cloudSelector.
          setRenderer(
            aRenderer);
        cloudSelector.
          addItem(
            null);
        java.lang.String cloudId =
          project.
          getCloudId(
            );
        for (edu.umd.cs.findbugs.cloud.CloudPlugin c
              :
              edu.umd.cs.findbugs.DetectorFactoryCollection.
               instance(
                 ).
               getRegisteredClouds(
                 ).
               values(
                 )) {
            java.lang.String fbid =
              c.
              getFindbugsPluginId(
                );
            edu.umd.cs.findbugs.Plugin plugin =
              edu.umd.cs.findbugs.Plugin.
              getByPluginId(
                fbid);
            if (plugin ==
                  null) {
                continue;
            }
            java.lang.Boolean fbPluginStatus =
              project.
              getPluginStatus(
                plugin);
            if ((!c.
                   isHidden(
                     ) ||
                   c.
                   getId(
                     ).
                   equals(
                     cloudId)) &&
                  !java.lang.Boolean.
                     FALSE.
                  equals(
                    fbPluginStatus)) {
                cloudSelector.
                  addItem(
                    c);
            }
        }
        if (cloudId !=
              null) {
            edu.umd.cs.findbugs.cloud.CloudPlugin c =
              edu.umd.cs.findbugs.DetectorFactoryCollection.
              instance(
                ).
              getRegisteredClouds(
                ).
              get(
                project.
                  getCloudId(
                    ));
            cloudSelector.
              setSelectedItem(
                c);
        }
        javax.swing.JPanel buttons =
          new javax.swing.JPanel(
          );
        buttons.
          setLayout(
            new javax.swing.BoxLayout(
              buttons,
              javax.swing.BoxLayout.
                X_AXIS));
        if (edu.umd.cs.findbugs.gui2.MainFrameHelper.
              isMacLookAndFeel(
                )) {
            buttons.
              add(
                javax.swing.Box.
                  createHorizontalStrut(
                    5));
            buttons.
              add(
                cancelButton);
            buttons.
              add(
                javax.swing.Box.
                  createHorizontalStrut(
                    5));
            buttons.
              add(
                finishButton);
        }
        else {
            buttons.
              add(
                javax.swing.Box.
                  createHorizontalStrut(
                    5));
            buttons.
              add(
                finishButton);
            buttons.
              add(
                javax.swing.Box.
                  createHorizontalStrut(
                    5));
            buttons.
              add(
                cancelButton);
        }
        finishButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                boolean
                  keepGoing =
                  false;
                private boolean displayWarningAndAskIfWeShouldContinue(java.lang.String msg,
                                                                       java.lang.String title) {
                    if (keepGoing) {
                        return true;
                    }
                    boolean result =
                      javax.swing.JOptionPane.
                      showConfirmDialog(
                        NewProjectWizard.this,
                        msg,
                        title,
                        javax.swing.JOptionPane.
                          OK_CANCEL_OPTION,
                        javax.swing.JOptionPane.
                          WARNING_MESSAGE) ==
                      javax.swing.JOptionPane.
                        OK_OPTION;
                    if (result) {
                        keepGoing =
                          true;
                    }
                    return result;
                }
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (displayWarnings(
                          )) {
                        return;
                    }
                    edu.umd.cs.findbugs.Project p;
                    java.lang.String oldCloudId =
                      null;
                    p =
                      project;
                    oldCloudId =
                      project.
                        getCloudId(
                          );
                    p.
                      setGuiCallback(
                        edu.umd.cs.findbugs.gui2.MainFrame.
                          getInstance(
                            ).
                          getGuiCallback(
                            ));
                    clearProjectSettings(
                      p);
                    for (int i =
                           0;
                         i <
                           analyzeModel.
                           getSize(
                             );
                         i++) {
                        p.
                          addFile(
                            analyzeModel.
                              get(
                                i));
                    }
                    for (int i =
                           0;
                         i <
                           auxModel.
                           getSize(
                             );
                         i++) {
                        p.
                          addAuxClasspathEntry(
                            auxModel.
                              get(
                                i));
                    }
                    for (int i =
                           0;
                         i <
                           sourceModel.
                           getSize(
                             );
                         i++) {
                        p.
                          addSourceDir(
                            sourceModel.
                              get(
                                i));
                    }
                    p.
                      setProjectName(
                        projectName.
                          getText(
                            ));
                    edu.umd.cs.findbugs.cloud.CloudPlugin cloudPlugin =
                      (edu.umd.cs.findbugs.cloud.CloudPlugin)
                        cloudSelector.
                        getSelectedItem(
                          );
                    java.lang.String newCloudId;
                    if (cloudPlugin ==
                          null ||
                          cloudSelector.
                          getSelectedIndex(
                            ) ==
                          0) {
                        newCloudId =
                          null;
                    }
                    else {
                        newCloudId =
                          cloudPlugin.
                            getId(
                              );
                    }
                    p.
                      setCloudId(
                        newCloudId);
                    edu.umd.cs.findbugs.gui2.MainFrame mainFrame =
                      edu.umd.cs.findbugs.gui2.MainFrame.
                      getInstance(
                        );
                    if (keepGoing) {
                        mainFrame.
                          setProject(
                            p);
                    }
                    if (projectChanged &&
                          (isNewProject ||
                             javax.swing.JOptionPane.
                             showConfirmDialog(
                               NewProjectWizard.this,
                               edu.umd.cs.findbugs.L10N.
                                 getLocalString(
                                   "dlg.project_settings_changed_lbl",
                                   ("Project settings have been changed.  Perform a new analysis " +
                                    "with the changed files?")),
                               edu.umd.cs.findbugs.L10N.
                                 getLocalString(
                                   "dlg.redo_analysis_question_lbl",
                                   "Redo analysis?"),
                               javax.swing.JOptionPane.
                                 YES_NO_OPTION) ==
                             javax.swing.JOptionPane.
                               YES_OPTION)) {
                        edu.umd.cs.findbugs.gui2.AnalyzingDialog.
                          show(
                            p);
                    }
                    else
                        if (!edu.umd.cs.findbugs.util.Util.
                              nullSafeEquals(
                                newCloudId,
                                oldCloudId)) {
                            edu.umd.cs.findbugs.BugCollection bugs =
                              mainFrame.
                              getBugCollection(
                                );
                            try {
                                bugs.
                                  reinitializeCloud(
                                    );
                                mainFrame.
                                  getComments(
                                    ).
                                  updateCloud(
                                    );
                            }
                            catch (java.lang.Exception e) {
                                javax.swing.JOptionPane.
                                  showMessageDialog(
                                    NewProjectWizard.this,
                                    "Error loading " +
                                    newCloudId +
                                    "\n\n" +
                                    e.
                                      getClass(
                                        ).
                                      getSimpleName(
                                        ) +
                                    ": " +
                                    e.
                                      getMessage(
                                        ),
                                    "FindBugs Cloud Error",
                                    javax.swing.JOptionPane.
                                      ERROR_MESSAGE);
                                return;
                            }
                            mainFrame.
                              getComments(
                                ).
                              updateCommentsFromLeafInformation(
                                mainFrame.
                                  getCurrentSelectedBugLeaf(
                                    ));
                        }
                    if (reconfig) {
                        mainFrame.
                          setProjectChanged(
                            true);
                    }
                    java.lang.String name =
                      p.
                      getProjectName(
                        );
                    if (name ==
                          null) {
                        name =
                          edu.umd.cs.findbugs.Project.
                            UNNAMED_PROJECT;
                        edu.umd.cs.findbugs.gui2.Debug.
                          println(
                            "PROJECT NAME IS NULL!!");
                    }
                    if (projectNameChanged) {
                        mainFrame.
                          updateTitle(
                            );
                    }
                    dispose(
                      );
                }
                private boolean displayWarnings() {
                    for (int i =
                           0;
                         i <
                           analyzeModel.
                           getSize(
                             );
                         i++) {
                        java.io.File temp =
                          new java.io.File(
                          analyzeModel.
                            get(
                              i));
                        if (!temp.
                              exists(
                                ) &&
                              directoryOrArchive.
                              accept(
                                temp)) {
                            if (!displayWarningAndAskIfWeShouldContinue(
                                   temp.
                                     getName(
                                       ) +
                                   " " +
                                   edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "dlg.invalid_txt",
                                       " is invalid."),
                                   edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "dlg.error_ttl",
                                       "Can\'t locate file"))) {
                                return true;
                            }
                        }
                    }
                    for (int i =
                           0;
                         i <
                           sourceModel.
                           getSize(
                             );
                         i++) {
                        java.io.File temp =
                          new java.io.File(
                          sourceModel.
                            get(
                              i));
                        if (!temp.
                              exists(
                                ) &&
                              directoryOrArchive.
                              accept(
                                temp)) {
                            if (!displayWarningAndAskIfWeShouldContinue(
                                   temp.
                                     getName(
                                       ) +
                                   " " +
                                   edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "dlg.invalid_txt",
                                       " is invalid."),
                                   edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "dlg.error_ttl",
                                       "Can\'t locate file"))) {
                                return true;
                            }
                        }
                    }
                    for (int i =
                           0;
                         i <
                           auxModel.
                           getSize(
                             );
                         i++) {
                        java.io.File temp =
                          new java.io.File(
                          auxModel.
                            get(
                              i));
                        if (!temp.
                              exists(
                                ) &&
                              directoryOrArchive.
                              accept(
                                temp)) {
                            if (!displayWarningAndAskIfWeShouldContinue(
                                   temp.
                                     getName(
                                       ) +
                                   " " +
                                   edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "dlg.invalid_txt",
                                       " is invalid."),
                                   edu.umd.cs.findbugs.L10N.
                                     getLocalString(
                                       "dlg.error_ttl",
                                       "Can\'t locate file"))) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            });
        if (curProject ==
              null) {
            finishButton.
              setText(
                edu.umd.cs.findbugs.L10N.
                  getLocalString(
                    "dlg.analyze_btn",
                    "Analyze"));
        }
        else {
            finishButton.
              setText(
                edu.umd.cs.findbugs.L10N.
                  getLocalString(
                    "dlg.ok_btn",
                    "OK"));
        }
        cancelButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dispose(
                      );
                }
            });
        javax.swing.JPanel south =
          new javax.swing.JPanel(
          new java.awt.BorderLayout(
            ));
        south.
          setBorder(
            new javax.swing.border.EmptyBorder(
              5,
              5,
              5,
              5));
        south.
          add(
            new javax.swing.JSeparator(
              ),
            java.awt.BorderLayout.
              NORTH);
        south.
          add(
            buttons,
            java.awt.BorderLayout.
              EAST);
        if (curProject !=
              null) {
            for (java.lang.String i
                  :
                  curProject.
                   getFileList(
                     )) {
                analyzeModel.
                  addElement(
                    i);
            }
            for (java.lang.String i
                  :
                  curProject.
                   getAuxClasspathEntryList(
                     )) {
                auxModel.
                  addElement(
                    i);
            }
            for (java.lang.String i
                  :
                  curProject.
                   getSourceDirList(
                     )) {
                sourceModel.
                  addElement(
                    i);
            }
            projectName.
              setText(
                curProject.
                  getProjectName(
                    ));
            projectName.
              addKeyListener(
                new java.awt.event.KeyAdapter(
                  ) {
                    @java.lang.Override
                    public void keyTyped(java.awt.event.KeyEvent e) {
                        projectNameChanged =
                          true;
                    }
                });
        }
        else {
            finishButton.
              setEnabled(
                false);
        }
        loadAllPanels(
          mainPanel);
        add(
          createTextFieldPanel(
            "Project name",
            projectName),
          java.awt.BorderLayout.
            NORTH);
        add(
          mainPanel,
          java.awt.BorderLayout.
            CENTER);
        add(
          south,
          java.awt.BorderLayout.
            SOUTH);
        setDefaultCloseOperation(
          DISPOSE_ON_CLOSE);
        setModal(
          true);
        setVisible(
          true);
    }
    private void clearProjectSettings(edu.umd.cs.findbugs.Project p) {
        int numOldFiles =
          p.
          getFileCount(
            );
        for (int x =
               0;
             x <
               numOldFiles;
             x++) {
            p.
              removeFile(
                0);
        }
        int numOldAuxFiles =
          p.
          getNumAuxClasspathEntries(
            );
        for (int x =
               0;
             x <
               numOldAuxFiles;
             x++) {
            p.
              removeAuxClasspathEntry(
                0);
        }
        int numOldSrc =
          p.
          getNumSourceDirs(
            );
        for (int x =
               0;
             x <
               numOldSrc;
             x++) {
            p.
              removeSourceDir(
                0);
        }
    }
    private javax.swing.JComponent createTextFieldPanel(java.lang.String label,
                                                        javax.swing.JTextField textField) {
        javax.swing.JPanel myPanel =
          new javax.swing.JPanel(
          new java.awt.BorderLayout(
            ));
        myPanel.
          add(
            new javax.swing.JLabel(
              label),
            java.awt.BorderLayout.
              NORTH);
        myPanel.
          add(
            textField,
            java.awt.BorderLayout.
              CENTER);
        myPanel.
          setBorder(
            new javax.swing.border.EmptyBorder(
              5,
              5,
              5,
              5));
        return myPanel;
    }
    private javax.swing.JPanel createFilePanel(final java.lang.String label,
                                               final javax.swing.JList<java.lang.String> list,
                                               final javax.swing.DefaultListModel<java.lang.String> listModel,
                                               final int fileSelectionMode,
                                               final javax.swing.filechooser.FileFilter filter,
                                               final java.lang.String dialogTitle,
                                               boolean wizard,
                                               final java.lang.String helpUrl) {
        javax.swing.JPanel myPanel =
          new javax.swing.JPanel(
          new java.awt.GridBagLayout(
            ));
        java.awt.GridBagConstraints gbc =
          new java.awt.GridBagConstraints(
          );
        gbc.
          gridx =
          0;
        gbc.
          gridy =
          0;
        gbc.
          gridheight =
          1;
        gbc.
          gridwidth =
          1;
        gbc.
          weightx =
          1;
        gbc.
          weighty =
          0;
        gbc.
          anchor =
          java.awt.GridBagConstraints.
            WEST;
        myPanel.
          add(
            new javax.swing.JLabel(
              label),
            gbc);
        gbc.
          gridx =
          1;
        gbc.
          gridy =
          0;
        gbc.
          gridheight =
          1;
        gbc.
          gridwidth =
          1;
        gbc.
          weightx =
          0;
        gbc.
          weighty =
          0;
        gbc.
          anchor =
          java.awt.GridBagConstraints.
            WEST;
        javax.swing.JButton button =
          new javax.swing.JButton(
          "<HTML><U>Help");
        button.
          setFont(
            button.
              getFont(
                ).
              deriveFont(
                java.awt.Font.
                  PLAIN));
        button.
          setForeground(
            java.awt.Color.
              BLUE);
        button.
          setBorderPainted(
            false);
        button.
          setCursor(
            java.awt.Cursor.
              getPredefinedCursor(
                java.awt.Cursor.
                  HAND_CURSOR));
        button.
          setContentAreaFilled(
            false);
        button.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        edu.umd.cs.findbugs.util.LaunchBrowser.
                          showDocument(
                            new java.net.URL(
                              helpUrl));
                    }
                    catch (java.net.MalformedURLException e1) {
                        throw new java.lang.IllegalStateException(
                          e1);
                    }
                }
            });
        myPanel.
          add(
            button,
            gbc);
        gbc.
          gridx =
          0;
        gbc.
          gridy =
          1;
        gbc.
          gridheight =
          3;
        gbc.
          gridwidth =
          1;
        gbc.
          weightx =
          1;
        gbc.
          weighty =
          1;
        gbc.
          fill =
          java.awt.GridBagConstraints.
            BOTH;
        myPanel.
          add(
            new javax.swing.JScrollPane(
              list),
            gbc);
        list.
          setModel(
            listModel);
        gbc.
          gridx =
          1;
        gbc.
          gridy =
          1;
        gbc.
          gridheight =
          1;
        gbc.
          gridwidth =
          1;
        gbc.
          weightx =
          0;
        gbc.
          weighty =
          0;
        gbc.
          fill =
          java.awt.GridBagConstraints.
            HORIZONTAL;
        final javax.swing.JButton addButton =
          new javax.swing.JButton(
          edu.umd.cs.findbugs.L10N.
            getLocalString(
              "dlg.add_btn",
              "Add"));
        myPanel.
          add(
            addButton,
            gbc);
        gbc.
          gridx =
          1;
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
        final javax.swing.JButton removeButton =
          new javax.swing.JButton(
          edu.umd.cs.findbugs.L10N.
            getLocalString(
              "dlg.remove_btn",
              "Remove"));
        myPanel.
          add(
            removeButton,
            gbc);
        gbc.
          gridx =
          1;
        gbc.
          gridy =
          3;
        final javax.swing.JButton wizardButton =
          new javax.swing.JButton(
          "Wizard");
        if (wizard) {
            final edu.umd.cs.findbugs.gui2.NewProjectWizard thisGUI =
              this;
            myPanel.
              add(
                wizardButton,
                gbc);
            wizardButton.
              addActionListener(
                new java.awt.event.ActionListener(
                  ) {
                    @java.lang.Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        final edu.umd.cs.findbugs.Project tempProject =
                          new edu.umd.cs.findbugs.Project(
                          );
                        for (int i =
                               0;
                             i <
                               analyzeModel.
                               getSize(
                                 );
                             i++) {
                            tempProject.
                              addFile(
                                analyzeModel.
                                  get(
                                    i));
                        }
                        for (int i =
                               0;
                             i <
                               auxModel.
                               getSize(
                                 );
                             i++) {
                            tempProject.
                              addAuxClasspathEntry(
                                auxModel.
                                  get(
                                    i));
                        }
                        java.awt.EventQueue.
                          invokeLater(
                            new java.lang.Runnable(
                              ) {
                                @java.lang.Override
                                public void run() {
                                    final edu.umd.cs.findbugs.gui2.SourceDirectoryWizard dialog =
                                      new edu.umd.cs.findbugs.gui2.SourceDirectoryWizard(
                                      new javax.swing.JFrame(
                                        ),
                                      true,
                                      tempProject,
                                      thisGUI);
                                    dialog.
                                      addWindowListener(
                                        new java.awt.event.WindowAdapter(
                                          ) {
                                            @java.lang.Override
                                            public void windowClosing(java.awt.event.WindowEvent e) {
                                                if (dialog.
                                                      discover !=
                                                      null &&
                                                      dialog.
                                                        discover.
                                                      isAlive(
                                                        )) {
                                                    dialog.
                                                      discover.
                                                      interrupt(
                                                        );
                                                }
                                            }
                                        });
                                    dialog.
                                      setVisible(
                                        true);
                                }
                            });
                    }
                });
        }
        gbc.
          insets =
          new java.awt.Insets(
            0,
            0,
            0,
            0);
        myPanel.
          add(
            javax.swing.Box.
              createGlue(
                ),
            gbc);
        myPanel.
          setBorder(
            border);
        addButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    chooser.
                      setFileSelectionMode(
                        fileSelectionMode);
                    chooser.
                      setMultiSelectionEnabled(
                        true);
                    chooser.
                      setApproveButtonText(
                        "Choose");
                    chooser.
                      setDialogTitle(
                        dialogTitle);
                    for (javax.swing.filechooser.FileFilter ff
                          :
                          chooser.
                           getChoosableFileFilters(
                             )) {
                        chooser.
                          removeChoosableFileFilter(
                            ff);
                    }
                    chooser.
                      setFileFilter(
                        filter);
                    if (chooser.
                          showOpenDialog(
                            NewProjectWizard.this) ==
                          javax.swing.JFileChooser.
                            APPROVE_OPTION) {
                        java.io.File[] selectedFiles =
                          chooser.
                          getSelectedFiles(
                            );
                        for (java.io.File selectedFile
                              :
                              selectedFiles) {
                            listModel.
                              addElement(
                                selectedFile.
                                  getAbsolutePath(
                                    ));
                        }
                        projectChanged =
                          true;
                        if (label.
                              equals(
                                edu.umd.cs.findbugs.L10N.
                                  getLocalString(
                                    "dlg.class_jars_dirs_lbl",
                                    "Class archives and directories to analyze:"))) {
                            finishButton.
                              setEnabled(
                                true);
                        }
                    }
                }
            });
        removeButton.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (list.
                          getSelectedValues(
                            ).
                          length >
                          0) {
                        projectChanged =
                          true;
                    }
                    for (java.lang.Object i
                          :
                          list.
                           getSelectedValues(
                             )) {
                        listModel.
                          removeElement(
                            i);
                    }
                }
            });
        return myPanel;
    }
    private void loadAllPanels(final javax.swing.JPanel mainPanel) {
        javax.swing.SwingUtilities.
          invokeLater(
            new java.lang.Runnable(
              ) {
                @java.lang.Override
                public void run() {
                    int numPanels =
                      wizardComponents.
                        length;
                    for (int i =
                           0;
                         i <
                           numPanels;
                         i++) {
                        mainPanel.
                          remove(
                            wizardComponents[i]);
                    }
                    for (int i =
                           0;
                         i <
                           numPanels;
                         i++) {
                        mainPanel.
                          add(
                            wizardComponents[i]);
                    }
                    validate(
                      );
                    repaint(
                      );
                }
            });
    }
    @java.lang.Override
    public void addNotify() { super.addNotify(
                                      );
                              for (javax.swing.JComponent component
                                    :
                                    wizardComponents) {
                                  setFontSizeHelper(
                                    component.
                                      getComponents(
                                        ),
                                    edu.umd.cs.findbugs.gui2.Driver.
                                      getFontSize(
                                        ));
                              }
                              pack();
                              int width =
                                super.
                                getWidth(
                                  );
                              if (width <
                                    600) {
                                  width =
                                    600;
                              }
                              setSize(new java.awt.Dimension(
                                        width,
                                        500));
                              setLocationRelativeTo(
                                edu.umd.cs.findbugs.gui2.MainFrame.
                                  getInstance(
                                    )); }
    public void setSourceDirecs(javax.swing.DefaultListModel<java.lang.String> foundModel) {
        for (int i =
               0;
             i <
               foundModel.
               size(
                 );
             i++) {
            this.
              sourceModel.
              addElement(
                foundModel.
                  getElementAt(
                    i));
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "obDW1CYNMhuItOoDbKIYpRWDt1uZk1WbQANq4xRrMovmGE3N1qYND3moMc6E" +
       "NgNJI5tk2ptqZa0N41Zt2sKzCgO0UQhcL+uZo37fF5RhQ1aGPpo2sfKoOuAN" +
       "bNLodKbSsBbibFbOaiMhyzAoEzFRaeFpW+PiNBskttOyySzrOtIcOCNKq076" +
       "CQtBvT7GzLqjLd5rShNJ8bFemUK7dOrSNbaRlWcRIbXTlmqGUZL1Ok0+mdUa" +
       "k7WNYch82BgKGIrAHCePWwQaxgCJbmPZ8ZZKZS5uSJTjGlq0Xk3aKHCwlRlW" +
       "cWuB3wXWlyAIa0v6YXM0r6fVFO8j2YKeTqAy6IJVtfKUkk0RNgf+OvFYoVvr" +
       "r7rDiImkeZmYhaikz0if4irrwXjUdyyNFxxMI1qtxirkjOpik7XtcQ2rcj2o" +
       "NluiyGo867tcS2SQhNcVoIzTZM4nJGanYSWeBQt1PFrjwooPh0gNBjZxOnen" +
       "KyM1bKwhCtQgJrYyu2rCKbaESWwBZ0ybrQ5oz+zSVkIMMMEOjfoQ76XJAGlB" +
       "2XhpacNaTe54fZOorPlmOSIbjF5uzoRqGdVqUBYN2s24yyJtbYlNhgxRxhZV" +
       "p8ZotS2GVKNUnYXVYY1pJUNWdBIMRyw9BbM7p+4Lvtka98ahuBEqTIS1idaa" +
       "nMryck1MJ1NjyKxSMxnF3VRlxXBQrgVqVO1HzTbPofVqigYbFMFsaTLKFNTK" +
       "4oY6s+asyFFJZbMcMFxNalKIUObZFc0vPIOZMiKh4Zpr+aN2p2rxFNdaLedC" +
       "Laqqsyk9TomRZY7XnOKkNElWK8pMh9T+kkxWltz36vW60vOWvbW1qJeX6aRs" +
       "sq6FJ+O2MpwlwG9KboLXa9ly4C4g2agsHbMuoLXZRu6o1eqyQZTllcPB8had" +
       "p1KmLFECheK+itdtA/wxy3VLDVq0KQQjY2GidWGcLDaQ0qugcadm1OrCVPdl" +
       "HF/RCTx31tksKmsDmB0Omdk88+tbbErNmt2OJPWTpmhMqkNU0212A+F1PSXc" +
       "JtrS5iNWHZveduHDkz6+GTCUrvBdk0DcoQOsR6LpE4OnhnPaVRwYHVCrBIYU" +
       "xRpRSqXDB6Ef9PRKINBUsO132nycinQU0wG22mbhurVC0LrCDHF/Zc0duyY2" +
       "+2kLglKI3Y7jcmhlhOiTvk2r04a9RpQJMer7JLqkKVkPsmVQhiLZCsntaDyU" +
       "xlLFE7BBXGEIqNK2xMmwvBnbtBJrbK3T5cvUhrJCVjFWXmz5ZmDqy6pGu416" +
       "vTvTMXIyrQ5Fo9oDDGoMkZbbaMXckqixTg1BLXbdSviRxov6eMObkxXM1yfA" +
       "2YWs3TA4ro8bwcgKVbimd1GkYgu01hYDs2L0ooqpuSs+2ZoCTHn1Ba45NaFN" +
       "dTyYdeVwZXTZLux6TH9elas2CKKS7tzuRqyChJAYk4gRcmOC6PZbaLzCoPmo" +
       "oVXJZea7ML9sLMoLUk4FfunbPY9CBmjWJbdISAbepJas+i6k+XbVR7EhZaiz" +
       "ysJYitCWnWOQVl25TWqxGJPNdWPd70xHGjdFo2TBNO1giaQ1TkMWFXY+1Afw" +
       "0EvWytqKebg7grpAbrmVZYibZDVAZEiCK+Vkia9hIpFlHmpty6i4sBBUwKDK" +
       "jHQnTLObVXuqp9GVoImJqlOPJAg1V5WW1e61+YT2up65VUxJEdea1ugw8gZN" +
       "uJRb0JWpPGRARKgQ4+WmH5vsTGfGiiMDqz8NGo6MCiQJKUvJn9QYoOazeoML" +
       "azNl3OL7HIXbYsZx/Awpu5ExG1Sw5sjp1lrajMGTnu6o60yBYohxtFTeGPCY" +
       "wMMxWvc3rtSaN6zlcGUt+043qIck1lrX+3RQXYzRjeNZPCRCSacHdduVCtF2" +
       "iIGq62gznOm1wMA6A8tje7NKu+X3kPVEcQZtyqIcbFbHm3JiyAIXGp5QTyxj" +
       "ACKFrVodyw6XDBy5C4Lb+kRm6hjCYFN+vkZGChzX1EWdaq+Hy7AuVbMW6lZS" +
       "tp3U+WrTIRguhIgk2lZaYUys4IXSqZeDSiP1Y5JZdlB+7Sp0Ta6qRp3zZlNl" +
       "IFPNqKFmCxhzpjFiBQHeboVKNRZXaoOn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "RgAA");
}
