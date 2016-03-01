package org.apache.batik.swing.svg;
public class SVGUserAgentGUIAdapter extends org.apache.batik.swing.svg.SVGUserAgentAdapter {
    public java.awt.Component parentComponent;
    public SVGUserAgentGUIAdapter(java.awt.Component parentComponent) { super(
                                                                          );
                                                                        this.
                                                                          parentComponent =
                                                                          parentComponent;
    }
    public void displayError(java.lang.String message) { javax.swing.JOptionPane pane =
                                                           new javax.swing.JOptionPane(
                                                           message,
                                                           javax.swing.JOptionPane.
                                                             ERROR_MESSAGE);
                                                         javax.swing.JDialog dialog =
                                                           pane.
                                                           createDialog(
                                                             parentComponent,
                                                             "ERROR");
                                                         dialog.
                                                           setModal(
                                                             false);
                                                         dialog.
                                                           setVisible(
                                                             true);
    }
    public void displayError(java.lang.Exception ex) {
        org.apache.batik.util.gui.JErrorPane pane =
          new org.apache.batik.util.gui.JErrorPane(
          ex,
          javax.swing.JOptionPane.
            ERROR_MESSAGE);
        javax.swing.JDialog dialog =
          pane.
          createDialog(
            parentComponent,
            "ERROR");
        dialog.
          setModal(
            false);
        dialog.
          setVisible(
            true);
    }
    public void displayMessage(java.lang.String message) {
        
    }
    public void showAlert(java.lang.String message) {
        java.lang.String str =
          "Script alert:\n" +
        message;
        javax.swing.JOptionPane.
          showMessageDialog(
            parentComponent,
            str);
    }
    public java.lang.String showPrompt(java.lang.String message) {
        java.lang.String str =
          "Script prompt:\n" +
        message;
        return javax.swing.JOptionPane.
          showInputDialog(
            parentComponent,
            str);
    }
    public java.lang.String showPrompt(java.lang.String message,
                                       java.lang.String defaultValue) {
        java.lang.String str =
          "Script prompt:\n" +
        message;
        return (java.lang.String)
                 javax.swing.JOptionPane.
                 showInputDialog(
                   parentComponent,
                   str,
                   null,
                   javax.swing.JOptionPane.
                     PLAIN_MESSAGE,
                   null,
                   null,
                   defaultValue);
    }
    public boolean showConfirm(java.lang.String message) {
        java.lang.String str =
          "Script confirm:\n" +
        message;
        return javax.swing.JOptionPane.
          showConfirmDialog(
            parentComponent,
            str,
            "Confirm",
            javax.swing.JOptionPane.
              YES_NO_OPTION) ==
          javax.swing.JOptionPane.
            YES_OPTION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe2wUxxmfO9vnBwY/CIYaMGAMEg7clSaURqZpbMfAkTO+" +
       "YEDFJDnmdufOi/d2l905++yEEpASUKSiCJyUpMGqVOgDkUCjpo1ahZK+AkpS" +
       "BE3TJKhJ2/yRpAlS+KNxWtqm38zu3T7uQa0g1dKOxzPfN/N93/y+x4xPXkEV" +
       "ho5aNayIOEhHNWIEo6wfxbpBxG4ZG8ZmGI0Jj/zl8J7J31fv9aPAAJoxiI1e" +
       "ARtkrURk0RhA8yXFoFgRiLGREJFxRHViEH0YU0lVBtAsyQinNFkSJNqrioQR" +
       "bMV6BDVgSnUpnqYkbC1A0YIIlybEpQl1egk6IqhWULVRm6HZxdDtmGO0KXs/" +
       "g6L6yE48jENpKsmhiGTQjoyObtZUeTQpqzRIMjS4U15lGWJDZFWeGVpP131y" +
       "7dHBem6GmVhRVMpVNDYRQ5WHiRhBdfZoj0xSxi70DVQWQdMcxBS1RbKbhmDT" +
       "EGya1demAumnEyWd6la5OjS7UkATmEAULXIvomEdp6xlolxmWKGKWrpzZtB2" +
       "YU7b7HF7VHzs5tD4t+6rf7YM1Q2gOknpZ+IIIASFTQbAoCQVJ7rRKYpEHEAN" +
       "Chx4P9ElLEtj1mk3GlJSwTQNEMiahQ2mNaLzPW1bwUmCbnpaoKqeUy/BQWX9" +
       "VZGQcRJ0bbJ1NTVcy8ZBwRoJBNMTGLBnsZQPSYrIceTmyOnYdhcQAGtlitBB" +
       "NbdVuYJhADWaEJGxkgz1A/iUJJBWqABBnWOtyKLM1hoWhnCSxCia46WLmlNA" +
       "Vc0NwVgomuUl4yvBKTV7TslxPlc2rjl4v7Je8SMfyCwSQWbyTwOmFg/TJpIg" +
       "OgE/MBlr2yOP46YXDvgRAuJZHmKT5qcPXL1jecvZcybN3AI0ffGdRKAx4Vh8" +
       "xsV53ctuK2NiVGmqIbHDd2nOvSxqzXRkNIg0TbkV2WQwO3l202+3PXiCfOhH" +
       "NWEUEFQ5nQIcNQhqSpNkoq8jCtExJWIYVRNF7ObzYVQJ/YikEHO0L5EwCA2j" +
       "cpkPBVT+N5goAUswE9VAX1ISaravYTrI+xkNIVQJH6qFrw2ZP/w3RXpoUE2R" +
       "EBawIilqKKqrTH92oDzmEAP6IsxqaigO+B9asTK4OmSoaR0AGVL1ZAgDKgaJ" +
       "ORkyRgBPIWMYoLV13RaIkJ1JotB1W8KdItYAYUGGPe3/smuG2WLmiM8HxzTP" +
       "GyRk8K/1qiwSPSaMp7t6rj4Te9kEIHMay4oUrYStg+bWQb51kG8dhK2DhbdG" +
       "Ph/f8SYmggkKONIhCA4QnWuX9d+7YceB1jJAozZSDufBSJfmZatuO4pkQ39M" +
       "OHlx0+SFV2tO+JEfAk0cspWdMtpcKcPMeLoqEBFiVrHkkQ2goeLpoqAc6OyR" +
       "kb1b93yRy+HMAmzBCghgjD3KYnduizav9xdat27/+5+ceny3ascBV1rJZsM8" +
       "ThZeWr3n61U+JrQvxM/FXtjd5kflELMgTlMMfgUhsMW7hyvMdGRDNtOlChRO" +
       "qHoKy2wqG2dr6KCujtgjHHgNvH8THPE05neL4FtqOSL/zWabNNbONoHKMOPR" +
       "gqeEr/ZrR9/43Qe3cHNns0edI+33E9rhiFhssUYemxpsCG7WCQG6Px2JHn7s" +
       "yv7tHH9AsbjQhm2s7YZIBUcIZn7o3K4333n72Gt+G7MUUnY6DtVPJqckG0c1" +
       "JZRkOLflgYgng/8z1LRtUQCVUkLCcZkwJ/lX3ZKVz310sN7EgQwjWRgtv/4C" +
       "9vgXutCDL9832cKX8Qks49o2s8nMMD7TXrlT1/EokyOz99L8J17CRyEhQBA2" +
       "pDHC46rP8lsm1BzIrpwTj9AgM5mqQDDg53krJwjx9hZmC86G+NxXWNNmOP3C" +
       "7XqOoikmPPrax9O3fnzmKlfEXXU5YdCLtQ4TeaxZkoHlZ3tj0HpsDALdrWc3" +
       "3lMvn70GKw7AigLEWKNPh1iYcYHGoq6ofOvFXzXtuFiG/GtRjaxicS3m/oeq" +
       "AfjEGIQwmtG+dod57iNV0NRzVVGe8szUCwofYk9Ko9zsY8/P/vGa70+8zfFm" +
       "AmxuLlQuzAuVvGK3vfyjy99+9xeT36008/2y4qHNwzfnn31yfN9fP80zMg9q" +
       "BWoRD/9A6ORTzd23f8j57ejCuBdn8vMPxF+b90snUn/3twZ+40eVA6hesKrj" +
       "rVhOM58dgIrQyJbMUEG75t3VnVnKdOSi5zxvZHNs641rdt6DPqNm/emFQtkS" +
       "68v2XaHMh3gnzFmWsqY9P0YU4wZAQ9ABD8q5EhteZYZH1t7Gmg0mKNYUQlym" +
       "0L78J+CthJyxyQYZYn4zv1ixygvtY/vGJ8S+4ytNiDW6C8AeuN88/fq/Xwke" +
       "+fP5AvVENVW1FTIZJrJjz0rYclEesHt5LW+jZPWlybLLh+bU5qd/tlJLkeTe" +
       "XtwDvBu8tO9vzZtvH9wxhby+wGMo75I/7D15ft1S4ZCfX0dMUOZdY9xMHW4o" +
       "1ugE7l3KZhcgW92AXA7fCutoVxTOraXQWIzVE8A9cb+ehzHmdkHzUsV3wiWi" +
       "PlfgHopqRcnQZDzao+twSSwZpKK6lIKkPmxdeEK7G98Zeur9p03keSOSh5gc" +
       "GH/ks+DBcROF5hVycd4tzsljXiO5rPWmmT6DHx98/2EfU4QNmNeIxm7rLrMw" +
       "d5nRtAxHcgmx+BZr3zu1++c/2L3fbxlmM0Xlw6ok2i5+bwkXz08qbKCTD3/d" +
       "DYx2+FZbp7t66sAoxloaGDNtYPRkBKIxF+KbZUpg4wHWGB5ssLGdtlHojTFK" +
       "EL4uS7OuqRulGGtho7A/43zVh0tof4A1eymaYWnfC/UIThKP/vtujP7L4Atb" +
       "SoSnrn8x1uvpf6iE/uOs+SZkB6ilRjrBp6hH9YOfW/VGNjUPvrst+e+euurF" +
       "WK+n+kQJ1b/DmicoqmGqw60NqkDOaOv+5I3TfZulwLap616M1aOan8vh5yrY" +
       "BjhRwgAnWXO8lAG+97kNMJNNtcAnWlqIUzdAMdbrHf5PSuj+PGt+RNE0pjuU" +
       "uAlJT/FbkaMWYs/r/em4QT3p7VTT5K5fV47dmX3YK8RiUt5l9F742fr3Yryu" +
       "qWKFU66acBRNnXrScXuvZ82Qafiko5+iqDKuqjLBSl78Z4+BHilMAQIrj/5j" +
       "z8Nv9PlReRhVpRVpV5qERXedU2mk4w6x7DdVPuCUiaVginztmnU54hh5duoY" +
       "ycCNuPATFrulzcl7VTdfgoVnJuqqZk9s+SN/Rsm91taCZRNpWXZeIhz9gKaT" +
       "hMS1qDWvFBr/dZ6i5uIvbBSVQcvFP2fSvwIyF6anqIL/dlJfgCrNSw10/LeT" +
       "7hJ4n01HUcDsOEn+ALIACeu+rmUzffB/fBy0zJrxue8ZucObdb3Dc1xNFruK" +
       "Rf4fkize0ub/SMA1JjZsvP/ql4+bL0aCjMfG2CrTAGXm41Wufl9UdLXsWoH1" +
       "y67NOF29JFurNZgC2/FirsOfO8ENNIaeZs9zitGWe1V589iaM68eCFyCsnQ7" +
       "8mGol7bn32AzWhouF9sjhfwJbjf8paej5t0dFz59y9fIHwosD2wpxRETDp+5" +
       "HE1o2pN+VB1GFVCKkgy/Xt85qmwiwrDucs9AXE0ruX+mzGBQx6zQ55axDDo9" +
       "N8peHClqzS+w819ha2R1hOhdbHXL3V03nrSmOWe5ZV80fZ9ZGpAYi/RqmlWK" +
       "V53mltc07tUfsOaX/wVoFsi1Bh0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "13zkma9lN1v/B42LaMcpKAAA");
}
