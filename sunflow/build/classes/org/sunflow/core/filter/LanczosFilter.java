package org.sunflow.core.filter;
public class LanczosFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return sinc1d(x * 0.5F) * sinc1d(
                                                                     y *
                                                                       0.5F);
    }
    private float sinc1d(float x) { x = java.lang.Math.abs(x);
                                    if (x < 1.0E-5F) return 1;
                                    if (x > 1.0F) return 0;
                                    x *= java.lang.Math.PI;
                                    float sinc = (float) java.lang.Math.sin(
                                                                          3 *
                                                                            x) /
                                      (3 *
                                         x);
                                    float lanczos = (float) java.lang.Math.
                                                      sin(
                                                        x) / x;
                                    return sinc * lanczos; }
    public LanczosFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wcRxmfO78f8TNO0jRxEtepSOLcNqQtKg4liWs3F87J" +
                                                              "YacWOCWX8d6cvfHe7mZ3zj67uKSV2phKjQKkbVpR/5WKgtqmQlQgQSsjJNqq" +
                                                              "BamlohRECxIS4RHRgFQkApTvm9m9fZztEiFx0s3tzXwz3+s3v/lmn7lMqhyb" +
                                                              "dDKDJ/iMxZxEv8HT1HZYtk+njnME+jLqYxX0b8cuHbotTqpHSdMEdQZV6rAB" +
                                                              "jelZZ5Rs1AyHU0NlziHGsjgjbTOH2VOUa6YxSjo0J5m3dE3V+KCZZSgwQu0U" +
                                                              "aaWc29pYgbOkuwAnG1NgiSIsUfZFh3tTpFE1rRlffF1AvC8wgpJ5X5fDSUvq" +
                                                              "BJ2iSoFrupLSHN5btMkOy9RnxnWTJ1iRJ07ot7ghOJi6pSwEXc83f3D17ESL" +
                                                              "CEE7NQyTC/ecIeaY+hTLpkiz39uvs7xzktxLKlKkISDMSXfKU6qAUgWUet76" +
                                                              "UmD9KmYU8n2mcId7K1VbKhrEyZbwIha1ad5dJi1shhVqueu7mAzebi55K70s" +
                                                              "c/GRHcq5x461fLuCNI+SZs0YRnNUMIKDklEIKMuPMdvZl82y7ChpNSDZw8zW" +
                                                              "qK7Nupluc7Rxg/ICpN8LC3YWLGYLnX6sII/gm11QuWmX3MsJQLn/qnI6HQdf" +
                                                              "1/i+Sg8HsB8crNfAMDtHAXfulMpJzchysik6o+Rj92dAAKbW5BmfMEuqKg0K" +
                                                              "HaRNQkSnxrgyDNAzxkG0ygQA2pysX3ZRjLVF1Uk6zjKIyIhcWg6BVJ0IBE7h" +
                                                              "pCMqJlaCLK2PZCmQn8uH9py5xzhgxEkMbM4yVUf7G2BSZ2TSEMsxm8E+kBMb" +
                                                              "t6cepWtenI8TAsIdEWEp890vXtnb07n4ipS5fgmZw2MnmMoz6oWxpjc29G27" +
                                                              "rQLNqLVMR8PkhzwXuyztjvQWLWCYNaUVcTDhDS4O/fjzp77F/hQn9UlSrZp6" +
                                                              "IQ84alXNvKXpzL6TGcymnGWTpI4Z2T4xniQ18JzSDCZ7D+dyDuNJUqmLrmpT" +
                                                              "/IcQ5WAJDFE9PGtGzvSeLconxHPRIoTUwJf0wLeKyI/45eS4MmHmmUJVamiG" +
                                                              "qaRtE/3HhBpZqnDmwHMWRi1TcQpGTjenFcdWFdMeL/1XTZspYAUgSEkBL82a" +
                                                              "zoD4l0CkWf8HHUX0s306FoMUbIgSgA5754CpZ5mdUc8V9vdfeS7zmgQXbgg3" +
                                                              "QpxsBXUJV10C1SWkukRIHYnFhJbVqFYmGVI0CZsd2LZx2/AXDh6f76oAdFnT" +
                                                              "lRBfFO0KnTp9PiN4NJ5R/3rwt7sPzH3yZ3ESB9IYg1PHJ//NAfLHU8s2VZYF" +
                                                              "7lnuEPCIUFme9pe0gSyen75v5Es3CRuCbI4LVgER4fQ0cnBJRXd0Fy+1bvPp" +
                                                              "Sx9cfHTO9Pdz6HjwTrWymUgTXdFcRp3PqNs30xcyL851x0klcA/wLaewP4DK" +
                                                              "OqM6QnTR61Ev+lILDudMO091HPL4sp5P2Oa03yNA1opNh8QbwiBioGDtTw1b" +
                                                              "T/7ip3/YLSLpEXxz4GQeZrw3QCq4WJugj1YfVUdsxkDu1+fTX3vk8umjAlIg" +
                                                              "ccNSCrux7QMygexABB945eQ777174a24D0MOp2phDIqTovBl9YfwicH33/hF" +
                                                              "IsAOSQhtfS4rbS7RkoWab/RtA4LSYQMjOLrvMgB8Wk6jYzrDPfDP5q27Xvjz" +
                                                              "mRaZbh16PLT0fPQCfv91+8mp1479vVMsE1PxgPTj54tJ1m33V95n23QG7Sje" +
                                                              "9+bGx1+mTwJ/A2c62iwTNEhEPIhI4M0iFopod0fGbsWm2wliPLyNAoVMRj37" +
                                                              "1vurRt5/6YqwNlwJBfM+SK1eiSKZBVC2k7hNiJZxdI2F7doi2LA2SjYHqDMB" +
                                                              "i928eOjuFn3xKqgdBbUq1AjOYRuIrhiCkitdVfPLH/5ozfE3Kkh8gNTrJs0O" +
                                                              "ULHhSB0gnTkTwJFF69N7pR3TtdC0iHiQsghh0Dctnc7+vMVFAma/t/Y7e76x" +
                                                              "8K5AoYTd9e508WeraD+GzQ4JUnzsKZZCIz7VK4QmsGZMPK/jZG0Zi0vexjBu" +
                                                              "XK7oEAXThfvPLWQPP7VLlgZt4YO8H+rUZ3/+r9cT53/z6hJnRx03rZ06m2J6" +
                                                              "wKYKVBni/kFRj/ncVf/gTe0pXsyV0z6u0rkMsW9fntijCl6+/4/rj9w+cfwa" +
                                                              "OH1TJEjRJb85+Myrd96ofjUuSkpJ52WlaHhSbzBcoNRmUDsb6Bb2rBI7oquU" +
                                                              "9lbM8jo39R4EQjtCkq/AEDZ9pakCXfUrTF1hw4+sMPY5bD7LSc0448PAJOFD" +
                                                              "HW97w4UxB45mLQ+EPuXWox9PH1fnu9O/k4C6bokJUq7jaeXhkbdPvC6SVIso" +
                                                              "KIUmgIB99njgGGrBZieCetsKt7uwPcpc23uTX7/0rLQnWkxHhNn8uYc+TJw5" +
                                                              "J8Eubxw3lBX9wTny1hGxbstKWsSMgd9fnPv+03On426skxyPTJPyUiZipUpq" +
                                                              "dTiG0tI7vtz8g7NtFQNQACRJbcHQThZYMhuGXI1TGAsE1b+i+AB0bcZzkJPY" +
                                                              "dsulrE9gMySfe/87bsSOvaJ7MAzq1S46PZReI6iXmxoBblzYEce/d4tGLG2t" +
                                                              "AG8bm0lOKgDeYobvuf4/e97mbecm1/ymFTwvOxJgz1m2NgVFSDEckIYVVoy4" +
                                                              "GvNPFxmLe1eIxSlspqFccjRD3ZWNhKN47eEockBc8AaBZ+e6spcU8mKtPrfQ" +
                                                              "XLt24a63RTVbuvw2Ai/kCroeQHQQ3dWWzXKaML9RlheW+Dm91HEoLzUcX0Pg" +
                                                              "g7D6QSn/ECctUXlOKvEnKPYwJw0BMY67SzwFhc4CnEAIH79ieYdziygZ8M1D" +
                                                              "Ql6zi7HyukAEuuOjAl2aEiyJkQHFWyKPJAryPVFGvbhw8NA9V259Spbkqk5n" +
                                                              "Z3GVBqAGWfiXzr8ty67mrVV9YNvVpufrtnqMFboSBG0T+QfkifJ5faRGdbpL" +
                                                              "peo7F/a89JP56jeBa4+SGOWk/WjgHY2MFBS6BSgnjqbKKRBqA1E89257Yub2" +
                                                              "ntxffiUqLpcyNywvn1Hr/nFmdosTS8RJXZJUARmz4iip15w7Zowhpk7ZIT6t" +
                                                              "HjMLRullUhNik+LbIxEVN5irSr14U+Okq/zEKL+9Qik6zez9uLrLz6FqoWBZ" +
                                                              "wVERVSbJGqMMOMukBi3Lu8CI1x97LUvsvgvY5P4DTZIVDP4VAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/9Zz38qPM/8XAKW5ZBEhAAA=");
}
