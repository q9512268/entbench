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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qNBSjXvAQP4ZCY2LWwReYAtd+T/XTbWEvysAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nDA9IQ5rILueZGOpmg5ZiBebSzogen3F");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ADivLoHzkTQPZ2YiAwsOAxE/EAOkqnaxKOR9qGc7nYEs+bjqtbLFMNsgecxI" +
       "54i56K+hCddgjNgd6ODMppfweB2zU1hz6yhW1xJYruOOEC3W/pQcW6HWdL2x" +
       "Zk9SYtSZtdxxCyYAiasYWNQkakICVu0In2HjhAX9MK5BVSMta3B9DUlVd2qU" +
       "s3lH020qab0eiN0ILsvrATCaLbm+zoDpiuz0IXhWMYiYRkVDSdwpNGUF0tWl" +
       "McnOV6Ab4+tI6/KG64uRS3UyTBUqZCoEFjmuTMMgLYFOdbxy20maodBNdgTQ" +
       "fC9tb1Bw1OahhHAMa7Uh2rS2CFtTsrbqLKExG1HSsuWL5RmwmPFsL0y8Vqv1" +
       "nvfk22V/drYdy7cUm7MHsdGa0cgzvnWGnbr4JtvSLxwG8BW/O0snImyPbHMX" +
       "JR/fxXh5bunJ04Kgi73Iz3/0lVfFyc9U9qNZ/tQv3ePbzjsNKdwFDG1J3ZZR" +
       "eun0fVe8iAE/jNL69Y/+1ydmP6R88Ayxp0+fwHmS5N/DX/vNwfPCT54v3XYQ" +
       "s3VddPrxSlePR2rd60p+4FqzY/FaTx4/QMjjP6/uJHv15AHCYW/e9PSgyLth" +
       "sOG5h2+S92ieXPTzWHzVL74E2Map/o8jmvMnfun20FbFA5U6d+mNNn+PNpO/" +
       "OHfhgOMH85d5vEJ7x3H7DByfP7SEG7J97iBw+SZxVUUQ53b7/dW/++xv/+ir" +
       "z/5eEQd5t+rNObflrm8QxX+kzndf+8a3f+f+J79YxAoXQV9Fx578/OH6rxuO" +
       "fbRQwD+UysO5EJ7Ise+kUvz7pWvXh9i96/Im4Dx1E9i+9MI21Pby9vDmcnF0" +
       "c3l7EPP+D1zGJ93eNaKF9+jL77lsSdEu50Ocyb/8/r29vQ9cfdFxCiDfuk6C" +
       "+1v4596+O8I699IbdcmBX7rTkKy1r9xIkW7LpJITe96JD5o8v6Wzf6T00OEB" +
       "T8ewLSmP3N3P20auq/bewXcrWWZ8I/DnLmzBF41tkefJc29kLO+6Sd6786Th" +
       "l+4QclxbNm5S/L3x9v/Zm5Rp5clTmYGZnJofNJ97/NDKnv4LWNmFfX0id/pE" +
       "/r/3K9hN8vA86fulu3K/MmCGJ1gbnIW12C89eP3HDHlk9uPXfRG1/YpH+OKr" +
       "F+9+7FXmX29tdP9Lm3vGpbvlwDCOBtIeub/TcSVZLdi+ZxtWWxjHuVnW/vXf" +
       "V+RHpsVNIXl6W5T1S/cdKZrxv7s7WmiVmUFWKL99v7Ov2Y8dD3rheF4Scz7j" +
       "c8fH1n0Rlh48LsILByI8t0/yiSNns4GTMed5LOdaWQPeaVX93TlrJtvaG0am" +
       "51/MSbsw58I/XhMu3Lf87//85f9Z2h4iZqSOOLvDIOUH95XzmZ1yPnNSOfPP" +
       "D24cz09n8A3Jt608Cv+l//bipXd/4W99pmjuLmmLJ6fwniJwv3EmFvYjuK8J" +
       "+PQjzbd+4ve/Xkwk7i7CubMSBd3rQ6/zblzHuTYULqnwpvG+Gh+ZEj17DEzx" +
       "xd/+pCMgd/HEX3p1RHzoe/Wf2X7OIRhcmuZU7s6Y235ZcjBxeeZUavu07kRf" +
       "/P4DX77nuf1J1gNbpTk0+yPYnr6xrHum4xdfO6S/9Ng/fPcXXv3d4oj9/wJo" +
       "c3I2ijkAAA==");
}
