package org.sunflow.system;
@java.lang.SuppressWarnings("serial") 
public class RenderGlobalsPanel extends javax.swing.JTabbedPane {
    private javax.swing.JPanel generalPanel;
    private javax.swing.JComboBox maxSamplingComboxBox;
    private javax.swing.JPanel samplingPanel;
    private javax.swing.JComboBox minSamplingComboBox;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton defaultRendererRadioButton;
    private javax.swing.JRadioButton bucketRendererRadioButton;
    private javax.swing.JPanel bucketRendererPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel rendererPanel;
    private javax.swing.JTextField threadTextField;
    private javax.swing.JCheckBox threadCheckBox;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel threadsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel resolutionPanel;
    private javax.swing.JTextField resolutionYTextField;
    private javax.swing.JTextField resolutionXTextField;
    private javax.swing.JCheckBox resolutionCheckBox;
    private void initialize() {  }
    public static void main(java.lang.String[] args) { javax.swing.JFrame frame =
                                                         new javax.swing.JFrame(
                                                         );
                                                       frame.getContentPane(
                                                               ).
                                                         add(
                                                           new org.sunflow.system.RenderGlobalsPanel(
                                                             ));
                                                       frame.
                                                         setDefaultCloseOperation(
                                                           javax.swing.WindowConstants.
                                                             DISPOSE_ON_CLOSE);
                                                       frame.
                                                         pack(
                                                           );
                                                       frame.
                                                         setVisible(
                                                           true);
    }
    public RenderGlobalsPanel() { super();
                                  initialize(
                                    );
                                  initGUI(
                                    ); }
    private void initGUI() { try { setPreferredSize(
                                     new java.awt.Dimension(
                                       400,
                                       300));
                                   { generalPanel =
                                       new javax.swing.JPanel(
                                         );
                                     java.awt.FlowLayout generalPanelLayout =
                                       new java.awt.FlowLayout(
                                       );
                                     generalPanelLayout.
                                       setAlignment(
                                         java.awt.FlowLayout.
                                           LEFT);
                                     generalPanel.
                                       setLayout(
                                         generalPanelLayout);
                                     this.
                                       addTab(
                                         "General",
                                         null,
                                         generalPanel,
                                         null);
                                     { resolutionPanel =
                                         new javax.swing.JPanel(
                                           );
                                       generalPanel.
                                         add(
                                           resolutionPanel);
                                       java.awt.FlowLayout resolutionPanelLayout =
                                         new java.awt.FlowLayout(
                                         );
                                       resolutionPanel.
                                         setLayout(
                                           resolutionPanelLayout);
                                       resolutionPanel.
                                         setBorder(
                                           javax.swing.BorderFactory.
                                             createTitledBorder(
                                               javax.swing.BorderFactory.
                                                 createEtchedBorder(
                                                   javax.swing.border.BevelBorder.
                                                     LOWERED),
                                               "Resolution",
                                               javax.swing.border.TitledBorder.
                                                 LEADING,
                                               javax.swing.border.TitledBorder.
                                                 TOP));
                                       { resolutionCheckBox =
                                           new javax.swing.JCheckBox(
                                             );
                                         resolutionPanel.
                                           add(
                                             resolutionCheckBox);
                                         resolutionCheckBox.
                                           setText(
                                             "Override");
                                       }
                                       { jLabel1 =
                                           new javax.swing.JLabel(
                                             );
                                         resolutionPanel.
                                           add(
                                             jLabel1);
                                         jLabel1.
                                           setText(
                                             "Image Width:");
                                       }
                                       { resolutionXTextField =
                                           new javax.swing.JTextField(
                                             );
                                         resolutionPanel.
                                           add(
                                             resolutionXTextField);
                                         resolutionXTextField.
                                           setText(
                                             "640");
                                         resolutionXTextField.
                                           setPreferredSize(
                                             new java.awt.Dimension(
                                               50,
                                               20));
                                       }
                                       { jLabel2 =
                                           new javax.swing.JLabel(
                                             );
                                         resolutionPanel.
                                           add(
                                             jLabel2);
                                         jLabel2.
                                           setText(
                                             "Image Height:");
                                       }
                                       { resolutionYTextField =
                                           new javax.swing.JTextField(
                                             );
                                         resolutionPanel.
                                           add(
                                             resolutionYTextField);
                                         resolutionYTextField.
                                           setText(
                                             "480");
                                         resolutionYTextField.
                                           setPreferredSize(
                                             new java.awt.Dimension(
                                               50,
                                               20));
                                       } }
                                     { threadsPanel =
                                         new javax.swing.JPanel(
                                           );
                                       generalPanel.
                                         add(
                                           threadsPanel);
                                       threadsPanel.
                                         setBorder(
                                           javax.swing.BorderFactory.
                                             createTitledBorder(
                                               javax.swing.BorderFactory.
                                                 createEtchedBorder(
                                                   javax.swing.border.BevelBorder.
                                                     LOWERED),
                                               "Threads",
                                               javax.swing.border.TitledBorder.
                                                 LEADING,
                                               javax.swing.border.TitledBorder.
                                                 TOP));
                                       { threadCheckBox =
                                           new javax.swing.JCheckBox(
                                             );
                                         threadsPanel.
                                           add(
                                             threadCheckBox);
                                         threadCheckBox.
                                           setText(
                                             "Use All Processors");
                                       }
                                       { jLabel3 =
                                           new javax.swing.JLabel(
                                             );
                                         threadsPanel.
                                           add(
                                             jLabel3);
                                         jLabel3.
                                           setText(
                                             "Threads:");
                                       }
                                       { threadTextField =
                                           new javax.swing.JTextField(
                                             );
                                         threadsPanel.
                                           add(
                                             threadTextField);
                                         threadTextField.
                                           setText(
                                             "1");
                                         threadTextField.
                                           setPreferredSize(
                                             new java.awt.Dimension(
                                               50,
                                               20));
                                       } }
                                   }
                                   { rendererPanel =
                                       new javax.swing.JPanel(
                                         );
                                     java.awt.FlowLayout rendererPanelLayout =
                                       new java.awt.FlowLayout(
                                       );
                                     rendererPanelLayout.
                                       setAlignment(
                                         java.awt.FlowLayout.
                                           LEFT);
                                     rendererPanel.
                                       setLayout(
                                         rendererPanelLayout);
                                     this.
                                       addTab(
                                         "Renderer",
                                         null,
                                         rendererPanel,
                                         null);
                                     { defaultRendererRadioButton =
                                         new javax.swing.JRadioButton(
                                           );
                                       rendererPanel.
                                         add(
                                           defaultRendererRadioButton);
                                       defaultRendererRadioButton.
                                         setText(
                                           "Default Renderer");
                                     }
                                     { bucketRendererPanel =
                                         new javax.swing.JPanel(
                                           );
                                       javax.swing.BoxLayout bucketRendererPanelLayout =
                                         new javax.swing.BoxLayout(
                                         bucketRendererPanel,
                                         javax.swing.BoxLayout.
                                           Y_AXIS);
                                       bucketRendererPanel.
                                         setLayout(
                                           bucketRendererPanelLayout);
                                       rendererPanel.
                                         add(
                                           bucketRendererPanel);
                                       bucketRendererPanel.
                                         setBorder(
                                           javax.swing.BorderFactory.
                                             createTitledBorder(
                                               javax.swing.BorderFactory.
                                                 createEtchedBorder(
                                                   javax.swing.border.BevelBorder.
                                                     LOWERED),
                                               "Bucket Renderer",
                                               javax.swing.border.TitledBorder.
                                                 LEADING,
                                               javax.swing.border.TitledBorder.
                                                 TOP));
                                       { bucketRendererRadioButton =
                                           new javax.swing.JRadioButton(
                                             );
                                         bucketRendererPanel.
                                           add(
                                             bucketRendererRadioButton);
                                         bucketRendererRadioButton.
                                           setText(
                                             "Enable");
                                       }
                                       { samplingPanel =
                                           new javax.swing.JPanel(
                                             );
                                         java.awt.GridLayout samplingPanelLayout =
                                           new java.awt.GridLayout(
                                           2,
                                           2);
                                         samplingPanelLayout.
                                           setColumns(
                                             2);
                                         samplingPanelLayout.
                                           setHgap(
                                             5);
                                         samplingPanelLayout.
                                           setVgap(
                                             5);
                                         samplingPanelLayout.
                                           setRows(
                                             2);
                                         samplingPanel.
                                           setLayout(
                                             samplingPanelLayout);
                                         bucketRendererPanel.
                                           add(
                                             samplingPanel);
                                         {
                                             jLabel5 =
                                               new javax.swing.JLabel(
                                                 );
                                             samplingPanel.
                                               add(
                                                 jLabel5);
                                             jLabel5.
                                               setText(
                                                 "Min:");
                                         }
                                         {
                                             javax.swing.ComboBoxModel minSamplingComboBoxModel =
                                               new javax.swing.DefaultComboBoxModel(
                                               new java.lang.String[] { "Item One",
                                               "Item Two" });
                                             minSamplingComboBox =
                                               new javax.swing.JComboBox(
                                                 );
                                             samplingPanel.
                                               add(
                                                 minSamplingComboBox);
                                             minSamplingComboBox.
                                               setModel(
                                                 minSamplingComboBoxModel);
                                         }
                                         {
                                             jLabel6 =
                                               new javax.swing.JLabel(
                                                 );
                                             samplingPanel.
                                               add(
                                                 jLabel6);
                                             jLabel6.
                                               setText(
                                                 "Max:");
                                         }
                                         {
                                             javax.swing.ComboBoxModel maxSamplingComboxBoxModel =
                                               new javax.swing.DefaultComboBoxModel(
                                               new java.lang.String[] { "Item One",
                                               "Item Two" });
                                             maxSamplingComboxBox =
                                               new javax.swing.JComboBox(
                                                 );
                                             samplingPanel.
                                               add(
                                                 maxSamplingComboxBox);
                                             maxSamplingComboxBox.
                                               setModel(
                                                 maxSamplingComboxBoxModel);
                                         }
                                       } }
                                   } }
                             catch (java.lang.Exception e) {
                                 e.
                                   printStackTrace(
                                     );
                             } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6WoppmEqVvpiA+l3mLqVEg1lYIIcNZQI");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("oCm51NIoN0EtqYwItjuTwo25cUdpZmq4pCTrDeCnasMTsFpqTLq1ZfaiOam2" +
       "lhNRiWG/O+WqNXiGLpqdKcg3GmGzV6lmgWFAoTDUKPeVJuvWu/MqvMBG/aQM" +
       "STBrLfgERtsq5sNRc9POohoAJ9tgWRYVCI4ZTUNIKuWkKcBXMpssy8rEVmsa" +
       "14O6Dja2udFUas8dwVLndhUgQJKOp30lmzNdg10I7kQWOk5vBAKIKHSleEJZ" +
       "DTqWgHbSXc0luMtpZTf1TGzATWf1XosHhlUBqlCIKoQQJ5qQyxKcI46a9aAm" +
       "uq6C1NYTHqxNykQ6mE0kcAZN/Vmr6ZE6guTLX396vhXI1xeLrYeZ0EuzmRd8" +
       "8xwrb/FtlpmfPUrIK373lk7l0x5bti5qPrbL2fK90hNnpTwXa4uf+8iLLynD" +
       "nwIPslP+JCg9EDjuO0012iUAbUndlVF6/ux11EGR8X2UdfVrH/mvj09+YPHB" +
       "c+SSvuUUztMk//7g5d/ovU3+GxdKdx3mYN2Ui36y0fWTmVcPemoQevbkRP7V" +
       "Eyc3BPJ8zus7yV4/vSFwNJq33Q0oym6ZPLj3xtuUPZKfLgV55r0RFHn/27zT" +
       "/3FMc/44KN0dOYZyqFJ7l19tMfd4N/mDvYuHHF/JH+b5B+iOY/QcHF84soRb" +
       "sr13mIh8mzypIilzu5z+0t97+rd++KWnf7fIa7zf8DnRQzz9Fjn7x9p85+Wv" +
       "f+u3X/fEF4rc3yKJqxjY0x873Pwtw4lPFAr4R1J5Yy6Ex3PsO6kU/0Hpxs0p" +
       "c++6ug5F31iHTqA+u02dvbrdjLlabMVc3W6svP8DVwfDDnaDRgYYe/U9V211" +
       "syv5kGhJL7x/f3//A9efc90CyDdvkuDBkvze23dbUnvPv9qQHPqle03V1oPF" +
       "rRTprkwqObG3ufFhlxe2dA62iN5wtGHTNh1bzTNxD8q2meiGs3/4lUpWGN8K" +
       "/N7FLfiisy3y/PTMqxnLu25T9u781AxK98g5ri0bt6n+3nj7//Rt6uRuf+/J" +
       "zMAs0cg3jvceO7Kyt/w5rOzigT4xO31i/uL9CnmbskF+6gal+3K/0pvip1jr" +
       "nYe1OChdufnjhDzT+rGbvn/afrMjf+GlS/c/+tL0X29t9OC7mgeo0v1aaJrH" +
       "E2OPXd/reqpmFGw/sE2TLYxjb5L1f/P3EvkWaHFRSJ7dVuWD0kPHqmb8766O" +
       "VxIyM8gq5Zfvdw80+9GTSSyiJKlKzme8d3JuPRBh6cpJEV48FOHeAcnHj+21" +
       "hm7GnO/zomdnHfhnNQ12+6aZbOuvmmmefx+n7tKWC/94Q7740Py///MX/ldp" +
       "uymYkTrm7I6Sjq8cKOdTO+V86rRy5p8T3Do/n83gm2rg2HlW/fP/7bnL7/78" +
       "3/500d196hZPTuE9RSJ+81wsHGRk35AHow+33vzx3/taEUjcX6RnZzUKujen" +
       "UufDqMe5NhQuqfCm8YEaHwuJnj4Bpvi+7yDoCJldfvAXXyLoD3238VPbzzNk" +
       "U0zTnMr9GXPbL0UOA5enzqR2QOve/nPfe/hLDzxzEGQ9vFWaI7M/hu0tt5Y1" +
       "ZrlB8fVC+guP/qN3f/6l3ym2zP8f+peJKng5AAA=");
}
