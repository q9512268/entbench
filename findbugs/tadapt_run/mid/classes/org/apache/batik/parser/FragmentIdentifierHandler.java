package org.apache.batik.parser;
public interface FragmentIdentifierHandler extends org.apache.batik.parser.PreserveAspectRatioHandler, org.apache.batik.parser.TransformListHandler {
    void startFragmentIdentifier() throws org.apache.batik.parser.ParseException;
    void idReference(java.lang.String s) throws org.apache.batik.parser.ParseException;
    void viewBox(float x, float y, float width, float height) throws org.apache.batik.parser.ParseException;
    void startViewTarget() throws org.apache.batik.parser.ParseException;
    void viewTarget(java.lang.String name) throws org.apache.batik.parser.ParseException;
    void endViewTarget() throws org.apache.batik.parser.ParseException;
    void zoomAndPan(boolean magnify);
    void endFragmentIdentifier() throws org.apache.batik.parser.ParseException;
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1445630120000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMUYa2wUx3nu/DYGPwiGQDAvgwohd6VNmiKTJsZgbOcMBjtI" +
                                          "mDbnud0538Le7jI7Z5+dEpJUaRCVaBrIow/40RKlrRIStYkapQoialSS0jYK" +
                                          "jdo82qRVf6QvpPCntKJt+n0zu3d7ax9uVUc9aed2Z77vm+/9fTNPXiRVLicr" +
                                          "HWrpNCYmHObGBvB9gHKX6V0mdd0hmE1qR3537NDlX9TdGyXVw2Rehrr9GnVZ" +
                                          "t8FM3R0mSw3LFdTSmLudMR0xBjhzGR+jwrCtYbLAcHuzjmlohui3dYYAuylP" +
                                          "kGYqBDdSOcF6PQKCLEtIbuKSm3hnGKAjQRo025koIiwuQegKrCFstrifK0hT" +
                                          "Yh8do/GcMMx4wnBFR56T6x3bnBg1bRFjeRHbZ97kKaIvcdMUNax8pvGvVx7M" +
                                          "NEk1zKeWZQsporuLubY5xvQEaSzObjVZ1j1A7iYVCTInACxIe8LfNA6bxmFT" +
                                          "X94iFHA/l1m5bJctxRE+pWpHQ4YEWVFKxKGcZj0yA5JnoFArPNklMki7vCCt" +
                                          "b+6QiA9fHz/+6J1N36sgjcOk0bAGkR0NmBCwyTAolGVTjLudus70YdJsgcEH" +
                                          "GTeoaUx61m5xjVGLihy4gK8WnMw5jMs9i7oCS4JsPKcJmxfES0un8r6q0iYd" +
                                          "BVlbi7IqCbtxHgSsN4Axnqbgex5K5X7D0qUflWIUZGy/HQAAtSbLRMYubFVp" +
                                          "UZggLcpFTGqNxgfB+axRAK2ywQW59LUyRFHXDtX201GWFGRRGG5ALQFUnVQE" +
                                          "ogiyIAwmKYGVFoesFLDPxe2bjt5l9VhREgGedaaZyP8cQGoLIe1iacYZxIFC" +
                                          "bFiXeIS2vng4SggALwgBK5gffP7Sbevbzr6iYJZMA7MjtY9pIqmdSs17/bqu" +
                                          "tRsrkI1ax3YNNH6J5DLKBryVjrwDmaa1QBEXY/7i2V0/3nPPd9mfo6S+l1Rr" +
                                          "tpnLgh81a3bWMUzGtzGLcSqY3kvqmKV3yfVeUgPvCcNianZHOu0y0UsqTTlV" +
                                          "bctvUFEaSKCK6uHdsNK2/+5QkZHveYcQUgMPicBDifotxUEQHs/YWRanGrUM" +
                                          "y44PcBvlR4PKnMNceNdh1bHjKfD//TdsiN0cd+0cB4eM23w0TsErMkwtYoxC" +
                                          "Wox3czqaZZbo1WEwwOF5D5ADSWPoe87/Zdc86mL+eCQCZrounCRMiK8e29QZ" +
                                          "T2rHc5u3XjqdPK8cEIPG06IgG2DrmNo6JreOqa1jZbcmkYjc8RpkQTkFmHQ/" +
                                          "JAfIzg1rBz/XN3J4ZQV4ozNeiQbJy2hd4n8AYohVmRduGXROvPnzP34ySqLF" +
                                          "FNIYyP2DTHQE3BZptkgHbS7yMcQZA7jfPDZw7OGLD+yVTADEquk2bMexC9wV" +
                                          "cjDksvtfOfDWe++eeiNaYLxCQN7OpaAEClJLU5D0qCYEqStkLyXYNR/CLwLP" +
                                          "v/BBGXFCeWJLlxcOywvx4DgBdUTl+yJBPlHOCl5RZp2uA960C9O1ZwYfdX05" +
                                          "1CFOLTdt8yzaxUNC9S8tl6hkkj113/GT+o7HN6h00lIa/Fuhtj31y3/+NPbY" +
                                          "b1+dxpfqhO3cYLIxZgZkrIUtV0zpVvplHverflK7+cLlinceWtQgzd+Qgkal" +
                                          "2C20l3QLqtnhtsZ0KFfl+ga/dq4r3ymEWTh3358WD30mMyJZCNZ+pFUFZQsx" +
                                          "B7BiF6gvC6kyTPI7/U++um2N9lBUFitM/NMUuVKkjqBSYVPOoCpbKBbOzM1j" +
                                          "6xeK9LAuktq65fS55IsH26OkEqoXVGxBIcNCMWwLb15ScDr8yMOtakEJ6D3U" +
                                          "xCW/4taLDLfHizMyBTWrQABjyxhfCc8aLyXLf1xtdXBcqFKWhG+T4woc2lU0" +
                                          "4OtqHNZIsI+B56wpBjfUEBNiAC3SfocFxoakRFMmQ/f+R+PqDc/95WiTckoT" +
                                          "ZnwTrZ+ZQHH+2s3knvN3Xm6TZCIa9jDFBFQEU4VxfpFyJ+d0AvnI33th6VfP" +
                                          "0RNQYqGsucYkk5WKeMkPmdoixb5Vjl1YwORaxA/nNWUzAf5tzWvMQRYkqW4c" +
                                          "OgRZCHbnYmrCBibXXqVT5kYWUumY12vED7a8t/8bf3hKBX64MQkBs8PHj3wY" +
                                          "O3pc6Vt1b6umNFBBHNXBSbabpHHzMi9cZReJ0f3+0wd/+O2DD0Q97X1ckMox" +
                                          "29ABub2MaIF+PKk9+MYHc3d/cOaSZLS0oQ8Wl37qKN6acdiEvC0Ml7ce6mYA" +
                                          "7saz2z/bZJ69AhSHgaIG5dvdwaHM5ktKkQddVfP2Sz9qHXm9gkS7Sb1pU72b" +
                                          "YusMDRBEEnMzUKHzzq23qWgZr4WhSboKKTiI7zzoc8um9+atWUdI/5t8fuGz" +
                                          "m544+a6sYpLCjaWx2QZPzIvN2P8Um1f14ibJJzbkMdWQS6Tk9Ej4uU0CaDgM" +
                                          "CzLH0AuJCaf6JcpOHPaqqjv0n6kMJ/ZMp4db4Nno6WHjLOqhUkJVSvcM1Dw8" +
                                          "Qg/moIcIxdHTrZcPvFwzucVv3qdDUZC3u/2vvdDzflJWp1oskIWaECh9nXw0" +
                                          "kJf9QMO/vsD7doF53qZiivmw3Q/xoLav3nDi74e++OYOqCi9pDZnGQdyrFcv" +
                                          "rVU1bi4VYKp4alKVK8ARdkiCRNY5jpx1ioP8zs7kJxM4ZASpGTPY+GY7H/IR" +
                                          "Y3Z8ZDE8nZ6PdM6ijwSrwRdmEvV+HO6GbCVz/G6Qd4jyUSZCIh+aHZGXw9Pn" +
                                          "idw3++kBP0ckwJdnkvsrOBwRpH6snMhfmh2RF8Gz0xN550dk5a/PJO0JHB4R" +
                                          "eHukl7Xxo7MjcDs8ezyB98y+jeW3VT7z1KRs22TUmk4ZY3lJ+YmrqPI0Dt8E" +
                                          "v5i07WynpcNxIKSmb81eKIx4ahr5iPzi+Zn84gUcvi/IAvCLqf1dSPBn/3vB" +
                                          "84JcW/agjw3Hoil3j+q+TDt9srF24ck7fiWPGIU7rQaoTemcaQaqQrBCVDuc" +
                                          "pQ0pWYNqt1TCfwl62DJ9Lx7C5YuU4KyCfxk6jDA81DT5H4Q7B35ShANS6iUI" +
                                          "8hNBKgAEX89DOYqUXlYUdLtgJt0G7jdWlTSm8o7Xr6c5dcsLhf9k3/a7Ln3q" +
                                          "cXXdoZl0chKpzIEqqg5dhTPmirLUfFrVPWuvzHumbrXfIzcrhos+uiTgchDx" +
                                          "EQctuzh0fHHbC6eYt05tOvOzw9UXoMXdSyJUkPl7Azes6joRzkA56Ef3Jqbr" +
                                          "F+AELk9WHfW/H3ntb29HWmQ/SlSH0XY1jKR27Mw7A2nH+VqU1PWSKjgCsPww" +
                                          "qTfcLRPWLqaN8ZL2ozpl56zCdfA8dEOK7abUjKfQuYVZPCkLsnLqOWXqZQK0" +
                                          "6uOMb0bqSGZu6FSec5zgqtRsTuU51DT4VDLR7zjeTVDNp6XmHUcG3a9lpvs3" +
                                          "VlKlH8gZAAA=");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1445630120000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAAMU6eewjV3mzv91kN5tjN4EcBHKyRA0Ovxl7PGNb4bLHx9ie" +
                                          "sWd8jD3TwmZOezz36fHQVDRVS1QqSmmgVIL8UQW1oHCoKm3VijZVSwGBKoFo" +
                                          "Sy9AVaUeFIn80UOlLX0z/l372/1lhRJUS/P8/OZ73/vu773v+fnvQjcEPlRw" +
                                          "HXOzMJ1wV03C3ZWJ7YYbVw12exTGiH6gKoQpBsEEjF2WH/7MhX///vuXF3eg" +
                                          "GwXoVaJtO6EY6o4djNTAMWNVoaALh6MtU7WCELpIrcRYhKNQN2FKD8LHKejm" +
                                          "I1ND6BK1TwIMSIABCXBOAlw/hAKTblXtyCKyGaIdBh70U9ApCrrRlTPyQuih" +
                                          "K5G4oi9ae2iYnAOA4Vz2mwNM5ZMTH3rwgPctz1cx/MEC/MyvvPPib56GLgjQ" +
                                          "Bd0eZ+TIgIgQLCJAt1iqJal+UFcUVRGg221VVcaqr4umnuZ0C9Adgb6wxTDy" +
                                          "1QMhZYORq/r5moeSu0XOePMjOXT8A/Y0XTWV/V83aKa4ALzedcjrlsN2Ng4Y" +
                                          "PK8DwnxNlNX9KWcM3VZC6IHjMw54vNQHAGDqWUsNl87BUmdsEQxAd2x1Z4r2" +
                                          "Ah6Hvm4vAOgNTgRWCaF7T0SaydoVZUNcqJdD6J7jcMz2FYC6KRdENiWE7jwO" +
                                          "lmMCWrr3mJaO6Oe7gze/7102ae/kNCuqbGb0nwOT7j82aaRqqq/asrqdeMsb" +
                                          "qQ+Jd33u6R0IAsB3HgPewvzOT7749sfuf+GLW5jXXgNmKK1UObwsPyfd9tXX" +
                                          "EY/WTmdknHOdQM+UfwXnufkze28eT1zgeXcdYMxe7u6/fGH0p/y7P6F+Zwc6" +
                                          "34VulB0zsoAd3S47lqubqt9RbdUXQ1XpQjeptkLk77vQWdCndFvdjg41LVDD" +
                                          "LnTGzIdudPLfQEQaQJGJ6Czo67bm7PddMVzm/cSFIOgseKBT4BGh7ee+rAkh" +
                                          "H146lgqLsmjrtgMzvpPxnynUVkQ4VAPQV8Bb14ElYP/Gm4q7FThwIh8YJOz4" +
                                          "C1gEVrFUty8zHw1UH2774sJS7bCrgEYHBu+TAB3gdDezPff/ZdUkk8XF9alT" +
                                          "QE2vOx4kTOBfpGMqqn9ZfiZqtF781OUv7xw4zZ4UQ6gIlt7dLr2bL727XXr3" +
                                          "xKWhU6fyFV+dkbA1CqBSAwQHEDZveXT8jt4TTz98Glijuz6TKSTJvfWe/Mdp" +
                                          "MO/Rk0N5O4sj3Tx2ysC07/mvoSk99ff/mZN9NBpnCHeu4T7H5gvw8x+5l3jr" +
                                          "d/L5N4HAFYrA0EBMuP+4E1/hd5k3HxcniMeHeEufsP5t5+EbP78DnRWgi/Je" +
                                          "sOdEM1LHKgi45/VgPwOAhHDF+yuD1dYzH98LCiH0uuN0HVn28f3ImjF/w1E1" +
                                          "gn4GnfXP5yZxWw5z+w/A5xR4/jd7Mk1kA1sXuYPY89MHDxzVdZNTp0LohtJu" +
                                          "ZRfJ5j+U6fi4gDMC3jJ2P/qNP/tndAfaOYz2F47kTyCEx49EmAzZhTyW3H5o" +
                                          "MhNfzYT1dx9mfvmD333Pj+f2AiBef60FL2VtRjFIlyDt/OwXvb/61jef+/rO" +
                                          "gY2dDkGKjSRTl0EnyLMf4ETTbdHMBfJwCN29MuVL+1xzIBsCwi6tzEouqjtB" +
                                          "/s9Jy7Syu00huW8Bii6dYK5H0v5l+f1f/96t3Pf+4MWrLPVKwdCi+/hWQzlV" +
                                          "CUB/93EvIsVgCeDKLwx+4qL5wvcBRgFglEGUCIY+8ObkCjHuQd9w9q//6I/v" +
                                          "euKrp6GdNnTedESlLWYZGsTZcAmS+hIEgsR929u3cXJ9DjQXc9+Ecv5fuyUn" +
                                          "d+vbDgVBOSCTvvcf3v+VX3z9twAdPeiGOLNhQMERaQ2ibHPxc89/8L6bn/n2" +
                                          "e3OdgKjMfKh18e0Z1mq+wBvy9seyprDVWNZ9LGvelDW7+2q6N1PTOI+KlBiE" +
                                          "tKNkoUfJNfWSoYPxdQtYW7yXOeEn7/iW8ZF/+uQ2Kx6PE8eA1aef+fkf7L7v" +
                                          "mZ0je5HXX7UdODpnux/Jib71QJUPvdQq+Yz2P376yd//jSffs6Xqjiszawts" +
                                          "HD/5F//zld0Pf/tL1wjUZ0xn3yiztrS3bPaFXV+x4a2PkeWgW9//0FNeLK2n" +
                                          "CWpHcJPvMGu9wzbr8WLtLBWcG1h6f9ILhIU0lOnGKuxaTcmOFARDq5RaWXUr" +
                                          "AlZQWm5vKo4ITmz4XWcNl5FR3/RH3XHIG6LLOmB7OR4jK76/UpxqyRtxGs7G" +
                                          "LkPYYb8XFmwkjVClIia1iJvKNVFVSkKlElsFuKZNBsxcH3GULvvkzHcHBG+R" +
                                          "Q6nTiBu1Bdmf4xxiKQqytFpFb4RiaGXQNOe1idLZzLl1aaQufb/WsTkhrLZp" +
                                          "dIRY4zVKtZXJ2KIihR4hSWO1TDujwmrtEyEvUXWZjNKVZTrLSEcVnq9HG5Mx" +
                                          "OrzXaCrjodzGGbZPUK2wK0X9sYUu7U6/vmJHDlLCDKerryNWXfR9og02xbrW" +
                                          "R5YTfllVHLgj03RSXtuN9gjDJ3iCSnZjUZRG7ZU6IiWhVjH6YjeWFXo6EJOq" +
                                          "G3diLqnQg5ZRTPvqTGAD1/EjKpJ4LInZljhOQa7ghOKqWK/oPEdMunadSLpq" +
                                          "ldIGdVxKrPZkXivrbbIOm0ULk3pymIxaBXfmkmyZb824dj/pd2RhhWzqWM92" +
                                          "2nWfGRgmbeiVmCBCqYCzer2mkSlcwHvFAYoHi5U8NBCp3jFGyMBqEOvNpO6Y" +
                                          "HW6yAnKMggrCK71gIbfIzkR1xGmCg2WTFdeh9OWmvOhXZza9xlZ0UNMrDjEu" +
                                          "9wKmL/esRGuNkciu+riH6LzS4ExJr3Q9QgoTcjEOBuV6YnvSQk2wPjavNBFv" +
                                          "qpmz7lTobGCSrdfDsUSNaD6S2pw7FRYLSnbbk443SBZaoyAmo3q/tFmzM6xG" +
                                          "TTejNjlvhvMSUuzM2p3RqNPB6hTbntoc23IW+qZbX1t9vsO1HTVoU00mUUvS" +
                                          "KsTMGrcctRYdVRFFYcNUZbbjUF21qIsyLyTdNiG19bnaHZdie1EeLxZ1ar1o" +
                                          "9LGFpjGVsaTGUurjOt8T6HqFXoV8ze16ljIOihVY8qJwFPhGtygmKD8YkHgP" +
                                          "a1L9hr/hVv66aYlikW205jxc0UscAqM2wyg1S3PwccEsjvzQtanFsloUUWlG" +
                                          "T9NOmHYoeezxqBF7Vp9DNxqnThdMTMgDXbQFchghG2QaeJOJyUlyGE/bwIz6" +
                                          "RB+PSCUY9EtwAWMNgYxVXmanC5rR5UZT15wwmbZYMoD52Ui0O/6U3pTLjNyI" +
                                          "zVGZ6dv0QFYHyrIokau+1oThiRLoA0RWCojcKKt0CV0jk6Dl08Y65J2EmDkJ" +
                                          "KqeeKAiSU5y11uthG2ti9eZ4xjhqtQILilzFLaqgEiwh+E5kEyNa71fVUo0V" +
                                          "JiWflLEIna88helX5VaX6SB4d9EpNX1r4OA9Xx16YnElSLJl8Cu5OnINdmK0" +
                                          "LZKFe3Wtmy6KfiOF5wO0VxZYruykA1Vnpd6mtFTKdrXOO0vOGilRZz4axoyd" +
                                          "Mmh5M/aodnvQ5TdMqTkh2RbaENzQWJDSuLKhZVaoV1Ya0xTWlWGHahY23KTe" +
                                          "bHmRUZJoNSFqa05eNY0gDrWh1pyphYKq6gORpxKCHVSGrlhvEWaPmmLArAm+" +
                                          "5Y1Dg9rM+cEIJqg1xcRwo9GZtwl11qPMRB5u1nFSbi4aynRiFja9BmOSQ8LE" +
                                          "RoJbiuo1HCFqw6Kw5jVljmBFoj2kJkpY3aRiMh0QtXE1NPGlYayKRRTuTApO" +
                                          "hRzgSwQxuyLcjpbhCi1uULgwYCReKhbA3kDzlkNU5qluIiwEw+9OQw5JXS52" +
                                          "TWAhvmb2KwWZAuc0WZ2F7CJVCuzCEM0SUUJMlKW80F6GgYD025pZWIiw4pV9" +
                                          "dGO1ZpMlimLVWRNFLHrTE4iBUHDb0zaIb0mj0tDb+CImcGMzYboVeFooRFZp" +
                                          "UDMb07Ye0vCAnkZc31h5jTHPMUOHcKV+QxqmdHGFJ2q/RtUjI/RwTBtjWDcg" +
                                          "S/jQaHnOnOskja48IOjZmpKK2Fhu+tUNPQxFo9XDm+gUWCVcDkWqSWmkntKb" +
                                          "xmTms/XGapMsNUKuikAnlFZMQmXekL12f7bsFCbltSOXzClSHoYeORC6QbfQ" +
                                          "wPC121hp01ZjoNcJdKw5cjtxRGPUpi0W1gqjAuM1ZbiGzfSJbDgTwV5PfKEg" +
                                          "sCRZKAWoYccDdG7hE4HoirVVs91os61pmUs0t73pFRSkHttdFA2XOKcxyGjA" +
                                          "8l4niGTeMLBZX6UNxlIcPZEwbmUW+fVwJCZ12B7Mpmldw8J0FtPsiDe8WVke" +
                                          "LkYCQUo2b/lEQ5fmc4+bYAY/m0YWXyzFrWZFrIZwVdLQZb8xx8s0azSCKkOu" +
                                          "0DU/RF0Z58KihEfWoN1okIN5YyyJkkuSKa3XZGGk9hANLSBrBS4MS80mwtYq" +
                                          "86Js0E5SqtUbkVSixW67wPSNWoHmSRlVYHkojgVqjDhsdWaiFa8/wEVZ0Vsx" +
                                          "gdBmRVZxi69XAjEtpbAk9PBafTkmF2K3gymxshZJGjPCvsEqChBLaZzWPHJu" +
                                          "1RbGGATfojutlCQ+CujmqNFq2XQ67ZNp6pVQb7YQ/PJsOZacfn+idytp6sjV" +
                                          "yKoVxHA2VbowFla1qJNaWLlcEPGAdyliJc6SEiswaTcelJjq1CpqxbIu9Xqp" +
                                          "ZNDKjB3jE6PWWpWjKUKIzQVNpBSJ1KMeIWp4T3aHJCN63ipGbNyge7BAu2VF" +
                                          "Kg9sB5+RK2roLadGjxvHMl1srqvsAracrtxNFBLYiMzE7XUayVyMekpzKhBo" +
                                          "BJfiWGmmmtmbuUUnMLozsUUsa/Z8jRg9rcbSQzgOmhXFaWOoJ+h6bK1RFk4c" +
                                          "SoxRu6lXyiAaDfmhR+g1tynYHVbZ+G059rlpUdLLHN93y6LZ5/rV+kgxdGI0" +
                                          "4LGVmxR1h6mmQcXoJXRZqI/dzoThCx2+QsLdEY8KVaHZqtoCzig0rq/WY389" +
                                          "UqxWzBXIId6RCC6FOzirlFeb6RhY+bIgkkJnvq4xtq6s0ULBaDCIbKx7im3E" +
                                          "gT9srEcuiQc2vdSsZWnUrnZSJBlgGKIYmAgzvSHSIxvlkUpGhlmZJw7Ir3Iz" +
                                          "qKrpplGrbgordYZyk0pa7I+CUmkytYyywKNmrwAM32O6SDOstmJMRyqzje3K" +
                                          "g6QLtnNStaj2u0lZXPqYzqR6QbCr5cVUjnW4W48JytOKyphp2DAaN6rlnjyD" +
                                          "xcVqjZKObqKrgleYNMNa4LdLZdmoaPqM6XSnFZ8VnYlqySIreqzfILhmJLss" +
                                          "4s74gRcWJ4S2NvFSs1ejkgqB8dG03N8QWmLgq2a9WmxOMLLMVhooNl7WB2Nc" +
                                          "n3ary0Gjv6i35tVac8h707nJTxUqXPRCpFNZKTMTbG2rTmXu4zKmyAG11GoG" +
                                          "CosVykY9eT5XHMFE5GXfTbstz1tgynLCWLpPTbW2zzGzKE5JcILz5yBhyv7S" +
                                          "CQqRPlnIy2bSYuUwSpeIRpISgat8iGDhMB6m69p07tBzZbzpTQ3GrNRTNcBX" +
                                          "zig16hje0tCeJ/ntQr1FGbUZqc1gErVDqVQjZyAqjs0xicz54qo/KlXodaVe" +
                                          "sskC502LzGzcXy2IgFmvvYkmUyNmRnnioCpQJSd1TQxPCUWrV5XWsF8RpSnY" +
                                          "fLARzwkMYVCBTXnD2dwT2D6CR0NaQiRv3BEivD1WZSxdeGDTNYmmGJBtmWtS" +
                                          "o0q6Uidcc+Dic4ucyh1UrJluHKCc2TfJ6kIAp6O3ZMem7g93cr09LzAcFKzB" +
                                          "gTV7gfwQJ7bkpRYMoXOiBM4Y4FgfQjcdVNC3qx+psO3sFzRKJxX2GF8FX7Fa" +
                                          "D1xVDkdZnWKvsrc/9bGTpk580Q40x7eyUt/epOzke99Jte/81PvcU888qww/" +
                                          "VsxOvdkKTcBA6LhvMtVYNY+Qfg5geuPJJ3w6L/0fVuG+8NS/3Dt56/KJvAx1" +
                                          "VXWQgs5nM5nshuXgJuWBY3QeR/lx+vkvdR6RP7ADnT6oyV11KXHlpMevrMSd" +
                                          "99Uw8u3JQT3Ohx6+qizgyKoS+erhum98UPzs5c89eWkHOnO0UJlhuO9Y2e/m" +
                                          "TPyimS2wfwtyPlz6zvpw5GgNEIg1L8I+DJ5H9srk+Xf29lVu1r46ObTRq4xv" +
                                          "58DaR3um5kOPHJafCMc0gRFlUr80ta28WiNKpprZx39feEPxs//6vovbWoYJ" +
                                          "RvbV8Nj1ERyOv6YBvfvL7/yP+3M0p+TsXumwoHYItr2seNUh5rrvi5uMjuSn" +
                                          "v3bfr35B/Ohp6FQXOhPoqZrfHkB71emMqFXO9lZ8enapkL87te8Pj5zoStlX" +
                                          "K5FVNyMhR5Vf7YghdDfQrR9eXUTPcb7tSCggQuhM7OjKYYyQrlfV0Y+Qnw+8" +
                                          "40pl3w+e3T1l774sZV9TLHlcywHedTKAlQM8mTVxCN2sKwcl9mzIPeR2/XK5" +
                                          "fQt4anvc1l5Bbs/kUGeupTDgkY6Ym/PTh02O5D3Xk8gvZM1TIXQ21tV1w0mO" +
                                          "SeNnXq407gVPfU8a9VdQGkfd5UPXY/LDWfNLIXQhdwIOcDoR/YUaHmP2Ay+X" +
                                          "2QfB09tjtvejNPRfux7Hz2XNR0PofHwSs8++XGbvAQ+7xyz7I9Lsp67H52ey" +
                                          "5uNh9jcH5US9fuLlsnoJPPweq/wrr9drufRZyXFMVdwG8d97CRH9YdZ8Fmg6" +
                                          "dRyrbiuMaB9j/7dfCbN+Yo/9J35Emv7S9TT95az5kxC6E2j66jR2jOXP/zAs" +
                                          "JyH0mhNvl7Msfs9Vf3jZ/klD/tSzF87d/ez0L/N90sEfKW6ioHNaZJpHL0SP" +
                                          "9G90fVXTc55u2m6N3PzrayBJn5DYs+vEvJPT/tUt/J+H0MXj8CAV5N9H4b4B" +
                                          "bOMQDqDado6C/E0InQYgWfdvs3vXI5vgPYvIpXrH9aR6MOXoxWm2cc7/WLS/" +
                                          "yY22fy26LH/62d7gXS/iH9te3MqmmKYZlnMUdHa7qzzYKD90IrZ9XDeSj37/" +
                                          "ts/c9Ib9Tf1tW4IPrfMIbQ9ce7/Xstww36Glv3v3b73515/9Zn55+H9CcYDX" +
                                          "8SUAAA==");
}
