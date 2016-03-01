package edu.umd.cs.findbugs.detect;
public class BadUseOfReturnValue extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public BadUseOfReturnValue(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    boolean readLineOnTOS = false;
    boolean stringIndexOfOnTOS = false;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { stringIndexOfOnTOS =
                                                              false;
                                                            readLineOnTOS =
                                                              false;
                                                            super.visit(obj);
                                                            bugAccumulator.
                                                              reportAccumulatedBugs(
                                                                );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKEVIRTUAL &&
                                            "indexOf".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "java/lang/String".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "(Ljava/lang/String;)I".
                                            equals(
                                              getSigConstantOperand(
                                                ))) { stringIndexOfOnTOS =
                                                        true; } else
                                          if (stringIndexOfOnTOS) {
                                              if (seen ==
                                                    IFLE ||
                                                    seen ==
                                                    IFGT) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "RV_CHECK_FOR_POSITIVE_INDEXOF",
                                                        LOW_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                              }
                                              stringIndexOfOnTOS =
                                                false;
                                          }
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            "readLine".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "()Ljava/lang/String;".
                                            equals(
                                              getSigConstantOperand(
                                                )) &&
                                            getClassConstantOperand(
                                              ).
                                            startsWith(
                                              "java/io") &&
                                            !"java/io/LineNumberReader".
                                            equals(
                                              getClassConstantOperand(
                                                ))) {
                                          readLineOnTOS =
                                            true;
                                      }
                                      else
                                          if (readLineOnTOS) {
                                              if (seen ==
                                                    IFNULL ||
                                                    seen ==
                                                    IFNONNULL) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "RV_DONT_JUST_NULL_CHECK_READLINE",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                              }
                                              readLineOnTOS =
                                                false;
                                          }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "57fCcvjWOYpb92lYoRixGaww6tFXQHclivPe6MFhP5UMZ+5bMxjm22w4DiFu" +
       "4ckBQ3Ki66uuIU4UNQRbPvqpqDxD0ZwCTxGsN16Y9wAqHu2kc6fqKhec2vE2" +
       "Ty65h7UaSBNJW1W93ZtnXm6YJKlwwWtELycqxncpair+TAJXPzHh/J8RKOeA" +
       "5wIoFM53pl7o71FU7UJTFJZ8289BBXW2wZowejdfgCXYZNMXjaz3rynY9U0B" +
       "l6wHkiDDQanZwrnWzUzIXwJyxp13s/LoqRrLfdmWP19nM6MtHrDj0vlT2/r3" +
       "Xf/sU+LeDjlieppRmQXFXDwh5LLrsqLUsrTKt666MftC1YpsHWoQDLvRtsjj" +
       "xl3gjwbzl6bApdZqy91t3z298eWfHS5/E9qXnSiEwX478y8LGcOGsrYzlt+0" +
       "QCXit+2OVd+c2rQm+dff8OsYEk3O4uLwcBl67J3eC+Mf38PfS8sUVv/5LWbL" +
       "lDZEpAnT1wHNZq6MWaPA9eCorza3yl55oOnPbwDz38bgqjpJzE7d1mReX6Dy" +
       "uSu+d/RsQbINI4Dgrnia5JRIP0z74JvxWJ9hOP1x+JrBY1opnI7YeIlP2XD5" +
       "v/UYbfTJGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wsV12f+2vvve2l9N7eQlsrfd+C7eJvdnb2maKyOzv7" +
       "mJ3Zmd3ZmdlZkMs8d2Z33s/dxSqQaAkkQKRFNFD/ECKSQomKjyimxigQiAmG" +
       "+EoEYkxEkYTGiEZUPDP7+/329/vde1sbjZvM2bPnnO/3fJ+fc+acfe470Nkw" +
       "gAqea63nlhvta6tof2FV9qO1p4X7BFlhpCDUVMySwnAC2q4qD3/24ve+/0Hj" +
       "0h50bgbdKTmOG0mR6TrhWAtdK9FUErq4a8UtzQ4j6BK5kBIJjiPTgkkzjJ4g" +
       "oVcdI42gK+ShCDAQAQYiwLkIcHM3ChC9WnNiG8soJCcKfeinoTMkdM5TMvEi" +
       "6KGTTDwpkOwDNkyuAeBwS/abB0rlxKsAevBI963O1yj8TAF++hfedunXb4Iu" +
       "zqCLpsNm4ihAiAhMMoNuszVb1oKwqaqaOoPucDRNZbXAlCxzk8s9gy6H5tyR" +
       "ojjQjoyUNcaeFuRz7ix3m5LpFsRK5AZH6ummZqmHv87qljQHut6103WrYSdr" +
       "BwpeMIFggS4p2iHJzUvTUSPogdMURzpeGYABgPS8rUWGezTVzY4EGqDLW99Z" +
       "kjOH2SgwnTkYetaNwSwRdO8NmWa29iRlKc21qxF0z+lxzLYLjLo1N0RGEkGv" +
       "PT0s5wS8dO8pLx3zz3eGb3r/O5yes5fLrGqKlcl/CyC6/xTRWNO1QHMUbUt4" +
       "2+Pkh6W7Pv+ePQgCg197avB2zG//1ItvfuP9L3xxO+aHrzOGlheaEl1VPi7f" +
       "/tXXYY81bsrEuMVzQzNz/gnN8/BnDnqeWHkg8+464ph17h92vjD+E/Gdn9K+" +
       "vQdd6EPnFNeKbRBHdyiu7ZmWFnQ1RwukSFP70K2ao2J5fx86D+qk6WjbVlrX" +
       "Qy3qQzdbedM5N/8NTKQDFpmJzoO66ejuYd2TIiOvrzwIgs6DB7oNPPdB20/+" +
       "HUEabLi2BkuK5JiOCzOBm+kfwpoTycC2BqyDYJLjeQiHgQLnoaOpMRzbKqyE" +
       "u05ViwAZ3JJULtRofayB9HB4yYq1/YzG+/+aaJVpfCk9cwY443WnocACWdRz" +
       "LVULripPxy38xc9c/fLeUWoc2CqC9sG8+2DefSXcP5x3fzvv/nXmhc6cyad7" +
       "TTb/1u/Aa0uQ/wAZb3uM/Uni7e95+CYQcF56MzB5NhS+MUBjO8To57iogLCF" +
       "XvhI+i7+Z4p70N5JpM1kBk0XMnImw8cjHLxyOsOux/fiU9/63vMfftLd5doJ" +
       "6D6AgGspsxR++LR1A1cBhgu0HfvHH5Q+d/XzT17Zg24GuACwMJJA7AKYuf/0" +
       "HCdS+YlDWMx0OQsU1t3Alqys6xDLLkRG4Ka7ltztt+f1O4CNX5XF9v3geegg" +
       "2PPvrPdOLytfsw2TzGmntMhh98dY72N/+af/gObmPkToi8fWPFaLnjiGChmz" +
       "i3n+37GLgUmgaWDc33yE+dAz33nqLXkAgBGPXG/CK1mJATQALgRm/tkv+n/1" +
       "ja9//Gt7u6CJwLIYy5aprI6UzNqhCy+hJJjt9Tt5AKpYIIKzqLnCObarmrop" +
       "yZaWRel/XHwU+dw/vf/SNg4s0HIYRm98eQa79h9qQe/88tv+9f6czRklW9V2" +
       "NtsN20LlnTvOzSCQ1pkcq3f92X2/+AXpYwB0AdCF5kbLsevMQeJkQr0WrHzX" +
       "y89WPB9rnhuAZSx3LpyPfjwv9zPD5DygvA/NigfC40lyMg+P7VKuKh/82ndf" +
       "zX/3D17MtTq5zTkeE5TkPbENw6x4cAXY330aEXpSaIBx5ReGb71kvfB9wHEG" +
       "OCpgbQ/pAMDS6kQEHYw+e/6v//CP7nr7V2+C9jrQBcuV1I6UJyN0K8gCLTQA" +
       "oq28n3jzNgjSW0BxKVcVukb5bfDck/86BwR87MY41Ml2KbtUvuffaUt+99/+" +
       "2zVGyBHoOovzKfoZ/NxH78V+/Ns5/Q4KMur7V9dCNdjR7WhLn7L/Ze/hc3+8" +
       "B52fQZeUg+1ijr0gwWZgixQe7iHBlvJE/8ntznZtf+II6l53GoaOTXsahHZL" +
       "BKhno7P6hVO4k1v5YfA8cJCSD5zGnTNQXmnmJA/l5ZWseMOBh7asfgA+Z8Dz" +
       "X9mTtWcN2/X6MnawaXjwaNfggTXrdpAETUWJ7diSDjebIFUevkGqHBu6RcKs" +
       "LGdFaytC7Ybx9KZrtX30QNtHb6AteSNtszoeQa8ONCnf6dDOhGZfOi6ZwLQB" +
       "6CYHmz74ycvfWH70W5/ebuhOB+Gpwdp7nn7vD/bf//TesW30I9fsZI/TbLfS" +
       "uZyvzoXN0vqhl5olp+j8/fNP/t4nn3xqK9Xlk5tCHLzzfPrP//Mr+x/55peu" +
       "s/s4L7uupUnOKb9Qr9Avbzh4DuvX88tbXsYvl8P8/aDvqNqK1nPnZD2TU6K9" +
       "9WVF25ruDFjFzpb2a/vF7Ld8/clvyqo/Apa7MH8vAxQgbiXrUKS7F5Zy5TAF" +
       "ePCeBjDoysKqHQb8pRw+s2zf377cnJIV/x/LChx9+44Z6YL3pPf93Qe/8oFH" +
       "vgGcRkBnkwxfgHePzTiMs1fHn3vumfte9fQ335ev3mDZYh+T//nNGVf7pTTO" +
       "Cj0r5oeq3pupyrpxoGikFEZUvuBq6pG2o2P6cBFYtt3/hbbR7dNeOew3Dz9k" +
       "UZSFlFuh0xjuIiFMdZz20Ji3W90u2uQkwcInXXsTij2ysGyWBMkY0LFarKCF" +
       "QQMVeBRZVOWigS2x4cA3sVlTIpLUXRMDdu6MBlaHjUTbdRcS4RIC6y1RduCP" +
       "/UGFK41HJd+2WEvWPXsWw6VyoUItJUIqJT1l04sSNFFrVElL3AlJjikEd1d4" +
       "dTZuBkUfHY+ElTSmK2wo8JFRE8qN3pyAozj24aKc+ka9QyG0KEVMasgeJ859" +
       "oTp0TYmYdbohG+ousRw7XRdfhuKyMvfjhTQgfEcgEW+EcEtDlz3Kxpv9hkm5" +
       "oxnlS8uljHvV3qjPkeKyRSA9mp2ONwoZLgzbXaIzY52O1WpKhnU6Tde1WcXi" +
       "+JFeKlOOMmRt0/CHg7EcrQkDLKTdgCvR/sSklqP1sIYwAo0FcgeJwX6G4TGU" +
       "U9CFL/vxKLBFHJ0MxjrTNQdCsCyPaFH20SEPkJyNEm1B+hjbnTl2cyD45GxU" +
       "GKZ+Z0y3R0EwCjvoUGE3XAWt8qli+zwnL02qL/pCQVyKJWrsGfV0XlktXb5D" +
       "9FS3TBXN2pBl4+WmxawKdOCGiooi0wLcGgpDd+F1uiU5ZKkmbnDD7kjClw6L" +
       "2RFvC+ZkPeguRmlj0Vx1pNQvlqtWd41YE4rhWsnQQZS+IIu0COOrKV9q9ZZU" +
       "qUhIvkzrXRYddJVpiSc6YqEVMENVEAWcEVK1NVgJ8za+MZVe0iMmrMIJk4Hg" +
       "EmI8XspkyDSbGNJfIi4b1lVe8gwBx4bpkueCPtIx6j0kauNNUmVaTa40AJHH" +
       "zmS3FLZZelU0FU0YNWWrFTb5Ec+n47YrGBreX02aZoi0pM0yVAoI7CK9hm3J" +
       "0aQ5aCr19ZKfdOH1qinNy/P2DF9SIwefc1goiQU1ZYY6bay6WL/ttMRmZ9OM" +
       "9NipMXYskUFqi+MRP28ZRM3EJ4ti7OC1tiKoVVTiKFL02+MiW+p1G0WHdkub" +
       "UUlz+l2iZVRixQ1DpK8mjFnEC7BGN6kCi1G+E41jiQ1UI6j7eI8tliUTT4aa" +
       "a+ATbk2irumbax6pJyuVT9trW8LZsG2yk47fbfidicUWuCqcFn123ic8n/Bt" +
       "LJK4EKbb3GqiE+UVjvf5+gCXCoQ4rys6zBVZczBBhq61wGyf9IpcZzKDCZlT" +
       "5mVMbUUDz8VnxUAUEZmjfM5VgYFLCF4jOcVaN0ocNhKKEqYJKmIs+20L77fX" +
       "RVzaSARFpAsGno7GS7s+2xBc06TCiSliFtt3/VJ1YFAb0iht6FqcOOVIx+1a" +
       "dxQy4w7HgfhWsEpRXA4q/cZwTdKL8ajcKfMYTJqVWm9lqLW2RFMjmKAxiVco" +
       "Rh5GjZjk8B5VFcmmwFONljBd93zFG+LDgOl5Oj2MVIYM/FWDEFcDsTofs41J" +
       "d+CHgV0vrtadBRu3GG44WrqcULUE2vc6gw1uyy6eeuZSoHiQdhMfr4+X1dVk" +
       "2ODbfWSBC6HaM3lpNIcLC3Ot2L2xUa1T5Q0Gx2QTtLQTSh61EGuwqU7jyG6x" +
       "A5xFa1GbX9SremlQqFWVzlSWiQ41L0zWalNS++Zciwm2gJB1nVlbsIAoNV4Y" +
       "JabdVfoMVWql9bSiNuhgMHMoi8VGYCGf0ENelnhkiiOTmVP1yARjZKG1KWiY" +
       "UF+ZZXVOoZu+wyQWHC0SXaQprKw61CYl2DrurRq19qrSDmG4MXRi0t+MpSld" +
       "TIsU3ggMVmApARsywqgUl0plFBt1y41imWYcuV7yuyraVVqiYxvNRiKWmhzR" +
       "xtO+5NTKkYwmiQNbjU5kIPW6x/f6teYIGROmshSKOk+lc8KrIsWC2MF9nBxR" +
       "UsMrVbstfe0RLVbl0jkZTFEuQBY12FozSDpvcAJlV4szX8bR9lQuRHhrXYsK" +
       "gTlbphYRtLAa7TCtcU/SywipyYRXNpPuWNMWQ0JtlDuTOqGOiHVY5Sm8UolH" +
       "xWoIQkUYBXhsdfrVmowbYjy3+U4lRhlOKSzLBTTkuLS0nCeB1mqzYShX2uVy" +
       "oz0RKMFyS42G0E7WZSWZxvyksAk3AY6iYrXVitd9ie+yGNwnFnhk94PWtIVO" +
       "tTWcINWG1qTcxZzoYKo7luoYPiGClTZrtqe8vKquCjDlwGh3zblon/b5MUoy" +
       "s3mvX/WxAdYSMI9IV8kCY5Q+QZiR4dOa6S42Rn0liX3eHdi1eU3mW7FFL6ed" +
       "zRqta9aEr83Rrkt2+25FT2MfI+FkDUeVYbOrFuqypTMJiuAV2hwhBs/QYafe" +
       "kgtKsTXsMRuVgQlukwzVuVa25u26xOgRzjU0u70xCzY6F1UrtJPKrFV3Ziuk" +
       "ghDwBlWEpDqhBq441gW2WIQ35fnEYJpuwyP4KPR7TiNGa4Vibwz3Jks8Tkxx" +
       "SG56rYjShPLQmNjtWcJII0JeEPa6E9R5oomhLbKlYnqvr49rtrooIGFMMUF7" +
       "Y7HehB659rxkDC2blclJ5Pqb3mSOi6V4LDJs07Q25CosbPqsRCdy7K5Q2WFr" +
       "C0wUog4+slCs6cyKRD3h253QtL3h3LFketCKeqtFabiiQ7EJy9goHCSVQZdp" +
       "w0ZEyUHLUUmjEYJ1AlMKgYhhTSJGF8w4KJfqiaasg/WAD8ip6CyEpYd2m51w" +
       "PEljt1OvwM1pahbgGsZQSlEY95NZiZ4WYy7aLNgyuTbsxWDdaqo9eFEoDJlp" +
       "DxGwVpPyRs2Unm7CQaWBL4x04nE9xfJkZ8qbdZomuwQ1NtKUpuISt3GU/kpL" +
       "KmU9qTNOw4LZXpuv0nAjLnT8QmGdwE6xoiQDNFipLmWGbOyX2YCeroX1YtpT" +
       "akipqPQjTRjHRl2V2Y03V6RlB5lKNlCICEprppD6ZDsxqJlRw9FhuzjuMl1R" +
       "M7l2Iva1tt+v6W41UGpTdKath9MJVfOqlLBKe/1En6AhYguj7jLa6CWl1mjO" +
       "JKTLL+gY15KNgQ7hujcuY7WlzDHK3O2Kg3XqqRZqyU67WiZB9oatiVQf0sFo" +
       "hvrVQVUR1QHhLvz+mLet3hrxyg29OERwOKqFYxSG5zVptbEirxBZUr2ISloi" +
       "1Vr8uphMF80Wb1UaGqbbtVnCxqWCoVcbhIRZfcpJGgTSgNUqX/SHBmy4xmC5" +
       "0QZlUfcVJikPOTtB5cp06leSsmrPpLYaClGtiHXUTX0ZkCxeWownLi+GYwwd" +
       "B3OxmggTELnRosm5Ho4bxLgPr8ZmA+VdgWvppRlIK3hUb6OYMVe8gReN3C7j" +
       "9Hu4M5Q7cHFgC5PYHNRwudWc1jmEZs0+pbL9QkESspDstxZ236Nmc1OBqxwv" +
       "ppHasmC9UtMxJVkItOjJjZIlumNz1ZXStBp1piMQPmbCaFWqYzAVjpoVKjK1" +
       "WtilUlpum524rCxbI3RgVqtx3OfKYD0cy0zie3571S7OUmyy6oZDpCo20qbf" +
       "i0tLpar7A0NTSglemqyrFaPGSWxrSAiI0EBnkTO1qyIxsNJUiHByrfgrR/Ek" +
       "MyhMmsSU2fQMmKiPB7TWrKR9t0NVUM+quTWkw9U4YtIhZvVSvdFqTYVSOnNT" +
       "baHqc2wqzobUdCFt0GDtiA2u2LKqaW9pttsjyZmlgSNsuE1/mhLrlYegIUy6" +
       "/jggddUWGKThUFUq6gXtRTGxJiU4QKc6HHIFUmsvLFPzvLE9mnam7dSokGQQ" +
       "+iQXBpNBVK1WKT3CENELe4I7apPJOAoXi5WFzhepvLGqctNTZ/66gUToptSo" +
       "a4LeYysw3vCnDmvi6bRcq6/rZFehu2EggrAsFEfY1IwKJZpXC0opGNkFVdfr" +
       "AHLwJUqXYzJVgFY1AtWwAqWjdUZn6yHHJ3CFFGTSAptTr+lMkLQ3nPkgxSSm" +
       "CeLZDTYSurYqFRcshHLa3qB1ee4vPGKD11TEHmvTansds3FBhcfhSO4P++X2" +
       "PHBMqQLCkiluamUiWQlEw6AZZFUAK6qIuJ7Tr4la32JK03YlgTlR1idEd95s" +
       "Zq+Y61f26ntH/pZ/dJ8J3nizDvMVvN1uux7KikePDkbyzzno1B3Y8RPz3fEo" +
       "lJ303Heja8r8lOfj7376WZX+BLJ3cGLCR9Ctkev9qKUlmnWM1R7g9PiNT7So" +
       "/JZ2d9z5hXf/472THzfe/gouex44Jedplr9GPfel7uuVn9+Dbjo6/Lzm/vgk" +
       "0RMnjzwvBPmF1+TEwed9Jy9cssPOxw8s+/jpI6ed766JgjN5FGx9f+rU/tTJ" +
       "//1uMN+XPEkxtH1Z0az9/J8C2QXoPuaqWs7iAy9x8P+hrHhvBJ1NzNCMrnuK" +
       "krimugux950MsduOQuxIpMu74x860YLAVLWXiMprj+TzhqdOGvIR8JQODFn6" +
       "vzfkKZVvMp0op/mVl7DcJ7PiWRDgoZTSngKMnTU8s7PUL9/QUlnzL70im6wi" +
       "6M7rXLRmt0b3XPP3ju1fEpTPPHvxlruf5f4iv2s8+tvArSR0ix5b1vHD+2P1" +
       "c16g6Wau4K3bo3wv//psBN1740vgCDq3reSCP78l+Q0g83VIIjD/QfX46N+K" +
       "oAu70RG0p5zo/t0IOn/QDfwDyuOdvw+aQGdW/bx3GIZvvO5B/xpICVzFKgBF" +
       "TGfezqV2g9WZk0B35MTLL3deeAwbHzmBaPmfcw7RJ97+Peeq8vyzxPAdL1Y/" +
       "sb1IBcm62WRcbiGh89s73SMEe+iG3A55nes99v3bP3vro4doe/tW4F06HJPt" +
       "gevfWuK2F+X3jJvfufs33/Srz349P6L9b9EkzXA1JQAA");
}
