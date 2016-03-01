package edu.umd.cs.findbugs.gui2;
public class CommentsArea {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.
      getLogger(
        edu.umd.cs.findbugs.gui2.CommentsArea.class.
          getName(
            ));
    private javax.swing.JButton fileBug;
    private final edu.umd.cs.findbugs.gui2.MainFrame frame;
    private edu.umd.cs.findbugs.cloud.Cloud.BugFilingStatus currentBugStatus;
    private edu.umd.cs.findbugs.gui2.CloudCommentsPaneSwing commentsPane;
    CommentsArea(edu.umd.cs.findbugs.gui2.MainFrame frame) { super(
                                                               );
                                                             this.
                                                               frame =
                                                               frame;
    }
    javax.swing.JPanel createCommentsInputPanel() { javax.swing.JPanel mainPanel =
                                                      new javax.swing.JPanel(
                                                      );
                                                    java.awt.GridBagLayout layout =
                                                      new java.awt.GridBagLayout(
                                                      );
                                                    mainPanel.
                                                      setLayout(
                                                        layout);
                                                    fileBug =
                                                      new javax.swing.JButton(
                                                        edu.umd.cs.findbugs.cloud.Cloud.BugFilingStatus.
                                                          FILE_BUG.
                                                          toString(
                                                            ));
                                                    fileBug.
                                                      setEnabled(
                                                        false);
                                                    fileBug.
                                                      setToolTipText(
                                                        "Click to file bug for this issue");
                                                    fileBug.
                                                      addActionListener(
                                                        new java.awt.event.ActionListener(
                                                          ) {
                                                            @java.lang.Override
                                                            public void actionPerformed(java.awt.event.ActionEvent e) {
                                                                if (frame.
                                                                      getCurrentSelectedBugLeaf(
                                                                        ) ==
                                                                      null) {
                                                                    return;
                                                                }
                                                                if (!canNavigateAway(
                                                                       )) {
                                                                    return;
                                                                }
                                                                edu.umd.cs.findbugs.BugInstance bug =
                                                                  frame.
                                                                  getCurrentSelectedBugLeaf(
                                                                    ).
                                                                  getBug(
                                                                    );
                                                                edu.umd.cs.findbugs.cloud.Cloud cloud1 =
                                                                  edu.umd.cs.findbugs.gui2.MainFrame.
                                                                  getInstance(
                                                                    ).
                                                                  getBugCollection(
                                                                    ).
                                                                  getCloud(
                                                                    );
                                                                if (!cloud1.
                                                                      supportsBugLinks(
                                                                        )) {
                                                                    return;
                                                                }
                                                                try {
                                                                    java.net.URL u =
                                                                      cloud1.
                                                                      getBugLink(
                                                                        bug);
                                                                    if (u !=
                                                                          null) {
                                                                        if (edu.umd.cs.findbugs.util.LaunchBrowser.
                                                                              showDocument(
                                                                                u)) {
                                                                            cloud1.
                                                                              bugFiled(
                                                                                bug,
                                                                                null);
                                                                            edu.umd.cs.findbugs.gui2.MainFrame.
                                                                              getInstance(
                                                                                ).
                                                                              syncBugInformation(
                                                                                );
                                                                        }
                                                                    }
                                                                }
                                                                catch (java.lang.Exception e1) {
                                                                    LOGGER.
                                                                      log(
                                                                        java.util.logging.Level.
                                                                          SEVERE,
                                                                        "Could not view/file bug",
                                                                        e1);
                                                                    javax.swing.JOptionPane.
                                                                      showMessageDialog(
                                                                        edu.umd.cs.findbugs.gui2.MainFrame.
                                                                          getInstance(
                                                                            ),
                                                                        "Could not view/file bug:\n" +
                                                                        e1.
                                                                          getClass(
                                                                            ).
                                                                          getSimpleName(
                                                                            ) +
                                                                        ": " +
                                                                        e1.
                                                                          getMessage(
                                                                            ));
                                                                }
                                                            }
                                                        });
                                                    java.awt.GridBagConstraints c =
                                                      new java.awt.GridBagConstraints(
                                                      );
                                                    c.
                                                      gridx =
                                                      0;
                                                    c.
                                                      gridy =
                                                      0;
                                                    c.
                                                      fill =
                                                      java.awt.GridBagConstraints.
                                                        BOTH;
                                                    c.
                                                      weightx =
                                                      1;
                                                    c.
                                                      weighty =
                                                      1;
                                                    commentsPane =
                                                      new edu.umd.cs.findbugs.gui2.CloudCommentsPaneSwing(
                                                        );
                                                    mainPanel.
                                                      add(
                                                        new javax.swing.JScrollPane(
                                                          commentsPane),
                                                        c);
                                                    c.
                                                      gridy++;
                                                    c.
                                                      weightx =
                                                      0;
                                                    c.
                                                      weighty =
                                                      0;
                                                    c.
                                                      fill =
                                                      java.awt.GridBagConstraints.
                                                        NONE;
                                                    c.
                                                      anchor =
                                                      java.awt.GridBagConstraints.
                                                        EAST;
                                                    mainPanel.
                                                      add(
                                                        fileBug,
                                                        c);
                                                    return mainPanel;
    }
    void updateCommentsFromLeafInformation(final edu.umd.cs.findbugs.gui2.BugLeafNode node) {
        if (node ==
              null) {
            return;
        }
        javax.swing.SwingUtilities.
          invokeLater(
            new java.lang.Runnable(
              ) {
                @java.lang.Override
                public void run() {
                    edu.umd.cs.findbugs.BugInstance bug =
                      node.
                      getBug(
                        );
                    edu.umd.cs.findbugs.cloud.Cloud plugin =
                      getCloud(
                        );
                    if (plugin.
                          supportsBugLinks(
                            )) {
                        currentBugStatus =
                          plugin.
                            getBugLinkStatus(
                              bug);
                        fileBug.
                          setText(
                            currentBugStatus.
                              toString(
                                ));
                        fileBug.
                          setToolTipText(
                            currentBugStatus ==
                              edu.umd.cs.findbugs.cloud.Cloud.BugFilingStatus.
                                FILE_BUG
                              ? "Click to file bug for this issue"
                              : "");
                        fileBug.
                          setEnabled(
                            currentBugStatus.
                              linkEnabled(
                                ));
                        fileBug.
                          setVisible(
                            true);
                    }
                    else {
                        fileBug.
                          setVisible(
                            false);
                    }
                    commentsPane.
                      setBugInstance(
                        node.
                          getBug(
                            ));
                }
            });
    }
    private edu.umd.cs.findbugs.SortedBugCollection getBugCollection() {
        return (edu.umd.cs.findbugs.SortedBugCollection)
                 edu.umd.cs.findbugs.gui2.MainFrame.
                 getInstance(
                   ).
                 getBugCollection(
                   );
    }
    void updateCommentsFromNonLeafInformation(final edu.umd.cs.findbugs.gui2.BugAspects theAspects) {
        javax.swing.SwingUtilities.
          invokeLater(
            new java.lang.Runnable(
              ) {
                @java.lang.Override
                public void run() {
                    updateCommentsFromNonLeafInformationFromSwingThread(
                      theAspects);
                }
            });
    }
    public boolean canNavigateAway() { return commentsPane.
                                         canNavigateAway(
                                           );
    }
    protected void updateCommentsFromNonLeafInformationFromSwingThread(edu.umd.cs.findbugs.gui2.BugAspects theAspects) {
        commentsPane.
          setBugAspects(
            theAspects);
        fileBug.
          setEnabled(
            false);
    }
    public boolean hasFocus() { return commentsPane.
                                  hasFocus(
                                    ); }
    @javax.annotation.CheckForNull
    private edu.umd.cs.findbugs.cloud.Cloud getCloud() {
        edu.umd.cs.findbugs.gui2.MainFrame instance =
          edu.umd.cs.findbugs.gui2.MainFrame.
          getInstance(
            );
        edu.umd.cs.findbugs.BugCollection bugCollection =
          instance.
          getBugCollection(
            );
        if (bugCollection ==
              null) {
            return null;
        }
        return bugCollection.
          getCloud(
            );
    }
    public void updateBugCollection() { commentsPane.
                                          setBugCollection(
                                            getBugCollection(
                                              ));
    }
    public void refresh() { commentsPane.
                              refresh(
                                ); }
    public boolean canSetDesignations() {
        return commentsPane.
          canSetDesignations(
            );
    }
    public void setDesignation(java.lang.String designationKey) {
        commentsPane.
          setDesignation(
            designationKey);
    }
    public void updateCloud() { commentsPane.
                                  updateCloud(
                                    ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ni92djjPIctHOI9PQ/8D7pLWXtUoAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xyfi+dYdiOeRorA4v/zlvXh++Xa1JXld");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("bfmjC+q+XWR/kEBXddXn1MyeA/DESl3fzEiuaEHgmuopxfjDO0D+YFH4UyB9" +
       "fo/887eDHKxGYRQkYG5N4yIlKX7+i22D714ghf9SZH+aQOgbmf2idHv+KFrA" +
       "KRvnlOE7d6oMPwTSF/Yi+cKbrwz/84K67xfZf0ugey017gT67rj4351g+4s7" +
       "dYt/DaQv7rF98Xaxva5bPLjngrorRQYBbMAtbo+Tj9zHU69zhH4M/+DgLPwH" +
       "juEfu6IndqvwSVhz2LRM3ekEEZe67gUh3uuKbxuDvBOkr+7F99U3XTUOHr2g" +
       "7rEieyiBHtlZyJmF4qwFHDx8B1qyhVlcu/naHubX3nyYz15QV1A7eAK4usic" +
       "FXexzkF78k6Nu5jB1/bQXnvzoV1wS+6guO1w8DyIFIGnH5lJy9zdaT9a6E/M" +
       "/OBddzqBxR2cb+xRfuPNQXnKnWdbOD9+AdR3FxmWQA/GZ3Cem0z8TmE+AdI3" +
       "9zC/+eZPZueCOrrIiAR6y37BKhzVOXjk7cDLE+iB09efi0udj93wv4rdfwH0" +
       "L75y9d63vzL+N9sbwMf39e9joXtnwMudvlh36vlyCEzK3oK+b3fNLtwiGYDN" +
       "za0COBCXF18FtwfcrrkAXNBNmgO/fvR4uvU4ge4/aZ1Al/Qz1RNg6PvqBLoL" +
       "5Kcr3weKQGXx+JPhkYM/ddFmd/sw3/n+x06ryXatfF0veGon/tyZ/fP2Xy9H" +
       "e91097+XF/UvvdLlPvg9/PO768u6q242BZV7WejK7ib1lmixX37mltSOaF2m" +
       "n//+g1++751He/sHdwyfqOwp3p66+aXhthcm22u+m197+1fe/fde+ePtTaP/" +
       "B40ISPyONAAA");
}
