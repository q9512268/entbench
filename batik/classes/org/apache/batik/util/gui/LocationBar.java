package org.apache.batik.util.gui;
public class LocationBar extends javax.swing.JPanel {
    protected static final java.lang.String RESOURCES = "org.apache.batik.util.gui.resources.LocationBar";
    protected static java.util.ResourceBundle bundle;
    protected static org.apache.batik.util.resources.ResourceManager rManager;
    static { bundle = java.util.ResourceBundle.getBundle(RESOURCES, java.util.Locale.
                                                           getDefault(
                                                             ));
             rManager = new org.apache.batik.util.resources.ResourceManager(
                          bundle); }
    protected javax.swing.JComboBox comboBox;
    public LocationBar() { super(new java.awt.BorderLayout(5, 5));
                           javax.swing.JLabel label = new javax.swing.JLabel(
                             rManager.
                               getString(
                                 "Panel.label"));
                           add("West", label);
                           try { java.lang.String s = rManager.getString(
                                                                 "Panel.icon");
                                 java.net.URL url = getClass().getResource(
                                                                 s);
                                 if (url != null) { label.setIcon(
                                                            new javax.swing.ImageIcon(
                                                              url));
                                 } }
                           catch (java.util.MissingResourceException e) {
                               
                           }
                           add("Center", comboBox = new javax.swing.JComboBox(
                                                      ));
                           comboBox.setEditable(true); }
    public void addActionListener(java.awt.event.ActionListener listener) {
        comboBox.
          addActionListener(
            listener);
    }
    public java.lang.String getText() { return (java.lang.String)
                                                 comboBox.
                                                 getEditor(
                                                   ).
                                                 getItem(
                                                   ); }
    public void setText(java.lang.String text) { comboBox.
                                                   getEditor(
                                                     ).
                                                   setItem(
                                                     text);
    }
    public void addToHistory(java.lang.String text) { comboBox.
                                                        addItem(
                                                          text);
                                                      comboBox.
                                                        setPreferredSize(
                                                          new java.awt.Dimension(
                                                            0,
                                                            comboBox.
                                                              getPreferredSize(
                                                                ).
                                                              height));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2SmwT4tXHP72H2TE8b6WHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
