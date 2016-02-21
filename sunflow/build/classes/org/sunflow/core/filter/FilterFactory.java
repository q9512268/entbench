package org.sunflow.core.filter;
public final class FilterFactory {
    public static final org.sunflow.core.Filter get(java.lang.String filter) {
        if (filter.
              equals(
                "box"))
            return new org.sunflow.core.filter.BoxFilter(
              1);
        else
            if (filter.
                  equals(
                    "gaussian"))
                return new org.sunflow.core.filter.GaussianFilter(
                  3);
            else
                if (filter.
                      equals(
                        "mitchell"))
                    return new org.sunflow.core.filter.MitchellFilter(
                      );
                else
                    if (filter.
                          equals(
                            "catmull-rom"))
                        return new org.sunflow.core.filter.CatmullRomFilter(
                          );
                    else
                        if (filter.
                              equals(
                                "blackman-harris"))
                            return new org.sunflow.core.filter.BlackmanHarrisFilter(
                              4);
                        else
                            if (filter.
                                  equals(
                                    "sinc"))
                                return new org.sunflow.core.filter.SincFilter(
                                  4);
                            else
                                if (filter.
                                      equals(
                                        "lanczos"))
                                    return new org.sunflow.core.filter.LanczosFilter(
                                      );
                                else
                                    if (filter.
                                          equals(
                                            "triangle"))
                                        return new org.sunflow.core.filter.TriangleFilter(
                                          2);
                                    else
                                        return null;
    }
    public FilterFactory() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Y7mGoZur2F/3yGA4Ax5NiAQtrOD2uJ7qPEq0ky42sOZNFCsjEmnXOrIc2Z11" +
       "J0yjpt3EOyTFLqokPrCs+goNhRnTTtpwcRGv+BXBI+XAXuKlSU8Z0eMIdro4" +
       "DAOWVX4TUnC9BKbiw9a6v1o16oznoMag5s4q1baNtHg0YFdtt2YThlestLWZ" +
       "H0QrJiHbAm+2zWZb75bXc7NDGDJXLHTwKcAstLNAyJmlOqHdaKBhYYXra9jA" +
       "2YDkUGJW7umeKxMy1WOaiTvpT5MFxgS1Umkz44Y42ZmJi8mAwModf6FFm7CB" +
       "jqqLhqh03f4o7a363ZqNd2a9iiKaI37pjjW6BsMzuDqYroWuQaVFEpsOqZ6M" +
       "6ROCkQuV+oQcDOF4hgWqZpIJcKt5wUok3muQZTbZ2KM4tLoJT5WxGtqAS1FY" +
       "q8wim7TLTk3TDC6RKhUtLbV4pwKbqF3nqKKEBEMuWuJuQQPvD8GhtTYWawFt" +
       "CQuNK7dsYRyjbba8TpUZi6yTFG0asD7l4ZWzaLBjYxUrlhAKm3WtNpg0V0yL" +
       "meMLrM5MjLWE0nF9wYWVxEYao2ElZqNuTZ3bSrOOlcOkPJP65GrML9r2kuE3" +
       "Pox2alhtVBcoSZYNtxyW4omxlOi6RKClxZwrkfaCq/cEtkgkc4TkB13KDwgG" +
       "KZr1ihFOtBJZEQKSKjgEK7is0XTWgzFjV/RhrzgfA1UqWmPBkjJDN+nhvAN8" +
       "gDHXbGFakWmbmUdTqj2ILHzkuJs14czSeZHjrKJI1YVgPJvIhf5iIk5WSKHT" +
       "rsxZtVbXiipHJVWJ061eQ2Qr+EItjzu25aCVQlylAhKZVwucbrKxPEWliser" +
       "o96kL7SIfgreT/JEEjRHk4IkikY8EiVWSaTSFTuQpkPGNvqWSipj128O4Zkj" +
       "utzQMroca7mGOqJaQVup4N1xsVQT5blVRFCWVWgGnlK6UWktmgUs1QsLyRzE" +
       "bm0iSNVecRNuUFh1BqglrMq8yNA8m47sqkF0+qPlmO4BSCysO6N4HcBEb7Bc" +
       "o0udJBo+ktLVYastyX02JeA1QQkLWsN7fqUmmY36FIGnMNzj6fXUwHhT6W46" +
       "PVFrqBVm4vL9oR0lvRkrG8hEXCV8EgvmgqutwrBYYWumW67bdXbZXipIWCwY" +
       "w0bYMEZxbZ7GwOEXVWo0I/zRWBqFAbysiOMNSTBjj0GLQ2nTmHaHbBIVK6Np" +
       "M5BBJrCcERurQAk4Uktd1h669VFhUeXncyt2LaQyacWRqSaVuVbBUVxaB6WO" +
       "nBBSrxhppLPqhBUTdVdjvcouGJ5qKZZWbY6oUWC2R3BbR1FWY5NqeegMwaFi" +
       "7vqldQ1xzKEwSONRdRO26rRVr3aV3sCkatNpDCdti5+ofJxmafJ73pOlzu97" +
       "c6eXe/KD2kEJHRxasgfkm8ja05svuHOwIJ4e1Kzy351vULM6cq6HsgPKQ7cq" +
       "mOeHk089f/1ljfs0srNXDxnF0O2x5/+0ra90+wir7JD41K0PYkz+veDwnP7l" +
       "5//lwcF758+8iUrkIyfkPMnyd5hXvkq+Q/21Hej0wan9hi8ZxyddPX5WvxDq" +
       "8TJ0B8dO7A8dWPaRzGKPg+vsnmXP3rwa+Cac40Th6dTWlLl75ATRG1Smllnj" +
       "xtDpmR7vn/nvv6HSvC0xH7qZ9+MOh8dqQDF017EadVZke+CGz2DbTzfq516+" +
       "eP7+l6W/zsu0B59Xbqeh88bSto/WRI70z/qhbpi5QrdvKyR+/vfBmymzLZvH" +
       "2YeuA62e3dI/F0OXTtKD43H2d5TsF2PojiNkMXRur3eU6AVgVECUdV/0b1JO" +
       "2daG0lPHI+nAxJd/nImPBN8Tx0Im/w65797L7ZfIa+rnX6bYD7yGfnpbRlZt" +
       "ZbPJuJynoXPbivZBiDx2S277vM52nnz97i/c/vb9cL57K/Ch4x6R7ZGb12lx" +
       "x4/zyurmD+7/vXf/1svfyqs7/wvHOutRIB4AAA==");
}
