package edu.umd.cs.findbugs.gui2;
public class PluginUpdateDialog implements java.io.Serializable {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.
      getLogger(
        edu.umd.cs.findbugs.gui2.PluginUpdateDialog.class.
          getName(
            ));
    private static final int SOFTWARE_UPDATE_DIALOG_DELAY_MS = 5000;
    public void showUpdateDialog(java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> updates,
                                 boolean force) { java.util.List<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> sortedUpdates =
                                                    new java.util.ArrayList<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate>(
                                                    );
                                                  edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate core =
                                                    sortUpdates(
                                                      updates,
                                                      sortedUpdates);
                                                  if (edu.umd.cs.findbugs.DetectorFactoryCollection.
                                                        instance(
                                                          ).
                                                        getUpdateChecker(
                                                          ).
                                                        updatesHaveBeenSeenBefore(
                                                          sortedUpdates) &&
                                                        !force) {
                                                      return;
                                                  }
                                                  java.lang.String headline;
                                                  if (core !=
                                                        null &&
                                                        updates.
                                                        size(
                                                          ) >=
                                                        2) {
                                                      headline =
                                                        "FindBugs and some plugins have updates";
                                                  }
                                                  else
                                                      if (updates.
                                                            isEmpty(
                                                              )) {
                                                          headline =
                                                            "FindBugs and all plugins are up to date!";
                                                      }
                                                      else
                                                          if (core ==
                                                                null) {
                                                              headline =
                                                                "Some FindBugs plugins have updates";
                                                          }
                                                          else {
                                                              headline =
                                                                null;
                                                          }
                                                  final javax.swing.JPanel comp =
                                                    new javax.swing.JPanel(
                                                    new java.awt.GridBagLayout(
                                                      ));
                                                  java.awt.GridBagConstraints gbc =
                                                    new java.awt.GridBagConstraints(
                                                    );
                                                  gbc.
                                                    insets =
                                                    new java.awt.Insets(
                                                      5,
                                                      5,
                                                      5,
                                                      5);
                                                  gbc.
                                                    gridwidth =
                                                    3;
                                                  gbc.
                                                    fill =
                                                    java.awt.GridBagConstraints.
                                                      BOTH;
                                                  if (headline !=
                                                        null) {
                                                      javax.swing.JLabel headlineLabel =
                                                        new javax.swing.JLabel(
                                                        headline);
                                                      headlineLabel.
                                                        setFont(
                                                          headlineLabel.
                                                            getFont(
                                                              ).
                                                            deriveFont(
                                                              java.awt.Font.
                                                                BOLD,
                                                              24));
                                                      comp.
                                                        add(
                                                          headlineLabel,
                                                          gbc);
                                                  }
                                                  if (!updates.
                                                        isEmpty(
                                                          )) {
                                                      int i =
                                                        1;
                                                      for (final edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate update
                                                            :
                                                            sortedUpdates) {
                                                          gbc.
                                                            gridy =
                                                            ++i;
                                                          gbc.
                                                            gridx =
                                                            1;
                                                          gbc.
                                                            fill =
                                                            java.awt.GridBagConstraints.
                                                              BOTH;
                                                          gbc.
                                                            gridwidth =
                                                            1;
                                                          gbc.
                                                            weightx =
                                                            1;
                                                          javax.swing.JLabel label =
                                                            createPluginLabel(
                                                              update);
                                                          comp.
                                                            add(
                                                              label,
                                                              gbc);
                                                          gbc.
                                                            weightx =
                                                            0;
                                                          gbc.
                                                            gridx =
                                                            2;
                                                          java.lang.String url =
                                                            update.
                                                            getUrl(
                                                              );
                                                          if (url !=
                                                                null &&
                                                                url.
                                                                length(
                                                                  ) >
                                                                0) {
                                                              javax.swing.JButton button =
                                                                createPluginUpdateButton(
                                                                  comp,
                                                                  update);
                                                              comp.
                                                                add(
                                                                  button,
                                                                  gbc);
                                                          }
                                                          java.lang.String msg =
                                                            update.
                                                            getMessage(
                                                              );
                                                          if (msg !=
                                                                null &&
                                                                msg.
                                                                length(
                                                                  ) >
                                                                0) {
                                                              gbc.
                                                                gridx =
                                                                1;
                                                              gbc.
                                                                gridwidth =
                                                                3;
                                                              gbc.
                                                                weightx =
                                                                1;
                                                              gbc.
                                                                fill =
                                                                java.awt.GridBagConstraints.
                                                                  BOTH;
                                                              gbc.
                                                                gridy =
                                                                ++i;
                                                              javax.swing.JTextPane msgpane =
                                                                createMessagePane(
                                                                  msg);
                                                              comp.
                                                                add(
                                                                  msgpane,
                                                                  gbc);
                                                          }
                                                      }
                                                  }
                                                  javax.swing.JOptionPane.
                                                    showMessageDialog(
                                                      null,
                                                      comp,
                                                      "Software Updates",
                                                      javax.swing.JOptionPane.
                                                        INFORMATION_MESSAGE);
    }
    private javax.swing.JTextPane createMessagePane(java.lang.String msg) {
        javax.swing.JTextPane msgpane =
          new javax.swing.JTextPane(
          );
        msgpane.
          setEditable(
            false);
        msgpane.
          setFocusable(
            false);
        msgpane.
          setText(
            msg);
        return msgpane;
    }
    private javax.swing.JLabel createPluginLabel(edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate update) {
        java.lang.String name;
        if (update.
              getPlugin(
                ).
              isCorePlugin(
                )) {
            name =
              "FindBugs";
        }
        else {
            name =
              update.
                getPlugin(
                  ).
                getShortDescription(
                  );
        }
        javax.swing.JLabel label =
          new javax.swing.JLabel(
          java.text.MessageFormat.
            format(
              ("<html><b>{0} {2}</b> is available<br><i><small>(currently in" +
               "stalled: {1})"),
              name,
              update.
                getPlugin(
                  ).
                getVersion(
                  ),
              update.
                getVersion(
                  )));
        label.
          setFont(
            label.
              getFont(
                ).
              deriveFont(
                java.awt.Font.
                  PLAIN,
                label.
                  getFont(
                    ).
                  getSize(
                    ) +
                  4));
        return label;
    }
    public edu.umd.cs.findbugs.updates.PluginUpdateListener createListener() {
        return new edu.umd.cs.findbugs.gui2.PluginUpdateDialog.MyPluginUpdateListener(
          );
    }
    private javax.swing.JButton createPluginUpdateButton(final javax.swing.JPanel comp,
                                                         final edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate update) {
        javax.swing.JButton button =
          new javax.swing.JButton(
          "<html><u><font color=#0000ff>More info...");
        button.
          setBorderPainted(
            false);
        button.
          setOpaque(
            false);
        button.
          setContentAreaFilled(
            false);
        button.
          setBackground(
            comp.
              getBackground(
                ));
        button.
          setToolTipText(
            update.
              getUrl(
                ));
        button.
          setCursor(
            java.awt.Cursor.
              getPredefinedCursor(
                java.awt.Cursor.
                  HAND_CURSOR));
        button.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean failed;
                    java.lang.String url =
                      update.
                      getUrl(
                        );
                    try {
                        failed =
                          url ==
                            null ||
                            !edu.umd.cs.findbugs.util.LaunchBrowser.
                            showDocument(
                              new java.net.URL(
                                url));
                    }
                    catch (java.net.MalformedURLException e1) {
                        failed =
                          true;
                    }
                    if (failed) {
                        javax.swing.JOptionPane.
                          showMessageDialog(
                            comp,
                            "Could not open URL " +
                            url);
                    }
                }
            });
        return button;
    }
    private edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate sortUpdates(java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> updates,
                                                                               java.util.List<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> sorted) {
        edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate core =
          null;
        for (edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate update
              :
              updates) {
            if (update.
                  getPlugin(
                    ).
                  isCorePlugin(
                    )) {
                core =
                  update;
            }
            else {
                sorted.
                  add(
                    update);
            }
        }
        java.util.Collections.
          sort(
            sorted,
            new java.util.Comparator<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate>(
              ) {
                @java.lang.Override
                public int compare(edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate o1,
                                   edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate o2) {
                    return o1.
                      getPlugin(
                        ).
                      getShortDescription(
                        ).
                      compareTo(
                        o2.
                          getPlugin(
                            ).
                          getShortDescription(
                            ));
                }
            });
        if (core !=
              null) {
            sorted.
              add(
                0,
                core);
        }
        return core;
    }
    private class MyPluginUpdateListener implements edu.umd.cs.findbugs.updates.PluginUpdateListener {
        @java.lang.Override
        public void pluginUpdateCheckComplete(final java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> updates,
                                              final boolean force) {
            if (updates.
                  isEmpty(
                    ) &&
                  !force) {
                return;
            }
            if (force) {
                showUpdateDialogInSwingThread(
                  updates,
                  force);
            }
            else {
                edu.umd.cs.findbugs.util.Util.
                  runInDameonThread(
                    new java.lang.Runnable(
                      ) {
                        @java.lang.Override
                        public void run() {
                            try {
                                java.lang.Thread.
                                  sleep(
                                    SOFTWARE_UPDATE_DIALOG_DELAY_MS);
                                showUpdateDialogInSwingThread(
                                  updates,
                                  force);
                            }
                            catch (java.lang.InterruptedException e) {
                                LOGGER.
                                  log(
                                    java.util.logging.Level.
                                      FINE,
                                    "Software update dialog thread interrupted",
                                    e);
                            }
                        }
                    },
                    "Software Update Dialog");
            }
        }
        private void showUpdateDialogInSwingThread(final java.util.Collection<edu.umd.cs.findbugs.updates.UpdateChecker.PluginUpdate> updates,
                                                   final boolean force) {
            javax.swing.SwingUtilities.
              invokeLater(
                new java.lang.Runnable(
                  ) {
                    @java.lang.Override
                    public void run() {
                        showUpdateDialog(
                          updates,
                          force);
                    }
                });
        }
        public MyPluginUpdateListener() {
            super(
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
           "Ooz+F7bq3YnuGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16e8zs6Fmfz3d2z16z5+zZXJZtstlNTqCbCZ9nxnPVoTRj" +
           "e8bjsT2escdzcSEnvtvj+3U8A0tJJJqoiCSCDQQU9h+CgCiQKJC0VQssQkBS" +
           "SKVUUZtUaoIQEiEhElEFrZoW+trz3c93Tlgh9ZPm/Tzv5Xmf6+995n38iW9B" +
           "D8YRVAl8Z2s4fnKo5cnh2mkeJttAiw9HdHMiRbGmYo4UxzPQd0d5y6eu/+13" +
           "PmTeOICuidBTkuf5iZRYvhdzWuw7mabS0PXT3r6juXEC3aDXUibBaWI5MG3F" +
           "yW0aeuzM0gS6RR+zAAMWYMACXLIA905ngUWv0bzUxYoVkpfEIfRj0BUauhYo" +
           "BXsJ9Px5IoEUSe4RmUkpAaDwcPF9DoQqF+cR9NyJ7HuZ7xL4wxX4pZ97141P" +
           "X4Wui9B1y+MLdhTARAI2EaHHXc2VtSjuqaqmitCTnqapvBZZkmPtSr5F6GZs" +
           "GZ6UpJF2oqSiMw20qNzzVHOPK4VsUaokfnQinm5pjnr87UHdkQwg6+tPZd1L" +
           "OCj6gYCPWoCxSJcU7XjJA7blqQn05osrTmS8RYEJYOlDrpaY/slWD3gS6IBu" +
           "7m3nSJ4B80lkeQaY+qCfgl0S6Jl7Ei10HUiKLRnanQR6+uK8yX4IzHqkVESx" +
           "JIFed3FaSQlY6ZkLVjpjn2+Nf+ADP+INvYOSZ1VTnIL/h8GiZy8s4jRdizRP" +
           "0fYLH387/bPS63/7/QcQBCa/7sLk/Zx/86Pffuc7nn3lc/s5/+SSOay81pTk" +
           "jvIx+YkvvhF7oXu1YOPhwI+twvjnJC/df3I0cjsPQOS9/oRiMXh4PPgK94er" +
           "H/+49s0D6FESuqb4TuoCP3pS8d3AcrSI0DwtkhJNJaFHNE/FynESegg805an" +
           "7XtZXY+1hIQecMqua375HahIByQKFT0Eni1P94+fAykxy+c8gCDocfCBhuDz" +
           "W9D+r/yfQBJs+q4GS4rkWZ4PTyK/kD+GNS+RgW5NWAfOJKdGDMeRAhupBWtq" +
           "CqeuCivx6Rjor8MTJzUsTwhUIAoOAsY3DgtXC/5/bJIXkt7YXLkCjPDGixDg" +
           "gOgZ+o6qRXeUl1K0/+3fuPPHBychcaSjBELBpodg00MlPjze9LDY9PDuTW8x" +
           "27OdBQgWRoSuXClZeG3B094HgAVtgAVgwuMv8D88evf733IVOF+weQCov5gK" +
           "3xussVP0IEuMVIALQ698ZPOe+b+sHkAH51G3kAN0PVosnxRYeYKJty5G22V0" +
           "r7/v63/7yZ990T+Nu3MwfgQHd68swvktFzUe+QpQZqSdkn/7c9Jn7vz2i7cO" +
           "oAcARgBcTCTgxwBynr24x7mwvn0MkYUsDwKBdT9yJacYOsa1RxMz8jenPaUr" +
           "PFE+Pwl0TEJHzTnHL0afCor2tXvXKYx2QYoSgv8ZH/zil//TXyKluo/R+vqZ" +
           "84/XkttnEKIgdr3EgidPfWAWaRqY998/MvmZD3/rff+idAAw462XbXiraDGA" +
           "DMCEQM0/8bnwK1/76se+dHDqNAk4IlPZsZR8L+Tfg78r4PN3xacQrujYR/dN" +
           "7AhinjvBmKDY+XtPeQNo44BgLDzoluC5vmrpliQ7pUv/n+tvq33mrz5wY+8T" +
           "Dug5dql3fHcCp/3fg0I//sfv+p/PlmSuKMVpd6q/02l7CH3qlHIviqRtwUf+" +
           "nv/8pp//I+kXARgDAIytnVZiGlTqAyoNWC11USlb+MJYvWjeHJ8NhPOxdiYr" +
           "uaN86Et//Zr5X//Ot0tuz6c1Z+3OSMHtvasVzXM5IP+Gi1E/lGITzGu8Mv6h" +
           "G84r3wEURUBRAWd5zEYAjvJzXnI0+8GH/tvv/f7r3/3Fq9DBAHrU8SV1IJUB" +
           "Bz0CPF2LTYBkefDP37n35s3DoLlRigrdJfzeQZ4uv10FDL5wb6wZFFnJabg+" +
           "/b9ZR37vn/2vu5RQoswlh/GF9SL8iY8+g/3gN8v1p+FerH42vxuiQQZ3urb+" +
           "cfdvDt5y7Q8OoIdE6IZylB7OJSctgkgEKVF8nDOCFPLc+Pn0Zn+W3z6Bszde" +
           "hJoz214EmtOjATwXs4vnR08N/kJ+BQTig/XD9mG1+P7OcuHzZXuraL5vr/Xi" +
           "8Z+CiI3LNBOsACeL5JR0XkiAxzjKreMYnYO0E6j41tppl2ReBxLt0jsKYQ73" +
           "udoeq4oW2XNRPrfu6Q23j3kF1n/ilBjtg7TvJ//8Q3/ywbd+DZhoBD2YFeoD" +
           "ljmz4zgtMuF/9YkPv+mxl/70J0sAAujDvyD/j3cWVKn7SVw0eNH0j0V9phCV" +
           "99NI0WgpTpgSJzS1lPa+njmJLBdAa3aU5sEv3vya/dGv//o+hbvohhcma+9/" +
           "6V///eEHXjo4kzi/9a7c9eyaffJcMv2aIw1H0PP326VcMfiLT77473/1xfft" +
           "ubp5Pg3sg185v/5f/u+fHH7kTz9/Sd7xgOP/IwybXL8xbMRk7/iPron6YiPk" +
           "uaB7u84mz8zY6NSRyiz0cXbKUqOeZecz2R3iNj7Q2QUZjFhVbCsVfaC1M7od" +
           "5F01JasktZzyKCbZJF83BytOEEy61xfMmei7vh8KU5KJRgI5Hvdqo5rgO9Kc" +
           "wENLhKuY2GXaY6SCDNqowwc8riKe52U7PZUQJN55tEVsjao6XhADlHGnpl8z" +
           "zCplGW7b4Og4Jvqr5Y5ZDoJqOtDrLZAEujW8tqz6I7+y0QwBnbKZ08YUZhhN" +
           "6b6dWxRG1sdWX1mNttxwHq+GtR45osIu1SO2U8sbz21+pFLBaN1zWqhcxSh/" +
           "ho0JBzF26GrO9KYyY/l9l5S4UajyFYQbYLWQCPBB5ggE4rbl1ZwPwnoXJ0ch" +
           "uUsHPZ4QSJFULNsgJMULJZpwtzYTLPg56mFL1NNHVHUjyOQ2ppc4niWTCk1s" +
           "9LYU2PTIcCnfHLle1B8QLb9joAzXpFWXrfPK2JNMs4YGaL++6XOMYLHTOq4Q" +
           "LqkaVbFVG6BqMMn7votIja1SNVnBF1zwId00FnzDbdm4POBGHktSBO/Sq50Y" +
           "ofVZ0pRkd4FaQifFzVpL87KEby1JpDHp2Ca1bvmWgZKDsRZjJjuu06rE1GwF" +
           "Gw0d3pvS6HoxUvoLzq+TtVrGY86ARG1S7zQSFafWKxFJJN2mGoZVb3EuFw4j" +
           "LcM4mpqwWSecxgGDL7g4WcjpoMUaHWJuu4Y7aggk22WcaFThBXs6HmdjW1Zy" +
           "BetMe2zaGAPfkbxWxNiLHjafTYTqdOEMpj4aul5AYtUlKfRrPVdaOlO/Kwuu" +
           "NalhWKwGXBT5vrcZhcxqx9V6C8OMFLG/4TnCbVHVsF4Z7OSElXu9jk/kK5Wa" +
           "skp/4C5CeMMZkkfmsjIYRQTTQJvbXHOGNiUN8/WyWjFJrLERloy0bDcbk0WN" +
           "b0aslzJVZpf740xPc4waWR21JXVbcl1tddKADwXJDUybx9vARz2Z8lOV4mtT" +
           "1CQyhm8tyE2CmPVtN0Mmer6DcUUPjXCNOcScqXukvwu42SLl15N5OyZHNUND" +
           "+wSJDPmQUqOVzrETQ7W5GSPuFM/erNzVfOrGLZty9OqYtkMMY0OLyoyEEuxa" +
           "txbPeBRue6ownSbLzZTLjM6OtuCugUwFEARVZG1jPcoKed+XrFTI0nEfQ1ka" +
           "tup0k++LbDQOyO3UX6XmvL+iGsLUdfq2Nw1HQLvDTsdBhV04tUUpXfQGk8Vm" +
           "NeCEKiFJSQSvmkycLGf8qm+PUIJwic3IZvGqPMddtCubDWo8WSh6zYYHdW2Z" +
           "caSLN6ywVwX+TrlTtU8216tx1a7jphgTrK/Hds5FEody/NSZrWb03NKUHkf3" +
           "9LjXI8MgWSPdemPVrXQE26jIco9B+t1Rc+dSQhQPCNwV1o3Ua1kKu2vXt22s" +
           "qgOrGJrdtwmBcMeSOJ9tBi1LR9weSO3M5ciZr6rNJAzQbbOeWi5mrP1kjtfG" +
           "VDALe+osmFQJXjYH+dhvKcic3loaG052ZkNDxkg3k4RKc8gssChw2EVPEVdd" +
           "XmNgXGN64/6guYWXaaZ7wzAEYGUYwbCp2PNdb8RKMdNRm1QD4QD4darcLp7p" +
           "RM/eJI3OkMIUbIjXelteRoZGw5Zi12SjhdM3cjb0AslmHX4Xq/Og312iraro" +
           "RLWaSqwNS8hnW0owqI2J5DLn0RmSVuud7awihma3u+gS7CoZrzeWEUZixxTE" +
           "+tx2Go28OqxV2UnUt7t6XXYnAYbOdtlsxVTpvqr0QquXNzvN8Tbd5l2dXcqc" +
           "2BI2U42pLldkihGayIgsbHodpzNxKd1ak9WezY6zZTJK6fFWYDUO5L4SZg8b" +
           "mIKPEzzGiHxO9ipOgM2qgGofBj/+V2NXzPKK39SJxYqXlrSdpHSMSV5XIoZe" +
           "E6k01fGsvx3xZJo1BYxeY5PWqJ9sw1aDntb4SZttIyKM+EOtL4a9ei9vrKpr" +
           "1OuT6WoK4rZhZ45FcckyHctpwDDYptm2d97Ylpq01YgJ2qvCMZztxq1qLotN" +
           "1cGRrefTy82YHXEGg2BbdKPYQN/ETmjNYhfDnYnC03OUmQS9Ohnu3EorcxRY" +
           "M4haezWIuYrRXcebxtT1lrZtO+okbUwyxI0URW0HioUMneUIuNyKbvdmZkfE" +
           "Q5dd490eEiK1Nq2q6xiliEW6msxZzDQMWzJVT+toNVJqcANxsp5TfCXT9LY/" +
           "EKUlESj5ZtvckFwqt2Ss39wiXU1Q6u1tTrD1PiN2HduJcF3YOFLLEXIm3FhE" +
           "n8gqdq87CZNVuzNpJe64Dc6MsTxspoTWnbYCpMv1tOp2C1fgdWdp+ArMal1u" +
           "g0UMkiz5Wl9HlJxfzZLVbGHhiKAgax1pJDYRAgwKsGYzSIU14iPtCWrYy4HU" +
           "mMvOUq/rOEDPSqsylFVu5EptnbUXFYH2LH2C0OhU77b7hDvQSCOWxa3KWd1t" +
           "EIfuxO+i83AU1MUt017Bw51UGdoLEuYpdyZlKdNZ5cgkG5L8VBIdLcXHkiZY" +
           "EzT0xWmrRy+GuybLVJCGvcEJJqsS/nScpKKUyd10EzHeqml68yYzNBtIY8Om" +
           "cCv1mlyIkCBdbfbpuNVhJ5N5w9eDBK5gdW3VjIe9FheyJiwiehvf9YykOlLq" +
           "cTZMksVUECUqZZO5mE/V9kCU/aXV08WlOMKMLDZSCulWWwCEFgGckI1oUpWl" +
           "1PQQvqoOdTjO4HqbrbO5IQ7Vhd1djlXY4Vs6ORpNeqtOlRS7U6rd6qPqGOSb" +
           "soZRiFcRabKNjJezla3U0Ko7zQKKiyg1mA2GvkG7Kzm1Vsgcgb1+qw0jI5Ay" +
           "mTreWq7jHbvohrnRq0wVu4XPGtrGhA3XrE76Q1tLOou8u1Squ3ne0cIA1nRX" +
           "T1ZdS603U1Tzm2FqomM8Szu7lqDQodmBY6+uNGScrq1QAaad5opMamIFpP80" +
           "gs8G5jQHx9iuMSIybt1R0yVVGQyWvZakTUnN3DANNlq28ZXfENUp1aP1sIqD" +
           "+OeIuDGe1zcLdc12uron6kx3VEWRgTgeLwkfZoeLKCbHslwjt7xPkDid4JQ0" +
           "CroOv6BgpNOZTruoiwj0MN60N8w0mzMVZdmZbO2o0YqxwF02ZtRYsrtVM6Rz" +
           "OUstRO6ntRQxB5lMmtVYms1XNOuRo6WWjFYzvQqPg6wexnycg2Mx1gdZmg8j" +
           "fNmU8mHYxrBgvk61tSxaC7rTotptQ4eXaCWha9UJh1MTao3RyTZFNxvTxRUR" +
           "g8eOtfPsRcw4I9qsYwvUwOIlw3FbI/H8diiYXrOyGecVbckPU5A3iTOT5hY7" +
           "TzE2SGW91ivBBqS9k9oQVvRUD63F1KZkm2FX0S6rUmMd3XSUxro61JGKtIR7" +
           "4JzXTbmG1qlNtZ14AKLW6wUML4Utmw05WHZpOl7KptYNrWA9XQ6HZtZqjjqp" +
           "r8Win5iV9bSxNSTw2MY289ag1s99Tt/IzYyyXXhoLXy5j80rzERMwNSc0xdu" +
           "DxW8RdfoNGtGxld3/nTCB1OuHuNmC3GyUEudPrHRKjvdS42evTKUiq8tm0Re" +
           "N5DWGDdlbNdZtdHWOJeru52hDl3C0ncSETYrzqbaIV1jmcAh3o15YJHeCm1H" +
           "kTGyepvpJDSbqr+ua6NK6gqZKA1jDYfJJkvtKrisqRY6C3KpQ2bscgYPbWEJ" +
           "Ow41lid1PFGyZi02I8klOMJxkSGyaQwGYsjaOb0TZgvYr3txa8OhQiML0JlD" +
           "Zs11JavgdrDpeRPFGLUJpJIMWBj8tphzQn06Q6ax1yBmIt+YzXvhWtcHc5cc" +
           "DSoZU4tm64Zj8tiokQSbTs1yXS3PdmHDbdAsPoSdIpdZu22ly+C1uQLn803F" +
           "5zoTXLSqag7O9E6moamwcJoLbi4TVkVYjlswSSqbtakttW0rVrZYv9PQKEpq" +
           "Lw2CmU4aeWNC5eNFhW2HSWPYRnNi63NkX5ZlDI6RAZMs+CoOa1qdJ/r5VlyO" +
           "nXSl4916dzRxJ3jXntesTYVpZLO8s9BG29ZgBqtwChIfKlBxNEVjvBXy6+Ec" +
           "35qrGE8tdpvOVPAjtJpgZH/HZyBbS+tDB5dHjrFbZ924wzYJimRqq3qWqwjD" +
           "NCNwzs12fLhwXLlGV4RGXe3iiMatMHbQNSesv6sM2nKIrLyU2PR6xU/jH3p1" +
           "txNPlhcxJxW0tdMuBohX8as8v3zDKwn0UBBZmZRo+cmddHk799h97qTP3Ntd" +
           "Ob4Lql5WnkjL8kN8eFkxori5eNO9Cm3lrcXH3vvSyyr7y7WDo4vSRQJdO6p/" +
           "njJwAMi8/d7XM0xZZDy9vfuj937jmdkPmu9+FfWJN19g8iLJX2M+8Xnie5Wf" +
           "PoCuntzl3VX+PL/o9vkbvEcjLUkjb3buHu9NJ/a4vjchBH32yB6fvbxGcLmF" +
           "S5faO9KFS+iDf4gC+VSOkzMF0J+yXv7Cf/yb6+/ZXyWdvxgra+BHSy+u+8qX" +
           "r9YfS259sFT8A7IUl6I+TEMPxsXMBHru3vX0ktb+1uux06ICdHlR4ZnLLu8P" +
           "y6J9EOTH7vrayyoExdiL5y7ULlfHHYV07/Cf+cr7WuV92fXMiq1EU2dHxf7z" +
           "FYTTCtvtcy8AXKqwO8rXP/lTn3v+G/OnysruXjcFW408KFlvHwX3lTK4D46q" +
           "dG+7B8NHHJUFjzvKj370777wly9+9fNXoWvA5wpHlSIN+GQCHd7rhYizBG7N" +
           "wBMOVgHvfWK/2vKM0sRHprx50ntSYkug778X7fLy9EIlrnilwPE3WoT6qaeW" +
           "9/EXQiUNgrOjpVM8/o90ih+LoHf8AzR4ooCjMIRuljFw5uK6uEo9Oxgk0FMY" +
           "3eP5O7PVpH9n3uPIHkr3Sz8LwOCV/iVX6fu6wImntu4HrHtIxUxNsbXo1lmY" +
           "PVddOYJ/7swpMQfIL/u+o0leqcPsPhWqjxRNmEDfE5zZoNy0KA44WqJdRv6B" +
           "zLfU09MpOn86PX5yOp0cITfP6CDToshStfscaHfXk8oO7wQ2y4kvgs8Xjizy" +
           "hVcLm9r9YLP4uiual8pZv3of/X28aH4pAZBu+puzdXrS4zcgWmZmpEmlP//C" +
           "qb4+9t3u2M+V0gDmXF7zP1Zu5VW8PgAQ5em7XlTav1yj/MbL1x9+w8vCfy0r" +
           "5ScvwDxCQw/rqeOcLUudeb4WRJpulbp4ZF+kCsp/v5lAT9+LL+BAxb+S/0/v" +
           "p38WhNMl0xOw99Hj2dn/LoEePZ2dQAfKueH/AALgaDiBroL27ODvgi4wWDy+" +
           "UjrLB/Mrd8dTaaeb381OJ0vOltQvoj+T7l8au6N88uXR+Ee+3frlfUkfQNRu" +
           "dwSvD+3fLjhJTJ6/J7VjWteGL3zniU898rbjDOqJPcOnfn+GtzdfXjPvu0FS" +
           "Vrl3//YNv/UDv/LyV8tK2/8DpDD24csnAAA=");
    }
    public PluginUpdateDialog() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5CQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eSWT7SVaQHixqxbZwQtHJfb9s6OFUjzw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("DpXih4LSB/4aHDxhwLEpvF6cgTNpiDwrc3bQj0oPt2icZQ+5xYQ85PFpDyfo" +
       "wlb/pA8G98hbJEZ2WcoTTcVuVW4SFzUm4cGu1qS11BRLC26crT85l+s9MucX" +
       "shVXZM+zNcktePhjd8iXv5E3PwKQDJdecra85ZY5kI1nqqdO5kffKv1xdrOi" +
       "4+UTw/fYsbHTjniqvV3D176l4ds7BVAKgH92B+J/LW9+FfhUJdAA4UMtDCUD" +
       "uAhXO5bQo0Vl0UGY5MnXPgcU6GS0YMEX3gELHs47b4DrWK+c7zoLPlcAfPEO" +
       "LPhy3vzLExbs1IyW5CNHDFhw/RwLTocK+n/jHdD/dN55AK6PHtH/0e+O7ztL" +
       "3n+4w9jv5s2/i0oP7kjPzXheOHNMN3ynw3n2OJ6bWHDlK++AK4/knR8A18tH" +
       "XHn5u6MVxxHBLaWaK7V9qjD/5Q5c+8O8+VpUevyswuwYQcRRdBRugR0ePrfD" +
       "mbGCRV9/BywqYiQEXK8dsei17yqL8sdPFp2feEvn88j5KuibYpEHz5YJ7dz9" +
       "t4uxn76ty8/7P/P/vHE+7+eKbXZOKL/9+XQn2vNuo+j8s9tLeq/g1H+PQFzm" +
       "BdFOwgXc506l+D/ejhRToHU3l1HmdWCP31SxvasyVn759av3vPv12e8WlYQn" +
       "lcD30qV79Ni2z5btnLm/7Aeabhbk3bsr4inYsncPUNrb1XcC35b/5TjvXdmB" +
       "3w9U+BbgEdj76PYs9INR6b5T6Ki0r5wbfgi45KPhqHQJtGcHHwFdYDC/fdTf" +
       "CWzvZg9fMPz6WzH8ZMrZksOL8egw3lXPHyqff70/+sFvYZ/blTwCJcqyfBUQ" +
       "8F3ZVV+evCo9c9vVjte63H3hOw/+yr3PH7/WPbhD+PQsnsHtqVvXFJKOHxVV" +
       "gNk/ffevfv8vvP61oo7o/wKfIcgA1DAAAA==");
}
