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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Z+VRTZ9WnUpHCOkSULKKM4erqeFjQ1Jv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("I0WnJpWNvsRGgomQdZZv1JBQZkIEctuDViQEZidyREyUJUrzYzBXKEJD2A1i" +
       "TgwW+Lg44gW+XTNWU56JaUpcJ0u4R9WNenstsXUxahKz4nIQExGcQpbWTn1S" +
       "rxHxsE6MWzi+mlXhcMhXjeXIbA44Xij3uq2NhhgBKSDcKKiLJbuo2EMraJRb" +
       "dNMsKXxpKRZDzxojI8XqoNEGqRIrDh9S1Wm8kkJW4hhxBpYVS9EtD1W83W+K" +
       "bUeobfSRIaMmsV4KYsB6Ic73Jj4eukFj7fTnXbxZGVhJC3a89Syd981ujFl9" +
       "32aKVIzpTarDNiluztddSV843VqyjNdtRLMX/UQXMU8YdLxSLKMJMpQ3E7/V" +
       "ar3vfdmW2Z+ebdfybfkG7UGktG7AWca3z7Bbl9xka/qFwyC+/Hdn4US87ZGt" +
       "7rzk47s4L98rPHlaSHS+H/mFj73yqjT6qcp+RMufBIV7Att5tyFHu6ChLanb" +
       "AKWXTt97pfKI8MNIrV/92H99YvpDqw+fIf706RM4T5L8+9Rrv048L/6N84Xb" +
       "DuK2rotVP17p6vForXs9OQDKNz0Ws/Xk8UOELAb06k6yV08eIhz25k1PEPK8" +
       "GwYcnnv4JnmPZsnFIIvM14L8u4BtrOr/OKI5fxwUbo9sTTpQqXOX3mwD+Ggz" +
       "2YtzFw44fjB7mcUsoDuO0TNwfP7QEm7I9rmD4OWbxFblgZzbLfhX/96zv/mj" +
       "rz77u3ks5N2az/Jey1NvENN/pM73Xvvmd37r/ie/lMcL54Ffecee/Bji+m8d" +
       "jn3CkMM/lMrDmRCeyLDvpJL/B4Vr14fZveeyG/K+5oZ2IL+wDbe9vD3AuZwf" +
       "31zeHsZ88EOXqVG7c23YojqTy++7bMnxLucjvCm8/MG9vb0PXX3RcXIg375O" +
       "gvvb+OfeuTvGOvfSm3XJgV+605AtNVjdSJFuA1LJiD3vJAdNnt/S2T9Weujw" +
       "kAczbEvOonf387bR65q9d/AVC8hMbgT+3IUt+LyxLfIsee7NjOU9N8l7b5bA" +
       "QeEOMcO1ZeMmxd+fbP+fvUmZVpY8BQzM5LXssPnc44dW9vSfw8ou7OsTvdMn" +
       "+v+9XxncJI/KEjwo3JX5FWLWO8EacRbWkqDw4PUfNGTR2Y9f933U9pse8Uuv" +
       "Xrz7sVdn/2Zro/vf3dxDFu5WQsM4Gkx75P5Ox5MVLWf7nm1obW4c56ag/eu/" +
       "sciOTfObXPKTbdF5ULjvSFHA/+7uaCEOmAEolN1+0NnX7MeOB77wgiBLGZ/J" +
       "ueNj674ICw8eF+GFAxGe2yf5xJHz2dABzPn+nPcs0IB/WtVgd9YKZFt70+j0" +
       "7Ps5eRfqnPvHa+KF+5b//V+8/D8L24NEQOqIszsMVH5wXzmf2SnnMyeVM/sE" +
       "4cYx/RMA35AD28oi8V/6by9eeu8X//Zn8+bukrd4Mgrvy4P34TOxsB/FfU2k" +
       "xh9tvv2Tv/eNfCJxdx7SDUrkdK8Pv866UU0ybchdUu5Nk301PjIlevYYmPz7" +
       "v/1JR0jvYoq//Gp/+JE3Gj+1/aRDNPg0zajcDZjbfl1yMHF55lRq+7Tu7L74" +
       "/Qe+cs9z+5OsB7ZKc2j2R7A9fWNZd0wnyL94SH/hsX/03i+++jv5Mfv/BQu8" +
       "cOCYOQAA");
}
