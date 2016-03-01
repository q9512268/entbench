package org.apache.batik.bridge.svg12;
public class SVG12URIResolver extends org.apache.batik.bridge.URIResolver {
    public SVG12URIResolver(org.w3c.dom.svg.SVGDocument doc, org.apache.batik.bridge.DocumentLoader dl) {
        super(
          doc,
          dl);
    }
    protected java.lang.String getRefererBaseURI(org.w3c.dom.Element ref) {
        org.apache.batik.dom.AbstractNode aref =
          (org.apache.batik.dom.AbstractNode)
            ref;
        if (aref.
              getXblBoundElement(
                ) !=
              null) {
            return null;
        }
        return aref.
          getBaseURI(
            );
    }
    protected org.w3c.dom.Node getNodeByFragment(java.lang.String frag,
                                                 org.w3c.dom.Element ref) {
        org.apache.batik.dom.xbl.NodeXBL refx =
          (org.apache.batik.dom.xbl.NodeXBL)
            ref;
        org.apache.batik.dom.xbl.NodeXBL boundElt =
          (org.apache.batik.dom.xbl.NodeXBL)
            refx.
            getXblBoundElement(
              );
        if (boundElt !=
              null) {
            org.apache.batik.dom.xbl.XBLShadowTreeElement shadow =
              (org.apache.batik.dom.xbl.XBLShadowTreeElement)
                boundElt.
                getXblShadowTree(
                  );
            org.w3c.dom.Node n =
              shadow.
              getElementById(
                frag);
            if (n !=
                  null) {
                return n;
            }
            org.w3c.dom.NodeList nl =
              refx.
              getXblDefinitions(
                );
            for (int i =
                   0;
                 i <
                   nl.
                   getLength(
                     );
                 i++) {
                n =
                  nl.
                    item(
                      i).
                    getOwnerDocument(
                      ).
                    getElementById(
                      frag);
                if (n !=
                      null) {
                    return n;
                }
            }
        }
        return super.
          getNodeByFragment(
            frag,
            ref);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YXWwbxxFeUv+0ZP1FkmvFsi3TKqw4vCpKGrRy01iMZcuh" +
                                                              "JFayjUZOTS/vluTZx7v13VKilKS2U7Qx+hAEtuO6AawnB0UDNwmKBu1LDBUF" +
                                                              "mgRpGtgN2vygaYu+9M9A/BK3cP9m9+54xyOpNC8lcMvj7uzszsy338zyyg3U" +
                                                              "YJlokGJdwTG2RIkVS/L3JDYtosQ1bFkHoDclf/sP507e+lXL6TBqnEfrc9ia" +
                                                              "krFFJlSiKdY82qTqFsO6TKxpQhQ+I2kSi5gLmKmGPo96VGsyTzVVVtmUoRAu" +
                                                              "cAibCdSJGTPVdIGRSUcBQ5sTYjeS2I20OygwlkCtskGXvAkbyybEfWNcNu+t" +
                                                              "ZzHUkTiGF7BUYKomJVSLjRVNdBc1tKWsZrAYKbLYMe0+xxH7E/dVuGHw5faP" +
                                                              "bz+T6xBu6Ma6bjBhojVLLENbIEoCtXu9ezSSt06gr6O6BFrnE2YomnAXlWBR" +
                                                              "CRZ17fWkYPdtRC/k44Ywh7maGqnMN8TQ1nIlFJs476hJij2Dhmbm2C4mg7Vb" +
                                                              "Sta64Q6Y+Oxd0vnvHOn4YR1qn0ftqj7HtyPDJhgsMg8OJfk0Ma3dikKUedSp" +
                                                              "Q8DniKliTV12ot1lqVkdswJAwHUL7yxQYoo1PV9BJME2syAzwyyZlxGgcn41" +
                                                              "ZDScBVt7PVttCyd4PxgYUWFjZgYD9pwp9cdVXRE4Kp9RsjH6MAjA1KY8YTmj" +
                                                              "tFS9jqEDddkQ0bCeleYAfHoWRBsMgKApsFZDKfc1xfJxnCUphjYE5ZL2EEi1" +
                                                              "CEfwKQz1BMWEJojSxkCUfPG5Mb3r6cf0fXoYhWDPCpE1vv91MGkgMGmWZIhJ" +
                                                              "4BzYE1uHExdw76tnwgiBcE9A2Jb58eM3H9w5sPq6LdNfRWYmfYzILCVfTq+/" +
                                                              "dmd8xxfq+DaaqWGpPPhllotTlnRGxooUmKa3pJEPxtzB1dmfP3LqBfLXMIpM" +
                                                              "okbZ0Ap5wFGnbOSpqhFzL9GJiRlRJlEL0ZW4GJ9ETfCeUHVi985kMhZhk6he" +
                                                              "E12NhvgNLsqACu6iCLyresZw3ylmOfFepAihJnhQKzyfRfZHfDNkSDkjTyQs" +
                                                              "Y13VDSlpGtx+HlDBOcSCdwVGqSGlAf/H7x6J3S9ZRsEEQEqGmZUwoCJH7EEp" +
                                                              "bapKlkjWQnbkHmnu0N6Rew7OTjrnwYxx4NH//5JF7oXuxVAIAnRnkB40OFn7" +
                                                              "DE0hZko+Xxjfc/PF1Js29PhxcfzHUAzWjdnrxsS6MXvdmFg3FlwXhUJiuTv4" +
                                                              "+jYWIJLHgROAlFt3zH1t/9Ezg3UAQrpYD2HgokMVSSrukYfL+Cn5yrXZW2+/" +
                                                              "FXkhjMLAL2lIUl6miJZlCjvRmYZMFKCqWjnD5U2pdpaoug+0enHx9KGTnxP7" +
                                                              "8JM/V9gAvMWnJzlll5aIBg99Nb3tT/3p45cuPGF4x78sm7hJsGImZ5XBYHCD" +
                                                              "xqfk4S34ldSrT0TDqB6oCuiZYThOwHwDwTXK2GXMZWpuSzMYnDHMPNb4kEuv" +
                                                              "EZYzjUWvR6CuU7zfASFex49bPzw7nfMnvvloL+Vtn41SjpmAFSITfGmOXnr3" +
                                                              "l38eFe52k0a7L9vPETbmIyqurEtQUqcHwQMmISD324vJc8/eeOqwwB9IbKu2" +
                                                              "YJS3cSAoCCG4+Zuvn3jvdx9efifsYZZBpi6koegplozk/SiyhpEc595+gOg0" +
                                                              "OPkcNdGDOqBSzag4rRF+SP7Zvn3klb893WHjQIMeF0Y7P1mB1/+ZcXTqzSO3" +
                                                              "BoSakMwTreczT8xm725P827TxEt8H8XT1zd99zV8CfIAcK+lLhNBp2Hhg7Cw" +
                                                              "fAND/ZweFkflmGLkOSVwQnjIkAt54tQ1IDNUi0JcwYSBgYYEDu4VkyTRjnIf" +
                                                              "iuWQGPsib6KW/zyVH1lfjZWSn3nno7ZDH129KRxQXqT54TOF6ZiNWN5sL4L6" +
                                                              "viB37cNWDuTuXZ1+tENbvQ0a50GjDKxszZh852Vgc6Qbmt7/6c96j16rQ+EJ" +
                                                              "FNHAxAkszi1qgQNDrBxwb5F++UEbL4vN0HQIU1GF8TxEm6sHf0+eMhGu5Z/0" +
                                                              "/WjX91Y+FDi1gdnvTBc/hngzXAKs+DQGs6IfsGUaTLSpVuEiiq7LT55fUWae" +
                                                              "H7HLi67yYmAP1Lo/+PW/fhG7+Ps3qmSYFmbQuzWyQDTfmmFYcmtFYpgSdZ1H" +
                                                              "avdfv1X3wdkNrZU5gWsaqMH4w7UZP7jAa0/+ZeOBB3JHPwXZbw44Kqjy+1NX" +
                                                              "3tg7JJ8Ni9LU5vmKkrZ80pjfZbCoSaAG17lZvKdNwHewFNoeHrIheEad0I5W" +
                                                              "J1yBCtHu4M1Ol9xaqGkwwBdRAvzWtobOwLENOdndYYBuP0vwyxMcerGLr65x" +
                                                              "3B/lzVcY6swSZuckcxwiDMWGq7ZDnAle0Mfsgl4MjPFm1t77A//b+eIdcdE9" +
                                                              "VTK5mw9F4Rl3TB5fw428OVDprVpTA1Y7nMp/HuHNI0J1bg3fHOONbPtmGiA+" +
                                                              "vjRh4qyfdDv8Lucinm+UT++bIigMlnqclTZUXDrti5L84kp7c9/Kwd+IcqN0" +
                                                              "mWmFRJ0paJoPzH5gN1KTZFRhYKvNyVR8AWVvWrMMZahBfIvdm/akBYb6akyC" +
                                                              "BG6/+OWXHJ/55UGv+PbLPc5QxJMDVfaLX+QkQ3Ugwl9PUTcg22pZ4HNpMVRJ" +
                                                              "3CJkPZ8UMh9TbyujN/HngUtFBfvvg5T80sr+6cdufv55u6qSNby8LC6bcHe2" +
                                                              "C7wSnW2tqc3V1bhvx+31L7dsDzvY7LQ37J2Ofh9w48AKlCNnY6DksKKlyuO9" +
                                                              "y7uuvnWm8TrkisMohIE+Dvuu7vY9FeqWAnDt4YQ/R/j+ghLV0Fjkj0ff/vv7" +
                                                              "oS6RFJF93RhYa0ZKPnf1g2SG0ufCqGUSNUBqI8V5FFGth5b0WSIvQPpuLujq" +
                                                              "iQKZVACwaaOgl/5nWM9hjjkPCc84Dm0r9fKqnKHBin8QqtxUoF5YBLrj2gXF" +
                                                              "BxJAgVL/aJHfv6tYBbEZufSPk996dwaOYdnG/dqarEK6lEv8f2N4yaXDprb/" +
                                                              "wCcEz7/5w0PKO/g3Q11x50q/pXSnp7Roj9WlElOUOrLhbwgYUCqI5YJQfJY3" +
                                                              "54tcgqHQMKX/BZdQTei/FAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Vn7s979oLOsz2CAAAA==");
}
