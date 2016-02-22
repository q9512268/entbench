package org.sunflow.core.filter;
public class MitchellFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return mitchell(x) * mitchell(y);
    }
    private float mitchell(float x) { final float B = 1 / 3.0F;
                                      final float C = 1 / 3.0F;
                                      final float SIXTH = 1 / 6.0F;
                                      x = java.lang.Math.abs(x);
                                      float x2 = x * x;
                                      if (x > 1.0F) return ((-B - 6 * C) *
                                                              x *
                                                              x2 +
                                                              (6 *
                                                                 B +
                                                                 30 *
                                                                 C) *
                                                              x2 +
                                                              (-12 *
                                                                 B -
                                                                 48 *
                                                                 C) *
                                                              x +
                                                              (8 *
                                                                 B +
                                                                 24 *
                                                                 C)) * SIXTH;
                                      return ((12 - 9 * B - 6 * C) * x * x2 +
                                                (-18 +
                                                   12 *
                                                   B +
                                                   6 *
                                                   C) *
                                                x2 +
                                                (6 -
                                                   2 *
                                                   B)) * SIXTH; }
    public MitchellFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4C+wTRwwXwbJBO5CG9pGping2MHkDBYm" +
                                                              "tDUtx3hv7m7x3u6yO2ufTdwmqBX0iyIChFYNfxE1iZKAqkZt1SaiitQkSlop" +
                                                              "UdQkrUIqtVLpB2pQpeQP2qbvzezefpxtRNWcdHN7M2/evPfmN7/3Zp++Rqps" +
                                                              "i3QznSf4tMnsxIDOR6hls0y/Rm17L/SllUcr6D8PXN11d5xUj5GmPLWHFWqz" +
                                                              "QZVpGXuMLFd1m1NdYfYuxjI4Y8RiNrMmKVcNfYy0q/ZQwdRUReXDRoahwD5q" +
                                                              "pUgr5dxSxx3OhlwFnCxPgSVJYUlyW3S4L0UaFcOc9sWXBsT7AyMoWfDXsjlp" +
                                                              "SR2ikzTpcFVLplSb9xUtcodpaNM5zeAJVuSJQ9pmNwQ7U5vLQrD6UvMHN07m" +
                                                              "W0QIFlNdN7hwz97DbEObZJkUafZ7BzRWsA+Tr5CKFGkICHPSk/IWTcKiSVjU" +
                                                              "89aXAusXMd0p9BvCHe5pqjYVNIiTVWElJrVowVUzImwGDbXc9V1MBm9XlryV" +
                                                              "Xpa5eOaO5OlHD7T8qII0j5FmVR9FcxQwgsMiYxBQVhhnlr0tk2GZMdKqw2aP" +
                                                              "Mkulmjrj7nSbreZ0yh3Yfi8s2OmYzBJr+rGCfQTfLEfhhlVyLysA5f6rymo0" +
                                                              "B752+L5KDwexHxysV8EwK0sBd+6UyglVz3CyIjqj5GPP/SAAU2sKjOeN0lKV" +
                                                              "OoUO0iYholE9lxwF6Ok5EK0yAIAWJ13zKsVYm1SZoDmWRkRG5EbkEEjViUDg" +
                                                              "FE7ao2JCE+xSV2SXAvtzbdeWE0f0HXqcxMDmDFM0tL8BJnVHJu1hWWYxOAdy" +
                                                              "YuP61Fna8fzxOCEg3B4RljI/efD61g3dl1+WMrfPIbN7/BBTeFq5MN70+rL+" +
                                                              "3rsr0Ixa07BV3PyQ5+KUjbgjfUUTGKajpBEHE97g5T2/+uJDT7G/xUn9EKlW" +
                                                              "DM0pAI5aFaNgqhqz7mM6syhnmSFSx/RMvxgfIjXwnFJ1Jnt3Z7M240OkUhNd" +
                                                              "1Yb4DyHKggoMUT08q3rW8J5NyvPiuWgSQmrgSzbCt4rIj/jl5PPJvFFgSapQ" +
                                                              "XdWN5IhloP92EhhnHGKbT9qOntWMqaRtKUnDypX+K4bFkrA24CY5rHIlzzRt" +
                                                              "UPxNIMDMj091Eb1aPBWLQcCXRY+7Bidlh6FlmJVWTjvbB64/m35VQgnh78aD" +
                                                              "k3WwXsJdL4HrJeR6ifB6JBYTyyzBdeWewo5MwNkGcm3sHf3yzoPHV1cAmMyp" +
                                                              "Sggniq4OJZl+nwA81k4rF9sWzay6sunFOKlMkTaqcIdqmDO2WTlgI2XCPbCN" +
                                                              "45B+/CywMpAFMH1ZhsIyQELzZQNXS60xySzs52RJQIOXo/A0JufPEHPaTy6f" +
                                                              "m3p431fvjJN4mPhxySrgLJw+gnRdouWe6IGfS2/zsasfXDw7a/hHP5RJvARY" +
                                                              "NhN9WB0FQjQ8aWX9Svpc+vnZHhH2OqBmTuEoAet1R9cIMUufx9LoSy04nDWs" +
                                                              "AtVwyItxPc9bxpTfIxDaik27BCtCKGKgIPjPjpqPvf2bv3xSRNLLBc2BJD7K" +
                                                              "eF+Af1BZm2CaVh+Rey3GQO7dcyOPnLl2bL+AI0ismWvBHmz7gXdgdyCCX3/5" +
                                                              "8DvvXbnwZtyHMIcE7IxDHVMUviz5CD4x+P4Hv8gZ2CG5o63fJbCVJQYzceV1" +
                                                              "vm3AZRocegRHzwM6wFDNqnRcY3h+/tW8dtNzfz/RIrdbgx4PLRtursDvv207" +
                                                              "eejVAx92CzUxBXOpHz9fTBL0Yl/zNsui02hH8eE3ln/vJfoYUD3Qq63OMMGY" +
                                                              "RMSDiA3cLGJxp2jviox9Gpu1dhDj4WMUqHnSysk331+07/0Xrgtrw0VTcN+H" +
                                                              "qdknUSR3ARZLELcJMTiOdpjYdhbBhs4oUe2gdh6U3XV515datMs3YNkxWFaB" +
                                                              "csLebQFLFkNQcqWran73yxc7Dr5eQeKDpF4zaGaQigNH6gDpzM4DwRbNz22V" +
                                                              "dkzVQtMi4kHKIlTWgbuwYu79HSiYXOzIzE87f7zlh+evCFiaUsftQYXrRNuL" +
                                                              "zQYJW3zcWCwFS3yqFwhWQGdMPC/lpLMsKcgsgIFdPl/FIqqtC0dPn8/sfnyT" +
                                                              "rCvawlXAABS5z/z2368lzv3hlTlSUR03zI0am2RawKYKXDKUSYZFMeez2btN" +
                                                              "p/74s57c9ltJItjXfZM0gf9XgBPr508KUVNeOvrXrr335A/eQj5YEQlnVOWT" +
                                                              "w0+/ct865VRcVK4yFZRVvOFJfcHAwqIWgxJdRzexZ5E4TWtKAGlFPCx1QeKB" +
                                                              "JXSaJHELtGEzUJoqcFi/wNQFyOILC4yNYTPKSU2O8VFgoXAxgXs76ozbkPjV" +
                                                              "AiSDSbfs/cTIQeV4z8ifJPRum2OClGt/IvmdfW8dek1sUi2iohSaACIAPYEU" +
                                                              "1oJNAuHfu8AlMmxPcrbtvYkfXH1G2hOt2SPC7Pjpb36UOHFaHgt5sVlTdrcI" +
                                                              "zpGXm4h1qxZaRcwY/PPF2Z8/MXss7sb6fo7p1qC8tBOxUgW3JBxDaem932j+" +
                                                              "xcm2ikE4bkOk1tHVww4byoQhV2M744Gg+jchH4CuzZhDOYmt98jtM9jslc9b" +
                                                              "/kdexY7tpujfHYb5EhevHm5vEebzTY1AOS4MiePfA6IRqu0FAO9gA3eqCgC8" +
                                                              "mOHHwvgYYtGGY13wbXIdalogFmUJBs6laamTUOQUwyFqWEBjxPmYn6tkdI4u" +
                                                              "EJ2vYXOEk9qCeyWJhOjB/0eIipw0ha88mJ+Xlr1EkRd/5dnzzbWd5x94SySd" +
                                                              "0uW8EQgl62ha4CgEj0W1abGsKnxqlDWNKX6+PVfGldcwjq9J8EHY/S0p/11O" +
                                                              "WqLynFTiT1DsFCcNATGOx1I8BYXOAOpACB/Pml7+bxFlCb4ZScjXAMVYeekh" +
                                                              "Yt9+s9iXpgTrcKRO8RbLYxdHvseCG+H5nbuOXP/U4/IeoGh0Zga1NACnyNtG" +
                                                              "KXGumlebp6t6R++Npkt1az2qC91DgrYJBAAcRc3eFSmM7Z5SffzOhS0v/Pp4" +
                                                              "9RtA0vtJjHKyeH/gHZKMFFTXDlQs+1Pl3AlFhqjY+3q/P33Phuw/fi+qOpdr" +
                                                              "l80vn1bGHnl76NLEh1vFa5MqYHFWHCP1qn3vtL6HKZNWiIibEI0U32eJOLjh" +
                                                              "W1TqxQshJ6vLk0v5NRoq3ilmbTccPeNSeYPfE3qd5tUajmlGJvg9gXyak+yP" +
                                                              "0Qf8pVPDpundpkxTnMj8XFyRF5OfFI/YPPVfXlo9TtAWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU5e+zsWFm9v/u+LPfevcDuurJPLugy8GtnOs9cwJ3pTKft" +
       "TKeddqadGZFL3+1MX9N2Ztri8jIIgQQ3uOCSLGuiEJUsjxiJJgazxigQiAmG" +
       "KJoIxJiIIgn7h2hExdPO733vXrJBJ+mZ03O+7zvfu98557nvQ2fDACr4np0Y" +
       "thftanG0O7cru1Hia+Eu1a+wUhBqKmZLYTgCYzeVRz9/5Yc/etK8ugOdm0Gv" +
       "kFzXi6TI8tyQ00LPXmtqH7pyONqxNSeMoKv9ubSW4FVk2XDfCqMbfehlR1Aj" +
       "6Hp/nwUYsAADFuCcBbh5CAWQXq65KwfLMCQ3CpfQO6FTfeicr2TsRdAjx4n4" +
       "UiA5e2TYXAJA4UL2LgChcuQ4gB4+kH0r8y0Cf7QAP/Ubb7v6+6ehKzPoiuXy" +
       "GTsKYCICi8yguxzNkbUgbKqqps6gu11NU3ktsCTbSnO+Z9C10DJcKVoF2oGS" +
       "ssGVrwX5moeau0vJZAtWSuQFB+Lplmar+29ndVsygKz3HMq6lRDPxoGAlyzA" +
       "WKBLiraPcmZhuWoEPXQS40DG6z0AAFDPO1pkegdLnXElMABd29rOllwD5qPA" +
       "cg0AetZbgVUi6P4XJZrp2peUhWRoNyPovpNw7HYKQF3MFZGhRNCrToLllICV" +
       "7j9hpSP2+f7gTR9+h0u4OznPqqbYGf8XANKDJ5A4TdcCzVW0LeJdr+9/TLrn" +
       "ix/YgSAA/KoTwFuYP/zlFx5/w4PPf3kL87O3gWHkuaZEN5VPype//mrsscbp" +
       "jI0LvhdamfGPSZ67P7s3cyP2QeTdc0Axm9zdn3ye+4vpuz+tfW8HukRC5xTP" +
       "XjnAj+5WPMe3bC3oaq4WSJGmktBFzVWxfJ6EzoN+33K17Sij66EWkdAZOx86" +
       "5+XvQEU6IJGp6DzoW67u7fd9KTLzfuxDEHQePNAbwXMW2v7y/wgSYdNzNFhS" +
       "JNdyPZgNvEz+ENbcSAa6NeFw5eq2t4HDQIG9wDh4V7xAg8HawG9g2ooUU7Nt" +
       "PH/dzRzM//8jHWdSXd2cOgUU/uqT4W6DSCE8W9WCm8pTq1bnhc/e/OrOgfvv" +
       "6SOCXgfW291bbzdbb3e73u7x9aBTp/JlXpmtu7UpsMgCxDbIenc9xv8S9fYP" +
       "PHoaOJO/OQPUmYHCL558scNsQOY5TwEuCT3/9OY9wruQHWjneBbNeAVDlzJ0" +
       "Nst9Bznu+snouR3dK+//7g8/97EnvMM4OpaW98L7VswsPB89qdXAUzQVJLxD" +
       "8q9/WPrCzS8+cX0HOgNiHuS5SAJ+CVLIgyfXOBamN/ZTXibLWSCw7gWOZGdT" +
       "+3nqUmQG3uZwJDf35bx/N9DxLrTXHHPkbPYVfta+cusemdFOSJGn1Dfz/ie+" +
       "+Zf/jObq3s++V458z3gtunEk4jNiV/LYvvvQB0aBpgG4v3+a/fWPfv/9v5g7" +
       "AIB4ze0WvJ61GIh0YEKg5vd9efm33/7WJ7+xc+g0EfjkrWTbUuKtkD8Gv1Pg" +
       "+Z/syYTLBrbReg3bSxkPH+QMP1v5dYe8gexhgzDLPOj62HU81dItSba1zGP/" +
       "68pri1/41w9f3fqEDUb2XeoNP5nA4fjPtKB3f/Vt//5gTuaUkn29DvV3CLZN" +
       "ia84pNwMAinJ+Ijf81cPfPxL0idAcgUJLbRSLc9RUK4PKDcgkuuikLfwiblS" +
       "1jwUHg2E47F2pMq4qTz5jR+8XPjBn7yQc3u8TDlqd1ryb2xdLWsejgH5e09G" +
       "PSGFJoArPz9461X7+R8BijNAUQHf5pAJQMqJj3nJHvTZ83/3p392z9u/fhra" +
       "waFLtiepuJQHHHQReLoWmiBbxf4vPL715s0F0FzNRYVuEX7rIPflb6cBg4+9" +
       "eK7BsyrjMFzv+0/Glt/7D/9xixLyLHObj+sJ/Bn83DP3Y2/5Xo5/GO4Z9oPx" +
       "rWkYVGSHuKVPO/+28+i5P9+Bzs+gq8peuSdI9ioLohkoccL9GhCUhMfmj5cr" +
       "22/zjYN09uqTqebIsicTzWH6B/0MOutfOjT4Y/EpEIhnS7u1XSR7fzxHfCRv" +
       "r2fNz221nnV/HkRsmJeNAEO3XMnO6TwWAY+xlev7MSqAMhKo+PrcruVkXgUK" +
       "59w7MmF2t7XXNldlLbrlIu9XX9QbbuzzCqx/+ZBY3wNl3If+8cmv/dprvg1M" +
       "REFn15n6gGWOrDhYZZXtrz730Qde9tR3PpQnIJB9+LMvfDOvE3p3kjhr2lnT" +
       "2Rf1/kxU3lsFitaXwojO84Sm5tLe0TPZwHJAal3vlW3wE9e+vXjmu5/ZlmQn" +
       "3fAEsPaBpz74490PP7VzpBB+zS216FGcbTGcM/3yPQ0H0CN3WiXHwP/pc0/8" +
       "8e8+8f4tV9eOl3UdsGv5zF//99d2n/7OV25TW5yxvZ/CsNFdzxDlkGzu//rC" +
       "VBc34zgWdQZtwGWssBlxm81kI1MtpoJ1G37XB45UoolFuzV1ovY4ilFzXXNq" +
       "MbqqJkxppY/UjbNsTRArITETnw70uFO0Zr3mcjGLirxkWdFwwdueP1aHi2BM" +
       "LiOh77dK/tDXhmxpKa9TLdV0P464gaioxKBGl2BtzerOoAajM79Q4JZ+aKHD" +
       "1OX1ckS7YUy2Ga5q2iGSwJxTrPVh3rbHSlBt19nJoFhUK/F4Xuk6bF8kcHGZ" +
       "DmeC352s6D6uFp3iQJ3q01U8J8vTOmcNAtrpCcpAnybIEp4NNyo35rRJm/Mk" +
       "c9OuLP2xEVTUmI9jlDHtDe5iMWvwAjUd24mI8uU+MpZwhVEaoThphaNaM6E9" +
       "UW9Pwrnt81zJWqQjX8GBwDYvN+JxpHiqLw3oSqo1KWHFU8OG7ww2w9q4su4P" +
       "g3Z1vKaJAVJzRGRI4vZAHdTMTdqoteUOI8+oxVjSZ7VWyolhszAKKlgP7y5I" +
       "jGD5BUyKI6Vn8cJ8XG9Ik+YqnNAq4jdaa4zQKv5yPhUGpDUSxI5NBYK3EcYp" +
       "6Wy6bXmiNIQi3XIaEztIhIkvVTRGYiqMTbRro/qSJJF5BXcEroEr8XBjhLQ1" +
       "jVtDwTRdO0CiRak7o9XeclOSWHqxsp15MK+5vBxoMyQx0alu1cMS40zTFhUU" +
       "gi6mD0d6v6Obpi0k/SRsVvRqkDge0qpVSoV+pdfeaDERJ6FQ72x6SNhSC9Ux" +
       "CA0hRbGEnC+BWVkW5pvNcSnszRltgNg9gfHGDGJNwYeu07DjDV5lFpVOD0ma" +
       "ZFOkimjaC4WpU+RnXtsRuQXXrXTkRaczF6xx28A7NckrUVinEPNCiZ8011Eq" +
       "q5rYQXSEmCyVmG47bZxGon69RbkCQa2KpihOY6apJtMVWy3irlTX05jBOgba" +
       "KnP2nIQ1vV0tGqhqFwsiHegsKQNPbrVGGr6s0IMaUgj6BTQIA4SMJaTWElA2" +
       "GVYKvfFcNub6eDzq9qS53+oQnUbNqIxKcGFFtUe1LhyP3UanZ4ttGvGbZEXC" +
       "pYGxNJdpzaGrYWK6Do/zMczR69jQyflk4+JUkXIjdAYiqowwi7E5UItTudxO" +
       "iJ5hePR4hNSXaCDWqcogWbPWSjT4oRMYfCpjUTkg59nBCstSaxw3eMkfTlRx" +
       "UCFN22MbpQ6wP9HtyaPGknEjkV5KXNQbu+3EnxR6ZRlfBM1SGZtWAoK005SL" +
       "xmw8IOk2PUcaxY5clNiW2B8q2ISbFmotS7XNKm47lCCO5mu5VS3DDloRhoZr" +
       "1upSe4GKm0lIqf0yEVAaV7X0VpVqTUdJkraAqbSNV6E3g0VXcdCQ0NEk9VhC" +
       "KCpNh0583jBca1lmqJldcDfNenFRDnAQrKmUVMH+DGd6Nr0YSUuFVJdOmymJ" +
       "I9sgSxOMlbFBudIqwFiyof0mThPFmRmSybDTT2fDwYSvInHCp2GlxFFDkpl4" +
       "cBOhVjrbIVhplFR1B/XLaFFfz6lB2WFNABsYfWpTMFxO9VaiViW7Ol+C01AK" +
       "9Ul7U5Ngk2ArHLVuctOBOWiILQQfzod1SZw0+LWvFNbujDCJErNsOaNVx2tq" +
       "UZFrKCQ9Xulxo+/xCVJ22yAtRMImIaOYVRpy7I90Mm5L1qJUa2ER1uv2DJKd" +
       "s3N/ya71krxGY54b9PstpdSi2rWehheaerE1c0qYJJgFTkvQ7pCpqUrCsG7f" +
       "Lsn9QpNErNAR1y3CSWvGRDXUBMMmKFypt9friexuZlFC0KTSqYGFCYEer620" +
       "grXLcYEtE+u6MSth3YpXRXVKxgRqOE0VTSiuHbQ548AW0OCIdENXN3h7sHQ5" +
       "ZYqaBTgS62o0SPUU5shAlY24zPa5aBWEYMESUtO0udCMGyUsHcetCeMTaUMf" +
       "tfrI1IbTQbiykJJJ1LUOarvwmtK96biNDpdVlKHp7pSj+bbVRJV+l4r90nxt" +
       "eXGj66+Kqtmel0V6vCRcPgkXKFosIDUYmQRGFGwQYaQMCsRSXbhjnkOb3Kzf" +
       "6SsUPbIY1Z9PVVNumWHZG2slQzWrY3QiVIoVVYroEJ0OFrGISy0l7GvyEO/j" +
       "i8FQWYqB5NbQJFZq7aCiDbVe28fLqdSVhpYxIKpG20/pcnvDyYO0VBLURSoM" +
       "I9oqL4geaY9EQ15tpqtag+Ct6YRJybRTr+m11DYL2hrDLWkc6tFwOgm4waqf" +
       "DqeUiKaKiG1wHk2W+MYUh12VZjHY9vt02FOM0CBxlbVhnFwuIwxRWbcOh7qb" +
       "jAJsLW3sSbPZ4ispnJbQat1O16hpj2x+zCFoSiKSU+KkTW/am7R7Y346w2lN" +
       "S0tyNPDhWjms1JSGHVFkNJ/oMxox9MbEaLFBBan3xsJAY9bBJAhQtNKEteG8" +
       "Mu0MbVdgxNEGKcBKVK9WBE4ReuUEn3HCmsEpXSGamyUpGjGlcmB/N6t0yiMx" +
       "6jW7Ns5icRHosUVNeIkiOv2o20nHlLdUcAveDIZ4wpB9rJwMpiO2x49LTF3A" +
       "DW/SjI1JWKt6qbxggU9ZfJuX9RBWRuRQE8pp3dIplls5JQazuxFMrh1VB66p" +
       "LYrh2CpZnslLTYxsstPOuOhRg+aK0Ff1pk07IBQDOVpPF/qEKHZLJhOVeBar" +
       "gSiU0eqYIXCJMKJKKNgjNVDIFFQqTtksLuOZxCmbKcyyeGlWh+lJGNZCuap7" +
       "Nb+4xOpRi4nHhohSLRDgmtNAS/NCrDig4OiU5QWzKEaEsNmU5cQbmkKJrpXL" +
       "XaMwV0yijK3SmdlmQCnXqM8jujEPbZAr4IWqxdNa5K/mOjGVKx1TWxNOZd3R" +
       "5HQ0LTYZvkxbGqs3qyS3XCF4k2kYTVRbYgZWdxiC2KyN6TTqdqdFdCNPSFWy" +
       "PQN3xlQrrNqS5IzGzHC8SfCl2GnNY9aZutVooZLlVYcqrYHjdhaNJaYlImUy" +
       "8xaMaKTlbxBTqtcdqgDqkmJnwalwRXXTVBZBedco8wmvIiux3hkadrVkSmXM" +
       "6MwRsSjJ3bDnxku7LQ56k2qBFfSurSqb+bJB1TvEFOYRHy4WGXHZT1x8ZI2K" +
       "7RDHlEFz1GXiIllvAWaajN/EWjDr2LWCHOM2JpdnvDKfNGlhqmkLcxo1CmHD" +
       "mvjGKFB6HFPn5P40Vol1qGHdAlFx5RUzYeFxGSY1r2siM0MqDpqYmwyibm/S" +
       "XTm2JvvVqMoVCgN/ERWltLTEGsW2EUypVrOpcAqq4bxD12YVXtdTxuSRNcz6" +
       "5QYXNZF1RM2JXqIRsEHMejSOjyZtexgWiqyNNm3cBIVeAV3CLIqy5moD61Zh" +
       "yfhqYNeRtVuUu4Rr16qDfscsrnGpQi+noEImMLa4dNF11K8SvdlAtEhL7pDI" +
       "GC1pFNOfm2JxtIyHoUlV1/0Fsq4MOG+JWrYjjxSF1Qa8NmX1DrpUK9FYmjt2" +
       "l1obDWOSSItCwiJDve4LbNtfuaq/iEcuPa9P8ITDK4yOk/CUBQaa2F5jFDVF" +
       "sBt5c7ZNeetL2ynenW+KD24nwAYxm+i+hB3SduqRrHntwUFg/jt3h4PAI4cl" +
       "p/Y34Pfecu67PejNdoUPvNilRL4j/OR7n3pWZT5V3Nk7hBIj6GLk+W+0tbVm" +
       "nziXef2L737p/E7m8HDkS+/9l/tHbzHf/hKOfx86wedJkr9HP/eV7uuUj+xA" +
       "pw+OSm65LTqOdOP4AcmlQANfcHd07JjkgQPN59q/b0/7+1a4zRHsbb3kVO4l" +
       "W9+4wxlfdIe5ddZ4EXTe0CLeSrfnxNwRJxKycxnbk6JD9/J/0gb86CL5gH1c" +
       "3leC59KevJf+b+TdyQF2std8Ps7bX7mD5O/LmndG0GkgeY5xKOC7fgoBr2WD" +
       "94Pn8p6Al1+KgMAQfmCtpUi7rZSnDtWwFfDJOwj4kaz5YARdcPbuYU5I+aGX" +
       "ImUcQZeP3+dkB9L33XJDvL3VVD777JUL9z47/pv8SuPg5vFiH7qgr2z76Pnh" +
       "kf45P9B0K+f94vY00c//Pn67XLO9Y4qyO+CskzP89Bb+mQi6ehI+gs5kf0fB" +
       "fjOCXnYEDKh+r3cU6LeAgwCgrPvb/m2OHrfnqPGpI1nrqI6v/SQdH6AcvfLI" +
       "Ml1+Rb+flVbbS/qbyueepQbveKH6qe2Vi2JLaZpRudCHzm9vfw4y2yMvSm2f" +
       "1jnisR9d/vzF1+5n4ctbhg/d8whvD93+TqPj+FF+C5H+0b1/8KbfefZb+Uno" +
       "/wJiYq3gOyEAAA==");
}
