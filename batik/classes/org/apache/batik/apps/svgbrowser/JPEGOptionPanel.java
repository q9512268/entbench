package org.apache.batik.apps.svgbrowser;
public class JPEGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JSlider quality;
    public JPEGOptionPanel() { super(new java.awt.GridBagLayout());
                               org.apache.batik.util.gui.ExtendedGridBagConstraints constraints =
                                 new org.apache.batik.util.gui.ExtendedGridBagConstraints(
                                 );
                               constraints.insets = new java.awt.Insets(
                                                      5,
                                                      5,
                                                      5,
                                                      5);
                               constraints.weightx = 0;
                               constraints.weighty = 0;
                               constraints.fill = java.awt.GridBagConstraints.
                                                    NONE;
                               constraints.setGridBounds(
                                             0,
                                             0,
                                             1,
                                             1);
                               add(new javax.swing.JLabel(
                                     resources.
                                       getString(
                                         "JPEGOptionPanel.label")),
                                   constraints);
                               quality = new javax.swing.JSlider(
                                           );
                               quality.setMinimum(0);
                               quality.setMaximum(100);
                               quality.setMajorTickSpacing(
                                         10);
                               quality.setMinorTickSpacing(
                                         5);
                               quality.setPaintTicks(true);
                               quality.setPaintLabels(true);
                               quality.setBorder(javax.swing.BorderFactory.
                                                   createEmptyBorder(
                                                     0,
                                                     0,
                                                     10,
                                                     0));
                               java.util.Hashtable labels =
                                 new java.util.Hashtable(
                                 );
                               for (int i = 0; i < 100; i +=
                                                          10) {
                                   labels.
                                     put(
                                       new java.lang.Integer(
                                         i),
                                       new javax.swing.JLabel(
                                         "0." +
                                         i /
                                           10));
                               }
                               labels.put(new java.lang.Integer(
                                            100),
                                          new javax.swing.JLabel(
                                            "1"));
                               quality.setLabelTable(labels);
                               java.awt.Dimension dim = quality.
                                 getPreferredSize(
                                   );
                               quality.setPreferredSize(new java.awt.Dimension(
                                                          350,
                                                          dim.
                                                            height));
                               constraints.weightx = 1.0;
                               constraints.fill = java.awt.GridBagConstraints.
                                                    HORIZONTAL;
                               constraints.setGridBounds(
                                             1,
                                             0,
                                             1,
                                             1);
                               add(quality, constraints);
    }
    public float getQuality() { return quality.getValue() /
                                  100.0F; }
    public static float showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "JPEGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.JPEGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.JPEGOptionPanel(
          );
        org.apache.batik.apps.svgbrowser.OptionPanel.Dialog dialog =
          new org.apache.batik.apps.svgbrowser.OptionPanel.Dialog(
          parent,
          title,
          panel);
        dialog.
          pack(
            );
        dialog.
          setVisible(
            true);
        return panel.
          getQuality(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nVz7En9lzbf+Awv6lnylGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "D+ZGO9O4IgAA");
}
