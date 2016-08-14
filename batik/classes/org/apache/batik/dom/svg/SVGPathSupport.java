package org.apache.batik.dom.svg;
public class SVGPathSupport {
    public static float getTotalLength(org.apache.batik.dom.svg.SVGOMPathElement path) {
        org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        return pathCtx.
          getTotalLength(
            );
    }
    public static int getPathSegAtLength(org.apache.batik.dom.svg.SVGOMPathElement path,
                                         float x) { org.apache.batik.dom.svg.SVGPathContext pathCtx =
                                                      (org.apache.batik.dom.svg.SVGPathContext)
                                                        path.
                                                        getSVGContext(
                                                          );
                                                    return pathCtx.
                                                      getPathSegAtLength(
                                                        x);
    }
    public static org.w3c.dom.svg.SVGPoint getPointAtLength(final org.apache.batik.dom.svg.SVGOMPathElement path,
                                                            final float distance) {
        final org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        if (pathCtx ==
              null)
            return null;
        return new org.w3c.dom.svg.SVGPoint(
          ) {
            public float getX() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getX(
                           );
            }
            public float getY() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getY(
                           );
            }
            public void setX(float x)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public void setY(float y)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public org.w3c.dom.svg.SVGPoint matrixTransform(org.w3c.dom.svg.SVGMatrix matrix) {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
        };
    }
    public SVGPathSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwUxxUfn7Gxjb/BxuHDgDFQA7mDJrREpmnAscH0DFcM" +
       "qDEJx9ze3N3ae7vL7px9dkqbpK0grYoQNQn9iKW2REmrJERV6YfaRFSRmkRJ" +
       "KyVFTdMqpFIrlX6gBlVK/6Bt+t7M3u3HnU2pkpNubm/mzXtv3sfvvdmnrpIq" +
       "2yKdTOdhPmkyO9yv8xi1bJbs06ht74e5uPJoJf3H4St77giR6hHSmKH2kEJt" +
       "NqAyLWmPkOWqbnOqK8zew1gSd8QsZjNrnHLV0EdIm2oPZk1NVVQ+ZCQZEhyk" +
       "VpS0UM4tNZHjbNBhwMnyKGgSEZpEtgeXe6OkXjHMSZe8w0Pe51lByqwry+ak" +
       "OTpKx2kkx1UtElVt3pu3yAbT0CbTmsHDLM/Do9oWxwS7o1tKTND1bNO7109l" +
       "moUJFlJdN7g4nr2P2YY2zpJR0uTO9mssax8lnyGVUbLAQ8xJd7QgNAJCIyC0" +
       "cFqXCrRvYHou22eI4/ACp2pTQYU4WeVnYlKLZh02MaEzcKjhztnFZjjtyuJp" +
       "5SlLjnhmQ2T60cPN36skTSOkSdWHUR0FlOAgZAQMyrIJZtnbk0mWHCEtOjh7" +
       "mFkq1dQpx9OttprWKc+B+wtmwcmcySwh07UV+BHOZuUUbljF46VEQDn/qlIa" +
       "TcNZ292zyhMO4DwcsE4FxawUhbhztswbU/UkJyuCO4pn7P4EEMDW+VnGM0ZR" +
       "1DydwgRplSGiUT0dGYbQ09NAWmVAAFqcLJmVKdrapMoYTbM4RmSALiaXgKpW" +
       "GAK3cNIWJBOcwEtLAl7y+Ofqnm0n79d36SFSATonmaKh/gtgU2dg0z6WYhaD" +
       "PJAb69dHH6Htz50IEQLEbQFiSfPDT1+7a2PnxZckzdIyNHsTo0zhceVcovG1" +
       "ZX09d1SiGjWmYavofN/JRZbFnJXevAkI017kiIvhwuLFfT+/54Hvsr+GSN0g" +
       "qVYMLZeFOGpRjKypaszayXRmUc6Sg6SW6ck+sT5I5sNzVNWZnN2bStmMD5J5" +
       "mpiqNsR/MFEKWKCJ6uBZ1VNG4dmkPCOe8yYhZD58ST18u4j8iF9ORiIZI8si" +
       "VKG6qhuRmGXg+e0IIE4CbJuJJCDqxyK2kbMgBCOGlY5QiIMMcxaSRjZij0Mo" +
       "HdwZA4HDOdM0LIAZiDHzA+Wex7MtnKioALMvCya9Bvmyy9CSzIor07kd/dee" +
       "ib8iAwqTwLEKJ+tAYFgKDAuBYRAYBoFhv0BSUSHkLELB0rXgmDFIccDY+p7h" +
       "+3YfOdFVCTFlTswDqyJpl6/W9Lk4UADvuHK+tWFq1eXNL4TIvChppQrPUQ1L" +
       "x3YrDaCkjDl5W5+AKuQWg5WeYoBVzDIUlgQsmq0oOFxqjHFm4TwnizwcCqUK" +
       "kzIye6Eoqz+5eHbiwYOf3RQiIT/+o8gqgC7cHkPULqJzdzDvy/FtOn7l3fOP" +
       "HDNcBPAVlEIdLNmJZ+gKRkLQPHFl/Up6If7csW5h9lpAaE4ho8DJnUEZPoDp" +
       "LYA1nqUGDpwyrCzVcKlg4zqesYwJd0aEaAsObTJaMYQCCgqc/9iw+dhvfvnn" +
       "24QlCyWhyVPLhxnv9cAQMmsVgNPiRuR+izGge+ts7Ctnrh4/JMIRKFaXE9iN" +
       "Yx/AD3gHLPiFl46++fblc5dCbghzqMO5BLQzeXGWRe/BpwK+/8EvQgdOSAhp" +
       "7XNwbGURyEyUvNbVDSBNg8TH4Og+oEMYqimVJjSG+fOvpjWbL/ztZLN0twYz" +
       "hWjZeGMG7vwtO8gDrxz+Z6dgU6FgSXXt55JJnF7oct5uWXQS9cg/+Pryr75I" +
       "HwPEB5S11SkmgJMIexDhwC3CFpvEeHtg7aM4rLG9Me5PI0/rE1dOXXqn4eA7" +
       "z18T2vp7J6/fh6jZK6NIegGELSPO4ANyXG03cVycBx0WB4FqF7UzwOz2i3vu" +
       "bdYuXgexIyBWAdC191oAk3lfKDnUVfN/+7MX2o+8VklCA6ROM2hygIqEI7UQ" +
       "6czOAMLmzY/fJfWYqIGhWdiDlFioZAK9sKK8f/uzJhcemfrR4u9ve2LmsghL" +
       "U/JY6mW4Vow9OGyUYYuPt+aLxhKf6jmM5edpkeWzNSaiqTr30PRMcu/jm2X7" +
       "0Oov9v3Qyz7963+/Gj77+5fL1Jpabpi3amycaR6ZlSjSVymGRM/motVbjaf/" +
       "8OPu9I6bKRI413mDMoD/V8Ah1s8O+kFVXnzoL0v235k5chN4vyJgziDL7ww9" +
       "9fLOtcrpkGhQJdSXNLb+Tb1ew4JQi0EnruMxcaZBZMvqYgB0oGPXwnedEwDr" +
       "gtkigblsNIVENAES2uKO4IaVCJeWObgGcKLCaQvwfwcnPXO1HXuHsPHAqxXE" +
       "hdDuU3Ogzr04fJKTxjTj+8EfGtT2NM/4GxCMl+FcwoZmQc1CARl3OuYPx44o" +
       "J7pjf5ThfEuZDZKu7cnIlw++MfqqcHwNRlrR3J4og4j0lL1mHMKYUj1z3D/9" +
       "+kSOtb499o0rT0t9gu1+gJidmP7ie+GT0zLV5J1odcm1xLtH3osC2q2aS4rY" +
       "MfCn88d+8uSx4yHH5IMcS7RBeYl7obr7bSg1vfvhpp+eaq0cgBQeJDU5XT2a" +
       "Y4NJfxjPt3MJj1HdS5Qb1I7OWHehIV1fAMStOOyTz9v+TyzGiR2mmB8qBnk7" +
       "rn0IvpucIN9006mDw4EyaTMbx0Cgh1xW9+BwREgcnyMdxABg2wrpIPp3lt7O" +
       "nZTApcOO3/GHep6hK65U9RKP4t9Rj5mPfgBmXoprG+C71THK1vfNzLNx/J/M" +
       "/PAcZv4SDp/jpBnNbIDhfEYGhOtAhJu4TfHdp4yChYUtP/9+2DIPyOe/qmFf" +
       "0VHyDki+t1CemWmqWTxz4A1RTIvvFuoB1FI5TfOkozc1q02LpVRx7nrZi5ni" +
       "54xzzHJADuEEo9B6WlKfhXtXOWqghNFL+XWwa5ASIEf8eulmOKlz6aBKyQcv" +
       "yTeBO5Dg47fMgm+aRdeF73/C8mVHvqK0sxIuaruRizyN02ofyot3dQUgzMm3" +
       "dXDhndm95/5rH3lcXnMUjU5NIZcFAH/yMlXsG1bNyq3Aq3pXz/XGZ2vXFFDZ" +
       "d83y6iYCBXJZXEmWBPp+u7vY/r95btvzvzhR/TrUk0OkgnKy8JDnTZm0FFwe" +
       "ctCwHYqWwjz0WOJC0tvztck7N6b+/jvRtDplYdns9HHl0hP3/ep0xzm4uCwY" +
       "JFVQcFh+hNSp9t2T+j6mjFsjpEG1+/OgInBRqearIY0YxBTf4gm7OOZsKM7i" +
       "/ZeTrtK6WPrWABr8CWbtMHJ60qlCC9wZ30tEJzHqIOMCG9wZTyugSqBFb0A8" +
       "xqNDplm4PNZ82xSZPFoeeXG8IB5x+MF/AX161g7HFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bfiTyRngiLeUL+GX0Pz9jQXio0V7MW+e2Gk9774GeGxQZI8AY2k6slXQeTIE" +
       "FmMpFw98dAKySaDiiysLL8i8HOTPhXXkwlzapWC7WJW3lR0XRb92XWu4fMAr" +
       "2P27johxLsjm3v9PH/jqrz7+TbBFLHTLNlcf2JljK/aiPMH9xec+9OBLnvnW" +
       "+4sABKLP5Jd+D/9WTrV7I4nzhsyb9oGo9+eiisX3m5ODkC/ihKYW0t7QMvu+" +
       "aYPQut3P3pCn7vnm+qPf/vQuMztthqeAtfc988s/vPT0M3vH8uHHr0pJj+Ps" +
       "cuKC6Tv3NexDj95olQKD+ufPPvXHv/vUe3dc3XMyu2uDw8un//p/vnrpI9/6" +
       "8jWSi5st98fY2PDOCzQWMMTBj5vMl9N4nCTjpYN3ktUCaSYRTeokNSBwm2T9" +
       "YduzHSJQaJSkFH5DttmkkWmVXkXW8C2He0lDXW8WXhfV/bk76A2chtmdlodt" +
       "22fbw0ltvpSHlDi010O2m06okcpvPIrxrVlNb1qTLlJrhnCI85WoQjvjsrf2" +
       "etHCRuxsFm4rwXK7VW3H95hNOe2qI0E1+vY6FRrptp6YpQW7CNCaEeKYVo36" +
       "rMsuKzQmhjium8OaQYt2ly6v22zY2xApN7X7a2G6WTjCplvPtLiki2p9EEir" +
       "nu/Q3ARtq4xddvvSutSbTAaw1BpIbSNdTzwRHfNY2JPo1aLXNGLeSbsdXWxL" +
       "XjvUtZlWE9azFc2LklaP0b5WLVnNdBP7KSyvhZHXTcrrdVIah21rEla8qJIS" +
       "ixHaWozsgCY5HiHdhjtNYhF3S2F31CNLi56Al9CGZbtjlrJYtYfrmOOX++X5" +
       "vJx57BCNRkLDDgI5qVtO2pmMFxwxqCesig/0HsG2mLSFKtRm1vKH2zntRuWy" +
       "xmAI0fLK3mgwH2NTbeLMrS4nGWiZl9uZ0l0ZWehQ0moVphHrVUWLWzmGPSiP" +
       "aqjS71VqwXokCmtRndLjIUpZAqFLxIBPfYaVQmexRu0p3WqHwsrAbWq9KakD" +
       "YBFCGHr+tKvATTgO7VixlVSMDRQfT+AmLUjReLywVhRWm7QHpINsLEYeKT2p" +
       "3ChnqcELGBkrQRujEjkeGwvAXhAvxsh4zaZRS8A8B+9j7TZPTuGJ0+FRaVgi" +
       "UzXWh54ldszxCFU788UAbfSIqT0hCGqjcKw96aq+7PHufLTgsaEtEpwpz/Su" +
       "N+0Q3YrSY6ZsU1DidsgRFp7CwnLj2KiDN9RKTaREYuQ6ttw1ED3Ux2VVR7Pa" +
       "dG7IZJ8lFrWGStM1OsyqKNMecO3FgDLFZZ8clWBcLvedRFLWmcqkPToYuWhm" +
       "KNpEcbedkjRDG2pJNDurqT2Xt+6yh7BDaUE57EzbEmsGLeFrk9kaccRRyxGM" +
       "VDF6G/hwR+yh+mYy5zlJo4SON1x1U08OMjmdDe2xUhP1mjitKWs4GFWZatDL" +
       "Jr2p5PTKCzG0ebLKVsGnY9MLhghPtbvTboutRU2pNOl1MNVe91uCVk/nhkRW" +
       "6+KoVI+wVd2kGsLQZCSmHpiTbqe2MaKh3ZnpsIYyTBtrLdiIZVvkJkm75fWC" +
       "15stoWPNqwOT4XklkcXhSjJXKO/SaiwRGE0KKo9yDCGZJJ0R8FRLcD50uqZL" +
       "cPy2lcqN5tZO00ZLzBjXR/G1iqiaZi7qJhFvRjHX7rJwSMwpvUsSUXM+JOZN" +
       "lzK2aFMci/Saa3NN1J/pNkkxikLOYQ834Mp8KajUpDWirFEQk5uU9awaMm1w" +
       "a2xMkNuI7sLhlNqUtFmPw0bMtmV43sDvjwclLqnMfVJurVekVZ1WYaIbDaZ6" +
       "darN3eYkI5mxpQ8Ce4O6ApVsVjRlY6PYMbNYaW3G3XXGpFqt7W4yuKrRCzOe" +
       "C8vKEKhlhMBuXd/oLVyh1/0xt2EzNSO3KUKFgoNblaXQp8me0uwTE6vNqFzP" +
       "ZiVY7w7X3KBPUxYy9mrMEleCadVoWB4htzHDrZOsM25LfZf0uDlRcjbjDunF" +
       "qd/KJkrX0rFsowXzmFVRuS0TgbAYsTI/H7Ra+kZBGmYMq8Z2uXWcMjawWunU" +
       "SCd9zkicbUMBjm4HE73XN4fREDazjq7BYYC3Qsc3MITlmWGXkmfthtmbJwhB" +
       "VnSa65uUhdVgeLmwlKraWuhGtuGFapMbZNqsMx1qSNOLuzBSb28HuiqIhOHh" +
       "s1686IyHaTsdb3uLCSk2e3p9RGOCDrttfr4x7Qm7EjvwUth6q+mCQ7JQ4npo" +
       "GM8zY7qStA7fwbdxKNR10k8yWKqp+rhG6eJsFlarLOtQuKuE1Wg6G4gNRUfg" +
       "vp/6eJWh4367WRVLJXFt60AYLSGNuFVpUd62rdGhjss85nOdBq9V+wyK+O2S" +
       "KsxmGwfTCDwr1UflrYezNWRp1FZSt9ZjNL3T5sS+gBG9dNZBK8okVZoJOm1i" +
       "1IbCx1ksZGWzso0W6jya6VrCpM0pobZKjZJLrCvWsks64wkIBDDOz8ouXJ+s" +
       "rRZRGwp82Uh1ZtNm8PGgpmQCwXN2NkeW7HI63zAdY6qapEWZrkR0G0G3W18i" +
       "UcaCSGMv/SEWNbZambMD3eDGCDuv2VNs4sYNoZOO5/OoH8IylxjdZW1l81Vw" +
       "2ltr06wnyuZm5FfQ/pBXImRll2c4KrjbxrYySDO8UavASGeF43B1yZVYT154" +
       "ZkW2U0Ue1iRLXImT1O4MecR2w8liJS+RutCPGkxt0R0yWKlik7xLIpM6YZSC" +
       "ugCvqcnMyVwO3ZYr1XVVMXrYNmX1zCQ5PI4bjSUnhIrvrTvGgFVF4KQLeLQo" +
       "aTHGDky07fgRnyiy1JT47WauN1G305/Fjqa2Y9LXw7WpL6ygx0zaPaItlqOu" +
       "gDHypMVqU2Ghd5Qu15IH23gZK05/JpToWUQHfZrYJLO2oZLRuCLomY9iS7Y7" +
       "SlajFVxvLzvhqNzjEayTtHgLppTYleyBUmoRQ6siRPN+gmEui3urZXVkLNuR" +
       "RErdCFccxophmF9uNgod94aWP6ywmKtjK9TiSjbNd+fjVSmrkEgDXotCuMAa" +
       "DRf1R2jY0KMSrLOmavdxU4M7IzTjJlW25KqKXUq4kK64Qau8Kcsi5s/5Zcup" +
       "11W4HokJltJ0leEVER82tbmFuwsfX4h6CTg6CHCwJm9QRW8ONJYcV2ejsjzH" +
       "euwyWfXDCs+uSrQqVgeLEoMLU1ozmElpSfBiKAjpKGts4VGadcxh2bab9U3T" +
       "WeO+gzJbL1KYXgNFazYZY+1UHvGLBG3pRimZNuBmPGzripPyakI09XIMMrq+" +
       "V7FCXHCkEeEpglBBOrTm1YxurTpuDLt9LGwMV1W7v9Sb9sz1/A7cwksjugsE" +
       "6GVcL0FYhEf6hCJtMZH0kJXXdHoLhgQ6n3cMISQMNsJGS1r1sLRlzMdhH6i2" +
       "TDL9VNCQjU0t0QmdkmsTDkstzZ7am+koyTCiNARfgC0Vuc0SxVRHS2HtZkpp" +
       "g5Y5bzJMcMeXzKpjVrEky2iWIKN22200a1OruzRm4Qykl7rRozh4No3lKiEy" +
       "7WVdiyxb6FpZTW5204GyTUdaU6iSOoYved2G5aGqUXgFadXtCb3ddNEgYSLZ" +
       "j4ZmlvbQsrtM3bCiDsZ6xtsVdUYajmo3qkjVpyuWMnP48Wpc7TGSQhE0kvLW" +
       "LOiADDLdVIhNxZtlyKwjlbcziiIltV5Ja+a81Zyx0qxtT5t9D47w7RzxG9VF" +
       "uM22mTFERv54jQpr3emmdZZ0RpKNUlQMzsStmJ5vpvEqQ6cC20IBfKis8V5t" +
       "ASOr7TAkPWuuOkGDpi3U6FcQzUOTzMaiVjxnqclAoQzY6IleIyyP4FXNXlHB" +
       "ymt3SjAi6IzTHG40cK6eo/OkOVpiuo0LghR0edxEJG3kh93atO9PiaZfb00X" +
       "IU+zNXRjtVqNWKqgYZvN6A0j8K0OeB+lkS5umtQCJerJpge4srF+T6qXE1Hq" +
       "U64Gvj91pllNYJ5CiFmpVtJxmooJIj8avenFnU7vLg7ihxcj4FCaT3RexKls" +
       "N/Vo3rzqsPhY/M7eoPh4rEAD5SfNB69331GcMj/+rmeeVYVPlPb2C1vTELo9" +
       "dL2ftrStZp2q9bz2+idqvrjuOSq4fPFd/3r/6A3GW15ESfnhU3yeJvlJ/rkv" +
       "d16tfHAPuumw/HLVRdRJpMsniy7nfC2MfGd0ovTy4KFm78s19mrwPLGv2Seu" +
       "Xda9phXsHVnBzgBOFQ/P7Ffn96swT96o+i/wef0/v+/UnLCg5t+gFLnNGzuE" +
       "7tK1cATUbHGao4dGATs8ZmKTvFJkuXJ4ZHzOjyoJHF+rGFgdauvefPA14EH3" +
       "tYX+P2pr7wiqGEsKqHffQAvvyZu3hdA9QAvF7YmmE+H1NXGT6RzTw9t/DD28" +
       "Mh+EwVPf10P9J66HD95AD8/kza+E0IVcDy6Q8oQWgOXdl1teXFFOXDe5J9Tx" +
       "9ItRRwIs7+SNVV5yv++qq/Dd9a3ymWfP3/aKZ8d/U1zaHF6x3s5Bty0jyzpe" +
       "IT3WP+v52tIs5Lt9Vy/1ij8f2xfnWo4E9hi0Bbsf3UH/Zgi97FrQABK0xyF/" +
       "C+jvNCTwnuLvcbjfDqFzR3AhdHbXOQ7ySUAdgOTdT3nXqMHuCsrJmZNR+3Ar" +
       "7vlRW3Es0D9+IjwX/7JwEEqj3T8tXFE++yzbe+sLtU/s7p4US86ynMptHHTr" +
       "7hrsMBw/el1qB7TO0k/+4K7P3f6qg0/HXTuGj8z9GG8PX/typ217YXEdk/3R" +
       "K/7g9b/z7DeKkvD/AfmVCz1LIgAA");
}
