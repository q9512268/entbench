package org.sunflow.image;
public class BlackbodySpectrum extends org.sunflow.image.SpectralCurve {
    private float temp;
    public BlackbodySpectrum(float temp) { super();
                                           this.temp = temp; }
    public float sample(float lambda) { double wavelength = lambda * 1.0E-9;
                                        return (float) (3.74183E-16 * java.lang.Math.
                                                          pow(
                                                            wavelength,
                                                            -5.0) /
                                                          (java.lang.Math.
                                                             exp(
                                                               0.014388 /
                                                                 (wavelength *
                                                                    temp)) -
                                                             1.0));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwcRxWfO3/GdvyV2Emd2ElsJ5Wd9K4pDTRyCIkdu3Y4" +
                                                              "J5adRuICceb25uyN93Y3u7P22a0hDaAEJKLQuklArf9K1RKlTYSoAEEro4p+" +
                                                              "qAWppdAW1BQBEoES0QjRIgKUNzP7fWeH/sFJN7c3896beV+/92YvXUclpoFa" +
                                                              "iEpjdFonZqxXpUPYMEm6R8GmeQDmRqVzRfhvh6/t2x5FpUlUPY7NQQmbpE8m" +
                                                              "StpMomZZNSlWJWLuIyTNOIYMYhJjElNZU5OoQTYHsroiSzId1NKEERzERgLV" +
                                                              "YUoNOWVRMmALoKg5ASeJ85PEd4eXuxKoStL0aY98tY+8x7fCKLPeXiZFtYmj" +
                                                              "eBLHLSor8YRs0q6cgTbrmjI9pmg0RnI0dlTZZptgb2Jbnglar9R8cPPMeC03" +
                                                              "wQqsqhrl6pnDxNSUSZJOoBpvtlchWfMY+iIqSqBKHzFF7Qln0zhsGodNHW09" +
                                                              "Kjj9cqJa2R6Nq0MdSaW6xA5E0YagEB0bOGuLGeJnBgnl1NadM4O2611thZZ5" +
                                                              "Kj6yOT537nDtd4tQTRLVyOoIO44Eh6CwSRIMSrIpYpi702mSTqI6FZw9QgwZ" +
                                                              "K/KM7el6Ux5TMbXA/Y5Z2KSlE4Pv6dkK/Ai6GZZENcNVL8MDyv5XklHwGOja" +
                                                              "6OkqNOxj86BghQwHMzIY4s5mKZ6Q1TRF68Icro7tnwUCYC3LEjquuVsVqxgm" +
                                                              "UL0IEQWrY/ERCD11DEhLNAhAg6KmRYUyW+tYmsBjZJRFZIhuSCwB1TJuCMZC" +
                                                              "UUOYjEsCLzWFvOTzz/V9O07fr/arURSBM6eJpLDzVwJTS4hpmGSIQSAPBGNV" +
                                                              "Z+Isbnz2VBQhIG4IEQua7z9wY9eWloWXBM2aAjT7U0eJREelC6nq19b2dGwv" +
                                                              "Ysco1zVTZs4PaM6zbMhe6crpgDCNrkS2GHMWF4Zf+Nzxi+S9KKoYQKWSplhZ" +
                                                              "iKM6ScvqskKMe4lKDExJegAtI2q6h68PoDJ4TsgqEbP7MxmT0AFUrPCpUo3/" +
                                                              "BxNlQAQzUQU8y2pGc551TMf5c05HCJXBF1XBtwiJD/+l6EB8XMuSOJawKqta" +
                                                              "fMjQmP5mHBAnBbYdj5uWmlG0qbhpSHHNGHP/y1nwd7xbAcentPT0iA5shpWN" +
                                                              "sejS/09yc0yfFVORCJh6bTjRgYP0a0qaGKPSnNXde+Pp0VdEELHAty1BURts" +
                                                              "FrM3i/HNYnmboUiE77GSbSpcCY6YgJQGTK3qGPnC3iOnWsGAOX2qGKzISFsD" +
                                                              "taXHy3sHrEely/XLZzZc3fp8FBUnUD2WqIUVVip2G2MAQtKEnadVKag6Hviv" +
                                                              "94E/q1qGJpE0YM9iRcCWUq5NEoPNU7TSJ8EpTSwJ44sXhoLnRwvnpx48+KU7" +
                                                              "oygaxHu2ZQlAFWMfYijtonF7OM8Lya05ee2Dy2dnNS/jAwXEqXt5nEyH1nAU" +
                                                              "hM0zKnWux8+MPjvbzs2+DBCZYsggALuW8B4BQOlywJnpUg4KZzQjixW25Ni4" +
                                                              "go4b2pQ3w8Ozjj+vhLCoZBm2Fr6ldsrxX7baqLNxlQhnFmchLTj4f3pEf+yt" +
                                                              "n//pE9zcTp2o8RX4EUK7fNjEhNVzFKrzwvaAQQjQvXN+6OFHrp88xGMWKNoK" +
                                                              "bdjOxh7AJHAhmPmrLx17+92rF96IenFOoThbKehxcq6SbB5VLKEk7LbJOw9g" +
                                                              "mwI5xqKm/T4V4lPOyDilEJZY/6rZuPWZv5yuFXGgwIwTRltuLcCbv60bHX/l" +
                                                              "8IctXExEYrXVs5lHJgB7hSd5t2HgaXaO3IOvN3/rRfwYQD/ArSnPEI6gkUK5" +
                                                              "zvJpxEqZkJdyFtwwaReju4aOSKfah/4gCs1tBRgEXcOT8W8cfPPoq9zJ5Szz" +
                                                              "2TzTe7kvrwEhfBFWK4z/EXwi8P0P+zKjswkB6vU9dmVZ75YWXc/ByTuW6AWD" +
                                                              "CsRn69+dePTaU0KBcOkNEZNTc1//KHZ6TnhO9CdteS2Cn0f0KEIdNmxnp9uw" +
                                                              "1C6co++Pl2d/9OTsSXGq+mC17YVm8qlf/fvV2PnfvlwA+CGFNCy6zLsD7lwZ" +
                                                              "9I5Qac/Xan58pr6oD1BjAJVbqnzMIgNpv0xosEwr5XOX1/nwCb9yzDUURTrB" +
                                                              "C3x6Gz/Gne5hED8M4mv9bNho+sEz6CxfDz0qnXnj/eUH33/uBlc42IT7sWIQ" +
                                                              "68LadWzYxKy9Klzc+rE5DnR3L+z7fK2ycBMkJkGiBJ2nud+AspoLIItNXVL2" +
                                                              "658833jktSIU7UMVYOF0H+YgjZYBOhJzHCpyTv/MLgEOU+Uw1HJVUZ7yeRMs" +
                                                              "QdcVTv3erE55ss78YNX3djwxf5WjlC5krHFduzZQlflVzisMF3/xqV8+8c2z" +
                                                              "UyKYlkiNEN/qf+5XUid+9488k/M6WCBbQvzJ+KVHm3p2vsf5vYLEuNtz+Y0N" +
                                                              "FHWP966L2b9HW0t/GkVlSVQr2Veng1ixGMwn4bpgOvcpuF4F1oOtv+hzu9yC" +
                                                              "uzacrr5tw6XQnwPFNBDvXvVjvSZa5VQI59df/SKIPyQ5y+187GTDHU6xKdMN" +
                                                              "Ga7XJFRtKpcQSuFAJMuf7xHVlY0DbDgkxCQKxaJYup0Nm93N3HIWaJn9pc0L" +
                                                              "NsQyqnmxWw3Hrgsn5ubT+x/fGrXzfBeFFNH0OxQySZRQ3DYH4naQ3+O8IHin" +
                                                              "+qHf/7B9rPvjNJJsruUWrSL7vw4isHPxVAgf5cUTf246sHP8yMfoCdeFrBQW" +
                                                              "+Z3BSy/fu0l6KMovrSI68y67QaauYExWGARu52oQidtcv9Y5kVlh+7WicF9W" +
                                                              "ICTcbmcx1hCu20WGhyOXai4B/BYb4IpZauKsLu5093jhqy0Rvv8DlLKJYT1H" +
                                                              "UV3ebYfB7Oq81ybiqi89PV9Tvmr+vjd5rLnX8SqImoylKH4g8D2X6gbJyFyp" +
                                                              "KgELOv+Zhe3zrl9QmfkvP/MDgvA4RZU+QspKLX/yE32ZoiIgYo9f0fnCaoiU" +
                                                              "/Oud0BMrPZYxSXKRYNa69m24lX19id4WSBD+YsoJZku8moLb3vzeffff+OTj" +
                                                              "on2XFDwzw19kQNsgbhJuQmxYVJojq7S/42b1lWUbHeioEwf2wnSNL4yGIeB0" +
                                                              "5tOmUG9rtrst7tsXdjz3s1Olr0MJOoQimKIVh/JrQ063AIkOJfLbIwAP3nR3" +
                                                              "dXx7eueWzF9/w6tvfs0N00Pte/itgSsTH+7ib0JKABVJjhetPdPqMJEmjUCv" +
                                                              "Vc3CDbNXVNwOtvmWu7PsskdRa36jmX9Fhs5kihjdmqWm7W6t0psJvCFzMMTS" +
                                                              "9RCDN+NrxveIBo9ZH8JxNDGo604f/oLOs663EBr0cuZz/JEN5/8LVOZ3q6MW" +
                                                              "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qMjPZ3947++/8bef/1aRVvofA1ENlkAgAAA=");
}
