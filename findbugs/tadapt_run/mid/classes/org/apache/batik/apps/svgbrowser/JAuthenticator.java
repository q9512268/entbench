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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1TT7WOYQ1zzk4GiEt+GPk/8DWC2cKFMsAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WJ1miENQbNdsbFvqIhkLDbMlzrpbhFfY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("beJqYm2KltHyOsMssA/ciGs+g4jAm0F6dVZF0ME8rRJk0hy1q+2110a8Kjsb" +
       "xsK6vaZZoFbbprRlA2lDtsQaiY4zbzEQwtDkjSBUWJ1mwOFNRdvCNs1kQjVN" +
       "PBhmXmOLTOqDXnMh6cZ8M20H2SSt18pbgH3ZmcqO2RmF9oyOh6oatx1JAWda" +
       "U+LsptZf91tIIpuCAjZyK2LCsliowDziE+x0gYto5vT5hMA7U6si6X5NLNfo" +
       "xBEp0WzqijxVWprt49wI0jk500VmNgFwukk71tQQoAAL2jqqA+jbcU8OcS1a" +
       "dPV2CFfgDaNaZJxp3SE26W4NCkq4uClyjQmLYdWa6zZIrtla0hvZp7eaV1HU" +
       "gAxHFSmoiXVnTEUev8zWKygkw4FRrtT5BpaO1xOX9/RVzdPFntcAh/iB5KcJ" +
       "NBxJZrzUx9Ks7YQ03FfWUquqSo2yKPNrcFxL+llzK7MNJCXg+SZiGR2c5LCW" +
       "h7ea05XTH7bJrCop8y4WQhmEDtfhYlKpaRyhp7C6bE5JlKHZ8rK1lfRoaOFj" +
       "bMbj0zKzHYLt4zirMYHNJoOOx5I1Bwo9b0CssuFM7Az1Ss03a5YAKZTpVU0j" +
       "HsxiJx7NWDGFTKI72MRyPKIDMmMbdKNMZnMx4NDOsiKSUyZr1kZ6mJYtrrIK" +
       "agYxguLl0mVJrV+elmPckLwEEtr4ik6bqy6TbOsJvk3Q1Wgcyg17PibBmTnZ" +
       "Dstr3o0Ca0Au5tVGQ9osLXg06idhr8o0qpvyJDEHHhrzzY3agsH5tlu12LHG" +
       "qjAXVgxgneKA7ttYz3cdyF0gFasFTsFiV4258tpaRUFfYgZ8eRFS67bruOuO" +
       "kFg2TyBQSjM9XmsE3Kje5UUxG9lDhOGNertV0Tb9xiQepWIYu7DLkxNmXBaR" +
       "VA0Rnm+Io/kY2W5ttAPkBuqwNtxsi0RFGVB0hGHYe3IX3tGdufBeU3gmTz7a" +
       "eAU+yfSMU/zEg1v8XSsdPPQ/48Etaj6699ZGYenxy77FKK5DP/+xF15UR7+I" +
       "XN27dv9NXLov9oMfc7S15pzp6u4i/Wc3vyD5wB7GBw4dyaeE3vLu/hbeeewW" +
       "ZUQevTvOb8+sWDx923PoGF37lnrqkn7Py/lEzw5zQHH+sLx4sBDsKQ5++BSz" +
       "tyjj8mgQlx5cJJaj5q+2WNnbz9FNDzRyj7jvafuvrgrah39R2vNr65f2tL/0" +
       "w6f9g7co+1AezePSjYL23WOjgvo8nz+lUfoL0PhUnpk/df2NPY2/cac0vuNl" +
       "aVzeoqygRYtLbzS0+Pi5ypm3edbpW7AnilsHcF4+ukW9gh8v+97x3HNyIFvn" +
       "XwPmD/YfvemDu91HYsoXXnzo+hteFP7D7nr7+EOu+4al63riOGffV59JXwtC" +
       "TbcKPt23e20dFMQncenJl/sAByj76Y8c/ZV41xgAf+TCxkD/839n634YCNFh" +
       "3bh0T/H/bL2P5NdyJ/Xi0rVd4myVj8alu0CVPPmx4JwaFnNzjpPplfNm+cT+" +
       "P/xyM3TGkj997hK4+F7y+MI22X0x+ZzyxRf7zIe/X//F3UcsiiNvt3kv14el" +
       "e3ff05xc+r710t6O+7rWfecPHvzSfW87Xhse3AE+VYMz2J64+IsR0g3i4huP" +
       "7T95wz969y+9+AfFxdj/B+nUNELIOgAA");
}
