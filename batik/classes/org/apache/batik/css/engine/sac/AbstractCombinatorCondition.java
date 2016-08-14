package org.apache.batik.css.engine.sac;
public abstract class AbstractCombinatorCondition implements org.w3c.css.sac.CombinatorCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected org.w3c.css.sac.Condition firstCondition;
    protected org.w3c.css.sac.Condition secondCondition;
    protected AbstractCombinatorCondition(org.w3c.css.sac.Condition c1, org.w3c.css.sac.Condition c2) {
        super(
          );
        firstCondition =
          c1;
        secondCondition =
          c2;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractCombinatorCondition c =
                                                    (org.apache.batik.css.engine.sac.AbstractCombinatorCondition)
                                                      obj;
                                                  return c.
                                                           firstCondition.
                                                    equals(
                                                      firstCondition) &&
                                                    c.
                                                      secondCondition.
                                                    equals(
                                                      secondCondition);
    }
    public int getSpecificity() { return ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                            getFirstCondition(
                                              )).
                                    getSpecificity(
                                      ) +
                                    ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                       getSecondCondition(
                                         )).
                                    getSpecificity(
                                      ); }
    public org.w3c.css.sac.Condition getFirstCondition() {
        return firstCondition;
    }
    public org.w3c.css.sac.Condition getSecondCondition() {
        return secondCondition;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwUxxWfO38bf4P5xoAxUAO5gySkoiY04NjB5GwsTCzV" +
       "NJi5vTnf4r3dZXfOPpu6DZESSNUgQgihVeL+URApJQFFjdq0JXKFmoQmrZSE" +
       "Nk0rSNVWKm2KGlQlrUrb9L3Zvdu9vQ8LqelJO7c3897Me2/e+703c2evkxLT" +
       "IE1M5QE+pjMz0KHyXmqYLNKuUNPcCX2D0tNF9G+7r/Vs8JPSAVITo2a3RE3W" +
       "KTMlYg6QRbJqcqpKzOxhLIIcvQYzmTFCuaypA6RRNrviuiJLMu/WIgwJ+qkR" +
       "IvWUc0MOJzjrsifgZFEIJAkKSYKbvcNtIVIlafqYQz7XRd7uGkHKuLOWyUld" +
       "aC8docEEl5VgSDZ5W9Igq3VNGRtSNB5gSR7Yq6y3TbAttD7LBM3naz++eSRW" +
       "J0wwk6qqxoV65g5masoIi4RIrdPbobC4uY98mRSFyAwXMSctodSiQVg0CIum" +
       "tHWoQPpqpibi7ZpQh6dmKtUlFIiTpZmT6NSgcXuaXiEzzFDObd0FM2i7JK2t" +
       "pWWWik+tDh57enfdi0WkdoDUymofiiOBEBwWGQCDsniYGebmSIRFBki9Cpvd" +
       "xwyZKvK4vdMNpjykUp6A7U+ZBTsTOjPEmo6tYB9BNyMhcc1IqxcVDmX/Kokq" +
       "dAh0ne3oamnYif2gYKUMghlRCn5nsxQPy2qEk8VejrSOLfcDAbCWxRmPaeml" +
       "ilUKHaTBchGFqkPBPnA9dQhISzRwQIOT+XknRVvrVBqmQ2wQPdJD12sNAVWF" +
       "MASycNLoJRMzwS7N9+ySa3+u92w8vF/dqvqJD2SOMElB+WcAU5OHaQeLMoNB" +
       "HFiMVatCx+nsC4f8hABxo4fYovnel27cs6Zp6nWLZkEOmu3hvUzig9LJcM1b" +
       "C9tbNxShGOW6Zsq4+RmaiyjrtUfakjogzOz0jDgYSA1O7Xj1Cw+dYR/4SWUX" +
       "KZU0JREHP6qXtLguK8y4j6nMoJxFukgFUyPtYryLlMF7SFaZ1bs9GjUZ7yLF" +
       "iugq1cRvMFEUpkATVcK7rEa11LtOeUy8J3VCSB08ZAk8S4n1WYwNJ2owpsVZ" +
       "kEpUlVUt2GtoqL8ZBMQJg21jwTB4/XDQ1BIGuGBQM4aCFPwgxuwByUTaIZAp" +
       "aFIpuDkM/k4l3q7FwzIEiWZAZEWEEQLod/r/fcUk2mDmqM8H27PQCw4KxNVW" +
       "TYkwY1A6ltjSceOFwTcsx8Ngsa3HSRsIEbCECAghAiBEwBIiAEIECghBfD6x" +
       "9iwUxnIL2NRhgAfA56rWvge37TnUXAT+qI8Ww44gaXNGnmp3MCQF/IPSuYbq" +
       "8aVX1130k+IQaYCVE1TBtLPZGAJAk4btmK8KQwZzEskSVyLBDGhoEosAjuVL" +
       "KPYs5doIM7Cfk1muGVJpDgM6mD/J5JSfTJ0YPdD/lbV+4s/MHbhkCcAesvci" +
       "4qeRvcWLGbnmrT147eNzxyc0Bz0yklEqh2Zxog7NXu/wmmdQWrWEvjR4YaJF" +
       "mL0C0J1TcAEAzibvGhng1JYCetSlHBSOakacKjiUsnEljxnaqNMj3LZevM8C" +
       "t6jBaG2FZ60dvuIbR2fr2M6x3Bz9zKOFSCR39+nP/urnf7pDmDuVc2pdxUIf" +
       "420unMPJGgSi1Ttuu9NgDOiunOh98qnrB3cJnwWKZbkWbMEWogGTNpj5kdf3" +
       "vff+1ZOX/Y6fc1KhGxqH0GeRZFpPHCLVBfSEBVc4IgFUKjADOk7LAyq4qByV" +
       "aVhhGFv/ql2+7qW/HK6zXEGBnpQnrZl+Aqd/3hby0Bu7/94kpvFJmKodszlk" +
       "Fv7PdGbebBh0DOVIHnh70ddfo89CJgH0NuVxJgDZL8zgF5rP5WQeQszoHZJA" +
       "FoSUNIAgwV1ie9cL4rWivRPtIqYgYmwDNstNd5hkRqKr8hqUjlz+sLr/w1du" +
       "CKUySze3V3RTvc1yRGxWJGH6OV4Y20rNGNDdOdXzxTpl6ibMOAAzSgDd5nYD" +
       "gDWZ4UM2dUnZr398cfaet4qIv5NUKhqNdFIRjqQC4oCZMcDkpP75eywfGC1P" +
       "JbAkyVI+qwP3YXHuHe6I61zsyfj353x34+nJq8IfdWuOBfaGQJrIwF9xAHAg" +
       "4Mw7n/3F6SeOj1olRGt+3PPwzf3ndiX88O/+kWVygXg5yhsP/0Dw7DPz2zd9" +
       "IPgd6EHulmR2agP4dnhvPxP/yN9c+hM/KRsgdZJdcPdTJYEBPQBFppmqwqEo" +
       "zxjPLBit6qgtDa0LvbDnWtYLek5KhXekxvfqXDi3Ep4Vdvyv8OKcj4iX+wXL" +
       "SmxWZ6NHPm5OaqIyHJQyg8uCTmw/h03I8oe787pfR6a4n4Fntb3g6jzi7igo" +
       "bj5uiEaTwXZECsrbV0Bea2ilaFdhc5vl5RyOWYkwnFY5Kad28eKgsPjUporE" +
       "1Lcbhd0BYyPYsmwEyyqGUrTrpiuoOpIcal7mKI7YsyjfqUGceE4+fGwysv3U" +
       "OiswGzIr8Q44aD7/y3+/GTjx20s5CrwKrum3KWyEKS7NinHJDCjoFgcqJ66u" +
       "1Bz9/cstQ1tupQrDvqZp6iz8vRiUWJUfXbyivPbwn+fv3BTbcwsF1WKPOb1T" +
       "frv77KX7VkhH/eL0aAV81qkzk6ktM8wrDQbHZHVnRrAvS7vZTPSqefBssN1s" +
       "Q+6iJqcL+/B1l6dyqCwwmSd5+uxy2/bIOpExEOQCFsiJtY0CGXcEGzBJKdsH" +
       "225m1u3oBX0JCKxeQ46DA4/Yh9Tbe/dIh1p6/2A56bwcDBZd43PBx/vf3fum" +
       "2M5y9J+0EV2+A37mqhbrLFt8Ah8fPP/BB6XFDvwGKG+3T5xL0kdOzH4F05hH" +
       "geBEw/vDz1x73lLAm7M8xOzQsa9+Ejh8zIo4695iWdbVgZvHuruw1MFmP0q3" +
       "tNAqgqPzj+cmfvjcxEG/vTewTllY0xRG1awNhxI50+yWrPc+VvujIw1FnRDL" +
       "XaQ8ocr7EqwrkunPZWYi7NoH56rD8W5barQ5J75VqeJCAHV8usRSuK7BjnZd" +
       "9MfSbo8oTRbB02G7fUeBGMJGy46YfKwFnP+JAmNPYvM1SLVDjPfpTIKSWpL5" +
       "mKBN2puKXxOu9wOcFMn2HaBrs/Dnoy4LPv4pWLARx7BQ6LHN0HPrFszHWsBK" +
       "3yowdgqbSU7qwYKd2fWKY49vflr2wBKs31aq/9btkY+1gM7nC4y9iM13AL/Q" +
       "o3IURI5Bzv4vDJLkZEGBGx08YMzNuma2rkalFyZry+dMPvCuKAnS15dVAOLR" +
       "hKK4S2DXe6lusKgsVK2yCmJdfP0AEu40lRLEDbRCk5ctpgsgfQEmTFjixc0z" +
       "xcmsXDwwO7RuyouQKr2UnJSIbzfdq5xUOnSwqPXiJrkEswMJvv5Uz5+Hfa6S" +
       "jLiwoHG6rU6zuO8oML+JfxJSCSBh/ZcwKJ2b3Naz/8Zdp6w7Ekmh4+M4ywyA" +
       "feu6Jl04Lc07W2qu0q2tN2vOVyxP5aN6S2AncBa4vLsdgE5Hp5rvuT0wW9KX" +
       "CO+d3PjKzw6Vvg2ZdBfxUU5m7so+liX1BFSsu0LZ6Q2KTHGt0db6jbFNa6J/" +
       "/Y04+BIrHS7MTz8oXT794DtH555s8pMZXaQEUi1LivPivWPqDiaNGAOkWjY7" +
       "kiAizCJTJSN31qD/U/yPQdjFNmd1uhdv2Dhpzq4Isu8lKxVtlBlbtIQasbPv" +
       "DKcn4y8OO6YqE7ruYXB6XFXTI1YWwt0AfxwMdet6qmAq/UgXiPBo7rSE7RXx" +
       "is3V/wLunHX+ZRwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
