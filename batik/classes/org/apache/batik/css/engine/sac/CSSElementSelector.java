package org.apache.batik.css.engine.sac;
public class CSSElementSelector extends org.apache.batik.css.engine.sac.AbstractElementSelector {
    public CSSElementSelector(java.lang.String uri, java.lang.String name) {
        super(
          uri,
          name);
    }
    public short getSelectorType() { return SAC_ELEMENT_NODE_SELECTOR; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        java.lang.String name =
          getLocalName(
            );
        if (name ==
              null) {
            return true;
        }
        java.lang.String eName;
        if (e.
              getPrefix(
                ) ==
              null)
            eName =
              e.
                getNodeName(
                  );
        else
            eName =
              e.
                getLocalName(
                  );
        return eName.
          equals(
            name);
    }
    public int getSpecificity() { return getLocalName() == null ? 0 : 1; }
    public java.lang.String toString() { java.lang.String name = getLocalName(
                                                                   );
                                         if (name == null) { return "*"; }
                                         return name; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye4xUVxk/M/t+P3iWxwLLgmHBmdKWGlxaC9PdsjgLK0uJ" +
                                                              "LsJw5s6Zmcveufdy75nd2a1oizFQEwnBpaVq+UOpbQ0tTbVRo20wTUqbVpNW" +
                                                              "Yq2m1EQT8UEsMal/oNbvO+fO3Dt3HhuMdZI5c+ec7/vO+V6/7zv3/DVSZ1uk" +
                                                              "h+k8xKdNZocGdT5KLZslIhq17T0wF1MeraF/P3B15+YgqR8n7WlqjyjUZkMq" +
                                                              "0xL2OFmu6janusLsnYwlkGPUYjazJilXDX2cLFDt4YypqYrKR4wEQ4K91IqS" +
                                                              "Lsq5pcaznA07AjhZHoWThMVJwlv9ywNR0qoY5rRLvthDHvGsIGXG3cvmpDN6" +
                                                              "iE7ScJarWjiq2nwgZ5H1pqFNpzSDh1iOhw5pmxwT7IhuKjFB73MdH9w4me4U" +
                                                              "JphHdd3gQj17N7MNbZIloqTDnR3UWMY+TL5IaqKkxUPMSV80v2kYNg3Dpnlt" +
                                                              "XSo4fRvTs5mIIdTheUn1poIH4mRVsRCTWjTjiBkVZwYJjdzRXTCDtisL2kot" +
                                                              "S1Q8vT48++iBzudrSMc46VD1MTyOAofgsMk4GJRl4syytyYSLDFOunRw9hiz" +
                                                              "VKqpM46nu201pVOeBffnzYKTWZNZYk/XVuBH0M3KKtywCuolRUA5/+qSGk2B" +
                                                              "rgtdXaWGQzgPCjarcDArSSHuHJbaCVVPcLLCz1HQse/TQACsDRnG00Zhq1qd" +
                                                              "wgTpliGiUT0VHoPQ01NAWmdAAFqcLKkoFG1tUmWCplgMI9JHNyqXgKpJGAJZ" +
                                                              "OFngJxOSwEtLfF7y+Ofazi0nHtC360ESgDMnmKLh+VuAqcfHtJslmcUgDyRj" +
                                                              "a3/0EbrwxeNBQoB4gY9Y0vzwC9fv2dBz8VVJs7QMza74IabwmHIu3v7mssi6" +
                                                              "zTV4jEbTsFV0fpHmIstGnZWBnAkIs7AgERdD+cWLu1/53IPfY38JkuZhUq8Y" +
                                                              "WjYDcdSlGBlT1Zh1H9OZRTlLDJMmpiciYn2YNMBzVNWZnN2VTNqMD5NaTUzV" +
                                                              "G+I/mCgJItBEzfCs6kkj/2xSnhbPOZMQ0gBf0grf5UR+xC8nLJw2MixMFaqr" +
                                                              "uhEetQzU3w4D4sTBtulwHKJ+ImwbWQtCMGxYqTCFOEgzZ0GxkTYFZwrbVAlH" +
                                                              "xsYQFYB7jGkM4z6E4Wb+vzbKocbzpgIBcMYyPxRokEXbDS3BrJgym902eP3Z" +
                                                              "2OsyzDA1HFtxchvsHZJ7h8TeIdg7JPcOwd6h0r1JICC2nI9nkL4Hz00ABgAI" +
                                                              "t64b27/j4PHeGgg6c6oWzI6kvUXFKOICRR7dY8qF7raZVVc2vhwktVHSTRWe" +
                                                              "pRrWlq1WClBLmXASuzUOZcqtFis91QLLnGUoLAFgValqOFIajUlm4Twn8z0S" +
                                                              "8rUMszZcuZKUPT+5eGbqob1fujVIgsUFAresA2xD9lGE9QJ89/mBoZzcjmNX" +
                                                              "P7jwyBHDhYiiipMvlCWcqEOvPyj85okp/SvpC7EXj/QJszcBhHMKngd07PHv" +
                                                              "UYRAA3k0R10aQeGkYWWohkt5GzfztGVMuTMiWrvE83wIi5Z8XvY6OSp+cXWh" +
                                                              "ieMiGd0YZz4tRLW4a8x8/Ne/+NPtwtz5wtLh6QjGGB/wgBkK6xaw1eWG7R6L" +
                                                              "MaB798zo109fO7ZPxCxQrC63YR+OEQAxcCGY+SuvHn7nvSvnLgfdOOdQzbNx" +
                                                              "aIpyBSVxnjRXURJ2W+ueB8AQUwyjpu9+HeJTTao0rjFMrH92rNn4wl9PdMo4" +
                                                              "0GAmH0Yb5hbgzt+yjTz4+oF/9AgxAQWLsWszl0wi/DxX8lbLotN4jtxDby1/" +
                                                              "7BJ9HGoF4LOtzjABuUFhg6DQfDH0ZoIT625I1l2cv1O4dJOguVWMd6A5BCcR" +
                                                              "a5txWGN7U6M4+zwtVUw5efn9tr3vv3Rd6FLck3kjYYSaAzL4cFibA/GL/NC1" +
                                                              "ndppoLvj4s7Pd2oXb4DEcZCoADjbuyzA0FxR3DjUdQ2/+dnLCw++WUOCQ6RZ" +
                                                              "M2hiiIoUJE0Q+8xOA/zmzE/dI10/1QhDp1CVlChfMoHmX1HesYMZkwtXzPxo" +
                                                              "0Q+2PHn2iohBU8pY6hX4MRzWF6JRfOr9ZdEbjUUSLLK8Uuciuq5zR2fPJnY9" +
                                                              "sVH2F93F3cAgNLvP/Opfb4TO/O61MmWniRvmxzU2yTTPnrW4ZVGlGBFNnYtW" +
                                                              "77af+v2P+1LbbqZI4FzPHGUA/68AJforg77/KJeO/nnJnrvTB28C71f4zOkX" +
                                                              "+fTI+dfuW6ucCooOVkJ9SedbzDTgNSxsajFo1XVUE2faRNivLgRAFzp2JXz7" +
                                                              "nQDoL4+5ZWKngGSVWKtk9d4qa5/F4TOQsClWaDBEzShqGtDHY9m4DQVezQCe" +
                                                              "Tzpt8G2jB5XjfaN/kCF4SxkGSbfgqfDX9r596A3hrEaMjoKJPJEBUeQpVZ1S" +
                                                              "9w/hE4Dvv/GLx8YJ2U52R5yedmWhqcU0tMi6KrfQYgXCR7rfm/jW1WekAv6m" +
                                                              "30fMjs9+9cPQiVmZT/JmtLrkcuLlkbcjqQ4O+/F0q6rtIjiG/njhyE+eOnIs" +
                                                              "6DhpmJM6QDOLF1wYKLR284uNLk9678MdPz3ZXTMEeTpMGrO6ejjLhhPFsdpg" +
                                                              "Z+MeL7hXKTdynTOjxTkJ9Ocx7pM47JbPd/2X8IoTEVPMjxSCfB6uLYbvRifI" +
                                                              "N958flRi9eWAr17OwzZ86nYllDAyIaffdkumXSWBpnCAu1pdhnIlLUjGHVfj" +
                                                              "T8zzDNW+IW4YGqO635H4N+2xrvERWLcjX3IijokiN2/dSqxVDHSsytrDOBzl" +
                                                              "pB3Rx2QKtEuKyqfnsmKNqpekgt+CX/4ILNiNa0vgu8Mxw46bt2Al1ipWeqzK" +
                                                              "2jdxmOWkkRueRs81w+n/hRlyiLUl91BskRaXvAGTb22UZ892NC46e//bolMo" +
                                                              "vFlpBfRPZjXNA0NeSKo3LZZUhV6tsmM0xc93oA7PcU+GoIBRKPBtyfRdTpZW" +
                                                              "YYLbgnzw8jwN99FyPCAdRi/leeix/ZQAAuLXS3eBk2aXDjaVD16S50E6kODj" +
                                                              "9808IH1irvcCW6G4WqC3zym5QGkbKgJhwVyB4Ok7VxfVT/EuNF9isvJtaEy5" +
                                                              "cHbHzgeu3/mEvAAqGp2ZQSktUFjkXbTQdq2qKC0vq377uhvtzzWtyde7Lnlg" +
                                                              "N5mWeiIeoCdgYuwt8d2O7L7CJemdc1te+vnx+regUu8jAQr4vs/zJlK+doMr" +
                                                              "Vhb63X3R0gIKLaq4tg2s+8b03RuSf/ut6PCJLLjLKtPHlMtP7v/lqcXn4HrX" +
                                                              "MkzqoJSz3DhpVu17p/XdTJm0xkmbag/m4IggRaVaUXVuxzShmMTCLo452wqz" +
                                                              "+PqAk97SjqP0pQvchqaYtc3I6gmnvre4M0UvaZ3Ua86apo/BnfF0ZSmJxOgN" +
                                                              "CNtYdMQ08w1ZQ50p8CJdHppxfEU84nDpPxJ0gL4nGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
