package org.apache.batik.apps.svgbrowser;
public interface SquiggleInputHandler {
    java.lang.String[] getHandledMimeTypes();
    java.lang.String[] getHandledExtensions();
    java.lang.String getDescription();
    boolean accept(java.io.File f);
    boolean accept(org.apache.batik.util.ParsedURL purl);
    void handle(org.apache.batik.util.ParsedURL purl, org.apache.batik.apps.svgbrowser.JSVGViewerFrame svgFrame)
          throws java.lang.Exception;
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1445630120000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVae3QU1Rm/s3lDQkKAgDzCIwEFYVdUsBpUQkggsIGUQDgE" +
                                          "dJnM3iQDszOTmbvJ8hKltVJbqUex2hZy2op9WBTb6mm1R0pfKrXoEZ9I6/MP" +
                                          "H2gP/KHY2mq/797dndnJ7gZNOM05+2V27vt3v+/3fd+9e/BDkmdbZJop62HZ" +
                                          "z7aY1PY343OzbNk0XKfJtr0a3oaUW9+8c+fZ54tu8pH8NjKiS7abFNmmDSrV" +
                                          "wnYbmaTqNpN1hdorKA1ji2aL2tTqkZlq6G1kjGo3RkxNVVTWZIQpVmiVrSAZ" +
                                          "KTNmqe1RRhvjHTAyOchnE+CzCdR6K9QESbFimFucBuNTGtS5yrBuxBnPZqQs" +
                                          "uEnukQNRpmqBoGqzmphFLjYNbUunZjA/jTH/Jm1eHIhlwXn9YJj2UOnHn97e" +
                                          "VcZhGCXrusH4Eu1V1Da0HhoOklLnbb1GI3Y3uYHkBMlwV2VGqoOJQQMwaAAG" +
                                          "TazXqQWzL6F6NFJn8OWwRE/5poITYmRqaiembMmReDfNfM7QQyGLr503htVO" +
                                          "Sa42sd2eJd51cWDv3deX/SqHlLaRUlVvwekoMAkGg7QBoDTSTi27Nhym4TYy" +
                                          "UocNb6GWKmvq1vhul9tqpy6zKKhAAhZ8GTWpxcd0sIKdhLVZUYUZVnJ5HVyp" +
                                          "4t/yOjS5E9Za4axVrLAB38MCh6kwMatDBt2LN8ndrOphrkepLZJrrF4OFaBp" +
                                          "QYSyLiM5VK4uwwtSLlREk/XOQAson94JVfMMUEGL61qGThFrU1Y2y500xMg4" +
                                          "b71mUQS1ijgQ2ISRMd5qvCfYpfGeXXLtz4crFuzZpi/VfUSCOYepouH8h0Oj" +
                                          "Sk+jVbSDWhTsQDQsnhX8rlzx+G4fIVB5jKeyqPOb7WcWzq488pSoMyFNnZXt" +
                                          "m6jCQsqB9hHPTaybeWUOTqPQNGwVNz9l5dzKmuMlNTETmKYi2SMW+hOFR1Y9" +
                                          "se7G++kpHxnWSPIVQ4tGQI9GKkbEVDVqLaE6tWRGw42kiOrhOl7eSArgOajq" +
                                          "VLxd2dFhU9ZIcjX+Kt/g3wGiDugCIRoGz6reYSSeTZl18eeYSQgpgA+R4LOI" +
                                          "iL8qFIz0BLqMCA3IiqyruhFotgxcP24o5xxqw3MYSk0j0A76v3nOXP8VAduI" +
                                          "WqCQAcPqDMigFV1UFMIX0w7YPZ3tltEL/Bho6Y6qnZ0asJsZZUuhS1itH/XP" +
                                          "/L+NHENMRvVKEmzXRC9ZaGBnSw0tTK2Qsje6qP7Mg6GnhSKi8cTRZGQeDO8X" +
                                          "w/v58H4c3u8M7083PJEkPuponIZQENjezUAUwNTFM1uuW7Zx97Qc0EyzNxc3" +
                                          "J8Ytd0LiCzT0TJdzxNUt5v5XnnnvMh/xOXRS6vIDLZTVuFQY+yznyjrSmcdq" +
                                          "i1Ko9497mu+868Nb1vNJQI2qdANWo6wD1QU+Bl67+anuE6+/duAFX3LiOQw4" +
                                          "PNoO7pCRQrkdCFBWGCNFSSYTCxv9OfxJ8PkMP7hGfCG0srwubhpTkrYBAHvg" +
                                          "mJSJRDgBHti1ty+88r65wtTLUw2zHvzOAy/992/+e944mmZ/i5hhztFoD9Vc" +
                                          "Y5bCkFP7RRJNnGMTHjmkXHH8bM7JO8YV8+0obocgwvHk1SmeXAQilqHQMLiS" +
                                          "TD494ddmZfbi3ik8uev98auv6drIp+D2y9hXHrgUbNmM3jTZ+2QPlN4uf950" +
                                          "8OiSGcodPu5IkJTTOKDURjVuUGFQi4LH1HFZ+KYkhmGZx/q8WISUWVPkR0KP" +
                                          "76j2kVzwLOBNmQzsB46q0jt4ijOoSVgCDlUIIHQYVkTWsCjhDYexLjBV5w2n" +
                                          "hZFCMWGzS1DJpsDnwjhd8v9YWmGiHCtohNev5HIqimquKT58nI5iBq92EWjO" +
                                          "DMfYgN81YDrckeo1Omy22qHK7RpFGvhP6fS5j3ywp0wopQZvEls0e+AOnPcX" +
                                          "LCI3Pn392UrejaRgfOEQglNNOK1RTs+1liVvwXnEbjo+6XtPyvvB/YHLsdWt" +
                                          "lHsRErc+nNRCvuwaLq/1lC1CcQUjozppnP3CTWqE741tY5DmMiOMmFuiQBN8" +
                                          "cOGnHx313q+Pbiw4IYy3Om11j/t/a9vTPzb+fsqXcO3pmoiay+2mZx9b+k6I" +
                                          "20chmmhSK13GV2t1ujSjzETGmZ7ZCF2T7/tJ1TM7+6reBPDbSKFqgxlDZ2mi" +
                                          "Hleb0wdfP3W8ZNKDXNFzcU7x+aSGi/2jwZQgj0+11BT8Og7SAb6zGOr5RaiX" +
                                          "3CyJb5bk3QvOSTzrcWzwg5M/ePv3Z+8tEMDOzAyBp924f6/U2ne99QnXwX40" +
                                          "lCae87RvCxzcN77umlO8vWP72Hp+rL/vBpSdtpfeH/nINy3/Lz5S0EbKlHiG" +
                                          "0SprUXRzbYCjnUg7IAtJKU+NkEU4WJMkvYle3nEN62UdN/3lsiTxcaIxYxLh" +
                                          "RLI6G4Uw6FDVZU2wCLhVjeqdrMvOug3NlhoBT98Tt4vAjvLXN+979wGxfV7M" +
                                          "PZXp7r23fu7fs1fQj0g0qvrF+u42ItkQNsJnGeNuMssovEXDO4d2/O5nO27x" +
                                          "xQljNiM5oNv4uCyuv6imPgFGQp9HOfpcpxk6RdJLlImoSjX8yWwNCmP9FB6/" +
                                          "X2LyMZelh17i0MeJOzPFbcpSxlOWDtg9BWcpFpWluoEsPDk9v9dHTMYZeetv" +
                                          "xz684Kd9r/E4K0bSWHKFl/PEnubP3f+vnd94ZSVQSyMpjOpqd5Q2hlPVs8CO" +
                                          "trtI0MnhHJWN7y7GaIxIs0xOiNUZ1NCV5oeU2184XdJ6+vCZfkSQGqc2yabQ" +
                                          "o5EovoLdj/VGyktluwvqXX5kxYYy7cinnGGHywrQob3Sgqg9lhLVxmvnFbz6" +
                                          "hz9VbHwuh/gayDDNkMMNMmbkkFdBEEDtLgj4Y+a1C4Wj7y0EUcb3hvTbLW6y" +
                                          "3UKJUmOFqfCZHY8VZg8qVsisJ7uylH0dxQ4wA8fj1scY1e0E4y7hsgfFDcIs" +
                                          "tnz5JQ/HogvgMze+5Lnnacl7spTdjuKbjIyAJS+mtmKpZtK/ZHR+HIBbBw1A" +
                                          "MRaVw2d+HID5QwiAm6tgIcUJZmuAjIg32JcFlR+iuBt8BZqFyexM4ZOH+Q9V" +
                                          "nO3+c8HWxQlCboiTOf5b53q+jpGCdsPQqKx754tfWcxB+Z6hQ3lBHOUF5w/l" +
                                          "yf1yenGEw88P16wK8j4eygL8wyh+kQQev93rgHFw0GDwoivhUxsHo3YIwfA5" +
                                          "tX6ZQOSSAU85lrW0LmlVaS+1GiCbFLp5ODvMLhdeH0OcwGJ5uz+ieBTg6+Ls" +
                                          "lU7xcnsMNexA+tjgIOWnDemPHyq8AaCfH0mbZjaIcxyIYRW6jLY1IL89n6Xs" +
                                          "RTFbFMfShfRiagNNZi2K58REUBxH8QKKlxgpBOrkxyZpzzY4T7iOZtee/lHs" +
                                          "nyUTZohQMsuJhLfhbWrfsb9+VHpTuhSCH+vHm3rbnXgl59LhrPo7PFNLZkXD" +
                                          "Ic62sSYjUzJfEfC+REAxYsANH+NsOB8+ud8J2EvdkScU4eu3AbRx6UGDrEk7" +
                                          "evZrm062iiVPHQCrkNIYCbU8cuKW+TxIKu1RbZWJmyZxsVORcrGTODSsSbnw" +
                                          "SItmSHn30G1PTX2/dRQ/yRbA4ex7YyIk3Ro3H4mbj4+IWHJyv3XF58IPGkLK" +
                                          "i9vbP767rXenWF6mvDi1zfZ9nx17b8drR3NIPmSymE/JFoWEjxF/pusidwfV" +
                                          "q+FpMbSCPGuEaA1OPbkboBXlybfJoyRG5mTqm6dK/U/fIEAEPltkRPUwdjvf" +
                                          "c4wVNU13qci4v7x+3WCR2ecAXnLtcepHpwi4j3CRqR6NuAtNoNq6YG1LS2j1" +
                                          "uub6UGvtqsbaRcF6rrcmFEqrMzJKtpOOtaoWrpOtsLDP+z4vqlo49uhV3D77" +
                                          "AzfUYHEOfznmORdP+oNjA/mDtDQrScI1oDiJ4g0Un2EJcTsNMcK58b+LcrMM" +
                                          "nJ+lrNA76MsD+XWH4qU8FAUoioDiuyALqoOoD4s3DBqtsiRaUjHvEZ9KUJR+" +
                                          "IbTOMToTO47dj8kyqbHniJY7tcd2o1FUoAA7yKfdUVkc+B8YNEyTHZgm8B7x" +
                                          "aSKKyiGFyT1mdZayGV8SoSoUOL50IagSM0QmhcXLB42R38FoFu8Rny5GMef8" +
                                          "Gt5lWcrmnSNQGQMs6VIUl6OYj3GgwdSOLVj4xKABu9oB7EreIz5dhWLB+QVs" +
                                          "UZayxYMGrBZFHYp6RooEYLWaNjSYBR3MliYxa0SxfOgxc+c63txFM/ROPqOv" +
                                          "Zk+QKh133IiH/VbUZHiW48qVpNZBY96MYg2KdTC3XlllQwP3RgfuDUm4r0MR" +
                                          "GlLec/JVaRW+28BHpxmdiLSWV+j8wm51rYMZBjFSB4ouZ32DRkxPh9hmFJHz" +
                                          "5insgXCKDgYnvKKRUJ+kniHEaXs6nJBYpW2iJMbI6HQ/uzB5mub9VZj4JZPy" +
                                          "YF9p4di+NS+Le7fEr42Kg6SwI6pp7gsc13O+adEOlS+4OHGdgxPZCQnpQGcm" +
                                          "jAxzvuBCpRtE410Q+KZtDPaJ/9x1b4ao3VuXkTz+311vN4zm1MOjKf7grvIt" +
                                          "RnKgCj5+G0JsKUNsPWagTXP9LqMqY0baFBU/3Asph/qWrdh2Zv594lcrEOBv" +
                                          "3Yq9QBJXIO7qeac5/VJnd2+JvvKXzvx0xENF0xNHlyPFhB1bmeCoEekGPTdR" +
                                          "JcZ7br3t6uTl94kDCw4f251/HHLx9USSIZNa3/9KMGZGIU1eH0x36ZJI22qG" +
                                          "vb3x2U9elcr5pQ0RqXVlthYh5c7DJ5s7TPP7PlLUSPJUPUxj/L5y8RZ9FVV6" +
                                          "rJQ7nPx2TK4EVpmy4pKUrJiRaf3v8wbMgkuyZsHigoiPd1EMkQadCgWbTDOe" +
                                          "00lzOfKmiYYq7ccv7H/FQjAOmysAAA==");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1445630120000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAAMV7edArWXWfvvdm394wAzMwMDNvmAF7aPhaUrc2Dxi0drfU" +
                                          "q3qR1Hh49CZ1t3pTb2oJBhtSNpSJgSQDdiowfyQQJw6LKzEVpxKncFKxwQtV" +
                                          "djmJcWKGLFW2IVTBH05SITG53foWve9tA28of1U6X6vvveee87vnnnvuPVef" +
                                          "/Xbp1igsQYHvbBaOHx8aWXxoO7XDeBMY0eGQrLFKGBl611GiSADvLmmv/9UL" +
                                          "//N7HzPvP1e6TS49qHieHyux5XvR2Ih8JzV0snTh9G3fMdwoLt1P2kqqwEls" +
                                          "OTBpRfEzZOnuvaZx6SnyWAQYiAADEeBCBLh9Wgs0utfwErebt1C8OFqV3lc6" +
                                          "IEu3BVouXlx64nImgRIq7hEbttAAcLgj/y4BpYrGWVi6eKL7TucrFP44BD//" +
                                          "i++6/5+eL12QSxcsj8/F0YAQMehELt3jGq5qhFFb1w1dLr3CMwydN0JLcaxt" +
                                          "IbdceiCyFp4SJ6FxAlL+MgmMsOjzFLl7tFy3MNFiPzxRb24Zjn787da5oyyA" +
                                          "rg+d6rrTcJC/BwreZQHBwrmiGcdNbllanh6XHj/b4kTHp0agAmh6u2vEpn/S" +
                                          "1S2eAl6UHtiNnaN4C5iPQ8tbgKq3+gnoJS49ck2mOdaBoi2VhXEpLr36bD12" +
                                          "VwRq3VkAkTeJS686W63gBEbpkTOjtDc+36bf+pH3eLh3rpBZNzQnl/8O0Oix" +
                                          "M43GxtwIDU8zdg3veRP5CeWh3/jQuVIJVH7Vmcq7Ov/8vd99x5sf+9KXd3Ve" +
                                          "e5U6jGobWnxJ+7R63x+8rvt063wuxh2BH1n54F+meWH+7FHJM1kAZt5DJxzz" +
                                          "wsPjwi+Nf2v2M79ifOtc6S6idJvmO4kL7OgVmu8GlmOEmOEZoRIbOlG60/D0" +
                                          "blFOlG4Hz6TlGbu3zHweGTFRusUpXt3mF98BRHPAIofodvBseXP/+DlQYrN4" +
                                          "zoJSqXQ7+JQOwKdT2v09mZO4lMKm7xqwoime5fkwG/q5/vmAeroCx0YEnnVQ" +
                                          "GviwCux/+ZbKYQOO/CQEBgn74QJWgFWYxq4QfAkiOEoXauivIyOE+VViLRaO" +
                                          "QXhBEuOAJdD2MLe/4K+t5yzH5P71wQEYrteddRYOmGe47+hGeEl7Pun0v/v5" +
                                          "S7977mTyHKEZl2qg+8Nd94dF94d594en3R9erfvSwUHR6ytzMXYGAoZ3CRwF" +
                                          "cKH3PM0/O3z3h15/HlhmsL4lH5ysmLmvLr6cB+2evrZbH+Q+hSj8qAbM/NX/" +
                                          "h3HUD/zX/12Ivu+Zc4bnrjKVzrSX4c9+8pHuT36raH8ncGKxAowO+IfHzk7o" +
                                          "y+ZgPrPPQgp88ynf6q+4f3nu9bf9u3Ol2+XS/dqR45cUJzF4Azjfu6zoeDUA" +
                                          "i8Nl5Zc7rt0sfebIQcSl152Va6/bZ469bK78rftDCZ7z2vnzXYVZ3FfUecX3" +
                                          "wd8B+PxV/slHIn+xmy4PdI/m7MWTSRsE2cFBXLq1etg4LOftn8jH+CzAuQBv" +
                                          "44NP/fFX/wI5Vzp36vkv7K2lAIRn9rxNzuxC4VdecWoyQmjkYP3pL7F/5+Pf" +
                                          "/uA7C3sBNZ68WodP5TSXGCydYAn62S+vvvbi1z/9R+dObOx8DJbbRHUsDTxE" +
                                          "xUoINJlbnuIUgLw+Lj1sO9pTx1pLYGUEgj1lO40CqleBWKAQLR+Vw91yUswv" +
                                          "INFT1zDXvRDgkvaxP/rOvdJ3/vV3r7DUy4GhlOCZ3QgVUmWA/cNnZxGuRCao" +
                                          "h36J/qn7nS99D3CUAUcNeIuICcGMzi6D8aj2rbf/yW/+24fe/QfnS+cGpbsc" +
                                          "X9EHSr5aA58bm2CBN4EzyIK3v2PnM9d3AHJ/MTdLhf6v3YlTTOv7ToEgfbCq" +
                                          "fvi/f+z3Pvrki0COYenWNLdhIMEeWnSSBxo/99mPP3r389/4cDEmwEOzn+jf" +
                                          "/46ca7Po4A0F/fGcQLsRyx/fnJO35OTweJgeyYeJL7wjqUQx5esWCDT0YqSu" +
                                          "6zrY0HKBtaVHqyj83AMvLj/555/brZBn/cSZysaHnv/57x9+5Plze3HJk1eE" +
                                          "BvttdrFJIfS9J0P5xPV6KVoM/uwLz/3Lf/TcB3dSPXD5KtsHQeTn/sP/+73D" +
                                          "X/rGV67irG9x/GOjzGn1qNv8X+3GAxs/8A0cjYj28R8lKQbCiZWxC0eI0+OW" +
                                          "o/ait+0S6/5gJuli1AlEbrlYRAQmcr1FXx96FGJxvWjLCK6aDpvmyImloboS" +
                                          "jaxqypuqH7QmHUGtu25lXA7mo3Dq9+UWUYcpFq8uWHiEz6ruCm60Grqne8PG" +
                                          "QqYZqlyDqlK1kcZICsHIXIdaBtzpLV1dlYd+UK/i8rahzCrsDEERZqvSy/J0" +
                                          "NB/GYVlBfEWctKCmBs3lGhonzQBv0vbI4huKOqBdt8eH0tqbqa4irOiArpi6" +
                                          "H47aFduqKmQ1FlZL2VnVscrSxnxkvMxoSRImMsEFkmtJId+WRwLtrozKeGym" +
                                          "Ni60N4xmen2ou+3q4/qoxfV5dWC5g0TrJLSAxXxtE3aSrOOx8oqLEjCQS44e" +
                                          "B+6q42OrrRuYA9Ke0aqYeLLdhm0Bh4duxcAJ01lPvdZsaFdFBoSKrYYhabKJ" +
                                          "dadhEuFoP6lIlZ5Sxk2fWTqkp6oVjEBmSDLDlx3KWUtVCVv5zJDjqLXSbmOC" +
                                          "sp2uuMmWrA/q9GDoNZnJetyHa4FPCDN3vFIssCWg3LHRm9NzqsFxG4wMa2XE" +
                                          "jCWGV9BqpFeNoV6raJNeiujGFMQeuEMqY9GR0rWx9Kn2Els0uI7fE3jBqjZo" +
                                          "c+Oiwmwj+hqt1rHJyE1XldRMnFa8Cjb17Whkttum3MSESZBpejkiRrpJSrI4" +
                                          "E2XJG9ZwaROgMbxhbL7Wb8kKqmRSSLY7SJPqmvXlmlLiXieuknTT00MmMMOl" +
                                          "EZDyMAwHKDNQOgE34zekRdWkEZqs1zFPOuP+Ep4yXDvyvRY6lOYUJfYxsl5Z" +
                                          "YYI5CMXKrLqplcsZtUDVRsUVOb5i2QuuSvBjSq+t0u58FswxYzol4y2qhYNk" +
                                          "KwcWLM1FvsvMjMBP8KZZBtIuIVtS+d7EFCKux0WeOW2GzjaDMHROSJ2aPTI2" +
                                          "K5ZRGxNtsl2hzWbA+9RmQHvyNHbrdpeLVp2WibOCslGNicgIK5ajsbVEb1tO" +
                                          "Td+O3IRyaKEvuKOZVeWpCWQyg3Fl1oqMBgZBywDPvAnPEhKHxhhHtLDRUu1L" +
                                          "PWlFKv16PBlja7S6tJjQZJyGwbfDBaPYK4nM9Ko+MMWWTGj2FBrF8AJZY1Yv" +
                                          "WXSJsY9t66Ex43lDkJ1K0wCP3CJYtKExSjKERTZXA2Jb7pArqttGCGu1CRNz" +
                                          "4MeLTGOrqF/LstUaoWb8smyX2416injMlG1KbT0hJqsu19bYVY+yFgOpIg4o" +
                                          "YlpeN2asjMRO3CfhjunXZ/WVJ5eVaBjJspiYYFRiHJ6yMAnReJ+mxqk06rvb" +
                                          "6bgLjATrePy6HAujKhfZRn3FNqhFHfNMfmQ1NWEsY5zRY5rTNZzWmjiqIUmT" +
                                          "apSbCDvsL9kk8D1C5vq0bWzFtrimhQFVSZJJQ85aDU4r9zdbOtOQYXMW62XS" +
                                          "6m6FsjDUtxktxrW0NvU8L6VMOGOmY76eEj1SFqRkwM2gzdbb2CHvavrKqoz8" +
                                          "FtpquAnUrDdptZLSQ46orvQ2PfHr616FE6GOU29Aipf06xCsJ+3BFCEthluj" +
                                          "LO0zjaA75sKl3h10JliXHvD8TOhmaYuZZ8Mmu6TYhonNu1g5CteJagbCMpx1" +
                                          "2ni6cIf8cNxbdPDYqsQbqNkM67V1LJDiurrF0y3T3sCtVhWGjBaKuq4MWzXT" +
                                          "3MYDv9eStFlN7S4HbGM8HtIeRgm47S6nON5UqcaQac6kJlT2VV9brFN8WeFd" +
                                          "Y9rmLGeFcxRp8UIPbaG67spz1UKsZTMx0lZTSdK6HhIB1KtuWuYUDxeiSrsU" +
                                          "YgsyVOVYh0aTeatWbjIWj2m+ziY1YjkUBGbUE8e2lIjYgLNQEq/gAxkazZam" +
                                          "i8kZvGpOCF6cSOxyXB6xjbpdXUrbNcl0aJfbRh20virbMWrZjM9Li27PEQkC" +
                                          "52bSUphEXdvszYyMtDtSbV31THnQpSbYlq/0hkHU89a2qTfT1mziYhbejX2T" +
                                          "NtIaTqwsd5WMhFrTI2pWZ9Wq9ic206PmswXdrMx6obY0/ArjbqrVFT5qjIMB" +
                                          "lppsfc7XbGSzDsprP+DktO9EZQNqMx6rTckugbAe0qqKoWEr48Wc6XMLh6aZ" +
                                          "UWUsRFDFsYCfnXp91fah+jRmN2nagWc4GemT2MGjcT/UII8ed9NkrZAruOJ0" +
                                          "K12NE21/GwQei3SFyarfQCvxrNZzKYuhwPpkcR26qTGYh2dIBVlBrGqtUWK2" +
                                          "QRi3UrHhGFZaqcBuVWgeraYagwSubykbqOqCGaFCyzpRLWum64LZVUEwqRpX" +
                                          "Epu3t30Bc+WG3B1UhQYcDysC1YCA/+iwPZUfDVaLzOnJVdfCHUMtr/U5i0ya" +
                                          "Mj3qTenBVhMbGaTwmAVX7bXMLewyVKl0hCazaPBttb7FmLA2Vqwp0t0M1Zq6" +
                                          "RLiU4YVtCDzpelGjYINNERlqxn2qx2zbm07QqqLzOixWPaPV4rzpeoqWna5i" +
                                          "NBvjtJttNbrRSFyHaaYTtlHFAygk4bQT8HoczA0c9gh6g8DktsaX++rIwS2s" +
                                          "zAehOB1v1VnX9sRFg2jHw5EI0cu+iE6G1DKdOQbi9el6VdRpGHEiS8g0hchm" +
                                          "GWmOSaKOoeK6PuiBRa667pKmZBsrPaRSJlkgtGP6HaHVFGI0bdspOaWhVqO1" +
                                          "xrK51KBYeRo0wioyTxrzqDLn7PKivErDAZSgVSIG0UQ09DCDTqgo8tP+tMeg" +
                                          "ehVmah5TbWQZ59g0WAd9OkWT7gZMPstlFwOMC1o4Mw+0IFvWx/qQdAjX5+1p" +
                                          "czNZ012XbQ06dXhaJTeUbDhmpWGVKWPIbNmBqgV85jCTXrxodSZaMAgmTuL3" +
                                          "I7a3bKUtHReomWwYcZpt6010pLdCuI+Oyio/wUcDB2ZB9KOyyBxKPb2FyrzE" +
                                          "8RsqsJlgpde4qumwUtTsMnEYE2XKM/HhhG5sGhiAkIjKGWPRolyhu1LNN8Rq" +
                                          "pYlO9WEdSrvyfMlz2EqrbhSV82t9P/VJ3YYlbLOMnWSdrqbT2jKbzTYNzfI8" +
                                          "DMM365DzVYRfrBYtBwQdmZt6A3VbN7ctScXXiQkvlE2vRy8piqZcdbkc6J1+" +
                                          "vxeTCxudQUqli07sxqbcFzUVMVNBJSf1DSKOhqLLDFbzrozPmpK8aK6kyIqG" +
                                          "jWTj4GU949B1uzm3K5E2qxjlPrppmNFiPuhpRBR729qQg3F/kS6orQHVSM9T" +
                                          "NLCnCQTdTkaqTWzaQx5yY3cUyPEIlvExhBMdtbOutKmxIq2rOvjeq3Frq+3W" +
                                          "4wWhiUPZTdo2sUCqQ23gjCEr6cTNjrwabIyMQmUGh7iW5DEIpDXxCbCRrupb" +
                                          "AjOvqTXgCOwA6+oRy61GWQPEz/OJlnUguW5yiNPBGXFQW8POZl7ZGB7WXzeb" +
                                          "bKW+HjVt1NgsyOZ6Y0JLjgOeHgkX+GBdxnpr30pNMYtwH5kR63m7Fk/rMsfw" +
                                          "fFts1pxwUiZdR1J4qIJZXXVABjWml1KkqRt4mdHW2LCWbCHL6AiLOkRGDvAR" +
                                          "mhdRtJG1odheEMzE6xkui29WzbbSneNlV5VthdCyDTEbT+o2OasQZLPl1afR" +
                                          "WBioA2rOm/OxpSxoWraqo1pz3Bc7Gd7kRiMnWwQdJlxmGznYbmeo0LAYOTYM" +
                                          "GDhYbyMKsm9yVJQMTXJuqpNwHqktSMIDAUQlXRxKcRcJVW+6cGot0gxZv8EO" +
                                          "aFJeTnuEVq9G/MwWt8N5f96Fxv12NovaNA7REdNpQoneHFb7qb7kNRE1EqSt" +
                                          "jrO6iPXC/rJhpHLolutVy5JYnOuGS5qYdVWxqSWjCSRkxCipjFV5MnQ3chZJ" +
                                          "zFgLMYHp8RGvemueiF0e95AyVmGFaRXWxxy8Gatt1Mgasw2xRMY+gqOuaqMQ" +
                                          "McGHmxSZDmpNgsWW5MhqpSpYSBvh1PAmg7qb9qzKdi63vKzSUJt6OEZognX5" +
                                          "jduHhwN/0rezARwkkaWv59IKGgSUyndZLOkr7QrDqkvV70ydjTof+psxVnOF" +
                                          "lVvXR7AIz4l+u8868XLMimvdTucaCmJdESxHmoWmYDlAJt1x1dDaU4+MNSPA" +
                                          "g7WF2kh3vBrX6aQd0z69qs+wCslXbRCtqQC2NF5FqjLWBvUw1NxBfxVS2+Eo" +
                                          "DhgmVvxJGDBxRPZYaIumK8dHW4kpIb1Go72dizO8z8y3nsuMdRbyabAbc3tx" +
                                          "jwt5jaj4PWuILsqiV+0PNSGiKQ2YjgqRWkhR3hByQhoEt1TUg6YTHF2JzUFb" +
                                          "9C3QKNm0SbAP83tohPQ6qziyxopo4ynY/47E4RgiVIGhBF9g0IZuN5eblYp7" +
                                          "1nDWiDW96lcGot9uNzajuS5KSw3qNGd0fyPg8sJtdhqZwo9GGwsbbISKq8vK" +
                                          "BpOavM/7IkPWyoSy4Kky55ogtOig1THSHPiDpDn2NjWMMuZNLK45Ey10PZ7m" +
                                          "MGDVdYkQnTozsxFssdZ5hpRsNBu1O0nL7zT6oUFsa7o5ITsQJ0Ui6CubUVjY" +
                                          "kQf4LKiPfb8/IycKbfOzzhihHGuWKWU+mzNgEwBpdSTOBhQ8ZtgVk8pLiBuZ" +
                                          "FQTsFHBYUkUZtyYocJUBLXdmrTo1W1RHutBFpo7jcGsWAZFQ0hNdNCxTY8wh" +
                                          "DQ0eSsp4AlWbHTzIXN0i+YkE2c21W6uEM0ru2AO+g/qJjFR7YO/Omi3THQzx" +
                                          "bc3yosW0O+otZl46Go3FIbT0LLyvTKO6N+zMgknVGlIqUcc5ONl2am6itiTZ" +
                                          "Rocyu5kNWgGqWxDNQ6TRmPdDtDpa1Pk1UQ+CxiLSKggDKXqfcXgIZXBMX2Ss" +
                                          "3OW8gMM0125n2zTpdINx3EcrZQ4ayXGPVYZwK6uoqOIjUjJdClsIqYDdALp1" +
                                          "KxRjj+aNRZgS8dgbLbp2DcLKw2gk0hE7URbClG2BrdZqVlaVQUeEkXYUmPBq" +
                                          "EupmVU5rLdTRwj7TSZHZqsV1hlOCaawMRavB0tDTq9AwTUfTbZqVsz49KGc0" +
                                          "7mzYgdmpqK7R9fvGEmMFfTzU5IYaInE9EZwWuux11+i8WqvAOE5mLZHnCZlW" +
                                          "ELg1ojAZI8QK8NMZUpeHBAh2sVRFsqrYMoAYtYArj1dTyYnNmVnTGr1hLWoI" +
                                          "LNtgHVLk2aHIipkNk7VNcyy3BpJUD4dcw2OzqjBC+1LgbtBgJIZDMGHmSNpc" +
                                          "q9RimWzkCLcWvsXqlT615BS9u5ioQo8xymVny8xHrjWbrRqaljZweMDZbRCC" +
                                          "R+12+21vy4+6iB/stPEVxaHwScLRdhp5QfkHOGXLrtdhXLpDUaM4VLQ4Lt15" +
                                          "kgHd9b6XFSnlp4ePXiuXWJwcfvoDz7+gM5+p5CeHecMeYBj7wVscIzWcPVYX" +
                                          "AKc3XfuUlCpSqaeZjN/+wDcfEX7SfHdxlH9FhoUs3ZW3ZPOM9Ulm+vEzcp5l" +
                                          "+Y+pz34Fe6P2t8+Vzp/kNa5I8l7e6JnLsxl3hUachJ5wktMIS6+/4mjV1ww9" +
                                          "AU7rpN83XVS+eOk3nnvqXOmW/WRPzuHRM6mTu+d+6CpO3sFxVvmu2Az99emb" +
                                          "/TwKgPXefJQugs+PHaUdi/956YNBTl+ZndrMFcZw7sT6xkdDH5beeHqE3/Ud" +
                                          "x9AK1J8SPbc48VZUx8jTaf/3whsqX/wfH7l/dx7sgDfHw/DmGzM4ff+aTuln" +
                                          "fvdd/+uxgs2BlufpT5MSp9V2yd8HTzm3w1DZ5HJk7//DR//ubyufOl86IEq3" +
                                          "RNbWKLKxpSPzzYWaF2orBTXOlBUJ3Gfj0oML4yiLqFOWW5yLR6DHN1zbYAsJ" +
                                          "dqf0L/zDJ7/60y88+V+KjMgdViQpYTtcXCULv9fmO5998Vt/eO+jny+M4hZV" +
                                          "iXYWdfb6wpW3Ey67dFDocM+JMbwy1+uRozz0cT66FJcuXZlU+4mLq0SJrFXi" +
                                          "x8aP7zJUF3f5qYtFduriLtf0zmcvUkyvf4luU33+4tsuesb6qOQ9iqs+987D" +
                                          "w8Nnn3k6CApByicQHxQQH5ye9LvZQamwx+BGlnjiAm9zDG8Rm0XNt+95u25c" +
                                          "Og9QyR+dIDvp8tyOz3HW7MHTPFDX8T0jN7vjsl1+2PIPT+6dgMLsqsLPdsIX" +
                                          "nV1d8oNC8j3PeXVDe/91yv5GTp6LS7dquaQ7xa5T/eeOUijFEvCuGyVa9lvv" +
                                          "VLrcdzwBPm8+Mpc335TvuLbEH71O2d/K");
    java.lang.String jlc$ClassType$jl5$1 =
      ("yc+DQTmdgf0sNrzo2Nk7p8p++CaUvTt/+RrwqRwpW/kRKfv3rlP2qZx8Ii7d" +
       "B5TtGZEWWsFxHrp8quYv3oSa9+QvHwCf+pGa9ZdRzf2ZAebRPcfzaAB8S9Hg" +
       "l6+j+z/Jyd8H8zpPGQfx1eb17arvO4binULxD14OKN56BMVbf3RQPH7FhZXd" +
       "/aTicpw4Jgsev34ddP5VTv7ZCTr5t8+dwvBrNwFD8bIFPu0jGNovIwznTmv9" +
       "i2Msyje8vDPkJUyyjLURDkAAtzOd37o+wHv+vJ/lCIFpU7T7nZz8JgDOLJzH" +
       "1czqltS39FMw/80PC2ZxS+Xq11YeOnt15rC4Y3m0MF4D3NPgfwzk95Q8I39D" +
       "9/KfrlP2p6dr1r/PrnJ/ZCfajYQ5zMnXdoLk5E9y8p9z8nWwbwCeq9gAXD+c" +
       "5xOwvdi7dPgL1gu//zt/eeH9u/sFl9+WKO6dHjU92+5rf3y+enf81EeLbcBJ" +
       "mHQHCJujvGZcunjtO6wFr91ViLtvOICvOh3AovuT8TuG8cJ+QAGK8tffvOxu" +
       "xdVBuKQR7iX+i1/7YL2IcS+kVmSB+Es4ulZ7ecR7el3tmcuu2l4Vpkvan3/h" +
       "F778xDelB4s7lDtEcrGQbBc+1I8s/KCw8HPFdLp2THskURGgX9Le+8m/+v2/" +
       "eO7rXzlfug1EoflmSQkNsC+KS4fXunq8z+ApATz1QCuwg7pv1xrEjCfAgQF8" +
       "4OTtyZYpLr3lWryLezRndlb55V3HB06k4yeenrN99Mx2LQmC/dL9aPmHMYX3" +
       "gc3NSwDvRPcjf5uvQdll15fyCzX7hQHwb12yzfOXhBnbvyS1x0S7Q/YLEwtA" +
       "4YGQP76YXWf0Jpajd5VQ302bz3z/ziff8fBXfqKYNleC9EMC8/CpoR7d7jqB" +
       "JtgJuH+j8sh3Vve80bVd7lX92cEt+cv/lpM/y7/mofbB+X0f99Kc654/u05n" +
       "d16n7O6znb54o+Xy1H8e3JGTu3JyD/CfJkCu6+uFjcY3jdCDOblQ8Mqf7s/J" +
       "Ay8RoZcY4uxGNmf86usI8shLRGh/u5S3ezgnr8nJa8EaaIBN6S7e/9xNQ1Ow" +
       "f6zglT89npMnXiZo9vv5seuUPf1DovLGnOTlB28CJhP7pxc/yzeNSyUnxWlj" +
       "fpx4kK/2B+Uf1aSqX6es+RLBuWZkclDLSX4yetDKAyg/tuabvPCrNw1SfkP0" +
       "4K0Fr/wpP8I9ePuPCqT+dcqwmwapl5NBTvC4dOcOpLbjvDw4MTkZneBE5oR+" +
       "OXHac0Kdokfh+vuEx05XWSI/OguTIM5PFPa2DAfSTWPK50TMyQxsL9aKFb88" +
       "cL47Jz91AuezObn0Mvmsva1aJydx0aNxTbwPJkWFxQ+89B2e4pSHFwfznJin" +
       "mt00St7lKC1z4v4IPHt0I2ySm8EmTwAcFKt2+jJi897Lscnd4cF7srj0yqv9" +
       "YCY/VH/1Fb/n2/0GTfv8CxfuePgF8T/uTqiPfyd2J1m6Y544zv5vPPaebwtC" +
       "Y24VSt65y1QUO+CDnwY7tRsdC8Slu06/5ModvG/X+AMgJr9qYzD38n/7dX8W" +
       "bHjP1o1Ltxb/9+t9CPR2Wi8/dyke9qt8OC6dB1Xyx7+Z/wblGrHtAzcaqL1U" +
       "2pPX3NFRye4nl5e0L7wwpN/z3fpndj9iAQH2dptzAVum23fZoYJpnml54prc" +
       "jnndhj/9vft+9c43HCfn7tsJfDo/9mR7/Op5m74bxEWmZfvrD//aW3/5ha8X" +
       "P6T4/5omgocJOwAA");
}