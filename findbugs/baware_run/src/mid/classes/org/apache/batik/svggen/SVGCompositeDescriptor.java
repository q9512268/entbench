package org.apache.batik.svggen;
public class SVGCompositeDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String opacityValue;
    private java.lang.String filterValue;
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue) {
        super(
          );
        this.
          opacityValue =
          opacityValue;
        this.
          filterValue =
          filterValue;
    }
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue,
                                  org.w3c.dom.Element def) {
        this(
          opacityValue,
          filterValue);
        this.
          def =
          def;
    }
    public java.lang.String getOpacityValue() { return opacityValue;
    }
    public java.lang.String getFilterValue() { return filterValue;
    }
    public org.w3c.dom.Element getDef() { return def; }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_OPACITY_ATTRIBUTE,
            opacityValue);
        attrMap.
          put(
            SVG_FILTER_ATTRIBUTE,
            filterValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null)
            defSet.
              add(
                def);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+ws113f3N+1r+1rx/faJrZxE79ynSYZ+M3O7uzObp1Q" +
       "z86+Z+exO/uYnQI3s/PYmdl5v3dStyESJCpSGoET0iqxBAotRU6CEAhoBRiV" +
       "NiAQKC1KS6WSAK0aGiKRP6BV05aemf2978MxifqT5uz5nfM953xf53O+5/Ha" +
       "16F7wwCCPdfabSw3OlSz6NC06ofRzlPDw9G4zklBqCqkJYXhDJTdlJ//uWt/" +
       "9c2P6dcPoCsi9JjkOG4kRYbrhFM1dK1EVcbQtdPSrqXaYQRdH5tSIiFxZFjI" +
       "2AijF8fQg2eaRtCN8TELCGABASwgJQsIcUoFGr1FdWKbLFpIThT60D+ALo2h" +
       "K55csBdBz53vxJMCyT7qhislAD3cX/y/AEKVjbMAevZE9r3Mtwj8cRh55Sd+" +
       "8PrPX4auidA1w+ELdmTARAQGEaGHbNVeq0FIKIqqiNAjjqoqvBoYkmXkJd8i" +
       "9GhobBwpigP1RElFYeypQTnmqeYekgvZgliO3OBEPM1QLeX4v3s1S9oAWR8/" +
       "lXUvYa8oBwJeNQBjgSbJ6nGTe7aGo0TQMxdbnMh4gwIEoOl9thrp7slQ9zgS" +
       "KIAe3dvOkpwNwkeB4WwA6b1uDEaJoKfu2Gmha0+St9JGvRlBT16k4/ZVgOqB" +
       "UhFFkwh660WysidgpacuWOmMfb7OvPejH3AGzkHJs6LKVsH//aDR0xcaTVVN" +
       "DVRHVvcNH3rP+BPS47/6kQMIAsRvvUC8p/mlv/+Nl77n6dd/a0/zt25Dw65N" +
       "VY5uyp9ZP/zFt5Hvbl0u2Ljfc0OjMP45yUv3545qXsw8MPMeP+mxqDw8rnx9" +
       "+m9XH/xZ9WsH0NUhdEV2rdgGfvSI7NqeYalBX3XUQIpUZQg9oDoKWdYPoftA" +
       "fmw46r6U1bRQjYbQPVZZdMUt/wcq0kAXhYruA3nD0dzjvCdFepnPPAiC7gMf" +
       "1AffO6D9X/kbQS6iu7aKSLLkGI6LcIFbyF8Y1FEkJFJDkFdArecia+D/2+9F" +
       "D3EkdOMAOCTiBhtEAl6hq/tKJEw2G9VB+EWfBLIV0qsdNZQDwwMz4LBwPO//" +
       "/5BZoYXr6aVLwEBvuwgPFphZA9dS1OCm/Erc7n7jczd/5+BkuhzpL4IOwbiH" +
       "+3EPy3EP9+Me3n5c6NKlcrjvKsbf+wKw5BZgAkDLh97N/8Do/R95/jJwQi+9" +
       "B5jhAJAidwZt8hRFhiVWysCVodc/mf7Q4h9WDqCD8+hb8AyKrhbNuQIzT7Dx" +
       "xsVZd7t+r334q3/1+U+87J7Ov3NwfgQLt7YspvXzF7UbuLKqAKA87f49z0q/" +
       "ePNXX75xAN0DsALgYyQBfwbQ8/TFMc5N7xePobKQ5V4gsOYGtmQVVcf4djXS" +
       "Azc9LSnN/nCZfwTo+MHC358D37uOJkD5W9Q+5hXpd+3dpDDaBSlKKH4f7336" +
       "P/7en9VKdR+j9rUz6yCvRi+eQYqis2slJjxy6gOzQFUB3X/+JPfjH//6h/9e" +
       "6QCA4h23G/BGkRauBUwI1PzDv+X/4Zf/6DN/cHDiNJcisFTGa8uQsxMhi3Lo" +
       "6l2EBKO985QfgDQWmHqF19yYO7arGJohrS218NL/fe0F9Bf//KPX935ggZJj" +
       "N/qeN+7gtPy729AHf+cH/8fTZTeX5GKlO9XZKdkePh877ZkIAmlX8JH90L97" +
       "+z/5gvRpAMQA/EIjV0s8OziaOAVTbwURSdmyWNQO94taUV4pTYqUNO8p08NC" +
       "HWVLqKyrFckz4dmpcX72nYlXbsof+4O/eMviL37tG6Us5wOes55AS96Le+cr" +
       "kmcz0P0TF3FgIIU6oMNeZ77/uvX6N0GPIuhRBggXsgEAo+yc3xxR33vff/qN" +
       "f/34+794GTroQVctV1J6UjkFoQeA76uhDnAs8/7uS3vTp/eD5HopKnSL8GXB" +
       "U7dOjsMjvzm8/eQo0ueK5IVbXe5OTS+o/3LJweXSPmVybMLHCohNa/Kh4tqH" +
       "RaCpOlE57Et3MWCnSF4sq7Aiee9eMvxbUsKe9snyvyvASu++MwT3iqDtFMWe" +
       "/F+stf7Qn/zPWzyhBN/bxCoX2ovIa596ivy+r5XtT1GwaP10dusqBQLc07bV" +
       "n7X/8uD5K//mALpPhK7LR9HzQrLiAltEEDGGxyE1iLDP1Z+P/vahzosnKP+2" +
       "iwh8ZtiL+Hu6OoJ8QV3kr16A3IcKLT8JvhtHrnHjolddgsoMs3esMr1RJH/7" +
       "GOHu8wIjAaHREcT9Nfi7BL7/W3xFZ0XBPpB5lDyKpp49Cac8sHBfVlStaEqc" +
       "OnDpKOwbOcrwvBjPgu+FIzFeuIMYwh3EKLLTUjd8BD3kgijCiHalQU5mwRnO" +
       "Vm+Ss2fA984jzt55B85ufiucPQgiSbALuCNj739DxsqOskvAbvdWD/HDsgPt" +
       "9kOXAPAusISF5f4LtNAMR7KOeXnCtOQbxxZdgP0YmFw3TAu/HV/8t8wXmOMP" +
       "ny4UYxfsfX70v3zsd//xO74MJuIIujcpRAfz78xqwsTFdvBHXvv42x985Ss/" +
       "Wq6+QG/cJ7rXXyp6de8mXZGYRbI9FuupQiy+DGXHUhjR5YKpKoVkd8cfLjBs" +
       "EFckR3sd5OVHv7z91Fc/u9/HXASbC8TqR175R399+NFXDs7sHt9xywbubJv9" +
       "DrJk+i1HGg6g5+42Stmi998+//K/+pmXP7zn6tHze6Eu2Op/9kv/53cPP/mV" +
       "375NgH2P5e4X7b+RYaNrLw2wcEgc/41RUROJeTYVkppKw6xan3XimcnSGN7V" +
       "27VJRgzZGaFmTVXBB12hYyCZQdbzEEdrBE7naSVNolRp60N/uiQdqmkkfbI3" +
       "1/3hIF1JywpCmfy2Z4yW4XTS7zNdsz2uD/Pe0FpMKZrvaXhN4EA3rOaRY2qt" +
       "+GAtw2u1pFWLk5rmw3gLIXpzeyd6jD2JRpv5yqf70ZxqwQwW2FOJUSSDF6Vq" +
       "p+brzVaGJNXawIvgOb5pTLeb3oThUak27lkVbz5e2J0F4RmxlPFTxotWEm9z" +
       "w8oy4o26tx5Ra7e6IUW/pyvknFmIwwXayPtUm6vyfb6Pdm3Wpj19G9HhMqUN" +
       "mmRkOx/PRxESjqoGtZ1HEjMXFZ3fiB29KtPSlIu19spkxD5T0Vee0+epvou5" +
       "PTsa2+pUmqDKQEd5RV8alD6TfLKaDWrtqbhll/26ofocXm/mNYJRKmzL628b" +
       "2E6UpIZt+WjkjruUX1OwBbVFV3bTiTxSJzMnHvaX9ogdsf2VMkxnbLBqoFS7" +
       "pbOutc0qDSaV69uNTy+nc2PUF+35kN6JEz7ydDUwmSHVZ6u4mIpBH6WWcBhG" +
       "TaTbbmBMDYFb1aoHL7e8364YqJssddYcuumS5AmBcGeTjK9UfS5b6uGGmfoh" +
       "226hvcl2oVh+UJMUb5J53W1Ekh09TuXGdjKvwB4cBsuunebznJp1tFk9XNTn" +
       "jI0YMeszBF9lAqNKbiJhZTZXS6pPrGxR3kRGvpTFaB5MVmaDoc2AZ8ZS3CZ6" +
       "+rhbnzAN2PYye8srI6LR5SnfI6o9eNfBIrK7GSsrvd2tqFLN7rp+k+EVbNtR" +
       "uu6wzrWUMWqQlEnFPDvRxf5IM4cxuRA9w4YXHBvlK7nKc0pcmRnokPDbuUm7" +
       "fsNsqnbba836keeM3HlzS6SLsDHiyA3KjZs4T2wmM2QyJeu+k9ScLAtsJkOb" +
       "S6bH5BVuQq/9yc5ouoO2H7EzNV4l680Q5Te50k3amQynTl8Rg7zGW+aQkKYB" +
       "33W6aZ1IVQGJgyWMYVO6OeDnc4ESeygj2gRL+YvWitd9ZipPZwufd/N+vN3U" +
       "0eVQ0ca7sUWP8CnTdxtsdZTtalQcbjBLUBcNLq3F5IYdRu1eTyNjaTBQ1Jm8" +
       "ZcJcm6cr3WtP1HDjqxJmYs1+q9/iyNTx2zovripTheskksS2YpaUw53eC/LB" +
       "iplNUoyeIPU4tjNF6o3XFY/YtvvKmnHXRHc+69HZsrOqmsPKdLxIBQT2OwHB" +
       "BJI29vnl2th0xS49Jugcx6kF5+qaP50QxFIaudrAmg2Dbl0xF92cimBNGK8N" +
       "LBq45LTXsMlGFck2o3Sd6vQSHuZZyDcxcZdXQpKY4cpiZiAGsVjt5lWCnHQo" +
       "a83h6wD1Uhi3hxudXFUn8rhLT/i+YvWkLdvLUzkbIpRegaNEmO3QldeZTIdd" +
       "rW13h/FiaXgSzRtdypGcMUOIE0tq2ex4I+ZW05Jjr22azUoYMEiWqdjAwtMp" +
       "Nuhtesmw5sYTR2wYmYhUYnW6rCGCAzTbintorZLDpm3qPXoYzuaSICa4DmMN" +
       "bueQa89XzbyKxqTYzoieTOTbHakQ3FZCBGbrduP1pjV1+Wy7GjAao1MzY0uw" +
       "SW+Zr9CuJg/0OhppeYuyTKMp6jEND+rJCEWQdjTop1k4wrZuJprZUu4GqTKE" +
       "VzC8TmoWwjlqbZ7zPqcsYRMfVjsoqYcdl+XXi5iksJyaLBtcns/VVrPTg+tS" +
       "DtMcReEjZtkdR7ophsPZpm5GWs3JGzVBZpN2nc6qO2IiLdhOSNmj+rzaTaLR" +
       "dNI1abmuaJOOu6D1pjnyl3a+HPLGMuaHtJ/xs/q0JgQJJcPVHm1iW7I3MFS6" +
       "btXFDRMhrdlol2HOemwudvSkK5KNWkDXFdodqC0KdxSGWkxRkkWbuODVaq1R" +
       "dROhxLgjzAOR7/hKm622pr5spzhMycse03F90UBSCvYYJbfNdlJv0DhLavoK" +
       "RUgvFHbeVrRbjl3l0UHdiWTEYToINgmFmK+K8A5NRoPpeOqFQ87OpPmuDW91" +
       "uM8aiwAkMYfjdj8X/KYcbuQJsd1tyHThNkfLkUkZ7XgdB2YlEGGkOu7oi3Z3" +
       "FBiThW/gvcXWbbbn23rWaaD6ptefN0VhrU/HHDrszyaVmrWciGaroW6FUFns" +
       "JnRmVpGWaI1mu3pdY5o4x/KYzjpidcrviF11ztbj1FkJjMOmq1zW/GWjaQTO" +
       "cCqgHZXtR6q5W+jiGJON2B51+42eL6+xiAqpgNP99WidubIAlhhzu9TGmjqp" +
       "4NWNMFhQ/aU+i1QNHmyybCU0cwxrYkzO4UnFRamsIdrKANZb2ohDaj7N4k6Q" +
       "bBsZhmWktqpwNpY1h4NafcuHMlPPwVqAC0NtXvHjbNphhFE9qW3c5qKfgp2b" +
       "MFkMG5O+t4UxczJuWKPpmGhX2+I6D7ZtU++KWN1aC+O+JlUSYWtbsMMpdKOi" +
       "1JU0JPCKweAZ00x7jRGf06Kjr3DHCprudLNBqIU2JZlErNI52hxM5yEzx0h9" +
       "pM2JRuK2J1PXM5hhI3GWjW0TMxtVb274pjJr8SK2jFFxmbDuwJnPGqIYDjQm" +
       "o1HKS7H6aCUxTUEZivVer5pmxsKZDLjxIG4sBXtuTpU5ozdrm7of+wNiuPOT" +
       "YE70lDluT3SnRRl9ZIzPVckX7YU3FohpxClCHszpNJq0MJRM/fkE8TWHrday" +
       "LUy1BU1LDGTeZLcIMUFrNrlc9QYMySXcgBMwWWWTiDJtNGMVlmmgfEOXXHWJ" +
       "dChxCZbagZCnDWONrSI1RqeVeoSPLGW7Xoqzud1X16whI2qyddS+IwgNKYyr" +
       "PSzN9KrfYZpmQo05Rm/Bo8UihKf4Bkmb4wlhNbKdulN4EC3Qi5G9GM3RWCD4" +
       "NdMQSS9NzXYcrImOt+0hBonIVm2cof6Giis+za2i9Xjd6dnsMNTrCBskoqwl" +
       "KxDoJIOwWhkoPTdc1ggsGKwdF0Y3AxQn3VzZNNFan9qSVVRrVOguiqh1bi24" +
       "rY5VYXJ0tEYaCxOswpqUDvKBgaWtzabaaRLqoJJpa0uWUBgYBxdG6Myck10Y" +
       "DwQNr3ZrbAa7ObXr+OM+Vk8ko8vgi9Zu3h8H4qLPkqN+XW1Wa7iTy4250Etd" +
       "d017I3xt+7bT8laCMHOnrWATpFaEdGi+EdQir7YK8FaLi3V5wi6MrsgHgdqY" +
       "5TUBIFGg+2me0ZOKNLCzkMHkZtasStEQ9ivkEm2Odqgm80hfcTANR3GC74/o" +
       "Hs3LLDEKUJpn+mKyqVfXTthKGT/L5zhLmQGIYfJarUqNFRmHYSHXYdHDdlg0" +
       "BBHeMvcQMeYEcdXroBVuxwn1IFnkQZ3K4HiIbkYCZWMTbT3zd01NA1ETIrXa" +
       "bAIQseOrMmkibY4X2t1JijvNdFolavCkTe14eB0hSsyucUTs7mZmvNXFuUVX" +
       "R1VLGI9pw1oEo8m8tY0VtbZ2qrsUDrQm4RDNXatJj3bpBJsuANK0LMWeJ2FY" +
       "Mds8S2fUimi05Nyme01WrK8HmLvb5o1ZNlhjHoylYw6ZpzQ3qjZIEV8qfSkZ" +
       "dMy8vuRoooPUYa5Do6GyUSJqLivURAZRNEvqLLfSGIrdNPykq2Dy1NqlZnOK" +
       "OFk/5nyL8DHYkCsJ8Ktphaq7CL0ampawQvBx0Mg0RMdpb5hW6+vKLMs6zXoD" +
       "b4pNASa1wVRTFHurzTTEiRDKU5EmlQ5q2NZatESc5NimpW8cSsZCPxMdGuu1" +
       "Eroz9HJ8tdp5FoapATKLSK29RTCwnfHqUUsF+2HRFzreZDTFmiLVJJvybkgP" +
       "hLAisfGul/W7lR43iiwYNonBDM/4TZ0La5sEn7ZleNAyZ4nrqNUKAOB14pnC" +
       "emzUm4teKu18v6LwEdWftEZjGEsqWaLZgm2xYGfE2ooWOL6RMMu2v/D1cBQG" +
       "87wybW/m9RVLUjNkoPi9bdRYxWglVZcJ1/HxAqz6HWGLdbo8V2vgfQbfbXUS" +
       "XWDabrJIZDLfWDU06qly1eHyLQA9JdkZO2Ldz7pdZZ7EcI/G0SytbTCe9nG+" +
       "05U3tkHVdttw0BKWc8ce26v+crRiGvNtgpgLqYfxjj6YIjWTrU1I1VKTwdT2" +
       "Ok7QwYdyD+kufLNO5su5W5uvNZNiyIpJNt3WLp9VuXzd9Tdrq1up2JUVs/GF" +
       "QdxXmXSnGgJiLTlCi2AMbCoJDeyY31dspT/45k4zHikPaU6unf8GxzPZ7U6U" +
       "y78r0IWryosnyk+evwB44S4XdKf3csfUz92Fmt85kZQVJx5vv9MtdXna8ZkP" +
       "vfKqwv40enB0FP2BCHogcr3vBSZSrTMsFi8y3nPnkx26vKQ/Pd79wof++1Oz" +
       "79Pf/ybu9Z65wOfFLv8F/dpv998p/9gBdPnksPeW5wPnG714/oj3aqBGceDM" +
       "zh30vv3EYo8WBiquD+pHFqtfPIc89YnbH0K+a+9Tdznp/6d3qftUkXw8gq5t" +
       "1Ii9eLx66omfeDOXA2XBj50XsTgEbh2J2PrOi/jP7lL3M0XykxH0MBCxd+Gc" +
       "9lTCn/o2JHysKPxu8L3vSML3fecl/Pm71P1CkXw2gq4ACTtHh/ankn3u25Ds" +
       "WlH4NPiII8mI74xkl/YE585Gz8/vqZSWoHFT/pXJV7746fzzr+2PPtdSqEYQ" +
       "fKdXUrc+1Cpu11+4ywuB0/czf9n/O6//2Z8ufuAYlh48UUNxUQA9fzc1HMPj" +
       "W06vHmmprPvNsq9fu4v5vlAkv7Kfg0QUBcY6jlTQuiT+9fM3jQ+/kS1+s0xO" +
       "rf8vvw3rXz+eudTRiNR31vrn5StQsLwguuNox0p++Oyd8P52/UvlQP/+Llr+" +
       "wyL5vQi6vp8khlM+NuDV6HZqvvZGQn+pTE7V/Ptv6vY0gh6//euX4ir/yVve" +
       "4e3fjsmfe/Xa/U+8Ov8P5QOQk/ddD4yh+7XYss5eK57JX/ECIGzJ8wP7S0av" +
       "/PmTCHriDkt5cbVUZkrG/3hP/1+B5i7SR9C95e9Zuq9G0NVTOtDVPnOW5GsR" +
       "dBmQFNk/927zDGF/u5pdOhMJHLlmqepH30jVJ03Ovg8pJn75DvJ4pY+5I3z5" +
       "/Ksj5gPfaPz0/n2KbEl5XvRy/xi6b/9U5iRaeO6OvR33dWXw7m8+/HMPvHAM" +
       "IQ/vGT6dJmd4e+b2j0G6theVzzfyX37iF977z1/9o/Lm7P8BWvLcvKAqAAA=");
}
