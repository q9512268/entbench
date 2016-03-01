package org.apache.batik.gvt.font;
public class UnicodeRange {
    private int firstUnicodeValue;
    private int lastUnicodeValue;
    public UnicodeRange(java.lang.String unicodeRange) { super();
                                                         if (unicodeRange.
                                                               startsWith(
                                                                 "U+") &&
                                                               unicodeRange.
                                                               length(
                                                                 ) >
                                                               2) { unicodeRange =
                                                                      unicodeRange.
                                                                        substring(
                                                                          2);
                                                                    int dashIndex =
                                                                      unicodeRange.
                                                                      indexOf(
                                                                        '-');
                                                                    java.lang.String firstValue;
                                                                    java.lang.String lastValue;
                                                                    if (dashIndex !=
                                                                          -1) {
                                                                        firstValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              0,
                                                                              dashIndex);
                                                                        lastValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              dashIndex +
                                                                                1);
                                                                    }
                                                                    else {
                                                                        firstValue =
                                                                          unicodeRange;
                                                                        lastValue =
                                                                          unicodeRange;
                                                                        if (unicodeRange.
                                                                              indexOf(
                                                                                '?') !=
                                                                              -1) {
                                                                            firstValue =
                                                                              firstValue.
                                                                                replace(
                                                                                  '?',
                                                                                  '0');
                                                                            lastValue =
                                                                              lastValue.
                                                                                replace(
                                                                                  '?',
                                                                                  'F');
                                                                        }
                                                                    }
                                                                    try {
                                                                        firstUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              firstValue,
                                                                              16);
                                                                        lastUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              lastValue,
                                                                              16);
                                                                    }
                                                                    catch (java.lang.NumberFormatException e) {
                                                                        firstUnicodeValue =
                                                                          -1;
                                                                        lastUnicodeValue =
                                                                          -1;
                                                                    }
                                                         }
                                                         else {
                                                             firstUnicodeValue =
                                                               -1;
                                                             lastUnicodeValue =
                                                               -1;
                                                         }
    }
    public boolean contains(java.lang.String unicode) {
        if (unicode.
              length(
                ) ==
              1) {
            int unicodeVal =
              unicode.
              charAt(
                0);
            return contains(
                     unicodeVal);
        }
        return false;
    }
    public boolean contains(int unicodeVal) {
        return unicodeVal >=
          firstUnicodeValue &&
          unicodeVal <=
          lastUnicodeValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tXSi3zCc1i92jVveMHimvsRh7n89I0wmehgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06e+zsWFm9v7v3ye7eu7uwuyzs+7KyW/h12um8cgHpTKfz" +
       "ajudV2emKpdOH9NO38/pFFeBiIuSwEYvKyawMRFUyPKIkWhiMGuMAoGYYIiv" +
       "RCDGRBRJ2D9EIyqedn7ve++uEOMkPT095zvf+d7nO+fMC9+FzgQ+BLuOuVma" +
       "TrirJOHuyizthhtXCXa7dIkT/UCRG6YYBGPQdk167HOXvv+DZ7XLO9BZAbpH" +
       "tG0nFEPdsYOhEjhmrMg0dOmwtWkqVhBCl+mVGItIFOomQutBeJWGXnVkaAhd" +
       "ofdJQAAJCCAByUlAiEMoMOgOxY6sRjZCtMPAg34OOkVDZ10pIy+EHj2OxBV9" +
       "0dpDw+UcAAzns28eMJUPTnzokQPetzzfwPCHYeT6r73j8u+ehi4J0CXdHmXk" +
       "SICIEEwiQLdbirVQ/ICQZUUWoLtsRZFHiq+Lpp7mdAvQ3YG+tMUw8pUDIWWN" +
       "kav4+ZyHkrtdynjzIyl0/AP2VF0x5f2vM6opLgGv9x7yuuWQytoBgxd1QJiv" +
       "ipKyP+Q2Q7flEHr45IgDHq/0AAAYes5SQs05mOo2WwQN0N1b3ZmivURGoa/b" +
       "SwB6xonALCH0wC2RZrJ2RckQl8q1ELr/JBy37QJQF3JBZENC6DUnwXJMQEsP" +
       "nNDSEf18l33LB99lt+2dnGZZkcyM/vNg0EMnBg0VVfEVW1K2A29/in5OvPcL" +
       "79+BIAD8mhPAW5jf/9mX3v6mh1780hbmdTeB6S9WihRekz6+uPNrr288WTud" +
       "kXHedQI9U/4xznPz5/Z6riYu8Lx7DzBmnbv7nS8O/2z+7k8p39mBLnags5Jj" +
       "Rhawo7skx3J1U/Fbiq34YqjIHeiCYsuNvL8DnQN1WreVbWtfVQMl7EC3mXnT" +
       "WSf/BiJSAYpMROdAXbdVZ7/uiqGW1xMXgqBz4IFuB89D0PaXv0NoiWiOpSCi" +
       "JNq67SCc72T8Zwq1ZREJlQDUZdDrOsgC2L/xZnS3ggRO5AODRBx/iYjAKjRl" +
       "24ks4xBRgZiQia1LjqwMgZUpu5nBuf9/UyUZ15fXp04Bhbz+ZDgwgSe1HVNW" +
       "/GvS9ajefOkz176yc+Aee/IKoSfAfLvb+Xbz+XbBfLvZfLtH54NOncqneXU2" +
       "71bnQGMG8H0QFW9/cvQz3Xe+/7HTwNjc9W1A3Bkocuvg3DiMFp08JkrAZKEX" +
       "P7J+D//zhR1o53iUzWgFTRez4VwWGw9i4JWT3nUzvJee+fb3P/vc086hnx0L" +
       "23vuf+PIzH0fOylV35EUGQTEQ/RPPSJ+/toXnr6yA90GYgKIg6EI7BaEmIdO" +
       "znHMja/uh8SMlzOAYdXxLdHMuvbj2MVQ8531YUuu7jvz+l1Axq/K7Po+8Dyx" +
       "Z+j5O+u9x83KV2/NI1PaCS7ykPvWkfuxv/7zfyrm4t6PzpeOrHcjJbx6JCJk" +
       "yC7lvn/XoQ2MfUUBcH/3Ee5XP/zdZ34qNwAA8fjNJrySlQ0QCYAKgZjf9yXv" +
       "b775jY9/fefQaEKwJEYLU5eSAyazdujiyzAJZnvikB4QUUzgapnVXJnYliPr" +
       "qi4uTCWz0v+89Ab08//ywctbOzBBy74ZvemVERy2v7YOvfsr7/i3h3I0p6Rs" +
       "RTuU2SHYNkzec4iZ8H1xk9GRvOcvHvz1L4ofAwEXBLlAT5U8bp3ac5yMqNeA" +
       "zCMfmS1eu9vFK9cmknc/lZe7mSTyQVDeV8yKh4OjXnHc8Y6kJNekZ7/+vTv4" +
       "7/3RSzkbx3Oao0bAiO7Vrd1lxSMJQH/fyRDQFgMNwOEvsj992XzxBwCjADBK" +
       "IJgFfR/En+SYyexBnzn3t3/8J/e+82unoR0Kumg6okyJufdBF4DZK4EGQlfi" +
       "/uTbt1pfnwfF5ZxV6Abmt9Zyf/6VZYVP3jrwUFlKcui79/9H31y89+///QYh" +
       "5CHnJivxifEC8sJHH2i87Tv5+EPfz0Y/lNwYk0H6djgW+5T1rzuPnf3THeic" +
       "AF2W9nJDXjSjzKMEkA8F+wkjyB+P9R/PbbYL+dWD2Pb6k3HnyLQno87hWgDq" +
       "GXRWv3gi0GSLKfQYeB7Z88FHTgaaU1BeIfIhj+bllaz4iX2/Puf6egwW/j3H" +
       "/iH4nQLPf2dPhixr2C7Tdzf2coVHDpIFFyxTd6m6H4R7K1IuhJdXNOfrFghb" +
       "8V7KhDx99zeNj37709t06KRWTwAr77/+yz/c/eD1nSNJ6OM35IFHx2wT0Vxs" +
       "d2QFlfnJoy83Sz6C+sfPPv2Hv/P0M1uq7j6eUjXBjuHTf/lfX939yLe+fJN1" +
       "+zRIl7fxPSvxrKhvpVu5pdO85bhKH9179us3U+noFirNqs2cYQrEKpDUHtNN" +
       "1k6foG78itRtJXcKmMsZbLeyW8i+hZvPfzqrvhGsF0G+qQEjVN0WzX2C7luZ" +
       "0pV9Q+LBJgf49JWVWcm6Cyfoov7XdAGd3nkYlWkHbCg+8A/PfvVDj38T6KcL" +
       "nYkz1oEij4RuNsr2WL/4wocffNX1b30gX+qA8LjnmpffnmGVXo67rHhHVlzb" +
       "Z+uBjK1RnifSQOJMvjopcsZZjqJzhB8mBGscIPHH5ja84xfaeNAh9n80Olen" +
       "60mSTNV+LbbJdQoTRKqtE21lNEgjdMcDluyy82Td6VpyNViio5UrrBYW0p+F" +
       "q8VsJtgViel2RgTqNIfUZEaMrOVi4hnDsDkwh6ao8R7a8FR9OLT0roM2hPpY" +
       "9q1VecgaTEddTU3XqpQFbFGsRWSwQjzLtIcxF8eyVQxV8DJSHm2wgtjtE1go" +
       "tHtqhWzRlIFtlKQnUIFf8EIv0abNIr1CKibWabnFmqSuet15IyiICS8iqwa2" +
       "GY0oDzU8LZm71kRMuwnr9kZdIek2Ub05Y5hJYTabWHo0j2cmyU+HlOzFwtpY" +
       "YZ0KW2/5dbPr9hJPNNKEIgpCp8nhxeZ4w6EaYZWbZW2IOmitHfQbRLMfVxJs" +
       "lc7iynQ4QLvFxYoZpQJPtUytRQ8rTq+7WPEFWYY7XsjgPZnEF/ZUnuPLUJ9N" +
       "TCHSqoFipWUc5libSVNGFF2zHzkrvkNTBblTM5pi3J2yZcdYwChFlltevetr" +
       "nbLo9GAq6gUtq2mlXjkKh2vFtJtBsV+DXamtuD1dMzb9pE6NcLZBtlI9bjDW" +
       "RqoyzchznDS061ahoodeubIsu3B/FBai8bhfChG+MxUnntYtzBdzaTrA6x2e" +
       "nVj1gRFUBwXY7wqGgWm8U5C45YAZToOe1u+HaBAKkzGJduYDiSk2KAsjrXbC" +
       "pehiOZJJNmxNPaswQ6XVxrG5mifpjkLwxQVHYZTmxvO+vpo7DFlP65sW1mbn" +
       "Xiw5U3fRngiNldfiZuqEIHyaLw0MFcXNBd9y5hTacBtDZibq5KC5FhWWaFks" +
       "qVNO1dT9TncsYAG5aa+SRkEbs2SNMZNRtPQipTVvrCfpABtLE3vpDiYajdhV" +
       "CZv5sMdwYjdCex2fsBZskw/tkrCujxVcc43+qDMaEVy9xa28YDiO+hjfQVvN" +
       "ZVuLdGo1QLhV3Ssq8WKFIJZXF6YdwerQ/cWGHIR21WciX3dkeCrzynouz4Wo" +
       "J6UlQkJLpj6V2VqBIkoNyx/pw3i+qdDVKodEC1grwONVue84A4QSKAytJvU2" +
       "vegpbDLiLU4arQR9blhr1dNlMXQVpFLoo0yz6rS0lk9ULGk4XaqeuShNjNRG" +
       "8H5X0hsNS1zWS443LdSw0lIxHDuRGI0iQq63HNr23EDiZTwccSOvi9tNV0xc" +
       "Sy+b5BB1V7W0x0jSPGhWG1iVnUkugfTh0mJSrJKBPVoMmcYkpFkQA0i+sx5V" +
       "+Y7YEtkRGayNhcxMWkLdbfZ6TELZREuFEX/gMuWavTIGS1ygmnPSHHdcBitb" +
       "Om9N3XKBxTZV2KDL5JDyaLIgKWirQMQirSNFXaWreKUu23B1VoPLVEdrVVMN" +
       "LvgqgSvYul8iYXIRtWmnjIZYW7GCpUWkiRfXi52kMJwYSTnmibUxw8J2auER" +
       "OdHG0mJsyEOqTRhEddbx1pq8nDvLhuu5m82ANqiRy/orvEdNo7o145YSrrZT" +
       "GEckYgaTdrXDVJvokoAZdW4s4YVOmUWt1MDtELbXwxIsq1MPqXh8yWl5eCKW" +
       "m0aZags13Z0rs3HVc/pImy6bKipP+AFrEIP1mGwZ5KguKUWdIzpuIcJXjNwz" +
       "SG3WL1uS5CnwrCESjMyqfLLA+fZ0HanpujlLsbrLDmCFmpSVKo9gYYAu8XQ9" +
       "tEeJNTDddcIhPaPd1isyUluMCkXgs5JlJ7w6Xw0WWnXJTFthu+2KcZ2Q2KVR" +
       "j1ZVeZyUKtXA19rjFF62ukI0wCoYu6QHxCCqkyyCV6a1SiVFip5VdMwKM/FW" +
       "HXkpilahOxwtxH7LE4ZGMC3JCU6w9cnGnvAsms5Zx6S7vbG+arrA5rCSGIMN" +
       "4xjHMT3VBnNpwjq1SZGKGmGx0qlzatpKPROj9bke4LSHSetVc7MEFsxJ85KL" +
       "t9OwjSsNM5FrZUqoEjGhMKEw6K6tZopHg7BfG1bLvSreLUeyxDcr0ViOS+Wq" +
       "yXkl04zqjE4jFUaLynS7Nq3XOQ5NWmZJUlXYHls1A+FmCu/VqcBTE7IwL7OL" +
       "pF5YmJpMIPR6TVjFFqqvBsVZCS7XFBFVudlg2ul1GY9wZZFoqPVZozNiBig6" +
       "hmE8VkMLK2MdXrdKDVL0+kEpWKdpaUJiFOdTFJE6dIIuIgqtqv68tbI8rzMq" +
       "CZZmloZFXBKrg4U97BbxTaU8Q4spUmo7VazJ43R/Fk/mLiq1GlqpD1dMuKHM" +
       "YqRYT8sKzG+iHiz5vXV9oVsIHBNjPi33kNnISZmOiDJO0tbHBdO2zeJAqalt" +
       "m0VIKhBrPlUXpWW9xsl4bAcVpFNzBLg4maCiMAjgTSEOo0T0+8x40qoIFbvG" +
       "0OP2UlXrqFEs9GSUqlAgz1jNAMvUpFpw5LRuoFa1yhBD26d4wubqaH9lK83l" +
       "aNOAeyMuKKdLvOBgfltInNp8TS2WujGsr9Ou1uo1J2F/wEeMUR6W5n5a4toU" +
       "4Yc6KRuCvhHY7qDq9PvzwrKlLtx4AXv2Qm/7SqlXlfReH05hHanKXL8tzssb" +
       "WdzgpB9Oq90Z27a5Zh1pswOwKuGjaiMtIsJ6XeEoY+Cjsu/X2oyczBd9htKi" +
       "sdYXO8OpgYjFuFK0MQe4WiNq4mS9Ne6U+pyq4Uhft5aT2rpnupNCycYVacwM" +
       "yn5d07toVJ6NKlKnxLZLwAMrDEhsqsE4nIiVdrO41mYRPEaqpYqa4MUaHE/W" +
       "K16c4GwlQrnV0FzN6E6/0DOxrjNG0nS9YQNyQi8qky4W9mZhWHAldmhtQmEq" +
       "VysxHbVQfNKvOgmKEpPpgFeazelsNVM283nQ2agT3hDXRYuQabCZlM1qQE6V" +
       "Qb2V9EyCh7stzOkV24VGVapM6wWmnRqlFO/0ilXR15N4HVNRpYiMZuIAjZtr" +
       "q564o0AgcWqsbQROWCrKNGHRjen1BsZssJLDCWMsJs02EdODdqTa+LDGk+uV" +
       "EY55QVEttjbHwvVmpBT4aSjzpsw4MdPyNaQMzzk9KvCFYmExiRqKoVIgXUVW" +
       "/bhYCRuqTvcqtU5DbsYR3mxZFYtcsq7exLz5lGRnfSeQLaZQDbSGqimN9ZBc" +
       "DeKuQffpWFiZvEaSc2+swakq86mXkAM57bBB0LA8aePJiWiNSLu8tjEMhtUC" +
       "ASemzK/t6cbCZrS9TLiZuOoSm0IT22jaBonp8UwIelyxymALHyRngsCwkmdx" +
       "42l/s6jQWlNAuhhX5RTBUWPbZhvJAIUtWPFpTJwhvXBU3KgGX8UxflCswCOM" +
       "Q+jFGGkuRjo3idxN6MUVr1KK22SXM6h2BQaZNt1gdcnt61PdlzXd8wUyRQrM" +
       "pI2ArCXdhBRJz8nhGDGYJQXPDa8jIlFk9wvUcFmQ2rWkmVQFtlovD8iGEMLo" +
       "ZjX25yHmDYkuiOHDzoyNS3VCnTRwel0nkV5kNjQdg0eFji/ZNI0ulUiNjJI0" +
       "x8b8eJ2sxTGz7Dvmwh2CbM4UJ4Lj9ypCqaTyAl2bx3K5VRwO07kOb6g4WPnL" +
       "4RKdttZBg0UTAKjziiJPYLAHmBmGvLS82gCfrIdjtmi2xWl9zrTSejIsdyV7" +
       "IAxKoRJXnDknmxhes8qGqarxiBpjtcjAC3EvkUrKuC+xeNfxPRglWL4ujHCq" +
       "GHNqVBiMepw1b23a1dgJzUV1SVp0fdy1wk0paknKksEjv0KC8CRgZpsnXTdp" +
       "4ZizHkvr/rjiD4aE2MBIiUNMM8TcNQHCstUJZyO9mDYkVK9hKz5WmLZuxcFQ" +
       "q9jVWqewthRtCTZdb31rth1zfrRt4l357vfgkuzH2Pduux7NijccnBnkv7PQ" +
       "iYuVo0exh8dwUHYA8uCt7r7yw4+Pv/f683L/E+jO3vElG0IXQsd9s6nEinkE" +
       "1Q7A9NStD3qY/Orv8Fjti+/95wfGb9Pe+SPcIjx8gs6TKD/JvPDl1hPSr+xA" +
       "pw8O2W64lDw+6Orxo7WLvhJGvj0+dsD24IFk78kk9jrw0HuSpU+exhzq7uZH" +
       "MW/c6v7E6fCpQ4BCDvC+lzk+fiYr3h1C5/eOMYObHSmcWziOqYj2oRm955UO" +
       "FI7Okzc8fSPf4z2+x//nfNM5wPWX4fu5rPjQEb6z7186ZPDZH4XBJIRuP3pt" +
       "lt0B3H/DRf32cln6zPOXzt/3/OSv8pujgwvgCzR0Xo1M8+jJ7JH6WddXVD2n" +
       "/ML2nNbNXx8Lodfe8iovhG7LXjm5H93C/0YIvfpm8CF0GpRHIX8zhC6fhAyh" +
       "M/n7KNxvhdDFQ7gQOrutHAX5JMAOQLLqp9yb3HRsj7KTU8cjyYEq7n4lVRwJ" +
       "Po8fCxn5Xyr23Tva/qnimvTZ57vsu14qf2J7BSaZYppmWM7T0LntbdxBiHj0" +
       "ltj2cZ1tP/mDOz934Q374ezOLcGHBnyEtodvft/UtNwwvyFK/+C+33vLbz//" +
       "jfy88H8AvYlPCesiAAA=");
}
