package edu.umd.cs.findbugs.detect;
public class NonNullReturnProperty extends edu.umd.cs.findbugs.props.AbstractWarningProperty {
    private NonNullReturnProperty(java.lang.String name, edu.umd.cs.findbugs.props.PriorityAdjustment priorityAdjustment) {
        super(
          name,
          priorityAdjustment);
    }
    public static final edu.umd.cs.findbugs.detect.NonNullReturnProperty
      EXACT_METHOD =
      new edu.umd.cs.findbugs.detect.NonNullReturnProperty(
      "EXACT_METHOD",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        RAISE_PRIORITY);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfu/N37PgjiW0c241dp8hpeptAA6oc2jgXGzuc" +
                                                              "P7DdABfIdW537m7jvd3N7Kx9dim0VaGpkKqgpmlA1H+lqhSVNkJU8AetjCqg" +
                                                              "qIDUUqAFERB/FZWIRogWEb7ezO7efty5iH846ebGM+9j3pv3fu+Nn7mG6i2K" +
                                                              "BonOkmzNJFZyQmfzmFpESWnYspZgLSs/kcB/OfXW7B1x1JBB24vYmpGxRSZV" +
                                                              "oilWBg2ousWwLhNrlhCFc8xTYhG6gplq6Bm0S7WmS6amyiqbMRTCCU5gmkad" +
                                                              "mDGq5mxGpl0BDA2k4SSSOIk0Ht0eS6NW2TDXfPLeAHkqsMMpS74ui6GO9Gm8" +
                                                              "giWbqZqUVi02VqboVtPQ1gqawZKkzJKntUOuC46nD1W5YPhK+7s3zhU7hAt2" +
                                                              "YF03mDDPWiCWoa0QJY3a/dUJjZSsM+gLKJFG2wLEDI2kPaUSKJVAqWetTwWn" +
                                                              "byO6XUoZwhzmSWowZX4ghobCQkxMcckVMy/ODBKamGu7YAZr91SsdaysMvHx" +
                                                              "W6XzT5zq+FYCtWdQu6ov8uPIcAgGSjLgUFLKEWqNKwpRMqhTh8teJFTFmrru" +
                                                              "3nSXpRZ0zGy4fs8tfNE2CRU6fV/BPYJt1JaZQSvm5UVAuX/V5zVcAFu7fVsd" +
                                                              "Cyf5OhjYosLBaB5D3LksdcuqrjB0U5SjYuPIJ4AAWBtLhBWNiqo6HcMC6nJC" +
                                                              "RMN6QVqE0NMLQFpvQABShvq2FMp9bWJ5GRdIlkdkhG7e2QKqZuEIzsLQriiZ" +
                                                              "kAS31Be5pcD9XJs9/Oi9+pQeRzE4s0JkjZ9/GzANRpgWSJ5QAnngMLbuS1/A" +
                                                              "3S+cjSMExLsixA7Ndz5//cj+wc2XHZrdNWjmcqeJzLLypdz2V/tTo3ck+DGa" +
                                                              "TMNS+eWHLBdZNu/ujJVNQJjuikS+mfQ2Nxd++Jn7L5O346hlGjXIhmaXII46" +
                                                              "ZaNkqhqhHyc6oZgRZRo1E11Jif1p1AjztKoTZ3Uun7cIm0Z1mlhqMMTf4KI8" +
                                                              "iOAuaoG5qucNb25iVhTzsokQaoQvaoVvP3I+4pehglQ0SkTCMtZV3ZDmqcHt" +
                                                              "tyRAnBz4tijlIZhydsGSLCpLInSIYkt2SZFky99UCAM2adbQZ21NWyCQHTrI" +
                                                              "EimR5Fzm/09VmVu9YzUWgwvpj8KBBpk0ZWgKoVn5vH104vqz2VecUOPp4fqL" +
                                                              "oQOgOQmak7KV9DQnHc3JmppRLCYU7uQncG4f7m4ZUABguHV08XPH7zk7nICw" +
                                                              "M1frwPGcdDhUjlI+VHj4npWf62pbH7p68KU4qkujLiwzG2u8uozTAuCWvOym" +
                                                              "dmsOCpVfL/YE6gUvdNSQwRxKtqobrpQmY4VQvs7QzoAEr5rxvJW2riU1z482" +
                                                              "L64+cOKLB+IoHi4RXGU9oBtnn+fAXgHwkSg01JLb/vBb7z534T7DB4lQzfFK" +
                                                              "ZRUnt2E4GhJR92TlfXvw89kX7hsRbm8GEGcYkg7wcTCqI4RBYx6ec1uawOC8" +
                                                              "QUtY41uej1tYkRqr/oqI1U4x3+kmKBqC74CbpeKX73abfOxxYpvHWcQKUS8+" +
                                                              "tmg++cbP/vhh4W6vtLQHeoJFwsYCcMaFdQng6vTDdokSAnS/vTj/2OPXHj4p" +
                                                              "YhYobq6lcISPKYAxuEJw85dePvPm765eej3uxzlDjSZVoUki5YqVfANtex8r" +
                                                              "Qd0t/oEADzXIOx42I3frEKBqXsU5jfDM+kf73oPP/+nRDicQNFjx4mj/fxfg" +
                                                              "r3/gKLr/lVPvDQoxMZnXY99pPpkD8jt8yeOU4jV+jvIDrw187Uf4SSgXANGW" +
                                                              "uk4E6saFE+LC8l5ozwQnL71Jp/R6G/trwY0J0MLDUzWoytbGldO2xUqQlyIG" +
                                                              "DgnWA2K8nbtPaEJib4wPe61gLoXTNdCFZeVzr7/TduKdF68L28NtXDB0ZrA5" +
                                                              "5kQrH24pg/ieKNZNYasIdLdvzn62Q9u8ARIzIFGG3sWaowC55VCgudT1jb/+" +
                                                              "/kvd97yaQPFJ1KIZWJnEImdRMyQLsYqA1mXzriNOqKw2wdAhTEVVxlct8Ou6" +
                                                              "qXYgTJRMJq5u/bs93z789MZVEbSmI2N3BaT7QyAtHgM+Tlz++Ud/8fRXL6w6" +
                                                              "7cTo1uAY4ev9+5yWe/APf6tyuYDFGq1OhD8jPfONvtSdbwt+H58490i5uugB" +
                                                              "xvu8H7pc+mt8uOEHcdSYQR2y23yfwJrNsz4DDafldeTQoIf2w82j0ymNVfC3" +
                                                              "P4qNAbVRZPSLLcw5NZ+3RcCwl1+hBN9hFyaGomAYQ2IyI1g+KMZ9fLhNXF+C" +
                                                              "wVvCzsGTDCaWaPMZHEPVsRbBoh5PeA0lDLVOfHo8tZSdmViamjvmZez/3CA4" +
                                                              "wM3Hw3yYdY5wV624Lte2J8ann/SPLj4N0ZYuCKN+KCOerwNbdd3ixXDpwfMb" +
                                                              "ytxTB51g7gp3shPwUPvmL//5k+TF3/+4RrvUzAzzNo2sEC2kE14ANX3B07K3" +
                                                              "6qHmPC7kZzfam3o27v6VKL6VB0ArlK08CAoGTmDeYFKSV0UAtTphZIofiNm+" +
                                                              "rW8K4sKZiFMrDkuRoR01WBjod6dB6mWGWnxqhuJyaBteDI3uNkMJGIObZ2AJ" +
                                                              "NvmUml5gHdy6FIznoJ8BbPwUptBBFzxvlmPhi67E2K73ibFobNwcAi/x1nYv" +
                                                              "ZsZ2XtvQjW4cn733+keectoLeKWvr4u3GTw1nU6n0sQNbSnNk9UwNXpj+5Xm" +
                                                              "vXG3ZnU6B/azZHegoE1A8Js8aPoipdcaqVTgNy8dfvGnZxteg+g8iWIYLvFk" +
                                                              "NViVTRvS4GTaB/XA/2pETzA2+vW1O/fn//wbUQ6qi0CUHsD4sTemryy/d0Q8" +
                                                              "7urhxkhZoOixNX2ByCtQx5psXT1jk2kljbbzeMa89As/uO5rq6zyZpSh4arn" +
                                                              "dY0WHkrlKqFHDVtXBHpCJfFXQo9+N0dabNOMMPgrlavbWW1rVj72SPv3znUl" +
                                                              "JiEnQ+YExTdadm7Jg/Lg/wF8bO9wsOvf8InB91/8yy+ZLzjP0a6U+ybeU3kU" +
                                                              "Q0129hLZ9IxpurRNC6aTMg/x4ctlvsxQbJ+7ypuAmI+ajwj1Z8WUD1/5D9sq" +
                                                              "ZFgSFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1Ze8wrx1Xf++W+k+beJE0aQpLmcQtKHb6112uvrZTS9fq5" +
       "Xq+9XnvXXqC3+/Z63297S0pbURJRqVQiLUVq81crUNWXEBVIqCgIAUWtkIoq" +
       "XhJNhZAoKpUaIQqihTK7/t733pb2DyzteHZmzplzzpzzmzOzn/oWdCEMoJLn" +
       "WlvdcqN9dRPtr63afrT11HCfpGoTMQhVhbDEMJyBtpvyU5+79p3vfnB1fQ+6" +
       "KEAPiI7jRmJkuE44VUPXSlSFgq4dt3Ys1Q4j6Dq1FhMRjiPDgikjjJ6joLtP" +
       "kEbQDepQBBiIAAMR4EIEGD8eBYhepzqxTeQUohOFPvQu6BwFXfTkXLwIevI0" +
       "E08MRPuAzaTQAHC4nL9zQKmCeBNATxzpvtP5FoU/VIJf+s23X//du6BrAnTN" +
       "cNhcHBkIEYFJBOgeW7UlNQhxRVEVAbrPUVWFVQNDtIyskFuA7g8N3RGjOFCP" +
       "jJQ3xp4aFHMeW+4eOdctiOXIDY7U0wzVUg7fLmiWqANdHzrWdadhN28HCl41" +
       "gGCBJsrqIcl503CUCHrjWYojHW8MwQBAeslWo5V7NNV5RwQN0P27tbNER4fZ" +
       "KDAcHQy94MZglgh65I5Mc1t7omyKunozgh4+O26y6wKjrhSGyEki6MGzwwpO" +
       "YJUeObNKJ9bnW/RbPvBOp+/sFTIrqmzl8l8GRI+fIZqqmhqojqzuCO95M/Vh" +
       "8aEvvLgHQWDwg2cG78b8/i+99rZnH3/li7sxP3mbMWNprcrRTfnj0r1feZR4" +
       "pnlXLsZlzw2NfPFPaV64/+Sg57mNByLvoSOOeef+Yecr0z9bvvuT6jf3oKsD" +
       "6KLsWrEN/Og+2bU9w1KDnuqogRipygC6ojoKUfQPoEugThmOumsda1qoRgPo" +
       "vFU0XXSLd2AiDbDITXQJ1A1Hcw/rnhitivrGgyDoEnige8DzKLT7Ff8RpMMr" +
       "11ZhURYdw3HhSeDm+oew6kQSsO0K1oAzSbEewmEgw4XrqEoMx7YCy+Fxp6JG" +
       "gAymXYeOLWuqguhwAK8iJPZzKu//b6pNrvX19Nw5sCCPnoUDC0RS37UUNbgp" +
       "vxS3Oq995uaX9o7C48BeEVQGM++DmfflcP9w5v3dzPu3nRk6d66Y8PW5BLvV" +
       "B2tnAhQA+HjPM+wvku948am7gNt56Xlg+HwofGeYJo5xY1CgowycF3rlI+l7" +
       "uF8u70F7p/E2lxo0Xc3JJzlKHqHhjbNxdju+1174xnc+++Hn3eOIOwXgB0Bw" +
       "K2UeyE+dtW/gysB0gXrM/s1PiJ+/+YXnb+xB5wE6AESMRODBAGwePzvHqYB+" +
       "7hAcc10uAIU1N7BFK+86RLSr0Spw0+OWYuHvLer3HXg79CR4Hjtw+eI/733A" +
       "y8vX7xwlX7QzWhTg+7Os97G//ct/qRbmPsTpayd2PlaNnjuBDTmzawUK3Hfs" +
       "A7NAVcG4f/jI5Dc+9K0Xfr5wADDi6dtNeCMvCYAJYAmBmd/3Rf/vXv3ax7+6" +
       "d+w0EXTJC4wEQMXmSMu8A7r7B2gJpvupY4EAuFjAiXO3uTF3bFcxNEOULDV3" +
       "0+9de1Pl8//6ges7R7BAy6EfPfvDGRy3/0QLeveX3v4fjxdszsn55nZstONh" +
       "O8R84JgzHgTiNpdj856/euy3/lz8GMBegHehkakFhO0VRtgrNH8QJCEFZb6P" +
       "7e/2scOOZ28Xux6I09w9DTcwoi2urOMwsgHyFD4AF6RvLsr93HzFTFDRV8uL" +
       "N4YnY+l0uJ5IaW7KH/zqt1/HffuPXit0P50TnXSdkeg9t/PWvHhiA9i/4Sxw" +
       "9MVwBcahr9C/cN165buAowA4yiARCMcBwK/NKUc7GH3h0t//8Z889I6v3AXt" +
       "daGrlisqXbGIWegKCBY1XAHo23g/97adq6SXQXG9UBW6Rfmdiz1cvJ0HAj5z" +
       "Z7jq5inNccQ//F9jS3rvP/7nLUYogOo2O/kZegH+1EcfId76zYL+GDFy6sc3" +
       "t2I6SP+OaZFP2v++99TFP92DLgnQdfkgt+REK87jUAD5VHiYcIL881T/6dxo" +
       "lwg8d4SIj55FqxPTnsWq470E1PPRef3qGXh6OLcyDJ6nDgL3ybPwdA4qKkRB" +
       "8mRR3siLny7W5K4IpMqxZBkgwi6GRRYbATEMR7QO0OH74HcOPP+TPznzvGG3" +
       "7d9PHOQeTxwlHx7Y9u7pLHBidnPUmfXH7QIddxCZl/W8aO9YN+/oQW/NC3Jz" +
       "DmDVBWQf2y/n7+M7aJBXe3nRz4tBYSAyAqFgyTcOBeRAMg5858bawvLu8hmB" +
       "yP+zQMCF7z2GDMoFie/7/+mDX/71p18FfkZCF5LcB4B7ncAVOs7PAr/6qQ89" +
       "dvdLX39/AcQAhdlnpH97W86V+9HUeiRXi3XjQFYpMYxGBXSqSq7ZDw4vgFo2" +
       "2GKSg0QXfv7+V82PfuPTuyT2bCydGay++NKvfX//Ay/tnTg6PH1L9n6SZnd8" +
       "KIR+3YGFA+jJHzRLQdH9588+/4e/8/wLO6nuP50Id8A579N//d9f3v/I1//i" +
       "NtnWeQusxo+9sNHd3+uj4QA//FGVpcan8nTDazFMV7GJvjb4soygFcVrrDzV" +
       "i3C87srIWl/0slieYG0Fb2kDha9VMRtbJ0qVxoabpmLYZU7seebQ1z3bwiv9" +
       "kuWvWI42yXkDV6M14ev+oD2f+3i3M23BXYEfTF2d70iYmo0xVYu2NaPfQOuq" +
       "1BuVmuuql1S1uEQ7mN2rG8iw5Tpj085ositsGVvL7K7XYXlnGXqCTrEhbMot" +
       "eKwteKxV2VTIVgtBk6Xt9TZTVuBcw+JbOuLGIZ9SKzqwVkRXbmxmy1WvrnuW" +
       "X2/ZZRbjbbYu2lvDl0bTGUHMa7ptiord7vk1e9PzrHKrjSMmyrLseGCW+1FZ" +
       "Zes0j8zaC21CqXjf9MPRyGMxNDbqvXGzZzd0g5d8wZ9zRhnhfMnloglT0X0x" +
       "FYZmRg6daD6OCbTutCt8bTlZDUtYWM1Wc2yFR8iyW67a7faENwjeFcsMuayK" +
       "sDIn1wIbjko6NSS7PSSlOu0BYk7EOTskOdzn1WiW8o60HdcXc1dIV5nN8m4q" +
       "LFB95UoEY25Gsmxyoy08breGot2LsSUuBM0KGyriNhwl/Q1fX2SzWuaXuksi" +
       "4hUmrrtJI54MZFzvsWtKn3epYYf36WHqTUf+arZqRCrZnXXtIIirDrvwpkI5" +
       "621RLWxEGt1BiOm8rnFwa7IkowopCgyb2LU5h8cLmKtlnIx3Y0zjQoXYarXx" +
       "ar10Q6oltmrtKmWGihz7wbpVntfY9RLIQKI4zrciatXiacN36315RNQdkpiO" +
       "6DrD+Z0yPaKYrpcweItdJT7SHXlNiSdrvakysEzFXPUwFWGGvhB3BllIMYFh" +
       "CCbOVisttebJ7eaCDJvw2GiWPEadZh00LJPmWmjCvQynp57Os2SNAfmLPqKk" +
       "mK3AeJUtyWt21NlQobHBMVrJajAsr0upjCz6QqDQ/NqWfZXMKGrrKRnCwdHM" +
       "rcpmqd0TZyOaLal8n2opAg2ObWuSoxlyHRsmW7I1BqE3SqlEOhhVG1fR+srq" +
       "rReDlS0uBgO0Loi06a/8VX8r111BnwpTt9KpVEhDq3gVfJ1FQ3cmVOexg8kD" +
       "uyxUbGvlj0YzDR0OGsYYj0W3V/NjmZaQmsGtZlnomozoMonocsmkOiihnrrS" +
       "LabMmjNiFAlcVWjbvtyPou0Ud1oZGhlrayCstkrYYynCowYOO1iaEcIKXXPb" +
       "bM4JfISIisQISIXmtwTTnwWDjmFPa93MhstNzubi5jKb83qaeOvGsNXyzLLA" +
       "60OXc2pJv1JGEx8YS5Xn44mHaj7lMmN9zNiiiQ25Zptx+nKVtD1vShHLORYz" +
       "jtxDNcxGhTne0uM+V24sJn0sMzFnQKSjihakk56stFdzIHWJ669Rx+O1OuJJ" +
       "fcyrN4Zz1DfjNWWkWQ+JG7GbzfCY4JPx1lbscEx4nEbBy05dnycKzTLpdDOM" +
       "fFcKPMZeohyThBiTuXgnqAWbhOSRwJhXMrSBUHW0JI+HVKs0cPsGOl305k23" +
       "FTlOScMXej81Wb1cISkJTloSltWq6Axrt1CLybTuUJjOnQjpoL0VOW0iM0tb" +
       "JGmjaS6wVTiV7Eav05OXpo6l8ozwB+i0tdzUVbkSi+mYaDDzaIlWYnVdiZbm" +
       "1A9g1x9U5uimWjLtYcsnMJSQPHW4wKqipI03m6WX9HmZGc7ZRimy9VJJliZw" +
       "slqhfD2JKKavumQ3DZeEPBK7CuPo9WTWVlyTxR0WTmZrGBlPFsCk3nK1dCW/" +
       "bskDdjJc4pu4Q6aNmqJOkomN1Wuquq7Gm8xqr3M8nptGbelzGk6Ds1kjYJRy" +
       "BLsdvJ0tBuMNigyqWtABwi7CeW2ttUclU8Oq7mQCl5xp25AZurveoPYa1jaa" +
       "HlRhfUgFsMVNkjbjbkaCs1g2m97EM9uNddTYquM5uuZK62TQDtJKA5trAML1" +
       "BU73+NhEO/VQ7HZKFNGwam6WMg6FVUgPntZ7cBSkyzJZHlHteca720jqWcoY" +
       "2cx9xtoOem3d4XFk2HCkaCJ2SENC04lar+iUu5jRCtEVVC4LMHimxEOlW29Q" +
       "SIOOFu1WWQjwWs1kgj6CejpsqENaoJdiOFAoJcmcOsI04wY+HWSDbq9XDXnR" +
       "TYlajSP0WJlV1hJcgs1EaWJbkZl0ycpwIPCk0xnYynS0Zahw6eMVe5EFBj32" +
       "hymSKvhq1uG4jSVHjXFc9xdLfUZOR6Rfi2EpbFYzrNEcCVxHYu0BQldb4gxj" +
       "tnjU10elmZWVSnMFbmjTBVVP65g8cysxvkTVpFmqbXkVxidaPdrGy3a351fG" +
       "K2DtiTamk4hVpDQq9WsNtFk2anGstzZJ3ACxJpfsqBGPO31ZYZfMFNki1a2W" +
       "kgEdZmi7LWqWos4Yd6AhaQNZl7c2zWlEdYL6NC5xU2HCUpSc1mihVJ3KRGpV" +
       "SqsW3Vx1t2LPtfElgwy2g4peGo6EpgY2+UW3RKRcQmRhb9YmRF6cjIR+Z8KB" +
       "CGq5q9pExctWm+LGWt9tRAKr2Jwh2uvEFtQMrhI4mo6q/bS6XSrLWsrVEZSK" +
       "VIRsgNMZzE6oNUqXhWVMDOnSkBirQUpLilI1Nou2l2ojaRttZq1aRcd0rxqu" +
       "Jul8ktgUDNfM0qxbhUvoNEjmGZ5ltIuEHQIxOxUUpxfVVhkbVut+354QmClk" +
       "mmhXXQRL6tyQqnOtMh5Yw3KDwN3ezG6ry+6Q5cpzPJp5K2HgagZtlwK+MUTD" +
       "oWB0R0HbjKfutFzhW2tXqSutus33eGfjr2JyK7YitT2oxrQ5InuDsSQgOEkn" +
       "9ty2anpf2da7g8xxyUZLAqJ7UavVzTaJZU9WRh3rIEOsakhdV6JTGTfgTcVZ" +
       "JkIoIIsoYdY8KjtYFUCNCg6DLqUO+SRA42pvllaced0phwwtsQ5tNucpvfDW" +
       "pdrCTha9qgA6W7CYCX1VdzsVvEGGDXHiGp4iiz430+ltQ9GSniNsIlUv6Q2D" +
       "HyyppGvSnMHNpgmL9mZiC17gMOJ1ZhmOlBK+MoY1B4ZTac7UfaNMzPthGw1n" +
       "qh1st7BSZhpYHKw25kpwx8aGXiCtLRExm5oXLkCYmYhprSUpU0dio4mHcDyu" +
       "BX492woeu0LFwFGWZb5vguXwu/02Fy1afY8gte6CcZsluqyIEj0ejSZ6YImJ" +
       "xPOVgFtjCDtJqpkzt0ij4zClZWczU0ByiZE6TOlw2m1I42YajhOtMXBazQrc" +
       "2G5LApWtJ2WxPi9tJXVeNedMuYI0V5TQHGy8OJjSRB2kETq8QeXISsINI5El" +
       "bOvFuD0oiet0XREa/LxdgWvtZugLXZ3tgnQ/PwboP9pJ7L7igHn0veTHOFpu" +
       "bj/huWLC48u54nfx7K37ycu54zsWKD9nPXanDyPFGevj733pZWX8icrewd2U" +
       "FEFXItf7GUtNVOsUqwh68LbX1PmV28O3fCLbfdaRP/PytctveHn+N8VN7dGn" +
       "lysUdFkDjE7eaZyoX/QCVTMKca7sbji84g+I8MidL9Ej6OKuUkid7kjeGUEP" +
       "3IYkAvMfVE+OflcEXT0eHUF78qnu90TQpYPuCLoLlCc7fwU0gc68+j7v8N6w" +
       "cud7Q1wKo0CUIx7EiuHoh9bcnDu9fkeuc/8PO7yeWPKnTx38i6+cBwszinff" +
       "OW/Kn32ZpN/5Wv0Tu7to2RKzLOdymYIu7a7Fj278n7wjt0NeF/vPfPfez115" +
       "06ET3bsT+Nj5T8j2xtvf+3ZsLypuarM/eMPvveW3X/5acTXyv6GfsBF+HgAA");
}
