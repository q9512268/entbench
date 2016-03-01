package org.apache.batik.css.parser;
public class DefaultClassCondition extends org.apache.batik.css.parser.DefaultAttributeCondition {
    public DefaultClassCondition(java.lang.String namespaceURI, java.lang.String value) {
        super(
          "class",
          namespaceURI,
          true,
          value);
    }
    public short getConditionType() { return SAC_CLASS_CONDITION;
    }
    public java.lang.String toString() { return "." + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYfWwUxxWfO38fBn8AhhowYAwSTnJbK6FpZNrGGIwNZ3yy" +
                                                              "CVLtlmNud863eG932Z2zz05cAlICyh8oCk5CquK/iNpGJERVo1atgly1ahKl" +
                                                              "KYJGbT7UpFX/SPqBFP6JW9E2fTOzX7d3dsJfPWnn9mbeezPv6/fe3OWbqMq2" +
                                                              "ULuJdQXH6bRJ7HiSvSexZROlV8O2fRhmU/ITfz5/cvF3daeiqHoUrcpie1DG" +
                                                              "NulTiabYo2iTqtsU6zKxDxGiMI6kRWxiTWKqGvooWqvaAzlTU2WVDhoKYQRH" +
                                                              "sJVATZhSS03nKRlwBFC0OcFPI/HTSD1hgu4EqpcNc9pnaC1i6A2sMdqcv59N" +
                                                              "UWPiOJ7EUp6qmpRQbdpdsNBdpqFNj2sGjZMCjR/XdjmGOJDYVWKG9pcbPr39" +
                                                              "ZLaRm2E11nWDchXtYWIb2iRREqjBn92nkZx9An0HVSTQigAxRR0Jd1MJNpVg" +
                                                              "U1dfnwpOv5Lo+VyvwdWhrqRqU2YHomhrsRATWzjniEnyM4OEWurozplB2y2e" +
                                                              "tq67Qyo+fZc09+zRxh9VoIZR1KDqI+w4MhyCwiajYFCSSxPL7lEUooyiJh0c" +
                                                              "PkIsFWvqjOPtZlsd1zHNQwi4ZmGTeZNYfE/fVuBJ0M3Ky9SwPPUyPKicX1UZ" +
                                                              "DY+Dri2+rkLDPjYPCsZUOJiVwRB7DkvlhKorPI6KOTwdOw4CAbDW5AjNGt5W" +
                                                              "lTqGCdQsQkTD+rg0AsGnjwNplQEhaPFYW0Ios7WJ5Qk8TlIUrQ/TJcUSUNVx" +
                                                              "QzAWitaGybgk8FJryEsB/9w8tPvcw3q/HkUROLNCZI2dfwUwtYWYhkmGWATy" +
                                                              "QDDWdyaewS2vno0iBMRrQ8SC5ieP3Hrw7raF1wXNhjI0Q+njRKYp+VJ61fWN" +
                                                              "vTsfqGDHqDUNW2XOL9KcZ1nSWekumIA0LZ5Ethh3FxeGf/3NR18gf4+i2ACq" +
                                                              "lg0tn4M4apKNnKlqxNpPdGJhSpQBVEd0pZevD6AaeE+oOhGzQ5mMTegAqtT4" +
                                                              "VLXBf4OJMiCCmSgG76qeMdx3E9Msfy+YCKEaeFA9PBuR+PBviiwpa+SIhGWs" +
                                                              "q7ohJS2D6c8cyjGH2PCuwKppSGmI/4l7uuL3S7aRtyAgJcMalzBERZaIRUm2" +
                                                              "bZanAI3SXpLBeY1yz0J2KdwQcRZ75v9l1wKzxeqpSATctDEMEhrkV7+hKcRK" +
                                                              "yXP5PftuvZR6UwQgSxrHihR1wdZxsXWcbx2HreNi63jZrVEkwndcw44gggJc" +
                                                              "OgHgAOhcv3Pk2weOnW2vgGg0pyrBH4x0R0m16vVRxIX+lHz5+vDitbdiL0RR" +
                                                              "FIAmDdXKLxkdRSVDVDzLkIkCmLVU8XABVFq6XJQ9B1q4MHXqyMkv83MEqwAT" +
                                                              "WAUAxtiTDLu9LTrC2V9ObsOZjz+98sys4eNAUVlxq2EJJ4OX9rB/w8qn5M4t" +
                                                              "+JXUq7MdUVQJmAU4TTHkFUBgW3iPIpjpdiGb6VILCmcMK4c1tuTibIxmLWPK" +
                                                              "n+GB18Tf14CLV7C82wLPVicR+TdbbTHZuE4EKouZkBa8JHxtxLz4zm//ei83" +
                                                              "t1s9GgJlf4TQ7gBiMWHNHJua/BA8bBECdH+8kDz/9M0zYzz+gGJbuQ072NgL" +
                                                              "SAUuBDM/9vqJdz/84NLbUT9mKZTsfBq6n4KnJJtHsWWUZHHunwcQT4P8Z1HT" +
                                                              "8ZAOUalmVJzWCEuSfzds73rlH+caRRxoMOOG0d2fL8Cf/9Ie9OibRxfbuJiI" +
                                                              "zCqubzOfTMD4al9yj2XhaXaOwqkbm557DV+EggAgbKszhONqlNsgyjVfDw0Y" +
                                                              "52TFNS6KK5vfxV16H6eR+HgvMwfnRHztq2zosIOpUZx9gb4pJT/59icrj3xy" +
                                                              "9RbXpbjxCkbCIDa7RfCxYXsBxK8Lw1A/trNAd9/CoW81agu3QeIoSJQBZu0h" +
                                                              "C+CwUBQ3DnVVzXu/+GXLsesVKNqHYpqBlT7MUxDVQewTOwtIWjC/8aBw/VQt" +
                                                              "DI1cVVSiPLP25vJ+3JczKbf8zE/X/Xj39+c/4CEnYmyDw85/7GBDpxd7/FMd" +
                                                              "rnTB2CuSYKFNSzUjvJG6dHpuXhl6vku0DM3FBX4f9K8v/v4/v4lf+NMbZepF" +
                                                              "HTXMezQySbTAnlHYcmsJxg/yXs3Hp/tvLFa8/9T6+lJ4Z5LalgDvzqXBO7zB" +
                                                              "a6f/1nr469ljd4Dbm0OGCov84eDlN/bvkJ+K8nZTQHZJm1rM1B00GWxqEeir" +
                                                              "daYWm1nJw7fdc22TCyWdjms7y2NnmajwEGkp1mWy8/Aya0fYMASJP06oV/U5" +
                                                              "+LNkDniZXQxH8mmbJi01B1STTtt6pWXxxK9qZva6LWk5FkF50B689rP+j1Lc" +
                                                              "Y7UsJDw7BcKhxxoP1J1GYYDP4BOB57/sYWdnE6IBbO51utAtXhtqmiwtdi5z" +
                                                              "byxWQZpt/nDiex+/KFQIt+khYnJ27onP4ufmRLqIu8y2kutEkEfcZ4Q6bBgr" +
                                                              "8AxaZhfO0ffRldmf/2D2TNTx1H6KqgCaLOr5MeL1XC1hs4uzVndd/NfJx98Z" +
                                                              "giZhANXmdfVEngwoxSFbY+fTAT/41x8/gJ1TM5tTFOk0HRB7gA1J8b77i6El" +
                                                              "m+jh0we9yG5mS63wdDmR3XXnSbEU6zKBby6zZrFhgsLt3AhUQV9p7c6VLsBt" +
                                                              "smyHzSrI+pJLv7ioyi/NN9Sum3/oD7zL8y6T9ZA+mbymBbwY9Gi1aZGMyhWp" +
                                                              "F/XT5F/TFG1Y5gLA2iD+wjUoCJ5HKFpTjoeiChiDlCcBQ8KUELH8O0h3mqKY" +
                                                              "TwebipcgyWMgHUjY6+Om25ns+gJ3F+/fKM+6hUhpveUuXPt5LgwU2G1FSML/" +
                                                              "x3FTLS/+yQEYnD9w6OFbX3le9LWyhmdm+L0fEky02F4V2rqkNFdWdf/O26te" +
                                                              "rtvuZn6TOLCfBhsCsdoDCGCyIGoNNX12h9f7vXtp99W3zlbfAMwaQxFM0eqx" +
                                                              "wL8o4i8D6BzzUCLHEuWgBGo070e7Y385du2f70WaeS/jgE/bchwp+fzV95MZ" +
                                                              "0/xuFNUNoCoANlIYRTHV3jutDxN50ipCpuq0kde9v3xWsYjHLAG5ZRyDrvRm" +
                                                              "2b2IovZS9C29K0KbN0WsPUy6g3RFdTtvmsFVblkiYE+UmYpUYtA0nbJTcZRb" +
                                                              "3jR5bj/Hhsz/AGHnpJCsFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
