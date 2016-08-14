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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "W/2r2Xz2q5z7r/yVNR/+F1r+cmcBHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16f+zr1nUf39f2e/aL4/dsN07qJk6cvGSzlXwpUaIowVlX" +
       "6gdFSiIpkiJFaV0d/iYl/hJ/iBRbd2mANmkDpMHmdCnWGhuQoF3hNO22Yh2G" +
       "bB7arg1SDOiQbd2GJVkxoD8DNH+0G5r+uqS+v/380sDJBPCSuvfcc8/n3HPO" +
       "PbyXL38VeiCOoFoYuHvLDZJjI0+O1y56nOxDIz4eT9GZEsWG3neVOJ6Duue1" +
       "d/7CrT/9+sft20fQ9RX0uOL7QaIkTuDHvBEH7s7Qp9Ct89qha3hxAt2erpWd" +
       "AqeJ48JTJ06em0JvuNA1ge5MT0WAgQgwEAGuRIDxcyrQ6Y2Gn3r9sofiJ/EW" +
       "+kHo2hS6HmqleAn09GUmoRIp3gmbWYUAcHiw/C8BUFXnPILecYb9gPlVgD9R" +
       "g1/8x993+1/cB91aQbccXyjF0YAQCRhkBT3sGZ5qRDGu64a+gh71DUMXjMhR" +
       "XKeo5F5Bj8WO5StJGhlnSior09CIqjHPNfewVmKLUi0JojN4pmO4+um/B0xX" +
       "sQDWJ86xHhASZT0AeNMBgkWmohmnXe7fOL6eQG+/2uMM450JIABdb3hGYgdn" +
       "Q93vK6ACeuwwd67iW7CQRI5vAdIHghSMkkBPvibTUtehom0Uy3g+gd5ylW52" +
       "aAJUD1WKKLsk0JuuklWcwCw9eWWWLszPV5n3f+z7fdI/qmTWDc0t5X8QdHrq" +
       "SifeMI3I8DXj0PHhZ6c/oTzxuY8cQRAgftMV4gPNv/6Br33Pe5965TcONN91" +
       "FxpWXRta8rz2KfWR33pr/5nufaUYD4ZB7JSTfwl5Zf6zk5bn8hB43hNnHMvG" +
       "49PGV/j/uPzgzxl/eATdpKDrWuCmHrCjR7XACx3XiEaGb0RKYugU9JDh6/2q" +
       "nYJugOep4xuHWtY0YyOhoPvdqup6UP0HKjIBi1JFN8Cz45vB6XOoJHb1nIcQ" +
       "BN0AF/QwuO5Ah191TyAdtgPPgBVN8R0/gGdRUOKPYcNPVKBbG1aB1W/gOEgj" +
       "YIJwEFmwAuzANk4bMmBBcLwDxiSNxNiIcAt0HYkUrishsKnj0trC/0/j5CXe" +
       "29m1a2Aq3no1ELjAh8jA1Y3oee3FtDf82s8//4WjM8c40VQCNcDQx4ehj6uh" +
       "j6uhj8HQx3cfGrp2rRrxO0oRDhMPpm0DAgAIjQ8/I/z98Qc+8s77gMWF2f1A" +
       "5yUp/NoRun8eMqgqMGrAbqFXPpn9kPQP6kfQ0eVQW4oNqm6W3WdlgDwLhHeu" +
       "utjd+N768O/96Wd/4oXg3Nkuxe6TGPDqnqUPv/OqgqNAM3QQFc/ZP/sO5Zee" +
       "/9wLd46g+0FgAMEwUYDxgjjz1NUxLvnyc6dxscTyAABsBpGnuGXTaTC7mdhR" +
       "kJ3XVDP/SPX8KNDxG0rjfhpc7zmx9upetj4eluV3HCylnLQrKKq4+3eE8Kd/" +
       "+z/9frNS92mIvnVh0ROM5LkLYaFkdqsKAI+e28A8MgxA978+OftHn/jqh/9e" +
       "ZQCA4l13G/BOWfZBOABTCNT8w7+x/e9f/tKnvnh0bjQJWBdT1XW0/AxkWQ/d" +
       "vAdIMNp7zuUBYcUFLldazR3R9wLdMR1FdY3SSv/81rsbv/RHH7t9sAMX1Jya" +
       "0Xu/MYPz+u/sQR/8wvf936cqNte0clk719k52SFWPn7OGY8iZV/Kkf/Qf37b" +
       "T/668tMg6oJIFzuFUQWvayeOUwr1JrCEVT2VLDkuVRb4wBur+YQrgmer8rjU" +
       "RdUNqtqaZfH2+KJfXHa9C5nJ89rHv/jHb5T++N99rQJyObW5aAa0Ej53sLyy" +
       "eEcO2L/5ahAgldgGdK1XmO+97b7ydcBxBThqIMjFbASCUX7JaE6oH7jxP/7D" +
       "rzzxgd+6DzoioJtuoOiEUvkf9BAwfCO2QRzLw7/7PYd5zx4Exe0KKvQq8Ad7" +
       "eUv1734g4DOvHXqIMjM59963/Bnrqh/6nf/3KiVUQecuC/KV/iv45Z96sv/d" +
       "f1j1P/f+svdT+asDNMjizvsiP+f9ydE7r//aEXRjBd3WTlJESXHT0qdWIC2K" +
       "T/NGkEZear+c4hzW8+fOottbr0aeC8NejTvnCwN4LqnL55t3CzXvPrlOny+F" +
       "mmtQ9YBXXZ6uyjtl8bcOVl0+/u0Tr/4r8LsGrr8sr5JPWXFYqB/rn2QL7zhL" +
       "F0KwXN0CIQPY/5kjlGzqh+BWlq2y6B24Y69pL+8vi2F+DUSZB5Bj7LhiML67" +
       "vPdV8oJwFFeJM+hhOr7iVloZJsD+Xe3OqagSSKSBwdxZu9ip796ubL2cmuND" +
       "9nlF1uHfWFZgy4+cM5sGIJH96P/5+G/++Lu+DAxuDD2wK40B2NmFEZm0zO1/" +
       "5OVPvO0NL37lo1V0BRMg/egvYl8puYr3QlwWTFmwp1CfLKEKVcIyVeKErgKi" +
       "oVdo7+lns8jxwLqxO0lc4Rce+/Lmp37vM4ek9KpTXSE2PvLij/3V8cdePLrw" +
       "KvCuV2XjF/scXgcqod94ouEIevpeo1Q9iN/97Av/9mdf+PBBqscuJ7ZD8N72" +
       "mf/6F795/MmvfP4uOdT9bvA6JjZ55GfJVkzhp79pY2UgmZjnG9Pvwrtep7Ok" +
       "RzjtyiBtnHNDkacVBCN7KJ6xvU2sDTRTw5Ic7ehYGq8T3683wuGWG46iBTW0" +
       "JhvBW8PacDuhJsJsO5GSzSQN5uJaEOyBMKbqfUlKw6TvbhVGqCvJ1mt2irQ5" +
       "x9KWZG1nC9/vekpNRcDVxEylhtEDiY/bE2c8YfgZX0hObRqLSKA3rJaj02uF" +
       "jnRcJoKW3LK6TTmp1fNAn3Bb2xv20i6+XlFJnd/UOcc2VmNHnGRUzthDh7Za" +
       "NZ93hmR9KdZdifOc0Wo2HzLSRhgz28gJOH4wwrsOG+ShGoiCNBCW9QZeVzML" +
       "689xPR8H3azd7EkjKRht18zOjXtNz1+2eD5PkcaAirZWtMtpvLXZ9jnSCsc9" +
       "BKXai60SdjyblraeOZ64cIIVEzEmR61JQBNzDpbhHZ+3NLKNWZPQIwhR2MhF" +
       "1+4PCNEYexTX0LddeT4Zj5o7zm307CEhth2gy76yXAy0voNLVn2sNJiemu7G" +
       "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" +
       "RdnUF+kktbokCTSbtcilPKdcQ9jvYFcQhtkSLJjDXGV9fd9SDJhJ0VauYtpw" +
       "tKwxsbTZ4rLp8VLaVl1nqWGqKPdFdbGupYaKdjQhJKOB1lRnKctymIpZQlHv" +
       "2e3RuiHP6qtpzVID3xw1iCaaxyy3D2kaE/HRKBrl5MpH9EZvzMVsnVolgdwg" +
       "1p35dpt0jXTdRlckDFPprkPgI1NbyLttprGyiCMdzZs3DXTISjPFWtbdmoBS" +
       "4K1DmU0Ih6Lbe0Kc8q4u6JZT9Mc2slh0GK4IvLEoy/3agt3u5jsjT93J1Cum" +
       "XK1TV1DOBSGXadtje87Tu+4k3evSDAsnUUvwDH4dk4E2SxG7PSCXisWsspgw" +
       "56In9VHZYxYwEiFygWzRAovgvcTwcI1oRDXN03qkhePlK6v5ze0aPFptkJyd" +
       "1a1drGzgvom35UPT02Xx7rNtqOp3/er5zsXN4PNtQKjcAXjbax3BVW//n/rQ" +
       "iy/p7KcbRyfbp0oCPZQE4ftcY2e4F1jdAJyefe2dDro6gTzf1vv1D/3Bk/Pv" +
       "tj/wTZxjvP2KnFdZ/nP65c+P3qP9wyPovrNNvledjV7u9Nzlrb2bkZGkkT+/" +
       "tMH3tssbfO8F1/tONPu+u58l3Gt3r5rSK7vT184JuIrgB+6xff2DZZEl0MO6" +
       "E4eush9G0cmR8vdeMJcPJND9u8DRz+0o/0a7LhcHqiqSy8CfBRd2Ahz7lgI/" +
       "3RF8/Hx/bphrRljaQ9Xvo/fQx4+XxY9c0UdZ98Fz7B9+vdjL9t4J9t63adJ/" +
       "8h4g/0lZvJhAj5yApI04VizjCsxPvF6Yz4CLOoFJfZtgfvoeMH+mLP4pCDCx" +
       "HWS4a0TJFYT/7HUgfKysfCu4uBOE3LcJ4S/eA+G/LIuXE+hmiRCkcl5YQeTO" +
       "IX7mWwFxeQJx+a2BeFQRHFWSnuP83D1w/vuy+OV74fw3rwPn42XlU+DST3Dq" +
       "36ap/Pw9IH6hLH41gd5QQuyD5MeJvLvF4RtqELiG4p9D/7VvBnqeQE/c/WuD" +
       "8uj0La/6yOnwYY728y/devDNL4n/rTpwP/t45qEp9KCZuu7F46wLz9fDyDCd" +
       "Ct1Dh8OtsLr9lwR68rU/hkig+0BZCf7FA/1vA5nvTp9AD1T3i9T/M4FuX6UG" +
       "dNX9It2XgDmd0yXQ9cPDRZL/DWQBJOXj74Sny8rx3/A7jhO15tcuJ0hn0/bY" +
       "N5q2CznVuy5lQtUHa6dZS3r4ZO157bMvjZnv/1r704dvCzRXKYqSy4NT6Mbh" +
       "M4ezzOfp1+R2yus6+czXH/mFh959mqU9chD43A0uyPb2ux/kD4GPVkfvxS+/" +
       "+V+9/2de+lJ1KvbXN62YE0koAAA=");
}
