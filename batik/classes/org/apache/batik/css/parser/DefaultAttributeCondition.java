package org.apache.batik.css.parser;
public class DefaultAttributeCondition extends org.apache.batik.css.parser.AbstractAttributeCondition {
    protected java.lang.String localName;
    protected java.lang.String namespaceURI;
    protected boolean specified;
    public DefaultAttributeCondition(java.lang.String localName, java.lang.String namespaceURI,
                                     boolean specified,
                                     java.lang.String value) { super(
                                                                 value);
                                                               this.
                                                                 localName =
                                                                 localName;
                                                               this.
                                                                 namespaceURI =
                                                                 namespaceURI;
                                                               this.
                                                                 specified =
                                                                 specified;
    }
    public short getConditionType() { return SAC_ATTRIBUTE_CONDITION;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    public boolean getSpecified() { return specified; }
    public java.lang.String toString() { if (value == null) { return "[" +
                                                              localName +
                                                              "]";
                                         }
                                         return "[" + localName +
                                         "=\"" +
                                         value +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxUfn41tjI0/+DZgwBgQH7kLaaBNTSDG2Mbk/CEM" +
                                                              "RDWBY29vzrd4b3ezO2efnZIPqghaqYhQvloF/qiISCkJadUoqZogqigfKLRV" +
                                                              "gDZNq5CqrRraFDWoalqVtul7M3u3H+c7ZKn0pJ3bm3nvzXtv3rzfm7mzN8gE" +
                                                              "yyQNVGNBNmJQK9imsV7JtGisVZUsawv0ReRjxdJfd17vvi9ASvvJ5IRkdcmS" +
                                                              "RdsVqsasfjJX0SwmaTK1uimNIUevSS1qDklM0bV+Mk2xOpOGqsgK69JjFAm2" +
                                                              "SWaY1EqMmUo0xWinLYCRuWHQJMQ1CbX4h5vDpFLWjRGHfKaLvNU1gpRJZy6L" +
                                                              "kZrwbmlICqWYoobCisWa0yZZbujqyICqsyBNs+BudZXtgk3hVTkuaHyx+tNb" +
                                                              "BxM13AVTJE3TGTfP2kwtXR2isTCpdnrbVJq0HiGPkeIwmeQiZqQpnJk0BJOG" +
                                                              "YNKMtQ4VaF9FtVSyVefmsIykUkNGhRhZ4BViSKaUtMX0cp1BQjmzbefMYO38" +
                                                              "rLXCyhwTjywPHT62s+b7xaS6n1QrWh+qI4MSDCbpB4fSZJSaVkssRmP9pFaD" +
                                                              "xe6jpiKpyqi90nWWMqBJLAXLn3ELdqYMavI5HV/BOoJtZkpmupk1L84Dyv41" +
                                                              "Ia5KA2DrdMdWYWE79oOBFQooZsYliDubpWRQ0WKMzPNzZG1sehAIgLUsSVlC" +
                                                              "z05VoknQQepEiKiSNhDqg9DTBoB0gg4BaDJSn1co+tqQ5EFpgEYwIn10vWII" +
                                                              "qCZyRyALI9P8ZFwSrFK9b5Vc63Oje82BR7WNWoAUgc4xKquo/yRgavAxbaZx" +
                                                              "alLYB4Kxcln4qDT9tf0BQoB4mo9Y0Lz85ZsPrGi48LagmT0GTU90N5VZRD4V" +
                                                              "nfzunNal9xWjGuWGbim4+B7L+S7rtUea0wZkmOlZiTgYzAxe2Pzml544Qz8O" +
                                                              "kIpOUirraioJcVQr60lDUanZQTVqSozGOslEqsVa+XgnKYP3sKJR0dsTj1uU" +
                                                              "dZISlXeV6vw3uCgOItBFFfCuaHE9825ILMHf0wYhpAweUgnPXCI+/JuRRCih" +
                                                              "J2lIkiVN0fRQr6mj/VYIMk4UfJsIRSHqB0OWnjIhBEO6ORCSIA4S1B6QLQt3" +
                                                              "JiTC0AYal1IqyyY02FMxbn4QI874P86VRrunDBcVwZLM8ScEFfbSRl2NUTMi" +
                                                              "H06tb7v5QuQdEWy4QWyPMbIKpg+K6YN8+iBMHxTTB/NOT4qK+KxTUQ0RBLCE" +
                                                              "g5AMIBtXLu3bsWnX/sZiiD5juAT8j6SNHlRqdTJGJs1H5HN1VaMLrq18PUBK" +
                                                              "wqROkllKUhFkWswBSF/yoL3DK6OAVw5szHfBBuKdqcs0BlkrH3zYUsr1IWpi" +
                                                              "PyNTXRIyoIbbN5QfUsbUn1w4PvzktsfvDpCAFylwygmQ5JC9F/N7No83+TPE" +
                                                              "WHKr913/9NzRPbqTKzzQk0HMHE60odEfF373RORl86WXIq/taeJunwi5nEmw" +
                                                              "9yBNNvjn8KSi5kxaR1vKweC4biYlFYcyPq5gCVMfdnp4wNby96kQFpNwbzbB" +
                                                              "s9LerPwbR6cb2M4QAY5x5rOCw8b9fcaJX/70j5/j7s4gTLWrNOijrNmV1VBY" +
                                                              "Hc9ftU7YbjEpBboPjvd+48iNfdt5zALFwrEmbMK2FbIZLCG4+am3H3n/w2un" +
                                                              "rgacOGcA66koVEfprJHYTyoKGAmzLXb0gayoQrbAqGnaqkF8KnFFiqoUN9a/" +
                                                              "qhetfOnPB2pEHKjQkwmjFbcX4PTPWk+eeGfn3xu4mCIZUdnxmUMmUv0UR3KL" +
                                                              "aUojqEf6yctzv/mWdAJAAxK1pYxSnntLuA9KuOUzoUjjnAjAQQHA2L/amwlw" +
                                                              "t/WlohbsWiUJizRkg9w9vbvk/U29vxcANmsMBkE37bnQ17e9t/sSD4FyzAvY" +
                                                              "jxNVuXY95A9X/NWIpfkMPkXw/AcfXBLsEGBR12oj1vwsZBlGGjRfWqDG9BoQ" +
                                                              "2lP34eAz158XBvgh3UdM9x/+2mfBA4fFuoq6Z2FO6eHmEbWPMAebZtRuQaFZ" +
                                                              "OEf7R+f2/Oi5PfuEVnVeFG+DIvX5X/z7UvD4by6OARRlUV1XqSSS2b0Y7NnU" +
                                                              "PtW7PsKoDV+tfvVgXXE7ZJVOUp7SlEdStDPmlgqlm5WKuhbMqal4h9s8XBxG" +
                                                              "ipbBOvAw4u0qrsvdWY0I14jwsU3YLLLcGda7Zq4SPSIfvPpJ1bZPzt/kdntr" +
                                                              "fHdC6ZIM4fRabBaj02f4EXCjZCWA7t4L3Q/XqBdugcR+kCgD0ls9JqBx2pN+" +
                                                              "bOoJZb/68evTd71bTALtpELVpVi7xDM5mQgplFoJAPK0se4BkUGGy6Gp4aaS" +
                                                              "HONzOnAXzxs7P7QlDcZ39OgrM36w5vTJazyVGULGbM5fjLWFB7r5SdFBjzNX" +
                                                              "Pv/z008fHRYxVWCH+Phm/rNHje797T9yXM7BcoxN4+PvD519pr517cec30Et" +
                                                              "5G5K59ZDgPwO7z1nkn8LNJa+ESBl/aRGtk9m2yQ1hVjQD6cRK3Ncg9ObZ9x7" +
                                                              "shBldHMWlef4d61rWj9eujdCCfMEvQORk3EJ58HTaKNHox8iiwh/eZizLOHt" +
                                                              "MmzuyiDSRMPUGWhJYz5QqiogFthUXZbUblvH1QKJsX0Qmx1CVnfekNzmNQHl" +
                                                              "L7HnWpLHBFEkLMEmkqtpPm5GKtGRFpSwdOvmzrGUjY9T2fnwrLCnW5FHWbWg" +
                                                              "svm4wa2WQWWAZBrDji/6NE0W0DTtzLg8OyP/lBLfecddXThbmWC+mpvvSMoB" +
                                                              "4tTewydjPc+uDNhZdD0ozHTjLpUOUdUlCq+Z5nqyQhc/hDtb7IPJh373w6aB" +
                                                              "9eOp5bGv4TbVOv6eB/t7Wf5E41flrb1/qt+yNrFrHGX5PJ+X/CK/03X2Ysdi" +
                                                              "+VCA3ziIvZ9zU+Flavbu+AqTspSpecFuYXZda3G9FsCzzl7Xdf44dCLHFxLZ" +
                                                              "gjMfawHU/EqBsaeweQzqugHKsgfBbG3/BbsMwa/7Xe8tDIIloZvMXzfgz460" +
                                                              "E/qP326TFgY57Nhi8P7RrCvqMl7ssF3RMX4v5mMt4KkjBcaOYXMQygrwYrc/" +
                                                              "bzneePpOeaMBnh7bpJ7xeyMfawGLv11g7BQ2JyCFgzfCHrxxXHHyDrhiCo4h" +
                                                              "rD5k2/PQ+F2Rj7WAuecKjH0PmzPCFX0ejHBc8d07FRX18Oy07dk5flfkYy1g" +
                                                              "7qsFxs5j8zIj5Ux3nxyzbnjlf+GGNCOz8t5vYc08M+eKXVwLyy+crC6fcXLr" +
                                                              "exzasle3lQBS8ZSquqs613upYdK4ws2rFDWeOMm8ycjsAldweKHAX7gZbwie" +
                                                              "i4xMHYuHkWJo3ZSXIF37KSEh82833c8YqXDoYFLx4ia5DNKBBF+vGJkz/upC" +
                                                              "t4ctcEw3Aflz3Zsu8pYl2ZWddruVdVUyCz0VAP/bJIPWKfHHSUQ+d3JT96M3" +
                                                              "Vz8rrohkVRodRSmT4OgpbquyiL8gr7SMrNKNS29NfnHiokxtVCsUdnbHbFcI" +
                                                              "bwGEMzCK6n33J1ZT9hrl/VNrzv9kf+llOMFsJ0USI1O25x4t0kYKSq3t4dwj" +
                                                              "NlRH/GKneem3RtauiP/l1/zwRsSRfE5++oh89fSOK4dmnmoIkEmdZAKUfTTN" +
                                                              "zzwbRrTNVB4y+0mVYrWlQUWQokiq5/w+GQNewl3J/WK7syrbixeMjDTmXl/k" +
                                                              "XsvCQXeYmuv1lMYTXRVUZ06P5/8cexNVpAzDx+D0uK542rFpTuNqQNRGwl2G" +
                                                              "kbndKWsweALoGLsewfYP/BWbj/4LKEpbIlIdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeewjV32f3WQ32SXsbhJIQiD3ciROfzO2Z3woFPD49hy2" +
       "Z+yxPbRZ5rTHc9/joWkBtU1aqhS14agK+aMFUVAg9ECtimiDqhYQCImKnlIB" +
       "VZVKS5HIH6VVaUvfjH/3HiEQ1dI8P7/j+76f7/u+z/fNe37mO9Ap34MKjm1s" +
       "loYd7ChJsLM2sJ1g4yj+zoDERoLnK3LTEHx/AsouSfd/6vz3vv+e1YWT0Gke" +
       "ulWwLDsQAs22fEbxbSNSZBI6f1DaNhTTD6AL5FqIBDgMNAMmNT94hIRedqhr" +
       "AF0k91SAgQowUAHOVYAbB61Ap5crVmg2sx6CFfgu9LPQCRI67UiZegF031Eh" +
       "juAJ5q6YUY4ASLgx+80BUHnnxIPu3ce+xXwZ4PcW4Kfe/+iF37sOOs9D5zWL" +
       "zdSRgBIBGISHbjIVU1Q8vyHLisxDN1uKIrOKpwmGluZ689Atvra0hCD0lH0j" +
       "ZYWho3j5mAeWu0nKsHmhFNjePjxVUwx579cp1RCWAOttB1i3CDtZOQB4VgOK" +
       "eaogKXtdrtc1Sw6ge4732Md4kQANQNcbTCVY2ftDXW8JoAC6ZTt3hmAtYTbw" +
       "NGsJmp6yQzBKAN15VaGZrR1B0oWlcimA7jjebrStAq3O5IbIugTQK483yyWB" +
       "Wbrz2Cwdmp/v0G988u1WzzqZ6ywrkpHpfyPodPexToyiKp5iScq2400Pke8T" +
       "bvvsEychCDR+5bHG2zZ/+DPPv+Xhu5/7wrbNq6/QZiiuFSm4JH1YPPfV1zQf" +
       "rF+XqXGjY/taNvlHkOfuP9qteSRxwMq7bV9iVrmzV/kc8xeLd3xc+fZJ6Gwf" +
       "Oi3ZRmgCP7pZsk1HMxSvq1iKJwSK3IfOKJbczOv70A0gT2qWsi0dqqqvBH3o" +
       "eiMvOm3nv4GJVCAiM9ENIK9Zqr2Xd4RglecTB4KgG8AD3QSeu6DtJ/8OoBW8" +
       "sk0FFiTB0iwbHnl2ht+HFSsQgW1XsAi8Xod9O/SAC8K2t4QF4AcrZbdC8v1s" +
       "ZfqKB7cUVQiNoBEArxKBP4E1JefwdzKPc/4fx0oy3BfiEyfAlLzmOCEYYC31" +
       "bENWvEvSUyHefv6Tl750cn+B7FosgDAw/M52+J18+B0w/M52+J2rDg+dOJGP" +
       "+opMja0TgCnUARkAmrzpQfanB2974v7rgPc58fXA/llT+Ops3Tygj35OkhLw" +
       "Yei5D8Tv5H4OOQmdPEq7meqg6GzWfZSR5T4pXjy+3K4k9/zj3/res+97zD5Y" +
       "eEd4fJcPLu+Zref7jxvZsyVFBgx5IP6he4VPX/rsYxdPQtcDkgDEGAjAkQHn" +
       "3H18jCPr+pE9jsywnAKAVdszBSOr2iO2s8HKs+ODknz2z+X5m4GNX5Y5+kXw" +
       "FHc9P//Oam91svQVW2/JJu0YipyDf5J1PvS3X/mXcm7uPbo+fygAskrwyCGK" +
       "yISdz8ng5gMfmHiKAtr9wwdGv/7e7zz+1twBQIsHrjTgxSxtAmoAUwjM/Atf" +
       "cP/uG1//8NdOHjhNAGJkKBqalOyDzMqhs9cACUZ73YE+gGIMsPQyr7k4tUxb" +
       "1lRNEA0l89L/Pv/a4qf/7ckLWz8wQMmeGz38wgIOyl+FQ+/40qP/cXcu5oSU" +
       "hbgDmx002/LmrQeSG54nbDI9knf+5V2/8XnhQ4CBAev5WqrkRHZ9boPrc+Sv" +
       "BFuRvGcWzXa20SwrR4DIB6+xCfI0E8xVtBs44Mdu+Yb+wW99YhsUjkeZY42V" +
       "J5765R/sPPnUyUOh+IHLouHhPttwnDvZy7fz9QPwOQGe/82ebJ6ygi0d39Lc" +
       "jQn37gcFx0kAnPuupVY+ROefn33sM7/z2ONbGLccjURtsNH6xF//z5d3PvDN" +
       "L16B7G4QbdtQhNx5kVxVOFf1oTzdyXTLzQ7ldT+ZJff4h3nlqI0P7fIuSe/5" +
       "2ndfzn33T57Phz26TTy8jCjB2RrpXJbcm2G+/TiJ9gR/Bdqhz9E/dcF47vtA" +
       "Ig8kSiBY+EMPEHpyZNHttj51w99/7s9ue9tXr4NOdqCzhi3IHSHnL+gMIA7F" +
       "X4FYkDhvfst23cQ3guRCDhW6DPx2vd2R/zp9bR/rZLu8A/a747+Ghviuf/zP" +
       "y4yQk/YV3O5Yfx5+5oN3Nt/07bz/AXtmve9OLg9yYEd80Lf0cfPfT95/+s9P" +
       "Qjfw0AVpd7vNCUaYcRIPtpj+3h4cbMmP1B/dLm73Ro/sR4fXHPf7Q8Me5+0D" +
       "fwP5rHWWP3uMqs9lVr4HPPfvstj9x6n6BJRniLzLfXl6MUtev8eMZxzPDoCW" +
       "ipzLroASw5YEg94dHtmSfZa+KUvI7Zw2rjr/naPaZRq9fle7119FO/Yq2mXZ" +
       "4Z5aN2UG8cH+Qpky/StpNnmRmt0Lnod3NXv4KprxP4xmZ3xHkQCfK3JWgB1T" +
       "660vqFYuJjkBJuNUaae6k+MSrjzwdVn2DSCe+flbGOihapZg7Gly+9qQLu4x" +
       "IgfeysCKubg2qlcyV+WH1gss3HMHUYO0wRvQu//pPV/+1Qe+AVbXADoVZZ4P" +
       "FtWh0EKH2UvhLz7z3rte9tQ3352HYmA17pd+t/rNTOr6WuiyJHc9dQ/WnRks" +
       "Nt/lkoIfUHn0VOQMWS6idAhPLQAx2N6GtR8JbXDuUz3U7zf2PmSRV2fxNEmm" +
       "qoUWg3UfgQstfhnjy3GvqpOCgNMTttUtUaION9sU05rhi1I9Sj0ZFctKOiwp" +
       "qsX3R+5yJbiL1Tgy7A7san22qQ8EeWq7vL10taVKkAy3bPG0izVdj/GETmtm" +
       "C4bLBaFRpcphuVeQqjxhIc6gLJplK0rnQVT2UtWsmildW7Y3mzHNdWmcNgdj" +
       "oq6ZPlcdBF3N5/ipL8QRwijMOpEHqlysRpFWb7BRNMD6jC5LJsvIPuf6gq+u" +
       "B3OEjU1hQhRDzaT7UyVi2aLb0g0KEbkCpZeSoTPsuv6SqNQH607DLLEzYVFs" +
       "u5Q5tZFkplnkosmEs954QI2LTXGOrrCo5XTI2Zrp9lRCICN6Wlw6zIDfVEid" +
       "92LRNPpNd7awbbGp+TMB2fC8GK7dDSj1NzjtF/BQ5ufBUi+vuIkeCr1NUgho" +
       "EU+oYrnBTQbt8qQ7UUclPQ7mTEnzJ01HtjyRG7hIT+uOdKUfm8pY492xYw10" +
       "BB8MuwuaoIIxygmdeifg2A2nqKbf3+hTne6umBWP4pzGEsI0oOaI5BTx8dpM" +
       "RUWlFsNyzSPnzc0qnqw38ag3qZT8glhNBLZiFcfebFVw+yjFtpqig6Mqyw9Y" +
       "gdN9nzFHdacjtBKlsnY0wtm4Wh2xZjPKxQdkY05a5TYpuwtKiPpYj4PxoT0I" +
       "eN0xQ0cvkjW0tYnQYl/AiEap5cmUPFvM2tW6PcQ7Y9vm/YWhtULRmTFjZEZQ" +
       "6YhO+W7RV1aN/pKc+ixnNFME42zdGo8Vp60RGkuvWu6y3prgNo4slygutAas" +
       "VZTsQuCOsXbHWbYXcd8qItGs33eb/IbZNMh+fVTjOzHrdYi6iHFSpTxcK7US" +
       "zlRn9MxuTJcSmhBuaMMbZilEjUQU+EQwyAWOEolkWKjbmtQDFcHHNo6adn2B" +
       "kGkN4/2R19XQGikszQnSnUzrCI1xPNNCOUtNQ4sWjHoyW3fDWVfUTLSAV8kC" +
       "W/WCqSIgMa+bQ4PXJstF2kiU0ig1DQxFx2ltqPed4VQD+2LNHkjc2KsgRmsq" +
       "WPx4wrmsnXaHvtF2fU4ozJcWsRiVfWLAILI/WRfDqcz3WWOucJUoLofN5bAf" +
       "4J2O2gR+167XSlifpHoqEi9WTiNWpktrNG/2C/AgZJimthqUjL6ucTSiMmBQ" +
       "cw1ziz6lo1N14PcZtufiyHBmrfsrvD2sDJkm22+gbBGvjMlxUB5okybSWAhG" +
       "se9uNguk1KES0ULH/VoVHdUqHOOFVguXuJgnqRortTuqyDJGiZ5OKK2HVAKx" +
       "GmHjcCy3Zxt0PNuMKLFPOMsCUVnQtYKGU71kMsFhejhBXaJAJJPpGGFwstle" +
       "Yg2qjwdzMiyL/syawz6vaS1sHTYmtXWFpXsG48qTQXfgF3tYjy5yAkV6brE2" +
       "muJE7DJD3TCI6aqjz/wYZzvwxibLLaIybHAx5qc9FcdDQnYlH8EN3euV08XU" +
       "94r9maONNvRkzvQ3dl8UaWysTn1xahVjdBSleuCrgDSajc7GiDdLc4wNmvUO" +
       "TFdpu1YuTEbtWY/w6sUyXKdTZiS6EyJNxzrSo3rtCmLLbbVTrpaZIWPUKrN5" +
       "34UDQRmEVqxhVtuM64BT6Ght1QhWw/REYIoREStNVNQWRmchbUYutmxylCpb" +
       "DhrT4qZe0ccdh47FVMT9Oql4o1hkKpJYotBxY4ElmDdsxjWxrkrCYA5XkTUG" +
       "r6s+upyQM48eamuPNrkihy96Ul0NptWFuG47uGiP1pFcQGsarcoBljbITuy1" +
       "TZEiSh2xz5PNLloQzHKvbMFxKbS8pSANu1KjUtFtrq063qC3mGxsotswU3Iu" +
       "IkthY489seF2LcHVOzXC6nQ0157SdQF2V0qgDq0RXnLaPWI91mNz3RGlOTqa" +
       "jGZ6QVG6qlVOQtRs9vmpbCXmFFB5hEyZMkEKU3vtttXKRgrSCDZncmPQaCRE" +
       "0VkkrAU2v2GjToTDaWpP12ursW6Mx71GiYQFMzbiAJ4Z9gq4lDYdaCmjL+tx" +
       "PRIjHZ6C4JhIDdr0KVxvl6uiNS5WlXoA+2wL7WzSRrRYJzQXzhd1rFGfw/Ss" +
       "76g6NdLnMdyQ1DlO+u0uzhRL9roYxT6PG93umlFnbqtbx+1xyRiVUaWRFrHa" +
       "HI+Wq/JUpuoJXCiZKt5A1U5ouxW+1BlWlJ7ZFmcjqqGIfMCEY6HDD9tqlSmo" +
       "JXioYSM1bHMWp3S6hVY/mmNzOK1OoxYqboBzM4wx5Ypzl2XZkogsqrQ1HQWz" +
       "6sgn7BZXCNSIW87n7So/4IZTp8oabZkNWiPTWLqGic2IcCVSrmCgq7oPlEy6" +
       "miPiw6gRoyHien4ECB7pF9F17E/LC5Ikpa4sVHkXZUdsX41GzqAo8qM0gHXZ" +
       "Cjy1JzcrfJ9CVUYQcWGNlFS0PW+u+easUQ1QsjyG5y4uh0uJKejNZQsx/PrA" +
       "xZOSQxdEEGh4Ea7UlGgiV4vipEEGTpvkHE6rJi0KM8dLx+jYg8aIQHwFxfVp" +
       "t7updB1UENjekE6HVmOeJn51VB0bLYkv14dLjypXYiyaDIR0w3WnZFekMHVN" +
       "zjp41cNYuYOvU3o+iuAUQWpqj1kk3KzZK4xWJuzRvbVSrVcn9c2cquKSndBo" +
       "YRS1sGLd8bBiVVKkMtIOsC5GYHW+tRzFw2patHSrRtIDodBmcQMWmG6g183S" +
       "ZlxccetxqyIxRJmWlvWhyNeTqr/CDblHzQxFReVK0Zut60q4lptNlWpH4yGj" +
       "l9sDrNabCATds5OapsUrWOG1lBz2AspMw43WYhlqNO3OVoNFio1dzV52gtV0" +
       "zotT0Yh6xTEx8OfI2EyKTRDAFJ1OTXrcM8hqz5o5ZA/vtHWSapu6GzgjE+sS" +
       "QZfpOGwsDyMz9brT9aI+KalW7JFNa4Z1ejNxtvQjE42F0mw8mzV43GutNbhC" +
       "t5EZ0poEKbmsDTcj2MBJVZFkeT5ZieasWTCdKGIpEGiDiRJv5PVIKoQtesXL" +
       "LcROe5M16UyHU3lqNN0Cj1nuZryS4FULhJD+aLAC3BlXBLyuDB1M7EboROSG" +
       "UUXB4aA6U7E2WlQNTyzCblDY0F7H63Xn2GhQmMNNAkbK89LCl7UC12yUU60f" +
       "8fV0WugYQiSGhYY78R0WvCl1wsWcl4Vyt97xm2lqVOeyiqJyk+x1EpJfrilV" +
       "iHtTuO3ivqDEyjh1w2WP8JcqLnbLMC76VCzA1blSC1r9vmHzETVP1WWKVpA2" +
       "7I7Kpcqks1xgVXql1UZVxmtGLgXeE/xOmaHmaISZVIAS+hqXhOFiTo03Sy9e" +
       "eBIsppaijJyhIlC4taqKzqCaKJtMly4ZFYvLKj4uDTbNzjJVmz0vSea93qbl" +
       "rbSmja68FqaX4NG40Ckx6+qsESoSse4hIzMdNTtzRFn3cKkmI9UOMy+CCUOq" +
       "so6phqovNkCu63cSH1vX0v4amyZlK9mkorU21EK3SzeHaS3AooWE1KiCQsy5" +
       "mNxsCpLXrKjSnPSUJBV8QykbY5yt8awbun6lWA6dhUygsV/ywDuEMqTM2kZa" +
       "+w1DjhWi15hXl7wYa4qGJlRvEfb02cAu8+y8D4ImwbZXtVKtXJZqC3feshcd" +
       "MkE1AWvRBI53ClF3oKdw6DQDVAqkdlxuqEZa5v2w5iyMEj+TZS/kZG66ARtO" +
       "rjGCxUF/NCPUXo+djgtyeTCpV6gyl9Y8z17pHGPLDGtO0OHSEV2wtMja0quy" +
       "lEcTNFuq06rV02w9CbimD8KS2BM7Ul+Mu20qbRIVq1weFPlJfeUZMEd7aVTX" +
       "1YJhDKmOP0CmbL84LGEJGiD6gmDdcoDK8Zo2mB7cJcAkm2UmEEINLJsinMaM" +
       "zzJqGysU7FWtrrJDApVNy7T7etuU+QYxVScTOk1BzPcmNIejmwJicgtvZoyn" +
       "s7Gtay4Gx4XumFZiozyAZ0TV33iilijUujUx5wasz/2oOZ4rCzOMiga1AHse" +
       "bsojlREG1yQFxDmnkbaSQgsJCQwFM+ZMQtod00w3NkpdXbRkAmyslAZpd0lf" +
       "idXFCMZn4hpGSaLtiH2jL4M31Px4MXpxr9Q35ycF+zegP8IZwbbqvix57f7B" +
       "Sv45DR27NTt8rH5wIAhlR5Z3Xe1iMz+i/fC7nnpaHn6keHL3ILUeQGcC2/kJ" +
       "Q4kU45Co7BL/oaufLVL5ve7BAd/n3/Wvd07etHrbi7gRuueYnsdFfox65ovd" +
       "10m/dhK6bv+477Ib56OdHjl6yHfWU4LQsyZHjvru2rdsbt37wPPmXcu++fiR" +
       "1cHcXfm86g3bub/GOfWvXKPuySx5PIAuLJVg//Zu/w7p2AnMKX9le8GBHz3x" +
       "Qqcvh0fLC35+H/gte8C7u8C7Lz3w37xG3Yey5H0BdB4Ap48fQR5AfP+PC/Fu" +
       "8Ax3IQ5feogfvUbdx7LktwLoJgCRPHL4e4Dvt38MfLdmhdkx9WwX3+ylx/f7" +
       "16j7dJZ8couPPXJWe4Dv2R93/u4Ez6O7+B596fH96TXqPpclfxxANwb24Tu9" +
       "fWyfeTHYkgB61VWv67O7xzsu+8fQ9l8u0iefPn/j7U9P/ya/sd7/J8oZErpR" +
       "DQ3j8H3Gofxpx1NULYdxZnu74eRfXwigV1/jHwXZlW6eyfX//LbPlwLoFVfq" +
       "E0DXgfRwy68AIjveEtBW/n243VcD6OxBOzDoNnO4ydeAdNAky/6Vs3fLWrnW" +
       "nyEaoh94gnQF8yYnjsbH/Rm85YVm8FBIfeBIIMz/BbYXtMLt/8AuSc8+PaDf" +
       "/nzlI9tLeskQ0jSTciMJ3bD9v8B+4LvvqtL2ZJ3uPfj9c58689q9IH1uq/CB" +
       "yx/S7Z4r34i3TSfI77DTP7r9D9740ae/nt8Y/B9qommwnicAAA==");
}
