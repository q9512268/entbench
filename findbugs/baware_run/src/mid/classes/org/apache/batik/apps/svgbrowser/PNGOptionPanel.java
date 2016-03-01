package org.apache.batik.apps.svgbrowser;
public class PNGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JCheckBox check;
    public PNGOptionPanel() { super(new java.awt.GridBagLayout());
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
                              constraints.setGridBounds(0,
                                                        0,
                                                        1,
                                                        1);
                              add(new javax.swing.JLabel(
                                    resources.
                                      getString(
                                        "PNGOptionPanel.label")),
                                  constraints);
                              check = new javax.swing.JCheckBox(
                                        );
                              constraints.weightx = 1.0;
                              constraints.fill = java.awt.GridBagConstraints.
                                                   HORIZONTAL;
                              constraints.setGridBounds(1,
                                                        0,
                                                        1,
                                                        1);
                              add(check, constraints); }
    public boolean isIndexed() { return check.isSelected(
                                                ); }
    public static boolean showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "PNGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.PNGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.PNGOptionPanel(
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
          isIndexed(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DJ7WF9kr/z8rWhcWARgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vaUIKMQeNmIpu76ALTbipqsJE05t3aH1dbsdcBrrVauLcruPcnjD9OG07nOa" +
       "xGH0EnxkvfOd2efX8vV9Ad+Rf+wfXESBD9+sg34dX37brkey4i0HBy3537mT" +
       "lxdHzzQPD7qg7Gv2gRvdL+Vfsi996PkX5fGnijt7B4RiCF0IXe/tlhIr1hFR" +
       "O0DSEzf+ah/m12uHB1df+tA/3zf7Ke29r+M4/qETep4U+TvDl7/Sfav0KzvQ" +
       "6YNjrGsu/o4zPXn88Oqir4SR78yOHWE9cODZuzKP3Q+ewZ5nB9c/Er/++VUe" +
       "Bdu5v8n569M36Xt/ViTA/3pAOLKSKNvryncfCRMhhM6LrmspgnMYQpvXOjw4" +
       "OlDeEB3YfF/WeAU89J7N9Ouweecw8q9r+Km925y9060787MmYR3uZkdgrqM4" +
       "Yc72SzfxyXNZ8UwIXQxABt3WBcvNj04+eGj9s6/HeuDd249fTWXn7Pdec0++" +
       "vduVPvvipVve9CLzV/ntzMH96wUSukWNLOvoseiR+jkPgJWea39he0jq5T8f" +
       "C6GHX+veLDP04CXX/oUt86+H0N3XZQ6hM9nPUdpPhtDlk7QhdDb/PUr3G2C0" +
       "Q7oQOretHCX5zRA6DUiy6kve/jy+7TVv/474Nzl1HI8O5u3O15q3IxD22DHg" +
       "yf/5YR8kou2/P1yVPvdif/S+V2uf2t5ISZaQppmUW0jo/PZy7ABoHrmhtH1Z" +
       "53qP//D2z194yz4o3r5V+HApHNHtoetf/3RsL8wvbNI/eNPvveO3XvxmfqD6" +
       "P1eR6fiVIgAA");
}
