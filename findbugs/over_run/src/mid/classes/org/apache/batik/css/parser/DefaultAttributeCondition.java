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
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMUZbWwUx3V8/jY2/gAMMWDAGCIIuStNCEpMQ4zBYHL+kA1E" +
                                                              "tRvM3t6cvXhvd9mdsw8nLoGqBUUqisBJSRqsSoV+IBLSqGmjViH0Iw0RSRE0" +
                                                              "apOghrb5kbQJUvjROC1t0/dm9m4/znfIaqSetHN7M+/7vXnvzdzpa6TQMkmD" +
                                                              "IWlRKcj2GtQKduF7l2RaNNqiSpa1DWb75Uf/fHTf5O9K9wdIUS+ZOShZ7bJk" +
                                                              "0VaFqlGrlyxUNItJmkytDkqjiNFlUouawxJTdK2XzFGstrihKrLC2vUoRYAd" +
                                                              "khkm1RJjphJJMNpmE2BkUZhLE+LShJr9AE1hUi7rxl4Hoc6D0OJaQ9i4w89i" +
                                                              "pCq8WxqWQgmmqKGwYrGmpEluM3R174CqsyBNsuBudY1tiK3hNRlmaHiu8pMb" +
                                                              "jw1WcTPMkjRNZ1xFq5taujpMo2FS6cxuUmnc2kO+SvLDZIYLmJHGcIppCJiG" +
                                                              "gGlKXwcKpK+gWiLeonN1WIpSkSGjQIws8RIxJFOK22S6uMxAoYTZunNk0HZx" +
                                                              "WtuUu30qPn5baPxbO6uezyeVvaRS0XpQHBmEYMCkFwxK4xFqWs3RKI32kmoN" +
                                                              "HN5DTUVSlVHb2zWWMqBJLAEhkDILTiYManKejq3Ak6CbmZCZbqbVi/Ggsn8V" +
                                                              "xlRpAHStdXQVGrbiPChYpoBgZkyC2LNRCoYULcrjyIuR1rHxfgAA1OI4ZYN6" +
                                                              "mlWBJsEEqREhokraQKgHgk8bANBCHULQ5LGWhSja2pDkIWmA9jMyzw/XJZYA" +
                                                              "qpQbAlEYmeMH45TAS3U+L7n8c61j3eGHtC1agOSBzFEqqyj/DECq9yF10xg1" +
                                                              "KewDgVi+MvyEVPvSoQAhADzHByxgfvrw9ftW1Z87L2DmTwHTGdlNZdYvn4jM" +
                                                              "vLSgZcXd+ShGiaFbCjrfoznfZV32SlPSgExTm6aIi8HU4rnu33z5kVP0wwAp" +
                                                              "ayNFsq4m4hBH1bIeNxSVmpupRk2J0WgbKaVatIWvt5FieA8rGhWznbGYRVkb" +
                                                              "KVD5VJHOf4OJYkACTVQG74oW01PvhsQG+XvSIIQUw0PK4VlIxId/MzIcGtTj" +
                                                              "NCTJkqZoeqjL1FF/dCjPOdSC9yisGnooAvE/dPvq4NqQpSdMCMiQbg6EJIiK" +
                                                              "QSoWQ7Jl4T6F1BjaSGNSQmXpBAc7LMqNEcT4M/5vnJNok1kjeXngrgX+ZKHC" +
                                                              "Ptuiq1Fq9svjiQ2brj/bf0EEIm4e25qMrAH2QcE+yNkHgX1QsA9mZU/y8jjX" +
                                                              "2SiGCBBw7xAkCsjU5St6Hty661BDPkSmMVIAvkHQ5RmVq8XJKKky0C+fvtQ9" +
                                                              "efGNslMBEoCkE4HK5ZSPRk/5ENXP1GUahfyVrZCkkmkoe+mYUg5y7tjI/h37" +
                                                              "vsDlcFcEJFgIyQzRuzCPp1k0+jPBVHQrD37wyZknxnQnJ3hKTKoyZmBiqmnw" +
                                                              "+9ivfL+8crH0Qv9LY40BUgD5C3I2k2CPQTqs9/PwpJymVPpGXUpA4ZhuxiUV" +
                                                              "l1I5t4wNmvqIM8ODr5q/zwYXz8A92AjPantT8m9crTVwnCuCFWPGpwUvD1/q" +
                                                              "MY6/9du/3sHNnaokla4WoIeyJlf2QmI1PE9VOyG4zaQU4P54rOvo49cO9vH4" +
                                                              "A4ilUzFsxLEFsha4EMz89fN73r767ok3A07MMijfiQh0Qsm0kjhPynIoiXHu" +
                                                              "yAPZT4U8gFHTuF2DqFRiihRRKW6Sf1UuW/3CR4erRByoMJMKo1U3J+DM37KB" +
                                                              "PHJh52Q9J5MnY/V1bOaAiZQ+y6HcbJrSXpQjuf/ywidflY5DcYCEbCmjlOfY" +
                                                              "Am6DAq75PGjGOCYW2qAotDi/xsKYd+1qbBh7EhGLdZlKHNw0bJezM7WTe35d" +
                                                              "PLoxVaqmQhGQ91vtF3+25f1+HgYluPtxHplVuPZ1szngisEq4Z7P4JMHz3/w" +
                                                              "QbfghCgMNS12dVqcLk+GkQTpV+ToJ70qhMZqrg49/cEzQgV/+fYB00Pjj34W" +
                                                              "PDwufCt6nKUZbYYbR/Q5Qh0c7kHpluTiwjFa3z8z9vMfjB0UUtV4K/YmaEif" +
                                                              "+f2/Xw8e+9NrUyT+4oiuq1QSCe0ODPh0qq71e0ioVbT6+D/2feOtTsgtbaQk" +
                                                              "oSl7ErQt6qYLjZqViLhc5nRQfMKtILqHkbyV4AkeTHy8k0sTSstEuEyEr7Xh" +
                                                              "0Gi586zXa66GvF9+7M2PK3Z8fPY619zb0bvTSrtkCLNX47AMzT7XX9O2SNYg" +
                                                              "wN15ruMrVeq5G0CxFyjKULutThPqa9KThGzowuJ3fvGr2l2X8kmglZSpuhRt" +
                                                              "lXg+J6WQSKk1CKU5aay/T+SRkRIYqriqJEN53LqLpk4Km+IG49t49MW5P173" +
                                                              "/Yl3ef4SCWs+R8+38CDhL738NOhUjY+ufPu9lye/WyziKMeu8OHN+2enGjnw" +
                                                              "l08zjMyL5BQbxYffGzr9dF3LvR9yfKdaIfbSZGZPA/Xcwf3iqfjfAw1FrwRI" +
                                                              "cS+pku2T1w5JTWAN6IXThpU6jsHpzLPuPTmINrkpXY0X+Heqi62/TrpDv4B5" +
                                                              "wtwpjTPRi4vgabCrRoO/NOYR/tLLUZbzcQUOq1KVqNQwdQZS0qivGFXkIAto" +
                                                              "qi5Laoct4xpRgXHcikOfoNWeNQi3eVVA+rfavG7NooIsVMDhwUxJs2EzUo6G" +
                                                              "tKANpdu726YSNjpNYRfDs8pmtyqLsLtzCpsNG8xqGVSGUkyjOHG3T9KhHJIm" +
                                                              "HY4r0xz5p4j4zjPursLZzgQz1MJsR05eFE4cGJ+Idp5cHbDzZjMIzHTjdpUO" +
                                                              "U9VFqpCXGH9maOcHbWebrb08mX/lyLzyzH4cKdVn6bZXZk8hfgavHvhb3bZ7" +
                                                              "B3dNo9Fe5NPfT/KH7adf27xcPhLgdwViV2fcMXiRmrx7ucykLGFq3sLVkPZY" +
                                                              "NXpiCTzrbY+t90eYExM+Z6dbyGyoOSrg/hxrX8PhYejUBihLH9PS3fpau6nA" +
                                                              "r3Wu9/sYhMGgbjJ/F4A/W5NOUI/dbPt5ChZOdPNpJ13VpGy22VZ88/Rtlg01" +
                                                              "h12O5Fgbx+Gb0BCAzTr8+cfR/fDno3s9PJ22Ap3T1z0bag79JnKsfQeHJyHx" +
                                                              "gu5hT5VwFH/qf1Z8Fi5h6XvAlv6B6SueDTWHcqdyrJ3G4aRQvMeTxx3Fv/f5" +
                                                              "eLwOnp229Dunr3g21BzK/STH2os4/IiREqa7z3BppZ+fvtJJRm7JekeEbeu8" +
                                                              "jCtsce0qPztRWTJ3Yvsf+D1F+mq0HA59sYSqursq13uRYdKYwpUpFz2WODu8" +
                                                              "zMj8HNdYeJDnL1yLswLnl4zMngqHkXwY3ZCvQFL1Q0La5N9uuPOMlDlwwFS8" +
                                                              "uEEuAHUAwdfXjdTZ+q5cN3DNcDQ24eCQad5knrctSPtxzs386OoklnrqNP9b" +
                                                              "IlVTE+KPCTi9T2zteOj6XSfF1YysSqOjSGUGHPbELVG6Li/JSi1Fq2jLihsz" +
                                                              "nytdlupNqoXAzl6Y7wrYbqhDBkZRne/ewmpMX1+8fWLd2TcOFV2GE0QfyZMY" +
                                                              "mdWX2donjQQ0DX3hqY610LXwK5Wmsvd2Xfz0nbwafoIi4iBcnwujXz569kpX" +
                                                              "zDCeCpDSNlIIrRdN8nPHxr1aN5WHTc8puSiiJ7T0PxgzMeQl3IXcMrZBK9Kz" +
                                                              "eLXHSEPmpUHmdSccLkeouQGpI5kKXyeTMAz3KrfsJhzuSaKlISL7w+2GYd+W" +
                                                              "5PdxyxsG3+BXcWj9L4gNxbh7HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
