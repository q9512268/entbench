package edu.umd.cs.findbugs.gui2;
public class PropertiesDialog extends edu.umd.cs.findbugs.gui2.FBDialog {
    private static edu.umd.cs.findbugs.gui2.PropertiesDialog instance;
    private final javax.swing.JTextField tabTextField;
    private final javax.swing.JTextField fontTextField;
    public static edu.umd.cs.findbugs.gui2.PropertiesDialog getInstance() {
        if (instance ==
              null) {
            instance =
              new edu.umd.cs.findbugs.gui2.PropertiesDialog(
                );
        }
        return instance;
    }
    private PropertiesDialog() { super();
                                 javax.swing.JPanel contentPanel = new javax.swing.JPanel(
                                   new java.awt.BorderLayout(
                                     ));
                                 javax.swing.JPanel mainPanel = new javax.swing.JPanel(
                                   );
                                 mainPanel.setLayout(new java.awt.GridLayout(
                                                       2,
                                                       2));
                                 mainPanel.add(new javax.swing.JLabel(
                                                 "Tab Size"));
                                 tabTextField = new javax.swing.JTextField(
                                                  java.lang.Integer.
                                                    toString(
                                                      edu.umd.cs.findbugs.gui2.GUISaveState.
                                                        getInstance(
                                                          ).
                                                        getTabSize(
                                                          )));
                                 mainPanel.add(tabTextField);
                                 mainPanel.add(new javax.swing.JLabel(
                                                 "Font Size"));
                                 fontTextField = new javax.swing.JTextField(
                                                   java.lang.Float.
                                                     toString(
                                                       edu.umd.cs.findbugs.gui2.GUISaveState.
                                                         getInstance(
                                                           ).
                                                         getFontSize(
                                                           )));
                                 mainPanel.
                                   add(
                                     fontTextField);
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
                                               if (java.lang.Integer.
                                                     decode(
                                                       tabTextField.
                                                         getText(
                                                           )).
                                                     intValue(
                                                       ) !=
                                                     edu.umd.cs.findbugs.gui2.GUISaveState.
                                                     getInstance(
                                                       ).
                                                     getTabSize(
                                                       )) {
                                                   edu.umd.cs.findbugs.gui2.GUISaveState.
                                                     getInstance(
                                                       ).
                                                     setTabSize(
                                                       java.lang.Integer.
                                                         decode(
                                                           tabTextField.
                                                             getText(
                                                               )).
                                                         intValue(
                                                           ));
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
                                               }
                                               if (java.lang.Float.
                                                     parseFloat(
                                                       fontTextField.
                                                         getText(
                                                           )) !=
                                                     edu.umd.cs.findbugs.gui2.GUISaveState.
                                                     getInstance(
                                                       ).
                                                     getFontSize(
                                                       )) {
                                                   edu.umd.cs.findbugs.gui2.GUISaveState.
                                                     getInstance(
                                                       ).
                                                     setFontSize(
                                                       java.lang.Float.
                                                         parseFloat(
                                                           fontTextField.
                                                             getText(
                                                               )));
                                                   javax.swing.JOptionPane.
                                                     showMessageDialog(
                                                       edu.umd.cs.findbugs.gui2.PropertiesDialog.
                                                         getInstance(
                                                           ),
                                                       "To implement the new font size, please restart FindBugs.",
                                                       "Changing Font",
                                                       javax.swing.JOptionPane.
                                                         INFORMATION_MESSAGE);
                                               }
                                           }
                                       }));
                                 bottomPanel.
                                   add(
                                     new javax.swing.JButton(
                                       new javax.swing.AbstractAction(
                                         "Reset") {
                                           @java.lang.Override
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               tabTextField.
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
                                           }
                                       }));
                                 contentPanel.
                                   add(
                                     bottomPanel,
                                     java.awt.BorderLayout.
                                       SOUTH);
                                 setContentPane(
                                   contentPanel);
                                 setDefaultCloseOperation(
                                   javax.swing.WindowConstants.
                                     HIDE_ON_CLOSE);
                                 setModal(
                                   true);
                                 pack();
                                 addWindowListener(
                                   new java.awt.event.WindowAdapter(
                                     ) {
                                       @java.lang.Override
                                       public void windowDeactivated(java.awt.event.WindowEvent e) {
                                           if (java.lang.Integer.
                                                 decode(
                                                   tabTextField.
                                                     getText(
                                                       )).
                                                 intValue(
                                                   ) !=
                                                 edu.umd.cs.findbugs.gui2.GUISaveState.
                                                 getInstance(
                                                   ).
                                                 getTabSize(
                                                   )) {
                                               tabTextField.
                                                 setText(
                                                   java.lang.Integer.
                                                     toString(
                                                       edu.umd.cs.findbugs.gui2.GUISaveState.
                                                         getInstance(
                                                           ).
                                                         getTabSize(
                                                           )));
                                           }
                                           if (java.lang.Float.
                                                 parseFloat(
                                                   fontTextField.
                                                     getText(
                                                       )) !=
                                                 edu.umd.cs.findbugs.gui2.GUISaveState.
                                                 getInstance(
                                                   ).
                                                 getFontSize(
                                                   )) {
                                               fontTextField.
                                                 setText(
                                                   java.lang.Float.
                                                     toString(
                                                       edu.umd.cs.findbugs.gui2.GUISaveState.
                                                         getInstance(
                                                           ).
                                                         getFontSize(
                                                           )));
                                           }
                                       }
                                   }); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "D4hEmWSZFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
