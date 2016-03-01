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
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYe2wUxxmfO7+NwS8wFIIBY5Bwktu6hNLItI25YDCc8ckm" +
                                                              "qDVNjrm9Od/ivd1ld84+OyWEVAkof1AUHEqrYEUKaZsIQlQ1atUqyFWrJlGa" +
                                                              "ImjU5qEmrfpH0gdS6B+hFW3Tb2b2dXsPivJHT7q5vZnv+2a+1+/7Zs9dRTWW" +
                                                              "iboMrKVwhE4bxIrE2XMcmxZJRVVsWXtgNiE//seTh6//puFIGNWOoUUZbA3J" +
                                                              "2CIDClFT1hhaqWgWxZpMrN2EpBhH3CQWMScxVXRtDC1RrMGsoSqyQof0FGEE" +
                                                              "e7EZQ62YUlNJ5igZtAVQtCrGTyPx00j9QYK+GGqSdWPaY1hewBD1rTHarLef" +
                                                              "RVFL7ACexFKOKqoUUyzalzfR7YauTo+rOo2QPI0cUDfZhtgZ21Rkhq4Xmz++" +
                                                              "cSLTws3QjjVNp1xFa4RYujpJUjHU7M1uU0nWOogeQlUxtMBHTFF3zNlUgk0l" +
                                                              "2NTR16OC0y8kWi4b1bk61JFUa8jsQBStKRRiYBNnbTFxfmaQUE9t3TkzaLva" +
                                                              "1dZxd0DFJ2+XZr/1QMsPqlDzGGpWtFF2HBkOQWGTMTAoySaJafWnUiQ1hlo1" +
                                                              "cPgoMRWsKjO2t9ssZVzDNAch4JiFTeYMYvI9PVuBJ0E3MydT3XTVS/Ogsv/V" +
                                                              "pFU8Drp2eLoKDQfYPCjYqMDBzDSG2LNZqicULcXjqJDD1bF7FxAAa12W0Izu" +
                                                              "blWtYZhAbSJEVKyNS6MQfNo4kNboEIImj7UyQpmtDSxP4HGSoGhZkC4uloCq" +
                                                              "gRuCsVC0JEjGJYGXlge85PPP1d1bjj+o7dDCKARnThFZZedfAEydAaYRkiYm" +
                                                              "gTwQjE09sVO44+VjYYSAeEmAWND86OvX7rmjc/5VQbOiBM1w8gCRaUI+m1x0" +
                                                              "+bbohrur2DHqDd1SmPMLNOdZFrdX+vIGIE2HK5EtRpzF+ZFffvXh58lfw6hx" +
                                                              "ENXKuprLQhy1ynrWUFRibicaMTElqUHUQLRUlK8Pojp4jikaEbPD6bRF6CCq" +
                                                              "VvlUrc7/g4nSIIKZqBGeFS2tO88Gphn+nDcQQnXwRU3wXYnEh/9SZEkZPUsk" +
                                                              "LGNN0XQpbupMf+ZQjjnEgucUrBq6lIT4n7izN7JZsvScCQEp6ea4hCEqMkQs" +
                                                              "SrJlSUQbhxNKFpal6Ogowwii0VGiEpYFERZ8xv9n2zyzRvtUKASOui0IEypk" +
                                                              "2A5dTREzIc/mtm679kLidRGCLG1sO1L0Odg7IvaO8L0jsHdE7B2BvSPFe6NQ" +
                                                              "iG+5mJ1BxAV4dQLwAQC6acPo/Tv3H+uqgoA0pqrBJYx0fVHBinpA4qB/Qj53" +
                                                              "eeT6pTcanw+jMGBNEgqWVzW6C6qGKHqmLpMUwFa5+uFgqFS+YpQ8B5o/PXVk" +
                                                              "7+HP8nP4CwETWAMYxtjjDL7dLbqDAFBKbvPRDz++cOqQ7kFBQWVxCmIRJ0OY" +
                                                              "rqCDg8on5J7V+KXEy4e6w6gaYAugmmLwIqBgZ3CPAqTpc1Cb6VIPCqd1M4tV" +
                                                              "tuRAbSPNmPqUN8Mjr5U/LwYXL3Dyr8vORf7LVjsMNi4VkcpiJqAFrwpfHDXO" +
                                                              "vPXrP2/k5nYKSLOv8o8S2ucDLSasjcNTqxeCe0xCgO73p+Mnn7x6dB+PP6BY" +
                                                              "W2rDbjZGAazAhWDmR189+Pb77519M+zFLIWqnUtCA5R3lWTzqLGCkizOvfMA" +
                                                              "6LF0YVHTfZ8GUamkFZxUCUuSfzWv633pb8dbRByoMOOE0R03F+DNf2Yrevj1" +
                                                              "B653cjEhmRVdz2YemUDydk9yv2niaXaO/JErK7/9Cj4DNQFw2FJmCIfWMLdB" +
                                                              "mGu+DHowzsnqa0TUVza/ibv0Lk4j8XEjMwfnRHztC2zotvypUZh9vtYpIZ94" +
                                                              "86OFez+6eI3rUth7+SNhCBt9IvjYsC4P4pcGYWgHtjJAd9f87q+1qPM3QOIY" +
                                                              "SJQBaK1hE/AwXxA3NnVN3Ts/+3nH/stVKDyAGlUdpwYwT0HUALFPrAxAad74" +
                                                              "8j3C9VP1MLRwVVGR8szaq0r7cVvWoNzyMz9e+sMt35t7j4eciLEVNjv/s54N" +
                                                              "PW7s8U9tsNj5Y69AgolWlutHeC919pHZudTws72ia2grrPHboIU9/9t//ypy" +
                                                              "+g+vlSgYDVQ37lTJJFF9e1bDlmuKMH6It2sePm2+cr3q3SeWNRXDO5PUWQa8" +
                                                              "e8qDd3CDVx75y/I9X8rsvwXcXhUwVFDkc0PnXtu+Xn4izDtOAdlFnWohU5/f" +
                                                              "ZLCpSaC11phabGYhD98u17WtzGWr4dtju7anNHaWiAoXkcqxVsjOPRXW9rJh" +
                                                              "GBJvnLhFn2M/y2Wfk9nVcDSXtGjcVLKAzJN243qh4/rBX9TN3Os0paVYBOUu" +
                                                              "a+jST3Z8kOAOq2cR4ZrJFw395riv7LQI/T+BTwi+/2FfdnQ2IVrAtqjdh652" +
                                                              "G1HDYFmxocLNsVAF6VDb+xNPfXheqBBs1APE5Njs459Ejs+KbBG3mbVFFwo/" +
                                                              "j7jRCHXYsC/PE6jCLpxj4IMLh376/UNHw7ajtlNUA8hkUteNIbfl6giaXZy1" +
                                                              "tvfMPw8/9tYw9AiDqD6nKQdzZDBVGLF1Vi7p84N3AfLi1z41szlFoR7DxrC7" +
                                                              "2RAXz1v+N7BkE/18epcb2O1saRl8e+3A7r31nCjHGoj7QK1rZ+3w1EY5ktKz" +
                                                              "Ebvv9cqdUSFpONkEOCSLqZzhJF+xXct+7vc9Y4rqkrquEqwFHcf+pn22VD+1" +
                                                              "LZudchG1DRK9dVuWY61gjm9UWHuUDQ9RtIjhi0FkaGxkhU7fzGZVilYU6EF7" +
                                                              "Hf7U9mpjS8vhu9NWeuet26scawWbzFZYO8WGb1JUT3VfA+YpfeLWlc4zlCy6" +
                                                              "2bHOZVnR+ybxjkR+Ya65funcfb/jtwv3PUYT4HY6p6o++PBDSa1hkrTCtWgS" +
                                                              "fZvBf85AFb3JzRMcDiM//1OC6WmKVlRggp5dPPh5nqFocSkekA6jn/K70OkG" +
                                                              "KSGd+a+f7jmKGj062FQ8+EnOgXQgYY/nDQdaNt/spt0PZdEEvQNOyYeK20Pu" +
                                                              "9iU3c7uvH1xbUPn4m0enNOTEu0co23M7dz947fPPimuYrOKZGSZlARQEcSN0" +
                                                              "m6Y1ZaU5smp3bLix6MWGdU6lahUH9lJnhS+++yGRDRZ7ywN3FKvbvaq8fXbL" +
                                                              "xTeO1V6BGrsPhQAN2vf53vuJl1xw0clBR7cvVqr0QUvJr099jX/af+kf74Ta" +
                                                              "eOuNRLHsrMSRkE9efDeeNozvhFHDIKqBQkzyY6hRse6d1kaIPGkWVNLapJ7T" +
                                                              "3JeUi1iiYJa03DK2QRe6s+waT1FXcbdQ/GoDbiVTxNzKpNuVuaDNzBmGf5Vb" +
                                                              "lggEZZaGkEzEhgzDbpPCf+eWNwyOB/McR/8L1d1qr14YAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KfUZtiMAAA==");
}
