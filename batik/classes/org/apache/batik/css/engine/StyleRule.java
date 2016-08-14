package org.apache.batik.css.engine;
public class StyleRule implements org.apache.batik.css.engine.Rule {
    public static final short TYPE = (short) 0;
    protected org.w3c.css.sac.SelectorList selectorList;
    protected org.apache.batik.css.engine.StyleDeclaration styleDeclaration;
    public short getType() { return TYPE; }
    public void setSelectorList(org.w3c.css.sac.SelectorList sl) { selectorList =
                                                                     sl;
    }
    public org.w3c.css.sac.SelectorList getSelectorList() { return selectorList;
    }
    public void setStyleDeclaration(org.apache.batik.css.engine.StyleDeclaration sd) {
        styleDeclaration =
          sd;
    }
    public org.apache.batik.css.engine.StyleDeclaration getStyleDeclaration() {
        return styleDeclaration;
    }
    public java.lang.String toString(org.apache.batik.css.engine.CSSEngine eng) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        if (selectorList !=
              null) {
            sb.
              append(
                selectorList.
                  item(
                    0));
            for (int i =
                   1;
                 i <
                   selectorList.
                   getLength(
                     );
                 i++) {
                sb.
                  append(
                    ", ");
                sb.
                  append(
                    selectorList.
                      item(
                        i));
            }
        }
        sb.
          append(
            " {\n");
        if (styleDeclaration !=
              null) {
            sb.
              append(
                styleDeclaration.
                  toString(
                    eng));
        }
        sb.
          append(
            "}\n");
        return sb.
          toString(
            );
    }
    public StyleRule() { super(); }
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
      ("H4sIAAAAAAAAALV6e+ws113f3Gvf60cc32s7D9fEju3chDhrfrM7+5hdOSGZ" +
       "fc7szuzM7sy+BsjN7Lzf79mZCYYQqU3aSCECBwIFV4ggIApJQE1btaUyICCI" +
       "hwRCvAQkahHl0Ujkj9KqaUvPzP5+v/39fr73upbNSnv27Dnfc873832d75wz" +
       "n/86dCUMoIrnWplqudGRnEZHhtU8ijJPDo/GZJMRglCWepYQhhxouyk+/aVr" +
       "f//NT2nXL0NXeegRwXHcSIh01wnncuhaiSyR0LVD68CS7TCCrpOGkAhwHOkW" +
       "TOph9BwJveHM0Ai6QZ6wAAMWYMACXLIAYwcqMOiNshPbvWKE4EShD30PdImE" +
       "rnpiwV4EPXV+Ek8IBPt4GqZEAGa4t/i/BKDKwWkAPXmKfY/5ZYA/XYFf+OEP" +
       "Xv+Fu6BrPHRNd9iCHREwEYFFeOgBW7a3chBikiRLPPSQI8sSKwe6YOl5yTcP" +
       "PRzqqiNEcSCfCqlojD05KNc8SO4BscAWxGLkBqfwFF22pJN/VxRLUAHWtxyw" +
       "7hEOi3YA8H4dMBYogiifDLnb1B0pgt5+ccQpxhsTQACG3mPLkeaeLnW3I4AG" +
       "6OG97izBUWE2CnRHBaRX3BisEkGP3XbSQtaeIJqCKt+MoEcv0jH7LkB1XymI" +
       "YkgEvfkiWTkT0NJjF7R0Rj9fn773kx92cOdyybMki1bB/71g0BMXBs1lRQ5k" +
       "R5T3Ax94D/lDwlt+8eOXIQgQv/kC8Z7m3373Nz7w7BMvfWVP8y23oKG3hixG" +
       "N8XPbh/83bf1nuncVbBxr+eGeqH8c8hL82eOe55LPeB5bzmdseg8Oul8af5r" +
       "m498Tv7by9D9BHRVdK3YBnb0kOjanm7JwUh25ECIZImA7pMdqVf2E9A9oE7q" +
       "jrxvpRUllCMCutsqm6665X8gIgVMUYjoHlDXHcU9qXtCpJX11IMg6B7whd4F" +
       "vo9D+0/5G0FrWHNtGRZEwdEdF2YCt8AfwrITbYFsNXgLrN6EQzcOgAnCbqDC" +
       "ArADTT7uEMOCVgU8AWvKLHkeW/JRYWHeP+LcaYHr+u7SJSDyt110eAv4Cu5a" +
       "khzcFF+Iu4NvfOHmb14+dYBjiUTQO8FyR/vljsrljsByR/vljk6Xgy5dKld5" +
       "U7HsXqlAJSZwbhD2HniG/a7xhz7+9F3Amrzd3UCeBSl8++jbO4QDogx6IrBJ" +
       "6KXP7L5v+b3Vy9Dl82G0YBU03V8MZ4rgdxrkblx0n1vNe+1jf/X3X/yh592D" +
       "I52Ly8f+/fKRhX8+fVGogSvKEoh4h+nf86Tw5Zu/+PyNy9DdwOlBoIsEIDkQ" +
       "Q564uMY5P33uJOYVWK4AwIob2IJVdJ0EqvsjLXB3h5ZS2w+W9YeAjL8VOi7O" +
       "WXLR+4hXlG/aW0ehtAsoypj6Ptb78T/6nb+ul+I+Cb/XzmxorBw9d8bli8mu" +
       "lc790MEGuECWAd2ffYb5wU9//WPfURoAoHjHrRa8UZQ94OpAhUDM//Qr/h9/" +
       "9c8/+/uXD0YTgT0v3lq6mO5B/gP4XALf/1t8C3BFw95dH+4dx4wnT4OGV6z8" +
       "rgNvIHxYwM0KC7qxcGxX0hVd2FpyYbH/+9o7a1/+b5+8vrcJC7ScmNSzrzzB" +
       "of2fdKGP/OYH/8cT5TSXxGL7OsjvQLaPiY8cZsaCQMgKPtLv+73Hf+TXhR8H" +
       "0RVEtFDP5TJIQaU8oFKB1VIWlbKEL/QhRfH28KwjnPe1M2nGTfFTv/93b1z+" +
       "3X/6Rsnt+TzlrN4pwXtub2pF8WQKpn/rRa/HhVADdI2Xpt953Xrpm2BGHswo" +
       "gugV0gGIOOk5KzmmvnLPn/zSr7zlQ797F3R5CN1vuYI0FEqHg+4Dli6HGghW" +
       "qff+D+yteXcvKK6XUKGXgd8byKPlv6uAwWduH2uGRZpxcNdH/xdtbT/6n//n" +
       "y4RQRplb7K4XxvPw53/ssd63/205/uDuxegn0pdHYZCSHcYin7P/++Wnr/7q" +
       "ZegeHrouHud7S8GKCyfiQY4TniSBICc8138+X9lvzs+dhrO3XQw1Z5a9GGgO" +
       "0R/UC+qifv+F2PJoIeUj8H36OLY8fTG2lLvBtVLHBUtHrOYGkUahjzQ+9Cdz" +
       "IBwWupIUjAOZXD9QTeMiqfxnn//042944WufKF1/P+0HyqWfKssbRfGtpW7v" +
       "KqrvBnEhLLPTCEDRHcEquX0mgu7mNszgzupnAt0G8Ss5To7g5x/+qvljf/Vz" +
       "+8Tnoq4vEMsff+Ff/MPRJ1+4fCbdfMfLMr6zY/YpZ8neG0seC+956k6rlCOG" +
       "//WLz/+Hn3n+Y3uuHj6fPA3As8HP/cH/+a2jz3ztN26xf18JC8nvQ31R1osC" +
       "2ztI67bO9Nypqh8sWt99sp+c/J5TNVRWuFurCETt+7zAjYBBytKJYh4I5SL2" +
       "uUER5MoRbwZWWmQau7pYJhihIB6xZ4guAFi8SgBV8H32GMCztwHwwdsAKKrr" +
       "E86vh0XK0wduVWxTJ4EBcP/sK+ZJZwZdQHPzFdHsjeUSEOYV5Ag9qhb/1Tv5" +
       "RFGMigI/4fythiXeONkWl+DRDfBxw7DQEwBn3HD/vHOByWf+v5kENv3gYTLS" +
       "BY9On/iLT/3W97/jq8A+xyeOX1D3gHiX//zn0a8Vf7xXh+exAg9b5sSkEEZU" +
       "uf/K0imk8RmmpyAWWO5rgBRdey/eCAns5EMueWW1W6TpSqErFAMTo2lltlO6" +
       "bqZpnFY3B5hGuSss3DDjEZvT7sYc2yTSibfxMJFqltRuVGaIyVldwVmyujUb" +
       "aYMKFk10UyeqJu/VeoLFeiGjLWc6sUC4idazgoVHLgja96ylx3Yq2/q23omx" +
       "jukvDaG9NuyEU5Jk7eQyAo+8VoUVTcrhlnON4ARzwTILd4vJM05yk2F11Z9Q" +
       "6zQJhuO2P0gQpJnQaExMHJdApqwaDaKeuo2siSpO4YCQBmZqT3pEbajhwnzX" +
       "lJ25v8Br2GY88TvjwdiMRsuaPR9bQ70+8iUiHOIzAmHD3ViNU25CSZbZG41N" +
       "GVvUe+sxs2OTTnXV4Ba67yLNcZeRvFE9RoQZFSMhz/XZwdS0+5ih9ceMKQ5m" +
       "2WoYrcaoFPhGtrCGi5VrmStE3ySRle2mAdHId+tp3lnCilODfXeEbsaZOukF" +
       "RlMzt/4En2D5TCaUNS0QElVtb+i2sWSH+qBG2uPRSicR1x5uplhGItGmtZx0" +
       "O/hykbXWwtJuT0N2vhJ0zE2pMAzm3WmVWCHjljxoqY2Zz0cObYu4YHNWwLFJ" +
       "zvXTqgwb6qAWgue4ttFZI+bamug+0SBYo7vxsLbIRlTqa2HQqA8ENJsaQ8kI" +
       "J9OFNeN5ZGUkkjDQxvMVxiM4uiU5fVMVDLpWn7e7SkhEscmbgtXKg92gnxlB" +
       "AE8GZI/r1lybDgRh6HAq3bV40h3r8qDXj8kxP0eAyPJQpZiqQqfeFlWx7mbS" +
       "oReexIkLn1pgM55wU1MPfczc1QYEwy7GHr3wu5M+nY1ZfRbha1vvxsPmpIpn" +
       "DDvvSAan4kuBbhD8aGiqXoViG2PJjsntWFIq6yFS307bMb+psmMMn9GL5nCk" +
       "rBJM2Nh4hxrZPtbS1lOVira0ke5W46DRxnuzgd5TGvoAEYZop4Xy6MoLpond" +
       "n3O9Ti80EMQg4nBttJWRM4ZXTAzHlMUarEVNe5yibHIT5rn6igN2gjVY3h7T" +
       "hJkN0XacjWpps13psp2Bzi3Xwry3pJfUKB67wUS3pwvbrgQ14BcBJpAZaUz4" +
       "STKuM1JzOGkNRFPjfaOVUmMVJWLKDOxZuvDhNBItDJu3JmO/NYgms2CN2mGX" +
       "TcbwstcbLdvjUbM9qDpNFYZzUe03eFbw7GF32J2PFyLVid0AGSFDzOkajam2" +
       "omfSPOmnkT93xVl/ErUoPcXwCetO2YHAjsOBw/YEzWZbBMtwg4GwkdTI4juj" +
       "WNzQXYzU2nYCY1m9u6r5WubQQacR4pTvNoMcFmB+tuFwtU8CD6FUedlrOoSW" +
       "WDvCUmM+ayyzrDnE1Ek7wz2xNk1XCN8Pxa3ZXyOOM89Xcb1vyOsZN/fUFoM5" +
       "VUNAKTNDZ40eQvYlstkEKgqbrQrZWzam5pKYVXs6Sfb6hG3wy9Yg7hL1UUtC" +
       "pu6m2W07fTGtejOcWqOuXzV0dUEOq5uB7S1U2TVimjJwaRyOqQUeSrv2fD5f" +
       "4J2sExoqkcZwoncJ1ULNNFuT2JadJTMlpV2FJJUGt65qMSyhpNNsN5NhVMuD" +
       "hmNJKk8RbW67MpC0gSuMUtfhsdPrwdUERVBtq7WnCLUbIKMMS9gtPNKarrCd" +
       "aiMb8TCX4nyvseLHWaYs8+kicFstIt9hXYTMZ7N8aYwGCuZlGtPJlnjiRyhc" +
       "adfqolnfZD4uWW1Ws7ZsA5vZoyk+Cka0hvN+jZpI3bbUUhzZFSJ0Cg93XSLg" +
       "tTkf7rZApZiEdPO8YXASouB9r5EMyBkrD0YrTuWw3cRmszqv7KYVzME6Nbg9" +
       "6M93O4xlUmdD7lZbmxjkfZAntWJ1tMnWfYBAE1ALGN9kNRhTc1OPFacOL/Nh" +
       "gO5a28ZIRCNrRI4MT1nbmJenSE2Yax1YaLttm9Q36sYY12BantkztZN7o/Yi" +
       "koeENDMqbRWtojAcJ9hi06+rfoZHXneX9RQRb8zjhs1EOrZqryuysNr0GVyk" +
       "5EYn1Zu616yISmWYV1xESbaTqdCKIsTL0Hpcd8kVv1hxMabnSHdF1HDVwJGN" +
       "KUQenbkUZTK1XjTY7Ba9YVSVolq/r5B8C+2GeLYLsBgTWvUFlgk7x+rlfjt0" +
       "GQXG/XRSd7KqvjNrHOlr/WTIAANqUVrVt+eYk08FPYkpZbEJiImtKnG/iZvu" +
       "dtetbxZbDZZrhNDIk4xqKRwTpKHH4GQyAaFxxy9yCx4tJpUuMmyqckNsW0xC" +
       "Ok7SxEWm33Q9xWqmPMOknIKuZcNGms0p3IyrZIrOes2NzCRZp12J9UUnXq5p" +
       "st0nQ0Mywxqz2PVn/bgieZ0x3M/5NdzziEkSESqiLtNuOKQ3jBOrlcmMomPT" +
       "H7qdMEUB3Fy2HVKVxSqD9ppWsu7bHiW7G3iBTOA8lbtmnSJmClVb9ftbdNPs" +
       "OVndryQtjZ2MPVbit/7aGMdVacNMG93c9edtrLvAnXzWWNJhtsKXcBtmtRa3" +
       "wBm4gdTrPIcO/UpnmMt5SNu12a6PgoGL0XrX9pDuhCf0bGqLrpGvxt5yZo2H" +
       "82QGIxKuclN9OxR6vD3DJ8uq2mtgNT6SVwqzdEYNTxYZ3upLS7ff9cbJTmKM" +
       "1JA7Cd1WtAQLOKkFR+xQyjSDS1iNmiIEt0PHG2LptSsNEF0sdKMkSkb5mzZM" +
       "OfUBGK9GSGvQ0arVjSS0GTGnJ5W+xNCb6c5XpGA4CUQCpZlmnYcl2pGA90ar" +
       "oFoLCUmcLtGmocD0XGy1k9G2K/qpqDLGGBNX6nLXnEposJ3SZm0DL2EkhTc1" +
       "0+EZIl54y7nXrfKItq6nTs8yNzbIp2CRbWaNyM37GsUTm35DNXg7DJfIJF/X" +
       "7FmvCjJsNhB3g3rXlGGBoquwFIFAbSRjzMOnNCdVeT+mDB2e0i2ygbrsRrM9" +
       "kJ3p/sQ1RIccAV/Pwu1OSgaJuRSqmj4ZuXpbc/j1ZLDUW1jQWbIeuiIsLqIm" +
       "6GjedqteGtYItTGyOiDUkVk62zK7oVrzkpVfQW18N2rpCyrvbvm+2tjlBrpz" +
       "Gi6bSfLS3U2Q3JiSrU2+7uXputpIJE2xeTpAnQaJNyoaRao1IQ3nTk+bOALO" +
       "EZJLjoN85i+alE3WlRxBM5Y32huxwtRIUrSWBGpVG0OD44TGssKIFE3Dud6i" +
       "1+vmet2BU4uN4aw23czr3Y5dIXNzCDt9NJomdSNaM92+yaU1uxNGKJEMsmjt" +
       "pK7lO+SECtZAVM4sxkJxPlF2cYQNDdeo75wWbmxQeDJS1otxTSOHTZmymkGr" +
       "n3OYYS2cyZZcwQ2T62xyEa35a3LaTTeegqfzOrD3qeEoLcvKoslcbg02PnAO" +
       "FQdKq+W+mS1Fcc5uZ7Vub9ScD+E1UPZ43W9Ppb7JiPiy58Qx7ezINcaRTWrm" +
       "L6VN5Dc2MR9PQn672/kmK7bklJ4NZNZxOylTD2SawqPMc0VSREmeas0rrenG" +
       "z4cqImBsHUm1QSTvYr7Z1eM+u/NMc0TTq3qz2uvssr6s9Nr4chs5K6beqw9X" +
       "g2gDiyFYo6O16yD/Jie7+W4jGs2s0503vZQ0vTazFPhkRdd7zBA8teC6h3gs" +
       "2hhFpmzg2xy38o6yc+Bks6Zpk/Vt24aDyMnXAHltN683OwncN5em26tPGMsx" +
       "+o6X15W0n6PLZrtjaR2wxRgdFGayRl+s1N1ozMwHc28rSdXuOqmSnLAg9XEk" +
       "CNPqJF+S6CCbzoAoGNSWHE2w2lWZa2o8vtNwcztx8SUHa3i76csDe0fCqCCg" +
       "+UAHIUkmba1az+arWV/ngJfOgrDn2ClnbsXhcmEFDAj1SAOZo9ZqmjNbS8Xb" +
       "SkdAuCWZJhm83HYazcgQpG0cK7I9qMg7fI7kDufNWQwVV+36IAVPGdRED6aW" +
       "tUr5CK1RYmXq2NO1Pm46c1SKmSGhNhOTq885hW4ac9MJ6Uql3wgtRcb9ZqOL" +
       "ND27qmFYn9tYDDwwp4tsgXdjPeaU3O+OmlinulVoGR8Gsp0YAdrKtwwJTzk2" +
       "outZR6ZBplOf0ZyRi0N2UV1PNopuIdsm0lZ8YrXoD2dKlbEIZzSv8YvuyGQJ" +
       "MowVf6qvaVf1mSG8mjTDrFHXY7hr9DmnXk/ydWcU8OvVrOUnC6M7Bklatxng" +
       "wxHKBOtF7tlTqo43iKwRJG5v6g9CVN0ONvWKueowYdphs0nqwlkw7PlsPopX" +
       "8I40Zt22UfH8tOtV5w3wsPy+9xWP0R9+dY/3D5XHFad3teCpvuiwXsUT/L7r" +
       "qaJ45+lpUPm5eodbkTMnx5dOjkaevNPZTnH9VRzjPX67u9ryCO+zH33hRYn+" +
       "qdrl46N5OoLui1zv2yw5ka0Lp9Xvuf1xJVVeVR+OjH/9o3/zGPft2odexaXY" +
       "2y/weXHKn6U+/xujd4k/cBm66/QA+WWX6OcHPXf+2Pj+QI7iwOHOHR4/fqqC" +
       "Ug3FCXLtWAW1iwdyByXf+jTu3XsjucPNxw/eoe/TRfHJCLpHlaMTHqmDSX3/" +
       "Kx0KnZ2vbPjEKbQ3nJw1to+htV8faJcOBHxJ8K/ugO8niuJHI+haKEfsxXPW" +
       "i6diiatLB+z/8jVgL+8EisPh9x9jf//rr9Yv3KHvS0XxswC2eh52KbQDxM+9" +
       "VvUWKh0eQxy+7uoVS4J/fwec/7EovhxBjxTqvcW58k8esP6b14D1bUVj0U8d" +
       "Y6Vef3X+2h36vlIUvwRgqreGKR5g/vJrgPlw0fgY+HLHMLnXVaUnO8gd36Lo" +
       "seygrJUz/d4dhPIHRfHbEXRv5B7O6K2DJH7n1UgiBVvQ6QscxQ30oy97J2z/" +
       "HpP4hRev3fvWFxd/WL7DcPqu0X0kdK8SW9bZC8Mz9ateICt6yfZ9++tDr/z5" +
       "swj6ljtII4Ku7islv3+6H/O1CHrTrcZE0F2gPEv5XyLo+kXKCLpS/p6l+8sI" +
       "uv9ABxbdV86S/DWYHZAU1b/xbnFLsr9lTS+d2b2PzavUxcOvpIvTIWdfiCh2" +
       "/PINvpPdOd6/w3dT/OKL4+mHv9H6qf0LGcAX8ryY5V4Sumf/bsjpDv/UbWc7" +
       "mesq/sw3H/zSfe88yUYe3DN8MPUzvL391m88DGwvKt9RyP/dW//1e3/6xT8v" +
       "b2v/H2koyipaKQAA");
}
