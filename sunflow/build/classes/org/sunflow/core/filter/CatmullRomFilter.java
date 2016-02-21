package org.sunflow.core.filter;
public class CatmullRomFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return catrom1d(x) * catrom1d(y);
    }
    private float catrom1d(float x) { x = java.lang.Math.abs(x);
                                      float x2 = x * x;
                                      float x3 = x * x2;
                                      if (x >= 2) return 0;
                                      if (x < 1) return 3 * x3 - 5 * x2 +
                                                   2;
                                      return -x3 + 5 * x2 - 8 * x + 4; }
    public CatmullRomFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wcRxmfO78f8SuxnbqJk7hOVSfpbULaouJQklzt2uHs" +
                                                              "GDu1wCm5jPfm7I33dje7c/bZxSWtRGMqNQrUbVNE/ZcrCmqbClGBBK2MkGir" +
                                                              "FqSWilIQLUhIhEdEA1KRCFC+b2bv9nG2S4TESTe3N/PN95rf/OabfeYyKXNs" +
                                                              "0s4MHuOzFnNiPQYforbDUnGdOs4x6Euqj5fQv524NHh7lJSPkbpJ6gyo1GG9" +
                                                              "GtNTzhjZqhkOp4bKnEHGUjhjyGYOs6cp10xjjDRrTn/G0jVV4wNmiqHAKLUT" +
                                                              "pJFybmvjWc76XQWcbE2AJ4rwRDkUHu5OkFrVtGY98c0+8bhvBCUzni2Hk4bE" +
                                                              "KTpNlSzXdCWhObw7Z5PdlqnPTugmj7Ecj53Sb3VTcCRxa1EKOp6v/+Dq+ckG" +
                                                              "kYKN1DBMLsJzhplj6tMslSD1Xm+PzjLOaXIfKUmQGp8wJ52JvFEFjCpgNB+t" +
                                                              "JwXeb2BGNhM3RTg8r6ncUtEhTnYElVjUphlXzZDwGTRUcjd2MRmi3V6IVkZZ" +
                                                              "FOKju5XFx080fLuE1I+Res0YQXdUcIKDkTFIKMuMM9s5lEqx1BhpNGCxR5it" +
                                                              "UV2bc1e6ydEmDMqzsPz5tGBn1mK2sOnlCtYRYrOzKjftQnhpASj3X1lapxMQ" +
                                                              "a4sXq4ywF/shwGoNHLPTFHDnTimd0owUJ9vCMwoxdn4aBGBqRYbxSbNgqtSg" +
                                                              "0EGaJER0akwoIwA9YwJEy0wAoM1J25pKMdcWVafoBEsiIkNyQ3IIpKpEInAK" +
                                                              "J81hMaEJVqkttEq+9bk8eODcvUafESUR8DnFVB39r4FJ7aFJwyzNbAb7QE6s" +
                                                              "3ZV4jLa8uBAlBISbQ8JS5rtfuHJwT/vKK1Lm+lVkjo6fYipPqsvjdW9siXfd" +
                                                              "XoJuVFqmo+HiByIXu2zIHenOWcAwLQWNOBjLD64M//hzZ77F/hQl1f2kXDX1" +
                                                              "bAZw1KiaGUvTmX0XM5hNOUv1kypmpOJivJ9UwHNCM5jsPZpOO4z3k1JddJWb" +
                                                              "4j+kKA0qMEXV8KwZaTP/bFE+KZ5zFiGkAr5EgW8ZkR/xy4mqTJoZplCVGpph" +
                                                              "KkO2ifHjghopqnDmwHMKRi1TcbJGWjdnFMdWFdOeKPxXTZsp4AUgSIlTnsnq" +
                                                              "+rCZ6RUdMQSb9f8xk8NoN85EIrAQW8I0oMMO6jP1FLOT6mL2cM+V55KvSYjh" +
                                                              "tnDzxMlNYDHmWoyhxZi0GAtbJJGIMLQJLcvVhrWagl0PtFvbNfL5IycXOkoA" +
                                                              "ZtZMKSQaRTsCx0/co4Y8nyfVvx757f6++U/8LEqiwB7jcPx4p8B23ymAx5dt" +
                                                              "qiwFJLTWaZBnRGVt/l/VB7JyYeb+0S/uFT74aR0VlgEj4fQhJOOCic7wdl5N" +
                                                              "b/3ZSx9cfGze9DZ24JzIH29FM5EvOsLLGQ4+qe7aTl9IvjjfGSWlQEJAvJzC" +
                                                              "RgFOaw/bCPBGd56DMZZKCDht2hmq41CeOKv5pG3OeD0CZ43YNEvIIQxCDgr6" +
                                                              "/uSI9eQvfvqH/SKTeaav9x3RI4x3+9gFlTUJHmn0UHXMZgzkfn1h6JFHL589" +
                                                              "LiAFEjesZrAT2ziwCqwOZPBLr5x+5713l9+KejDkcLxmx6FKyYlYNn0Inwh8" +
                                                              "/41fZATskMzQFHfpaXuBnyy0fKPnGzCVDtsYwdF5twHg09IaHdcZ7oF/1u/c" +
                                                              "98KfzzXI5dahJ4+WPR+twOu/7jA589qJv7cLNREVT0ovf56YpN+NnuZDtk1n" +
                                                              "0Y/c/W9ufeJl+iQQOZCno80xwYdE5IOIBbxF5EIR7f7Q2G3YdDp+jAe3ka+i" +
                                                              "Sarn33p/w+j7L10R3gZLIv+6D1CrW6JIrgIY20vcJsDPONpiYduaAx9aw2TT" +
                                                              "R51JUHbLyuA9DfrKVTA7BmZVKBacozZwXS4AJVe6rOKXP/xRy8k3Ski0l1Tr" +
                                                              "Jk31UrHhSBUgnTmTQJM561MHpR8zldA0iHyQogxh0retvpw9GYuLBZj7Xut3" +
                                                              "Dnxj6V2BQgm7693p4s9O0d6EzW4JUnzckyukRnzK10mNT2dEPG/mpLWIyCVv" +
                                                              "Yxq3rlV9iMpp+YHFpdTRp/bJGqEpeKL3QMH67M//9Xrswm9eXeX4qOKmdbPO" +
                                                              "ppnu86kETQa4f0AUZh53VT+4d2OC59LFtI9a2tcg9l1rE3vYwMsP/LHt2B2T" +
                                                              "J6+B07eFkhRW+c2BZ16960b1q1FRW0o6L6pJg5O6/ekCozaDItrAsLBng9gR" +
                                                              "HYVlb8RV3uwufR4CgR0hyVdgCJt4YapAV/U6U9fZ8KPrjH0Wm89wUjHB+Agw" +
                                                              "SfBQx2vfSHbcgaNZywChT7uF6ceGTqoLnUO/k4C6bpUJUq75aeXh0bdPvS4W" +
                                                              "qRJRUEiNDwGH7AnfMdSAzc0I6q51rnlBf5T5pvemvn7pWelPuKoOCbOFxYc+" +
                                                              "jJ1blGCXV48biqp//xx5/Qh5t2M9K2JG7+8vzn//6fmzUTfX/RyPTJPywkpE" +
                                                              "CpXUpmAOpad3frn+B+ebSnqhAOgnlVlDO51l/akg5Cqc7Lgvqd5dxQOg6zOe" +
                                                              "g5xEdlkuZX0cm2H53P3fcSN2HBTdA0FQb3LRmUfpNYJ6rakh4EaFH1H8e49o" +
                                                              "hGprHXjb2ExxUgLwFjO8yPX/OfImHGqDb53rft06kRcdCbDnLFubhiIkF0xI" +
                                                              "zToaQ6FGvNNF5uK+dXJxBpsZTipVym0zsy8VSkju2hOS46QhfI3AA3Rz0SsL" +
                                                              "ec1Wn1uqr2xduvttUdIWrsK1QA5p0OGDtR/i5ZbN0pqIoVbWGJb4ObvamSgv" +
                                                              "NxxfSuCDcPxBKf8QeBuW56QUf/xiD3NS4xPjuMXEk1/oPGAKhPDxK1b+hG4Q" +
                                                              "dQO+h4jJS3cuUlwciFw3f1SuC1P8dTHSoHhnlGeKrHxrlFQvLh0ZvPfKbU/J" +
                                                              "ulzV6dwcaqkBfpDVf+EQ3LGmtryu8r6uq3XPV+3M01bgXuD3TUAA4Cdq6LZQ" +
                                                              "oep0FurVd5YPvPSThfI3gXCPkwjlZONx3xsbmSmodrNQUxxPFPMgFAiigu7u" +
                                                              "+trsHXvSf/mVKLtc3tyytnxSrfrHubkdTiQWJVX9pAwYmeXGSLXm3DlrDDN1" +
                                                              "2g6Qavm4mTUKr5bqEJsU3yWJrLjJ3FDoxesaJx3Fx0bxFRbq0RlmH0btLkkH" +
                                                              "SoasZflHRVaZZGzMMuAsmRiwrPwtRmyYg5YlNuAyNun/ACD1RfsMFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fqew+YP7f+9Nv/XsN/Nzzf8FwEpwXSMhAAA=");
}
