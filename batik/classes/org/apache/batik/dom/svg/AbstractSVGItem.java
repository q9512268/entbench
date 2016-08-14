package org.apache.batik.dom.svg;
public abstract class AbstractSVGItem implements org.apache.batik.dom.svg.SVGItem {
    protected org.apache.batik.dom.svg.AbstractSVGList parent;
    protected java.lang.String itemStringValue;
    protected abstract java.lang.String getStringValue();
    protected AbstractSVGItem() { super(); }
    public void setParent(org.apache.batik.dom.svg.AbstractSVGList list) {
        parent =
          list;
    }
    public org.apache.batik.dom.svg.AbstractSVGList getParent() { return parent;
    }
    protected void resetAttribute() { if (parent != null) { itemStringValue =
                                                              null;
                                                            parent.itemChanged(
                                                                     ); }
    }
    public java.lang.String getValueAsString() { if (itemStringValue == null) {
                                                     itemStringValue =
                                                       getStringValue(
                                                         );
                                                 }
                                                 return itemStringValue; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZfXBUVxW/u/kO+QZCBBJCCFQ+ugtapJ0gNqQJBDchJRTH" +
                                                              "ICxv397dfeTte4/37iabIEqZ6YD+wVCkFJ02/iEMirQwHTtalU4cxtJO1Zm2" +
                                                              "+IG11NE/RCtjGcfqiFrPufftvrdvs4vMSGbezc2955x7z7m/83Fvzt8kZZZJ" +
                                                              "2qjGAmzCoFagV2NDkmnRaI8qWdZ2GAvLT5dIf919Y/AhPykfIXUJyRqQJYv2" +
                                                              "KVSNWiOkVdEsJmkytQYpjSLHkEktao5JTNG1ETJXsfqThqrIChvQoxQJdkhm" +
                                                              "iDRKjJlKJMVovy2AkdYQ7CTIdxLs9k53hUiNrBsTDnmLi7zHNYOUSWcti5GG" +
                                                              "0F5pTAqmmKIGQ4rFutImWWno6kRc1VmApllgr7rWNsGW0No8E3RcrP/g9rFE" +
                                                              "AzfBbEnTdMbVs7ZRS1fHaDRE6p3RXpUmrX3kC6QkRGa5iBnpDGUWDcKiQVg0" +
                                                              "o61DBbuvpVoq2aNzdVhGUrkh44YYWZwrxJBMKWmLGeJ7BgmVzNadM4O27Vlt" +
                                                              "hZZ5Kj61Mnji6d0NL5SQ+hFSr2jDuB0ZNsFgkREwKE1GqGl1R6M0OkIaNTjs" +
                                                              "YWoqkqpM2ifdZClxTWIpOP6MWXAwZVCTr+nYCs4RdDNTMtPNrHoxDij7r7KY" +
                                                              "KsVB12ZHV6FhH46DgtUKbMyMSYA7m6V0VNGijCzycmR17Pw0EABrRZKyhJ5d" +
                                                              "qlSTYIA0CYiokhYPDgP0tDiQlukAQJOR+QWFoq0NSR6V4jSMiPTQDYkpoKri" +
                                                              "hkAWRuZ6ybgkOKX5nlNync/NwfVH92ubNT/xwZ6jVFZx/7OAqc3DtI3GqEnB" +
                                                              "DwRjzYrQSan50hE/IUA810MsaL77+VsPr2qbflXQLJiBZmtkL5VZWD4dqXtj" +
                                                              "Yc/yh0pwG5WGbil4+Dmacy8bsme60gZEmOasRJwMZCant73y2YPn6Ht+Ut1P" +
                                                              "ymVdTSUBR42ynjQUlZqbqEZNidFoP6miWrSHz/eTCuiHFI2K0a2xmEVZPylV" +
                                                              "+VC5zv8GE8VABJqoGvqKFtMzfUNiCd5PG4SQBvjIg/AtIOKH/2ZkZzChJ2lQ" +
                                                              "kiVN0fTgkKmj/lYQIk4EbJsIRgD1o0FLT5kAwaBuxoMS4CBB7YmongxaY/Fg" +
                                                              "dwSALslseMemfkaTAQSZcW/Fp1G72eM+Hxh+odftVfCYzboapWZYPpHa2Hvr" +
                                                              "+fDrAlLoBrZdGPkorBgQKwb4igFYMQArBjwrEp+PLzQHVxanC2czCl4OYbZm" +
                                                              "+fCuLXuOdJQArIzxUjAsknbkpJseJxRk4ndYvtBUO7n4+prLflIaIk2wWkpS" +
                                                              "MXt0m3GIS/Ko7bo1EUhETj5od+UDTGSmLtMohKNCecGWUqmPURPHGZnjkpDJ" +
                                                              "VuiXwcK5Ysb9k+lT44/v+OJqP/HnpgBcsgyiF7IPYeDOBuhOr+vPJLf+8I0P" +
                                                              "Lpw8oDtBICenZFJhHifq0OGFgtc8YXlFu/Ri+NKBTm72KgjSTAKngvjX5l0j" +
                                                              "J8Z0ZeI16lIJCsd0MympOJWxcTVLmPq4M8Ix2sj7cwAWdeh0rfCttr2Q/8bZ" +
                                                              "ZgPbeQLTiDOPFjwffHLYePZXP/vjx7m5M6mj3pXzhynrcoUrFNbEA1OjA9vt" +
                                                              "JqVA986poa88dfPwTo5ZoFgy04Kd2PZAmIIjBDM/8eq+a+9eP33V7+CckSrD" +
                                                              "1Bk4NY2ms3riFKktoicsuMzZEkQ8FSQgcDof0wCiSkyRIipF3/pX/dI1L/75" +
                                                              "aIOAggojGSSturMAZ/wjG8nB13f/vY2L8cmYcR2zOWQijM92JHebpjSB+0g/" +
                                                              "/mbrV69Iz0JCgCBsKZOUx1XCzUD4ua3l+q/m7QOeuXXYLLXc+M91MVdlFJaP" +
                                                              "XX2/dsf7L9/iu80trdzHPSAZXQJh2CxLg/h53vi0WbISQPfA9ODnGtTp2yBx" +
                                                              "BCTKEG2trSaEx3QOOGzqsopf/+hy8543Soi/j1SruhTtk7ifkSoAOLUSEFnT" +
                                                              "xqceFoc7XplJMGmSp3zeABp40cxH15s0GDf25PfmfWf92anrHGiGkLGA8/sx" +
                                                              "2OcEVl6gO7597q11Pz/75MlxkeKXFw5oHr6Wf25VI4d+9488k/NQNkP54eEf" +
                                                              "CZ5/Zn7Phvc4vxNTkLsznZ+gIC47vB87l/ybv6P8x35SMUIaZLsg3iGpKfTU" +
                                                              "ESgCrUyVDEVzznxuQSeql65szFzojWeuZb3RzEmM0Edq7NfOFMCWwtduO3a7" +
                                                              "N4D5CO/0c5b7sFmZHxYKcTOo/iWIt+Iy0PI/5ueQHRRmc64HsdkiMNNVEKI9" +
                                                              "+Sotsze1rIBK24qqVIgbPFaB+kGU2vzIMro1cCfAcwuIWY8Ow0V0EFP38XYF" +
                                                              "NvcL70ADpiJwC2WkUrIt5IRl/lPvLQLdYdlxNF9mm+0Fj8AujTDstBYq6Pll" +
                                                              "5PShE1PRrWfWCJ9syi2Se+EO+Nwv/v2TwKnfvjZDhVbFdON+lY5R1bU5vM23" +
                                                              "5kSBAX7XcVzqnbrjv3+pM77xbiorHGu7Q+2Efy8CJVYUDizerVw59Kf52zck" +
                                                              "9txFkbTIY06vyG8NnH9t0zL5uJ9f7ISv510Ic5m6cj282qRwg9W25/j5kixS" +
                                                              "2hAYq+BbaSNlpdcpHLDmoxC7AWx2e0qC5iISiyRPs8gc93xQvy5OmcvJcPQz" +
                                                              "ji8l7xQPiqcsHOg2+Hgiq9EsnAvCt87WaN1d2MiH3V0e81QXEeYxgc+RMsjX" +
                                                              "OVjERoewmQRfghvjkIivRVPjkKkkoYAcs2/WwQNN744+c+M54b7ePOghpkdO" +
                                                              "fPnDwNETwpXFW8WSvOcCN494r+AbbRD2+BB+fPD9Bz/UAgfwN2S7HvvS3J69" +
                                                              "NWOBYJLFxbbFl+j7w4UDP/jmgcN+2yqwsdIxXYk6KNl/D1DCQ2wnfBvsg91Q" +
                                                              "BCXYHMjHRCHWIkd+ssjcKWyeBDjEM3DgMHLscPwe2IGn2SXw9dnK9N3BDjPk" +
                                                              "2EKsRXT9RpG5M9hMQejAh1yWfYjF0cOOMb5+D4zRhHMd8D1qa/To3YOiEGsR" +
                                                              "hS8WmXsBm29DVQKg4BG023KqElckPf//MEcaqiLPAwteC1ryHm/Fg6P8/FR9" +
                                                              "5bypx37Js3n2UbAG8nIsparuwtXVLzdMGlO4cjWijDX4r+8z0lKopmGkBFq+" +
                                                              "7ZcE9SVG5sxEDZTQuimnwXheSkbK+G833WVGqh06qNhEx03yCkgHEuxeMWao" +
                                                              "F0Wdn/a5SiLb2PyM5t7pjLIs7ns/pgH+yJ4pOlLimT0sX5jaMrj/1ifOiHcH" +
                                                              "WZUmJ1HKrBCpEE8g2cJlcUFpGVnlm5ffrrtYtTQThRvFhh28L3CBshtSnIHI" +
                                                              "mO+5kVud2Yv5tdPrX/7pkfI3IeHsJD6Jkdk7829EaSMFFePOkFMzuv5Jw58K" +
                                                              "upZ/bWLDqthf3uZ3TiKe8BYWpg/LV8/ueut4y+k2P5nVT8ogwdA0v6o9MqFt" +
                                                              "o/KYOUJqFas3DVsEKYqk9pPKlKbsS9H+aIjUIYgl9C9uF9uctdlRfLVipCM/" +
                                                              "cea/9cH9fJyaG/WUFkUxtVBkOiM5r/+2Y1SnDMPD4Ixkj3JOvu5h+ZEv1f/w" +
                                                              "WFNJHzhijjpu8RVWKpKtK93/EOADIs9jcySN5wxID4cGDCOT4ssXGgLx1wQN" +
                                                              "jjPiW2GPemqf33Bxb/MuNtf/C+CCLC3rGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "777uN575an5x8b9j4B+8fSYAAA==");
}
