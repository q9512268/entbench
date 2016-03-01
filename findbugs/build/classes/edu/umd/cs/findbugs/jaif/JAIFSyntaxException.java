package edu.umd.cs.findbugs.jaif;
public class JAIFSyntaxException extends java.lang.Exception {
    public JAIFSyntaxException(edu.umd.cs.findbugs.jaif.JAIFParser parser,
                               java.lang.String msg) { super(msg + " at line " +
                                                             parser.
                                                               getLineNumber(
                                                                 )); }
    public JAIFSyntaxException(edu.umd.cs.findbugs.jaif.JAIFScanner scanner,
                               java.lang.String msg) { super(msg + " at line " +
                                                             scanner.
                                                               getLineNumber(
                                                                 )); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0YW2wc1fXurt+xs34kTkiwSRyHKo/uEJVURU5LHGOTDeuH" +
                                                              "YojUTZvl7sxd78SzM5M7d+y1KTRQIcIPikSAtBL+CqpUtRAhUPtRkCskoKKt" +
                                                              "BEIttGraT6o2KlEl+Ehf59yZnZmdXQepH11p7ozPPfe8X9c/vk5aHU6GmSky" +
                                                              "YsVmTmbSFHOUO0ybMKjjPAiwgvpCiv7jzCcz9yRJW55sLlNnWqUOm9KZoTl5" +
                                                              "MqSbjqCmypwZxjQ8MceZw/gSFbpl5slW3clWbENXdTFtaQwRTlGeI31UCK4X" +
                                                              "XcGyPgFBhnIgiSIlUcbj22M50q1a9kqIvj2CPhHZQcxKyMsRpDd3li5RxRW6" +
                                                              "oeR0R4xVOTlgW8bKgmGJDKuKzFnjsG+CE7nDDSYYuZr+7ObFcq80wQA1TUtI" +
                                                              "9ZyTzLGMJablSDqEThqs4pwjj5FUjmyKIAsymqsxVYCpAkxr2oZYIH0PM93K" +
                                                              "hCXVETVKbbaKAgmyu56ITTmt+GTmpMxAoUP4usvDoO2uQFtPywYVnzugXHrh" +
                                                              "TO+rKZLOk7RuzqM4KgghgEkeDMoqRcadcU1jWp70meDsecZ1auirvqf7HX3B" +
                                                              "pMIF99fMgkDXZlzyDG0FfgTduKsKiwfqlWRA+X+1lgy6ALoOhrp6Gk4hHBTs" +
                                                              "0kEwXqIQd/6RlkXd1AS5I34i0HH0AUCAo+0VJspWwKrFpAAg/V6IGNRcUOYh" +
                                                              "9MwFQG21IAC5IDs2JIq2tqm6SBdYASMyhjfnbQFWpzQEHhFkaxxNUgIv7Yh5" +
                                                              "KeKf6zNHnnnEPG4mSQJk1phqoPyb4NBw7NBJVmKcQR54B7v3556ng29cSBIC" +
                                                              "yFtjyB7OT79z4+jB4fV3PZydTXBmi2eZKgrqleLm92+f2HdPCsXosC1HR+fX" +
                                                              "aS6zbM7fGavaUGEGA4q4maltrp98+5vnf8T+miRdWdKmWoZbgTjqU62KrRuM" +
                                                              "389MxqlgWpZ0MlObkPtZ0g7fOd1kHnS2VHKYyJIWQ4LaLPk3mKgEJNBEXfCt" +
                                                              "myWr9m1TUZbfVZsQ0g4P6YbnNuL95FsQVSlbFaZQlZq6aSlz3EL9HQUqThFs" +
                                                              "W1ZKEExFd8FRHK4qMnSY5ipuRVNUJ9w8S/WScmI8OzW/YgpanayqzEbNM3jC" +
                                                              "/v+wqaK2A8uJBDji9ngZMCCDjluGxnhBveQem7zxcuE9L8QwLXw7CXIQuGaA" +
                                                              "a0Z1MjWuGeSaacKVJBKS2Rbk7nkc/LUImQ+lt3vf/LdPPHxhJAWhZi+3gLGT" +
                                                              "gDpS14ImwvJQq+kF9ZX+ntXd1w69lSQtOdJPVeFSAzvKOF+AWqUu+uncXYTm" +
                                                              "FPaIXZEegc2NWyqowtlGvcKn0mEtMY5wQbZEKNQ6GOaqsnH/aCo/Wb+8/Pip" +
                                                              "796VJMn6toAsW6Gi4fE5LOZB0R6Nl4NmdNNPffLZK88/aoWFoa7P1Npjw0nU" +
                                                              "YSQeDnHzFNT9u+jrhTceHZVm74TCLSgkGtTE4TiPurozVqvhqEsHKFyyeIUa" +
                                                              "uFWzcZcoc2s5hMg47ZPfWyAsNmEiDsOzw89M+cbdQRvXbV5cY5zFtJA94uvz" +
                                                              "9osf/eYvX5HmrrWTdGQOmGdiLFLCkFi/LFZ9Ydg+yBkDvD9ennv2uetPnZYx" +
                                                              "Cxh7mjEcxXUCShe4EMz85LvnPv7TtSsfJoM4Twjo4W4RRqFqoCTCSdctlARu" +
                                                              "d4byQAk0oD5g1Iw+ZEJ86iWdFg2GifXP9N5Dr//tmV4vDgyA1MLo4BcTCOG3" +
                                                              "HSPn3zvz+bAkk1CxBYc2C9G8uj4QUh7nnK6gHNXHPxj6/jv0RegQUJUdfZXJ" +
                                                              "Qpv0cx2F2i7InlsWFDmd8Bpur+SCnTnjdWbp+cNy+y653o1WkwyI3BvDZa8T" +
                                                              "zaD6JI3MWwX14oef9pz69M0bUuX6gS0aMNPUHvNiFJc7q0B+W7zCHadOGfDu" +
                                                              "Xp/5Vq+xfhMo5oGiClOKM8uhyFbrwsvHbm3//S/eGnz4/RRJTpEuw6LaFJWZ" +
                                                              "SjohRZhThvpcte896kXIcgcsvVJV0qB8AwC9dEdz/09WbCE9tvqzba8d+eHa" +
                                                              "NRmqtiQx1JiGw36EDjdPQ1y/hMuBxuDe6GjMg7EQGb11z4GWCXUIcb8mRXjg" +
                                                              "FvEwi8uU3DqCy/2eoe79H22KgEnb29gZxYoZQP7a4sNF3AABBU6GNpr/5Ox6" +
                                                              "5YlLa9rsS4e8Ka2/fqaahCvDT377r19lLv/5l00aeKew7C8bbIkZdTwFGWjS" +
                                                              "wDFotjdcGLwhV315Ld2xbe2h38mGEAyi3VBKS65hBEyjAuDlhbOSLn3R7eWQ" +
                                                              "LV84M2/kZkFa8CXlPeOhF0HeJugCePufUWxo3l0htiBJtW67LGCU9LYFScEa" +
                                                              "3VwEEGzip2HXInIgLESBraqJxjCQMbb1i2Is4vc9dWVK3uh8s0+73p0O5p+1" +
                                                              "EzOP3PjqS15Dg7vg6qq8AcCFxuutwdiwe0NqNVptx/fd3Hy1c2/Sz48+T+Aw" +
                                                              "k3dGkmcSWpeNIbEjVu2d0aDof3zlyJu/vtD2AUTeaZKgYKrTkfuUd3mAluFC" +
                                                              "iJ/OhbNe5D8Csg2N7fvByjcOlv7+B1mKsGfizLoxfkHNP/tR9uri50flFaIV" +
                                                              "goBV83A5dO5bMU8ydQlqaIdr6udcloV752aMVoodRNrBN19PAMXxR5CRhktc" +
                                                              "k6ERyvQy48cs19SQTA80jhBSd7X0M6DLte3YgRASuG5Lo64F9b6n0z+/2J+a" +
                                                              "goyrUydKvt1xi4jt0w5vmxIg/djr1aX/wC8Bz7/xQScjAN9wB57wb167gquX" +
                                                              "bVe9vVQhN23bPm6H4feJx3A5X0WwIIn9PhSLZcKbefDP70n2T8hPXJ78LxXW" +
                                                              "RRJ4EgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ZecwsWVWv9828dYZ5b2ZgGEZ4zPJQh8aveqvurgzgVFdX" +
       "9VLV3dVdvRbKo/ala9+rYWRJgFESJHFATGD+gmgIW4xEE4MZY1QMxARD3BKB" +
       "GBMxSMLEiEZUvFX97W9B+cNO+nb1vefce9bfPffWZ78HnQ98qOQ6ZqaaTrgv" +
       "p+G+YSL7YebKwf6ARhjeD2QJN/kgmIG+m+KTX7z6gx9+RLu2B13goId523ZC" +
       "PtQdO5jKgWPGskRDV497CVO2ghC6Rht8zMNRqJswrQfhMzR03wnWELpBH4oA" +
       "AxFgIAJciABjx1SA6RWyHVl4zsHbYeBBvwSdo6ELrpiLF0JPnJ7E5X3eOpiG" +
       "KTQAM1zK/y+AUgVz6kOPH+m+0/kWhT9agl/49bdf++17oKscdFW32VwcEQgR" +
       "gkU46H5LtgTZDzBJkiUOetCWZYmVfZ039W0hNwc9FOiqzYeRLx8ZKe+MXNkv" +
       "1jy23P1irpsfiaHjH6mn6LIpHf47r5i8CnR95FjXnYZk3g8UvKIDwXyFF+VD" +
       "lns3ui2F0OvPchzpeIMCBID1oiWHmnO01L02Dzqgh3a+M3lbhdnQ120VkJ53" +
       "IrBKCD12x0lzW7u8uOFV+WYIPXqWjtkNAarLhSFylhB61VmyYibgpcfOeOmE" +
       "f743evOH32n37L1CZkkWzVz+S4Dp+hmmqazIvmyL8o7x/jfSH+Mf+fLzexAE" +
       "iF91hnhH87vvevnZN11/6Ss7mp+6Dc1YMGQxvCl+Snjg66/Fn0bvycW45DqB" +
       "njv/lOZF+DMHI8+kLsi8R45mzAf3Dwdfmv7J+j2fkb+7B13pQxdEx4wsEEcP" +
       "io7l6qbsd2Vb9vlQlvrQZdmW8GK8D10Ez7Ruy7vesaIEctiH7jWLrgtO8R+Y" +
       "SAFT5Ca6CJ51W3EOn10+1Irn1IUg6CL4QveD72ug3af4DSER1hxLhnmRt3Xb" +
       "gRnfyfUPYNkOBWBbDVZAMAmRGsCBL8JF6MhSBEeWBIvB8aDB6wo8wPokm9kh" +
       "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" +
       "/z+6ZghFqx0AAA==");
}
