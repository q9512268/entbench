package org.apache.batik.util.io;
public class UTF16Decoder extends org.apache.batik.util.io.AbstractCharDecoder {
    protected boolean bigEndian;
    public UTF16Decoder(java.io.InputStream is) throws java.io.IOException {
        super(
          is);
        int b1 =
          is.
          read(
            );
        if (b1 ==
              -1) {
            endOfStreamError(
              "UTF-16");
        }
        int b2 =
          is.
          read(
            );
        if (b2 ==
              -1) {
            endOfStreamError(
              "UTF-16");
        }
        int m =
          (b1 &
             255) <<
          8 |
          b2 &
          255;
        switch (m) {
            case 65279:
                bigEndian =
                  true;
                break;
            case 65534:
                break;
            default:
                charError(
                  "UTF-16");
        }
    }
    public UTF16Decoder(java.io.InputStream is, boolean be) { super(is);
                                                              bigEndian =
                                                                be; }
    public int readChar() throws java.io.IOException { if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           return END_OF_STREAM;
                                                       }
                                                       byte b1 = buffer[position++];
                                                       if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           endOfStreamError(
                                                             "UTF-16");
                                                       }
                                                       byte b2 = buffer[position++];
                                                       int c = bigEndian ? (b1 &
                                                                              255) <<
                                                         8 |
                                                         b2 &
                                                         255
                                                         : (b2 &
                                                              255) <<
                                                         8 |
                                                         b1 &
                                                         255;
                                                       if (c == 65534) {
                                                           charError(
                                                             "UTF-16");
                                                       }
                                                       return c; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe4xUVxk/M/t+P2BhC+wCy4Dh0Z1SCwYXaWHZZZfOPmBh" +
                                                              "o7OW5cydMzuXvXPv5d5zd2e30gdNA5pIKAJFbdd/aKiElqbaqNE2mEbbptWk" +
                                                              "LVqrKTVqIlqJJcZqRK3fOefeuY+ZXYLRSebMnXO+853zfd/ve90L11CJaaBW" +
                                                              "otJ2OqUTs71LpYPYMEmyU8GmuQfmRqXHi/Bf9l3t3xRGpXFUm8Zmn4RN0i0T" +
                                                              "JWnGUYusmhSrEjH7CUmyHYMGMYkxgamsqXHUJJu9GV2RJZn2aUnCCIaxEUMN" +
                                                              "mFJDTliU9NoMKGqJwU2i/CbRrcHljhiqljR9yiVv9pB3elYYZcY9y6SoPnYA" +
                                                              "T+CoRWUlGpNN2pE10FpdU6bGFI22kyxtP6BssFWwM7YhTwVtz9V9dON4up6r" +
                                                              "YB5WVY1y8czdxNSUCZKMoTp3tkshGfMgegAVxVCVh5iiSMw5NAqHRuFQR1qX" +
                                                              "Cm5fQ1Qr06lxcajDqVSX2IUoWu5nomMDZ2w2g/zOwKGc2rLzzSDtspy0Qso8" +
                                                              "EU+tjZ58fF/980WoLo7qZHWIXUeCS1A4JA4KJZkEMcytySRJxlGDCsYeIoaM" +
                                                              "FXnatnSjKY+pmFpgfkctbNLSicHPdHUFdgTZDEuimpETL8UBZf8rSSl4DGRd" +
                                                              "4MoqJOxm8yBgpQwXM1IYcGdvKR6X1SRFS4M7cjJG7gUC2FqWITSt5Y4qVjFM" +
                                                              "oEYBEQWrY9EhgJ46BqQlGgDQoGjRrEyZrnUsjeMxMsoQGaAbFEtAVcEVwbZQ" +
                                                              "1BQk45zASosCVvLY51r/5mP3qz1qGIXgzkkiKez+VbCpNbBpN0kRg4AfiI3V" +
                                                              "a2Kn8YIXj4YRAuKmALGg+c4Xrt+zrvXSq4JmcQGagcQBItFR6Wyi9s0lnas3" +
                                                              "FbFrlOuaKTPj+yTnXjZor3RkdYgwC3Ic2WK7s3hp948/99B58kEYVfaiUklT" +
                                                              "rAzgqEHSMrqsEGMHUYmBKUn2ogqiJjv5ei8qg+eYrBIxO5BKmYT2omKFT5Vq" +
                                                              "/D+oKAUsmIoq4VlWU5rzrGOa5s9ZHSFUBl9UDd+lSHz4L0Wfjaa1DIliCauy" +
                                                              "qkUHDY3Jb0Yh4iRAt+loAlA/HjU1ywAIRjVjLIoBB2liL3AlyFp0757u9Ru3" +
                                                              "EwnCkdHOEKb/H3lnmVzzJkMhUPmSoMMr4Cs9mgK0o9JJa1vX9WdHXxdgYg5g" +
                                                              "a4SilXBcuziunR8nTCZr7d7jUCjET5nPjhUUYJJxcG6IrtWrh+7buf9oWxGg" +
                                                              "SZ8sBn2GgbTNl2U63QjghO1R6WJjzfTyK+tfDqPiGGrEErWwwpLGVmMMwpE0" +
                                                              "bntsdQLyj5sGlnnSAMtfhiaRJESh2dKBzaVcmyAGm6dovoeDk6SYO0ZnTxEF" +
                                                              "748unZl8ePjBO8Io7I/87MgSCFps+yCL17m4HAl6fCG+dUeufnTx9CHN9X1f" +
                                                              "KnEyYN5OJkNbEAdB9YxKa5bhF0ZfPBThaq+A2Ewx+BKEvdbgGb7Q0uGEaSZL" +
                                                              "OQic0owMVtiSo+NKmja0SXeGA7SBP88HWFQxX1sI37W28/FftrpAZ+NCAWiG" +
                                                              "s4AUPA18Zkh/8hc//cMnubqdjFHnSfVDhHZ4ohRj1sjjUYML2z0GIUD33pnB" +
                                                              "r5y6dmSEYxYoVhQ6MMLGTohOYEJQ86OvHnz3/StnL4dzOA9RSNNWAqqdbE5I" +
                                                              "No8q5xASTlvl3geinALRgKEmslcFfMopGScUwhzrn3Ur17/wp2P1AgcKzDgw" +
                                                              "WndzBu78bdvQQ6/v+1srZxOSWJZ1deaSidA9z+W81TDwFLtH9uG3Wr76Cn4S" +
                                                              "kgAEXlOeJjyWhoQOuOTN1N4JgaNX1S0KOZXgDDfoBk5xBx/vmmvfQFdWIjq7" +
                                                              "C9+3iQ0rTa/T+P3SU0WNSscvf1gz/OFL17mU/jLMi5E+rHcIWLJhVRbYLwwG" +
                                                              "tR5spoHurkv9n69XLt0AjnHgKEFwNgcMiIZZH6Js6pKyX/7w5QX73yxC4W5U" +
                                                              "qWg42Y25c6IK8ApipiEWZ/W77xGgmCyHoZ49ZVFOMYgrBmXzJphhlhY2eVdG" +
                                                              "p9xI099d+O3N52aucHTqnEVLvuf12KDsKex5bPwEG9bm43m2rQHrhkUGYH83" +
                                                              "+tMAC7VDVsKEkC1nwEMn7IrlzsH90tHI4O9ENXJbgQ2Crunp6JeH3znwBvf/" +
                                                              "cpYU2Dw7qMYT8iF5eIJPvZDjY/iE4Ptv9mX3ZxMi8zd22uXHslz9oesMFqvn" +
                                                              "aBj8AkQPNb4//sTVZ4QAwfosQEyOnvzSx+3HTgqnFkXsirw60rtHFLJCHDYM" +
                                                              "sNstn+sUvqP79xcPff/pQ0fErRr9JVkXdBzP/Pxfb7Sf+fVrBaqCsoSmKQSr" +
                                                              "eT4LodlvHyHU9i/W/eB4Y1E3pJReVG6p8kGL9Ca9XKEON62Ex2BugcwnvOIx" +
                                                              "41AUWgN24NP3BiDmuAX7v48N3XxpMxt2CO+5+790NDbRpYuFxTmZl/hqGd4K" +
                                                              "u+n0/Nuf+tm5x05PCj3PgZrAvuZ/DCiJw7/5e17A4tVDASAF9sejF55Y1Lnl" +
                                                              "A77fTeNsdySbXxBCKeTuvfN85q/httIfhVFZHNVLdus5jBWLJcc4tFum049C" +
                                                              "e+pb97dOok/oyJUpS4JI9hwbLCC84CimPiC4NUMts8sy+Ebs8BMJRq4Q4g8H" +
                                                              "RPDi4xo23O6k6Ard0CjckiQDWbpmDrawLSGPdalJGfNCot8NkBxn43PgLFso" +
                                                              "jvJPKQp0HsE4uthBpoFaZmsOuXefPXxyJjnw1Pqw7QfDcGGq6bcrZIIoAfi2" +
                                                              "+ODbx9thFwvv1Z747fciY9tupQpnc603qbPZ/6UAxDWze0TwKq8c/uOiPVvS" +
                                                              "+2+hoF4a0FKQ5Tf7Lry2Y5V0Isx7fwHSvHcG/k0dfmhWGoRahuqPVCtydq1z" +
                                                              "Uusu2667bj21zrZ1jrj3SOGiiv39NCd4lA0PUFQOdViyM20bKGYnEPazy/O8" +
                                                              "l6Ii2X75FGA3knVR/+D/JLpSVO1tLll105z3vkq8Y5GenakrXziz9x2Oztx7" +
                                                              "kGrAWcpSFG8E8TyX6gZJyVwN1SKe6PznBEXNs/W7FIVljV/5MUF8iqKmgsQU" +
                                                              "FbMfL+0ZiuqDtBSV8F8v3dcpqnTpoHsQD16SGbAEkLDHb+hOjbxu1i59K5RH" +
                                                              "Bjgts7Ctz2zIH0py1mu6mfU80WeFz2v5S0fHwyzx2hH695md/fdf3/iUaMgk" +
                                                              "BU9PMy5VkOtFb5jz0uWzcnN4lfasvlH7XMVKJ541iAu7vrPYA/4ugKbOYLMo" +
                                                              "0K2YkVzT8u7ZzS/95GjpW5AeR1AIQ58xkp+3sroF4XEkll/TQETjbVTH6q9N" +
                                                              "bVmX+vOveF2dXw8E6Uely+fue/tE81lot6p6UQmEapLlCXX7lLqbSBNGHNXI" +
                                                              "ZlcWrghcZKz4CqZahnDMXkdyvdjqrMnNsnaeorb8ejH/JQj0IJPE2KZZatIu" +
                                                              "uarcGd/bUCfQWboe2ODOeGrquIgbzBqA1dFYn6475XR1l86dfKRwIGHj8/yR" +
                                                              "Dd/6D7ddBTWQGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "//zpZ/7448+8ayvGXcfXBCRY8n7yr//7y7svfOOLNyhL5xXPs3V567uNE4rd" +
       "N2323MuaN+evqlnzlq3BsR/JN7aw9+VPZ25tIipbrh6m/fv+s28rz/7j964L" +
       "kLxa3cBqJ/Al+KUP30+85Vs5/mHZyLAfTK+v5mBpf4hb/oTz7zuPnvvzHei8" +
       "BF1R9/YNgmwnWTKWwFo52t9MgL3FsffH173bRd5TB2Xx9Sfd5si0JwvWoblA" +
       "P4PO+pdO1Kg7Mi0/DL5X9yLm6slgOwXlnek23vL2atb8xH5JuOiHXgy41LWc" +
       "Ng1GFMskXc2S85pEHYZrbn/xh9mfy8mkpwDts+Xd2m4xe376xvOfzro/CepS" +
       "lO+OAIZhubK9z8m9c1u9uh8fAtgtAQe4Ordr+8n4Sp7XMlXvbrcYJ3ilf2Re" +
       "gW/ecUis64Hdynv+6f1fft9jXwcO1IbOLjPjAr85MmMvyTZwv/zSBx54zfPf" +
       "eE9eZoFChXf/XuV7GdXFrSTOGi1r9H1R789E5fIValeOYjavjLp2IC1xRJ5W" +
       "DOqr93+QNr794wwStfD9T1cQdSTlhXQBs3BcGJQbM6KwItZIc1aUShyxEqfy" +
       "hJEkyegPnMbMq/UnqLrW2E0yXU4HS1RDN1pZrxRNrYejfquDtylF02C5Y5F2" +
       "oMhBjyw7pKL48WTRFYKwMxaClh2026oUjDoVow8WbolYkKZid8TpCutO+4U6" +
       "WtkYGrzUsWK3VCLastyYeHG73A/4cVQrdX1xILKks+brtJMMDWcUTBkLbhiY" +
       "XYkr6Yj2pxTv1CXHRUa9olUctycuzYtJ5My4kJwzNYJ31ozI0qy4SM1syTtl" +
       "+HY7wWihPGpLblnmXYJoySnJsz2HajfHtsVjPY/t0EF7xZctmFBGocrY85kV" +
       "2PMRtraEJeY3KrotipIqYusq5w1cER8XCG804W3a7/XKPlkqUr7GVxWaapXL" +
       "i3UaD6qNKKImK7YmzsYrId5gAqb1e0jiV0OxgU4EsbSuqxst7XE8IXVYb+xX" +
       "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" +
       "nN/7bP7o3j940++8+LX8JO5/AfpKtAuiIgAA");
}
