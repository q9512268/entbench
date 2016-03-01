package org.apache.batik.ext.awt.image;
public final class ARGBChannel implements java.io.Serializable {
    public static final int CHANNEL_A = 3;
    public static final int CHANNEL_R = 2;
    public static final int CHANNEL_G = 1;
    public static final int CHANNEL_B = 0;
    public static final java.lang.String RED = "Red";
    public static final java.lang.String GREEN = "Green";
    public static final java.lang.String BLUE = "Blue";
    public static final java.lang.String ALPHA = "Alpha";
    public static final org.apache.batik.ext.awt.image.ARGBChannel R = new org.apache.batik.ext.awt.image.ARGBChannel(
      CHANNEL_R,
      RED);
    public static final org.apache.batik.ext.awt.image.ARGBChannel
      G =
      new org.apache.batik.ext.awt.image.ARGBChannel(
      CHANNEL_G,
      GREEN);
    public static final org.apache.batik.ext.awt.image.ARGBChannel
      B =
      new org.apache.batik.ext.awt.image.ARGBChannel(
      CHANNEL_B,
      BLUE);
    public static final org.apache.batik.ext.awt.image.ARGBChannel
      A =
      new org.apache.batik.ext.awt.image.ARGBChannel(
      CHANNEL_A,
      ALPHA);
    private java.lang.String desc;
    private int val;
    private ARGBChannel(int val, java.lang.String desc) { super();
                                                          this.desc =
                                                            desc;
                                                          this.val =
                                                            val; }
    public java.lang.String toString() { return desc; }
    public int toInt() { return val; }
    public java.lang.Object readResolve() { switch (val) { case CHANNEL_R:
                                                               return R;
                                                           case CHANNEL_G:
                                                               return G;
                                                           case CHANNEL_B:
                                                               return B;
                                                           case CHANNEL_A:
                                                               return A;
                                                           default:
                                                               throw new java.lang.Error(
                                                                 "Unknown ARGBChannel value");
                                            } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pqFzB1bgj/X/BRB7s25oIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e6zj2Hmf5s7O7uzDO7Pjx2633rW9O07rlX0pkZQoZW3X" +
       "4lviS6LebOsxRZEixadIig+l29gGWrsN4Lrt2nGBZNs/7D6CdRy0CVq0SLFB" +
       "0SZBjAIpgr6AxG7QImkTA1kUTdK6qXtI3dfcuTP2nQYVwKNDnu+c8/u+853f" +
       "+chz3vxO5VoUVqqB7+Qrx48P9Sw+XDuNwzgP9Oiwxzf6ahjpS8JRo2gEnt3R" +
       "XvqZG7//3S+aNw8qjyqVd6qe58dqbPleJOuR7yT6kq/cOH1KObobxZWb/FpN" +
       "VGgbWw7EW1H8Kl958kzVuHKbP4YAAQgQgACVEKDOqRSo9A7d27pEUUP14mhT" +
       "+YuVK3zl0UAr4MWVD9zdSKCGqnvUTL/UALRwvbifAKXKyllYef+J7nud71H4" +
       "S1Xo9R//5M1/eLVyQ6ncsLxhAUcDIGLQiVJ5ytXdhR5GneVSXyqVZzxdXw71" +
       "0FIda1fiViq3ImvlqfE21E+MVDzcBnpY9nlquae0Qrdwq8V+eKKeYenO8vju" +
       "muGoK6Dre0513WtIF8+Bgk9YAFhoqJp+XOUR2/KWceV952uc6HibAwKg6mOu" +
       "Hpv+SVePeCp4ULm1HztH9VbQMA4tbwVEr/lb0Etcef6+jRa2DlTNVlf6nbjy" +
       "3Hm5/r4ISD1eGqKoElfefV6sbAmM0vPnRunM+HxH/OgXfsRjvYMS81LXnAL/" +
       "dVDpxXOVZN3QQ93T9H3Fp17hv6y+5+c/f1CpAOF3nxPey/zjv/D2Jz784lu/" +
       "tJf5kxfISIu1rsV3tK8unv7V9xIfal8tYFwP/MgqBv8uzUv37x+VvJoFYOa9" +
       "56TFovDwuPAt+V/NP/1T+u8cVJ7oVh7VfGfrAj96RvPdwHL0kNE9PVRjfdmt" +
       "PK57S6Is71YeA3ne8vT9U8kwIj3uVh5xykeP+uU9MJEBmihM9BjIW57hH+cD" +
       "NTbLfBZUKpV3gKvSBNcLlf2v/I8rNmT6rg6pmupZng/1Q7/QvxhQb6lCsR6B" +
       "/BKUBj60AP5vf6R+iEGRvw2BQ0J+uIJU4BWmvi8s56maxpDlAmeAOjKDEyYg" +
       "Bt05LJwu+P/bXVZofzO9cgUMzHvP04IDZhTrO0s9vKO9vsWpt3/6zq8cnEyT" +
       "I7vFlVdAn4f7Pg/LPktKBX0eln0enumzcuVK2dW7ir734w9GzwY8ABjyqQ8N" +
       "/3zvU59/6SpwvCB9BJi+EIXuT9TEKXN0S37UgPtW3vpK+pnJj9YOKgd3M26B" +
       "Fzx6oqjeL3jyhA9vn59pF7V743O//fvf+PJr/umcu4vCj6jg3prFVH7pvGVD" +
       "X9OXgBxPm3/l/erP3fn5124fVB4B/AA4MVaBDwO6efF8H3dN6VeP6bHQ5RpQ" +
       "2PBDV3WKomNOeyI2Qz89fVIO+dNl/hlg46cKH38WXOSR05f/Rek7gyJ9195F" +
       "ikE7p0VJvx8bBj/57//1f0VKcx8z9Y0za99Qj189ww5FYzdKHnjm1AdGoa4D" +
       "uV//Sv9vfuk7n/uzpQMAiZcv6vB2kRKAFcAQAjP/pV/a/Idv/cZXf+3g1Gni" +
       "ymNBaCWALLITLYuCypMP0BJ090OngAC9OGDOFW5ze+y5/tIyLHXh6IWb/u8b" +
       "H6z/3O9+4ebeERzw5NiPPvz9Gzh9/ifwyqd/5ZN/8GLZzBWtWN5OjXYqtufM" +
       "d5623AlDNS9wZJ/5Ny/8rV9UfxKwL2C8yNrpJYkdlEY4AJU+9IAQJ7RcMBzJ" +
       "0bIAvXbrW/ZP/PbX95R/fg05J6x//vW/+r3DL7x+cGahffmete5snf1iW/rR" +
       "O/Yj8j3wuwKu/1NcxUgUD/Zke4s4Yvz3n1B+EGRAnQ88CFbZBf1b33jtn/39" +
       "1z63V+PW3esMBcKor//bP/rm4Ve+/csXkNhV6yi6ejcI3UprF6v/4X71L6FD" +
       "ZfErZXpYYC0NXSnLPlYk74vOUsndNj8T093Rvvhrv/eOye/987dLGHcHhWdn" +
       "jqAGe6M9XSTvL2zw7HneZNXIBHLoW+Kfu+m89V3QogJa1MBKEEkhIO7srnl2" +
       "JH3tsf/4C//iPZ/61auVA7ryhOOrS1otKavyOOAKPTIB52fBn/nEfqak10Fy" +
       "s1S1co/y+xn2XHn3zIN9ji5iulPCe+5/Sc7is7/5h/cYoeTpC9zwXH0FevMn" +
       "nic+/jtl/VPCLGq/mN27mIH497Qu/FPu/zh46dF/eVB5TKnc1I6C64nqbAsa" +
       "UkBAGR1H3CAAv6v87uBwHwm9erIgvPf8PDjT7XmqPvU/kC+ki/wT59j5ucLK" +
       "r4DrpSPeeuk8O5fr6TOnHtsFsfBKD2/95t/56h985nOtg4IdriUFdGCVM54t" +
       "bosY/i+/+aUXnnz92z9W0ido+WrRKFd2/4EyvV0kf6oc36sxeO/YLhwLkNWj" +
       "UflKEAOVLE91StRoXHmcYDuiSPF3OsUDZL9yFOnHi4Tfe0vnvp5F36v3y0d6" +
       "v3yB3kVGKMiuyMzuA7rIykUyLJLRPUjli5DOHwLp7SOktx+A9EqR+dRDImUu" +
       "Qqo+BNIPHiH94AOQls/Nh0SKX4TUuiTS6tF1nD+HFFC2rC+Lu+ByKK/KFFlk" +
       "f/gcvs0l8UHg+vARvg9fhO8aA8KaMuDJLofwGiNTlHgRxvySGD9ydB3n78H4" +
       "CA6Iobj99OUgPoLzY+oihJ95CCseHiE8vNCKHScw1eL+85e0Yofvs52LMP6V" +
       "h5gz6BFG5B6MlTLzxcuBu1I+u3kO2F+/JLDC7ZpHwBr3AfbjlwTGXATsKw8x" +
       "d1tHwLD7AHvjksDwi4D97Yew2A8fAWvfB9jXLgmscxGwv/uDAyvfwAp0Hz0C" +
       "9tH7AHvzYmDlovKnT2bmUo+0i7z+65dE9C5wfewI0cfug+gf/SCIroLoo8ie" +
       "XxB+9vsCKhvYswB8iB3Wivt/ernReXbtaLePXykmehiBEPP22sEushD6AwMC" +
       "IdfTp6EU73urV3/sP3/xm3/t5W+BeKt3HG8V0iKwRv/L1M1PFDe/cDnszxfY" +
       "h+WHHV6NYqF8i9SXBfyyidoZ0E0w8g7A8dAqxTevs2jU7Rz/+LpCzjrjulyH" +
       "lpAtrWbpqjuoDcSO7FmsObNWK9gn5qYtdRwF79lBROeYBLfzJhJhwyaGNbpr" +
       "h+BgWlPh9UbsqGoydvWez8qjsM44oYwm7bG7jbPRJmbrAhS0J1NXoWE1HMK1" +
       "BIIwHYuRGItrk8zbCXk1YSMDAr821DCwap9iJj2zyclLqjFEKYbDxOmGMkOq" +
       "yksrZm0Y3Mqlo9VS9fV+P4yr1QXkISJkEQFLiDvb72Zcx2eQIS5L06Zgj6fD" +
       "+RrHKdXOZMbWlHQX1jmyaQodeyLb61Yur7vcrGdbVjYYTSRNw6eDeXUg+1Q2" +
       "m28cRoZTgiRySeAcYiYGaYzonUlNHlv6BnYb3sBNJJNuzFi0IUpGKsimb9XT" +
       "aDRYr8UeaWv2YDd1lmyvp/gbLGvOJrJqMbLanDkNh9eGbs5tWsrUhKI+1l7D" +
       "DVFMcMclIt+KfFRmJIrZ+K2BLsjjbbXWjuyaoqfWLJcdasTzomLJa38tip1M" +
       "SFvkONtuhc7W8cb5dNl0xg2WUcAIyBTdtWQL4Xpqt7sNiDRP65nr06TIS1lL" +
       "2BBtoZtMJ6HGoluaT329Gi0Q0x/1hv3aYtObjseZTONERxEyF8fVYcAsVQFj" +
       "N0YmLDl/JfTYzRDtRWvZURdJzxbmk5U6w3Epc1JNrcneTKrV7bBGyKtaW7DG" +
       "0DhKOgOE28YzedydZis6jND+ROZXOJzSq3AwJJoDG18IVXUcNkbjLa+tvZ6n" +
       "kDQ86wjknAkmVsjZrjuZhKv1YNALBKpB0coobRGR6q2F/oAwJ8JY0uGGLYzr" +
       "dX+U9RBC6tby2ra7FOEMTtWVmpgd1FToBuIyGuVaQV0VHAfBJJKD28ocGoap" +
       "3OswQ2lcp5nq1MADctEPcEb1SZ/u7zpe3Zsw69VaXGeoQK04soHYjAuL1Wp3" +
       "upvk7USCprY0VfDViFnM28uRPZ7RKEY1gsyA+XBrkcLUrzsyOdjOvK601EV3" +
       "V18y45pFjsTpPJwziy42QpFW0xMQhDIMQuHVzqQbbLxuE58txhznByOFC5KA" +
       "2kxwbb4eVAfMJqR0xIM6nEvotjzciG5TUqiUw6NVY9RLNs6osahbFt4jOz11" +
       "Q283A3vCb7fEcNdrZq5Ikd1F3+s2jO62W9UMSMC6O4+WRyKRd1dWN1A9cz7J" +
       "KIgLRizLBJ3+oNl2zY20MpAkYWVaZWfzsSg0GUae1zWD7DgmbQebJUJV6aGs" +
       "TsduR0D1prwewe3hYCVMOk2zNnUNno8EP2hhzMDqzE2lmaJdgY2nSe4xG7k1" +
       "IZtKsxqlbcrbKSIZI9R0vWQkn/ZyaaCg66xBdaZ6V0N3DanX66xYqbni7YXu" +
       "GzGvjdBVh0LDwPEbkBFL4krP7Lm3VhTS3vYHOSQNa3l7FBGpj2TjPks3lX6o" +
       "KHCYEI3uKusN5j1i7knIyFY62m6ru5uhJAy8ZJebeC1Moabiqx2tIY7k3Kgv" +
       "2gis5lVKqlJW2nG7k5EJMUKv7tR0ut6merVmWm1BBtbrIvEkq052gm8tq/2e" +
       "O7fkoJ2HU2KHbpYO6vfxrL1k2qzdk0m9yw12HTntzk14MUF1SWacHMUkixur" +
       "HWI57g9nXZiZsnV6M62Lk16AThYzQkpmaWcT2sLMTSFDjxKvykLRYqmmHtNW" +
       "OXEj4Om0D21jJh7FRlWqGxOId2JTpJNhQq7r/LQxCKQhlwMippksHSLN3ojY" +
       "kq0lu8DarZ5Nwti6nc5Xjimb8Fy0+cHAGRNC0nKGSyQx1huupRvkzofzmjUJ" +
       "7G2KqYzCU2HU5SXOp2RymYJ5Tqhk3uwrSzoPV7TDEWO3m8vDdkOE6sO61oIk" +
       "NCbVuZmLuAW32byViSm8hiYDuIHqSVxjcm1EkQwm+YlLkiLZdnJWC/UtgcXy" +
       "OtpVG5nSbqWeOVqtqxR4fVXnYc7goW1lnVqNy5ZrP14kMV3bMSS5DQbEaJzN" +
       "Cd2xW9BwO6vLYrjQRyOVChqRGa4F2mOrDsS1/PpsXpPWW7hrLBb8cpHUNUVX" +
       "RGXFSZ0l1DFW1WzVmrFmItREbKxWpzMCE3pyLOTdPpx31wkx66zNZAwnWLhb" +
       "Y0YsEiJKYbgjkFmzCdzCd2zJbUfZMg+41nrew9ahMxJ0ehUNQOjRXM3pXWOd" +
       "1iOvDWE2EtbYEeeqmiduWTgNMAgiDQQdSUmojtMxoQeOjY3kmb+ue12E2U12" +
       "kRsI/mSJNFGsOZ+Jdt9nCHKijmeqo85JbQQokpkrTcXkZxpWNXc6mqr0huk4" +
       "Nd9U02AwhjFx19QAgQnr5droZ05CbjVHEVMJzAymRVgpQrB1J4234WI+Nthp" +
       "o11dJMa0nbWw3NHWSx+L1rlKrNxp4GcM4DSXqYooUidq82Hm1GF1azXxxBvL" +
       "NTwjCYuze5a4G4V2bZxJCE8zk/qw3e6v+y6ia7zVx0lVnk78GYr7DKvRXTJS" +
       "BHU4XuOMDm82LaQrTGxRHkjsMOE7PiZseTNlqk5XRVEUa6v9Rr9uYjuMnunC" +
       "KqcRG/d2GJtyEi62k7zVgEecCDRYxgnkjZrb+tSdybOMiqotx2vHjisA8qNx" +
       "xOJ3Cb3uaKPdLmt1Pcxdx4nRXfbjdm9MmthwqEBY2g2QHigy4iGU5vAEQvMh" +
       "FzLDruh76hQmvK6aQujcw1tCFe3QjSasQXG+W/Fehmm+i3Yn+g6ZZm1VYeLd" +
       "dhxlu9ES65kEvMkorAFztWpNxwQT2aF1yUSzDqUbmuojyYydtXSvjbfnlCAH" +
       "sxFH+hHhb3eZw6ENNg5MiaVbtWZbDGZbvYlrpj1k9X7EVxeOYOVTDRH8OUIK" +
       "I8FYZR10smq0OsyYGNIUC/f4RUMeyG7AqUiCxP6GaA0xTWXq03kzQ7ojOo7B" +
       "SidVG2HNMRBmOuXzKU2vtJDOWWawCody257i09RiKJP2yTWwHa00BwOWsykJ" +
       "r01DFLW0Tm8OT8Y5S7am/Hq1IFqsPESJXV3i6nFnpSHrxkQwU4i2ULQ/n62w" +
       "nm161DbaNRsYShEuy9EZ1J869oZF7bGhGvo220YUiUbRDscZZoF5tDKzTQof" +
       "L+YGxC9bisFlLsOmkt2P+ZlYH3RzcekRkgyi336oj0lOz8kI1SCyp/dTH4Wo" +
       "btuA6XkvCzpy2yRS2J/zzWZPrfdwYzcVbBTCV6u2ZqYGopldsRWkSzuJICva" +
       "dURCl6a6bTJRm6MEtyXIOqyhq0bEkm0FU9DVBDOCfNjsTfqOBc12/HQyao47" +
       "w6ifQ0ssYKu+SVpwtuUy2DaabEOLoKlv5BbeHuVswOaOiY3aYWuxJmQoZIeN" +
       "RZUwIa7L1pGu7kDtsM3vqi2YEnqq1VqqbNU1hM2M9dd9aBfhiRiJ8Yagptp2" +
       "YuzqeDfk8h3M7XaU0UPk+azmpvUGyarraX/som2RVoR0PHG1dFNrznqJbfiR" +
       "1Yhn0x5KhhYu7brzSaMzdH2/CqOyndsgGlg0kEW4G0OzjElbSwuuVvXabCC5" +
       "po6PIilwN7PcGxK5hVYVIxewNYjeDQ7Bt0stSjaN5oKbLeBtkGPVnUwFcX+t" +
       "Dz2j4fFWlezBWGta3U65hoApXkfZLi0SqSW5jgqeFwdoNDMXNlmduYK+Shh9" +
       "ilDOcjvXjWkA5zGH2V6CLaJqEA22cD019ayOexm8EdcyiPXS0OitIoNX0WjA" +
       "gdi6RTXlZC3OoZ4rqxtVnWS8RsjIAoqSBkRAXq2LiordwPrDuJHo8HSa73px" +
       "Jiu4tdN3K7AIYONuJNmWIbet1syYD0adyShAtEBGKAiyIGpkKEmYLCkAaoez" +
       "2MiYsPRwBWaVjq/l1k6wt94gzppROFhbUhyBWIGXmDhbbJXQHlBuGNc4ZCvV" +
       "GjwydK0qj676bHOTeCyWgCU13/aTpDnJNLM+d2s8v02Yya4+tGGPmNvJXKk3" +
       "miqeWawwV4fbqpVydAtq+fqUgCV1K9uyCk1lMvNnw36yIq2FysoC3uPaNbNL" +
       "p4hua4QBIXpfhad23fTYITdRtEFbwUXZJOjFQqSrjjLgthsGdlgVI3XdGM1n" +
       "KldtUh0HJaB0mcgCDFdT26DtlgaTeq2hQ96yYUs014lH45rpTHx57E5bLjww" +
       "W/awVXfrigNhXL+xzuZReyQNfNhNuw2MZ/EGNjApeYDEm+VkZ03bNUWC8tku" +
       "r7ZD2iOdeZXOh/iiCFDJHjKFmvGkpvADJJzTllMj0l3DWrSSpQg8S+8rZB3l" +
       "RNGejVhzUZ8okewMW9CCmZmZpLY3tdVGtsGLdt8SBSlpiItkYqu+xLHejAhm" +
       "WTys2R689dA+w8NkqzGM17y+jhZEVF2S7NDzqpCXQOgk34Z2fZQMdL/FIU4+" +
       "ccIRwtdbymybTXt93BkoC6s2Z0St3pxyFmo1q61gQ+/w+mK1hmYQLuNYBDf8" +
       "btopv2d983KfKp4pP7OcnK56iA8s9/lGfnDS4eh0N7/8FR+p7jqoc+b71Jld" +
       "yf2WxrvjozMnln94clRt4ejFpuoL9ztoVW4qf/Wzr7+xlL5WPzja6sXiyuOx" +
       "H3zE0RPdOdPPVdDSK/ff/RTKc2anW5C/+Nn/9vzo4+anLnFM5X3ncJ5v8h8I" +
       "b/4y80Pa3zioXD3ZkLznBNzdlV69exvyiVAHAZk3umsz8oUTs98qrPw8uPgj" +
       "s/PnPwuejvfF3wTlvb+UZRfvpP+XB5T9VpF8O65cj/39vnzpY6fu9Z++38eu" +
       "sw2WD379RLcbx588R0e6jf74dXv7AWX/vUh+N65ci/2uV54oQU4V+87/g2K3" +
       "jufHJ48U++Qfv2J/9ICy7xXJH8aVJ0NdXR4d+zyekme2o/c76acq/8/LqJyB" +
       "5s+cMitOzDx3zxnX/blM7affuHH92TfG/648aHVydvJxvnLd2DrO2T35M/lH" +
       "g1A3rFKfx/c79EHxd+V6XHnxwaffwIiW/wXmK4/taz0ZV567X624chWkZ6Wf" +
       "BtR1kTSQBOlZyWeARc9Lgv7L/7Ny74orT5zKxZVH95mzIs+C1oFIkX2ucJMr" +
       "V7IrZ8juyMvKkbr1/UbqpMrZE12FuuVp5WMy2+7PK9/RvvFGT/yRt5tf258o" +
       "0xx1tytauc5XHtsfbjshxA/ct7Xjth5lP/Tdp3/m8Q8ek/fTe8CnHn8G2/su" +
       "Pr1FuUFcnrfa/ZNnf/ajf++N3yiPSvxf5B28OEYuAAA=");
}
