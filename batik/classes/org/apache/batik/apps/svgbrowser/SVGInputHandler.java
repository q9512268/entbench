package org.apache.batik.apps.svgbrowser;
public class SVGInputHandler implements org.apache.batik.apps.svgbrowser.SquiggleInputHandler {
    public static final java.lang.String[] SVG_MIME_TYPES = { "image/svg+xml" };
    public static final java.lang.String[] SVG_FILE_EXTENSIONS = { ".svg",
    ".svgz" };
    public java.lang.String[] getHandledMimeTypes() { return SVG_MIME_TYPES;
    }
    public java.lang.String[] getHandledExtensions() { return SVG_FILE_EXTENSIONS;
    }
    public java.lang.String getDescription() { return ""; }
    public void handle(org.apache.batik.util.ParsedURL purl, org.apache.batik.apps.svgbrowser.JSVGViewerFrame svgViewerFrame) {
        svgViewerFrame.
          getJSVGCanvas(
            ).
          loadSVGDocument(
            purl.
              toString(
                ));
    }
    public boolean accept(java.io.File f) { return f != null &&
                                              f.
                                              isFile(
                                                ) &&
                                              accept(
                                                f.
                                                  getPath(
                                                    )); }
    public boolean accept(org.apache.batik.util.ParsedURL purl) {
        if (purl ==
              null) {
            return false;
        }
        java.lang.String path =
          purl.
          getPath(
            );
        if (path ==
              null)
            return false;
        return accept(
                 path);
    }
    public boolean accept(java.lang.String path) { if (path ==
                                                         null)
                                                       return false;
                                                   for (int i =
                                                          0;
                                                        i <
                                                          SVG_FILE_EXTENSIONS.
                                                            length;
                                                        i++) {
                                                       if (path.
                                                             endsWith(
                                                               SVG_FILE_EXTENSIONS[i])) {
                                                           return true;
                                                       }
                                                   }
                                                   return false;
    }
    public SVGInputHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+JnBz/a+4jEFHbeDP+LT0v8CndTFacghAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mlPDngeak4kA3BfUxf2D57DlceiwePYQW545jy0XoPLmg2WTZ8ryelH8QGmT" +
       "e4rb94J4Tsq0MwUsWL7slqO8kEIPg9nl5mgw6t2cLvmeAAz4/J0NWAbLPq95" +
       "5R8999s/8spzf1j62/1WAsQkYvM2idapNt959Rvf+t23P/nFEp/vVeRkL/D5" +
       "DPXWBPRMXlly/tCxft5RqOOJArMO9XNhD0s3b4Wlv3EtyuTEirIg1d+7h7dr" +
       "e61cK3VybZ+dfujD10Zct3eTJUY94dr7r/n65rDmY7KnvPShg4ODD994IQz3" +
       "nv9O8HFSxlfhDgd7uuMguXA4BRfPN4pieGQt7vbWulhaqyh6Rxa65Oq+ma7u" +
       "Hlp8bHlgblgfZqbIS49+w/mZP/6lfdZ5Po7OEeuffPnv/eXBp16+eCrXf+6W" +
       "dPt0m32+XzL49pLLApmeudsoZQvyj7700j/9uZc+sefq0bOZaw98mP3Sv/uL" +
       "3zr47Dd/4zZp0j3AKYqHwaHaC+1e3KvsyAyPnZih4wa+XkwQR3X7ZMkKDo6/" +
       "rEBlfoudYujFO+t4VDrhCYZ87eP/7YnpD60++iaypKfP6eh8lz8/evU3qO9X" +
       "f/IidM8xotzy2XW20Y2zOPJgrIPvRH96Bk2e3Lteqb+ieO4uE5lxl7oyuwfe" +
       "cZ9a6HdvjruQOzm0z3uKEi0KYq9y/I4zy41bce/5w7i+fgfc8++Ge0XRPRNO" +
       "jxWARw6Y3s3eYtpjhQHHCseKOcVq8Ias7j3/AsiV7qsdNA4qxXP25ph5t+2q" +
       "14+AStTjBLjPddttFNXMOYZe+H9mCLjxwyexwATgg/vH//Onf+snnvsGCKwh" +
       "dN+6mMaAN57CLTYr1iD+zqufefJtL3/zx8tEEMSD+Hd/Gf2zotcffnNiPVGI" +
       "JZRfVoycpKMyX9O1QrKyC+GUPPMUZH2Axb+ytOlVvo8lA+Lox1SlTp2Y5RM/" +
       "QxfpVtlgXI+jCGxLtFVRH01otNvOczSJbZTmcKzisJLkGQ3N1DwJkyU0Tkhz" +
       "uxoKIR3NR4pJt6hYCIYdhpgyeZcOJz3WymdaGLdpdmJVqt1Kynbas7BXY8Ng" +
       "7SON0NNqmt+vinNywS5qu8UUMVADsZEGjMDNuh6Gs7kggekjYBKtQqWzQYta" +
       "ZbPpIPEydzFMAnnFbBVDFMhWxqEtxMm6YT+asfTMiSrwnGGjeNYVV7ZEk5a3" +
       "zAWJC6uzVkjYDjWdhxO1mltWhLOOrZBWNGZFqSdWI9Wn2/RIoOTZbjhejuoi" +
       "tkqpAT/u2R2c2zi7riEsLM1omLGwCh1Us1MnQXZOX2tMQmLbkOvuSBsIqECx" +
       "AtwbzVqTjciQS7G1dOq5h2d2FuJW3ku228q4WrWjWnuq9Wrtjh3oyroRVFqp" +
       "wIgbMtlO2EruLHatcMSIFS3EnEBeSA29KsipL0+oiku67KRhtf3Q7kbMyutP" +
       "Rp1dJHCpsNExJZKkoQanap9TRiKFDrIOSbnZhF86lucysk/pk8Zq5UaeUGlI" +
       "GykkYd0hxcHc6tt9Xae6Wq0a67LQYQewIDkzZZOhg4RwKAvbdsaeg0+darwQ" +
       "hu0eUF9oKlQ/or1B5NP9dC3EkixUO8KcMEYNOelzdo9k15Ec0w3C3lKSJ9Gy" +
       "whl9KuvxklIV7Sgc9+a6jiVmMNQbPaNN59MlxXseMYGlBjtruEKl3eEYpL2p" +
       "U9Ns3TaHZjxzp2463AlVMer5wljMelYUjd1NhTd1NxAEOq2ovc7UMRx3WBE1" +
       "qk43Z5VYAIw6dq0+7hJ9sUtjA4minN0MoaTNIN4ZmrSdc0YFqcZKo9qu4SYp" +
       "jLs1n+5srTUYF5dq/RbrcY7EdjKNGHXlxGaxcLfwm+MhMR5QjV1vnMl5o76t" +
       "J6HYEHS9N536ZNSTLA42R8F6uIKHLLNtBAufDNtz3K6mRNpe1ozhzkGkJV8T" +
       "SGNODIDK68mkXeE5bOCz02q1UcH4ijjsziYzqxrTmcTy9mRKujyFhfROzoKJ" +
       "UxtWZkJvR7flIMz4ScVk+Z4q2stYN5VebjUGg0ic1MXGgkMrJLncEWQUmZy/" +
       "EtMpsHh36blwn58PBtPZZgAnK61lDdYNzKgojtoL+UqDcIR6ZOE62Z5VjHo8" +
       "JczpKq94m7i/0VN0ZVVaS2zArPzZjpIUoltlZv2QGG02oYI1PSyaNQkqkPuT" +
       "CKflnkwpErDpwJyPPXUHAp6RyL48n3Btor2yzEmTErurNoXOqmO1tjS6nd06" +
       "M0aJttptksVmzq7wZTbuzLuOI5qN3J1xmAo45vSJ4o3HHWPUlzKCXWlKV5ra" +
       "dotgmiyNyRnamLbGPZXMhkk+Gzv0pEVz62531pjRPRNOcnixirE65ip4FR45" +
       "ZhTgE9FxXWpmU1Hc5aYmaWyn63TANserMePmy7jnT70OMULn0tDseEIyY/S6" +
       "JBvSVq6NkIEyao6mq2m3mQdZf8bRjRBWs/7aqodki9xMhqNus4INh6JJxQM+" +
       "sAjf5LOp3XTIYYbCkoLyuxCuVxtae6k35xzX2xJDzqX73UY+hFvq1HGXmTup" +
       "cXwDRh05bLaxUcXhqC1hwSjMGvQmbK7bqiS4pDnWK81aJeTocQCPcNdkEHWR" +
       "YXGz0QudGsYo0VjBRs02ualJ7A6FcwNuWvNMEDSZ7a87SLvtLiZ4b5O4MjdR" +
       "WK1b3dbo8Qxn8aaOEA2tvoUlIUUneHs593btqbdtEJJPcFG3He/gHd6Yo+gu" +
       "rqhpu7ocL1fciutPOwYjSX6LMzYkxoMP1FVbTHqcKdQytLugGDVf+dgoZlCl" +
       "0q5FDtHWTdUXExDTrDsd9i06WeyaMOJJcmIgWpYyKqPS6zGGxsMIN30V8fm5" +
       "U8/0GiKvNbvOjkdSgMMxP5yMxnySabpUDYU4zfstT5lu8Wa95oe8aVLEqDNP" +
       "Am077YhqHxsrKoEu8vG8uVZNAPW92na7XduwagwqrTk5ZNc64nXzsMf7tt3V" +
       "6pkh+n6KWqq0UGkGiGQmajZA9cmKHzS4kdLRPGzW2vGzbnWmDIWEdMg6Gqzx" +
       "OskbvZDpJvS2GRCblkx0Fpa0W4xcrxFF9bVo8FPXh7FEHLIrBncnmrCe0Mio" +
       "M6H0bljtBe0qJbM0js3guhWsZJnEsdFMpi2TwGsbMDu09NaAwnJFara4Ol91" +
       "Gzo/SBuhTHkcq+5WrV5r1OrOh412hhnNjaRmCAhppdWsDxY0QYLI3Kkq2qiP" +
       "2qzSQKZ5c1EbiPY87DfzkYpQdh1vILtsW2nlxkpTHSbZzXMrJ+i2hpqJMeWb" +
       "uxoJNL3thJQwS5OwktuVVdROkCpNCUM3ZKlxVdbYOm40l34ltJK+b66bG06S" +
       "qmYrViKhJ+FTql6RjW4Ts7WUXcEwIaw3TarTR5Y56c2b6JJkowyDhXjTXGwJ" +
       "arD26+NtLaAswUsq6aZfdWKbzZ3xbCkvB8u+njEtftFbRU2t0fbpGNlsYqLq" +
       "YivFDquZs9IMkUdEBseMNW8N1SAaDRIBWfB9GhN9zEa0ccPMKHVgbjtxVh3A" +
       "ZGLHcB3zIxZlZkq8nGlr3zVHM60yJcVgxNMKI6wzV4K5aXebt5Ya4lRsZDuu" +
       "ZvGcIloenQ/MDF3Bejeo4RrHWhiADVYFE+IQdVqwJA6XOjcVe+gWzFPK0Nvo" +
       "4nAHb3BqtJqJC8f2F8TU322MJb/yeBjHsiWvrlkbRPWiM+j5ETlhknAitqIN" +
       "54FUAkthTJGQDZrKqNZqNBCH7/BrvIsLnAemWbiJ8ON4rJFuuy9WNbpDJAYz" +
       "2AbJUqjBQmO6dIDK1EFDb2GNNWJ4k7WiDxbKwqtugtaMCJDWKER8E9GQpeZb" +
       "W8Ej5wRnMD6lEr2dTHC6shxKsenholizKULQRhKl034QiM11Z8koxMQCqSah" +
       "a4a2sxgTb9UW04aPInNP3CC+spnBrcjfdne5MekHEiWGHSRDm+spvG4Cg9nb" +
       "qjEJwrpFGysjnyKRvcYZdsFI2rqLDLfzcdsZS562awliF0urQ28mzfI1RzR1" +
       "t71uodMFxXfRDk+CFHQYqEtmx1NUcyVEtXElQzrCKBujZE9SG+RqrQ/oHZ53" +
       "ds0myfaHDovWbDif11JSQc12Tgpei5otJo4s6NM4SBQ671aDegtjsmGUdzeI" +
       "Z2GbnriKKH+c2vrGqYlggluIydbRVmOqb81rC2qVVKYmPI/qmwHLrrGOsQns" +
       "6Xw+9Lh+sFQXgV2R6svdbtHljWrXWfbhwWQnYyHvy7WF05vxTDKn6qnhguzG" +
       "m+1Cvt4e7rprT4kGvgRYczxRj1Kp3e+SoYyDJADT5jayUf3ehq/FZmNpj+dY" +
       "bsI+BQuBFuKhP9gtmnM1GW7GizqxBtI6dNIarikRZCVG1GhkNp1Ixq7p20Mb" +
       "bfLeoG1mwhyt99Aq7WVLOu3Usp2OL7emwQwbvCW3F9Nt21ilrWAuI4sKK9J0" +
       "utzNuvWxxGEM29qSQtaOw+0UfGeMcU93p1uzwZmOq/SzLZzXldCBrSDMxZBq" +
       "tOEFtUhmXo0bT7Ehzbpthl3NbLJG0qGdq2PV4M2AiVR5swAqWc5cLDfGc3G5" +
       "noUbSVsynZjooVRjKyPztLblOH8yXdTrKRFu1Jlu9thFshqRHIxV4UWiErta" +
       "d8Nx8w6tbwW/JuCdtg9TU7q6XZCqEGeywRGZ7GOiXW/ZsoZvNlO1tgBjDfvN" +
       "Vb9pLn1FT0WRplKxGQY4KiYLc5IuDTEb0SlG6zxjWE0V7WAG3s6bOQCx5bKF" +
       "G3KUWXqGC9aCXVfTJippVWXR3SpsZO6qkoMiE/CpFFUzAt20Zg6M486Ws2F2" +
       "pyR1X+cVD8c81M4UL115VoNN4TAIgO7kHobk82kzCzCXT3hv43YUuKkg48lQ" +
       "nkgp0uKq2HwnrLG6pcOzpt8fhmlcr4BJVpzPsgRHQ2IZ8KPlNsqi1m5NNMU8" +
       "8foihwkEmBEDzg+XPXOAZT5hryg83SzczmDcG+WizYxFabwkNmhLr7nBgFnU" +
       "ZYFr1I1tS+PlnVeJ+ha85BYhAXK2Lfgkrcm2wG6EaqUvmR2tPqjjXbQri5XF" +
       "IEGT1GFYFMurQV+fMpZaq454G69HBkyNqjC8qObeFo8q0gbhZiZCmrG5rddZ" +
       "K1Jkp07tuAU7U0R0J7f4zkga17O6WPN0xKAWY73pkc3mDjG0hhtp2WytVzd4" +
       "aug02sZDfrymWu547GyJGkq6uCotKyNp5CoBJgKoEKoIG9XlpohqgAc5260V" +
       "pBODjxQ6IuYuPue3W0xfG7Bf05eGbOJjeBwF5g6XJCPi0KWi1zw1tuvWKhTp" +
       "rc5Qm4kU9C1eRizZodeu3W1g/Sivat4Sb87X/UEOMvy6T/bBd6DLVjujXdxa" +
       "bucbyjOlKEV1bOIarJjldrvZpXBemYWJkk9WbbrSRlYW01p5VBNzTHjot3eI" +
       "DGPgA66v6F0eZqaVdbPja1NSVs0VQRDvL5YWPvnmljweKVdyjg9E/BXWcPZV" +
       "zxTF88erYOXvEnTnncVTuy8XjhY762+8pQxizTRd/fS+crGG++SdTkmU67ef" +
       "//jLr2jcF6oXD9f3Fin0QBqEf93V17p7ipHL5b18don+B8D14qEQL55fyjtR" +
       "0y0Kv1AqfK/mu6w1fu4udf+wKD6bQo+Z+qGw2sjy9OPt3MGJgX76jZadTvd9" +
       "OzHfC67qoZjVt17Mn79L3S8WxedT6B0nYvbyVPeTozXpU3J+4XuQ89EjP2we" +
       "ytl86+X8yl3qfrUovpxCDwM5u3qixlZ4tCvOnEj4y9+DhG8rXpLg+sChhB94" +
       "ayQ8t2Hx9C1xuj/DUx4gm02YI7o3PiIyFERKtPSNHpOx7Onl4L92FxV+rSj+" +
       "WQpdWpV+cttF2XVgaSfq/Or3oM7Hipffd6jSI9W+Beq8cBb2Hjra4yEtd6+C" +
       "r99FBb9XFP8GqKDYKw/T26ngshIEri77J1r4t2+FFkaHWhi9pVooHv9FSfBf" +
       "7iL1HxXFN4+lLp5+/0S8P3wrxPvIoXgfecvFY0qC1+8i3n8vij+5k3jffjPi" +
       "5Sl05dzJq+LoyOO3nPbcn1BUv/jKlfvf/crs3+83t49OET7AQPcbmeue3uk/" +
       "dX8pjHXDKll/YL/vH5Z/f55C194o6FPowZOHkv3/tW/8Fyn0zts2BkFd/J2i" +
       "vQCl0NXztCl0X/l/mu4eMNoJXaHg8uY0yaUUugeQFLeXw6OYPLXFtD8pkV84" +
       "lSgcOlFpnEffyDjHTU4faio2actjukcb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qtn+oO5N9UuvDNmPvY5/YX+oSnXl3a7o5X4Gurw/31V2WmzKPnPH3o76utR/" +
       "4bsPf/mB548Sn4f3DJ849Cnenr79qaWeF6blOaPdP3n3P37fz77yB+Ue2/8F" +
       "6OdEPz8tAAA=");
}
