package edu.umd.cs.findbugs.gui2;
public abstract class AbstractSwingGuiCallback implements edu.umd.cs.findbugs.IGuiCallback {
    private final edu.umd.cs.findbugs.AWTEventQueueExecutor bugUpdateExecutor =
      new edu.umd.cs.findbugs.AWTEventQueueExecutor(
      );
    private final java.awt.Component parent;
    public AbstractSwingGuiCallback(java.awt.Component parent) { super();
                                                                 this.parent =
                                                                   parent;
    }
    @java.lang.Override
    public java.util.concurrent.ExecutorService getBugUpdateExecutor() { return bugUpdateExecutor;
    }
    @java.lang.Override
    public void showMessageDialogAndWait(final java.lang.String message)
          throws java.lang.InterruptedException { if (javax.swing.SwingUtilities.
                                                        isEventDispatchThread(
                                                          )) {
                                                      javax.swing.JOptionPane.
                                                        showMessageDialog(
                                                          parent,
                                                          message);
                                                  }
                                                  else {
                                                      try {
                                                          javax.swing.SwingUtilities.
                                                            invokeAndWait(
                                                              new java.lang.Runnable(
                                                                ) {
                                                                  @java.lang.Override
                                                                  public void run() {
                                                                      javax.swing.JOptionPane.
                                                                        showMessageDialog(
                                                                          parent,
                                                                          message);
                                                                  }
                                                              });
                                                      }
                                                      catch (java.lang.reflect.InvocationTargetException e) {
                                                          throw new java.lang.IllegalStateException(
                                                            e);
                                                      }
                                                  }
    }
    @java.lang.Override
    public void showMessageDialog(final java.lang.String message) {
        if (javax.swing.SwingUtilities.
              isEventDispatchThread(
                )) {
            javax.swing.JOptionPane.
              showMessageDialog(
                parent,
                message);
        }
        else {
            javax.swing.SwingUtilities.
              invokeLater(
                new java.lang.Runnable(
                  ) {
                    @java.lang.Override
                    public void run() {
                        javax.swing.JOptionPane.
                          showMessageDialog(
                            parent,
                            message);
                    }
                });
        }
    }
    @java.lang.Override
    public int showConfirmDialog(java.lang.String message,
                                 java.lang.String title,
                                 java.lang.String ok,
                                 java.lang.String cancel) {
        return javax.swing.JOptionPane.
          showOptionDialog(
            parent,
            message,
            title,
            javax.swing.JOptionPane.
              OK_CANCEL_OPTION,
            javax.swing.JOptionPane.
              PLAIN_MESSAGE,
            null,
            new java.lang.Object[] { ok,
            cancel },
            ok);
    }
    @java.lang.Override
    public java.io.InputStream getProgressMonitorInputStream(java.io.InputStream in,
                                                             int length,
                                                             java.lang.String msg) {
        javax.swing.ProgressMonitorInputStream pmin =
          new javax.swing.ProgressMonitorInputStream(
          parent,
          msg,
          in);
        javax.swing.ProgressMonitor pm =
          pmin.
          getProgressMonitor(
            );
        if (length >
              0) {
            pm.
              setMaximum(
                length);
        }
        return pmin;
    }
    @java.lang.Override
    public void displayNonmodelMessage(java.lang.String title,
                                       java.lang.String message) {
        edu.umd.cs.findbugs.gui2.DisplayNonmodelMessage.
          displayNonmodelMessage(
            title,
            message,
            parent,
            true);
    }
    @java.lang.Override
    public java.lang.String showQuestionDialog(java.lang.String message,
                                               java.lang.String title,
                                               java.lang.String defaultValue) {
        return (java.lang.String)
                 javax.swing.JOptionPane.
                 showInputDialog(
                   parent,
                   message,
                   title,
                   javax.swing.JOptionPane.
                     QUESTION_MESSAGE,
                   null,
                   null,
                   defaultValue);
    }
    @java.lang.Override
    public java.util.List<java.lang.String> showForm(java.lang.String message,
                                                     java.lang.String title,
                                                     java.util.List<edu.umd.cs.findbugs.IGuiCallback.FormItem> items) {
        int result =
          showFormDialog(
            message,
            title,
            items);
        if (result !=
              javax.swing.JOptionPane.
                OK_OPTION) {
            return null;
        }
        updateFormItemsFromGui(
          items);
        java.util.List<java.lang.String> results =
          new java.util.ArrayList<java.lang.String>(
          );
        for (edu.umd.cs.findbugs.IGuiCallback.FormItem item
              :
              items) {
            results.
              add(
                item.
                  getCurrentValue(
                    ));
        }
        return results;
    }
    @java.lang.Override
    public boolean showDocument(java.net.URL u) {
        return edu.umd.cs.findbugs.util.LaunchBrowser.
          showDocument(
            u);
    }
    @java.lang.Override
    public boolean isHeadless() { return false;
    }
    @java.lang.Override
    public void invokeInGUIThread(java.lang.Runnable r) {
        javax.swing.SwingUtilities.
          invokeLater(
            r);
    }
    private void updateFormItemsFromGui(java.util.List<edu.umd.cs.findbugs.IGuiCallback.FormItem> items) {
        for (edu.umd.cs.findbugs.IGuiCallback.FormItem item
              :
              items) {
            javax.swing.JComponent field =
              item.
              getField(
                );
            if (field instanceof javax.swing.text.JTextComponent) {
                javax.swing.text.JTextComponent textComponent =
                  (javax.swing.text.JTextComponent)
                    field;
                item.
                  setCurrentValue(
                    textComponent.
                      getText(
                        ));
            }
            else
                if (field instanceof javax.swing.JComboBox) {
                    javax.swing.JComboBox<java.lang.String> box =
                      (javax.swing.JComboBox<java.lang.String>)
                        field;
                    java.lang.String value =
                      (java.lang.String)
                        box.
                        getSelectedItem(
                          );
                    item.
                      setCurrentValue(
                        value);
                }
            item.
              updated(
                );
        }
        updateComboBoxes(
          items);
    }
    private void updateComboBoxes(java.util.List<edu.umd.cs.findbugs.IGuiCallback.FormItem> items) {
        for (edu.umd.cs.findbugs.IGuiCallback.FormItem item
              :
              items) {
            javax.swing.JComponent field =
              item.
              getField(
                );
            if (field instanceof javax.swing.JComboBox) {
                javax.swing.JComboBox<java.lang.String> box =
                  (javax.swing.JComboBox<java.lang.String>)
                    field;
                java.util.List<java.lang.String> newPossibleValues =
                  item.
                  getPossibleValues(
                    );
                if (!boxModelIsSame(
                       box,
                       newPossibleValues)) {
                    javax.swing.MutableComboBoxModel<java.lang.String> mmodel =
                      (javax.swing.MutableComboBoxModel<java.lang.String>)
                        box.
                        getModel(
                          );
                    replaceBoxModelValues(
                      mmodel,
                      newPossibleValues);
                    mmodel.
                      setSelectedItem(
                        item.
                          getCurrentValue(
                            ));
                }
            }
        }
    }
    private void replaceBoxModelValues(javax.swing.MutableComboBoxModel<java.lang.String> mmodel,
                                       java.util.List<java.lang.String> newPossibleValues) {
        try {
            while (mmodel.
                     getSize(
                       ) >
                     0) {
                mmodel.
                  removeElementAt(
                    0);
            }
        }
        catch (java.lang.Exception e) {
            
        }
        for (java.lang.String value
              :
              newPossibleValues) {
            mmodel.
              addElement(
                value);
        }
    }
    private boolean boxModelIsSame(javax.swing.JComboBox<java.lang.String> box,
                                   java.util.List<java.lang.String> newPossibleValues) {
        boolean same =
          true;
        if (box.
              getModel(
                ).
              getSize(
                ) !=
              newPossibleValues.
              size(
                )) {
            same =
              false;
        }
        else {
            for (int i =
                   0;
                 i <
                   box.
                   getModel(
                     ).
                   getSize(
                     );
                 i++) {
                if (!box.
                      getModel(
                        ).
                      getElementAt(
                        i).
                      equals(
                        newPossibleValues.
                          get(
                            i))) {
                    same =
                      false;
                    break;
                }
            }
        }
        return same;
    }
    private int showFormDialog(java.lang.String message,
                               java.lang.String title,
                               final java.util.List<edu.umd.cs.findbugs.IGuiCallback.FormItem> items) {
        javax.swing.JPanel panel =
          new javax.swing.JPanel(
          );
        panel.
          setLayout(
            new java.awt.GridBagLayout(
              ));
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
          weighty =
          0;
        gbc.
          gridwidth =
          2;
        gbc.
          gridy =
          1;
        gbc.
          insets =
          new java.awt.Insets(
            5,
            5,
            5,
            5);
        panel.
          add(
            new javax.swing.JLabel(
              message),
            gbc);
        gbc.
          gridwidth =
          1;
        for (edu.umd.cs.findbugs.IGuiCallback.FormItem item
              :
              items) {
            item.
              setItems(
                items);
            gbc.
              gridy++;
            panel.
              add(
                new javax.swing.JLabel(
                  item.
                    getLabel(
                      )),
                gbc);
            java.lang.String defaultValue =
              item.
              getDefaultValue(
                );
            if (item.
                  getPossibleValues(
                    ) !=
                  null) {
                javax.swing.JComboBox<?> box =
                  createComboBox(
                    items,
                    item);
                panel.
                  add(
                    box,
                    gbc);
            }
            else {
                javax.swing.JTextField field =
                  createTextField(
                    items,
                    item);
                panel.
                  add(
                    field,
                    gbc);
            }
        }
        return javax.swing.JOptionPane.
          showConfirmDialog(
            parent,
            panel,
            title,
            javax.swing.JOptionPane.
              OK_CANCEL_OPTION);
    }
    private javax.swing.JTextField createTextField(final java.util.List<edu.umd.cs.findbugs.IGuiCallback.FormItem> items,
                                                   edu.umd.cs.findbugs.IGuiCallback.FormItem item) {
        java.lang.String defaultValue =
          item.
          getDefaultValue(
            );
        javax.swing.JTextField field =
          item.
          isPassword(
            )
          ? new javax.swing.JPasswordField(
          )
          : new javax.swing.JTextField(
          );
        if (defaultValue !=
              null) {
            field.
              setText(
                defaultValue);
        }
        item.
          setField(
            field);
        field.
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
                    updateFormItemsFromGui(
                      items);
                }
            });
        return field;
    }
    private javax.swing.JComboBox<java.lang.String> createComboBox(final java.util.List<edu.umd.cs.findbugs.IGuiCallback.FormItem> items,
                                                                   edu.umd.cs.findbugs.IGuiCallback.FormItem item) {
        javax.swing.DefaultComboBoxModel<java.lang.String> model =
          new javax.swing.DefaultComboBoxModel<java.lang.String>(
          );
        javax.swing.JComboBox<java.lang.String> box =
          new javax.swing.JComboBox<java.lang.String>(
          model);
        item.
          setField(
            box);
        for (java.lang.String possibleValue
              :
              item.
               getPossibleValues(
                 )) {
            model.
              addElement(
                possibleValue);
        }
        java.lang.String defaultValue =
          item.
          getDefaultValue(
            );
        if (defaultValue ==
              null) {
            model.
              setSelectedItem(
                model.
                  getElementAt(
                    0));
        }
        else {
            model.
              setSelectedItem(
                defaultValue);
        }
        box.
          addActionListener(
            new java.awt.event.ActionListener(
              ) {
                @java.lang.Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    updateFormItemsFromGui(
                      items);
                }
            });
        return box;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wGnk7b2FzYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV8CbDsWHlev2VWhnkzAzNMgBlm4A14EFz1LqkGCOpFLbXU" +
       "6kXd6paI/dDWanVr31t4bBiXPZQNmMLD4gpMkgpUbBeLs5DFBGpSLrParnKK" +
       "JCapgONKJWCHxJTjpcCxc6S++3vvjvG8l9wqnVaf/f/Of77znz7/uZ/8bumW" +
       "wC9BrmNuddMJ97Q03Fubjb1w62rBXp9pjCQ/0NS2KQXBFMRdUV79q5f+9Afv" +
       "X91zvnSrWHqJZNtOKIWGYwcTLXDMWFOZ0qWj2K6pWUFYuodZS7EER6FhwowR" +
       "hE8wpRcdKxqWLjMHXYBBF2DQBbjoAowf5QKFXqzZkdXOS0h2GHilnyidY0q3" +
       "ukrevbD06MlKXMmXrP1qRoUEoIbb8+88EKoonPqlRw5l38l8lcAfhOBnPvxj" +
       "9/yTC6VLYumSYXN5dxTQiRA0IpbusjRL1vwAV1VNFUv32pqmcppvSKaRFf0W" +
       "S/cFhm5LYeRrhyDlkZGr+UWbR8jdpeSy+ZESOv6heEtDM9WDb7csTUkHsj5w" +
       "JOtOQiKPBwLeaYCO+UtJ0Q6KXNwYthqWXnW6xKGMl2mQARS9zdLClXPY1EVb" +
       "AhGl+3ZjZ0q2DnOhb9g6yHqLE4FWwtLLr1tpjrUrKRtJ166EpQdP5xvtkkCu" +
       "Owog8iJh6f7T2YqawCi9/NQoHRuf77Jvet87bNI+X/RZ1RQz7//toNDDpwpN" +
       "tKXma7ai7Qre9XrmQ9IDn3/3+VIJZL7/VOZdnn/x49976xsefu7LuzyvuEae" +
       "obzWlPCK8nH57t95Zftx7ELejdtdJzDywT8heaH+o/2UJ1IXzLwHDmvME/cO" +
       "Ep+bfFF4569of3i+dCdVulVxzMgCenSv4liuYWp+T7M1Xwo1lSrdodlqu0in" +
       "SreBd8awtV3scLkMtJAqXTSLqFud4juAaAmqyCG6Dbwb9tI5eHelcFW8p26p" +
       "VLoHPCUCPJdLu7/iMyzp8MqxNFhSJNuwHXjkO7n8AazZoQywXcFLoExypAdw" +
       "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" +
       "QhpCN0N8pQ7CmWh3Ydh0IbwdVVIZ7rj0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Y4LOX6igG/B8el/QT98YQfc3Frv14nmX3eKuSAoH+fUmeBCFu7sdO3EH+e7i" +
       "KovskaLEXlFi71olcmA2Zy9MBbucu4Gdy+u7o2h4t3Tnr3cV8Jxe+vKUAtpz" +
       "+hkKEOWBHJbu9zU3v0N20GBx2eC0FigvQAtemke+Gjyf29eCz/3/0IJXHAe6" +
       "fwDxVUN///GhP8yWQ/BTN2S8n6cbh4P8U3/9Qf7JMwb5vXmQgT2GvD+6VMDt" +
       "7NjjK987XsDoFtkeBs9X90f3qzdmdK+5U97R2ofPEPgX8+ADQOADo/Jol/yF" +
       "I4F/4QUIXPzG9FrwfGdf4O/cUHUuxMz7eHchzz88Q9ZP5MGzYemSApbrUJuC" +
       "rQNxeBUb6PIDJ3T5ZHIBw997ATDkQ156A5Dotl3Z3efNguEfnwHDP82DT4Ih" +
       "38FwfM6+80jWT/0wsqZh6cHrXYvN7/g9eNWd/N09cuXTz166/WXPzv5DcTP0" +
       "8K73HUzp9mVkmsfvXR17v9X1taVRoHHH7hbWjgh+DfTierd2w9LF/KNgnX+1" +
       "y/55sNu7RnawwTp4PZ77OWAKH+UOS+eVE8m/DrYH+8lh6QIIjyd+EUSBxPz1" +
       "S+6Oos6dIKdD2Ev3PR/sh0WOXyE9/bPEINr9f4Qrymee7bPv+F7zE7srrIA2" +
       "syyvBez7b9vdpi0qzQ/UHr1ubQd13Uo+/oO7f/WOxw4O/+7edfhIb4/17VXX" +
       "vi/atdywuOGZ/cuX/bM3/aNnv1lcVfq/dEUuj7ZCAAA=");
}
