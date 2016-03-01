package org.apache.batik.parser;
public class TimingSpecifierListParser extends org.apache.batik.parser.TimingSpecifierParser {
    public TimingSpecifierListParser(boolean useSVG11AccessKeys, boolean useSVG12AccessKeys) {
        super(
          useSVG11AccessKeys,
          useSVG12AccessKeys);
        timingSpecifierHandler =
          org.apache.batik.parser.DefaultTimingSpecifierListHandler.
            INSTANCE;
    }
    public void setTimingSpecifierListHandler(org.apache.batik.parser.TimingSpecifierListHandler handler) {
        timingSpecifierHandler =
          handler;
    }
    public org.apache.batik.parser.TimingSpecifierListHandler getTimingSpecifierListHandler() {
        return (org.apache.batik.parser.TimingSpecifierListHandler)
                 timingSpecifierHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.read(
                                                 );
                              ((org.apache.batik.parser.TimingSpecifierListHandler)
                                 timingSpecifierHandler).
                                startTimingSpecifierList(
                                  );
                              skipSpaces(
                                );
                              if (current !=
                                    -1) {
                                  for (;
                                       ;
                                       ) {
                                      java.lang.Object[] spec =
                                        parseTimingSpecifier(
                                          );
                                      handleTimingSpecifier(
                                        spec);
                                      skipSpaces(
                                        );
                                      if (current ==
                                            -1) {
                                          break;
                                      }
                                      if (current ==
                                            ';') {
                                          current =
                                            reader.
                                              read(
                                                );
                                          continue;
                                      }
                                      reportUnexpectedCharacterError(
                                        current);
                                  }
                              }
                              skipSpaces(
                                );
                              if (current !=
                                    -1) {
                                  reportUnexpectedCharacterError(
                                    current);
                              }
                              ((org.apache.batik.parser.TimingSpecifierListHandler)
                                 timingSpecifierHandler).
                                endTimingSpecifierList(
                                  ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3AYaEsLypiky9Qc4bPkvxySwHzEXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVaeawsWVmvd9+8leG9NwPMDOPs8xicabjV+5IHDN21dFd3" +
       "dXVVV/VWKm9q76qufemuLhiFMTooyUD0MWICE02GoDgsMRJNDGaMUSAQEwxx" +
       "SwRiTESRhPlDNKLiqep7b9973zJOMPEmdfrUOd/5zred3zn1nfvS96BTgQ/l" +
       "XMdca6YT7ipxuGuYld1w7SrBbpes0IIfKDJiCkHAgbar0iOfv/iDH35kfmkH" +
       "Os1DbxBs2wmFUHfsYKgEjrlUZBK6uG3FTMUKQugSaQhLAY5C3YRJPQivkNDr" +
       "Dg0NocvkvggwEAEGIsCZCHBzSwUGvV6xIwtJRwh2GHjQz0InSOi0K6XihdDD" +
       "R5m4gi9Ye2zoTAPA4Wz6PgZKZYNjH3roQPeNztcp/NEcfO3X3nPpd09CF3no" +
       "om6zqTgSECIEk/DQ7ZZiiYofNGVZkXnoDltRZFbxdcHUk0xuHroz0DVbCCNf" +
       "OTBS2hi5ip/NubXc7VKqmx9JoeMfqKfqiinvv51STUEDut611XWjIZ62AwXP" +
       "60AwXxUkZX/IbQvdlkPoweMjDnS83AMEYOgZSwnnzsFUt9kCaIDu3PjOFGwN" +
       "ZkNftzVAesqJwCwhdO9Nmaa2dgVpIWjK1RC65zgdvekCVOcyQ6RDQuhNx8ky" +
       "TsBL9x7z0iH/fI96x3PvtTv2TiazrEhmKv9ZMOiBY4OGiqr4ii0pm4G3P0E+" +
       "L9z1xQ/uQBAgftMx4g3N77/vlXe/7YGXv7yh+Ykb0AxEQ5HCq9KL4oWv34c8" +
       "3jiZinHWdQI9df4RzbPwp/d6rsQuWHl3HXBMO3f3O18e/tns/Z9WvrsDnSeg" +
       "05JjRhaIozskx3J1U/Hbiq34QqjIBHROsWUk6yegM6BO6rayaR2oaqCEBHSb" +
       "mTWddrJ3YCIVsEhNdAbUdVt19uuuEM6zeuxCEHQGPNDt4HkA2vxlvyHkw3PH" +
       "UmBBEmzddmDad1L9U4fasgCHSgDqMuh1HVgE8b94e2G3BgdO5IOAhB1fgwUQ" +
       "FXNl05mu0UDxYU63QFyxriLpINr9FCKydejvprHn/r/MGqe2uLQ6cQK46b7j" +
       "IGGC9dVxTFnxr0rXohb2ymevfnXnYNHsWTGECmDq3c3Uu9nUu5upd286NXTi" +
       "RDbjG1MRNkEBXLoA4ABIbn+c/ZnuUx985CSIRnd1G/BHSgrfHL2RLZwQGWhK" +
       "IKahlz+2+sD45/I70M5RGE7FBk3n0+F0Cp4HIHn5+PK7Ed+Lz37nB597/mln" +
       "uxCP4PoePlw/Ml3fjxw3sO9IigwQc8v+iYeEL1z94tOXd6DbAGgAoAwFENgA" +
       "gx44PseRdX5lHzNTXU4BhVXHtwQz7doHuvPh3HdW25bM8xey+h3Axq9LA/8y" +
       "eN66txKy37T3DW5avnETKanTjmmRYfI7WfcTf/3n/1TKzL0P3xcPbYisEl45" +
       "BBkps4sZONyxjQHOVxRA93cfo3/1o9979qeyAAAUj95owstpiQCoAC4EZv6F" +
       "L3t/861vvviNnW3QhGDPjERTl+IDJdN26PwtlASzPbaVB0COCRZgGjWXR7bl" +
       "yCCMBdFU0ij9z4tvKXzhX567tIkDE7Tsh9HbXp3Btv3NLej9X33Pvz2QsTkh" +
       "pVve1mZbsg2OvmHLuen7wjqVI/7AX9z/618SPgEQGaBgoCdKBmw7mQ12wKDH" +
       "b3Hs8cECDfXl3lYBP33ntxYf/85nNtvA8X3lGLHywWu//KPd567tHNp8H71u" +
       "/zs8ZrMBZ2H0+o1HfgT+ToDnv9Mn9UTasAHgO5G9XeChg23AdWOgzsO3Eiub" +
       "Av/Hzz39h7/19LMbNe48uvdg4Gj1mb/8r6/tfuzbX7kBlJ0RHcdUhCw8S5mo" +
       "cCbqE1m5m8qWGRbK+q6kxYPBYeQ4auND57qr0ke+8f3Xj7//R69k0x49GB5e" +
       "KH3B3RjpQlo8lOp893GY7AjBHNCVX6Z++pL58g8BRx5wlMA2EAx8ANfxkWW1" +
       "R33qzN/+8Z/c9dTXT0I7OHTedAQZFzKEgs4BaFCCOUD62H3y3ZuVsToLikuZ" +
       "qtB1ym9W1D3Z28lbxxienuu2+HbPfwxM8Zm///frjJDB8g3C7th4Hn7p4/ci" +
       "7/puNn6Lj+noB+LrtzBwBt6OLX7a+tedR07/6Q50hocuSXsH7LFgRinq8OBQ" +
       "GeyfusEh/Ej/0QPi5jR05QD/7zse94emPY7M23gD9ZQ6rZ/fOrwcnwDIdaq4" +
       "W9vNp+9ENvDhrLycFm/dWD2t/iSAuCA7qIMRqm4LZsanHIKIMaXL+0toDA7u" +
       "wMSXDbOWsXkT+FTJoiNVZndz2t2Ae1q+YyNFVn/yptGA7ssKvH9hy4x0wMH5" +
       "Q//wka99+NFvARd1oVPL1HzAM4dmpKL0W+IXX/ro/a+79u0PZYgN4Jp+Hrv0" +
       "7pQrdyuN06KfFtS+qvemqrLZIYgUgrCfgawiH2ibP6RPNQRQ7fwY2oa3f7lT" +
       "Dojm/l9/PFMnq1EcT9RBqa627DqDDjqohuIjjDRQbtx1uBHdbLdX5XLct1gU" +
       "o+JGotjtxlwsqbwt9ulR3iUKM0LHhWmLnWijHBE54shFxujYK7Ae4ZkTrofl" +
       "h1TbTxxWCHMLlUWr3IorzvEizDYsuSQuuZLaFeZwgeoNGkVRWXYsdQnLFllY" +
       "2bLI49Fi7blFa9RJBL4zKmlKuStQi2VJkNmiXKeCkW3nuapCl9Q4zMPYyhvW" +
       "zaBGjjpmz0lEweOwpegU2aEXRlJV8xI56U3ieb6rN+x+25MlSh0O+wul0CoN" +
       "QMg5XichWbRpF0dIOCjqhm26fk9KRKc/aC2kcUxgMc3G6AxHpr7h4os46dPK" +
       "fLkw27BbF/K6WK9Xk8HEojpV1KC6ou3NBdJLxCU5NhZkSDOo03BbTm7ddOpK" +
       "flApoCTWUK0c3xZdRaTtcsGi+bHVbhfH3BRlK6OwI8XFBtqecO5g4ie86pTM" +
       "GkYvhCpjcZZY1lHbNfyoE0co024lXjUKh5rKJBZfoxtDE+kolbVnSGOc0DlX" +
       "GPe5tj+0+32LmDBt1ClJ+XEhaFnFKU6OC6VhganPrNrMpOjaZNmYMQW3zY5C" +
       "z6giZV3TWoSMDoO2RnZl3fTzrj0R3ZHcs7Q61bF6Y5bjC/klVYi8Yr9amS6I" +
       "piwFg+6iZLHTQaO9wm2Nk30yQVAhcqaLGWaqA5/06GFfRgqrBgWgRxtX8p2W" +
       "3vSQyXDRA9/5gccVnaq1GA6ro5puuMXaqokUKY+ZJbGPEzkQZ2Z/0ZnxxNwf" +
       "x0XCwDpJtd1FJ+0hgpiOXkAWybCg82M0JGIzGi6mbjMieKXpLRazpi+v+rpM" +
       "dA29ZeZmneWASxJ4IrfzZTnPqPl+02olbcsSEANGKWPUlvW8XpzMYrZJV/qi" +
       "NVYxW5BUslsfYE26LTXJ9iKn4lOxsYajJb32Kl1rxTH5VXWBcgO8W5nGXiGc" +
       "4CobwROC0qmu1/YFMmETZjrh+dXYdsiu3qKGFcwgF6IcS1FNXU61VT0XL8vj" +
       "Lt9FR72yMEnymBSyZjsxmQJvFYyB33f4nNnKB1xe7jZmnTVD1VuVqczy9jzp" +
       "8xaMt0Ze1PWmLgo3Zxw/a+KWriG1qqf05bi0gIGpkdxs3m22FUxL6G4Bgx0b" +
       "tnE99ru4AXZgZipPqEmfWI86jbzXb0p8QNXaJk8RFQHJobmyqytV0pqJChMg" +
       "fYufzRKsN+JxU5rjCd5uxqG5pJjxmrKweEjITjhEesN5YTaa1eH6shILDL7s" +
       "25qOr7A8qa2ROTMtU23cEyYj0+z5uQpcn5FrWTabbZId4OLCbSoDI/AMJ0c6" +
       "HrqqTpa4g2leF8s1mthkyGhYQDcNrcmqdG8xU4q1BObHDD0UsNpIM3KMjI35" +
       "UPGTUZ/FYW+4LiteZBVURUdX066FNa35cNSrNhZyVxmhuB2TGDUXJCRggyna" +
       "kluzypSI/WGyqLtWt1yKBv5wvM71gmbfW6HNPh0iEheV5x15paxVw4JJnanD" +
       "y6WxGEk0qvG9ddkU0cDNE2Sh0IJXwphbe74ZItOFXldrTJWbBM1g1TYHhFBv" +
       "No0I5Stck+vVyaIwJ4m1LvWFlVSYot1YXhBJwW/PUcloeg1qCTxPutWWAqAt" +
       "ySnSsMXBkjhF4047QnG2b82aE0cf1hWJqeca/BK2e6U+KYv02K3z0xxWH5fV" +
       "md5OZAenxHGZqPmzWbPmwDZmSWpEVnUxr8NOSy9OmY4c0bNWXsNJjUnUHD1m" +
       "ijkYbtQqVJ1Skg7hFNXFSEZzuOMSZW7dHZt9ptzIMa2Y6mtwgnvRHGYI1pnr" +
       "xXlvVtEWcNHlS0uaLeVzhbVhMLP+jHIaEzUJEHFZ6ieKahRUTqq1+IjR5tNp" +
       "UDE7XQuvh4FcWRSnw9V63imremEoNypzvoprWlMTexHHDVrehNI0sU2NcjAx" +
       "KdaRodp0tVWz65QHXnlUZSI5XNUb/ai9ZgtRk3cjvcpJM6Yh5xS72crb8yom" +
       "9sVK3ClN1GrfVjhKEcjAFF0NgzVyxdEq3GqtcgNsTi+LtKdaJLKYdOR+oNGM" +
       "75XYrsv6mOELsAojPFrJTXsaS0oOMrP5uNro0o7H2i4tWxUSCf3OMq7xtKQX" +
       "JHxOj7xSSDnuLFAnKIhSWLZLhltlRv5kWojwnIAOVLhRhNU436jX1anrdApz" +
       "dzgXiLi3Jh2RqTlEPC+00LxVqNrLAbykZ1SjLrSWzKxLFCpTrjjiy5RLFxrO" +
       "MhfX15G09td1FiuV8TxXBMtXaHVLLd0eGktMJjHdIIbEsD8UGuGqSooNFvc9" +
       "apwT7TGjKPDAsKZBLrKHqIDXBBeOWrOyLuSjOBwgcSeo16mxl2+BY2Sr5tbI" +
       "QQ1mPbOYaw3jjib0kbG8UEKvVcUXrhZ77UgoGXalBjvFTq4wd9jSwplbeXo4" +
       "6c0RkWrio74RkHNR1kQ/VolgjBGrdciYY9Y1VlYlR7r5WhnmS72h1+3DlhoZ" +
       "qFxvNCqVZq9pdpFKEpYDqdfBZ2Nn5NcLjCQSSWNkTpHVutftLYWIWMEDmusW" +
       "SDSBRazESyHfRsHHR2Vo0QZHD2Jvjg87QpJnql2jUfVHkRWUhEaloeKVROHx" +
       "Dufmx+xS99b+QqIHyHgIl6sqLDeKarE0EvPTFszQwTLJ5YnpNPQKTEfLkWxZ" +
       "CkrtydSUu9RSmPBYDZuVerV83kzcnlfUhFzHlbh1UV46vYFTTPTS2BVnk1AT" +
       "honGtOAkRy/qNXUIr4pNGmy5c3bt9nxLWinYnJvzLaqQ4w3ZqHYZia7LjYZN" +
       "sYN21auXmJIWYPWoRs8DfcZwCNdpzCis2ishLlqpFQx7OinVKvNesRjOtHZt" +
       "bTrAifMiOfR8fp5fjIyYbNO5pDsRwVu3TBm+J/ZiHeHaUdxuF4pxs2DxYqvJ" +
       "m7NB2OQSIUGCssMbmjoB+qG6FIxNpctOMbKKrJxEzy+oCtlrjGYlp9xpxdww" +
       "SeThynJYxEJFjFOLs0YUVyuqGEwGpJWUoxGRn8ZKUZWE3KzQUhRcYnO0JK3g" +
       "+tTgnFipNxO5SfJqT6gs+iRdIkdWLJIe1pvypk3y2KIRS7aEGCJSMyd1pFnM" +
       "dRULTkamv+hWucGyo3KJirMSazQL4joewWsckQoM0Vvy+WTaLAY5otIiBvEY" +
       "qYzH/UGbG7iJjY1rwsQcMnid61AtFanD3VW7pFiVGhfRJdpAAri7dibzvDTv" +
       "VRKiZQ3DSqIvxpowGkekB1c1flLi/dIspFbhvF1gZ0hjiS8NfbDC+VmRKCfN" +
       "Rr5k86WAweEcvG6zxZzkk/U2J8kK5hFMbIcNu0Yu5Dh0SjDFOKrYdovgTIyx" +
       "PTaPLyt9uObDiWGPwXGghRAizVS9XIHoedJyyS8JayByM5nIswNPS3wa6REW" +
       "OMGKaE6vWgYemNNJq7EODD9WGlGQtIq9acXBKnyMol4yIKLpKF+trt2lXteC" +
       "GoXVuYTy+iVsPEe7HLVs29VxeWzmihzFYCFKIKLBVEW31JwJWECuXX2xbjBS" +
       "WaQXy3jNrjoJNgVfLu9MP2meem2fWndkX5UHFyrgCyvtoF/D19Sm6+G0eMtB" +
       "Vi77O308CX84K7fNNkBpPuT+m92TZPmfF5+59oI8+GRhZy9LUwuhc6Hjvt1U" +
       "lop5LHHxxM0TF/3smmibPfjSM/98L/eu+VOvIaH84DE5j7P87f5LX2k/Jv3K" +
       "DnTyIJdw3QXW0UFXjmYQzvtKGPk2dySPcP/RpG4ePIU9y+ZvnNS9YRScyKJg" +
       "4/tjSbATe2n5vWxC8TVcAHQEWzYVP2O7vEVuLUkLLwTKKOHN2dzwC3/p6PI2" +
       "HP1X+7g/PHPWYB/Y77G0EQFPfc9+9f8b+x1W9Nlb9P1SWjwDjKDdyggp0Wqr" +
       "8M//GApfSBvvA8+Tewo/+VoUBgvN9Z1QkUJFflW9rx3r289Y78XUYzeLqewG" +
       "CYslxT1YfYB8kxrXnV1icNCXTfN8WjwXQmdkJxuZvr5va6wPvxZjxSH05pve" +
       "aaUJ+nuuu2bfXA1Ln33h4tm7Xxj9VXatc3B9e46EzqqRaR5OCR6qn3Z9RdUz" +
       "Lc5tEoRu9vObIXT3TayT3nlklUz239jQvxhCl47Th9Cp7Pcw3adC6PyWDrDa" +
       "VA6TfDqETgKStPo77r7t3/6/XP4bO8UnjsL5gSvufDVXHNoBHj2C29n/QOxj" +
       "bLT5L4ir0ude6FLvfaX6yc2VlGQKSYYpZ0nozOZ27ACnH74pt31epzuP//DC" +
       "58+9ZX9PubAReLsYDsn24I3vfzDLDbMbm+QP7v69d3zqhW9mic//Aajvq+yc" +
       "IgAA");
}
