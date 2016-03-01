package edu.umd.cs.findbugs.gui2;
public class AboutDialog extends javax.swing.JDialog {
    private static final long serialVersionUID = 3546076956480385584L;
    public AboutDialog(javax.swing.JFrame parent, edu.umd.cs.findbugs.log.Logger l,
                       boolean modal) { super(parent, modal);
                                        initComponents();
                                        try { aboutEditorPane.setPage(
                                                                edu.umd.cs.findbugs.gui2.AboutDialog.class.
                                                                  getResource(
                                                                    "help/About.html"));
                                              licenseEditorPane.
                                                setPage(
                                                  edu.umd.cs.findbugs.gui2.AboutDialog.class.
                                                    getResource(
                                                      "help/License.html"));
                                              acknowldgementsEditorPane.
                                                setPage(
                                                  edu.umd.cs.findbugs.gui2.AboutDialog.class.
                                                    getResource(
                                                      "help/Acknowledgements.html"));
                                        }
                                        catch (java.io.IOException e) {
                                            l.
                                              logMessage(
                                                edu.umd.cs.findbugs.log.Logger.
                                                  ERROR,
                                                e.
                                                  toString(
                                                    ));
                                        }
                                        setTitle(
                                          java.text.MessageFormat.
                                            format(
                                              edu.umd.cs.findbugs.L10N.
                                                getLocalString(
                                                  "dlg.aboutfindbugs_ttl",
                                                  "About FindBugs {0}"),
                                              new java.lang.Object[] { edu.umd.cs.findbugs.Version.
                                                                         RELEASE }));
    }
    static java.util.regex.Pattern pattern =
      java.util.regex.Pattern.
      compile(
        "@VERSION@");
    private void initComponents() { java.awt.GridBagConstraints gridBagConstraints;
                                    aboutTabPane =
                                      new javax.swing.JTabbedPane(
                                        );
                                    aboutScrollPane =
                                      new javax.swing.JScrollPane(
                                        );
                                    aboutEditorPane =
                                      new javax.swing.JEditorPane(
                                        );
                                    licenseScrollPane =
                                      new javax.swing.JScrollPane(
                                        );
                                    licenseEditorPane =
                                      new javax.swing.JEditorPane(
                                        );
                                    acknowledgmentsScrollPane =
                                      new javax.swing.JScrollPane(
                                        );
                                    acknowldgementsEditorPane =
                                      new javax.swing.JEditorPane(
                                        );
                                    jSeparator1 =
                                      new javax.swing.JSeparator(
                                        );
                                    okButton =
                                      new javax.swing.JButton(
                                        );
                                    getContentPane(
                                      ).setLayout(
                                          new java.awt.GridBagLayout(
                                            ));
                                    addWindowListener(
                                      new java.awt.event.WindowAdapter(
                                        ) {
                                          @java.lang.Override
                                          public void windowClosing(java.awt.event.WindowEvent evt) {
                                              closeDialog(
                                                evt);
                                          }
                                      });
                                    aboutEditorPane.
                                      setEditable(
                                        false);
                                    aboutEditorPane.
                                      addHyperlinkListener(
                                        new javax.swing.event.HyperlinkListener(
                                          ) {
                                            @java.lang.Override
                                            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                                                editorPaneHyperlinkUpdate(
                                                  evt);
                                            }
                                        });
                                    aboutScrollPane.
                                      setViewportView(
                                        aboutEditorPane);
                                    aboutTabPane.
                                      addTab(
                                        "About",
                                        aboutScrollPane);
                                    licenseEditorPane.
                                      setEditable(
                                        false);
                                    licenseEditorPane.
                                      addHyperlinkListener(
                                        new javax.swing.event.HyperlinkListener(
                                          ) {
                                            @java.lang.Override
                                            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                                                editorPaneHyperlinkUpdate(
                                                  evt);
                                            }
                                        });
                                    licenseScrollPane.
                                      setViewportView(
                                        licenseEditorPane);
                                    aboutTabPane.
                                      addTab(
                                        "License",
                                        licenseScrollPane);
                                    acknowldgementsEditorPane.
                                      setEditable(
                                        false);
                                    acknowldgementsEditorPane.
                                      addHyperlinkListener(
                                        new javax.swing.event.HyperlinkListener(
                                          ) {
                                            @java.lang.Override
                                            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                                                editorPaneHyperlinkUpdate(
                                                  evt);
                                            }
                                        });
                                    acknowledgmentsScrollPane.
                                      setViewportView(
                                        acknowldgementsEditorPane);
                                    aboutTabPane.
                                      addTab(
                                        "Acknowledgments",
                                        acknowledgmentsScrollPane);
                                    gridBagConstraints =
                                      new java.awt.GridBagConstraints(
                                        );
                                    gridBagConstraints.
                                      fill =
                                      java.awt.GridBagConstraints.
                                        BOTH;
                                    gridBagConstraints.
                                      weightx =
                                      1.0;
                                    gridBagConstraints.
                                      weighty =
                                      1.0;
                                    getContentPane(
                                      ).add(
                                          aboutTabPane,
                                          gridBagConstraints);
                                    { aboutTabPane.
                                        setTitleAt(
                                          0,
                                          edu.umd.cs.findbugs.L10N.
                                            getLocalString(
                                              "dlg.about_tab",
                                              "About"));
                                      aboutTabPane.
                                        setTitleAt(
                                          1,
                                          edu.umd.cs.findbugs.L10N.
                                            getLocalString(
                                              "dlg.license_tab",
                                              "License"));
                                      aboutTabPane.
                                        setTitleAt(
                                          2,
                                          edu.umd.cs.findbugs.L10N.
                                            getLocalString(
                                              "dlg.acknowledgements_tab",
                                              "Acknowledgements"));
                                    }
                                    gridBagConstraints =
                                      new java.awt.GridBagConstraints(
                                        );
                                    gridBagConstraints.
                                      gridx =
                                      0;
                                    gridBagConstraints.
                                      gridy =
                                      1;
                                    gridBagConstraints.
                                      fill =
                                      java.awt.GridBagConstraints.
                                        HORIZONTAL;
                                    getContentPane(
                                      ).add(
                                          jSeparator1,
                                          gridBagConstraints);
                                    okButton.
                                      setMnemonic(
                                        'O');
                                    okButton.
                                      setText(
                                        edu.umd.cs.findbugs.L10N.
                                          getLocalString(
                                            "dlg.ok_btn",
                                            "OK"));
                                    okButton.
                                      addActionListener(
                                        new java.awt.event.ActionListener(
                                          ) {
                                            @java.lang.Override
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                okButtonActionPerformed(
                                                  evt);
                                            }
                                        });
                                    gridBagConstraints =
                                      new java.awt.GridBagConstraints(
                                        );
                                    gridBagConstraints.
                                      gridx =
                                      0;
                                    gridBagConstraints.
                                      gridy =
                                      2;
                                    gridBagConstraints.
                                      insets =
                                      new java.awt.Insets(
                                        3,
                                        0,
                                        3,
                                        0);
                                    getContentPane(
                                      ).add(
                                          okButton,
                                          gridBagConstraints);
                                    pack(
                                      ); }
    static void editorPaneHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
        try {
            if (evt.
                  getEventType(
                    ).
                  equals(
                    javax.swing.event.HyperlinkEvent.EventType.
                      ACTIVATED)) {
                java.net.URL url =
                  evt.
                  getURL(
                    );
                edu.umd.cs.findbugs.util.LaunchBrowser.
                  showDocument(
                    url);
            }
        }
        catch (java.lang.Exception e) {
            
        }
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        closeDialog(
          );
    }
    private void closeDialog(java.awt.event.WindowEvent evt) {
        closeDialog(
          );
    }
    private void closeDialog() { setVisible(
                                   false);
                                 dispose(
                                   ); }
    private javax.swing.JEditorPane aboutEditorPane;
    private javax.swing.JScrollPane aboutScrollPane;
    private javax.swing.JTabbedPane aboutTabPane;
    private javax.swing.JEditorPane acknowldgementsEditorPane;
    private javax.swing.JScrollPane acknowledgmentsScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JEditorPane licenseEditorPane;
    private javax.swing.JScrollPane licenseScrollPane;
    private javax.swing.JButton okButton;
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
       "N4rqwTuxd+nq3bCXAVKnrgkWd56evOXy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8f7CrPKrr15/4IlX+T8qb8odX2p9cAI9oMe2ffqixKnn+/1A062S5wf31yb8" +
       "kpEnIujJiy4uAr9W/CvAXnp8P/ypCHrsNsMjsPbh4+nRT0fQ1ZPREXRZOdP9" +
       "bARdOeyOoHtAfbrzedAEOovHm/7tvyztZZVdOhthj/Xr0e+0AaeC8vNnQml5" +
       "O/wo7MX7++EvKZ99dUz96BuNX9zf9FNsabcrqDwwga7sLx0eh87nLqR2ROt+" +
       "4oU3r/3ag+85CvPX9oBPlPYUtnfd/lpd3/Gj8iLc7jef+PX3/dKrf1LeTPm/" +
       "31RhcrYvAAA=");
}
