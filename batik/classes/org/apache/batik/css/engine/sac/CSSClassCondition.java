package org.apache.batik.css.engine.sac;
public class CSSClassCondition extends org.apache.batik.css.engine.sac.CSSAttributeCondition {
    public CSSClassCondition(java.lang.String localName, java.lang.String namespaceURI,
                             java.lang.String value) { super(localName,
                                                             namespaceURI,
                                                             true,
                                                             value);
    }
    public short getConditionType() { return SAC_CLASS_CONDITION;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        if (!(e instanceof org.apache.batik.css.engine.CSSStylableElement))
            return false;
        java.lang.String attr =
          ((org.apache.batik.css.engine.CSSStylableElement)
             e).
          getCSSClass(
            );
        java.lang.String val =
          getValue(
            );
        int attrLen =
          attr.
          length(
            );
        int valLen =
          val.
          length(
            );
        int i =
          attr.
          indexOf(
            val);
        while (i !=
                 -1) {
            if (i ==
                  0 ||
                  java.lang.Character.
                  isSpaceChar(
                    attr.
                      charAt(
                        i -
                          1))) {
                if (i +
                      valLen ==
                      attrLen ||
                      java.lang.Character.
                      isSpaceChar(
                        attr.
                          charAt(
                            i +
                              valLen))) {
                    return true;
                }
            }
            i =
              attr.
                indexOf(
                  val,
                  i +
                    valLen);
        }
        return false;
    }
    public java.lang.String toString() { return '.' + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wcRxmfu4vfdvzIs3nYeThBeXDX0LpScFqaXO3G4eyY" +
                                                              "OI3AIbnM7c3dbby3u9mds88ugTYVSopEFILbhIpYIKVqQW1ToUaAoFVQJdqq" +
                                                              "BaklohTUFAkkwiOiEVL5I5TyfTN7u3t7Z4cgwNLOrWe+75v5Xr/vm33mGqmx" +
                                                              "LdLJdB7lkyazo306H6aWzdJxjdr2XphLKmci9G8Hrw5tDZPaUTI/R+1Bhdqs" +
                                                              "X2Va2h4lK1Xd5lRXmD3EWBo5hi1mM2ucctXQR8ki1R7Im5qqqHzQSDMk2Eet" +
                                                              "BGmnnFtqqsDZgCOAk5UJOElMnCS2PbjcmyDNimFOeuRLfeRx3wpS5r29bE7a" +
                                                              "EofpOI0VuKrFEqrNe4sW2WQa2mRWM3iUFXn0sNbjmGBXoqfCBGueb/3gxqlc" +
                                                              "mzDBAqrrBhfq2XuYbWjjLJ0grd5sn8by9hHyRRJJkCYfMSfdidKmMdg0BpuW" +
                                                              "tPWo4PQtTC/k44ZQh5ck1ZoKHoiT1eVCTGrRvCNmWJwZJNRzR3fBDNqucrWV" +
                                                              "Wlao+Nim2PSZg23fi5DWUdKq6iN4HAUOwWGTUTAoy6eYZW9Pp1l6lLTr4OwR" +
                                                              "ZqlUU6ccT3fYalanvADuL5kFJwsms8Senq3Aj6CbVVC4YbnqZURAOf/VZDSa" +
                                                              "BV0Xe7pKDftxHhRsVOFgVoZC3Dks88ZUPc1JV5DD1bH700AArHV5xnOGu9U8" +
                                                              "ncIE6ZAholE9GxuB0NOzQFpjQABanCybVSja2qTKGM2yJEZkgG5YLgFVgzAE" +
                                                              "snCyKEgmJIGXlgW85PPPtaFtJx/Ud+phEoIzp5mi4fmbgKkzwLSHZZjFIA8k" +
                                                              "Y/PGxON08YsnwoQA8aIAsaT5/heu37u589KrkmZ5FZrdqcNM4UnlfGr+myvi" +
                                                              "G7ZG8Bj1pmGr6PwyzUWWDTsrvUUTEGaxKxEXo6XFS3t++rmHvsv+HCaNA6RW" +
                                                              "MbRCHuKoXTHypqox636mM4tylh4gDUxPx8X6AKmD94SqMzm7O5OxGR8g8zQx" +
                                                              "VWuI/8FEGRCBJmqEd1XPGKV3k/KceC+ahJA6eEgzPF1E/olfTtKxnJFnMapQ" +
                                                              "XdWN2LBloP52DBAnBbbNxVIQ9WMx2yhYEIIxw8rGKMRBjjkLio20WThTzKZK" +
                                                              "LD4yInwJ+ZQWqkcx2sz/0z5F1HfBRCgErlgRBAINcminoaWZlVSmCzv6rj+X" +
                                                              "fF0GGSaGYylOtsDWUbl1VGwdha2jcusobB2t2JqEQmLHhXgE6Xhw2xgAACBw" +
                                                              "84aRA7sOnVgTgYgzJ+aBzZF0TVklinsoUYL2pHKho2Vq9ZUtL4fJvATpoAov" +
                                                              "UA0Ly3YrC5CljDlZ3ZyCGuWVilW+UoE1zjIUlgakmq1kOFLqjXFm4TwnC30S" +
                                                              "SoUMUzY2exmpen5y6ezEw/u+dHuYhMurA25ZA8CG7MOI6S52dwdRoZrc1uNX" +
                                                              "P7jw+FHDw4eyclOqkhWcqMOaYEwEzZNUNq6iF5MvHu0WZm8A/OYUHA/Q2Bnc" +
                                                              "owx+ektQjrrUg8IZw8pTDZdKNm7kOcuY8GZEsLaL94UQFk2Yjyvg6XYSVPzi" +
                                                              "6mITxyUyuDHOAlqIUnH3iHnuVz//4x3C3KWq0uprB0YY7/UhGQrrEJjV7oXt" +
                                                              "XosxoHv37PDXH7t2fL+IWaBYW23DbhzjgGDgQjDzl1898s57V85fDntxzqGU" +
                                                              "F1LQERVdJXGeNM6hJOy23jsPIKEGKIFR0/2ADvGpZlSa0hgm1j9a1225+JeT" +
                                                              "bTIONJgphdHmmwvw5m/bQR56/eDfO4WYkIKV2LOZRybhfYEnebtl0Uk8R/Hh" +
                                                              "t1Z+4xV6DgoFgLOtTjGBtxFhg4jQfCk0ZoITi25UFl2cv0sMwq89gvB2Md6J" +
                                                              "NhHsRKxtxWGd7c+P8hT0NVVJ5dTl91v2vf/SdaFQeVfmD4dBavbKCMRhfRHE" +
                                                              "Lwni105q54DuzktDn2/TLt0AiaMgUQF8tndbgKPFsuBxqGvqfv2TlxcfejNC" +
                                                              "wv2kUTNoup+KPCQNkADMzgEEF81P3Sv9P1EPQ5tQlVQoXzGBPuiq7t2+vMmF" +
                                                              "P6Z+sOSFbU/NXBGBaEoZy/0CP4bDJjckxV9tsDD6Q7JMgkVWzta7iL7r/LHp" +
                                                              "mfTuJ7fIDqOjvB/og3b32V9++Eb07G9fq1J6Grhhflxj40zz7RnBLcvKxaBo" +
                                                              "6zzIenf+6d/9sDu741YqBc513qQW4P9doMTG2ZE/eJRXjv1p2d57coduAfS7" +
                                                              "AuYMivzO4DOv3b9eOR0WPazE+4ret5yp129Y2NRi0KzrqCbOtIiwX+sGQDs6" +
                                                              "djU8UScAotWBt0rsuHA2G+scWb1vjrXP4vAZQI0s426bISpHWeuATh4ppGwo" +
                                                              "82oeaMadTvgTw4eUE93Dv5cxeFsVBkm36OnYV/e9ffgN4a16DA/XRr7QgDDy" +
                                                              "Faw2qfxH8BeC55/44LlxQnaUHXGnrV3l9rWYhxbZMMdFtFyB2NGO98a+efVZ" +
                                                              "qUCw7w8QsxPTX/koenJaJpS8HK2tuJ/4eeQFSaqDwwE83eq5dhEc/X+4cPRH" +
                                                              "Tx89Hna8NMBJDcCZxV0fhtwGb2G50eVJ73u09cenOiL9kKgDpL6gq0cKbCBd" +
                                                              "Hqx1diHl84J3m/JC1zkzWpyT0MYSyH0Shz3y/e7/EF9xIm6K+UE3yhfg2lJ4" +
                                                              "epwo77n1BJmNNZAEYXGQcKlqLsBefOIOJZo28lH82gBW9WqmPUcGTeAA17Wa" +
                                                              "POVKTpCMOq7Gn6TvHWp+XcowNEb1oCPx35zPusb/wLoduLYMnkHHRIO3bt3Z" +
                                                              "WOcw0PE51h7F4Rgn9dzwNSueGR75b5ihyEl7xVUKC/zSii848quD8txMa/2S" +
                                                              "mQfeFnXO/TLQDNCVKWiaL4f8+VRrWiyjCrWaZb9jip+vQRW5yU2PQ+2lijj/" +
                                                              "Kck0zcnyOZig4ZUvfp4zcKWqxgPSYfRTPgGAH6SECBa/frpznDR6dLCpfPGT" +
                                                              "fAukAwm+ftssZVPPv3Gzdb9Gui4phipbKBEFi24WBb6eaW0Z9IsveSV0LMhv" +
                                                              "eXDhndk19OD1u56UNxhFo1NTKKUJMFFeptyWYfWs0kqyanduuDH/+YZ1Jahu" +
                                                              "lwf2Mmm5L9zjkOkmRt6yQHtvd7td/jvnt730sxO1b0GR2U9CFKBpv+87mvxo" +
                                                              "BHeEAvRq+xOV2A/tlbh39G54YvKezZm//kZ0p06tWDE7fVK5/NSBX5xeeh7u" +
                                                              "J00DpAaqECuOkkbVvm9S38OUcWuUtKh2XxGOCFJUqpUVlvmYJBQzWNjFMWeL" +
                                                              "O4v3X07WVBbLyq8G0MlPMGuHUdDTTmlq8mbKPjGWuq6CaQYYvBlfQ5GVUCx7" +
                                                              "h0gyMWiapV6i9kNTgEWuOi7j+IJ4xeHivwD23Ld95RcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "s/sLRyHnB+BzClz/nV2ZubOO7QJ7V2tvlX/kYJl33eQUSOjTyG5tNw/bZi7l" +
       "0by9nDU/uXVTdvtTIPODvEYFHKphC2Y+MBaCEDOly/vSWVCzAp9cXpq1g2y4" +
       "lAus5ORb99duGCqv31LlC9kdh/lFOqA+fN8/fOAr73/8G8B/feh0nNkWuO1I" +
       "Eo6irGR+9wvPPfiKZ7/5vhy0AGKxv/g7tW9mUsmbaZc1RNZ099W6P1NrltcB" +
       "pBCEwxxnFDnT7OZhO/YNC8BxvFcPwk/d9Y3VR771qW2tdzJGTxAr7332l36w" +
       "+8yzO0cq7MevKXKP8myr7HzSt+9Z2IcevdkoOUfnHz/z1B9+4qn3bGd11/F6" +
       "EQevQ5/6y//6yu6Hv/ml65Qmt5rOFut+JMeGt9/TrQS95v6HLC0UZC1NE0uN" +
       "KrEqx2kvKNsLhdYxZd6eF0l3JnU8YU6ViYqyWVC9crMn2sOaVJZFcVOOGpYc" +
       "1OuRRi/YmePinR4p6j130Ruw3oQr0Q4jNJ0OO+nLnocJK9PRaabTXK3WBmXg" +
       "LIn2UHqj0qNaVA5rfEXS1iOS8jmlUENjdO7DsVUuW4RnJaRM9mWsZq42QuqU" +
       "i9VuVeBSuZ8sZR+Zuzo5sCSjQdS7/hoN2/xYYOgePC2UMF32gjnCCoheMQel" +
       "uYya07nVLuMc5qC6UbKGSCRJ4Xwyra+M0rTWs1DP87rpZNYerhBcCTHCsu1O" +
       "6HlBm9daVHOFMn0KN4d2a4aMxaVkbdojw+pQSjQlVWWalNfuDPWRhojXBNxR" +
       "XapXZKOB38E9f6RUAg7hJgJiTblh2WA6c7sYjMSlRWBzx1NbGBEpIlzWEs+U" +
       "rLSNNT3fx3TVQ+bRQuSWS7Jf1HwZDey6uGno3c102u+vWgt1OFNlQx5YQ1kr" +
       "Ym7EhWPOqYwnId2CV5UKP9FRaVXinUHXMeiSwrZowp/GrZHF9dd8fzRNp2UV" +
       "a4+8SPI5ljMFpwA0QsYzXkPKqoG2OUYeeFVjVOk2GWrNETRDN51NVVnwXGPs" +
       "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" +
       "IgAA");
}
