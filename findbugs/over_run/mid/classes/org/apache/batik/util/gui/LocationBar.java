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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5756lQ0P/AtIDXVr2R0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+NDVDs7HkwvAQ+HbLxdAnfsV7PTCUfT81nKOJ8ryRlF8Q6nEOyLoih94EYCl" +
       "giTvUlhmpxFg3XQl+zAG/Cf4uwCe/yiegqGiYr+cP9A/zCneeJxU+GBBuzLF" +
       "eHY27WN8OcKDIIUvzbKQ4sE+C9wHxqKsF8U79nO1bmuGbzsW0oNFbQU8zUMh" +
       "NW8SElS+jG+N+WLxOigKrBQ/DnCvY1ex1SNmHznxoemhQHslwTmm2VfJdKFN" +
       "9JBp9DZML75mpu8OGMkFSXBwxPZt7OLEJo7AHPY7h2b5taO5r6h9Ajy9QzS9" +
       "26B5563RXCjRHAMBiena63lFyHviNhFlKqVl0v6s/AuTL37uo/lLL+7XkLUE" +
       "slKocrv9381b0CKlePIV0qKTncE/4m97+W/+Yv4dFw+j/j1n4T/8SvCPVPJg" +
       "mSIehCmw+AOyf4izaLTOSV/6qtIvpVUGgLvqB+2DavG/exu3Ll7fWlpLUQyP" +
       "JP2wZcs3jlx2DiwHBIgblt0umslzDOFfM0NAbfeduDftgS3eD/7lB377h978" +
       "BaAjErorKSIpEPupGDCOi13v97/4wcfuef6LP1jmH8AquA9h199RjBq/OliP" +
       "FrD40rRpKYyYMmVQlQLZKy9SXGA6ILNKDrd08HMPfGHzkb/+1H67dn5FOkes" +
       "vu/5H/jPg/c/f/HUJvnNN+1TT/fZb5RLpl9zKOHTBn+LWcoew7966blf/MRz" +
       "791z9cDZLR/mxs6nfv/ff/vgw1/8zVvsLO60vZtC7deu2OiaQDTDUffoj66K" +
       "UqM3q2luSMbT4ajb0ZNhx6iyhLE2N6Mugpn8CsPGu4mzwe2BIthttJ7tmiqC" +
       "2o2EIzehNwpTz2KZdM70TAq2jXTu4ZmwtaOlpKOUs6D0sU1ttsHcRbzpYr0x" +
       "6iS9gGNFrrSVCqoTvlqtMrC2aZF5Uum0W40IbchJKuHOStoO24Rk7AhkKCkO" +
       "hbHjGO4aG9fMJ149Xy5S3J+pFY2rEIJSWbabuYn5SJXRK2taJOt9PhApGsun" +
       "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");
}
