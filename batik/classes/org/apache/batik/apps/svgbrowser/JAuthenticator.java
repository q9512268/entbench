package org.apache.batik.apps.svgbrowser;
public class JAuthenticator extends java.net.Authenticator {
    public static final java.lang.String TITLE = "JAuthenticator.title";
    public static final java.lang.String LABEL_SITE = "JAuthenticator.label.site";
    public static final java.lang.String LABEL_REQ = "JAuthenticator.label.req";
    public static final java.lang.String LABEL_USERID = "JAuthenticator.label.userID";
    public static final java.lang.String LABEL_PASSWORD = "JAuthenticator.label.password";
    public static final java.lang.String LABEL_CANCEL = "JAuthenticator.label.cancel";
    public static final java.lang.String LABEL_OK = "JAuthenticator.label.ok";
    protected javax.swing.JDialog window;
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JButton okButton;
    protected javax.swing.JLabel label1;
    protected javax.swing.JLabel label2;
    protected javax.swing.JTextField JUserID;
    protected javax.swing.JPasswordField JPassword;
    final java.lang.Object lock = new java.lang.Object();
    private boolean result;
    private volatile boolean wasNotified;
    private java.lang.String userID;
    private char[] password;
    public JAuthenticator() { super();
                              initWindow(); }
    protected void initWindow() { java.lang.String title = org.apache.batik.apps.svgbrowser.Resources.
                                    getString(
                                      TITLE);
                                  window = new javax.swing.JDialog(
                                             (java.awt.Frame)
                                               null,
                                             title,
                                             true);
                                  java.awt.Container mainPanel = window.
                                    getContentPane(
                                      );
                                  mainPanel.setLayout(new java.awt.BorderLayout(
                                                        ));
                                  mainPanel.add(buildAuthPanel(),
                                                java.awt.BorderLayout.
                                                  CENTER);
                                  mainPanel.add(buildButtonPanel(
                                                  ), java.awt.BorderLayout.
                                                       SOUTH);
                                  window.pack();
                                  window.addWindowListener(new java.awt.event.WindowAdapter(
                                                             ) {
                                                               public void windowClosing(java.awt.event.WindowEvent e) {
                                                                   cancelListener.
                                                                     actionPerformed(
                                                                       new java.awt.event.ActionEvent(
                                                                         e.
                                                                           getWindow(
                                                                             ),
                                                                         java.awt.event.ActionEvent.
                                                                           ACTION_PERFORMED,
                                                                         "Close"));
                                                               }
                                                           });
    }
    protected javax.swing.JComponent buildAuthPanel() {
        java.awt.GridBagLayout gridBag =
          new java.awt.GridBagLayout(
          );
        java.awt.GridBagConstraints c =
          new java.awt.GridBagConstraints(
          );
        javax.swing.JPanel proxyPanel =
          new javax.swing.JPanel(
          gridBag);
        c.
          fill =
          java.awt.GridBagConstraints.
            BOTH;
        c.
          weightx =
          1.0;
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelS =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_SITE));
        labelS.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelS,
            c);
        proxyPanel.
          add(
            labelS);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        label1 =
          new javax.swing.JLabel(
            "");
        label1.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            label1,
            c);
        proxyPanel.
          add(
            label1);
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelR =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_REQ));
        labelR.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelR,
            c);
        proxyPanel.
          add(
            labelR);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        label2 =
          new javax.swing.JLabel(
            "");
        label2.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            label2,
            c);
        proxyPanel.
          add(
            label2);
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelUserID =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_USERID));
        labelUserID.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelUserID,
            c);
        proxyPanel.
          add(
            labelUserID);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        JUserID =
          new javax.swing.JTextField(
            20);
        gridBag.
          setConstraints(
            JUserID,
            c);
        proxyPanel.
          add(
            JUserID);
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelPassword =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_PASSWORD));
        labelPassword.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelPassword,
            c);
        proxyPanel.
          add(
            labelPassword);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        JPassword =
          new javax.swing.JPasswordField(
            20);
        JPassword.
          setEchoChar(
            '*');
        JPassword.
          addActionListener(
            okListener);
        gridBag.
          setConstraints(
            JPassword,
            c);
        proxyPanel.
          add(
            JPassword);
        return proxyPanel;
    }
    protected javax.swing.JComponent buildButtonPanel() {
        javax.swing.JPanel buttonPanel =
          new javax.swing.JPanel(
          );
        cancelButton =
          new javax.swing.JButton(
            org.apache.batik.apps.svgbrowser.Resources.
              getString(
                LABEL_CANCEL));
        cancelButton.
          addActionListener(
            cancelListener);
        buttonPanel.
          add(
            cancelButton);
        okButton =
          new javax.swing.JButton(
            org.apache.batik.apps.svgbrowser.Resources.
              getString(
                LABEL_OK));
        okButton.
          addActionListener(
            okListener);
        buttonPanel.
          add(
            okButton);
        return buttonPanel;
    }
    public java.net.PasswordAuthentication getPasswordAuthentication() {
        synchronized (lock)  {
            java.awt.EventQueue.
              invokeLater(
                new java.lang.Runnable(
                  ) {
                    public void run() {
                        label1.
                          setText(
                            getRequestingSite(
                              ).
                              getHostName(
                                ));
                        label2.
                          setText(
                            getRequestingPrompt(
                              ));
                        window.
                          setVisible(
                            true);
                    }
                });
            wasNotified =
              false;
            while (!wasNotified) {
                try {
                    lock.
                      wait(
                        );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
            if (!result)
                return null;
            return new java.net.PasswordAuthentication(
              userID,
              password);
        }
    }
    java.awt.event.ActionListener okListener =
      new java.awt.event.ActionListener(
      ) {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            synchronized (lock)  {
                window.
                  setVisible(
                    false);
                userID =
                  JUserID.
                    getText(
                      );
                password =
                  JPassword.
                    getPassword(
                      );
                JPassword.
                  setText(
                    "");
                result =
                  true;
                wasNotified =
                  true;
                lock.
                  notifyAll(
                    );
            }
        }
    };
    java.awt.event.ActionListener cancelListener =
      new java.awt.event.ActionListener(
      ) {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            synchronized (lock)  {
                window.
                  setVisible(
                    false);
                userID =
                  null;
                JUserID.
                  setText(
                    "");
                password =
                  null;
                JPassword.
                  setText(
                    "");
                result =
                  false;
                wasNotified =
                  true;
                lock.
                  notifyAll(
                    );
            }
        }
    };
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4xP83cBNQegG/opvN/4XItGXxPgsAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FdmwnWz7yjxUU6m2YJf9clRezZVaU2Xo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "P84INSHIOgAA");
}
