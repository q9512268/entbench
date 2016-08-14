package org.apache.batik.gvt.font;
public class KerningTable {
    private org.apache.batik.gvt.font.Kern[] entries;
    public KerningTable(org.apache.batik.gvt.font.Kern[] entries) { super(
                                                                      );
                                                                    this.
                                                                      entries =
                                                                      entries;
    }
    public float getKerningValue(int glyphCode1, int glyphCode2, java.lang.String glyphUnicode1,
                                 java.lang.String glyphUnicode2) {
        for (int i =
               0;
             i <
               entries.
                 length;
             i++) {
            if (entries[i].
                  matchesFirstGlyph(
                    glyphCode1,
                    glyphUnicode1) &&
                  entries[i].
                  matchesSecondGlyph(
                    glyphCode2,
                    glyphUnicode2)) {
                return entries[i].
                  getAdjustValue(
                    );
            }
        }
        return 0.0F;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wUxxmfOz/xAz94P2yMbWh55DakoYWakoBjg8kZTthY" +
                                                              "ikk49vbm7hbv7S67c/bZqfNAiqCVgigxhFSJ/ykEgghEtFFbtUmpokKipJFC" +
                                                              "aNM0CvQRtbQUFVQ1rUqb9JuZ3dvHnU2jKifd3t7MN9/M9/p93zenrqMS00CN" +
                                                              "WCUhMqxjM9ShkohomDjeroim2QtjUenpIvFvO65uXh1Epf1oako0uyXRxJ0y" +
                                                              "VuJmP2qQVZOIqoTNzRjH6YqIgU1sDIpE1tR+NEM2u9K6Iksy6dbimBL0iUYY" +
                                                              "1YmEGHIsQ3CXxYCghjCcRGAnEdb5p9vCqErS9GGHfLaLvN01QynTzl4mQbXh" +
                                                              "XeKgKGSIrAhh2SRtWQMt0zVlOKloJISzJLRLWWmpYFN4ZZ4Kml+q+fjWgVQt" +
                                                              "U8E0UVU1wsQzt2JTUwZxPIxqnNEOBafN3egRVBRGlS5iglrD9qYCbCrApra0" +
                                                              "DhWcvhqrmXS7xsQhNqdSXaIHImihl4kuGmLaYhNhZwYO5cSSnS0GaZty0nIp" +
                                                              "80Q8tEwYe3pH7dkiVNOPamS1hx5HgkMQ2KQfFIrTMWyY6+JxHO9HdSoYuwcb" +
                                                              "sqjII5al6005qYokA+a31UIHMzo22J6OrsCOIJuRkYhm5MRLMIey/pUkFDEJ" +
                                                              "ss50ZOUSdtJxELBChoMZCRH8zlpSPCCrcYIW+FfkZGy9HwhgaVkak5SW26pY" +
                                                              "FWEA1XMXUUQ1KfSA66lJIC3RwAENguZOyJTqWhelATGJo9QjfXQRPgVUU5gi" +
                                                              "6BKCZvjJGCew0lyflVz2ub55zf6H1Y1qEAXgzHEsKfT8lbCo0bdoK05gA0Mc" +
                                                              "8IVVS8OHxZmv7AsiBMQzfMSc5vtfv3nv8sZzr3OaeQVotsR2YYlEpaOxqe/M" +
                                                              "b1+yuogeo1zXTJka3yM5i7KINdOW1QFhZuY40smQPXlu6/kHHjuJrwVRRRcq" +
                                                              "lTQlkwY/qpO0tC4r2NiAVWyIBMe70BSsxtvZfBcqg/ewrGI+uiWRMDHpQsUK" +
                                                              "GyrV2H9QUQJYUBVVwLusJjT7XRdJir1ndYRQGXxRFXwbEf+wX4IeEFJaGgui" +
                                                              "JKqyqgkRQ6PymwIgTgx0mxJi4PUDgqllDHBBQTOSggh+kMLWRHKQCAlQjHA/" +
                                                              "NoBDsleMKThEXUz/PJlnqWTThgIBUPp8f8grEC0bNSWOjag0llnfcfN09E3u" +
                                                              "TjQELJ0QtBj2C/H9Qmy/EOwXovuF3PuhQIBtM53uy+0KVhmA+AaArVrS89Cm" +
                                                              "nfuai8Ch9KFiUCklbfYkmnYHBGzkjkpn6qtHFl5e8VoQFYdRvSiRjKjQvLHO" +
                                                              "SAIiSQNW0FbFIAU5maDJlQloCjM0CccBiCbKCBaXcm0QG3ScoOkuDnaeohEp" +
                                                              "TJwlCp4fnTsy9Hjfo3cGUdAL/nTLEsAtujxCITsHza3+oC/Et2bv1Y/PHB7V" +
                                                              "nPD3ZBM7CeatpDI0+x3Br56otLRJfDn6ymgrU/sUgGciQjgB8jX69/CgS5uN" +
                                                              "1FSWchA4oRlpUaFTto4rSMrQhpwR5qF17H06uEUlDbdZ8P2iFX/sl87O1Olz" +
                                                              "Fvdo6mc+KVgm+FqP/tyv3v7Tl5i67aRR48r2PZi0uYCKMqtnkFTnuG2vgTHQ" +
                                                              "fXgk8tSh63u3M58FipZCG7bSZzsAFJgQ1PzE67vfv3L56KWg4+cEMnUmBgVP" +
                                                              "NickHUcVkwgJuy12zgNApwAeUK9p3aaCf8oJmUYcDax/1yxa8fJf9tdyP1Bg" +
                                                              "xHaj5bdn4IzPWY8ee3PHPxoZm4BEE62jM4eMo/c0h/M6wxCH6Tmyj19seOaC" +
                                                              "+BzkAcBeUx7BDE4DuVh3FZU0nnoyMZOw1TzjPFh5/ifmd/5wlmec5gLEvjR2" +
                                                              "4ni59EH6/Ed8wZwCCzjdjBPCk33v7XqLeUQ5hQk6TpVU7QIBgBOXO9bmLFVu" +
                                                              "p4NDlqUO8XSw7f9E7Jghx5NY6OnbsKGvt5NCqZUKPh/GWTDAoomRy2WH8edb" +
                                                              "3n50vOW34Aj9qFw2AR1BNwVKEdeaG6euXLtY3XCagUUxVbGlXm8Nl1+ieSov" +
                                                              "pvka+vgqj5TZgDaTpx5GdrfHzeZ7UgprShxUO/nuV35x/FuHh7jPLJlYIb51" +
                                                              "s/+1RYnt+d0/WXTkgXiBksu3vl849ezc9rXX2HoHTenq1mx+YgadO2vvOpn+" +
                                                              "e7C59GdBVNaPaiWrCegTlQzFqH7Qqml3BtAoeOa9RSyv2Npy2WK+H8ld2/px" +
                                                              "3CkI4J3Y8cOhm1ssgBhydbEVX2DPpfRxB7NMkL6GCDCVVVGxgPBT+ATg+wn9" +
                                                              "0rCiAzy86tutkq8pV/PpEBylClaTJGVOaruIIacB2wctnBBG668MPHv1RW5z" +
                                                              "v6F8xHjf2Dc/De0f42jKG4iWvBrevYY3ERw16KObhtrCyXZhKzr/eGb0RydG" +
                                                              "9/JT1XvL4Q7o9l785X/eCh35zRsF6rEiiCP65x49mwuAIFezHTccoanZoWXQ" +
                                                              "VEzB3p7j9ZmshXLtGkxmC4RSgyeUulmoOn754dSDv/9ha3L9ZynM6FjjbUov" +
                                                              "+n8B6GTpxBb2H+XCnj/P7V2b2vkZaqwFPgv5Wb7QfeqNDYulg0HWEfKAyesk" +
                                                              "vYvavGFSYWBofdVeT7C08GBh1uORQh/LmOOw/3fm7ICYHRCjxZPMJekjBqEl" +
                                                              "UUNzv5iEfFfeKM3oCwrXCh1pnbDsPvKDWd9bc3z8Mitr9Cwq4C3TvRmYx9N9" +
                                                              "36j58YH6ok5wki5UnlHl3RncFfcqqszMxFwp2emLHbVZkUXxgaDAUjgBG145" +
                                                              "iZxscJHprqa9fuS6YYlKBy7dqO678erNPID3Fo/dot7mgN5iGuqz/N3ORtFM" +
                                                              "Ad3d5zY/WKucu8XyaKUoQdIztxjQamU9paZFXVL265++NnPnO0Uo2IkqFE2M" +
                                                              "d4qsakdToFzGZgq6tKx+z728BhmiVUktExXlCZ9vXzqQtrBinmUv+t6eq3Jo" +
                                                              "gYPmwbfJqnKa/EW3Be+jheEdatwy3ZAHAad9RW7lJEwJ7dyJIXPvXs3revpk" +
                                                              "6PYI5zRUSOisK3Zy+7FPKfJ17u6i2lEAoqZrmOhyhSH00T1j4/Etx1YELYfa" +
                                                              "RsAWmn6HggexkqfLHblj1NmirrKOscqvS0dQnwS5tmCipT5/L2YHKDYL18u+" +
                                                              "1HZXZKe0rzXykS3PKh5T9NnjD2f6V2dTY3bWqHUyCr8No+OHGc3BScLwGfp4" +
                                                              "EqIoiYl1WcBKE0b8lJUw6U/E9d5LCwUIAlL4XI6P7J/ER/73wCCoyn2PQfFw" +
                                                              "dt7tKL/Rk06P15TPGt/2Hi917Vu3KshfiYyiuKsk13upbuCEzPRRxeGDK/d5" +
                                                              "guZMWOASVEx/2KmPcfoXIHkXooeSAJ5uylNgMD8lKJX9uunOEFTh0EGBxV/c" +
                                                              "JGeBO5DQ1+/qBbyBl5XZgDe6ciaacTsTuQKyxQPV7B7bduoMv8mOSmfGN21+" +
                                                              "+OaXj/EGX1LEkRHKpRLyCL9ryKX4hRNys3mVblxya+pLUxbZIVHHD+zE5zyX" +
                                                              "J6fB/3TqG3N93a/ZmmuC3z+65tWf7yu9CKC/HQVEqMO25xfgWT0D2LM9nJ8v" +
                                                              "oRxibXnbkm8Pr12e+OsHLN2ivMbGTx+VLh1/6N2Ds49C+17ZhUoAvXCWdQb3" +
                                                              "DatbsTRo9KNq2ezIwhGBCxR9nmQ8lbqxSGOa6cVSZ3VulF4PEdScXwbnX6pB" +
                                                              "6hrCxnoto8atdF7pjHgu2K3QqMjoum+BM+LqCzUOD9Qa4I/RcLeu291CySc6" +
                                                              "i2R9YhQ7z17p48J/AcI/z1TjGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6bteMj/6nU9tE5KTijoBrLzvmV/98e4Hntk5kgY+ek0mdnTMNhXMJXF7VjyV" +
       "Auoevtks+YjWP33m6T/+3affu6XqruNJDQly9k/95X99dffZb3/5OqvqaeBB" +
       "2UfZSw+semcr5n1n2IaGTO0g8XMdJYsy+33bVdZwdw+SbtCZXsc/nrixjAe5" +
       "xx4a6Rff/S/3Td6kv+2nWF4fPCGjkyh/b/DCl9uvk359Bzp9YLLXZOTHBz15" +
       "3FAvBgrYQjiTY+Z6/9Zcc/ltbTUrHstVl38/cSAJKJcElMNOb9I3z4oJMG4p" +
       "E/VWMzcBf0u6fcM3gXlrVjwYHk1CjuvgyC7vqvTBb37/dv77f/LyNeHp+Jo7" +
       "ELwnD132ocxQ7zmZcVFCqAO4yovDt1y2XvxRHv9vFSQQrMNRANK99NgKvQd9" +
       "9vzf/umf3f22r5+GdlrQRcsV5JaQJzvQLSDLUEIdZIqp9+anthF8dWEvpEMp" +
       "dA3zWzu8N/86k9erx9eC19xsLdgLQtr1gxBIAc57gZGAaJKL4ako2wCADdrW" +
       "NcrbjCYrr2aFvqVFvCHd1a2/nwJ4z5Z3q7vF7Nu9/tyn9wLguTDfDGdfb94n" +
       "4p6lJV3ZD3g82BkD1V1ZWtV9h7186Mzb7eQJQp/6XxMKNH7HIbK+C3am7//H" +
       "D3711x59CSi6C51NslUDqPjIjMM426z/8gsfvv/WZ779/jyfApLkf+VzyA8z" +
       "rOubsZsV4TFW78tYZfPNSF8Io0GeAinyAbfEEX7aEUik3P8Dt9Edz1OVsNPY" +
       "//X5uVJecWlqq6MNnDY29cq4vB6IUx1Fm4LpzqegwJdazVxMIn1umGalnoh2" +
       "VReTKotVJVhc+OqwYfgErxlaqrfYLrw2SU3TyajVEiPO9lyzZ3jdFiEMB0Ui" +
       "oZlIpLkWT5cCzhfr3XiByAnlcOVlz1BlJKoOhnV4UIe9OrJRnMAfsMUiMZwS" +
       "nD7w0+WgzuqmC7Z3zaUSuIZdpqMlpzheJ2klIwyNZ3qJ9NSSC4guxusZk3aL" +
       "az7u2uOyT/OLUcd3J8MNs6Swud/RuFLY7HhkKWIKQ3JQjus9rGOGa0wWDRvv" +
       "Fw1uPi/NbbJNdUIaIWbpnND0JSEx7YZDyiLq1RPCJwO23m5Tal/oJ8NiiV47" +
       "k41VsWlxps+UntZrs52goetllomm9CAqbnhr1LPcbofddPtMfzq1vXlrWFks" +
       "Kj3bKvgFdTnVeDriamSR47nSKqQ3Ubk74VaLdNxJfWdIjnBBHSKKxvA407ZY" +
       "1NCsoFn354RIBA0vEIpNfSoluh/YM7aahrQ+9GV2JnSojm3oVsWM23ZfmOtD" +
       "fbGaj1CJZR222BYW0brodLxaka5F5GquIB5VlU2DH47Ggs2W9BSlNHNAl3u0" +
       "2uoEk8F0PccK3ZQa1SmZdefxShJDf9npoIKFFYuoP3fNRkFASlyHGmzccrmL" +
       "jYKQGHW6MWPOdRsdMP1BR1nDHme2mmQ3DNHiYsSxctRNyT5O6O5gQTBUbWN5" +
       "7JggAmnemRZaqrlor+vUStcE3hRMlJ2WMSC+KdkozQYzjqNLPZVtYJjV7RAI" +
       "s2qQQy1ejNbdiT/VFasxaXfdOr1UZzQz1niOQzUDw3vEIll224SyKlpr1eI3" +
       "5VhE0Y2KUaV5yScbM21DkWFPndQskXCLouz2iqjWKA6kWofn2dqIShd2Um2E" +
       "Bj6gN+qAldAkUhPESWrhYhMgI0GheTcKmfJ8bpGeMEp9BR6IpcI6djXFLW1m" +
       "k64pIOsBalR7naE8mpbolr6I55ViaNPjmRVjsElRy7gbrHiGYSTfmtCWuZrD" +
       "vjcqRkQlKA+NBj9dd/CBUi3ibJhGyULFJV+DlVXQ7hRiY8oMmpRHh1yvvQ74" +
       "MlWnObo753CeX/XjsLucVGeM3DWCkiPPGbo9S5nWbCWSamE1q3QUstUV2lps" +
       "dHv+2tdMhsbGa3vV0SZaWrTTrlEZc03Nt6wmheP0ZMQC3y+Yg/6UoXo00bDo" +
       "JdWAhy7eDC1l0Jvo5IzbwOOu5fjTyUTXOjg39mpqTQtIoigO2eloKWhFy3JU" +
       "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" +
       "f/DGTzz3rfy87n8AGUoaZbQkAAA=");
}
