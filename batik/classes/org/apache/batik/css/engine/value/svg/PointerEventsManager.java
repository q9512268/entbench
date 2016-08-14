package org.apache.batik.css.engine.value.svg;
public class PointerEventsManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_PAINTED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          PAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_STROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          STROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLEPAINTED_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                      VISIBLEPAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLESTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLESTROKE_VALUE); }
    public boolean isInheritedProperty() { return true;
    }
    public boolean isAnimatableProperty() { return true;
    }
    public boolean isAdditiveProperty() { return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_POINTER_EVENTS_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 VISIBLEPAINTED_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public PointerEventsManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aa+zkVnX3bpLd7BKymw15NJD3hjQM/XvG8/BMQym2xzNj" +
       "j+15j2dcysZve/wcP2Y8hrSAVEKLShGElwTph4LaovAoAvUlUKqqBQRCoqIt" +
       "bVWgFRK0FIl8KK1KW3rt+b/3EaJEHcl37tx7zrnnnHvuz2fuvU//ALohDKCC" +
       "79kb3faiHTWJdhZ2dSfa+Gq4QzPVvhiEqkLYYhiOQdsl+YFPnfvRj99lnD8J" +
       "nRKgW0XX9SIxMj03HKqhZ69UhYHOHbSStuqEEXSeWYgrEY4j04YZM4weZaCX" +
       "HGKNoIvMngowUAEGKsC5CjB2QAWYXqq6sUNkHKIbhUvoV6ATDHTKlzP1Iuj+" +
       "o0J8MRCdXTH93AIg4cbs9xQYlTMnAXTfvu1bmy8z+L0F+Mn3v+H8p6+DzgnQ" +
       "OdMdZerIQIkIDCJANzmqI6lBiCmKqgjQLa6qKiM1MEXbTHO9BehCaOquGMWB" +
       "uu+krDH21SAf88BzN8mZbUEsR16wb55mqray9+sGzRZ1YOvtB7ZuLWxl7cDA" +
       "syZQLNBEWd1jud4yXSWC7j3OsW/jxS4gAKynHTUyvP2hrndF0ABd2M6dLbo6" +
       "PIoC09UB6Q1eDEaJoLuuKjTztS/KlqirlyLozuN0/W0XoDqTOyJjiaDbjpPl" +
       "ksAs3XVslg7Nzw+417zzjW7HPZnrrKiynel/I2C65xjTUNXUQHVldct406uY" +
       "94m3f+7tJyEIEN92jHhL84dvevZ1r77nmS9uaV5+BZqetFDl6JL8Eenmr72C" +
       "eKRxXabGjb4XmtnkH7E8D//+bs+jiQ9W3u37ErPOnb3OZ4Z/OX/zx9Tvn4TO" +
       "UtAp2bNjB8TRLbLn+KatBm3VVQMxUhUKOqO6CpH3U9BpUGdMV9229jQtVCMK" +
       "ut7Om055+W/gIg2IyFx0GtRNV/P26r4YGXk98SEIOg0e6CbwPABtP/l3BDmw" +
       "4TkqLMqia7oe3A+8zP4QVt1IAr41YAlEvQWHXhyAEIS9QIdFEAeGutshhxmt" +
       "DnSCV6Idq3C40oFT8qglV0BKyIouiIxgJws7//97wCTzwPn1iRNgcl5xHBps" +
       "sKo6nq2owSX5yRgnn/3EpS+f3F8qu76LoJ8HOuxsddjJddgBOuxsddjJddgB" +
       "OuxcSQfoxIl86JdlumxjAsyoBbABoOZNj4x+mX7s7Q9cB4LRX18PpiMjha8O" +
       "3sQBmlA5ZsogpKFnPrB+y/RXiyehk0dRONMfNJ3N2PsZdu5j5MXjq+9Kcs89" +
       "8b0fffJ9j3sH6/AIrO/Cw+Wc2fJ+4LinA09WFQCYB+JfdZ/42Uufe/ziSeh6" +
       "gBkAJyMRuBNA0D3HxziyzB/dg8zMlhuAwZoXOKKdde3h3NnICLz1QUseAjfn" +
       "9VuAj18D7RZHFkLWe6uflS/bhkw2acesyCH5F0b+h7/x1X8p5+7eQ+9zh96H" +
       "IzV69BBiZMLO5dhwy0EMjANVBXT/+IH+e977gyd+KQ8AQPHglQa8mJUEQAow" +
       "hcDNv/bF5d9965sf+frJg6CJwCszlmxTTrZG/gR8ToDnf7MnMy5r2K72C8Qu" +
       "5Ny3jzl+NvIrD3QD6GODBZlF0MWJ63iKqZmiZKtZxP73uYdKn/23d57fxoQN" +
       "WvZC6tXPLeCg/Wdw6M1ffsN/3JOLOSFnb78D/x2QbSH11gPJWBCIm0yP5C1/" +
       "dfcHvyB+GIAzAMTQTNUc46DcH1A+gcXcF4W8hI/1IVlxb3h4IRxda4eylEvy" +
       "u77+w5dOf/j5Z3Ntj6Y5h+edFf1Ht6GWFfclQPwdx1d9RwwNQFd5hnv9efuZ" +
       "HwOJApAoA5wLewGAoeRIlOxS33D67//sz29/7GvXQSdb0FnbE5WWmC846AyI" +
       "dDU0AIIl/i++bhvN6xtBcT43FbrM+G2A3Jn/uh4o+MjVsaaVZSkHy/XO/+rZ" +
       "0lv/+T8vc0KOMld4OR/jF+CnP3QX8drv5/wHyz3jvie5HJpBRnfAi3zM+feT" +
       "D5z6i5PQaQE6L++mi9MMeMEiEkCKFO7lkCClPNJ/NN3Zvtsf3YezVxyHmkPD" +
       "Hgeag1cCqGfUWf3sMWx5eebl14Ln4V1sefg4tpyA8srrcpb78/JiVjycz8l1" +
       "EXTGD7wIaKmCFO9UmOemEdDEdEU7H+wR0Jy/c8Kc+bYIKjz362mb54FY2kJb" +
       "VpazAtsGRO2qwfNoPmRyAmDMDcgOulPMfjNXUT6r/mxWkFnR2lP3joUtX9zD" +
       "nSlIrUHYXFzY6J7+5/OIzyZoV89jSj7yUysJIvrmA2GMB1Lbd3znXV/5rQe/" +
       "BcKOhm7InQGi7dCIXJxl+297+r13v+TJb78jB1WAqNNf/wP025nUyfMz9a7M" +
       "1FGeuTBiGLE59qlKbu01V1s/MB3wuljtprLw4xe+ZX3oex/fpqnHl9YxYvXt" +
       "T/7GT3be+eTJQ38OHrwsPz/Ms/2DkCv90l0PB9D91xol52h995OP/+nvPf7E" +
       "VqsLR1NdEvyT+/jf/M9Xdj7w7S9dIYe63vZewMRG56BOJaSwvQ9TEtQyPikN" +
       "LTiutOsEMSCxUF9YOK6rjB50gwliY54x6mBjVh8Jit0hEClyrXVURtGyrKaS" +
       "MO+6VERNka7Xo0yq6hR0uWcvqfXYLxYCXOqIwnTpisuiiCNJE1GtyXK+cRW/" +
       "J4ozTSnUGmoCoyZt+WXBRhtxpVoua70GbCoovOohw95s01qMKarEVodkwW+y" +
       "aXGJbiRnOWc4x5lwfZnoII1iyNmNdkNi3LHSNiVbHncNt7pUyMVMaPuWPxpz" +
       "PSF0lhvRWrJSjwlHw42Cr1iBnWNVqeskltMEmlrKhOcFrubTQ2skden2gtxY" +
       "Lh5tqJATjLSI0yhnUqQ9GeG00h4m8UIgxZHS68z6tN9ZUUi6NkZ+hJTGJLqc" +
       "RysPo0pO3E3IOcrQPMq2eTEJNjaheSuS2sAMxTm8IM3pUshPq7SjF6bairYH" +
       "/YYiU6RVM5eivfEEpKr7yzkbtkdsiVk20IHPOOmKKhUNYUGlKdnpj0iX5Rdy" +
       "15xMF5OiItpY7HbYlB9LUY/sRRthOd3MJgTec1abcY0b6eIsFiWTTNNWk5aU" +
       "YotFdJSuqZHP86qp16OFUa2p5EphEd7irOpSkCadRGhhBFZjEratM3RJNwJr" +
       "4/Bjukc7nh5wqEO0xkOl6qtooNr9aLJZ9HUtlEOEdofOqMMr7WJL08cK0Jnk" +
       "Rj13ZnnYZlUpccvZoB/hJXMZB75Kiigmt5bIZJCSxnBNlznWEdGAmFedYdna" +
       "9Ny5rMsDrB21nFWrwEjapE1PCbzmlKkuPYhGsIg18HGhghcDbI5xTVOYucNR" +
       "xEx7vooUF/DEpHSuWFbmg0lrQg82GEOvSzi7IMdq266tyVCFS+mSD1C44/JR" +
       "25wbVtOlaWxmd9YKuxi0neYIeA2T0HW7G/LDATruyvXVpsESOFbGKT1yjEah" +
       "odHRKPH7K4QZpoSBhWktWUyc+jRdik6/2U4ZsRVVRaNN8zUhDDyNhp25r5SQ" +
       "TS/ih0UzpcfyoqnP5YHQl+BFa1qea0KiNX1m2bTJWLQsq7kwhS5vL2ctXpJT" +
       "e+hM2NqoI466S9lCWKWKd2OsQS9XbM1GtJHvgCYsMWN9WaoPV2yL7PoWNp7K" +
       "PTTozovVEuICd9aF8pQYYZO6j4mq4NCNpCm7Nd6EbUcYdu3WdBpMvajWNoC2" +
       "E8qqEBIXauNBcxkVFY7hWQzv9sTiULV1iisIeoOiIwbRJ+kQE32L5wZyDest" +
       "CG6ENOtYKJjKFBvabbzddmG0Pku7VIvWkfYgJmRH7gw8loj5ZeiPeKk48uTN" +
       "suGt+o0yutQnaJlYIuh4UQVYNQj5EUXgFliXfdIySVOgTKxJtwjWxwcjYt1o" +
       "83zCYqRaHtQSbE6nqdxV44YSlRVFxp3mBK+rWK9KFBFBtZBojVWscWMW2xas" +
       "mcpYVWcrY+DMka7lWl59kMzY3ijm+p7hFF0BXTdki+ogVZ4f9ehKpBcWbNEc" +
       "TQwTnzH0ah7aioexKKFZdUdtC2vZQMMqv0ibLXqkuc3KRuUKjorUKQvFYFkl" +
       "RvNNx6FmYdlYRTLfrtO4lxD1hhSvtCa9AXPFNZViodkdWsVm2mu1O1UTq+ix" +
       "5NtDifNkGOkHhWAomA3ColC/gmEmveTW42ndEt2pqXW90WbiuVyX5VrT9YZp" +
       "JZxaL0dkuzys4Qi1mHMtDxsOdBIfzpnK3IMLBS5ewbAFZtty7cawZnqYmthh" +
       "oz4I3WWiDsVll9lQxfa82CyX/U6MJ4Va1FFTneAGKYEU51iMSEOivG5G+pov" +
       "1MO4pzTqda0/jBBKXhs6L48mmGIbo9o4qFMuzhbcQrvJrgeVoBGNysigtR6b" +
       "FaIWLDZaS0ZMatI1MJkc1mOlG+KDcWgVvXFT7sOF2JW0IiLBYYD25WBC9PXq" +
       "3KaKsN6wC2UzTgqKHMLtcFKkBnYa8iFs19fdOt2Xnaks4kaJ6ElMeTV2A0vQ" +
       "/EoVW1LNjVS3Kg5lVoYNs0nockwyfGWAyggeTuO1wys1VkW1oV8Tl1O5Jvel" +
       "RV0IC1rc3licoCkdt1G23NJUj1q2oeihOiMldy2AUHRrnNFL5xQ7qfRw0SyW" +
       "Ckh74xQb5fKUd12mQmzqgsEPbCJEXVVnTaEx6dC+UZXqUjibVZebxry4Ie1q" +
       "c2nwHB0pg1BtUa0RoThacaAwfbDka2kVN0OjK/QQqm/xI3OFocV1jOIw0mBr" +
       "rQQVCmLP75eMgtQ363p3GqdjctFCWm7B7IbLHqyMZ2g9mEYFubDB1xWONyRi" +
       "rbYHTJ0so6WyZ4eq2ofraWpWDB8XlzOsU6+r4GVX44sBo/sFDtV1pRgi/bKC" +
       "6x2hKqUbFXbjSqyl7nxKDekyP5pNGqt1uCYLqdfjxLHf4uyBDK/asMbrU21T" +
       "rHqMm7Zxvb5ZS812FKfesOyzUrk+INnUwmaBh7v6vIzjE5I1PKPCj5R51QOx" +
       "NRYYo7/q9rruqDlHmjaWLCsdetzq1WWabk2XzjCtrU1vTBSS5oropu1i13Yc" +
       "mcEr1c10NWXDpkSE7lwzalKvlpTsRCNkVFx3zFZ9pdSm03LaHRUSrlkZ0GjE" +
       "CcnA9ybaWivPOK/HABeKE97srRpD3kJdxlELcQmeeaFc0BABi6a9lqIVa8kE" +
       "WePjvmPwFb8NSwq1TI35Cm9s5jLM9fo87PMLce6sJbRNil4PbhYlu2VMgCbt" +
       "4cyupkVtzNVQr5wuu3WHRtZ0incleKaqDItqPVtHWonFUMiwUcFTFp7Uovqo" +
       "NBCbZK1XK0pyUo3nGItZSi8pqIoRYqjc5ipzOu4vBK3h9BqxPgxMZb2wE33M" +
       "eBzHWRbSawwLPYxp2l5vOaKTDTybLAsBgEbwkvP98XjSllmEUDdtNC6PVpEY" +
       "LwrrecdQsIHIBHGHrvURKXVK6HhshqQBEpoq2+nMMWtcnk6MYpGMiiDpwhHg" +
       "1GUAr8rRolSqbHzKbdNYM2mnmsc3tIW6hoV2cVirrxtcAZ7XCnySRkW8Jvjd" +
       "YERVSm5SkSMlHRdQsY1KkWbIbmtgc5PEmMrlCl0VmJnA1KfM1J5ptRXirzWw" +
       "oCSsGoe6PbSnZb9ldCYWjBErdszSi+lKnaMhM7QNj+HIKmFWU7Y7p+Ru0rH6" +
       "Vn+UeNVpHC+0mi43hrE4XyjpvEa2tAUzIUOmoc7jjYRwa2aYlIVZ1+2K8jKZ" +
       "usPBAgEpcJVRSnXPqheafqjNlm2pRJtBm5/0Y5x02P58xSpdfGitANQhRMm0" +
       "+vFKn7SWsrgeuoEZTWcgKTXdNm8xfmVIL8r1mUOKZrmQGGWGJtG4NovceUOL" +
       "Y1WRS5SDVFXZNRCuX5HrSCEdikiTUI0k0E3FQDZkohosP9+UDN9m7cRH8eoq" +
       "KpBlAQ863WU49oeVNseJtqIE3rQ3w1hmLI+SnoaHYWMmc67HtHg2ms95zR4a" +
       "KCnEGo8LYjqlil5Jb8VIz8BH/dlyU2uwXJKW6vi6OdaR6cYApots2W22eDKc" +
       "V+HJaI7C7aq+dklA05m4lO02daEkKIjKipWqBhMIZ1GT+iRezZpUYVlc9etG" +
       "wERpTQXWhUt/XVZVsjLdoG4NxfWlNiWF4YqSvbQcV6WAmDD9UQBGAvxGzaly" +
       "VbdgI+SS6kdkdygnUhBX18WFrHfpWox3KD9MVj05JRY4QchBrT5j6mt1PSVI" +
       "lcQikSlMOmHfadoE0Sr0pZEmG3Q0CTtmyVvN/G5/3pnra0Vl4oBbSUYgzIjq" +
       "Uuo0nAGMLqbraqs56hmbDmc6hTCY1HmNn1QUG+0U0ng5Heu1VQ0N3HqsqmEX" +
       "TWlqFpcpJ11Q/WUqecUUL80dL+hVw2S6ciXDHjjuMp5XBXG26kVk4NSxjU/Q" +
       "SWM8b8hMw47iURwrlWq82rRmhWKgJWy3EhatYa+lh00XrplEIBQIK246/Kw2" +
       "IyqTqrxiJrHWGXqJwExmjfrUTlkLLXrOiKsH7riENEphx09KUZPmkg4/CKfs" +
       "OuwWKsWpXvDBJBbn7JhWOTtMK12q1lSXBTLQCWnR7Hbng/lQk9wel65mi/6m" +
       "aKea09a0NFID3mymLdMWlIE11rlWo2mWk9SpFMJqvT0t9llGb7gBx5aW3riI" +
       "hxiiVOd+rYLateHCw7wZN2GMtd6RxvVJwNkgXoo4Z1Y0r6NjWPZXWHt+uxG3" +
       "5Bsv+6eCCxvNOgbP41/4tuv+rHhof5Mr/5y6xgb6oU1GKNtZuPtqh335rsJH" +
       "3vrkU0rvo6WTu5uzYgSdiTz/52x1pdqHRJ0Gkl519R0UNj/rPNg0/MJb//Wu" +
       "8WuNx57Hsci9x/Q8LvL32ae/1H6l/O6T0HX7W4iXncIeZXr06Mbh2UCNYhB+" +
       "R7YP79737K2Zx14JHnLXs+SVjyauGAUn8ijYzv019r7fdI2+X8mKdQTdaoaU" +
       "a6gAqVWlH3j5uXbO8PpDAfNYBJ2WPM9WRfcgmJLn2tI5PGTeEB21PtswZXat" +
       "Z158699xjb7fzIq3RdDLzBBzTUeMskOLPfOzvjcf2PnEC7XzIfCMdu0cvfh2" +
       "vv8afR/MindH0AUzu+SQb/Fdxcr3vAArz2WN94BH2LVSePGt/J1r9H00K56K" +
       "oHO6Gu2Zt38meCyOrzN3b5/kVv/2C7D6QtZ4P3ikXaulF9/qT1+j7zNZ8fGj" +
       "VnO7+DM4MPETL8DE/BVwH3gWuyYuXnwTP3+Nvmey4o+3JjZVTYzt7VHP3nHC" +
       "w899HHJAn3vjT16AN27LGh/MHbD9LF98b3zlGn1fzYovRNDNwBuUorpRduCw" +
       "vWvUObDwi8/HwgRA4JXuMmSHsXdedrtqeyNI/sRT526846nJ3+bH+fu3ds4w" +
       "0I1abNuHz84O1U/5gaqZuR1ntidpfv711xH00E915wIsXVDmFnx9y/qNCLr/" +
       "OVmj3aOgw4z/EEEvvwZjBJ3aVg7zfBN46ko8QC1QHqb8pwg6f5wSaJF/H6b7" +
       "TgSdPaADg24rh0m+C6QDkqz6PX8v6MvP7a6D6Nidz+TE0URtP1ouPFe0HMrt" +
       "HjySkeVX9Payp3h7Se+S/MmnaO6Nz9Y+ur0yIdtimmZSbmSg09vbG/sZ2P1X" +
       "lbYn61TnkR/f/KkzD+1lizdvFT5YZId0u/fKdxJIx4/yWwTpH93xmdf87lPf" +
       "zE/9/g8MdPo6OykAAA==");
}
