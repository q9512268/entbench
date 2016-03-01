package edu.umd.cs.findbugs.gui2;
import static edu.umd.cs.findbugs.util.Util.nullSafeEquals;
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({ "SE_TRANSIENT_FIELD_NOT_RESTORED",
"SE_BAD_FIELD",
"SE_BAD_FIELD_STORE" }) 
public abstract class CloudCommentsPane extends javax.swing.JPanel {
    private static final java.lang.String MSG_REVIEW = edu.umd.cs.findbugs.L10N.
      getLocalString(
        "dlg.cloud.add_review",
        "Click to add review...");
    private static final java.lang.String MSG_REVIEW_MULTI = edu.umd.cs.findbugs.L10N.
      getLocalString(
        "dlg.cloud.add_review_multi",
        "Click to add review to {0} bugs...");
    private static final java.lang.String MSG_OVERWRITE_REVIEW =
      edu.umd.cs.findbugs.L10N.
      getLocalString(
        "dlg.cloud.ovwrt_review_multi",
        "Click to overwrite {0} reviews...");
    private javax.swing.JTextArea cloudReportPane;
    protected javax.swing.JComponent cancelLink;
    protected javax.swing.JComponent signInOutLink;
    private javax.swing.JTextArea commentBox;
    private javax.swing.JButton submitCommentButton;
    private edu.umd.cs.findbugs.gui2.WideComboBox<java.lang.String>
      designationCombo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane _cloudReportScrollPane;
    protected javax.swing.JLabel titleLabel;
    protected javax.swing.JTextArea cloudDetailsLabel;
    private javax.swing.JPanel dumbPanelSignInOutLink;
    private javax.swing.JLabel lastSavedLabel;
    private javax.swing.JPanel cards;
    private javax.swing.JButton bulkReviewButton;
    private javax.swing.JLabel warningLabel;
    protected edu.umd.cs.findbugs.BugCollection _bugCollection;
    protected edu.umd.cs.findbugs.BugInstance _bugInstance;
    private edu.umd.cs.findbugs.gui2.BugAspects _bugAspects;
    private final java.util.concurrent.Executor backgroundExecutor =
      java.util.concurrent.Executors.
      newCachedThreadPool(
        );
    private final edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener
      _cloudStatusListener =
      new edu.umd.cs.findbugs.gui2.CloudCommentsPane.MyCloudStatusListener(
      );
    private edu.umd.cs.findbugs.cloud.Cloud lastCloud = null;
    private java.awt.Font plainCommentFont;
    private java.lang.String lastCommentText = null;
    private java.util.Set<edu.umd.cs.findbugs.BugInstance>
      lastBugsEdited =
      java.util.Collections.
      emptySet(
        );
    private boolean clickedBulkReview = false;
    private void addNotInCloudCard() { final javax.swing.JPanel panel5 =
                                         new javax.swing.JPanel(
                                         );
                                       cards.add(panel5, "NOT_IN_CLOUD");
    }
    public CloudCommentsPane() { super();
                                 $$$setupUI$$$();
                                 addNotInCloudCard();
                                 cloudReportPane.setBackground(
                                                   this.
                                                     getBackground(
                                                       ));
                                 cloudReportPane.setBorder(
                                                   new javax.swing.border.EmptyBorder(
                                                     0,
                                                     0,
                                                     0,
                                                     0));
                                 _cloudReportScrollPane.
                                   setBorder(
                                     new javax.swing.border.EmptyBorder(
                                       0,
                                       0,
                                       0,
                                       0));
                                 commentBox.addMouseListener(
                                              new java.awt.event.MouseAdapter(
                                                ) {
                                                  @java.lang.Override
                                                  public void mousePressed(java.awt.event.MouseEvent e) {
                                                      commentBoxClicked(
                                                        );
                                                  }
                                              });
                                 commentBox.
                                   getDocument(
                                     ).
                                   addDocumentListener(
                                     new javax.swing.event.DocumentListener(
                                       ) {
                                         @java.lang.Override
                                         public void insertUpdate(javax.swing.event.DocumentEvent e) {
                                             changed(
                                               );
                                         }
                                         @java.lang.Override
                                         public void removeUpdate(javax.swing.event.DocumentEvent e) {
                                             changed(
                                               );
                                         }
                                         @java.lang.Override
                                         public void changedUpdate(javax.swing.event.DocumentEvent e) {
                                             changed(
                                               );
                                         }
                                         private void changed() {
                                             updateSaveButton(
                                               );
                                         }
                                     });
                                 commentBox.
                                   setBorder(
                                     new javax.swing.border.EtchedBorder(
                                       javax.swing.border.EtchedBorder.
                                         LOWERED));
                                 dumbPanelSignInOutLink.
                                   setPreferredSize(
                                     null);
                                 setLayout(
                                   new java.awt.BorderLayout(
                                     ));
                                 add(mainPanel,
                                     java.awt.BorderLayout.
                                       CENTER);
                                 designationCombo.
                                   removeAllItems(
                                     );
                                 final java.util.List<java.lang.String> userDesignationKeys =
                                   edu.umd.cs.findbugs.I18N.
                                   instance(
                                     ).
                                   getUserDesignationKeys(
                                     true);
                                 for (final java.lang.String designation
                                       :
                                       userDesignationKeys) {
                                     designationCombo.
                                       addItem(
                                         edu.umd.cs.findbugs.I18N.
                                           instance(
                                             ).
                                           getUserDesignation(
                                             designation));
                                 }
                                 designationCombo.
                                   addItem(
                                     null);
                                 designationCombo.
                                   setRenderer(
                                     new javax.swing.DefaultListCellRenderer(
                                       ) {
                                         @java.lang.Override
                                         public java.awt.Component getListCellRendererComponent(javax.swing.JList list,
                                                                                                java.lang.Object value,
                                                                                                int index,
                                                                                                boolean isSelected,
                                                                                                boolean cellHasFocus) {
                                             java.awt.Component real =
                                               super.
                                               getListCellRendererComponent(
                                                 list,
                                                 value,
                                                 index,
                                                 isSelected,
                                                 cellHasFocus);
                                             if (value ==
                                                   null) {
                                                 return real;
                                             }
                                             if (index ==
                                                   -1) {
                                                 return real;
                                             }
                                             javax.swing.JPanel panel =
                                               new javax.swing.JPanel(
                                               new java.awt.GridBagLayout(
                                                 ));
                                             panel.
                                               setBorder(
                                                 new javax.swing.border.EmptyBorder(
                                                   3,
                                                   3,
                                                   3,
                                                   3));
                                             int mask =
                                               java.awt.Toolkit.
                                               getDefaultToolkit(
                                                 ).
                                               getMenuShortcutKeyMask(
                                                 );
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
                                               anchor =
                                               java.awt.GridBagConstraints.
                                                 WEST;
                                             panel.
                                               add(
                                                 real,
                                                 gbc);
                                             gbc.
                                               weightx =
                                               0;
                                             gbc.
                                               anchor =
                                               java.awt.GridBagConstraints.
                                                 EAST;
                                             gbc.
                                               insets =
                                               new java.awt.Insets(
                                                 0,
                                                 10,
                                                 0,
                                                 0);
                                             javax.swing.JLabel label =
                                               new javax.swing.JLabel(
                                               java.awt.event.KeyEvent.
                                                 getKeyModifiersText(
                                                   mask) +
                                               "-" +
                                               (index +
                                                  1));
                                             label.
                                               setForeground(
                                                 java.awt.Color.
                                                   GRAY);
                                             panel.
                                               add(
                                                 label,
                                                 gbc);
                                             panel.
                                               setBackground(
                                                 real.
                                                   getBackground(
                                                     ));
                                             return panel;
                                         }
                                     });
                                 designationCombo.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         @java.lang.Override
                                         public void actionPerformed(java.awt.event.ActionEvent e) {
                                             if (!updatingHeader) {
                                                 int selectedIndex =
                                                   designationCombo.
                                                   getSelectedIndex(
                                                     );
                                                 if (selectedIndex >=
                                                       0) {
                                                     setDesignation(
                                                       userDesignationKeys.
                                                         get(
                                                           selectedIndex));
                                                 }
                                             }
                                         }
                                     });
                                 submitCommentButton.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         @java.lang.Override
                                         public void actionPerformed(final java.awt.event.ActionEvent e) {
                                             submitComment(
                                               CloudCommentsPane.this.
                                                 getSelectedBugs(
                                                   ));
                                         }
                                     });
                                 cloudDetailsLabel.
                                   setBackground(
                                     null);
                                 cloudDetailsLabel.
                                   setBorder(
                                     null);
                                 plainCommentFont =
                                   commentBox.
                                     getFont(
                                       ).
                                     deriveFont(
                                       java.awt.Font.
                                         PLAIN);
                                 cloudReportPane.
                                   setFont(
                                     plainCommentFont);
                                 setDefaultComment(
                                   MSG_REVIEW);
                                 commentBox.
                                   addFocusListener(
                                     new java.awt.event.FocusListener(
                                       ) {
                                         @java.lang.Override
                                         public void focusGained(java.awt.event.FocusEvent e) {
                                             commentBox.
                                               setForeground(
                                                 null);
                                             commentBox.
                                               setFont(
                                                 plainCommentFont);
                                             if (isDefaultComment(
                                                   commentBox.
                                                     getText(
                                                       ))) {
                                                 resetCommentBoxFont(
                                                   );
                                                 setCommentText(
                                                   "");
                                             }
                                         }
                                         @java.lang.Override
                                         public void focusLost(java.awt.event.FocusEvent e) {
                                             java.lang.String text =
                                               commentBox.
                                               getText(
                                                 );
                                             if (isDefaultComment(
                                                   text)) {
                                                 refresh(
                                                   );
                                             }
                                             else
                                                 if (text.
                                                       equals(
                                                         lastCommentText)) {
                                                     if (text.
                                                           trim(
                                                             ).
                                                           length(
                                                             ) ==
                                                           0) {
                                                         refresh(
                                                           );
                                                     }
                                                 }
                                                 else {
                                                     submitComment(
                                                       CloudCommentsPane.this.
                                                         getSelectedBugs(
                                                           ));
                                                     resetCommentBoxFont(
                                                       );
                                                 }
                                         }
                                     });
                                 commentBox.
                                   addKeyListener(
                                     new java.awt.event.KeyAdapter(
                                       ) {
                                         @java.lang.Override
                                         public void keyPressed(java.awt.event.KeyEvent e) {
                                             if (e.
                                                   getKeyCode(
                                                     ) ==
                                                   java.awt.event.KeyEvent.
                                                     VK_ESCAPE) {
                                                 cancelClicked(
                                                   );
                                             }
                                             else
                                                 if (e.
                                                       getKeyCode(
                                                         ) ==
                                                       java.awt.event.KeyEvent.
                                                         VK_ENTER &&
                                                       (e.
                                                          getModifiersEx(
                                                            ) &
                                                          java.awt.event.InputEvent.
                                                            CTRL_DOWN_MASK) !=
                                                       0) {
                                                     submitComment(
                                                       CloudCommentsPane.this.
                                                         getSelectedBugs(
                                                           ));
                                                 }
                                         }
                                     });
                                 submitCommentButton.
                                   setToolTipText(
                                     "Submit review [Enter]");
                                 cancelLink.
                                   setToolTipText(
                                     "Cancel [Esc]");
                                 bulkReviewButton.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         @java.lang.Override
                                         public void actionPerformed(java.awt.event.ActionEvent e) {
                                             clickedBulkReview =
                                               true;
                                             refresh(
                                               );
                                         }
                                     });
                                 setCanAddComments(
                                   false,
                                   false);
                                 setLastSaved(
                                   0);
                                 updateBugCommentsView(
                                   ); }
    private boolean isDefaultComment(java.lang.String text) {
        if (text.
              equals(
                MSG_REVIEW)) {
            return true;
        }
        try {
            new java.text.MessageFormat(
              MSG_REVIEW_MULTI).
              parse(
                text);
            return true;
        }
        catch (java.text.ParseException e) {
            
        }
        try {
            new java.text.MessageFormat(
              MSG_OVERWRITE_REVIEW).
              parse(
                text);
            return true;
        }
        catch (java.text.ParseException e) {
            
        }
        return false;
    }
    private void updateSaveButton() { boolean changed =
                                        commentWasChanged(
                                          );
                                      submitCommentButton.
                                        setEnabled(
                                          changed);
                                      submitCommentButton.
                                        setText(
                                          changed
                                            ? edu.umd.cs.findbugs.L10N.
                                            getLocalString(
                                              "dlg.save_btn",
                                              "Save")
                                            : edu.umd.cs.findbugs.L10N.
                                            getLocalString(
                                              "dlg.saved_btn",
                                              "Saved"));
                                      cancelLink.
                                        setEnabled(
                                          false);
    }
    private void setCommentText(java.lang.String t) {
        lastCommentText =
          t;
        if (!commentBox.
              getText(
                ).
              equals(
                t)) {
            commentBox.
              setText(
                t);
        }
    }
    private void resetCommentBoxFont() { commentBox.
                                           setFont(
                                             plainCommentFont);
                                         commentBox.
                                           setForeground(
                                             null);
    }
    private void setDefaultComment(java.lang.String defaultComment) {
        setCommentText(
          defaultComment);
        commentBox.
          setForeground(
            java.awt.Color.
              DARK_GRAY);
        commentBox.
          setFont(
            plainCommentFont.
              deriveFont(
                java.awt.Font.
                  ITALIC));
    }
    private void createUIComponents() { setupLinksOrButtons(
                                          );
    }
    protected abstract void setupLinksOrButtons();
    private void applyToBugs(final edu.umd.cs.findbugs.gui2.CloudCommentsPane.BugAction bugAction) {
        java.util.concurrent.Executor executor =
          backgroundExecutor;
        final java.util.concurrent.atomic.AtomicInteger shownErrorMessages =
          new java.util.concurrent.atomic.AtomicInteger(
          0);
        for (final edu.umd.cs.findbugs.BugInstance bug
              :
              getSelectedBugs(
                )) {
            executor.
              execute(
                new java.lang.Runnable(
                  ) {
                    @java.lang.Override
                    public void run() {
                        if (shownErrorMessages.
                              get(
                                ) >
                              5) {
                            return;
                        }
                        try {
                            bugAction.
                              execute(
                                bug);
                        }
                        catch (java.lang.Throwable e) {
                            if (shownErrorMessages.
                                  addAndGet(
                                    1) >
                                  5) {
                                return;
                            }
                            javax.swing.JOptionPane.
                              showMessageDialog(
                                CloudCommentsPane.this,
                                "Error while submitting cloud reviews:\n" +
                                e.
                                  getClass(
                                    ).
                                  getSimpleName(
                                    ) +
                                ": " +
                                e.
                                  getMessage(
                                    ),
                                "Review Submission Error",
                                javax.swing.JOptionPane.
                                  ERROR_MESSAGE);
                        }
                    }
                });
        }
    }
    protected void signInOrOutClicked() {
        if (_bugCollection !=
              null) {
            final edu.umd.cs.findbugs.cloud.Cloud cloud =
              _bugCollection.
              getCloud(
                );
            if ("edu.umd.cs.findbugs.cloud.doNothingCloud".
                  equals(
                    cloud.
                      getPlugin(
                        ).
                      getId(
                        ))) {
                changeClicked(
                  );
            }
            edu.umd.cs.findbugs.cloud.Cloud.SigninState state =
              cloud.
              getSigninState(
                );
            if (state ==
                  edu.umd.cs.findbugs.cloud.Cloud.SigninState.
                    SIGNED_IN) {
                backgroundExecutor.
                  execute(
                    new java.lang.Runnable(
                      ) {
                        @java.lang.Override
                        public void run() {
                            cloud.
                              signOut(
                                );
                            refresh(
                              );
                        }
                    });
                refresh(
                  );
            }
            else
                if (state.
                      couldSignIn(
                        )) {
                    backgroundExecutor.
                      execute(
                        new java.lang.Runnable(
                          ) {
                            @java.lang.Override
                            public void run() {
                                try {
                                    cloud.
                                      signIn(
                                        );
                                }
                                catch (java.lang.Exception e) {
                                    _bugCollection.
                                      getProject(
                                        ).
                                      getGuiCallback(
                                        ).
                                      showMessageDialog(
                                        "The FindBugs Cloud could not be contacted at this time.\n\n" +
                                        edu.umd.cs.findbugs.util.Util.
                                          getNetworkErrorMessage(
                                            e));
                                }
                                refresh(
                                  );
                            }
                        });
                    refresh(
                      );
                }
        }
    }
    protected void commentBoxClicked() { if (commentWasChanged(
                                               )) {
                                             return;
                                         }
                                         setCanAddComments(
                                           false,
                                           true);
                                         edu.umd.cs.findbugs.gui2.CloudCommentsPane.CommentInfo commentInfo =
                                           new edu.umd.cs.findbugs.gui2.CloudCommentsPane.CommentInfo(
                                           ).
                                           invoke(
                                             );
                                         boolean sameText =
                                           commentInfo.
                                           isSameText(
                                             );
                                         java.lang.String txt =
                                           commentInfo.
                                           getTxt(
                                             );
                                         if (!sameText) {
                                             txt =
                                               "";
                                         }
                                         if (txt ==
                                               null ||
                                               txt.
                                               trim(
                                                 ).
                                               length(
                                                 ) ==
                                               0) {
                                             txt =
                                               "";
                                         }
                                         resetCommentBoxFont(
                                           );
                                         boolean sameTextInBox =
                                           commentBox.
                                           getText(
                                             ).
                                           equals(
                                             txt);
                                         setCommentText(
                                           txt);
                                         int start =
                                           commentBox.
                                           getSelectionStart(
                                             );
                                         int end =
                                           commentBox.
                                           getSelectionEnd(
                                             );
                                         if (!commentBox.
                                               hasFocus(
                                                 ) &&
                                               (!sameTextInBox ||
                                                  start !=
                                                  0 ||
                                                  end !=
                                                  txt.
                                                  length(
                                                    ))) {
                                             commentBox.
                                               setSelectionStart(
                                                 0);
                                             commentBox.
                                               setSelectionEnd(
                                                 txt.
                                                   length(
                                                     ));
                                         }
                                         updateSaveButton(
                                           );
    }
    private boolean commentWasChanged() {
        java.lang.String text =
          commentBox.
          getText(
            );
        boolean b =
          !isDefaultComment(
             text);
        boolean b3 =
          text.
          equals(
            lastCommentText);
        return b &&
          !b3;
    }
    public boolean canSetDesignations() {
        java.util.List<edu.umd.cs.findbugs.BugInstance> bugs =
          getSelectedBugs(
            );
        if (bugs.
              isEmpty(
                )) {
            return true;
        }
        edu.umd.cs.findbugs.cloud.Cloud plugin =
          _bugCollection !=
          null
          ? _bugCollection.
          getCloud(
            )
          : null;
        if (plugin ==
              null) {
            return false;
        }
        for (edu.umd.cs.findbugs.BugInstance b
              :
              bugs) {
            if (plugin.
                  canStoreUserAnnotation(
                    b)) {
                return true;
            }
        }
        return false;
    }
    public void setDesignation(final java.lang.String designationKey) {
        final java.util.concurrent.atomic.AtomicBoolean stop =
          new java.util.concurrent.atomic.AtomicBoolean(
          false);
        applyToBugs(
          new edu.umd.cs.findbugs.gui2.CloudCommentsPane.BugAction(
            ) {
              @java.lang.Override
              public void execute(edu.umd.cs.findbugs.BugInstance bug) {
                  if (stop.
                        get(
                          )) {
                      return;
                  }
                  java.lang.String oldValue =
                    bug.
                    getUserDesignationKey(
                      );
                  java.lang.String key =
                    designationKey;
                  if (key.
                        equals(
                          oldValue)) {
                      return;
                  }
                  edu.umd.cs.findbugs.cloud.Cloud plugin =
                    _bugCollection !=
                    null
                    ? _bugCollection.
                    getCloud(
                      )
                    : null;
                  if (plugin !=
                        null &&
                        "I_WILL_FIX".
                        equals(
                          key) &&
                        plugin.
                        supportsClaims(
                          )) {
                      java.lang.String claimedBy =
                        plugin.
                        claimedBy(
                          bug);
                      if (claimedBy !=
                            null &&
                            !plugin.
                            getUser(
                              ).
                            equals(
                              claimedBy)) {
                          int result =
                            javax.swing.JOptionPane.
                            showConfirmDialog(
                              null,
                              bug.
                                getMessage(
                                  ) +
                              "\n" +
                              claimedBy +
                              " has already said they will fix this issue\n" +
                              "Do you want to also be listed as fixing this issue?\n" +
                              "If so, please coordinate with " +
                              claimedBy,
                              "Issue already claimed",
                              javax.swing.JOptionPane.
                                YES_NO_CANCEL_OPTION);
                          if (result ==
                                javax.swing.JOptionPane.
                                  CANCEL_OPTION) {
                              stop.
                                set(
                                  true);
                              return;
                          }
                          if (result !=
                                javax.swing.JOptionPane.
                                  YES_OPTION) {
                              key =
                                "MUST_FIX";
                          }
                      }
                  }
                  changeDesignationOfBugRightNow(
                    bug,
                    key);
                  refresh(
                    );
              }
          });
    }
    @java.lang.SuppressWarnings({ "UnusedDeclaration" }) 
    private void submitComment(java.util.List<edu.umd.cs.findbugs.BugInstance> selectedBugs) {
        java.lang.String comment =
          commentBox.
          getText(
            );
        if (isDefaultComment(
              comment)) {
            comment =
              "";
        }
        if (designationCombo.
              getSelectedItem(
                ) !=
              null) {
            final int index =
              designationCombo.
              getSelectedIndex(
                );
            final java.lang.String choice;
            if (index ==
                  -1) {
                choice =
                  edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                    UNCLASSIFIED.
                    name(
                      );
            }
            else {
                choice =
                  edu.umd.cs.findbugs.I18N.
                    instance(
                      ).
                    getUserDesignationKeys(
                      true).
                    get(
                      index);
            }
            setDesignation(
              choice);
        }
        final java.lang.String finalComment =
          comment;
        applyToBugs(
          new edu.umd.cs.findbugs.gui2.CloudCommentsPane.BugAction(
            ) {
              @java.lang.Override
              public void execute(edu.umd.cs.findbugs.BugInstance bug) {
                  bug.
                    setAnnotationText(
                      finalComment,
                      _bugCollection);
                  refresh(
                    );
                  setLastSaved(
                    java.lang.System.
                      currentTimeMillis(
                        ));
              }
          });
        refresh(
          );
        setCanAddComments(
          true,
          false);
        commentBox.
          requestFocus(
            );
    }
    private void setLastSaved(long date) {
        if (date >
              0) {
            lastSavedLabel.
              setText(
                "saved " +
                java.text.DateFormat.
                  getDateTimeInstance(
                    java.text.DateFormat.
                      SHORT,
                    java.text.DateFormat.
                      SHORT).
                  format(
                    new java.util.Date(
                      date)));
        }
        else {
            lastSavedLabel.
              setText(
                "");
        }
    }
    protected void cancelClicked() { setDefaultComment(
                                       lastCommentText);
                                     setCanAddComments(
                                       true,
                                       false);
    }
    private java.util.List<edu.umd.cs.findbugs.BugInstance> getSelectedBugs() {
        if (_bugInstance !=
              null) {
            return java.util.Collections.
              singletonList(
                _bugInstance);
        }
        if (_bugAspects !=
              null) {
            java.util.List<edu.umd.cs.findbugs.BugInstance> set =
              new java.util.ArrayList<edu.umd.cs.findbugs.BugInstance>(
              );
            for (edu.umd.cs.findbugs.gui2.BugLeafNode node
                  :
                  _bugAspects.
                   getMatchingBugs(
                     edu.umd.cs.findbugs.gui2.BugSet.
                       getMainBugSet(
                         ))) {
                if (!edu.umd.cs.findbugs.gui2.BugSet.
                      suppress(
                        node)) {
                    set.
                      add(
                        node.
                          getBug(
                            ));
                }
            }
            return set;
        }
        return java.util.Collections.
          emptyList(
            );
    }
    private boolean hasSelectedBugs() { return _bugInstance !=
                                          null ||
                                          _bugAspects !=
                                          null;
    }
    protected void changeClicked() { final java.util.List<edu.umd.cs.findbugs.cloud.CloudPlugin> plugins =
                                       new java.util.ArrayList<edu.umd.cs.findbugs.cloud.CloudPlugin>(
                                       );
                                     final java.util.List<java.lang.String> descriptions =
                                       new java.util.ArrayList<java.lang.String>(
                                       );
                                     java.util.List<edu.umd.cs.findbugs.cloud.CloudPlugin> clouds =
                                       new java.util.ArrayList<edu.umd.cs.findbugs.cloud.CloudPlugin>(
                                       edu.umd.cs.findbugs.DetectorFactoryCollection.
                                         instance(
                                           ).
                                         getRegisteredClouds(
                                           ).
                                         values(
                                           ));
                                     java.util.Collections.
                                       sort(
                                         clouds,
                                         new java.util.Comparator<edu.umd.cs.findbugs.cloud.CloudPlugin>(
                                           ) {
                                             @java.lang.Override
                                             public int compare(edu.umd.cs.findbugs.cloud.CloudPlugin o1,
                                                                edu.umd.cs.findbugs.cloud.CloudPlugin o2) {
                                                 return o1.
                                                   getDescription(
                                                     ).
                                                   compareToIgnoreCase(
                                                     o2.
                                                       getDescription(
                                                         ));
                                             }
                                         });
                                     for (final edu.umd.cs.findbugs.cloud.CloudPlugin plugin
                                           :
                                           clouds) {
                                         final boolean disabled =
                                           isDisabled(
                                             plugin);
                                         if (!disabled &&
                                               !plugin.
                                               isHidden(
                                                 )) {
                                             descriptions.
                                               add(
                                                 plugin.
                                                   getDescription(
                                                     ));
                                             plugins.
                                               add(
                                                 plugin);
                                         }
                                     }
                                     showCloudChooser(
                                       plugins,
                                       descriptions);
    }
    protected abstract boolean isDisabled(edu.umd.cs.findbugs.cloud.CloudPlugin plugin);
    protected abstract void showCloudChooser(java.util.List<edu.umd.cs.findbugs.cloud.CloudPlugin> plugins,
                                             java.util.List<java.lang.String> descriptions);
    protected void changeCloud(java.lang.String newCloudId) {
        final java.lang.String oldCloudId =
          _bugCollection.
          getCloud(
            ).
          getPlugin(
            ).
          getId(
            );
        if (!oldCloudId.
              equals(
                newCloudId)) {
            _bugCollection.
              getProject(
                ).
              setCloudId(
                newCloudId);
            edu.umd.cs.findbugs.gui2.MainFrame.
              getInstance(
                ).
              setProjectChanged(
                true);
            backgroundExecutor.
              execute(
                new java.lang.Runnable(
                  ) {
                    @java.lang.Override
                    public void run() {
                        _bugCollection.
                          reinitializeCloud(
                            );
                        edu.umd.cs.findbugs.cloud.Cloud cloud =
                          _bugCollection.
                          getCloud(
                            );
                        if (cloud !=
                              null) {
                            cloud.
                              waitUntilIssueDataDownloaded(
                                );
                        }
                        updateCloudListeners(
                          _bugCollection);
                        refresh(
                          );
                    }
                });
            refresh(
              );
        }
    }
    public void setBugCollection(edu.umd.cs.findbugs.BugCollection bugCollection) {
        updateCloudListeners(
          bugCollection);
        _bugCollection =
          bugCollection;
        _bugInstance =
          null;
        _bugAspects =
          null;
        refresh(
          );
    }
    public void setBugInstance(final edu.umd.cs.findbugs.BugInstance bugInstance) {
        setBugs(
          bugInstance,
          null);
    }
    public void setBugAspects(edu.umd.cs.findbugs.gui2.BugAspects aspects) {
        setBugs(
          null,
          aspects);
    }
    private void setBugs(edu.umd.cs.findbugs.BugInstance bugInstance,
                         edu.umd.cs.findbugs.gui2.BugAspects bugAspects) {
        if (_bugInstance ==
              bugInstance &&
              _bugAspects ==
              bugAspects) {
            return;
        }
        if (!canNavigateAway(
               )) {
            return;
        }
        _bugInstance =
          bugInstance;
        _bugAspects =
          bugAspects;
        refresh(
          );
    }
    public boolean canNavigateAway() { if (commentWasChanged(
                                             )) {
                                           submitComment(
                                             getSelectedBugs(
                                               ));
                                           return true;
                                       }
                                       else {
                                           return true;
                                       } }
    protected void changeDesignationOfBugRightNow(final edu.umd.cs.findbugs.BugInstance bug,
                                                  final java.lang.String designationKey) {
        java.lang.String oldValue =
          bug.
          getUserDesignationKey(
            );
        if (designationKey.
              equals(
                oldValue)) {
            return;
        }
        bug.
          setUserDesignationKey(
            designationKey,
            _bugCollection);
    }
    public void refresh() { updateBugCommentsView(
                              ); }
    public void updateCloud() { updateCloudListeners(
                                  _bugCollection);
                                refresh();
    }
    private void updateCloudListeners(edu.umd.cs.findbugs.BugCollection newBugCollection) {
        final edu.umd.cs.findbugs.cloud.Cloud newCloud =
          newBugCollection ==
          null
          ? null
          : newBugCollection.
          getCloud(
            );
        if (_bugCollection !=
              null) {
            if (lastCloud !=
                  newCloud) {
                if (lastCloud !=
                      null) {
                    lastCloud.
                      removeStatusListener(
                        _cloudStatusListener);
                }
            }
        }
        if (lastCloud !=
              newCloud &&
              newCloud !=
              null) {
            lastCloud =
              newCloud;
            newCloud.
              addStatusListener(
                _cloudStatusListener);
        }
    }
    private boolean inCloud(java.util.Collection<edu.umd.cs.findbugs.BugInstance> bugs) {
        final edu.umd.cs.findbugs.cloud.Cloud cloud =
          _bugCollection.
          getCloud(
            );
        for (edu.umd.cs.findbugs.BugInstance b
              :
              bugs) {
            if (cloud.
                  isInCloud(
                    b)) {
                return true;
            }
        }
        return false;
    }
    private void updateBugCommentsView() {
        java.util.List<edu.umd.cs.findbugs.BugInstance> bugs =
          getSelectedBugs(
            );
        if (_bugCollection ==
              null) {
            signInOutLink.
              setVisible(
                false);
            cloudDetailsLabel.
              setText(
                "");
            cloudReportPane.
              setText(
                "");
            titleLabel.
              setText(
                "<html>Reviews");
            return;
        }
        updateHeader(
          );
        final edu.umd.cs.findbugs.cloud.Cloud cloud =
          _bugCollection.
          getCloud(
            );
        final edu.umd.cs.findbugs.cloud.CloudPlugin plugin =
          cloud.
          getPlugin(
            );
        java.lang.String details =
          plugin.
          getDetails(
            );
        cloudDetailsLabel.
          setText(
            details);
        if (bugs.
              isEmpty(
                )) {
            setCanAddComments(
              false,
              false);
            return;
        }
        java.lang.String report;
        long lastSaved =
          -1;
        if (bugs.
              size(
                ) >
              1) {
            int totalReviews =
              0;
            int bugsWithReviews =
              0;
            for (edu.umd.cs.findbugs.BugInstance bug
                  :
                  bugs) {
                long newTs =
                  cloud.
                  getUserTimestamp(
                    bug);
                if (bug.
                      hasSomeUserAnnotation(
                        ) &&
                      newTs >
                      0 &&
                      (lastSaved ==
                         -1 ||
                         lastSaved <
                         newTs)) {
                    lastSaved =
                      newTs;
                }
                int reviewers =
                  cloud.
                  getNumberReviewers(
                    bug);
                if (reviewers >
                      0) {
                    bugsWithReviews++;
                }
                totalReviews +=
                  reviewers;
            }
            report =
              bugs.
                size(
                  ) +
              " bug" +
              (bugs.
                 size(
                   ) ==
                 1
                 ? ""
                 : "s") +
              " selected\n";
            report +=
              bugsWithReviews +
              " reviewed bug" +
              (bugsWithReviews ==
                 1
                 ? ""
                 : "s") +
              " / " +
              totalReviews +
              " total review" +
              (totalReviews ==
                 1
                 ? ""
                 : "s");
        }
        else {
            edu.umd.cs.findbugs.BugInstance bug =
              bugs.
              get(
                0);
            if (bug.
                  hasSomeUserAnnotation(
                    )) {
                lastSaved =
                  bug.
                    getUserTimestamp(
                      );
            }
            report =
              cloud.
                getCloudReportWithoutMe(
                  bug);
        }
        setLastSaved(
          lastSaved);
        cloudReportPane.
          setText(
            report);
        edu.umd.cs.findbugs.gui2.CloudCommentsPane.CommentInfo commentInfo =
          new edu.umd.cs.findbugs.gui2.CloudCommentsPane.CommentInfo(
          ).
          invoke(
            );
        boolean sameText =
          commentInfo.
          isSameText(
            );
        java.lang.String txt =
          commentInfo.
          getTxt(
            );
        java.awt.CardLayout cl =
          (java.awt.CardLayout)
            cards.
            getLayout(
              );
        java.util.HashSet<edu.umd.cs.findbugs.BugInstance> newBugSet =
          new java.util.HashSet<edu.umd.cs.findbugs.BugInstance>(
          bugs);
        boolean sameBugs =
          newBugSet.
          equals(
            lastBugsEdited);
        if (!sameBugs) {
            lastBugsEdited =
              newBugSet;
            clickedBulkReview =
              false;
        }
        if (!inCloud(
               bugs)) {
            cl.
              show(
                cards,
                "NOT_IN_CLOUD");
        }
        else
            if (bugs.
                  size(
                    ) >
                  1 &&
                  !clickedBulkReview) {
                warningLabel.
                  setText(
                    "<HTML>" +
                    bugs.
                      size(
                        ) +
                    " bugs are selected.<BR>Click to review them all at once.");
                cl.
                  show(
                    cards,
                    "WARNING");
            }
            else {
                cl.
                  show(
                    cards,
                    "COMMENTS");
            }
        if (!sameText) {
            txt =
              java.text.MessageFormat.
                format(
                  MSG_OVERWRITE_REVIEW,
                  bugs.
                    size(
                      ));
            setDefaultComment(
              txt);
        }
        else {
            if (txt ==
                  null ||
                  txt.
                  trim(
                    ).
                  length(
                    ) ==
                  0) {
                txt =
                  bugs.
                    size(
                      ) >
                    1
                    ? java.text.MessageFormat.
                    format(
                      MSG_REVIEW_MULTI,
                      bugs.
                        size(
                          ))
                    : MSG_REVIEW;
                setDefaultComment(
                  txt);
            }
            else {
                resetCommentBoxFont(
                  );
                setCommentText(
                  txt);
            }
        }
        setCanAddComments(
          cloud.
            canStoreUserAnnotation(
              bugs.
                get(
                  0)),
          false);
        updateSaveButton(
          );
    }
    private boolean updatingHeader = false;
    private void updateHeader() { final edu.umd.cs.findbugs.cloud.Cloud cloud =
                                    _bugCollection.
                                    getCloud(
                                      );
                                  edu.umd.cs.findbugs.cloud.CloudPlugin plugin =
                                    cloud.
                                    getPlugin(
                                      );
                                  if (hasSelectedBugs(
                                        )) {
                                      edu.umd.cs.findbugs.gui2.CloudCommentsPane.CommentInfo commentInfo =
                                        new edu.umd.cs.findbugs.gui2.CloudCommentsPane.CommentInfo(
                                        ).
                                        invoke(
                                          );
                                      boolean sameDesignation =
                                        commentInfo.
                                        isSameDesignation(
                                          );
                                      java.lang.String designation =
                                        commentInfo.
                                        getDesignation(
                                          );
                                      if (!sameDesignation) {
                                          designation =
                                            null;
                                      }
                                      updatingHeader =
                                        true;
                                      designationCombo.
                                        setSelectedIndex(
                                          edu.umd.cs.findbugs.I18N.
                                            instance(
                                              ).
                                            getUserDesignationKeys(
                                              true).
                                            indexOf(
                                              designation));
                                      updatingHeader =
                                        false;
                                      setCanAddComments(
                                        true,
                                        true);
                                  }
                                  else {
                                      setCanAddComments(
                                        false,
                                        false);
                                  }
                                  final edu.umd.cs.findbugs.cloud.Cloud.SigninState state =
                                    cloud.
                                    getSigninState(
                                      );
                                  final java.lang.String stateStr =
                                    state ==
                                    edu.umd.cs.findbugs.cloud.Cloud.SigninState.
                                      NO_SIGNIN_REQUIRED
                                    ? ""
                                    : "" +
                                  state;
                                  final java.lang.String userStr =
                                    cloud.
                                    getUser(
                                      ) ==
                                    null
                                    ? ""
                                    : cloud.
                                    getUser(
                                      );
                                  if ("edu.umd.cs.findbugs.cloud.doNothingCloud".
                                        equals(
                                          plugin.
                                            getId(
                                              ))) {
                                      titleLabel.
                                        setText(
                                          "<html><b>No cloud selected");
                                  }
                                  else {
                                      titleLabel.
                                        setText(
                                          "<html><b>Reviews - " +
                                          cloud.
                                            getCloudName(
                                              ) +
                                          "</b>" +
                                          "<br><font style=\'font-size: x-small;color:darkgray\'>" +
                                          stateStr +
                                          (userStr.
                                             length(
                                               ) >
                                             0
                                             ? " - " +
                                           userStr
                                             : ""));
                                  }
                                  switch (state) {
                                      case NO_SIGNIN_REQUIRED:
                                      case SIGNING_IN:
                                          signInOutLink.
                                            setVisible(
                                              false);
                                          break;
                                      case SIGNED_IN:
                                          setSignInOutText(
                                            "sign out");
                                          signInOutLink.
                                            setVisible(
                                              true);
                                          break;
                                      default:
                                          if (state.
                                                couldSignIn(
                                                  )) {
                                              setSignInOutText(
                                                "sign in");
                                              signInOutLink.
                                                setVisible(
                                                  true);
                                          }
                                          break;
                                  }
                                  if ("edu.umd.cs.findbugs.cloud.doNothingCloud".
                                        equals(
                                          cloud.
                                            getPlugin(
                                              ).
                                            getId(
                                              ))) {
                                      setSignInOutText(
                                        "enable cloud plugin...");
                                      signInOutLink.
                                        setVisible(
                                          true);
                                  } }
    private void setCanAddComments(boolean canClick,
                                   boolean canEnter) {
        submitCommentButton.
          setEnabled(
            canClick ||
              canEnter);
        designationCombo.
          setEnabled(
            canClick ||
              canEnter);
        commentBox.
          setEnabled(
            canClick ||
              canEnter);
    }
    protected abstract void setSignInOutText(java.lang.String buttonText);
    private void $$$setupUI$$$() { createUIComponents(
                                     );
                                   mainPanel =
                                     new javax.swing.JPanel(
                                       );
                                   mainPanel.
                                     setLayout(
                                       new java.awt.GridBagLayout(
                                         ));
                                   mainPanel.
                                     setBorder(
                                       javax.swing.BorderFactory.
                                         createTitledBorder(
                                           javax.swing.BorderFactory.
                                             createEmptyBorder(
                                               3,
                                               3,
                                               3,
                                               3),
                                           null));
                                   _cloudReportScrollPane =
                                     new javax.swing.JScrollPane(
                                       );
                                   java.awt.GridBagConstraints gbc;
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     2;
                                   gbc.gridwidth =
                                     6;
                                   gbc.weightx =
                                     1.0;
                                   gbc.weighty =
                                     1.0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   gbc.insets =
                                     new java.awt.Insets(
                                       5,
                                       5,
                                       5,
                                       5);
                                   mainPanel.
                                     add(
                                       _cloudReportScrollPane,
                                       gbc);
                                   cloudReportPane =
                                     new javax.swing.JTextArea(
                                       );
                                   cloudReportPane.
                                     setEditable(
                                       false);
                                   cloudReportPane.
                                     setLineWrap(
                                       true);
                                   cloudReportPane.
                                     setText(
                                       ("<html>\r\n  <head>\r\n    \r\n  </head>\r\n  <body>\r\n  </b" +
                                        "ody>\r\n</html>\r\n"));
                                   cloudReportPane.
                                     setWrapStyleWord(
                                       true);
                                   _cloudReportScrollPane.
                                     setViewportView(
                                       cloudReportPane);
                                   final javax.swing.JPanel panel1 =
                                     new javax.swing.JPanel(
                                     );
                                   panel1.
                                     setLayout(
                                       new java.awt.GridBagLayout(
                                         ));
                                   panel1.
                                     setBackground(
                                       new java.awt.Color(
                                         -3355444));
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     0;
                                   gbc.gridwidth =
                                     6;
                                   gbc.weightx =
                                     1.0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   mainPanel.
                                     add(
                                       panel1,
                                       gbc);
                                   panel1.
                                     setBorder(
                                       javax.swing.BorderFactory.
                                         createTitledBorder(
                                           javax.swing.BorderFactory.
                                             createLineBorder(
                                               new java.awt.Color(
                                                 -16751002)),
                                           null));
                                   titleLabel =
                                     new javax.swing.JLabel(
                                       );
                                   titleLabel.
                                     setFont(
                                       new java.awt.Font(
                                         titleLabel.
                                           getFont(
                                             ).
                                           getName(
                                             ),
                                         java.awt.Font.
                                           BOLD,
                                         14));
                                   titleLabel.
                                     setForeground(
                                       new java.awt.Color(
                                         -16777216));
                                   titleLabel.
                                     setText(
                                       "FindBugs Cloud - signed in");
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     0;
                                   gbc.gridheight =
                                     2;
                                   gbc.weightx =
                                     1.0;
                                   gbc.anchor =
                                     java.awt.GridBagConstraints.
                                       NORTHWEST;
                                   panel1.
                                     add(
                                       titleLabel,
                                       gbc);
                                   dumbPanelSignInOutLink =
                                     new javax.swing.JPanel(
                                       );
                                   dumbPanelSignInOutLink.
                                     setLayout(
                                       new java.awt.GridBagLayout(
                                         ));
                                   dumbPanelSignInOutLink.
                                     setOpaque(
                                       false);
                                   dumbPanelSignInOutLink.
                                     setPreferredSize(
                                       new java.awt.Dimension(
                                         50,
                                         10));
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     1;
                                   gbc.gridy =
                                     0;
                                   gbc.gridheight =
                                     2;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   panel1.
                                     add(
                                       dumbPanelSignInOutLink,
                                       gbc);
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     0;
                                   gbc.anchor =
                                     java.awt.GridBagConstraints.
                                       NORTHWEST;
                                   dumbPanelSignInOutLink.
                                     add(
                                       signInOutLink,
                                       gbc);
                                   final javax.swing.JPanel panel2 =
                                     new javax.swing.JPanel(
                                     );
                                   panel2.
                                     setLayout(
                                       new java.awt.GridBagLayout(
                                         ));
                                   panel2.
                                     setVisible(
                                       false);
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     1;
                                   gbc.weightx =
                                     1.0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   gbc.insets =
                                     new java.awt.Insets(
                                       5,
                                       5,
                                       5,
                                       5);
                                   mainPanel.
                                     add(
                                       panel2,
                                       gbc);
                                   cloudDetailsLabel =
                                     new javax.swing.JTextArea(
                                       );
                                   cloudDetailsLabel.
                                     setEditable(
                                       false);
                                   cloudDetailsLabel.
                                     setFont(
                                       new java.awt.Font(
                                         cloudDetailsLabel.
                                           getFont(
                                             ).
                                           getName(
                                             ),
                                         java.awt.Font.
                                           ITALIC,
                                         10));
                                   cloudDetailsLabel.
                                     setForeground(
                                       new java.awt.Color(
                                         -10066330));
                                   cloudDetailsLabel.
                                     setLineWrap(
                                       true);
                                   cloudDetailsLabel.
                                     setMaximumSize(
                                       new java.awt.Dimension(
                                         100,
                                         50));
                                   cloudDetailsLabel.
                                     setMinimumSize(
                                       new java.awt.Dimension(
                                         50,
                                         16));
                                   cloudDetailsLabel.
                                     setOpaque(
                                       false);
                                   cloudDetailsLabel.
                                     setPreferredSize(
                                       new java.awt.Dimension(
                                         100,
                                         31));
                                   cloudDetailsLabel.
                                     setText(
                                       ("Comments are stored on the FindBugs Cloud at http://findbugs" +
                                        "-cloud.appspot.com"));
                                   cloudDetailsLabel.
                                     setWrapStyleWord(
                                       true);
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     0;
                                   gbc.weightx =
                                     1.0;
                                   gbc.weighty =
                                     1.0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   panel2.
                                     add(
                                       cloudDetailsLabel,
                                       gbc);
                                   final javax.swing.JPanel panel3 =
                                     new javax.swing.JPanel(
                                     );
                                   panel3.
                                     setLayout(
                                       new java.awt.GridBagLayout(
                                         ));
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     1;
                                   gbc.gridy =
                                     3;
                                   gbc.gridwidth =
                                     5;
                                   gbc.weightx =
                                     1.0;
                                   gbc.weighty =
                                     1.0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   mainPanel.
                                     add(
                                       panel3,
                                       gbc);
                                   cards =
                                     new javax.swing.JPanel(
                                       );
                                   cards.
                                     setLayout(
                                       new java.awt.CardLayout(
                                         0,
                                         0));
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     5;
                                   gbc.gridy =
                                     4;
                                   gbc.weightx =
                                     1.0;
                                   gbc.weighty =
                                     1.0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   mainPanel.
                                     add(
                                       cards,
                                       gbc);
                                   final javax.swing.JPanel panel4 =
                                     new javax.swing.JPanel(
                                     );
                                   panel4.
                                     setLayout(
                                       new java.awt.GridBagLayout(
                                         ));
                                   cards.
                                     add(
                                       panel4,
                                       "COMMENTS");
                                   designationCombo =
                                     new edu.umd.cs.findbugs.gui2.WideComboBox<java.lang.String>(
                                       );
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     4;
                                   gbc.gridy =
                                     0;
                                   gbc.gridwidth =
                                     2;
                                   gbc.anchor =
                                     java.awt.GridBagConstraints.
                                       NORTHWEST;
                                   gbc.insets =
                                     new java.awt.Insets(
                                       5,
                                       0,
                                       0,
                                       0);
                                   panel4.
                                     add(
                                       designationCombo,
                                       gbc);
                                   final javax.swing.JScrollPane scrollPane1 =
                                     new javax.swing.JScrollPane(
                                     );
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     0;
                                   gbc.gridwidth =
                                     4;
                                   gbc.gridheight =
                                     4;
                                   gbc.weightx =
                                     1.0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       BOTH;
                                   panel4.
                                     add(
                                       scrollPane1,
                                       gbc);
                                   scrollPane1.
                                     setBorder(
                                       javax.swing.BorderFactory.
                                         createTitledBorder(
                                           javax.swing.BorderFactory.
                                             createEmptyBorder(
                                               ),
                                           null));
                                   commentBox =
                                     new javax.swing.JTextArea(
                                       );
                                   commentBox.
                                     setLineWrap(
                                       true);
                                   commentBox.
                                     setRows(
                                       5);
                                   commentBox.
                                     setText(
                                       " ");
                                   commentBox.
                                     setWrapStyleWord(
                                       true);
                                   scrollPane1.
                                     setViewportView(
                                       commentBox);
                                   submitCommentButton =
                                     new javax.swing.JButton(
                                       );
                                   submitCommentButton.
                                     setText(
                                       "Save");
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     4;
                                   gbc.gridy =
                                     1;
                                   gbc.insets =
                                     new java.awt.Insets(
                                       5,
                                       5,
                                       5,
                                       5);
                                   panel4.
                                     add(
                                       submitCommentButton,
                                       gbc);
                                   lastSavedLabel =
                                     new javax.swing.JLabel(
                                       );
                                   lastSavedLabel.
                                     setFont(
                                       new java.awt.Font(
                                         lastSavedLabel.
                                           getFont(
                                             ).
                                           getName(
                                             ),
                                         java.awt.Font.
                                           ITALIC,
                                         9));
                                   lastSavedLabel.
                                     setText(
                                       "saved at");
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     4;
                                   gbc.gridy =
                                     3;
                                   gbc.gridwidth =
                                     2;
                                   panel4.
                                     add(
                                       lastSavedLabel,
                                       gbc);
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     5;
                                   gbc.gridy =
                                     1;
                                   panel4.
                                     add(
                                       cancelLink,
                                       gbc);
                                   final javax.swing.JPanel panel5 =
                                     new javax.swing.JPanel(
                                     );
                                   panel5.
                                     setLayout(
                                       new java.awt.GridBagLayout(
                                         ));
                                   cards.
                                     add(
                                       panel5,
                                       "WARNING");
                                   warningLabel =
                                     new javax.swing.JLabel(
                                       );
                                   warningLabel.
                                     setHorizontalAlignment(
                                       0);
                                   warningLabel.
                                     setHorizontalTextPosition(
                                       0);
                                   warningLabel.
                                     setText(
                                       ("<HTML>Multiple bugs are selected.<BR>Click to review them al" +
                                        "l at once."));
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     0;
                                   gbc.gridy =
                                     0;
                                   gbc.insets =
                                     new java.awt.Insets(
                                       10,
                                       10,
                                       10,
                                       10);
                                   panel5.
                                     add(
                                       warningLabel,
                                       gbc);
                                   bulkReviewButton =
                                     new javax.swing.JButton(
                                       );
                                   bulkReviewButton.
                                     setText(
                                       "Bulk Review");
                                   gbc = new java.awt.GridBagConstraints(
                                           );
                                   gbc.gridx =
                                     1;
                                   gbc.gridy =
                                     0;
                                   gbc.fill =
                                     java.awt.GridBagConstraints.
                                       HORIZONTAL;
                                   gbc.insets =
                                     new java.awt.Insets(
                                       10,
                                       10,
                                       10,
                                       10);
                                   panel5.
                                     add(
                                       bulkReviewButton,
                                       gbc);
    }
    public javax.swing.JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
    private class MyCloudStatusListener implements edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener {
        @java.lang.Override
        public void handleIssueDataDownloadedEvent() {
            refresh(
              );
        }
        @java.lang.Override
        public void handleStateChange(final edu.umd.cs.findbugs.cloud.Cloud.SigninState oldState,
                                      final edu.umd.cs.findbugs.cloud.Cloud.SigninState state) {
            updateHeader(
              );
            refresh(
              );
        }
        public MyCloudStatusListener() { super(
                                           );
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
          ("H4sIAAAAAAAAAL06C6wkWVU1b747DDuzs+yyruyXAZ1t8qqruvqXQdzu6q7u" +
           "6q7u6k/1p0pktr5d1fX/dnXhCqwfVjFIdBchgTXRJSpZPjESTQxmjVEgEBMM" +
           "8ZcIxJiIIgkbIxpR8Vb1e6/fe/NmcKPxJX379r33nHv+99xz30vfgs76HpRz" +
           "bGO9MOxgV46D3aVR3A3WjuzvdqjigPd8WcIN3vcZMHZTfPzTl7/z3Q+oV3ag" +
           "cxx0L29ZdsAHmm35I9m3jUiWKOjydrRpyKYfQFeoJR/xcBhoBkxpfnCDgl5z" +
           "CDSArlH7JMCABBiQAGckwLXtKgD0WtkKTTyF4K3Ad6GfhE5R0DlHTMkLoMeO" +
           "InF4jzf30AwyDgCGC+nvKWAqA4496NED3jc838Lw8zn4uV95x5XfPg1d5qDL" +
           "mjVOyREBEQHYhIMumbIpyJ5fkyRZ4qB7LFmWxrKn8YaWZHRz0FVfW1h8EHry" +
           "gZDSwdCRvWzPreQuiSlvXigGtnfAnqLJhrT/66xi8AvA6/1bXjccEuk4YPCi" +
           "BgjzFF6U90HO6JolBdAjxyEOeLzWBQsA6HlTDlT7YKszFg8GoKsb3Rm8tYDH" +
           "gadZC7D0rB2CXQLowdsiTWXt8KLOL+SbAfTA8XWDzRRYdVcmiBQkgO47vizD" +
           "BLT04DEtHdLPt/pvff87rba1k9EsyaKR0n8BAD18DGgkK7InW6K8Abz0BPVB" +
           "/v7PPrsDQWDxfccWb9b87k+88uRbHn7585s1P3jCGlpYymJwU3xRuPvLb8Cv" +
           "V0+nZFxwbF9LlX+E88z8B3szN2IHeN79BxjTyd39yZdHf8K+++PyN3egiyR0" +
           "TrSN0AR2dI9om45myF5LtmSPD2SJhO6SLQnP5knoPOhTmiVvRmlF8eWAhM4Y" +
           "2dA5O/sNRKQAFKmIzoO+Zin2ft/hAzXrxw4EQZfAB6Ig6MwFKPvbfAfQU7Bq" +
           "mzLMi7ylWTY88OyUfx+WrUAAslVhBRiTEC582PdEeBFqsCyFcGhKsOhv58A4" +
           "CmzFDgHxpglg/QFvybuppTn/D3vEKZ9XVqdOARW84XgAMIDvtG1Dkr2b4nNh" +
           "vfnKJ29+cefAIfYkFEBPgj13wZ67or+7v+duuufuLXte662zsTR0hH4aAFMF" +
           "QqdOZQS8LqVoo3+gPR3EAbDg0vXxj3eeevbx08DwnNUZIPp0KXz7QI1vIweZ" +
           "xUcRmC/08odW75m+K78D7RyNuCkXYOhiCj5I4+RBPLx23NNOwnv5vd/4zqc+" +
           "+LS99bkjIXwvFNwKmbry48fl7dkiEKUnb9E/8Sj/mZufffraDnQGxAcQEwMe" +
           "2DAINw8f3+OIS9/YD48pL2cBw4rtmbyRTu3HtIuB6tmr7UhmCHdn/XuAjHvQ" +
           "pjlq9OnsvU7avm5jOKnSjnGRhd8fGTsf/cs//YdCJu79SH350Nk3loMbh6JD" +
           "iuxyFgfu2doA48kyWPc3Hxr88vPfeu+PZQYAVrzxpA2vpS2wtPSoA2L+mc+7" +
           "f/W1r774lZ2t0QTgeAwFQxPjDZPfA3+nwOe/0k/KXDqw8eyr+F54efQgvjjp" +
           "zm/e0gYijQE8MbWgaxPLtCVN0XjBkFOL/Y/Lb0I+80/vv7KxCQOM7JvUW74/" +
           "gu34D9Shd3/xHf/6cIbmlJiedFv5bZdtwue9W8w1z+PXKR3xe/7soQ9/jv8o" +
           "CMQg+PlaImfxDMrkAWUKzGeyyGUtfGwOTZtH/MOOcNTXDmUkN8UPfOXbr51+" +
           "+w9eyag9mtIc1nuPd25sTC1tHo0B+tcf9/o276tgHfZy/+1XjJe/CzByAKMI" +
           "znGf9kAwio9Yyd7qs+f/+g//6P6nvnwa2iGgi4bNSwSfORx0F7B02VdBHIud" +
           "H31yY86r1JyvZKxCtzC/MZAHsl+nAYHXbx9riDQj2brrA/9OG8Izf/tvtwgh" +
           "izInHMTH4Dn4pY88iL/tmxn81t1T6IfjWwM0yN62sOjHzX/ZefzcH+9A5zno" +
           "iriXGk55I0ydiAPpkL+fL4L08cj80dRmc47fOAhnbzgeag5tezzQbA8G0E9X" +
           "p/2LW4Vfj08BRzyL7pZ38+nvJzPAx7L2Wtr80EbqafeHgcf6WYoJIMC5whsZ" +
           "nusBsBhDvLbvo1OQcgIRX1sa5QzNfSDJzqwjZWZ3k6dtYlXaFjZUZP3Sba3h" +
           "xj6tQPt3b5FRNkj53vd3H/jSL77xa0BFHehslIoPaObQjv0wzYJ/9qXnH3rN" +
           "c19/XxaAQPQZXxf++ckUa/dOHKdNI22a+6w+mLI6tkNPlCneD3pZnJCljNs7" +
           "WubA00wQWqO9FA9++urX9I984xOb9O24GR5bLD/73M9/b/f9z+0cSprfeEve" +
           "ehhmkzhnRL92T8Ie9NiddskgiL//1NO//5tPv3dD1dWjKWAT3HA+8ef/+aXd" +
           "D339CydkHWcM+3+h2ODSi23MJ2v7fxTCyuhKHMWmQifwkm4XRcsddyoFUqOH" +
           "RqExQxfGpN/BAq2fh/sNceQ2JwWSK1fKkiCsC2HVlAKxEi74Id6ZDjUtcPMN" +
           "VuXxOhVP+kFTq9nDoOa6I8Kf6oQzzZNdnoyabWzUHuFdq0rmG8XIMatoRZFo" +
           "Fm36NIPIIS8I5XJbKJSVPhz1JIlaoN0x1WKSDrdOzM7A7w90J1BLRpW2ZmIt" +
           "wWcTruTacKWitApYYak6bVwKZNnudaWRWos9ZjqTRa/P9lSk32BFbMWu3bBF" +
           "zbhVbuWsl3OmhUtUfyavWNrk7aipTtCJLXYaPC91OrQgIzgnJ8NJpd4pRQzb" +
           "NLqzDsUTXCFkuP4sFkamMmhOa0ort6rFXSJaV9tNrJTXFYdoosV5v8/wYkGN" +
           "JjNBoIieMuYtM0k62jIuTvtwqM7qCsgTCbzPKYIFw8XAqKirZZ01bbajKiGt" +
           "hBybcximiTKSlcvPUZEoxssi6RqUjk3q7KRUypem/Um57uBLFvAdUAtlRpl0" +
           "c5bTE7WhVUF2MJz0SY2RZk2D8KbOatpLuuaq1RALYgXJ+3UTnhseOp0bPJbr" +
           "jWcIZVoNS6n4ZCm/LPbRZKQ2xHi4Wvg9E4vrw6mjLgKvT005vcQs7f54wLJ+" +
           "MnP5cl92VJo2lsBj1+2qIzQWdsuPZ7nEiVfeGqfKnOd3+mEulqeLRjdXqqhu" +
           "tSfmKK9XRaYlmmwssRZO1W2Bmw1drFIUJgzqtta+yZdId72s5geLWs0XxvbK" +
           "WirUrDoRiBpHDvVO08mzYX8oDHsFcoGaNbzWQuhpwE00r4W6jU5HXK8bGpmQ" +
           "S9F2dMJe1GyCogmdJ0Y0TzZ9j0T0bpFWShUSSxpxUF4yWmch5t1JYZxX1k2/" +
           "ZNs+6ufWSYtbNUIGR/yC08mZayJfbuPDtuqMCLWrDJZUNWFDYe6ttWBctDG3" +
           "p/WYUdHCexWX0ARhPoXnSIEI29xyJDhuX63otKwhPbTkF/KEhizM1tQAe3NU" +
           "E5FRBaaSYgGrKYFgUcOergsE0s/jWFdlesNw5iwHZcVkV2ahazYckkiIRjke" +
           "rBY8SxWCFruiGXecMG6vUeyU5sMVYoYdGCeas2kLJ2dhXeqVO2ZJQrUBDsta" +
           "zKpOfZobc+4wZ7KaEo4Uxi7pFZOvO7yKN8T8alKiUU3Byt0ZLuKsGgycCdFr" +
           "ohg9Vgy0abtF1HYcz3aCEm4SPVlZwMSgRnA9AltFRAsPenm7b+hjfabk2gPW" +
           "s4s5ypnV4rGPO91awxUtATW9JVm2i3EiwYoi4+XEXAzn7cUiGjqJrzZQxm9J" +
           "Y5HrGgOOxrhyR0tyJbXFtIC2m6U1RbPDepfCh/TMbk7WcBGvjuVavdlaBi0l" +
           "qkQabSFVsV7pJo68WFQ1FxsQ/DBnreNuo1MdUdpklvClchiiBg220FejadgM" +
           "EA/Plct1ENzzcUktB0hNd6fzpD2ra3bLWHrCtFermtWZ2+6UZpxFd1FmSa+5" +
           "bk01yOqqSAuugfTdwBl4zloZWNZqXFBaYyYWO+0GVQ9rhXmj1EWIklmhMZue" +
           "MgxaKLtoFM6tZRzmlsORu3QN1jDjpoWwbWxK9hsrjlP6fM5KTFUeSGS4ohY9" +
           "tqjOeu1GX58WxoPm0MsbI11STL+tei197pJFxhlphQoVB0zkL2teKOWIhcuy" +
           "q6GmLmzNb1lxaW0VYK8/z2FjfZxMlwpXW42qy6ih1KYg3SGnmpPPK3qN82O9" +
           "HVkwvVwyyAqWJstaczxEp/1w1SrmavJ6XWn2WlHUpvzyXI7m1iIp6zSrrwUK" +
           "cWsNVp+rSYccYGOxFcFwfb4esu1OvannlgnaKgamjPmFtssI8WporcrNBb20" +
           "laBWa7ccbjkp240aPIyqdkGwolwZFUscVURauFXn5DAglOWyXQ36jBejObIX" +
           "2mPeZOk2Ustp1JjhlHIrkjkpyNfDvG1Z8bIqSYqjVxvzYS2UvBHXCbWpRtaG" +
           "utgOSJUraKEi6YIxwGb0srkaFXP1FdFyxz0xEvrVmJUUGiZaFYoXSXHKDFbD" +
           "YG4by9ZwxlI9lVSraugrHDdic0as1NVwOnICh7KYlR3CURcISco5M8Gn85jQ" +
           "DWrlXKuHNvFFPMJnA9psOQEMY+7UGCGliISb9bzbFaZ1dIH541F9WEeK4bgu" +
           "Y9GMK3DdYUkY6TVs1EDIkc3a9aTX5UsRyHoRVeRaDNqpgBSGpssiIhKUhjoY" +
           "Vlqs9IKGsvTAG3ULuYEXs0uDHVqCOug1uyVy3anGM7FAzIK5prKEydRL3eKY" +
           "XDZsFw2RgdsJQrhBhoyBFGkSRfmavgqR5qDAUAlcBiZc7VoRvHSRiTvrDuZh" +
           "5LViqwVPyDzX1FA1KQyioFFAnWIVLRYEhbGsus8XBaLeqCgrBPMpAw1Zja9E" +
           "5FJBkCJGlSu6FNpEy9d8cIDDg/KwV4LlKG8UKbxcmiO63o08s9KlZJYYqZNi" +
           "ULfR3MJMtPW4vk4as7ke4P1hjWog1Ki4nrlUmyE6JZAi4GstLtTcUm+gDolK" +
           "4JkTZjEIsGTQg8XhwOcXCj1zbNnx820CXK6kdejLYj9qkD1vCuOBL5gw0xMR" +
           "NB8MuxNDMyNsgklMeVXOiYiX5F1/5EWJ1qiVFbk8ahT7VqJb4lqLeqrtCKM2" +
           "3o96LFlKopUuMoyPlnJzcdxdMFWFjkpJOc7DhCJWFAxncprB6FV5IcP1eAjS" +
           "MDUvdbzZtNt14EDt1sQIJ43RqjEMXH6d75BDrZDX2z5dL3As216Zy84q6JQj" +
           "fFyYN8ulXnueIFyd0RCjOWeaA1ZYzfvFdTexhUU+jCIcpfRcjURzcZFsyEQj" +
           "UVfWqLNmzYkS0UpTDj3LRmpJO9HEXLHajBbaPM87klyx4GSUq8JDkfXcJbbW" +
           "6lHsO4mYK/TXOVGGO4VFHqaCYDRje3LkynadXWgMw/d138XMRSDaJcHW4U6u" +
           "VZqJvj9szHNNmVd0uqMUzVFMzJu0XAijoWwwFsVgeSdpGlIjb1cbgizRItJr" +
           "JvRAR1pkp6M0kKUxptgms8hjakdaEvMZZgW6jfhlJ9c0ViI2KU3USm3tjqJx" +
           "CNf8psTPykql1ysMLGMk+XyXMSVrAiTbb5ljeC4X2e7ac3lUdwtElFRQdL3y" +
           "USNcLJGO3hZGNFaz192OxRkO0c+Hvt/Hqv5c8hKsVKX7wqoRt8dkjC/1EjFY" +
           "4OS6R5TBYW0ozhB14eliliNtex6UFauVtBHBB+6/AK6iUSvYc+3AQtqtdqHq" +
           "VQaUXk8iYoSJrWGt5i2d3iyR9ITNxdZaZfJcBQ3tEZKgPM53zDw5ZR1lkR+K" +
           "0aAWdG1YI1iTqXKz5nxuxmqdW5mBWWYkaTgSzSYblgZqo9gyZq7PI+aorhRJ" +
           "ej6lulah322HOTQqJz5mlmqMGpJzGS85viiVOmKEDRQHXuPlYDJPcH9BF3uy" +
           "ryURFnSHPs7UovWUEDsag7a4iOjoZjEYxBI2RgUsmCtEUqHWxcV0XC8SIMFL" +
           "rytvf3U3xnuyy/HBiwa4KKYTrVdxU4pP3hBc3M87nhbxgRwf1Amzislr7lAn" +
           "PFRLObV/Py+cVDAW07rwpmJ87YQacXqhfOh2bx/ZZfLFZ557QaI/huzs1a9m" +
           "AXRu70lqS8MOQPPE7W/NvezdZ1tU+dwz//gg8zb1qVdRNn7kGJHHUf5W76Uv" +
           "tN4s/tIOdPqgxHLLi9RRoBtHCysXPTkAMYc5Ul556EAll1MNYEAVF/dUcvHk" +
           "0u3JSs6samNLd6gNRneYyxo3gB5WeUsyZNL3Q7nBB3wDXFXSupwsNSN579Fy" +
           "dMgWp+BOH9matDVS76iRXjow0gNLurqtu9CR7HmaJN/Brm8t9WUD1lHRKUBk" +
           "V/ZEd+X/RnQ7e7a3R3Xu+9n/WFtYm/fVTMM/lyF99g4y/4W0+Sng/BuZZ5A4" +
           "6C8y+GQr0p++rUjT4Xe9KuHFAXTfie85+3w+8T9/GAJu+cAt78+bN1Pxky9c" +
           "vvD6FyZ/kT2CHLxr3kVBF5TQMA5XHA/1zzmerGiZcO7a1B+d7OuDAfTA7cgC" +
           "Bph+ZeQ/v1n+4QC694TlAdh7r3t49UcC6OJ2dQDtiEemfxVE0L3pADoN2sOT" +
           "vwaGwGTa/XXnhErmpiwbnzoUzPbsN1Ps1e9X+joAOfyCkgbA7L8D9oNVuPn/" +
           "gJvip17o9N/5Suljmxcc0eCTJMVygYLObx6TDgLeY7fFto/rXPv6d+/+9F1v" +
           "2o/Md28I3vrSIdoeOfmJpGk6Qfaokfze63/nrb/xwlezwup/AwaBX2u2IQAA");
    }
    private static interface BugAction {
        void execute(edu.umd.cs.findbugs.BugInstance bug);
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1456688264000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1456688264000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "m6Q27zrdFV1giIKCDAr2oBxvhM2gaiZphPam1oalKwKhGe0JPNeloGwhHbYR" +
           "xEpcmDQHFKoIDM3EzUEX0fRW1e5w46i6Yr1kjBa73HCwmRg4olqJ19nA05pv" +
           "FufydJVOQYiCRSuaiVWSk/WIp/A5UbL8tFOp8u3QWfPOqDOZYUPD9+aGyclr" +
           "R6/rWkkqWPPyElPHqtWhZwQ2EekxkwzLfXlG2XBdms+1wVLB21i/gzJLuDdc" +
           "MmYRlztGsxMMu0ZPFuqjkVDv6C3fKhDL1sLl15rQb/lsi2iAcYzhfKK3Blai" +
           "RGSrADcKaqWUzPFJuwf2sHLssOVBa9MPdHZTLNcWWrygdXyVqp02mSqsy7Ta" +
           "SkEpIRW+bVA1hOdgNlIbc3EkGyNySZh+t1X3Ew5tJu0+29sk2KatV6khs2K7" +
           "FTYty9Ha7HREjcZL5bRR98lW0kVnWfhKW8SkyQseh7Hz8XjZw0duwlGSVUQV" +
           "lS+QaKEb9Im4Vd5QChv1pXLCRdNSh+wmjreUjCI/VVmxm6AWL8hcUXdod1rD" +
           "ucIsNiS1JhfqalMQ0F5fL8ib8arrdRNz1iFqmOUpvVUQS6taslFUpMZXYH3Z" +
           "l4SSUjUQojfX/HkVp+WlpAwaomCZcwxplo1xZ2KXivyqnGBqgmLNuDtupaKH" +
           "lCmjb8mtPq2ZFQlG1cWAbTfQ3pgj1og18YyIroAVIWwRU40Nh2Kqc2LDR5EV" +
           "s2xX4pGgeujAsNRl3GsjrN/vKIV+VKTaaEUsV7gFvyjzlUZ5tqgUTIqmHKZM" +
           "jJqpUV9vhOqki3hVol/3mt3+zEOlpD70IzcikHG/32wvizAjrNOxS1aECcHM" +
           "OkgVXbNFu1U3GI6musispzV0U8SpWIv6REsbSiSW6Fg3Ctvdbq9SV+sDdm4P" +
           "q36pxaqxX3EVdwYjRS3odOd0C8bCeAzkgmMBFkt1jij3GsZKsTYmA0cW2xmm" +
           "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" +
           "/Rd5g3u/50Xy4BinvUsZuScjbziZ2WtG");
        java.lang.String jlc$ClassType$jl5$1 =
          ("6YHTKF3NyLXXP7LvPfxK2DzyWrB5KCNvysibX0dsHj+NzaMZeSwFjn98EfLI" +
           "U97x6m9Rgg3qwzdd1t5eMJY/9cKVux96Yfyf82zL8SXgSwx09yIyzd3bfjvP" +
           "F11fXeg5Fpe2CZb8jXrv7SH08O3EAo6WfWXi7z21bf402GDfojlYMo8ed1s/" +
           "E0KXT1qH0L58qhrOsg3barBnA3S3Eox+DlRmj+XsymEO4s074muvpLSdHN+T" +
           "t30N7EXbS/M35BdfoNn3vFz9+PbOItiWbzYZF/Ceddc2c5UzzbJAj9+W2xGv" +
           "i52nv33fL1566ihreN9W4BNf2ZHtbbfOKZGWG+ZZoM0/f+iXf+hnX/hKfm/u" +
           "/wFEceCbyzAAAA==");
    }
    private class CommentInfo {
        private java.lang.String txt;
        private boolean sameText;
        private java.lang.String designation;
        private boolean sameDesignation;
        public java.lang.String getTxt() {
            return txt;
        }
        public boolean isSameText() { return sameText;
        }
        public java.lang.String getDesignation() {
            return designation;
        }
        public boolean isSameDesignation() {
            return sameDesignation;
        }
        public edu.umd.cs.findbugs.gui2.CloudCommentsPane.CommentInfo invoke() {
            txt =
              null;
            sameText =
              true;
            designation =
              null;
            sameDesignation =
              true;
            for (edu.umd.cs.findbugs.BugInstance bug
                  :
                  getSelectedBugs(
                    )) {
                java.lang.String newText =
                  bug.
                  getAnnotationText(
                    );
                if (txt ==
                      null) {
                    txt =
                      newText;
                }
                else {
                    if (!nullSafeEquals(
                           txt,
                           newText)) {
                        sameText =
                          false;
                    }
                }
                java.lang.String newDesignation =
                  bug.
                  getUserDesignationKey(
                    );
                if (designation ==
                      null) {
                    designation =
                      newDesignation;
                }
                else {
                    if (!nullSafeEquals(
                           designation,
                           newDesignation)) {
                        sameDesignation =
                          false;
                    }
                }
            }
            return this;
        }
        public CommentInfo() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZfXBUVxW/u/kkCfmCBArkg7AwJsXdgqW1E8RCICV0Azsk" +
           "MGNQwt23d5NH3r73eO++ZJOKbbEKdpRBoECdFv2D2spAwY+OVi0Tp6NtB9Qp" +
           "thZ0Sh11RrRlLOPYOqLWc+99u+9js4txRGZyebn3nHu+fvecc29OXUMlpoGa" +
           "iUrDdFwnZnidSmPYMEmiS8Gm2Q9zg9LRIvyX7Vc33hNEpQOoehibvRI2SbdM" +
           "lIQ5gJpk1aRYlYi5kZAE44gZxCTGKKaypg6gBtnsSemKLMm0V0sQRrAVG1FU" +
           "hyk15LhFSY+9AUVNUdAkwjWJrPYvd0ZRlaTp4w75XBd5l2uFUaYcWSZFtdGd" +
           "eBRHLCorkahs0s60gW7XNWV8SNFomKRpeKeywnbBhuiKHBe0na1578aB4Vru" +
           "gllYVTXKzTM3E1NTRkkiimqc2XUKSZm70GdQURRVuogpCkUzQiMgNAJCM9Y6" +
           "VKD9TKJaqS6Nm0MzO5XqElOIooXeTXRs4JS9TYzrDDuUU9t2zgzWtmatFVbm" +
           "mPjY7ZHDR7fXfqsI1QygGlntY+pIoAQFIQPgUJKKE8NcnUiQxACqUyHYfcSQ" +
           "sSJP2JGuN+UhFVMLwp9xC5u0dGJwmY6vII5gm2FJVDOy5iU5oOzfSpIKHgJb" +
           "Gx1bhYXdbB4MrJBBMSOJAXc2S/GIrCYoavFzZG0M3Q8EwFqWInRYy4oqVjFM" +
           "oHoBEQWrQ5E+gJ46BKQlGgDQoGhe3k2Zr3UsjeAhMsgQ6aOLiSWgmsEdwVgo" +
           "avCT8Z0gSvN8UXLF59rGlfsfUNerQRQAnRNEUpj+lcDU7GPaTJLEIHAOBGNV" +
           "R/QIbnxhXxAhIG7wEQua7376+r1LmydfFjTzp6DZFN9JJDoonYhXv7qgq/2e" +
           "IqZGua6ZMgu+x3J+ymL2SmdahwzTmN2RLYYzi5Obf/KJh06St4OoogeVSppi" +
           "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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aC+zrVnn3vW3v7Yve2xbarrS3r0tHG/S34zwcq8CaxLET" +
           "x0kcO3Fib+PW7zjxK37EjqEbIG1UQypotIxt0GkSjI2Vh9gQmyZYJ8QAwZCY" +
           "0NiYBmiaNDaGRDWNTWMbO07+7/toO6pFyolzHt/5nr/znXP87Peha8IAKvie" +
           "vTZtL9rR02hnbld2orWvhzs0U2HlINS1pi2H4QjUXVDv/8SZH/7o3bOzJ6FT" +
           "EnSr7LpeJEeW54acHnr2StcY6MxBbcvWnTCCzjJzeSXDcWTZMGOF0SMMdMOh" +
           "oRF0ntljAQYswIAFeMMCXD/oBQa9Qndjp5mPkN0oXEK/AJ1goFO+mrMXQfcd" +
           "JeLLgezskmE3EgAK1+b/BSDUZnAaQPfuy76V+SKBny7AT/3am85+8irojASd" +
           "sVw+Z0cFTERgEgm60dEdRQ/CuqbpmgTd7Oq6xuuBJdtWtuFbgm4JLdOVozjQ" +
           "95WUV8a+HmzmPNDcjWouWxCrkRfsi2dYuq3t/bvGsGUTyHrbgaxbCcm8Hgh4" +
           "vQUYCwxZ1feGXL2wXC2C7jk+Yl/G813QAQw97ejRzNuf6mpXBhXQLVvb2bJr" +
           "wnwUWK4Jul7jxWCWCLrzskRzXfuyupBN/UIE3XG8H7ttAr2u2ygiHxJBrzre" +
           "bUMJWOnOY1Y6ZJ/v91//5Jvdtntyw7Omq3bO/7Vg0Lljgzjd0APdVfXtwBsf" +
           "Zt4r3/aZJ05CEOj8qmOdt30+/ZbnH33duee+uO3z6kv0GShzXY0uqB9Ubvra" +
           "Xc2H8KtyNq71vdDKjX9E8o37s7stj6Q+iLzb9inmjTt7jc9xfy6+9SP6905C" +
           "13egU6pnxw7wo5tVz/EtWw8o3dUDOdK1DnSd7mrNTXsHOg2eGcvVt7UDwwj1" +
           "qANdbW+qTnmb/0BFBiCRq+g0eLZcw9t79uVotnlOfQiCbgRf6GYIuvouaPPZ" +
           "/kbQY/DMc3RYVmXXcj2YDbxc/hDW3UgBup3BBnAmJTZDOAxU2IwtWNdiOHY0" +
           "WA0P2kA9CnzFiwHzjgPGhqzs6ju5p/n/D3OkuZxnkxMngAnuOg4ANoidtmdr" +
           "enBBfSputJ7/2IUvn9wPiF0NRVAVzLkD5txRw529OXfyOXcumvP87p8O0DZ0" +
           "4sRm2lfmfGytDmy2ANEPcPHGh/ifpx974v6rgLv5ydVA4XlX+PLw3DzAi84G" +
           "FVXgtNBz70veJvwichI6eRRnc95B1fX5cDZHx30UPH88vi5F98w7vvvDj7/3" +
           "ce8g0o4A9y4AXDwyD+D7j2s58FSgwEA/IP/wvfKnLnzm8fMnoasBKgAkjGTg" +
           "uQBkzh2f40ggP7IHirks1wCBDS9wZDtv2kOy66NZ4CUHNRvz37R5Bh4OnYO2" +
           "xVFXz1tv9fPylVt3yY12TIoN6L6B9z/w11/9p9JG3Xv4fObQisfr0SOHMCEn" +
           "dmYT/Tcf+MAo0HXQ7+/ex77n6e+/42c3DgB6PHCpCc/nJXCpfIEDav6lLy7/" +
           "5tvf+uDXTx44TQQWxVixLTXdCvlj8DkBvv+Tf3Ph8optPN/S3AWVe/dRxc9n" +
           "fvCAN4AvNoi/3IPOj13H0yzDkhVbzz32v868pvipf3ny7NYnbFCz51Kve2EC" +
           "B/U/1YDe+uU3/fu5DZkTar6+HejvoNsWNG89oFwPAnmd85G+7S/v/vUvyB8A" +
           "8AsgL7QyfYNi0EYf0MaAyEYXhU0JH2tD8+Ke8HAgHI21Q3nIBfXdX//BK4Qf" +
           "fPb5DbdHE5nDdu/J/iNbV8uLe1NA/vbjUd+WwxnoV36u/3Nn7ed+BChKgKIK" +
           "Vu9wEAAISo94yW7va05/888+d9tjX7sKOklC19uerJHyJuCg64Cn6+EMoFfq" +
           "/8yjW3dOrgXF2Y2o0EXCbx3kjs2/04DBhy6PNWSehxyE6x3/ObCVt//9f1yk" +
           "hA3KXGL5PTZegp99/53NN35vM/4g3PPR59KLYRnkbAdj0Y84/3by/lOfPwmd" +
           "lqCz6m5CKMh2nAeRBJKgcC9LBEnjkfajCc129X5kH87uOg41h6Y9DjQHywF4" +
           "znvnz9cfw5aN3l8NMOXuXWy5+zi2nIA2D49uhty3Kc/nxU/vhfJpP7BWIC43" +
           "lB+KoKuidJv7vgok1hvfyEXZ2eZmW6TKy1Je1Lf2rV7WFx45yul9gMNzu5ye" +
           "uwyn9GU4zR+JPSavDYFyRsCHruxTbGA5ABRXuykZ/Pgt3168/7sf3aZbxx3o" +
           "WGf9iad+5cc7Tz518lCS+8BFeebhMdtEd8PiKzZ85iF535Vm2Ywg//Hjj//J" +
           "7z7+ji1XtxxN2VpgR/LRv/rvr+y87ztfukSWcFrxPFuX3WN26b5EuzwA7HHP" +
           "rl3uuYxdxBdjlxs0fbsb2V2IyGOMSS+RsdcChu7dZezeyzD22Ith7EzuMMRR" +
           "5rhjzMkvyNzWqidA1FyD7mA7SP7fvPT0V+WPrwUrZbjZ0IERIIuT7T1+bp/b" +
           "6vm9tVEAGzzA0/m5jV1KaQ+9aL6Av910ELKMBzZT7/yHd3/lXQ98G/gODV2z" +
           "yiEKONmhuO7H+f7yl599+u4bnvrOOzeLPNAd/5Dyr4/mVP0rSZcXi7zYF+vO" +
           "XCzeiwNVZ+Qw6m3WYl3LJduQGBySh4/Aiu5dhCkvXtropifa5bBT3/swRcmY" +
           "NsZCOoFjeLFoGk6zUQ8WJlZP6HCqmctJsVXjmp2mgNSzcNGj+sMkQktapd8u" +
           "BVhJHxQKEj3oKkqrq/lcw2s1NXKFEmjo1xOxMBAsZORX+1EDH/rRTEL4WbHI" +
           "BZzNDFhxsGQmagHH4wI+D8tRylHSWlfcktuOC8ZKV1UUH0zHPdv3KNkaB4RG" +
           "Jq7kWhrvsGKv5Vh8jXLQIZ6ZOMN1VuspJqil0qzf8ocDT59ZyorroLyi9ezO" +
           "sGLS/qIoc6ItWpWFVG+Vy6aUNkdUtyuvfbNqNiI35HWny/QcREDCIRfUBapI" +
           "jmfrRbHCzEheLOD1sdAfa/VFMp/QASuuNETibHnklxOsMm1oFRuNybEsqhNe" +
           "IiON0vQG12aaXrCQZyESVhFzgk37E6HG90nP6XK+3tXXias0ZrHVbTd0xJWL" +
           "FawmN8pCEJu2LQqjaTcb9UqtYn/ELRaW5SxVdDru8pKDIZQ2HHOcEHum31yM" +
           "s6HVM/t1utnDxarQJfBRl5aXfLXvIL1sUJkuW/ag43lTfTTlwjLN4yMxCwgi" +
           "Ho/xCM3MbBI5ckQKiuOwcxGT2gSHGVNjGXaKw7VJ2W4kFvyOVx+SnSFrjulu" +
           "t1Xrq+7YGqb15nK8bouGyg9DnmZRmor7hfGMFHpM4uNpsxIjGkUnjlhddToV" +
           "00FJWiAG64o1rniDzOD9Trdt0gqVFpWZONWURrkX0I1Gjx/Q9amK8jDVCZqi" +
           "J6/ITKKQXmlYayXkctJxOXFd9pbCnOx5ba/RGk6CYaVVMOlytdEd2pRJDD1q" +
           "ppcWqBSUxuFcr896oTmsygPG4iemE7a0RDAB3eaoJiEmv+rXxlOGrOABZRuh" +
           "Me7rwZAb1l2u3xr784KtEmOMYuURzbQ67fqgQfUFDh52FDedTdP6rENhSWsY" +
           "y1gJqxaCIuOsNYOcjzK/SkhkH6dpwvNccTZdYUtzCaN6ZylRsVyVemZcSEt0" +
           "Ye0wKO9o8izJRk4f5RhRzKzKQDHgLj1DqnxUHnieqQu871v+sNHWpO4EcSYk" +
           "xaqczVniYjFknUV7zDU0A0NIu9ZABYGnnf56MqKXLXxJzmfj6liG06IK4iFy" +
           "OuGyTEaTRTFwJjUNcdoFVxO5IWmszYHHd8k1URjBKYuIWCekRavFpzNBkIt8" +
           "Lxs6bNFpEPSg3U6wdmvRdAbMZNFYpAS/WEu9BbcI6pZgedxinLqELk/rRRFp" +
           "VjjWF4npnKKEWcPlcbZAzAk+U3FJBGA0mwwabL2+VF1jIi8sgvLaI3ESsHEh" +
           "GBCVZFJGO1TCjkfclK9nBMEQi5k7WNeTzNFbqsO3MTvFkr7pteL+XBrVa5wm" +
           "zqUmnRZ4BhewKWqgQWM+LYZc0kKMbiK3e3gHHaXuUrXpFr2ssbxjLCWkHK4Y" +
           "Jkz5+nK+pKsM2WK61fUyIGSqQ+J0B5a5wPMJc8osuW4cjIJ6U0JNnqImQ4Od" +
           "NktLQaXWY8qpal7kxO1RQ5hXsgm/Kku95aggs4SC1vpiG0ssy2NUpEe37EV/" +
           "LOrlxMapzCJW9iixR1gxXuOFqCp1sLBIZ3ZZXqAON5CS3gykyD0iiVFtWHXm" +
           "ZJaghZBYtUqjMrGYG6TaN00mUzBpOluPUNWZZ31lHbZNn5IXYa876c2rsdcb" +
           "UP1Y6am90SSUyYZJa411VzWZpGVU8YGxYvmMLVVbekaPmImvSkqVRVqV6czp" +
           "KkWjrwoDFWyla2ZjMNfZhojhfau40sJyu0NaiDBsDtGkZTL9dTPFaqVejDEB" +
           "XqyoXDAcGk2SnvozM8UJxM5EVILrbK1ZY3srPGT5ph+C2JwU1rVKGmiLhZ+x" +
           "HJ9mdqeP+It6WRwsaEXoNWcuzaXTZjuss+hcWlHrCg7EXa+sQG30GlaFUbBq" +
           "o1eCFWo1Ghb00qoP9yMQnUFULhPtUZdLULUyqNZQgsgGeMuEDabt1yQjWRTr" +
           "/U59oNTM0YznhHS2rusJN1XJkpHUxpiBRsVwQq2rQ72Mc9UqKpP1aq2/xHqY" +
           "XtAL5WoRVxQBWxCl8qo4Mlvz1nA8LHpZq9wqrRVG4KTCQO0PzCStFPyi088o" +
           "QsbUEjOn0VhYc6GpmUSLjxqpQ4c9no58oiKFVb+7nsIlL1VFLUjlmUjoyzHB" +
           "q9WeUku7LaneFixiwVIjPTRWRdXr2eJguC6VGrUgHffKLQthmCJLajbe8ee1" +
           "eQsvSDWpMB2lVTyZDnxrDjvqqmIK9XGhW+HRmlrzWThm4mIFLtT8VooMeaSC" +
           "4BEbVCsGXlikrFHDnVpF1UlaET0qVVW4RbjFlFnHwgTPQNKC9QaVIdgkJ0NR" +
           "QnVaN0YsUkRJpVpe15cU0iwuImSt1CbddIihdYanpaXMzgJFDguVqDDmYKTi" +
           "9l1zVXNUxC768NTtdOhSeS0bKoyIUqOtj6otT3Upke4ZZtJusZmU2JZQUyiD" +
           "GPukjg70NoK7ONWmhyOxjXebS0uekphTD0udTlmRHF/UGNUCnpl66Lo8BR7X" +
           "s2rrYsmLJkOTd9ASnU0XYZXTJ2G3VRIKeK3U4AWnQLCG19SitW3OFIO1/GiY" +
           "DMZjmhW4uEZq7SicYcMVaVh4ouPhmOh047LkdmxMLoRGr8mkrh20pl5WG3WL" +
           "w0a9W2gtOUUImwyLjAf1WoHlaaxbgeUCTy+rOsm6WFIoz+lVOGCNGaEbxdkC" +
           "iE1OJC6zSkRmUXFvhMXkTOaSeVyGgdZwE9VQLAUgPQ2VmiskpSzD1yVcbzZg" +
           "LOOjEd5p2Oq4OGqSckbxzlDRfEfHkWhOBthM8oz20lxVPangDXVhUl3W1usO" +
           "3tTxRnc0iOLeCs5W085gtEZ1OV2OZyPPbI+cegGdyCKNttRmlIqSxqfYELOS" +
           "DupmKkmOHYuZw2hYpLKuEawJrghzjY6sTOxIVzhN0BpTow9cwV400HUk4MDX" +
           "XLRfXy0dv8IwcpGzTZ4JlotJR1REv4ROpmV42nJDtt2qxPpkJiN6IvTGsos3" +
           "4naYFKsrZ54UA8kwMAlp1iZKMdFqeDv15V4FUeqVKFiFjmayJb1u6n6nhMu1" +
           "7mqN+GU40yOjr6RzKizCVg0nYQuFkelqaRvxhK/rBNwkCaFbVRtpfTWuGiWK" +
           "FMUZuaSq82LZwuiGMhk1zEV9EuF2QzH6BCKSfSV0mouBPZkCnJ/izpIJGjNz" +
           "qoC4ooMpOiIkpG22um1c1sqDNE0SttTNkqJextDOSC4NCzBKTBZzO5xL0wYI" +
           "OJtPluWZiRpZSWiykdiczcpRyIplKqnwxdUUQfnJuI2W2i1Ri02+V+YWtMmJ" +
           "WjRSDaQtUfmQlE6WoSEh/Wl14lERYa4BSAvtLBKWVLOiVxNFIMuFEOukxaBe" +
           "pmqTCRuiFFLhhKY2LKswNp/jg1JCw1mvoC7iCTpWYxcr4zWQLoesrZmK1Oln" +
           "yGC5AOmRInKLQTyCa8s2o2pwCU6NmEd6blmrafZgVc4qE7BumaUKRhos2WCy" +
           "tLrqSgBHeqGyavhOu0IFXrdsM2B3MkX7aqk6qQ6lzlorokLc5ztcnDS5KZst" +
           "xwLXM2J2CXx9wRZUz7ZHi9YAc2EbGRcLLWYgDccpP2Z78WpY7C+ZWg9vIEqp" +
           "bE1EczFFdcExymZngbmBbzLqbK3KaXkipRo7Tqwss1245tM22K0Y7bbTaoOl" +
           "qdWn0kLZiLRReWl3xyui1ejHdsv1zRrfnDCGytQK1QkqR4hhxP1q0MtIR692" +
           "QnzkCGFpboleYoBAlbBVVRV7koAnjI+Lul51C4i3GkY6TAwn5lpaFhlDm7h9" +
           "MaoyA5Sb9jFjYvULdMRLcDRNbTUaGVilCGdaXXSwRGSAsxMBW+L9SiHrFGBj" +
           "HcE1flhv0LXCqoq6ZLFXISlChUlP8huk0g+6sE5gSlVCBReVFjY3KVTxrqHb" +
           "EcJwqWelXMCOG/2QCmZVIfMyV0E6KNwMw6mhpgNiEC/XXZeo6hKekLCJk/pU" +
           "MYwC4jtVOEVouATAFKMdDZ65AGtxB+9TmQJmQcDG8w1vyLekb3lpW+WbNycA" +
           "+5ek/4e9f3rFg4/9g5TNSewNV7h/OHRGC+VHVndf7jZ0c1z1wbc/9Yw2+FDx" +
           "5O7Z9iiCTu1eUh/Qya/9H778uVxvcxN8cOD6hbf/852jN84eewlXSvccY/I4" +
           "yd/rPfsl6kH1V09CV+0fv150R3100CNHD12vD/QoDtzRkaPXu/fVeluuLqDK" +
           "q+/fVev9x8+nDkx5aRu9dusKV7g3eM8V2p7OiyeB8k09GqWbexHywG/e9UKn" +
           "KIfJbSreuS/Z7XtHtQ/uSvbgyy/Zb12h7bfz4jei/Jid3z3m3RzXHUj3mz+B" +
           "dBu7nQdSPbwr3cMvv3S/f4W2j+bF70TQTcBuxw4kD9nvwz+p/fKT051dCXde" +
           "fgk/fYW2P86LTwKE29rv+KnrgZB/8BMI+eo9J0V3hURffiE/d4W2z+fFZ0H4" +
           "We7KW+jHYPtPX4pkaQTdcOgKf+/y5eEX/wYAQNs7LnrRaPtyjPqxZ85ce/sz" +
           "429s7r33X2C5joGuNWLbPnzJdOj5lB/ohrUR9LrtlZO/+flqBN1xObYi6Or8" +
           "Z8P+X2y7fy2Cbr1E9wjMvft4uPfXQcgf9I6gk+qR5m9E0Ond5gi6CpSHG78J" +
           "qkBj/vi3/iWur7Y3cemJo2vdvr1ueSF7HVoeHziyrm1eA9tbg+Lti2AX1I8/" +
           "Q/ff/Hz1Q9tLe9WWsyynci0Dnd6+P7C/jt13WWp7tE61H/rRTZ+47jV7C+5N" +
           "W4YPPO4Qb/dc+la85fjR5h47+6Pb//D1H37mW5tz/v8F0y6SEp8nAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EOgXTrCv+O1P/we2BSAbjWIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL19C7Dr6F2fz7m72Wd2N7vJbliyySZ7E7IxXFl+m20gkmXZ" +
       "siVZlmXZFpAbPS1ZT+ttk6UktATCBEJJAsxAmLYwQBuatNNMaSmdUEohPNrS" +
       "0kLoQGgHyjMzTWlogRb6SfZ5+d5zzj25l54ZffbR9/r9vu///b//9/THPle4" +
       "P/ALRc+11gvLDW+oaXhjadVuhGtPDW70yRoj+oGqtC0xCDjw7qb8pk88/id/" +
       "/kH9icPCK4TCU6LjuKEYGq4TsGrgWrGqkIXHT952LNUOwsIT5FKMRSgKDQsi" +
       "jSB8iSw8cipqWLhOHkGAAAQIQIByCBByEgpEeqXqRHY7iyE6YbAqfEPhgCy8" +
       "wpMzeGHhjWcT8URftHfJMDkDkMKD2f88IJVHTv3C88fct5xvIfzhIvSh737n" +
       "E//oWuFxofC44YwzODIAEYJMhMKjtmpLqh8giqIqQuFVjqoqY9U3RMvY5LiF" +
       "wpOBsXDEMPLV40LKXkae6ud5npTco3LGzY/k0PWP6WmGailH/92vWeICcH36" +
       "hOuWIZ69BwQfNgAwXxNl9SjKfabhKGHhDfsxjjleH4AAIOoDthrq7nFW9zki" +
       "eFF4clt3lugsoHHoG84CBL3fjUAuYeHZcxPNytoTZVNcqDfDwmv3wzFbLxDq" +
       "obwgsihh4TX7wfKUQC09u1dLp+rnc/Rf+/avd3rOYY5ZUWUrw/8giPT6vUis" +
       "qqm+6sjqNuKjbyM/Ij79k99yWCiAwK/ZC7wN80/e/fl3fPnrP/Vz2zBfepsw" +
       "Q2mpyuFN+Qelx375de0XW9cyGA96bmBklX+GeS7+zM7npdQDLe/p4xQzzxtH" +
       "np9i//X8G/+e+oeHhYeJwitk14psIEevkl3bMyzV76qO6ouhqhCFh1RHaef+" +
       "ROEB8J00HHX7dqhpgRoShfus/NUr3Px/UEQaSCIrogfAd8PR3KPvnhjq+ffU" +
       "KxQKT4Cn8Brw8IXtX/4ZFt4F6a6tQqIsOobjQozvZvwDSHVCCZStDmlAmKRo" +
       "EUCBL0OLyIBUJYIiW4Hk4MQPvC8DWXEjAN62QdyAER31RiZp3v+HPNKM5xPJ" +
       "wQGogtftKwALtJ2eaymqf1P+UIR2Pv8Pbv7C4XGD2JVQWHgbyPMGyPOGHNw4" +
       "yvNGlueNW/IsHBzkWb06y3tb06CeTNDigS589MXx1/Xf9S1vugZEzEvuA4Wc" +
       "BYXOV8ntEx1B5JpQBoJa+NT3JO/h/3rpsHB4VrdmeMGrh7PoTKYRjzXf9f02" +
       "dbt0H3/f7/3Jxz/ysnvSus4o612jvzVm1mjftF+yviuDQvPVk+Tf9rz4yZs/" +
       "+fL1w8J9QBMA7ReKQFqBYnn9fh5nGu9LR4ow43I/IKy5vi1amdeR9no41H03" +
       "OXmTV/lj+fdXgTJ+JJPm14HnPTvxzj8z36e8zH31VkSySttjkSvat4+97/+1" +
       "f/P7lby4j3Ty46d6ubEavnRKD2SJPZ63+FedyADnqyoI9xvfw3zXhz/3vq/J" +
       "BQCEeOF2GV7PXCBTWacGivlv/tzqM5/9zR/8lcMToQlBRxhJliGnxySz94WH" +
       "LyAJcnvLCR6gRyzQzjKpuT5xbFcxNEOULDWT0v/z+JvhT/7Rtz+xlQMLvDkS" +
       "oy+/PIGT91+CFr7xF975v16fJ3MgZ/3YSZmdBNsqx6dOUkZ8X1xnONL3/Pvn" +
       "vvdnxe8HahaotsDYqLm2KuRlUMgrDcr5vy13b+z5wZnzhuC08J9tX6fsjZvy" +
       "B3/lv7+S/+//4vM52rMGy+m6pkTvpa14Zc7zKUj+mf2W3hMDHYSrfor+2ies" +
       "T/05SFEAKcqglw6GPlA16RnJ2IW+/4Ff/6mffvpdv3ytcIgXHrZcUcHFvJEV" +
       "HgLSrQY60FKp99Xv2FZu8uCR2k4Lt5DfCsVr8/+eBwBfPF+/4Jm9cdJEX/tn" +
       "Q0t673/937cUQq5ZbtPN7sUXoI9937Ptr/rDPP5JE89ivz69Vf0C2+wkbvnv" +
       "2V84fNMrfuaw8IBQeELeGX68aEVZwxGAsRMcWYPAODzjf9Zw2fbSLx2rsNft" +
       "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" +
       "zmkSSksp0/RsSnNyglRhTBARnS1iQ3yD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "8Wf+8V/74Y/+Zn6R2/8Dhrt/MchzAAA=");
}
