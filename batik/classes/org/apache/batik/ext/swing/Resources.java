package org.apache.batik.ext.swing;
public class Resources {
    protected Resources() { super(); }
    protected static final java.lang.String RESOURCES = "org.apache.batik.ext.swing.resources.Messages";
    protected static org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      RESOURCES,
      org.apache.batik.ext.swing.Resources.class.
        getClassLoader(
          ));
    protected static org.apache.batik.util.resources.ResourceManager
      resourceManager =
      new org.apache.batik.util.resources.ResourceManager(
      localizableSupport.
        getResourceBundle(
          ));
    public static void setLocale(java.util.Locale l) { localizableSupport.
                                                         setLocale(
                                                           l);
                                                       resourceManager =
                                                         new org.apache.batik.util.resources.ResourceManager(
                                                           localizableSupport.
                                                             getResourceBundle(
                                                               ));
    }
    public static java.util.Locale getLocale() { return localizableSupport.
                                                   getLocale(
                                                     ); }
    public static java.lang.String formatMessage(java.lang.String key,
                                                 java.lang.Object[] args)
          throws java.util.MissingResourceException { return localizableSupport.
                                                        formatMessage(
                                                          key,
                                                          args);
    }
    public static java.lang.String getString(java.lang.String key)
          throws java.util.MissingResourceException { return resourceManager.
                                                        getString(
                                                          key);
    }
    public static int getInteger(java.lang.String key) throws java.util.MissingResourceException {
        return resourceManager.
          getInteger(
            key);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDXAV1RW+eQkhCQn54T9AgBCwILwnKhUnlgrPREJffiZB" +
       "tEEJm333JQv7dtfd+5IXLP4w7Zg6UwYp/nU07UyxUAbEcXTaTquldUQY0RkV" +
       "a9WqrTotlTKFabVOabXn3Lv79uf9ZOxAZva+zb3nnnvOued859y7h86SCZZJ" +
       "GqjGwmzEoFa4RWNdkmnReFSVLGsD9PXJDxVL/9h8uuPaECntJZMHJatdliza" +
       "qlA1bvWSuYpmMUmTqdVBaRxndJnUouaQxBRd6yXTFKstaaiKrLB2PU6RYKNk" +
       "xkitxJip9KcYbbMZMDI3BpJEuCSRNcHh5hiplHVjxCWf6SGPekaQMumuZTFS" +
       "E9sqDUmRFFPUSEyxWHPaJJcbujoyoOosTNMsvFVdaZtgfWxllgkan6z+9MLu" +
       "wRpugimSpumMq2d1U0tXh2g8Rqrd3haVJq3byZ2kOEYmeYgZaYo5i0Zg0Qgs" +
       "6mjrUoH0VVRLJaM6V4c5nEoNGQViZIGfiSGZUtJm08VlBg5lzNadTwZt52e0" +
       "FVpmqfjA5ZG9D22ueaqYVPeSakXrQXFkEILBIr1gUJrsp6a1Jh6n8V5Sq8Fm" +
       "91BTkVRlu73TdZYyoEksBdvvmAU7UwY1+ZqurWAfQTczJTPdzKiX4A5l/zch" +
       "oUoDoOt0V1ehYSv2g4IVCghmJiTwO3tKyTZFizMyLzgjo2PTN4AApk5MUjao" +
       "Z5Yq0SToIHXCRVRJG4j0gOtpA0A6QQcHNBmpz8sUbW1I8jZpgPahRwbousQQ" +
       "UJVzQ+AURqYFyTgn2KX6wC559udsx3W77tDWaSFSBDLHqayi/JNgUkNgUjdN" +
       "UJNCHIiJlUtjD0rTnx0NEQLE0wLEguZn3zp//bKGo8cFzewcNJ39W6nM+uR9" +
       "/ZNfnRNdcm0xilFm6JaCm+/TnEdZlz3SnDYAYaZnOOJg2Bk82n3sm3cfpGdC" +
       "pKKNlMq6mkqCH9XKetJQVGreSDVqSozG20g51eJRPt5GJsJ7TNGo6O1MJCzK" +
       "2kiJyrtKdf4/mCgBLNBEFfCuaAndeTckNsjf0wYhZCI8pBKeRiL++C8jN0cG" +
       "9SSNSLKkKZoe6TJ11N+KAOL0g20HI/3g9dsilp4ywQUjujkQkcAPBqk9gJFp" +
       "DYMXRdDtOVEYHcy4dKzTqNWU4aIiMPicYLirECnrdDVOzT55b2pty/kn+l4S" +
       "roTub9sDAApWC4vVwnw1Do58tXBmNVJUxBeZiquKHYX92AaRDdBauaTntvVb" +
       "RhuLwZWM4RIwJpI2+lJM1A1/B7P75CN1VdsXvLfi+RApiZE6SWYpScWMscYc" +
       "ACySt9nhWtkPycfNAfM9OQCTl6nLNA4QlC8X2FzK9CFqYj8jUz0cnAyFsRjJ" +
       "nx9yyk+OPjx8z8a7rgiRkB/2cckJgFg4vQvBOgPKTcFwz8W3+t7Tnx55cIfu" +
       "Br4vjzjpL2sm6tAYdIOgefrkpfOlZ/qe3dHEzV4OwMwkCCTAvIbgGj5caXYw" +
       "GnUpA4UTupmUVBxybFzBBk192O3h/lnL36eCW0zGQJsBz2V25PFfHJ1uYDtD" +
       "+DP6WUALngO+1mM89vtX/noVN7eTLqo9eb6HsmYPRCGzOg5Gta7bbjApBbp3" +
       "H+76/gNn793EfRYoFuZasAnbKEATbCGY+TvHb3/r/ff2nQq5fs5IuWHqDIKZ" +
       "xtMZPXGIVBXQExZc7IoEKKcCB3Scpps0cFEloUj9KsXY+k/1ohXP/G1XjXAF" +
       "FXocT1o2PgO3f9ZacvdLm//VwNkUyZhlXbO5ZAK6p7ic15imNIJypO95be4j" +
       "L0qPQRIA4LWU7ZRjKeFmIHzfVnL9r+Dt1YGxa7BZZHn93x9inmqoT9596lzV" +
       "xnPPnefS+ssp73a3S0az8DBsFqeB/YwgPq2TrEGgu/pox6016tELwLEXOMoA" +
       "aVanCdCY9jmHTT1h4tu/eX76lleLSaiVVKi6FG+VeJyRcnBwag0CqqaNr18v" +
       "Nne4DJoarirJUj6rAw08L/fWtSQNxo29/ecznr5u/9h73NEMwWM2n1+MQO8D" +
       "Vl6Uu7F98PVr3th//4PDIq0vyQ9ogXkz/92p9u/84LMsk3Moy1FyBOb3Rg49" +
       "Wh9dfYbPdzEFZzels5MT4LI798qDyU9CjaUvhMjEXlIj20XwRklNYaT2QuFn" +
       "OZUxFMq+cX8RJyqW5gxmzgnimWfZIJq5SRHekRrfqwIANhu3cBU8y+3AXhYE" +
       "sCKAhOUFMqqZyd/t4IJQJ3Lebby9jLdLsVkudhtfw4yUWrwyZyCxoklqAGjq" +
       "HTlyyAP41N3S03lTd7Slh8+aCScj7n1osLCoegXoYrsKm/WCf3Ne/45m1p+G" +
       "vTF4rrLXvzLLHoS/bMytYIgriE1HQKmpDrMcTGHTVV3mxxAAuZ6UYegmc7T7" +
       "SpbxlRWrtHAsa0JA65u/pNY3wHOtLeCqPFpv+X+0XpWHKWCf4zztkgaeYzoq" +
       "R7JU5tDiulq3f15Ac6mA5uncGoCTlxqpfjjiuwrwv1ISKKu9Sc+FMYJYPTff" +
       "yYef2vbt3DsW73x8hQCyOv9pogUOy4d/99+T4Yf/eCJHSVvOdGO5Soeo6lkT" +
       "rz3m+qCznR8KXRx6d/KeD3/RNLD2y5Sj2NcwTsGJ/88DJZbmR+OgKC/u/Lh+" +
       "w+rBLV+ispwXMGeQ5U/bD524cbG8J8RPwAIgs07O/knNflisMCkc9bUNPnBc" +
       "mHGAOtzYpfCsth1gdTAsXMfLHRNqrpioLcAxUHEU2YcPH9CJYgDDn3IB7ixQ" +
       "puzEJg0OhOdJPsUqmES7TCUJpeaQfe6O7Kh7f9ujpw8Lnw1mzAAxHd173xfh" +
       "XXuF/4qbjIVZlwneOeI2gwtaI2z0BfwVwfM5PqgFduAvQGTUPlLPz5ypsZQw" +
       "yYJCYvElWv9yZMcvD+y4N2RbBSKqZEhX4i5kjIwHloVLIOxYY/B+ltnsWQ5m" +
       "tNqb3XrR3CcfxwKe8FCBsUewuR+8ZMDxEuy4yzXPnktlnsXwdNjKdFw08+Tj" +
       "GDBByGXV7b9CRpDsSfVbjB8XhHvfOunYr60f//kpEQuNOYgDl1YH9pfJ7ySP" +
       "fSQmzMoxQdBNOxD53sY3t57k0FiGWJwBJA8OA2Z7jqA13PMX5Q9kj+BjP1n4" +
       "yl1jC//EjwpligWIDsxy3NR55pw79P6Z16rmPsEzRwnKZMvjv+LMvsH0XUxy" +
       "Uavtet9fqInKNifQRQ2n3HhyvM3v5CuMQvJWqTbABjnlt3mfWPQ+RopBRnw9" +
       "ZKSDO+/INcWVK6rqGsWiyhkTF0SKHs7cFMNgOqfgzODiHBJSY8Mz7GiByDta" +
       "YOy32DwLNbKMMgkVCpC/kC/uPCHqSGuSqX53FLt+w3erf7W7rrgVdr2NlKU0" +
       "5fYUbYv7c+ZEK9Xv8U/3StjNoDViAxC6GSlaCijNux8vnNwa3eTWrlgWlPFO" +
       "ldeSlqmBxQJncxKbHzJSxW9rmH3qEEGcAawfXUo877HhpeeiAVY+jrktxnXl" +
       "i72dn+BlTvAHbE4JZHfPRh5DvXEJDDUdx+bDc4ut1i0XzVD5OI5nqNPjGepj" +
       "bD5gpAIM1QaghqeR3CgfqHqu7NoijzZ1feTUFgeE82P7dK7lTqRd4394MYyP" +
       "1V3mWhsvY2ZmfSYTn3bkJ8aqy2aM3fSmAHXn80slJJ1ESlW91wWe91LDpAmF" +
       "61MpLg8Eyn3CSH3+awFALf7Lhf6nmPEZgGmuGQDR0HopL0CqCFICR/7rpfsc" +
       "9sulgywgXjwkeHtRDCT4GuIGO5wu8p/bMrsxbbzd8Bz1FvoyL/986fhJSnzA" +
       "7JOPjK3vuOP8Vx8Xt7uyKm3fjlwmAYaKi+bMSWdBXm4Or9J1Sy5MfrJ8keNl" +
       "tUJgN45mezLBGnA1Az2hPnDvaTVlrj/f2nfdcy+Plr4GRcEmUiRBDtyUfe+U" +
       "NlJwxNwUy84VUEPwC9nmJT8YWb0s8fd3+M2enVvm5Kfvk0/tv+31PTP3NYTI" +
       "pDYyAYpzmuYXYjeMaN1UHjJ7SZVitaRBROACCdeXiCaj00oIY9wutjmrMr34" +
       "bQAySfahI/uLSoWqD1NzrZ7S4nYqm+T2ONWM77CYMozABLfHU+8cFwCAuwG+" +
       "1xdrNwznEFN+1uA+eCI3MKCTTuGv+Db1fx/a8+7aIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EXe9iDd0rugUqpPIbI5xdtslKLQ5t7HusjHcTRFsGIhW1+J3NcVF82HEWLib" +
       "IXm+qc5oK+vuunInNExm04MairLBjaHR3M63vZlBTzllmO66C7gad4D9tFrK" +
       "RE96YXNr7SyfaEROO0ZFdTIzND3c+PrMlqBAg9XxYCc0ZymZbjCMQ7eTlTGy" +
       "Woq8FNORy/tok+cS3+GFXpavhrteb1NHGjN4DdkuAbc1bFHbjeZ41Ns1hEaL" +
       "HupjvJ6I/bhf7dPtBY8SrjGr1h2yi2zjJeR6AtXROCLwEG3VHkeOSDPYaDcz" +
       "WqNY7qxWFur3Vj48rnbakEG5HQQe6IzoDRNJjlB3NR2g3AobiVVuO17BUAjp" +
       "esOdBy09ak2SxTjoT6ZSFpMSvRxNhN5yPsgkpTPxBtOpgvVgVvH9qKYMB7bH" +
       "W8g0WorVDVT31ksaGtWX1hIdDpeewtUBIhgzGOwisrJVCQeChJTa8Lm0tper" +
       "WUtCp22/Yyr1lulQEzz3Z0hrpTUtohbQc2aCNokF35EYa6oNncl4pwsugYTV" +
       "flwXR5nc6UnS2EXgDDFdJ/A4pIW07Z2QuTTtajpbjSK/A8swW5N33X4vGgZa" +
       "DxJTgw4aXDgYGQnke1m7Vm/HAwLAwnJGeqgsyC6mYiJiOWOOq6+bcQJpy04b" +
       "fIMTrGwKwtRsD0dVQcNzRnF7qWzUsCCQqbDe3VKu1uzjnhyaIc5b7RBNa10C" +
       "0hcxO6cyr4FAmrJzw1YC9sIOTA3IdEE23HqVnM+6fcFu80lniHRpIYTjNQQ1" +
       "6f4kqG3zOeIZy80OQho+kkDdJkFGG5j08vow781WMGM0kcUaUXVxBUB7MJR2" +
       "mh21SK5JTDpIN+jnPIJZMr9dk9ZgaU+sRm2ZMhubEmWuMU+G7kzisyEZVJVl" +
       "l8HzYNEyMmdnuKaz0KUJHrRYZqxtmFAP0glKrRNY6fHdvAqjy7U4iLApup7x" +
       "oHsg5SoUNyf4HIcJbbXKEYtQiUjYJOo61tNmzi/CNJdyLPM2doCOrGDM2XmO" +
       "0s06BZYHtjm1w9rrblXGWMXquHUvIjBPM5aeGEZTB1pgOkxpULPl1P3qaMsN" +
       "m2FILLc7ghh7LLQi81icGKE5qI/nU8fvh6TCjcacIMBOlqFoIrV5UTMcpcN1" +
       "WH+V2cwijMdoJNdwtA2Ww6dEOB3PYkLDAnrob6vLam3pL8ZTMG1zt4s3hqyJ" +
       "Oy9gOjjfivtmYgewXm+hSttBW4mrjDyAO1ng65ZlJmmYbusTdjpNEFapDkkR" +
       "F2lO13NR0xvbVQz3o0UHzrrrOZbPtojvGfwMIC6EIFWuKeqQhuFjVtjO1NGs" +
       "xXqa17Y3XLiDnWqA7VymO10yWVuFplofhhiK6DfyFms1KCXlohEOdbt9XFo5" +
       "THVmTDEogYh1Na2GPUKompGfLsmRNm/x0KrfajSV1aiLdxk6RSdGVOvMAJxT" +
       "um1GJLZRkBVP0W5PccYjdBbvRF/HonhdN1QOjZakTowZKgh90yMUNOPHA74h" +
       "KvQYwXDR6PddeNLrmNncT3YD3KjN1jMVpyM+cAZsh8N43Nfkua61Z53puqMj" +
       "ieWnXQJsGc4ORbOxWgeq0dfLZTKEmsHKmgiSnbraTJs0jDSWJ41draenQqqT" +
       "LTowhmqCbucjjqdtgt61cj+S5mku4pi4HdiLLZJLpLLtV/Mm1WBWPXYaSIP1" +
       "smm2NtYkHdueQExmmShCvaodu9Fi3nJiKljBy5CBMUXP0qnWHWK9iNfShKl2" +
       "QXCZDZK8me+WtLuJbTdapiplTdUhcPIqZ436vV4+WgqdFYIxfj9idWFl9brL" +
       "9XirzxJXDNs1HYI2/mCeUDOgKLsujhFfxzs5S+vs3NmRXjZXe9Qs67fgSITj" +
       "VmdTG5qjBZ72cLQ7QxtSxwrQOkyTy9Yc2VjVnkXX3WZu1y0MggZW6tumsZj0" +
       "oyyHKabV8tMOQrelejt06GiwY8DngkRurW2VILfRuLbks5yXt7EWI3owcaeU" +
       "qc+ZOYhkxut8S8LbFpaQ8y2+CLgV2rNcO4YdfUHPq4zn9xg3RaQp259VoQml" +
       "LIRpOwxG0cLM1xtuWGOn46ijDEnKmAW6sZv1zXEPZ8UuueuMzF7ej2VxlsON" +
       "fkpQqylJGhsB8zFoA+yVxsYBO0rYYNmCh0RcTWEt1DuLThgagho2KHvK11q6" +
       "yK/EbUepSoMpstx2eQhmY4vy+oKJZlh7xNoyZlpUknW3LpXKsMYtQttY2PRw" +
       "ZqsaawdOL5vjrpJNV+MdzmYLJHTGcDAYjBRUTvUl73U7nfHa1zQTFcSqFW7i" +
       "zF3aZqehutWezW3R8WrQxKWxTjPrVn+7HOD9Pq9m1VVfaSZx3awtd0K/NZu0" +
       "3ICirZHmW8DhDB+dkPW5bKwDDdiXoQfjIOlQnmntpLqucfzQ0AbdBt1Rpx2b" +
       "Cxi1CSNNUszpOsCwxTraig3J0VmRc+HVBu/KQd6QSVhnHXS8dLu1yMbx+oC1" +
       "F0g9XWhInej7qDNs10mfMLqD3IUxdgxX5XSIEnqHWOtt16EHkjFyktG8z9TG" +
       "nk+AbQwbTjAG6oS+HilIlNhGnhpLK91o45jpY1xzlEwAKqVJ1weQG0bZarVT" +
       "u71dfbj1cvCB123ra5x1d2gHB6HVFN4mM7orZN1l3EnyqQPrlp06IHCemtUV" +
       "yS7U3tJpzkIEr7N5i9RDvLvRKDvmcYMCOK/tiN7IRevorrGm3f5W5gQ7tCAQ" +
       "oOiqkldpO2yOGGXg8CbT68c5r2tVnrLxNKNSPu82BX5ApxjiOjjXFRerWtTV" +
       "VbhKNjRX2Dqtqb7d1KB4W4XrNEfDlMhNQBCco6K/cxJxKVoaKVN1fmzhHVYS" +
       "zFhmeswMxTBVW5qYbNVq3kRE0iS2nJAM4eZqjuasLq8nUEKw3iLo16ldKHXY" +
       "pisGTpVrzKgF2elgIunt0B6hj/kq+OhIMTRJR9V6poZUunMHQ6paT9Cqhk1g" +
       "copxXDLaVvurup5BcrfakYtDgeKYIPvWTmoeLQ+gTrPX/x9HT3eY8FI54SGp" +
       "Uv5dqVzIgZ5NqhxO2ivFOcxTd0pTl2cwn/7wy6+os5+rXz7OUERx5Wrs+e+z" +
       "tS2Ibw5DFVcynr/zeRNZZukPJ+e/8eG/eJJ7//qD30JK8B0X+Lw45L8iX/3N" +
       "0buVf3y5cs/pOfot9wfOd3rh/On5g6EWJ6HLnTtDf+pUs48VGnsePO8/1uz7" +
       "Lx6rHlbz9meqypkz1QtZoEvH2dVzx9v7BE1xMqyVnX7qLqmjny6KnwSrUyTM" +
       "yy4lmXvGrMK4cu/WM9WDvX30zU7Ezs5SVrx0qo7vOjGu4bE6ht9GdZyV7J/f" +
       "pe1fFMU/A1IbJ1IXFR8/SPipv62E7wYPdSwh9W2U8PKBagJ851139p0yubg/" +
       "en3lXz73Oz/yynN/VObnHjAjQQ7R0LjNXZMzfb726pe/8sWHn/pMmca+dyVH" +
       "e+O+eEnn1js4567WlDI85Ge3yb/sk1e3teTv809SDf/2zbR0ipRXbM014vXt" +
       "rPcewGPx+toxH2f0eMLXWw58YbbnakVC5aRtf8XB9I5O7zqBxuy2jL/kl+y8" +
       "tue6KD70Zmb6a3dp+/WieD2u3KcUPO1FuAv557L976t3B4lnDyBBmlFkusZJ" +
       "tmWQKZpf4Gk5zG8Vxc/HlYfLmwjxcf5ub3mnjvIL3w4oYI8dhf32I2PJbknw" +
       "e3cm+HxJ8PtF8YU9KBySg2dk/eLfQtbHi8pnwLM8lnX5dynrH7+ZrH9SFH8Q" +
       "Vx4Esk6ABx/n2H7lIOyXvhVhsyLXepK8Ky45vO2Wq4b763HKZ1659sATr/D/" +
       "ZQ8rJ1fYrhKVB/TEts/mpM+8X/FDTTdLxq/uM9R7P/tKXHnyzrln4Dflb8nt" +
       "X+x7/HfgzrfrAUAClGcp3wBgdZESjFj+nqX7H0CJBzqAQ/uXsyR/DUYHJMXr" +
       "18vF/mx26Xw4dar1x95M62cisOfOYX95BfQkxkn2l0BvKq+9glM//Eb75/aX" +
       "ehRb3u2KUR4AML2/X3QaJ73zjqOdjHVl/J5vPPLZq+86ieke2TN8sNszvL3j" +
       "9tdnBo4flxdedv/+iX/3/T//ypfKTOb/AzY6CbGbKwAA");
}
