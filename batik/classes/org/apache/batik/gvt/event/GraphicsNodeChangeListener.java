package org.apache.batik.gvt.event;
public interface GraphicsNodeChangeListener extends java.util.EventListener {
    void changeStarted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce);
    void changeCompleted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce);
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1471188907000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2wcVxW+u+t3/I5jh6R2XpsIO2FXLU2l4hAaO3bisHas" +
                                          "OK2UdZvN3dm7uxPPzkxm7qzXLkGlEtQtUhQFl5aq9S9XBdSXEBUgaBWE1Ifa" +
                                          "IrVEQEFtkfhBeUQ0Qio/ApRz7p3dmR17UwESlvbu7J1zz/t851w/fZXU2xYZ" +
                                          "YDqP8QWT2bExnU9Ty2aZUY3a9knYSymPROjfTn8wdXuYNCRJe57akwq12bjK" +
                                          "tIydJP2qbnOqK8yeYiyDJ6YtZjOrSLlq6EmySbUnCqamKiqfNDIMCe6iVoJ0" +
                                          "Uc4tNe1wNuEy4KQ/AZrEhSbxQ8HXwwnSqhjmgke+2Uc+6nuDlAVPls1JZ+Is" +
                                          "LdK4w1UtnlBtPlyyyF7T0BZymsFjrMRjZ7X9rguOJfavccHO5zs+un4x3ylc" +
                                          "sJHqusGFefYJZhtakWUSpMPbHdNYwT5HvkwiCbLBR8xJNFEWGgehcRBattaj" +
                                          "Au3bmO4URg1hDi9zajAVVIiTHdVMTGrRgstmWugMHJq4a7s4DNZur1grrVxj" +
                                          "4sN748uPnO78XoR0JEmHqs+gOgoowUFIEhzKCmlm2YcyGZZJki4dgj3DLJVq" +
                                          "6qIb6W5bzemUOxD+sltw0zGZJWR6voI4gm2Wo3DDqpiXFQnl/qrPajQHtvZ6" +
                                          "tkoLx3EfDGxRQTErSyHv3CN1c6qe4WRb8ETFxugXgQCONhYYzxsVUXU6hQ3S" +
                                          "LVNEo3ouPgOpp+eAtN6ABLQ42VKTKfrapMoczbEUZmSAblq+Aqpm4Qg8wsmm" +
                                          "IJngBFHaEoiSLz5Xpw5cuFc/qodJCHTOMEVD/TfAoYHAoRMsyywGdSAPtg4l" +
                                          "vkl7X1wKEwLEmwLEkuYHX7p2x76By69Kmq3r0BxPn2UKTymr6fa3bhodvD2C" +
                                          "ajSZhq1i8KssF1U27b4ZLpmAML0VjvgyVn55+cTLp+77LvtzmLRMkAbF0JwC" +
                                          "5FGXYhRMVWPWEaYzi3KWmSDNTM+MivcTpBGeE6rO5O7xbNZmfILUaWKrwRC/" +
                                          "wUVZYIEuaoFnVc8a5WeT8rx4LpmEkEb4kBB89hL5148LJ/l43iiwOFWorupG" +
                                          "fNoy0H47DoiTBt/m42nI+rm4bTgWpGDcsHJxCnmQZ+6LXBGqs4j4dMSiZl5V" +
                                          "7ClApNE8pBdDBELTYphx5v9RVgnt3jgfCkFIbgoCgga1dNTQMsxKKcvOyNi1" +
                                          "Z1Ovy2TDAnE9xsl+EB+T4mNCfAzEx4T4WG3xJBQSUntQDZkEEMI5AAMgaB2c" +
                                          "uefYmaWdEcg+c74OA1AS1bm1/AMOBtQVOPD5GfOJX//8j58Nk7AHGR0+rJ9h" +
                                          "fNiXpsizWyRkl6fHSYsxoHv30elvPHz1gVmhBFDsWk9gFNdRSE/AXMCur756" +
                                          "7p3331u9Eq4oHuGA004a2h0nTTQNIEcVzklzBa2kYT0fw18IPv/CD9qIGzLz" +
                                          "ukfd9N9eyX/T9LkjJJ43c9Ln2TCG7i/7Gt3VXwtIBAiu3r+8kjn+5M2y3Lur" +
                                          "i3MMes8zv/znG7FHf/faOvFv5ob5GQ3irfl0CqPIqiliUmBsuSOnlHfbL/3+" +
                                          "R9HcSJjUJUg3OMWhGs4Dh6wcdBplzgXj1jSMFl6H3+7r8DiaWIbCMtBganV6" +
                                          "l0uTUWQW7nPS4+NQnj8QaYdqd/+g6q/c/6ctJw/mz4gs8/dzlFYPrQhPTmMX" +
                                          "rnTbbQH3B1l+Z/Lp147sUS6FRQNCMF+ncVUfGvYHAoRaDDqtjubgThsI3Rms" +
                                          "6KC3UsrQdvpC6sXzURGFZujCnAJqQoMbCAqvaiLD5epCUU3ghKxhFaiGr8ou" +
                                          "b+F5y5j3dgTUdMlkhwQRdXwrfKIuzIpvfNtr4tonoUnQD4h1By5RmV34uBuX" +
                                          "PYLs05Bte7zkh76gAV5iRKJ36hB2NavStCaw5x8du29+4S8XOmUia7BTDtG+" +
                                          "T2bg7X9qhNz3+um/Dwg2IQXnEg9kPDLZ7DZ6nA9ZFl1APUpfebv/W6/QJ6Bt" +
                                          "Qquy1UUmuk+ouqJv+Y+wVRS9cMioYHBQrCPoWBc38fcRXD7HSZsiDkGxWYAo" +
                                          "oObgDeZfSy0AYBbdCSJ+vvv9ucc/eEbCRXDcCBCzpeWHPo5dWJYelzPZrjVj" +
                                          "kf+MnMuEsp0ivAhgO24kRZwY/8Nz53/87fMPhF1DY5zUFQ0VTYvWMM03ZaeU" +
                                          "i1c+bLvrw5euCUWrx3R/C5mkptStC5dh1K0v2MSOUjsPdLdenrq7U7t8HTgm" +
                                          "gaMCzdo+bkFDLVU1HJe6vvE3P/1Z75m3IiQ8Tlo0g2bGKQ7EMNZALTE7D724" +
                                          "ZH7hDlkv802wdIqokjVxXrOBabht/QQfK5hcpOTiD/u+f+CplfdE85IN5pbq" +
                                          "er0NPkNuvQ79T/VanZ5u1uPPw4IgdYP8pbgkISYyf7E5agwyGLcT4sQ0LrPS" +
                                          "CTP/pb9w45RZgkm/9gyDTt285holR3/l2ZWOpr6VO38lkLUynrdCL8o6muYD" +
                                          "bj+IN5gWy6rCzFaZY6b4UkGP2lDASb34Flbk5QnoHz3rneAkAquf0oDbcJAS" +
                                          "OIpvPx00hRaPDsYa+eAncYA7kOBj0TRLoeqZrRKaTZ8UGt+Yt6uqcsXVttxC" +
                                          "HXm5TSnPrRybuvfabU/KqQ8uxYuL4ioENzvZlypteEdNbmVeDUcHr7c/37y7" +
                                          "DCJdUmEvubf6UvEUJK2JWbAlgPB2tAL076weeOnNpYa3AQNmSYhysnHWd7GU" +
                                          "tyhoEw7MS7MJb2Ly/WtEtJ7hwccWDu7L/vW3ojpFj4CRvTZ9Srny1D2/uLR5" +
                                          "FVrUhglSD/jISkm4JduHF/QTTClaSdKm2mMlkcscru0TpMnR1XMOm4ALeTsm" +
                                          "LMVLr/CL6862yi6OEpzsXAvja+cxQLJ5Zo0Yji5KtA2w1dupunOXJxnHNAMH" +
                                          "vJ1KKHvW2p5SDj/Y8ZOL3ZFxKLoqc/zsG20nXZmS/NdwOTb5uo4cvyOpxKRp" +
                                          "lsfxuo9caPyapMF9TkJD7m4AzR4U7JbEIy5f/ze3oa+SYRMAAA==");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1471188907000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAAL05eczkVn3+vr03x24CJGkgCQkLajLweWZsj2e0XB6P5/B4" +
                                          "TttzmJaNb3t8jq/xDE0FkYC0SAG1oaUS5C9QWxSOVkWtVFGlqlpAoEpUqJdU" +
                                          "QFWlHhSJ/NEWlbb02fMds99mE0WVOpLf2M+/+3rv/fzCD6FzYQAVfM9e67YX" +
                                          "HahpdLCwsYNo7avhAc1gQzEIVYW0xTDkwNwN+bEvX/n3n3zCuLoPnReg14mu" +
                                          "60ViZHpuOFZDz05UhYGunMxStuqEEXSVWYiJCMeRacOMGUbXGeiOHdQIusYc" +
                                          "iQADEWAgApyLABMnUADpLtWNHTLDEN0oXEK/CO0x0HlfzsSLoEdvJuKLgegc" +
                                          "khnmGgAKF7PnCVAqR04D6M3Hum91vkXhTxbg5379/Vd/9wx0RYCumC6biSMD" +
                                          "ISLARIDudFRHUoOQUBRVEaB7XFVVWDUwRdvc5HIL0L2hqbtiFAfqsZGyydhX" +
                                          "g5znieXulDPdgliOvOBYPc1UbeXo6ZxmizrQ9b4TXbcaNrN5oOBlEwgWaKKs" +
                                          "HqGctUxXiaBHTmMc63itCwAA6gVHjQzvmNVZVwQT0L1b39miq8NsFJiuDkDP" +
                                          "eTHgEkEP3pZoZmtflC1RV29E0AOn4YbbVwDqUm6IDCWC3nAaLKcEvPTgKS/t" +
                                          "+OeH/Xc++wG37e7nMiuqbGfyXwRID59CGquaGqiurG4R73yC+TXxvq8+sw9B" +
                                          "APgNp4C3ML//Cy+99+0Pv/j1LcwbXwZmIC1UObohf1a6+9tvIh+vncnEuOh7" +
                                          "oZk5/ybN8/AfHr65nvog8+47ppi9PDh6+eL4z+Yf/Lz6g33ocgc6L3t27IA4" +
                                          "ukf2HN+01aClumogRqrSgS6prkLm7zvQBXDPmK66nR1oWqhGHeisnU+d9/Jn" +
                                          "YCINkMhMdAHcm67mHd37YmTk96kPQdAFcEF74CpA299D2RBBBmx4jgqLsuia" +
                                          "rgcPAy/TP4RVN5KAbQ1YAlFvwaEXByAEYS/QYRHEgaEevtATkJ0JgIZbgegb" +
                                          "phz2PUUlDRBealYaMtUOsojz/x95pZneV1d7e8AlbzpdEGyQS23PVtTghvxc" +
                                          "XKde+uKNb+4fJ8ihxSIIA+wPtuwPcvYHgP1Bzv7g9uyhvb2c6+szMbZBAFxo" +
                                          "gWIAAO58nP15+slnHjsDos9fnc0ckObZ+UD+cAbgPX770t3M6kYnr5UyCOUH" +
                                          "/nNgS0///Y9z0Xerb0Zw/2XS5RS+AL/w6QfJd/8gx78EClUkgsACNeDh00l7" +
                                          "U55l2XvapKD+ntAtf975t/3Hzv/pPnRBgK7Kh8V9ItqxyqqgwF42w6OKDxaA" +
                                          "m97fXJy2mXj9sAhE0JtOy7XD9vpRJc2UP7frSnCfQWf3l/OwuDuHueen4LcH" +
                                          "rv/JrswT2cQ2Je4lD/PyzceJ6fvp3l4EnSsf4AfFDP/RzMenDZwJ8C7W/8xf" +
                                          "//k/I/vQ/kl1v7KzXgIjXN+pKBmxK3ntuOckZLhAzYz1d58a/uonf/jR9+Xx" +
                                          "AiDe8nIMr2VjJjFYHsEy8+GvL//me9/97Hf2j2PsTASW1FiyTRnchPlqBzTR" +
                                          "TFe0c4M8FkH3L2z52pHWE7D6AcGuLWw8N9UbwHqfi5Z55WC7ZOT5BSS6dptw" +
                                          "3Vnmb8if+M6P7pr86I9euiVSbzZMT/Svbz2US5UC8vefzqK2GBoADn2x/3NX" +
                                          "7Rd/AigKgKIMqkU4CEBGpzeZ8RD63IW//eM/ue/Jb5+B9pvQZdsTlaaYrcig" +
                                          "rkYGWMQNUAxS/z3v3dbF1UUwXM1zE8r1f+NWnDyt7z4xBOOBlfNj//CJb338" +
                                          "Ld8DctDQuSSLYSDBjrX6cbaZ+MgLn3zojue+/7HcJ6AKT37pd5AfZ1SrOYO3" +
                                          "5uPPZkNh67Hs9u3Z8I5sODhy04OZm9i8OjJiGPU8xQSbCSX31CuWjmFgOiDa" +
                                          "ksOVEn7q3u9Zn/6nL2xXwdN14hSw+sxzv/zTg2ef29/Ze7zlluV/F2e7/8iF" +
                                          "vuvYlY++Epcco/mPX3rqD3/rqY9upbr35pWUAhvFL/zlf3/r4FPf/8bLFOuz" +
                                          "tncUlNlYPmSb/WGv7tjoji+30bBDHP2Y0lwsr+RJOi3EhQiBO9jCqIzLMz/s" +
                                          "DMrNGcOXbdQgxAEimSGIsUG3zCtC0kcUB4/T4XBjpQ6+3MwYq2VT0SjijVHT" +
                                          "xsRlja3N6go7o+q8LtanVKmjiZ1gQo2oZmRpRl3lR8WR6cGEP97gPqA2LuH8" +
                                          "imLtRIpxurTZwFEVK61gTZjx5XQuzBvLYXU05coSlbp8jVuXRYGfI2LNcufs" +
                                          "2hmOBwuNc6srZRbP++SYVjFctFbLUlladKPOWqGH5aXkDpbd6lqdm+sGXZlH" +
                                          "wmIQsIy9rFDOmpV4l1yKTtdcav1Gp0eqFXPi0UVeRqO+Wlr1Y2qNdkcwIQSU" +
                                          "wUrpqNqerVYuuzQWjm6phTIvFypu3LCJydAOS7RQ6ISM0kVXJT5y7Xo0tNfr" +
                                          "dRPninVh7YTNRdAbLwR8Vgv0eEBrYiLL7QG2CQuxi6bI2pZDur2Mw1ZT1ea0" +
                                          "YESiNeVZvzeU2kp/vuKwdmKtTFJi6uNqSveb1LSlq4Y8rotRJC6IGJGcAcqP" +
                                          "9ZLRMGsbMDOZdEyurUx6XCsYgyrtTGO916aXqIiHaKMvxEFJD4JJukDDPo5W" +
                                          "46E7wKszb1ykKae9DAv6QPe8Fd/sUMamSzq2U57L65Yg0JaJKvoCaTD0ZFlZ" +
                                          "dqTKFJM2qsMP0kYhtKNVcdMS6Om4kngdVHfKUw9pNJa+OWuOXBteBkNxMWpH" +
                                          "iVCJLI9JEUprtNLxiKMCdt1OELJfkitLFZ2OpSrFNdNYn+kjctA35vNNGk74" +
                                          "GV8xRgjLTPqUh3jxUB/4fkElon6FqDMjtDzpcl0NbF96nryRKF5wWEKylwVi" +
                                          "6TvoSK+uQsfp0K5eb7ZFyjNZZoPN/BUmx00ZXnoKTba5QY+aNGBOI7x5m/DG" +
                                          "vXC9XrUUlhhGOmonlo3PSqsutWIoB1xWPG/PcL+c4pX6ulLrOkskKNbToVvm" +
                                          "u9zaCSqaiEjgkJI0yqS4YAVjWTKr3TBslvgyLqEC4ztEjylOFom+nrgYVpA5" +
                                          "xi/gOJNEG4cZ9yxCahbpFYk1W7O5Me5NpsMpJc43JtKdOmyjz/UKPTOROb/e" +
                                          "UqlKMMAGeCr1BUfrMLw47QarMQmv+Ikw71Cx6DXdiVwVsanKVYMUBbwpi5JQ" +
                                          "q16v1gwGK6FVhoZtFDHN1aA59YLYb2l9b11so3jDM7l6BDto2e0UAgeVOH3q" +
                                          "txpy2KZT0nVGQqHCzOqtZYguUKXHmoKNTXDSJvw+VfXrSqNOMdzcN1IsqY0n" +
                                          "uhshC10jrWZH0j1S18WS0udGvTDtduVksO6bJaE0SNZlrkG4VC0N7QJVL3Co" +
                                          "0yc1YkOlKIdOW0hK10cs70ajhmBRVK+DEUQP1J2yHIMEcsSpQsl6QcbRAVEi" +
                                          "2JLklGCiN6hHo8lg2MBa2oCewXB1gVX7Fk60W+NiIaBrhtY3QRk0N9P12LIr" +
                                          "Wpudh6kHwrKo2smwvSnpE8eoNxvh1Krpzb4yZimYmPXIOMCxCqhpCFKKa9QS" +
                                          "9dpxiygWUbFsFF2OG/U7lDzZWPamLpatOVfUVqVqZ5jAZKO27LQ2zCa2NKXW" +
                                          "r6nrGczVGGtB0ygi1xi3zJEt3ITxVoRMZquoUyfMGAkKVWvhFrBeeY0wcWAi" +
                                          "vZ4aVjcJvHFbeLOtwZo4SJoJ5klYa4SYgWYXyeWwszRtk3fqYcwOXLutSQyM" +
                                          "FMa1tszSC57mdWTQmxotUBqMykpW6r690WeL0oLtNe1KGyngQbVhitOORPai" +
                                          "ui66k4pdjDl+Opri7pBFC/2Ru6iOxLmyVOCCXlnCMlyRI3oFOxtUD6uwsrGb" +
                                          "82EwMoac05sFLidJozZSL9kFAWb8EoqHPFtpjkd9stcsuPKE11pJnoAiqB7R" +
                                          "IpZ0zgg7yNgJK10S4cNgpCQ+WQlnG37cagrxgnQJejnyehJJLBPRZBqY6pM8" +
                                          "j+hGNzWaotkKql4sFZrYGlsgis7xSs+2jNVorMxWgdbtxJuOn2j9KEAjz/V4" +
                                          "d9RAjVJ9jY2dCYLG9Xg2nDNhEatHKr6xDLyiExPMHHdppGLUy30xYSNSXGFp" +
                                          "VYnLtQLKVmcDhzdFvM41olYBLGI6KP1Lo79BCrEDN1Z6uTOauZRes4YNRsAb" +
                                          "QsUlakLTLhFD3tdUKYGnFXhEV0DELuN1ieed2Cp48ZJOCvPCajJma3LPBCWq" +
                                          "PgrIoTety0hVk8ezBt5mhdBsWK10Oic8byDpDVXQ2HWRmNclhWTpQpIktViW" +
                                          "YZWSSIAgk3Vy46vT9tDDlCk9V+3NUAgWk4WlFXpuL6ZCv2gmhKEPyqg1FlZz" +
                                          "uNrfYAhcxbXe0GiWGnNswzdHxQk3T6a9XhERRJU3S3JBYpJghakxyU+DFBnD" +
                                          "JOZYfgTMhClGqVtMyj12wC/CocIoqhsscR6Pqm1Od3SxR24UryBZzQYz4Utt" +
                                          "Wq0kCYUM4ZKAYw7SMUdVzvaKellqdUc41esLBMNReAMvo0IbNxq2lVSL5ZXS" +
                                          "WXrWYpLOgkFdlIwIHo20LmbI/oAzG3Bc0Aqkb2sKVcU6fcyXlmpQ7A+tfpyM" +
                                          "8BoHTl+ugMWleDhcoR1dmQ+rvqRbHXa+1nAKE/XVusXIHBqOikwwZEluCPtS" +
                                          "bYViY0G3HLimrxtcVK5iYPM9RmC7LEwHflCZDJCqbTH82g0Ukql6FSeeN6RF" +
                                          "AQigT9eVgNw0RWFekVDeag3LdoNgJQRt2pKFjVyvvUECVyUsYhlrRa8hyTTB" +
                                          "DkDMDtNi0RiLw0Y4F8FS6MpzArcG9UWRGzOeuhSCcVfkhCrfigrzqBIv5XA2" +
                                          "iaKUbM8cjGPdYTBeS3GiiRIPd5ejapzOYwY1Paq/SQR77UcqpfQlZ6I2eLkd" +
                                          "4DKM4Gu8QdIK71BJLGkVPqF4ulumpxJh68N6OSKYIl5ZqerA7ftzESFGfYed" +
                                          "G+vQbU8VvMVHa8OjVniPxXu0VGbW8DSiIho3VrI8bcQ4AydTxFv4zQVKjhNO" +
                                          "qLGBuy41ynDMjLHmJOAN3WYb8KLDWg5KK3G7CY84jrRFVuk6ZQcktRzKQVzk" +
                                          "/J47Ls16AwclGJULHaY3YQKYZCrVSnltVgaUvwlnRLIQC3I6YmhM8IrzhYl1" +
                                          "I6K8KimxH7uDGZ267T7Rayd0qdttJ9Oyj7GNBTyvCgMGEZppl/GWMrwJW+Wi" +
                                          "OwObDbivrAachMUeKifrgZ92x74damns1WRxuAb7kmaNs+gGDoTajFEepyWq" +
                                          "s8Y0eKMinlhg5+Me2KC/613Z1r3z2k5P9+SH3OMmKTg0ZS+Kr+HUkL4Swwi6" +
                                          "KEphFICjZQRdOu7abrnvdHn2jg7VO4dbKusqHbWQstPSQ7frj+Ynpc8+/dzz" +
                                          "yuBzpeyklBFrAIaR57/DVhPV3mG1Dyg9cftTYS9vD590br729L88yL3beDJv" +
                                          "XdzSUWKgyxnmMOvCH3fbHzkl52mSv9174Rutt8m/sg+dOe7j3NK4vhnp+s3d" +
                                          "m8uBGsVgNTzu4QTQY7ccJT1ZVeJAPeH7xJvFr9z46lPX9qGzu82tjMJDp1pF" +
                                          "d2he4Ih2xuCoU345MgJvdTKz2zcCZs0bdyi4rh22UvP/7O3r/Gx8fXoSU7cE" +
                                          "y/5xdI4PQyOA3nYSCaRn26qcW/0a7zr5CV+U7Ly/+F9X3lr6yr8+e3V7/rXB" +
                                          "zJEb3v7qBE7mf6YOffCb7/+Ph3Mye3L27eGkCXMCtm1ov+6EMhEE4jqTI/3Q" +
                                          "Xzz0G18TP3MG2utAZ8FmUM07zHs3h3f5NfVP8wzIDWLkBOR81PMM3DZKs+f8" +
                                          "U8CNCLpLzpHYSAwidfuB4z07yUtG0NnEM5WTrH7y1XoBu5zyiffd7O4KuJ44" +
                                          "dPcT/yd336zdodGyRzMHWL+C+h/IBlBdrmzVzxp2tgoMkE27J8rGr0XZNIIe" +
                                          "vH07OwuBB275orb9CiR/8fkrF+9/nv+rPMmOv9RcYqCLWmzbux3YnfvzfqBq" +
                                          "W1UvbfPKz/+eBnLcPmIi6Fz+n4v/oS3GhyPo9S+HEUFnwLgL+UwEXT0NCSjm" +
                                          "/7twH4ugyydwEXR+e7ML8iygDkCy249nTeGdansYOLkL7n01Fxyj7HZ1swqd" +
                                          "f+U8qqbx9jvnDflLz9P9D7xU+dy2qyzb4maTUbnIQBe25eu4Ij96W2pHtM63" +
                                          "H//J3V++9Naj1ePurcAnQbwj2yMvX1gox4/yUrD5g/t/752/+fx3887m/wI2" +
                                          "lVeDfh4AAA==");
}
